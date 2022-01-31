package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.i;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.n.c;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.fav.ui.n.h;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class FavoriteImgDetailUI
  extends BaseFavDetailReportUI
  implements com.tencent.mm.plugin.fav.a.p
{
  private com.tencent.mm.sdk.b.c kbV = new FavoriteImgDetailUI.2(this);
  private View.OnClickListener kdc = new FavoriteImgDetailUI.5(this);
  private LinearLayout kfF;
  private int kfG = 0;
  private com.tencent.mm.plugin.fav.a.g kfH;
  private HashMap<String, FavoriteImgDetailUI.a> kfI = new HashMap();
  private Bitmap kfJ;
  private boolean kfK = true;
  private View.OnLongClickListener kfL = new FavoriteImgDetailUI.6(this);
  
  private void a(FavoriteImgDetailUI.a parama)
  {
    com.tencent.mm.kernel.g.DS().O(new FavoriteImgDetailUI.4(this, parama));
  }
  
  public static void a(String paramString1, String paramString2, Context paramContext)
  {
    if (bk.bl(paramString1)) {
      y.w("MicroMsg.FavoriteImgDetailUI", "save image fail, path is null");
    }
    while (com.tencent.mm.platformtools.q.a(paramString1, paramContext, n.i.cropimage_saved)) {
      return;
    }
    Toast.makeText(paramContext, paramString2, 1).show();
  }
  
  private void aRL()
  {
    if (com.tencent.mm.sdk.platformtools.ae.getResources() != null) {}
    for (DisplayMetrics localDisplayMetrics = com.tencent.mm.sdk.platformtools.ae.getResources().getDisplayMetrics();; localDisplayMetrics = getResources().getDisplayMetrics())
    {
      this.kfG = (localDisplayMetrics.widthPixels - getResources().getDimensionPixelOffset(n.c.FavDetailPadding) * 2);
      this.kfG = Math.max(this.kfG, 0);
      y.d("MicroMsg.FavoriteImgDetailUI", "update display width %d", new Object[] { Integer.valueOf(this.kfG) });
      return;
    }
  }
  
  private Bitmap l(xv paramxv)
  {
    boolean bool = true;
    paramxv = l.a(paramxv, this.kfH);
    if (paramxv != null) {}
    for (;;)
    {
      y.d("MicroMsg.FavoriteImgDetailUI", "get thumb ok ? %B", new Object[] { Boolean.valueOf(bool) });
      if (paramxv == null) {
        break;
      }
      return paramxv;
      bool = false;
    }
    if (this.kfJ == null) {
      this.kfJ = com.tencent.mm.compatible.g.a.decodeResource(getResources(), n.h.fav_list_img_default);
    }
    return this.kfJ;
  }
  
  protected final MMLoadScrollView aRE()
  {
    return (MMLoadScrollView)findViewById(n.e.scroll_view);
  }
  
  public final void d(com.tencent.mm.plugin.fav.a.c paramc)
  {
    if ((paramc == null) || (!paramc.isFinished())) {}
    do
    {
      return;
      y.d("MicroMsg.FavoriteImgDetailUI", "on cdn status change, dataid[%s]", new Object[] { paramc.field_dataId });
      paramc = (FavoriteImgDetailUI.a)this.kfI.get(paramc.field_dataId);
    } while (paramc == null);
    a(paramc);
  }
  
  protected final int getLayoutId()
  {
    return n.f.favorite_img_detail_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (1 == paramInt1)
    {
      if (-1 != paramInt2) {
        return;
      }
      new k();
      if (k.u(this.kfH))
      {
        h.bC(this.mController.uMN, getString(n.i.Fav_NotDownload_CannotForward));
        return;
      }
      String str1 = paramIntent.getStringExtra("Select_Conv_User");
      String str2 = paramIntent.getStringExtra("custom_send_text");
      y.d("MicroMsg.FavoriteImgDetailUI", "select %s for sending", new Object[] { str1 });
      com.tencent.mm.ui.base.p localp = h.b(this.mController.uMN, getString(n.i.favorite_forward_tips), false, null);
      i.a(this.mController.uMN, str1, str2, this.kfH, new FavoriteImgDetailUI.10(this, localp));
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    aRL();
    paramConfiguration = this.kfI.entrySet().iterator();
    while (paramConfiguration.hasNext()) {
      a((FavoriteImgDetailUI.a)((Map.Entry)paramConfiguration.next()).getValue());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    e.k(this);
    super.onCreate(paramBundle);
    aRL();
    this.kfF = ((LinearLayout)findViewById(n.e.fav_img_container));
    long l = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.kfH = ((com.tencent.mm.plugin.fav.a.ae)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavItemInfoStorage().eE(l);
    if (this.kfH == null)
    {
      finish();
      return;
    }
    E(this.kfH);
    paramBundle = this.kfH.field_favProto.sXc.iterator();
    int i = 0;
    while (paramBundle.hasNext())
    {
      xv localxv = (xv)paramBundle.next();
      y.d("MicroMsg.FavoriteImgDetailUI", "index[%d], dataid[%s]", new Object[] { Integer.valueOf(i), localxv.kgC });
      FavoriteImgDetailUI.a locala = new FavoriteImgDetailUI.a(this, (byte)0);
      locala.bNt = localxv;
      ImageView localImageView = new ImageView(this.mController.uMN);
      int j = getResources().getDimensionPixelSize(n.c.SmallPadding);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      if (i > 0) {
        localLayoutParams.topMargin = j;
      }
      this.kfF.addView(localImageView, localLayoutParams);
      localImageView.setTag(localxv);
      j /= 2;
      localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      localImageView.setPadding(j, j, j, j);
      localImageView.setMinimumWidth(com.tencent.mm.cb.a.fromDPToPix(this.mController.uMN, 50));
      localImageView.setMinimumHeight(com.tencent.mm.cb.a.fromDPToPix(this.mController.uMN, 50));
      localImageView.setImageResource(n.h.fav_list_img_default);
      localImageView.setOnClickListener(this.kdc);
      localImageView.setOnLongClickListener(this.kfL);
      localImageView.setOnTouchListener(new FavoriteImgDetailUI.9(this));
      locala.bNu = localImageView;
      this.kfI.put(localxv.kgC, locala);
      a(locala);
      if (localxv.sVO != 0) {
        this.kfK = false;
      }
      i += 1;
    }
    setMMTitle(getString(n.i.favorite_detail));
    a.a(this, this.kfH);
    setBackBtn(new FavoriteImgDetailUI.1(this));
    addIconOptionMenu(0, n.i.top_item_desc_more, n.h.actionbar_icon_dark_more, new FavoriteImgDetailUI.3(this, l));
    e.l(this);
    ((com.tencent.mm.plugin.fav.a.ae)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavCdnStorage().a(this);
    com.tencent.mm.sdk.b.a.udP.c(this.kbV);
  }
  
  protected void onDestroy()
  {
    ((com.tencent.mm.plugin.fav.a.ae)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fav.a.ae.class)).getFavCdnStorage().b(this);
    com.tencent.mm.sdk.b.a.udP.d(this.kbV);
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    Iterator localIterator = this.kfI.entrySet().iterator();
    while (localIterator.hasNext()) {
      a((FavoriteImgDetailUI.a)((Map.Entry)localIterator.next()).getValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI
 * JD-Core Version:    0.7.0.1
 */