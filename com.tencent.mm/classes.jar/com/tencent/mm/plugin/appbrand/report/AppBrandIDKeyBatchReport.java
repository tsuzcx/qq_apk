package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.dui;
import com.tencent.mm.protocal.protobuf.dum;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static volatile IDKeyBatchReportTask loI;
  
  public static void a(dum paramdum)
  {
    AppMethodBeat.i(48037);
    if (aj.cbv())
    {
      b.c(paramdum);
      AppMethodBeat.o(48037);
      return;
    }
    a.b(paramdum);
    AppMethodBeat.o(48037);
  }
  
  public static IDKeyBatchReportTask bma()
  {
    AppMethodBeat.i(48035);
    if (loI == null) {
      loI = new IDKeyBatchReportTask();
    }
    IDKeyBatchReportTask localIDKeyBatchReportTask = loI;
    AppMethodBeat.o(48035);
    return localIDKeyBatchReportTask;
  }
  
  static String bmb()
  {
    AppMethodBeat.i(48036);
    if (!g.afw())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(48036);
      throw ((Throwable)localObject);
    }
    String str = g.afB().cachePath;
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    localObject = (String)localObject + "appbrand/report/";
    l.aAk((String)localObject);
    AppMethodBeat.o(48036);
    return localObject;
  }
  
  public static final class IDKeyBatchReportTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<IDKeyBatchReportTask> CREATOR;
    public int loK;
    int loL;
    public String loM;
    public int loN;
    dum loO;
    
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
    
    public final void aEz()
    {
      AppMethodBeat.i(48018);
      if (1 == this.loK)
      {
        if ((!bt.isNullOrNil(this.loM)) && (g.afz().gcn))
        {
          Pair localPair = ((com.tencent.mm.plugin.appbrand.appcache.b.e.b)j.T(com.tencent.mm.plugin.appbrand.appcache.b.e.b.class)).F(this.loM, 5, this.loN);
          if (((Boolean)localPair.first).booleanValue())
          {
            ad.i("MicroMsg.AppBrandIDKeyBatchReport", "report blocked by appid(%s) scene(%d) ", new Object[] { this.loM, Integer.valueOf(this.loN) });
            com.tencent.mm.plugin.appbrand.appcache.b.c.a locala = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iQw;
            com.tencent.mm.plugin.appbrand.appcache.b.c.a.D(((Integer)localPair.second).intValue(), 167L);
            AppMethodBeat.o(48018);
            return;
          }
        }
        AppBrandIDKeyBatchReport.b.nu(0);
        AppBrandIDKeyBatchReport.b.access$300();
        AppMethodBeat.o(48018);
        return;
      }
      if (2 == this.loK)
      {
        AppBrandIDKeyBatchReport.b.Le();
        AppMethodBeat.o(48018);
        return;
      }
      if (3 == this.loK) {
        AppBrandIDKeyBatchReport.b.c(this.loO);
      }
      AppMethodBeat.o(48018);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(48019);
      this.loK = paramParcel.readInt();
      this.loL = paramParcel.readInt();
      this.loM = paramParcel.readString();
      this.loN = paramParcel.readInt();
      if (3 == this.loK) {
        try
        {
          this.loO = new dum();
          this.loO.parseFrom(paramParcel.createByteArray());
          AppMethodBeat.o(48019);
          return;
        }
        catch (Exception paramParcel)
        {
          ad.e("MicroMsg.AppBrandIDKeyBatchReport", "parse WxaAppRecord from parcel, e = %s", new Object[] { paramParcel });
          this.loO = null;
        }
      }
      AppMethodBeat.o(48019);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(48020);
      paramParcel.writeInt(this.loK);
      paramParcel.writeInt(this.loL);
      paramParcel.writeString(this.loM);
      paramParcel.writeInt(this.loN);
      if (3 == this.loK) {
        try
        {
          paramParcel.writeByteArray(this.loO.toByteArray());
          AppMethodBeat.o(48020);
          return;
        }
        catch (Exception paramParcel)
        {
          ad.e("MicroMsg.AppBrandIDKeyBatchReport", "write WxaAppRecord to parcel, e = %s", new Object[] { paramParcel });
        }
      }
      AppMethodBeat.o(48020);
    }
  }
  
  static final class a
  {
    private static final byte[] loJ = new byte[0];
  }
  
  static final class b
  {
    private static final ReentrantReadWriteLock loP;
    private static volatile av loQ;
    private static volatile av loR;
    private static volatile int loS;
    
    static
    {
      AppMethodBeat.i(48034);
      loP = new ReentrantReadWriteLock();
      loQ = null;
      loR = null;
      AppMethodBeat.o(48034);
    }
    
    private static void bmd()
    {
      AppMethodBeat.i(48026);
      if (loQ != null)
      {
        loQ.stopTimer();
        loQ = null;
      }
      AppMethodBeat.o(48026);
    }
    
    private static LinkedList<dum> bme()
    {
      AppMethodBeat.i(48027);
      loP.readLock().lock();
      for (;;)
      {
        try
        {
          Object localObject2 = new com.tencent.mm.vfs.e(AppBrandIDKeyBatchReport.bmc());
          if (!((com.tencent.mm.vfs.e)localObject2).exists())
          {
            ad.d("MicroMsg.AppBrandIDKeyBatchReport", "reportFile not exist!");
            return null;
          }
          LinkedList localLinkedList = new LinkedList();
          long l = ((com.tencent.mm.vfs.e)localObject2).length();
          int i = 0;
          localObject2 = i.aR(AppBrandIDKeyBatchReport.bmc(), i, 4);
          if (localObject2 == null)
          {
            ad.e("MicroMsg.AppBrandIDKeyBatchReport", "preData is null!");
            return null;
          }
          int j = new DataInputStream(new ByteArrayInputStream((byte[])localObject2)).readInt();
          localObject2 = i.aR(AppBrandIDKeyBatchReport.bmc(), i + 4, j);
          if (!bt.cw((byte[])localObject2))
          {
            localLinkedList.add((dum)new dum().parseFrom((byte[])localObject2));
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
          ad.e("MicroMsg.AppBrandIDKeyBatchReport", "read file error %s", new Object[] { localException.getMessage() });
          ad.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", localException, "readReportData()", new Object[0]);
          return null;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          ad.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", localOutOfMemoryError, "readReportData()", new Object[0]);
          loP.readLock().unlock();
          AppMethodBeat.o(48027);
          return null;
        }
        finally
        {
          loP.readLock().unlock();
          bmf();
          AppMethodBeat.o(48027);
        }
      }
    }
    
    private static void bmf()
    {
      AppMethodBeat.i(48028);
      loP.writeLock().lock();
      try
      {
        i.deleteFile(AppBrandIDKeyBatchReport.bmc());
        loP.writeLock().unlock();
        AppMethodBeat.o(48028);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", localException, "removeFile()", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport
 * JD-Core Version:    0.7.0.1
 */