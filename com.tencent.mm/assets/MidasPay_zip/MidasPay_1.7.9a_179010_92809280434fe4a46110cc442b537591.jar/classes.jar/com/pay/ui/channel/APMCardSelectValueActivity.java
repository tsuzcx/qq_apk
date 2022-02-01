package com.pay.ui.channel;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.plugin.APPluginActivity;
import java.util.ArrayList;
import java.util.List;
import midas.x.a;
import midas.x.c6;
import midas.x.d5;
import midas.x.e5;
import midas.x.h5;
import midas.x.o4;
import midas.x.p4;
import midas.x.z5;

public class APMCardSelectValueActivity
  extends APActivity
{
  public AP3PointsLoading d;
  public int e;
  public Button f;
  public ImageButton g;
  public List<RadioButton> h;
  public h5 i = new a();
  
  public final void a(boolean paramBoolean)
  {
    if (this.h.size() > 0)
    {
      int j = 0;
      while (j < this.h.size())
      {
        ((RadioButton)this.h.get(j)).setEnabled(paramBoolean);
        j += 1;
      }
    }
  }
  
  public void f()
  {
    com.pay.paychannel.mcard.APMcardChannel.q = String.valueOf(this.e * 100);
    String str = p4.p().e().f.e;
    APRecoChannelActivity.h = true;
    e5.h().a(this, str, this.i, null);
  }
  
  public final void g()
  {
    final int[] arrayOfInt = new int[5];
    int[] tmp7_5 = arrayOfInt;
    tmp7_5[0] = 10;
    int[] tmp12_7 = tmp7_5;
    tmp12_7[1] = 20;
    int[] tmp17_12 = tmp12_7;
    tmp17_12[2] = 30;
    int[] tmp22_17 = tmp17_12;
    tmp22_17[3] = 50;
    int[] tmp27_22 = tmp22_17;
    tmp27_22[4] = 100;
    tmp27_22;
    int m = 0;
    this.e = arrayOfInt[0];
    this.h = new ArrayList();
    int j = 1;
    int k;
    RadioButton localRadioButton;
    for (;;)
    {
      k = m;
      if (j > 5) {
        break;
      }
      localRadioButton = (RadioButton)findViewById(2131099787 + j);
      this.h.add(localRadioButton);
      j += 1;
    }
    while (k < 5)
    {
      localRadioButton = (RadioButton)this.h.get(k);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(arrayOfInt[k]));
      localStringBuilder.append(" 元");
      localRadioButton.setText(localStringBuilder.toString());
      ((RadioButton)this.h.get(k)).setOnClickListener(new d(arrayOfInt));
      k += 1;
    }
  }
  
  public void h()
  {
    this.d = ((AP3PointsLoading)findViewById(2131099895));
    this.f = ((Button)findViewById(2131099726));
    this.f.setOnClickListener(new b());
    this.g = ((ImageButton)findViewById(2131099802));
    this.g.setOnClickListener(new c());
    g();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((c6.s0().i()) && (a.r().d != null))
    {
      this.a = this.c.b.saveType;
      setContentView(2131165219);
      h();
      a.r().f = true;
      return;
    }
    finish();
    APUICommonMethod.a(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (APRecoChannelActivity.f()) {
        return true;
      }
      APDataReportManager.getInstance().insertData("sdk.mcard.selectvalue.keyback", this.a, p4.p().e().f.k, p4.p().e().f.e, null);
      finish();
      APUICommonMethod.a(this);
      overridePendingTransition(z5.a(this, "unipay_anim_in_from_left"), z5.a(this, "unipay_anim_out_to_right"));
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    APDataReportManager.getInstance().insertData("sdk.mcard.selectvalue.show", this.a, p4.p().e().f.k, p4.p().e().f.e, null);
    super.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public class a
    implements h5
  {
    public a() {}
    
    public void a()
    {
      APRecoChannelActivity.h = false;
      APMCardSelectValueActivity.this.d.d();
      APMCardSelectValueActivity.this.d.setVisibility(8);
      APMCardSelectValueActivity.a(APMCardSelectValueActivity.this).setVisibility(0);
      APMCardSelectValueActivity.b(APMCardSelectValueActivity.this).setEnabled(true);
      APMCardSelectValueActivity.a(APMCardSelectValueActivity.this, true);
    }
    
    public void a(int paramInt)
    {
      APRecoChannelActivity.h = false;
      APMCardSelectValueActivity.this.d.d();
      APMCardSelectValueActivity.this.d.setVisibility(8);
      APMCardSelectValueActivity.a(APMCardSelectValueActivity.this).setVisibility(0);
      APMCardSelectValueActivity.b(APMCardSelectValueActivity.this).setEnabled(true);
      APMCardSelectValueActivity.a(APMCardSelectValueActivity.this, true);
    }
    
    public void a(int paramInt, String paramString1, String paramString2)
    {
      APRecoChannelActivity.h = false;
      APMCardSelectValueActivity.this.d.d();
      APMCardSelectValueActivity.this.d.setVisibility(8);
      APMCardSelectValueActivity.a(APMCardSelectValueActivity.this).setVisibility(0);
      APMCardSelectValueActivity.b(APMCardSelectValueActivity.this).setEnabled(true);
      APMCardSelectValueActivity.a(APMCardSelectValueActivity.this, true);
    }
  }
  
  public class b
    implements View.OnClickListener
  {
    public b() {}
    
    public void onClick(View paramView)
    {
      APMCardSelectValueActivity.a(APMCardSelectValueActivity.this).setVisibility(8);
      APMCardSelectValueActivity.this.d.setVisibility(0);
      APMCardSelectValueActivity.this.d.c();
      APMCardSelectValueActivity.b(APMCardSelectValueActivity.this).setEnabled(false);
      APMCardSelectValueActivity.a(APMCardSelectValueActivity.this, false);
      APMCardSelectValueActivity.this.f();
    }
  }
  
  public class c
    implements View.OnClickListener
  {
    public c() {}
    
    public void onClick(View paramView)
    {
      if (APRecoChannelActivity.f()) {
        return;
      }
      APDataReportManager.getInstance().insertData("sdk.mcard.selectvalue.back", APMCardSelectValueActivity.c(APMCardSelectValueActivity.this), p4.p().e().f.k, p4.p().e().f.e, null);
      APMCardSelectValueActivity.this.finish();
      APUICommonMethod.a(APMCardSelectValueActivity.this);
    }
  }
  
  public class d
    implements View.OnClickListener
  {
    public d(int[] paramArrayOfInt) {}
    
    public void onClick(View paramView)
    {
      int i = 0;
      while (i < APMCardSelectValueActivity.d(APMCardSelectValueActivity.this).size())
      {
        if (paramView.getId() == ((RadioButton)APMCardSelectValueActivity.d(APMCardSelectValueActivity.this).get(i)).getId())
        {
          APMCardSelectValueActivity.a(APMCardSelectValueActivity.this, arrayOfInt[i]);
          APDataReportManager.getInstance().insertData("sdk.mcard.selectvalue.num", APMCardSelectValueActivity.e(APMCardSelectValueActivity.this), p4.p().e().f.k, p4.p().e().f.e, null);
        }
        else
        {
          ((RadioButton)APMCardSelectValueActivity.d(APMCardSelectValueActivity.this).get(i)).setChecked(false);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.channel.APMCardSelectValueActivity
 * JD-Core Version:    0.7.0.1
 */