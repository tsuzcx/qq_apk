package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;

public class WXMediaMessage$Builder
{
  public static final String KEY_IDENTIFIER = "_wxobject_identifier_";
  
  public static WXMediaMessage fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128329);
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    localWXMediaMessage.sdkVer = paramBundle.getInt("_wxobject_sdkVer");
    localWXMediaMessage.title = paramBundle.getString("_wxobject_title");
    localWXMediaMessage.description = paramBundle.getString("_wxobject_description");
    localWXMediaMessage.thumbData = paramBundle.getByteArray("_wxobject_thumbdata");
    localWXMediaMessage.mediaTagName = paramBundle.getString("_wxobject_mediatagname");
    localWXMediaMessage.messageAction = paramBundle.getString("_wxobject_message_action");
    localWXMediaMessage.messageExt = paramBundle.getString("_wxobject_message_ext");
    String str = pathOldToNew(paramBundle.getString("_wxobject_identifier_"));
    if ((str == null) || (str.length() <= 0))
    {
      AppMethodBeat.o(128329);
      return localWXMediaMessage;
    }
    try
    {
      localWXMediaMessage.mediaObject = ((WXMediaMessage.IMediaObject)Class.forName(str).newInstance());
      localWXMediaMessage.mediaObject.unserialize(paramBundle);
      AppMethodBeat.o(128329);
      return localWXMediaMessage;
    }
    catch (Exception paramBundle)
    {
      Log.e("MicroMsg.SDK.WXMediaMessage", "get media object from bundle failed: unknown ident " + str + ", ex = " + paramBundle.getMessage());
      AppMethodBeat.o(128329);
    }
    return localWXMediaMessage;
  }
  
  private static String pathNewToOld(String paramString)
  {
    AppMethodBeat.i(128330);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.SDK.WXMediaMessage", "pathNewToOld fail, newPath is null");
      AppMethodBeat.o(128330);
      return paramString;
    }
    paramString = paramString.replace("com.tencent.mm.opensdk.modelmsg", "com.tencent.mm.sdk.openapi");
    AppMethodBeat.o(128330);
    return paramString;
  }
  
  private static String pathOldToNew(String paramString)
  {
    AppMethodBeat.i(128331);
    Log.i("MicroMsg.SDK.WXMediaMessage", "pathOldToNew, oldPath = ".concat(String.valueOf(paramString)));
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.SDK.WXMediaMessage", "pathOldToNew fail, oldPath is null");
      AppMethodBeat.o(128331);
      return paramString;
    }
    int i = paramString.lastIndexOf('.');
    if (i == -1)
    {
      Log.e("MicroMsg.SDK.WXMediaMessage", "pathOldToNew fail, invalid pos, oldPath = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(128331);
      return paramString;
    }
    paramString = "com.tencent.mm.opensdk.modelmsg" + paramString.substring(i);
    AppMethodBeat.o(128331);
    return paramString;
  }
  
  public static Bundle toBundle(WXMediaMessage paramWXMediaMessage)
  {
    AppMethodBeat.i(128328);
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
    AppMethodBeat.o(128328);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXMediaMessage.Builder
 * JD-Core Version:    0.7.0.1
 */