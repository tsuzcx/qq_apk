package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import android.graphics.Rect;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qbar.QbarNative;
import java.util.concurrent.atomic.AtomicBoolean;

final class b$1
  implements Runnable
{
  b$1(b paramb, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, Rect paramRect) {}
  
  public final void run()
  {
    if (this.gpr.gpj.compareAndSet(false, true))
    {
      byte[] arrayOfByte1 = this.gpm;
      if ((270 == this.gpn) || (90 == this.gpn))
      {
        byte[] arrayOfByte2 = new byte[this.gpm.length];
        QbarNative.a(arrayOfByte2, this.gpm, this.gpo, this.gpp);
        arrayOfByte1 = new byte[this.gpm.length];
        QbarNative.a(arrayOfByte1, arrayOfByte2, this.gpp, this.gpo);
        QbarNative.nativeRelease();
      }
      this.gpr.b(arrayOfByte1, this.gpo, this.gpp, this.gpn);
      this.gpr.gpj.set(false);
      return;
    }
    y.d("MicroMsg.appbrand.ScanDecoder", "decode isDecoding");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.a.b.1
 * JD-Core Version:    0.7.0.1
 */