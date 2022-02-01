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
  private static final c pCE;
  
  static
  {
    AppMethodBeat.i(108438);
    c.a locala = new c.a();
    locala.idp = true;
    locala.idu = 1;
    locala.hdX = false;
    pCE = locala.aJc();
    AppMethodBeat.o(108438);
  }
  
  public static c L(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(108429);
    a locala = a.gqn;
    paramString1 = EmojiLogic.j(a.agp(), paramString1, paramString2);
    if (!bt.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.idp = true;
      paramString2.idr = true;
      paramString2.hdP = paramString1;
      paramString2.hdS = paramInt;
      paramString2.hdR = paramInt;
      paramString1 = paramString2.aJc();
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
      locala.idr = true;
      locala.hdP = paramString;
      locala.hdS = paramInt;
      locala.hdR = paramInt;
      locala.idR = paramVarArgs;
      paramString = locala.aJc();
      AppMethodBeat.o(108433);
      return paramString;
    }
    ad.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108433);
    return null;
  }
  
  public static c cgt()
  {
    AppMethodBeat.i(108430);
    Object localObject = new c.a();
    ((c.a)localObject).idp = true;
    ((c.a)localObject).idr = false;
    ((c.a)localObject).idu = 3;
    localObject = ((c.a)localObject).aJc();
    AppMethodBeat.o(108430);
    return localObject;
  }
  
  public static c fu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108427);
    paramString1 = g(paramString1, paramString2, new Object[0]);
    AppMethodBeat.o(108427);
    return paramString1;
  }
  
  public static c fv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108434);
    a locala = a.gqn;
    paramString1 = EmojiLogic.j(a.agp(), paramString1, paramString2);
    if (!bt.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.idp = true;
      paramString2.idr = true;
      paramString2.hdP = paramString1;
      paramString2.hfi = true;
      paramString1 = paramString2.aJc();
      AppMethodBeat.o(108434);
      return paramString1;
    }
    ad.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108434);
    return null;
  }
  
  public static c fw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108435);
    a locala = a.gqn;
    paramString1 = EmojiLogic.j(a.agp(), paramString1, paramString2);
    if (!bt.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.idp = true;
      paramString2.idr = true;
      paramString2.hdP = paramString1;
      paramString2.hfi = false;
      paramString1 = paramString2.aJc();
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
    a locala = a.gqn;
    paramString1 = EmojiLogic.j(a.agp(), paramString1, paramString2);
    if (!bt.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.idp = true;
      paramString2.idr = true;
      paramString2.hdP = paramString1;
      paramString2.idR = paramVarArgs;
      paramString1 = paramString2.aJc();
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
    String str = g.ajC().gBm;
    a locala = a.gqn;
    paramString1 = EmojiLogic.j(a.agp(), paramString1, paramString2);
    if (!bt.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.idp = true;
      paramString2.idr = true;
      paramString2.hdP = paramString1;
      paramString2.prefixPath = str;
      paramString2.idR = paramVarArgs;
      paramString1 = paramString2.aJc();
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
    a locala = a.gqn;
    paramString1 = EmojiLogic.j(a.agp(), paramString1, paramString2);
    if (!bt.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.idp = false;
      paramString2.idr = true;
      paramString2.hdP = paramString1;
      paramString2.idR = paramVarArgs;
      paramString1 = paramString2.aJc();
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
    a locala = a.gqn;
    paramString1 = EmojiLogic.j(a.agp(), paramString1, paramString2);
    if (!bt.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.idp = true;
      paramString2.idr = true;
      paramString2.hdP = paramString1;
      paramString2.idR = paramVarArgs;
      paramString1 = paramString2.aJc();
      AppMethodBeat.o(108437);
      return paramString1;
    }
    ad.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108437);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.e
 * JD-Core Version:    0.7.0.1
 */