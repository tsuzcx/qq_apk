package com.facebook.internal;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.EnumSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class FetchedAppSettings
{
  private boolean IAPAutomaticLoggingEnabled;
  private boolean automaticLoggingEnabled;
  private boolean codelessEventsEnabled;
  private boolean codelessSetupEnabled;
  private boolean customTabsEnabled;
  private Map<String, Map<String, DialogFeatureConfig>> dialogConfigMap;
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
  
  public FetchedAppSettings(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, EnumSet<SmartLoginOption> paramEnumSet, Map<String, Map<String, DialogFeatureConfig>> paramMap, boolean paramBoolean4, FacebookRequestErrorClassification paramFacebookRequestErrorClassification, String paramString2, String paramString3, boolean paramBoolean5, boolean paramBoolean6, JSONArray paramJSONArray, String paramString4, boolean paramBoolean7, boolean paramBoolean8)
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
  
  public static DialogFeatureConfig getDialogFeatureConfig(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(17739);
    if ((Utility.isNullOrEmpty(paramString2)) || (Utility.isNullOrEmpty(paramString3)))
    {
      AppMethodBeat.o(17739);
      return null;
    }
    paramString1 = FetchedAppSettingsManager.getAppSettingsWithoutQuery(paramString1);
    if (paramString1 != null)
    {
      paramString1 = (Map)paramString1.getDialogConfigurations().get(paramString2);
      if (paramString1 != null)
      {
        paramString1 = (DialogFeatureConfig)paramString1.get(paramString3);
        AppMethodBeat.o(17739);
        return paramString1;
      }
    }
    AppMethodBeat.o(17739);
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
  
  public final Map<String, Map<String, DialogFeatureConfig>> getDialogConfigurations()
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
  
  public static class DialogFeatureConfig
  {
    private static final String DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR = "\\|";
    private static final String DIALOG_CONFIG_NAME_KEY = "name";
    private static final String DIALOG_CONFIG_URL_KEY = "url";
    private static final String DIALOG_CONFIG_VERSIONS_KEY = "versions";
    private String dialogName;
    private Uri fallbackUrl;
    private String featureName;
    private int[] featureVersionSpec;
    
    private DialogFeatureConfig(String paramString1, String paramString2, Uri paramUri, int[] paramArrayOfInt)
    {
      this.dialogName = paramString1;
      this.featureName = paramString2;
      this.fallbackUrl = paramUri;
      this.featureVersionSpec = paramArrayOfInt;
    }
    
    public static DialogFeatureConfig parseDialogConfig(JSONObject paramJSONObject)
    {
      Uri localUri = null;
      AppMethodBeat.i(17737);
      String str1 = paramJSONObject.optString("name");
      if (Utility.isNullOrEmpty(str1))
      {
        AppMethodBeat.o(17737);
        return null;
      }
      Object localObject = str1.split("\\|");
      if (localObject.length != 2)
      {
        AppMethodBeat.o(17737);
        return null;
      }
      str1 = localObject[0];
      localObject = localObject[1];
      if ((Utility.isNullOrEmpty(str1)) || (Utility.isNullOrEmpty((String)localObject)))
      {
        AppMethodBeat.o(17737);
        return null;
      }
      String str2 = paramJSONObject.optString("url");
      if (!Utility.isNullOrEmpty(str2)) {
        localUri = Uri.parse(str2);
      }
      paramJSONObject = new DialogFeatureConfig(str1, (String)localObject, localUri, parseVersionSpec(paramJSONObject.optJSONArray("versions")));
      AppMethodBeat.o(17737);
      return paramJSONObject;
    }
    
    private static int[] parseVersionSpec(JSONArray paramJSONArray)
    {
      AppMethodBeat.i(17738);
      int[] arrayOfInt = null;
      if (paramJSONArray != null)
      {
        int m = paramJSONArray.length();
        arrayOfInt = new int[m];
        int j = 0;
        for (;;)
        {
          if (j < m)
          {
            int k = paramJSONArray.optInt(j, -1);
            int i = k;
            String str;
            if (k == -1)
            {
              str = paramJSONArray.optString(j);
              i = k;
              if (Utility.isNullOrEmpty(str)) {}
            }
            try
            {
              i = Integer.parseInt(str);
              arrayOfInt[j] = i;
              j += 1;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                Utility.logd("FacebookSDK", localNumberFormatException);
                i = -1;
              }
            }
          }
        }
      }
      AppMethodBeat.o(17738);
      return arrayOfInt;
    }
    
    public String getDialogName()
    {
      return this.dialogName;
    }
    
    public Uri getFallbackUrl()
    {
      return this.fallbackUrl;
    }
    
    public String getFeatureName()
    {
      return this.featureName;
    }
    
    public int[] getVersionSpec()
    {
      return this.featureVersionSpec;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.internal.FetchedAppSettings
 * JD-Core Version:    0.7.0.1
 */