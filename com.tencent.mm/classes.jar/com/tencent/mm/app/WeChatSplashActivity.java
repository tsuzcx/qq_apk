package com.tencent.mm.app;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.splash.SplashActivity;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.y;

public class WeChatSplashActivity
  extends SplashActivity
{
  public Resources getResources()
  {
    if ((getAssets() != null) && (ae.getResources() != null)) {
      return ae.getResources();
    }
    return super.getResources();
  }
  
  public Object getSystemService(String paramString)
  {
    Object localObject2 = super.getSystemService(paramString);
    Object localObject1 = localObject2;
    if ("layout_inflater".equals(paramString)) {
      localObject1 = y.a((LayoutInflater)localObject2);
    }
    return localObject1;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    MMActivity.initLanguage(getBaseContext());
    setContentView(2130970995);
  }
  
  protected void onPause()
  {
    r.ckn();
    super.onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashActivity
 * JD-Core Version:    0.7.0.1
 */