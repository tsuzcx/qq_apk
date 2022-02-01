package com.tencent.mm.plugin.cast.d;

import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage", "com/tencent/mm/plugin/cast/manager/ScreenCastManager$initTcpTransport$1$1"})
final class a$c
  implements MMHandler.Callback
{
  a$c(a parama) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    int j = 0;
    AppMethodBeat.i(189589);
    p.j(paramMessage, "it");
    paramMessage = paramMessage.getData();
    byte b;
    int i;
    if (paramMessage != null)
    {
      b = paramMessage.getByte("data_type");
      paramMessage = paramMessage.getByteArray("data_data");
      if (paramMessage == null) {
        break label83;
      }
      i = 1;
      if (i == 0) {
        break label88;
      }
      label47:
      if (paramMessage != null) {
        switch (b)
        {
        }
      }
    }
    label296:
    label299:
    for (;;)
    {
      AppMethodBeat.o(189589);
      return true;
      label83:
      i = 0;
      break;
      label88:
      paramMessage = null;
      break label47;
      Log.i("MicroMsg.ScreenCastManager", "onVideoFrame Ready");
      com.tencent.mm.plugin.cast.h.b localb = this.tJB.tJx;
      if (localb != null)
      {
        paramMessage = Integer.valueOf(localb.a(b, paramMessage));
        i = j;
        if (((Number)paramMessage).intValue() != 0) {
          i = 1;
        }
        if (i != 0) {}
        while (paramMessage != null)
        {
          ((Number)paramMessage).intValue();
          this.tJB.tJy = com.tencent.mm.plugin.cast.h.a.b.tKw;
          paramMessage = this.tJB.tJz;
          if (paramMessage == null) {
            break;
          }
          paramMessage.invoke(com.tencent.mm.plugin.cast.h.a.b.tKw);
          break;
          paramMessage = null;
        }
        Log.i("MicroMsg.ScreenCastManager", "onAudioFrame Ready");
        localb = this.tJB.tJx;
        if (localb != null)
        {
          paramMessage = Integer.valueOf(localb.a(b, paramMessage));
          if (((Number)paramMessage).intValue() != 0)
          {
            i = 1;
            label240:
            if (i == 0) {
              break label296;
            }
          }
          for (;;)
          {
            if (paramMessage == null) {
              break label299;
            }
            ((Number)paramMessage).intValue();
            this.tJB.tJy = com.tencent.mm.plugin.cast.h.a.b.tKw;
            paramMessage = this.tJB.tJz;
            if (paramMessage == null) {
              break;
            }
            paramMessage.invoke(com.tencent.mm.plugin.cast.h.a.b.tKw);
            break;
            i = 0;
            break label240;
            paramMessage = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.d.a.c
 * JD-Core Version:    0.7.0.1
 */