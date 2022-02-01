package com.tencent.mm.plugin.gallery.b;

import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/utils/AlbumSelectRestriction;", "", "()V", "GLOBAL_SCENE", "", "KEY_AUDIO_MIME", "", "KEY_ENABLE_QT", "KEY_FILE_FORMAT", "KEY_INCLUDE_LOCAL_SETTING", "KEY_LONG_SIDE_LIMIT", "KEY_MAX_DURATION_MS", "KEY_MAX_RATIO", "KEY_MIN_DURATION_MS", "KEY_MIN_RATIO", "KEY_SCENE", "KEY_SHORT_SIDE_LIMIT", "KEY_SUFFIX", "KEY_VIDEO_MIME", "LOG_LIMIT", "TAG", "localRestriction", "Ljava/util/HashMap;", "Lorg/json/JSONObject;", "Lkotlin/collections/HashMap;", "logFrequency", "restrictionMap", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "checkAudioMime", "", "mimeArray", "Lorg/json/JSONArray;", "audioMime", "checkFileFormat", "fileFormatArray", "path", "checkQtVideo", "item", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "enableQT", "checkRestrictionEnable", "restriction", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "checkRestrictionsEnable", "restrictions", "checkVideoMime", "videoMime", "configEnable", "value", "", "getGlobalRestrictionCopy", "getSceneLowTimeRestriction", "scene", "getSceneTimeRestriction", "initDefaultRestriction", "initLocalSNSRestriction", "initSnsCoverRestriction", "limitLog", "", "string", "setSceneRestriction", "setupRestriction", "checkArray", "videoCheckSuffixSupportedError", "suffixArray", "originalPath", "videoEnableCheck", "videoEnableCheckBool", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b HQZ;
  private static final HashMap<Integer, JSONObject> HRa;
  private static int HRb;
  private static final HashMap<Integer, ArrayList<JSONObject>> HRc;
  
  static
  {
    AppMethodBeat.i(289332);
    HQZ = new b();
    HRa = new HashMap();
    HRc = new HashMap();
    Map localMap = (Map)HRa;
    JSONObject localJSONObject = new JSONObject();
    Object localObject = new JSONArray();
    ((JSONArray)localObject).put(".h264");
    ((JSONArray)localObject).put(".h26l");
    ((JSONArray)localObject).put(".264");
    ((JSONArray)localObject).put(".avc");
    ((JSONArray)localObject).put(".mov");
    ((JSONArray)localObject).put(".mp4");
    ((JSONArray)localObject).put(".m4a");
    ((JSONArray)localObject).put(".3gp");
    ((JSONArray)localObject).put(".3g2");
    ((JSONArray)localObject).put(".mj2");
    ((JSONArray)localObject).put(".m4v");
    localJSONObject.put("suffix", localObject);
    localObject = new JSONArray();
    ((JSONArray)localObject).put("video/avc");
    ((JSONArray)localObject).put("video/hevc");
    localJSONObject.put("video-mime", localObject);
    localObject = new com.tencent.mm.ad.f();
    ((com.tencent.mm.ad.f)localObject).cP("audio/mp4a-latm");
    localJSONObject.put("audio-mime", localObject);
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.znt, true))
    {
      localObject = new JSONArray();
      ((JSONArray)localObject).put("video/mp4");
      ((JSONArray)localObject).put("mov,mp4,m4a,3gp,3g2,mj2");
      localJSONObject.put("file-format", localObject);
    }
    localMap.put(Integer.valueOf(-1), localJSONObject);
    localMap = (Map)HRa;
    localJSONObject = new JSONObject();
    localJSONObject.put("include_local_setting", true);
    localJSONObject.put("min-duration-ms", 1000);
    localJSONObject.put("max-duration-ms", 300000);
    localMap.put(Integer.valueOf(31), localJSONObject);
    localMap = (Map)HRa;
    localJSONObject = new JSONObject();
    localJSONObject.put("include_local_setting", true);
    localObject = a.lZC;
    localJSONObject.put("max-duration-ms", a.aQz() * 1000);
    localMap.put(Integer.valueOf(4), localJSONObject);
    AppMethodBeat.o(289332);
  }
  
  private static boolean O(double paramDouble)
  {
    return paramDouble > 0.0D;
  }
  
  public static int WU(int paramInt)
  {
    AppMethodBeat.i(289300);
    JSONObject localJSONObject1 = (JSONObject)HRa.get(Integer.valueOf(paramInt));
    JSONObject localJSONObject2 = (JSONObject)HRa.get(Integer.valueOf(-1));
    if ((localJSONObject1 != null) && (localJSONObject1.has("max-duration-ms")))
    {
      paramInt = localJSONObject1.optInt("max-duration-ms", 300000);
      AppMethodBeat.o(289300);
      return paramInt;
    }
    if ((localJSONObject2 != null) && (localJSONObject2.has("max-duration-ms")))
    {
      paramInt = localJSONObject2.optInt("max-duration-ms", 300000);
      AppMethodBeat.o(289300);
      return paramInt;
    }
    AppMethodBeat.o(289300);
    return 300000;
  }
  
  public static int WV(int paramInt)
  {
    AppMethodBeat.i(289305);
    JSONObject localJSONObject1 = (JSONObject)HRa.get(Integer.valueOf(paramInt));
    JSONObject localJSONObject2 = (JSONObject)HRa.get(Integer.valueOf(-1));
    if ((localJSONObject1 != null) && (localJSONObject1.has("min-duration-ms")))
    {
      paramInt = localJSONObject1.optInt("min-duration-ms", 1000);
      AppMethodBeat.o(289305);
      return paramInt;
    }
    if ((localJSONObject2 != null) && (localJSONObject2.has("min-duration-ms")))
    {
      paramInt = localJSONObject2.optInt("min-duration-ms", 1000);
      AppMethodBeat.o(289305);
      return paramInt;
    }
    AppMethodBeat.o(289305);
    return 1000;
  }
  
  private static int a(ArrayList<JSONObject> paramArrayList, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(289317);
    if (paramArrayList.size() <= 0)
    {
      if (HRb % 20 == 0) {
        Log.i("MicroMsg.AlbumSelectRestriction", "never happen!!!");
      }
      AppMethodBeat.o(289317);
      return 0;
    }
    paramArrayList = paramArrayList.iterator();
    label393:
    label1047:
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
              break label295;
            }
            Log.i("MicroMsg.AlbumSelectRestriction", "disable by long side ,origin:" + Math.max(((GalleryItem.VideoMediaItem)paramMediaItem).videoHeight, ((GalleryItem.VideoMediaItem)paramMediaItem).videoWidth) + " config:" + n);
            i = 301;
          }
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label1047;
        }
        AppMethodBeat.o(289317);
        return i;
        i = 0;
        break;
        label295:
        if (m > 0) {}
        for (i = 1;; i = 0)
        {
          if ((i == 0) || (Math.min(((GalleryItem.VideoMediaItem)paramMediaItem).videoHeight, ((GalleryItem.VideoMediaItem)paramMediaItem).videoWidth) >= m)) {
            break label393;
          }
          Log.i("MicroMsg.AlbumSelectRestriction", "disable by short side ,origin:" + Math.min(((GalleryItem.VideoMediaItem)paramMediaItem).videoHeight, ((GalleryItem.VideoMediaItem)paramMediaItem).videoWidth) + " config:" + m);
          i = 302;
          break;
        }
        if ((localObject2 != null) && (!a((JSONArray)localObject2, paramMediaItem.Gcc)))
        {
          Log.i("MicroMsg.AlbumSelectRestriction", s.X("disable by Suffix ,origin:", paramMediaItem.Gcc));
          i = 101;
        }
        else
        {
          localObject1 = (GalleryItem.VideoMediaItem)paramMediaItem;
          localObject2 = ((GalleryItem.VideoMediaItem)localObject1).Gcc;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            i = 0;
          }
          for (;;)
          {
            if (i != 0) {
              break label585;
            }
            Log.i("MicroMsg.AlbumSelectRestriction", "disable by qt file check");
            i = 102;
            break;
            boolean bool2 = com.tencent.mm.modelvideo.y.PK((String)localObject2);
            if (!bool2)
            {
              i = 1;
            }
            else if ((!bool1) && (bool2))
            {
              i = 0;
            }
            else if ((!Util.isNullOrNil(((GalleryItem.VideoMediaItem)localObject1).oTL)) && (com.tencent.mm.plugin.u.f.aMo(((GalleryItem.VideoMediaItem)localObject1).oTL)) && (!Util.isNullOrNil(((GalleryItem.VideoMediaItem)localObject1).oTM)) && (com.tencent.mm.plugin.u.f.aMo(((GalleryItem.VideoMediaItem)localObject1).oTM)))
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
          label585:
          if (k > 0) {}
          for (i = 1;; i = 0)
          {
            if ((i == 0) || (((GalleryItem.VideoMediaItem)paramMediaItem).oTN >= k)) {
              break label663;
            }
            Log.i("MicroMsg.AlbumSelectRestriction", "disable by min time,origin:" + ((GalleryItem.VideoMediaItem)paramMediaItem).oTN + " config:" + k);
            i = 201;
            break;
          }
          label663:
          if (j > 0) {}
          for (i = 1;; i = 0)
          {
            if ((i == 0) || (((GalleryItem.VideoMediaItem)paramMediaItem).oTN <= j)) {
              break label741;
            }
            Log.i("MicroMsg.AlbumSelectRestriction", "disable by max time,origin:" + ((GalleryItem.VideoMediaItem)paramMediaItem).oTN + " config:" + j);
            i = 202;
            break;
          }
          label741:
          float f;
          if (O(d1))
          {
            f = ((GalleryItem.VideoMediaItem)paramMediaItem).videoHeight / ((GalleryItem.VideoMediaItem)paramMediaItem).videoWidth;
            if (f > d1)
            {
              Log.i("MicroMsg.AlbumSelectRestriction", "disable by max ratio,origin:" + f + " config:" + d1);
              i = 303;
              continue;
            }
          }
          if (O(d2))
          {
            f = ((GalleryItem.VideoMediaItem)paramMediaItem).videoHeight / ((GalleryItem.VideoMediaItem)paramMediaItem).videoWidth;
            if (f < d2)
            {
              Log.i("MicroMsg.AlbumSelectRestriction", "disable by min ratio,origin:" + f + " config:" + d2);
              i = 304;
              continue;
            }
          }
          if (!b(localJSONArray1, ((GalleryItem.VideoMediaItem)paramMediaItem).oTL))
          {
            Log.i("MicroMsg.AlbumSelectRestriction", "disable by video mime check,origin:" + ((GalleryItem.VideoMediaItem)paramMediaItem).oTL + " config:" + localJSONArray1);
            i = 103;
          }
          else if (!c(localJSONArray2, ((GalleryItem.VideoMediaItem)paramMediaItem).oTM))
          {
            Log.i("MicroMsg.AlbumSelectRestriction", "disable by video mime check,origin:" + ((GalleryItem.VideoMediaItem)paramMediaItem).oTL + " config:" + localJSONArray1);
            i = 104;
          }
          else if (!d(localJSONArray3, paramMediaItem.Gcc))
          {
            Log.i("MicroMsg.AlbumSelectRestriction", "disable by file format check");
            i = 105;
          }
          else
          {
            i = 0;
          }
        }
      }
    }
    AppMethodBeat.o(289317);
    return 0;
  }
  
  private static void a(ArrayList<JSONObject> paramArrayList, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(289308);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(289308);
      return;
    }
    paramArrayList.add(paramJSONObject);
    if (paramJSONObject.optBoolean("include_local_setting", false))
    {
      paramJSONObject = (JSONObject)HRa.get(Integer.valueOf(-1));
      if (paramJSONObject != null) {
        paramArrayList.add(paramJSONObject);
      }
    }
    AppMethodBeat.o(289308);
  }
  
  private static boolean a(JSONArray paramJSONArray, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(289320);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(289320);
      return false;
    }
    s.checkNotNull(paramString);
    paramString = (CharSequence)paramString;
    int i = paramString.length() - 1;
    int k = 0;
    int j = 0;
    while (j <= i)
    {
      int m;
      if (k == 0)
      {
        m = j;
        label63:
        if (s.compare(paramString.charAt(m), 32) > 0) {
          break label104;
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
            label104:
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
      AppMethodBeat.o(289320);
      return false;
    }
    if (paramString == null)
    {
      paramJSONArray = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(289320);
      throw paramJSONArray;
    }
    paramString = paramString.substring(i);
    s.s(paramString, "(this as java.lang.String).substring(startIndex)");
    if (paramString == null)
    {
      paramJSONArray = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(289320);
      throw paramJSONArray;
    }
    paramString = paramString.toLowerCase();
    s.s(paramString, "(this as java.lang.String).toLowerCase()");
    k = paramJSONArray.length();
    if (k > 0)
    {
      i = 0;
      bool = false;
      j = i + 1;
      String str = paramJSONArray.optString(i);
      s.s(str, "suffixArray.optString(i)");
      str = str.toLowerCase();
      s.s(str, "(this as java.lang.String).toLowerCase()");
      if (!s.p(str, paramString)) {
        break label327;
      }
      bool = true;
    }
    label327:
    for (;;)
    {
      if (j >= k)
      {
        AppMethodBeat.o(289320);
        return bool;
      }
      i = j;
      break;
    }
  }
  
  private static boolean b(JSONArray paramJSONArray, String paramString)
  {
    AppMethodBeat.i(289325);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(289325);
      return true;
    }
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(289325);
      return false;
    }
    int m = paramJSONArray.length();
    int j;
    int i;
    int k;
    if (m > 0)
    {
      j = 0;
      i = 0;
      k = j + 1;
      if (n.T(paramJSONArray.optString(j), paramString, true)) {
        i = 1;
      }
      if (k < m) {}
    }
    for (;;)
    {
      if (i == 0)
      {
        AppMethodBeat.o(289325);
        return false;
      }
      if ((n.T("video/hevc", paramString, true)) && (!com.tencent.mm.plugin.u.f.gbA()))
      {
        AppMethodBeat.o(289325);
        return false;
      }
      AppMethodBeat.o(289325);
      return true;
      j = k;
      break;
      i = 0;
    }
  }
  
  public static void bk(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(289289);
    s.u(paramJSONObject, "restriction");
    ((Map)HRa).put(Integer.valueOf(25), paramJSONObject);
    AppMethodBeat.o(289289);
  }
  
  private static boolean c(JSONArray paramJSONArray, String paramString)
  {
    AppMethodBeat.i(289327);
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(289327);
      return true;
    }
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(289327);
      return true;
    }
    int k = paramJSONArray.length();
    int i;
    boolean bool;
    int j;
    if (k > 0)
    {
      i = 0;
      bool = false;
      j = i + 1;
      if (n.T(paramJSONArray.optString(i), paramString, true)) {
        bool = true;
      }
      if (j < k) {}
    }
    for (;;)
    {
      AppMethodBeat.o(289327);
      return bool;
      i = j;
      break;
      bool = false;
    }
  }
  
  private static boolean d(JSONArray paramJSONArray, String paramString)
  {
    AppMethodBeat.i(289328);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(289328);
      return false;
    }
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      AppMethodBeat.o(289328);
      return true;
    }
    if (!com.tencent.mm.vfs.y.ZC(paramString))
    {
      AppMethodBeat.o(289328);
      return false;
    }
    Object localObject = new com.tencent.mm.compatible.i.c();
    s.checkNotNull(paramString);
    ((com.tencent.mm.compatible.i.c)localObject).setDataSource(paramString);
    localObject = ((com.tencent.mm.compatible.i.c)localObject).getTrackFormat(0);
    s.s(localObject, "extractor.getTrackFormat(0)");
    if (!((MediaFormat)localObject).containsKey("file-format"))
    {
      localObject = com.tencent.mm.plugin.sight.base.f.aVX(paramString);
      Log.i("MicroMsg.AlbumSelectRestriction", "path:" + paramString + " format:" + ((com.tencent.mm.plugin.sight.base.b)localObject).PFf + " long-format:" + ((com.tencent.mm.plugin.sight.base.b)localObject).PFg);
    }
    for (localObject = ((com.tencent.mm.plugin.sight.base.b)localObject).PFf;; localObject = ((MediaFormat)localObject).getString("file-format"))
    {
      Log.i("MicroMsg.AlbumSelectRestriction", "path:" + paramString + " final format:" + localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      AppMethodBeat.o(289328);
      return true;
    }
    int k = paramJSONArray.length();
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (n.T(paramJSONArray.optString(i), (String)localObject, true))
      {
        AppMethodBeat.o(289328);
        return true;
      }
      if (j >= k)
      {
        AppMethodBeat.o(289328);
        return false;
      }
    }
  }
  
  public static JSONObject fBR()
  {
    AppMethodBeat.i(289294);
    JSONObject localJSONObject = new JSONObject(String.valueOf(HRa.get(Integer.valueOf(-1))));
    AppMethodBeat.o(289294);
    return localJSONObject;
  }
  
  public final boolean b(int paramInt, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(289336);
    s.u(paramMediaItem, "item");
    if (c(paramInt, paramMediaItem) == 0)
    {
      AppMethodBeat.o(289336);
      return true;
    }
    AppMethodBeat.o(289336);
    return false;
  }
  
  public final int c(int paramInt, GalleryItem.MediaItem paramMediaItem)
  {
    AppMethodBeat.i(289342);
    s.u(paramMediaItem, "item");
    ArrayList localArrayList;
    if (!HRc.containsKey(Integer.valueOf(paramInt)))
    {
      localObject1 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.znu, "");
      Log.i("MicroMsg.AlbumSelectRestriction", "print scene:" + paramInt + " restriction:" + localObject1);
      localArrayList = new ArrayList();
    }
    try
    {
      localJSONArray = new JSONArray((String)localObject1);
      i = 0;
      k = localJSONArray.length();
      if (k <= 0) {
        break label360;
      }
      localObject3 = null;
      localObject1 = null;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        JSONArray localJSONArray;
        int i;
        int k;
        int j;
        Object localObject3 = null;
        Object localObject2 = null;
        continue;
        continue;
        localObject3 = null;
        localObject2 = null;
      }
    }
    j = i + 1;
    for (;;)
    {
      try
      {
        localJSONObject = localJSONArray.getJSONObject(i);
        i = localJSONObject.optInt("scene");
        if (i != paramInt) {
          continue;
        }
        localObject1 = localJSONObject;
      }
      catch (Exception localException2)
      {
        JSONObject localJSONObject;
        continue;
        continue;
        i = j;
      }
      try
      {
        i = localJSONObject.optInt("scene");
        if (i == -1) {
          localObject3 = localJSONObject;
        }
        if (j < k) {
          continue;
        }
      }
      catch (Exception localException3) {}
    }
    a(localArrayList, (JSONObject)localObject1);
    if (localArrayList.size() <= 0) {
      a(localArrayList, localObject3);
    }
    if (localArrayList.size() <= 0) {
      a(localArrayList, (JSONObject)HRa.get(Integer.valueOf(paramInt)));
    }
    if (localArrayList.size() <= 0) {
      a(localArrayList, (JSONObject)HRa.get(Integer.valueOf(-1)));
    }
    ((Map)HRc).put(Integer.valueOf(paramInt), localArrayList);
    Log.i("MicroMsg.AlbumSelectRestriction", s.X("checkArray size:", Integer.valueOf(localArrayList.size())));
    Object localObject1 = HRc.get(Integer.valueOf(paramInt));
    s.checkNotNull(localObject1);
    s.s(localObject1, "restrictionMap[scene]!!");
    paramInt = a((ArrayList)localObject1, paramMediaItem);
    AppMethodBeat.o(289342);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.b.b
 * JD-Core Version:    0.7.0.1
 */