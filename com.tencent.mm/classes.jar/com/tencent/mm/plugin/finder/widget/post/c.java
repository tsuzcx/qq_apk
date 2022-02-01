package com.tencent.mm.plugin.finder.widget.post;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.b;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.post.SdkShareUIC;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.plugin.finder.utils.d;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.ayq;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.protocal.protobuf.erf;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "TAG", "", "compositionInfo", "", "getCompositionInfo", "()[B", "setCompositionInfo", "([B)V", "draftLocalId", "", "getDraftLocalId", "()J", "setDraftLocalId", "(J)V", "extraMusic", "getExtraMusic", "setExtraMusic", "fromCamera", "", "getFromCamera", "()Z", "setFromCamera", "(Z)V", "geoDegree", "Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "getGeoDegree", "()Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "setGeoDegree", "(Lcom/tencent/mm/plugin/finder/utils/GeoDegree;)V", "halfImageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getHalfImageList", "()Ljava/util/ArrayList;", "setHalfImageList", "(Ljava/util/ArrayList;)V", "halfRectList", "Landroid/graphics/Rect;", "getHalfRectList", "setHalfRectList", "imageQualityList", "", "getImageQualityList", "setImageQualityList", "getIntent", "()Landroid/content/Intent;", "isLongVideo", "setLongVideo", "mediaCount", "getMediaCount", "()I", "setMediaCount", "(I)V", "mediaList", "getMediaList", "setMediaList", "mediaMute", "getMediaMute", "setMediaMute", "musicMute", "getMusicMute", "setMusicMute", "originBgmUrl", "getOriginBgmUrl", "()Ljava/lang/String;", "setOriginBgmUrl", "(Ljava/lang/String;)V", "originMusicId", "getOriginMusicId", "setOriginMusicId", "originMusicInfo", "getOriginMusicInfo", "setOriginMusicInfo", "originMusicPath", "getOriginMusicPath", "setOriginMusicPath", "postData", "Landroid/os/Bundle;", "getPostData", "()Landroid/os/Bundle;", "postType", "getPostType", "()Ljava/lang/Integer;", "setPostType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRefFeed", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeed", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "refFeedContent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "getRefFeedContent", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "setRefFeedContent", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;)V", "soundTrackType", "getSoundTrackType", "setSoundTrackType", "thumbList", "getThumbList", "setThumbList", "typeList", "getTypeList", "setTypeList", "videoCropInfoList", "Landroid/os/Parcelable;", "getVideoCropInfoList", "setVideoCropInfoList", "vlogCropRect", "getVlogCropRect", "()Landroid/graphics/Rect;", "setVlogCropRect", "(Landroid/graphics/Rect;)V", "delMedia", "", "doPost", "context", "Landroid/app/Activity;", "desc", "uploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "atContactList", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "activityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "genHoldingPostData", "Lcom/tencent/mm/plugin/finder/upload/HoldingPostData;", "sdkShareUIC", "Lcom/tencent/mm/plugin/finder/ui/post/SdkShareUIC;", "generateFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "initLongVideoCropInfo", "setupPostDataForMediaWidget", "updatePostVideoCoverUrl", "coverUrl", "coverQuality", "cropInfo", "Lcom/tencent/mm/plugin/finder/video/LocalVideoCropInfoParcelable;", "plugin-finder_release"})
public final class c
{
  public final String TAG;
  private int dJl;
  public final Intent intent;
  public boolean isLongVideo;
  public boolean mch;
  public int soundTrackType;
  public ArrayList<String> tGk;
  public String vMV;
  public String vMX;
  public byte[] vMY;
  public String vMZ;
  public azy vTz;
  public final Bundle vUI;
  public Integer wCl;
  public ArrayList<Integer> wCm;
  public byte[] wCn;
  public ArrayList<Parcelable> wCo;
  public ArrayList<String> wCp;
  public ArrayList<Integer> wCq;
  public FinderObjectDesc wCr;
  public Rect wCs;
  public byte[] wCt;
  public boolean wCu;
  public boolean wCv;
  public long wCw;
  public ArrayList<String> wCx;
  public ArrayList<Rect> wCy;
  
  public c(Intent paramIntent)
  {
    AppMethodBeat.i(256114);
    this.intent = paramIntent;
    this.TAG = "Finder.PostDataManager";
    this.vUI = new Bundle();
    this.wCl = Integer.valueOf(this.intent.getIntExtra("postType", -1));
    this.tGk = this.intent.getStringArrayListExtra("postMediaList");
    this.wCm = this.intent.getIntegerArrayListExtra("key_post_media_quality_list");
    this.wCn = this.intent.getByteArrayExtra("video_composition");
    this.wCw = this.intent.getLongExtra("KEY_FINDER_POST_DRAFT_LOCAL_ID", 0L);
    paramIntent = this.tGk;
    int i;
    if (paramIntent != null) {
      i = paramIntent.size();
    }
    for (;;)
    {
      this.dJl = i;
      paramIntent = this.wCl;
      label137:
      Object localObject1;
      if (paramIntent == null)
      {
        localObject1 = this.intent.getByteArrayExtra("postRefMediaList");
        if (localObject1 != null) {
          paramIntent = (com.tencent.mm.bw.a)new FinderObjectDesc();
        }
      }
      try
      {
        paramIntent.parseFrom((byte[])localObject1);
        this.wCr = ((FinderObjectDesc)paramIntent);
        paramIntent = this.intent.getByteArrayExtra("postRefFeedInfo");
        if (paramIntent != null)
        {
          localObject1 = new azy();
          ((azy)localObject1).parseFrom(paramIntent);
          this.vTz = ((azy)localObject1);
        }
        this.mch = this.intent.getBooleanExtra("KEY_POST_FROM_CAMERA", false);
        this.wCo = this.intent.getParcelableArrayListExtra("postVideoCropList");
        this.wCp = this.intent.getStringArrayListExtra("postThumbList");
        this.wCs = ((Rect)this.intent.getParcelableExtra("KEY_POST_VLOG_CROP_RECT"));
        this.wCt = this.intent.getByteArrayExtra("MEDIA_EXTRA_MUSIC");
        this.vMX = this.intent.getStringExtra("ORIGIN_MUSIC_ID");
        this.vMY = this.intent.getByteArrayExtra("ORIGIN_MUSIC_INFO");
        this.vMV = this.intent.getStringExtra("ORIGIN_MUSIC_PATH");
        this.vMZ = this.intent.getStringExtra("ORIGIN_BGM_URL");
        this.wCu = this.intent.getBooleanExtra("MEDIA_IS_MUTE", this.wCu);
        this.wCv = this.intent.getBooleanExtra("MUSIC_IS_MUTE", this.wCv);
        this.soundTrackType = this.intent.getIntExtra("SOUND_TRACK_TYPE", 0);
        paramIntent = this.intent.getStringExtra("post_id");
        localObject1 = this.intent.getStringExtra("edit_id");
        if (paramIntent != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.report.i.vfo;
          com.tencent.mm.plugin.finder.report.i.gR(paramIntent, (String)localObject1);
        }
        this.isLongVideo = this.intent.getBooleanExtra("isLongVideoPost", false);
        this.wCx = this.intent.getStringArrayListExtra("KEY_POST_HALF_IMAGE_LIST");
        this.wCy = this.intent.getParcelableArrayListExtra("KEY_POST_HALF_RECT_LIST");
        paramIntent = this.TAG;
        localObject1 = new StringBuilder("postType ").append(this.wCl).append(", mediaList ").append(this.tGk).append(" mediaCount ").append(this.dJl).append(' ').append("thumbList ").append(this.wCp).append(" thumbCount ");
        Object localObject2 = this.wCp;
        i = j;
        if (localObject2 != null) {
          i = ((ArrayList)localObject2).size();
        }
        Log.i(paramIntent, i + ", fromCamera:" + this.mch);
        AppMethodBeat.o(256114);
        return;
        i = 0;
        continue;
        if (paramIntent.intValue() != 8) {
          break label137;
        }
        this.wCq = this.intent.getIntegerArrayListExtra("postTypeList");
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramIntent });
          paramIntent = null;
        }
      }
    }
  }
  
  public final FinderItem a(String paramString, g paramg, ArrayList<cjj> paramArrayList)
  {
    AppMethodBeat.i(256113);
    kotlin.g.b.p.h(paramString, "desc");
    kotlin.g.b.p.h(paramg, "uploadData");
    Object localObject9 = new axt();
    Object localObject8 = new aqp();
    new clp();
    Object localObject1 = this.vUI;
    Object localObject3 = a.wCk;
    localObject1 = ((Bundle)localObject1).getByteArray(a.dIY());
    if (localObject1 != null) {
      ((axt)localObject9).parseFrom((byte[])localObject1);
    }
    localObject1 = this.vUI;
    localObject3 = a.wCk;
    localObject1 = ((Bundle)localObject1).getByteArray(a.dIZ());
    if (localObject1 != null) {
      ((aqp)localObject8).parseFrom((byte[])localObject1);
    }
    localObject1 = this.vUI;
    localObject3 = a.wCk;
    int k = ((Bundle)localObject1).getInt(a.dJd(), 0);
    localObject1 = this.vUI;
    localObject3 = a.wCk;
    boolean bool1 = ((Bundle)localObject1).getBoolean(a.dJc(), false);
    localObject1 = this.vUI;
    localObject3 = a.wCk;
    localObject3 = ((Bundle)localObject1).getByteArray(a.dJa());
    localObject1 = this.vUI;
    Object localObject4 = a.wCk;
    localObject1 = ((Bundle)localObject1).getByteArray(a.dJb());
    if ((localObject3 != null) && (localObject1 != null)) {}
    Object localObject2;
    for (localObject1 = (com.tencent.mm.bw.a)new azy();; localObject2 = null) {
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (azy)localObject1;
        boolean bool2 = this.vUI.getBoolean("isNews");
        localObject3 = com.tencent.mm.plugin.finder.upload.g.vSJ;
        localObject6 = com.tencent.mm.plugin.finder.upload.g.dBa();
        m = paramg.type;
        localObject11 = Util.nullAsNil(paramString);
        kotlin.g.b.p.g(localObject11, "Util.nullAsNil(desc)");
        localObject5 = paramg.wDD;
        paramString = paramg.vTB;
        bool3 = this.isLongVideo;
        kotlin.g.b.p.h(localObject11, "description");
        kotlin.g.b.p.h(paramString, "videoPathBeforeCut");
        localObject4 = new FinderItem();
        paramg = ((FinderItem)localObject4).field_reportObject;
        if (paramg != null)
        {
          paramg.sendOrExitButtonTime = cl.aWA();
          paramg.videoPostType = m;
          paramg.beforeCutMediaPath = paramString;
          paramg.postStage = 1;
          paramString = x.SXb;
        }
        paramString = com.tencent.mm.plugin.finder.api.c.tsp;
        localObject3 = c.a.asG(z.aUg());
        localObject7 = new FinderObject();
        localObject10 = new FinderObjectDesc();
        if (bool2)
        {
          i = 1;
          ((FinderObject)localObject7).objectType = i;
          if (localObject1 == null) {
            break label551;
          }
          l = ((azy)localObject1).refObjectId;
          ((FinderObject)localObject7).refObjectId = l;
          if (localObject1 == null) {
            break label557;
          }
          l = ((azy)localObject1).refObjectFlag;
          ((FinderObject)localObject7).refObjectFlag = l;
          if (localObject1 == null) {
            break label563;
          }
          paramString = ((azy)localObject1).refObjectContact;
          ((FinderObject)localObject7).refObjectContact = paramString;
          ((FinderObject)localObject7).id = 0L;
          ((FinderObject)localObject7).username = z.aUg();
          paramString = com.tencent.mm.kernel.g.aAh();
          kotlin.g.b.p.g(paramString, "MMKernel.storage()");
          paramString = paramString.azQ().get(ar.a.OjH, "");
          if (paramString != null) {
            break label568;
          }
          paramString = new kotlin.t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(256113);
          throw paramString;
        }
      }
      catch (Exception localException)
      {
        Object localObject6;
        int m;
        Object localObject11;
        Object localObject5;
        boolean bool3;
        Object localObject7;
        Object localObject10;
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          localObject2 = null;
          continue;
          i = 0;
          continue;
          label551:
          long l = 0L;
          continue;
          label557:
          l = 0L;
          continue;
          label563:
          paramString = null;
        }
        label568:
        ((FinderObject)localObject7).nickname = ((String)paramString);
        ((FinderObject)localObject7).objectDesc = ((FinderObjectDesc)localObject10);
        paramString = y.vXH;
        ((FinderObject)localObject7).createtime = y.dCA();
        if (localObject3 != null) {}
        Object localObject12;
        for (paramString = b.a((com.tencent.mm.plugin.finder.api.g)localObject3);; paramString = paramg)
        {
          ((FinderObject)localObject7).contact = paramString;
          ((FinderObject)localObject7).mentionedUserContact = new LinkedList();
          paramString = com.tencent.mm.plugin.finder.storage.c.vCb;
          if ((!com.tencent.mm.plugin.finder.storage.c.drO()) || (paramArrayList == null)) {
            break label920;
          }
          paramString = paramArrayList.iterator();
          while (paramString.hasNext())
          {
            paramg = (cjj)paramString.next();
            localObject3 = ((FinderObject)localObject7).mentionedUserContact;
            localObject12 = d.vVg;
            kotlin.g.b.p.g(paramg, "atContact");
            ((LinkedList)localObject3).add(d.b(paramg));
          }
          paramg = new FinderContact();
          paramg.username = z.aUg();
          paramString = com.tencent.mm.kernel.g.aAh();
          kotlin.g.b.p.g(paramString, "MMKernel.storage()");
          paramString = paramString.azQ().get(ar.a.OjH, "");
          if (paramString == null)
          {
            paramString = new kotlin.t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(256113);
            throw paramString;
          }
          paramg.nickname = ((String)paramString);
          paramString = com.tencent.mm.kernel.g.aAh();
          kotlin.g.b.p.g(paramString, "MMKernel.storage()");
          paramString = paramString.azQ().get(ar.a.OjJ, "");
          if (paramString == null)
          {
            paramString = new kotlin.t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(256113);
            throw paramString;
          }
          paramg.headUrl = ((String)paramString);
          if (localObject3 != null)
          {
            localObject3 = ((com.tencent.mm.plugin.finder.api.g)localObject3).field_signature;
            paramString = (String)localObject3;
            if (localObject3 != null) {}
          }
          else
          {
            paramString = "";
          }
          paramg.signature = paramString;
          paramString = com.tencent.mm.kernel.g.aAh();
          kotlin.g.b.p.g(paramString, "MMKernel.storage()");
          paramString = paramString.azQ().get(ar.a.OjM, "");
          if (paramString == null)
          {
            paramString = new kotlin.t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(256113);
            throw paramString;
          }
          paramg.coverImgUrl = ((String)paramString);
          paramString = x.SXb;
        }
        paramString = x.SXb;
        label920:
        paramString = y.vXH;
        if (y.dnv()) {
          ((FinderObject)localObject7).permissionFlag = 3;
        }
        localObject3 = new bal();
        label982:
        label1020:
        Object localObject13;
        if (localObject5 != null)
        {
          paramString = ((cjk)localObject5).MoJ;
          ((FinderObjectDesc)localObject10).imgFeedBgmInfo = paramString;
          localObject12 = new azr();
          if (localObject5 == null) {
            break label1764;
          }
          paramString = ((cjk)localObject5).MoJ;
          ((azr)localObject12).musicInfo = paramString;
          if (localObject5 != null)
          {
            paramg = ((cjk)localObject5).vMX;
            paramString = paramg;
            if (paramg != null) {}
          }
          else
          {
            paramString = ((azr)localObject12).musicInfo;
            if (paramString == null) {
              break label1769;
            }
            paramString = paramString.wWb;
          }
          ((azr)localObject12).groupId = paramString;
          if (((localObject5 == null) || (((cjk)localObject5).wCu)) && ((localObject5 == null) || (((cjk)localObject5).wCv))) {
            break label1774;
          }
          i = 1;
          label1055:
          ((azr)localObject12).LJw = i;
          paramg = ((com.tencent.mm.plugin.finder.upload.g)localObject6).TAG;
          localObject13 = new StringBuilder("FinderObjectBGMInfo, groupId:").append(((azr)localObject12).groupId).append(", mediaMute:");
          if (localObject5 == null) {
            break label1780;
          }
          paramString = Boolean.valueOf(((cjk)localObject5).wCu);
          label1108:
          localObject13 = ((StringBuilder)localObject13).append(paramString).append(", musicMute:");
          if (localObject5 == null) {
            break label1785;
          }
          paramString = Boolean.valueOf(((cjk)localObject5).wCv);
          label1136:
          Log.d(paramg, paramString + ", hasBgm:" + ((azr)localObject12).LJw);
          paramString = (CharSequence)((azr)localObject12).groupId;
          if ((paramString != null) && (paramString.length() != 0)) {
            break label1790;
          }
          i = 1;
          label1188:
          if ((i == 0) && (((azr)localObject12).musicInfo == null))
          {
            paramg = new azk();
            if (localObject5 == null) {
              break label1796;
            }
            paramString = ((cjk)localObject5).MoK;
            label1220:
            paramString = (CharSequence)paramString;
            if ((paramString != null) && (paramString.length() != 0)) {
              break label1801;
            }
            i = 1;
            label1241:
            if (i == 0) {
              break label1812;
            }
            if (localObject5 == null) {
              break label1807;
            }
            paramString = ((cjk)localObject5).vMV;
            label1257:
            paramString = q.k(paramString, true);
            label1263:
            paramg.LJi = paramString;
            paramString = x.SXb;
            ((azr)localObject12).musicInfo = paramg;
          }
          paramString = x.SXb;
          ((FinderObjectDesc)localObject10).feedBgmInfo = ((azr)localObject12);
          if (localObject5 == null) {
            break label2018;
          }
          paramString = ((cjk)localObject5).mediaList;
          if (paramString == null) {
            break label2018;
          }
          localObject12 = ((Iterable)paramString).iterator();
          i = 0;
        }
        label1318:
        int j;
        for (;;)
        {
          if (!((Iterator)localObject12).hasNext()) {
            break label2014;
          }
          paramString = ((Iterator)localObject12).next();
          j = i + 1;
          if (i < 0) {
            kotlin.a.j.hxH();
          }
          localObject13 = (cjl)paramString;
          Object localObject14 = new FinderMedia();
          ((FinderMedia)localObject14).url = ((cjl)localObject13).url;
          ((FinderMedia)localObject14).mediaType = ((cjl)localObject13).mediaType;
          ((FinderMedia)localObject14).thumbUrl = ((cjl)localObject13).thumbUrl;
          ((FinderMedia)localObject14).full_thumb_url = ((cjl)localObject13).MoR;
          if ((!((cjl)localObject13).MoO) && (((cjl)localObject13).videoDuration <= 0))
          {
            paramString = com.tencent.mm.plugin.sight.base.e.aNx(((cjl)localObject13).url);
            if (paramString != null)
            {
              ((cjl)localObject13).videoDuration = paramString.getVideoDuration();
              paramString = x.SXb;
            }
          }
          ((FinderMedia)localObject14).videoDuration = ((cjl)localObject13).videoDuration;
          ((FinderMedia)localObject14).width = ((cjl)localObject13).width;
          ((FinderMedia)localObject14).height = ((cjl)localObject13).height;
          ((FinderMedia)localObject14).md5sum = ((cjl)localObject13).md5sum;
          ((FinderMedia)localObject14).coverUrl = ((cjl)localObject13).coverUrl;
          ((FinderObjectDesc)localObject10).media.add(localObject14);
          if ((i == 0) && (!Util.isNullOrNil(((cjl)localObject13).url)) && ((((cjl)localObject13).mediaType == 2) || (((cjl)localObject13).mediaType == 4)))
          {
            if (((cjl)localObject13).mediaType != 2) {
              break label1831;
            }
            paramString = y.vXH;
            paramg = ((cjl)localObject13).url;
            paramString = paramg;
            if (paramg == null) {
              paramString = "";
            }
          }
          for (paramString = y.awo(paramString);; paramString = y.awp(((cjl)localObject13).url))
          {
            if (paramString != null)
            {
              ((bal)localObject3).LKd = ((float)((Number)paramString.first).doubleValue());
              ((bal)localObject3).LKc = ((float)((Number)paramString.second).doubleValue());
              paramString = x.SXb;
            }
            if (((FinderMedia)localObject14).mediaType != 2) {
              break label1847;
            }
            paramString = ((com.tencent.mm.plugin.finder.upload.g)localObject6).TAG;
            paramg = new StringBuilder("print mediaList ").append(i).append(' ').append(((cjl)localObject13).url).append(" size:").append(Util.getSizeKB(s.boW(((cjl)localObject13).url))).append(" option ");
            localObject13 = BitmapUtil.getImageOptions(((cjl)localObject13).url);
            Log.i(paramString, new StringBuilder("w*h:[").append(((BitmapFactory.Options)localObject13).outWidth).append(" * ").append(((BitmapFactory.Options)localObject13).outHeight).append(']').toString() + '}');
            i = j;
            break label1318;
            paramString = null;
            break;
            label1764:
            paramString = null;
            break label982;
            label1769:
            paramString = null;
            break label1020;
            label1774:
            i = 0;
            break label1055;
            label1780:
            paramString = null;
            break label1108;
            label1785:
            paramString = null;
            break label1136;
            label1790:
            i = 0;
            break label1188;
            label1796:
            paramString = null;
            break label1220;
            label1801:
            i = 0;
            break label1241;
            label1807:
            paramString = null;
            break label1257;
            label1812:
            if (localObject5 != null)
            {
              paramString = ((cjk)localObject5).MoK;
              break label1263;
            }
            paramString = null;
            break label1263;
            label1831:
            paramString = y.vXH;
          }
          label1847:
          if (((FinderMedia)localObject14).mediaType == 4)
          {
            paramString = ((com.tencent.mm.plugin.finder.upload.g)localObject6).TAG;
            paramg = new StringBuilder("print mediaList ").append(i).append(' ').append(((cjl)localObject13).url).append(" size:").append(Util.getSizeKB(s.boW(((cjl)localObject13).url))).append(" option ");
            localObject14 = com.tencent.mm.plugin.gallery.a.c.xsz;
            Log.i(paramString, com.tencent.mm.plugin.gallery.a.c.awl(((cjl)localObject13).url));
            i = j;
          }
          else
          {
            Log.i(((com.tencent.mm.plugin.finder.upload.g)localObject6).TAG, "print mediaList " + i + ' ' + ((cjl)localObject13).url + " size:" + Util.getSizeKB(s.boW(((cjl)localObject13).url)));
            i = j;
          }
        }
        label2014:
        paramString = x.SXb;
        label2018:
        paramString = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
        paramString = FinderGlobalLocationVM.dHP();
        ((bal)localObject3).dTj = ((Number)paramString.first).floatValue();
        ((bal)localObject3).latitude = ((Number)paramString.second).floatValue();
        paramString = x.SXb;
        if (bool1) {}
        for (int i = 1;; i = 0)
        {
          ((bal)localObject3).LKe = i;
          ((FinderItem)localObject4).field_postExtraData = ((bal)localObject3);
          ((FinderObject)localObject7).displayidDiscarded = "";
          ((FinderObject)localObject7).recommendReason = "";
          ((FinderObject)localObject7).secondaryShowFlag = 1;
          ((FinderObject)localObject7).originalFlag = k;
          ((FinderObjectDesc)localObject10).description = ((String)localObject11);
          ((FinderObjectDesc)localObject10).mediaType = m;
          ((FinderObjectDesc)localObject10).location = ((axt)localObject9);
          ((FinderObjectDesc)localObject10).extReading = ((aqp)localObject8);
          localObject3 = new HashMap();
          paramString = com.tencent.mm.plugin.finder.storage.c.vCb;
          if ((!com.tencent.mm.plugin.finder.storage.c.drO()) || (paramArrayList == null)) {
            break label2303;
          }
          localObject9 = new LinkedList();
          localObject12 = paramArrayList.iterator();
          while (((Iterator)localObject12).hasNext())
          {
            localObject13 = (cjj)((Iterator)localObject12).next();
            paramString = new ayq();
            paramString.username = ((cjj)localObject13).username;
            paramString.source = ((cjj)localObject13).type;
            paramString.nickname = ((cjj)localObject13).nickname;
            ((LinkedList)localObject9).add(paramString);
            paramg = ((cjj)localObject13).nickname;
            paramString = paramg;
            if (paramg == null) {
              paramString = "";
            }
            ((HashMap)localObject3).put(paramString, localObject13);
            paramString = x.SXb;
          }
        }
        ((FinderObjectDesc)localObject10).mentionedUser = ((LinkedList)localObject9);
        paramString = x.SXb;
        label2303:
        paramString = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (!com.tencent.mm.plugin.finder.storage.c.drN())
        {
          paramString = com.tencent.mm.plugin.finder.storage.c.vCb;
          if (!com.tencent.mm.plugin.finder.storage.c.drO()) {}
        }
        else
        {
          paramString = new bdq();
          paramg = com.tencent.mm.plugin.finder.utils.t.vWZ;
          paramString.LNs = com.tencent.mm.plugin.finder.utils.t.c((String)localObject11, (HashMap)localObject3);
          paramg = x.SXb;
          ((FinderObjectDesc)localObject10).topic = paramString;
        }
        paramString = ((FinderItem)localObject4).field_reportObject;
        label2402:
        float f;
        if (paramString != null)
        {
          paramg = ((FinderObjectDesc)localObject10).description;
          if (paramg == null) {
            break label2718;
          }
          i = paramg.length();
          paramString.descCount = i;
          if (((FinderItem)localObject4).field_reportObject.descCount <= 0) {
            break label2724;
          }
          i = 1;
          paramString.existDesc = i;
          paramg = ((FinderObjectDesc)localObject10).location;
          if (paramg == null) {
            break label2730;
          }
          f = paramg.latitude;
          label2424:
          if (f <= 0.0F) {
            break label2742;
          }
          paramg = ((FinderObjectDesc)localObject10).location;
          if (paramg == null) {
            break label2736;
          }
          f = paramg.dTj;
          label2447:
          if (f <= 0.0F) {
            break label2742;
          }
        }
        label2718:
        label2724:
        label2730:
        label2736:
        label2742:
        for (paramString.existLocation = 1;; paramString.existLocation = 0)
        {
          paramString.link = ((aqp)localObject8).link;
          paramString = x.SXb;
          paramString = x.SXb;
          if (!bool3) {
            break label2880;
          }
          localObject3 = new cnl();
          ((cnl)localObject3).description = ((FinderObjectDesc)localObject10).description;
          paramString = ((FinderObjectDesc)localObject10).media;
          if (paramString == null) {
            break label2754;
          }
          localObject8 = ((Iterable)paramString).iterator();
          while (((Iterator)localObject8).hasNext())
          {
            localObject10 = (FinderMedia)((Iterator)localObject8).next();
            localObject9 = new cod();
            ((cod)localObject9).url = ((FinderMedia)localObject10).url;
            paramString = f.vSz;
            paramg = ((cod)localObject9).url;
            paramString = paramg;
            if (paramg == null) {
              paramString = "";
            }
            ((cod)localObject9).thumbUrl = f.avT(paramString);
            ((cod)localObject9).mediaType = 0;
            localObject11 = MultiMediaVideoChecker.GyY;
            paramg = ((cod)localObject9).url;
            paramString = paramg;
            if (paramg == null) {
              paramString = "";
            }
            paramString = ((MultiMediaVideoChecker)localObject11).aTV(paramString);
            if (paramString != null)
            {
              ((cod)localObject9).width = paramString.width;
              ((cod)localObject9).height = paramString.height;
              ((cod)localObject9).Mur = kotlin.h.a.cR((float)paramString.duration / 1000.0F);
              paramString = x.SXb;
            }
            ((cod)localObject9).md5sum = ((FinderMedia)localObject10).md5sum;
            ((cod)localObject9).fileSize = ((FinderMedia)localObject10).fileSize;
            ((cod)localObject9).bitrate = ((FinderMedia)localObject10).bitrate;
            paramString = x.SXb;
            ((cnl)localObject3).media.add(localObject9);
          }
          i = 0;
          break;
          i = 0;
          break label2402;
          f = 0.0F;
          break label2424;
          f = 0.0F;
          break label2447;
        }
        paramString = x.SXb;
        label2754:
        paramg = new cng();
        paramg.id = 0L;
        paramg.iXu = ((FinderObject)localObject7).createtime;
        paramg.MtG = ((cnl)localObject3);
        paramString = x.SXb;
        paramString = new aoq();
        paramString.LAM = new LinkedList();
        localObject3 = paramString.LAM;
        localObject8 = new aop();
        ((aop)localObject8).type = 1;
        localObject9 = new bei();
        ((bei)localObject9).id = 0L;
        ((bei)localObject9).LIA = paramg;
        paramg = x.SXb;
        ((aop)localObject8).LAL = ((bei)localObject9);
        paramg = x.SXb;
        ((LinkedList)localObject3).add(localObject8);
        paramg = x.SXb;
        ((FinderObject)localObject7).attachmentList = paramString;
        label2880:
        Log.i(((com.tencent.mm.plugin.finder.upload.g)localObject6).TAG, "finder send post " + com.tencent.mm.ac.g.bN(localObject7));
        ((FinderItem)localObject4).updateFinderObject((FinderObject)localObject7);
        paramString = com.tencent.mm.plugin.finder.upload.i.vSX;
        paramString = com.tencent.mm.plugin.finder.upload.i.dBh();
        paramString.Mpd = cl.aWy();
        if (paramArrayList != null)
        {
          paramString.Mpg.clear();
          paramString.Mpg.addAll((Collection)paramArrayList);
        }
        paramg = x.SXb;
        ((FinderItem)localObject4).setPostInfo(paramString);
        if (localObject5 != null)
        {
          paramg = ((cjk)localObject5).mediaList;
          paramString = paramg;
          if (paramg != null) {}
        }
        else
        {
          paramString = new LinkedList();
        }
        ((FinderItem)localObject4).setMediaExtList(paramString);
        paramString = ((FinderObject)localObject7).attachmentList;
        if (paramString != null)
        {
          paramString = paramString.LAM;
          if (paramString != null)
          {
            paramString = (aop)kotlin.a.j.kt((List)paramString);
            if (paramString != null)
            {
              paramString = paramString.LAL;
              if (paramString != null)
              {
                paramString = paramString.LIA;
                if (paramString != null)
                {
                  paramString = paramString.MtG;
                  if (paramString != null)
                  {
                    paramString = paramString.media;
                    if (paramString != null)
                    {
                      paramString = com.tencent.mm.plugin.finder.storage.data.j.aB(paramString);
                      ((FinderItem)localObject4).setLongVideoMediaExtList(paramString);
                      paramArrayList = ((Iterable)((FinderItem)localObject4).getLongVideoMediaExtList()).iterator();
                      label3090:
                      if (!paramArrayList.hasNext()) {
                        break label3900;
                      }
                      localObject3 = (cjl)paramArrayList.next();
                      ((cjl)localObject3).mediaId = ("longvideo_" + ((cjl)localObject3).mediaId);
                      ((cjl)localObject3).MoO = true;
                      localObject5 = new cjx();
                      paramString = com.tencent.mm.plugin.finder.storage.c.vCb;
                      localObject6 = com.tencent.mm.plugin.finder.storage.c.dqy();
                      i = (int)((cjl)localObject3).width;
                      j = (int)((cjl)localObject3).height;
                      k = SightVideoJNI.getMp4RotateVFS(((cjl)localObject3).url);
                      if ((k == 90) || (k == 270))
                      {
                        i = (int)((cjl)localObject3).height;
                        j = (int)((cjl)localObject3).width;
                      }
                      paramString = MMApplicationContext.getContext();
                      kotlin.g.b.p.g(paramString, "MMApplicationContext.getContext()");
                      paramString = paramString.getResources();
                      kotlin.g.b.p.g(paramString, "MMApplicationContext.getContext().resources");
                      k = paramString.getDisplayMetrics().widthPixels;
                      f = i / j;
                      if ((f < 0.5625F) || (f > 1.777778F)) {
                        break label3603;
                      }
                      paramString = new erf();
                      paramString.left = 0;
                      paramString.top = j;
                      paramString.right = i;
                      paramString.bottom = 0;
                      paramg = x.SXb;
                      ((cjx)localObject5).Mpq = paramString;
                      ((cjx)localObject5).Mps = paramString;
                      paramg = kotlin.a.j.listOf(new Float[] { Float.valueOf(1.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(1.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(1.0F) });
                      paramString = new bej();
                      paramString.LOe.addAll((Collection)kotlin.a.j.p((Iterable)paramg));
                      paramg = x.SXb;
                      ((cjx)localObject5).Mpr = paramString;
                    }
                  }
                }
              }
            }
          }
        }
        for (;;)
        {
          ((cjx)localObject5).dvv = 0;
          localObject7 = MultiMediaVideoChecker.GyY;
          paramg = ((cjl)localObject3).url;
          paramString = paramg;
          if (paramg == null) {
            paramString = "";
          }
          paramString = ((MultiMediaVideoChecker)localObject7).aTV(paramString);
          if (paramString != null)
          {
            ((cjx)localObject5).iqg = Math.min(((VideoTransPara)localObject6).duration * 1000, (int)paramString.duration);
            paramString = x.SXb;
          }
          paramString = com.tencent.mm.plugin.finder.upload.g.af(i, j, Math.min(((VideoTransPara)localObject6).width, ((VideoTransPara)localObject6).height));
          i = ((Number)paramString.first).intValue();
          j = ((Number)paramString.second).intValue();
          ((cjx)localObject5).width = i;
          ((cjx)localObject5).height = j;
          ((cjl)localObject3).width = i;
          ((cjl)localObject3).height = j;
          ((cjx)localObject5).retryCount = 0;
          paramString = x.SXb;
          ((cjl)localObject3).uOR = ((cjx)localObject5);
          break label3090;
          paramString = new LinkedList();
          break;
          label3603:
          if (f > 1.777778F)
          {
            k = (int)(j * 16.0F / 9.0F);
            paramg = new erf();
            paramg.left = ((i - k) / 2);
            paramg.top = j;
            paramg.right = (i - paramg.left);
            paramg.bottom = 0;
            paramString = x.SXb;
            ((cjx)localObject5).Mpq = paramg;
            ((cjx)localObject5).Mps = paramg;
            paramString = new Matrix();
            paramString.postTranslate(-paramg.left, 0.0F);
            paramg = new bej();
            localObject7 = new float[9];
            paramString.getValues((float[])localObject7);
            paramg.LOe.addAll((Collection)kotlin.a.e.s((float[])localObject7));
            paramString = x.SXb;
            ((cjx)localObject5).Mpr = paramg;
            i = k;
          }
          else
          {
            k = (int)(i * 16.0F / 9.0F);
            paramg = new erf();
            paramg.left = 0;
            paramg.bottom = ((j - k) / 2);
            paramg.right = i;
            paramg.top = (j - paramg.bottom);
            paramString = x.SXb;
            ((cjx)localObject5).Mpq = paramg;
            ((cjx)localObject5).Mps = paramg;
            paramString = new Matrix();
            paramString.postTranslate(0.0F, -paramg.bottom);
            paramg = new bej();
            localObject7 = new float[9];
            paramString.getValues((float[])localObject7);
            paramg.LOe.addAll((Collection)kotlin.a.e.s((float[])localObject7));
            paramString = x.SXb;
            ((cjx)localObject5).Mpr = paramg;
            j = k;
          }
        }
        label3900:
        if (localObject2 != null)
        {
          paramString = ((FinderItem)localObject4).getPostInfo();
          paramString.Mpa = 1;
          paramg = x.SXb;
          ((FinderItem)localObject4).setPostInfo(paramString);
        }
        ((FinderItem)localObject4).setPostWaiting();
        ((FinderItem)localObject4).setLocalId(System.currentTimeMillis());
        AppMethodBeat.o(256113);
        return localObject4;
      }
    }
  }
  
  public final com.tencent.mm.plugin.finder.upload.p a(g paramg, String paramString, ArrayList<cjj> paramArrayList, SdkShareUIC paramSdkShareUIC, azs paramazs)
  {
    AppMethodBeat.i(256112);
    axt localaxt = new axt();
    aqp localaqp = new aqp();
    Object localObject3 = null;
    Object localObject1 = this.vUI;
    Object localObject4 = a.wCk;
    localObject1 = ((Bundle)localObject1).getByteArray(a.dIY());
    if (localObject1 != null) {
      localaxt.parseFrom((byte[])localObject1);
    }
    localObject1 = this.vUI;
    localObject4 = a.wCk;
    localObject1 = ((Bundle)localObject1).getByteArray(a.dIZ());
    if (localObject1 != null) {
      localaqp.parseFrom((byte[])localObject1);
    }
    localObject1 = this.vUI;
    localObject4 = a.wCk;
    int j = ((Bundle)localObject1).getInt(a.dJd(), 0);
    localObject1 = this.vUI;
    localObject4 = a.wCk;
    boolean bool1 = ((Bundle)localObject1).getBoolean(a.dJc(), false);
    localObject1 = this.vUI;
    localObject4 = a.wCk;
    localObject4 = ((Bundle)localObject1).getByteArray(a.dJa());
    localObject1 = this.vUI;
    Object localObject5 = a.wCk;
    localObject5 = ((Bundle)localObject1).getByteArray(a.dJb());
    localObject1 = localObject3;
    if (localObject4 != null)
    {
      localObject1 = localObject3;
      if (localObject5 != null) {
        localObject1 = (com.tencent.mm.bw.a)new azy();
      }
    }
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject4);
      localObject1 = (azy)localObject1;
      boolean bool2 = this.vUI.getBoolean("isNews");
      localObject5 = new arm();
      if (paramSdkShareUIC != null)
      {
        localObject4 = paramSdkShareUIC.vRz;
        localObject3 = localObject4;
        if (localObject4 != null) {}
      }
      else
      {
        localObject3 = "";
      }
      ((arm)localObject5).dNI = ((String)localObject3);
      int k = paramg.type;
      localObject4 = Util.nullAsNil(paramString);
      kotlin.g.b.p.g(localObject4, "Util.nullAsNil(desc)");
      cjk localcjk = paramg.wDD;
      String str = paramg.vTB;
      boolean bool3 = this.isLongVideo;
      if (paramSdkShareUIC != null)
      {
        paramString = paramSdkShareUIC.tsW;
        paramg = paramString;
        if (paramString != null) {}
      }
      else
      {
        paramg = "";
      }
      if (paramSdkShareUIC != null)
      {
        localObject3 = paramSdkShareUIC.tsX;
        paramString = (String)localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        paramString = "";
      }
      if (paramSdkShareUIC != null) {
        if (Util.isNullOrNil(paramSdkShareUIC.dAO()))
        {
          i = 0;
          paramg = new com.tencent.mm.plugin.finder.upload.p(k, (String)localObject4, localcjk, localaxt, localaqp, j, (azy)localObject1, bool1, str, paramArrayList, bool3, bool2, (arm)localObject5, paramg, paramString, i, paramazs);
          Log.i(this.TAG, "doPost, mediaType:" + paramg.mediaType + ", isLongVideo:" + paramg.isLongVideo + ", sdkShareType:" + paramg.sdkShareType);
          AppMethodBeat.o(256112);
          return paramg;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
        continue;
        if (Util.isNullOrNil(paramSdkShareUIC.tsW))
        {
          i = SdkShareUIC.vRA;
        }
        else
        {
          i = SdkShareUIC.vRB;
          continue;
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.c
 * JD-Core Version:    0.7.0.1
 */