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
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;

final class QrRewardMainUI$8
  implements Runnable
{
  QrRewardMainUI$8(QrRewardMainUI paramQrRewardMainUI, ViewGroup paramViewGroup, ImageView paramImageView) {}
  
  public final void run()
  {
    AppMethodBeat.i(41091);
    ab.d("MicroMsg.QrRewardMainUI", "height: %d, width: %d", new Object[] { Integer.valueOf(this.kPQ.getHeight()), Integer.valueOf(this.kPQ.getWidth()) });
    Bitmap localBitmap = Bitmap.createBitmap(QrRewardMainUI.s(this.kPN).getWidth(), QrRewardMainUI.s(this.kPN).getHeight(), Bitmap.Config.ARGB_8888);
    Object localObject = new Canvas(localBitmap);
    QrRewardMainUI.s(this.kPN).draw((Canvas)localObject);
    this.kPR.setImageBitmap(localBitmap);
    localBitmap = Bitmap.createBitmap(this.kPQ.getWidth(), this.kPQ.getHeight(), Bitmap.Config.ARGB_8888);
    localObject = new Canvas(localBitmap);
    this.kPQ.draw((Canvas)localObject);
    try
    {
      localObject = n.aok() + "mm_reward_qrcode_" + System.currentTimeMillis() + ".png";
      d.a(localBitmap, 100, Bitmap.CompressFormat.PNG, (String)localObject, false);
      Toast.makeText(this.kPN.getContext(), this.kPN.getString(2131298889, new Object[] { localObject }), 1).show();
      n.a((String)localObject, this.kPN.getContext());
      QrRewardMainUI.t(this.kPN).setVisibility(8);
      ab.i("MicroMsg.QrRewardMainUI", "bitmap recycle %s", new Object[] { localBitmap.toString() });
      localBitmap.recycle();
      AppMethodBeat.o(41091);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.w("MicroMsg.QrRewardMainUI", "save fixed amount qrcode failed!" + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.8
 * JD-Core Version:    0.7.0.1
 */