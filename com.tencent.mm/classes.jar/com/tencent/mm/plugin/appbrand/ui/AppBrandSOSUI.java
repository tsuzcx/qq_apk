package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSMoreWebViewUI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.List;

public class AppBrandSOSUI
  extends FTSSOSMoreWebViewUI
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
        y.e("MicroMsg.AppBrandSOSUI", "refresh keyword id error : %s", new Object[] { localRemoteException });
      }
    }
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
    localView1.setOnClickListener(new AppBrandSOSUI.1(this));
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
        break label301;
      }
      i += m - localRect.height();
    }
    for (;;)
    {
      localView1.setPadding(k, i + this.hdQ.getPaddingTop(), this.hdQ.getPaddingRight(), this.hdQ.getPaddingBottom());
      addContentView(this.hdQ, paramView);
      return;
      label301:
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    overridePendingTransition(R.a.pop_in, 0);
    this.hdS = getIntent().getStringExtra("key_session_id");
    this.scene = getIntent().getIntExtra("ftsbizscene", 0);
    y.i("MicroMsg.AppBrandSOSUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", new Object[] { this.hdS });
    h.nFQ.f(13929, new Object[] { this.hdS, "", Integer.valueOf(1), Integer.valueOf(this.scene) });
    paramBundle = new Intent();
    paramBundle.putExtra("key_session_id", this.hdS);
    paramBundle.putExtra("ftsbizscene", this.scene);
    setResult(-1, paramBundle);
  }
  
  public void onDestroy()
  {
    if ((this.scene == 3) || (this.scene == 16)) {
      h.nFQ.f(13929, new Object[] { this.hdS, b.dZM, Integer.valueOf(2), Integer.valueOf(this.scene) });
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandSOSUI
 * JD-Core Version:    0.7.0.1
 */