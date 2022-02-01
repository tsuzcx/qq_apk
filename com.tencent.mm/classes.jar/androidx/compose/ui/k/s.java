package androidx.compose.ui.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d;
import kotlin.g.a.m;
import kotlin.g.b.aa;
import kotlin.g.b.ai;
import kotlin.g.b.z;
import kotlin.l.o;

@Metadata(d1={""}, d2={"<set-?>", "Landroidx/compose/ui/semantics/CollectionInfo;", "collectionInfo", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "getCollectionInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", "setCollectionInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/CollectionInfo;)V", "collectionInfo$delegate", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/compose/ui/semantics/CollectionItemInfo;", "collectionItemInfo", "getCollectionItemInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionItemInfo;", "setCollectionItemInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/CollectionItemInfo;)V", "collectionItemInfo$delegate", "value", "", "contentDescription", "getContentDescription", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", "setContentDescription", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/lang/String;)V", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "customActions", "getCustomActions", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/util/List;", "setCustomActions", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/util/List;)V", "customActions$delegate", "Landroidx/compose/ui/text/AnnotatedString;", "editableText", "getEditableText", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", "setEditableText", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/text/AnnotatedString;)V", "editableText$delegate", "", "focused", "getFocused", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", "setFocused", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Z)V", "focused$delegate", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "horizontalScrollAxisRange", "getHorizontalScrollAxisRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", "setHorizontalScrollAxisRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/ScrollAxisRange;)V", "horizontalScrollAxisRange$delegate", "Landroidx/compose/ui/text/input/ImeAction;", "imeAction", "getImeAction", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", "setImeAction-4L7nppU", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;I)V", "imeAction$delegate", "Landroidx/compose/ui/semantics/LiveRegionMode;", "liveRegion", "getLiveRegion", "setLiveRegion-hR3wRGc", "liveRegion$delegate", "paneTitle", "getPaneTitle", "setPaneTitle", "paneTitle$delegate", "Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "progressBarRangeInfo", "getProgressBarRangeInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "setProgressBarRangeInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/ProgressBarRangeInfo;)V", "progressBarRangeInfo$delegate", "Landroidx/compose/ui/semantics/Role;", "role", "getRole", "setRole-kuIjeqM", "role$delegate", "selected", "getSelected", "setSelected", "selected$delegate", "stateDescription", "getStateDescription", "setStateDescription", "stateDescription$delegate", "testTag", "getTestTag", "setTestTag", "testTag$delegate", "text", "getText", "setText", "Landroidx/compose/ui/text/TextRange;", "textSelectionRange", "getTextSelectionRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", "setTextSelectionRange-FDrldGo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;J)V", "textSelectionRange$delegate", "Landroidx/compose/ui/state/ToggleableState;", "toggleableState", "getToggleableState", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/state/ToggleableState;", "setToggleableState", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/state/ToggleableState;)V", "toggleableState$delegate", "verticalScrollAxisRange", "getVerticalScrollAxisRange", "setVerticalScrollAxisRange", "verticalScrollAxisRange$delegate", "ActionPropertyKey", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/compose/ui/semantics/AccessibilityAction;", "T", "Lkotlin/Function;", "name", "throwSemanticsGetNotSupported", "()Ljava/lang/Object;", "collapse", "", "label", "action", "Lkotlin/Function0;", "copyText", "cutText", "dialog", "disabled", "dismiss", "error", "description", "expand", "getTextLayoutResult", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/TextLayoutResult;", "heading", "indexForKey", "mapping", "", "", "invisibleToUser", "onClick", "onLongClick", "password", "pasteText", "popup", "scrollBy", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "x", "y", "scrollToIndex", "selectableGroup", "setProgress", "setSelection", "Lkotlin/Function3;", "startIndex", "endIndex", "traversalMode", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class s
{
  private static final t aYf;
  private static final t aYg;
  private static final t aYh;
  private static final t aYi;
  private static final t aYj;
  private static final t aYk;
  private static final t aYl;
  private static final t aYm;
  private static final t aYn;
  private static final t aYo;
  private static final t aYp;
  private static final t aYq;
  private static final t aYr;
  private static final t aYs;
  private static final t aYt;
  private static final t aYu;
  private static final t aYv;
  
  static
  {
    AppMethodBeat.i(205629);
    aYe = new o[] { (o)ai.a((z)new aa(s.class, "stateDescription", "getStateDescription(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), (o)ai.a((z)new aa(s.class, "progressBarRangeInfo", "getProgressBarRangeInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", 1)), (o)ai.a((z)new aa(s.class, "paneTitle", "getPaneTitle(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), (o)ai.a((z)new aa(s.class, "liveRegion", "getLiveRegion(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), (o)ai.a((z)new aa(s.class, "focused", "getFocused(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), (o)ai.a((z)new aa(s.class, "horizontalScrollAxisRange", "getHorizontalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1)), (o)ai.a((z)new aa(s.class, "verticalScrollAxisRange", "getVerticalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1)), (o)ai.a((z)new aa(s.class, "role", "getRole(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), (o)ai.a((z)new aa(s.class, "testTag", "getTestTag(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), (o)ai.a((z)new aa(s.class, "editableText", "getEditableText(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1)), (o)ai.a((z)new aa(s.class, "textSelectionRange", "getTextSelectionRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", 1)), (o)ai.a((z)new aa(s.class, "imeAction", "getImeAction(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), (o)ai.a((z)new aa(s.class, "selected", "getSelected(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), (o)ai.a((z)new aa(s.class, "collectionInfo", "getCollectionInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", 1)), (o)ai.a((z)new aa(s.class, "collectionItemInfo", "getCollectionItemInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionItemInfo;", 1)), (o)ai.a((z)new aa(s.class, "toggleableState", "getToggleableState(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/state/ToggleableState;", 1)), (o)ai.a((z)new aa(s.class, "customActions", "getCustomActions(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/util/List;", 1)) };
    Object localObject = r.aXu;
    aYf = r.Ag();
    localObject = r.aXu;
    aYg = r.Ah();
    localObject = r.aXu;
    aYh = r.Ai();
    localObject = r.aXu;
    aYi = r.Ao();
    localObject = r.aXu;
    aYj = r.Ap();
    localObject = r.aXu;
    aYk = r.Ar();
    localObject = r.aXu;
    aYl = r.As();
    localObject = r.aXu;
    aYm = r.At();
    localObject = r.aXu;
    aYn = r.Au();
    localObject = r.aXu;
    aYo = r.Aw();
    localObject = r.aXu;
    aYp = r.Ax();
    localObject = r.aXu;
    aYq = r.Ay();
    localObject = r.aXu;
    aYr = r.Az();
    localObject = r.aXu;
    aYs = r.Ak();
    localObject = r.aXu;
    aYt = r.Al();
    localObject = r.aXu;
    aYu = r.AA();
    localObject = i.aWM;
    aYv = i.zT();
    AppMethodBeat.o(205629);
  }
  
  public static final void a(u paramu)
  {
    AppMethodBeat.i(205513);
    kotlin.g.b.s.u(paramu, "<this>");
    r localr = r.aXu;
    paramu.a(r.An(), ah.aiuX);
    AppMethodBeat.o(205513);
  }
  
  public static final void a(u paramu, int paramInt)
  {
    AppMethodBeat.i(205527);
    kotlin.g.b.s.u(paramu, "$this$role");
    aYm.a(paramu, aYe[7], g.df(paramInt));
    AppMethodBeat.o(205527);
  }
  
  public static final void a(u paramu, b paramb)
  {
    AppMethodBeat.i(205552);
    kotlin.g.b.s.u(paramu, "<this>");
    kotlin.g.b.s.u(paramb, "<set-?>");
    aYs.a(paramu, aYe[13], paramb);
    AppMethodBeat.o(205552);
  }
  
  public static final void a(u paramu, h paramh)
  {
    AppMethodBeat.i(205518);
    kotlin.g.b.s.u(paramu, "<this>");
    kotlin.g.b.s.u(paramh, "<set-?>");
    aYk.a(paramu, aYe[5], paramh);
    AppMethodBeat.o(205518);
  }
  
  public static final void a(u paramu, androidx.compose.ui.m.a parama)
  {
    AppMethodBeat.i(205536);
    kotlin.g.b.s.u(paramu, "<this>");
    kotlin.g.b.s.u(parama, "value");
    r localr = r.aXu;
    paramu.a(r.Av(), p.listOf(parama));
    AppMethodBeat.o(205536);
  }
  
  public static final void a(u paramu, String paramString)
  {
    AppMethodBeat.i(205507);
    kotlin.g.b.s.u(paramu, "<this>");
    kotlin.g.b.s.u(paramString, "value");
    r localr = r.aXu;
    paramu.a(r.Af(), p.listOf(paramString));
    AppMethodBeat.o(205507);
  }
  
  public static final void a(u paramu, String paramString, kotlin.g.a.a<Boolean> parama)
  {
    AppMethodBeat.i(205585);
    kotlin.g.b.s.u(paramu, "<this>");
    i locali = i.aWM;
    paramu.a(i.zG(), new a(paramString, (d)parama));
    AppMethodBeat.o(205585);
  }
  
  public static final void a(u paramu, kotlin.g.a.b<Object, Integer> paramb)
  {
    AppMethodBeat.i(205562);
    kotlin.g.b.s.u(paramu, "<this>");
    kotlin.g.b.s.u(paramb, "mapping");
    r localr = r.aXu;
    paramu.a(r.AD(), paramb);
    AppMethodBeat.o(205562);
  }
  
  public static final void a(u paramu, boolean paramBoolean)
  {
    AppMethodBeat.i(205543);
    kotlin.g.b.s.u(paramu, "<this>");
    aYr.a(paramu, aYe[12], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(205543);
  }
  
  public static final <T extends d<? extends Boolean>> t<a<T>> an(String paramString)
  {
    AppMethodBeat.i(205501);
    kotlin.g.b.s.u(paramString, "name");
    paramString = new t(paramString, (m)a.aYw);
    AppMethodBeat.o(205501);
    return paramString;
  }
  
  public static final void b(u paramu)
  {
    AppMethodBeat.i(205569);
    kotlin.g.b.s.u(paramu, "<this>");
    r localr = r.aXu;
    paramu.a(r.Aj(), ah.aiuX);
    AppMethodBeat.o(205569);
  }
  
  public static final void b(u paramu, h paramh)
  {
    AppMethodBeat.i(205522);
    kotlin.g.b.s.u(paramu, "<this>");
    kotlin.g.b.s.u(paramh, "<set-?>");
    aYl.a(paramu, aYe[6], paramh);
    AppMethodBeat.o(205522);
  }
  
  public static final void b(u paramu, String paramString, kotlin.g.a.a<Boolean> parama)
  {
    AppMethodBeat.i(205596);
    kotlin.g.b.s.u(paramu, "<this>");
    i locali = i.aWM;
    paramu.a(i.zH(), new a(paramString, (d)parama));
    AppMethodBeat.o(205596);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/semantics/AccessibilityAction;", "T", "Lkotlin/Function;", "", "parentValue", "childValue"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements m<a<T>, a<T>, a<T>>
  {
    public static final a aYw;
    
    static
    {
      AppMethodBeat.i(205478);
      aYw = new a();
      AppMethodBeat.o(205478);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.k.s
 * JD-Core Version:    0.7.0.1
 */