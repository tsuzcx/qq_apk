package com.tencent.mm.plugin.facedetect.d;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class d$9
  implements a.b
{
  d$9(d paramd) {}
  
  public final void buM()
  {
    AppMethodBeat.i(319);
    synchronized (this.mkc.mjW)
    {
      ab.i("MicroMsg.NumberFaceMotion", "hy: triggered read symbol");
      if ((!this.mkc.mjQ) && (this.mkc.mjR))
      {
        this.mkc.mjQ = true;
        d.b(this.mkc);
      }
      AppMethodBeat.o(319);
      return;
    }
  }
  
  public final void onError(int paramInt)
  {
    AppMethodBeat.i(320);
    for (;;)
    {
      synchronized (this.mkc.mjW)
      {
        ab.w("MicroMsg.NumberFaceMotion", "hy: on voice prepare error: %d", new Object[] { Integer.valueOf(paramInt) });
        switch (paramInt)
        {
        case 11: 
          this.mkc.mjX = true;
          this.mkc.mjY = new b.a(ah.getResources().getString(2131302075));
          AppMethodBeat.o(320);
          return;
          this.mkc.mjO = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.d.9
 * JD-Core Version:    0.7.0.1
 */