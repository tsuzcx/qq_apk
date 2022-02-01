package com.tencent.kinda.framework.widget.base;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.KLink;
import com.tencent.kinda.gen.KText;
import com.tencent.kinda.gen.LinkStyle;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.aj;

public class MMKRichText
  implements KText
{
  public boolean hasLinkAndCanCallback;
  private SpannableStringBuilder spanText;
  
  public MMKRichText()
  {
    AppMethodBeat.i(19109);
    this.hasLinkAndCanCallback = false;
    this.spanText = new SpannableStringBuilder("");
    AppMethodBeat.o(19109);
  }
  
  public void appendLink(KLink paramKLink)
  {
    AppMethodBeat.i(19111);
    if ((paramKLink != null) && ((paramKLink instanceof MMKLink)))
    {
      paramKLink = (MMKLink)paramKLink;
      this.spanText.append(paramKLink.get());
      this.hasLinkAndCanCallback = paramKLink.hasCallBack;
    }
    AppMethodBeat.o(19111);
  }
  
  public void appendText(String paramString)
  {
    AppMethodBeat.i(19110);
    if (paramString != null) {
      this.spanText.append(k.c(aj.getContext(), paramString));
    }
    AppMethodBeat.o(19110);
  }
  
  public CharSequence get()
  {
    return this.spanText;
  }
  
  public static class MMKLink
    implements KLink
  {
    private VoidCallback clickCallback;
    public boolean hasCallBack = false;
    private int linkColor;
    private LinkStyle linkStyle;
    private boolean setLinkColor = false;
    private String text;
    
    public SpannableString get()
    {
      AppMethodBeat.i(19108);
      SpannableString localSpannableString = new SpannableString("");
      if (this.text != null) {
        localSpannableString = new SpannableString(this.text);
      }
      if ((!this.setLinkColor) && (ColorUtil.ifCompatKindaDarkModeDefaultColor())) {
        this.linkColor = MMKViewUtil.argbColor(ColorUtil.getColorByMode(new DynamicColor(Long.parseLong("E6000000", 16), Long.parseLong("CCFFFFFF", 16))));
      }
      localSpannableString.setSpan(new ForegroundColorSpan(this.linkColor), 0, localSpannableString.length(), 33);
      if (this.clickCallback != null) {
        localSpannableString.setSpan(new MMKRichText.MMKLink.LinkClickableSpan(this.linkColor, this.clickCallback), 0, localSpannableString.length(), 33);
      }
      if (this.linkStyle == LinkStyle.DELETED) {
        localSpannableString.setSpan(new StrikethroughSpan(), 0, localSpannableString.length(), 33);
      }
      if (this.linkStyle == LinkStyle.UNDERLINE) {
        localSpannableString.setSpan(new UnderlineSpan(), 0, localSpannableString.length(), 33);
      }
      AppMethodBeat.o(19108);
      return localSpannableString;
    }
    
    public void setLinkCallbackImpl(VoidCallback paramVoidCallback)
    {
      if (paramVoidCallback != null)
      {
        this.clickCallback = paramVoidCallback;
        this.hasCallBack = true;
      }
    }
    
    public void setLinkColor(DynamicColor paramDynamicColor)
    {
      AppMethodBeat.i(19107);
      this.linkColor = MMKViewUtil.argbColor(ColorUtil.getColorByMode(paramDynamicColor));
      this.setLinkColor = true;
      AppMethodBeat.o(19107);
    }
    
    public void setLinkFont(String paramString) {}
    
    public void setLinkStyle(LinkStyle paramLinkStyle)
    {
      this.linkStyle = paramLinkStyle;
    }
    
    public void setText(String paramString)
    {
      this.text = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKRichText
 * JD-Core Version:    0.7.0.1
 */