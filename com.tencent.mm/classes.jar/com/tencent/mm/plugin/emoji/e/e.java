package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
{
  private static final c uCE;
  
  static
  {
    AppMethodBeat.i(108438);
    c.a locala = new c.a();
    locala.lRB = true;
    locala.lRG = 1;
    locala.kOl = false;
    uCE = locala.bmL();
    AppMethodBeat.o(108438);
  }
  
  public static c O(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(108429);
    paramString1 = EmojiLogic.j(b.bcb(), paramString1, paramString2);
    if (!Util.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.lRB = true;
      paramString2.lRD = true;
      paramString2.fullPath = paramString1;
      paramString2.kOg = paramInt;
      paramString2.kOf = paramInt;
      paramString1 = paramString2.bmL();
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
      locala.lRD = true;
      locala.fullPath = paramString;
      locala.kOg = paramInt;
      locala.kOf = paramInt;
      locala.lSd = paramVarArgs;
      paramString = locala.bmL();
      AppMethodBeat.o(108433);
      return paramString;
    }
    Log.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108433);
    return null;
  }
  
  public static c gd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108427);
    paramString1 = j(paramString1, paramString2, new Object[0]);
    AppMethodBeat.o(108427);
    return paramString1;
  }
  
  public static c ge(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108434);
    paramString1 = EmojiLogic.j(b.bcb(), paramString1, paramString2);
    if (!Util.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.lRB = true;
      paramString2.lRD = true;
      paramString2.fullPath = paramString1;
      paramString2.kPz = true;
      paramString1 = paramString2.bmL();
      AppMethodBeat.o(108434);
      return paramString1;
    }
    Log.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108434);
    return null;
  }
  
  public static c gf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108435);
    paramString1 = EmojiLogic.j(b.bcb(), paramString1, paramString2);
    if (!Util.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.lRB = true;
      paramString2.lRD = true;
      paramString2.fullPath = paramString1;
      paramString2.kPz = false;
      paramString1 = paramString2.bmL();
      AppMethodBeat.o(108435);
      return paramString1;
    }
    Log.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108435);
    return null;
  }
  
  public static c j(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(108428);
    paramString1 = EmojiLogic.j(b.bcb(), paramString1, paramString2);
    if (!Util.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.lRB = true;
      paramString2.lRD = true;
      paramString2.fullPath = paramString1;
      paramString2.lSd = paramVarArgs;
      paramString1 = paramString2.bmL();
      AppMethodBeat.o(108428);
      return paramString1;
    }
    Log.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108428);
    return null;
  }
  
  public static c k(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(108431);
    String str = h.aHG().kcB;
    paramString1 = EmojiLogic.j(b.bcb(), paramString1, paramString2);
    if (!Util.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.lRB = true;
      paramString2.lRD = true;
      paramString2.fullPath = paramString1;
      paramString2.prefixPath = str;
      paramString2.lSd = paramVarArgs;
      paramString1 = paramString2.bmL();
      AppMethodBeat.o(108431);
      return paramString1;
    }
    Log.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108431);
    return null;
  }
  
  public static c l(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(108436);
    paramString1 = EmojiLogic.j(b.bcb(), paramString1, paramString2);
    if (!Util.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.lRB = false;
      paramString2.lRD = true;
      paramString2.fullPath = paramString1;
      paramString2.lSd = paramVarArgs;
      paramString1 = paramString2.bmL();
      AppMethodBeat.o(108436);
      return paramString1;
    }
    Log.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108436);
    return null;
  }
  
  public static c m(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(108437);
    paramString1 = EmojiLogic.j(b.bcb(), paramString1, paramString2);
    if (!Util.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.lRB = true;
      paramString2.lRD = true;
      paramString2.fullPath = paramString1;
      paramString2.lSd = paramVarArgs;
      paramString1 = paramString2.bmL();
      AppMethodBeat.o(108437);
      return paramString1;
    }
    Log.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(108437);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.e
 * JD-Core Version:    0.7.0.1
 */