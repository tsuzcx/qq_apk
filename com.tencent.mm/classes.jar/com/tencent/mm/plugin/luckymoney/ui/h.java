package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;

public final class h
{
  private static final Drawable lXq = new ColorDrawable();
  private Activity activity;
  private String imagePath;
  private com.tencent.mm.ui.base.o lXp;
  private GetHdHeadImageGalleryView lXr;
  private h.a lXs;
  private int lXt = 1;
  private String username;
  
  public h(Activity paramActivity, String paramString1, String paramString2)
  {
    this(paramActivity, paramString1, paramString2, h.a.lXv);
  }
  
  private h(Activity paramActivity, String paramString1, String paramString2, h.a parama)
  {
    this.activity = paramActivity;
    this.username = paramString1;
    this.imagePath = paramString2;
    this.lXs = parama;
  }
  
  public final void p(boolean paramBoolean, int paramInt)
  {
    y.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "previewImg readImgFromCache:" + paramBoolean + ", sceneFromUI:" + paramInt);
    Object localObject1 = LayoutInflater.from(this.activity).inflate(a.g.wallet_get_hd_head_image_gallery_view, null);
    this.lXp = new com.tencent.mm.ui.base.o((View)localObject1, -1, -1);
    this.lXp.setFocusable(true);
    this.lXp.setOutsideTouchable(true);
    this.lXp.setBackgroundDrawable(lXq);
    this.lXp.showAtLocation(this.activity.getWindow().getDecorView(), 49, 0, 0);
    this.lXr = ((GetHdHeadImageGalleryView)((View)localObject1).findViewById(a.f.gallery));
    this.lXr.setParentWindow(this.lXp);
    this.lXr.setUsername(this.username);
    this.lXr.setHdHeadImagePath(this.imagePath);
    this.lXt = paramInt;
    g.DQ();
    Bitmap localBitmap;
    if (!g.DP().isSDCardAvailable())
    {
      y.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "previewImg sdcard is not available!");
      s.gM(this.activity);
      localBitmap = BitmapFactory.decodeResource(ae.getContext().getResources(), a.e.nosdcard_chatting_bg);
    }
    for (;;)
    {
      try
      {
        if ((localBitmap.getWidth() >= 480) || (localBitmap.getWidth() <= 0)) {
          break label451;
        }
        float f = 480.0F / localBitmap.getWidth();
        localObject1 = new Matrix();
        ((Matrix)localObject1).postScale(f, f);
        localObject1 = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), (Matrix)localObject1, true);
        y.d("MicroMsg.LuckyMoneyPreviewImgGallaryView", "dkhdbm old[%d %d] new[%d %d]", new Object[] { Integer.valueOf(localBitmap.getWidth()), Integer.valueOf(localBitmap.getHeight()), Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()) });
        this.lXr.setHdHeadImage((Bitmap)localObject1);
        this.lXr.setHdHeadImagePath(null);
        return;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.LuckyMoneyPreviewImgGallaryView", localException, "", new Object[0]);
        return;
      }
      Object localObject2 = com.tencent.mm.plugin.luckymoney.b.o.aJ(this.imagePath, paramBoolean);
      if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
      {
        y.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "The image of %s is in the cache", new Object[] { this.username });
        this.lXr.setHdHeadImage((Bitmap)localObject2);
      }
      for (;;)
      {
        this.lXr.setLongClickOverListener(new h.1(this));
        return;
        y.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "The image of %s is not in the cache, use default avatar", new Object[] { this.username });
      }
      label451:
      localObject2 = localBitmap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.h
 * JD-Core Version:    0.7.0.1
 */