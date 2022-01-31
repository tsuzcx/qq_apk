package com.tencent.mm.modelsns;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Bundle;
import com.tencent.mm.h.a.qi;
import com.tencent.mm.h.a.qi.b;
import com.tencent.mm.model.au;
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
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.e.h;
import com.tencent.mm.vfs.e;
import java.util.Set;

public final class a
{
  public static Set<String> eAt;
  
  public static Intent a(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2)
  {
    y.d("MicroMsg.ShareSnsImpl", "appmsg.description " + paramWXMediaMessage.description);
    y.d("MicroMsg.ShareSnsImpl", "appmsg.title " + paramWXMediaMessage.title);
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
      y.d("MicroMsg.ShareSnsImpl", "TimeLineType " + i + " " + ((WXMediaMessage.IMediaObject)localObject1).type());
      localIntent.putExtra("Ksnsupload_appid", paramString1);
      localIntent.putExtra("Ksnsupload_appname", paramString2);
      localIntent.putExtra("KSnsAction", true);
      localIntent.putExtra("need_result", true);
      paramString1 = new Bundle();
      paramString2 = new SendMessageToWX.Req();
      paramString2.message = paramWXMediaMessage;
      paramString2.toBundle(paramString1);
      localIntent.putExtra("Ksnsupload_timeline", paramString1);
      if (i != -1) {
        break;
      }
      y.d("MicroMsg.ShareSnsImpl", "timeLineType is invalid");
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
    label496:
    String str1;
    label573:
    label581:
    label978:
    String str2;
    switch (((WXMediaMessage.IMediaObject)localObject1).type())
    {
    default: 
      y.e("MicroMsg.ShareSnsImpl", "none type not support!");
      return null;
    case 1: 
      paramWXMediaMessage = (WXTextObject)localObject1;
      localIntent.putExtra(e.h.uHV, paramWXMediaMessage.text);
      localIntent.putExtra("Ksnsupload_type", 8);
      return localIntent;
    case 3: 
      paramString1 = (WXMusicObject)localObject1;
      if (!bk.bl(paramString1.musicUrl))
      {
        paramWXMediaMessage = paramString1.musicUrl;
        paramString2 = bk.aM(paramWXMediaMessage, "");
        if (bk.bl(paramString1.musicDataUrl)) {
          break label573;
        }
        paramWXMediaMessage = paramString1.musicDataUrl;
        bk.aM(paramWXMediaMessage, "");
        if (bk.bl(paramString1.musicLowBandDataUrl)) {
          break label581;
        }
      }
      for (paramWXMediaMessage = paramString1.musicLowBandDataUrl;; paramWXMediaMessage = paramString1.musicLowBandUrl)
      {
        bk.aM(paramWXMediaMessage, "");
        localIntent.putExtra("Ksnsupload_link", paramString2);
        localIntent.putExtra("Ksnsupload_title", "");
        localIntent.putExtra("Ksnsupload_type", 2);
        localIntent.putExtra("ksnsis_music", true);
        return localIntent;
        paramWXMediaMessage = paramString1.musicLowBandUrl;
        break;
        paramWXMediaMessage = paramString1.musicUrl;
        break label496;
      }
    case 2: 
      paramWXMediaMessage = (WXImageObject)localObject1;
      localIntent.putExtra("KBlockAdd", true);
      localIntent.putExtra("Ksnsupload_type", 0);
      localIntent.putExtra("sns_kemdia_path", paramWXMediaMessage.imagePath);
      return localIntent;
    case 5: 
      localIntent.putExtra("Ksnsupload_link", ((WXWebpageObject)localObject1).webpageUrl);
      localIntent.putExtra("Ksnsupload_title", bk.aM(paramWXMediaMessage.title, ""));
      localIntent.putExtra("Ksnsupload_imgbuf", paramWXMediaMessage.thumbData);
      localIntent.putExtra("Ksnsupload_type", 1);
      return localIntent;
    case 6: 
      y.e("MicroMsg.ShareSnsImpl", "file is not support!");
      return null;
    case 4: 
      paramWXMediaMessage = (WXVideoObject)localObject1;
      if (!bk.bl(paramWXMediaMessage.videoUrl)) {}
      for (paramWXMediaMessage = paramWXMediaMessage.videoUrl;; paramWXMediaMessage = paramWXMediaMessage.videoLowBandUrl)
      {
        localIntent.putExtra("Ksnsupload_link", bk.aM(paramWXMediaMessage, ""));
        localIntent.putExtra("Ksnsupload_title", "");
        localIntent.putExtra("Ksnsupload_type", 1);
        localIntent.putExtra("ksnsis_video", true);
        return localIntent;
      }
    case 38: 
      paramWXMediaMessage = (WXVideoFileObject)localObject1;
      localIntent.putExtra("KBlockAdd", true);
      localIntent.putExtra("Ksnsupload_type", 14);
      paramString1 = paramWXMediaMessage.filePath;
      paramWXMediaMessage = "";
      paramString2 = e.aeY(paramString1);
      if ((bk.bl("")) || (!e.bK("")))
      {
        paramWXMediaMessage = new StringBuilder();
        au.Hx();
        paramWXMediaMessage = com.tencent.mm.model.c.getAccSnsTmpPath() + paramString2;
      }
      try
      {
        localObject1 = ng(paramString1);
        if (localObject1 == null) {
          break label978;
        }
        y.i("MicroMsg.ShareSnsImpl", "getBitmap1 %d %d", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()) });
        com.tencent.mm.sdk.platformtools.c.a((Bitmap)localObject1, 80, Bitmap.CompressFormat.JPEG, paramWXMediaMessage, true);
        localObject1 = com.tencent.mm.sdk.platformtools.c.YU(paramWXMediaMessage);
        y.i("MicroMsg.ShareSnsImpl", "getBitmap2 %d %d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject1).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject1).outHeight) });
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          y.e("MicroMsg.ShareSnsImpl", "savebitmap error %s", new Object[] { localException1.getMessage() });
        }
      }
      localIntent.putExtra("KSightPath", paramString1);
      localIntent.putExtra("KSightThumbPath", paramWXMediaMessage);
      localIntent.putExtra("sight_md5", paramString2);
      return localIntent;
      y.e("MicroMsg.ShareSnsImpl", "thumb null , videoPath %s ", new Object[] { paramString1 });
      return null;
    case 39: 
      paramWXMediaMessage = (WXGameVideoFileObject)localException1;
      localIntent.putExtra("KBlockAdd", true);
      localIntent.putExtra("Ksnsupload_type", 14);
      paramString1 = paramWXMediaMessage.filePath;
      paramString2 = paramWXMediaMessage.videoUrl;
      str1 = paramWXMediaMessage.thumbUrl;
      y.i("MicroMsg.ShareSnsImpl", "videoPath %s,thumbPath %s,cdnUrl %s,cdnThumbUrl %s", new Object[] { paramString1, "", paramString2, str1 });
      str2 = e.aeY(paramString1);
      if ((bk.bl("")) || (!e.bK("")))
      {
        paramWXMediaMessage = new StringBuilder();
        au.Hx();
      }
      break;
    }
    for (paramWXMediaMessage = com.tencent.mm.model.c.getAccSnsTmpPath() + str2;; paramWXMediaMessage = "")
    {
      try
      {
        Object localObject2 = ng(paramString1);
        if (localObject2 == null) {
          break label1293;
        }
        y.i("MicroMsg.ShareSnsImpl", "getBitmap1 %d %d", new Object[] { Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()) });
        com.tencent.mm.sdk.platformtools.c.a((Bitmap)localObject2, 80, Bitmap.CompressFormat.JPEG, paramWXMediaMessage, true);
        localObject2 = com.tencent.mm.sdk.platformtools.c.YU(paramWXMediaMessage);
        y.i("MicroMsg.ShareSnsImpl", "getBitmap2 %d %d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject2).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject2).outHeight) });
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          label1293:
          y.e("MicroMsg.ShareSnsImpl", "savebitmap error %s", new Object[] { localException2.getMessage() });
        }
      }
      localIntent.putExtra("KSightPath", paramString1);
      localIntent.putExtra("KSightThumbPath", paramWXMediaMessage);
      localIntent.putExtra("sight_md5", str2);
      localIntent.putExtra("KSightCdnUrl", paramString2);
      localIntent.putExtra("KSightCdnThumbUrl", str1);
      return localIntent;
      y.e("MicroMsg.ShareSnsImpl", "thumb null , videoPath %s ", new Object[] { paramString1 });
      return null;
      return null;
    }
  }
  
  private static Bitmap ng(String paramString)
  {
    qi localqi = new qi();
    localqi.bZG.bZI = paramString;
    com.tencent.mm.sdk.b.a.udP.m(localqi);
    return (Bitmap)localqi.bZH.result;
  }
  
  public static final class a
  {
    public String eAu;
    public String eAv;
    public String eAw;
    public int eAx = -1;
    public int eAy = -1;
    public int videoBitRate = -1;
    public int videoFrameRate = -1;
    public int videoHeight = -1;
    public int videoWidth = -1;
    
    public static a nh(String paramString)
    {
      MediaExtractor localMediaExtractor = new MediaExtractor();
      a locala = new a();
      locala.eAu = paramString;
      for (;;)
      {
        Object localObject2;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        Object localObject6;
        try
        {
          localMediaExtractor.setDataSource(paramString);
          int j = localMediaExtractor.getTrackCount();
          int i = 0;
          localObject2 = null;
          String str1 = null;
          localObject3 = localObject2;
          localObject4 = str1;
          MediaFormat localMediaFormat;
          String str2;
          if (i < j)
          {
            localMediaFormat = localMediaExtractor.getTrackFormat(i);
            if (!localMediaFormat.containsKey("mime"))
            {
              y.i("MicroMsg.ShareSnsImpl", "find video mime : not found.");
              localObject5 = localObject2;
              localObject6 = str1;
              break label494;
            }
            str2 = localMediaFormat.getString("mime");
            y.i("MicroMsg.ShareSnsImpl", "find video mime : %s", new Object[] { str2 });
            localObject5 = localObject2;
            localObject6 = str1;
            if (str2 == null) {
              break label494;
            }
            if (str2.startsWith("video/"))
            {
              localObject3 = localObject2;
              localObject4 = str1;
              if (str1 != null) {
                break label508;
              }
              localObject4 = localMediaFormat;
              localObject3 = localObject2;
              break label508;
            }
          }
          else
          {
            if (localObject4 != null)
            {
              if (((MediaFormat)localObject4).containsKey("durationUs")) {
                continue;
              }
              i = 0;
              locala.eAx = i;
              if (((MediaFormat)localObject4).containsKey("height")) {
                continue;
              }
              i = 0;
              locala.videoHeight = i;
              if (((MediaFormat)localObject4).containsKey("width")) {
                continue;
              }
              i = 0;
              locala.videoWidth = i;
              if (((MediaFormat)localObject4).containsKey("mime")) {
                continue;
              }
              str1 = "";
              locala.eAv = str1;
              if (((MediaFormat)localObject4).containsKey("bitrate")) {
                continue;
              }
              i = 0;
              locala.videoBitRate = i;
              if (((MediaFormat)localObject4).containsKey("i-frame-interval")) {
                continue;
              }
              i = 0;
              locala.eAy = i;
              if (((MediaFormat)localObject4).containsKey("frame-rate")) {
                continue;
              }
              i = 0;
              locala.videoFrameRate = i;
            }
            if (localObject3 != null)
            {
              if (localObject3.containsKey("mime")) {
                continue;
              }
              str1 = "";
              locala.eAw = str1;
            }
            return locala;
          }
          localObject3 = localObject2;
          localObject4 = str1;
          if (str2.startsWith("audio/"))
          {
            localObject3 = localObject2;
            localObject4 = str1;
            if (localObject2 == null)
            {
              localObject3 = localMediaFormat;
              localObject4 = str1;
              break label508;
              i = (int)(((MediaFormat)localObject4).getLong("durationUs") / 1000L);
              continue;
              i = ((MediaFormat)localObject4).getInteger("height");
              continue;
              i = ((MediaFormat)localObject4).getInteger("width");
              continue;
              str1 = ((MediaFormat)localObject4).getString("mime");
              continue;
              i = ((MediaFormat)localObject4).getInteger("bitrate");
              continue;
              i = ((MediaFormat)localObject4).getInteger("i-frame-interval");
              continue;
              i = ((MediaFormat)localObject4).getInteger("frame-rate");
              continue;
              str1 = localObject3.getString("mime");
              continue;
              i += 1;
            }
          }
        }
        catch (Exception localException)
        {
          y.i("MicroMsg.ShareSnsImpl", "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { paramString, localException.getMessage() });
          return locala;
        }
        finally
        {
          localMediaExtractor.release();
        }
        label494:
        label508:
        do
        {
          do
          {
            localObject2 = localObject5;
            Object localObject1 = localObject6;
            break;
            localObject5 = localObject3;
            localObject6 = localObject4;
          } while (localObject3 == null);
          localObject5 = localObject3;
          localObject6 = localObject4;
        } while (localObject4 == null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsns.a
 * JD-Core Version:    0.7.0.1
 */