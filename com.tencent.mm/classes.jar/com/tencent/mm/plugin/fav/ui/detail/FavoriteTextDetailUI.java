package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.a.e;

public class FavoriteTextDetailUI
  extends BaseFavDetailReportUI
{
  private static final int qiC;
  private com.tencent.mm.ui.tools.l contextMenuHelper;
  private com.tencent.mm.plugin.fav.a.g qcq;
  private TextView qiD;
  private ClipboardManager qiE;
  private com.tencent.mm.plugin.fav.a.g qiF;
  private n.d qiG;
  private long qis;
  
  static
  {
    AppMethodBeat.i(107254);
    qiC = com.tencent.mm.m.b.YG();
    AppMethodBeat.o(107254);
  }
  
  public FavoriteTextDetailUI()
  {
    AppMethodBeat.i(107244);
    this.qiG = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(107242);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(107242);
          return;
          if ((FavoriteTextDetailUI.c(FavoriteTextDetailUI.this) != null) && (FavoriteTextDetailUI.a(FavoriteTextDetailUI.this) != null) && (FavoriteTextDetailUI.a(FavoriteTextDetailUI.this).field_favProto != null))
          {
            FavoriteTextDetailUI.c(FavoriteTextDetailUI.this).setText(FavoriteTextDetailUI.a(FavoriteTextDetailUI.this).field_favProto.desc);
            com.tencent.mm.ui.base.h.cf(FavoriteTextDetailUI.this.getContext(), FavoriteTextDetailUI.this.getContext().getString(2131755702));
          }
        }
      }
    };
    AppMethodBeat.o(107244);
  }
  
  private void cjI()
  {
    AppMethodBeat.i(107250);
    this.qcq = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(this.qis);
    H(this.qcq);
    if ((this.qcq == null) || (this.qcq.field_favProto == null))
    {
      ad.w("MicroMsg.FavoriteTextDetailUI", "id[%d] info is null, return", new Object[] { Long.valueOf(this.qis) });
      AppMethodBeat.o(107250);
      return;
    }
    a.a(this, this.qcq);
    if ((this.qiF != null) && (this.qiF.field_edittime == this.qcq.field_edittime))
    {
      ad.w("MicroMsg.FavoriteTextDetailUI", "not change, return");
      AppMethodBeat.o(107250);
      return;
    }
    this.qiF = this.qcq;
    this.qiD.setText(this.qcq.field_favProto.desc);
    k.m(this.qiD, 1);
    AppMethodBeat.o(107250);
  }
  
  protected final MMLoadScrollView cjv()
  {
    AppMethodBeat.i(107245);
    MMLoadScrollView localMMLoadScrollView = (MMLoadScrollView)findViewById(2131304376);
    AppMethodBeat.o(107245);
    return localMMLoadScrollView;
  }
  
  public int getLayoutId()
  {
    return 2131493993;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(107252);
    if ((1 == paramInt1) && (-1 == paramInt2))
    {
      com.tencent.mm.ui.base.h.cf(getContext(), getString(2131755881));
      new ap().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107243);
          FavoriteTextDetailUI.d(FavoriteTextDetailUI.this);
          AppMethodBeat.o(107243);
        }
      }, 250L);
      AppMethodBeat.o(107252);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(107252);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107246);
    super.onCreate(paramBundle);
    this.qiD = ((TextView)findViewById(2131297956));
    this.qiE = ((ClipboardManager)aj.getContext().getSystemService("clipboard"));
    this.qis = getIntent().getLongExtra("key_detail_info_id", -1L);
    com.tencent.mm.pluginsdk.wallet.h.Vs(5);
    this.contextMenuHelper = new com.tencent.mm.ui.tools.l(getContext());
    this.contextMenuHelper.a(this.qiD, this, this.qiG);
    setMMTitle(getString(2131758856));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(107236);
        FavoriteTextDetailUI.this.finish();
        AppMethodBeat.o(107236);
        return true;
      }
    });
    addIconOptionMenu(0, 2131764451, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(107241);
        paramAnonymousMenuItem = new e(FavoriteTextDetailUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.HrX = new n.c()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(107237);
            if (FavoriteTextDetailUI.this.getIntent().getBooleanExtra("key_detail_can_share_to_friend", true)) {
              paramAnonymous2l.c(2, FavoriteTextDetailUI.this.getString(2131759001));
            }
            paramAnonymous2l.c(0, FavoriteTextDetailUI.this.getString(2131758873));
            paramAnonymous2l.c(1, FavoriteTextDetailUI.this.getString(2131758988));
            paramAnonymous2l.c(3, FavoriteTextDetailUI.this.getString(2131758875));
            paramAnonymous2l.c(4, FavoriteTextDetailUI.this.getString(2131755707));
            AppMethodBeat.o(107237);
          }
        };
        paramAnonymousMenuItem.HrY = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(107240);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(107240);
              return;
              if ((FavoriteTextDetailUI.a(FavoriteTextDetailUI.this) != null) && (FavoriteTextDetailUI.a(FavoriteTextDetailUI.this).field_favProto != null))
              {
                paramAnonymous2MenuItem = new Intent();
                paramAnonymous2MenuItem.putExtra("key_value", FavoriteTextDetailUI.a(FavoriteTextDetailUI.this).field_favProto.desc);
                paramAnonymous2MenuItem.putExtra("key_max_count", FavoriteTextDetailUI.qiC);
                paramAnonymous2MenuItem.putExtra("key_show_confirm", true);
                paramAnonymous2MenuItem.putExtra("key_fav_item_id", FavoriteTextDetailUI.a(FavoriteTextDetailUI.this).field_id);
                com.tencent.mm.plugin.fav.a.b.a(FavoriteTextDetailUI.this, ".ui.FavTextEditUI", paramAnonymous2MenuItem, 1);
                paramAnonymous2MenuItem = FavoriteTextDetailUI.this.qhk;
                paramAnonymous2MenuItem.pZT += 1;
                AppMethodBeat.o(107240);
                return;
                j.a(FavoriteTextDetailUI.this, FavoriteTextDetailUI.b(FavoriteTextDetailUI.this), FavoriteTextDetailUI.this.qhk);
                AppMethodBeat.o(107240);
                return;
                if ((FavoriteTextDetailUI.a(FavoriteTextDetailUI.this) != null) && (FavoriteTextDetailUI.a(FavoriteTextDetailUI.this).field_favProto != null))
                {
                  paramAnonymous2MenuItem = FavoriteTextDetailUI.this.qhk;
                  paramAnonymous2MenuItem.pZR += 1;
                  com.tencent.mm.plugin.fav.a.b.c(FavoriteTextDetailUI.a(FavoriteTextDetailUI.this).field_favProto.desc, FavoriteTextDetailUI.this);
                  com.tencent.mm.plugin.fav.a.h.i(FavoriteTextDetailUI.a(FavoriteTextDetailUI.this).field_localId, 1, 0);
                  AppMethodBeat.o(107240);
                  return;
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
                  paramAnonymous2MenuItem.putExtra("key_fav_item_id", FavoriteTextDetailUI.a(FavoriteTextDetailUI.this).field_localId);
                  com.tencent.mm.plugin.fav.a.b.b(FavoriteTextDetailUI.this.getContext(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
                  paramAnonymous2MenuItem = FavoriteTextDetailUI.this.qhk;
                  paramAnonymous2MenuItem.pZU += 1;
                  AppMethodBeat.o(107240);
                  return;
                  com.tencent.mm.ui.base.h.a(FavoriteTextDetailUI.this.getContext(), FavoriteTextDetailUI.this.getString(2131755709), "", new DialogInterface.OnClickListener()
                  {
                    public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(107239);
                      paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.b(FavoriteTextDetailUI.this.getContext(), FavoriteTextDetailUI.this.getString(2131755709), false, null);
                      com.tencent.mm.plugin.fav.a.b.a(FavoriteTextDetailUI.b(FavoriteTextDetailUI.this), new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(107238);
                          FavoriteTextDetailUI.this.qhk.pZV = true;
                          paramAnonymous3DialogInterface.dismiss();
                          ad.d("MicroMsg.FavoriteTextDetailUI", "do del, local id %d", new Object[] { Long.valueOf(FavoriteTextDetailUI.b(FavoriteTextDetailUI.this)) });
                          FavoriteTextDetailUI.this.finish();
                          AppMethodBeat.o(107238);
                        }
                      });
                      AppMethodBeat.o(107239);
                    }
                  }, null);
                }
              }
            }
          }
        };
        paramAnonymousMenuItem.csG();
        AppMethodBeat.o(107241);
        return true;
      }
    });
    AppMethodBeat.o(107246);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(107251);
    paramContextMenu.add(0, 1, 0, getString(2131755701));
    AppMethodBeat.o(107251);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107247);
    super.onDestroy();
    AppMethodBeat.o(107247);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(107249);
    super.onPause();
    AppMethodBeat.o(107249);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107248);
    super.onResume();
    cjI();
    AppMethodBeat.o(107248);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI
 * JD-Core Version:    0.7.0.1
 */