package com.tencent.mm.plugin.finder.widget.post;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.amq;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "TAG", "", "compositionInfo", "", "getCompositionInfo", "()[B", "setCompositionInfo", "([B)V", "fromCamera", "", "getFromCamera", "()Z", "setFromCamera", "(Z)V", "geoDegree", "Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "getGeoDegree", "()Lcom/tencent/mm/plugin/finder/utils/GeoDegree;", "setGeoDegree", "(Lcom/tencent/mm/plugin/finder/utils/GeoDegree;)V", "getIntent", "()Landroid/content/Intent;", "mediaCount", "", "getMediaCount", "()I", "setMediaCount", "(I)V", "mediaList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMediaList", "()Ljava/util/ArrayList;", "setMediaList", "(Ljava/util/ArrayList;)V", "postData", "Landroid/os/Bundle;", "getPostData", "()Landroid/os/Bundle;", "postType", "getPostType", "()Ljava/lang/Integer;", "setPostType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRefFeed", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeed", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "refFeedContent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "getRefFeedContent", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "setRefFeedContent", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;)V", "thumbList", "getThumbList", "setThumbList", "typeList", "getTypeList", "setTypeList", "videoCropInfoList", "Landroid/os/Parcelable;", "getVideoCropInfoList", "setVideoCropInfoList", "vlogCropRect", "Landroid/graphics/Rect;", "getVlogCropRect", "()Landroid/graphics/Rect;", "setVlogCropRect", "(Landroid/graphics/Rect;)V", "doPost", "", "desc", "uploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "atContactList", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "setupPostDataForMediaWidget", "updatePostVideoCoverUrl", "coverUrl", "plugin-finder_release"})
public final class c
{
  private final String TAG;
  private int dfy;
  public final Intent intent;
  public boolean kxi;
  public final Bundle rOl;
  public ArrayList<String> sgY;
  public amq shV;
  public Integer sie;
  public byte[] sif;
  public ArrayList<Parcelable> sig;
  public ArrayList<String> sih;
  public ArrayList<Integer> sii;
  public FinderObjectDesc sij;
  public Rect sik;
  
  public c(Intent paramIntent)
  {
    AppMethodBeat.i(204869);
    this.intent = paramIntent;
    this.TAG = "Finder.PostDataManager";
    this.rOl = new Bundle();
    this.sie = Integer.valueOf(this.intent.getIntExtra("postType", 2));
    this.sgY = this.intent.getStringArrayListExtra("postMediaList");
    this.sif = this.intent.getByteArrayExtra("video_composition");
    paramIntent = this.sgY;
    int i;
    if (paramIntent != null) {
      i = paramIntent.size();
    }
    for (;;)
    {
      this.dfy = i;
      paramIntent = this.sie;
      label110:
      Object localObject1;
      if (paramIntent == null)
      {
        localObject1 = this.intent.getByteArrayExtra("postRefMediaList");
        if (localObject1 != null) {
          paramIntent = (a)new FinderObjectDesc();
        }
      }
      try
      {
        paramIntent.parseFrom((byte[])localObject1);
        this.sij = ((FinderObjectDesc)paramIntent);
        paramIntent = this.intent.getByteArrayExtra("postRefFeedInfo");
        if (paramIntent != null)
        {
          localObject1 = new amq();
          ((amq)localObject1).parseFrom(paramIntent);
          this.shV = ((amq)localObject1);
        }
        this.kxi = this.intent.getBooleanExtra("KEY_POST_FROM_CAMERA", false);
        this.sig = this.intent.getParcelableArrayListExtra("postVideoCropList");
        this.sih = this.intent.getStringArrayListExtra("postThumbList");
        this.sik = ((Rect)this.intent.getParcelableExtra("KEY_POST_VLOG_CROP_RECT"));
        paramIntent = this.intent.getStringExtra("post_id");
        localObject1 = this.intent.getStringExtra("edit_id");
        if (paramIntent != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.report.c.rxi;
          com.tencent.mm.plugin.finder.report.c.gd(paramIntent, (String)localObject1);
        }
        paramIntent = this.TAG;
        localObject1 = new StringBuilder("postType ").append(this.sie).append(", mediaList ").append(this.sgY).append(" mediaCount ").append(this.dfy).append(' ').append("thumbList ").append(this.sih).append(" thumbCount ");
        Object localObject2 = this.sih;
        i = j;
        if (localObject2 != null) {
          i = ((ArrayList)localObject2).size();
        }
        ac.i(paramIntent, i + ", fromCamera:" + this.kxi);
        AppMethodBeat.o(204869);
        return;
        i = 0;
        continue;
        if (paramIntent.intValue() != 8) {
          break label110;
        }
        this.sii = this.intent.getIntegerArrayListExtra("postTypeList");
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          ac.l("safeParser", "", new Object[] { paramIntent });
          paramIntent = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.c
 * JD-Core Version:    0.7.0.1
 */