package com.tencent.mm.plugin.appbrand.widget.input.c;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;

final class a$1
  extends ah
{
  a$1(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (1000 == paramMessage.what)
    {
      String str = (String)paramMessage.obj;
      int i = paramMessage.arg1;
      if (this.hxx.hxw != null) {
        this.hxx.hxw.aQ(str, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.c.a.1
 * JD-Core Version:    0.7.0.1
 */