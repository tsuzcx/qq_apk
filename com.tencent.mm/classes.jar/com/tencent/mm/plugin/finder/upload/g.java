package com.tencent.mm.plugin.finder.upload;

import android.arch.lifecycle.ViewModelProvider;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.he;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.report.o.c;
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
import com.tencent.mm.protocal.protobuf.amz;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.protocal.protobuf.apv;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.aqx;
import com.tencent.mm.protocal.protobuf.asu;
import com.tencent.mm.protocal.protobuf.bvx;
import com.tencent.mm.protocal.protobuf.bvy;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.bwj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.q;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "", "()V", "TAG", "", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "mediaProcessQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask;", "postCallback", "com/tencent/mm/plugin/finder/upload/FinderPostManager$postCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager$postCallback$1;", "postQueue", "Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "uploadCallback", "com/tencent/mm/plugin/finder/upload/FinderPostManager$uploadCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager$uploadCallback$1;", "uploadImageQueue", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask;", "uploadQueue", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "addPostEndListener", "", "listener", "checkNextPost", "doPost", "", "mediaType", "", "description", "localContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "extendedReading", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "originalFlag", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "isFromCamera", "", "videoPathBeforeCut", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "doProcess", "processTask", "callback", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "doUpload", "uploadTask", "notifyEventPost", "localId", "isOk", "notifyPostError", "notifyPostOk", "svrId", "notifyStartPost", "onStart", "onStop", "rePost", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "removePostEndListener", "uploadCoverImage", "path", "userName", "Companion", "plugin-finder_release"})
public final class g
{
  private static final g sUv;
  private static boolean sUw;
  public static final a sUx;
  private final String TAG;
  public com.tencent.mm.loader.g.d<h> hip;
  private final HashSet<l> listeners;
  public com.tencent.mm.loader.g.d<k> sUq;
  public com.tencent.mm.loader.g.d<j> sUr;
  com.tencent.mm.loader.g.d<c> sUs;
  public final g sUt;
  public final i sUu;
  
  static
  {
    AppMethodBeat.i(167765);
    sUx = new a((byte)0);
    sUv = new g();
    AppMethodBeat.o(167765);
  }
  
  public g()
  {
    AppMethodBeat.i(167764);
    this.hip = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderPost"));
    this.sUq = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderUpload"));
    this.sUr = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderUploadImage"));
    this.sUs = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderMediaProcess"));
    this.TAG = "Finder.LogPost.FinderPostManager";
    this.sUt = new g(this);
    this.sUu = new i();
    this.listeners = new HashSet();
    AppMethodBeat.o(167764);
  }
  
  private void xC(final long paramLong)
  {
    AppMethodBeat.i(167763);
    com.tencent.mm.ac.c.h((d.g.a.a)new f(this, paramLong));
    AppMethodBeat.o(167763);
  }
  
  public final long a(int paramInt1, String paramString1, bvy parambvy, apl paramapl, amz paramamz, int paramInt2, aqq paramaqq, boolean paramBoolean, String paramString2, ArrayList<bvx> paramArrayList)
  {
    AppMethodBeat.i(204954);
    d.g.b.p.h(paramString1, "description");
    d.g.b.p.h(paramString2, "videoPathBeforeCut");
    FinderItem localFinderItem = new FinderItem();
    Object localObject1 = com.tencent.mm.plugin.finder.report.g.syJ;
    localFinderItem.field_reportObject = com.tencent.mm.plugin.finder.report.g.cFq();
    localObject1 = localFinderItem.field_reportObject;
    if (localObject1 != null)
    {
      ((FinderFeedReportObject)localObject1).sendOrExitButtonTime = ch.aDc();
      ((FinderFeedReportObject)localObject1).videoPostType = paramInt1;
      ((FinderFeedReportObject)localObject1).beforeCutMediaPath = paramString2;
      ((FinderFeedReportObject)localObject1).postStage = 1;
      paramString2 = z.Nhr;
    }
    paramString2 = com.tencent.mm.plugin.finder.api.c.rPy;
    localObject1 = c.a.ahT(com.tencent.mm.model.v.aAK());
    FinderObject localFinderObject = new FinderObject();
    FinderObjectDesc localFinderObjectDesc = new FinderObjectDesc();
    long l;
    if (paramaqq != null)
    {
      l = paramaqq.refObjectId;
      localFinderObject.refObjectId = l;
      if (paramaqq == null) {
        break label244;
      }
      l = paramaqq.refObjectFlag;
      label146:
      localFinderObject.refObjectFlag = l;
      if (paramaqq == null) {
        break label250;
      }
    }
    label244:
    label250:
    for (paramString2 = paramaqq.refObjectContact;; paramString2 = null)
    {
      localFinderObject.refObjectContact = paramString2;
      localFinderObject.id = 0L;
      localFinderObject.username = com.tencent.mm.model.v.aAK();
      paramString2 = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(paramString2, "MMKernel.storage()");
      paramString2 = paramString2.ajA().get(am.a.JaX, "");
      if (paramString2 != null) {
        break label256;
      }
      paramString1 = new d.v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(204954);
      throw paramString1;
      l = 0L;
      break;
      l = 0L;
      break label146;
    }
    label256:
    localFinderObject.nickname = ((String)paramString2);
    localFinderObject.objectDesc = localFinderObjectDesc;
    paramString2 = com.tencent.mm.plugin.finder.utils.p.sXz;
    localFinderObject.createtime = com.tencent.mm.plugin.finder.utils.p.xF(ch.aDa());
    Object localObject2 = new FinderContact();
    ((FinderContact)localObject2).username = com.tencent.mm.model.v.aAK();
    paramString2 = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(paramString2, "MMKernel.storage()");
    paramString2 = paramString2.ajA().get(am.a.JaX, "");
    if (paramString2 == null)
    {
      paramString1 = new d.v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(204954);
      throw paramString1;
    }
    ((FinderContact)localObject2).nickname = ((String)paramString2);
    paramString2 = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(paramString2, "MMKernel.storage()");
    paramString2 = paramString2.ajA().get(am.a.JaZ, "");
    if (paramString2 == null)
    {
      paramString1 = new d.v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(204954);
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
    paramString2 = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(paramString2, "MMKernel.storage()");
    paramString2 = paramString2.ajA().get(am.a.Jbc, "");
    if (paramString2 == null)
    {
      paramString1 = new d.v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(204954);
      throw paramString1;
    }
    ((FinderContact)localObject2).coverImgUrl = ((String)paramString2);
    paramString2 = z.Nhr;
    localFinderObject.contact = ((FinderContact)localObject2);
    localFinderObject.mentionedUserContact = new LinkedList();
    paramString2 = com.tencent.mm.plugin.finder.storage.b.sHP;
    Object localObject3;
    if ((com.tencent.mm.plugin.finder.storage.b.cId()) && (paramArrayList != null))
    {
      paramString2 = paramArrayList.iterator();
      while (paramString2.hasNext())
      {
        localObject1 = (bvx)paramString2.next();
        localObject2 = localFinderObject.mentionedUserContact;
        localObject3 = com.tencent.mm.plugin.finder.utils.b.sWa;
        d.g.b.p.g(localObject1, "atContact");
        ((LinkedList)localObject2).add(com.tencent.mm.plugin.finder.utils.b.b((bvx)localObject1));
      }
      paramString2 = z.Nhr;
    }
    paramString2 = com.tencent.mm.plugin.finder.utils.p.sXz;
    if (com.tencent.mm.plugin.finder.utils.p.cOj()) {
      localFinderObject.permissionFlag = 3;
    }
    localObject2 = new aqx();
    int i;
    Object localObject4;
    if (parambvy != null)
    {
      paramString2 = parambvy.mediaList;
      if (paramString2 != null)
      {
        localObject3 = ((Iterable)paramString2).iterator();
        i = 0;
        while (((Iterator)localObject3).hasNext())
        {
          paramString2 = ((Iterator)localObject3).next();
          int j = i + 1;
          if (i < 0) {
            d.a.j.gkd();
          }
          localObject4 = (bvz)paramString2;
          Object localObject5 = new FinderMedia();
          ((FinderMedia)localObject5).url = ((bvz)localObject4).url;
          ((FinderMedia)localObject5).mediaType = ((bvz)localObject4).mediaType;
          ((FinderMedia)localObject5).thumbUrl = ((bvz)localObject4).thumbUrl;
          if ((!((bvz)localObject4).HiV) && (((bvz)localObject4).videoDuration <= 0))
          {
            paramString2 = com.tencent.mm.plugin.sight.base.e.ayN(((bvz)localObject4).url);
            if (paramString2 != null)
            {
              ((bvz)localObject4).videoDuration = paramString2.getVideoDuration();
              paramString2 = z.Nhr;
            }
          }
          ((FinderMedia)localObject5).videoDuration = ((bvz)localObject4).videoDuration;
          ((FinderMedia)localObject5).width = ((bvz)localObject4).width;
          ((FinderMedia)localObject5).height = ((bvz)localObject4).height;
          ((FinderMedia)localObject5).md5sum = ((bvz)localObject4).md5sum;
          ((FinderMedia)localObject5).coverUrl = ((bvz)localObject4).coverUrl;
          localFinderObjectDesc.media.add(localObject5);
          if ((i == 0) && (!bu.isNullOrNil(((bvz)localObject4).url)) && ((((bvz)localObject4).mediaType == 2) || (((bvz)localObject4).mediaType == 4)))
          {
            if (((bvz)localObject4).mediaType != 2) {
              break label1141;
            }
            paramString2 = com.tencent.mm.plugin.finder.utils.p.sXz;
            localObject1 = ((bvz)localObject4).url;
            paramString2 = (String)localObject1;
            if (localObject1 == null) {
              paramString2 = "";
            }
          }
          for (paramString2 = com.tencent.mm.plugin.finder.utils.p.ajW(paramString2);; paramString2 = com.tencent.mm.plugin.finder.utils.p.ajX(((bvz)localObject4).url))
          {
            if (paramString2 != null)
            {
              ((aqx)localObject2).GHI = ((float)((Number)paramString2.first).doubleValue());
              ((aqx)localObject2).GHH = ((float)((Number)paramString2.second).doubleValue());
              paramString2 = z.Nhr;
            }
            if (((FinderMedia)localObject5).mediaType != 2) {
              break label1159;
            }
            paramString2 = this.TAG;
            localObject1 = new StringBuilder("print mediaList ").append(i).append(' ').append(((bvz)localObject4).url).append(" size:").append(bu.sL(com.tencent.mm.vfs.o.aZR(((bvz)localObject4).url))).append(" option ");
            localObject4 = com.tencent.mm.sdk.platformtools.h.aRz(((bvz)localObject4).url);
            ae.i(paramString2, new StringBuilder("w*h:[").append(((BitmapFactory.Options)localObject4).outWidth).append(" * ").append(((BitmapFactory.Options)localObject4).outHeight).append(']').toString() + '}');
            i = j;
            break;
            label1141:
            paramString2 = com.tencent.mm.plugin.finder.utils.p.sXz;
          }
          label1159:
          if (((FinderMedia)localObject5).mediaType == 4)
          {
            paramString2 = this.TAG;
            localObject1 = new StringBuilder("print mediaList ").append(i).append(' ').append(((bvz)localObject4).url).append(" size:").append(bu.sL(com.tencent.mm.vfs.o.aZR(((bvz)localObject4).url))).append(" option ");
            localObject5 = com.tencent.mm.plugin.gallery.a.c.ubl;
            ae.i(paramString2, com.tencent.mm.plugin.gallery.a.c.ajS(((bvz)localObject4).url));
            i = j;
          }
          else
          {
            ae.i(this.TAG, "print mediaList " + i + ' ' + ((bvz)localObject4).url + " size:" + bu.sL(com.tencent.mm.vfs.o.aZR(((bvz)localObject4).url)));
            i = j;
          }
        }
        paramString2 = z.Nhr;
      }
    }
    paramString2 = com.tencent.mm.ui.component.a.KEX;
    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    paramString2 = FinderGlobalLocationVM.cQL();
    ((aqx)localObject2).dBu = ((Number)paramString2.first).floatValue();
    ((aqx)localObject2).dzE = ((Number)paramString2.second).floatValue();
    paramString2 = z.Nhr;
    if (paramBoolean)
    {
      i = 1;
      ((aqx)localObject2).GHJ = i;
      localFinderItem.field_postExtraData = ((aqx)localObject2);
      localFinderObject.displayidDiscarded = "";
      localFinderObject.recommendReason = "";
      localFinderObject.secondaryShowFlag = 1;
      localFinderObject.originalFlag = paramInt2;
      localFinderObjectDesc.description = paramString1;
      localFinderObjectDesc.mediaType = paramInt1;
      paramString2 = paramapl;
      if (paramapl == null) {
        paramString2 = new apl();
      }
      localFinderObjectDesc.location = paramString2;
      if (paramamz != null) {
        break label2127;
      }
    }
    label1813:
    label2097:
    label2102:
    label2107:
    label2113:
    label2119:
    label2127:
    for (paramapl = new amz();; paramapl = paramamz)
    {
      localFinderObjectDesc.extReading = paramapl;
      localObject1 = new HashMap();
      paramapl = com.tencent.mm.plugin.finder.storage.b.sHP;
      if ((com.tencent.mm.plugin.finder.storage.b.cId()) && (paramArrayList != null))
      {
        localObject2 = new LinkedList();
        localObject3 = paramArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (bvx)((Iterator)localObject3).next();
            paramapl = new apv();
            paramapl.username = ((bvx)localObject4).username;
            paramapl.doj = ((bvx)localObject4).type;
            ((LinkedList)localObject2).add(paramapl);
            paramString2 = ((bvx)localObject4).nickname;
            paramapl = paramString2;
            if (paramString2 == null) {
              paramapl = "";
            }
            ((HashMap)localObject1).put(paramapl, localObject4);
            paramapl = z.Nhr;
            continue;
            i = 0;
            break;
          }
        }
        localFinderObjectDesc.mentionedUser = ((LinkedList)localObject2);
        paramapl = z.Nhr;
      }
      paramapl = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (!com.tencent.mm.plugin.finder.storage.b.cIc())
      {
        paramapl = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (!com.tencent.mm.plugin.finder.storage.b.cId()) {}
      }
      else
      {
        paramapl = new asu();
        paramString2 = n.sXn;
        paramapl.GJP = n.c(paramString1, (HashMap)localObject1);
        paramString1 = z.Nhr;
        localFinderObjectDesc.topic = paramapl;
      }
      paramString1 = localFinderItem.field_reportObject;
      label1763:
      float f;
      if (paramString1 != null)
      {
        paramapl = localFinderObjectDesc.description;
        if (paramapl == null) {
          break label2097;
        }
        paramInt1 = paramapl.length();
        paramString1.descCount = paramInt1;
        if (localFinderItem.field_reportObject.descCount <= 0) {
          break label2102;
        }
        paramInt1 = 1;
        paramString1.existDesc = paramInt1;
        paramapl = localFinderObjectDesc.location;
        if (paramapl == null) {
          break label2107;
        }
        f = paramapl.dzE;
        label1787:
        if (f <= 0.0F) {
          break label2119;
        }
        paramapl = localFinderObjectDesc.location;
        if (paramapl == null) {
          break label2113;
        }
        f = paramapl.dBu;
        if (f <= 0.0F) {
          break label2119;
        }
      }
      for (paramString1.existLocation = 1;; paramString1.existLocation = 0)
      {
        if (paramamz != null)
        {
          paramString1.link = paramamz.link;
          paramString1 = z.Nhr;
        }
        paramString1 = z.Nhr;
        ae.i(this.TAG, "finder send post " + com.tencent.mm.ac.f.bF(localFinderObject));
        localFinderItem.updateFinderObject(localFinderObject);
        paramString1 = i.sUG;
        paramString1 = i.cNs();
        paramString1.Hjc = ch.aDa();
        if (paramArrayList != null)
        {
          paramString1.Hjf.clear();
          paramString1.Hjf.addAll((Collection)paramArrayList);
        }
        paramapl = z.Nhr;
        localFinderItem.setPostInfo(paramString1);
        if (parambvy != null)
        {
          parambvy = parambvy.mediaList;
          paramString1 = parambvy;
          if (parambvy != null) {}
        }
        else
        {
          paramString1 = new LinkedList();
        }
        localFinderItem.setMediaExtList(paramString1);
        if (paramaqq != null)
        {
          paramString1 = localFinderItem.getPostInfo();
          paramString1.HiZ = 1;
          parambvy = z.Nhr;
          localFinderItem.setPostInfo(paramString1);
        }
        localFinderItem.setPostWaiting();
        l = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().e(localFinderItem);
        ae.i(this.TAG, "insertNewFeed " + l + " localId:" + l);
        localFinderItem.setLocalId(l);
        paramString1 = com.tencent.mm.plugin.finder.storage.data.k.sLb;
        k.a.h(localFinderItem);
        xC(l);
        cNn();
        paramString1 = o.c.sAI;
        o.c.cFI();
        localFinderItem.trackPost("doPost");
        AppMethodBeat.o(204954);
        return l;
        paramInt1 = 0;
        break;
        paramInt1 = 0;
        break label1763;
        f = 0.0F;
        break label1787;
        f = 0.0F;
        break label1813;
      }
    }
  }
  
  public final void a(final l paraml)
  {
    AppMethodBeat.i(167760);
    com.tencent.mm.ac.c.h((d.g.a.a)new b(this, paraml));
    AppMethodBeat.o(167760);
  }
  
  public final void b(final l paraml)
  {
    AppMethodBeat.i(167761);
    com.tencent.mm.ac.c.h((d.g.a.a)new h(this, paraml));
    AppMethodBeat.o(167761);
  }
  
  public final void cNn()
  {
    AppMethodBeat.i(167759);
    FinderItem localFinderItem = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().cKX();
    if (localFinderItem == null)
    {
      ae.d(this.TAG, "All has post, check posting folder");
      localObject = f.sUp;
      if (f.cNm())
      {
        localObject = new e(System.currentTimeMillis());
        this.hip.b((com.tencent.mm.loader.g.c)localObject);
      }
      AppMethodBeat.o(167759);
      return;
    }
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("checking post-waiting finder feed from db, next will post: ").append(localFinderItem.getLocalId()).append(' ').append(localFinderItem.getCreateTime()).append(' ');
    Object localObject = localFinderItem.getPostInfo();
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((bwa)localObject).hiJ);; localObject = null)
    {
      ae.i(str, ((Integer)localObject).intValue());
      localObject = new h(localFinderItem);
      d.sUk.N(localFinderItem.getLocalId(), localFinderItem.getPostInfo().Hjb);
      this.hip.b((com.tencent.mm.loader.g.c)localObject);
      AppMethodBeat.o(167759);
      return;
    }
  }
  
  public final void k(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167758);
    d.g.b.p.h(paramFinderItem, "feedObject");
    ae.i(this.TAG, "Finder.PostLog repost " + paramFinderItem.getLocalId());
    paramFinderItem.setPostWaiting();
    Object localObject1 = paramFinderItem.getPostInfo();
    if (localObject1 != null)
    {
      ((bwa)localObject1).hiJ = 0;
      ((bwa)localObject1).Hjb = 0;
      if (((bwa)localObject1).HiZ == 2) {
        ((bwa)localObject1).HiZ = 0;
      }
    }
    localObject1 = paramFinderItem.getMediaList();
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((bvz)((Iterator)localObject1).next()).stz;
        if (localObject2 != null) {
          ((bwj)localObject2).retryCount = 0;
        }
      }
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
    b.a.i(paramFinderItem);
    cNn();
    localObject1 = o.c.sAI;
    o.c.cFI();
    localObject1 = o.c.sAI;
    o.c.cFV();
    localObject1 = com.tencent.mm.sdk.b.a.IvT;
    Object localObject2 = new he();
    ((he)localObject2).duD.doE = paramFinderItem.getLocalId();
    ((he)localObject2).duD.progress = paramFinderItem.getPostInfo().Hjb;
    ((com.tencent.mm.sdk.b.a)localObject1).l((com.tencent.mm.sdk.b.b)localObject2);
    AppMethodBeat.o(167758);
  }
  
  public final void xB(final long paramLong)
  {
    AppMethodBeat.i(167762);
    com.tencent.mm.ac.c.h((d.g.a.a)new d(this, paramLong));
    AppMethodBeat.o(167762);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/FinderPostManager$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "shouldScrollToPostingItem", "", "getShouldScrollToPostingItem", "()Z", "setShouldScrollToPostingItem", "(Z)V", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(g paramg, l paraml)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(g paramg, long paramLong)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(g paramg, long paramLong)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(g paramg, long paramLong1, long paramLong2)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(g paramg, long paramLong)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/upload/FinderPostManager$postCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class g
    implements com.tencent.mm.loader.g.f<h>
  {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(g paramg, l paraml)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/upload/FinderPostManager$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class i
    implements com.tencent.mm.loader.g.f<k>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.g
 * JD-Core Version:    0.7.0.1
 */