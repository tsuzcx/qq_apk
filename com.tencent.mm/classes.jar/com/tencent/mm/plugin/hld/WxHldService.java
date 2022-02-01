package com.tencent.mm.plugin.hld;

import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.inputmethodservice.AbstractInputMethodService.AbstractInputMethodSessionImpl;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.InputMethodService.InputMethodSessionImpl;
import android.inputmethodservice.InputMethodService.Insets;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.candidate.ImeCandidateView;
import com.tencent.mm.plugin.hld.model.f;
import com.tencent.mm.plugin.hld.model.k.m;
import com.tencent.mm.plugin.hld.model.k.n;
import com.tencent.mm.plugin.hld.model.k.o;
import com.tencent.mm.plugin.hld.model.k.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.wxhld.WxhldApi;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.aa.d;
import kotlin.g.b.aa.f;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/WxHldService;", "Landroid/inputmethodservice/InputMethodService;", "Lcom/tencent/mm/plugin/hld/api/IImeService;", "()V", "keyboardShow", "", "mAttribute", "Landroid/view/inputmethod/EditorInfo;", "mImeKeyboardActionListener", "Lcom/tencent/mm/plugin/hld/key/ImeKeyboardActionListener;", "switchToAnotherIme", "getSwitchToAnotherIme", "()Z", "setSwitchToAnotherIme", "(Z)V", "commitEmojiToWX", "", "emojiStr", "", "commitEnglishText", "text", "", "lastPending", "isEnglishSP", "commitText", "checkPairSymbol", "deleteText", "deleteLen", "", "getActionType", "getAroundText", "Lcom/tencent/mm/plugin/hld/api/ImeAroundText;", "num", "getBeforeText", "getContext", "Landroid/content/Context;", "getCurrentPackageName", "getCurrentSelection", "Lcom/tencent/mm/plugin/hld/api/ImeSelection;", "getEndSpaceLength", "str", "getImeKeyboardActionListener", "getImeResources", "Landroid/content/res/Resources;", "getResources", "getWechatScene", "handleActionKey", "handleBack", "keyCode", "handleNewLine", "ifActionNewLine", "isKeyboardShow", "isSafetyKeyboard", "isWeChat", "moveSelection", "index", "onComputeInsets", "outInsets", "Landroid/inputmethodservice/InputMethodService$Insets;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onCreateCandidatesView", "Landroid/view/View;", "onCreateInputMethodSessionInterface", "Landroid/inputmethodservice/AbstractInputMethodService$AbstractInputMethodSessionImpl;", "Landroid/inputmethodservice/AbstractInputMethodService;", "onCreateInputView", "onDestroy", "onEvaluateFullscreenMode", "onFinishInput", "onKeyDown", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onStartInput", "attribute", "restarting", "onStartInputView", "info", "onUpdateSelection", "oldSelStart", "oldSelEnd", "newSelStart", "newSelEnd", "candidatesStart", "candidatesEnd", "onWindowHidden", "onWindowShown", "reset", "supportWxEmoji", "switchToDefaultIme", "updateEditorInfo", "updateEnglishStrikeView", "lastPendingInput", "updateKeyboard", "Companion", "InputMethodSessionImpls", "plugin-hld_release"})
public class WxHldService
  extends InputMethodService
  implements com.tencent.mm.plugin.hld.a.b
{
  public static final b DtA;
  private static com.tencent.mm.plugin.hld.a.b Dtz;
  public boolean Dtv;
  private boolean Dtw;
  private EditorInfo Dtx;
  private com.tencent.mm.plugin.hld.e.a Dty;
  
  static
  {
    AppMethodBeat.i(216507);
    DtA = new b((byte)0);
    AppMethodBeat.o(216507);
  }
  
  public static int Z(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(216483);
    kotlin.g.b.p.k(paramCharSequence, "str");
    Object localObject = paramCharSequence.toString();
    if (localObject == null)
    {
      paramCharSequence = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(216483);
      throw paramCharSequence;
    }
    localObject = ((String)localObject).toCharArray();
    kotlin.g.b.p.j(localObject, "(this as java.lang.String).toCharArray()");
    int i = localObject.length;
    while ((i > 0) && (localObject[(i - 1)] <= ' ')) {
      i -= 1;
    }
    if (i < localObject.length)
    {
      int j = paramCharSequence.toString().length();
      AppMethodBeat.o(216483);
      return j - i;
    }
    AppMethodBeat.o(216483);
    return 0;
  }
  
  private static void eCl()
  {
    AppMethodBeat.i(216467);
    Object localObject = com.tencent.mm.plugin.hld.f.i.DHq;
    com.tencent.mm.plugin.hld.f.i.eGF();
    com.tencent.mm.plugin.hld.model.g.DCm.eDW();
    localObject = com.tencent.mm.plugin.hld.model.n.DEn;
    com.tencent.mm.plugin.hld.model.n.eEF();
    localObject = com.tencent.mm.plugin.hld.model.g.DCm;
    com.tencent.mm.plugin.hld.model.g.eEb();
    localObject = com.tencent.mm.plugin.hld.model.g.DCm;
    com.tencent.mm.plugin.hld.model.g.eEi();
    localObject = com.tencent.mm.plugin.hld.candidate.e.DuU;
    if (com.tencent.mm.plugin.hld.candidate.e.eCO())
    {
      localObject = com.tencent.mm.plugin.hld.model.g.DCm;
      localObject = com.tencent.mm.plugin.hld.model.g.eEl();
      if (localObject != null) {
        ((ImeCandidateView)localObject).eCJ();
      }
    }
    localObject = com.tencent.mm.plugin.hld.model.g.DCm;
    if (!com.tencent.mm.plugin.hld.model.g.eDV())
    {
      localObject = com.tencent.mm.plugin.hld.model.g.DCm;
      com.tencent.mm.plugin.hld.model.g.gP(getContext());
    }
    localObject = com.tencent.mm.plugin.hld.model.g.DCm;
    localObject = com.tencent.mm.plugin.hld.model.g.eEl();
    if (localObject != null)
    {
      ((ImeCandidateView)localObject).eCK();
      AppMethodBeat.o(216467);
      return;
    }
    AppMethodBeat.o(216467);
  }
  
  private static Resources eCy()
  {
    AppMethodBeat.i(216505);
    Resources localResources = getContext().getResources();
    kotlin.g.b.p.j(localResources, "getContext().resources");
    AppMethodBeat.o(216505);
    return localResources;
  }
  
  private static Context getContext()
  {
    AppMethodBeat.i(216499);
    Context localContext = MMApplicationContext.getContext();
    kotlin.g.b.p.j(localContext, "MMApplicationContext.getContext()");
    AppMethodBeat.o(216499);
    return localContext;
  }
  
  public final void Um(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(216486);
    Log.i("WxIme.WxHldService", "deleteText ".concat(String.valueOf(paramInt)));
    Object localObject = getCurrentInputConnection();
    if (localObject != null)
    {
      if (Util.isNullOrNil(((InputConnection)localObject).getSelectedText(0))) {
        while (i < paramInt)
        {
          sendDownUpKeyEvents(67);
          i += 1;
        }
      }
      ((InputConnection)localObject).commitText((CharSequence)"", 1);
      localObject = com.tencent.mm.plugin.hld.f.l.DHK;
      if (com.tencent.mm.plugin.hld.f.l.eGY())
      {
        localObject = com.tencent.mm.plugin.hld.model.g.DCm;
        com.tencent.mm.plugin.hld.model.g.eEi();
      }
      AppMethodBeat.o(216486);
      return;
    }
    AppMethodBeat.o(216486);
  }
  
  public final void Un(int paramInt)
  {
    AppMethodBeat.i(216491);
    InputConnection localInputConnection = getCurrentInputConnection();
    if (localInputConnection != null)
    {
      localInputConnection.setSelection(paramInt, paramInt);
      AppMethodBeat.o(216491);
      return;
    }
    AppMethodBeat.o(216491);
  }
  
  public final com.tencent.mm.plugin.hld.a.e Uo(int paramInt)
  {
    AppMethodBeat.i(216497);
    Object localObject = null;
    InputConnection localInputConnection = getCurrentInputConnection();
    if (localInputConnection != null)
    {
      localObject = localInputConnection.getTextBeforeCursor(paramInt, 0);
      CharSequence localCharSequence = localInputConnection.getTextAfterCursor(paramInt, 0);
      localObject = new com.tencent.mm.plugin.hld.a.e((CharSequence)localObject, localInputConnection.getSelectedText(0), localCharSequence);
    }
    AppMethodBeat.o(216497);
    return localObject;
  }
  
  public final void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(216479);
    Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    com.tencent.mm.plugin.hld.f.l.it("WxIme.WxHldService", "commitEnglishText " + paramCharSequence2);
    if (Util.isNullOrNil(paramCharSequence1))
    {
      Log.i("WxIme.WxHldService", "commitText null");
      AppMethodBeat.o(216479);
      return;
    }
    if (paramCharSequence1 != null)
    {
      localObject = new aa.f();
      ((aa.f)localObject).aaBC = paramCharSequence1;
      final aa.d locald = new aa.d();
      locald.aaBA = 0;
      int j;
      int i;
      if (paramCharSequence2 != null)
      {
        int k = Math.min(paramCharSequence2.length(), ((CharSequence)((aa.f)localObject).aaBC).length());
        j = 0;
        i = 0;
        while ((j < k) && (Util.isEqual(Character.valueOf(paramCharSequence2.charAt(j)), Character.valueOf(((CharSequence)((aa.f)localObject).aaBC).charAt(j)))))
        {
          i += 1;
          j += 1;
        }
        if (i == paramCharSequence2.length()) {
          if (((CharSequence)((aa.f)localObject).aaBC).length() == i)
          {
            paramCharSequence1 = (CharSequence)"";
            ((aa.f)localObject).aaBC = paramCharSequence1;
            label219:
            paramCharSequence1 = getCurrentInputConnection();
            if (paramCharSequence1 != null)
            {
              if (locald.aaBA <= 0) {
                break label515;
              }
              paramCharSequence1.commitText((CharSequence)"", 1);
              if (Build.VERSION.SDK_INT < 24) {
                break label499;
              }
              paramCharSequence1.deleteSurroundingTextInCodePoints(locald.aaBA, 0);
              label271:
              com.tencent.e.h.ZvG.n((Runnable)new a(paramCharSequence1, locald, (aa.f)localObject), 1L);
            }
          }
        }
      }
      for (;;)
      {
        paramCharSequence1 = com.tencent.mm.plugin.hld.f.l.DHK;
        if (com.tencent.mm.plugin.hld.f.l.eGY())
        {
          paramCharSequence1 = com.tencent.mm.plugin.hld.model.g.DCm;
          com.tencent.mm.plugin.hld.model.g.eEi();
        }
        paramCharSequence1 = com.tencent.mm.plugin.hld.model.k.DDb;
        com.tencent.mm.plugin.hld.model.k.UD(((CharSequence)((aa.f)localObject).aaBC).length());
        AppMethodBeat.o(216479);
        return;
        paramCharSequence1 = ((CharSequence)((aa.f)localObject).aaBC).subSequence(i, ((CharSequence)((aa.f)localObject).aaBC).length());
        break;
        j = paramCharSequence2.length() - i;
        paramCharSequence1 = getCurrentInputConnection();
        if (paramCharSequence1 != null)
        {
          if (Build.VERSION.SDK_INT < 24) {
            break label443;
          }
          paramCharSequence1.deleteSurroundingTextInCodePoints(j, 0);
        }
        for (;;)
        {
          ((aa.f)localObject).aaBC = ((CharSequence)((aa.f)localObject).aaBC).subSequence(i, ((CharSequence)((aa.f)localObject).aaBC).length());
          break;
          label443:
          paramCharSequence1.deleteSurroundingText(j, 0);
        }
        paramCharSequence2 = (WxHldService)this;
        com.tencent.mm.plugin.hld.f.b localb = com.tencent.mm.plugin.hld.f.b.DGL;
        if (!com.tencent.mm.plugin.hld.f.b.ab(paramCharSequence1)) {
          break label219;
        }
        paramCharSequence1 = paramCharSequence2.eCx();
        if ((paramCharSequence1 == null) || (Z(paramCharSequence1) != 1)) {
          break label219;
        }
        locald.aaBA = 1;
        break label219;
        label499:
        paramCharSequence1.deleteSurroundingText(locald.aaBA, 0);
        break label271;
        label515:
        paramCharSequence1.commitText((CharSequence)((aa.f)localObject).aaBC, 1);
      }
    }
    AppMethodBeat.o(216479);
  }
  
  public final void aa(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(292915);
    c(paramCharSequence, false);
    AppMethodBeat.o(292915);
  }
  
  public final void b(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    int i = 0;
    AppMethodBeat.i(216481);
    Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    com.tencent.mm.plugin.hld.f.l.it("WxIme.WxHldService", "updateEnglishStrikeView " + paramCharSequence2);
    int j;
    if (Util.isNullOrNil(paramCharSequence1))
    {
      if (paramCharSequence2 != null)
      {
        j = paramCharSequence2.length();
        while (i < j)
        {
          sendDownUpKeyEvents(67);
          i += 1;
        }
        AppMethodBeat.o(216481);
        return;
      }
      AppMethodBeat.o(216481);
      return;
    }
    localObject = new aa.d();
    ((aa.d)localObject).aaBA = 0;
    final aa.f localf = new aa.f();
    if (paramCharSequence1 == null) {
      kotlin.g.b.p.iCn();
    }
    localf.aaBC = paramCharSequence1;
    if (!Util.isNullOrNil(paramCharSequence2))
    {
      if (paramCharSequence2 == null) {
        kotlin.g.b.p.iCn();
      }
      int k = Math.min(paramCharSequence2.length(), ((CharSequence)localf.aaBC).length());
      j = 0;
      i = 0;
      while ((j < k) && (Util.isEqual(Character.valueOf(paramCharSequence2.charAt(j)), Character.valueOf(((CharSequence)localf.aaBC).charAt(j)))))
      {
        i += 1;
        j += 1;
      }
      if (i == paramCharSequence2.length()) {
        if (((CharSequence)localf.aaBC).length() == i)
        {
          paramCharSequence1 = (CharSequence)"";
          localf.aaBC = paramCharSequence1;
          label263:
          paramCharSequence1 = getCurrentInputConnection();
          if (paramCharSequence1 != null)
          {
            if (((aa.d)localObject).aaBA <= 0) {
              break label533;
            }
            paramCharSequence1.commitText((CharSequence)"", 1);
            if (Build.VERSION.SDK_INT < 24) {
              break label517;
            }
            paramCharSequence1.deleteSurroundingTextInCodePoints(((aa.d)localObject).aaBA, 0);
            label315:
            com.tencent.e.h.ZvG.n((Runnable)new f(paramCharSequence1, (aa.d)localObject, localf), 1L);
          }
        }
      }
    }
    for (;;)
    {
      paramCharSequence1 = com.tencent.mm.plugin.hld.f.l.DHK;
      if (com.tencent.mm.plugin.hld.f.l.eGY())
      {
        paramCharSequence1 = com.tencent.mm.plugin.hld.model.g.DCm;
        com.tencent.mm.plugin.hld.model.g.eEi();
      }
      AppMethodBeat.o(216481);
      return;
      paramCharSequence1 = ((CharSequence)localf.aaBC).subSequence(i, ((CharSequence)localf.aaBC).length());
      break;
      j = paramCharSequence2.length() - i;
      paramCharSequence1 = getCurrentInputConnection();
      if (paramCharSequence1 != null)
      {
        if (Build.VERSION.SDK_INT < 24) {
          break label467;
        }
        paramCharSequence1.deleteSurroundingTextInCodePoints(j, 0);
      }
      for (;;)
      {
        localf.aaBC = ((CharSequence)localf.aaBC).subSequence(i, ((CharSequence)localf.aaBC).length());
        break;
        label467:
        paramCharSequence1.deleteSurroundingText(j, 0);
      }
      paramCharSequence2 = com.tencent.mm.plugin.hld.f.b.DGL;
      if (!com.tencent.mm.plugin.hld.f.b.ab(paramCharSequence1)) {
        break label263;
      }
      paramCharSequence1 = eCx();
      if ((paramCharSequence1 == null) || (Z(paramCharSequence1) != 1)) {
        break label263;
      }
      ((aa.d)localObject).aaBA = 1;
      break label263;
      label517:
      paramCharSequence1.deleteSurroundingText(((aa.d)localObject).aaBA, 0);
      break label315;
      label533:
      paramCharSequence1.commitText((CharSequence)localf.aaBC, 1);
    }
  }
  
  public final void c(final CharSequence paramCharSequence, final boolean paramBoolean)
  {
    AppMethodBeat.i(216478);
    if (Util.isNullOrNil(paramCharSequence))
    {
      Log.i("WxIme.WxHldService", "commitText null");
      AppMethodBeat.o(216478);
      return;
    }
    com.tencent.e.h.ZvG.be((Runnable)new d(this, paramCharSequence, paramBoolean));
    AppMethodBeat.o(216478);
  }
  
  public final void eCm()
  {
    AppMethodBeat.i(216475);
    Log.d("WxIme.WxHldService", "handleActionKey " + eCp());
    switch (eCp())
    {
    case 6: 
    default: 
      eCo();
      AppMethodBeat.o(216475);
      return;
    }
    InputConnection localInputConnection = getCurrentInputConnection();
    if (localInputConnection != null)
    {
      localInputConnection.performEditorAction(eCp());
      AppMethodBeat.o(216475);
      return;
    }
    AppMethodBeat.o(216475);
  }
  
  public final boolean eCn()
  {
    AppMethodBeat.i(216476);
    Log.d("WxIme.WxHldService", "handleActionKey " + eCp());
    switch (eCp())
    {
    case 6: 
    default: 
      AppMethodBeat.o(216476);
      return true;
    }
    AppMethodBeat.o(216476);
    return false;
  }
  
  public final void eCo()
  {
    AppMethodBeat.i(216477);
    c((CharSequence)"\n", false);
    AppMethodBeat.o(216477);
  }
  
  public final int eCp()
  {
    int j = 1;
    EditorInfo localEditorInfo = this.Dtx;
    if (localEditorInfo != null) {}
    for (int i = localEditorInfo.imeOptions; (i & 0x40000000) == 1073741824; i = 0) {
      return 1;
    }
    localEditorInfo = this.Dtx;
    i = j;
    if (localEditorInfo != null) {
      i = localEditorInfo.imeOptions;
    }
    return i & 0xFF;
  }
  
  public final boolean eCq()
  {
    return this.Dtw;
  }
  
  public final com.tencent.mm.plugin.hld.a.h eCs()
  {
    AppMethodBeat.i(216489);
    Object localObject = getCurrentInputConnection();
    if (localObject != null)
    {
      localObject = ((InputConnection)localObject).getExtractedText(new ExtractedTextRequest(), 0);
      if (localObject != null)
      {
        localObject = new com.tencent.mm.plugin.hld.a.h(((ExtractedText)localObject).selectionStart, ((ExtractedText)localObject).selectionEnd);
        AppMethodBeat.o(216489);
        return localObject;
      }
      AppMethodBeat.o(216489);
      return null;
    }
    AppMethodBeat.o(216489);
    return null;
  }
  
  public final void eCt()
  {
    AppMethodBeat.i(216493);
    Object localObject = getSystemService("input_method");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(216493);
      throw ((Throwable)localObject);
    }
    localObject = ((InputMethodManager)localObject).getEnabledInputMethodList();
    if (((List)localObject).size() == 1)
    {
      Log.e("WxIme.WxHldService", "only wxime!!");
      AppMethodBeat.o(216493);
      return;
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      Log.w("WxIme.WxHldService", "switchToNextInputMethod ".concat(String.valueOf(switchToNextInputMethod(false))));
      AppMethodBeat.o(216493);
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      InputMethodInfo localInputMethodInfo = (InputMethodInfo)((Iterator)localObject).next();
      kotlin.g.b.p.j(localInputMethodInfo, "imi");
      String str = localInputMethodInfo.getId();
      com.tencent.mm.plugin.hld.model.p localp = com.tencent.mm.plugin.hld.model.p.DEH;
      if ((kotlin.g.b.p.h(str, com.tencent.mm.plugin.hld.model.p.eFo()) ^ true))
      {
        str = localInputMethodInfo.getId();
        localp = com.tencent.mm.plugin.hld.model.p.DEH;
        if ((kotlin.g.b.p.h(str, com.tencent.mm.plugin.hld.model.p.eFp()) ^ true))
        {
          Log.i("WxIme.WxHldService", "switch to " + localInputMethodInfo.getId());
          switchInputMethod(localInputMethodInfo.getId());
          AppMethodBeat.o(216493);
          return;
        }
      }
    }
    AppMethodBeat.o(216493);
  }
  
  public final boolean eCu()
  {
    AppMethodBeat.i(216494);
    boolean bool = Util.isEqual(getCurrentInputEditorInfo().packageName, MMApplicationContext.getApplicationId());
    AppMethodBeat.o(216494);
    return bool;
  }
  
  public final boolean eCv()
  {
    AppMethodBeat.i(216495);
    Object localObject = getCurrentInputEditorInfo();
    if (localObject != null)
    {
      localObject = ((EditorInfo)localObject).extras;
      if (localObject != null)
      {
        boolean bool = ((Bundle)localObject).getBoolean("if_support_wx_emoji");
        AppMethodBeat.o(216495);
        return bool;
      }
      AppMethodBeat.o(216495);
      return false;
    }
    AppMethodBeat.o(216495);
    return false;
  }
  
  public final int eCw()
  {
    AppMethodBeat.i(216496);
    Object localObject = getCurrentInputEditorInfo();
    if (localObject != null)
    {
      localObject = ((EditorInfo)localObject).extras;
      if (localObject != null)
      {
        int i = ((Bundle)localObject).getInt("wechat_scene");
        AppMethodBeat.o(216496);
        return i;
      }
      AppMethodBeat.o(216496);
      return 5;
    }
    AppMethodBeat.o(216496);
    return 5;
  }
  
  public final CharSequence eCx()
  {
    AppMethodBeat.i(216498);
    Object localObject = getCurrentInputConnection();
    if (localObject != null)
    {
      CharSequence localCharSequence = ((InputConnection)localObject).getTextBeforeCursor(2147483647, 0);
      localObject = localCharSequence;
      if (localCharSequence != null) {}
    }
    else
    {
      localObject = (CharSequence)"";
    }
    AppMethodBeat.o(216498);
    return localObject;
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(216500);
    if (getBaseContext() != null)
    {
      localObject1 = getBaseContext();
      kotlin.g.b.p.j(localObject1, "getBaseContext()");
      Object localObject2 = ((Context)localObject1).getResources();
      localObject1 = super.getResources();
      if (((localObject1 instanceof com.tencent.mm.cj.b)) && (localObject2 != null))
      {
        localObject2 = ((com.tencent.mm.cj.b)localObject1).hrv().f(((Resources)localObject2).getConfiguration());
        com.tencent.mm.cj.c.a((Configuration)localObject2, ar.f((Resources)localObject1));
        ((com.tencent.mm.cj.b)localObject1).getConfiguration().updateFrom((Configuration)localObject2);
      }
      AppMethodBeat.o(216500);
      return localObject1;
    }
    Log.e("WxIme.WxHldService", "no base context!!");
    Object localObject1 = super.getResources();
    AppMethodBeat.o(216500);
    return localObject1;
  }
  
  public void onComputeInsets(InputMethodService.Insets paramInsets)
  {
    AppMethodBeat.i(216455);
    kotlin.g.b.p.k(paramInsets, "outInsets");
    super.onComputeInsets(paramInsets);
    paramInsets.contentTopInsets = paramInsets.visibleTopInsets;
    AppMethodBeat.o(216455);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(216461);
    Object localObject1 = new StringBuilder("onConfigurationChanged lastOrientation:");
    Object localObject2 = com.tencent.mm.plugin.hld.f.k.DHH;
    localObject2 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.hld.f.k.eGL()).append(" orientation:");
    if (paramConfiguration != null) {}
    for (localObject1 = Integer.valueOf(paramConfiguration.orientation);; localObject1 = "")
    {
      localObject1 = ((StringBuilder)localObject2).append(localObject1).append(" darkMode:").append(ar.isDarkMode()).append(' ');
      localObject2 = MMApplicationContext.getContext();
      kotlin.g.b.p.j(localObject2, "MMApplicationContext.getContext()");
      localObject2 = ((Context)localObject2).getResources();
      if (localObject2 != null) {
        break;
      }
      paramConfiguration = new t("null cannot be cast to non-null type com.tencent.mm.resources.MMResources");
      AppMethodBeat.o(216461);
      throw paramConfiguration;
    }
    localObject2 = ((com.tencent.mm.cj.b)localObject2).hrw();
    kotlin.g.b.p.j(localObject2, "(MMApplicationContext.ge…esources).systemResources");
    Log.i("WxIme.WxHldService", ((Resources)localObject2).getConfiguration().uiMode);
    int i;
    if (paramConfiguration != null)
    {
      localObject1 = com.tencent.mm.plugin.hld.f.k.DHH;
      localObject1 = getContext();
      i = paramConfiguration.orientation;
      kotlin.g.b.p.k(localObject1, "context");
      Log.i("WxIme.WxImeUIUtil", "updateConfiguration " + com.tencent.mm.plugin.hld.f.k.DHs + ' ' + i + ' ' + com.tencent.mm.plugin.hld.f.k.DHu + ' ' + ar.isDarkMode());
      localObject2 = com.tencent.mm.plugin.hld.f.k.DHs;
      if (localObject2 != null) {
        break label331;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.hld.f.k.DHt = com.tencent.mm.plugin.hld.f.k.DHs;
      com.tencent.mm.plugin.hld.f.k.DHs = Integer.valueOf(i);
      com.tencent.mm.plugin.hld.f.k.DHu = ar.isDarkMode();
      com.tencent.mm.plugin.hld.f.k.reset((Context)localObject1);
      label331:
      do
      {
        super.onConfigurationChanged(paramConfiguration);
        paramConfiguration = new StringBuilder("onConfigurationChanged  ");
        localObject1 = MMApplicationContext.getContext();
        kotlin.g.b.p.j(localObject1, "MMApplicationContext.getContext()");
        localObject1 = ((Context)localObject1).getResources();
        if (localObject1 != null) {
          break label352;
        }
        paramConfiguration = new t("null cannot be cast to non-null type com.tencent.mm.resources.MMResources");
        AppMethodBeat.o(216461);
        throw paramConfiguration;
        if (((Integer)localObject2).intValue() != i) {
          break;
        }
      } while (com.tencent.mm.plugin.hld.f.k.DHu == ar.isDarkMode());
    }
    label352:
    localObject1 = ((com.tencent.mm.cj.b)localObject1).hrw();
    kotlin.g.b.p.j(localObject1, "(MMApplicationContext.ge…esources).systemResources");
    Log.d("WxIme.WxHldService", ((Resources)localObject1).getConfiguration().uiMode);
    AppMethodBeat.o(216461);
  }
  
  public void onCreate()
  {
    boolean bool = false;
    AppMethodBeat.i(216445);
    super.onCreate();
    long l1 = System.currentTimeMillis();
    Log.i("WxIme.WxHldService", "onCreate ".concat(String.valueOf(l1)));
    Object localObject = getWindow();
    kotlin.g.b.p.j(localObject, "window");
    localObject = ((Dialog)localObject).getWindow();
    if (localObject != null) {
      ((Window)localObject).setNavigationBarColor(eCy().getColor(a.c.ime_keyboard_end_color));
    }
    Dtz = (com.tencent.mm.plugin.hld.a.b)this;
    localObject = com.tencent.mm.plugin.hld.model.a.b.DFe;
    long l2 = System.currentTimeMillis();
    localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    localObject = kotlin.n.n.a((CharSequence)com.tencent.mm.plugin.hld.f.l.eHb(), new String[] { "_" });
    int i;
    if (((List)localObject).size() == 2)
    {
      i = 1;
      if (i == 0) {
        break label473;
      }
      label132:
      if (localObject != null)
      {
        com.tencent.mm.plugin.hld.model.a.b.DFa = Util.safeParseLong((String)((List)localObject).get(0));
        com.tencent.mm.plugin.hld.model.a.b.DFb = Util.safeParseLong((String)((List)localObject).get(1));
      }
      if ((l2 - com.tencent.mm.plugin.hld.model.a.b.DFc > com.tencent.mm.plugin.hld.model.a.b.DFa) || (com.tencent.mm.plugin.hld.model.a.b.DFd < com.tencent.mm.plugin.hld.model.a.b.DFb)) {
        break label496;
      }
      com.tencent.mm.plugin.hld.model.a.b.reset();
    }
    for (;;)
    {
      Log.i("WxIme.ImeRecovery", "initRecovery initResult:" + bool + " monitorTime:" + com.tencent.mm.plugin.hld.model.a.b.DFa + " maxCrashNum:" + com.tencent.mm.plugin.hld.model.a.b.DFb + " nowTime:" + l2);
      if (bool)
      {
        this.Dty = new com.tencent.mm.plugin.hld.e.a(getContext(), eCy());
        localObject = com.tencent.mm.plugin.hld.model.n.DEn;
        com.tencent.mm.plugin.hld.model.n.gR(getContext());
        localObject = com.tencent.mm.plugin.hld.f.k.DHH;
        com.tencent.mm.plugin.hld.f.k.init(eCy().getConfiguration().orientation);
        localObject = f.DBL;
        f.init(getContext());
        localObject = com.tencent.mm.plugin.hld.model.g.DCm;
        localObject = getContext();
        com.tencent.mm.plugin.hld.e.a locala = this.Dty;
        if (locala == null) {
          kotlin.g.b.p.iCn();
        }
        com.tencent.mm.plugin.hld.model.g.a((Context)localObject, (com.tencent.mm.plugin.hld.a.c)locala);
        com.tencent.mm.plugin.hld.candidate.e.DuU.eCN();
        com.tencent.mm.plugin.hld.model.g.DCm.gO(getContext());
      }
      for (;;)
      {
        l2 = System.currentTimeMillis();
        localObject = com.tencent.mm.plugin.hld.model.k.DDb;
        if (!com.tencent.mm.plugin.hld.model.k.eEz()) {
          com.tencent.e.h.ZvG.d((Runnable)new k.m(l1, l2), "WxIme.ImeReporter");
        }
        Log.i("WxIme.WxHldService", "onCreate " + bool + ' ' + l1 + ' ' + (l2 - l1) + ' ' + hashCode());
        AppMethodBeat.o(216445);
        return;
        i = 0;
        break;
        label473:
        localObject = null;
        break label132;
        this.Dtv = true;
        Log.e("WxIme.WxHldService", "repeatedly crash, switch to another ime!!");
      }
      label496:
      bool = true;
    }
  }
  
  public View onCreateCandidatesView()
  {
    return null;
  }
  
  public AbstractInputMethodService.AbstractInputMethodSessionImpl onCreateInputMethodSessionInterface()
  {
    AppMethodBeat.i(216474);
    AbstractInputMethodService.AbstractInputMethodSessionImpl localAbstractInputMethodSessionImpl = (AbstractInputMethodService.AbstractInputMethodSessionImpl)new c();
    AppMethodBeat.o(216474);
    return localAbstractInputMethodSessionImpl;
  }
  
  public View onCreateInputView()
  {
    AppMethodBeat.i(216451);
    Log.i("WxIme.WxHldService", "onCreateInputView " + System.currentTimeMillis());
    Object localObject = com.tencent.mm.plugin.hld.model.g.DCm;
    localObject = com.tencent.mm.plugin.hld.model.g.eEa();
    if (((View)localObject).getParent() != null)
    {
      if (!(((View)localObject).getParent() instanceof ViewGroup)) {
        break label100;
      }
      ViewParent localViewParent = ((View)localObject).getParent();
      if (localViewParent == null)
      {
        localObject = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(216451);
        throw ((Throwable)localObject);
      }
      ((ViewGroup)localViewParent).removeView((View)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(216451);
      return localObject;
      label100:
      Log.e("WxIme.WxHldService", "onCreateInputView " + ((View)localObject).getParent());
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(216463);
    super.onDestroy();
    Log.i("WxIme.WxHldService", "onDestroy " + hashCode());
    WxhldApi.finalize1();
    Object localObject1 = com.tencent.mm.plugin.hld.candidate.e.DuU;
    Object localObject2;
    try
    {
      localObject2 = MMApplicationContext.getContext().getSystemService("clipboard");
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.content.ClipboardManager");
        AppMethodBeat.o(216463);
        throw ((Throwable)localObject1);
      }
    }
    catch (Exception localException)
    {
      Log.e("WxIme.ImeClipBoardListener", "releaseListener " + localException.getMessage());
    }
    for (;;)
    {
      com.tencent.mm.app.g.jZ(Process.myPid());
      AppMethodBeat.o(216463);
      return;
      ((ClipboardManager)localObject2).removePrimaryClipChangedListener((ClipboardManager.OnPrimaryClipChangedListener)localException);
    }
  }
  
  public boolean onEvaluateFullscreenMode()
  {
    AppMethodBeat.i(216462);
    Log.i("WxIme.WxHldService", "onEvaluateFullscreenMode");
    AppMethodBeat.o(216462);
    return false;
  }
  
  public void onFinishInput()
  {
    AppMethodBeat.i(216460);
    super.onFinishInput();
    AppMethodBeat.o(216460);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int i = 0;
    AppMethodBeat.i(216472);
    Log.i("WxIme.WxHldService", "onKeyDown keyCoed:" + paramInt + ", event:" + paramKeyEvent);
    if (!this.Dtw)
    {
      AppMethodBeat.o(216472);
      return false;
    }
    if ((paramInt == 4) || (paramInt == 111))
    {
      requestHideSelf(0);
      i = 1;
    }
    if (i != 0)
    {
      AppMethodBeat.o(216472);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(216472);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(216473);
    Log.i("WxIme.WxHldService", "onKeyUp keyCoed:" + paramInt + ", event:" + paramKeyEvent);
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(216473);
    return bool;
  }
  
  public void onStartInput(EditorInfo paramEditorInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(216448);
    long l1 = System.currentTimeMillis();
    super.onStartInput(paramEditorInfo, paramBoolean);
    if ((this.Dtx == null) || (paramEditorInfo == null))
    {
      this.Dtx = paramEditorInfo;
      paramEditorInfo = com.tencent.mm.plugin.hld.model.g.DCm;
      com.tencent.mm.plugin.hld.model.g.eEi();
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      paramEditorInfo = com.tencent.mm.plugin.hld.model.k.DDb;
      if (!com.tencent.mm.plugin.hld.model.k.eEz()) {
        com.tencent.e.h.ZvG.d((Runnable)new k.n(l1, l2), "WxIme.ImeReporter");
      }
      Log.i("WxIme.WxHldService", "onStartInput " + (l2 - l1));
      AppMethodBeat.o(216448);
      return;
      EditorInfo localEditorInfo = this.Dtx;
      if (localEditorInfo == null) {
        kotlin.g.b.p.iCn();
      }
      if ((localEditorInfo.imeOptions & 0xFF) != (paramEditorInfo.imeOptions & 0xFF))
      {
        this.Dtx = paramEditorInfo;
        paramEditorInfo = com.tencent.mm.plugin.hld.model.g.DCm;
        com.tencent.mm.plugin.hld.model.g.eEi();
      }
    }
  }
  
  public void onStartInputView(EditorInfo paramEditorInfo, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(216458);
    long l1 = System.currentTimeMillis();
    super.onStartInputView(paramEditorInfo, paramBoolean);
    Object localObject1 = com.tencent.mm.plugin.hld.f.k.DHH;
    if (paramEditorInfo != null)
    {
      localObject1 = Integer.valueOf(paramEditorInfo.inputType);
      com.tencent.mm.plugin.hld.f.k.q((Integer)localObject1);
      localObject1 = com.tencent.mm.plugin.hld.model.k.DDb;
      long l2 = System.currentTimeMillis();
      if (!com.tencent.mm.plugin.hld.model.k.eEz()) {
        com.tencent.e.h.ZvG.d((Runnable)new k.o(l2), "WxIme.ImeReporter");
      }
      if (this.Dtw) {
        break label275;
      }
      this.Dtw = true;
      eCl();
      localObject1 = com.tencent.mm.plugin.hld.model.k.DDb;
      com.tencent.mm.plugin.hld.model.k.gQ(getContext());
      localObject1 = (d)com.tencent.mm.kernel.h.ae(d.class);
      if (localObject1 != null) {
        ((d)localObject1).eCB();
      }
      l2 = System.currentTimeMillis();
      localObject1 = com.tencent.mm.plugin.hld.model.k.DDb;
      localObject1 = com.tencent.mm.plugin.hld.model.g.DCm;
      int i = com.tencent.mm.plugin.hld.model.g.eEm();
      if (!com.tencent.mm.plugin.hld.model.k.eEz()) {
        com.tencent.e.h.ZvG.d((Runnable)new k.p(l1, l2, i), "WxIme.ImeReporter");
      }
    }
    for (;;)
    {
      Object localObject3 = new StringBuilder("onStartInputView newType:");
      localObject1 = localObject2;
      if (paramEditorInfo != null) {
        localObject1 = Integer.valueOf(paramEditorInfo.inputType);
      }
      paramEditorInfo = ((StringBuilder)localObject3).append(localObject1).append(" oldType:");
      localObject1 = com.tencent.mm.plugin.hld.f.k.DHH;
      Log.i("WxIme.WxHldService", com.tencent.mm.plugin.hld.f.k.eGP() + ' ' + (l1 - System.currentTimeMillis()));
      AppMethodBeat.o(216458);
      return;
      localObject1 = null;
      break;
      label275:
      Log.w("WxIme.WxHldService", "onWindowShown last:" + this.Dtw + " why????");
      localObject1 = com.tencent.mm.plugin.hld.f.k.DHH;
      localObject1 = com.tencent.mm.plugin.hld.f.k.eGO();
      localObject3 = com.tencent.mm.plugin.hld.f.k.DHH;
      if (!(kotlin.g.b.p.h(localObject1, com.tencent.mm.plugin.hld.f.k.eGP()) ^ true))
      {
        localObject1 = com.tencent.mm.plugin.hld.f.k.DHH;
        localObject1 = com.tencent.mm.plugin.hld.f.k.eGM();
        localObject3 = com.tencent.mm.plugin.hld.f.k.DHH;
        if (!(kotlin.g.b.p.h(localObject1, com.tencent.mm.plugin.hld.f.k.eGL()) ^ true)) {}
      }
      else
      {
        localObject1 = com.tencent.mm.plugin.hld.model.n.DEn;
        com.tencent.mm.plugin.hld.model.n.eEG();
        localObject1 = f.DBL;
        f.eDS();
        localObject1 = com.tencent.mm.plugin.hld.model.g.DCm;
        localObject1 = com.tencent.mm.plugin.hld.model.g.eEl();
        if (localObject1 != null) {
          ((ImeCandidateView)localObject1).reset();
        }
        eCl();
      }
      localObject1 = com.tencent.mm.plugin.hld.model.g.DCm;
      if (!com.tencent.mm.plugin.hld.model.g.eDV())
      {
        localObject1 = com.tencent.mm.plugin.hld.model.g.DCm;
        com.tencent.mm.plugin.hld.model.g.gP(getContext());
      }
    }
  }
  
  public void onUpdateSelection(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(216470);
    super.onUpdateSelection(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    com.tencent.mm.plugin.hld.model.g localg = com.tencent.mm.plugin.hld.model.g.DCm;
    com.tencent.mm.plugin.hld.model.g.eEp();
    AppMethodBeat.o(216470);
  }
  
  public void onWindowHidden()
  {
    AppMethodBeat.i(216468);
    Log.i("WxIme.WxHldService", "onWindowHidden " + System.currentTimeMillis());
    super.onWindowHidden();
    Object localObject = com.tencent.mm.plugin.hld.model.n.DEn;
    Log.i("WxIme.WxEngineMgr", "onWindowHidden needReInitEngine:" + com.tencent.mm.plugin.hld.model.n.DEl);
    com.tencent.mm.plugin.hld.model.n.eEG();
    if (com.tencent.mm.plugin.hld.model.n.DEl) {
      com.tencent.mm.plugin.hld.model.n.finalize1();
    }
    localObject = f.DBL;
    f.eDS();
    com.tencent.mm.plugin.hld.model.g.DCm.eDY();
    localObject = com.tencent.mm.plugin.hld.model.g.DCm;
    localObject = com.tencent.mm.plugin.hld.model.g.eEl();
    if (localObject != null) {
      ((ImeCandidateView)localObject).reset();
    }
    localObject = com.tencent.mm.plugin.hld.model.k.DDb;
    com.tencent.mm.plugin.hld.model.k.eEx();
    this.Dtw = false;
    AppMethodBeat.o(216468);
  }
  
  public void onWindowShown()
  {
    AppMethodBeat.i(216465);
    long l = System.currentTimeMillis();
    super.onWindowShown();
    Object localObject = com.tencent.mm.plugin.hld.f.k.DHH;
    localObject = com.tencent.mm.plugin.hld.f.k.DHH;
    com.tencent.mm.plugin.hld.f.k.q(com.tencent.mm.plugin.hld.f.k.eGO());
    localObject = com.tencent.mm.plugin.hld.f.k.DHH;
    com.tencent.mm.plugin.hld.f.k.eGN();
    if (this.Dtv) {
      com.tencent.e.h.ZvG.bc((Runnable)new e(this));
    }
    StringBuilder localStringBuilder = new StringBuilder("onWindowShown ").append(this.Dtv).append(' ');
    localObject = getCurrentInputEditorInfo();
    if (localObject != null) {}
    for (localObject = ((EditorInfo)localObject).packageName;; localObject = null)
    {
      Log.i("WxIme.WxHldService", (String)localObject + ' ' + l + ' ' + (System.currentTimeMillis() - l));
      AppMethodBeat.o(216465);
      return;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(216503);
    Object localObject = getWindow();
    kotlin.g.b.p.j(localObject, "window");
    localObject = ((Dialog)localObject).getWindow();
    if (localObject != null)
    {
      ((Window)localObject).setNavigationBarColor(eCy().getColor(a.c.ime_keyboard_end_color));
      AppMethodBeat.o(216503);
      return;
    }
    AppMethodBeat.o(216503);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/hld/WxHldService$commitEnglishText$1$3$1"})
  static final class a
    implements Runnable
  {
    a(InputConnection paramInputConnection, aa.d paramd, aa.f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(213435);
      this.DtB.commitText((CharSequence)this.DtD.aaBC, 1);
      AppMethodBeat.o(213435);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/WxHldService$Companion;", "", "()V", "TAG", "", "wxHldService", "Lcom/tencent/mm/plugin/hld/api/IImeService;", "getService", "plugin-hld_release"})
  public static final class b {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/WxHldService$InputMethodSessionImpls;", "Landroid/inputmethodservice/InputMethodService$InputMethodSessionImpl;", "Landroid/inputmethodservice/InputMethodService;", "(Lcom/tencent/mm/plugin/hld/WxHldService;)V", "updateSelection", "", "oldSelStart", "", "oldSelEnd", "newSelStart", "newSelEnd", "candidatesStart", "candidatesEnd", "plugin-hld_release"})
  public final class c
    extends InputMethodService.InputMethodSessionImpl
  {
    public c()
    {
      super();
    }
    
    public final void updateSelection(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      AppMethodBeat.i(214019);
      super.updateSelection(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
      Log.d("WxIme.WxHldService", "updateSelection " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramInt4 + ' ' + paramInt5 + ' ' + paramInt6);
      Object localObject = com.tencent.mm.plugin.hld.model.g.DCm;
      if (com.tencent.mm.plugin.hld.model.g.eEh())
      {
        localObject = com.tencent.mm.plugin.hld.model.n.DEn;
        if (!com.tencent.mm.plugin.hld.model.n.eEE())
        {
          AppMethodBeat.o(214019);
          return;
        }
      }
      localObject = com.tencent.mm.plugin.hld.model.n.DEn;
      com.tencent.mm.plugin.hld.model.n.eEL();
      localObject = com.tencent.mm.plugin.hld.model.n.DEn;
      if (com.tencent.mm.plugin.hld.model.n.eEE())
      {
        localObject = com.tencent.mm.plugin.hld.model.n.DEn;
        com.tencent.mm.plugin.hld.model.n.eEQ();
      }
      localObject = com.tencent.mm.plugin.hld.model.g.DCm;
      localObject = com.tencent.mm.plugin.hld.model.g.eEl();
      if (localObject != null)
      {
        ((ImeCandidateView)localObject).eCK();
        AppMethodBeat.o(214019);
        return;
      }
      AppMethodBeat.o(214019);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(WxHldService paramWxHldService, CharSequence paramCharSequence, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(212801);
      Object localObject1 = paramCharSequence;
      if (localObject1 != null)
      {
        final aa.d locald = new aa.d();
        locald.aaBA = 0;
        final aa.f localf = new aa.f();
        int i;
        if (paramBoolean)
        {
          String str = paramCharSequence.subSequence(paramCharSequence.length() - 1, paramCharSequence.length()).toString();
          Object localObject2 = com.tencent.mm.plugin.hld.f.b.DGL;
          str = com.tencent.mm.plugin.hld.f.b.bd(WxHldService.eCz(), str);
          if (!Util.isNullOrNil(str))
          {
            localObject2 = this.DtE.eCs();
            if (localObject2 != null)
            {
              i = ((com.tencent.mm.plugin.hld.a.h)localObject2).start;
              int j = ((CharSequence)localObject1).length();
              localObject2 = x.aazN;
              i += j;
              localObject1 = new StringBuilder((CharSequence)localObject1).append(str);
              kotlin.g.b.p.j(localObject1, "StringBuilder(it).append(pairChar)");
              localObject1 = (CharSequence)localObject1;
              label163:
              localf.aaBC = localObject1;
              localObject1 = com.tencent.mm.plugin.hld.model.g.DCm;
              if (com.tencent.mm.plugin.hld.model.g.eEh())
              {
                localObject1 = com.tencent.mm.plugin.hld.f.b.DGL;
                if (com.tencent.mm.plugin.hld.f.b.ab(paramCharSequence))
                {
                  localObject1 = this.DtE.eCx();
                  if ((localObject1 != null) && (WxHldService.Z((CharSequence)localObject1) == 1)) {
                    locald.aaBA = 1;
                  }
                }
              }
              localObject1 = this.DtE.getCurrentInputConnection();
              if (localObject1 != null)
              {
                if (locald.aaBA <= 0) {
                  break label384;
                }
                ((InputConnection)localObject1).commitText((CharSequence)"", 1);
                if (Build.VERSION.SDK_INT < 24) {
                  break label368;
                }
                ((InputConnection)localObject1).deleteSurroundingTextInCodePoints(locald.aaBA, 0);
                label273:
                com.tencent.e.h.ZvG.n((Runnable)new a((InputConnection)localObject1, locald, localf), 1L);
              }
            }
          }
        }
        for (;;)
        {
          if (i != 0) {
            this.DtE.Un(i);
          }
          localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
          if (com.tencent.mm.plugin.hld.f.l.eGY())
          {
            localObject1 = com.tencent.mm.plugin.hld.model.g.DCm;
            com.tencent.mm.plugin.hld.model.g.eEi();
          }
          localObject1 = com.tencent.mm.plugin.hld.model.k.DDb;
          com.tencent.mm.plugin.hld.model.k.UD(((CharSequence)localf.aaBC).length());
          AppMethodBeat.o(212801);
          return;
          i = 0;
          break;
          i = 0;
          break label163;
          i = 0;
          break label163;
          label368:
          ((InputConnection)localObject1).deleteSurroundingText(locald.aaBA, 0);
          break label273;
          label384:
          ((InputConnection)localObject1).commitText((CharSequence)localf.aaBC, 1);
        }
      }
      AppMethodBeat.o(212801);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/hld/WxHldService$commitText$1$1$2$1"})
    static final class a
      implements Runnable
    {
      a(InputConnection paramInputConnection, aa.d paramd, aa.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(210953);
        this.DtB.commitText((CharSequence)localf.aaBC, 1);
        AppMethodBeat.o(210953);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(WxHldService paramWxHldService) {}
    
    public final void run()
    {
      AppMethodBeat.i(211523);
      this.DtE.eCt();
      AppMethodBeat.o(211523);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/hld/WxHldService$updateEnglishStrikeView$4$1"})
  static final class f
    implements Runnable
  {
    f(InputConnection paramInputConnection, aa.d paramd, aa.f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(213799);
      this.DtB.commitText((CharSequence)localf.aaBC, 1);
      AppMethodBeat.o(213799);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.WxHldService
 * JD-Core Version:    0.7.0.1
 */