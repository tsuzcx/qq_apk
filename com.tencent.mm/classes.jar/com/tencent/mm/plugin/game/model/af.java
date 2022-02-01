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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bj;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class af
  extends x
{
  public bk tgc;
  private boolean tgd;
  public LinkedList<c> tge;
  public HashMap<String, Integer> tgf;
  
  public af(com.tencent.mm.bw.a parama)
  {
    AppMethodBeat.i(41549);
    this.tgf = new HashMap();
    if (parama == null)
    {
      this.tgc = new bk();
      AppMethodBeat.o(41549);
      return;
    }
    this.tgc = ((bk)parama);
    this.tgd = true;
    WJ();
    AppMethodBeat.o(41549);
  }
  
  public af(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41550);
    this.tgf = new HashMap();
    this.tgc = new bk();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41550);
      return;
    }
    try
    {
      this.tgc.parseFrom(paramArrayOfByte);
      this.tgd = false;
      WJ();
      AppMethodBeat.o(41550);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        ac.e("MicroMsg.GamePBDataOverSea", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private void WJ()
  {
    AppMethodBeat.i(41551);
    this.tge = cQW();
    if (this.tgd)
    {
      com.tencent.mm.plugin.game.f.d.aC(this.tge);
      cQX();
      ((com.tencent.mm.plugin.game.api.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.d.class)).cOk().init(com.tencent.mm.sdk.platformtools.ai.getContext());
    }
    AppMethodBeat.o(41551);
  }
  
  private LinkedList<c> cQW()
  {
    AppMethodBeat.i(41552);
    LinkedList localLinkedList = new LinkedList();
    if ((this.tgc.tko == null) || (this.tgc.tko.thO == null))
    {
      AppMethodBeat.o(41552);
      return localLinkedList;
    }
    Iterator localIterator = this.tgc.tko.thO.iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      Object localObject = (as)localIterator.next();
      if (((as)localObject).thi != null)
      {
        c localc = a(((as)localObject).thi);
        if (localc != null)
        {
          at localat;
          StringBuilder localStringBuilder;
          int j;
          if (((as)localObject).thi.thB != null) {
            if ((((as)localObject).thi.thB.Name != null) && (((as)localObject).thi.thB.tkV != null))
            {
              localc.tcX = ((as)localObject).thi.thB.Name;
              localc.tcY = ((as)localObject).thi.thB.tkV;
              localc.tdb = com.tencent.mm.plugin.game.e.a.ae(((as)localObject).thP, "label", localc.tcX);
              if (((as)localObject).tjn == null) {
                break label476;
              }
              localObject = ((as)localObject).tjn.iterator();
              do
              {
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                localat = (at)((Iterator)localObject).next();
              } while (localat == null);
              if ((localat.tjo == null) || (localat.tjo.size() == 0)) {
                break label462;
              }
              localStringBuilder = new StringBuilder();
              j = 0;
              label271:
              if (j >= localat.tjo.size()) {
                break label423;
              }
              com.tencent.mm.storage.ai localai = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt((String)localat.tjo.get(j));
              if ((localai == null) || (localai.fLJ == 0L)) {
                break label402;
              }
              localStringBuilder.append(localai.aaS());
            }
          }
          for (;;)
          {
            if (j < localat.tjo.size() - 1) {
              localStringBuilder.append("、");
            }
            j += 1;
            break label271;
            localc.tdb = com.tencent.mm.plugin.game.e.a.tu(((as)localObject).thP);
            break;
            localc.tdb = com.tencent.mm.plugin.game.e.a.tu(((as)localObject).thP);
            break;
            label402:
            localStringBuilder.append((String)localat.tjo.get(j));
          }
          label423:
          localStringBuilder.append(" ");
          localc.tcS.add(localStringBuilder.toString());
          for (;;)
          {
            localc.tcS.add(localat.tiv);
            break;
            label462:
            localc.tcS.add("");
          }
          label476:
          localc.scene = 10;
          localc.dtF = 1004;
          localc.position = i;
          localLinkedList.add(localc);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(41552);
    return localLinkedList;
  }
  
  private void cQX()
  {
    AppMethodBeat.i(41553);
    this.tgf = new HashMap();
    if ((this.tgc.tkp == null) || (this.tgc.tkp.tkS == null))
    {
      AppMethodBeat.o(41553);
      return;
    }
    Iterator localIterator = this.tgc.tkp.tkS.iterator();
    while (localIterator.hasNext())
    {
      cd localcd = (cd)localIterator.next();
      Object localObject = a(localcd.thi);
      if (localObject != null)
      {
        this.tgf.put(((c)localObject).field_appId, Integer.valueOf(((c)localObject).versionCode));
        localObject = com.tencent.mm.plugin.s.a.dny().aGk(((c)localObject).field_appId);
        if (localObject != null)
        {
          ((com.tencent.mm.pluginsdk.model.app.g)localObject).pR(localcd.tkU);
          if (!com.tencent.mm.plugin.s.a.dny().a((com.tencent.mm.pluginsdk.model.app.g)localObject, new String[0])) {
            ac.e("MicroMsg.GamePBDataOverSea", "Store rank info failed, AppID: %s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appId });
          }
        }
      }
    }
    AppMethodBeat.o(41553);
  }
  
  public final av cQY()
  {
    if (this.tgc != null) {
      return this.tgc.tkm;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.af
 * JD-Core Version:    0.7.0.1
 */