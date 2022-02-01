package com.tencent.mm.plugin.kidswatch.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.d;
import com.tencent.mm.am.f;
import com.tencent.mm.an.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.kidswatch.a.b;
import com.tencent.mm.plugin.kidswatch.b.a;
import com.tencent.mm.plugin.kidswatch.b.b;
import com.tencent.mm.plugin.kidswatch.b.d;
import com.tencent.mm.plugin.kidswatch.b.e;
import com.tencent.mm.plugin.kidswatch.b.f;
import com.tencent.mm.plugin.kidswatch.b.h;
import com.tencent.mm.plugin.kidswatch.model.c;
import com.tencent.mm.plugin.kidswatch.model.c.a;
import com.tencent.mm.plugin.kidswatch.model.c.b;
import com.tencent.mm.plugin.kidswatch.model.c.c;
import com.tencent.mm.plugin.kidswatch.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(35)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/kidswatch/ui/login/KidsWatchLoginFirstChooseSceneUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "deviceName", "kidsCount", "", "loginUrl", "okSessionList", "option", "radius", "doLoginOK", "", "loginScene", "finish", "", "getForceOrientation", "getLayoutId", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateCB", "plugin-kidswatch_release"})
public final class KidsWatchLoginFirstChooseSceneUI
  extends MMActivity
  implements i
{
  private String Ecp;
  private int Ecw;
  private final String TAG;
  private HashMap _$_findViewCache;
  private String deviceName;
  private String fTQ;
  private int option;
  private final int radius;
  
  public KidsWatchLoginFirstChooseSceneUI()
  {
    AppMethodBeat.i(252209);
    this.TAG = "MicroMsg.KidsWatchLoginFirstChooseSceneUI";
    this.radius = aw.fromDPToPix((Context)getContext(), 16);
    AppMethodBeat.o(252209);
  }
  
  private final boolean af(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(252203);
    Log.i(this.TAG, "doLoginOK, login:" + paramString1 + ", okSession:" + paramString2 + ", scene:" + paramInt);
    h.aGY().a(972, (i)this);
    paramString1 = new g(paramString1, paramString2, paramInt, null);
    h.aGY().b((com.tencent.mm.an.q)paramString1);
    AppMethodBeat.o(252203);
    return true;
  }
  
  private final void eKV()
  {
    int j = 0;
    AppMethodBeat.i(252202);
    WeImageView localWeImageView = (WeImageView)_$_findCachedViewById(b.e.EaP);
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
      localWeImageView = (WeImageView)_$_findCachedViewById(b.e.EaT);
      if (localWeImageView == null) {
        break label84;
      }
      if (this.option != 1) {
        break label78;
      }
    }
    label78:
    for (int i = j;; i = 8)
    {
      localWeImageView.setVisibility(i);
      AppMethodBeat.o(252202);
      return;
      i = 8;
      break;
    }
    label84:
    AppMethodBeat.o(252202);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252217);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252217);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252215);
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
    AppMethodBeat.o(252215);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(252195);
    super.finish();
    overridePendingTransition(b.a.anim_not_change, b.a.push_down_out);
    AppMethodBeat.o(252195);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.f.Ebl;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(252200);
    this.fTQ = getIntent().getStringExtra("intent.key.login.url");
    this.Ecw = getIntent().getIntExtra("intent.key.kids.cnt", 0);
    this.deviceName = getIntent().getStringExtra("intent.key.device.name");
    this.Ecp = getIntent().getStringExtra("intent.key.ok.session.list");
    ((KidsWatchHeadComponent)_$_findCachedViewById(b.e.EaG)).setCloseIconResId(b.d.actionbar_icon_dark_back);
    ((KidsWatchHeadComponent)_$_findCachedViewById(b.e.EaG)).setCloseBtnCallBack((kotlin.g.a.a)new KidsWatchLoginFirstChooseSceneUI.a(this));
    String str = z.bcZ();
    ((RoundCornerImageView)_$_findCachedViewById(b.e.dsd)).mQ(this.radius, this.radius);
    Object localObject = d.Tx(str);
    if (localObject == null)
    {
      com.tencent.mm.am.q.bhz();
      localObject = f.TI(str);
    }
    for (;;)
    {
      if (localObject != null) {
        ((RoundCornerImageView)_$_findCachedViewById(b.e.dsd)).setImageBitmap((Bitmap)localObject);
      }
      localObject = (WeImageView)_$_findCachedViewById(b.e.EaP);
      if (localObject != null) {}
      for (localObject = ((WeImageView)localObject).getParent(); localObject == null; localObject = null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(252200);
        throw ((Throwable)localObject);
      }
      ((View)localObject).setOnClickListener((View.OnClickListener)new KidsWatchLoginFirstChooseSceneUI.b(this));
      localObject = (WeImageView)_$_findCachedViewById(b.e.EaT);
      if (localObject != null) {}
      for (localObject = ((WeImageView)localObject).getParent(); localObject == null; localObject = null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(252200);
        throw ((Throwable)localObject);
      }
      ((View)localObject).setOnClickListener((View.OnClickListener)new KidsWatchLoginFirstChooseSceneUI.c(this));
      eKV();
      localObject = (LinearLayout)_$_findCachedViewById(b.e.EaD);
      if (localObject != null) {
        ((LinearLayout)localObject).setOnClickListener((View.OnClickListener)new KidsWatchLoginFirstChooseSceneUI.d(this));
      }
      ((Button)_$_findCachedViewById(b.e.EaQ)).setOnClickListener((View.OnClickListener)new KidsWatchLoginFirstChooseSceneUI.e(this));
      localObject = com.tencent.mm.plugin.kidswatch.b.a.Edb;
      localObject = getContext();
      p.j(localObject, "context");
      com.tencent.mm.plugin.kidswatch.b.a.a((Context)localObject, (LinearLayout)_$_findCachedViewById(b.e.Eax), (LinearLayout)_$_findCachedViewById(b.e.Eav));
      AppMethodBeat.o(252200);
      return;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(252206);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 30846)
    {
      Log.i(this.TAG, "onActivityResult, " + paramInt1 + ", " + paramInt2);
      if (paramInt2 == -1)
      {
        paramIntent = this.fTQ;
        if (paramIntent == null) {
          p.iCn();
        }
        af(paramIntent, this.Ecp, this.option);
      }
    }
    AppMethodBeat.o(252206);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(252197);
    super.onBackPressed();
    finish();
    AppMethodBeat.o(252197);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252192);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      p.iCn();
    }
    paramBundle.hide();
    setSelfNavigationBarVisible(8);
    paramBundle = getContext();
    p.j(paramBundle, "context");
    setActionbarColor(paramBundle.getResources().getColor(b.b.Eap));
    paramBundle = getContext();
    p.j(paramBundle, "context");
    setNavigationbarColor(paramBundle.getResources().getColor(b.b.Eap));
    setMMTitle("");
    initView();
    overridePendingTransition(b.a.push_up_in, b.a.anim_not_change);
    AppMethodBeat.o(252192);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(252207);
    Log.i(this.TAG, "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    c.a locala;
    String str;
    if ((paramq instanceof g))
    {
      Log.i(this.TAG, "onSceneEnd type[%d]", new Object[] { Integer.valueOf(((g)paramq).getType()) });
      h.aGY().b(972, (i)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramInt1 = b.h.EbC;
        if (this.option == 0)
        {
          Log.i(this.TAG, "top");
          paramString = c.EbU;
          paramString = c.a.EbV;
          paramq = this.fTQ;
          if (paramq == null) {
            p.iCn();
          }
          c.a(paramString, paramq, c.c.Ece, c.b.EbY, this.Ecw, paramInt2);
        }
        for (;;)
        {
          paramString = getContext().getString(paramInt1);
          p.j(paramString, "context.getString(toastTip)");
          Log.i(this.TAG, "Tips: ".concat(String.valueOf(paramString)));
          w.cR((Context)getContext(), paramString);
          paramString = com.tencent.mm.plugin.kidswatch.b.a.Edb;
          paramString = getContext();
          p.j(paramString, "context");
          com.tencent.mm.plugin.kidswatch.b.a.h((Context)paramString, "", true);
          AppMethodBeat.o(252207);
          return;
          paramInt1 = b.h.EbD;
          paramString = c.EbU;
          paramString = c.a.EbV;
          paramq = this.fTQ;
          if (paramq == null) {
            p.iCn();
          }
          c.a(paramString, paramq, c.c.Ecf, c.b.EbY, this.Ecw, paramInt2);
        }
      }
      if ((paramInt1 == 4) && (paramInt2 == a.b.Eaj.value))
      {
        Log.i(this.TAG, "showBlockBySpam");
        y.f((Context)this, paramString, 30846);
        AppMethodBeat.o(252207);
        return;
      }
      paramq = c.EbU;
      locala = c.a.EbV;
      str = this.fTQ;
      if (str == null) {
        p.iCn();
      }
      if (this.option != 0) {
        break label423;
      }
    }
    label423:
    for (paramq = c.c.Ece;; paramq = c.c.Ecf)
    {
      c.a(locala, str, paramq, c.b.Ecb, this.Ecw, paramInt2);
      paramq = com.tencent.mm.plugin.kidswatch.b.a.Edb;
      paramq = getContext();
      p.j(paramq, "context");
      com.tencent.mm.plugin.kidswatch.b.a.e((Context)paramq, paramInt2, paramString);
      AppMethodBeat.o(252207);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.login.KidsWatchLoginFirstChooseSceneUI
 * JD-Core Version:    0.7.0.1
 */