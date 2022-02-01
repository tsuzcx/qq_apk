package com.tencent.mm.plugin.flutter.d;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashMap;
import java.util.Map;

final class f$b$1
  extends ao
{
  f$b$1(f.b paramb) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(209689);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(209689);
      return;
      paramMessage = this.smU;
      ac.d("MicroMsg.FlutterVideoPlayerPlugin", "FlutterThumb [buffering prepare]");
      if (paramMessage.smS != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("event", "preparing");
        paramMessage.smS.db(localHashMap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.d.f.b.1
 * JD-Core Version:    0.7.0.1
 */