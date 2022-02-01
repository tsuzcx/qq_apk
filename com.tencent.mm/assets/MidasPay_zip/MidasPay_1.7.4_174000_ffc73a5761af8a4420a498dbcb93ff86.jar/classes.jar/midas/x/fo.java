package midas.x;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.widget.Toast;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.data.report.APDataReportManager;
import com.pay.paychannel.tenpay.APTenpayActivity;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APGlobalInfo;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginUtils;
import java.io.File;
import java.util.ArrayList;

public class fo
{
  private Context a;
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private String j = "";
  private int k = 1;
  private boolean l;
  
  public fo(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private void a(int paramInt)
  {
    el localel = em.b().n();
    switch (paramInt)
    {
    default: 
      return;
    case 5: 
      if (gc.a().f() == gc.a.a)
      {
        if (a.a().d.getResources().getConfiguration().orientation == 2) {
          this.d = this.b;
        } else if (a.a().d.getResources().getConfiguration().orientation == 1) {
          this.d = "";
        }
      }
      else {
        this.d = this.b;
      }
      this.e = localel.b.a;
      return;
    case 4: 
      if (gc.a().f() == gc.a.a)
      {
        if (this.a.getResources().getConfiguration().orientation == 2) {
          this.d = this.b;
        } else if (this.a.getResources().getConfiguration().orientation == 1) {
          this.d = "";
        }
        this.e = localel.b.a;
        return;
      }
      gc.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append("个月");
      this.d = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(fv.a(localel.b.e, 2));
      localStringBuilder.append("元/月");
      this.e = localStringBuilder.toString();
      return;
    case 3: 
      this.d = this.b;
      this.e = "1元=1Q币";
      return;
    case 2: 
      this.d = this.b;
      this.e = "1元=10Q点";
      return;
    case 1: 
      this.d = this.b;
      if (!TextUtils.isEmpty(localel.b.f))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(fv.a(localel.b.f, 2));
        localStringBuilder.append("元/个");
        this.f = localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(fv.a(localel.b.e, 2));
      localStringBuilder.append("元/个");
      this.e = localStringBuilder.toString();
      return;
    }
    this.d = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("1元=");
    localStringBuilder.append(localel.b.e);
    localStringBuilder.append(localel.b.b);
    this.e = localStringBuilder.toString();
  }
  
  private void b()
  {
    el localel = em.b().n();
    this.h = localel.a.openId;
    this.i = localel.a.openKey;
    Object localObject = localel.a.sessionId;
    String str = localel.a.sessionType;
    if ("sid".equals(str))
    {
      this.j = "1";
      return;
    }
    if (("uin".equals(localObject)) && ("skey".equals(str)))
    {
      this.j = "2";
      return;
    }
    if (a.a().j())
    {
      if (TextUtils.isEmpty(localel.e.c))
      {
        this.j = "2";
        this.h = localel.e.a;
        this.i = localel.e.b;
        return;
      }
      this.j = "6";
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append("&appid=");
      ((StringBuffer)localObject).append(em.b().n().a.offerId);
      ((StringBuffer)localObject).append("&openid=");
      ((StringBuffer)localObject).append(localel.e.a);
      ((StringBuffer)localObject).append("&paytoken=");
      ((StringBuffer)localObject).append(localel.e.b);
      this.h = "";
      this.i = ((StringBuffer)localObject).toString();
      return;
    }
    if ("vkey".equals(str))
    {
      this.j = "4";
      return;
    }
    if ("vask".equals(str))
    {
      this.j = "5";
      return;
    }
    if ("kp_actoken".equals(str))
    {
      this.j = "6";
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append("&appid=");
      ((StringBuffer)localObject).append(em.b().n().a.offerId);
      ((StringBuffer)localObject).append("&openid=");
      ((StringBuffer)localObject).append(localel.a.openId);
      ((StringBuffer)localObject).append("&paytoken=");
      ((StringBuffer)localObject).append(localel.a.openKey);
      this.h = "";
      this.i = ((StringBuffer)localObject).toString();
      return;
    }
    if ("openkey".equals(str))
    {
      this.j = "7";
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append("&appid=");
      ((StringBuffer)localObject).append(em.b().n().a.offerId);
      ((StringBuffer)localObject).append("&openid=");
      ((StringBuffer)localObject).append(localel.a.openId);
      ((StringBuffer)localObject).append("&openkey=");
      ((StringBuffer)localObject).append(localel.a.openKey);
      this.h = "";
      this.i = ((StringBuffer)localObject).toString();
      return;
    }
    if (TextUtils.isEmpty(localel.e.c))
    {
      this.j = "2";
      this.h = localel.e.a;
      this.i = localel.e.b;
      return;
    }
    this.j = "6";
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append("&appid=");
    ((StringBuffer)localObject).append(em.b().n().a.offerId);
    ((StringBuffer)localObject).append("&openid=");
    ((StringBuffer)localObject).append(localel.e.a);
    ((StringBuffer)localObject).append("&paytoken=");
    ((StringBuffer)localObject).append(localel.e.b);
    this.h = "";
    this.i = ((StringBuffer)localObject).toString();
  }
  
  private int c()
  {
    el localel = em.b().n();
    if ((!a.a().j()) && (!d.a()) && (!d.b()))
    {
      if (("bank".equals(localel.e.j)) && (!this.l) && (!"bank".equals(em.b().n().a.mpInfo.payChannel))) {
        this.k = 1;
      } else if (localel.d.c) {
        this.k = 3;
      } else {
        this.k = 4;
      }
    }
    else {
      this.k = 3;
    }
    return this.k;
  }
  
  private int d()
  {
    if ((!a.a().j()) && (!d.a()) && (!d.b()))
    {
      if (("cft".equals(em.b().n().e.j)) && (!this.l) && (!"cft".equals(em.b().n().a.mpInfo.payChannel))) {
        this.k = 0;
      } else {
        this.k = 2;
      }
    }
    else {
      this.k = 2;
    }
    return this.k;
  }
  
  public void a(int paramInt, boolean paramBoolean, ResultReceiver paramResultReceiver)
  {
    String str = em.b().n().e.m;
    int n = em.b().n().a.saveType;
    this.b = em.b().n().e.g;
    this.l = paramBoolean;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("tokenId = ");
    ((StringBuilder)localObject1).append(str);
    ((StringBuilder)localObject1).append(" count:");
    ((StringBuilder)localObject1).append(this.b);
    APLog.i("Call Tenpay", ((StringBuilder)localObject1).toString());
    localObject1 = "数量";
    if ((str != null) && (!str.equals("")))
    {
      switch (n)
      {
      default: 
        break;
      case 5: 
        if (gc.a().f() == gc.a.a)
        {
          if (this.a.getResources().getConfiguration().orientation == 2)
          {
            this.c = ": ";
            localObject1 = "数量 ";
          }
          else if (this.a.getResources().getConfiguration().orientation == 1)
          {
            this.c = "";
            localObject1 = "";
          }
        }
        else
        {
          this.c = " × ";
          localObject1 = "数量";
        }
        break;
      case 4: 
        if (gc.a().f() == gc.a.a)
        {
          if (this.a.getResources().getConfiguration().orientation == 2)
          {
            this.c = ": ";
            localObject1 = "数量";
          }
          else if (this.a.getResources().getConfiguration().orientation == 1)
          {
            this.c = "";
            localObject1 = "";
          }
        }
        else
        {
          this.c = ": ";
          localObject1 = "时长";
        }
        break;
      case 2: 
      case 3: 
        m = APGlobalInfo.b;
        this.c = " x ";
        break;
      case 0: 
      case 1: 
        if (!TextUtils.isEmpty(em.b().n().b.f))
        {
          localObject2 = APUICommonMethod.a(this.a);
          if (localObject2 != null)
          {
            m = ((gr)localObject2).a;
            break label409;
          }
        }
        m = 0;
        label409:
        this.c = " x ";
        break;
      }
      int m = 0;
      a(n);
      b();
      this.g = "";
      StringBuilder localStringBuilder;
      switch (paramInt)
      {
      default: 
        break;
      case 2: 
        c();
        if ((n != 3) && (n != 2)) {
          localObject2 = gn.a().c("bank");
        } else {
          localObject2 = gn.a().b("bank");
        }
        if ((!((String)localObject2).equals("")) && (n != 3) && (n != 2))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("银行卡快捷支付(");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("折)");
          this.g = localStringBuilder.toString();
        }
        else
        {
          this.g = "银行卡快捷支付";
        }
        break;
      case 1: 
        d();
        if ((n != 3) && (n != 2)) {
          localObject2 = gn.a().c("cft");
        } else {
          localObject2 = gn.a().b("cft");
        }
        if ((!((String)localObject2).equals("")) && (n != 3) && (n != 2))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("财付通余额(");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("折)");
          this.g = localStringBuilder.toString();
        }
        else
        {
          this.g = "财付通余额";
        }
        break;
      }
      if (!APAppDataInterface.singleton().h())
      {
        this.c = "";
        this.d = "";
      }
      if (!APAppDataInterface.singleton().h())
      {
        this.c = "";
        this.d = "";
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("skey = ");
      ((StringBuilder)localObject2).append(this.i);
      APLog.i("Call Tenpay", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("skey_type = ");
      ((StringBuilder)localObject2).append(this.j);
      APLog.i("Call Tenpay", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("paytype = ");
      ((StringBuilder)localObject2).append(this.k);
      APLog.i("Call Tenpay", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("uin = ");
      ((StringBuilder)localObject2).append(this.h);
      APLog.i("Call Tenpay", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("price = ");
      ((StringBuilder)localObject2).append(this.e);
      ((StringBuilder)localObject2).append("disPrice = ");
      ((StringBuilder)localObject2).append(this.f);
      APLog.i("Call Tenpay", ((StringBuilder)localObject2).toString());
      if (this.a == null)
      {
        APLog.w("APCallTenpay", "toTenpay context is null");
        return;
      }
      if ((a.a().a(em.b().n().a)) && ("bank".equals(em.b().n().a.mpInfo.payChannel))) {
        APDataReportManager.getInstance().insertData("sdk.market.pay", em.b().n().a.saveType, null, em.b().n().a.mpInfo.payChannel, fy.a().m());
      }
      int i1 = APAppDataInterface.singleton().o();
      n = i1;
      if (i1 != 0) {
        if (i1 == 1) {
          n = i1;
        } else {
          n = APAppDataInterface.singleton().g();
        }
      }
      if (!a())
      {
        APLog.i("APCallTenpay", "checkValid false");
        Toast.makeText(this.a.getApplicationContext(), "腾讯充值加载失败，请重新拉起", 0).show();
        APUICommonMethod.b();
        fv.a(8, "腾讯充值拉起失败，请重新拉起");
        return;
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("uin", this.h);
      ((Bundle)localObject2).putString("skey", this.i);
      ((Bundle)localObject2).putString("skeyType", this.j);
      ((Bundle)localObject2).putString("tokenId", str);
      ((Bundle)localObject2).putInt("payType", this.k);
      ((Bundle)localObject2).putString("landMountText", (String)localObject1);
      ((Bundle)localObject2).putString("saveNum", this.d);
      ((Bundle)localObject2).putString("count", this.b);
      ((Bundle)localObject2).putString("amountMark", this.c);
      ((Bundle)localObject2).putString("price", this.e);
      ((Bundle)localObject2).putInt("vipResId", m);
      ((Bundle)localObject2).putString("disPrice", this.f);
      ((Bundle)localObject2).putString("disCount", this.g);
      ((Bundle)localObject2).putInt("type", n);
      ((Bundle)localObject2).putInt("channel", paramInt);
      ((Bundle)localObject2).putParcelable("tenpayCallback", paramResultReceiver);
      paramResultReceiver = new StringBuilder();
      paramResultReceiver.append("context:");
      paramResultReceiver.append(this.a);
      APLog.e("APCallTenpay", paramResultReceiver.toString());
      paramResultReceiver = new Intent();
      paramResultReceiver.setClass(this.a, APTenpayActivity.class);
      paramResultReceiver.putExtras((Bundle)localObject2);
      this.a.startActivity(paramResultReceiver);
      return;
    }
    if (this.a == null)
    {
      APLog.w("APCallTenpay", "toTenpay context is null");
      return;
    }
    APUICommonMethod.a(this.a, "系统繁忙,请稍后再试");
  }
  
  public boolean a()
  {
    File[] arrayOfFile = a.a().d.getDir("midasplugins", 0).listFiles();
    ArrayList localArrayList = aq.a().c();
    int m = 0;
    while (m < arrayOfFile.length)
    {
      if (arrayOfFile[m].getName().startsWith("MidasCFT"))
      {
        m = 1;
        break label61;
      }
      m += 1;
    }
    m = 0;
    label61:
    if (m == 0)
    {
      APPluginUtils.deletePlugin(a.a().d);
      APLog.i("APCallTenpay", "resultData=data区里的文件数目与校验表不一致的，则删除文件");
      return false;
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      m = 0;
      while (m < arrayOfFile.length)
      {
        if (arrayOfFile[m].getName().startsWith("MidasCFT"))
        {
          Object localObject = APTools.l(arrayOfFile[m].getAbsolutePath());
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("resultData=校验buypage来的checlistmd5值时本地md5是");
          localStringBuilder.append((String)localObject);
          APLog.i("APMidasDownIUtif", localStringBuilder.toString());
          m = 0;
          while (m < localArrayList.size())
          {
            if (((ap)localArrayList.get(m)).h.compareToIgnoreCase((String)localObject) == 0)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("resultData=校验buypage来的");
              ((StringBuilder)localObject).append(((ap)localArrayList.get(m)).h);
              APLog.i("APMidasDownIUtif", ((StringBuilder)localObject).toString());
              m = 1;
              break label256;
            }
            m += 1;
          }
          m = 0;
          label256:
          if (m == 0)
          {
            m = 0;
            while (m < arrayOfFile.length)
            {
              try
              {
                arrayOfFile[m].delete();
                APLog.i("APMidasDownIUtif", "resultData=data区里的文件与cgi的升级表里的文件Md5值不匹配，本地md5值文件被篡改，删掉文件");
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
              }
              m += 1;
            }
          }
          return true;
        }
        m += 1;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.fo
 * JD-Core Version:    0.7.0.1
 */