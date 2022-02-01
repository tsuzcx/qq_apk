package com.tencent.mm.plugin.appbrand.report;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandServiceTypeCache;", "", "()V", "TAG", "", "serviceTypeMap", "Landroid/util/SparseIntArray;", "addServiceTypeMap", "", "appId", "serviceType", "", "getServiceTypeMap", "default", "plugin-appbrand-integration_release"})
public final class i
{
  private static final SparseIntArray mrs;
  public static final i mrt;
  
  static
  {
    AppMethodBeat.i(51006);
    mrt = new i();
    mrs = new SparseIntArray();
    AppMethodBeat.o(51006);
  }
  
  public static final int Uj(String paramString)
  {
    AppMethodBeat.i(51005);
    if (paramString != null)
    {
      int i = mrs.get(paramString.hashCode(), -1);
      ad.d("MicroMsg.AppBrandServiceTypeCache", "getServiceTypeMap appId: " + paramString + ", ret " + i);
      AppMethodBeat.o(51005);
      return i;
    }
    AppMethodBeat.o(51005);
    return -1;
  }
  
  public static final void bT(String paramString, int paramInt)
  {
    AppMethodBeat.i(51004);
    if (paramString != null)
    {
      ad.d("MicroMsg.AppBrandServiceTypeCache", "addServiceTypeMap appId: " + paramString + ", serviceType: " + paramInt);
      mrs.put(paramString.hashCode(), paramInt);
    }
    AppMethodBeat.o(51004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.i
 * JD-Core Version:    0.7.0.1
 */