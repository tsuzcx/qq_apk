package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class e
{
  private static final c iWG;
  
  static
  {
    c.a locala = new c.a();
    locala.erd = true;
    locala.erk = 1;
    locala.erC = false;
    iWG = locala.OV();
  }
  
  public static c a(String paramString, int paramInt, Object... paramVarArgs)
  {
    if (!bk.bl(paramString))
    {
      c.a locala = new c.a();
      locala.erf = true;
      locala.erh = paramString;
      locala.erm = paramInt;
      locala.erl = paramInt;
      locala.erJ = paramVarArgs;
      return locala.OV();
    }
    y.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    return null;
  }
  
  public static c aHe()
  {
    c.a locala = new c.a();
    locala.erd = true;
    locala.erf = false;
    locala.erk = 3;
    return locala.OV();
  }
  
  public static c cJ(String paramString1, String paramString2)
  {
    return g(paramString1, paramString2, new Object[0]);
  }
  
  public static c cK(String paramString1, String paramString2)
  {
    paramString1 = EmojiLogic.I(b.FL(), paramString1, paramString2);
    if (!bk.bl(paramString1))
    {
      paramString2 = new c.a();
      paramString2.erd = true;
      paramString2.erf = true;
      paramString2.erh = paramString1;
      paramString2.erD = true;
      return paramString2.OV();
    }
    y.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    return null;
  }
  
  public static c cL(String paramString1, String paramString2)
  {
    paramString1 = EmojiLogic.I(b.FL(), paramString1, paramString2);
    if (!bk.bl(paramString1))
    {
      paramString2 = new c.a();
      paramString2.erd = true;
      paramString2.erf = true;
      paramString2.erh = paramString1;
      paramString2.erD = false;
      return paramString2.OV();
    }
    y.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    return null;
  }
  
  public static c g(String paramString1, String paramString2, Object... paramVarArgs)
  {
    paramString1 = EmojiLogic.I(b.FL(), paramString1, paramString2);
    if (!bk.bl(paramString1))
    {
      paramString2 = new c.a();
      paramString2.erd = true;
      paramString2.erf = true;
      paramString2.erh = paramString1;
      paramString2.erJ = paramVarArgs;
      return paramString2.OV();
    }
    y.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    return null;
  }
  
  public static c h(String paramString1, String paramString2, Object... paramVarArgs)
  {
    String str = g.DP().dKt;
    paramString1 = EmojiLogic.I(b.FL(), paramString1, paramString2);
    if (!bk.bl(paramString1))
    {
      paramString2 = new c.a();
      paramString2.erd = true;
      paramString2.erf = true;
      paramString2.erh = paramString1;
      paramString2.eri = str;
      paramString2.erJ = paramVarArgs;
      return paramString2.OV();
    }
    y.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    return null;
  }
  
  public static c j(String paramString1, String paramString2, Object... paramVarArgs)
  {
    paramString1 = EmojiLogic.I(b.FL(), paramString1, paramString2);
    if (!bk.bl(paramString1))
    {
      paramString2 = new c.a();
      paramString2.erd = false;
      paramString2.erf = true;
      paramString2.erh = paramString1;
      paramString2.erJ = paramVarArgs;
      return paramString2.OV();
    }
    y.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    return null;
  }
  
  public static c k(String paramString1, String paramString2, Object... paramVarArgs)
  {
    paramString1 = EmojiLogic.I(b.FL(), paramString1, paramString2);
    if (!bk.bl(paramString1))
    {
      paramString2 = new c.a();
      paramString2.erd = true;
      paramString2.erf = true;
      paramString2.erh = paramString1;
      paramString2.erJ = paramVarArgs;
      return paramString2.OV();
    }
    y.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    return null;
  }
  
  public static c o(String paramString, Object... paramVarArgs)
  {
    if (!bk.bl(paramString))
    {
      c.a locala = new c.a();
      locala.erf = true;
      locala.erh = paramString;
      locala.erJ = paramVarArgs;
      return locala.OV();
    }
    y.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    return null;
  }
  
  public static c p(String paramString, Object... paramVarArgs)
  {
    if (!bk.bl(paramString))
    {
      c.a locala = new c.a();
      locala.erf = true;
      locala.erh = paramString;
      locala.erG = false;
      locala.erJ = paramVarArgs;
      return locala.OV();
    }
    y.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    return null;
  }
  
  public static c s(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = EmojiLogic.I(b.FL(), paramString1, paramString2);
    if (!bk.bl(paramString1))
    {
      paramString2 = new c.a();
      paramString2.erd = true;
      paramString2.erf = true;
      paramString2.erh = paramString1;
      paramString2.erm = paramInt;
      paramString2.erl = paramInt;
      return paramString2.OV();
    }
    y.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.e
 * JD-Core Version:    0.7.0.1
 */