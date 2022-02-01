package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.emoji.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
{
  private static final c qZD;
  
  static
  {
    AppMethodBeat.i(108438);
    c.a locala = new c.a();
    locala.jbd = true;
    locala.jbi = 1;
    locala.hZF = false;
    qZD = locala.bdv();
    AppMethodBeat.o(108438);
  }
  
  public static c K(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(108429);
    a locala = a.hdT;
    paramString1 = EmojiLogic.j(a.awt(), paramString1, paramString2);
    if (!Util.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.jbd = true;
      paramString2.jbf = true;
      paramString2.fullPath = paramString1;
      paramString2.hZA = paramInt;
      paramString2.hZz = paramInt;
      paramString1 = paramString2.bdv();
      AppMethodBeat.o(108429);
      return paramString1;
    }
    Log.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108429);
    return null;
  }
  
  public static c a(String paramString, int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(108433);
    if (!Util.isNullOrNil(paramString))
    {
      c.a locala = new c.a();
      locala.jbf = true;
      locala.fullPath = paramString;
      locala.hZA = paramInt;
      locala.hZz = paramInt;
      locala.jbE = paramVarArgs;
      paramString = locala.bdv();
      AppMethodBeat.o(108433);
      return paramString;
    }
    Log.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108433);
    return null;
  }
  
  public static c cFG()
  {
    AppMethodBeat.i(108430);
    Object localObject = new c.a();
    ((c.a)localObject).jbd = true;
    ((c.a)localObject).jbf = false;
    ((c.a)localObject).jbi = 3;
    localObject = ((c.a)localObject).bdv();
    AppMethodBeat.o(108430);
    return localObject;
  }
  
  public static c fQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108427);
    paramString1 = h(paramString1, paramString2, new Object[0]);
    AppMethodBeat.o(108427);
    return paramString1;
  }
  
  public static c fR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108434);
    a locala = a.hdT;
    paramString1 = EmojiLogic.j(a.awt(), paramString1, paramString2);
    if (!Util.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.jbd = true;
      paramString2.jbf = true;
      paramString2.fullPath = paramString1;
      paramString2.iaT = true;
      paramString1 = paramString2.bdv();
      AppMethodBeat.o(108434);
      return paramString1;
    }
    Log.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108434);
    return null;
  }
  
  public static c fS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108435);
    a locala = a.hdT;
    paramString1 = EmojiLogic.j(a.awt(), paramString1, paramString2);
    if (!Util.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.jbd = true;
      paramString2.jbf = true;
      paramString2.fullPath = paramString1;
      paramString2.iaT = false;
      paramString1 = paramString2.bdv();
      AppMethodBeat.o(108435);
      return paramString1;
    }
    Log.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108435);
    return null;
  }
  
  public static c h(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(108428);
    a locala = a.hdT;
    paramString1 = EmojiLogic.j(a.awt(), paramString1, paramString2);
    if (!Util.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.jbd = true;
      paramString2.jbf = true;
      paramString2.fullPath = paramString1;
      paramString2.jbE = paramVarArgs;
      paramString1 = paramString2.bdv();
      AppMethodBeat.o(108428);
      return paramString1;
    }
    Log.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108428);
    return null;
  }
  
  public static c j(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(108431);
    String str = g.aAh().hqG;
    a locala = a.hdT;
    paramString1 = EmojiLogic.j(a.awt(), paramString1, paramString2);
    if (!Util.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.jbd = true;
      paramString2.jbf = true;
      paramString2.fullPath = paramString1;
      paramString2.prefixPath = str;
      paramString2.jbE = paramVarArgs;
      paramString1 = paramString2.bdv();
      AppMethodBeat.o(108431);
      return paramString1;
    }
    Log.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108431);
    return null;
  }
  
  public static c k(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(108436);
    a locala = a.hdT;
    paramString1 = EmojiLogic.j(a.awt(), paramString1, paramString2);
    if (!Util.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.jbd = false;
      paramString2.jbf = true;
      paramString2.fullPath = paramString1;
      paramString2.jbE = paramVarArgs;
      paramString1 = paramString2.bdv();
      AppMethodBeat.o(108436);
      return paramString1;
    }
    Log.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108436);
    return null;
  }
  
  public static c l(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(108437);
    a locala = a.hdT;
    paramString1 = EmojiLogic.j(a.awt(), paramString1, paramString2);
    if (!Util.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.jbd = true;
      paramString2.jbf = true;
      paramString2.fullPath = paramString1;
      paramString2.jbE = paramVarArgs;
      paramString1 = paramString2.bdv();
      AppMethodBeat.o(108437);
      return paramString1;
    }
    Log.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108437);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.e
 * JD-Core Version:    0.7.0.1
 */