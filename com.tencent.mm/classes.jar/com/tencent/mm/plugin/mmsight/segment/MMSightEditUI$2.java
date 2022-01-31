package com.tencent.mm.plugin.mmsight.segment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.ui.b;
import com.tencent.mm.plugin.mmsight.ui.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class MMSightEditUI$2
  implements b.a
{
  MMSightEditUI$2(MMSightEditUI paramMMSightEditUI) {}
  
  public final void bRC()
  {
    AppMethodBeat.i(54961);
    ab.i("MicroMsg.MMSightEditUI", "onEditFinish");
    try
    {
      MMSightEditUI.b(this.oKK);
      long l1 = MMSightEditUI.c(this.oKK).oOC;
      long l2 = MMSightEditUI.c(this.oKK).oOD;
      if (MMSightEditUI.c(this.oKK) != null)
      {
        MMSightEditUI.c(this.oKK).p(false, "");
        MMSightEditUI.c(this.oKK).release();
        MMSightEditUI.d(this.oKK);
      }
      Object localObject;
      if (!MMSightEditUI.e(this.oKK))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("K_SEGMENTVIDEOPATH", MMSightEditUI.f(this.oKK));
        ((Intent)localObject).putExtra("key_seek_look_start_time", l1);
        ((Intent)localObject).putExtra("key_seek_end_time", l2);
        this.oKK.setResult(-1, (Intent)localObject);
        this.oKK.finish();
        AppMethodBeat.o(54961);
        return;
      }
      Bitmap localBitmap = com.tencent.mm.plugin.mmsight.d.ut(MMSightEditUI.g(this.oKK));
      if (localBitmap != null)
      {
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        localObject = localBitmap;
        if (com.tencent.mm.plugin.mmsight.d.a(localBitmap.getWidth(), localBitmap.getHeight(), MMSightEditUI.h(this.oKK).fAg, localPInt1, localPInt2)) {
          localObject = Bitmap.createScaledBitmap(localBitmap, localPInt1.value, localPInt2.value, true);
        }
        ab.i("MicroMsg.MMSightEditUI", "getBitmap size = [%d, %d]", new Object[] { Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
        com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject, 80, Bitmap.CompressFormat.JPEG, MMSightEditUI.i(this.oKK), true);
        localObject = new Intent();
        ((Intent)localObject).putExtra("K_SEGMENTVIDEOPATH", MMSightEditUI.g(this.oKK));
        ((Intent)localObject).putExtra("KSEGMENTVIDEOTHUMBPATH", MMSightEditUI.i(this.oKK));
        this.oKK.setResult(-1, (Intent)localObject);
        this.oKK.finish();
        AppMethodBeat.o(54961);
        return;
      }
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.MMSightEditUI", localException, "save video thumb error", new Object[0]);
      Toast.makeText(this.oKK, 2131301571, 1).show();
      this.oKK.finish();
      AppMethodBeat.o(54961);
      return;
    }
    ab.e("MicroMsg.MMSightEditUI", "getVideoThumb failed!");
    AppMethodBeat.o(54961);
  }
  
  public final void bRD()
  {
    AppMethodBeat.i(54962);
    ab.i("MicroMsg.MMSightEditUI", "onExitEdit");
    if (MMSightEditUI.c(this.oKK) != null)
    {
      MMSightEditUI.c(this.oKK).p(true, "");
      MMSightEditUI.c(this.oKK).release();
      MMSightEditUI.d(this.oKK);
    }
    this.oKK.finish();
    AppMethodBeat.o(54962);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(54963);
    if (MMSightEditUI.c(this.oKK) != null)
    {
      MMSightEditUI.c(this.oKK).release();
      MMSightEditUI.d(this.oKK);
    }
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(54960);
        Toast.makeText(MMSightEditUI.2.this.oKK, 2131301571, 1).show();
        AppMethodBeat.o(54960);
      }
    });
    AppMethodBeat.o(54963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.MMSightEditUI.2
 * JD-Core Version:    0.7.0.1
 */