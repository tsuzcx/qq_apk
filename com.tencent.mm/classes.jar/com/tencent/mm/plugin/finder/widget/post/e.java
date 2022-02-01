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
import com.tencent.mm.plugin.finder.loader.g;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.protocal.protobuf.bvy;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.bwj;
import com.tencent.mm.protocal.protobuf.dwz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.o;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mediaCountView", "Landroid/widget/TextView;", "getMediaCountView", "()Landroid/widget/TextView;", "setMediaCountView", "(Landroid/widget/TextView;)V", "mediaCropInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "Lkotlin/collections/ArrayList;", "getMediaCropInfoList", "()Ljava/util/ArrayList;", "setMediaCropInfoList", "(Ljava/util/ArrayList;)V", "mediaFileList", "", "getMediaFileList", "setMediaFileList", "mediaTypeList", "", "getMediaTypeList", "setMediaTypeList", "multiIcon", "Landroid/view/View;", "getMultiIcon", "()Landroid/view/View;", "setMultiIcon", "(Landroid/view/View;)V", "reprintIv", "rootView", "thumbFileList", "getThumbFileList", "setThumbFileList", "thumbIv", "Lcom/tencent/mm/view/PhotoView;", "getThumbIv", "()Lcom/tencent/mm/view/PhotoView;", "setThumbIv", "(Lcom/tencent/mm/view/PhotoView;)V", "videoPlayIcon", "Landroid/widget/ImageView;", "getVideoPlayIcon", "()Landroid/widget/ImageView;", "setVideoPlayIcon", "(Landroid/widget/ImageView;)V", "checkData", "", "getThumbFile", "index", "file", "mediaThumbList", "getUploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "inflateView", "initCropInfo", "", "jumpToPreviewMediaUI", "onCreate", "onDestroy", "refresh", "showMediaThumb", "showVideoThumb", "thumbFile", "showThumb", "Companion", "plugin-finder_release"})
public final class e
  extends a
{
  private static final String TAG = "Finder.PostMixMediaWidget";
  public static final a tqb;
  private View kFh;
  private View tpD;
  ArrayList<String> tpG;
  public PhotoView tpU;
  public TextView tpV;
  protected ImageView tpW;
  public View tpX;
  private ArrayList<String> tpY;
  private ArrayList<Integer> tpZ;
  private ArrayList<bwj> tqa;
  
  static
  {
    AppMethodBeat.i(168612);
    tqb = new a((byte)0);
    TAG = "Finder.PostMixMediaWidget";
    AppMethodBeat.o(168612);
  }
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168611);
    this.tpG = new ArrayList();
    this.tqa = new ArrayList();
    AppMethodBeat.o(168611);
  }
  
  public final void Z(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(206424);
    Object localObject1 = this.tpY;
    if (localObject1 == null) {
      d.g.b.p.gkB();
    }
    Iterator localIterator = ((Iterable)localObject1).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (i < 0) {
        j.gkd();
      }
      localObject1 = (String)localObject1;
      final boolean bool;
      label72:
      Object localObject2;
      if (i == 0)
      {
        bool = true;
        d.g.b.p.h(localObject1, "file");
        localObject2 = this.tpZ;
        if (localObject2 == null) {
          d.g.b.p.gkB();
        }
        localObject2 = (Integer)((ArrayList)localObject2).get(i);
        if (localObject2 != null) {
          break label290;
        }
        label109:
        if ((paramArrayList == null) || (paramArrayList.size() <= i) || (bu.isNullOrNil((String)paramArrayList.get(i))) || (!o.fB((String)paramArrayList.get(i)))) {
          break label364;
        }
        localObject1 = paramArrayList.get(i);
        d.g.b.p.g(localObject1, "mediaThumbList[index]");
        localObject1 = (String)localObject1;
      }
      for (;;)
      {
        d.g.b.p.h(localObject1, "thumbFile");
        ae.i(TAG, "showVideoThumb, thumbFile:" + (String)localObject1 + ", showThumb:" + bool);
        if (!bu.isNullOrNil((String)localObject1))
        {
          localObject2 = com.tencent.mm.sdk.platformtools.h.decodeFile((String)localObject1);
          if (localObject2 != null) {
            ar.f((Runnable)new d((Bitmap)localObject2, this, (String)localObject1, bool, (Bitmap)localObject2));
          }
        }
        if (bool)
        {
          localObject1 = this.tpW;
          if (localObject1 == null) {
            d.g.b.p.bdF("videoPlayIcon");
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
        if ((paramArrayList != null) && (paramArrayList.size() > i) && (!bu.isNullOrNil((String)paramArrayList.get(i))))
        {
          localObject1 = paramArrayList.get(i);
          d.g.b.p.g(localObject1, "mediaThumbList[index]");
          localObject1 = (String)localObject1;
        }
        else
        {
          localObject2 = f.sUp;
          localObject1 = f.ajI((String)localObject1);
          continue;
          label364:
          if ((this.tqa.size() > i) && (this.tqa.get(i) != null))
          {
            localObject2 = this.tqa.get(i);
            if (localObject2 == null) {
              d.g.b.p.gkB();
            }
            if (((bwj)localObject2).Hjp != null)
            {
              localObject2 = f.sUp;
              localObject2 = this.tqa.get(i);
              if (localObject2 == null) {
                d.g.b.p.gkB();
              }
              localObject2 = ((bwj)localObject2).Hjp;
              if (localObject2 == null) {
                d.g.b.p.gkB();
              }
              d.g.b.p.g(localObject2, "mediaCropInfoList[index]!!.thumbRect!!");
              localObject1 = f.a((String)localObject1, (dwz)localObject2);
              continue;
            }
          }
          ae.w(TAG, "no thumb & no thumbRect");
          localObject2 = f.sUp;
          localObject1 = f.ajH((String)localObject1);
        }
      }
    }
    AppMethodBeat.o(206424);
  }
  
  public final View cRs()
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
    this.kFh = ((View)localObject);
    localObject = this.kFh;
    if (localObject == null) {
      d.g.b.p.bdF("rootView");
    }
    localObject = ((View)localObject).findViewById(2131305801);
    d.g.b.p.g(localObject, "rootView.findViewById(R.id.thumb_view)");
    this.tpU = ((PhotoView)localObject);
    localObject = this.kFh;
    if (localObject == null) {
      d.g.b.p.bdF("rootView");
    }
    localObject = ((View)localObject).findViewById(2131302214);
    d.g.b.p.g(localObject, "rootView.findViewById(R.id.media_number)");
    this.tpV = ((TextView)localObject);
    localObject = this.kFh;
    if (localObject == null) {
      d.g.b.p.bdF("rootView");
    }
    localObject = ((View)localObject).findViewById(2131306365);
    d.g.b.p.g(localObject, "rootView.findViewById(R.id.video_play_icon)");
    this.tpW = ((ImageView)localObject);
    localObject = this.kFh;
    if (localObject == null) {
      d.g.b.p.bdF("rootView");
    }
    localObject = ((View)localObject).findViewById(2131302563);
    d.g.b.p.g(localObject, "rootView.findViewById(R.id.multi_icon)");
    this.tpX = ((View)localObject);
    localObject = this.kFh;
    if (localObject == null) {
      d.g.b.p.bdF("rootView");
    }
    localObject = ((View)localObject).findViewById(2131304092);
    d.g.b.p.g(localObject, "rootView.findViewById(R.id.reprint_iv)");
    this.tpD = ((View)localObject);
    localObject = this.kFh;
    if (localObject == null) {
      d.g.b.p.bdF("rootView");
    }
    AppMethodBeat.o(168608);
    return localObject;
  }
  
  public final h cRt()
  {
    AppMethodBeat.i(206423);
    if ((this.tpk != null) && (this.tpl != null))
    {
      localObject1 = new h(true, 8, this.tpl);
      AppMethodBeat.o(206423);
      return localObject1;
    }
    Object localObject1 = (Collection)this.tpY;
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
      Object localObject3 = this.tpY;
      if (localObject3 == null) {
        d.g.b.p.gkB();
      }
      ae.i((String)localObject1, ((ArrayList)localObject3).size() + ", thumb list " + this.tpG.size());
      localObject1 = this.tpY;
      if (localObject1 == null) {
        d.g.b.p.gkB();
      }
      if (((ArrayList)localObject1).size() != this.tpG.size()) {
        break label341;
      }
      i = 1;
      if (i == 0) {
        break label443;
      }
      localObject2 = new bvy();
      localObject1 = this.tpY;
      if (localObject1 == null) {
        d.g.b.p.gkB();
      }
      localObject3 = ((Iterable)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject3).hasNext()) {
        break label422;
      }
      localObject1 = ((Iterator)localObject3).next();
      j = i + 1;
      if (i < 0) {
        j.gkd();
      }
      str1 = (String)localObject1;
      localObject1 = this.tpZ;
      if (localObject1 == null) {
        d.g.b.p.gkB();
      }
      localObject1 = (Integer)((ArrayList)localObject1).get(i);
      if (localObject1 != null) {
        break label360;
      }
      localObject4 = ((bvy)localObject2).mediaList;
      localObject1 = com.tencent.mm.plugin.finder.upload.i.sUG;
      str2 = bu.nullAsNil((String)this.tpG.get(i));
      d.g.b.p.g(str2, "Util.nullAsNil(thumbFileList[index])");
      if (this.tqa.size() <= i) {
        break label417;
      }
    }
    label417:
    for (localObject1 = (bwj)this.tqa.get(i);; localObject1 = null)
    {
      ((LinkedList)localObject4).add(com.tencent.mm.plugin.finder.upload.i.a(str1, str2, (bwj)localObject1));
      i = j;
      break label199;
      i = 0;
      break;
      label341:
      i = 0;
      break label161;
      label346:
      ae.i(TAG, "media list null");
      i = 0;
      break label161;
      label360:
      if (((Integer)localObject1).intValue() != 2) {
        break label259;
      }
      localObject1 = ((bvy)localObject2).mediaList;
      localObject4 = com.tencent.mm.plugin.finder.upload.i.sUG;
      localObject4 = this.tpG.get(i);
      d.g.b.p.g(localObject4, "thumbFileList[index]");
      ((LinkedList)localObject1).add(com.tencent.mm.plugin.finder.upload.i.gz(str1, (String)localObject4));
      i = j;
      break label199;
    }
    label422:
    localObject1 = new h(true, 8, (bvy)localObject2);
    AppMethodBeat.o(206423);
    return localObject1;
    label443:
    localObject1 = new h(false, 0, null);
    AppMethodBeat.o(206423);
    return localObject1;
  }
  
  public final PhotoView cRx()
  {
    AppMethodBeat.i(206422);
    PhotoView localPhotoView = this.tpU;
    if (localPhotoView == null) {
      d.g.b.p.bdF("thumbIv");
    }
    AppMethodBeat.o(206422);
    return localPhotoView;
  }
  
  public final void cRy()
  {
    AppMethodBeat.i(206425);
    bvy localbvy = new bvy();
    if (this.tpl != null)
    {
      localObject1 = this.tpl;
      if (localObject1 == null) {
        d.g.b.p.gkB();
      }
      if (!bu.ht((List)((bvy)localObject1).mediaList))
      {
        localObject1 = localbvy.mediaList;
        localObject2 = this.tpl;
        if (localObject2 == null) {
          d.g.b.p.gkB();
        }
        ((LinkedList)localObject1).addAll((Collection)((bvy)localObject2).mediaList);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.sVQ;
        localObject1 = this.context;
        if (localObject1 != null) {
          break label336;
        }
        localObject1 = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(206425);
        throw ((Throwable)localObject1);
      }
    }
    Object localObject1 = this.tpY;
    if (localObject1 == null) {
      d.g.b.p.gkB();
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
        j.gkd();
      }
      localObject3 = (String)localObject1;
      localObject1 = this.tpZ;
      if (localObject1 == null) {
        d.g.b.p.gkB();
      }
      localObject1 = (Integer)((ArrayList)localObject1).get(i);
      if (localObject1 == null)
      {
        localObject4 = localbvy.mediaList;
        localObject1 = com.tencent.mm.plugin.finder.upload.i.sUG;
        str = bu.nullAsNil((String)this.tpG.get(i));
        d.g.b.p.g(str, "Util.nullAsNil(thumbFileList[index])");
        if (this.tqa.size() <= i) {
          break label331;
        }
      }
    }
    label331:
    for (localObject1 = (bwj)this.tqa.get(i);; localObject1 = null)
    {
      ((LinkedList)localObject4).add(com.tencent.mm.plugin.finder.upload.i.a((String)localObject3, str, (bwj)localObject1));
      i = j;
      break label137;
      if (((Integer)localObject1).intValue() != 2) {
        break label197;
      }
      localObject1 = localbvy.mediaList;
      localObject4 = com.tencent.mm.plugin.finder.upload.i.sUG;
      localObject4 = this.tpG.get(i);
      d.g.b.p.g(localObject4, "thumbFileList[index]");
      ((LinkedList)localObject1).add(com.tencent.mm.plugin.finder.upload.i.gz((String)localObject3, (String)localObject4));
      i = j;
      break label137;
      break;
    }
    label336:
    localObject1 = (Activity)localObject1;
    localObject2 = this.tpU;
    if (localObject2 == null) {
      d.g.b.p.bdF("thumbIv");
    }
    localObject2 = (View)localObject2;
    Object localObject3 = this.context;
    if (localObject3 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(206425);
      throw ((Throwable)localObject1);
    }
    localObject3 = ((MMActivity)localObject3).getWindow();
    d.g.b.p.g(localObject3, "(context as MMActivity).window");
    localObject2 = ViewAnimHelper.o((View)localObject2, ((Window)localObject3).getDecorView());
    d.g.b.p.g(localObject2, "ViewAnimHelper.getViewIn…tivity).window.decorView)");
    com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject1, (ViewAnimHelper.ViewInfo)localObject2, localbvy, this.tpk);
    AppMethodBeat.o(206425);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(168610);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (this.tpl != null)
    {
      localObject1 = this.tpl;
      if (localObject1 == null) {
        d.g.b.p.gkB();
      }
      if (!bu.ht((List)((bvy)localObject1).mediaList))
      {
        localObject1 = this.tpD;
        if (localObject1 == null) {
          d.g.b.p.bdF("reprintIv");
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = this.tpl;
        if (localObject1 == null) {
          d.g.b.p.gkB();
        }
        if (((bvy)localObject1).mediaList.size() > 1)
        {
          localObject1 = this.tpV;
          if (localObject1 == null) {
            d.g.b.p.bdF("mediaCountView");
          }
          ((TextView)localObject1).setVisibility(8);
          localObject1 = this.tpV;
          if (localObject1 == null) {
            d.g.b.p.bdF("mediaCountView");
          }
          localObject2 = this.context;
          localObject3 = this.tpl;
          if (localObject3 == null) {
            d.g.b.p.gkB();
          }
          ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getString(2131759238, new Object[] { Integer.valueOf(((bvy)localObject3).mediaList.size()) }));
          localObject1 = this.tpX;
          if (localObject1 == null) {
            d.g.b.p.bdF("multiIcon");
          }
          ((View)localObject1).setVisibility(0);
          localObject1 = this.tpl;
          if (localObject1 == null) {
            d.g.b.p.gkB();
          }
          localObject1 = ((bvy)localObject1).mediaList;
          d.g.b.p.g(localObject1, "refFeedContent!!.mediaList");
          localObject1 = (bvz)((LinkedList)localObject1).getFirst();
          localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
          localObject2 = com.tencent.mm.plugin.finder.utils.p.fT((int)((bvz)localObject1).width, (int)((bvz)localObject1).height);
          localObject3 = this.tpU;
          if (localObject3 == null) {
            d.g.b.p.bdF("thumbIv");
          }
          ((PhotoView)localObject3).getLayoutParams().width = ((Bundle)localObject2).getInt("media_layout_width", (int)((bvz)localObject1).width);
          localObject3 = this.tpU;
          if (localObject3 == null) {
            d.g.b.p.bdF("thumbIv");
          }
          ((PhotoView)localObject3).getLayoutParams().height = ((Bundle)localObject2).getInt("media_layout_height", (int)((bvz)localObject1).height);
          localObject3 = this.tpU;
          if (localObject3 == null) {
            d.g.b.p.bdF("thumbIv");
          }
          ((PhotoView)localObject3).setScaleType(android.widget.ImageView.ScaleType.values()[localObject2.getInt("media_layout_sale_type", android.widget.ImageView.ScaleType.CENTER_CROP.ordinal())]);
          localObject2 = this.tpU;
          if (localObject2 == null) {
            d.g.b.p.bdF("thumbIv");
          }
          ((PhotoView)localObject2).requestLayout();
          if (((bvz)localObject1).mediaType != 4) {
            break label498;
          }
          d.g.b.p.g(localObject1, "mediaObj");
          localObject1 = new g((bvz)localObject1, r.sJv);
          localObject2 = com.tencent.mm.plugin.finder.loader.i.srW;
          localObject2 = com.tencent.mm.plugin.finder.loader.i.cEn();
          localObject3 = this.tpU;
          if (localObject3 == null) {
            d.g.b.p.bdF("thumbIv");
          }
          if (localObject3 == null) {
            d.g.b.p.gkB();
          }
          localObject3 = (ImageView)localObject3;
          localObject4 = com.tencent.mm.plugin.finder.loader.i.srW;
          ((d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.i.a(i.a.srX));
        }
        for (;;)
        {
          localObject1 = this.tpU;
          if (localObject1 == null) {
            d.g.b.p.bdF("thumbIv");
          }
          ((PhotoView)localObject1).setOnClickListener((View.OnClickListener)new b(this));
          AppMethodBeat.o(168610);
          return;
          localObject1 = this.tpV;
          if (localObject1 == null) {
            d.g.b.p.bdF("mediaCountView");
          }
          ((TextView)localObject1).setVisibility(8);
          break;
          label498:
          d.g.b.p.g(localObject1, "mediaObj");
          localObject1 = new g((bvz)localObject1, r.sJv);
          localObject2 = com.tencent.mm.plugin.finder.loader.i.srW;
          localObject2 = com.tencent.mm.plugin.finder.loader.i.cEn();
          localObject3 = this.tpU;
          if (localObject3 == null) {
            d.g.b.p.bdF("thumbIv");
          }
          if (localObject3 == null) {
            d.g.b.p.gkB();
          }
          localObject3 = (ImageView)localObject3;
          localObject4 = com.tencent.mm.plugin.finder.loader.i.srW;
          ((d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.i.a(i.a.srX));
        }
      }
    }
    Object localObject1 = this.dyY;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getStringArrayList("MEDIA_FILE_LIST");
      this.tpY = ((ArrayList)localObject1);
      localObject1 = this.dyY;
      if (localObject1 == null) {
        break label720;
      }
      localObject1 = ((Bundle)localObject1).getIntegerArrayList("MEDIA_TYPE_LIST");
      label611:
      this.tpZ = ((ArrayList)localObject1);
      localObject1 = this.dyY;
      if (localObject1 == null) {
        break label725;
      }
      localObject1 = ((Bundle)localObject1).getStringArrayList("MEDIA_THUMB_LIST");
      label633:
      localObject2 = this.dyY;
      if (localObject2 == null) {
        d.g.b.p.gkB();
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
        this.tqa.add(((LocalVideoCropInfoParcelable)localObject3).stz);
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
      this.tqa.add(null);
    }
    label742:
    if (this.tpY != null)
    {
      localObject2 = this.tpY;
      if (localObject2 == null) {
        d.g.b.p.gkB();
      }
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject2 = this.tpY;
        if (localObject2 == null) {
          d.g.b.p.gkB();
        }
        if (((ArrayList)localObject2).size() <= 1) {
          break label917;
        }
        localObject2 = this.tpV;
        if (localObject2 == null) {
          d.g.b.p.bdF("mediaCountView");
        }
        ((TextView)localObject2).setVisibility(8);
        localObject2 = this.tpV;
        if (localObject2 == null) {
          d.g.b.p.bdF("mediaCountView");
        }
        localObject3 = this.context;
        localObject4 = this.tpY;
        if (localObject4 == null) {
          d.g.b.p.gkB();
        }
        ((TextView)localObject2).setText((CharSequence)((Context)localObject3).getString(2131759238, new Object[] { Integer.valueOf(((ArrayList)localObject4).size()) }));
        localObject2 = this.tpX;
        if (localObject2 == null) {
          d.g.b.p.bdF("multiIcon");
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
      localObject2 = this.tpV;
      if (localObject2 == null) {
        d.g.b.p.bdF("mediaCountView");
      }
      ((TextView)localObject2).setVisibility(8);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168600);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.tqc.cRy();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168600);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(e parame, ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(168607);
      this.tqc.Z(this.tqd);
      AppMethodBeat.o(168607);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$showVideoThumb$1$1"})
  static final class d
    implements Runnable
  {
    d(Bitmap paramBitmap1, e parame, String paramString, boolean paramBoolean, Bitmap paramBitmap2) {}
    
    public final void run()
    {
      AppMethodBeat.i(206421);
      jdField_this.tpG.add(this.tpP);
      Object localObject = e.tqb;
      ae.i(e.access$getTAG$cp(), "add thumb file");
      if (bool)
      {
        localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
        localObject = com.tencent.mm.plugin.finder.utils.p.fT(this.tpR.getWidth(), this.tpR.getHeight());
        jdField_this.cRx().getLayoutParams().width = ((Bundle)localObject).getInt("media_layout_width", this.tpR.getWidth());
        jdField_this.cRx().getLayoutParams().height = ((Bundle)localObject).getInt("media_layout_height", this.tpR.getHeight());
        jdField_this.cRx().setScaleType(android.widget.ImageView.ScaleType.values()[localObject.getInt("media_layout_sale_type", android.widget.ImageView.ScaleType.CENTER_CROP.ordinal())]);
        jdField_this.cRx().requestLayout();
        jdField_this.cRx().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(206419);
            this.tqe.tqc.cRx().setImageBitmap(this.tqe.tpO);
            AppMethodBeat.o(206419);
          }
        });
        jdField_this.cRx().setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(206420);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$showVideoThumb$$inlined$let$lambda$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            this.tqe.tqc.cRy();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$showVideoThumb$$inlined$let$lambda$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(206420);
          }
        });
      }
      AppMethodBeat.o(206421);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.e
 * JD-Core Version:    0.7.0.1
 */