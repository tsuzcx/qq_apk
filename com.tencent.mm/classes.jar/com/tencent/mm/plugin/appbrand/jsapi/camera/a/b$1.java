package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.qbar.QbarNative;
import java.util.concurrent.atomic.AtomicBoolean;

final class b$1
  implements Runnable
{
  b$1(b paramb, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, Rect paramRect) {}
  
  public final void run()
  {
    AppMethodBeat.i(130978);
    if (this.hJv.hJn.compareAndSet(false, true))
    {
      byte[] arrayOfByte1 = this.hJq;
      if ((270 == this.hJr) || (90 == this.hJr))
      {
        byte[] arrayOfByte2 = new byte[this.hJq.length];
        QbarNative.a(arrayOfByte2, this.hJq, this.hJs, this.hJt);
        arrayOfByte1 = new byte[this.hJq.length];
        QbarNative.a(arrayOfByte1, arrayOfByte2, this.hJt, this.hJs);
        QbarNative.nativeRelease();
      }
      this.hJv.a(arrayOfByte1, this.hJs, this.hJt, this.hJr);
      this.hJv.hJn.set(false);
      AppMethodBeat.o(130978);
      return;
    }
    ab.d("MicroMsg.appbrand.ScanDecoder", "decode isDecoding");
    AppMethodBeat.o(130978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.a.b.1
 * JD-Core Version:    0.7.0.1
 */