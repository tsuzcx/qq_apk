package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.ColorUtil.MMViewType;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.BaselineAdjustmentAlign;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.Ellipsize;
import com.tencent.kinda.gen.FontStyle;
import com.tencent.kinda.gen.KLabelView;
import com.tencent.kinda.gen.TextAlign;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.al;
import com.tencent.mm.wallet_core.ui.e;

public class MMKLabelView
  extends MMKView<TextView>
  implements KLabelView
{
  private Ellipsize ellipsize;
  private FontStyle fontStyle;
  private int maxLength;
  private MMKRichText richText;
  private TextAlign textAlign;
  private DynamicColor textColor;
  private String textFontName;
  
  public MMKLabelView()
  {
    AppMethodBeat.i(19063);
    this.textAlign = TextAlign.LEFT;
    this.maxLength = -1;
    this.textColor = new DynamicColor(-1L, 0L);
    this.fontStyle = FontStyle.REGULAR;
    AppMethodBeat.o(19063);
  }
  
  private void updateTypeface()
  {
    AppMethodBeat.i(19064);
    int i;
    if (this.textFontName != null) {
      if (this.textFontName.equalsIgnoreCase("WeChat-Sans-SS-Light")) {
        i = 2;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        String str = e.agp(i);
        try
        {
          ((TextView)getView()).setTypeface(Typeface.createFromAsset(aj.getContext().getAssets(), str));
          AppMethodBeat.o(19064);
          return;
        }
        catch (Exception localException)
        {
          ad.e("base_MMKView", "setTypeface() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          AppMethodBeat.o(19064);
          return;
        }
        if (this.textFontName.equalsIgnoreCase("WeChat-Sans-SS-Medium"))
        {
          i = 0;
          continue;
        }
        if (this.textFontName.equalsIgnoreCase("WeChat-Sans-SS-Regular"))
        {
          i = 3;
          continue;
        }
        if (this.textFontName.equalsIgnoreCase("WeChat-Sans-SS-Bold"))
        {
          i = 1;
          continue;
        }
        if (this.textFontName.equalsIgnoreCase("WeChat-Sans-Std-Medium"))
        {
          i = 4;
          continue;
        }
        if (this.textFontName.equalsIgnoreCase("WeChat-Sans-Std-Light"))
        {
          i = 6;
          continue;
        }
        if (this.textFontName.equalsIgnoreCase("WeChat-Sans-Std-Bold"))
        {
          i = 5;
          continue;
        }
        if (!this.textFontName.equalsIgnoreCase("WeChat-Sans-Std-Regular")) {
          break label301;
        }
        i = 7;
        continue;
      }
      if (this.fontStyle == FontStyle.BOLD)
      {
        ((TextView)getView()).setTypeface(null, 1);
        AppMethodBeat.o(19064);
        return;
      }
      if (this.fontStyle == FontStyle.MEDIUM)
      {
        al.a(((TextView)getView()).getPaint(), 0.8F);
        AppMethodBeat.o(19064);
        return;
      }
      ((TextView)getView()).setTypeface(null, 0);
      AppMethodBeat.o(19064);
      return;
      label301:
      i = -1;
    }
  }
  
  public TextView createView(Context paramContext)
  {
    AppMethodBeat.i(19065);
    TextView localTextView = new TextView(paramContext);
    localTextView.setOnTouchListener(new n());
    localTextView.setGravity(19);
    if (ColorUtil.ifCompatKindaDarkModeDefaultColor())
    {
      localTextView.setTextColor(paramContext.getResources().getColor(2131100711));
      this.textColor = new DynamicColor(Long.parseLong("E6000000", 16), Long.parseLong("CCFFFFFF", 16));
    }
    AppMethodBeat.o(19065);
    return localTextView;
  }
  
  public boolean getAdjustsFontSizeToFitWidth()
  {
    return false;
  }
  
  public BaselineAdjustmentAlign getBaselineAdjustment()
  {
    return null;
  }
  
  public Ellipsize getEllipsize()
  {
    return this.ellipsize;
  }
  
  public FontStyle getFontStyle()
  {
    return this.fontStyle;
  }
  
  public int getLines()
  {
    AppMethodBeat.i(19068);
    int i = ((TextView)getView()).getLineCount();
    AppMethodBeat.o(19068);
    return i;
  }
  
  public int getMaxLength()
  {
    return this.maxLength;
  }
  
  public String getText()
  {
    AppMethodBeat.i(19070);
    ad.d("base_MMKView", "MMKLabelView getText ");
    Object localObject = ((TextView)getView()).getText();
    if (localObject != null)
    {
      localObject = ((CharSequence)localObject).toString();
      AppMethodBeat.o(19070);
      return localObject;
    }
    AppMethodBeat.o(19070);
    return null;
  }
  
  public TextAlign getTextAlign()
  {
    return this.textAlign;
  }
  
  public DynamicColor getTextColor()
  {
    return this.textColor;
  }
  
  public String getTextFont()
  {
    return this.textFontName;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(19072);
    float f = a.aA(aj.getContext(), (int)((TextView)getView()).getTextSize());
    AppMethodBeat.o(19072);
    return f;
  }
  
  protected void notifyChanged()
  {
    AppMethodBeat.i(19078);
    super.notifyChanged();
    AppMethodBeat.o(19078);
  }
  
  public void setAdjustsFontSizeToFitWidth(boolean paramBoolean) {}
  
  public void setBaselineAdjustment(BaselineAdjustmentAlign paramBaselineAdjustmentAlign) {}
  
  public void setEllipsize(Ellipsize paramEllipsize)
  {
    AppMethodBeat.i(19075);
    this.ellipsize = paramEllipsize;
    switch (1.$SwitchMap$com$tencent$kinda$gen$Ellipsize[paramEllipsize.ordinal()])
    {
    }
    for (;;)
    {
      notifyChanged();
      AppMethodBeat.o(19075);
      return;
      ((TextView)getView()).setEllipsize(TextUtils.TruncateAt.END);
      continue;
      ((TextView)getView()).setEllipsize(TextUtils.TruncateAt.START);
      continue;
      ((TextView)getView()).setEllipsize(TextUtils.TruncateAt.MIDDLE);
    }
  }
  
  public void setFontStyle(FontStyle paramFontStyle)
  {
    AppMethodBeat.i(19066);
    this.fontStyle = paramFontStyle;
    updateTypeface();
    AppMethodBeat.o(19066);
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(19067);
    if (paramInt > 0)
    {
      ((TextView)getView()).setMaxLines(paramInt);
      notifyChanged();
    }
    AppMethodBeat.o(19067);
  }
  
  public void setMaxLength(int paramInt)
  {
    AppMethodBeat.i(19077);
    if (paramInt >= 0)
    {
      this.maxLength = paramInt;
      ((TextView)getView()).setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.maxLength) });
    }
    AppMethodBeat.o(19077);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(19069);
    if (paramString != null)
    {
      ((TextView)getView()).setText(k.b(aj.getContext(), paramString, ((TextView)getView()).getTextSize()));
      notifyChanged();
    }
    AppMethodBeat.o(19069);
  }
  
  public void setTextAlign(TextAlign paramTextAlign)
  {
    AppMethodBeat.i(19076);
    int i;
    if (paramTextAlign != null)
    {
      this.textAlign = paramTextAlign;
      i = ((TextView)getView()).getGravity();
      switch (1.$SwitchMap$com$tencent$kinda$gen$TextAlign[this.textAlign.ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(19076);
      return;
      ((TextView)getView()).setGravity(i | 0x3);
      AppMethodBeat.o(19076);
      return;
      ((TextView)getView()).setGravity(17);
      AppMethodBeat.o(19076);
      return;
      ((TextView)getView()).setGravity(i | 0x5);
    }
  }
  
  public void setTextColor(DynamicColor paramDynamicColor)
  {
    AppMethodBeat.i(19073);
    this.textColor = paramDynamicColor;
    ad.d("MMKLabelView", "setTextColor: " + Integer.toHexString(MMKViewUtil.argbColor(ColorUtil.getColorByMode(paramDynamicColor, ColorUtil.MMViewType.MMKLabelViewText))));
    ((TextView)getView()).setTextColor(MMKViewUtil.argbColor(ColorUtil.getColorByMode(paramDynamicColor, ColorUtil.MMViewType.MMKLabelViewText)));
    notifyChanged();
    AppMethodBeat.o(19073);
  }
  
  public void setTextFont(String paramString)
  {
    AppMethodBeat.i(19074);
    if (paramString != null)
    {
      this.textFontName = paramString;
      updateTypeface();
    }
    AppMethodBeat.o(19074);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(19071);
    if (paramFloat > 0.0F)
    {
      ((TextView)getView()).setTextSize(0, MMKViewUtil.dpToPx(aj.getContext(), paramFloat));
      notifyChanged();
    }
    AppMethodBeat.o(19071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKLabelView
 * JD-Core Version:    0.7.0.1
 */