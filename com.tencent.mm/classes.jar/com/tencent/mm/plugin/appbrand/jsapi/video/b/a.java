package com.tencent.mm.plugin.appbrand.jsapi.video.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.j;
import java.util.List;

public class a
{
  private static volatile a lqy;
  public Context appContext;
  public boolean cFS = false;
  public String cacheDir;
  public boolean lqA = true;
  public boolean lqB = true;
  public boolean lqC = true;
  public boolean lqD = false;
  public List<String> lqE;
  public long lqF = 536870912L;
  public long lqG = 1048576L;
  public int lqH = 5;
  public j lqI;
  public com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a lqJ;
  public e lqK;
  public f lqL;
  public com.tencent.mm.plugin.appbrand.jsapi.video.b.c.k lqu;
  public boolean lqz = true;
  public String tmpDir;
  
  private a(Context paramContext)
  {
    this.appContext = paramContext;
  }
  
  private static String Rq(String paramString)
  {
    AppMethodBeat.i(210991);
    if (!TextUtils.isEmpty(paramString))
    {
      com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k(paramString);
      boolean bool;
      if (localk.isFile())
      {
        bool = localk.delete();
        h.log(4, "PlayerConfig", "fileDir:" + paramString + " is file, delete result:" + bool);
      }
      if (!localk.exists())
      {
        bool = localk.mkdirs();
        h.log(4, "PlayerConfig", "fileDir:" + paramString + " not exist, make dir result:" + bool);
      }
    }
    AppMethodBeat.o(210991);
    return paramString;
  }
  
  public static a boh()
  {
    AppMethodBeat.i(210987);
    if (lqy == null)
    {
      localObject = new RuntimeException("PlayerConfig not initialized!");
      AppMethodBeat.o(210987);
      throw ((Throwable)localObject);
    }
    Object localObject = lqy;
    AppMethodBeat.o(210987);
    return localObject;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(210988);
    if (lqy == null) {
      try
      {
        if (lqy == null) {
          lqy = new a(paramContext);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(210988);
      }
    }
    AppMethodBeat.o(210988);
  }
  
  public final String boi()
  {
    AppMethodBeat.i(210990);
    if (TextUtils.isEmpty(this.tmpDir)) {
      try
      {
        com.tencent.mm.vfs.k localk = com.tencent.mm.vfs.k.W(this.appContext.getFilesDir());
        if (localk == null)
        {
          AppMethodBeat.o(210990);
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
        localObject = Rq(localObject + "/wxvideotmp");
        AppMethodBeat.o(210990);
        return localObject;
      }
    }
    Object localObject = this.tmpDir;
    AppMethodBeat.o(210990);
    return localObject;
  }
  
  public final String getCacheDir()
  {
    AppMethodBeat.i(210989);
    if (TextUtils.isEmpty(this.cacheDir)) {
      try
      {
        com.tencent.mm.vfs.k localk = com.tencent.mm.vfs.k.W(this.appContext.getExternalCacheDir());
        if (localk == null)
        {
          h.log(5, "PlayerConfig", "getCacheDir fail, extCacheDir not exist");
          AppMethodBeat.o(210989);
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
        localObject = Rq(localObject + "/wxvideocache");
        AppMethodBeat.o(210989);
        return localObject;
      }
    }
    Object localObject = this.cacheDir;
    AppMethodBeat.o(210989);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a
 * JD-Core Version:    0.7.0.1
 */