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
  CharSequence vc;
  public View vd;
  public TabLayout ve;
  public TabLayout.h vf;
  
  private f z(View paramView)
  {
    this.vd = paramView;
    updateView();
    return this;
  }
  
  public final f ak(int paramInt)
  {
    return z(LayoutInflater.from(this.vf.getContext()).inflate(paramInt, this.vf, false));
  }
  
  public final f d(CharSequence paramCharSequence)
  {
    if ((TextUtils.isEmpty(this.vc)) && (!TextUtils.isEmpty(paramCharSequence))) {
      this.vf.setContentDescription(paramCharSequence);
    }
    this.text = paramCharSequence;
    updateView();
    return this;
  }
  
  public final f g(Object paramObject)
  {
    this.tag = paramObject;
    return this;
  }
  
  public final View getCustomView()
  {
    return this.vd;
  }
  
  public final int getPosition()
  {
    return this.position;
  }
  
  public final Object getTag()
  {
    return this.tag;
  }
  
  public final boolean isSelected()
  {
    if (this.ve == null) {
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    return this.ve.getSelectedTabPosition() == this.position;
  }
  
  public final void select()
  {
    if (this.ve == null) {
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    this.ve.b(this);
  }
  
  final void updateView()
  {
    if (this.vf != null) {
      this.vf.update();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.TabLayout.f
 * JD-Core Version:    0.7.0.1
 */