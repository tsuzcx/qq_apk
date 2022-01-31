package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.aq;
import com.tencent.mm.plugin.game.d.ar;
import com.tencent.mm.plugin.game.d.at;
import com.tencent.mm.plugin.game.d.bk;
import com.tencent.mm.plugin.game.d.cc;
import com.tencent.mm.plugin.game.d.cd;
import com.tencent.mm.plugin.game.d.cg;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class af
  extends x
{
  public bk noP;
  private boolean noQ;
  public LinkedList<c> noR;
  public HashMap<String, Integer> noS;
  
  public af(com.tencent.mm.bv.a parama)
  {
    AppMethodBeat.i(111384);
    this.noS = new HashMap();
    if (parama == null)
    {
      this.noP = new bk();
      AppMethodBeat.o(111384);
      return;
    }
    this.noP = ((bk)parama);
    this.noQ = true;
    Kc();
    AppMethodBeat.o(111384);
  }
  
  public af(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(111385);
    this.noS = new HashMap();
    this.noP = new bk();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(111385);
      return;
    }
    try
    {
      this.noP.parseFrom(paramArrayOfByte);
      this.noQ = false;
      Kc();
      AppMethodBeat.o(111385);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        ab.e("MicroMsg.GamePBDataOverSea", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private void Kc()
  {
    AppMethodBeat.i(111386);
    this.noR = bGR();
    if (this.noQ)
    {
      com.tencent.mm.plugin.game.f.d.ag(this.noR);
      bGS();
      ((com.tencent.mm.plugin.game.api.d)g.E(com.tencent.mm.plugin.game.api.d.class)).bEP().init(ah.getContext());
    }
    AppMethodBeat.o(111386);
  }
  
  private LinkedList<c> bGR()
  {
    AppMethodBeat.i(111387);
    LinkedList localLinkedList = new LinkedList();
    if ((this.noP.nsS == null) || (this.noP.nsS.nqs == null))
    {
      AppMethodBeat.o(111387);
      return localLinkedList;
    }
    Iterator localIterator = this.noP.nsS.nqs.iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      Object localObject = (aq)localIterator.next();
      if (((aq)localObject).npS != null)
      {
        c localc = a(((aq)localObject).npS);
        if (localc != null)
        {
          ar localar;
          StringBuilder localStringBuilder;
          int j;
          if (((aq)localObject).npS.nqm != null) {
            if ((((aq)localObject).npS.nqm.Name != null) && (((aq)localObject).npS.nqm.ntA != null))
            {
              localc.nmh = ((aq)localObject).npS.nqm.Name;
              localc.nmi = ((aq)localObject).npS.nqm.ntA;
              localc.nml = com.tencent.mm.plugin.game.e.a.V(((aq)localObject).nqt, "label", localc.nmh);
              if (((aq)localObject).nrO == null) {
                break label476;
              }
              localObject = ((aq)localObject).nrO.iterator();
              do
              {
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                localar = (ar)((Iterator)localObject).next();
              } while (localar == null);
              if ((localar.nrP == null) || (localar.nrP.size() == 0)) {
                break label462;
              }
              localStringBuilder = new StringBuilder();
              j = 0;
              label271:
              if (j >= localar.nrP.size()) {
                break label423;
              }
              ad localad = ((j)g.E(j.class)).YA().arw((String)localar.nrP.get(j));
              if ((localad == null) || (localad.euF == 0L)) {
                break label402;
              }
              localStringBuilder.append(localad.Of());
            }
          }
          for (;;)
          {
            if (j < localar.nrP.size() - 1) {
              localStringBuilder.append("、");
            }
            j += 1;
            break label271;
            localc.nml = com.tencent.mm.plugin.game.e.a.lR(((aq)localObject).nqt);
            break;
            localc.nml = com.tencent.mm.plugin.game.e.a.lR(((aq)localObject).nqt);
            break;
            label402:
            localStringBuilder.append((String)localar.nrP.get(j));
          }
          label423:
          localStringBuilder.append(" ");
          localc.nmc.add(localStringBuilder.toString());
          for (;;)
          {
            localc.nmc.add(localar.nqY);
            break;
            label462:
            localc.nmc.add("");
          }
          label476:
          localc.scene = 10;
          localc.cFj = 1004;
          localc.position = i;
          localLinkedList.add(localc);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(111387);
    return localLinkedList;
  }
  
  private void bGS()
  {
    AppMethodBeat.i(111388);
    this.noS = new HashMap();
    if ((this.noP.nsT == null) || (this.noP.nsT.ntx == null))
    {
      AppMethodBeat.o(111388);
      return;
    }
    Iterator localIterator = this.noP.nsT.ntx.iterator();
    while (localIterator.hasNext())
    {
      cd localcd = (cd)localIterator.next();
      Object localObject = a(localcd.npS);
      if (localObject != null)
      {
        this.noS.put(((c)localObject).field_appId, Integer.valueOf(((c)localObject).versionCode));
        localObject = com.tencent.mm.plugin.s.a.cac().als(((c)localObject).field_appId);
        if (localObject != null)
        {
          ((f)localObject).iX(localcd.ntz);
          if (!com.tencent.mm.plugin.s.a.cac().a((f)localObject, new String[0])) {
            ab.e("MicroMsg.GamePBDataOverSea", "Store rank info failed, AppID: %s", new Object[] { ((f)localObject).field_appId });
          }
        }
      }
    }
    AppMethodBeat.o(111388);
  }
  
  public final at bGT()
  {
    if (this.noP != null) {
      return this.noP.nsQ;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.af
 * JD-Core Version:    0.7.0.1
 */