package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.fcm;
import com.tencent.mm.protocal.protobuf.fcq;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public final class AppBrandIDKeyBatchReport
{
  private static final long nGk;
  private static volatile IDKeyBatchReportTask nGl;
  
  static
  {
    AppMethodBeat.i(227369);
    nGk = TimeUnit.SECONDS.toMillis(30L);
    AppMethodBeat.o(227369);
  }
  
  public static void a(fcq paramfcq)
  {
    AppMethodBeat.i(48037);
    if (paramfcq == null)
    {
      AppMethodBeat.o(48037);
      return;
    }
    if (MMApplicationContext.isMMProcess())
    {
      b.c(paramfcq);
      AppMethodBeat.o(48037);
      return;
    }
    a.b(paramfcq);
    AppMethodBeat.o(48037);
  }
  
  private static IDKeyBatchReportTask bUh()
  {
    AppMethodBeat.i(48035);
    if (nGl == null) {
      nGl = new IDKeyBatchReportTask();
    }
    IDKeyBatchReportTask localIDKeyBatchReportTask = nGl;
    AppMethodBeat.o(48035);
    return localIDKeyBatchReportTask;
  }
  
  private static String bUi()
  {
    AppMethodBeat.i(48036);
    if (!g.aAc())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(48036);
      throw ((Throwable)localObject);
    }
    String str = g.aAh().cachePath;
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    localObject = (String)localObject + "appbrand/report/";
    FilePathGenerator.checkMkdir((String)localObject);
    AppMethodBeat.o(48036);
    return localObject;
  }
  
  public static void ce(String paramString, int paramInt)
  {
    AppMethodBeat.i(227366);
    bUh().nGn = 1;
    bUh().nGp = paramString;
    bUh().nGq = paramInt;
    AppBrandMainProcessService.a(bUh());
    AppMethodBeat.o(227366);
  }
  
  static final class IDKeyBatchReportTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<IDKeyBatchReportTask> CREATOR;
    int nGn;
    int nGo;
    String nGp;
    int nGq;
    fcq nGr;
    
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
      f(paramParcel);
      AppMethodBeat.o(48017);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(48018);
      if (1 == this.nGn)
      {
        if ((!Util.isNullOrNil(this.nGp)) && (g.aAf().hpY))
        {
          Pair localPair = ((com.tencent.mm.plugin.appbrand.appcache.predownload.e.b)n.W(com.tencent.mm.plugin.appbrand.appcache.predownload.e.b.class)).J(this.nGp, 5, this.nGq);
          if (((Boolean)localPair.first).booleanValue())
          {
            Log.i("MicroMsg.AppBrandIDKeyBatchReport", "report blocked by appid(%s) scene(%d) ", new Object[] { this.nGp, Integer.valueOf(this.nGq) });
            com.tencent.mm.plugin.appbrand.appcache.predownload.c.a locala = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.kQt;
            com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(((Integer)localPair.second).intValue(), 167L);
            AppMethodBeat.o(48018);
            return;
          }
        }
        AppBrandIDKeyBatchReport.b.sz(0);
        AppBrandIDKeyBatchReport.b.access$300();
        AppMethodBeat.o(48018);
        return;
      }
      if (2 == this.nGn)
      {
        AppBrandIDKeyBatchReport.b.Wz();
        AppMethodBeat.o(48018);
        return;
      }
      if (3 == this.nGn) {
        AppBrandIDKeyBatchReport.b.c(this.nGr);
      }
      AppMethodBeat.o(48018);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(48019);
      this.nGn = paramParcel.readInt();
      this.nGo = paramParcel.readInt();
      this.nGp = paramParcel.readString();
      this.nGq = paramParcel.readInt();
      if (3 == this.nGn) {
        try
        {
          this.nGr = new fcq();
          this.nGr.parseFrom(paramParcel.createByteArray());
          AppMethodBeat.o(48019);
          return;
        }
        catch (Exception paramParcel)
        {
          Log.e("MicroMsg.AppBrandIDKeyBatchReport", "parse WxaAppRecord from parcel, e = %s", new Object[] { paramParcel });
          this.nGr = null;
        }
      }
      AppMethodBeat.o(48019);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(48020);
      paramParcel.writeInt(this.nGn);
      paramParcel.writeInt(this.nGo);
      paramParcel.writeString(this.nGp);
      paramParcel.writeInt(this.nGq);
      if (3 == this.nGn) {
        try
        {
          paramParcel.writeByteArray(this.nGr.toByteArray());
          AppMethodBeat.o(48020);
          return;
        }
        catch (Exception paramParcel)
        {
          Log.e("MicroMsg.AppBrandIDKeyBatchReport", "write WxaAppRecord to parcel, e = %s", new Object[] { paramParcel });
        }
      }
      AppMethodBeat.o(48020);
    }
  }
  
  static final class a
  {
    private static final byte[] nGm = new byte[0];
  }
  
  static final class b
  {
    private static final ReentrantReadWriteLock nGs;
    private static volatile MTimerHandler nGt;
    private static volatile MTimerHandler nGu;
    private static volatile int nGv;
    
    static
    {
      AppMethodBeat.i(48034);
      nGs = new ReentrantReadWriteLock();
      nGt = null;
      nGu = null;
      AppMethodBeat.o(48034);
    }
    
    private static void bUm()
    {
      AppMethodBeat.i(48026);
      if (nGt != null)
      {
        nGt.stopTimer();
        nGt = null;
      }
      AppMethodBeat.o(48026);
    }
    
    private static LinkedList<fcq> bUn()
    {
      AppMethodBeat.i(48027);
      nGs.readLock().lock();
      for (;;)
      {
        try
        {
          Object localObject2 = new o(AppBrandIDKeyBatchReport.bUk());
          if (!((o)localObject2).exists())
          {
            Log.d("MicroMsg.AppBrandIDKeyBatchReport", "reportFile not exist!");
            return null;
          }
          LinkedList localLinkedList = new LinkedList();
          long l = ((o)localObject2).length();
          int i = 0;
          localObject2 = s.aW(AppBrandIDKeyBatchReport.bUk(), i, 4);
          if (localObject2 == null)
          {
            Log.e("MicroMsg.AppBrandIDKeyBatchReport", "preData is null!");
            return null;
          }
          int j = new DataInputStream(new ByteArrayInputStream((byte[])localObject2)).readInt();
          localObject2 = s.aW(AppBrandIDKeyBatchReport.bUk(), i + 4, j);
          if (!Util.isNullOrNil((byte[])localObject2))
          {
            localLinkedList.add((fcq)new fcq().parseFrom((byte[])localObject2));
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
          Log.e("MicroMsg.AppBrandIDKeyBatchReport", "read file error %s", new Object[] { localException.getMessage() });
          Log.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", localException, "readReportData()", new Object[0]);
          return null;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          Log.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", localOutOfMemoryError, "readReportData()", new Object[0]);
          nGs.readLock().unlock();
          AppMethodBeat.o(48027);
          return null;
        }
        finally
        {
          nGs.readLock().unlock();
          bUo();
          AppMethodBeat.o(48027);
        }
      }
    }
    
    private static void bUo()
    {
      AppMethodBeat.i(48028);
      nGs.writeLock().lock();
      try
      {
        s.deleteFile(AppBrandIDKeyBatchReport.bUk());
        nGs.writeLock().unlock();
        AppMethodBeat.o(48028);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", localException, "removeFile()", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport
 * JD-Core Version:    0.7.0.1
 */