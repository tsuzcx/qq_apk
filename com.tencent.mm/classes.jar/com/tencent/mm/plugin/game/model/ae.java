package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
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
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class ae
  extends x
{
  private int tfF;
  public bm tfZ;
  public LinkedList<c> tga;
  public LinkedList<c> tgb;
  
  public ae(a parama, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(41543);
    this.tfF = 0;
    if (parama == null)
    {
      this.tfZ = new bm();
      AppMethodBeat.o(41543);
      return;
    }
    this.tfZ = ((bm)parama);
    this.tfF = paramInt;
    this.tga = cQS();
    this.tgb = cQT();
    if (paramBoolean) {
      ((e)g.ab(e.class)).cOn().b("pb_library", parama);
    }
    com.tencent.mm.plugin.game.f.d.aC(this.tga);
    com.tencent.mm.plugin.game.f.d.aC(this.tgb);
    AppMethodBeat.o(41543);
  }
  
  public ae(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41544);
    this.tfF = 0;
    this.tfZ = new bm();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41544);
      return;
    }
    try
    {
      this.tfZ.parseFrom(paramArrayOfByte);
      this.tga = cQS();
      this.tgb = cQT();
      com.tencent.mm.plugin.game.f.d.aC(this.tga);
      com.tencent.mm.plugin.game.f.d.aC(this.tgb);
      AppMethodBeat.o(41544);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        ac.e("MicroMsg.GamePBDataLibrary", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private LinkedList<c> cQS()
  {
    AppMethodBeat.i(41545);
    LinkedList localLinkedList = new LinkedList();
    if ((this.tfZ.tkv == null) || (this.tfZ.tkv.tkX == null) || (this.tfZ.tkv.tkX.tll == null))
    {
      AppMethodBeat.o(41545);
      return localLinkedList;
    }
    Iterator localIterator = this.tfZ.tkv.tkX.tll.iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      cr localcr = (cr)localIterator.next();
      c localc = a(localcr.thi);
      if (localc != null)
      {
        localc.tcU = localcr.thi.thw;
        localc.scene = 11;
        localc.dtF = 1110;
        localc.position = i;
        localLinkedList.add(localc);
        i += 1;
      }
    }
    AppMethodBeat.o(41545);
    return localLinkedList;
  }
  
  private LinkedList<c> cQT()
  {
    AppMethodBeat.i(41546);
    LinkedList localLinkedList = new LinkedList();
    if (this.tfZ.tkw == null)
    {
      AppMethodBeat.o(41546);
      return localLinkedList;
    }
    int j = this.tfF + 1;
    int i = this.tfF / 15;
    Iterator localIterator = this.tfZ.tkw.iterator();
    i += 901;
    label272:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        com.tencent.mm.plugin.game.d.d locald = (com.tencent.mm.plugin.game.d.d)localIterator.next();
        Object localObject = null;
        switch (locald.ndI)
        {
        }
        for (;;)
        {
          if (localObject == null) {
            break label272;
          }
          localObject.scene = 11;
          localObject.dtF = 1111;
          localLinkedList.add(localObject);
          break;
          c localc = a(locald.thi);
          localObject = localc;
          if (localc != null)
          {
            localc.position = j;
            j += 1;
            localObject = localc;
            continue;
            if (locald.thl != null)
            {
              localc = a(locald.thl.thi);
              localObject = localc;
              if (localc != null)
              {
                localc.type = 1;
                localc.tcN = locald.thl.thk;
                localc.tcO = locald.thl.thj;
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
  
  public final HashMap<Integer, String> cQU()
  {
    AppMethodBeat.i(41547);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if ((this.tfZ.tkv == null) || (this.tfZ.tkv.tla == null))
    {
      AppMethodBeat.o(41547);
      return localLinkedHashMap;
    }
    Iterator localIterator = this.tfZ.tkv.tla.iterator();
    while (localIterator.hasNext())
    {
      dd localdd = (dd)localIterator.next();
      localLinkedHashMap.put(Integer.valueOf(localdd.tkt), localdd.Name);
    }
    AppMethodBeat.o(41547);
    return localLinkedHashMap;
  }
  
  public final LinkedList<GameLibraryCategoriesView.a> cQV()
  {
    AppMethodBeat.i(41548);
    if ((this.tfZ.tkv == null) || (this.tfZ.tkv.tkY == null))
    {
      AppMethodBeat.o(41548);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.tfZ.tkv.tkY.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      GameLibraryCategoriesView.a locala = new GameLibraryCategoriesView.a();
      locala.trI = localn.thY;
      locala.sLh = localn.Name;
      locala.trJ = localn.thk;
      locala.jwf = localn.thp;
      i += 1;
      locala.position = i;
      localLinkedList.add(locala);
    }
    AppMethodBeat.o(41548);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ae
 * JD-Core Version:    0.7.0.1
 */