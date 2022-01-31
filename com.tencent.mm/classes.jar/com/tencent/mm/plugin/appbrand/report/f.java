package com.tencent.mm.plugin.appbrand.report;

import a.l;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandServiceTypeCache;", "", "()V", "TAG", "", "serviceTypeMap", "Landroid/util/SparseIntArray;", "addServiceTypeMap", "", "appId", "serviceType", "", "getServiceTypeMap", "default", "plugin-appbrand-integration_release"})
public final class f
{
  private static final SparseIntArray iFS;
  public static final f iFT;
  
  static
  {
    AppMethodBeat.i(134937);
    iFT = new f();
    iFS = new SparseIntArray();
    AppMethodBeat.o(134937);
  }
  
  public static final int EE(String paramString)
  {
    AppMethodBeat.i(134936);
    if (paramString != null)
    {
      int i = iFS.get(paramString.hashCode(), -1);
      ab.d("MicroMsg.AppBrandServiceTypeCache", "getServiceTypeMap appId: " + paramString + ", ret " + i);
      AppMethodBeat.o(134936);
      return i;
    }
    AppMethodBeat.o(134936);
    return -1;
  }
  
  public static final void br(String paramString, int paramInt)
  {
    AppMethodBeat.i(134934);
    if (paramString != null)
    {
      ab.d("MicroMsg.AppBrandServiceTypeCache", "addServiceTypeMap appId: " + paramString + ", serviceType: " + paramInt);
      iFS.put(paramString.hashCode(), paramInt);
    }
    AppMethodBeat.o(134934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.f
 * JD-Core Version:    0.7.0.1
 */