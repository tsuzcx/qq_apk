package com.tencent.mm.plugin.finder.upload;

import android.arch.lifecycle.ViewModelProvider;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hd;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.report.n.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.api;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.protocal.protobuf.aqi;
import com.tencent.mm.protocal.protobuf.asf;
import com.tencent.mm.protocal.protobuf.bvd;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.q;
import d.o;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "", "()V", "TAG", "", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "mediaProcessQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask;", "postCallback", "com/tencent/mm/plugin/finder/upload/FinderPostManager$postCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager$postCallback$1;", "postQueue", "Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "uploadCallback", "com/tencent/mm/plugin/finder/upload/FinderPostManager$uploadCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager$uploadCallback$1;", "uploadImageQueue", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask;", "uploadQueue", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "addPostEndListener", "", "listener", "checkNextPost", "doPost", "", "mediaType", "", "description", "localContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "extendedReading", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "originalFlag", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "isFromCamera", "", "videoPathBeforeCut", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "doProcess", "processTask", "callback", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "doUpload", "uploadTask", "notifyEventPost", "localId", "isOk", "notifyPostError", "notifyPostOk", "svrId", "notifyStartPost", "onStart", "onStop", "rePost", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "removePostEndListener", "uploadCoverImage", "path", "userName", "Companion", "plugin-finder_release"})
public final class g
{
  private static final g sJi;
  private static boolean sJj;
  public static final a sJk;
  private final String TAG;
  public com.tencent.mm.loader.g.d<h> hfB;
  private final HashSet<l> listeners;
  public com.tencent.mm.loader.g.d<k> sJd;
  public com.tencent.mm.loader.g.d<j> sJe;
  com.tencent.mm.loader.g.d<c> sJf;
  public final g sJg;
  public final i sJh;
  
  static
  {
    AppMethodBeat.i(167765);
    sJk = new a((byte)0);
    sJi = new g();
    AppMethodBeat.o(167765);
  }
  
  public g()
  {
    AppMethodBeat.i(167764);
    this.hfB = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderPost"));
    this.sJd = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderUpload"));
    this.sJe = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderUploadImage"));
    this.sJf = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderMediaProcess"));
    this.TAG = "Finder.LogPost.FinderPostManager";
    this.sJg = new g(this);
    this.sJh = new i();
    this.listeners = new HashSet();
    AppMethodBeat.o(167764);
  }
  
  private void xl(final long paramLong)
  {
    AppMethodBeat.i(167763);
    com.tencent.mm.ad.c.g((d.g.a.a)new f(this, paramLong));
    AppMethodBeat.o(167763);
  }
  
  public final long a(int paramInt1, String paramString1, bve parambve, aoy paramaoy, amn paramamn, int paramInt2, aqb paramaqb, boolean paramBoolean, String paramString2, ArrayList<bvd> paramArrayList)
  {
    AppMethodBeat.i(204336);
    d.g.b.p.h(paramString1, "description");
    d.g.b.p.h(paramString2, "videoPathBeforeCut");
    FinderItem localFinderItem = new FinderItem();
    Object localObject1 = com.tencent.mm.plugin.finder.report.f.soC;
    localFinderItem.field_reportObject = com.tencent.mm.plugin.finder.report.f.cDv();
    localObject1 = localFinderItem.field_reportObject;
    if (localObject1 != null)
    {
      ((FinderFeedReportObject)localObject1).sendOrExitButtonTime = cf.aCM();
      ((FinderFeedReportObject)localObject1).videoPostType = paramInt1;
      ((FinderFeedReportObject)localObject1).beforeCutMediaPath = paramString2;
      ((FinderFeedReportObject)localObject1).postStage = 1;
      paramString2 = z.MKo;
    }
    paramString2 = com.tencent.mm.plugin.finder.api.c.rHn;
    paramString2 = u.aAu();
    d.g.b.p.g(paramString2, "ConfigStorageLogic.getMyFinderUsername()");
    localObject1 = c.a.agW(paramString2);
    FinderObject localFinderObject = new FinderObject();
    FinderObjectDesc localFinderObjectDesc = new FinderObjectDesc();
    long l;
    if (paramaqb != null)
    {
      l = paramaqb.refObjectId;
      localFinderObject.refObjectId = l;
      if (paramaqb == null) {
        break label256;
      }
      l = paramaqb.refObjectFlag;
      label158:
      localFinderObject.refObjectFlag = l;
      if (paramaqb == null) {
        break label262;
      }
    }
    label256:
    label262:
    for (paramString2 = paramaqb.refObjectContact;; paramString2 = null)
    {
      localFinderObject.refObjectContact = paramString2;
      localFinderObject.id = 0L;
      localFinderObject.username = u.aAu();
      paramString2 = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(paramString2, "MMKernel.storage()");
      paramString2 = paramString2.ajl().get(al.a.IGx, "");
      if (paramString2 != null) {
        break label268;
      }
      paramString1 = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(204336);
      throw paramString1;
      l = 0L;
      break;
      l = 0L;
      break label158;
    }
    label268:
    localFinderObject.nickname = ((String)paramString2);
    localFinderObject.objectDesc = localFinderObjectDesc;
    paramString2 = com.tencent.mm.plugin.finder.utils.p.sMo;
    localFinderObject.createtime = com.tencent.mm.plugin.finder.utils.p.xo(cf.aCK());
    Object localObject2 = new FinderContact();
    ((FinderContact)localObject2).username = u.aAu();
    paramString2 = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(paramString2, "MMKernel.storage()");
    paramString2 = paramString2.ajl().get(al.a.IGx, "");
    if (paramString2 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(204336);
      throw paramString1;
    }
    ((FinderContact)localObject2).nickname = ((String)paramString2);
    paramString2 = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(paramString2, "MMKernel.storage()");
    paramString2 = paramString2.ajl().get(al.a.IGz, "");
    if (paramString2 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(204336);
      throw paramString1;
    }
    ((FinderContact)localObject2).headUrl = ((String)paramString2);
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).field_signature;
      paramString2 = (String)localObject1;
      if (localObject1 != null) {}
    }
    else
    {
      paramString2 = "";
    }
    ((FinderContact)localObject2).signature = paramString2;
    paramString2 = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(paramString2, "MMKernel.storage()");
    paramString2 = paramString2.ajl().get(al.a.IGC, "");
    if (paramString2 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(204336);
      throw paramString1;
    }
    ((FinderContact)localObject2).coverImgUrl = ((String)paramString2);
    paramString2 = z.MKo;
    localFinderObject.contact = ((FinderContact)localObject2);
    localFinderObject.mentionedUserContact = new LinkedList();
    paramString2 = com.tencent.mm.plugin.finder.storage.b.sxa;
    Object localObject3;
    if ((com.tencent.mm.plugin.finder.storage.b.cGg()) && (paramArrayList != null))
    {
      paramString2 = paramArrayList.iterator();
      while (paramString2.hasNext())
      {
        localObject1 = (bvd)paramString2.next();
        localObject2 = localFinderObject.mentionedUserContact;
        localObject3 = com.tencent.mm.plugin.finder.utils.b.sKO;
        d.g.b.p.g(localObject1, "atContact");
        ((LinkedList)localObject2).add(com.tencent.mm.plugin.finder.utils.b.b((bvd)localObject1));
      }
      paramString2 = z.MKo;
    }
    paramString2 = com.tencent.mm.plugin.finder.utils.p.sMo;
    if (com.tencent.mm.plugin.finder.utils.p.cLC()) {
      localFinderObject.permissionFlag = 3;
    }
    localObject1 = new aqi();
    int i;
    if (parambve != null)
    {
      paramString2 = parambve.mediaList;
      if (paramString2 != null)
      {
        localObject2 = ((Iterable)paramString2).iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          paramString2 = ((Iterator)localObject2).next();
          int j = i + 1;
          if (i < 0) {
            d.a.j.gfB();
          }
          localObject3 = (bvf)paramString2;
          Object localObject4 = new FinderMedia();
          ((FinderMedia)localObject4).url = ((bvf)localObject3).url;
          ((FinderMedia)localObject4).mediaType = ((bvf)localObject3).mediaType;
          ((FinderMedia)localObject4).thumbUrl = ((bvf)localObject3).thumbUrl;
          if ((!((bvf)localObject3).GPt) && (((bvf)localObject3).videoDuration <= 0))
          {
            paramString2 = com.tencent.mm.plugin.sight.base.e.axx(((bvf)localObject3).url);
            if (paramString2 != null)
            {
              ((bvf)localObject3).videoDuration = paramString2.getVideoDuration();
              paramString2 = z.MKo;
            }
          }
          ((FinderMedia)localObject4).videoDuration = ((bvf)localObject3).videoDuration;
          ((FinderMedia)localObject4).width = ((bvf)localObject3).width;
          ((FinderMedia)localObject4).height = ((bvf)localObject3).height;
          ((FinderMedia)localObject4).md5sum = ((bvf)localObject3).md5sum;
          ((FinderMedia)localObject4).coverUrl = ((bvf)localObject3).coverUrl;
          localFinderObjectDesc.media.add(localObject4);
          if ((i == 0) && (!bt.isNullOrNil(((bvf)localObject3).url)) && ((((bvf)localObject3).mediaType == 2) || (((bvf)localObject3).mediaType == 4)))
          {
            if (((bvf)localObject3).mediaType != 2) {
              break label1147;
            }
            paramString2 = com.tencent.mm.plugin.finder.utils.p.sMo;
            paramString2 = ((bvf)localObject3).url;
            d.g.b.p.g(paramString2, "it.url");
          }
          for (paramString2 = com.tencent.mm.plugin.finder.utils.p.aiZ(paramString2);; paramString2 = com.tencent.mm.plugin.finder.utils.p.aja(((bvf)localObject3).url))
          {
            if (paramString2 != null)
            {
              ((aqi)localObject1).Gor = ((float)((Number)paramString2.first).doubleValue());
              ((aqi)localObject1).Goq = ((float)((Number)paramString2.second).doubleValue());
              paramString2 = z.MKo;
            }
            if (((FinderMedia)localObject4).mediaType != 2) {
              break label1165;
            }
            paramString2 = this.TAG;
            localObject4 = new StringBuilder("print mediaList ").append(i).append(' ').append(((bvf)localObject3).url).append(" size:").append(bt.sy(com.tencent.mm.vfs.i.aYo(((bvf)localObject3).url))).append(" option ");
            localObject3 = com.tencent.mm.sdk.platformtools.g.aQc(((bvf)localObject3).url);
            ad.i(paramString2, new StringBuilder("w*h:[").append(((BitmapFactory.Options)localObject3).outWidth).append(" * ").append(((BitmapFactory.Options)localObject3).outHeight).append(']').toString() + '}');
            i = j;
            break;
            label1147:
            paramString2 = com.tencent.mm.plugin.finder.utils.p.sMo;
          }
          label1165:
          if (((FinderMedia)localObject4).mediaType == 4)
          {
            paramString2 = this.TAG;
            localObject4 = new StringBuilder("print mediaList ").append(i).append(' ').append(((bvf)localObject3).url).append(" size:").append(bt.sy(com.tencent.mm.vfs.i.aYo(((bvf)localObject3).url))).append(" option ");
            com.tencent.mm.plugin.gallery.a.c localc = com.tencent.mm.plugin.gallery.a.c.tQu;
            ad.i(paramString2, com.tencent.mm.plugin.gallery.a.c.aiV(((bvf)localObject3).url));
            i = j;
          }
          else
          {
            ad.i(this.TAG, "print mediaList " + i + ' ' + ((bvf)localObject3).url + " size:" + bt.sy(com.tencent.mm.vfs.i.aYo(((bvf)localObject3).url)));
            i = j;
          }
        }
        paramString2 = z.MKo;
      }
    }
    paramString2 = com.tencent.mm.ui.component.a.KiD;
    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    paramString2 = FinderGlobalLocationVM.cOb();
    ((aqi)localObject1).dAp = ((Number)paramString2.first).floatValue();
    ((aqi)localObject1).dyz = ((Number)paramString2.second).floatValue();
    paramString2 = z.MKo;
    if (paramBoolean)
    {
      i = 1;
      ((aqi)localObject1).Gos = i;
      localFinderItem.field_postExtraData = ((aqi)localObject1);
      localFinderObject.displayidDiscarded = "";
      localFinderObject.recommendReason = "";
      localFinderObject.secondaryShowFlag = 1;
      localFinderObject.originalFlag = paramInt2;
      localFinderObjectDesc.description = paramString1;
      localFinderObjectDesc.mediaType = paramInt1;
      paramString2 = paramaoy;
      if (paramaoy == null) {
        paramString2 = new aoy();
      }
      localFinderObjectDesc.location = paramString2;
      if (paramamn != null) {
        break label2077;
      }
    }
    label2059:
    label2064:
    label2069:
    label2077:
    for (paramaoy = new amn();; paramaoy = paramamn)
    {
      localFinderObjectDesc.extReading = paramaoy;
      paramaoy = new HashMap();
      paramString2 = com.tencent.mm.plugin.finder.storage.b.sxa;
      if ((com.tencent.mm.plugin.finder.storage.b.cGg()) && (paramArrayList != null))
      {
        paramString2 = new LinkedList();
        localObject1 = paramArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (bvd)((Iterator)localObject1).next();
            localObject3 = new api();
            ((api)localObject3).username = ((bvd)localObject2).username;
            ((api)localObject3).dnh = ((bvd)localObject2).type;
            paramString2.add(localObject3);
            paramaoy.put(((bvd)localObject2).nickname, localObject2);
            localObject2 = z.MKo;
            continue;
            i = 0;
            break;
          }
        }
        localFinderObjectDesc.mentionedUser = paramString2;
        paramString2 = z.MKo;
      }
      paramString2 = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (!com.tencent.mm.plugin.finder.storage.b.cGf())
      {
        paramString2 = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (!com.tencent.mm.plugin.finder.storage.b.cGg()) {}
      }
      else
      {
        paramString2 = new asf();
        localObject1 = n.sMc;
        paramString2.Gqu = n.c(paramString1, paramaoy);
        paramString1 = z.MKo;
        localFinderObjectDesc.topic = paramString2;
      }
      paramString1 = localFinderItem.field_reportObject;
      if (paramString1 != null)
      {
        paramaoy = localFinderObjectDesc.description;
        if (paramaoy == null) {
          break label2059;
        }
        paramInt1 = paramaoy.length();
        paramString1.descCount = paramInt1;
        if (localFinderItem.field_reportObject.descCount <= 0) {
          break label2064;
        }
        paramInt1 = 1;
        label1751:
        paramString1.existDesc = paramInt1;
        if ((localFinderObjectDesc.location.dyz <= 0.0F) || (localFinderObjectDesc.location.dAp <= 0.0F)) {
          break label2069;
        }
      }
      for (paramString1.existLocation = 1;; paramString1.existLocation = 0)
      {
        if (paramamn != null)
        {
          paramString1.link = paramamn.link;
          paramString1 = z.MKo;
        }
        paramString1 = z.MKo;
        ad.i(this.TAG, "finder send post " + com.tencent.mm.ad.f.bF(localFinderObject));
        localFinderItem.updateFinderObject(localFinderObject);
        paramString1 = i.sJt;
        paramString1 = i.cKO();
        paramString1.GPA = cf.aCK();
        if (paramArrayList != null)
        {
          paramString1.GPD.clear();
          paramString1.GPD.addAll((Collection)paramArrayList);
        }
        paramaoy = z.MKo;
        localFinderItem.setPostInfo(paramString1);
        if (parambve != null)
        {
          parambve = parambve.mediaList;
          paramString1 = parambve;
          if (parambve != null) {}
        }
        else
        {
          paramString1 = new LinkedList();
        }
        localFinderItem.setMediaExtList(paramString1);
        if (paramaqb != null)
        {
          paramString1 = localFinderItem.getPostInfo();
          paramString1.GPx = 1;
          parambve = z.MKo;
          localFinderItem.setPostInfo(paramString1);
        }
        localFinderItem.setPostWaiting();
        l = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().e(localFinderItem);
        ad.i(this.TAG, "insertNewFeed " + l + " localId:" + l);
        localFinderItem.setLocalId(l);
        paramString1 = com.tencent.mm.plugin.finder.storage.data.k.sAe;
        k.a.h(localFinderItem);
        xl(l);
        cKJ();
        paramString1 = n.c.sqy;
        n.c.cDM();
        localFinderItem.trackPost("doPost");
        AppMethodBeat.o(204336);
        return l;
        paramInt1 = 0;
        break;
        paramInt1 = 0;
        break label1751;
      }
    }
  }
  
  public final void a(final l paraml)
  {
    AppMethodBeat.i(167760);
    com.tencent.mm.ad.c.g((d.g.a.a)new b(this, paraml));
    AppMethodBeat.o(167760);
  }
  
  public final void b(final l paraml)
  {
    AppMethodBeat.i(167761);
    com.tencent.mm.ad.c.g((d.g.a.a)new h(this, paraml));
    AppMethodBeat.o(167761);
  }
  
  public final void cKJ()
  {
    AppMethodBeat.i(167759);
    FinderItem localFinderItem = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().cIs();
    if (localFinderItem == null)
    {
      ad.d(this.TAG, "All has post, check posting folder");
      localObject = f.sJc;
      if (f.cKI())
      {
        localObject = new e(System.currentTimeMillis());
        this.hfB.b((com.tencent.mm.loader.g.c)localObject);
      }
      AppMethodBeat.o(167759);
      return;
    }
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("checking post-waiting finder feed from db, next will post: ").append(localFinderItem.getLocalId()).append(' ').append(localFinderItem.getCreateTime()).append(' ');
    Object localObject = localFinderItem.getPostInfo();
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((bvg)localObject).hfV);; localObject = null)
    {
      ad.i(str, ((Integer)localObject).intValue());
      localObject = new h(localFinderItem);
      d.sIX.N(localFinderItem.getLocalId(), localFinderItem.getPostInfo().GPz);
      this.hfB.b((com.tencent.mm.loader.g.c)localObject);
      AppMethodBeat.o(167759);
      return;
    }
  }
  
  public final void k(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167758);
    d.g.b.p.h(paramFinderItem, "feedObject");
    ad.i(this.TAG, "Finder.PostLog repost " + paramFinderItem.getLocalId());
    paramFinderItem.setPostWaiting();
    Object localObject = paramFinderItem.getPostInfo();
    if (localObject != null)
    {
      ((bvg)localObject).hfV = 0;
      ((bvg)localObject).GPz = 0;
      if (((bvg)localObject).GPx == 2) {
        ((bvg)localObject).GPx = 0;
      }
    }
    localObject = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
    b.a.i(paramFinderItem);
    cKJ();
    localObject = n.c.sqy;
    n.c.cDM();
    localObject = n.c.sqy;
    n.c.cDZ();
    localObject = com.tencent.mm.sdk.b.a.IbL;
    hd localhd = new hd();
    localhd.dty.dnz = paramFinderItem.getLocalId();
    localhd.dty.progress = paramFinderItem.getPostInfo().GPz;
    ((com.tencent.mm.sdk.b.a)localObject).l((com.tencent.mm.sdk.b.b)localhd);
    AppMethodBeat.o(167758);
  }
  
  public final void xk(final long paramLong)
  {
    AppMethodBeat.i(167762);
    com.tencent.mm.ad.c.g((d.g.a.a)new d(this, paramLong));
    AppMethodBeat.o(167762);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/FinderPostManager$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "shouldScrollToPostingItem", "", "getShouldScrollToPostingItem", "()Z", "setShouldScrollToPostingItem", "(Z)V", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(g paramg, l paraml)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(g paramg, long paramLong)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(g paramg, long paramLong)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(g paramg, long paramLong1, long paramLong2)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(g paramg, long paramLong)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/upload/FinderPostManager$postCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class g
    implements com.tencent.mm.loader.g.f<h>
  {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(g paramg, l paraml)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/upload/FinderPostManager$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class i
    implements com.tencent.mm.loader.g.f<k>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.g
 * JD-Core Version:    0.7.0.1
 */