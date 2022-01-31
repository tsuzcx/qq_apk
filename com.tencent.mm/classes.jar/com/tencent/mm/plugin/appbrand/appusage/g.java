package com.tencent.mm.plugin.appbrand.appusage;

import a.l;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.e.k;
import java.util.ArrayList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageIPC;", "Lcom/tencent/mm/sdk/storage/MStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "()V", "addCollection", "", "username", "", "versionType", "getCount", "getCountLimit", "isCollection", "", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "count", "order", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "refreshOnPullDownOpen", "", "removeCollection", "reorder", "reorderList", "reason", "plugin-appbrand-integration_release"})
public final class g
  extends k
  implements af
{
  public final List<LocalUsageInfo> a(int paramInt, af.a parama)
  {
    AppMethodBeat.i(134534);
    parama = (Parcel)XIPCInvoker.a("com.tencent.mm", new QueryParams(paramInt, parama), aj.class);
    if (parama != null)
    {
      ArrayList localArrayList = new ArrayList();
      parama.readTypedList((List)localArrayList, LocalUsageInfo.CREATOR);
      parama = (List)localArrayList;
      AppMethodBeat.o(134534);
      return parama;
    }
    parama = (List)new ArrayList(0);
    AppMethodBeat.o(134534);
    return parama;
  }
  
  public final boolean aC(String paramString, int paramInt)
  {
    AppMethodBeat.i(134533);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(134533);
      return false;
    }
    paramString = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", new AppIdentity(paramString, paramInt), ah.class);
    if (paramString != null)
    {
      boolean bool = paramString.value;
      AppMethodBeat.o(134533);
      return bool;
    }
    AppMethodBeat.o(134533);
    return false;
  }
  
  public final int aD(String paramString, int paramInt)
  {
    AppMethodBeat.i(134531);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(134531);
      return -1;
    }
    paramString = (IPCInteger)XIPCInvoker.a("com.tencent.mm", new AppIdentity(paramString, paramInt), a.class);
    if (paramString != null)
    {
      paramInt = paramString.value;
      AppMethodBeat.o(134531);
      return paramInt;
    }
    AppMethodBeat.o(134531);
    return -1;
  }
  
  public final boolean aE(String paramString, int paramInt)
  {
    AppMethodBeat.i(134532);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(134532);
      return false;
    }
    paramString = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", new AppIdentity(paramString, paramInt), ak.class);
    if (paramString != null)
    {
      boolean bool = paramString.value;
      AppMethodBeat.o(134532);
      return bool;
    }
    AppMethodBeat.o(134532);
    return false;
  }
  
  public final void awQ() {}
  
  public final int awR()
  {
    AppMethodBeat.i(134536);
    IPCInteger localIPCInteger = (IPCInteger)XIPCInvoker.a("com.tencent.mm", IPCVoid.eER, ai.class);
    if (localIPCInteger != null)
    {
      i = localIPCInteger.value;
      AppMethodBeat.o(134536);
      return i;
    }
    int i = t.axA();
    AppMethodBeat.o(134536);
    return i;
  }
  
  public final boolean g(List<LocalUsageInfo> paramList, int paramInt)
  {
    return false;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(134535);
    IPCInteger localIPCInteger = (IPCInteger)XIPCInvoker.a("com.tencent.mm", IPCVoid.eER, ac.class);
    if (localIPCInteger != null)
    {
      int i = localIPCInteger.value;
      AppMethodBeat.o(134535);
      return i;
    }
    AppMethodBeat.o(134535);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.g
 * JD-Core Version:    0.7.0.1
 */