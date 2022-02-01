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
  public final CharSequence LV;
  public final int bEN;
  public final Drawable bxV;
  
  public TabItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(239544);
    paramContext = ac.a(paramContext, paramAttributeSet, a.k.TabItem);
    this.LV = paramContext.getText(a.k.TabItem_android_text);
    this.bxV = paramContext.getDrawable(a.k.TabItem_android_icon);
    this.bEN = paramContext.r(a.k.TabItem_android_layout, 0);
    paramContext.wA.recycle();
    AppMethodBeat.o(239544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.tabs.TabItem
 * JD-Core Version:    0.7.0.1
 */