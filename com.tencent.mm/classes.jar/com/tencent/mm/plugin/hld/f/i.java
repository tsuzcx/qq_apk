package com.tencent.mm.plugin.hld.f;

import android.content.Context;
import android.content.res.AssetManager;
import android.media.AudioAttributes.Builder;
import android.media.SoundPool;
import android.media.SoundPool.Builder;
import android.media.SoundPool.OnLoadCompleteListener;
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
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/utils/WxImeSettingUtil;", "", "()V", "TAG", "", "clickSoundIDs", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "currentKeyboardMode", "", "Ljava/lang/Boolean;", "currentKeyboardOrdinal", "Ljava/lang/Integer;", "isLogin", "mClickSoundPool", "Landroid/media/SoundPool;", "getCurrentKeyboardOrdinal", "getIMESetting", "isOpenKeySound", "isOpenKeyVibrate", "isSafetyKeyboardMode", "isSettingKeyVoice", "isSettingKeyboardOpen", "isSettingTNine", "performClick", "", "v", "Landroid/view/View;", "type", "btn", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "context", "Landroid/content/Context;", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "performClickSound", "performClickVibrate", "playSound", "pathId", "stream", "releaseClickSoundPool", "resetLogicStatus", "resetSetting", "saveCurrentKeyboard", "currentId", "saveCurrentKeyboardMode", "safety", "saveIMESetting", "imeSetting", "saveKeySoundStatus", "open", "saveKeyVibrateStatus", "plugin-hld_release"})
public final class i
{
  private static Integer DHm;
  private static Boolean DHn;
  private static SoundPool DHo;
  private static final HashMap<Integer, Integer> DHp;
  public static final i DHq;
  public static final String TAG = "WxIme.WxImeSettingUtil";
  private static boolean isLogin;
  
  static
  {
    AppMethodBeat.i(217068);
    DHq = new i();
    TAG = "WxIme.WxImeSettingUtil";
    l locall = l.DHK;
    isLogin = l.biq();
    DHp = new HashMap();
    AppMethodBeat.o(217068);
  }
  
  public static void UJ(int paramInt)
  {
    AppMethodBeat.i(217046);
    Log.i(TAG, "saveCurrentKeyboard ".concat(String.valueOf(paramInt)));
    DHm = Integer.valueOf(paramInt);
    Object localObject = l.DHK;
    localObject = l.eHB();
    if ((localObject == null) || (((MultiProcessMMKV)localObject).putInt("ime_current_keyboard", paramInt) == null))
    {
      Log.e(TAG, "saveCurrentKeyboard getUserKV null");
      localObject = x.aazN;
    }
    localObject = l.DHK;
    localObject = l.eHC();
    if ((localObject == null) || (((MultiProcessMMKV)localObject).putInt("ime_current_keyboard", paramInt) == null))
    {
      Log.e(TAG, "saveCurrentKeyboard getInvalidUserKV null");
      localObject = x.aazN;
    }
    AppMethodBeat.o(217046);
  }
  
  public static void a(b paramb, Context paramContext)
  {
    AppMethodBeat.i(217055);
    p.k(paramContext, "context");
    if (paramb != null)
    {
      if (((paramb.type & 0x2) == 2) && (paramb.DzR == 2))
      {
        ax(paramContext, 3);
        AppMethodBeat.o(217055);
        return;
      }
      ax(paramContext, 1);
      AppMethodBeat.o(217055);
      return;
    }
    AppMethodBeat.o(217055);
  }
  
  public static void an(View paramView, int paramInt)
  {
    AppMethodBeat.i(217056);
    if (paramView != null)
    {
      paramView = paramView.getContext();
      if (paramView != null)
      {
        ax(paramView, paramInt);
        AppMethodBeat.o(217056);
        return;
      }
    }
    AppMethodBeat.o(217056);
  }
  
  private static void ax(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(217065);
    if (eGD()) {
      switch (paramInt)
      {
      default: 
        paramInt = a.j.key_sound1;
      }
    }
    for (;;)
    {
      ay(paramContext, paramInt);
      AppMethodBeat.o(217065);
      return;
      paramInt = a.j.key_sound2;
      continue;
      paramInt = a.j.key_sound3;
    }
  }
  
  private static void ay(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(217067);
    Object localObject = paramContext.getString(paramInt);
    p.j(localObject, "context.getString(pathId)");
    Log.d(TAG, "play start path:" + (String)localObject + " context:" + paramContext + " pathId:" + paramInt + " loaded " + DHp.containsKey(Integer.valueOf(paramInt)));
    if (DHo == null) {
      DHo = new SoundPool.Builder().setMaxStreams(10).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(1).build()).build();
    }
    if (DHp.containsKey(Integer.valueOf(paramInt)))
    {
      paramContext = DHo;
      if (paramContext != null)
      {
        localObject = DHp.get(Integer.valueOf(paramInt));
        if (localObject == null) {
          p.iCn();
        }
        p.j(localObject, "clickSoundIDs[pathId]!!");
        paramContext.play(((Number)localObject).intValue(), 1.0F, 1.0F, 0, 0, 1.0F);
        AppMethodBeat.o(217067);
        return;
      }
      AppMethodBeat.o(217067);
      return;
    }
    localObject = DHo;
    if (localObject != null) {
      ((SoundPool)localObject).load(paramContext.getAssets().openFd(paramContext.getString(paramInt)), 1);
    }
    paramContext = DHo;
    if (paramContext != null)
    {
      paramContext.setOnLoadCompleteListener((SoundPool.OnLoadCompleteListener)new a(paramInt));
      AppMethodBeat.o(217067);
      return;
    }
    AppMethodBeat.o(217067);
  }
  
  public static boolean biq()
  {
    return isLogin;
  }
  
  public static void d(ImeKeyRelativeLayout paramImeKeyRelativeLayout)
  {
    AppMethodBeat.i(217053);
    if (paramImeKeyRelativeLayout != null)
    {
      if (((paramImeKeyRelativeLayout.getType() & 0x2) == 2) && (paramImeKeyRelativeLayout.getFunctionCode() == 2))
      {
        an((View)paramImeKeyRelativeLayout, 3);
        AppMethodBeat.o(217053);
        return;
      }
      an((View)paramImeKeyRelativeLayout, 1);
      AppMethodBeat.o(217053);
      return;
    }
    AppMethodBeat.o(217053);
  }
  
  public static int eEm()
  {
    AppMethodBeat.i(217048);
    Object localObject = l.DHK;
    int i;
    if (l.eCE())
    {
      i = c.Dym.ordinal();
      AppMethodBeat.o(217048);
      return i;
    }
    if (DHm == null)
    {
      i = c.Dym.ordinal();
      if (!isLogin) {
        break label109;
      }
      localObject = l.DHK;
      localObject = l.eHB();
      if (localObject == null) {
        break label101;
      }
      localObject = Integer.valueOf(((MultiProcessMMKV)localObject).getInt("ime_current_keyboard", i));
    }
    for (;;)
    {
      DHm = (Integer)localObject;
      localObject = DHm;
      if (localObject == null) {
        p.iCn();
      }
      i = ((Integer)localObject).intValue();
      AppMethodBeat.o(217048);
      return i;
      label101:
      localObject = Integer.valueOf(i);
      continue;
      label109:
      localObject = l.DHK;
      localObject = l.eHC();
      if (localObject != null) {
        localObject = Integer.valueOf(((MultiProcessMMKV)localObject).getInt("ime_current_keyboard", i));
      } else {
        localObject = Integer.valueOf(i);
      }
    }
  }
  
  public static boolean eGC()
  {
    AppMethodBeat.i(217045);
    Object localObject;
    if (DHn == null)
    {
      if (!isLogin) {
        break label77;
      }
      localObject = l.DHK;
      localObject = l.eHB();
      if (localObject == null) {
        break label70;
      }
      localObject = Boolean.valueOf(((MultiProcessMMKV)localObject).getBoolean("ime_current_mode", true));
    }
    for (;;)
    {
      DHn = (Boolean)localObject;
      localObject = DHn;
      if (localObject == null) {
        p.iCn();
      }
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(217045);
      return bool;
      label70:
      localObject = Boolean.TRUE;
      continue;
      label77:
      localObject = l.DHK;
      localObject = l.eHC();
      if (localObject != null) {
        localObject = Boolean.valueOf(((MultiProcessMMKV)localObject).getBoolean("ime_current_mode", true));
      } else {
        localObject = Boolean.TRUE;
      }
    }
  }
  
  public static boolean eGD()
  {
    AppMethodBeat.i(217051);
    boolean bool;
    if (isLogin)
    {
      localObject = l.DHK;
      localObject = l.eHB();
      if (localObject != null)
      {
        bool = ((MultiProcessMMKV)localObject).getBoolean("ime_key_sound_status", false);
        AppMethodBeat.o(217051);
        return bool;
      }
      AppMethodBeat.o(217051);
      return false;
    }
    Object localObject = l.DHK;
    localObject = l.eHC();
    if (localObject != null)
    {
      bool = ((MultiProcessMMKV)localObject).getBoolean("ime_key_sound_status", false);
      AppMethodBeat.o(217051);
      return bool;
    }
    AppMethodBeat.o(217051);
    return false;
  }
  
  public static boolean eGE()
  {
    AppMethodBeat.i(217052);
    boolean bool;
    if (isLogin)
    {
      localObject = l.DHK;
      localObject = l.eHB();
      if (localObject != null)
      {
        bool = ((MultiProcessMMKV)localObject).getBoolean("ime_key_vibrate_status", true);
        AppMethodBeat.o(217052);
        return bool;
      }
      AppMethodBeat.o(217052);
      return true;
    }
    Object localObject = l.DHK;
    localObject = l.eHC();
    if (localObject != null)
    {
      bool = ((MultiProcessMMKV)localObject).getBoolean("ime_key_vibrate_status", true);
      AppMethodBeat.o(217052);
      return bool;
    }
    AppMethodBeat.o(217052);
    return true;
  }
  
  public static void eGF()
  {
    AppMethodBeat.i(217060);
    l locall = l.DHK;
    isLogin = l.biq();
    AppMethodBeat.o(217060);
  }
  
  public static int eGG()
  {
    AppMethodBeat.i(217062);
    Object localObject = l.DHK;
    localObject = l.eHB();
    if (localObject != null)
    {
      int i = ((MultiProcessMMKV)localObject).getInt("ime_setting", 0);
      AppMethodBeat.o(217062);
      return i;
    }
    AppMethodBeat.o(217062);
    return 0;
  }
  
  public static void eGH()
  {
    DHm = null;
    DHn = null;
  }
  
  public static void td(boolean paramBoolean)
  {
    AppMethodBeat.i(217043);
    Log.i(TAG, "saveCurrentKeyboardMode ".concat(String.valueOf(paramBoolean)));
    DHn = Boolean.valueOf(paramBoolean);
    Object localObject = l.DHK;
    localObject = l.eHB();
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).putBoolean("ime_current_mode", paramBoolean);
    }
    localObject = l.DHK;
    localObject = l.eHC();
    if (localObject != null)
    {
      ((MultiProcessMMKV)localObject).putBoolean("ime_current_mode", paramBoolean);
      AppMethodBeat.o(217043);
      return;
    }
    AppMethodBeat.o(217043);
  }
  
  public static void te(boolean paramBoolean)
  {
    AppMethodBeat.i(217049);
    Log.i(TAG, "saveKeySoundStatus ".concat(String.valueOf(paramBoolean)));
    Object localObject = l.DHK;
    localObject = l.eHB();
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).putBoolean("ime_key_sound_status", paramBoolean);
    }
    localObject = l.DHK;
    localObject = l.eHC();
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).putBoolean("ime_key_sound_status", paramBoolean);
    }
    if (!paramBoolean)
    {
      localObject = DHo;
      if (localObject != null) {
        ((SoundPool)localObject).release();
      }
      DHo = null;
      DHp.clear();
    }
    AppMethodBeat.o(217049);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "soundPool", "Landroid/media/SoundPool;", "kotlin.jvm.PlatformType", "sampleId", "", "status", "onLoadComplete"})
  static final class a
    implements SoundPool.OnLoadCompleteListener
  {
    a(int paramInt) {}
    
    public final void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(217109);
      if (paramInt2 == 0)
      {
        paramSoundPool = i.DHq;
        ((Map)i.eGI()).put(Integer.valueOf(this.DHr), Integer.valueOf(paramInt1));
        paramSoundPool = i.DHq;
        paramSoundPool = i.eGJ();
        if (paramSoundPool != null)
        {
          paramSoundPool.play(paramInt1, 1.0F, 1.0F, 0, 0, 1.0F);
          AppMethodBeat.o(217109);
          return;
        }
        AppMethodBeat.o(217109);
        return;
      }
      paramSoundPool = i.DHq;
      Log.e(i.eGK(), "SoundPool load error pathId " + this.DHr + " status " + paramInt2);
      AppMethodBeat.o(217109);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.f.i
 * JD-Core Version:    0.7.0.1
 */