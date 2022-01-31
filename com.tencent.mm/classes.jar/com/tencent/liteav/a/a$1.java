package com.tencent.liteav.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(66365);
    if (a.a(this.a) != null) {
      switch (paramMessage.what)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66365);
      return;
      a.a(this.a).a(((Long)paramMessage.obj).longValue());
      AppMethodBeat.o(66365);
      return;
      TXCLog.d("TXCStreamRecord", "record complete. errcode = " + paramMessage.arg1 + ", errmsg = " + (String)paramMessage.obj + ", outputPath = " + a.b(this.a).f + ", coverImage = " + a.b(this.a).g);
      if ((paramMessage.arg1 == 0) && (a.b(this.a).g != null) && (!a.b(this.a).g.isEmpty()) && (!b.a(a.b(this.a).f, a.b(this.a).g))) {
        TXCLog.e("TXCStreamRecord", "saveVideoThumb error. sourcePath = " + a.b(this.a).f + ", coverImagePath = " + a.b(this.a).g);
      }
      if (paramMessage.arg1 != 0) {}
      try
      {
        File localFile = new File(a.b(this.a).f);
        if (localFile.exists()) {
          localFile.delete();
        }
        label296:
        a.a(this.a).a(paramMessage.arg1, (String)paramMessage.obj, a.b(this.a).f, a.b(this.a).g);
      }
      catch (Exception localException)
      {
        break label296;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.a.a.1
 * JD-Core Version:    0.7.0.1
 */