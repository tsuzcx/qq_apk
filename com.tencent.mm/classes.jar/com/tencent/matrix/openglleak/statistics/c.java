package com.tencent.matrix.openglleak.statistics;

import com.tencent.matrix.openglleak.statistics.resource.ResRecordManager;
import com.tencent.matrix.openglleak.statistics.resource.d;
import java.util.List;

public final class c
{
  final d eXp = new d();
  
  public final void ayO()
  {
    d locald = this.eXp;
    ResRecordManager localResRecordManager;
    synchronized (locald.eXW)
    {
      locald.eXW.clear();
      locald = this.eXp;
      localResRecordManager = ResRecordManager.ayR();
    }
    synchronized (localResRecordManager.eXT)
    {
      if (localResRecordManager.eXT.contains(locald))
      {
        return;
        localObject1 = finally;
        throw localObject1;
      }
      localResRecordManager.eXT.add(localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.openglleak.statistics.c
 * JD-Core Version:    0.7.0.1
 */