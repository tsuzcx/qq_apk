package com.tencent.mm.opensdk.modelmsg;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.io.ByteArrayOutputStream;

public final class WXMediaMessage
{
  public static final String ACTION_WXAPPMESSAGE = "com.tencent.mm.sdk.openapi.Intent.ACTION_WXAPPMESSAGE";
  public static final int DESCRIPTION_LENGTH_LIMIT = 1024;
  public static final int MEDIA_TAG_NAME_LENGTH_LIMIT = 64;
  public static final int MESSAGE_ACTION_LENGTH_LIMIT = 2048;
  public static final int MESSAGE_EXT_LENGTH_LIMIT = 2048;
  public static final int MINI_PROGRAM__THUMB_LENGHT = 131072;
  private static final String TAG = "MicroMsg.SDK.WXMediaMessage";
  public static final int THUMB_LENGTH_LIMIT = 65536;
  public static final int TITLE_LENGTH_LIMIT = 512;
  public String description;
  public IMediaObject mediaObject;
  public String mediaTagName;
  public String messageAction;
  public String messageExt;
  public int sdkVer;
  public byte[] thumbData;
  public String title;
  
  public WXMediaMessage()
  {
    this(null);
  }
  
  public WXMediaMessage(IMediaObject paramIMediaObject)
  {
    AppMethodBeat.i(196988);
    this.mediaObject = paramIMediaObject;
    AppMethodBeat.o(196988);
  }
  
  final boolean checkArgs()
  {
    AppMethodBeat.i(3993);
    if (getType() == 8)
    {
      localObject = this.thumbData;
      if ((localObject == null) || (localObject.length == 0))
      {
        Log.e("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, thumbData should not be null when send emoji");
        AppMethodBeat.o(3993);
        return false;
      }
    }
    if (b.a(getType()))
    {
      localObject = this.thumbData;
      if ((localObject == null) || (localObject.length > 131072))
      {
        Log.e("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, thumbData should not be null or exceed 128kb");
        AppMethodBeat.o(3993);
        return false;
      }
    }
    if (!b.a(getType()))
    {
      localObject = this.thumbData;
      if ((localObject != null) && (localObject.length > 65536))
      {
        Log.e("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, thumbData is invalid");
        AppMethodBeat.o(3993);
        return false;
      }
    }
    Object localObject = this.title;
    if ((localObject != null) && (((String)localObject).length() > 512))
    {
      Log.e("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, title is invalid");
      AppMethodBeat.o(3993);
      return false;
    }
    localObject = this.description;
    if ((localObject != null) && (((String)localObject).length() > 1024))
    {
      Log.e("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, description is invalid");
      AppMethodBeat.o(3993);
      return false;
    }
    if (this.mediaObject == null)
    {
      Log.e("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, mediaObject is null");
      AppMethodBeat.o(3993);
      return false;
    }
    localObject = this.mediaTagName;
    if ((localObject != null) && (((String)localObject).length() > 64))
    {
      Log.e("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, mediaTagName is too long");
      AppMethodBeat.o(3993);
      return false;
    }
    localObject = this.messageAction;
    if ((localObject != null) && (((String)localObject).length() > 2048))
    {
      Log.e("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, messageAction is too long");
      AppMethodBeat.o(3993);
      return false;
    }
    localObject = this.messageExt;
    if ((localObject != null) && (((String)localObject).length() > 2048))
    {
      Log.e("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, messageExt is too long");
      AppMethodBeat.o(3993);
      return false;
    }
    boolean bool = this.mediaObject.checkArgs();
    AppMethodBeat.o(3993);
    return bool;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(3991);
    IMediaObject localIMediaObject = this.mediaObject;
    if (localIMediaObject == null)
    {
      AppMethodBeat.o(3991);
      return 0;
    }
    int i = localIMediaObject.type();
    AppMethodBeat.o(3991);
    return i;
  }
  
  public final void setThumbImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(3992);
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, localByteArrayOutputStream);
      this.thumbData = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      AppMethodBeat.o(3992);
      return;
    }
    catch (Exception paramBitmap)
    {
      Log.e("MicroMsg.SDK.WXMediaMessage", "setThumbImage exception:" + paramBitmap.getMessage());
      AppMethodBeat.o(3992);
    }
  }
  
  public static class Builder
  {
    public static final String KEY_IDENTIFIER = "_wxobject_identifier_";
    
    public static WXMediaMessage fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(4029);
      WXMediaMessage localWXMediaMessage = new WXMediaMessage();
      localWXMediaMessage.sdkVer = paramBundle.getInt("_wxobject_sdkVer");
      localWXMediaMessage.title = paramBundle.getString("_wxobject_title");
      localWXMediaMessage.description = paramBundle.getString("_wxobject_description");
      localWXMediaMessage.thumbData = paramBundle.getByteArray("_wxobject_thumbdata");
      localWXMediaMessage.mediaTagName = paramBundle.getString("_wxobject_mediatagname");
      localWXMediaMessage.messageAction = paramBundle.getString("_wxobject_message_action");
      localWXMediaMessage.messageExt = paramBundle.getString("_wxobject_message_ext");
      String str = pathOldToNew(paramBundle.getString("_wxobject_identifier_"));
      if ((str != null) && (str.length() > 0)) {
        try
        {
          WXMediaMessage.IMediaObject localIMediaObject = (WXMediaMessage.IMediaObject)Class.forName(str).newInstance();
          localWXMediaMessage.mediaObject = localIMediaObject;
          localIMediaObject.unserialize(paramBundle);
          AppMethodBeat.o(4029);
          return localWXMediaMessage;
        }
        catch (Exception paramBundle)
        {
          Log.e("MicroMsg.SDK.WXMediaMessage", "get media object from bundle failed: unknown ident " + str + ", ex = " + paramBundle.getMessage());
          AppMethodBeat.o(4029);
          return localWXMediaMessage;
        }
      }
      AppMethodBeat.o(4029);
      return localWXMediaMessage;
    }
    
    private static String pathNewToOld(String paramString)
    {
      AppMethodBeat.i(4030);
      if ((paramString != null) && (paramString.length() != 0))
      {
        paramString = paramString.replace("com.tencent.mm.opensdk.modelmsg", "com.tencent.mm.sdk.openapi");
        AppMethodBeat.o(4030);
        return paramString;
      }
      Log.e("MicroMsg.SDK.WXMediaMessage", "pathNewToOld fail, newPath is null");
      AppMethodBeat.o(4030);
      return paramString;
    }
    
    private static String pathOldToNew(String paramString)
    {
      AppMethodBeat.i(4031);
      Log.i("MicroMsg.SDK.WXMediaMessage", "pathOldToNew, oldPath = ".concat(String.valueOf(paramString)));
      if ((paramString != null) && (paramString.length() != 0))
      {
        int i = paramString.lastIndexOf('.');
        if (i == -1)
        {
          Log.e("MicroMsg.SDK.WXMediaMessage", "pathOldToNew fail, invalid pos, oldPath = ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(4031);
          return paramString;
        }
        paramString = "com.tencent.mm.opensdk.modelmsg" + paramString.substring(i);
        AppMethodBeat.o(4031);
        return paramString;
      }
      Log.e("MicroMsg.SDK.WXMediaMessage", "pathOldToNew fail, oldPath is null");
      AppMethodBeat.o(4031);
      return paramString;
    }
    
    public static Bundle toBundle(WXMediaMessage paramWXMediaMessage)
    {
      AppMethodBeat.i(4028);
      Bundle localBundle = new Bundle();
      localBundle.putInt("_wxobject_sdkVer", paramWXMediaMessage.sdkVer);
      localBundle.putString("_wxobject_title", paramWXMediaMessage.title);
      localBundle.putString("_wxobject_description", paramWXMediaMessage.description);
      localBundle.putByteArray("_wxobject_thumbdata", paramWXMediaMessage.thumbData);
      WXMediaMessage.IMediaObject localIMediaObject = paramWXMediaMessage.mediaObject;
      if (localIMediaObject != null)
      {
        localBundle.putString("_wxobject_identifier_", pathNewToOld(localIMediaObject.getClass().getName()));
        paramWXMediaMessage.mediaObject.serialize(localBundle);
      }
      localBundle.putString("_wxobject_mediatagname", paramWXMediaMessage.mediaTagName);
      localBundle.putString("_wxobject_message_action", paramWXMediaMessage.messageAction);
      localBundle.putString("_wxobject_message_ext", paramWXMediaMessage.messageExt);
      AppMethodBeat.o(4028);
      return localBundle;
    }
  }
  
  public static abstract interface IMediaObject
  {
    public static final int TYPE_APPBRAND = 33;
    public static final int TYPE_APPDATA = 7;
    public static final int TYPE_BUSINESS_CARD = 45;
    public static final int TYPE_CARD_SHARE = 16;
    public static final int TYPE_DESIGNER_SHARED = 25;
    public static final int TYPE_DEVICE_ACCESS = 12;
    public static final int TYPE_EMOJI = 8;
    public static final int TYPE_EMOJILIST_SHARED = 27;
    public static final int TYPE_EMOTICON_GIFT = 11;
    public static final int TYPE_EMOTICON_SHARED = 15;
    public static final int TYPE_EMOTIONLIST_SHARED = 26;
    public static final int TYPE_FILE = 6;
    public static final int TYPE_GAME_VIDEO_FILE = 39;
    public static final int TYPE_GIFTCARD = 34;
    public static final int TYPE_IMAGE = 2;
    public static final int TYPE_LOCATION = 30;
    public static final int TYPE_LOCATION_SHARE = 17;
    public static final int TYPE_MALL_PRODUCT = 13;
    public static final int TYPE_MUSIC = 3;
    public static final int TYPE_NOTE = 24;
    public static final int TYPE_OLD_TV = 14;
    public static final int TYPE_OPENSDK_APPBRAND = 36;
    public static final int TYPE_OPENSDK_APPBRAND_WEISHIVIDEO = 46;
    public static final int TYPE_OPENSDK_LITEAPP = 68;
    public static final int TYPE_OPENSDK_WEWORK_OBJECT = 49;
    public static final int TYPE_PRODUCT = 10;
    public static final int TYPE_RECORD = 19;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_TV = 20;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_URL = 5;
    public static final int TYPE_VIDEO = 4;
    public static final int TYPE_VIDEO_FILE = 38;
    
    public abstract boolean checkArgs();
    
    public abstract void serialize(Bundle paramBundle);
    
    public abstract int type();
    
    public abstract void unserialize(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXMediaMessage
 * JD-Core Version:    0.7.0.1
 */