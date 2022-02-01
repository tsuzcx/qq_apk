package com.tencent.mm.emoji.b.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"TAG", "", "captureGroupId", "getCaptureGroupId", "()Ljava/lang/String;", "customGroupId", "getCustomGroupId", "smileyGroupId", "getSmileyGroupId", "smileyRecentGroupId", "getSmileyRecentGroupId", "createCaptureGroupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "createCustomGroupInfo", "createSmileyGroupInfo", "createSmileyRecentGroupInfo", "plugin-emojisdk_release"})
public final class af
{
  private static final String TAG = "MicroMsg.PanelItemGroup";
  private static final String jJZ = "smiley";
  private static final String jKa = "smiley_recent";
  private static final String jKb = "custom";
  private static final String jKc = "capture";
  
  public static final EmojiGroupInfo aCA()
  {
    AppMethodBeat.i(105575);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(jJZ);
    localEmojiGroupInfo.bIQ(MMApplicationContext.getContext().getString(a.j.emoji_panel_smiley_title));
    AppMethodBeat.o(105575);
    return localEmojiGroupInfo;
  }
  
  public static final EmojiGroupInfo aCB()
  {
    AppMethodBeat.i(105576);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(jKb);
    localEmojiGroupInfo.bIQ(MMApplicationContext.getContext().getString(a.j.emoji_panel_custom_title));
    AppMethodBeat.o(105576);
    return localEmojiGroupInfo;
  }
  
  public static final EmojiGroupInfo aCC()
  {
    AppMethodBeat.i(105577);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(jKc);
    localEmojiGroupInfo.bIQ(MMApplicationContext.getContext().getString(a.j.emoji_panel_capture_title));
    AppMethodBeat.o(105577);
    return localEmojiGroupInfo;
  }
  
  public static final String aCw()
  {
    return jJZ;
  }
  
  public static final String aCx()
  {
    return jKb;
  }
  
  public static final String aCy()
  {
    return jKc;
  }
  
  public static final EmojiGroupInfo aCz()
  {
    AppMethodBeat.i(105574);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.setProductID(jKa);
    localEmojiGroupInfo.bIQ(MMApplicationContext.getContext().getString(a.j.emoji_panel_smiley_recent_title));
    AppMethodBeat.o(105574);
    return localEmojiGroupInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.af
 * JD-Core Version:    0.7.0.1
 */