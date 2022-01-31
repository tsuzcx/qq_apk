package com.tencent.mm.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.u;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.splash.SplashActivity;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w;

public class WeChatSplashActivity
  extends SplashActivity
{
  public Resources getResources()
  {
    AppMethodBeat.i(137988);
    if ((getAssets() != null) && (ah.getResources() != null))
    {
      localResources = ah.getResources();
      AppMethodBeat.o(137988);
      return localResources;
    }
    Resources localResources = super.getResources();
    AppMethodBeat.o(137988);
    return localResources;
  }
  
  public Object getSystemService(String paramString)
  {
    AppMethodBeat.i(137989);
    Object localObject = super.getSystemService(paramString);
    if ("layout_inflater".equals(paramString))
    {
      paramString = w.b((LayoutInflater)localObject);
      AppMethodBeat.o(137989);
      return paramString;
    }
    AppMethodBeat.o(137989);
    return localObject;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(137987);
    super.onCreate(paramBundle);
    MMActivity.initLanguage(getBaseContext());
    setContentView(2130971311);
    AppMethodBeat.o(137987);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(137990);
    u.dkT();
    super.onPause();
    AppMethodBeat.o(137990);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashActivity
 * JD-Core Version:    0.7.0.1
 */