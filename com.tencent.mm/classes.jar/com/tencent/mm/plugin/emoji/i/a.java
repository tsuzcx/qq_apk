package com.tencent.mm.plugin.emoji.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.c;

public final class a
{
  public static boolean ava(String paramString)
  {
    AppMethodBeat.i(109441);
    if (paramString == null)
    {
      AppMethodBeat.o(109441);
      return false;
    }
    boolean bool = paramString.equals(cWZ());
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
    boolean bool = ava(paramEmojiGroupInfo.field_productID);
    AppMethodBeat.o(109440);
    return bool;
  }
  
  public static final String cWZ()
  {
    AppMethodBeat.i(109442);
    String str = EmojiGroupInfo.YCu;
    AppMethodBeat.o(109442);
    return str;
  }
  
  public static boolean cWg()
  {
    AppMethodBeat.i(109438);
    boolean bool = p.getEmojiStorageMgr().VFI.hAU();
    AppMethodBeat.o(109438);
    return bool;
  }
  
  public static boolean g(akh paramakh)
  {
    AppMethodBeat.i(109439);
    if (paramakh == null)
    {
      AppMethodBeat.o(109439);
      return false;
    }
    boolean bool = ava(paramakh.ProductID);
    AppMethodBeat.o(109439);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.i.a
 * JD-Core Version:    0.7.0.1
 */