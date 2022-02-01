package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.e.d;
import com.tencent.mm.plugin.game.protobuf.bc;
import com.tencent.mm.plugin.game.protobuf.bd;
import com.tencent.mm.plugin.game.protobuf.bf;
import com.tencent.mm.plugin.game.protobuf.bu;
import com.tencent.mm.plugin.game.protobuf.cp;
import com.tencent.mm.plugin.game.protobuf.cq;
import com.tencent.mm.plugin.game.protobuf.cv;
import com.tencent.mm.plugin.game.protobuf.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class af
  extends x
{
  public bu xHt;
  private boolean xHu;
  public LinkedList<c> xHv;
  public HashMap<String, Integer> xHw;
  
  public af(com.tencent.mm.bw.a parama)
  {
    AppMethodBeat.i(41549);
    this.xHw = new HashMap();
    if (parama == null)
    {
      this.xHt = new bu();
      AppMethodBeat.o(41549);
      return;
    }
    this.xHt = ((bu)parama);
    this.xHu = true;
    amZ();
    AppMethodBeat.o(41549);
  }
  
  public af(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41550);
    this.xHw = new HashMap();
    this.xHt = new bu();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41550);
      return;
    }
    try
    {
      this.xHt.parseFrom(paramArrayOfByte);
      this.xHu = false;
      amZ();
      AppMethodBeat.o(41550);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        Log.e("MicroMsg.GamePBDataOverSea", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private void amZ()
  {
    AppMethodBeat.i(41551);
    this.xHv = dVU();
    if (this.xHu)
    {
      d.aZ(this.xHv);
      dVV();
      ((e)com.tencent.mm.kernel.g.af(e.class)).dSI().init(MMApplicationContext.getContext());
    }
    AppMethodBeat.o(41551);
  }
  
  private LinkedList<c> dVU()
  {
    AppMethodBeat.i(41552);
    LinkedList localLinkedList = new LinkedList();
    if ((this.xHt.xLS == null) || (this.xHt.xLS.xJs == null))
    {
      AppMethodBeat.o(41552);
      return localLinkedList;
    }
    Iterator localIterator = this.xHt.xLS.xJs.iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      Object localObject = (bc)localIterator.next();
      if (((bc)localObject).xIz != null)
      {
        c localc = a(((bc)localObject).xIz);
        if (localc != null)
        {
          bd localbd;
          StringBuilder localStringBuilder;
          int j;
          if (((bc)localObject).xIz.xIU != null) {
            if ((((bc)localObject).xIz.xIU.Name != null) && (((bc)localObject).xIz.xIU.xMD != null))
            {
              localc.xEh = ((bc)localObject).xIz.xIU.Name;
              localc.xEi = ((bc)localObject).xIz.xIU.xMD;
              localc.xEl = com.tencent.mm.plugin.game.d.a.as(((bc)localObject).xJt, "label", localc.xEh);
              if (((bc)localObject).xLe == null) {
                break label476;
              }
              localObject = ((bc)localObject).xLe.iterator();
              do
              {
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                localbd = (bd)((Iterator)localObject).next();
              } while (localbd == null);
              if ((localbd.xLf == null) || (localbd.xLf.size() == 0)) {
                break label462;
              }
              localStringBuilder = new StringBuilder();
              j = 0;
              label271:
              if (j >= localbd.xLf.size()) {
                break label423;
              }
              as localas = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn((String)localbd.xLf.get(j));
              if ((localas == null) || (localas.gMZ == 0L)) {
                break label402;
              }
              localStringBuilder.append(localas.arJ());
            }
          }
          for (;;)
          {
            if (j < localbd.xLf.size() - 1) {
              localStringBuilder.append("、");
            }
            j += 1;
            break label271;
            localc.xEl = com.tencent.mm.plugin.game.d.a.Fh(((bc)localObject).xJt);
            break;
            localc.xEl = com.tencent.mm.plugin.game.d.a.Fh(((bc)localObject).xJt);
            break;
            label402:
            localStringBuilder.append((String)localbd.xLf.get(j));
          }
          label423:
          localStringBuilder.append(" ");
          localc.xEc.add(localStringBuilder.toString());
          for (;;)
          {
            localc.xEc.add(localbd.xKd);
            break;
            label462:
            localc.xEc.add("");
          }
          label476:
          localc.scene = 10;
          localc.dYu = 1004;
          localc.position = i;
          localLinkedList.add(localc);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(41552);
    return localLinkedList;
  }
  
  private void dVV()
  {
    AppMethodBeat.i(41553);
    this.xHw = new HashMap();
    if ((this.xHt.xLT == null) || (this.xHt.xLT.xMy == null))
    {
      AppMethodBeat.o(41553);
      return;
    }
    Iterator localIterator = this.xHt.xLT.xMy.iterator();
    while (localIterator.hasNext())
    {
      cq localcq = (cq)localIterator.next();
      Object localObject = a(localcq.xIz);
      if (localObject != null)
      {
        this.xHw.put(((c)localObject).field_appId, Integer.valueOf(((c)localObject).versionCode));
        localObject = com.tencent.mm.plugin.r.a.eAS().bdG(((c)localObject).field_appId);
        if (localObject != null)
        {
          ((com.tencent.mm.pluginsdk.model.app.g)localObject).Bn(localcq.xMA);
          if (!com.tencent.mm.plugin.r.a.eAS().a((com.tencent.mm.pluginsdk.model.app.g)localObject, new String[0])) {
            Log.e("MicroMsg.GamePBDataOverSea", "Store rank info failed, AppID: %s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appId });
          }
        }
      }
    }
    AppMethodBeat.o(41553);
  }
  
  public final bf dVW()
  {
    if (this.xHt != null) {
      return this.xHt.xLQ;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.af
 * JD-Core Version:    0.7.0.1
 */