package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

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
  TelephonyManager tSE;
  PhoneStateListener tSF;
  
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
      if (this.tSE == null)
      {
        this.tSE = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
        this.tSF = new PhoneStateListener()
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
              q.1.this.tSG.am(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(184469);
                  Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: hy: phone broken. exit room if in room");
                  q.a(q.1.this.tSG, q.a.tTz);
                  AppMethodBeat.o(184469);
                }
              });
            }
          }
        };
      }
      paramMessage = this.tSE;
      Object localObject = this.tSF;
      localObject = c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramMessage, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/cloudvoip/cloudvoice/service/OpenVoiceService$1", "handleMessage", "(Landroid/os/Message;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      paramMessage.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramMessage, "com/tencent/mm/plugin/cloudvoip/cloudvoice/service/OpenVoiceService$1", "handleMessage", "(Landroid/os/Message;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    }
    AppMethodBeat.o(184471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.1
 * JD-Core Version:    0.7.0.1
 */