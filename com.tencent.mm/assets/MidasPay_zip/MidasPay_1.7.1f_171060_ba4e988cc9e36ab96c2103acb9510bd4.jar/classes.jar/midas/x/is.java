package midas.x;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import java.util.HashMap;

public class is
{
  public static HashMap<String, is> c = new HashMap();
  private boolean a = false;
  public APRecoChannelActivity d;
  
  public static is a(APRecoChannelActivity paramAPRecoChannelActivity)
  {
    paramAPRecoChannelActivity = (is)c.get("channelView");
    if (paramAPRecoChannelActivity != null) {
      return paramAPRecoChannelActivity;
    }
    paramAPRecoChannelActivity = new ir();
    c.put("channelView", paramAPRecoChannelActivity);
    return paramAPRecoChannelActivity;
  }
  
  public static is b(String paramString)
  {
    Object localObject = (is)c.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    if ((!"qdqb".equals(paramString)) && (!"qbqd".equals(paramString)))
    {
      if ("getChannel".equals(paramString))
      {
        paramString = new iv();
        c.put("getChannel", paramString);
        return paramString;
      }
      if ("hfpay".equals(paramString))
      {
        localObject = new iu();
        c.put(paramString, localObject);
        return localObject;
      }
      localObject = new it();
      c.put(paramString, localObject);
      return localObject;
    }
    localObject = new iw();
    c.put(paramString, localObject);
    return localObject;
  }
  
  public static void b()
  {
    if (c != null) {
      c.clear();
    }
  }
  
  public View a(APRecoChannelActivity paramAPRecoChannelActivity, Context paramContext, Bundle paramBundle)
  {
    this.d = paramAPRecoChannelActivity;
    return null;
  }
  
  public void a() {}
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }
  
  public boolean a(Context paramContext, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.is
 * JD-Core Version:    0.7.0.1
 */