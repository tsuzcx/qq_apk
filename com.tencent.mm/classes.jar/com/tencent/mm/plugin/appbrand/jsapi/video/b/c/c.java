package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.b;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public final class c
{
  public static final c lnp;
  public static final c lnq;
  public static final c lnr;
  private static final byte[] lns;
  public static HashMap<String, c> lnv;
  public String lnt;
  public String lnu;
  
  static
  {
    AppMethodBeat.i(206091);
    lnp = new c("unknown");
    lnq = new c("application/octet-stream");
    lnr = new c("video/mp4");
    lns = new byte[] { 117, 110, 107, 110, 111, 119, 110 };
    lnv = new HashMap();
    AppMethodBeat.o(206091);
  }
  
  private c(String paramString)
  {
    this.lnt = paramString;
  }
  
  public static String QM(String paramString)
  {
    AppMethodBeat.i(206085);
    try
    {
      paramString = b.encode(paramString.getBytes("UTF-8"));
      AppMethodBeat.o(206085);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = b.encode(lns);
      AppMethodBeat.o(206085);
    }
    return paramString;
  }
  
  private static String QN(String paramString)
  {
    AppMethodBeat.i(206086);
    try
    {
      paramString = new String(b.decode(paramString), "UTF-8");
      AppMethodBeat.o(206086);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = lnp.toString();
      AppMethodBeat.o(206086);
    }
    return paramString;
  }
  
  public static c QO(String paramString)
  {
    AppMethodBeat.i(206087);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = lnp;
      AppMethodBeat.o(206087);
      return paramString;
    }
    if (paramString.equals("video/mp4"))
    {
      paramString = lnr;
      AppMethodBeat.o(206087);
      return paramString;
    }
    if (paramString.equals("unknown"))
    {
      paramString = lnp;
      AppMethodBeat.o(206087);
      return paramString;
    }
    paramString = new c(paramString);
    AppMethodBeat.o(206087);
    return paramString;
  }
  
  public static c QP(String paramString)
  {
    AppMethodBeat.i(206088);
    if (lnv.containsKey(paramString)) {}
    c localc;
    for (paramString = (c)lnv.get(paramString);; paramString = localc)
    {
      AppMethodBeat.o(206088);
      return paramString;
      localc = QO(QN(paramString));
      lnv.put(paramString, localc);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(206089);
    if (this == paramObject)
    {
      AppMethodBeat.o(206089);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(206089);
      return false;
    }
    paramObject = (c)paramObject;
    if (this.lnt != null)
    {
      if (this.lnt.equals(paramObject.lnt)) {}
    }
    else {
      while (paramObject.lnt != null)
      {
        AppMethodBeat.o(206089);
        return false;
      }
    }
    AppMethodBeat.o(206089);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(206090);
    if (this.lnt != null)
    {
      int i = this.lnt.hashCode();
      AppMethodBeat.o(206090);
      return i;
    }
    AppMethodBeat.o(206090);
    return 0;
  }
  
  public final String toString()
  {
    return this.lnt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c
 * JD-Core Version:    0.7.0.1
 */