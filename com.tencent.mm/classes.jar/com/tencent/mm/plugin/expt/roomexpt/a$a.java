package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelmulti.r;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bv;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

final class a$a
  implements Runnable
{
  private String TAG;
  private final r lTz;
  private final LinkedList<abu> wqP;
  private int wqQ;
  
  public a$a(String paramString, r paramr, LinkedList<abu> paramLinkedList)
  {
    this.TAG = paramString;
    this.lTz = paramr;
    this.wqP = paramLinkedList;
  }
  
  public final void run()
  {
    AppMethodBeat.i(122399);
    int i;
    if (this.lTz != null)
    {
      i = this.lTz.lVa;
      if ((i == 3) || ((!this.lTz.dgo) && ((i == 1) || (i == 2) || (i == 8))))
      {
        this.wqQ = 0;
        Iterator localIterator = this.wqP.iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = (abu)localIterator.next();
          Object localObject2 = z.a(((abu)localObject1).SnH);
          if (((abu)localObject1).SnG == 5) {
            try
            {
              localObject1 = ((db)new db().parseFrom((byte[])localObject2)).RID.toString();
              localObject2 = ((n)h.ae(n.class)).bbL().RG((String)localObject1);
              if ((((String)localObject1).endsWith("@chatroom")) && (((ax)localObject2).hDj == 0)) {
                this.wqQ += 1;
              }
            }
            catch (IOException localIOException)
            {
              Log.e(this.TAG, "muteroom idkeyStat: docmd: parse from protobuf to addmsg error, " + localIOException.getMessage());
            }
          }
        }
        if (this.wqQ > 0)
        {
          if (this.wqQ > 5) {
            break label330;
          }
          f.Iyx.idkeyStat(202L, this.wqQ, 1L, false);
          Log.i(this.TAG, "muteroom idkeyStat:muteroomNotNotifyNum = " + this.wqQ);
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
      if (this.wqQ <= 10)
      {
        f.Iyx.idkeyStat(202L, 6L, 1L, false);
        break;
      }
      if (this.wqQ <= 15)
      {
        f.Iyx.idkeyStat(202L, 7L, 1L, false);
        break;
      }
      if (this.wqQ <= 20)
      {
        f.Iyx.idkeyStat(202L, 8L, 1L, false);
        break;
      }
      f.Iyx.idkeyStat(202L, 9L, 1L, false);
      break;
      f.Iyx.idkeyStat(202L, 10L, 1L, false);
      continue;
      f.Iyx.idkeyStat(202L, 11L, 1L, false);
      continue;
      f.Iyx.idkeyStat(202L, 12L, 1L, false);
      continue;
      f.Iyx.idkeyStat(202L, 13L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.a.a
 * JD-Core Version:    0.7.0.1
 */