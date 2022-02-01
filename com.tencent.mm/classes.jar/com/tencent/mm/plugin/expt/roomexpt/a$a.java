package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.r;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bp;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

final class a$a
  implements Runnable
{
  private String TAG;
  private final r ifm;
  private final LinkedList<zu> rbl;
  private int rbm;
  
  public a$a(String paramString, r paramr, LinkedList<zu> paramLinkedList)
  {
    this.TAG = paramString;
    this.ifm = paramr;
    this.rbl = paramLinkedList;
  }
  
  public final void run()
  {
    AppMethodBeat.i(122399);
    int i;
    if (this.ifm != null)
    {
      i = this.ifm.igM;
      if ((i == 3) || ((!this.ifm.cBJ) && ((i == 1) || (i == 2) || (i == 8))))
      {
        this.rbm = 0;
        Iterator localIterator = this.rbl.iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = (zu)localIterator.next();
          Object localObject2 = z.a(((zu)localObject1).FYV);
          if (((zu)localObject1).FYU == 5) {
            try
            {
              localObject1 = ((cv)new cv().parseFrom((byte[])localObject2)).Fvi.toString();
              localObject2 = ((l)g.ab(l.class)).azp().Bf((String)localObject1);
              if ((((String)localObject1).endsWith("@chatroom")) && (((aw)localObject2).ePs == 0)) {
                this.rbm += 1;
              }
            }
            catch (IOException localIOException)
            {
              ad.e(this.TAG, "muteroom idkeyStat: docmd: parse from protobuf to addmsg error, " + localIOException.getMessage());
            }
          }
        }
        if (this.rbm > 0)
        {
          if (this.rbm > 5) {
            break label330;
          }
          e.ygI.idkeyStat(202L, this.rbm, 1L, false);
          ad.i(this.TAG, "muteroom idkeyStat:muteroomNotNotifyNum = " + this.rbm);
          switch (i)
          {
          }
        }
      }
    }
    for (;;)
    {
      ad.i(this.TAG, "muteroom idkeyStat:aiScene = ".concat(String.valueOf(i)));
      AppMethodBeat.o(122399);
      return;
      label330:
      if (this.rbm <= 10)
      {
        e.ygI.idkeyStat(202L, 6L, 1L, false);
        break;
      }
      if (this.rbm <= 15)
      {
        e.ygI.idkeyStat(202L, 7L, 1L, false);
        break;
      }
      if (this.rbm <= 20)
      {
        e.ygI.idkeyStat(202L, 8L, 1L, false);
        break;
      }
      e.ygI.idkeyStat(202L, 9L, 1L, false);
      break;
      e.ygI.idkeyStat(202L, 10L, 1L, false);
      continue;
      e.ygI.idkeyStat(202L, 11L, 1L, false);
      continue;
      e.ygI.idkeyStat(202L, 12L, 1L, false);
      continue;
      e.ygI.idkeyStat(202L, 13L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.a.a
 * JD-Core Version:    0.7.0.1
 */