package com.tencent.mm.plugin.appbrand.report;

import com.tencent.mm.a.e;
import com.tencent.mm.protocal.c.cmf;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

final class AppBrandIDKeyBatchReport$b
{
  private static final ReentrantReadWriteLock gXp = new ReentrantReadWriteLock();
  private static volatile am gXq = null;
  private static volatile am gXr = null;
  private static volatile int gXs;
  
  private static void anW()
  {
    if (gXq != null)
    {
      gXq.stopTimer();
      gXq = null;
    }
  }
  
  private static LinkedList<cmf> anX()
  {
    gXp.readLock().lock();
    for (;;)
    {
      try
      {
        Object localObject2 = new File(AppBrandIDKeyBatchReport.access$800());
        if (!((File)localObject2).exists())
        {
          y.d("MicroMsg.AppBrandIDKeyBatchReport", "reportFile not exist!");
          return null;
        }
        LinkedList localLinkedList = new LinkedList();
        long l = ((File)localObject2).length();
        int i = 0;
        localObject2 = e.c(AppBrandIDKeyBatchReport.access$800(), i, 4);
        if (localObject2 == null)
        {
          y.e("MicroMsg.AppBrandIDKeyBatchReport", "preData is null!");
          return null;
        }
        int j = new DataInputStream(new ByteArrayInputStream((byte[])localObject2)).readInt();
        localObject2 = e.c(AppBrandIDKeyBatchReport.access$800(), i + 4, j);
        if (!bk.bE((byte[])localObject2))
        {
          localLinkedList.add((cmf)new cmf().aH((byte[])localObject2));
          i = j + 4 + i;
          if (i < l) {}
        }
        else
        {
          return localLinkedList;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.AppBrandIDKeyBatchReport", "read file error %s", new Object[] { localException.getMessage() });
        y.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", localException, "readReportData()", new Object[0]);
        return null;
      }
      finally
      {
        gXp.readLock().unlock();
        anY();
      }
    }
  }
  
  private static void anY()
  {
    gXp.writeLock().lock();
    try
    {
      e.deleteFile(AppBrandIDKeyBatchReport.access$800());
      gXp.writeLock().unlock();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", localException, "removeFile()", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport.b
 * JD-Core Version:    0.7.0.1
 */