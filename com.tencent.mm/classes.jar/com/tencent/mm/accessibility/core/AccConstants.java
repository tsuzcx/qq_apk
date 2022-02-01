package com.tencent.mm.accessibility.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/AccConstants;", "", "()V", "ID_RESOURCE_TYPE", "", "NORMAL_STRING_TYPE", "PARAM_METHOD_TYPE", "STRING_RESOURCE_TYPE", "AreaConfig", "ProviderAuthority", "ReportKey", "ReportMMKVKey", "ServiceName", "ServicePackage", "ServiceTypeValue", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AccConstants
{
  public static final String ID_RESOURCE_TYPE = "id_resource_type";
  public static final AccConstants INSTANCE;
  public static final String NORMAL_STRING_TYPE = "normal_string_type";
  public static final String PARAM_METHOD_TYPE = "param_method_type";
  public static final String STRING_RESOURCE_TYPE = "string_resource_type";
  
  static
  {
    AppMethodBeat.i(234161);
    INSTANCE = new AccConstants();
    AppMethodBeat.o(234161);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/AccConstants$AreaConfig;", "", "()V", "DEFAULT_MIN_HEIGHT", "", "DEFAULT_MIN_WIDTH", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class AreaConfig
  {
    public static final int DEFAULT_MIN_HEIGHT = 44;
    public static final int DEFAULT_MIN_WIDTH = 44;
    public static final AreaConfig INSTANCE;
    
    static
    {
      AppMethodBeat.i(234153);
      INSTANCE = new AreaConfig();
      AppMethodBeat.o(234153);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/AccConstants$ProviderAuthority;", "", "()V", "ACC_ACTION", "", "ACC_EVENT", "INFLATE", "NODE_INFO", "NONE", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class ProviderAuthority
  {
    public static final int ACC_ACTION = 8;
    public static final int ACC_EVENT = 4;
    public static final int INFLATE = 2;
    public static final ProviderAuthority INSTANCE;
    public static final int NODE_INFO = 1;
    public static final int NONE = 0;
    
    static
    {
      AppMethodBeat.i(234172);
      INSTANCE = new ProviderAuthority();
      AppMethodBeat.o(234172);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/AccConstants$ReportKey;", "", "()V", "Hierarchy_Invoke_Throw", "", "Hierarchy_Reflect_Throw", "ID", "Touch_Exploration_Enable", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class ReportKey
  {
    public static final long Hierarchy_Invoke_Throw = 2L;
    public static final long Hierarchy_Reflect_Throw = 1L;
    public static final long ID = 1784L;
    public static final ReportKey INSTANCE;
    public static final long Touch_Exploration_Enable = 0L;
    
    static
    {
      AppMethodBeat.i(234142);
      INSTANCE = new ReportKey();
      AppMethodBeat.o(234142);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/AccConstants$ReportMMKVKey;", "", "()V", "HasReportDataString", "", "LastReportTimeLong", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class ReportMMKVKey
  {
    public static final String HasReportDataString = "HasReportDataString";
    public static final ReportMMKVKey INSTANCE;
    public static final String LastReportTimeLong = "LastReportTimeLong";
    
    static
    {
      AppMethodBeat.i(234127);
      INSTANCE = new ReportMMKVKey();
      AppMethodBeat.o(234127);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/AccConstants$ServiceName;", "", "()V", "Boyhood", "", "DianMing", "JieShuo", "ScreenReader", "TalkBack", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class ServiceName
  {
    public static final String Boyhood = "BoyhoodVoiceBackService";
    public static final String DianMing = "MyAccessibilityService";
    public static final ServiceName INSTANCE;
    public static final String JieShuo = "TalkManAccessibilityService";
    public static final String ScreenReader = "ScreenReaderService";
    public static final String TalkBack = "TalkBackService";
    
    static
    {
      AppMethodBeat.i(234157);
      INSTANCE = new ServiceName();
      AppMethodBeat.o(234157);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/AccConstants$ServicePackage;", "", "()V", "Boyhood", "", "DianMing", "JieShuo", "ScreenReader", "TalkBack", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class ServicePackage
  {
    public static final String Boyhood = "com.bjbyhd.voiceback";
    public static final String DianMing = "com.dianming.phoneapp";
    public static final ServicePackage INSTANCE;
    public static final String JieShuo = "com.nirenr.talkman";
    public static final String ScreenReader = "com.bjbyhd.screenreader_huawei";
    public static final String TalkBack = "com.google.android.marvin";
    
    static
    {
      AppMethodBeat.i(234123);
      INSTANCE = new ServicePackage();
      AppMethodBeat.o(234123);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/AccConstants$ServiceTypeValue;", "", "()V", "DianMing", "", "JieShuo", "ScreenReader", "TalkBack", "UNKNOWN", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class ServiceTypeValue
  {
    public static final int DianMing = 3;
    public static final ServiceTypeValue INSTANCE;
    public static final int JieShuo = 4;
    public static final int ScreenReader = 2;
    public static final int TalkBack = 1;
    public static final int UNKNOWN = 0;
    
    static
    {
      AppMethodBeat.i(234141);
      INSTANCE = new ServiceTypeValue();
      AppMethodBeat.o(234141);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.AccConstants
 * JD-Core Version:    0.7.0.1
 */