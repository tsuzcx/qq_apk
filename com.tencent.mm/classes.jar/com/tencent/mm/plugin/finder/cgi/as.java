package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.amq;
import com.tencent.mm.protocal.protobuf.amy;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.aos;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderInit;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderInitResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "handleFinderCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class as
  extends n
  implements k
{
  private final String TAG;
  private f callback;
  private com.tencent.mm.al.b rJA;
  public aos rJB;
  
  public as()
  {
    AppMethodBeat.i(165243);
    this.TAG = "Finder.NetSceneFinderInit";
    ad.i(this.TAG, "NetSceneFinderInit");
    Object localObject1 = new b.a();
    aor localaor = new aor();
    Object localObject2 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject2, "MMKernel.storage()");
    localObject2 = ((com.tencent.mm.kernel.e)localObject2).ajl().get(al.a.IGZ, "");
    if (localObject2 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(165243);
      throw ((Throwable)localObject1);
    }
    localaor.FRr = z.al(bt.aRa((String)localObject2));
    localObject2 = v.rIR;
    localaor.Glv = v.cxY();
    ((b.a)localObject1).oP(getType());
    ((b.a)localObject1).Dl("/cgi-bin/micromsg-bin/finderinit");
    ((b.a)localObject1).c((a)localaor);
    ((b.a)localObject1).d((a)new aos());
    this.rJA = ((b.a)localObject1).aDC();
    com.tencent.mm.plugin.report.service.g.yhR.n(1279L, 23L, 1L);
    AppMethodBeat.o(165243);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(165241);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rJA, (k)this);
    AppMethodBeat.o(165241);
    return i;
  }
  
  public final int getType()
  {
    return 3930;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165242);
    ad.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Object localObject1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rJA;
      if (paramq != null)
      {
        paramq = paramq.aEF();
        paramArrayOfByte = paramq;
        if (!(paramq instanceof aos)) {
          paramArrayOfByte = null;
        }
        this.rJB = ((aos)paramArrayOfByte);
        localObject1 = this.rJB;
        if (localObject1 == null) {
          break label1599;
        }
        paramq = this.rJB;
        if (paramq == null) {
          break label335;
        }
        paramq = paramq.Gnl;
        label126:
        if (paramq == null) {
          break label1334;
        }
        if (((Collection)paramq).isEmpty()) {
          break label341;
        }
        paramInt1 = 1;
        label146:
        if (paramInt1 == 0) {
          break label346;
        }
        paramArrayOfByte = paramq;
      }
      for (;;)
      {
        if ((paramArrayOfByte != null) && (!bt.isNullOrNil(((FinderContact)paramq.get(0)).username)))
        {
          paramArrayOfByte = com.tencent.mm.kernel.g.ajC();
          p.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.ajl().set(al.a.IGw, ((FinderContact)paramq.get(0)).username);
          paramArrayOfByte = c.rHn;
          paramArrayOfByte = paramq.get(0);
          p.g(paramArrayOfByte, "self[0]");
          c.a.a((FinderContact)paramArrayOfByte);
          paramArrayOfByte = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension();
          Object localObject2 = this.rJB;
          if (localObject2 == null) {
            p.gfZ();
          }
          paramArrayOfByte.fI(((aos)localObject2).continueFlag, 5);
          paramArrayOfByte = this.rJA;
          if (paramArrayOfByte == null) {
            p.gfZ();
          }
          paramArrayOfByte = paramArrayOfByte.aEF();
          if (paramArrayOfByte == null)
          {
            paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderInitResponse");
            AppMethodBeat.o(165242);
            throw paramString;
            paramq = null;
            break;
            label335:
            paramq = null;
            break label126;
            label341:
            paramInt1 = 0;
            break label146;
            label346:
            paramArrayOfByte = null;
            continue;
          }
          paramArrayOfByte = ((aos)paramArrayOfByte).rbl;
          if (paramArrayOfByte != null)
          {
            localObject2 = ((Iterable)paramArrayOfByte).iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = (alo)((Iterator)localObject2).next();
                p.g(localObject3, "it");
                Object localObject4;
                Object localObject5;
                switch (((alo)localObject3).cmdId)
                {
                default: 
                  break;
                case 105: 
                  paramArrayOfByte = (a)new amy();
                  localObject3 = ((alo)localObject3).Glr.toByteArray();
                  try
                  {
                    paramArrayOfByte.parseFrom((byte[])localObject3);
                    localObject3 = (amy)paramArrayOfByte;
                    paramArrayOfByte = c.rHn;
                    paramArrayOfByte = u.aAu();
                    p.g(paramArrayOfByte, "ConfigStorageLogic.getMyFinderUsername()");
                    if (c.a.agW(paramArrayOfByte) != null)
                    {
                      localObject4 = this.TAG;
                      localObject5 = new StringBuilder("save follow count ");
                      if (localObject3 != null)
                      {
                        paramArrayOfByte = Integer.valueOf(((amy)localObject3).GlM);
                        ad.i((String)localObject4, paramArrayOfByte);
                        paramArrayOfByte = com.tencent.mm.kernel.g.ajC();
                        p.g(paramArrayOfByte, "MMKernel.storage()");
                        localObject4 = paramArrayOfByte.ajl();
                        localObject5 = al.a.IHU;
                        if (localObject3 == null) {
                          break label632;
                        }
                        paramArrayOfByte = Integer.valueOf(((amy)localObject3).GlM);
                        ((ai)localObject4).set((al.a)localObject5, paramArrayOfByte);
                      }
                    }
                  }
                  catch (Exception paramArrayOfByte)
                  {
                    for (;;)
                    {
                      ad.l("safeParser", "", new Object[] { paramArrayOfByte });
                      paramArrayOfByte = null;
                      continue;
                      paramArrayOfByte = null;
                      continue;
                      paramArrayOfByte = null;
                    }
                  }
                case 106: 
                  label632:
                  paramArrayOfByte = (a)new amq();
                  localObject3 = ((alo)localObject3).Glr.toByteArray();
                  try
                  {
                    paramArrayOfByte.parseFrom((byte[])localObject3);
                    localObject3 = (amq)paramArrayOfByte;
                    paramArrayOfByte = c.rHn;
                    paramArrayOfByte = u.aAu();
                    p.g(paramArrayOfByte, "ConfigStorageLogic.getMyFinderUsername()");
                    if (c.a.agW(paramArrayOfByte) != null)
                    {
                      localObject4 = this.TAG;
                      localObject5 = new StringBuilder("save fans count ");
                      if (localObject3 != null)
                      {
                        paramArrayOfByte = Integer.valueOf(((amq)localObject3).GlN);
                        ad.i((String)localObject4, paramArrayOfByte);
                        paramArrayOfByte = com.tencent.mm.kernel.g.ajC();
                        p.g(paramArrayOfByte, "MMKernel.storage()");
                        localObject4 = paramArrayOfByte.ajl();
                        localObject5 = al.a.IHV;
                        if (localObject3 == null) {
                          break label831;
                        }
                        paramArrayOfByte = Integer.valueOf(((amq)localObject3).GlN);
                        ((ai)localObject4).set((al.a)localObject5, paramArrayOfByte);
                      }
                    }
                  }
                  catch (Exception paramArrayOfByte)
                  {
                    for (;;)
                    {
                      ad.l("safeParser", "", new Object[] { paramArrayOfByte });
                      paramArrayOfByte = null;
                      continue;
                      paramArrayOfByte = null;
                      continue;
                      label831:
                      paramArrayOfByte = null;
                    }
                  }
                }
              }
            }
          }
          paramArrayOfByte = com.tencent.mm.kernel.g.ajC();
          p.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte = paramArrayOfByte.ajl();
          localObject2 = al.a.IGZ;
          Object localObject3 = this.rJB;
          if (localObject3 == null) {
            p.gfZ();
          }
          paramArrayOfByte.set((al.a)localObject2, bt.cE(z.a(((aos)localObject3).FRr)));
          paramArrayOfByte = com.tencent.mm.kernel.g.ajC();
          p.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.ajl().set(al.a.IGx, ((FinderContact)paramq.get(0)).nickname);
          paramArrayOfByte = com.tencent.mm.kernel.g.ajC();
          p.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.ajl().set(al.a.IGy, ((FinderContact)paramq.get(0)).signature);
          paramArrayOfByte = com.tencent.mm.kernel.g.ajC();
          p.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.ajl().set(al.a.IGz, ((FinderContact)paramq.get(0)).headUrl);
          paramArrayOfByte = com.tencent.mm.kernel.g.ajC();
          p.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.ajl().set(al.a.IGW, Integer.valueOf(((FinderContact)paramq.get(0)).extFlag));
          paramArrayOfByte = com.tencent.mm.kernel.g.ajC();
          p.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.ajl().set(al.a.IGE, Integer.valueOf(((FinderContact)paramq.get(0)).originalFlag));
          if (((FinderContact)paramq.get(0)).originalInfo != null)
          {
            paramArrayOfByte = com.tencent.mm.kernel.g.ajC();
            p.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.ajl().set(al.a.IGF, Integer.valueOf(((FinderContact)paramq.get(0)).originalInfo.Gok));
            paramArrayOfByte = com.tencent.mm.kernel.g.ajC();
            p.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.ajl().set(al.a.IGG, Integer.valueOf(((FinderContact)paramq.get(0)).originalInfo.Gol));
            paramArrayOfByte = com.tencent.mm.kernel.g.ajC();
            p.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.ajl().set(al.a.IGH, Integer.valueOf(((FinderContact)paramq.get(0)).originalInfo.Gom));
            paramArrayOfByte = com.tencent.mm.kernel.g.ajC();
            p.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.ajl().set(al.a.IGI, Integer.valueOf(((FinderContact)paramq.get(0)).originalInfo.Gon));
            paramArrayOfByte = com.tencent.mm.kernel.g.ajC();
            p.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.ajl().set(al.a.IGL, Integer.valueOf(((FinderContact)paramq.get(0)).originalInfo.Goo));
          }
          if (((FinderContact)paramq.get(0)).authInfo != null) {
            break label1462;
          }
          paramq = com.tencent.mm.kernel.g.ajC();
          p.g(paramq, "MMKernel.storage()");
          paramq.ajl().set(al.a.IGA, "");
        }
      }
      label1334:
      paramq = ((aos)localObject1).Gnm;
      p.g(paramq, "it.tabInfos");
      paramq = ((Iterable)paramq).iterator();
    }
    else
    {
      for (;;)
      {
        if (paramq.hasNext())
        {
          paramArrayOfByte = (arx)paramq.next();
          ad.i(this.TAG, paramArrayOfByte.Glz + " => " + paramArrayOfByte.Gqj);
          if (paramArrayOfByte.Glz == 4)
          {
            localObject1 = com.tencent.mm.kernel.g.ajC();
            p.g(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IHk, paramArrayOfByte.Gqj);
            continue;
            label1462:
            paramArrayOfByte = com.tencent.mm.kernel.g.ajC();
            p.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.ajl().set(al.a.IGA, bt.cE(((FinderContact)paramq.get(0)).authInfo.toByteArray()));
            break;
          }
          if (paramArrayOfByte.Glz == 3)
          {
            localObject1 = com.tencent.mm.kernel.g.ajC();
            p.g(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IHl, paramArrayOfByte.Gqj);
          }
          else if (paramArrayOfByte.Glz == 1)
          {
            localObject1 = com.tencent.mm.kernel.g.ajC();
            p.g(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IHj, paramArrayOfByte.Gqj);
            continue;
            com.tencent.mm.plugin.report.service.g.yhR.n(1279L, 24L, 1L);
          }
        }
      }
    }
    label1599:
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(165242);
      return;
    }
    AppMethodBeat.o(165242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.as
 * JD-Core Version:    0.7.0.1
 */