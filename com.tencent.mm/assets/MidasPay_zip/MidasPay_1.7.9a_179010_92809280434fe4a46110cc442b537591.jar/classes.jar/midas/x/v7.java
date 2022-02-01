package midas.x;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APGameRequest;
import com.pay.api.request.APGoodsRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APTools;
import com.pay.ui.common.APGridView;
import com.pay.ui.common.APScrollTextView;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;

public class v7
  extends s7
{
  public o4 a = null;
  public Activity b = null;
  public View c = null;
  public APGridView d;
  public String[] e = null;
  public String[] f = null;
  public String[] g = null;
  
  public v7(Activity paramActivity, o4 paramo4)
  {
    this.b = paramActivity;
    this.a = paramo4;
  }
  
  public void a()
  {
    super.a();
    APDataReportManager.getInstance().insertData("sdk.gamelist.close", this.a.b.saveType);
  }
  
  public boolean a(Context paramContext, int paramInt, KeyEvent paramKeyEvent)
  {
    APDataReportManager.getInstance().insertData("sdk.gamelist.keyback", this.a.b.saveType);
    return super.a(paramContext, paramInt, paramKeyEvent);
  }
  
  public View b()
  {
    try
    {
      this.c = this.b.getLayoutInflater().inflate(2131165210, null);
      f();
      label21:
      return this.c;
    }
    catch (Exception localException)
    {
      break label21;
    }
  }
  
  public void c()
  {
    super.c();
    APDataReportManager.getInstance().insertData("sdk.gamelist.show", this.a.b.saveType);
  }
  
  public void d()
  {
    if (APTools.m()) {
      return;
    }
    Object localObject2 = this.a.f.f;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("a");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject2).toString();
    APDataReportManager.getInstance().insertData("sdk.gamelist.click", this.a.b.saveType, null, (String)localObject1, null);
    e5.h().a(this.b, "", null);
  }
  
  public final void e()
  {
    Object localObject = (ScrollView)this.c.findViewById(2131099796);
    this.d = ((APGridView)this.c.findViewById(2131099795));
    this.c.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    localObject = new o7((ScrollView)localObject, this.d, this.b, this.e, this.f, this.g);
    this.d.setAdapter((ListAdapter)localObject);
    this.d.setOnItemClickListener(new b());
  }
  
  public final void f()
  {
    this.e = r7.e().c();
    this.f = r7.e().a();
    this.g = r7.e().b();
    h();
    g();
    e();
  }
  
  public final void g()
  {
    Object localObject = this.a.b;
    int i = ((APBaseRequest)localObject).saveType;
    if (i == 0) {
      i = ((APGameRequest)localObject).gameLogo;
    } else if (i == 4) {
      i = ((APMonthRequest)localObject).gameLogo;
    } else if (i == 1) {
      i = ((APGoodsRequest)localObject).gameLogo;
    } else if (i == 5) {
      i = ((APSubscribeRequest)localObject).gameLogo;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject = (ImageView)this.c.findViewById(2131099976);
      byte[] arrayOfByte = z5.a(i);
      ((ImageView)localObject).setImageBitmap(BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length));
    }
  }
  
  public final void h()
  {
    if (this.a.b.saveType != 0) {
      return;
    }
    String str = d0.i().e();
    LinearLayout localLinearLayout = (LinearLayout)this.c.findViewById(2131100034);
    APScrollTextView localAPScrollTextView = (APScrollTextView)this.c.findViewById(2131099798);
    if (!TextUtils.isEmpty(str))
    {
      localAPScrollTextView.setText(str);
      localLinearLayout.setVisibility(0);
      return;
    }
    if ((d0.i().b()) && (this.a.e.b))
    {
      localAPScrollTextView.setText(d0.i().d(this.a.c.b));
      localLinearLayout.setVisibility(0);
      return;
    }
    localLinearLayout.setVisibility(8);
  }
  
  public class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public a() {}
    
    public void onGlobalLayout()
    {
      int i = v7.a(v7.this).getWidth();
      v7.a(v7.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
      if (i >= APUICommonMethod.a(v7.b(v7.this), 600.0F))
      {
        v7.c(v7.this).setNumColumns(2);
        return;
      }
      v7.c(v7.this).setNumColumns(1);
    }
  }
  
  public class b
    implements AdapterView.OnItemClickListener
  {
    public b() {}
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      int i;
      if ((d0.i().c()) && (v7.this.a.b.saveType == 0))
      {
        i = 0;
        paramAdapterView = d0.i().g(paramInt);
        paramInt = i;
        if (paramAdapterView != null) {
          paramInt = paramAdapterView.a;
        }
        paramAdapterView = new StringBuilder();
        paramAdapterView.append("list select value");
        paramAdapterView.append(paramInt);
        APLog.i("APPayGameListNumActivity", paramAdapterView.toString());
        v7.this.a.f.f = String.valueOf(paramInt);
      }
      else
      {
        i = v7.this.a.b.saveType;
        if (((i == 4) || (i == 5)) && (g6.k().e() == g6.a.a))
        {
          paramAdapterView = v7.this;
          paramAdapterView.a.f.f = "1";
          i = APTools.p(v7.d(paramAdapterView)[paramInt]);
          v7.this.a.c.c = String.valueOf(i);
          ((z4)v7.this.a.c).k = r7.e().d()[paramInt];
          paramAdapterView = v7.this;
          paramAdapterView.a.c.b = v7.e(paramAdapterView)[paramInt];
        }
        else if (paramInt < v7.f(v7.this).length)
        {
          paramAdapterView = v7.this;
          paramAdapterView.a.f.f = v7.f(paramAdapterView)[paramInt];
        }
      }
      v7.this.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.v7
 * JD-Core Version:    0.7.0.1
 */