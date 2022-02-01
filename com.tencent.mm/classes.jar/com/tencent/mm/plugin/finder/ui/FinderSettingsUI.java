package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.config.e;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingsUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "screen", "Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter;", "getResourceId", "", "handleAddPreference", "", "list", "", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "importConfig", "initView", "intiViewByConfigArray", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPreferenceTreeClick", "", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "Companion", "plugin-finder_release"})
public final class FinderSettingsUI
  extends MMPreference
{
  private static ArrayList<e> vOB;
  public static final a vOC;
  private final String TAG;
  private HashMap _$_findViewCache;
  private h vOA;
  
  static
  {
    AppMethodBeat.i(167667);
    vOC = new a((byte)0);
    AppMethodBeat.o(167667);
  }
  
  public FinderSettingsUI()
  {
    AppMethodBeat.i(167666);
    this.TAG = "MicroMsg.FinderDebugSettingsUI";
    AppMethodBeat.o(167666);
  }
  
  private final void ex(List<? extends e> paramList)
  {
    AppMethodBeat.i(252689);
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        e locale = (e)paramList.next();
        if ((locale instanceof com.tencent.mm.plugin.finder.storage.config.a))
        {
          h localh = this.vOA;
          if (localh != null)
          {
            PreferenceTitleCategory localPreferenceTitleCategory = new PreferenceTitleCategory((Context)this);
            localPreferenceTitleCategory.setTitle((CharSequence)locale.title);
            localh.c((Preference)localPreferenceTitleCategory);
          }
        }
        else if ((locale instanceof com.tencent.mm.plugin.finder.storage.config.c))
        {
          new j.e((MMPreference)this, locale);
        }
        else if ((locale instanceof com.tencent.mm.plugin.finder.storage.config.item.integer.a))
        {
          new j.d((MMPreference)this, locale);
        }
        else if ((locale instanceof com.tencent.mm.plugin.finder.storage.config.item.c))
        {
          new j.d((MMPreference)this, locale);
        }
        else if ((locale instanceof com.tencent.mm.plugin.finder.storage.config.item.longtype.a))
        {
          new j.d((MMPreference)this, locale);
        }
        else if ((locale instanceof com.tencent.mm.plugin.finder.storage.config.item.booleantype.a))
        {
          new j.c((MMPreference)this, locale);
        }
      }
      AppMethodBeat.o(252689);
      return;
    }
    AppMethodBeat.o(252689);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252694);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252694);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252693);
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
    AppMethodBeat.o(252693);
    return localView1;
  }
  
  public final int getResourceId()
  {
    return 2132017217;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(252690);
    Object localObject = getPreferenceScreen();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.MMPreferenceAdapter");
      AppMethodBeat.o(252690);
      throw ((Throwable)localObject);
    }
    this.vOA = ((h)localObject);
    if (this.vOA == null) {
      p.hyc();
    }
    ex((List)vOB);
    localObject = this.vOA;
    if (localObject != null)
    {
      ((h)localObject).notifyDataSetChanged();
      AppMethodBeat.o(252690);
      return;
    }
    AppMethodBeat.o(252690);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167662);
    super.onCreate(paramBundle);
    setMMTitle("视频号维修厂");
    setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
    paramBundle = (Collection)vOB;
    int i;
    if ((paramBundle == null) || (paramBundle.isEmpty())) {
      i = 1;
    }
    while (i != 0)
    {
      paramBundle = (e)new com.tencent.mm.plugin.finder.storage.config.a("新版本");
      Object localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject1 = (e)com.tencent.mm.plugin.finder.storage.c.dra();
      Object localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject2 = (e)com.tencent.mm.plugin.finder.storage.c.dqE();
      Object localObject3 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject3 = (e)com.tencent.mm.plugin.finder.storage.c.dqF();
      Object localObject4 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject4 = (e)com.tencent.mm.plugin.finder.storage.c.dvM();
      Object localObject5 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject5 = (e)com.tencent.mm.plugin.finder.storage.c.dvN();
      Object localObject6 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject6 = (e)com.tencent.mm.plugin.finder.storage.c.dvO();
      Object localObject7 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject7 = (e)com.tencent.mm.plugin.finder.storage.c.dtp();
      Object localObject8 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject8 = (e)com.tencent.mm.plugin.finder.storage.c.dsE();
      Object localObject9 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject9 = (e)com.tencent.mm.plugin.finder.storage.c.dsF();
      Object localObject10 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject10 = (e)com.tencent.mm.plugin.finder.storage.c.dsG();
      Object localObject11 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject11 = (e)com.tencent.mm.plugin.finder.storage.c.dsH();
      Object localObject12 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject12 = (e)com.tencent.mm.plugin.finder.storage.c.dsI();
      Object localObject13 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject13 = (e)com.tencent.mm.plugin.finder.storage.c.dsJ();
      Object localObject14 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject14 = (e)com.tencent.mm.plugin.finder.storage.c.dsK();
      Object localObject15 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject15 = (e)com.tencent.mm.plugin.finder.storage.c.dsL();
      Object localObject16 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject16 = (e)com.tencent.mm.plugin.finder.storage.c.dsM();
      Object localObject17 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject17 = (e)com.tencent.mm.plugin.finder.storage.c.duy();
      Object localObject18 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject18 = (e)com.tencent.mm.plugin.finder.storage.c.dvD();
      Object localObject19 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject19 = (e)com.tencent.mm.plugin.finder.storage.c.dvI();
      Object localObject20 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject20 = (e)com.tencent.mm.plugin.finder.storage.c.dvP();
      Object localObject21 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject21 = (e)com.tencent.mm.plugin.finder.storage.c.dvQ();
      Object localObject22 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject22 = (e)com.tencent.mm.plugin.finder.storage.c.dqK();
      Object localObject23 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject23 = (e)com.tencent.mm.plugin.finder.storage.c.dvF();
      Object localObject24 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject24 = (e)com.tencent.mm.plugin.finder.storage.c.dvG();
      Object localObject25 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject25 = (e)com.tencent.mm.plugin.finder.storage.c.dvH();
      Object localObject26 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject26 = (e)com.tencent.mm.plugin.finder.storage.c.dvy();
      Object localObject27 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject27 = (e)com.tencent.mm.plugin.finder.storage.c.dvz();
      Object localObject28 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject28 = (e)com.tencent.mm.plugin.finder.storage.c.duA();
      Object localObject29 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject29 = (e)com.tencent.mm.plugin.finder.storage.c.duC();
      Object localObject30 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject30 = (e)com.tencent.mm.plugin.finder.storage.c.duD();
      Object localObject31 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject31 = (e)com.tencent.mm.plugin.finder.storage.c.duv();
      Object localObject32 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject32 = (e)com.tencent.mm.plugin.finder.storage.c.dtQ();
      Object localObject33 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject33 = (e)com.tencent.mm.plugin.finder.storage.c.dtN();
      Object localObject34 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject34 = (e)com.tencent.mm.plugin.finder.storage.c.dud();
      Object localObject35 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject35 = (e)com.tencent.mm.plugin.finder.storage.c.duw();
      Object localObject36 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject36 = (e)com.tencent.mm.plugin.finder.storage.c.dux();
      Object localObject37 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject37 = (e)com.tencent.mm.plugin.finder.storage.c.duz();
      Object localObject38 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject38 = (e)com.tencent.mm.plugin.finder.storage.c.dtV();
      Object localObject39 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject39 = (e)com.tencent.mm.plugin.finder.storage.c.dtW();
      Object localObject40 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject40 = (e)com.tencent.mm.plugin.finder.storage.c.dso();
      Object localObject41 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject41 = (e)com.tencent.mm.plugin.finder.storage.c.dsq();
      Object localObject42 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject42 = (e)com.tencent.mm.plugin.finder.storage.c.dsr();
      Object localObject43 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject43 = (e)com.tencent.mm.plugin.finder.storage.c.dtB();
      Object localObject44 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject44 = (e)com.tencent.mm.plugin.finder.storage.c.dtS();
      Object localObject45 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject45 = (e)com.tencent.mm.plugin.finder.storage.c.dss();
      Object localObject46 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject46 = (e)com.tencent.mm.plugin.finder.storage.c.dte();
      Object localObject47 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject47 = (e)com.tencent.mm.plugin.finder.storage.c.dst();
      Object localObject48 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject48 = (e)com.tencent.mm.plugin.finder.storage.c.dtC();
      Object localObject49 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject49 = (e)com.tencent.mm.plugin.finder.storage.c.dtI();
      Object localObject50 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject50 = (e)com.tencent.mm.plugin.finder.storage.c.dtT();
      Object localObject51 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject51 = (e)com.tencent.mm.plugin.finder.storage.c.dtR();
      Object localObject52 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject52 = (e)com.tencent.mm.plugin.finder.storage.c.dtZ();
      Object localObject53 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject53 = (e)com.tencent.mm.plugin.finder.storage.c.dqz();
      Object localObject54 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject54 = (e)com.tencent.mm.plugin.finder.storage.c.dvK();
      Object localObject55 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject55 = (e)com.tencent.mm.plugin.finder.storage.c.dvL();
      Object localObject56 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject56 = (e)com.tencent.mm.plugin.finder.storage.c.dvv();
      Object localObject57 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject57 = (e)com.tencent.mm.plugin.finder.storage.c.dvw();
      Object localObject58 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject58 = (e)com.tencent.mm.plugin.finder.storage.c.dxh();
      Object localObject59 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject59 = (e)com.tencent.mm.plugin.finder.storage.c.dwX();
      e locale1 = (e)new com.tencent.mm.plugin.finder.storage.config.a("体验相关");
      Object localObject60 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject60 = (e)com.tencent.mm.plugin.finder.storage.c.dwq();
      Object localObject61 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject61 = (e)com.tencent.mm.plugin.finder.storage.c.dwp();
      Object localObject62 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject62 = (e)com.tencent.mm.plugin.finder.storage.c.dwz();
      Object localObject63 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject63 = (e)com.tencent.mm.plugin.finder.storage.c.dws();
      Object localObject64 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject64 = (e)com.tencent.mm.plugin.finder.storage.c.dwr();
      Object localObject65 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject65 = (e)com.tencent.mm.plugin.finder.storage.c.dwt();
      Object localObject66 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject66 = (e)com.tencent.mm.plugin.finder.storage.c.dwu();
      Object localObject67 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject67 = (e)com.tencent.mm.plugin.finder.storage.c.dww();
      Object localObject68 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject68 = (e)com.tencent.mm.plugin.finder.storage.c.dwv();
      Object localObject69 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject69 = (e)com.tencent.mm.plugin.finder.storage.c.dwx();
      Object localObject70 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject70 = (e)com.tencent.mm.plugin.finder.storage.c.dwy();
      Object localObject71 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject71 = (e)com.tencent.mm.plugin.finder.storage.c.dtK();
      Object localObject72 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject72 = (e)com.tencent.mm.plugin.finder.storage.c.dtL();
      Object localObject73 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject73 = (e)com.tencent.mm.plugin.finder.storage.c.dsu();
      Object localObject74 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject74 = (e)com.tencent.mm.plugin.finder.storage.c.dsv();
      Object localObject75 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject75 = (e)com.tencent.mm.plugin.finder.storage.c.dsw();
      Object localObject76 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject76 = (e)com.tencent.mm.plugin.finder.storage.c.dsx();
      Object localObject77 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject77 = (e)com.tencent.mm.plugin.finder.storage.c.dvJ();
      e locale2 = (e)new com.tencent.mm.plugin.finder.storage.config.a("直播");
      Object localObject78 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject78 = (e)com.tencent.mm.plugin.finder.storage.c.duL();
      Object localObject79 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject79 = (e)com.tencent.mm.plugin.finder.storage.c.duM();
      Object localObject80 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject80 = (e)com.tencent.mm.plugin.finder.storage.c.duN();
      Object localObject81 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject81 = (e)com.tencent.mm.plugin.finder.storage.c.duR();
      Object localObject82 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject82 = (e)com.tencent.mm.plugin.finder.storage.c.duT();
      Object localObject83 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject83 = (e)com.tencent.mm.plugin.finder.storage.c.duV();
      Object localObject84 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject84 = (e)com.tencent.mm.plugin.finder.storage.c.dvb();
      Object localObject85 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject85 = (e)com.tencent.mm.plugin.finder.storage.c.duO();
      Object localObject86 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject86 = (e)com.tencent.mm.plugin.finder.storage.c.dwi();
      Object localObject87 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject87 = (e)com.tencent.mm.plugin.finder.storage.c.dvi();
      Object localObject88 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject88 = (e)com.tencent.mm.plugin.finder.storage.c.dvl();
      Object localObject89 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject89 = (e)com.tencent.mm.plugin.finder.storage.c.dwF();
      Object localObject90 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject90 = (e)com.tencent.mm.plugin.finder.storage.c.dwG();
      Object localObject91 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject91 = (e)com.tencent.mm.plugin.finder.storage.c.dvW();
      Object localObject92 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject92 = (e)com.tencent.mm.plugin.finder.storage.c.dvX();
      Object localObject93 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject93 = (e)com.tencent.mm.plugin.finder.storage.c.dvo();
      Object localObject94 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject94 = (e)com.tencent.mm.plugin.finder.storage.c.dwd();
      Object localObject95 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject95 = (e)com.tencent.mm.plugin.finder.storage.c.dwg();
      Object localObject96 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject96 = (e)com.tencent.mm.plugin.finder.storage.c.dwe();
      Object localObject97 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject97 = (e)com.tencent.mm.plugin.finder.storage.c.dwh();
      Object localObject98 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject98 = (e)com.tencent.mm.plugin.finder.storage.c.dwf();
      Object localObject99 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject99 = (e)com.tencent.mm.plugin.finder.storage.c.dwl();
      Object localObject100 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject100 = (e)com.tencent.mm.plugin.finder.storage.c.dwm();
      Object localObject101 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject101 = (e)com.tencent.mm.plugin.finder.storage.c.dxe();
      e locale3 = (e)new com.tencent.mm.plugin.finder.storage.config.a("测试");
      Object localObject102 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject102 = (e)com.tencent.mm.plugin.finder.storage.c.dxc();
      Object localObject103 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject103 = (e)com.tencent.mm.plugin.finder.storage.c.dwB();
      Object localObject104 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject104 = (e)com.tencent.mm.plugin.finder.storage.c.dwn();
      Object localObject105 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject105 = (e)com.tencent.mm.plugin.finder.storage.c.dtJ();
      Object localObject106 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject106 = (e)com.tencent.mm.plugin.finder.storage.c.dtY();
      Object localObject107 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject107 = (e)com.tencent.mm.plugin.finder.storage.c.dsy();
      Object localObject108 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject108 = (e)com.tencent.mm.plugin.finder.storage.c.dsz();
      Object localObject109 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject109 = (e)com.tencent.mm.plugin.finder.storage.c.dsA();
      Object localObject110 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject110 = (e)com.tencent.mm.plugin.finder.storage.c.dsB();
      Object localObject111 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject111 = (e)com.tencent.mm.plugin.finder.storage.c.dsC();
      Object localObject112 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject112 = (e)com.tencent.mm.plugin.finder.storage.c.dsD();
      Object localObject113 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject113 = (e)com.tencent.mm.plugin.finder.storage.c.dsN();
      Object localObject114 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject114 = (e)com.tencent.mm.plugin.finder.storage.c.dsO();
      Object localObject115 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject115 = (e)com.tencent.mm.plugin.finder.storage.c.dsQ();
      Object localObject116 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject116 = (e)com.tencent.mm.plugin.finder.storage.c.dsT();
      Object localObject117 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject117 = (e)com.tencent.mm.plugin.finder.storage.c.dsU();
      Object localObject118 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject118 = (e)com.tencent.mm.plugin.finder.storage.c.dsV();
      Object localObject119 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject119 = (e)com.tencent.mm.plugin.finder.storage.c.dsW();
      Object localObject120 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject120 = (e)com.tencent.mm.plugin.finder.storage.c.dsX();
      Object localObject121 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject121 = (e)com.tencent.mm.plugin.finder.storage.c.dsY();
      Object localObject122 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject122 = (e)com.tencent.mm.plugin.finder.storage.c.dsZ();
      Object localObject123 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject123 = (e)com.tencent.mm.plugin.finder.storage.c.dta();
      Object localObject124 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject124 = (e)com.tencent.mm.plugin.finder.storage.c.dtb();
      Object localObject125 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject125 = (e)com.tencent.mm.plugin.finder.storage.c.dtc();
      Object localObject126 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject126 = (e)com.tencent.mm.plugin.finder.storage.c.dtd();
      Object localObject127 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject127 = (e)com.tencent.mm.plugin.finder.storage.c.dtf();
      Object localObject128 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject128 = (e)com.tencent.mm.plugin.finder.storage.c.dtg();
      Object localObject129 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject129 = (e)com.tencent.mm.plugin.finder.storage.c.dti();
      Object localObject130 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject130 = (e)com.tencent.mm.plugin.finder.storage.c.dtj();
      Object localObject131 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject131 = (e)com.tencent.mm.plugin.finder.storage.c.dtk();
      Object localObject132 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject132 = (e)com.tencent.mm.plugin.finder.storage.c.dua();
      Object localObject133 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject133 = (e)com.tencent.mm.plugin.finder.storage.c.dub();
      Object localObject134 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject134 = (e)com.tencent.mm.plugin.finder.storage.c.duc();
      e locale4 = (e)new com.tencent.mm.plugin.finder.storage.config.a("私信");
      Object localObject135 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject135 = (e)com.tencent.mm.plugin.finder.storage.c.dtG();
      Object localObject136 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject136 = (e)com.tencent.mm.plugin.finder.storage.c.dqZ();
      e locale5 = (e)new com.tencent.mm.plugin.finder.storage.config.a("三天两夜");
      Object localObject137 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject137 = (e)com.tencent.mm.plugin.finder.storage.c.duI();
      Object localObject138 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject138 = (e)com.tencent.mm.plugin.finder.storage.c.duJ();
      Object localObject139 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject139 = (e)com.tencent.mm.plugin.finder.storage.c.duK();
      e locale6 = (e)new com.tencent.mm.plugin.finder.storage.config.a("tab流预加载");
      Object localObject140 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject140 = (e)com.tencent.mm.plugin.finder.storage.c.duH();
      Object localObject141 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject141 = (e)com.tencent.mm.plugin.finder.storage.c.dsa();
      Object localObject142 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject142 = (e)com.tencent.mm.plugin.finder.storage.c.due();
      Object localObject143 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject143 = (e)com.tencent.mm.plugin.finder.storage.c.duf();
      Object localObject144 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject144 = (e)com.tencent.mm.plugin.finder.storage.c.dug();
      Object localObject145 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject145 = (e)com.tencent.mm.plugin.finder.storage.c.duh();
      Object localObject146 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject146 = (e)com.tencent.mm.plugin.finder.storage.c.dui();
      Object localObject147 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject147 = (e)com.tencent.mm.plugin.finder.storage.c.duj();
      Object localObject148 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject148 = (e)com.tencent.mm.plugin.finder.storage.c.duk();
      Object localObject149 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject149 = (e)com.tencent.mm.plugin.finder.storage.c.dul();
      Object localObject150 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject150 = (e)com.tencent.mm.plugin.finder.storage.c.dum();
      Object localObject151 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject151 = (e)com.tencent.mm.plugin.finder.storage.c.dun();
      Object localObject152 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject152 = (e)com.tencent.mm.plugin.finder.storage.c.duo();
      Object localObject153 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject153 = (e)com.tencent.mm.plugin.finder.storage.c.dup();
      Object localObject154 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject154 = (e)com.tencent.mm.plugin.finder.storage.c.duq();
      Object localObject155 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject155 = (e)com.tencent.mm.plugin.finder.storage.c.dur();
      Object localObject156 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject156 = (e)com.tencent.mm.plugin.finder.storage.c.dus();
      Object localObject157 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject157 = (e)com.tencent.mm.plugin.finder.storage.c.dut();
      Object localObject158 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject158 = (e)com.tencent.mm.plugin.finder.storage.c.duu();
      e locale7 = (e)new com.tencent.mm.plugin.finder.storage.config.a("其他");
      Object localObject159 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject159 = (e)com.tencent.mm.plugin.finder.storage.c.dtl();
      Object localObject160 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject160 = (e)com.tencent.mm.plugin.finder.storage.c.dtm();
      Object localObject161 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject161 = (e)com.tencent.mm.plugin.finder.storage.c.dtn();
      Object localObject162 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject162 = (e)com.tencent.mm.plugin.finder.storage.c.dto();
      Object localObject163 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject163 = (e)com.tencent.mm.plugin.finder.storage.c.dtq();
      Object localObject164 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject164 = (e)com.tencent.mm.plugin.finder.storage.c.dtr();
      Object localObject165 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject165 = (e)com.tencent.mm.plugin.finder.storage.c.dts();
      Object localObject166 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject166 = (e)com.tencent.mm.plugin.finder.storage.c.dtt();
      Object localObject167 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject167 = (e)com.tencent.mm.plugin.finder.storage.c.dtu();
      Object localObject168 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject168 = (e)com.tencent.mm.plugin.finder.storage.c.dtv();
      Object localObject169 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject169 = (e)com.tencent.mm.plugin.finder.storage.c.dtw();
      Object localObject170 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject170 = (e)com.tencent.mm.plugin.finder.storage.c.dtx();
      Object localObject171 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject171 = (e)com.tencent.mm.plugin.finder.storage.c.dty();
      Object localObject172 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject172 = (e)com.tencent.mm.plugin.finder.storage.c.dtz();
      Object localObject173 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject173 = (e)com.tencent.mm.plugin.finder.storage.c.dtA();
      Object localObject174 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject174 = (e)com.tencent.mm.plugin.finder.storage.c.dth();
      Object localObject175 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject175 = (e)com.tencent.mm.plugin.finder.storage.c.dtM();
      Object localObject176 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject176 = (e)com.tencent.mm.plugin.finder.storage.c.duF();
      Object localObject177 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject177 = (e)com.tencent.mm.plugin.finder.storage.c.duG();
      Object localObject178 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject178 = (e)com.tencent.mm.plugin.finder.storage.c.dvx();
      Object localObject179 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject179 = (e)com.tencent.mm.plugin.finder.storage.c.duG();
      Object localObject180 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject180 = (e)com.tencent.mm.plugin.finder.storage.c.dvA();
      Object localObject181 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject181 = (e)com.tencent.mm.plugin.finder.storage.c.dvB();
      Object localObject182 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject182 = (e)com.tencent.mm.plugin.finder.storage.c.dvC();
      Object localObject183 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject183 = (e)com.tencent.mm.plugin.finder.storage.c.dvE();
      Object localObject184 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject184 = (e)com.tencent.mm.plugin.finder.storage.c.dwo();
      Object localObject185 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject185 = (e)com.tencent.mm.plugin.finder.storage.c.dvR();
      Object localObject186 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject186 = (e)com.tencent.mm.plugin.finder.storage.c.dvS();
      Object localObject187 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject187 = (e)com.tencent.mm.plugin.finder.storage.c.dvT();
      Object localObject188 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject188 = (e)com.tencent.mm.plugin.finder.storage.c.dvU();
      Object localObject189 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject189 = (e)com.tencent.mm.plugin.finder.storage.c.dvV();
      Object localObject190 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject190 = (e)com.tencent.mm.plugin.finder.storage.c.dwj();
      Object localObject191 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject191 = (e)com.tencent.mm.plugin.finder.storage.c.dwk();
      Object localObject192 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject192 = (e)com.tencent.mm.plugin.finder.storage.c.dwC();
      Object localObject193 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject193 = (e)com.tencent.mm.plugin.finder.storage.c.dwD();
      Object localObject194 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject194 = (e)com.tencent.mm.plugin.finder.storage.c.dwE();
      Object localObject195 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject195 = (e)com.tencent.mm.plugin.finder.storage.c.dwH();
      Object localObject196 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject196 = (e)com.tencent.mm.plugin.finder.storage.c.dwI();
      Object localObject197 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject197 = (e)com.tencent.mm.plugin.finder.storage.c.dwL();
      Object localObject198 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject198 = (e)com.tencent.mm.plugin.finder.storage.c.dwJ();
      Object localObject199 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject199 = (e)com.tencent.mm.plugin.finder.storage.c.dwK();
      Object localObject200 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject200 = (e)com.tencent.mm.plugin.finder.storage.c.dwR();
      Object localObject201 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject201 = (e)com.tencent.mm.plugin.finder.storage.c.dwS();
      Object localObject202 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject202 = (e)com.tencent.mm.plugin.finder.storage.c.dwT();
      Object localObject203 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject203 = (e)com.tencent.mm.plugin.finder.storage.c.dwM();
      Object localObject204 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject204 = (e)com.tencent.mm.plugin.finder.storage.c.dwN();
      Object localObject205 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject205 = (e)com.tencent.mm.plugin.finder.storage.c.dwO();
      Object localObject206 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject206 = (e)com.tencent.mm.plugin.finder.storage.c.dwP();
      Object localObject207 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject207 = (e)com.tencent.mm.plugin.finder.storage.c.dwQ();
      Object localObject208 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject208 = (e)com.tencent.mm.plugin.finder.storage.c.dwU();
      Object localObject209 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject209 = (e)com.tencent.mm.plugin.finder.storage.c.dwV();
      Object localObject210 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject210 = (e)com.tencent.mm.plugin.finder.storage.c.dwW();
      Object localObject211 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject211 = (e)com.tencent.mm.plugin.finder.storage.c.dwZ();
      Object localObject212 = com.tencent.mm.plugin.finder.storage.c.vCb;
      localObject212 = (e)com.tencent.mm.plugin.finder.storage.c.dxa();
      com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
      paramBundle = j.ac(new e[] { paramBundle, localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, localObject9, localObject10, localObject11, localObject12, localObject13, localObject14, localObject15, localObject16, localObject17, localObject18, localObject19, localObject20, localObject21, localObject22, localObject23, localObject24, localObject25, localObject26, localObject27, localObject28, localObject29, localObject30, localObject31, localObject32, localObject33, localObject34, localObject35, localObject36, localObject37, localObject38, localObject39, localObject40, localObject41, localObject42, localObject43, localObject44, localObject45, localObject46, localObject47, localObject48, localObject49, localObject50, localObject51, localObject52, localObject53, localObject54, localObject55, localObject56, localObject57, localObject58, localObject59, locale1, localObject60, localObject61, localObject62, localObject63, localObject64, localObject65, localObject66, localObject67, localObject68, localObject69, localObject70, localObject71, localObject72, localObject73, localObject74, localObject75, localObject76, localObject77, locale2, localObject78, localObject79, localObject80, localObject81, localObject82, localObject83, localObject84, localObject85, localObject86, localObject87, localObject88, localObject89, localObject90, localObject91, localObject92, localObject93, localObject94, localObject95, localObject96, localObject97, localObject98, localObject99, localObject100, localObject101, locale3, localObject102, localObject103, localObject104, localObject105, localObject106, localObject107, localObject108, localObject109, localObject110, localObject111, localObject112, localObject113, localObject114, localObject115, localObject116, localObject117, localObject118, localObject119, localObject120, localObject121, localObject122, localObject123, localObject124, localObject125, localObject126, localObject127, localObject128, localObject129, localObject130, localObject131, localObject132, localObject133, localObject134, locale4, localObject135, localObject136, locale5, localObject137, localObject138, localObject139, locale6, localObject140, localObject141, localObject142, localObject143, localObject144, localObject145, localObject146, localObject147, localObject148, localObject149, localObject150, localObject151, localObject152, localObject153, localObject154, localObject155, localObject156, localObject157, localObject158, locale7, localObject159, localObject160, localObject161, localObject162, localObject163, localObject164, localObject165, localObject166, localObject167, localObject168, localObject169, localObject170, localObject171, localObject172, localObject173, localObject174, localObject175, localObject176, localObject177, localObject178, localObject179, localObject180, localObject181, localObject182, localObject183, localObject184, localObject185, localObject186, localObject187, localObject188, localObject189, localObject190, localObject191, localObject192, localObject193, localObject194, localObject195, localObject196, localObject197, localObject198, localObject199, localObject200, localObject201, localObject202, localObject203, localObject204, localObject205, localObject206, localObject207, localObject208, localObject209, localObject210, localObject211, localObject212, (e)com.tencent.mm.plugin.finder.storage.c.dxb() });
      vOB = paramBundle;
      localObject2 = (Iterable)paramBundle;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          if (p.j("T5", ((e)localObject3).dyq()))
          {
            ((Collection)localObject1).add(localObject3);
            continue;
            i = 0;
            break;
          }
        }
      }
      localObject1 = (List)localObject1;
      paramBundle.removeAll((Collection)localObject1);
      paramBundle.add(0, new com.tencent.mm.plugin.finder.storage.config.a("T5"));
      paramBundle.addAll(1, (Collection)localObject1);
      paramBundle = vOB;
      if (paramBundle != null)
      {
        paramBundle = ((Iterable)paramBundle).iterator();
        while (paramBundle.hasNext()) {
          ((e)paramBundle.next()).dKq = ((Activity)this);
        }
        paramBundle = x.SXb;
      }
    }
    initView();
    paramBundle = new s((byte)0);
    paramBundle.a((s.b)new b(this));
    addSearchMenu(true, paramBundle);
    AppMethodBeat.o(167662);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167663);
    super.onDestroy();
    Object localObject = vOB;
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((e)((Iterator)localObject).next()).dKq = null;
      }
      AppMethodBeat.o(167663);
      return;
    }
    AppMethodBeat.o(167663);
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(252691);
    if (!(paramPreference instanceof j.f)) {}
    for (paramf = null;; paramf = paramPreference)
    {
      paramf = (j.f)paramf;
      if (paramf != null) {
        paramf.dAo();
      }
      paramf = MediaPreloadCore.uTV;
      paramf = com.tencent.mm.plugin.finder.storage.c.vCb;
      MediaPreloadCore.nL(((Boolean)com.tencent.mm.plugin.finder.storage.c.dsv().value()).booleanValue());
      AppMethodBeat.o(252691);
      return true;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingsUI$Companion;", "", "()V", "CONFIG_ARRAY", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "Lkotlin/collections/ArrayList;", "getCONFIG_ARRAY", "()Ljava/util/ArrayList;", "setCONFIG_ARRAY", "(Ljava/util/ArrayList;)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$onCreate$searchViewHelper$1$1", "Lcom/tencent/mm/ui/tools/SearchViewHelper$ISearchListener;", "onClickClearText", "", "onEnterSearch", "onQuitSearch", "onSearchChange", "searchText", "", "onSearchEditTextReady", "onSearchKeyDown", "", "plugin-finder_release"})
  public static final class b
    implements s.b
  {
    b(FinderSettingsUI paramFinderSettingsUI) {}
    
    public final boolean SN(String paramString)
    {
      return false;
    }
    
    public final void SO(String paramString)
    {
      AppMethodBeat.i(252687);
      p.h(paramString, "searchText");
      Object localObject1 = FinderSettingsUI.a(this.vOD);
      if (localObject1 != null) {
        ((h)localObject1).removeAll();
      }
      localObject1 = this.vOD;
      Object localObject2 = FinderSettingsUI.vOC;
      localObject2 = FinderSettingsUI.dAf();
      if (localObject2 != null)
      {
        Object localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = ((Iterator)localObject3).next();
          if (n.e((CharSequence)((e)localObject4).title, (CharSequence)paramString)) {
            ((Collection)localObject2).add(localObject4);
          }
        }
      }
      for (paramString = (List)localObject2;; paramString = null)
      {
        FinderSettingsUI.a((FinderSettingsUI)localObject1, paramString);
        AppMethodBeat.o(252687);
        return;
      }
    }
    
    public final void bnA() {}
    
    public final void bnB() {}
    
    public final void bny()
    {
      AppMethodBeat.i(252688);
      Object localObject = FinderSettingsUI.a(this.vOD);
      if (localObject != null) {
        ((h)localObject).removeAll();
      }
      localObject = this.vOD;
      FinderSettingsUI.a locala = FinderSettingsUI.vOC;
      FinderSettingsUI.a((FinderSettingsUI)localObject, (List)FinderSettingsUI.dAf());
      AppMethodBeat.o(252688);
    }
    
    public final void bnz() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderSettingsUI paramFinderSettingsUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167660);
      this.vOD.finish();
      AppMethodBeat.o(167660);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingsUI
 * JD-Core Version:    0.7.0.1
 */