package com.tencent.mm.plugin.appbrand.report;

import android.util.SparseIntArray;
import com.tencent.mm.sdk.platformtools.y;

public final class d
{
  private static final SparseIntArray gXC = new SparseIntArray();
  public static final d gXD = new d();
  
  public static final void aY(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      y.d("MicroMsg.AppBrandServiceTypeCache", "addServiceTypeMap appId: " + paramString + ", serviceType: " + paramInt);
      gXC.put(paramString.hashCode(), paramInt);
    }
  }
  
  public static final int vZ(String paramString)
  {
    int i = -1;
    if (paramString != null)
    {
      i = gXC.get(paramString.hashCode(), -1);
      y.d("MicroMsg.AppBrandServiceTypeCache", "getServiceTypeMap appId: " + paramString + ", ret " + i);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.d
 * JD-Core Version:    0.7.0.1
 */