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

public class ax
{
  private Context a = null;
  private ProgressBar b = null;
  private TextView c = null;
  private TextView d = null;
  private ProgressDialog e = null;
  private a f = null;
  private ba g = null;
  private ar h = null;
  private bb i = null;
  private boolean j = false;
  
  public ax(Context paramContext, int paramInt, ar paramar, ba paramba)
  {
    this.a = paramContext;
    this.g = paramba;
    this.h = paramar;
    if (paramInt == 1)
    {
      this.e = new aw(this.a, 1, this.h);
      this.e.show();
      this.b = ((ProgressBar)this.e.findViewById(2131099651));
      this.c = ((TextView)this.e.findViewById(2131100039));
      ((TextView)this.e.findViewById(2131100049)).setText("wifi环境升级不耗流量哦");
      APDataReportManager.getInstance().insertData("sdk.update.force.wifi.show", -1);
      return;
    }
    if (paramInt == 2)
    {
      this.e = new aw(this.a, 2, this.h);
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
      this.e = new aw(this.a, 1, this.h);
      this.e.show();
      this.b = ((ProgressBar)this.e.findViewById(2131099651));
      this.c = ((TextView)this.e.findViewById(2131100039));
    }
  }
  
  public ax(Context paramContext, ArrayList<ap> paramArrayList, bb parambb)
  {
    this.a = paramContext;
    this.i = parambb;
    this.e = new aw(this.a, 3);
    this.e.show();
    ((LinearLayout)this.e.findViewById(2131100047)).setVisibility(0);
    ((RelativeLayout)this.e.findViewById(2131100048)).setVisibility(8);
    APDataReportManager.getInstance().insertData("sdk.update.force.nowifi.show", -1);
  }
  
  private void a()
  {
    au localau = new au(this.a);
    if (localau.g())
    {
      localau.a(0);
      localau.b(0);
      b();
      this.f.sendEmptyMessage(4);
      return;
    }
    localau.f();
    this.f.sendEmptyMessage(5);
  }
  
  private void b()
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
  
  private void b(final ArrayList<ap> paramArrayList, final int paramInt)
  {
    this.b.setMax(this.h.b());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append(this.h.b());
    APLog.i("APMidasForceUndate", localStringBuilder.toString());
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          ax.c(ax.this).b(paramArrayList, paramInt, new ba()
          {
            public void a()
            {
              Message localMessage = new Message();
              localMessage.what = 3;
              ax.a(ax.this).sendMessage(localMessage);
            }
            
            public void a(int paramAnonymous2Int)
            {
              Message localMessage = new Message();
              localMessage.what = 1;
              localMessage.getData().putInt("size", paramAnonymous2Int);
              ax.a(ax.this).sendMessage(localMessage);
            }
            
            public void b()
            {
              long l = new au(ax.b(ax.this)).c();
              Object localObject = APDataReportManager.getInstance();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("datanum=");
              localStringBuilder.append(l);
              ((APDataReportManager)localObject).a("sdk.update.dasize", localStringBuilder.toString());
              localObject = new Message();
              ((Message)localObject).what = 6;
              ax.a(ax.this).sendMessage((Message)localObject);
            }
            
            public void b(int paramAnonymous2Int)
            {
              Message localMessage = new Message();
              localMessage.what = 2;
              ax.a(ax.this).sendMessage(localMessage);
            }
          });
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }).start();
  }
  
  public void a(final int paramInt)
  {
    this.f = new a(this);
    new Thread(new Runnable()
    {
      public void run()
      {
        an localan = new an(ax.b(ax.this));
        Object localObject2;
        if (paramInt == 1)
        {
          au localau = new au(ax.b(ax.this));
          ArrayList localArrayList2 = new ArrayList();
          localObject2 = new ArrayList();
          Object localObject1 = new ArrayList();
          if (!localau.b(aq.a().l()))
          {
            localObject1 = aq.a().j();
            APLog.i("APMidasForceUndate", "resultData=强制升级sdcard文件不是全部的升级文件，但是其中文件有损坏");
          }
          if (!localan.a())
          {
            localan.a(2);
            localObject2 = localan.b();
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
            localObject1 = new ar(ax.b(ax.this));
            an.a = 0;
            ((ar)localObject1).b(localArrayList2);
            ((ar)localObject1).b(localArrayList2, 2);
            ((ar)localObject1).b(localArrayList2, 1, new ba()
            {
              public void a()
              {
                ax.d(ax.this);
              }
              
              public void a(int paramAnonymous2Int) {}
              
              public void b()
              {
                long l = new au(ax.b(ax.this)).c();
                Object localObject = APDataReportManager.getInstance();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("datanum=");
                localStringBuilder.append(l);
                ((APDataReportManager)localObject).a("sdk.update.dasize", localStringBuilder.toString());
                localObject = new Message();
                ((Message)localObject).what = 6;
                ax.a(ax.this).sendMessage((Message)localObject);
              }
              
              public void b(int paramAnonymous2Int)
              {
                ax.a(ax.this).sendEmptyMessage(5);
              }
            });
            return;
          }
          try
          {
            Thread.sleep(500L);
            ax.d(ax.this);
            return;
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            return;
          }
        }
        if (!localan.a())
        {
          localan.a(2);
          ArrayList localArrayList1 = localan.b();
          localObject2 = new ar(ax.b(ax.this));
          an.a = 0;
          if ((localArrayList1 != null) && (localArrayList1.size() > 0))
          {
            ((ar)localObject2).b(localArrayList1);
            ((ar)localObject2).b(localArrayList1, 2);
            ((ar)localObject2).b(localArrayList1, 1, new ba()
            {
              public void a()
              {
                ax.d(ax.this);
              }
              
              public void a(int paramAnonymous2Int) {}
              
              public void b()
              {
                long l = new au(ax.b(ax.this)).c();
                Object localObject = APDataReportManager.getInstance();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("datanum=");
                localStringBuilder.append(l);
                ((APDataReportManager)localObject).a("sdk.update.dasize", localStringBuilder.toString());
                localObject = new Message();
                ((Message)localObject).what = 6;
                ax.a(ax.this).sendMessage((Message)localObject);
              }
              
              public void b(int paramAnonymous2Int)
              {
                ax.a(ax.this).sendEmptyMessage(5);
              }
            });
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
            ax.d(ax.this);
            return;
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
          }
        }
      }
    }).start();
  }
  
  public void a(ArrayList<ap> paramArrayList)
  {
    this.h.d();
    this.h.a(paramArrayList);
    if (this.h.a() > 0)
    {
      this.b.setMax(this.h.a());
      this.b.setProgress(this.h.c());
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
  
  public void a(ArrayList<ap> paramArrayList, int paramInt)
  {
    this.f = new a(this);
    b(paramArrayList, paramInt);
  }
  
  public void b(ArrayList<ap> paramArrayList)
  {
    Button localButton1 = (Button)this.e.findViewById(2131099730);
    final Button localButton2 = (Button)this.e.findViewById(2131099731);
    final TextView localTextView = (TextView)this.e.findViewById(2131099733);
    ((TextView)this.e.findViewById(2131100039)).setText("提示");
    int k = 0;
    int m = 0;
    while (k < paramArrayList.size())
    {
      m += ((ap)paramArrayList.get(k)).b;
      k += 1;
    }
    float f1 = m / 1024.0F;
    paramArrayList = new StringBuilder();
    paramArrayList.append("您的安全支付服务需要升级,要消耗");
    paramArrayList.append(f1);
    paramArrayList.append("KB,为保证安全支付请确认升级!");
    localTextView.setText(paramArrayList.toString());
    localButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!ax.e(ax.this))
        {
          localTextView.setText("若停止升级,将暂时无法充值!");
          localButton2.setText("继续升级");
          ax.a(ax.this, true);
        }
        else
        {
          ax.f(ax.this).dismiss();
          ax.g(ax.this).a(2);
        }
        APDataReportManager.getInstance().insertData("sdk.update.force.cancle", -1);
      }
    });
    localButton2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ax.g(ax.this).a(1);
        ax.f(ax.this).dismiss();
        APDataReportManager.getInstance().insertData("sdk.update.force.continue", -1);
      }
    });
  }
  
  public void c(final ArrayList<ap> paramArrayList)
  {
    this.f = new a(this);
    new Thread(new Runnable()
    {
      public void run()
      {
        au localau = new au(ax.b(ax.this));
        if (localau.b(paramArrayList))
        {
          APLog.i("APMidasForceUpdate", "resultData=强制升级全部走sdcrad成功，文件是完整的");
          localau.a(1);
          localau.b(1);
          try
          {
            Thread.sleep(3000L);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          ax.h(ax.this);
          ax.a(ax.this).sendEmptyMessage(4);
          return;
        }
        APLog.i("APMidasForceUpdate", "resultData=强制升级全部走sdcrad不成功，sdcrad文件是不完整的");
        ax.a(ax.this).sendEmptyMessage(5);
      }
    }).start();
  }
  
  static class a
    extends Handler
  {
    private final WeakReference<ax> a;
    
    public a(ax paramax)
    {
      this.a = new WeakReference(paramax);
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      Object localObject = (ax)this.a.get();
      if (localObject == null) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      case 6: 
        ax.f((ax)localObject).dismiss();
        ax.k((ax)localObject).b();
        return;
      case 5: 
        ax.f((ax)localObject).dismiss();
        ax.k((ax)localObject).b(1);
        return;
      case 4: 
        ax.f((ax)localObject).dismiss();
        Toast.makeText(ax.b((ax)localObject).getApplicationContext(), "安全支付服务校验成功，请重新进入支付", 0).show();
        ax.k((ax)localObject).a();
        return;
      case 3: 
        ax.f((ax)localObject).dismiss();
        ax.k((ax)localObject).a();
        return;
      case 2: 
        ax.f((ax)localObject).dismiss();
        Toast.makeText(ax.b((ax)localObject).getApplicationContext(), "网络异常，请检查网络，重新下载", 0).show();
        ax.k((ax)localObject).b(2);
        return;
      }
      ax.i((ax)localObject).setProgress(paramMessage.getData().getInt("size"));
      int i = (int)(ax.i((ax)localObject).getProgress() / ax.i((ax)localObject).getMax() * 100.0F);
      paramMessage = ax.j((ax)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("%");
      paramMessage.setText(((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ax
 * JD-Core Version:    0.7.0.1
 */