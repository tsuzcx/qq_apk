package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic.TaskCallback;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.dhh;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;

final class g$3$a
  implements SimpleHttpLogic.TaskCallback
{
  g$3$a(g.3 param3) {}
  
  public final void onCompleted(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(195280);
    Log.i("simple", "errorType: %d, errorCode:%d, result is %s , length %d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfByte, Integer.valueOf(paramArrayOfByte.length) });
    try
    {
      PByteArray localPByteArray = new PByteArray();
      boolean bool = SimpleHttpLogic.unpackResponse(paramArrayOfByte, localPByteArray);
      Log.e("simple", "unpack result ".concat(String.valueOf(bool)));
      if (bool)
      {
        paramArrayOfByte = new dhh();
        paramArrayOfByte.parseFrom(localPByteArray.value);
        if ((paramArrayOfByte.BaseResponse != null) && (paramArrayOfByte.TOo != null) && (paramArrayOfByte.GIL != null))
        {
          Log.e("simple", "response is " + paramArrayOfByte.BaseResponse.CqV + " error msg " + paramArrayOfByte.BaseResponse.Tef);
          Log.e("simple", "response base id is " + paramArrayOfByte.TOo + " error msg " + paramArrayOfByte.GIL);
        }
      }
      AppMethodBeat.o(195280);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("simple", "unpack failed. " + paramArrayOfByte.getLocalizedMessage());
      AppMethodBeat.o(195280);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.g.3.a
 * JD-Core Version:    0.7.0.1
 */