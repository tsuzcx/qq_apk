package com.tencent.mm.plugin.fav.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.b.b;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import java.util.HashSet;
import java.util.Set;

public class FavSelectUI
  extends FavBaseUI
{
  private String Aio;
  private com.tencent.mm.plugin.fav.ui.adapter.b Aip;
  private Set<Integer> Aiq;
  private com.tencent.mm.plugin.fav.a.k Air;
  private View.OnClickListener fhU;
  private String toUser;
  
  public FavSelectUI()
  {
    AppMethodBeat.i(106877);
    this.Aip = null;
    this.Aiq = new HashSet();
    this.Air = new com.tencent.mm.plugin.fav.a.k();
    this.fhU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106876);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/FavSelectUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_preset_search_type", i);
        paramAnonymousView.putExtra("key_to_user", FavSelectUI.b(FavSelectUI.this));
        paramAnonymousView.putExtra("key_fav_item_id", FavSelectUI.c(FavSelectUI.this));
        paramAnonymousView.putExtra("key_search_type", 1);
        paramAnonymousView.putExtra("key_enter_fav_search_from", 1);
        o.b(FavSelectUI.this.getContext(), FavSelectUI.a(FavSelectUI.this).Ake, paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSelectUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(106876);
      }
    };
    AppMethodBeat.o(106877);
  }
  
  public final com.tencent.mm.plugin.fav.ui.adapter.a dRv()
  {
    AppMethodBeat.i(106880);
    if (this.Aip == null)
    {
      getContext();
      this.Aip = new com.tencent.mm.plugin.fav.ui.adapter.b(this.AfM, false);
    }
    com.tencent.mm.plugin.fav.ui.adapter.b localb = this.Aip;
    AppMethodBeat.o(106880);
    return localb;
  }
  
  protected final void dRw() {}
  
  protected final boolean dRx()
  {
    AppMethodBeat.i(106881);
    if (((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().getCount() > 0)
    {
      AppMethodBeat.o(106881);
      return true;
    }
    AppMethodBeat.o(106881);
    return false;
  }
  
  protected final void dRy()
  {
    AppMethodBeat.i(106882);
    this.njO.setCompoundDrawablesWithIntrinsicBounds(0, q.d.favorites_empty_favorites_icon, 0, 0);
    this.njO.setCompoundDrawablePadding(com.tencent.mm.cd.a.fromDPToPix(getContext(), 10));
    this.njO.setText(q.i.favorite_empty_fav);
    AppMethodBeat.o(106882);
  }
  
  protected final View.OnClickListener dRz()
  {
    return this.fhU;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(106883);
    if ((paramInt1 == 0) && (-1 == paramInt2))
    {
      finish();
      AppMethodBeat.o(106883);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(106883);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106878);
    super.onCreate(paramBundle);
    this.toUser = getIntent().getStringExtra("key_to_user");
    this.Aio = getIntent().getStringExtra("key_fav_item_id");
    if (this.Aio != null)
    {
      paramBundle = this.Aio.split(",");
      int j = paramBundle.length;
      int i = 0;
      while (i < j)
      {
        int k = Util.getInt(paramBundle[i], 2147483647);
        if (2147483647 != k) {
          this.Aiq.add(Integer.valueOf(k));
        }
        i += 1;
      }
    }
    this.Aiq.remove(Integer.valueOf(3));
    this.Aip.r(this.Aiq);
    this.Air.AcS = false;
    this.Air.AcT = false;
    this.Aip.a(this.Air);
    this.workerHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106870);
        FavSelectUI.a(FavSelectUI.this).dSj();
        FavSelectUI.this.dRA();
        AppMethodBeat.o(106870);
      }
    });
    addIconOptionMenu(0, q.h.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(106871);
        paramAnonymousMenuItem = new Intent();
        FavSelectUI.a(FavSelectUI.this, paramAnonymousMenuItem);
        AppMethodBeat.o(106871);
        return true;
      }
    });
    setMMTitle(q.i.favorite_select_title);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(106872);
        FavSelectUI.this.finish();
        AppMethodBeat.o(106872);
        return true;
      }
    });
    AppMethodBeat.o(106878);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106884);
    super.onDestroy();
    AppMethodBeat.o(106884);
  }
  
  public void onItemClick(final AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(106879);
    paramAdapterView = (b.b)paramView.getTag();
    if (paramAdapterView == null)
    {
      Log.w("MicroMsg.FavSelectUI", "on item click, holder is null");
      AppMethodBeat.o(106879);
      return;
    }
    if (paramAdapterView.AdF == null)
    {
      Log.w("MicroMsg.FavSelectUI", "on item click, info is null");
      AppMethodBeat.o(106879);
      return;
    }
    paramView = paramAdapterView.AdF;
    int i = this.AfH.getHeaderViewsCount();
    com.tencent.mm.plugin.fav.a.h.b(paramView.field_localId, 1, 1, paramInt - i - 1);
    if ((paramView.field_type == 19) && (b.a(paramView.field_favProto.ZAw)))
    {
      com.tencent.mm.ui.widget.snackbar.b.u(this, getString(q.i.Fav_AppBrand_CannotForward));
      AppMethodBeat.o(106879);
      return;
    }
    if ((paramView.field_type == 5) && (m.a(paramView.field_favProto.ZAj)))
    {
      com.tencent.mm.ui.widget.snackbar.b.u(this, getString(q.i.Fav_WebPage_CannotForward));
      AppMethodBeat.o(106879);
      return;
    }
    if (paramView.field_type == 3)
    {
      com.tencent.mm.ui.widget.snackbar.b.u(this, getString(q.i.Fav_Voice_CannotForward));
      AppMethodBeat.o(106879);
      return;
    }
    if ((paramView.field_type == 8) && (ab.IS(this.toUser)))
    {
      com.tencent.mm.ui.widget.snackbar.b.u(this, getString(q.i.Fav_File_CannotForward));
      AppMethodBeat.o(106879);
      return;
    }
    paramInt = q.i.favorite_detail_illegal_send_record_too_big;
    paramLong = c.aRn();
    if (paramView.field_type == 18)
    {
      paramInt = q.i.favorite_detail_illegal_send_note_too_big;
      paramLong = c.aRo();
    }
    long l = paramView.field_datatotalsize;
    Log.i("MicroMsg.FavSelectUI", "fav total size:%s, limitSize:%s", new Object[] { Long.valueOf(l), Long.valueOf(paramLong) });
    if (l > paramLong)
    {
      com.tencent.mm.ui.widget.snackbar.b.u(this, getString(paramInt, new Object[] { Util.getSizeKB(paramLong) }));
      AppMethodBeat.o(106879);
      return;
    }
    ((ad)com.tencent.mm.kernel.h.ax(ad.class)).a(getContext(), this.toUser, paramAdapterView.AdF, q.i.app_send, true, new y.a()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(106875);
        FavSelectUI.this.hideVKB();
        if (paramAnonymousBoolean)
        {
          final w localw = com.tencent.mm.ui.base.k.a(FavSelectUI.this.getContext(), FavSelectUI.this.getString(q.i.favorite_forward_tips), false, null);
          l.a(FavSelectUI.this.getContext(), FavSelectUI.b(FavSelectUI.this), paramAnonymousString, paramAdapterView.AdF, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(106874);
              if (localw != null) {
                localw.dismiss();
              }
              com.tencent.mm.ui.widget.snackbar.b.u(FavSelectUI.this, FavSelectUI.this.getString(q.i.fav_finish_sent));
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(106873);
                  FavSelectUI.this.finish();
                  AppMethodBeat.o(106873);
                }
              }, 1800L);
              AppMethodBeat.o(106874);
            }
          });
        }
        AppMethodBeat.o(106875);
      }
    });
    AppMethodBeat.o(106879);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSelectUI
 * JD-Core Version:    0.7.0.1
 */