package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.d.bb;
import com.tencent.mm.plugin.game.d.bc;
import com.tencent.mm.plugin.game.d.be;
import com.tencent.mm.plugin.game.d.bu;
import com.tencent.mm.plugin.game.d.cp;
import com.tencent.mm.plugin.game.d.cq;
import com.tencent.mm.plugin.game.d.cv;
import com.tencent.mm.plugin.game.d.m;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class af
  extends x
{
  public bu upa;
  private boolean upb;
  public LinkedList<c> upc;
  public HashMap<String, Integer> upd;
  
  public af(com.tencent.mm.bw.a parama)
  {
    AppMethodBeat.i(41549);
    this.upd = new HashMap();
    if (parama == null)
    {
      this.upa = new bu();
      AppMethodBeat.o(41549);
      return;
    }
    this.upa = ((bu)parama);
    this.upb = true;
    Zm();
    AppMethodBeat.o(41549);
  }
  
  public af(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41550);
    this.upd = new HashMap();
    this.upa = new bu();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41550);
      return;
    }
    try
    {
      this.upa.parseFrom(paramArrayOfByte);
      this.upb = false;
      Zm();
      AppMethodBeat.o(41550);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        ae.e("MicroMsg.GamePBDataOverSea", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private void Zm()
  {
    AppMethodBeat.i(41551);
    this.upc = dcn();
    if (this.upb)
    {
      d.aE(this.upc);
      dco();
      ((e)com.tencent.mm.kernel.g.ab(e.class)).cZj().init(ak.getContext());
    }
    AppMethodBeat.o(41551);
  }
  
  private LinkedList<c> dcn()
  {
    AppMethodBeat.i(41552);
    LinkedList localLinkedList = new LinkedList();
    if ((this.upa.utQ == null) || (this.upa.utQ.uqZ == null))
    {
      AppMethodBeat.o(41552);
      return localLinkedList;
    }
    Iterator localIterator = this.upa.utQ.uqZ.iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      Object localObject = (bb)localIterator.next();
      if (((bb)localObject).uqg != null)
      {
        c localc = a(((bb)localObject).uqg);
        if (localc != null)
        {
          bc localbc;
          StringBuilder localStringBuilder;
          int j;
          if (((bb)localObject).uqg.uqC != null) {
            if ((((bb)localObject).uqg.uqC.Name != null) && (((bb)localObject).uqg.uqC.uuC != null))
            {
              localc.ulP = ((bb)localObject).uqg.uqC.Name;
              localc.ulQ = ((bb)localObject).uqg.uqC.uuC;
              localc.ulT = com.tencent.mm.plugin.game.e.a.ak(((bb)localObject).ura, "label", localc.ulP);
              if (((bb)localObject).usL == null) {
                break label476;
              }
              localObject = ((bb)localObject).usL.iterator();
              do
              {
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                localbc = (bc)((Iterator)localObject).next();
              } while (localbc == null);
              if ((localbc.usM == null) || (localbc.usM.size() == 0)) {
                break label462;
              }
              localStringBuilder = new StringBuilder();
              j = 0;
              label271:
              if (j >= localbc.usM.size()) {
                break label423;
              }
              an localan = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH((String)localbc.usM.get(j));
              if ((localan == null) || (localan.ght == 0L)) {
                break label402;
              }
              localStringBuilder.append(localan.adG());
            }
          }
          for (;;)
          {
            if (j < localbc.usM.size() - 1) {
              localStringBuilder.append("、");
            }
            j += 1;
            break label271;
            localc.ulT = com.tencent.mm.plugin.game.e.a.wT(((bb)localObject).ura);
            break;
            localc.ulT = com.tencent.mm.plugin.game.e.a.wT(((bb)localObject).ura);
            break;
            label402:
            localStringBuilder.append((String)localbc.usM.get(j));
          }
          label423:
          localStringBuilder.append(" ");
          localc.ulK.add(localStringBuilder.toString());
          for (;;)
          {
            localc.ulK.add(localbc.urL);
            break;
            label462:
            localc.ulK.add("");
          }
          label476:
          localc.scene = 10;
          localc.dGL = 1004;
          localc.position = i;
          localLinkedList.add(localc);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(41552);
    return localLinkedList;
  }
  
  private void dco()
  {
    AppMethodBeat.i(41553);
    this.upd = new HashMap();
    if ((this.upa.utR == null) || (this.upa.utR.uuw == null))
    {
      AppMethodBeat.o(41553);
      return;
    }
    Iterator localIterator = this.upa.utR.uuw.iterator();
    while (localIterator.hasNext())
    {
      cq localcq = (cq)localIterator.next();
      Object localObject = a(localcq.uqg);
      if (localObject != null)
      {
        this.upd.put(((c)localObject).field_appId, Integer.valueOf(((c)localObject).versionCode));
        localObject = com.tencent.mm.plugin.s.a.dBg().aNg(((c)localObject).field_appId);
        if (localObject != null)
        {
          ((com.tencent.mm.pluginsdk.model.app.g)localObject).sW(localcq.uuy);
          if (!com.tencent.mm.plugin.s.a.dBg().a((com.tencent.mm.pluginsdk.model.app.g)localObject, new String[0])) {
            ae.e("MicroMsg.GamePBDataOverSea", "Store rank info failed, AppID: %s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appId });
          }
        }
      }
    }
    AppMethodBeat.o(41553);
  }
  
  public final be dcp()
  {
    if (this.upa != null) {
      return this.upa.utO;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.af
 * JD-Core Version:    0.7.0.1
 */