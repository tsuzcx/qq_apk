package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.compatible.util.n;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSMoreWebViewUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.c;
import java.util.List;

public class AppBrandSOSUI
  extends FTSSOSMoreWebViewUI
{
  private View mEu;
  private String mEv;
  private String mEw;
  private int scene;
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(163179);
    if (!TextUtils.isEmpty(paramString2)) {
      this.mEu.setVisibility(8);
    }
    try
    {
      this.lvv.k(10001, null);
      super.a(paramString1, paramString2, paramList, paramb);
      AppMethodBeat.o(163179);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ad.e("MicroMsg.AppBrandSOSUI", "refresh keyword id error : %s", new Object[] { localRemoteException });
      }
    }
  }
  
  public final boolean bzz()
  {
    AppMethodBeat.i(21127);
    this.mEu.setVisibility(8);
    boolean bool = super.bzz();
    AppMethodBeat.o(21127);
    return bool;
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(21129);
    super.dealContentView(paramView);
    this.mEv = getIntent().getStringExtra("key_nearby_url");
    getIntent().getStringExtra("key_nearby_list_id");
    this.mEu = getLayoutInflater().inflate(2131493053, (ViewGroup)paramView, false);
    View localView1 = this.mEu.findViewById(2131302682);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(21124);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandSOSUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (TextUtils.isEmpty(AppBrandSOSUI.a(AppBrandSOSUI.this)))
        {
          a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandSOSUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21124);
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("showShare", false);
        ((Intent)localObject).putExtra("rawUrl", AppBrandSOSUI.a(AppBrandSOSUI.this));
        ((Intent)localObject).putExtra("geta8key_scene", 41);
        ((Intent)localObject).putExtra("show_long_click_popup_menu", false);
        d.b(paramAnonymousView.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandSOSUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(21124);
      }
    });
    if (TextUtils.isEmpty(this.mEv))
    {
      localView1.setVisibility(8);
      this.mEu.setVisibility(8);
    }
    while ((paramView instanceof FrameLayout))
    {
      ((FrameLayout)paramView).addView(this.mEu);
      AppMethodBeat.o(21129);
      return;
      localView1.setVisibility(0);
      this.mEu.setVisibility(0);
    }
    paramView = paramView.getLayoutParams();
    int k;
    Rect localRect;
    int i;
    if (getWindow().hasFeature(9))
    {
      localView1 = this.mEu;
      k = this.mEu.getPaddingLeft();
      localRect = new Rect();
      int j = getActionBarHeight();
      View localView2 = getWindow().getDecorView();
      localView2.getWindowVisibleDisplayFrame(localRect);
      int m = localView2.getHeight();
      int[] arrayOfInt = new int[2];
      localView2.getLocationOnScreen(arrayOfInt);
      i = j;
      if (m == 0) {
        i = j + n.B(getContext(), 0);
      }
      if ((m - localRect.height() < 0) || (arrayOfInt[1] <= 200)) {
        break label321;
      }
      i += m - localRect.height();
    }
    for (;;)
    {
      localView1.setPadding(k, i + this.mEu.getPaddingTop(), this.mEu.getPaddingRight(), this.mEu.getPaddingBottom());
      addContentView(this.mEu, paramView);
      AppMethodBeat.o(21129);
      return;
      label321:
      i += localRect.top;
    }
  }
  
  public final String getHint()
  {
    AppMethodBeat.i(21131);
    String str = getIntent().getStringExtra("key_search_place_holder");
    if ((str != null) && (str.length() > 0))
    {
      AppMethodBeat.o(21131);
      return str;
    }
    str = super.getHint();
    AppMethodBeat.o(21131);
    return str;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21125);
    super.onCreate(paramBundle);
    overridePendingTransition(2130772095, 0);
    this.mEw = getIntent().getStringExtra("key_session_id");
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    ad.i("MicroMsg.AppBrandSOSUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", new Object[] { this.mEw });
    g.yhR.f(13929, new Object[] { this.mEw, "", Integer.valueOf(1), Integer.valueOf(this.scene) });
    paramBundle = new Intent();
    paramBundle.putExtra("key_session_id", this.mEw);
    paramBundle.putExtra("ftsbizscene", this.scene);
    setResult(-1, paramBundle);
    AppMethodBeat.o(21125);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21126);
    if ((this.scene == 3) || (this.scene == 16)) {
      g.yhR.f(13929, new Object[] { this.mEw, com.tencent.mm.modelappbrand.b.hKo, Integer.valueOf(2), Integer.valueOf(this.scene) });
    }
    super.onDestroy();
    AppMethodBeat.o(21126);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandSOSUI
 * JD-Core Version:    0.7.0.1
 */