package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.config.c;
import com.tencent.mm.plugin.finder.storage.config.d;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingsUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "screen", "Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter;", "getResourceId", "", "handleAddPreference", "", "list", "", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "importConfig", "initView", "intiViewByConfigArray", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "Companion", "plugin-finder_release"})
public final class FinderSettingsUI
  extends MMPreference
{
  private static List<? extends d> sHg;
  public static final a sHh;
  private final String TAG;
  private h sHf;
  
  static
  {
    AppMethodBeat.i(167667);
    sHh = new a((byte)0);
    AppMethodBeat.o(167667);
  }
  
  public FinderSettingsUI()
  {
    AppMethodBeat.i(167666);
    this.TAG = "MicroMsg.FinderDebugSettingsUI";
    AppMethodBeat.o(167666);
  }
  
  private final void jA(List<? extends d> paramList)
  {
    AppMethodBeat.i(221550);
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        d locald = (d)paramList.next();
        if ((locald instanceof com.tencent.mm.plugin.finder.storage.config.a))
        {
          h localh = this.sHf;
          if (localh != null)
          {
            PreferenceTitleCategory localPreferenceTitleCategory = new PreferenceTitleCategory((Context)this);
            localPreferenceTitleCategory.setTitle((CharSequence)locald.title);
            localh.b((Preference)localPreferenceTitleCategory);
          }
        }
        else if ((locald instanceof c))
        {
          new f.e((MMPreference)this, locald);
        }
        else if ((locald instanceof com.tencent.mm.plugin.finder.storage.config.item.integer.a))
        {
          new f.d((MMPreference)this, locald);
        }
        else if ((locald instanceof com.tencent.mm.plugin.finder.storage.config.item.longtype.a))
        {
          new f.d((MMPreference)this, locald);
        }
        else if ((locald instanceof com.tencent.mm.plugin.finder.storage.config.item.booleantype.a))
        {
          new f.c((MMPreference)this, locald);
        }
      }
      AppMethodBeat.o(221550);
      return;
    }
    AppMethodBeat.o(221550);
  }
  
  public final int getResourceId()
  {
    return 2131951769;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(204185);
    Object localObject = getPreferenceScreen();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.MMPreferenceAdapter");
      AppMethodBeat.o(204185);
      throw ((Throwable)localObject);
    }
    this.sHf = ((h)localObject);
    if (this.sHf == null) {
      p.gfZ();
    }
    jA(sHg);
    localObject = this.sHf;
    if (localObject != null)
    {
      ((h)localObject).notifyDataSetChanged();
      AppMethodBeat.o(204185);
      return;
    }
    AppMethodBeat.o(204185);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167662);
    super.onCreate(paramBundle);
    setMMTitle("视频号维修厂");
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    paramBundle = (Collection)sHg;
    if ((paramBundle == null) || (paramBundle.isEmpty())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramBundle = (com.tencent.mm.plugin.finder.storage.config.b)new com.tencent.mm.plugin.finder.storage.config.a("新版本");
        Object localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject1 = com.tencent.mm.plugin.finder.storage.b.eQo();
        Object localObject2 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject2 = com.tencent.mm.plugin.finder.storage.b.cId();
        Object localObject3 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject3 = com.tencent.mm.plugin.finder.storage.b.cIa();
        Object localObject4 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject4 = com.tencent.mm.plugin.finder.storage.b.cIm();
        Object localObject5 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject5 = com.tencent.mm.plugin.finder.storage.b.eQp();
        Object localObject6 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject6 = com.tencent.mm.plugin.finder.storage.b.eQq();
        Object localObject7 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject7 = com.tencent.mm.plugin.finder.storage.b.cIi();
        Object localObject8 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject8 = com.tencent.mm.plugin.finder.storage.b.cIj();
        Object localObject9 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject9 = com.tencent.mm.plugin.finder.storage.b.cGK();
        Object localObject10 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject10 = com.tencent.mm.plugin.finder.storage.b.cGL();
        Object localObject11 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject11 = com.tencent.mm.plugin.finder.storage.b.cGM();
        Object localObject12 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject12 = com.tencent.mm.plugin.finder.storage.b.cHN();
        Object localObject13 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject13 = com.tencent.mm.plugin.finder.storage.b.cIf();
        Object localObject14 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject14 = com.tencent.mm.plugin.finder.storage.b.cGN();
        Object localObject15 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject15 = com.tencent.mm.plugin.finder.storage.b.cHq();
        Object localObject16 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject16 = com.tencent.mm.plugin.finder.storage.b.cGO();
        Object localObject17 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject17 = com.tencent.mm.plugin.finder.storage.b.cHO();
        Object localObject18 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject18 = com.tencent.mm.plugin.finder.storage.b.cHV();
        Object localObject19 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject19 = com.tencent.mm.plugin.finder.storage.b.cIg();
        Object localObject20 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject20 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cIe();
        Object localObject21 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject21 = com.tencent.mm.plugin.finder.storage.b.cIl();
        com.tencent.mm.plugin.finder.storage.config.b localb1 = (com.tencent.mm.plugin.finder.storage.config.b)new com.tencent.mm.plugin.finder.storage.config.a("体验相关");
        Object localObject22 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject22 = com.tencent.mm.plugin.finder.storage.b.cHX();
        Object localObject23 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject23 = com.tencent.mm.plugin.finder.storage.b.cHY();
        Object localObject24 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject24 = com.tencent.mm.plugin.finder.storage.b.cGP();
        Object localObject25 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject25 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cGQ();
        Object localObject26 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject26 = com.tencent.mm.plugin.finder.storage.b.cGR();
        Object localObject27 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject27 = com.tencent.mm.plugin.finder.storage.b.cGS();
        com.tencent.mm.plugin.finder.storage.config.b localb2 = (com.tencent.mm.plugin.finder.storage.config.b)new com.tencent.mm.plugin.finder.storage.config.a("测试");
        Object localObject28 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject28 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cIk();
        Object localObject29 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject29 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cGT();
        Object localObject30 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject30 = com.tencent.mm.plugin.finder.storage.b.cGU();
        Object localObject31 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject31 = com.tencent.mm.plugin.finder.storage.b.cGV();
        Object localObject32 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject32 = com.tencent.mm.plugin.finder.storage.b.cGW();
        Object localObject33 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject33 = com.tencent.mm.plugin.finder.storage.b.cGX();
        Object localObject34 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject34 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cGY();
        Object localObject35 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject35 = com.tencent.mm.plugin.finder.storage.b.cGZ();
        Object localObject36 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject36 = com.tencent.mm.plugin.finder.storage.b.cHa();
        Object localObject37 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject37 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cHc();
        Object localObject38 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject38 = com.tencent.mm.plugin.finder.storage.b.cHf();
        Object localObject39 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject39 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cHg();
        Object localObject40 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject40 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cHh();
        Object localObject41 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject41 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cHi();
        Object localObject42 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject42 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cHj();
        Object localObject43 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject43 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cHk();
        Object localObject44 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject44 = com.tencent.mm.plugin.finder.storage.b.cHl();
        Object localObject45 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject45 = com.tencent.mm.plugin.finder.storage.b.cHm();
        Object localObject46 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject46 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cHn();
        Object localObject47 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject47 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cHo();
        Object localObject48 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject48 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cHp();
        Object localObject49 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject49 = com.tencent.mm.plugin.finder.storage.b.cHr();
        Object localObject50 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject50 = com.tencent.mm.plugin.finder.storage.b.cHs();
        Object localObject51 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject51 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cHu();
        Object localObject52 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject52 = com.tencent.mm.plugin.finder.storage.b.cHv();
        Object localObject53 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject53 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cHw();
        com.tencent.mm.plugin.finder.storage.config.b localb3 = (com.tencent.mm.plugin.finder.storage.config.b)new com.tencent.mm.plugin.finder.storage.config.a("其他");
        Object localObject54 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject54 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cHx();
        Object localObject55 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject55 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cHy();
        Object localObject56 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject56 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cHz();
        Object localObject57 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject57 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cHA();
        Object localObject58 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject58 = com.tencent.mm.plugin.finder.storage.b.cHB();
        Object localObject59 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject59 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cHC();
        Object localObject60 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject60 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cHD();
        Object localObject61 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject61 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cHE();
        Object localObject62 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject62 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cHF();
        Object localObject63 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject63 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cHG();
        Object localObject64 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject64 = com.tencent.mm.plugin.finder.storage.b.cHH();
        Object localObject65 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject65 = com.tencent.mm.plugin.finder.storage.b.cHI();
        Object localObject66 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject66 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cHL();
        Object localObject67 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject67 = com.tencent.mm.plugin.finder.storage.b.cHM();
        Object localObject68 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject68 = com.tencent.mm.plugin.finder.storage.b.cHt();
        Object localObject69 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject69 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cHZ();
        com.tencent.mm.plugin.finder.storage.config.b localb4 = (com.tencent.mm.plugin.finder.storage.config.b)new com.tencent.mm.plugin.finder.storage.config.a("私信");
        Object localObject70 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject70 = com.tencent.mm.plugin.finder.storage.b.cHS();
        Object localObject71 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject71 = com.tencent.mm.plugin.finder.storage.b.cFs();
        com.tencent.mm.plugin.finder.storage.config.b localb5 = (com.tencent.mm.plugin.finder.storage.config.b)new com.tencent.mm.plugin.finder.storage.config.a("tab流预加载");
        Object localObject72 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject72 = com.tencent.mm.plugin.finder.storage.b.cGt();
        Object localObject73 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject73 = com.tencent.mm.plugin.finder.storage.b.cHT();
        Object localObject74 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject74 = com.tencent.mm.plugin.finder.storage.b.cNk();
        Object localObject75 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject75 = com.tencent.mm.plugin.finder.storage.b.cOe();
        Object localObject76 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject76 = com.tencent.mm.plugin.finder.storage.b.cOg();
        Object localObject77 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject77 = com.tencent.mm.plugin.finder.storage.b.cOh();
        Object localObject78 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject78 = com.tencent.mm.plugin.finder.storage.b.cOi();
        Object localObject79 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject79 = com.tencent.mm.plugin.finder.storage.b.cOj();
        Object localObject80 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject80 = com.tencent.mm.plugin.finder.storage.b.cOk();
        Object localObject81 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject81 = com.tencent.mm.plugin.finder.storage.b.cVi();
        Object localObject82 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject82 = com.tencent.mm.plugin.finder.storage.b.cVm();
        Object localObject83 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject83 = com.tencent.mm.plugin.finder.storage.b.dbP();
        Object localObject84 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject84 = com.tencent.mm.plugin.finder.storage.b.dbQ();
        Object localObject85 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject85 = com.tencent.mm.plugin.finder.storage.b.dRe();
        Object localObject86 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject86 = com.tencent.mm.plugin.finder.storage.b.dSc();
        Object localObject87 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject87 = com.tencent.mm.plugin.finder.storage.b.dSf();
        Object localObject88 = com.tencent.mm.plugin.finder.storage.b.sxa;
        localObject88 = com.tencent.mm.plugin.finder.storage.b.dSg();
        com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
        sHg = j.listOf(new com.tencent.mm.plugin.finder.storage.config.b[] { paramBundle, localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, localObject9, localObject10, localObject11, localObject12, localObject13, localObject14, localObject15, localObject16, localObject17, localObject18, localObject19, localObject20, localObject21, localb1, localObject22, localObject23, localObject24, localObject25, localObject26, localObject27, localb2, localObject28, localObject29, localObject30, localObject31, localObject32, localObject33, localObject34, localObject35, localObject36, localObject37, localObject38, localObject39, localObject40, localObject41, localObject42, localObject43, localObject44, localObject45, localObject46, localObject47, localObject48, localObject49, localObject50, localObject51, localObject52, localObject53, localb3, localObject54, localObject55, localObject56, localObject57, localObject58, localObject59, localObject60, localObject61, localObject62, localObject63, localObject64, localObject65, localObject66, localObject67, localObject68, localObject69, localb4, localObject70, localObject71, localb5, localObject72, localObject73, localObject74, localObject75, localObject76, localObject77, localObject78, localObject79, localObject80, localObject81, localObject82, localObject83, localObject84, localObject85, localObject86, localObject87, localObject88, com.tencent.mm.plugin.finder.storage.b.dSh() });
      }
      initView();
      paramBundle = new r((byte)0);
      paramBundle.a((r.b)new FinderSettingsUI.c(this));
      addSearchMenu(true, paramBundle);
      AppMethodBeat.o(167662);
      return;
    }
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(204186);
    if (!(paramPreference instanceof f.f)) {}
    for (paramf = null;; paramf = paramPreference)
    {
      paramf = (f.f)paramf;
      if (paramf != null) {
        paramf.cKx();
      }
      paramf = MediaPreloadCore.skO;
      paramf = com.tencent.mm.plugin.finder.storage.b.sxa;
      MediaPreloadCore.lW(((Boolean)com.tencent.mm.plugin.finder.storage.b.cGQ().value()).booleanValue());
      AppMethodBeat.o(204186);
      return true;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingsUI$Companion;", "", "()V", "CONFIG_ARRAY", "", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "getCONFIG_ARRAY", "()Ljava/util/List;", "setCONFIG_ARRAY", "(Ljava/util/List;)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderSettingsUI paramFinderSettingsUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167660);
      this.sHi.finish();
      AppMethodBeat.o(167660);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingsUI
 * JD-Core Version:    0.7.0.1
 */