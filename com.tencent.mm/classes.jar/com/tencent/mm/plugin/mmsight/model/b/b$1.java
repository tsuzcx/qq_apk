package com.tencent.mm.plugin.mmsight.model.b;

import android.os.HandlerThread;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.sdk.g.d;

final class b$1
  implements h
{
  b$1(b paramb) {}
  
  public final void a(byte[] paramArrayOfByte, boolean paramBoolean, long paramLong)
  {
    int i = 1;
    AppMethodBeat.i(76691);
    if (b.a(this.oKb) == null)
    {
      b.a(this.oKb, d.ey("remuxer_encode", -2));
      b.a(this.oKb).start();
      b.a(this.oKb, new b.a(this.oKb, b.a(this.oKb).getLooper()));
    }
    Message localMessage;
    byte[] arrayOfByte;
    if (b.b(this.oKb) != null)
    {
      localMessage = Message.obtain();
      localMessage.what = 1;
      if (paramArrayOfByte == null) {
        break label170;
      }
      arrayOfByte = j.oJp.f(Integer.valueOf(paramArrayOfByte.length));
      if (arrayOfByte != null) {
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, arrayOfByte.length);
      }
      localMessage.obj = arrayOfByte;
      if (!paramBoolean) {
        break label176;
      }
    }
    for (;;)
    {
      localMessage.arg1 = i;
      localMessage.arg2 = ((int)paramLong);
      b.b(this.oKb).sendMessage(localMessage);
      AppMethodBeat.o(76691);
      return;
      label170:
      arrayOfByte = null;
      break;
      label176:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.b.1
 * JD-Core Version:    0.7.0.1
 */