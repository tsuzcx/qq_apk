package com.tencent.mm.emoji.c.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"TAG", "", "captureGroupId", "getCaptureGroupId", "()Ljava/lang/String;", "customGroupId", "getCustomGroupId", "smileyGroupId", "getSmileyGroupId", "smileyRecentGroupId", "getSmileyRecentGroupId", "createCaptureGroupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "createCustomGroupInfo", "createSmileyGroupInfo", "createSmileyRecentGroupInfo", "plugin-emojisdk_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class af
{
  private static final String TAG = "MicroMsg.PanelItemGroup";
  private static final String mjq = "smiley";
  private static final String mjr = "smiley_recent";
  private static final String mjs = "custom";
  private static final String mjt = "capture";
  
  public static final String aVt()
  {
    return mjq;
  }
  
  public static final String aVu()
  {
    return mjs;
  }
  
  public static final String aVv()
  {
    return mjt;
  }
  
  public static final EmojiGroupInfo aVw()
  {
    AppMethodBeat.i(105574);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.field_productID = mjr;
    localEmojiGroupInfo.field_packName = MMApplicationContext.getContext().getString(a.j.emoji_panel_smiley_recent_title);
    AppMethodBeat.o(105574);
    return localEmojiGroupInfo;
  }
  
  public static final EmojiGroupInfo aVx()
  {
    AppMethodBeat.i(105575);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.field_productID = mjq;
    localEmojiGroupInfo.field_packName = MMApplicationContext.getContext().getString(a.j.emoji_panel_smiley_title);
    AppMethodBeat.o(105575);
    return localEmojiGroupInfo;
  }
  
  public static final EmojiGroupInfo aVy()
  {
    AppMethodBeat.i(105576);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.field_productID = mjs;
    localEmojiGroupInfo.field_packName = MMApplicationContext.getContext().getString(a.j.emoji_panel_custom_title);
    AppMethodBeat.o(105576);
    return localEmojiGroupInfo;
  }
  
  public static final EmojiGroupInfo aVz()
  {
    AppMethodBeat.i(105577);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.field_productID = mjt;
    localEmojiGroupInfo.field_packName = MMApplicationContext.getContext().getString(a.j.emoji_panel_capture_title);
    AppMethodBeat.o(105577);
    return localEmojiGroupInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b.af
 * JD-Core Version:    0.7.0.1
 */