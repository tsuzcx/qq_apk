package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.plugin.game.protobuf.by;
import com.tencent.mm.plugin.game.protobuf.da;
import com.tencent.mm.plugin.game.protobuf.dk;
import com.tencent.mm.plugin.game.protobuf.dl;
import com.tencent.mm.plugin.game.protobuf.dy;
import com.tencent.mm.plugin.game.protobuf.e;
import com.tencent.mm.plugin.game.protobuf.g;
import com.tencent.mm.plugin.game.protobuf.s;
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
  public by IFA;
  public LinkedList<c> IFB;
  public LinkedList<c> IFC;
  private int IFh;
  
  public ae(a parama, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(41543);
    this.IFh = 0;
    if (parama == null)
    {
      this.IFA = new by();
      AppMethodBeat.o(41543);
      return;
    }
    this.IFA = ((by)parama);
    this.IFh = paramInt;
    this.IFB = fGU();
    this.IFC = fGV();
    if (paramBoolean) {
      ((f)h.ax(f.class)).fCi().b("pb_library", parama);
    }
    d.bz(this.IFB);
    d.bz(this.IFC);
    AppMethodBeat.o(41543);
  }
  
  public ae(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41544);
    this.IFh = 0;
    this.IFA = new by();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41544);
      return;
    }
    try
    {
      this.IFA.parseFrom(paramArrayOfByte);
      this.IFB = fGU();
      this.IFC = fGV();
      d.bz(this.IFB);
      d.bz(this.IFC);
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
  
  private LinkedList<c> fGU()
  {
    AppMethodBeat.i(41545);
    LinkedList localLinkedList = new LinkedList();
    if ((this.IFA.IKs == null) || (this.IFA.IKs.ILc == null) || (this.IFA.IKs.ILc.ILs == null))
    {
      AppMethodBeat.o(41545);
      return localLinkedList;
    }
    Iterator localIterator = this.IFA.IKs.ILc.ILs.iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      dl localdl = (dl)localIterator.next();
      c localc = a(localdl.IGJ);
      if (localc != null)
      {
        localc.ICp = localdl.IGJ.IHa;
        localc.scene = 11;
        localc.hYi = 1110;
        localc.position = i;
        localLinkedList.add(localc);
        i += 1;
      }
    }
    AppMethodBeat.o(41545);
    return localLinkedList;
  }
  
  private LinkedList<c> fGV()
  {
    AppMethodBeat.i(41546);
    LinkedList localLinkedList = new LinkedList();
    if (this.IFA.IKt == null)
    {
      AppMethodBeat.o(41546);
      return localLinkedList;
    }
    int j = this.IFh + 1;
    int i = this.IFh / 15;
    Iterator localIterator = this.IFA.IKt.iterator();
    i += 901;
    label272:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        Object localObject = null;
        switch (locale.vhJ)
        {
        }
        for (;;)
        {
          if (localObject == null) {
            break label272;
          }
          localObject.scene = 11;
          localObject.hYi = 1111;
          localLinkedList.add(localObject);
          break;
          c localc = a(locale.IGJ);
          localObject = localc;
          if (localc != null)
          {
            localc.position = j;
            j += 1;
            localObject = localc;
            continue;
            if (locale.IGP != null)
            {
              localc = a(locale.IGP.IGJ);
              localObject = localc;
              if (localc != null)
              {
                localc.type = 1;
                localc.ICi = locale.IGP.IGL;
                localc.ICj = locale.IGP.IGK;
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
  
  public final HashMap<Integer, String> fGW()
  {
    AppMethodBeat.i(41547);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if ((this.IFA.IKs == null) || (this.IFA.IKs.ILf == null))
    {
      AppMethodBeat.o(41547);
      return localLinkedHashMap;
    }
    Iterator localIterator = this.IFA.IKs.ILf.iterator();
    while (localIterator.hasNext())
    {
      dy localdy = (dy)localIterator.next();
      localLinkedHashMap.put(Integer.valueOf(localdy.IKq), localdy.IGU);
    }
    AppMethodBeat.o(41547);
    return localLinkedHashMap;
  }
  
  public final LinkedList<GameLibraryCategoriesView.a> fGX()
  {
    AppMethodBeat.i(41548);
    if ((this.IFA.IKs == null) || (this.IFA.IKs.ILd == null))
    {
      AppMethodBeat.o(41548);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.IFA.IKs.ILd.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      s locals = (s)localIterator.next();
      GameLibraryCategoriesView.a locala = new GameLibraryCategoriesView.a();
      locala.ISa = locals.IHU;
      locala.HIH = locals.IGU;
      locala.ISb = locals.IGL;
      locala.qQb = locals.IGT;
      i += 1;
      locala.position = i;
      localLinkedList.add(locala);
    }
    AppMethodBeat.o(41548);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ae
 * JD-Core Version:    0.7.0.1
 */