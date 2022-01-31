package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.appbrand.s.n;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.b.c;
import java.util.HashMap;

@a(7)
public class AppBrandProcessShareMessageProxyUI
  extends MMActivity
{
  private c iNf;
  private AppBrandProcessShareMessageProxyUI.a iNg;
  
  public void finish()
  {
    AppMethodBeat.i(133023);
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(133023);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(133022);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    o.a(getWindow());
    o.a(getWindow(), false);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    if (getIntent() == null)
    {
      finish();
      AppMethodBeat.o(133022);
      return;
    }
    paramBundle = getIntent().getStringExtra("key_dialog_touser");
    if (bo.isNullOrNil(paramBundle)) {}
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        finish();
      }
      AppMethodBeat.o(133022);
      return;
      Object localObject2 = (HashMap)getIntent().getSerializableExtra("key_dialog_params");
      i = ce.getInt(((HashMap)localObject2).get("type"), 1);
      Object localObject1 = ce.f(((HashMap)localObject2).get("title"), "");
      String str1 = ce.f(((HashMap)localObject2).get("img_url"), null);
      if ((i == 2) || (i == 3))
      {
        i = ce.getInt(((HashMap)localObject2).get("pkg_type"), 0);
        int j = ce.getInt(((HashMap)localObject2).get("pkg_version"), 0);
        String str2 = ce.f(((HashMap)localObject2).get("app_id"), null);
        String str3 = ce.f(((HashMap)localObject2).get("cache_key"), null);
        String str4 = ce.f(((HashMap)localObject2).get("path"), null);
        String str5 = ce.f(((HashMap)localObject2).get("delay_load_img_path"), null);
        boolean bool = ce.aR(((HashMap)localObject2).get("is_dynamic"));
        localObject2 = ((com.tencent.mm.modelappbrand.i)g.E(com.tencent.mm.modelappbrand.i.class)).e(this, null);
        String str6 = n.bt(this);
        Bundle localBundle = new Bundle();
        localBundle.putString("app_id", str2);
        localBundle.putString("msg_id", String.format("%d-%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
        localBundle.putInt("msg_pkg_type", i);
        localBundle.putInt("pkg_version", j);
        localBundle.putString("image_url", str1);
        localBundle.putBoolean("is_dynamic_page", bool);
        localBundle.putString("title", (String)localObject1);
        localBundle.putString("cache_key", str3);
        localBundle.putString("msg_path", str4);
        localBundle.putString("delay_load_img_path", str5);
        localObject1 = new AppBrandProcessShareMessageProxyUI.c(this, this);
        ((AppBrandProcessShareMessageProxyUI.c)localObject1).iNo = new AppBrandProcessShareMessageProxyUI.2(this, str6, (View)localObject2);
        ((com.tencent.mm.modelappbrand.i)g.E(com.tencent.mm.modelappbrand.i.class)).a(str6, (View)localObject2, localBundle, new AppBrandProcessShareMessageProxyUI.3(this, (AppBrandProcessShareMessageProxyUI.c)localObject1));
        this.iNg = new AppBrandProcessShareMessageProxyUI.a(this);
        this.iNf = ((com.tencent.mm.pluginsdk.i)g.E(com.tencent.mm.pluginsdk.i.class)).a(this, paramBundle, (View)localObject2, getResources().getString(2131297067), new AppBrandProcessShareMessageProxyUI.4(this, (AppBrandProcessShareMessageProxyUI.c)localObject1));
        this.iNf.setOnDismissListener(this.iNg);
        this.iNf.setOnKeyListener(new AppBrandProcessShareMessageProxyUI.5(this, (AppBrandProcessShareMessageProxyUI.c)localObject1));
        this.iNf.show();
      }
    }
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(133021);
    super.onCreateBeforeSetContentView();
    supportRequestWindowFeature(1);
    AppMethodBeat.o(133021);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(133024);
    super.onDestroy();
    if ((this.iNf != null) && (this.iNf.isShowing()))
    {
      this.iNf.dismiss();
      this.iNf = null;
      this.iNg = null;
    }
    AppMethodBeat.o(133024);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI
 * JD-Core Version:    0.7.0.1
 */