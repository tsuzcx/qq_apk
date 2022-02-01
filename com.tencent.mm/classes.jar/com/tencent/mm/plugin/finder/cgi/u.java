package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ahv;
import com.tencent.mm.protocal.protobuf.aij;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.ajm;
import com.tencent.mm.protocal.protobuf.dzn;
import com.tencent.mm.protocal.protobuf.dzr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.l;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderInit;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderInitResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "handleFinderCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class u
  extends n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private com.tencent.mm.al.g callback;
  private com.tencent.mm.al.b qpm;
  public ajm qpn;
  
  public u()
  {
    AppMethodBeat.i(165243);
    this.TAG = "Finder.NetSceneFinderInit";
    ad.i(this.TAG, "NetSceneFinderInit");
    Object localObject1 = new com.tencent.mm.al.b.a();
    ajl localajl = new ajl();
    Object localObject2 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject2, "MMKernel.storage()");
    localObject2 = ((com.tencent.mm.kernel.e)localObject2).afk().get(ae.a.Fwr, "");
    if (localObject2 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(165243);
      throw ((Throwable)localObject1);
    }
    localajl.CRx = z.am(bt.aGd((String)localObject2));
    localObject2 = am.KJy;
    localajl.Dkw = am.fRS();
    ((com.tencent.mm.al.b.a)localObject1).nB(getType());
    ((com.tencent.mm.al.b.a)localObject1).wg("/cgi-bin/micromsg-bin/finderinit");
    ((com.tencent.mm.al.b.a)localObject1).c((a)localajl);
    ((com.tencent.mm.al.b.a)localObject1).d((a)new ajm());
    this.qpm = ((com.tencent.mm.al.b.a)localObject1).atI();
    h.vKh.m(1279L, 23L, 1L);
    AppMethodBeat.o(165243);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(165241);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.qpm, (com.tencent.mm.network.k)this);
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
      paramq = this.qpm;
      if (paramq != null)
      {
        paramq = paramq.auM();
        paramArrayOfByte = paramq;
        if (!(paramq instanceof ajm)) {
          paramArrayOfByte = null;
        }
        this.qpn = ((ajm)paramArrayOfByte);
        localObject1 = this.qpn;
        if (localObject1 == null) {
          break label1599;
        }
        paramq = this.qpn;
        if (paramq == null) {
          break label335;
        }
        paramq = paramq.Dlz;
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
          paramArrayOfByte = com.tencent.mm.kernel.g.afB();
          d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.afk().set(ae.a.FvW, ((FinderContact)paramq.get(0)).username);
          paramArrayOfByte = com.tencent.mm.plugin.finder.api.b.qnX;
          paramArrayOfByte = paramq.get(0);
          d.g.b.k.g(paramArrayOfByte, "self[0]");
          com.tencent.mm.plugin.finder.api.b.a.a((FinderContact)paramArrayOfByte);
          paramArrayOfByte = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension();
          Object localObject2 = this.qpn;
          if (localObject2 == null) {
            d.g.b.k.fvU();
          }
          paramArrayOfByte.fu(((ajm)localObject2).continueFlag, 5);
          paramArrayOfByte = this.qpm;
          if (paramArrayOfByte == null) {
            d.g.b.k.fvU();
          }
          paramArrayOfByte = paramArrayOfByte.auM();
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
          paramArrayOfByte = ((ajm)paramArrayOfByte).pJl;
          if (paramArrayOfByte != null)
          {
            localObject2 = ((Iterable)paramArrayOfByte).iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = (ahv)((Iterator)localObject2).next();
                d.g.b.k.g(localObject3, "it");
                Object localObject4;
                Object localObject5;
                switch (((ahv)localObject3).cmdId)
                {
                default: 
                  break;
                case 105: 
                  paramArrayOfByte = (a)new aio();
                  localObject3 = ((ahv)localObject3).Dkt.toByteArray();
                  try
                  {
                    paramArrayOfByte.parseFrom((byte[])localObject3);
                    localObject3 = (aio)paramArrayOfByte;
                    paramArrayOfByte = com.tencent.mm.plugin.finder.api.b.qnX;
                    paramArrayOfByte = com.tencent.mm.model.u.aqO();
                    d.g.b.k.g(paramArrayOfByte, "ConfigStorageLogic.getMyFinderUsername()");
                    if (com.tencent.mm.plugin.finder.api.b.a.YL(paramArrayOfByte) != null)
                    {
                      localObject4 = this.TAG;
                      localObject5 = new StringBuilder("save follow count ");
                      if (localObject3 != null)
                      {
                        paramArrayOfByte = Integer.valueOf(((aio)localObject3).Dlh);
                        ad.i((String)localObject4, paramArrayOfByte);
                        paramArrayOfByte = com.tencent.mm.kernel.g.afB();
                        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
                        localObject4 = paramArrayOfByte.afk();
                        localObject5 = ae.a.FwW;
                        if (localObject3 == null) {
                          break label632;
                        }
                        paramArrayOfByte = Integer.valueOf(((aio)localObject3).Dlh);
                        ((ab)localObject4).set((ae.a)localObject5, paramArrayOfByte);
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
                  paramArrayOfByte = (a)new aij();
                  localObject3 = ((ahv)localObject3).Dkt.toByteArray();
                  try
                  {
                    paramArrayOfByte.parseFrom((byte[])localObject3);
                    localObject3 = (aij)paramArrayOfByte;
                    paramArrayOfByte = com.tencent.mm.plugin.finder.api.b.qnX;
                    paramArrayOfByte = com.tencent.mm.model.u.aqO();
                    d.g.b.k.g(paramArrayOfByte, "ConfigStorageLogic.getMyFinderUsername()");
                    if (com.tencent.mm.plugin.finder.api.b.a.YL(paramArrayOfByte) != null)
                    {
                      localObject4 = this.TAG;
                      localObject5 = new StringBuilder("save fans count ");
                      if (localObject3 != null)
                      {
                        paramArrayOfByte = Integer.valueOf(((aij)localObject3).Dla);
                        ad.i((String)localObject4, paramArrayOfByte);
                        paramArrayOfByte = com.tencent.mm.kernel.g.afB();
                        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
                        localObject4 = paramArrayOfByte.afk();
                        localObject5 = ae.a.FwX;
                        if (localObject3 == null) {
                          break label831;
                        }
                        paramArrayOfByte = Integer.valueOf(((aij)localObject3).Dla);
                        ((ab)localObject4).set((ae.a)localObject5, paramArrayOfByte);
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
          paramArrayOfByte = com.tencent.mm.kernel.g.afB();
          d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte = paramArrayOfByte.afk();
          localObject2 = ae.a.Fwr;
          Object localObject3 = this.qpn;
          if (localObject3 == null) {
            d.g.b.k.fvU();
          }
          paramArrayOfByte.set((ae.a)localObject2, bt.cy(z.a(((ajm)localObject3).CRx)));
          paramArrayOfByte = com.tencent.mm.kernel.g.afB();
          d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.afk().set(ae.a.FvX, ((FinderContact)paramq.get(0)).nickname);
          paramArrayOfByte = com.tencent.mm.kernel.g.afB();
          d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.afk().set(ae.a.FvY, ((FinderContact)paramq.get(0)).signature);
          paramArrayOfByte = com.tencent.mm.kernel.g.afB();
          d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.afk().set(ae.a.FvZ, ((FinderContact)paramq.get(0)).headUrl);
          paramArrayOfByte = com.tencent.mm.kernel.g.afB();
          d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.afk().set(ae.a.Fwo, Integer.valueOf(((FinderContact)paramq.get(0)).extFlag));
          paramArrayOfByte = com.tencent.mm.kernel.g.afB();
          d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.afk().set(ae.a.Fwe, Integer.valueOf(((FinderContact)paramq.get(0)).originalFlag));
          if (((FinderContact)paramq.get(0)).originalInfo != null)
          {
            paramArrayOfByte = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.afk().set(ae.a.Fwf, Integer.valueOf(((FinderContact)paramq.get(0)).originalInfo.LxV));
            paramArrayOfByte = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.afk().set(ae.a.Fwg, Integer.valueOf(((FinderContact)paramq.get(0)).originalInfo.LxW));
            paramArrayOfByte = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.afk().set(ae.a.Fwh, Integer.valueOf(((FinderContact)paramq.get(0)).originalInfo.LxX));
            paramArrayOfByte = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.afk().set(ae.a.Fwi, Integer.valueOf(((FinderContact)paramq.get(0)).originalInfo.LxY));
            paramArrayOfByte = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.afk().set(ae.a.LAK, Integer.valueOf(((FinderContact)paramq.get(0)).originalInfo.LxZ));
          }
          if (((FinderContact)paramq.get(0)).authInfo != null) {
            break label1462;
          }
          paramq = com.tencent.mm.kernel.g.afB();
          d.g.b.k.g(paramq, "MMKernel.storage()");
          paramq.afk().set(ae.a.Fwa, "");
        }
      }
      label1334:
      paramq = ((ajm)localObject1).LxE;
      d.g.b.k.g(paramq, "it.tabInfos");
      paramq = ((Iterable)paramq).iterator();
    }
    else
    {
      for (;;)
      {
        if (paramq.hasNext())
        {
          paramArrayOfByte = (dzr)paramq.next();
          ad.i(this.TAG, paramArrayOfByte.Lyv + " => " + paramArrayOfByte.Lyw);
          if (paramArrayOfByte.Lyv == 4)
          {
            localObject1 = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.e)localObject1).afk().set(ae.a.LAV, paramArrayOfByte.Lyw);
            continue;
            label1462:
            paramArrayOfByte = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.afk().set(ae.a.Fwa, bt.cy(((FinderContact)paramq.get(0)).authInfo.toByteArray()));
            break;
          }
          if (paramArrayOfByte.Lyv == 3)
          {
            localObject1 = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.e)localObject1).afk().set(ae.a.LAW, paramArrayOfByte.Lyw);
          }
          else if (paramArrayOfByte.Lyv == 1)
          {
            localObject1 = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.e)localObject1).afk().set(ae.a.LAU, paramArrayOfByte.Lyw);
            continue;
            h.vKh.m(1279L, 24L, 1L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.u
 * JD-Core Version:    0.7.0.1
 */