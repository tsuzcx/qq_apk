package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.cw.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.qp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements i
{
  public LinkedList<a> swm;
  private boolean swn;
  public List<qp> swo;
  public List<qp> swp;
  
  public g()
  {
    AppMethodBeat.i(5570);
    this.swm = new LinkedList();
    this.swn = false;
    this.swo = new LinkedList();
    this.swp = new LinkedList();
    h.aGY().a(387, this);
    h.aGY().a(new j(), 0);
    AppMethodBeat.o(5570);
  }
  
  public final void ao(final Runnable paramRunnable)
  {
    AppMethodBeat.i(263755);
    final LinkedList localLinkedList1 = new LinkedList();
    final LinkedList localLinkedList2 = new LinkedList();
    com.tencent.mm.cw.g.ijP().h(new a() {}).b(new a() {});
    AppMethodBeat.o(263755);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    int i = 0;
    AppMethodBeat.i(5573);
    Log.w("MicroMsg.BrandService.BrandServiceMgr", "on scene end code(%d, %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(5573);
      return;
    }
    if (paramq.getType() == 387)
    {
      paramString = ((j)paramq).swD;
      if (paramString == null)
      {
        Log.e("MicroMsg.BrandService.BrandServiceMgr", "nameList is null.");
        AppMethodBeat.o(5573);
        return;
      }
      if ((this.swo == null) || (this.swp == null))
      {
        Log.e("MicroMsg.BrandService.BrandServiceMgr", "enterpriseItemList or subscribeAndServiceItemList is null.");
        AppMethodBeat.o(5573);
        return;
      }
      if (paramString.size() != this.swo.size() + this.swp.size()) {
        paramInt1 = 1;
      }
    }
    label305:
    for (;;)
    {
      if (paramInt1 != 0)
      {
        paramString = this.swm.iterator();
        for (;;)
        {
          if (paramString.hasNext())
          {
            ((a)paramString.next()).onChange();
            continue;
            paramq = this.swo.iterator();
            qp localqp;
            do
            {
              paramInt1 = i;
              if (!paramq.hasNext()) {
                break;
              }
              localqp = (qp)paramq.next();
            } while ((localqp != null) && (paramString.contains(localqp.userName)));
            paramInt1 = 1;
            if (paramInt1 != 0) {
              break label305;
            }
            paramq = this.swp.iterator();
            do
            {
              if (!paramq.hasNext()) {
                break;
              }
              localqp = (qp)paramq.next();
            } while ((localqp != null) && (paramString.contains(localqp.userName)));
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
    h.aGY().b(387, this);
    if (this.swn)
    {
      ArrayList localArrayList = new ArrayList(this.swo.size() + this.swp.size());
      Iterator localIterator = this.swo.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((qp)localIterator.next());
      }
      localIterator = this.swp.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((qp)localIterator.next());
      }
      h.aGY().a(new o(localArrayList), 0);
    }
    AppMethodBeat.o(5572);
  }
  
  public static abstract interface a
  {
    public abstract void onChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.g
 * JD-Core Version:    0.7.0.1
 */