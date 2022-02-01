package com.tencent.mm.plugin.hld.f;

import android.content.Context;
import android.content.res.AssetManager;
import android.media.AudioAttributes.Builder;
import android.media.SoundPool;
import android.media.SoundPool.Builder;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.keyboard.c;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.b;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/utils/WxImeSettingUtil;", "", "()V", "TAG", "", "clickSoundIDs", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "currentKeyboardMode", "", "Ljava/lang/Boolean;", "currentKeyboardOrdinal", "Ljava/lang/Integer;", "isLogin", "mClickSoundPool", "Landroid/media/SoundPool;", "getCurrentKeyboardOrdinal", "getIMESetting", "isOpenKeySound", "isOpenKeyVibrate", "isSafetyKeyboardMode", "isSettingKeyVoice", "isSettingKeyboardOpen", "isSettingTNine", "performClick", "", "v", "Landroid/view/View;", "type", "btn", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "context", "Landroid/content/Context;", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "performClickSound", "performClickVibrate", "playSound", "pathId", "stream", "releaseClickSoundPool", "resetLogicStatus", "resetSetting", "saveCurrentKeyboard", "currentId", "saveCurrentKeyboardMode", "safety", "saveIMESetting", "imeSetting", "saveKeySoundStatus", "open", "saveKeyVibrateStatus", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i JyA;
  private static Integer JyB;
  private static Boolean JyC;
  private static SoundPool JyD;
  private static final HashMap<Integer, Integer> JyE;
  public static final String TAG;
  private static boolean isLogin;
  
  static
  {
    AppMethodBeat.i(311678);
    JyA = new i();
    TAG = "WxIme.WxImeSettingUtil";
    l locall = l.JyV;
    isLogin = l.bGa();
    JyE = new HashMap();
    AppMethodBeat.o(311678);
  }
  
  public static void YH(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(311556);
    Log.i(TAG, s.X("saveCurrentKeyboard ", Integer.valueOf(paramInt)));
    JyB = Integer.valueOf(paramInt);
    Object localObject1 = l.JyV;
    localObject1 = l.fPk();
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 == null) {
        Log.e(TAG, "saveCurrentKeyboard getUserKV null");
      }
      localObject1 = l.JyV;
      localObject1 = l.fPl();
      if (localObject1 != null) {
        break label98;
      }
    }
    label98:
    for (localObject1 = localObject2;; localObject1 = ((MultiProcessMMKV)localObject1).putInt("ime_current_keyboard", paramInt))
    {
      if (localObject1 == null) {
        Log.e(TAG, "saveCurrentKeyboard getInvalidUserKV null");
      }
      AppMethodBeat.o(311556);
      return;
      localObject1 = ((MultiProcessMMKV)localObject1).putInt("ime_current_keyboard", paramInt);
      break;
    }
  }
  
  private static final void a(int paramInt1, SoundPool paramSoundPool, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(311669);
    if (paramInt3 == 0)
    {
      ((Map)JyE).put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      paramSoundPool = JyD;
      if (paramSoundPool != null)
      {
        paramSoundPool.play(paramInt2, 1.0F, 1.0F, 0, 0, 1.0F);
        AppMethodBeat.o(311669);
      }
    }
    else
    {
      Log.e(TAG, "SoundPool load error pathId " + paramInt1 + " status " + paramInt3);
    }
    AppMethodBeat.o(311669);
  }
  
  public static void a(b paramb, Context paramContext)
  {
    AppMethodBeat.i(311604);
    s.u(paramContext, "context");
    if (paramb != null)
    {
      if (((paramb.type & 0x2) == 2) && (paramb.JsU == 2))
      {
        aK(paramContext, 3);
        AppMethodBeat.o(311604);
        return;
      }
      aK(paramContext, 1);
    }
    AppMethodBeat.o(311604);
  }
  
  public static void aC(View paramView, int paramInt)
  {
    AppMethodBeat.i(311612);
    if (paramView != null)
    {
      paramView = paramView.getContext();
      if (paramView != null) {
        aK(paramView, paramInt);
      }
    }
    AppMethodBeat.o(311612);
  }
  
  private static void aK(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(311652);
    if (fOp()) {
      switch (paramInt)
      {
      default: 
        paramInt = a.j.key_sound1;
      }
    }
    for (;;)
    {
      aL(paramContext, paramInt);
      AppMethodBeat.o(311652);
      return;
      paramInt = a.j.key_sound2;
      continue;
      paramInt = a.j.key_sound3;
    }
  }
  
  private static void aL(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(311663);
    Object localObject = paramContext.getString(paramInt);
    s.s(localObject, "context.getString(pathId)");
    Log.d(TAG, "play start path:" + (String)localObject + " context:" + paramContext + " pathId:" + paramInt + " loaded " + JyE.containsKey(Integer.valueOf(paramInt)));
    if (JyD == null) {
      JyD = new SoundPool.Builder().setMaxStreams(10).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(1).build()).build();
    }
    if (JyE.containsKey(Integer.valueOf(paramInt)))
    {
      paramContext = JyD;
      if (paramContext != null)
      {
        localObject = JyE.get(Integer.valueOf(paramInt));
        s.checkNotNull(localObject);
        s.s(localObject, "clickSoundIDs[pathId]!!");
        paramContext.play(((Number)localObject).intValue(), 1.0F, 1.0F, 0, 0, 1.0F);
        AppMethodBeat.o(311663);
      }
    }
    else
    {
      localObject = JyD;
      if (localObject != null) {
        ((SoundPool)localObject).load(paramContext.getAssets().openFd(paramContext.getString(paramInt)), 1);
      }
      paramContext = JyD;
      if (paramContext != null) {
        paramContext.setOnLoadCompleteListener(new i..ExternalSyntheticLambda0(paramInt));
      }
    }
    AppMethodBeat.o(311663);
  }
  
  public static boolean bGa()
  {
    return isLogin;
  }
  
  public static void d(ImeKeyRelativeLayout paramImeKeyRelativeLayout)
  {
    AppMethodBeat.i(311595);
    if (paramImeKeyRelativeLayout != null)
    {
      if (((paramImeKeyRelativeLayout.getType() & 0x2) == 2) && (paramImeKeyRelativeLayout.getFunctionCode() == 2))
      {
        aC((View)paramImeKeyRelativeLayout, 3);
        AppMethodBeat.o(311595);
        return;
      }
      aC((View)paramImeKeyRelativeLayout, 1);
    }
    AppMethodBeat.o(311595);
  }
  
  public static int fMo()
  {
    AppMethodBeat.i(311566);
    Object localObject = l.JyV;
    int i;
    if (l.fKH())
    {
      i = c.Jrq.ordinal();
      AppMethodBeat.o(311566);
      return i;
    }
    if (JyB == null)
    {
      i = c.Jrq.ordinal();
      if (!isLogin) {
        break label103;
      }
      localObject = l.JyV;
      localObject = l.fPk();
      if (localObject != null) {
        break label92;
      }
    }
    for (;;)
    {
      localObject = Integer.valueOf(i);
      JyB = (Integer)localObject;
      localObject = JyB;
      s.checkNotNull(localObject);
      i = ((Integer)localObject).intValue();
      AppMethodBeat.o(311566);
      return i;
      label92:
      i = ((MultiProcessMMKV)localObject).getInt("ime_current_keyboard", i);
    }
    label103:
    localObject = l.JyV;
    localObject = l.fPl();
    if (localObject == null) {}
    for (;;)
    {
      localObject = Integer.valueOf(i);
      break;
      i = ((MultiProcessMMKV)localObject).getInt("ime_current_keyboard", i);
    }
  }
  
  public static boolean fOo()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(311547);
    if (JyC == null)
    {
      if (!isLogin) {
        break label76;
      }
      localObject = l.JyV;
      localObject = l.fPk();
      if (localObject != null) {
        break label64;
      }
    }
    for (;;)
    {
      localObject = Boolean.valueOf(bool1);
      JyC = (Boolean)localObject;
      localObject = JyC;
      s.checkNotNull(localObject);
      bool1 = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(311547);
      return bool1;
      label64:
      bool1 = ((MultiProcessMMKV)localObject).getBoolean("ime_current_mode", true);
    }
    label76:
    Object localObject = l.JyV;
    localObject = l.fPl();
    if (localObject == null) {}
    for (bool1 = bool2;; bool1 = ((MultiProcessMMKV)localObject).getBoolean("ime_current_mode", true))
    {
      localObject = Boolean.valueOf(bool1);
      break;
    }
  }
  
  public static boolean fOp()
  {
    AppMethodBeat.i(311581);
    if (isLogin)
    {
      localObject = l.JyV;
      localObject = l.fPk();
      if (localObject == null)
      {
        AppMethodBeat.o(311581);
        return false;
      }
      bool = ((MultiProcessMMKV)localObject).getBoolean("ime_key_sound_status", false);
      AppMethodBeat.o(311581);
      return bool;
    }
    Object localObject = l.JyV;
    localObject = l.fPl();
    if (localObject == null)
    {
      AppMethodBeat.o(311581);
      return false;
    }
    boolean bool = ((MultiProcessMMKV)localObject).getBoolean("ime_key_sound_status", false);
    AppMethodBeat.o(311581);
    return bool;
  }
  
  public static boolean fOq()
  {
    AppMethodBeat.i(311588);
    if (isLogin)
    {
      localObject = l.JyV;
      localObject = l.fPk();
      if (localObject == null)
      {
        AppMethodBeat.o(311588);
        return true;
      }
      bool = ((MultiProcessMMKV)localObject).getBoolean("ime_key_vibrate_status", true);
      AppMethodBeat.o(311588);
      return bool;
    }
    Object localObject = l.JyV;
    localObject = l.fPl();
    if (localObject == null)
    {
      AppMethodBeat.o(311588);
      return true;
    }
    boolean bool = ((MultiProcessMMKV)localObject).getBoolean("ime_key_vibrate_status", true);
    AppMethodBeat.o(311588);
    return bool;
  }
  
  public static void fOr()
  {
    AppMethodBeat.i(311631);
    l locall = l.JyV;
    isLogin = l.bGa();
    AppMethodBeat.o(311631);
  }
  
  public static int fOs()
  {
    AppMethodBeat.i(311637);
    Object localObject = l.JyV;
    localObject = l.fPk();
    if (localObject == null)
    {
      AppMethodBeat.o(311637);
      return 0;
    }
    int i = ((MultiProcessMMKV)localObject).getInt("ime_setting", 0);
    AppMethodBeat.o(311637);
    return i;
  }
  
  public static void fOt()
  {
    JyB = null;
    JyC = null;
  }
  
  public static void xo(boolean paramBoolean)
  {
    AppMethodBeat.i(311541);
    Log.i(TAG, s.X("saveCurrentKeyboardMode ", Boolean.valueOf(paramBoolean)));
    JyC = Boolean.valueOf(paramBoolean);
    Object localObject = l.JyV;
    localObject = l.fPk();
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).putBoolean("ime_current_mode", paramBoolean);
    }
    localObject = l.JyV;
    localObject = l.fPl();
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).putBoolean("ime_current_mode", paramBoolean);
    }
    AppMethodBeat.o(311541);
  }
  
  public static void xp(boolean paramBoolean)
  {
    AppMethodBeat.i(311575);
    Log.i(TAG, s.X("saveKeySoundStatus ", Boolean.valueOf(paramBoolean)));
    Object localObject = l.JyV;
    localObject = l.fPk();
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).putBoolean("ime_key_sound_status", paramBoolean);
    }
    localObject = l.JyV;
    localObject = l.fPl();
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).putBoolean("ime_key_sound_status", paramBoolean);
    }
    if (!paramBoolean)
    {
      localObject = JyD;
      if (localObject != null) {
        ((SoundPool)localObject).release();
      }
      JyD = null;
      JyE.clear();
    }
    AppMethodBeat.o(311575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.f.i
 * JD-Core Version:    0.7.0.1
 */