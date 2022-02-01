package com.tencent.mm.plugin.expt.hellhound.ext.session.d;

import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.a.a;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.g;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.g.a;
import com.tencent.mm.plugin.expt.hellhound.ext.session.config.d;
import com.tencent.mm.protocal.protobuf.cav;
import com.tencent.mm.protocal.protobuf.caw;
import com.tencent.mm.protocal.protobuf.eag;
import com.tencent.mm.protocal.protobuf.eyz;
import com.tencent.mm.protocal.protobuf.ezb;
import com.tencent.mm.protocal.protobuf.ezc;
import com.tencent.mm.protocal.protobuf.ezf;
import com.tencent.mm.protocal.protobuf.fxz;
import com.tencent.mm.protocal.protobuf.fya;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/params/HellViewParamsCatcher$Companion;", "", "()V", "TAG", "", "addView2FuzzyPath", "", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "catchBizParams2ViewNode", "view", "Landroid/view/View;", "catchParams", "pageObj", "pathId", "", "matchPageList", "", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "catchViewParam", "pathConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$a
{
  private static void a(Object paramObject, View paramView, fxz paramfxz, long paramLong, List<? extends ezb> paramList)
  {
    AppMethodBeat.i(300212);
    Iterator localIterator1 = ((Iterable)paramList).iterator();
    label17:
    if (localIterator1.hasNext())
    {
      ezb localezb = (ezb)localIterator1.next();
      paramList = localezb.abAg;
      s.s(paramList, "it.viewOps");
      Iterator localIterator2 = ((Iterable)paramList).iterator();
      Object localObject;
      for (;;)
      {
        if (!localIterator2.hasNext()) {
          break label17;
        }
        localObject = (fya)localIterator2.next();
        Log.i("HABBYGE-MALI.HellViewParamsCatcher", "catchParams: page=" + localezb.hJW + ", " + paramfxz.id + " == " + ((fya)localObject).viewId + ", " + paramfxz.abVR + " == " + ((fya)localObject).abVR);
        paramList = g.zDb;
        s.s(localObject, "viewOpIt");
        if (!g.a.a(paramfxz, (fya)localObject)) {
          break;
        }
        switch (((fya)localObject).type)
        {
        }
      }
      for (paramList = paramView;; paramList = paramObject)
      {
        localObject = ((fya)localObject).abAf.iterator();
        while (((Iterator)localObject).hasNext())
        {
          eag localeag = (eag)((Iterator)localObject).next();
          if (localeag != null) {
            b.a(paramList, localeag, paramLong, paramfxz);
          }
        }
      }
    }
    AppMethodBeat.o(300212);
  }
  
  public static void b(View paramView, fxz paramfxz)
  {
    AppMethodBeat.i(300206);
    if (paramfxz == null)
    {
      AppMethodBeat.o(300206);
      return;
    }
    Object localObject2 = a.dIS();
    if (localObject2 == null)
    {
      AppMethodBeat.o(300206);
      return;
    }
    d.dLN();
    Object localObject1 = d.dLO();
    if (localObject1 == null)
    {
      Log.e("HABBYGE-MALI.HellViewParamsCatcher", "HellViewParamsCatcher, catchBizParams2ViewNode, config is NULL !!");
      AppMethodBeat.o(300206);
      return;
    }
    String str1 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLz();
    Iterator localIterator1 = ((ezc)localObject1).abAh.iterator();
    label310:
    while (localIterator1.hasNext())
    {
      ezf localezf = (ezf)localIterator1.next();
      if ((localezf != null) && ((s.p(localezf.zIC, str1)) || (s.p("-1", localezf.zIC))))
      {
        localObject1 = localObject2.getClass().getName();
        Object localObject3 = e.zKR;
        s.s(localObject1, "curPageName");
        s.u(localObject1, "curPageName");
        s.u(localezf, "pathConfig");
        localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH((String)localObject1);
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = (List)localObject3)
        {
          if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
            break label310;
          }
          localObject3 = com.tencent.mm.plugin.expt.hellhound.a.a.a.zLL;
          localObject3 = paramfxz.id;
          s.s(localObject3, "viewNode.id");
          paramfxz.abVR = a.a.b((String)localObject3, (List)localObject1, paramfxz.abVR);
          a(localObject2, paramView, paramfxz, localezf.aajX, (List)localObject1);
          break;
          localObject3 = new ArrayList();
          Iterator localIterator2 = localezf.abAl.iterator();
          while (localIterator2.hasNext())
          {
            ezb localezb = (ezb)localIterator2.next();
            String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(localezb.hJW);
            if ((str2 != null) && (s.p(localObject1, str2))) {
              ((ArrayList)localObject3).add(localezb);
            }
          }
        }
      }
    }
    AppMethodBeat.o(300206);
  }
  
  public static void c(fxz paramfxz)
  {
    AppMethodBeat.i(300203);
    if (paramfxz == null)
    {
      AppMethodBeat.o(300203);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.d.a.zJT;
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.d.a.dLl();
    if (localObject2 == null)
    {
      AppMethodBeat.o(300203);
      return;
    }
    localObject1 = (eyz)((Pair)localObject2).first;
    localObject2 = (Integer)((Pair)localObject2).second;
    Iterator localIterator = ((eyz)localObject1).aajM.iterator();
    label259:
    for (;;)
    {
      cav localcav;
      if (localIterator.hasNext())
      {
        Object localObject3 = (caw)localIterator.next();
        if ((localObject3 != null) && (!((caw)localObject3).aajU.isEmpty()))
        {
          Object localObject4 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(((caw)localObject3).aajT.hJW);
          localcav = (cav)((caw)localObject3).aajU.getLast();
          String str = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(localcav.name);
          if (s.p(str, localObject4))
          {
            localcav.aajR.add(paramfxz);
          }
          else
          {
            localObject3 = ((caw)localObject3).aajS.iterator();
            do
            {
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              localObject4 = (ezb)((Iterator)localObject3).next();
            } while ((localObject4 == null) || (!s.p(str, com.tencent.mm.plugin.expt.hellhound.core.b.aqH(((ezb)localObject4).hJW))));
          }
        }
      }
      else
      {
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label259;
          }
          localcav.aajR.add(paramfxz);
          break;
          paramfxz = com.tencent.mm.plugin.expt.hellhound.ext.d.a.zJT;
          s.s(localObject2, "index");
          com.tencent.mm.plugin.expt.hellhound.ext.d.a.a((eyz)localObject1, ((Integer)localObject2).intValue());
          AppMethodBeat.o(300203);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.d.d.a
 * JD-Core Version:    0.7.0.1
 */