package com.facebook.internal;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;

public class FetchedAppSettings$DialogFeatureConfig
{
  private static final String DIALOG_CONFIG_DIALOG_NAME_FEATURE_NAME_SEPARATOR = "\\|";
  private static final String DIALOG_CONFIG_NAME_KEY = "name";
  private static final String DIALOG_CONFIG_URL_KEY = "url";
  private static final String DIALOG_CONFIG_VERSIONS_KEY = "versions";
  private String dialogName;
  private Uri fallbackUrl;
  private String featureName;
  private int[] featureVersionSpec;
  
  private FetchedAppSettings$DialogFeatureConfig(String paramString1, String paramString2, Uri paramUri, int[] paramArrayOfInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.internal.FetchedAppSettings.DialogFeatureConfig
 * JD-Core Version:    0.7.0.1
 */