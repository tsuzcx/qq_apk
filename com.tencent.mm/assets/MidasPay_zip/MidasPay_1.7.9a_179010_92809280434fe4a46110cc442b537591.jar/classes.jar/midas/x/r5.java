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
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginUtils;
import java.io.File;
import java.util.ArrayList;

public class r5
{
  public Context a;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public int k = 1;
  public boolean l;
  
  public r5(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final void a(int paramInt)
  {
    o4 localo4 = p4.p().e();
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return;
              }
              if (g6.k().e() == g6.a.a)
              {
                if (a.r().d.getResources().getConfiguration().orientation == 2) {
                  this.d = this.b;
                } else if (a.r().d.getResources().getConfiguration().orientation == 1) {
                  this.d = "";
                }
              }
              else {
                this.d = this.b;
              }
              this.e = localo4.c.a;
              return;
            }
            if (g6.k().e() == g6.a.a)
            {
              if (this.a.getResources().getConfiguration().orientation == 2) {
                this.d = this.b;
              } else if (this.a.getResources().getConfiguration().orientation == 1) {
                this.d = "";
              }
              this.e = localo4.c.a;
              return;
            }
            g6.k();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.b);
            localStringBuilder.append("个月");
            this.d = localStringBuilder.toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(z5.a(localo4.c.c, 2));
            localStringBuilder.append("元/月");
            this.e = localStringBuilder.toString();
            return;
          }
          this.d = this.b;
          this.e = "1元=1Q币";
          return;
        }
        this.d = this.b;
        this.e = "1元=10Q点";
        return;
      }
      this.d = this.b;
      if (!TextUtils.isEmpty(localo4.c.d))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(z5.a(localo4.c.d, 2));
        localStringBuilder.append("元/个");
        this.f = localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(z5.a(localo4.c.c, 2));
      localStringBuilder.append("元/个");
      this.e = localStringBuilder.toString();
      return;
    }
    this.d = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("1元=");
    localStringBuilder.append(localo4.c.c);
    localStringBuilder.append(localo4.c.b);
    this.e = localStringBuilder.toString();
  }
  
  public void a(int paramInt, boolean paramBoolean, ResultReceiver paramResultReceiver)
  {
    String str = p4.p().e().f.l;
    int n = p4.p().e().b.saveType;
    this.b = p4.p().e().f.f;
    this.l = paramBoolean;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("tokenId = ");
    ((StringBuilder)localObject1).append(str);
    ((StringBuilder)localObject1).append(" count:");
    ((StringBuilder)localObject1).append(this.b);
    APLog.i("Call Tenpay", ((StringBuilder)localObject1).toString());
    if ((str != null) && (!str.equals("")))
    {
      localObject1 = "数量";
      label307:
      label317:
      label326:
      int m;
      if ((n != 0) && (n != 1))
      {
        if ((n != 2) && (n != 3))
        {
          if (n != 4)
          {
            if (n != 5) {
              break label326;
            }
            if (g6.k().e() == g6.a.a)
            {
              if (this.a.getResources().getConfiguration().orientation == 2)
              {
                this.c = ": ";
                localObject1 = "数量 ";
                break label317;
              }
              if (this.a.getResources().getConfiguration().orientation != 1) {
                break label326;
              }
              this.c = "";
            }
            else
            {
              this.c = " × ";
              break label326;
            }
          }
          else
          {
            if (g6.k().e() != g6.a.a) {
              break label307;
            }
            if (this.a.getResources().getConfiguration().orientation == 2)
            {
              this.c = ": ";
              break label326;
            }
            if (this.a.getResources().getConfiguration().orientation != 1) {
              break label326;
            }
            this.c = "";
          }
          localObject1 = "";
          break label326;
          this.c = ": ";
          localObject1 = "时长";
        }
        else
        {
          this.c = " x ";
        }
        m = 0;
      }
      else
      {
        if (!TextUtils.isEmpty(p4.p().e().c.d))
        {
          localObject2 = APUICommonMethod.b(this.a);
          if (localObject2 != null)
          {
            m = ((v6)localObject2).a;
            break label377;
          }
        }
        m = 0;
        label377:
        this.c = " x ";
      }
      a(n);
      d();
      this.g = "";
      StringBuilder localStringBuilder;
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          b();
          if ((n != 3) && (n != 2)) {
            localObject2 = r6.j().d("bank");
          } else {
            localObject2 = r6.j().a("bank");
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
        }
      }
      else
      {
        c();
        if ((n != 3) && (n != 2)) {
          localObject2 = r6.j().d("cft");
        } else {
          localObject2 = r6.j().a("cft");
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
      }
      if (!APAppDataInterface.singleton().n())
      {
        this.c = "";
        this.d = "";
      }
      if (!APAppDataInterface.singleton().n())
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
      if ((a.r().e(p4.p().e().b)) && ("bank".equals(p4.p().e().b.mpInfo.payChannel))) {
        APDataReportManager.getInstance().insertData("sdk.market.pay", p4.p().e().b.saveType, null, p4.p().e().b.mpInfo.payChannel, c6.s0().l());
      }
      int i1 = APAppDataInterface.singleton().v();
      n = i1;
      if (i1 != 0) {
        if (i1 == 1) {
          n = i1;
        } else {
          n = APAppDataInterface.singleton().a();
        }
      }
      if (!a())
      {
        APLog.i("APCallTenpay", "checkValid false");
        Toast.makeText(this.a.getApplicationContext(), "腾讯充值加载失败，请重新拉起", 0).show();
        APUICommonMethod.f();
        z5.a(8, "腾讯充值拉起失败，请重新拉起");
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
    paramResultReceiver = this.a;
    if (paramResultReceiver == null)
    {
      APLog.w("APCallTenpay", "toTenpay context is null");
      return;
    }
    APUICommonMethod.a(paramResultReceiver, "系统繁忙,请稍后再试");
  }
  
  public boolean a()
  {
    File[] arrayOfFile = a.r().d.getDir("midasplugins", 0).listFiles();
    ArrayList localArrayList = r0.p().a();
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
      APPluginUtils.deletePlugin(a.r().d);
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
          Object localObject = APTools.b(arrayOfFile[m].getAbsolutePath());
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("resultData=校验buypage来的checlistmd5值时本地md5是");
          localStringBuilder.append((String)localObject);
          APLog.i("APMidasDownIUtif", localStringBuilder.toString());
          m = 0;
          while (m < localArrayList.size())
          {
            if (((q0)localArrayList.get(m)).g.compareToIgnoreCase((String)localObject) == 0)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("resultData=校验buypage来的");
              ((StringBuilder)localObject).append(((q0)localArrayList.get(m)).g);
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
  
  public final int b()
  {
    o4 localo4 = p4.p().e();
    if ((!a.r().e()) && (!d.a()) && (!d.b()))
    {
      if (("bank".equals(localo4.f.i)) && (!this.l) && (!"bank".equals(p4.p().e().b.mpInfo.payChannel))) {
        this.k = 1;
      } else if (localo4.e.c) {
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
  
  public final int c()
  {
    if ((!a.r().e()) && (!d.a()) && (!d.b()))
    {
      if (("cft".equals(p4.p().e().f.i)) && (!this.l) && (!"cft".equals(p4.p().e().b.mpInfo.payChannel))) {
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
  
  public final void d()
  {
    Object localObject1 = p4.p().e();
    Object localObject3 = ((o4)localObject1).b;
    this.h = ((APBaseRequest)localObject3).openId;
    this.i = ((APBaseRequest)localObject3).openKey;
    Object localObject2 = ((APBaseRequest)localObject3).sessionId;
    localObject3 = ((APBaseRequest)localObject3).sessionType;
    if ("sid".equals(localObject3))
    {
      this.j = "1";
      return;
    }
    if (("uin".equals(localObject2)) && ("skey".equals(localObject3)))
    {
      this.j = "2";
      return;
    }
    if (a.r().e())
    {
      if (TextUtils.isEmpty(((o4)localObject1).f.c))
      {
        this.j = "2";
        localObject1 = ((o4)localObject1).f;
        this.h = ((d5)localObject1).a;
        this.i = ((d5)localObject1).b;
        return;
      }
      this.j = "6";
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject2).append("&appid=");
      ((StringBuffer)localObject2).append(p4.p().e().b.offerId);
      ((StringBuffer)localObject2).append("&openid=");
      ((StringBuffer)localObject2).append(((o4)localObject1).f.a);
      ((StringBuffer)localObject2).append("&paytoken=");
      ((StringBuffer)localObject2).append(((o4)localObject1).f.b);
      this.h = "";
      this.i = ((StringBuffer)localObject2).toString();
      return;
    }
    if ("vkey".equals(localObject3))
    {
      this.j = "4";
      return;
    }
    if ("vask".equals(localObject3))
    {
      this.j = "5";
      return;
    }
    if ("kp_actoken".equals(localObject3))
    {
      this.j = "6";
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject2).append("&appid=");
      ((StringBuffer)localObject2).append(p4.p().e().b.offerId);
      ((StringBuffer)localObject2).append("&openid=");
      ((StringBuffer)localObject2).append(((o4)localObject1).b.openId);
      ((StringBuffer)localObject2).append("&paytoken=");
      ((StringBuffer)localObject2).append(((o4)localObject1).b.openKey);
      this.h = "";
      this.i = ((StringBuffer)localObject2).toString();
      return;
    }
    if ("openkey".equals(localObject3))
    {
      this.j = "7";
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject2).append("&appid=");
      ((StringBuffer)localObject2).append(p4.p().e().b.offerId);
      ((StringBuffer)localObject2).append("&openid=");
      ((StringBuffer)localObject2).append(((o4)localObject1).b.openId);
      ((StringBuffer)localObject2).append("&openkey=");
      ((StringBuffer)localObject2).append(((o4)localObject1).b.openKey);
      this.h = "";
      this.i = ((StringBuffer)localObject2).toString();
      return;
    }
    if (TextUtils.isEmpty(((o4)localObject1).f.c))
    {
      this.j = "2";
      localObject1 = ((o4)localObject1).f;
      this.h = ((d5)localObject1).a;
      this.i = ((d5)localObject1).b;
      return;
    }
    this.j = "6";
    localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append("&appid=");
    ((StringBuffer)localObject2).append(p4.p().e().b.offerId);
    ((StringBuffer)localObject2).append("&openid=");
    ((StringBuffer)localObject2).append(((o4)localObject1).f.a);
    ((StringBuffer)localObject2).append("&paytoken=");
    ((StringBuffer)localObject2).append(((o4)localObject1).f.b);
    this.h = "";
    this.i = ((StringBuffer)localObject2).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.r5
 * JD-Core Version:    0.7.0.1
 */