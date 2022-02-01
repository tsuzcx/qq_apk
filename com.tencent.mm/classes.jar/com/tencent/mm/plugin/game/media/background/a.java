package com.tencent.mm.plugin.game.media.background;

import android.graphics.Bitmap.CompressFormat;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.media.q;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.aw;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  public static String a(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(41190);
    WebViewJSSDKVideoItem localWebViewJSSDKVideoItem = ahl(paramCaptureVideoNormalModel.videoPath);
    if (localWebViewJSSDKVideoItem == null)
    {
      AppMethodBeat.o(41190);
      return null;
    }
    String str = gM(paramCaptureVideoNormalModel.thumbPath, paramCaptureVideoNormalModel.videoPath);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = an.eBy().aBU(str);
    if (localWebViewJSSDKFileItem != null) {
      localWebViewJSSDKVideoItem.kmB = localWebViewJSSDKFileItem.jAH;
    }
    localWebViewJSSDKVideoItem.hSN.putInt("mark_edit_flag", c(paramCaptureVideoNormalModel.dvk()));
    paramCaptureVideoNormalModel = aw.b(localWebViewJSSDKVideoItem.dgl, str, localWebViewJSSDKVideoItem.duration, localWebViewJSSDKVideoItem.height, localWebViewJSSDKVideoItem.width, localWebViewJSSDKVideoItem.size);
    AppMethodBeat.o(41190);
    return paramCaptureVideoNormalModel;
  }
  
  public static void a(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(41185);
    int i = paramBundle.getInt("key_video_from", 0);
    Object localObject = paramCaptureVideoNormalModel.dvk();
    HashMap localHashMap = new HashMap();
    localHashMap.put("videoid", i.aKe(paramCaptureVideoNormalModel.videoPath));
    localHashMap.put("costtime", ((RecordMediaReportInfo)localObject).x("KEY_REMUX_VIDEO_COST_MS_INT", Integer.valueOf(0)));
    localHashMap.put("origtime", Integer.valueOf(paramBundle.getInt("key_raw_video_duration", 0)));
    localHashMap.put("cliptime", Integer.valueOf(bs.Aq(paramCaptureVideoNormalModel.wqk.longValue())));
    localHashMap.put("origsize", Integer.valueOf(paramBundle.getInt("key_raw_video_size", 0)));
    localHashMap.put("remuxsize", Integer.valueOf((int)i.aSp(paramCaptureVideoNormalModel.videoPath)));
    localHashMap.put("hasexpre", ((RecordMediaReportInfo)localObject).x("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(0)));
    localHashMap.put("hasword", ((RecordMediaReportInfo)localObject).x("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(0)));
    localHashMap.put("hasmusic", Integer.valueOf(1));
    if (((Integer)((RecordMediaReportInfo)localObject).x("KEY_MUSIC_ID_INT", Integer.valueOf(-1))).intValue() == -1) {
      localHashMap.put("hasmusic", Integer.valueOf(0));
    }
    paramBundle = new StringBuffer();
    localObject = localHashMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramBundle.append((String)localEntry.getKey());
      paramBundle.append(":");
      paramBundle.append(localEntry.getValue());
      paramBundle.append(", ");
    }
    ac.i("MicroMsg.Haowan.ActionAfterVideoEdited", "remuxResult:%b, statistic:[%s]", new Object[] { paramCaptureVideoNormalModel.wqj, paramBundle.toString() });
    if (!paramCaptureVideoNormalModel.wqj.booleanValue())
    {
      ac.e("MicroMsg.Haowan.ActionAfterVideoEdited", "video remux error");
      com.tencent.mm.game.report.b.a.a(ai.getContext(), 8763, 2, 56, com.tencent.mm.game.report.b.a.a(i, localHashMap));
      AppMethodBeat.o(41185);
      return;
    }
    com.tencent.mm.game.report.b.a.a(ai.getContext(), 8763, 2, 48, com.tencent.mm.game.report.b.a.a(i, localHashMap));
    AppMethodBeat.o(41185);
  }
  
  public static void a(String paramString, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(41186);
    if (!paramString.equals(paramCaptureVideoNormalModel.videoPath))
    {
      i.aSh(i.aSs(paramString));
      if (i.lZ(paramCaptureVideoNormalModel.videoPath, paramString) > 0L) {
        paramCaptureVideoNormalModel.videoPath = paramString;
      }
    }
    AppMethodBeat.o(41186);
  }
  
  public static void ahk(String paramString)
  {
    AppMethodBeat.i(41189);
    String str = b.alY("mp4");
    ac.i("MicroMsg.Haowan.ActionAfterVideoEdited", "auto save video :%s", new Object[] { str });
    i.lZ(paramString, str);
    b.k(str, ai.getContext());
    AppMethodBeat.o(41189);
  }
  
  public static WebViewJSSDKVideoItem ahl(String paramString)
  {
    AppMethodBeat.i(41193);
    com.tencent.mm.plugin.sight.base.a locala = com.tencent.mm.plugin.sight.base.e.asx(paramString);
    if (locala == null)
    {
      ac.e("MicroMsg.Haowan.ActionAfterVideoEdited", "video after edited is error");
      AppMethodBeat.o(41193);
      return null;
    }
    WebViewJSSDKVideoItem localWebViewJSSDKVideoItem = WebViewJSSDKFileItem.aOK(paramString);
    localWebViewJSSDKVideoItem.duration = locala.getVideoDuration();
    localWebViewJSSDKVideoItem.width = locala.width;
    localWebViewJSSDKVideoItem.height = locala.height;
    localWebViewJSSDKVideoItem.size = ((int)i.aSp(paramString));
    g.eCa().a(localWebViewJSSDKVideoItem);
    AppMethodBeat.o(41193);
    return localWebViewJSSDKVideoItem;
  }
  
  public static void b(String paramString, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(41187);
    if (!paramString.equals(paramCaptureVideoNormalModel.thumbPath))
    {
      i.aSh(i.aSs(paramString));
      if (i.lZ(paramCaptureVideoNormalModel.thumbPath, paramString) > 0L) {
        paramCaptureVideoNormalModel.thumbPath = paramString;
      }
    }
    AppMethodBeat.o(41187);
  }
  
  public static int c(RecordMediaReportInfo paramRecordMediaReportInfo)
  {
    AppMethodBeat.i(41188);
    if (paramRecordMediaReportInfo == null)
    {
      AppMethodBeat.o(41188);
      return 0;
    }
    boolean bool1;
    boolean bool2;
    label60:
    boolean bool3;
    if (((Integer)paramRecordMediaReportInfo.x("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(0))).intValue() != 0)
    {
      bool1 = true;
      if (((Integer)paramRecordMediaReportInfo.x("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(0))).intValue() == 0) {
        break label220;
      }
      bool2 = true;
      if (((Integer)paramRecordMediaReportInfo.x("KEY_SELECT_MUSIC_INT", Integer.valueOf(0))).intValue() == 0) {
        break label225;
      }
      bool3 = true;
      label83:
      long l1 = ((Integer)paramRecordMediaReportInfo.x("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", Integer.valueOf(0))).intValue();
      long l2 = ((Integer)paramRecordMediaReportInfo.x("KEY_VIDEO_CROP_DURATION_MS_INT", Integer.valueOf(0))).intValue();
      if ((l1 == 0L) || (l2 == 0L) || (l1 == l2)) {
        break label231;
      }
    }
    label220:
    label225:
    label231:
    for (boolean bool4 = true;; bool4 = false)
    {
      int i = q.c(bool1, bool2, bool3, bool4);
      ac.i("MicroMsg.Haowan.ActionAfterVideoEdited", "hasEmoji:%b, hasText:%b, hasMusic:%b, hasCut:%b, editFlag:%d", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Integer.valueOf(i) });
      AppMethodBeat.o(41188);
      return i;
      bool1 = false;
      break;
      bool2 = false;
      break label60;
      bool3 = false;
      break label83;
    }
  }
  
  public static WebViewJSSDKVideoItem gL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41191);
    WebViewJSSDKVideoItem localWebViewJSSDKVideoItem = ahl(paramString1);
    if (localWebViewJSSDKVideoItem == null)
    {
      AppMethodBeat.o(41191);
      return null;
    }
    paramString1 = gM(paramString2, paramString1);
    paramString1 = an.eBy().aBU(paramString1);
    if (paramString1 != null) {
      localWebViewJSSDKVideoItem.kmB = paramString1.jAH;
    }
    AppMethodBeat.o(41191);
    return localWebViewJSSDKVideoItem;
  }
  
  public static String gM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41192);
    String str1 = paramString1;
    com.tencent.mm.vfs.e locale;
    if (TextUtils.isEmpty(paramString1))
    {
      locale = new com.tencent.mm.vfs.e(paramString2);
      String str2 = locale.getName();
      str1 = null;
      paramString1 = str1;
      if (!TextUtils.isEmpty(str2))
      {
        paramString1 = str1;
        if (str2.contains(".")) {
          paramString1 = str2.substring(0, str2.lastIndexOf("."));
        }
      }
      if (TextUtils.isEmpty(paramString1)) {
        break label177;
      }
      str1 = locale.getParent() + "/" + paramString1 + ".jpeg";
    }
    while (!new com.tencent.mm.vfs.e(str1).exists())
    {
      ac.i("MicroMsg.Haowan.ActionAfterVideoEdited", "create new thumb path:%s!", new Object[] { str1 });
      paramString1 = ThumbnailUtils.createVideoThumbnail(paramString2, 1);
      if (paramString1 == null)
      {
        ac.e("MicroMsg.Haowan.ActionAfterVideoEdited", "createVideoThumbnail bitmap fail for path:%s!", new Object[] { str1 });
        AppMethodBeat.o(41192);
        return "";
        label177:
        str1 = locale.getParent() + "microMsg_" + System.currentTimeMillis() + ".jpeg";
      }
      else
      {
        paramString1 = ThumbnailUtils.extractThumbnail(paramString1, 690, 400, 2);
      }
    }
    for (;;)
    {
      try
      {
        f.a(paramString1, 30, Bitmap.CompressFormat.JPEG, str1, true);
        if (TextUtils.isEmpty(str1)) {
          break;
        }
        paramString1 = WebViewJSSDKFileItem.nr(str1, str1);
        paramString1.jAL = true;
        paramString1.mediaType = 1;
        g.eCa().a(paramString1);
        paramString1 = paramString1.dgl;
        AppMethodBeat.o(41192);
        return paramString1;
      }
      catch (IOException paramString1)
      {
        ac.e("MicroMsg.Haowan.ActionAfterVideoEdited", "saveBitmapToImage exist IOException:" + paramString1.getMessage());
        continue;
      }
      ac.i("MicroMsg.Haowan.ActionAfterVideoEdited", "file is exist for path:%s!", new Object[] { str1 });
    }
    AppMethodBeat.o(41192);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.background.a
 * JD-Core Version:    0.7.0.1
 */