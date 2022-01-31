package com.tencent.mm.media.widget.b;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.s;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ak;

final class e$1
  implements f
{
  e$1(e parame) {}
  
  public final boolean N(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(152044);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      AppMethodBeat.o(152044);
      return false;
    }
    if (this.fdq.fcm.oJP == d.c.oIG)
    {
      Object localObject = this.fdq;
      if ((!((e)localObject).fcp) && (((e)localObject).fcC))
      {
        ((e)localObject).fcp = true;
        byte[] arrayOfByte = new byte[paramArrayOfByte.length];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
        d.post(new e.7((e)localObject, arrayOfByte), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
      }
      if (this.fdq.fdi != null)
      {
        localObject = Message.obtain();
        ((Message)localObject).what = 1;
        ((Message)localObject).obj = paramArrayOfByte;
        this.fdq.fdi.sendMessage((Message)localObject);
      }
      AppMethodBeat.o(152044);
      return true;
    }
    AppMethodBeat.o(152044);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.e.1
 * JD-Core Version:    0.7.0.1
 */