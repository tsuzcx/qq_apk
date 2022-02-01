package com.tencent.mm.emoji.b.b;

import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig$Companion;", "", "()V", "convertScene", "", "panelScene", "isShowCaptureEntrance", "", "scene", "isShowCustomEntrance", "plugin-emojisdk_release"})
public final class i$a
{
  public static int ph(int paramInt)
  {
    if (paramInt != ChatFooterPanel.KbC)
    {
      if (paramInt == ChatFooterPanel.KbH) {
        return 3;
      }
      if (paramInt == ChatFooterPanel.KbI) {
        return 4;
      }
      if (paramInt == ChatFooterPanel.KbJ) {
        return 5;
      }
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.i.a
 * JD-Core Version:    0.7.0.1
 */