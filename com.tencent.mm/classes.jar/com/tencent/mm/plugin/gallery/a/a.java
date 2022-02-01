package com.tencent.mm.plugin.gallery.a;

import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/utils/AlbumSelectRestriction;", "", "()V", "GLOBAL_SCENE", "", "KEY_AUDIO_MIME", "", "KEY_ENABLE_QT", "KEY_FILE_FORMAT", "KEY_INCLUDE_LOCAL_SETTING", "KEY_LONG_SIDE_LIMIT", "KEY_MAX_DURATION_MS", "KEY_MAX_RATIO", "KEY_MIN_DURATION_MS", "KEY_MIN_RATIO", "KEY_SCENE", "KEY_SHORT_SIDE_LIMIT", "KEY_SUFFIX", "KEY_VIDEO_MIME", "LOG_LIMIT", "TAG", "localRestriction", "Ljava/util/HashMap;", "Lorg/json/JSONObject;", "Lkotlin/collections/HashMap;", "logFrequency", "checkAudioMime", "", "mimeArray", "Lorg/json/JSONArray;", "audioMime", "checkFileFormat", "fileFormatArray", "path", "checkQtVideo", "item", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "enableQT", "checkRestrictionEnable", "restriction", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "checkRestrictionsEnable", "restrictions", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "checkVideoMime", "videoMime", "configEnable", "value", "", "getGlobalRestrictionCopy", "initDefaultRestriction", "limitLog", "", "string", "setSceneRestriction", "scene", "setupRestriction", "checkArray", "videoCheckSuffixSupportedError", "suffixArray", "originalPath", "videoEnableCheck", "plugin-gallery_release"})
public final class a
{
  private static final HashMap<Integer, JSONObject> CeV;
  private static int CeW;
  public static final a CeX;
  
  static
  {
    AppMethodBeat.i(243520);
    CeX = new a();
    Object localObject1 = new HashMap();
    CeV = (HashMap)localObject1;
    localObject1 = (Map)localObject1;
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = new JSONArray();
    ((JSONArray)localObject2).put(".h264");
    ((JSONArray)localObject2).put(".h26l");
    ((JSONArray)localObject2).put(".264");
    ((JSONArray)localObject2).put(".avc");
    ((JSONArray)localObject2).put(".mov");
    ((JSONArray)localObject2).put(".mp4");
    ((JSONArray)localObject2).put(".m4a");
    ((JSONArray)localObject2).put(".3gp");
    ((JSONArray)localObject2).put(".3g2");
    ((JSONArray)localObject2).put(".mj2");
    ((JSONArray)localObject2).put(".m4v");
    localJSONObject.put("suffix", localObject2);
    localObject2 = new JSONArray();
    ((JSONArray)localObject2).put("video/avc");
    ((JSONArray)localObject2).put("video/hevc");
    localJSONObject.put("video-mime", localObject2);
    localObject2 = new com.tencent.mm.ad.f();
    ((com.tencent.mm.ad.f)localObject2).bv("audio/mp4a-latm");
    localJSONObject.put("audio-mime", localObject2);
    if (((b)h.ae(b.class)).a(b.a.vUP, true))
    {
      localObject2 = new JSONArray();
      ((JSONArray)localObject2).put("video/mp4");
      localJSONObject.put("file-format", localObject2);
    }
    ((Map)localObject1).put(Integer.valueOf(-1), localJSONObject);
    AppMethodBeat.o(243520);
  }
  
  private static void a(ArrayList<JSONObject> paramArrayList, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(243511);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(243511);
      return;
    }
    paramArrayList.add(paramJSONObject);
    if (paramJSONObject.optBoolean("include_local_setting", false))
    {
      paramJSONObject = (JSONObject)CeV.get(Integer.valueOf(-1));
      if (paramJSONObject != null)
      {
        paramArrayList.add(paramJSONObject);
        AppMethodBeat.o(243511);
        return;
      }
    }
    AppMethodBeat.o(243511);
  }
  
  private static boolean a(ArrayList<JSONObject> paramArrayList, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(243513);
    if (paramArrayList.size() <= 0)
    {
      aIF("never happen!!!");
      AppMethodBeat.o(243513);
      return true;
    }
    paramArrayList = paramArrayList.iterator();
    label656:
    while (paramArrayList.hasNext())
    {
      Object localObject1 = (JSONObject)paramArrayList.next();
      int m;
      Object localObject2;
      int k;
      int j;
      double d1;
      double d2;
      JSONArray localJSONArray1;
      JSONArray localJSONArray2;
      JSONArray localJSONArray3;
      boolean bool1;
      int i;
      if (localObject1 != null)
      {
        int n = ((JSONObject)localObject1).optInt("long-side-limit", -1);
        m = ((JSONObject)localObject1).optInt("short-side-limit", -1);
        localObject2 = ((JSONObject)localObject1).optJSONArray("suffix");
        k = ((JSONObject)localObject1).optInt("min-duration-ms", -1);
        j = ((JSONObject)localObject1).optInt("max-duration-ms", -1);
        d1 = ((JSONObject)localObject1).optDouble("max-ratio", -1.0D);
        d2 = ((JSONObject)localObject1).optDouble("min-ratio", -1.0D);
        localJSONArray1 = ((JSONObject)localObject1).optJSONArray("video-mime");
        localJSONArray2 = ((JSONObject)localObject1).optJSONArray("audio-mime");
        localJSONArray3 = ((JSONObject)localObject1).optJSONArray("file-format");
        bool1 = ((JSONObject)localObject1).optBoolean("qt-file", false);
        if ((paramMediaItem instanceof GalleryItem.VideoMediaItem)) {
          if (n > 0)
          {
            i = 1;
            if ((i == 0) || (Math.max(((GalleryItem.VideoMediaItem)paramMediaItem).videoHeight, ((GalleryItem.VideoMediaItem)paramMediaItem).videoWidth) <= n)) {
              break label278;
            }
            Log.i("MicroMsg.AlbumSelectRestriction", "disable by long side ,origin:" + Math.max(((GalleryItem.VideoMediaItem)paramMediaItem).videoHeight, ((GalleryItem.VideoMediaItem)paramMediaItem).videoWidth) + " config:" + n);
            i = 0;
          }
        }
      }
      label278:
      label579:
      label733:
      for (;;)
      {
        if (i != 0) {
          break label1037;
        }
        AppMethodBeat.o(243513);
        return false;
        i = 0;
        break;
        if (m > 0) {}
        for (i = 1;; i = 0)
        {
          if ((i == 0) || (Math.min(((GalleryItem.VideoMediaItem)paramMediaItem).videoHeight, ((GalleryItem.VideoMediaItem)paramMediaItem).videoWidth) >= m)) {
            break label375;
          }
          Log.i("MicroMsg.AlbumSelectRestriction", "disable by short side ,origin:" + Math.min(((GalleryItem.VideoMediaItem)paramMediaItem).videoHeight, ((GalleryItem.VideoMediaItem)paramMediaItem).videoWidth) + " config:" + m);
          i = 0;
          break;
        }
        label375:
        if ((localObject2 != null) && (!a((JSONArray)localObject2, paramMediaItem.AAz)))
        {
          Log.i("MicroMsg.AlbumSelectRestriction", "disable by Suffix ,origin:" + paramMediaItem.AAz);
          i = 0;
        }
        else
        {
          localObject1 = (GalleryItem.VideoMediaItem)paramMediaItem;
          localObject2 = ((GalleryItem.VideoMediaItem)localObject1).AAz;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            i = 0;
          }
          for (;;)
          {
            if (i != 0) {
              break label579;
            }
            Log.i("MicroMsg.AlbumSelectRestriction", "disable by qt file check");
            i = 0;
            break;
            boolean bool2 = v.XI((String)localObject2);
            if (!bool2)
            {
              i = 1;
            }
            else if ((!bool1) && (bool2))
            {
              i = 0;
            }
            else if ((!Util.isNullOrNil(((GalleryItem.VideoMediaItem)localObject1).maR)) && (com.tencent.mm.plugin.u.f.aPq(((GalleryItem.VideoMediaItem)localObject1).maR)) && (!Util.isNullOrNil(((GalleryItem.VideoMediaItem)localObject1).maS)) && (com.tencent.mm.plugin.u.f.aPq(((GalleryItem.VideoMediaItem)localObject1).maS)))
            {
              Log.i("MicroMsg.AlbumSelectRestriction", "qt video can decode");
              i = 1;
            }
            else
            {
              Log.i("MicroMsg.AlbumSelectRestriction", "qt video cannot decode");
              i = 0;
            }
          }
          if (k > 0) {}
          for (i = 1;; i = 0)
          {
            if ((i == 0) || (((GalleryItem.VideoMediaItem)paramMediaItem).maT >= k)) {
              break label656;
            }
            Log.i("MicroMsg.AlbumSelectRestriction", "disable by min time,origin:" + ((GalleryItem.VideoMediaItem)paramMediaItem).maT + " config:" + k);
            i = 0;
            break;
          }
          if (j > 0) {}
          for (i = 1;; i = 0)
          {
            if ((i == 0) || (((GalleryItem.VideoMediaItem)paramMediaItem).maT <= j)) {
              break label733;
            }
            Log.i("MicroMsg.AlbumSelectRestriction", "disable by max time,origin:" + ((GalleryItem.VideoMediaItem)paramMediaItem).maT + " config:" + j);
            i = 0;
            break;
          }
          float f;
          if (v(d1))
          {
            f = ((GalleryItem.VideoMediaItem)paramMediaItem).videoHeight / ((GalleryItem.VideoMediaItem)paramMediaItem).videoWidth;
            if (f > d1)
            {
              Log.i("MicroMsg.AlbumSelectRestriction", "disable by max ratio,origin:" + f + " config:" + d1);
              i = 0;
              continue;
            }
          }
          if (v(d2))
          {
            f = ((GalleryItem.VideoMediaItem)paramMediaItem).videoHeight / ((GalleryItem.VideoMediaItem)paramMediaItem).videoWidth;
            if (f < d2)
            {
              Log.i("MicroMsg.AlbumSelectRestriction", "disable by min ratio,origin:" + f + " config:" + d2);
              i = 0;
              continue;
            }
          }
          if (!b(localJSONArray1, ((GalleryItem.VideoMediaItem)paramMediaItem).maR))
          {
            Log.i("MicroMsg.AlbumSelectRestriction", "disable by video mime check,origin:" + ((GalleryItem.VideoMediaItem)paramMediaItem).maR + " config:" + localJSONArray1);
            i = 0;
          }
          else if (!c(localJSONArray2, ((GalleryItem.VideoMediaItem)paramMediaItem).maS))
          {
            Log.i("MicroMsg.AlbumSelectRestriction", "disable by video mime check,origin:" + ((GalleryItem.VideoMediaItem)paramMediaItem).maR + " config:" + localJSONArray1);
            i = 0;
          }
          else if (!d(localJSONArray3, paramMediaItem.AAz))
          {
            Log.i("MicroMsg.AlbumSelectRestriction", "disable by file format check");
            i = 0;
          }
          else
          {
            i = 1;
          }
        }
      }
    }
    label1037:
    AppMethodBeat.o(243513);
    return true;
  }
  
  private static boolean a(JSONArray paramJSONArray, String paramString)
  {
    AppMethodBeat.i(243514);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(243514);
      return false;
    }
    if (paramString == null) {
      p.iCn();
    }
    paramString = (CharSequence)paramString;
    int i = paramString.length() - 1;
    int j = 0;
    int k = 0;
    while (j <= i)
    {
      int m;
      if (k == 0)
      {
        m = j;
        label63:
        if (paramString.charAt(m) > ' ') {
          break label101;
        }
        m = 1;
      }
      for (;;)
      {
        if (k == 0)
        {
          if (m == 0)
          {
            k = 1;
            break;
            m = i;
            break label63;
            label101:
            m = 0;
            continue;
          }
          j += 1;
          break;
        }
      }
      if (m == 0) {
        break;
      }
      i -= 1;
    }
    paramString = paramString.subSequence(j, i + 1).toString();
    i = n.g((CharSequence)paramString, ".");
    if ((i < 0) || (i >= paramString.length()))
    {
      AppMethodBeat.o(243514);
      return false;
    }
    if (paramString == null)
    {
      paramJSONArray = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(243514);
      throw paramJSONArray;
    }
    paramString = paramString.substring(i);
    p.j(paramString, "(this as java.lang.String).substring(startIndex)");
    if (paramString == null)
    {
      paramJSONArray = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(243514);
      throw paramJSONArray;
    }
    paramString = paramString.toLowerCase();
    p.j(paramString, "(this as java.lang.String).toLowerCase()");
    j = paramJSONArray.length();
    i = 0;
    boolean bool = false;
    while (i < j)
    {
      String str = paramJSONArray.optString(i);
      p.j(str, "suffixArray.optString(i)");
      if (str == null)
      {
        paramJSONArray = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(243514);
        throw paramJSONArray;
      }
      str = str.toLowerCase();
      p.j(str, "(this as java.lang.String).toLowerCase()");
      if (p.h(str, paramString)) {
        bool = true;
      }
      i += 1;
    }
    AppMethodBeat.o(243514);
    return bool;
  }
  
  private static void aIF(String paramString)
  {
    AppMethodBeat.i(243510);
    if (CeW % 20 == 0) {
      Log.i("MicroMsg.AlbumSelectRestriction", paramString);
    }
    AppMethodBeat.o(243510);
  }
  
  public static void aX(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(243506);
    p.k(paramJSONObject, "restriction");
    ((Map)CeV).put(Integer.valueOf(25), paramJSONObject);
    AppMethodBeat.o(243506);
  }
  
  private static boolean b(JSONArray paramJSONArray, String paramString)
  {
    AppMethodBeat.i(243516);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(243516);
      return true;
    }
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(243516);
      return false;
    }
    int k = paramJSONArray.length();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      if (n.L(paramJSONArray.optString(i), paramString, true)) {
        j = 1;
      }
      i += 1;
    }
    if (j == 0)
    {
      AppMethodBeat.o(243516);
      return false;
    }
    if ((n.L("video/hevc", paramString, true)) && (!com.tencent.mm.plugin.u.f.eSH()))
    {
      AppMethodBeat.o(243516);
      return false;
    }
    AppMethodBeat.o(243516);
    return true;
  }
  
  private static boolean c(JSONArray paramJSONArray, String paramString)
  {
    AppMethodBeat.i(243517);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(243517);
      return true;
    }
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(243517);
      return true;
    }
    int j = paramJSONArray.length();
    int i = 0;
    boolean bool = false;
    while (i < j)
    {
      if (n.L(paramJSONArray.optString(i), paramString, true)) {
        bool = true;
      }
      i += 1;
    }
    AppMethodBeat.o(243517);
    return bool;
  }
  
  private static boolean d(JSONArray paramJSONArray, String paramString)
  {
    AppMethodBeat.i(243519);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(243519);
      return false;
    }
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(243519);
      return true;
    }
    if (!u.agG(paramString))
    {
      AppMethodBeat.o(243519);
      return false;
    }
    c localc = new c();
    if (paramString == null) {
      p.iCn();
    }
    localc.setDataSource(paramString);
    paramString = localc.getTrackFormat(0);
    p.j(paramString, "extractor.getTrackFormat(0)");
    if ((paramString == null) || (!paramString.containsKey("file-format")))
    {
      AppMethodBeat.o(243519);
      return true;
    }
    paramString = paramString.getString("file-format");
    int j = paramJSONArray.length();
    int i = 0;
    boolean bool = false;
    while (i < j)
    {
      if (n.L(paramJSONArray.optString(i), paramString, true)) {
        bool = true;
      }
      i += 1;
    }
    AppMethodBeat.o(243519);
    return bool;
  }
  
  public static JSONObject euY()
  {
    AppMethodBeat.i(243507);
    JSONObject localJSONObject = new JSONObject(String.valueOf(CeV.get(Integer.valueOf(-1))));
    AppMethodBeat.o(243507);
    return localJSONObject;
  }
  
  private static boolean v(double paramDouble)
  {
    return paramDouble > 0.0D;
  }
  
  public final boolean b(int paramInt, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(243508);
    p.k(paramMediaItem, "item");
    CeW += 1;
    Object localObject1 = ((b)h.ae(b.class)).a(b.a.vUQ, "");
    aIF("print scene:" + paramInt + " restriction:" + (String)localObject1);
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    Object localObject5;
    for (;;)
    {
      try
      {
        localJSONArray = new JSONArray((String)localObject1);
        int j = localJSONArray.length();
        i = 0;
        localObject1 = null;
        localObject2 = null;
        if (i >= j) {
          break label320;
        }
        localObject5 = localObject2;
      }
      catch (Exception localException1)
      {
        JSONArray localJSONArray;
        int i;
        JSONObject localJSONObject2;
        Object localObject4;
        int k;
        localJSONObject1 = null;
        localObject2 = null;
      }
      try
      {
        localJSONObject2 = localJSONArray.getJSONObject(i);
        localObject4 = localObject2;
        localObject5 = localObject2;
        if (localJSONObject2.optInt("scene") == paramInt) {
          localObject4 = localJSONObject2;
        }
        localObject5 = localObject4;
        k = localJSONObject2.optInt("scene");
        if (k != -1) {
          break label317;
        }
        localObject1 = localJSONObject2;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject3 = localObject5;
        }
        continue;
      }
      i += 1;
      localObject2 = localObject4;
    }
    label317:
    label320:
    for (;;)
    {
      JSONObject localJSONObject1;
      a(localArrayList, localObject2);
      if (localArrayList.size() <= 0) {
        a(localArrayList, localJSONObject1);
      }
      if (localArrayList.size() <= 0) {
        a(localArrayList, (JSONObject)CeV.get(Integer.valueOf(paramInt)));
      }
      if (localArrayList.size() <= 0) {
        a(localArrayList, (JSONObject)CeV.get(Integer.valueOf(-1)));
      }
      aIF("checkArray size:" + localArrayList.size());
      boolean bool = a(localArrayList, paramMediaItem);
      AppMethodBeat.o(243508);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.a.a
 * JD-Core Version:    0.7.0.1
 */