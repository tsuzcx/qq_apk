package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.a;

@a(7)
public class AppBrandProxyTransparentUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(45408);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.AppBrandProxyTransparentUI", "onCreate");
    aw.g(getWindow());
    try
    {
      paramBundle = Class.forName(getIntent().getStringExtra("task_class_name"));
      getIntent().getExtras().setClassLoader(paramBundle.getClassLoader());
      paramBundle = (AppBrandProxyTransparentUIProcessTask)getIntent().getParcelableExtra("task_object");
      final String str = getIntent().getStringExtra("task_id");
      if (paramBundle != null)
      {
        paramBundle.a(this, new AppBrandProxyTransparentUIProcessTask.a()
        {
          public final void cpu()
          {
            AppMethodBeat.i(45407);
            Log.i("MicroMsg.AppBrandProxyTransparentUI", "onResult");
            Intent localIntent = new Intent();
            localIntent.putExtra("task_object", paramBundle);
            localIntent.putExtra("task_id", str);
            AppBrandProxyTransparentUI.this.setResult(-1, localIntent);
            AppBrandProxyTransparentUI.this.finish();
            AppMethodBeat.o(45407);
          }
        });
        AppMethodBeat.o(45408);
        return;
      }
    }
    catch (ClassNotFoundException paramBundle)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrandProxyTransparentUI", "ClassNotFoundException");
        setResult(1);
        finish();
      }
      setResult(1);
      finish();
      AppMethodBeat.o(45408);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45409);
    super.onDestroy();
    Log.i("MicroMsg.AppBrandProxyTransparentUI", "onDestroy");
    AppMethodBeat.o(45409);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setMMOrientation()
  {
    AppMethodBeat.i(45410);
    int i = getIntent().getIntExtra("orientation", -1);
    if (i != -1) {
      setRequestedOrientation(i);
    }
    AppMethodBeat.o(45410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUI
 * JD-Core Version:    0.7.0.1
 */