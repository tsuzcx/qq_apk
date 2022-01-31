package com.tencent.mm.plugin.emoji.h;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class b
{
  public static String FL()
  {
    return ((d)g.t(d.class)).getProvider().FU() + "emoji/";
  }
  
  public static String aJL()
  {
    return ((d)g.t(d.class)).getProvider().FU() + "emoji/";
  }
  
  public static int aj(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4)) {
      return EmojiInfo.uCP;
    }
    if ((paramArrayOfByte[1] == 80) && (paramArrayOfByte[2] == 78) && (paramArrayOfByte[3] == 71)) {
      return EmojiInfo.uDa;
    }
    if ((paramArrayOfByte[0] == 71) && (paramArrayOfByte[1] == 73) && (paramArrayOfByte[2] == 70)) {
      return EmojiInfo.uDb;
    }
    if ((paramArrayOfByte[6] == 74) && (paramArrayOfByte[7] == 70) && (paramArrayOfByte[8] == 73) && (paramArrayOfByte[9] == 70)) {
      return EmojiInfo.uDc;
    }
    return EmojiInfo.uCP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.h.b
 * JD-Core Version:    0.7.0.1
 */