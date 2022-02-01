package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
{
  public static int pYr = 0;
  public static int pYs = 1;
  public static int pYt = 2;
  public String appId;
  public int appType;
  public int cBU;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(271162);
    if ((paramObject != null) && ((paramObject instanceof f)))
    {
      paramObject = (f)paramObject;
      if ((!Util.isNullOrNil(this.appId)) && (!Util.isNullOrNil(paramObject.appId)) && (this.appId.equals(paramObject.appId)) && (this.appType == paramObject.appType) && (this.cBU == paramObject.cBU))
      {
        AppMethodBeat.o(271162);
        return true;
      }
    }
    AppMethodBeat.o(271162);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(271163);
    int i = this.appId.hashCode();
    int j = this.appType;
    int k = this.cBU;
    AppMethodBeat.o(271163);
    return i + j + k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.f
 * JD-Core Version:    0.7.0.1
 */