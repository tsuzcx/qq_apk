package com.tencent.mm.emoji.b.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"TAG", "", "captureGroupId", "getCaptureGroupId", "()Ljava/lang/String;", "customGroupId", "getCustomGroupId", "smileyGroupId", "getSmileyGroupId", "smileyRecentGroupId", "getSmileyRecentGroupId", "createCaptureGroupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "createCustomGroupInfo", "createSmileyGroupInfo", "createSmileyRecentGroupInfo", "plugin-emojisdk_release"})
public final class ad
{
  private static final String TAG = "MicroMsg.PanelItemGroup";
  private static final String gYZ = "smiley";
  private static final String gZa = "smiley_recent";
  private static final String gZb = "custom";
  private static final String gZc = "capture";
  
  public static final String avB()
  {
    return gYZ;
  }
  
  public static final String avC()
  {
    return gZb;
  }
  
  public static final String avD()
  {
    return gZc;
  }
  
  public static final EmojiGroupInfo avE()
  {
    AppMethodBeat.i(105574);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(gZa);
    localEmojiGroupInfo.bxl(MMApplicationContext.getContext().getString(2131758573));
    AppMethodBeat.o(105574);
    return localEmojiGroupInfo;
  }
  
  public static final EmojiGroupInfo avF()
  {
    AppMethodBeat.i(105575);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(gYZ);
    localEmojiGroupInfo.bxl(MMApplicationContext.getContext().getString(2131758574));
    AppMethodBeat.o(105575);
    return localEmojiGroupInfo;
  }
  
  public static final EmojiGroupInfo avG()
  {
    AppMethodBeat.i(105576);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(gZb);
    localEmojiGroupInfo.bxl(MMApplicationContext.getContext().getString(2131758568));
    AppMethodBeat.o(105576);
    return localEmojiGroupInfo;
  }
  
  public static final EmojiGroupInfo avH()
  {
    AppMethodBeat.i(105577);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(gZc);
    localEmojiGroupInfo.bxl(MMApplicationContext.getContext().getString(2131758567));
    AppMethodBeat.o(105577);
    return localEmojiGroupInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.ad
 * JD-Core Version:    0.7.0.1
 */