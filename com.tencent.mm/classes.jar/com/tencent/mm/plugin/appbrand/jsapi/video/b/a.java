package com.tencent.mm.plugin.appbrand.jsapi.video.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.j;
import com.tencent.mm.vfs.o;
import java.util.List;

public class a
{
  private static volatile a mxe;
  public Context appContext;
  public boolean cWq = false;
  public String cacheDir;
  public k mxa;
  public boolean mxf = true;
  public boolean mxg = true;
  public boolean mxh = true;
  public boolean mxi = true;
  public boolean mxj = false;
  public List<String> mxk;
  public long mxl = 536870912L;
  public long mxm = 1048576L;
  public int mxn = 5;
  public j mxo;
  public com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a mxp;
  public e mxq;
  public f mxr;
  public String tmpDir;
  
  private a(Context paramContext)
  {
    this.appContext = paramContext;
  }
  
  private static String aaX(String paramString)
  {
    AppMethodBeat.i(234660);
    if (!TextUtils.isEmpty(paramString))
    {
      o localo = new o(paramString);
      boolean bool;
      if (localo.isFile())
      {
        bool = localo.delete();
        h.log(4, "PlayerConfig", "fileDir:" + paramString + " is file, delete result:" + bool);
      }
      if (!localo.exists())
      {
        bool = localo.mkdirs();
        h.log(4, "PlayerConfig", "fileDir:" + paramString + " not exist, make dir result:" + bool);
      }
    }
    AppMethodBeat.o(234660);
    return paramString;
  }
  
  public static a bJK()
  {
    AppMethodBeat.i(234656);
    if (mxe == null)
    {
      localObject = new RuntimeException("PlayerConfig not initialized!");
      AppMethodBeat.o(234656);
      throw ((Throwable)localObject);
    }
    Object localObject = mxe;
    AppMethodBeat.o(234656);
    return localObject;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(234657);
    if (mxe == null) {
      try
      {
        if (mxe == null) {
          mxe = new a(paramContext);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(234657);
      }
    }
    AppMethodBeat.o(234657);
  }
  
  public final String bJL()
  {
    AppMethodBeat.i(234659);
    if (TextUtils.isEmpty(this.tmpDir)) {
      try
      {
        o localo = o.X(this.appContext.getFilesDir());
        if (localo == null)
        {
          AppMethodBeat.o(234659);
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
        localObject = aaX(localObject + "/wxvideotmp");
        AppMethodBeat.o(234659);
        return localObject;
      }
    }
    Object localObject = this.tmpDir;
    AppMethodBeat.o(234659);
    return localObject;
  }
  
  public final String getCacheDir()
  {
    AppMethodBeat.i(234658);
    if (TextUtils.isEmpty(this.cacheDir)) {
      try
      {
        o localo = o.X(this.appContext.getExternalCacheDir());
        if (localo == null)
        {
          h.log(5, "PlayerConfig", "getCacheDir fail, extCacheDir not exist");
          AppMethodBeat.o(234658);
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
        localObject = aaX(localObject + "/wxvideocache");
        AppMethodBeat.o(234658);
        return localObject;
      }
    }
    Object localObject = this.cacheDir;
    AppMethodBeat.o(234658);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a
 * JD-Core Version:    0.7.0.1
 */