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
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderSettingsUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "screen", "Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter;", "getResourceId", "", "handleAddPreference", "", "list", "", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "importConfig", "initView", "intiViewByConfigArray", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "Companion", "plugin-finder_release"})
public final class FinderSettingsUI
  extends MMPreference
{
  private static List<? extends d> sSf;
  public static final FinderSettingsUI.a sSg;
  private final String TAG;
  private h sSe;
  
  static
  {
    AppMethodBeat.i(167667);
    sSg = new FinderSettingsUI.a((byte)0);
    AppMethodBeat.o(167667);
  }
  
  public FinderSettingsUI()
  {
    AppMethodBeat.i(167666);
    this.TAG = "MicroMsg.FinderDebugSettingsUI";
    AppMethodBeat.o(167666);
  }
  
  private final void dO(List<? extends d> paramList)
  {
    AppMethodBeat.i(204790);
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        d locald = (d)paramList.next();
        if ((locald instanceof com.tencent.mm.plugin.finder.storage.config.a))
        {
          h localh = this.sSe;
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
      AppMethodBeat.o(204790);
      return;
    }
    AppMethodBeat.o(204790);
  }
  
  public final int getResourceId()
  {
    return 2131951769;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(204791);
    Object localObject = getPreferenceScreen();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.MMPreferenceAdapter");
      AppMethodBeat.o(204791);
      throw ((Throwable)localObject);
    }
    this.sSe = ((h)localObject);
    if (this.sSe == null) {
      p.gkB();
    }
    dO(sSf);
    localObject = this.sSe;
    if (localObject != null)
    {
      ((h)localObject).notifyDataSetChanged();
      AppMethodBeat.o(204791);
      return;
    }
    AppMethodBeat.o(204791);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167662);
    super.onCreate(paramBundle);
    setMMTitle("视频号维修厂");
    setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
    paramBundle = (Collection)sSf;
    if ((paramBundle == null) || (paramBundle.isEmpty())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramBundle = (com.tencent.mm.plugin.finder.storage.config.b)new com.tencent.mm.plugin.finder.storage.config.a("新版本");
        Object localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject1 = com.tencent.mm.plugin.finder.storage.b.cKG();
        Object localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject2 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cKI();
        Object localObject3 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject3 = com.tencent.mm.plugin.finder.storage.b.cKE();
        Object localObject4 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject4 = com.tencent.mm.plugin.finder.storage.b.cKg();
        Object localObject5 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject5 = com.tencent.mm.plugin.finder.storage.b.cKB();
        Object localObject6 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject6 = com.tencent.mm.plugin.finder.storage.b.cJZ();
        Object localObject7 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject7 = com.tencent.mm.plugin.finder.storage.b.cJW();
        Object localObject8 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject8 = com.tencent.mm.plugin.finder.storage.b.cKj();
        Object localObject9 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject9 = com.tencent.mm.plugin.finder.storage.b.cKC();
        Object localObject10 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject10 = com.tencent.mm.plugin.finder.storage.b.cKD();
        Object localObject11 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject11 = com.tencent.mm.plugin.finder.storage.b.cKF();
        Object localObject12 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject12 = com.tencent.mm.plugin.finder.storage.b.cKe();
        Object localObject13 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject13 = com.tencent.mm.plugin.finder.storage.b.cKf();
        Object localObject14 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject14 = com.tencent.mm.plugin.finder.storage.b.cII();
        Object localObject15 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject15 = com.tencent.mm.plugin.finder.storage.b.cIK();
        Object localObject16 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject16 = com.tencent.mm.plugin.finder.storage.b.cIL();
        Object localObject17 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject17 = com.tencent.mm.plugin.finder.storage.b.cJK();
        Object localObject18 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject18 = com.tencent.mm.plugin.finder.storage.b.cKb();
        Object localObject19 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject19 = com.tencent.mm.plugin.finder.storage.b.cIM();
        Object localObject20 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject20 = com.tencent.mm.plugin.finder.storage.b.cJp();
        Object localObject21 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject21 = com.tencent.mm.plugin.finder.storage.b.cIN();
        Object localObject22 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject22 = com.tencent.mm.plugin.finder.storage.b.cJL();
        Object localObject23 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject23 = com.tencent.mm.plugin.finder.storage.b.cJR();
        Object localObject24 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject24 = com.tencent.mm.plugin.finder.storage.b.cKc();
        Object localObject25 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject25 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cKa();
        Object localObject26 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject26 = com.tencent.mm.plugin.finder.storage.b.cKi();
        com.tencent.mm.plugin.finder.storage.config.b localb1 = (com.tencent.mm.plugin.finder.storage.config.b)new com.tencent.mm.plugin.finder.storage.config.a("体验相关");
        Object localObject27 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject27 = com.tencent.mm.plugin.finder.storage.b.cJT();
        Object localObject28 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject28 = com.tencent.mm.plugin.finder.storage.b.cJU();
        Object localObject29 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject29 = com.tencent.mm.plugin.finder.storage.b.cIO();
        Object localObject30 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject30 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cIP();
        Object localObject31 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject31 = com.tencent.mm.plugin.finder.storage.b.cIQ();
        Object localObject32 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject32 = com.tencent.mm.plugin.finder.storage.b.cIR();
        com.tencent.mm.plugin.finder.storage.config.b localb2 = (com.tencent.mm.plugin.finder.storage.config.b)new com.tencent.mm.plugin.finder.storage.config.a("测试");
        Object localObject33 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject33 = com.tencent.mm.plugin.finder.storage.b.cJS();
        Object localObject34 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject34 = com.tencent.mm.plugin.finder.storage.b.cKh();
        Object localObject35 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject35 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cIS();
        Object localObject36 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject36 = com.tencent.mm.plugin.finder.storage.b.cIT();
        Object localObject37 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject37 = com.tencent.mm.plugin.finder.storage.b.cIU();
        Object localObject38 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject38 = com.tencent.mm.plugin.finder.storage.b.cIV();
        Object localObject39 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject39 = com.tencent.mm.plugin.finder.storage.b.cIW();
        Object localObject40 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject40 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cIX();
        Object localObject41 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject41 = com.tencent.mm.plugin.finder.storage.b.cIY();
        Object localObject42 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject42 = com.tencent.mm.plugin.finder.storage.b.cIZ();
        Object localObject43 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject43 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cJb();
        Object localObject44 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject44 = com.tencent.mm.plugin.finder.storage.b.cJe();
        Object localObject45 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject45 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cJf();
        Object localObject46 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject46 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cJg();
        Object localObject47 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject47 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cJh();
        Object localObject48 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject48 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cJi();
        Object localObject49 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject49 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cJj();
        Object localObject50 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject50 = com.tencent.mm.plugin.finder.storage.b.cJk();
        Object localObject51 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject51 = com.tencent.mm.plugin.finder.storage.b.cJl();
        Object localObject52 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject52 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cJm();
        Object localObject53 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject53 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cJn();
        Object localObject54 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject54 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cJo();
        Object localObject55 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject55 = com.tencent.mm.plugin.finder.storage.b.cJq();
        Object localObject56 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject56 = com.tencent.mm.plugin.finder.storage.b.cJr();
        Object localObject57 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject57 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cJt();
        Object localObject58 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject58 = com.tencent.mm.plugin.finder.storage.b.cJu();
        Object localObject59 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject59 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cJv();
        com.tencent.mm.plugin.finder.storage.config.b localb3 = (com.tencent.mm.plugin.finder.storage.config.b)new com.tencent.mm.plugin.finder.storage.config.a("私信");
        Object localObject60 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject60 = com.tencent.mm.plugin.finder.storage.b.cJP();
        Object localObject61 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject61 = com.tencent.mm.plugin.finder.storage.b.cHp();
        com.tencent.mm.plugin.finder.storage.config.b localb4 = (com.tencent.mm.plugin.finder.storage.config.b)new com.tencent.mm.plugin.finder.storage.config.a("三天两夜");
        Object localObject62 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject62 = com.tencent.mm.plugin.finder.storage.b.cKN();
        Object localObject63 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject63 = com.tencent.mm.plugin.finder.storage.b.cKO();
        Object localObject64 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject64 = com.tencent.mm.plugin.finder.storage.b.cKP();
        com.tencent.mm.plugin.finder.storage.config.b localb5 = (com.tencent.mm.plugin.finder.storage.config.b)new com.tencent.mm.plugin.finder.storage.config.a("tab流预加载");
        Object localObject65 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject65 = com.tencent.mm.plugin.finder.storage.b.cKM();
        Object localObject66 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject66 = com.tencent.mm.plugin.finder.storage.b.cIq();
        Object localObject67 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject67 = com.tencent.mm.plugin.finder.storage.b.cKk();
        Object localObject68 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject68 = com.tencent.mm.plugin.finder.storage.b.cKl();
        Object localObject69 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject69 = com.tencent.mm.plugin.finder.storage.b.cKm();
        Object localObject70 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject70 = com.tencent.mm.plugin.finder.storage.b.cKn();
        Object localObject71 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject71 = com.tencent.mm.plugin.finder.storage.b.cKo();
        Object localObject72 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject72 = com.tencent.mm.plugin.finder.storage.b.cKp();
        Object localObject73 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject73 = com.tencent.mm.plugin.finder.storage.b.cKq();
        Object localObject74 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject74 = com.tencent.mm.plugin.finder.storage.b.cKr();
        Object localObject75 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject75 = com.tencent.mm.plugin.finder.storage.b.cKs();
        Object localObject76 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject76 = com.tencent.mm.plugin.finder.storage.b.cKt();
        Object localObject77 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject77 = com.tencent.mm.plugin.finder.storage.b.cKu();
        Object localObject78 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject78 = com.tencent.mm.plugin.finder.storage.b.cKv();
        Object localObject79 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject79 = com.tencent.mm.plugin.finder.storage.b.cKw();
        Object localObject80 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject80 = com.tencent.mm.plugin.finder.storage.b.cKx();
        Object localObject81 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject81 = com.tencent.mm.plugin.finder.storage.b.cKy();
        Object localObject82 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject82 = com.tencent.mm.plugin.finder.storage.b.cKz();
        Object localObject83 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject83 = com.tencent.mm.plugin.finder.storage.b.cKA();
        com.tencent.mm.plugin.finder.storage.config.b localb6 = (com.tencent.mm.plugin.finder.storage.config.b)new com.tencent.mm.plugin.finder.storage.config.a("其他");
        Object localObject84 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject84 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cJw();
        Object localObject85 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject85 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cJx();
        Object localObject86 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject86 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cJy();
        Object localObject87 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject87 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cJz();
        Object localObject88 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject88 = com.tencent.mm.plugin.finder.storage.b.cJA();
        Object localObject89 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject89 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cJB();
        Object localObject90 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject90 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cJC();
        Object localObject91 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject91 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cJD();
        Object localObject92 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject92 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cJE();
        Object localObject93 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject93 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cJF();
        Object localObject94 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject94 = com.tencent.mm.plugin.finder.storage.b.cJG();
        Object localObject95 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject95 = com.tencent.mm.plugin.finder.storage.b.cJH();
        Object localObject96 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject96 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cJI();
        Object localObject97 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject97 = com.tencent.mm.plugin.finder.storage.b.cJJ();
        Object localObject98 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject98 = com.tencent.mm.plugin.finder.storage.b.cJs();
        Object localObject99 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject99 = (com.tencent.mm.plugin.finder.storage.config.b)com.tencent.mm.plugin.finder.storage.b.cJV();
        Object localObject100 = com.tencent.mm.plugin.finder.storage.b.sHP;
        localObject100 = com.tencent.mm.plugin.finder.storage.b.cKK();
        com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
        sSf = j.listOf(new com.tencent.mm.plugin.finder.storage.config.b[] { paramBundle, localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, localObject9, localObject10, localObject11, localObject12, localObject13, localObject14, localObject15, localObject16, localObject17, localObject18, localObject19, localObject20, localObject21, localObject22, localObject23, localObject24, localObject25, localObject26, localb1, localObject27, localObject28, localObject29, localObject30, localObject31, localObject32, localb2, localObject33, localObject34, localObject35, localObject36, localObject37, localObject38, localObject39, localObject40, localObject41, localObject42, localObject43, localObject44, localObject45, localObject46, localObject47, localObject48, localObject49, localObject50, localObject51, localObject52, localObject53, localObject54, localObject55, localObject56, localObject57, localObject58, localObject59, localb3, localObject60, localObject61, localb4, localObject62, localObject63, localObject64, localb5, localObject65, localObject66, localObject67, localObject68, localObject69, localObject70, localObject71, localObject72, localObject73, localObject74, localObject75, localObject76, localObject77, localObject78, localObject79, localObject80, localObject81, localObject82, localObject83, localb6, localObject84, localObject85, localObject86, localObject87, localObject88, localObject89, localObject90, localObject91, localObject92, localObject93, localObject94, localObject95, localObject96, localObject97, localObject98, localObject99, localObject100, com.tencent.mm.plugin.finder.storage.b.cKL() });
      }
      initView();
      paramBundle = new r((byte)0);
      paramBundle.a((r.b)new b(this));
      addSearchMenu(true, paramBundle);
      AppMethodBeat.o(167662);
      return;
    }
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(204792);
    if (!(paramPreference instanceof f.f)) {}
    for (paramf = null;; paramf = paramPreference)
    {
      paramf = (f.f)paramf;
      if (paramf != null) {
        paramf.cNb();
      }
      paramf = MediaPreloadCore.stL;
      paramf = com.tencent.mm.plugin.finder.storage.b.sHP;
      MediaPreloadCore.lW(((Boolean)com.tencent.mm.plugin.finder.storage.b.cIP().value()).booleanValue());
      AppMethodBeat.o(204792);
      return true;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$onCreate$searchViewHelper$1$1", "Lcom/tencent/mm/ui/tools/SearchViewHelper$ISearchListener;", "onClickClearText", "", "onEnterSearch", "onQuitSearch", "onSearchChange", "searchText", "", "onSearchEditTextReady", "onSearchKeyDown", "", "plugin-finder_release"})
  public static final class b
    implements r.b
  {
    b(FinderSettingsUI paramFinderSettingsUI) {}
    
    public final boolean JO(String paramString)
    {
      return false;
    }
    
    public final void JP(String paramString)
    {
      AppMethodBeat.i(204788);
      p.h(paramString, "searchText");
      Object localObject1 = FinderSettingsUI.a(this.sSh);
      if (localObject1 != null) {
        ((h)localObject1).removeAll();
      }
      localObject1 = this.sSh;
      Object localObject2 = FinderSettingsUI.sSg;
      localObject2 = FinderSettingsUI.cMV();
      if (localObject2 != null)
      {
        Object localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = ((Iterator)localObject3).next();
          if (n.f((CharSequence)((d)localObject4).title, (CharSequence)paramString)) {
            ((Collection)localObject2).add(localObject4);
          }
        }
      }
      for (paramString = (List)localObject2;; paramString = null)
      {
        FinderSettingsUI.a((FinderSettingsUI)localObject1, paramString);
        AppMethodBeat.o(204788);
        return;
      }
    }
    
    public final void aSL()
    {
      AppMethodBeat.i(204789);
      Object localObject = FinderSettingsUI.a(this.sSh);
      if (localObject != null) {
        ((h)localObject).removeAll();
      }
      localObject = this.sSh;
      FinderSettingsUI.a locala = FinderSettingsUI.sSg;
      FinderSettingsUI.a((FinderSettingsUI)localObject, FinderSettingsUI.cMV());
      AppMethodBeat.o(204789);
    }
    
    public final void aSM() {}
    
    public final void aSN() {}
    
    public final void aSO() {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderSettingsUI paramFinderSettingsUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167660);
      this.sSh.finish();
      AppMethodBeat.o(167660);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingsUI
 * JD-Core Version:    0.7.0.1
 */