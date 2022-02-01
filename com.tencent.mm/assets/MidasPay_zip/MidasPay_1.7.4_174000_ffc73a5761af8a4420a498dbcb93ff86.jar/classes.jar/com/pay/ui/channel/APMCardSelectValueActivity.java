package com.pay.ui.channel;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import java.util.ArrayList;
import java.util.List;
import midas.x.a;
import midas.x.el;
import midas.x.em;
import midas.x.fa;
import midas.x.fb;
import midas.x.fe;
import midas.x.fv;
import midas.x.fy;

public class APMCardSelectValueActivity
  extends APActivity
{
  protected AP3PointsLoading a;
  fe b = new fe()
  {
    public void a()
    {
      APRecoChannelActivity.b = false;
      APMCardSelectValueActivity.this.a.a();
      APMCardSelectValueActivity.this.a.setVisibility(8);
      APMCardSelectValueActivity.a(APMCardSelectValueActivity.this).setVisibility(0);
      APMCardSelectValueActivity.b(APMCardSelectValueActivity.this).setEnabled(true);
      APMCardSelectValueActivity.a(APMCardSelectValueActivity.this, true);
    }
    
    public void a(int paramAnonymousInt)
    {
      APRecoChannelActivity.b = false;
      APMCardSelectValueActivity.this.a.a();
      APMCardSelectValueActivity.this.a.setVisibility(8);
      APMCardSelectValueActivity.a(APMCardSelectValueActivity.this).setVisibility(0);
      APMCardSelectValueActivity.b(APMCardSelectValueActivity.this).setEnabled(true);
      APMCardSelectValueActivity.a(APMCardSelectValueActivity.this, true);
    }
    
    public void a(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
    {
      APRecoChannelActivity.b = false;
      APMCardSelectValueActivity.this.a.a();
      APMCardSelectValueActivity.this.a.setVisibility(8);
      APMCardSelectValueActivity.a(APMCardSelectValueActivity.this).setVisibility(0);
      APMCardSelectValueActivity.b(APMCardSelectValueActivity.this).setEnabled(true);
      APMCardSelectValueActivity.a(APMCardSelectValueActivity.this, true);
    }
  };
  private int c;
  private Button d;
  private ImageButton e;
  private List<RadioButton> q;
  
  private void a(boolean paramBoolean)
  {
    if (this.q.size() > 0)
    {
      int i = 0;
      while (i < this.q.size())
      {
        ((RadioButton)this.q.get(i)).setEnabled(paramBoolean);
        i += 1;
      }
    }
  }
  
  private void c()
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
    int k = 0;
    this.c = arrayOfInt[0];
    this.q = new ArrayList();
    int i = 1;
    int j;
    RadioButton localRadioButton;
    for (;;)
    {
      j = k;
      if (i > 5) {
        break;
      }
      localRadioButton = (RadioButton)findViewById(2131099787 + i);
      this.q.add(localRadioButton);
      i += 1;
    }
    while (j < 5)
    {
      localRadioButton = (RadioButton)this.q.get(j);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(arrayOfInt[j]));
      localStringBuilder.append(" 元");
      localRadioButton.setText(localStringBuilder.toString());
      ((RadioButton)this.q.get(j)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          int i = 0;
          while (i < APMCardSelectValueActivity.d(APMCardSelectValueActivity.this).size())
          {
            if (paramAnonymousView.getId() == ((RadioButton)APMCardSelectValueActivity.d(APMCardSelectValueActivity.this).get(i)).getId())
            {
              APMCardSelectValueActivity.a(APMCardSelectValueActivity.this, arrayOfInt[i]);
              APDataReportManager.getInstance().insertData("sdk.mcard.selectvalue.num", APMCardSelectValueActivity.e(APMCardSelectValueActivity.this), em.b().n().e.l, em.b().n().e.f, null);
            }
            else
            {
              ((RadioButton)APMCardSelectValueActivity.d(APMCardSelectValueActivity.this).get(i)).setChecked(false);
            }
            i += 1;
          }
        }
      });
      j += 1;
    }
  }
  
  protected void a()
  {
    this.a = ((AP3PointsLoading)findViewById(2131099895));
    this.d = ((Button)findViewById(2131099726));
    this.d.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APMCardSelectValueActivity.a(APMCardSelectValueActivity.this).setVisibility(8);
        APMCardSelectValueActivity.this.a.setVisibility(0);
        APMCardSelectValueActivity.this.a.b();
        APMCardSelectValueActivity.b(APMCardSelectValueActivity.this).setEnabled(false);
        APMCardSelectValueActivity.a(APMCardSelectValueActivity.this, false);
        APMCardSelectValueActivity.this.b();
      }
    });
    this.e = ((ImageButton)findViewById(2131099802));
    this.e.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (APRecoChannelActivity.a()) {
          return;
        }
        APDataReportManager.getInstance().insertData("sdk.mcard.selectvalue.back", APMCardSelectValueActivity.c(APMCardSelectValueActivity.this), em.b().n().e.l, em.b().n().e.f, null);
        APMCardSelectValueActivity.this.finish();
        APUICommonMethod.b(APMCardSelectValueActivity.this);
      }
    });
    c();
  }
  
  protected void b()
  {
    com.pay.paychannel.mcard.APMcardChannel.l = String.valueOf(this.c * 100);
    String str = em.b().n().e.f;
    APRecoChannelActivity.b = true;
    fb.a().a(this, str, this.b, null);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((fy.a().f()) && (a.a().d != null))
    {
      this.f = this.p.a.saveType;
      setContentView(2131165219);
      a();
      a.a().f = true;
      return;
    }
    finish();
    APUICommonMethod.b(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (APRecoChannelActivity.a()) {
        return true;
      }
      APDataReportManager.getInstance().insertData("sdk.mcard.selectvalue.keyback", this.f, em.b().n().e.l, em.b().n().e.f, null);
      finish();
      APUICommonMethod.b(this);
      overridePendingTransition(fv.a(this, "unipay_anim_in_from_left"), fv.a(this, "unipay_anim_out_to_right"));
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    APDataReportManager.getInstance().insertData("sdk.mcard.selectvalue.show", this.f, em.b().n().e.l, em.b().n().e.f, null);
    super.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.channel.APMCardSelectValueActivity
 * JD-Core Version:    0.7.0.1
 */