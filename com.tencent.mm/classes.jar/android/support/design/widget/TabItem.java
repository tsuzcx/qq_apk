package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.design.a.k;
import android.support.v7.widget.ax;
import android.util.AttributeSet;
import android.view.View;

public final class TabItem
  extends View
{
  final Drawable kc;
  final int kd;
  final CharSequence mText;
  
  public TabItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = ax.a(paramContext, paramAttributeSet, a.k.TabItem);
    this.mText = paramContext.getText(a.k.TabItem_android_text);
    this.kc = paramContext.getDrawable(a.k.TabItem_android_icon);
    this.kd = paramContext.getResourceId(a.k.TabItem_android_layout, 0);
    paramContext.alZ.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.design.widget.TabItem
 * JD-Core Version:    0.7.0.1
 */