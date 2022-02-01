package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.bp;
import com.tencent.mm.plugin.game.d.co;
import com.tencent.mm.plugin.game.d.cx;
import com.tencent.mm.plugin.game.d.cy;
import com.tencent.mm.plugin.game.d.dl;
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
  public bp udP;
  public LinkedList<c> udQ;
  public LinkedList<c> udR;
  private int udv;
  
  public ae(a parama, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(41543);
    this.udv = 0;
    if (parama == null)
    {
      this.udP = new bp();
      AppMethodBeat.o(41543);
      return;
    }
    this.udP = ((bp)parama);
    this.udv = paramInt;
    this.udQ = cZy();
    this.udR = cZz();
    if (paramBoolean) {
      ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWI().b("pb_library", parama);
    }
    com.tencent.mm.plugin.game.f.d.aE(this.udQ);
    com.tencent.mm.plugin.game.f.d.aE(this.udR);
    AppMethodBeat.o(41543);
  }
  
  public ae(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41544);
    this.udv = 0;
    this.udP = new bp();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41544);
      return;
    }
    try
    {
      this.udP.parseFrom(paramArrayOfByte);
      this.udQ = cZy();
      this.udR = cZz();
      com.tencent.mm.plugin.game.f.d.aE(this.udQ);
      com.tencent.mm.plugin.game.f.d.aE(this.udR);
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
  
  private LinkedList<c> cZy()
  {
    AppMethodBeat.i(41545);
    LinkedList localLinkedList = new LinkedList();
    if ((this.udP.uiz == null) || (this.udP.uiz.ujg == null) || (this.udP.uiz.ujg.uju == null))
    {
      AppMethodBeat.o(41545);
      return localLinkedList;
    }
    Iterator localIterator = this.udP.uiz.ujg.uju.iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      cy localcy = (cy)localIterator.next();
      c localc = a(localcy.ueZ);
      if (localc != null)
      {
        localc.uaK = localcy.ueZ.ufn;
        localc.scene = 11;
        localc.dFG = 1110;
        localc.position = i;
        localLinkedList.add(localc);
        i += 1;
      }
    }
    AppMethodBeat.o(41545);
    return localLinkedList;
  }
  
  private LinkedList<c> cZz()
  {
    AppMethodBeat.i(41546);
    LinkedList localLinkedList = new LinkedList();
    if (this.udP.uiA == null)
    {
      AppMethodBeat.o(41546);
      return localLinkedList;
    }
    int j = this.udv + 1;
    int i = this.udv / 15;
    Iterator localIterator = this.udP.uiA.iterator();
    i += 901;
    label272:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        com.tencent.mm.plugin.game.d.d locald = (com.tencent.mm.plugin.game.d.d)localIterator.next();
        Object localObject = null;
        switch (locald.nEf)
        {
        }
        for (;;)
        {
          if (localObject == null) {
            break label272;
          }
          localObject.scene = 11;
          localObject.dFG = 1111;
          localLinkedList.add(localObject);
          break;
          c localc = a(locald.ueZ);
          localObject = localc;
          if (localc != null)
          {
            localc.position = j;
            j += 1;
            localObject = localc;
            continue;
            if (locald.ufc != null)
            {
              localc = a(locald.ufc.ueZ);
              localObject = localc;
              if (localc != null)
              {
                localc.type = 1;
                localc.uaD = locald.ufc.ufb;
                localc.uaE = locald.ufc.ufa;
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
  
  public final HashMap<Integer, String> cZA()
  {
    AppMethodBeat.i(41547);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if ((this.udP.uiz == null) || (this.udP.uiz.ujj == null))
    {
      AppMethodBeat.o(41547);
      return localLinkedHashMap;
    }
    Iterator localIterator = this.udP.uiz.ujj.iterator();
    while (localIterator.hasNext())
    {
      dl localdl = (dl)localIterator.next();
      localLinkedHashMap.put(Integer.valueOf(localdl.uix), localdl.Name);
    }
    AppMethodBeat.o(41547);
    return localLinkedHashMap;
  }
  
  public final LinkedList<GameLibraryCategoriesView.a> cZB()
  {
    AppMethodBeat.i(41548);
    if ((this.udP.uiz == null) || (this.udP.uiz.ujh == null))
    {
      AppMethodBeat.o(41548);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.udP.uiz.ujh.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      GameLibraryCategoriesView.a locala = new GameLibraryCategoriesView.a();
      locala.uqf = localn.ufP;
      locala.tHQ = localn.Name;
      locala.uqg = localn.ufb;
      locala.jPZ = localn.ufg;
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