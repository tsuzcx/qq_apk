package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class g
{
  private static final c lfO;
  
  static
  {
    AppMethodBeat.i(52883);
    c.a locala = new c.a();
    locala.eNK = true;
    locala.fHt = 1;
    locala.eOe = false;
    lfO = locala.ahY();
    AppMethodBeat.o(52883);
  }
  
  public static c a(String paramString, int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(52878);
    if (!bo.isNullOrNil(paramString))
    {
      c.a locala = new c.a();
      locala.eNM = true;
      locala.eNO = paramString;
      locala.eNT = paramInt;
      locala.eNS = paramInt;
      locala.eOi = paramVarArgs;
      paramString = locala.ahY();
      AppMethodBeat.o(52878);
      return paramString;
    }
    ab.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(52878);
    return null;
  }
  
  public static c bkS()
  {
    AppMethodBeat.i(52874);
    Object localObject = new c.a();
    ((c.a)localObject).eNK = true;
    ((c.a)localObject).eNM = false;
    ((c.a)localObject).fHt = 3;
    localObject = ((c.a)localObject).ahY();
    AppMethodBeat.o(52874);
    return localObject;
  }
  
  public static c dK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52871);
    paramString1 = g(paramString1, paramString2, new Object[0]);
    AppMethodBeat.o(52871);
    return paramString1;
  }
  
  public static c dL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52879);
    paramString1 = EmojiLogic.L(b.YP(), paramString1, paramString2);
    if (!bo.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.eNK = true;
      paramString2.eNM = true;
      paramString2.eNO = paramString1;
      paramString2.eOk = true;
      paramString1 = paramString2.ahY();
      AppMethodBeat.o(52879);
      return paramString1;
    }
    ab.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(52879);
    return null;
  }
  
  public static c dM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52880);
    paramString1 = EmojiLogic.L(b.YP(), paramString1, paramString2);
    if (!bo.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.eNK = true;
      paramString2.eNM = true;
      paramString2.eNO = paramString1;
      paramString2.eOk = false;
      paramString1 = paramString2.ahY();
      AppMethodBeat.o(52880);
      return paramString1;
    }
    ab.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(52880);
    return null;
  }
  
  public static c g(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(52872);
    paramString1 = EmojiLogic.L(b.YP(), paramString1, paramString2);
    if (!bo.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.eNK = true;
      paramString2.eNM = true;
      paramString2.eNO = paramString1;
      paramString2.eOi = paramVarArgs;
      paramString1 = paramString2.ahY();
      AppMethodBeat.o(52872);
      return paramString1;
    }
    ab.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(52872);
    return null;
  }
  
  public static c h(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(52875);
    String str = com.tencent.mm.kernel.g.RL().eHR;
    paramString1 = EmojiLogic.L(b.YP(), paramString1, paramString2);
    if (!bo.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.eNK = true;
      paramString2.eNM = true;
      paramString2.eNO = paramString1;
      paramString2.eNP = str;
      paramString2.eOi = paramVarArgs;
      paramString1 = paramString2.ahY();
      AppMethodBeat.o(52875);
      return paramString1;
    }
    ab.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(52875);
    return null;
  }
  
  public static c j(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(52881);
    paramString1 = EmojiLogic.L(b.YP(), paramString1, paramString2);
    if (!bo.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.eNK = false;
      paramString2.eNM = true;
      paramString2.eNO = paramString1;
      paramString2.eOi = paramVarArgs;
      paramString1 = paramString2.ahY();
      AppMethodBeat.o(52881);
      return paramString1;
    }
    ab.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(52881);
    return null;
  }
  
  public static c k(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(52882);
    paramString1 = EmojiLogic.L(b.YP(), paramString1, paramString2);
    if (!bo.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.eNK = true;
      paramString2.eNM = true;
      paramString2.eNO = paramString1;
      paramString2.eOi = paramVarArgs;
      paramString1 = paramString2.ahY();
      AppMethodBeat.o(52882);
      return paramString1;
    }
    ab.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(52882);
    return null;
  }
  
  public static c n(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(52876);
    if (!bo.isNullOrNil(paramString))
    {
      c.a locala = new c.a();
      locala.eNM = true;
      locala.eNO = paramString;
      locala.eOi = paramVarArgs;
      paramString = locala.ahY();
      AppMethodBeat.o(52876);
      return paramString;
    }
    ab.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(52876);
    return null;
  }
  
  public static c z(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(52873);
    paramString1 = EmojiLogic.L(b.YP(), paramString1, paramString2);
    if (!bo.isNullOrNil(paramString1))
    {
      paramString2 = new c.a();
      paramString2.eNK = true;
      paramString2.eNM = true;
      paramString2.eNO = paramString1;
      paramString2.eNT = paramInt;
      paramString2.eNS = paramInt;
      paramString1 = paramString2.ahY();
      AppMethodBeat.o(52873);
      return paramString1;
    }
    ab.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    AppMethodBeat.o(52873);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.g
 * JD-Core Version:    0.7.0.1
 */