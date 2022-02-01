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
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.brc;
import com.tencent.mm.protocal.protobuf.dqk;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.i;
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mediaCountView", "Landroid/widget/TextView;", "getMediaCountView", "()Landroid/widget/TextView;", "setMediaCountView", "(Landroid/widget/TextView;)V", "mediaCropInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "Lkotlin/collections/ArrayList;", "getMediaCropInfoList", "()Ljava/util/ArrayList;", "setMediaCropInfoList", "(Ljava/util/ArrayList;)V", "mediaFileList", "", "getMediaFileList", "setMediaFileList", "mediaTypeList", "", "getMediaTypeList", "setMediaTypeList", "multiIcon", "Landroid/view/View;", "getMultiIcon", "()Landroid/view/View;", "setMultiIcon", "(Landroid/view/View;)V", "reprintIv", "rootView", "thumbFileList", "getThumbFileList", "setThumbFileList", "thumbIv", "Lcom/tencent/mm/view/PhotoView;", "getThumbIv", "()Lcom/tencent/mm/view/PhotoView;", "setThumbIv", "(Lcom/tencent/mm/view/PhotoView;)V", "videoPlayIcon", "Landroid/widget/ImageView;", "getVideoPlayIcon", "()Landroid/widget/ImageView;", "setVideoPlayIcon", "(Landroid/widget/ImageView;)V", "checkData", "", "getThumbFile", "index", "file", "mediaThumbList", "getUploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "inflateView", "initCropInfo", "", "jumpToPreviewMediaUI", "onCreate", "onDestroy", "refresh", "showMediaThumb", "showVideoThumb", "thumbFile", "showThumb", "Companion", "plugin-finder_release"})
public final class e
  extends a
{
  private static final String TAG = "Finder.PostMixMediaWidget";
  public static final a siJ;
  private View khe;
  public PhotoView siC;
  public TextView siD;
  protected ImageView siE;
  public View siF;
  private ArrayList<String> siG;
  private ArrayList<Integer> siH;
  private ArrayList<brc> siI;
  private View sio;
  ArrayList<String> siq;
  
  static
  {
    AppMethodBeat.i(168612);
    siJ = new a((byte)0);
    TAG = "Finder.PostMixMediaWidget";
    AppMethodBeat.o(168612);
  }
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168611);
    this.siq = new ArrayList();
    this.siI = new ArrayList();
    AppMethodBeat.o(168611);
  }
  
  public final void aa(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(204876);
    Object localObject1 = this.siG;
    if (localObject1 == null) {
      k.fOy();
    }
    Iterator localIterator = ((Iterable)localObject1).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (i < 0) {
        j.fOc();
      }
      localObject1 = (String)localObject1;
      boolean bool;
      label72:
      Object localObject2;
      if (i == 0)
      {
        bool = true;
        k.h(localObject1, "file");
        localObject2 = this.siH;
        if (localObject2 == null) {
          k.fOy();
        }
        localObject2 = (Integer)((ArrayList)localObject2).get(i);
        if (localObject2 != null) {
          break label289;
        }
        label109:
        if ((paramArrayList == null) || (paramArrayList.size() <= i) || (bs.isNullOrNil((String)paramArrayList.get(i))) || (!i.eA((String)paramArrayList.get(i)))) {
          break label363;
        }
        localObject1 = paramArrayList.get(i);
        k.g(localObject1, "mediaThumbList[index]");
        localObject1 = (String)localObject1;
      }
      for (;;)
      {
        k.h(localObject1, "thumbFile");
        ac.i(TAG, "showVideoThumb, thumbFile:" + (String)localObject1 + ", showThumb:" + bool);
        if (!bs.isNullOrNil((String)localObject1))
        {
          localObject2 = com.tencent.mm.sdk.platformtools.f.decodeFile((String)localObject1);
          if (localObject2 != null) {
            ap.f((Runnable)new e.d((Bitmap)localObject2, this, (String)localObject1, bool, (Bitmap)localObject2));
          }
        }
        if (bool)
        {
          localObject1 = this.siE;
          if (localObject1 == null) {
            k.aVY("videoPlayIcon");
          }
          ((ImageView)localObject1).setVisibility(8);
        }
        i += 1;
        break;
        bool = false;
        break label72;
        label289:
        if (((Integer)localObject2).intValue() != 2) {
          break label109;
        }
        if ((paramArrayList != null) && (paramArrayList.size() > i) && (!bs.isNullOrNil((String)paramArrayList.get(i))))
        {
          localObject1 = paramArrayList.get(i);
          k.g(localObject1, "mediaThumbList[index]");
          localObject1 = (String)localObject1;
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.finder.upload.e.rMX;
          localObject1 = com.tencent.mm.plugin.finder.upload.e.aer((String)localObject1);
          continue;
          label363:
          if ((this.siI.size() > i) && (this.siI.get(i) != null))
          {
            localObject2 = com.tencent.mm.plugin.finder.upload.e.rMX;
            localObject2 = this.siI.get(i);
            if (localObject2 == null) {
              k.fOy();
            }
            localObject2 = ((brc)localObject2).Fgl;
            k.g(localObject2, "mediaCropInfoList[index]!!.thumbRect");
            localObject1 = com.tencent.mm.plugin.finder.upload.e.a((String)localObject1, (dqk)localObject2);
          }
          else
          {
            ac.w(TAG, "no thumb & no thumbRect");
            localObject2 = com.tencent.mm.plugin.finder.upload.e.rMX;
            localObject1 = com.tencent.mm.plugin.finder.upload.e.aeq((String)localObject1);
          }
        }
      }
    }
    AppMethodBeat.o(204876);
  }
  
  public final View cGA()
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
    this.khe = ((View)localObject);
    localObject = this.khe;
    if (localObject == null) {
      k.aVY("rootView");
    }
    localObject = ((View)localObject).findViewById(2131305801);
    k.g(localObject, "rootView.findViewById(R.id.thumb_view)");
    this.siC = ((PhotoView)localObject);
    localObject = this.khe;
    if (localObject == null) {
      k.aVY("rootView");
    }
    localObject = ((View)localObject).findViewById(2131302214);
    k.g(localObject, "rootView.findViewById(R.id.media_number)");
    this.siD = ((TextView)localObject);
    localObject = this.khe;
    if (localObject == null) {
      k.aVY("rootView");
    }
    localObject = ((View)localObject).findViewById(2131306365);
    k.g(localObject, "rootView.findViewById(R.id.video_play_icon)");
    this.siE = ((ImageView)localObject);
    localObject = this.khe;
    if (localObject == null) {
      k.aVY("rootView");
    }
    localObject = ((View)localObject).findViewById(2131302563);
    k.g(localObject, "rootView.findViewById(R.id.multi_icon)");
    this.siF = ((View)localObject);
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
    AppMethodBeat.o(168608);
    return localObject;
  }
  
  public final h cGB()
  {
    AppMethodBeat.i(204875);
    if ((this.shV != null) && (this.shW != null))
    {
      localObject1 = new h(true, 8, this.shW);
      AppMethodBeat.o(204875);
      return localObject1;
    }
    Object localObject1 = (Collection)this.siG;
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
      Object localObject3 = this.siG;
      if (localObject3 == null) {
        k.fOy();
      }
      ac.i((String)localObject1, ((ArrayList)localObject3).size() + ", thumb list " + this.siq.size());
      localObject1 = this.siG;
      if (localObject1 == null) {
        k.fOy();
      }
      if (((ArrayList)localObject1).size() != this.siq.size()) {
        break label341;
      }
      i = 1;
      if (i == 0) {
        break label443;
      }
      localObject2 = new bqr();
      localObject1 = this.siG;
      if (localObject1 == null) {
        k.fOy();
      }
      localObject3 = ((Iterable)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject3).hasNext()) {
        break label422;
      }
      localObject1 = ((Iterator)localObject3).next();
      j = i + 1;
      if (i < 0) {
        j.fOc();
      }
      str1 = (String)localObject1;
      localObject1 = this.siH;
      if (localObject1 == null) {
        k.fOy();
      }
      localObject1 = (Integer)((ArrayList)localObject1).get(i);
      if (localObject1 != null) {
        break label360;
      }
      localObject4 = ((bqr)localObject2).mediaList;
      localObject1 = com.tencent.mm.plugin.finder.upload.h.rNr;
      str2 = bs.nullAsNil((String)this.siq.get(i));
      k.g(str2, "Util.nullAsNil(thumbFileList[index])");
      if (this.siI.size() <= i) {
        break label417;
      }
    }
    label417:
    for (localObject1 = (brc)this.siI.get(i);; localObject1 = null)
    {
      ((LinkedList)localObject4).add(com.tencent.mm.plugin.finder.upload.h.a(str1, str2, (brc)localObject1));
      i = j;
      break label199;
      i = 0;
      break;
      label341:
      i = 0;
      break label161;
      label346:
      ac.i(TAG, "media list null");
      i = 0;
      break label161;
      label360:
      if (((Integer)localObject1).intValue() != 2) {
        break label259;
      }
      localObject1 = ((bqr)localObject2).mediaList;
      localObject4 = com.tencent.mm.plugin.finder.upload.h.rNr;
      localObject4 = this.siq.get(i);
      k.g(localObject4, "thumbFileList[index]");
      ((LinkedList)localObject1).add(com.tencent.mm.plugin.finder.upload.h.gj(str1, (String)localObject4));
      i = j;
      break label199;
    }
    label422:
    localObject1 = new h(true, 8, (bqr)localObject2);
    AppMethodBeat.o(204875);
    return localObject1;
    label443:
    localObject1 = new h(false, 0, null);
    AppMethodBeat.o(204875);
    return localObject1;
  }
  
  public final PhotoView cGE()
  {
    AppMethodBeat.i(204874);
    PhotoView localPhotoView = this.siC;
    if (localPhotoView == null) {
      k.aVY("thumbIv");
    }
    AppMethodBeat.o(204874);
    return localPhotoView;
  }
  
  public final void cGF()
  {
    AppMethodBeat.i(204877);
    bqr localbqr = new bqr();
    if (this.shW != null)
    {
      localObject1 = this.shW;
      if (localObject1 == null) {
        k.fOy();
      }
      if (!bs.gY((List)((bqr)localObject1).mediaList))
      {
        localObject1 = localbqr.mediaList;
        localObject2 = this.shW;
        if (localObject2 == null) {
          k.fOy();
        }
        ((LinkedList)localObject1).addAll((Collection)((bqr)localObject2).mediaList);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.rOv;
        localObject1 = this.context;
        if (localObject1 != null) {
          break label336;
        }
        localObject1 = new v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(204877);
        throw ((Throwable)localObject1);
      }
    }
    Object localObject1 = this.siG;
    if (localObject1 == null) {
      k.fOy();
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
        j.fOc();
      }
      localObject3 = (String)localObject1;
      localObject1 = this.siH;
      if (localObject1 == null) {
        k.fOy();
      }
      localObject1 = (Integer)((ArrayList)localObject1).get(i);
      if (localObject1 == null)
      {
        localObject4 = localbqr.mediaList;
        localObject1 = com.tencent.mm.plugin.finder.upload.h.rNr;
        str = bs.nullAsNil((String)this.siq.get(i));
        k.g(str, "Util.nullAsNil(thumbFileList[index])");
        if (this.siI.size() <= i) {
          break label331;
        }
      }
    }
    label331:
    for (localObject1 = (brc)this.siI.get(i);; localObject1 = null)
    {
      ((LinkedList)localObject4).add(com.tencent.mm.plugin.finder.upload.h.a((String)localObject3, str, (brc)localObject1));
      i = j;
      break label137;
      if (((Integer)localObject1).intValue() != 2) {
        break label197;
      }
      localObject1 = localbqr.mediaList;
      localObject4 = com.tencent.mm.plugin.finder.upload.h.rNr;
      localObject4 = this.siq.get(i);
      k.g(localObject4, "thumbFileList[index]");
      ((LinkedList)localObject1).add(com.tencent.mm.plugin.finder.upload.h.gj((String)localObject3, (String)localObject4));
      i = j;
      break label137;
      break;
    }
    label336:
    localObject1 = (Activity)localObject1;
    localObject2 = this.siC;
    if (localObject2 == null) {
      k.aVY("thumbIv");
    }
    localObject2 = (View)localObject2;
    Object localObject3 = this.context;
    if (localObject3 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(204877);
      throw ((Throwable)localObject1);
    }
    localObject3 = ((MMActivity)localObject3).getWindow();
    k.g(localObject3, "(context as MMActivity).window");
    localObject2 = ViewAnimHelper.n((View)localObject2, ((Window)localObject3).getDecorView());
    k.g(localObject2, "ViewAnimHelper.getViewIn…tivity).window.decorView)");
    com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject1, (ViewAnimHelper.ViewInfo)localObject2, localbqr, this.shV);
    AppMethodBeat.o(204877);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(168610);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (this.shW != null)
    {
      localObject1 = this.shW;
      if (localObject1 == null) {
        k.fOy();
      }
      if (!bs.gY((List)((bqr)localObject1).mediaList))
      {
        localObject1 = this.sio;
        if (localObject1 == null) {
          k.aVY("reprintIv");
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = this.shW;
        if (localObject1 == null) {
          k.fOy();
        }
        if (((bqr)localObject1).mediaList.size() > 1)
        {
          localObject1 = this.siD;
          if (localObject1 == null) {
            k.aVY("mediaCountView");
          }
          ((TextView)localObject1).setVisibility(8);
          localObject1 = this.siD;
          if (localObject1 == null) {
            k.aVY("mediaCountView");
          }
          localObject2 = this.context;
          localObject3 = this.shW;
          if (localObject3 == null) {
            k.fOy();
          }
          ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getString(2131759238, new Object[] { Integer.valueOf(((bqr)localObject3).mediaList.size()) }));
          localObject1 = this.siF;
          if (localObject1 == null) {
            k.aVY("multiIcon");
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
          localObject3 = this.siC;
          if (localObject3 == null) {
            k.aVY("thumbIv");
          }
          ((PhotoView)localObject3).getLayoutParams().width = ((Bundle)localObject2).getInt("media_layout_width", (int)((bqs)localObject1).width);
          localObject3 = this.siC;
          if (localObject3 == null) {
            k.aVY("thumbIv");
          }
          ((PhotoView)localObject3).getLayoutParams().height = ((Bundle)localObject2).getInt("media_layout_height", (int)((bqs)localObject1).height);
          localObject3 = this.siC;
          if (localObject3 == null) {
            k.aVY("thumbIv");
          }
          ((PhotoView)localObject3).setScaleType(android.widget.ImageView.ScaleType.values()[localObject2.getInt("media_layout_sale_type", android.widget.ImageView.ScaleType.CENTER_CROP.ordinal())]);
          localObject2 = this.siC;
          if (localObject2 == null) {
            k.aVY("thumbIv");
          }
          ((PhotoView)localObject2).requestLayout();
          if (((bqs)localObject1).mediaType != 4) {
            break label498;
          }
          k.g(localObject1, "mediaObj");
          localObject1 = new com.tencent.mm.plugin.finder.loader.f((bqs)localObject1, m.rDR);
          localObject2 = com.tencent.mm.plugin.finder.loader.h.rtK;
          localObject2 = com.tencent.mm.plugin.finder.loader.h.cwn();
          localObject3 = this.siC;
          if (localObject3 == null) {
            k.aVY("thumbIv");
          }
          if (localObject3 == null) {
            k.fOy();
          }
          localObject3 = (ImageView)localObject3;
          localObject4 = com.tencent.mm.plugin.finder.loader.h.rtK;
          ((d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.h.a(h.a.rtL));
        }
        for (;;)
        {
          localObject1 = this.siC;
          if (localObject1 == null) {
            k.aVY("thumbIv");
          }
          ((PhotoView)localObject1).setOnClickListener((View.OnClickListener)new b(this));
          AppMethodBeat.o(168610);
          return;
          localObject1 = this.siD;
          if (localObject1 == null) {
            k.aVY("mediaCountView");
          }
          ((TextView)localObject1).setVisibility(8);
          break;
          label498:
          k.g(localObject1, "mediaObj");
          localObject1 = new com.tencent.mm.plugin.finder.loader.f((bqs)localObject1, m.rDR);
          localObject2 = com.tencent.mm.plugin.finder.loader.h.rtK;
          localObject2 = com.tencent.mm.plugin.finder.loader.h.cwn();
          localObject3 = this.siC;
          if (localObject3 == null) {
            k.aVY("thumbIv");
          }
          if (localObject3 == null) {
            k.fOy();
          }
          localObject3 = (ImageView)localObject3;
          localObject4 = com.tencent.mm.plugin.finder.loader.h.rtK;
          ((d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.h.a(h.a.rtL));
        }
      }
    }
    Object localObject1 = this.dmf;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getStringArrayList("MEDIA_FILE_LIST");
      this.siG = ((ArrayList)localObject1);
      localObject1 = this.dmf;
      if (localObject1 == null) {
        break label720;
      }
      localObject1 = ((Bundle)localObject1).getIntegerArrayList("MEDIA_TYPE_LIST");
      label611:
      this.siH = ((ArrayList)localObject1);
      localObject1 = this.dmf;
      if (localObject1 == null) {
        break label725;
      }
      localObject1 = ((Bundle)localObject1).getStringArrayList("MEDIA_THUMB_LIST");
      label633:
      localObject2 = this.dmf;
      if (localObject2 == null) {
        k.fOy();
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
        this.siI.add(((LocalVideoCropInfoParcelable)localObject3).rvh);
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
      this.siI.add(null);
    }
    label742:
    if (this.siG != null)
    {
      localObject2 = this.siG;
      if (localObject2 == null) {
        k.fOy();
      }
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject2 = this.siG;
        if (localObject2 == null) {
          k.fOy();
        }
        if (((ArrayList)localObject2).size() <= 1) {
          break label917;
        }
        localObject2 = this.siD;
        if (localObject2 == null) {
          k.aVY("mediaCountView");
        }
        ((TextView)localObject2).setVisibility(8);
        localObject2 = this.siD;
        if (localObject2 == null) {
          k.aVY("mediaCountView");
        }
        localObject3 = this.context;
        localObject4 = this.siG;
        if (localObject4 == null) {
          k.fOy();
        }
        ((TextView)localObject2).setText((CharSequence)((Context)localObject3).getString(2131759238, new Object[] { Integer.valueOf(((ArrayList)localObject4).size()) }));
        localObject2 = this.siF;
        if (localObject2 == null) {
          k.aVY("multiIcon");
        }
        ((View)localObject2).setVisibility(0);
      }
    }
    for (;;)
    {
      b.c((Runnable)new e.c(this, (ArrayList)localObject1), "Finder_Post_Create_Media_Thumb");
      AppMethodBeat.o(168610);
      return;
      label917:
      localObject2 = this.siD;
      if (localObject2 == null) {
        k.aVY("mediaCountView");
      }
      ((TextView)localObject2).setVisibility(8);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168600);
      this.siK.cGF();
      AppMethodBeat.o(168600);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.e
 * JD-Core Version:    0.7.0.1
 */