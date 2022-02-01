package com.tencent.mm.plugin.brandservice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.cp.f;
import com.tencent.mm.protocal.protobuf.sa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements com.tencent.mm.am.h
{
  public LinkedList<a> vBT;
  private boolean vBU;
  public List<sa> vBV;
  public List<sa> vBW;
  
  public g()
  {
    AppMethodBeat.i(5570);
    this.vBT = new LinkedList();
    this.vBU = false;
    this.vBV = new LinkedList();
    this.vBW = new LinkedList();
    com.tencent.mm.kernel.h.aZW().a(387, this);
    com.tencent.mm.kernel.h.aZW().a(new j(), 0);
    AppMethodBeat.o(5570);
  }
  
  public final void aw(final Runnable paramRunnable)
  {
    AppMethodBeat.i(303470);
    final LinkedList localLinkedList1 = new LinkedList();
    final LinkedList localLinkedList2 = new LinkedList();
    com.tencent.mm.cp.g.jPX().h(new a() {}).b(new a() {});
    AppMethodBeat.o(303470);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    int i = 0;
    AppMethodBeat.i(5573);
    Log.w("MicroMsg.BrandService.BrandServiceMgr", "on scene end code(%d, %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(5573);
      return;
    }
    if (paramp.getType() == 387)
    {
      paramString = ((j)paramp).vCk;
      if (paramString == null)
      {
        Log.e("MicroMsg.BrandService.BrandServiceMgr", "nameList is null.");
        AppMethodBeat.o(5573);
        return;
      }
      if ((this.vBV == null) || (this.vBW == null))
      {
        Log.e("MicroMsg.BrandService.BrandServiceMgr", "enterpriseItemList or subscribeAndServiceItemList is null.");
        AppMethodBeat.o(5573);
        return;
      }
      if (paramString.size() != this.vBV.size() + this.vBW.size()) {
        paramInt1 = 1;
      }
    }
    label305:
    for (;;)
    {
      if (paramInt1 != 0)
      {
        paramString = this.vBT.iterator();
        for (;;)
        {
          if (paramString.hasNext())
          {
            ((a)paramString.next()).onChange();
            continue;
            paramp = this.vBV.iterator();
            sa localsa;
            do
            {
              paramInt1 = i;
              if (!paramp.hasNext()) {
                break;
              }
              localsa = (sa)paramp.next();
            } while ((localsa != null) && (paramString.contains(localsa.userName)));
            paramInt1 = 1;
            if (paramInt1 != 0) {
              break label305;
            }
            paramp = this.vBW.iterator();
            do
            {
              if (!paramp.hasNext()) {
                break;
              }
              localsa = (sa)paramp.next();
            } while ((localsa != null) && (paramString.contains(localsa.userName)));
            paramInt1 = 1;
            break;
          }
        }
      }
      AppMethodBeat.o(5573);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(5572);
    com.tencent.mm.kernel.h.aZW().b(387, this);
    if (this.vBU)
    {
      ArrayList localArrayList = new ArrayList(this.vBV.size() + this.vBW.size());
      Iterator localIterator = this.vBV.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((sa)localIterator.next());
      }
      localIterator = this.vBW.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((sa)localIterator.next());
      }
      com.tencent.mm.kernel.h.aZW().a(new o(localArrayList), 0);
    }
    AppMethodBeat.o(5572);
  }
  
  public static abstract interface a
  {
    public abstract void onChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.model.g
 * JD-Core Version:    0.7.0.1
 */