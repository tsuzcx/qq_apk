package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import android.os.Parcel;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class o
  extends j
  implements ag
{
  private final Set<j.a> fIF = new HashSet();
  
  public final void a(j.a parama, Looper arg2)
  {
    int i = 1;
    if ((parama == null) || (??? == null)) {}
    for (;;)
    {
      return;
      super.a(parama, ???);
      synchronized (this.fIF)
      {
        this.fIF.add(parama);
        if (this.fIF.size() == 1)
        {
          if (i == 0) {
            continue;
          }
          XIPCInvoker.a("com.tencent.mm", IPCVoid.dHo, o.b.class, new o.1(this));
          return;
        }
        i = 0;
      }
    }
  }
  
  public final boolean as(String paramString, int paramInt)
  {
    paramString = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", new AppIdentity(paramString, paramInt), c.class);
    if (paramString == null) {
      return false;
    }
    return paramString.value;
  }
  
  public final void c(j.a parama)
  {
    a(parama, Looper.getMainLooper());
  }
  
  public final void d(j.a parama)
  {
    if (parama == null) {
      return;
    }
    super.d(parama);
    synchronized (this.fIF)
    {
      this.fIF.remove(parama);
      return;
    }
  }
  
  public final List<LocalUsageInfo> kz(int paramInt)
  {
    Parcel localParcel = (Parcel)XIPCInvoker.a("com.tencent.mm", new IPCInteger(paramInt), a.class);
    if (localParcel == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    localParcel.readTypedList(localArrayList, LocalUsageInfo.CREATOR);
    return localArrayList;
  }
  
  private static final class a
    implements i<IPCInteger, Parcel>
  {
    private static Parcel a(IPCInteger paramIPCInteger)
    {
      Parcel localParcel = Parcel.obtain();
      try
      {
        localParcel.writeTypedList(((ag)g.r(ag.class)).kz(paramIPCInteger.value));
        return localParcel;
      }
      catch (Exception paramIPCInteger)
      {
        localParcel.setDataPosition(0);
        localParcel.writeTypedList(null);
      }
      return localParcel;
    }
  }
  
  private static final class c
    implements i<AppIdentity, IPCBoolean>
  {
    private static IPCBoolean c(AppIdentity paramAppIdentity)
    {
      try
      {
        paramAppIdentity = new IPCBoolean(((ag)g.r(ag.class)).as(paramAppIdentity.username, paramAppIdentity.fJy));
        return paramAppIdentity;
      }
      catch (Exception paramAppIdentity)
      {
        y.printErrStackTrace("MicroMsg.AppBrandLocalUsageStorageIPCImpl", paramAppIdentity, "ipc removeUsage", new Object[0]);
      }
      return new IPCBoolean(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.o
 * JD-Core Version:    0.7.0.1
 */