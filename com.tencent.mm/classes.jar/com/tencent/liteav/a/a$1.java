package com.tencent.liteav.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.File;

class a$1
  extends Handler
{
  a$1(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (a.a(this.a) != null) {}
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      a.a(this.a).a(((Long)paramMessage.obj).longValue());
      return;
    }
    TXCLog.d("TXCStreamRecord", "record complete. errcode = " + paramMessage.arg1 + ", errmsg = " + (String)paramMessage.obj + ", outputPath = " + a.b(this.a).f + ", coverImage = " + a.b(this.a).g);
    if ((paramMessage.arg1 == 0) && (a.b(this.a).g != null) && (!a.b(this.a).g.isEmpty()) && (!com.tencent.liteav.basic.util.a.a(a.b(this.a).f, a.b(this.a).g))) {
      TXCLog.e("TXCStreamRecord", "saveVideoThumb error. sourcePath = " + a.b(this.a).f + ", coverImagePath = " + a.b(this.a).g);
    }
    if (paramMessage.arg1 != 0) {}
    try
    {
      File localFile = new File(a.b(this.a).f);
      if (localFile.exists()) {
        localFile.delete();
      }
      label282:
      a.a(this.a).a(paramMessage.arg1, (String)paramMessage.obj, a.b(this.a).f, a.b(this.a).g);
      return;
    }
    catch (Exception localException)
    {
      break label282;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.a.a.1
 * JD-Core Version:    0.7.0.1
 */