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
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.upload.i;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.erf;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.s;
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
import kotlin.r;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mediaCountView", "Landroid/widget/TextView;", "getMediaCountView", "()Landroid/widget/TextView;", "setMediaCountView", "(Landroid/widget/TextView;)V", "mediaCropInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "Lkotlin/collections/ArrayList;", "getMediaCropInfoList", "()Ljava/util/ArrayList;", "setMediaCropInfoList", "(Ljava/util/ArrayList;)V", "mediaFileList", "", "getMediaFileList", "setMediaFileList", "mediaTypeList", "", "getMediaTypeList", "setMediaTypeList", "multiIcon", "Landroid/view/View;", "getMultiIcon", "()Landroid/view/View;", "setMultiIcon", "(Landroid/view/View;)V", "reprintIv", "rootView", "thumbFileList", "getThumbFileList", "setThumbFileList", "thumbIv", "Lcom/tencent/mm/view/PhotoView;", "getThumbIv", "()Lcom/tencent/mm/view/PhotoView;", "setThumbIv", "(Lcom/tencent/mm/view/PhotoView;)V", "videoPlayIcon", "Landroid/widget/ImageView;", "getVideoPlayIcon", "()Landroid/widget/ImageView;", "setVideoPlayIcon", "(Landroid/widget/ImageView;)V", "checkData", "", "checkFileExist", "getThumbFile", "index", "file", "mediaThumbList", "getUploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "inflateView", "initCropInfo", "", "jumpToPreviewMediaUI", "onCreate", "onDestroy", "refresh", "showMediaThumb", "showVideoThumb", "thumbFile", "showThumb", "Companion", "plugin-finder_release"})
public final class e
  extends a
{
  private static final String TAG = "Finder.PostMixMediaWidget";
  public static final a wDd;
  private View lJI;
  private View wCA;
  ArrayList<String> wCD;
  public PhotoView wCW;
  public TextView wCX;
  protected ImageView wCY;
  public View wCZ;
  private ArrayList<String> wDa;
  private ArrayList<Integer> wDb;
  private ArrayList<cjx> wDc;
  
  static
  {
    AppMethodBeat.i(168612);
    wDd = new a((byte)0);
    TAG = "Finder.PostMixMediaWidget";
    AppMethodBeat.o(168612);
  }
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168611);
    this.wCD = new ArrayList();
    this.wDc = new ArrayList();
    AppMethodBeat.o(168611);
  }
  
  public final void an(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(256126);
    Object localObject1 = this.wDa;
    if (localObject1 == null) {
      p.hyc();
    }
    Iterator localIterator = ((Iterable)localObject1).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (i < 0) {
        j.hxH();
      }
      localObject1 = (String)localObject1;
      final boolean bool;
      label72:
      Object localObject2;
      if (i == 0)
      {
        bool = true;
        a.wCj = (String)localObject1;
        p.h(localObject1, "file");
        localObject2 = this.wDb;
        if (localObject2 == null) {
          p.hyc();
        }
        localObject2 = (Integer)((ArrayList)localObject2).get(i);
        if (localObject2 != null) {
          break label295;
        }
        label114:
        if ((paramArrayList == null) || (paramArrayList.size() <= i) || (Util.isNullOrNil((String)paramArrayList.get(i))) || (!s.YS((String)paramArrayList.get(i)))) {
          break label369;
        }
        localObject1 = paramArrayList.get(i);
        p.g(localObject1, "mediaThumbList[index]");
        localObject1 = (String)localObject1;
      }
      for (;;)
      {
        p.h(localObject1, "thumbFile");
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
          localObject1 = this.wCY;
          if (localObject1 == null) {
            p.btv("videoPlayIcon");
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
          p.g(localObject1, "mediaThumbList[index]");
          localObject1 = (String)localObject1;
        }
        else
        {
          localObject2 = com.tencent.mm.plugin.finder.upload.f.vSz;
          localObject1 = com.tencent.mm.plugin.finder.upload.f.avU((String)localObject1);
          continue;
          label369:
          if ((this.wDc.size() > i) && (this.wDc.get(i) != null))
          {
            localObject2 = this.wDc.get(i);
            if (localObject2 == null) {
              p.hyc();
            }
            if (((cjx)localObject2).Mps != null)
            {
              localObject2 = com.tencent.mm.plugin.finder.upload.f.vSz;
              Object localObject3 = this.wDc.get(i);
              if (localObject3 == null) {
                p.hyc();
              }
              localObject3 = ((cjx)localObject3).Mps;
              if (localObject3 == null) {
                p.hyc();
              }
              p.g(localObject3, "mediaCropInfoList[index]!!.thumbRect!!");
              localObject1 = ((com.tencent.mm.plugin.finder.upload.f)localObject2).a((String)localObject1, (erf)localObject3);
              continue;
            }
          }
          Log.w(TAG, "no thumb & no thumbRect");
          localObject2 = com.tencent.mm.plugin.finder.upload.f.vSz;
          localObject1 = com.tencent.mm.plugin.finder.upload.f.avT((String)localObject1);
        }
      }
    }
    AppMethodBeat.o(256126);
  }
  
  public final boolean cyn()
  {
    AppMethodBeat.i(256128);
    Object localObject1 = this.wDa;
    if (localObject1 != null)
    {
      Object localObject2 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (String)((Iterator)localObject2).next();
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!s.YS((String)localObject1)))
        {
          localObject2 = f.wDt;
          Log.i(f.access$getTAG$cp(), "[PostMixMediaWidget] widget file:" + (String)localObject1 + " lost!");
          AppMethodBeat.o(256128);
          return false;
        }
      }
    }
    AppMethodBeat.o(256128);
    return true;
  }
  
  public final View dJg()
  {
    AppMethodBeat.i(168608);
    Object localObject = this.context;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(168608);
      throw ((Throwable)localObject);
    }
    localObject = ((Activity)localObject).getLayoutInflater().inflate(2131494574, null);
    p.g(localObject, "(context as Activity).la…_post_media_widget, null)");
    this.lJI = ((View)localObject);
    localObject = this.lJI;
    if (localObject == null) {
      p.btv("rootView");
    }
    localObject = ((View)localObject).findViewById(2131309076);
    p.g(localObject, "rootView.findViewById(R.id.thumb_view)");
    this.wCW = ((PhotoView)localObject);
    localObject = this.lJI;
    if (localObject == null) {
      p.btv("rootView");
    }
    localObject = ((View)localObject).findViewById(2131304565);
    p.g(localObject, "rootView.findViewById(R.id.media_number)");
    this.wCX = ((TextView)localObject);
    localObject = this.lJI;
    if (localObject == null) {
      p.btv("rootView");
    }
    localObject = ((View)localObject).findViewById(2131309794);
    p.g(localObject, "rootView.findViewById(R.id.video_play_icon)");
    this.wCY = ((ImageView)localObject);
    localObject = this.lJI;
    if (localObject == null) {
      p.btv("rootView");
    }
    localObject = ((View)localObject).findViewById(2131304995);
    p.g(localObject, "rootView.findViewById(R.id.multi_icon)");
    this.wCZ = ((View)localObject);
    localObject = this.lJI;
    if (localObject == null) {
      p.btv("rootView");
    }
    localObject = ((View)localObject).findViewById(2131306958);
    p.g(localObject, "rootView.findViewById(R.id.reprint_iv)");
    this.wCA = ((View)localObject);
    localObject = this.lJI;
    if (localObject == null) {
      p.btv("rootView");
    }
    AppMethodBeat.o(168608);
    return localObject;
  }
  
  public final g dJh()
  {
    AppMethodBeat.i(256125);
    if ((this.vTz != null) && (this.wCb != null))
    {
      localObject1 = new g(true, 8, this.wCb);
      AppMethodBeat.o(256125);
      return localObject1;
    }
    Object localObject1 = (Collection)this.wDa;
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
      Object localObject3 = this.wDa;
      if (localObject3 == null) {
        p.hyc();
      }
      Log.i((String)localObject1, ((ArrayList)localObject3).size() + ", thumb list " + this.wCD.size());
      localObject1 = this.wDa;
      if (localObject1 == null) {
        p.hyc();
      }
      if (((ArrayList)localObject1).size() != this.wCD.size()) {
        break label341;
      }
      i = 1;
      if (i == 0) {
        break label443;
      }
      localObject2 = new cjk();
      localObject1 = this.wDa;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject3 = ((Iterable)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject3).hasNext()) {
        break label422;
      }
      localObject1 = ((Iterator)localObject3).next();
      j = i + 1;
      if (i < 0) {
        j.hxH();
      }
      str1 = (String)localObject1;
      localObject1 = this.wDb;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = (Integer)((ArrayList)localObject1).get(i);
      if (localObject1 != null) {
        break label360;
      }
      localObject4 = ((cjk)localObject2).mediaList;
      localObject1 = i.vSX;
      str2 = Util.nullAsNil((String)this.wCD.get(i));
      p.g(str2, "Util.nullAsNil(thumbFileList[index])");
      if (this.wDc.size() <= i) {
        break label417;
      }
    }
    label417:
    for (localObject1 = (cjx)this.wDc.get(i);; localObject1 = null)
    {
      ((LinkedList)localObject4).add(i.a(str1, str2, (cjx)localObject1));
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
      localObject1 = ((cjk)localObject2).mediaList;
      localObject4 = i.vSX;
      localObject4 = this.wCD.get(i);
      p.g(localObject4, "thumbFileList[index]");
      ((LinkedList)localObject1).add(i.hb(str1, (String)localObject4));
      i = j;
      break label199;
    }
    label422:
    localObject1 = new g(true, 8, (cjk)localObject2);
    AppMethodBeat.o(256125);
    return localObject1;
    label443:
    localObject1 = new g(false, 0, null);
    AppMethodBeat.o(256125);
    return localObject1;
  }
  
  public final PhotoView dJm()
  {
    AppMethodBeat.i(256124);
    PhotoView localPhotoView = this.wCW;
    if (localPhotoView == null) {
      p.btv("thumbIv");
    }
    AppMethodBeat.o(256124);
    return localPhotoView;
  }
  
  public final void dJn()
  {
    AppMethodBeat.i(256127);
    cjk localcjk = new cjk();
    if (this.wCb != null)
    {
      localObject1 = this.wCb;
      if (localObject1 == null) {
        p.hyc();
      }
      if (!Util.isNullOrNil((List)((cjk)localObject1).mediaList))
      {
        localObject1 = localcjk.mediaList;
        localObject2 = this.wCb;
        if (localObject2 == null) {
          p.hyc();
        }
        ((LinkedList)localObject1).addAll((Collection)((cjk)localObject2).mediaList);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
        localObject1 = this.context;
        if (localObject1 != null) {
          break label336;
        }
        localObject1 = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(256127);
        throw ((Throwable)localObject1);
      }
    }
    Object localObject1 = this.wDa;
    if (localObject1 == null) {
      p.hyc();
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
        j.hxH();
      }
      localObject3 = (String)localObject1;
      localObject1 = this.wDb;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = (Integer)((ArrayList)localObject1).get(i);
      if (localObject1 == null)
      {
        localObject4 = localcjk.mediaList;
        localObject1 = i.vSX;
        str = Util.nullAsNil((String)this.wCD.get(i));
        p.g(str, "Util.nullAsNil(thumbFileList[index])");
        if (this.wDc.size() <= i) {
          break label331;
        }
      }
    }
    label331:
    for (localObject1 = (cjx)this.wDc.get(i);; localObject1 = null)
    {
      ((LinkedList)localObject4).add(i.a((String)localObject3, str, (cjx)localObject1));
      i = j;
      break label137;
      if (((Integer)localObject1).intValue() != 2) {
        break label197;
      }
      localObject1 = localcjk.mediaList;
      localObject4 = i.vSX;
      localObject4 = this.wCD.get(i);
      p.g(localObject4, "thumbFileList[index]");
      ((LinkedList)localObject1).add(i.hb((String)localObject3, (String)localObject4));
      i = j;
      break label137;
      break;
    }
    label336:
    localObject1 = (Activity)localObject1;
    localObject2 = this.wCW;
    if (localObject2 == null) {
      p.btv("thumbIv");
    }
    localObject2 = (View)localObject2;
    Object localObject3 = this.context;
    if (localObject3 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(256127);
      throw ((Throwable)localObject1);
    }
    localObject3 = ((MMActivity)localObject3).getWindow();
    p.g(localObject3, "(context as MMActivity).window");
    com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject1, ViewAnimHelper.q((View)localObject2, ((Window)localObject3).getDecorView()), localcjk, this.vTz, false, 16);
    AppMethodBeat.o(256127);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(168610);
    super.refresh();
    Object localObject2;
    Object localObject3;
    label230:
    Object localObject4;
    if (this.wCb != null)
    {
      localObject1 = this.wCb;
      if (localObject1 == null) {
        p.hyc();
      }
      if (!Util.isNullOrNil((List)((cjk)localObject1).mediaList))
      {
        localObject1 = this.wCA;
        if (localObject1 == null) {
          p.btv("reprintIv");
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = this.wCb;
        if (localObject1 == null) {
          p.hyc();
        }
        if (((cjk)localObject1).mediaList.size() > 1)
        {
          localObject1 = this.wCX;
          if (localObject1 == null) {
            p.btv("mediaCountView");
          }
          ((TextView)localObject1).setVisibility(8);
          localObject1 = this.wCX;
          if (localObject1 == null) {
            p.btv("mediaCountView");
          }
          localObject2 = this.context;
          localObject3 = this.wCb;
          if (localObject3 == null) {
            p.hyc();
          }
          ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getString(2131759814, new Object[] { Integer.valueOf(((cjk)localObject3).mediaList.size()) }));
          localObject1 = this.wCZ;
          if (localObject1 == null) {
            p.btv("multiIcon");
          }
          ((View)localObject1).setVisibility(0);
          localObject1 = this.wCb;
          if (localObject1 == null) {
            p.hyc();
          }
          localObject1 = ((cjk)localObject1).mediaList;
          p.g(localObject1, "refFeedContent!!.mediaList");
          localObject2 = (cjl)((LinkedList)localObject1).getFirst();
          if (localObject2 == null) {
            break label512;
          }
          localObject1 = ((cjl)localObject2).MoM;
          a.wCj = (String)localObject1;
          localObject1 = y.vXH;
          localObject1 = y.go((int)((cjl)localObject2).width, (int)((cjl)localObject2).height);
          localObject3 = this.wCW;
          if (localObject3 == null) {
            p.btv("thumbIv");
          }
          ((PhotoView)localObject3).getLayoutParams().width = ((Number)((r)localObject1).second).intValue();
          localObject3 = this.wCW;
          if (localObject3 == null) {
            p.btv("thumbIv");
          }
          ((PhotoView)localObject3).getLayoutParams().height = ((Number)((r)localObject1).SWY).intValue();
          localObject3 = this.wCW;
          if (localObject3 == null) {
            p.btv("thumbIv");
          }
          ((PhotoView)localObject3).setScaleType(android.widget.ImageView.ScaleType.values()[((Number)localObject1.first).intValue()]);
          localObject1 = this.wCW;
          if (localObject1 == null) {
            p.btv("thumbIv");
          }
          ((PhotoView)localObject1).requestLayout();
          if (((cjl)localObject2).mediaType != 4) {
            break label517;
          }
          p.g(localObject2, "mediaObj");
          localObject1 = new k((cjl)localObject2, x.vEo, null, null, 12);
          localObject2 = m.uJa;
          localObject2 = m.djY();
          localObject3 = this.wCW;
          if (localObject3 == null) {
            p.btv("thumbIv");
          }
          if (localObject3 == null) {
            p.hyc();
          }
          localObject3 = (ImageView)localObject3;
          localObject4 = m.uJa;
          ((d)localObject2).a(localObject1, (ImageView)localObject3, m.a(m.a.uJb));
        }
        for (;;)
        {
          localObject1 = this.wCW;
          if (localObject1 == null) {
            p.btv("thumbIv");
          }
          ((PhotoView)localObject1).setOnClickListener((View.OnClickListener)new b(this));
          AppMethodBeat.o(168610);
          return;
          localObject1 = this.wCX;
          if (localObject1 == null) {
            p.btv("mediaCountView");
          }
          ((TextView)localObject1).setVisibility(8);
          break;
          label512:
          localObject1 = null;
          break label230;
          label517:
          p.g(localObject2, "mediaObj");
          localObject1 = new k((cjl)localObject2, x.vEo, null, null, 12);
          localObject2 = m.uJa;
          localObject2 = m.djY();
          localObject3 = this.wCW;
          if (localObject3 == null) {
            p.btv("thumbIv");
          }
          if (localObject3 == null) {
            p.hyc();
          }
          localObject3 = (ImageView)localObject3;
          localObject4 = m.uJa;
          ((d)localObject2).a(localObject1, (ImageView)localObject3, m.a(m.a.uJb));
        }
      }
    }
    Object localObject1 = this.dQL;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getStringArrayList("MEDIA_FILE_LIST");
      this.wDa = ((ArrayList)localObject1);
      localObject1 = this.dQL;
      if (localObject1 == null) {
        break label743;
      }
      localObject1 = ((Bundle)localObject1).getIntegerArrayList("MEDIA_TYPE_LIST");
      label634:
      this.wDb = ((ArrayList)localObject1);
      localObject1 = this.dQL;
      if (localObject1 == null) {
        break label748;
      }
      localObject1 = ((Bundle)localObject1).getStringArrayList("MEDIA_THUMB_LIST");
      label656:
      localObject2 = this.dQL;
      if (localObject2 == null) {
        p.hyc();
      }
      localObject2 = ((Bundle)localObject2).getParcelableArrayList("VIDEO_CROP_LIST");
      if (localObject2 == null) {
        break label765;
      }
      localObject2 = ((Iterable)localObject2).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label765;
      }
      localObject3 = (Parcelable)((Iterator)localObject2).next();
      if ((localObject3 != null) && ((localObject3 instanceof LocalVideoCropInfoParcelable)))
      {
        this.wDc.add(((LocalVideoCropInfoParcelable)localObject3).uOR);
        continue;
        localObject1 = null;
        break;
        label743:
        localObject1 = null;
        break label634;
        label748:
        localObject1 = null;
        break label656;
      }
      this.wDc.add(null);
    }
    label765:
    if (this.wDa != null)
    {
      localObject2 = this.wDa;
      if (localObject2 == null) {
        p.hyc();
      }
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject2 = this.wDa;
        if (localObject2 == null) {
          p.hyc();
        }
        if (((ArrayList)localObject2).size() <= 1) {
          break label940;
        }
        localObject2 = this.wCX;
        if (localObject2 == null) {
          p.btv("mediaCountView");
        }
        ((TextView)localObject2).setVisibility(8);
        localObject2 = this.wCX;
        if (localObject2 == null) {
          p.btv("mediaCountView");
        }
        localObject3 = this.context;
        localObject4 = this.wDa;
        if (localObject4 == null) {
          p.hyc();
        }
        ((TextView)localObject2).setText((CharSequence)((Context)localObject3).getString(2131759814, new Object[] { Integer.valueOf(((ArrayList)localObject4).size()) }));
        localObject2 = this.wCZ;
        if (localObject2 == null) {
          p.btv("multiIcon");
        }
        ((View)localObject2).setVisibility(0);
      }
    }
    for (;;)
    {
      ThreadPool.post((Runnable)new c(this, (ArrayList)localObject1), "Finder_Post_Create_Media_Thumb");
      AppMethodBeat.o(168610);
      return;
      label940:
      localObject2 = this.wCX;
      if (localObject2 == null) {
        p.btv("mediaCountView");
      }
      ((TextView)localObject2).setVisibility(8);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168600);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.wDe.dJn();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168600);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(e parame, ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(168607);
      this.wDe.an(this.wDf);
      AppMethodBeat.o(168607);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$showVideoThumb$1$1"})
  static final class d
    implements Runnable
  {
    d(Bitmap paramBitmap1, e parame, String paramString, boolean paramBoolean, Bitmap paramBitmap2) {}
    
    public final void run()
    {
      AppMethodBeat.i(256123);
      jdField_this.wCD.add(this.wCP);
      Object localObject = e.wDd;
      Log.i(e.access$getTAG$cp(), "add thumb file");
      if (bool)
      {
        localObject = y.vXH;
        localObject = y.go(this.wDg.getWidth(), this.wDg.getHeight());
        jdField_this.dJm().getLayoutParams().width = ((Number)((r)localObject).second).intValue();
        jdField_this.dJm().getLayoutParams().height = ((Number)((r)localObject).SWY).intValue();
        jdField_this.dJm().setScaleType(android.widget.ImageView.ScaleType.values()[((Number)localObject.first).intValue()]);
        jdField_this.dJm().requestLayout();
        jdField_this.dJm().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(256121);
            this.wDh.wDe.dJm().setImageBitmap(this.wDh.qix);
            AppMethodBeat.o(256121);
          }
        });
        jdField_this.dJm().setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(256122);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$showVideoThumb$$inlined$let$lambda$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            this.wDh.wDe.dJn();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostMixMediaWidget$showVideoThumb$$inlined$let$lambda$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(256122);
          }
        });
      }
      AppMethodBeat.o(256123);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.e
 * JD-Core Version:    0.7.0.1
 */