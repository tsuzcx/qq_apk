package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.mm.plugin.emoji.f.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.s;

final class EmojiStoreV2RewardUI$4
  implements TextWatcher
{
  EmojiStoreV2RewardUI$4(EmojiStoreV2RewardUI paramEmojiStoreV2RewardUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    float f1;
    if (EmojiStoreV2RewardUI.h(this.jhK) != null) {
      if ((paramEditable != null) && (paramEditable.length() > 0))
      {
        String str = paramEditable.toString();
        int i = str.indexOf(".");
        if ((i > 0) && (str.length() - i - 1 > 2)) {
          paramEditable.delete(i + 3, i + 4);
        }
        f1 = 0.0F;
      }
    }
    try
    {
      float f2 = Float.valueOf(paramEditable.toString()).floatValue();
      f1 = f2;
    }
    catch (NumberFormatException paramEditable)
    {
      label87:
      break label87;
    }
    if ((f1 > 200.0F) || (f1 < 1.0F))
    {
      EmojiStoreV2RewardUI.e(this.jhK).getContentEditText().setTextColor(this.jhK.mController.uMN.getResources().getColor(f.b.red));
      EmojiStoreV2RewardUI.h(this.jhK).setEnabled(false);
      return;
    }
    EmojiStoreV2RewardUI.e(this.jhK).getContentEditText().setTextColor(this.jhK.mController.uMN.getResources().getColor(f.b.normal_text_color));
    EmojiStoreV2RewardUI.h(this.jhK).setEnabled(true);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.4
 * JD-Core Version:    0.7.0.1
 */