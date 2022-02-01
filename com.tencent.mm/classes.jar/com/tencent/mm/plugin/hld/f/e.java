package com.tencent.mm.plugin.hld.f;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/utils/WxImeConfigUtil;", "", "()V", "TAG", "", "getCanPrintClickDataConfig", "", "getCanPrintEngineLogConfig", "getDeleteKeyRepeatDelayTime", "", "getDeleteKeyRepeatInterTime", "getEnableMoveCursorConfig", "getEnablePreInputConfig", "getEnableSelfdrawKeyboardConfig", "getImeCloudDictOpenConfig", "getImeEmojiUnicodeOpenConfig", "getImeFaultExchangeOpenConfig", "getImeFaultInsertAtMiddleOpenConfig", "getImeFaultOpenConfig", "getImeFaultSkipOpenConfig", "getImeFuzzySyllablesOpenConfig", "getImeILinkLoginOpenConfig", "saveCanPrintClickDataConfig", "", "open", "saveCanPrintEngineLogConfig", "saveDeleteKeyRepeatDelayTime", "interTime", "saveDeleteKeyRepeatInterTime", "saveEnableMoveCursorConfig", "saveEnablePreInputConfig", "saveEnableSelfdrawKeyboardConfig", "saveImeCloudDictOpenConfig", "saveImeEmojiUnicodeOpenConfig", "saveImeFaultExchangeOpenConfig", "saveImeFaultInsertAtMiddleOpenConfig", "saveImeFaultOpenConfig", "saveImeFaultSkipOpenConfig", "saveImeFuzzySyllablesOpenConfig", "saveImeILinkLoginOpenConfig", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e Jym;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(311755);
    Jym = new e();
    TAG = "WxIme.WxImeConfigUtil";
    AppMethodBeat.o(311755);
  }
  
  public static boolean fNQ()
  {
    return true;
  }
  
  public static boolean fNR()
  {
    return true;
  }
  
  public static boolean fNS()
  {
    return true;
  }
  
  public static boolean fNT()
  {
    return false;
  }
  
  public static boolean fNU()
  {
    return false;
  }
  
  public static boolean fNV()
  {
    return false;
  }
  
  public static boolean fNW()
  {
    return false;
  }
  
  public static boolean fNX()
  {
    AppMethodBeat.i(311641);
    if (!WeChatEnvironment.hasDebugger())
    {
      AppMethodBeat.o(311641);
      return false;
    }
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject == null)
    {
      AppMethodBeat.o(311641);
      return false;
    }
    boolean bool = ((MultiProcessMMKV)localObject).getBoolean("ime_can_print_click_data", false);
    AppMethodBeat.o(311641);
    return bool;
  }
  
  public static boolean fNY()
  {
    AppMethodBeat.i(311656);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject == null)
    {
      AppMethodBeat.o(311656);
      return false;
    }
    boolean bool = ((MultiProcessMMKV)localObject).getBoolean("ime_can_print_engine_log", false);
    AppMethodBeat.o(311656);
    return bool;
  }
  
  public static boolean fNZ()
  {
    AppMethodBeat.i(311664);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject == null)
    {
      AppMethodBeat.o(311664);
      return true;
    }
    boolean bool = ((MultiProcessMMKV)localObject).getBoolean("ime_enable_pre_input", true);
    AppMethodBeat.o(311664);
    return bool;
  }
  
  public static boolean fOa()
  {
    AppMethodBeat.i(311679);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject == null)
    {
      AppMethodBeat.o(311679);
      return true;
    }
    boolean bool = ((MultiProcessMMKV)localObject).getBoolean("ime_enable_selfdraw_keyboard", true);
    AppMethodBeat.o(311679);
    return bool;
  }
  
  public static boolean fOb()
  {
    AppMethodBeat.i(311700);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject == null)
    {
      AppMethodBeat.o(311700);
      return false;
    }
    boolean bool = ((MultiProcessMMKV)localObject).getBoolean("ime_enable_move_cursor", false);
    AppMethodBeat.o(311700);
    return bool;
  }
  
  public static boolean fOc()
  {
    return true;
  }
  
  public static long fOd()
  {
    AppMethodBeat.i(311717);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject == null)
    {
      AppMethodBeat.o(311717);
      return 100L;
    }
    long l = ((MultiProcessMMKV)localObject).getLong("ime_delete_key_repeat_inter_time", 100L);
    AppMethodBeat.o(311717);
    return l;
  }
  
  public static long fOe()
  {
    AppMethodBeat.i(311737);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject == null)
    {
      AppMethodBeat.o(311737);
      return 300L;
    }
    long l = ((MultiProcessMMKV)localObject).getLong("ime_delete_key_repeat_delay_time", 300L);
    AppMethodBeat.o(311737);
    return l;
  }
  
  public static void rW(long paramLong)
  {
    AppMethodBeat.i(311730);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null) {
        ((SharedPreferences.Editor)localObject).putLong("ime_delete_key_repeat_inter_time", paramLong);
      }
    }
    AppMethodBeat.o(311730);
  }
  
  public static void rX(long paramLong)
  {
    AppMethodBeat.i(311748);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null) {
        ((SharedPreferences.Editor)localObject).putLong("ime_delete_key_repeat_delay_time", paramLong);
      }
    }
    AppMethodBeat.o(311748);
  }
  
  public static void xc(boolean paramBoolean)
  {
    AppMethodBeat.i(311538);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null) {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_fault_open", paramBoolean);
      }
    }
    AppMethodBeat.o(311538);
  }
  
  public static void xd(boolean paramBoolean)
  {
    AppMethodBeat.i(311548);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null) {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_fault_exchange_open", paramBoolean);
      }
    }
    AppMethodBeat.o(311548);
  }
  
  public static void xe(boolean paramBoolean)
  {
    AppMethodBeat.i(311563);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null) {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_fault_insert_at_middle_open", paramBoolean);
      }
    }
    AppMethodBeat.o(311563);
  }
  
  public static void xf(boolean paramBoolean)
  {
    AppMethodBeat.i(311578);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null) {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_fault_skip_open", paramBoolean);
      }
    }
    AppMethodBeat.o(311578);
  }
  
  public static void xg(boolean paramBoolean)
  {
    AppMethodBeat.i(311593);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null) {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_fuzzy_syllables_open", paramBoolean);
      }
    }
    AppMethodBeat.o(311593);
  }
  
  public static void xh(boolean paramBoolean)
  {
    AppMethodBeat.i(311607);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null) {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_emoji_unicode_open", paramBoolean);
      }
    }
    AppMethodBeat.o(311607);
  }
  
  public static void xi(boolean paramBoolean)
  {
    AppMethodBeat.i(311617);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null) {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_ilink_login_open", paramBoolean);
      }
    }
    AppMethodBeat.o(311617);
  }
  
  public static void xj(boolean paramBoolean)
  {
    AppMethodBeat.i(311632);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null) {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_can_print_click_data", paramBoolean);
      }
    }
    AppMethodBeat.o(311632);
  }
  
  public static void xk(boolean paramBoolean)
  {
    AppMethodBeat.i(311649);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null) {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_can_print_engine_log", paramBoolean);
      }
    }
    AppMethodBeat.o(311649);
  }
  
  public static void xl(boolean paramBoolean)
  {
    AppMethodBeat.i(311661);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null) {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_enable_pre_input", paramBoolean);
      }
    }
    AppMethodBeat.o(311661);
  }
  
  public static void xm(boolean paramBoolean)
  {
    AppMethodBeat.i(311670);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null) {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_enable_selfdraw_keyboard", paramBoolean);
      }
    }
    AppMethodBeat.o(311670);
  }
  
  public static void xn(boolean paramBoolean)
  {
    AppMethodBeat.i(311691);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null) {
        ((SharedPreferences.Editor)localObject).putBoolean("ime_enable_move_cursor", paramBoolean);
      }
    }
    AppMethodBeat.o(311691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.f.e
 * JD-Core Version:    0.7.0.1
 */