package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.c;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.a.e;

public class FavoriteTextDetailUI
  extends BaseFavDetailReportUI
{
  private static final int tjb;
  private com.tencent.mm.ui.tools.l contextMenuHelper;
  private com.tencent.mm.plugin.fav.a.g tcP;
  private long tiR;
  private TextView tjc;
  private com.tencent.mm.plugin.fav.a.g tjd;
  private o.g tje;
  
  static
  {
    AppMethodBeat.i(107254);
    tjb = c.aql();
    AppMethodBeat.o(107254);
  }
  
  public FavoriteTextDetailUI()
  {
    AppMethodBeat.i(107244);
    this.tje = new o.g()
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
          if ((FavoriteTextDetailUI.a(FavoriteTextDetailUI.this) != null) && (FavoriteTextDetailUI.a(FavoriteTextDetailUI.this).field_favProto != null))
          {
            ClipboardHelper.setText(FavoriteTextDetailUI.a(FavoriteTextDetailUI.this).field_favProto.desc);
            com.tencent.mm.ui.base.h.cD(FavoriteTextDetailUI.this.getContext(), FavoriteTextDetailUI.this.getContext().getString(2131755773));
          }
        }
      }
    };
    AppMethodBeat.o(107244);
  }
  
  private void cWE()
  {
    AppMethodBeat.i(107250);
    this.tcP = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(this.tiR);
    H(this.tcP);
    if ((this.tcP == null) || (this.tcP.field_favProto == null))
    {
      Log.w("MicroMsg.FavoriteTextDetailUI", "id[%d] info is null, return", new Object[] { Long.valueOf(this.tiR) });
      AppMethodBeat.o(107250);
      return;
    }
    a.a(this, this.tcP);
    if ((this.tjd != null) && (this.tjd.field_edittime == this.tcP.field_edittime))
    {
      Log.w("MicroMsg.FavoriteTextDetailUI", "not change, return");
      AppMethodBeat.o(107250);
      return;
    }
    this.tjd = this.tcP;
    this.tjc.setText(this.tcP.field_favProto.desc);
    com.tencent.mm.pluginsdk.ui.span.l.a(this.tjc, 1, 3, t.grX(), com.tencent.mm.pluginsdk.ui.span.l.Krf);
    AppMethodBeat.o(107250);
  }
  
  protected final MMLoadScrollView cWr()
  {
    AppMethodBeat.i(107245);
    MMLoadScrollView localMMLoadScrollView = (MMLoadScrollView)findViewById(2131307339);
    AppMethodBeat.o(107245);
    return localMMLoadScrollView;
  }
  
  public int getLayoutId()
  {
    return 2131494163;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(107252);
    if ((1 == paramInt1) && (-1 == paramInt2))
    {
      com.tencent.mm.ui.base.h.cD(getContext(), getString(2131755971));
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107243);
          FavoriteTextDetailUI.c(FavoriteTextDetailUI.this);
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
    this.tjc = ((TextView)findViewById(2131298292));
    this.tiR = getIntent().getLongExtra("key_detail_info_id", -1L);
    com.tencent.mm.pluginsdk.wallet.h.setPayChannel(5);
    this.contextMenuHelper = new com.tencent.mm.ui.tools.l(getContext());
    this.contextMenuHelper.a(this.tjc, this, this.tje);
    setMMTitle(getString(2131759179));
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
    addIconOptionMenu(0, 2131766795, 2131690843, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(107241);
        paramAnonymousMenuItem = new e(FavoriteTextDetailUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.HLX = new o.f()
        {
          public final void onCreateMMMenu(m paramAnonymous2m)
          {
            AppMethodBeat.i(107237);
            if (FavoriteTextDetailUI.this.getIntent().getBooleanExtra("key_detail_can_share_to_friend", true)) {
              paramAnonymous2m.d(2, FavoriteTextDetailUI.this.getString(2131759326));
            }
            paramAnonymous2m.d(0, FavoriteTextDetailUI.this.getString(2131759197));
            paramAnonymous2m.d(1, FavoriteTextDetailUI.this.getString(2131759313));
            paramAnonymous2m.d(3, FavoriteTextDetailUI.this.getString(2131759199));
            paramAnonymous2m.d(4, FavoriteTextDetailUI.this.getString(2131755778));
            AppMethodBeat.o(107237);
          }
        };
        paramAnonymousMenuItem.HLY = new o.g()
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
                paramAnonymous2MenuItem.putExtra("key_max_count", FavoriteTextDetailUI.tjb);
                paramAnonymous2MenuItem.putExtra("key_show_confirm", true);
                paramAnonymous2MenuItem.putExtra("key_fav_item_id", FavoriteTextDetailUI.a(FavoriteTextDetailUI.this).field_id);
                b.a(FavoriteTextDetailUI.this, ".ui.FavTextEditUI", paramAnonymous2MenuItem, 1);
                paramAnonymous2MenuItem = FavoriteTextDetailUI.this.thD;
                paramAnonymous2MenuItem.tat += 1;
                AppMethodBeat.o(107240);
                return;
                j.a(FavoriteTextDetailUI.this, FavoriteTextDetailUI.b(FavoriteTextDetailUI.this), FavoriteTextDetailUI.this.thD);
                AppMethodBeat.o(107240);
                return;
                if ((FavoriteTextDetailUI.a(FavoriteTextDetailUI.this) != null) && (FavoriteTextDetailUI.a(FavoriteTextDetailUI.this).field_favProto != null))
                {
                  paramAnonymous2MenuItem = FavoriteTextDetailUI.this.thD;
                  paramAnonymous2MenuItem.tar += 1;
                  b.c(FavoriteTextDetailUI.a(FavoriteTextDetailUI.this).field_favProto.desc, FavoriteTextDetailUI.this);
                  com.tencent.mm.plugin.fav.a.h.w(FavoriteTextDetailUI.a(FavoriteTextDetailUI.this).field_localId, 1);
                  AppMethodBeat.o(107240);
                  return;
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
                  paramAnonymous2MenuItem.putExtra("key_fav_item_id", FavoriteTextDetailUI.a(FavoriteTextDetailUI.this).field_localId);
                  b.b(FavoriteTextDetailUI.this.getContext(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
                  paramAnonymous2MenuItem = FavoriteTextDetailUI.this.thD;
                  paramAnonymous2MenuItem.tau += 1;
                  AppMethodBeat.o(107240);
                  return;
                  com.tencent.mm.ui.base.h.a(FavoriteTextDetailUI.this.getContext(), FavoriteTextDetailUI.this.getString(2131755780), "", new DialogInterface.OnClickListener()
                  {
                    public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(107239);
                      paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.a(FavoriteTextDetailUI.this.getContext(), FavoriteTextDetailUI.this.getString(2131755780), false, null);
                      b.b(FavoriteTextDetailUI.b(FavoriteTextDetailUI.this), new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(107238);
                          FavoriteTextDetailUI.this.thD.tav = true;
                          paramAnonymous3DialogInterface.dismiss();
                          Log.d("MicroMsg.FavoriteTextDetailUI", "do del, local id %d", new Object[] { Long.valueOf(FavoriteTextDetailUI.b(FavoriteTextDetailUI.this)) });
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
        paramAnonymousMenuItem.dGm();
        AppMethodBeat.o(107241);
        return true;
      }
    });
    AppMethodBeat.o(107246);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(107251);
    paramContextMenu.add(0, 1, 0, getString(2131755772));
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
    cWE();
    AppMethodBeat.o(107248);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI
 * JD-Core Version:    0.7.0.1
 */