package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.b;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public final class c
{
  public static final c lrO;
  public static final c lrP;
  public static final c lrQ;
  private static final byte[] lrR;
  public static HashMap<String, c> lrU;
  public String lrS;
  public String lrT;
  
  static
  {
    AppMethodBeat.i(211118);
    lrO = new c("unknown");
    lrP = new c("application/octet-stream");
    lrQ = new c("video/mp4");
    lrR = new byte[] { 117, 110, 107, 110, 111, 119, 110 };
    lrU = new HashMap();
    AppMethodBeat.o(211118);
  }
  
  private c(String paramString)
  {
    this.lrS = paramString;
  }
  
  public static String Rv(String paramString)
  {
    AppMethodBeat.i(211112);
    try
    {
      paramString = b.encode(paramString.getBytes("UTF-8"));
      AppMethodBeat.o(211112);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = b.encode(lrR);
      AppMethodBeat.o(211112);
    }
    return paramString;
  }
  
  private static String Rw(String paramString)
  {
    AppMethodBeat.i(211113);
    try
    {
      paramString = new String(b.decode(paramString), "UTF-8");
      AppMethodBeat.o(211113);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = lrO.toString();
      AppMethodBeat.o(211113);
    }
    return paramString;
  }
  
  public static c Rx(String paramString)
  {
    AppMethodBeat.i(211114);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = lrO;
      AppMethodBeat.o(211114);
      return paramString;
    }
    if (paramString.equals("video/mp4"))
    {
      paramString = lrQ;
      AppMethodBeat.o(211114);
      return paramString;
    }
    if (paramString.equals("unknown"))
    {
      paramString = lrO;
      AppMethodBeat.o(211114);
      return paramString;
    }
    paramString = new c(paramString);
    AppMethodBeat.o(211114);
    return paramString;
  }
  
  public static c Ry(String paramString)
  {
    AppMethodBeat.i(211115);
    if (lrU.containsKey(paramString)) {}
    c localc;
    for (paramString = (c)lrU.get(paramString);; paramString = localc)
    {
      AppMethodBeat.o(211115);
      return paramString;
      localc = Rx(Rw(paramString));
      lrU.put(paramString, localc);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(211116);
    if (this == paramObject)
    {
      AppMethodBeat.o(211116);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(211116);
      return false;
    }
    paramObject = (c)paramObject;
    if (this.lrS != null)
    {
      if (this.lrS.equals(paramObject.lrS)) {}
    }
    else {
      while (paramObject.lrS != null)
      {
        AppMethodBeat.o(211116);
        return false;
      }
    }
    AppMethodBeat.o(211116);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(211117);
    if (this.lrS != null)
    {
      int i = this.lrS.hashCode();
      AppMethodBeat.o(211117);
      return i;
    }
    AppMethodBeat.o(211117);
    return 0;
  }
  
  public final String toString()
  {
    return this.lrS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c
 * JD-Core Version:    0.7.0.1
 */