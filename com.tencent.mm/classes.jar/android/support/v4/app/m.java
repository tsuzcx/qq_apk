package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.n;
import android.view.View;
import android.view.ViewGroup;

public abstract class m
  extends n
{
  private final j wr;
  private o ws = null;
  private Fragment wt = null;
  
  public m(j paramj)
  {
    this.wr = paramj;
  }
  
  private static String b(int paramInt, long paramLong)
  {
    return "android:switcher:" + paramInt + ":" + paramLong;
  }
  
  public final void a(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
  
  public final void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (this.ws == null) {
      this.ws = this.wr.bP();
    }
    this.ws.c((Fragment)paramObject);
  }
  
  public final boolean a(View paramView, Object paramObject)
  {
    return ((Fragment)paramObject).getView() == paramView;
  }
  
  public abstract Fragment ae(int paramInt);
  
  public final Object b(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.ws == null) {
      this.ws = this.wr.bP();
    }
    long l = paramInt;
    Object localObject = b(paramViewGroup.getId(), l);
    localObject = this.wr.G((String)localObject);
    if (localObject != null) {
      this.ws.d((Fragment)localObject);
    }
    for (paramViewGroup = (ViewGroup)localObject;; paramViewGroup = (ViewGroup)localObject)
    {
      if (paramViewGroup != this.wt)
      {
        paramViewGroup.setMenuVisibility(false);
        paramViewGroup.setUserVisibleHint(false);
      }
      return paramViewGroup;
      localObject = ae(paramInt);
      this.ws.a(paramViewGroup.getId(), (Fragment)localObject, b(paramViewGroup.getId(), l));
    }
  }
  
  public final void cc()
  {
    if (this.ws != null)
    {
      this.ws.commitNowAllowingStateLoss();
      this.ws = null;
    }
  }
  
  public final Parcelable cd()
  {
    return null;
  }
  
  public final void e(ViewGroup paramViewGroup)
  {
    if (paramViewGroup.getId() == -1) {
      throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
  }
  
  public final void j(Object paramObject)
  {
    paramObject = (Fragment)paramObject;
    if (paramObject != this.wt)
    {
      if (this.wt != null)
      {
        this.wt.setMenuVisibility(false);
        this.wt.setUserVisibleHint(false);
      }
      if (paramObject != null)
      {
        paramObject.setMenuVisibility(true);
        paramObject.setUserVisibleHint(true);
      }
      this.wt = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v4.app.m
 * JD-Core Version:    0.7.0.1
 */