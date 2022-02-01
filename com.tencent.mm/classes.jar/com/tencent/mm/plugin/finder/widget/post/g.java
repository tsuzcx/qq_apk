package com.tencent.mm.plugin.finder.widget.post;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.j;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "TAG", "", "compositionInfo", "", "getCompositionInfo", "()[B", "setCompositionInfo", "([B)V", "fromCamera", "", "getFromCamera", "()Z", "setFromCamera", "(Z)V", "geoDegree", "Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "getGeoDegree", "()Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "setGeoDegree", "(Lcom/tencent/mm/plugin/finder/utils/GeoDegree;)V", "getIntent", "()Landroid/content/Intent;", "mediaCount", "", "getMediaCount", "()I", "setMediaCount", "(I)V", "mediaList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMediaList", "()Ljava/util/ArrayList;", "setMediaList", "(Ljava/util/ArrayList;)V", "postData", "Landroid/os/Bundle;", "getPostData", "()Landroid/os/Bundle;", "postType", "getPostType", "()Ljava/lang/Integer;", "setPostType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRefFeed", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeed", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "refFeedContent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "getRefFeedContent", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "setRefFeedContent", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;)V", "thumbList", "getThumbList", "setThumbList", "typeList", "getTypeList", "setTypeList", "videoCropInfoList", "Landroid/os/Parcelable;", "getVideoCropInfoList", "setVideoCropInfoList", "vlogCropRect", "Landroid/graphics/Rect;", "getVlogCropRect", "()Landroid/graphics/Rect;", "setVlogCropRect", "(Landroid/graphics/Rect;)V", "doPost", "", "desc", "uploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "atContactList", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "setupPostDataForMediaWidget", "updatePostVideoCoverUrl", "coverUrl", "plugin-finder_release"})
public final class g
{
  public final Bundle Lau;
  public Integer LlN;
  public byte[] LlO;
  public ArrayList<Parcelable> LlP;
  public ArrayList<String> LlQ;
  public ArrayList<Integer> LlR;
  public j LlS;
  public FinderObjectDesc LlT;
  public Rect LlU;
  public ArrayList<String> Llb;
  private final String TAG;
  private int did;
  public final Intent intent;
  public boolean jWw;
  public akf qOO;
  
  public g(Intent paramIntent)
  {
    AppMethodBeat.i(200741);
    this.intent = paramIntent;
    this.TAG = "Finder.PostDataManager";
    this.Lau = new Bundle();
    this.LlN = Integer.valueOf(this.intent.getIntExtra("postType", 2));
    this.Llb = this.intent.getStringArrayListExtra("postMediaList");
    this.LlO = this.intent.getByteArrayExtra("video_composition");
    paramIntent = this.Llb;
    int i;
    if (paramIntent != null) {
      i = paramIntent.size();
    }
    for (;;)
    {
      this.did = i;
      paramIntent = this.LlN;
      label110:
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
        this.LlT = ((FinderObjectDesc)paramIntent);
        paramIntent = this.intent.getByteArrayExtra("postRefFeedInfo");
        if (paramIntent != null)
        {
          localObject1 = new akf();
          ((akf)localObject1).parseFrom(paramIntent);
          this.qOO = ((akf)localObject1);
        }
        this.jWw = this.intent.getBooleanExtra("KEY_POST_FROM_CAMERA", false);
        this.LlP = this.intent.getParcelableArrayListExtra("postVideoCropList");
        this.LlQ = this.intent.getStringArrayListExtra("postThumbList");
        this.LlU = ((Rect)this.intent.getParcelableExtra("KEY_POST_VLOG_CROP_RECT"));
        paramIntent = this.intent.getStringExtra("post_id");
        localObject1 = this.intent.getStringExtra("edit_id");
        if (paramIntent != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.report.a.qFo;
          com.tencent.mm.plugin.finder.report.a.ka(paramIntent, (String)localObject1);
        }
        paramIntent = this.TAG;
        localObject1 = new StringBuilder("postType ").append(this.LlN).append(", mediaList ").append(this.Llb).append(" mediaCount ").append(this.did).append(' ').append("thumbList ").append(this.LlQ).append(" thumbCount ");
        Object localObject2 = this.LlQ;
        i = j;
        if (localObject2 != null) {
          i = ((ArrayList)localObject2).size();
        }
        ad.i(paramIntent, i + ", fromCamera:" + this.jWw);
        AppMethodBeat.o(200741);
        return;
        i = 0;
        continue;
        if (paramIntent.intValue() != 8) {
          break label110;
        }
        this.LlR = this.intent.getIntegerArrayListExtra("postTypeList");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.g
 * JD-Core Version:    0.7.0.1
 */