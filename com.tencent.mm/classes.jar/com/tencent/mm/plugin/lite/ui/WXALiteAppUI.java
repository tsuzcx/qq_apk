package com.tencent.mm.plugin.lite.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.tencent.luggage.natives.LuggageNativeViewJni;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.b;
import com.tencent.mm.plugin.m.a.a.a.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import java.io.File;
import java.util.Map;

public class WXALiteAppUI
  extends MMActivity
{
  private Context mContext;
  private b sOa;
  private LuggageNativeViewJni sOb;
  private FrameLayout sOl;
  private com.tencent.mm.plugin.m.a.a.b.a sOm;
  private com.tencent.mm.plugin.m.a.a.a sOn;
  private b sOo;
  private LuggageNativeViewJni sOp;
  
  private void b(LuggageNativeViewJni paramLuggageNativeViewJni)
  {
    AppMethodBeat.i(146395);
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    int i = localDisplayMetrics.densityDpi;
    int j = localDisplayMetrics.widthPixels;
    int k = localDisplayMetrics.heightPixels;
    ad.i("MicroMsg.AppLite.AppLiteUI", "SetDisplayParams w=%d h=%d", new Object[] { Integer.valueOf(j), Integer.valueOf(j) });
    paramLuggageNativeViewJni.c(j, k, i, localDisplayMetrics.density);
    AppMethodBeat.o(146395);
  }
  
  public int getLayoutId()
  {
    return 2131494588;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(146401);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(146401);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(146394);
    super.onCreate(paramBundle);
    this.mContext = this;
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.sOb = new LuggageNativeViewJni();
    this.sOb.init();
    this.sOa = new b(this);
    this.sOl = ((FrameLayout)findViewById(2131304239));
    this.sOn = new com.tencent.mm.plugin.m.a.a.a(getContext(), null, "liteapp", "com.tencent.mm.liteapp/LiteApp");
    this.sOm = this.sOn.a(null, this.sOb.CR(), this.sOb.ceQ, (Activity)this.mContext, "AppLiteUI hardcode", this.sOl, new a.a.a()
    {
      public final String FD(int paramAnonymousInt)
      {
        return new String[1][0];
      }
      
      public final void FE(int paramAnonymousInt) {}
      
      public final void ac(Map<String, ?> paramAnonymousMap) {}
      
      public final void ad(Map<String, ?> paramAnonymousMap) {}
      
      public final void b(int paramAnonymousInt, String paramAnonymousString, Map<String, Float> paramAnonymousMap) {}
      
      public final void cJe() {}
      
      public final void cJf() {}
      
      public final void mG(boolean paramAnonymousBoolean) {}
    });
    b(this.sOb);
    this.sOb.cp("AppLiteUI hardcode");
    AppMethodBeat.o(146394);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(146400);
    super.onDestroy();
    AppMethodBeat.o(146400);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(146397);
    if (this.sOn != null) {
      this.sOn.a(this.sOm);
    }
    super.onPause();
    AppMethodBeat.o(146397);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(146398);
    if (this.sOn != null) {
      this.sOn.a(this.sOm, this.sOl);
    }
    super.onResume();
    AppMethodBeat.o(146398);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(146396);
    super.onStart();
    this.sOa.a(this.sOb);
    try
    {
      Environment.getExternalStorageDirectory().getAbsolutePath();
      String str1 = com.tencent.mm.plugin.m.a.c.a.aO(this.mContext, "wxa_library/native/luggage_lite.js");
      String str2 = com.tencent.mm.plugin.m.a.c.a.aO(this.mContext, "wxa_library/native/index.js");
      this.sOa.evaluateJavascript(str1, new ValueCallback() {});
      this.sOa.evaluateJavascript(str2, new ValueCallback() {});
      this.sOo = new b(this);
      this.sOp = new LuggageNativeViewJni();
      this.sOp.init();
      this.sOo.a(this.sOp);
      new Thread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(146393);
          try
          {
            Thread.sleep(10000L);
            label11:
            WXALiteAppUI.a(WXALiteAppUI.this, WXALiteAppUI.a(WXALiteAppUI.this));
            WXALiteAppUI.a(WXALiteAppUI.this).cp("AppLiteUI hardcode");
            String str1 = com.tencent.mm.plugin.m.a.c.a.aO(WXALiteAppUI.b(WXALiteAppUI.this), "wxa_library/native/luggage_lite.js");
            String str2 = com.tencent.mm.plugin.m.a.c.a.aO(WXALiteAppUI.b(WXALiteAppUI.this), "wxa_library/native/second_page.js");
            WXALiteAppUI.c(WXALiteAppUI.this).evaluateJavascript(str1, null);
            WXALiteAppUI.c(WXALiteAppUI.this).evaluateJavascript(str2, null);
            AppMethodBeat.o(146393);
            return;
          }
          catch (Exception localException)
          {
            break label11;
          }
        }
      }).start();
      AppMethodBeat.o(146396);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.AppLite.AppLiteUI", "evaluateJavascript exception:" + localException.getStackTrace());
      }
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(146399);
    this.sOb.uninit();
    if (this.sOn != null) {
      com.tencent.mm.plugin.m.a.a.a.b(this.sOm);
    }
    super.onStop();
    AppMethodBeat.o(146399);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WXALiteAppUI
 * JD-Core Version:    0.7.0.1
 */