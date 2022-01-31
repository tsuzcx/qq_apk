package com.tencent.mm.plugin.facedetect.d;

import android.content.res.Resources;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class d$9
  implements a.b
{
  d$9(d paramd) {}
  
  public final void aOI()
  {
    synchronized (this.jPM.jPG)
    {
      y.i("MicroMsg.NumberFaceMotion", "hy: triggered read symbol");
      if ((!this.jPM.jPA) && (this.jPM.jPB))
      {
        this.jPM.jPA = true;
        d.b(this.jPM);
      }
      return;
    }
  }
  
  public final void onError(int paramInt)
  {
    for (;;)
    {
      synchronized (this.jPM.jPG)
      {
        y.w("MicroMsg.NumberFaceMotion", "hy: on voice prepare error: %d", new Object[] { Integer.valueOf(paramInt) });
        switch (paramInt)
        {
        case 11: 
          this.jPM.jPH = true;
          this.jPM.jPI = new b.a(ae.getResources().getString(a.i.permission_microphone_request_again_msg));
          return;
          this.jPM.jPy = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.d.9
 * JD-Core Version:    0.7.0.1
 */