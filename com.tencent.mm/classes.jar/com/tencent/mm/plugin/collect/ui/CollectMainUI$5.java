package com.tencent.mm.plugin.collect.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.protocal.protobuf.aed;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;

final class CollectMainUI$5
  implements Runnable
{
  CollectMainUI$5(CollectMainUI paramCollectMainUI, LinearLayout paramLinearLayout, dqi paramdqi, aed paramaed) {}
  
  public final void run()
  {
    AppMethodBeat.i(64117);
    Log.d("MicroMsg.CollectMainUI", "height: %d, width: %d", new Object[] { Integer.valueOf(this.uaO.getHeight()), Integer.valueOf(this.uaO.getWidth()) });
    Bitmap localBitmap = Bitmap.createBitmap(this.uaO.getWidth(), this.uaO.getHeight(), Bitmap.Config.ARGB_8888);
    Object localObject = new Canvas(localBitmap);
    this.uaO.draw((Canvas)localObject);
    try
    {
      localObject = u.getSysCameraDirPath() + "mm_facetoface_collect_qrcode_" + System.currentTimeMillis() + ".png";
      BitmapUtil.saveBitmapToImage(localBitmap, 100, Bitmap.CompressFormat.PNG, (String)localObject, false);
      if (this.uaP)
      {
        Log.i("MicroMsg.CollectMainUI", "doSaveQrCode success ");
        CollectMainUI.a(this.uaM, this.uaM.getContext(), this.uaM.getContext().getResources().getString(a.i.collect_material_guide_save_text_toast), a.h.icons_filled_done, this.uaQ, this.uaR);
      }
      u.refreshMediaScanner((String)localObject, this.uaM.getContext());
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.CollectMainUI", "save fixed amount qrcode failed!" + localException.getMessage());
      }
    }
    this.uaM.tXA.setVisibility(8);
    AppMethodBeat.o(64117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.5
 * JD-Core Version:    0.7.0.1
 */