package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.e.j;
import java.util.ArrayList;
import java.util.List;

public final class g
  extends j
  implements af
{
  public final List<LocalUsageInfo> a(int paramInt, af.a parama)
  {
    parama = (Parcel)XIPCInvoker.a("com.tencent.mm", new QueryParams(paramInt, parama), aj.class);
    if (parama != null)
    {
      ArrayList localArrayList = new ArrayList();
      parama.readTypedList((List)localArrayList, LocalUsageInfo.CREATOR);
      return (List)localArrayList;
    }
    return (List)new ArrayList(0);
  }
  
  public final void acK() {}
  
  public final int acL()
  {
    IPCInteger localIPCInteger = (IPCInteger)XIPCInvoker.a("com.tencent.mm", IPCVoid.dHo, ai.class);
    if (localIPCInteger != null) {
      return localIPCInteger.value;
    }
    return t.ads();
  }
  
  public final boolean ap(String paramString, int paramInt)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0) {
      return false;
    }
    paramString = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", new AppIdentity(paramString, paramInt), ah.class);
    if (paramString != null) {
      return paramString.value;
    }
    return false;
  }
  
  public final int aq(String paramString, int paramInt)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0) {
      return -1;
    }
    paramString = (IPCInteger)XIPCInvoker.a("com.tencent.mm", new AppIdentity(paramString, paramInt), a.class);
    if (paramString != null) {
      return paramString.value;
    }
    return -1;
  }
  
  public final boolean ar(String paramString, int paramInt)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0) {
      return false;
    }
    paramString = (IPCBoolean)XIPCInvoker.a("com.tencent.mm", new AppIdentity(paramString, paramInt), ak.class);
    if (paramString != null) {
      return paramString.value;
    }
    return false;
  }
  
  public final boolean d(List<LocalUsageInfo> paramList, int paramInt)
  {
    return false;
  }
  
  public final int getCount()
  {
    IPCInteger localIPCInteger = (IPCInteger)XIPCInvoker.a("com.tencent.mm", IPCVoid.dHo, ac.class);
    if (localIPCInteger != null) {
      return localIPCInteger.value;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.g
 * JD-Core Version:    0.7.0.1
 */