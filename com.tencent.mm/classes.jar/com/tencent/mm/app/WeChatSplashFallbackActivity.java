package com.tencent.mm.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.splash.SplashFallbackActivity;

public class WeChatSplashFallbackActivity
  extends SplashFallbackActivity
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(137977);
    super.onCreate(paramBundle);
    setContentView(2130971311);
    AppMethodBeat.o(137977);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashFallbackActivity
 * JD-Core Version:    0.7.0.1
 */