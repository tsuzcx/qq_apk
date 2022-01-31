package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.m.b;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMLoadScrollView;

public class FavoriteTextDetailUI
  extends BaseFavDetailReportUI
{
  private static final int kgl = ;
  private com.tencent.mm.ui.tools.j contextMenuHelper;
  private com.tencent.mm.plugin.fav.a.g kfH;
  private long kgb;
  private TextView kgm;
  private ClipboardManager kgn;
  private com.tencent.mm.plugin.fav.a.g kgo;
  private com.tencent.mm.ui.base.n.d kgp = new FavoriteTextDetailUI.3(this);
  
  private void aRN()
  {
    this.kfH = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(this.kgb);
    E(this.kfH);
    if ((this.kfH == null) || (this.kfH.field_favProto == null))
    {
      y.w("MicroMsg.FavoriteTextDetailUI", "id[%d] info is null, return", new Object[] { Long.valueOf(this.kgb) });
      return;
    }
    a.a(this, this.kfH);
    if ((this.kgo != null) && (this.kgo.field_edittime == this.kfH.field_edittime))
    {
      y.w("MicroMsg.FavoriteTextDetailUI", "not change, return");
      return;
    }
    this.kgo = this.kfH;
    this.kgm.setText(this.kfH.field_favProto.desc);
    com.tencent.mm.pluginsdk.ui.d.j.h(this.kgm, 1);
  }
  
  protected final MMLoadScrollView aRE()
  {
    return (MMLoadScrollView)findViewById(n.e.scroll_view);
  }
  
  protected final int getLayoutId()
  {
    return n.f.favorite_text_detail_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((1 == paramInt1) && (-1 == paramInt2))
    {
      h.bC(this.mController.uMN, getString(n.i.app_saved));
      new ah().postDelayed(new FavoriteTextDetailUI.4(this), 250L);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.kgm = ((TextView)findViewById(n.e.chat_fav_text_tv));
    this.kgn = ((ClipboardManager)getSystemService("clipboard"));
    this.kgb = getIntent().getLongExtra("key_detail_info_id", -1L);
    i.Ez(5);
    this.contextMenuHelper = new com.tencent.mm.ui.tools.j(this.mController.uMN);
    this.contextMenuHelper.a(this.kgm, this, this.kgp);
    setMMTitle(getString(n.i.favorite_detail));
    setBackBtn(new FavoriteTextDetailUI.1(this));
    addIconOptionMenu(0, n.i.top_item_desc_more, com.tencent.mm.plugin.fav.ui.n.d.mm_title_btn_menu, new FavoriteTextDetailUI.2(this));
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenu.add(0, 1, 0, getString(n.i.app_copy));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    aRN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI
 * JD-Core Version:    0.7.0.1
 */