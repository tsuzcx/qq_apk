package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.r;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bq;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

final class a$a
  implements Runnable
{
  private String TAG;
  private final r iif;
  private final LinkedList<zx> rjr;
  private int rjs;
  
  public a$a(String paramString, r paramr, LinkedList<zx> paramLinkedList)
  {
    this.TAG = paramString;
    this.iif = paramr;
    this.rjr = paramLinkedList;
  }
  
  public final void run()
  {
    AppMethodBeat.i(122399);
    int i;
    if (this.iif != null)
    {
      i = this.iif.ijF;
      if ((i == 3) || ((!this.iif.cCq) && ((i == 1) || (i == 2) || (i == 8))))
      {
        this.rjs = 0;
        Iterator localIterator = this.rjr.iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = (zx)localIterator.next();
          Object localObject2 = z.a(((zx)localObject1).Grv);
          if (((zx)localObject1).Gru == 5) {
            try
            {
              localObject1 = ((cv)new cv().parseFrom((byte[])localObject2)).FNG.toString();
              localObject2 = ((l)g.ab(l.class)).azF().BH((String)localObject1);
              if ((((String)localObject1).endsWith("@chatroom")) && (((aw)localObject2).eRd == 0)) {
                this.rjs += 1;
              }
            }
            catch (IOException localIOException)
            {
              ae.e(this.TAG, "muteroom idkeyStat: docmd: parse from protobuf to addmsg error, " + localIOException.getMessage());
            }
          }
        }
        if (this.rjs > 0)
        {
          if (this.rjs > 5) {
            break label330;
          }
          e.ywz.idkeyStat(202L, this.rjs, 1L, false);
          ae.i(this.TAG, "muteroom idkeyStat:muteroomNotNotifyNum = " + this.rjs);
          switch (i)
          {
          }
        }
      }
    }
    for (;;)
    {
      ae.i(this.TAG, "muteroom idkeyStat:aiScene = ".concat(String.valueOf(i)));
      AppMethodBeat.o(122399);
      return;
      label330:
      if (this.rjs <= 10)
      {
        e.ywz.idkeyStat(202L, 6L, 1L, false);
        break;
      }
      if (this.rjs <= 15)
      {
        e.ywz.idkeyStat(202L, 7L, 1L, false);
        break;
      }
      if (this.rjs <= 20)
      {
        e.ywz.idkeyStat(202L, 8L, 1L, false);
        break;
      }
      e.ywz.idkeyStat(202L, 9L, 1L, false);
      break;
      e.ywz.idkeyStat(202L, 10L, 1L, false);
      continue;
      e.ywz.idkeyStat(202L, 11L, 1L, false);
      continue;
      e.ywz.idkeyStat(202L, 12L, 1L, false);
      continue;
      e.ywz.idkeyStat(202L, 13L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.a.a
 * JD-Core Version:    0.7.0.1
 */