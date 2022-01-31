package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bd;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

final class a$a
  implements Runnable
{
  private String TAG;
  private final p fIM;
  private final LinkedList<ud> mcO;
  private int mcP;
  
  public a$a(String paramString, p paramp, LinkedList<ud> paramLinkedList)
  {
    this.TAG = paramString;
    this.fIM = paramp;
    this.mcO = paramLinkedList;
  }
  
  public final void run()
  {
    AppMethodBeat.i(152436);
    int i;
    if (this.fIM != null)
    {
      i = this.fIM.fJS;
      if ((i == 3) || ((!this.fIM.bSe) && ((i == 1) || (i == 2) || (i == 8))))
      {
        this.mcP = 0;
        Iterator localIterator = this.mcO.iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = (ud)localIterator.next();
          Object localObject2 = aa.a(((ud)localObject1).wMD);
          if (((ud)localObject1).wMC == 5) {
            try
            {
              localObject1 = ((cm)new cm().parseFrom((byte[])localObject2)).woP.toString();
              localObject2 = ((j)g.E(j.class)).YA().arw((String)localObject1);
              if ((((String)localObject1).endsWith("@chatroom")) && (((aq)localObject2).dqK == 0)) {
                this.mcP += 1;
              }
            }
            catch (IOException localIOException)
            {
              ab.e(this.TAG, "muteroom idkeyStat: docmd: parse from protobuf to addmsg error, " + localIOException.getMessage());
            }
          }
        }
        if (this.mcP > 0)
        {
          if (this.mcP > 5) {
            break label330;
          }
          e.qrI.idkeyStat(202L, this.mcP, 1L, false);
          ab.i(this.TAG, "muteroom idkeyStat:muteroomNotNotifyNum = " + this.mcP);
          switch (i)
          {
          }
        }
      }
    }
    for (;;)
    {
      ab.i(this.TAG, "muteroom idkeyStat:aiScene = ".concat(String.valueOf(i)));
      AppMethodBeat.o(152436);
      return;
      label330:
      if (this.mcP <= 10)
      {
        e.qrI.idkeyStat(202L, 6L, 1L, false);
        break;
      }
      if (this.mcP <= 15)
      {
        e.qrI.idkeyStat(202L, 7L, 1L, false);
        break;
      }
      if (this.mcP <= 20)
      {
        e.qrI.idkeyStat(202L, 8L, 1L, false);
        break;
      }
      e.qrI.idkeyStat(202L, 9L, 1L, false);
      break;
      e.qrI.idkeyStat(202L, 10L, 1L, false);
      continue;
      e.qrI.idkeyStat(202L, 11L, 1L, false);
      continue;
      e.qrI.idkeyStat(202L, 12L, 1L, false);
      continue;
      e.qrI.idkeyStat(202L, 13L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.a.a
 * JD-Core Version:    0.7.0.1
 */