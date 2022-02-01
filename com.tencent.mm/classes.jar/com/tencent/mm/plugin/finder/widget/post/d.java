package com.tencent.mm.plugin.finder.widget.post;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.protocal.protobuf.apb;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/widget/post/PostImageWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "activity", "Landroid/content/Context;", "postType", "", "(Landroid/content/Context;I)V", "imgFileList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "imgQualityList", "reprintIv", "Landroid/view/View;", "rootView", "thumbFileList", "thumbIv", "Landroid/widget/ImageView;", "checkData", "", "getUploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "inflateView", "jumpToPreviewMediaUI", "", "onCreate", "onDestroy", "refresh", "Companion", "plugin-finder_release"})
public final class d
  extends a
{
  private static final String TAG = "Finder.PostImageWidget";
  private static final String teP = "image_file_list";
  private static final String teQ = "image_quality_list";
  private static final String teR = "image_thumb_list";
  public static final a teS;
  private View kBS;
  private ImageView teJ;
  private View teK;
  private ArrayList<String> teL;
  private ArrayList<Integer> teM;
  private ArrayList<String> teN;
  private int teO;
  
  static
  {
    AppMethodBeat.i(168598);
    teS = new a((byte)0);
    teP = "image_file_list";
    teQ = "image_quality_list";
    teR = "image_thumb_list";
    TAG = "Finder.PostImageWidget";
    AppMethodBeat.o(168598);
  }
  
  private d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168597);
    this.teO = 2;
    this.teN = new ArrayList();
    AppMethodBeat.o(168597);
  }
  
  public final View cON()
  {
    AppMethodBeat.i(168594);
    Object localObject = this.context;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(168594);
      throw ((Throwable)localObject);
    }
    this.kBS = ((Activity)localObject).getLayoutInflater().inflate(2131494084, null);
    localObject = this.kBS;
    if (localObject == null) {
      d.g.b.p.gfZ();
    }
    this.teJ = ((ImageView)((View)localObject).findViewById(2131305801));
    localObject = this.kBS;
    if (localObject == null) {
      d.g.b.p.gfZ();
    }
    localObject = ((View)localObject).findViewById(2131304092);
    d.g.b.p.g(localObject, "rootView!!.findViewById(R.id.reprint_iv)");
    this.teK = ((View)localObject);
    localObject = this.kBS;
    AppMethodBeat.o(168594);
    return localObject;
  }
  
  public final h cOO()
  {
    int j = 0;
    AppMethodBeat.i(205804);
    if ((this.ter != null) && (this.tes != null))
    {
      localObject1 = new h(true, 2, this.tes);
      AppMethodBeat.o(205804);
      return localObject1;
    }
    Object localObject1 = (Collection)this.teL;
    int i;
    Object localObject2;
    Object localObject3;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
    {
      i = 1;
      if (i != 0) {
        break label306;
      }
      localObject1 = TAG;
      localObject2 = new StringBuilder("img list ");
      localObject3 = this.teL;
      if (localObject3 == null) {
        d.g.b.p.gfZ();
      }
      ad.i((String)localObject1, ((ArrayList)localObject3).size() + ", thumb list " + this.teN.size());
      localObject1 = this.teL;
      if (localObject1 == null) {
        d.g.b.p.gfZ();
      }
      if (((ArrayList)localObject1).size() != this.teN.size()) {
        break label301;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = new bve();
        Object localObject4;
        Object localObject5;
        if (this.teO == 7)
        {
          localObject2 = this.teL;
          if (localObject2 == null) {
            d.g.b.p.gfZ();
          }
          localObject2 = ((Iterable)localObject2).iterator();
          i = j;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            if (i < 0) {
              j.gfB();
            }
            localObject3 = (String)localObject3;
            localObject4 = ((bve)localObject1).mediaList;
            localObject5 = com.tencent.mm.plugin.finder.upload.i.sJt;
            localObject5 = this.teN.get(i);
            d.g.b.p.g(localObject5, "thumbFileList[index]");
            ((LinkedList)localObject4).add(com.tencent.mm.plugin.finder.upload.i.gv((String)localObject3, (String)localObject5));
            i += 1;
          }
          i = 0;
          break;
          label301:
          i = 0;
          continue;
          label306:
          ad.i(TAG, "img list null");
          i = 0;
          continue;
        }
        localObject2 = this.teL;
        if (localObject2 == null) {
          d.g.b.p.gfZ();
        }
        localObject2 = ((Iterable)localObject2).iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          if (i < 0) {
            j.gfB();
          }
          localObject4 = (String)localObject3;
          localObject3 = ((bve)localObject1).mediaList;
          localObject5 = com.tencent.mm.plugin.finder.upload.i.sJt;
          localObject5 = this.teN.get(i);
          d.g.b.p.g(localObject5, "thumbFileList[index]");
          localObject4 = com.tencent.mm.plugin.finder.upload.i.gu((String)localObject4, (String)localObject5);
          ((bvf)localObject4).codec_info = new apb();
          localObject5 = this.teM;
          if (localObject5 != null)
          {
            localObject5 = (Integer)j.E((List)localObject5, i);
            if (localObject5 != null)
            {
              j = ((Number)localObject5).intValue();
              ((bvf)localObject4).codec_info.GnA = j;
              ad.i(TAG, "codec_info hdimg_score:".concat(String.valueOf(j)));
            }
          }
          ((LinkedList)localObject3).add(localObject4);
          i += 1;
        }
        if (this.teO == 7)
        {
          localObject1 = new h(true, 7, (bve)localObject1);
          AppMethodBeat.o(205804);
          return localObject1;
        }
        localObject1 = new h(true, 2, (bve)localObject1);
        AppMethodBeat.o(205804);
        return localObject1;
      }
    }
    localObject1 = new h(false, 0, null);
    AppMethodBeat.o(205804);
    return localObject1;
  }
  
  public final void refresh()
  {
    Object localObject2 = null;
    AppMethodBeat.i(168596);
    Object localObject3;
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
        localObject1 = ((bve)localObject1).mediaList;
        d.g.b.p.g(localObject1, "refFeedContent!!.mediaList");
        localObject1 = (bvf)((LinkedList)localObject1).getFirst();
        localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
        localObject2 = com.tencent.mm.plugin.finder.utils.p.fT((int)((bvf)localObject1).width, (int)((bvf)localObject1).height);
        localObject3 = this.teJ;
        if (localObject3 == null) {
          d.g.b.p.gfZ();
        }
        ((ImageView)localObject3).getLayoutParams().width = ((Bundle)localObject2).getInt("media_layout_width", (int)((bvf)localObject1).width);
        localObject3 = this.teJ;
        if (localObject3 == null) {
          d.g.b.p.gfZ();
        }
        ((ImageView)localObject3).getLayoutParams().height = ((Bundle)localObject2).getInt("media_layout_height", (int)((bvf)localObject1).height);
        localObject3 = this.teJ;
        if (localObject3 == null) {
          d.g.b.p.gfZ();
        }
        ((ImageView)localObject3).setScaleType(android.widget.ImageView.ScaleType.values()[localObject2.getInt("media_layout_sale_type", android.widget.ImageView.ScaleType.CENTER_CROP.ordinal())]);
        localObject2 = this.teJ;
        if (localObject2 == null) {
          d.g.b.p.gfZ();
        }
        ((ImageView)localObject2).requestLayout();
        d.g.b.p.g(localObject1, "mediaObj");
        localObject1 = new com.tencent.mm.plugin.finder.loader.g((bvf)localObject1, r.syE);
        localObject2 = com.tencent.mm.plugin.finder.loader.i.sja;
        localObject2 = com.tencent.mm.plugin.finder.loader.i.cCB();
        localObject3 = this.teJ;
        if (localObject3 == null) {
          d.g.b.p.gfZ();
        }
        com.tencent.mm.plugin.finder.loader.i locali = com.tencent.mm.plugin.finder.loader.i.sja;
        ((com.tencent.mm.loader.d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.i.a(i.a.sjb));
        localObject1 = this.teJ;
        if (localObject1 == null) {
          d.g.b.p.gfZ();
        }
        ((ImageView)localObject1).setVisibility(0);
        localObject1 = this.teJ;
        if (localObject1 == null) {
          d.g.b.p.gfZ();
        }
        ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new b(this));
        AppMethodBeat.o(168596);
        return;
      }
    }
    Object localObject1 = this.dxT;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getStringArrayList(teP);
      this.teL = ((ArrayList)localObject1);
      localObject1 = this.dxT;
      if (localObject1 == null) {
        break label453;
      }
    }
    label453:
    for (localObject1 = ((Bundle)localObject1).getIntegerArrayList(teQ);; localObject1 = null)
    {
      this.teM = ((ArrayList)localObject1);
      localObject3 = this.dxT;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((Bundle)localObject3).getStringArrayList(teR);
      }
      if (this.teL != null)
      {
        localObject2 = this.teL;
        if (localObject2 == null) {
          d.g.b.p.gfZ();
        }
        if (((ArrayList)localObject2).size() > 0) {
          com.tencent.e.h.LTJ.f((Runnable)new c(this, (ArrayList)localObject1), "Finder_Post_Create_Image_Thumb");
        }
      }
      AppMethodBeat.o(168596);
      return;
      localObject1 = null;
      break;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/widget/post/PostImageWidget$Companion;", "", "()V", "IMAGE_FILE_LIST", "", "getIMAGE_FILE_LIST", "()Ljava/lang/String;", "IMAGE_QUALITY_LIST", "getIMAGE_QUALITY_LIST", "IMAGE_THUMB_LIST", "getIMAGE_THUMB_LIST", "TAG", "getTAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168590);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      d.a(this.teT);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168590);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(d paramd, ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(168593);
      Object localObject1 = d.b(this.teT);
      if (localObject1 == null) {
        d.g.b.p.gfZ();
      }
      Iterator localIterator = ((Iterable)localObject1).iterator();
      final int i = 0;
      while (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        int j = i + 1;
        if (i < 0) {
          j.gfB();
        }
        localObject1 = (String)localObject1;
        final boolean bool;
        if (i == 0)
        {
          bool = true;
          label79:
          if ((this.teU == null) || (this.teU.size() <= i) || (bt.isNullOrNil((String)this.teU.get(i)))) {
            break label179;
          }
        }
        for (localObject1 = (String)this.teU.get(i);; localObject1 = f.aiL((String)localObject1))
        {
          if (bt.isNullOrNil((String)localObject1)) {
            break label194;
          }
          Object localObject2 = com.tencent.mm.sdk.platformtools.g.decodeFile((String)localObject1);
          if (localObject2 == null) {
            break label194;
          }
          aq.f((Runnable)new a((Bitmap)localObject2, (String)localObject1, i, bool, (Bitmap)localObject2, this));
          i = j;
          break;
          bool = false;
          break label79;
          label179:
          localObject2 = f.sJc;
        }
        label194:
        i = j;
      }
      AppMethodBeat.o(168593);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$2$1$1$1", "com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$2$$special$$inlined$let$lambda$1"})
    static final class a
      implements Runnable
    {
      a(Bitmap paramBitmap1, String paramString, int paramInt, boolean paramBoolean, Bitmap paramBitmap2, d.c paramc) {}
      
      public final void run()
      {
        Object localObject4 = null;
        AppMethodBeat.i(168592);
        d.c(jdField_this.teT).add(this.teW);
        Object localObject1 = d.teS;
        ad.i(d.access$getTAG$cp(), "add thumb file, index:" + i);
        Bundle localBundle;
        Object localObject2;
        LinearLayout localLinearLayout;
        label233:
        label244:
        Object localObject3;
        if (bool)
        {
          localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
          localBundle = com.tencent.mm.plugin.finder.utils.p.fT(this.teY.getWidth(), this.teY.getHeight());
          int i = localBundle.getInt("media_layout_width", this.teY.getWidth());
          int j = localBundle.getInt("media_layout_height", this.teY.getHeight());
          localObject1 = d.d(jdField_this.teT);
          if (localObject1 == null) {
            d.g.b.p.gfZ();
          }
          ((ImageView)localObject1).getLayoutParams().width = i;
          localObject1 = d.d(jdField_this.teT);
          if (localObject1 == null) {
            d.g.b.p.gfZ();
          }
          ((ImageView)localObject1).getLayoutParams().height = j;
          localObject1 = d.e(jdField_this.teT);
          if (localObject1 == null) {
            break label580;
          }
          localObject1 = ((View)localObject1).getParent();
          localObject2 = localObject1;
          if (!(localObject1 instanceof LinearLayout)) {
            localObject2 = null;
          }
          localLinearLayout = (LinearLayout)localObject2;
          if (localLinearLayout == null) {
            break label585;
          }
          localObject1 = localLinearLayout.getRootView();
          if (localObject1 == null) {
            break label585;
          }
          localObject2 = (TextView)((View)localObject1).findViewById(2131303369);
          if (localLinearLayout == null) {
            break label591;
          }
          localObject1 = localLinearLayout.getLayoutParams();
          localObject3 = localObject1;
          if (!(localObject1 instanceof FrameLayout.LayoutParams)) {
            localObject3 = null;
          }
          localObject3 = (FrameLayout.LayoutParams)localObject3;
          localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
          if ((((Number)com.tencent.mm.plugin.finder.storage.b.cIi().value()).intValue() != 2) || (this.teY.getWidth() <= 0) || (this.teY.getHeight() <= 0) || (this.teY.getHeight() / this.teY.getWidth() < 1.316667F)) {
            break label596;
          }
          if (localObject3 != null) {
            ((FrameLayout.LayoutParams)localObject3).topMargin = 0;
          }
          if (localObject2 != null)
          {
            localObject1 = aj.getContext();
            d.g.b.p.g(localObject1, "MMApplicationContext.getContext()");
            ((TextView)localObject2).setTextColor(((Context)localObject1).getResources().getColor(2131099828));
          }
          localObject1 = d.e(jdField_this.teT);
          if (localObject1 != null)
          {
            localObject1 = ((View)localObject1).findViewById(2131308324);
            if (localObject1 != null)
            {
              ((View)localObject1).setVisibility(0);
              localObject2 = ((View)localObject1).getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).width = i;
              ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            }
          }
        }
        for (;;)
        {
          if (localLinearLayout != null) {
            localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          }
          localObject1 = d.d(jdField_this.teT);
          if (localObject1 == null) {
            d.g.b.p.gfZ();
          }
          ((ImageView)localObject1).setScaleType(android.widget.ImageView.ScaleType.values()[localBundle.getInt("media_layout_sale_type", android.widget.ImageView.ScaleType.CENTER_CROP.ordinal())]);
          localObject1 = d.d(jdField_this.teT);
          if (localObject1 == null) {
            d.g.b.p.gfZ();
          }
          ((ImageView)localObject1).requestLayout();
          localObject1 = d.d(jdField_this.teT);
          if (localObject1 == null) {
            d.g.b.p.gfZ();
          }
          ((ImageView)localObject1).setImageBitmap(this.teV);
          localObject1 = d.d(jdField_this.teT);
          if (localObject1 == null) {
            d.g.b.p.gfZ();
          }
          ((ImageView)localObject1).setVisibility(0);
          localObject1 = d.d(jdField_this.teT);
          if (localObject1 == null) {
            d.g.b.p.gfZ();
          }
          ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(168591);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$2$$special$$inlined$forEachIndexed$lambda$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              d.a(this.tfa.teZ.teT);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$2$$special$$inlined$forEachIndexed$lambda$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(168591);
            }
          });
          AppMethodBeat.o(168592);
          return;
          label580:
          localObject1 = null;
          break;
          label585:
          localObject2 = null;
          break label233;
          label591:
          localObject1 = null;
          break label244;
          label596:
          if (localObject2 != null)
          {
            localObject1 = aj.getContext();
            d.g.b.p.g(localObject1, "MMApplicationContext.getContext()");
            ((TextView)localObject2).setTextColor(((Context)localObject1).getResources().getColor(2131100711));
          }
          if (localObject3 != null)
          {
            localObject2 = d.e(jdField_this.teT);
            localObject1 = localObject4;
            if (localObject2 != null)
            {
              localObject2 = ((View)localObject2).getResources();
              localObject1 = localObject4;
              if (localObject2 != null) {
                localObject1 = Integer.valueOf((int)((Resources)localObject2).getDimension(2131165295));
              }
            }
            ((FrameLayout.LayoutParams)localObject3).topMargin = ((Integer)localObject1).intValue();
          }
          localObject1 = d.e(jdField_this.teT);
          if (localObject1 != null)
          {
            localObject1 = ((View)localObject1).findViewById(2131308324);
            if (localObject1 != null) {
              ((View)localObject1).setVisibility(8);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.d
 * JD-Core Version:    0.7.0.1
 */