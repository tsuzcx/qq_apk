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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;
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

public class hr
  extends ho
{
  protected el a = null;
  private Activity b = null;
  private View c = null;
  private APGridView d;
  private String[] e = null;
  private String[] f = null;
  private String[] g = null;
  
  public hr(Activity paramActivity, el paramel)
  {
    this.b = paramActivity;
    this.a = paramel;
  }
  
  private void e()
  {
    this.e = hn.a().b();
    this.f = hn.a().c();
    this.g = hn.a().e();
    h();
    g();
    f();
  }
  
  private void f()
  {
    Object localObject = (ScrollView)this.c.findViewById(2131099796);
    this.d = ((APGridView)this.c.findViewById(2131099795));
    this.c.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        int i = hr.a(hr.this).getWidth();
        hr.a(hr.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        if (i >= APUICommonMethod.a(hr.b(hr.this), 600.0F))
        {
          hr.c(hr.this).setNumColumns(2);
          return;
        }
        hr.c(hr.this).setNumColumns(1);
      }
    });
    localObject = new hk((ScrollView)localObject, this.d, this.b, this.e, this.f, this.g);
    this.d.setAdapter((ListAdapter)localObject);
    this.d.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        int i;
        if ((ac.a().c()) && (hr.this.a.a.saveType == 0))
        {
          i = 0;
          paramAnonymousAdapterView = ac.a().a(paramAnonymousInt);
          paramAnonymousInt = i;
          if (paramAnonymousAdapterView != null) {
            paramAnonymousInt = paramAnonymousAdapterView.a;
          }
          paramAnonymousAdapterView = new StringBuilder();
          paramAnonymousAdapterView.append("list select value");
          paramAnonymousAdapterView.append(paramAnonymousInt);
          APLog.i("APPayGameListNumActivity", paramAnonymousAdapterView.toString());
          hr.this.a.e.g = String.valueOf(paramAnonymousInt);
        }
        else
        {
          i = hr.this.a.a.saveType;
          if (((i == 4) || (i == 5)) && (gc.a().f() == gc.a.a))
          {
            hr.this.a.e.g = "1";
            i = APTools.g(hr.d(hr.this)[paramAnonymousInt]);
            hr.this.a.b.e = String.valueOf(i);
            ((ew)hr.this.a.b).k = hn.a().d()[paramAnonymousInt];
            hr.this.a.b.b = hr.e(hr.this)[paramAnonymousInt];
          }
          else if (paramAnonymousInt < hr.f(hr.this).length)
          {
            hr.this.a.e.g = hr.f(hr.this)[paramAnonymousInt];
          }
        }
        hr.this.d();
      }
    });
  }
  
  private void g()
  {
    int i;
    if (this.a.a.saveType == 0) {
      i = ((APGameRequest)this.a.a).gameLogo;
    } else if (this.a.a.saveType == 4) {
      i = ((APMonthRequest)this.a.a).gameLogo;
    } else if (this.a.a.saveType == 1) {
      i = ((APGoodsRequest)this.a.a).gameLogo;
    } else if (this.a.a.saveType == 5) {
      i = ((APSubscribeRequest)this.a.a).gameLogo;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      ImageView localImageView = (ImageView)this.c.findViewById(2131099976);
      byte[] arrayOfByte = fv.a(i);
      localImageView.setImageBitmap(BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length));
    }
  }
  
  private void h()
  {
    if (this.a.a.saveType != 0) {
      return;
    }
    String str = ac.a().e();
    LinearLayout localLinearLayout = (LinearLayout)this.c.findViewById(2131100034);
    APScrollTextView localAPScrollTextView = (APScrollTextView)this.c.findViewById(2131099798);
    if (!TextUtils.isEmpty(str))
    {
      localAPScrollTextView.setText(str);
      localLinearLayout.setVisibility(0);
      return;
    }
    if ((ac.a().d()) && (this.a.d.b))
    {
      localAPScrollTextView.setText(ac.a().c(this.a.b.b));
      localLinearLayout.setVisibility(0);
      return;
    }
    localLinearLayout.setVisibility(8);
  }
  
  public View a()
  {
    try
    {
      this.c = this.b.getLayoutInflater().inflate(2131165210, null);
      e();
      label21:
      return this.c;
    }
    catch (Exception localException)
    {
      break label21;
    }
  }
  
  public boolean a(Context paramContext, int paramInt, KeyEvent paramKeyEvent)
  {
    APDataReportManager.getInstance().insertData("sdk.gamelist.keyback", this.a.a.saveType);
    return super.a(paramContext, paramInt, paramKeyEvent);
  }
  
  public void b()
  {
    super.b();
    APDataReportManager.getInstance().insertData("sdk.gamelist.close", this.a.a.saveType);
  }
  
  public void c()
  {
    super.c();
    APDataReportManager.getInstance().insertData("sdk.gamelist.show", this.a.a.saveType);
  }
  
  public void d()
  {
    if (APTools.j()) {
      return;
    }
    if (this.a.e.g == null) {
      str = "";
    } else {
      str = this.a.e.g;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("a");
    localStringBuilder.append(str);
    String str = localStringBuilder.toString();
    APDataReportManager.getInstance().insertData("sdk.gamelist.click", this.a.a.saveType, null, str, null);
    fb.a().a(this.b, "", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.hr
 * JD-Core Version:    0.7.0.1
 */