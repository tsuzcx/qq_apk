package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.d.bm;
import com.tencent.mm.plugin.game.d.ch;
import com.tencent.mm.plugin.game.d.cq;
import com.tencent.mm.plugin.game.d.cr;
import com.tencent.mm.plugin.game.d.dd;
import com.tencent.mm.plugin.game.d.f;
import com.tencent.mm.plugin.game.d.n;
import com.tencent.mm.plugin.game.ui.GameLibraryCategoriesView.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class ae
  extends x
{
  private int rXN;
  public bm rYh;
  public LinkedList<c> rYi;
  public LinkedList<c> rYj;
  
  public ae(a parama, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(41543);
    this.rXN = 0;
    if (parama == null)
    {
      this.rYh = new bm();
      AppMethodBeat.o(41543);
      return;
    }
    this.rYh = ((bm)parama);
    this.rXN = paramInt;
    this.rYi = cDI();
    this.rYj = cDJ();
    if (paramBoolean) {
      ((e)g.ab(e.class)).cBe().b("pb_library", parama);
    }
    com.tencent.mm.plugin.game.f.d.av(this.rYi);
    com.tencent.mm.plugin.game.f.d.av(this.rYj);
    AppMethodBeat.o(41543);
  }
  
  public ae(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41544);
    this.rXN = 0;
    this.rYh = new bm();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41544);
      return;
    }
    try
    {
      this.rYh.parseFrom(paramArrayOfByte);
      this.rYi = cDI();
      this.rYj = cDJ();
      com.tencent.mm.plugin.game.f.d.av(this.rYi);
      com.tencent.mm.plugin.game.f.d.av(this.rYj);
      AppMethodBeat.o(41544);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        ad.e("MicroMsg.GamePBDataLibrary", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private LinkedList<c> cDI()
  {
    AppMethodBeat.i(41545);
    LinkedList localLinkedList = new LinkedList();
    if ((this.rYh.scB == null) || (this.rYh.scB.sdd == null) || (this.rYh.scB.sdd.sdr == null))
    {
      AppMethodBeat.o(41545);
      return localLinkedList;
    }
    Iterator localIterator = this.rYh.scB.sdd.sdr.iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      cr localcr = (cr)localIterator.next();
      c localc = a(localcr.rZp);
      if (localc != null)
      {
        localc.rVc = localcr.rZp.rZD;
        localc.scene = 11;
        localc.dvS = 1110;
        localc.position = i;
        localLinkedList.add(localc);
        i += 1;
      }
    }
    AppMethodBeat.o(41545);
    return localLinkedList;
  }
  
  private LinkedList<c> cDJ()
  {
    AppMethodBeat.i(41546);
    LinkedList localLinkedList = new LinkedList();
    if (this.rYh.scC == null)
    {
      AppMethodBeat.o(41546);
      return localLinkedList;
    }
    int j = this.rXN + 1;
    int i = this.rXN / 15;
    Iterator localIterator = this.rYh.scC.iterator();
    i += 901;
    label272:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        com.tencent.mm.plugin.game.d.d locald = (com.tencent.mm.plugin.game.d.d)localIterator.next();
        Object localObject = null;
        switch (locald.mBH)
        {
        }
        for (;;)
        {
          if (localObject == null) {
            break label272;
          }
          localObject.scene = 11;
          localObject.dvS = 1111;
          localLinkedList.add(localObject);
          break;
          c localc = a(locald.rZp);
          localObject = localc;
          if (localc != null)
          {
            localc.position = j;
            j += 1;
            localObject = localc;
            continue;
            if (locald.rZs != null)
            {
              localc = a(locald.rZs.rZp);
              localObject = localc;
              if (localc != null)
              {
                localc.type = 1;
                localc.rUV = locald.rZs.rZr;
                localc.rUW = locald.rZs.rZq;
                int k = i + 1;
                localc.position = i;
                i = k;
                localObject = localc;
              }
            }
          }
        }
      }
      AppMethodBeat.o(41546);
      return localLinkedList;
    }
  }
  
  public final HashMap<Integer, String> cDK()
  {
    AppMethodBeat.i(41547);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if ((this.rYh.scB == null) || (this.rYh.scB.sdg == null))
    {
      AppMethodBeat.o(41547);
      return localLinkedHashMap;
    }
    Iterator localIterator = this.rYh.scB.sdg.iterator();
    while (localIterator.hasNext())
    {
      dd localdd = (dd)localIterator.next();
      localLinkedHashMap.put(Integer.valueOf(localdd.scz), localdd.Name);
    }
    AppMethodBeat.o(41547);
    return localLinkedHashMap;
  }
  
  public final LinkedList<GameLibraryCategoriesView.a> cDL()
  {
    AppMethodBeat.i(41548);
    if ((this.rYh.scB == null) || (this.rYh.scB.sde == null))
    {
      AppMethodBeat.o(41548);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.rYh.scB.sde.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      GameLibraryCategoriesView.a locala = new GameLibraryCategoriesView.a();
      locala.sjP = localn.saf;
      locala.rCn = localn.Name;
      locala.sjQ = localn.rZr;
      locala.iVP = localn.rZw;
      i += 1;
      locala.position = i;
      localLinkedList.add(locala);
    }
    AppMethodBeat.o(41548);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ae
 * JD-Core Version:    0.7.0.1
 */