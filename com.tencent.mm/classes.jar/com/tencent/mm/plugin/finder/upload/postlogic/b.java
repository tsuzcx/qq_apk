package com.tencent.mm.plugin.finder.upload.postlogic;

import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.upload.h;
import com.tencent.mm.plugin.finder.upload.h.a;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.afd;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.ewu;
import com.tencent.mm.protocal.protobuf.fos;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.ScopedStorageUtil.MediaStoreOps;
import com.tencent.mm.vfs.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/FinderPostFileLogic;", "", "()V", "TAG", "", "checkIfNeedMarkDelete", "", "preUrl", "isInPosting", "", "path", "moveFileToPost", "draftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "moveFileToPostForNormal", "moveFileToPostForVLog", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b GdH;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(343019);
    GdH = new b();
    TAG = "Finder.FinderPostFileLogic";
    AppMethodBeat.o(343019);
  }
  
  private static boolean aBq(String paramString)
  {
    AppMethodBeat.i(343001);
    if (paramString == null)
    {
      AppMethodBeat.o(343001);
      return false;
    }
    bm localbm = bm.GlZ;
    boolean bool = kotlin.n.n.U(paramString, bm.fiu(), false);
    AppMethodBeat.o(343001);
    return bool;
  }
  
  public static void i(i parami)
  {
    AppMethodBeat.i(342978);
    s.u(parami, "draftItem");
    Log.i(TAG, "moveFileToPost draft");
    Object localObject = bm.GlZ;
    localObject = bm.fiu();
    y.bDX((String)localObject);
    h.a locala = h.GbZ;
    if ((h.fdX()) && (Log.getLogLevel() <= 1))
    {
      Log.i(TAG, "debugDeleteFileWhenMoveFile");
      y.ew((String)localObject, true);
    }
    if (!parami.isMvFeed())
    {
      localObject = parami.eYK();
      if ((((FinderItem)localObject).getMediaExtList().size() != 1) || (((dji)((FinderItem)localObject).getMediaExtList().get(0)).aaDI == null)) {
        break label145;
      }
      x((FinderItem)localObject);
    }
    for (;;)
    {
      ((FinderItem)localObject).setMediaList(((FinderItem)localObject).getMediaList());
      if (((FinderItem)localObject).isLongVideo()) {
        ((FinderItem)localObject).setLongVideoMediaList(((FinderItem)localObject).getLongVideoMediaList());
      }
      localObject = c.FNC;
      c.g(parami);
      AppMethodBeat.o(342978);
      return;
      label145:
      y((FinderItem)localObject);
    }
  }
  
  public static void w(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(342972);
    s.u(paramFinderItem, "finderObj");
    Log.i(TAG, "moveFileToPost");
    Object localObject = bm.GlZ;
    localObject = bm.fiu();
    y.bDX((String)localObject);
    h.a locala = h.GbZ;
    if ((h.fdX()) && (Log.getLogLevel() <= 1))
    {
      Log.i(TAG, "debugDeleteFileWhenMoveFile");
      y.ew((String)localObject, true);
    }
    if (!paramFinderItem.isMvFeed())
    {
      if ((paramFinderItem.getMediaExtList().size() != 1) || (((dji)paramFinderItem.getMediaExtList().get(0)).aaDI == null)) {
        break label140;
      }
      x(paramFinderItem);
    }
    for (;;)
    {
      paramFinderItem.setMediaList(paramFinderItem.getMediaList());
      if (paramFinderItem.isLongVideo()) {
        paramFinderItem.setLongVideoMediaList(paramFinderItem.getLongVideoMediaList());
      }
      localObject = d.FND;
      d.a.v(paramFinderItem);
      AppMethodBeat.o(342972);
      return;
      label140:
      y(paramFinderItem);
    }
  }
  
  private static void x(FinderItem paramFinderItem)
  {
    Object localObject2 = null;
    AppMethodBeat.i(342997);
    s.u(paramFinderItem, "finderObj");
    Object localObject4 = ((dji)paramFinderItem.getMediaExtList().get(0)).aaDI;
    Object localObject5;
    if (localObject4 != null)
    {
      localObject1 = ((afb)localObject4).Zng;
      if (localObject1 != null)
      {
        localObject5 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          fos localfos = (fos)((Iterator)localObject5).next();
          if (y.ZC(localfos.path))
          {
            localObject1 = localfos.path;
            s.s(localObject1, "it.path");
            localObject3 = bm.GlZ;
            if (!kotlin.n.n.U((String)localObject1, bm.fiu(), false))
            {
              localObject1 = bm.GlZ;
              String str = bm.aCh(s.X(MD5Util.getMD5String(localfos.path), Integer.valueOf(localfos.hashCode())));
              localObject3 = localfos.path;
              localObject1 = localObject3;
              if (Build.VERSION.SDK_INT >= 30)
              {
                Uri localUri = ScopedStorageUtil.MediaStoreOps.videoOrImagePathToUri(MMApplicationContext.getContext(), (String)localObject3);
                localObject1 = localObject3;
                if (localObject3 != null) {
                  localObject1 = String.valueOf(localUri);
                }
              }
              y.O((String)localObject1, str, false);
              Log.i(TAG, "copy " + localfos.path + " to " + str + "  real:" + y.n(str, false) + ",result:" + y.ZC(str));
              if (y.ZC(str))
              {
                if (localfos.Uaj == 1)
                {
                  localObject1 = com.tencent.mm.plugin.recordvideo.util.f.Obq;
                  com.tencent.mm.plugin.recordvideo.util.f.aTp(localfos.path);
                }
                localObject1 = ((afb)localObject4).Znm;
                s.s(localObject1, "compositionInfo.trackLabelInfoList");
                localObject3 = ((Iterable)localObject1).iterator();
                do
                {
                  if (!((Iterator)localObject3).hasNext()) {
                    break;
                  }
                  localObject1 = ((Iterator)localObject3).next();
                } while (!s.p(((afd)localObject1).path, localfos.path));
                for (;;)
                {
                  localObject1 = (afd)localObject1;
                  if (localObject1 != null) {
                    ((afd)localObject1).path = str;
                  }
                  localfos.path = str;
                  break;
                  localObject1 = null;
                }
              }
            }
          }
        }
      }
    }
    Object localObject3 = ((dji)paramFinderItem.getMediaExtList().get(0)).thumbUrl;
    if ((y.ZC((String)localObject3)) && (localObject3 != null))
    {
      localObject1 = bm.GlZ;
      if (!kotlin.n.n.U((String)localObject3, bm.fiu(), false))
      {
        localObject1 = bm.GlZ;
        localObject4 = bm.aCh(s.X(MD5Util.getMD5String((String)localObject3), Integer.valueOf(((String)localObject3).hashCode())));
        if (Build.VERSION.SDK_INT < 30) {
          break label1095;
        }
      }
    }
    label1089:
    label1095:
    for (Object localObject1 = String.valueOf(ScopedStorageUtil.MediaStoreOps.imagePathToUri(MMApplicationContext.getContext(), (String)localObject3));; localObject1 = localObject3)
    {
      y.O((String)localObject1, (String)localObject4, false);
      Log.i(TAG, "copy thumb" + localObject3 + " to " + (String)localObject4 + "  real:" + y.n((String)localObject4, false) + ",result:" + y.ZC((String)localObject4));
      if (y.ZC((String)localObject4))
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.util.f.Obq;
        com.tencent.mm.plugin.recordvideo.util.f.aTp((String)localObject3);
        ((dji)paramFinderItem.getMediaExtList().get(0)).thumbUrl = ((String)localObject4);
      }
      localObject3 = ((dji)paramFinderItem.getMediaExtList().get(0)).aaPi;
      if ((y.ZC((String)localObject3)) && (localObject3 != null))
      {
        localObject1 = bm.GlZ;
        if (!kotlin.n.n.U((String)localObject3, bm.fiu(), false))
        {
          localObject1 = bm.GlZ;
          localObject4 = bm.aCh(s.X(MD5Util.getMD5String((String)localObject3), Integer.valueOf(((String)localObject3).hashCode())));
          if (Build.VERSION.SDK_INT < 30) {
            break label1089;
          }
        }
      }
      for (localObject1 = String.valueOf(ScopedStorageUtil.MediaStoreOps.imagePathToUri(MMApplicationContext.getContext(), (String)localObject3));; localObject1 = localObject3)
      {
        y.O((String)localObject1, (String)localObject4, false);
        Log.i(TAG, "copy fullThumbPath" + localObject3 + " to " + (String)localObject4 + "  real:" + y.n((String)localObject4, false) + ",result:" + y.ZC((String)localObject4));
        if (y.ZC((String)localObject4)) {
          ((dji)paramFinderItem.getMediaExtList().get(0)).aaPi = ((String)localObject4);
        }
        paramFinderItem = paramFinderItem.getFeedObject().objectDesc;
        if (paramFinderItem == null) {
          paramFinderItem = (FinderItem)localObject2;
        }
        while (paramFinderItem != null)
        {
          paramFinderItem = paramFinderItem.abyV;
          if ((paramFinderItem != null) && (paramFinderItem.size() > 0))
          {
            localObject1 = bm.GlZ;
            localObject1 = bm.fis();
            localObject2 = paramFinderItem.getFirst();
            s.s(localObject2, "it.first");
            localObject2 = kotlin.n.n.b((CharSequence)localObject2, new String[] { "/" });
            if (((List)localObject2).size() > 2)
            {
              localObject1 = s.X((String)localObject1, ((List)localObject2).get(((List)localObject2).size() - 2));
              y.bDX((String)localObject1);
              localObject2 = new LinkedList();
              localObject3 = ((Iterable)paramFinderItem).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (String)((Iterator)localObject3).next();
                s.s(localObject4, "path");
                localObject5 = kotlin.n.n.b((CharSequence)localObject4, new String[] { "/" });
                localObject5 = (String)localObject1 + '/' + (String)p.oM((List)localObject5);
                long l = y.O((String)localObject4, (String)localObject5, false);
                Log.i(TAG, "copy:" + localObject4 + " to:" + (String)localObject5 + " result:" + l);
                ((LinkedList)localObject2).add(localObject5);
              }
              localObject1 = paramFinderItem.video_tmpl_info;
              paramFinderItem = (FinderItem)localObject2;
              if (localObject1 != null) {
                paramFinderItem = ((byy)localObject1).aaia;
              }
            }
            else
            {
              AppMethodBeat.o(342997);
              return;
              paramFinderItem.clear();
              paramFinderItem.addAll((Collection)localObject2);
            }
          }
        }
        AppMethodBeat.o(342997);
        return;
      }
    }
  }
  
  private static void y(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(343014);
    s.u(paramFinderItem, "finderObj");
    Object localObject1;
    int i;
    label39:
    dji localdji;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    boolean bool6;
    boolean bool7;
    boolean bool8;
    if (paramFinderItem.isLongVideo())
    {
      localObject1 = paramFinderItem.getLongVideoMediaList();
      Iterator localIterator = ((Iterable)localObject1).iterator();
      i = 0;
      if (!localIterator.hasNext()) {
        break label965;
      }
      localObject1 = localIterator.next();
      if (i < 0) {
        p.kkW();
      }
      localdji = (dji)localObject1;
      bool1 = y.ZC(localdji.url);
      bool2 = y.ZC(localdji.thumbUrl);
      bool3 = y.ZC(localdji.coverUrl);
      bool4 = y.ZC(localdji.aaPi);
      localObject1 = MD5Util.getMD5String(localdji.url);
      bool5 = aBq(localdji.url);
      bool6 = aBq(localdji.thumbUrl);
      bool7 = aBq(localdji.coverUrl);
      bool8 = aBq(localdji.aaPi);
      Log.i(TAG, "moveFileToPost, mediaId: " + localObject1 + ", fileExist:" + bool1 + ", thumbExist:" + bool2 + ", before url: " + localdji.url + ", " + localdji.thumbUrl + ", " + localdji.coverUrl);
      if ((!bool1) && (!bool2)) {}
    }
    Object localObject2;
    String str;
    long l;
    switch (localdji.mediaType)
    {
    case 3: 
    case 5: 
    case 6: 
    default: 
    case 2: 
    case 7: 
      for (;;)
      {
        Log.i(TAG, "moveFileToPost, after mediaId: " + localdji.mediaId + ", url: " + localdji.url + ", " + localdji.thumbUrl + ", " + localdji.coverUrl);
        i += 1;
        break label39;
        localObject1 = paramFinderItem.getMediaList();
        break;
        if ((bool1) && (bool2) && (!bool6))
        {
          Log.i(TAG, "moveFileToPost Image thumb");
          localObject1 = com.tencent.mm.plugin.finder.upload.f.GbE;
          localObject2 = localdji.url;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          str = localdji.thumbUrl;
          localObject2 = str;
          if (str == null) {
            localObject2 = "";
          }
          localObject1 = com.tencent.mm.plugin.finder.upload.f.im((String)localObject1, (String)localObject2);
          if (y.ZC((String)localObject1)) {
            localdji.thumbUrl = ((String)localObject1);
          }
        }
        if ((bool1) && (!bool5))
        {
          Log.i(TAG, "moveFileToPost Image");
          localObject1 = new com.tencent.mm.plugin.finder.loader.n(localdji, com.tencent.mm.plugin.finder.storage.v.FKY, null, null, 12);
          localObject2 = bm.GlZ;
          localObject1 = bm.a((com.tencent.mm.plugin.finder.loader.n)localObject1, String.valueOf(paramFinderItem.getCreateTime()));
          l = y.O(localdji.url, (String)localObject1, false);
          if (y.ZC((String)localObject1))
          {
            localdji.url = ((String)localObject1);
            localdji.mediaId = MD5Util.getMD5String(localdji.url);
          }
          else
          {
            Log.i(TAG, s.X("copy Image failed, copyRet:", Long.valueOf(l)));
          }
        }
      }
    }
    if ((bool1) && (bool2) && (!bool6))
    {
      Log.i(TAG, "moveFileToPost Video thumb");
      localObject1 = com.tencent.mm.plugin.finder.upload.f.GbE;
      localObject2 = localdji.url;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      str = localdji.thumbUrl;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      localObject1 = com.tencent.mm.plugin.finder.upload.f.il((String)localObject1, (String)localObject2);
      if (y.ZC((String)localObject1)) {
        localdji.thumbUrl = ((String)localObject1);
      }
    }
    if ((bool1) && (!bool5))
    {
      Log.i(TAG, "moveFileToPost Video");
      localObject1 = new com.tencent.mm.plugin.finder.loader.v(localdji, com.tencent.mm.plugin.finder.storage.v.FLB, 0, null, 12);
      localObject2 = bm.GlZ;
      localObject1 = bm.a((com.tencent.mm.plugin.finder.loader.v)localObject1, String.valueOf(paramFinderItem.getCreateTime()));
      l = y.O(localdji.url, (String)localObject1, false);
      if (!y.ZC((String)localObject1)) {
        break label945;
      }
      localdji.url = ((String)localObject1);
      localObject2 = localdji.url;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localdji.mediaId = MD5Util.getMD5String((String)localObject1);
    }
    for (;;)
    {
      if ((bool3) && (!bool7))
      {
        Log.i(TAG, "moveFileToPost Cover");
        localObject1 = new t(localdji, com.tencent.mm.plugin.finder.storage.v.FKY);
        localObject2 = bm.GlZ;
        localObject1 = bm.a((t)localObject1, String.valueOf(paramFinderItem.getCreateTime()));
        y.O(localdji.coverUrl, (String)localObject1, false);
        localdji.coverUrl = ((String)localObject1);
      }
      if ((!bool4) || (bool8)) {
        break;
      }
      Log.i(TAG, "moveFileToPost fullThumb");
      localObject1 = new t(localdji, com.tencent.mm.plugin.finder.storage.v.FKY);
      localObject2 = bm.GlZ;
      localObject1 = bm.a((t)localObject1, String.valueOf(paramFinderItem.getCreateTime()));
      y.O(localdji.aaPi, (String)localObject1, false);
      localdji.aaPi = ((String)localObject1);
      break;
      label945:
      Log.i(TAG, s.X("copy Video failed, copyRet:", Long.valueOf(l)));
    }
    label965:
    AppMethodBeat.o(343014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.b
 * JD-Core Version:    0.7.0.1
 */