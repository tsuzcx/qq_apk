package com.tencent.mm.modelsns;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uo;
import com.tencent.mm.g.a.uo.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXGameVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.vfs.i;
import java.util.Set;

public final class a
{
  public static Set<String> imN;
  
  private static Bitmap Gq(String paramString)
  {
    AppMethodBeat.i(20652);
    uo localuo = new uo();
    localuo.dIM.dIO = paramString;
    com.tencent.mm.sdk.b.a.IbL.l(localuo);
    paramString = (Bitmap)localuo.dIN.result;
    AppMethodBeat.o(20652);
    return paramString;
  }
  
  public static Intent a(int paramInt, WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(20651);
    ad.d("MicroMsg.ShareSnsImpl", "appmsg.description " + paramWXMediaMessage.description);
    ad.d("MicroMsg.ShareSnsImpl", "appmsg.title " + paramWXMediaMessage.title);
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
      ad.d("MicroMsg.ShareSnsImpl", "TimeLineType " + i + " " + ((WXMediaMessage.IMediaObject)localObject1).type());
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
      ad.d("MicroMsg.ShareSnsImpl", "timeLineType is invalid");
      AppMethodBeat.o(20651);
      return null;
      i = 2;
      continue;
      i = 4;
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
    label541:
    label624:
    label632:
    String str1;
    label1061:
    String str2;
    switch (((WXMediaMessage.IMediaObject)localObject1).type())
    {
    default: 
      ad.e("MicroMsg.ShareSnsImpl", "none type not support!");
      AppMethodBeat.o(20651);
      return null;
    case 1: 
      localIntent.putExtra("Kdescription", ((WXTextObject)localObject1).text);
      localIntent.putExtra("Ksnsupload_type", 8);
      AppMethodBeat.o(20651);
      return localIntent;
    case 3: 
      paramString1 = (WXMusicObject)localObject1;
      if (!bt.isNullOrNil(paramString1.musicUrl))
      {
        paramWXMediaMessage = paramString1.musicUrl;
        paramString2 = bt.bI(paramWXMediaMessage, "");
        if (bt.isNullOrNil(paramString1.musicDataUrl)) {
          break label624;
        }
        paramWXMediaMessage = paramString1.musicDataUrl;
        bt.bI(paramWXMediaMessage, "");
        if (bt.isNullOrNil(paramString1.musicLowBandDataUrl)) {
          break label632;
        }
      }
      for (paramWXMediaMessage = paramString1.musicLowBandDataUrl;; paramWXMediaMessage = paramString1.musicLowBandUrl)
      {
        bt.bI(paramWXMediaMessage, "");
        localIntent.putExtra("Ksnsupload_link", paramString2);
        localIntent.putExtra("Ksnsupload_title", "");
        localIntent.putExtra("Ksnsupload_type", 2);
        localIntent.putExtra("ksnsis_music", true);
        AppMethodBeat.o(20651);
        return localIntent;
        paramWXMediaMessage = paramString1.musicLowBandUrl;
        break;
        paramWXMediaMessage = paramString1.musicUrl;
        break label541;
      }
    case 2: 
      paramWXMediaMessage = (WXImageObject)localObject1;
      localIntent.putExtra("KBlockAdd", true);
      localIntent.putExtra("Ksnsupload_type", 0);
      localIntent.putExtra("sns_kemdia_path", paramWXMediaMessage.imagePath);
      AppMethodBeat.o(20651);
      return localIntent;
    case 5: 
      localIntent.putExtra("Ksnsupload_link", ((WXWebpageObject)localObject1).webpageUrl);
      localIntent.putExtra("Ksnsupload_title", bt.bI(paramWXMediaMessage.title, ""));
      localIntent.putExtra("Ksnsupload_imgbuf", paramWXMediaMessage.thumbData);
      localIntent.putExtra("Ksnsupload_type", 1);
      AppMethodBeat.o(20651);
      return localIntent;
    case 6: 
      ad.e("MicroMsg.ShareSnsImpl", "file is not support!");
      AppMethodBeat.o(20651);
      return null;
    case 4: 
      paramWXMediaMessage = (WXVideoObject)localObject1;
      if (!bt.isNullOrNil(paramWXMediaMessage.videoUrl)) {}
      for (paramWXMediaMessage = paramWXMediaMessage.videoUrl;; paramWXMediaMessage = paramWXMediaMessage.videoLowBandUrl)
      {
        localIntent.putExtra("Ksnsupload_link", bt.bI(paramWXMediaMessage, ""));
        localIntent.putExtra("Ksnsupload_title", "");
        localIntent.putExtra("Ksnsupload_type", 1);
        localIntent.putExtra("ksnsis_video", true);
        AppMethodBeat.o(20651);
        return localIntent;
      }
    case 38: 
      paramWXMediaMessage = (WXVideoFileObject)localObject1;
      localIntent.putExtra("KBlockAdd", true);
      localIntent.putExtra("Ksnsupload_type", 14);
      paramString1 = paramWXMediaMessage.filePath;
      paramWXMediaMessage = "";
      paramString2 = i.aPK(paramString1);
      if ((bt.isNullOrNil("")) || (!i.fv("")))
      {
        paramWXMediaMessage = new StringBuilder();
        ba.aBQ();
        paramWXMediaMessage = c.getAccSnsTmpPath() + paramString2;
      }
      try
      {
        localObject1 = Gq(paramString1);
        if (localObject1 == null) {
          break label1061;
        }
        ad.i("MicroMsg.ShareSnsImpl", "getBitmap1 %d %d", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()) });
        g.a((Bitmap)localObject1, 80, Bitmap.CompressFormat.JPEG, paramWXMediaMessage, true);
        localObject1 = g.aQc(paramWXMediaMessage);
        ad.i("MicroMsg.ShareSnsImpl", "getBitmap2 %d %d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject1).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject1).outHeight) });
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          ad.e("MicroMsg.ShareSnsImpl", "savebitmap error %s", new Object[] { localException1.getMessage() });
        }
      }
      localIntent.putExtra("KSightPath", paramString1);
      localIntent.putExtra("KSightThumbPath", paramWXMediaMessage);
      localIntent.putExtra("sight_md5", paramString2);
      AppMethodBeat.o(20651);
      return localIntent;
      ad.e("MicroMsg.ShareSnsImpl", "thumb null , videoPath %s ", new Object[] { paramString1 });
      AppMethodBeat.o(20651);
      return null;
    case 39: 
      paramWXMediaMessage = (WXGameVideoFileObject)localException1;
      localIntent.putExtra("KBlockAdd", true);
      localIntent.putExtra("Ksnsupload_type", 14);
      paramString1 = paramWXMediaMessage.filePath;
      paramString2 = paramWXMediaMessage.videoUrl;
      str1 = paramWXMediaMessage.thumbUrl;
      ad.i("MicroMsg.ShareSnsImpl", "videoPath %s,thumbPath %s,cdnUrl %s,cdnThumbUrl %s", new Object[] { paramString1, "", paramString2, str1 });
      str2 = i.aPK(paramString1);
      if ((bt.isNullOrNil("")) || (!i.fv("")))
      {
        paramWXMediaMessage = new StringBuilder();
        ba.aBQ();
      }
      break;
    }
    for (paramWXMediaMessage = c.getAccSnsTmpPath() + str2;; paramWXMediaMessage = "")
    {
      try
      {
        Object localObject2 = Gq(paramString1);
        if (localObject2 == null) {
          break label1390;
        }
        ad.i("MicroMsg.ShareSnsImpl", "getBitmap1 %d %d", new Object[] { Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()) });
        g.a((Bitmap)localObject2, 80, Bitmap.CompressFormat.JPEG, paramWXMediaMessage, true);
        localObject2 = g.aQc(paramWXMediaMessage);
        ad.i("MicroMsg.ShareSnsImpl", "getBitmap2 %d %d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject2).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject2).outHeight) });
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          label1390:
          ad.e("MicroMsg.ShareSnsImpl", "savebitmap error %s", new Object[] { localException2.getMessage() });
        }
      }
      localIntent.putExtra("KSightPath", paramString1);
      localIntent.putExtra("KSightThumbPath", paramWXMediaMessage);
      localIntent.putExtra("sight_md5", str2);
      localIntent.putExtra("KSightCdnUrl", paramString2);
      localIntent.putExtra("KSightCdnThumbUrl", str1);
      AppMethodBeat.o(20651);
      return localIntent;
      ad.e("MicroMsg.ShareSnsImpl", "thumb null , videoPath %s ", new Object[] { paramString1 });
      AppMethodBeat.o(20651);
      return null;
      AppMethodBeat.o(20651);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsns.a
 * JD-Core Version:    0.7.0.1
 */