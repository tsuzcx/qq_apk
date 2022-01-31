package com.tencent.mm.plugin.fav.ui.detail;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.m.c;
import com.tencent.mm.plugin.fav.a.m.d;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.i;
import com.tencent.mm.plugin.fav.ui.n.d;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.fav.ui.n.h;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public class FavoriteSightDetailUI
  extends BaseFavDetailReportUI
  implements p, j.a
{
  private xv bNt;
  private k kdb = new k();
  private com.tencent.mm.plugin.fav.a.g kdn;
  private View kfW;
  private ImageView kfX;
  private MMPinProgressBtn kfY;
  private VideoPlayerTextureView kfZ;
  private boolean kfm = false;
  private boolean kfs = false;
  private ImageView kga;
  private long kgb;
  private boolean kgc = true;
  private boolean kgd = false;
  private Runnable kge = new FavoriteSightDetailUI.5(this);
  private boolean kgf = false;
  
  private void aRM()
  {
    String str = com.tencent.mm.plugin.fav.a.b.b(this.bNt);
    if (!com.tencent.mm.vfs.e.bK(str)) {
      return;
    }
    this.kfZ.stop();
    this.kfZ.setMute(true);
    this.kfZ.setVideoPath(str);
  }
  
  @SuppressLint({"ResourceType"})
  private void fZ(boolean paramBoolean)
  {
    if (this.kdn.isDone())
    {
      if (com.tencent.mm.plugin.fav.a.b.f(this.bNt))
      {
        this.kfX.setVisibility(8);
        this.kfY.setVisibility(8);
        aRM();
        return;
      }
      if (bk.bl(this.bNt.sUG)) {
        this.kfX.setImageResource(n.h.shortvideo_play_btn);
      }
    }
    for (;;)
    {
      this.kfX.setVisibility(0);
      this.kfY.setVisibility(8);
      this.kga.setVisibility(0);
      return;
      y.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
      this.kfX.setImageResource(n.h.shortvideo_play_btn);
      continue;
      if (this.kdn.aQb())
      {
        if (bk.bl(this.bNt.sUG))
        {
          this.kfX.setImageResource(n.h.shortvideo_play_btn);
          if (!paramBoolean) {}
        }
        else
        {
          this.kfX.setImageResource(n.h.shortvideo_play_btn);
          if (paramBoolean) {
            h.bC(this.mController.uMN, getString(n.i.download_fail));
          }
        }
      }
      else if (this.kdn.aQa())
      {
        this.kfX.setImageResource(n.h.shortvideo_play_btn);
        if (paramBoolean) {
          h.bC(this.mController.uMN, getString(n.i.fav_upload_fail));
        }
      }
      else
      {
        if ((this.kdn.isDownloading()) || (this.kdn.aPZ()))
        {
          this.kfX.setVisibility(8);
          this.kfY.setVisibility(0);
          c localc = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().CN(this.bNt.kgC);
          if (localc != null) {
            this.kfY.setProgress((int)localc.getProgress());
          }
          for (;;)
          {
            this.kga.setVisibility(0);
            return;
            this.kfY.setProgress(0);
          }
        }
        y.w("MicroMsg.FavoriteSightDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
        this.kfX.setImageResource(n.h.shortvideo_play_btn);
      }
    }
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.l paraml)
  {
    y.i("MicroMsg.FavoriteSightDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[] { paramString, Long.valueOf(this.kdn.field_localId) });
    paramString = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(this.kdn.field_localId);
    if (paramString == null)
    {
      y.w("MicroMsg.FavoriteSightDetailUI", "error, on notify change, cannot find info");
      finish();
    }
    for (;;)
    {
      return;
      this.kdn = paramString;
      this.bNt = com.tencent.mm.plugin.fav.a.b.c(paramString);
      paramString = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().CN(this.bNt.kgC);
      boolean bool;
      if (paramString == null) {
        bool = false;
      }
      while (!bool)
      {
        ai.S(this.kge);
        ai.l(this.kge, 500L);
        return;
        if (this.kfs)
        {
          bool = false;
        }
        else
        {
          if ((paramString.field_status == 4) && (((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().CN(this.bNt.kgC).field_extFlag != 0))
          {
            com.tencent.mm.plugin.fav.a.b.a(this.kdn, this.bNt, true);
            this.kfs = true;
          }
          y.i("MicroMsg.FavoriteSightDetailUI", "FavoriteFileDetail download, check retry, return %B", new Object[] { Boolean.valueOf(this.kfs) });
          bool = this.kfs;
        }
      }
    }
  }
  
  protected final MMLoadScrollView aRE()
  {
    return (MMLoadScrollView)findViewById(n.e.scroll_view);
  }
  
  public final void d(c paramc)
  {
    if ((paramc == null) || (paramc.field_dataId == null))
    {
      y.w("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, item is null");
      return;
    }
    y.i("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, dataID is %s, field id is %s,offset is %d, total is %d,cdn status is %d, cdn type is %d (send or recieve)", new Object[] { this.bNt.kgC, paramc.field_dataId, Integer.valueOf(paramc.field_offset), Integer.valueOf(paramc.field_totalLen), Integer.valueOf(paramc.field_status), Integer.valueOf(paramc.field_type) });
    if (paramc.field_offset > paramc.field_totalLen)
    {
      y.e("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, cdn offset length > cdn total length, do cdnLengthError()");
      if (1 != paramc.field_type) {
        break label211;
      }
    }
    label211:
    for (paramc.field_status = 2;; paramc.field_status = 4)
    {
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().a(paramc, new String[0]);
      if (paramc.field_type == 0) {
        com.tencent.mm.plugin.fav.a.b.a(paramc);
      }
      if (paramc.field_type == 1) {
        com.tencent.mm.plugin.fav.a.b.b(paramc);
      }
      if (!paramc.field_dataId.equals(this.bNt.kgC)) {
        break;
      }
      int i = (int)paramc.getProgress();
      this.kfY.post(new FavoriteSightDetailUI.6(this, i));
      return;
    }
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return n.f.favorite_sight_detail_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (-1 == paramInt2))
    {
      String str;
      label23:
      Object localObject;
      label87:
      m.d locald;
      if (paramIntent == null)
      {
        str = null;
        if (paramIntent != null) {
          break label142;
        }
        paramIntent = null;
        localObject = new FavoriteSightDetailUI.7(this, h.b(this.mController.uMN, getString(n.i.favorite_forward_tips), false, null));
        i.a(this.mController.uMN, str, paramIntent, this.kdn, (Runnable)localObject);
        boolean bool = com.tencent.mm.model.s.fn(str);
        if (!bool) {
          break label153;
        }
        paramIntent = m.c.jZv;
        localObject = this.kdn;
        locald = m.d.jZy;
        if (!bool) {
          break label160;
        }
      }
      label142:
      label153:
      label160:
      for (paramInt1 = com.tencent.mm.model.m.gM(str);; paramInt1 = 0)
      {
        com.tencent.mm.plugin.fav.a.m.a(paramIntent, (com.tencent.mm.plugin.fav.a.g)localObject, locald, paramInt1);
        com.tencent.mm.ui.widget.snackbar.b.h(this, getString(n.i.fav_finish_sent));
        return;
        str = paramIntent.getStringExtra("Select_Conv_User");
        break;
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        break label23;
        paramIntent = m.c.jZu;
        break label87;
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    com.tencent.mm.pluginsdk.e.k(this);
    super.onCreate(paramBundle);
    this.kgb = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.kdn = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(this.kgb);
    if (this.kdn == null)
    {
      y.w("MicroMsg.FavoriteSightDetailUI", "id[%d] info is null, return", new Object[] { Long.valueOf(this.kgb) });
      finish();
      return;
    }
    E(this.kdn);
    com.tencent.mm.plugin.fav.a.m.w(this.kdn);
    a.a(this, this.kdn);
    this.bNt = com.tencent.mm.plugin.fav.a.b.c(this.kdn);
    this.kfX = ((ImageView)findViewById(n.e.status_btn));
    this.kfY = ((MMPinProgressBtn)findViewById(n.e.video_progress));
    this.kfW = findViewById(n.e.click_area);
    this.kfZ = ((VideoPlayerTextureView)findViewById(n.e.video_view));
    this.kga = ((ImageView)findViewById(n.e.video_thumb));
    this.kfW.setOnClickListener(new FavoriteSightDetailUI.1(this));
    this.kfZ.setVideoCallback(new FavoriteSightDetailUI.2(this));
    setMMTitle(getString(n.i.favorite_detail));
    setBackBtn(new FavoriteSightDetailUI.3(this));
    addIconOptionMenu(0, n.i.top_item_desc_more, n.d.mm_title_btn_menu, new FavoriteSightDetailUI.4(this));
    if (!com.tencent.mm.vfs.e.bK(com.tencent.mm.plugin.fav.a.b.c(this.bNt))) {
      if (!bk.bl(this.bNt.dQL)) {
        com.tencent.mm.plugin.fav.a.b.a(this.kdn, this.bNt);
      }
    }
    do
    {
      fZ(false);
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().c(this);
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().a(this);
      com.tencent.mm.pluginsdk.e.l(this);
      return;
      paramBundle = com.tencent.mm.plugin.fav.ui.l.a(this.bNt, this.kdn);
    } while (paramBundle == null);
    int i = paramBundle.getWidth();
    int j = paramBundle.getHeight();
    DisplayMetrics localDisplayMetrics;
    float f;
    ViewGroup.LayoutParams localLayoutParams;
    if (!this.kgf)
    {
      this.kgf = true;
      localDisplayMetrics = this.kfW.getResources().getDisplayMetrics();
      f = localDisplayMetrics.density;
      localLayoutParams = this.kfW.getLayoutParams();
      if (localLayoutParams != null) {
        break label444;
      }
      y.e("MicroMsg.FavoriteSightDetailUI", "setViewResize, but params is null");
    }
    for (;;)
    {
      this.kga.setImageBitmap(paramBundle);
      this.kga.setVisibility(0);
      break;
      label444:
      localLayoutParams.width = (localDisplayMetrics.widthPixels - (int)(f * 36.0F + 0.5F));
      localLayoutParams.height = (j * localLayoutParams.width / i);
      this.kfW.setLayoutParams(localLayoutParams);
    }
  }
  
  protected void onDestroy()
  {
    if (this.kfZ != null)
    {
      this.kfZ.setVideoCallback(null);
      this.kfZ.stop();
    }
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().d(this);
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnStorage().b(this);
    super.onDestroy();
  }
  
  protected void onPause()
  {
    if (this.kfZ != null) {
      this.kfZ.stop();
    }
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.kfZ != null)
    {
      if (this.kgc) {
        break label28;
      }
      aRM();
    }
    for (;;)
    {
      this.kgc = false;
      return;
      label28:
      if (!this.kfZ.isPlaying()) {
        this.kfZ.start();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI
 * JD-Core Version:    0.7.0.1
 */