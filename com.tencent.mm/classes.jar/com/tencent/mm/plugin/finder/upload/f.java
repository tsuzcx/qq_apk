package com.tencent.mm.plugin.finder.upload;

import android.arch.lifecycle.ViewModelProvider;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gz;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.i.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.i.a;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.amc;
import com.tencent.mm.protocal.protobuf.amq;
import com.tencent.mm.protocal.protobuf.amw;
import com.tencent.mm.protocal.protobuf.aoo;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.o;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "", "()V", "TAG", "", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "mediaProcessQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask;", "postCallback", "com/tencent/mm/plugin/finder/upload/FinderPostManager$postCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager$postCallback$1;", "postQueue", "Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "uploadCallback", "com/tencent/mm/plugin/finder/upload/FinderPostManager$uploadCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager$uploadCallback$1;", "uploadImageQueue", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask;", "uploadQueue", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "addPostEndListener", "", "listener", "checkNextPost", "doPost", "", "mediaType", "", "description", "localContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "extendedReading", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "originalFlag", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "isFromCamera", "", "videoPathBeforeCut", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "doProcess", "processTask", "callback", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "doUpload", "uploadTask", "notifyEventPost", "localId", "isOk", "notifyPostError", "notifyPostOk", "svrId", "notifyStartPost", "onStart", "onStop", "rePost", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "removePostEndListener", "uploadCoverImage", "path", "userName", "Companion", "plugin-finder_release"})
public final class f
{
  private static final f rNe;
  private static boolean rNf;
  public static final a rNg;
  private final String TAG;
  private final HashSet<k> listeners;
  public com.tencent.mm.loader.g.d<g> rMY;
  public com.tencent.mm.loader.g.d<j> rMZ;
  public com.tencent.mm.loader.g.d<i> rNa;
  com.tencent.mm.loader.g.d<c> rNb;
  public final f.g rNc;
  public final i rNd;
  
  static
  {
    AppMethodBeat.i(167765);
    rNg = new a((byte)0);
    rNe = new f();
    AppMethodBeat.o(167765);
  }
  
  public f()
  {
    AppMethodBeat.i(167764);
    this.rMY = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderPost"));
    this.rMZ = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderUpload"));
    this.rNa = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderUploadImage"));
    this.rNb = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finderMediaProcess"));
    this.TAG = "Finder.FinderPostManager";
    this.rNc = new f.g(this);
    this.rNd = new i();
    this.listeners = new HashSet();
    AppMethodBeat.o(167764);
  }
  
  private void vj(long paramLong)
  {
    AppMethodBeat.i(167763);
    com.tencent.mm.ac.c.g((d.g.a.a)new f.f(this, paramLong));
    AppMethodBeat.o(167763);
  }
  
  public final long a(int paramInt1, String paramString1, bqr parambqr, alt paramalt, ajq paramajq, int paramInt2, amq paramamq, boolean paramBoolean, String paramString2, ArrayList<bqq> paramArrayList)
  {
    AppMethodBeat.i(203503);
    d.g.b.k.h(paramString1, "description");
    d.g.b.k.h(paramString2, "videoPathBeforeCut");
    FinderItem localFinderItem = new FinderItem();
    Object localObject1 = com.tencent.mm.plugin.finder.report.c.rxi;
    localFinderItem.field_reportObject = com.tencent.mm.plugin.finder.report.c.cwQ();
    localObject1 = localFinderItem.field_reportObject;
    if (localObject1 != null)
    {
      ((FinderFeedReportObject)localObject1).sendOrExitButtonTime = ce.azJ();
      ((FinderFeedReportObject)localObject1).videoPostType = paramInt1;
      ((FinderFeedReportObject)localObject1).beforeCutMediaPath = paramString2;
      paramString2 = y.KTp;
    }
    paramString2 = com.tencent.mm.plugin.finder.api.b.qWt;
    paramString2 = u.axE();
    d.g.b.k.g(paramString2, "ConfigStorageLogic.getMyFinderUsername()");
    localObject1 = com.tencent.mm.plugin.finder.api.b.a.adh(paramString2);
    FinderObject localFinderObject = new FinderObject();
    FinderObjectDesc localFinderObjectDesc = new FinderObjectDesc();
    long l;
    if (paramamq != null)
    {
      l = paramamq.refObjectId;
      localFinderObject.refObjectId = l;
      if (paramamq == null) {
        break label250;
      }
      l = paramamq.refObjectFlag;
      label152:
      localFinderObject.refObjectFlag = l;
      if (paramamq == null) {
        break label256;
      }
    }
    label256:
    for (paramString2 = paramamq.refObjectContact;; paramString2 = null)
    {
      localFinderObject.refObjectContact = paramString2;
      localFinderObject.id = 0L;
      localFinderObject.username = u.axE();
      paramString2 = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(paramString2, "MMKernel.storage()");
      paramString2 = paramString2.agA().get(ah.a.GTR, "");
      if (paramString2 != null) {
        break label262;
      }
      paramString1 = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(203503);
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
    paramString2 = n.rPN;
    localFinderObject.createtime = n.vl(ce.azH());
    Object localObject2 = new FinderContact();
    ((FinderContact)localObject2).username = u.axE();
    paramString2 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(paramString2, "MMKernel.storage()");
    paramString2 = paramString2.agA().get(ah.a.GTR, "");
    if (paramString2 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(203503);
      throw paramString1;
    }
    ((FinderContact)localObject2).nickname = ((String)paramString2);
    paramString2 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(paramString2, "MMKernel.storage()");
    paramString2 = paramString2.agA().get(ah.a.GTT, "");
    if (paramString2 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(203503);
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
    paramString2 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(paramString2, "MMKernel.storage()");
    paramString2 = paramString2.agA().get(ah.a.GTW, "");
    if (paramString2 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(203503);
      throw paramString1;
    }
    ((FinderContact)localObject2).coverImgUrl = ((String)paramString2);
    paramString2 = y.KTp;
    localFinderObject.contact = ((FinderContact)localObject2);
    localFinderObject.mentionedUserContact = new LinkedList();
    paramString2 = com.tencent.mm.plugin.finder.storage.b.rCU;
    Object localObject3;
    if ((com.tencent.mm.plugin.finder.storage.b.czp()) && (paramArrayList != null))
    {
      paramString2 = paramArrayList.iterator();
      while (paramString2.hasNext())
      {
        localObject1 = (bqq)paramString2.next();
        localObject2 = localFinderObject.mentionedUserContact;
        localObject3 = com.tencent.mm.plugin.finder.utils.b.rOw;
        d.g.b.k.g(localObject1, "atContact");
        ((LinkedList)localObject2).add(com.tencent.mm.plugin.finder.utils.b.b((bqq)localObject1));
      }
      paramString2 = y.KTp;
    }
    localObject1 = new amw();
    int i;
    if (parambqr != null)
    {
      paramString2 = parambqr.mediaList;
      if (paramString2 != null)
      {
        localObject2 = ((Iterable)paramString2).iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          paramString2 = ((Iterator)localObject2).next();
          int j = i + 1;
          if (i < 0) {
            d.a.j.fOc();
          }
          localObject3 = (bqs)paramString2;
          Object localObject4 = new FinderMedia();
          ((FinderMedia)localObject4).url = ((bqs)localObject3).url;
          ((FinderMedia)localObject4).mediaType = ((bqs)localObject3).mediaType;
          ((FinderMedia)localObject4).thumbUrl = ((bqs)localObject3).thumbUrl;
          if ((!((bqs)localObject3).FfP) && (((bqs)localObject3).videoDuration <= 0))
          {
            paramString2 = com.tencent.mm.plugin.sight.base.e.asx(((bqs)localObject3).url);
            if (paramString2 != null)
            {
              ((bqs)localObject3).videoDuration = paramString2.getVideoDuration();
              paramString2 = y.KTp;
            }
          }
          ((FinderMedia)localObject4).videoDuration = ((bqs)localObject3).videoDuration;
          ((FinderMedia)localObject4).width = ((bqs)localObject3).width;
          ((FinderMedia)localObject4).height = ((bqs)localObject3).height;
          ((FinderMedia)localObject4).md5sum = ((bqs)localObject3).md5sum;
          ((FinderMedia)localObject4).coverUrl = ((bqs)localObject3).coverUrl;
          localFinderObjectDesc.media.add(localObject4);
          if ((i == 0) && (!bs.isNullOrNil(((bqs)localObject3).url)) && ((((bqs)localObject3).mediaType == 2) || (((bqs)localObject3).mediaType == 4)))
          {
            if (((bqs)localObject3).mediaType != 2) {
              break label1124;
            }
            paramString2 = n.rPN;
            paramString2 = ((bqs)localObject3).url;
            d.g.b.k.g(paramString2, "it.url");
          }
          for (paramString2 = n.aeF(paramString2);; paramString2 = n.aeG(((bqs)localObject3).url))
          {
            if (paramString2 != null)
            {
              ((amw)localObject1).EFV = ((float)((Number)paramString2.first).doubleValue());
              ((amw)localObject1).EFU = ((float)((Number)paramString2.second).doubleValue());
              paramString2 = y.KTp;
            }
            if (((FinderMedia)localObject4).mediaType != 2) {
              break label1142;
            }
            paramString2 = this.TAG;
            localObject4 = new StringBuilder("print mediaList ").append(i).append(' ').append(((bqs)localObject3).url).append(" size:").append(bs.qz(com.tencent.mm.vfs.i.aSp(((bqs)localObject3).url))).append(" option ");
            localObject3 = com.tencent.mm.sdk.platformtools.f.aKw(((bqs)localObject3).url);
            ac.i(paramString2, new StringBuilder("w*h:[").append(((BitmapFactory.Options)localObject3).outWidth).append(" * ").append(((BitmapFactory.Options)localObject3).outHeight).append(']').toString() + '}');
            i = j;
            break;
            label1124:
            paramString2 = n.rPN;
          }
          label1142:
          if (((FinderMedia)localObject4).mediaType == 4)
          {
            paramString2 = this.TAG;
            localObject4 = new StringBuilder("print mediaList ").append(i).append(' ').append(((bqs)localObject3).url).append(" size:").append(bs.qz(com.tencent.mm.vfs.i.aSp(((bqs)localObject3).url))).append(" option ");
            com.tencent.mm.plugin.gallery.a.c localc = com.tencent.mm.plugin.gallery.a.c.sTV;
            ac.i(paramString2, com.tencent.mm.plugin.gallery.a.c.aeB(((bqs)localObject3).url));
            i = j;
          }
          else
          {
            ac.i(this.TAG, "print mediaList " + i + ' ' + ((bqs)localObject3).url + " size:" + bs.qz(com.tencent.mm.vfs.i.aSp(((bqs)localObject3).url)));
            i = j;
          }
        }
        paramString2 = y.KTp;
      }
    }
    paramString2 = com.tencent.mm.ui.component.a.IrY;
    com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderGlobalLocationVM.class);
    paramString2 = FinderGlobalLocationVM.cFH();
    ((amw)localObject1).doB = ((Number)paramString2.first).floatValue();
    ((amw)localObject1).dmL = ((Number)paramString2.second).floatValue();
    paramString2 = y.KTp;
    if (paramBoolean)
    {
      i = 1;
      ((amw)localObject1).EFW = i;
      localFinderItem.field_postExtraData = ((amw)localObject1);
      localFinderObject.displayidDiscarded = "";
      localFinderObject.recommendReason = "";
      localFinderObject.secondaryShowFlag = 1;
      localFinderObject.originalFlag = paramInt2;
      localFinderObjectDesc.description = paramString1;
      localFinderObjectDesc.mediaType = paramInt1;
      paramString2 = paramalt;
      if (paramalt == null) {
        paramString2 = new alt();
      }
      localFinderObjectDesc.location = paramString2;
      if (paramajq != null) {
        break label2054;
      }
    }
    label2054:
    for (paramalt = new ajq();; paramalt = paramajq)
    {
      localFinderObjectDesc.extReading = paramalt;
      paramalt = new HashMap();
      paramString2 = com.tencent.mm.plugin.finder.storage.b.rCU;
      if ((com.tencent.mm.plugin.finder.storage.b.czp()) && (paramArrayList != null))
      {
        paramString2 = new LinkedList();
        localObject1 = paramArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (bqq)((Iterator)localObject1).next();
            localObject3 = new amc();
            ((amc)localObject3).username = ((bqq)localObject2).username;
            ((amc)localObject3).dbL = ((bqq)localObject2).type;
            paramString2.add(localObject3);
            paramalt.put(((bqq)localObject2).nickname, localObject2);
            localObject2 = y.KTp;
            continue;
            i = 0;
            break;
          }
        }
        localFinderObjectDesc.mentionedUser = paramString2;
        paramString2 = y.KTp;
      }
      paramString2 = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (!com.tencent.mm.plugin.finder.storage.b.czo())
      {
        paramString2 = com.tencent.mm.plugin.finder.storage.b.rCU;
        if (!com.tencent.mm.plugin.finder.storage.b.czp()) {}
      }
      else
      {
        paramString2 = new aoo();
        localObject1 = com.tencent.mm.plugin.finder.utils.l.rPB;
        paramString2.EHF = com.tencent.mm.plugin.finder.utils.l.c(paramString1, paramalt);
        paramString1 = y.KTp;
        localFinderObjectDesc.topic = paramString2;
      }
      paramString1 = localFinderItem.field_reportObject;
      if (paramString1 != null)
      {
        paramalt = localFinderObjectDesc.description;
        if (paramalt == null) {
          break label2036;
        }
        paramInt1 = paramalt.length();
        paramString1.descCount = paramInt1;
        if (localFinderItem.field_reportObject.descCount <= 0) {
          break label2041;
        }
        paramInt1 = 1;
        label1728:
        paramString1.existDesc = paramInt1;
        if ((localFinderObjectDesc.location.dmL <= 0.0F) || (localFinderObjectDesc.location.doB <= 0.0F)) {
          break label2046;
        }
      }
      label2036:
      label2041:
      label2046:
      for (paramString1.existLocation = 1;; paramString1.existLocation = 0)
      {
        if (paramajq != null)
        {
          paramString1.link = paramajq.link;
          paramString1 = y.KTp;
        }
        paramString1 = y.KTp;
        ac.i(this.TAG, "finder send post " + com.tencent.mm.ac.f.bD(localFinderObject));
        localFinderItem.updateFinderObject(localFinderObject);
        paramString1 = h.rNr;
        paramString1 = h.cCA();
        paramString1.FfX = ce.azH();
        if (paramArrayList != null)
        {
          paramString1.Fgb.clear();
          paramString1.Fgb.addAll((Collection)paramArrayList);
        }
        paramalt = y.KTp;
        localFinderItem.setPostInfo(paramString1);
        if (parambqr != null)
        {
          parambqr = parambqr.mediaList;
          paramString1 = parambqr;
          if (parambqr != null) {}
        }
        else
        {
          paramString1 = new LinkedList();
        }
        localFinderItem.setMediaExtList(paramString1);
        if (paramamq != null)
        {
          paramString1 = localFinderItem.getPostInfo();
          paramString1.FfT = 1;
          parambqr = y.KTp;
          localFinderItem.setPostInfo(paramString1);
        }
        localFinderItem.setPostWaiting();
        l = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().e(localFinderItem);
        ac.i(this.TAG, "insertNewFeed " + l + " localId:" + l);
        localFinderItem.setLocalId(l);
        paramString1 = com.tencent.mm.plugin.finder.storage.data.i.rEV;
        i.a.g(localFinderItem);
        vj(l);
        cCu();
        paramString1 = i.c.ryP;
        i.c.cxd();
        localFinderItem.trackPost("doPost");
        AppMethodBeat.o(203503);
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
    com.tencent.mm.ac.c.g((d.g.a.a)new b(this, paramk));
    AppMethodBeat.o(167760);
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(167761);
    com.tencent.mm.ac.c.g((d.g.a.a)new f.h(this, paramk));
    AppMethodBeat.o(167761);
  }
  
  public final void cCu()
  {
    AppMethodBeat.i(167759);
    FinderItem localFinderItem = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().cAx();
    if (localFinderItem == null)
    {
      ac.d(this.TAG, "All has post, check posting folder");
      localObject = e.rMX;
      if (e.cCt())
      {
        localObject = new d(System.currentTimeMillis());
        this.rMY.b((com.tencent.mm.loader.g.c)localObject);
      }
      AppMethodBeat.o(167759);
      return;
    }
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("checking post-waiting finder feed from db, next will post: ").append(localFinderItem.getLocalId()).append(' ').append(localFinderItem.getCreateTime()).append(' ');
    Object localObject = localFinderItem.getPostInfo();
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((bqt)localObject).gLY);; localObject = null)
    {
      ac.i(str, ((Integer)localObject).intValue());
      localObject = new g(localFinderItem);
      this.rMY.b((com.tencent.mm.loader.g.c)localObject);
      AppMethodBeat.o(167759);
      return;
    }
  }
  
  public final void j(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167758);
    d.g.b.k.h(paramFinderItem, "feedObject");
    paramFinderItem.setPostWaiting();
    Object localObject = paramFinderItem.getPostInfo();
    if (localObject != null)
    {
      ((bqt)localObject).gLY = 0;
      ((bqt)localObject).FfV = 0;
      if (((bqt)localObject).FfT == 2) {
        ((bqt)localObject).FfT = 0;
      }
    }
    localObject = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
    com.tencent.mm.plugin.finder.storage.logic.b.a.h(paramFinderItem);
    cCu();
    localObject = i.c.ryP;
    i.c.cxd();
    localObject = com.tencent.mm.sdk.b.a.GpY;
    gz localgz = new gz();
    localgz.dhW.dcd = paramFinderItem.getLocalId();
    localgz.dhW.progress = paramFinderItem.getPostInfo().FfV;
    ((com.tencent.mm.sdk.b.a)localObject).l((com.tencent.mm.sdk.b.b)localgz);
    AppMethodBeat.o(167758);
  }
  
  public final void vi(final long paramLong)
  {
    AppMethodBeat.i(167762);
    com.tencent.mm.ac.c.g((d.g.a.a)new d(this, paramLong));
    AppMethodBeat.o(167762);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/FinderPostManager$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/FinderPostManager;", "shouldScrollToPostingItem", "", "getShouldScrollToPostingItem", "()Z", "setShouldScrollToPostingItem", "(Z)V", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(f paramf, k paramk)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(f paramf, long paramLong)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(f paramf, long paramLong)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/upload/FinderPostManager$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class i
    implements com.tencent.mm.loader.g.f<j>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.f
 * JD-Core Version:    0.7.0.1
 */