package com.tencent.mm.plugin.hld.model;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.candidate.ImeCandidateView;
import com.tencent.mm.plugin.hld.f.e;
import com.tencent.mm.plugin.hld.f.k.a;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.keyboard.Keyboard;
import com.tencent.mm.plugin.hld.keyboard.S10SettingKeyboard;
import com.tencent.mm.plugin.hld.keyboard.S8ExceptionSettingKeyboard;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.S2ChineseQwertyKeyboard;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.k.b.a;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.d;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/model/ImeKeyboardSwitch;", "", "()V", "TAG", "", "animator_move_to_below", "Landroid/animation/ObjectAnimator;", "animator_move_to_up", "mActiveMaskBt", "Landroid/widget/Button;", "mActiveMaskDescTv", "Landroid/widget/TextView;", "mActiveMaskLl", "Landroid/widget/RelativeLayout;", "mActiveMaskTitleTv", "mCandidateView", "Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateView;", "mContext", "Landroid/content/Context;", "mCurrentFirstLevelKeyboard", "", "Ljava/lang/Integer;", "mFirstInitializeStart", "", "mHasKeySendAction", "mIKeyboardActionListener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "mIfShieldCandidateView", "mImeKeyboardViewMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/hld/keyboard/Keyboard;", "Lkotlin/collections/HashMap;", "mInputBelowView", "Landroid/widget/FrameLayout;", "mInputCenterContainer", "mInputCenterView", "Landroid/view/View;", "mInputContainer", "mInputEmojiView", "mInputLeftView", "mInputLeftView2", "mInputUpView", "mKeyboardStatus", "mKeyboardTask", "Ljava/util/LinkedList;", "mSecondInitializeStart", "getMSecondInitializeStart", "()Z", "setMSecondInitializeStart", "(Z)V", "mSettingBt", "mUpdateDictMaskView", "mUpdateDictMaskViewstub", "Landroid/view/ViewStub;", "addKeyboardTask", "", "keyboard", "(Ljava/lang/Integer;)V", "backLastKeyboard", "firstInitKeyboard", "context", "ordinal", "getBelowAnimator", "beforeCallback", "Lkotlin/Function0;", "afterCallback", "getCurrentFirstLevelKeyboard", "getCurrentKeyboard", "getCurrentKeyboardOrdinal", "getCurrentKeyboardStatus", "getCurrentReportKbType", "getImeCandidateView", "getInputContainer", "getLastKeyboardOrdinal", "getNewKeyboard", "getResId", "getUpAnimator", "getmIfShieldCandidateView", "goExceptionSettingKeyboard", "goImeEmojiKeyboard", "goSettingKeyboard", "back", "handleActiveMaskBtClick", "hasKeySendAction", "init", "listener", "initInputView", "initKeyBoard", "firstInit", "initKeyboardImp", "resource", "initKeyboardRealImpl", "initSwitch", "isCurrentKeyboard", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "isFirstLevelEnglishKeyboard", "isS3EnglishQwertyKeyboard", "isUpperMode", "leftSlideInputLeftKeyboard", "onEngineInitializeSuccess", "onResumeKeyboard", "onSelectCandidate", "text", "id", "", "suffix", "onUpdateSelection", "oldSelStart", "oldSelEnd", "newSelStart", "newSelEnd", "candidatesStart", "candidatesEnd", "preInitKeyBoard", "first", "serialTag", "preInitKeyboards", "removeKeyboardTask", "reset", "resetToFirstLevelKeyboard", "rightSlideInputLeftKeyboard", "secondInitKeyboard", "secondInitSwitch", "setVisibleActiveMaskLl", "visible", "setVisibleUpdateDictMaskView", "showActiveKeyboard", "switchKeyboard", "keyboardOrdinal", "switchToChineseKeyboard", "transparentUpKeyboardBg", "currentKeyboardOrdinal", "transparent", "updateActionKey", "updateCurrentKeyboard", "updateEmojiKeyboard", "updateInputBelowKeyboard", "updateInputKeyboard", "hasLeftSlideAnimation", "hasRightSlideAnimation", "hasUpAnimation", "hasBelowAnimation", "updateUpKeyboard", "updateInputUpKeyboard", "updateKeyboardStatus", "hasStrikeContent", "hasClipboardContent", "updateUpperMod", "viewSaveToImage", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  private static com.tencent.mm.plugin.hld.a.c JnO;
  public static final g JuL;
  private static HashMap<Integer, Keyboard> JuM;
  private static LinkedList<Integer> JuN;
  private static int JuO;
  private static View JuP;
  private static ImeCandidateView JuQ;
  private static RelativeLayout JuR;
  private static FrameLayout JuS;
  private static View JuT;
  private static FrameLayout JuU;
  private static FrameLayout JuV;
  private static FrameLayout JuW;
  private static FrameLayout JuX;
  private static RelativeLayout JuY;
  private static TextView JuZ;
  private static TextView Jva;
  private static Button Jvb;
  private static ViewStub Jvc;
  static View Jvd;
  private static Button Jve;
  private static ObjectAnimator Jvf;
  private static ObjectAnimator Jvg;
  private static boolean Jvh;
  private static boolean Jvi;
  private static boolean Jvj;
  private static Integer Jvk;
  private static boolean Jvl;
  private static Context mContext;
  
  static
  {
    AppMethodBeat.i(312396);
    JuL = new g();
    JuN = new LinkedList();
    JuO = 1;
    AppMethodBeat.o(312396);
  }
  
  private static int Yt(int paramInt)
  {
    AppMethodBeat.i(312026);
    e locale = e.Jym;
    if (e.fOa())
    {
      if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Jrp.ordinal())
      {
        paramInt = a.h.ime_keyboard_s1_chinese_t9_selfdraw;
        AppMethodBeat.o(312026);
        return paramInt;
      }
      if (paramInt != com.tencent.mm.plugin.hld.keyboard.c.Jrq.ordinal())
      {
        if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Jrr.ordinal())
        {
          paramInt = a.h.ime_keyboard_s3_english_qwerty_selfdraw;
          AppMethodBeat.o(312026);
          return paramInt;
        }
        if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Jrs.ordinal())
        {
          paramInt = a.h.ime_keyboard_s4_number_selfdraw;
          AppMethodBeat.o(312026);
          return paramInt;
        }
        if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Jrt.ordinal())
        {
          paramInt = a.h.ime_keyboard_s5_symbol;
          AppMethodBeat.o(312026);
          return paramInt;
        }
        if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Jru.ordinal())
        {
          paramInt = a.h.ime_keyboard_s6_alternative_words;
          AppMethodBeat.o(312026);
          return paramInt;
        }
        if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Jrv.ordinal())
        {
          paramInt = a.h.ime_keyboard_s7_emoji;
          AppMethodBeat.o(312026);
          return paramInt;
        }
        if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Jrw.ordinal())
        {
          paramInt = a.h.ime_keyboard_s8_ime_setting;
          AppMethodBeat.o(312026);
          return paramInt;
        }
        if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Jrx.ordinal())
        {
          paramInt = a.h.ime_keyboard_s9_sound_vibrate;
          AppMethodBeat.o(312026);
          return paramInt;
        }
        if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Jry.ordinal())
        {
          paramInt = a.h.ime_keyboard_s10_setting;
          AppMethodBeat.o(312026);
          return paramInt;
        }
      }
      paramInt = a.h.ime_keyboard_s2_chinese_qwerty_selfdraw;
      AppMethodBeat.o(312026);
      return paramInt;
    }
    if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Jrp.ordinal())
    {
      paramInt = a.h.ime_keyboard_s1_chinese_t9;
      AppMethodBeat.o(312026);
      return paramInt;
    }
    if (paramInt != com.tencent.mm.plugin.hld.keyboard.c.Jrq.ordinal())
    {
      if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Jrr.ordinal())
      {
        paramInt = a.h.ime_keyboard_s3_english_qwerty;
        AppMethodBeat.o(312026);
        return paramInt;
      }
      if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Jrs.ordinal())
      {
        paramInt = a.h.ime_keyboard_s4_number;
        AppMethodBeat.o(312026);
        return paramInt;
      }
      if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Jrt.ordinal())
      {
        paramInt = a.h.ime_keyboard_s5_symbol;
        AppMethodBeat.o(312026);
        return paramInt;
      }
      if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Jru.ordinal())
      {
        paramInt = a.h.ime_keyboard_s6_alternative_words;
        AppMethodBeat.o(312026);
        return paramInt;
      }
      if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Jrv.ordinal())
      {
        paramInt = a.h.ime_keyboard_s7_emoji;
        AppMethodBeat.o(312026);
        return paramInt;
      }
      if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Jrw.ordinal())
      {
        paramInt = a.h.ime_keyboard_s8_ime_setting;
        AppMethodBeat.o(312026);
        return paramInt;
      }
      if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Jrx.ordinal())
      {
        paramInt = a.h.ime_keyboard_s9_sound_vibrate;
        AppMethodBeat.o(312026);
        return paramInt;
      }
      if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Jry.ordinal())
      {
        paramInt = a.h.ime_keyboard_s10_setting;
        AppMethodBeat.o(312026);
        return paramInt;
      }
    }
    paramInt = a.h.ime_keyboard_s2_chinease_qwerty;
    AppMethodBeat.o(312026);
    return paramInt;
  }
  
  private static void Yv(int paramInt)
  {
    View localView2 = null;
    AppMethodBeat.i(312247);
    for (;;)
    {
      try
      {
        localObject1 = Jvc;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label120;
          Jvd = (View)localObject1;
          localObject1 = Jvd;
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(paramInt);
          }
          AppMethodBeat.o(312247);
        }
        else
        {
          localObject1 = ((ViewStub)localObject1).inflate();
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject2 = Jvc;
        if (localObject2 == null) {
          continue;
        }
        ((ViewStub)localObject2).setVisibility(0);
        localObject2 = Jvd;
        if (localObject2 == null) {
          continue;
        }
        ((View)localObject2).setVisibility(paramInt);
        AppMethodBeat.o(312247);
        return;
      }
      finally
      {
        localView2 = Jvd;
        if (localView2 == null) {
          continue;
        }
        localView2.setVisibility(paramInt);
        AppMethodBeat.o(312247);
      }
      localObject1 = ((View)localObject1).findViewById(a.f.update_dict_ll);
      continue;
      label120:
      if (localObject3 == null) {
        View localView1 = localView2;
      }
    }
  }
  
  private static void Yw(int paramInt)
  {
    AppMethodBeat.i(312257);
    Object localObject;
    int i;
    if (paramInt == 0)
    {
      localObject = com.tencent.mm.plugin.hld.f.i.JyA;
      if (com.tencent.mm.plugin.hld.f.i.bGa()) {
        break label158;
      }
      localObject = (d)com.tencent.mm.kernel.h.ax(d.class);
      if (localObject == null) {
        break label153;
      }
      localObject = ((d)localObject).fKG();
      if ((localObject == null) || (((com.tencent.mm.plugin.hld.a.b)localObject).fKx() != true)) {
        break label153;
      }
      i = 1;
      if (i == 0) {
        break label158;
      }
      localObject = JuZ;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)MMApplicationContext.getContext().getString(a.j.ime_keyboard_active_title_exchange));
      }
      localObject = Jva;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)MMApplicationContext.getContext().getString(a.j.ime_keyboard_active_desc_exchange));
      }
      localObject = Jvb;
      if (localObject != null) {
        ((Button)localObject).setText((CharSequence)MMApplicationContext.getContext().getString(a.j.ime_keyboard_active_setting_exchange));
      }
    }
    for (;;)
    {
      localObject = JuY;
      if (localObject != null) {
        ((RelativeLayout)localObject).setVisibility(paramInt);
      }
      AppMethodBeat.o(312257);
      return;
      label153:
      i = 0;
      break;
      label158:
      localObject = JuZ;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)MMApplicationContext.getContext().getString(a.j.ime_keyboard_active_title));
      }
      localObject = Jva;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)MMApplicationContext.getContext().getString(a.j.ime_keyboard_active_desc));
      }
      localObject = Jvb;
      if (localObject != null) {
        ((Button)localObject).setText((CharSequence)MMApplicationContext.getContext().getString(a.j.ime_keyboard_active_setting));
      }
    }
  }
  
  private static void Yx(int paramInt)
  {
    AppMethodBeat.i(312264);
    Object localObject1 = JuM;
    if (localObject1 != null)
    {
      localObject1 = (Keyboard)((HashMap)localObject1).get(Integer.valueOf(paramInt));
      if (localObject1 != null)
      {
        Object localObject2 = com.tencent.mm.plugin.hld.f.k.JyF;
        boolean bool = com.tencent.mm.plugin.hld.f.k.isLandscape();
        localObject2 = l.JyV;
        com.tencent.mm.plugin.hld.f.k localk = com.tencent.mm.plugin.hld.f.k.JyF;
        if (!y.ZC(((l)localObject2).bg(paramInt, com.tencent.mm.plugin.hld.f.k.isLandscape()))) {
          ((Keyboard)localObject1).post(new g..ExternalSyntheticLambda6((Keyboard)localObject1, paramInt, bool));
        }
      }
    }
    AppMethodBeat.o(312264);
  }
  
  private static final void a(int paramInt1, Context paramContext, int paramInt2)
  {
    AppMethodBeat.i(312314);
    s.u(paramContext, "$context");
    long l = System.currentTimeMillis();
    ah.f localf = new ah.f();
    Object localObject = com.tencent.mm.ui.k.b.afwA;
    localObject = b.a.aDY(paramInt1);
    if (localObject == null)
    {
      localObject = null;
      localf.aqH = localObject;
      if (localf.aqH != null) {
        break label161;
      }
      localf.aqH = af.mU(paramContext).inflate(paramInt1, null, false);
    }
    label161:
    for (boolean bool = false;; bool = true)
    {
      Log.i("WxIme.ImeKeyboardSwitch", "initKeyboardImp load " + paramInt2 + ' ' + (System.currentTimeMillis() - l) + ' ' + bool);
      com.tencent.threadpool.h.ahAA.bk(new g..ExternalSyntheticLambda7(localf, paramInt2, paramContext));
      AppMethodBeat.o(312314);
      return;
      localObject = ((com.tencent.mm.ui.k.b)localObject).jBE();
      break;
    }
  }
  
  private static void a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool1 = false;
    boolean bool4 = false;
    boolean bool3 = true;
    AppMethodBeat.i(312042);
    Log.i("WxIme.ImeKeyboardSwitch", "initKeyboardImp start " + paramInt1 + ' ' + paramInt2 + ' ' + paramBoolean);
    long l = System.currentTimeMillis();
    Object localObject = l.JyV;
    com.tencent.mm.plugin.hld.f.k localk = com.tencent.mm.plugin.hld.f.k.JyF;
    localObject = ((l)localObject).bg(paramInt1, com.tencent.mm.plugin.hld.f.k.isLandscape());
    boolean bool2;
    if (paramBoolean)
    {
      localk = com.tencent.mm.plugin.hld.f.k.JyF;
      if ((!com.tencent.mm.plugin.hld.f.k.isLandscape()) && (y.ZC((String)localObject)))
      {
        localObject = e.Jym;
        if (!e.fOa())
        {
          bool2 = true;
          if (!bool2) {
            break label277;
          }
          localObject = com.tencent.mm.ui.k.b.afwA;
          localObject = b.a.aDY(paramInt2);
          paramBoolean = bool4;
          if (localObject != null)
          {
            paramBoolean = bool4;
            if (((com.tencent.mm.ui.k.b)localObject).jBD() == true) {
              paramBoolean = true;
            }
          }
          bool1 = paramBoolean;
          if (paramBoolean) {
            break label277;
          }
          com.tencent.threadpool.h.ahAA.bm(new g..ExternalSyntheticLambda4(paramInt2, paramContext, paramInt1));
        }
      }
    }
    for (bool1 = bool3;; bool1 = bool3)
    {
      Log.i("WxIme.ImeKeyboardSwitch", "initKeyboardImp " + paramInt1 + ' ' + (System.currentTimeMillis() - l) + ' ' + aw.isDarkMode() + ' ' + bool1 + ' ' + bool2 + ' ' + paramBoolean);
      AppMethodBeat.o(312042);
      return;
      bool2 = false;
      break;
      label277:
      bool3 = k(paramContext, paramInt1, paramInt2);
      paramBoolean = bool1;
    }
  }
  
  private static void a(Context paramContext, int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(312012);
    if ((!paramBoolean) && (paramInt == fMo()))
    {
      AppMethodBeat.o(312012);
      return;
    }
    int i = Yt(paramInt);
    Log.d("WxIme.ImeKeyboardSwitch", "preInitKeyBoard " + paramInt + ' ' + i);
    new com.tencent.mm.ui.k.b(paramContext).eh(i, paramString);
    AppMethodBeat.o(312012);
  }
  
  public static void a(Context paramContext, com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(311928);
    s.u(paramContext, "context");
    s.u(paramc, "listener");
    long l = System.currentTimeMillis();
    mContext = paramContext;
    JnO = paramc;
    paramContext = com.tencent.mm.plugin.hld.f.i.JyA;
    paramContext = Integer.valueOf(com.tencent.mm.plugin.hld.f.i.fMo());
    Jvk = paramContext;
    w(paramContext);
    Log.i("WxIme.ImeKeyboardSwitch", s.X("init ", Long.valueOf(System.currentTimeMillis() - l)));
    AppMethodBeat.o(311928);
  }
  
  private static final void a(Keyboard paramKeyboard, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(312344);
    s.u(paramKeyboard, "$keyboard");
    if (paramKeyboard.getKeyboardType().ordinal() <= com.tencent.mm.plugin.hld.keyboard.c.Jrs.ordinal())
    {
      com.tencent.mm.plugin.hld.f.k localk = com.tencent.mm.plugin.hld.f.k.JyF;
      com.tencent.mm.plugin.hld.f.k.a((View)paramKeyboard, paramInt, paramBoolean, (k.a)new g.k(paramInt));
    }
    AppMethodBeat.o(312344);
  }
  
  private static final void a(ah.f paramf, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(312303);
    s.u(paramf, "$keyboardView");
    s.u(paramContext, "$context");
    long l = System.currentTimeMillis();
    paramf = (View)paramf.aqH;
    Object localObject;
    if (paramf == null)
    {
      paramf = null;
      localObject = JuM;
      if (localObject != null)
      {
        localObject = (Map)localObject;
        if (paramf != null) {
          break label210;
        }
      }
    }
    label210:
    for (paramContext = (Keyboard)new S2ChineseQwertyKeyboard(paramContext);; paramContext = paramf)
    {
      ((Map)localObject).put(Integer.valueOf(paramInt), paramContext);
      if (paramf != null) {
        paramf.onCreate();
      }
      Log.i("WxIme.ImeKeyboardSwitch", "initKeyboardImp push to cache " + paramInt + ' ' + (System.currentTimeMillis() - l) + ' ' + fMo());
      if ((paramf != null) && (fMo() == paramInt))
      {
        paramf.b(JnO);
        paramContext = JuU;
        if (paramContext != null) {
          paramContext.addView((View)paramf);
        }
        Log.i("WxIme.ImeKeyboardSwitch", s.X("initKeyboardImp refresh ", Integer.valueOf(paramInt)));
      }
      AppMethodBeat.o(312303);
      return;
      paramf = (Keyboard)paramf.findViewById(a.f.root);
      break;
    }
  }
  
  private static final void a(ah.f paramf, ah.d paramd)
  {
    AppMethodBeat.i(312320);
    s.u(paramf, "$actionStr");
    s.u(paramd, "$actionMode");
    Keyboard localKeyboard = fMr();
    if (localKeyboard != null) {
      localKeyboard.fG((String)paramf.aqH, paramd.aixb);
    }
    AppMethodBeat.o(312320);
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, kotlin.g.a.a<ah> parama1, kotlin.g.a.a<ah> parama2)
  {
    AppMethodBeat.i(312083);
    if (paramBoolean1)
    {
      b(parama1, parama2);
      AppMethodBeat.o(312083);
      return;
    }
    Object localObject;
    if (paramBoolean2)
    {
      c(parama1, parama2);
      if (fMo() < com.tencent.mm.plugin.hld.keyboard.c.Jrw.ordinal())
      {
        if (!paramBoolean4) {
          break label177;
        }
        fMg();
        if (!paramBoolean2) {
          break label149;
        }
        localObject = JuU;
        if (localObject != null) {
          ((FrameLayout)localObject).setVisibility(8);
        }
        if (parama1 != null) {
          parama1.invoke();
        }
        if (parama2 != null) {
          parama2.invoke();
        }
      }
    }
    for (;;)
    {
      fMk();
      AppMethodBeat.o(312083);
      return;
      localObject = JuW;
      if (localObject != null) {
        ((FrameLayout)localObject).setVisibility(8);
      }
      localObject = JuX;
      if (localObject == null) {
        break;
      }
      ((FrameLayout)localObject).setVisibility(8);
      break;
      label149:
      localObject = Jvg;
      if (localObject != null) {
        ((ObjectAnimator)localObject).cancel();
      }
      e(parama1, parama2).start();
      continue;
      label177:
      if (paramBoolean6)
      {
        localObject = JuV;
        if (localObject != null) {
          ((FrameLayout)localObject).setVisibility(0);
        }
        fMh();
        if (parama1 != null) {
          parama1.invoke();
        }
        if (parama2 != null) {
          parama2.invoke();
        }
      }
      else
      {
        localObject = JuV;
        if (localObject != null) {
          ((FrameLayout)localObject).setVisibility(8);
        }
        if (paramBoolean5)
        {
          fMf();
          if (paramBoolean2)
          {
            if (paramBoolean3)
            {
              localObject = JuU;
              if (localObject != null) {
                ((FrameLayout)localObject).setVisibility(0);
              }
              localObject = JuU;
              if (localObject != null) {
                ((FrameLayout)localObject).setTranslationY(0.0F);
              }
            }
            if (parama1 != null) {
              parama1.invoke();
            }
            if (parama2 != null) {
              parama2.invoke();
            }
          }
          else if (paramBoolean3)
          {
            localObject = Jvf;
            if (localObject != null) {
              ((ObjectAnimator)localObject).cancel();
            }
            d(parama1, parama2).start();
          }
          else
          {
            if (parama1 != null) {
              parama1.invoke();
            }
            if (parama2 != null) {
              parama2.invoke();
            }
          }
        }
        else
        {
          fMg();
          if (parama1 != null) {
            parama1.invoke();
          }
          if (parama2 != null) {
            parama2.invoke();
          }
        }
      }
    }
  }
  
  private final void aI(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(311992);
    if (paramInt == fMo()) {
      f(paramContext, paramInt, true);
    }
    AppMethodBeat.o(311992);
  }
  
  private static void aJ(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(311999);
    HashMap localHashMap = JuM;
    if ((localHashMap != null) && (localHashMap.get(Integer.valueOf(paramInt)) == null)) {
      f(paramContext, paramInt, false);
    }
    AppMethodBeat.o(311999);
  }
  
  public static void ax(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(312151);
    int i;
    if (paramBoolean1) {
      i = 2;
    }
    for (;;)
    {
      JuO = i;
      fMk();
      AppMethodBeat.o(312151);
      return;
      if (paramBoolean2)
      {
        i = 4;
      }
      else
      {
        l locall = l.JyV;
        if (l.fOH()) {
          i = 1;
        } else {
          i = 3;
        }
      }
    }
  }
  
  private static void b(kotlin.g.a.a<ah> parama1, final kotlin.g.a.a<ah> parama2)
  {
    AppMethodBeat.i(312117);
    Object localObject = fMr();
    if (localObject != null) {
      if ((!(localObject instanceof S8ExceptionSettingKeyboard)) && (!(localObject instanceof S10SettingKeyboard))) {
        break label156;
      }
    }
    label156:
    for (final FrameLayout localFrameLayout = JuW;; localFrameLayout = JuX)
    {
      if (localFrameLayout != null) {
        localFrameLayout.removeAllViews();
      }
      if (localFrameLayout != null) {
        localFrameLayout.addView((View)localObject);
      }
      localObject = com.tencent.mm.plugin.hld.f.k.JyF;
      localObject = MMApplicationContext.getContext();
      s.s(localObject, "getContext()");
      int i = com.tencent.mm.plugin.hld.f.k.getScreenWidth((Context)localObject);
      localObject = ObjectAnimator.ofFloat(localFrameLayout, View.TRANSLATION_X, new float[] { i, 0.0F });
      ((ObjectAnimator)localObject).setDuration(300L);
      ((ObjectAnimator)localObject).setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
      ((ObjectAnimator)localObject).addListener((Animator.AnimatorListener)new c(parama1, localFrameLayout, parama2));
      ((ObjectAnimator)localObject).start();
      AppMethodBeat.o(312117);
      return;
    }
  }
  
  public static boolean b(com.tencent.mm.plugin.hld.keyboard.c paramc)
  {
    AppMethodBeat.i(312130);
    s.u(paramc, "keyboard");
    if (paramc.ordinal() == fMo())
    {
      AppMethodBeat.o(312130);
      return true;
    }
    AppMethodBeat.o(312130);
    return false;
  }
  
  private static void c(kotlin.g.a.a<ah> parama1, final kotlin.g.a.a<ah> parama2)
  {
    AppMethodBeat.i(312123);
    Object localObject1 = fMr();
    if (localObject1 != null) {
      if (!(localObject1 instanceof S8ExceptionSettingKeyboard)) {
        break label124;
      }
    }
    label124:
    for (localObject1 = JuX;; localObject1 = JuW)
    {
      Object localObject2 = com.tencent.mm.plugin.hld.f.k.JyF;
      localObject2 = MMApplicationContext.getContext();
      s.s(localObject2, "getContext()");
      int i = com.tencent.mm.plugin.hld.f.k.getScreenWidth((Context)localObject2);
      localObject2 = ObjectAnimator.ofFloat(localObject1, View.TRANSLATION_X, new float[] { 0.0F, i });
      ((ObjectAnimator)localObject2).setDuration(300L);
      ((ObjectAnimator)localObject2).setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
      ((ObjectAnimator)localObject2).addListener((Animator.AnimatorListener)new f(parama1, (FrameLayout)localObject1, parama2));
      ((ObjectAnimator)localObject2).start();
      AppMethodBeat.o(312123);
      return;
    }
  }
  
  private static ObjectAnimator d(kotlin.g.a.a<ah> parama1, final kotlin.g.a.a<ah> parama2)
  {
    AppMethodBeat.i(312210);
    if (Jvg == null)
    {
      localObject = JuU;
      Property localProperty = View.TRANSLATION_Y;
      com.tencent.mm.plugin.hld.f.k localk = com.tencent.mm.plugin.hld.f.k.JyF;
      localObject = ObjectAnimator.ofFloat(localObject, localProperty, new float[] { com.tencent.mm.plugin.hld.f.k.ir(mContext), 0.0F });
      Jvg = (ObjectAnimator)localObject;
      if (localObject != null) {
        ((ObjectAnimator)localObject).setDuration(300L);
      }
      localObject = Jvg;
      if (localObject != null) {
        ((ObjectAnimator)localObject).setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
      }
      localObject = Jvg;
      if (localObject != null) {
        ((ObjectAnimator)localObject).addUpdateListener(g..ExternalSyntheticLambda0.INSTANCE);
      }
    }
    Object localObject = Jvg;
    if (localObject != null) {
      ((ObjectAnimator)localObject).removeAllListeners();
    }
    localObject = Jvg;
    if (localObject != null) {
      ((ObjectAnimator)localObject).addListener((Animator.AnimatorListener)new b(parama1, parama2));
    }
    parama1 = Jvg;
    if (parama1 == null)
    {
      parama1 = new NullPointerException("null cannot be cast to non-null type android.animation.ObjectAnimator");
      AppMethodBeat.o(312210);
      throw parama1;
    }
    AppMethodBeat.o(312210);
    return parama1;
  }
  
  private static ObjectAnimator e(kotlin.g.a.a<ah> parama1, final kotlin.g.a.a<ah> parama2)
  {
    AppMethodBeat.i(312219);
    if (Jvf == null)
    {
      localObject = JuU;
      Property localProperty = View.TRANSLATION_Y;
      com.tencent.mm.plugin.hld.f.k localk = com.tencent.mm.plugin.hld.f.k.JyF;
      localObject = ObjectAnimator.ofFloat(localObject, localProperty, new float[] { 0.0F, com.tencent.mm.plugin.hld.f.k.ir(mContext) });
      Jvf = (ObjectAnimator)localObject;
      if (localObject != null) {
        ((ObjectAnimator)localObject).setDuration(300L);
      }
      localObject = Jvf;
      if (localObject != null) {
        ((ObjectAnimator)localObject).setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
      }
      localObject = Jvf;
      if (localObject != null) {
        ((ObjectAnimator)localObject).addUpdateListener(g..ExternalSyntheticLambda1.INSTANCE);
      }
    }
    Object localObject = Jvf;
    if (localObject != null) {
      ((ObjectAnimator)localObject).removeAllListeners();
    }
    localObject = Jvf;
    if (localObject != null) {
      ((ObjectAnimator)localObject).addListener((Animator.AnimatorListener)new a(parama1, parama2));
    }
    parama1 = Jvf;
    if (parama1 == null)
    {
      parama1 = new NullPointerException("null cannot be cast to non-null type android.animation.ObjectAnimator");
      AppMethodBeat.o(312219);
      throw parama1;
    }
    AppMethodBeat.o(312219);
    return parama1;
  }
  
  private static final void f(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(312328);
    if (paramValueAnimator == null)
    {
      paramValueAnimator = null;
      if (!(paramValueAnimator instanceof Float)) {
        break label71;
      }
      paramValueAnimator = (Float)paramValueAnimator;
      label24:
      if (paramValueAnimator != null) {
        break label76;
      }
    }
    label71:
    label76:
    for (float f = 0.0F;; f = paramValueAnimator.floatValue())
    {
      paramValueAnimator = JuT;
      if (paramValueAnimator != null)
      {
        com.tencent.mm.plugin.hld.f.k localk = com.tencent.mm.plugin.hld.f.k.JyF;
        paramValueAnimator.setAlpha(1.0F - f / com.tencent.mm.plugin.hld.f.k.ir(mContext));
      }
      AppMethodBeat.o(312328);
      return;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      break;
      paramValueAnimator = null;
      break label24;
    }
  }
  
  private static void f(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(312006);
    int j = 1;
    HashMap localHashMap = JuM;
    int i = j;
    if (localHashMap != null)
    {
      i = j;
      if (localHashMap.get(Integer.valueOf(paramInt)) != null) {
        i = 0;
      }
    }
    if (i != 0) {
      a(paramContext, paramInt, Yt(paramInt), paramBoolean);
    }
    AppMethodBeat.o(312006);
  }
  
  public static boolean fLX()
  {
    return Jvl;
  }
  
  private static int fLZ()
  {
    boolean bool = true;
    AppMethodBeat.i(311948);
    fMo();
    Object localObject = JuW;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = JuX;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = com.tencent.mm.plugin.hld.f.i.JyA;
    int k = com.tencent.mm.plugin.hld.f.i.fMo();
    localObject = com.tencent.mm.plugin.hld.f.k.JyF;
    localObject = com.tencent.mm.plugin.hld.f.k.fOx();
    label75:
    int i;
    label77:
    label83:
    label89:
    label95:
    label101:
    label107:
    label113:
    label119:
    int j;
    if (localObject == null)
    {
      if (localObject != null) {
        break label213;
      }
      i = 0;
      if (i == 0) {
        break label228;
      }
      i = 1;
      if (i == 0) {
        break label253;
      }
      i = 1;
      if (i == 0) {
        break label277;
      }
      i = 1;
      if (i == 0) {
        break label303;
      }
      i = 1;
      if (i == 0) {
        break label328;
      }
      i = 1;
      if (i == 0) {
        break label354;
      }
      i = 1;
      if (i == 0) {
        break label378;
      }
      i = 1;
      if (i == 0) {
        break label404;
      }
      i = com.tencent.mm.plugin.hld.keyboard.c.Jrs.ordinal();
      localObject = com.tencent.mm.plugin.hld.f.k.JyF;
      localObject = com.tencent.mm.plugin.hld.f.k.fOx();
      if (localObject != null) {
        break label623;
      }
      label145:
      if (localObject != null) {
        break label638;
      }
      label150:
      j = 0;
      label152:
      if (j == 0) {
        break label654;
      }
      j = 1;
      label158:
      if (j == 0) {
        break label680;
      }
      j = 1;
      label164:
      if (j == 0) {
        break label706;
      }
    }
    for (;;)
    {
      Jvj = bool;
      if (bool)
      {
        localObject = JuQ;
        if (localObject != null) {
          ImeCandidateView.a((ImeCandidateView)localObject);
        }
      }
      AppMethodBeat.o(311948);
      return i;
      if (((Integer)localObject).intValue() != 4) {
        break;
      }
      i = 1;
      break label77;
      label213:
      if (((Integer)localObject).intValue() != 20) {
        break label75;
      }
      i = 1;
      break label77;
      label228:
      if (localObject == null) {}
      while (((Integer)localObject).intValue() != 36)
      {
        i = 0;
        break;
      }
      i = 1;
      break label83;
      label253:
      if (localObject == null) {}
      while (((Integer)localObject).intValue() != 2)
      {
        i = 0;
        break;
      }
      i = 1;
      break label89;
      label277:
      if (localObject == null) {}
      while (((Integer)localObject).intValue() != 8194)
      {
        i = 0;
        break;
      }
      i = 1;
      break label95;
      label303:
      if (localObject == null) {}
      while (((Integer)localObject).intValue() != 18)
      {
        i = 0;
        break;
      }
      i = 1;
      break label101;
      label328:
      if (localObject == null) {}
      while (((Integer)localObject).intValue() != 4098)
      {
        i = 0;
        break;
      }
      i = 1;
      break label107;
      label354:
      if (localObject == null) {}
      while (((Integer)localObject).intValue() != 3)
      {
        i = 0;
        break;
      }
      i = 1;
      break label113;
      label378:
      if (localObject == null) {}
      while (((Integer)localObject).intValue() != 161)
      {
        i = 0;
        break;
      }
      i = 1;
      break label119;
      label404:
      if (localObject == null)
      {
        label409:
        if (localObject != null) {
          break label478;
        }
        label414:
        i = 0;
        label416:
        if (i == 0) {
          break label494;
        }
        i = 1;
        label422:
        if (i == 0) {
          break label519;
        }
        i = 1;
        label428:
        if (i == 0) {
          break label545;
        }
        i = 1;
        label434:
        if (i == 0) {
          break label571;
        }
        i = 1;
        label440:
        if (i == 0) {
          break label597;
        }
        j = 1;
      }
      for (;;)
      {
        i = k;
        if (j == 0) {
          break;
        }
        i = com.tencent.mm.plugin.hld.keyboard.c.Jrr.ordinal();
        break;
        if (((Integer)localObject).intValue() != 16384) {
          break label409;
        }
        i = 1;
        break label416;
        label478:
        if (((Integer)localObject).intValue() != 8192) {
          break label414;
        }
        i = 1;
        break label416;
        label494:
        if (localObject == null) {}
        while (((Integer)localObject).intValue() != 33)
        {
          i = 0;
          break;
        }
        i = 1;
        break label422;
        label519:
        if (localObject == null) {}
        while (((Integer)localObject).intValue() != 129)
        {
          i = 0;
          break;
        }
        i = 1;
        break label428;
        label545:
        if (localObject == null) {}
        while (((Integer)localObject).intValue() != 145)
        {
          i = 0;
          break;
        }
        i = 1;
        break label434;
        label571:
        if (localObject == null) {}
        while (((Integer)localObject).intValue() != 209)
        {
          i = 0;
          break;
        }
        i = 1;
        break label440;
        label597:
        if (localObject == null) {}
        while (((Integer)localObject).intValue() != 225)
        {
          j = 0;
          break;
        }
        j = 1;
      }
      label623:
      if (((Integer)localObject).intValue() != 18) {
        break label145;
      }
      j = 1;
      break label152;
      label638:
      if (((Integer)localObject).intValue() != 129) {
        break label150;
      }
      j = 1;
      break label152;
      label654:
      if (localObject == null) {}
      while (((Integer)localObject).intValue() != 145)
      {
        j = 0;
        break;
      }
      j = 1;
      break label158;
      label680:
      if (localObject == null) {}
      while (((Integer)localObject).intValue() != 225)
      {
        j = 0;
        break;
      }
      j = 1;
      break label164;
      label706:
      bool = false;
    }
  }
  
  private final void fMb()
  {
    boolean bool = false;
    Object localObject2 = null;
    AppMethodBeat.i(311976);
    long l1 = System.currentTimeMillis();
    Object localObject1 = com.tencent.mm.ui.k.b.afwA;
    localObject1 = b.a.aDY(a.h.ime_input_view);
    if (localObject1 == null)
    {
      localObject1 = null;
      JuP = (View)localObject1;
      if (JuP != null) {
        break label662;
      }
      JuP = af.mU(mContext).inflate(a.h.ime_input_view, null, false);
    }
    for (;;)
    {
      localObject1 = JuP;
      label77:
      long l2;
      if (localObject1 == null)
      {
        localObject1 = null;
        JuQ = (ImeCandidateView)localObject1;
        if (localObject1 != null) {
          ((ImeCandidateView)localObject1).a(JnO);
        }
        l2 = System.currentTimeMillis();
        localObject1 = JuP;
        if (localObject1 != null) {
          break label457;
        }
        localObject1 = null;
        label113:
        JuR = (RelativeLayout)localObject1;
        localObject1 = JuP;
        if (localObject1 != null) {
          break label473;
        }
        localObject1 = null;
        label131:
        JuS = (FrameLayout)localObject1;
        localObject1 = JuP;
        if (localObject1 != null) {
          break label489;
        }
        localObject1 = null;
        label149:
        JuT = (View)localObject1;
        localObject1 = JuP;
        if (localObject1 != null) {
          break label502;
        }
        localObject1 = null;
        label167:
        JuU = (FrameLayout)localObject1;
        localObject1 = JuP;
        if (localObject1 != null) {
          break label518;
        }
        localObject1 = null;
        label185:
        JuV = (FrameLayout)localObject1;
        localObject1 = JuP;
        if (localObject1 != null) {
          break label534;
        }
        localObject1 = null;
        label203:
        JuW = (FrameLayout)localObject1;
        localObject1 = JuP;
        if (localObject1 != null) {
          break label550;
        }
        localObject1 = null;
        label221:
        JuX = (FrameLayout)localObject1;
        localObject1 = JuU;
        if (localObject1 != null) {
          ((FrameLayout)localObject1).setOnTouchListener(g..ExternalSyntheticLambda3.INSTANCE);
        }
        localObject1 = JuP;
        if (localObject1 != null) {
          break label566;
        }
        localObject1 = null;
        label257:
        JuY = (RelativeLayout)localObject1;
        if (localObject1 != null) {
          break label582;
        }
        localObject1 = null;
        label270:
        JuZ = (TextView)localObject1;
        localObject1 = JuY;
        if (localObject1 != null) {
          break label598;
        }
        localObject1 = null;
        label288:
        Jva = (TextView)localObject1;
        localObject1 = JuY;
        if (localObject1 != null) {
          break label614;
        }
        localObject1 = null;
        label306:
        Jvb = (Button)localObject1;
        localObject1 = JuP;
        if (localObject1 != null) {
          break label630;
        }
        localObject1 = null;
        label324:
        Jvc = (ViewStub)localObject1;
        localObject1 = JuP;
        if (localObject1 != null) {
          break label646;
        }
      }
      label646:
      for (localObject1 = localObject2;; localObject1 = (Button)((View)localObject1).findViewById(a.f.setting_bt))
      {
        Jve = (Button)localObject1;
        if (localObject1 != null) {
          ((Button)localObject1).setOnClickListener(g..ExternalSyntheticLambda2.INSTANCE);
        }
        long l3 = System.currentTimeMillis();
        fMf();
        Log.i("WxIme.ImeKeyboardSwitch", "initInputView async:" + bool + " startTime:" + l1 + " secondStage:" + l2 + " thirdStage:" + l3);
        AppMethodBeat.o(311976);
        return;
        localObject1 = ((com.tencent.mm.ui.k.b)localObject1).jBE();
        break;
        localObject1 = (ImeCandidateView)((View)localObject1).findViewById(a.f.candidate_container);
        break label77;
        label457:
        localObject1 = (RelativeLayout)((View)localObject1).findViewById(a.f.input_center_container);
        break label113;
        label473:
        localObject1 = (FrameLayout)((View)localObject1).findViewById(a.f.input_below_view);
        break label131;
        label489:
        localObject1 = ((View)localObject1).findViewById(a.f.input_center_view);
        break label149;
        label502:
        localObject1 = (FrameLayout)((View)localObject1).findViewById(a.f.input_up_view);
        break label167;
        label518:
        localObject1 = (FrameLayout)((View)localObject1).findViewById(a.f.input_view);
        break label185;
        label534:
        localObject1 = (FrameLayout)((View)localObject1).findViewById(a.f.input_left_view);
        break label203;
        label550:
        localObject1 = (FrameLayout)((View)localObject1).findViewById(a.f.input_left_view2);
        break label221;
        label566:
        localObject1 = (RelativeLayout)((View)localObject1).findViewById(a.f.active_ll);
        break label257;
        label582:
        localObject1 = (TextView)((RelativeLayout)localObject1).findViewById(a.f.title_tv);
        break label270;
        label598:
        localObject1 = (TextView)((RelativeLayout)localObject1).findViewById(a.f.desc_tv);
        break label288;
        label614:
        localObject1 = (Button)((RelativeLayout)localObject1).findViewById(a.f.setting_bt);
        break label306;
        label630:
        localObject1 = (ViewStub)((View)localObject1).findViewById(a.f.update_dict_viewstub);
        break label324;
      }
      label662:
      bool = true;
    }
  }
  
  public static View fMc()
  {
    AppMethodBeat.i(311986);
    View localView = JuP;
    if (localView == null)
    {
      localView = new View(MMApplicationContext.getContext());
      AppMethodBeat.o(311986);
      return localView;
    }
    AppMethodBeat.o(311986);
    return localView;
  }
  
  public static void fMd()
  {
    AppMethodBeat.i(312055);
    Object localObject = fMr();
    if (localObject != null) {
      ((Keyboard)localObject).b(JnO);
    }
    localObject = JuQ;
    if (localObject != null) {
      ((ImeCandidateView)localObject).getStrikeTv().setTextSize(0, com.tencent.mm.cd.a.bs(((ImeCandidateView)localObject).getContext(), a.d.keyboard_strike_text_size));
    }
    AppMethodBeat.o(312055);
  }
  
  private static void fMe()
  {
    AppMethodBeat.i(312067);
    Object localObject = fMr();
    if (localObject != null)
    {
      FrameLayout localFrameLayout = JuW;
      if (localFrameLayout != null) {
        localFrameLayout.removeAllViews();
      }
      ((Keyboard)localObject).b(JnO);
      localFrameLayout = JuW;
      if (localFrameLayout != null) {
        localFrameLayout.addView((View)localObject);
      }
      localObject = JuW;
      if (localObject != null) {
        ((FrameLayout)localObject).setVisibility(0);
      }
    }
    AppMethodBeat.o(312067);
  }
  
  private static void fMf()
  {
    AppMethodBeat.i(312093);
    Object localObject1 = JuU;
    if (localObject1 != null) {
      ((FrameLayout)localObject1).removeAllViews();
    }
    localObject1 = fMr();
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 == null)
      {
        localObject1 = l.JyV;
        int i = fMo();
        localObject2 = com.tencent.mm.plugin.hld.f.k.JyF;
        localObject1 = ((l)localObject1).bg(i, com.tencent.mm.plugin.hld.f.k.isLandscape());
        localObject2 = com.tencent.mm.plugin.hld.f.k.JyF;
        if ((com.tencent.mm.plugin.hld.f.k.isLandscape()) || (!y.ZC((String)localObject1))) {
          break label202;
        }
      }
    }
    label202:
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        Bitmap localBitmap = BitmapUtil.decodeFileWithSample((String)localObject1);
        localObject2 = mContext;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = MMApplicationContext.getContext();
        }
        localObject1 = new ImageView((Context)localObject1);
        ((ImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((ImageView)localObject1).setImageBitmap(localBitmap);
        ((ImageView)localObject1).setAlpha(1.0F);
        localObject2 = JuU;
        if (localObject2 != null) {
          ((FrameLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        }
      }
      Log.i("WxIme.ImeKeyboardSwitch", s.X("updateInputUpKeyboard ", Boolean.valueOf(bool)));
      AppMethodBeat.o(312093);
      return;
      localObject2 = JuU;
      if (localObject2 == null)
      {
        localObject1 = null;
        break;
      }
      ((FrameLayout)localObject2).addView((View)localObject1);
      localObject1 = ah.aiuX;
      break;
    }
  }
  
  private static void fMg()
  {
    AppMethodBeat.i(312102);
    Object localObject = JuS;
    if (localObject != null) {
      ((FrameLayout)localObject).removeAllViews();
    }
    localObject = fMr();
    if (localObject != null)
    {
      FrameLayout localFrameLayout = JuS;
      if (localFrameLayout != null) {
        localFrameLayout.addView((View)localObject);
      }
    }
    AppMethodBeat.o(312102);
  }
  
  private static void fMh()
  {
    AppMethodBeat.i(312109);
    Object localObject = JuV;
    if (localObject != null) {
      ((FrameLayout)localObject).removeAllViews();
    }
    localObject = fMr();
    if (localObject != null)
    {
      FrameLayout localFrameLayout = JuV;
      if (localFrameLayout != null) {
        localFrameLayout.addView((View)localObject);
      }
    }
    AppMethodBeat.o(312109);
  }
  
  public static int fMi()
  {
    AppMethodBeat.i(312136);
    Object localObject = Jvk;
    if (localObject == null)
    {
      localObject = com.tencent.mm.plugin.hld.f.i.JyA;
      i = com.tencent.mm.plugin.hld.f.i.fMo();
      AppMethodBeat.o(312136);
      return i;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(312136);
    return i;
  }
  
  public static boolean fMj()
  {
    AppMethodBeat.i(312144);
    if (fMi() == com.tencent.mm.plugin.hld.keyboard.c.Jrr.ordinal())
    {
      AppMethodBeat.o(312144);
      return true;
    }
    AppMethodBeat.o(312144);
    return false;
  }
  
  public static void fMk()
  {
    AppMethodBeat.i(312167);
    Jvh = false;
    ah.f localf = new ah.f();
    Object localObject = mContext;
    ah.d locald;
    if (localObject == null)
    {
      localObject = "";
      localf.aqH = localObject;
      locald = new ah.d();
      locald.aixb = 2;
      if (((fMo() > com.tencent.mm.plugin.hld.keyboard.c.Jrq.ordinal()) && (fMo() != com.tencent.mm.plugin.hld.keyboard.c.Jrs.ordinal())) || (JuO != 2)) {
        break label198;
      }
      localObject = mContext;
      if (localObject != null) {
        break label161;
      }
      localObject = "";
      label93:
      localf.aqH = localObject;
    }
    String str;
    label161:
    label198:
    int i;
    for (;;)
    {
      com.tencent.threadpool.h.ahAA.bk(new g..ExternalSyntheticLambda8(localf, locald));
      AppMethodBeat.o(312167);
      return;
      localObject = ((Context)localObject).getResources();
      if (localObject == null)
      {
        localObject = "";
        break;
      }
      str = ((Resources)localObject).getString(a.j.newline);
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
      localObject = ((Context)localObject).getResources();
      if (localObject == null)
      {
        localObject = "";
        break label93;
      }
      str = ((Resources)localObject).getString(a.j.confirm);
      localObject = str;
      if (str != null) {
        break label93;
      }
      localObject = "";
      break label93;
      localObject = (d)com.tencent.mm.kernel.h.ax(d.class);
      if (localObject != null) {
        break label285;
      }
      i = 1;
      label214:
      switch (i & 0xFF)
      {
      }
    }
    locald.aixb = 3;
    localObject = mContext;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      localf.aqH = localObject;
      break;
      label285:
      localObject = ((d)localObject).fKG();
      if (localObject == null)
      {
        i = 1;
        break label214;
      }
      i = ((com.tencent.mm.plugin.hld.a.b)localObject).fKt();
      break label214;
      localObject = ((Context)localObject).getResources();
      if (localObject == null)
      {
        localObject = "";
      }
      else
      {
        str = ((Resources)localObject).getString(a.j.key_action_go);
        localObject = str;
        if (str == null) {
          localObject = "";
        }
      }
    }
    locald.aixb = 3;
    localObject = mContext;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      localf.aqH = localObject;
      break;
      localObject = ((Context)localObject).getResources();
      if (localObject == null)
      {
        localObject = "";
      }
      else
      {
        str = ((Resources)localObject).getString(a.j.key_action_search);
        localObject = str;
        if (str == null) {
          localObject = "";
        }
      }
    }
    localObject = l.JyV;
    if (l.fOH())
    {
      locald.aixb = 1;
      label427:
      localObject = mContext;
      if (localObject != null) {
        break label460;
      }
      localObject = "";
    }
    for (;;)
    {
      localf.aqH = localObject;
      Jvh = true;
      break;
      locald.aixb = 3;
      break label427;
      label460:
      localObject = ((Context)localObject).getResources();
      if (localObject == null)
      {
        localObject = "";
      }
      else
      {
        str = ((Resources)localObject).getString(a.j.key_action_send);
        localObject = str;
        if (str == null) {
          localObject = "";
        }
      }
    }
    locald.aixb = 3;
    localObject = mContext;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      localf.aqH = localObject;
      break;
      localObject = ((Context)localObject).getResources();
      if (localObject == null)
      {
        localObject = "";
      }
      else
      {
        str = ((Resources)localObject).getString(a.j.key_action_next);
        localObject = str;
        if (str == null) {
          localObject = "";
        }
      }
    }
    locald.aixb = 3;
    localObject = mContext;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      localf.aqH = localObject;
      break;
      localObject = ((Context)localObject).getResources();
      if (localObject == null)
      {
        localObject = "";
      }
      else
      {
        str = ((Resources)localObject).getString(a.j.key_action_previous);
        localObject = str;
        if (str == null) {
          localObject = "";
        }
      }
    }
  }
  
  public static int fMl()
  {
    return JuO;
  }
  
  public static boolean fMm()
  {
    AppMethodBeat.i(312180);
    Keyboard localKeyboard = fMr();
    if (localKeyboard == null)
    {
      AppMethodBeat.o(312180);
      return false;
    }
    boolean bool = localKeyboard.fLL();
    AppMethodBeat.o(312180);
    return bool;
  }
  
  public static ImeCandidateView fMn()
  {
    return JuQ;
  }
  
  public static int fMo()
  {
    AppMethodBeat.i(312199);
    try
    {
      Object localObject = JuN.getLast();
      s.s(localObject, "{\n            mKeyboardTask.last\n        }");
      i = ((Number)localObject).intValue();
      AppMethodBeat.o(312199);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.hld.f.i locali = com.tencent.mm.plugin.hld.f.i.JyA;
        int i = com.tencent.mm.plugin.hld.f.i.fMo();
      }
    }
  }
  
  public static boolean fMp()
  {
    return Jvj;
  }
  
  public static int fMq()
  {
    AppMethodBeat.i(312236);
    try
    {
      i = Math.max(JuN.size() - 2, 0);
      Object localObject = JuN.get(i);
      s.s(localObject, "{\n            val index …oardTask[index]\n        }");
      i = ((Number)localObject).intValue();
      AppMethodBeat.o(312236);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.hld.f.i locali = com.tencent.mm.plugin.hld.f.i.JyA;
        int i = com.tencent.mm.plugin.hld.f.i.fMo();
      }
    }
  }
  
  public static Keyboard fMr()
  {
    AppMethodBeat.i(312242);
    Object localObject = JuM;
    if (localObject == null)
    {
      AppMethodBeat.o(312242);
      return null;
    }
    localObject = (Keyboard)((HashMap)localObject).get(Integer.valueOf(fMo()));
    AppMethodBeat.o(312242);
    return localObject;
  }
  
  private static final void g(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(312335);
    if (paramValueAnimator == null)
    {
      paramValueAnimator = null;
      if (!(paramValueAnimator instanceof Float)) {
        break label71;
      }
      paramValueAnimator = (Float)paramValueAnimator;
      label24:
      if (paramValueAnimator != null) {
        break label76;
      }
    }
    label71:
    label76:
    for (float f = 0.0F;; f = paramValueAnimator.floatValue())
    {
      paramValueAnimator = JuT;
      if (paramValueAnimator != null)
      {
        com.tencent.mm.plugin.hld.f.k localk = com.tencent.mm.plugin.hld.f.k.JyF;
        paramValueAnimator.setAlpha(1.0F - f / com.tencent.mm.plugin.hld.f.k.ir(mContext));
      }
      AppMethodBeat.o(312335);
      return;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      break;
      paramValueAnimator = null;
      break label24;
    }
  }
  
  private static final void hQ(View paramView)
  {
    AppMethodBeat.i(312289);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/model/ImeKeyboardSwitch", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    paramView = com.tencent.mm.plugin.hld.f.i.JyA;
    int i;
    if (!com.tencent.mm.plugin.hld.f.i.bGa())
    {
      paramView = (d)com.tencent.mm.kernel.h.ax(d.class);
      if (paramView != null)
      {
        paramView = paramView.fKG();
        if ((paramView != null) && (paramView.fKx() == true))
        {
          i = 1;
          if (i == 0) {
            break label167;
          }
          paramView = MMApplicationContext.getContext().getSystemService("input_method");
          if (!(paramView instanceof InputMethodManager)) {
            break label162;
          }
          paramView = (InputMethodManager)paramView;
          label120:
          if (paramView != null) {
            paramView.showInputMethodPicker();
          }
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/hld/model/ImeKeyboardSwitch", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(312289);
      return;
      i = 0;
      break;
      label162:
      paramView = null;
      break label120;
      label167:
      localObject = new Intent();
      ((Intent)localObject).setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.HldContactUI");
      ((Intent)localObject).addFlags(268435456);
      paramView = MMApplicationContext.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/hld/model/ImeKeyboardSwitch", "handleActiveMaskBtClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/hld/model/ImeKeyboardSwitch", "handleActiveMaskBtClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView = k.JvH;
      k.jp(14, 7);
    }
  }
  
  private static final boolean i(View paramView, MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public static void ij(Context paramContext)
  {
    AppMethodBeat.i(311958);
    s.u(paramContext, "context");
    if (Jvl)
    {
      AppMethodBeat.o(311958);
      return;
    }
    Jvl = true;
    com.tencent.threadpool.h.ahAA.bk(new g..ExternalSyntheticLambda5(paramContext));
    AppMethodBeat.o(311958);
  }
  
  private static final void ik(Context paramContext)
  {
    AppMethodBeat.i(312271);
    s.u(paramContext, "$context");
    aJ(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jrp.ordinal());
    aJ(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jrq.ordinal());
    aJ(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jrr.ordinal());
    aJ(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jrs.ordinal());
    aJ(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jrt.ordinal());
    aJ(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jru.ordinal());
    aJ(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jrw.ordinal());
    aJ(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jrx.ordinal());
    aJ(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jry.ordinal());
    AppMethodBeat.o(312271);
  }
  
  private static boolean k(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(312050);
    boolean bool = true;
    Object localObject1 = com.tencent.mm.ui.k.b.afwA;
    localObject1 = b.a.aDY(paramInt2);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = af.mU(paramContext).inflate(paramInt2, null, false);
        bool = false;
      }
      if (localObject2 != null) {
        break label133;
      }
      localObject1 = null;
      label58:
      localObject2 = JuM;
      if (localObject2 != null)
      {
        localObject2 = (Map)localObject2;
        if (localObject1 != null) {
          break label149;
        }
      }
    }
    label133:
    label149:
    for (paramContext = (Keyboard)new S2ChineseQwertyKeyboard(paramContext);; paramContext = (Context)localObject1)
    {
      ((Map)localObject2).put(Integer.valueOf(paramInt1), paramContext);
      if (localObject1 != null) {
        ((Keyboard)localObject1).onCreate();
      }
      AppMethodBeat.o(312050);
      return bool;
      localObject1 = ((com.tencent.mm.ui.k.b)localObject1).jBE();
      break;
      localObject1 = (Keyboard)((View)localObject2).findViewById(a.f.root);
      break label58;
    }
  }
  
  public static void reset()
  {
    Jvi = false;
    Jvl = false;
  }
  
  private static void w(Integer paramInteger)
  {
    AppMethodBeat.i(312228);
    if (paramInteger != null)
    {
      ((Number)paramInteger).intValue();
      if (paramInteger.intValue() <= com.tencent.mm.plugin.hld.keyboard.c.Jrr.ordinal())
      {
        if (!s.p(Jvk, paramInteger))
        {
          Jvk = paramInteger;
          n.JvW.fMR();
        }
        JuN.clear();
      }
      if (JuN.contains(paramInteger))
      {
        int i = JuN.indexOf(paramInteger);
        while ((i + 1 < JuN.size()) && (i >= 0)) {
          JuN.removeLast();
        }
      }
      JuN.add(paramInteger);
    }
    AppMethodBeat.o(312228);
  }
  
  public final void Yu(final int paramInt)
  {
    AppMethodBeat.i(312558);
    if (JuM != null)
    {
      localObject1 = JuM;
      s.checkNotNull(localObject1);
      if (((HashMap)localObject1).get(Integer.valueOf(paramInt)) == null)
      {
        Log.e("WxIme.ImeKeyboardSwitch", "switchKeyboard " + paramInt + " is null..");
        AppMethodBeat.o(312558);
        return;
      }
    }
    final int i = fMo();
    Object localObject1 = Jvk;
    if (paramInt == i)
    {
      Log.i("WxIme.ImeKeyboardSwitch", "switchKeyboard equal(" + i + ')');
      AppMethodBeat.o(312558);
      return;
    }
    Object localObject2 = f.JuH;
    f.fLV();
    localObject2 = new ah.a();
    boolean bool1;
    final ah.a locala;
    label185:
    label203:
    boolean bool2;
    label216:
    boolean bool3;
    if ((paramInt >= com.tencent.mm.plugin.hld.keyboard.c.Jrw.ordinal()) && (paramInt > i))
    {
      bool1 = true;
      ((ah.a)localObject2).aiwY = bool1;
      locala = new ah.a();
      if ((i < com.tencent.mm.plugin.hld.keyboard.c.Jrw.ordinal()) || (paramInt >= i)) {
        break label443;
      }
      bool1 = true;
      locala.aiwY = bool1;
      if (i != com.tencent.mm.plugin.hld.keyboard.c.Jru.ordinal()) {
        break label448;
      }
      bool1 = true;
      if (paramInt != com.tencent.mm.plugin.hld.keyboard.c.Jru.ordinal()) {
        break label453;
      }
      bool2 = true;
      if (paramInt >= com.tencent.mm.plugin.hld.keyboard.c.Jru.ordinal()) {
        break label459;
      }
      bool3 = true;
      label229:
      if (paramInt != com.tencent.mm.plugin.hld.keyboard.c.Jrv.ordinal()) {
        break label465;
      }
    }
    label443:
    label448:
    label453:
    label459:
    label465:
    for (boolean bool4 = true;; bool4 = false)
    {
      w(Integer.valueOf(paramInt));
      if (paramInt <= com.tencent.mm.plugin.hld.keyboard.c.Jrq.ordinal())
      {
        com.tencent.mm.plugin.hld.f.i locali = com.tencent.mm.plugin.hld.f.i.JyA;
        com.tencent.mm.plugin.hld.f.i.YH(fMo());
      }
      Log.i("WxIme.ImeKeyboardSwitch", "switchKeyboard " + i + " to:" + paramInt + ' ' + ((ah.a)localObject2).aiwY + ' ' + locala.aiwY + ' ' + bool1 + ' ' + bool2 + ' ' + bool3 + ' ' + bool4 + ' ' + localObject1);
      a(((ah.a)localObject2).aiwY, locala.aiwY, bool1, bool2, bool3, bool4, (kotlin.g.a.a)new g((ah.a)localObject2, locala, paramInt, i), (kotlin.g.a.a)new h(i, paramInt, (ah.a)localObject2, locala));
      AppMethodBeat.o(312558);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label185;
      bool1 = false;
      break label203;
      bool2 = false;
      break label216;
      bool3 = false;
      break label229;
    }
  }
  
  public final void a(com.tencent.mm.plugin.hld.keyboard.c paramc)
  {
    AppMethodBeat.i(312544);
    s.u(paramc, "keyboard");
    Yu(paramc.ordinal());
    AppMethodBeat.o(312544);
  }
  
  public final void fLY()
  {
    AppMethodBeat.i(312505);
    Context localContext = MMApplicationContext.getContext();
    int j = fMo();
    Object localObject1 = l.JyV;
    boolean bool1 = l.fKH();
    localObject1 = new StringBuilder("updateCurrentKeyboard isSafetyMode:").append(bool1).append(" isLogin:");
    Object localObject2 = com.tencent.mm.plugin.hld.f.i.JyA;
    Log.i("WxIme.ImeKeyboardSwitch", com.tencent.mm.plugin.hld.f.i.bGa());
    int i;
    if (bool1)
    {
      Yw(8);
      Yv(8);
      i = fLZ();
      if (i != j)
      {
        w(Integer.valueOf(i));
        s.s(localContext, "context");
        f(localContext, i, false);
        if (i != com.tencent.mm.plugin.hld.keyboard.c.Jrw.ordinal()) {
          break label490;
        }
        fMe();
      }
    }
    for (;;)
    {
      Log.i("WxIme.ImeKeyboardSwitch", "updateCurrentKeyboard " + i + ' ' + j);
      AppMethodBeat.o(312505);
      return;
      localObject1 = l.JyV;
      bool1 = l.fOT();
      localObject1 = l.JyV;
      boolean bool2 = l.fOW();
      localObject1 = l.JyV;
      boolean bool3 = l.fOZ();
      localObject1 = e.Jym;
      boolean bool4 = e.fOc();
      localObject1 = (d)com.tencent.mm.kernel.h.ax(d.class);
      if (localObject1 == null)
      {
        localObject1 = null;
        label223:
        localObject2 = com.tencent.mm.plugin.hld.f.i.JyA;
        if (!com.tencent.mm.plugin.hld.f.i.bGa()) {
          break label419;
        }
        if ((bool1) && (bool2)) {
          break label367;
        }
        Yv(8);
        Yw(0);
        localObject2 = k.JvH;
        k.jp(11, 7);
        i = 1;
        label266:
        if ((i != 0) || (bool3)) {
          break label412;
        }
      }
      label412:
      for (i = com.tencent.mm.plugin.hld.keyboard.c.Jrw.ordinal();; i = fLZ())
      {
        Log.i("WxIme.ImeKeyboardSwitch", "updateCurrentKeyboard first:" + bool1 + " second:" + bool2 + " fifth:" + bool3 + " finishFirstFetch:" + localObject1 + " cloudConfig:" + bool4);
        break;
        localObject1 = Boolean.valueOf(((d)localObject1).fKF());
        break label223;
        label367:
        if ((bool4) && (!s.p(localObject1, Boolean.TRUE)))
        {
          Yv(0);
          Yw(8);
          i = 1;
          break label266;
        }
        Yw(8);
        Yv(8);
        i = 0;
        break label266;
      }
      label419:
      if ((!bool1) || (!bool2) || (!bool3))
      {
        Yv(8);
        Yw(0);
      }
      for (;;)
      {
        i = fLZ();
        break;
        if ((bool4) && (!s.p(localObject1, Boolean.TRUE)))
        {
          Yv(0);
          Yw(8);
        }
        else
        {
          Yw(8);
          Yv(8);
        }
      }
      label490:
      a(false, false, false, false, true, false, (kotlin.g.a.a)i.Jvw, (kotlin.g.a.a)g.j.Jvx);
    }
  }
  
  public final void fMa()
  {
    View localView = null;
    Object localObject1 = null;
    AppMethodBeat.i(312514);
    Object localObject2 = com.tencent.mm.plugin.hld.f.i.JyA;
    int i = com.tencent.mm.plugin.hld.f.i.fMo();
    Log.i("WxIme.ImeKeyboardSwitch", s.X("resetToFirstLevelKeyboard ", Integer.valueOf(i)));
    localObject2 = fMr();
    if (localObject2 != null) {
      ((Keyboard)localObject2).onReset();
    }
    if (fMo() == i)
    {
      Yx(fMo());
      localView = JuT;
      if (localView == null) {}
      for (;;)
      {
        if (localObject1 == null) {
          Log.e("WxIme.ImeKeyboardSwitch", "resetToFirstLevelKeyboard mInputCenterView is null");
        }
        localObject1 = JuU;
        if (localObject1 != null) {
          ((FrameLayout)localObject1).setVisibility(0);
        }
        localObject1 = JuU;
        if (localObject1 != null) {
          ((FrameLayout)localObject1).setTranslationY(0.0F);
        }
        Log.i("WxIme.ImeKeyboardSwitch", "resetToFirstLevelKeyboard reset keyboard");
        AppMethodBeat.o(312514);
        return;
        localView.setAlpha(1.0F);
        localView.setVisibility(0);
        localObject1 = ah.aiuX;
      }
    }
    w(Integer.valueOf(i));
    if (fMr() == null)
    {
      localObject1 = mContext;
      if (localObject1 != null) {
        break label234;
      }
    }
    for (localObject1 = localView;; localObject1 = ah.aiuX)
    {
      if (localObject1 == null) {
        Log.e("WxIme.ImeKeyboardSwitch", "resetToFirstLevelKeyboard current:" + fMo() + ", mContext is null");
      }
      JuO = 1;
      a(false, false, true, false, true, false, (kotlin.g.a.a)g.d.Jvp, (kotlin.g.a.a)g.e.Jvq);
      AppMethodBeat.o(312514);
      return;
      label234:
      f((Context)localObject1, fMo(), false);
    }
  }
  
  public final void ih(Context paramContext)
  {
    AppMethodBeat.i(312524);
    s.u(paramContext, "context");
    Log.i("WxIme.ImeKeyboardSwitch", "preInitKeyboards");
    a(paramContext, fMo(), true, "WxIme.ImeKeyboardSwitch");
    new com.tencent.mm.ui.k.b(paramContext).eh(a.h.ime_input_view, null);
    a(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jrp.ordinal(), false, "WxIme.ImeKeyboardSwitch");
    a(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jrq.ordinal(), false, "WxIme.ImeKeyboardSwitch");
    a(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jrr.ordinal(), false, "WxIme.ImeKeyboardSwitch");
    a(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jrs.ordinal(), false, "WxIme.ImeKeyboardSwitch");
    a(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jrt.ordinal(), false, "WxIme.ImeKeyboardSwitch");
    a(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jru.ordinal(), false, "WxIme.ImeKeyboardSwitch");
    a(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jrw.ordinal(), false, "WxIme.ImeKeyboardSwitch");
    a(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jrx.ordinal(), false, "WxIme.ImeKeyboardSwitch");
    a(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jry.ordinal(), false, "WxIme.ImeKeyboardSwitch");
    AppMethodBeat.o(312524);
  }
  
  public final void ii(Context paramContext)
  {
    AppMethodBeat.i(312534);
    s.u(paramContext, "context");
    if (Jvi)
    {
      AppMethodBeat.o(312534);
      return;
    }
    Jvi = true;
    JuM = new HashMap();
    aI(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jrp.ordinal());
    aI(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jrq.ordinal());
    aI(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jrr.ordinal());
    aI(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jrs.ordinal());
    aI(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jrt.ordinal());
    aI(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jru.ordinal());
    aI(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jrw.ordinal());
    aI(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jrx.ordinal());
    aI(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Jry.ordinal());
    fMb();
    AppMethodBeat.o(312534);
  }
  
  public final void wW(boolean paramBoolean)
  {
    AppMethodBeat.i(312564);
    if (paramBoolean)
    {
      localObject = com.tencent.mm.plugin.hld.f.i.JyA;
      Yu(com.tencent.mm.plugin.hld.f.i.fMo());
      AppMethodBeat.o(312564);
      return;
    }
    Object localObject = k.JvH;
    k.aL(0, 1, 0);
    a(com.tencent.mm.plugin.hld.keyboard.c.Jry);
    AppMethodBeat.o(312564);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/model/ImeKeyboardSwitch$getBelowAnimator$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Animator.AnimatorListener
  {
    a(kotlin.g.a.a<ah> parama1, kotlin.g.a.a<ah> parama2) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(311824);
      s.u(paramAnimator, "animation");
      Log.w("WxIme.ImeKeyboardSwitch", "animator_move_to_below onAnimationCancel");
      paramAnimator = g.fMv();
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      AppMethodBeat.o(311824);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(311817);
      s.u(paramAnimator, "animation");
      Log.w("WxIme.ImeKeyboardSwitch", "animator_move_to_below onAnimationEnd");
      paramAnimator = g.fMv();
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      paramAnimator = parama2;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      paramAnimator = g.fMw();
      if (paramAnimator == null) {}
      for (paramAnimator = null;; paramAnimator = ah.aiuX)
      {
        if (paramAnimator == null) {
          Log.e("WxIme.ImeKeyboardSwitch", "getBelowAnimator mInputCenterView is null");
        }
        AppMethodBeat.o(311817);
        return;
        paramAnimator.setAlpha(0.0F);
        paramAnimator.setVisibility(8);
        com.tencent.mm.plugin.hld.f.k localk = com.tencent.mm.plugin.hld.f.k.JyF;
        paramAnimator.setTranslationY(com.tencent.mm.plugin.hld.f.k.ir(g.fMx()));
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(311830);
      s.u(paramAnimator, "animation");
      AppMethodBeat.o(311830);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(311810);
      s.u(paramAnimator, "animation");
      Log.w("WxIme.ImeKeyboardSwitch", "animator_move_to_below onAnimationStart");
      paramAnimator = this.Jvm;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      paramAnimator = g.fMv();
      if (paramAnimator != null) {
        paramAnimator.setVisibility(0);
      }
      paramAnimator = g.fMw();
      if (paramAnimator == null) {}
      for (paramAnimator = null;; paramAnimator = ah.aiuX)
      {
        if (paramAnimator == null) {
          Log.e("WxIme.ImeKeyboardSwitch", "getBelowAnimator mInputCenterView is null");
        }
        AppMethodBeat.o(311810);
        return;
        paramAnimator.setVisibility(0);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/model/ImeKeyboardSwitch$getUpAnimator$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Animator.AnimatorListener
  {
    b(kotlin.g.a.a<ah> parama1, kotlin.g.a.a<ah> parama2) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(311833);
      s.u(paramAnimator, "animation");
      Log.w("WxIme.ImeKeyboardSwitch", "animator_move_to_up onAnimationCancel");
      AppMethodBeat.o(311833);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(311827);
      s.u(paramAnimator, "animation");
      Log.i("WxIme.ImeKeyboardSwitch", "animator_move_to_up onAnimationEnd");
      paramAnimator = parama2;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      paramAnimator = g.fMw();
      if (paramAnimator == null) {}
      for (paramAnimator = null;; paramAnimator = ah.aiuX)
      {
        if (paramAnimator == null) {
          Log.e("WxIme.ImeKeyboardSwitch", "getUpAnimator mInputCenterView is null");
        }
        AppMethodBeat.o(311827);
        return;
        paramAnimator.setAlpha(1.0F);
        paramAnimator.setVisibility(8);
        paramAnimator.setTranslationY(0.0F);
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(311840);
      s.u(paramAnimator, "animation");
      AppMethodBeat.o(311840);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(311818);
      s.u(paramAnimator, "animation");
      Log.i("WxIme.ImeKeyboardSwitch", "animator_move_to_up onAnimationStart");
      paramAnimator = this.Jvm;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      paramAnimator = g.fMv();
      if (paramAnimator != null) {
        paramAnimator.setVisibility(0);
      }
      paramAnimator = g.fMw();
      if (paramAnimator == null) {}
      for (paramAnimator = null;; paramAnimator = ah.aiuX)
      {
        if (paramAnimator == null) {
          Log.e("WxIme.ImeKeyboardSwitch", "getUpAnimator mInputCenterView is null");
        }
        AppMethodBeat.o(311818);
        return;
        paramAnimator.setVisibility(0);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/model/ImeKeyboardSwitch$leftSlideInputLeftKeyboard$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animator.AnimatorListener
  {
    c(kotlin.g.a.a<ah> parama1, FrameLayout paramFrameLayout, kotlin.g.a.a<ah> parama2) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(311831);
      s.u(paramAnimator, "animation");
      AppMethodBeat.o(311831);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(311823);
      s.u(paramAnimator, "animation");
      paramAnimator = parama2;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      AppMethodBeat.o(311823);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(311839);
      s.u(paramAnimator, "animation");
      AppMethodBeat.o(311839);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(311816);
      s.u(paramAnimator, "animation");
      paramAnimator = this.Jvm;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      paramAnimator = localFrameLayout;
      if (paramAnimator != null) {
        paramAnimator.setVisibility(0);
      }
      AppMethodBeat.o(311816);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/model/ImeKeyboardSwitch$rightSlideInputLeftKeyboard$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements Animator.AnimatorListener
  {
    f(kotlin.g.a.a<ah> parama1, FrameLayout paramFrameLayout, kotlin.g.a.a<ah> parama2) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(311841);
      s.u(paramAnimator, "animation");
      AppMethodBeat.o(311841);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(311834);
      s.u(paramAnimator, "animation");
      paramAnimator = this.Jvr;
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      paramAnimator = parama2;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      AppMethodBeat.o(311834);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(311848);
      s.u(paramAnimator, "animation");
      AppMethodBeat.o(311848);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(311826);
      s.u(paramAnimator, "animation");
      paramAnimator = this.Jvm;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      AppMethodBeat.o(311826);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(ah.a parama1, ah.a parama2, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(int paramInt1, int paramInt2, ah.a parama1, ah.a parama2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final i Jvw;
    
    static
    {
      AppMethodBeat.i(311819);
      Jvw = new i();
      AppMethodBeat.o(311819);
    }
    
    i()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.g
 * JD-Core Version:    0.7.0.1
 */