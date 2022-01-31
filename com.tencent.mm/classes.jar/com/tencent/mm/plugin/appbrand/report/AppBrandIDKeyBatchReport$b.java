package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

final class AppBrandIDKeyBatchReport$b
{
  private static final ReentrantReadWriteLock iFs;
  private static volatile ap iFt;
  private static volatile ap iFu;
  private static volatile int iFv;
  
  static
  {
    AppMethodBeat.i(132532);
    iFs = new ReentrantReadWriteLock();
    iFt = null;
    iFu = null;
    AppMethodBeat.o(132532);
  }
  
  private static void aKU()
  {
    AppMethodBeat.i(132524);
    if (iFt != null)
    {
      iFt.stopTimer();
      iFt = null;
    }
    AppMethodBeat.o(132524);
  }
  
  private static LinkedList<czw> aKV()
  {
    AppMethodBeat.i(132525);
    iFs.readLock().lock();
    for (;;)
    {
      try
      {
        Object localObject2 = new File(AppBrandIDKeyBatchReport.access$800());
        if (!((File)localObject2).exists())
        {
          ab.d("MicroMsg.AppBrandIDKeyBatchReport", "reportFile not exist!");
          return null;
        }
        LinkedList localLinkedList = new LinkedList();
        long l = ((File)localObject2).length();
        int i = 0;
        localObject2 = e.i(AppBrandIDKeyBatchReport.access$800(), i, 4);
        if (localObject2 == null)
        {
          ab.e("MicroMsg.AppBrandIDKeyBatchReport", "preData is null!");
          return null;
        }
        int j = new DataInputStream(new ByteArrayInputStream((byte[])localObject2)).readInt();
        localObject2 = e.i(AppBrandIDKeyBatchReport.access$800(), i + 4, j);
        if (!bo.ce((byte[])localObject2))
        {
          localLinkedList.add((czw)new czw().parseFrom((byte[])localObject2));
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
        ab.e("MicroMsg.AppBrandIDKeyBatchReport", "read file error %s", new Object[] { localException.getMessage() });
        ab.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", localException, "readReportData()", new Object[0]);
        return null;
      }
      finally
      {
        iFs.readLock().unlock();
        aKW();
        AppMethodBeat.o(132525);
      }
    }
  }
  
  private static void aKW()
  {
    AppMethodBeat.i(132526);
    iFs.writeLock().lock();
    try
    {
      e.deleteFile(AppBrandIDKeyBatchReport.access$800());
      iFs.writeLock().unlock();
      AppMethodBeat.o(132526);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", localException, "removeFile()", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport.b
 * JD-Core Version:    0.7.0.1
 */