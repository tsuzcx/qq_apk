package com.tencent.mm.plugin.game.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.d.ap;
import com.tencent.mm.plugin.game.d.aq;
import com.tencent.mm.plugin.game.d.as;
import com.tencent.mm.plugin.game.d.bj;
import com.tencent.mm.plugin.game.d.cb;
import com.tencent.mm.plugin.game.d.cc;
import com.tencent.mm.plugin.game.d.cf;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class ag
  extends y
{
  public bj kQL;
  private boolean kQM;
  public LinkedList<d> kQN;
  public HashMap<String, Integer> kQO = new HashMap();
  
  public ag(com.tencent.mm.bv.a parama)
  {
    if (parama == null)
    {
      this.kQL = new bj();
      return;
    }
    this.kQL = ((bj)parama);
    this.kQM = true;
    xK();
  }
  
  public ag(byte[] paramArrayOfByte)
  {
    this.kQL = new bj();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return;
    }
    try
    {
      this.kQL.aH(paramArrayOfByte);
      this.kQM = false;
      xK();
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.GamePBDataOverSea", "Parsing Failed: %s", new Object[] { paramArrayOfByte.getMessage() });
      }
    }
  }
  
  private void aZN()
  {
    this.kQO = new HashMap();
    if ((this.kQL.kUR == null) || (this.kQL.kUR.kVv == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.kQL.kUR.kVv.iterator();
      while (localIterator.hasNext())
      {
        cc localcc = (cc)localIterator.next();
        Object localObject = a(localcc.kRQ);
        if (localObject != null)
        {
          this.kQO.put(((d)localObject).field_appId, Integer.valueOf(((d)localObject).versionCode));
          localObject = com.tencent.mm.plugin.z.a.brn().VU(((d)localObject).field_appId);
          if (localObject != null)
          {
            ((f)localObject).cP(localcc.kVx);
            if (!com.tencent.mm.plugin.z.a.brn().a((f)localObject, new String[0])) {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.GamePBDataOverSea", "Store rank info failed, AppID: %s", new Object[] { ((f)localObject).field_appId });
            }
          }
        }
      }
    }
  }
  
  private void xK()
  {
    LinkedList localLinkedList = new LinkedList();
    if ((this.kQL.kUQ == null) || (this.kQL.kUQ.kSr == null)) {}
    for (;;)
    {
      this.kQN = localLinkedList;
      if (this.kQM)
      {
        com.tencent.mm.plugin.game.f.d.Y(this.kQN);
        aZN();
        ((b)g.r(b.class)).aYc().init(ae.getContext());
      }
      return;
      Iterator localIterator = this.kQL.kUQ.kSr.iterator();
      int i = 1;
      while (localIterator.hasNext())
      {
        Object localObject = (ap)localIterator.next();
        if (((ap)localObject).kRQ != null)
        {
          d locald = a(((ap)localObject).kRQ);
          if (locald != null)
          {
            aq localaq;
            StringBuilder localStringBuilder;
            int j;
            if (((ap)localObject).kRQ.kSl != null) {
              if ((((ap)localObject).kRQ.kSl.kRZ != null) && (((ap)localObject).kRQ.kSl.kVz != null))
              {
                locald.kOk = ((ap)localObject).kRQ.kSl.kRZ;
                locald.kOl = ((ap)localObject).kRQ.kSl.kVz;
                locald.kOo = com.tencent.mm.plugin.game.e.a.O(((ap)localObject).kSs, "label", locald.kOk);
                if (((ap)localObject).kTO == null) {
                  break label510;
                }
                localObject = ((ap)localObject).kTO.iterator();
                do
                {
                  if (!((Iterator)localObject).hasNext()) {
                    break;
                  }
                  localaq = (aq)((Iterator)localObject).next();
                } while (localaq == null);
                if ((localaq.kTP == null) || (localaq.kTP.size() == 0)) {
                  break label495;
                }
                localStringBuilder = new StringBuilder();
                j = 0;
                label302:
                if (j >= localaq.kTP.size()) {
                  break label455;
                }
                ad localad = ((j)g.r(j.class)).Fw().abl((String)localaq.kTP.get(j));
                if ((localad == null) || (localad.dBe == 0L)) {
                  break label434;
                }
                localStringBuilder.append(localad.Bq());
              }
            }
            for (;;)
            {
              if (j < localaq.kTP.size() - 1) {
                localStringBuilder.append("、");
              }
              j += 1;
              break label302;
              locald.kOo = com.tencent.mm.plugin.game.e.a.fy(((ap)localObject).kSs);
              break;
              locald.kOo = com.tencent.mm.plugin.game.e.a.fy(((ap)localObject).kSs);
              break;
              label434:
              localStringBuilder.append((String)localaq.kTP.get(j));
            }
            label455:
            localStringBuilder.append(" ");
            locald.kOf.add(localStringBuilder.toString());
            for (;;)
            {
              locald.kOf.add(localaq.kSY);
              break;
              label495:
              locald.kOf.add("");
            }
            label510:
            locald.scene = 10;
            locald.bXn = 1004;
            locald.position = i;
            localLinkedList.add(locald);
            i += 1;
          }
        }
      }
    }
  }
  
  public final as aZO()
  {
    if (this.kQL != null) {
      return this.kQL.kUO;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ag
 * JD-Core Version:    0.7.0.1
 */