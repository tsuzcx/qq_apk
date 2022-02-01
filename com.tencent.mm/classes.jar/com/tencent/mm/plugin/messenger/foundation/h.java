package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mars.mm.MMLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.d;
import com.tencent.mm.am.s;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.bx.b;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.protocal.protobuf.bg;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.dut;
import com.tencent.mm.protocal.protobuf.ewv;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  implements com.tencent.mm.plugin.zero.a.c
{
  public final void a(NotifyReceiver.NotifyService paramNotifyService, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong)
  {
    AppMethodBeat.i(288636);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(288636);
      return;
      if (paramArrayOfByte1 != null)
      {
        ewv localewv = new ewv();
        try
        {
          localewv.parseFrom(paramArrayOfByte1);
          paramArrayOfByte1 = localewv.Zsu.Op;
          paramNotifyService = paramArrayOfByte1;
          int i;
          if (localewv.TpC != null)
          {
            bf localbf = new bf();
            localbf.parseFrom(localewv.TpC.Op);
            paramNotifyService = paramArrayOfByte1;
            if (localbf.YCp)
            {
              paramNotifyService = localbf.YCq;
              Log.i("MicroMsg.SecurityNotifyReceiverCallback", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData[%d, %d, %d, %d, %d, %d]", new Object[] { Integer.valueOf(paramNotifyService.YCs), Integer.valueOf(paramNotifyService.YCt), Integer.valueOf(paramNotifyService.YCu), Integer.valueOf(paramNotifyService.YCv), Integer.valueOf(paramNotifyService.YCw), Integer.valueOf(paramNotifyService.YCx) });
              if (paramNotifyService.YCs != 13) {
                break label357;
              }
              com.tencent.mm.kernel.h.baF();
              paramArrayOfByte2 = com.tencent.mm.kernel.h.baD().sA(3);
              paramNotifyService = UtilsJni.AesGcmDecryptWithUncompress(paramArrayOfByte2, paramArrayOfByte1);
              if (paramArrayOfByte2 != null) {
                break label343;
              }
              paramInt = -1;
              if (paramNotifyService != null) {
                break label350;
              }
              i = -1;
              label223:
              Log.i("MicroMsg.SecurityNotifyReceiverCallback", "summerbadcr MM_PKT_SILENCE_NOTIFY AES_GCM_ENCRYPT serverSession[%s] data[%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
            }
          }
          for (;;)
          {
            paramArrayOfByte1 = new dut();
            paramArrayOfByte1.parseFrom(paramNotifyService);
            g.d.dB(Integer.valueOf(paramArrayOfByte1.YFg.IIs)).b(new g.a(paramArrayOfByte1.YFg));
            com.tencent.mm.kernel.h.aZW().oun.ackActionNotify("", localewv.abyW, MMLogic.ACTION_ACK_OK);
            Log.i("MicroMsg.SecurityNotifyReceiverCallback", "deal succ, taskid:%d", new Object[] { Long.valueOf(localewv.abyW) });
            AppMethodBeat.o(288636);
            return;
            label343:
            paramInt = paramArrayOfByte2.length;
            break;
            label350:
            i = paramNotifyService.length;
            break label223;
            label357:
            paramNotifyService = MMProtocalJni.decodeSecureNotifyData(paramArrayOfByte2, paramNotifyService.YCs, paramNotifyService.YCt, paramNotifyService.YCu, paramNotifyService.YCv, paramNotifyService.YCw, paramNotifyService.YCx, paramNotifyService.YCy, paramArrayOfByte1);
          }
          if (paramNotifyService == null) {
            continue;
          }
        }
        catch (Exception paramNotifyService)
        {
          Log.printErrStackTrace("MicroMsg.SecurityNotifyReceiverCallback", paramNotifyService, "taskid:%d", new Object[] { Long.valueOf(localewv.abyW) });
          paramNotifyService = com.tencent.mm.kernel.h.aZW();
        }
        paramNotifyService = paramNotifyService.oun;
        if (paramNotifyService != null) {
          paramNotifyService.ackActionNotify("", localewv.abyW, MMLogic.ACTION_ACK_FAILED);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.h
 * JD-Core Version:    0.7.0.1
 */