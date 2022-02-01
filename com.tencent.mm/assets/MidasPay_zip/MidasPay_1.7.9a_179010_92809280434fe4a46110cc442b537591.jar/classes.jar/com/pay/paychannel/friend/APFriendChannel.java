package com.pay.paychannel.friend;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.pay.ui.common.APUICommonMethod;
import java.lang.ref.WeakReference;
import midas.x.a;
import midas.x.c.b;
import midas.x.c.c;
import midas.x.g5;
import midas.x.h5;
import midas.x.i5;
import midas.x.j5;
import midas.x.w3;
import midas.x.z5;

public class APFriendChannel
  extends i5
{
  public APFriendChannel()
  {
    new c.c();
  }
  
  public void a(Context paramContext, Bundle paramBundle) {}
  
  public void a(Context paramContext, Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    c(paramContext, paramh5);
  }
  
  public void a(Context paramContext, w3 paramw3) {}
  
  public void c(Context paramContext, Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    a(paramContext, paramBundle);
  }
  
  public final void c(final Context paramContext, final h5 paramh5)
  {
    new j5((Activity)a.r().c.get()).a(new a(paramh5, paramContext));
  }
  
  public class a
    implements c.b
  {
    public a(h5 paramh5, Context paramContext) {}
    
    public void a(int paramInt, String paramString)
    {
      h5 localh5 = paramh5;
      if (localh5 != null) {
        localh5.a(-1);
      }
      if (paramInt == 0)
      {
        APUICommonMethod.f();
        z5.a(14, paramInt, -1, paramString);
        return;
      }
      if (paramInt == 3)
      {
        paramString = paramContext;
        if (paramString != null) {
          APUICommonMethod.a(paramString, "登录态失效，请重新登录");
        }
      }
      else
      {
        paramString = paramContext;
        if (paramString != null) {
          APUICommonMethod.a(paramString, "好友代付发起失败，请重试");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.friend.APFriendChannel
 * JD-Core Version:    0.7.0.1
 */