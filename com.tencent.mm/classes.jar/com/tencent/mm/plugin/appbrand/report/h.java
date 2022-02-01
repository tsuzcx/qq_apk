package com.tencent.mm.plugin.appbrand.report;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandServiceTypeCache;", "", "()V", "TAG", "", "serviceTypeMap", "Landroid/util/SparseIntArray;", "addServiceTypeMap", "", "appId", "serviceType", "", "getServiceTypeMap", "default", "plugin-appbrand-integration_release"})
public final class h
{
  private static final SparseIntArray lRC;
  public static final h lRD;
  
  static
  {
    AppMethodBeat.i(51006);
    lRD = new h();
    lRC = new SparseIntArray();
    AppMethodBeat.o(51006);
  }
  
  public static final int QD(String paramString)
  {
    AppMethodBeat.i(51005);
    if (paramString != null)
    {
      int i = lRC.get(paramString.hashCode(), -1);
      ac.d("MicroMsg.AppBrandServiceTypeCache", "getServiceTypeMap appId: " + paramString + ", ret " + i);
      AppMethodBeat.o(51005);
      return i;
    }
    AppMethodBeat.o(51005);
    return -1;
  }
  
  public static final void bQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(51004);
    if (paramString != null)
    {
      ac.d("MicroMsg.AppBrandServiceTypeCache", "addServiceTypeMap appId: " + paramString + ", serviceType: " + paramInt);
      lRC.put(paramString.hashCode(), paramInt);
    }
    AppMethodBeat.o(51004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.h
 * JD-Core Version:    0.7.0.1
 */