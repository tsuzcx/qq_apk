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
  private ImageButton roT;
  
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
    this.roT = new ImageButton(paramContext);
    this.roT.setClickable(false);
    this.roT.setBackground(null);
    addView(this.roT, new FrameLayout.LayoutParams(getActionBarHeight(), -1, 17));
    setAccessibilityLabel(getDefaultAccessibilityLabel());
    AppMethodBeat.o(135463);
  }
  
  public ImageView getButtonImage()
  {
    return this.roT;
  }
  
  protected String getDefaultAccessibilityLabel()
  {
    AppMethodBeat.i(246034);
    String str = getContext().getString(a.g.app_brand_accessibility_option_button);
    AppMethodBeat.o(246034);
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
    this.roT.setVisibility(0);
    this.roT.setAlpha(1.0F);
    this.roT.setImageDrawable(getDefaultImageDrawable());
    AppMethodBeat.o(135467);
  }
  
  public final void setAccessibilityLabel(String paramString)
  {
    AppMethodBeat.i(135464);
    if ((this.roT != null) && (this.roT.getVisibility() == 0)) {
      this.roT.setContentDescription(paramString);
    }
    AppMethodBeat.o(135464);
  }
  
  public void setColor(int paramInt)
  {
    AppMethodBeat.i(135466);
    this.roT.setImageDrawable(getDefaultImageDrawable());
    this.roT.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    this.roT.setBackground(getBackground());
    if (this.roT.getBackground() != null) {
      this.roT.getBackground().setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
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
    this.roT.setImageDrawable(new BitmapDrawable(getResources(), paramBitmap));
    this.roT.setVisibility(0);
    AppMethodBeat.o(135465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton
 * JD-Core Version:    0.7.0.1
 */