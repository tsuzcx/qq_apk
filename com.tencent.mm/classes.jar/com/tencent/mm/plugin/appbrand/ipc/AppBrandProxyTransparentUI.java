package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.a;

@a(7)
public class AppBrandProxyTransparentUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73147);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.AppBrandProxyTransparentUI", "onCreate");
    af.a(getWindow());
    try
    {
      paramBundle = Class.forName(getIntent().getStringExtra("task_class_name"));
      getIntent().getExtras().setClassLoader(paramBundle.getClassLoader());
      paramBundle = (AppBrandProxyTransparentUIProcessTask)getIntent().getParcelableExtra("task_object");
      String str = getIntent().getStringExtra("task_id");
      if (paramBundle != null)
      {
        paramBundle.a(this, new AppBrandProxyTransparentUI.1(this, paramBundle, str));
        AppMethodBeat.o(73147);
        return;
      }
    }
    catch (ClassNotFoundException paramBundle)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppBrandProxyTransparentUI", "ClassNotFoundException");
        setResult(1);
        finish();
      }
      setResult(1);
      finish();
      AppMethodBeat.o(73147);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(73148);
    super.onDestroy();
    ab.i("MicroMsg.AppBrandProxyTransparentUI", "onDestroy");
    AppMethodBeat.o(73148);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setMMOrientation()
  {
    AppMethodBeat.i(73149);
    int i = getIntent().getIntExtra("orientation", -1);
    if (i != -1) {
      setRequestedOrientation(i);
    }
    AppMethodBeat.o(73149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUI
 * JD-Core Version:    0.7.0.1
 */