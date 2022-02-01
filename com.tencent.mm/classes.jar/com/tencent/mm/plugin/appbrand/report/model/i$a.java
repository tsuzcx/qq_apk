package com.tencent.mm.plugin.appbrand.report.model;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;

final class i$a
{
  private static final Set<String> qLa = new HashSet();
  private static final Set<String> qLb;
  
  static
  {
    AppMethodBeat.i(48121);
    try
    {
      localObject1 = MMApplicationContext.getContext().getAssets().open("15007_api_list.txt");
      if (localObject1 != null)
      {
        localObject1 = new InputStreamReader((InputStream)localObject1);
        localBufferedReader = new BufferedReader((Reader)localObject1);
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          String str = localBufferedReader.readLine();
          if (str == null) {
            break;
          }
          if (!Util.isNullOrNil(str)) {
            qLa.add(str);
          }
        }
      }
      catch (Exception localException2)
      {
        Object localObject1;
        Log.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", localException2, "readLine()", new Object[0]);
        Util.qualityClose(localBufferedReader);
        Util.qualityClose((Closeable)localObject1);
        for (;;)
        {
          qLb = new HashSet() {};
          AppMethodBeat.o(48121);
          return;
          localException1 = localException1;
          Log.printErrStackTrace("MicroMsg.AppBrand.JsApiInvokeReportProtocol", localException1, "open read 15007_api_list.txt", new Object[0]);
          localCloseable = null;
          break;
          Util.qualityClose(localBufferedReader);
          Util.qualityClose(localCloseable);
        }
      }
      finally
      {
        BufferedReader localBufferedReader;
        Closeable localCloseable;
        Util.qualityClose(localBufferedReader);
        Util.qualityClose(localCloseable);
        AppMethodBeat.o(48121);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.i.a
 * JD-Core Version:    0.7.0.1
 */