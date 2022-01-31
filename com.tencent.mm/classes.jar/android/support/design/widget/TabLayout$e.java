package android.support.design.widget;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;

public final class TabLayout$e
{
  Object lV;
  CharSequence lW;
  public View lX;
  TabLayout lY;
  TabLayout.g lZ;
  Drawable la;
  int mPosition = -1;
  CharSequence mText;
  
  private e u(View paramView)
  {
    this.lX = paramView;
    bJ();
    return this;
  }
  
  public final e P(int paramInt)
  {
    return u(LayoutInflater.from(this.lZ.getContext()).inflate(paramInt, this.lZ, false));
  }
  
  final void bJ()
  {
    if (this.lZ != null) {
      this.lZ.update();
    }
  }
  
  public final e c(CharSequence paramCharSequence)
  {
    this.mText = paramCharSequence;
    bJ();
    return this;
  }
  
  public final boolean isSelected()
  {
    if (this.lY == null) {
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    return this.lY.getSelectedTabPosition() == this.mPosition;
  }
  
  public final void select()
  {
    if (this.lY == null) {
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    this.lY.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.TabLayout.e
 * JD-Core Version:    0.7.0.1
 */