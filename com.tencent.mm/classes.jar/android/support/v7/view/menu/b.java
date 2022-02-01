package android.support.v7.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class b
  implements o
{
  public h aaQ;
  protected Context afe;
  protected LayoutInflater aff;
  public o.a afg;
  private int afh;
  private int afi;
  public p afj;
  protected Context mContext;
  public int mId;
  protected LayoutInflater mInflater;
  
  public b(Context paramContext)
  {
    this.afe = paramContext;
    this.aff = LayoutInflater.from(paramContext);
    this.afh = 2131492911;
    this.afi = 2131492910;
  }
  
  public View a(j paramj, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof p.a)) {}
    for (paramView = (p.a)paramView;; paramView = (p.a)this.aff.inflate(this.afi, paramViewGroup, false))
    {
      a(paramj, paramView);
      return (View)paramView;
    }
  }
  
  public void a(Context paramContext, h paramh)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(this.mContext);
    this.aaQ = paramh;
  }
  
  public void a(h paramh, boolean paramBoolean)
  {
    if (this.afg != null) {
      this.afg.a(paramh, paramBoolean);
    }
  }
  
  public abstract void a(j paramj, p.a parama);
  
  public final void a(o.a parama)
  {
    this.afg = parama;
  }
  
  public boolean a(u paramu)
  {
    if (this.afg != null) {
      return this.afg.d(paramu);
    }
    return false;
  }
  
  public final boolean b(j paramj)
  {
    return false;
  }
  
  public boolean bF()
  {
    return false;
  }
  
  public p c(ViewGroup paramViewGroup)
  {
    if (this.afj == null)
    {
      this.afj = ((p)this.aff.inflate(this.afh, paramViewGroup, false));
      this.afj.a(this.aaQ);
      p(true);
    }
    return this.afj;
  }
  
  public final boolean c(j paramj)
  {
    return false;
  }
  
  protected boolean c(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }
  
  public boolean e(j paramj)
  {
    return true;
  }
  
  public final int getId()
  {
    return this.mId;
  }
  
  public void p(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)this.afj;
    if (localViewGroup == null) {}
    label225:
    label231:
    for (;;)
    {
      return;
      int j;
      if (this.aaQ != null)
      {
        this.aaQ.ig();
        ArrayList localArrayList = this.aaQ.jdMethod_if();
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
              ((ViewGroup)this.afj).addView(localView2, i);
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
        if (!c(localViewGroup, j))
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