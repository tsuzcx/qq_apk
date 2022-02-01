package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.ehu;
import com.tencent.mm.protocal.protobuf.ehy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public final class AppBrandIDKeyBatchReport
{
  private static volatile IDKeyBatchReportTask mvw;
  
  public static void a(ehy paramehy)
  {
    AppMethodBeat.i(48037);
    if (ak.cpe())
    {
      b.c(paramehy);
      AppMethodBeat.o(48037);
      return;
    }
    a.b(paramehy);
    AppMethodBeat.o(48037);
  }
  
  public static IDKeyBatchReportTask bxU()
  {
    AppMethodBeat.i(48035);
    if (mvw == null) {
      mvw = new IDKeyBatchReportTask();
    }
    IDKeyBatchReportTask localIDKeyBatchReportTask = mvw;
    AppMethodBeat.o(48035);
    return localIDKeyBatchReportTask;
  }
  
  static String bxV()
  {
    AppMethodBeat.i(48036);
    if (!g.ajM())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(48036);
      throw ((Throwable)localObject);
    }
    String str = g.ajR().cachePath;
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    localObject = (String)localObject + "appbrand/report/";
    com.tencent.mm.sdk.platformtools.n.aMy((String)localObject);
    AppMethodBeat.o(48036);
    return localObject;
  }
  
  public static final class IDKeyBatchReportTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<IDKeyBatchReportTask> CREATOR;
    public String mvA;
    public int mvB;
    ehy mvC;
    public int mvy;
    int mvz;
    
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
    
    public final void aOX()
    {
      AppMethodBeat.i(48018);
      if (1 == this.mvy)
      {
        if ((!bu.isNullOrNil(this.mvA)) && (g.ajP().gDk))
        {
          Pair localPair = ((com.tencent.mm.plugin.appbrand.appcache.b.e.b)j.T(com.tencent.mm.plugin.appbrand.appcache.b.e.b.class)).G(this.mvA, 5, this.mvB);
          if (((Boolean)localPair.first).booleanValue())
          {
            ae.i("MicroMsg.AppBrandIDKeyBatchReport", "report blocked by appid(%s) scene(%d) ", new Object[] { this.mvA, Integer.valueOf(this.mvB) });
            com.tencent.mm.plugin.appbrand.appcache.b.c.a locala = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jNM;
            com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(((Integer)localPair.second).intValue(), 167L);
            AppMethodBeat.o(48018);
            return;
          }
        }
        AppBrandIDKeyBatchReport.b.oL(0);
        AppBrandIDKeyBatchReport.b.access$300();
        AppMethodBeat.o(48018);
        return;
      }
      if (2 == this.mvy)
      {
        AppBrandIDKeyBatchReport.b.MF();
        AppMethodBeat.o(48018);
        return;
      }
      if (3 == this.mvy) {
        AppBrandIDKeyBatchReport.b.c(this.mvC);
      }
      AppMethodBeat.o(48018);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(48019);
      this.mvy = paramParcel.readInt();
      this.mvz = paramParcel.readInt();
      this.mvA = paramParcel.readString();
      this.mvB = paramParcel.readInt();
      if (3 == this.mvy) {
        try
        {
          this.mvC = new ehy();
          this.mvC.parseFrom(paramParcel.createByteArray());
          AppMethodBeat.o(48019);
          return;
        }
        catch (Exception paramParcel)
        {
          ae.e("MicroMsg.AppBrandIDKeyBatchReport", "parse WxaAppRecord from parcel, e = %s", new Object[] { paramParcel });
          this.mvC = null;
        }
      }
      AppMethodBeat.o(48019);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(48020);
      paramParcel.writeInt(this.mvy);
      paramParcel.writeInt(this.mvz);
      paramParcel.writeString(this.mvA);
      paramParcel.writeInt(this.mvB);
      if (3 == this.mvy) {
        try
        {
          paramParcel.writeByteArray(this.mvC.toByteArray());
          AppMethodBeat.o(48020);
          return;
        }
        catch (Exception paramParcel)
        {
          ae.e("MicroMsg.AppBrandIDKeyBatchReport", "write WxaAppRecord to parcel, e = %s", new Object[] { paramParcel });
        }
      }
      AppMethodBeat.o(48020);
    }
  }
  
  static final class a
  {
    private static final byte[] mvx = new byte[0];
  }
  
  static final class b
  {
    private static final ReentrantReadWriteLock mvD;
    private static volatile aw mvE;
    private static volatile aw mvF;
    private static volatile int mvG;
    
    static
    {
      AppMethodBeat.i(48034);
      mvD = new ReentrantReadWriteLock();
      mvE = null;
      mvF = null;
      AppMethodBeat.o(48034);
    }
    
    private static void bxX()
    {
      AppMethodBeat.i(48026);
      if (mvE != null)
      {
        mvE.stopTimer();
        mvE = null;
      }
      AppMethodBeat.o(48026);
    }
    
    private static LinkedList<ehy> bxY()
    {
      AppMethodBeat.i(48027);
      mvD.readLock().lock();
      for (;;)
      {
        try
        {
          Object localObject2 = new k(AppBrandIDKeyBatchReport.bxW());
          if (!((k)localObject2).exists())
          {
            ae.d("MicroMsg.AppBrandIDKeyBatchReport", "reportFile not exist!");
            return null;
          }
          LinkedList localLinkedList = new LinkedList();
          long l = ((k)localObject2).length();
          int i = 0;
          localObject2 = o.bb(AppBrandIDKeyBatchReport.bxW(), i, 4);
          if (localObject2 == null)
          {
            ae.e("MicroMsg.AppBrandIDKeyBatchReport", "preData is null!");
            return null;
          }
          int j = new DataInputStream(new ByteArrayInputStream((byte[])localObject2)).readInt();
          localObject2 = o.bb(AppBrandIDKeyBatchReport.bxW(), i + 4, j);
          if (!bu.cF((byte[])localObject2))
          {
            localLinkedList.add((ehy)new ehy().parseFrom((byte[])localObject2));
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
          ae.e("MicroMsg.AppBrandIDKeyBatchReport", "read file error %s", new Object[] { localException.getMessage() });
          ae.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", localException, "readReportData()", new Object[0]);
          return null;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          ae.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", localOutOfMemoryError, "readReportData()", new Object[0]);
          mvD.readLock().unlock();
          AppMethodBeat.o(48027);
          return null;
        }
        finally
        {
          mvD.readLock().unlock();
          bxZ();
          AppMethodBeat.o(48027);
        }
      }
    }
    
    private static void bxZ()
    {
      AppMethodBeat.i(48028);
      mvD.writeLock().lock();
      try
      {
        o.deleteFile(AppBrandIDKeyBatchReport.bxW());
        mvD.writeLock().unlock();
        AppMethodBeat.o(48028);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", localException, "removeFile()", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport
 * JD-Core Version:    0.7.0.1
 */