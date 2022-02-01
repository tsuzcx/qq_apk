package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.dzz;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public final class AppBrandIDKeyBatchReport
{
  private static volatile IDKeyBatchReportTask lQI;
  
  public static void a(ead paramead)
  {
    AppMethodBeat.i(48037);
    if (ai.ciE())
    {
      b.c(paramead);
      AppMethodBeat.o(48037);
      return;
    }
    a.b(paramead);
    AppMethodBeat.o(48037);
  }
  
  public static IDKeyBatchReportTask bsW()
  {
    AppMethodBeat.i(48035);
    if (lQI == null) {
      lQI = new IDKeyBatchReportTask();
    }
    IDKeyBatchReportTask localIDKeyBatchReportTask = lQI;
    AppMethodBeat.o(48035);
    return localIDKeyBatchReportTask;
  }
  
  static String bsX()
  {
    AppMethodBeat.i(48036);
    if (!g.agM())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(48036);
      throw ((Throwable)localObject);
    }
    String str = g.agR().cachePath;
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    localObject = (String)localObject + "appbrand/report/";
    l.aFC((String)localObject);
    AppMethodBeat.o(48036);
    return localObject;
  }
  
  public static final class IDKeyBatchReportTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<IDKeyBatchReportTask> CREATOR;
    public int lQK;
    int lQL;
    public String lQM;
    public int lQN;
    ead lQO;
    
    static
    {
      AppMethodBeat.i(48021);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(48021);
    }
    
    IDKeyBatchReportTask() {}
    
    IDKeyBatchReportTask(Parcel paramParcel)
    {
      AppMethodBeat.i(48017);
      e(paramParcel);
      AppMethodBeat.o(48017);
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(48018);
      if (1 == this.lQK)
      {
        if ((!bs.isNullOrNil(this.lQM)) && (g.agP().ggT))
        {
          Pair localPair = ((com.tencent.mm.plugin.appbrand.appcache.b.e.b)j.T(com.tencent.mm.plugin.appbrand.appcache.b.e.b.class)).E(this.lQM, 5, this.lQN);
          if (((Boolean)localPair.first).booleanValue())
          {
            ac.i("MicroMsg.AppBrandIDKeyBatchReport", "report blocked by appid(%s) scene(%d) ", new Object[] { this.lQM, Integer.valueOf(this.lQN) });
            com.tencent.mm.plugin.appbrand.appcache.b.c.a locala = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jqG;
            com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(((Integer)localPair.second).intValue(), 167L);
            AppMethodBeat.o(48018);
            return;
          }
        }
        AppBrandIDKeyBatchReport.b.oi(0);
        AppBrandIDKeyBatchReport.b.access$300();
        AppMethodBeat.o(48018);
        return;
      }
      if (2 == this.lQK)
      {
        AppBrandIDKeyBatchReport.b.Lc();
        AppMethodBeat.o(48018);
        return;
      }
      if (3 == this.lQK) {
        AppBrandIDKeyBatchReport.b.c(this.lQO);
      }
      AppMethodBeat.o(48018);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(48019);
      this.lQK = paramParcel.readInt();
      this.lQL = paramParcel.readInt();
      this.lQM = paramParcel.readString();
      this.lQN = paramParcel.readInt();
      if (3 == this.lQK) {
        try
        {
          this.lQO = new ead();
          this.lQO.parseFrom(paramParcel.createByteArray());
          AppMethodBeat.o(48019);
          return;
        }
        catch (Exception paramParcel)
        {
          ac.e("MicroMsg.AppBrandIDKeyBatchReport", "parse WxaAppRecord from parcel, e = %s", new Object[] { paramParcel });
          this.lQO = null;
        }
      }
      AppMethodBeat.o(48019);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(48020);
      paramParcel.writeInt(this.lQK);
      paramParcel.writeInt(this.lQL);
      paramParcel.writeString(this.lQM);
      paramParcel.writeInt(this.lQN);
      if (3 == this.lQK) {
        try
        {
          paramParcel.writeByteArray(this.lQO.toByteArray());
          AppMethodBeat.o(48020);
          return;
        }
        catch (Exception paramParcel)
        {
          ac.e("MicroMsg.AppBrandIDKeyBatchReport", "write WxaAppRecord to parcel, e = %s", new Object[] { paramParcel });
        }
      }
      AppMethodBeat.o(48020);
    }
  }
  
  static final class a
  {
    private static final byte[] lQJ = new byte[0];
  }
  
  static final class b
  {
    private static final ReentrantReadWriteLock lQP;
    private static volatile au lQQ;
    private static volatile au lQR;
    private static volatile int lQS;
    
    static
    {
      AppMethodBeat.i(48034);
      lQP = new ReentrantReadWriteLock();
      lQQ = null;
      lQR = null;
      AppMethodBeat.o(48034);
    }
    
    private static void bsZ()
    {
      AppMethodBeat.i(48026);
      if (lQQ != null)
      {
        lQQ.stopTimer();
        lQQ = null;
      }
      AppMethodBeat.o(48026);
    }
    
    private static LinkedList<ead> bta()
    {
      AppMethodBeat.i(48027);
      lQP.readLock().lock();
      for (;;)
      {
        try
        {
          Object localObject2 = new com.tencent.mm.vfs.e(AppBrandIDKeyBatchReport.bsY());
          if (!((com.tencent.mm.vfs.e)localObject2).exists())
          {
            ac.d("MicroMsg.AppBrandIDKeyBatchReport", "reportFile not exist!");
            return null;
          }
          LinkedList localLinkedList = new LinkedList();
          long l = ((com.tencent.mm.vfs.e)localObject2).length();
          int i = 0;
          localObject2 = i.aU(AppBrandIDKeyBatchReport.bsY(), i, 4);
          if (localObject2 == null)
          {
            ac.e("MicroMsg.AppBrandIDKeyBatchReport", "preData is null!");
            return null;
          }
          int j = new DataInputStream(new ByteArrayInputStream((byte[])localObject2)).readInt();
          localObject2 = i.aU(AppBrandIDKeyBatchReport.bsY(), i + 4, j);
          if (!bs.cv((byte[])localObject2))
          {
            localLinkedList.add((ead)new ead().parseFrom((byte[])localObject2));
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
          ac.e("MicroMsg.AppBrandIDKeyBatchReport", "read file error %s", new Object[] { localException.getMessage() });
          ac.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", localException, "readReportData()", new Object[0]);
          return null;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          ac.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", localOutOfMemoryError, "readReportData()", new Object[0]);
          lQP.readLock().unlock();
          AppMethodBeat.o(48027);
          return null;
        }
        finally
        {
          lQP.readLock().unlock();
          btb();
          AppMethodBeat.o(48027);
        }
      }
    }
    
    private static void btb()
    {
      AppMethodBeat.i(48028);
      lQP.writeLock().lock();
      try
      {
        i.deleteFile(AppBrandIDKeyBatchReport.bsY());
        lQP.writeLock().unlock();
        AppMethodBeat.o(48028);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", localException, "removeFile()", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport
 * JD-Core Version:    0.7.0.1
 */