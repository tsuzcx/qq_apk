package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.d;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.axu;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;", "", "addAll", "", "collection", "", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "clear", "", "getNextGiftType", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "hasNext", "offer", "giftShowInfo", "peek", "peekByComboId", "comboId", "", "peekByTargetUserName", "targetUserName", "peekNonPrecious", "poll", "pollByComboId", "pollByTargetUserName", "pollNonPrecious", "registerObserver", "observer", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftAddingObserver;", "remove", "size", "", "unregisterObserver", "GiftAddingObserver", "GiftShowInfo", "GiftType", "plugin-finder-base_release"})
public abstract interface p
{
  public abstract void a(a parama);
  
  public abstract b aCM(String paramString);
  
  public abstract b aCN(String paramString);
  
  public abstract b aCP(String paramString);
  
  public abstract boolean addAll(Collection<b> paramCollection);
  
  public abstract void b(a parama);
  
  public abstract boolean b(b paramb);
  
  public abstract boolean c(b paramb);
  
  public abstract void clear();
  
  public abstract c dEu();
  
  public abstract b dEv();
  
  public abstract boolean hasNext();
  
  public abstract int size();
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftAddingObserver;", "", "onGiftAdding", "", "giftType", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "plugin-finder-base_release"})
  public static abstract interface a
  {
    public abstract void a(p.c paramc);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "", "liveMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "comboId", "", "getComboId", "()Ljava/lang/String;", "setComboId", "(Ljava/lang/String;)V", "comboSumCount", "", "getComboSumCount", "()I", "setComboSumCount", "(I)V", "giftExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgLiveRewardInfo;", "getGiftExtInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgLiveRewardInfo;", "setGiftExtInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgLiveRewardInfo;)V", "giftId", "getGiftId", "setGiftId", "giftType", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "getGiftType", "()Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "setGiftType", "(Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;)V", "isPreciousGift", "", "()Z", "setPreciousGift", "(Z)V", "isSelfSend", "setSelfSend", "getLiveMsg", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "queueMsgId", "", "getQueueMsgId", "()J", "setQueueMsgId", "(J)V", "rewardCount", "getRewardCount", "setRewardCount", "targetUserName", "getTargetUserName", "setTargetUserName", "compareTo", "other", "component1", "copy", "equals", "", "hashCode", "toString", "plugin-finder-base_release"})
  public static final class b
    implements Comparable<b>
  {
    p.c yQA;
    long yQB;
    public axu yQC;
    public int yQD;
    public boolean yQE;
    public final axe yQF;
    public String yrC;
    public String yrD;
    public boolean yrt;
    public String yru;
    public int yrv;
    
    public b(axe paramaxe)
    {
      AppMethodBeat.i(261253);
      this.yQF = paramaxe;
      this.yQC = new axu();
      paramaxe = this.yQF.SJH;
      boolean bool;
      if (paramaxe != null)
      {
        paramaxe = paramaxe.contact;
        if (paramaxe != null)
        {
          paramaxe = paramaxe.username;
          if ((paramaxe != null) && (true == paramaxe.equals(z.bcZ()))) {
            bool = true;
          }
        }
      }
      for (;;)
      {
        this.yrt = bool;
        Object localObject = (a)this.yQC;
        paramaxe = this.yQF.SJE;
        if (paramaxe != null) {
          paramaxe = paramaxe.toByteArray();
        }
        try
        {
          for (;;)
          {
            ((a)localObject).parseFrom(paramaxe);
            this.yQE = ((d)h.ae(d.class)).aae(this.yQC.SKd);
            this.yru = this.yQC.SKg;
            this.yrv = this.yQC.SKf;
            this.yQD = this.yQC.SKo;
            this.yrC = this.yQC.SKd;
            if (Util.isNullOrNil(this.yru)) {
              break label320;
            }
            i = j;
            if (this.yrv <= 1)
            {
              if (this.yQD <= 1) {
                break label320;
              }
              i = j;
            }
            paramaxe = this.yQF.SJC;
            if (paramaxe != null)
            {
              paramaxe = paramaxe.contact;
              if (paramaxe != null)
              {
                localObject = paramaxe.username;
                paramaxe = (axe)localObject;
                if (localObject != null) {
                  break label252;
                }
              }
            }
            paramaxe = "";
            label252:
            this.yrD = paramaxe;
            if (!this.yrt) {
              break label350;
            }
            if (!this.yQE) {
              break label332;
            }
            if (i == 0) {
              break label325;
            }
            paramaxe = p.c.yQG;
            this.yQA = paramaxe;
            AppMethodBeat.o(261253);
            return;
            bool = false;
            break;
            paramaxe = null;
          }
        }
        catch (Exception paramaxe)
        {
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { paramaxe });
            continue;
            label320:
            int i = 0;
            continue;
            label325:
            paramaxe = p.c.yQH;
            continue;
            label332:
            if (i != 0)
            {
              paramaxe = p.c.yQI;
            }
            else
            {
              paramaxe = p.c.yQJ;
              continue;
              label350:
              if (this.yQE)
              {
                if (i != 0) {
                  paramaxe = p.c.yQK;
                } else {
                  paramaxe = p.c.yQL;
                }
              }
              else if (i != 0) {
                paramaxe = p.c.yQM;
              } else {
                paramaxe = p.c.yQN;
              }
            }
          }
        }
      }
    }
    
    public final void a(axu paramaxu)
    {
      AppMethodBeat.i(261244);
      kotlin.g.b.p.k(paramaxu, "<set-?>");
      this.yQC = paramaxu;
      AppMethodBeat.o(261244);
    }
    
    public final void aCo(String paramString)
    {
      AppMethodBeat.i(261246);
      kotlin.g.b.p.k(paramString, "<set-?>");
      this.yrD = paramString;
      AppMethodBeat.o(261246);
    }
    
    public final void c(p.c paramc)
    {
      AppMethodBeat.i(261242);
      kotlin.g.b.p.k(paramc, "<set-?>");
      this.yQA = paramc;
      AppMethodBeat.o(261242);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(261257);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if (!kotlin.g.b.p.h(this.yQF, paramObject.yQF)) {}
        }
      }
      else
      {
        AppMethodBeat.o(261257);
        return true;
      }
      AppMethodBeat.o(261257);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(261255);
      axe localaxe = this.yQF;
      if (localaxe != null)
      {
        int i = localaxe.hashCode();
        AppMethodBeat.o(261255);
        return i;
      }
      AppMethodBeat.o(261255);
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(261252);
      String str = "\n" + new StringBuilder("giftId = ").append(this.yrC).toString() + ", " + new StringBuilder("giftType = ").append(this.yQA).toString() + ", " + new StringBuilder("queueMsgId = ").append(this.yQB).toString() + ", " + new StringBuilder("comboId = ").append(this.yru).toString() + ", " + new StringBuilder("comboSumCount = ").append(this.yrv).toString() + ", " + new StringBuilder("rewardCount = ").append(this.yQD).toString() + ", " + new StringBuilder("targetUserName = ").append(this.yrD).toString() + "\n";
      kotlin.g.b.p.j(str, "StringBuilder().append(\"…              .toString()");
      AppMethodBeat.o(261252);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "", "(Ljava/lang/String;I)V", "SELF_PRECIOUS_GIFT_COMBO", "SELF_PRECIOUS_GIFT_SOLO", "SELF_NORMAL_GIFT_COMBO", "SELF_NORMAL_GIFT_SOLO", "PRECIOUS_GIFT_COMBO", "PRECIOUS_GIFT_SOLO", "NORMAL_GIFT_COMBO", "NORMAL_GIFT_SOLO", "plugin-finder-base_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(258127);
      c localc1 = new c("SELF_PRECIOUS_GIFT_COMBO", 0);
      yQG = localc1;
      c localc2 = new c("SELF_PRECIOUS_GIFT_SOLO", 1);
      yQH = localc2;
      c localc3 = new c("SELF_NORMAL_GIFT_COMBO", 2);
      yQI = localc3;
      c localc4 = new c("SELF_NORMAL_GIFT_SOLO", 3);
      yQJ = localc4;
      c localc5 = new c("PRECIOUS_GIFT_COMBO", 4);
      yQK = localc5;
      c localc6 = new c("PRECIOUS_GIFT_SOLO", 5);
      yQL = localc6;
      c localc7 = new c("NORMAL_GIFT_COMBO", 6);
      yQM = localc7;
      c localc8 = new c("NORMAL_GIFT_SOLO", 7);
      yQN = localc8;
      yQO = new c[] { localc1, localc2, localc3, localc4, localc5, localc6, localc7, localc8 };
      AppMethodBeat.o(258127);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.p
 * JD-Core Version:    0.7.0.1
 */