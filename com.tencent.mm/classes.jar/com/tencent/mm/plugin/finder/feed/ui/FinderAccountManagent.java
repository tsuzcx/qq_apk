package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.b.m;
import com.tencent.mm.plugin.finder.widget.pref.a;
import com.tencent.mm.protocal.protobuf.av;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAccountManagent;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "accountExtConfig", "Lcom/tencent/mm/protocal/protobuf/AccountExtraSettingConfig;", "getResourceId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "Companion", "plugin-finder_release"})
public final class FinderAccountManagent
  extends MMPreference
{
  private static final String xLe = "ACCOUNT_EXTRA_CONFIG";
  public static final a xLf;
  private final String TAG = "Finder.FinderAccountManagent";
  private HashMap _$_findViewCache;
  private av xLd;
  
  static
  {
    AppMethodBeat.i(246420);
    xLf = new a((byte)0);
    xLe = "ACCOUNT_EXTRA_CONFIG";
    AppMethodBeat.o(246420);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(246422);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(246422);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(246421);
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
    AppMethodBeat.o(246421);
    return localView1;
  }
  
  public final int getResourceId()
  {
    return b.m.finder_account_managent_pref;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(246417);
    super.initView();
    Object localObject = this.xLd;
    if (localObject != null)
    {
      localObject = ((av)localObject).RFl;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ax localax = (ax)((Iterator)localObject).next();
          f localf = getPreferenceScreen();
          p.j(localax, "it");
          localf.b((Preference)new a(localax, (Context)this));
        }
      }
    }
    getPreferenceScreen().notifyDataSetChanged();
    AppMethodBeat.o(246417);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(246416);
    super.onCreate(paramBundle);
    setMMTitle(b.j.finder_account_management);
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    byte[] arrayOfByte = getIntent().getByteArrayExtra(xLe);
    if (arrayOfByte != null)
    {
      paramBundle = new av();
      paramBundle.parseFrom(arrayOfByte);
    }
    for (;;)
    {
      this.xLd = paramBundle;
      if (this.xLd != null) {
        break;
      }
      finish();
      AppMethodBeat.o(246416);
      return;
      paramBundle = null;
    }
    initView();
    AppMethodBeat.o(246416);
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    g localg = null;
    AppMethodBeat.i(246419);
    if (paramPreference == null)
    {
      paramf = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.pref.FinderAccountManagementPref");
      AppMethodBeat.o(246419);
      throw paramf;
    }
    a locala = (a)paramPreference;
    paramf = locala.Bum;
    if (paramf != null)
    {
      paramf = Integer.valueOf(paramf.tpK);
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
        AppMethodBeat.o(246419);
        return true;
        paramf = null;
        break;
        if (paramf.intValue() != 2) {
          break label57;
        }
        paramPreference = new Intent();
        ax localax = locala.Bum;
        paramf = localg;
        if (localax != null) {
          paramf = localax.ugh;
        }
        paramPreference.putExtra("rawUrl", paramf);
        c.b(locala.getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
      }
    }
    label134:
    localg = new g();
    paramf = locala.Bum;
    if (paramf != null)
    {
      paramPreference = paramf.RFn;
      paramf = paramPreference;
      if (paramPreference != null) {}
    }
    else
    {
      paramf = "";
    }
    localg.username = paramf;
    paramf = locala.Bum;
    if (paramf != null)
    {
      paramPreference = paramf.RFo;
      paramf = paramPreference;
      if (paramPreference != null) {}
    }
    else
    {
      paramf = "";
    }
    localg.nBq = paramf;
    paramf = locala.Bum;
    if (paramf != null) {}
    for (int i = paramf.RFq;; i = 1000)
    {
      localg.scene = i;
      ((r)h.ae(r.class)).a(locala.getContext(), localg);
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAccountManagent$Companion;", "", "()V", "ACCOUNT_EXTRA_CONFIG", "", "getACCOUNT_EXTRA_CONFIG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderAccountManagent paramFinderAccountManagent) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(269008);
      this.xLg.finish();
      AppMethodBeat.o(269008);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderAccountManagent
 * JD-Core Version:    0.7.0.1
 */