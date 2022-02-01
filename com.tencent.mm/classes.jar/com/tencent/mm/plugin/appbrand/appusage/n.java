package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class n
  extends MStorage
  implements ag
{
  private final Set<MStorage.IOnStorageChange> qOT;
  
  public n()
  {
    AppMethodBeat.i(44521);
    this.qOT = new HashSet();
    AppMethodBeat.o(44521);
  }
  
  private static List<LocalUsageInfo> g(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(319312);
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("count", paramInt1);
    ((Bundle)localObject).putInt("versionType", paramInt2);
    ((Bundle)localObject).putLong("maxUpdateTime", paramLong);
    localObject = (Parcel)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, localObject, n.a.class);
    if (localObject == null)
    {
      AppMethodBeat.o(319312);
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramInt1);
    ((Parcel)localObject).readTypedList(localArrayList, LocalUsageInfo.CREATOR);
    AppMethodBeat.o(319312);
    return localArrayList;
  }
  
  public final void add(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(44525);
    add(paramIOnStorageChange, Looper.getMainLooper());
    AppMethodBeat.o(44525);
  }
  
  public final void add(MStorage.IOnStorageChange paramIOnStorageChange, Looper arg2)
  {
    int i = 1;
    AppMethodBeat.i(44526);
    if ((paramIOnStorageChange == null) || (??? == null))
    {
      AppMethodBeat.o(44526);
      return;
    }
    super.add(paramIOnStorageChange, ???);
    synchronized (this.qOT)
    {
      this.qOT.add(paramIOnStorageChange);
      if (this.qOT.size() == 1)
      {
        if (i != 0) {
          XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.mzv, n.b.class, new f() {});
        }
        AppMethodBeat.o(44526);
        return;
      }
      i = 0;
    }
  }
  
  public final boolean bT(String paramString, int paramInt)
  {
    AppMethodBeat.i(44522);
    paramString = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new AppIdentity(paramString, paramInt), c.class);
    if (paramString == null)
    {
      AppMethodBeat.o(44522);
      return false;
    }
    boolean bool = paramString.value;
    AppMethodBeat.o(44522);
    return bool;
  }
  
  public final List<LocalUsageInfo> fg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44524);
    List localList = g(paramInt1, paramInt2, 9223372036854775807L);
    AppMethodBeat.o(44524);
    return localList;
  }
  
  public final List<LocalUsageInfo> r(long paramLong, int paramInt)
  {
    AppMethodBeat.i(319320);
    List localList = g(paramInt, 2147483647, paramLong);
    AppMethodBeat.o(319320);
    return localList;
  }
  
  public final void remove(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(44527);
    if (paramIOnStorageChange == null)
    {
      AppMethodBeat.o(44527);
      return;
    }
    super.remove(paramIOnStorageChange);
    synchronized (this.qOT)
    {
      this.qOT.remove(paramIOnStorageChange);
      AppMethodBeat.o(44527);
      return;
    }
  }
  
  public final List<LocalUsageInfo> zu(int paramInt)
  {
    AppMethodBeat.i(44523);
    List localList = fg(paramInt, 2147483647);
    AppMethodBeat.o(44523);
    return localList;
  }
  
  static final class c
    implements m<AppIdentity, IPCBoolean>
  {
    private static IPCBoolean d(AppIdentity paramAppIdentity)
    {
      AppMethodBeat.i(44519);
      try
      {
        paramAppIdentity = new IPCBoolean(((ag)h.ax(ag.class)).bT(paramAppIdentity.username, paramAppIdentity.euz));
        AppMethodBeat.o(44519);
        return paramAppIdentity;
      }
      catch (Exception paramAppIdentity)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandLocalUsageStorageIPCImpl", paramAppIdentity, "ipc removeUsage", new Object[0]);
        paramAppIdentity = new IPCBoolean(false);
        AppMethodBeat.o(44519);
      }
      return paramAppIdentity;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.n
 * JD-Core Version:    0.7.0.1
 */