package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.k;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bek;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "", "liveMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "comboId", "", "getComboId", "()Ljava/lang/String;", "setComboId", "(Ljava/lang/String;)V", "comboSumCount", "", "getComboSumCount", "()I", "setComboSumCount", "(I)V", "giftExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgLiveRewardInfo;", "getGiftExtInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgLiveRewardInfo;", "setGiftExtInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgLiveRewardInfo;)V", "giftId", "getGiftId", "setGiftId", "giftType", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "getGiftType", "()Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "setGiftType", "(Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;)V", "isPreciousGift", "", "()Z", "setPreciousGift", "(Z)V", "isSelfSend", "setSelfSend", "getLiveMsg", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "queueMsgId", "", "getQueueMsgId", "()J", "setQueueMsgId", "(J)V", "rewardCount", "getRewardCount", "setRewardCount", "targetUserName", "getTargetUserName", "setTargetUserName", "compareTo", "other", "component1", "copy", "equals", "", "hashCode", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s$b
  implements Comparable<b>
{
  public final bdm DJk;
  s.c DJl;
  long DJm;
  public bek DJn;
  public int DJo;
  public boolean DJp;
  public String DbF;
  public String DbG;
  public boolean Dbw;
  public String Dbx;
  public int Dby;
  
  public s$b(bdm parambdm)
  {
    AppMethodBeat.i(351375);
    this.DJk = parambdm;
    this.DJn = new bek();
    parambdm = this.DJk.ZOb;
    if (parambdm == null) {
      parambdm = null;
    }
    for (;;)
    {
      Object localObject = (CharSequence)parambdm;
      int i;
      label73:
      boolean bool;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0))
      {
        i = 1;
        if ((i != 0) || ((!parambdm.equals(z.bAM())) && (!parambdm.equals(z.bAW())) && (!parambdm.equals(z.bAX())))) {
          break label325;
        }
        bool = true;
        label110:
        this.Dbw = bool;
        localObject = (a)this.DJn;
        parambdm = this.DJk.ZNY;
        if (parambdm != null) {
          break label331;
        }
        parambdm = str;
      }
      try
      {
        for (;;)
        {
          ((a)localObject).parseFrom(parambdm);
          this.DJp = ((k)h.ax(k.class)).Sy(this.DJn.ZOC);
          this.Dbx = this.DJn.ZOF;
          this.Dby = this.DJn.ZOE;
          this.DJo = this.DJn.ZOS;
          this.DbF = this.DJn.ZOC;
          if (Util.isNullOrNil(this.Dbx)) {
            break label358;
          }
          i = j;
          if (this.Dby <= 1)
          {
            if (this.DJo <= 1) {
              break label358;
            }
            i = j;
          }
          parambdm = this.DJk.ZNW;
          if (parambdm != null) {
            break label363;
          }
          parambdm = "";
          this.DbG = parambdm;
          if (!this.Dbw) {
            break label423;
          }
          if (!this.DJp) {
            break label405;
          }
          if (i == 0) {
            break label398;
          }
          parambdm = s.c.DJq;
          this.DJl = parambdm;
          AppMethodBeat.o(351375);
          return;
          parambdm = parambdm.contact;
          if (parambdm == null)
          {
            parambdm = null;
            break;
          }
          parambdm = parambdm.username;
          break;
          i = 0;
          break label73;
          label325:
          bool = false;
          break label110;
          label331:
          parambdm = parambdm.toByteArray();
        }
      }
      catch (Exception parambdm)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { parambdm });
          continue;
          label358:
          i = 0;
          continue;
          label363:
          parambdm = parambdm.contact;
          if (parambdm == null)
          {
            parambdm = "";
          }
          else
          {
            str = parambdm.username;
            parambdm = str;
            if (str == null)
            {
              parambdm = "";
              continue;
              label398:
              parambdm = s.c.DJr;
              continue;
              label405:
              if (i != 0)
              {
                parambdm = s.c.DJs;
              }
              else
              {
                parambdm = s.c.DJt;
                continue;
                label423:
                if (this.DJp)
                {
                  if (i != 0) {
                    parambdm = s.c.DJu;
                  } else {
                    parambdm = s.c.DJv;
                  }
                }
                else if (i != 0) {
                  parambdm = s.c.DJw;
                } else {
                  parambdm = s.c.DJx;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void a(bek parambek)
  {
    AppMethodBeat.i(351405);
    s.u(parambek, "<set-?>");
    this.DJn = parambek;
    AppMethodBeat.o(351405);
  }
  
  public final void awW(String paramString)
  {
    AppMethodBeat.i(351413);
    s.u(paramString, "<set-?>");
    this.DbG = paramString;
    AppMethodBeat.o(351413);
  }
  
  public final void c(s.c paramc)
  {
    AppMethodBeat.i(351391);
    s.u(paramc, "<set-?>");
    this.DJl = paramc;
    AppMethodBeat.o(351391);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(351445);
    if (this == paramObject)
    {
      AppMethodBeat.o(351445);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(351445);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.DJk, paramObject.DJk))
    {
      AppMethodBeat.o(351445);
      return false;
    }
    AppMethodBeat.o(351445);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(351437);
    int i = this.DJk.hashCode();
    AppMethodBeat.o(351437);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(351428);
    String str = s.X("giftId = ", this.DbF) + ", " + s.X("giftType = ", this.DJl) + ", " + s.X("queueMsgId = ", Long.valueOf(this.DJm)) + ", " + s.X("comboId = ", this.Dbx) + ", " + s.X("comboSumCount = ", Integer.valueOf(this.Dby)) + ", " + s.X("rewardCount = ", Integer.valueOf(this.DJo)) + ", " + s.X("targetUserName = ", this.DbG);
    s.s(str, "StringBuilder()\n        …              .toString()");
    AppMethodBeat.o(351428);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.s.b
 * JD-Core Version:    0.7.0.1
 */