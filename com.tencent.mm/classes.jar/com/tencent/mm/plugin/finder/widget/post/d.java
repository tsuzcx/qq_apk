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
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.upload.e;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.protocal.protobuf.bmc;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.protocal.protobuf.dkt;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.PhotoView;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mediaCountView", "Landroid/widget/TextView;", "getMediaCountView", "()Landroid/widget/TextView;", "setMediaCountView", "(Landroid/widget/TextView;)V", "mediaCropInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "Lkotlin/collections/ArrayList;", "getMediaCropInfoList", "()Ljava/util/ArrayList;", "setMediaCropInfoList", "(Ljava/util/ArrayList;)V", "mediaFileList", "", "getMediaFileList", "setMediaFileList", "mediaTypeList", "", "getMediaTypeList", "setMediaTypeList", "multiIcon", "Landroid/view/View;", "getMultiIcon", "()Landroid/view/View;", "setMultiIcon", "(Landroid/view/View;)V", "reprintIv", "rootView", "thumbFileList", "getThumbFileList", "setThumbFileList", "thumbIv", "Lcom/tencent/mm/view/PhotoView;", "getThumbIv", "()Lcom/tencent/mm/view/PhotoView;", "setThumbIv", "(Lcom/tencent/mm/view/PhotoView;)V", "videoPlayIcon", "Landroid/widget/ImageView;", "getVideoPlayIcon", "()Landroid/widget/ImageView;", "setVideoPlayIcon", "(Landroid/widget/ImageView;)V", "checkData", "", "getThumbFile", "index", "file", "mediaThumbList", "getUploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "inflateView", "initCropInfo", "", "jumpToPreviewMediaUI", "onCreate", "onDestroy", "refresh", "showMediaThumb", "showVideoThumb", "thumbFile", "showThumb", "Companion", "plugin-finder_release"})
public final class d
  extends a
{
  private static final String TAG = "Finder.PostMixMediaWidget";
  public static final a ray;
  private View jGG;
  private View rac;
  ArrayList<String> rae;
  public PhotoView rar;
  public TextView ras;
  protected ImageView rat;
  public View rau;
  private ArrayList<String> rav;
  private ArrayList<Integer> raw;
  private ArrayList<bmm> rax;
  
  static
  {
    AppMethodBeat.i(168612);
    ray = new a((byte)0);
    TAG = "Finder.PostMixMediaWidget";
    AppMethodBeat.o(168612);
  }
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168611);
    this.rae = new ArrayList();
    this.rax = new ArrayList();
    AppMethodBeat.o(168611);
  }
  
  public final void ba(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(200748);
    Object localObject1 = this.rav;
    if (localObject1 == null) {
      k.fvU();
    }
    Iterator localIterator = ((Iterable)localObject1).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (i < 0) {
        j.fvx();
      }
      localObject1 = (String)localObject1;
      final boolean bool;
      label72:
      Object localObject2;
      if (i == 0)
      {
        bool = true;
        k.h(localObject1, "file");
        localObject2 = this.raw;
        if (localObject2 == null) {
          k.fvU();
        }
        localObject2 = (Integer)((ArrayList)localObject2).get(i);
        if (localObject2 != null) {
          break label290;
        }
        label109:
        if ((paramArrayList == null) || (paramArrayList.size() <= i) || (bt.isNullOrNil((String)paramArrayList.get(i))) || (!com.tencent.mm.vfs.i.eK((String)paramArrayList.get(i)))) {
          break label364;
        }
        localObject1 = paramArrayList.get(i);
        k.g(localObject1, "mediaThumbList[index]");
        localObject1 = (String)localObject1;
      }
      for (;;)
      {
        k.h(localObject1, "thumbFile");
        ad.i(TAG, "showVideoThumb, thumbFile:" + (String)localObject1 + ", showThumb:" + bool);
        if (!bt.isNullOrNil((String)localObject1))
        {
          localObject2 = com.tencent.mm.sdk.platformtools.f.decodeFile((String)localObject1);
          if (localObject2 != null) {
            aq.f((Runnable)new d((Bitmap)localObject2, this, (String)localObject1, bool, (Bitmap)localObject2));
          }
        }
        if (bool)
        {
          localObject1 = this.rat;
          if (localObject1 == null) {
            k.aPZ("videoPlayIcon");
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
          k.g(localObject1, "mediaThumbList[index]");
          localObject1 = (String)localObject1;
        }
        else
        {
          localObject2 = e.qQW;
          localObject1 = e.aVF((String)localObject1);
          continue;
          label364:
          if ((this.rax.size() > i) && (this.rax.get(i) != null))
          {
            localObject2 = e.qQW;
            localObject2 = this.rax.get(i);
            if (localObject2 == null) {
              k.fvU();
            }
            localObject2 = ((bmm)localObject2).DJW;
            k.g(localObject2, "mediaCropInfoList[index]!!.thumbRect");
            localObject1 = e.a((String)localObject1, (dkt)localObject2);
          }
          else
          {
            ad.w(TAG, "no thumb & no thumbRect");
            localObject2 = e.qQW;
            localObject1 = e.ZE((String)localObject1);
          }
        }
      }
    }
    AppMethodBeat.o(200748);
  }
  
  public final View ctv()
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
    k.g(localObject, "(context as Activity).la…_post_media_widget, null)");
    this.jGG = ((View)localObject);
    localObject = this.jGG;
    if (localObject == null) {
      k.aPZ("rootView");
    }
    localObject = ((View)localObject).findViewById(2131305801);
    k.g(localObject, "rootView.findViewById(R.id.thumb_view)");
    this.rar = ((PhotoView)localObject);
    localObject = this.jGG;
    if (localObject == null) {
      k.aPZ("rootView");
    }
    localObject = ((View)localObject).findViewById(2131302214);
    k.g(localObject, "rootView.findViewById(R.id.media_number)");
    this.ras = ((TextView)localObject);
    localObject = this.jGG;
    if (localObject == null) {
      k.aPZ("rootView");
    }
    localObject = ((View)localObject).findViewById(2131306365);
    k.g(localObject, "rootView.findViewById(R.id.video_play_icon)");
    this.rat = ((ImageView)localObject);
    localObject = this.jGG;
    if (localObject == null) {
      k.aPZ("rootView");
    }
    localObject = ((View)localObject).findViewById(2131302563);
    k.g(localObject, "rootView.findViewById(R.id.multi_icon)");
    this.rau = ((View)localObject);
    localObject = this.jGG;
    if (localObject == null) {
      k.aPZ("rootView");
    }
    localObject = ((View)localObject).findViewById(2131304092);
    k.g(localObject, "rootView.findViewById(R.id.reprint_iv)");
    this.rac = ((View)localObject);
    localObject = this.jGG;
    if (localObject == null) {
      k.aPZ("rootView");
    }
    AppMethodBeat.o(168608);
    return localObject;
  }
  
  public final h fXI()
  {
    AppMethodBeat.i(200747);
    if ((this.qOO != null) && (this.qZS != null))
    {
      localObject1 = new h(true, 8, this.qZS);
      AppMethodBeat.o(200747);
      return localObject1;
    }
    Object localObject1 = (Collection)this.rav;
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
      Object localObject3 = this.rav;
      if (localObject3 == null) {
        k.fvU();
      }
      ad.i((String)localObject1, ((ArrayList)localObject3).size() + ", thumb list " + this.rae.size());
      localObject1 = this.rav;
      if (localObject1 == null) {
        k.fvU();
      }
      if (((ArrayList)localObject1).size() != this.rae.size()) {
        break label341;
      }
      i = 1;
      if (i == 0) {
        break label443;
      }
      localObject2 = new bmc();
      localObject1 = this.rav;
      if (localObject1 == null) {
        k.fvU();
      }
      localObject3 = ((Iterable)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject3).hasNext()) {
        break label422;
      }
      localObject1 = ((Iterator)localObject3).next();
      j = i + 1;
      if (i < 0) {
        j.fvx();
      }
      str1 = (String)localObject1;
      localObject1 = this.raw;
      if (localObject1 == null) {
        k.fvU();
      }
      localObject1 = (Integer)((ArrayList)localObject1).get(i);
      if (localObject1 != null) {
        break label360;
      }
      localObject4 = ((bmc)localObject2).mediaList;
      localObject1 = com.tencent.mm.plugin.finder.upload.h.qRq;
      str2 = bt.nullAsNil((String)this.rae.get(i));
      k.g(str2, "Util.nullAsNil(thumbFileList[index])");
      if (this.rax.size() <= i) {
        break label417;
      }
    }
    label417:
    for (localObject1 = (bmm)this.rax.get(i);; localObject1 = null)
    {
      ((LinkedList)localObject4).add(com.tencent.mm.plugin.finder.upload.h.a(str1, str2, (bmm)localObject1));
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
      localObject1 = ((bmc)localObject2).mediaList;
      localObject4 = com.tencent.mm.plugin.finder.upload.h.qRq;
      localObject4 = this.rae.get(i);
      k.g(localObject4, "thumbFileList[index]");
      ((LinkedList)localObject1).add(com.tencent.mm.plugin.finder.upload.h.mR(str1, (String)localObject4));
      i = j;
      break label199;
    }
    label422:
    localObject1 = new h(true, 8, (bmc)localObject2);
    AppMethodBeat.o(200747);
    return localObject1;
    label443:
    localObject1 = new h(false, 0, null);
    AppMethodBeat.o(200747);
    return localObject1;
  }
  
  public final PhotoView fXJ()
  {
    AppMethodBeat.i(200746);
    PhotoView localPhotoView = this.rar;
    if (localPhotoView == null) {
      k.aPZ("thumbIv");
    }
    AppMethodBeat.o(200746);
    return localPhotoView;
  }
  
  public final void fXK()
  {
    AppMethodBeat.i(200749);
    bmc localbmc = new bmc();
    if (this.qZS != null)
    {
      localObject1 = this.qZS;
      if (localObject1 == null) {
        k.fvU();
      }
      if (!bt.gL((List)((bmc)localObject1).mediaList))
      {
        localObject1 = localbmc.mediaList;
        localObject2 = this.qZS;
        if (localObject2 == null) {
          k.fvU();
        }
        ((LinkedList)localObject1).addAll((Collection)((bmc)localObject2).mediaList);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.qSb;
        localObject1 = this.context;
        if (localObject1 != null) {
          break label336;
        }
        localObject1 = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(200749);
        throw ((Throwable)localObject1);
      }
    }
    Object localObject1 = this.rav;
    if (localObject1 == null) {
      k.fvU();
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
        j.fvx();
      }
      localObject3 = (String)localObject1;
      localObject1 = this.raw;
      if (localObject1 == null) {
        k.fvU();
      }
      localObject1 = (Integer)((ArrayList)localObject1).get(i);
      if (localObject1 == null)
      {
        localObject4 = localbmc.mediaList;
        localObject1 = com.tencent.mm.plugin.finder.upload.h.qRq;
        str = bt.nullAsNil((String)this.rae.get(i));
        k.g(str, "Util.nullAsNil(thumbFileList[index])");
        if (this.rax.size() <= i) {
          break label331;
        }
      }
    }
    label331:
    for (localObject1 = (bmm)this.rax.get(i);; localObject1 = null)
    {
      ((LinkedList)localObject4).add(com.tencent.mm.plugin.finder.upload.h.a((String)localObject3, str, (bmm)localObject1));
      i = j;
      break label137;
      if (((Integer)localObject1).intValue() != 2) {
        break label197;
      }
      localObject1 = localbmc.mediaList;
      localObject4 = com.tencent.mm.plugin.finder.upload.h.qRq;
      localObject4 = this.rae.get(i);
      k.g(localObject4, "thumbFileList[index]");
      ((LinkedList)localObject1).add(com.tencent.mm.plugin.finder.upload.h.mR((String)localObject3, (String)localObject4));
      i = j;
      break label137;
      break;
    }
    label336:
    localObject1 = (Activity)localObject1;
    localObject2 = this.rar;
    if (localObject2 == null) {
      k.aPZ("thumbIv");
    }
    localObject2 = (View)localObject2;
    Object localObject3 = this.context;
    if (localObject3 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(200749);
      throw ((Throwable)localObject1);
    }
    localObject3 = ((MMActivity)localObject3).getWindow();
    k.g(localObject3, "(context as MMActivity).window");
    localObject2 = ViewAnimHelper.m((View)localObject2, ((Window)localObject3).getDecorView());
    k.g(localObject2, "ViewAnimHelper.getViewIn…tivity).window.decorView)");
    com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject1, (ViewAnimHelper.ViewInfo)localObject2, localbmc, this.qOO);
    AppMethodBeat.o(200749);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(168610);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (this.qZS != null)
    {
      localObject1 = this.qZS;
      if (localObject1 == null) {
        k.fvU();
      }
      if (!bt.gL((List)((bmc)localObject1).mediaList))
      {
        localObject1 = this.rac;
        if (localObject1 == null) {
          k.aPZ("reprintIv");
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = this.qZS;
        if (localObject1 == null) {
          k.fvU();
        }
        if (((bmc)localObject1).mediaList.size() > 1)
        {
          localObject1 = this.ras;
          if (localObject1 == null) {
            k.aPZ("mediaCountView");
          }
          ((TextView)localObject1).setVisibility(8);
          localObject1 = this.ras;
          if (localObject1 == null) {
            k.aPZ("mediaCountView");
          }
          localObject2 = this.context;
          localObject3 = this.qZS;
          if (localObject3 == null) {
            k.fvU();
          }
          ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getString(2131759238, new Object[] { Integer.valueOf(((bmc)localObject3).mediaList.size()) }));
          localObject1 = this.rau;
          if (localObject1 == null) {
            k.aPZ("multiIcon");
          }
          ((View)localObject1).setVisibility(0);
          localObject1 = this.qZS;
          if (localObject1 == null) {
            k.fvU();
          }
          localObject1 = ((bmc)localObject1).mediaList;
          k.g(localObject1, "refFeedContent!!.mediaList");
          localObject1 = (bmd)((LinkedList)localObject1).getFirst();
          localObject2 = com.tencent.mm.plugin.finder.utils.i.qTa;
          localObject2 = com.tencent.mm.plugin.finder.utils.i.fB((int)((bmd)localObject1).width, (int)((bmd)localObject1).height);
          localObject3 = this.rar;
          if (localObject3 == null) {
            k.aPZ("thumbIv");
          }
          ((PhotoView)localObject3).getLayoutParams().width = ((Bundle)localObject2).getInt("media_layout_width", (int)((bmd)localObject1).width);
          localObject3 = this.rar;
          if (localObject3 == null) {
            k.aPZ("thumbIv");
          }
          ((PhotoView)localObject3).getLayoutParams().height = ((Bundle)localObject2).getInt("media_layout_height", (int)((bmd)localObject1).height);
          localObject3 = this.rar;
          if (localObject3 == null) {
            k.aPZ("thumbIv");
          }
          ((PhotoView)localObject3).setScaleType(android.widget.ImageView.ScaleType.values()[localObject2.getInt("media_layout_sale_type", android.widget.ImageView.ScaleType.CENTER_CROP.ordinal())]);
          localObject2 = this.rar;
          if (localObject2 == null) {
            k.aPZ("thumbIv");
          }
          ((PhotoView)localObject2).requestLayout();
          if (((bmd)localObject1).mediaType != 4) {
            break label498;
          }
          k.g(localObject1, "mediaObj");
          localObject1 = new com.tencent.mm.plugin.finder.loader.f((bmd)localObject1, com.tencent.mm.plugin.finder.storage.h.qJZ);
          localObject2 = com.tencent.mm.plugin.finder.loader.h.qCF;
          localObject2 = com.tencent.mm.plugin.finder.loader.h.cmU();
          localObject3 = this.rar;
          if (localObject3 == null) {
            k.aPZ("thumbIv");
          }
          if (localObject3 == null) {
            k.fvU();
          }
          localObject3 = (ImageView)localObject3;
          localObject4 = com.tencent.mm.plugin.finder.loader.h.qCF;
          ((com.tencent.mm.loader.d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCG));
        }
        for (;;)
        {
          localObject1 = this.rar;
          if (localObject1 == null) {
            k.aPZ("thumbIv");
          }
          ((PhotoView)localObject1).setOnClickListener((View.OnClickListener)new b(this));
          AppMethodBeat.o(168610);
          return;
          localObject1 = this.ras;
          if (localObject1 == null) {
            k.aPZ("mediaCountView");
          }
          ((TextView)localObject1).setVisibility(8);
          break;
          label498:
          k.g(localObject1, "mediaObj");
          localObject1 = new com.tencent.mm.plugin.finder.loader.f((bmd)localObject1, com.tencent.mm.plugin.finder.storage.h.qJZ);
          localObject2 = com.tencent.mm.plugin.finder.loader.h.qCF;
          localObject2 = com.tencent.mm.plugin.finder.loader.h.cmU();
          localObject3 = this.rar;
          if (localObject3 == null) {
            k.aPZ("thumbIv");
          }
          if (localObject3 == null) {
            k.fvU();
          }
          localObject3 = (ImageView)localObject3;
          localObject4 = com.tencent.mm.plugin.finder.loader.h.qCF;
          ((com.tencent.mm.loader.d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCG));
        }
      }
    }
    Object localObject1 = this.dow;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getStringArrayList("MEDIA_FILE_LIST");
      this.rav = ((ArrayList)localObject1);
      localObject1 = this.dow;
      if (localObject1 == null) {
        break label720;
      }
      localObject1 = ((Bundle)localObject1).getIntegerArrayList("MEDIA_TYPE_LIST");
      label611:
      this.raw = ((ArrayList)localObject1);
      localObject1 = this.dow;
      if (localObject1 == null) {
        break label725;
      }
      localObject1 = ((Bundle)localObject1).getStringArrayList("MEDIA_THUMB_LIST");
      label633:
      localObject2 = this.dow;
      if (localObject2 == null) {
        k.fvU();
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
        this.rax.add(((LocalVideoCropInfoParcelable)localObject3).qDR);
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
      this.rax.add(null);
    }
    label742:
    if (this.rav != null)
    {
      localObject2 = this.rav;
      if (localObject2 == null) {
        k.fvU();
      }
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject2 = this.rav;
        if (localObject2 == null) {
          k.fvU();
        }
        if (((ArrayList)localObject2).size() <= 1) {
          break label917;
        }
        localObject2 = this.ras;
        if (localObject2 == null) {
          k.aPZ("mediaCountView");
        }
        ((TextView)localObject2).setVisibility(8);
        localObject2 = this.ras;
        if (localObject2 == null) {
          k.aPZ("mediaCountView");
        }
        localObject3 = this.context;
        localObject4 = this.rav;
        if (localObject4 == null) {
          k.fvU();
        }
        ((TextView)localObject2).setText((CharSequence)((Context)localObject3).getString(2131759238, new Object[] { Integer.valueOf(((ArrayList)localObject4).size()) }));
        localObject2 = this.rau;
        if (localObject2 == null) {
          k.aPZ("multiIcon");
        }
        ((View)localObject2).setVisibility(0);
      }
    }
    for (;;)
    {
      b.c((Runnable)new c(this, (ArrayList)localObject1), "Finder_Post_Create_Media_Thumb");
      AppMethodBeat.o(168610);
      return;
      label917:
      localObject2 = this.ras;
      if (localObject2 == null) {
        k.aPZ("mediaCountView");
      }
      ((TextView)localObject2).setVisibility(8);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168600);
      this.raz.fXK();
      AppMethodBeat.o(168600);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(d paramd, ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(168607);
      this.raz.ba(this.raA);
      AppMethodBeat.o(168607);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$showVideoThumb$1$1"})
  static final class d
    implements Runnable
  {
    d(Bitmap paramBitmap1, d paramd, String paramString, boolean paramBoolean, Bitmap paramBitmap2) {}
    
    public final void run()
    {
      AppMethodBeat.i(200745);
      jdField_this.rae.add(this.ram);
      Object localObject = d.ray;
      ad.i(d.access$getTAG$cp(), "add thumb file");
      if (bool)
      {
        localObject = com.tencent.mm.plugin.finder.utils.i.qTa;
        localObject = com.tencent.mm.plugin.finder.utils.i.fB(this.rao.getWidth(), this.rao.getHeight());
        jdField_this.fXJ().getLayoutParams().width = ((Bundle)localObject).getInt("media_layout_width", this.rao.getWidth());
        jdField_this.fXJ().getLayoutParams().height = ((Bundle)localObject).getInt("media_layout_height", this.rao.getHeight());
        jdField_this.fXJ().setScaleType(android.widget.ImageView.ScaleType.values()[localObject.getInt("media_layout_sale_type", android.widget.ImageView.ScaleType.CENTER_CROP.ordinal())]);
        jdField_this.fXJ().requestLayout();
        jdField_this.fXJ().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(200743);
            this.LlV.raz.fXJ().setImageBitmap(this.LlV.ral);
            AppMethodBeat.o(200743);
          }
        });
        jdField_this.fXJ().setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(200744);
            this.LlV.raz.fXK();
            AppMethodBeat.o(200744);
          }
        });
      }
      AppMethodBeat.o(200745);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.d
 * JD-Core Version:    0.7.0.1
 */