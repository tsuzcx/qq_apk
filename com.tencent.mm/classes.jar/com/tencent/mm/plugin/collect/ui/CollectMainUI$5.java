package com.tencent.mm.plugin.collect.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;

final class CollectMainUI$5
  implements Runnable
{
  CollectMainUI$5(CollectMainUI paramCollectMainUI, LinearLayout paramLinearLayout, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(41256);
    ab.d("MicroMsg.CollectMainUI", "height: %d, width: %d", new Object[] { Integer.valueOf(this.kSB.getHeight()), Integer.valueOf(this.kSB.getWidth()) });
    Bitmap localBitmap = Bitmap.createBitmap(this.kSB.getWidth(), this.kSB.getHeight(), Bitmap.Config.ARGB_8888);
    Object localObject = new Canvas(localBitmap);
    this.kSB.draw((Canvas)localObject);
    try
    {
      localObject = n.aok() + "mm_facetoface_collect_qrcode_" + System.currentTimeMillis() + ".png";
      d.a(localBitmap, 100, Bitmap.CompressFormat.PNG, (String)localObject, false);
      if (this.kSC) {
        Toast.makeText(this.kSz.getContext(), this.kSz.getString(2131305031, new Object[] { localObject }), 1).show();
      }
      n.a((String)localObject, this.kSz.getContext());
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.w("MicroMsg.CollectMainUI", "save fixed amount qrcode failed!" + localException.getMessage());
      }
    }
    this.kSz.kPF.setVisibility(8);
    AppMethodBeat.o(41256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.5
 * JD-Core Version:    0.7.0.1
 */