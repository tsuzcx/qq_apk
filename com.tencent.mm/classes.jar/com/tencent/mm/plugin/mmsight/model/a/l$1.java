package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ak;

final class l$1
  implements f
{
  l$1(l paraml) {}
  
  public final boolean N(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(76594);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      AppMethodBeat.o(76594);
      return false;
    }
    if (this.oJt.fcm.oJP == d.c.oIG)
    {
      Object localObject = this.oJt;
      if ((!((l)localObject).fcp) && (((l)localObject).fcC))
      {
        ((l)localObject).fcp = true;
        byte[] arrayOfByte = new byte[paramArrayOfByte.length];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
        d.post(new l.7((l)localObject, arrayOfByte), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
      }
      if (this.oJt.fdi != null)
      {
        localObject = Message.obtain();
        ((Message)localObject).what = 1;
        ((Message)localObject).obj = paramArrayOfByte;
        this.oJt.fdi.sendMessage((Message)localObject);
      }
      AppMethodBeat.o(76594);
      return true;
    }
    AppMethodBeat.o(76594);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.l.1
 * JD-Core Version:    0.7.0.1
 */