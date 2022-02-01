package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import com.tencent.kinda.framework.R.color;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.KindaFontUtil.KindaTypefaceSpan;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.FontStyle;
import com.tencent.kinda.gen.KLink;
import com.tencent.kinda.gen.KText;
import com.tencent.kinda.gen.LinkStyle;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.appbrand.widget.i.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

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
      this.spanText.append(l.c(MMApplicationContext.getContext(), paramString));
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
    private DynamicColor bgColor;
    private int bgRadius;
    private VoidCallback clickCallback;
    private FontStyle fontStyle = FontStyle.REGULAR;
    public boolean hasCallBack = false;
    private int linkColor;
    private LinkStyle linkStyle;
    private boolean setLinkColor = false;
    private String text;
    private String textFontName;
    private float textSize;
    
    public SpannableString get()
    {
      AppMethodBeat.i(19108);
      SpannableString localSpannableString = new SpannableString("");
      if (this.text != null) {
        localSpannableString = new SpannableString(this.text);
      }
      for (;;)
      {
        if ((!this.setLinkColor) && (ColorUtil.ifCompatKindaDarkModeDefaultColor())) {
          this.linkColor = MMKViewUtil.argbColor(ColorUtil.getColorByMode(new DynamicColor(Long.parseLong("E6000000", 16), Long.parseLong("CCFFFFFF", 16))));
        }
        localSpannableString.setSpan(new ForegroundColorSpan(this.linkColor), 0, localSpannableString.length(), 33);
        if (this.clickCallback != null) {
          localSpannableString.setSpan(new LinkClickableSpan(this.linkColor, this.clickCallback), 0, localSpannableString.length(), 33);
        }
        if (this.linkStyle == LinkStyle.DELETED) {
          localSpannableString.setSpan(new StrikethroughSpan(), 0, localSpannableString.length(), 33);
        }
        if (this.linkStyle == LinkStyle.UNDERLINE) {
          localSpannableString.setSpan(new UnderlineSpan(), 0, localSpannableString.length(), 33);
        }
        if (this.bgColor != null)
        {
          long l = ColorUtil.getColorByMode(this.bgColor);
          int i = a.fromDPToPix(MMApplicationContext.getContext(), 4);
          localSpannableString.setSpan(new c(this.text, i, i, (int)this.textSize, this.linkColor, (int)l, this.bgRadius), 0, localSpannableString.length(), 33);
        }
        if ((!TextUtils.isEmpty(this.textFontName)) || (this.fontStyle != FontStyle.REGULAR)) {
          localSpannableString.setSpan(new KindaFontUtil.KindaTypefaceSpan(this.textFontName, this.fontStyle), 0, localSpannableString.length(), 33);
        }
        AppMethodBeat.o(19108);
        return localSpannableString;
      }
    }
    
    public void setBackground(DynamicColor paramDynamicColor, int paramInt)
    {
      AppMethodBeat.i(264924);
      this.bgColor = paramDynamicColor;
      this.bgRadius = a.fromDPToPix(MMApplicationContext.getContext(), paramInt);
      AppMethodBeat.o(264924);
    }
    
    public void setFontStyle(FontStyle paramFontStyle)
    {
      this.fontStyle = paramFontStyle;
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
    
    public void setLinkFont(String paramString)
    {
      this.textFontName = paramString;
    }
    
    public void setLinkStyle(LinkStyle paramLinkStyle)
    {
      this.linkStyle = paramLinkStyle;
    }
    
    public void setText(String paramString)
    {
      this.text = paramString;
    }
    
    public void setTextSize(float paramFloat)
    {
      AppMethodBeat.i(264925);
      this.textSize = a.fromDPToPix(MMApplicationContext.getContext(), paramFloat);
      AppMethodBeat.o(264925);
    }
    
    static class LinkClickableSpan
      extends p
    {
      private VoidCallback clickCallback;
      private int linkColor;
      private LinkStyle linkStyle;
      
      public LinkClickableSpan(int paramInt, VoidCallback paramVoidCallback)
      {
        super(null);
        AppMethodBeat.i(19105);
        this.linkColor = paramInt;
        this.clickCallback = paramVoidCallback;
        setColor(this.linkColor, MMApplicationContext.getContext().getResources().getColor(R.color.BW_0_Alpha_0_1));
        AppMethodBeat.o(19105);
      }
      
      public void onClick(View paramView)
      {
        AppMethodBeat.i(19106);
        if (this.clickCallback != null) {
          this.clickCallback.call();
        }
        AppMethodBeat.o(19106);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKRichText
 * JD-Core Version:    0.7.0.1
 */