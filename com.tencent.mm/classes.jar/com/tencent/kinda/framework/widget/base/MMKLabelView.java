package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.Ellipsize;
import com.tencent.kinda.gen.FontStyle;
import com.tencent.kinda.gen.KLabelView;
import com.tencent.kinda.gen.TextAlign;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.wallet_core.ui.e;

public class MMKLabelView
  extends MMKView<TextView>
  implements KLabelView
{
  private Ellipsize ellipsize;
  private FontStyle fontStyle = FontStyle.REGULAR;
  private int maxLength = -1;
  private MMKRichText richText;
  private TextAlign textAlign = TextAlign.LEFT;
  private long textColor = -1L;
  private String textFontName;
  
  private void updateTypeface()
  {
    AppMethodBeat.i(144908);
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
        String str = e.RV(i);
        ((TextView)getView()).setTypeface(Typeface.createFromAsset(ah.getContext().getAssets(), str));
        AppMethodBeat.o(144908);
        return;
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
        if (this.textFontName.equalsIgnoreCase("WeChat-Sans-SS-Bold")) {
          i = 1;
        }
      }
      else
      {
        if (this.fontStyle == FontStyle.BOLD)
        {
          ((TextView)getView()).setTypeface(null, 1);
          AppMethodBeat.o(144908);
          return;
        }
        ((TextView)getView()).setTypeface(null, 0);
        AppMethodBeat.o(144908);
        return;
      }
      i = -1;
    }
  }
  
  public TextView createView(Context paramContext)
  {
    AppMethodBeat.i(144909);
    paramContext = new TextView(paramContext);
    paramContext.setOnTouchListener(new m());
    paramContext.setGravity(19);
    AppMethodBeat.o(144909);
    return paramContext;
  }
  
  public boolean getAdjustsFontSizeToFitWidth()
  {
    return false;
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
    AppMethodBeat.i(144912);
    int i = ((TextView)getView()).getLineCount();
    AppMethodBeat.o(144912);
    return i;
  }
  
  public int getMaxLength()
  {
    return this.maxLength;
  }
  
  public String getText()
  {
    AppMethodBeat.i(144914);
    ab.d("base_MMKView", "MMKLabelView getText ");
    Object localObject = ((TextView)getView()).getText();
    if (localObject != null)
    {
      localObject = ((CharSequence)localObject).toString();
      AppMethodBeat.o(144914);
      return localObject;
    }
    AppMethodBeat.o(144914);
    return null;
  }
  
  public TextAlign getTextAlign()
  {
    return this.textAlign;
  }
  
  public long getTextColor()
  {
    return this.textColor;
  }
  
  public String getTextFont()
  {
    return this.textFontName;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(144916);
    float f = a.ar(ah.getContext(), (int)((TextView)getView()).getTextSize());
    AppMethodBeat.o(144916);
    return f;
  }
  
  protected void notifyChanged()
  {
    AppMethodBeat.i(144922);
    super.notifyChanged();
    AppMethodBeat.o(144922);
  }
  
  public void setAdjustsFontSizeToFitWidth(boolean paramBoolean) {}
  
  public void setEllipsize(Ellipsize paramEllipsize)
  {
    AppMethodBeat.i(144919);
    this.ellipsize = paramEllipsize;
    switch (MMKLabelView.1.$SwitchMap$com$tencent$kinda$gen$Ellipsize[paramEllipsize.ordinal()])
    {
    }
    for (;;)
    {
      notifyChanged();
      AppMethodBeat.o(144919);
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
    AppMethodBeat.i(144910);
    this.fontStyle = paramFontStyle;
    updateTypeface();
    AppMethodBeat.o(144910);
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(144911);
    if (paramInt > 0)
    {
      ((TextView)getView()).setMaxLines(paramInt);
      notifyChanged();
    }
    AppMethodBeat.o(144911);
  }
  
  public void setMaxLength(int paramInt)
  {
    AppMethodBeat.i(144921);
    if (paramInt >= 0)
    {
      this.maxLength = paramInt;
      ((TextView)getView()).setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.maxLength) });
    }
    AppMethodBeat.o(144921);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(144913);
    if (paramString != null)
    {
      ((TextView)getView()).setText(j.b(ah.getContext(), paramString, ((TextView)getView()).getTextSize()));
      notifyChanged();
    }
    AppMethodBeat.o(144913);
  }
  
  public void setTextAlign(TextAlign paramTextAlign)
  {
    AppMethodBeat.i(144920);
    int i;
    if (paramTextAlign != null)
    {
      this.textAlign = paramTextAlign;
      i = ((TextView)getView()).getGravity();
      switch (MMKLabelView.1.$SwitchMap$com$tencent$kinda$gen$TextAlign[this.textAlign.ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(144920);
      return;
      ((TextView)getView()).setGravity(i | 0x3);
      AppMethodBeat.o(144920);
      return;
      ((TextView)getView()).setGravity(17);
      AppMethodBeat.o(144920);
      return;
      ((TextView)getView()).setGravity(i | 0x5);
    }
  }
  
  public void setTextColor(long paramLong)
  {
    AppMethodBeat.i(144917);
    this.textColor = paramLong;
    ab.e("MMKLabelView", "setTextColor: " + Integer.toHexString(MMKViewUtil.argbColor(paramLong)));
    ((TextView)getView()).setTextColor(MMKViewUtil.argbColor(paramLong));
    notifyChanged();
    AppMethodBeat.o(144917);
  }
  
  public void setTextFont(String paramString)
  {
    AppMethodBeat.i(144918);
    if (paramString != null)
    {
      this.textFontName = paramString;
      updateTypeface();
    }
    AppMethodBeat.o(144918);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(144915);
    if (paramFloat > 0.0F)
    {
      ((TextView)getView()).setTextSize(0, MMKViewUtil.dpToPx(ah.getContext(), paramFloat));
      notifyChanged();
    }
    AppMethodBeat.o(144915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKLabelView
 * JD-Core Version:    0.7.0.1
 */