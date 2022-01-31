package com.tencent.mm.plugin.api.recordView;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

final class h$2
  implements Runnable
{
  h$2(h paramh, byte[] paramArrayOfByte, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(76387);
    i locali = this.gOE.gOy;
    byte[] arrayOfByte = this.val$data;
    int j = this.gOE.gNA;
    int k = this.gOE.gNB;
    int m = this.gOE.fbz;
    int n = this.gOF;
    try
    {
      if ((locali.gNB != k) || (locali.gNA != j) || (locali.rotate != m)) {
        break label403;
      }
      if (locali.gNH == n) {
        break label398;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.YUVDateRenderToRGBBufferRenderer", "setDrawFrame error: %s", new Object[] { localException.getMessage() });
        continue;
        int i = 0;
        continue;
        i = 1;
      }
    }
    if (i != 0) {
      ab.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[] { arrayOfByte, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(locali.fcx), Boolean.TRUE, locali });
    }
    locali.frameData = arrayOfByte;
    locali.gNA = j;
    locali.gNB = k;
    locali.rotate = m;
    locali.gNH = n;
    if (i != 0)
    {
      locali.eZm = ByteBuffer.allocateDirect(k * j);
      locali.eZn = ByteBuffer.allocateDirect(j * k / 2);
      locali.eZm.order(ByteOrder.nativeOrder());
      locali.eZn.order(ByteOrder.nativeOrder());
      if (locali.gNF != null)
      {
        locali.eYv.put(locali.gNF);
        locali.eYv.position(0);
      }
    }
    if ((locali.eZm != null) && (locali.eZn != null))
    {
      locali.eZm.put(arrayOfByte, 0, j * k);
      locali.eZm.position(0);
      locali.eZn.put(arrayOfByte, j * k, j * k / 2);
      locali.eZn.position(0);
    }
    this.gOE.gOy.onDrawFrame(null);
    this.gOE.gOz.asU();
    AppMethodBeat.o(76387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.h.2
 * JD-Core Version:    0.7.0.1
 */