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

public class hg
  extends hd
{
  protected ec a = null;
  private Activity b = null;
  private View c = null;
  private APGridView d;
  private String[] e = null;
  private String[] f = null;
  private String[] g = null;
  
  public hg(Activity paramActivity, ec paramec)
  {
    this.b = paramActivity;
    this.a = paramec;
  }
  
  private void e()
  {
    this.e = hc.a().b();
    this.f = hc.a().c();
    this.g = hc.a().e();
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
        int i = hg.a(hg.this).getWidth();
        hg.a(hg.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        if (i >= APUICommonMethod.a(hg.b(hg.this), 600.0F))
        {
          hg.c(hg.this).setNumColumns(2);
          return;
        }
        hg.c(hg.this).setNumColumns(1);
      }
    });
    localObject = new gz((ScrollView)localObject, this.d, this.b, this.e, this.f, this.g);
    this.d.setAdapter((ListAdapter)localObject);
    this.d.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        int i;
        if ((ac.a().c()) && (hg.this.a.a.saveType == 0))
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
          hg.this.a.e.g = String.valueOf(paramAnonymousInt);
        }
        else
        {
          i = hg.this.a.a.saveType;
          if (((i == 4) || (i == 5)) && (fs.a().f() == fs.a.a))
          {
            hg.this.a.e.g = "1";
            i = APTools.g(hg.d(hg.this)[paramAnonymousInt]);
            hg.this.a.b.e = String.valueOf(i);
            ((en)hg.this.a.b).k = hc.a().d()[paramAnonymousInt];
            hg.this.a.b.b = hg.e(hg.this)[paramAnonymousInt];
          }
          else if (paramAnonymousInt < hg.f(hg.this).length)
          {
            hg.this.a.e.g = hg.f(hg.this)[paramAnonymousInt];
          }
        }
        hg.this.d();
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
      byte[] arrayOfByte = fm.a(i);
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
      this.c = this.b.getLayoutInflater().inflate(2131165209, null);
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
    es.a().a(this.b, "", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.hg
 * JD-Core Version:    0.7.0.1
 */