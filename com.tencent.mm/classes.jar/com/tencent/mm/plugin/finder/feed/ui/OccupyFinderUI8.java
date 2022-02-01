package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.b.m;
import com.tencent.mm.plugin.finder.cgi.ch;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.utils.pref.a;
import com.tencent.mm.plugin.finder.utils.pref.b;
import com.tencent.mm.plugin.finder.utils.pref.c;
import com.tencent.mm.plugin.finder.utils.pref.e;
import com.tencent.mm.plugin.finder.utils.pref.g;
import com.tencent.mm.plugin.finder.utils.pref.j;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI8;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "myFinderUser", "prefList", "Ljava/util/Vector;", "Lcom/tencent/mm/plugin/finder/utils/pref/PrefComponent;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "self", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "doPrepareUser", "", "getResourceId", "", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "updateView", "isFromSceneEnd", "plugin-finder_release"})
public final class OccupyFinderUI8
  extends MMPreference
  implements com.tencent.mm.an.i
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private ble wZz;
  private String xTq;
  private com.tencent.mm.plugin.finder.api.i xTr;
  private final Vector<com.tencent.mm.plugin.finder.utils.pref.i> xTs;
  
  public OccupyFinderUI8()
  {
    AppMethodBeat.i(286161);
    this.TAG = "Finder.FinderPosterCenterUI";
    this.xTs = new Vector();
    AppMethodBeat.o(286161);
  }
  
  private void buQ()
  {
    AppMethodBeat.i(286153);
    Iterator localIterator = ((Iterable)this.xTs).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.finder.utils.pref.i)localIterator.next()).onCreate();
    }
    getPreferenceScreen().notifyDataSetChanged();
    AppMethodBeat.o(286153);
  }
  
  private final void jq(boolean paramBoolean)
  {
    AppMethodBeat.i(286157);
    Object localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
    this.xTr = d.a.aAK(Util.nullAsNil(this.xTq));
    if (this.xTr == null)
    {
      finish();
      AppMethodBeat.o(286157);
      return;
    }
    localObject = ((Iterable)this.xTs).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.plugin.finder.utils.pref.i)((Iterator)localObject).next()).jq(paramBoolean);
    }
    AppMethodBeat.o(286157);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(286163);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(286163);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(286162);
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
    AppMethodBeat.o(286162);
    return localView1;
  }
  
  public final int getResourceId()
  {
    return b.m.finder_poster_center_pref;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(286151);
    super.onCreate(paramBundle);
    this.xTq = z.bdh();
    Log.i(this.TAG, "myFinderUser " + this.xTq);
    setMMTitle(b.j.finder_poster_entrance);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    paramBundle = this.xTs;
    com.tencent.mm.ui.base.preference.f localf = getPreferenceScreen();
    p.j(localf, "preferenceScreen");
    paramBundle.add(new a("settings_auth", localf, (Context)this));
    paramBundle = this.xTs;
    localf = getPreferenceScreen();
    p.j(localf, "preferenceScreen");
    paramBundle.add(new com.tencent.mm.plugin.finder.utils.pref.f("setting_original", localf, (Context)this));
    paramBundle = this.xTs;
    localf = getPreferenceScreen();
    p.j(localf, "preferenceScreen");
    paramBundle.add(new b("setting_live_income", localf, (Context)this));
    paramBundle = this.xTs;
    localf = getPreferenceScreen();
    p.j(localf, "preferenceScreen");
    paramBundle.add(new com.tencent.mm.plugin.finder.utils.pref.d("setting_live_task", localf, (Context)this));
    paramBundle = this.xTs;
    localf = getPreferenceScreen();
    p.j(localf, "preferenceScreen");
    paramBundle.add(new e("setting_live_lottery_history", localf, (Context)this));
    paramBundle = this.xTs;
    localf = getPreferenceScreen();
    p.j(localf, "preferenceScreen");
    paramBundle.add(new com.tencent.mm.plugin.finder.utils.pref.h("setting_live_settle_to_agency", localf, (Context)this));
    paramBundle = this.xTs;
    localf = getPreferenceScreen();
    p.j(localf, "preferenceScreen");
    paramBundle.add(new c("settings_shop", localf, (Context)this));
    paramBundle = this.xTs;
    localf = getPreferenceScreen();
    p.j(localf, "preferenceScreen");
    paramBundle.add(new g("settings_creater_guide", localf, (Context)this));
    buQ();
    com.tencent.mm.kernel.h.aGY().a(3761, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(286151);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(286155);
    com.tencent.mm.kernel.h.aGY().b(3761, (com.tencent.mm.an.i)this);
    super.onDestroy();
    AppMethodBeat.o(286155);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(286159);
    if (paramPreference == null) {
      p.iCn();
    }
    paramPreference = paramPreference.getKey();
    Log.i(this.TAG, "click ".concat(String.valueOf(paramPreference)));
    Iterator localIterator = ((Iterable)this.xTs).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramf = localIterator.next();
    } while (!p.h(((com.tencent.mm.plugin.finder.utils.pref.i)paramf).egv(), paramPreference));
    for (;;)
    {
      paramf = (com.tencent.mm.plugin.finder.utils.pref.i)paramf;
      if (paramf != null) {
        paramf.onClick();
      }
      AppMethodBeat.o(286159);
      return true;
      paramf = null;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(286154);
    super.onResume();
    Object localObject = ((Iterable)this.xTs).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.plugin.finder.utils.pref.i)((Iterator)localObject).next()).onResume();
    }
    getContentView().post((Runnable)new b(this));
    localObject = n.zWF;
    n.b((Context)this, 4L, 2L);
    localObject = new ch(2);
    com.tencent.mm.kernel.h.aGY().b((q)localObject);
    AppMethodBeat.o(286154);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    com.tencent.mm.plugin.finder.utils.pref.i locali = null;
    AppMethodBeat.i(286156);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene ");
    if (paramq != null) {}
    for (paramString = Integer.valueOf(paramq.getType());; paramString = null)
    {
      Log.i(str, paramString + " scene:" + paramq);
      paramString = locali;
      if (paramq != null) {
        paramString = Integer.valueOf(paramq.getType());
      }
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(286156);
      return;
    }
    if ((paramString.intValue() == 3761) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
        AppMethodBeat.o(286156);
        throw paramString;
      }
      this.wZz = ((ch)paramq).dnR();
      paramString = this.wZz;
      if (paramString != null)
      {
        paramq = ((Iterable)this.xTs).iterator();
        while (paramq.hasNext())
        {
          locali = (com.tencent.mm.plugin.finder.utils.pref.i)paramq.next();
          if ((locali instanceof j)) {
            ((j)locali).b(paramString);
          }
        }
        jq(true);
        AppMethodBeat.o(286156);
        return;
      }
    }
    AppMethodBeat.o(286156);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(286160);
    super.onStop();
    Iterator localIterator = ((Iterable)this.xTs).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.finder.utils.pref.i)localIterator.next()).onStop();
    }
    AppMethodBeat.o(286160);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(OccupyFinderUI8 paramOccupyFinderUI8) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(272725);
      this.xTt.finish();
      AppMethodBeat.o(272725);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(OccupyFinderUI8 paramOccupyFinderUI8) {}
    
    public final void run()
    {
      AppMethodBeat.i(292157);
      OccupyFinderUI8.a(this.xTt);
      AppMethodBeat.o(292157);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI8
 * JD-Core Version:    0.7.0.1
 */