package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.emoji.d.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class e
{
  private static final c ovu;
  
  static
  {
    AppMethodBeat.i(108438);
    c.a locala = new c.a();
    locala.hjS = true;
    locala.hjX = 1;
    locala.gjA = false;
    ovu = locala.azc();
    AppMethodBeat.o(108438);
  }
  
  public static c J(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(108429);
    a locala = a.fSR;
    paramString1 = EmojiLogic.j(a.acD(), paramString1, paramString2);
    if (!bt.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.hjS = true;
      paramString2.hjU = true;
      paramString2.gjt = paramString1;
      paramString2.gjw = paramInt;
      paramString2.gjv = paramInt;
      paramString1 = paramString2.azc();
      AppMethodBeat.o(108429);
      return paramString1;
    }
    ad.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108429);
    return null;
  }
  
  public static c a(String paramString, int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(108433);
    if (!bt.isNullOrNil(paramString))
    {
      c.a locala = new c.a();
      locala.hjU = true;
      locala.gjt = paramString;
      locala.gjw = paramInt;
      locala.gjv = paramInt;
      locala.hkt = paramVarArgs;
      paramString = locala.azc();
      AppMethodBeat.o(108433);
      return paramString;
    }
    ad.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108433);
    return null;
  }
  
  public static c bUC()
  {
    AppMethodBeat.i(108430);
    Object localObject = new c.a();
    ((c.a)localObject).hjS = true;
    ((c.a)localObject).hjU = false;
    ((c.a)localObject).hjX = 3;
    localObject = ((c.a)localObject).azc();
    AppMethodBeat.o(108430);
    return localObject;
  }
  
  public static c eX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108427);
    paramString1 = g(paramString1, paramString2, new Object[0]);
    AppMethodBeat.o(108427);
    return paramString1;
  }
  
  public static c eY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108434);
    a locala = a.fSR;
    paramString1 = EmojiLogic.j(a.acD(), paramString1, paramString2);
    if (!bt.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.hjS = true;
      paramString2.hjU = true;
      paramString2.gjt = paramString1;
      paramString2.gkG = true;
      paramString1 = paramString2.azc();
      AppMethodBeat.o(108434);
      return paramString1;
    }
    ad.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108434);
    return null;
  }
  
  public static c eZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108435);
    a locala = a.fSR;
    paramString1 = EmojiLogic.j(a.acD(), paramString1, paramString2);
    if (!bt.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.hjS = true;
      paramString2.hjU = true;
      paramString2.gjt = paramString1;
      paramString2.gkG = false;
      paramString1 = paramString2.azc();
      AppMethodBeat.o(108435);
      return paramString1;
    }
    ad.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108435);
    return null;
  }
  
  public static c g(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(108428);
    a locala = a.fSR;
    paramString1 = EmojiLogic.j(a.acD(), paramString1, paramString2);
    if (!bt.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.hjS = true;
      paramString2.hjU = true;
      paramString2.gjt = paramString1;
      paramString2.hkt = paramVarArgs;
      paramString1 = paramString2.azc();
      AppMethodBeat.o(108428);
      return paramString1;
    }
    ad.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108428);
    return null;
  }
  
  public static c h(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(108431);
    String str = g.afB().gcW;
    a locala = a.fSR;
    paramString1 = EmojiLogic.j(a.acD(), paramString1, paramString2);
    if (!bt.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.hjS = true;
      paramString2.hjU = true;
      paramString2.gjt = paramString1;
      paramString2.prefixPath = str;
      paramString2.hkt = paramVarArgs;
      paramString1 = paramString2.azc();
      AppMethodBeat.o(108431);
      return paramString1;
    }
    ad.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108431);
    return null;
  }
  
  public static c j(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(108436);
    a locala = a.fSR;
    paramString1 = EmojiLogic.j(a.acD(), paramString1, paramString2);
    if (!bt.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.hjS = false;
      paramString2.hjU = true;
      paramString2.gjt = paramString1;
      paramString2.hkt = paramVarArgs;
      paramString1 = paramString2.azc();
      AppMethodBeat.o(108436);
      return paramString1;
    }
    ad.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108436);
    return null;
  }
  
  public static c k(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(108437);
    a locala = a.fSR;
    paramString1 = EmojiLogic.j(a.acD(), paramString1, paramString2);
    if (!bt.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.hjS = true;
      paramString2.hjU = true;
      paramString2.gjt = paramString1;
      paramString2.hkt = paramVarArgs;
      paramString1 = paramString2.azc();
      AppMethodBeat.o(108437);
      return paramString1;
    }
    ad.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108437);
    return null;
  }
  
  public static c p(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(108432);
    if (!bt.isNullOrNil(paramString))
    {
      c.a locala = new c.a();
      locala.hjU = true;
      locala.gjt = paramString;
      locala.hkt = paramVarArgs;
      paramString = locala.azc();
      AppMethodBeat.o(108432);
      return paramString;
    }
    ad.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108432);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.e
 * JD-Core Version:    0.7.0.1
 */