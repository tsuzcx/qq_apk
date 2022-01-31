package android.support.v7.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class b
  implements o
{
  protected Context Vc;
  protected LayoutInflater Vd;
  private int Ve;
  private int Vf;
  public p Vg;
  public o.a eN;
  public h eq;
  protected Context mContext;
  public int mId;
  protected LayoutInflater mInflater;
  
  public b(Context paramContext)
  {
    this.Vc = paramContext;
    this.Vd = LayoutInflater.from(paramContext);
    this.Ve = 2130968587;
    this.Vf = 2130968586;
  }
  
  public View a(j paramj, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof p.a)) {}
    for (paramView = (p.a)paramView;; paramView = (p.a)this.Vd.inflate(this.Vf, paramViewGroup, false))
    {
      a(paramj, paramView);
      return (View)paramView;
    }
  }
  
  public void a(Context paramContext, h paramh)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(this.mContext);
    this.eq = paramh;
  }
  
  public void a(h paramh, boolean paramBoolean)
  {
    if (this.eN != null) {
      this.eN.a(paramh, paramBoolean);
    }
  }
  
  public abstract void a(j paramj, p.a parama);
  
  public final void a(o.a parama)
  {
    this.eN = parama;
  }
  
  public boolean a(u paramu)
  {
    if (this.eN != null) {
      return this.eN.d(paramu);
    }
    return false;
  }
  
  public boolean aG()
  {
    return false;
  }
  
  public final boolean b(j paramj)
  {
    return false;
  }
  
  protected boolean b(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }
  
  public final boolean c(j paramj)
  {
    return false;
  }
  
  public p e(ViewGroup paramViewGroup)
  {
    if (this.Vg == null)
    {
      this.Vg = ((p)this.Vd.inflate(this.Ve, paramViewGroup, false));
      this.Vg.a(this.eq);
      n(true);
    }
    return this.Vg;
  }
  
  public boolean e(j paramj)
  {
    return true;
  }
  
  public final int getId()
  {
    return this.mId;
  }
  
  public void n(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)this.Vg;
    if (localViewGroup == null) {}
    label225:
    label231:
    for (;;)
    {
      return;
      int j;
      if (this.eq != null)
      {
        this.eq.gd();
        ArrayList localArrayList = this.eq.gb();
        int m = localArrayList.size();
        int k = 0;
        int i = 0;
        j = i;
        if (k < m)
        {
          j localj = (j)localArrayList.get(k);
          if (!e(localj)) {
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
              ((ViewGroup)this.Vg).addView(localView2, i);
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
        if (!b(localViewGroup, j))
        {
          j += 1;
          continue;
          break;
          j = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.b
 * JD-Core Version:    0.7.0.1
 */