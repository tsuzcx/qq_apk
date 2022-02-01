package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.d.bw;
import com.tencent.mm.plugin.game.d.cw;
import com.tencent.mm.plugin.game.d.df;
import com.tencent.mm.plugin.game.d.dg;
import com.tencent.mm.plugin.game.d.dt;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.q;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.plugin.game.ui.GameLibraryCategoriesView.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class ae
  extends x
{
  private int uoD;
  public bw uoX;
  public LinkedList<c> uoY;
  public LinkedList<c> uoZ;
  
  public ae(a parama, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(41543);
    this.uoD = 0;
    if (parama == null)
    {
      this.uoX = new bw();
      AppMethodBeat.o(41543);
      return;
    }
    this.uoX = ((bw)parama);
    this.uoD = paramInt;
    this.uoY = dcj();
    this.uoZ = dck();
    if (paramBoolean) {
      ((f)com.tencent.mm.kernel.g.ab(f.class)).cZm().b("pb_library", parama);
    }
    d.aE(this.uoY);
    d.aE(this.uoZ);
    AppMethodBeat.o(41543);
  }
  
  public ae(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41544);
    this.uoD = 0;
    this.uoX = new bw();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41544);
      return;
    }
    try
    {
      this.uoX.parseFrom(paramArrayOfByte);
      this.uoY = dcj();
      this.uoZ = dck();
      d.aE(this.uoY);
      d.aE(this.uoZ);
      AppMethodBeat.o(41544);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.GamePBDataLibrary", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private LinkedList<c> dcj()
  {
    AppMethodBeat.i(41545);
    LinkedList localLinkedList = new LinkedList();
    if ((this.uoX.utX == null) || (this.uoX.utX.uuE == null) || (this.uoX.utX.uuE.uuS == null))
    {
      AppMethodBeat.o(41545);
      return localLinkedList;
    }
    Iterator localIterator = this.uoX.utX.uuE.uuS.iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      dg localdg = (dg)localIterator.next();
      c localc = a(localdg.uqg);
      if (localc != null)
      {
        localc.ulM = localdg.uqg.uqx;
        localc.scene = 11;
        localc.dGL = 1110;
        localc.position = i;
        localLinkedList.add(localc);
        i += 1;
      }
    }
    AppMethodBeat.o(41545);
    return localLinkedList;
  }
  
  private LinkedList<c> dck()
  {
    AppMethodBeat.i(41546);
    LinkedList localLinkedList = new LinkedList();
    if (this.uoX.utY == null)
    {
      AppMethodBeat.o(41546);
      return localLinkedList;
    }
    int j = this.uoD + 1;
    int i = this.uoD / 15;
    Iterator localIterator = this.uoX.utY.iterator();
    i += 901;
    label272:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        Object localObject = null;
        switch (locale.nJA)
        {
        }
        for (;;)
        {
          if (localObject == null) {
            break label272;
          }
          localObject.scene = 11;
          localObject.dGL = 1111;
          localLinkedList.add(localObject);
          break;
          c localc = a(locale.uqg);
          localObject = localc;
          if (localc != null)
          {
            localc.position = j;
            j += 1;
            localObject = localc;
            continue;
            if (locale.uqm != null)
            {
              localc = a(locale.uqm.uqg);
              localObject = localc;
              if (localc != null)
              {
                localc.type = 1;
                localc.ulF = locale.uqm.uqi;
                localc.ulG = locale.uqm.uqh;
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
  
  public final HashMap<Integer, String> dcl()
  {
    AppMethodBeat.i(41547);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if ((this.uoX.utX == null) || (this.uoX.utX.uuH == null))
    {
      AppMethodBeat.o(41547);
      return localLinkedHashMap;
    }
    Iterator localIterator = this.uoX.utX.uuH.iterator();
    while (localIterator.hasNext())
    {
      dt localdt = (dt)localIterator.next();
      localLinkedHashMap.put(Integer.valueOf(localdt.utV), localdt.Name);
    }
    AppMethodBeat.o(41547);
    return localLinkedHashMap;
  }
  
  public final LinkedList<GameLibraryCategoriesView.a> dcm()
  {
    AppMethodBeat.i(41548);
    if ((this.uoX.utX == null) || (this.uoX.utX.uuF == null))
    {
      AppMethodBeat.o(41548);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.uoX.utX.uuF.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      GameLibraryCategoriesView.a locala = new GameLibraryCategoriesView.a();
      locala.uBB = localq.urk;
      locala.tSH = localq.Name;
      locala.uBC = localq.uqi;
      locala.jTr = localq.uqq;
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