package com.tencent.mm.plugin.finder.widget.post;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.bvp;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.PhotoView;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import d.a.j;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mediaCountView", "Landroid/widget/TextView;", "getMediaCountView", "()Landroid/widget/TextView;", "setMediaCountView", "(Landroid/widget/TextView;)V", "mediaCropInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "Lkotlin/collections/ArrayList;", "getMediaCropInfoList", "()Ljava/util/ArrayList;", "setMediaCropInfoList", "(Ljava/util/ArrayList;)V", "mediaFileList", "", "getMediaFileList", "setMediaFileList", "mediaTypeList", "", "getMediaTypeList", "setMediaTypeList", "multiIcon", "Landroid/view/View;", "getMultiIcon", "()Landroid/view/View;", "setMultiIcon", "(Landroid/view/View;)V", "reprintIv", "rootView", "thumbFileList", "getThumbFileList", "setThumbFileList", "thumbIv", "Lcom/tencent/mm/view/PhotoView;", "getThumbIv", "()Lcom/tencent/mm/view/PhotoView;", "setThumbIv", "(Lcom/tencent/mm/view/PhotoView;)V", "videoPlayIcon", "Landroid/widget/ImageView;", "getVideoPlayIcon", "()Landroid/widget/ImageView;", "setVideoPlayIcon", "(Landroid/widget/ImageView;)V", "checkData", "", "getThumbFile", "index", "file", "mediaThumbList", "getUploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "inflateView", "initCropInfo", "", "jumpToPreviewMediaUI", "onCreate", "onDestroy", "refresh", "showMediaThumb", "showVideoThumb", "thumbFile", "showThumb", "Companion", "plugin-finder_release"})
public final class e
  extends a
{
  private static final String TAG = "Finder.PostMixMediaWidget";
  public static final a tfi;
  private View kBS;
  private View teK;
  ArrayList<String> teN;
  public PhotoView tfb;
  public TextView tfc;
  protected ImageView tfd;
  public View tfe;
  private ArrayList<String> tff;
  private ArrayList<Integer> tfg;
  private ArrayList<bvp> tfh;
  
  static
  {
    AppMethodBeat.i(168612);
    tfi = new a((byte)0);
    TAG = "Finder.PostMixMediaWidget";
    AppMethodBeat.o(168612);
  }
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168611);
    this.teN = new ArrayList();
    this.tfh = new ArrayList();
    AppMethodBeat.o(168611);
  }
  
  public final void Z(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(205810);
    Object localObject1 = this.tff;
    if (localObject1 == null) {
      d.g.b.p.gfZ();
    }
    Iterator localIterator = ((Iterable)localObject1).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (i < 0) {
        j.gfB();
      }
      localObject1 = (String)localObject1;
      final boolean bool;
      label72:
      Object localObject2;
      if (i == 0)
      {
        bool = true;
        d.g.b.p.h(localObject1, "file");
        localObject2 = this.tfg;
        if (localObject2 == null) {
          d.g.b.p.gfZ();
        }
        localObject2 = (Integer)((ArrayList)localObject2).get(i);
        if (localObject2 != null) {
          break label290;
        }
        label109:
        if ((paramArrayList == null) || (paramArrayList.size() <= i) || (bt.isNullOrNil((String)paramArrayList.get(i))) || (!com.tencent.mm.vfs.i.fv((String)paramArrayList.get(i)))) {
          break label364;
        }
        localObject1 = paramArrayList.get(i);
        d.g.b.p.g(localObject1, "mediaThumbList[index]");
        localObject1 = (String)localObject1;
      }
      for (;;)
      {
        d.g.b.p.h(localObject1, "thumbFile");
        ad.i(TAG, "showVideoThumb, thumbFile:" + (String)localObject1 + ", showThumb:" + bool);
        if (!bt.isNullOrNil((String)localObject1))
        {
          localObject2 = com.tencent.mm.sdk.platformtools.g.decodeFile((String)localObject1);
          if (localObject2 != null) {
            aq.f((Runnable)new d((Bitmap)localObject2, this, (String)localObject1, bool, (Bitmap)localObject2));
          }
        }
        if (bool)
        {
          localObject1 = this.tfd;
          if (localObject1 == null) {
            d.g.b.p.bcb("videoPlayIcon");
          }
          ((ImageView)localObject1).setVisibility(8);
        }
        i += 1;
        break;
        bool = false;
        break label72;
        label290:
        if (((Integer)localObject2).intValue() != 2) {
          break label109;
        }
        if ((paramArrayList != null) && (paramArrayList.size() > i) && (!bt.isNullOrNil((String)paramArrayList.get(i))))
        {
          localObject1 = paramArrayList.get(i);
          d.g.b.p.g(localObject1, "mediaThumbList[index]");
          localObject1 = (String)localObject1;
        }
        else
        {
          localObject2 = f.sJc;
          localObject1 = f.aiL((String)localObject1);
          continue;
          label364:
          if ((this.tfh.size() > i) && (this.tfh.get(i) != null))
          {
            localObject2 = f.sJc;
            localObject2 = this.tfh.get(i);
            if (localObject2 == null) {
              d.g.b.p.gfZ();
            }
            localObject2 = ((bvp)localObject2).GPN;
            d.g.b.p.g(localObject2, "mediaCropInfoList[index]!!.thumbRect");
            localObject1 = f.a((String)localObject1, (dwe)localObject2);
          }
          else
          {
            ad.w(TAG, "no thumb & no thumbRect");
            localObject2 = f.sJc;
            localObject1 = f.aiK((String)localObject1);
          }
        }
      }
    }
    AppMethodBeat.o(205810);
  }
  
  public final View cON()
  {
    AppMethodBeat.i(168608);
    Object localObject = this.context;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(168608);
      throw ((Throwable)localObject);
    }
    localObject = ((Activity)localObject).getLayoutInflater().inflate(2131494086, null);
    d.g.b.p.g(localObject, "(context as Activity).la…_post_media_widget, null)");
    this.kBS = ((View)localObject);
    localObject = this.kBS;
    if (localObject == null) {
      d.g.b.p.bcb("rootView");
    }
    localObject = ((View)localObject).findViewById(2131305801);
    d.g.b.p.g(localObject, "rootView.findViewById(R.id.thumb_view)");
    this.tfb = ((PhotoView)localObject);
    localObject = this.kBS;
    if (localObject == null) {
      d.g.b.p.bcb("rootView");
    }
    localObject = ((View)localObject).findViewById(2131302214);
    d.g.b.p.g(localObject, "rootView.findViewById(R.id.media_number)");
    this.tfc = ((TextView)localObject);
    localObject = this.kBS;
    if (localObject == null) {
      d.g.b.p.bcb("rootView");
    }
    localObject = ((View)localObject).findViewById(2131306365);
    d.g.b.p.g(localObject, "rootView.findViewById(R.id.video_play_icon)");
    this.tfd = ((ImageView)localObject);
    localObject = this.kBS;
    if (localObject == null) {
      d.g.b.p.bcb("rootView");
    }
    localObject = ((View)localObject).findViewById(2131302563);
    d.g.b.p.g(localObject, "rootView.findViewById(R.id.multi_icon)");
    this.tfe = ((View)localObject);
    localObject = this.kBS;
    if (localObject == null) {
      d.g.b.p.bcb("rootView");
    }
    localObject = ((View)localObject).findViewById(2131304092);
    d.g.b.p.g(localObject, "rootView.findViewById(R.id.reprint_iv)");
    this.teK = ((View)localObject);
    localObject = this.kBS;
    if (localObject == null) {
      d.g.b.p.bcb("rootView");
    }
    AppMethodBeat.o(168608);
    return localObject;
  }
  
  public final h cOO()
  {
    AppMethodBeat.i(205809);
    if ((this.ter != null) && (this.tes != null))
    {
      localObject1 = new h(true, 8, this.tes);
      AppMethodBeat.o(205809);
      return localObject1;
    }
    Object localObject1 = (Collection)this.tff;
    int i;
    Object localObject2;
    label161:
    label199:
    int j;
    String str1;
    label259:
    Object localObject4;
    String str2;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
    {
      i = 1;
      if (i != 0) {
        break label346;
      }
      localObject1 = TAG;
      localObject2 = new StringBuilder("media list ");
      Object localObject3 = this.tff;
      if (localObject3 == null) {
        d.g.b.p.gfZ();
      }
      ad.i((String)localObject1, ((ArrayList)localObject3).size() + ", thumb list " + this.teN.size());
      localObject1 = this.tff;
      if (localObject1 == null) {
        d.g.b.p.gfZ();
      }
      if (((ArrayList)localObject1).size() != this.teN.size()) {
        break label341;
      }
      i = 1;
      if (i == 0) {
        break label443;
      }
      localObject2 = new bve();
      localObject1 = this.tff;
      if (localObject1 == null) {
        d.g.b.p.gfZ();
      }
      localObject3 = ((Iterable)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject3).hasNext()) {
        break label422;
      }
      localObject1 = ((Iterator)localObject3).next();
      j = i + 1;
      if (i < 0) {
        j.gfB();
      }
      str1 = (String)localObject1;
      localObject1 = this.tfg;
      if (localObject1 == null) {
        d.g.b.p.gfZ();
      }
      localObject1 = (Integer)((ArrayList)localObject1).get(i);
      if (localObject1 != null) {
        break label360;
      }
      localObject4 = ((bve)localObject2).mediaList;
      localObject1 = com.tencent.mm.plugin.finder.upload.i.sJt;
      str2 = bt.nullAsNil((String)this.teN.get(i));
      d.g.b.p.g(str2, "Util.nullAsNil(thumbFileList[index])");
      if (this.tfh.size() <= i) {
        break label417;
      }
    }
    label417:
    for (localObject1 = (bvp)this.tfh.get(i);; localObject1 = null)
    {
      ((LinkedList)localObject4).add(com.tencent.mm.plugin.finder.upload.i.a(str1, str2, (bvp)localObject1));
      i = j;
      break label199;
      i = 0;
      break;
      label341:
      i = 0;
      break label161;
      label346:
      ad.i(TAG, "media list null");
      i = 0;
      break label161;
      label360:
      if (((Integer)localObject1).intValue() != 2) {
        break label259;
      }
      localObject1 = ((bve)localObject2).mediaList;
      localObject4 = com.tencent.mm.plugin.finder.upload.i.sJt;
      localObject4 = this.teN.get(i);
      d.g.b.p.g(localObject4, "thumbFileList[index]");
      ((LinkedList)localObject1).add(com.tencent.mm.plugin.finder.upload.i.gu(str1, (String)localObject4));
      i = j;
      break label199;
    }
    label422:
    localObject1 = new h(true, 8, (bve)localObject2);
    AppMethodBeat.o(205809);
    return localObject1;
    label443:
    localObject1 = new h(false, 0, null);
    AppMethodBeat.o(205809);
    return localObject1;
  }
  
  public final PhotoView cOS()
  {
    AppMethodBeat.i(205808);
    PhotoView localPhotoView = this.tfb;
    if (localPhotoView == null) {
      d.g.b.p.bcb("thumbIv");
    }
    AppMethodBeat.o(205808);
    return localPhotoView;
  }
  
  public final void cOT()
  {
    AppMethodBeat.i(205811);
    bve localbve = new bve();
    if (this.tes != null)
    {
      localObject1 = this.tes;
      if (localObject1 == null) {
        d.g.b.p.gfZ();
      }
      if (!bt.hj((List)((bve)localObject1).mediaList))
      {
        localObject1 = localbve.mediaList;
        localObject2 = this.tes;
        if (localObject2 == null) {
          d.g.b.p.gfZ();
        }
        ((LinkedList)localObject1).addAll((Collection)((bve)localObject2).mediaList);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.sKD;
        localObject1 = this.context;
        if (localObject1 != null) {
          break label336;
        }
        localObject1 = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(205811);
        throw ((Throwable)localObject1);
      }
    }
    Object localObject1 = this.tff;
    if (localObject1 == null) {
      d.g.b.p.gfZ();
    }
    Object localObject2 = ((Iterable)localObject1).iterator();
    int i = 0;
    label137:
    int j;
    label197:
    Object localObject4;
    String str;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      j = i + 1;
      if (i < 0) {
        j.gfB();
      }
      localObject3 = (String)localObject1;
      localObject1 = this.tfg;
      if (localObject1 == null) {
        d.g.b.p.gfZ();
      }
      localObject1 = (Integer)((ArrayList)localObject1).get(i);
      if (localObject1 == null)
      {
        localObject4 = localbve.mediaList;
        localObject1 = com.tencent.mm.plugin.finder.upload.i.sJt;
        str = bt.nullAsNil((String)this.teN.get(i));
        d.g.b.p.g(str, "Util.nullAsNil(thumbFileList[index])");
        if (this.tfh.size() <= i) {
          break label331;
        }
      }
    }
    label331:
    for (localObject1 = (bvp)this.tfh.get(i);; localObject1 = null)
    {
      ((LinkedList)localObject4).add(com.tencent.mm.plugin.finder.upload.i.a((String)localObject3, str, (bvp)localObject1));
      i = j;
      break label137;
      if (((Integer)localObject1).intValue() != 2) {
        break label197;
      }
      localObject1 = localbve.mediaList;
      localObject4 = com.tencent.mm.plugin.finder.upload.i.sJt;
      localObject4 = this.teN.get(i);
      d.g.b.p.g(localObject4, "thumbFileList[index]");
      ((LinkedList)localObject1).add(com.tencent.mm.plugin.finder.upload.i.gu((String)localObject3, (String)localObject4));
      i = j;
      break label137;
      break;
    }
    label336:
    localObject1 = (Activity)localObject1;
    localObject2 = this.tfb;
    if (localObject2 == null) {
      d.g.b.p.bcb("thumbIv");
    }
    localObject2 = (View)localObject2;
    Object localObject3 = this.context;
    if (localObject3 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(205811);
      throw ((Throwable)localObject1);
    }
    localObject3 = ((MMActivity)localObject3).getWindow();
    d.g.b.p.g(localObject3, "(context as MMActivity).window");
    localObject2 = ViewAnimHelper.o((View)localObject2, ((Window)localObject3).getDecorView());
    d.g.b.p.g(localObject2, "ViewAnimHelper.getViewIn…tivity).window.decorView)");
    com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject1, (ViewAnimHelper.ViewInfo)localObject2, localbve, this.ter);
    AppMethodBeat.o(205811);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(168610);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (this.tes != null)
    {
      localObject1 = this.tes;
      if (localObject1 == null) {
        d.g.b.p.gfZ();
      }
      if (!bt.hj((List)((bve)localObject1).mediaList))
      {
        localObject1 = this.teK;
        if (localObject1 == null) {
          d.g.b.p.bcb("reprintIv");
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = this.tes;
        if (localObject1 == null) {
          d.g.b.p.gfZ();
        }
        if (((bve)localObject1).mediaList.size() > 1)
        {
          localObject1 = this.tfc;
          if (localObject1 == null) {
            d.g.b.p.bcb("mediaCountView");
          }
          ((TextView)localObject1).setVisibility(8);
          localObject1 = this.tfc;
          if (localObject1 == null) {
            d.g.b.p.bcb("mediaCountView");
          }
          localObject2 = this.context;
          localObject3 = this.tes;
          if (localObject3 == null) {
            d.g.b.p.gfZ();
          }
          ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getString(2131759238, new Object[] { Integer.valueOf(((bve)localObject3).mediaList.size()) }));
          localObject1 = this.tfe;
          if (localObject1 == null) {
            d.g.b.p.bcb("multiIcon");
          }
          ((View)localObject1).setVisibility(0);
          localObject1 = this.tes;
          if (localObject1 == null) {
            d.g.b.p.gfZ();
          }
          localObject1 = ((bve)localObject1).mediaList;
          d.g.b.p.g(localObject1, "refFeedContent!!.mediaList");
          localObject1 = (bvf)((LinkedList)localObject1).getFirst();
          localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
          localObject2 = com.tencent.mm.plugin.finder.utils.p.fT((int)((bvf)localObject1).width, (int)((bvf)localObject1).height);
          localObject3 = this.tfb;
          if (localObject3 == null) {
            d.g.b.p.bcb("thumbIv");
          }
          ((PhotoView)localObject3).getLayoutParams().width = ((Bundle)localObject2).getInt("media_layout_width", (int)((bvf)localObject1).width);
          localObject3 = this.tfb;
          if (localObject3 == null) {
            d.g.b.p.bcb("thumbIv");
          }
          ((PhotoView)localObject3).getLayoutParams().height = ((Bundle)localObject2).getInt("media_layout_height", (int)((bvf)localObject1).height);
          localObject3 = this.tfb;
          if (localObject3 == null) {
            d.g.b.p.bcb("thumbIv");
          }
          ((PhotoView)localObject3).setScaleType(android.widget.ImageView.ScaleType.values()[localObject2.getInt("media_layout_sale_type", android.widget.ImageView.ScaleType.CENTER_CROP.ordinal())]);
          localObject2 = this.tfb;
          if (localObject2 == null) {
            d.g.b.p.bcb("thumbIv");
          }
          ((PhotoView)localObject2).requestLayout();
          if (((bvf)localObject1).mediaType != 4) {
            break label498;
          }
          d.g.b.p.g(localObject1, "mediaObj");
          localObject1 = new com.tencent.mm.plugin.finder.loader.g((bvf)localObject1, r.syE);
          localObject2 = com.tencent.mm.plugin.finder.loader.i.sja;
          localObject2 = com.tencent.mm.plugin.finder.loader.i.cCB();
          localObject3 = this.tfb;
          if (localObject3 == null) {
            d.g.b.p.bcb("thumbIv");
          }
          if (localObject3 == null) {
            d.g.b.p.gfZ();
          }
          localObject3 = (ImageView)localObject3;
          localObject4 = com.tencent.mm.plugin.finder.loader.i.sja;
          ((d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.i.a(i.a.sjb));
        }
        for (;;)
        {
          localObject1 = this.tfb;
          if (localObject1 == null) {
            d.g.b.p.bcb("thumbIv");
          }
          ((PhotoView)localObject1).setOnClickListener((View.OnClickListener)new b(this));
          AppMethodBeat.o(168610);
          return;
          localObject1 = this.tfc;
          if (localObject1 == null) {
            d.g.b.p.bcb("mediaCountView");
          }
          ((TextView)localObject1).setVisibility(8);
          break;
          label498:
          d.g.b.p.g(localObject1, "mediaObj");
          localObject1 = new com.tencent.mm.plugin.finder.loader.g((bvf)localObject1, r.syE);
          localObject2 = com.tencent.mm.plugin.finder.loader.i.sja;
          localObject2 = com.tencent.mm.plugin.finder.loader.i.cCB();
          localObject3 = this.tfb;
          if (localObject3 == null) {
            d.g.b.p.bcb("thumbIv");
          }
          if (localObject3 == null) {
            d.g.b.p.gfZ();
          }
          localObject3 = (ImageView)localObject3;
          localObject4 = com.tencent.mm.plugin.finder.loader.i.sja;
          ((d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.i.a(i.a.sjb));
        }
      }
    }
    Object localObject1 = this.dxT;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getStringArrayList("MEDIA_FILE_LIST");
      this.tff = ((ArrayList)localObject1);
      localObject1 = this.dxT;
      if (localObject1 == null) {
        break label720;
      }
      localObject1 = ((Bundle)localObject1).getIntegerArrayList("MEDIA_TYPE_LIST");
      label611:
      this.tfg = ((ArrayList)localObject1);
      localObject1 = this.dxT;
      if (localObject1 == null) {
        break label725;
      }
      localObject1 = ((Bundle)localObject1).getStringArrayList("MEDIA_THUMB_LIST");
      label633:
      localObject2 = this.dxT;
      if (localObject2 == null) {
        d.g.b.p.gfZ();
      }
      localObject2 = ((Bundle)localObject2).getParcelableArrayList("VIDEO_CROP_LIST");
      if (localObject2 == null) {
        break label742;
      }
      localObject2 = ((Iterable)localObject2).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label742;
      }
      localObject3 = (Parcelable)((Iterator)localObject2).next();
      if ((localObject3 != null) && ((localObject3 instanceof LocalVideoCropInfoParcelable)))
      {
        this.tfh.add(((LocalVideoCropInfoParcelable)localObject3).skC);
        continue;
        localObject1 = null;
        break;
        label720:
        localObject1 = null;
        break label611;
        label725:
        localObject1 = null;
        break label633;
      }
      this.tfh.add(null);
    }
    label742:
    if (this.tff != null)
    {
      localObject2 = this.tff;
      if (localObject2 == null) {
        d.g.b.p.gfZ();
      }
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject2 = this.tff;
        if (localObject2 == null) {
          d.g.b.p.gfZ();
        }
        if (((ArrayList)localObject2).size() <= 1) {
          break label917;
        }
        localObject2 = this.tfc;
        if (localObject2 == null) {
          d.g.b.p.bcb("mediaCountView");
        }
        ((TextView)localObject2).setVisibility(8);
        localObject2 = this.tfc;
        if (localObject2 == null) {
          d.g.b.p.bcb("mediaCountView");
        }
        localObject3 = this.context;
        localObject4 = this.tff;
        if (localObject4 == null) {
          d.g.b.p.gfZ();
        }
        ((TextView)localObject2).setText((CharSequence)((Context)localObject3).getString(2131759238, new Object[] { Integer.valueOf(((ArrayList)localObject4).size()) }));
        localObject2 = this.tfe;
        if (localObject2 == null) {
          d.g.b.p.bcb("multiIcon");
        }
        ((View)localObject2).setVisibility(0);
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.g.b.c((Runnable)new c(this, (ArrayList)localObject1), "Finder_Post_Create_Media_Thumb");
      AppMethodBeat.o(168610);
      return;
      label917:
      localObject2 = this.tfc;
      if (localObject2 == null) {
        d.g.b.p.bcb("mediaCountView");
      }
      ((TextView)localObject2).setVisibility(8);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168600);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.tfj.cOT();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168600);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(e parame, ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(168607);
      this.tfj.Z(this.tfk);
      AppMethodBeat.o(168607);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$showVideoThumb$1$1"})
  static final class d
    implements Runnable
  {
    d(Bitmap paramBitmap1, e parame, String paramString, boolean paramBoolean, Bitmap paramBitmap2) {}
    
    public final void run()
    {
      AppMethodBeat.i(205807);
      jdField_this.teN.add(this.teW);
      Object localObject = e.tfi;
      ad.i(e.access$getTAG$cp(), "add thumb file");
      if (bool)
      {
        localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
        localObject = com.tencent.mm.plugin.finder.utils.p.fT(this.teY.getWidth(), this.teY.getHeight());
        jdField_this.cOS().getLayoutParams().width = ((Bundle)localObject).getInt("media_layout_width", this.teY.getWidth());
        jdField_this.cOS().getLayoutParams().height = ((Bundle)localObject).getInt("media_layout_height", this.teY.getHeight());
        jdField_this.cOS().setScaleType(android.widget.ImageView.ScaleType.values()[localObject.getInt("media_layout_sale_type", android.widget.ImageView.ScaleType.CENTER_CROP.ordinal())]);
        jdField_this.cOS().requestLayout();
        jdField_this.cOS().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(205805);
            this.tfl.tfj.cOS().setImageBitmap(this.tfl.teV);
            AppMethodBeat.o(205805);
          }
        });
        jdField_this.cOS().setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(205806);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$showVideoThumb$$inlined$let$lambda$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            this.tfl.tfj.cOT();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$showVideoThumb$$inlined$let$lambda$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(205806);
          }
        });
      }
      AppMethodBeat.o(205807);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.e
 * JD-Core Version:    0.7.0.1
 */