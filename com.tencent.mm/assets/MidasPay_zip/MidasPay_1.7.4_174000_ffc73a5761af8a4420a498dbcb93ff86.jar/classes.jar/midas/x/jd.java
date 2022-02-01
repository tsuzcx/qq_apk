package midas.x;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import java.util.HashMap;

public class jd
{
  public static HashMap<String, jd> c = new HashMap();
  private boolean a = false;
  public APRecoChannelActivity d;
  
  public static jd a(APRecoChannelActivity paramAPRecoChannelActivity)
  {
    paramAPRecoChannelActivity = (jd)c.get("channelView");
    if (paramAPRecoChannelActivity != null) {
      return paramAPRecoChannelActivity;
    }
    paramAPRecoChannelActivity = new jc();
    c.put("channelView", paramAPRecoChannelActivity);
    return paramAPRecoChannelActivity;
  }
  
  public static jd b(String paramString)
  {
    Object localObject = (jd)c.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    if ((!"qdqb".equals(paramString)) && (!"qbqd".equals(paramString)))
    {
      if ("getChannel".equals(paramString))
      {
        paramString = new jg();
        c.put("getChannel", paramString);
        return paramString;
      }
      if ("hfpay".equals(paramString))
      {
        localObject = new jf();
        c.put(paramString, localObject);
        return localObject;
      }
      localObject = new je();
      c.put(paramString, localObject);
      return localObject;
    }
    localObject = new jh();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.jd
 * JD-Core Version:    0.7.0.1
 */