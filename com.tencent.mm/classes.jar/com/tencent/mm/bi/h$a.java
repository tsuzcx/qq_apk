package com.tencent.mm.bi;

import android.graphics.Point;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;

final class h$a
  extends ah
{
  private Point eJJ = null;
  
  public h$a(h paramh, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    byte[] arrayOfByte;
    long l;
    int i;
    int j;
    if (paramMessage.what == h.access$100())
    {
      arrayOfByte = (byte[])paramMessage.obj;
      if (paramMessage.arg1 != 1) {
        break label155;
      }
      l = paramMessage.arg2;
      if (h.a(this.eJI) != null)
      {
        this.eJJ = h.b(this.eJI).SP();
        if (h.c(this.eJI) == null) {
          break label161;
        }
        i = h.c(this.eJI).getInteger("width");
        j = h.c(this.eJI).getInteger("height");
      }
    }
    for (;;)
    {
      h.a(this.eJI).a(arrayOfByte, i, j, this.eJJ.x, this.eJJ.y, bool, l, h.b(this.eJI).SQ());
      b.eIx.z(arrayOfByte);
      return;
      label155:
      bool = false;
      break;
      label161:
      j = 0;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bi.h.a
 * JD-Core Version:    0.7.0.1
 */