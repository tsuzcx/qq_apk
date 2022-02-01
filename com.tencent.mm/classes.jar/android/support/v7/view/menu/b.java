package android.support.v7.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class b
  implements o
{
  public h aaD;
  protected Context aeR;
  protected LayoutInflater aeS;
  public o.a aeT;
  private int aeU;
  private int aeV;
  public p aeW;
  protected Context mContext;
  public int mId;
  protected LayoutInflater mInflater;
  
  public b(Context paramContext)
  {
    this.aeR = paramContext;
    this.aeS = LayoutInflater.from(paramContext);
    this.aeU = 2131492894;
    this.aeV = 2131492893;
  }
  
  public View a(j paramj, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof p.a)) {}
    for (paramView = (p.a)paramView;; paramView = (p.a)this.aeS.inflate(this.aeV, paramViewGroup, false))
    {
      a(paramj, paramView);
      return (View)paramView;
    }
  }
  
  public void a(Context paramContext, h paramh)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(this.mContext);
    this.aaD = paramh;
  }
  
  public void a(h paramh, boolean paramBoolean)
  {
    if (this.aeT != null) {
      this.aeT.a(paramh, paramBoolean);
    }
  }
  
  public abstract void a(j paramj, p.a parama);
  
  public final void a(o.a parama)
  {
    this.aeT = parama;
  }
  
  public boolean a(u paramu)
  {
    if (this.aeT != null) {
      return this.aeT.d(paramu);
    }
    return false;
  }
  
  public final boolean b(j paramj)
  {
    return false;
  }
  
  public boolean bD()
  {
    return false;
  }
  
  public p c(ViewGroup paramViewGroup)
  {
    if (this.aeW == null)
    {
      this.aeW = ((p)this.aeS.inflate(this.aeU, paramViewGroup, false));
      this.aeW.a(this.aaD);
      p(true);
    }
    return this.aeW;
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
    ViewGroup localViewGroup = (ViewGroup)this.aeW;
    if (localViewGroup == null) {}
    label225:
    label231:
    for (;;)
    {
      return;
      int j;
      if (this.aaD != null)
      {
        this.aaD.hW();
        ArrayList localArrayList = this.aaD.hV();
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
              ((ViewGroup)this.aeW).addView(localView2, i);
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