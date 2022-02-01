package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.b;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public final class c
{
  public static HashMap<String, c> kpB;
  public static final c kpv;
  public static final c kpw;
  public static final c kpx;
  private static final byte[] kpy;
  public String kpA;
  public String kpz;
  
  static
  {
    AppMethodBeat.i(193932);
    kpv = new c("unknown");
    kpw = new c("application/octet-stream");
    kpx = new c("video/mp4");
    kpy = new byte[] { 117, 110, 107, 110, 111, 119, 110 };
    kpB = new HashMap();
    AppMethodBeat.o(193932);
  }
  
  private c(String paramString)
  {
    this.kpz = paramString;
  }
  
  public static String Jl(String paramString)
  {
    AppMethodBeat.i(193926);
    try
    {
      paramString = b.encode(paramString.getBytes("UTF-8"));
      AppMethodBeat.o(193926);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = b.encode(kpy);
      AppMethodBeat.o(193926);
    }
    return paramString;
  }
  
  private static String Jm(String paramString)
  {
    AppMethodBeat.i(193927);
    try
    {
      paramString = new String(b.decode(paramString), "UTF-8");
      AppMethodBeat.o(193927);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = kpv.toString();
      AppMethodBeat.o(193927);
    }
    return paramString;
  }
  
  public static c Jn(String paramString)
  {
    AppMethodBeat.i(193928);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = kpv;
      AppMethodBeat.o(193928);
      return paramString;
    }
    if (paramString.equals("video/mp4"))
    {
      paramString = kpx;
      AppMethodBeat.o(193928);
      return paramString;
    }
    if (paramString.equals("unknown"))
    {
      paramString = kpv;
      AppMethodBeat.o(193928);
      return paramString;
    }
    paramString = new c(paramString);
    AppMethodBeat.o(193928);
    return paramString;
  }
  
  public static c Jo(String paramString)
  {
    AppMethodBeat.i(193929);
    if (kpB.containsKey(paramString)) {}
    c localc;
    for (paramString = (c)kpB.get(paramString);; paramString = localc)
    {
      AppMethodBeat.o(193929);
      return paramString;
      localc = Jn(Jm(paramString));
      kpB.put(paramString, localc);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(193930);
    if (this == paramObject)
    {
      AppMethodBeat.o(193930);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(193930);
      return false;
    }
    paramObject = (c)paramObject;
    if (this.kpz != null)
    {
      if (this.kpz.equals(paramObject.kpz)) {}
    }
    else {
      while (paramObject.kpz != null)
      {
        AppMethodBeat.o(193930);
        return false;
      }
    }
    AppMethodBeat.o(193930);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(193931);
    if (this.kpz != null)
    {
      int i = this.kpz.hashCode();
      AppMethodBeat.o(193931);
      return i;
    }
    AppMethodBeat.o(193931);
    return 0;
  }
  
  public final String toString()
  {
    return this.kpz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c
 * JD-Core Version:    0.7.0.1
 */