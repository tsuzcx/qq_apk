package com.tencent.mm.plugin.finder.widget.post;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.activity.b;
import com.tencent.mm.plugin.finder.post.i;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.ayb;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bqz;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.brq;
import com.tencent.mm.protocal.protobuf.brx;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.djg;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "TAG", "", "compositionInfo", "", "getCompositionInfo", "()[B", "setCompositionInfo", "([B)V", "draftExtendedReading", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "getDraftExtendedReading", "()Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "setDraftExtendedReading", "(Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;)V", "draftFeedBgmInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectBGMInfo;", "getDraftFeedBgmInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectBGMInfo;", "setDraftFeedBgmInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectBGMInfo;)V", "draftFinderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getDraftFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setDraftFinderItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "draftImgFeedBgmInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getDraftImgFeedBgmInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setDraftImgFeedBgmInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "draftLocalId", "", "getDraftLocalId", "()J", "setDraftLocalId", "(J)V", "draftLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getDraftLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setDraftLocation", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "draftMediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getDraftMediaList", "()Ljava/util/LinkedList;", "setDraftMediaList", "(Ljava/util/LinkedList;)V", "draftMentionList", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getDraftMentionList", "setDraftMentionList", "draftSvrId", "getDraftSvrId", "setDraftSvrId", "editId", "getEditId", "()Ljava/lang/String;", "setEditId", "(Ljava/lang/String;)V", "extraMusic", "getExtraMusic", "setExtraMusic", "fromCamera", "", "getFromCamera", "()Z", "setFromCamera", "(Z)V", "geoDegree", "Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "getGeoDegree", "()Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "setGeoDegree", "(Lcom/tencent/mm/plugin/finder/utils/GeoDegree;)V", "halfImageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getHalfImageList", "()Ljava/util/ArrayList;", "setHalfImageList", "(Ljava/util/ArrayList;)V", "halfRectList", "Landroid/graphics/Rect;", "getHalfRectList", "setHalfRectList", "imageQualityList", "", "getImageQualityList", "setImageQualityList", "getIntent", "()Landroid/content/Intent;", "isLongVideo", "setLongVideo", "jumpInfo", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "getJumpInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "setJumpInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;)V", "mediaCount", "getMediaCount", "()I", "setMediaCount", "(I)V", "mediaList", "getMediaList", "setMediaList", "mediaMute", "getMediaMute", "setMediaMute", "musicFeedId", "getMusicFeedId", "setMusicFeedId", "musicMute", "getMusicMute", "setMusicMute", "oldVersionDraft", "getOldVersionDraft", "setOldVersionDraft", "optionalInfo", "Lcom/tencent/mm/protocal/protobuf/FinderOptionalInfo;", "getOptionalInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderOptionalInfo;", "setOptionalInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderOptionalInfo;)V", "originBgmUrl", "getOriginBgmUrl", "setOriginBgmUrl", "originMusicId", "getOriginMusicId", "setOriginMusicId", "originMusicInfo", "getOriginMusicInfo", "setOriginMusicInfo", "originMusicPath", "getOriginMusicPath", "setOriginMusicPath", "postData", "Landroid/os/Bundle;", "getPostData", "()Landroid/os/Bundle;", "postId", "getPostId", "setPostId", "postType", "getPostType", "()Ljava/lang/Integer;", "setPostType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRefFeed", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeed", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "refFeedContent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "getRefFeedContent", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "setRefFeedContent", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;)V", "reportInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGeneralReportInfo;", "getReportInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderGeneralReportInfo;", "setReportInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderGeneralReportInfo;)V", "soundTrackType", "getSoundTrackType", "setSoundTrackType", "thumbList", "getThumbList", "setThumbList", "typeList", "getTypeList", "setTypeList", "videoCropInfoList", "Landroid/os/Parcelable;", "getVideoCropInfoList", "setVideoCropInfoList", "videoTemplate", "Lcom/tencent/mm/protocal/protobuf/FinderVideoTemplateInfo;", "getVideoTemplate", "()Lcom/tencent/mm/protocal/protobuf/FinderVideoTemplateInfo;", "setVideoTemplate", "(Lcom/tencent/mm/protocal/protobuf/FinderVideoTemplateInfo;)V", "vlogCropRect", "getVlogCropRect", "()Landroid/graphics/Rect;", "setVlogCropRect", "(Landroid/graphics/Rect;)V", "checkListSize", "", "T", "list", "maxSize", "delMedia", "doPost", "context", "Landroid/app/Activity;", "desc", "uploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "atContactList", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "activityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "jumpInfoList", "fromDraft", "genHoldingPostData", "Lcom/tencent/mm/plugin/finder/upload/HoldingPostData;", "sdkShareUIC", "Lcom/tencent/mm/plugin/finder/post/SdkShareUIC;", "generateDraft", "forPreview", "activityEventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "generateFeed", "initFromDraft", "initLongVideoCropInfo", "setupPostDataForMediaWidget", "updatePostVideoCoverUrl", "fullCoverUrl", "coverUrl", "coverQuality", "cropInfo", "Lcom/tencent/mm/plugin/finder/video/LocalVideoCropInfoParcelable;", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final a GZG;
  public String FSU;
  public String FSW;
  public byte[] FSX;
  public String FSY;
  public brq GZC;
  public Integer GZH;
  public ArrayList<Integer> GZI;
  public byte[] GZJ;
  public ArrayList<Parcelable> GZK;
  public ArrayList<String> GZL;
  public ArrayList<Integer> GZM;
  public FinderObjectDesc GZN;
  public Rect GZO;
  public byte[] GZP;
  public boolean GZQ;
  public boolean GZR;
  public long GZS;
  private long GZT;
  public boolean GZU;
  public brx GZV;
  public ArrayList<String> GZW;
  public ArrayList<Rect> GZX;
  public byy GZY;
  public LinkedList<dji> GZZ;
  private ayb GcA;
  public FinderItem Gcx;
  public final Bundle Gfy;
  public bqj Haa;
  public bqz Hab;
  public LinkedList<FinderContact> Hac;
  private boi Had;
  private axa Hae;
  public final String TAG;
  public String editId;
  private int hGP;
  public FinderJumpInfo hVf;
  public final Intent intent;
  public boolean isLongVideo;
  public String musicFeedId;
  public ArrayList<String> ofu;
  private String postId;
  public boolean sft;
  public int soundTrackType;
  
  static
  {
    AppMethodBeat.i(330828);
    GZG = new a((byte)0);
    AppMethodBeat.o(330828);
  }
  
  public c(Intent paramIntent)
  {
    AppMethodBeat.i(330798);
    this.intent = paramIntent;
    this.TAG = "Finder.PostDataManager";
    this.Gfy = new Bundle();
    this.postId = "";
    this.editId = "";
    this.GZS = this.intent.getLongExtra("KEY_FINDER_POST_DRAFT_LOCAL_ID", 0L);
    this.GZT = this.intent.getLongExtra("KEY_FINDER_POST_DRAFT_SVR_ID", 0L);
    paramIntent = (com.tencent.mm.bx.a)new bby();
    Object localObject = this.intent.getByteArrayExtra("KEY_POST_DRAFT_FINDER_ITEM");
    try
    {
      paramIntent.parseFrom((byte[])localObject);
      paramIntent = (bby)paramIntent;
      if (paramIntent == null)
      {
        paramIntent = null;
        this.Gcx = paramIntent;
        this.GZU = this.intent.getBooleanExtra("KEY_FINDER_POST_DRAFT_FROM_OLD_VERSION", false);
        localObject = this.Gcx;
        if (localObject != null)
        {
          this.GZZ = ((FinderItem)localObject).getMediaList();
          paramIntent = ((FinderItem)localObject).getFeedObject().objectDesc;
          if (paramIntent != null) {
            break label1144;
          }
          paramIntent = null;
          this.Haa = paramIntent;
          paramIntent = ((FinderItem)localObject).getFeedObject().objectDesc;
          if (paramIntent != null) {
            break label1152;
          }
          paramIntent = null;
          this.Hab = paramIntent;
          this.Hac = ((FinderItem)localObject).getFeedObject().mentionedUserContact;
          paramIntent = ((FinderItem)localObject).getFeedObject().objectDesc;
          if (paramIntent != null) {
            break label1160;
          }
          paramIntent = null;
          this.Had = paramIntent;
          paramIntent = ((FinderItem)localObject).getFeedObject().objectDesc;
          if (paramIntent != null) {
            break label1168;
          }
          paramIntent = null;
          this.Hae = paramIntent;
          this.hVf = ((FinderItem)localObject).getFirstJumpInfo();
          paramIntent = ((FinderItem)localObject).getFeedObject().objectDesc;
          if (paramIntent != null) {
            break label1176;
          }
          paramIntent = null;
          this.GcA = paramIntent;
        }
        this.GZH = Integer.valueOf(this.intent.getIntExtra("postType", -1));
        paramIntent = this.intent.getStringArrayListExtra("postMediaList");
        if (paramIntent != null) {
          break label1184;
        }
        paramIntent = null;
        this.ofu = paramIntent;
        paramIntent = this.intent.getIntegerArrayListExtra("key_post_media_quality_list");
        if (paramIntent != null) {
          break label1197;
        }
        paramIntent = null;
        this.GZI = paramIntent;
        this.GZJ = this.intent.getByteArrayExtra("video_composition");
        paramIntent = this.ofu;
        if (paramIntent != null) {
          break label1210;
        }
        i = 0;
        this.hGP = i;
        paramIntent = this.GZH;
        if (paramIntent != null) {
          break label1218;
        }
        this.sft = this.intent.getBooleanExtra("KEY_POST_FROM_CAMERA", false);
        paramIntent = this.intent.getParcelableArrayListExtra("postVideoCropList");
        if (paramIntent != null) {
          break label1265;
        }
        paramIntent = null;
        this.GZK = paramIntent;
        paramIntent = this.intent.getStringArrayListExtra("postThumbList");
        if (paramIntent != null) {
          break label1278;
        }
        paramIntent = null;
        this.GZL = paramIntent;
        this.GZO = ((Rect)this.intent.getParcelableExtra("KEY_POST_VLOG_CROP_RECT"));
        this.GZP = this.intent.getByteArrayExtra("MEDIA_EXTRA_MUSIC");
        this.FSW = this.intent.getStringExtra("ORIGIN_MUSIC_ID");
        this.FSX = this.intent.getByteArrayExtra("ORIGIN_MUSIC_INFO");
        this.FSU = this.intent.getStringExtra("ORIGIN_MUSIC_PATH");
        this.FSY = this.intent.getStringExtra("ORIGIN_BGM_URL");
        this.GZQ = this.intent.getBooleanExtra("MEDIA_IS_MUTE", this.GZQ);
        this.GZR = this.intent.getBooleanExtra("MUSIC_IS_MUTE", this.GZR);
        this.soundTrackType = this.intent.getIntExtra("SOUND_TRACK_TYPE", 0);
        this.musicFeedId = this.intent.getStringExtra("MUSIC_FEED_ID");
        localObject = this.intent.getStringExtra("post_id");
        paramIntent = (Intent)localObject;
        if (localObject == null) {
          paramIntent = this.postId;
        }
        this.postId = paramIntent;
        localObject = this.intent.getStringExtra("edit_id");
        paramIntent = (Intent)localObject;
        if (localObject == null) {
          paramIntent = this.editId;
        }
        this.editId = paramIntent;
        localObject = this.intent.getStringExtra("REPORT_INFO");
        if (localObject != null) {
          break label1291;
        }
        paramIntent = null;
        localObject = paramIntent;
        if (paramIntent == null) {
          localObject = this.GcA;
        }
        this.GcA = ((ayb)localObject);
        if (((CharSequence)this.postId).length() <= 0) {
          break label1308;
        }
        i = 1;
        if (i != 0)
        {
          paramIntent = v.FrN;
          v.ib(this.postId, this.editId);
        }
        this.isLongVideo = this.intent.getBooleanExtra("isLongVideoPost", false);
        paramIntent = this.intent.getStringArrayListExtra("KEY_POST_HALF_IMAGE_LIST");
        if (paramIntent != null) {
          break label1313;
        }
        paramIntent = null;
        this.GZW = paramIntent;
        paramIntent = this.intent.getParcelableArrayListExtra("KEY_POST_HALF_RECT_LIST");
        if (paramIntent != null) {
          break label1326;
        }
        paramIntent = null;
        this.GZX = paramIntent;
        if (this.hVf == null)
        {
          paramIntent = (com.tencent.mm.bx.a)new FinderJumpInfo();
          localObject = this.intent.getByteArrayExtra("JUMP_INFO");
        }
      }
    }
    catch (Exception paramIntent)
    {
      try
      {
        paramIntent.parseFrom((byte[])localObject);
        localObject = (FinderJumpInfo)paramIntent;
        paramIntent = (Intent)localObject;
        if (localObject == null)
        {
          paramIntent = com.tencent.mm.plugin.finder.activity.a.Atw;
          paramIntent = com.tencent.mm.plugin.finder.activity.a.dTp();
          if (paramIntent == null)
          {
            paramIntent = null;
            if (!(paramIntent instanceof List)) {
              break label1373;
            }
            paramIntent = (List)paramIntent;
            if (paramIntent != null) {
              break label1378;
            }
            paramIntent = null;
            if (paramIntent != null) {
              break label1391;
            }
            paramIntent = null;
          }
        }
        else
        {
          this.hVf = paramIntent;
          if (this.GZV == null)
          {
            paramIntent = (com.tencent.mm.bx.a)new brx();
            localObject = this.intent.getByteArrayExtra("OPTIONAL_INFO");
          }
        }
      }
      catch (Exception paramIntent)
      {
        try
        {
          paramIntent.parseFrom((byte[])localObject);
          localObject = (brx)paramIntent;
          paramIntent = (Intent)localObject;
          if (localObject == null) {
            paramIntent = new brx();
          }
          this.GZV = paramIntent;
          paramIntent = (com.tencent.mm.bx.a)new byy();
          localObject = this.intent.getByteArrayExtra("KEY_POST_VIDEO_TEMPLATE");
        }
        catch (Exception paramIntent)
        {
          try
          {
            label1152:
            label1160:
            label1168:
            label1176:
            label1184:
            label1197:
            label1326:
            for (;;)
            {
              paramIntent.parseFrom((byte[])localObject);
              this.GZY = ((byy)paramIntent);
              paramIntent = this.TAG;
              localObject = new StringBuilder("postType ").append(this.GZH).append(", mediaList ").append(this.ofu).append(" mediaCount ").append(this.hGP).append(" thumbList ").append(this.GZL).append(" thumbCount ");
              localArrayList = this.GZL;
              if (localArrayList != null) {
                break;
              }
              i = j;
              Log.i(paramIntent, i + ", fromCamera:" + this.sft);
              AppMethodBeat.o(330798);
              return;
              paramIntent = paramIntent;
              Log.printDebugStack("safeParser", "", new Object[] { paramIntent });
              paramIntent = null;
              continue;
              localObject = FinderItem.Companion;
              paramIntent = FinderItem.a.a(paramIntent, this.GZS);
              continue;
              label1144:
              paramIntent = paramIntent.imgFeedBgmInfo;
              continue;
              paramIntent = paramIntent.feedBgmInfo;
              continue;
              paramIntent = paramIntent.location;
              continue;
              paramIntent = paramIntent.extReading;
              continue;
              paramIntent = paramIntent.generalReportInfo;
              continue;
              a(this, paramIntent);
              localObject = ah.aiuX;
              continue;
              a(this, paramIntent);
              localObject = ah.aiuX;
              continue;
              label1210:
              i = paramIntent.size();
              continue;
              label1218:
              if (paramIntent.intValue() == 8)
              {
                paramIntent = this.intent.getIntegerArrayListExtra("postTypeList");
                if (paramIntent == null) {
                  paramIntent = null;
                }
                for (;;)
                {
                  this.GZM = paramIntent;
                  break;
                  a(this, paramIntent);
                  localObject = ah.aiuX;
                }
                label1265:
                a(this, paramIntent);
                localObject = ah.aiuX;
                continue;
                label1278:
                a(this, paramIntent);
                localObject = ah.aiuX;
                continue;
                paramIntent = new ayb();
                paramIntent.hZn = ((String)localObject);
                continue;
                i = 0;
                continue;
                a(this, paramIntent);
                localObject = ah.aiuX;
                continue;
                a(this, paramIntent);
                localObject = ah.aiuX;
                continue;
                paramIntent = paramIntent;
                Log.printDebugStack("safeParser", "", new Object[] { paramIntent });
                paramIntent = null;
                continue;
                paramIntent = paramIntent.getSerializableExtra("key_activity_jump_info_list");
                continue;
                label1373:
                paramIntent = null;
                continue;
                label1378:
                localObject = b.Aty;
                paramIntent = b.fR(paramIntent);
                continue;
                label1391:
                paramIntent = (FinderJumpInfo)kotlin.a.p.oL(paramIntent);
              }
            }
            label1291:
            label1308:
            label1313:
            paramIntent = paramIntent;
            Log.printDebugStack("safeParser", "", new Object[] { paramIntent });
            paramIntent = null;
          }
          catch (Exception paramIntent)
          {
            for (;;)
            {
              ArrayList localArrayList;
              Log.printDebugStack("safeParser", "", new Object[] { paramIntent });
              paramIntent = null;
              continue;
              int i = localArrayList.size();
            }
          }
        }
      }
    }
  }
  
  private final <T> void aG(ArrayList<T> paramArrayList)
  {
    AppMethodBeat.i(330807);
    if (paramArrayList.size() == 0)
    {
      AppMethodBeat.o(330807);
      return;
    }
    if (paramArrayList.size() > 9)
    {
      Log.i(this.TAG, "checkListSize: list size = " + paramArrayList.size() + ", maxSize = 9");
      while (paramArrayList.size() > 9) {
        if (kotlin.a.p.oH((List)paramArrayList) == null)
        {
          AppMethodBeat.o(330807);
          return;
        }
      }
    }
    AppMethodBeat.o(330807);
  }
  
  public final FinderItem a(Activity paramActivity, String paramString, h paramh, boolean paramBoolean, ArrayList<djg> paramArrayList, brg parambrg, awt paramawt, LinkedList<FinderJumpInfo> paramLinkedList)
  {
    AppMethodBeat.i(330846);
    s.u(paramActivity, "context");
    s.u(paramString, "desc");
    s.u(paramh, "uploadData");
    s.u(paramLinkedList, "jumpInfoList");
    k localk = k.aeZF;
    paramActivity = a(paramh, paramString, paramArrayList, (i)k.nq((Context)paramActivity).q(i.class), parambrg, paramLinkedList);
    paramActivity.GcB = paramawt;
    paramString = com.tencent.mm.plugin.finder.upload.postlogic.a.GdF;
    paramActivity = com.tencent.mm.plugin.finder.upload.postlogic.a.a(paramActivity, paramBoolean);
    AppMethodBeat.o(330846);
    return paramActivity;
  }
  
  public final com.tencent.mm.plugin.finder.upload.p a(h paramh, String paramString, ArrayList<djg> paramArrayList, i parami, brg parambrg, LinkedList<FinderJumpInfo> paramLinkedList)
  {
    AppMethodBeat.i(330838);
    boi localboi = new boi();
    axa localaxa = new axa();
    Object localObject1 = this.Gfy.getByteArray("post_location");
    if (localObject1 != null) {
      localboi.parseFrom((byte[])localObject1);
    }
    localObject1 = this.Gfy.getByteArray("post_extend_reading");
    if (localObject1 != null) {
      localaxa.parseFrom((byte[])localObject1);
    }
    int j = this.Gfy.getInt("POST_ORIGINAL_FLAG", 0);
    boolean bool1 = this.Gfy.getBoolean("post_from_camera", false);
    localObject1 = this.Gfy.getByteArray("post_ref_feed_info");
    Object localObject3 = this.Gfy.getByteArray("post_ref_feed_content");
    if ((localObject1 != null) && (localObject3 != null)) {
      localObject3 = (com.tencent.mm.bx.a)new brq();
    }
    try
    {
      ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
      localObject3 = this.Gfy.getByteArray("KEY_POST_VIDEO_TEMPLATE");
      if (localObject3 == null)
      {
        localObject3 = null;
        boolean bool2 = this.Gfy.getBoolean("isNews");
        axw localaxw = new axw();
        if (parami != null) {
          break label497;
        }
        localObject1 = "";
        localaxw.appid = ((String)localObject1);
        if (parami != null) {
          break label521;
        }
        localObject1 = "";
        localaxw.ext_info = ((String)localObject1);
        if (parami != null) {
          break label545;
        }
        i = 0;
        localaxw.source = i;
        int k = paramh.type;
        str1 = Util.nullAsNil(paramString);
        s.s(str1, "nullAsNil(desc)");
        djh localdjh = paramh.HaW;
        String str2 = paramh.Gcs;
        boolean bool3 = this.isLongVideo;
        if (parami != null) {
          break label555;
        }
        paramh = "";
        if (parami != null) {
          break label574;
        }
        paramString = "";
        if (parami != null) {
          break label596;
        }
        i = 0;
        paramh = new com.tencent.mm.plugin.finder.upload.p(k, str1, localdjh, localboi, localaxa, j, bool1, str2, paramArrayList, bool3, bool2, localaxw, paramh, paramString, i, parambrg, this.Gcx, paramLinkedList, (byy)localObject3, this.GcA);
        Log.i(this.TAG, "doPost, mediaType:" + paramh.mediaType + ", isLongVideo:" + paramh.isLongVideo + ", sdkShareType:" + paramh.sdkShareType);
        AppMethodBeat.o(330838);
        return paramh;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        int i;
        Log.printDebugStack("safeParser", "", new Object[] { localException1 });
        continue;
        com.tencent.mm.bx.a locala = (com.tencent.mm.bx.a)new byy();
        try
        {
          locala.parseFrom((byte[])localObject3);
          localObject3 = (byy)locala;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { localException2 });
            localObject2 = null;
          }
        }
        label497:
        String str1 = parami.EUn;
        Object localObject2 = str1;
        if (str1 == null)
        {
          localObject2 = "";
          continue;
          label521:
          str1 = parami.extInfo;
          localObject2 = str1;
          if (str1 == null)
          {
            localObject2 = "";
            continue;
            label545:
            i = parami.source;
            continue;
            label555:
            paramString = parami.AyS;
            paramh = paramString;
            if (paramString == null)
            {
              paramh = "";
              continue;
              label574:
              localObject2 = parami.AyT;
              paramString = (String)localObject2;
              if (localObject2 == null)
              {
                paramString = "";
                continue;
                label596:
                if (Util.isNullOrNil(parami.eHB())) {
                  i = 0;
                } else if (Util.isNullOrNil(parami.AyS)) {
                  i = i.EUq;
                } else {
                  i = i.EUr;
                }
              }
            }
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager$Companion;", "", "()V", "MAX_MEDIA_COUNT", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.c
 * JD-Core Version:    0.7.0.1
 */