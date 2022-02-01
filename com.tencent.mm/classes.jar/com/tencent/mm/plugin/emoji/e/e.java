package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.emoji.d.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class e
{
  private static final c oYU;
  
  static
  {
    AppMethodBeat.i(108438);
    c.a locala = new c.a();
    locala.hKv = true;
    locala.hKA = 1;
    locala.gKm = false;
    oYU = locala.aFT();
    AppMethodBeat.o(108438);
  }
  
  public static c K(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(108429);
    a locala = a.fWM;
    paramString1 = EmojiLogic.j(a.adJ(), paramString1, paramString2);
    if (!bs.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.hKv = true;
      paramString2.hKx = true;
      paramString2.gKe = paramString1;
      paramString2.gKh = paramInt;
      paramString2.gKg = paramInt;
      paramString1 = paramString2.aFT();
      AppMethodBeat.o(108429);
      return paramString1;
    }
    ac.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108429);
    return null;
  }
  
  public static c a(String paramString, int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(108433);
    if (!bs.isNullOrNil(paramString))
    {
      c.a locala = new c.a();
      locala.hKx = true;
      locala.gKe = paramString;
      locala.gKh = paramInt;
      locala.gKg = paramInt;
      locala.hKW = paramVarArgs;
      paramString = locala.aFT();
      AppMethodBeat.o(108433);
      return paramString;
    }
    ac.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108433);
    return null;
  }
  
  public static c cbP()
  {
    AppMethodBeat.i(108430);
    Object localObject = new c.a();
    ((c.a)localObject).hKv = true;
    ((c.a)localObject).hKx = false;
    ((c.a)localObject).hKA = 3;
    localObject = ((c.a)localObject).aFT();
    AppMethodBeat.o(108430);
    return localObject;
  }
  
  public static c fk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108427);
    paramString1 = g(paramString1, paramString2, new Object[0]);
    AppMethodBeat.o(108427);
    return paramString1;
  }
  
  public static c fl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108434);
    a locala = a.fWM;
    paramString1 = EmojiLogic.j(a.adJ(), paramString1, paramString2);
    if (!bs.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.hKv = true;
      paramString2.hKx = true;
      paramString2.gKe = paramString1;
      paramString2.gLt = true;
      paramString1 = paramString2.aFT();
      AppMethodBeat.o(108434);
      return paramString1;
    }
    ac.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108434);
    return null;
  }
  
  public static c fm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108435);
    a locala = a.fWM;
    paramString1 = EmojiLogic.j(a.adJ(), paramString1, paramString2);
    if (!bs.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.hKv = true;
      paramString2.hKx = true;
      paramString2.gKe = paramString1;
      paramString2.gLt = false;
      paramString1 = paramString2.aFT();
      AppMethodBeat.o(108435);
      return paramString1;
    }
    ac.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108435);
    return null;
  }
  
  public static c g(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(108428);
    a locala = a.fWM;
    paramString1 = EmojiLogic.j(a.adJ(), paramString1, paramString2);
    if (!bs.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.hKv = true;
      paramString2.hKx = true;
      paramString2.gKe = paramString1;
      paramString2.hKW = paramVarArgs;
      paramString1 = paramString2.aFT();
      AppMethodBeat.o(108428);
      return paramString1;
    }
    ac.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108428);
    return null;
  }
  
  public static c h(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(108431);
    String str = g.agR().ghC;
    a locala = a.fWM;
    paramString1 = EmojiLogic.j(a.adJ(), paramString1, paramString2);
    if (!bs.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.hKv = true;
      paramString2.hKx = true;
      paramString2.gKe = paramString1;
      paramString2.prefixPath = str;
      paramString2.hKW = paramVarArgs;
      paramString1 = paramString2.aFT();
      AppMethodBeat.o(108431);
      return paramString1;
    }
    ac.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108431);
    return null;
  }
  
  public static c j(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(108436);
    a locala = a.fWM;
    paramString1 = EmojiLogic.j(a.adJ(), paramString1, paramString2);
    if (!bs.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.hKv = false;
      paramString2.hKx = true;
      paramString2.gKe = paramString1;
      paramString2.hKW = paramVarArgs;
      paramString1 = paramString2.aFT();
      AppMethodBeat.o(108436);
      return paramString1;
    }
    ac.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108436);
    return null;
  }
  
  public static c k(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(108437);
    a locala = a.fWM;
    paramString1 = EmojiLogic.j(a.adJ(), paramString1, paramString2);
    if (!bs.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.hKv = true;
      paramString2.hKx = true;
      paramString2.gKe = paramString1;
      paramString2.hKW = paramVarArgs;
      paramString1 = paramString2.aFT();
      AppMethodBeat.o(108437);
      return paramString1;
    }
    ac.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108437);
    return null;
  }
  
  public static c p(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(108432);
    if (!bs.isNullOrNil(paramString))
    {
      c.a locala = new c.a();
      locala.hKx = true;
      locala.gKe = paramString;
      locala.hKW = paramVarArgs;
      paramString = locala.aFT();
      AppMethodBeat.o(108432);
      return paramString;
    }
    ac.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108432);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.e
 * JD-Core Version:    0.7.0.1
 */