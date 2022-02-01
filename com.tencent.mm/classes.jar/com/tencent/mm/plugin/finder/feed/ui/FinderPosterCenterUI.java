package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.cgi.di;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.e.k;
import com.tencent.mm.plugin.finder.utils.pref.a;
import com.tencent.mm.plugin.finder.utils.pref.b;
import com.tencent.mm.plugin.finder.utils.pref.c;
import com.tencent.mm.plugin.finder.utils.pref.e;
import com.tencent.mm.plugin.finder.utils.pref.g;
import com.tencent.mm.plugin.finder.utils.pref.i;
import com.tencent.mm.plugin.finder.utils.pref.j;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.Vector;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPosterCenterUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "myFinderUser", "prefList", "Ljava/util/Vector;", "Lcom/tencent/mm/plugin/finder/utils/pref/PrefComponent;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "self", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "doPrepareUser", "", "getResourceId", "", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "updateView", "isFromSceneEnd", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderPosterCenterUI
  extends MMPreference
  implements com.tencent.mm.am.h
{
  private bys AwM;
  private String Bre;
  private m Brf;
  private final Vector<i> Brg;
  private final String TAG;
  
  public FinderPosterCenterUI()
  {
    AppMethodBeat.i(365033);
    this.TAG = "Finder.FinderPosterCenterUI";
    this.Brg = new Vector();
    AppMethodBeat.o(365033);
  }
  
  private static final void a(FinderPosterCenterUI paramFinderPosterCenterUI)
  {
    AppMethodBeat.i(365063);
    kotlin.g.b.s.u(paramFinderPosterCenterUI, "this$0");
    paramFinderPosterCenterUI.kD(false);
    AppMethodBeat.o(365063);
  }
  
  private static final boolean a(FinderPosterCenterUI paramFinderPosterCenterUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(365052);
    kotlin.g.b.s.u(paramFinderPosterCenterUI, "this$0");
    paramFinderPosterCenterUI.finish();
    AppMethodBeat.o(365052);
    return true;
  }
  
  private final void kD(boolean paramBoolean)
  {
    AppMethodBeat.i(365046);
    Object localObject = com.tencent.mm.plugin.finder.api.d.AwY;
    this.Brf = d.a.auT(Util.nullAsNil(this.Bre));
    if (this.Brf == null)
    {
      finish();
      AppMethodBeat.o(365046);
      return;
    }
    localObject = ((Iterable)this.Brg).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((i)((Iterator)localObject).next()).kD(paramBoolean);
    }
    AppMethodBeat.o(365046);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getResourceId()
  {
    return e.k.finder_poster_center_pref;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365092);
    super.onCreate(paramBundle);
    this.Bre = com.tencent.mm.model.z.bAW();
    Log.i(this.TAG, kotlin.g.b.s.X("myFinderUser ", this.Bre));
    setMMTitle(e.h.finder_poster_entrance);
    setBackBtn(new FinderPosterCenterUI..ExternalSyntheticLambda0(this));
    paramBundle = this.Brg;
    com.tencent.mm.ui.base.preference.f localf = getPreferenceScreen();
    kotlin.g.b.s.s(localf, "preferenceScreen");
    paramBundle.add(new a("settings_auth", localf, (Context)this));
    paramBundle = this.Brg;
    localf = getPreferenceScreen();
    kotlin.g.b.s.s(localf, "preferenceScreen");
    paramBundle.add(new com.tencent.mm.plugin.finder.utils.pref.f("setting_original", localf, (Context)this));
    paramBundle = this.Brg;
    localf = getPreferenceScreen();
    kotlin.g.b.s.s(localf, "preferenceScreen");
    paramBundle.add(new b("setting_live_income", localf, (Context)this));
    paramBundle = this.Brg;
    localf = getPreferenceScreen();
    kotlin.g.b.s.s(localf, "preferenceScreen");
    paramBundle.add(new com.tencent.mm.plugin.finder.utils.pref.d("setting_live_task", localf, (Context)this));
    paramBundle = this.Brg;
    localf = getPreferenceScreen();
    kotlin.g.b.s.s(localf, "preferenceScreen");
    paramBundle.add(new e("setting_live_lottery_history", localf, (Context)this));
    paramBundle = this.Brg;
    localf = getPreferenceScreen();
    kotlin.g.b.s.s(localf, "preferenceScreen");
    paramBundle.add(new com.tencent.mm.plugin.finder.utils.pref.h("setting_live_settle_to_agency", localf, (Context)this));
    paramBundle = this.Brg;
    localf = getPreferenceScreen();
    kotlin.g.b.s.s(localf, "preferenceScreen");
    paramBundle.add(new c("settings_shop", localf, (Context)this));
    paramBundle = this.Brg;
    localf = getPreferenceScreen();
    kotlin.g.b.s.s(localf, "preferenceScreen");
    paramBundle.add(new g("settings_creater_guide", localf, (Context)this));
    paramBundle = ((Iterable)this.Brg).iterator();
    while (paramBundle.hasNext()) {
      ((i)paramBundle.next()).onCreate();
    }
    getPreferenceScreen().notifyDataSetChanged();
    com.tencent.mm.kernel.h.aZW().a(3761, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(365092);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(365105);
    com.tencent.mm.kernel.h.aZW().b(3761, (com.tencent.mm.am.h)this);
    super.onDestroy();
    AppMethodBeat.o(365105);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(365125);
    kotlin.g.b.s.checkNotNull(paramPreference);
    paramPreference = paramPreference.mKey;
    Log.i(this.TAG, kotlin.g.b.s.X("click ", paramPreference));
    Iterator localIterator = ((Iterable)this.Brg).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramf = localIterator.next();
    } while (!kotlin.g.b.s.p(((i)paramf).fiv(), paramPreference));
    for (;;)
    {
      paramf = (i)paramf;
      if (paramf != null) {
        paramf.onClick();
      }
      AppMethodBeat.o(365125);
      return true;
      paramf = null;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(365099);
    super.onResume();
    Object localObject = ((Iterable)this.Brg).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((i)((Iterator)localObject).next()).onResume();
    }
    getContentView().post(new FinderPosterCenterUI..ExternalSyntheticLambda1(this));
    localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
    com.tencent.mm.plugin.finder.report.z.b((Context)this, 4L, 2L);
    localObject = new di(2);
    com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    AppMethodBeat.o(365099);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    i locali = null;
    AppMethodBeat.i(365115);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene ");
    if (paramp == null)
    {
      paramString = null;
      Log.i(str, paramString + " scene:" + paramp);
      if (paramp != null) {
        break label120;
      }
    }
    label120:
    for (paramString = locali;; paramString = Integer.valueOf(paramp.getType()))
    {
      if (paramString != null) {
        break label132;
      }
      AppMethodBeat.o(365115);
      return;
      paramString = Integer.valueOf(paramp.getType());
      break;
    }
    label132:
    if ((paramString.intValue() == 3761) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
        AppMethodBeat.o(365115);
        throw paramString;
      }
      this.AwM = ((di)paramp).dVy();
      paramString = this.AwM;
      if (paramString != null)
      {
        paramp = ((Iterable)this.Brg).iterator();
        while (paramp.hasNext())
        {
          locali = (i)paramp.next();
          if ((locali instanceof j)) {
            ((j)locali).b(paramString);
          }
        }
        kD(true);
      }
    }
    AppMethodBeat.o(365115);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(365140);
    super.onStop();
    Iterator localIterator = ((Iterable)this.Brg).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).onStop();
    }
    AppMethodBeat.o(365140);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderPosterCenterUI
 * JD-Core Version:    0.7.0.1
 */