package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;

public final class o$a
{
  public final String appId;
  public final int euz;
  
  public o$a(String paramString, int paramInt)
  {
    this.appId = paramString;
    this.euz = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(320340);
    if (this == paramObject)
    {
      AppMethodBeat.o(320340);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(320340);
      return false;
    }
    paramObject = (a)paramObject;
    if ((this.euz == paramObject.euz) && (this.appId.equals(paramObject.appId)))
    {
      AppMethodBeat.o(320340);
      return true;
    }
    AppMethodBeat.o(320340);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(320341);
    int i = Objects.hash(new Object[] { this.appId, Integer.valueOf(this.euz) });
    AppMethodBeat.o(320341);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(320339);
    String str = "AppPkg{appId='" + this.appId + '\'' + ", versionType=" + this.euz + '}';
    AppMethodBeat.o(320339);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.o.a
 * JD-Core Version:    0.7.0.1
 */