package com.tencent.mm.plugin.appbrand.ui;

import android.content.ComponentName;
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
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.a;
import com.tencent.mm.plugin.fts.ui.widget.a.b;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.e.i;
import java.lang.reflect.Field;
import java.util.List;

public class AppBrandSearchUI
  extends FTSSearchTabWebViewUI
{
  private View hdQ;
  private String hdR;
  private String hdS;
  private int scene;
  
  private int apc()
  {
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = bk.getInt(localClass.getField("status_bar_height").get(localObject).toString(), 0);
      i = getResources().getDimensionPixelSize(i);
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  private void apd()
  {
    if (this.kAW != null)
    {
      ((ImageView)this.kAW.findViewById(R.h.ab_back_btn)).getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
      FTSEditTextView localFTSEditTextView = (FTSEditTextView)this.kAW.findViewById(R.h.fts_edittext);
      localFTSEditTextView.getIconView().setImageResource(R.k.appbrand_actionbar_search_view_icon_black);
      ((ImageButton)localFTSEditTextView.findViewById(R.h.clear_btn)).getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
      localFTSEditTextView.getEditText().setHintTextColor(getResources().getColor(R.e.light_bg_hint_color));
      localFTSEditTextView.getEditText().setTextColor(-16777216);
      m.b(this);
    }
  }
  
  public final void a(String paramString1, String paramString2, List<a.b> paramList, FTSEditTextView.b paramb)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      this.hdQ.setVisibility(8);
    }
    try
    {
      this.gGn.f(10001, null);
      super.a(paramString1, paramString2, paramList, paramb);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        y.e("MicroMsg.AppBrandSearchUI", "refresh keyword id error : %s", new Object[] { localRemoteException });
      }
    }
  }
  
  protected final void aoX()
  {
    super.aoX();
    apd();
  }
  
  protected final int aoY()
  {
    if ((Build.VERSION.SDK_INT >= 23) && ((!com.tencent.mm.compatible.util.h.zK()) || (!AppBrandNearbyWebViewUI.zL())))
    {
      ak.g(getWindow());
      return -855310;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      return v.fAu;
    }
    return super.aoY();
  }
  
  public final boolean apb()
  {
    this.hdQ.setVisibility(8);
    return super.apb();
  }
  
  protected final void dealContentView(View paramView)
  {
    super.dealContentView(paramView);
    this.hdR = getIntent().getStringExtra("key_nearby_url");
    getIntent().getStringExtra("key_nearby_list_id");
    this.hdQ = getLayoutInflater().inflate(R.i.app_brand_search_ui_recommend_page, (ViewGroup)paramView, false);
    View localView1 = this.hdQ.findViewById(R.h.nearbyV);
    localView1.setOnClickListener(new AppBrandSearchUI.1(this));
    if (TextUtils.isEmpty(this.hdR))
    {
      localView1.setVisibility(8);
      this.hdQ.setVisibility(8);
    }
    while ((paramView instanceof FrameLayout))
    {
      ((FrameLayout)paramView).addView(this.hdQ);
      return;
      localView1.setVisibility(0);
      this.hdQ.setVisibility(0);
    }
    paramView = paramView.getLayoutParams();
    int k;
    Rect localRect;
    int i;
    if (getWindow().hasFeature(9))
    {
      localView1 = this.hdQ;
      k = this.hdQ.getPaddingLeft();
      localRect = new Rect();
      int j = getActionBarHeight();
      View localView2 = getWindow().getDecorView();
      localView2.getWindowVisibleDisplayFrame(localRect);
      int m = localView2.getHeight();
      int[] arrayOfInt = new int[2];
      localView2.getLocationOnScreen(arrayOfInt);
      i = j;
      if (m == 0) {
        i = j + apc();
      }
      if ((m - localRect.height() < 0) || (arrayOfInt[1] <= 200)) {
        break label303;
      }
      i += m - localRect.height();
    }
    for (;;)
    {
      localView1.setPadding(k, i + this.hdQ.getPaddingTop(), this.hdQ.getPaddingRight(), this.hdQ.getPaddingBottom());
      addContentView(this.hdQ, paramView);
      return;
      label303:
      i += localRect.top;
    }
  }
  
  protected final String getHint()
  {
    String str = getIntent().getStringExtra("key_search_place_holder");
    if ((str != null) && (str.length() > 0)) {
      return str;
    }
    return super.getHint();
  }
  
  protected final void i(int paramInt, Bundle paramBundle)
  {
    super.i(paramInt, paramBundle);
    switch (paramInt)
    {
    default: 
      return;
    }
    String str = paramBundle.getString("fts_key_json_data");
    paramInt = paramBundle.getInt("fts_key_is_cache_data", 0);
    int i = paramBundle.getInt("fts_key_is_expired", 1);
    this.handler.post(new AppBrandSearchUI.2(this, str, paramInt, i));
  }
  
  protected final void initView()
  {
    super.initView();
    ta(-855310);
    apd();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent() == null) {
      finish();
    }
    do
    {
      return;
      this.hdS = getIntent().getStringExtra("key_session_id");
      this.scene = getIntent().getIntExtra("ftsbizscene", 0);
      y.i("MicroMsg.AppBrandSearchUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", new Object[] { this.hdS });
      com.tencent.mm.plugin.report.service.h.nFQ.f(13929, new Object[] { this.hdS, "", Integer.valueOf(1), Integer.valueOf(this.scene) });
      paramBundle = new Intent();
      paramBundle.putExtra("key_session_id", this.hdS);
      paramBundle.putExtra("ftsbizscene", this.scene);
      setResult(-1, paramBundle);
    } while (!getIntent().getBooleanExtra("key_alpha_in", false));
    overridePendingTransition(R.a.alpha_in, R.a.anim_not_change);
  }
  
  public void onDestroy()
  {
    if ((this.scene == 3) || (this.scene == 16)) {
      com.tencent.mm.plugin.report.service.h.nFQ.f(13929, new Object[] { this.hdS, b.dZM, Integer.valueOf(2), Integer.valueOf(this.scene) });
    }
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    try
    {
      if (((com.tencent.mm.kernel.b.h)g.DM().Dr()).Ex())
      {
        Intent localIntent = new Intent();
        localIntent.setComponent(new ComponentName(e.i.hle, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        localIntent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        sendBroadcast(localIntent);
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI
 * JD-Core Version:    0.7.0.1
 */