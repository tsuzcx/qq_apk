package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bg;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

final class a$a
  implements Runnable
{
  private String TAG;
  private final q hlP;
  private final LinkedList<xd> pJl;
  private int pJm;
  
  public a$a(String paramString, q paramq, LinkedList<xd> paramLinkedList)
  {
    this.TAG = paramString;
    this.hlP = paramq;
    this.pJl = paramLinkedList;
  }
  
  public final void run()
  {
    AppMethodBeat.i(122399);
    int i;
    if (this.hlP != null)
    {
      i = this.hlP.hmV;
      if ((i == 3) || ((!this.hlP.ctF) && ((i == 1) || (i == 2) || (i == 8))))
      {
        this.pJm = 0;
        Iterator localIterator = this.pJl.iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = (xd)localIterator.next();
          Object localObject2 = z.a(((xd)localObject1).CYZ);
          if (((xd)localObject1).CYY == 5) {
            try
            {
              localObject1 = ((cs)new cs().parseFrom((byte[])localObject2)).Cxx.toString();
              localObject2 = ((k)g.ab(k.class)).apM().aHY((String)localObject1);
              if ((((String)localObject1).endsWith("@chatroom")) && (((au)localObject2).evx == 0)) {
                this.pJm += 1;
              }
            }
            catch (IOException localIOException)
            {
              ad.e(this.TAG, "muteroom idkeyStat: docmd: parse from protobuf to addmsg error, " + localIOException.getMessage());
            }
          }
        }
        if (this.pJm > 0)
        {
          if (this.pJm > 5) {
            break label330;
          }
          e.vIY.idkeyStat(202L, this.pJm, 1L, false);
          ad.i(this.TAG, "muteroom idkeyStat:muteroomNotNotifyNum = " + this.pJm);
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
      if (this.pJm <= 10)
      {
        e.vIY.idkeyStat(202L, 6L, 1L, false);
        break;
      }
      if (this.pJm <= 15)
      {
        e.vIY.idkeyStat(202L, 7L, 1L, false);
        break;
      }
      if (this.pJm <= 20)
      {
        e.vIY.idkeyStat(202L, 8L, 1L, false);
        break;
      }
      e.vIY.idkeyStat(202L, 9L, 1L, false);
      break;
      e.vIY.idkeyStat(202L, 10L, 1L, false);
      continue;
      e.vIY.idkeyStat(202L, 11L, 1L, false);
      continue;
      e.vIY.idkeyStat(202L, 12L, 1L, false);
      continue;
      e.vIY.idkeyStat(202L, 13L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.a.a
 * JD-Core Version:    0.7.0.1
 */