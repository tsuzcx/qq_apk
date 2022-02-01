package com.tencent.mm.plugin.game.media.background;

import android.graphics.Bitmap.CompressFormat;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.media.q;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.model.ax;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
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
    WebViewJSSDKVideoItem localWebViewJSSDKVideoItem = amN(paramCaptureVideoNormalModel.videoPath);
    if (localWebViewJSSDKVideoItem == null)
    {
      AppMethodBeat.o(41190);
      return null;
    }
    String str = hc(paramCaptureVideoNormalModel.thumbPath, paramCaptureVideoNormalModel.videoPath);
    WebViewJSSDKFileItem localWebViewJSSDKFileItem = ao.eUe().aIN(str);
    if (localWebViewJSSDKFileItem != null) {
      localWebViewJSSDKVideoItem.kKQ = localWebViewJSSDKFileItem.jXT;
    }
    localWebViewJSSDKVideoItem.ioY.putInt("mark_edit_flag", c(paramCaptureVideoNormalModel.dIW()));
    paramCaptureVideoNormalModel = ax.b(localWebViewJSSDKVideoItem.dsN, str, localWebViewJSSDKVideoItem.duration, localWebViewJSSDKVideoItem.height, localWebViewJSSDKVideoItem.width, localWebViewJSSDKVideoItem.size);
    AppMethodBeat.o(41190);
    return paramCaptureVideoNormalModel;
  }
  
  public static void a(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(41185);
    int i = paramBundle.getInt("key_video_from", 0);
    Object localObject = paramCaptureVideoNormalModel.dIW();
    HashMap localHashMap = new HashMap();
    localHashMap.put("videoid", o.aRh(paramCaptureVideoNormalModel.videoPath));
    localHashMap.put("costtime", ((RecordMediaReportInfo)localObject).v("KEY_REMUX_VIDEO_COST_MS_INT", Integer.valueOf(0)));
    localHashMap.put("origtime", Integer.valueOf(paramBundle.getInt("key_raw_video_duration", 0)));
    localHashMap.put("cliptime", Integer.valueOf(bu.DE(paramCaptureVideoNormalModel.xNX.longValue())));
    localHashMap.put("origsize", Integer.valueOf(paramBundle.getInt("key_raw_video_size", 0)));
    localHashMap.put("remuxsize", Integer.valueOf((int)o.aZR(paramCaptureVideoNormalModel.videoPath)));
    localHashMap.put("hasexpre", ((RecordMediaReportInfo)localObject).v("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(0)));
    localHashMap.put("hasword", ((RecordMediaReportInfo)localObject).v("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(0)));
    localHashMap.put("hasmusic", Integer.valueOf(1));
    if (((Integer)((RecordMediaReportInfo)localObject).v("KEY_MUSIC_ID_INT", Integer.valueOf(-1))).intValue() == -1) {
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
    ae.i("MicroMsg.Haowan.ActionAfterVideoEdited", "remuxResult:%b, statistic:[%s]", new Object[] { paramCaptureVideoNormalModel.xNW, paramBundle.toString() });
    if (!paramCaptureVideoNormalModel.xNW.booleanValue())
    {
      ae.e("MicroMsg.Haowan.ActionAfterVideoEdited", "video remux error");
      com.tencent.mm.game.report.b.a.a(ak.getContext(), 8763, 2, 56, com.tencent.mm.game.report.b.a.b(i, localHashMap));
      AppMethodBeat.o(41185);
      return;
    }
    com.tencent.mm.game.report.b.a.a(ak.getContext(), 8763, 2, 48, com.tencent.mm.game.report.b.a.b(i, localHashMap));
    AppMethodBeat.o(41185);
  }
  
  public static void a(String paramString, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(41186);
    if (!paramString.equals(paramCaptureVideoNormalModel.videoPath))
    {
      o.aZI(o.aZU(paramString));
      if (o.mF(paramCaptureVideoNormalModel.videoPath, paramString) > 0L) {
        paramCaptureVideoNormalModel.videoPath = paramString;
      }
    }
    AppMethodBeat.o(41186);
  }
  
  public static void amM(String paramString)
  {
    AppMethodBeat.i(41189);
    String str = b.arS("mp4");
    ae.i("MicroMsg.Haowan.ActionAfterVideoEdited", "auto save video :%s", new Object[] { str });
    o.mF(paramString, str);
    b.k(str, ak.getContext());
    AppMethodBeat.o(41189);
  }
  
  public static WebViewJSSDKVideoItem amN(String paramString)
  {
    AppMethodBeat.i(41193);
    com.tencent.mm.plugin.sight.base.a locala = e.ayN(paramString);
    if (locala == null)
    {
      ae.e("MicroMsg.Haowan.ActionAfterVideoEdited", "video after edited is error");
      AppMethodBeat.o(41193);
      return null;
    }
    WebViewJSSDKVideoItem localWebViewJSSDKVideoItem = WebViewJSSDKFileItem.bfH(paramString);
    localWebViewJSSDKVideoItem.duration = locala.getVideoDuration();
    localWebViewJSSDKVideoItem.width = locala.width;
    localWebViewJSSDKVideoItem.height = locala.height;
    localWebViewJSSDKVideoItem.size = ((int)o.aZR(paramString));
    g.eUG().a(localWebViewJSSDKVideoItem);
    AppMethodBeat.o(41193);
    return localWebViewJSSDKVideoItem;
  }
  
  public static void b(String paramString, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(41187);
    if (!paramString.equals(paramCaptureVideoNormalModel.thumbPath))
    {
      o.aZI(o.aZU(paramString));
      if (o.mF(paramCaptureVideoNormalModel.thumbPath, paramString) > 0L) {
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
    if (((Integer)paramRecordMediaReportInfo.v("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(0))).intValue() != 0)
    {
      bool1 = true;
      if (((Integer)paramRecordMediaReportInfo.v("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(0))).intValue() == 0) {
        break label220;
      }
      bool2 = true;
      if (((Integer)paramRecordMediaReportInfo.v("KEY_SELECT_MUSIC_INT", Integer.valueOf(0))).intValue() == 0) {
        break label225;
      }
      bool3 = true;
      label83:
      long l1 = ((Integer)paramRecordMediaReportInfo.v("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", Integer.valueOf(0))).intValue();
      long l2 = ((Integer)paramRecordMediaReportInfo.v("KEY_VIDEO_CROP_DURATION_MS_INT", Integer.valueOf(0))).intValue();
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
      ae.i("MicroMsg.Haowan.ActionAfterVideoEdited", "hasEmoji:%b, hasText:%b, hasMusic:%b, hasCut:%b, editFlag:%d", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Integer.valueOf(i) });
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
  
  public static WebViewJSSDKVideoItem hb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41191);
    WebViewJSSDKVideoItem localWebViewJSSDKVideoItem = amN(paramString1);
    if (localWebViewJSSDKVideoItem == null)
    {
      AppMethodBeat.o(41191);
      return null;
    }
    paramString1 = hc(paramString2, paramString1);
    paramString1 = ao.eUe().aIN(paramString1);
    if (paramString1 != null) {
      localWebViewJSSDKVideoItem.kKQ = paramString1.jXT;
    }
    AppMethodBeat.o(41191);
    return localWebViewJSSDKVideoItem;
  }
  
  public static String hc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41192);
    String str1 = paramString1;
    k localk;
    if (TextUtils.isEmpty(paramString1))
    {
      localk = new k(paramString2);
      String str2 = localk.getName();
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
      str1 = localk.getParent() + "/" + paramString1 + ".jpeg";
    }
    while (!new k(str1).exists())
    {
      ae.i("MicroMsg.Haowan.ActionAfterVideoEdited", "create new thumb path:%s!", new Object[] { str1 });
      paramString1 = ThumbnailUtils.createVideoThumbnail(paramString2, 1);
      if (paramString1 == null)
      {
        ae.e("MicroMsg.Haowan.ActionAfterVideoEdited", "createVideoThumbnail bitmap fail for path:%s!", new Object[] { str1 });
        AppMethodBeat.o(41192);
        return "";
        label177:
        str1 = localk.getParent() + "microMsg_" + System.currentTimeMillis() + ".jpeg";
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
        h.a(paramString1, 30, Bitmap.CompressFormat.JPEG, str1, true);
        if (TextUtils.isEmpty(str1)) {
          break;
        }
        paramString1 = WebViewJSSDKFileItem.lb(str1, str1);
        paramString1.jXX = true;
        paramString1.mediaType = 1;
        g.eUG().a(paramString1);
        paramString1 = paramString1.dsN;
        AppMethodBeat.o(41192);
        return paramString1;
      }
      catch (IOException paramString1)
      {
        ae.e("MicroMsg.Haowan.ActionAfterVideoEdited", "saveBitmapToImage exist IOException:" + paramString1.getMessage());
        continue;
      }
      ae.i("MicroMsg.Haowan.ActionAfterVideoEdited", "file is exist for path:%s!", new Object[] { str1 });
    }
    AppMethodBeat.o(41192);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.background.a
 * JD-Core Version:    0.7.0.1
 */