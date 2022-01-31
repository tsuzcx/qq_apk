package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.FavChatVoiceView;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.fav.ui.n.d;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

public class FavoriteVoiceDetailUI
  extends BaseFavDetailReportUI
  implements j.a
{
  private com.tencent.mm.plugin.fav.a.g jZN;
  private n kai;
  private FavChatVoiceView kgH;
  private long kgb;
  
  public final void a(String paramString, l paraml)
  {
    this.jZN = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(this.kgb);
    if (this.jZN == null)
    {
      y.w("MicroMsg.FavoriteDetailUI", "on notify changed, get fav item info error");
      finish();
    }
    while ((this.jZN.field_itemStatus != 10) || (paraml == null) || (paraml.ujY == null) || (this.jZN.field_favProto.sXc.size() <= 0)) {
      return;
    }
    paraml = b.c(this.jZN);
    paramString = b.b(paraml);
    int i = b.CA(paraml.sUV);
    y.i("MicroMsg.FavoriteDetailUI", "on notify changed, favVoiceView.updateInfo");
    paraml = j.x(this, (int)b.eu(paraml.duration)).toString();
    this.kgH.v(paramString, i, paraml);
  }
  
  protected final int getLayoutId()
  {
    return n.f.favorite_voice_detail_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(getString(n.i.favorite_detail));
    this.kgb = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.jZN = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(this.kgb);
    if (this.jZN == null)
    {
      y.w("MicroMsg.FavoriteDetailUI", "get fav item info error");
      finish();
    }
    for (;;)
    {
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().c(this);
      return;
      E(this.jZN);
      this.kai = new n();
      this.kgH = ((FavChatVoiceView)findViewById(n.e.fav_chatvoice_player));
      this.kgH.setVoiceHelper(this.kai);
      a.a(this, this.jZN);
      Object localObject = b.c(this.jZN);
      paramBundle = b.b((xv)localObject);
      int i = b.CA(((xv)localObject).sUV);
      if (!e.bK(paramBundle)) {
        b.m(this.jZN);
      }
      localObject = j.x(this, (int)b.eu(((xv)localObject).duration)).toString();
      this.kgH.v(paramBundle, i, (String)localObject);
      setBackBtn(new FavoriteVoiceDetailUI.1(this));
      addIconOptionMenu(0, n.i.top_item_desc_more, n.d.mm_title_btn_menu, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          paramAnonymousMenuItem = new d(FavoriteVoiceDetailUI.this.mController.uMN, 1, false);
          paramAnonymousMenuItem.phH = new FavoriteVoiceDetailUI.2.1(this);
          paramAnonymousMenuItem.phI = new FavoriteVoiceDetailUI.2.2(this);
          paramAnonymousMenuItem.cfU();
          return true;
        }
      });
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.kgH != null) {
      this.kgH.stopPlay();
    }
    if (this.kai != null) {
      this.kai.destroy();
    }
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().d(this);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.kai.pause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI
 * JD-Core Version:    0.7.0.1
 */