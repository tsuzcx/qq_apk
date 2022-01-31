package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.emoji.f.h;
import java.util.List;

final class EmojiStoreV2DesignerUI$2
  implements Runnable
{
  EmojiStoreV2DesignerUI$2(EmojiStoreV2DesignerUI paramEmojiStoreV2DesignerUI, List paramList) {}
  
  public final void run()
  {
    int k = 8;
    EmojiStoreV2DesignerUI localEmojiStoreV2DesignerUI = this.jgP;
    int i;
    View localView;
    if (this.jgQ.size() > 3)
    {
      i = 1;
      if (localEmojiStoreV2DesignerUI.jgz != null) {
        localEmojiStoreV2DesignerUI.jgz.setVisibility(0);
      }
      if (localEmojiStoreV2DesignerUI.jgC != null) {
        localEmojiStoreV2DesignerUI.jgC.setVisibility(0);
      }
      if (localEmojiStoreV2DesignerUI.jgB != null) {
        localEmojiStoreV2DesignerUI.jgB.setVisibility(0);
      }
      if (localEmojiStoreV2DesignerUI.jgD != null)
      {
        localView = localEmojiStoreV2DesignerUI.jgD;
        if (i == 0) {
          break label176;
        }
      }
    }
    label176:
    for (int j = 0;; j = 8)
    {
      localView.setVisibility(j);
      if (localEmojiStoreV2DesignerUI.jgE != null) {
        localEmojiStoreV2DesignerUI.jgE.setText(f.h.emoji_store_product_more_title);
      }
      if (localEmojiStoreV2DesignerUI.jgF != null)
      {
        localView = localEmojiStoreV2DesignerUI.jgF;
        j = k;
        if (i != 0) {
          j = 0;
        }
        localView.setVisibility(j);
      }
      if (localEmojiStoreV2DesignerUI.jgw != null) {
        localEmojiStoreV2DesignerUI.jgw.setPadding(0, 0, 0, 0);
      }
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