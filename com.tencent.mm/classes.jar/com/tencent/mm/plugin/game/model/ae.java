package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.b;
import com.tencent.mm.plugin.game.d.bm;
import com.tencent.mm.plugin.game.d.ch;
import com.tencent.mm.plugin.game.d.cq;
import com.tencent.mm.plugin.game.d.cr;
import com.tencent.mm.plugin.game.d.dc;
import com.tencent.mm.plugin.game.d.l;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.plugin.game.ui.GameLibraryCategoriesView.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class ae
  extends x
{
  public bm noM;
  public LinkedList<c> noN;
  public LinkedList<c> noO;
  private int nor;
  
  public ae(a parama, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(111378);
    this.nor = 0;
    if (parama == null)
    {
      this.noM = new bm();
      AppMethodBeat.o(111378);
      return;
    }
    this.noM = ((bm)parama);
    this.nor = paramInt;
    this.noN = bGN();
    this.noO = bGO();
    if (paramBoolean) {
      ((com.tencent.mm.plugin.game.api.e)g.E(com.tencent.mm.plugin.game.api.e.class)).bET().b("pb_library", parama);
    }
    d.ag(this.noN);
    d.ag(this.noO);
    AppMethodBeat.o(111378);
  }
  
  public ae(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(111379);
    this.nor = 0;
    this.noM = new bm();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(111379);
      return;
    }
    try
    {
      this.noM.parseFrom(paramArrayOfByte);
      this.noN = bGN();
      this.noO = bGO();
      d.ag(this.noN);
      d.ag(this.noO);
      AppMethodBeat.o(111379);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        ab.e("MicroMsg.GamePBDataLibrary", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private LinkedList<c> bGN()
  {
    AppMethodBeat.i(111380);
    LinkedList localLinkedList = new LinkedList();
    if ((this.noM.nsZ == null) || (this.noM.nsZ.ntC == null) || (this.noM.nsZ.ntC.ntQ == null))
    {
      AppMethodBeat.o(111380);
      return localLinkedList;
    }
    Iterator localIterator = this.noM.nsZ.ntC.ntQ.iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      cr localcr = (cr)localIterator.next();
      c localc = a(localcr.npS);
      if (localc != null)
      {
        localc.nme = localcr.npS.nqh;
        localc.scene = 11;
        localc.cFj = 1110;
        localc.position = i;
        localLinkedList.add(localc);
        i += 1;
      }
    }
    AppMethodBeat.o(111380);
    return localLinkedList;
  }
  
  private LinkedList<c> bGO()
  {
    AppMethodBeat.i(111381);
    LinkedList localLinkedList = new LinkedList();
    if (this.noM.nta == null)
    {
      AppMethodBeat.o(111381);
      return localLinkedList;
    }
    int j = this.nor + 1;
    int i = this.nor / 15;
    Iterator localIterator = this.noM.nta.iterator();
    i += 901;
    label272:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        com.tencent.mm.plugin.game.d.c localc1 = (com.tencent.mm.plugin.game.d.c)localIterator.next();
        Object localObject = null;
        switch (localc1.jKs)
        {
        }
        for (;;)
        {
          if (localObject == null) {
            break label272;
          }
          localObject.scene = 11;
          localObject.cFj = 1111;
          localLinkedList.add(localObject);
          break;
          c localc = a(localc1.npS);
          localObject = localc;
          if (localc != null)
          {
            localc.position = j;
            j += 1;
            localObject = localc;
            continue;
            if (localc1.npV != null)
            {
              localc = a(localc1.npV.npS);
              localObject = localc;
              if (localc != null)
              {
                localc.type = 1;
                localc.nlW = localc1.npV.npU;
                localc.nlX = localc1.npV.npT;
                int k = i + 1;
                localc.position = i;
                i = k;
                localObject = localc;
              }
            }
          }
        }
      }
      AppMethodBeat.o(111381);
      return localLinkedList;
    }
  }
  
  public final HashMap<Integer, String> bGP()
  {
    AppMethodBeat.i(111382);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if ((this.noM.nsZ == null) || (this.noM.nsZ.ntF == null))
    {
      AppMethodBeat.o(111382);
      return localLinkedHashMap;
    }
    Iterator localIterator = this.noM.nsZ.ntF.iterator();
    while (localIterator.hasNext())
    {
      dc localdc = (dc)localIterator.next();
      localLinkedHashMap.put(Integer.valueOf(localdc.nsX), localdc.Name);
    }
    AppMethodBeat.o(111382);
    return localLinkedHashMap;
  }
  
  public final LinkedList<GameLibraryCategoriesView.a> bGQ()
  {
    AppMethodBeat.i(111383);
    if ((this.noM.nsZ == null) || (this.noM.nsZ.ntD == null))
    {
      AppMethodBeat.o(111383);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.noM.nsZ.ntD.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      GameLibraryCategoriesView.a locala = new GameLibraryCategoriesView.a();
      locala.nAr = locall.nqC;
      locala.nAs = locall.Name;
      locala.nAt = locall.npU;
      locala.hcN = locall.nqa;
      i += 1;
      locala.position = i;
      localLinkedList.add(locala);
    }
    AppMethodBeat.o(111383);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ae
 * JD-Core Version:    0.7.0.1
 */