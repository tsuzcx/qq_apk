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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidMediaUtil;

final class QrRewardMainUI$8
  implements Runnable
{
  QrRewardMainUI$8(QrRewardMainUI paramQrRewardMainUI, ViewGroup paramViewGroup, ImageView paramImageView) {}
  
  public final void run()
  {
    AppMethodBeat.i(63950);
    Log.d("MicroMsg.QrRewardMainUI", "height: %d, width: %d", new Object[] { Integer.valueOf(this.tXL.getHeight()), Integer.valueOf(this.tXL.getWidth()) });
    Bitmap localBitmap = Bitmap.createBitmap(QrRewardMainUI.s(this.tXI).getWidth(), QrRewardMainUI.s(this.tXI).getHeight(), Bitmap.Config.ARGB_8888);
    Object localObject = new Canvas(localBitmap);
    QrRewardMainUI.s(this.tXI).draw((Canvas)localObject);
    this.tXM.setImageBitmap(localBitmap);
    localBitmap = Bitmap.createBitmap(this.tXL.getWidth(), this.tXL.getHeight(), Bitmap.Config.ARGB_8888);
    localObject = new Canvas(localBitmap);
    this.tXL.draw((Canvas)localObject);
    try
    {
      localObject = u.getSysCameraDirPath() + "mm_reward_qrcode_" + System.currentTimeMillis() + ".png";
      BitmapUtil.saveBitmapToImage(localBitmap, 100, Bitmap.CompressFormat.PNG, AndroidMediaUtil.getFriendlySdcardPath((String)localObject), false);
      Toast.makeText(this.tXI.getContext(), this.tXI.getString(a.i.cropimage_saved, new Object[] { localObject }), 1).show();
      u.refreshMediaScanner((String)localObject, this.tXI.getContext());
      QrRewardMainUI.t(this.tXI).setVisibility(8);
      Log.i("MicroMsg.QrRewardMainUI", "bitmap recycle %s", new Object[] { localBitmap.toString() });
      localBitmap.recycle();
      AppMethodBeat.o(63950);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.QrRewardMainUI", "save fixed amount qrcode failed!" + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.8
 * JD-Core Version:    0.7.0.1
 */