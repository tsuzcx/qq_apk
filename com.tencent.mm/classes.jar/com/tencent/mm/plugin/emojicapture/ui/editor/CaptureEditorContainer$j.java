package com.tencent.mm.plugin.emojicapture.ui.editor;

import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;

final class CaptureEditorContainer$j
  implements Runnable
{
  CaptureEditorContainer$j(CaptureEditorContainer paramCaptureEditorContainer) {}
  
  public final void run()
  {
    ChatFooterPanel localChatFooterPanel = CaptureEditorContainer.f(this.jpF);
    if (localChatFooterPanel != null) {
      localChatFooterPanel.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer.j
 * JD-Core Version:    0.7.0.1
 */