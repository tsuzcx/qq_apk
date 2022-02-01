package com.tencent.mm.plugin.appbrand.jsapi.video.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.j;
import java.util.List;

public class a
{
  private static volatile a koc;
  public boolean cxf = false;
  public k knX;
  public Context kob;
  public boolean kod = true;
  public boolean koe = true;
  public boolean kof = true;
  public boolean kog = true;
  public boolean koh = false;
  public String koi;
  public String koj;
  public List<String> kok;
  public long kol = 536870912L;
  public long kom = 1048576L;
  public int kon = 5;
  public j koo;
  public com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a kop;
  public com.tencent.mm.plugin.appbrand.jsapi.video.b.a.e koq;
  public f kor;
  
  private a(Context paramContext)
  {
    this.kob = paramContext;
  }
  
  private static String Jg(String paramString)
  {
    AppMethodBeat.i(193805);
    if (!TextUtils.isEmpty(paramString))
    {
      com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(paramString);
      boolean bool;
      if (locale.isFile())
      {
        bool = locale.delete();
        h.log(4, "PlayerConfig", "fileDir:" + paramString + " is file, delete result:" + bool);
      }
      if (!locale.exists())
      {
        bool = locale.mkdirs();
        h.log(4, "PlayerConfig", "fileDir:" + paramString + " not exist, make dir result:" + bool);
      }
    }
    AppMethodBeat.o(193805);
    return paramString;
  }
  
  public static a bcR()
  {
    AppMethodBeat.i(193801);
    if (koc == null)
    {
      localObject = new RuntimeException("PlayerConfig not initialized!");
      AppMethodBeat.o(193801);
      throw ((Throwable)localObject);
    }
    Object localObject = koc;
    AppMethodBeat.o(193801);
    return localObject;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(193802);
    if (koc == null) {
      try
      {
        if (koc == null) {
          koc = new a(paramContext);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(193802);
      }
    }
    AppMethodBeat.o(193802);
  }
  
  public final String aTh()
  {
    AppMethodBeat.i(193803);
    if (TextUtils.isEmpty(this.koj)) {
      try
      {
        com.tencent.mm.vfs.e locale = com.tencent.mm.vfs.e.R(this.kob.getExternalCacheDir());
        if (locale == null)
        {
          h.log(5, "PlayerConfig", "getCacheDir fail, extCacheDir not exist");
          AppMethodBeat.o(193803);
          return null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          h.a(5, "PlayerConfig", "getCacheDir fail", localException);
          localObject = null;
        }
        localObject = Jg(localObject + "/wxvideocache");
        AppMethodBeat.o(193803);
        return localObject;
      }
    }
    Object localObject = this.koj;
    AppMethodBeat.o(193803);
    return localObject;
  }
  
  public final String bcS()
  {
    AppMethodBeat.i(193804);
    if (TextUtils.isEmpty(this.koi)) {
      try
      {
        com.tencent.mm.vfs.e locale = com.tencent.mm.vfs.e.R(this.kob.getFilesDir());
        if (locale == null)
        {
          AppMethodBeat.o(193804);
          return null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          h.a(5, "PlayerConfig", "getTempDir fail", localException);
          localObject = null;
        }
        localObject = Jg(localObject + "/wxvideotmp");
        AppMethodBeat.o(193804);
        return localObject;
      }
    }
    Object localObject = this.koi;
    AppMethodBeat.o(193804);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a
 * JD-Core Version:    0.7.0.1
 */