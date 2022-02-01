package midas.x;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ScrollView;
import com.pay.api.request.APBaseRequest;
import com.pay.ui.common.APGridView;
import com.tencent.midas.comm.APLog;

public class o7
  extends BaseAdapter
{
  public String[] a;
  public o4 b = null;
  public k7 c = null;
  
  public o7(ScrollView paramScrollView, APGridView paramAPGridView, Activity paramActivity, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3)
  {
    this.a = paramArrayOfString1;
    this.b = p4.p().e();
    int i = this.b.b.saveType;
    if (i == 0)
    {
      this.c = new l7(paramScrollView, paramAPGridView, paramActivity, paramArrayOfString1, paramArrayOfString2, paramArrayOfString3);
      return;
    }
    if (i == 4)
    {
      this.c = new m7(paramScrollView, paramAPGridView, paramActivity, paramArrayOfString1, paramArrayOfString2, paramArrayOfString3);
      return;
    }
    if (i == 5)
    {
      this.c = new n7(paramScrollView, paramAPGridView, paramActivity, paramArrayOfString1, paramArrayOfString2, paramArrayOfString3);
      return;
    }
    paramScrollView = new StringBuilder();
    paramScrollView.append("saveType:");
    paramScrollView.append(this.b.b.saveType);
    APLog.i("APPayListValueAdapter", paramScrollView.toString());
  }
  
  public int getCount()
  {
    k7 localk7 = this.c;
    if (localk7 != null) {
      return localk7.a();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    String[] arrayOfString = this.a;
    if (paramInt >= arrayOfString.length) {
      return null;
    }
    return arrayOfString[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.c.a(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      paramViewGroup = this.c.a(paramInt, paramView, paramViewGroup);
      return paramViewGroup;
    }
    catch (Exception paramViewGroup)
    {
      APLog.w("payList_getView_err", paramViewGroup.toString());
    }
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return super.getViewTypeCount();
  }
  
  public boolean isEnabled(int paramInt)
  {
    return this.c.b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.o7
 * JD-Core Version:    0.7.0.1
 */