package com.tencent.mm.plugin.appbrand.game.c;

import android.graphics.drawable.Drawable;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.b;
import com.tencent.mm.cg.c;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aa.i;

public final class a
  extends com.tencent.luggage.game.b.a
{
  public static final a jqx;
  
  static
  {
    AppMethodBeat.i(45104);
    jqx = new a();
    AppMethodBeat.o(45104);
  }
  
  public final void a(MBRuntime paramMBRuntime, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(45103);
    super.a(paramMBRuntime, paramAppBrandRuntime);
    com.tencent.magicbrush.a.a.a(new a((byte)0));
    com.tencent.magicbrush.handler.glfont.a.a(new a.b());
    AppMethodBeat.o(45103);
  }
  
  static final class a
    implements com.tencent.magicbrush.a.a.a
  {
    private static int a(String paramString, int paramInt, i<c> parami)
    {
      AppMethodBeat.i(45101);
      if ((paramString == null) || (paramInt < 0) || (paramInt >= paramString.length()))
      {
        AppMethodBeat.o(45101);
        return 0;
      }
      int k = paramString.codePointAt(paramInt);
      c localc = b.eHL().Wo(k);
      if (localc != null)
      {
        if (parami != null) {
          parami.value = localc;
        }
        paramInt = Character.charCount(k);
        AppMethodBeat.o(45101);
        return paramInt;
      }
      int j = paramInt + Character.charCount(k);
      if (j < paramString.length()) {}
      for (int i = paramString.codePointAt(j);; i = 0)
      {
        paramString = b.eHL().iZ(k, i);
        if (paramString != null) {
          break;
        }
        AppMethodBeat.o(45101);
        return 0;
      }
      if (paramString.mfw != 0) {}
      for (i = Character.charCount(i) + j;; i = j)
      {
        if (parami != null) {
          parami.value = paramString;
        }
        AppMethodBeat.o(45101);
        return i - paramInt;
      }
    }
    
    public final int n(String paramString, int paramInt)
    {
      AppMethodBeat.i(45099);
      paramInt = a(paramString, paramInt, null);
      AppMethodBeat.o(45099);
      return paramInt;
    }
    
    public final Drawable o(String paramString, int paramInt)
    {
      AppMethodBeat.i(45100);
      i locali = new i();
      a(paramString, paramInt, locali);
      paramString = b.eHL().a((c)locali.value, true);
      AppMethodBeat.o(45100);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.a
 * JD-Core Version:    0.7.0.1
 */