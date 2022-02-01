package androidx.compose.ui.m.c;

import android.content.Context;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.BaseInputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.a.b;
import kotlin.g.b.u;
import kotlin.o;
import kotlinx.coroutines.a.l;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "inputMethodManager", "Landroidx/compose/ui/text/input/InputMethodManager;", "(Landroid/view/View;Landroidx/compose/ui/text/input/InputMethodManager;)V", "baseInputConnection", "Landroid/view/inputmethod/BaseInputConnection;", "getBaseInputConnection", "()Landroid/view/inputmethod/BaseInputConnection;", "baseInputConnection$delegate", "Lkotlin/Lazy;", "editorHasFocus", "", "focusedRect", "Landroid/graphics/Rect;", "ic", "Landroidx/compose/ui/text/input/RecordingInputConnection;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "layoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onEditCommand", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/input/EditCommand;", "", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "showKeyboardChannel", "Lkotlinx/coroutines/channels/Channel;", "<set-?>", "Landroidx/compose/ui/text/input/TextFieldValue;", "state", "getState$ui_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "getView", "()Landroid/view/View;", "createInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "hideSoftwareKeyboard", "isEditorFocused", "keyboardVisibilityEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyFocusedRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "restartInput", "showSoftwareKeyboard", "startInput", "value", "stopInput", "updateState", "oldValue", "newValue", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  implements m
{
  private final i bdm;
  public boolean bdn;
  b<? super List<? extends d>, ah> bdo;
  b<? super f, ah> bdp;
  public r bdq;
  public g bdr;
  public n bds;
  final kotlin.j bdt;
  Rect bdu;
  private final kotlinx.coroutines.a.h<Boolean> bdv;
  final ViewTreeObserver.OnGlobalLayoutListener bdw;
  final View view;
  
  public t(View paramView)
  {
    this(paramView, (i)new j(localContext));
    AppMethodBeat.i(205290);
    AppMethodBeat.o(205290);
  }
  
  private t(View paramView, i parami)
  {
    AppMethodBeat.i(205285);
    this.view = paramView;
    this.bdm = parami;
    this.bdo = ((b)t.e.bdy);
    this.bdp = ((b)t.f.bdz);
    paramView = androidx.compose.ui.m.s.baA;
    this.bdq = new r("", androidx.compose.ui.m.s.su());
    paramView = g.bcE;
    this.bdr = g.Bs();
    this.bdt = kotlin.k.a(o.aiuH, (kotlin.g.a.a)new a(this));
    this.bdv = kotlinx.coroutines.a.k.a(-1, null, 6);
    this.bdw = ((ViewTreeObserver.OnGlobalLayoutListener)new d(this));
    this.view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(205258);
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.getRootView();
          if (paramAnonymousView != null)
          {
            paramAnonymousView = paramAnonymousView.getViewTreeObserver();
            if (paramAnonymousView != null) {
              paramAnonymousView.addOnGlobalLayoutListener(this.bdx.bdw);
            }
          }
        }
        AppMethodBeat.o(205258);
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(205257);
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.getRootView();
          if (paramAnonymousView != null)
          {
            paramAnonymousView = paramAnonymousView.getViewTreeObserver();
            if (paramAnonymousView != null) {
              paramAnonymousView.removeOnGlobalLayoutListener(this.bdx.bdw);
            }
          }
        }
        AppMethodBeat.o(205257);
      }
    });
    AppMethodBeat.o(205285);
  }
  
  public final Object h(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(205298);
    if ((paramd instanceof c))
    {
      localObject1 = (c)paramd;
      if ((((c)localObject1).label & 0x80000000) != 0) {
        ((c)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new c(this, paramd))
    {
      localObject2 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(205298);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Object localObject1 = this.bdv.kCW();
    t localt = this;
    kotlin.d.d<? super ah> locald = paramd;
    paramd = (kotlin.d.d<? super ah>)localObject1;
    locald.L$0 = localt;
    locald.Uf = paramd;
    locald.label = 1;
    Object localObject2 = paramd.aC(locald);
    if (localObject2 == locala)
    {
      AppMethodBeat.o(205298);
      return locala;
      localObject1 = (kotlinx.coroutines.a.j)paramd.Uf;
      localt = (t)paramd.L$0;
      ResultKt.throwOnFailure(localObject2);
      locald = paramd;
    }
    for (paramd = localObject2;; paramd = localObject2)
    {
      if (((Boolean)paramd).booleanValue())
      {
        boolean bool = ((Boolean)((kotlinx.coroutines.a.j)localObject1).next()).booleanValue();
        paramd = (Boolean)l.getOrNull-impl(localt.bdv.kCV());
        if (paramd == null) {}
        for (;;)
        {
          if (!bool) {
            break label278;
          }
          localt.bdm.C(localt.view);
          paramd = (kotlin.d.d<? super ah>)localObject1;
          break;
          bool = paramd.booleanValue();
        }
        label278:
        localt.bdm.f(localt.view.getWindowToken());
        paramd = (kotlin.d.d<? super ah>)localObject1;
        break;
      }
      paramd = ah.aiuX;
      AppMethodBeat.o(205298);
      return paramd;
      localObject1 = paramd;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/inputmethod/BaseInputConnection;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<BaseInputConnection>
  {
    a(t paramt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/text/input/TextInputServiceAndroid$createInputConnection$1", "Landroidx/compose/ui/text/input/InputEventCallback2;", "onEditCommands", "", "editCommands", "", "Landroidx/compose/ui/text/input/EditCommand;", "onImeAction", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "onImeAction-KlQnJC8", "(I)V", "onKeyEvent", "event", "Landroid/view/KeyEvent;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements h
  {
    public b(t paramt) {}
    
    public final void U(List<? extends d> paramList)
    {
      AppMethodBeat.i(205244);
      kotlin.g.b.s.u(paramList, "editCommands");
      this.bdx.bdo.invoke(paramList);
      AppMethodBeat.o(205244);
    }
    
    public final void dA(int paramInt)
    {
      AppMethodBeat.i(205249);
      this.bdx.bdp.invoke(f.dz(paramInt));
      AppMethodBeat.o(205249);
    }
    
    public final void h(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(205253);
      kotlin.g.b.s.u(paramKeyEvent, "event");
      ((BaseInputConnection)this.bdx.bdt.getValue()).sendKeyEvent(paramKeyEvent);
      AppMethodBeat.o(205253);
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    c(t paramt, kotlin.d.d<? super c> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(205237);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.bdx.h((kotlin.d.d)this);
      AppMethodBeat.o(205237);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    d(t paramt) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(205248);
      Rect localRect = this.bdx.bdu;
      if (localRect != null) {
        this.bdx.view.requestRectangleOnScreen(new Rect(localRect));
      }
      AppMethodBeat.o(205248);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.c.t
 * JD-Core Version:    0.7.0.1
 */