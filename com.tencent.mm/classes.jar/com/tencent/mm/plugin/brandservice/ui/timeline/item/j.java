package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.ccu;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.protocal.protobuf.np;
import com.tencent.mm.protocal.protobuf.nq;
import com.tencent.mm.protocal.protobuf.nr;
import com.tencent.mm.protocal.protobuf.ny;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.protocal.protobuf.om;
import com.tencent.mm.protocal.protobuf.sx;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"TAG", "", "value", "", "isOpenFollow", "()Z", "setOpenFollow", "(Z)V", "doBizFeedbackReq", "", "cardType", "", "levelType", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "selectFeedback", "", "isSupportStyle", "style", "plugin-brandservice_release"})
public final class j
{
  private static boolean oiL = true;
  
  public static final void a(int paramInt, dmq paramdmq, List<String> paramList)
  {
    AppMethodBeat.i(208685);
    p.h(paramdmq, "wrapper");
    switch (paramdmq.style)
    {
    default: 
      AppMethodBeat.o(208685);
      return;
    }
    if ((paramdmq.HTS == null) || (bu.ht((List)paramdmq.HTS.Gal)))
    {
      AppMethodBeat.o(208685);
      return;
    }
    Object localObject1 = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject1).c((a)new nq());
    ((com.tencent.mm.ak.b.a)localObject1).d((a)new nr());
    ((com.tencent.mm.ak.b.a)localObject1).DN("/cgi-bin/mmbiz-bin/timeline/bizfeedback");
    ((com.tencent.mm.ak.b.a)localObject1).oS(4898);
    Object localObject2 = z.Nhr;
    com.tencent.mm.ak.b localb = ((com.tencent.mm.ak.b.a)localObject1).aDS();
    localObject1 = localb.aEU();
    if (localObject1 == null)
    {
      paramdmq = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizFeedbackReq");
      AppMethodBeat.o(208685);
      throw paramdmq;
    }
    nq localnq = (nq)localObject1;
    localnq.Gam = 3;
    localObject1 = new LinkedList();
    localObject2 = paramdmq.HTS.Gal;
    p.g(localObject2, "wrapper.extraInfo.BizInfo");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject5 = (om)((Iterator)localObject3).next();
      localObject4 = new ny();
      ((ny)localObject4).FZa = ((om)localObject5).nIJ;
      LinkedList localLinkedList = new LinkedList();
      Object localObject6 = ((om)localObject5).Gcu;
      p.g(localObject6, "it.AppMsg");
      Object localObject7 = (Iterable)localObject6;
      localObject6 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject7, 10));
      localObject7 = ((Iterable)localObject7).iterator();
      while (((Iterator)localObject7).hasNext()) {
        ((Collection)localObject6).add(((ol)((Iterator)localObject7).next()).FYs);
      }
      localLinkedList.addAll((Collection)localObject6);
      localObject6 = z.Nhr;
      ((ny)localObject4).GaF = localLinkedList;
      ((ny)localObject4).GaG = ((om)localObject5).nJO;
      localObject5 = z.Nhr;
      ((Collection)localObject2).add(localObject4);
    }
    ((LinkedList)localObject1).addAll((Collection)localObject2);
    localObject2 = z.Nhr;
    localnq.Gal = ((LinkedList)localObject1);
    localnq.Gan = paramdmq.style;
    localObject2 = paramdmq.dmp;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localnq.Gao = ((String)localObject1);
    localnq.Gap = paramdmq.HDI;
    localObject2 = paramdmq.HTS.Gaq;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localnq.Gaq = ((String)localObject1);
    localObject2 = paramdmq.HTS.Gau;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localnq.Gau = ((String)localObject1);
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramdmq = z.Nhr;
      paramdmq = z.Nhr;
      x.a(localb, (x.a)a.oiM);
      AppMethodBeat.o(208685);
      return;
      localObject1 = new np();
      ((np)localObject1).FZa = ((om)paramdmq.HTS.Gal.get(0)).nIJ;
      if (!bu.ht(paramList))
      {
        paramdmq = new LinkedList();
        if (paramList == null) {
          p.gkB();
        }
        localObject2 = (Iterable)paramList;
        paramList = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (String)((Iterator)localObject2).next();
          localObject3 = new ccu();
          ((ccu)localObject3).hFS = ((String)localObject4);
          localObject4 = z.Nhr;
          paramList.add(localObject3);
        }
        paramdmq.addAll((Collection)paramList);
        paramList = z.Nhr;
        ((np)localObject1).FPC = paramdmq;
      }
      paramdmq = z.Nhr;
      localnq.Gas = ((np)localObject1);
      continue;
      switch (paramdmq.style)
      {
      default: 
        paramdmq = new sx();
        paramdmq.dms = 1;
        paramList = z.Nhr;
        localnq.Gar = paramdmq;
        break;
      case 102: 
        paramdmq = new sx();
        if (!bu.ht(paramList))
        {
          localObject1 = new LinkedList();
          if (paramList == null) {
            p.gkB();
          }
          localObject2 = (Iterable)paramList;
          paramList = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (String)((Iterator)localObject2).next();
            localObject3 = new ccu();
            ((ccu)localObject3).hFS = ((String)localObject4);
            localObject4 = z.Nhr;
            paramList.add(localObject3);
          }
          ((LinkedList)localObject1).addAll((Collection)paramList);
          paramList = z.Nhr;
          paramdmq.FPC = ((LinkedList)localObject1);
        }
        paramList = z.Nhr;
        localnq.Gar = paramdmq;
      }
    }
  }
  
  public static final void bPA()
  {
    AppMethodBeat.i(208684);
    if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qBr, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      oiL = bool;
      AppMethodBeat.o(208684);
      return;
    }
  }
  
  public static final boolean bPz()
  {
    return oiL;
  }
  
  public static final boolean zn(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "<anonymous parameter 1>", "<anonymous parameter 2>", "", "<anonymous parameter 3>", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class a
    implements x.a
  {
    public static final a oiM;
    
    static
    {
      AppMethodBeat.i(208683);
      oiM = new a();
      AppMethodBeat.o(208683);
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb, n paramn)
    {
      AppMethodBeat.i(208682);
      p.h(paramb, "<anonymous parameter 3>");
      p.h(paramn, "<anonymous parameter 4>");
      AppMethodBeat.o(208682);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.j
 * JD-Core Version:    0.7.0.1
 */