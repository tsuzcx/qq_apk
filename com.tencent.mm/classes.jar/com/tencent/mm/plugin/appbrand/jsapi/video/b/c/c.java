package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.b;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public final class c
{
  public static final c sBU;
  public static final c sBV;
  public static final c sBW;
  private static final byte[] sBX;
  public static HashMap<String, c> sCa;
  public String sBY;
  public String sBZ;
  
  static
  {
    AppMethodBeat.i(328449);
    sBU = new c("unknown");
    sBV = new c("application/octet-stream");
    sBW = new c("video/mp4");
    sBX = new byte[] { 117, 110, 107, 110, 111, 119, 110 };
    sCa = new HashMap();
    AppMethodBeat.o(328449);
  }
  
  private c(String paramString)
  {
    this.sBY = paramString;
  }
  
  public static String abU(String paramString)
  {
    AppMethodBeat.i(328421);
    try
    {
      paramString = b.encode(paramString.getBytes("UTF-8"));
      AppMethodBeat.o(328421);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = b.encode(sBX);
      AppMethodBeat.o(328421);
    }
    return paramString;
  }
  
  private static String abV(String paramString)
  {
    AppMethodBeat.i(328427);
    try
    {
      paramString = new String(b.decode(paramString), "UTF-8");
      AppMethodBeat.o(328427);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = sBU.toString();
      AppMethodBeat.o(328427);
    }
    return paramString;
  }
  
  public static c abW(String paramString)
  {
    AppMethodBeat.i(328436);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = sBU;
      AppMethodBeat.o(328436);
      return paramString;
    }
    if (paramString.equals("video/mp4"))
    {
      paramString = sBW;
      AppMethodBeat.o(328436);
      return paramString;
    }
    if (paramString.equals("unknown"))
    {
      paramString = sBU;
      AppMethodBeat.o(328436);
      return paramString;
    }
    paramString = new c(paramString);
    AppMethodBeat.o(328436);
    return paramString;
  }
  
  public static c abX(String paramString)
  {
    AppMethodBeat.i(328442);
    if (sCa.containsKey(paramString)) {}
    c localc;
    for (paramString = (c)sCa.get(paramString);; paramString = localc)
    {
      AppMethodBeat.o(328442);
      return paramString;
      localc = abW(abV(paramString));
      sCa.put(paramString, localc);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(328463);
    if (this == paramObject)
    {
      AppMethodBeat.o(328463);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(328463);
      return false;
    }
    paramObject = (c)paramObject;
    if (this.sBY != null)
    {
      if (this.sBY.equals(paramObject.sBY)) {}
    }
    else {
      while (paramObject.sBY != null)
      {
        AppMethodBeat.o(328463);
        return false;
      }
    }
    AppMethodBeat.o(328463);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(328472);
    if (this.sBY != null)
    {
      int i = this.sBY.hashCode();
      AppMethodBeat.o(328472);
      return i;
    }
    AppMethodBeat.o(328472);
    return 0;
  }
  
  public final String toString()
  {
    return this.sBY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c
 * JD-Core Version:    0.7.0.1
 */