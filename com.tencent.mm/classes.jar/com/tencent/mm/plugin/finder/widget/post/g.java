package com.tencent.mm.plugin.finder.widget.post;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.f;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.brc;
import com.tencent.mm.protocal.protobuf.yo;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.a.j;
import d.g.b.k;
import d.g.b.v.f;
import d.v;
import d.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/widget/post/PostVideoWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "getCompositionInfo", "()Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "setCompositionInfo", "(Lcom/tencent/mm/protocal/protobuf/CompositionInfo;)V", "container", "Landroid/view/View;", "coverUrl", "", "cropInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "Lkotlin/collections/ArrayList;", "getCropInfoList", "()Ljava/util/ArrayList;", "setCropInfoList", "(Ljava/util/ArrayList;)V", "reprintIv", "rootView", "thumbFileList", "getThumbFileList", "setThumbFileList", "thumbIv", "Landroid/widget/ImageView;", "videoFileList", "getVideoFileList", "setVideoFileList", "videoPathBeforeCut", "checkData", "", "getUploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "inflateView", "initCropInfo", "", "initFakeVideoLogic", "initNormalVideoLogic", "jumpSelectCoverUI", "jumpToPreviewMediaUI", "onCreate", "onDestroy", "refresh", "showThumb", "thumb", "Landroid/graphics/Bitmap;", "Companion", "plugin-finder_release"})
public final class g
  extends a
{
  private static final String TAG = "Finder.PostVideoWidget";
  private static final int siR = 1001;
  private static final String siS = "RESULT_COVER_PATH";
  public static final a siT;
  private String coverUrl;
  private View ifK;
  private View khe;
  ArrayList<String> siN;
  ArrayList<brc> siO;
  yo siP;
  private String siQ;
  private ImageView sil;
  private View sio;
  ArrayList<String> siq;
  
  static
  {
    AppMethodBeat.i(168626);
    siT = new a((byte)0);
    siR = 1001;
    siS = "RESULT_COVER_PATH";
    TAG = "Finder.PostVideoWidget";
    AppMethodBeat.o(168626);
  }
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168625);
    this.siq = new ArrayList();
    this.siO = new ArrayList();
    this.coverUrl = "";
    this.siQ = "";
    AppMethodBeat.o(168625);
  }
  
  private final boolean cGG()
  {
    AppMethodBeat.i(204890);
    Object localObject1 = this.dmf;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getByteArray("video_composition");
      if (localObject1 != null)
      {
        Object localObject3;
        try
        {
          ac.i(TAG, "initFakeVideoLogic");
          localObject3 = this.ifK;
          if (localObject3 == null) {
            k.aVY("container");
          }
          ((View)localObject3).setVisibility(0);
          localObject1 = new yo().parseFrom((byte[])localObject1);
          if (localObject1 != null) {
            break label117;
          }
          localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CompositionInfo");
          AppMethodBeat.o(204890);
          throw ((Throwable)localObject1);
        }
        catch (IOException localIOException)
        {
          ac.printErrStackTrace(TAG, (Throwable)localIOException, "parse error", new Object[0]);
        }
        AppMethodBeat.o(204890);
        return true;
        label117:
        this.siP = ((yo)localIOException);
        Object localObject2 = this.dmf;
        if (localObject2 != null)
        {
          localObject2 = ((Bundle)localObject2).getStringArrayList("VIDEO_THUMB_LIST");
          label142:
          localObject3 = new v.f();
          ((v.f)localObject3).KUQ = "";
          if (localObject2 != null) {
            if (((Collection)localObject2).isEmpty()) {
              break label295;
            }
          }
        }
        label295:
        for (int i = 1;; i = 0)
        {
          if (i == 1)
          {
            localObject2 = j.iO((List)localObject2);
            k.g(localObject2, "mediaThumbList.first()");
            ((v.f)localObject3).KUQ = ((String)localObject2);
          }
          c.b("PostVideoWidget_initFakeVideoLogic", (d.g.a.a)new b((v.f)localObject3, this));
          localObject2 = this.sil;
          if (localObject2 == null) {
            k.aVY("thumbIv");
          }
          ((ImageView)localObject2).setOnClickListener((View.OnClickListener)new g.c((v.f)localObject3, this));
          localObject2 = this.khe;
          if (localObject2 == null) {
            k.aVY("rootView");
          }
          ((View)localObject2).findViewById(2131307963).setOnClickListener((View.OnClickListener)new g.d((v.f)localObject3, this));
          break;
          localObject2 = null;
          break label142;
        }
      }
    }
    AppMethodBeat.o(204890);
    return false;
  }
  
  private final void cGH()
  {
    AppMethodBeat.i(204891);
    Bundle localBundle = this.dmf;
    if (localBundle != null)
    {
      Object localObject2 = localBundle.getString("video_before_cut_path");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.siQ = ((String)localObject1);
      localObject1 = localBundle.getParcelableArrayList("VIDEO_CROP_LIST");
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Parcelable)((Iterator)localObject1).next();
          if ((localObject2 != null) && ((localObject2 instanceof LocalVideoCropInfoParcelable))) {
            this.siO.add(((LocalVideoCropInfoParcelable)localObject2).rvh);
          } else {
            this.siO.add(null);
          }
        }
        AppMethodBeat.o(204891);
        return;
      }
      AppMethodBeat.o(204891);
      return;
    }
    AppMethodBeat.o(204891);
  }
  
  public final View cGA()
  {
    AppMethodBeat.i(168622);
    Object localObject = this.context;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(168622);
      throw ((Throwable)localObject);
    }
    localObject = ((Activity)localObject).getLayoutInflater().inflate(2131494091, null);
    k.g(localObject, "(context as Activity).la…_post_video_widget, null)");
    this.khe = ((View)localObject);
    localObject = this.khe;
    if (localObject == null) {
      k.aVY("rootView");
    }
    localObject = ((View)localObject).findViewById(2131306317);
    k.g(localObject, "rootView.findViewById(R.id.video_container)");
    this.ifK = ((View)localObject);
    localObject = this.khe;
    if (localObject == null) {
      k.aVY("rootView");
    }
    localObject = ((View)localObject).findViewById(2131305801);
    k.g(localObject, "rootView.findViewById(R.id.thumb_view)");
    this.sil = ((ImageView)localObject);
    localObject = this.khe;
    if (localObject == null) {
      k.aVY("rootView");
    }
    localObject = ((View)localObject).findViewById(2131304092);
    k.g(localObject, "rootView.findViewById(R.id.reprint_iv)");
    this.sio = ((View)localObject);
    localObject = this.khe;
    if (localObject == null) {
      k.aVY("rootView");
    }
    AppMethodBeat.o(168622);
    return localObject;
  }
  
  public final h cGB()
  {
    AppMethodBeat.i(204889);
    Object localObject3;
    Object localObject2;
    label63:
    Object localObject4;
    if (this.siP != null)
    {
      localObject3 = new bqr();
      localObject1 = this.dmf;
      if (localObject1 != null)
      {
        localObject1 = ((Bundle)localObject1).getStringArrayList("VIDEO_THUMB_LIST");
        if (localObject1 != null)
        {
          localObject2 = (String)j.iO((List)localObject1);
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label63;
          }
        }
      }
      localObject1 = "";
      localObject2 = ((bqr)localObject3).mediaList;
      localObject4 = com.tencent.mm.plugin.finder.upload.h.rNr;
      localObject4 = this.siP;
      if (localObject4 == null) {
        k.fOy();
      }
      ((LinkedList)localObject2).add(com.tencent.mm.plugin.finder.upload.h.a((yo)localObject4, (String)localObject1, this.coverUrl));
      localObject1 = new h(true, 4, (bqr)localObject3, this.siQ);
      AppMethodBeat.o(204889);
      return localObject1;
    }
    if ((this.shV != null) && (this.shW != null))
    {
      localObject1 = new h(true, 4, this.shW);
      AppMethodBeat.o(204889);
      return localObject1;
    }
    Object localObject1 = (Collection)this.siN;
    int i;
    label279:
    label316:
    LinkedList localLinkedList;
    String str;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
    {
      i = 1;
      if (i != 0) {
        break label438;
      }
      localObject1 = TAG;
      localObject2 = new StringBuilder("video list ");
      localObject3 = this.siN;
      if (localObject3 == null) {
        k.fOy();
      }
      ac.i((String)localObject1, ((ArrayList)localObject3).size() + ", thumb list " + this.siq.size());
      localObject1 = this.siN;
      if (localObject1 == null) {
        k.fOy();
      }
      if (((ArrayList)localObject1).size() != this.siq.size()) {
        break label433;
      }
      i = 1;
      if (i == 0) {
        break label487;
      }
      localObject2 = new bqr();
      localObject1 = this.siN;
      if (localObject1 == null) {
        k.fOy();
      }
      localObject3 = ((Iterable)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject3).hasNext()) {
        break label457;
      }
      localObject1 = ((Iterator)localObject3).next();
      if (i < 0) {
        j.fOc();
      }
      localObject4 = (String)localObject1;
      localLinkedList = ((bqr)localObject2).mediaList;
      localObject1 = com.tencent.mm.plugin.finder.upload.h.rNr;
      str = bs.nullAsNil((String)this.siq.get(i));
      k.g(str, "Util.nullAsNil(thumbFileList[index])");
      if (this.siO.size() <= i) {
        break label452;
      }
    }
    label433:
    label438:
    label452:
    for (localObject1 = (brc)this.siO.get(i);; localObject1 = null)
    {
      localLinkedList.add(com.tencent.mm.plugin.finder.upload.h.a((String)localObject4, str, (brc)localObject1, this.coverUrl));
      i += 1;
      break label316;
      i = 0;
      break;
      i = 0;
      break label279;
      ac.i(TAG, "video list null");
      i = 0;
      break label279;
    }
    label457:
    localObject1 = n.rPN;
    localObject1 = new h(true, n.a((bqr)localObject2), (bqr)localObject2, this.siQ);
    AppMethodBeat.o(204889);
    return localObject1;
    label487:
    localObject1 = new h(false, 0, null);
    AppMethodBeat.o(204889);
    return localObject1;
  }
  
  public final void refresh()
  {
    Object localObject2 = null;
    AppMethodBeat.i(168624);
    Object localObject1 = this.dmf;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = ((Bundle)localObject1).getString("VIDEO_COVER_URL");
      localObject1 = localObject3;
      if (localObject3 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    this.coverUrl = ((String)localObject1);
    localObject1 = this.dmf;
    if (localObject1 != null) {}
    for (localObject1 = ((Bundle)localObject1).getByteArray("video_composition"); localObject1 != null; localObject1 = null)
    {
      cGG();
      AppMethodBeat.o(168624);
      return;
    }
    if (this.shW != null)
    {
      localObject1 = this.shW;
      if (localObject1 == null) {
        k.fOy();
      }
      if (!bs.gY((List)((bqr)localObject1).mediaList))
      {
        localObject1 = this.ifK;
        if (localObject1 == null) {
          k.aVY("container");
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = this.sio;
        if (localObject1 == null) {
          k.aVY("reprintIv");
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = this.shW;
        if (localObject1 == null) {
          k.fOy();
        }
        localObject1 = ((bqr)localObject1).mediaList;
        k.g(localObject1, "refFeedContent!!.mediaList");
        localObject1 = (bqs)((LinkedList)localObject1).getFirst();
        localObject2 = n.rPN;
        localObject2 = n.fF((int)((bqs)localObject1).width, (int)((bqs)localObject1).height);
        localObject3 = this.sil;
        if (localObject3 == null) {
          k.aVY("thumbIv");
        }
        ((ImageView)localObject3).getLayoutParams().width = ((Bundle)localObject2).getInt("media_layout_width", (int)((bqs)localObject1).width);
        localObject3 = this.sil;
        if (localObject3 == null) {
          k.aVY("thumbIv");
        }
        ((ImageView)localObject3).getLayoutParams().height = ((Bundle)localObject2).getInt("media_layout_height", (int)((bqs)localObject1).height);
        localObject3 = this.sil;
        if (localObject3 == null) {
          k.aVY("thumbIv");
        }
        ((ImageView)localObject3).setScaleType(android.widget.ImageView.ScaleType.values()[localObject2.getInt("media_layout_sale_type", android.widget.ImageView.ScaleType.CENTER_CROP.ordinal())]);
        localObject2 = this.sil;
        if (localObject2 == null) {
          k.aVY("thumbIv");
        }
        ((ImageView)localObject2).requestLayout();
        k.g(localObject1, "mediaObj");
        localObject1 = new f((bqs)localObject1, m.rDR);
        localObject2 = com.tencent.mm.plugin.finder.loader.h.rtK;
        localObject2 = com.tencent.mm.plugin.finder.loader.h.cwn();
        localObject3 = this.sil;
        if (localObject3 == null) {
          k.aVY("thumbIv");
        }
        com.tencent.mm.plugin.finder.loader.h localh = com.tencent.mm.plugin.finder.loader.h.rtK;
        ((d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.h.a(h.a.rtL));
        localObject1 = this.sil;
        if (localObject1 == null) {
          k.aVY("thumbIv");
        }
        ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new g.g(this));
        AppMethodBeat.o(168624);
        return;
      }
    }
    localObject1 = this.dmf;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getStringArrayList("video_file_list");
      this.siN = ((ArrayList)localObject1);
      this.siq = new ArrayList();
      localObject3 = this.dmf;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((Bundle)localObject3).getStringArrayList("VIDEO_THUMB_LIST");
      }
      localObject2 = this.dmf;
      if (localObject2 != null)
      {
        localObject3 = ((Bundle)localObject2).getString("VIDEO_COVER_URL");
        localObject2 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject2 = "";
      }
      this.coverUrl = ((String)localObject2);
      cGH();
      localObject2 = (Collection)this.siN;
      if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
        break label633;
      }
    }
    label633:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject2 = this.khe;
        if (localObject2 == null) {
          k.aVY("rootView");
        }
        ((View)localObject2).findViewById(2131307963).setOnClickListener((View.OnClickListener)new g.e(this));
        localObject2 = this.ifK;
        if (localObject2 == null) {
          k.aVY("container");
        }
        ((View)localObject2).setVisibility(0);
        b.c((Runnable)new g.f(this, (ArrayList)localObject1), "Finder_Post_Create_Video_Thumb");
      }
      AppMethodBeat.o(168624);
      return;
      localObject1 = null;
      break;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/widget/post/PostVideoWidget$Companion;", "", "()V", "REQUEST_SELECT_COVER", "", "getREQUEST_SELECT_COVER", "()I", "RESULT_COVER_PATH", "", "getRESULT_COVER_PATH", "()Ljava/lang/String;", "TAG", "getTAG", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$1$1"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(v.f paramf, g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.g
 * JD-Core Version:    0.7.0.1
 */