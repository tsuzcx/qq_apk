package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import a.c.b.a.d;
import a.c.b.a.g;
import a.c.c;
import a.f.a.m;
import a.f.b.j;
import a.l;
import a.p.b;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cki;
import com.tencent.mm.protocal.protobuf.ckj;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlinx.coroutines.ac;

@d(c="com/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager$downloadTmpl$1", f="LocalTmplInfoManager.kt", l={610, 623}, m="invokeSuspend")
@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class b$f
  extends g
  implements m<ac, c<? super y>, Object>
{
  private ac kbW;
  Object kcL;
  Object kcM;
  int label;
  
  b$f(ckj paramckj, int paramInt, a.f.a.a parama, c paramc)
  {
    super(paramc);
  }
  
  public final c<y> a(Object paramObject, c<?> paramc)
  {
    AppMethodBeat.i(152712);
    j.q(paramc, "completion");
    paramc = new f(this.kcN, this.jSy, this.kcO, paramc);
    paramc.kbW = ((ac)paramObject);
    AppMethodBeat.o(152712);
    return paramc;
  }
  
  public final Object bD(Object paramObject)
  {
    AppMethodBeat.i(152711);
    a.c.a.a locala = a.c.a.a.BMS;
    Object localObject2;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(152711);
      throw paramObject;
    case 0: 
      if ((paramObject instanceof p.b))
      {
        paramObject = ((p.b)paramObject).BLY;
        AppMethodBeat.o(152711);
        throw paramObject;
      }
      paramObject = new HashMap();
      localObject1 = this.kcN.wyV;
      localObject2 = this.kcN.xUm;
      j.p(localObject2, "tmplInfo.HttpHeaderList");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (cki)((Iterator)localObject2).next();
        Object localObject4 = (CharSequence)((cki)localObject3).wxP;
        if ((localObject4 == null) || (((CharSequence)localObject4).length() == 0))
        {
          i = 1;
          if (i != 0) {
            continue;
          }
          localObject4 = (CharSequence)((cki)localObject3).qsu;
          if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
            break label257;
          }
        }
        for (int i = 1; i == 0; i = 0)
        {
          localObject4 = (Map)paramObject;
          String str = ((cki)localObject3).wxP;
          j.p(str, "it.Key");
          localObject3 = ((cki)localObject3).qsu;
          j.p(localObject3, "it.Value");
          ((Map)localObject4).put(str, localObject3);
          break;
          i = 0;
          break label168;
        }
      }
      if (!this.kcN.xUn) {
        break label404;
      }
      localObject2 = b.kcE;
      j.p(localObject1, "downloadUrl");
      this.kcL = paramObject;
      this.kcM = localObject1;
      this.label = 1;
      localObject2 = b.a((String)localObject1, paramObject, this);
      localObject1 = localObject2;
      if (localObject2 == locala)
      {
        AppMethodBeat.o(152711);
        return locala;
      }
      break;
    case 1: 
      label168:
      localObject2 = (HashMap)this.kcL;
      label257:
      if ((paramObject instanceof p.b))
      {
        paramObject = ((p.b)paramObject).BLY;
        AppMethodBeat.o(152711);
        throw paramObject;
      }
      localObject1 = paramObject;
      paramObject = localObject2;
    }
    Object localObject1 = (String)localObject1;
    label404:
    for (;;)
    {
      localObject2 = b.kcE;
      j.p(localObject1, "fullUrl");
      b.a((String)localObject1, this.kcN, paramObject, this.jSy, this.kcO);
      paramObject = y.BMg;
      AppMethodBeat.o(152711);
      return paramObject;
    }
  }
  
  public final Object h(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(152713);
    paramObject1 = ((f)a(paramObject1, (c)paramObject2)).bD(y.BMg);
    AppMethodBeat.o(152713);
    return paramObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.f
 * JD-Core Version:    0.7.0.1
 */