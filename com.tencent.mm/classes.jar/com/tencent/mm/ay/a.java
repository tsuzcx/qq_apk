package com.tencent.mm.ay;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.adx;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.protocal.protobuf.dze;
import com.tencent.mm.protocal.protobuf.dzf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.plugin.messenger.foundation.a.a.h
{
  SparseArray<LinkedList<h.b>> oPB;
  SparseArray<LinkedList<h.a>> oPC;
  
  public a()
  {
    AppMethodBeat.i(116837);
    this.oPB = new SparseArray();
    this.oPC = new SparseArray();
    AppMethodBeat.o(116837);
  }
  
  public final void a(int paramInt, h.b paramb)
  {
    AppMethodBeat.i(116839);
    if (this.oPB.indexOfKey(paramInt) < 0) {
      this.oPB.put(paramInt, new LinkedList());
    }
    ((LinkedList)this.oPB.get(paramInt)).add(paramb);
    AppMethodBeat.o(116839);
  }
  
  public final void a(h.a parama)
  {
    AppMethodBeat.i(231260);
    if (this.oPC.indexOfKey(226) < 0) {
      this.oPC.put(226, new LinkedList());
    }
    ((LinkedList)this.oPC.get(226)).add(parama);
    AppMethodBeat.o(231260);
  }
  
  public final void a(final ArrayList<k.b> paramArrayList, final h.a parama)
  {
    AppMethodBeat.i(231264);
    if (paramArrayList.isEmpty())
    {
      AppMethodBeat.o(231264);
      return;
    }
    b localb = new b(paramArrayList);
    com.tencent.mm.kernel.h.baF();
    localb.doScene(com.tencent.mm.kernel.h.baD().mCm.oun, new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(231244);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (((b)paramAnonymousp).oPG != null))
        {
          ((b)paramAnonymousp).oPG.getReqObjImp();
          paramAnonymousString = ((b.c)((b)paramAnonymousp).oPG.getRespObj()).oPL;
          if ((paramAnonymousString == null) || (paramAnonymousString.abdX == null) || (paramAnonymousString.abdX.aamU == null)) {
            paramAnonymousInt1 = 0;
          }
        }
        while (paramAnonymousInt1 == 0)
        {
          paramAnonymousString = new LinkedList();
          paramAnonymousp = new LinkedList();
          paramAnonymousInt1 = 0;
          for (;;)
          {
            if (paramAnonymousInt1 < paramArrayList.size())
            {
              paramAnonymousString.add(new dzc());
              paramAnonymousp.add(Integer.valueOf(-1));
              paramAnonymousInt1 += 1;
              continue;
              parama.onOpLogResult(paramAnonymousString.abdX.aamU, paramAnonymousString.abdX.abdY, paramArrayList);
              paramAnonymousInt1 = 1;
              break;
              paramAnonymousInt1 = 0;
              break;
            }
          }
          parama.onOpLogResult(paramAnonymousp, paramAnonymousString, paramArrayList);
        }
        AppMethodBeat.o(231244);
      }
    });
    AppMethodBeat.o(231264);
  }
  
  public final void b(int paramInt, h.b paramb)
  {
    AppMethodBeat.i(116840);
    if (this.oPB.indexOfKey(paramInt) >= 0) {
      ((LinkedList)this.oPB.get(paramInt)).remove(paramb);
    }
    AppMethodBeat.o(116840);
  }
  
  public final void b(h.a parama)
  {
    AppMethodBeat.i(231262);
    if (this.oPC.indexOfKey(226) >= 0) {
      ((LinkedList)this.oPC.get(226)).remove(parama);
    }
    AppMethodBeat.o(231262);
  }
  
  public final void b(k.b paramb)
  {
    AppMethodBeat.i(116838);
    if ((com.tencent.mm.kernel.h.baD().mCm == null) || (com.tencent.mm.kernel.h.baD().mCm.oun == null))
    {
      AppMethodBeat.o(116838);
      return;
    }
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramb);
    y(localArrayList);
    AppMethodBeat.o(116838);
  }
  
  public final void y(final ArrayList<k.b> paramArrayList)
  {
    AppMethodBeat.i(231255);
    if (paramArrayList.isEmpty())
    {
      AppMethodBeat.o(231255);
      return;
    }
    b localb = new b(paramArrayList);
    com.tencent.mm.kernel.h.baF();
    localb.doScene(com.tencent.mm.kernel.h.baD().mCm.oun, new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        paramAnonymousInt1 = -1;
        AppMethodBeat.i(116836);
        if (paramAnonymousp.getType() != 681)
        {
          AppMethodBeat.o(116836);
          return;
        }
        if (((b)paramAnonymousp).oPG == null)
        {
          AppMethodBeat.o(116836);
          return;
        }
        ((b)paramAnonymousp).oPG.getReqObjImp();
        Object localObject = ((b.c)((b)paramAnonymousp).oPG.getRespObj()).oPL;
        paramAnonymousInt2 = ((adw)((b.b)((b)paramAnonymousp).oPG.getReqObj()).oPK.abat.vgO.getLast()).Zmc;
        if ((localObject == null) || (((dze)localObject).abdX == null) || (((dze)localObject).abdX.aamU == null))
        {
          paramAnonymousString = (List)a.this.oPB.get(paramAnonymousInt2);
          if (paramAnonymousString != null)
          {
            paramAnonymousString = paramAnonymousString.iterator();
            while (paramAnonymousString.hasNext()) {
              ((h.b)paramAnonymousString.next()).a(-1, new dzc(), (k.b)paramArrayList.get(0));
            }
          }
          paramAnonymousString = (List)a.this.oPC.get(paramAnonymousInt2);
          if (paramAnonymousString != null)
          {
            paramAnonymousString = paramAnonymousString.iterator();
            while (paramAnonymousString.hasNext())
            {
              paramAnonymousp = (h.a)paramAnonymousString.next();
              localObject = new LinkedList();
              LinkedList localLinkedList = new LinkedList();
              paramAnonymousInt1 = 0;
              while (paramAnonymousInt1 < paramArrayList.size())
              {
                ((LinkedList)localObject).add(new dzc());
                localLinkedList.add(Integer.valueOf(-1));
                paramAnonymousInt1 += 1;
              }
              paramAnonymousp.onOpLogResult(localLinkedList, (LinkedList)localObject, paramArrayList);
            }
          }
          AppMethodBeat.o(116836);
          return;
        }
        paramAnonymousp = (List)a.this.oPB.get(paramAnonymousInt2);
        if (paramAnonymousp != null)
        {
          if (((dze)localObject).abdX.aamU.size() > 0) {
            paramAnonymousInt1 = ((Integer)((dze)localObject).abdX.aamU.getLast()).intValue();
          }
          if (((dze)localObject).abdX.abdY.size() > 0) {}
          for (paramAnonymousString = (dzc)((dze)localObject).abdX.abdY.getLast();; paramAnonymousString = new dzc())
          {
            paramAnonymousp = paramAnonymousp.iterator();
            while (paramAnonymousp.hasNext()) {
              ((h.b)paramAnonymousp.next()).a(paramAnonymousInt1, paramAnonymousString, (k.b)paramArrayList.get(0));
            }
          }
        }
        paramAnonymousString = (List)a.this.oPC.get(paramAnonymousInt2);
        if (paramAnonymousString != null)
        {
          paramAnonymousString = paramAnonymousString.iterator();
          while (paramAnonymousString.hasNext()) {
            ((h.a)paramAnonymousString.next()).onOpLogResult(((dze)localObject).abdX.aamU, ((dze)localObject).abdX.abdY, paramArrayList);
          }
        }
        AppMethodBeat.o(116836);
      }
    });
    AppMethodBeat.o(231255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.a
 * JD-Core Version:    0.7.0.1
 */