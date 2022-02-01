package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.e.d;
import com.tencent.mm.plugin.game.protobuf.bw;
import com.tencent.mm.plugin.game.protobuf.cw;
import com.tencent.mm.plugin.game.protobuf.df;
import com.tencent.mm.plugin.game.protobuf.dg;
import com.tencent.mm.plugin.game.protobuf.dt;
import com.tencent.mm.plugin.game.protobuf.e;
import com.tencent.mm.plugin.game.protobuf.q;
import com.tencent.mm.plugin.game.ui.GameLibraryCategoriesView.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class ae
  extends x
{
  private int xGW;
  public bw xHq;
  public LinkedList<c> xHr;
  public LinkedList<c> xHs;
  
  public ae(a parama, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(41543);
    this.xGW = 0;
    if (parama == null)
    {
      this.xHq = new bw();
      AppMethodBeat.o(41543);
      return;
    }
    this.xHq = ((bw)parama);
    this.xGW = paramInt;
    this.xHr = dVQ();
    this.xHs = dVR();
    if (paramBoolean) {
      ((f)com.tencent.mm.kernel.g.af(f.class)).dSL().b("pb_library", parama);
    }
    d.aZ(this.xHr);
    d.aZ(this.xHs);
    AppMethodBeat.o(41543);
  }
  
  public ae(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41544);
    this.xGW = 0;
    this.xHq = new bw();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41544);
      return;
    }
    try
    {
      this.xHq.parseFrom(paramArrayOfByte);
      this.xHr = dVQ();
      this.xHs = dVR();
      d.aZ(this.xHr);
      d.aZ(this.xHs);
      AppMethodBeat.o(41544);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        Log.e("MicroMsg.GamePBDataLibrary", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private LinkedList<c> dVQ()
  {
    AppMethodBeat.i(41545);
    LinkedList localLinkedList = new LinkedList();
    if ((this.xHq.xLZ == null) || (this.xHq.xLZ.xMF == null) || (this.xHq.xLZ.xMF.xMT == null))
    {
      AppMethodBeat.o(41545);
      return localLinkedList;
    }
    Iterator localIterator = this.xHq.xLZ.xMF.xMT.iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      dg localdg = (dg)localIterator.next();
      c localc = a(localdg.xIz);
      if (localc != null)
      {
        localc.xEe = localdg.xIz.xIP;
        localc.scene = 11;
        localc.dYu = 1110;
        localc.position = i;
        localLinkedList.add(localc);
        i += 1;
      }
    }
    AppMethodBeat.o(41545);
    return localLinkedList;
  }
  
  private LinkedList<c> dVR()
  {
    AppMethodBeat.i(41546);
    LinkedList localLinkedList = new LinkedList();
    if (this.xHq.xMa == null)
    {
      AppMethodBeat.o(41546);
      return localLinkedList;
    }
    int j = this.xGW + 1;
    int i = this.xGW / 15;
    Iterator localIterator = this.xHq.xMa.iterator();
    i += 901;
    label272:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        Object localObject = null;
        switch (locale.oUv)
        {
        }
        for (;;)
        {
          if (localObject == null) {
            break label272;
          }
          localObject.scene = 11;
          localObject.dYu = 1111;
          localLinkedList.add(localObject);
          break;
          c localc = a(locale.xIz);
          localObject = localc;
          if (localc != null)
          {
            localc.position = j;
            j += 1;
            localObject = localc;
            continue;
            if (locale.xIF != null)
            {
              localc = a(locale.xIF.xIz);
              localObject = localc;
              if (localc != null)
              {
                localc.type = 1;
                localc.xDX = locale.xIF.xIB;
                localc.xDY = locale.xIF.xIA;
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
  
  public final HashMap<Integer, String> dVS()
  {
    AppMethodBeat.i(41547);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if ((this.xHq.xLZ == null) || (this.xHq.xLZ.xMI == null))
    {
      AppMethodBeat.o(41547);
      return localLinkedHashMap;
    }
    Iterator localIterator = this.xHq.xLZ.xMI.iterator();
    while (localIterator.hasNext())
    {
      dt localdt = (dt)localIterator.next();
      localLinkedHashMap.put(Integer.valueOf(localdt.xLX), localdt.Name);
    }
    AppMethodBeat.o(41547);
    return localLinkedHashMap;
  }
  
  public final LinkedList<GameLibraryCategoriesView.a> dVT()
  {
    AppMethodBeat.i(41548);
    if ((this.xHq.xLZ == null) || (this.xHq.xLZ.xMG == null))
    {
      AppMethodBeat.o(41548);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.xHq.xLZ.xMG.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      GameLibraryCategoriesView.a locala = new GameLibraryCategoriesView.a();
      locala.xTz = localq.xJC;
      locala.xjU = localq.Name;
      locala.xTA = localq.xIB;
      locala.kVZ = localq.xIJ;
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