package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.widget.ai;
import com.tencent.mm.plugin.finder.live.widget.ai.c;
import com.tencent.mm.plugin.finder.live.widget.o;
import com.tencent.mm.protocal.protobuf.elx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.HashMap;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderLivePostHelperUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "exception", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget;", "faceVerifyUrl", "", "precheck", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePrecheckWidget;", "precheckTypeCache", "", "progressBar", "Landroid/widget/ProgressBar;", "finishWithoutTransition", "", "getLayoutId", "gotoFaceVerify", "verifyUrl", "gotoFaceVerifyImpl", "requestCode", "initIntent", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "Companion", "plugin-finder-live_release"})
public final class FinderLivePostHelperUI
  extends MMFinderUI
{
  public static final a ArH;
  private ai ArE;
  private String ArF = "";
  private int ArG;
  private HashMap _$_findViewCache;
  private ProgressBar progressBar;
  private o ybs;
  
  static
  {
    AppMethodBeat.i(233392);
    ArH = new a((byte)0);
    AppMethodBeat.o(233392);
  }
  
  private final void eav()
  {
    AppMethodBeat.i(233391);
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(233391);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(233400);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(233400);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(233399);
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
    AppMethodBeat.o(233399);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_post_helper;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Intent localIntent = null;
    Object localObject = null;
    AppMethodBeat.i(233389);
    Log.i("Finder.FinderLivePostHelperUI", "onActivityResult requestCode:10000, resultCode:".concat(String.valueOf(paramInt2)));
    switch (paramInt1)
    {
    default: 
      paramIntent = this.ArE;
      if (paramIntent == null) {
        p.bGy("precheck");
      }
      switch (paramInt1)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(233389);
      return;
      localIntent = new Intent();
      if (paramIntent != null) {
        localObject = paramIntent.getBundleExtra("result_data");
      }
      if ((paramInt2 == -1) && (localObject != null))
      {
        paramIntent = ((Bundle)localObject).getString("go_next", "");
        localObject = ((Bundle)localObject).getString("result_json");
        if (!Util.isNullOrNil((String)localObject))
        {
          paramInt1 = new i((String)localObject).getInt("code");
          Log.i("Finder.FinderLivePostHelperUI", "onActivityResult nextStep:" + paramIntent + ", code:" + paramInt1);
          if ((p.h(paramIntent, "roomlive_verify")) && (paramInt1 == 0))
          {
            paramIntent = h.aHG();
            p.j(paramIntent, "MMKernel.storage()");
            paramIntent.aHp().set(ar.a.VyG, Boolean.TRUE);
            localIntent.putExtra("FACE_VERIFY_RESULT", 1);
          }
        }
      }
      setResult(-1, localIntent);
      eav();
      AppMethodBeat.o(233389);
      return;
      localObject = localIntent;
      if (paramIntent != null) {
        localObject = paramIntent.getBundleExtra("result_data");
      }
      if ((paramInt2 == -1) && (localObject != null))
      {
        paramIntent = ((Bundle)localObject).getString("go_next", "");
        localObject = ((Bundle)localObject).getString("result_json");
        if (!Util.isNullOrNil((String)localObject))
        {
          paramInt1 = new i((String)localObject).getInt("code");
          Log.i("Finder.FinderLivePostHelperUI", "onActivityResult precheckTypeCache:" + this.ArG + " nextStep:" + paramIntent + ", code:" + paramInt1);
          if ((p.h(paramIntent, "roomlive_verify")) && (paramInt1 == 0))
          {
            paramIntent = this.ArE;
            if (paramIntent == null) {
              p.bGy("precheck");
            }
            paramIntent.Q(true, this.ArG);
            this.ArG = 0;
            AppMethodBeat.o(233389);
            return;
          }
        }
      }
      paramIntent = this.ArE;
      if (paramIntent == null) {
        p.bGy("precheck");
      }
      paramIntent.Q(false, this.ArG);
      this.ArG = 0;
      AppMethodBeat.o(233389);
      return;
      if (paramInt2 == -1)
      {
        localObject = h.aHG();
        p.j(localObject, "MMKernel.storage()");
        ((f)localObject).aHp().set(ar.a.VyY, Boolean.TRUE);
        paramIntent.zqF = true;
        if ((!paramIntent.zqG) && (!paramIntent.zqH) && (!paramIntent.zqI))
        {
          paramIntent = paramIntent.zqw;
          if (paramIntent != null)
          {
            paramIntent.invoke(Boolean.TRUE);
            AppMethodBeat.o(233389);
            return;
          }
          AppMethodBeat.o(233389);
          return;
        }
        paramIntent.dID();
      }
    }
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(233378);
    super.onCreate(paramBundle);
    hideTitleView();
    paramBundle = findViewById(b.f.finder_live_post_forbidden);
    p.j(paramBundle, "findViewById(R.id.finder_live_post_forbidden)");
    this.ybs = new o(paramBundle);
    paramBundle = findViewById(b.f.finder_live_post_precheck);
    p.j(paramBundle, "findViewById(R.id.finder_live_post_precheck)");
    this.ArE = new ai((ViewGroup)paramBundle);
    paramBundle = this.ArE;
    if (paramBundle == null) {
      p.bGy("precheck");
    }
    paramBundle.zqv = ((m)new d(this));
    paramBundle.zqw = ((b)new e(this));
    paramBundle = findViewById(b.f.finder_live_helper_loading_progress_bar);
    p.j(paramBundle, "findViewById(R.id.finder…per_loading_progress_bar)");
    this.progressBar = ((ProgressBar)paramBundle);
    int i = getIntent().getIntExtra("LIVE_HELP_TYPE", 0);
    Log.i("Finder.FinderLivePostHelperUI", "type:".concat(String.valueOf(i)));
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(233378);
      return;
      paramBundle = getIntent().getStringExtra("FACE_VERIFY_URL");
      p.j(paramBundle, "intent.getStringExtra(Co…HelperUI.FACE_VERIFY_URL)");
      this.ArF = paramBundle;
      paramBundle = this.ArF;
      localObject1 = this.ybs;
      if (localObject1 == null) {
        p.bGy("exception");
      }
      Object localObject2 = o.znK;
      o.a((o)localObject1, o.dIe(), null, (b)new b(this, paramBundle), 6);
      AppMethodBeat.o(233378);
      return;
      paramBundle = this.ybs;
      if (paramBundle == null) {
        p.bGy("exception");
      }
      localObject1 = o.znK;
      o.a(paramBundle, o.dId(), null, (b)new c(this), 6);
      AppMethodBeat.o(233378);
      return;
      localObject2 = getIntent().getByteArrayExtra("PRECHECK_SPAMRISK");
      paramBundle = (Bundle)localObject1;
      if (localObject2 != null)
      {
        paramBundle = new elx();
        paramBundle.parseFrom((byte[])localObject2);
      }
      if (paramBundle != null)
      {
        localObject1 = this.ArE;
        if (localObject1 == null) {
          p.bGy("precheck");
        }
        i = getIntent().getIntExtra("PRECHECK_USERFLAG", 0);
        p.k(paramBundle, "spamRisk");
        d.uiThread((a)new ai.c((ai)localObject1, i, paramBundle));
        AppMethodBeat.o(233378);
        return;
      }
      Log.e("Finder.FinderLivePostHelperUI", "LIVE_PRECHECK error, spamRisk is empty!");
      finish();
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(233385);
    super.onPause();
    ProgressBar localProgressBar = this.progressBar;
    if (localProgressBar == null) {
      p.bGy("progressBar");
    }
    localProgressBar.setVisibility(8);
    AppMethodBeat.o(233385);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(233383);
    super.onResume();
    ProgressBar localProgressBar = this.progressBar;
    if (localProgressBar == null) {
      p.bGy("progressBar");
    }
    localProgressBar.setVisibility(8);
    AppMethodBeat.o(233383);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderLivePostHelperUI$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "verify", "", "invoke"})
  static final class b
    extends q
    implements b<Boolean, x>
  {
    b(FinderLivePostHelperUI paramFinderLivePostHelperUI, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ok", "", "invoke"})
  static final class c
    extends q
    implements b<Boolean, x>
  {
    c(FinderLivePostHelperUI paramFinderLivePostHelperUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "verifyUrl", "", "precheckType", "", "invoke", "com/tencent/mm/plugin/finder/ui/FinderLivePostHelperUI$onCreate$1$1"})
  static final class d
    extends q
    implements m<String, Integer, x>
  {
    d(FinderLivePostHelperUI paramFinderLivePostHelperUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ok", "", "invoke", "com/tencent/mm/plugin/finder/ui/FinderLivePostHelperUI$onCreate$1$2"})
  static final class e
    extends q
    implements b<Boolean, x>
  {
    e(FinderLivePostHelperUI paramFinderLivePostHelperUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderLivePostHelperUI
 * JD-Core Version:    0.7.0.1
 */