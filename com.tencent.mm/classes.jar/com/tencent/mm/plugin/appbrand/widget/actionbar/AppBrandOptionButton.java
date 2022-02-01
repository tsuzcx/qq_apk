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
  private ImageButton mUj;
  
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
    this.mUj = new ImageButton(paramContext);
    this.mUj.setClickable(false);
    this.mUj.setBackground(null);
    addView(this.mUj, new FrameLayout.LayoutParams(getActionBarHeight(), -1, 17));
    AppMethodBeat.o(135463);
  }
  
  ImageView getButtonImage()
  {
    return this.mUj;
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
    this.mUj.setVisibility(0);
    this.mUj.setAlpha(1.0F);
    this.mUj.setImageDrawable(getDefaultImageDrawable());
    AppMethodBeat.o(135467);
  }
  
  public void setAccessibilityLabel(String paramString)
  {
    AppMethodBeat.i(135464);
    if ((this.mUj != null) && (this.mUj.getVisibility() == 0)) {
      this.mUj.setContentDescription(paramString);
    }
    AppMethodBeat.o(135464);
  }
  
  public void setColor(int paramInt)
  {
    AppMethodBeat.i(135466);
    this.mUj.setImageDrawable(getDefaultImageDrawable());
    this.mUj.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    this.mUj.setBackground(getBackground());
    if (this.mUj.getBackground() != null) {
      this.mUj.getBackground().setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
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
    this.mUj.setImageDrawable(new BitmapDrawable(getResources(), paramBitmap));
    this.mUj.setVisibility(0);
    AppMethodBeat.o(135465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton
 * JD-Core Version:    0.7.0.1
 */