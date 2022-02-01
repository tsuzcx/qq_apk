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

public final class o
  extends MStorage
  implements ah
{
  private final Set<MStorage.IOnStorageChange> nPb;
  
  public o()
  {
    AppMethodBeat.i(44521);
    this.nPb = new HashSet();
    AppMethodBeat.o(44521);
  }
  
  private static List<LocalUsageInfo> g(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(269763);
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("count", paramInt1);
    ((Bundle)localObject).putInt("versionType", paramInt2);
    ((Bundle)localObject).putLong("maxUpdateTime", paramLong);
    localObject = (Parcel)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, localObject, a.class);
    if (localObject == null)
    {
      AppMethodBeat.o(269763);
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramInt1);
    ((Parcel)localObject).readTypedList(localArrayList, LocalUsageInfo.CREATOR);
    AppMethodBeat.o(269763);
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
    synchronized (this.nPb)
    {
      this.nPb.add(paramIOnStorageChange);
      if (this.nPb.size() == 1)
      {
        if (i != 0) {
          XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.jZu, o.b.class, new f() {});
        }
        AppMethodBeat.o(44526);
        return;
      }
      i = 0;
    }
  }
  
  public final boolean bB(String paramString, int paramInt)
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
  
  public final List<LocalUsageInfo> en(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44524);
    List localList = g(paramInt1, paramInt2, 9223372036854775807L);
    AppMethodBeat.o(44524);
    return localList;
  }
  
  public final List<LocalUsageInfo> i(long paramLong, int paramInt)
  {
    AppMethodBeat.i(269762);
    List localList = g(paramInt, 2147483647, paramLong);
    AppMethodBeat.o(269762);
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
    synchronized (this.nPb)
    {
      this.nPb.remove(paramIOnStorageChange);
      AppMethodBeat.o(44527);
      return;
    }
  }
  
  public final List<LocalUsageInfo> zh(int paramInt)
  {
    AppMethodBeat.i(44523);
    List localList = en(paramInt, 2147483647);
    AppMethodBeat.o(44523);
    return localList;
  }
  
  static final class a
    implements m<Bundle, Parcel>
  {
    private static Parcel M(Bundle paramBundle)
    {
      AppMethodBeat.i(44513);
      int i = paramBundle.getInt("count");
      int j = paramBundle.getInt("versionType", 2147483647);
      long l = paramBundle.getLong("maxUpdateTime", 9223372036854775807L);
      paramBundle = Parcel.obtain();
      if (l != 9223372036854775807L) {}
      for (;;)
      {
        try
        {
          paramBundle.writeTypedList(((ah)h.ae(ah.class)).i(l, i));
          AppMethodBeat.o(44513);
          return paramBundle;
        }
        catch (Exception localException)
        {
          paramBundle.setDataPosition(0);
          paramBundle.writeTypedList(null);
          AppMethodBeat.o(44513);
        }
        paramBundle.writeTypedList(((ah)h.ae(ah.class)).en(i, j));
      }
      return paramBundle;
    }
  }
  
  static final class c
    implements m<AppIdentity, IPCBoolean>
  {
    private static IPCBoolean c(AppIdentity paramAppIdentity)
    {
      AppMethodBeat.i(44519);
      try
      {
        paramAppIdentity = new IPCBoolean(((ah)h.ae(ah.class)).bB(paramAppIdentity.username, paramAppIdentity.cBU));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.o
 * JD-Core Version:    0.7.0.1
 */