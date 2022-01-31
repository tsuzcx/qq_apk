package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.b;
import com.tencent.mm.plugin.game.d.bl;
import com.tencent.mm.plugin.game.d.cg;
import com.tencent.mm.plugin.game.d.cp;
import com.tencent.mm.plugin.game.d.cq;
import com.tencent.mm.plugin.game.d.db;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.l;
import com.tencent.mm.plugin.game.ui.GameLibraryCategoriesView.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class af
  extends y
{
  public bl kQI;
  public LinkedList<d> kQJ;
  public LinkedList<d> kQK;
  private int kQn = 0;
  
  public af(a parama, boolean paramBoolean, int paramInt)
  {
    if (parama == null)
    {
      this.kQI = new bl();
      return;
    }
    this.kQI = ((bl)parama);
    this.kQn = paramInt;
    this.kQJ = aZJ();
    this.kQK = aZK();
    if (paramBoolean) {
      ((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYg().b("pb_library", parama);
    }
    com.tencent.mm.plugin.game.f.d.Y(this.kQJ);
    com.tencent.mm.plugin.game.f.d.Y(this.kQK);
  }
  
  public af(byte[] paramArrayOfByte)
  {
    this.kQI = new bl();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return;
    }
    try
    {
      this.kQI.aH(paramArrayOfByte);
      this.kQJ = aZJ();
      this.kQK = aZK();
      com.tencent.mm.plugin.game.f.d.Y(this.kQJ);
      com.tencent.mm.plugin.game.f.d.Y(this.kQK);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.GamePBDataLibrary", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private LinkedList<d> aZJ()
  {
    LinkedList localLinkedList = new LinkedList();
    if ((this.kQI.kUX == null) || (this.kQI.kUX.kVB == null) || (this.kQI.kUX.kVB.kVQ == null)) {
      return localLinkedList;
    }
    Iterator localIterator = this.kQI.kUX.kVB.kVQ.iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      cq localcq = (cq)localIterator.next();
      d locald = a(localcq.kRQ);
      if (locald != null)
      {
        locald.kOh = localcq.kRQ.kSg;
        locald.scene = 11;
        locald.bXn = 1110;
        locald.position = i;
        localLinkedList.add(locald);
        i += 1;
      }
    }
    return localLinkedList;
  }
  
  private LinkedList<d> aZK()
  {
    LinkedList localLinkedList = new LinkedList();
    if (this.kQI.kUY == null) {
      return localLinkedList;
    }
    int j = this.kQn + 1;
    int i = this.kQn / 15;
    Iterator localIterator = this.kQI.kUY.iterator();
    i += 901;
    label259:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        com.tencent.mm.plugin.game.d.c localc = (com.tencent.mm.plugin.game.d.c)localIterator.next();
        Object localObject = null;
        switch (localc.hQR)
        {
        }
        for (;;)
        {
          if (localObject == null) {
            break label259;
          }
          localObject.scene = 11;
          localObject.bXn = 1111;
          localLinkedList.add(localObject);
          break;
          d locald = a(localc.kRQ);
          localObject = locald;
          if (locald != null)
          {
            locald.position = j;
            j += 1;
            localObject = locald;
            continue;
            if (localc.kRT != null)
            {
              locald = a(localc.kRT.kRQ);
              localObject = locald;
              if (locald != null)
              {
                locald.type = 1;
                locald.kNZ = localc.kRT.kRS;
                locald.kOa = localc.kRT.kRR;
                int k = i + 1;
                locald.position = i;
                i = k;
                localObject = locald;
              }
            }
          }
        }
      }
      return localLinkedList;
    }
  }
  
  public final HashMap<Integer, String> aZL()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if ((this.kQI.kUX == null) || (this.kQI.kUX.kVE == null)) {
      return localLinkedHashMap;
    }
    Iterator localIterator = this.kQI.kUX.kVE.iterator();
    while (localIterator.hasNext())
    {
      db localdb = (db)localIterator.next();
      localLinkedHashMap.put(Integer.valueOf(localdb.kUV), localdb.kRZ);
    }
    return localLinkedHashMap;
  }
  
  public final LinkedList<GameLibraryCategoriesView.a> aZM()
  {
    if ((this.kQI.kUX == null) || (this.kQI.kUX.kVC == null)) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.kQI.kUX.kVC.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      GameLibraryCategoriesView.a locala = new GameLibraryCategoriesView.a();
      locala.lcw = locall.kSD;
      locala.lcx = locall.kRZ;
      locala.lcy = locall.kRS;
      locala.fJY = locall.kRY;
      i += 1;
      locala.position = i;
      localLinkedList.add(locala);
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.af
 * JD-Core Version:    0.7.0.1
 */