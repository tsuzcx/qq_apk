package com.tencent.mm.plugin.finder.upload;

import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.model.cm;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.aa;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.loader.y;
import com.tencent.mm.plugin.finder.report.v.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.aow;
import com.tencent.mm.protocal.protobuf.awh;
import com.tencent.mm.protocal.protobuf.csc;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.eth;
import com.tencent.mm.protocal.protobuf.fbq;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.ScopedStorageUtil.MediaStoreOps;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/FinderPostFileManager;", "", "()V", "MARK_DEL_FILES", "", "TAG", "getTAG", "()Ljava/lang/String;", "fileLock", "Ljava/lang/Object;", "lastCheckPostingTime", "", "getLastCheckPostingTime", "()J", "setLastCheckPostingTime", "(J)V", "postingFileClaimers", "", "Lcom/tencent/mm/plugin/finder/upload/FinderPostFileManager$FileClaimer;", "getPostingFileClaimers", "()Ljava/util/List;", "_genImageThumbFile", "originFilePath", "thumbFile", "thumbRect", "Lcom/tencent/mm/protocal/protobuf/ViewRect;", "canCheckPostingFolder", "", "checkPostingFolder", "", "clearMarkFiles", "copyImageThumbToPost", "imagePath", "thumbOriginPath", "copyVideoThumbFileToPost", "videoFilePath", "genImageThumbFileForPost", "genImageThumbFileTmp", "genVideoOriginThumbFile", "Landroid/graphics/Bitmap;", "vfsPath", "genVideoThumbFile", "videoPath", "targetWidth", "", "targetHeight", "Landroid/graphics/Rect;", "dstPath", "genVideoThumbFileForPost", "input", "genVideoThumbFileTmp", "getTmpImageThumbPath", "getTmpVideoThumbPath", "suffix", "getVideoFirstBitmap", "isInPosting", "path", "markPostFileToDelete", "moveFileToPost", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "moveFileToPostForNormal", "moveFileToPostForVLog", "parseIntentOwnership", "intentStr", "ret", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "FileClaimer", "plugin-finder_release"})
public final class f
{
  private static final String AzV = "MARK_DEL_FILES";
  private static final Object AzW;
  static long AzX = 0L;
  static final List<a> AzY;
  public static final f AzZ;
  static final String TAG = "finder.FinderPostFileManager";
  
  static
  {
    AppMethodBeat.i(167748);
    AzZ = new f();
    TAG = "finder.FinderPostFileManager";
    AzV = "MARK_DEL_FILES";
    AzW = new Object();
    List localList = (List)new ArrayList();
    localList.add(new b());
    localList.add(new c());
    AzY = localList;
    AppMethodBeat.o(167748);
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(167739);
    p.k(paramString, "input");
    Log.i(TAG, "genVideoThumbFileTmp input:" + paramString + ", targetWidth:" + paramInt1 + ", targetHeight:" + paramInt2 + ", thumbRect:" + paramRect);
    paramString = a(paramString, paramInt1, paramInt2, paramRect, "");
    AppMethodBeat.o(167739);
    return paramString;
  }
  
  private static String a(String paramString1, int paramInt1, int paramInt2, Rect paramRect, String paramString2)
  {
    AppMethodBeat.i(167742);
    String str = paramString2;
    if (Util.isNullOrNil(paramString2)) {
      str = hn(paramString1, String.valueOf(System.currentTimeMillis()));
    }
    paramString2 = com.tencent.mm.vfs.u.n(paramString1, false);
    Log.i(TAG, "genVideoThumbFile savepath:" + str + ", input:" + paramString2);
    paramString1 = com.tencent.mm.plugin.mmsight.d.Xd(paramString1);
    if (paramString1 == null)
    {
      paramString1 = i.AAy;
      if (i.aFo(str))
      {
        Log.i(TAG, "genVideoThumbFile file exist");
        AppMethodBeat.o(167742);
        return str;
      }
      if (com.tencent.mm.plugin.sight.base.f.aYg(paramString2) != null)
      {
        paramString1 = i.AAy;
        paramString1 = i.eh(paramString2, 4);
        paramInt1 = SightVideoJNI.getMp4RotateVFS(paramString2);
        paramString1 = com.tencent.mm.plugin.sight.base.f.aC(paramString2, paramString1.x, paramString1.y);
        Log.i(TAG, "genVideoThumbFile file %s rotate %d", new Object[] { paramString2, Integer.valueOf(paramInt1) });
        if (paramString1 != null) {
          BitmapUtil.saveBitmapToImage(paramString1, 70, Bitmap.CompressFormat.JPEG, str, false);
        }
      }
      if (!com.tencent.mm.vfs.u.agG(str)) {
        Log.e(TAG, "genVideoThumbFile failed.");
      }
      AppMethodBeat.o(167742);
      return str;
    }
    paramString2 = Bitmap.createBitmap(paramInt1, paramInt2, paramString1.getConfig());
    Canvas localCanvas = new Canvas(paramString2);
    if (paramRect != null)
    {
      Log.i(TAG, "genVideoThumbFile crop by rect");
      paramRect = new Rect(paramRect.left, paramRect.bottom, paramRect.right, paramRect.top);
      p.j(paramString2, "cropThumb");
      localCanvas.drawBitmap(paramString1, paramRect, new Rect(0, 0, paramString2.getWidth(), paramString2.getHeight()), new Paint());
    }
    for (;;)
    {
      BitmapUtil.saveBitmapToImage(paramString2, 80, Bitmap.CompressFormat.JPEG, str, false);
      break;
      Log.i(TAG, "genVideoThumbFile no rect");
      p.j(paramString2, "cropThumb");
      localCanvas.drawBitmap(paramString1, null, new Rect(0, 0, paramString2.getWidth(), paramString2.getHeight()), new Paint());
    }
  }
  
  public static String a(String paramString1, String paramString2, int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(277737);
    p.k(paramString1, "input");
    p.k(paramString2, "dstPath");
    Log.i(TAG, "genVideoThumbFileForPost input:" + paramString1 + ", targetWidth:" + paramInt1 + ", targetHeight:" + paramInt2 + ", thumbRect:" + paramRect + ", dstPath:" + paramString2);
    paramString1 = a(paramString1, paramInt1, paramInt2, paramRect, paramString2);
    AppMethodBeat.o(277737);
    return paramString1;
  }
  
  public static String aFj(String paramString)
  {
    AppMethodBeat.i(167740);
    p.k(paramString, "input");
    Object localObject = i.AAy;
    localObject = i.eh(paramString, 4);
    Log.i(TAG, "genVideoThumbFileTmp input:" + paramString + ", targetWidth:" + ((Point)localObject).x + ", targetHeight:" + ((Point)localObject).y);
    paramString = a(paramString, ((Point)localObject).x, ((Point)localObject).y, null, "");
    AppMethodBeat.o(167740);
    return paramString;
  }
  
  public static void aFl(String paramString)
  {
    AppMethodBeat.i(167745);
    p.k(paramString, "path");
    synchronized (AzW)
    {
      Log.i(TAG, "FinderFileTrack markPostFileToDelete ".concat(String.valueOf(paramString)));
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleDefault();
      Set localSet = localMultiProcessMMKV.getStringSet(AzV, (Set)new HashSet());
      if (localSet == null) {
        p.iCn();
      }
      localSet.add(paramString);
      localMultiProcessMMKV.putStringSet(AzV, localSet).commit();
      AppMethodBeat.o(167745);
      return;
    }
  }
  
  private static boolean aFm(String paramString)
  {
    AppMethodBeat.i(277743);
    if (paramString != null)
    {
      av localav = av.AJz;
      boolean bool = n.M(paramString, av.egu(), false);
      AppMethodBeat.o(277743);
      return bool;
    }
    AppMethodBeat.o(277743);
    return false;
  }
  
  public static void ecf()
  {
    AppMethodBeat.i(167746);
    Set localSet;
    synchronized (AzW)
    {
      l = Util.currentTicks();
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleDefault();
      localSet = localMultiProcessMMKV.getStringSet(AzV, (Set)new HashSet());
      if (localSet != null)
      {
        Iterator localIterator = ((Iterable)localSet).iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Log.i(TAG, "FinderFileTrack clearMarkFiles ".concat(String.valueOf(str)));
          com.tencent.mm.vfs.u.deleteFile(str);
        }
      }
    }
    localObject2.putStringSet(AzV, (Set)new HashSet());
    long l = Util.ticksToNow(l);
    if ((localSet != null) && (localSet.size() > 0))
    {
      localObject3 = v.a.zXP;
      v.a.Mu(l);
    }
    Log.i(TAG, "clearMarkFolder cost:".concat(String.valueOf(l)));
    Object localObject3 = x.aazN;
    AppMethodBeat.o(167746);
  }
  
  public static boolean ecg()
  {
    AppMethodBeat.i(167747);
    long l1 = cm.bfC();
    long l2 = AzX;
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (l1 - l2 > com.tencent.mm.plugin.finder.storage.d.dSv())
    {
      AppMethodBeat.o(167747);
      return true;
    }
    AppMethodBeat.o(167747);
    return false;
  }
  
  private static String hn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167738);
    p.k(paramString1, "originFilePath");
    p.k(paramString2, "suffix");
    StringBuilder localStringBuilder = new StringBuilder();
    av localav = av.AJz;
    paramString1 = av.egt() + "video_" + MD5Util.getMD5String(paramString1) + "_" + paramString2 + "_thumb";
    AppMethodBeat.o(167738);
    return paramString1;
  }
  
  private static String ho(String paramString1, String paramString2)
  {
    AppMethodBeat.i(277739);
    Object localObject = i.AAy;
    if (i.aFo(paramString2))
    {
      AppMethodBeat.o(277739);
      return paramString2;
    }
    localObject = i.AAy;
    localObject = i.eh(paramString1, 2);
    Bitmap localBitmap = BitmapUtil.createThumbCropBitmap(paramString1, ((Point)localObject).x, ((Point)localObject).y, true);
    Exif localExif = Exif.fromFile(paramString1);
    p.j(localExif, "Exif.fromFile(originFilePath)");
    int i = localExif.getOrientationInDegree();
    Log.i(TAG, "_genImageThumbFile, file %s rotate %d. originThumbWidth:%s, originThumbHeight:%s", new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(((Point)localObject).x), Integer.valueOf(((Point)localObject).y) });
    if (localBitmap != null)
    {
      Log.i(TAG, "_genImageThumbFile, file %s cropThumbWidth:%s, cropThumbHeight:%s", new Object[] { paramString1, Integer.valueOf(localBitmap.getWidth()), Integer.valueOf(localBitmap.getHeight()) });
      BitmapUtil.saveBitmapToImage(localBitmap, 70, Bitmap.CompressFormat.JPEG, paramString2, false);
    }
    AppMethodBeat.o(277739);
    return paramString2;
  }
  
  public static void t(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(277741);
    p.k(paramFinderItem, "finderObj");
    Log.i("Finder.LogPost.FinderPostTask", "moveFileToPost");
    Object localObject1 = av.AJz;
    localObject1 = av.egu();
    com.tencent.mm.vfs.u.bBD((String)localObject1);
    Object localObject2 = h.AAs;
    if ((h.eco()) && (Log.getLogLevel() <= 1))
    {
      Log.i("Finder.LogPost.FinderPostTask", "debugDeleteFileWhenMoveFile");
      com.tencent.mm.vfs.u.dK((String)localObject1, true);
    }
    Object localObject3;
    if (!paramFinderItem.isMvFeed())
    {
      if ((paramFinderItem.getMediaExtList().size() != 1) || (((csg)paramFinderItem.getMediaExtList().get(0)).TpG == null)) {
        break label685;
      }
      p.k(paramFinderItem, "finderObj");
      localObject3 = ((csg)paramFinderItem.getMediaExtList().get(0)).TpG;
      if (localObject3 != null)
      {
        localObject1 = ((acu)localObject3).Sou;
        if (localObject1 != null)
        {
          Iterator localIterator = ((Iterable)localObject1).iterator();
          while (localIterator.hasNext())
          {
            eth localeth = (eth)localIterator.next();
            if (com.tencent.mm.vfs.u.agG(localeth.path))
            {
              localObject1 = localeth.path;
              p.j(localObject1, "it.path");
              localObject2 = av.AJz;
              if (!n.M((String)localObject1, av.egu(), false))
              {
                localObject1 = av.AJz;
                String str = av.aGe(MD5Util.getMD5String(localeth.path) + localeth.hashCode());
                localObject2 = localeth.path;
                localObject1 = localObject2;
                if (Build.VERSION.SDK_INT >= 30)
                {
                  Uri localUri = ScopedStorageUtil.MediaStoreOps.videoOrImagePathToUri(MMApplicationContext.getContext(), (String)localObject2);
                  localObject1 = localObject2;
                  if (localObject2 != null) {
                    localObject1 = String.valueOf(localUri);
                  }
                }
                com.tencent.mm.vfs.u.on((String)localObject1, str);
                Log.i("Finder.LogPost.FinderPostTask", "copy " + localeth.path + " to " + str + "  real:" + com.tencent.mm.vfs.u.n(str, false) + ",result:" + com.tencent.mm.vfs.u.agG(str));
                if (com.tencent.mm.vfs.u.agG(str))
                {
                  if (localeth.NmG == 1)
                  {
                    localObject1 = com.tencent.mm.plugin.recordvideo.e.d.IeU;
                    com.tencent.mm.plugin.recordvideo.e.d.aWg(localeth.path);
                  }
                  localObject1 = ((acu)localObject3).SoA;
                  p.j(localObject1, "compositionInfo.trackLabelInfoList");
                  localObject2 = ((Iterable)localObject1).iterator();
                  do
                  {
                    if (!((Iterator)localObject2).hasNext()) {
                      break;
                    }
                    localObject1 = ((Iterator)localObject2).next();
                  } while (!p.h(((acw)localObject1).path, localeth.path));
                  for (;;)
                  {
                    localObject1 = (acw)localObject1;
                    if (localObject1 != null) {
                      ((acw)localObject1).path = str;
                    }
                    localeth.path = str;
                    break;
                    localObject1 = null;
                  }
                }
              }
            }
          }
        }
      }
      localObject2 = ((csg)paramFinderItem.getMediaExtList().get(0)).thumbUrl;
      if ((com.tencent.mm.vfs.u.agG((String)localObject2)) && (localObject2 != null))
      {
        localObject1 = av.AJz;
        if (!n.M((String)localObject2, av.egu(), false))
        {
          localObject1 = av.AJz;
          localObject3 = av.aGe(MD5Util.getMD5String((String)localObject2) + ((String)localObject2).hashCode());
          if (Build.VERSION.SDK_INT < 30) {
            break label692;
          }
        }
      }
    }
    label685:
    label692:
    for (localObject1 = String.valueOf(ScopedStorageUtil.MediaStoreOps.imagePathToUri(MMApplicationContext.getContext(), (String)localObject2));; localObject1 = localObject2)
    {
      com.tencent.mm.vfs.u.on((String)localObject1, (String)localObject3);
      Log.i("Finder.LogPost.FinderPostTask", "copy thumb" + (String)localObject2 + " to " + (String)localObject3 + "  real:" + com.tencent.mm.vfs.u.n((String)localObject3, false) + ",result:" + com.tencent.mm.vfs.u.agG((String)localObject3));
      if (com.tencent.mm.vfs.u.agG((String)localObject3))
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.e.d.IeU;
        com.tencent.mm.plugin.recordvideo.e.d.aWg((String)localObject2);
        ((csg)paramFinderItem.getMediaExtList().get(0)).thumbUrl = ((String)localObject3);
      }
      for (;;)
      {
        paramFinderItem.setMediaList(paramFinderItem.getMediaList());
        localObject1 = c.AnK;
        c.a.s(paramFinderItem);
        AppMethodBeat.o(277741);
        return;
        u(paramFinderItem);
      }
    }
  }
  
  private static void u(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(277747);
    p.k(paramFinderItem, "finderObj");
    Iterator localIterator = ((Iterable)paramFinderItem.getMediaList()).iterator();
    int i = 0;
    label1282:
    if (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      if (i < 0) {
        j.iBO();
      }
      csg localcsg = (csg)localObject1;
      boolean bool1 = com.tencent.mm.vfs.u.agG(localcsg.url);
      boolean bool2 = com.tencent.mm.vfs.u.agG(localcsg.thumbUrl);
      boolean bool3 = com.tencent.mm.vfs.u.agG(localcsg.coverUrl);
      localObject1 = MD5Util.getMD5String(localcsg.url);
      boolean bool4 = aFm(localcsg.url);
      boolean bool5 = aFm(localcsg.thumbUrl);
      boolean bool6 = aFm(localcsg.coverUrl);
      Log.i(TAG, "moveFileToPost, mediaId: " + (String)localObject1 + ", fileExist:" + bool1 + ", thumbExist:" + bool2 + ", before url: " + localcsg.url + ", " + localcsg.thumbUrl + ", " + localcsg.coverUrl);
      if ((bool1) || (bool2)) {
        switch (localcsg.mediaType)
        {
        }
      }
      label910:
      label1300:
      for (;;)
      {
        Log.i("Finder.LogPost.FinderPostTask", "moveFileToPost, after mediaId: " + localcsg.mediaId + ", url: " + localcsg.url + ", " + localcsg.thumbUrl + ", " + localcsg.coverUrl);
        i += 1;
        break;
        Object localObject2;
        Object localObject3;
        i locali;
        if ((bool1) && (bool2) && (!bool5))
        {
          Log.i("Finder.LogPost.FinderPostTask", "moveFileToPost Image thumb");
          localObject2 = localcsg.url;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject3 = localcsg.thumbUrl;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          p.k(localObject1, "imagePath");
          p.k(localObject2, "thumbOriginPath");
          localObject3 = av.AJz;
          p.k(localObject1, "imagePath");
          localObject3 = av.egu() + "image_" + MD5Util.getMD5String((String)localObject1) + "_" + com.tencent.mm.vfs.u.bBR((String)localObject1) + "_thumb";
          Log.i(TAG, "copyImageThumbFromTmpToPost, imagePath:" + (String)localObject1 + ", thumbOriginPath:" + (String)localObject2 + ", thumbPostPath:" + (String)localObject3);
          locali = i.AAy;
          if (!i.aFo((String)localObject2)) {
            break label676;
          }
          Log.i(TAG, "copyImageThumbFromTmpToPost exist, copy");
          com.tencent.mm.vfs.u.on((String)localObject2, (String)localObject3);
        }
        long l;
        for (;;)
        {
          if (com.tencent.mm.vfs.u.agG((String)localObject3)) {
            localcsg.thumbUrl = ((String)localObject3);
          }
          if ((!bool1) || (bool4)) {
            break;
          }
          Log.i("Finder.LogPost.FinderPostTask", "moveFileToPost Image");
          localObject1 = new r(localcsg, com.tencent.mm.plugin.finder.storage.u.Aly, null, null, 12);
          localObject2 = av.AJz;
          localObject1 = av.a((r)localObject1, String.valueOf(paramFinderItem.getCreateTime()));
          l = com.tencent.mm.vfs.u.on(localcsg.url, (String)localObject1);
          if (!com.tencent.mm.vfs.u.agG((String)localObject1)) {
            break label696;
          }
          localcsg.url = ((String)localObject1);
          localcsg.mediaId = MD5Util.getMD5String(localcsg.url);
          break;
          label676:
          Log.i(TAG, "copyImageThumbFromTmpToPost not exist, generate");
          ho((String)localObject1, (String)localObject3);
        }
        label696:
        Log.i("Finder.LogPost.FinderPostTask", "copy Image failed, copyRet:".concat(String.valueOf(l)));
        continue;
        if ((bool1) && (bool2) && (!bool5))
        {
          Log.i("Finder.LogPost.FinderPostTask", "moveFileToPost Video thumb");
          localObject2 = localcsg.thumbUrl;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          p.j(localObject1, "it.thumbUrl ?: \"\"");
          localObject2 = localcsg.url;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject3 = localcsg.thumbUrl;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          p.k(localObject1, "videoFilePath");
          p.k(localObject2, "thumbOriginPath");
          localObject3 = av.AJz;
          localObject3 = av.aGf((String)localObject1);
          Log.i(TAG, "copyVideoThumbFileToPost, videoFilePath:" + (String)localObject1 + ", thumbOriginPath:" + (String)localObject2 + ", thumbPostPath:" + (String)localObject3);
          locali = i.AAy;
          if (!i.aFo((String)localObject2)) {
            break label1188;
          }
          Log.i(TAG, "copyImageThumbFromTmpToPost exist, copy");
          com.tencent.mm.vfs.u.on((String)localObject2, (String)localObject3);
          if (com.tencent.mm.vfs.u.agG((String)localObject3)) {
            localcsg.thumbUrl = ((String)localObject3);
          }
        }
        if ((bool1) && (!bool4))
        {
          Log.i("Finder.LogPost.FinderPostTask", "moveFileToPost Video");
          localObject1 = new aa(localcsg, com.tencent.mm.plugin.finder.storage.u.AlL, 0, null, 12);
          localObject2 = av.AJz;
          localObject1 = av.a((aa)localObject1, String.valueOf(paramFinderItem.getCreateTime()));
          l = com.tencent.mm.vfs.u.on(localcsg.url, (String)localObject1);
          if (!com.tencent.mm.vfs.u.agG((String)localObject1)) {
            break label1282;
          }
          localcsg.url = ((String)localObject1);
          localObject2 = localcsg.url;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localcsg.mediaId = MD5Util.getMD5String((String)localObject1);
        }
        for (;;)
        {
          if ((!bool3) || (bool6)) {
            break label1300;
          }
          localObject1 = localcsg.coverUrl;
          if (localObject1 == null) {
            break;
          }
          localObject2 = av.AJz;
          if (n.M((String)localObject1, av.egu(), false) != true) {
            break;
          }
          Log.i("Finder.LogPost.FinderPostTask", "moveFileToPost Cover");
          localObject1 = new y(localcsg, com.tencent.mm.plugin.finder.storage.u.Aly);
          localObject2 = av.AJz;
          localObject2 = String.valueOf(paramFinderItem.getCreateTime());
          p.k(localObject1, "image");
          p.k(localObject2, "suffix");
          localObject1 = av.egu() + ((y)localObject1).aBv() + "_" + (String)localObject2;
          com.tencent.mm.vfs.u.on(localcsg.coverUrl, (String)localObject1);
          localcsg.coverUrl = ((String)localObject1);
          break;
          label1188:
          Log.i(TAG, "copyImageThumbFromTmpToPost not exist, generate");
          localObject2 = i.AAy;
          localObject2 = i.eh((String)localObject1, 4);
          Log.i(TAG, "genVideoThumbFileTmp videoFilePath:" + (String)localObject1 + ", targetWidth:" + ((Point)localObject2).x + ", targetHeight:" + ((Point)localObject2).y);
          a((String)localObject1, ((Point)localObject2).x, ((Point)localObject2).y, null, (String)localObject3);
          break label910;
          Log.i("Finder.LogPost.FinderPostTask", "copy Video failed, copyRet:".concat(String.valueOf(l)));
        }
      }
    }
    AppMethodBeat.o(277747);
  }
  
  public final String a(String paramString, fbq paramfbq)
  {
    AppMethodBeat.i(167741);
    p.k(paramString, "input");
    p.k(paramfbq, "thumbRect");
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    int i = com.tencent.mm.plugin.finder.storage.d.dRI().lJy;
    paramString = a(paramString, i, (int)((paramfbq.top - paramfbq.bottom) / (paramfbq.right - paramfbq.left) * i), new Rect(paramfbq.left, paramfbq.top, paramfbq.right, paramfbq.bottom));
    AppMethodBeat.o(167741);
    return paramString;
  }
  
  public final String aj(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(277736);
    p.k(paramString, "input");
    av localav = av.AJz;
    paramString = a(paramString, av.aGf(paramString), paramInt1, paramInt2, null);
    AppMethodBeat.o(277736);
    return paramString;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/FinderPostFileManager$FileClaimer;", "", "listOwnFiles", "", "", "name", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract List<String> ech();
    
    public abstract String name();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/upload/FinderPostFileManager$postingFileClaimers$1$1", "Lcom/tencent/mm/plugin/finder/upload/FinderPostFileManager$FileClaimer;", "listOwnFiles", "", "", "name", "plugin-finder_release"})
  public static final class b
    implements f.a
  {
    public final List<String> ech()
    {
      AppMethodBeat.i(242107);
      Object localObject1 = new ArrayList();
      Iterator localIterator1 = ((Iterable)((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFeedStorage().dYD()).iterator();
      while (localIterator1.hasNext())
      {
        Object localObject2 = (FinderItem)localIterator1.next();
        Iterator localIterator2 = ((Iterable)((FinderItem)localObject2).getMediaList()).iterator();
        Object localObject3;
        while (localIterator2.hasNext())
        {
          localObject3 = (csg)localIterator2.next();
          ((ArrayList)localObject1).add(((csg)localObject3).url);
          ((ArrayList)localObject1).add(((csg)localObject3).thumbUrl);
          ((ArrayList)localObject1).add(((csg)localObject3).coverUrl);
          ((ArrayList)localObject1).add(((csg)localObject3).TzX);
          localObject3 = ((csg)localObject3).TpG;
          if (localObject3 != null)
          {
            localObject3 = ((acu)localObject3).Sou;
            if (localObject3 != null)
            {
              localObject3 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject3).hasNext()) {
                ((ArrayList)localObject1).add(((eth)((Iterator)localObject3).next()).path);
              }
            }
          }
        }
        localIterator2 = ((Iterable)((FinderItem)localObject2).getLongVideoMediaList()).iterator();
        while (localIterator2.hasNext())
        {
          localObject3 = (csg)localIterator2.next();
          ((ArrayList)localObject1).add(((csg)localObject3).url);
          ((ArrayList)localObject1).add(((csg)localObject3).thumbUrl);
          ((ArrayList)localObject1).add(((csg)localObject3).coverUrl);
          ((ArrayList)localObject1).add(((csg)localObject3).TzX);
          localObject3 = ((csg)localObject3).TpG;
          if (localObject3 != null)
          {
            localObject3 = ((acu)localObject3).Sou;
            if (localObject3 != null)
            {
              localObject3 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject3).hasNext()) {
                ((ArrayList)localObject1).add(((eth)((Iterator)localObject3).next()).path);
              }
            }
          }
        }
        localIterator2 = ((Iterable)((FinderItem)localObject2).getHalfVideoMediaExtList()).iterator();
        while (localIterator2.hasNext())
        {
          localObject3 = (csg)localIterator2.next();
          ((ArrayList)localObject1).add(((csg)localObject3).url);
          ((ArrayList)localObject1).add(((csg)localObject3).thumbUrl);
          ((ArrayList)localObject1).add(((csg)localObject3).coverUrl);
          ((ArrayList)localObject1).add(((csg)localObject3).TzX);
          localObject3 = ((csg)localObject3).TpG;
          if (localObject3 != null)
          {
            localObject3 = ((acu)localObject3).Sou;
            if (localObject3 != null)
            {
              localObject3 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject3).hasNext()) {
                ((ArrayList)localObject1).add(((eth)((Iterator)localObject3).next()).path);
              }
            }
          }
        }
        label496:
        localObject2 = ((Iterable)((FinderItem)localObject2).getClipListExt()).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localIterator2 = ((Iterable)((FinderItem)((Iterator)localObject2).next()).getMediaList()).iterator();
          while (localIterator2.hasNext())
          {
            localObject3 = (csg)localIterator2.next();
            ((ArrayList)localObject1).add(((csg)localObject3).url);
            ((ArrayList)localObject1).add(((csg)localObject3).thumbUrl);
            ((ArrayList)localObject1).add(((csg)localObject3).coverUrl);
            ((ArrayList)localObject1).add(((csg)localObject3).TzX);
            localObject3 = ((csg)localObject3).TpG;
            if (localObject3 == null) {
              break label496;
            }
            localObject3 = ((acu)localObject3).Sou;
            if (localObject3 == null) {
              break label496;
            }
            localObject3 = ((Iterable)localObject3).iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((ArrayList)localObject1).add(((eth)((Iterator)localObject3).next()).path);
            }
          }
        }
      }
      localObject1 = (List)localObject1;
      AppMethodBeat.o(242107);
      return localObject1;
    }
    
    public final String name()
    {
      return "unsentFileClaimer";
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/upload/FinderPostFileManager$postingFileClaimers$1$2", "Lcom/tencent/mm/plugin/finder/upload/FinderPostFileManager$FileClaimer;", "listOwnFiles", "", "", "name", "plugin-finder_release"})
  public static final class c
    implements f.a
  {
    public final List<String> ech()
    {
      AppMethodBeat.i(272393);
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = com.tencent.mm.kernel.h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.f)localObject1).aHp().get(ar.a.VAt, "").toString();
      Object localObject2 = f.AzZ;
      f.i((String)localObject1, localArrayList);
      localObject1 = com.tencent.mm.plugin.finder.storage.i.AkK;
      localObject2 = ((Iterable)com.tencent.mm.plugin.finder.storage.i.dYp()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        com.tencent.mm.plugin.finder.storage.h localh = (com.tencent.mm.plugin.finder.storage.h)((Iterator)localObject2).next();
        if ((!Util.isNullOrNil(localh.field_postIntent)) && ((localh.field_objectType == 1) || (localh.field_objectType == 0)))
        {
          localObject1 = f.AzZ;
          localObject1 = localh.field_postIntent;
          p.j(localObject1, "it.field_postIntent");
          f.i((String)localObject1, localArrayList);
        }
        if (localh.field_objectType == 2)
        {
          localObject1 = FinderItem.Companion;
          localObject1 = FinderItem.a.n(localh.dYm()).SCc;
          if (localObject1 != null)
          {
            localObject1 = ((csc)localObject1).TzN;
            if (localObject1 != null)
            {
              Iterator localIterator = ((Iterable)localObject1).iterator();
              label258:
              while (localIterator.hasNext())
              {
                localObject1 = ((awh)localIterator.next()).xcx;
                if (localObject1 != null)
                {
                  localObject1 = ((FinderObject)localObject1).objectDesc;
                  if (localObject1 != null)
                  {
                    localObject1 = ((FinderObjectDesc)localObject1).media;
                    if (localObject1 == null) {}
                  }
                }
                for (localObject1 = (FinderMedia)j.lp((List)localObject1);; localObject1 = null)
                {
                  if (localObject1 == null) {
                    break label258;
                  }
                  localArrayList.add(((FinderMedia)localObject1).url);
                  break;
                }
              }
            }
          }
          localObject1 = localh.field_finderItem.xcx;
          if (localObject1 != null)
          {
            localObject1 = ((FinderObject)localObject1).objectDesc;
            if (localObject1 != null)
            {
              localObject1 = ((FinderObjectDesc)localObject1).media;
              if (localObject1 != null)
              {
                localObject1 = (FinderMedia)j.lp((List)localObject1);
                if (localObject1 != null)
                {
                  localObject1 = ((FinderMedia)localObject1).url;
                  if (localObject1 != null) {
                    localArrayList.add(localObject1);
                  }
                }
              }
            }
          }
        }
      }
      localObject1 = (List)localArrayList;
      AppMethodBeat.o(272393);
      return localObject1;
    }
    
    public final String name()
    {
      return "draftFileClaimer";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.f
 * JD-Core Version:    0.7.0.1
 */