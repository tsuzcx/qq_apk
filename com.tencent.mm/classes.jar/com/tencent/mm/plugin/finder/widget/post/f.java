package com.tencent.mm.plugin.finder.widget.post;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.publish.l.f;
import com.tencent.mm.plugin.finder.publish.l.i;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.upload.i;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.protocal.protobuf.fyb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.y;
import com.tencent.mm.view.PhotoView;
import com.tencent.mm.view.ViewAnimHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mediaCountView", "Landroid/widget/TextView;", "getMediaCountView", "()Landroid/widget/TextView;", "setMediaCountView", "(Landroid/widget/TextView;)V", "mediaCropInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "Lkotlin/collections/ArrayList;", "getMediaCropInfoList", "()Ljava/util/ArrayList;", "setMediaCropInfoList", "(Ljava/util/ArrayList;)V", "mediaFileList", "", "getMediaFileList", "setMediaFileList", "mediaTypeList", "", "getMediaTypeList", "setMediaTypeList", "multiIcon", "Landroid/view/View;", "getMultiIcon", "()Landroid/view/View;", "setMultiIcon", "(Landroid/view/View;)V", "reprintIv", "rootView", "thumbFileList", "getThumbFileList", "setThumbFileList", "thumbIv", "Lcom/tencent/mm/view/PhotoView;", "getThumbIv", "()Lcom/tencent/mm/view/PhotoView;", "setThumbIv", "(Lcom/tencent/mm/view/PhotoView;)V", "videoPlayIcon", "Landroid/widget/ImageView;", "getVideoPlayIcon", "()Landroid/widget/ImageView;", "setVideoPlayIcon", "(Landroid/widget/ImageView;)V", "checkData", "", "checkFileExist", "getThumbFile", "index", "file", "mediaThumbList", "getUploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "inflateView", "initCropInfo", "", "jumpToPreviewMediaUI", "onCreate", "onDestroy", "refresh", "showMediaThumb", "showVideoThumb", "thumbFile", "showThumb", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends a
{
  public static final a Haw;
  private static final String TAG;
  public View HaA;
  private ArrayList<String> HaB;
  private ArrayList<Integer> HaC;
  private ArrayList<dju> HaD;
  private View Haj;
  private ArrayList<String> Ham;
  public PhotoView Hax;
  public TextView Hay;
  protected ImageView Haz;
  private View rootView;
  
  static
  {
    AppMethodBeat.i(168612);
    Haw = new a((byte)0);
    TAG = "Finder.PostMixMediaWidget";
    AppMethodBeat.o(168612);
  }
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168611);
    this.Ham = new ArrayList();
    this.HaD = new ArrayList();
    AppMethodBeat.o(168611);
  }
  
  private static final void a(f paramf, Bitmap paramBitmap)
  {
    AppMethodBeat.i(330766);
    s.u(paramf, "this$0");
    s.u(paramBitmap, "$it");
    paramf.fqI().setImageBitmap(paramBitmap);
    AppMethodBeat.o(330766);
  }
  
  private static final void a(f paramf, View paramView)
  {
    AppMethodBeat.i(330746);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramf, "this$0");
    paramf.fqL();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(330746);
  }
  
  private static final void a(f paramf, String paramString, boolean paramBoolean, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    AppMethodBeat.i(330786);
    s.u(paramf, "this$0");
    s.u(paramString, "$thumbFile");
    s.u(paramBitmap2, "$it");
    paramf.Ham.add(paramString);
    Log.i(TAG, "add thumb file");
    if (paramBoolean)
    {
      paramString = av.GiL;
      paramString = av.ir(paramBitmap1.getWidth(), paramBitmap1.getHeight());
      paramf.fqI().getLayoutParams().width = ((Number)paramString.bsD).intValue();
      paramf.fqI().getLayoutParams().height = ((Number)paramString.aiuN).intValue();
      paramf.fqI().setScaleType(android.widget.ImageView.ScaleType.values()[((Number)paramString.bsC).intValue()]);
      paramf.fqI().requestLayout();
      paramf.fqI().post(new f..ExternalSyntheticLambda2(paramf, paramBitmap2));
      paramf.fqI().setOnClickListener(new f..ExternalSyntheticLambda0(paramf));
    }
    AppMethodBeat.o(330786);
  }
  
  private static final void a(f paramf, ArrayList paramArrayList)
  {
    AppMethodBeat.i(330761);
    s.u(paramf, "this$0");
    Object localObject1 = paramf.HaB;
    s.checkNotNull(localObject1);
    Iterator localIterator = ((Iterable)localObject1).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject1 = (String)localObject1;
      boolean bool;
      label76:
      Object localObject2;
      if (i == 0)
      {
        bool = true;
        a.aCW((String)localObject1);
        s.u(localObject1, "file");
        localObject2 = paramf.HaC;
        s.checkNotNull(localObject2);
        localObject2 = (Integer)((ArrayList)localObject2).get(i);
        if (localObject2 != null) {
          break label292;
        }
        label116:
        if ((paramArrayList == null) || (paramArrayList.size() <= i) || (Util.isNullOrNil((String)paramArrayList.get(i))) || (!y.ZC((String)paramArrayList.get(i)))) {
          break label370;
        }
        localObject1 = paramArrayList.get(i);
        s.s(localObject1, "{\n                mediaT…List[index]\n            }");
        localObject1 = (String)localObject1;
        label178:
        s.u(localObject1, "thumbFile");
        Log.i(TAG, "showVideoThumb, thumbFile:" + (String)localObject1 + ", showThumb:" + bool);
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject2 = BitmapUtil.decodeFile((String)localObject1);
          if (localObject2 != null) {
            MMHandlerThread.postToMainThread(new f..ExternalSyntheticLambda3(paramf, (String)localObject1, bool, (Bitmap)localObject2, (Bitmap)localObject2));
          }
        }
        if (bool)
        {
          localObject1 = paramf.Haz;
          if (localObject1 == null) {
            break label499;
          }
        }
      }
      for (;;)
      {
        ((ImageView)localObject1).setVisibility(8);
        i += 1;
        break;
        bool = false;
        break label76;
        label292:
        if (((Integer)localObject2).intValue() != 2) {
          break label116;
        }
        if ((paramArrayList != null) && (paramArrayList.size() > i) && (!Util.isNullOrNil((String)paramArrayList.get(i))))
        {
          localObject1 = paramArrayList.get(i);
          s.s(localObject1, "{\n                    me…[index]\n                }");
          localObject1 = (String)localObject1;
          break label178;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.publish.a)com.tencent.mm.plugin.finder.upload.f.GbE).azz((String)localObject1);
        break label178;
        label370:
        if ((paramf.HaD.size() > i) && (paramf.HaD.get(i) != null))
        {
          localObject2 = paramf.HaD.get(i);
          s.checkNotNull(localObject2);
          if (((dju)localObject2).aaPL != null)
          {
            localObject2 = com.tencent.mm.plugin.finder.upload.f.GbE;
            Object localObject3 = paramf.HaD.get(i);
            s.checkNotNull(localObject3);
            localObject3 = ((dju)localObject3).aaPL;
            s.checkNotNull(localObject3);
            s.s(localObject3, "mediaCropInfoList[index]!!.thumbRect!!");
            localObject1 = ((com.tencent.mm.plugin.finder.upload.f)localObject2).a((String)localObject1, (fyb)localObject3);
            break label178;
          }
        }
        Log.w(TAG, "no thumb & no thumbRect");
        localObject2 = com.tencent.mm.plugin.finder.upload.f.GbE;
        localObject1 = com.tencent.mm.plugin.finder.upload.f.aBj((String)localObject1);
        break label178;
        label499:
        s.bIx("videoPlayIcon");
        localObject1 = null;
      }
    }
    AppMethodBeat.o(330761);
  }
  
  private static final void b(f paramf, View paramView)
  {
    AppMethodBeat.i(330775);
    s.u(paramf, "this$0");
    paramf.fqL();
    AppMethodBeat.o(330775);
  }
  
  private PhotoView fqI()
  {
    AppMethodBeat.i(330730);
    PhotoView localPhotoView = this.Hax;
    if (localPhotoView != null)
    {
      AppMethodBeat.o(330730);
      return localPhotoView;
    }
    s.bIx("thumbIv");
    AppMethodBeat.o(330730);
    return null;
  }
  
  private TextView fqJ()
  {
    AppMethodBeat.i(330734);
    TextView localTextView = this.Hay;
    if (localTextView != null)
    {
      AppMethodBeat.o(330734);
      return localTextView;
    }
    s.bIx("mediaCountView");
    AppMethodBeat.o(330734);
    return null;
  }
  
  private View fqK()
  {
    AppMethodBeat.i(330736);
    View localView = this.HaA;
    if (localView != null)
    {
      AppMethodBeat.o(330736);
      return localView;
    }
    s.bIx("multiIcon");
    AppMethodBeat.o(330736);
    return null;
  }
  
  private void fqL()
  {
    AppMethodBeat.i(330743);
    djh localdjh = new djh();
    if (fqz() != null)
    {
      localObject1 = fqz();
      s.checkNotNull(localObject1);
      if (!Util.isNullOrNil((List)((djh)localObject1).mediaList))
      {
        localObject1 = localdjh.mediaList;
        localObject2 = fqz();
        s.checkNotNull(localObject2);
        ((LinkedList)localObject1).addAll((Collection)((djh)localObject2).mediaList);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
        com.tencent.mm.plugin.finder.utils.a.a((Activity)getContext(), ViewAnimHelper.z((View)fqI(), ((MMActivity)getContext()).getWindow().getDecorView()), localdjh, fqy(), false, false, 48);
        AppMethodBeat.o(330743);
        return;
      }
    }
    Object localObject1 = this.HaB;
    s.checkNotNull(localObject1);
    Object localObject2 = ((Iterable)localObject1).iterator();
    int i = 0;
    label150:
    int j;
    String str1;
    label207:
    Object localObject3;
    String str2;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      j = i + 1;
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      str1 = (String)localObject1;
      localObject1 = this.HaC;
      s.checkNotNull(localObject1);
      localObject1 = (Integer)((ArrayList)localObject1).get(i);
      if (localObject1 == null)
      {
        localObject3 = localdjh.mediaList;
        localObject1 = i.Gcb;
        str2 = Util.nullAsNil((String)this.Ham.get(i));
        s.s(str2, "nullAsNil(thumbFileList[index])");
        if (this.HaD.size() <= i) {
          break label341;
        }
      }
    }
    label341:
    for (localObject1 = (dju)this.HaD.get(i);; localObject1 = null)
    {
      ((LinkedList)localObject3).add(i.a(str1, str2, (dju)localObject1));
      i = j;
      break label150;
      if (((Integer)localObject1).intValue() != 2) {
        break label207;
      }
      localObject1 = localdjh.mediaList;
      localObject3 = i.Gcb;
      localObject3 = this.Ham.get(i);
      s.s(localObject3, "thumbFileList[index]");
      ((LinkedList)localObject1).add(i.in(str1, (String)localObject3));
      i = j;
      break label150;
      break;
    }
  }
  
  public final void bDL()
  {
    AppMethodBeat.i(168610);
    super.bDL();
    Object localObject2;
    int i;
    Object localObject3;
    label181:
    Object localObject4;
    if (fqz() != null)
    {
      localObject1 = fqz();
      s.checkNotNull(localObject1);
      if (!Util.isNullOrNil((List)((djh)localObject1).mediaList))
      {
        localObject2 = this.Haj;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("reprintIv");
          localObject1 = null;
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = fqz();
        s.checkNotNull(localObject1);
        if (((djh)localObject1).mediaList.size() > 1)
        {
          fqJ().setVisibility(8);
          localObject1 = fqJ();
          localObject2 = getContext();
          i = l.i.finder_image_count_tip;
          localObject3 = fqz();
          s.checkNotNull(localObject3);
          ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getString(i, new Object[] { Integer.valueOf(((djh)localObject3).mediaList.size()) }));
          fqK().setVisibility(0);
          localObject1 = fqz();
          s.checkNotNull(localObject1);
          localObject2 = (dji)((djh)localObject1).mediaList.getFirst();
          if (localObject2 != null) {
            break label380;
          }
          localObject1 = null;
          a.aCW((String)localObject1);
          localObject1 = av.GiL;
          localObject1 = av.ir((int)((dji)localObject2).width, (int)((dji)localObject2).height);
          fqI().getLayoutParams().width = ((Number)((u)localObject1).bsD).intValue();
          fqI().getLayoutParams().height = ((Number)((u)localObject1).aiuN).intValue();
          fqI().setScaleType(android.widget.ImageView.ScaleType.values()[((Number)localObject1.bsC).intValue()]);
          fqI().requestLayout();
          if (((dji)localObject2).mediaType != 4) {
            break label388;
          }
          s.s(localObject2, "mediaObj");
          localObject1 = new n((dji)localObject2, v.FKZ, null, null, 12);
          localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
          localObject2 = com.tencent.mm.plugin.finder.loader.p.eCl();
          localObject3 = fqI();
          s.checkNotNull(localObject3);
          localObject3 = (ImageView)localObject3;
          localObject4 = com.tencent.mm.plugin.finder.loader.p.ExI;
          ((d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
        }
        for (;;)
        {
          fqI().setOnClickListener(new f..ExternalSyntheticLambda1(this));
          AppMethodBeat.o(168610);
          return;
          fqJ().setVisibility(8);
          break;
          label380:
          localObject1 = ((dji)localObject2).aaPd;
          break label181;
          label388:
          s.s(localObject2, "mediaObj");
          localObject1 = new n((dji)localObject2, v.FKZ, null, null, 12);
          localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
          localObject2 = com.tencent.mm.plugin.finder.loader.p.eCl();
          localObject3 = fqI();
          s.checkNotNull(localObject3);
          localObject3 = (ImageView)localObject3;
          localObject4 = com.tencent.mm.plugin.finder.loader.p.ExI;
          ((d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
        }
      }
    }
    Object localObject1 = fqx();
    if (localObject1 == null)
    {
      localObject1 = null;
      this.HaB = ((ArrayList)localObject1);
      localObject1 = fqx();
      if (localObject1 != null) {
        break label595;
      }
      localObject1 = null;
      label485:
      this.HaC = ((ArrayList)localObject1);
      localObject1 = fqx();
      if (localObject1 != null) {
        break label606;
      }
      localObject1 = null;
      label501:
      localObject2 = fqx();
      s.checkNotNull(localObject2);
      localObject2 = ((Bundle)localObject2).getParcelableArrayList("VIDEO_CROP_LIST");
      if (localObject2 == null) {
        break label629;
      }
      localObject2 = ((Iterable)localObject2).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label629;
      }
      localObject3 = (Parcelable)((Iterator)localObject2).next();
      if ((localObject3 != null) && ((localObject3 instanceof LocalVideoCropInfoParcelable)))
      {
        this.HaD.add(((LocalVideoCropInfoParcelable)localObject3).EDC);
        continue;
        localObject1 = ((Bundle)localObject1).getStringArrayList("MEDIA_FILE_LIST");
        break;
        label595:
        localObject1 = ((Bundle)localObject1).getIntegerArrayList("MEDIA_TYPE_LIST");
        break label485;
        label606:
        localObject1 = ((Bundle)localObject1).getStringArrayList("MEDIA_THUMB_LIST");
        break label501;
      }
      this.HaD.add(null);
    }
    label629:
    if (this.HaB != null)
    {
      localObject2 = this.HaB;
      s.checkNotNull(localObject2);
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject2 = this.HaB;
        s.checkNotNull(localObject2);
        if (((ArrayList)localObject2).size() <= 1) {
          break label762;
        }
        fqJ().setVisibility(8);
        localObject2 = fqJ();
        localObject3 = getContext();
        i = l.i.finder_image_count_tip;
        localObject4 = this.HaB;
        s.checkNotNull(localObject4);
        ((TextView)localObject2).setText((CharSequence)((Context)localObject3).getString(i, new Object[] { Integer.valueOf(((ArrayList)localObject4).size()) }));
        fqK().setVisibility(0);
      }
    }
    for (;;)
    {
      ThreadPool.post(new f..ExternalSyntheticLambda4(this, (ArrayList)localObject1), "Finder_Post_Create_Media_Thumb");
      AppMethodBeat.o(168610);
      return;
      label762:
      fqJ().setVisibility(8);
    }
  }
  
  public final boolean dqm()
  {
    AppMethodBeat.i(330869);
    Object localObject1 = this.HaB;
    if (localObject1 != null)
    {
      Object localObject2 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (String)((Iterator)localObject2).next();
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!y.ZC((String)localObject1)))
        {
          localObject2 = g.HaE;
          Log.i(g.access$getTAG$cp(), "[PostMixMediaWidget] widget file:" + (String)localObject1 + " lost!");
          AppMethodBeat.o(330869);
          return false;
        }
      }
    }
    AppMethodBeat.o(330869);
    return true;
  }
  
  public final View fqB()
  {
    AppMethodBeat.i(168608);
    Object localObject = ((Activity)getContext()).getLayoutInflater().inflate(l.f.finder_post_media_widget, null);
    s.s(localObject, "context as Activity).lay…_post_media_widget, null)");
    this.rootView = ((View)localObject);
    View localView = this.rootView;
    localObject = localView;
    if (localView == null)
    {
      s.bIx("rootView");
      localObject = null;
    }
    localObject = ((View)localObject).findViewById(l.e.thumb_view);
    s.s(localObject, "rootView.findViewById(R.id.thumb_view)");
    localObject = (PhotoView)localObject;
    s.u(localObject, "<set-?>");
    this.Hax = ((PhotoView)localObject);
    localView = this.rootView;
    localObject = localView;
    if (localView == null)
    {
      s.bIx("rootView");
      localObject = null;
    }
    localObject = ((View)localObject).findViewById(l.e.media_number);
    s.s(localObject, "rootView.findViewById(R.id.media_number)");
    localObject = (TextView)localObject;
    s.u(localObject, "<set-?>");
    this.Hay = ((TextView)localObject);
    localView = this.rootView;
    localObject = localView;
    if (localView == null)
    {
      s.bIx("rootView");
      localObject = null;
    }
    localObject = ((View)localObject).findViewById(l.e.video_play_icon);
    s.s(localObject, "rootView.findViewById(R.id.video_play_icon)");
    localObject = (ImageView)localObject;
    s.u(localObject, "<set-?>");
    this.Haz = ((ImageView)localObject);
    localView = this.rootView;
    localObject = localView;
    if (localView == null)
    {
      s.bIx("rootView");
      localObject = null;
    }
    localObject = ((View)localObject).findViewById(l.e.multi_icon);
    s.s(localObject, "rootView.findViewById(R.id.multi_icon)");
    s.u(localObject, "<set-?>");
    this.HaA = ((View)localObject);
    localView = this.rootView;
    localObject = localView;
    if (localView == null)
    {
      s.bIx("rootView");
      localObject = null;
    }
    localObject = ((View)localObject).findViewById(l.e.reprint_iv);
    s.s(localObject, "rootView.findViewById(R.id.reprint_iv)");
    this.Haj = ((View)localObject);
    localObject = this.rootView;
    if (localObject == null)
    {
      s.bIx("rootView");
      AppMethodBeat.o(168608);
      return null;
    }
    AppMethodBeat.o(168608);
    return localObject;
  }
  
  public final h fqC()
  {
    AppMethodBeat.i(330847);
    if ((fqy() != null) && (fqz() != null))
    {
      localObject1 = new h(true, 8, fqz());
      AppMethodBeat.o(330847);
      return localObject1;
    }
    Object localObject1 = (Collection)this.HaB;
    int i;
    Object localObject2;
    label155:
    label190:
    int j;
    String str1;
    label247:
    Object localObject4;
    String str2;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
    {
      i = 1;
      if (i != 0) {
        break label334;
      }
      localObject1 = TAG;
      localObject2 = new StringBuilder("media list ");
      Object localObject3 = this.HaB;
      s.checkNotNull(localObject3);
      Log.i((String)localObject1, ((ArrayList)localObject3).size() + ", thumb list " + this.Ham.size());
      localObject1 = this.HaB;
      s.checkNotNull(localObject1);
      if (((ArrayList)localObject1).size() != this.Ham.size()) {
        break label329;
      }
      i = 1;
      if (i == 0) {
        break label431;
      }
      localObject2 = new djh();
      localObject1 = this.HaB;
      s.checkNotNull(localObject1);
      localObject3 = ((Iterable)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject3).hasNext()) {
        break label410;
      }
      localObject1 = ((Iterator)localObject3).next();
      j = i + 1;
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      str1 = (String)localObject1;
      localObject1 = this.HaC;
      s.checkNotNull(localObject1);
      localObject1 = (Integer)((ArrayList)localObject1).get(i);
      if (localObject1 != null) {
        break label348;
      }
      localObject4 = ((djh)localObject2).mediaList;
      localObject1 = i.Gcb;
      str2 = Util.nullAsNil((String)this.Ham.get(i));
      s.s(str2, "nullAsNil(thumbFileList[index])");
      if (this.HaD.size() <= i) {
        break label405;
      }
    }
    label405:
    for (localObject1 = (dju)this.HaD.get(i);; localObject1 = null)
    {
      ((LinkedList)localObject4).add(i.a(str1, str2, (dju)localObject1));
      i = j;
      break label190;
      i = 0;
      break;
      label329:
      i = 0;
      break label155;
      label334:
      Log.i(TAG, "media list null");
      i = 0;
      break label155;
      label348:
      if (((Integer)localObject1).intValue() != 2) {
        break label247;
      }
      localObject1 = ((djh)localObject2).mediaList;
      localObject4 = i.Gcb;
      localObject4 = this.Ham.get(i);
      s.s(localObject4, "thumbFileList[index]");
      ((LinkedList)localObject1).add(i.in(str1, (String)localObject4));
      i = j;
      break label190;
    }
    label410:
    localObject1 = new h(true, 8, (djh)localObject2);
    AppMethodBeat.o(330847);
    return localObject1;
    label431:
    localObject1 = new h(false, 0, null);
    AppMethodBeat.o(330847);
    return localObject1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.f
 * JD-Core Version:    0.7.0.1
 */