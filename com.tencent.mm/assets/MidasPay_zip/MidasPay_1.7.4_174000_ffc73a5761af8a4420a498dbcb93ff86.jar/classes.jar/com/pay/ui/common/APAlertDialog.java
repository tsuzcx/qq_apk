package com.pay.ui.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.midas.comm.APLog;
import midas.x.bl;
import midas.x.gy;

public class APAlertDialog
  extends APActivity
{
  private static gy A;
  private static gy B;
  private static SpannableString C;
  private static boolean D = true;
  private static boolean c = true;
  private static String d;
  private static String e;
  private static String q;
  private static String r;
  private static String s;
  private static SpannableString t;
  private static SpannableString u;
  private static SpannableString v;
  private static SpannableString w;
  private static View x;
  private static gy y;
  private static gy z;
  private AP3PointsLoading E;
  Button a;
  Button b;
  
  private void h()
  {
    TextView localTextView = (TextView)findViewById(2131100044);
    if (t != null)
    {
      localTextView.setText(t);
      return;
    }
    if (d != null) {
      localTextView.setText(d);
    }
  }
  
  private void i()
  {
    Object localObject = (TextView)findViewById(2131100043);
    if (C != null)
    {
      ((TextView)localObject).setText(C);
      return;
    }
    if (e != null)
    {
      ((TextView)localObject).setText(e);
      return;
    }
    localObject = x;
  }
  
  private void j()
  {
    TextView localTextView = (TextView)findViewById(2131099648);
    if (A != null)
    {
      localTextView.setVisibility(0);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (APAlertDialog.b() != null) {
            APAlertDialog.b().a(APAlertDialog.this, -1, null);
          }
        }
      });
      return;
    }
    localTextView.setVisibility(8);
  }
  
  private void k()
  {
    Button localButton = (Button)findViewById(2131099705);
    if (u != null)
    {
      localButton.setText(u);
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (APAlertDialog.c() != null) {
            APAlertDialog.c().a(APAlertDialog.this, -1, null);
          }
        }
      });
      return;
    }
    if (q != null)
    {
      localButton.setText(q);
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (APAlertDialog.c() != null) {
            APAlertDialog.c().a(APAlertDialog.this, -1, null);
          }
        }
      });
      return;
    }
    findViewById(2131099705).setVisibility(8);
  }
  
  private void l()
  {
    Button localButton = (Button)findViewById(2131099703);
    if (v != null)
    {
      localButton.setText(v);
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (APAlertDialog.d() != null) {
            APAlertDialog.d().a(APAlertDialog.this, -2, null);
          }
        }
      });
      return;
    }
    if (r != null)
    {
      localButton.setText(r);
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (APAlertDialog.d() != null) {
            APAlertDialog.d().a(APAlertDialog.this, -2, null);
          }
        }
      });
      return;
    }
    findViewById(2131099703).setVisibility(8);
  }
  
  public void a()
  {
    try
    {
      d = null;
      c = true;
      e = null;
      q = null;
      r = null;
      s = null;
      t = null;
      u = null;
      v = null;
      x = null;
      y = null;
      z = null;
      A = null;
      B = null;
      this.a = null;
      this.b = null;
      C = null;
      a.b();
      finish();
      APUICommonMethod.b(this);
      return;
    }
    catch (Exception localException)
    {
      label82:
      break label82;
    }
    APLog.d("APAlertDialog", "cancel Exception");
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    bl.a().a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a.a(this);
    switch (a.a())
    {
    default: 
      return;
    case 1: 
      setContentView(2131165229);
      h();
      this.E = ((AP3PointsLoading)findViewById(2131099699));
      this.E.b();
      return;
    }
    setContentView(2131165228);
    k();
    l();
    j();
    h();
    i();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (B != null) {
      B.a(this, paramInt, paramKeyEvent);
    }
    if (4 == paramKeyEvent.getKeyCode())
    {
      if (D)
      {
        APLog.i("APProgressDialog", "isAllowCancel=true");
        a();
        return false;
      }
      APLog.i("APProgressDialog", "isAllowCancel=false");
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onStart()
  {
    super.onStart();
  }
  
  public static class a
  {
    static APAlertDialog a;
    static Context b;
    private static int c;
    
    public a(Context paramContext)
    {
      APAlertDialog.a(null);
      APAlertDialog.a(true);
      APAlertDialog.b(null);
      APAlertDialog.c(null);
      APAlertDialog.d(null);
      APAlertDialog.e(null);
      APAlertDialog.a(null);
      APAlertDialog.b(null);
      APAlertDialog.c(null);
      APAlertDialog.a(null);
      APAlertDialog.b(null);
      APAlertDialog.c(null);
      APAlertDialog.d(null);
      APAlertDialog.d(null);
      APAlertDialog.b(true);
      b = paramContext;
      c = 0;
    }
    
    public static int a()
    {
      return c;
    }
    
    public static void a(int paramInt)
    {
      c = paramInt;
    }
    
    public static void a(APAlertDialog paramAPAlertDialog)
    {
      a = paramAPAlertDialog;
    }
    
    public static void b()
    {
      a = null;
      b = null;
    }
    
    public a a(String paramString)
    {
      APAlertDialog.b(paramString);
      return this;
    }
    
    public a a(String paramString, gy paramgy)
    {
      APAlertDialog.c(paramString);
      APAlertDialog.a(paramgy);
      return this;
    }
    
    public a a(gy paramgy)
    {
      APAlertDialog.c(paramgy);
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      APAlertDialog.b(paramBoolean);
      return this;
    }
    
    public a b(int paramInt)
    {
      APAlertDialog.a((String)b.getText(paramInt));
      return this;
    }
    
    public a b(String paramString)
    {
      APAlertDialog.a(paramString);
      return this;
    }
    
    public a b(String paramString, gy paramgy)
    {
      APAlertDialog.d(paramString);
      APAlertDialog.b(paramgy);
      return this;
    }
    
    public a b(gy paramgy)
    {
      APAlertDialog.d(paramgy);
      return this;
    }
    
    public void c()
    {
      try
      {
        if (a != null)
        {
          a.finish();
          APUICommonMethod.b(a);
        }
        Intent localIntent = new Intent(b, APAlertDialog.class);
        b.startActivity(localIntent);
        return;
      }
      catch (Exception localException) {}
    }
    
    public void d()
    {
      if (a != null)
      {
        a.a();
        return;
      }
      Activity localActivity = APUICommonMethod.c();
      if (localActivity != null)
      {
        localActivity.finish();
        APUICommonMethod.b(localActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.common.APAlertDialog
 * JD-Core Version:    0.7.0.1
 */