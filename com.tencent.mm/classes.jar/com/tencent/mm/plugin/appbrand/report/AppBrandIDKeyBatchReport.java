package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.predownload.c.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.gkk;
import com.tencent.mm.protocal.protobuf.gkq;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
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
  private static final long tNc;
  private static volatile IDKeyBatchReportTask tNd;
  
  static
  {
    AppMethodBeat.i(321379);
    tNc = TimeUnit.SECONDS.toMillis(30L);
    AppMethodBeat.o(321379);
  }
  
  public static void a(gkq paramgkq)
  {
    AppMethodBeat.i(48037);
    if (paramgkq == null)
    {
      AppMethodBeat.o(48037);
      return;
    }
    if (MMApplicationContext.isMMProcess())
    {
      b.c(paramgkq);
      AppMethodBeat.o(48037);
      return;
    }
    a.b(paramgkq);
    AppMethodBeat.o(48037);
  }
  
  private static IDKeyBatchReportTask cIi()
  {
    AppMethodBeat.i(48035);
    if (tNd == null) {
      tNd = new IDKeyBatchReportTask();
    }
    IDKeyBatchReportTask localIDKeyBatchReportTask = tNd;
    AppMethodBeat.o(48035);
    return localIDKeyBatchReportTask;
  }
  
  private static String cIj()
  {
    AppMethodBeat.i(48036);
    if (!h.baz())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(48036);
      throw ((Throwable)localObject);
    }
    String str = h.baE().cachePath;
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    localObject = (String)localObject + "appbrand/report/";
    FilePathGenerator.checkMkdir((String)localObject);
    AppMethodBeat.o(48036);
    return localObject;
  }
  
  public static void dd(String paramString, int paramInt)
  {
    AppMethodBeat.i(321360);
    cIi().rHu = 1;
    cIi().tNf = paramString;
    cIi().tNg = paramInt;
    cIi().bQt();
    AppMethodBeat.o(321360);
  }
  
  static final class IDKeyBatchReportTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<IDKeyBatchReportTask> CREATOR;
    int cqI;
    int rHu;
    String tNf;
    int tNg;
    gkq tNh;
    
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
      h(paramParcel);
      AppMethodBeat.o(48017);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(48018);
      if (1 == this.rHu)
      {
        if ((!Util.isNullOrNil(this.tNf)) && (h.baC().mBZ))
        {
          Pair localPair = ((com.tencent.mm.plugin.appbrand.appcache.predownload.storage.b)n.ag(com.tencent.mm.plugin.appbrand.appcache.predownload.storage.b.class)).N(this.tNf, 5, this.tNg);
          if (((Boolean)localPair.first).booleanValue())
          {
            Log.i("MicroMsg.AppBrandIDKeyBatchReport", "report blocked by appid(%s) scene(%d) ", new Object[] { this.tNf, Integer.valueOf(this.tNg) });
            a locala = a.qJY;
            a.ac(((Integer)localPair.second).intValue(), 167L);
            AppMethodBeat.o(48018);
            return;
          }
        }
        AppBrandIDKeyBatchReport.b.access$200(0);
        AppBrandIDKeyBatchReport.b.access$300();
        AppMethodBeat.o(48018);
        return;
      }
      if (2 == this.rHu)
      {
        AppBrandIDKeyBatchReport.b.access$400();
        AppMethodBeat.o(48018);
        return;
      }
      if (3 == this.rHu) {
        AppBrandIDKeyBatchReport.b.c(this.tNh);
      }
      AppMethodBeat.o(48018);
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(48019);
      this.rHu = paramParcel.readInt();
      this.cqI = paramParcel.readInt();
      this.tNf = paramParcel.readString();
      this.tNg = paramParcel.readInt();
      if (3 == this.rHu) {
        try
        {
          this.tNh = new gkq();
          this.tNh.parseFrom(paramParcel.createByteArray());
          AppMethodBeat.o(48019);
          return;
        }
        catch (Exception paramParcel)
        {
          Log.e("MicroMsg.AppBrandIDKeyBatchReport", "parse WxaAppRecord from parcel, e = %s", new Object[] { paramParcel });
          this.tNh = null;
        }
      }
      AppMethodBeat.o(48019);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(48020);
      paramParcel.writeInt(this.rHu);
      paramParcel.writeInt(this.cqI);
      paramParcel.writeString(this.tNf);
      paramParcel.writeInt(this.tNg);
      if (3 == this.rHu) {
        try
        {
          paramParcel.writeByteArray(this.tNh.toByteArray());
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
    private static final byte[] tNe = new byte[0];
  }
  
  static final class b
  {
    private static final ReentrantReadWriteLock tNi;
    private static volatile MTimerHandler tNj;
    private static volatile MTimerHandler tNk;
    private static volatile int tNl;
    
    static
    {
      AppMethodBeat.i(48034);
      tNi = new ReentrantReadWriteLock();
      tNj = null;
      tNk = null;
      AppMethodBeat.o(48034);
    }
    
    private static void cIn()
    {
      AppMethodBeat.i(48026);
      if (tNj != null)
      {
        tNj.stopTimer();
        tNj = null;
      }
      AppMethodBeat.o(48026);
    }
    
    private static LinkedList<gkq> cIo()
    {
      AppMethodBeat.i(48027);
      tNi.readLock().lock();
      for (;;)
      {
        try
        {
          Object localObject2 = new u(AppBrandIDKeyBatchReport.cIl());
          if (!((u)localObject2).jKS())
          {
            Log.d("MicroMsg.AppBrandIDKeyBatchReport", "reportFile not exist!");
            return null;
          }
          LinkedList localLinkedList = new LinkedList();
          long l = ((u)localObject2).length();
          int i = 0;
          localObject2 = y.bi(AppBrandIDKeyBatchReport.cIl(), i, 4);
          if (localObject2 == null)
          {
            Log.e("MicroMsg.AppBrandIDKeyBatchReport", "preData is null!");
            return null;
          }
          int j = new DataInputStream(new ByteArrayInputStream((byte[])localObject2)).readInt();
          localObject2 = y.bi(AppBrandIDKeyBatchReport.cIl(), i + 4, j);
          if (!Util.isNullOrNil((byte[])localObject2))
          {
            localLinkedList.add((gkq)new gkq().parseFrom((byte[])localObject2));
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
          tNi.readLock().unlock();
          AppMethodBeat.o(48027);
          return null;
        }
        finally
        {
          tNi.readLock().unlock();
          cIp();
          AppMethodBeat.o(48027);
        }
      }
    }
    
    private static void cIp()
    {
      AppMethodBeat.i(48028);
      tNi.writeLock().lock();
      try
      {
        y.deleteFile(AppBrandIDKeyBatchReport.cIl());
        tNi.writeLock().unlock();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport
 * JD-Core Version:    0.7.0.1
 */