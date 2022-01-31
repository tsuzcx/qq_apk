package com.tencent.mm.bj;

import android.graphics.Point;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class h$a
  extends ak
{
  private Point fZm = null;
  
  public h$a(h paramh, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    AppMethodBeat.i(50946);
    byte[] arrayOfByte;
    long l;
    int i;
    int j;
    if (paramMessage.what == h.access$100())
    {
      arrayOfByte = (byte[])paramMessage.obj;
      if (paramMessage.arg1 != 1) {
        break label165;
      }
      l = paramMessage.arg2;
      if (h.a(this.fZl) != null)
      {
        this.fZm = h.b(this.fZl).amc();
        if (h.c(this.fZl) == null) {
          break label171;
        }
        i = h.c(this.fZl).getInteger("width");
        j = h.c(this.fZl).getInteger("height");
      }
    }
    for (;;)
    {
      h.a(this.fZl).a(arrayOfByte, i, j, this.fZm.x, this.fZm.y, bool, l, h.b(this.fZl).amd());
      b.fYm.O(arrayOfByte);
      AppMethodBeat.o(50946);
      return;
      label165:
      bool = false;
      break;
      label171:
      j = 0;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bj.h.a
 * JD-Core Version:    0.7.0.1
 */