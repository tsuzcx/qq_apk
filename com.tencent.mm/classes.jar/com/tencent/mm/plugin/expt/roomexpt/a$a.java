package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bj;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

final class a$a
  implements Runnable
{
  private String TAG;
  private final q hMs;
  private final LinkedList<xv> qrS;
  private int qrT;
  
  public a$a(String paramString, q paramq, LinkedList<xv> paramLinkedList)
  {
    this.TAG = paramString;
    this.hMs = paramq;
    this.qrS = paramLinkedList;
  }
  
  public final void run()
  {
    AppMethodBeat.i(122399);
    int i;
    if (this.hMs != null)
    {
      i = this.hMs.hNy;
      if ((i == 3) || ((!this.hMs.cqM) && ((i == 1) || (i == 2) || (i == 8))))
      {
        this.qrT = 0;
        Iterator localIterator = this.qrS.iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = (xv)localIterator.next();
          Object localObject2 = z.a(((xv)localObject1).ErM);
          if (((xv)localObject1).ErL == 5) {
            try
            {
              localObject1 = ((cu)new cu().parseFrom((byte[])localObject2)).DPT.toString();
              localObject2 = ((k)g.ab(k.class)).awB().aNt((String)localObject1);
              if ((((String)localObject1).endsWith("@chatroom")) && (((av)localObject2).exT == 0)) {
                this.qrT += 1;
              }
            }
            catch (IOException localIOException)
            {
              ac.e(this.TAG, "muteroom idkeyStat: docmd: parse from protobuf to addmsg error, " + localIOException.getMessage());
            }
          }
        }
        if (this.qrT > 0)
        {
          if (this.qrT > 5) {
            break label330;
          }
          e.wTc.idkeyStat(202L, this.qrT, 1L, false);
          ac.i(this.TAG, "muteroom idkeyStat:muteroomNotNotifyNum = " + this.qrT);
          switch (i)
          {
          }
        }
      }
    }
    for (;;)
    {
      ac.i(this.TAG, "muteroom idkeyStat:aiScene = ".concat(String.valueOf(i)));
      AppMethodBeat.o(122399);
      return;
      label330:
      if (this.qrT <= 10)
      {
        e.wTc.idkeyStat(202L, 6L, 1L, false);
        break;
      }
      if (this.qrT <= 15)
      {
        e.wTc.idkeyStat(202L, 7L, 1L, false);
        break;
      }
      if (this.qrT <= 20)
      {
        e.wTc.idkeyStat(202L, 8L, 1L, false);
        break;
      }
      e.wTc.idkeyStat(202L, 9L, 1L, false);
      break;
      e.wTc.idkeyStat(202L, 10L, 1L, false);
      continue;
      e.wTc.idkeyStat(202L, 11L, 1L, false);
      continue;
      e.wTc.idkeyStat(202L, 12L, 1L, false);
      continue;
      e.wTc.idkeyStat(202L, 13L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.a.a
 * JD-Core Version:    0.7.0.1
 */