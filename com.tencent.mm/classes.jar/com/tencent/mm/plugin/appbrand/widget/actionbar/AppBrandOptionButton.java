package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.core.content.a;
import com.tencent.luggage.wxa.a.b;
import com.tencent.luggage.wxa.a.c;
import com.tencent.luggage.wxa.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandOptionButton
  extends FrameLayout
{
  private ImageButton uze;
  
  public AppBrandOptionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(135460);
    init(paramContext);
    AppMethodBeat.o(135460);
  }
  
  public AppBrandOptionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(135461);
    init(paramContext);
    AppMethodBeat.o(135461);
  }
  
  private int getActionBarHeight()
  {
    AppMethodBeat.i(135462);
    int i = getResources().getDimensionPixelSize(a.b.DefaultActionbarHeight);
    AppMethodBeat.o(135462);
    return i;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(135463);
    this.uze = new ImageButton(paramContext);
    this.uze.setClickable(false);
    this.uze.setBackground(null);
    this.uze.setImportantForAccessibility(2);
    addView(this.uze, new FrameLayout.LayoutParams(getActionBarHeight(), -1, 17));
    setAccessibilityLabel(getDefaultAccessibilityLabel());
    AppMethodBeat.o(135463);
  }
  
  public CharSequence getAccessibilityClassName()
  {
    AppMethodBeat.i(324200);
    String str = ImageButton.class.getName();
    AppMethodBeat.o(324200);
    return str;
  }
  
  public ImageView getButtonImage()
  {
    return this.uze;
  }
  
  protected String getDefaultAccessibilityLabel()
  {
    AppMethodBeat.i(324190);
    String str = getContext().getString(a.g.app_brand_accessibility_option_button);
    AppMethodBeat.o(324190);
    return str;
  }
  
  protected Drawable getDefaultImageDrawable()
  {
    AppMethodBeat.i(135468);
    Drawable localDrawable = a.m(getContext(), a.c.app_brand_actionbar_option_light);
    AppMethodBeat.o(135468);
    return localDrawable;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(135467);
    this.uze.setVisibility(0);
    this.uze.setAlpha(1.0F);
    this.uze.setImageDrawable(getDefaultImageDrawable());
    AppMethodBeat.o(135467);
  }
  
  public final void setAccessibilityLabel(String paramString)
  {
    AppMethodBeat.i(135464);
    if ((this.uze != null) && (this.uze.getVisibility() == 0)) {
      this.uze.setContentDescription(paramString);
    }
    AppMethodBeat.o(135464);
  }
  
  public void setColor(int paramInt)
  {
    AppMethodBeat.i(135466);
    this.uze.setImageDrawable(getDefaultImageDrawable());
    this.uze.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    this.uze.setBackground(getBackground());
    if (this.uze.getBackground() != null) {
      this.uze.getBackground().setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(135466);
  }
  
  public void setIcon(Bitmap paramBitmap)
  {
    AppMethodBeat.i(135465);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(135465);
      return;
    }
    this.uze.setImageDrawable(new BitmapDrawable(getResources(), paramBitmap));
    this.uze.setVisibility(0);
    AppMethodBeat.o(135465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton
 * JD-Core Version:    0.7.0.1
 */