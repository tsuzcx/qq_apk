package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.plugin.game.protobuf.be;
import com.tencent.mm.plugin.game.protobuf.bf;
import com.tencent.mm.plugin.game.protobuf.bh;
import com.tencent.mm.plugin.game.protobuf.bw;
import com.tencent.mm.plugin.game.protobuf.cs;
import com.tencent.mm.plugin.game.protobuf.ct;
import com.tencent.mm.plugin.game.protobuf.cz;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class af
  extends x
{
  public bw IFD;
  private boolean IFE;
  public LinkedList<c> IFF;
  public HashMap<String, Integer> IFG;
  
  public af(com.tencent.mm.bx.a parama)
  {
    AppMethodBeat.i(41549);
    this.IFG = new HashMap();
    if (parama == null)
    {
      this.IFD = new bw();
      AppMethodBeat.o(41549);
      return;
    }
    this.IFD = ((bw)parama);
    this.IFE = true;
    aNi();
    AppMethodBeat.o(41549);
  }
  
  public af(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41550);
    this.IFG = new HashMap();
    this.IFD = new bw();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(41550);
      return;
    }
    try
    {
      this.IFD.parseFrom(paramArrayOfByte);
      this.IFE = false;
      aNi();
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
  
  private void aNi()
  {
    AppMethodBeat.i(41551);
    this.IFF = fGY();
    if (this.IFE)
    {
      d.bz(this.IFF);
      fGZ();
      ((e)h.ax(e.class)).fCf().init(MMApplicationContext.getContext());
    }
    AppMethodBeat.o(41551);
  }
  
  private LinkedList<c> fGY()
  {
    AppMethodBeat.i(41552);
    LinkedList localLinkedList = new LinkedList();
    if ((this.IFD.IKl == null) || (this.IFD.IKl.IHH == null))
    {
      AppMethodBeat.o(41552);
      return localLinkedList;
    }
    Iterator localIterator = this.IFD.IKl.IHH.iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      Object localObject = (be)localIterator.next();
      if (((be)localObject).IGJ != null)
      {
        c localc = a(((be)localObject).IGJ);
        if (localc != null)
        {
          bf localbf;
          StringBuilder localStringBuilder;
          int j;
          if (((be)localObject).IGJ.IHf != null) {
            if ((((be)localObject).IGJ.IHf.IGU != null) && (((be)localObject).IGJ.IHf.ILa != null))
            {
              localc.ICs = ((be)localObject).IGJ.IHf.IGU;
              localc.ICt = ((be)localObject).IGJ.IHf.ILa;
              localc.ICw = com.tencent.mm.plugin.game.c.a.aw(((be)localObject).IHI, "label", localc.ICs);
              if (((be)localObject).IJw == null) {
                break label476;
              }
              localObject = ((be)localObject).IJw.iterator();
              do
              {
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                localbf = (bf)((Iterator)localObject).next();
              } while (localbf == null);
              if ((localbf.IJx == null) || (localbf.IJx.size() == 0)) {
                break label462;
              }
              localStringBuilder = new StringBuilder();
              j = 0;
              label271:
              if (j >= localbf.IJx.size()) {
                break label423;
              }
              au localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE((String)localbf.IJx.get(j));
              if ((localau == null) || (localau.maN == 0L)) {
                break label402;
              }
              localStringBuilder.append(localau.aSV());
            }
          }
          for (;;)
          {
            if (j < localbf.IJx.size() - 1) {
              localStringBuilder.append("、");
            }
            j += 1;
            break label271;
            localc.ICw = com.tencent.mm.plugin.game.c.a.EM(((be)localObject).IHI);
            break;
            localc.ICw = com.tencent.mm.plugin.game.c.a.EM(((be)localObject).IHI);
            break;
            label402:
            localStringBuilder.append((String)localbf.IJx.get(j));
          }
          label423:
          localStringBuilder.append(" ");
          localc.ICn.add(localStringBuilder.toString());
          for (;;)
          {
            localc.ICn.add(localbf.IIu);
            break;
            label462:
            localc.ICn.add("");
          }
          label476:
          localc.scene = 10;
          localc.hYi = 1004;
          localc.position = i;
          localLinkedList.add(localc);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(41552);
    return localLinkedList;
  }
  
  private void fGZ()
  {
    AppMethodBeat.i(41553);
    this.IFG = new HashMap();
    if ((this.IFD.IKm == null) || (this.IFD.IKm.IKT == null))
    {
      AppMethodBeat.o(41553);
      return;
    }
    Iterator localIterator = this.IFD.IKm.IKT.iterator();
    while (localIterator.hasNext())
    {
      ct localct = (ct)localIterator.next();
      Object localObject = a(localct.IGJ);
      if (localObject != null)
      {
        this.IFG.put(((c)localObject).field_appId, Integer.valueOf(((c)localObject).versionCode));
        localObject = com.tencent.mm.plugin.openapi.a.gxn().bpR(((c)localObject).field_appId);
        if (localObject != null)
        {
          ((com.tencent.mm.pluginsdk.model.app.g)localObject).AG(localct.IKV);
          if (!com.tencent.mm.plugin.openapi.a.gxn().a((com.tencent.mm.pluginsdk.model.app.g)localObject, new String[0])) {
            Log.e("MicroMsg.GamePBDataOverSea", "Store rank info failed, AppID: %s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appId });
          }
        }
      }
    }
    AppMethodBeat.o(41553);
  }
  
  public final bh fHa()
  {
    if (this.IFD != null) {
      return this.IFD.IKj;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.af
 * JD-Core Version:    0.7.0.1
 */