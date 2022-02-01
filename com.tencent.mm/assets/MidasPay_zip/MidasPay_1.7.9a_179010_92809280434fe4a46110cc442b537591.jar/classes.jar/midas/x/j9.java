package midas.x;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import java.util.HashMap;

public class j9
{
  public static HashMap<String, j9> b = new HashMap();
  public APRecoChannelActivity a;
  
  public static j9 a(APRecoChannelActivity paramAPRecoChannelActivity)
  {
    paramAPRecoChannelActivity = (j9)b.get("channelView");
    if (paramAPRecoChannelActivity != null) {
      return paramAPRecoChannelActivity;
    }
    paramAPRecoChannelActivity = new i9();
    b.put("channelView", paramAPRecoChannelActivity);
    return paramAPRecoChannelActivity;
  }
  
  public static j9 a(String paramString)
  {
    Object localObject = (j9)b.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    if ((!"qdqb".equals(paramString)) && (!"qbqd".equals(paramString)))
    {
      if ("getChannel".equals(paramString))
      {
        paramString = new m9();
        b.put("getChannel", paramString);
        return paramString;
      }
      if ("hfpay".equals(paramString))
      {
        localObject = new l9();
        b.put(paramString, localObject);
        return localObject;
      }
      localObject = new k9();
      b.put(paramString, localObject);
      return localObject;
    }
    localObject = new n9();
    b.put(paramString, localObject);
    return localObject;
  }
  
  public static void b()
  {
    HashMap localHashMap = b;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public View a(APRecoChannelActivity paramAPRecoChannelActivity, Context paramContext, Bundle paramBundle)
  {
    this.a = paramAPRecoChannelActivity;
    return null;
  }
  
  public void a() {}
  
  public void a(boolean paramBoolean) {}
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }
  
  public boolean a(Context paramContext, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.j9
 * JD-Core Version:    0.7.0.1
 */