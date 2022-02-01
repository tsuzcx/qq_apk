package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.storage.MStorage;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageIPC;", "Lcom/tencent/mm/sdk/storage/MStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "()V", "addCollection", "", "username", "", "versionType", "getCount", "getCountLimit", "isCollection", "", "isCollectionForAppId", "appId", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "count", "order", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "removeCollection", "reorder", "reorderList", "reason", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends MStorage
  implements af
{
  private static final IPCBoolean a(AppIdentity paramAppIdentity)
  {
    AppMethodBeat.i(319336);
    String str;
    int i;
    if ((h.baz()) && (paramAppIdentity != null))
    {
      str = g.b(paramAppIdentity);
      i = g.c(paramAppIdentity);
    }
    for (boolean bool = ((af)h.ax(af.class)).bQ(str, i);; bool = false)
    {
      paramAppIdentity = new IPCBoolean(bool);
      AppMethodBeat.o(319336);
      return paramAppIdentity;
    }
  }
  
  public final List<LocalUsageInfo> a(int paramInt, af.a parama)
  {
    AppMethodBeat.i(50269);
    parama = a(paramInt, parama, 2147483647);
    AppMethodBeat.o(50269);
    return parama;
  }
  
  public final List<LocalUsageInfo> a(int paramInt1, af.a parama, int paramInt2)
  {
    AppMethodBeat.i(50270);
    Parcel localParcel = (Parcel)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new QueryParams(paramInt1, parama, paramInt2), ak.class);
    if (localParcel == null) {
      parama = null;
    }
    while (parama == null)
    {
      parama = (List)new ArrayList(0);
      AppMethodBeat.o(50270);
      return parama;
      parama = new ArrayList();
      localParcel.readTypedList((List)parama, LocalUsageInfo.CREATOR);
    }
    parama = (List)parama;
    AppMethodBeat.o(50270);
    return parama;
  }
  
  public final boolean bP(String paramString, int paramInt)
  {
    AppMethodBeat.i(50268);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50268);
      return false;
    }
    paramString = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new AppIdentity(paramString, paramInt), ah.class);
    if (paramString == null)
    {
      AppMethodBeat.o(50268);
      return false;
    }
    boolean bool = paramString.value;
    AppMethodBeat.o(50268);
    return bool;
  }
  
  public final boolean bQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(319342);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(319342);
      return false;
    }
    paramString = (IPCBoolean)com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new AppIdentity(paramString, paramInt), f..ExternalSyntheticLambda0.INSTANCE);
    if (paramString == null)
    {
      AppMethodBeat.o(319342);
      return false;
    }
    boolean bool = paramString.value;
    AppMethodBeat.o(319342);
    return bool;
  }
  
  public final int bR(String paramString, int paramInt)
  {
    AppMethodBeat.i(50266);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50266);
      return -1;
    }
    paramString = (IPCInteger)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new AppIdentity(paramString, paramInt), a.class);
    if (paramString == null)
    {
      AppMethodBeat.o(50266);
      return -1;
    }
    paramInt = paramString.value;
    AppMethodBeat.o(50266);
    return paramInt;
  }
  
  public final boolean bS(String paramString, int paramInt)
  {
    AppMethodBeat.i(50267);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50267);
      return false;
    }
    paramString = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new AppIdentity(paramString, paramInt), al.class);
    if (paramString == null)
    {
      AppMethodBeat.o(50267);
      return false;
    }
    boolean bool = paramString.value;
    AppMethodBeat.o(50267);
    return bool;
  }
  
  public final int ciA()
  {
    AppMethodBeat.i(50272);
    Object localObject = (IPCInteger)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.mzv, ai.class);
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = Integer.valueOf(((IPCInteger)localObject).value))
    {
      i = u.cjh();
      AppMethodBeat.o(50272);
      return i;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(50272);
    return i;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(50271);
    IPCInteger localIPCInteger = (IPCInteger)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.mzv, ac.class);
    if (localIPCInteger == null)
    {
      AppMethodBeat.o(50271);
      return 0;
    }
    int i = localIPCInteger.value;
    AppMethodBeat.o(50271);
    return i;
  }
  
  public final boolean p(List<LocalUsageInfo> paramList, int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.f
 * JD-Core Version:    0.7.0.1
 */