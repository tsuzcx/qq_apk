package com.tencent.mm.bd;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.dgv;
import com.tencent.mm.protocal.protobuf.dgw;
import com.tencent.mm.protocal.protobuf.dgx;
import com.tencent.mm.protocal.protobuf.dgy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.plugin.messenger.foundation.a.a.h
{
  SparseArray<LinkedList<h.a>> lWA;
  SparseArray<LinkedList<h.b>> lWz;
  
  public a()
  {
    AppMethodBeat.i(116837);
    this.lWz = new SparseArray();
    this.lWA = new SparseArray();
    AppMethodBeat.o(116837);
  }
  
  public final void a(int paramInt, h.b paramb)
  {
    AppMethodBeat.i(116839);
    if (this.lWz.indexOfKey(paramInt) < 0) {
      this.lWz.put(paramInt, new LinkedList());
    }
    ((LinkedList)this.lWz.get(paramInt)).add(paramb);
    AppMethodBeat.o(116839);
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(187747);
    if (this.lWA.indexOfKey(226) < 0) {
      this.lWA.put(226, new LinkedList());
    }
    ((LinkedList)this.lWA.get(226)).add(parama);
    AppMethodBeat.o(187747);
  }
  
  public final void a(final ArrayList<k.b> paramArrayList, final h.a parama)
  {
    AppMethodBeat.i(187750);
    if (paramArrayList.isEmpty())
    {
      AppMethodBeat.o(187750);
      return;
    }
    b localb = new b(paramArrayList);
    com.tencent.mm.kernel.h.aHH();
    localb.doScene(com.tencent.mm.kernel.h.aHF().kcd.lCD, new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(187777);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (((b)paramAnonymousq).lWE != null))
        {
          ((b)paramAnonymousq).lWE.getReqObjImp();
          paramAnonymousString = ((b.c)((b)paramAnonymousq).lWE.getRespObj()).lWJ;
          if ((paramAnonymousString == null) || (paramAnonymousString.TNE == null) || (paramAnonymousString.TNE.SZW == null)) {
            paramAnonymousInt1 = 0;
          }
        }
        while (paramAnonymousInt1 == 0)
        {
          paramAnonymousString = new LinkedList();
          paramAnonymousq = new LinkedList();
          paramAnonymousInt1 = 0;
          for (;;)
          {
            if (paramAnonymousInt1 < paramArrayList.size())
            {
              paramAnonymousString.add(new dgv());
              paramAnonymousq.add(Integer.valueOf(-1));
              paramAnonymousInt1 += 1;
              continue;
              parama.a(paramAnonymousString.TNE.SZW, paramAnonymousString.TNE.TNF, paramArrayList);
              paramAnonymousInt1 = 1;
              break;
              paramAnonymousInt1 = 0;
              break;
            }
          }
          parama.a(paramAnonymousq, paramAnonymousString, paramArrayList);
        }
        AppMethodBeat.o(187777);
      }
    });
    AppMethodBeat.o(187750);
  }
  
  public final void b(int paramInt, h.b paramb)
  {
    AppMethodBeat.i(116840);
    if (this.lWz.indexOfKey(paramInt) >= 0) {
      ((LinkedList)this.lWz.get(paramInt)).remove(paramb);
    }
    AppMethodBeat.o(116840);
  }
  
  public final void b(h.a parama)
  {
    AppMethodBeat.i(187749);
    if (this.lWA.indexOfKey(226) >= 0) {
      ((LinkedList)this.lWA.get(226)).remove(parama);
    }
    AppMethodBeat.o(187749);
  }
  
  public final void b(k.b paramb)
  {
    AppMethodBeat.i(116838);
    if ((com.tencent.mm.kernel.h.aHF().kcd == null) || (com.tencent.mm.kernel.h.aHF().kcd.lCD == null))
    {
      AppMethodBeat.o(116838);
      return;
    }
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramb);
    v(localArrayList);
    AppMethodBeat.o(116838);
  }
  
  public final void v(final ArrayList<k.b> paramArrayList)
  {
    AppMethodBeat.i(187744);
    if (paramArrayList.isEmpty())
    {
      AppMethodBeat.o(187744);
      return;
    }
    b localb = new b(paramArrayList);
    com.tencent.mm.kernel.h.aHH();
    localb.doScene(com.tencent.mm.kernel.h.aHF().kcd.lCD, new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        paramAnonymousInt1 = -1;
        AppMethodBeat.i(116836);
        if (paramAnonymousq.getType() != 681)
        {
          AppMethodBeat.o(116836);
          return;
        }
        if (((b)paramAnonymousq).lWE == null)
        {
          AppMethodBeat.o(116836);
          return;
        }
        ((b)paramAnonymousq).lWE.getReqObjImp();
        Object localObject = ((b.c)((b)paramAnonymousq).lWE.getRespObj()).lWJ;
        paramAnonymousInt2 = ((abu)((b.b)((b)paramAnonymousq).lWE.getReqObj()).lWI.TKA.rVy.getLast()).SnG;
        if ((localObject == null) || (((dgx)localObject).TNE == null) || (((dgx)localObject).TNE.SZW == null))
        {
          paramAnonymousString = (List)a.this.lWz.get(paramAnonymousInt2);
          if (paramAnonymousString != null)
          {
            paramAnonymousString = paramAnonymousString.iterator();
            while (paramAnonymousString.hasNext()) {
              ((h.b)paramAnonymousString.next()).a(-1, new dgv(), (k.b)paramArrayList.get(0));
            }
          }
          paramAnonymousString = (List)a.this.lWA.get(paramAnonymousInt2);
          if (paramAnonymousString != null)
          {
            paramAnonymousString = paramAnonymousString.iterator();
            while (paramAnonymousString.hasNext())
            {
              paramAnonymousq = (h.a)paramAnonymousString.next();
              localObject = new LinkedList();
              LinkedList localLinkedList = new LinkedList();
              paramAnonymousInt1 = 0;
              while (paramAnonymousInt1 < paramArrayList.size())
              {
                ((LinkedList)localObject).add(new dgv());
                localLinkedList.add(Integer.valueOf(-1));
                paramAnonymousInt1 += 1;
              }
              paramAnonymousq.a(localLinkedList, (LinkedList)localObject, paramArrayList);
            }
          }
          AppMethodBeat.o(116836);
          return;
        }
        paramAnonymousq = (List)a.this.lWz.get(paramAnonymousInt2);
        if (paramAnonymousq != null)
        {
          if (((dgx)localObject).TNE.SZW.size() > 0) {
            paramAnonymousInt1 = ((Integer)((dgx)localObject).TNE.SZW.getLast()).intValue();
          }
          if (((dgx)localObject).TNE.TNF.size() > 0) {}
          for (paramAnonymousString = (dgv)((dgx)localObject).TNE.TNF.getLast();; paramAnonymousString = new dgv())
          {
            paramAnonymousq = paramAnonymousq.iterator();
            while (paramAnonymousq.hasNext()) {
              ((h.b)paramAnonymousq.next()).a(paramAnonymousInt1, paramAnonymousString, (k.b)paramArrayList.get(0));
            }
          }
        }
        paramAnonymousString = (List)a.this.lWA.get(paramAnonymousInt2);
        if (paramAnonymousString != null)
        {
          paramAnonymousString = paramAnonymousString.iterator();
          while (paramAnonymousString.hasNext()) {
            ((h.a)paramAnonymousString.next()).a(((dgx)localObject).TNE.SZW, ((dgx)localObject).TNE.TNF, paramArrayList);
          }
        }
        AppMethodBeat.o(116836);
      }
    });
    AppMethodBeat.o(187744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bd.a
 * JD-Core Version:    0.7.0.1
 */