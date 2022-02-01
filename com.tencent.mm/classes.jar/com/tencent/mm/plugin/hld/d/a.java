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
import com.tencent.mm.plugin.hld.model.f;
import com.tencent.mm.plugin.hld.model.g;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/independ/ImeIndependentView;", "Lcom/tencent/mm/plugin/hld/api/IImeIndependView;", "Landroid/view/View$OnClickListener;", "()V", "TAG", "", "isSafetyKeyboard", "", "Ljava/lang/Boolean;", "keyboardShow", "mContext", "Landroid/app/Activity;", "mImeKeyboardActionListener", "Lcom/tencent/mm/plugin/hld/key/ImeKeyboardActionListener;", "mImeOption", "", "mInitializeSuccess", "mInputEditText", "Landroid/widget/EditText;", "mInputViewWidow", "Landroid/widget/PopupWindow;", "yOffset", "commitEmojiToWX", "", "emojiStr", "commitEnglishText", "text", "", "lastPending", "isEnglishSP", "commitText", "checkPairSymbol", "deleteText", "deleteLen", "getActionType", "getAroundText", "Lcom/tencent/mm/plugin/hld/api/ImeAroundText;", "num", "getBeforeText", "getContext", "Landroid/content/Context;", "getCurrentPackageName", "getCurrentSelection", "Lcom/tencent/mm/plugin/hld/api/ImeSelection;", "getImeKeyboardActionListener", "getInputEditText", "getResources", "Landroid/content/res/Resources;", "getSelectedText", "editText", "getTextAfterCursor", "getTextBeforeCursor", "getWechatScene", "handleActionKey", "handleNewLine", "ifActionNewLine", "ifUse", "init", "isKeyboardShow", "isWeChat", "moveSelection", "index", "onClick", "v", "Landroid/view/View;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onHide", "onShowView", "requestHideSelf", "flags", "reset", "setInputEditText", "activity", "supportWxEmoji", "switchToDefaultIme", "updateEnglishStrikeView", "lastPendingInput", "updateKeyboard", "updateSelection", "plugin-hld_release"})
public final class a
  implements View.OnClickListener, com.tencent.mm.plugin.hld.a.a
{
  private static int DqN;
  private static boolean Dtw;
  private static com.tencent.mm.plugin.hld.e.a Dty;
  private static boolean Dva;
  private static PopupWindow DxE;
  private static int DxF;
  private static Boolean DxG;
  public static final a DxH;
  private static Activity mContext;
  private static EditText mInputEditText;
  
  static
  {
    AppMethodBeat.i(209295);
    DxH = new a();
    AppMethodBeat.o(209295);
  }
  
  private static void eCl()
  {
    AppMethodBeat.i(209255);
    Object localObject = i.DHq;
    i.eGF();
    g.DCm.eDW();
    localObject = n.DEn;
    n.eEF();
    localObject = g.DCm;
    g.eEb();
    localObject = g.DCm;
    g.eEi();
    localObject = com.tencent.mm.plugin.hld.candidate.e.DuU;
    if (com.tencent.mm.plugin.hld.candidate.e.eCO())
    {
      localObject = g.DCm;
      localObject = g.eEl();
      if (localObject != null) {
        ((ImeCandidateView)localObject).eCJ();
      }
    }
    localObject = g.DCm;
    if (!g.eDV())
    {
      localObject = g.DCm;
      g.gP(getContext());
    }
    localObject = g.DCm;
    localObject = g.eEl();
    if (localObject != null)
    {
      ((ImeCandidateView)localObject).eCK();
      AppMethodBeat.o(209255);
      return;
    }
    AppMethodBeat.o(209255);
  }
  
  public static void eDy()
  {
    AppMethodBeat.i(209254);
    if (!(mContext instanceof Activity))
    {
      AppMethodBeat.o(209254);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = com.tencent.mm.plugin.hld.f.k.DHH;
    int i = com.tencent.mm.plugin.hld.f.k.gZ((Context)mContext);
    int j = DqN;
    Log.d("WxIme.ImeIndependentView", "yOffset:" + DqN + " navigationBarHeight:" + i + " newYOffset:" + (j - i));
    localObject1 = DxE;
    Object localObject2;
    if ((localObject1 == null) || (((PopupWindow)localObject1).isShowing() != true))
    {
      Dtw = true;
      eCl();
      localObject1 = com.tencent.mm.plugin.hld.model.k.DDb;
      com.tencent.mm.plugin.hld.model.k.gQ(getContext());
      localObject1 = (d)com.tencent.mm.kernel.h.ae(d.class);
      if (localObject1 != null) {
        ((d)localObject1).eCB();
      }
      localObject1 = new int[2];
      localObject2 = mContext;
      if (localObject2 == null) {
        p.iCn();
      }
      localObject2 = ((Activity)localObject2).getCurrentFocus();
      if (localObject2 != null) {
        ((View)localObject2).getLocationInWindow((int[])localObject1);
      }
      localObject1 = DxE;
      if (localObject1 != null)
      {
        localObject2 = mContext;
        if (localObject2 == null) {
          p.iCn();
        }
        ((PopupWindow)localObject1).showAtLocation(((Activity)localObject2).getCurrentFocus(), 8388691, 0, 0);
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.hld.f.k.DHH;
      localObject1 = com.tencent.mm.plugin.hld.f.k.DHH;
      com.tencent.mm.plugin.hld.f.k.q(com.tencent.mm.plugin.hld.f.k.eGO());
      Log.i("WxIme.ImeIndependentView", "onWindowShown  " + l + ' ' + (System.currentTimeMillis() - l));
      AppMethodBeat.o(209254);
      return;
      Log.w("WxIme.ImeIndependentView", "onWindowShown last:" + Dtw + " why????");
      localObject1 = com.tencent.mm.plugin.hld.f.k.DHH;
      localObject1 = com.tencent.mm.plugin.hld.f.k.eGO();
      localObject2 = com.tencent.mm.plugin.hld.f.k.DHH;
      if ((p.h(localObject1, com.tencent.mm.plugin.hld.f.k.eGP()) ^ true))
      {
        localObject1 = n.DEn;
        n.eEG();
        localObject1 = f.DBL;
        f.eDS();
        localObject1 = g.DCm;
        localObject1 = g.eEl();
        if (localObject1 != null) {
          ((ImeCandidateView)localObject1).reset();
        }
        DxG = null;
        eCl();
      }
    }
  }
  
  public static EditText eDz()
  {
    return mInputEditText;
  }
  
  private static Context getContext()
  {
    AppMethodBeat.i(209260);
    Context localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    AppMethodBeat.o(209260);
    return localContext;
  }
  
  private static Resources getResources()
  {
    AppMethodBeat.i(209262);
    Object localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    p.j(localObject, "MMApplicationContext.getContext().resources");
    AppMethodBeat.o(209262);
    return localObject;
  }
  
  private static CharSequence h(EditText paramEditText)
  {
    AppMethodBeat.i(209293);
    Editable localEditable = paramEditText.getText();
    int i = paramEditText.getSelectionStart();
    int j = paramEditText.getSelectionEnd();
    if (i > j)
    {
      paramEditText = localEditable.subSequence(j, i);
      AppMethodBeat.o(209293);
      return paramEditText;
    }
    paramEditText = localEditable.subSequence(i, j);
    AppMethodBeat.o(209293);
    return paramEditText;
  }
  
  private void init()
  {
    AppMethodBeat.i(209251);
    if (Dva)
    {
      AppMethodBeat.o(209251);
      return;
    }
    Dva = true;
    long l = System.currentTimeMillis();
    Dty = new com.tencent.mm.plugin.hld.e.a(getContext(), getResources());
    Object localObject1 = com.tencent.mm.plugin.hld.f.k.DHH;
    com.tencent.mm.plugin.hld.f.k.init(getResources().getConfiguration().orientation);
    localObject1 = f.DBL;
    f.init(getContext());
    localObject1 = g.DCm;
    localObject1 = getContext();
    Object localObject2 = Dty;
    if (localObject2 == null) {
      p.iCn();
    }
    g.a((Context)localObject1, (c)localObject2);
    com.tencent.mm.plugin.hld.candidate.e.DuU.eCN();
    Log.i("WxIme.ImeIndependentView", "onCreate " + l + ' ' + (System.currentTimeMillis() - l) + ' ' + hashCode());
    g.DCm.gO(getContext());
    localObject1 = g.DCm;
    localObject1 = g.eEa();
    if (((View)localObject1).getParent() != null)
    {
      if (!(((View)localObject1).getParent() instanceof ViewGroup)) {
        break label429;
      }
      localObject2 = ((View)localObject1).getParent();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(209251);
        throw ((Throwable)localObject1);
      }
      ((ViewGroup)localObject2).removeView((View)localObject1);
    }
    for (;;)
    {
      localObject1 = g.DCm;
      localObject1 = new PopupWindow(g.eEa());
      ((PopupWindow)localObject1).setInputMethodMode(2);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
        ((PopupWindow)localObject1).setWindowLayoutType(1003);
      }
      localObject2 = com.tencent.mm.plugin.hld.f.k.DHH;
      ((PopupWindow)localObject1).setWidth(com.tencent.mm.plugin.hld.f.k.getScreenWidth(getContext()));
      localObject2 = com.tencent.mm.plugin.hld.f.k.DHH;
      ((PopupWindow)localObject1).setHeight(com.tencent.mm.plugin.hld.f.k.gV(getContext()));
      ((PopupWindow)localObject1).setAnimationStyle(a.k.BottomToTopAnimation);
      DxE = (PopupWindow)localObject1;
      int i = ar.au(getContext()).y;
      localObject1 = com.tencent.mm.plugin.hld.f.k.DHH;
      DqN = i - com.tencent.mm.plugin.hld.f.k.gV(getContext());
      localObject1 = new StringBuilder("y:").append(ar.au(getContext()).y).append(" statusBar:").append(ar.getStatusBarHeight(getContext())).append(" keyboardHeight:");
      localObject2 = com.tencent.mm.plugin.hld.f.k.DHH;
      Log.d("WxIme.ImeIndependentView", com.tencent.mm.plugin.hld.f.k.gV(getContext()));
      AppMethodBeat.o(209251);
      return;
      label429:
      Log.e("WxIme.ImeIndependentView", "onCreateInputView " + ((View)localObject1).getParent());
    }
  }
  
  public static void onHide()
  {
    AppMethodBeat.i(209258);
    Log.d("WxIme.ImeIndependentView", "onWindowHidden " + System.currentTimeMillis());
    Object localObject = DxE;
    if (localObject != null) {
      ((PopupWindow)localObject).dismiss();
    }
    localObject = n.DEn;
    n.eEG();
    localObject = f.DBL;
    f.eDS();
    g.DCm.eDY();
    localObject = g.DCm;
    localObject = g.eEl();
    if (localObject != null) {
      ((ImeCandidateView)localObject).reset();
    }
    localObject = com.tencent.mm.plugin.hld.model.k.DDb;
    com.tencent.mm.plugin.hld.model.k.eEx();
    Dtw = false;
    DxG = null;
    AppMethodBeat.o(209258);
  }
  
  public final void Um(int paramInt)
  {
    AppMethodBeat.i(209281);
    Object localObject = mInputEditText;
    if (localObject != null)
    {
      if (Util.isNullOrNil(h((EditText)localObject)))
      {
        paramInt = ((EditText)localObject).getSelectionStart();
        ((EditText)localObject).getText().delete(paramInt - 1, paramInt);
      }
      for (;;)
      {
        localObject = com.tencent.mm.plugin.hld.f.l.DHK;
        if (com.tencent.mm.plugin.hld.f.l.eGY())
        {
          localObject = g.DCm;
          g.eEi();
        }
        AppMethodBeat.o(209281);
        return;
        paramInt = ((EditText)localObject).getSelectionStart();
        int i = ((EditText)localObject).getSelectionEnd();
        ((EditText)localObject).getText().delete(paramInt, i);
      }
    }
    AppMethodBeat.o(209281);
  }
  
  public final void Un(int paramInt)
  {
    AppMethodBeat.i(209283);
    EditText localEditText = mInputEditText;
    if (localEditText != null)
    {
      localEditText.setSelection(paramInt);
      AppMethodBeat.o(209283);
      return;
    }
    AppMethodBeat.o(209283);
  }
  
  public final com.tencent.mm.plugin.hld.a.e Uo(int paramInt)
  {
    AppMethodBeat.i(209291);
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
      AppMethodBeat.o(209291);
      return localObject1;
      localObject1 = ((Editable)localObject1).subSequence(paramInt, 0);
      break;
    }
  }
  
  public final void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {}
  
  public final boolean a(EditText paramEditText, Context paramContext)
  {
    AppMethodBeat.i(209252);
    if (!(paramContext instanceof Activity))
    {
      AppMethodBeat.o(209252);
      return false;
    }
    if (p.h(paramEditText, mInputEditText))
    {
      AppMethodBeat.o(209252);
      return true;
    }
    mContext = (Activity)paramContext;
    init();
    mInputEditText = paramEditText;
    if (paramEditText != null)
    {
      if ((DxF == 0) || ((DxF & 0xFF) != (paramEditText.getImeOptions() & 0xFF)))
      {
        DxF = paramEditText.getImeOptions();
        paramContext = g.DCm;
        g.eEi();
      }
      paramContext = com.tencent.mm.plugin.hld.f.k.DHH;
      com.tencent.mm.plugin.hld.f.k.q(Integer.valueOf(paramEditText.getInputType()));
    }
    AppMethodBeat.o(209252);
    return true;
  }
  
  public final void aa(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(209271);
    c(paramCharSequence, false);
    AppMethodBeat.o(209271);
  }
  
  public final void b(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(209275);
    p.k(paramCharSequence2, "lastPendingInput");
    AppMethodBeat.o(209275);
  }
  
  public final void c(CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(209269);
    if (Util.isNullOrNil(paramCharSequence))
    {
      Log.i("WxIme.ImeIndependentView", "commitText null");
      AppMethodBeat.o(209269);
      return;
    }
    if (paramCharSequence != null)
    {
      Object localObject1;
      Object localObject2;
      int i;
      if (paramBoolean)
      {
        localObject1 = paramCharSequence.subSequence(paramCharSequence.length() - 1, paramCharSequence.length()).toString();
        localObject2 = com.tencent.mm.plugin.hld.f.b.DGL;
        localObject1 = com.tencent.mm.plugin.hld.f.b.bd(getContext(), (String)localObject1);
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject2 = DxH.eCs();
          if (localObject2 != null)
          {
            i = ((com.tencent.mm.plugin.hld.a.h)localObject2).start + paramCharSequence.length();
            localObject1 = new StringBuilder(paramCharSequence).append((String)localObject1);
            p.j(localObject1, "StringBuilder(it).append(pairChar)");
            localObject1 = (CharSequence)localObject1;
          }
        }
      }
      for (;;)
      {
        localObject2 = mInputEditText;
        if (localObject2 != null) {
          ((EditText)localObject2).append(paramCharSequence);
        }
        if (i != 0) {
          DxH.Un(i);
        }
        paramCharSequence = com.tencent.mm.plugin.hld.f.l.DHK;
        if (com.tencent.mm.plugin.hld.f.l.eGY())
        {
          paramCharSequence = g.DCm;
          g.eEi();
        }
        paramCharSequence = com.tencent.mm.plugin.hld.model.k.DDb;
        com.tencent.mm.plugin.hld.model.k.UD(((CharSequence)localObject1).length());
        AppMethodBeat.o(209269);
        return;
        i = 0;
        break;
        localObject1 = paramCharSequence;
        i = 0;
        continue;
        localObject1 = paramCharSequence;
        i = 0;
      }
    }
    AppMethodBeat.o(209269);
  }
  
  public final void eCm()
  {
    AppMethodBeat.i(209282);
    int i = DxF & 0xFF;
    Log.d("WxIme.ImeIndependentView", "handleActionKey ".concat(String.valueOf(i)));
    switch (i)
    {
    case 6: 
    default: 
      eCo();
      AppMethodBeat.o(209282);
      return;
    }
    EditText localEditText = mInputEditText;
    if (localEditText != null)
    {
      localEditText.onEditorAction(i);
      AppMethodBeat.o(209282);
      return;
    }
    AppMethodBeat.o(209282);
  }
  
  public final boolean eCn()
  {
    AppMethodBeat.i(209287);
    int i = DxF & 0xFF;
    Log.d("WxIme.ImeIndependentView", "handleActionKey ".concat(String.valueOf(i)));
    switch (i)
    {
    case 6: 
    default: 
      AppMethodBeat.o(209287);
      return true;
    }
    AppMethodBeat.o(209287);
    return false;
  }
  
  public final void eCo()
  {
    AppMethodBeat.i(209285);
    c((CharSequence)"\n", false);
    AppMethodBeat.o(209285);
  }
  
  public final int eCp()
  {
    return DxF;
  }
  
  public final boolean eCq()
  {
    return Dtw;
  }
  
  public final com.tencent.mm.plugin.hld.a.h eCs()
  {
    AppMethodBeat.i(209284);
    Object localObject = mInputEditText;
    if (localObject != null)
    {
      localObject = new com.tencent.mm.plugin.hld.a.h(((EditText)localObject).getSelectionStart(), ((EditText)localObject).getSelectionEnd());
      AppMethodBeat.o(209284);
      return localObject;
    }
    AppMethodBeat.o(209284);
    return null;
  }
  
  public final void eCt() {}
  
  public final boolean eCu()
  {
    return true;
  }
  
  public final boolean eCv()
  {
    AppMethodBeat.i(209289);
    Object localObject = mInputEditText;
    if (localObject != null)
    {
      localObject = ((EditText)localObject).getInputExtras(false);
      if (localObject != null)
      {
        boolean bool = ((Bundle)localObject).getBoolean("if_support_wx_emoji");
        AppMethodBeat.o(209289);
        return bool;
      }
      AppMethodBeat.o(209289);
      return false;
    }
    AppMethodBeat.o(209289);
    return false;
  }
  
  public final int eCw()
  {
    AppMethodBeat.i(209290);
    Object localObject = mInputEditText;
    if (localObject != null)
    {
      localObject = ((EditText)localObject).getInputExtras(false);
      if (localObject != null)
      {
        int i = ((Bundle)localObject).getInt("wechat_scene");
        AppMethodBeat.o(209290);
        return i;
      }
      AppMethodBeat.o(209290);
      return 5;
    }
    AppMethodBeat.o(209290);
    return 5;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(209294);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/independ/ImeIndependentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/independ/ImeIndependentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(209294);
  }
  
  public final void requestHideSelf(int paramInt)
  {
    AppMethodBeat.i(209264);
    onHide();
    AppMethodBeat.o(209264);
  }
  
  public final void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.d.a
 * JD-Core Version:    0.7.0.1
 */