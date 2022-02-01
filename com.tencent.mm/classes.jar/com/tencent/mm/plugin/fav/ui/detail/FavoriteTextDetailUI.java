package com.tencent.mm.plugin.fav.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.c;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.h;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.x;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.a.f;

public class FavoriteTextDetailUI
  extends BaseFavDetailReportUI
{
  private static final int AlU;
  private g Afv;
  private long AlK;
  private TextView AlV;
  private g AlW;
  private u.i AlX;
  private l contextMenuHelper;
  
  static
  {
    AppMethodBeat.i(107254);
    AlU = c.aRe();
    AppMethodBeat.o(107254);
  }
  
  public FavoriteTextDetailUI()
  {
    AppMethodBeat.i(107244);
    this.AlX = new u.i()
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
            k.cZ(FavoriteTextDetailUI.this.getContext(), FavoriteTextDetailUI.this.getContext().getString(q.i.app_copy_ok));
          }
        }
      }
    };
    AppMethodBeat.o(107244);
  }
  
  private void dSB()
  {
    AppMethodBeat.i(107250);
    this.Afv = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(this.AlK);
    H(this.Afv);
    if ((this.Afv == null) || (this.Afv.field_favProto == null))
    {
      Log.w("MicroMsg.FavoriteTextDetailUI", "id[%d] info is null, return", new Object[] { Long.valueOf(this.AlK) });
      AppMethodBeat.o(107250);
      return;
    }
    a.a(this, this.Afv);
    if ((this.AlW != null) && (this.AlW.field_edittime == this.Afv.field_edittime))
    {
      Log.w("MicroMsg.FavoriteTextDetailUI", "not change, return");
      AppMethodBeat.o(107250);
      return;
    }
    this.AlW = this.Afv;
    this.AlV.setText(this.Afv.field_favProto.desc);
    p.a(this.AlV, 1, 3, x.iNN(), p.YoF, true, false);
    AppMethodBeat.o(107250);
  }
  
  protected final MMLoadScrollView dSo()
  {
    AppMethodBeat.i(107245);
    MMLoadScrollView localMMLoadScrollView = (MMLoadScrollView)findViewById(q.e.scroll_view);
    AppMethodBeat.o(107245);
    return localMMLoadScrollView;
  }
  
  public int getLayoutId()
  {
    return q.f.favorite_text_detail_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(107252);
    if ((1 == paramInt1) && (-1 == paramInt2))
    {
      k.cZ(getContext(), getString(q.i.app_saved));
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
    this.AlV = ((TextView)findViewById(q.e.chat_fav_text_tv));
    this.AlK = getIntent().getLongExtra("key_detail_info_id", -1L);
    com.tencent.mm.pluginsdk.wallet.h.setPayChannel(5);
    this.contextMenuHelper = new l(getContext());
    this.contextMenuHelper.a(this.AlV, this, this.AlX);
    setMMTitle(getString(q.i.favorite_detail));
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
    addIconOptionMenu(0, q.i.top_item_desc_more, q.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(107241);
        paramAnonymousMenuItem = new f(FavoriteTextDetailUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.Vtg = new u.g()
        {
          public final void onCreateMMMenu(s paramAnonymous2s)
          {
            AppMethodBeat.i(107237);
            if (FavoriteTextDetailUI.this.getIntent().getBooleanExtra("key_detail_can_share_to_friend", true)) {
              paramAnonymous2s.c(2, FavoriteTextDetailUI.this.getString(q.i.favorite_share_with_friend));
            }
            paramAnonymous2s.c(0, FavoriteTextDetailUI.this.getString(q.i.favorite_edit_menu));
            paramAnonymous2s.c(1, FavoriteTextDetailUI.this.getString(q.i.favorite_save_as_note));
            paramAnonymous2s.c(3, FavoriteTextDetailUI.this.getString(q.i.favorite_edit_tag_tips));
            paramAnonymous2s.c(4, FavoriteTextDetailUI.this.getString(q.i.app_delete));
            AppMethodBeat.o(107237);
          }
        };
        paramAnonymousMenuItem.GAC = new u.i()
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
                paramAnonymous2MenuItem.putExtra("key_max_count", FavoriteTextDetailUI.AlU);
                paramAnonymous2MenuItem.putExtra("key_show_confirm", true);
                paramAnonymous2MenuItem.putExtra("key_fav_item_id", FavoriteTextDetailUI.a(FavoriteTextDetailUI.this).field_id);
                b.a(FavoriteTextDetailUI.this, ".ui.FavTextEditUI", paramAnonymous2MenuItem, 1);
                paramAnonymous2MenuItem = FavoriteTextDetailUI.this.Akw;
                paramAnonymous2MenuItem.AcF += 1;
                AppMethodBeat.o(107240);
                return;
                j.a(FavoriteTextDetailUI.this, FavoriteTextDetailUI.b(FavoriteTextDetailUI.this), FavoriteTextDetailUI.this.Akw);
                AppMethodBeat.o(107240);
                return;
                if ((FavoriteTextDetailUI.a(FavoriteTextDetailUI.this) != null) && (FavoriteTextDetailUI.a(FavoriteTextDetailUI.this).field_favProto != null))
                {
                  paramAnonymous2MenuItem = FavoriteTextDetailUI.this.Akw;
                  paramAnonymous2MenuItem.AcD += 1;
                  b.d(FavoriteTextDetailUI.a(FavoriteTextDetailUI.this).field_favProto.desc, FavoriteTextDetailUI.this);
                  com.tencent.mm.plugin.fav.a.h.I(FavoriteTextDetailUI.a(FavoriteTextDetailUI.this).field_localId, 1);
                  AppMethodBeat.o(107240);
                  return;
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
                  paramAnonymous2MenuItem.putExtra("key_fav_item_id", FavoriteTextDetailUI.a(FavoriteTextDetailUI.this).field_localId);
                  b.b(FavoriteTextDetailUI.this.getContext(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
                  paramAnonymous2MenuItem = FavoriteTextDetailUI.this.Akw;
                  paramAnonymous2MenuItem.AcG += 1;
                  AppMethodBeat.o(107240);
                  return;
                  k.a(FavoriteTextDetailUI.this.getContext(), FavoriteTextDetailUI.this.getString(q.i.app_delete_tips), "", new DialogInterface.OnClickListener()
                  {
                    public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AppMethodBeat.i(107239);
                      paramAnonymous3DialogInterface = k.a(FavoriteTextDetailUI.this.getContext(), FavoriteTextDetailUI.this.getString(q.i.app_delete_tips), false, null);
                      b.b(FavoriteTextDetailUI.b(FavoriteTextDetailUI.this), new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(107238);
                          FavoriteTextDetailUI.this.Akw.AcH = true;
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
        paramAnonymousMenuItem.dDn();
        AppMethodBeat.o(107241);
        return true;
      }
    });
    AppMethodBeat.o(107246);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(107251);
    paramContextMenu.add(0, 1, 0, getString(q.i.app_copy));
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
    dSB();
    AppMethodBeat.o(107248);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI
 * JD-Core Version:    0.7.0.1
 */