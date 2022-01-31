package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.protocal.protobuf.gc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;

@a(3)
public class AppBrandIDCardUI
  extends MMActivity
{
  public static final int iQr = 2131820557;
  private String appId;
  private int fme;
  private AppBrandIDCardUI.a iQb;
  public MMFragment iQs;
  private ccl iQt;
  private gc iQu;
  private LinkedList<Integer> iQv;
  private String iQw;
  private String iQx;
  private p iQy;
  
  public AppBrandIDCardUI()
  {
    AppMethodBeat.i(133238);
    this.iQb = new AppBrandIDCardUI.1(this);
    AppMethodBeat.o(133238);
  }
  
  private static LinkedList<Integer> G(Bundle paramBundle)
  {
    AppMethodBeat.i(133244);
    LinkedList localLinkedList = new LinkedList();
    try
    {
      paramBundle = paramBundle.getString("intent_category_id");
      ab.i("MicroMsg.AppBrandIDCardUI", "[processCategoryId] categoryIdStr:%s", new Object[] { paramBundle });
      paramBundle = new JSONArray(paramBundle);
      int i = 0;
      while (i < paramBundle.length())
      {
        localLinkedList.add(Integer.valueOf(paramBundle.optInt(i)));
        i += 1;
      }
      AppMethodBeat.o(133244);
      return localLinkedList;
    }
    catch (JSONException paramBundle)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandIDCardUI", paramBundle, "", new Object[0]);
      AppMethodBeat.o(133244);
    }
    return null;
  }
  
  private void aMA()
  {
    AppMethodBeat.i(133245);
    ab.i("MicroMsg.AppBrandIDCardUI", "switchToShowFragment");
    this.iQs = new AppBrandIDCardShowFrag();
    ((AppBrandIDCardShowFrag)this.iQs).iQb = this.iQb;
    getSupportFragmentManager().beginTransaction().b(iQr, this.iQs).commitAllowingStateLoss();
    AppMethodBeat.o(133245);
  }
  
  private void back()
  {
    AppMethodBeat.i(133242);
    if ((this.iQs instanceof AppBrandIDCardVerifyPwdFrag))
    {
      aMA();
      AppMethodBeat.o(133242);
      return;
    }
    finish();
    AppMethodBeat.o(133242);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(133241);
    back();
    AppMethodBeat.o(133241);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(133240);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    if (paramBundle == null)
    {
      ab.e("MicroMsg.AppBrandIDCardUI", "bundle is null, return");
      finish();
      AppMethodBeat.o(133240);
      return;
    }
    this.appId = paramBundle.getString("intent_appid", "");
    if (bo.isNullOrNil(this.appId))
    {
      ab.e("MicroMsg.AppBrandIDCardUI", "appId is null, return");
      finish();
      AppMethodBeat.o(133240);
      return;
    }
    this.iQv = G(paramBundle);
    if ((bo.es(this.iQv)) || (this.iQv.size() <= 0))
    {
      ab.e("MicroMsg.AppBrandIDCardUI", "categoryId is null, return");
      paramBundle = new Intent();
      paramBundle.putExtra("intent_err_code", 40003);
      paramBundle.putExtra("intent_err_msg", "category_id is null");
      setResult(1, paramBundle);
      finish();
      AppMethodBeat.o(133240);
      return;
    }
    this.fme = paramBundle.getInt("intent_auth_type", 1);
    getContentView().setBackgroundColor(getResources().getColor(2131690316));
    paramBundle = new ViewGroup.LayoutParams(-1, -1);
    FrameLayout localFrameLayout = new FrameLayout(this);
    localFrameLayout.setId(iQr);
    ((ViewGroup)getContentView()).addView(localFrameLayout, paramBundle);
    setBackBtn(new AppBrandIDCardUI.2(this));
    getString(2131297087);
    this.iQy = h.b(this, getString(2131301086), true, new AppBrandIDCardUI.3(this));
    this.iQy.show();
    this.iQb.aMB();
    if (isSupportNavigationSwipeBack()) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    AppMethodBeat.o(133240);
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(133239);
    super.onCreateBeforeSetContentView();
    getWindow().requestFeature(10);
    getWindow().getDecorView().setFitsSystemWindows(true);
    supportRequestWindowFeature(10);
    supportRequestWindowFeature(1);
    AppMethodBeat.o(133239);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(133243);
    back();
    AppMethodBeat.o(133243);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI
 * JD-Core Version:    0.7.0.1
 */