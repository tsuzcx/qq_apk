package com.tencent.mm.modelpackage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.se;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ch;
import com.tencent.mm.protocal.protobuf.dfq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;

public class PostTaskReportEggListener
  extends IListener<se>
{
  public PostTaskReportEggListener()
  {
    super(com.tencent.mm.app.f.hfK);
    AppMethodBeat.i(161780);
    this.__eventId = se.class.getName().hashCode();
    AppMethodBeat.o(161780);
  }
  
  private static boolean bLF()
  {
    AppMethodBeat.i(150854);
    int i;
    if (h.baC().aZN())
    {
      h.baC();
      if (!b.aZG())
      {
        i = 1;
        if (i == 0) {
          break label346;
        }
        if (Util.secondsToNow(Util.nullAs((Long)h.baE().ban().d(68097, null), 0L)) * 1000L <= 3600000L) {
          break label123;
        }
        i = 1;
      }
    }
    LinkedList localLinkedList;
    for (;;)
    {
      if (i != 0)
      {
        localLinkedList = new LinkedList();
        Object localObject = y.bi(h.baE().cachePath + "eggresult.rep", 0, -1);
        if (localObject == null)
        {
          AppMethodBeat.o(150854);
          return false;
          i = 0;
          break;
          label123:
          i = 0;
          continue;
        }
        try
        {
          localObject = ((k)new k().parseFrom((byte[])localObject)).oQC.iterator();
          while (((Iterator)localObject).hasNext())
          {
            j localj = (j)((Iterator)localObject).next();
            dfq localdfq;
            if (localj.oQA != 0)
            {
              localdfq = new dfq();
              localdfq.OzG = 17;
              localdfq.OzQ = (localj.hYb + "," + localj.oQA);
              localLinkedList.add(localdfq);
            }
            if (localj.oQB != 0)
            {
              localdfq = new dfq();
              localdfq.OzG = 18;
              localdfq.OzQ = (localj.hYb + "," + localj.oQB);
              localLinkedList.add(localdfq);
            }
          }
          if (localLinkedList.isEmpty()) {}
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.PostTaskReportEgg", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
        }
      }
    }
    for (;;)
    {
      ch.b(localLinkedList);
      h.baE().ban().B(68097, Long.valueOf(Util.nowSecond()));
      label346:
      Log.d("MicroMsg.PostTaskReportEgg", "report egg done");
      AppMethodBeat.o(150854);
      return false;
      y.deleteFile(h.baE().cachePath + "eggresult.rep");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelpackage.PostTaskReportEggListener
 * JD-Core Version:    0.7.0.1
 */