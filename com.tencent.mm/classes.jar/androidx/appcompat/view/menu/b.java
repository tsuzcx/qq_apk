package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class b
  implements o
{
  public h jo;
  protected Context mContext;
  public int mId;
  protected LayoutInflater mInflater;
  protected Context mj;
  protected LayoutInflater mk;
  public o.a ml;
  private int mm;
  private int mn;
  public p mo;
  
  public b(Context paramContext, int paramInt1, int paramInt2)
  {
    this.mj = paramContext;
    this.mk = LayoutInflater.from(paramContext);
    this.mm = paramInt1;
    this.mn = paramInt2;
  }
  
  public void J(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)this.mo;
    if (localViewGroup == null) {}
    label225:
    label231:
    for (;;)
    {
      return;
      int j;
      if (this.jo != null)
      {
        this.jo.dc();
        ArrayList localArrayList = this.jo.db();
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
              ((ViewGroup)this.mo).addView(localView2, i);
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
    for (paramView = (p.a)paramView;; paramView = (p.a)this.mk.inflate(this.mn, paramViewGroup, false))
    {
      a(paramj, paramView);
      return (View)paramView;
    }
  }
  
  public p a(ViewGroup paramViewGroup)
  {
    if (this.mo == null)
    {
      this.mo = ((p)this.mk.inflate(this.mm, paramViewGroup, false));
      this.mo.g(this.jo);
      J(true);
    }
    return this.mo;
  }
  
  public void a(Context paramContext, h paramh)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(this.mContext);
    this.jo = paramh;
  }
  
  public void a(h paramh, boolean paramBoolean)
  {
    if (this.ml != null) {
      this.ml.a(paramh, paramBoolean);
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
    if (this.ml != null) {
      return this.ml.c(paramu);
    }
    return false;
  }
  
  public final void b(o.a parama)
  {
    this.ml = parama;
  }
  
  public boolean b(j paramj)
  {
    return true;
  }
  
  public final boolean c(j paramj)
  {
    return false;
  }
  
  public boolean cL()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.view.menu.b
 * JD-Core Version:    0.7.0.1
 */