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
  private static volatile a llY;
  public Context appContext;
  public boolean cFj = false;
  public String cacheDir;
  public k llU;
  public boolean llZ = true;
  public boolean lma = true;
  public boolean lmb = true;
  public boolean lmc = true;
  public boolean lmd = false;
  public List<String> lme;
  public long lmf = 536870912L;
  public long lmg = 1048576L;
  public int lmh = 5;
  public j lmi;
  public com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a lmj;
  public com.tencent.mm.plugin.appbrand.jsapi.video.b.a.e lmk;
  public f lml;
  public String tmpDir;
  
  private a(Context paramContext)
  {
    this.appContext = paramContext;
  }
  
  private static String QH(String paramString)
  {
    AppMethodBeat.i(205964);
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
    AppMethodBeat.o(205964);
    return paramString;
  }
  
  public static a bnx()
  {
    AppMethodBeat.i(205960);
    if (llY == null)
    {
      localObject = new RuntimeException("PlayerConfig not initialized!");
      AppMethodBeat.o(205960);
      throw ((Throwable)localObject);
    }
    Object localObject = llY;
    AppMethodBeat.o(205960);
    return localObject;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(205961);
    if (llY == null) {
      try
      {
        if (llY == null) {
          llY = new a(paramContext);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(205961);
      }
    }
    AppMethodBeat.o(205961);
  }
  
  public final String bny()
  {
    AppMethodBeat.i(205963);
    if (TextUtils.isEmpty(this.tmpDir)) {
      try
      {
        com.tencent.mm.vfs.e locale = com.tencent.mm.vfs.e.X(this.appContext.getFilesDir());
        if (locale == null)
        {
          AppMethodBeat.o(205963);
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
        localObject = QH(localObject + "/wxvideotmp");
        AppMethodBeat.o(205963);
        return localObject;
      }
    }
    Object localObject = this.tmpDir;
    AppMethodBeat.o(205963);
    return localObject;
  }
  
  public final String getCacheDir()
  {
    AppMethodBeat.i(205962);
    if (TextUtils.isEmpty(this.cacheDir)) {
      try
      {
        com.tencent.mm.vfs.e locale = com.tencent.mm.vfs.e.X(this.appContext.getExternalCacheDir());
        if (locale == null)
        {
          h.log(5, "PlayerConfig", "getCacheDir fail, extCacheDir not exist");
          AppMethodBeat.o(205962);
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
        localObject = QH(localObject + "/wxvideocache");
        AppMethodBeat.o(205962);
        return localObject;
      }
    }
    Object localObject = this.cacheDir;
    AppMethodBeat.o(205962);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a
 * JD-Core Version:    0.7.0.1
 */