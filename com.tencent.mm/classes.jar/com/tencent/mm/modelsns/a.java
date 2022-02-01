package com.tencent.mm.modelsns;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.vq.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXGameVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.Set;

public final class a
{
  public static Set<String> jkO;
  
  private static Bitmap PF(String paramString)
  {
    AppMethodBeat.i(20652);
    vq localvq = new vq();
    localvq.ebN.ebP = paramString;
    EventCenter.instance.publish(localvq);
    paramString = (Bitmap)localvq.ebO.result;
    AppMethodBeat.o(20652);
    return paramString;
  }
  
  public static Intent a(int paramInt, WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(231571);
    Log.d("MicroMsg.ShareSnsImpl", "appmsg.description " + paramWXMediaMessage.description);
    Log.d("MicroMsg.ShareSnsImpl", "appmsg.title " + paramWXMediaMessage.title);
    Object localObject1 = paramWXMediaMessage.mediaObject;
    int i;
    switch (((WXMediaMessage.IMediaObject)localObject1).type())
    {
    default: 
      i = -1;
    }
    Intent localIntent;
    for (;;)
    {
      localIntent = new Intent();
      localIntent.putExtra("KThrid_app", true);
      Log.d("MicroMsg.ShareSnsImpl", "TimeLineType " + i + " " + ((WXMediaMessage.IMediaObject)localObject1).type());
      localIntent.putExtra("Ksnsupload_appid", paramString1);
      localIntent.putExtra("Ksnsupload_appname", paramString2);
      localIntent.putExtra("Ksnsupload_open_sdk_version", paramInt);
      localIntent.putExtra("KSnsAction", true);
      localIntent.putExtra("need_result", true);
      localIntent.putExtra("Ksnsupload_app_is_game", paramBoolean);
      paramString1 = new Bundle();
      paramString2 = new SendMessageToWX.Req();
      paramString2.message = paramWXMediaMessage;
      paramString2.toBundle(paramString1);
      localIntent.putExtra("Ksnsupload_timeline", paramString1);
      if (i != -1) {
        break;
      }
      Log.d("MicroMsg.ShareSnsImpl", "timeLineType is invalid");
      AppMethodBeat.o(231571);
      return null;
      i = 2;
      continue;
      i = 4;
      continue;
      i = 42;
      continue;
      i = 1;
      continue;
      i = 3;
      continue;
      i = 5;
      continue;
      i = 3;
      continue;
      i = 15;
    }
    switch (((WXMediaMessage.IMediaObject)localObject1).type())
    {
    default: 
      Log.e("MicroMsg.ShareSnsImpl", "none type not support!");
      AppMethodBeat.o(231571);
      return null;
    case 1: 
      localIntent.putExtra("Kdescription", ((WXTextObject)localObject1).text);
      localIntent.putExtra("Ksnsupload_type", 8);
      AppMethodBeat.o(231571);
      return localIntent;
    case 3: 
      paramString1 = (WXMusicObject)localObject1;
      if (!Util.isNullOrNil(paramString1.musicUrl)) {}
      for (paramWXMediaMessage = paramString1.musicUrl;; paramWXMediaMessage = paramString1.musicLowBandUrl)
      {
        paramString2 = Util.nullAs(paramWXMediaMessage, "");
        if (tN(3) != -1) {
          break;
        }
        Log.d("MicroMsg.ShareSnsImpl", "mediaType is invalid");
        AppMethodBeat.o(231571);
        return null;
      }
      if (!Util.isNullOrNil(paramString1.musicDataUrl))
      {
        paramWXMediaMessage = paramString1.musicDataUrl;
        Util.nullAs(paramWXMediaMessage, "");
        if (Util.isNullOrNil(paramString1.musicLowBandDataUrl)) {
          break label675;
        }
      }
      for (paramWXMediaMessage = paramString1.musicLowBandDataUrl;; paramWXMediaMessage = paramString1.musicLowBandUrl)
      {
        Util.nullAs(paramWXMediaMessage, "");
        localIntent.putExtra("Ksnsupload_link", paramString2);
        localIntent.putExtra("Ksnsupload_title", "");
        localIntent.putExtra("Ksnsupload_type", 2);
        localIntent.putExtra("ksnsis_music", true);
        AppMethodBeat.o(231571);
        return localIntent;
        paramWXMediaMessage = paramString1.musicUrl;
        break;
      }
    case 76: 
      paramWXMediaMessage = Util.nullAs(((WXMusicVideoObject)localObject1).musicUrl, "");
      if (tN(76) == -1)
      {
        Log.d("MicroMsg.ShareSnsImpl", "mediaType is invalid");
        AppMethodBeat.o(231571);
        return null;
      }
      localIntent.putExtra("Ksnsupload_link", paramWXMediaMessage);
      localIntent.putExtra("Ksnsupload_title", "");
      localIntent.putExtra("Ksnsupload_type", 25);
      localIntent.putExtra("ksnsis_music", true);
      if (paramBundle != null) {
        localIntent.putExtra("music_mv_cover_url", paramBundle.getString("music_mv_cover_url", ""));
      }
      AppMethodBeat.o(231571);
      return localIntent;
    case 2: 
      paramWXMediaMessage = (WXImageObject)localObject1;
      localIntent.putExtra("KBlockAdd", true);
      localIntent.putExtra("Ksnsupload_type", 0);
      localIntent.putExtra("sns_kemdia_path", paramWXMediaMessage.imagePath);
      AppMethodBeat.o(231571);
      return localIntent;
    case 5: 
      localIntent.putExtra("Ksnsupload_link", ((WXWebpageObject)localObject1).webpageUrl);
      localIntent.putExtra("Ksnsupload_title", Util.nullAs(paramWXMediaMessage.title, ""));
      localIntent.putExtra("Ksnsupload_imgbuf", paramWXMediaMessage.thumbData);
      localIntent.putExtra("Ksnsupload_type", 1);
      AppMethodBeat.o(231571);
      return localIntent;
    case 6: 
      Log.e("MicroMsg.ShareSnsImpl", "file is not support!");
      AppMethodBeat.o(231571);
      return null;
    case 4: 
      paramWXMediaMessage = (WXVideoObject)localObject1;
      if (!Util.isNullOrNil(paramWXMediaMessage.videoUrl)) {}
      for (paramWXMediaMessage = paramWXMediaMessage.videoUrl;; paramWXMediaMessage = paramWXMediaMessage.videoLowBandUrl)
      {
        paramWXMediaMessage = Util.nullAs(paramWXMediaMessage, "");
        if (tN(3) != -1) {
          break;
        }
        Log.d("MicroMsg.ShareSnsImpl", "mediaType is invalid");
        AppMethodBeat.o(231571);
        return null;
      }
      localIntent.putExtra("Ksnsupload_link", paramWXMediaMessage);
      localIntent.putExtra("Ksnsupload_title", "");
      localIntent.putExtra("Ksnsupload_type", 1);
      localIntent.putExtra("ksnsis_video", true);
      AppMethodBeat.o(231571);
      return localIntent;
    case 38: 
      paramWXMediaMessage = (WXVideoFileObject)localObject1;
      localIntent.putExtra("KBlockAdd", true);
      localIntent.putExtra("Ksnsupload_type", 14);
      paramString1 = paramWXMediaMessage.filePath;
      paramWXMediaMessage = "";
      paramString2 = s.bhK(paramString1);
      if ((Util.isNullOrNil("")) || (!s.YS("")))
      {
        paramWXMediaMessage = new StringBuilder();
        bg.aVF();
        paramWXMediaMessage = c.getAccSnsTmpPath() + paramString2;
      }
      try
      {
        paramBundle = PF(paramString1);
        if (paramBundle == null) {
          break label1229;
        }
        Log.i("MicroMsg.ShareSnsImpl", "getBitmap1 %d %d", new Object[] { Integer.valueOf(paramBundle.getWidth()), Integer.valueOf(paramBundle.getHeight()) });
        BitmapUtil.saveBitmapToImage(paramBundle, 80, Bitmap.CompressFormat.JPEG, paramWXMediaMessage, true);
        paramBundle = BitmapUtil.getImageOptions(paramWXMediaMessage);
        Log.i("MicroMsg.ShareSnsImpl", "getBitmap2 %d %d", new Object[] { Integer.valueOf(paramBundle.outWidth), Integer.valueOf(paramBundle.outHeight) });
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          Log.e("MicroMsg.ShareSnsImpl", "savebitmap error %s", new Object[] { paramBundle.getMessage() });
        }
      }
      localIntent.putExtra("KSightPath", paramString1);
      localIntent.putExtra("KSightThumbPath", paramWXMediaMessage);
      localIntent.putExtra("sight_md5", paramString2);
      AppMethodBeat.o(231571);
      return localIntent;
      Log.e("MicroMsg.ShareSnsImpl", "thumb null , videoPath %s ", new Object[] { paramString1 });
      AppMethodBeat.o(231571);
      return null;
    case 39: 
      label675:
      label1229:
      paramWXMediaMessage = (WXGameVideoFileObject)localObject1;
      localIntent.putExtra("KBlockAdd", true);
      localIntent.putExtra("Ksnsupload_type", 14);
      paramString1 = paramWXMediaMessage.filePath;
      paramString2 = paramWXMediaMessage.videoUrl;
      paramBundle = paramWXMediaMessage.thumbUrl;
      Log.i("MicroMsg.ShareSnsImpl", "videoPath %s,thumbPath %s,cdnUrl %s,cdnThumbUrl %s", new Object[] { paramString1, "", paramString2, paramBundle });
      localObject1 = s.bhK(paramString1);
      if ((Util.isNullOrNil("")) || (!s.YS("")))
      {
        paramWXMediaMessage = new StringBuilder();
        bg.aVF();
      }
      break;
    }
    for (paramWXMediaMessage = c.getAccSnsTmpPath() + (String)localObject1;; paramWXMediaMessage = "")
    {
      try
      {
        Object localObject2 = PF(paramString1);
        if (localObject2 == null) {
          break label1556;
        }
        Log.i("MicroMsg.ShareSnsImpl", "getBitmap1 %d %d", new Object[] { Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()) });
        BitmapUtil.saveBitmapToImage((Bitmap)localObject2, 80, Bitmap.CompressFormat.JPEG, paramWXMediaMessage, true);
        localObject2 = BitmapUtil.getImageOptions(paramWXMediaMessage);
        Log.i("MicroMsg.ShareSnsImpl", "getBitmap2 %d %d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject2).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject2).outHeight) });
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label1556:
          Log.e("MicroMsg.ShareSnsImpl", "savebitmap error %s", new Object[] { localException.getMessage() });
        }
      }
      localIntent.putExtra("KSightPath", paramString1);
      localIntent.putExtra("KSightThumbPath", paramWXMediaMessage);
      localIntent.putExtra("sight_md5", (String)localObject1);
      localIntent.putExtra("KSightCdnUrl", paramString2);
      localIntent.putExtra("KSightCdnThumbUrl", paramBundle);
      AppMethodBeat.o(231571);
      return localIntent;
      Log.e("MicroMsg.ShareSnsImpl", "thumb null , videoPath %s ", new Object[] { paramString1 });
      AppMethodBeat.o(231571);
      return null;
      AppMethodBeat.o(231571);
      return null;
    }
  }
  
  private static int tN(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 1;
    case 3: 
      return 3;
    case 76: 
      return 5;
    case 2: 
      return 2;
    case 4: 
      return 4;
    }
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsns.a
 * JD-Core Version:    0.7.0.1
 */