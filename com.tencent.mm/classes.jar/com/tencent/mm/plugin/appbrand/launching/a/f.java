package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
{
  public static int tdi = 0;
  public static int tdj = 1;
  public static int tdk = 2;
  public String appId;
  public int appType;
  public int euz;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(321097);
    if ((paramObject != null) && ((paramObject instanceof f)))
    {
      paramObject = (f)paramObject;
      if ((!Util.isNullOrNil(this.appId)) && (!Util.isNullOrNil(paramObject.appId)) && (this.appId.equals(paramObject.appId)) && (this.appType == paramObject.appType) && (this.euz == paramObject.euz))
      {
        AppMethodBeat.o(321097);
        return true;
      }
    }
    AppMethodBeat.o(321097);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(321100);
    int i = this.appId.hashCode();
    int j = this.appType;
    int k = this.euz;
    AppMethodBeat.o(321100);
    return i + j + k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.f
 * JD-Core Version:    0.7.0.1
 */