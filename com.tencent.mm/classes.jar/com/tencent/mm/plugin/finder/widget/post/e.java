package com.tencent.mm.plugin.finder.widget.post;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.publish.l.b;
import com.tencent.mm.plugin.finder.publish.l.c;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.publish.l.f;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.boy;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.cyv;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dls;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/widget/post/PostImageWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "activity", "Landroid/content/Context;", "postType", "", "(Landroid/content/Context;I)V", "extraMusic", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "halfImgFileList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "halfRectList", "Landroid/graphics/Rect;", "halfThumbFileList", "imgFileList", "imgQualityList", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "reprintIv", "Landroid/view/View;", "rootView", "thumbFileList", "thumbIv", "Landroid/widget/ImageView;", "checkData", "", "checkFileExist", "delMedia", "", "getPicCount", "getUploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "inflateView", "jumpToPreviewMediaUI", "onCreate", "onDestroy", "refresh", "refreshByIntent", "showThumb", "thumb", "Landroid/graphics/Bitmap;", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends a
{
  public static final e.a Hag;
  private static final String Haq;
  private static final String Har;
  private static final String Has;
  private static final String Hat;
  private static final String TAG;
  private ArrayList<Rect> GZX;
  private int Hah;
  private ImageView Hai;
  private View Haj;
  public ArrayList<String> Hak;
  private ArrayList<Integer> Hal;
  private ArrayList<String> Ham;
  private dls Han;
  private ArrayList<String> Hao;
  private ArrayList<String> Hap;
  private bqj musicInfo;
  private View rootView;
  
  static
  {
    AppMethodBeat.i(168598);
    Hag = new e.a((byte)0);
    Haq = "image_file_list";
    Har = "image_quality_list";
    Has = "image_thumb_list";
    Hat = "half_image_file_list";
    TAG = "Finder.PostImageWidget";
    AppMethodBeat.o(168598);
  }
  
  private e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168597);
    this.Hah = 2;
    this.Ham = new ArrayList();
    this.Hap = new ArrayList();
    AppMethodBeat.o(168597);
  }
  
  private static final void a(e parame, View paramView)
  {
    AppMethodBeat.i(330781);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parame);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/widget/post/PostImageWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parame, "this$0");
    paramView = k.aeZF;
    ((com.tencent.mm.plugin.finder.post.f)k.nq(parame.getContext()).q(com.tencent.mm.plugin.finder.post.f.class)).eHz();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/widget/post/PostImageWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(330781);
  }
  
  private static final void a(e parame, com.tencent.mm.loader.g.a.a parama, com.tencent.mm.loader.d.b.g paramg, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(330771);
    s.u(parame, "this$0");
    if (paramBitmap != null) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(parame, paramBitmap));
    }
    AppMethodBeat.o(330771);
  }
  
  private static final void a(e parame, String paramString, ah.f paramf1, Bitmap paramBitmap, int paramInt, boolean paramBoolean, ah.f paramf2)
  {
    AppMethodBeat.i(330800);
    s.u(parame, "this$0");
    s.u(paramf1, "$halfThumbFile");
    s.u(paramf2, "$thumb");
    parame.Ham.add(paramString);
    if ((paramf1.aqH != null) && (paramBitmap != null))
    {
      paramString = parame.Hap;
      paramf1 = paramf1.aqH;
      s.checkNotNull(paramf1);
      paramString.add(paramf1);
    }
    Log.i(TAG, s.X("add thumb file, index:", Integer.valueOf(paramInt)));
    if (paramBoolean)
    {
      paramString = paramf2.aqH;
      s.s(paramString, "thumb");
      parame.ak((Bitmap)paramString);
      paramf1 = parame.Hai;
      paramString = paramf1;
      if (paramf1 == null)
      {
        s.bIx("thumbIv");
        paramString = null;
      }
      paramString.setOnClickListener(new e..ExternalSyntheticLambda0(parame));
    }
    AppMethodBeat.o(330800);
  }
  
  private static final void a(e parame, ArrayList paramArrayList)
  {
    AppMethodBeat.i(330812);
    s.u(parame, "this$0");
    Object localObject1 = parame.Hak;
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
      if (i == 0)
      {
        bool = true;
        label76:
        if ((paramArrayList == null) || (paramArrayList.size() <= i) || (Util.isNullOrNil((String)paramArrayList.get(i)))) {
          break label253;
        }
      }
      label253:
      for (localObject1 = (String)paramArrayList.get(i);; localObject1 = ((com.tencent.mm.plugin.finder.publish.a)com.tencent.mm.plugin.finder.upload.f.GbE).azz((String)localObject1))
      {
        ah.f localf = new ah.f();
        Object localObject2 = parame.Hao;
        if (localObject2 != null)
        {
          localObject2 = (String)kotlin.a.p.ae((List)localObject2, i);
          if (localObject2 != null) {
            localf.aqH = ((com.tencent.mm.plugin.finder.publish.a)com.tencent.mm.plugin.finder.upload.f.GbE).azz((String)localObject2);
          }
        }
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject2 = new ah.f();
          ((ah.f)localObject2).aqH = BitmapUtil.decodeFile((String)localObject1);
          Bitmap localBitmap = BitmapUtil.decodeFile((String)localf.aqH);
          if ((Bitmap)((ah.f)localObject2).aqH != null) {
            MMHandlerThread.postToMainThread(new e..ExternalSyntheticLambda3(parame, (String)localObject1, localf, localBitmap, i, bool, (ah.f)localObject2));
          }
        }
        i += 1;
        break;
        bool = false;
        break label76;
      }
    }
    AppMethodBeat.o(330812);
  }
  
  private final void ak(Bitmap paramBitmap)
  {
    Object localObject4 = null;
    AppMethodBeat.i(330764);
    Object localObject1 = av.GiL;
    kotlin.u localu = av.it(paramBitmap.getWidth(), paramBitmap.getHeight());
    int i = ((Number)localu.bsD).intValue();
    int j = ((Number)localu.aiuN).intValue();
    Object localObject2 = this.Hai;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("thumbIv");
      localObject1 = null;
    }
    ((ImageView)localObject1).getLayoutParams().width = i;
    localObject2 = this.Hai;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("thumbIv");
      localObject1 = null;
    }
    ((ImageView)localObject1).getLayoutParams().height = j;
    localObject2 = this.rootView;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("rootView");
      localObject1 = null;
    }
    ((ImageIndicatorView)((View)localObject1).findViewById(l.e.image_indicator)).getLayoutParams().width = i;
    localObject2 = this.rootView;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("rootView");
      localObject1 = null;
    }
    localObject1 = ((View)localObject1).getParent();
    label213:
    Object localObject3;
    if ((localObject1 instanceof LinearLayout))
    {
      localObject2 = (LinearLayout)localObject1;
      if (localObject2 != null) {
        break label508;
      }
      localObject1 = null;
      if (localObject2 != null) {
        break label542;
      }
      localObject3 = null;
      label221:
      if (!(localObject3 instanceof FrameLayout.LayoutParams)) {
        break label552;
      }
      localObject3 = (FrameLayout.LayoutParams)localObject3;
      label236:
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(MMApplicationContext.getContext().getResources().getColor(l.b.normal_text_color));
      }
      if (localObject3 != null)
      {
        localView = this.rootView;
        localObject1 = localView;
        if (localView == null)
        {
          s.bIx("rootView");
          localObject1 = null;
        }
        localObject1 = ((View)localObject1).getResources();
        if (localObject1 != null) {
          break label558;
        }
        localObject1 = null;
        label302:
        ((FrameLayout.LayoutParams)localObject3).topMargin = ((Integer)localObject1).intValue();
      }
      View localView = this.rootView;
      localObject1 = localView;
      if (localView == null)
      {
        s.bIx("rootView");
        localObject1 = null;
      }
      localObject1 = ((View)localObject1).findViewById(l.e.header_mask_view);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      if (localObject2 != null) {
        ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      }
      localObject1 = this.Hai;
      if (localObject1 != null) {
        break label575;
      }
      s.bIx("thumbIv");
      localObject1 = null;
      label393:
      ((ImageView)localObject1).setScaleType(android.widget.ImageView.ScaleType.values()[((Number)localu.bsC).intValue()]);
      localObject2 = this.Hai;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("thumbIv");
        localObject1 = null;
      }
      ((ImageView)localObject1).requestLayout();
      localObject2 = this.Hai;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("thumbIv");
        localObject1 = null;
      }
      ((ImageView)localObject1).setImageBitmap(paramBitmap);
      paramBitmap = this.Hai;
      if (paramBitmap != null) {
        break label578;
      }
      s.bIx("thumbIv");
      paramBitmap = localObject4;
    }
    label542:
    label552:
    label558:
    label575:
    label578:
    for (;;)
    {
      paramBitmap.setVisibility(0);
      AppMethodBeat.o(330764);
      return;
      localObject2 = null;
      break;
      label508:
      localObject1 = ((LinearLayout)localObject2).getRootView();
      if (localObject1 == null)
      {
        localObject1 = null;
        break label213;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(l.e.post_nickname);
      break label213;
      localObject3 = ((LinearLayout)localObject2).getLayoutParams();
      break label221;
      localObject3 = null;
      break label236;
      localObject1 = Integer.valueOf((int)((Resources)localObject1).getDimension(l.c.Edge_4_5_A));
      break label302;
      break label393;
    }
  }
  
  private static final void b(e parame, View paramView)
  {
    AppMethodBeat.i(330791);
    s.u(parame, "this$0");
    paramView = k.aeZF;
    ((com.tencent.mm.plugin.finder.post.f)k.nq(parame.getContext()).q(com.tencent.mm.plugin.finder.post.f.class)).eHz();
    AppMethodBeat.o(330791);
  }
  
  public final void bDL()
  {
    com.tencent.mm.plugin.finder.loader.p localp = null;
    Object localObject3 = null;
    AppMethodBeat.i(168596);
    super.bDL();
    if ((eHl().Gcx != null) && (!Util.isNullOrNil((List)eHl().GZZ)))
    {
      localObject1 = eHl().GZZ;
      if (localObject1 != null)
      {
        localObject1 = (dji)kotlin.a.p.oL((List)localObject1);
        if (localObject1 != null)
        {
          if (((dji)localObject1).mediaType != 4) {
            break label205;
          }
          if (!Util.isNullOrNil(((dji)localObject1).coverUrl)) {
            break label187;
          }
          localObject1 = (r)new n((dji)localObject1, v.FKZ, null, null, 12);
          localp = com.tencent.mm.plugin.finder.loader.p.ExI;
          localObject1 = com.tencent.mm.plugin.finder.loader.p.eCl().dk(localObject1);
          localp = com.tencent.mm.plugin.finder.loader.p.ExI;
          ((com.tencent.mm.loader.a.b)localObject1).a(com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ)).a(new e..ExternalSyntheticLambda2(this)).blg();
        }
      }
      localObject1 = this.Hai;
      if (localObject1 == null)
      {
        s.bIx("thumbIv");
        localObject1 = localObject3;
      }
      for (;;)
      {
        ((ImageView)localObject1).setOnClickListener(new e..ExternalSyntheticLambda1(this));
        AppMethodBeat.o(168596);
        return;
        label187:
        localObject1 = (r)new t((dji)localObject1, v.FKY);
        break;
        label205:
        localObject1 = (r)new n((dji)localObject1, v.FKZ, null, null, 12);
        break;
      }
    }
    super.bDL();
    Object localObject1 = fqx();
    if (localObject1 == null) {
      localObject1 = null;
    }
    label261:
    Object localObject4;
    int i;
    Object localObject2;
    for (;;)
    {
      this.Hak = ((ArrayList)localObject1);
      localObject1 = fqx();
      if (localObject1 == null)
      {
        localObject1 = null;
        this.Hal = ((ArrayList)localObject1);
        localObject1 = fqx();
        if (localObject1 != null)
        {
          localObject3 = ((Bundle)localObject1).getByteArray("MEDIA_EXTRA_MUSIC");
          if (localObject3 != null) {
            localObject1 = (com.tencent.mm.bx.a)new dls();
          }
        }
      }
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        this.Han = ((dls)localObject1);
        localObject3 = TAG;
        localObject1 = this.Han;
        if (localObject1 == null)
        {
          localObject1 = null;
          Log.i((String)localObject3, s.X("post image with music: ", localObject1));
          localObject1 = com.tencent.mm.plugin.finder.upload.i.Gcb;
          this.musicInfo = com.tencent.mm.plugin.finder.upload.i.a(this.Han);
          localObject1 = fqx();
          if (localObject1 != null)
          {
            localObject3 = ((Bundle)localObject1).getByteArray("ORIGIN_MUSIC_INFO");
            if (localObject3 != null) {
              localObject1 = (com.tencent.mm.bx.a)new bqj();
            }
          }
        }
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
            this.musicInfo = ((bqj)localObject1);
            localObject1 = fqx();
            if (localObject1 != null) {
              break label765;
            }
            localObject1 = null;
            this.Hao = ((ArrayList)localObject1);
            localObject1 = fqx();
            if (localObject1 != null) {
              break label776;
            }
            localObject1 = null;
            this.GZX = ((ArrayList)localObject1);
            if (this.musicInfo == null)
            {
              localObject1 = fqx();
              if (localObject1 != null) {
                break label787;
              }
              localObject1 = null;
              localObject3 = fqx();
              if (localObject3 != null) {
                break label798;
              }
              localObject3 = null;
              localObject4 = (CharSequence)localObject1;
              if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
                break label809;
              }
              i = 1;
              if (i != 0) {
                localObject1 = q.n((String)localObject3, true);
              }
              localObject3 = (CharSequence)localObject1;
              if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
                break label814;
              }
              i = 1;
              if (i == 0)
              {
                localObject3 = new bqj();
                ((bqj)localObject3).ZYp = ((String)localObject1);
                localObject1 = ah.aiuX;
                this.musicInfo = ((bqj)localObject3);
              }
            }
            localObject1 = this.Hak;
            if (localObject1 != null) {
              break label819;
            }
            localObject1 = null;
            a.aCW((String)localObject1);
            localObject1 = fqx();
            if (localObject1 != null) {
              break label833;
            }
            localObject1 = null;
            if (this.Hak != null)
            {
              localObject3 = this.Hak;
              s.checkNotNull(localObject3);
              if (((ArrayList)localObject3).size() > 0) {
                com.tencent.threadpool.h.ahAA.g(new e..ExternalSyntheticLambda4(this, (ArrayList)localObject1), "Finder_Post_Create_Image_Thumb");
              }
            }
            localObject3 = this.rootView;
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              s.bIx("rootView");
              localObject1 = null;
            }
            localObject4 = (ImageIndicatorView)((View)localObject1).findViewById(l.e.image_indicator);
            if (localObject4 != null) {
              ((ImageIndicatorView)localObject4).setVisibility(0);
            }
            localObject3 = this.Hak;
            if (localObject3 != null) {
              break label844;
            }
            localObject1 = localp;
            if ((localObject1 == null) && (localObject4 != null)) {
              ((ImageIndicatorView)localObject4).setVisibility(8);
            }
            AppMethodBeat.o(168596);
            return;
            localObject1 = ((Bundle)localObject1).getStringArrayList(Haq);
            break;
            localObject1 = ((Bundle)localObject1).getIntegerArrayList(Har);
            break label261;
            localException1 = localException1;
            Log.printDebugStack("safeParser", "", new Object[] { localException1 });
            localInteger = null;
          }
          Integer localInteger = Integer.valueOf(localInteger.aaRI);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { localException2 });
            localObject2 = null;
            continue;
            label765:
            localObject2 = ((Bundle)localObject2).getStringArrayList(Hat);
            continue;
            label776:
            localObject2 = ((Bundle)localObject2).getParcelableArrayList("HALF_RECT_LIST");
            continue;
            label787:
            localObject2 = ((Bundle)localObject2).getString("ORIGIN_BGM_URL");
            continue;
            label798:
            localObject3 = ((Bundle)localObject3).getString("ORIGIN_MUSIC_PATH");
            continue;
            label809:
            i = 0;
            continue;
            label814:
            i = 0;
            continue;
            label819:
            localObject2 = (String)kotlin.a.p.oL((List)localObject2);
            continue;
            label833:
            localObject2 = ((Bundle)localObject2).getStringArrayList(Has);
          }
        }
      }
    }
    label844:
    if (((ArrayList)localObject3).size() > 0)
    {
      i = 1;
      label853:
      if (i == 0) {
        break label893;
      }
    }
    for (;;)
    {
      localObject2 = localp;
      if (localObject3 == null) {
        break;
      }
      localObject2 = localp;
      if (localObject4 == null) {
        break;
      }
      ((ImageIndicatorView)localObject4).RVj = ((ArrayList)localObject3).size();
      localObject2 = ah.aiuX;
      break;
      i = 0;
      break label853;
      label893:
      localObject3 = null;
    }
  }
  
  public final boolean dqm()
  {
    AppMethodBeat.i(330917);
    Object localObject1 = this.Hak;
    if (localObject1 != null)
    {
      Object localObject2 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (String)((Iterator)localObject2).next();
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!y.ZC((String)localObject1)))
        {
          localObject2 = g.HaE;
          Log.i(g.access$getTAG$cp(), "image widget file:" + (String)localObject1 + " lost!");
          AppMethodBeat.o(330917);
          return false;
        }
      }
    }
    AppMethodBeat.o(330917);
    return true;
  }
  
  public final void fqA()
  {
    AppMethodBeat.i(330924);
    this.Hak = null;
    this.Hal = null;
    this.Ham.clear();
    this.Han = null;
    this.musicInfo = null;
    this.Hao = null;
    this.Hap.clear();
    this.GZX = null;
    AppMethodBeat.o(330924);
  }
  
  public final View fqB()
  {
    AppMethodBeat.i(168594);
    Object localObject = ((Activity)getContext()).getLayoutInflater().inflate(l.f.finder_post_image_widget, null);
    s.s(localObject, "context as Activity).lay…_post_image_widget, null)");
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
    this.Hai = ((ImageView)localObject);
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
      AppMethodBeat.o(168594);
      return null;
    }
    AppMethodBeat.o(168594);
    return localObject;
  }
  
  public final h fqC()
  {
    Object localObject3 = null;
    int j = 0;
    AppMethodBeat.i(330887);
    Object localObject1 = eHl().Gcx;
    if ((localObject1 != null) && (!Util.isNullOrNil((List)eHl().GZZ)))
    {
      localObject1 = new h(true, ((FinderItem)localObject1).getMediaType(), null);
      AppMethodBeat.o(330887);
      return localObject1;
    }
    Object localObject2 = (Collection)this.Hak;
    Object localObject4;
    label186:
    label224:
    LinkedList localLinkedList;
    dji localdji;
    label396:
    String str;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty()))
    {
      i = 1;
      if (i != 0) {
        break label605;
      }
      localObject2 = TAG;
      localObject4 = new StringBuilder("img list ");
      Object localObject5 = this.Hak;
      s.checkNotNull(localObject5);
      Log.i((String)localObject2, ((ArrayList)localObject5).size() + ", thumb list " + this.Ham.size());
      localObject2 = this.Hak;
      s.checkNotNull(localObject2);
      if (((ArrayList)localObject2).size() != this.Ham.size()) {
        break label600;
      }
      i = 1;
      if (i == 0) {
        break label923;
      }
      localObject4 = new djh();
      localObject1 = this.Hak;
      s.checkNotNull(localObject1);
      localObject5 = ((Iterable)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject5).hasNext()) {
        break label653;
      }
      localObject1 = ((Iterator)localObject5).next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject1 = (String)localObject1;
      localLinkedList = ((djh)localObject4).mediaList;
      localObject2 = com.tencent.mm.plugin.finder.upload.i.Gcb;
      localObject2 = this.Ham.get(i);
      s.s(localObject2, "thumbFileList[index]");
      localdji = com.tencent.mm.plugin.finder.upload.i.in((String)localObject1, (String)localObject2);
      localObject1 = new boy();
      localObject2 = this.Hal;
      if (localObject2 != null)
      {
        localObject2 = (Integer)kotlin.a.p.ae((List)localObject2, i);
        if (localObject2 != null)
        {
          int k = ((Number)localObject2).intValue();
          ((boy)localObject1).ZXu = k;
          Log.i(TAG, s.X("codec_info hdimg_score:", Integer.valueOf(k)));
        }
      }
      localObject2 = ah.aiuX;
      localdji.codec_info = ((boy)localObject1);
      localObject1 = this.Hao;
      if (localObject1 != null) {
        break label619;
      }
      localObject1 = null;
      str = (String)kotlin.a.p.ae((List)this.Hap, i);
      localObject2 = this.GZX;
      if (localObject2 != null) {
        break label636;
      }
    }
    label600:
    label605:
    label619:
    label636:
    for (localObject2 = null;; localObject2 = (Rect)kotlin.a.p.ae((List)localObject2, i))
    {
      if ((localObject1 != null) && (str != null) && (localObject2 != null))
      {
        cyv localcyv = new cyv();
        localcyv.IdD = ((String)localObject1);
        aw localaw = aw.Gjk;
        localObject1 = aw.aBX((String)localObject1);
        localcyv.width = ((Point)localObject1).x;
        localcyv.height = ((Point)localObject1).y;
        localcyv.thumbUrl = str;
        localObject1 = ah.aiuX;
        localdji.aaPo = localcyv;
        localObject1 = new bbn();
        ((bbn)localObject1).left = ((Rect)localObject2).left;
        ((bbn)localObject1).top = ((Rect)localObject2).top;
        ((bbn)localObject1).right = ((Rect)localObject2).right;
        ((bbn)localObject1).bottom = ((Rect)localObject2).bottom;
        localObject2 = ah.aiuX;
        localdji.aaPl = ((bbn)localObject1);
      }
      localObject1 = ah.aiuX;
      localLinkedList.add(localdji);
      i += 1;
      break label224;
      i = 0;
      break;
      i = 0;
      break label186;
      Log.i(TAG, "img list null");
      i = 0;
      break label186;
      localObject1 = (String)kotlin.a.p.ae((List)localObject1, i);
      break label396;
    }
    label653:
    localObject1 = fqx();
    label688:
    label709:
    boolean bool;
    if (localObject1 == null)
    {
      localObject1 = null;
      ((djh)localObject4).FSW = ((String)localObject1);
      localObject1 = fqx();
      if (localObject1 != null) {
        break label843;
      }
      localObject1 = null;
      ((djh)localObject4).FSU = ((String)localObject1);
      localObject1 = fqx();
      if (localObject1 != null) {
        break label856;
      }
      localObject1 = null;
      ((djh)localObject4).aaPa = ((String)localObject1);
      localObject1 = fqx();
      if (localObject1 != null) {
        break label869;
      }
      bool = false;
      label730:
      ((djh)localObject4).GZQ = bool;
      localObject1 = fqx();
      if (localObject1 != null) {
        break label883;
      }
      bool = false;
      label751:
      ((djh)localObject4).GZR = bool;
      localObject1 = fqx();
      if (localObject1 != null) {
        break label897;
      }
      i = j;
      label771:
      ((djh)localObject4).soundTrackType = i;
      localObject1 = fqx();
      if (localObject1 != null) {
        break label910;
      }
    }
    label897:
    label910:
    for (localObject1 = localObject3;; localObject1 = ((Bundle)localObject1).getString("MUSIC_FEED_ID"))
    {
      ((djh)localObject4).musicFeedId = ((String)localObject1);
      ((djh)localObject4).aaOZ = this.musicInfo;
      localObject1 = new h(true, 2, (djh)localObject4);
      AppMethodBeat.o(330887);
      return localObject1;
      localObject1 = ((Bundle)localObject1).getString("ORIGIN_MUSIC_ID");
      break;
      label843:
      localObject1 = ((Bundle)localObject1).getString("ORIGIN_MUSIC_PATH");
      break label688;
      label856:
      localObject1 = ((Bundle)localObject1).getString("ORIGIN_BGM_URL");
      break label709;
      label869:
      bool = ((Bundle)localObject1).getBoolean("MEDIA_IS_MUTE", false);
      break label730;
      label883:
      bool = ((Bundle)localObject1).getBoolean("MUSIC_IS_MUTE", false);
      break label751;
      i = ((Bundle)localObject1).getInt("SOUND_TRACK_TYPE", 0);
      break label771;
    }
    label923:
    if (localObject1 == null) {}
    for (int i = 0;; i = ((FinderItem)localObject1).getMediaType())
    {
      localObject1 = new h(false, i, null);
      AppMethodBeat.o(330887);
      return localObject1;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    b(e parame, Bitmap paramBitmap)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.e
 * JD-Core Version:    0.7.0.1
 */