package android.support.v7.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class b
  implements o
{
  protected LayoutInflater Lu;
  public Context Ur;
  protected LayoutInflater Us;
  private int Ut;
  private int Uu;
  public p Uv;
  public o.a dL;
  public h dm;
  public Context mContext;
  public int mId;
  
  public b(Context paramContext, int paramInt1, int paramInt2)
  {
    this.Ur = paramContext;
    this.Us = LayoutInflater.from(paramContext);
    this.Ut = paramInt1;
    this.Uu = paramInt2;
  }
  
  public boolean V()
  {
    return false;
  }
  
  public View a(j paramj, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof p.a)) {}
    for (paramView = (p.a)paramView;; paramView = (p.a)this.Us.inflate(this.Uu, paramViewGroup, false))
    {
      a(paramj, paramView);
      return (View)paramView;
    }
  }
  
  public void a(Context paramContext, h paramh)
  {
    this.mContext = paramContext;
    this.Lu = LayoutInflater.from(this.mContext);
    this.dm = paramh;
  }
  
  public void a(h paramh, boolean paramBoolean)
  {
    if (this.dL != null) {
      this.dL.a(paramh, paramBoolean);
    }
  }
  
  public abstract void a(j paramj, p.a parama);
  
  public final void a(o.a parama)
  {
    this.dL = parama;
  }
  
  public boolean a(u paramu)
  {
    if (this.dL != null) {
      return this.dL.d(paramu);
    }
    return false;
  }
  
  public final boolean b(j paramj)
  {
    return false;
  }
  
  public final boolean c(j paramj)
  {
    return false;
  }
  
  public boolean c(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }
  
  public boolean e(j paramj)
  {
    return true;
  }
  
  public p g(ViewGroup paramViewGroup)
  {
    if (this.Uv == null)
    {
      this.Uv = ((p)this.Us.inflate(this.Ut, paramViewGroup, false));
      this.Uv.a(this.dm);
      o(true);
    }
    return this.Uv;
  }
  
  public final int getId()
  {
    return this.mId;
  }
  
  public void o(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)this.Uv;
    if (localViewGroup == null) {}
    label225:
    label231:
    for (;;)
    {
      return;
      int j;
      if (this.dm != null)
      {
        this.dm.fm();
        ArrayList localArrayList = this.dm.fl();
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
              ((ViewGroup)this.Uv).addView(localView2, i);
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