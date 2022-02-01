package com.tencent.mm.plugin.appbrand.jsapi.video.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.j;
import com.tencent.mm.vfs.u;
import java.util.List;

public class a
{
  private static volatile a sAE;
  public Context appContext;
  public String cacheDir;
  public boolean eYL = false;
  public k sAA;
  public boolean sAF = true;
  public boolean sAG = true;
  public boolean sAH = true;
  public boolean sAI = true;
  public boolean sAJ = false;
  public List<String> sAK;
  public long sAL = 536870912L;
  public long sAM = 1048576L;
  public int sAN = 5;
  public j sAO;
  public com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a sAP;
  public e sAQ;
  public f sAR;
  public String tmpDir;
  
  private a(Context paramContext)
  {
    this.appContext = paramContext;
  }
  
  private static String abP(String paramString)
  {
    AppMethodBeat.i(328296);
    if (!TextUtils.isEmpty(paramString))
    {
      u localu = new u(paramString);
      boolean bool;
      if (localu.jKV())
      {
        bool = localu.diJ();
        h.log(4, "PlayerConfig", "fileDir:" + paramString + " is file, delete result:" + bool);
      }
      if (!localu.jKS())
      {
        bool = localu.jKY();
        h.log(4, "PlayerConfig", "fileDir:" + paramString + " not exist, make dir result:" + bool);
      }
    }
    AppMethodBeat.o(328296);
    return paramString;
  }
  
  public static a cvH()
  {
    AppMethodBeat.i(328281);
    if (sAE == null)
    {
      localObject = new RuntimeException("PlayerConfig not initialized!");
      AppMethodBeat.o(328281);
      throw ((Throwable)localObject);
    }
    Object localObject = sAE;
    AppMethodBeat.o(328281);
    return localObject;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(328287);
    if (sAE == null) {
      try
      {
        if (sAE == null) {
          sAE = new a(paramContext);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(328287);
      }
    }
    AppMethodBeat.o(328287);
  }
  
  public final String cvI()
  {
    AppMethodBeat.i(328317);
    if (TextUtils.isEmpty(this.tmpDir)) {
      try
      {
        u localu = u.V(this.appContext.getFilesDir());
        if (localu == null)
        {
          AppMethodBeat.o(328317);
          return null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          h.b(5, "PlayerConfig", "getTempDir fail", localException);
          localObject = null;
        }
        localObject = abP(localObject + "/wxvideotmp");
        AppMethodBeat.o(328317);
        return localObject;
      }
    }
    Object localObject = this.tmpDir;
    AppMethodBeat.o(328317);
    return localObject;
  }
  
  public final String getCacheDir()
  {
    AppMethodBeat.i(328307);
    if (TextUtils.isEmpty(this.cacheDir)) {
      try
      {
        u localu = u.V(this.appContext.getExternalCacheDir());
        if (localu == null)
        {
          h.log(5, "PlayerConfig", "getCacheDir fail, extCacheDir not exist");
          AppMethodBeat.o(328307);
          return null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          h.b(5, "PlayerConfig", "getCacheDir fail", localException);
          localObject = null;
        }
        localObject = abP(localObject + "/wxvideocache");
        AppMethodBeat.o(328307);
        return localObject;
      }
    }
    Object localObject = this.cacheDir;
    AppMethodBeat.o(328307);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a
 * JD-Core Version:    0.7.0.1
 */