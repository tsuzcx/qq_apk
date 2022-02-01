package com.tencent.mm.plugin.hld.f;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/utils/WxImeConfigUtil;", "", "()V", "TAG", "", "getCanPrintClickDataConfig", "", "getCanPrintEngineLogConfig", "getDeleteKeyRepeatDelayTime", "", "getDeleteKeyRepeatInterTime", "getEnableMoveCursorConfig", "getEnablePreInputConfig", "getEnableSelfdrawKeyboardConfig", "getImeCloudDictOpenConfig", "getImeEmojiUnicodeOpenConfig", "getImeFaultExchangeOpenConfig", "getImeFaultInsertAtMiddleOpenConfig", "getImeFaultOpenConfig", "getImeFaultSkipOpenConfig", "getImeFuzzySyllablesOpenConfig", "getImeILinkLoginOpenConfig", "saveCanPrintClickDataConfig", "", "open", "saveCanPrintEngineLogConfig", "saveDeleteKeyRepeatDelayTime", "interTime", "saveDeleteKeyRepeatInterTime", "saveEnableMoveCursorConfig", "saveEnablePreInputConfig", "saveEnableSelfdrawKeyboardConfig", "saveImeCloudDictOpenConfig", "saveImeEmojiUnicodeOpenConfig", "saveImeFaultExchangeOpenConfig", "saveImeFaultInsertAtMiddleOpenConfig", "saveImeFaultOpenConfig", "saveImeFaultSkipOpenConfig", "saveImeFuzzySyllablesOpenConfig", "saveImeILinkLoginOpenConfig", "plugin-hld_release"})
public final class e
{
  public static final e DGW;
  private static final String TAG = "WxIme.WxImeConfigUtil";
  
  static
  {
    AppMethodBeat.i(215936);
    DGW = new e();
    TAG = "WxIme.WxImeConfigUtil";
    AppMethodBeat.o(215936);
  }
  
  public static void Ob(long paramLong)
  {
    AppMethodBeat.i(215930);
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putLong("ime_delete_key_repeat_inter_time", paramLong);
        AppMethodBeat.o(215930);
        return;
      }
    }
    AppMethodBeat.o(215930);
  }
  
  public static void Oc(long paramLong)
  {
    AppMethodBeat.i(215934);
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putLong("ime_delete_key_repeat_delay_time", paramLong);
        AppMethodBeat.o(215934);
        return;
      }
    }
    AppMethodBeat.o(215934);
  }
  
  public static void eGe()
  {
    AppMethodBeat.i(215895);
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_fault_open", false);
        AppMethodBeat.o(215895);
        return;
      }
    }
    AppMethodBeat.o(215895);
  }
  
  public static void eGf()
  {
    AppMethodBeat.i(215898);
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_fault_exchange_open", false);
        AppMethodBeat.o(215898);
        return;
      }
    }
    AppMethodBeat.o(215898);
  }
  
  public static void eGg()
  {
    AppMethodBeat.i(215900);
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_fault_insert_at_middle_open", false);
        AppMethodBeat.o(215900);
        return;
      }
    }
    AppMethodBeat.o(215900);
  }
  
  public static void eGh()
  {
    AppMethodBeat.i(215901);
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_fault_skip_open", true);
        AppMethodBeat.o(215901);
        return;
      }
    }
    AppMethodBeat.o(215901);
  }
  
  public static void eGi()
  {
    AppMethodBeat.i(215903);
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_fuzzy_syllables_open", true);
        AppMethodBeat.o(215903);
        return;
      }
    }
    AppMethodBeat.o(215903);
  }
  
  public static void eGj()
  {
    AppMethodBeat.i(215905);
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_emoji_unicode_open", true);
        AppMethodBeat.o(215905);
        return;
      }
    }
    AppMethodBeat.o(215905);
  }
  
  public static void eGk()
  {
    AppMethodBeat.i(215907);
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_ilink_login_open", true);
        AppMethodBeat.o(215907);
        return;
      }
    }
    AppMethodBeat.o(215907);
  }
  
  public static boolean eGl()
  {
    AppMethodBeat.i(215911);
    if (!WeChatEnvironment.hasDebugger())
    {
      AppMethodBeat.o(215911);
      return false;
    }
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      boolean bool = ((MultiProcessMMKV)localObject).getBoolean("ime_can_print_click_data", false);
      AppMethodBeat.o(215911);
      return bool;
    }
    AppMethodBeat.o(215911);
    return false;
  }
  
  public static boolean eGm()
  {
    AppMethodBeat.i(215914);
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      boolean bool = ((MultiProcessMMKV)localObject).getBoolean("ime_can_print_engine_log", false);
      AppMethodBeat.o(215914);
      return bool;
    }
    AppMethodBeat.o(215914);
    return false;
  }
  
  public static boolean eGn()
  {
    AppMethodBeat.i(215919);
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      boolean bool = ((MultiProcessMMKV)localObject).getBoolean("ime_enable_pre_input", true);
      AppMethodBeat.o(215919);
      return bool;
    }
    AppMethodBeat.o(215919);
    return true;
  }
  
  public static boolean eGo()
  {
    AppMethodBeat.i(215923);
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      boolean bool = ((MultiProcessMMKV)localObject).getBoolean("ime_enable_selfdraw_keyboard", true);
      AppMethodBeat.o(215923);
      return bool;
    }
    AppMethodBeat.o(215923);
    return true;
  }
  
  public static boolean eGp()
  {
    AppMethodBeat.i(215926);
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      boolean bool = ((MultiProcessMMKV)localObject).getBoolean("ime_enable_move_cursor", false);
      AppMethodBeat.o(215926);
      return bool;
    }
    AppMethodBeat.o(215926);
    return false;
  }
  
  public static long eGq()
  {
    AppMethodBeat.i(215928);
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      long l = ((MultiProcessMMKV)localObject).getLong("ime_delete_key_repeat_inter_time", 100L);
      AppMethodBeat.o(215928);
      return l;
    }
    AppMethodBeat.o(215928);
    return 100L;
  }
  
  public static long eGr()
  {
    AppMethodBeat.i(215932);
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      long l = ((MultiProcessMMKV)localObject).getLong("ime_delete_key_repeat_delay_time", 300L);
      AppMethodBeat.o(215932);
      return l;
    }
    AppMethodBeat.o(215932);
    return 300L;
  }
  
  public static void sX(boolean paramBoolean)
  {
    AppMethodBeat.i(215909);
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_can_print_click_data", paramBoolean);
        AppMethodBeat.o(215909);
        return;
      }
    }
    AppMethodBeat.o(215909);
  }
  
  public static void sY(boolean paramBoolean)
  {
    AppMethodBeat.i(215913);
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_can_print_engine_log", paramBoolean);
        AppMethodBeat.o(215913);
        return;
      }
    }
    AppMethodBeat.o(215913);
  }
  
  public static void sZ(boolean paramBoolean)
  {
    AppMethodBeat.i(215917);
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_enable_pre_input", paramBoolean);
        AppMethodBeat.o(215917);
        return;
      }
    }
    AppMethodBeat.o(215917);
  }
  
  public static void ta(boolean paramBoolean)
  {
    AppMethodBeat.i(215921);
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_enable_selfdraw_keyboard", paramBoolean);
        AppMethodBeat.o(215921);
        return;
      }
    }
    AppMethodBeat.o(215921);
  }
  
  public static void tb(boolean paramBoolean)
  {
    AppMethodBeat.i(215924);
    Object localObject = l.DHK;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_enable_move_cursor", paramBoolean);
        AppMethodBeat.o(215924);
        return;
      }
    }
    AppMethodBeat.o(215924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.f.e
 * JD-Core Version:    0.7.0.1
 */