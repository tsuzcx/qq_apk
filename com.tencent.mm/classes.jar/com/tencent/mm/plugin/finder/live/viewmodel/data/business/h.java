package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.d.a.a.a.d.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveFansClubSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveBuContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "value", "Lcom/tencent/mm/protocal/protobuf/FinderLiveFanClubInfo;", "fansClubInfo", "getFansClubInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveFanClubInfo;", "setFansClubInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveFanClubInfo;)V", "", "haveShowTag", "getHaveShowTag", "()Z", "setHaveShowTag", "(Z)V", "isFansClubMember", "setFansClubMember", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveGiftInfo;", "joinGift", "getJoinGift", "()Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveGiftInfo;", "setJoinGift", "(Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveGiftInfo;)V", "visitorFansClubLevel", "", "getVisitorFansClubLevel", "()I", "setVisitorFansClubLevel", "(I)V", "isOpenFunClub", "onCleared", "", "printNewFansClubInfo", "oriInfo", "newInfo", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends c<a>
{
  public static final a Efe;
  public boolean Eff;
  public bgw Efg;
  public d Efh;
  public boolean Efi;
  
  static
  {
    AppMethodBeat.i(356720);
    Efe = new a((byte)0);
    AppMethodBeat.o(356720);
  }
  
  public h(a parama)
  {
    super(parama);
    AppMethodBeat.i(356704);
    AppMethodBeat.o(356704);
  }
  
  private static void a(bgw parambgw1, bgw parambgw2)
  {
    Object localObject3 = null;
    AppMethodBeat.i(356715);
    Object localObject1;
    Object localObject2;
    if (parambgw2 == null)
    {
      localObject1 = null;
      if (parambgw1 != null) {
        break label106;
      }
      localObject2 = null;
      label20:
      if (s.p(localObject1, localObject2))
      {
        if (parambgw2 != null) {
          break label114;
        }
        localObject1 = null;
        label34:
        if (parambgw1 != null) {
          break label125;
        }
        localObject2 = null;
        label40:
        if (s.p(localObject1, localObject2))
        {
          if (parambgw2 != null) {
            break label136;
          }
          localObject1 = null;
          label54:
          if (parambgw1 != null) {
            break label147;
          }
        }
      }
    }
    label136:
    label147:
    for (parambgw1 = localObject3;; parambgw1 = Boolean.valueOf(parambgw1.ZQo))
    {
      if (!s.p(localObject1, parambgw1))
      {
        parambgw1 = parambgw2;
        if (parambgw2 == null) {
          parambgw1 = "";
        }
        Log.i("LiveFansClubSlice", s.X("printNewFansClubInfo ", f.dg(parambgw1)));
      }
      AppMethodBeat.o(356715);
      return;
      localObject1 = parambgw2.ZQn;
      break;
      label106:
      localObject2 = parambgw1.ZQn;
      break label20;
      label114:
      localObject1 = Integer.valueOf(parambgw2.YFb);
      break label34;
      label125:
      localObject2 = Integer.valueOf(parambgw1.YFb);
      break label40;
      localObject1 = Boolean.valueOf(parambgw2.ZQo);
      break label54;
    }
  }
  
  public final void a(bgw parambgw)
  {
    AppMethodBeat.i(356745);
    a(this.Efg, parambgw);
    this.Efg = parambgw;
    AppMethodBeat.o(356745);
  }
  
  public final void b(d paramd)
  {
    Object localObject3 = null;
    AppMethodBeat.i(356755);
    Object localObject2;
    label137:
    if (paramd == null)
    {
      localObject1 = null;
      localObject2 = this.Efh;
      if (localObject2 != null) {
        break label221;
      }
      localObject2 = null;
      label25:
      if (!s.p(localObject1, localObject2))
      {
        localObject2 = new StringBuilder("joinGift:");
        localObject1 = this.Efh;
        if (localObject1 != null) {
          break label229;
        }
        localObject1 = null;
        label54:
        localObject2 = ((StringBuilder)localObject2).append(localObject1).append(',');
        localObject1 = this.Efh;
        if (localObject1 != null) {
          break label237;
        }
        localObject1 = null;
        label76:
        localObject2 = ((StringBuilder)localObject2).append(localObject1).append(',');
        localObject1 = this.Efh;
        if (localObject1 != null) {
          break label248;
        }
        localObject1 = null;
        label98:
        localObject2 = ((StringBuilder)localObject2).append(localObject1).append(',');
        localObject1 = this.Efh;
        if (localObject1 != null) {
          break label259;
        }
        localObject1 = null;
        label120:
        localObject2 = ((StringBuilder)localObject2).append(localObject1).append(",new:");
        if (paramd != null) {
          break label270;
        }
        localObject1 = null;
        localObject2 = ((StringBuilder)localObject2).append(localObject1).append(',');
        if (paramd != null) {
          break label278;
        }
        localObject1 = null;
        label154:
        localObject2 = ((StringBuilder)localObject2).append(localObject1).append(',');
        if (paramd != null) {
          break label289;
        }
        localObject1 = null;
        label171:
        localObject2 = ((StringBuilder)localObject2).append(localObject1).append(',');
        if (paramd != null) {
          break label300;
        }
      }
    }
    label259:
    label270:
    label278:
    label289:
    label300:
    for (Object localObject1 = localObject3;; localObject1 = Float.valueOf(paramd.field_price))
    {
      Log.i("LiveFansClubSlice", localObject1);
      this.Efh = paramd;
      AppMethodBeat.o(356755);
      return;
      localObject1 = paramd.field_rewardProductId;
      break;
      label221:
      localObject2 = ((d)localObject2).field_rewardProductId;
      break label25;
      label229:
      localObject1 = ((d)localObject1).field_rewardProductId;
      break label54;
      label237:
      localObject1 = Integer.valueOf(((d)localObject1).field_flag);
      break label76;
      label248:
      localObject1 = Integer.valueOf(((d)localObject1).field_unlockIntimacyLevel);
      break label98;
      localObject1 = Float.valueOf(((d)localObject1).field_price);
      break label120;
      localObject1 = paramd.field_rewardProductId;
      break label137;
      localObject1 = Integer.valueOf(paramd.field_flag);
      break label154;
      localObject1 = Integer.valueOf(paramd.field_unlockIntimacyLevel);
      break label171;
    }
  }
  
  public final int eyQ()
  {
    AppMethodBeat.i(356737);
    Object localObject = ((e)business(e.class)).Ecm;
    int i;
    if (localObject == null) {
      i = 0;
    }
    for (;;)
    {
      Log.i("LiveFansClubSlice", s.X("visitorFansClubLevel:", Integer.valueOf(i)));
      AppMethodBeat.o(356737);
      return i;
      Iterator localIterator = ((Iterable)localObject).iterator();
      label55:
      if (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if (((bfl)localObject).ZPp == 4)
        {
          i = 1;
          label84:
          if (i == 0) {
            break label105;
          }
        }
      }
      for (;;)
      {
        localObject = (bfl)localObject;
        if (localObject != null) {
          break label112;
        }
        i = 0;
        break;
        i = 0;
        break label84;
        label105:
        break label55;
        localObject = null;
      }
      label112:
      i = ((bfl)localObject).ZPr;
    }
  }
  
  public final boolean eyR()
  {
    AppMethodBeat.i(356775);
    if (this.Efg != null)
    {
      bgw localbgw = this.Efg;
      localObject = localbgw;
      if (localbgw == null) {
        localObject = "";
      }
      Log.i("LiveFansClubSlice", s.X("isShowFunClub ", f.dg(localObject)));
    }
    Object localObject = this.Efg;
    if ((localObject != null) && (((bgw)localObject).ZQq == true))
    {
      i = 1;
      if (i == 0) {
        break label103;
      }
      localObject = this.Efg;
      if ((localObject == null) || (((bgw)localObject).ZQo != true)) {
        break label98;
      }
    }
    label98:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label103;
      }
      AppMethodBeat.o(356775);
      return true;
      i = 0;
      break;
    }
    label103:
    AppMethodBeat.o(356775);
    return false;
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(356766);
    sn(false);
    a(null);
    b(null);
    so(false);
    AppMethodBeat.o(356766);
  }
  
  public final void sn(boolean paramBoolean)
  {
    AppMethodBeat.i(356730);
    aw localaw = aw.Gjk;
    if (aw.bgV()) {
      Log.i("LiveFansClubSlice", "isFansClubMember:" + this.Eff + ",new:" + paramBoolean);
    }
    if (paramBoolean != this.Eff)
    {
      localaw = aw.Gjk;
      if (!aw.bgV()) {
        break label116;
      }
      Log.printInfoStack("LiveFansClubSlice", "isFansClubMember:" + this.Eff + ",new:" + paramBoolean, new Object[0]);
    }
    for (;;)
    {
      this.Eff = paramBoolean;
      AppMethodBeat.o(356730);
      return;
      label116:
      Log.i("LiveFansClubSlice", "isFansClubMember:" + this.Eff + ",new:" + paramBoolean);
    }
  }
  
  public final void so(boolean paramBoolean)
  {
    AppMethodBeat.i(356761);
    if (paramBoolean != this.Efi) {
      Log.i("LiveFansClubSlice", "haveShowTag:" + this.Efi + ",new:" + paramBoolean);
    }
    this.Efi = paramBoolean;
    AppMethodBeat.o(356761);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveFansClubSlice$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.h
 * JD-Core Version:    0.7.0.1
 */