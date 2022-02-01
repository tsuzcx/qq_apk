package com.tencent.mm.plugin.finder.live.model;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.viewmodel.data.e;
import com.tencent.mm.protocal.protobuf.edv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBattleData;", "", "battleId", "", "battleSeq", "", "leftTime", "", "battleResult", "battleStatus", "playerInfo", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveBattlePlayerInfo;", "(Ljava/lang/String;JIIILjava/util/List;)V", "TAG", "getBattleId", "()Ljava/lang/String;", "setBattleId", "(Ljava/lang/String;)V", "getBattleResult", "()I", "setBattleResult", "(I)V", "getBattleSeq", "()J", "setBattleSeq", "(J)V", "getBattleStatus", "setBattleStatus", "getLeftTime", "setLeftTime", "getPlayerInfo", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "getOtherBattleUser", "anchorUsername", "getSelfBattleUser", "hashCode", "isStartWait", "toString", "transEnd", "", "endResult", "transStart", "updatePlayerInfo", "remotePlayerInfo", "", "Lcom/tencent/mm/protocal/protobuf/PlayerInfo;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public String CES;
  public long CET;
  public int CEU;
  public int CEV;
  public int CEW;
  public final List<e> CEX;
  private final String TAG;
  
  public i()
  {
    this(null, 0L, 0, 0, 0, null, 63);
  }
  
  private i(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3, List<e> paramList)
  {
    AppMethodBeat.i(359320);
    this.CES = paramString;
    this.CET = paramLong;
    this.CEU = paramInt1;
    this.CEV = paramInt2;
    this.CEW = paramInt3;
    this.CEX = paramList;
    this.TAG = "Finder.FinderLiveBattleData";
    AppMethodBeat.o(359320);
  }
  
  public final void OO(int paramInt)
  {
    this.CEW = 3;
    this.CEV = paramInt;
  }
  
  public final e awt(String paramString)
  {
    AppMethodBeat.i(359352);
    Log.i(this.TAG, s.X("getOtherBattleUser anchorUsername:", paramString));
    synchronized ((Iterable)this.CEX)
    {
      Iterator localIterator = ???.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        boolean bool = Util.isEqual(((e)localObject).username, paramString);
        if (!bool) {}
        for (int i = 1; i != 0; i = 0)
        {
          paramString = localObject;
          paramString = (e)paramString;
          AppMethodBeat.o(359352);
          return paramString;
        }
      }
      paramString = null;
    }
  }
  
  public final e awu(String paramString)
  {
    AppMethodBeat.i(359362);
    Log.i(this.TAG, s.X("getSelfBattleUser anchorUsername:", paramString));
    synchronized ((Iterable)this.CEX)
    {
      Iterator localIterator = ???.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        boolean bool = Util.isEqual(((e)localObject).username, paramString);
        if (bool)
        {
          paramString = localObject;
          paramString = (e)paramString;
          AppMethodBeat.o(359362);
          return paramString;
        }
      }
      paramString = null;
    }
  }
  
  public final String ekA()
  {
    return this.CES;
  }
  
  public final boolean ekB()
  {
    return this.CEW == 4;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(359402);
    if (this == paramObject)
    {
      AppMethodBeat.o(359402);
      return true;
    }
    if (!(paramObject instanceof i))
    {
      AppMethodBeat.o(359402);
      return false;
    }
    paramObject = (i)paramObject;
    if (!s.p(this.CES, paramObject.CES))
    {
      AppMethodBeat.o(359402);
      return false;
    }
    if (this.CET != paramObject.CET)
    {
      AppMethodBeat.o(359402);
      return false;
    }
    if (this.CEU != paramObject.CEU)
    {
      AppMethodBeat.o(359402);
      return false;
    }
    if (this.CEV != paramObject.CEV)
    {
      AppMethodBeat.o(359402);
      return false;
    }
    if (this.CEW != paramObject.CEW)
    {
      AppMethodBeat.o(359402);
      return false;
    }
    if (!s.p(this.CEX, paramObject.CEX))
    {
      AppMethodBeat.o(359402);
      return false;
    }
    AppMethodBeat.o(359402);
    return true;
  }
  
  public final void gr(List<? extends edv> paramList)
  {
    AppMethodBeat.i(359375);
    s.u(paramList, "remotePlayerInfo");
    ArrayList localArrayList = new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      edv localedv = (edv)paramList.next();
      Log.i(this.TAG, "updatePlayerInfo remotePlayerInfo:[" + localedv.YIZ + ", " + localedv.abiU + ']');
      localArrayList.add(new e(localedv.YIZ, localedv.abiU));
    }
    this.CEX.clear();
    this.CEX.addAll((Collection)localArrayList);
    AppMethodBeat.o(359375);
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(359397);
    if (this.CES == null) {}
    for (int i = 0;; i = this.CES.hashCode())
    {
      int j = q.a..ExternalSyntheticBackport0.m(this.CET);
      int k = this.CEU;
      int m = this.CEV;
      int n = this.CEW;
      int i1 = this.CEX.hashCode();
      AppMethodBeat.o(359397);
      return ((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(359390);
    String str = "FinderLiveBattleData(battleId=" + this.CES + ", battleSeq=" + this.CET + ", leftTime=" + this.CEU + ", battleResult=" + this.CEV + ", battleStatus=" + this.CEW + ", playerInfo=" + this.CEX + ')';
    AppMethodBeat.o(359390);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.i
 * JD-Core Version:    0.7.0.1
 */