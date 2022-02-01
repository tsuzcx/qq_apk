package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class sp
  implements nt
{
  private Context a;
  private final mf b;
  private String c;
  
  public sp(Context paramContext, String paramString)
  {
    AppMethodBeat.i(223956);
    if (paramContext != null)
    {
      this.a = paramContext.getApplicationContext();
      this.b = mf.a(this.a, null);
      this.c = paramString;
      AppMethodBeat.o(223956);
      return;
    }
    this.b = null;
    AppMethodBeat.o(223956);
  }
  
  public final String a()
  {
    AppMethodBeat.i(223963);
    if (this.b != null)
    {
      String str = this.b.d();
      AppMethodBeat.o(223963);
      return str;
    }
    AppMethodBeat.o(223963);
    return null;
  }
  
  public final String b()
  {
    AppMethodBeat.i(223972);
    if (this.b != null)
    {
      Object localObject = this.b;
      kb.a(((mf)localObject).b);
      localObject = ((mf)localObject).b;
      AppMethodBeat.o(223972);
      return localObject;
    }
    AppMethodBeat.o(223972);
    return null;
  }
  
  public final String c()
  {
    AppMethodBeat.i(223978);
    if (this.b != null)
    {
      String str = this.b.a(this.c);
      AppMethodBeat.o(223978);
      return str;
    }
    AppMethodBeat.o(223978);
    return null;
  }
  
  public final String d()
  {
    AppMethodBeat.i(223985);
    if (this.b != null)
    {
      String str = this.b.c(this.c);
      AppMethodBeat.o(223985);
      return str;
    }
    AppMethodBeat.o(223985);
    return null;
  }
  
  public final String e()
  {
    AppMethodBeat.i(223993);
    if (this.b != null)
    {
      String str = this.b.b(this.c);
      AppMethodBeat.o(223993);
      return str;
    }
    AppMethodBeat.o(223993);
    return null;
  }
  
  public final String f()
  {
    return null;
  }
  
  public final String g()
  {
    return null;
  }
  
  public final String h()
  {
    return null;
  }
  
  public final String i()
  {
    AppMethodBeat.i(224023);
    if (this.b != null)
    {
      Object localObject = this.b;
      kb.a(((mf)localObject).c);
      localObject = ((mf)localObject).c;
      AppMethodBeat.o(224023);
      return localObject;
    }
    AppMethodBeat.o(224023);
    return null;
  }
  
  public final String j()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.sp
 * JD-Core Version:    0.7.0.1
 */