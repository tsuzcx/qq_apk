package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.r;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bv;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

final class a$a
  implements Runnable
{
  private String TAG;
  private final r jda;
  private final LinkedList<abn> sKS;
  private int sKT;
  
  public a$a(String paramString, r paramr, LinkedList<abn> paramLinkedList)
  {
    this.TAG = paramString;
    this.jda = paramr;
    this.sKS = paramLinkedList;
  }
  
  public final void run()
  {
    AppMethodBeat.i(122399);
    int i;
    if (this.jda != null)
    {
      i = this.jda.jeB;
      if ((i == 3) || ((!this.jda.cQp) && ((i == 1) || (i == 2) || (i == 8))))
      {
        this.sKT = 0;
        Iterator localIterator = this.sKS.iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = (abn)localIterator.next();
          Object localObject2 = z.a(((abn)localObject1).Lmt);
          if (((abn)localObject1).Lms == 5) {
            try
            {
              localObject1 = ((de)new de().parseFrom((byte[])localObject2)).KHl.toString();
              localObject2 = ((l)g.af(l.class)).aSN().Kn((String)localObject1);
              if ((((String)localObject1).endsWith("@chatroom")) && (((ax)localObject2).fuH == 0)) {
                this.sKT += 1;
              }
            }
            catch (IOException localIOException)
            {
              Log.e(this.TAG, "muteroom idkeyStat: docmd: parse from protobuf to addmsg error, " + localIOException.getMessage());
            }
          }
        }
        if (this.sKT > 0)
        {
          if (this.sKT > 5) {
            break label330;
          }
          e.Cxv.idkeyStat(202L, this.sKT, 1L, false);
          Log.i(this.TAG, "muteroom idkeyStat:muteroomNotNotifyNum = " + this.sKT);
          switch (i)
          {
          }
        }
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "muteroom idkeyStat:aiScene = ".concat(String.valueOf(i)));
      AppMethodBeat.o(122399);
      return;
      label330:
      if (this.sKT <= 10)
      {
        e.Cxv.idkeyStat(202L, 6L, 1L, false);
        break;
      }
      if (this.sKT <= 15)
      {
        e.Cxv.idkeyStat(202L, 7L, 1L, false);
        break;
      }
      if (this.sKT <= 20)
      {
        e.Cxv.idkeyStat(202L, 8L, 1L, false);
        break;
      }
      e.Cxv.idkeyStat(202L, 9L, 1L, false);
      break;
      e.Cxv.idkeyStat(202L, 10L, 1L, false);
      continue;
      e.Cxv.idkeyStat(202L, 11L, 1L, false);
      continue;
      e.Cxv.idkeyStat(202L, 12L, 1L, false);
      continue;
      e.Cxv.idkeyStat(202L, 13L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.a.a
 * JD-Core Version:    0.7.0.1
 */