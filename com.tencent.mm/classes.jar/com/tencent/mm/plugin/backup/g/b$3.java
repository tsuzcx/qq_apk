package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
    label285:
    label309:
    label356:
    for (;;)
    {
      long l;
      synchronized (b.auX())
      {
        l = bk.UY();
        Iterator localIterator = b.auX().entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label309;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry == null) {
          break label356;
        }
        try
        {
          localPByteArray = b.a((b)localEntry.getValue());
          if (localPByteArray == null) {
            break label285;
          }
          if (b.auY() == null) {
            continue;
          }
          b.auY().k(((Integer)localEntry.getKey()).intValue(), localPByteArray.value);
          y.i("MicroMsg.BackupBaseScene", "resendSceneMap sceneSeq[%d], type[%d], sceneBuf[%d]", new Object[] { localEntry.getKey(), Integer.valueOf(((b)localEntry.getValue()).getType()), Integer.valueOf(localPByteArray.value.length) });
        }
        catch (Exception localException)
        {
          PByteArray localPByteArray;
          y.printErrStackTrace("MicroMsg.BackupBaseScene", localException, "req to buf fail: " + localException.toString(), new Object[0]);
          continue;
        }
        i += 1;
        if ((i > 0) && (i % 5 == 0)) {
          this.hLM.ef(false);
        }
        continue;
        y.e("MicroMsg.BackupBaseScene", "resendSceneMap engineSender null, sceneSeq[%d], type[%d], sceneBuf[%d]", new Object[] { localEntry.getKey(), Integer.valueOf(((b)localEntry.getValue()).getType()), Integer.valueOf(localPByteArray.value.length) });
      }
      y.e("MicroMsg.BackupBaseScene", "resendSceneMap sceneBuf null, sceneSeq[%d]", new Object[] { localException.getKey() });
      continue;
      this.hLM.ef(true);
      y.i("MicroMsg.BackupBaseScene", "resendSceneMap finish, sceneMap[%d], time[%d]", new Object[] { Integer.valueOf(b.auX().size()), Long.valueOf(bk.co(l)) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.b.3
 * JD-Core Version:    0.7.0.1
 */