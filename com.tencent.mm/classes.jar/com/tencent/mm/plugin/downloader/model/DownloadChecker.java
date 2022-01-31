package com.tencent.mm.plugin.downloader.model;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.xweb.WebView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DownloadChecker
{
  public static boolean a(String paramString1, String paramString2, WebView paramWebView)
  {
    AppMethodBeat.i(2353);
    if ((bo.isNullOrNil(paramString1)) || (g.dsn()))
    {
      AppMethodBeat.o(2353);
      return false;
    }
    Object localObject1;
    for (;;)
    {
      try
      {
        localObject1 = a.bFi();
        if (bo.es((List)localObject1))
        {
          ab.i("MicroMsg.DownloadChecker", "raw check url: [ %s ], no regex to intercept", new Object[] { paramString1 });
          AppMethodBeat.o(2353);
          return false;
        }
        ab.i("MicroMsg.DownloadChecker", "raw check url: [ %s ], have (%d) regexes to intercept", new Object[] { paramString1, Integer.valueOf(((List)localObject1).size()) });
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          str = (String)((Iterator)localObject1).next();
          localObject2 = Pattern.compile(str).matcher(paramString1.trim());
          if (!((Matcher)localObject2).find()) {
            continue;
          }
          localObject1 = ((Matcher)localObject2).group();
        }
      }
      catch (Exception localException1)
      {
        String str;
        localObject1 = null;
      }
      try
      {
        ab.i("MicroMsg.DownloadChecker", "match the regex: %s", new Object[] { str });
        if (!bo.isNullOrNil((String)localObject1)) {
          break;
        }
        AppMethodBeat.o(2353);
        return false;
      }
      catch (Exception localException2)
      {
        WeakReference localWeakReference;
        break label183;
      }
      localObject1 = null;
      continue;
      label183:
      ab.e("MicroMsg.DownloadChecker", "err: %s", new Object[] { localException1.getMessage() });
    }
    localWeakReference = new WeakReference(paramWebView);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("download_url", (String)localObject1);
    ((Bundle)localObject2).putString("main_url", paramWebView.getUrl());
    ((Bundle)localObject2).putString("scene", paramString2);
    f.a("com.tencent.mm", (Parcelable)localObject2, DownloadChecker.b.class, new DownloadChecker.1(localWeakReference, paramString1));
    AppMethodBeat.o(2353);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.DownloadChecker
 * JD-Core Version:    0.7.0.1
 */