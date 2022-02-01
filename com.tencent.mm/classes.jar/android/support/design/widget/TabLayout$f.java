package android.support.design.widget;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;

public final class TabLayout$f
{
  Drawable icon;
  int position = -1;
  Object tag;
  CharSequence text;
  CharSequence tj;
  public View tk;
  public TabLayout tl;
  public TabLayout.h tm;
  
  private f z(View paramView)
  {
    this.tk = paramView;
    cL();
    return this;
  }
  
  public final f ak(int paramInt)
  {
    return z(LayoutInflater.from(this.tm.getContext()).inflate(paramInt, this.tm, false));
  }
  
  final void cL()
  {
    if (this.tm != null) {
      this.tm.update();
    }
  }
  
  public final f d(CharSequence paramCharSequence)
  {
    if ((TextUtils.isEmpty(this.tj)) && (!TextUtils.isEmpty(paramCharSequence))) {
      this.tm.setContentDescription(paramCharSequence);
    }
    this.text = paramCharSequence;
    cL();
    return this;
  }
  
  public final f f(Object paramObject)
  {
    this.tag = paramObject;
    return this;
  }
  
  public final View getCustomView()
  {
    return this.tk;
  }
  
  public final Object getTag()
  {
    return this.tag;
  }
  
  public final boolean isSelected()
  {
    if (this.tl == null) {
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    return this.tl.getSelectedTabPosition() == this.position;
  }
  
  public final void select()
  {
    if (this.tl == null) {
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    this.tl.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.TabLayout.f
 * JD-Core Version:    0.7.0.1
 */