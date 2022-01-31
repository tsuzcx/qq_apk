package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandOptionButton
  extends FrameLayout
{
  private boolean jbF;
  private View jbG;
  private View jbH;
  private TextView jbI;
  private ImageButton jbJ;
  
  public AppBrandOptionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(87498);
    this.jbF = true;
    init(paramContext);
    AppMethodBeat.o(87498);
  }
  
  public AppBrandOptionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(87499);
    this.jbF = true;
    init(paramContext);
    AppMethodBeat.o(87499);
  }
  
  private int getActionBarHeight()
  {
    AppMethodBeat.i(87500);
    int i = getResources().getDimensionPixelSize(2131427557);
    AppMethodBeat.o(87500);
    return i;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(87501);
    this.jbG = LayoutInflater.from(paramContext).inflate(2130968657, this, false);
    this.jbH = this.jbG.findViewById(2131821148);
    this.jbI = ((TextView)this.jbG.findViewById(2131821149));
    this.jbI.setMaxLines(1);
    this.jbI.setClickable(false);
    this.jbI.setBackground(null);
    addView(this.jbG, new FrameLayout.LayoutParams(-2, -1, 17));
    this.jbG.setVisibility(8);
    this.jbJ = new ImageButton(paramContext);
    this.jbJ.setClickable(false);
    this.jbJ.setBackground(null);
    addView(this.jbJ, new FrameLayout.LayoutParams(getActionBarHeight(), -1, 17));
    AppMethodBeat.o(87501);
  }
  
  ImageView getButtonImage()
  {
    return this.jbJ;
  }
  
  protected Drawable getDefaultImageDrawable()
  {
    AppMethodBeat.i(87507);
    Drawable localDrawable = b.k(getContext(), 2130837716);
    AppMethodBeat.o(87507);
    return localDrawable;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(87506);
    this.jbF = true;
    this.jbG.setVisibility(8);
    this.jbJ.setVisibility(0);
    this.jbJ.setAlpha(1.0F);
    this.jbJ.setImageDrawable(getDefaultImageDrawable());
    AppMethodBeat.o(87506);
  }
  
  public void setAccessibilityLabel(String paramString)
  {
    AppMethodBeat.i(87502);
    if ((this.jbJ != null) && (this.jbJ.getVisibility() == 0))
    {
      this.jbJ.setContentDescription(paramString);
      AppMethodBeat.o(87502);
      return;
    }
    if ((this.jbI != null) && (this.jbI.getVisibility() == 0)) {
      this.jbI.setContentDescription(paramString);
    }
    AppMethodBeat.o(87502);
  }
  
  public void setColor(int paramInt)
  {
    AppMethodBeat.i(87505);
    this.jbI.setTextColor(paramInt);
    this.jbJ.setImageDrawable(getDefaultImageDrawable());
    this.jbJ.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    this.jbJ.setBackground(getBackground());
    if (this.jbJ.getBackground() != null) {
      this.jbJ.getBackground().setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(87505);
  }
  
  public void setIcon(Bitmap paramBitmap)
  {
    AppMethodBeat.i(87503);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(87503);
      return;
    }
    this.jbF = false;
    this.jbJ.setImageDrawable(new BitmapDrawable(getResources(), paramBitmap));
    this.jbJ.setVisibility(0);
    this.jbG.setVisibility(8);
    AppMethodBeat.o(87503);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(87504);
    this.jbF = false;
    this.jbI.setText(paramString);
    this.jbG.setVisibility(0);
    this.jbJ.setVisibility(8);
    AppMethodBeat.o(87504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton
 * JD-Core Version:    0.7.0.1
 */