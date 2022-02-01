package com.tencent.mm.plugin.appbrand.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.file.ar;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.q;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import org.json.JSONArray;
import org.json.JSONException;

public final class x
{
  public static boolean Np(String paramString)
  {
    AppMethodBeat.i(49317);
    if ((paramString != null) && (paramString.startsWith("content://")))
    {
      AppMethodBeat.o(49317);
      return true;
    }
    AppMethodBeat.o(49317);
    return false;
  }
  
  public static boolean Nq(String paramString)
  {
    AppMethodBeat.i(49318);
    try
    {
      new JSONArray(paramString);
      AppMethodBeat.o(49318);
      return true;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(49318);
    }
    return false;
  }
  
  public static String a(o paramo, String paramString1, String paramString2)
  {
    AppMethodBeat.i(49316);
    paramString2 = Uri.parse(paramString2);
    for (;;)
    {
      try
      {
        BufferedInputStream localBufferedInputStream = new BufferedInputStream(aj.getContext().getContentResolver().openInputStream(paramString2));
        paramString2 = paramString2.getPath();
        int i = paramString2.indexOf('.');
        Object localObject;
        if (i != -1)
        {
          paramString2 = paramString2.substring(i);
          paramString1 = q.B(new com.tencent.mm.vfs.e(paramString1, "opensdkfile_" + System.currentTimeMillis() + "." + paramString2).fhU());
          localObject = new com.tencent.mm.vfs.e(paramString1);
        }
        com.tencent.mm.plugin.appbrand.aa.i locali;
        paramString2 = "";
      }
      catch (FileNotFoundException paramo)
      {
        try
        {
          localObject = com.tencent.mm.vfs.i.ai((com.tencent.mm.vfs.e)localObject);
          com.tencent.mm.b.e.copyStream(localBufferedInputStream, (OutputStream)localObject);
          locali = new com.tencent.mm.plugin.appbrand.aa.i();
          paramo.DW().a(new com.tencent.mm.vfs.e(paramString1), paramString2, true, locali);
          bt.d(localBufferedInputStream);
          bt.d((Closeable)localObject);
          paramo = (String)locali.value;
          AppMethodBeat.o(49316);
          return paramo;
        }
        catch (FileNotFoundException paramo)
        {
          ad.printErrStackTrace("MicroMsg.OpenSdkJsApiProcessor", paramo, "", new Object[0]);
          AppMethodBeat.o(49316);
        }
        paramo = paramo;
        ad.printErrStackTrace("MicroMsg.OpenSdkJsApiProcessor", paramo, "", new Object[0]);
        AppMethodBeat.o(49316);
        return "";
      }
      catch (Exception paramo)
      {
        ad.printErrStackTrace("MicroMsg.OpenSdkJsApiProcessor", paramo, "", new Object[0]);
        AppMethodBeat.o(49316);
        return "";
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.x
 * JD-Core Version:    0.7.0.1
 */