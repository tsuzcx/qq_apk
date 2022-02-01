package com.tencent.mm.plugin.emoji.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.s;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class c
{
  public static boolean a(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(109440);
    if (paramEmojiGroupInfo == null)
    {
      AppMethodBeat.o(109440);
      return false;
    }
    boolean bool = apa(paramEmojiGroupInfo.field_productID);
    AppMethodBeat.o(109440);
    return bool;
  }
  
  public static boolean apa(String paramString)
  {
    AppMethodBeat.i(109441);
    if (paramString == null)
    {
      AppMethodBeat.o(109441);
      return false;
    }
    boolean bool = paramString.equals(dDt());
    AppMethodBeat.o(109441);
    return bool;
  }
  
  public static boolean dBJ()
  {
    AppMethodBeat.i(109438);
    boolean bool = s.getEmojiStorageMgr().adjv.jcV();
    AppMethodBeat.o(109438);
    return bool;
  }
  
  public static final String dDt()
  {
    AppMethodBeat.i(109442);
    String str = EmojiGroupInfo.aklD;
    AppMethodBeat.o(109442);
    return str;
  }
  
  public static boolean i(cjb paramcjb)
  {
    AppMethodBeat.i(109439);
    if (paramcjb == null)
    {
      AppMethodBeat.o(109439);
      return false;
    }
    boolean bool = apa(paramcjb.ProductID);
    AppMethodBeat.o(109439);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.c
 * JD-Core Version:    0.7.0.1
 */