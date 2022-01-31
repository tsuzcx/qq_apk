package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s.r;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.a.c;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.e.k;
import java.lang.reflect.Field;
import java.util.List;

public class AppBrandSearchUI
  extends FTSSearchTabWebViewUI
  implements com.tencent.mm.plugin.fts.ui.widget.a.a
{
  private View iOB;
  private String iOC;
  private String iOD;
  private int iOF;
  private int scene;
  
  private int aMn()
  {
    int i = 0;
    AppMethodBeat.i(17093);
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int j = bo.getInt(localClass.getField("status_bar_height").get(localObject).toString(), 0);
      j = getResources().getDimensionPixelSize(j);
      i = j;
    }
    catch (Exception localException)
    {
      label50:
      break label50;
    }
    AppMethodBeat.o(17093);
    return i;
  }
  
  private void aMo()
  {
    AppMethodBeat.i(17086);
    if (this.mWO != null)
    {
      ((ImageView)this.mWO.findViewById(2131820993)).getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
      FTSEditTextView localFTSEditTextView = (FTSEditTextView)this.mWO.findViewById(2131824308);
      localFTSEditTextView.getIconView().setImageResource(2131230921);
      ((ImageButton)localFTSEditTextView.findViewById(2131820991)).getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
      localFTSEditTextView.getEditText().setHintTextColor(getResources().getColor(2131690205));
      localFTSEditTextView.getEditText().setTextColor(-16777216);
      q.b(this);
      this.mWO.setImageSearchListener(this);
    }
    AppMethodBeat.o(17086);
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    int i = 8;
    AppMethodBeat.i(17091);
    if (!TextUtils.isEmpty(paramString2)) {
      this.iOB.setVisibility(8);
    }
    Object localObject;
    boolean bool;
    if (this.iOF == 1)
    {
      localObject = this.mWO;
      bool = TextUtils.isEmpty(paramString1);
      if (((com.tencent.mm.plugin.fts.ui.widget.a)localObject).nbt != null) {
        break label91;
      }
      ab.i("MicroMsg.FTS.FTSSearchView", "showImageSearchButton imageSearchBtn is null");
    }
    try
    {
      for (;;)
      {
        this.igU.i(10001, null);
        super.a(paramString1, paramString2, paramList, paramb);
        AppMethodBeat.o(17091);
        return;
        label91:
        localObject = ((com.tencent.mm.plugin.fts.ui.widget.a)localObject).nbt;
        if (bool) {
          i = 0;
        }
        ((View)localObject).setVisibility(i);
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppBrandSearchUI", "refresh keyword id error : %s", new Object[] { localRemoteException });
      }
    }
  }
  
  public final void aMf()
  {
    AppMethodBeat.i(17085);
    super.aMf();
    aMo();
    AppMethodBeat.o(17085);
  }
  
  public final int aMg()
  {
    AppMethodBeat.i(17088);
    if ((Build.VERSION.SDK_INT >= 23) && ((!com.tencent.mm.compatible.util.h.Mn()) || (!AppBrandNearbyWebViewUI.Mo())))
    {
      af.a(getWindow(), true);
      AppMethodBeat.o(17088);
      return -855310;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      i = com.tencent.mm.plugin.appbrand.aa.gSb;
      AppMethodBeat.o(17088);
      return i;
    }
    int i = super.aMg();
    AppMethodBeat.o(17088);
    return i;
  }
  
  public final boolean aMm()
  {
    AppMethodBeat.i(17090);
    this.iOB.setVisibility(8);
    boolean bool = super.aMm();
    AppMethodBeat.o(17090);
    return bool;
  }
  
  public final com.tencent.mm.plugin.fts.ui.widget.a dd(Context paramContext)
  {
    AppMethodBeat.i(153487);
    this.iOF = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lVx, 0);
    this.iOF = 0;
    if (this.iOF == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramContext = new com.tencent.mm.plugin.fts.ui.widget.a(paramContext, bool);
      AppMethodBeat.o(153487);
      return paramContext;
    }
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(17092);
    super.dealContentView(paramView);
    this.iOC = getIntent().getStringExtra("key_nearby_url");
    getIntent().getStringExtra("key_nearby_list_id");
    this.iOB = getLayoutInflater().inflate(2130968734, (ViewGroup)paramView, false);
    View localView1 = this.iOB.findViewById(2131821400);
    localView1.setOnClickListener(new AppBrandSearchUI.1(this));
    if (TextUtils.isEmpty(this.iOC))
    {
      localView1.setVisibility(8);
      this.iOB.setVisibility(8);
    }
    while ((paramView instanceof FrameLayout))
    {
      ((FrameLayout)paramView).addView(this.iOB);
      AppMethodBeat.o(17092);
      return;
      localView1.setVisibility(0);
      this.iOB.setVisibility(0);
    }
    paramView = paramView.getLayoutParams();
    int k;
    Rect localRect;
    int i;
    if (getWindow().hasFeature(9))
    {
      localView1 = this.iOB;
      k = this.iOB.getPaddingLeft();
      localRect = new Rect();
      int j = getActionBarHeight();
      View localView2 = getWindow().getDecorView();
      localView2.getWindowVisibleDisplayFrame(localRect);
      int m = localView2.getHeight();
      int[] arrayOfInt = new int[2];
      localView2.getLocationOnScreen(arrayOfInt);
      i = j;
      if (m == 0) {
        i = j + aMn();
      }
      if ((m - localRect.height() < 0) || (arrayOfInt[1] <= 200)) {
        break label321;
      }
      i += m - localRect.height();
    }
    for (;;)
    {
      localView1.setPadding(k, i + this.iOB.getPaddingTop(), this.iOB.getPaddingRight(), this.iOB.getPaddingBottom());
      addContentView(this.iOB, paramView);
      AppMethodBeat.o(17092);
      return;
      label321:
      i += localRect.top;
    }
  }
  
  public final String getHint()
  {
    AppMethodBeat.i(17095);
    String str = getIntent().getStringExtra("key_search_place_holder");
    if ((str != null) && (str.length() > 0))
    {
      AppMethodBeat.o(17095);
      return str;
    }
    str = super.getHint();
    AppMethodBeat.o(17095);
    return str;
  }
  
  public void initView()
  {
    AppMethodBeat.i(17084);
    super.initView();
    setActionbarColor(-855310);
    aMo();
    AppMethodBeat.o(17084);
  }
  
  public final void l(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(17094);
    super.l(paramInt, paramBundle);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(17094);
      return;
      String str = paramBundle.getString("fts_key_json_data");
      paramInt = paramBundle.getInt("fts_key_is_cache_data", 0);
      int i = paramBundle.getInt("fts_key_is_expired", 1);
      int j = paramBundle.getInt("fts_key_is_preload", 0);
      this.handler.post(new AppBrandSearchUI.2(this, str, paramInt, i, j));
    }
  }
  
  public void onClickSearchButton(View paramView)
  {
    AppMethodBeat.i(153488);
    ab.i("MicroMsg.AppBrandSearchUI", "onClickSearchButton");
    paramView = new AppBrandStatObject();
    paramView.scene = 1132;
    ((j)g.E(j.class)).a(getContext(), "gh_6a9e987117da@app", null, 0, 0, "Search/image/camera.html", paramView);
    AppMethodBeat.o(153488);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(17083);
    super.onCreate(paramBundle);
    if (getIntent() == null)
    {
      finish();
      AppMethodBeat.o(17083);
      return;
    }
    com.tencent.mm.plugin.websearch.api.aa.Jg(r.aLx());
    this.iOD = getIntent().getStringExtra("key_session_id");
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    ab.i("MicroMsg.AppBrandSearchUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", new Object[] { this.iOD });
    com.tencent.mm.plugin.report.service.h.qsU.e(13929, new Object[] { this.iOD, "", Integer.valueOf(1), Integer.valueOf(this.scene) });
    paramBundle = new Intent();
    paramBundle.putExtra("key_session_id", this.iOD);
    paramBundle.putExtra("ftsbizscene", this.scene);
    setResult(-1, paramBundle);
    if (getIntent().getBooleanExtra("key_alpha_in", false)) {
      overridePendingTransition(2131034125, 2131034130);
    }
    AppMethodBeat.o(17083);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(17089);
    if ((this.scene == 3) || (this.scene == 16)) {
      com.tencent.mm.plugin.report.service.h.qsU.e(13929, new Object[] { this.iOD, b.fpR, Integer.valueOf(2), Integer.valueOf(this.scene) });
    }
    super.onDestroy();
    AppMethodBeat.o(17089);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(17087);
    super.onResume();
    try
    {
      if (((com.tencent.mm.kernel.b.h)g.RI().Rj()).SD())
      {
        Intent localIntent = new Intent();
        localIntent.setComponent(new ComponentName(e.k.iXz, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        localIntent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        sendBroadcast(localIntent);
      }
      AppMethodBeat.o(17087);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(17087);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI
 * JD-Core Version:    0.7.0.1
 */