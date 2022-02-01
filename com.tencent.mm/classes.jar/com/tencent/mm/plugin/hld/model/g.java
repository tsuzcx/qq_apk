package com.tencent.mm.plugin.hld.model;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
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
import com.tencent.mm.plugin.hld.keyboard.Keyboard;
import com.tencent.mm.plugin.hld.keyboard.S10SettingKeyboard;
import com.tencent.mm.plugin.hld.keyboard.S8ExceptionSettingKeyboard;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.S2ChineseQwertyKeyboard;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.k.b.a;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.d;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/ImeKeyboardSwitch;", "", "()V", "TAG", "", "animator_move_to_below", "Landroid/animation/ObjectAnimator;", "animator_move_to_up", "mActiveMaskBt", "Landroid/widget/Button;", "mActiveMaskDescTv", "Landroid/widget/TextView;", "mActiveMaskLl", "Landroid/widget/RelativeLayout;", "mActiveMaskTitleTv", "mCandidateView", "Lcom/tencent/mm/plugin/hld/candidate/ImeCandidateView;", "mContext", "Landroid/content/Context;", "mCurrentFirstLevelKeyboard", "", "Ljava/lang/Integer;", "mFirstInitializeStart", "", "mHasKeySendAction", "mIKeyboardActionListener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "mIfShieldCandidateView", "mImeKeyboardViewMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/hld/keyboard/Keyboard;", "Lkotlin/collections/HashMap;", "mInputBelowView", "Landroid/widget/FrameLayout;", "mInputCenterContainer", "mInputCenterView", "Landroid/view/View;", "mInputContainer", "mInputEmojiView", "mInputLeftView", "mInputLeftView2", "mInputUpView", "mKeyboardStatus", "mKeyboardTask", "Ljava/util/LinkedList;", "mSecondInitializeStart", "getMSecondInitializeStart", "()Z", "setMSecondInitializeStart", "(Z)V", "mSettingBt", "mUpdateDictMaskView", "mUpdateDictMaskViewstub", "Landroid/view/ViewStub;", "addKeyboardTask", "", "keyboard", "(Ljava/lang/Integer;)V", "backLastKeyboard", "firstInitKeyboard", "context", "ordinal", "getBelowAnimator", "beforeCallback", "Lkotlin/Function0;", "afterCallback", "getCurrentFirstLevelKeyboard", "getCurrentKeyboard", "getCurrentKeyboardOrdinal", "getCurrentKeyboardStatus", "getCurrentReportKbType", "getImeCandidateView", "getInputContainer", "getLastKeyboardOrdinal", "getNewKeyboard", "getResId", "getUpAnimator", "getmIfShieldCandidateView", "goExceptionSettingKeyboard", "goImeEmojiKeyboard", "goSettingKeyboard", "back", "handleActiveMaskBtClick", "hasKeySendAction", "init", "listener", "initInputView", "initKeyBoard", "firstInit", "initKeyboardImp", "resource", "initKeyboardRealImpl", "initSwitch", "isCurrentKeyboard", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "isFirstLevelEnglishKeyboard", "isS3EnglishQwertyKeyboard", "isUpperMode", "leftSlideInputLeftKeyboard", "onEngineInitializeSuccess", "onResumeKeyboard", "onSelectCandidate", "text", "id", "", "suffix", "onUpdateSelection", "oldSelStart", "oldSelEnd", "newSelStart", "newSelEnd", "candidatesStart", "candidatesEnd", "preInitKeyBoard", "first", "serialTag", "preInitKeyboards", "removeKeyboardTask", "reset", "resetToFirstLevelKeyboard", "rightSlideInputLeftKeyboard", "secondInitKeyboard", "secondInitSwitch", "setVisibleActiveMaskLl", "visible", "setVisibleUpdateDictMaskView", "showActiveKeyboard", "switchKeyboard", "keyboardOrdinal", "switchToChineseKeyboard", "transparentUpKeyboardBg", "currentKeyboardOrdinal", "transparent", "updateActionKey", "updateCurrentKeyboard", "updateEmojiKeyboard", "updateInputBelowKeyboard", "updateInputKeyboard", "hasLeftSlideAnimation", "hasRightSlideAnimation", "hasUpAnimation", "hasBelowAnimation", "updateUpKeyboard", "updateInputUpKeyboard", "updateKeyboardStatus", "hasStrikeContent", "hasClipboardContent", "updateUpperMod", "viewSaveToImage", "plugin-hld_release"})
@SuppressLint({"StaticFieldLeak"})
public final class g
{
  private static HashMap<Integer, Keyboard> DBM;
  private static LinkedList<Integer> DBN;
  private static int DBO;
  private static View DBP;
  private static ImeCandidateView DBQ;
  private static RelativeLayout DBR;
  private static FrameLayout DBS;
  private static View DBT;
  private static FrameLayout DBU;
  private static FrameLayout DBV;
  private static FrameLayout DBW;
  private static FrameLayout DBX;
  private static RelativeLayout DBY;
  private static TextView DBZ;
  private static TextView DCa;
  private static Button DCb;
  private static ViewStub DCc;
  static View DCd;
  private static Button DCe;
  private static ObjectAnimator DCf;
  private static ObjectAnimator DCg;
  private static boolean DCh;
  private static boolean DCi;
  private static boolean DCj;
  private static Integer DCk;
  private static boolean DCl;
  public static final g DCm;
  private static com.tencent.mm.plugin.hld.a.c Dup;
  private static Context mContext;
  
  static
  {
    AppMethodBeat.i(211340);
    DCm = new g();
    DBN = new LinkedList();
    DBO = 1;
    AppMethodBeat.o(211340);
  }
  
  private static void UA(final int paramInt)
  {
    AppMethodBeat.i(211338);
    Object localObject1 = DBM;
    if (localObject1 != null)
    {
      localObject1 = (Keyboard)((HashMap)localObject1).get(Integer.valueOf(paramInt));
      if (localObject1 != null)
      {
        Object localObject2 = com.tencent.mm.plugin.hld.f.k.DHH;
        final boolean bool = com.tencent.mm.plugin.hld.f.k.isLandscape();
        localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
        com.tencent.mm.plugin.hld.f.k localk = com.tencent.mm.plugin.hld.f.k.DHH;
        if (!u.agG(((com.tencent.mm.plugin.hld.f.l)localObject2).aG(paramInt, com.tencent.mm.plugin.hld.f.k.isLandscape())))
        {
          if (localObject1 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(211338);
            throw ((Throwable)localObject1);
          }
          ((View)localObject1).post((Runnable)new r((Keyboard)localObject1, bool, paramInt));
        }
        AppMethodBeat.o(211338);
        return;
      }
      AppMethodBeat.o(211338);
      return;
    }
    AppMethodBeat.o(211338);
  }
  
  private static int Uw(int paramInt)
  {
    AppMethodBeat.i(211293);
    e locale = e.DGW;
    if (e.eGo())
    {
      if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Dyl.ordinal())
      {
        paramInt = a.h.ime_keyboard_s1_chinese_t9_selfdraw;
        AppMethodBeat.o(211293);
        return paramInt;
      }
      if (paramInt != com.tencent.mm.plugin.hld.keyboard.c.Dym.ordinal())
      {
        if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Dyn.ordinal())
        {
          paramInt = a.h.ime_keyboard_s3_english_qwerty_selfdraw;
          AppMethodBeat.o(211293);
          return paramInt;
        }
        if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Dyo.ordinal())
        {
          paramInt = a.h.ime_keyboard_s4_number_selfdraw;
          AppMethodBeat.o(211293);
          return paramInt;
        }
        if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Dyp.ordinal())
        {
          paramInt = a.h.ime_keyboard_s5_symbol;
          AppMethodBeat.o(211293);
          return paramInt;
        }
        if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Dyq.ordinal())
        {
          paramInt = a.h.ime_keyboard_s6_alternative_words;
          AppMethodBeat.o(211293);
          return paramInt;
        }
        if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Dyr.ordinal())
        {
          paramInt = a.h.ime_keyboard_s7_emoji;
          AppMethodBeat.o(211293);
          return paramInt;
        }
        if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Dys.ordinal())
        {
          paramInt = a.h.ime_keyboard_s8_ime_setting;
          AppMethodBeat.o(211293);
          return paramInt;
        }
        if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Dyt.ordinal())
        {
          paramInt = a.h.ime_keyboard_s9_sound_vibrate;
          AppMethodBeat.o(211293);
          return paramInt;
        }
        if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Dyu.ordinal())
        {
          paramInt = a.h.ime_keyboard_s10_setting;
          AppMethodBeat.o(211293);
          return paramInt;
        }
      }
      paramInt = a.h.ime_keyboard_s2_chinese_qwerty_selfdraw;
      AppMethodBeat.o(211293);
      return paramInt;
    }
    if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Dyl.ordinal())
    {
      paramInt = a.h.ime_keyboard_s1_chinese_t9;
      AppMethodBeat.o(211293);
      return paramInt;
    }
    if (paramInt != com.tencent.mm.plugin.hld.keyboard.c.Dym.ordinal())
    {
      if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Dyn.ordinal())
      {
        paramInt = a.h.ime_keyboard_s3_english_qwerty;
        AppMethodBeat.o(211293);
        return paramInt;
      }
      if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Dyo.ordinal())
      {
        paramInt = a.h.ime_keyboard_s4_number;
        AppMethodBeat.o(211293);
        return paramInt;
      }
      if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Dyp.ordinal())
      {
        paramInt = a.h.ime_keyboard_s5_symbol;
        AppMethodBeat.o(211293);
        return paramInt;
      }
      if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Dyq.ordinal())
      {
        paramInt = a.h.ime_keyboard_s6_alternative_words;
        AppMethodBeat.o(211293);
        return paramInt;
      }
      if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Dyr.ordinal())
      {
        paramInt = a.h.ime_keyboard_s7_emoji;
        AppMethodBeat.o(211293);
        return paramInt;
      }
      if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Dys.ordinal())
      {
        paramInt = a.h.ime_keyboard_s8_ime_setting;
        AppMethodBeat.o(211293);
        return paramInt;
      }
      if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Dyt.ordinal())
      {
        paramInt = a.h.ime_keyboard_s9_sound_vibrate;
        AppMethodBeat.o(211293);
        return paramInt;
      }
      if (paramInt == com.tencent.mm.plugin.hld.keyboard.c.Dyu.ordinal())
      {
        paramInt = a.h.ime_keyboard_s10_setting;
        AppMethodBeat.o(211293);
        return paramInt;
      }
    }
    paramInt = a.h.ime_keyboard_s2_chinease_qwerty;
    AppMethodBeat.o(211293);
    return paramInt;
  }
  
  private static void Uy(int paramInt)
  {
    View localView = null;
    AppMethodBeat.i(211333);
    try
    {
      Object localObject1 = DCc;
      if (localObject1 != null) {}
      for (localObject1 = ((ViewStub)localObject1).inflate();; localObject1 = null)
      {
        if (localObject1 != null) {
          localView = ((View)localObject1).findViewById(a.f.update_dict_ll);
        }
        DCd = localView;
        localObject1 = DCd;
        if (localObject1 == null) {
          break;
        }
        ((View)localObject1).setVisibility(paramInt);
        AppMethodBeat.o(211333);
        return;
      }
      AppMethodBeat.o(211333);
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = DCc;
      if (localObject2 != null) {
        ((ViewStub)localObject2).setVisibility(0);
      }
      localObject2 = DCd;
      if (localObject2 != null)
      {
        ((View)localObject2).setVisibility(paramInt);
        AppMethodBeat.o(211333);
        return;
      }
      AppMethodBeat.o(211333);
      return;
    }
    finally
    {
      localView = DCd;
      if (localView != null) {
        localView.setVisibility(paramInt);
      }
      AppMethodBeat.o(211333);
    }
  }
  
  private static void Uz(int paramInt)
  {
    AppMethodBeat.i(211336);
    Object localObject;
    if (paramInt == 0)
    {
      localObject = com.tencent.mm.plugin.hld.f.i.DHq;
      if (com.tencent.mm.plugin.hld.f.i.biq()) {
        break label147;
      }
      localObject = (d)com.tencent.mm.kernel.h.ae(d.class);
      if (localObject == null) {
        break label147;
      }
      localObject = ((d)localObject).eCD();
      if ((localObject == null) || (((com.tencent.mm.plugin.hld.a.b)localObject).eCu() != true)) {
        break label147;
      }
      localObject = DBZ;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)MMApplicationContext.getContext().getString(a.j.ime_keyboard_active_title_exchange));
      }
      localObject = DCa;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)MMApplicationContext.getContext().getString(a.j.ime_keyboard_active_desc_exchange));
      }
      localObject = DCb;
      if (localObject != null) {
        ((Button)localObject).setText((CharSequence)MMApplicationContext.getContext().getString(a.j.ime_keyboard_active_setting_exchange));
      }
    }
    for (;;)
    {
      localObject = DBY;
      if (localObject == null) {
        break;
      }
      ((RelativeLayout)localObject).setVisibility(paramInt);
      AppMethodBeat.o(211336);
      return;
      label147:
      localObject = DBZ;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)MMApplicationContext.getContext().getString(a.j.ime_keyboard_active_title));
      }
      localObject = DCa;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)MMApplicationContext.getContext().getString(a.j.ime_keyboard_active_desc));
      }
      localObject = DCb;
      if (localObject != null) {
        ((Button)localObject).setText((CharSequence)MMApplicationContext.getContext().getString(a.j.ime_keyboard_active_setting));
      }
    }
    AppMethodBeat.o(211336);
  }
  
  private static void a(final Context paramContext, final int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool3 = false;
    boolean bool2 = true;
    AppMethodBeat.i(211295);
    Log.i("WxIme.ImeKeyboardSwitch", "initKeyboardImp start " + paramInt1 + ' ' + paramInt2 + ' ' + paramBoolean);
    long l = System.currentTimeMillis();
    Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    com.tencent.mm.plugin.hld.f.k localk = com.tencent.mm.plugin.hld.f.k.DHH;
    localObject = ((com.tencent.mm.plugin.hld.f.l)localObject).aG(paramInt1, com.tencent.mm.plugin.hld.f.k.isLandscape());
    boolean bool1;
    if (paramBoolean)
    {
      localk = com.tencent.mm.plugin.hld.f.k.DHH;
      if ((!com.tencent.mm.plugin.hld.f.k.isLandscape()) && (u.agG((String)localObject)))
      {
        localObject = e.DGW;
        if (!e.eGo())
        {
          bool1 = true;
          paramBoolean = bool3;
          if (!bool1) {
            break label272;
          }
          localObject = com.tencent.mm.ui.k.b.XIY;
          localObject = b.a.axo(paramInt2);
          if ((localObject == null) || (((com.tencent.mm.ui.k.b)localObject).hXg() != true)) {
            break label267;
          }
          paramBoolean = true;
          label151:
          if (paramBoolean) {
            break label272;
          }
          com.tencent.e.h.ZvG.be((Runnable)new g(paramInt2, paramContext, paramInt1));
        }
      }
    }
    for (;;)
    {
      Log.i("WxIme.ImeKeyboardSwitch", "initKeyboardImp " + paramInt1 + ' ' + (System.currentTimeMillis() - l) + ' ' + ar.isDarkMode() + ' ' + bool2 + ' ' + bool1 + ' ' + paramBoolean);
      AppMethodBeat.o(211295);
      return;
      bool1 = false;
      break;
      label267:
      paramBoolean = false;
      break label151;
      label272:
      bool2 = h(paramContext, paramInt1, paramInt2);
    }
  }
  
  private static void a(Context paramContext, int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(211289);
    if ((!paramBoolean) && (paramInt == eEm()))
    {
      AppMethodBeat.o(211289);
      return;
    }
    int i = Uw(paramInt);
    Log.d("WxIme.ImeKeyboardSwitch", "preInitKeyBoard " + paramInt + ' ' + i);
    new com.tencent.mm.ui.k.b(paramContext).jdMethod_do(i, paramString);
    AppMethodBeat.o(211289);
  }
  
  public static void a(Context paramContext, com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(211271);
    p.k(paramContext, "context");
    p.k(paramc, "listener");
    long l = System.currentTimeMillis();
    mContext = paramContext;
    Dup = paramc;
    paramContext = com.tencent.mm.plugin.hld.f.i.DHq;
    paramContext = Integer.valueOf(com.tencent.mm.plugin.hld.f.i.eEm());
    DCk = paramContext;
    p(paramContext);
    Log.i("WxIme.ImeKeyboardSwitch", "init " + (System.currentTimeMillis() - l));
    AppMethodBeat.o(211271);
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, kotlin.g.a.a<x> parama1, kotlin.g.a.a<x> parama2)
  {
    AppMethodBeat.i(211306);
    if (paramBoolean1)
    {
      b(parama1, parama2);
      AppMethodBeat.o(211306);
      return;
    }
    Object localObject;
    if (paramBoolean2)
    {
      c(parama1, parama2);
      if (eEm() < com.tencent.mm.plugin.hld.keyboard.c.Dys.ordinal())
      {
        if (!paramBoolean4) {
          break label177;
        }
        eEe();
        if (!paramBoolean2) {
          break label149;
        }
        localObject = DBU;
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
      eEi();
      AppMethodBeat.o(211306);
      return;
      localObject = DBW;
      if (localObject != null) {
        ((FrameLayout)localObject).setVisibility(8);
      }
      localObject = DBX;
      if (localObject == null) {
        break;
      }
      ((FrameLayout)localObject).setVisibility(8);
      break;
      label149:
      localObject = DCg;
      if (localObject != null) {
        ((ObjectAnimator)localObject).cancel();
      }
      e(parama1, parama2).start();
      continue;
      label177:
      if (paramBoolean6)
      {
        localObject = DBV;
        if (localObject != null) {
          ((FrameLayout)localObject).setVisibility(0);
        }
        eEf();
        if (parama1 != null) {
          parama1.invoke();
        }
        if (parama2 != null) {
          parama2.invoke();
        }
      }
      else
      {
        localObject = DBV;
        if (localObject != null) {
          ((FrameLayout)localObject).setVisibility(8);
        }
        if (paramBoolean5)
        {
          eEd();
          if (paramBoolean2)
          {
            if (paramBoolean3)
            {
              localObject = DBU;
              if (localObject != null) {
                ((FrameLayout)localObject).setVisibility(0);
              }
              localObject = DBU;
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
            localObject = DCf;
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
          eEe();
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
  
  public static void af(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(211316);
    int i;
    if (paramBoolean1) {
      i = 2;
    }
    for (;;)
    {
      DBO = i;
      eEi();
      AppMethodBeat.o(211316);
      return;
      if (paramBoolean2)
      {
        i = 4;
      }
      else
      {
        com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
        if (com.tencent.mm.plugin.hld.f.l.eGY()) {
          i = 1;
        } else {
          i = 3;
        }
      }
    }
  }
  
  private final void av(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(211285);
    if (paramInt == eEm()) {
      f(paramContext, paramInt, true);
    }
    AppMethodBeat.o(211285);
  }
  
  private static void b(final kotlin.g.a.a<x> parama1, final kotlin.g.a.a<x> parama2)
  {
    AppMethodBeat.i(211310);
    Object localObject = eEp();
    if (localObject != null)
    {
      if (((localObject instanceof S8ExceptionSettingKeyboard)) || ((localObject instanceof S10SettingKeyboard))) {}
      for (FrameLayout localFrameLayout = DBW;; localFrameLayout = DBX)
      {
        if (localFrameLayout != null) {
          localFrameLayout.removeAllViews();
        }
        if (localFrameLayout != null) {
          localFrameLayout.addView((View)localObject);
        }
        localObject = com.tencent.mm.plugin.hld.f.k.DHH;
        localObject = MMApplicationContext.getContext();
        p.j(localObject, "MMApplicationContext.getContext()");
        int i = com.tencent.mm.plugin.hld.f.k.getScreenWidth((Context)localObject);
        localObject = ObjectAnimator.ofFloat(localFrameLayout, View.TRANSLATION_X, new float[] { i, 0.0F });
        p.j(localObject, "leftSlideAnimator");
        ((ObjectAnimator)localObject).setDuration(300L);
        ((ObjectAnimator)localObject).setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
        ((ObjectAnimator)localObject).addListener((Animator.AnimatorListener)new h(localFrameLayout, parama1, parama2));
        ((ObjectAnimator)localObject).start();
        AppMethodBeat.o(211310);
        return;
      }
    }
    AppMethodBeat.o(211310);
  }
  
  public static boolean b(com.tencent.mm.plugin.hld.keyboard.c paramc)
  {
    AppMethodBeat.i(211312);
    p.k(paramc, "keyboard");
    if (paramc.ordinal() == eEm())
    {
      AppMethodBeat.o(211312);
      return true;
    }
    AppMethodBeat.o(211312);
    return false;
  }
  
  private static void c(final kotlin.g.a.a<x> parama1, final kotlin.g.a.a<x> parama2)
  {
    AppMethodBeat.i(211311);
    Object localObject1 = eEp();
    if (localObject1 != null)
    {
      if ((localObject1 instanceof S8ExceptionSettingKeyboard)) {}
      for (localObject1 = DBX;; localObject1 = DBW)
      {
        Object localObject2 = com.tencent.mm.plugin.hld.f.k.DHH;
        localObject2 = MMApplicationContext.getContext();
        p.j(localObject2, "MMApplicationContext.getContext()");
        int i = com.tencent.mm.plugin.hld.f.k.getScreenWidth((Context)localObject2);
        localObject2 = ObjectAnimator.ofFloat(localObject1, View.TRANSLATION_X, new float[] { 0.0F, i });
        p.j(localObject2, "rightSlideAnimator");
        ((ObjectAnimator)localObject2).setDuration(300L);
        ((ObjectAnimator)localObject2).setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
        ((ObjectAnimator)localObject2).addListener((Animator.AnimatorListener)new k((FrameLayout)localObject1, parama1, parama2));
        ((ObjectAnimator)localObject2).start();
        AppMethodBeat.o(211311);
        return;
      }
    }
    AppMethodBeat.o(211311);
  }
  
  private static ObjectAnimator d(kotlin.g.a.a<x> parama1, final kotlin.g.a.a<x> parama2)
  {
    AppMethodBeat.i(211325);
    if (DCg == null)
    {
      localObject = DBU;
      Property localProperty = View.TRANSLATION_Y;
      com.tencent.mm.plugin.hld.f.k localk = com.tencent.mm.plugin.hld.f.k.DHH;
      localObject = ObjectAnimator.ofFloat(localObject, localProperty, new float[] { com.tencent.mm.plugin.hld.f.k.gW(mContext), 0.0F });
      DCg = (ObjectAnimator)localObject;
      if (localObject != null) {
        ((ObjectAnimator)localObject).setDuration(300L);
      }
      localObject = DCg;
      if (localObject != null) {
        ((ObjectAnimator)localObject).setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
      }
      localObject = DCg;
      if (localObject != null) {
        ((ObjectAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)c.DCq);
      }
    }
    Object localObject = DCg;
    if (localObject != null) {
      ((ObjectAnimator)localObject).removeAllListeners();
    }
    localObject = DCg;
    if (localObject != null) {
      ((ObjectAnimator)localObject).addListener((Animator.AnimatorListener)new d(parama1, parama2));
    }
    parama1 = DCg;
    if (parama1 == null)
    {
      parama1 = new t("null cannot be cast to non-null type android.animation.ObjectAnimator");
      AppMethodBeat.o(211325);
      throw parama1;
    }
    AppMethodBeat.o(211325);
    return parama1;
  }
  
  private static ObjectAnimator e(kotlin.g.a.a<x> parama1, final kotlin.g.a.a<x> parama2)
  {
    AppMethodBeat.i(211327);
    if (DCf == null)
    {
      localObject = DBU;
      Property localProperty = View.TRANSLATION_Y;
      com.tencent.mm.plugin.hld.f.k localk = com.tencent.mm.plugin.hld.f.k.DHH;
      localObject = ObjectAnimator.ofFloat(localObject, localProperty, new float[] { 0.0F, com.tencent.mm.plugin.hld.f.k.gW(mContext) });
      DCf = (ObjectAnimator)localObject;
      if (localObject != null) {
        ((ObjectAnimator)localObject).setDuration(300L);
      }
      localObject = DCf;
      if (localObject != null) {
        ((ObjectAnimator)localObject).setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
      }
      localObject = DCf;
      if (localObject != null) {
        ((ObjectAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)a.DCn);
      }
    }
    Object localObject = DCf;
    if (localObject != null) {
      ((ObjectAnimator)localObject).removeAllListeners();
    }
    localObject = DCf;
    if (localObject != null) {
      ((ObjectAnimator)localObject).addListener((Animator.AnimatorListener)new b(parama1, parama2));
    }
    parama1 = DCf;
    if (parama1 == null)
    {
      parama1 = new t("null cannot be cast to non-null type android.animation.ObjectAnimator");
      AppMethodBeat.o(211327);
      throw parama1;
    }
    AppMethodBeat.o(211327);
    return parama1;
  }
  
  public static boolean eDV()
  {
    return DCl;
  }
  
  private static int eDX()
  {
    AppMethodBeat.i(211273);
    eEm();
    Object localObject = DBW;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = DBX;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = com.tencent.mm.plugin.hld.f.i.DHq;
    int i = com.tencent.mm.plugin.hld.f.i.eEm();
    localObject = com.tencent.mm.plugin.hld.f.k.DHH;
    localObject = com.tencent.mm.plugin.hld.f.k.eGO();
    if (localObject == null)
    {
      if (localObject != null) {
        break label190;
      }
      if (localObject != null) {
        break label202;
      }
      label66:
      if (localObject != null) {
        break label214;
      }
      label70:
      if (localObject != null) {
        break label225;
      }
      label74:
      if (localObject != null) {
        break label238;
      }
      label78:
      if (localObject != null) {
        break label250;
      }
      label82:
      if (localObject != null) {
        break label263;
      }
      label86:
      if (localObject != null) {
        break label274;
      }
      label90:
      if (localObject != null) {
        break label287;
      }
      label94:
      if (localObject != null) {
        break label307;
      }
      if (localObject != null) {
        break label320;
      }
      label102:
      if (localObject != null) {
        break label332;
      }
      label106:
      if (localObject != null) {
        break label345;
      }
      label110:
      if (localObject != null) {
        break label358;
      }
      label114:
      if (localObject != null) {
        break label371;
      }
      label118:
      localObject = com.tencent.mm.plugin.hld.f.k.DHH;
      localObject = com.tencent.mm.plugin.hld.f.k.eGO();
      if (localObject != null) {
        break label384;
      }
    }
    label138:
    label142:
    boolean bool;
    label144:
    label190:
    label202:
    label214:
    label225:
    label238:
    label250:
    while (((Integer)localObject).intValue() != 18)
    {
      if (localObject != null) {
        break label398;
      }
      if (localObject != null) {
        break label411;
      }
      if (localObject != null) {
        break label424;
      }
      bool = false;
      DCj = bool;
      if (bool)
      {
        localObject = DBQ;
        if (localObject != null) {
          ImeCandidateView.a((ImeCandidateView)localObject);
        }
      }
      AppMethodBeat.o(211273);
      return i;
      if (((Integer)localObject).intValue() != 4) {
        break;
      }
      for (;;)
      {
        i = com.tencent.mm.plugin.hld.keyboard.c.Dyo.ordinal();
        break label118;
        if (((Integer)localObject).intValue() != 20)
        {
          break;
          if (((Integer)localObject).intValue() != 36)
          {
            break label66;
            if (((Integer)localObject).intValue() != 2)
            {
              break label70;
              if (((Integer)localObject).intValue() != 8194)
              {
                break label74;
                if (((Integer)localObject).intValue() != 18)
                {
                  break label78;
                  if (((Integer)localObject).intValue() != 4098)
                  {
                    break label82;
                    if (((Integer)localObject).intValue() != 3)
                    {
                      break label86;
                      if (((Integer)localObject).intValue() != 161) {
                        break label90;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      if (((Integer)localObject).intValue() != 16384) {
        break label94;
      }
      for (;;)
      {
        i = com.tencent.mm.plugin.hld.keyboard.c.Dyn.ordinal();
        break label118;
        if (((Integer)localObject).intValue() != 8192)
        {
          break;
          if (((Integer)localObject).intValue() != 33)
          {
            break label102;
            if (((Integer)localObject).intValue() != 129)
            {
              break label106;
              if (((Integer)localObject).intValue() != 145)
              {
                break label110;
                if (((Integer)localObject).intValue() != 209)
                {
                  break label114;
                  if (((Integer)localObject).intValue() != 225) {
                    break label118;
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label263:
      label274:
      label287:
      label307:
      label320:
      label332:
      label345:
      label358:
      label371:
      bool = true;
      label384:
      break label144;
      label398:
      if (((Integer)localObject).intValue() != 129)
      {
        break;
        label411:
        if (((Integer)localObject).intValue() != 145)
        {
          break label138;
          label424:
          if (((Integer)localObject).intValue() != 225) {
            break label142;
          }
        }
      }
    }
  }
  
  private final void eDZ()
  {
    boolean bool = false;
    Object localObject2 = null;
    AppMethodBeat.i(211282);
    long l1 = System.currentTimeMillis();
    Object localObject1 = com.tencent.mm.ui.k.b.XIY;
    localObject1 = b.a.axo(a.h.ime_input_view);
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.ui.k.b)localObject1).hXh();
      DBP = (View)localObject1;
      if (DBP != null) {
        break label665;
      }
      DBP = ad.kS(mContext).inflate(a.h.ime_input_view, null, false);
    }
    for (;;)
    {
      localObject1 = DBP;
      label91:
      long l2;
      if (localObject1 != null)
      {
        localObject1 = (ImeCandidateView)((View)localObject1).findViewById(a.f.candidate_container);
        DBQ = (ImeCandidateView)localObject1;
        if (localObject1 != null) {
          ((ImeCandidateView)localObject1).a(Dup);
        }
        l2 = System.currentTimeMillis();
        localObject1 = DBP;
        if (localObject1 == null) {
          break label593;
        }
        localObject1 = (RelativeLayout)((View)localObject1).findViewById(a.f.input_center_container);
        label137:
        DBR = (RelativeLayout)localObject1;
        localObject1 = DBP;
        if (localObject1 == null) {
          break label599;
        }
        localObject1 = (FrameLayout)((View)localObject1).findViewById(a.f.input_below_view);
        label165:
        DBS = (FrameLayout)localObject1;
        localObject1 = DBP;
        if (localObject1 == null) {
          break label605;
        }
        localObject1 = ((View)localObject1).findViewById(a.f.input_center_view);
        label190:
        DBT = (View)localObject1;
        localObject1 = DBP;
        if (localObject1 == null) {
          break label611;
        }
        localObject1 = (FrameLayout)((View)localObject1).findViewById(a.f.input_up_view);
        label218:
        DBU = (FrameLayout)localObject1;
        localObject1 = DBP;
        if (localObject1 == null) {
          break label617;
        }
        localObject1 = (FrameLayout)((View)localObject1).findViewById(a.f.input_view);
        label246:
        DBV = (FrameLayout)localObject1;
        localObject1 = DBP;
        if (localObject1 == null) {
          break label623;
        }
        localObject1 = (FrameLayout)((View)localObject1).findViewById(a.f.input_left_view);
        label274:
        DBW = (FrameLayout)localObject1;
        localObject1 = DBP;
        if (localObject1 == null) {
          break label629;
        }
        localObject1 = (FrameLayout)((View)localObject1).findViewById(a.f.input_left_view2);
        label302:
        DBX = (FrameLayout)localObject1;
        localObject1 = DBU;
        if (localObject1 != null) {
          ((FrameLayout)localObject1).setOnTouchListener((View.OnTouchListener)e.DCr);
        }
        localObject1 = DBP;
        if (localObject1 == null) {
          break label635;
        }
        localObject1 = (RelativeLayout)((View)localObject1).findViewById(a.f.active_ll);
        label351:
        DBY = (RelativeLayout)localObject1;
        if (localObject1 == null) {
          break label641;
        }
        localObject1 = (TextView)((RelativeLayout)localObject1).findViewById(a.f.title_tv);
        label374:
        DBZ = (TextView)localObject1;
        localObject1 = DBY;
        if (localObject1 == null) {
          break label647;
        }
        localObject1 = (TextView)((RelativeLayout)localObject1).findViewById(a.f.desc_tv);
        label402:
        DCa = (TextView)localObject1;
        localObject1 = DBY;
        if (localObject1 == null) {
          break label653;
        }
        localObject1 = (Button)((RelativeLayout)localObject1).findViewById(a.f.setting_bt);
        label430:
        DCb = (Button)localObject1;
        localObject1 = DBP;
        if (localObject1 == null) {
          break label659;
        }
      }
      label641:
      label647:
      label653:
      label659:
      for (localObject1 = (ViewStub)((View)localObject1).findViewById(a.f.update_dict_viewstub);; localObject1 = null)
      {
        DCc = (ViewStub)localObject1;
        View localView = DBP;
        localObject1 = localObject2;
        if (localView != null) {
          localObject1 = (Button)localView.findViewById(a.f.setting_bt);
        }
        DCe = (Button)localObject1;
        if (localObject1 != null) {
          ((Button)localObject1).setOnClickListener((View.OnClickListener)f.DCs);
        }
        long l3 = System.currentTimeMillis();
        eEd();
        Log.i("WxIme.ImeKeyboardSwitch", "initInputView async:" + bool + " startTime:" + l1 + " secondStage:" + l2 + " thirdStage:" + l3);
        AppMethodBeat.o(211282);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label91;
        label593:
        localObject1 = null;
        break label137;
        label599:
        localObject1 = null;
        break label165;
        label605:
        localObject1 = null;
        break label190;
        label611:
        localObject1 = null;
        break label218;
        label617:
        localObject1 = null;
        break label246;
        label623:
        localObject1 = null;
        break label274;
        label629:
        localObject1 = null;
        break label302;
        label635:
        localObject1 = null;
        break label351;
        localObject1 = null;
        break label374;
        localObject1 = null;
        break label402;
        localObject1 = null;
        break label430;
      }
      label665:
      bool = true;
    }
  }
  
  public static View eEa()
  {
    AppMethodBeat.i(211284);
    View localView2 = DBP;
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = new View(MMApplicationContext.getContext());
    }
    AppMethodBeat.o(211284);
    return localView1;
  }
  
  public static void eEb()
  {
    AppMethodBeat.i(211298);
    Object localObject = eEp();
    if (localObject != null) {
      ((Keyboard)localObject).b(Dup);
    }
    localObject = DBQ;
    if (localObject != null)
    {
      ((ImeCandidateView)localObject).getStrikeTv().setTextSize(0, com.tencent.mm.ci.a.aZ(((ImeCandidateView)localObject).getContext(), a.d.keyboard_strike_text_size));
      AppMethodBeat.o(211298);
      return;
    }
    AppMethodBeat.o(211298);
  }
  
  private static void eEc()
  {
    AppMethodBeat.i(211305);
    Object localObject = eEp();
    if (localObject != null)
    {
      FrameLayout localFrameLayout = DBW;
      if (localFrameLayout != null) {
        localFrameLayout.removeAllViews();
      }
      ((Keyboard)localObject).b(Dup);
      localFrameLayout = DBW;
      if (localFrameLayout != null) {
        localFrameLayout.addView((View)localObject);
      }
      localObject = DBW;
      if (localObject != null)
      {
        ((FrameLayout)localObject).setVisibility(0);
        AppMethodBeat.o(211305);
        return;
      }
      AppMethodBeat.o(211305);
      return;
    }
    AppMethodBeat.o(211305);
  }
  
  private static void eEd()
  {
    AppMethodBeat.i(211307);
    Object localObject1 = DBU;
    if (localObject1 != null) {
      ((FrameLayout)localObject1).removeAllViews();
    }
    localObject1 = eEp();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = DBU;
      if (localObject2 == null) {
        break label196;
      }
      ((FrameLayout)localObject2).addView((View)localObject1);
      localObject1 = x.aazN;
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
      int i = eEm();
      localObject2 = com.tencent.mm.plugin.hld.f.k.DHH;
      localObject1 = ((com.tencent.mm.plugin.hld.f.l)localObject1).aG(i, com.tencent.mm.plugin.hld.f.k.isLandscape());
      localObject2 = com.tencent.mm.plugin.hld.f.k.DHH;
      if ((com.tencent.mm.plugin.hld.f.k.isLandscape()) || (!u.agG((String)localObject1))) {
        break label201;
      }
    }
    label196:
    label201:
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
        localObject2 = DBU;
        if (localObject2 != null) {
          ((FrameLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        }
      }
      Log.i("WxIme.ImeKeyboardSwitch", "updateInputUpKeyboard ".concat(String.valueOf(bool)));
      localObject1 = x.aazN;
      AppMethodBeat.o(211307);
      return;
      localObject1 = null;
      break;
    }
  }
  
  private static void eEe()
  {
    AppMethodBeat.i(211308);
    Object localObject = DBS;
    if (localObject != null) {
      ((FrameLayout)localObject).removeAllViews();
    }
    localObject = eEp();
    if (localObject != null)
    {
      FrameLayout localFrameLayout = DBS;
      if (localFrameLayout != null)
      {
        localFrameLayout.addView((View)localObject);
        AppMethodBeat.o(211308);
        return;
      }
      AppMethodBeat.o(211308);
      return;
    }
    AppMethodBeat.o(211308);
  }
  
  private static void eEf()
  {
    AppMethodBeat.i(211309);
    Object localObject = DBV;
    if (localObject != null) {
      ((FrameLayout)localObject).removeAllViews();
    }
    localObject = eEp();
    if (localObject != null)
    {
      FrameLayout localFrameLayout = DBV;
      if (localFrameLayout != null)
      {
        localFrameLayout.addView((View)localObject);
        AppMethodBeat.o(211309);
        return;
      }
      AppMethodBeat.o(211309);
      return;
    }
    AppMethodBeat.o(211309);
  }
  
  public static int eEg()
  {
    AppMethodBeat.i(211313);
    Object localObject = DCk;
    if (localObject != null)
    {
      i = ((Integer)localObject).intValue();
      AppMethodBeat.o(211313);
      return i;
    }
    localObject = com.tencent.mm.plugin.hld.f.i.DHq;
    int i = com.tencent.mm.plugin.hld.f.i.eEm();
    AppMethodBeat.o(211313);
    return i;
  }
  
  public static boolean eEh()
  {
    AppMethodBeat.i(211315);
    if (eEg() == com.tencent.mm.plugin.hld.keyboard.c.Dyn.ordinal())
    {
      AppMethodBeat.o(211315);
      return true;
    }
    AppMethodBeat.o(211315);
    return false;
  }
  
  public static void eEi()
  {
    AppMethodBeat.i(211318);
    DCh = false;
    aa.f localf = new aa.f();
    Object localObject = mContext;
    String str;
    if (localObject != null)
    {
      localObject = ((Context)localObject).getResources();
      if (localObject != null)
      {
        str = ((Resources)localObject).getString(a.j.newline);
        localObject = str;
        if (str != null) {
          break label53;
        }
      }
    }
    localObject = "";
    label53:
    localf.aaBC = localObject;
    final aa.d locald = new aa.d();
    locald.aaBA = 2;
    if (((eEm() <= com.tencent.mm.plugin.hld.keyboard.c.Dym.ordinal()) || (eEm() == com.tencent.mm.plugin.hld.keyboard.c.Dyo.ordinal())) && (DBO == 2))
    {
      localObject = mContext;
      if (localObject != null)
      {
        localObject = ((Context)localObject).getResources();
        if (localObject != null)
        {
          str = ((Resources)localObject).getString(a.j.confirm);
          localObject = str;
          if (str != null) {
            break label139;
          }
        }
      }
      localObject = "";
      label139:
      localf.aaBC = localObject;
    }
    for (;;)
    {
      com.tencent.e.h.ZvG.bc((Runnable)new o(localf, locald));
      AppMethodBeat.o(211318);
      return;
      localObject = (d)com.tencent.mm.kernel.h.ae(d.class);
      if (localObject != null)
      {
        localObject = ((d)localObject).eCD();
        if (localObject == null) {}
      }
      for (int i = ((com.tencent.mm.plugin.hld.a.b)localObject).eCp();; i = 1) {
        switch (i & 0xFF)
        {
        case 6: 
        default: 
          break;
        case 2: 
          locald.aaBA = 3;
          localObject = mContext;
          if (localObject != null)
          {
            localObject = ((Context)localObject).getResources();
            if (localObject != null)
            {
              str = ((Resources)localObject).getString(a.j.key_action_go);
              localObject = str;
              if (str != null) {
                break label292;
              }
            }
          }
          localObject = "";
          label292:
          localf.aaBC = localObject;
          break;
        }
      }
      locald.aaBA = 3;
      localObject = mContext;
      if (localObject != null)
      {
        localObject = ((Context)localObject).getResources();
        if (localObject != null)
        {
          str = ((Resources)localObject).getString(a.j.key_action_search);
          localObject = str;
          if (str != null) {
            break label346;
          }
        }
      }
      localObject = "";
      label346:
      localf.aaBC = localObject;
      continue;
      localObject = com.tencent.mm.plugin.hld.f.l.DHK;
      if (com.tencent.mm.plugin.hld.f.l.eGY()) {}
      for (locald.aaBA = 1;; locald.aaBA = 3)
      {
        localObject = mContext;
        if (localObject != null)
        {
          localObject = ((Context)localObject).getResources();
          if (localObject != null)
          {
            str = ((Resources)localObject).getString(a.j.key_action_send);
            localObject = str;
            if (str != null) {
              break label405;
            }
          }
        }
        localObject = "";
        label405:
        localf.aaBC = localObject;
        DCh = true;
        break;
      }
      locald.aaBA = 3;
      localObject = mContext;
      if (localObject != null)
      {
        localObject = ((Context)localObject).getResources();
        if (localObject != null)
        {
          str = ((Resources)localObject).getString(a.j.key_action_next);
          localObject = str;
          if (str != null) {
            break label467;
          }
        }
      }
      localObject = "";
      label467:
      localf.aaBC = localObject;
      continue;
      locald.aaBA = 3;
      localObject = mContext;
      if (localObject != null)
      {
        localObject = ((Context)localObject).getResources();
        if (localObject != null)
        {
          str = ((Resources)localObject).getString(a.j.key_action_previous);
          localObject = str;
          if (str != null) {
            break label516;
          }
        }
      }
      localObject = "";
      label516:
      localf.aaBC = localObject;
    }
  }
  
  public static int eEj()
  {
    return DBO;
  }
  
  public static boolean eEk()
  {
    AppMethodBeat.i(211322);
    Keyboard localKeyboard = eEp();
    if (localKeyboard != null)
    {
      boolean bool = localKeyboard.eDJ();
      AppMethodBeat.o(211322);
      return bool;
    }
    AppMethodBeat.o(211322);
    return false;
  }
  
  public static ImeCandidateView eEl()
  {
    return DBQ;
  }
  
  public static int eEm()
  {
    AppMethodBeat.i(211324);
    try
    {
      Object localObject1 = DBN.getLast();
      p.j(localObject1, "mKeyboardTask.last");
      localObject1 = (Integer)localObject1;
      int i = ((Integer)localObject1).intValue();
      AppMethodBeat.o(211324);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = com.tencent.mm.plugin.hld.f.i.DHq;
        localObject2 = Integer.valueOf(com.tencent.mm.plugin.hld.f.i.eEm());
      }
    }
  }
  
  public static boolean eEn()
  {
    return DCj;
  }
  
  public static int eEo()
  {
    AppMethodBeat.i(211331);
    try
    {
      i = Math.max(DBN.size() - 2, 0);
      Object localObject = DBN.get(i);
      p.j(localObject, "mKeyboardTask[index]");
      i = ((Number)localObject).intValue();
      AppMethodBeat.o(211331);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.hld.f.i locali = com.tencent.mm.plugin.hld.f.i.DHq;
        int i = com.tencent.mm.plugin.hld.f.i.eEm();
      }
    }
  }
  
  public static Keyboard eEp()
  {
    AppMethodBeat.i(211332);
    Object localObject = DBM;
    if (localObject != null)
    {
      localObject = (Keyboard)((HashMap)localObject).get(Integer.valueOf(eEm()));
      AppMethodBeat.o(211332);
      return localObject;
    }
    AppMethodBeat.o(211332);
    return null;
  }
  
  private static void f(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(211288);
    int j = 1;
    HashMap localHashMap = DBM;
    int i = j;
    if (localHashMap != null)
    {
      i = j;
      if (localHashMap.get(Integer.valueOf(paramInt)) != null) {
        i = 0;
      }
    }
    if (i != 0) {
      a(paramContext, paramInt, Uw(paramInt), paramBoolean);
    }
    AppMethodBeat.o(211288);
  }
  
  public static void gP(Context paramContext)
  {
    AppMethodBeat.i(211280);
    p.k(paramContext, "context");
    if (DCl)
    {
      AppMethodBeat.o(211280);
      return;
    }
    DCl = true;
    com.tencent.e.h.ZvG.bc((Runnable)new l(paramContext));
    AppMethodBeat.o(211280);
  }
  
  private static boolean h(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211296);
    boolean bool = true;
    Object localObject1 = com.tencent.mm.ui.k.b.XIY;
    localObject1 = b.a.axo(paramInt2);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.ui.k.b)localObject1).hXh();
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = ad.kS(paramContext).inflate(paramInt2, null, false);
        bool = false;
      }
      if (localObject2 == null) {
        break label143;
      }
      localObject1 = (Keyboard)((View)localObject2).findViewById(a.f.root);
      label72:
      localObject2 = DBM;
      if (localObject2 != null)
      {
        localObject2 = (Map)localObject2;
        if (localObject1 != null) {
          break label149;
        }
      }
    }
    label143:
    label149:
    for (paramContext = (Keyboard)new S2ChineseQwertyKeyboard(paramContext);; paramContext = (Context)localObject1)
    {
      ((Map)localObject2).put(Integer.valueOf(paramInt1), paramContext);
      if (localObject1 != null) {
        ((Keyboard)localObject1).onCreate();
      }
      AppMethodBeat.o(211296);
      return bool;
      localObject1 = null;
      break;
      localObject1 = null;
      break label72;
    }
  }
  
  private static void p(Integer paramInteger)
  {
    AppMethodBeat.i(211329);
    if (paramInteger != null)
    {
      ((Number)paramInteger).intValue();
      if (paramInteger.intValue() <= com.tencent.mm.plugin.hld.keyboard.c.Dyn.ordinal())
      {
        if ((p.h(DCk, paramInteger) ^ true))
        {
          DCk = paramInteger;
          n.DEn.eEO();
        }
        DBN.clear();
      }
      if (DBN.contains(paramInteger))
      {
        int i = DBN.indexOf(paramInteger);
        while ((i + 1 < DBN.size()) && (i >= 0)) {
          DBN.removeLast();
        }
      }
      DBN.add(paramInteger);
      AppMethodBeat.o(211329);
      return;
    }
    AppMethodBeat.o(211329);
  }
  
  public static void reset()
  {
    DCi = false;
    DCl = false;
  }
  
  public final void Ux(final int paramInt)
  {
    AppMethodBeat.i(211304);
    if (DBM != null)
    {
      localObject1 = DBM;
      if (localObject1 == null) {
        p.iCn();
      }
      if (((HashMap)localObject1).get(Integer.valueOf(paramInt)) == null)
      {
        Log.e("WxIme.ImeKeyboardSwitch", "switchKeyboard " + paramInt + " is null..");
        AppMethodBeat.o(211304);
        return;
      }
    }
    final int i = eEm();
    Object localObject1 = DCk;
    if (paramInt == i)
    {
      Log.i("WxIme.ImeKeyboardSwitch", "switchKeyboard equal(" + i + ')');
      AppMethodBeat.o(211304);
      return;
    }
    Object localObject2 = f.DBL;
    f.eDS();
    localObject2 = new aa.a();
    boolean bool1;
    final aa.a locala;
    label188:
    label206:
    boolean bool2;
    label219:
    boolean bool3;
    if ((paramInt >= com.tencent.mm.plugin.hld.keyboard.c.Dys.ordinal()) && (paramInt > i))
    {
      bool1 = true;
      ((aa.a)localObject2).aaBx = bool1;
      locala = new aa.a();
      if ((i < com.tencent.mm.plugin.hld.keyboard.c.Dys.ordinal()) || (paramInt >= i)) {
        break label446;
      }
      bool1 = true;
      locala.aaBx = bool1;
      if (i != com.tencent.mm.plugin.hld.keyboard.c.Dyq.ordinal()) {
        break label451;
      }
      bool1 = true;
      if (paramInt != com.tencent.mm.plugin.hld.keyboard.c.Dyq.ordinal()) {
        break label456;
      }
      bool2 = true;
      if (paramInt >= com.tencent.mm.plugin.hld.keyboard.c.Dyq.ordinal()) {
        break label462;
      }
      bool3 = true;
      label232:
      if (paramInt != com.tencent.mm.plugin.hld.keyboard.c.Dyr.ordinal()) {
        break label468;
      }
    }
    label446:
    label451:
    label456:
    label462:
    label468:
    for (boolean bool4 = true;; bool4 = false)
    {
      p(Integer.valueOf(paramInt));
      if (paramInt <= com.tencent.mm.plugin.hld.keyboard.c.Dym.ordinal())
      {
        com.tencent.mm.plugin.hld.f.i locali = com.tencent.mm.plugin.hld.f.i.DHq;
        com.tencent.mm.plugin.hld.f.i.UJ(eEm());
      }
      Log.i("WxIme.ImeKeyboardSwitch", "switchKeyboard " + i + " to:" + paramInt + ' ' + ((aa.a)localObject2).aaBx + ' ' + locala.aaBx + ' ' + bool1 + ' ' + bool2 + ' ' + bool3 + ' ' + bool4 + ' ' + localObject1);
      a(((aa.a)localObject2).aaBx, locala.aaBx, bool1, bool2, bool3, bool4, (kotlin.g.a.a)new m((aa.a)localObject2, locala, paramInt, i), (kotlin.g.a.a)new n(i, paramInt, (aa.a)localObject2, locala));
      AppMethodBeat.o(211304);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label188;
      bool1 = false;
      break label206;
      bool2 = false;
      break label219;
      bool3 = false;
      break label232;
    }
  }
  
  public final void a(com.tencent.mm.plugin.hld.keyboard.c paramc)
  {
    AppMethodBeat.i(211302);
    p.k(paramc, "keyboard");
    Ux(paramc.ordinal());
    AppMethodBeat.o(211302);
  }
  
  public final void eDW()
  {
    AppMethodBeat.i(211272);
    Context localContext = MMApplicationContext.getContext();
    int j = eEm();
    Object localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
    boolean bool1 = com.tencent.mm.plugin.hld.f.l.eCE();
    localObject1 = new StringBuilder("updateCurrentKeyboard isSafetyMode:").append(bool1).append(" isLogin:");
    Object localObject2 = com.tencent.mm.plugin.hld.f.i.DHq;
    Log.i("WxIme.ImeKeyboardSwitch", com.tencent.mm.plugin.hld.f.i.biq());
    int i;
    if (bool1)
    {
      Uz(8);
      Uy(8);
      i = eDX();
      if (i != j)
      {
        p(Integer.valueOf(i));
        p.j(localContext, "context");
        f(localContext, i, false);
        if (i != com.tencent.mm.plugin.hld.keyboard.c.Dys.ordinal()) {
          break label474;
        }
        eEc();
      }
    }
    for (;;)
    {
      Log.i("WxIme.ImeKeyboardSwitch", "updateCurrentKeyboard " + i + ' ' + j);
      AppMethodBeat.o(211272);
      return;
      localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
      bool1 = com.tencent.mm.plugin.hld.f.l.eHk();
      localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
      boolean bool2 = com.tencent.mm.plugin.hld.f.l.eHn();
      localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
      boolean bool3 = com.tencent.mm.plugin.hld.f.l.eHq();
      localObject1 = e.DGW;
      localObject1 = (d)com.tencent.mm.kernel.h.ae(d.class);
      if (localObject1 != null)
      {
        localObject1 = Boolean.valueOf(((d)localObject1).eCC());
        label227:
        localObject2 = com.tencent.mm.plugin.hld.f.i.DHq;
        if (!com.tencent.mm.plugin.hld.f.i.biq()) {
          break label406;
        }
        if ((bool1) && (bool2)) {
          break label357;
        }
        Uy(8);
        Uz(0);
        localObject2 = k.DDb;
        k.hL(11, 7);
        i = 1;
        label270:
        if ((i != 0) || (bool3)) {
          break label399;
        }
      }
      label399:
      for (i = com.tencent.mm.plugin.hld.keyboard.c.Dys.ordinal();; i = eDX())
      {
        Log.i("WxIme.ImeKeyboardSwitch", "updateCurrentKeyboard first:" + bool1 + " second:" + bool2 + " fifth:" + bool3 + " finishFirstFetch:" + localObject1 + " cloudConfig:true");
        break;
        localObject1 = null;
        break label227;
        label357:
        if ((p.h(localObject1, Boolean.TRUE) ^ true))
        {
          Uy(0);
          Uz(8);
          i = 1;
          break label270;
        }
        Uz(8);
        Uy(8);
        i = 0;
        break label270;
      }
      label406:
      if ((!bool1) || (!bool2) || (!bool3))
      {
        Uy(8);
        Uz(0);
      }
      for (;;)
      {
        i = eDX();
        break;
        if ((p.h(localObject1, Boolean.TRUE) ^ true))
        {
          Uy(0);
          Uz(8);
        }
        else
        {
          Uz(8);
          Uy(8);
        }
      }
      label474:
      a(false, false, false, false, true, false, (kotlin.g.a.a)p.DCJ, (kotlin.g.a.a)q.DCK);
    }
  }
  
  public final void eDY()
  {
    AppMethodBeat.i(211274);
    Object localObject = com.tencent.mm.plugin.hld.f.i.DHq;
    int i = com.tencent.mm.plugin.hld.f.i.eEm();
    Log.i("WxIme.ImeKeyboardSwitch", "resetToFirstLevelKeyboard ".concat(String.valueOf(i)));
    localObject = eEp();
    if (localObject != null) {
      ((Keyboard)localObject).onReset();
    }
    if (eEm() == i)
    {
      UA(eEm());
      localObject = DBT;
      if (localObject != null)
      {
        ((View)localObject).setAlpha(1.0F);
        ((View)localObject).setVisibility(0);
      }
      for (;;)
      {
        localObject = DBU;
        if (localObject != null) {
          ((FrameLayout)localObject).setVisibility(0);
        }
        localObject = DBU;
        if (localObject != null) {
          ((FrameLayout)localObject).setTranslationY(0.0F);
        }
        Log.i("WxIme.ImeKeyboardSwitch", "resetToFirstLevelKeyboard reset keyboard");
        AppMethodBeat.o(211274);
        return;
        Log.e("WxIme.ImeKeyboardSwitch", "resetToFirstLevelKeyboard mInputCenterView is null");
      }
    }
    p(Integer.valueOf(i));
    if (eEp() == null)
    {
      localObject = mContext;
      if (localObject == null) {
        break label189;
      }
      f((Context)localObject, eEm(), false);
    }
    for (;;)
    {
      DBO = 1;
      a(false, false, true, false, true, false, (kotlin.g.a.a)i.DCA, (kotlin.g.a.a)j.DCB);
      AppMethodBeat.o(211274);
      return;
      label189:
      Log.e("WxIme.ImeKeyboardSwitch", "resetToFirstLevelKeyboard current:" + eEm() + ", mContext is null");
    }
  }
  
  public final void gN(Context paramContext)
  {
    AppMethodBeat.i(211276);
    p.k(paramContext, "context");
    Log.i("WxIme.ImeKeyboardSwitch", "preInitKeyboards");
    a(paramContext, eEm(), true, "WxIme.ImeKeyboardSwitch");
    new com.tencent.mm.ui.k.b(paramContext).jdMethod_do(a.h.ime_input_view, null);
    a(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Dyl.ordinal(), false, "WxIme.ImeKeyboardSwitch");
    a(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Dym.ordinal(), false, "WxIme.ImeKeyboardSwitch");
    a(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Dyn.ordinal(), false, "WxIme.ImeKeyboardSwitch");
    a(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Dyo.ordinal(), false, "WxIme.ImeKeyboardSwitch");
    a(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Dyp.ordinal(), false, "WxIme.ImeKeyboardSwitch");
    a(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Dyq.ordinal(), false, "WxIme.ImeKeyboardSwitch");
    a(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Dys.ordinal(), false, "WxIme.ImeKeyboardSwitch");
    a(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Dyt.ordinal(), false, "WxIme.ImeKeyboardSwitch");
    a(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Dyu.ordinal(), false, "WxIme.ImeKeyboardSwitch");
    AppMethodBeat.o(211276);
  }
  
  public final void gO(Context paramContext)
  {
    AppMethodBeat.i(211278);
    p.k(paramContext, "context");
    if (DCi)
    {
      AppMethodBeat.o(211278);
      return;
    }
    DCi = true;
    DBM = new HashMap();
    av(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Dyl.ordinal());
    av(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Dym.ordinal());
    av(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Dyn.ordinal());
    av(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Dyo.ordinal());
    av(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Dyp.ordinal());
    av(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Dyq.ordinal());
    av(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Dys.ordinal());
    av(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Dyt.ordinal());
    av(paramContext, com.tencent.mm.plugin.hld.keyboard.c.Dyu.ordinal());
    eDZ();
    AppMethodBeat.o(211278);
  }
  
  public final void sQ(boolean paramBoolean)
  {
    AppMethodBeat.i(211323);
    if (paramBoolean)
    {
      localObject = com.tencent.mm.plugin.hld.f.i.DHq;
      Ux(com.tencent.mm.plugin.hld.f.i.eEm());
      AppMethodBeat.o(211323);
      return;
    }
    Object localObject = k.DDb;
    k.ap(0, 1, 0);
    a(com.tencent.mm.plugin.hld.keyboard.c.Dyu);
    AppMethodBeat.o(211323);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    public static final a DCn;
    
    static
    {
      AppMethodBeat.i(209822);
      DCn = new a();
      AppMethodBeat.o(209822);
    }
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(209820);
      Object localObject;
      if (paramValueAnimator != null)
      {
        paramValueAnimator = paramValueAnimator.getAnimatedValue();
        localObject = paramValueAnimator;
        if (!(paramValueAnimator instanceof Float)) {
          localObject = null;
        }
        paramValueAnimator = (Float)localObject;
        if (paramValueAnimator == null) {
          break label84;
        }
      }
      label84:
      for (float f = paramValueAnimator.floatValue();; f = 0.0F)
      {
        paramValueAnimator = g.DCm;
        paramValueAnimator = g.eEv();
        if (paramValueAnimator == null) {
          break label89;
        }
        localObject = com.tencent.mm.plugin.hld.f.k.DHH;
        localObject = g.DCm;
        paramValueAnimator.setAlpha(1.0F - f / com.tencent.mm.plugin.hld.f.k.gW(g.eEw()));
        AppMethodBeat.o(209820);
        return;
        paramValueAnimator = null;
        break;
      }
      label89:
      AppMethodBeat.o(209820);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/model/ImeKeyboardSwitch$getBelowAnimator$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-hld_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    b(kotlin.g.a.a parama1, kotlin.g.a.a parama2) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(215752);
      p.k(paramAnimator, "animation");
      Log.w("WxIme.ImeKeyboardSwitch", "animator_move_to_below onAnimationCancel");
      paramAnimator = g.DCm;
      paramAnimator = g.eEu();
      if (paramAnimator != null)
      {
        paramAnimator.setVisibility(8);
        AppMethodBeat.o(215752);
        return;
      }
      AppMethodBeat.o(215752);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(215750);
      p.k(paramAnimator, "animation");
      Log.w("WxIme.ImeKeyboardSwitch", "animator_move_to_below onAnimationEnd");
      paramAnimator = g.DCm;
      paramAnimator = g.eEu();
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      paramAnimator = parama2;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      paramAnimator = g.DCm;
      paramAnimator = g.eEv();
      if (paramAnimator != null)
      {
        paramAnimator.setAlpha(0.0F);
        paramAnimator.setVisibility(8);
        Object localObject = com.tencent.mm.plugin.hld.f.k.DHH;
        localObject = g.DCm;
        paramAnimator.setTranslationY(com.tencent.mm.plugin.hld.f.k.gW(g.eEw()));
        AppMethodBeat.o(215750);
        return;
      }
      Log.e("WxIme.ImeKeyboardSwitch", "getBelowAnimator mInputCenterView is null");
      AppMethodBeat.o(215750);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(215753);
      p.k(paramAnimator, "animation");
      AppMethodBeat.o(215753);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(215748);
      p.k(paramAnimator, "animation");
      Log.w("WxIme.ImeKeyboardSwitch", "animator_move_to_below onAnimationStart");
      paramAnimator = this.DCo;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      paramAnimator = g.DCm;
      paramAnimator = g.eEu();
      if (paramAnimator != null) {
        paramAnimator.setVisibility(0);
      }
      paramAnimator = g.DCm;
      paramAnimator = g.eEv();
      if (paramAnimator != null)
      {
        paramAnimator.setVisibility(0);
        AppMethodBeat.o(215748);
        return;
      }
      Log.e("WxIme.ImeKeyboardSwitch", "getBelowAnimator mInputCenterView is null");
      AppMethodBeat.o(215748);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    public static final c DCq;
    
    static
    {
      AppMethodBeat.i(215955);
      DCq = new c();
      AppMethodBeat.o(215955);
    }
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(215953);
      Object localObject;
      if (paramValueAnimator != null)
      {
        paramValueAnimator = paramValueAnimator.getAnimatedValue();
        localObject = paramValueAnimator;
        if (!(paramValueAnimator instanceof Float)) {
          localObject = null;
        }
        paramValueAnimator = (Float)localObject;
        if (paramValueAnimator == null) {
          break label84;
        }
      }
      label84:
      for (float f = paramValueAnimator.floatValue();; f = 0.0F)
      {
        paramValueAnimator = g.DCm;
        paramValueAnimator = g.eEv();
        if (paramValueAnimator == null) {
          break label89;
        }
        localObject = com.tencent.mm.plugin.hld.f.k.DHH;
        localObject = g.DCm;
        paramValueAnimator.setAlpha(1.0F - f / com.tencent.mm.plugin.hld.f.k.gW(g.eEw()));
        AppMethodBeat.o(215953);
        return;
        paramValueAnimator = null;
        break;
      }
      label89:
      AppMethodBeat.o(215953);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/model/ImeKeyboardSwitch$getUpAnimator$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-hld_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    d(kotlin.g.a.a parama1, kotlin.g.a.a parama2) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(217141);
      p.k(paramAnimator, "animation");
      Log.w("WxIme.ImeKeyboardSwitch", "animator_move_to_up onAnimationCancel");
      AppMethodBeat.o(217141);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(217140);
      p.k(paramAnimator, "animation");
      Log.i("WxIme.ImeKeyboardSwitch", "animator_move_to_up onAnimationEnd");
      paramAnimator = parama2;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      paramAnimator = g.DCm;
      paramAnimator = g.eEv();
      if (paramAnimator != null)
      {
        paramAnimator.setAlpha(1.0F);
        paramAnimator.setVisibility(8);
        paramAnimator.setTranslationY(0.0F);
        AppMethodBeat.o(217140);
        return;
      }
      Log.e("WxIme.ImeKeyboardSwitch", "getUpAnimator mInputCenterView is null");
      AppMethodBeat.o(217140);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(217143);
      p.k(paramAnimator, "animation");
      AppMethodBeat.o(217143);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(217139);
      p.k(paramAnimator, "animation");
      Log.i("WxIme.ImeKeyboardSwitch", "animator_move_to_up onAnimationStart");
      paramAnimator = this.DCo;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      paramAnimator = g.DCm;
      paramAnimator = g.eEu();
      if (paramAnimator != null) {
        paramAnimator.setVisibility(0);
      }
      paramAnimator = g.DCm;
      paramAnimator = g.eEv();
      if (paramAnimator != null)
      {
        paramAnimator.setVisibility(0);
        AppMethodBeat.o(217139);
        return;
      }
      Log.e("WxIme.ImeKeyboardSwitch", "getUpAnimator mInputCenterView is null");
      AppMethodBeat.o(217139);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class e
    implements View.OnTouchListener
  {
    public static final e DCr;
    
    static
    {
      AppMethodBeat.i(211971);
      DCr = new e();
      AppMethodBeat.o(211971);
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    public static final f DCs;
    
    static
    {
      AppMethodBeat.i(211111);
      DCs = new f();
      AppMethodBeat.o(211111);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(211110);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/model/ImeKeyboardSwitch$initInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = g.DCm;
      g.eEs();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/model/ImeKeyboardSwitch$initInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211110);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(int paramInt1, Context paramContext, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(214068);
      long l = System.currentTimeMillis();
      final aa.f localf = new aa.f();
      Object localObject = com.tencent.mm.ui.k.b.XIY;
      localObject = b.a.axo(this.DCt);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.ui.k.b)localObject).hXh();
        localf.aaBC = localObject;
        if ((View)localf.aaBC != null) {
          break label165;
        }
        localf.aaBC = ad.kS(paramContext).inflate(this.DCt, null, false);
      }
      label165:
      for (boolean bool = false;; bool = true)
      {
        Log.i("WxIme.ImeKeyboardSwitch", "initKeyboardImp load " + paramInt1 + ' ' + (System.currentTimeMillis() - l) + ' ' + bool);
        com.tencent.e.h.ZvG.bc((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(210960);
            long l = System.currentTimeMillis();
            Object localObject1 = (View)localf.aaBC;
            Object localObject3;
            int i;
            if (localObject1 != null)
            {
              localObject1 = (Keyboard)((View)localObject1).findViewById(a.f.root);
              localObject2 = g.DCm;
              localObject2 = g.eEt();
              if (localObject2 != null)
              {
                localObject3 = (Map)localObject2;
                i = this.DCv.DCu;
                if (localObject1 != null) {
                  break label283;
                }
              }
            }
            label283:
            for (Object localObject2 = (Keyboard)new S2ChineseQwertyKeyboard(this.DCv.$context);; localObject2 = localObject1)
            {
              ((Map)localObject3).put(Integer.valueOf(i), localObject2);
              if (localObject1 != null) {
                ((Keyboard)localObject1).onCreate();
              }
              localObject2 = new StringBuilder("initKeyboardImp push to cache ").append(this.DCv.DCu).append(' ').append(System.currentTimeMillis() - l).append(' ');
              localObject3 = g.DCm;
              Log.i("WxIme.ImeKeyboardSwitch", g.eEm());
              if (localObject1 != null)
              {
                localObject2 = g.DCm;
                if (g.eEm() == this.DCv.DCu)
                {
                  localObject2 = g.DCm;
                  ((Keyboard)localObject1).b(g.eEr());
                  localObject2 = g.DCm;
                  localObject2 = g.eEu();
                  if (localObject2 != null) {
                    ((FrameLayout)localObject2).addView((View)localObject1);
                  }
                  Log.i("WxIme.ImeKeyboardSwitch", "initKeyboardImp refresh " + this.DCv.DCu);
                }
                AppMethodBeat.o(210960);
                return;
                localObject1 = null;
                break;
              }
              AppMethodBeat.o(210960);
              return;
            }
          }
        });
        AppMethodBeat.o(214068);
        return;
        localObject = null;
        break;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/model/ImeKeyboardSwitch$leftSlideInputLeftKeyboard$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-hld_release"})
  public static final class h
    implements Animator.AnimatorListener
  {
    h(FrameLayout paramFrameLayout, kotlin.g.a.a parama1, kotlin.g.a.a parama2) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(210159);
      p.k(paramAnimator, "animation");
      AppMethodBeat.o(210159);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(210158);
      p.k(paramAnimator, "animation");
      paramAnimator = parama2;
      if (paramAnimator != null)
      {
        paramAnimator.invoke();
        AppMethodBeat.o(210158);
        return;
      }
      AppMethodBeat.o(210158);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(210160);
      p.k(paramAnimator, "animation");
      AppMethodBeat.o(210160);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(210155);
      p.k(paramAnimator, "animation");
      paramAnimator = parama1;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      paramAnimator = this.DCx;
      if (paramAnimator != null)
      {
        paramAnimator.setVisibility(0);
        AppMethodBeat.o(210155);
        return;
      }
      AppMethodBeat.o(210155);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final i DCA;
    
    static
    {
      AppMethodBeat.i(214386);
      DCA = new i();
      AppMethodBeat.o(214386);
    }
    
    i()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final j DCB;
    
    static
    {
      AppMethodBeat.i(210447);
      DCB = new j();
      AppMethodBeat.o(210447);
    }
    
    j()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/model/ImeKeyboardSwitch$rightSlideInputLeftKeyboard$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-hld_release"})
  public static final class k
    implements Animator.AnimatorListener
  {
    k(FrameLayout paramFrameLayout, kotlin.g.a.a parama1, kotlin.g.a.a parama2) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(213478);
      p.k(paramAnimator, "animation");
      AppMethodBeat.o(213478);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(213477);
      p.k(paramAnimator, "animation");
      paramAnimator = this.DCC;
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      paramAnimator = parama2;
      if (paramAnimator != null)
      {
        paramAnimator.invoke();
        AppMethodBeat.o(213477);
        return;
      }
      AppMethodBeat.o(213477);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(213479);
      p.k(paramAnimator, "animation");
      AppMethodBeat.o(213479);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(213476);
      p.k(paramAnimator, "animation");
      paramAnimator = parama1;
      if (paramAnimator != null)
      {
        paramAnimator.invoke();
        AppMethodBeat.o(213476);
        return;
      }
      AppMethodBeat.o(213476);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(Context paramContext) {}
    
    public final void run()
    {
      AppMethodBeat.i(216606);
      g localg = g.DCm;
      g.aw(this.$context, com.tencent.mm.plugin.hld.keyboard.c.Dyl.ordinal());
      localg = g.DCm;
      g.aw(this.$context, com.tencent.mm.plugin.hld.keyboard.c.Dym.ordinal());
      localg = g.DCm;
      g.aw(this.$context, com.tencent.mm.plugin.hld.keyboard.c.Dyn.ordinal());
      localg = g.DCm;
      g.aw(this.$context, com.tencent.mm.plugin.hld.keyboard.c.Dyo.ordinal());
      localg = g.DCm;
      g.aw(this.$context, com.tencent.mm.plugin.hld.keyboard.c.Dyp.ordinal());
      localg = g.DCm;
      g.aw(this.$context, com.tencent.mm.plugin.hld.keyboard.c.Dyq.ordinal());
      localg = g.DCm;
      g.aw(this.$context, com.tencent.mm.plugin.hld.keyboard.c.Dys.ordinal());
      localg = g.DCm;
      g.aw(this.$context, com.tencent.mm.plugin.hld.keyboard.c.Dyt.ordinal());
      localg = g.DCm;
      g.aw(this.$context, com.tencent.mm.plugin.hld.keyboard.c.Dyu.ordinal());
      AppMethodBeat.o(216606);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<x>
  {
    m(aa.a parama1, aa.a parama2, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<x>
  {
    n(int paramInt1, int paramInt2, aa.a parama1, aa.a parama2)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(aa.f paramf, aa.d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(210806);
      Object localObject = g.DCm;
      localObject = g.eEq();
      if (localObject != null)
      {
        ((Keyboard)localObject).eO((String)this.DCH.aaBC, locald.aaBA);
        AppMethodBeat.o(210806);
        return;
      }
      AppMethodBeat.o(210806);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final p DCJ;
    
    static
    {
      AppMethodBeat.i(209805);
      DCJ = new p();
      AppMethodBeat.o(209805);
    }
    
    p()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final q DCK;
    
    static
    {
      AppMethodBeat.i(215676);
      DCK = new q();
      AppMethodBeat.o(215676);
    }
    
    q()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/hld/model/ImeKeyboardSwitch$viewSaveToImage$1$1$1", "com/tencent/mm/plugin/hld/model/ImeKeyboardSwitch$$special$$inlined$let$lambda$1"})
  static final class r
    implements Runnable
  {
    r(Keyboard paramKeyboard, boolean paramBoolean, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(213931);
      if (this.DCL.getKeyboardType().ordinal() <= com.tencent.mm.plugin.hld.keyboard.c.Dyo.ordinal())
      {
        Object localObject = com.tencent.mm.plugin.hld.f.k.DHH;
        localObject = this.DCL;
        p.j(localObject, "keyboard");
        com.tencent.mm.plugin.hld.f.k.a((View)localObject, paramInt, bool, (k.a)new k.a()
        {
          public final void dL(String paramAnonymousString)
          {
            AppMethodBeat.i(210020);
            Log.i("WxIme.ImeKeyboardSwitch", "onFailure " + this.DCO.DCN + ' ' + paramAnonymousString);
            AppMethodBeat.o(210020);
          }
          
          public final void onFinish()
          {
            AppMethodBeat.i(210021);
            Log.i("WxIme.ImeKeyboardSwitch", "onFinish " + this.DCO.DCN);
            AppMethodBeat.o(210021);
          }
          
          public final void onStart()
          {
            AppMethodBeat.i(210018);
            Log.i("WxIme.ImeKeyboardSwitch", "onStart " + this.DCO.DCN);
            AppMethodBeat.o(210018);
          }
          
          public final void onSucceed(String paramAnonymousString)
          {
            AppMethodBeat.i(210019);
            Log.i("WxIme.ImeKeyboardSwitch", "onSucceed " + this.DCO.DCN + ' ' + paramAnonymousString);
            AppMethodBeat.o(210019);
          }
        });
      }
      AppMethodBeat.o(213931);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.g
 * JD-Core Version:    0.7.0.1
 */