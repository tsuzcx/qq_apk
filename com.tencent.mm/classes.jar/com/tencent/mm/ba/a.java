package com.tencent.mm.ba;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.cbu;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.cbw;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.protocal.protobuf.xw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.plugin.messenger.foundation.a.a.g
{
  SparseArray<LinkedList<g.a>> hOS;
  
  public a()
  {
    AppMethodBeat.i(116837);
    this.hOS = new SparseArray();
    AppMethodBeat.o(116837);
  }
  
  public final void a(int paramInt, g.a parama)
  {
    AppMethodBeat.i(116839);
    if (this.hOS.indexOfKey(paramInt) < 0) {
      this.hOS.put(paramInt, new LinkedList());
    }
    ((LinkedList)this.hOS.get(paramInt)).add(parama);
    AppMethodBeat.o(116839);
  }
  
  public final void a(final j.b paramb)
  {
    AppMethodBeat.i(116838);
    if ((com.tencent.mm.kernel.g.agQ().ghe == null) || (com.tencent.mm.kernel.g.agQ().ghe.hwg == null))
    {
      AppMethodBeat.o(116838);
      return;
    }
    Object localObject = new ArrayList(1);
    ((ArrayList)localObject).add(paramb);
    localObject = new b((List)localObject);
    com.tencent.mm.kernel.g.agS();
    ((b)localObject).doScene(com.tencent.mm.kernel.g.agQ().ghe.hwg, new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        paramAnonymousInt1 = -1;
        AppMethodBeat.i(116836);
        if (paramAnonymousn.getType() != 681)
        {
          AppMethodBeat.o(116836);
          return;
        }
        if (((b)paramAnonymousn).hOV == null)
        {
          AppMethodBeat.o(116836);
          return;
        }
        ((b)paramAnonymousn).hOV.getReqObjImp();
        paramAnonymousString = ((b.c)((b)paramAnonymousn).hOV.getRespObj()).hPa;
        paramAnonymousInt2 = ((xv)((b.b)((b)paramAnonymousn).hOV.getReqObj()).hOZ.Fnk.ncM.getLast()).ErL;
        if ((paramAnonymousString == null) || (paramAnonymousString.FpR == null) || (paramAnonymousString.FpR.EKK == null))
        {
          paramAnonymousString = (List)a.this.hOS.get(paramAnonymousInt2);
          if (paramAnonymousString != null)
          {
            paramAnonymousString = paramAnonymousString.iterator();
            while (paramAnonymousString.hasNext()) {
              ((g.a)paramAnonymousString.next()).a(-1, paramb);
            }
          }
          AppMethodBeat.o(116836);
          return;
        }
        if (paramAnonymousString.FpR.EKK.size() > 0) {
          paramAnonymousInt1 = ((Integer)paramAnonymousString.FpR.EKK.getLast()).intValue();
        }
        if (paramAnonymousString.FpR.FpS.size() > 0) {
          paramAnonymousString.FpR.FpS.getLast();
        }
        if (paramAnonymousString.FpR.FpS.size() > 0) {
          paramAnonymousString.FpR.FpS.getLast();
        }
        paramAnonymousString = (List)a.this.hOS.get(paramAnonymousInt2);
        if (paramAnonymousString != null)
        {
          paramAnonymousString = paramAnonymousString.iterator();
          while (paramAnonymousString.hasNext()) {
            ((g.a)paramAnonymousString.next()).a(paramAnonymousInt1, paramb);
          }
        }
        AppMethodBeat.o(116836);
      }
    });
    AppMethodBeat.o(116838);
  }
  
  public final void b(int paramInt, g.a parama)
  {
    AppMethodBeat.i(116840);
    if (this.hOS.indexOfKey(paramInt) >= 0) {
      ((LinkedList)this.hOS.get(paramInt)).remove(parama);
    }
    AppMethodBeat.o(116840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ba.a
 * JD-Core Version:    0.7.0.1
 */