package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.emoji.d.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class e
{
  private static final c pJi;
  
  static
  {
    AppMethodBeat.i(108438);
    c.a locala = new c.a();
    locala.igi = true;
    locala.ign = 1;
    locala.hgL = false;
    pJi = locala.aJu();
    AppMethodBeat.o(108438);
  }
  
  public static c L(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(108429);
    a locala = a.gsI;
    paramString1 = EmojiLogic.j(a.agD(), paramString1, paramString2);
    if (!bu.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.igi = true;
      paramString2.igk = true;
      paramString2.hgD = paramString1;
      paramString2.hgG = paramInt;
      paramString2.hgF = paramInt;
      paramString1 = paramString2.aJu();
      AppMethodBeat.o(108429);
      return paramString1;
    }
    ae.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108429);
    return null;
  }
  
  public static c a(String paramString, int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(108433);
    if (!bu.isNullOrNil(paramString))
    {
      c.a locala = new c.a();
      locala.igk = true;
      locala.hgD = paramString;
      locala.hgG = paramInt;
      locala.hgF = paramInt;
      locala.igJ = paramVarArgs;
      paramString = locala.aJu();
      AppMethodBeat.o(108433);
      return paramString;
    }
    ae.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108433);
    return null;
  }
  
  public static c chJ()
  {
    AppMethodBeat.i(108430);
    Object localObject = new c.a();
    ((c.a)localObject).igi = true;
    ((c.a)localObject).igk = false;
    ((c.a)localObject).ign = 3;
    localObject = ((c.a)localObject).aJu();
    AppMethodBeat.o(108430);
    return localObject;
  }
  
  public static c fA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108435);
    a locala = a.gsI;
    paramString1 = EmojiLogic.j(a.agD(), paramString1, paramString2);
    if (!bu.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.igi = true;
      paramString2.igk = true;
      paramString2.hgD = paramString1;
      paramString2.hhW = false;
      paramString1 = paramString2.aJu();
      AppMethodBeat.o(108435);
      return paramString1;
    }
    ae.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108435);
    return null;
  }
  
  public static c fy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108427);
    paramString1 = g(paramString1, paramString2, new Object[0]);
    AppMethodBeat.o(108427);
    return paramString1;
  }
  
  public static c fz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108434);
    a locala = a.gsI;
    paramString1 = EmojiLogic.j(a.agD(), paramString1, paramString2);
    if (!bu.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.igi = true;
      paramString2.igk = true;
      paramString2.hgD = paramString1;
      paramString2.hhW = true;
      paramString1 = paramString2.aJu();
      AppMethodBeat.o(108434);
      return paramString1;
    }
    ae.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108434);
    return null;
  }
  
  public static c g(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(108428);
    a locala = a.gsI;
    paramString1 = EmojiLogic.j(a.agD(), paramString1, paramString2);
    if (!bu.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.igi = true;
      paramString2.igk = true;
      paramString2.hgD = paramString1;
      paramString2.igJ = paramVarArgs;
      paramString1 = paramString2.aJu();
      AppMethodBeat.o(108428);
      return paramString1;
    }
    ae.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108428);
    return null;
  }
  
  public static c h(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(108431);
    String str = g.ajR().gDT;
    a locala = a.gsI;
    paramString1 = EmojiLogic.j(a.agD(), paramString1, paramString2);
    if (!bu.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.igi = true;
      paramString2.igk = true;
      paramString2.hgD = paramString1;
      paramString2.prefixPath = str;
      paramString2.igJ = paramVarArgs;
      paramString1 = paramString2.aJu();
      AppMethodBeat.o(108431);
      return paramString1;
    }
    ae.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108431);
    return null;
  }
  
  public static c j(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(108436);
    a locala = a.gsI;
    paramString1 = EmojiLogic.j(a.agD(), paramString1, paramString2);
    if (!bu.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.igi = false;
      paramString2.igk = true;
      paramString2.hgD = paramString1;
      paramString2.igJ = paramVarArgs;
      paramString1 = paramString2.aJu();
      AppMethodBeat.o(108436);
      return paramString1;
    }
    ae.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108436);
    return null;
  }
  
  public static c k(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(108437);
    a locala = a.gsI;
    paramString1 = EmojiLogic.j(a.agD(), paramString1, paramString2);
    if (!bu.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.igi = true;
      paramString2.igk = true;
      paramString2.hgD = paramString1;
      paramString2.igJ = paramVarArgs;
      paramString1 = paramString2.aJu();
      AppMethodBeat.o(108437);
      return paramString1;
    }
    ae.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108437);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.e
 * JD-Core Version:    0.7.0.1
 */