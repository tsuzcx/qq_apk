package com.tencent.mm.plugin.hld.d;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.k;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.candidate.ImeCandidateView;
import com.tencent.mm.plugin.hld.f.i;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.model.f;
import com.tencent.mm.plugin.hld.model.g;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/independ/ImeIndependentView;", "Lcom/tencent/mm/plugin/hld/api/IImeIndependView;", "Landroid/view/View$OnClickListener;", "()V", "TAG", "", "isSafetyKeyboard", "", "Ljava/lang/Boolean;", "keyboardShow", "mContext", "Landroid/app/Activity;", "mImeKeyboardActionListener", "Lcom/tencent/mm/plugin/hld/key/ImeKeyboardActionListener;", "mImeOption", "", "mInitializeSuccess", "mInputEditText", "Landroid/widget/EditText;", "mInputViewWidow", "Landroid/widget/PopupWindow;", "yOffset", "commitEmojiToWX", "", "emojiStr", "commitEnglishText", "text", "", "lastPending", "isEnglishSP", "commitText", "checkPairSymbol", "deleteText", "deleteLen", "getActionType", "getAroundText", "Lcom/tencent/mm/plugin/hld/api/ImeAroundText;", "num", "getBeforeText", "getContext", "Landroid/content/Context;", "getCurrentPackageName", "getCurrentSelection", "Lcom/tencent/mm/plugin/hld/api/ImeSelection;", "getImeKeyboardActionListener", "getInputEditText", "getResources", "Landroid/content/res/Resources;", "getSelectedText", "editText", "getTextAfterCursor", "getTextBeforeCursor", "getWechatScene", "handleActionKey", "handleNewLine", "ifActionNewLine", "ifUse", "init", "isKeyboardShow", "isWeChat", "moveSelection", "index", "onClick", "v", "Landroid/view/View;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onHide", "onShowView", "requestHideSelf", "flags", "reset", "setInputEditText", "activity", "supportWxEmoji", "switchToDefaultIme", "updateEnglishStrikeView", "lastPendingInput", "updateKeyboard", "updateSelection", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements View.OnClickListener, com.tencent.mm.plugin.hld.a.a
{
  private static int Jkv;
  private static boolean Jnd;
  private static com.tencent.mm.plugin.hld.e.a Jnf;
  private static boolean Jox;
  public static final a JqJ;
  private static PopupWindow JqK;
  private static int JqL;
  private static Boolean JqM;
  private static Activity mContext;
  private static EditText mInputEditText;
  
  static
  {
    AppMethodBeat.i(311803);
    JqJ = new a();
    AppMethodBeat.o(311803);
  }
  
  private static void fKp()
  {
    AppMethodBeat.i(311695);
    Object localObject = i.JyA;
    i.fOr();
    g.JuL.fLY();
    localObject = n.JvW;
    n.fMI();
    localObject = g.JuL;
    g.fMd();
    localObject = g.JuL;
    g.fMk();
    localObject = com.tencent.mm.plugin.hld.candidate.e.Jon;
    if (com.tencent.mm.plugin.hld.candidate.e.fKQ())
    {
      localObject = g.JuL;
      localObject = g.fMn();
      if (localObject != null) {
        ((ImeCandidateView)localObject).fKM();
      }
    }
    localObject = g.JuL;
    if (!g.fLX())
    {
      localObject = g.JuL;
      g.ij(getContext());
    }
    localObject = g.JuL;
    localObject = g.fMn();
    if (localObject != null) {
      ((ImeCandidateView)localObject).fKN();
    }
    AppMethodBeat.o(311695);
  }
  
  public static EditText fLA()
  {
    return mInputEditText;
  }
  
  public static boolean fLB()
  {
    return false;
  }
  
  public static void fLy()
  {
    AppMethodBeat.i(311672);
    if (mContext == null)
    {
      AppMethodBeat.o(311672);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = com.tencent.mm.plugin.hld.f.k.JyF;
    int i = com.tencent.mm.plugin.hld.f.k.iu((Context)mContext);
    int j = Jkv;
    Log.d("WxIme.ImeIndependentView", "yOffset:" + Jkv + " navigationBarHeight:" + i + " newYOffset:" + (j - i));
    localObject1 = JqK;
    Object localObject2;
    if ((localObject1 != null) && (((PopupWindow)localObject1).isShowing() == true))
    {
      i = 1;
      if (i != 0) {
        break label280;
      }
      Jnd = true;
      fKp();
      localObject1 = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.il(getContext());
      localObject1 = (d)com.tencent.mm.kernel.h.ax(d.class);
      if (localObject1 != null) {
        ((d)localObject1).fKE();
      }
      localObject1 = new int[2];
      localObject2 = mContext;
      s.checkNotNull(localObject2);
      localObject2 = ((Activity)localObject2).getCurrentFocus();
      if (localObject2 != null) {
        ((View)localObject2).getLocationInWindow((int[])localObject1);
      }
      localObject1 = JqK;
      if (localObject1 != null)
      {
        localObject2 = mContext;
        s.checkNotNull(localObject2);
        ((PopupWindow)localObject1).showAtLocation(((Activity)localObject2).getCurrentFocus(), 8388691, 0, 0);
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.hld.f.k.JyF;
      localObject1 = com.tencent.mm.plugin.hld.f.k.JyF;
      com.tencent.mm.plugin.hld.f.k.x(com.tencent.mm.plugin.hld.f.k.fOx());
      Log.i("WxIme.ImeIndependentView", "onWindowShown  " + l + ' ' + (System.currentTimeMillis() - l));
      AppMethodBeat.o(311672);
      return;
      i = 0;
      break;
      label280:
      Log.w("WxIme.ImeIndependentView", "onWindowShown last:" + Jnd + " why????");
      localObject1 = com.tencent.mm.plugin.hld.f.k.JyF;
      localObject1 = com.tencent.mm.plugin.hld.f.k.fOx();
      localObject2 = com.tencent.mm.plugin.hld.f.k.JyF;
      if (!s.p(localObject1, com.tencent.mm.plugin.hld.f.k.fOy()))
      {
        localObject1 = n.JvW;
        n.fMJ();
        localObject1 = f.JuH;
        f.fLV();
        localObject1 = g.JuL;
        localObject1 = g.fMn();
        if (localObject1 != null) {
          ((ImeCandidateView)localObject1).reset();
        }
        JqM = null;
        fKp();
      }
    }
  }
  
  public static void fLz()
  {
    AppMethodBeat.i(311756);
    Object localObject = n.JvW;
    n.fMO();
    localObject = n.JvW;
    n.fMT();
    localObject = g.JuL;
    localObject = g.fMn();
    if (localObject != null) {
      ((ImeCandidateView)localObject).fKN();
    }
    AppMethodBeat.o(311756);
  }
  
  private static Context getContext()
  {
    AppMethodBeat.i(311727);
    Context localContext = MMApplicationContext.getContext();
    s.s(localContext, "getContext()");
    AppMethodBeat.o(311727);
    return localContext;
  }
  
  private static Resources getResources()
  {
    AppMethodBeat.i(311742);
    Resources localResources = MMApplicationContext.getContext().getResources();
    s.s(localResources, "getContext().resources");
    AppMethodBeat.o(311742);
    return localResources;
  }
  
  private static CharSequence h(EditText paramEditText)
  {
    AppMethodBeat.i(311783);
    Editable localEditable = paramEditText.getText();
    int i = paramEditText.getSelectionStart();
    int j = paramEditText.getSelectionEnd();
    if (i > j)
    {
      paramEditText = localEditable.subSequence(j, i);
      AppMethodBeat.o(311783);
      return paramEditText;
    }
    paramEditText = localEditable.subSequence(i, j);
    AppMethodBeat.o(311783);
    return paramEditText;
  }
  
  private void init()
  {
    AppMethodBeat.i(311655);
    if (Jox)
    {
      AppMethodBeat.o(311655);
      return;
    }
    Jox = true;
    long l = System.currentTimeMillis();
    Jnf = new com.tencent.mm.plugin.hld.e.a(getContext(), getResources());
    Object localObject1 = com.tencent.mm.plugin.hld.f.k.JyF;
    com.tencent.mm.plugin.hld.f.k.sE(getResources().getConfiguration().orientation);
    localObject1 = f.JuH;
    f.init(getContext());
    localObject1 = g.JuL;
    localObject1 = getContext();
    Object localObject2 = Jnf;
    s.checkNotNull(localObject2);
    g.a((Context)localObject1, (c)localObject2);
    com.tencent.mm.plugin.hld.candidate.e.Jon.fKP();
    Log.i("WxIme.ImeIndependentView", "onCreate " + l + ' ' + (System.currentTimeMillis() - l) + ' ' + hashCode());
    g.JuL.ii(getContext());
    localObject1 = g.JuL;
    localObject1 = g.fMc();
    if (((View)localObject1).getParent() != null)
    {
      if (!(((View)localObject1).getParent() instanceof ViewGroup)) {
        break label426;
      }
      localObject2 = ((View)localObject1).getParent();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(311655);
        throw ((Throwable)localObject1);
      }
      ((ViewGroup)localObject2).removeView((View)localObject1);
    }
    for (;;)
    {
      localObject1 = g.JuL;
      localObject1 = new PopupWindow(g.fMc());
      ((PopupWindow)localObject1).setInputMethodMode(2);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject2 = l.JyV;
        ((PopupWindow)localObject1).setWindowLayoutType(l.fOG());
      }
      localObject2 = com.tencent.mm.plugin.hld.f.k.JyF;
      ((PopupWindow)localObject1).setWidth(com.tencent.mm.plugin.hld.f.k.getScreenWidth(getContext()));
      localObject2 = com.tencent.mm.plugin.hld.f.k.JyF;
      ((PopupWindow)localObject1).setHeight(com.tencent.mm.plugin.hld.f.k.iq(getContext()));
      ((PopupWindow)localObject1).setAnimationStyle(a.k.BottomToTopAnimation);
      JqK = (PopupWindow)localObject1;
      int i = aw.bf(getContext()).y;
      localObject1 = com.tencent.mm.plugin.hld.f.k.JyF;
      Jkv = i - com.tencent.mm.plugin.hld.f.k.iq(getContext());
      localObject1 = new StringBuilder("y:").append(aw.bf(getContext()).y).append(" statusBar:").append(aw.getStatusBarHeight(getContext())).append(" keyboardHeight:");
      localObject2 = com.tencent.mm.plugin.hld.f.k.JyF;
      Log.d("WxIme.ImeIndependentView", com.tencent.mm.plugin.hld.f.k.iq(getContext()));
      AppMethodBeat.o(311655);
      return;
      label426:
      Log.e("WxIme.ImeIndependentView", s.X("onCreateInputView ", ((View)localObject1).getParent()));
    }
  }
  
  public static void onHide()
  {
    AppMethodBeat.i(311709);
    Log.d("WxIme.ImeIndependentView", s.X("onWindowHidden ", Long.valueOf(System.currentTimeMillis())));
    Object localObject = JqK;
    if (localObject != null) {
      ((PopupWindow)localObject).dismiss();
    }
    localObject = n.JvW;
    n.fMJ();
    localObject = f.JuH;
    f.fLV();
    g.JuL.fMa();
    localObject = g.JuL;
    localObject = g.fMn();
    if (localObject != null) {
      ((ImeCandidateView)localObject).reset();
    }
    localObject = com.tencent.mm.plugin.hld.model.k.JvH;
    com.tencent.mm.plugin.hld.model.k.fMA();
    Jnd = false;
    JqM = null;
    AppMethodBeat.o(311709);
  }
  
  public final void Yi(int paramInt)
  {
    AppMethodBeat.i(311907);
    Object localObject = mInputEditText;
    if (localObject != null)
    {
      if (!Util.isNullOrNil(h((EditText)localObject))) {
        break label67;
      }
      paramInt = ((EditText)localObject).getSelectionStart();
      ((EditText)localObject).getText().delete(paramInt - 1, paramInt);
    }
    for (;;)
    {
      localObject = l.JyV;
      if (l.fOH())
      {
        localObject = g.JuL;
        g.fMk();
      }
      AppMethodBeat.o(311907);
      return;
      label67:
      paramInt = ((EditText)localObject).getSelectionStart();
      int i = ((EditText)localObject).getSelectionEnd();
      ((EditText)localObject).getText().delete(paramInt, i);
    }
  }
  
  public final void Yj(int paramInt)
  {
    AppMethodBeat.i(311921);
    EditText localEditText = mInputEditText;
    if (localEditText != null) {
      localEditText.setSelection(paramInt);
    }
    AppMethodBeat.o(311921);
  }
  
  public final com.tencent.mm.plugin.hld.a.e Yk(int paramInt)
  {
    AppMethodBeat.i(312038);
    Object localObject1 = null;
    EditText localEditText = mInputEditText;
    if (localEditText != null)
    {
      localObject1 = localEditText.getText();
      paramInt = localEditText.getSelectionStart();
      if (paramInt <= 0) {
        break label100;
      }
      localObject1 = ((Editable)localObject1).subSequence(0, paramInt);
      localObject2 = localEditText.getText();
      paramInt = localEditText.getSelectionEnd();
      if (paramInt <= localEditText.length()) {
        break label112;
      }
    }
    label100:
    label112:
    for (Object localObject2 = ((Editable)localObject2).subSequence(localEditText.length(), paramInt);; localObject2 = ((Editable)localObject2).subSequence(paramInt, localEditText.length()))
    {
      localObject1 = new com.tencent.mm.plugin.hld.a.e((CharSequence)localObject1, h(localEditText), (CharSequence)localObject2);
      AppMethodBeat.o(312038);
      return localObject1;
      localObject1 = ((Editable)localObject1).subSequence(paramInt, 0);
      break;
    }
  }
  
  public final void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {}
  
  public final boolean a(EditText paramEditText, Context paramContext)
  {
    AppMethodBeat.i(311822);
    if (!(paramContext instanceof Activity))
    {
      AppMethodBeat.o(311822);
      return false;
    }
    if (s.p(paramEditText, mInputEditText))
    {
      AppMethodBeat.o(311822);
      return true;
    }
    mContext = (Activity)paramContext;
    init();
    mInputEditText = paramEditText;
    if (paramEditText != null)
    {
      if ((JqL == 0) || ((JqL & 0xFF) != (paramEditText.getImeOptions() & 0xFF)))
      {
        JqL = paramEditText.getImeOptions();
        paramContext = g.JuL;
        g.fMk();
      }
      paramContext = com.tencent.mm.plugin.hld.f.k.JyF;
      com.tencent.mm.plugin.hld.f.k.x(Integer.valueOf(paramEditText.getInputType()));
    }
    AppMethodBeat.o(311822);
    return true;
  }
  
  public final void aj(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(311859);
    c(paramCharSequence, false);
    AppMethodBeat.o(311859);
  }
  
  public final void b(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(311881);
    s.u(paramCharSequence2, "lastPendingInput");
    AppMethodBeat.o(311881);
  }
  
  public final void c(CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(311854);
    if (Util.isNullOrNil(paramCharSequence))
    {
      Log.i("WxIme.ImeIndependentView", "commitText null");
      AppMethodBeat.o(311854);
      return;
    }
    Object localObject1;
    Object localObject2;
    if (paramCharSequence != null)
    {
      if (!paramBoolean) {
        break label209;
      }
      localObject1 = paramCharSequence.subSequence(paramCharSequence.length() - 1, paramCharSequence.length()).toString();
      localObject2 = com.tencent.mm.plugin.hld.f.b.Jyf;
      localObject1 = com.tencent.mm.plugin.hld.f.b.bf(getContext(), (String)localObject1);
      if (Util.isNullOrNil((String)localObject1)) {
        break label201;
      }
      localObject2 = JqJ.fKv();
      if (localObject2 == null) {
        break label217;
      }
    }
    label201:
    label209:
    label217:
    for (int i = ((com.tencent.mm.plugin.hld.a.h)localObject2).start + paramCharSequence.length();; i = 0)
    {
      localObject1 = (CharSequence)new StringBuilder(paramCharSequence).append((String)localObject1);
      s.s(localObject1, "{\n                val la…          }\n            }");
      for (;;)
      {
        localObject2 = mInputEditText;
        if (localObject2 != null) {
          ((EditText)localObject2).append(paramCharSequence);
        }
        if (i != 0) {
          JqJ.Yj(i);
        }
        paramCharSequence = l.JyV;
        if (l.fOH())
        {
          paramCharSequence = g.JuL;
          g.fMk();
        }
        paramCharSequence = com.tencent.mm.plugin.hld.model.k.JvH;
        com.tencent.mm.plugin.hld.model.k.YB(((CharSequence)localObject1).length());
        AppMethodBeat.o(311854);
        return;
        localObject1 = paramCharSequence;
        i = 0;
        break;
        localObject1 = paramCharSequence;
        i = 0;
      }
    }
  }
  
  public final void fKq()
  {
    AppMethodBeat.i(311914);
    int i = JqL & 0xFF;
    Log.d("WxIme.ImeIndependentView", s.X("handleActionKey ", Integer.valueOf(i)));
    switch (i)
    {
    case 6: 
    default: 
      fKs();
    }
    EditText localEditText;
    do
    {
      AppMethodBeat.o(311914);
      return;
      localEditText = mInputEditText;
    } while (localEditText == null);
    localEditText.onEditorAction(i);
    AppMethodBeat.o(311914);
  }
  
  public final boolean fKr()
  {
    AppMethodBeat.i(311988);
    int i = JqL & 0xFF;
    Log.d("WxIme.ImeIndependentView", s.X("handleActionKey ", Integer.valueOf(i)));
    switch (i)
    {
    case 6: 
    default: 
      AppMethodBeat.o(311988);
      return true;
    }
    AppMethodBeat.o(311988);
    return false;
  }
  
  public final void fKs()
  {
    AppMethodBeat.i(311953);
    c((CharSequence)"\n", false);
    AppMethodBeat.o(311953);
  }
  
  public final int fKt()
  {
    return JqL;
  }
  
  public final boolean fKu()
  {
    return Jnd;
  }
  
  public final com.tencent.mm.plugin.hld.a.h fKv()
  {
    AppMethodBeat.i(311937);
    Object localObject = mInputEditText;
    if (localObject == null)
    {
      AppMethodBeat.o(311937);
      return null;
    }
    localObject = new com.tencent.mm.plugin.hld.a.h(((EditText)localObject).getSelectionStart(), ((EditText)localObject).getSelectionEnd());
    AppMethodBeat.o(311937);
    return localObject;
  }
  
  public final void fKw() {}
  
  public final boolean fKx()
  {
    return true;
  }
  
  public final boolean fKy()
  {
    AppMethodBeat.i(312000);
    Object localObject = mInputEditText;
    if (localObject == null)
    {
      AppMethodBeat.o(312000);
      return false;
    }
    localObject = ((EditText)localObject).getInputExtras(false);
    if (localObject == null)
    {
      AppMethodBeat.o(312000);
      return false;
    }
    boolean bool = ((Bundle)localObject).getBoolean("if_support_wx_emoji");
    AppMethodBeat.o(312000);
    return bool;
  }
  
  public final int fKz()
  {
    AppMethodBeat.i(312010);
    Object localObject = mInputEditText;
    if (localObject == null)
    {
      AppMethodBeat.o(312010);
      return 5;
    }
    localObject = ((EditText)localObject).getInputExtras(false);
    if (localObject == null)
    {
      AppMethodBeat.o(312010);
      return 5;
    }
    int i = ((Bundle)localObject).getInt("wechat_scene");
    AppMethodBeat.o(312010);
    return i;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(312057);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/independ/ImeIndependentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/independ/ImeIndependentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(312057);
  }
  
  public final void requestHideSelf(int paramInt)
  {
    AppMethodBeat.i(311835);
    onHide();
    AppMethodBeat.o(311835);
  }
  
  public final void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.d.a
 * JD-Core Version:    0.7.0.1
 */