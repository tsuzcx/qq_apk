package com.tencent.mm.plugin.appbrand.jsapi.video.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.k;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.j;
import com.tencent.mm.vfs.q;
import java.util.List;

public class a
{
  private static volatile a pvy;
  public Context appContext;
  public String cacheDir;
  public boolean dal = false;
  public boolean pvA = true;
  public boolean pvB = true;
  public boolean pvC = true;
  public boolean pvD = false;
  public List<String> pvE;
  public long pvF = 536870912L;
  public long pvG = 1048576L;
  public int pvH = 5;
  public j pvI;
  public com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a pvJ;
  public e pvK;
  public f pvL;
  public k pvu;
  public boolean pvz = true;
  public String tmpDir;
  
  private a(Context paramContext)
  {
    this.appContext = paramContext;
  }
  
  private static String aiQ(String paramString)
  {
    AppMethodBeat.i(230108);
    if (!TextUtils.isEmpty(paramString))
    {
      q localq = new q(paramString);
      boolean bool;
      if (localq.ifH())
      {
        bool = localq.cFq();
        h.log(4, "PlayerConfig", "fileDir:" + paramString + " is file, delete result:" + bool);
      }
      if (!localq.ifE())
      {
        bool = localq.ifL();
        h.log(4, "PlayerConfig", "fileDir:" + paramString + " not exist, make dir result:" + bool);
      }
    }
    AppMethodBeat.o(230108);
    return paramString;
  }
  
  public static a bVt()
  {
    AppMethodBeat.i(230101);
    if (pvy == null)
    {
      localObject = new RuntimeException("PlayerConfig not initialized!");
      AppMethodBeat.o(230101);
      throw ((Throwable)localObject);
    }
    Object localObject = pvy;
    AppMethodBeat.o(230101);
    return localObject;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(230103);
    if (pvy == null) {
      try
      {
        if (pvy == null) {
          pvy = new a(paramContext);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(230103);
      }
    }
    AppMethodBeat.o(230103);
  }
  
  public final String bVu()
  {
    AppMethodBeat.i(230107);
    if (TextUtils.isEmpty(this.tmpDir)) {
      try
      {
        q localq = q.Q(this.appContext.getFilesDir());
        if (localq == null)
        {
          AppMethodBeat.o(230107);
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
        localObject = aiQ(localObject + "/wxvideotmp");
        AppMethodBeat.o(230107);
        return localObject;
      }
    }
    Object localObject = this.tmpDir;
    AppMethodBeat.o(230107);
    return localObject;
  }
  
  public final String getCacheDir()
  {
    AppMethodBeat.i(230106);
    if (TextUtils.isEmpty(this.cacheDir)) {
      try
      {
        q localq = q.Q(this.appContext.getExternalCacheDir());
        if (localq == null)
        {
          h.log(5, "PlayerConfig", "getCacheDir fail, extCacheDir not exist");
          AppMethodBeat.o(230106);
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
        localObject = aiQ(localObject + "/wxvideocache");
        AppMethodBeat.o(230106);
        return localObject;
      }
    }
    Object localObject = this.cacheDir;
    AppMethodBeat.o(230106);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a
 * JD-Core Version:    0.7.0.1
 */