package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.b;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public final class c
{
  public static HashMap<String, c> myA;
  public static final c myu;
  public static final c myv;
  public static final c myw;
  private static final byte[] myx;
  public String myy;
  public String myz;
  
  static
  {
    AppMethodBeat.i(234787);
    myu = new c("unknown");
    myv = new c("application/octet-stream");
    myw = new c("video/mp4");
    myx = new byte[] { 117, 110, 107, 110, 111, 119, 110 };
    myA = new HashMap();
    AppMethodBeat.o(234787);
  }
  
  private c(String paramString)
  {
    this.myy = paramString;
  }
  
  public static String abb(String paramString)
  {
    AppMethodBeat.i(234781);
    try
    {
      paramString = b.encode(paramString.getBytes("UTF-8"));
      AppMethodBeat.o(234781);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = b.encode(myx);
      AppMethodBeat.o(234781);
    }
    return paramString;
  }
  
  private static String abc(String paramString)
  {
    AppMethodBeat.i(234782);
    try
    {
      paramString = new String(b.decode(paramString), "UTF-8");
      AppMethodBeat.o(234782);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = myu.toString();
      AppMethodBeat.o(234782);
    }
    return paramString;
  }
  
  public static c abd(String paramString)
  {
    AppMethodBeat.i(234783);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = myu;
      AppMethodBeat.o(234783);
      return paramString;
    }
    if (paramString.equals("video/mp4"))
    {
      paramString = myw;
      AppMethodBeat.o(234783);
      return paramString;
    }
    if (paramString.equals("unknown"))
    {
      paramString = myu;
      AppMethodBeat.o(234783);
      return paramString;
    }
    paramString = new c(paramString);
    AppMethodBeat.o(234783);
    return paramString;
  }
  
  public static c abe(String paramString)
  {
    AppMethodBeat.i(234784);
    if (myA.containsKey(paramString)) {}
    c localc;
    for (paramString = (c)myA.get(paramString);; paramString = localc)
    {
      AppMethodBeat.o(234784);
      return paramString;
      localc = abd(abc(paramString));
      myA.put(paramString, localc);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(234785);
    if (this == paramObject)
    {
      AppMethodBeat.o(234785);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(234785);
      return false;
    }
    paramObject = (c)paramObject;
    if (this.myy != null)
    {
      if (this.myy.equals(paramObject.myy)) {}
    }
    else {
      while (paramObject.myy != null)
      {
        AppMethodBeat.o(234785);
        return false;
      }
    }
    AppMethodBeat.o(234785);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(234786);
    if (this.myy != null)
    {
      int i = this.myy.hashCode();
      AppMethodBeat.o(234786);
      return i;
    }
    AppMethodBeat.o(234786);
    return 0;
  }
  
  public final String toString()
  {
    return this.myy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c
 * JD-Core Version:    0.7.0.1
 */