package com.tencent.mm.plugin.appbrand.report;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandServiceTypeCache;", "", "()V", "TAG", "", "serviceTypeMap", "Landroid/util/SparseIntArray;", "addServiceTypeMap", "", "appId", "serviceType", "", "getServiceTypeMap", "default", "plugin-appbrand-integration_release"})
public final class j
{
  private static final SparseIntArray nHo;
  public static final j nHp;
  
  static
  {
    AppMethodBeat.i(51006);
    nHp = new j();
    nHo = new SparseIntArray();
    AppMethodBeat.o(51006);
  }
  
  public static final int aeJ(String paramString)
  {
    AppMethodBeat.i(51005);
    if (paramString != null)
    {
      int i = nHo.get(paramString.hashCode(), -1);
      Log.d("MicroMsg.AppBrandServiceTypeCache", "getServiceTypeMap appId: " + paramString + ", ret " + i);
      AppMethodBeat.o(51005);
      return i;
    }
    AppMethodBeat.o(51005);
    return -1;
  }
  
  public static final void cg(String paramString, int paramInt)
  {
    AppMethodBeat.i(51004);
    if (paramString != null)
    {
      Log.d("MicroMsg.AppBrandServiceTypeCache", "addServiceTypeMap appId: " + paramString + ", serviceType: " + paramInt);
      nHo.put(paramString.hashCode(), paramInt);
    }
    AppMethodBeat.o(51004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.j
 * JD-Core Version:    0.7.0.1
 */