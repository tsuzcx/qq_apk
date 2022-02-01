package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandOptionButton
  extends FrameLayout
{
  private ImageButton mZm;
  
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
    int i = getResources().getDimensionPixelSize(2131165250);
    AppMethodBeat.o(135462);
    return i;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(135463);
    this.mZm = new ImageButton(paramContext);
    this.mZm.setClickable(false);
    this.mZm.setBackground(null);
    addView(this.mZm, new FrameLayout.LayoutParams(getActionBarHeight(), -1, 17));
    setAccessibilityLabel(getDefaultAccessibilityLabel());
    AppMethodBeat.o(135463);
  }
  
  public ImageView getButtonImage()
  {
    return this.mZm;
  }
  
  protected String getDefaultAccessibilityLabel()
  {
    AppMethodBeat.i(208020);
    String str = getContext().getString(2131755290);
    AppMethodBeat.o(208020);
    return str;
  }
  
  protected Drawable getDefaultImageDrawable()
  {
    AppMethodBeat.i(135468);
    Drawable localDrawable = b.l(getContext(), 2131230952);
    AppMethodBeat.o(135468);
    return localDrawable;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(135467);
    this.mZm.setVisibility(0);
    this.mZm.setAlpha(1.0F);
    this.mZm.setImageDrawable(getDefaultImageDrawable());
    AppMethodBeat.o(135467);
  }
  
  public final void setAccessibilityLabel(String paramString)
  {
    AppMethodBeat.i(135464);
    if ((this.mZm != null) && (this.mZm.getVisibility() == 0)) {
      this.mZm.setContentDescription(paramString);
    }
    AppMethodBeat.o(135464);
  }
  
  public void setColor(int paramInt)
  {
    AppMethodBeat.i(135466);
    this.mZm.setImageDrawable(getDefaultImageDrawable());
    this.mZm.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    this.mZm.setBackground(getBackground());
    if (this.mZm.getBackground() != null) {
      this.mZm.getBackground().setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
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
    this.mZm.setImageDrawable(new BitmapDrawable(getResources(), paramBitmap));
    this.mZm.setVisibility(0);
    AppMethodBeat.o(135465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton
 * JD-Core Version:    0.7.0.1
 */