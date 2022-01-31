package com.tencent.liteav.screencapture;

import android.os.Bundle;
import com.tencent.liteav.basic.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

class b$6
  implements Runnable
{
  b$6(b paramb) {}
  
  public void run()
  {
    AppMethodBeat.i(66770);
    if (b.h(this.a) != null)
    {
      a locala = (a)b.h(this.a).get();
      if (locala != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("EVT_MSG", "录屏启动成功");
        locala.onNotifyEvent(1004, localBundle);
      }
    }
    AppMethodBeat.o(66770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.screencapture.b.6
 * JD-Core Version:    0.7.0.1
 */