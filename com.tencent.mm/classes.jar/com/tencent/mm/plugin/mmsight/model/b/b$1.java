package com.tencent.mm.plugin.mmsight.model.b;

import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.sdk.f.e;

final class b$1
  implements h
{
  b$1(b paramb) {}
  
  public final void a(byte[] paramArrayOfByte, boolean paramBoolean, long paramLong)
  {
    int i = 1;
    if (b.a(this.mkW) == null)
    {
      b.a(this.mkW, e.ds("remuxer_encode", -2));
      b.a(this.mkW).start();
      b.a(this.mkW, new b.a(this.mkW, b.a(this.mkW).getLooper()));
    }
    Message localMessage;
    byte[] arrayOfByte;
    if (b.b(this.mkW) != null)
    {
      localMessage = Message.obtain();
      localMessage.what = 1;
      if (paramArrayOfByte == null) {
        break label160;
      }
      arrayOfByte = j.mji.f(Integer.valueOf(paramArrayOfByte.length));
      if (arrayOfByte != null) {
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, arrayOfByte.length);
      }
      localMessage.obj = arrayOfByte;
      if (!paramBoolean) {
        break label166;
      }
    }
    for (;;)
    {
      localMessage.arg1 = i;
      localMessage.arg2 = ((int)paramLong);
      b.b(this.mkW).sendMessage(localMessage);
      return;
      label160:
      arrayOfByte = null;
      break;
      label166:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.b.1
 * JD-Core Version:    0.7.0.1
 */