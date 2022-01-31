package com.tencent.mm.plugin.emoji.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class a
{
  public static boolean Lj(String paramString)
  {
    AppMethodBeat.i(53866);
    if (paramString == null)
    {
      AppMethodBeat.o(53866);
      return false;
    }
    boolean bool = paramString.equals(bnx());
    AppMethodBeat.o(53866);
    return bool;
  }
  
  public static boolean b(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(53865);
    if (paramEmojiGroupInfo == null)
    {
      AppMethodBeat.o(53865);
      return false;
    }
    boolean bool = Lj(paramEmojiGroupInfo.field_productID);
    AppMethodBeat.o(53865);
    return bool;
  }
  
  public static boolean bmI()
  {
    AppMethodBeat.i(53863);
    boolean bool = i.getEmojiStorageMgr().yNo.dyT();
    AppMethodBeat.o(53863);
    return bool;
  }
  
  public static final String bnx()
  {
    AppMethodBeat.i(53867);
    String str = EmojiGroupInfo.yPd;
    AppMethodBeat.o(53867);
    return str;
  }
  
  public static boolean g(EmotionSummary paramEmotionSummary)
  {
    AppMethodBeat.i(53864);
    if (paramEmotionSummary == null)
    {
      AppMethodBeat.o(53864);
      return false;
    }
    boolean bool = Lj(paramEmotionSummary.ProductID);
    AppMethodBeat.o(53864);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.h.a
 * JD-Core Version:    0.7.0.1
 */