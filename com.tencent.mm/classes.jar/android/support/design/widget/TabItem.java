package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.design.a.a;
import android.support.v7.widget.az;
import android.util.AttributeSet;
import android.view.View;

public class TabItem
  extends View
{
  public final Drawable icon;
  public final int sg;
  public final CharSequence text;
  
  public TabItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = az.a(paramContext, paramAttributeSet, a.a.TabItem);
    this.text = paramContext.getText(2);
    this.icon = paramContext.getDrawable(0);
    this.sg = paramContext.getResourceId(1, 0);
    paramContext.awJ.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.TabItem
 * JD-Core Version:    0.7.0.1
 */