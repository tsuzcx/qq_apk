package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class EmojiStoreV2DesignerUI$2
  implements Runnable
{
  EmojiStoreV2DesignerUI$2(EmojiStoreV2DesignerUI paramEmojiStoreV2DesignerUI, List paramList) {}
  
  public final void run()
  {
    int k = 8;
    AppMethodBeat.i(53581);
    EmojiStoreV2DesignerUI localEmojiStoreV2DesignerUI = this.lpI;
    int i;
    View localView;
    if (this.lpJ.size() > 3)
    {
      i = 1;
      if (localEmojiStoreV2DesignerUI.lps != null) {
        localEmojiStoreV2DesignerUI.lps.setVisibility(0);
      }
      if (localEmojiStoreV2DesignerUI.lpv != null) {
        localEmojiStoreV2DesignerUI.lpv.setVisibility(0);
      }
      if (localEmojiStoreV2DesignerUI.lpu != null) {
        localEmojiStoreV2DesignerUI.lpu.setVisibility(0);
      }
      if (localEmojiStoreV2DesignerUI.lpw != null)
      {
        localView = localEmojiStoreV2DesignerUI.lpw;
        if (i == 0) {
          break label185;
        }
      }
    }
    label185:
    for (int j = 0;; j = 8)
    {
      localView.setVisibility(j);
      if (localEmojiStoreV2DesignerUI.lpx != null) {
        localEmojiStoreV2DesignerUI.lpx.setText(2131299221);
      }
      if (localEmojiStoreV2DesignerUI.lpy != null)
      {
        localView = localEmojiStoreV2DesignerUI.lpy;
        j = k;
        if (i != 0) {
          j = 0;
        }
        localView.setVisibility(j);
      }
      if (localEmojiStoreV2DesignerUI.lpp != null) {
        localEmojiStoreV2DesignerUI.lpp.setPadding(0, 0, 0, 0);
      }
      AppMethodBeat.o(53581);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.2
 * JD-Core Version:    0.7.0.1
 */