package com.tencent.mm.modelsns;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rs;
import com.tencent.mm.g.a.rs.b;
import com.tencent.mm.model.aw;
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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.e.j;
import com.tencent.mm.vfs.e;
import java.util.Set;

public final class a
{
  public static Set<String> fQm;
  
  public static Intent a(int paramInt, WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(16607);
    ab.d("MicroMsg.ShareSnsImpl", "appmsg.description " + paramWXMediaMessage.description);
    ab.d("MicroMsg.ShareSnsImpl", "appmsg.title " + paramWXMediaMessage.title);
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
      ab.d("MicroMsg.ShareSnsImpl", "TimeLineType " + i + " " + ((WXMediaMessage.IMediaObject)localObject1).type());
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
      ab.d("MicroMsg.ShareSnsImpl", "timeLineType is invalid");
      AppMethodBeat.o(16607);
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
    label544:
    label627:
    label635:
    String str1;
    label1062:
    String str2;
    switch (((WXMediaMessage.IMediaObject)localObject1).type())
    {
    default: 
      ab.e("MicroMsg.ShareSnsImpl", "none type not support!");
      AppMethodBeat.o(16607);
      return null;
    case 1: 
      paramWXMediaMessage = (WXTextObject)localObject1;
      localIntent.putExtra(e.j.yVi, paramWXMediaMessage.text);
      localIntent.putExtra("Ksnsupload_type", 8);
      AppMethodBeat.o(16607);
      return localIntent;
    case 3: 
      paramString1 = (WXMusicObject)localObject1;
      if (!bo.isNullOrNil(paramString1.musicUrl))
      {
        paramWXMediaMessage = paramString1.musicUrl;
        paramString2 = bo.bf(paramWXMediaMessage, "");
        if (bo.isNullOrNil(paramString1.musicDataUrl)) {
          break label627;
        }
        paramWXMediaMessage = paramString1.musicDataUrl;
        bo.bf(paramWXMediaMessage, "");
        if (bo.isNullOrNil(paramString1.musicLowBandDataUrl)) {
          break label635;
        }
      }
      for (paramWXMediaMessage = paramString1.musicLowBandDataUrl;; paramWXMediaMessage = paramString1.musicLowBandUrl)
      {
        bo.bf(paramWXMediaMessage, "");
        localIntent.putExtra("Ksnsupload_link", paramString2);
        localIntent.putExtra("Ksnsupload_title", "");
        localIntent.putExtra("Ksnsupload_type", 2);
        localIntent.putExtra("ksnsis_music", true);
        AppMethodBeat.o(16607);
        return localIntent;
        paramWXMediaMessage = paramString1.musicLowBandUrl;
        break;
        paramWXMediaMessage = paramString1.musicUrl;
        break label544;
      }
    case 2: 
      paramWXMediaMessage = (WXImageObject)localObject1;
      localIntent.putExtra("KBlockAdd", true);
      localIntent.putExtra("Ksnsupload_type", 0);
      localIntent.putExtra("sns_kemdia_path", paramWXMediaMessage.imagePath);
      AppMethodBeat.o(16607);
      return localIntent;
    case 5: 
      localIntent.putExtra("Ksnsupload_link", ((WXWebpageObject)localObject1).webpageUrl);
      localIntent.putExtra("Ksnsupload_title", bo.bf(paramWXMediaMessage.title, ""));
      localIntent.putExtra("Ksnsupload_imgbuf", paramWXMediaMessage.thumbData);
      localIntent.putExtra("Ksnsupload_type", 1);
      AppMethodBeat.o(16607);
      return localIntent;
    case 6: 
      ab.e("MicroMsg.ShareSnsImpl", "file is not support!");
      AppMethodBeat.o(16607);
      return null;
    case 4: 
      paramWXMediaMessage = (WXVideoObject)localObject1;
      if (!bo.isNullOrNil(paramWXMediaMessage.videoUrl)) {}
      for (paramWXMediaMessage = paramWXMediaMessage.videoUrl;; paramWXMediaMessage = paramWXMediaMessage.videoLowBandUrl)
      {
        localIntent.putExtra("Ksnsupload_link", bo.bf(paramWXMediaMessage, ""));
        localIntent.putExtra("Ksnsupload_title", "");
        localIntent.putExtra("Ksnsupload_type", 1);
        localIntent.putExtra("ksnsis_video", true);
        AppMethodBeat.o(16607);
        return localIntent;
      }
    case 38: 
      paramWXMediaMessage = (WXVideoFileObject)localObject1;
      localIntent.putExtra("KBlockAdd", true);
      localIntent.putExtra("Ksnsupload_type", 14);
      paramString1 = paramWXMediaMessage.filePath;
      paramWXMediaMessage = "";
      paramString2 = e.avP(paramString1);
      if ((bo.isNullOrNil("")) || (!e.cN("")))
      {
        paramWXMediaMessage = new StringBuilder();
        aw.aaz();
        paramWXMediaMessage = c.getAccSnsTmpPath() + paramString2;
      }
      try
      {
        localObject1 = ut(paramString1);
        if (localObject1 == null) {
          break label1062;
        }
        ab.i("MicroMsg.ShareSnsImpl", "getBitmap1 %d %d", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()) });
        d.a((Bitmap)localObject1, 80, Bitmap.CompressFormat.JPEG, paramWXMediaMessage, true);
        localObject1 = d.aoT(paramWXMediaMessage);
        ab.i("MicroMsg.ShareSnsImpl", "getBitmap2 %d %d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject1).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject1).outHeight) });
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          ab.e("MicroMsg.ShareSnsImpl", "savebitmap error %s", new Object[] { localException1.getMessage() });
        }
      }
      localIntent.putExtra("KSightPath", paramString1);
      localIntent.putExtra("KSightThumbPath", paramWXMediaMessage);
      localIntent.putExtra("sight_md5", paramString2);
      AppMethodBeat.o(16607);
      return localIntent;
      ab.e("MicroMsg.ShareSnsImpl", "thumb null , videoPath %s ", new Object[] { paramString1 });
      AppMethodBeat.o(16607);
      return null;
    case 39: 
      paramWXMediaMessage = (WXGameVideoFileObject)localException1;
      localIntent.putExtra("KBlockAdd", true);
      localIntent.putExtra("Ksnsupload_type", 14);
      paramString1 = paramWXMediaMessage.filePath;
      paramString2 = paramWXMediaMessage.videoUrl;
      str1 = paramWXMediaMessage.thumbUrl;
      ab.i("MicroMsg.ShareSnsImpl", "videoPath %s,thumbPath %s,cdnUrl %s,cdnThumbUrl %s", new Object[] { paramString1, "", paramString2, str1 });
      str2 = e.avP(paramString1);
      if ((bo.isNullOrNil("")) || (!e.cN("")))
      {
        paramWXMediaMessage = new StringBuilder();
        aw.aaz();
      }
      break;
    }
    for (paramWXMediaMessage = c.getAccSnsTmpPath() + str2;; paramWXMediaMessage = "")
    {
      try
      {
        Object localObject2 = ut(paramString1);
        if (localObject2 == null) {
          break label1389;
        }
        ab.i("MicroMsg.ShareSnsImpl", "getBitmap1 %d %d", new Object[] { Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()) });
        d.a((Bitmap)localObject2, 80, Bitmap.CompressFormat.JPEG, paramWXMediaMessage, true);
        localObject2 = d.aoT(paramWXMediaMessage);
        ab.i("MicroMsg.ShareSnsImpl", "getBitmap2 %d %d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject2).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject2).outHeight) });
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          label1389:
          ab.e("MicroMsg.ShareSnsImpl", "savebitmap error %s", new Object[] { localException2.getMessage() });
        }
      }
      localIntent.putExtra("KSightPath", paramString1);
      localIntent.putExtra("KSightThumbPath", paramWXMediaMessage);
      localIntent.putExtra("sight_md5", str2);
      localIntent.putExtra("KSightCdnUrl", paramString2);
      localIntent.putExtra("KSightCdnThumbUrl", str1);
      AppMethodBeat.o(16607);
      return localIntent;
      ab.e("MicroMsg.ShareSnsImpl", "thumb null , videoPath %s ", new Object[] { paramString1 });
      AppMethodBeat.o(16607);
      return null;
      AppMethodBeat.o(16607);
      return null;
    }
  }
  
  private static Bitmap ut(String paramString)
  {
    AppMethodBeat.i(16608);
    rs localrs = new rs();
    localrs.cHY.cIa = paramString;
    com.tencent.mm.sdk.b.a.ymk.l(localrs);
    paramString = (Bitmap)localrs.cHZ.result;
    AppMethodBeat.o(16608);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.a
 * JD-Core Version:    0.7.0.1
 */