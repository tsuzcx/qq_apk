package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
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
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.d.b.b;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.q;
import java.util.HashSet;
import java.util.Set;

public class FavSelectUI
  extends FavBaseUI
{
  private View.OnClickListener dec;
  private String tfB;
  private com.tencent.mm.plugin.fav.ui.a.b tfC;
  private Set<Integer> tfD;
  private k tfE;
  private String toUser;
  
  public FavSelectUI()
  {
    AppMethodBeat.i(106877);
    this.tfC = null;
    this.tfD = new HashSet();
    this.tfE = new k();
    this.dec = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106876);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/FavSelectUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_preset_search_type", i);
        paramAnonymousView.putExtra("key_to_user", FavSelectUI.b(FavSelectUI.this));
        paramAnonymousView.putExtra("key_fav_item_id", FavSelectUI.c(FavSelectUI.this));
        paramAnonymousView.putExtra("key_search_type", 1);
        paramAnonymousView.putExtra("key_enter_fav_search_from", 1);
        p.b(FavSelectUI.this.getContext(), FavSelectUI.a(FavSelectUI.this).thl, paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavSelectUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(106876);
      }
    };
    AppMethodBeat.o(106877);
  }
  
  protected final void cVA() {}
  
  protected final boolean cVB()
  {
    AppMethodBeat.i(106881);
    if (((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().getCount() > 0)
    {
      AppMethodBeat.o(106881);
      return true;
    }
    AppMethodBeat.o(106881);
    return false;
  }
  
  protected final void cVC()
  {
    AppMethodBeat.i(106882);
    this.hSx.setCompoundDrawablesWithIntrinsicBounds(0, 2131232388, 0, 0);
    this.hSx.setCompoundDrawablePadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 10));
    this.hSx.setText(2131759202);
    AppMethodBeat.o(106882);
  }
  
  protected final View.OnClickListener cVD()
  {
    return this.dec;
  }
  
  public final com.tencent.mm.plugin.fav.ui.a.a cVz()
  {
    AppMethodBeat.i(106880);
    if (this.tfC == null)
    {
      getContext();
      this.tfC = new com.tencent.mm.plugin.fav.ui.a.b(this.tdg, false);
    }
    com.tencent.mm.plugin.fav.ui.a.b localb = this.tfC;
    AppMethodBeat.o(106880);
    return localb;
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
    this.tfB = getIntent().getStringExtra("key_fav_item_id");
    if (this.tfB != null)
    {
      paramBundle = this.tfB.split(",");
      int j = paramBundle.length;
      int i = 0;
      while (i < j)
      {
        int k = Util.getInt(paramBundle[i], 2147483647);
        if (2147483647 != k) {
          this.tfD.add(Integer.valueOf(k));
        }
        i += 1;
      }
    }
    this.tfD.remove(Integer.valueOf(3));
    this.tfC.k(this.tfD);
    this.tfE.taE = false;
    this.tfE.taF = false;
    this.tfC.a(this.tfE);
    this.workerHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106870);
        FavSelectUI.a(FavSelectUI.this).cWm();
        FavSelectUI.this.cVE();
        AppMethodBeat.o(106870);
      }
    });
    addIconOptionMenu(0, 2131689496, new MenuItem.OnMenuItemClickListener()
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
    setMMTitle(2131759323);
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
    if (this.tfC != null) {
      this.tfC.finish();
    }
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
    if (paramAdapterView.tbr == null)
    {
      Log.w("MicroMsg.FavSelectUI", "on item click, info is null");
      AppMethodBeat.o(106879);
      return;
    }
    paramView = paramAdapterView.tbr;
    int i = this.tdb.getHeaderViewsCount();
    com.tencent.mm.plugin.fav.a.h.b(paramView.field_localId, 1, 1, paramInt - i - 1);
    if ((paramView.field_type == 19) && (c.a(paramView.field_favProto.Lxf)))
    {
      com.tencent.mm.ui.widget.snackbar.b.r(this, getString(2131755009));
      AppMethodBeat.o(106879);
      return;
    }
    if (paramView.field_type == 3)
    {
      com.tencent.mm.ui.widget.snackbar.b.r(this, getString(2131755012));
      AppMethodBeat.o(106879);
      return;
    }
    if ((paramView.field_type == 8) && (com.tencent.mm.model.ab.IT(this.toUser)))
    {
      com.tencent.mm.ui.widget.snackbar.b.r(this, getString(2131755010));
      AppMethodBeat.o(106879);
      return;
    }
    paramInt = 2131759187;
    if (paramView.field_type == 18) {
      paramInt = 2131759186;
    }
    paramLong = paramView.field_datatotalsize;
    Log.i("MicroMsg.FavSelectUI", "fav total size:%s", new Object[] { Long.valueOf(paramLong) });
    if (paramLong > com.tencent.mm.n.c.aqu())
    {
      com.tencent.mm.ui.widget.snackbar.b.r(this, getString(paramInt, new Object[] { Util.getSizeKB(com.tencent.mm.n.c.aqu()) }));
      AppMethodBeat.o(106879);
      return;
    }
    ((com.tencent.mm.plugin.fav.a.ab)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fav.a.ab.class)).a(getContext(), this.toUser, paramAdapterView.tbr, true, new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(106875);
        FavSelectUI.this.hideVKB();
        if (paramAnonymousBoolean)
        {
          final q localq = com.tencent.mm.ui.base.h.a(FavSelectUI.this.getContext(), FavSelectUI.this.getString(2131759230), false, null);
          l.a(FavSelectUI.this.getContext(), FavSelectUI.b(FavSelectUI.this), paramAnonymousString, paramAdapterView.tbr, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(106874);
              if (localq != null) {
                localq.dismiss();
              }
              com.tencent.mm.ui.widget.snackbar.b.r(FavSelectUI.this, FavSelectUI.this.getString(2131759157));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSelectUI
 * JD-Core Version:    0.7.0.1
 */