package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.live.widget.f;
import com.tencent.mm.plugin.finder.live.widget.f.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.HashMap;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderLivePostHelperUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "exception", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget;", "faceVerifyUrl", "", "progressBar", "Landroid/widget/ProgressBar;", "finishWithoutTransition", "", "getLayoutId", "", "gotoFaceVerify", "verifyUrl", "initIntent", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class FinderLivePostHelperUI
  extends MMFinderUI
{
  public static final a vLa;
  private HashMap _$_findViewCache;
  private ProgressBar progressBar;
  private f uho;
  private String vKZ = "";
  
  static
  {
    AppMethodBeat.i(252492);
    vLa = new a((byte)0);
    AppMethodBeat.o(252492);
  }
  
  private final void dzF()
  {
    AppMethodBeat.i(252491);
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(252491);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252496);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252496);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252495);
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
    AppMethodBeat.o(252495);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494450;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(252490);
    Intent localIntent;
    if (paramInt1 == 10000)
    {
      localIntent = new Intent();
      if (paramIntent == null) {
        break label173;
      }
    }
    label173:
    for (paramIntent = paramIntent.getBundleExtra("result_data");; paramIntent = null)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str = paramIntent.getString("go_next", "");
        paramIntent = paramIntent.getString("result_json");
        if (!Util.isNullOrNil(paramIntent))
        {
          paramInt1 = new i(paramIntent).getInt("code");
          Log.i("Finder.FinderLivePostHelperUI", "onActivityResult, nextStep:" + str + ", code:" + paramInt1);
          if ((p.j(str, "roomlive_verify")) && (paramInt1 == 0))
          {
            paramIntent = g.aAh();
            p.g(paramIntent, "MMKernel.storage()");
            paramIntent.azQ().set(ar.a.Oki, Boolean.TRUE);
            localIntent.putExtra("FACE_VERIFY_RESULT", 1);
          }
        }
      }
      setResult(-1, localIntent);
      dzF();
      AppMethodBeat.o(252490);
      return;
    }
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(252487);
    super.onCreate(paramBundle);
    hideTitleView();
    paramBundle = findViewById(2131301223);
    p.g(paramBundle, "findViewById(R.id.finder_live_post_forbidden)");
    this.uho = new f(paramBundle);
    paramBundle = findViewById(2131301027);
    p.g(paramBundle, "findViewById(R.id.finder…per_loading_progress_bar)");
    this.progressBar = ((ProgressBar)paramBundle);
    int i = getIntent().getIntExtra("LIVE_HELP_TYPE", 0);
    Log.i("Finder.FinderLivePostHelperUI", "type:".concat(String.valueOf(i)));
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(252487);
      return;
      paramBundle = getIntent().getStringExtra("FACE_VERIFY_URL");
      p.g(paramBundle, "intent.getStringExtra(FACE_VERIFY_URL)");
      this.vKZ = paramBundle;
      paramBundle = this.vKZ;
      Object localObject = this.uho;
      if (localObject == null) {
        p.btv("exception");
      }
      f.c localc = f.uGx;
      f.a((f)localObject, f.djF(), null, (b)new b(this, paramBundle), 6);
      AppMethodBeat.o(252487);
      return;
      paramBundle = this.uho;
      if (paramBundle == null) {
        p.btv("exception");
      }
      localObject = f.uGx;
      f.a(paramBundle, f.djE(), null, (b)new c(this), 6);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(252489);
    super.onPause();
    ProgressBar localProgressBar = this.progressBar;
    if (localProgressBar == null) {
      p.btv("progressBar");
    }
    localProgressBar.setVisibility(8);
    AppMethodBeat.o(252489);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(252488);
    super.onResume();
    ProgressBar localProgressBar = this.progressBar;
    if (localProgressBar == null) {
      p.btv("progressBar");
    }
    localProgressBar.setVisibility(8);
    AppMethodBeat.o(252488);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderLivePostHelperUI$Companion;", "", "()V", "DEFAULT", "", "ENTER_LIVE_FACE_VERIFY", "FACE_VERIFY", "FACE_VERIFY_OK", "FACE_VERIFY_RESULT", "", "FACE_VERIFY_URL", "LIVE_CANNOT_USE", "LIVE_FORBIDDEN", "LIVE_HELP_TYPE", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "verify", "", "invoke"})
  static final class b
    extends q
    implements b<Boolean, x>
  {
    b(FinderLivePostHelperUI paramFinderLivePostHelperUI, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ok", "", "invoke"})
  static final class c
    extends q
    implements b<Boolean, x>
  {
    c(FinderLivePostHelperUI paramFinderLivePostHelperUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderLivePostHelperUI
 * JD-Core Version:    0.7.0.1
 */