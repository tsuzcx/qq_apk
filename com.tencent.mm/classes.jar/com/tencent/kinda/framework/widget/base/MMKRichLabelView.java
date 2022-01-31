package com.tencent.kinda.framework.widget.base;

import android.widget.TextView;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.KRichLabelView;
import com.tencent.kinda.gen.KText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class MMKRichLabelView
  extends MMKLabelView
  implements KRichLabelView
{
  private MMKRichText richText;
  
  public KText getRichText()
  {
    return this.richText;
  }
  
  public void setRichText(KText paramKText)
  {
    AppMethodBeat.i(144944);
    if ((paramKText != null) && ((paramKText instanceof MMKRichText)))
    {
      this.richText = ((MMKRichText)paramKText);
      ((TextView)getView()).setText(this.richText.get());
      if (!this.richText.hasLinkAndCanCallback) {
        break label152;
      }
      ((TextView)getView()).setClickable(true);
    }
    for (;;)
    {
      ab.e("MMKRichLabelView", "setRichText: %s, raw color: %s, color: %s, colorHex: %s", new Object[] { this.richText.get().toString(), getTextColor(), Integer.valueOf(MMKViewUtil.argbColor(getTextColor())), Integer.toHexString(MMKViewUtil.argbColor(getTextColor())) });
      setTextColor(getTextColor());
      notifyChanged();
      AppMethodBeat.o(144944);
      return;
      label152:
      ((TextView)getView()).setClickable(false);
    }
  }
  
  public void setTextColor(long paramLong)
  {
    AppMethodBeat.i(144945);
    super.setTextColor(paramLong);
    ab.e("MMKRichLabelView", "setTextColor: " + Integer.toHexString(MMKViewUtil.argbColor(paramLong)));
    ((TextView)getView()).setTextColor(MMKViewUtil.argbColor(paramLong));
    notifyChanged();
    AppMethodBeat.o(144945);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKRichLabelView
 * JD-Core Version:    0.7.0.1
 */