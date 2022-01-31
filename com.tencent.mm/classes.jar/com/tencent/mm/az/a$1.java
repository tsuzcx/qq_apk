package com.tencent.mm.az;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bjo;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.protocal.protobuf.bjq;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.protocal.protobuf.ue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class a$1
  implements f
{
  a$1(a parama, j.b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    paramInt1 = -1;
    AppMethodBeat.i(983);
    if (paramm.getType() != 681)
    {
      AppMethodBeat.o(983);
      return;
    }
    if (((b)paramm).fLG == null)
    {
      AppMethodBeat.o(983);
      return;
    }
    ((b)paramm).fLG.getReqObjImp();
    paramString = ((b.c)((b)paramm).fLG.getRespObj()).fLL;
    paramInt2 = ((ud)((b.b)((b)paramm).fLG.getReqObj()).fLK.xvF.jJv.getLast()).wMC;
    if ((paramString == null) || (paramString.xxX == null) || (paramString.xxX.xaU == null))
    {
      paramString = (List)this.fLF.fLD.get(paramInt2);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext()) {
          ((g.a)paramString.next()).a(-1, this.fLE);
        }
      }
      AppMethodBeat.o(983);
      return;
    }
    if (paramString.xxX.xaU.size() > 0) {
      paramInt1 = ((Integer)paramString.xxX.xaU.getLast()).intValue();
    }
    if (paramString.xxX.xxY.size() > 0) {
      paramString.xxX.xxY.getLast();
    }
    if (paramString.xxX.xxY.size() > 0) {
      paramString.xxX.xxY.getLast();
    }
    paramString = (List)this.fLF.fLD.get(paramInt2);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        ((g.a)paramString.next()).a(paramInt1, this.fLE);
      }
    }
    AppMethodBeat.o(983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.az.a.1
 * JD-Core Version:    0.7.0.1
 */