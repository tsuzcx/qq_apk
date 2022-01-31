package android.support.v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import java.util.ArrayList;

public class FragmentTabHost
  extends TabHost
  implements TabHost.OnTabChangeListener
{
  private final ArrayList<FragmentTabHost.a> kf = new ArrayList();
  private int mContainerId;
  private Context mContext;
  private j wr;
  private TabHost.OnTabChangeListener wx;
  private FragmentTabHost.a wy;
  private boolean wz;
  
  public FragmentTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842995 }, 0, 0);
    this.mContainerId = paramContext.getResourceId(0, 0);
    paramContext.recycle();
    super.setOnTabChangedListener(this);
  }
  
  private o a(String paramString, o paramo)
  {
    int j = this.kf.size();
    int i = 0;
    FragmentTabHost.a locala;
    if (i < j)
    {
      locala = (FragmentTabHost.a)this.kf.get(i);
      if (locala.tag.equals(paramString))
      {
        label42:
        paramString = paramo;
        if (this.wy != locala)
        {
          paramString = paramo;
          if (paramo == null) {
            paramString = this.wr.bP();
          }
          if ((this.wy != null) && (this.wy.uD != null)) {
            paramString.c(this.wy.uD);
          }
          if (locala != null)
          {
            if (locala.uD != null) {
              break label174;
            }
            locala.uD = Fragment.instantiate(this.mContext, locala.wB.getName(), locala.wC);
            paramString.a(this.mContainerId, locala.uD, locala.tag);
          }
        }
      }
    }
    for (;;)
    {
      this.wy = locala;
      return paramString;
      i += 1;
      break;
      locala = null;
      break label42;
      label174:
      paramString.d(locala.uD);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    String str = getCurrentTabTag();
    Object localObject1 = null;
    int j = this.kf.size();
    int i = 0;
    if (i < j)
    {
      FragmentTabHost.a locala = (FragmentTabHost.a)this.kf.get(i);
      locala.uD = this.wr.G(locala.tag);
      Object localObject2 = localObject1;
      if (locala.uD != null)
      {
        localObject2 = localObject1;
        if (!locala.uD.isDetached())
        {
          if (!locala.tag.equals(str)) {
            break label114;
          }
          this.wy = locala;
          localObject2 = localObject1;
        }
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        label114:
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = this.wr.bP();
        }
        ((o)localObject2).c(locala.uD);
      }
    }
    this.wz = true;
    localObject1 = a(str, (o)localObject1);
    if (localObject1 != null)
    {
      ((o)localObject1).commit();
      this.wr.executePendingTransactions();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.wz = false;
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof FragmentTabHost.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (FragmentTabHost.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setCurrentTabByTag(paramParcelable.wA);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    FragmentTabHost.SavedState localSavedState = new FragmentTabHost.SavedState(super.onSaveInstanceState());
    localSavedState.wA = getCurrentTabTag();
    return localSavedState;
  }
  
  public void onTabChanged(String paramString)
  {
    if (this.wz)
    {
      o localo = a(paramString, null);
      if (localo != null) {
        localo.commit();
      }
    }
    if (this.wx != null) {
      this.wx.onTabChanged(paramString);
    }
  }
  
  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.wx = paramOnTabChangeListener;
  }
  
  @Deprecated
  public void setup()
  {
    throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.app.FragmentTabHost
 * JD-Core Version:    0.7.0.1
 */