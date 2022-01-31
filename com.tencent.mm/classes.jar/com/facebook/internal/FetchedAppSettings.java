package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.EnumSet;
import java.util.Map;
import org.json.JSONArray;

public final class FetchedAppSettings
{
  private boolean IAPAutomaticLoggingEnabled;
  private boolean automaticLoggingEnabled;
  private boolean codelessEventsEnabled;
  private boolean codelessSetupEnabled;
  private boolean customTabsEnabled;
  private Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> dialogConfigMap;
  private FacebookRequestErrorClassification errorClassification;
  private JSONArray eventBindings;
  private String nuxContent;
  private boolean nuxEnabled;
  private String sdkUpdateMessage;
  private int sessionTimeoutInSeconds;
  private String smartLoginBookmarkIconURL;
  private String smartLoginMenuIconURL;
  private EnumSet<SmartLoginOption> smartLoginOptions;
  private boolean supportsImplicitLogging;
  private boolean trackUninstallEnabled;
  
  public FetchedAppSettings(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, EnumSet<SmartLoginOption> paramEnumSet, Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> paramMap, boolean paramBoolean4, FacebookRequestErrorClassification paramFacebookRequestErrorClassification, String paramString2, String paramString3, boolean paramBoolean5, boolean paramBoolean6, JSONArray paramJSONArray, String paramString4, boolean paramBoolean7, boolean paramBoolean8)
  {
    this.supportsImplicitLogging = paramBoolean1;
    this.nuxContent = paramString1;
    this.nuxEnabled = paramBoolean2;
    this.customTabsEnabled = paramBoolean3;
    this.dialogConfigMap = paramMap;
    this.errorClassification = paramFacebookRequestErrorClassification;
    this.sessionTimeoutInSeconds = paramInt;
    this.automaticLoggingEnabled = paramBoolean4;
    this.smartLoginOptions = paramEnumSet;
    this.smartLoginBookmarkIconURL = paramString2;
    this.smartLoginMenuIconURL = paramString3;
    this.IAPAutomaticLoggingEnabled = paramBoolean5;
    this.codelessEventsEnabled = paramBoolean6;
    this.eventBindings = paramJSONArray;
    this.sdkUpdateMessage = paramString4;
    this.trackUninstallEnabled = paramBoolean7;
    this.codelessSetupEnabled = paramBoolean8;
  }
  
  public static FetchedAppSettings.DialogFeatureConfig getDialogFeatureConfig(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(72303);
    if ((Utility.isNullOrEmpty(paramString2)) || (Utility.isNullOrEmpty(paramString3)))
    {
      AppMethodBeat.o(72303);
      return null;
    }
    paramString1 = FetchedAppSettingsManager.getAppSettingsWithoutQuery(paramString1);
    if (paramString1 != null)
    {
      paramString1 = (Map)paramString1.getDialogConfigurations().get(paramString2);
      if (paramString1 != null)
      {
        paramString1 = (FetchedAppSettings.DialogFeatureConfig)paramString1.get(paramString3);
        AppMethodBeat.o(72303);
        return paramString1;
      }
    }
    AppMethodBeat.o(72303);
    return null;
  }
  
  public final boolean getAutomaticLoggingEnabled()
  {
    return this.automaticLoggingEnabled;
  }
  
  public final boolean getCodelessEventsEnabled()
  {
    return this.codelessEventsEnabled;
  }
  
  public final boolean getCodelessSetupEnabled()
  {
    return this.codelessSetupEnabled;
  }
  
  public final boolean getCustomTabsEnabled()
  {
    return this.customTabsEnabled;
  }
  
  public final Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> getDialogConfigurations()
  {
    return this.dialogConfigMap;
  }
  
  public final FacebookRequestErrorClassification getErrorClassification()
  {
    return this.errorClassification;
  }
  
  public final JSONArray getEventBindings()
  {
    return this.eventBindings;
  }
  
  public final boolean getIAPAutomaticLoggingEnabled()
  {
    return this.IAPAutomaticLoggingEnabled;
  }
  
  public final String getNuxContent()
  {
    return this.nuxContent;
  }
  
  public final boolean getNuxEnabled()
  {
    return this.nuxEnabled;
  }
  
  public final String getSdkUpdateMessage()
  {
    return this.sdkUpdateMessage;
  }
  
  public final int getSessionTimeoutInSeconds()
  {
    return this.sessionTimeoutInSeconds;
  }
  
  public final String getSmartLoginBookmarkIconURL()
  {
    return this.smartLoginBookmarkIconURL;
  }
  
  public final String getSmartLoginMenuIconURL()
  {
    return this.smartLoginMenuIconURL;
  }
  
  public final EnumSet<SmartLoginOption> getSmartLoginOptions()
  {
    return this.smartLoginOptions;
  }
  
  public final boolean getTrackUninstallEnabled()
  {
    return this.trackUninstallEnabled;
  }
  
  public final boolean supportsImplicitLogging()
  {
    return this.supportsImplicitLogging;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.internal.FetchedAppSettings
 * JD-Core Version:    0.7.0.1
 */