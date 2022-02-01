package com.tencent.kinda.framework.widget.base;

import android.widget.TextView;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.ColorUtil.MMViewType;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.KRichLabelView;
import com.tencent.kinda.gen.KText;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class MMKRichLabelView
  extends MMKLabelView
  implements KRichLabelView
{
  public VoidCallback linkCallback;
  private MMKRichText richText;
  
  public KText getRichText()
  {
    return this.richText;
  }
  
  public void setRichText(KText paramKText)
  {
    AppMethodBeat.i(19103);
    if ((paramKText != null) && ((paramKText instanceof MMKRichText)))
    {
      this.richText = ((MMKRichText)paramKText);
      this.linkCallback = this.richText.linkCallback;
      ((TextView)getView()).setText(this.richText.get());
      if (!this.richText.hasLinkAndCanCallback) {
        break label174;
      }
      ((TextView)getView()).setClickable(true);
    }
    for (;;)
    {
      Log.d("MMKRichLabelView", "setRichText: %s, raw color: %s, color: %s, colorHex: %s", new Object[] { this.richText.get().toString(), getTextColor(), Integer.valueOf(MMKViewUtil.argbColor(ColorUtil.getColorByMode(getTextColor(), ColorUtil.MMViewType.MMKRichLabelView))), Integer.toHexString(MMKViewUtil.argbColor(ColorUtil.getColorByModeNoCompat(getTextColor()))) });
      setTextColor(getTextColor());
      notifyChanged();
      AppMethodBeat.o(19103);
      return;
      label174:
      ((TextView)getView()).setClickable(false);
    }
  }
  
  public void setTextColor(DynamicColor paramDynamicColor)
  {
    AppMethodBeat.i(19104);
    super.setTextColor(paramDynamicColor);
    Log.d("MMKRichLabelView", "setTextColor: " + Integer.toHexString(MMKViewUtil.argbColor(ColorUtil.getColorByMode(paramDynamicColor, ColorUtil.MMViewType.MMKRichLabelView))));
    ((TextView)getView()).setTextColor(MMKViewUtil.argbColor(ColorUtil.getColorByModeNoCompat(paramDynamicColor)));
    notifyChanged();
    AppMethodBeat.o(19104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKRichLabelView
 * JD-Core Version:    0.7.0.1
 */