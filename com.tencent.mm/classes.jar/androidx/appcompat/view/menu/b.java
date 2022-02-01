package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class b
  implements o
{
  public h is;
  protected Context ln;
  protected LayoutInflater lo;
  public o.a lp;
  private int lq;
  private int lr;
  public p ls;
  protected Context mContext;
  public int mId;
  protected LayoutInflater mInflater;
  
  public b(Context paramContext, int paramInt1, int paramInt2)
  {
    this.ln = paramContext;
    this.lo = LayoutInflater.from(paramContext);
    this.lq = paramInt1;
    this.lr = paramInt2;
  }
  
  public void F(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)this.ls;
    if (localViewGroup == null) {}
    label225:
    label231:
    for (;;)
    {
      return;
      int j;
      if (this.is != null)
      {
        this.is.cj();
        ArrayList localArrayList = this.is.ci();
        int m = localArrayList.size();
        int k = 0;
        int i = 0;
        j = i;
        if (k < m)
        {
          j localj = (j)localArrayList.get(k);
          if (!b(localj)) {
            break label225;
          }
          View localView1 = localViewGroup.getChildAt(i);
          if ((localView1 instanceof p.a)) {}
          for (Object localObject = ((p.a)localView1).getItemData();; localObject = null)
          {
            View localView2 = a(localj, localView1, localViewGroup);
            if (localj != localObject)
            {
              localView2.setPressed(false);
              localView2.jumpDrawablesToCurrentState();
            }
            if (localView2 != localView1)
            {
              localObject = (ViewGroup)localView2.getParent();
              if (localObject != null) {
                ((ViewGroup)localObject).removeView(localView2);
              }
              ((ViewGroup)this.ls).addView(localView2, i);
            }
            i += 1;
            k += 1;
            break;
          }
        }
      }
      for (;;)
      {
        if (j >= localViewGroup.getChildCount()) {
          break label231;
        }
        if (!a(localViewGroup, j))
        {
          j += 1;
          continue;
          break;
          j = 0;
        }
      }
    }
  }
  
  public View a(j paramj, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof p.a)) {}
    for (paramView = (p.a)paramView;; paramView = (p.a)this.lo.inflate(this.lr, paramViewGroup, false))
    {
      a(paramj, paramView);
      return (View)paramView;
    }
  }
  
  public p a(ViewGroup paramViewGroup)
  {
    if (this.ls == null)
    {
      this.ls = ((p)this.lo.inflate(this.lq, paramViewGroup, false));
      this.ls.g(this.is);
      F(true);
    }
    return this.ls;
  }
  
  public void a(Context paramContext, h paramh)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(this.mContext);
    this.is = paramh;
  }
  
  public void a(h paramh, boolean paramBoolean)
  {
    if (this.lp != null) {
      this.lp.a(paramh, paramBoolean);
    }
  }
  
  public abstract void a(j paramj, p.a parama);
  
  protected boolean a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }
  
  public boolean a(u paramu)
  {
    if (this.lp != null) {
      return this.lp.c(paramu);
    }
    return false;
  }
  
  public final void b(o.a parama)
  {
    this.lp = parama;
  }
  
  public boolean b(j paramj)
  {
    return true;
  }
  
  public boolean bS()
  {
    return false;
  }
  
  public final boolean c(j paramj)
  {
    return false;
  }
  
  public final boolean d(j paramj)
  {
    return false;
  }
  
  public final int getId()
  {
    return this.mId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.menu.b
 * JD-Core Version:    0.7.0.1
 */