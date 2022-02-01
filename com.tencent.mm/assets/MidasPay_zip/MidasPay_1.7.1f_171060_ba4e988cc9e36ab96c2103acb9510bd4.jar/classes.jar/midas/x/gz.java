package midas.x;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ScrollView;
import com.pay.api.request.APBaseRequest;
import com.pay.ui.common.APGridView;
import com.tencent.midas.comm.APLog;

public class gz
  extends BaseAdapter
{
  private String[] a;
  private ec b = null;
  private gv c = null;
  
  public gz(ScrollView paramScrollView, APGridView paramAPGridView, Activity paramActivity, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3)
  {
    this.a = paramArrayOfString1;
    this.b = ed.b().n();
    if (this.b.a.saveType == 0)
    {
      this.c = new gw(paramScrollView, paramAPGridView, paramActivity, paramArrayOfString1, paramArrayOfString2, paramArrayOfString3);
      return;
    }
    if (this.b.a.saveType == 4)
    {
      this.c = new gx(paramScrollView, paramAPGridView, paramActivity, paramArrayOfString1, paramArrayOfString2, paramArrayOfString3);
      return;
    }
    if (this.b.a.saveType == 5)
    {
      this.c = new gy(paramScrollView, paramAPGridView, paramActivity, paramArrayOfString1, paramArrayOfString2, paramArrayOfString3);
      return;
    }
    paramScrollView = new StringBuilder();
    paramScrollView.append("saveType:");
    paramScrollView.append(this.b.a.saveType);
    APLog.i("APPayListValueAdapter", paramScrollView.toString());
  }
  
  public int getCount()
  {
    if (this.c != null) {
      return this.c.a();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt >= this.a.length) {
      return null;
    }
    return this.a[paramInt];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.gz
 * JD-Core Version:    0.7.0.1
 */