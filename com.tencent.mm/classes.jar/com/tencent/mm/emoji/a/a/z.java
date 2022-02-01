package com.tencent.mm.emoji.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"TAG", "", "captureGroupId", "getCaptureGroupId", "()Ljava/lang/String;", "customGroupId", "getCustomGroupId", "smileyGroupId", "getSmileyGroupId", "smileyRecentGroupId", "getSmileyRecentGroupId", "createCaptureGroupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "createCustomGroupInfo", "createSmileyGroupInfo", "createSmileyRecentGroupInfo", "plugin-emojisdk_release"})
public final class z
{
  private static final String TAG = "MicroMsg.PanelItemGroup";
  private static final String fOv = "smiley";
  private static final String fOw = "smiley_recent";
  private static final String fOx = "custom";
  private static final String fOy = "capture";
  
  public static final String abS()
  {
    return fOv;
  }
  
  public static final String abT()
  {
    return fOx;
  }
  
  public static final String abU()
  {
    return fOy;
  }
  
  public static final EmojiGroupInfo abV()
  {
    AppMethodBeat.i(105574);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(fOw);
    localEmojiGroupInfo.aWg(aj.getContext().getString(2131758283));
    AppMethodBeat.o(105574);
    return localEmojiGroupInfo;
  }
  
  public static final EmojiGroupInfo abW()
  {
    AppMethodBeat.i(105575);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(fOv);
    localEmojiGroupInfo.aWg(aj.getContext().getString(2131758284));
    AppMethodBeat.o(105575);
    return localEmojiGroupInfo;
  }
  
  public static final EmojiGroupInfo abX()
  {
    AppMethodBeat.i(105576);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(fOx);
    localEmojiGroupInfo.aWg(aj.getContext().getString(2131758280));
    AppMethodBeat.o(105576);
    return localEmojiGroupInfo;
  }
  
  public static final EmojiGroupInfo abY()
  {
    AppMethodBeat.i(105577);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(fOy);
    localEmojiGroupInfo.aWg(aj.getContext().getString(2131758279));
    AppMethodBeat.o(105577);
    return localEmojiGroupInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.z
 * JD-Core Version:    0.7.0.1
 */