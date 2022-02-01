package com.tencent.mm.plugin.finder.widget.post;

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
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.ad;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.asl;
import com.tencent.mm.protocal.protobuf.ati;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bek;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.protocal.protobuf.bkp;
import com.tencent.mm.protocal.protobuf.blj;
import com.tencent.mm.protocal.protobuf.blk;
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cum;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.protocal.protobuf.fbq;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "TAG", "", "compositionInfo", "", "getCompositionInfo", "()[B", "setCompositionInfo", "([B)V", "draftLocalId", "", "getDraftLocalId", "()J", "setDraftLocalId", "(J)V", "extraMusic", "getExtraMusic", "setExtraMusic", "fromCamera", "", "getFromCamera", "()Z", "setFromCamera", "(Z)V", "geoDegree", "Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "getGeoDegree", "()Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "setGeoDegree", "(Lcom/tencent/mm/plugin/finder/utils/GeoDegree;)V", "halfImageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getHalfImageList", "()Ljava/util/ArrayList;", "setHalfImageList", "(Ljava/util/ArrayList;)V", "halfRectList", "Landroid/graphics/Rect;", "getHalfRectList", "setHalfRectList", "imageQualityList", "", "getImageQualityList", "setImageQualityList", "getIntent", "()Landroid/content/Intent;", "isLongVideo", "setLongVideo", "mediaCount", "getMediaCount", "()I", "setMediaCount", "(I)V", "mediaList", "getMediaList", "setMediaList", "mediaMute", "getMediaMute", "setMediaMute", "musicFeedId", "getMusicFeedId", "()Ljava/lang/String;", "setMusicFeedId", "(Ljava/lang/String;)V", "musicMute", "getMusicMute", "setMusicMute", "originBgmUrl", "getOriginBgmUrl", "setOriginBgmUrl", "originMusicId", "getOriginMusicId", "setOriginMusicId", "originMusicInfo", "getOriginMusicInfo", "setOriginMusicInfo", "originMusicPath", "getOriginMusicPath", "setOriginMusicPath", "postData", "Landroid/os/Bundle;", "getPostData", "()Landroid/os/Bundle;", "postType", "getPostType", "()Ljava/lang/Integer;", "setPostType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRefFeed", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeed", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "refFeedContent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "getRefFeedContent", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "setRefFeedContent", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;)V", "soundTrackType", "getSoundTrackType", "setSoundTrackType", "thumbList", "getThumbList", "setThumbList", "typeList", "getTypeList", "setTypeList", "videoCropInfoList", "Landroid/os/Parcelable;", "getVideoCropInfoList", "setVideoCropInfoList", "vlogCropRect", "getVlogCropRect", "()Landroid/graphics/Rect;", "setVlogCropRect", "(Landroid/graphics/Rect;)V", "delMedia", "", "doPost", "context", "Landroid/app/Activity;", "desc", "uploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "atContactList", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "activityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "genHoldingPostData", "Lcom/tencent/mm/plugin/finder/upload/HoldingPostData;", "sdkShareUIC", "Lcom/tencent/mm/plugin/finder/live/ui/post/SdkShareUIC;", "generateFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "initLongVideoCropInfo", "setupPostDataForMediaWidget", "updatePostVideoCoverUrl", "coverUrl", "coverQuality", "cropInfo", "Lcom/tencent/mm/plugin/finder/video/LocalVideoCropInfoParcelable;", "plugin-finder_release"})
public final class c
{
  public bge ABc;
  public final Bundle ACv;
  public String AtN;
  public String AtP;
  public byte[] AtQ;
  public String AtR;
  public Integer BsT;
  public ArrayList<Integer> BsU;
  public byte[] BsV;
  public ArrayList<Parcelable> BsW;
  public ArrayList<String> BsX;
  public ArrayList<Integer> BsY;
  public FinderObjectDesc BsZ;
  public Rect Bta;
  public byte[] Btb;
  public boolean Btc;
  public boolean Btd;
  public long Bte;
  public ArrayList<String> Btf;
  public ArrayList<Rect> Btg;
  public final String TAG;
  private int fCa;
  public final Intent intent;
  public boolean isLongVideo;
  public String musicFeedId;
  public boolean oZX;
  public int soundTrackType;
  public ArrayList<String> xoX;
  
  public c(Intent paramIntent)
  {
    AppMethodBeat.i(224839);
    this.intent = paramIntent;
    this.TAG = "Finder.PostDataManager";
    this.ACv = new Bundle();
    this.BsT = Integer.valueOf(this.intent.getIntExtra("postType", -1));
    this.xoX = this.intent.getStringArrayListExtra("postMediaList");
    this.BsU = this.intent.getIntegerArrayListExtra("key_post_media_quality_list");
    this.BsV = this.intent.getByteArrayExtra("video_composition");
    this.Bte = this.intent.getLongExtra("KEY_FINDER_POST_DRAFT_LOCAL_ID", 0L);
    paramIntent = this.xoX;
    int i;
    if (paramIntent != null) {
      i = paramIntent.size();
    }
    for (;;)
    {
      this.fCa = i;
      paramIntent = this.BsT;
      label138:
      Object localObject1;
      if (paramIntent == null)
      {
        localObject1 = this.intent.getByteArrayExtra("postRefMediaList");
        if (localObject1 != null) {
          paramIntent = (com.tencent.mm.cd.a)new FinderObjectDesc();
        }
      }
      try
      {
        paramIntent.parseFrom((byte[])localObject1);
        this.BsZ = ((FinderObjectDesc)paramIntent);
        paramIntent = this.intent.getByteArrayExtra("postRefFeedInfo");
        if (paramIntent != null)
        {
          localObject1 = new bge();
          ((bge)localObject1).parseFrom(paramIntent);
          this.ABc = ((bge)localObject1);
        }
        this.oZX = this.intent.getBooleanExtra("KEY_POST_FROM_CAMERA", false);
        this.BsW = this.intent.getParcelableArrayListExtra("postVideoCropList");
        this.BsX = this.intent.getStringArrayListExtra("postThumbList");
        this.Bta = ((Rect)this.intent.getParcelableExtra("KEY_POST_VLOG_CROP_RECT"));
        this.Btb = this.intent.getByteArrayExtra("MEDIA_EXTRA_MUSIC");
        this.AtP = this.intent.getStringExtra("ORIGIN_MUSIC_ID");
        this.AtQ = this.intent.getByteArrayExtra("ORIGIN_MUSIC_INFO");
        this.AtN = this.intent.getStringExtra("ORIGIN_MUSIC_PATH");
        this.AtR = this.intent.getStringExtra("ORIGIN_BGM_URL");
        this.Btc = this.intent.getBooleanExtra("MEDIA_IS_MUTE", this.Btc);
        this.Btd = this.intent.getBooleanExtra("MUSIC_IS_MUTE", this.Btd);
        this.soundTrackType = this.intent.getIntExtra("SOUND_TRACK_TYPE", 0);
        this.musicFeedId = this.intent.getStringExtra("MUSIC_FEED_ID");
        paramIntent = this.intent.getStringExtra("post_id");
        localObject1 = this.intent.getStringExtra("edit_id");
        if (paramIntent != null)
        {
          localObject2 = k.zWs;
          k.hh(paramIntent, (String)localObject1);
        }
        this.isLongVideo = this.intent.getBooleanExtra("isLongVideoPost", false);
        this.Btf = this.intent.getStringArrayListExtra("KEY_POST_HALF_IMAGE_LIST");
        this.Btg = this.intent.getParcelableArrayListExtra("KEY_POST_HALF_RECT_LIST");
        paramIntent = this.TAG;
        localObject1 = new StringBuilder("postType ").append(this.BsT).append(", mediaList ").append(this.xoX).append(" mediaCount ").append(this.fCa).append(' ').append("thumbList ").append(this.BsX).append(" thumbCount ");
        Object localObject2 = this.BsX;
        i = j;
        if (localObject2 != null) {
          i = ((ArrayList)localObject2).size();
        }
        Log.i(paramIntent, i + ", fromCamera:" + this.oZX);
        AppMethodBeat.o(224839);
        return;
        i = 0;
        continue;
        if (paramIntent.intValue() != 8) {
          break label138;
        }
        this.BsY = this.intent.getIntegerArrayListExtra("postTypeList");
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
  
  public final FinderItem a(String paramString, g paramg, ArrayList<cse> paramArrayList)
  {
    AppMethodBeat.i(224823);
    kotlin.g.b.p.k(paramString, "desc");
    kotlin.g.b.p.k(paramg, "uploadData");
    Object localObject9 = new bdm();
    Object localObject8 = new asl();
    new cum();
    Object localObject1 = this.ACv;
    Object localObject3 = a.BsS;
    localObject1 = ((Bundle)localObject1).getByteArray(a.emq());
    if (localObject1 != null) {
      ((bdm)localObject9).parseFrom((byte[])localObject1);
    }
    localObject1 = this.ACv;
    localObject3 = a.BsS;
    localObject1 = ((Bundle)localObject1).getByteArray(a.emr());
    if (localObject1 != null) {
      ((asl)localObject8).parseFrom((byte[])localObject1);
    }
    localObject1 = this.ACv;
    localObject3 = a.BsS;
    int k = ((Bundle)localObject1).getInt(a.emv(), 0);
    localObject1 = this.ACv;
    localObject3 = a.BsS;
    boolean bool1 = ((Bundle)localObject1).getBoolean(a.emu(), false);
    localObject1 = this.ACv;
    localObject3 = a.BsS;
    localObject3 = ((Bundle)localObject1).getByteArray(a.ems());
    localObject1 = this.ACv;
    Object localObject4 = a.BsS;
    localObject1 = ((Bundle)localObject1).getByteArray(a.emt());
    if ((localObject3 != null) && (localObject1 != null)) {}
    Object localObject2;
    for (localObject1 = (com.tencent.mm.cd.a)new bge();; localObject2 = null) {
      try
      {
        ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (bge)localObject1;
        boolean bool2 = this.ACv.getBoolean("isNews");
        localObject3 = com.tencent.mm.plugin.finder.upload.g.AAk;
        localObject6 = com.tencent.mm.plugin.finder.upload.g.ecj();
        m = paramg.type;
        localObject11 = Util.nullAsNil(paramString);
        kotlin.g.b.p.j(localObject11, "Util.nullAsNil(desc)");
        localObject5 = paramg.Bul;
        paramString = paramg.ABe;
        bool3 = this.isLongVideo;
        kotlin.g.b.p.k(localObject11, "description");
        kotlin.g.b.p.k(paramString, "videoPathBeforeCut");
        localObject4 = new FinderItem();
        paramg = ((FinderItem)localObject4).field_reportObject;
        if (paramg != null)
        {
          paramg.sendOrExitButtonTime = cm.bfE();
          paramg.videoPostType = m;
          paramg.beforeCutMediaPath = paramString;
          paramg.postStage = 1;
          paramString = x.aazN;
        }
        paramString = com.tencent.mm.plugin.finder.api.d.wZQ;
        localObject3 = d.a.aAK(z.bdh());
        localObject7 = new FinderObject();
        localObject10 = new FinderObjectDesc();
        if (bool2)
        {
          i = 1;
          ((FinderObject)localObject7).objectType = i;
          if (localObject1 == null) {
            break label551;
          }
          l = ((bge)localObject1).refObjectId;
          ((FinderObject)localObject7).refObjectId = l;
          if (localObject1 == null) {
            break label557;
          }
          l = ((bge)localObject1).refObjectFlag;
          ((FinderObject)localObject7).refObjectFlag = l;
          if (localObject1 == null) {
            break label563;
          }
          paramString = ((bge)localObject1).refObjectContact;
          ((FinderObject)localObject7).refObjectContact = paramString;
          ((FinderObject)localObject7).id = 0L;
          ((FinderObject)localObject7).username = z.bdh();
          paramString = h.aHG();
          kotlin.g.b.p.j(paramString, "MMKernel.storage()");
          paramString = paramString.aHp().get(ar.a.VxY, "");
          if (paramString != null) {
            break label568;
          }
          paramString = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(224823);
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
        paramString = aj.AGc;
        ((FinderObject)localObject7).createtime = aj.edX();
        if (localObject3 != null) {}
        Object localObject12;
        for (paramString = com.tencent.mm.plugin.finder.api.c.a((com.tencent.mm.plugin.finder.api.i)localObject3);; paramString = paramg)
        {
          ((FinderObject)localObject7).contact = paramString;
          ((FinderObject)localObject7).mentionedUserContact = new LinkedList();
          paramString = com.tencent.mm.plugin.finder.storage.d.AjH;
          if ((!com.tencent.mm.plugin.finder.storage.d.dTe()) || (paramArrayList == null)) {
            break label920;
          }
          paramString = paramArrayList.iterator();
          while (paramString.hasNext())
          {
            paramg = (cse)paramString.next();
            localObject3 = ((FinderObject)localObject7).mentionedUserContact;
            localObject12 = com.tencent.mm.plugin.finder.utils.e.ACV;
            kotlin.g.b.p.j(paramg, "atContact");
            ((LinkedList)localObject3).add(com.tencent.mm.plugin.finder.utils.e.b(paramg));
          }
          paramg = new FinderContact();
          paramg.username = z.bdh();
          paramString = h.aHG();
          kotlin.g.b.p.j(paramString, "MMKernel.storage()");
          paramString = paramString.aHp().get(ar.a.VxY, "");
          if (paramString == null)
          {
            paramString = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(224823);
            throw paramString;
          }
          paramg.nickname = ((String)paramString);
          paramString = h.aHG();
          kotlin.g.b.p.j(paramString, "MMKernel.storage()");
          paramString = paramString.aHp().get(ar.a.Vya, "");
          if (paramString == null)
          {
            paramString = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(224823);
            throw paramString;
          }
          paramg.headUrl = ((String)paramString);
          if (localObject3 != null)
          {
            localObject3 = ((com.tencent.mm.plugin.finder.api.i)localObject3).field_signature;
            paramString = (String)localObject3;
            if (localObject3 != null) {}
          }
          else
          {
            paramString = "";
          }
          paramg.signature = paramString;
          paramString = h.aHG();
          kotlin.g.b.p.j(paramString, "MMKernel.storage()");
          paramString = paramString.aHp().get(ar.a.Vyg, "");
          if (paramString == null)
          {
            paramString = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(224823);
            throw paramString;
          }
          paramg.coverImgUrl = ((String)paramString);
          paramString = x.aazN;
        }
        paramString = x.aazN;
        label920:
        paramString = aj.AGc;
        if (aj.dOO()) {
          ((FinderObject)localObject7).permissionFlag = 3;
        }
        localObject3 = new bgw();
        label982:
        label1020:
        Object localObject13;
        if (localObject5 != null)
        {
          paramString = ((csf)localObject5).TzP;
          ((FinderObjectDesc)localObject10).imgFeedBgmInfo = paramString;
          localObject12 = new bfs();
          if (localObject5 == null) {
            break label1764;
          }
          paramString = ((csf)localObject5).TzP;
          ((bfs)localObject12).musicInfo = paramString;
          if (localObject5 != null)
          {
            paramg = ((csf)localObject5).AtP;
            paramString = paramg;
            if (paramg != null) {}
          }
          else
          {
            paramString = ((bfs)localObject12).musicInfo;
            if (paramString == null) {
              break label1769;
            }
            paramString = paramString.BHW;
          }
          ((bfs)localObject12).groupId = paramString;
          if (((localObject5 == null) || (((csf)localObject5).Btc)) && ((localObject5 == null) || (((csf)localObject5).Btd))) {
            break label1774;
          }
          i = 1;
          label1055:
          ((bfs)localObject12).SQv = i;
          paramg = ((com.tencent.mm.plugin.finder.upload.g)localObject6).TAG;
          localObject13 = new StringBuilder("FinderObjectBGMInfo, groupId:").append(((bfs)localObject12).groupId).append(", mediaMute:");
          if (localObject5 == null) {
            break label1780;
          }
          paramString = Boolean.valueOf(((csf)localObject5).Btc);
          label1108:
          localObject13 = ((StringBuilder)localObject13).append(paramString).append(", musicMute:");
          if (localObject5 == null) {
            break label1785;
          }
          paramString = Boolean.valueOf(((csf)localObject5).Btd);
          label1136:
          Log.d(paramg, paramString + ", hasBgm:" + ((bfs)localObject12).SQv);
          paramString = (CharSequence)((bfs)localObject12).groupId;
          if ((paramString != null) && (paramString.length() != 0)) {
            break label1790;
          }
          i = 1;
          label1188:
          if ((i == 0) && (((bfs)localObject12).musicInfo == null))
          {
            paramg = new bfg();
            if (localObject5 == null) {
              break label1796;
            }
            paramString = ((csf)localObject5).TzQ;
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
            paramString = ((csf)localObject5).AtN;
            label1257:
            paramString = q.n(paramString, true);
            label1263:
            paramg.SPV = paramString;
            paramString = x.aazN;
            ((bfs)localObject12).musicInfo = paramg;
          }
          paramString = x.aazN;
          ((FinderObjectDesc)localObject10).feedBgmInfo = ((bfs)localObject12);
          if (localObject5 == null) {
            break label2018;
          }
          paramString = ((csf)localObject5).mediaList;
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
            j.iBO();
          }
          localObject13 = (csg)paramString;
          Object localObject14 = new FinderMedia();
          ((FinderMedia)localObject14).url = ((csg)localObject13).url;
          ((FinderMedia)localObject14).mediaType = ((csg)localObject13).mediaType;
          ((FinderMedia)localObject14).thumbUrl = ((csg)localObject13).thumbUrl;
          ((FinderMedia)localObject14).full_thumb_url = ((csg)localObject13).TzX;
          if ((!((csg)localObject13).TzU) && (((csg)localObject13).videoDuration <= 0))
          {
            paramString = com.tencent.mm.plugin.sight.base.f.aYg(((csg)localObject13).url);
            if (paramString != null)
            {
              ((csg)localObject13).videoDuration = paramString.getVideoDuration();
              paramString = x.aazN;
            }
          }
          ((FinderMedia)localObject14).videoDuration = ((csg)localObject13).videoDuration;
          ((FinderMedia)localObject14).width = ((csg)localObject13).width;
          ((FinderMedia)localObject14).height = ((csg)localObject13).height;
          ((FinderMedia)localObject14).md5sum = ((csg)localObject13).md5sum;
          ((FinderMedia)localObject14).coverUrl = ((csg)localObject13).coverUrl;
          ((FinderObjectDesc)localObject10).media.add(localObject14);
          if ((i == 0) && (!Util.isNullOrNil(((csg)localObject13).url)) && ((((csg)localObject13).mediaType == 2) || (((csg)localObject13).mediaType == 4)))
          {
            if (((csg)localObject13).mediaType != 2) {
              break label1831;
            }
            paramString = aj.AGc;
            paramg = ((csg)localObject13).url;
            paramString = paramg;
            if (paramg == null) {
              paramString = "";
            }
          }
          for (paramString = aj.aFK(paramString);; paramString = aj.aFL(((csg)localObject13).url))
          {
            if (paramString != null)
            {
              ((bgw)localObject3).SRy = ((float)((Number)paramString.Mx).doubleValue());
              ((bgw)localObject3).SRx = ((float)((Number)paramString.My).doubleValue());
              paramString = x.aazN;
            }
            if (((FinderMedia)localObject14).mediaType != 2) {
              break label1847;
            }
            paramString = ((com.tencent.mm.plugin.finder.upload.g)localObject6).TAG;
            paramg = new StringBuilder("print mediaList ").append(i).append(' ').append(((csg)localObject13).url).append(" size:").append(Util.getSizeKB(u.bBQ(((csg)localObject13).url))).append(" option ");
            localObject13 = BitmapUtil.getImageOptions(((csg)localObject13).url);
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
              paramString = ((csf)localObject5).TzQ;
              break label1263;
            }
            paramString = null;
            break label1263;
            label1831:
            paramString = aj.AGc;
          }
          label1847:
          if (((FinderMedia)localObject14).mediaType == 4)
          {
            paramString = ((com.tencent.mm.plugin.finder.upload.g)localObject6).TAG;
            paramg = new StringBuilder("print mediaList ").append(i).append(' ').append(((csg)localObject13).url).append(" size:").append(Util.getSizeKB(u.bBQ(((csg)localObject13).url))).append(" option ");
            localObject14 = com.tencent.mm.plugin.gallery.a.d.CeY;
            Log.i(paramString, com.tencent.mm.plugin.gallery.a.d.aFG(((csg)localObject13).url));
            i = j;
          }
          else
          {
            Log.i(((com.tencent.mm.plugin.finder.upload.g)localObject6).TAG, "print mediaList " + i + ' ' + ((csg)localObject13).url + " size:" + Util.getSizeKB(u.bBQ(((csg)localObject13).url)));
            i = j;
          }
        }
        label2014:
        paramString = x.aazN;
        label2018:
        paramString = com.tencent.mm.ui.component.g.Xox;
        paramString = ((com.tencent.mm.plugin.finder.viewmodel.a)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class)).dnl();
        ((bgw)localObject3).longitude = ((Number)paramString.Mx).floatValue();
        ((bgw)localObject3).latitude = ((Number)paramString.My).floatValue();
        paramString = x.aazN;
        if (bool1) {}
        for (int i = 1;; i = 0)
        {
          ((bgw)localObject3).SRz = i;
          ((FinderItem)localObject4).field_postExtraData = ((bgw)localObject3);
          ((FinderObject)localObject7).displayidDiscarded = "";
          ((FinderObject)localObject7).recommendReason = "";
          ((FinderObject)localObject7).secondaryShowFlag = 1;
          ((FinderObject)localObject7).originalFlag = k;
          ((FinderObjectDesc)localObject10).description = ((String)localObject11);
          ((FinderObjectDesc)localObject10).mediaType = m;
          ((FinderObjectDesc)localObject10).location = ((bdm)localObject9);
          ((FinderObjectDesc)localObject10).extReading = ((asl)localObject8);
          localObject3 = new HashMap();
          paramString = com.tencent.mm.plugin.finder.storage.d.AjH;
          if ((!com.tencent.mm.plugin.finder.storage.d.dTe()) || (paramArrayList == null)) {
            break label2305;
          }
          localObject9 = new LinkedList();
          localObject12 = paramArrayList.iterator();
          while (((Iterator)localObject12).hasNext())
          {
            localObject13 = (cse)((Iterator)localObject12).next();
            paramString = new bek();
            paramString.username = ((cse)localObject13).username;
            paramString.source = ((cse)localObject13).type;
            paramString.nickname = ((cse)localObject13).nickname;
            ((LinkedList)localObject9).add(paramString);
            paramg = ((cse)localObject13).nickname;
            paramString = paramg;
            if (paramg == null) {
              paramString = "";
            }
            ((HashMap)localObject3).put(paramString, localObject13);
            paramString = x.aazN;
          }
        }
        ((FinderObjectDesc)localObject10).mentionedUser = ((LinkedList)localObject9);
        paramString = x.aazN;
        label2305:
        paramString = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (!com.tencent.mm.plugin.finder.storage.d.dTd())
        {
          paramString = com.tencent.mm.plugin.finder.storage.d.AjH;
          if (!com.tencent.mm.plugin.finder.storage.d.dTe()) {}
        }
        else
        {
          paramString = new bkp();
          paramg = ad.AFr;
          paramString.SVC = ad.d((String)localObject11, (HashMap)localObject3);
          paramg = x.aazN;
          ((FinderObjectDesc)localObject10).topic = paramString;
        }
        paramString = ((FinderItem)localObject4).field_reportObject;
        label2404:
        float f;
        if (paramString != null)
        {
          paramg = ((FinderObjectDesc)localObject10).description;
          if (paramg == null) {
            break label2720;
          }
          i = paramg.length();
          paramString.descCount = i;
          if (((FinderItem)localObject4).field_reportObject.descCount <= 0) {
            break label2726;
          }
          i = 1;
          paramString.existDesc = i;
          paramg = ((FinderObjectDesc)localObject10).location;
          if (paramg == null) {
            break label2732;
          }
          f = paramg.latitude;
          label2426:
          if (f <= 0.0F) {
            break label2744;
          }
          paramg = ((FinderObjectDesc)localObject10).location;
          if (paramg == null) {
            break label2738;
          }
          f = paramg.longitude;
          label2449:
          if (f <= 0.0F) {
            break label2744;
          }
        }
        label2720:
        label2726:
        label2732:
        label2738:
        label2744:
        for (paramString.existLocation = 1;; paramString.existLocation = 0)
        {
          paramString.link = ((asl)localObject8).link;
          paramString = x.aazN;
          paramString = x.aazN;
          if (!bool3) {
            break label2882;
          }
          localObject3 = new cwc();
          ((cwc)localObject3).description = ((FinderObjectDesc)localObject10).description;
          paramString = ((FinderObjectDesc)localObject10).media;
          if (paramString == null) {
            break label2756;
          }
          localObject8 = ((Iterable)paramString).iterator();
          while (((Iterator)localObject8).hasNext())
          {
            localObject10 = (FinderMedia)((Iterator)localObject8).next();
            localObject9 = new cwq();
            ((cwq)localObject9).url = ((FinderMedia)localObject10).url;
            paramString = com.tencent.mm.plugin.finder.upload.f.AzZ;
            paramg = ((cwq)localObject9).url;
            paramString = paramg;
            if (paramg == null) {
              paramString = "";
            }
            ((cwq)localObject9).thumbUrl = com.tencent.mm.plugin.finder.upload.f.aFj(paramString);
            ((cwq)localObject9).mediaType = 0;
            localObject11 = MultiMediaVideoChecker.NmA;
            paramg = ((cwq)localObject9).url;
            paramString = paramg;
            if (paramg == null) {
              paramString = "";
            }
            paramString = ((MultiMediaVideoChecker)localObject11).bfs(paramString);
            if (paramString != null)
            {
              ((cwq)localObject9).width = paramString.width;
              ((cwq)localObject9).height = paramString.height;
              ((cwq)localObject9).TFq = kotlin.h.a.dm((float)paramString.duration / 1000.0F);
              paramString = x.aazN;
            }
            ((cwq)localObject9).md5sum = ((FinderMedia)localObject10).md5sum;
            ((cwq)localObject9).fileSize = ((FinderMedia)localObject10).fileSize;
            ((cwq)localObject9).bitrate = ((FinderMedia)localObject10).bitrate;
            paramString = x.aazN;
            ((cwc)localObject3).media.add(localObject9);
          }
          i = 0;
          break;
          i = 0;
          break label2404;
          f = 0.0F;
          break label2426;
          f = 0.0F;
          break label2449;
        }
        paramString = x.aazN;
        label2756:
        paramg = new cvy();
        paramg.id = 0L;
        paramg.createTime = ((FinderObject)localObject7).createtime;
        paramg.TEM = ((cwc)localObject3);
        paramString = x.aazN;
        paramString = new apx();
        paramString.SDm = new LinkedList();
        localObject3 = paramString.SDm;
        localObject8 = new apw();
        ((apw)localObject8).type = 1;
        localObject9 = new blj();
        ((blj)localObject9).id = 0L;
        ((blj)localObject9).SPm = paramg;
        paramg = x.aazN;
        ((apw)localObject8).SDl = ((blj)localObject9);
        paramg = x.aazN;
        ((LinkedList)localObject3).add(localObject8);
        paramg = x.aazN;
        ((FinderObject)localObject7).attachmentList = paramString;
        label2882:
        Log.i(((com.tencent.mm.plugin.finder.upload.g)localObject6).TAG, "finder send post " + com.tencent.mm.ae.g.bN(localObject7));
        ((FinderItem)localObject4).updateFinderObject((FinderObject)localObject7);
        paramString = com.tencent.mm.plugin.finder.upload.i.AAy;
        paramString = com.tencent.mm.plugin.finder.upload.i.ecp();
        paramString.TAj = cm.bfC();
        if (paramArrayList != null)
        {
          paramString.TAm.clear();
          paramString.TAm.addAll((Collection)paramArrayList);
        }
        paramg = x.aazN;
        ((FinderItem)localObject4).setPostInfo(paramString);
        if (localObject5 != null)
        {
          paramg = ((csf)localObject5).mediaList;
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
          paramString = paramString.SDm;
          if (paramString != null)
          {
            paramString = (apw)j.lp((List)paramString);
            if (paramString != null)
            {
              paramString = paramString.SDl;
              if (paramString != null)
              {
                paramString = paramString.SPm;
                if (paramString != null)
                {
                  paramString = paramString.TEM;
                  if (paramString != null)
                  {
                    paramString = paramString.media;
                    if (paramString != null)
                    {
                      paramString = com.tencent.mm.plugin.finder.storage.data.i.aS(paramString);
                      ((FinderItem)localObject4).setLongVideoMediaExtList(paramString);
                      paramArrayList = ((Iterable)((FinderItem)localObject4).getLongVideoMediaExtList()).iterator();
                      label3092:
                      if (!paramArrayList.hasNext()) {
                        break label3902;
                      }
                      localObject3 = (csg)paramArrayList.next();
                      ((csg)localObject3).mediaId = ("longvideo_" + ((csg)localObject3).mediaId);
                      ((csg)localObject3).TzU = true;
                      localObject5 = new css();
                      paramString = com.tencent.mm.plugin.finder.ui.config.a.AxF;
                      localObject6 = com.tencent.mm.plugin.finder.ui.config.a.ebF();
                      i = (int)((csg)localObject3).width;
                      j = (int)((csg)localObject3).height;
                      k = SightVideoJNI.getMp4RotateVFS(((csg)localObject3).url);
                      if ((k == 90) || (k == 270))
                      {
                        i = (int)((csg)localObject3).height;
                        j = (int)((csg)localObject3).width;
                      }
                      paramString = MMApplicationContext.getContext();
                      kotlin.g.b.p.j(paramString, "MMApplicationContext.getContext()");
                      paramString = paramString.getResources();
                      kotlin.g.b.p.j(paramString, "MMApplicationContext.getContext().resources");
                      k = paramString.getDisplayMetrics().widthPixels;
                      f = i / j;
                      if ((f < 0.5625F) || (f > 1.777778F)) {
                        break label3605;
                      }
                      paramString = new fbq();
                      paramString.left = 0;
                      paramString.top = j;
                      paramString.right = i;
                      paramString.bottom = 0;
                      paramg = x.aazN;
                      ((css)localObject5).TAv = paramString;
                      ((css)localObject5).TAx = paramString;
                      paramg = j.listOf(new Float[] { Float.valueOf(1.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(1.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(1.0F) });
                      paramString = new blk();
                      paramString.SWx.addAll((Collection)j.p((Iterable)paramg));
                      paramg = x.aazN;
                      ((css)localObject5).TAw = paramString;
                    }
                  }
                }
              }
            }
          }
        }
        for (;;)
        {
          ((css)localObject5).fod = 0;
          localObject7 = MultiMediaVideoChecker.NmA;
          paramg = ((csg)localObject3).url;
          paramString = paramg;
          if (paramg == null) {
            paramString = "";
          }
          paramString = ((MultiMediaVideoChecker)localObject7).bfs(paramString);
          if (paramString != null)
          {
            ((css)localObject5).endTime = Math.min(((VideoTransPara)localObject6).duration * 1000, (int)paramString.duration);
            paramString = x.aazN;
          }
          paramString = com.tencent.mm.plugin.finder.upload.g.aj(i, j, Math.min(((VideoTransPara)localObject6).width, ((VideoTransPara)localObject6).height));
          i = ((Number)paramString.Mx).intValue();
          j = ((Number)paramString.My).intValue();
          ((css)localObject5).width = i;
          ((css)localObject5).height = j;
          ((csg)localObject3).width = i;
          ((csg)localObject3).height = j;
          ((css)localObject5).retryCount = 0;
          paramString = x.aazN;
          ((csg)localObject3).zBo = ((css)localObject5);
          break label3092;
          paramString = new LinkedList();
          break;
          label3605:
          if (f > 1.777778F)
          {
            k = (int)(j * 16.0F / 9.0F);
            paramg = new fbq();
            paramg.left = ((i - k) / 2);
            paramg.top = j;
            paramg.right = (i - paramg.left);
            paramg.bottom = 0;
            paramString = x.aazN;
            ((css)localObject5).TAv = paramg;
            ((css)localObject5).TAx = paramg;
            paramString = new Matrix();
            paramString.postTranslate(-paramg.left, 0.0F);
            paramg = new blk();
            localObject7 = new float[9];
            paramString.getValues((float[])localObject7);
            paramg.SWx.addAll((Collection)kotlin.a.e.t((float[])localObject7));
            paramString = x.aazN;
            ((css)localObject5).TAw = paramg;
            i = k;
          }
          else
          {
            k = (int)(i * 16.0F / 9.0F);
            paramg = new fbq();
            paramg.left = 0;
            paramg.bottom = ((j - k) / 2);
            paramg.right = i;
            paramg.top = (j - paramg.bottom);
            paramString = x.aazN;
            ((css)localObject5).TAv = paramg;
            ((css)localObject5).TAx = paramg;
            paramString = new Matrix();
            paramString.postTranslate(0.0F, -paramg.bottom);
            paramg = new blk();
            localObject7 = new float[9];
            paramString.getValues((float[])localObject7);
            paramg.SWx.addAll((Collection)kotlin.a.e.t((float[])localObject7));
            paramString = x.aazN;
            ((css)localObject5).TAw = paramg;
            j = k;
          }
        }
        label3902:
        if (localObject2 != null)
        {
          paramString = ((FinderItem)localObject4).getPostInfo();
          paramString.TAg = 1;
          paramg = x.aazN;
          ((FinderItem)localObject4).setPostInfo(paramString);
        }
        ((FinderItem)localObject4).setPostWaiting();
        ((FinderItem)localObject4).setLocalId(System.currentTimeMillis());
        AppMethodBeat.o(224823);
        return localObject4;
      }
    }
  }
  
  public final com.tencent.mm.plugin.finder.upload.p a(g paramg, String paramString, ArrayList<cse> paramArrayList, com.tencent.mm.plugin.finder.live.ui.post.e parame, bfv parambfv)
  {
    AppMethodBeat.i(224774);
    bdm localbdm = new bdm();
    asl localasl = new asl();
    Object localObject3 = null;
    Object localObject1 = this.ACv;
    Object localObject4 = a.BsS;
    localObject1 = ((Bundle)localObject1).getByteArray(a.emq());
    if (localObject1 != null) {
      localbdm.parseFrom((byte[])localObject1);
    }
    localObject1 = this.ACv;
    localObject4 = a.BsS;
    localObject1 = ((Bundle)localObject1).getByteArray(a.emr());
    if (localObject1 != null) {
      localasl.parseFrom((byte[])localObject1);
    }
    localObject1 = this.ACv;
    localObject4 = a.BsS;
    int j = ((Bundle)localObject1).getInt(a.emv(), 0);
    localObject1 = this.ACv;
    localObject4 = a.BsS;
    boolean bool1 = ((Bundle)localObject1).getBoolean(a.emu(), false);
    localObject1 = this.ACv;
    localObject4 = a.BsS;
    localObject4 = ((Bundle)localObject1).getByteArray(a.ems());
    localObject1 = this.ACv;
    Object localObject5 = a.BsS;
    localObject5 = ((Bundle)localObject1).getByteArray(a.emt());
    localObject1 = localObject3;
    if (localObject4 != null)
    {
      localObject1 = localObject3;
      if (localObject5 != null) {
        localObject1 = (com.tencent.mm.cd.a)new bge();
      }
    }
    try
    {
      ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject4);
      localObject1 = (bge)localObject1;
      boolean bool2 = this.ACv.getBoolean("isNews");
      localObject5 = new ati();
      if (parame != null)
      {
        localObject4 = parame.yPv;
        localObject3 = localObject4;
        if (localObject4 != null) {}
      }
      else
      {
        localObject3 = "";
      }
      ((ati)localObject5).appid = ((String)localObject3);
      if (parame != null)
      {
        localObject4 = parame.yPw;
        localObject3 = localObject4;
        if (localObject4 != null) {}
      }
      else
      {
        localObject3 = "";
      }
      ((ati)localObject5).MFj = ((String)localObject3);
      int k = paramg.type;
      localObject4 = Util.nullAsNil(paramString);
      kotlin.g.b.p.j(localObject4, "Util.nullAsNil(desc)");
      csf localcsf = paramg.Bul;
      String str = paramg.ABe;
      boolean bool3 = this.isLongVideo;
      if (parame != null)
      {
        paramString = parame.xaL;
        paramg = paramString;
        if (paramString != null) {}
      }
      else
      {
        paramg = "";
      }
      if (parame != null)
      {
        localObject3 = parame.xaM;
        paramString = (String)localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        paramString = "";
      }
      if (parame != null) {
        if (Util.isNullOrNil(parame.dEn()))
        {
          i = 0;
          paramg = new com.tencent.mm.plugin.finder.upload.p(k, (String)localObject4, localcsf, localbdm, localasl, j, (bge)localObject1, bool1, str, paramArrayList, bool3, bool2, (ati)localObject5, paramg, paramString, i, parambfv);
          Log.i(this.TAG, "doPost, mediaType:" + paramg.mediaType + ", isLongVideo:" + paramg.isLongVideo + ", sdkShareType:" + paramg.sdkShareType);
          AppMethodBeat.o(224774);
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
        if (Util.isNullOrNil(parame.xaL))
        {
          i = com.tencent.mm.plugin.finder.live.ui.post.e.yPx;
        }
        else
        {
          i = com.tencent.mm.plugin.finder.live.ui.post.e.yPy;
          continue;
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.c
 * JD-Core Version:    0.7.0.1
 */