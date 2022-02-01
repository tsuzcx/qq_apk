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
  private ImageButton omr;
  
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
    int i = getResources().getDimensionPixelSize(2131165254);
    AppMethodBeat.o(135462);
    return i;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(135463);
    this.omr = new ImageButton(paramContext);
    this.omr.setClickable(false);
    this.omr.setBackground(null);
    addView(this.omr, new FrameLayout.LayoutParams(getActionBarHeight(), -1, 17));
    setAccessibilityLabel(getDefaultAccessibilityLabel());
    AppMethodBeat.o(135463);
  }
  
  public ImageView getButtonImage()
  {
    return this.omr;
  }
  
  protected String getDefaultAccessibilityLabel()
  {
    AppMethodBeat.i(219627);
    String str = getContext().getString(2131755326);
    AppMethodBeat.o(219627);
    return str;
  }
  
  protected Drawable getDefaultImageDrawable()
  {
    AppMethodBeat.i(135468);
    Drawable localDrawable = b.l(getContext(), 2131230975);
    AppMethodBeat.o(135468);
    return localDrawable;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(135467);
    this.omr.setVisibility(0);
    this.omr.setAlpha(1.0F);
    this.omr.setImageDrawable(getDefaultImageDrawable());
    AppMethodBeat.o(135467);
  }
  
  public final void setAccessibilityLabel(String paramString)
  {
    AppMethodBeat.i(135464);
    if ((this.omr != null) && (this.omr.getVisibility() == 0)) {
      this.omr.setContentDescription(paramString);
    }
    AppMethodBeat.o(135464);
  }
  
  public void setColor(int paramInt)
  {
    AppMethodBeat.i(135466);
    this.omr.setImageDrawable(getDefaultImageDrawable());
    this.omr.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    this.omr.setBackground(getBackground());
    if (this.omr.getBackground() != null) {
      this.omr.getBackground().setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
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
    this.omr.setImageDrawable(new BitmapDrawable(getResources(), paramBitmap));
    this.omr.setVisibility(0);
    AppMethodBeat.o(135465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton
 * JD-Core Version:    0.7.0.1
 */