package com.tencent.mm.plugin.appbrand.report;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandServiceTypeCache;", "", "()V", "TAG", "", "serviceTypeMap", "Landroid/util/SparseIntArray;", "addServiceTypeMap", "", "appId", "serviceType", "", "getServiceTypeMap", "default", "plugin-appbrand-integration_release"})
public final class i
{
  private static final SparseIntArray mwq;
  public static final i mwr;
  
  static
  {
    AppMethodBeat.i(51006);
    mwr = new i();
    mwq = new SparseIntArray();
    AppMethodBeat.o(51006);
  }
  
  public static final int UU(String paramString)
  {
    AppMethodBeat.i(51005);
    if (paramString != null)
    {
      int i = mwq.get(paramString.hashCode(), -1);
      ae.d("MicroMsg.AppBrandServiceTypeCache", "getServiceTypeMap appId: " + paramString + ", ret " + i);
      AppMethodBeat.o(51005);
      return i;
    }
    AppMethodBeat.o(51005);
    return -1;
  }
  
  public static final void bX(String paramString, int paramInt)
  {
    AppMethodBeat.i(51004);
    if (paramString != null)
    {
      ae.d("MicroMsg.AppBrandServiceTypeCache", "addServiceTypeMap appId: " + paramString + ", serviceType: " + paramInt);
      mwq.put(paramString.hashCode(), paramInt);
    }
    AppMethodBeat.o(51004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.i
 * JD-Core Version:    0.7.0.1
 */