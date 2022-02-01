package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rn
  extends JsonComposer
{
  private static final String i = "default";
  private static final int k = 0;
  private static final int l = 1;
  @Json(name="rule")
  public int a = 0;
  @Json(name="frontier")
  public String b = "default";
  @Json(name="logo_name")
  public String c = "";
  @Json(name="logo")
  public String d = "";
  @Json(name="logo_night")
  public String e;
  @Json(ignore=true)
  public Bitmap f;
  @Json(ignore=true)
  public Bitmap g;
  public boolean h;
  @Json(name="priority")
  private int j = 0;
  
  private void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  private void a(Bitmap paramBitmap)
  {
    this.f = paramBitmap;
  }
  
  private void a(String paramString)
  {
    this.b = paramString;
  }
  
  private void b(Bitmap paramBitmap)
  {
    this.g = paramBitmap;
  }
  
  private void b(String paramString)
  {
    this.c = paramString;
  }
  
  private boolean b()
  {
    return this.h;
  }
  
  private boolean b(fs paramfs)
  {
    AppMethodBeat.i(223240);
    if ("default".equals(this.b))
    {
      AppMethodBeat.o(223240);
      return true;
    }
    if (paramfs == null)
    {
      AppMethodBeat.o(223240);
      return false;
    }
    paramfs = paramfs.a;
    rg.a();
    boolean bool = rg.a(paramfs, rg.c(this.b));
    AppMethodBeat.o(223240);
    return bool;
  }
  
  private void c()
  {
    this.h = true;
  }
  
  private void c(String paramString)
  {
    this.d = paramString;
  }
  
  private boolean c(fs paramfs)
  {
    AppMethodBeat.i(223260);
    if ("default".equals(this.b))
    {
      AppMethodBeat.o(223260);
      return true;
    }
    if (paramfs == null)
    {
      AppMethodBeat.o(223260);
      return false;
    }
    rg.a();
    ft[] arrayOfft = rg.c(this.b);
    paramfs = paramfs.b;
    if ((paramfs == null) || (arrayOfft == null))
    {
      AppMethodBeat.o(223260);
      return true;
    }
    boolean bool = rg.a(paramfs, arrayOfft);
    AppMethodBeat.o(223260);
    return bool;
  }
  
  private void d()
  {
    this.a = 1;
  }
  
  private void d(String paramString)
  {
    this.e = paramString;
  }
  
  private String e()
  {
    return this.c;
  }
  
  private String f()
  {
    return this.d;
  }
  
  private String g()
  {
    return this.e;
  }
  
  public final int a()
  {
    return this.a * 10 + this.j;
  }
  
  public final Bitmap a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.g;
    }
    return this.f;
  }
  
  public final boolean a(fs paramfs)
  {
    AppMethodBeat.i(223298);
    boolean bool;
    switch (this.a)
    {
    default: 
      bool = false;
    }
    while (this.h) {
      if (!bool)
      {
        AppMethodBeat.o(223298);
        return true;
        bool = b(paramfs);
        continue;
        bool = c(paramfs);
      }
      else
      {
        AppMethodBeat.o(223298);
        return false;
      }
    }
    AppMethodBeat.o(223298);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.rn
 * JD-Core Version:    0.7.0.1
 */