package android.support.design.widget;

import android.graphics.drawable.Drawable;
import android.view.View;

public final class TabLayout$e
{
  Object kY;
  CharSequence kZ;
  Drawable kc;
  View la;
  TabLayout lb;
  TabLayout.g lc;
  int mPosition = -1;
  CharSequence mText;
  
  public final e a(CharSequence paramCharSequence)
  {
    this.mText = paramCharSequence;
    aZ();
    return this;
  }
  
  final void aZ()
  {
    if (this.lc != null) {
      this.lc.update();
    }
  }
  
  public final void select()
  {
    if (this.lb == null) {
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    this.lb.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.design.widget.TabLayout.e
 * JD-Core Version:    0.7.0.1
 */