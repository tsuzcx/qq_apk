package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.design.a.a;
import android.support.v7.widget.az;
import android.util.AttributeSet;
import android.view.View;

public final class TabItem
  extends View
{
  final Drawable la;
  final int lb;
  final CharSequence mText;
  
  public TabItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = az.a(paramContext, paramAttributeSet, a.a.TabItem);
    this.mText = paramContext.getText(2);
    this.la = paramContext.getDrawable(0);
    this.lb = paramContext.getResourceId(1, 0);
    paramContext.aoo.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.design.widget.TabItem
 * JD-Core Version:    0.7.0.1
 */