package com.pay.ui.common.pickview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
import midas.x.he;

public class APOptionsViewWindow
  extends LinearLayout
  implements View.OnClickListener
{
  he a;
  private View b;
  private View c;
  private View d;
  private a e;
  
  public APOptionsViewWindow(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public APOptionsViewWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public void a(Context paramContext)
  {
    this.b = ((ViewGroup)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131165243, this));
    this.c = this.b.findViewById(2131099650);
    this.c.setTag("submit");
    this.d = this.b.findViewById(2131099649);
    this.d.setTag("cancel");
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.a = new he(this.b.findViewById(2131099694));
  }
  
  public void onClick(View paramView)
  {
    if (((String)paramView.getTag()).equals("cancel"))
    {
      setVisibility(8);
      return;
    }
    if (this.e != null)
    {
      paramView = this.a.a();
      this.e.a(paramView[0], paramView[1], paramView[2]);
    }
    setVisibility(8);
  }
  
  public void setCyclic(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  public void setLabels(String paramString)
  {
    this.a.a(paramString, null, null);
  }
  
  public void setLabels(String paramString1, String paramString2)
  {
    this.a.a(paramString1, paramString2, null);
  }
  
  public void setLabels(String paramString1, String paramString2, String paramString3)
  {
    this.a.a(paramString1, paramString2, paramString3);
  }
  
  public void setOnoptionsSelectListener(a parama)
  {
    this.e = parama;
  }
  
  public void setPicker(ArrayList<String> paramArrayList)
  {
    this.a.a(paramArrayList, null, null, false);
  }
  
  public void setPicker(ArrayList<String> paramArrayList, ArrayList<ArrayList<String>> paramArrayList1, ArrayList<ArrayList<ArrayList<String>>> paramArrayList2, boolean paramBoolean)
  {
    this.a.a(paramArrayList, paramArrayList1, paramArrayList2, paramBoolean);
  }
  
  public void setPicker(ArrayList<String> paramArrayList, ArrayList<ArrayList<String>> paramArrayList1, boolean paramBoolean)
  {
    this.a.a(paramArrayList, paramArrayList1, null, paramBoolean);
  }
  
  public void setSelectOptions(int paramInt)
  {
    this.a.a(paramInt, 0, 0);
  }
  
  public void setSelectOptions(int paramInt1, int paramInt2)
  {
    this.a.a(paramInt1, paramInt2, 0);
  }
  
  public void setSelectOptions(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.a(paramInt1, paramInt2, paramInt3);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.common.pickview.view.APOptionsViewWindow
 * JD-Core Version:    0.7.0.1
 */