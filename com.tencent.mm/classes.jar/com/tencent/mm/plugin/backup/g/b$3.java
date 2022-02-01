package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

final class b$3
  implements Runnable
{
  b$3(b.b paramb) {}
  
  public final void run()
  {
    int i = 0;
    AppMethodBeat.i(21699);
    label297:
    label321:
    label374:
    for (;;)
    {
      long l;
      synchronized (b.bEE())
      {
        l = bs.eWj();
        Iterator localIterator = b.bEE().entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label321;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry == null) {
          break label374;
        }
        try
        {
          localPByteArray = b.a((b)localEntry.getValue());
          if (localPByteArray == null) {
            break label297;
          }
          if (b.bEF() == null) {
            continue;
          }
          b.bEF().m(((Integer)localEntry.getKey()).intValue(), localPByteArray.value);
          ac.i("MicroMsg.BackupBaseScene", "resendSceneMap sceneSeq[%d], type[%d], sceneBuf[%d]", new Object[] { localEntry.getKey(), Integer.valueOf(((b)localEntry.getValue()).getType()), Integer.valueOf(localPByteArray.value.length) });
        }
        catch (Exception localException)
        {
          PByteArray localPByteArray;
          ac.printErrStackTrace("MicroMsg.BackupBaseScene", localException, "req to buf fail: " + localException.toString(), new Object[0]);
          continue;
        }
        i += 1;
        if ((i > 0) && (i % 5 == 0)) {
          this.mYJ.iw(false);
        }
        continue;
        ac.e("MicroMsg.BackupBaseScene", "resendSceneMap engineSender null, sceneSeq[%d], type[%d], sceneBuf[%d]", new Object[] { localEntry.getKey(), Integer.valueOf(((b)localEntry.getValue()).getType()), Integer.valueOf(localPByteArray.value.length) });
      }
      ac.e("MicroMsg.BackupBaseScene", "resendSceneMap sceneBuf null, sceneSeq[%d]", new Object[] { localException.getKey() });
      continue;
      this.mYJ.iw(true);
      ac.i("MicroMsg.BackupBaseScene", "resendSceneMap finish, sceneMap[%d], time[%d]", new Object[] { Integer.valueOf(b.bEE().size()), Long.valueOf(bs.Ap(l)) });
      AppMethodBeat.o(21699);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.b.3
 * JD-Core Version:    0.7.0.1
 */