package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.finder.widget.pref.a;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI16;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "accountExtConfig", "Lcom/tencent/mm/protocal/protobuf/AccountExtraSettingConfig;", "getResourceId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "Companion", "plugin-finder_release"})
public final class OccupyFinderUI16
  extends MMPreference
{
  private static final String ueE = "ACCOUNT_EXTRA_CONFIG";
  public static final a ueF;
  private final String TAG = "Finder.FinderAccountManagent";
  private HashMap _$_findViewCache;
  private ax ueD;
  
  static
  {
    AppMethodBeat.i(245717);
    ueF = new a((byte)0);
    ueE = "ACCOUNT_EXTRA_CONFIG";
    AppMethodBeat.o(245717);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245719);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245719);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245718);
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
    AppMethodBeat.o(245718);
    return localView1;
  }
  
  public final int getResourceId()
  {
    return 2132017215;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(245715);
    super.initView();
    Object localObject = this.ueD;
    if (localObject != null)
    {
      localObject = ((ax)localObject).KDT;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          az localaz = (az)((Iterator)localObject).next();
          f localf = getPreferenceScreen();
          p.g(localaz, "it");
          localf.c((Preference)new a(localaz, (Context)this));
        }
      }
    }
    getPreferenceScreen().notifyDataSetChanged();
    AppMethodBeat.o(245715);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245714);
    super.onCreate(paramBundle);
    setMMTitle(2131759486);
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    byte[] arrayOfByte = getIntent().getByteArrayExtra(ueE);
    if (arrayOfByte != null)
    {
      paramBundle = new ax();
      paramBundle.parseFrom(arrayOfByte);
    }
    for (;;)
    {
      this.ueD = paramBundle;
      if (this.ueD != null) {
        break;
      }
      finish();
      AppMethodBeat.o(245714);
      return;
      paramBundle = null;
    }
    initView();
    AppMethodBeat.o(245714);
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    com.tencent.mm.plugin.appbrand.api.g localg = null;
    AppMethodBeat.i(245716);
    if (paramPreference == null)
    {
      paramf = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.pref.FinderAccountManagementPref");
      AppMethodBeat.o(245716);
      throw paramf;
    }
    a locala = (a)paramPreference;
    paramf = locala.wDE;
    if (paramf != null)
    {
      paramf = Integer.valueOf(paramf.pTI);
      if (paramf != null) {
        break label73;
      }
      label57:
      if (paramf != null) {
        break label134;
      }
    }
    label73:
    while (paramf.intValue() != 1) {
      for (;;)
      {
        AppMethodBeat.o(245716);
        return true;
        paramf = null;
        break;
        if (paramf.intValue() != 2) {
          break label57;
        }
        paramPreference = new Intent();
        az localaz = locala.wDE;
        paramf = localg;
        if (localaz != null) {
          paramf = localaz.qHg;
        }
        paramPreference.putExtra("rawUrl", paramf);
        c.b(locala.getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
      }
    }
    label134:
    localg = new com.tencent.mm.plugin.appbrand.api.g();
    paramf = locala.wDE;
    if (paramf != null)
    {
      paramPreference = paramf.KDV;
      paramf = paramPreference;
      if (paramPreference != null) {}
    }
    else
    {
      paramf = "";
    }
    localg.username = paramf;
    paramf = locala.wDE;
    if (paramf != null)
    {
      paramPreference = paramf.KDW;
      paramf = paramPreference;
      if (paramPreference != null) {}
    }
    else
    {
      paramf = "";
    }
    localg.kHw = paramf;
    paramf = locala.wDE;
    if (paramf != null) {}
    for (int i = paramf.KDY;; i = 1000)
    {
      localg.scene = i;
      ((r)com.tencent.mm.kernel.g.af(r.class)).a(locala.getContext(), localg);
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI16$Companion;", "", "()V", "ACCOUNT_EXTRA_CONFIG", "", "getACCOUNT_EXTRA_CONFIG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(OccupyFinderUI16 paramOccupyFinderUI16) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(245713);
      this.ueG.finish();
      AppMethodBeat.o(245713);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI16
 * JD-Core Version:    0.7.0.1
 */