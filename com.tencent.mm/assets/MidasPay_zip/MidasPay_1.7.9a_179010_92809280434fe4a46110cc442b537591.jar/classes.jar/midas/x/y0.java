package midas.x;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.pay.data.report.APDataReportManager;
import com.tencent.midas.comm.APLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class y0
{
  public Context a = null;
  public ProgressBar b = null;
  public TextView c = null;
  public TextView d = null;
  public ProgressDialog e = null;
  public f f = null;
  public b1 g = null;
  public s0 h = null;
  public c1 i = null;
  public boolean j = false;
  
  public y0(Context paramContext, int paramInt, s0 params0, b1 paramb1)
  {
    this.a = paramContext;
    this.g = paramb1;
    this.h = params0;
    if (paramInt == 1)
    {
      this.e = new x0(this.a, 1, this.h);
      this.e.show();
      this.b = ((ProgressBar)this.e.findViewById(2131099651));
      this.c = ((TextView)this.e.findViewById(2131100039));
      ((TextView)this.e.findViewById(2131100049)).setText("wifi环境升级不耗流量哦");
      APDataReportManager.getInstance().insertData("sdk.update.force.wifi.show", -1);
      return;
    }
    if (paramInt == 2)
    {
      this.e = new x0(this.a, 2, this.h);
      this.e.show();
      this.d = ((TextView)this.e.findViewById(2131099733));
      this.c = ((TextView)this.e.findViewById(2131100039));
      this.d.setText("腾讯充值服务校验中....");
      this.c.setTextSize(25.0F);
      this.c.setText("提示");
      return;
    }
    if (paramInt == 3)
    {
      this.e = new x0(this.a, 1, this.h);
      this.e.show();
      this.b = ((ProgressBar)this.e.findViewById(2131099651));
      this.c = ((TextView)this.e.findViewById(2131100039));
    }
  }
  
  public y0(Context paramContext, ArrayList<q0> paramArrayList, c1 paramc1)
  {
    this.a = paramContext;
    this.i = paramc1;
    this.e = new x0(this.a, 3);
    this.e.show();
    ((LinearLayout)this.e.findViewById(2131100047)).setVisibility(0);
    ((RelativeLayout)this.e.findViewById(2131100048)).setVisibility(8);
    APDataReportManager.getInstance().insertData("sdk.update.force.nowifi.show", -1);
  }
  
  public final void a()
  {
    v0 localv0 = new v0(this.a);
    if (localv0.a())
    {
      localv0.b(0);
      localv0.a(0);
      b();
      this.f.sendEmptyMessage(4);
      return;
    }
    localv0.d();
    this.f.sendEmptyMessage(5);
  }
  
  public void a(final int paramInt)
  {
    this.f = new f(this);
    new Thread(new b(paramInt)).start();
  }
  
  public void a(final ArrayList<q0> paramArrayList)
  {
    this.f = new f(this);
    new Thread(new e(paramArrayList)).start();
  }
  
  public final void a(final ArrayList<q0> paramArrayList, final int paramInt)
  {
    this.b.setMax(this.h.c());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append(this.h.c());
    APLog.i("APMidasForceUndate", localStringBuilder.toString());
    new Thread(new a(paramArrayList, paramInt)).start();
  }
  
  public final void b()
  {
    int k = 0;
    try
    {
      Class localClass1 = Class.forName("com.tencent.midas.plugin.APPluginUtils");
      localClass1.getDeclaredMethod("updateLibExtendNum", new Class[0]).invoke(localClass1, new Object[0]);
      k = 1;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localInvocationTargetException.printStackTrace();
    }
    catch (IllegalAccessException localIllegalAccessException1)
    {
      localIllegalAccessException1.printStackTrace();
    }
    catch (IllegalArgumentException localIllegalArgumentException1)
    {
      localIllegalArgumentException1.printStackTrace();
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      localClassNotFoundException1.printStackTrace();
    }
    if (k == 0) {}
    try
    {
      Class localClass2 = Class.forName("com.tencent.midas.plugin.APPluginUtils");
      Field localField = localClass2.getDeclaredField("e");
      localField.setAccessible(true);
      k = localField.getInt(null);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateLibExtend libextend:");
      localStringBuilder.append(k);
      APLog.d("APMidasForceUpdate", localStringBuilder.toString());
      localField.set(localClass2, Integer.valueOf(k + 1));
      return;
    }
    catch (IllegalAccessException localIllegalAccessException2)
    {
      localIllegalAccessException2.printStackTrace();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException2)
    {
      localIllegalArgumentException2.printStackTrace();
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      localClassNotFoundException2.printStackTrace();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b(ArrayList<q0> paramArrayList)
  {
    this.h.d();
    this.h.b(paramArrayList);
    if (this.h.a() > 0)
    {
      this.b.setMax(this.h.a());
      this.b.setProgress(this.h.b());
      APLog.i("APMidasForceUndate", "resultData=下载未完成，断点续传下载");
      int k = (int)(this.b.getProgress() / this.b.getMax() * 100.0F);
      paramArrayList = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(k);
      localStringBuilder.append("%");
      paramArrayList.setText(localStringBuilder.toString());
      return;
    }
    this.c.setText("0%");
  }
  
  public void b(ArrayList<q0> paramArrayList, int paramInt)
  {
    this.f = new f(this);
    a(paramArrayList, paramInt);
  }
  
  public void c(ArrayList<q0> paramArrayList)
  {
    Button localButton1 = (Button)this.e.findViewById(2131099730);
    final Button localButton2 = (Button)this.e.findViewById(2131099731);
    final TextView localTextView = (TextView)this.e.findViewById(2131099733);
    ((TextView)this.e.findViewById(2131100039)).setText("提示");
    int k = 0;
    int m = 0;
    while (k < paramArrayList.size())
    {
      m += ((q0)paramArrayList.get(k)).b;
      k += 1;
    }
    float f1 = m / 1024.0F;
    paramArrayList = new StringBuilder();
    paramArrayList.append("您的安全支付服务需要升级,要消耗");
    paramArrayList.append(f1);
    paramArrayList.append("KB,为保证安全支付请确认升级!");
    localTextView.setText(paramArrayList.toString());
    localButton1.setOnClickListener(new c(localTextView, localButton2));
    localButton2.setOnClickListener(new d());
  }
  
  public class a
    implements Runnable
  {
    public a(ArrayList paramArrayList, int paramInt) {}
    
    public void run()
    {
      try
      {
        y0.d(y0.this).b(paramArrayList, paramInt, new a());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    
    public class a
      implements b1
    {
      public a() {}
      
      public void a()
      {
        Message localMessage = new Message();
        localMessage.what = 3;
        y0.a(y0.this).sendMessage(localMessage);
      }
      
      public void a(int paramInt)
      {
        Message localMessage = new Message();
        localMessage.what = 1;
        localMessage.getData().putInt("size", paramInt);
        y0.a(y0.this).sendMessage(localMessage);
      }
      
      public void b()
      {
        long l = new v0(y0.b(y0.this)).e();
        Object localObject = APDataReportManager.getInstance();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("datanum=");
        localStringBuilder.append(l);
        ((APDataReportManager)localObject).a("sdk.update.dasize", localStringBuilder.toString());
        localObject = new Message();
        ((Message)localObject).what = 6;
        y0.a(y0.this).sendMessage((Message)localObject);
      }
      
      public void b(int paramInt)
      {
        Message localMessage = new Message();
        localMessage.what = 2;
        y0.a(y0.this).sendMessage(localMessage);
      }
    }
  }
  
  public class b
    implements Runnable
  {
    public b(int paramInt) {}
    
    public void run()
    {
      o0 localo0 = new o0(y0.b(y0.this));
      Object localObject2;
      if (paramInt == 1)
      {
        v0 localv0 = new v0(y0.b(y0.this));
        ArrayList localArrayList2 = new ArrayList();
        localObject2 = new ArrayList();
        Object localObject1 = new ArrayList();
        if (!localv0.a(r0.p().h()))
        {
          localObject1 = r0.p().g();
          APLog.i("APMidasForceUndate", "resultData=强制升级sdcard文件不是全部的升级文件，但是其中文件有损坏");
        }
        if (!localo0.b())
        {
          localo0.a(2);
          localObject2 = localo0.c();
          APLog.i("APMidasForceUndate", "resultData=强制升级sdcard文件不是全部的升级文件，diff时出错");
        }
        int i;
        if (((ArrayList)localObject1).size() > 0)
        {
          i = 0;
          while (i < ((ArrayList)localObject1).size())
          {
            localArrayList2.add(((ArrayList)localObject1).get(i));
            i += 1;
          }
        }
        if (((ArrayList)localObject2).size() > 0)
        {
          i = 0;
          while (i < ((ArrayList)localObject2).size())
          {
            localArrayList2.add(((ArrayList)localObject2).get(i));
            i += 1;
          }
        }
        if (localArrayList2.size() > 0)
        {
          APLog.i("APMidasForceUndate", "resultData=强制升级sdcard文件不是全部的升级文件，再次走网络下载");
          localObject1 = new s0(y0.b(y0.this));
          o0.h = 0;
          ((s0)localObject1).c(localArrayList2);
          ((s0)localObject1).a(localArrayList2, 2);
          ((s0)localObject1).b(localArrayList2, 1, new a());
          return;
        }
        try
        {
          Thread.sleep(500L);
          y0.e(y0.this);
          return;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          return;
        }
      }
      if (!localo0.b())
      {
        localo0.a(2);
        ArrayList localArrayList1 = localo0.c();
        localObject2 = new s0(y0.b(y0.this));
        o0.h = 0;
        if ((localArrayList1 != null) && (localArrayList1.size() > 0))
        {
          ((s0)localObject2).c(localArrayList1);
          ((s0)localObject2).a(localArrayList1, 2);
          ((s0)localObject2).b(localArrayList1, 1, new b());
        }
      }
      else
      {
        try
        {
          Thread.sleep(500L);
        }
        catch (Exception localException2) {}
        try
        {
          localException2.printStackTrace();
          y0.e(y0.this);
          return;
        }
        catch (Exception localException3)
        {
          localException3.printStackTrace();
        }
      }
    }
    
    public class a
      implements b1
    {
      public a() {}
      
      public void a()
      {
        y0.e(y0.this);
      }
      
      public void a(int paramInt) {}
      
      public void b()
      {
        long l = new v0(y0.b(y0.this)).e();
        Object localObject = APDataReportManager.getInstance();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("datanum=");
        localStringBuilder.append(l);
        ((APDataReportManager)localObject).a("sdk.update.dasize", localStringBuilder.toString());
        localObject = new Message();
        ((Message)localObject).what = 6;
        y0.a(y0.this).sendMessage((Message)localObject);
      }
      
      public void b(int paramInt)
      {
        y0.a(y0.this).sendEmptyMessage(5);
      }
    }
    
    public class b
      implements b1
    {
      public b() {}
      
      public void a()
      {
        y0.e(y0.this);
      }
      
      public void a(int paramInt) {}
      
      public void b()
      {
        long l = new v0(y0.b(y0.this)).e();
        Object localObject = APDataReportManager.getInstance();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("datanum=");
        localStringBuilder.append(l);
        ((APDataReportManager)localObject).a("sdk.update.dasize", localStringBuilder.toString());
        localObject = new Message();
        ((Message)localObject).what = 6;
        y0.a(y0.this).sendMessage((Message)localObject);
      }
      
      public void b(int paramInt)
      {
        y0.a(y0.this).sendEmptyMessage(5);
      }
    }
  }
  
  public class c
    implements View.OnClickListener
  {
    public c(TextView paramTextView, Button paramButton) {}
    
    public void onClick(View paramView)
    {
      if (!y0.f(y0.this))
      {
        localTextView.setText("若停止升级,将暂时无法充值!");
        localButton2.setText("继续升级");
        y0.a(y0.this, true);
      }
      else
      {
        y0.g(y0.this).dismiss();
        y0.h(y0.this).a(2);
      }
      APDataReportManager.getInstance().insertData("sdk.update.force.cancle", -1);
    }
  }
  
  public class d
    implements View.OnClickListener
  {
    public d() {}
    
    public void onClick(View paramView)
    {
      y0.h(y0.this).a(1);
      y0.g(y0.this).dismiss();
      APDataReportManager.getInstance().insertData("sdk.update.force.continue", -1);
    }
  }
  
  public class e
    implements Runnable
  {
    public e(ArrayList paramArrayList) {}
    
    public void run()
    {
      v0 localv0 = new v0(y0.b(y0.this));
      if (localv0.a(paramArrayList))
      {
        APLog.i("APMidasForceUpdate", "resultData=强制升级全部走sdcrad成功，文件是完整的");
        localv0.b(1);
        localv0.a(1);
        try
        {
          Thread.sleep(3000L);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        y0.i(y0.this);
        y0.a(y0.this).sendEmptyMessage(4);
        return;
      }
      APLog.i("APMidasForceUpdate", "resultData=强制升级全部走sdcrad不成功，sdcrad文件是不完整的");
      y0.a(y0.this).sendEmptyMessage(5);
    }
  }
  
  public static class f
    extends Handler
  {
    public final WeakReference<y0> a;
    
    public f(y0 paramy0)
    {
      this.a = new WeakReference(paramy0);
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      Object localObject = (y0)this.a.get();
      if (localObject == null) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      case 6: 
        y0.g((y0)localObject).dismiss();
        y0.c((y0)localObject).b();
        return;
      case 5: 
        y0.g((y0)localObject).dismiss();
        y0.c((y0)localObject).b(1);
        return;
      case 4: 
        y0.g((y0)localObject).dismiss();
        Toast.makeText(y0.b((y0)localObject).getApplicationContext(), "安全支付服务校验成功，请重新进入支付", 0).show();
        y0.c((y0)localObject).a();
        return;
      case 3: 
        y0.g((y0)localObject).dismiss();
        y0.c((y0)localObject).a();
        return;
      case 2: 
        y0.g((y0)localObject).dismiss();
        Toast.makeText(y0.b((y0)localObject).getApplicationContext(), "网络异常，请检查网络，重新下载", 0).show();
        y0.c((y0)localObject).b(2);
        return;
      }
      y0.j((y0)localObject).setProgress(paramMessage.getData().getInt("size"));
      int i = (int)(y0.j((y0)localObject).getProgress() / y0.j((y0)localObject).getMax() * 100.0F);
      paramMessage = y0.k((y0)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("%");
      paramMessage.setText(((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.y0
 * JD-Core Version:    0.7.0.1
 */