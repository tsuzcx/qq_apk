package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.as;
import com.tencent.mm.plugin.game.d.at;
import com.tencent.mm.plugin.game.d.av;
import com.tencent.mm.plugin.game.d.bk;
import com.tencent.mm.plugin.game.d.cc;
import com.tencent.mm.plugin.game.d.cd;
import com.tencent.mm.plugin.game.d.cg;
import com.tencent.mm.plugin.game.d.f;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bg;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class af
  extends x
{
  public bk rYk;
  private boolean rYl;
  public LinkedList<c> rYm;
  public HashMap<String, Integer> rYn;
  
  public af(com.tencent.mm.bx.a parama)
  {
    AppMethodBeat.i(41549);
    this.rYn = new HashMap();
    if (parama == null)
    {
      this.rYk = new bk();
      AppMethodBeat.o(41549);
      return;
    }
    this.rYk = ((bk)parama);
    this.rYl = true;
    VL();
    AppMethodBeat.o(41549);
  }
  
  public af(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41550);
    this.rYn = new HashMap();
    this.rYk = new bk();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41550);
      return;
    }
    try
    {
      this.rYk.parseFrom(paramArrayOfByte);
      this.rYl = false;
      VL();
      AppMethodBeat.o(41550);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        ad.e("MicroMsg.GamePBDataOverSea", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private void VL()
  {
    AppMethodBeat.i(41551);
    this.rYm = cDM();
    if (this.rYl)
    {
      com.tencent.mm.plugin.game.f.d.av(this.rYm);
      cDN();
      ((com.tencent.mm.plugin.game.api.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.d.class)).cBb().init(aj.getContext());
    }
    AppMethodBeat.o(41551);
  }
  
  private LinkedList<c> cDM()
  {
    AppMethodBeat.i(41552);
    LinkedList localLinkedList = new LinkedList();
    if ((this.rYk.scu == null) || (this.rYk.scu.rZV == null))
    {
      AppMethodBeat.o(41552);
      return localLinkedList;
    }
    Iterator localIterator = this.rYk.scu.rZV.iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      Object localObject = (as)localIterator.next();
      if (((as)localObject).rZp != null)
      {
        c localc = a(((as)localObject).rZp);
        if (localc != null)
        {
          at localat;
          StringBuilder localStringBuilder;
          int j;
          if (((as)localObject).rZp.rZI != null) {
            if ((((as)localObject).rZp.rZI.Name != null) && (((as)localObject).rZp.rZI.sdb != null))
            {
              localc.rVf = ((as)localObject).rZp.rZI.Name;
              localc.rVg = ((as)localObject).rZp.rZI.sdb;
              localc.rVj = com.tencent.mm.plugin.game.e.a.ad(((as)localObject).rZW, "label", localc.rVf);
              if (((as)localObject).sbt == null) {
                break label476;
              }
              localObject = ((as)localObject).sbt.iterator();
              do
              {
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                localat = (at)((Iterator)localObject).next();
              } while (localat == null);
              if ((localat.sbu == null) || (localat.sbu.size() == 0)) {
                break label462;
              }
              localStringBuilder = new StringBuilder();
              j = 0;
              label271:
              if (j >= localat.sbu.size()) {
                break label423;
              }
              com.tencent.mm.storage.af localaf = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY((String)localat.sbu.get(j));
              if ((localaf == null) || (localaf.fId == 0L)) {
                break label402;
              }
              localStringBuilder.append(localaf.ZX());
            }
          }
          for (;;)
          {
            if (j < localat.sbu.size() - 1) {
              localStringBuilder.append("、");
            }
            j += 1;
            break label271;
            localc.rVj = com.tencent.mm.plugin.game.e.a.qh(((as)localObject).rZW);
            break;
            localc.rVj = com.tencent.mm.plugin.game.e.a.qh(((as)localObject).rZW);
            break;
            label402:
            localStringBuilder.append((String)localat.sbu.get(j));
          }
          label423:
          localStringBuilder.append(" ");
          localc.rVa.add(localStringBuilder.toString());
          for (;;)
          {
            localc.rVa.add(localat.saB);
            break;
            label462:
            localc.rVa.add("");
          }
          label476:
          localc.scene = 10;
          localc.dvS = 1004;
          localc.position = i;
          localLinkedList.add(localc);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(41552);
    return localLinkedList;
  }
  
  private void cDN()
  {
    AppMethodBeat.i(41553);
    this.rYn = new HashMap();
    if ((this.rYk.scv == null) || (this.rYk.scv.scY == null))
    {
      AppMethodBeat.o(41553);
      return;
    }
    Iterator localIterator = this.rYk.scv.scY.iterator();
    while (localIterator.hasNext())
    {
      cd localcd = (cd)localIterator.next();
      Object localObject = a(localcd.rZp);
      if (localObject != null)
      {
        this.rYn.put(((c)localObject).field_appId, Integer.valueOf(((c)localObject).versionCode));
        localObject = com.tencent.mm.plugin.s.a.cZQ().aAS(((c)localObject).field_appId);
        if (localObject != null)
        {
          ((com.tencent.mm.pluginsdk.model.app.g)localObject).mL(localcd.sda);
          if (!com.tencent.mm.plugin.s.a.cZQ().a((com.tencent.mm.pluginsdk.model.app.g)localObject, new String[0])) {
            ad.e("MicroMsg.GamePBDataOverSea", "Store rank info failed, AppID: %s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appId });
          }
        }
      }
    }
    AppMethodBeat.o(41553);
  }
  
  public final av cDO()
  {
    if (this.rYk != null) {
      return this.rYk.scs;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.af
 * JD-Core Version:    0.7.0.1
 */