package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Parcel;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class o
  extends com.tencent.mm.sdk.e.k
  implements ai
{
  private final Set<k.a> iUD;
  
  public o()
  {
    AppMethodBeat.i(44521);
    this.iUD = new HashSet();
    AppMethodBeat.o(44521);
  }
  
  public final boolean aU(String paramString, int paramInt)
  {
    AppMethodBeat.i(44522);
    paramString = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", new AppIdentity(paramString, paramInt), c.class);
    if (paramString == null)
    {
      AppMethodBeat.o(44522);
      return false;
    }
    boolean bool = paramString.value;
    AppMethodBeat.o(44522);
    return bool;
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(44525);
    add(parama, Looper.getMainLooper());
    AppMethodBeat.o(44525);
  }
  
  public final void add(k.a parama, Looper arg2)
  {
    int i = 1;
    AppMethodBeat.i(44526);
    if ((parama == null) || (??? == null))
    {
      AppMethodBeat.o(44526);
      return;
    }
    super.add(parama, ???);
    synchronized (this.iUD)
    {
      this.iUD.add(parama);
      if (this.iUD.size() == 1)
      {
        if (i != 0) {
          XIPCInvoker.a("com.tencent.mm", IPCVoid.fZS, b.class, new d() {});
        }
        AppMethodBeat.o(44526);
        return;
      }
      i = 0;
    }
  }
  
  public final List<LocalUsageInfo> dC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44524);
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("count", paramInt1);
    ((Bundle)localObject).putInt("versionType", paramInt2);
    localObject = (Parcel)XIPCInvoker.a("com.tencent.mm", localObject, a.class);
    if (localObject == null)
    {
      AppMethodBeat.o(44524);
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramInt1);
    ((Parcel)localObject).readTypedList(localArrayList, LocalUsageInfo.CREATOR);
    AppMethodBeat.o(44524);
    return localArrayList;
  }
  
  public final List<LocalUsageInfo> qL(int paramInt)
  {
    AppMethodBeat.i(44523);
    List localList = dC(paramInt, 2147483647);
    AppMethodBeat.o(44523);
    return localList;
  }
  
  public final void remove(k.a parama)
  {
    AppMethodBeat.i(44527);
    if (parama == null)
    {
      AppMethodBeat.o(44527);
      return;
    }
    super.remove(parama);
    synchronized (this.iUD)
    {
      this.iUD.remove(parama);
      AppMethodBeat.o(44527);
      return;
    }
  }
  
  static final class a
    implements com.tencent.mm.ipcinvoker.k<Bundle, Parcel>
  {
    private static Parcel y(Bundle paramBundle)
    {
      AppMethodBeat.i(44513);
      int i = paramBundle.getInt("count");
      int j = paramBundle.getInt("versionType", 2147483647);
      paramBundle = Parcel.obtain();
      try
      {
        paramBundle.writeTypedList(((ai)g.ab(ai.class)).dC(i, j));
        AppMethodBeat.o(44513);
        return paramBundle;
      }
      catch (Exception localException)
      {
        paramBundle.setDataPosition(0);
        paramBundle.writeTypedList(null);
        AppMethodBeat.o(44513);
      }
      return paramBundle;
    }
  }
  
  static final class b
    implements com.tencent.mm.ipcinvoker.b<IPCVoid, Parcel>
  {}
  
  static final class c
    implements com.tencent.mm.ipcinvoker.k<AppIdentity, IPCBoolean>
  {
    private static IPCBoolean c(AppIdentity paramAppIdentity)
    {
      AppMethodBeat.i(44519);
      try
      {
        paramAppIdentity = new IPCBoolean(((ai)g.ab(ai.class)).aU(paramAppIdentity.username, paramAppIdentity.gXn));
        AppMethodBeat.o(44519);
        return paramAppIdentity;
      }
      catch (Exception paramAppIdentity)
      {
        ad.printErrStackTrace("MicroMsg.AppBrandLocalUsageStorageIPCImpl", paramAppIdentity, "ipc removeUsage", new Object[0]);
        paramAppIdentity = new IPCBoolean(false);
        AppMethodBeat.o(44519);
      }
      return paramAppIdentity;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.o
 * JD-Core Version:    0.7.0.1
 */