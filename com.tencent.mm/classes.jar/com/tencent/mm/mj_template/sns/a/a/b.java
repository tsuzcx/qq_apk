package com.tencent.mm.mj_template.sns.a.a;

import androidx.compose.runtime.an;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/sns/compose/widget/MoreTemplateBottomSheetState;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "_canConfirmState", "Landroidx/compose/runtime/MutableState;", "", "_snsMoreTemplateTabData", "", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsMoreTemplateTabData;", "canConfirm", "getCanConfirm$plugin_mj_template_release", "()Z", "canConfirm$delegate", "Landroidx/compose/runtime/MutableState;", "curSelectTemplateInfo", "Lcom/tencent/mm/mj_template/sns/compose/widget/SnsTemplateListData$SnsTemplateListDataTemplate;", "initialSelectedId", "", "onPanelClose", "Lkotlin/Function0;", "", "getOnPanelClose", "()Lkotlin/jvm/functions/Function0;", "setOnPanelClose", "(Lkotlin/jvm/functions/Function0;)V", "onSelectedTemplateChanged", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "templateId", "Lkotlin/coroutines/Continuation;", "getOnSelectedTemplateChanged", "()Lkotlin/jvm/functions/Function2;", "setOnSelectedTemplateChanged", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "onTemplateSelectConfirmed", "Lkotlin/Function1;", "getOnTemplateSelectConfirmed", "()Lkotlin/jvm/functions/Function1;", "setOnTemplateSelectConfirmed", "(Lkotlin/jvm/functions/Function1;)V", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "snsMoreTemplateTabData", "getSnsMoreTemplateTabData$plugin_mj_template_release", "()Ljava/util/List;", "snsMoreTemplateTabData$delegate", "onCategoryChanged", "list", "onClosed", "onConfirmed", "onTemplateSelected", "setInitialSelectId", "updateInitialItemSelectedState", "Companion", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a oer;
  final an oeA;
  public kotlin.g.a.a<ah> oes;
  public kotlin.g.a.b<? super e.e, ah> oet;
  public m<? super String, ? super d<? super Boolean>, ? extends Object> oeu;
  private an<List<c>> oev;
  private final an oew;
  public String oex;
  public e.e oey;
  private an<Boolean> oez;
  final aq scope;
  
  static
  {
    AppMethodBeat.i(240376);
    oer = new b.a((byte)0);
    AppMethodBeat.o(240376);
  }
  
  public b(aq paramaq)
  {
    AppMethodBeat.i(240363);
    this.scope = paramaq;
    this.oes = ((kotlin.g.a.a)b.b.oeB);
    this.oet = ((kotlin.g.a.b)b.d.oeC);
    this.oeu = ((m)new b.c(null));
    this.oev = bj.T((List)ab.aivy);
    this.oew = this.oev;
    this.oex = "";
    this.oez = bj.T(Boolean.FALSE);
    this.oeA = this.oez;
    AppMethodBeat.o(240363);
  }
  
  public final List<c> byz()
  {
    AppMethodBeat.i(240382);
    List localList = (List)((bm)this.oew).getValue();
    AppMethodBeat.o(240382);
    return localList;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    e(b paramb, String paramString, d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(240309);
      paramObject = (d)new e(this.oeD, this.oad, paramd);
      AppMethodBeat.o(240309);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240305);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240305);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.oeD.oeu;
        localObject = this.oad;
        this.label = 1;
        localObject = paramObject.invoke(localObject, this);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(240305);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      if (((Boolean)paramObject).booleanValue())
      {
        paramObject = b.a(this.oeD);
        if (paramObject == null) {}
        for (paramObject = null;; paramObject = paramObject.hIQ)
        {
          localObject = ((Iterable)b.b(this.oeD).getValue()).iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label196;
          }
          ((Iterator)localObject).next();
          if (paramObject == null) {
            break;
          }
          AppMethodBeat.o(240305);
          throw null;
        }
        AppMethodBeat.o(240305);
        throw null;
      }
      Log.e("MicroMsg.SnsTemplate.MoreTemplateBottomSheetState", "onSelectedTemplateChanged error");
      label196:
      paramObject = ah.aiuX;
      AppMethodBeat.o(240305);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.sns.a.a.b
 * JD-Core Version:    0.7.0.1
 */