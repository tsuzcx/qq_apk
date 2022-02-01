package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ama;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.anl;
import com.tencent.mm.protocal.protobuf.ape;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.asm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderInit;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderInitResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "handleFinderCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class at
  extends n
  implements k
{
  private final String TAG;
  private f callback;
  private com.tencent.mm.ak.b rRO;
  public apf rRP;
  
  public at()
  {
    AppMethodBeat.i(165243);
    this.TAG = "Finder.NetSceneFinderInit";
    ae.i(this.TAG, "NetSceneFinderInit");
    Object localObject1 = new b.a();
    ape localape = new ape();
    Object localObject2 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject2, "MMKernel.storage()");
    localObject2 = ((com.tencent.mm.kernel.e)localObject2).ajA().get(am.a.JbA, "");
    if (localObject2 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(165243);
      throw ((Throwable)localObject1);
    }
    localape.GjQ = z.al(bu.aSx((String)localObject2));
    localObject2 = v.rRb;
    localape.GDR = v.czz();
    ((b.a)localObject1).oS(getType());
    ((b.a)localObject1).DN("/cgi-bin/micromsg-bin/finderinit");
    ((b.a)localObject1).c((a)localape);
    ((b.a)localObject1).d((a)new apf());
    this.rRO = ((b.a)localObject1).aDS();
    com.tencent.mm.plugin.report.service.g.yxI.n(1279L, 23L, 1L);
    AppMethodBeat.o(165243);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(165241);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rRO, (k)this);
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
    ae.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    label126:
    Object localObject1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rRO;
      apf localapf;
      if (paramq != null)
      {
        paramq = paramq.aEV();
        paramArrayOfByte = paramq;
        if (!(paramq instanceof apf)) {
          paramArrayOfByte = null;
        }
        this.rRP = ((apf)paramArrayOfByte);
        localapf = this.rRP;
        if (localapf == null) {
          break label1813;
        }
        paramq = this.rRP;
        if (paramq == null) {
          break label335;
        }
        paramq = paramq.GGr;
        if (paramq == null) {
          break label1491;
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
        if ((paramArrayOfByte != null) && (!bu.isNullOrNil(((FinderContact)paramq.get(0)).username)))
        {
          paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
          p.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.ajA().set(am.a.JaW, ((FinderContact)paramq.get(0)).username);
          paramArrayOfByte = c.rPy;
          paramArrayOfByte = paramq.get(0);
          p.g(paramArrayOfByte, "self[0]");
          c.a.a((FinderContact)paramArrayOfByte);
          paramArrayOfByte = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension();
          localObject1 = this.rRP;
          if (localObject1 == null) {
            p.gkB();
          }
          paramArrayOfByte.fG(((apf)localObject1).continueFlag, 5);
          paramArrayOfByte = this.rRO;
          if (paramArrayOfByte == null) {
            p.gkB();
          }
          paramArrayOfByte = paramArrayOfByte.aEV();
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
          paramArrayOfByte = ((apf)paramArrayOfByte).rjr;
          if (paramArrayOfByte != null)
          {
            localObject2 = ((Iterable)paramArrayOfByte).iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                paramArrayOfByte = (ama)((Iterator)localObject2).next();
                p.g(paramArrayOfByte, "it");
                Object localObject3;
                Object localObject4;
                switch (paramArrayOfByte.cmdId)
                {
                default: 
                  break;
                case 105: 
                  localObject1 = (a)new anl();
                  paramArrayOfByte = paramArrayOfByte.GEu;
                  if (paramArrayOfByte != null) {}
                  for (paramArrayOfByte = paramArrayOfByte.toByteArray();; paramArrayOfByte = null)
                  {
                    try
                    {
                      ((a)localObject1).parseFrom(paramArrayOfByte);
                      paramArrayOfByte = (byte[])localObject1;
                    }
                    catch (Exception paramArrayOfByte)
                    {
                      for (;;)
                      {
                        ae.l("safeParser", "", new Object[] { paramArrayOfByte });
                        paramArrayOfByte = null;
                        continue;
                        paramArrayOfByte = null;
                        continue;
                        paramArrayOfByte = null;
                      }
                    }
                    localObject1 = (anl)paramArrayOfByte;
                    paramArrayOfByte = c.rPy;
                    if (c.a.ahT(com.tencent.mm.model.v.aAK()) == null) {
                      break;
                    }
                    localObject3 = this.TAG;
                    localObject4 = new StringBuilder("save follow count ");
                    if (localObject1 == null) {
                      break label633;
                    }
                    paramArrayOfByte = Integer.valueOf(((anl)localObject1).GEO);
                    ae.i((String)localObject3, paramArrayOfByte);
                    paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
                    p.g(paramArrayOfByte, "MMKernel.storage()");
                    localObject3 = paramArrayOfByte.ajA();
                    localObject4 = am.a.Jcx;
                    if (localObject1 == null) {
                      break label639;
                    }
                    paramArrayOfByte = Integer.valueOf(((anl)localObject1).GEO);
                    ((aj)localObject3).set((am.a)localObject4, paramArrayOfByte);
                    break;
                  }
                case 106: 
                  label633:
                  label639:
                  localObject1 = (a)new anc();
                  paramArrayOfByte = paramArrayOfByte.GEu;
                  if (paramArrayOfByte != null) {}
                  for (paramArrayOfByte = paramArrayOfByte.toByteArray();; paramArrayOfByte = null)
                  {
                    try
                    {
                      ((a)localObject1).parseFrom(paramArrayOfByte);
                      paramArrayOfByte = (byte[])localObject1;
                    }
                    catch (Exception paramArrayOfByte)
                    {
                      for (;;)
                      {
                        ae.l("safeParser", "", new Object[] { paramArrayOfByte });
                        paramArrayOfByte = null;
                        continue;
                        paramArrayOfByte = null;
                        continue;
                        paramArrayOfByte = null;
                      }
                    }
                    localObject1 = (anc)paramArrayOfByte;
                    paramArrayOfByte = c.rPy;
                    if (c.a.ahT(com.tencent.mm.model.v.aAK()) == null) {
                      break;
                    }
                    localObject3 = this.TAG;
                    localObject4 = new StringBuilder("save fans count ");
                    if (localObject1 == null) {
                      break label839;
                    }
                    paramArrayOfByte = Integer.valueOf(((anc)localObject1).GDY);
                    ae.i((String)localObject3, paramArrayOfByte);
                    paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
                    p.g(paramArrayOfByte, "MMKernel.storage()");
                    localObject3 = paramArrayOfByte.ajA();
                    localObject4 = am.a.Jcy;
                    if (localObject1 == null) {
                      break label845;
                    }
                    paramArrayOfByte = Integer.valueOf(((anc)localObject1).GDY);
                    ((aj)localObject3).set((am.a)localObject4, paramArrayOfByte);
                    break;
                  }
                }
              }
            }
          }
          label839:
          label845:
          paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
          p.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte = paramArrayOfByte.ajA();
          localObject1 = am.a.JbA;
          Object localObject2 = this.rRP;
          if (localObject2 == null) {
            p.gkB();
          }
          paramArrayOfByte.set((am.a)localObject1, bu.cH(z.a(((apf)localObject2).GjQ)));
          paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
          p.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.ajA().set(am.a.JaX, ((FinderContact)paramq.get(0)).nickname);
          paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
          p.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.ajA().set(am.a.JaY, ((FinderContact)paramq.get(0)).signature);
          paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
          p.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.ajA().set(am.a.JaZ, ((FinderContact)paramq.get(0)).headUrl);
          paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
          p.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.ajA().set(am.a.Jbx, Integer.valueOf(((FinderContact)paramq.get(0)).extFlag));
          paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
          p.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.ajA().set(am.a.Jbe, Integer.valueOf(((FinderContact)paramq.get(0)).originalFlag));
          paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
          p.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.ajA().set(am.a.Jbj, Integer.valueOf(((FinderContact)paramq.get(0)).originalEntranceFlag));
          if (((FinderContact)paramq.get(0)).originalInfo != null)
          {
            paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
            p.g(paramArrayOfByte, "MMKernel.storage()");
            localObject1 = paramArrayOfByte.ajA();
            localObject2 = am.a.Jbf;
            paramArrayOfByte = ((FinderContact)paramq.get(0)).originalInfo;
            if (paramArrayOfByte == null) {
              break label1619;
            }
            paramArrayOfByte = Integer.valueOf(paramArrayOfByte.GHB);
            ((aj)localObject1).set((am.a)localObject2, paramArrayOfByte);
            paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
            p.g(paramArrayOfByte, "MMKernel.storage()");
            localObject1 = paramArrayOfByte.ajA();
            localObject2 = am.a.Jbg;
            paramArrayOfByte = ((FinderContact)paramq.get(0)).originalInfo;
            if (paramArrayOfByte == null) {
              break label1625;
            }
            paramArrayOfByte = Integer.valueOf(paramArrayOfByte.GHC);
            label1256:
            ((aj)localObject1).set((am.a)localObject2, paramArrayOfByte);
            paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
            p.g(paramArrayOfByte, "MMKernel.storage()");
            localObject1 = paramArrayOfByte.ajA();
            localObject2 = am.a.Jbh;
            paramArrayOfByte = ((FinderContact)paramq.get(0)).originalInfo;
            if (paramArrayOfByte == null) {
              break label1631;
            }
            paramArrayOfByte = Integer.valueOf(paramArrayOfByte.GHD);
            label1318:
            ((aj)localObject1).set((am.a)localObject2, paramArrayOfByte);
            paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
            p.g(paramArrayOfByte, "MMKernel.storage()");
            localObject1 = paramArrayOfByte.ajA();
            localObject2 = am.a.Jbi;
            paramArrayOfByte = ((FinderContact)paramq.get(0)).originalInfo;
            if (paramArrayOfByte == null) {
              break label1637;
            }
            paramArrayOfByte = Integer.valueOf(paramArrayOfByte.GHE);
            label1380:
            ((aj)localObject1).set((am.a)localObject2, paramArrayOfByte);
            paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
            p.g(paramArrayOfByte, "MMKernel.storage()");
            localObject1 = paramArrayOfByte.ajA();
            localObject2 = am.a.Jbl;
            paramArrayOfByte = ((FinderContact)paramq.get(0)).originalInfo;
            if (paramArrayOfByte == null) {
              break label1643;
            }
            paramArrayOfByte = Integer.valueOf(paramArrayOfByte.GHF);
            label1442:
            ((aj)localObject1).set((am.a)localObject2, paramArrayOfByte);
          }
          if (((FinderContact)paramq.get(0)).authInfo != null) {
            break label1649;
          }
          paramq = com.tencent.mm.kernel.g.ajR();
          p.g(paramq, "MMKernel.storage()");
          paramq.ajA().set(am.a.Jba, "");
        }
      }
      label1491:
      paramq = localapf.GGs;
      p.g(paramq, "it.tabInfos");
      paramq = ((Iterable)paramq).iterator();
    }
    else
    {
      for (;;)
      {
        if (paramq.hasNext())
        {
          paramArrayOfByte = (asm)paramq.next();
          ae.i(this.TAG, paramArrayOfByte.GEB + " => " + paramArrayOfByte.GJE);
          if (paramArrayOfByte.GEB == 4)
          {
            localObject1 = com.tencent.mm.kernel.g.ajR();
            p.g(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.e)localObject1).ajA().set(am.a.JbN, paramArrayOfByte.GJE);
            continue;
            label1619:
            paramArrayOfByte = null;
            break;
            label1625:
            paramArrayOfByte = null;
            break label1256;
            label1631:
            paramArrayOfByte = null;
            break label1318;
            label1637:
            paramArrayOfByte = null;
            break label1380;
            label1643:
            paramArrayOfByte = null;
            break label1442;
            label1649:
            paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
            p.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte = paramArrayOfByte.ajA();
            localObject1 = am.a.Jba;
            paramq = ((FinderContact)paramq.get(0)).authInfo;
            if (paramq != null) {}
            for (paramq = paramq.toByteArray();; paramq = null)
            {
              paramArrayOfByte.set((am.a)localObject1, bu.cH(paramq));
              break;
            }
          }
          if (paramArrayOfByte.GEB == 3)
          {
            localObject1 = com.tencent.mm.kernel.g.ajR();
            p.g(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.e)localObject1).ajA().set(am.a.JbO, paramArrayOfByte.GJE);
          }
          else if (paramArrayOfByte.GEB == 1)
          {
            localObject1 = com.tencent.mm.kernel.g.ajR();
            p.g(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.e)localObject1).ajA().set(am.a.JbM, paramArrayOfByte.GJE);
            continue;
            com.tencent.mm.plugin.report.service.g.yxI.n(1279L, 24L, 1L);
          }
        }
      }
    }
    label1813:
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
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.at
 * JD-Core Version:    0.7.0.1
 */