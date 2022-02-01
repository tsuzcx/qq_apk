package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelmulti.x;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bx;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

final class a$a
  implements Runnable
{
  private String TAG;
  private final x oMs;
  private final LinkedList<adw> zMR;
  private int zMS;
  
  public a$a(String paramString, x paramx, LinkedList<adw> paramLinkedList)
  {
    this.TAG = paramString;
    this.oMs = paramx;
    this.zMR = paramLinkedList;
  }
  
  public final void run()
  {
    AppMethodBeat.i(122399);
    int i;
    if (this.oMs != null)
    {
      i = this.oMs.oOc;
      if ((i == 3) || ((!this.oMs.ffv) && ((i == 1) || (i == 2) || (i == 8))))
      {
        this.zMS = 0;
        Iterator localIterator = this.zMR.iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = (adw)localIterator.next();
          Object localObject2 = w.a(((adw)localObject1).Zmd);
          if (((adw)localObject1).Zmc == 5) {
            try
            {
              localObject1 = ((dl)new dl().parseFrom((byte[])localObject2)).YFE.toString();
              localObject2 = ((n)h.ax(n.class)).bzA().JE((String)localObject1);
              if ((((String)localObject1).endsWith("@chatroom")) && (((az)localObject2).kaf == 0)) {
                this.zMS += 1;
              }
            }
            catch (IOException localIOException)
            {
              Log.e(this.TAG, "muteroom idkeyStat: docmd: parse from protobuf to addmsg error, " + localIOException.getMessage());
            }
          }
        }
        if (this.zMS > 0)
        {
          if (this.zMS > 5) {
            break label330;
          }
          f.Ozc.idkeyStat(202L, this.zMS, 1L, false);
          Log.i(this.TAG, "muteroom idkeyStat:muteroomNotNotifyNum = " + this.zMS);
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
      if (this.zMS <= 10)
      {
        f.Ozc.idkeyStat(202L, 6L, 1L, false);
        break;
      }
      if (this.zMS <= 15)
      {
        f.Ozc.idkeyStat(202L, 7L, 1L, false);
        break;
      }
      if (this.zMS <= 20)
      {
        f.Ozc.idkeyStat(202L, 8L, 1L, false);
        break;
      }
      f.Ozc.idkeyStat(202L, 9L, 1L, false);
      break;
      f.Ozc.idkeyStat(202L, 10L, 1L, false);
      continue;
      f.Ozc.idkeyStat(202L, 11L, 1L, false);
      continue;
      f.Ozc.idkeyStat(202L, 12L, 1L, false);
      continue;
      f.Ozc.idkeyStat(202L, 13L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.a.a
 * JD-Core Version:    0.7.0.1
 */