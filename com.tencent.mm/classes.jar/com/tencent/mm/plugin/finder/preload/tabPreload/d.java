package com.tencent.mm.plugin.finder.preload.tabPreload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.protocal.protobuf.arr;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/tabPreload/HotTabPreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "core", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;)V", "getOutTimeOutPreloadSource", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "getOuterTime", "", "isValid", "", "source", "performChangeEnterTargetTab", "", "lastTab", "", "targetTab", "performServerConfigChanged", "fromTabType", "serverConfig", "Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "plugin-finder_release"})
public final class d
  extends f
{
  public d(FinderStreamTabPreloadCore paramFinderStreamTabPreloadCore)
  {
    super(4, paramFinderStreamTabPreloadCore);
    AppMethodBeat.i(221504);
    AppMethodBeat.o(221504);
  }
  
  public final void a(int paramInt, arr paramarr)
  {
    boolean bool2 = true;
    AppMethodBeat.i(221502);
    p.h(paramarr, "serverConfig");
    super.a(paramInt, paramarr);
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    int i = ((Number)com.tencent.mm.plugin.finder.storage.b.dSh().value()).intValue();
    boolean bool1 = paramarr.OeA;
    boolean bool3;
    label102:
    long l;
    if (i >= 0)
    {
      if (i == 1) {
        bool1 = true;
      }
    }
    else
    {
      if ((paramInt == this.duh) || (!bool1) || (!this.INr)) {
        break label307;
      }
      bool3 = this.INz.Gg(this.duh);
      if (this.INy.INA == null) {
        break label273;
      }
      bool1 = true;
      l = FinderStreamTabPreloadCore.Gn(this.duh);
      if (System.currentTimeMillis() - this.INy.hfU < FinderStreamTabPreloadCore.Gn(this.duh)) {
        break label279;
      }
    }
    for (;;)
    {
      ad.i(this.TAG, "[performConfigChange] isAutoRefresh=" + bool3 + " isLoading=" + this.isLoading + " isOverTime=" + bool2 + " expired=" + l + " debugValue=" + i + " hasCache=" + bool1);
      if ((!bool3) || (this.isLoading) || ((bool1) && (!bool2))) {
        break label285;
      }
      this.INs.axH("performServerConfigChanged");
      this.INs.a((a.a)new a(this), 0L, "performConfigChange");
      AppMethodBeat.o(221502);
      return;
      bool1 = false;
      break;
      label273:
      bool1 = false;
      break label102;
      label279:
      bool2 = false;
    }
    label285:
    ad.i(this.TAG, "[performConfigChange] not need to preload. debugValue=".concat(String.valueOf(i)));
    AppMethodBeat.o(221502);
    return;
    label307:
    ad.i(this.TAG, "[performConfigChange] not need to check hot preload. debugValue=" + i + " fromTabType=" + paramInt);
    AppMethodBeat.o(221502);
  }
  
  public final boolean a(f.c paramc)
  {
    boolean bool3 = true;
    AppMethodBeat.i(221503);
    p.h(paramc, "source");
    boolean bool1;
    boolean bool4;
    boolean bool5;
    if (this.INz.bEe().fsM() == 4)
    {
      bool1 = true;
      bool4 = this.INz.Gg(this.duh);
      bool5 = super.a(paramc);
      if (!bool5) {
        break label174;
      }
      if (((paramc == f.c.INI) || (paramc == f.c.KuW)) && (bool1))
      {
        bool2 = bool3;
        if (bool4) {}
      }
      else
      {
        if ((paramc != f.c.INJ) || (!this.INr)) {
          break label174;
        }
      }
    }
    label174:
    for (boolean bool2 = bool3;; bool2 = false)
    {
      ad.i(this.TAG, "[isValid] ret=" + bool2 + " super.isValid=" + bool5 + " targetEnterHot=" + bool1 + " isAutoRefresh=" + bool4 + " isInFinder=" + this.INr);
      AppMethodBeat.o(221503);
      return bool2;
      bool1 = false;
      break;
    }
  }
  
  public final f.c bEg()
  {
    return f.c.KuW;
  }
  
  public final long bEh()
  {
    AppMethodBeat.i(221500);
    long l = FinderStreamTabPreloadCore.bu(this.duh, false);
    AppMethodBeat.o(221500);
    return l;
  }
  
  public final void ex(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221501);
    super.ex(paramInt1, paramInt2);
    if (paramInt2 != this.duh)
    {
      this.INs.axH("performChangeEnterTargetTab");
      AppMethodBeat.o(221501);
      return;
    }
    this.INs.a(this.INw, bEh(), "performChangeEnterTargetTab");
    AppMethodBeat.o(221501);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/preload/tabPreload/HotTabPreloadWorker$performServerConfigChanged$1", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "run", "", "plugin-finder_release"})
  public static final class a
    extends a.a
  {
    public final void run()
    {
      AppMethodBeat.i(221499);
      this.INp.b(f.c.INJ);
      AppMethodBeat.o(221499);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.tabPreload.d
 * JD-Core Version:    0.7.0.1
 */