package com.tencent.mm.mj_template.album_template.multi_template.a;

import androidx.compose.runtime.an;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import com.tencent.maas.model.MJTemplateInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mm.mj_template.album_template.multi_template.a.b.e;>;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/album_template/multi_template/widget/TemplateListState;", "", "asyncJobScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "_showMusicSelector", "Landroidx/compose/runtime/MutableState;", "", "_templateChanged", "_templateListState", "", "Lcom/tencent/mm/mj_template/album_template/multi_template/widget/MaasTemplateListData;", "curSelectedId", "", "exportTemplateId", "getExportTemplateId", "()Ljava/lang/String;", "onSelectedTemplateChanged", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "templateId", "isBlank", "Lkotlin/coroutines/Continuation;", "getOnSelectedTemplateChanged", "()Lkotlin/jvm/functions/Function3;", "setOnSelectedTemplateChanged", "(Lkotlin/jvm/functions/Function3;)V", "Lkotlin/jvm/functions/Function3;", "reporter", "Lcom/tencent/mm/mj_template/album_template/multi_template/widget/TemplateListState$IReporter;", "getReporter", "()Lcom/tencent/mm/mj_template/album_template/multi_template/widget/TemplateListState$IReporter;", "setReporter", "(Lcom/tencent/mm/mj_template/album_template/multi_template/widget/TemplateListState$IReporter;)V", "showMusicSelector", "getShowMusicSelector", "()Z", "showMusicSelector$delegate", "Landroidx/compose/runtime/MutableState;", "templateChanged", "getTemplateChanged", "templateChanged$delegate", "templateTemplate", "getTemplateTemplate$plugin_mj_template_release", "()Ljava/util/List;", "templateTemplate$delegate", "isMaasExport", "onTemplateListChange", "", "list", "Lcom/tencent/mm/mj_template/album_template/multi_template/widget/MaasTemplateListData$MaasTemplate;", "onTemplateListChangeMJ", "Lcom/tencent/maas/model/MJTemplateInfo;", "onTemplateSwitch", "template", "onVisibleListChanged", "visibleItemIdx", "", "Companion", "IReporter", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d.a nXp;
  private final an nXA;
  private final aq nXq;
  private final an<List<b>> nXr;
  private final an nXs;
  public b nXt;
  public String nXu;
  public final String nXv;
  public q<? super String, ? super Boolean, ? super kotlin.d.d<? super Boolean>, ? extends Object> nXw;
  private final an<Boolean> nXx;
  public final an nXy;
  private final an<Boolean> nXz;
  
  static
  {
    AppMethodBeat.i(240699);
    nXp = new d.a((byte)0);
    AppMethodBeat.o(240699);
  }
  
  public d(aq paramaq)
  {
    AppMethodBeat.i(240678);
    this.nXq = paramaq;
    paramaq = b.c.nXk;
    paramaq.nXf.setValue(Boolean.TRUE);
    ah localah = ah.aiuX;
    this.nXr = bj.T(p.listOf(new b[] { (b)paramaq, (b)new b.d(), (b)new b.d(), (b)new b.d(), (b)new b.d() }));
    this.nXs = this.nXr;
    this.nXu = b.c.nXk.hIQ;
    this.nXv = "";
    this.nXw = ((q)new d.c(null));
    this.nXx = bj.T(Boolean.FALSE);
    this.nXy = this.nXx;
    this.nXz = bj.T(Boolean.FALSE);
    this.nXA = this.nXz;
    AppMethodBeat.o(240678);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(240724);
    s.u(paramb, "template");
    if (!paramb.nXg)
    {
      Log.i("MaasMultiTemplate.TemplateList", "unselectable item " + paramb + " clicked, no need to update");
      AppMethodBeat.o(240724);
      return;
    }
    if (s.p(this.nXu, paramb.hIQ))
    {
      Log.i("MaasMultiTemplate.TemplateList", paramb + " clicked, no need to update");
      AppMethodBeat.o(240724);
      return;
    }
    j.a(this.nXq, null, null, (m)new d(paramb, this, null), 3);
    AppMethodBeat.o(240724);
  }
  
  public final void bK(List<? extends MJTemplateInfo> paramList)
  {
    AppMethodBeat.i(240716);
    s.u(paramList, "list");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (MJTemplateInfo)((Iterator)localObject1).next();
      String str1 = ((MJTemplateInfo)localObject2).getTemplateID();
      s.s(str1, "it.templateID");
      String str2 = ((MJTemplateInfo)localObject2).getThumbnailURL();
      s.s(str2, "it.thumbnailURL");
      localObject2 = ((MJTemplateInfo)localObject2).getDisplayName();
      s.s(localObject2, "it.displayName");
      paramList.add(new b.e(str1, str2, (String)localObject2));
    }
    bL((List)paramList);
    AppMethodBeat.o(240716);
  }
  
  public final void bL(List<b.e> paramList)
  {
    AppMethodBeat.i(240720);
    s.u(paramList, "list");
    if (paramList.isEmpty())
    {
      Log.w("MaasMultiTemplate.TemplateList", "empty template list");
      AppMethodBeat.o(240720);
      return;
    }
    paramList = (Iterable)paramList;
    Object localObject2 = (Collection)new ArrayList(p.a(paramList, 10));
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      b.e locale = (b.e)localIterator.next();
      localObject1 = ((Iterable)bwY()).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        paramList = ((Iterator)localObject1).next();
      } while (!s.p(((b)paramList).hIQ, locale.hIQ));
      for (;;)
      {
        localObject1 = (b)paramList;
        paramList = (List<b.e>)localObject1;
        if (localObject1 == null) {
          paramList = (b)locale;
        }
        ((Collection)localObject2).add(paramList);
        break;
        paramList = null;
      }
    }
    localObject2 = (List)localObject2;
    paramList = this.nXr;
    Object localObject1 = (List)new ArrayList();
    ((List)localObject1).add(b.c.nXk);
    ((List)localObject1).addAll((Collection)localObject2);
    localObject2 = ah.aiuX;
    paramList.setValue(localObject1);
    localObject1 = ((Iterable)bwY()).iterator();
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      paramList = ((Iterator)localObject1).next();
    } while (!s.p(((b)paramList).hIQ, this.nXu));
    for (;;)
    {
      if (paramList == null)
      {
        paramList = (b)p.oL(bwY());
        if (paramList != null) {
          a(paramList);
        }
      }
      AppMethodBeat.o(240720);
      return;
      paramList = null;
    }
  }
  
  public final void bM(List<Integer> paramList)
  {
    AppMethodBeat.i(240726);
    s.u(paramList, "visibleItemIdx");
    Iterator localIterator = ((Iterable)paramList).iterator();
    label70:
    label113:
    label116:
    while (localIterator.hasNext())
    {
      int i = ((Number)localIterator.next()).intValue();
      paramList = (b)p.ae(bwY(), i);
      if (paramList != null)
      {
        if (!paramList.nXh)
        {
          i = 1;
          if (i == 0) {
            break label113;
          }
        }
        for (;;)
        {
          if (paramList == null) {
            break label116;
          }
          b localb = this.nXt;
          if (localb != null) {
            localb.HB(paramList.hIQ);
          }
          paramList.nXh = true;
          break;
          i = 0;
          break label70;
          paramList = null;
        }
      }
    }
    AppMethodBeat.o(240726);
  }
  
  public final List<b> bwY()
  {
    AppMethodBeat.i(240702);
    List localList = (List)((bm)this.nXs).getValue();
    AppMethodBeat.o(240702);
    return localList;
  }
  
  public final boolean bwZ()
  {
    AppMethodBeat.i(240708);
    boolean bool = ((Boolean)((bm)this.nXA).getValue()).booleanValue();
    AppMethodBeat.o(240708);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/album_template/multi_template/widget/TemplateListState$IReporter;", "", "onTemplateExposed", "", "templateId", "", "onTemplateSelected", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void HA(String paramString);
    
    public abstract void HB(String paramString);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    d(b paramb, d paramd, kotlin.d.d<? super d> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240700);
      paramObject = (kotlin.d.d)new d(this.nXB, jdField_this, paramd);
      AppMethodBeat.o(240700);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      Object localObject1 = null;
      AppMethodBeat.i(240697);
      Object localObject3 = a.aiwj;
      Object localObject2;
      Boolean localBoolean;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240697);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.nXB;
        if ((paramObject instanceof b.e))
        {
          paramObject = jdField_this.nXw;
          localObject2 = this.nXB.hIQ;
          localBoolean = Boolean.FALSE;
          this.label = 1;
          localObject2 = paramObject.invoke(localObject2, localBoolean, this);
          paramObject = localObject2;
          if (localObject2 == localObject3)
          {
            AppMethodBeat.o(240697);
            return localObject3;
          }
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        if (!((Boolean)paramObject).booleanValue())
        {
          Log.e("MaasMultiTemplate.TemplateList", "template change error");
          paramObject = ah.aiuX;
          AppMethodBeat.o(240697);
          return paramObject;
        }
        d.a(jdField_this).setValue(Boolean.TRUE);
        paramObject = (Iterable)jdField_this.bwY();
        localObject2 = jdField_this;
        localObject3 = paramObject.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          paramObject = ((Iterator)localObject3).next();
          if (s.p(((b)paramObject).hIQ, d.b((d)localObject2)))
          {
            label240:
            paramObject = (b)paramObject;
            if (paramObject != null) {
              break label680;
            }
            paramObject = null;
            if (paramObject == null) {
              Log.e("MaasMultiTemplate.TemplateList", s.X(d.b(jdField_this), " not in this data list"));
            }
            paramObject = (Iterable)jdField_this.bwY();
            localObject2 = this.nXB;
            localObject3 = paramObject.iterator();
            do
            {
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              paramObject = ((Iterator)localObject3).next();
            } while (!s.p(((b)paramObject).hIQ, ((b)localObject2).hIQ));
          }
        }
      }
      for (;;)
      {
        paramObject = (b)paramObject;
        if (paramObject != null) {
          break label758;
        }
        paramObject = localObject1;
        if (paramObject == null) {
          Log.e("MaasMultiTemplate.TemplateList", this.nXB + " not in this data list");
        }
        d.a(jdField_this, this.nXB.hIQ);
        d.c(jdField_this).setValue(Boolean.TRUE);
        paramObject = jdField_this.nXt;
        if (paramObject != null) {
          paramObject.HA(d.b(jdField_this));
        }
        Log.i("MaasMultiTemplate.TemplateList", s.X("current selected template id set to ", d.b(jdField_this)));
        paramObject = ah.aiuX;
        AppMethodBeat.o(240697);
        return paramObject;
        if ((paramObject instanceof b.c))
        {
          paramObject = jdField_this.nXw;
          localObject2 = this.nXB.hIQ;
          localBoolean = Boolean.TRUE;
          this.label = 2;
          localObject2 = paramObject.invoke(localObject2, localBoolean, this);
          paramObject = localObject2;
          if (localObject2 == localObject3)
          {
            AppMethodBeat.o(240697);
            return localObject3;
            ResultKt.throwOnFailure(paramObject);
          }
          if (!((Boolean)paramObject).booleanValue())
          {
            Log.e("MaasMultiTemplate.TemplateList", "template change error");
            paramObject = ah.aiuX;
            AppMethodBeat.o(240697);
            return paramObject;
          }
          d.a(jdField_this).setValue(Boolean.FALSE);
          break;
        }
        if (!(paramObject instanceof b.b)) {
          break;
        }
        paramObject = jdField_this.nXw;
        localObject2 = this.nXB.hIQ;
        localBoolean = Boolean.TRUE;
        this.label = 3;
        localObject2 = paramObject.invoke(localObject2, localBoolean, this);
        paramObject = localObject2;
        if (localObject2 == localObject3)
        {
          AppMethodBeat.o(240697);
          return localObject3;
          ResultKt.throwOnFailure(paramObject);
        }
        if (!((Boolean)paramObject).booleanValue())
        {
          Log.e("MaasMultiTemplate.TemplateList", "template change error");
          paramObject = ah.aiuX;
          AppMethodBeat.o(240697);
          return paramObject;
        }
        d.a(jdField_this).setValue(Boolean.FALSE);
        break;
        paramObject = null;
        break label240;
        label680:
        localObject2 = jdField_this;
        if (((Boolean)paramObject.nXf.getValue()).booleanValue())
        {
          paramObject.nXf.setValue(Boolean.FALSE);
          Log.i("MaasMultiTemplate.TemplateList", s.X(d.b((d)localObject2), " selected set to false"));
        }
        for (;;)
        {
          paramObject = ah.aiuX;
          break;
          Log.w("MaasMultiTemplate.TemplateList", s.X(d.b((d)localObject2), " not been selected"));
        }
        paramObject = null;
      }
      label758:
      if (((Boolean)paramObject.nXf.getValue()).booleanValue()) {
        Log.w("MaasMultiTemplate.TemplateList", s.X(paramObject.hIQ, " been selected"));
      }
      for (;;)
      {
        paramObject = ah.aiuX;
        break;
        paramObject.nXf.setValue(Boolean.TRUE);
        Log.i("MaasMultiTemplate.TemplateList", s.X(paramObject.hIQ, " selected set to true"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.multi_template.a.d
 * JD-Core Version:    0.7.0.1
 */