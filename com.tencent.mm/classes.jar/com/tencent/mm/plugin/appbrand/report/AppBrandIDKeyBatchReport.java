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
import com.tencent.mm.protocal.protobuf.egd;
import com.tencent.mm.protocal.protobuf.egh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
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
  private static volatile IDKeyBatchReportTask mqy;
  
  public static void a(egh paramegh)
  {
    AppMethodBeat.i(48037);
    if (aj.cnC())
    {
      b.c(paramegh);
      AppMethodBeat.o(48037);
      return;
    }
    a.b(paramegh);
    AppMethodBeat.o(48037);
  }
  
  public static IDKeyBatchReportTask bxb()
  {
    AppMethodBeat.i(48035);
    if (mqy == null) {
      mqy = new IDKeyBatchReportTask();
    }
    IDKeyBatchReportTask localIDKeyBatchReportTask = mqy;
    AppMethodBeat.o(48035);
    return localIDKeyBatchReportTask;
  }
  
  static String bxc()
  {
    AppMethodBeat.i(48036);
    if (!g.ajx())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(48036);
      throw ((Throwable)localObject);
    }
    String str = g.ajC().cachePath;
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    localObject = (String)localObject + "appbrand/report/";
    m.aLc((String)localObject);
    AppMethodBeat.o(48036);
    return localObject;
  }
  
  public static final class IDKeyBatchReportTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<IDKeyBatchReportTask> CREATOR;
    public int mqA;
    int mqB;
    public String mqC;
    public int mqD;
    egh mqE;
    
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
    
    public final void aOA()
    {
      AppMethodBeat.i(48018);
      if (1 == this.mqA)
      {
        if ((!bt.isNullOrNil(this.mqC)) && (g.ajA().gAD))
        {
          Pair localPair = ((com.tencent.mm.plugin.appbrand.appcache.b.e.b)j.T(com.tencent.mm.plugin.appbrand.appcache.b.e.b.class)).G(this.mqC, 5, this.mqD);
          if (((Boolean)localPair.first).booleanValue())
          {
            ad.i("MicroMsg.AppBrandIDKeyBatchReport", "report blocked by appid(%s) scene(%d) ", new Object[] { this.mqC, Integer.valueOf(this.mqD) });
            com.tencent.mm.plugin.appbrand.appcache.b.c.a locala = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jKA;
            com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(((Integer)localPair.second).intValue(), 167L);
            AppMethodBeat.o(48018);
            return;
          }
        }
        AppBrandIDKeyBatchReport.b.oI(0);
        AppBrandIDKeyBatchReport.b.access$300();
        AppMethodBeat.o(48018);
        return;
      }
      if (2 == this.mqA)
      {
        AppBrandIDKeyBatchReport.b.MK();
        AppMethodBeat.o(48018);
        return;
      }
      if (3 == this.mqA) {
        AppBrandIDKeyBatchReport.b.c(this.mqE);
      }
      AppMethodBeat.o(48018);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(48019);
      this.mqA = paramParcel.readInt();
      this.mqB = paramParcel.readInt();
      this.mqC = paramParcel.readString();
      this.mqD = paramParcel.readInt();
      if (3 == this.mqA) {
        try
        {
          this.mqE = new egh();
          this.mqE.parseFrom(paramParcel.createByteArray());
          AppMethodBeat.o(48019);
          return;
        }
        catch (Exception paramParcel)
        {
          ad.e("MicroMsg.AppBrandIDKeyBatchReport", "parse WxaAppRecord from parcel, e = %s", new Object[] { paramParcel });
          this.mqE = null;
        }
      }
      AppMethodBeat.o(48019);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(48020);
      paramParcel.writeInt(this.mqA);
      paramParcel.writeInt(this.mqB);
      paramParcel.writeString(this.mqC);
      paramParcel.writeInt(this.mqD);
      if (3 == this.mqA) {
        try
        {
          paramParcel.writeByteArray(this.mqE.toByteArray());
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
    private static final byte[] mqz = new byte[0];
  }
  
  static final class b
  {
    private static final ReentrantReadWriteLock mqF;
    private static volatile av mqG;
    private static volatile av mqH;
    private static volatile int mqI;
    
    static
    {
      AppMethodBeat.i(48034);
      mqF = new ReentrantReadWriteLock();
      mqG = null;
      mqH = null;
      AppMethodBeat.o(48034);
    }
    
    private static void bxe()
    {
      AppMethodBeat.i(48026);
      if (mqG != null)
      {
        mqG.stopTimer();
        mqG = null;
      }
      AppMethodBeat.o(48026);
    }
    
    private static LinkedList<egh> bxf()
    {
      AppMethodBeat.i(48027);
      mqF.readLock().lock();
      for (;;)
      {
        try
        {
          Object localObject2 = new com.tencent.mm.vfs.e(AppBrandIDKeyBatchReport.bxd());
          if (!((com.tencent.mm.vfs.e)localObject2).exists())
          {
            ad.d("MicroMsg.AppBrandIDKeyBatchReport", "reportFile not exist!");
            return null;
          }
          LinkedList localLinkedList = new LinkedList();
          long l = ((com.tencent.mm.vfs.e)localObject2).length();
          int i = 0;
          localObject2 = i.aY(AppBrandIDKeyBatchReport.bxd(), i, 4);
          if (localObject2 == null)
          {
            ad.e("MicroMsg.AppBrandIDKeyBatchReport", "preData is null!");
            return null;
          }
          int j = new DataInputStream(new ByteArrayInputStream((byte[])localObject2)).readInt();
          localObject2 = i.aY(AppBrandIDKeyBatchReport.bxd(), i + 4, j);
          if (!bt.cC((byte[])localObject2))
          {
            localLinkedList.add((egh)new egh().parseFrom((byte[])localObject2));
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
          mqF.readLock().unlock();
          AppMethodBeat.o(48027);
          return null;
        }
        finally
        {
          mqF.readLock().unlock();
          bxg();
          AppMethodBeat.o(48027);
        }
      }
    }
    
    private static void bxg()
    {
      AppMethodBeat.i(48028);
      mqF.writeLock().lock();
      try
      {
        i.deleteFile(AppBrandIDKeyBatchReport.bxd());
        mqF.writeLock().unlock();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport
 * JD-Core Version:    0.7.0.1
 */