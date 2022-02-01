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
  private static volatile a kPw;
  public Context appContext;
  public String cacheDir;
  public boolean cuo = false;
  public boolean kPA = true;
  public boolean kPB = false;
  public String kPC;
  public List<String> kPD;
  public long kPE = 536870912L;
  public long kPF = 1048576L;
  public int kPG = 5;
  public j kPH;
  public com.tencent.mm.plugin.appbrand.jsapi.video.b.d.a kPI;
  public com.tencent.mm.plugin.appbrand.jsapi.video.b.a.e kPJ;
  public f kPK;
  public k kPr;
  public boolean kPx = true;
  public boolean kPy = true;
  public boolean kPz = true;
  
  private a(Context paramContext)
  {
    this.appContext = paramContext;
  }
  
  private static String Nk(String paramString)
  {
    AppMethodBeat.i(194152);
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
    AppMethodBeat.o(194152);
    return paramString;
  }
  
  public static a bjM()
  {
    AppMethodBeat.i(194148);
    if (kPw == null)
    {
      localObject = new RuntimeException("PlayerConfig not initialized!");
      AppMethodBeat.o(194148);
      throw ((Throwable)localObject);
    }
    Object localObject = kPw;
    AppMethodBeat.o(194148);
    return localObject;
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(194149);
    if (kPw == null) {
      try
      {
        if (kPw == null) {
          kPw = new a(paramContext);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(194149);
      }
    }
    AppMethodBeat.o(194149);
  }
  
  public final String bjN()
  {
    AppMethodBeat.i(194151);
    if (TextUtils.isEmpty(this.kPC)) {
      try
      {
        com.tencent.mm.vfs.e locale = com.tencent.mm.vfs.e.U(this.appContext.getFilesDir());
        if (locale == null)
        {
          AppMethodBeat.o(194151);
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
        localObject = Nk(localObject + "/wxvideotmp");
        AppMethodBeat.o(194151);
        return localObject;
      }
    }
    Object localObject = this.kPC;
    AppMethodBeat.o(194151);
    return localObject;
  }
  
  public final String getCacheDir()
  {
    AppMethodBeat.i(194150);
    if (TextUtils.isEmpty(this.cacheDir)) {
      try
      {
        com.tencent.mm.vfs.e locale = com.tencent.mm.vfs.e.U(this.appContext.getExternalCacheDir());
        if (locale == null)
        {
          h.log(5, "PlayerConfig", "getCacheDir fail, extCacheDir not exist");
          AppMethodBeat.o(194150);
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
        localObject = Nk(localObject + "/wxvideocache");
        AppMethodBeat.o(194150);
        return localObject;
      }
    }
    Object localObject = this.cacheDir;
    AppMethodBeat.o(194150);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a
 * JD-Core Version:    0.7.0.1
 */