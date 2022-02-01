package com.tencent.mm.plugin.finder.widget.post;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.upload.i;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.fbq;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.PhotoView;
import com.tencent.mm.view.ViewAnimHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mediaCountView", "Landroid/widget/TextView;", "getMediaCountView", "()Landroid/widget/TextView;", "setMediaCountView", "(Landroid/widget/TextView;)V", "mediaCropInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "Lkotlin/collections/ArrayList;", "getMediaCropInfoList", "()Ljava/util/ArrayList;", "setMediaCropInfoList", "(Ljava/util/ArrayList;)V", "mediaFileList", "", "getMediaFileList", "setMediaFileList", "mediaTypeList", "", "getMediaTypeList", "setMediaTypeList", "multiIcon", "Landroid/view/View;", "getMultiIcon", "()Landroid/view/View;", "setMultiIcon", "(Landroid/view/View;)V", "reprintIv", "rootView", "thumbFileList", "getThumbFileList", "setThumbFileList", "thumbIv", "Lcom/tencent/mm/view/PhotoView;", "getThumbIv", "()Lcom/tencent/mm/view/PhotoView;", "setThumbIv", "(Lcom/tencent/mm/view/PhotoView;)V", "videoPlayIcon", "Landroid/widget/ImageView;", "getVideoPlayIcon", "()Landroid/widget/ImageView;", "setVideoPlayIcon", "(Landroid/widget/ImageView;)V", "checkData", "", "checkFileExist", "getThumbFile", "index", "file", "mediaThumbList", "getUploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "inflateView", "initCropInfo", "", "jumpToPreviewMediaUI", "onCreate", "onDestroy", "refresh", "showMediaThumb", "showVideoThumb", "thumbFile", "showThumb", "Companion", "plugin-finder_release"})
public final class e
  extends a
{
  public static final a BtL;
  private static final String TAG = "Finder.PostMixMediaWidget";
  public PhotoView BtE;
  public TextView BtF;
  protected ImageView BtG;
  public View BtH;
  private ArrayList<String> BtI;
  private ArrayList<Integer> BtJ;
  private ArrayList<css> BtK;
  private View Bti;
  ArrayList<String> Btl;
  private View oFW;
  
  static
  {
    AppMethodBeat.i(168612);
    BtL = new a((byte)0);
    TAG = "Finder.PostMixMediaWidget";
    AppMethodBeat.o(168612);
  }
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168611);
    this.Btl = new ArrayList();
    this.BtK = new ArrayList();
    AppMethodBeat.o(168611);
  }
  
  public final void at(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(277226);
    Object localObject1 = this.BtI;
    if (localObject1 == null) {
      p.iCn();
    }
    Iterator localIterator = ((Iterable)localObject1).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (i < 0) {
        j.iBO();
      }
      localObject1 = (String)localObject1;
      final boolean bool;
      label72:
      Object localObject2;
      if (i == 0)
      {
        bool = true;
        a.aGH((String)localObject1);
        p.k(localObject1, "file");
        localObject2 = this.BtJ;
        if (localObject2 == null) {
          p.iCn();
        }
        localObject2 = (Integer)((ArrayList)localObject2).get(i);
        if (localObject2 != null) {
          break label295;
        }
        label114:
        if ((paramArrayList == null) || (paramArrayList.size() <= i) || (Util.isNullOrNil((String)paramArrayList.get(i))) || (!com.tencent.mm.vfs.u.agG((String)paramArrayList.get(i)))) {
          break label369;
        }
        localObject1 = paramArrayList.get(i);
        p.j(localObject1, "mediaThumbList[index]");
        localObject1 = (String)localObject1;
      }
      for (;;)
      {
        p.k(localObject1, "thumbFile");
        Log.i(TAG, "showVideoThumb, thumbFile:" + (String)localObject1 + ", showThumb:" + bool);
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject2 = BitmapUtil.decodeFile((String)localObject1);
          if (localObject2 != null) {
            MMHandlerThread.postToMainThread((Runnable)new d((Bitmap)localObject2, this, (String)localObject1, bool, (Bitmap)localObject2));
          }
        }
        if (bool)
        {
          localObject1 = this.BtG;
          if (localObject1 == null) {
            p.bGy("videoPlayIcon");
          }
          ((ImageView)localObject1).setVisibility(8);
        }
        i += 1;
        break;
        bool = false;
        break label72;
        label295:
        if (((Integer)localObject2).intValue() != 2) {
          break label114;
        }
        if ((paramArrayList != null) && (paramArrayList.size() > i) && (!Util.isNullOrNil((String)paramArrayList.get(i))))
        {
          localObject1 = paramArrayList.get(i);
          p.j(localObject1, "mediaThumbList[index]");
          localObject1 = (String)localObject1;
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.finder.upload.f.AzZ;
          localObject1 = com.tencent.mm.plugin.finder.upload.f.aFk((String)localObject1);
          continue;
          label369:
          if ((this.BtK.size() > i) && (this.BtK.get(i) != null))
          {
            localObject2 = this.BtK.get(i);
            if (localObject2 == null) {
              p.iCn();
            }
            if (((css)localObject2).TAx != null)
            {
              localObject2 = com.tencent.mm.plugin.finder.upload.f.AzZ;
              Object localObject3 = this.BtK.get(i);
              if (localObject3 == null) {
                p.iCn();
              }
              localObject3 = ((css)localObject3).TAx;
              if (localObject3 == null) {
                p.iCn();
              }
              p.j(localObject3, "mediaCropInfoList[index]!!.thumbRect!!");
              localObject1 = ((com.tencent.mm.plugin.finder.upload.f)localObject2).a((String)localObject1, (fbq)localObject3);
              continue;
            }
          }
          Log.w(TAG, "no thumb & no thumbRect");
          localObject2 = com.tencent.mm.plugin.finder.upload.f.AzZ;
          localObject1 = com.tencent.mm.plugin.finder.upload.f.aFj((String)localObject1);
        }
      }
    }
    AppMethodBeat.o(277226);
  }
  
  public final void bfU()
  {
    AppMethodBeat.i(168610);
    super.bfU();
    Object localObject2;
    int i;
    Object localObject3;
    label235:
    Object localObject4;
    if (emo() != null)
    {
      localObject1 = emo();
      if (localObject1 == null) {
        p.iCn();
      }
      if (!Util.isNullOrNil((List)((csf)localObject1).mediaList))
      {
        localObject1 = this.Bti;
        if (localObject1 == null) {
          p.bGy("reprintIv");
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = emo();
        if (localObject1 == null) {
          p.iCn();
        }
        if (((csf)localObject1).mediaList.size() > 1)
        {
          localObject1 = this.BtF;
          if (localObject1 == null) {
            p.bGy("mediaCountView");
          }
          ((TextView)localObject1).setVisibility(8);
          localObject1 = this.BtF;
          if (localObject1 == null) {
            p.bGy("mediaCountView");
          }
          localObject2 = this.context;
          i = b.j.finder_image_count_tip;
          localObject3 = emo();
          if (localObject3 == null) {
            p.iCn();
          }
          ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getString(i, new Object[] { Integer.valueOf(((csf)localObject3).mediaList.size()) }));
          localObject1 = this.BtH;
          if (localObject1 == null) {
            p.bGy("multiIcon");
          }
          ((View)localObject1).setVisibility(0);
          localObject1 = emo();
          if (localObject1 == null) {
            p.iCn();
          }
          localObject1 = ((csf)localObject1).mediaList;
          p.j(localObject1, "refFeedContent!!.mediaList");
          localObject2 = (csg)((LinkedList)localObject1).getFirst();
          if (localObject2 == null) {
            break label532;
          }
          localObject1 = ((csg)localObject2).TzS;
          a.aGH((String)localObject1);
          localObject1 = aj.AGc;
          localObject1 = aj.ha((int)((csg)localObject2).width, (int)((csg)localObject2).height);
          localObject3 = this.BtE;
          if (localObject3 == null) {
            p.bGy("thumbIv");
          }
          ((PhotoView)localObject3).getLayoutParams().width = ((Number)((kotlin.r)localObject1).My).intValue();
          localObject3 = this.BtE;
          if (localObject3 == null) {
            p.bGy("thumbIv");
          }
          ((PhotoView)localObject3).getLayoutParams().height = ((Number)((kotlin.r)localObject1).aazK).intValue();
          localObject3 = this.BtE;
          if (localObject3 == null) {
            p.bGy("thumbIv");
          }
          ((PhotoView)localObject3).setScaleType(android.widget.ImageView.ScaleType.values()[((Number)localObject1.Mx).intValue()]);
          localObject1 = this.BtE;
          if (localObject1 == null) {
            p.bGy("thumbIv");
          }
          ((PhotoView)localObject1).requestLayout();
          if (((csg)localObject2).mediaType != 4) {
            break label537;
          }
          p.j(localObject2, "mediaObj");
          localObject1 = new com.tencent.mm.plugin.finder.loader.r((csg)localObject2, com.tencent.mm.plugin.finder.storage.u.Alz, null, null, 12);
          localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
          localObject2 = com.tencent.mm.plugin.finder.loader.t.dJe();
          localObject3 = this.BtE;
          if (localObject3 == null) {
            p.bGy("thumbIv");
          }
          if (localObject3 == null) {
            p.iCn();
          }
          localObject3 = (ImageView)localObject3;
          localObject4 = com.tencent.mm.plugin.finder.loader.t.ztT;
          ((d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
        }
        for (;;)
        {
          localObject1 = this.BtE;
          if (localObject1 == null) {
            p.bGy("thumbIv");
          }
          ((PhotoView)localObject1).setOnClickListener((View.OnClickListener)new b(this));
          AppMethodBeat.o(168610);
          return;
          localObject1 = this.BtF;
          if (localObject1 == null) {
            p.bGy("mediaCountView");
          }
          ((TextView)localObject1).setVisibility(8);
          break;
          label532:
          localObject1 = null;
          break label235;
          label537:
          p.j(localObject2, "mediaObj");
          localObject1 = new com.tencent.mm.plugin.finder.loader.r((csg)localObject2, com.tencent.mm.plugin.finder.storage.u.Alz, null, null, 12);
          localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
          localObject2 = com.tencent.mm.plugin.finder.loader.t.dJe();
          localObject3 = this.BtE;
          if (localObject3 == null) {
            p.bGy("thumbIv");
          }
          if (localObject3 == null) {
            p.iCn();
          }
          localObject3 = (ImageView)localObject3;
          localObject4 = com.tencent.mm.plugin.finder.loader.t.ztT;
          ((d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
        }
      }
    }
    Object localObject1 = getData();
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getStringArrayList("MEDIA_FILE_LIST");
      this.BtI = ((ArrayList)localObject1);
      localObject1 = getData();
      if (localObject1 == null) {
        break label773;
      }
      localObject1 = ((Bundle)localObject1).getIntegerArrayList("MEDIA_TYPE_LIST");
      label660:
      this.BtJ = ((ArrayList)localObject1);
      localObject1 = getData();
      if (localObject1 == null) {
        break label778;
      }
      localObject1 = ((Bundle)localObject1).getStringArrayList("MEDIA_THUMB_LIST");
      label682:
      localObject2 = getData();
      if (localObject2 == null) {
        p.iCn();
      }
      localObject2 = ((Bundle)localObject2).getParcelableArrayList("VIDEO_CROP_LIST");
      if (localObject2 == null) {
        break label795;
      }
      localObject2 = ((Iterable)localObject2).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label795;
      }
      localObject3 = (Parcelable)((Iterator)localObject2).next();
      if ((localObject3 != null) && ((localObject3 instanceof LocalVideoCropInfoParcelable)))
      {
        this.BtK.add(((LocalVideoCropInfoParcelable)localObject3).zBo);
        continue;
        localObject1 = null;
        break;
        label773:
        localObject1 = null;
        break label660;
        label778:
        localObject1 = null;
        break label682;
      }
      this.BtK.add(null);
    }
    label795:
    if (this.BtI != null)
    {
      localObject2 = this.BtI;
      if (localObject2 == null) {
        p.iCn();
      }
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject2 = this.BtI;
        if (localObject2 == null) {
          p.iCn();
        }
        if (((ArrayList)localObject2).size() <= 1) {
          break label974;
        }
        localObject2 = this.BtF;
        if (localObject2 == null) {
          p.bGy("mediaCountView");
        }
        ((TextView)localObject2).setVisibility(8);
        localObject2 = this.BtF;
        if (localObject2 == null) {
          p.bGy("mediaCountView");
        }
        localObject3 = this.context;
        i = b.j.finder_image_count_tip;
        localObject4 = this.BtI;
        if (localObject4 == null) {
          p.iCn();
        }
        ((TextView)localObject2).setText((CharSequence)((Context)localObject3).getString(i, new Object[] { Integer.valueOf(((ArrayList)localObject4).size()) }));
        localObject2 = this.BtH;
        if (localObject2 == null) {
          p.bGy("multiIcon");
        }
        ((View)localObject2).setVisibility(0);
      }
    }
    for (;;)
    {
      ThreadPool.post((Runnable)new c(this, (ArrayList)localObject1), "Finder_Post_Create_Media_Thumb");
      AppMethodBeat.o(168610);
      return;
      label974:
      localObject2 = this.BtF;
      if (localObject2 == null) {
        p.bGy("mediaCountView");
      }
      ((TextView)localObject2).setVisibility(8);
    }
  }
  
  public final boolean cMI()
  {
    AppMethodBeat.i(277232);
    Object localObject1 = this.BtI;
    if (localObject1 != null)
    {
      Object localObject2 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (String)((Iterator)localObject2).next();
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!com.tencent.mm.vfs.u.agG((String)localObject1)))
        {
          localObject2 = f.Bub;
          Log.i(f.access$getTAG$cp(), "[PostMixMediaWidget] widget file:" + (String)localObject1 + " lost!");
          AppMethodBeat.o(277232);
          return false;
        }
      }
    }
    AppMethodBeat.o(277232);
    return true;
  }
  
  public final PhotoView emD()
  {
    AppMethodBeat.i(277222);
    PhotoView localPhotoView = this.BtE;
    if (localPhotoView == null) {
      p.bGy("thumbIv");
    }
    AppMethodBeat.o(277222);
    return localPhotoView;
  }
  
  public final void emE()
  {
    AppMethodBeat.i(277229);
    csf localcsf = new csf();
    if (emo() != null)
    {
      localObject1 = emo();
      if (localObject1 == null) {
        p.iCn();
      }
      if (!Util.isNullOrNil((List)((csf)localObject1).mediaList))
      {
        localObject1 = localcsf.mediaList;
        localObject2 = emo();
        if (localObject2 == null) {
          p.iCn();
        }
        ((LinkedList)localObject1).addAll((Collection)((csf)localObject2).mediaList);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
        localObject1 = this.context;
        if (localObject1 != null) {
          break label336;
        }
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(277229);
        throw ((Throwable)localObject1);
      }
    }
    Object localObject1 = this.BtI;
    if (localObject1 == null) {
      p.iCn();
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
        j.iBO();
      }
      localObject3 = (String)localObject1;
      localObject1 = this.BtJ;
      if (localObject1 == null) {
        p.iCn();
      }
      localObject1 = (Integer)((ArrayList)localObject1).get(i);
      if (localObject1 == null)
      {
        localObject4 = localcsf.mediaList;
        localObject1 = i.AAy;
        str = Util.nullAsNil((String)this.Btl.get(i));
        p.j(str, "Util.nullAsNil(thumbFileList[index])");
        if (this.BtK.size() <= i) {
          break label331;
        }
      }
    }
    label331:
    for (localObject1 = (css)this.BtK.get(i);; localObject1 = null)
    {
      ((LinkedList)localObject4).add(i.a((String)localObject3, str, (css)localObject1));
      i = j;
      break label137;
      if (((Integer)localObject1).intValue() != 2) {
        break label197;
      }
      localObject1 = localcsf.mediaList;
      localObject4 = i.AAy;
      localObject4 = this.Btl.get(i);
      p.j(localObject4, "thumbFileList[index]");
      ((LinkedList)localObject1).add(i.hq((String)localObject3, (String)localObject4));
      i = j;
      break label137;
      break;
    }
    label336:
    localObject1 = (Activity)localObject1;
    localObject2 = this.BtE;
    if (localObject2 == null) {
      p.bGy("thumbIv");
    }
    localObject2 = (View)localObject2;
    Object localObject3 = this.context;
    if (localObject3 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(277229);
      throw ((Throwable)localObject1);
    }
    localObject3 = ((MMActivity)localObject3).getWindow();
    p.j(localObject3, "(context as MMActivity).window");
    com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject1, ViewAnimHelper.q((View)localObject2, ((Window)localObject3).getDecorView()), localcsf, this.ABc, false, false, 48);
    AppMethodBeat.o(277229);
  }
  
  public final View emx()
  {
    AppMethodBeat.i(168608);
    Object localObject = this.context;
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(168608);
      throw ((Throwable)localObject);
    }
    localObject = ((Activity)localObject).getLayoutInflater().inflate(b.g.finder_post_media_widget, null);
    p.j(localObject, "(context as Activity).la…_post_media_widget, null)");
    this.oFW = ((View)localObject);
    localObject = this.oFW;
    if (localObject == null) {
      p.bGy("rootView");
    }
    localObject = ((View)localObject).findViewById(b.f.thumb_view);
    p.j(localObject, "rootView.findViewById(R.id.thumb_view)");
    this.BtE = ((PhotoView)localObject);
    localObject = this.oFW;
    if (localObject == null) {
      p.bGy("rootView");
    }
    localObject = ((View)localObject).findViewById(b.f.media_number);
    p.j(localObject, "rootView.findViewById(R.id.media_number)");
    this.BtF = ((TextView)localObject);
    localObject = this.oFW;
    if (localObject == null) {
      p.bGy("rootView");
    }
    localObject = ((View)localObject).findViewById(b.f.video_play_icon);
    p.j(localObject, "rootView.findViewById(R.id.video_play_icon)");
    this.BtG = ((ImageView)localObject);
    localObject = this.oFW;
    if (localObject == null) {
      p.bGy("rootView");
    }
    localObject = ((View)localObject).findViewById(b.f.multi_icon);
    p.j(localObject, "rootView.findViewById(R.id.multi_icon)");
    this.BtH = ((View)localObject);
    localObject = this.oFW;
    if (localObject == null) {
      p.bGy("rootView");
    }
    localObject = ((View)localObject).findViewById(b.f.reprint_iv);
    p.j(localObject, "rootView.findViewById(R.id.reprint_iv)");
    this.Bti = ((View)localObject);
    localObject = this.oFW;
    if (localObject == null) {
      p.bGy("rootView");
    }
    AppMethodBeat.o(168608);
    return localObject;
  }
  
  public final g emy()
  {
    AppMethodBeat.i(277223);
    if ((this.ABc != null) && (emo() != null))
    {
      localObject1 = new g(true, 8, emo());
      AppMethodBeat.o(277223);
      return localObject1;
    }
    Object localObject1 = (Collection)this.BtI;
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
      Object localObject3 = this.BtI;
      if (localObject3 == null) {
        p.iCn();
      }
      Log.i((String)localObject1, ((ArrayList)localObject3).size() + ", thumb list " + this.Btl.size());
      localObject1 = this.BtI;
      if (localObject1 == null) {
        p.iCn();
      }
      if (((ArrayList)localObject1).size() != this.Btl.size()) {
        break label341;
      }
      i = 1;
      if (i == 0) {
        break label443;
      }
      localObject2 = new csf();
      localObject1 = this.BtI;
      if (localObject1 == null) {
        p.iCn();
      }
      localObject3 = ((Iterable)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject3).hasNext()) {
        break label422;
      }
      localObject1 = ((Iterator)localObject3).next();
      j = i + 1;
      if (i < 0) {
        j.iBO();
      }
      str1 = (String)localObject1;
      localObject1 = this.BtJ;
      if (localObject1 == null) {
        p.iCn();
      }
      localObject1 = (Integer)((ArrayList)localObject1).get(i);
      if (localObject1 != null) {
        break label360;
      }
      localObject4 = ((csf)localObject2).mediaList;
      localObject1 = i.AAy;
      str2 = Util.nullAsNil((String)this.Btl.get(i));
      p.j(str2, "Util.nullAsNil(thumbFileList[index])");
      if (this.BtK.size() <= i) {
        break label417;
      }
    }
    label417:
    for (localObject1 = (css)this.BtK.get(i);; localObject1 = null)
    {
      ((LinkedList)localObject4).add(i.a(str1, str2, (css)localObject1));
      i = j;
      break label199;
      i = 0;
      break;
      label341:
      i = 0;
      break label161;
      label346:
      Log.i(TAG, "media list null");
      i = 0;
      break label161;
      label360:
      if (((Integer)localObject1).intValue() != 2) {
        break label259;
      }
      localObject1 = ((csf)localObject2).mediaList;
      localObject4 = i.AAy;
      localObject4 = this.Btl.get(i);
      p.j(localObject4, "thumbFileList[index]");
      ((LinkedList)localObject1).add(i.hq(str1, (String)localObject4));
      i = j;
      break label199;
    }
    label422:
    localObject1 = new g(true, 8, (csf)localObject2);
    AppMethodBeat.o(277223);
    return localObject1;
    label443:
    localObject1 = new g(false, 0, null);
    AppMethodBeat.o(277223);
    return localObject1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168600);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.BtM.emE();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168600);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(e parame, ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(168607);
      this.BtM.at(this.BtN);
      AppMethodBeat.o(168607);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$showVideoThumb$1$1"})
  static final class d
    implements Runnable
  {
    d(Bitmap paramBitmap1, e parame, String paramString, boolean paramBoolean, Bitmap paramBitmap2) {}
    
    public final void run()
    {
      AppMethodBeat.i(274299);
      jdField_this.Btl.add(this.Btx);
      Object localObject = e.BtL;
      Log.i(e.access$getTAG$cp(), "add thumb file");
      if (bool)
      {
        localObject = aj.AGc;
        localObject = aj.ha(this.BtO.getWidth(), this.BtO.getHeight());
        jdField_this.emD().getLayoutParams().width = ((Number)((kotlin.r)localObject).My).intValue();
        jdField_this.emD().getLayoutParams().height = ((Number)((kotlin.r)localObject).aazK).intValue();
        jdField_this.emD().setScaleType(android.widget.ImageView.ScaleType.values()[((Number)localObject.Mx).intValue()]);
        jdField_this.emD().requestLayout();
        jdField_this.emD().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(219958);
            this.BtP.BtM.emD().setImageBitmap(this.BtP.tEt);
            AppMethodBeat.o(219958);
          }
        });
        jdField_this.emD().setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(292319);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$showVideoThumb$$inlined$let$lambda$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            this.BtP.BtM.emE();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$showVideoThumb$$inlined$let$lambda$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(292319);
          }
        });
      }
      AppMethodBeat.o(274299);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.e
 * JD-Core Version:    0.7.0.1
 */