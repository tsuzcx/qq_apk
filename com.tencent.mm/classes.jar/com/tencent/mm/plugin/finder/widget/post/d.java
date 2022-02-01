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
import com.tencent.mm.plugin.finder.loader.g;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.protocal.protobuf.apo;
import com.tencent.mm.protocal.protobuf.bvy;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import d.a.j;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/widget/post/PostImageWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "activity", "Landroid/content/Context;", "postType", "", "(Landroid/content/Context;I)V", "imgFileList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "imgQualityList", "reprintIv", "Landroid/view/View;", "rootView", "thumbFileList", "thumbIv", "Landroid/widget/ImageView;", "checkData", "", "getUploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "inflateView", "jumpToPreviewMediaUI", "", "onCreate", "onDestroy", "refresh", "Companion", "plugin-finder_release"})
public final class d
  extends a
{
  private static final String TAG = "Finder.PostImageWidget";
  private static final String tpI = "image_file_list";
  private static final String tpJ = "image_quality_list";
  private static final String tpK = "image_thumb_list";
  public static final a tpL;
  private View kFh;
  private ImageView tpC;
  private View tpD;
  private ArrayList<String> tpE;
  private ArrayList<Integer> tpF;
  private ArrayList<String> tpG;
  private int tpH;
  
  static
  {
    AppMethodBeat.i(168598);
    tpL = new a((byte)0);
    tpI = "image_file_list";
    tpJ = "image_quality_list";
    tpK = "image_thumb_list";
    TAG = "Finder.PostImageWidget";
    AppMethodBeat.o(168598);
  }
  
  private d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168597);
    this.tpH = 2;
    this.tpG = new ArrayList();
    AppMethodBeat.o(168597);
  }
  
  public final View cRs()
  {
    AppMethodBeat.i(168594);
    Object localObject = this.context;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(168594);
      throw ((Throwable)localObject);
    }
    this.kFh = ((Activity)localObject).getLayoutInflater().inflate(2131494084, null);
    localObject = this.kFh;
    if (localObject == null) {
      d.g.b.p.gkB();
    }
    this.tpC = ((ImageView)((View)localObject).findViewById(2131305801));
    localObject = this.kFh;
    if (localObject == null) {
      d.g.b.p.gkB();
    }
    localObject = ((View)localObject).findViewById(2131304092);
    d.g.b.p.g(localObject, "rootView!!.findViewById(R.id.reprint_iv)");
    this.tpD = ((View)localObject);
    localObject = this.kFh;
    AppMethodBeat.o(168594);
    return localObject;
  }
  
  public final h cRt()
  {
    int j = 0;
    AppMethodBeat.i(206418);
    if ((this.tpk != null) && (this.tpl != null))
    {
      localObject1 = new h(true, 2, this.tpl);
      AppMethodBeat.o(206418);
      return localObject1;
    }
    Object localObject1 = (Collection)this.tpE;
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
      localObject3 = this.tpE;
      if (localObject3 == null) {
        d.g.b.p.gkB();
      }
      ae.i((String)localObject1, ((ArrayList)localObject3).size() + ", thumb list " + this.tpG.size());
      localObject1 = this.tpE;
      if (localObject1 == null) {
        d.g.b.p.gkB();
      }
      if (((ArrayList)localObject1).size() != this.tpG.size()) {
        break label301;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = new bvy();
        Object localObject4;
        Object localObject5;
        if (this.tpH == 7)
        {
          localObject2 = this.tpE;
          if (localObject2 == null) {
            d.g.b.p.gkB();
          }
          localObject2 = ((Iterable)localObject2).iterator();
          i = j;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            if (i < 0) {
              j.gkd();
            }
            localObject3 = (String)localObject3;
            localObject4 = ((bvy)localObject1).mediaList;
            localObject5 = com.tencent.mm.plugin.finder.upload.i.sUG;
            localObject5 = this.tpG.get(i);
            d.g.b.p.g(localObject5, "thumbFileList[index]");
            ((LinkedList)localObject4).add(com.tencent.mm.plugin.finder.upload.i.gA((String)localObject3, (String)localObject5));
            i += 1;
          }
          i = 0;
          break;
          label301:
          i = 0;
          continue;
          label306:
          ae.i(TAG, "img list null");
          i = 0;
          continue;
        }
        localObject2 = this.tpE;
        if (localObject2 == null) {
          d.g.b.p.gkB();
        }
        localObject2 = ((Iterable)localObject2).iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          if (i < 0) {
            j.gkd();
          }
          localObject4 = (String)localObject3;
          localObject3 = ((bvy)localObject1).mediaList;
          localObject5 = com.tencent.mm.plugin.finder.upload.i.sUG;
          localObject5 = this.tpG.get(i);
          d.g.b.p.g(localObject5, "thumbFileList[index]");
          localObject4 = com.tencent.mm.plugin.finder.upload.i.gz((String)localObject4, (String)localObject5);
          localObject5 = new apo();
          Object localObject6 = this.tpF;
          if (localObject6 != null)
          {
            localObject6 = (Integer)j.F((List)localObject6, i);
            if (localObject6 != null)
            {
              j = ((Number)localObject6).intValue();
              ((apo)localObject5).GGG = j;
              ae.i(TAG, "codec_info hdimg_score:".concat(String.valueOf(j)));
            }
          }
          ((bvz)localObject4).codec_info = ((apo)localObject5);
          ((LinkedList)localObject3).add(localObject4);
          i += 1;
        }
        if (this.tpH == 7)
        {
          localObject1 = new h(true, 7, (bvy)localObject1);
          AppMethodBeat.o(206418);
          return localObject1;
        }
        localObject1 = new h(true, 2, (bvy)localObject1);
        AppMethodBeat.o(206418);
        return localObject1;
      }
    }
    localObject1 = new h(false, 0, null);
    AppMethodBeat.o(206418);
    return localObject1;
  }
  
  public final void refresh()
  {
    Object localObject2 = null;
    AppMethodBeat.i(168596);
    Object localObject3;
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
        localObject1 = ((bvy)localObject1).mediaList;
        d.g.b.p.g(localObject1, "refFeedContent!!.mediaList");
        localObject1 = (bvz)((LinkedList)localObject1).getFirst();
        localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
        localObject2 = com.tencent.mm.plugin.finder.utils.p.fT((int)((bvz)localObject1).width, (int)((bvz)localObject1).height);
        localObject3 = this.tpC;
        if (localObject3 == null) {
          d.g.b.p.gkB();
        }
        ((ImageView)localObject3).getLayoutParams().width = ((Bundle)localObject2).getInt("media_layout_width", (int)((bvz)localObject1).width);
        localObject3 = this.tpC;
        if (localObject3 == null) {
          d.g.b.p.gkB();
        }
        ((ImageView)localObject3).getLayoutParams().height = ((Bundle)localObject2).getInt("media_layout_height", (int)((bvz)localObject1).height);
        localObject3 = this.tpC;
        if (localObject3 == null) {
          d.g.b.p.gkB();
        }
        ((ImageView)localObject3).setScaleType(android.widget.ImageView.ScaleType.values()[localObject2.getInt("media_layout_sale_type", android.widget.ImageView.ScaleType.CENTER_CROP.ordinal())]);
        localObject2 = this.tpC;
        if (localObject2 == null) {
          d.g.b.p.gkB();
        }
        ((ImageView)localObject2).requestLayout();
        d.g.b.p.g(localObject1, "mediaObj");
        localObject1 = new g((bvz)localObject1, r.sJv);
        localObject2 = com.tencent.mm.plugin.finder.loader.i.srW;
        localObject2 = com.tencent.mm.plugin.finder.loader.i.cEn();
        localObject3 = this.tpC;
        if (localObject3 == null) {
          d.g.b.p.gkB();
        }
        com.tencent.mm.plugin.finder.loader.i locali = com.tencent.mm.plugin.finder.loader.i.srW;
        ((com.tencent.mm.loader.d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.i.a(i.a.srX));
        localObject1 = this.tpC;
        if (localObject1 == null) {
          d.g.b.p.gkB();
        }
        ((ImageView)localObject1).setVisibility(0);
        localObject1 = this.tpC;
        if (localObject1 == null) {
          d.g.b.p.gkB();
        }
        ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new b(this));
        AppMethodBeat.o(168596);
        return;
      }
    }
    Object localObject1 = this.dyY;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getStringArrayList(tpI);
      this.tpE = ((ArrayList)localObject1);
      localObject1 = this.dyY;
      if (localObject1 == null) {
        break label453;
      }
    }
    label453:
    for (localObject1 = ((Bundle)localObject1).getIntegerArrayList(tpJ);; localObject1 = null)
    {
      this.tpF = ((ArrayList)localObject1);
      localObject3 = this.dyY;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((Bundle)localObject3).getStringArrayList(tpK);
      }
      if (this.tpE != null)
      {
        localObject2 = this.tpE;
        if (localObject2 == null) {
          d.g.b.p.gkB();
        }
        if (((ArrayList)localObject2).size() > 0) {
          com.tencent.e.h.MqF.f((Runnable)new c(this, (ArrayList)localObject1), "Finder_Post_Create_Image_Thumb");
        }
      }
      AppMethodBeat.o(168596);
      return;
      localObject1 = null;
      break;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/widget/post/PostImageWidget$Companion;", "", "()V", "IMAGE_FILE_LIST", "", "getIMAGE_FILE_LIST", "()Ljava/lang/String;", "IMAGE_QUALITY_LIST", "getIMAGE_QUALITY_LIST", "IMAGE_THUMB_LIST", "getIMAGE_THUMB_LIST", "TAG", "getTAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168590);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      d.a(this.tpM);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168590);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(d paramd, ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(168593);
      Object localObject1 = d.b(this.tpM);
      if (localObject1 == null) {
        d.g.b.p.gkB();
      }
      Iterator localIterator = ((Iterable)localObject1).iterator();
      final int i = 0;
      while (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        int j = i + 1;
        if (i < 0) {
          j.gkd();
        }
        localObject1 = (String)localObject1;
        final boolean bool;
        if (i == 0)
        {
          bool = true;
          label79:
          if ((this.tpN == null) || (this.tpN.size() <= i) || (bu.isNullOrNil((String)this.tpN.get(i)))) {
            break label179;
          }
        }
        for (localObject1 = (String)this.tpN.get(i);; localObject1 = f.ajI((String)localObject1))
        {
          if (bu.isNullOrNil((String)localObject1)) {
            break label194;
          }
          Object localObject2 = com.tencent.mm.sdk.platformtools.h.decodeFile((String)localObject1);
          if (localObject2 == null) {
            break label194;
          }
          ar.f((Runnable)new a((Bitmap)localObject2, (String)localObject1, i, bool, (Bitmap)localObject2, this));
          i = j;
          break;
          bool = false;
          break label79;
          label179:
          localObject2 = f.sUp;
        }
        label194:
        i = j;
      }
      AppMethodBeat.o(168593);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$2$1$1$1", "com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$2$$special$$inlined$let$lambda$1"})
    static final class a
      implements Runnable
    {
      a(Bitmap paramBitmap1, String paramString, int paramInt, boolean paramBoolean, Bitmap paramBitmap2, d.c paramc) {}
      
      public final void run()
      {
        Object localObject4 = null;
        AppMethodBeat.i(168592);
        d.c(jdField_this.tpM).add(this.tpP);
        Object localObject1 = d.tpL;
        ae.i(d.access$getTAG$cp(), "add thumb file, index:" + i);
        Bundle localBundle;
        Object localObject2;
        LinearLayout localLinearLayout;
        label233:
        label244:
        Object localObject3;
        if (bool)
        {
          localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
          localBundle = com.tencent.mm.plugin.finder.utils.p.fT(this.tpR.getWidth(), this.tpR.getHeight());
          int i = localBundle.getInt("media_layout_width", this.tpR.getWidth());
          int j = localBundle.getInt("media_layout_height", this.tpR.getHeight());
          localObject1 = d.d(jdField_this.tpM);
          if (localObject1 == null) {
            d.g.b.p.gkB();
          }
          ((ImageView)localObject1).getLayoutParams().width = i;
          localObject1 = d.d(jdField_this.tpM);
          if (localObject1 == null) {
            d.g.b.p.gkB();
          }
          ((ImageView)localObject1).getLayoutParams().height = j;
          localObject1 = d.e(jdField_this.tpM);
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
          localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
          if ((((Number)com.tencent.mm.plugin.finder.storage.b.cKe().value()).intValue() != 2) || (this.tpR.getWidth() <= 0) || (this.tpR.getHeight() <= 0) || (this.tpR.getHeight() / this.tpR.getWidth() < 1.316667F)) {
            break label596;
          }
          if (localObject3 != null) {
            ((FrameLayout.LayoutParams)localObject3).topMargin = 0;
          }
          if (localObject2 != null)
          {
            localObject1 = ak.getContext();
            d.g.b.p.g(localObject1, "MMApplicationContext.getContext()");
            ((TextView)localObject2).setTextColor(((Context)localObject1).getResources().getColor(2131099828));
          }
          localObject1 = d.e(jdField_this.tpM);
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
          localObject1 = d.d(jdField_this.tpM);
          if (localObject1 == null) {
            d.g.b.p.gkB();
          }
          ((ImageView)localObject1).setScaleType(android.widget.ImageView.ScaleType.values()[localBundle.getInt("media_layout_sale_type", android.widget.ImageView.ScaleType.CENTER_CROP.ordinal())]);
          localObject1 = d.d(jdField_this.tpM);
          if (localObject1 == null) {
            d.g.b.p.gkB();
          }
          ((ImageView)localObject1).requestLayout();
          localObject1 = d.d(jdField_this.tpM);
          if (localObject1 == null) {
            d.g.b.p.gkB();
          }
          ((ImageView)localObject1).setImageBitmap(this.tpO);
          localObject1 = d.d(jdField_this.tpM);
          if (localObject1 == null) {
            d.g.b.p.gkB();
          }
          ((ImageView)localObject1).setVisibility(0);
          localObject1 = d.d(jdField_this.tpM);
          if (localObject1 == null) {
            d.g.b.p.gkB();
          }
          ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(168591);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$2$$special$$inlined$forEachIndexed$lambda$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              d.a(this.tpT.tpS.tpM);
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
            localObject1 = ak.getContext();
            d.g.b.p.g(localObject1, "MMApplicationContext.getContext()");
            ((TextView)localObject2).setTextColor(((Context)localObject1).getResources().getColor(2131100711));
          }
          if (localObject3 != null)
          {
            localObject2 = d.e(jdField_this.tpM);
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
          localObject1 = d.e(jdField_this.tpM);
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