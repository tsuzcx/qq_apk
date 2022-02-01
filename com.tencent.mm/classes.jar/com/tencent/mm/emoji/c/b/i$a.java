package com.tencent.mm.emoji.c.b;

import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig$Companion;", "", "()V", "convertScene", "", "panelScene", "isShowCaptureEntrance", "", "scene", "isShowCustomEntrance", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i$a
{
  public static int rC(int paramInt)
  {
    if (paramInt != ChatFooterPanel.XYm)
    {
      if (paramInt == ChatFooterPanel.XYr) {
        return 3;
      }
      if (paramInt == ChatFooterPanel.XYs) {
        return 4;
      }
      if (paramInt == ChatFooterPanel.XYt) {
        return 5;
      }
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b.i.a
 * JD-Core Version:    0.7.0.1
 */