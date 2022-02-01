package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/WxImeConstants;", "", "()V", "IME_ANIMATOR_DURATION", "", "IME_APP_ID", "", "IME_ASSOCIATE_AFTER_TEXT_MAX_NUM", "", "IME_ASSOCIATE_BEFORE_TEXT_MAX_NUM", "IME_CANDIDATE_EVERY_NUM", "IME_CAN_PRINT_CLICK_DATA", "IME_CLOSE_CLIP_CONTENT", "IME_CLOUD_DICT_OPEN", "IME_CURRENT_KEYBOARD", "IME_DEFAULT_WIDTH", "", "IME_DOUBLE_CLICK_INTERVAL", "IME_EMOJI_UNICODE_OPEN", "IME_FAULT_EXCHANGE_OPEN", "IME_FAULT_INSERT_AT_MIDDLE_OPEN", "IME_FAULT_OPEN", "IME_FAULT_SKIP_OPEN", "IME_FETCH_DICT_INTERVAL_MIN_TIME", "IME_FETCH_MORE_CANDIDATE_THRESHOLD", "IME_FLOAT_VIEW_CLICK_DELAY_TIME", "IME_FUZZY_SYLLABLES_OPEN", "IME_GRID_COLUMN_COUNT", "IME_GRID_COLUMN_COUNT_FOUR", "IME_ID", "getIME_ID", "()Ljava/lang/String;", "setIME_ID", "(Ljava/lang/String;)V", "IME_ID2", "getIME_ID2", "setIME_ID2", "IME_ID_NAME", "IME_ILINK_LOGIN_OPEN", "IME_KEY_SOUND_STATUS", "IME_KEY_SOUND_VOLUME", "", "IME_KEY_VIBRATE_STATUS", "IME_LANDSCAPE_GRID_COLUMN_COUNT", "IME_LANDSCAPE_WIDTH", "IME_LONG_CLICK_INTERVAL", "IME_PENDING_INPUT_MAX_NUM", "IME_PHONE_CONTACT_REFRESH_TIME_INTERVSL", "IME_QWERTY_FIRST_LINE_NUM", "IME_SETTING_UI_NAME", "IME_SETTING_UI_NAME_TO_OUT", "IME_SINGLE_APP", "", "getIME_SINGLE_APP", "()Z", "setIME_SINGLE_APP", "(Z)V", "IME_SYMBOL_COLUMN_COUNT", "IME_SYMBOL_COMMON_MAX_NUM", "IME_USER_DICT_MAX_SIZE", "WEI_XIN_PACKAGE_NAME", "getWEI_XIN_PACKAGE_NAME", "setWEI_XIN_PACKAGE_NAME", "init", "", "CloudResource", "ContactInfoUI", "CurrentEngineNeedBaseRes", "DeleteKeyParams", "DeleteKeyType", "EditScene", "EmojiParam", "EmojiSubTypeName", "EmojiType", "FirstFetchDictStatus", "FloatViewType", "GridViewType", "ImeConfig", "ImeExtraKey", "ImeKV", "ImePath", "KaoEmojiSubTypeName", "KeyActionMode", "KeyButtonViewType", "KeyChar", "KeyFunctionCode", "KeyTypeBitConst", "KeyUpperMode", "KeyboardButton", "KeyboardKeyID", "KeyboardResource", "KeyboardStatus", "MMKVKey", "MMKVKeyLocalDebugConfig", "OldUserGuideStatus", "Recovery", "RegexPattern", "ReportCandidateType", "ReportKBType", "ReportKeyArea", "ReportOperationType", "ReportPendingInputStatus", "SecDataId", "SwitchFlag", "SymbolTypeName", "UnfoldLineType", "UserDefaultMode", "WxImeInterService", "plugin-hld_release"})
public final class p
{
  private static boolean DED;
  private static String DEE;
  private static String DEF;
  private static String DEG;
  public static final p DEH;
  
  static
  {
    AppMethodBeat.i(210825);
    DEH = new p();
    DEE = "com.tencent.mm";
    DEF = DEE + "/.plugin.hld.WxHldService";
    DEG = DEE + "/com.tencent.mm.plugin.hld.WxHldService";
    AppMethodBeat.o(210825);
  }
  
  public static void aLA(String paramString)
  {
    AppMethodBeat.i(210823);
    kotlin.g.b.p.k(paramString, "<set-?>");
    DEE = paramString;
    AppMethodBeat.o(210823);
  }
  
  public static boolean eFn()
  {
    return DED;
  }
  
  public static String eFo()
  {
    return DEF;
  }
  
  public static String eFp()
  {
    return DEG;
  }
  
  public static void init()
  {
    AppMethodBeat.i(210824);
    DEF = DEE + "/.plugin.hld.WxHldService";
    DEG = DEE + "/com.tencent.mm.plugin.hld.WxHldService";
    AppMethodBeat.o(210824);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/WxImeConstants$RegexPattern;", "", "()V", "SYMBOL_ENGLISH_HANDLE_CHAR_PATTERN", "Ljava/util/regex/Pattern;", "getSYMBOL_ENGLISH_HANDLE_CHAR_PATTERN", "()Ljava/util/regex/Pattern;", "SYMBOL_ENGLISH_SPECIAL_CHAR_PATTERN", "getSYMBOL_ENGLISH_SPECIAL_CHAR_PATTERN", "SYMBOL_NUMBER_CLASS_PATTERN", "getSYMBOL_NUMBER_CLASS_PATTERN", "SYMBOL_PATTERN_ENGLISH_LETTER", "getSYMBOL_PATTERN_ENGLISH_LETTER", "SYMBOL_PATTERN_ENGLISH_LOWER_CASE_LETTER", "getSYMBOL_PATTERN_ENGLISH_LOWER_CASE_LETTER", "plugin-hld_release"})
  public static final class a
  {
    private static final Pattern DEI;
    private static final Pattern DEJ;
    private static final Pattern DEK;
    private static final Pattern DEL;
    private static final Pattern DEM;
    public static final a DEN;
    
    static
    {
      AppMethodBeat.i(215209);
      DEN = new a();
      Pattern localPattern = Pattern.compile("^[a-zA-Z]+$");
      kotlin.g.b.p.j(localPattern, "Pattern.compile(\"^[a-zA-Z]+$\")");
      DEI = localPattern;
      localPattern = Pattern.compile("^[a-z]+$");
      kotlin.g.b.p.j(localPattern, "Pattern.compile(\"^[a-z]+$\")");
      DEJ = localPattern;
      localPattern = Pattern.compile("^\\d$");
      kotlin.g.b.p.j(localPattern, "Pattern.compile(\"^\\\\d$\")");
      DEK = localPattern;
      localPattern = Pattern.compile("^[a-zA-Z0-9@]$");
      kotlin.g.b.p.j(localPattern, "Pattern.compile(\"^[a-zA-Z0-9@]$\")");
      DEL = localPattern;
      localPattern = Pattern.compile("^[,.?!:;]$");
      kotlin.g.b.p.j(localPattern, "Pattern.compile(\"^[,.?!:;]$\")");
      DEM = localPattern;
      AppMethodBeat.o(215209);
    }
    
    public static Pattern eFq()
    {
      return DEI;
    }
    
    public static Pattern eFr()
    {
      return DEK;
    }
    
    public static Pattern eFs()
    {
      return DEL;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.p
 * JD-Core Version:    0.7.0.1
 */