package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.b;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public final class c
{
  public static final c kQO;
  public static final c kQP;
  public static final c kQQ;
  private static final byte[] kQR;
  public static HashMap<String, c> kQU;
  public String kQS;
  public String kQT;
  
  static
  {
    AppMethodBeat.i(194279);
    kQO = new c("unknown");
    kQP = new c("application/octet-stream");
    kQQ = new c("video/mp4");
    kQR = new byte[] { 117, 110, 107, 110, 111, 119, 110 };
    kQU = new HashMap();
    AppMethodBeat.o(194279);
  }
  
  private c(String paramString)
  {
    this.kQS = paramString;
  }
  
  public static String Np(String paramString)
  {
    AppMethodBeat.i(194273);
    try
    {
      paramString = b.encode(paramString.getBytes("UTF-8"));
      AppMethodBeat.o(194273);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = b.encode(kQR);
      AppMethodBeat.o(194273);
    }
    return paramString;
  }
  
  private static String Nq(String paramString)
  {
    AppMethodBeat.i(194274);
    try
    {
      paramString = new String(b.decode(paramString), "UTF-8");
      AppMethodBeat.o(194274);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = kQO.toString();
      AppMethodBeat.o(194274);
    }
    return paramString;
  }
  
  public static c Nr(String paramString)
  {
    AppMethodBeat.i(194275);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = kQO;
      AppMethodBeat.o(194275);
      return paramString;
    }
    if (paramString.equals("video/mp4"))
    {
      paramString = kQQ;
      AppMethodBeat.o(194275);
      return paramString;
    }
    if (paramString.equals("unknown"))
    {
      paramString = kQO;
      AppMethodBeat.o(194275);
      return paramString;
    }
    paramString = new c(paramString);
    AppMethodBeat.o(194275);
    return paramString;
  }
  
  public static c Ns(String paramString)
  {
    AppMethodBeat.i(194276);
    if (kQU.containsKey(paramString)) {}
    c localc;
    for (paramString = (c)kQU.get(paramString);; paramString = localc)
    {
      AppMethodBeat.o(194276);
      return paramString;
      localc = Nr(Nq(paramString));
      kQU.put(paramString, localc);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(194277);
    if (this == paramObject)
    {
      AppMethodBeat.o(194277);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(194277);
      return false;
    }
    paramObject = (c)paramObject;
    if (this.kQS != null)
    {
      if (this.kQS.equals(paramObject.kQS)) {}
    }
    else {
      while (paramObject.kQS != null)
      {
        AppMethodBeat.o(194277);
        return false;
      }
    }
    AppMethodBeat.o(194277);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(194278);
    if (this.kQS != null)
    {
      int i = this.kQS.hashCode();
      AppMethodBeat.o(194278);
      return i;
    }
    AppMethodBeat.o(194278);
    return 0;
  }
  
  public final String toString()
  {
    return this.kQS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c
 * JD-Core Version:    0.7.0.1
 */