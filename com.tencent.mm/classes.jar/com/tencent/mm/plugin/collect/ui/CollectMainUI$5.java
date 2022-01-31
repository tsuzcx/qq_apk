package com.tencent.mm.plugin.collect.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class CollectMainUI$5
  implements Runnable
{
  CollectMainUI$5(CollectMainUI paramCollectMainUI, LinearLayout paramLinearLayout, boolean paramBoolean) {}
  
  public final void run()
  {
    y.d("MicroMsg.CollectMainUI", "height: %d, width: %d", new Object[] { Integer.valueOf(this.iLR.getHeight()), Integer.valueOf(this.iLR.getWidth()) });
    Bitmap localBitmap = Bitmap.createBitmap(this.iLR.getWidth(), this.iLR.getHeight(), Bitmap.Config.ARGB_8888);
    Object localObject = new Canvas(localBitmap);
    this.iLR.draw((Canvas)localObject);
    try
    {
      localObject = l.qt() + "mm_facetoface_collect_qrcode_" + System.currentTimeMillis() + ".png";
      c.a(localBitmap, 100, Bitmap.CompressFormat.PNG, (String)localObject, false);
      if (this.iLS) {
        Toast.makeText(this.iLP.mController.uMN, this.iLP.getString(a.i.wallet_cropimage_saved, new Object[] { localObject }), 1).show();
      }
      l.a((String)localObject, this.iLP.mController.uMN);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.w("MicroMsg.CollectMainUI", "save fixed amount qrcode failed!" + localException.getMessage());
      }
    }
    this.iLP.iIZ.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.5
 * JD-Core Version:    0.7.0.1
 */