package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable.OnSelectedListener;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

public abstract class au<D extends ao>
  implements eq
{
  public Rect a(ep paramep)
  {
    return f_().getScreenBound(paramep);
  }
  
  public void a(GL10 paramGL10)
  {
    f_().a(paramGL10);
  }
  
  public Rect b(ep paramep)
  {
    return f_().getBound(paramep);
  }
  
  public abstract D f_();
  
  public List<Boundable<ep>> getGroupBounds()
  {
    return f_().getGroupBounds();
  }
  
  public String getId()
  {
    return f_().getId();
  }
  
  public int getLevel()
  {
    return f_().getLevel();
  }
  
  public int getZIndex()
  {
    return f_().getZIndex();
  }
  
  public boolean handleOnTap()
  {
    return f_().handleOnTap();
  }
  
  public boolean isRemoved()
  {
    return f_().isRemoved();
  }
  
  public boolean isSelected()
  {
    return f_().isSelected();
  }
  
  public boolean isVisible()
  {
    return f_().isVisible();
  }
  
  public boolean onTap(float paramFloat1, float paramFloat2)
  {
    return f_().onTap(paramFloat1, paramFloat2);
  }
  
  public void releaseData()
  {
    f_().releaseData();
  }
  
  public void remove()
  {
    f_().remove();
  }
  
  public void setLevel(int paramInt)
  {
    f_().setLevel(paramInt);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    f_().setSelected(paramBoolean);
  }
  
  public <T> void setSelectedListener(Selectable.OnSelectedListener<T> paramOnSelectedListener)
  {
    f_().setSelectedListener(paramOnSelectedListener);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    f_().setVisible(paramBoolean);
  }
  
  public void setZIndex(float paramFloat)
  {
    setZIndex((int)paramFloat);
  }
  
  public void setZIndex(int paramInt)
  {
    f_().setZIndex(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.au
 * JD-Core Version:    0.7.0.1
 */