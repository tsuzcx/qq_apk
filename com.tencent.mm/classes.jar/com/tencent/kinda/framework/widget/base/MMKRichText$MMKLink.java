package com.tencent.kinda.framework.widget.base;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.KLink;
import com.tencent.kinda.gen.LinkStyle;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMKRichText$MMKLink
  implements KLink
{
  private VoidCallback clickCallback;
  public boolean hasCallBack = false;
  private int linkColor;
  private LinkStyle linkStyle;
  private String text;
  
  public SpannableString get()
  {
    AppMethodBeat.i(144949);
    SpannableString localSpannableString = new SpannableString("");
    if (this.text != null) {
      localSpannableString = new SpannableString(this.text);
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
    AppMethodBeat.o(144949);
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
  
  public void setLinkColor(long paramLong)
  {
    AppMethodBeat.i(144948);
    this.linkColor = MMKViewUtil.argbColor(paramLong);
    AppMethodBeat.o(144948);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKRichText.MMKLink
 * JD-Core Version:    0.7.0.1
 */