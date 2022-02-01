package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.predownload.c.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.fnn;
import com.tencent.mm.protocal.protobuf.fnr;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
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
  private static final long qIw;
  private static volatile IDKeyBatchReportTask qIx;
  
  static
  {
    AppMethodBeat.i(254321);
    qIw = TimeUnit.SECONDS.toMillis(30L);
    AppMethodBeat.o(254321);
  }
  
  public static void a(fnr paramfnr)
  {
    AppMethodBeat.i(48037);
    if (paramfnr == null)
    {
      AppMethodBeat.o(48037);
      return;
    }
    if (MMApplicationContext.isMMProcess())
    {
      b.c(paramfnr);
      AppMethodBeat.o(48037);
      return;
    }
    a.b(paramfnr);
    AppMethodBeat.o(48037);
  }
  
  public static void cD(String paramString, int paramInt)
  {
    AppMethodBeat.i(254307);
    chn().oEk = 1;
    chn().qIA = paramString;
    chn().qIB = paramInt;
    chn().bsM();
    AppMethodBeat.o(254307);
  }
  
  private static IDKeyBatchReportTask chn()
  {
    AppMethodBeat.i(48035);
    if (qIx == null) {
      qIx = new IDKeyBatchReportTask();
    }
    IDKeyBatchReportTask localIDKeyBatchReportTask = qIx;
    AppMethodBeat.o(48035);
    return localIDKeyBatchReportTask;
  }
  
  private static String cho()
  {
    AppMethodBeat.i(48036);
    if (!h.aHB())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(48036);
      throw ((Throwable)localObject);
    }
    String str = h.aHG().cachePath;
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    localObject = (String)localObject + "appbrand/report/";
    FilePathGenerator.checkMkdir((String)localObject);
    AppMethodBeat.o(48036);
    return localObject;
  }
  
  static final class IDKeyBatchReportTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<IDKeyBatchReportTask> CREATOR;
    int oEk;
    String qIA;
    int qIB;
    fnr qIC;
    int qIz;
    
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
    
    public final void RW()
    {
      AppMethodBeat.i(48018);
      if (1 == this.oEk)
      {
        if ((!Util.isNullOrNil(this.qIA)) && (h.aHE().kbT))
        {
          Pair localPair = ((com.tencent.mm.plugin.appbrand.appcache.predownload.e.b)m.W(com.tencent.mm.plugin.appbrand.appcache.predownload.e.b.class)).J(this.qIA, 5, this.qIB);
          if (((Boolean)localPair.first).booleanValue())
          {
            Log.i("MicroMsg.AppBrandIDKeyBatchReport", "report blocked by appid(%s) scene(%d) ", new Object[] { this.qIA, Integer.valueOf(this.qIB) });
            a locala = a.nKB;
            a.F(((Integer)localPair.second).intValue(), 167L);
            AppMethodBeat.o(48018);
            return;
          }
        }
        AppBrandIDKeyBatchReport.b.access$200(0);
        AppBrandIDKeyBatchReport.b.access$300();
        AppMethodBeat.o(48018);
        return;
      }
      if (2 == this.oEk)
      {
        AppBrandIDKeyBatchReport.b.access$400();
        AppMethodBeat.o(48018);
        return;
      }
      if (3 == this.oEk) {
        AppBrandIDKeyBatchReport.b.c(this.qIC);
      }
      AppMethodBeat.o(48018);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(48019);
      this.oEk = paramParcel.readInt();
      this.qIz = paramParcel.readInt();
      this.qIA = paramParcel.readString();
      this.qIB = paramParcel.readInt();
      if (3 == this.oEk) {
        try
        {
          this.qIC = new fnr();
          this.qIC.parseFrom(paramParcel.createByteArray());
          AppMethodBeat.o(48019);
          return;
        }
        catch (Exception paramParcel)
        {
          Log.e("MicroMsg.AppBrandIDKeyBatchReport", "parse WxaAppRecord from parcel, e = %s", new Object[] { paramParcel });
          this.qIC = null;
        }
      }
      AppMethodBeat.o(48019);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(48020);
      paramParcel.writeInt(this.oEk);
      paramParcel.writeInt(this.qIz);
      paramParcel.writeString(this.qIA);
      paramParcel.writeInt(this.qIB);
      if (3 == this.oEk) {
        try
        {
          paramParcel.writeByteArray(this.qIC.toByteArray());
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
    private static final byte[] qIy = new byte[0];
  }
  
  static final class b
  {
    private static final ReentrantReadWriteLock qID;
    private static volatile MTimerHandler qIE;
    private static volatile MTimerHandler qIF;
    private static volatile int qIG;
    
    static
    {
      AppMethodBeat.i(48034);
      qID = new ReentrantReadWriteLock();
      qIE = null;
      qIF = null;
      AppMethodBeat.o(48034);
    }
    
    private static void chr()
    {
      AppMethodBeat.i(48026);
      if (qIE != null)
      {
        qIE.stopTimer();
        qIE = null;
      }
      AppMethodBeat.o(48026);
    }
    
    private static LinkedList<fnr> chs()
    {
      AppMethodBeat.i(48027);
      qID.readLock().lock();
      for (;;)
      {
        try
        {
          Object localObject2 = new com.tencent.mm.vfs.q(AppBrandIDKeyBatchReport.chp());
          if (!((com.tencent.mm.vfs.q)localObject2).ifE())
          {
            Log.d("MicroMsg.AppBrandIDKeyBatchReport", "reportFile not exist!");
            return null;
          }
          LinkedList localLinkedList = new LinkedList();
          long l = ((com.tencent.mm.vfs.q)localObject2).length();
          int i = 0;
          localObject2 = u.aY(AppBrandIDKeyBatchReport.chp(), i, 4);
          if (localObject2 == null)
          {
            Log.e("MicroMsg.AppBrandIDKeyBatchReport", "preData is null!");
            return null;
          }
          int j = new DataInputStream(new ByteArrayInputStream((byte[])localObject2)).readInt();
          localObject2 = u.aY(AppBrandIDKeyBatchReport.chp(), i + 4, j);
          if (!Util.isNullOrNil((byte[])localObject2))
          {
            localLinkedList.add((fnr)new fnr().parseFrom((byte[])localObject2));
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
          qID.readLock().unlock();
          AppMethodBeat.o(48027);
          return null;
        }
        finally
        {
          qID.readLock().unlock();
          cht();
          AppMethodBeat.o(48027);
        }
      }
    }
    
    private static void cht()
    {
      AppMethodBeat.i(48028);
      qID.writeLock().lock();
      try
      {
        u.deleteFile(AppBrandIDKeyBatchReport.chp());
        qID.writeLock().unlock();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport
 * JD-Core Version:    0.7.0.1
 */