package com.tencent.mm.plugin.finder.upload;

import android.arch.lifecycle.ViewModelProvider;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.e.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akk;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.bmc;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.protocal.protobuf.ebc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.o;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "", "()V", "TAG", "", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "mediaProcessQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask;", "postCallback", "com/tencent/mm/plugin/finder/upload/FinderPostManager$postCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager$postCallback$1;", "postQueue", "Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "uploadCallback", "com/tencent/mm/plugin/finder/upload/FinderPostManager$uploadCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager$uploadCallback$1;", "uploadImageQueue", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask;", "uploadQueue", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "addPostEndListener", "", "listener", "checkNextPost", "doPost", "", "mediaType", "", "description", "localContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "extendedReading", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "originalFlag", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "isFromCamera", "", "videoPathBeforeCut", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "doProcess", "processTask", "callback", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "doUpload", "uploadTask", "notifyEventPost", "localId", "isOk", "notifyPostError", "notifyPostOk", "svrId", "notifyStartPost", "onStart", "onStop", "rePost", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "removePostEndListener", "uploadCoverImage", "path", "userName", "Companion", "plugin-finder_release"})
public final class f
{
  private static final f qRd;
  private static boolean qRe;
  public static final a qRf;
  private final String TAG;
  private final HashSet<k> listeners;
  public com.tencent.mm.loader.g.d<g> qQX;
  public com.tencent.mm.loader.g.d<j> qQY;
  public com.tencent.mm.loader.g.d<i> qQZ;
  com.tencent.mm.loader.g.d<c> qRa;
  public final g qRb;
  public final i qRc;
  
  static
  {
    AppMethodBeat.i(167765);
    qRf = new a((byte)0);
    qRd = new f();
    AppMethodBeat.o(167765);
  }
  
  public f()
  {
    AppMethodBeat.i(167764);
    this.qQX = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderPost"));
    this.qQY = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderUpload"));
    this.qQZ = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderUploadImage"));
    this.qRa = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderMediaProcess"));
    this.TAG = "Finder.FinderPostManager";
    this.qRb = new g(this);
    this.qRc = new i();
    this.listeners = new HashSet();
    AppMethodBeat.o(167764);
  }
  
  private void qM(final long paramLong)
  {
    AppMethodBeat.i(167763);
    com.tencent.mm.ad.c.g((d.g.a.a)new f(this, paramLong));
    AppMethodBeat.o(167763);
  }
  
  public final long a(int paramInt1, String paramString1, bmc parambmc, ajq paramajq, aig paramaig, int paramInt2, akf paramakf, boolean paramBoolean, String paramString2, ArrayList<ebc> paramArrayList)
  {
    AppMethodBeat.i(199527);
    d.g.b.k.h(paramString1, "description");
    d.g.b.k.h(paramString2, "videoPathBeforeCut");
    FinderItem localFinderItem = new FinderItem();
    Object localObject1 = com.tencent.mm.plugin.finder.report.a.qFo;
    localFinderItem.field_reportObject = com.tencent.mm.plugin.finder.report.a.cnz();
    localObject1 = localFinderItem.field_reportObject;
    if (localObject1 != null)
    {
      ((FinderFeedReportObject)localObject1).sendOrExitButtonTime = ce.asS();
      ((FinderFeedReportObject)localObject1).videoPostType = paramInt1;
      ((FinderFeedReportObject)localObject1).beforeCutMediaPath = paramString2;
      paramString2 = y.JfV;
    }
    paramString2 = com.tencent.mm.plugin.finder.api.b.qnX;
    paramString2 = u.aqO();
    d.g.b.k.g(paramString2, "ConfigStorageLogic.getMyFinderUsername()");
    localObject1 = com.tencent.mm.plugin.finder.api.b.a.YL(paramString2);
    FinderObject localFinderObject = new FinderObject();
    FinderObjectDesc localFinderObjectDesc = new FinderObjectDesc();
    long l;
    if (paramakf != null)
    {
      l = paramakf.refObjectId;
      localFinderObject.refObjectId = l;
      if (paramakf == null) {
        break label250;
      }
      l = paramakf.refObjectFlag;
      label152:
      localFinderObject.refObjectFlag = l;
      if (paramakf == null) {
        break label256;
      }
    }
    label256:
    for (paramString2 = paramakf.refObjectContact;; paramString2 = null)
    {
      localFinderObject.refObjectContact = paramString2;
      localFinderObject.id = 0L;
      localFinderObject.username = u.aqO();
      paramString2 = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramString2, "MMKernel.storage()");
      paramString2 = paramString2.afk().get(ae.a.FvX, "");
      if (paramString2 != null) {
        break label262;
      }
      paramString1 = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(199527);
      throw paramString1;
      l = 0L;
      break;
      label250:
      l = 0L;
      break label152;
    }
    label262:
    localFinderObject.nickname = ((String)paramString2);
    localFinderObject.objectDesc = localFinderObjectDesc;
    paramString2 = com.tencent.mm.plugin.finder.utils.i.qTa;
    localFinderObject.createtime = com.tencent.mm.plugin.finder.utils.i.qO(ce.asQ());
    Object localObject2 = new FinderContact();
    ((FinderContact)localObject2).username = u.aqO();
    paramString2 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(paramString2, "MMKernel.storage()");
    paramString2 = paramString2.afk().get(ae.a.FvX, "");
    if (paramString2 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(199527);
      throw paramString1;
    }
    ((FinderContact)localObject2).nickname = ((String)paramString2);
    paramString2 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(paramString2, "MMKernel.storage()");
    paramString2 = paramString2.afk().get(ae.a.FvZ, "");
    if (paramString2 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(199527);
      throw paramString1;
    }
    ((FinderContact)localObject2).headUrl = ((String)paramString2);
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.api.f)localObject1).field_signature;
      paramString2 = (String)localObject1;
      if (localObject1 != null) {}
    }
    else
    {
      paramString2 = "";
    }
    ((FinderContact)localObject2).signature = paramString2;
    paramString2 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(paramString2, "MMKernel.storage()");
    paramString2 = paramString2.afk().get(ae.a.Fwc, "");
    if (paramString2 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(199527);
      throw paramString1;
    }
    ((FinderContact)localObject2).coverImgUrl = ((String)paramString2);
    paramString2 = y.JfV;
    localFinderObject.contact = ((FinderContact)localObject2);
    localFinderObject.mentionedUserContact = new LinkedList();
    paramString2 = com.tencent.mm.plugin.finder.storage.b.qJA;
    Object localObject3;
    if ((com.tencent.mm.plugin.finder.storage.b.fUh()) && (paramArrayList != null))
    {
      paramString2 = paramArrayList.iterator();
      while (paramString2.hasNext())
      {
        localObject1 = (ebc)paramString2.next();
        localObject2 = localFinderObject.mentionedUserContact;
        localObject3 = n.LaC;
        d.g.b.k.g(localObject1, "atContact");
        ((LinkedList)localObject2).add(n.b((ebc)localObject1));
      }
      paramString2 = y.JfV;
    }
    localObject1 = new akk();
    int i;
    if (parambmc != null)
    {
      paramString2 = parambmc.mediaList;
      if (paramString2 != null)
      {
        localObject2 = ((Iterable)paramString2).iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          paramString2 = ((Iterator)localObject2).next();
          int j = i + 1;
          if (i < 0) {
            d.a.j.fvx();
          }
          localObject3 = (bmd)paramString2;
          Object localObject4 = new FinderMedia();
          ((FinderMedia)localObject4).url = ((bmd)localObject3).url;
          ((FinderMedia)localObject4).mediaType = ((bmd)localObject3).mediaType;
          ((FinderMedia)localObject4).thumbUrl = ((bmd)localObject3).thumbUrl;
          if ((!((bmd)localObject3).DJD) && (((bmd)localObject3).videoDuration <= 0))
          {
            paramString2 = com.tencent.mm.plugin.sight.base.e.ano(((bmd)localObject3).url);
            if (paramString2 != null)
            {
              ((bmd)localObject3).videoDuration = paramString2.getVideoDuration();
              paramString2 = y.JfV;
            }
          }
          ((FinderMedia)localObject4).videoDuration = ((bmd)localObject3).videoDuration;
          ((FinderMedia)localObject4).width = ((bmd)localObject3).width;
          ((FinderMedia)localObject4).height = ((bmd)localObject3).height;
          ((FinderMedia)localObject4).md5sum = ((bmd)localObject3).md5sum;
          ((FinderMedia)localObject4).coverUrl = ((bmd)localObject3).coverUrl;
          localFinderObjectDesc.media.add(localObject4);
          if ((i == 0) && (!bt.isNullOrNil(((bmd)localObject3).url)) && ((((bmd)localObject3).mediaType == 2) || (((bmd)localObject3).mediaType == 4)))
          {
            if (((bmd)localObject3).mediaType != 2) {
              break label1124;
            }
            paramString2 = com.tencent.mm.plugin.finder.utils.i.qTa;
            paramString2 = ((bmd)localObject3).url;
            d.g.b.k.g(paramString2, "it.url");
          }
          for (paramString2 = com.tencent.mm.plugin.finder.utils.i.ZT(paramString2);; paramString2 = com.tencent.mm.plugin.finder.utils.i.ZU(((bmd)localObject3).url))
          {
            if (paramString2 != null)
            {
              ((akk)localObject1).DlW = ((float)((Number)paramString2.first).doubleValue());
              ((akk)localObject1).DlV = ((float)((Number)paramString2.second).doubleValue());
              paramString2 = y.JfV;
            }
            if (((FinderMedia)localObject4).mediaType != 2) {
              break label1142;
            }
            paramString2 = this.TAG;
            localObject4 = new StringBuilder("print mediaList ").append(i).append(' ').append(((bmd)localObject3).url).append(" size:").append(bt.mK(com.tencent.mm.vfs.i.aMN(((bmd)localObject3).url))).append(" option ");
            localObject3 = com.tencent.mm.sdk.platformtools.f.aFf(((bmd)localObject3).url);
            ad.i(paramString2, new StringBuilder("w*h:[").append(((BitmapFactory.Options)localObject3).outWidth).append(" * ").append(((BitmapFactory.Options)localObject3).outHeight).append(']').toString() + '}');
            i = j;
            break;
            label1124:
            paramString2 = com.tencent.mm.plugin.finder.utils.i.qTa;
          }
          label1142:
          if (((FinderMedia)localObject4).mediaType == 4)
          {
            paramString2 = this.TAG;
            localObject4 = new StringBuilder("print mediaList ").append(i).append(' ').append(((bmd)localObject3).url).append(" size:").append(bt.mK(com.tencent.mm.vfs.i.aMN(((bmd)localObject3).url))).append(" option ");
            com.tencent.mm.plugin.gallery.a.c localc = com.tencent.mm.plugin.gallery.a.c.rMg;
            ad.i(paramString2, com.tencent.mm.plugin.gallery.a.c.ZP(((bmd)localObject3).url));
            i = j;
          }
          else
          {
            ad.i(this.TAG, "print mediaList " + i + ' ' + ((bmd)localObject3).url + " size:" + bt.mK(com.tencent.mm.vfs.i.aMN(((bmd)localObject3).url)));
            i = j;
          }
        }
        paramString2 = y.JfV;
      }
    }
    paramString2 = com.tencent.mm.ui.component.a.LCX;
    com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderGlobalLocationVM.class);
    paramString2 = FinderGlobalLocationVM.fXf();
    ((akk)localObject1).dqQ = ((Number)paramString2.first).floatValue();
    ((akk)localObject1).dpb = ((Number)paramString2.second).floatValue();
    paramString2 = y.JfV;
    if (paramBoolean)
    {
      i = 1;
      ((akk)localObject1).DlX = i;
      localFinderItem.field_postExtraData = ((akk)localObject1);
      localFinderObject.displayidDiscarded = "";
      localFinderObject.recommendReason = "";
      localFinderObject.secondaryShowFlag = 1;
      localFinderObject.originalFlag = paramInt2;
      localFinderObjectDesc.description = paramString1;
      localFinderObjectDesc.mediaType = paramInt1;
      paramString2 = paramajq;
      if (paramajq == null) {
        paramString2 = new ajq();
      }
      localFinderObjectDesc.location = paramString2;
      if (paramaig != null) {
        break label2054;
      }
    }
    label2054:
    for (paramajq = new aig();; paramajq = paramaig)
    {
      localFinderObjectDesc.extReading = paramajq;
      paramajq = new HashMap();
      paramString2 = com.tencent.mm.plugin.finder.storage.b.qJA;
      if ((com.tencent.mm.plugin.finder.storage.b.fUh()) && (paramArrayList != null))
      {
        paramString2 = new LinkedList();
        localObject1 = paramArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ebc)((Iterator)localObject1).next();
            localObject3 = new dzi();
            ((dzi)localObject3).username = ((ebc)localObject2).username;
            ((dzi)localObject3).dep = ((ebc)localObject2).type;
            paramString2.add(localObject3);
            paramajq.put(((ebc)localObject2).nickname, localObject2);
            localObject2 = y.JfV;
            continue;
            i = 0;
            break;
          }
        }
        localFinderObjectDesc.mentionedUser = paramString2;
        paramString2 = y.JfV;
      }
      paramString2 = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (!com.tencent.mm.plugin.finder.storage.b.cpO())
      {
        paramString2 = com.tencent.mm.plugin.finder.storage.b.qJA;
        if (!com.tencent.mm.plugin.finder.storage.b.fUh()) {}
      }
      else
      {
        paramString2 = new alo();
        localObject1 = r.Lbe;
        paramString2.DmM = r.f(paramString1, paramajq);
        paramString1 = y.JfV;
        localFinderObjectDesc.topic = paramString2;
      }
      paramString1 = localFinderItem.field_reportObject;
      if (paramString1 != null)
      {
        paramajq = localFinderObjectDesc.description;
        if (paramajq == null) {
          break label2036;
        }
        paramInt1 = paramajq.length();
        paramString1.descCount = paramInt1;
        if (localFinderItem.field_reportObject.descCount <= 0) {
          break label2041;
        }
        paramInt1 = 1;
        label1728:
        paramString1.existDesc = paramInt1;
        if ((localFinderObjectDesc.location.dpb <= 0.0F) || (localFinderObjectDesc.location.dqQ <= 0.0F)) {
          break label2046;
        }
      }
      label2036:
      label2041:
      label2046:
      for (paramString1.existLocation = 1;; paramString1.existLocation = 0)
      {
        if (paramaig != null)
        {
          paramString1.link = paramaig.link;
          paramString1 = y.JfV;
        }
        paramString1 = y.JfV;
        ad.i(this.TAG, "finder send post " + com.tencent.mm.ad.f.bG(localFinderObject));
        localFinderItem.updateFinderObject(localFinderObject);
        paramString1 = h.qRq;
        paramString1 = h.crF();
        paramString1.DJJ = ce.asQ();
        if (paramArrayList != null)
        {
          paramString1.LzN.clear();
          paramString1.LzN.addAll((Collection)paramArrayList);
        }
        paramajq = y.JfV;
        localFinderItem.setPostInfo(paramString1);
        if (parambmc != null)
        {
          parambmc = parambmc.mediaList;
          paramString1 = parambmc;
          if (parambmc != null) {}
        }
        else
        {
          paramString1 = new LinkedList();
        }
        localFinderItem.setMediaExtList(paramString1);
        if (paramakf != null)
        {
          paramString1 = localFinderItem.getPostInfo();
          paramString1.DJF = 1;
          parambmc = y.JfV;
          localFinderItem.setPostInfo(paramString1);
        }
        localFinderItem.setPostWaiting();
        l = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().d(localFinderItem);
        ad.i(this.TAG, "insertNewFeed " + l + " localId:" + l);
        localFinderItem.setLocalId(l);
        paramString1 = com.tencent.mm.plugin.finder.storage.data.f.qKv;
        com.tencent.mm.plugin.finder.storage.data.f.a.f(localFinderItem);
        qM(l);
        crA();
        paramString1 = e.c.qFV;
        e.c.cnH();
        localFinderItem.trackPost("doPost");
        AppMethodBeat.o(199527);
        return l;
        paramInt1 = 0;
        break;
        paramInt1 = 0;
        break label1728;
      }
    }
  }
  
  public final void a(final k paramk)
  {
    AppMethodBeat.i(167760);
    com.tencent.mm.ad.c.g((d.g.a.a)new b(this, paramk));
    AppMethodBeat.o(167760);
  }
  
  public final void b(final k paramk)
  {
    AppMethodBeat.i(167761);
    com.tencent.mm.ad.c.g((d.g.a.a)new h(this, paramk));
    AppMethodBeat.o(167761);
  }
  
  public final void crA()
  {
    AppMethodBeat.i(167759);
    FinderItem localFinderItem = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().cqn();
    if (localFinderItem == null)
    {
      ad.d(this.TAG, "All has post, check posting folder");
      localObject = e.qQW;
      if (e.crz())
      {
        localObject = new d(System.currentTimeMillis());
        this.qQX.b((com.tencent.mm.loader.g.c)localObject);
      }
      AppMethodBeat.o(167759);
      return;
    }
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("checking post-waiting finder feed from db, next will post: ").append(localFinderItem.getLocalId()).append(' ').append(localFinderItem.getCreateTime()).append(' ');
    Object localObject = localFinderItem.getPostInfo();
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((bme)localObject).gll);; localObject = null)
    {
      ad.i(str, ((Integer)localObject).intValue());
      localObject = new g(localFinderItem);
      this.qQX.b((com.tencent.mm.loader.g.c)localObject);
      AppMethodBeat.o(167759);
      return;
    }
  }
  
  public final void i(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167758);
    d.g.b.k.h(paramFinderItem, "feedObject");
    paramFinderItem.setPostWaiting();
    Object localObject = paramFinderItem.getPostInfo();
    if (localObject != null)
    {
      ((bme)localObject).gll = 0;
      ((bme)localObject).DJH = 0;
      if (((bme)localObject).DJF == 2) {
        ((bme)localObject).DJF = 0;
      }
    }
    localObject = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
    com.tencent.mm.plugin.finder.storage.logic.b.a.g(paramFinderItem);
    crA();
    localObject = e.c.qFV;
    e.c.cnH();
    localObject = com.tencent.mm.sdk.b.a.ESL;
    gx localgx = new gx();
    localgx.dky.deI = paramFinderItem.getLocalId();
    localgx.dky.progress = paramFinderItem.getPostInfo().DJH;
    ((com.tencent.mm.sdk.b.a)localObject).l((com.tencent.mm.sdk.b.b)localgx);
    AppMethodBeat.o(167758);
  }
  
  public final void qL(final long paramLong)
  {
    AppMethodBeat.i(167762);
    com.tencent.mm.ad.c.g((d.g.a.a)new d(this, paramLong));
    AppMethodBeat.o(167762);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/FinderPostManager$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "shouldScrollToPostingItem", "", "getShouldScrollToPostingItem", "()Z", "setShouldScrollToPostingItem", "(Z)V", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(f paramf, k paramk)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(f paramf, long paramLong)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(f paramf, long paramLong)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(f paramf, long paramLong1, long paramLong2)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(f paramf, long paramLong)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/upload/FinderPostManager$postCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class g
    implements com.tencent.mm.loader.g.f<g>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(f paramf, k paramk)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/upload/FinderPostManager$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class i
    implements com.tencent.mm.loader.g.f<j>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.f
 * JD-Core Version:    0.7.0.1
 */