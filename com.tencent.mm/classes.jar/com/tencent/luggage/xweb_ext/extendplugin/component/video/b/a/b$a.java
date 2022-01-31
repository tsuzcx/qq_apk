package com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a;

import com.google.android.exoplayer2.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$a
  implements e.b
{
  private b$a(b paramb) {}
  
  public final void ye()
  {
    AppMethodBeat.i(139937);
    for (;;)
    {
      synchronized (this.bIP)
      {
        if (this.bIP.bIe)
        {
          AppMethodBeat.o(139937);
          return;
        }
        if (this.bIP.yb()) {}
        switch (this.bIP.bID.mJ())
        {
        case 1: 
          AppMethodBeat.o(139937);
          return;
        case 4: 
          b.a(this.bIP, false);
        }
      }
      int i = this.bIP.getBufferedPercentage();
      if (i != this.bIP.bIL)
      {
        this.bIP.fE(i);
        this.bIP.bIL = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */