package com.tencent.mm.plugin.finder.widget.post;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.amz;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.bvx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "TAG", "", "compositionInfo", "", "getCompositionInfo", "()[B", "setCompositionInfo", "([B)V", "fromCamera", "", "getFromCamera", "()Z", "setFromCamera", "(Z)V", "geoDegree", "Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "getGeoDegree", "()Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "setGeoDegree", "(Lcom/tencent/mm/plugin/finder/utils/GeoDegree;)V", "imageQualityList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getImageQualityList", "()Ljava/util/ArrayList;", "setImageQualityList", "(Ljava/util/ArrayList;)V", "getIntent", "()Landroid/content/Intent;", "mediaCount", "getMediaCount", "()I", "setMediaCount", "(I)V", "mediaList", "getMediaList", "setMediaList", "postData", "Landroid/os/Bundle;", "getPostData", "()Landroid/os/Bundle;", "postType", "getPostType", "()Ljava/lang/Integer;", "setPostType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRefFeed", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeed", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "refFeedContent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "getRefFeedContent", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "setRefFeedContent", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;)V", "thumbList", "getThumbList", "setThumbList", "typeList", "getTypeList", "setTypeList", "videoCropInfoList", "Landroid/os/Parcelable;", "getVideoCropInfoList", "setVideoCropInfoList", "vlogCropRect", "Landroid/graphics/Rect;", "getVlogCropRect", "()Landroid/graphics/Rect;", "setVlogCropRect", "(Landroid/graphics/Rect;)V", "doPost", "", "desc", "uploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "atContactList", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "setupPostDataForMediaWidget", "", "updatePostVideoCoverUrl", "coverUrl", "coverQuality", "plugin-finder_release"})
public final class c
{
  private final String TAG;
  private int drZ;
  public final Intent intent;
  public boolean kWX;
  public final Bundle sVF;
  public FinderObjectDesc tpA;
  public Rect tpB;
  public aqq tpk;
  public Integer tpt;
  public ArrayList<String> tpu;
  public ArrayList<Integer> tpv;
  public byte[] tpw;
  public ArrayList<Parcelable> tpx;
  public ArrayList<String> tpy;
  public ArrayList<Integer> tpz;
  
  public c(Intent paramIntent)
  {
    AppMethodBeat.i(206417);
    this.intent = paramIntent;
    this.TAG = "Finder.PostDataManager";
    this.sVF = new Bundle();
    this.tpt = Integer.valueOf(this.intent.getIntExtra("postType", 2));
    this.tpu = this.intent.getStringArrayListExtra("postMediaList");
    this.tpv = this.intent.getIntegerArrayListExtra("key_post_media_quality_list");
    this.tpw = this.intent.getByteArrayExtra("video_composition");
    paramIntent = this.tpu;
    int i;
    if (paramIntent != null) {
      i = paramIntent.size();
    }
    for (;;)
    {
      this.drZ = i;
      paramIntent = this.tpt;
      label123:
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
        this.tpA = ((FinderObjectDesc)paramIntent);
        paramIntent = this.intent.getByteArrayExtra("postRefFeedInfo");
        if (paramIntent != null)
        {
          localObject1 = new aqq();
          ((aqq)localObject1).parseFrom(paramIntent);
          this.tpk = ((aqq)localObject1);
        }
        this.kWX = this.intent.getBooleanExtra("KEY_POST_FROM_CAMERA", false);
        this.tpx = this.intent.getParcelableArrayListExtra("postVideoCropList");
        this.tpy = this.intent.getStringArrayListExtra("postThumbList");
        this.tpB = ((Rect)this.intent.getParcelableExtra("KEY_POST_VLOG_CROP_RECT"));
        paramIntent = this.intent.getStringExtra("post_id");
        localObject1 = this.intent.getStringExtra("edit_id");
        if (paramIntent != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.report.g.syJ;
          com.tencent.mm.plugin.finder.report.g.gr(paramIntent, (String)localObject1);
        }
        paramIntent = this.TAG;
        localObject1 = new StringBuilder("postType ").append(this.tpt).append(", mediaList ").append(this.tpu).append(" mediaCount ").append(this.drZ).append(' ').append("thumbList ").append(this.tpy).append(" thumbCount ");
        Object localObject2 = this.tpy;
        i = j;
        if (localObject2 != null) {
          i = ((ArrayList)localObject2).size();
        }
        ae.i(paramIntent, i + ", fromCamera:" + this.kWX);
        AppMethodBeat.o(206417);
        return;
        i = 0;
        continue;
        if (paramIntent.intValue() != 8) {
          break label123;
        }
        this.tpz = this.intent.getIntegerArrayListExtra("postTypeList");
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          ae.l("safeParser", "", new Object[] { paramIntent });
          paramIntent = null;
        }
      }
    }
  }
  
  public final long a(String paramString, h paramh, ArrayList<bvx> paramArrayList)
  {
    AppMethodBeat.i(206416);
    p.h(paramString, "desc");
    p.h(paramh, "uploadData");
    apl localapl = new apl();
    amz localamz = new amz();
    Object localObject1 = this.sVF;
    Object localObject3 = a.tps;
    localObject1 = ((Bundle)localObject1).getByteArray(a.cRm());
    if (localObject1 != null) {
      localapl.parseFrom((byte[])localObject1);
    }
    localObject1 = this.sVF;
    localObject3 = a.tps;
    localObject1 = ((Bundle)localObject1).getByteArray(a.cRn());
    if (localObject1 != null) {
      localamz.parseFrom((byte[])localObject1);
    }
    localObject1 = this.sVF;
    localObject3 = a.tps;
    int i = ((Bundle)localObject1).getInt(a.cRr(), 0);
    localObject1 = this.sVF;
    localObject3 = a.tps;
    boolean bool = ((Bundle)localObject1).getBoolean(a.cRq(), false);
    localObject1 = this.sVF;
    localObject3 = a.tps;
    localObject3 = ((Bundle)localObject1).getByteArray(a.cRo());
    localObject1 = this.sVF;
    a.a locala = a.tps;
    localObject1 = ((Bundle)localObject1).getByteArray(a.cRp());
    if ((localObject3 != null) && (localObject1 != null)) {}
    Object localObject2;
    for (localObject1 = (com.tencent.mm.bw.a)new aqq();; localObject2 = null) {
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (aqq)localObject1;
        localObject3 = com.tencent.mm.plugin.finder.upload.g.sUx;
        localObject3 = com.tencent.mm.plugin.finder.upload.g.cNo();
        int j = paramh.type;
        paramString = bu.nullAsNil(paramString);
        p.g(paramString, "Util.nullAsNil(desc)");
        long l = ((com.tencent.mm.plugin.finder.upload.g)localObject3).a(j, paramString, paramh.tqx, localapl, localamz, i, (aqq)localObject1, bool, paramh.tqj, paramArrayList);
        AppMethodBeat.o(206416);
        return l;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.l("safeParser", "", new Object[] { localException });
          localObject2 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.c
 * JD-Core Version:    0.7.0.1
 */