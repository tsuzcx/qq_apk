package com.tencent.mm.plugin.cloudvoip.cloudvoice.service;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class q$1
  extends MMHandler
{
  TelephonyManager wVW;
  PhoneStateListener wVX;
  
  q$1(q paramq, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(184471);
    super.handleMessage(paramMessage);
    if (paramMessage.what == 272)
    {
      if (this.wVW == null)
      {
        this.wVW = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
        this.wVX = new PhoneStateListener()
        {
          public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(184470);
            super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
            switch (paramAnonymousInt)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(184470);
              return;
              q.1.this.wVY.au(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(184469);
                  Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: hy: phone broken. exit room if in room");
                  q.a(q.1.this.wVY, q.a.wWQ);
                  AppMethodBeat.o(184469);
                }
              });
            }
          }
        };
      }
      paramMessage = this.wVW;
      Object localObject = this.wVX;
      localObject = c.a(32, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramMessage, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/cloudvoip/cloudvoice/service/OpenVoiceService$1", "handleMessage", "(Landroid/os/Message;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      paramMessage.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramMessage, "com/tencent/mm/plugin/cloudvoip/cloudvoice/service/OpenVoiceService$1", "handleMessage", "(Landroid/os/Message;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    }
    AppMethodBeat.o(184471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q.1
 * JD-Core Version:    0.7.0.1
 */