package com.tencent.mm.plugin.finder.widget.post;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.upload.e;
import com.tencent.mm.protocal.protobuf.bmc;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/widget/post/PostImageWidget;", "Lcom/tencent/mm/plugin/finder/widget/post/BasePostMediaWidget;", "activity", "Landroid/content/Context;", "postType", "", "(Landroid/content/Context;I)V", "imgFileList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "multiImgIcon", "Landroid/widget/ImageView;", "reprintIv", "Landroid/view/View;", "rootView", "thumbFileList", "thumbIv", "checkData", "", "getUploadData", "Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "inflateView", "jumpToPreviewMediaUI", "", "onCreate", "onDestroy", "refresh", "Companion", "plugin-finder_release"})
public final class c
  extends a
{
  private static final String TAG = "Finder.PostImageWidget";
  private static final String rag = "image_file_list";
  private static final String rah = "image_thumb_list";
  public static final a rai;
  private View jGG;
  private ImageView raa;
  private ImageView rab;
  private View rac;
  private ArrayList<String> rad;
  private ArrayList<String> rae;
  private int raf;
  
  static
  {
    AppMethodBeat.i(168598);
    rai = new a((byte)0);
    rag = "image_file_list";
    rah = "image_thumb_list";
    TAG = "Finder.PostImageWidget";
    AppMethodBeat.o(168598);
  }
  
  private c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168597);
    this.raf = 2;
    this.rae = new ArrayList();
    AppMethodBeat.o(168597);
  }
  
  public final View ctv()
  {
    AppMethodBeat.i(168594);
    Object localObject = this.context;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(168594);
      throw ((Throwable)localObject);
    }
    this.jGG = ((Activity)localObject).getLayoutInflater().inflate(2131494084, null);
    localObject = this.jGG;
    if (localObject == null) {
      k.fvU();
    }
    this.raa = ((ImageView)((View)localObject).findViewById(2131305801));
    localObject = this.jGG;
    if (localObject == null) {
      k.fvU();
    }
    this.rab = ((ImageView)((View)localObject).findViewById(2131300941));
    localObject = this.jGG;
    if (localObject == null) {
      k.fvU();
    }
    localObject = ((View)localObject).findViewById(2131304092);
    k.g(localObject, "rootView!!.findViewById(R.id.reprint_iv)");
    this.rac = ((View)localObject);
    localObject = this.jGG;
    AppMethodBeat.o(168594);
    return localObject;
  }
  
  public final h fXI()
  {
    int k = 0;
    int j = 0;
    AppMethodBeat.i(200742);
    if ((this.qOO != null) && (this.qZS != null))
    {
      localObject1 = new h(true, 2, this.qZS);
      AppMethodBeat.o(200742);
      return localObject1;
    }
    Object localObject1 = (Collection)this.rad;
    int i;
    Object localObject2;
    Object localObject3;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
    {
      i = 1;
      if (i != 0) {
        break label320;
      }
      localObject1 = TAG;
      localObject2 = new StringBuilder("img list ");
      localObject3 = this.rad;
      if (localObject3 == null) {
        k.fvU();
      }
      ad.i((String)localObject1, ((ArrayList)localObject3).size() + ", thumb list " + this.rae.size());
      localObject1 = this.rad;
      if (localObject1 == null) {
        k.fvU();
      }
      if (((ArrayList)localObject1).size() != this.rae.size()) {
        break label315;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = new bmc();
        LinkedList localLinkedList;
        Object localObject4;
        if (this.raf == 7)
        {
          localObject2 = this.rad;
          if (localObject2 == null) {
            k.fvU();
          }
          localObject2 = ((Iterable)localObject2).iterator();
          i = j;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            if (i < 0) {
              j.fvx();
            }
            localObject3 = (String)localObject3;
            localLinkedList = ((bmc)localObject1).mediaList;
            localObject4 = com.tencent.mm.plugin.finder.upload.h.qRq;
            localObject4 = this.rae.get(i);
            k.g(localObject4, "thumbFileList[index]");
            localLinkedList.add(com.tencent.mm.plugin.finder.upload.h.fV((String)localObject3, (String)localObject4));
            i += 1;
          }
          i = 0;
          break;
          label315:
          i = 0;
          continue;
          label320:
          ad.i(TAG, "img list null");
          i = 0;
          continue;
        }
        localObject2 = this.rad;
        if (localObject2 == null) {
          k.fvU();
        }
        localObject2 = ((Iterable)localObject2).iterator();
        i = k;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          if (i < 0) {
            j.fvx();
          }
          localObject3 = (String)localObject3;
          localLinkedList = ((bmc)localObject1).mediaList;
          localObject4 = com.tencent.mm.plugin.finder.upload.h.qRq;
          localObject4 = this.rae.get(i);
          k.g(localObject4, "thumbFileList[index]");
          localLinkedList.add(com.tencent.mm.plugin.finder.upload.h.mR((String)localObject3, (String)localObject4));
          i += 1;
        }
        if (this.raf == 7)
        {
          localObject1 = new h(true, 7, (bmc)localObject1);
          AppMethodBeat.o(200742);
          return localObject1;
        }
        localObject1 = new h(true, 2, (bmc)localObject1);
        AppMethodBeat.o(200742);
        return localObject1;
      }
    }
    localObject1 = new h(false, 0, null);
    AppMethodBeat.o(200742);
    return localObject1;
  }
  
  public final void refresh()
  {
    Object localObject2 = null;
    AppMethodBeat.i(168596);
    Object localObject3;
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
        localObject1 = this.rab;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(0);
        }
        localObject1 = this.qZS;
        if (localObject1 == null) {
          k.fvU();
        }
        localObject1 = ((bmc)localObject1).mediaList;
        k.g(localObject1, "refFeedContent!!.mediaList");
        localObject1 = (bmd)((LinkedList)localObject1).getFirst();
        localObject2 = com.tencent.mm.plugin.finder.utils.i.qTa;
        localObject2 = com.tencent.mm.plugin.finder.utils.i.fB((int)((bmd)localObject1).width, (int)((bmd)localObject1).height);
        localObject3 = this.raa;
        if (localObject3 == null) {
          k.fvU();
        }
        ((ImageView)localObject3).getLayoutParams().width = ((Bundle)localObject2).getInt("media_layout_width", (int)((bmd)localObject1).width);
        localObject3 = this.raa;
        if (localObject3 == null) {
          k.fvU();
        }
        ((ImageView)localObject3).getLayoutParams().height = ((Bundle)localObject2).getInt("media_layout_height", (int)((bmd)localObject1).height);
        localObject3 = this.raa;
        if (localObject3 == null) {
          k.fvU();
        }
        ((ImageView)localObject3).setScaleType(android.widget.ImageView.ScaleType.values()[localObject2.getInt("media_layout_sale_type", android.widget.ImageView.ScaleType.CENTER_CROP.ordinal())]);
        localObject2 = this.raa;
        if (localObject2 == null) {
          k.fvU();
        }
        ((ImageView)localObject2).requestLayout();
        k.g(localObject1, "mediaObj");
        localObject1 = new com.tencent.mm.plugin.finder.loader.f((bmd)localObject1, com.tencent.mm.plugin.finder.storage.h.qJZ);
        localObject2 = com.tencent.mm.plugin.finder.loader.h.qCF;
        localObject2 = com.tencent.mm.plugin.finder.loader.h.cmU();
        localObject3 = this.raa;
        if (localObject3 == null) {
          k.fvU();
        }
        com.tencent.mm.plugin.finder.loader.h localh = com.tencent.mm.plugin.finder.loader.h.qCF;
        ((d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCG));
        localObject1 = this.raa;
        if (localObject1 == null) {
          k.fvU();
        }
        ((ImageView)localObject1).setVisibility(0);
        localObject1 = this.raa;
        if (localObject1 == null) {
          k.fvU();
        }
        ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new b(this));
        AppMethodBeat.o(168596);
        return;
      }
    }
    Object localObject1 = this.dow;
    if (localObject1 != null) {}
    for (localObject1 = ((Bundle)localObject1).getStringArrayList(rag);; localObject1 = null)
    {
      this.rad = ((ArrayList)localObject1);
      localObject3 = this.dow;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((Bundle)localObject3).getStringArrayList(rah);
      }
      if (this.rad != null)
      {
        localObject2 = this.rad;
        if (localObject2 == null) {
          k.fvU();
        }
        if (((ArrayList)localObject2).size() > 0)
        {
          localObject2 = this.rab;
          if (localObject2 != null) {
            ((ImageView)localObject2).setVisibility(0);
          }
          com.tencent.e.h.Iye.f((Runnable)new c(this, (ArrayList)localObject1), "Finder_Post_Create_Image_Thumb");
        }
      }
      AppMethodBeat.o(168596);
      return;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/widget/post/PostImageWidget$Companion;", "", "()V", "IMAGE_FILE_LIST", "", "getIMAGE_FILE_LIST", "()Ljava/lang/String;", "IMAGE_THUMB_LIST", "getIMAGE_THUMB_LIST", "TAG", "getTAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168590);
      c.a(this.raj);
      AppMethodBeat.o(168590);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc, ArrayList paramArrayList) {}
    
    public final void run()
    {
      AppMethodBeat.i(168593);
      Object localObject1 = c.b(this.raj);
      if (localObject1 == null) {
        k.fvU();
      }
      Iterator localIterator = ((Iterable)localObject1).iterator();
      final int i = 0;
      while (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        int j = i + 1;
        if (i < 0) {
          j.fvx();
        }
        localObject1 = (String)localObject1;
        final boolean bool;
        if (i == 0)
        {
          bool = true;
          label79:
          if ((this.rak == null) || (this.rak.size() <= i) || (bt.isNullOrNil((String)this.rak.get(i)))) {
            break label179;
          }
        }
        for (localObject1 = (String)this.rak.get(i);; localObject1 = e.aVF((String)localObject1))
        {
          if (bt.isNullOrNil((String)localObject1)) {
            break label194;
          }
          Object localObject2 = com.tencent.mm.sdk.platformtools.f.decodeFile((String)localObject1);
          if (localObject2 == null) {
            break label194;
          }
          aq.f((Runnable)new a((Bitmap)localObject2, (String)localObject1, i, bool, (Bitmap)localObject2, this));
          i = j;
          break;
          bool = false;
          break label79;
          label179:
          localObject2 = e.qQW;
        }
        label194:
        i = j;
      }
      AppMethodBeat.o(168593);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$2$1$1$1", "com/tencent/mm/plugin/finder/widget/post/PostImageWidget$refresh$2$$special$$inlined$let$lambda$1"})
    static final class a
      implements Runnable
    {
      a(Bitmap paramBitmap1, String paramString, int paramInt, boolean paramBoolean, Bitmap paramBitmap2, c.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(168592);
        c.c(jdField_this.raj).add(this.ram);
        Object localObject = c.rai;
        ad.i(c.access$getTAG$cp(), "add thumb file, index:" + i);
        if (bool)
        {
          localObject = com.tencent.mm.plugin.finder.utils.i.qTa;
          localObject = com.tencent.mm.plugin.finder.utils.i.fB(this.rao.getWidth(), this.rao.getHeight());
          ImageView localImageView = c.d(jdField_this.raj);
          if (localImageView == null) {
            k.fvU();
          }
          localImageView.getLayoutParams().width = ((Bundle)localObject).getInt("media_layout_width", this.rao.getWidth());
          localImageView = c.d(jdField_this.raj);
          if (localImageView == null) {
            k.fvU();
          }
          localImageView.getLayoutParams().height = ((Bundle)localObject).getInt("media_layout_height", this.rao.getHeight());
          localImageView = c.d(jdField_this.raj);
          if (localImageView == null) {
            k.fvU();
          }
          localImageView.setScaleType(android.widget.ImageView.ScaleType.values()[localObject.getInt("media_layout_sale_type", android.widget.ImageView.ScaleType.CENTER_CROP.ordinal())]);
          localObject = c.d(jdField_this.raj);
          if (localObject == null) {
            k.fvU();
          }
          ((ImageView)localObject).requestLayout();
          localObject = c.d(jdField_this.raj);
          if (localObject == null) {
            k.fvU();
          }
          ((ImageView)localObject).setImageBitmap(this.ral);
          localObject = c.d(jdField_this.raj);
          if (localObject == null) {
            k.fvU();
          }
          ((ImageView)localObject).setVisibility(0);
          localObject = c.d(jdField_this.raj);
          if (localObject == null) {
            k.fvU();
          }
          ((ImageView)localObject).setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(168591);
              c.a(this.raq.rap.raj);
              AppMethodBeat.o(168591);
            }
          });
        }
        AppMethodBeat.o(168592);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.c
 * JD-Core Version:    0.7.0.1
 */