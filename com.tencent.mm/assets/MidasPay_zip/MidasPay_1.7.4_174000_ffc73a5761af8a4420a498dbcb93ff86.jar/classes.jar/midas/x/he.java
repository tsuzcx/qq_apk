package midas.x;

import android.view.View;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.common.pickview.APWheelView;
import java.util.ArrayList;

public class he
{
  private View a;
  private APWheelView b;
  private APWheelView c;
  private APWheelView d;
  private ArrayList<String> e;
  private ArrayList<ArrayList<String>> f;
  private ArrayList<ArrayList<ArrayList<String>>> g;
  
  public he(View paramView)
  {
    this.a = paramView;
    a(paramView);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.b.setCurrentItem(paramInt1);
    this.c.setCurrentItem(paramInt2);
    this.d.setCurrentItem(paramInt3);
  }
  
  public void a(View paramView)
  {
    this.a = paramView;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 != null) {
      this.b.setLabel(paramString1);
    }
    if (paramString2 != null) {
      this.c.setLabel(paramString2);
    }
    if (paramString3 != null) {
      this.d.setLabel(paramString3);
    }
  }
  
  public void a(ArrayList<String> paramArrayList, ArrayList<ArrayList<String>> paramArrayList1, ArrayList<ArrayList<ArrayList<String>>> paramArrayList2, boolean paramBoolean)
  {
    this.e = paramArrayList;
    this.f = paramArrayList1;
    this.g = paramArrayList2;
    if (this.g == null) {
      i = 8;
    } else {
      i = 4;
    }
    if (this.f == null) {
      i = 12;
    }
    this.b = ((APWheelView)this.a.findViewById(2131099691));
    this.b.setAdapter(new gz(this.e, i));
    this.b.setCurrentItem(0);
    this.c = ((APWheelView)this.a.findViewById(2131099692));
    if (this.f != null) {
      this.c.setAdapter(new gz((ArrayList)this.f.get(0)));
    }
    this.c.setCurrentItem(this.b.getCurrentItem());
    this.d = ((APWheelView)this.a.findViewById(2131099693));
    if (this.g != null) {
      this.d.setAdapter(new gz((ArrayList)((ArrayList)this.g.get(0)).get(0)));
    }
    this.d.setCurrentItem(this.d.getCurrentItem());
    int i = APUICommonMethod.a(this.a.getContext(), 16.0F);
    this.b.a = i;
    this.c.a = i;
    this.d.a = i;
    if (this.f == null) {
      this.c.setVisibility(8);
    }
    if (this.g == null) {
      this.d.setVisibility(8);
    }
    if (this.b != null) {
      this.b.invalidate();
    }
    if (this.c != null) {
      this.c.invalidate();
    }
    if (this.d != null) {
      this.d.invalidate();
    }
    paramArrayList = new hb()
    {
      public void a(APWheelView paramAnonymousAPWheelView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (he.a(he.this) != null)
        {
          he.c(he.this).setAdapter(new gz((ArrayList)he.a(he.this).get(he.b(he.this).getCurrentItem())));
          he.c(he.this).setCurrentItem(0);
        }
        if (he.d(he.this) != null)
        {
          he.e(he.this).setAdapter(new gz((ArrayList)((ArrayList)he.d(he.this).get(he.b(he.this).getCurrentItem())).get(he.c(he.this).getCurrentItem())));
          he.e(he.this).setCurrentItem(0);
        }
      }
    };
    hb local2 = new hb()
    {
      public void a(APWheelView paramAnonymousAPWheelView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (he.d(he.this) != null)
        {
          he.e(he.this).setAdapter(new gz((ArrayList)((ArrayList)he.d(he.this).get(he.b(he.this).getCurrentItem())).get(he.c(he.this).getCurrentItem())));
          he.e(he.this).setCurrentItem(0);
        }
      }
    };
    if ((paramArrayList1 != null) && (paramBoolean)) {
      this.b.a(paramArrayList);
    }
    if ((paramArrayList2 != null) && (paramBoolean)) {
      this.c.a(local2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.setCyclic(paramBoolean);
    this.c.setCyclic(paramBoolean);
    this.d.setCyclic(paramBoolean);
  }
  
  public int[] a()
  {
    return new int[] { this.b.getCurrentItem(), this.c.getCurrentItem(), this.d.getCurrentItem() };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.he
 * JD-Core Version:    0.7.0.1
 */