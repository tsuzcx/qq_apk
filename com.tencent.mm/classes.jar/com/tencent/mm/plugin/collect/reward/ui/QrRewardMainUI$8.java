package com.tencent.mm.plugin.collect.reward.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class QrRewardMainUI$8
  implements Runnable
{
  QrRewardMainUI$8(QrRewardMainUI paramQrRewardMainUI, ViewGroup paramViewGroup, ImageView paramImageView) {}
  
  public final void run()
  {
    y.d("MicroMsg.QrRewardMainUI", "height: %d, width: %d", new Object[] { Integer.valueOf(this.iJl.getHeight()), Integer.valueOf(this.iJl.getWidth()) });
    Bitmap localBitmap = Bitmap.createBitmap(QrRewardMainUI.r(this.iJi).getWidth(), QrRewardMainUI.r(this.iJi).getHeight(), Bitmap.Config.ARGB_8888);
    Object localObject = new Canvas(localBitmap);
    QrRewardMainUI.r(this.iJi).draw((Canvas)localObject);
    this.iJm.setImageBitmap(localBitmap);
    localBitmap = Bitmap.createBitmap(this.iJl.getWidth(), this.iJl.getHeight(), Bitmap.Config.ARGB_8888);
    localObject = new Canvas(localBitmap);
    this.iJl.draw((Canvas)localObject);
    try
    {
      localObject = l.qt() + "mm_reward_qrcode_" + System.currentTimeMillis() + ".png";
      c.a(localBitmap, 100, Bitmap.CompressFormat.PNG, (String)localObject, false);
      Toast.makeText(this.iJi.mController.uMN, this.iJi.getString(a.i.cropimage_saved, new Object[] { localObject }), 1).show();
      l.a((String)localObject, this.iJi.mController.uMN);
      QrRewardMainUI.s(this.iJi).setVisibility(8);
      localBitmap.recycle();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.w("MicroMsg.QrRewardMainUI", "save fixed amount qrcode failed!" + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.8
 * JD-Core Version:    0.7.0.1
 */