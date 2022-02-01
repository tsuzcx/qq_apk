package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aiy;
import com.tencent.mm.protocal.protobuf.ajt;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.alm;
import com.tencent.mm.protocal.protobuf.aln;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.l;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderInit;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderInitResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "handleFinderCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class al
  extends n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private com.tencent.mm.ak.g callback;
  private com.tencent.mm.ak.b qYo;
  public aln qYp;
  
  public al()
  {
    AppMethodBeat.i(165243);
    this.TAG = "Finder.NetSceneFinderInit";
    ac.i(this.TAG, "NetSceneFinderInit");
    Object localObject1 = new com.tencent.mm.ak.b.a();
    alm localalm = new alm();
    Object localObject2 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject2, "MMKernel.storage()");
    localObject2 = ((com.tencent.mm.kernel.e)localObject2).agA().get(ah.a.GUt, "");
    if (localObject2 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(165243);
      throw ((Throwable)localObject1);
    }
    localalm.Eki = z.al(bs.aLu((String)localObject2));
    localObject2 = q.qXH;
    localalm.EDL = q.csi();
    ((com.tencent.mm.ak.b.a)localObject1).op(getType());
    ((com.tencent.mm.ak.b.a)localObject1).Am("/cgi-bin/micromsg-bin/finderinit");
    ((com.tencent.mm.ak.b.a)localObject1).c((a)localalm);
    ((com.tencent.mm.ak.b.a)localObject1).d((a)new aln());
    this.qYo = ((com.tencent.mm.ak.b.a)localObject1).aAz();
    h.wUl.n(1279L, 23L, 1L);
    AppMethodBeat.o(165243);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(165241);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.qYo, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165241);
    return i;
  }
  
  public final int getType()
  {
    return 3930;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165242);
    ac.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Object localObject1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.qYo;
      if (paramq != null)
      {
        paramq = paramq.aBD();
        paramArrayOfByte = paramq;
        if (!(paramq instanceof aln)) {
          paramArrayOfByte = null;
        }
        this.qYp = ((aln)paramArrayOfByte);
        localObject1 = this.qYp;
        if (localObject1 == null) {
          break label1599;
        }
        paramq = this.qYp;
        if (paramq == null) {
          break label335;
        }
        paramq = paramq.EFf;
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
        if ((paramArrayOfByte != null) && (!bs.isNullOrNil(((FinderContact)paramq.get(0)).username)))
        {
          paramArrayOfByte = com.tencent.mm.kernel.g.agR();
          d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.agA().set(ah.a.GTQ, ((FinderContact)paramq.get(0)).username);
          paramArrayOfByte = com.tencent.mm.plugin.finder.api.b.qWt;
          paramArrayOfByte = paramq.get(0);
          d.g.b.k.g(paramArrayOfByte, "self[0]");
          com.tencent.mm.plugin.finder.api.b.a.a((FinderContact)paramArrayOfByte);
          paramArrayOfByte = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension();
          Object localObject2 = this.qYp;
          if (localObject2 == null) {
            d.g.b.k.fOy();
          }
          paramArrayOfByte.fx(((aln)localObject2).continueFlag, 5);
          paramArrayOfByte = this.qYo;
          if (paramArrayOfByte == null) {
            d.g.b.k.fOy();
          }
          paramArrayOfByte = paramArrayOfByte.aBD();
          if (paramArrayOfByte == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderInitResponse");
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
          paramArrayOfByte = ((aln)paramArrayOfByte).qrS;
          if (paramArrayOfByte != null)
          {
            localObject2 = ((Iterable)paramArrayOfByte).iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = (aiy)((Iterator)localObject2).next();
                d.g.b.k.g(localObject3, "it");
                Object localObject4;
                Object localObject5;
                switch (((aiy)localObject3).cmdId)
                {
                default: 
                  break;
                case 105: 
                  paramArrayOfByte = (a)new aka();
                  localObject3 = ((aiy)localObject3).EDH.toByteArray();
                  try
                  {
                    paramArrayOfByte.parseFrom((byte[])localObject3);
                    localObject3 = (aka)paramArrayOfByte;
                    paramArrayOfByte = com.tencent.mm.plugin.finder.api.b.qWt;
                    paramArrayOfByte = u.axE();
                    d.g.b.k.g(paramArrayOfByte, "ConfigStorageLogic.getMyFinderUsername()");
                    if (com.tencent.mm.plugin.finder.api.b.a.adh(paramArrayOfByte) != null)
                    {
                      localObject4 = this.TAG;
                      localObject5 = new StringBuilder("save follow count ");
                      if (localObject3 != null)
                      {
                        paramArrayOfByte = Integer.valueOf(((aka)localObject3).EDX);
                        ac.i((String)localObject4, paramArrayOfByte);
                        paramArrayOfByte = com.tencent.mm.kernel.g.agR();
                        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
                        localObject4 = paramArrayOfByte.agA();
                        localObject5 = ah.a.GVm;
                        if (localObject3 == null) {
                          break label632;
                        }
                        paramArrayOfByte = Integer.valueOf(((aka)localObject3).EDX);
                        ((ae)localObject4).set((ah.a)localObject5, paramArrayOfByte);
                      }
                    }
                  }
                  catch (Exception paramArrayOfByte)
                  {
                    for (;;)
                    {
                      ac.l("safeParser", "", new Object[] { paramArrayOfByte });
                      paramArrayOfByte = null;
                      continue;
                      paramArrayOfByte = null;
                      continue;
                      paramArrayOfByte = null;
                    }
                  }
                case 106: 
                  label632:
                  paramArrayOfByte = (a)new ajt();
                  localObject3 = ((aiy)localObject3).EDH.toByteArray();
                  try
                  {
                    paramArrayOfByte.parseFrom((byte[])localObject3);
                    localObject3 = (ajt)paramArrayOfByte;
                    paramArrayOfByte = com.tencent.mm.plugin.finder.api.b.qWt;
                    paramArrayOfByte = u.axE();
                    d.g.b.k.g(paramArrayOfByte, "ConfigStorageLogic.getMyFinderUsername()");
                    if (com.tencent.mm.plugin.finder.api.b.a.adh(paramArrayOfByte) != null)
                    {
                      localObject4 = this.TAG;
                      localObject5 = new StringBuilder("save fans count ");
                      if (localObject3 != null)
                      {
                        paramArrayOfByte = Integer.valueOf(((ajt)localObject3).EDY);
                        ac.i((String)localObject4, paramArrayOfByte);
                        paramArrayOfByte = com.tencent.mm.kernel.g.agR();
                        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
                        localObject4 = paramArrayOfByte.agA();
                        localObject5 = ah.a.GVn;
                        if (localObject3 == null) {
                          break label831;
                        }
                        paramArrayOfByte = Integer.valueOf(((ajt)localObject3).EDY);
                        ((ae)localObject4).set((ah.a)localObject5, paramArrayOfByte);
                      }
                    }
                  }
                  catch (Exception paramArrayOfByte)
                  {
                    for (;;)
                    {
                      ac.l("safeParser", "", new Object[] { paramArrayOfByte });
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
          paramArrayOfByte = com.tencent.mm.kernel.g.agR();
          d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte = paramArrayOfByte.agA();
          localObject2 = ah.a.GUt;
          Object localObject3 = this.qYp;
          if (localObject3 == null) {
            d.g.b.k.fOy();
          }
          paramArrayOfByte.set((ah.a)localObject2, bs.cx(z.a(((aln)localObject3).Eki)));
          paramArrayOfByte = com.tencent.mm.kernel.g.agR();
          d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.agA().set(ah.a.GTR, ((FinderContact)paramq.get(0)).nickname);
          paramArrayOfByte = com.tencent.mm.kernel.g.agR();
          d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.agA().set(ah.a.GTS, ((FinderContact)paramq.get(0)).signature);
          paramArrayOfByte = com.tencent.mm.kernel.g.agR();
          d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.agA().set(ah.a.GTT, ((FinderContact)paramq.get(0)).headUrl);
          paramArrayOfByte = com.tencent.mm.kernel.g.agR();
          d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.agA().set(ah.a.GUq, Integer.valueOf(((FinderContact)paramq.get(0)).extFlag));
          paramArrayOfByte = com.tencent.mm.kernel.g.agR();
          d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.agA().set(ah.a.GTY, Integer.valueOf(((FinderContact)paramq.get(0)).originalFlag));
          if (((FinderContact)paramq.get(0)).originalInfo != null)
          {
            paramArrayOfByte = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.agA().set(ah.a.GTZ, Integer.valueOf(((FinderContact)paramq.get(0)).originalInfo.EFP));
            paramArrayOfByte = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.agA().set(ah.a.GUa, Integer.valueOf(((FinderContact)paramq.get(0)).originalInfo.EFQ));
            paramArrayOfByte = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.agA().set(ah.a.GUb, Integer.valueOf(((FinderContact)paramq.get(0)).originalInfo.EFR));
            paramArrayOfByte = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.agA().set(ah.a.GUc, Integer.valueOf(((FinderContact)paramq.get(0)).originalInfo.EFS));
            paramArrayOfByte = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.agA().set(ah.a.GUf, Integer.valueOf(((FinderContact)paramq.get(0)).originalInfo.EFT));
          }
          if (((FinderContact)paramq.get(0)).authInfo != null) {
            break label1462;
          }
          paramq = com.tencent.mm.kernel.g.agR();
          d.g.b.k.g(paramq, "MMKernel.storage()");
          paramq.agA().set(ah.a.GTU, "");
        }
      }
      label1334:
      paramq = ((aln)localObject1).EFg;
      d.g.b.k.g(paramq, "it.tabInfos");
      paramq = ((Iterable)paramq).iterator();
    }
    else
    {
      for (;;)
      {
        if (paramq.hasNext())
        {
          paramArrayOfByte = (aoi)paramq.next();
          ac.i(this.TAG, paramArrayOfByte.EHv + " => " + paramArrayOfByte.EHw);
          if (paramArrayOfByte.EHv == 4)
          {
            localObject1 = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.e)localObject1).agA().set(ah.a.GUE, paramArrayOfByte.EHw);
            continue;
            label1462:
            paramArrayOfByte = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.agA().set(ah.a.GTU, bs.cx(((FinderContact)paramq.get(0)).authInfo.toByteArray()));
            break;
          }
          if (paramArrayOfByte.EHv == 3)
          {
            localObject1 = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.e)localObject1).agA().set(ah.a.GUF, paramArrayOfByte.EHw);
          }
          else if (paramArrayOfByte.EHv == 1)
          {
            localObject1 = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.e)localObject1).agA().set(ah.a.GUD, paramArrayOfByte.EHw);
            continue;
            h.wUl.n(1279L, 24L, 1L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.al
 * JD-Core Version:    0.7.0.1
 */