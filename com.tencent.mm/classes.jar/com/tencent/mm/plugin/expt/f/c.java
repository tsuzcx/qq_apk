package com.tencent.mm.plugin.expt.f;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.b.a.bc;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.h.b;
import com.tencent.mm.protocal.protobuf.aho;
import com.tencent.mm.protocal.protobuf.alk;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.protocal.protobuf.bup;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends q
  implements m
{
  private i callback;
  private int lMY = 0;
  
  public c(int paramInt)
  {
    this.lMY = paramInt;
  }
  
  private static void Lj(int paramInt)
  {
    AppMethodBeat.i(251910);
    int i = (int)Util.nowSecond();
    if (i > paramInt)
    {
      h.aHG().aHp().set(ar.a.VuS, Integer.valueOf(i));
      AppMethodBeat.o(251910);
      return;
    }
    h.aHG().aHp().set(ar.a.VuS, Integer.valueOf(paramInt));
    AppMethodBeat.o(251910);
  }
  
  private static LinkedList<alk> dgk()
  {
    AppMethodBeat.i(251909);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = b.dgG().dgK();
    if (((List)localObject).size() > 0)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      bc localbc = new bc();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.expt.h.a locala = (com.tencent.mm.plugin.expt.h.a)((Iterator)localObject).next();
        if (locala != null)
        {
          alk localalk = new alk();
          localalk.SvO = locala.wrb;
          localalk.SvP = locala.ka;
          localalk.SvQ = locala.wrc;
          localalk.SvT = locala.wrg;
          localbc.glH = localalk.SvO;
          localbc.glI = localalk.SvQ;
          localbc.giX = 1;
          localbc.fBl();
          localLinkedList.add(localalk);
          localStringBuffer.append("expt:").append(locala.wrb).append(",seq:").append(locala.wrc).append(";");
        }
      }
      Log.i("MicroMsg.NetSceneGetExptApp", "local list[%s]", new Object[] { localStringBuffer });
    }
    AppMethodBeat.o(251909);
    return localLinkedList;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(251901);
    this.callback = parami;
    long l = Util.currentTicks();
    try
    {
      parami = new d.a();
      parami.lBU = new buo();
      parami.lBV = new bup();
      parami.uri = "/cgi-bin/mmfddataappsvr/getexptappconfig";
      parami.funcId = 1110;
      parami.lBW = 0;
      parami.respCmdId = 0;
      parami = parami.bgN();
      buo localbuo = (buo)d.b.b(parami.lBR);
      localbuo.CPw = this.lMY;
      localbuo.TeG = ((Integer)h.aHG().aHp().get(ar.a.VuS, Integer.valueOf(0))).intValue();
      Object localObject = new aho();
      ((aho)localObject).oeB = Build.MANUFACTURER;
      ((aho)localObject).model = Build.MODEL;
      ((aho)localObject).Ssk = Build.VERSION.SDK_INT;
      ((aho)localObject).Ssl = Build.CPU_ABI;
      Log.i("MicroMsg.NetSceneGetExptApp", "create Device type manufacturer[%s] model[%s] os_api[%s] cpu[%s]", new Object[] { ((aho)localObject).oeB, ((aho)localObject).model, ((aho)localObject).Ssk, ((aho)localObject).Ssl });
      localbuo.TeH = ((aho)localObject);
      localbuo.TeK = ((String)h.aHG().aHp().get(ar.a.VuT, ""));
      int j;
      int k;
      int m;
      int n;
      if (this.lMY == 3)
      {
        i = 0;
        localbuo.TeJ = i;
        if (h.aHG().aHp().getInt(ar.a.VuU, 0) == 1) {
          localbuo.TeJ = 0;
        }
        localObject = dgk();
        j = ((Integer)h.aHG().aHp().get(ar.a.VuV, Integer.valueOf(1))).intValue();
        if ((j == 1) || (localbuo.TeJ == 0)) {
          localbuo.TeI = ((LinkedList)localObject);
        }
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(863L, 155L, 1L, false);
        k = localbuo.CPw;
        m = localbuo.TeG;
        n = localbuo.TeJ;
        localObject = localbuo.TeK;
        if (localbuo.TeI == null) {
          break label486;
        }
      }
      label486:
      for (int i = localbuo.TeI.size();; i = 0)
      {
        Log.i("MicroMsg.NetSceneGetExptApp", "get expt app scene[%d] lastGetSvrSec[%d] IsIncrement[%d] GlobalSequence[%s] nextReqNeedLocalList[%d] localExptList[%d] cost[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), localObject, Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
        i = dispatch(paramg, parami, this);
        AppMethodBeat.o(251901);
        return i;
        i = 1;
        break;
      }
      return -1;
    }
    catch (Exception paramg)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneGetExptApp", paramg, "", new Object[0]);
      AppMethodBeat.o(251901);
    }
  }
  
  public final int getType()
  {
    return 1110;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(251905);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (bup)d.c.b(((d)params).lBS);
      if (params == null)
      {
        paramInt1 = 0;
        if (paramInt1 == 0) {
          break label373;
        }
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(863L, 156L, 1L, false);
      }
    }
    for (;;)
    {
      a.dgf();
      a.nD(false);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(251905);
      return;
      if (params.BaseResponse.CqV != 0)
      {
        paramInt1 = 0;
        break;
      }
      paramArrayOfByte = new ArrayList();
      if ((params.TeO != null) && (params.TeO.size() > 0))
      {
        localObject = params.TeO.iterator();
        while (((Iterator)localObject).hasNext())
        {
          alk localalk = (alk)((Iterator)localObject).next();
          com.tencent.mm.plugin.expt.h.a locala = new com.tencent.mm.plugin.expt.h.a();
          locala.abx(localalk.SvR);
          paramArrayOfByte.add(locala);
        }
      }
      a.dgf();
      a.b(params.RIs, params.TeN, paramArrayOfByte);
      Lj(params.TeL);
      int i = params.TeM;
      h.aHG().aHp().set(ar.a.VuR, Integer.valueOf(i));
      int j = params.TeP;
      h.aHG().aHp().set(ar.a.VuV, Integer.valueOf(j));
      Object localObject = params.TeK;
      h.aHG().aHp().set(ar.a.VuT, localObject);
      int k = paramArrayOfByte.size();
      if (params.TeN != null) {}
      for (paramInt1 = params.TeN.size();; paramInt1 = 0)
      {
        Log.i("MicroMsg.NetSceneGetExptApp", "updateExpt interval[%d] nextReqNeedLocalList[%d] globalSeq[%s] updateList[%d] deleteList[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject, Integer.valueOf(k), Integer.valueOf(paramInt1) });
        paramInt1 = 1;
        break;
      }
      label373:
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(863L, 157L, 1L, false);
      continue;
      Log.w("MicroMsg.NetSceneGetExptApp", "get expt error");
      Lj((int)Util.nowSecond());
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(863L, 157L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.f.c
 * JD-Core Version:    0.7.0.1
 */