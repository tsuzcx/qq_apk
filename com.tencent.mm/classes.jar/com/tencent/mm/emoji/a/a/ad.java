package com.tencent.mm.emoji.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"TAG", "", "captureGroupId", "getCaptureGroupId", "()Ljava/lang/String;", "customGroupId", "getCustomGroupId", "smileyGroupId", "getSmileyGroupId", "smileyRecentGroupId", "getSmileyRecentGroupId", "createCaptureGroupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "createCustomGroupInfo", "createSmileyGroupInfo", "createSmileyRecentGroupInfo", "plugin-emojisdk_release"})
public final class ad
{
  private static final String TAG = "MicroMsg.PanelItemGroup";
  private static final String glK = "smiley";
  private static final String glL = "smiley_recent";
  private static final String glM = "custom";
  private static final String glN = "capture";
  
  public static final String afA()
  {
    return glM;
  }
  
  public static final String afB()
  {
    return glN;
  }
  
  public static final EmojiGroupInfo afC()
  {
    AppMethodBeat.i(105574);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(glL);
    localEmojiGroupInfo.bec(aj.getContext().getString(2131758283));
    AppMethodBeat.o(105574);
    return localEmojiGroupInfo;
  }
  
  public static final EmojiGroupInfo afD()
  {
    AppMethodBeat.i(105575);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(glK);
    localEmojiGroupInfo.bec(aj.getContext().getString(2131758284));
    AppMethodBeat.o(105575);
    return localEmojiGroupInfo;
  }
  
  public static final EmojiGroupInfo afE()
  {
    AppMethodBeat.i(105576);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(glM);
    localEmojiGroupInfo.bec(aj.getContext().getString(2131758280));
    AppMethodBeat.o(105576);
    return localEmojiGroupInfo;
  }
  
  public static final EmojiGroupInfo afF()
  {
    AppMethodBeat.i(105577);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(glN);
    localEmojiGroupInfo.bec(aj.getContext().getString(2131758279));
    AppMethodBeat.o(105577);
    return localEmojiGroupInfo;
  }
  
  public static final String afz()
  {
    return glK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.ad
 * JD-Core Version:    0.7.0.1
 */