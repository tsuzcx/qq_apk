package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.sdk.storage.MStorage;
import java.util.ArrayList;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageIPC;", "Lcom/tencent/mm/sdk/storage/MStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "()V", "addCollection", "", "username", "", "versionType", "getCount", "getCountLimit", "isCollection", "", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "count", "order", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "refreshOnPullDownOpen", "", "refreshOnPullDownOpenAnimationEnd", "removeCollection", "reorder", "reorderList", "reason", "plugin-appbrand-integration_release"})
public final class g
  extends MStorage
  implements ag
{
  public final List<LocalUsageInfo> a(int paramInt, ag.a parama)
  {
    AppMethodBeat.i(50269);
    parama = a(paramInt, parama, 2147483647);
    AppMethodBeat.o(50269);
    return parama;
  }
  
  public final List<LocalUsageInfo> a(int paramInt1, ag.a parama, int paramInt2)
  {
    AppMethodBeat.i(50270);
    parama = (Parcel)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new QueryParams(paramInt1, parama, paramInt2), al.class);
    if (parama != null)
    {
      ArrayList localArrayList = new ArrayList();
      parama.readTypedList((List)localArrayList, LocalUsageInfo.CREATOR);
      parama = (List)localArrayList;
      AppMethodBeat.o(50270);
      return parama;
    }
    parama = (List)new ArrayList(0);
    AppMethodBeat.o(50270);
    return parama;
  }
  
  public final boolean bA(String paramString, int paramInt)
  {
    AppMethodBeat.i(50267);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50267);
      return false;
    }
    paramString = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new AppIdentity(paramString, paramInt), am.class);
    if (paramString != null)
    {
      boolean bool = paramString.value;
      AppMethodBeat.o(50267);
      return bool;
    }
    AppMethodBeat.o(50267);
    return false;
  }
  
  public final int bIW()
  {
    AppMethodBeat.i(50272);
    IPCInteger localIPCInteger = (IPCInteger)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.jZu, aj.class);
    if (localIPCInteger != null)
    {
      i = localIPCInteger.value;
      AppMethodBeat.o(50272);
      return i;
    }
    int i = v.bJC();
    AppMethodBeat.o(50272);
    return i;
  }
  
  public final boolean by(String paramString, int paramInt)
  {
    AppMethodBeat.i(50268);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50268);
      return false;
    }
    paramString = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new AppIdentity(paramString, paramInt), ai.class);
    if (paramString != null)
    {
      boolean bool = paramString.value;
      AppMethodBeat.o(50268);
      return bool;
    }
    AppMethodBeat.o(50268);
    return false;
  }
  
  public final int bz(String paramString, int paramInt)
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
    if (paramString != null)
    {
      paramInt = paramString.value;
      AppMethodBeat.o(50266);
      return paramInt;
    }
    AppMethodBeat.o(50266);
    return -1;
  }
  
  public final boolean g(List<LocalUsageInfo> paramList, int paramInt)
  {
    return false;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(50271);
    IPCInteger localIPCInteger = (IPCInteger)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.jZu, ad.class);
    if (localIPCInteger != null)
    {
      int i = localIPCInteger.value;
      AppMethodBeat.o(50271);
      return i;
    }
    AppMethodBeat.o(50271);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.g
 * JD-Core Version:    0.7.0.1
 */