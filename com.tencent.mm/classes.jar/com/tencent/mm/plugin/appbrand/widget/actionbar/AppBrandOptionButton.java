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
  private ImageButton lRA;
  
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
    this.lRA = new ImageButton(paramContext);
    this.lRA.setClickable(false);
    this.lRA.setBackground(null);
    addView(this.lRA, new FrameLayout.LayoutParams(getActionBarHeight(), -1, 17));
    AppMethodBeat.o(135463);
  }
  
  ImageView getButtonImage()
  {
    return this.lRA;
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
    this.lRA.setVisibility(0);
    this.lRA.setAlpha(1.0F);
    this.lRA.setImageDrawable(getDefaultImageDrawable());
    AppMethodBeat.o(135467);
  }
  
  public void setAccessibilityLabel(String paramString)
  {
    AppMethodBeat.i(135464);
    if ((this.lRA != null) && (this.lRA.getVisibility() == 0)) {
      this.lRA.setContentDescription(paramString);
    }
    AppMethodBeat.o(135464);
  }
  
  public void setColor(int paramInt)
  {
    AppMethodBeat.i(135466);
    this.lRA.setImageDrawable(getDefaultImageDrawable());
    this.lRA.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    this.lRA.setBackground(getBackground());
    if (this.lRA.getBackground() != null) {
      this.lRA.getBackground().setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
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
    this.lRA.setImageDrawable(new BitmapDrawable(getResources(), paramBitmap));
    this.lRA.setVisibility(0);
    AppMethodBeat.o(135465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton
 * JD-Core Version:    0.7.0.1
 */