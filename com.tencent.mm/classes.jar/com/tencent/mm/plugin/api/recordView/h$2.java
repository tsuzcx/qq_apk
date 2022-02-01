package com.tencent.mm.plugin.api.recordView;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

final class h$2
  implements Runnable
{
  h$2(h paramh, byte[] paramArrayOfByte, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(89271);
    i locali = this.qqK.qqF;
    byte[] arrayOfByte = this.val$data;
    int j = this.qqK.qpD;
    int k = this.qqK.qpE;
    int m = this.qqK.nKn;
    int n = this.qqL;
    try
    {
      if ((locali.qpE != k) || (locali.qpD != j) || (locali.hYK != m)) {
        break label447;
      }
      if (locali.qpM == n) {
        break label442;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.YUVDateRenderToRGBBufferRenderer", "setDrawFrame error: %s", new Object[] { localException.getMessage() });
        continue;
        int i = 0;
        continue;
        i = 1;
      }
    }
    if (i != 0) {
      Log.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[] { arrayOfByte, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(locali.nKe), Boolean.TRUE, locali });
    }
    if ((locali.frameData == null) || (locali.frameData.length != arrayOfByte.length)) {
      locali.frameData = new byte[arrayOfByte.length];
    }
    System.arraycopy(arrayOfByte, 0, locali.frameData, 0, arrayOfByte.length);
    locali.qpD = j;
    locali.qpE = k;
    locali.hYK = m;
    locali.qpM = n;
    if (i != 0)
    {
      locali.nEJ = ByteBuffer.allocateDirect(k * j);
      locali.nEQ = ByteBuffer.allocateDirect(j * k / 2);
      locali.nEJ.order(ByteOrder.nativeOrder());
      locali.nEQ.order(ByteOrder.nativeOrder());
      if (locali.qpK != null)
      {
        locali.mVV.put(locali.qpK);
        locali.mVV.position(0);
      }
    }
    if ((locali.nEJ != null) && (locali.nEQ != null))
    {
      locali.nEJ.put(locali.frameData, 0, j * k);
      locali.nEJ.position(0);
      locali.nEQ.put(locali.frameData, j * k, j * k / 2);
      locali.nEQ.position(0);
    }
    this.qqK.qqF.onDrawFrame(null);
    this.qqK.qqG.cbc();
    AppMethodBeat.o(89271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.h.2
 * JD-Core Version:    0.7.0.1
 */