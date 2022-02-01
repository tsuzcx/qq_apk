package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.b;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public final class c
{
  public static final c pwO;
  public static final c pwP;
  public static final c pwQ;
  private static final byte[] pwR;
  public static HashMap<String, c> pwU;
  public String pwS;
  public String pwT;
  
  static
  {
    AppMethodBeat.i(230371);
    pwO = new c("unknown");
    pwP = new c("application/octet-stream");
    pwQ = new c("video/mp4");
    pwR = new byte[] { 117, 110, 107, 110, 111, 119, 110 };
    pwU = new HashMap();
    AppMethodBeat.o(230371);
  }
  
  private c(String paramString)
  {
    this.pwS = paramString;
  }
  
  public static String aiV(String paramString)
  {
    AppMethodBeat.i(230359);
    try
    {
      paramString = b.encode(paramString.getBytes("UTF-8"));
      AppMethodBeat.o(230359);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = b.encode(pwR);
      AppMethodBeat.o(230359);
    }
    return paramString;
  }
  
  private static String aiW(String paramString)
  {
    AppMethodBeat.i(230363);
    try
    {
      paramString = new String(b.decode(paramString), "UTF-8");
      AppMethodBeat.o(230363);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = pwO.toString();
      AppMethodBeat.o(230363);
    }
    return paramString;
  }
  
  public static c aiX(String paramString)
  {
    AppMethodBeat.i(230364);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = pwO;
      AppMethodBeat.o(230364);
      return paramString;
    }
    if (paramString.equals("video/mp4"))
    {
      paramString = pwQ;
      AppMethodBeat.o(230364);
      return paramString;
    }
    if (paramString.equals("unknown"))
    {
      paramString = pwO;
      AppMethodBeat.o(230364);
      return paramString;
    }
    paramString = new c(paramString);
    AppMethodBeat.o(230364);
    return paramString;
  }
  
  public static c aiY(String paramString)
  {
    AppMethodBeat.i(230366);
    if (pwU.containsKey(paramString)) {}
    c localc;
    for (paramString = (c)pwU.get(paramString);; paramString = localc)
    {
      AppMethodBeat.o(230366);
      return paramString;
      localc = aiX(aiW(paramString));
      pwU.put(paramString, localc);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(230369);
    if (this == paramObject)
    {
      AppMethodBeat.o(230369);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(230369);
      return false;
    }
    paramObject = (c)paramObject;
    if (this.pwS != null)
    {
      if (this.pwS.equals(paramObject.pwS)) {}
    }
    else {
      while (paramObject.pwS != null)
      {
        AppMethodBeat.o(230369);
        return false;
      }
    }
    AppMethodBeat.o(230369);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(230370);
    if (this.pwS != null)
    {
      int i = this.pwS.hashCode();
      AppMethodBeat.o(230370);
      return i;
    }
    AppMethodBeat.o(230370);
    return 0;
  }
  
  public final String toString()
  {
    return this.pwS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c
 * JD-Core Version:    0.7.0.1
 */