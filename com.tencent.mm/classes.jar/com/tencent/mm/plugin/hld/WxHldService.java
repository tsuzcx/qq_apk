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
import com.tencent.mm.plugin.hld.candidate.ImeCandidateView;
import com.tencent.mm.plugin.hld.e.a;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.model.f;
import com.tencent.mm.plugin.hld.model.g;
import com.tencent.mm.plugin.hld.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.wxhld.WxhldApi;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/WxHldService;", "Landroid/inputmethodservice/InputMethodService;", "Lcom/tencent/mm/plugin/hld/api/IImeService;", "()V", "keyboardShow", "", "mAttribute", "Landroid/view/inputmethod/EditorInfo;", "mImeKeyboardActionListener", "Lcom/tencent/mm/plugin/hld/key/ImeKeyboardActionListener;", "switchToAnotherIme", "getSwitchToAnotherIme", "()Z", "setSwitchToAnotherIme", "(Z)V", "commitEmojiToWX", "", "emojiStr", "", "commitEnglishText", "text", "", "lastPending", "isEnglishSP", "commitText", "checkPairSymbol", "deleteText", "deleteLen", "", "getActionType", "getAroundText", "Lcom/tencent/mm/plugin/hld/api/ImeAroundText;", "num", "getBeforeText", "getContext", "Landroid/content/Context;", "getCurrentPackageName", "getCurrentSelection", "Lcom/tencent/mm/plugin/hld/api/ImeSelection;", "getEndSpaceLength", "str", "getImeKeyboardActionListener", "getImeResources", "Landroid/content/res/Resources;", "getResources", "getWechatScene", "handleActionKey", "handleBack", "keyCode", "handleNewLine", "ifActionNewLine", "isKeyboardShow", "isSafetyKeyboard", "isWeChat", "moveSelection", "index", "onComputeInsets", "outInsets", "Landroid/inputmethodservice/InputMethodService$Insets;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onCreateCandidatesView", "Landroid/view/View;", "onCreateInputMethodSessionInterface", "Landroid/inputmethodservice/AbstractInputMethodService$AbstractInputMethodSessionImpl;", "Landroid/inputmethodservice/AbstractInputMethodService;", "onCreateInputView", "onDestroy", "onEvaluateFullscreenMode", "onFinishInput", "onKeyDown", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onStartInput", "attribute", "restarting", "onStartInputView", "info", "onUpdateSelection", "oldSelStart", "oldSelEnd", "newSelStart", "newSelEnd", "candidatesStart", "candidatesEnd", "onWindowHidden", "onWindowShown", "reset", "supportWxEmoji", "switchToDefaultIme", "updateEditorInfo", "updateEnglishStrikeView", "lastPendingInput", "updateKeyboard", "Companion", "InputMethodSessionImpls", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public class WxHldService
  extends InputMethodService
  implements com.tencent.mm.plugin.hld.a.b
{
  public static final WxHldService.a Jnb;
  private static com.tencent.mm.plugin.hld.a.b Jng;
  public boolean Jnc;
  private boolean Jnd;
  private EditorInfo Jne;
  private a Jnf;
  
  static
  {
    AppMethodBeat.i(311484);
    Jnb = new WxHldService.a((byte)0);
    AppMethodBeat.o(311484);
  }
  
  private static final void a(InputConnection paramInputConnection, ah.f paramf)
  {
    AppMethodBeat.i(311455);
    s.u(paramInputConnection, "$connection");
    s.u(paramf, "$commitText");
    paramInputConnection.commitText((CharSequence)paramf.aqH, 1);
    AppMethodBeat.o(311455);
  }
  
  private static final void a(WxHldService paramWxHldService)
  {
    AppMethodBeat.i(311451);
    s.u(paramWxHldService, "this$0");
    paramWxHldService.fKw();
    AppMethodBeat.o(311451);
  }
  
  private static final void a(CharSequence paramCharSequence, boolean paramBoolean, WxHldService paramWxHldService)
  {
    AppMethodBeat.i(311463);
    s.u(paramWxHldService, "this$0");
    ah.f localf;
    Object localObject1;
    int i;
    int j;
    if (paramCharSequence != null)
    {
      localf = new ah.f();
      if (!paramBoolean) {
        break label305;
      }
      localObject1 = paramCharSequence.subSequence(paramCharSequence.length() - 1, paramCharSequence.length()).toString();
      Object localObject2 = com.tencent.mm.plugin.hld.f.b.Jyf;
      localObject1 = com.tencent.mm.plugin.hld.f.b.bf(getContext(), (String)localObject1);
      if (Util.isNullOrNil((String)localObject1)) {
        break label297;
      }
      localObject2 = paramWxHldService.fKv();
      if (localObject2 == null) {
        break label351;
      }
      i = ((com.tencent.mm.plugin.hld.a.h)localObject2).start;
      j = paramCharSequence.length();
      localObject2 = ah.aiuX;
      i += j;
    }
    for (;;)
    {
      localObject1 = (CharSequence)new StringBuilder(paramCharSequence).append((String)localObject1);
      localf.aqH = localObject1;
      localObject1 = g.JuL;
      if (g.fMj())
      {
        localObject1 = com.tencent.mm.plugin.hld.f.b.Jyf;
        if (com.tencent.mm.plugin.hld.f.b.ak(paramCharSequence))
        {
          paramCharSequence = paramWxHldService.fKA();
          if ((paramCharSequence == null) || (ai(paramCharSequence) != 1)) {}
        }
      }
      for (j = 1;; j = 0)
      {
        paramCharSequence = paramWxHldService.getCurrentInputConnection();
        if (paramCharSequence != null)
        {
          if (j <= 0) {
            break label326;
          }
          paramCharSequence.commitText((CharSequence)"", 1);
          if (Build.VERSION.SDK_INT < 24) {
            break label313;
          }
          paramCharSequence.deleteSurroundingTextInCodePoints(j, 0);
          label225:
          com.tencent.threadpool.h.ahAA.o(new WxHldService..ExternalSyntheticLambda1(paramCharSequence, localf), 1L);
        }
        for (;;)
        {
          if (i != 0) {
            paramWxHldService.Yj(i);
          }
          paramCharSequence = l.JyV;
          if (l.fOH())
          {
            paramCharSequence = g.JuL;
            g.fMk();
          }
          paramCharSequence = com.tencent.mm.plugin.hld.model.k.JvH;
          com.tencent.mm.plugin.hld.model.k.YB(((CharSequence)localf.aqH).length());
          AppMethodBeat.o(311463);
          return;
          label297:
          localObject1 = paramCharSequence;
          i = 0;
          break;
          label305:
          localObject1 = paramCharSequence;
          i = 0;
          break;
          label313:
          paramCharSequence.deleteSurroundingText(j, 0);
          break label225;
          label326:
          paramCharSequence.commitText((CharSequence)localf.aqH, 1);
        }
      }
      label351:
      i = 0;
    }
  }
  
  private static int ai(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(311438);
    s.u(paramCharSequence, "str");
    Object localObject = paramCharSequence.toString();
    if (localObject == null)
    {
      paramCharSequence = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(311438);
      throw paramCharSequence;
    }
    localObject = ((String)localObject).toCharArray();
    s.s(localObject, "(this as java.lang.String).toCharArray()");
    int i = localObject.length;
    while ((i > 0) && (s.compare(localObject[(i - 1)], 32) <= 0)) {
      i -= 1;
    }
    if (i < localObject.length)
    {
      int j = paramCharSequence.toString().length();
      AppMethodBeat.o(311438);
      return j - i;
    }
    AppMethodBeat.o(311438);
    return 0;
  }
  
  private static final void b(InputConnection paramInputConnection, ah.f paramf)
  {
    AppMethodBeat.i(311468);
    s.u(paramInputConnection, "$connection");
    s.u(paramf, "$commitText");
    paramInputConnection.commitText((CharSequence)paramf.aqH, 1);
    AppMethodBeat.o(311468);
  }
  
  private static final void c(InputConnection paramInputConnection, ah.f paramf)
  {
    AppMethodBeat.i(311475);
    s.u(paramInputConnection, "$connection");
    s.u(paramf, "$commitText");
    paramInputConnection.commitText((CharSequence)paramf.aqH, 1);
    AppMethodBeat.o(311475);
  }
  
  private CharSequence fKA()
  {
    AppMethodBeat.i(311442);
    Object localObject = getCurrentInputConnection();
    if (localObject == null)
    {
      localObject = (CharSequence)"";
      AppMethodBeat.o(311442);
      return localObject;
    }
    localObject = ((InputConnection)localObject).getTextBeforeCursor(2147483647, 0);
    if (localObject == null)
    {
      localObject = (CharSequence)"";
      AppMethodBeat.o(311442);
      return localObject;
    }
    AppMethodBeat.o(311442);
    return localObject;
  }
  
  private static Resources fKB()
  {
    AppMethodBeat.i(311446);
    Resources localResources = getContext().getResources();
    s.s(localResources, "getContext().resources");
    AppMethodBeat.o(311446);
    return localResources;
  }
  
  private static void fKp()
  {
    AppMethodBeat.i(311434);
    Object localObject = com.tencent.mm.plugin.hld.f.i.JyA;
    com.tencent.mm.plugin.hld.f.i.fOr();
    g.JuL.fLY();
    localObject = com.tencent.mm.plugin.hld.model.n.JvW;
    com.tencent.mm.plugin.hld.model.n.fMI();
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
    AppMethodBeat.o(311434);
  }
  
  private static Context getContext()
  {
    AppMethodBeat.i(311444);
    Context localContext = MMApplicationContext.getContext();
    s.s(localContext, "getContext()");
    AppMethodBeat.o(311444);
    return localContext;
  }
  
  public final void Yi(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(311729);
    Log.i("WxIme.WxHldService", s.X("deleteText ", Integer.valueOf(paramInt)));
    Object localObject = getCurrentInputConnection();
    if (localObject != null)
    {
      if (!Util.isNullOrNil(((InputConnection)localObject).getSelectedText(0))) {
        break label96;
      }
      if (paramInt > 0)
      {
        int j;
        do
        {
          j = i + 1;
          sendDownUpKeyEvents(67);
          i = j;
        } while (j < paramInt);
      }
    }
    for (;;)
    {
      localObject = l.JyV;
      if (l.fOH())
      {
        localObject = g.JuL;
        g.fMk();
      }
      AppMethodBeat.o(311729);
      return;
      label96:
      ((InputConnection)localObject).commitText((CharSequence)"", 1);
    }
  }
  
  public final void Yj(int paramInt)
  {
    AppMethodBeat.i(311746);
    InputConnection localInputConnection = getCurrentInputConnection();
    if (localInputConnection != null) {
      localInputConnection.setSelection(paramInt, paramInt);
    }
    AppMethodBeat.o(311746);
  }
  
  public final com.tencent.mm.plugin.hld.a.e Yk(int paramInt)
  {
    AppMethodBeat.i(311789);
    Object localObject = null;
    InputConnection localInputConnection = getCurrentInputConnection();
    if (localInputConnection != null)
    {
      localObject = localInputConnection.getTextBeforeCursor(paramInt, 0);
      CharSequence localCharSequence = localInputConnection.getTextAfterCursor(paramInt, 0);
      localObject = new com.tencent.mm.plugin.hld.a.e((CharSequence)localObject, localInputConnection.getSelectedText(0), localCharSequence);
    }
    AppMethodBeat.o(311789);
    return localObject;
  }
  
  public final void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(311668);
    Object localObject = l.JyV;
    l.jC("WxIme.WxHldService", s.X("commitEnglishText ", paramCharSequence2));
    if (Util.isNullOrNil(paramCharSequence1))
    {
      Log.i("WxIme.WxHldService", "commitText null");
      AppMethodBeat.o(311668);
      return;
    }
    int i;
    if (paramCharSequence1 != null)
    {
      localObject = new ah.f();
      ((ah.f)localObject).aqH = paramCharSequence1;
      if (paramCharSequence2 == null)
      {
        paramCharSequence2 = null;
        if (paramCharSequence2 != null) {
          break label508;
        }
        paramCharSequence2 = (WxHldService)this;
        com.tencent.mm.plugin.hld.f.b localb = com.tencent.mm.plugin.hld.f.b.Jyf;
        if (!com.tencent.mm.plugin.hld.f.b.ak(paramCharSequence1)) {
          break label508;
        }
        paramCharSequence1 = paramCharSequence2.fKA();
        if ((paramCharSequence1 == null) || (ai(paramCharSequence1) != 1)) {
          break label508;
        }
        i = 1;
        label112:
        paramCharSequence1 = getCurrentInputConnection();
        if (paramCharSequence1 != null)
        {
          if (i <= 0) {
            break label489;
          }
          paramCharSequence1.commitText((CharSequence)"", 1);
          if (Build.VERSION.SDK_INT < 24) {
            break label477;
          }
          paramCharSequence1.deleteSurroundingTextInCodePoints(i, 0);
          label156:
          com.tencent.threadpool.h.ahAA.o(new WxHldService..ExternalSyntheticLambda0(paramCharSequence1, (ah.f)localObject), 1L);
        }
        label176:
        paramCharSequence1 = l.JyV;
        if (l.fOH())
        {
          paramCharSequence1 = g.JuL;
          g.fMk();
        }
        paramCharSequence1 = com.tencent.mm.plugin.hld.model.k.JvH;
        com.tencent.mm.plugin.hld.model.k.YB(((CharSequence)((ah.f)localObject).aqH).length());
      }
    }
    else
    {
      AppMethodBeat.o(311668);
      return;
    }
    int n = Math.min(paramCharSequence2.length(), ((CharSequence)((ah.f)localObject).aqH).length());
    int k;
    label254:
    int m;
    if (n > 0)
    {
      k = 0;
      i = 0;
      m = k + 1;
      j = i;
      if (Util.isEqual(Character.valueOf(paramCharSequence2.charAt(k)), Character.valueOf(((CharSequence)((ah.f)localObject).aqH).charAt(k))))
      {
        i += 1;
        if (m < n) {
          break label513;
        }
      }
    }
    for (int j = i;; j = 0)
    {
      if (j == paramCharSequence2.length())
      {
        if (((CharSequence)((ah.f)localObject).aqH).length() == j) {}
        for (paramCharSequence2 = (CharSequence)"";; paramCharSequence2 = ((CharSequence)((ah.f)localObject).aqH).subSequence(j, ((CharSequence)((ah.f)localObject).aqH).length()))
        {
          ((ah.f)localObject).aqH = paramCharSequence2;
          paramCharSequence2 = ah.aiuX;
          break;
        }
      }
      i = paramCharSequence2.length() - j;
      paramCharSequence2 = getCurrentInputConnection();
      if (paramCharSequence2 != null)
      {
        if (Build.VERSION.SDK_INT < 24) {
          break label465;
        }
        paramCharSequence2.deleteSurroundingTextInCodePoints(i, 0);
      }
      for (;;)
      {
        ((ah.f)localObject).aqH = ((CharSequence)((ah.f)localObject).aqH).subSequence(j, ((CharSequence)((ah.f)localObject).aqH).length());
        break;
        label465:
        paramCharSequence2.deleteSurroundingText(i, 0);
      }
      label477:
      paramCharSequence1.deleteSurroundingText(i, 0);
      break label156;
      label489:
      paramCharSequence1.commitText((CharSequence)((ah.f)localObject).aqH, 1);
      break label176;
      label508:
      i = 0;
      break label112;
      label513:
      k = m;
      break label254;
    }
  }
  
  public final void aj(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(369992);
    c(paramCharSequence, false);
    AppMethodBeat.o(369992);
  }
  
  public final void b(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(311686);
    Object localObject = l.JyV;
    l.jC("WxIme.WxHldService", s.X("updateEnglishStrikeView ", paramCharSequence2));
    int k;
    int i;
    if (Util.isNullOrNil(paramCharSequence1))
    {
      if (paramCharSequence2 != null)
      {
        k = paramCharSequence2.length() - 1;
        if (k >= 0)
        {
          i = 0;
          do
          {
            j = i + 1;
            sendDownUpKeyEvents(67);
            i = j;
          } while (j <= k);
        }
      }
      AppMethodBeat.o(311686);
      return;
    }
    localObject = new ah.f();
    s.checkNotNull(paramCharSequence1);
    ((ah.f)localObject).aqH = paramCharSequence1;
    int m;
    if (!Util.isNullOrNil(paramCharSequence2))
    {
      s.checkNotNull(paramCharSequence2);
      int n = Math.min(paramCharSequence2.length(), ((CharSequence)((ah.f)localObject).aqH).length());
      if (n <= 0) {
        break label528;
      }
      k = 0;
      i = 0;
      m = k + 1;
      j = i;
      if (Util.isEqual(Character.valueOf(paramCharSequence2.charAt(k)), Character.valueOf(((CharSequence)((ah.f)localObject).aqH).charAt(k))))
      {
        i += 1;
        if (m < n) {
          break label521;
        }
      }
    }
    label516:
    label521:
    label528:
    for (int j = i;; j = 0)
    {
      if (j == paramCharSequence2.length()) {
        if (((CharSequence)((ah.f)localObject).aqH).length() == j)
        {
          paramCharSequence1 = (CharSequence)"";
          ((ah.f)localObject).aqH = paramCharSequence1;
          i = 0;
        }
      }
      for (;;)
      {
        label246:
        paramCharSequence1 = getCurrentInputConnection();
        if (paramCharSequence1 != null)
        {
          if (i <= 0) {
            break label497;
          }
          paramCharSequence1.commitText((CharSequence)"", 1);
          if (Build.VERSION.SDK_INT < 24) {
            break label485;
          }
          paramCharSequence1.deleteSurroundingTextInCodePoints(i, 0);
          label290:
          com.tencent.threadpool.h.ahAA.o(new WxHldService..ExternalSyntheticLambda2(paramCharSequence1, (ah.f)localObject), 1L);
        }
        for (;;)
        {
          paramCharSequence1 = l.JyV;
          if (l.fOH())
          {
            paramCharSequence1 = g.JuL;
            g.fMk();
          }
          AppMethodBeat.o(311686);
          return;
          paramCharSequence1 = ((CharSequence)((ah.f)localObject).aqH).subSequence(j, ((CharSequence)((ah.f)localObject).aqH).length());
          break;
          i = paramCharSequence2.length() - j;
          paramCharSequence1 = getCurrentInputConnection();
          if (paramCharSequence1 != null)
          {
            if (Build.VERSION.SDK_INT < 24) {
              break label440;
            }
            paramCharSequence1.deleteSurroundingTextInCodePoints(i, 0);
          }
          for (;;)
          {
            ((ah.f)localObject).aqH = ((CharSequence)((ah.f)localObject).aqH).subSequence(j, ((CharSequence)((ah.f)localObject).aqH).length());
            i = 0;
            break;
            label440:
            paramCharSequence1.deleteSurroundingText(i, 0);
          }
          paramCharSequence2 = com.tencent.mm.plugin.hld.f.b.Jyf;
          if (!com.tencent.mm.plugin.hld.f.b.ak(paramCharSequence1)) {
            break label516;
          }
          paramCharSequence1 = fKA();
          if ((paramCharSequence1 == null) || (ai(paramCharSequence1) != 1)) {
            break label516;
          }
          i = 1;
          break label246;
          label485:
          paramCharSequence1.deleteSurroundingText(i, 0);
          break label290;
          label497:
          paramCharSequence1.commitText((CharSequence)((ah.f)localObject).aqH, 1);
        }
        i = 0;
      }
      k = m;
      break;
    }
  }
  
  public final void c(CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(311657);
    if (Util.isNullOrNil(paramCharSequence))
    {
      Log.i("WxIme.WxHldService", "commitText null");
      AppMethodBeat.o(311657);
      return;
    }
    com.tencent.threadpool.h.ahAA.bm(new WxHldService..ExternalSyntheticLambda4(paramCharSequence, paramBoolean, this));
    AppMethodBeat.o(311657);
  }
  
  public final void fKq()
  {
    AppMethodBeat.i(311635);
    Log.d("WxIme.WxHldService", s.X("handleActionKey ", Integer.valueOf(fKt())));
    switch (fKt())
    {
    case 6: 
    default: 
      fKs();
    }
    InputConnection localInputConnection;
    do
    {
      AppMethodBeat.o(311635);
      return;
      localInputConnection = getCurrentInputConnection();
    } while (localInputConnection == null);
    localInputConnection.performEditorAction(fKt());
    AppMethodBeat.o(311635);
  }
  
  public final boolean fKr()
  {
    AppMethodBeat.i(311643);
    Log.d("WxIme.WxHldService", s.X("handleActionKey ", Integer.valueOf(fKt())));
    switch (fKt())
    {
    case 6: 
    default: 
      AppMethodBeat.o(311643);
      return true;
    }
    AppMethodBeat.o(311643);
    return false;
  }
  
  public final void fKs()
  {
    AppMethodBeat.i(311650);
    c((CharSequence)"\n", false);
    AppMethodBeat.o(311650);
  }
  
  public final int fKt()
  {
    int j = 1;
    EditorInfo localEditorInfo = this.Jne;
    if (localEditorInfo == null) {}
    for (int i = 0; (i & 0x40000000) == 1073741824; i = localEditorInfo.imeOptions) {
      return 1;
    }
    localEditorInfo = this.Jne;
    if (localEditorInfo == null) {}
    for (i = j;; i = localEditorInfo.imeOptions) {
      return i & 0xFF;
    }
  }
  
  public final boolean fKu()
  {
    return this.Jnd;
  }
  
  public final com.tencent.mm.plugin.hld.a.h fKv()
  {
    AppMethodBeat.i(311736);
    Object localObject = getCurrentInputConnection();
    if (localObject == null)
    {
      AppMethodBeat.o(311736);
      return null;
    }
    localObject = ((InputConnection)localObject).getExtractedText(new ExtractedTextRequest(), 0);
    if (localObject == null)
    {
      AppMethodBeat.o(311736);
      return null;
    }
    localObject = new com.tencent.mm.plugin.hld.a.h(((ExtractedText)localObject).selectionStart, ((ExtractedText)localObject).selectionEnd);
    AppMethodBeat.o(311736);
    return localObject;
  }
  
  public final void fKw()
  {
    AppMethodBeat.i(311760);
    Object localObject = getSystemService("input_method");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(311760);
      throw ((Throwable)localObject);
    }
    localObject = ((InputMethodManager)localObject).getEnabledInputMethodList();
    if (((List)localObject).size() == 1)
    {
      Log.e("WxIme.WxHldService", "only wxime!!");
      AppMethodBeat.o(311760);
      return;
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      Log.w("WxIme.WxHldService", s.X("switchToNextInputMethod ", Boolean.valueOf(switchToNextInputMethod(false))));
      AppMethodBeat.o(311760);
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      InputMethodInfo localInputMethodInfo = (InputMethodInfo)((Iterator)localObject).next();
      String str = localInputMethodInfo.getId();
      o localo = o.Jwm;
      if (!s.p(str, o.fNf()))
      {
        str = localInputMethodInfo.getId();
        localo = o.Jwm;
        if (!s.p(str, o.fNg()))
        {
          Log.i("WxIme.WxHldService", s.X("switch to ", localInputMethodInfo.getId()));
          switchInputMethod(localInputMethodInfo.getId());
        }
      }
    }
    AppMethodBeat.o(311760);
  }
  
  public final boolean fKx()
  {
    AppMethodBeat.i(311765);
    boolean bool = Util.isEqual(getCurrentInputEditorInfo().packageName, MMApplicationContext.getApplicationId());
    AppMethodBeat.o(311765);
    return bool;
  }
  
  public final boolean fKy()
  {
    AppMethodBeat.i(311775);
    Object localObject = getCurrentInputEditorInfo();
    if (localObject == null)
    {
      AppMethodBeat.o(311775);
      return false;
    }
    localObject = ((EditorInfo)localObject).extras;
    if (localObject == null)
    {
      AppMethodBeat.o(311775);
      return false;
    }
    boolean bool = ((Bundle)localObject).getBoolean("if_support_wx_emoji");
    AppMethodBeat.o(311775);
    return bool;
  }
  
  public final int fKz()
  {
    AppMethodBeat.i(311780);
    Object localObject = getCurrentInputEditorInfo();
    if (localObject == null)
    {
      AppMethodBeat.o(311780);
      return 5;
    }
    localObject = ((EditorInfo)localObject).extras;
    if (localObject == null)
    {
      AppMethodBeat.o(311780);
      return 5;
    }
    int i = ((Bundle)localObject).getInt("wechat_scene");
    AppMethodBeat.o(311780);
    return i;
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(311798);
    if (getBaseContext() != null)
    {
      Object localObject = getBaseContext().getResources();
      localResources = super.getResources();
      if (((localResources instanceof com.tencent.mm.ce.d)) && (localObject != null))
      {
        localObject = ((com.tencent.mm.ce.d)localResources).acma.h(((Resources)localObject).getConfiguration());
        com.tencent.mm.ce.e.a((Configuration)localObject, aw.f(localResources));
        ((com.tencent.mm.ce.d)localResources).getConfiguration().updateFrom((Configuration)localObject);
      }
      AppMethodBeat.o(311798);
      return localResources;
    }
    Log.e("WxIme.WxHldService", "no base context!!");
    Resources localResources = super.getResources();
    AppMethodBeat.o(311798);
    return localResources;
  }
  
  public void onComputeInsets(InputMethodService.Insets paramInsets)
  {
    AppMethodBeat.i(311537);
    s.u(paramInsets, "outInsets");
    super.onComputeInsets(paramInsets);
    paramInsets.contentTopInsets = paramInsets.visibleTopInsets;
    AppMethodBeat.o(311537);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(311564);
    s.u(paramConfiguration, "newConfig");
    Object localObject1 = new StringBuilder("onConfigurationChanged lastOrientation:");
    Object localObject2 = com.tencent.mm.plugin.hld.f.k.JyF;
    localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.plugin.hld.f.k.fOu()).append(" orientation:").append(Integer.valueOf(paramConfiguration.orientation)).append(" darkMode:").append(aw.isDarkMode()).append(' ');
    localObject2 = MMApplicationContext.getContext().getResources();
    if (localObject2 == null)
    {
      paramConfiguration = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.resources.MMResources");
      AppMethodBeat.o(311564);
      throw paramConfiguration;
    }
    Log.i("WxIme.WxHldService", ((com.tencent.mm.ce.d)localObject2).mResources.getConfiguration().uiMode);
    localObject1 = com.tencent.mm.plugin.hld.f.k.JyF;
    localObject1 = getContext();
    int i = paramConfiguration.orientation;
    s.u(localObject1, "context");
    Log.i("WxIme.WxImeUIUtil", "updateConfiguration " + com.tencent.mm.plugin.hld.f.k.JyG + ' ' + i + ' ' + com.tencent.mm.plugin.hld.f.k.JyI + ' ' + aw.isDarkMode());
    localObject2 = com.tencent.mm.plugin.hld.f.k.JyG;
    if (localObject2 == null) {}
    for (;;)
    {
      com.tencent.mm.plugin.hld.f.k.JyH = com.tencent.mm.plugin.hld.f.k.JyG;
      com.tencent.mm.plugin.hld.f.k.JyG = Integer.valueOf(i);
      com.tencent.mm.plugin.hld.f.k.JyI = aw.isDarkMode();
      com.tencent.mm.plugin.hld.f.k.reset((Context)localObject1);
      do
      {
        super.onConfigurationChanged(paramConfiguration);
        paramConfiguration = MMApplicationContext.getContext().getResources();
        if (paramConfiguration != null) {
          break label294;
        }
        paramConfiguration = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.resources.MMResources");
        AppMethodBeat.o(311564);
        throw paramConfiguration;
        if (((Integer)localObject2).intValue() != i) {
          break;
        }
      } while (com.tencent.mm.plugin.hld.f.k.JyI == aw.isDarkMode());
    }
    label294:
    Log.d("WxIme.WxHldService", s.X("onConfigurationChanged  ", Integer.valueOf(((com.tencent.mm.ce.d)paramConfiguration).mResources.getConfiguration().uiMode)));
    AppMethodBeat.o(311564);
  }
  
  public void onCreate()
  {
    boolean bool = false;
    AppMethodBeat.i(311526);
    super.onCreate();
    long l1 = System.currentTimeMillis();
    Log.i("WxIme.WxHldService", s.X("onCreate ", Long.valueOf(l1)));
    Object localObject = getWindow().getWindow();
    if (localObject != null) {
      ((Window)localObject).setNavigationBarColor(fKB().getColor(a.c.ime_keyboard_end_color));
    }
    Jng = (com.tencent.mm.plugin.hld.a.b)this;
    localObject = com.tencent.mm.plugin.hld.model.a.b.JwG;
    long l2 = System.currentTimeMillis();
    localObject = l.JyV;
    localObject = kotlin.n.n.a((CharSequence)l.fOK(), new String[] { "_" });
    int i;
    if (((List)localObject).size() == 2)
    {
      i = 1;
      if (i == 0) {
        break label433;
      }
      label120:
      if (localObject != null)
      {
        com.tencent.mm.plugin.hld.model.a.b.JwI = Util.safeParseLong((String)((List)localObject).get(0));
        com.tencent.mm.plugin.hld.model.a.b.JwJ = Util.safeParseLong((String)((List)localObject).get(1));
      }
      if ((l2 - com.tencent.mm.plugin.hld.model.a.b.JwK > com.tencent.mm.plugin.hld.model.a.b.JwI) || (com.tencent.mm.plugin.hld.model.a.b.JwL < com.tencent.mm.plugin.hld.model.a.b.JwJ)) {
        break label456;
      }
      com.tencent.mm.plugin.hld.model.a.b.reset();
    }
    for (;;)
    {
      Log.i("WxIme.ImeRecovery", "initRecovery initResult:" + bool + " monitorTime:" + com.tencent.mm.plugin.hld.model.a.b.JwI + " maxCrashNum:" + com.tencent.mm.plugin.hld.model.a.b.JwJ + " nowTime:" + l2);
      if (bool)
      {
        this.Jnf = new a(getContext(), fKB());
        localObject = com.tencent.mm.plugin.hld.model.n.JvW;
        com.tencent.mm.plugin.hld.model.n.im(getContext());
        localObject = com.tencent.mm.plugin.hld.f.k.JyF;
        com.tencent.mm.plugin.hld.f.k.sE(fKB().getConfiguration().orientation);
        localObject = f.JuH;
        f.init(getContext());
        localObject = g.JuL;
        localObject = getContext();
        a locala = this.Jnf;
        s.checkNotNull(locala);
        g.a((Context)localObject, (com.tencent.mm.plugin.hld.a.c)locala);
        com.tencent.mm.plugin.hld.candidate.e.Jon.fKP();
        g.JuL.ii(getContext());
      }
      for (;;)
      {
        l2 = System.currentTimeMillis();
        localObject = com.tencent.mm.plugin.hld.model.k.JvH;
        com.tencent.mm.plugin.hld.model.k.aM(l1, l2);
        Log.i("WxIme.WxHldService", "onCreate " + bool + ' ' + l1 + ' ' + (l2 - l1) + ' ' + hashCode());
        AppMethodBeat.o(311526);
        return;
        i = 0;
        break;
        label433:
        localObject = null;
        break label120;
        this.Jnc = true;
        Log.e("WxIme.WxHldService", "repeatedly crash, switch to another ime!!");
      }
      label456:
      bool = true;
    }
  }
  
  public View onCreateCandidatesView()
  {
    return null;
  }
  
  public AbstractInputMethodService.AbstractInputMethodSessionImpl onCreateInputMethodSessionInterface()
  {
    AppMethodBeat.i(311628);
    AbstractInputMethodService.AbstractInputMethodSessionImpl localAbstractInputMethodSessionImpl = (AbstractInputMethodService.AbstractInputMethodSessionImpl)new b();
    AppMethodBeat.o(311628);
    return localAbstractInputMethodSessionImpl;
  }
  
  public View onCreateInputView()
  {
    AppMethodBeat.i(311531);
    Log.i("WxIme.WxHldService", s.X("onCreateInputView ", Long.valueOf(System.currentTimeMillis())));
    Object localObject = g.JuL;
    localObject = g.fMc();
    if (((View)localObject).getParent() != null)
    {
      if (!(((View)localObject).getParent() instanceof ViewGroup)) {
        break label93;
      }
      ViewParent localViewParent = ((View)localObject).getParent();
      if (localViewParent == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(311531);
        throw ((Throwable)localObject);
      }
      ((ViewGroup)localViewParent).removeView((View)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(311531);
      return localObject;
      label93:
      Log.e("WxIme.WxHldService", s.X("onCreateInputView ", ((View)localObject).getParent()));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(311580);
    super.onDestroy();
    Log.i("WxIme.WxHldService", s.X("onDestroy ", Integer.valueOf(hashCode())));
    WxhldApi.finalize1();
    Object localObject1 = com.tencent.mm.plugin.hld.candidate.e.Jon;
    Object localObject2;
    try
    {
      localObject2 = MMApplicationContext.getContext().getSystemService("clipboard");
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
        AppMethodBeat.o(311580);
        throw ((Throwable)localObject1);
      }
    }
    catch (Exception localException)
    {
      Log.e("WxIme.ImeClipBoardListener", s.X("releaseListener ", localException.getMessage()));
    }
    for (;;)
    {
      com.tencent.mm.app.i.nI(Process.myPid());
      AppMethodBeat.o(311580);
      return;
      ((ClipboardManager)localObject2).removePrimaryClipChangedListener((ClipboardManager.OnPrimaryClipChangedListener)localException);
    }
  }
  
  public boolean onEvaluateFullscreenMode()
  {
    AppMethodBeat.i(311571);
    Log.i("WxIme.WxHldService", "onEvaluateFullscreenMode");
    AppMethodBeat.o(311571);
    return false;
  }
  
  public void onFinishInput()
  {
    AppMethodBeat.i(311553);
    super.onFinishInput();
    AppMethodBeat.o(311553);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int i = 0;
    AppMethodBeat.i(311614);
    Log.i("WxIme.WxHldService", "onKeyDown keyCoed:" + paramInt + ", event:" + paramKeyEvent);
    if (!this.Jnd)
    {
      AppMethodBeat.o(311614);
      return false;
    }
    switch (paramInt)
    {
    }
    while (i != 0)
    {
      AppMethodBeat.o(311614);
      return true;
      requestHideSelf(0);
      i = 1;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(311614);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(311620);
    Log.i("WxIme.WxHldService", "onKeyUp keyCoed:" + paramInt + ", event:" + paramKeyEvent);
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(311620);
    return bool;
  }
  
  public void onStartInput(EditorInfo paramEditorInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(311528);
    long l1 = System.currentTimeMillis();
    super.onStartInput(paramEditorInfo, paramBoolean);
    if ((this.Jne == null) || (paramEditorInfo == null))
    {
      this.Jne = paramEditorInfo;
      paramEditorInfo = g.JuL;
      g.fMk();
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      paramEditorInfo = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.aN(l1, l2);
      Log.i("WxIme.WxHldService", s.X("onStartInput ", Long.valueOf(l2 - l1)));
      AppMethodBeat.o(311528);
      return;
      EditorInfo localEditorInfo = this.Jne;
      s.checkNotNull(localEditorInfo);
      if ((localEditorInfo.imeOptions & 0xFF) != (paramEditorInfo.imeOptions & 0xFF))
      {
        this.Jne = paramEditorInfo;
        paramEditorInfo = g.JuL;
        g.fMk();
      }
    }
  }
  
  public void onStartInputView(EditorInfo paramEditorInfo, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(311545);
    long l1 = System.currentTimeMillis();
    super.onStartInputView(paramEditorInfo, paramBoolean);
    Object localObject1 = com.tencent.mm.plugin.hld.f.k.JyF;
    if (paramEditorInfo == null)
    {
      localObject1 = null;
      com.tencent.mm.plugin.hld.f.k.x((Integer)localObject1);
      localObject1 = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.rQ(System.currentTimeMillis());
      if (this.Jnd) {
        break label205;
      }
      this.Jnd = true;
      fKp();
      localObject1 = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.il(getContext());
      localObject1 = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.hld.a.d.class);
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.hld.a.d)localObject1).fKE();
      }
      long l2 = System.currentTimeMillis();
      localObject1 = com.tencent.mm.plugin.hld.model.k.JvH;
      localObject1 = g.JuL;
      com.tencent.mm.plugin.hld.model.k.k(l1, l2, g.fMo());
      label120:
      localObject1 = new StringBuilder("onStartInputView newType:");
      if (paramEditorInfo != null) {
        break label353;
      }
    }
    label205:
    label353:
    for (paramEditorInfo = localObject2;; paramEditorInfo = Integer.valueOf(paramEditorInfo.inputType))
    {
      paramEditorInfo = ((StringBuilder)localObject1).append(paramEditorInfo).append(" oldType:");
      localObject1 = com.tencent.mm.plugin.hld.f.k.JyF;
      Log.i("WxIme.WxHldService", com.tencent.mm.plugin.hld.f.k.fOy() + ' ' + (l1 - System.currentTimeMillis()));
      AppMethodBeat.o(311545);
      return;
      localObject1 = Integer.valueOf(paramEditorInfo.inputType);
      break;
      Log.w("WxIme.WxHldService", "onWindowShown last:" + this.Jnd + " why????");
      localObject1 = com.tencent.mm.plugin.hld.f.k.JyF;
      localObject1 = com.tencent.mm.plugin.hld.f.k.fOx();
      com.tencent.mm.plugin.hld.f.k localk = com.tencent.mm.plugin.hld.f.k.JyF;
      if (s.p(localObject1, com.tencent.mm.plugin.hld.f.k.fOy()))
      {
        localObject1 = com.tencent.mm.plugin.hld.f.k.JyF;
        localObject1 = com.tencent.mm.plugin.hld.f.k.fOv();
        localk = com.tencent.mm.plugin.hld.f.k.JyF;
        if (s.p(localObject1, com.tencent.mm.plugin.hld.f.k.fOu())) {}
      }
      else
      {
        localObject1 = com.tencent.mm.plugin.hld.model.n.JvW;
        com.tencent.mm.plugin.hld.model.n.fMJ();
        localObject1 = f.JuH;
        f.fLV();
        localObject1 = g.JuL;
        localObject1 = g.fMn();
        if (localObject1 != null) {
          ((ImeCandidateView)localObject1).reset();
        }
        fKp();
      }
      localObject1 = g.JuL;
      if (g.fLX()) {
        break label120;
      }
      localObject1 = g.JuL;
      g.ij(getContext());
      break label120;
    }
  }
  
  public void onUpdateSelection(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(311605);
    super.onUpdateSelection(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    g localg = g.JuL;
    g.fMr();
    AppMethodBeat.o(311605);
  }
  
  public void onWindowHidden()
  {
    AppMethodBeat.i(311597);
    Log.i("WxIme.WxHldService", s.X("onWindowHidden ", Long.valueOf(System.currentTimeMillis())));
    super.onWindowHidden();
    Object localObject = com.tencent.mm.plugin.hld.model.n.JvW;
    Log.i("WxIme.WxEngineMgr", s.X("onWindowHidden needReInitEngine:", Boolean.valueOf(com.tencent.mm.plugin.hld.model.n.Jwk)));
    com.tencent.mm.plugin.hld.model.n.fMJ();
    if (com.tencent.mm.plugin.hld.model.n.Jwk) {
      com.tencent.mm.plugin.hld.model.n.finalize1();
    }
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
    this.Jnd = false;
    AppMethodBeat.o(311597);
  }
  
  public void onWindowShown()
  {
    AppMethodBeat.i(311590);
    long l = System.currentTimeMillis();
    super.onWindowShown();
    Object localObject = com.tencent.mm.plugin.hld.f.k.JyF;
    localObject = com.tencent.mm.plugin.hld.f.k.JyF;
    com.tencent.mm.plugin.hld.f.k.x(com.tencent.mm.plugin.hld.f.k.fOx());
    localObject = com.tencent.mm.plugin.hld.f.k.JyF;
    com.tencent.mm.plugin.hld.f.k.fOw();
    if (this.Jnc) {
      com.tencent.threadpool.h.ahAA.bk(new WxHldService..ExternalSyntheticLambda3(this));
    }
    StringBuilder localStringBuilder = new StringBuilder("onWindowShown ").append(this.Jnc).append(' ');
    localObject = getCurrentInputEditorInfo();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((EditorInfo)localObject).packageName)
    {
      Log.i("WxIme.WxHldService", localObject + ' ' + l + ' ' + (System.currentTimeMillis() - l));
      AppMethodBeat.o(311590);
      return;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(311805);
    Window localWindow = getWindow().getWindow();
    if (localWindow != null) {
      localWindow.setNavigationBarColor(fKB().getColor(a.c.ime_keyboard_end_color));
    }
    AppMethodBeat.o(311805);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/WxHldService$InputMethodSessionImpls;", "Landroid/inputmethodservice/InputMethodService$InputMethodSessionImpl;", "Landroid/inputmethodservice/InputMethodService;", "(Lcom/tencent/mm/plugin/hld/WxHldService;)V", "updateSelection", "", "oldSelStart", "", "oldSelEnd", "newSelStart", "newSelEnd", "candidatesStart", "candidatesEnd", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends InputMethodService.InputMethodSessionImpl
  {
    public b()
    {
      super();
      AppMethodBeat.i(311574);
      AppMethodBeat.o(311574);
    }
    
    public final void updateSelection(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      AppMethodBeat.i(311582);
      super.updateSelection(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
      Log.d("WxIme.WxHldService", "updateSelection " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramInt4 + ' ' + paramInt5 + ' ' + paramInt6);
      Object localObject = g.JuL;
      if (g.fMj())
      {
        localObject = com.tencent.mm.plugin.hld.model.n.JvW;
        if (!com.tencent.mm.plugin.hld.model.n.fMH())
        {
          AppMethodBeat.o(311582);
          return;
        }
      }
      localObject = com.tencent.mm.plugin.hld.model.n.JvW;
      com.tencent.mm.plugin.hld.model.n.fMO();
      localObject = com.tencent.mm.plugin.hld.model.n.JvW;
      if (com.tencent.mm.plugin.hld.model.n.fMH())
      {
        localObject = com.tencent.mm.plugin.hld.model.n.JvW;
        com.tencent.mm.plugin.hld.model.n.fMT();
      }
      localObject = g.JuL;
      localObject = g.fMn();
      if (localObject != null) {
        ((ImeCandidateView)localObject).fKN();
      }
      AppMethodBeat.o(311582);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.WxHldService
 * JD-Core Version:    0.7.0.1
 */