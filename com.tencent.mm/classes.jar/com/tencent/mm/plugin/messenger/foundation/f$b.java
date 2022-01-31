package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

final class f$b
  implements Runnable
{
  private String TAG;
  private final p esZ;
  private final LinkedList<qv> jZU;
  private int mcZ;
  
  public f$b(String paramString, p paramp, LinkedList<qv> paramLinkedList)
  {
    this.TAG = paramString;
    this.esZ = paramp;
    this.jZU = paramLinkedList;
  }
  
  public final void run()
  {
    int i;
    if (this.esZ != null)
    {
      i = this.esZ.eug;
      if ((i == 3) || ((!this.esZ.euf) && ((i == 1) || (i == 2) || (i == 8))))
      {
        this.mcZ = 0;
        Iterator localIterator = this.jZU.iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = (qv)localIterator.next();
          Object localObject2 = aa.a(((qv)localObject1).sOB);
          if (((qv)localObject1).sOA == 5) {
            try
            {
              localObject1 = ((cd)new cd().aH((byte[])localObject2)).svF.toString();
              localObject2 = ((j)g.r(j.class)).Fw().abl((String)localObject1);
              if ((((String)localObject1).endsWith("@chatroom")) && (((ao)localObject2).cCy == 0)) {
                this.mcZ += 1;
              }
            }
            catch (IOException localIOException)
            {
              y.e(this.TAG, "muteroom idkeyStat: docmd: parse from protobuf to addmsg error, " + localIOException.getMessage());
            }
          }
        }
        if (this.mcZ > 0)
        {
          if (this.mcZ > 5) {
            break label328;
          }
          f.nEG.a(202L, this.mcZ, 1L, false);
          y.i(this.TAG, "muteroom idkeyStat:muteroomNotNotifyNum = " + this.mcZ);
          switch (i)
          {
          }
        }
      }
    }
    for (;;)
    {
      y.i(this.TAG, "muteroom idkeyStat:aiScene = " + i);
      return;
      label328:
      if (this.mcZ <= 10)
      {
        f.nEG.a(202L, 6L, 1L, false);
        break;
      }
      if (this.mcZ <= 15)
      {
        f.nEG.a(202L, 7L, 1L, false);
        break;
      }
      if (this.mcZ <= 20)
      {
        f.nEG.a(202L, 8L, 1L, false);
        break;
      }
      f.nEG.a(202L, 9L, 1L, false);
      break;
      f.nEG.a(202L, 10L, 1L, false);
      continue;
      f.nEG.a(202L, 11L, 1L, false);
      continue;
      f.nEG.a(202L, 12L, 1L, false);
      continue;
      f.nEG.a(202L, 13L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.f.b
 * JD-Core Version:    0.7.0.1
 */