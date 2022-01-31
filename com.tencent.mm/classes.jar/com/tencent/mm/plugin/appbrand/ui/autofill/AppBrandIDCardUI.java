package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.j;
import android.support.v4.app.o;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.protocal.c.bsa;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;

public class AppBrandIDCardUI
  extends DrawStatusBarActivity
{
  public static final int hfd = y.g.app_brand_idcard_container;
  private String appId;
  private int dVU;
  private p gIZ;
  private AppBrandIDCardUI.a heO = new AppBrandIDCardUI.1(this);
  public x hfe;
  private bsa hff;
  private ey hfg;
  private LinkedList<Integer> hfh;
  private String hfi;
  private String hfj;
  
  private void apk()
  {
    y.i("MicroMsg.AppBrandIDCardUI", "switchToShowFragment");
    this.hfe = new a();
    ((a)this.hfe).heO = this.heO;
    getSupportFragmentManager().bP().b(hfd, this.hfe).commit();
  }
  
  private void back()
  {
    if ((this.hfe instanceof b))
    {
      apk();
      return;
    }
    finish();
  }
  
  private static LinkedList<Integer> z(Bundle paramBundle)
  {
    LinkedList localLinkedList = new LinkedList();
    try
    {
      paramBundle = paramBundle.getString("intent_category_id");
      y.i("MicroMsg.AppBrandIDCardUI", "[processCategoryId] categoryIdStr:%s", new Object[] { paramBundle });
      JSONArray localJSONArray = new JSONArray(paramBundle);
      int i = 0;
      for (;;)
      {
        paramBundle = localLinkedList;
        if (i >= localJSONArray.length()) {
          break;
        }
        localLinkedList.add(Integer.valueOf(localJSONArray.optInt(i)));
        i += 1;
      }
      return paramBundle;
    }
    catch (JSONException paramBundle)
    {
      y.printErrStackTrace("MicroMsg.AppBrandIDCardUI", paramBundle, "", new Object[0]);
      paramBundle = null;
    }
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public final boolean noActionBar()
  {
    return true;
  }
  
  public void onBackPressed()
  {
    back();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    if (paramBundle == null)
    {
      y.e("MicroMsg.AppBrandIDCardUI", "bundle is null, return");
      finish();
    }
    do
    {
      return;
      this.appId = paramBundle.getString("intent_appid", "");
      if (bk.bl(this.appId))
      {
        y.e("MicroMsg.AppBrandIDCardUI", "appId is null, return");
        finish();
        return;
      }
      this.hfh = z(paramBundle);
      if ((bk.dk(this.hfh)) || (this.hfh.size() <= 0))
      {
        y.e("MicroMsg.AppBrandIDCardUI", "categoryId is null, return");
        paramBundle = new Intent();
        paramBundle.putExtra("intent_err_code", 40003);
        paramBundle.putExtra("intent_err_msg", "category_id is null");
        setResult(1, paramBundle);
        finish();
        return;
      }
      this.dVU = paramBundle.getInt("intent_auth_type", 1);
      this.mController.contentView.setBackgroundColor(-855310);
      paramBundle = new ViewGroup.LayoutParams(-1, -1);
      FrameLayout localFrameLayout = new FrameLayout(this);
      localFrameLayout.setId(hfd);
      ((ViewGroup)this.mController.contentView).addView(localFrameLayout, paramBundle);
      setBackBtn(new AppBrandIDCardUI.2(this));
      getString(y.j.app_tip);
      this.gIZ = h.b(this, getString(y.j.loading_tips), true, new AppBrandIDCardUI.3(this));
      this.gIZ.show();
      this.heO.apl();
    } while (!isSupportNavigationSwipeBack());
    getSwipeBackLayout().setEnableGesture(false);
  }
  
  protected final void onCreateBeforeSetContentView()
  {
    super.onCreateBeforeSetContentView();
    getWindow().requestFeature(10);
    getWindow().getDecorView().setFitsSystemWindows(true);
    supportRequestWindowFeature(10);
    supportRequestWindowFeature(1);
  }
  
  public void onSwipeBack()
  {
    back();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI
 * JD-Core Version:    0.7.0.1
 */