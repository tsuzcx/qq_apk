package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.cca;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.nn;
import com.tencent.mm.protocal.protobuf.no;
import com.tencent.mm.protocal.protobuf.np;
import com.tencent.mm.protocal.protobuf.nw;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.protocal.protobuf.sv;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"TAG", "", "value", "", "isOpenFollow", "()Z", "setOpenFollow", "(Z)V", "doBizFeedbackReq", "", "cardType", "", "levelType", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "selectFeedback", "", "isSupportStyle", "style", "plugin-brandservice_release"})
public final class j
{
  private static boolean ocW = true;
  
  public static final void a(int paramInt, dlt paramdlt, List<String> paramList)
  {
    AppMethodBeat.i(209711);
    p.h(paramdlt, "wrapper");
    switch (paramdlt.style)
    {
    default: 
      AppMethodBeat.o(209711);
      return;
    }
    if ((paramdlt.HAf == null) || (bt.hj((List)paramdlt.HAf.FHP)))
    {
      AppMethodBeat.o(209711);
      return;
    }
    Object localObject1 = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject1).c((a)new no());
    ((com.tencent.mm.al.b.a)localObject1).d((a)new np());
    ((com.tencent.mm.al.b.a)localObject1).Dl("/cgi-bin/mmbiz-bin/timeline/bizfeedback");
    ((com.tencent.mm.al.b.a)localObject1).oP(4898);
    com.tencent.mm.al.b localb = ((com.tencent.mm.al.b.a)localObject1).aDC();
    localObject1 = localb.aEE();
    if (localObject1 == null)
    {
      paramdlt = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizFeedbackReq");
      AppMethodBeat.o(209711);
      throw paramdlt;
    }
    no localno = (no)localObject1;
    localno.FHQ = 3;
    localObject1 = new LinkedList();
    Object localObject2 = paramdlt.HAf.FHP;
    p.g(localObject2, "wrapper.extraInfo.BizInfo");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject5 = (ok)((Iterator)localObject3).next();
      localObject4 = new nw();
      ((nw)localObject4).FGE = ((ok)localObject5).nDo;
      LinkedList localLinkedList = new LinkedList();
      localObject5 = ((ok)localObject5).FJV;
      p.g(localObject5, "it.AppMsg");
      Object localObject6 = (Iterable)localObject5;
      localObject5 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject6, 10));
      localObject6 = ((Iterable)localObject6).iterator();
      while (((Iterator)localObject6).hasNext()) {
        ((Collection)localObject5).add(((oj)((Iterator)localObject6).next()).FFW);
      }
      localLinkedList.addAll((Collection)localObject5);
      ((nw)localObject4).FIj = localLinkedList;
      ((Collection)localObject2).add(localObject4);
    }
    ((LinkedList)localObject1).addAll((Collection)localObject2);
    localno.FHP = ((LinkedList)localObject1);
    localno.FHR = paramdlt.style;
    localObject2 = paramdlt.dln;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localno.FHS = ((String)localObject1);
    localno.FHT = paramdlt.Hki;
    localObject2 = paramdlt.HAf.FHU;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localno.FHU = ((String)localObject1);
    localObject2 = paramdlt.HAf.FHY;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localno.FHY = ((String)localObject1);
    switch (paramInt)
    {
    }
    for (;;)
    {
      x.a(localb, (x.a)a.ocX);
      AppMethodBeat.o(209711);
      return;
      localObject1 = new nn();
      ((nn)localObject1).FGE = ((ok)paramdlt.HAf.FHP.get(0)).nDo;
      if (!bt.hj(paramList))
      {
        paramdlt = new LinkedList();
        if (paramList == null) {
          p.gfZ();
        }
        localObject2 = (Iterable)paramList;
        paramList = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject4 = new cca();
          ((cca)localObject4).hDa = ((String)localObject3);
          paramList.add(localObject4);
        }
        paramdlt.addAll((Collection)paramList);
        ((nn)localObject1).Fxe = paramdlt;
      }
      localno.FHW = ((nn)localObject1);
      continue;
      paramdlt = new sv();
      paramdlt.dlq = 1;
      localno.FHV = paramdlt;
    }
  }
  
  public static final boolean bOB()
  {
    return ocW;
  }
  
  public static final void bOC()
  {
    AppMethodBeat.i(209710);
    if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.quA, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ocW = bool;
      AppMethodBeat.o(209710);
      return;
    }
  }
  
  public static final boolean ze(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "<anonymous parameter 1>", "<anonymous parameter 2>", "", "<anonymous parameter 3>", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class a
    implements x.a
  {
    public static final a ocX;
    
    static
    {
      AppMethodBeat.i(209709);
      ocX = new a();
      AppMethodBeat.o(209709);
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb, n paramn)
    {
      AppMethodBeat.i(209708);
      p.h(paramb, "<anonymous parameter 3>");
      p.h(paramn, "<anonymous parameter 4>");
      AppMethodBeat.o(209708);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.j
 * JD-Core Version:    0.7.0.1
 */