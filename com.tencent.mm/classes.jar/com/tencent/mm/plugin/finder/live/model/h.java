package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.viewmodel.data.e;
import com.tencent.mm.protocal.protobuf.dlk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBattleData;", "", "battleId", "", "battleSeq", "", "leftTime", "", "battleResult", "battleStatus", "playerInfo", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveBattlePlayerInfo;", "(Ljava/lang/String;JIIILjava/util/List;)V", "TAG", "getBattleId", "()Ljava/lang/String;", "setBattleId", "(Ljava/lang/String;)V", "getBattleResult", "()I", "setBattleResult", "(I)V", "getBattleSeq", "()J", "setBattleSeq", "(J)V", "getBattleStatus", "setBattleStatus", "getLeftTime", "setLeftTime", "getPlayerInfo", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "getOtherBattleUser", "anchorUsername", "getSelfBattleUser", "hashCode", "toString", "transEnd", "", "endResult", "transStart", "updatePlayerInfo", "remotePlayerInfo", "", "Lcom/tencent/mm/protocal/protobuf/PlayerInfo;", "plugin-finder-base_release"})
public final class h
{
  private final String TAG;
  public String yeu;
  public long yev;
  public int yew;
  public int yex;
  public int yey;
  public final List<e> yez;
  
  public h()
  {
    this(null, 0L, 0, 0, 0, null, 63);
  }
  
  private h(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3, List<e> paramList)
  {
    AppMethodBeat.i(261354);
    this.yeu = paramString;
    this.yev = paramLong;
    this.yew = paramInt1;
    this.yex = paramInt2;
    this.yey = paramInt3;
    this.yez = paramList;
    this.TAG = "Finder.FinderLiveBattleData";
    AppMethodBeat.o(261354);
  }
  
  public final void No(int paramInt)
  {
    this.yey = 3;
    this.yex = paramInt;
  }
  
  public final e aBY(String paramString)
  {
    AppMethodBeat.i(261348);
    Log.i(this.TAG, "getOtherBattleUser anchorUsername:".concat(String.valueOf(paramString)));
    synchronized ((Iterable)this.yez)
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
          AppMethodBeat.o(261348);
          return paramString;
        }
      }
      paramString = null;
    }
  }
  
  public final e aBZ(String paramString)
  {
    AppMethodBeat.i(261351);
    Log.i(this.TAG, "getSelfBattleUser anchorUsername:".concat(String.valueOf(paramString)));
    synchronized ((Iterable)this.yez)
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
          AppMethodBeat.o(261351);
          return paramString;
        }
      }
      paramString = null;
    }
  }
  
  public final void en(List<? extends dlk> paramList)
  {
    AppMethodBeat.i(261353);
    p.k(paramList, "remotePlayerInfo");
    ArrayList localArrayList = new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      dlk localdlk = (dlk)paramList.next();
      Log.i(this.TAG, "updatePlayerInfo remotePlayerInfo:[" + localdlk.RLN + ", " + localdlk.TSv + ']');
      localArrayList.add(new e(localdlk.RLN, localdlk.TSv));
    }
    this.yez.clear();
    this.yez.addAll((Collection)localArrayList);
    AppMethodBeat.o(261353);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(261361);
    if (this != paramObject)
    {
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((!p.h(this.yeu, paramObject.yeu)) || (this.yev != paramObject.yev) || (this.yew != paramObject.yew) || (this.yex != paramObject.yex) || (this.yey != paramObject.yey) || (!p.h(this.yez, paramObject.yez))) {}
      }
    }
    else
    {
      AppMethodBeat.o(261361);
      return true;
    }
    AppMethodBeat.o(261361);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(261359);
    Object localObject = this.yeu;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      long l = this.yev;
      int k = (int)(l ^ l >>> 32);
      int m = this.yew;
      int n = this.yex;
      int i1 = this.yey;
      localObject = this.yez;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(261359);
      return ((((i * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(261357);
    String str = "FinderLiveBattleData(battleId=" + this.yeu + ", battleSeq=" + this.yev + ", leftTime=" + this.yew + ", battleResult=" + this.yex + ", battleStatus=" + this.yey + ", playerInfo=" + this.yez + ")";
    AppMethodBeat.o(261357);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.h
 * JD-Core Version:    0.7.0.1
 */