package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;

public class WXMediaMessage$Builder
{
  public static final String KEY_IDENTIFIER = "_wxobject_identifier_";
  
  public static WXMediaMessage fromBundle(Bundle paramBundle)
  {
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    localWXMediaMessage.sdkVer = paramBundle.getInt("_wxobject_sdkVer");
    localWXMediaMessage.title = paramBundle.getString("_wxobject_title");
    localWXMediaMessage.description = paramBundle.getString("_wxobject_description");
    localWXMediaMessage.thumbData = paramBundle.getByteArray("_wxobject_thumbdata");
    localWXMediaMessage.mediaTagName = paramBundle.getString("_wxobject_mediatagname");
    localWXMediaMessage.messageAction = paramBundle.getString("_wxobject_message_action");
    localWXMediaMessage.messageExt = paramBundle.getString("_wxobject_message_ext");
    String str = pathOldToNew(paramBundle.getString("_wxobject_identifier_"));
    if ((str == null) || (str.length() <= 0)) {
      return localWXMediaMessage;
    }
    try
    {
      localWXMediaMessage.mediaObject = ((WXMediaMessage.IMediaObject)Class.forName(str).newInstance());
      localWXMediaMessage.mediaObject.unserialize(paramBundle);
      return localWXMediaMessage;
    }
    catch (Exception paramBundle)
    {
      Log.e("MicroMsg.SDK.WXMediaMessage", "get media object from bundle failed: unknown ident " + str + ", ex = " + paramBundle.getMessage());
    }
    return localWXMediaMessage;
  }
  
  private static String pathNewToOld(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.SDK.WXMediaMessage", "pathNewToOld fail, newPath is null");
      return paramString;
    }
    return paramString.replace("com.tencent.mm.opensdk.modelmsg", "com.tencent.mm.sdk.openapi");
  }
  
  private static String pathOldToNew(String paramString)
  {
    Log.i("MicroMsg.SDK.WXMediaMessage", "pathOldToNew, oldPath = " + paramString);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.SDK.WXMediaMessage", "pathOldToNew fail, oldPath is null");
      return paramString;
    }
    int i = paramString.lastIndexOf('.');
    if (i == -1)
    {
      Log.e("MicroMsg.SDK.WXMediaMessage", "pathOldToNew fail, invalid pos, oldPath = " + paramString);
      return paramString;
    }
    return "com.tencent.mm.opensdk.modelmsg" + paramString.substring(i);
  }
  
  public static Bundle toBundle(WXMediaMessage paramWXMediaMessage)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("_wxobject_sdkVer", paramWXMediaMessage.sdkVer);
    localBundle.putString("_wxobject_title", paramWXMediaMessage.title);
    localBundle.putString("_wxobject_description", paramWXMediaMessage.description);
    localBundle.putByteArray("_wxobject_thumbdata", paramWXMediaMessage.thumbData);
    if (paramWXMediaMessage.mediaObject != null)
    {
      localBundle.putString("_wxobject_identifier_", pathNewToOld(paramWXMediaMessage.mediaObject.getClass().getName()));
      paramWXMediaMessage.mediaObject.serialize(localBundle);
    }
    localBundle.putString("_wxobject_mediatagname", paramWXMediaMessage.mediaTagName);
    localBundle.putString("_wxobject_message_action", paramWXMediaMessage.messageAction);
    localBundle.putString("_wxobject_message_ext", paramWXMediaMessage.messageExt);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXMediaMessage.Builder
 * JD-Core Version:    0.7.0.1
 */