package com.tencent.mm.plugin.appbrand.report;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandServiceTypeCache;", "", "()V", "TAG", "", "serviceTypeMap", "Landroid/util/SparseIntArray;", "addServiceTypeMap", "", "appId", "serviceType", "", "getServiceTypeMap", "default", "plugin-appbrand-integration_release"})
public final class i
{
  private static final SparseIntArray lpG;
  public static final i lpH;
  
  static
  {
    AppMethodBeat.i(51006);
    lpH = new i();
    lpG = new SparseIntArray();
    AppMethodBeat.o(51006);
  }
  
  public static final int Mu(String paramString)
  {
    AppMethodBeat.i(51005);
    if (paramString != null)
    {
      int i = lpG.get(paramString.hashCode(), -1);
      ad.d("MicroMsg.AppBrandServiceTypeCache", "getServiceTypeMap appId: " + paramString + ", ret " + i);
      AppMethodBeat.o(51005);
      return i;
    }
    AppMethodBeat.o(51005);
    return -1;
  }
  
  public static final void bM(String paramString, int paramInt)
  {
    AppMethodBeat.i(51004);
    if (paramString != null)
    {
      ad.d("MicroMsg.AppBrandServiceTypeCache", "addServiceTypeMap appId: " + paramString + ", serviceType: " + paramInt);
      lpG.put(paramString.hashCode(), paramInt);
    }
    AppMethodBeat.o(51004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.i
 * JD-Core Version:    0.7.0.1
 */