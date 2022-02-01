package com.tencent.mm.emoji.a.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"TAG", "", "captureGroupId", "getCaptureGroupId", "()Ljava/lang/String;", "customGroupId", "getCustomGroupId", "smileyGroupId", "getSmileyGroupId", "smileyRecentGroupId", "getSmileyRecentGroupId", "createCaptureGroupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "createCustomGroupInfo", "createSmileyGroupInfo", "createSmileyRecentGroupInfo", "plugin-emojisdk_release"})
public final class ad
{
  private static final String TAG = "MicroMsg.PanelItemGroup";
  private static final String gof = "smiley";
  private static final String gog = "smiley_recent";
  private static final String goh = "custom";
  private static final String goi = "capture";
  
  public static final String afN()
  {
    return gof;
  }
  
  public static final String afO()
  {
    return goh;
  }
  
  public static final String afP()
  {
    return goi;
  }
  
  public static final EmojiGroupInfo afQ()
  {
    AppMethodBeat.i(105574);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(gog);
    localEmojiGroupInfo.bfM(ak.getContext().getString(2131758283));
    AppMethodBeat.o(105574);
    return localEmojiGroupInfo;
  }
  
  public static final EmojiGroupInfo afR()
  {
    AppMethodBeat.i(105575);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(gof);
    localEmojiGroupInfo.bfM(ak.getContext().getString(2131758284));
    AppMethodBeat.o(105575);
    return localEmojiGroupInfo;
  }
  
  public static final EmojiGroupInfo afS()
  {
    AppMethodBeat.i(105576);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(goh);
    localEmojiGroupInfo.bfM(ak.getContext().getString(2131758280));
    AppMethodBeat.o(105576);
    return localEmojiGroupInfo;
  }
  
  public static final EmojiGroupInfo afT()
  {
    AppMethodBeat.i(105577);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(goi);
    localEmojiGroupInfo.bfM(ak.getContext().getString(2131758279));
    AppMethodBeat.o(105577);
    return localEmojiGroupInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.ad
 * JD-Core Version:    0.7.0.1
 */