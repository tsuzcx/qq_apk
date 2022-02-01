package com.tencent.mm.plugin.collect.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.cnv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.g;

final class CollectMainUI$5
  implements Runnable
{
  CollectMainUI$5(CollectMainUI paramCollectMainUI, LinearLayout paramLinearLayout, cnv paramcnv, abl paramabl) {}
  
  public final void run()
  {
    AppMethodBeat.i(64117);
    ad.d("MicroMsg.CollectMainUI", "height: %d, width: %d", new Object[] { Integer.valueOf(this.pfQ.getHeight()), Integer.valueOf(this.pfQ.getWidth()) });
    Bitmap localBitmap = Bitmap.createBitmap(this.pfQ.getWidth(), this.pfQ.getHeight(), Bitmap.Config.ARGB_8888);
    Object localObject = new Canvas(localBitmap);
    this.pfQ.draw((Canvas)localObject);
    try
    {
      localObject = q.ffo() + "mm_facetoface_collect_qrcode_" + System.currentTimeMillis() + ".png";
      g.a(localBitmap, 100, Bitmap.CompressFormat.PNG, (String)localObject, false);
      if (this.pfR)
      {
        ad.i("MicroMsg.CollectMainUI", "doSaveQrCode success ");
        CollectMainUI.a(this.pfO, this.pfO.getContext(), this.pfO.getContext().getResources().getString(2131760299), this.pfS, this.pfT);
      }
      q.k((String)localObject, this.pfO.getContext());
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.w("MicroMsg.CollectMainUI", "save fixed amount qrcode failed!" + localException.getMessage());
      }
    }
    this.pfO.pcJ.setVisibility(8);
    AppMethodBeat.o(64117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.5
 * JD-Core Version:    0.7.0.1
 */