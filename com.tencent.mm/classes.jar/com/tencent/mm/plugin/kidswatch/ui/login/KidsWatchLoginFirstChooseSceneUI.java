package com.tencent.mm.plugin.kidswatch.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.kidswatch.a.b;
import com.tencent.mm.plugin.kidswatch.model.c.a;
import com.tencent.mm.plugin.kidswatch.model.c.b;
import com.tencent.mm.plugin.kidswatch.model.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.l;

@com.tencent.mm.ui.base.a(35)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "deviceName", "kidsCount", "", "loginUrl", "okSessionList", "option", "radius", "doLoginOK", "", "loginScene", "finish", "", "getForceOrientation", "getLayoutId", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateCB", "plugin-kidswatch_release"})
public final class KidsWatchLoginFirstChooseSceneUI
  extends MMActivity
  implements i
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private String dZW;
  private String deviceName;
  private int option;
  private final int radius;
  private String yBa;
  private int yBh;
  
  public KidsWatchLoginFirstChooseSceneUI()
  {
    AppMethodBeat.i(256280);
    this.TAG = "MicroMsg.KidsWatchLoginFirstChooseSceneUI";
    this.radius = at.fromDPToPix((Context)getContext(), 16);
    AppMethodBeat.o(256280);
  }
  
  private final boolean ab(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(256277);
    Log.i(this.TAG, "doLoginOK, login:" + paramString1 + ", okSession:" + paramString2 + ", scene:" + paramInt);
    com.tencent.mm.kernel.g.azz().a(972, (i)this);
    paramString1 = new com.tencent.mm.plugin.kidswatch.model.g(paramString1, paramString2, paramInt, null);
    com.tencent.mm.kernel.g.azz().b((q)paramString1);
    AppMethodBeat.o(256277);
    return true;
  }
  
  private final void ebX()
  {
    int j = 0;
    AppMethodBeat.i(256276);
    WeImageView localWeImageView = (WeImageView)_$_findCachedViewById(2131303770);
    if (localWeImageView != null)
    {
      if (this.option == 0)
      {
        i = 0;
        localWeImageView.setVisibility(i);
      }
    }
    else
    {
      localWeImageView = (WeImageView)_$_findCachedViewById(2131303774);
      if (localWeImageView == null) {
        break label82;
      }
      if (this.option != 1) {
        break label76;
      }
    }
    label76:
    for (int i = j;; i = 8)
    {
      localWeImageView.setVisibility(i);
      AppMethodBeat.o(256276);
      return;
      i = 8;
      break;
    }
    label82:
    AppMethodBeat.o(256276);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(256284);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(256284);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(256283);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(256283);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(256273);
    super.finish();
    overridePendingTransition(2130771986, 2130772130);
    AppMethodBeat.o(256273);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return 2131495135;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(256275);
    this.dZW = getIntent().getStringExtra("intent.key.login.url");
    this.yBh = getIntent().getIntExtra("intent.key.kids.cnt", 0);
    this.deviceName = getIntent().getStringExtra("intent.key.device.name");
    this.yBa = getIntent().getStringExtra("intent.key.ok.session.list");
    ((KidsWatchHeadComponent)_$_findCachedViewById(2131302263)).setCloseIconResId(2131230855);
    ((KidsWatchHeadComponent)_$_findCachedViewById(2131302263)).setCloseBtnCallBack((kotlin.g.a.a)new KidsWatchLoginFirstChooseSceneUI.a(this));
    String str = z.aTY();
    ((RoundCornerImageView)_$_findCachedViewById(2131297120)).ly(this.radius, this.radius);
    Object localObject = com.tencent.mm.aj.c.Mc(str);
    if (localObject == null)
    {
      com.tencent.mm.aj.p.aYn();
      localObject = e.Mn(str);
    }
    for (;;)
    {
      if (localObject != null) {
        ((RoundCornerImageView)_$_findCachedViewById(2131297120)).setImageBitmap((Bitmap)localObject);
      }
      localObject = (WeImageView)_$_findCachedViewById(2131303770);
      if (localObject != null) {}
      for (localObject = ((WeImageView)localObject).getParent(); localObject == null; localObject = null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(256275);
        throw ((Throwable)localObject);
      }
      ((View)localObject).setOnClickListener((View.OnClickListener)new KidsWatchLoginFirstChooseSceneUI.b(this));
      localObject = (WeImageView)_$_findCachedViewById(2131303774);
      if (localObject != null) {}
      for (localObject = ((WeImageView)localObject).getParent(); localObject == null; localObject = null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(256275);
        throw ((Throwable)localObject);
      }
      ((View)localObject).setOnClickListener((View.OnClickListener)new KidsWatchLoginFirstChooseSceneUI.c(this));
      ebX();
      localObject = (LinearLayout)_$_findCachedViewById(2131299661);
      if (localObject != null) {
        ((LinearLayout)localObject).setOnClickListener((View.OnClickListener)new KidsWatchLoginFirstChooseSceneUI.d(this));
      }
      ((Button)_$_findCachedViewById(2131303771)).setOnClickListener((View.OnClickListener)new KidsWatchLoginFirstChooseSceneUI.e(this));
      localObject = com.tencent.mm.plugin.kidswatch.b.a.yBL;
      localObject = getContext();
      kotlin.g.b.p.g(localObject, "context");
      com.tencent.mm.plugin.kidswatch.b.a.a((Context)localObject, (LinearLayout)_$_findCachedViewById(2131298013), (LinearLayout)_$_findCachedViewById(2131297654));
      AppMethodBeat.o(256275);
      return;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(256278);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 30846)
    {
      Log.i(this.TAG, "onActivityResult, " + paramInt1 + ", " + paramInt2);
      if (paramInt2 == -1)
      {
        paramIntent = this.dZW;
        if (paramIntent == null) {
          kotlin.g.b.p.hyc();
        }
        ab(paramIntent, this.yBa, this.option);
      }
    }
    AppMethodBeat.o(256278);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(256274);
    super.onBackPressed();
    finish();
    AppMethodBeat.o(256274);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256272);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      kotlin.g.b.p.hyc();
    }
    paramBundle.hide();
    setSelfNavigationBarVisible(8);
    paramBundle = getContext();
    kotlin.g.b.p.g(paramBundle, "context");
    setActionbarColor(paramBundle.getResources().getColor(2131099846));
    paramBundle = getContext();
    kotlin.g.b.p.g(paramBundle, "context");
    setNavigationbarColor(paramBundle.getResources().getColor(2131099846));
    setMMTitle("");
    initView();
    overridePendingTransition(2130772132, 2130771986);
    AppMethodBeat.o(256272);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(256279);
    Log.i(this.TAG, "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    c.a locala;
    String str;
    if ((paramq instanceof com.tencent.mm.plugin.kidswatch.model.g))
    {
      Log.i(this.TAG, "onSceneEnd type[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.kidswatch.model.g)paramq).getType()) });
      com.tencent.mm.kernel.g.azz().b(972, (i)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.option == 0)
        {
          Log.i(this.TAG, "top");
          paramString = com.tencent.mm.plugin.kidswatch.model.c.yAF;
          paramString = c.a.yAG;
          paramq = this.dZW;
          if (paramq == null) {
            kotlin.g.b.p.hyc();
          }
          com.tencent.mm.plugin.kidswatch.model.c.a(paramString, paramq, c.c.yAP, c.b.yAJ, this.yBh, paramInt2);
        }
        for (paramInt1 = 2131762084;; paramInt1 = 2131762085)
        {
          paramString = getContext().getString(paramInt1);
          kotlin.g.b.p.g(paramString, "context.getString(toastTip)");
          Log.i(this.TAG, "Tips: ".concat(String.valueOf(paramString)));
          u.cG((Context)getContext(), paramString);
          paramString = com.tencent.mm.plugin.kidswatch.b.a.yBL;
          paramString = getContext();
          kotlin.g.b.p.g(paramString, "context");
          com.tencent.mm.plugin.kidswatch.b.a.h((Context)paramString, "", true);
          AppMethodBeat.o(256279);
          return;
          paramString = com.tencent.mm.plugin.kidswatch.model.c.yAF;
          paramString = c.a.yAG;
          paramq = this.dZW;
          if (paramq == null) {
            kotlin.g.b.p.hyc();
          }
          com.tencent.mm.plugin.kidswatch.model.c.a(paramString, paramq, c.c.yAQ, c.b.yAJ, this.yBh, paramInt2);
        }
      }
      if ((paramInt1 == 4) && (paramInt2 == a.b.yAr.value))
      {
        Log.i(this.TAG, "showBlockBySpam");
        y.g((Context)this, paramString, 30846);
        AppMethodBeat.o(256279);
        return;
      }
      paramq = com.tencent.mm.plugin.kidswatch.model.c.yAF;
      locala = c.a.yAG;
      str = this.dZW;
      if (str == null) {
        kotlin.g.b.p.hyc();
      }
      if (this.option != 0) {
        break label423;
      }
    }
    label423:
    for (paramq = c.c.yAP;; paramq = c.c.yAQ)
    {
      com.tencent.mm.plugin.kidswatch.model.c.a(locala, str, paramq, c.b.yAM, this.yBh, paramInt2);
      paramq = com.tencent.mm.plugin.kidswatch.b.a.yBL;
      paramq = getContext();
      kotlin.g.b.p.g(paramq, "context");
      com.tencent.mm.plugin.kidswatch.b.a.c((Context)paramq, paramInt2, paramString);
      AppMethodBeat.o(256279);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchLoginFirstChooseSceneUI
 * JD-Core Version:    0.7.0.1
 */