package com.google.android.material.tabs;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ac;
import com.google.android.material.a.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TabItem
  extends View
{
  public final CharSequence bba;
  public final Drawable dqY;
  public final int dxN;
  
  public TabItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(208928);
    paramContext = ac.a(paramContext, paramAttributeSet, a.k.TabItem);
    this.bba = paramContext.getText(a.k.TabItem_android_text);
    this.dqY = paramContext.getDrawable(a.k.TabItem_android_icon);
    this.dxN = paramContext.w(a.k.TabItem_android_layout, 0);
    paramContext.xv.recycle();
    AppMethodBeat.o(208928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.tabs.TabItem
 * JD-Core Version:    0.7.0.1
 */