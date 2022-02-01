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
import com.tencent.midas.plugin.APPluginActivity;
import midas.x.c7;
import midas.x.m1;

public class APAlertDialog
  extends APActivity
{
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static SpannableString i;
  public static SpannableString j;
  public static SpannableString k;
  public static View l;
  public static c7 m;
  public static c7 n;
  public static c7 o;
  public static c7 p;
  public static SpannableString q;
  public static boolean r = true;
  public AP3PointsLoading d;
  
  public void f()
  {
    try
    {
      e = null;
      f = null;
      g = null;
      h = null;
      i = null;
      j = null;
      k = null;
      l = null;
      m = null;
      n = null;
      o = null;
      p = null;
      q = null;
      f.c();
      finish();
      APUICommonMethod.a(this);
      return;
    }
    catch (Exception localException)
    {
      label64:
      break label64;
    }
    APLog.d("APAlertDialog", "cancel Exception");
  }
  
  public final void g()
  {
    TextView localTextView = (TextView)findViewById(2131099648);
    if (o != null)
    {
      localTextView.setVisibility(0);
      localTextView.setOnClickListener(new a());
      return;
    }
    localTextView.setVisibility(8);
  }
  
  public final void h()
  {
    TextView localTextView = (TextView)findViewById(2131100043);
    Object localObject = q;
    if (localObject != null)
    {
      localTextView.setText((CharSequence)localObject);
      return;
    }
    localObject = f;
    if (localObject != null) {
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  public final void i()
  {
    TextView localTextView = (TextView)findViewById(2131100044);
    Object localObject = i;
    if (localObject != null)
    {
      localTextView.setText((CharSequence)localObject);
      return;
    }
    localObject = e;
    if (localObject != null) {
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  public final void j()
  {
    Button localButton = (Button)findViewById(2131099703);
    Object localObject = k;
    if (localObject != null)
    {
      localButton.setText((CharSequence)localObject);
      localButton.setOnClickListener(new d());
      return;
    }
    localObject = h;
    if (localObject != null)
    {
      localButton.setText((CharSequence)localObject);
      localButton.setOnClickListener(new e());
      return;
    }
    findViewById(2131099703).setVisibility(8);
  }
  
  public final void k()
  {
    Button localButton = (Button)findViewById(2131099705);
    Object localObject = j;
    if (localObject != null)
    {
      localButton.setText((CharSequence)localObject);
      localButton.setOnClickListener(new b());
      return;
    }
    localObject = g;
    if (localObject != null)
    {
      localButton.setText((CharSequence)localObject);
      localButton.setOnClickListener(new c());
      return;
    }
    findViewById(2131099705).setVisibility(8);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    m1.d().a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    f.a(this);
    int i1 = f.d();
    if (i1 != 0)
    {
      if (i1 != 1) {
        return;
      }
      setContentView(2131165229);
      i();
      this.d = ((AP3PointsLoading)findViewById(2131099699));
      this.d.c();
      return;
    }
    setContentView(2131165228);
    k();
    j();
    g();
    i();
    h();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    c7 localc7 = p;
    if (localc7 != null) {
      localc7.a(this, paramInt, paramKeyEvent);
    }
    if (4 == paramKeyEvent.getKeyCode())
    {
      if (r)
      {
        APLog.i("APProgressDialog", "isAllowCancel=true");
        f();
        return false;
      }
      APLog.i("APProgressDialog", "isAllowCancel=false");
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public class a
    implements View.OnClickListener
  {
    public a() {}
    
    public void onClick(View paramView)
    {
      if (APAlertDialog.l() != null) {
        APAlertDialog.l().a(APAlertDialog.this, -1, null);
      }
    }
  }
  
  public class b
    implements View.OnClickListener
  {
    public b() {}
    
    public void onClick(View paramView)
    {
      if (APAlertDialog.m() != null) {
        APAlertDialog.m().a(APAlertDialog.this, -1, null);
      }
    }
  }
  
  public class c
    implements View.OnClickListener
  {
    public c() {}
    
    public void onClick(View paramView)
    {
      if (APAlertDialog.m() != null) {
        APAlertDialog.m().a(APAlertDialog.this, -1, null);
      }
    }
  }
  
  public class d
    implements View.OnClickListener
  {
    public d() {}
    
    public void onClick(View paramView)
    {
      if (APAlertDialog.n() != null) {
        APAlertDialog.n().a(APAlertDialog.this, -2, null);
      }
    }
  }
  
  public class e
    implements View.OnClickListener
  {
    public e() {}
    
    public void onClick(View paramView)
    {
      if (APAlertDialog.n() != null) {
        APAlertDialog.n().a(APAlertDialog.this, -2, null);
      }
    }
  }
  
  public static class f
  {
    public static APAlertDialog a;
    public static Context b;
    public static int c;
    
    public f(Context paramContext)
    {
      APAlertDialog.a(null);
      APAlertDialog.b(true);
      APAlertDialog.b(null);
      APAlertDialog.c(null);
      APAlertDialog.d(null);
      APAlertDialog.e(null);
      APAlertDialog.d(null);
      APAlertDialog.a(null);
      APAlertDialog.b(null);
      APAlertDialog.b(null);
      APAlertDialog.d(null);
      APAlertDialog.a(null);
      APAlertDialog.c(null);
      APAlertDialog.c(null);
      APAlertDialog.a(true);
      b = paramContext;
      c = 0;
    }
    
    public static void a(APAlertDialog paramAPAlertDialog)
    {
      a = paramAPAlertDialog;
    }
    
    public static void b(int paramInt)
    {
      c = paramInt;
    }
    
    public static void c()
    {
      a = null;
      b = null;
    }
    
    public static int d()
    {
      return c;
    }
    
    public f a(int paramInt)
    {
      APAlertDialog.a((String)b.getText(paramInt));
      return this;
    }
    
    public f a(String paramString)
    {
      APAlertDialog.b(paramString);
      return this;
    }
    
    public f a(String paramString, c7 paramc7)
    {
      APAlertDialog.d(paramString);
      APAlertDialog.d(paramc7);
      return this;
    }
    
    public f a(c7 paramc7)
    {
      APAlertDialog.a(paramc7);
      return this;
    }
    
    public f a(boolean paramBoolean)
    {
      APAlertDialog.a(paramBoolean);
      return this;
    }
    
    public void a()
    {
      Object localObject = a;
      if (localObject != null)
      {
        ((APAlertDialog)localObject).f();
        return;
      }
      localObject = APUICommonMethod.c();
      if (localObject != null)
      {
        ((Activity)localObject).finish();
        APUICommonMethod.a((Activity)localObject);
      }
    }
    
    public f b(String paramString)
    {
      APAlertDialog.a(paramString);
      return this;
    }
    
    public f b(String paramString, c7 paramc7)
    {
      APAlertDialog.c(paramString);
      APAlertDialog.b(paramc7);
      return this;
    }
    
    public f b(c7 paramc7)
    {
      APAlertDialog.c(paramc7);
      return this;
    }
    
    public void b()
    {
      try
      {
        if (a != null)
        {
          a.finish();
          APUICommonMethod.a(a);
        }
        Intent localIntent = new Intent(b, APAlertDialog.class);
        b.startActivity(localIntent);
        return;
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.common.APAlertDialog
 * JD-Core Version:    0.7.0.1
 */