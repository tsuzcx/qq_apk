package com.tencent.mm.plugin.lite.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.widget.FrameLayout;
import com.tencent.luggage.natives.LuggageNativeViewJni;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.c.b;
import com.tencent.mm.plugin.lite.c.b.5;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import io.flutter.a.a.k.d;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.c.e;
import java.util.HashMap;
import java.util.Map;

public class LiteAppUI
  extends MMActivity
{
  private Context mContext;
  private FrameLayout mRootView;
  private b sOk;
  
  public int getLayoutId()
  {
    return 2131494589;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(146390);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    b localb = this.sOk;
    if (localb.sOg.get(paramInt1) != null)
    {
      k.d locald = (k.d)localb.sOg.get(paramInt1);
      paramIntent = (HashMap)paramIntent.getExtras().get("data");
      paramIntent.put("requestCode", Integer.valueOf(paramInt1));
      paramIntent.put("resultCode", Integer.valueOf(paramInt2));
      if (paramInt1 == -1) {
        locald.ay(paramIntent);
      }
      for (;;)
      {
        localb.sOg.remove(paramInt1);
        AppMethodBeat.o(146390);
        return;
        locald.a("", "", paramIntent);
      }
    }
    ad.w("MicroMsg.AppLite.LiteRenderEngine", "unknown request Code %d", new Object[] { Integer.valueOf(paramInt1) });
    AppMethodBeat.o(146390);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(146384);
    ad.d("MicroMsg.AppLite.LiteAppUI", "onCreate");
    super.onCreate(paramBundle);
    this.mContext = this;
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    ad.d("MicroMsg.AppLite.LiteAppUI", "init");
    this.mRootView = ((FrameLayout)findViewById(2131304239));
    this.sOk = new b(this.mContext, this.mRootView, "AppLiteUI hardcode");
    paramBundle = this.sOk;
    paramBundle.cGL.IYk.aPN(paramBundle.sOc.aOj());
    ad.d("MicroMsg.AppLite.LiteRenderEngine", "onCreate");
    Object localObject = new HashMap();
    ((Map)localObject).put("viewId", Long.valueOf(paramBundle.sOb.CR()));
    ((Map)localObject).put("renderPtr", Long.valueOf(paramBundle.sOb.ceQ));
    int i = paramBundle.jzm.lastIndexOf("/");
    if (-1 == i) {
      ((Map)localObject).put("workDir", paramBundle.jzm);
    }
    for (;;)
    {
      paramBundle.sOe.a("onCreate", localObject, new b.5(paramBundle));
      paramBundle.sOd.b(paramBundle.cGL);
      paramBundle.cGL.IYi.fuV();
      localObject = paramBundle.mContext.getResources().getDisplayMetrics();
      i = ((DisplayMetrics)localObject).densityDpi;
      int j = ((DisplayMetrics)localObject).widthPixels;
      int k = ((DisplayMetrics)localObject).heightPixels;
      ad.i("MicroMsg.AppLite.LiteRenderEngine", "SetDisplayParams w=%d h=%d", new Object[] { Integer.valueOf(j), Integer.valueOf(j) });
      paramBundle.sOb.c(j, k, i, ((DisplayMetrics)localObject).density);
      AppMethodBeat.o(146384);
      return;
      ((Map)localObject).put("workDir", paramBundle.jzm.substring(i + 1));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(146389);
    ad.d("MicroMsg.AppLite.LiteAppUI", "onDestroy");
    super.onDestroy();
    b localb = this.sOk;
    ad.d("MicroMsg.AppLite.LiteRenderEngine", "onDestroy");
    localb.aeR("onDestroy");
    localb.sOb.uninit();
    localb.sOd.fuw();
    localb.sOg.clear();
    localb.sOg = null;
    AppMethodBeat.o(146389);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(146387);
    ad.d("MicroMsg.AppLite.LiteAppUI", "onPause");
    super.onPause();
    AppMethodBeat.o(146387);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(146386);
    ad.d("MicroMsg.AppLite.LiteAppUI", "onResume");
    b localb = this.sOk;
    ad.d("MicroMsg.AppLite.LiteRenderEngine", "onForeground");
    localb.aeR("onForeground");
    localb.cGL.IYi.fuW();
    super.onResume();
    AppMethodBeat.o(146386);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(146385);
    ad.d("MicroMsg.AppLite.LiteAppUI", "onStart");
    super.onStart();
    AppMethodBeat.o(146385);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(146388);
    ad.d("MicroMsg.AppLite.LiteAppUI", "onStop");
    b localb = this.sOk;
    ad.d("MicroMsg.AppLite.LiteRenderEngine", "onBackground");
    localb.aeR("onBackground");
    localb.cGL.IYi.fuV();
    localb.cGL.IYi.fuX();
    super.onStop();
    AppMethodBeat.o(146388);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.LiteAppUI
 * JD-Core Version:    0.7.0.1
 */