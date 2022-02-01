package com.tencent.mm.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.splash.SplashActivity;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.z;

public class WeChatSplashActivity
  extends SplashActivity
{
  public Resources getResources()
  {
    AppMethodBeat.i(160109);
    Resources localResources = super.getResources();
    AppMethodBeat.o(160109);
    return localResources;
  }
  
  public Object getSystemService(String paramString)
  {
    AppMethodBeat.i(160110);
    Object localObject = super.getSystemService(paramString);
    if ("layout_inflater".equals(paramString))
    {
      paramString = z.b((LayoutInflater)localObject);
      AppMethodBeat.o(160110);
      return paramString;
    }
    AppMethodBeat.o(160110);
    return localObject;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(160108);
    super.onCreate(paramBundle);
    MMActivity.initLanguage(getBaseContext());
    AppMethodBeat.o(160108);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(160111);
    t.fcM();
    super.onPause();
    AppMethodBeat.o(160111);
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