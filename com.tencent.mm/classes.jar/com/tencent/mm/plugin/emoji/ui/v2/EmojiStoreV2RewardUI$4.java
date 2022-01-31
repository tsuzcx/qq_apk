package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMFormInputView;

final class EmojiStoreV2RewardUI$4
  implements TextWatcher
{
  EmojiStoreV2RewardUI$4(EmojiStoreV2RewardUI paramEmojiStoreV2RewardUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(53698);
    float f1;
    if (EmojiStoreV2RewardUI.h(this.lqH) != null) {
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
      label92:
      break label92;
    }
    if ((f1 > 200.0F) || (f1 < 1.0F))
    {
      EmojiStoreV2RewardUI.e(this.lqH).getContentEditText().setTextColor(this.lqH.getContext().getResources().getColor(2131690391));
      EmojiStoreV2RewardUI.h(this.lqH).setEnabled(false);
      AppMethodBeat.o(53698);
      return;
    }
    EmojiStoreV2RewardUI.e(this.lqH).getContentEditText().setTextColor(this.lqH.getContext().getResources().getColor(2131690322));
    EmojiStoreV2RewardUI.h(this.lqH).setEnabled(true);
    AppMethodBeat.o(53698);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.4
 * JD-Core Version:    0.7.0.1
 */