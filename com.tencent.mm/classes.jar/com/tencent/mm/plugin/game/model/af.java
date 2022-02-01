package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.d.av;
import com.tencent.mm.plugin.game.d.aw;
import com.tencent.mm.plugin.game.d.ay;
import com.tencent.mm.plugin.game.d.bn;
import com.tencent.mm.plugin.game.d.ci;
import com.tencent.mm.plugin.game.d.cj;
import com.tencent.mm.plugin.game.d.cn;
import com.tencent.mm.plugin.game.d.f;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class af
  extends x
{
  public bn udS;
  private boolean udT;
  public LinkedList<c> udU;
  public HashMap<String, Integer> udV;
  
  public af(com.tencent.mm.bx.a parama)
  {
    AppMethodBeat.i(41549);
    this.udV = new HashMap();
    if (parama == null)
    {
      this.udS = new bn();
      AppMethodBeat.o(41549);
      return;
    }
    this.udS = ((bn)parama);
    this.udT = true;
    Zd();
    AppMethodBeat.o(41549);
  }
  
  public af(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41550);
    this.udV = new HashMap();
    this.udS = new bn();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41550);
      return;
    }
    try
    {
      this.udS.parseFrom(paramArrayOfByte);
      this.udT = false;
      Zd();
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
  
  private void Zd()
  {
    AppMethodBeat.i(41551);
    this.udU = cZC();
    if (this.udT)
    {
      d.aE(this.udU);
      cZD();
      ((e)com.tencent.mm.kernel.g.ab(e.class)).cWF().init(aj.getContext());
    }
    AppMethodBeat.o(41551);
  }
  
  private LinkedList<c> cZC()
  {
    AppMethodBeat.i(41552);
    LinkedList localLinkedList = new LinkedList();
    if ((this.udS.uis == null) || (this.udS.uis.ufF == null))
    {
      AppMethodBeat.o(41552);
      return localLinkedList;
    }
    Iterator localIterator = this.udS.uis.ufF.iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      Object localObject = (av)localIterator.next();
      if (((av)localObject).ueZ != null)
      {
        c localc = a(((av)localObject).ueZ);
        if (localc != null)
        {
          aw localaw;
          StringBuilder localStringBuilder;
          int j;
          if (((av)localObject).ueZ.ufs != null) {
            if ((((av)localObject).ueZ.ufs.Name != null) && (((av)localObject).ueZ.ufs.uje != null))
            {
              localc.uaN = ((av)localObject).ueZ.ufs.Name;
              localc.uaO = ((av)localObject).ueZ.ufs.uje;
              localc.uaR = com.tencent.mm.plugin.game.e.a.aj(((av)localObject).ufG, "label", localc.uaN);
              if (((av)localObject).uhn == null) {
                break label476;
              }
              localObject = ((av)localObject).uhn.iterator();
              do
              {
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                localaw = (aw)((Iterator)localObject).next();
              } while (localaw == null);
              if ((localaw.uho == null) || (localaw.uho.size() == 0)) {
                break label462;
              }
              localStringBuilder = new StringBuilder();
              j = 0;
              label271:
              if (j >= localaw.uho.size()) {
                break label423;
              }
              am localam = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf((String)localaw.uho.get(j));
              if ((localam == null) || (localam.gfj == 0L)) {
                break label402;
              }
              localStringBuilder.append(localam.adv());
            }
          }
          for (;;)
          {
            if (j < localaw.uho.size() - 1) {
              localStringBuilder.append("、");
            }
            j += 1;
            break label271;
            localc.uaR = com.tencent.mm.plugin.game.e.a.wk(((av)localObject).ufG);
            break;
            localc.uaR = com.tencent.mm.plugin.game.e.a.wk(((av)localObject).ufG);
            break;
            label402:
            localStringBuilder.append((String)localaw.uho.get(j));
          }
          label423:
          localStringBuilder.append(" ");
          localc.uaI.add(localStringBuilder.toString());
          for (;;)
          {
            localc.uaI.add(localaw.ugo);
            break;
            label462:
            localc.uaI.add("");
          }
          label476:
          localc.scene = 10;
          localc.dFG = 1004;
          localc.position = i;
          localLinkedList.add(localc);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(41552);
    return localLinkedList;
  }
  
  private void cZD()
  {
    AppMethodBeat.i(41553);
    this.udV = new HashMap();
    if ((this.udS.uit == null) || (this.udS.uit.uiZ == null))
    {
      AppMethodBeat.o(41553);
      return;
    }
    Iterator localIterator = this.udS.uit.uiZ.iterator();
    while (localIterator.hasNext())
    {
      cj localcj = (cj)localIterator.next();
      Object localObject = a(localcj.ueZ);
      if (localObject != null)
      {
        this.udV.put(((c)localObject).field_appId, Integer.valueOf(((c)localObject).versionCode));
        localObject = com.tencent.mm.plugin.s.a.dxQ().aLK(((c)localObject).field_appId);
        if (localObject != null)
        {
          ((com.tencent.mm.pluginsdk.model.app.g)localObject).sB(localcj.ujb);
          if (!com.tencent.mm.plugin.s.a.dxQ().a((com.tencent.mm.pluginsdk.model.app.g)localObject, new String[0])) {
            ad.e("MicroMsg.GamePBDataOverSea", "Store rank info failed, AppID: %s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appId });
          }
        }
      }
    }
    AppMethodBeat.o(41553);
  }
  
  public final ay cZE()
  {
    if (this.udS != null) {
      return this.udS.uiq;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.af
 * JD-Core Version:    0.7.0.1
 */