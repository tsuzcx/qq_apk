package com.pay.paychannel.payscore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;
import midas.x.a;
import midas.x.e5;
import midas.x.g5;
import midas.x.h5;
import midas.x.i5;
import midas.x.j9;
import midas.x.o4;
import midas.x.ob;
import midas.x.p4;
import midas.x.w3;
import midas.x.z5;

public class APPayScoreChannel
  extends i5
{
  public void a(int paramInt, Bundle paramBundle)
  {
    if (a.r().a == null) {
      return;
    }
    if (paramInt == 0)
    {
      a(null);
      return;
    }
    if (paramInt == -1)
    {
      a(this.c, -1, "系统繁忙,请稍后再试(100-100--1)", this.f);
      return;
    }
    if (paramInt == 2)
    {
      b(this.c, this.f);
      return;
    }
    paramBundle = this.f;
    if (paramBundle != null)
    {
      paramBundle.a(paramInt);
      return;
    }
    if (z5.d())
    {
      APUICommonMethod.f();
      paramBundle = new StringBuilder();
      paramBundle.append("payscore result code:");
      paramBundle.append(paramInt);
      z5.a(-1, paramBundle.toString());
      return;
    }
    if ((e5.h().e()) && (!TextUtils.isEmpty(p4.p().e().b.saveValue)) && (!p4.p().e().b.isCanChange))
    {
      APUICommonMethod.f();
      paramBundle = new StringBuilder();
      paramBundle.append("payscore result code:");
      paramBundle.append(paramInt);
      z5.a(-1, paramBundle.toString());
    }
  }
  
  public void a(Context paramContext, Bundle paramBundle)
  {
    if (j9.b.size() > 0) {
      try
      {
        ((APRecoChannelActivity)paramContext).a(1, 2, paramBundle);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localIntent = new Intent(paramContext, APRecoChannelActivity.class);
        if (paramBundle != null) {
          localIntent.putExtras(paramBundle);
        }
        paramContext.startActivity(localIntent);
        return;
      }
    }
    Intent localIntent = new Intent(paramContext, APRecoChannelActivity.class);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    paramContext.startActivity(localIntent);
  }
  
  public void a(Context paramContext, Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    this.e = paramg5;
    this.f = paramh5;
    a(paramContext, paramh5, paramg5);
  }
  
  public void a(Context paramContext, w3 paramw3)
  {
    int i = paramw3.d();
    paramContext = new StringBuilder();
    paramContext.append("progressChannelSaveAns ret:");
    paramContext.append(i);
    APLog.i("APPayScoreChannel", paramContext.toString());
    paramContext = p4.p().e().b.mpInfo.payChannel;
    if ((!TextUtils.isEmpty(paramContext)) && (paramContext.equals("wechat_payscore"))) {
      APUICommonMethod.b();
    }
    if (i != 0)
    {
      a(i, paramw3.f(), false);
      return;
    }
    a(null);
  }
  
  public void c(Context paramContext, Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    this.e = paramg5;
    this.f = paramh5;
    a(paramContext, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.payscore.APPayScoreChannel
 * JD-Core Version:    0.7.0.1
 */