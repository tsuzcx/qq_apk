package com.tencent.mm.plugin.appbrand.appusage;

import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Parcel;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.e.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class o
  extends k
  implements ag
{
  private final Set<k.a> hbx;
  
  public o()
  {
    AppMethodBeat.i(129592);
    this.hbx = new HashSet();
    AppMethodBeat.o(129592);
  }
  
  public final boolean aF(String paramString, int paramInt)
  {
    AppMethodBeat.i(129593);
    paramString = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", new AppIdentity(paramString, paramInt), c.class);
    if (paramString == null)
    {
      AppMethodBeat.o(129593);
      return false;
    }
    boolean bool = paramString.value;
    AppMethodBeat.o(129593);
    return bool;
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(129595);
    add(parama, Looper.getMainLooper());
    AppMethodBeat.o(129595);
  }
  
  public final void add(k.a parama, Looper arg2)
  {
    int i = 1;
    AppMethodBeat.i(129596);
    if ((parama == null) || (??? == null))
    {
      AppMethodBeat.o(129596);
      return;
    }
    super.add(parama, ???);
    synchronized (this.hbx)
    {
      this.hbx.add(parama);
      if (this.hbx.size() == 1)
      {
        if (i != 0) {
          XIPCInvoker.a("com.tencent.mm", IPCVoid.eER, o.b.class, new o.1(this));
        }
        AppMethodBeat.o(129596);
        return;
      }
      i = 0;
    }
  }
  
  public final List<LocalUsageInfo> nu(int paramInt)
  {
    AppMethodBeat.i(129594);
    Parcel localParcel = (Parcel)XIPCInvoker.a("com.tencent.mm", new IPCInteger(paramInt), o.a.class);
    if (localParcel == null)
    {
      AppMethodBeat.o(129594);
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    localParcel.readTypedList(localArrayList, LocalUsageInfo.CREATOR);
    AppMethodBeat.o(129594);
    return localArrayList;
  }
  
  public final void remove(k.a parama)
  {
    AppMethodBeat.i(129597);
    if (parama == null)
    {
      AppMethodBeat.o(129597);
      return;
    }
    super.remove(parama);
    synchronized (this.hbx)
    {
      this.hbx.remove(parama);
      AppMethodBeat.o(129597);
      return;
    }
  }
  
  static final class c
    implements i<AppIdentity, IPCBoolean>
  {
    private static IPCBoolean c(AppIdentity paramAppIdentity)
    {
      AppMethodBeat.i(129590);
      try
      {
        paramAppIdentity = new IPCBoolean(((ag)g.E(ag.class)).aF(paramAppIdentity.username, paramAppIdentity.hcr));
        AppMethodBeat.o(129590);
        return paramAppIdentity;
      }
      catch (Exception paramAppIdentity)
      {
        ab.printErrStackTrace("MicroMsg.AppBrandLocalUsageStorageIPCImpl", paramAppIdentity, "ipc removeUsage", new Object[0]);
        paramAppIdentity = new IPCBoolean(false);
        AppMethodBeat.o(129590);
      }
      return paramAppIdentity;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.o
 * JD-Core Version:    0.7.0.1
 */