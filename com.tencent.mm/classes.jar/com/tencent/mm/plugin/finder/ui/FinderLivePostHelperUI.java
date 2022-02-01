package com.tencent.mm.plugin.finder.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.a.adl;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.widget.ax;
import com.tencent.mm.plugin.finder.live.widget.ax.b;
import com.tencent.mm.plugin.finder.live.widget.w;
import com.tencent.mm.protocal.protobuf.fgq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderLivePostHelperUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "exception", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget;", "faceVerifyUrl", "", "precheck", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePrecheckWidget;", "precheckTypeCache", "", "progressBar", "Landroid/widget/ProgressBar;", "realnameNotifyListener", "Lcom/tencent/mm/sdk/event/IListener;", "afterVerify", "", "resultCode", "finishWithoutTransition", "getLayoutId", "goToPayRealNameVerify", "gotoFaceVerify", "verifyUrl", "gotoFaceVerifyImpl", "requestCode", "initIntent", "onActivityResult", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLivePostHelperUI
  extends MMFinderUI
{
  public static final FinderLivePostHelperUI.a FRe;
  private final IListener<?> CUH;
  private w CzQ;
  private ax FRf;
  private String FRg;
  private int FRh;
  private ProgressBar progressBar;
  
  static
  {
    AppMethodBeat.i(347304);
    FRe = new FinderLivePostHelperUI.a((byte)0);
    AppMethodBeat.o(347304);
  }
  
  public FinderLivePostHelperUI()
  {
    AppMethodBeat.i(347250);
    this.FRg = "";
    this.CUH = ((IListener)new IListener(com.tencent.mm.app.f.hfK) {});
    AppMethodBeat.o(347250);
  }
  
  private final void fbl()
  {
    AppMethodBeat.i(347257);
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(347257);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return p.f.Cfh;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    Intent localIntent = null;
    String str1 = null;
    String str2 = null;
    AppMethodBeat.i(347350);
    Log.i("Finder.FinderLivePostHelperUI", s.X("onActivityResult requestCode:10000, resultCode:", Integer.valueOf(paramInt2)));
    switch (paramInt1)
    {
    default: 
      paramIntent = this.FRf;
      if (paramIntent == null)
      {
        s.bIx("precheck");
        paramIntent = str2;
      }
      break;
    }
    while ((paramInt1 == 10123) && (paramInt2 == -1))
    {
      h.baE().ban().set(at.a.adaU, Boolean.TRUE);
      paramIntent.Eth = true;
      if ((!paramIntent.Eti) && (!paramIntent.Etj) && (!paramIntent.Etk))
      {
        paramIntent = paramIntent.EsY;
        if (paramIntent != null)
        {
          paramIntent.invoke(Boolean.TRUE);
          AppMethodBeat.o(347350);
          return;
          localIntent = new Intent();
          if (paramIntent == null) {}
          for (paramIntent = localObject;; paramIntent = paramIntent.getBundleExtra("result_data"))
          {
            if ((paramInt2 == -1) && (paramIntent != null))
            {
              str1 = paramIntent.getString("go_next", "");
              paramIntent = paramIntent.getString("result_json");
              if (!Util.isNullOrNil(paramIntent))
              {
                paramInt1 = new i(paramIntent).getInt("code");
                Log.i("Finder.FinderLivePostHelperUI", "onActivityResult nextStep:" + str1 + ", code:" + paramInt1);
                if ((s.p(str1, "roomlive_verify")) && (paramInt1 == 0))
                {
                  h.baE().ban().set(at.a.adaC, Boolean.TRUE);
                  localIntent.putExtra("FACE_VERIFY_RESULT", 1);
                }
              }
            }
            setResult(-1, localIntent);
            fbl();
            AppMethodBeat.o(347350);
            return;
          }
          if (paramIntent == null)
          {
            paramIntent = null;
            if ((paramInt2 != -1) || (paramIntent == null)) {
              break label486;
            }
            str2 = paramIntent.getString("go_next", "");
            paramIntent = paramIntent.getString("result_json");
            if (Util.isNullOrNil(paramIntent)) {
              break label486;
            }
            paramInt1 = new i(paramIntent).getInt("code");
            Log.i("Finder.FinderLivePostHelperUI", "onActivityResult precheckTypeCache:" + this.FRh + " nextStep:" + str2 + ", code:" + paramInt1);
            if ((!s.p(str2, "roomlive_verify")) || (paramInt1 != 0)) {
              break label486;
            }
            paramIntent = this.FRf;
            if (paramIntent != null) {
              break label483;
            }
            s.bIx("precheck");
            paramIntent = localIntent;
          }
          label483:
          for (;;)
          {
            paramIntent.Q(true, this.FRh);
            this.FRh = 0;
            AppMethodBeat.o(347350);
            return;
            paramIntent = paramIntent.getBundleExtra("result_data");
            break;
          }
          label486:
          paramIntent = this.FRf;
          if (paramIntent == null)
          {
            s.bIx("precheck");
            paramIntent = str1;
          }
          for (;;)
          {
            paramIntent.Q(false, this.FRh);
            this.FRh = 0;
            AppMethodBeat.o(347350);
            return;
          }
        }
      }
      else
      {
        paramIntent.eBr();
      }
    }
    AppMethodBeat.o(347350);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(347321);
    super.onCreate(paramBundle);
    hideTitleView();
    paramBundle = findViewById(p.e.BQF);
    s.s(paramBundle, "findViewById(R.id.finder_live_post_forbidden)");
    this.CzQ = new w(paramBundle);
    paramBundle = findViewById(p.e.BQS);
    s.s(paramBundle, "findViewById(R.id.finder_live_post_precheck)");
    this.FRf = new ax((ViewGroup)paramBundle);
    paramBundle = this.FRf;
    int i;
    if (paramBundle == null)
    {
      s.bIx("precheck");
      paramBundle = null;
      paramBundle.EsX = ((m)new d(this));
      paramBundle.EsY = ((b)new e(this));
      paramBundle = findViewById(p.e.BMh);
      s.s(paramBundle, "findViewById(R.id.finder…per_loading_progress_bar)");
      this.progressBar = ((ProgressBar)paramBundle);
      i = getIntent().getIntExtra("LIVE_HELP_TYPE", 0);
      Log.i("Finder.FinderLivePostHelperUI", s.X("type:", Integer.valueOf(i)));
      switch (i)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(347321);
      return;
      break;
      paramBundle = getIntent().getStringExtra("FACE_VERIFY_URL");
      s.checkNotNull(paramBundle);
      s.s(paramBundle, "intent.getStringExtra(Co…lperUI.FACE_VERIFY_URL)!!");
      this.FRg = paramBundle;
      localObject1 = this.FRg;
      paramBundle = this.CzQ;
      if (paramBundle == null)
      {
        s.bIx("exception");
        paramBundle = null;
      }
      for (;;)
      {
        localObject2 = w.EoA;
        w.a(paramBundle, w.eAB(), null, (b)new b(this, (String)localObject1), 6);
        AppMethodBeat.o(347321);
        return;
      }
      paramBundle = this.CzQ;
      if (paramBundle == null)
      {
        s.bIx("exception");
        paramBundle = null;
      }
      for (;;)
      {
        localObject1 = w.EoA;
        w.a(paramBundle, w.eAA(), null, (b)new c(this), 6);
        AppMethodBeat.o(347321);
        return;
      }
      Object localObject2 = getIntent().getByteArrayExtra("PRECHECK_SPAMRISK");
      if (localObject2 == null)
      {
        paramBundle = null;
        if (paramBundle == null) {
          break label465;
        }
        localObject2 = this.FRf;
        if (localObject2 != null) {
          break label459;
        }
        s.bIx("precheck");
      }
      for (;;)
      {
        i = getIntent().getIntExtra("PRECHECK_USERFLAG", 0);
        s.u(paramBundle, "spamRisk");
        d.uiThread((a)new ax.b((ax)localObject1, i, paramBundle));
        AppMethodBeat.o(347321);
        return;
        paramBundle = new fgq();
        paramBundle.parseFrom((byte[])localObject2);
        break;
        label459:
        localObject1 = localObject2;
      }
      label465:
      Log.e("Finder.FinderLivePostHelperUI", "LIVE_PRECHECK error, spamRisk is empty!");
      finish();
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(347334);
    super.onPause();
    ProgressBar localProgressBar2 = this.progressBar;
    ProgressBar localProgressBar1 = localProgressBar2;
    if (localProgressBar2 == null)
    {
      s.bIx("progressBar");
      localProgressBar1 = null;
    }
    localProgressBar1.setVisibility(8);
    AppMethodBeat.o(347334);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(347328);
    super.onResume();
    ProgressBar localProgressBar2 = this.progressBar;
    ProgressBar localProgressBar1 = localProgressBar2;
    if (localProgressBar2 == null)
    {
      s.bIx("progressBar");
      localProgressBar1 = null;
    }
    localProgressBar1.setVisibility(8);
    AppMethodBeat.o(347328);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "verify", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<Boolean, ah>
  {
    b(FinderLivePostHelperUI paramFinderLivePostHelperUI, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "ok", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<Boolean, ah>
  {
    c(FinderLivePostHelperUI paramFinderLivePostHelperUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "verifyUrl", "", "precheckType", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements m<String, Integer, ah>
  {
    d(FinderLivePostHelperUI paramFinderLivePostHelperUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "ok", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements b<Boolean, ah>
  {
    e(FinderLivePostHelperUI paramFinderLivePostHelperUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderLivePostHelperUI
 * JD-Core Version:    0.7.0.1
 */