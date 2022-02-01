package com.tencent.mm.emoji.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"TAG", "", "captureGroupId", "getCaptureGroupId", "()Ljava/lang/String;", "customGroupId", "getCustomGroupId", "smileyGroupId", "getSmileyGroupId", "smileyRecentGroupId", "getSmileyRecentGroupId", "createCaptureGroupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "createCustomGroupInfo", "createSmileyGroupInfo", "createSmileyRecentGroupInfo", "plugin-emojisdk_release"})
public final class z
{
  private static final String TAG = "MicroMsg.PanelItemGroup";
  private static final String fSg = "smiley";
  private static final String fSh = "smiley_recent";
  private static final String fSi = "custom";
  private static final String fSj = "capture";
  
  public static final String acS()
  {
    return fSg;
  }
  
  public static final String acT()
  {
    return fSi;
  }
  
  public static final String acU()
  {
    return fSj;
  }
  
  public static final EmojiGroupInfo acV()
  {
    AppMethodBeat.i(105574);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(fSh);
    localEmojiGroupInfo.aXI(ai.getContext().getString(2131758283));
    AppMethodBeat.o(105574);
    return localEmojiGroupInfo;
  }
  
  public static final EmojiGroupInfo acW()
  {
    AppMethodBeat.i(105575);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(fSg);
    localEmojiGroupInfo.aXI(ai.getContext().getString(2131758284));
    AppMethodBeat.o(105575);
    return localEmojiGroupInfo;
  }
  
  public static final EmojiGroupInfo acX()
  {
    AppMethodBeat.i(105576);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(fSi);
    localEmojiGroupInfo.aXI(ai.getContext().getString(2131758280));
    AppMethodBeat.o(105576);
    return localEmojiGroupInfo;
  }
  
  public static final EmojiGroupInfo acY()
  {
    AppMethodBeat.i(105577);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(fSj);
    localEmojiGroupInfo.aXI(ai.getContext().getString(2131758279));
    AppMethodBeat.o(105577);
    return localEmojiGroupInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.z
 * JD-Core Version:    0.7.0.1
 */