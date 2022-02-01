package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.qbar.QbarNative.QBarPoint;
import com.tencent.qbar.d;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class b
{
  AtomicBoolean kIr = new AtomicBoolean(false);
  a kIs;
  ap kIt = new ap("MicroMsg.appbrand.ScanDecoder");
  
  public b(a parama)
  {
    this.kIs = parama;
  }
  
  protected final void a(final String paramString, final int paramInt1, final int paramInt2, final byte[] paramArrayOfByte, final QbarNative.QBarPoint paramQBarPoint)
  {
    ad.d("MicroMsg.appbrand.ScanDecoder", "result:%b, resultText:%s, resultType:%d, codeType:%d, codeVersion:%d", new Object[] { Boolean.TRUE, paramString, Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2) });
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46235);
        if (b.this.kIs != null) {
          b.this.kIs.a(paramInt1, paramString, paramInt2, paramArrayOfByte, paramQBarPoint);
        }
        AppMethodBeat.o(46235);
      }
    });
  }
  
  abstract boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Point paramPoint, Rect paramRect, int paramInt5, int paramInt6);
  
  abstract void init();
  
  abstract void release();
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, String paramString, int paramInt2, byte[] paramArrayOfByte, QbarNative.QBarPoint paramQBarPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.a.b
 * JD-Core Version:    0.7.0.1
 */