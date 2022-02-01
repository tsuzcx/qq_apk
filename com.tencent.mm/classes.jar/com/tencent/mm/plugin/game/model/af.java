package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.plugin.game.protobuf.bd;
import com.tencent.mm.plugin.game.protobuf.be;
import com.tencent.mm.plugin.game.protobuf.bg;
import com.tencent.mm.plugin.game.protobuf.cq;
import com.tencent.mm.plugin.game.protobuf.cr;
import com.tencent.mm.plugin.game.protobuf.cw;
import com.tencent.mm.plugin.game.protobuf.m;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class af
  extends x
{
  public com.tencent.mm.plugin.game.protobuf.bv CLw;
  private boolean CLx;
  public LinkedList<c> CLy;
  public HashMap<String, Integer> CLz;
  
  public af(com.tencent.mm.cd.a parama)
  {
    AppMethodBeat.i(41549);
    this.CLz = new HashMap();
    if (parama == null)
    {
      this.CLw = new com.tencent.mm.plugin.game.protobuf.bv();
      AppMethodBeat.o(41549);
      return;
    }
    this.CLw = ((com.tencent.mm.plugin.game.protobuf.bv)parama);
    this.CLx = true;
    ata();
    AppMethodBeat.o(41549);
  }
  
  public af(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41550);
    this.CLz = new HashMap();
    this.CLw = new com.tencent.mm.plugin.game.protobuf.bv();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41550);
      return;
    }
    try
    {
      this.CLw.parseFrom(paramArrayOfByte);
      this.CLx = false;
      ata();
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
  
  private void ata()
  {
    AppMethodBeat.i(41551);
    this.CLy = ezc();
    if (this.CLx)
    {
      d.bs(this.CLy);
      ezd();
      ((e)h.ae(e.class)).evm().init(MMApplicationContext.getContext());
    }
    AppMethodBeat.o(41551);
  }
  
  private LinkedList<c> ezc()
  {
    AppMethodBeat.i(41552);
    LinkedList localLinkedList = new LinkedList();
    if ((this.CLw.CQb == null) || (this.CLw.CQb.CNz == null))
    {
      AppMethodBeat.o(41552);
      return localLinkedList;
    }
    Iterator localIterator = this.CLw.CQb.CNz.iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      Object localObject = (bd)localIterator.next();
      if (((bd)localObject).CME != null)
      {
        c localc = a(((bd)localObject).CME);
        if (localc != null)
        {
          be localbe;
          StringBuilder localStringBuilder;
          int j;
          if (((bd)localObject).CME.CNa != null) {
            if ((((bd)localObject).CME.CNa.CMP != null) && (((bd)localObject).CME.CNa.CQM != null))
            {
              localc.CIi = ((bd)localObject).CME.CNa.CMP;
              localc.CIj = ((bd)localObject).CME.CNa.CQM;
              localc.CIm = com.tencent.mm.plugin.game.c.a.am(((bd)localObject).CNA, "label", localc.CIi);
              if (((bd)localObject).CPm == null) {
                break label476;
              }
              localObject = ((bd)localObject).CPm.iterator();
              do
              {
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                localbe = (be)((Iterator)localObject).next();
              } while (localbe == null);
              if ((localbe.CPn == null) || (localbe.CPn.size() == 0)) {
                break label462;
              }
              localStringBuilder = new StringBuilder();
              j = 0;
              label271:
              if (j >= localbe.CPn.size()) {
                break label423;
              }
              as localas = ((n)h.ae(n.class)).bbL().RG((String)localbe.CPn.get(j));
              if ((localas == null) || (localas.jxt == 0L)) {
                break label402;
              }
              localStringBuilder.append(localas.ays());
            }
          }
          for (;;)
          {
            if (j < localbe.CPn.size() - 1) {
              localStringBuilder.append("、");
            }
            j += 1;
            break label271;
            localc.CIm = com.tencent.mm.plugin.game.c.a.Md(((bd)localObject).CNA);
            break;
            localc.CIm = com.tencent.mm.plugin.game.c.a.Md(((bd)localObject).CNA);
            break;
            label402:
            localStringBuilder.append((String)localbe.CPn.get(j));
          }
          label423:
          localStringBuilder.append(" ");
          localc.CId.add(localStringBuilder.toString());
          for (;;)
          {
            localc.CId.add(localbe.COk);
            break;
            label462:
            localc.CId.add("");
          }
          label476:
          localc.scene = 10;
          localc.fSl = 1004;
          localc.position = i;
          localLinkedList.add(localc);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(41552);
    return localLinkedList;
  }
  
  private void ezd()
  {
    AppMethodBeat.i(41553);
    this.CLz = new HashMap();
    if ((this.CLw.CQc == null) || (this.CLw.CQc.CQH == null))
    {
      AppMethodBeat.o(41553);
      return;
    }
    Iterator localIterator = this.CLw.CQc.CQH.iterator();
    while (localIterator.hasNext())
    {
      cr localcr = (cr)localIterator.next();
      Object localObject = a(localcr.CME);
      if (localObject != null)
      {
        this.CLz.put(((c)localObject).field_appId, Integer.valueOf(((c)localObject).versionCode));
        localObject = com.tencent.mm.plugin.ab.a.fmz().bqc(((c)localObject).field_appId);
        if (localObject != null)
        {
          ((com.tencent.mm.pluginsdk.model.app.g)localObject).Ib(localcr.CQJ);
          if (!com.tencent.mm.plugin.ab.a.fmz().a((com.tencent.mm.pluginsdk.model.app.g)localObject, new String[0])) {
            Log.e("MicroMsg.GamePBDataOverSea", "Store rank info failed, AppID: %s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appId });
          }
        }
      }
    }
    AppMethodBeat.o(41553);
  }
  
  public final bg eze()
  {
    if (this.CLw != null) {
      return this.CLw.CPZ;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.af
 * JD-Core Version:    0.7.0.1
 */