package com.tencent.mm.plugin.emoji.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;

public final class a
{
  public static boolean Up(String paramString)
  {
    AppMethodBeat.i(109441);
    if (paramString == null)
    {
      AppMethodBeat.o(109441);
      return false;
    }
    boolean bool = paramString.equals(bXj());
    AppMethodBeat.o(109441);
    return bool;
  }
  
  public static boolean b(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(109440);
    if (paramEmojiGroupInfo == null)
    {
      AppMethodBeat.o(109440);
      return false;
    }
    boolean bool = Up(paramEmojiGroupInfo.field_productID);
    AppMethodBeat.o(109440);
    return bool;
  }
  
  public static boolean bWs()
  {
    AppMethodBeat.i(109438);
    boolean bool = k.getEmojiStorageMgr().FyZ.eNf();
    AppMethodBeat.o(109438);
    return bool;
  }
  
  public static final String bXj()
  {
    AppMethodBeat.i(109442);
    String str = EmojiGroupInfo.LBN;
    AppMethodBeat.o(109442);
    return str;
  }
  
  public static boolean g(EmotionSummary paramEmotionSummary)
  {
    AppMethodBeat.i(109439);
    if (paramEmotionSummary == null)
    {
      AppMethodBeat.o(109439);
      return false;
    }
    boolean bool = Up(paramEmotionSummary.ProductID);
    AppMethodBeat.o(109439);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.h.a
 * JD-Core Version:    0.7.0.1
 */