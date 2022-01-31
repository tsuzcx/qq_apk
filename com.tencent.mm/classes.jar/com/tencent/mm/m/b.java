package com.tencent.mm.m;

import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  public static int Ab()
  {
    return bk.getInt(g.AA().getValue("InputLimitSessionTextMsg"), 8192) * 2;
  }
  
  public static int Ac()
  {
    return bk.getInt(g.AA().getValue("InputLimitSNSObjectText"), 2000) * 2;
  }
  
  public static int Ad()
  {
    return bk.getInt(g.AA().getValue("SnsCommentMaxSize"), 1000) * 2;
  }
  
  public static int Ae()
  {
    return bk.getInt(g.AA().getValue("InputLimitFavText"), 100000) * 2;
  }
  
  public static int Af()
  {
    return bk.getInt(g.AA().getValue("InputLimitSendEmotionBufSize"), 5242880);
  }
  
  public static int Ag()
  {
    try
    {
      int i = bk.getInt(g.AA().getValue("InputLimitSendEmotionWidth"), 1024);
      return i;
    }
    catch (Exception localException)
    {
      y.b("MicroMsg.BoundaryConfig", "getCustomEmojiMaxWidthAndHeight:%s", new Object[] { localException });
    }
    return 1024;
  }
  
  public static int Ah()
  {
    try
    {
      int i = bk.getInt(g.AA().getValue("InputLimitSendAppMsgEmotionBufSize"), 5242880);
      return i;
    }
    catch (Exception localException)
    {
      y.b("MicroMsg.BoundaryConfig", "getAppEmojiMsgMaxSize:%s", new Object[] { localException });
    }
    return 5242880;
  }
  
  public static int Ai()
  {
    if (!com.tencent.mm.kernel.g.DN().Dc()) {
      return 26214400;
    }
    return bk.getInt(g.AA().getValue("InputLimitFavImageSize"), 26214400);
  }
  
  public static int Aj()
  {
    return bk.getInt(g.AA().getValue("InputLimitVideoSize"), 26214400);
  }
  
  public static String Ak()
  {
    return g.AA().getValue("InputLimitForbiddenChar");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.m.b
 * JD-Core Version:    0.7.0.1
 */