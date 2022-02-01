package com.tencent.mm.plugin.finder.widget.post;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.f;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.protocal.protobuf.bvd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "TAG", "", "compositionInfo", "", "getCompositionInfo", "()[B", "setCompositionInfo", "([B)V", "fromCamera", "", "getFromCamera", "()Z", "setFromCamera", "(Z)V", "geoDegree", "Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "getGeoDegree", "()Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "setGeoDegree", "(Lcom/tencent/mm/plugin/finder/utils/GeoDegree;)V", "imageQualityList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getImageQualityList", "()Ljava/util/ArrayList;", "setImageQualityList", "(Ljava/util/ArrayList;)V", "getIntent", "()Landroid/content/Intent;", "mediaCount", "getMediaCount", "()I", "setMediaCount", "(I)V", "mediaList", "getMediaList", "setMediaList", "postData", "Landroid/os/Bundle;", "getPostData", "()Landroid/os/Bundle;", "postType", "getPostType", "()Ljava/lang/Integer;", "setPostType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRefFeed", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeed", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "refFeedContent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "getRefFeedContent", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "setRefFeedContent", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;)V", "thumbList", "getThumbList", "setThumbList", "typeList", "getTypeList", "setTypeList", "videoCropInfoList", "Landroid/os/Parcelable;", "getVideoCropInfoList", "setVideoCropInfoList", "vlogCropRect", "Landroid/graphics/Rect;", "getVlogCropRect", "()Landroid/graphics/Rect;", "setVlogCropRect", "(Landroid/graphics/Rect;)V", "doPost", "", "desc", "uploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "atContactList", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "setupPostDataForMediaWidget", "", "updatePostVideoCoverUrl", "coverUrl", "coverQuality", "plugin-finder_release"})
public final class c
{
  private final String TAG;
  private int dqU;
  public final Intent intent;
  public boolean kTo;
  public final Bundle sKs;
  public Integer teA;
  public ArrayList<String> teB;
  public ArrayList<Integer> teC;
  public byte[] teD;
  public ArrayList<Parcelable> teE;
  public ArrayList<String> teF;
  public ArrayList<Integer> teG;
  public FinderObjectDesc teH;
  public Rect teI;
  public aqb ter;
  
  public c(Intent paramIntent)
  {
    AppMethodBeat.i(205803);
    this.intent = paramIntent;
    this.TAG = "Finder.PostDataManager";
    this.sKs = new Bundle();
    this.teA = Integer.valueOf(this.intent.getIntExtra("postType", 2));
    this.teB = this.intent.getStringArrayListExtra("postMediaList");
    this.teC = this.intent.getIntegerArrayListExtra("key_post_media_quality_list");
    this.teD = this.intent.getByteArrayExtra("video_composition");
    paramIntent = this.teB;
    int i;
    if (paramIntent != null) {
      i = paramIntent.size();
    }
    for (;;)
    {
      this.dqU = i;
      paramIntent = this.teA;
      label123:
      Object localObject1;
      if (paramIntent == null)
      {
        localObject1 = this.intent.getByteArrayExtra("postRefMediaList");
        if (localObject1 != null) {
          paramIntent = (com.tencent.mm.bx.a)new FinderObjectDesc();
        }
      }
      try
      {
        paramIntent.parseFrom((byte[])localObject1);
        this.teH = ((FinderObjectDesc)paramIntent);
        paramIntent = this.intent.getByteArrayExtra("postRefFeedInfo");
        if (paramIntent != null)
        {
          localObject1 = new aqb();
          ((aqb)localObject1).parseFrom(paramIntent);
          this.ter = ((aqb)localObject1);
        }
        this.kTo = this.intent.getBooleanExtra("KEY_POST_FROM_CAMERA", false);
        this.teE = this.intent.getParcelableArrayListExtra("postVideoCropList");
        this.teF = this.intent.getStringArrayListExtra("postThumbList");
        this.teI = ((Rect)this.intent.getParcelableExtra("KEY_POST_VLOG_CROP_RECT"));
        paramIntent = this.intent.getStringExtra("post_id");
        localObject1 = this.intent.getStringExtra("edit_id");
        if (paramIntent != null)
        {
          localObject2 = f.soC;
          f.gm(paramIntent, (String)localObject1);
        }
        paramIntent = this.TAG;
        localObject1 = new StringBuilder("postType ").append(this.teA).append(", mediaList ").append(this.teB).append(" mediaCount ").append(this.dqU).append(' ').append("thumbList ").append(this.teF).append(" thumbCount ");
        Object localObject2 = this.teF;
        i = j;
        if (localObject2 != null) {
          i = ((ArrayList)localObject2).size();
        }
        ad.i(paramIntent, i + ", fromCamera:" + this.kTo);
        AppMethodBeat.o(205803);
        return;
        i = 0;
        continue;
        if (paramIntent.intValue() != 8) {
          break label123;
        }
        this.teG = this.intent.getIntegerArrayListExtra("postTypeList");
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          ad.l("safeParser", "", new Object[] { paramIntent });
          paramIntent = null;
        }
      }
    }
  }
  
  public final long a(String paramString, h paramh, ArrayList<bvd> paramArrayList)
  {
    AppMethodBeat.i(205802);
    p.h(paramString, "desc");
    p.h(paramh, "uploadData");
    aoy localaoy = new aoy();
    amn localamn = new amn();
    Object localObject1 = this.sKs;
    Object localObject3 = a.tez;
    localObject1 = ((Bundle)localObject1).getByteArray(a.cOH());
    if (localObject1 != null) {
      localaoy.parseFrom((byte[])localObject1);
    }
    localObject1 = this.sKs;
    localObject3 = a.tez;
    localObject1 = ((Bundle)localObject1).getByteArray(a.cOI());
    if (localObject1 != null) {
      localamn.parseFrom((byte[])localObject1);
    }
    localObject1 = this.sKs;
    localObject3 = a.tez;
    int i = ((Bundle)localObject1).getInt(a.cOM(), 0);
    localObject1 = this.sKs;
    localObject3 = a.tez;
    boolean bool = ((Bundle)localObject1).getBoolean(a.cOL(), false);
    localObject1 = this.sKs;
    localObject3 = a.tez;
    localObject3 = ((Bundle)localObject1).getByteArray(a.cOJ());
    localObject1 = this.sKs;
    a.a locala = a.tez;
    localObject1 = ((Bundle)localObject1).getByteArray(a.cOK());
    if ((localObject3 != null) && (localObject1 != null)) {}
    Object localObject2;
    for (localObject1 = (com.tencent.mm.bx.a)new aqb();; localObject2 = null) {
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (aqb)localObject1;
        localObject3 = g.sJk;
        localObject3 = g.cKK();
        int j = paramh.type;
        paramString = bt.nullAsNil(paramString);
        p.g(paramString, "Util.nullAsNil(desc)");
        long l = ((g)localObject3).a(j, paramString, paramh.tfE, localaoy, localamn, i, (aqb)localObject1, bool, paramh.tfq, paramArrayList);
        AppMethodBeat.o(205802);
        return l;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.l("safeParser", "", new Object[] { localException });
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