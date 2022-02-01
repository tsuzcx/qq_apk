package midas.x;

import android.view.View;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.common.pickview.APWheelView;
import java.util.ArrayList;

public class i7
{
  public View a;
  public APWheelView b;
  public APWheelView c;
  public APWheelView d;
  public ArrayList<String> e;
  public ArrayList<ArrayList<String>> f;
  public ArrayList<ArrayList<ArrayList<String>>> g;
  
  public i7(View paramView)
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
    this.b.setAdapter(new d7(this.e, i));
    this.b.setCurrentItem(0);
    this.c = ((APWheelView)this.a.findViewById(2131099692));
    paramArrayList = this.f;
    if (paramArrayList != null) {
      this.c.setAdapter(new d7((ArrayList)paramArrayList.get(0)));
    }
    this.c.setCurrentItem(this.b.getCurrentItem());
    this.d = ((APWheelView)this.a.findViewById(2131099693));
    paramArrayList = this.g;
    if (paramArrayList != null) {
      this.d.setAdapter(new d7((ArrayList)((ArrayList)paramArrayList.get(0)).get(0)));
    }
    paramArrayList = this.d;
    paramArrayList.setCurrentItem(paramArrayList.getCurrentItem());
    int i = APUICommonMethod.a(this.a.getContext(), 16.0F);
    this.b.a = i;
    paramArrayList = this.c;
    paramArrayList.a = i;
    this.d.a = i;
    if (this.f == null) {
      paramArrayList.setVisibility(8);
    }
    if (this.g == null) {
      this.d.setVisibility(8);
    }
    paramArrayList = this.b;
    if (paramArrayList != null) {
      paramArrayList.invalidate();
    }
    paramArrayList = this.c;
    if (paramArrayList != null) {
      paramArrayList.invalidate();
    }
    paramArrayList = this.d;
    if (paramArrayList != null) {
      paramArrayList.invalidate();
    }
    paramArrayList = new a();
    b localb = new b();
    if ((paramArrayList1 != null) && (paramBoolean)) {
      this.b.a(paramArrayList);
    }
    if ((paramArrayList2 != null) && (paramBoolean)) {
      this.c.a(localb);
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
  
  public class a
    implements f7
  {
    public a() {}
    
    public void a(APWheelView paramAPWheelView, int paramInt1, int paramInt2)
    {
      if (i7.a(i7.this) != null)
      {
        i7.c(i7.this).setAdapter(new d7((ArrayList)i7.a(i7.this).get(i7.b(i7.this).getCurrentItem())));
        i7.c(i7.this).setCurrentItem(0);
      }
      if (i7.d(i7.this) != null)
      {
        i7.e(i7.this).setAdapter(new d7((ArrayList)((ArrayList)i7.d(i7.this).get(i7.b(i7.this).getCurrentItem())).get(i7.c(i7.this).getCurrentItem())));
        i7.e(i7.this).setCurrentItem(0);
      }
    }
  }
  
  public class b
    implements f7
  {
    public b() {}
    
    public void a(APWheelView paramAPWheelView, int paramInt1, int paramInt2)
    {
      if (i7.d(i7.this) != null)
      {
        i7.e(i7.this).setAdapter(new d7((ArrayList)((ArrayList)i7.d(i7.this).get(i7.b(i7.this).getCurrentItem())).get(i7.c(i7.this).getCurrentItem())));
        i7.e(i7.this).setCurrentItem(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.i7
 * JD-Core Version:    0.7.0.1
 */