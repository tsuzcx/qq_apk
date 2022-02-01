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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.e.b.b;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Set;

public class FavSelectUI
  extends FavBaseUI
{
  private View.OnClickListener cEO;
  private String qfj;
  private com.tencent.mm.plugin.fav.ui.a.b qfk;
  private Set<Integer> qfl;
  private k qfm;
  private String toUser;
  
  public FavSelectUI()
  {
    AppMethodBeat.i(106877);
    this.qfk = null;
    this.qfl = new HashSet();
    this.qfm = new k();
    this.cEO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106876);
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_preset_search_type", i);
        paramAnonymousView.putExtra("key_to_user", FavSelectUI.b(FavSelectUI.this));
        paramAnonymousView.putExtra("key_fav_item_id", FavSelectUI.c(FavSelectUI.this));
        paramAnonymousView.putExtra("key_search_type", 1);
        paramAnonymousView.putExtra("key_enter_fav_search_from", 1);
        p.b(FavSelectUI.this.getContext(), FavSelectUI.a(FavSelectUI.this).qgS, paramAnonymousView);
        AppMethodBeat.o(106876);
      }
    };
    AppMethodBeat.o(106877);
  }
  
  public final com.tencent.mm.plugin.fav.ui.a.a ciI()
  {
    AppMethodBeat.i(106880);
    if (this.qfk == null)
    {
      getContext();
      this.qfk = new com.tencent.mm.plugin.fav.ui.a.b(this.qcI, false);
    }
    com.tencent.mm.plugin.fav.ui.a.b localb = this.qfk;
    AppMethodBeat.o(106880);
    return localb;
  }
  
  protected final void ciJ() {}
  
  protected final boolean ciK()
  {
    AppMethodBeat.i(106881);
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().getCount() > 0)
    {
      AppMethodBeat.o(106881);
      return true;
    }
    AppMethodBeat.o(106881);
    return false;
  }
  
  protected final void ciL()
  {
    AppMethodBeat.i(106882);
    this.qcD.setCompoundDrawablesWithIntrinsicBounds(0, 2131232274, 0, 0);
    this.qcD.setCompoundDrawablePadding(com.tencent.mm.cd.a.fromDPToPix(getContext(), 10));
    this.qcD.setText(2131758878);
    AppMethodBeat.o(106882);
  }
  
  protected final View.OnClickListener ciM()
  {
    return this.cEO;
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
    this.qfj = getIntent().getStringExtra("key_fav_item_id");
    if (this.qfj != null)
    {
      paramBundle = this.qfj.split(",");
      int j = paramBundle.length;
      int i = 0;
      while (i < j)
      {
        int k = bt.getInt(paramBundle[i], 2147483647);
        if (2147483647 != k) {
          this.qfl.add(Integer.valueOf(k));
        }
        i += 1;
      }
    }
    this.qfl.remove(Integer.valueOf(3));
    this.qfk.f(this.qfl);
    this.qfm.qaf = false;
    this.qfm.qag = false;
    this.qfk.a(this.qfm);
    this.pXi.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106870);
        FavSelectUI.a(FavSelectUI.this).cjq();
        FavSelectUI.this.ciN();
        AppMethodBeat.o(106870);
      }
    });
    addIconOptionMenu(0, 2131689494, new MenuItem.OnMenuItemClickListener()
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
    setMMTitle(2131758998);
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
    if (this.qfk != null) {
      this.qfk.finish();
    }
    AppMethodBeat.o(106884);
  }
  
  public void onItemClick(final AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(106879);
    paramAdapterView = (b.b)paramView.getTag();
    if (paramAdapterView == null)
    {
      ad.w("MicroMsg.FavSelectUI", "on item click, holder is null");
      AppMethodBeat.o(106879);
      return;
    }
    if (paramAdapterView.qaS == null)
    {
      ad.w("MicroMsg.FavSelectUI", "on item click, info is null");
      AppMethodBeat.o(106879);
      return;
    }
    paramView = paramAdapterView.qaS;
    com.tencent.mm.plugin.fav.a.h.i(paramView.field_localId, 1, 1);
    if ((paramView.field_type == 19) && (c.a(paramView.field_favProto.DhR)))
    {
      com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131755132));
      AppMethodBeat.o(106879);
      return;
    }
    if (paramView.field_type == 3)
    {
      com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131755011));
      AppMethodBeat.o(106879);
      return;
    }
    if ((paramView.field_type == 8) && (w.sE(this.toUser)))
    {
      com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131755009));
      AppMethodBeat.o(106879);
      return;
    }
    paramInt = 2131758864;
    if (paramView.field_type == 18) {
      paramInt = 2131758863;
    }
    paramLong = paramView.field_datatotalsize;
    ad.i("MicroMsg.FavSelectUI", "fav total size:%s", new Object[] { Long.valueOf(paramLong) });
    if (paramLong > com.tencent.mm.m.b.YM())
    {
      com.tencent.mm.ui.widget.snackbar.b.n(this, getString(paramInt, new Object[] { bt.mK(com.tencent.mm.m.b.YM()) }));
      AppMethodBeat.o(106879);
      return;
    }
    ((ab)com.tencent.mm.kernel.g.ab(ab.class)).a(getContext(), this.toUser, paramAdapterView.qaS, true, new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(106875);
        FavSelectUI.this.hideVKB();
        if (paramAnonymousBoolean)
        {
          final com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(FavSelectUI.this.getContext(), FavSelectUI.this.getString(2131758906), false, null);
          l.a(FavSelectUI.this.getContext(), FavSelectUI.b(FavSelectUI.this), paramAnonymousString, paramAdapterView.qaS, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(106874);
              if (localp != null) {
                localp.dismiss();
              }
              com.tencent.mm.ui.widget.snackbar.b.n(FavSelectUI.this, FavSelectUI.this.getString(2131758834));
              aq.n(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSelectUI
 * JD-Core Version:    0.7.0.1
 */