package com.tencent.mm.plugin.finder.live.component;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateConfig;", "", "()V", "disableList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/component/LotteryCreateItem;", "getDisableList", "()Ljava/util/LinkedList;", "setDisableList", "(Ljava/util/LinkedList;)V", "enableComment", "", "getEnableComment", "()Z", "setEnableComment", "(Z)V", "enableLike", "getEnableLike", "setEnableLike", "enableList", "getEnableList", "setEnableList", "value", "enableRepeatLottery", "getEnableRepeatLottery", "setEnableRepeatLottery", "lastLotteryType", "", "getLastLotteryType", "()I", "setLastLotteryType", "(I)V", "lotteryList", "getLotteryList", "setLotteryList", "getLotteryTypeList", "", "getSettingFlag", "initLiveLotterySetting", "", "initLotteryTypeList", "resetLotteryTypeList", "lastType", "setLiveLotterySetting", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
{
  public static final ad.a Cza;
  private static final int[] Czh;
  private boolean Czb;
  LinkedList<at> Czc;
  LinkedList<at> Czd;
  LinkedList<at> Cze;
  int Czf;
  boolean Czg;
  private boolean ngI;
  
  static
  {
    AppMethodBeat.i(353037);
    Cza = new ad.a((byte)0);
    Czh = new int[] { 2, 1, 3, 4, 5 };
    AppMethodBeat.o(353037);
  }
  
  public ad()
  {
    AppMethodBeat.i(353021);
    this.Czc = new LinkedList();
    this.Czd = new LinkedList();
    this.Cze = new LinkedList();
    this.Czf = 1;
    Object localObject = a.CMm;
    localObject = a.emY();
    boolean bool;
    label76:
    label98:
    label109:
    int j;
    if (localObject == null)
    {
      i = 0;
      if (com.tencent.mm.ae.d.ee(i, 512)) {
        break label297;
      }
      bool = true;
      this.Czb = bool;
      localObject = a.CMm;
      localObject = a.emY();
      if (localObject != null) {
        break label302;
      }
      i = 0;
      if (com.tencent.mm.ae.d.ee(i, 8)) {
        break label333;
      }
      bool = true;
      this.ngI = bool;
      j = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adeM, 0);
      if (j != 0) {
        break label338;
      }
    }
    label297:
    label302:
    label333:
    label338:
    for (int i = 1;; i = j)
    {
      this.Czf = i;
      long l = com.tencent.mm.kernel.h.baE().ban().a(at.a.adeL, 0L);
      qr(com.tencent.mm.ae.d.ee((int)l, 1));
      Log.i("FinderLiveLotteryCreateConfig", "initLiveLotterySetting lotteryType:" + j + ", setting_flag:" + l);
      eit();
      Log.i("FinderLiveLotteryCreateConfig", "init enableLike:" + this.Czb + ",enableComment:" + this.ngI + ",enableRepeatLottery:" + this.Czg + ",currentLotteryType:" + this.Czf);
      AppMethodBeat.o(353021);
      return;
      localObject = (e)((a)localObject).business(e.class);
      if (localObject == null)
      {
        i = 0;
        break;
      }
      i = ((e)localObject).Ecp;
      break;
      bool = false;
      break label76;
      localObject = (e)((a)localObject).business(e.class);
      if (localObject == null)
      {
        i = 0;
        break label98;
      }
      i = ((e)localObject).Ecp;
      break label98;
      bool = false;
      break label109;
    }
  }
  
  private final void eis()
  {
    AppMethodBeat.i(353029);
    this.Cze.clear();
    this.Czc.clear();
    this.Czd.clear();
    AppMethodBeat.o(353029);
  }
  
  public final at eir()
  {
    AppMethodBeat.i(353050);
    Object localObject = null;
    if (this.Czc.isEmpty()) {
      eit();
    }
    Iterator localIterator = ((Iterable)this.Czc).iterator();
    if (localIterator.hasNext())
    {
      at localat = (at)localIterator.next();
      if (localat.type != this.Czf) {
        break label155;
      }
      localObject = localat;
    }
    label152:
    label155:
    for (;;)
    {
      break;
      int i;
      if (localObject == null) {
        if (!((Collection)this.Czc).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break label152;
          }
          localObject = this.Czc.get(0);
          this.Czf = ((at)this.Czc.get(0)).type;
        }
      }
      for (;;)
      {
        Log.i("FinderLiveLotteryCreateConfig", s.X("getLastLotteryType currentLotteryTypeItem:", localObject));
        localObject = (at)localObject;
        AppMethodBeat.o(353050);
        return localObject;
        i = 0;
        break;
      }
    }
  }
  
  final void eit()
  {
    AppMethodBeat.i(353069);
    eis();
    Resources localResources = MMApplicationContext.getResources();
    int[] arrayOfInt = Czh;
    int k = arrayOfInt.length;
    int i = 0;
    boolean bool1 = true;
    if (i < k)
    {
      int m = arrayOfInt[i];
      switch (m)
      {
      }
      label512:
      label515:
      for (;;)
      {
        i += 1;
        break;
        Object localObject = localResources.getString(p.h.Cmw);
        s.s(localObject, "res.getString(R.string.f…ottery_chooser_type_like)");
        localObject = new at((String)localObject, m, this.Czb, 8);
        if (this.Czb)
        {
          this.Czc.add(localObject);
        }
        else
        {
          this.Czd.add(localObject);
          continue;
          localObject = localResources.getString(p.h.Cms);
          s.s(localObject, "res.getString(R.string.f…chooser_type_any_comment)");
          localObject = new at((String)localObject, m, this.ngI, 8);
          if (this.ngI)
          {
            this.Czc.add(localObject);
            bool1 = true;
          }
          else
          {
            String str = localResources.getString(p.h.Cmt);
            s.s(str, "res.getString(R.string.f…ser_type_disable_comment)");
            ((at)localObject).setTitle(str);
            this.Czd.add(localObject);
            bool1 = false;
            continue;
            if (bool1)
            {
              localObject = this.Czc;
              str = localResources.getString(p.h.Cmx);
              s.s(str, "res.getString(R.string.f…ser_type_special_comment)");
              ((LinkedList)localObject).add(new at(str, m, bool1, 8));
              continue;
              localObject = this.Czc;
              str = localResources.getString(p.h.Cmv);
              s.s(str, "res.getString(R.string.f…tery_chooser_type_follow)");
              ((LinkedList)localObject).add(new at(str, m, true, 8));
              continue;
              localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
              boolean bool2;
              if (((Number)com.tencent.mm.plugin.finder.storage.d.eXP().bmg()).intValue() == 1)
              {
                bool2 = true;
                label378:
                Log.i("FinderLiveLotteryCreateConfig", "initLotteryTypeList isFanLotteryEnable: " + bool2 + ' ');
                localObject = a.CMm;
                localObject = a.emY();
                if (localObject == null) {
                  break label512;
                }
                localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)((a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class);
                if ((localObject == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)localObject).eyR() != true)) {
                  break label512;
                }
              }
              for (int j = 1;; j = 0)
              {
                if ((j == 0) || (!bool2)) {
                  break label515;
                }
                localObject = this.Czc;
                str = localResources.getString(p.h.Cmu);
                s.s(str, "res.getString(R.string.f…_chooser_type_fan_member)");
                ((LinkedList)localObject).add(new at(str, m, true, 8));
                break;
                bool2 = false;
                break label378;
              }
            }
          }
        }
      }
    }
    this.Cze.addAll((Collection)this.Czc);
    this.Cze.addAll((Collection)this.Czd);
    Log.i("FinderLiveLotteryCreateConfig", "generateLotteryTypeList lotteryList:" + this.Cze + ",enableList:" + this.Czc.size() + ",disableList:" + this.Czd.size());
    AppMethodBeat.o(353069);
  }
  
  public final void qr(boolean paramBoolean)
  {
    AppMethodBeat.i(353044);
    Log.i("FinderLiveLotteryCreateConfig", s.X("setEnableRepeatLottery enableRepeatLottery:", Boolean.valueOf(paramBoolean)));
    this.Czg = paramBoolean;
    AppMethodBeat.o(353044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.ad
 * JD-Core Version:    0.7.0.1
 */