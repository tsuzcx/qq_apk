package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/model/WxImeConstants;", "", "()V", "IME_ANIMATOR_DURATION", "", "IME_APP_ID", "", "IME_ASSOCIATE_AFTER_TEXT_MAX_NUM", "", "IME_ASSOCIATE_BEFORE_TEXT_MAX_NUM", "IME_CANDIDATE_EVERY_NUM", "IME_CAN_PRINT_CLICK_DATA", "IME_CLOSE_CLIP_CONTENT", "IME_CLOUD_DICT_OPEN", "IME_CURRENT_KEYBOARD", "IME_DEFAULT_WIDTH", "", "IME_DOUBLE_CLICK_INTERVAL", "IME_EMOJI_UNICODE_OPEN", "IME_FAULT_EXCHANGE_OPEN", "IME_FAULT_INSERT_AT_MIDDLE_OPEN", "IME_FAULT_OPEN", "IME_FAULT_SKIP_OPEN", "IME_FETCH_DICT_INTERVAL_MIN_TIME", "IME_FETCH_MORE_CANDIDATE_THRESHOLD", "IME_FLOAT_VIEW_CLICK_DELAY_TIME", "IME_FUZZY_SYLLABLES_OPEN", "IME_GRID_COLUMN_COUNT", "IME_GRID_COLUMN_COUNT_FOUR", "IME_ID", "getIME_ID", "()Ljava/lang/String;", "setIME_ID", "(Ljava/lang/String;)V", "IME_ID2", "getIME_ID2", "setIME_ID2", "IME_ID_NAME", "IME_ILINK_LOGIN_OPEN", "IME_KEY_SOUND_STATUS", "IME_KEY_SOUND_VOLUME", "", "IME_KEY_VIBRATE_STATUS", "IME_LANDSCAPE_GRID_COLUMN_COUNT", "IME_LANDSCAPE_WIDTH", "IME_LONG_CLICK_INTERVAL", "IME_PENDING_INPUT_MAX_NUM", "IME_PHONE_CONTACT_REFRESH_TIME_INTERVSL", "IME_QWERTY_FIRST_LINE_NUM", "IME_SETTING_UI_NAME", "IME_SETTING_UI_NAME_TO_OUT", "IME_SINGLE_APP", "", "getIME_SINGLE_APP", "()Z", "setIME_SINGLE_APP", "(Z)V", "IME_SYMBOL_COLUMN_COUNT", "IME_SYMBOL_COMMON_MAX_NUM", "IME_USER_DICT_MAX_SIZE", "WEI_XIN_PACKAGE_NAME", "getWEI_XIN_PACKAGE_NAME", "setWEI_XIN_PACKAGE_NAME", "init", "", "CloudResource", "ContactInfoUI", "CurrentEngineNeedBaseRes", "DeleteKeyParams", "DeleteKeyType", "EditScene", "EmojiParam", "EmojiSubTypeName", "EmojiType", "FirstFetchDictStatus", "FloatViewType", "GridViewType", "ImeConfig", "ImeExtraKey", "ImeKV", "ImePath", "KaoEmojiSubTypeName", "KeyActionMode", "KeyButtonViewType", "KeyChar", "KeyFunctionCode", "KeyTypeBitConst", "KeyUpperMode", "KeyboardButton", "KeyboardKeyID", "KeyboardResource", "KeyboardStatus", "MMKVKey", "MMKVKeyLocalDebugConfig", "OldUserGuideStatus", "Recovery", "RegexPattern", "ReportCandidateType", "ReportKBType", "ReportKeyArea", "ReportOperationType", "ReportPendingInputStatus", "SecDataId", "SwitchFlag", "SymbolTypeName", "UnfoldLineType", "UserDefaultMode", "WxImeInterService", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final o Jwm;
  private static boolean Jwn;
  private static String Jwo;
  private static String Jwp;
  private static String Jwq;
  
  static
  {
    AppMethodBeat.i(311956);
    Jwm = new o();
    Jwo = "com.tencent.mm";
    Jwp = s.X("com.tencent.mm", "/.plugin.hld.WxHldService");
    Jwq = s.X(Jwo, "/com.tencent.mm.plugin.hld.WxHldService");
    AppMethodBeat.o(311956);
  }
  
  public static void aIs(String paramString)
  {
    AppMethodBeat.i(311918);
    s.u(paramString, "<set-?>");
    Jwo = paramString;
    AppMethodBeat.o(311918);
  }
  
  public static boolean fNe()
  {
    return Jwn;
  }
  
  public static String fNf()
  {
    return Jwp;
  }
  
  public static String fNg()
  {
    return Jwq;
  }
  
  public static void init()
  {
    AppMethodBeat.i(311944);
    Jwp = s.X(Jwo, "/.plugin.hld.WxHldService");
    Jwq = s.X(Jwo, "/com.tencent.mm.plugin.hld.WxHldService");
    AppMethodBeat.o(311944);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/model/WxImeConstants$RegexPattern;", "", "()V", "SYMBOL_ENGLISH_HANDLE_CHAR_PATTERN", "Ljava/util/regex/Pattern;", "getSYMBOL_ENGLISH_HANDLE_CHAR_PATTERN", "()Ljava/util/regex/Pattern;", "SYMBOL_ENGLISH_SPECIAL_CHAR_PATTERN", "getSYMBOL_ENGLISH_SPECIAL_CHAR_PATTERN", "SYMBOL_NUMBER_CLASS_PATTERN", "getSYMBOL_NUMBER_CLASS_PATTERN", "SYMBOL_PATTERN_ENGLISH_LETTER", "getSYMBOL_PATTERN_ENGLISH_LETTER", "SYMBOL_PATTERN_ENGLISH_LOWER_CASE_LETTER", "getSYMBOL_PATTERN_ENGLISH_LOWER_CASE_LETTER", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final a Jwr;
    private static final Pattern Jws;
    private static final Pattern Jwt;
    private static final Pattern Jwu;
    private static final Pattern Jwv;
    private static final Pattern Jww;
    
    static
    {
      AppMethodBeat.i(312032);
      Jwr = new a();
      Pattern localPattern = Pattern.compile("^[a-zA-Z]+$");
      s.s(localPattern, "compile(\"^[a-zA-Z]+$\")");
      Jws = localPattern;
      localPattern = Pattern.compile("^[a-z]+$");
      s.s(localPattern, "compile(\"^[a-z]+$\")");
      Jwt = localPattern;
      localPattern = Pattern.compile("^\\d$");
      s.s(localPattern, "compile(\"^\\\\d$\")");
      Jwu = localPattern;
      localPattern = Pattern.compile("^[a-zA-Z0-9@]$");
      s.s(localPattern, "compile(\"^[a-zA-Z0-9@]$\")");
      Jwv = localPattern;
      localPattern = Pattern.compile("^[,.?!:;]$");
      s.s(localPattern, "compile(\"^[,.?!:;]$\")");
      Jww = localPattern;
      AppMethodBeat.o(312032);
    }
    
    public static Pattern fNh()
    {
      return Jws;
    }
    
    public static Pattern fNi()
    {
      return Jwu;
    }
    
    public static Pattern fNj()
    {
      return Jwv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.o
 * JD-Core Version:    0.7.0.1
 */