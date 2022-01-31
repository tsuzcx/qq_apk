package com.tencent.mm.plugin.appbrand.t;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.file.an;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import org.json.JSONArray;
import org.json.JSONException;

public final class s
{
  public static boolean Fs(String paramString)
  {
    AppMethodBeat.i(133592);
    if ((paramString != null) && (paramString.startsWith("content://")))
    {
      AppMethodBeat.o(133592);
      return true;
    }
    AppMethodBeat.o(133592);
    return false;
  }
  
  public static boolean Ft(String paramString)
  {
    AppMethodBeat.i(133593);
    try
    {
      new JSONArray(paramString);
      AppMethodBeat.o(133593);
      return true;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(133593);
    }
    return false;
  }
  
  public static String a(o paramo, String paramString1, String paramString2)
  {
    AppMethodBeat.i(133591);
    paramString2 = Uri.parse(paramString2);
    for (;;)
    {
      try
      {
        BufferedInputStream localBufferedInputStream = new BufferedInputStream(ah.getContext().getContentResolver().openInputStream(paramString2));
        paramString2 = paramString2.getPath();
        int i = paramString2.indexOf('.');
        Object localObject;
        if (i != -1)
        {
          paramString2 = paramString2.substring(i);
          paramString1 = new File(paramString1, "opensdkfile_" + System.currentTimeMillis() + "." + paramString2).getAbsolutePath();
          localObject = new File(paramString1);
        }
        j localj;
        paramString2 = "";
      }
      catch (FileNotFoundException paramo)
      {
        try
        {
          localObject = new FileOutputStream((File)localObject);
          e.copyStream(localBufferedInputStream, (OutputStream)localObject);
          localj = new j();
          paramo.wP().a(new File(paramString1), paramString2, true, localj);
          bo.b(localBufferedInputStream);
          bo.b((Closeable)localObject);
          paramo = (String)localj.value;
          AppMethodBeat.o(133591);
          return paramo;
        }
        catch (FileNotFoundException paramo)
        {
          d.printErrStackTrace("MicroMsg.OpenSdkJsApiProcessor", paramo, "", new Object[0]);
          AppMethodBeat.o(133591);
        }
        paramo = paramo;
        d.printErrStackTrace("MicroMsg.OpenSdkJsApiProcessor", paramo, "", new Object[0]);
        AppMethodBeat.o(133591);
        return "";
      }
      catch (Exception paramo)
      {
        d.printErrStackTrace("MicroMsg.OpenSdkJsApiProcessor", paramo, "", new Object[0]);
        AppMethodBeat.o(133591);
        return "";
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.s
 * JD-Core Version:    0.7.0.1
 */