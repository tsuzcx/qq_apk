package com.tencent.mm.mj_template.sns.a.a;

import androidx.compose.runtime.an;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import com.tencent.maas.model.MJTemplateInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fxr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<+Lcom.tencent.maas.model.MJTemplateInfo;>;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListState;", "", "asyncJobScope", "Lkotlinx/coroutines/CoroutineScope;", "defaultTemplateList", "", "Lcom/tencent/mm/protocal/protobuf/VideoTemplate;", "(Lkotlinx/coroutines/CoroutineScope;Ljava/util/List;)V", "getAsyncJobScope", "()Lkotlinx/coroutines/CoroutineScope;", "curSelectedItemId", "", "getCurSelectedItemId", "()Ljava/lang/String;", "<set-?>", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData;", "curSelectedTemplate", "getCurSelectedTemplate", "()Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData;", "getDefaultTemplateList", "()Ljava/util/List;", "exposedTmplIdSet", "Ljava/util/HashSet;", "homepageTemplateList", "", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData$SnsTemplateListDataTemplate;", "listLoadEnd", "", "moreTemplateList", "Ljava/util/LinkedList;", "onSelectedTemplateChanged", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "templateId", "Lkotlin/coroutines/Continuation;", "getOnSelectedTemplateChanged", "()Lkotlin/jvm/functions/Function2;", "setOnSelectedTemplateChanged", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "openMorePanel", "Lkotlin/Function0;", "", "getOpenMorePanel", "()Lkotlin/jvm/functions/Function0;", "setOpenMorePanel", "(Lkotlin/jvm/functions/Function0;)V", "openMusicPanel", "getOpenMusicPanel", "setOpenMusicPanel", "reporter", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListState$IReporter;", "getReporter", "()Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListState$IReporter;", "setReporter", "(Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListState$IReporter;)V", "templateList", "getTemplateList$plugin_mj_template_release", "templateList$delegate", "Landroidx/compose/runtime/MutableState;", "templateListState", "Landroidx/compose/runtime/MutableState;", "addMoreTemplate", "templateData", "selected", "onTemplateListChange", "list", "onTemplateListChangeMJ", "Lcom/tencent/maas/model/MJTemplateInfo;", "onTemplateSelected", "data", "onVisibleListChanged", "visibleItemIdx", "", "updateCurSelectTemplate", "updateTemplateList", "Companion", "IReporter", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g.a ofc;
  final aq nXq;
  public m<? super String, ? super d<? super Boolean>, ? extends Object> oeu;
  public final List<fxr> ofd;
  public kotlin.g.a.a<ah> ofe;
  public kotlin.g.a.a<ah> ofg;
  private final an<List<e>> ofh;
  private final an ofi;
  public final LinkedList<e> ofj;
  private final List<e.e> ofk;
  private boolean ofl;
  public e ofm;
  public b ofn;
  private final HashSet<String> ofo;
  
  static
  {
    AppMethodBeat.i(240372);
    ofc = new g.a((byte)0);
    AppMethodBeat.o(240372);
  }
  
  public g(aq paramaq, List<? extends fxr> paramList)
  {
    AppMethodBeat.i(240368);
    this.nXq = paramaq;
    this.ofd = paramList;
    this.ofe = ((kotlin.g.a.a)g.f.ofs);
    this.ofg = ((kotlin.g.a.a)g.e.ofr);
    this.oeu = ((m)new g.c(null));
    this.ofh = bj.T((List)ab.aivy);
    this.ofi = this.ofh;
    this.ofj = new LinkedList();
    this.ofk = ((List)new ArrayList());
    if (!((Collection)this.ofd).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        byE();
      }
      this.ofo = new HashSet();
      AppMethodBeat.o(240368);
      return;
    }
  }
  
  public final void HP(String paramString)
  {
    AppMethodBeat.i(240414);
    s.u(paramString, "templateId");
    Log.i("MicroMsg.SnsTemplate.SnsTemplateListState", "updateCurSelectTemplate: " + paramString + ", curSelectedId: " + byD());
    Iterator localIterator = ((Iterable)byC()).iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (s.p(((e)localObject).hIQ, byD()))
      {
        localObject = (e)localObject;
        if (localObject != null) {
          ((e)localObject).oeN.setValue(Boolean.FALSE);
        }
        localIterator = ((Iterable)byC()).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = localIterator.next();
        } while (!s.p(((e)localObject).hIQ, paramString));
      }
    }
    for (paramString = (String)localObject;; paramString = null)
    {
      paramString = (e)paramString;
      if (paramString != null)
      {
        paramString.oeN.setValue(Boolean.TRUE);
        this.ofm = paramString;
      }
      AppMethodBeat.o(240414);
      return;
      localObject = null;
      break;
    }
  }
  
  public final void bK(List<? extends MJTemplateInfo> paramList)
  {
    AppMethodBeat.i(240393);
    s.u(paramList, "list");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject4;
    label154:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (MJTemplateInfo)localObject2;
      localObject4 = (Iterable)this.ofd;
      if ((!(localObject4 instanceof Collection)) || (!((Collection)localObject4).isEmpty()))
      {
        localObject4 = ((Iterable)localObject4).iterator();
        do
        {
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
        } while (!s.p(((fxr)((Iterator)localObject4).next()).id, ((MJTemplateInfo)localObject3).getTemplateID()));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label154;
        }
        paramList.add(localObject2);
        break;
      }
    }
    paramList = (Iterable)paramList;
    Object localObject2 = (Collection)new ArrayList(p.a(paramList, 10));
    Object localObject3 = paramList.iterator();
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (MJTemplateInfo)((Iterator)localObject3).next();
      localObject1 = ((Iterable)this.ofk).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        paramList = ((Iterator)localObject1).next();
      } while (!s.p(((e.e)paramList).hIQ, ((MJTemplateInfo)localObject4).getTemplateID()));
      for (;;)
      {
        localObject1 = (e.e)paramList;
        paramList = (List<? extends MJTemplateInfo>)localObject1;
        if (localObject1 == null)
        {
          paramList = e.e.oeR;
          s.u(localObject4, "template");
          paramList = ((MJTemplateInfo)localObject4).getTemplateID();
          s.s(paramList, "template.templateID");
          localObject1 = ((MJTemplateInfo)localObject4).getDisplayName();
          s.s(localObject1, "template.displayName");
          String str = ((MJTemplateInfo)localObject4).getThumbnailURL();
          s.s(str, "template.thumbnailURL");
          paramList = e.e.a.a(paramList, (String)localObject1, str, ((MJTemplateInfo)localObject4).getMinimumiOSSDKVersion(), ((MJTemplateInfo)localObject4).getMinimumAndroidSDKVersion());
        }
        ((Collection)localObject2).add(paramList);
        break;
        paramList = null;
      }
    }
    bL((List)localObject2);
    AppMethodBeat.o(240393);
  }
  
  public final void bL(List<e.e> paramList)
  {
    AppMethodBeat.i(240397);
    s.u(paramList, "list");
    if (paramList.isEmpty()) {
      Log.w("MicroMsg.SnsTemplate.SnsTemplateListState", "empty template list");
    }
    for (;;)
    {
      List localList = this.ofk;
      localList.clear();
      localList.addAll((Collection)paramList);
      byE();
      AppMethodBeat.o(240397);
      return;
      this.ofl = true;
    }
  }
  
  public final void bM(List<Integer> paramList)
  {
    AppMethodBeat.i(240423);
    s.u(paramList, "visibleItemIdx");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      int i = ((Number)((Iterator)localObject1).next()).intValue();
      paramList.add((e)p.ae(byC(), i));
    }
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof e.e)) {
        paramList.add(localObject2);
      }
    }
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      localObject1 = ((e.e)paramList.next()).hIQ;
      if (!this.ofo.contains(localObject1))
      {
        localObject2 = this.ofn;
        if (localObject2 != null) {
          ((b)localObject2).HB((String)localObject1);
        }
        this.ofo.add(localObject1);
      }
    }
    AppMethodBeat.o(240423);
  }
  
  public final List<e> byC()
  {
    AppMethodBeat.i(240375);
    List localList = (List)((bm)this.ofi).getValue();
    AppMethodBeat.o(240375);
    return localList;
  }
  
  public final String byD()
  {
    e locale = this.ofm;
    if (locale == null) {
      return "";
    }
    return locale.hIQ;
  }
  
  public final void byE()
  {
    AppMethodBeat.i(240407);
    Log.i("MicroMsg.SnsTemplate.SnsTemplateListState", "updateTemplateList");
    Object localObject1 = this.ofh;
    Object localObject2 = (List)new ArrayList();
    Log.i("MicroMsg.SnsTemplate.SnsTemplateListState", s.X("updateTemplateList defaultTemplateList: ", Integer.valueOf(this.ofd.size())));
    Object localObject4 = (Iterable)this.ofd;
    Object localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
    localObject4 = ((Iterable)localObject4).iterator();
    Object localObject5;
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (fxr)((Iterator)localObject4).next();
      e.e.a locala = e.e.oeR;
      ((Collection)localObject3).add(e.e.a.a((fxr)localObject5));
    }
    ((List)localObject2).addAll((Collection)localObject3);
    int i;
    if (!this.ofl)
    {
      Log.i("MicroMsg.SnsTemplate.SnsTemplateListState", "add loading item");
      i = 0;
      while (i < 5)
      {
        ((List)localObject2).add(new e.f());
        i += 1;
      }
    }
    Log.i("MicroMsg.SnsTemplate.SnsTemplateListState", "add homepage item");
    ((List)localObject2).addAll((Collection)this.ofk);
    ((List)localObject2).add(e.c.oeP);
    localObject3 = ah.aiuX;
    localObject4 = (Iterable)localObject2;
    localObject2 = new HashSet();
    localObject3 = new ArrayList();
    localObject4 = ((Iterable)localObject4).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = ((Iterator)localObject4).next();
      if (((HashSet)localObject2).add(((e)localObject5).hIQ)) {
        ((ArrayList)localObject3).add(localObject5);
      }
    }
    ((an)localObject1).setValue((List)localObject3);
    if (((CharSequence)byD()).length() == 0)
    {
      i = 1;
      if (i != 0)
      {
        Log.i("MicroMsg.SnsTemplate.SnsTemplateListState", "updateTemplateList curSelectedItemId is null");
        localObject2 = ((Iterable)byC()).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject2).next();
        } while (!((e)localObject1).nXg);
      }
    }
    for (;;)
    {
      localObject1 = (e)localObject1;
      if (localObject1 != null) {
        HP(((e)localObject1).hIQ);
      }
      AppMethodBeat.o(240407);
      return;
      i = 0;
      break;
      localObject1 = null;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListState$IReporter;", "", "onTemplateExposed", "", "templateId", "", "onTemplateSelected", "templatePos", "", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void HB(String paramString);
    
    public abstract void aI(String paramString, int paramInt);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    d(e parame, g paramg, d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(240392);
      paramObject = (d)new d(this.ofp, this.ofq, paramd);
      AppMethodBeat.o(240392);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240387);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240387);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Log.i("MicroMsg.SnsTemplate.SnsTemplateListState", s.X("onTemplateSelected: ", this.ofp.hIQ));
        paramObject = this.ofq.oeu;
        String str = this.ofp.hIQ;
        this.label = 1;
        if (paramObject.invoke(str, this) == locala)
        {
          AppMethodBeat.o(240387);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      this.ofq.HP(this.ofp.hIQ);
      paramObject = ah.aiuX;
      AppMethodBeat.o(240387);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.sns.a.a.g
 * JD-Core Version:    0.7.0.1
 */