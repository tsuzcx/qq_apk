package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.mapsdk.engine.jni.models.IconImageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;

public final class sn
  implements np
{
  private Context c;
  private final float d;
  private String e;
  private String f;
  
  public sn(Context paramContext, String paramString)
  {
    AppMethodBeat.i(224016);
    this.c = paramContext.getApplicationContext();
    this.d = ha.a(this.c);
    this.e = paramString;
    AppMethodBeat.o(224016);
  }
  
  private Bitmap b(String paramString)
  {
    AppMethodBeat.i(224024);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(224024);
      return null;
    }
    Object localObject2 = kb.b(mf.a(this.c, null).a(this.e) + paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = kb.b(mf.a(this.c, null).b(this.e) + paramString);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = kb.b(mf.a(this.c, null).e() + paramString);
    }
    Object localObject3 = localObject2;
    if (localObject2 == null)
    {
      localObject3 = localObject2;
      if (this.f != null) {
        localObject3 = kb.a(new File(this.f, paramString));
      }
    }
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      if (mc.a() == null) {
        break label252;
      }
      localObject1 = mc.b(this.c, mc.a() + paramString);
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = mc.a(this.c, paramString);
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = mc.b(this.c, paramString);
      }
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(224024);
      return null;
      label252:
      localObject1 = localObject3;
      if (mc.b() != null) {
        localObject1 = kb.b(mc.b() + paramString);
      }
    }
    paramString = BitmapFactory.decodeStream((InputStream)localObject1);
    kb.a((Closeable)localObject1);
    AppMethodBeat.o(224024);
    return paramString;
  }
  
  public final String a()
  {
    return null;
  }
  
  public final void a(String paramString)
  {
    AppMethodBeat.i(224054);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(224054);
      return;
    }
    String str = paramString;
    if (paramString.contains("../")) {
      str = paramString.replaceAll("\\.\\./", "");
    }
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(224054);
      return;
    }
    this.f = str;
    AppMethodBeat.o(224054);
  }
  
  public final void a(String paramString, IconImageInfo paramIconImageInfo)
  {
    AppMethodBeat.i(224037);
    Bitmap localBitmap2 = gv.b.a(paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = gv.b.a(paramString);
    }
    paramIconImageInfo.bitmap = localBitmap1;
    if ((paramString.endsWith("@2x.png")) || (paramString.contains("@2x"))) {
      paramIconImageInfo.scale = 2.0F;
    }
    while (this.c == null)
    {
      AppMethodBeat.o(224037);
      return;
      if ((paramString.endsWith("@3x.png")) || (paramString.contains("@3x"))) {
        paramIconImageInfo.scale = 3.0F;
      } else {
        paramIconImageInfo.scale = this.d;
      }
    }
    if (localBitmap1 == null)
    {
      try
      {
        if ((paramString.startsWith("poi_icon")) || (paramString.startsWith("mapcfg_"))) {
          localBitmap1 = b(gz.b(paramString) + "@2x.png");
        }
        if (localBitmap1 != null)
        {
          paramIconImageInfo.bitmap = localBitmap1;
          paramIconImageInfo.scale = 2.0F;
          AppMethodBeat.o(224037);
          return;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        AppMethodBeat.o(224037);
        return;
      }
      paramIconImageInfo.bitmap = b(paramString);
      if ((paramString.equals("compass.png")) || (paramString.equals("compass_dark.png")))
      {
        paramIconImageInfo.scale = this.d;
        AppMethodBeat.o(224037);
        return;
      }
      paramIconImageInfo.scale = 1.0F;
    }
    AppMethodBeat.o(224037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.sn
 * JD-Core Version:    0.7.0.1
 */