package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.protocal.protobuf.cht;
import com.tencent.mm.protocal.protobuf.chu;
import com.tencent.mm.protocal.protobuf.dgk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.az;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends p
  implements m
{
  private h callback;
  private final com.tencent.mm.am.c rr;
  
  public d()
  {
    AppMethodBeat.i(26149);
    c.a locala = new c.a();
    locala.otE = new cht();
    locala.otF = new chu();
    locala.uri = "/cgi-bin/micromsg-bin/getcontactlabellist";
    locala.funcId = 639;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    AppMethodBeat.o(26149);
  }
  
  private static void fTd()
  {
    AppMethodBeat.i(268628);
    Object localObject1 = com.tencent.mm.plugin.label.d.fTa().iZP();
    Object localObject2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = ((ArrayList)localObject1).iterator();
    while (localIterator.hasNext())
    {
      aw localaw = (aw)localIterator.next();
      if (!((ArrayList)localObject2).contains(Long.valueOf(localaw.field_createTime))) {
        ((ArrayList)localObject2).add(Long.valueOf(localaw.field_createTime));
      } else {
        localArrayList2.add(Long.valueOf(localaw.field_createTime));
      }
    }
    localArrayList2.add(Long.valueOf(0L));
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (aw)((Iterator)localObject1).next();
      if (localArrayList2.contains(Long.valueOf(((aw)localObject2).field_createTime))) {
        localArrayList1.add(localObject2);
      }
    }
    int i = 0;
    while (i < localArrayList1.size())
    {
      ((aw)localArrayList1.get(0)).field_createTime = (System.currentTimeMillis() + i * 1000);
      i += 1;
    }
    com.tencent.mm.plugin.label.d.fTa().mL(localArrayList1);
    AppMethodBeat.o(268628);
  }
  
  private static void iG(List<Integer> paramList)
  {
    AppMethodBeat.i(268632);
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Object localObject1 = com.tencent.mm.plugin.label.d.fTa().iZP();
    Object localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      aw localaw = (aw)((Iterator)localObject2).next();
      localHashMap1.put(Integer.valueOf(localaw.field_labelID), Long.valueOf(localaw.field_createTime));
    }
    int i = 0;
    while ((i < paramList.size()) && (i < ((ArrayList)localObject1).size()))
    {
      if (((Integer)paramList.get(i)).intValue() != ((aw)((ArrayList)localObject1).get(i)).field_labelID)
      {
        Log.i("MicroMsg.Label.NetSceneGetContactLabelList", "isSwapPosAdapter field_labelID no equal.");
        localHashMap2.put((Integer)paramList.get(i), Integer.valueOf(((aw)((ArrayList)localObject1).get(i)).field_labelID));
      }
      i += 1;
    }
    localObject1 = paramList.iterator();
    label368:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      if (localHashMap2.containsKey(localObject2))
      {
        i = ((Integer)localHashMap2.get(localObject2)).intValue();
        long l = ((Long)localHashMap1.get(Integer.valueOf(i))).longValue();
        paramList = com.tencent.mm.plugin.label.d.fTa().bxn(String.valueOf(localObject2));
        if (paramList == null) {
          paramList = new aw();
        }
        for (;;)
        {
          if (paramList.field_createTime == l) {
            break label368;
          }
          paramList.field_createTime = l;
          localArrayList.add(paramList);
          Log.i("MicroMsg.Label.NetSceneGetContactLabelList", "newSortLabelId = " + localObject2 + "oldLabelId = " + i + "label.field_createTime = " + paramList.field_createTime + ", newCreateTime = " + l);
          break;
          if (paramList.field_isTemporary) {
            break;
          }
        }
      }
    }
    com.tencent.mm.plugin.label.d.fTa().mL(localArrayList);
    localHashMap2.clear();
    localHashMap1.clear();
    AppMethodBeat.o(268632);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(26151);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(26151);
    return i;
  }
  
  public final int getType()
  {
    return 639;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    int i = 0;
    AppMethodBeat.i(26150);
    Log.d("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      bh.bCz();
      com.tencent.mm.model.c.ban().B(209408, Long.valueOf(System.currentTimeMillis()));
      params = (chu)c.c.b(this.rr.otC);
      if ((params != null) && (params.YFs != null))
      {
        params = params.YFs;
        paramArrayOfByte = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        int j = params.size();
        paramInt1 = i;
        while (paramInt1 < j)
        {
          dgk localdgk = (dgk)params.get(paramInt1);
          aw localaw = new aw();
          paramArrayOfByte.add(Integer.valueOf(localdgk.aaLB));
          localaw.field_labelID = localdgk.aaLB;
          localaw.field_labelName = localdgk.aaLA;
          localaw.field_labelPYFull = f.RZ(localdgk.aaLA);
          localaw.field_labelPYShort = f.Sa(localdgk.aaLA);
          localArrayList.add(localaw);
          paramInt1 += 1;
        }
        com.tencent.mm.plugin.label.d.fTa().mK(localArrayList);
        fTd();
        iG(paramArrayOfByte);
        com.tencent.mm.plugin.label.d.fTa().mM(com.tencent.mm.plugin.label.d.fTa().mN(localArrayList));
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26150);
      return;
      Log.w("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] getcontactlabellist fail.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.d
 * JD-Core Version:    0.7.0.1
 */