package com.tencent.mm.plugin.expt.f;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.b.a.aa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.ahv;
import com.tencent.mm.protocal.protobuf.bbo;
import com.tencent.mm.protocal.protobuf.bbp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends n
  implements k
{
  private f callback;
  private int ibF = 0;
  
  public c(int paramInt)
  {
    this.ibF = paramInt;
  }
  
  private static void DM(int paramInt)
  {
    AppMethodBeat.i(196207);
    int i = (int)bu.aRi();
    if (i > paramInt)
    {
      g.ajR().ajA().set(am.a.IYf, Integer.valueOf(i));
      AppMethodBeat.o(196207);
      return;
    }
    g.ajR().ajA().set(am.a.IYf, Integer.valueOf(paramInt));
    AppMethodBeat.o(196207);
  }
  
  private static LinkedList<ahv> csI()
  {
    AppMethodBeat.i(196206);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = com.tencent.mm.plugin.expt.h.b.ctb().cte();
    if (((List)localObject).size() > 0)
    {
      aa localaa = new aa();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.expt.h.a locala = (com.tencent.mm.plugin.expt.h.a)((Iterator)localObject).next();
        if (locala != null)
        {
          ahv localahv = new ahv();
          localahv.GxH = locala.rjD;
          localahv.GxI = locala.adG;
          localahv.GxJ = locala.rjE;
          localahv.GxM = locala.rjI;
          localaa.dVX = localahv.GxH;
          localaa.dVY = localahv.GxJ;
          localaa.dTY = 1;
          localaa.dNp();
          localLinkedList.add(localahv);
        }
      }
    }
    AppMethodBeat.o(196206);
    return localLinkedList;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(196204);
    this.callback = paramf;
    try
    {
      paramf = new b.a();
      paramf.hQF = new bbo();
      paramf.hQG = new bbp();
      paramf.uri = "/cgi-bin/mmfddataappsvr/getexptappconfig";
      paramf.funcId = 1110;
      paramf.hQH = 0;
      paramf.respCmdId = 0;
      paramf = paramf.aDS();
      bbo localbbo = (bbo)paramf.hQD.hQJ;
      localbbo.Scene = this.ibF;
      localbbo.GRw = ((Integer)g.ajR().ajA().get(am.a.IYf, Integer.valueOf(0))).intValue();
      Object localObject = new aez();
      ((aez)localObject).kgh = Build.MANUFACTURER;
      ((aez)localObject).model = Build.MODEL;
      ((aez)localObject).Gvi = Build.VERSION.SDK_INT;
      ((aez)localObject).Gvj = Build.CPU_ABI;
      localbbo.GRx = ((aez)localObject);
      localbbo.GRA = ((String)g.ajR().ajA().get(am.a.IYg, ""));
      int j;
      int k;
      int m;
      int n;
      if (this.ibF == 3)
      {
        i = 0;
        localbbo.GRz = i;
        if (g.ajR().ajA().getInt(am.a.IYh, 0) == 1) {
          localbbo.GRz = 0;
        }
        j = ((Integer)g.ajR().ajA().get(am.a.IYi, Integer.valueOf(1))).intValue();
        if ((j == 1) || (localbbo.GRz == 0)) {
          localbbo.GRy = csI();
        }
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(863L, 155L, 1L, false);
        k = localbbo.Scene;
        m = localbbo.GRw;
        n = localbbo.GRz;
        localObject = localbbo.GRA;
        if (localbbo.GRy == null) {
          break label422;
        }
      }
      label422:
      for (int i = localbbo.GRy.size();; i = 0)
      {
        ae.i("MicroMsg.NetSceneGetExptApp", "get expt app scene[%d] lastGetSvrSec[%d] IsIncrement[%d] GlobalSequence[%s] nextReqNeedLocalList[%d] localExptList[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), localObject, Integer.valueOf(j), Integer.valueOf(i) });
        i = dispatch(parame, paramf, this);
        AppMethodBeat.o(196204);
        return i;
        i = 1;
        break;
      }
      return -1;
    }
    catch (Exception parame)
    {
      ae.printErrStackTrace("MicroMsg.NetSceneGetExptApp", parame, "", new Object[0]);
      AppMethodBeat.o(196204);
    }
  }
  
  public final int getType()
  {
    return 1110;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(196205);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (bbp)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
      if (paramArrayOfByte == null)
      {
        paramInt1 = 0;
        if (paramInt1 == 0) {
          break label338;
        }
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(863L, 156L, 1L, false);
      }
    }
    for (;;)
    {
      a.csB();
      a.li(false);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(196205);
      return;
      if (paramArrayOfByte.BaseResponse.Ret != 0)
      {
        paramInt1 = 0;
        break;
      }
      paramq = new ArrayList();
      if ((paramArrayOfByte.GRE != null) && (paramArrayOfByte.GRE.size() > 0))
      {
        Iterator localIterator = paramArrayOfByte.GRE.iterator();
        while (localIterator.hasNext())
        {
          ahv localahv = (ahv)localIterator.next();
          com.tencent.mm.plugin.expt.h.a locala = new com.tencent.mm.plugin.expt.h.a();
          locala.agx(localahv.GxK);
          paramq.add(locala);
        }
      }
      a.csB();
      a.c(paramArrayOfByte.FNv, paramArrayOfByte.GRD, paramq);
      DM(paramArrayOfByte.GRB);
      paramInt1 = paramArrayOfByte.GRC;
      g.ajR().ajA().set(am.a.IYe, Integer.valueOf(paramInt1));
      int i = paramArrayOfByte.GRF;
      g.ajR().ajA().set(am.a.IYi, Integer.valueOf(i));
      paramArrayOfByte = paramArrayOfByte.GRA;
      g.ajR().ajA().set(am.a.IYg, paramArrayOfByte);
      ae.i("MicroMsg.NetSceneGetExptApp", "updateExpt interval[%d] nextReqNeedLocalList[%d] globalSeq[%s] updateList[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), paramArrayOfByte, Integer.valueOf(paramq.size()) });
      paramInt1 = 1;
      break;
      label338:
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(863L, 157L, 1L, false);
      continue;
      ae.w("MicroMsg.NetSceneGetExptApp", "get expt error");
      DM((int)bu.aRi());
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(863L, 157L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.f.c
 * JD-Core Version:    0.7.0.1
 */