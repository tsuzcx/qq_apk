package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.auz;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;", "", "addAll", "", "collection", "", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "clear", "", "getNextGiftType", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "hasNext", "offer", "giftShowInfo", "peek", "peekNonPrecious", "poll", "pollNonPrecious", "registerObserver", "observer", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftAddingObserver;", "remove", "size", "", "unregisterObserver", "GiftAddingObserver", "GiftShowInfo", "GiftType", "plugin-finder_release"})
public abstract interface p
{
  public abstract void a(a parama);
  
  public abstract void b(a parama);
  
  public abstract boolean b(b paramb);
  
  public abstract c dii();
  
  public abstract b dij();
  
  public abstract b dik();
  
  public abstract b dil();
  
  public abstract boolean hasNext();
  
  public abstract int size();
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftAddingObserver;", "", "onGiftAdding", "", "giftType", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(p.c paramc);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "", "liveMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "comboId", "", "getComboId", "()Ljava/lang/String;", "setComboId", "(Ljava/lang/String;)V", "comboSumCount", "", "getComboSumCount", "()I", "setComboSumCount", "(I)V", "giftExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgLiveRewardInfo;", "getGiftExtInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgLiveRewardInfo;", "setGiftExtInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgLiveRewardInfo;)V", "giftId", "getGiftId", "setGiftId", "giftType", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "getGiftType", "()Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "setGiftType", "(Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;)V", "isPreciousGift", "", "()Z", "setPreciousGift", "(Z)V", "isSelfSend", "setSelfSend", "getLiveMsg", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "queueMsgId", "", "getQueueMsgId", "()J", "setQueueMsgId", "(J)V", "rewardCount", "getRewardCount", "setRewardCount", "compareTo", "other", "component1", "copy", "equals", "", "hashCode", "toString", "plugin-finder_release"})
  public static final class b
    implements Comparable<b>
  {
    public boolean upQ;
    public String upR;
    public int upS;
    public String upZ;
    p.c uwS;
    long uwT;
    public auz uwU;
    public int uwV;
    public boolean uwW;
    public final aut uwX;
    
    public b(aut paramaut)
    {
      AppMethodBeat.i(247286);
      this.uwX = paramaut;
      this.uwU = new auz();
      paramaut = this.uwX.LFE;
      boolean bool;
      if (paramaut != null)
      {
        paramaut = paramaut.contact;
        if (paramaut != null)
        {
          paramaut = paramaut.username;
          if ((paramaut != null) && (true == paramaut.equals(z.aTY()))) {
            bool = true;
          }
        }
      }
      for (;;)
      {
        this.upQ = bool;
        a locala = (a)this.uwU;
        paramaut = this.uwX.LFB;
        if (paramaut != null) {
          paramaut = paramaut.toByteArray();
        }
        try
        {
          for (;;)
          {
            locala.parseFrom(paramaut);
            paramaut = e.uiD;
            this.uwW = e.atB(this.uwU.LFM);
            this.upR = this.uwU.LFP;
            this.upS = this.uwU.LFO;
            this.uwV = this.uwU.LFQ;
            this.upZ = this.uwU.LFM;
            if (Util.isNullOrNil(this.upR)) {
              break label271;
            }
            i = j;
            if (this.upS <= 1)
            {
              if (this.uwV <= 1) {
                break label271;
              }
              i = j;
            }
            if (!this.upQ) {
              break label301;
            }
            if (!this.uwW) {
              break label283;
            }
            if (i == 0) {
              break label276;
            }
            paramaut = p.c.uwY;
            this.uwS = paramaut;
            AppMethodBeat.o(247286);
            return;
            bool = false;
            break;
            paramaut = null;
          }
        }
        catch (Exception paramaut)
        {
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { paramaut });
            continue;
            label271:
            int i = 0;
            continue;
            label276:
            paramaut = p.c.uwZ;
            continue;
            label283:
            if (i != 0)
            {
              paramaut = p.c.uxa;
            }
            else
            {
              paramaut = p.c.uxb;
              continue;
              label301:
              if (this.uwW)
              {
                if (i != 0) {
                  paramaut = p.c.uxc;
                } else {
                  paramaut = p.c.uxd;
                }
              }
              else if (i != 0) {
                paramaut = p.c.uxe;
              } else {
                paramaut = p.c.uxf;
              }
            }
          }
        }
      }
    }
    
    public final void c(p.c paramc)
    {
      AppMethodBeat.i(247283);
      kotlin.g.b.p.h(paramc, "<set-?>");
      this.uwS = paramc;
      AppMethodBeat.o(247283);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(247288);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if (!kotlin.g.b.p.j(this.uwX, paramObject.uwX)) {}
        }
      }
      else
      {
        AppMethodBeat.o(247288);
        return true;
      }
      AppMethodBeat.o(247288);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(247287);
      aut localaut = this.uwX;
      if (localaut != null)
      {
        int i = localaut.hashCode();
        AppMethodBeat.o(247287);
        return i;
      }
      AppMethodBeat.o(247287);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(247285);
      String str = "\n" + new StringBuilder("giftId = ").append(this.upZ).toString() + ", " + new StringBuilder("giftType = ").append(this.uwS).toString() + ", " + new StringBuilder("queueMsgId = ").append(this.uwT).toString() + ", " + new StringBuilder("comboId = ").append(this.upR).toString() + ", " + new StringBuilder("comboSumCount = ").append(this.upS).toString() + ", " + new StringBuilder("rewardCount = ").append(this.uwV).toString() + "\n";
      kotlin.g.b.p.g(str, "StringBuilder().append(\"…              .toString()");
      AppMethodBeat.o(247285);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "", "(Ljava/lang/String;I)V", "SELF_PRECIOUS_GIFT_COMBO", "SELF_PRECIOUS_GIFT_SOLO", "SELF_NORMAL_GIFT_COMBO", "SELF_NORMAL_GIFT_SOLO", "PRECIOUS_GIFT_COMBO", "PRECIOUS_GIFT_SOLO", "NORMAL_GIFT_COMBO", "NORMAL_GIFT_SOLO", "plugin-finder_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(247289);
      c localc1 = new c("SELF_PRECIOUS_GIFT_COMBO", 0);
      uwY = localc1;
      c localc2 = new c("SELF_PRECIOUS_GIFT_SOLO", 1);
      uwZ = localc2;
      c localc3 = new c("SELF_NORMAL_GIFT_COMBO", 2);
      uxa = localc3;
      c localc4 = new c("SELF_NORMAL_GIFT_SOLO", 3);
      uxb = localc4;
      c localc5 = new c("PRECIOUS_GIFT_COMBO", 4);
      uxc = localc5;
      c localc6 = new c("PRECIOUS_GIFT_SOLO", 5);
      uxd = localc6;
      c localc7 = new c("NORMAL_GIFT_COMBO", 6);
      uxe = localc7;
      c localc8 = new c("NORMAL_GIFT_SOLO", 7);
      uxf = localc8;
      uxg = new c[] { localc1, localc2, localc3, localc4, localc5, localc6, localc7, localc8 };
      AppMethodBeat.o(247289);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.p
 * JD-Core Version:    0.7.0.1
 */