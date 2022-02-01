package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.plugin.game.protobuf.bx;
import com.tencent.mm.plugin.game.protobuf.cx;
import com.tencent.mm.plugin.game.protobuf.dg;
import com.tencent.mm.plugin.game.protobuf.dh;
import com.tencent.mm.plugin.game.protobuf.du;
import com.tencent.mm.plugin.game.protobuf.e;
import com.tencent.mm.plugin.game.protobuf.g;
import com.tencent.mm.plugin.game.protobuf.r;
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
  private int CKZ;
  public bx CLt;
  public LinkedList<c> CLu;
  public LinkedList<c> CLv;
  
  public ae(a parama, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(41543);
    this.CKZ = 0;
    if (parama == null)
    {
      this.CLt = new bx();
      AppMethodBeat.o(41543);
      return;
    }
    this.CLt = ((bx)parama);
    this.CKZ = paramInt;
    this.CLu = eyY();
    this.CLv = eyZ();
    if (paramBoolean) {
      ((f)h.ae(f.class)).evp().b("pb_library", parama);
    }
    d.bs(this.CLu);
    d.bs(this.CLv);
    AppMethodBeat.o(41543);
  }
  
  public ae(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41544);
    this.CKZ = 0;
    this.CLt = new bx();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41544);
      return;
    }
    try
    {
      this.CLt.parseFrom(paramArrayOfByte);
      this.CLu = eyY();
      this.CLv = eyZ();
      d.bs(this.CLu);
      d.bs(this.CLv);
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
  
  private LinkedList<c> eyY()
  {
    AppMethodBeat.i(41545);
    LinkedList localLinkedList = new LinkedList();
    if ((this.CLt.CQi == null) || (this.CLt.CQi.CQO == null) || (this.CLt.CQi.CQO.CRc == null))
    {
      AppMethodBeat.o(41545);
      return localLinkedList;
    }
    Iterator localIterator = this.CLt.CQi.CQO.CRc.iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      dh localdh = (dh)localIterator.next();
      c localc = a(localdh.CME);
      if (localc != null)
      {
        localc.CIf = localdh.CME.CMV;
        localc.scene = 11;
        localc.fSl = 1110;
        localc.position = i;
        localLinkedList.add(localc);
        i += 1;
      }
    }
    AppMethodBeat.o(41545);
    return localLinkedList;
  }
  
  private LinkedList<c> eyZ()
  {
    AppMethodBeat.i(41546);
    LinkedList localLinkedList = new LinkedList();
    if (this.CLt.CQj == null)
    {
      AppMethodBeat.o(41546);
      return localLinkedList;
    }
    int j = this.CKZ + 1;
    int i = this.CKZ / 15;
    Iterator localIterator = this.CLt.CQj.iterator();
    i += 901;
    label272:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        Object localObject = null;
        switch (locale.rWu)
        {
        }
        for (;;)
        {
          if (localObject == null) {
            break label272;
          }
          localObject.scene = 11;
          localObject.fSl = 1111;
          localLinkedList.add(localObject);
          break;
          c localc = a(locale.CME);
          localObject = localc;
          if (localc != null)
          {
            localc.position = j;
            j += 1;
            localObject = localc;
            continue;
            if (locale.CMK != null)
            {
              localc = a(locale.CMK.CME);
              localObject = localc;
              if (localc != null)
              {
                localc.type = 1;
                localc.CHY = locale.CMK.CMG;
                localc.CHZ = locale.CMK.CMF;
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
  
  public final HashMap<Integer, String> eza()
  {
    AppMethodBeat.i(41547);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if ((this.CLt.CQi == null) || (this.CLt.CQi.CQR == null))
    {
      AppMethodBeat.o(41547);
      return localLinkedHashMap;
    }
    Iterator localIterator = this.CLt.CQi.CQR.iterator();
    while (localIterator.hasNext())
    {
      du localdu = (du)localIterator.next();
      localLinkedHashMap.put(Integer.valueOf(localdu.CQg), localdu.CMP);
    }
    AppMethodBeat.o(41547);
    return localLinkedHashMap;
  }
  
  public final LinkedList<GameLibraryCategoriesView.a> ezb()
  {
    AppMethodBeat.i(41548);
    if ((this.CLt.CQi == null) || (this.CLt.CQi.CQP == null))
    {
      AppMethodBeat.o(41548);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.CLt.CQi.CQP.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      r localr = (r)localIterator.next();
      GameLibraryCategoriesView.a locala = new GameLibraryCategoriesView.a();
      locala.CXK = localr.CNK;
      locala.BWk = localr.CMP;
      locala.CXL = localr.CMG;
      locala.nQm = localr.CMO;
      i += 1;
      locala.position = i;
      localLinkedList.add(locala);
    }
    AppMethodBeat.o(41548);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ae
 * JD-Core Version:    0.7.0.1
 */