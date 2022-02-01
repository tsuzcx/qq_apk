package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.a;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.e;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.plugin.finder.loader.j;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MultiTouchImageView;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$FinderPreviewImageAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/ui/FinderImagePreviewUI;)V", "images", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "isLocal", "", "getCount", "", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "view", "viewGroup", "Landroid/view/ViewGroup;", "setImages", "", "files", "setIsLocal", "plugin-finder_release"})
public final class FinderImagePreviewUI$a
  extends BaseAdapter
{
  boolean dtp;
  private ArrayList<String> qMA;
  
  public FinderImagePreviewUI$a()
  {
    AppMethodBeat.i(167298);
    this.qMA = new ArrayList();
    AppMethodBeat.o(167298);
  }
  
  private String getItem(int paramInt)
  {
    AppMethodBeat.i(167294);
    String str = (String)this.qMA.get(paramInt);
    AppMethodBeat.o(167294);
    return str;
  }
  
  public final void P(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(167297);
    d.g.b.k.h(paramArrayList, "files");
    this.qMA.addAll((Collection)paramArrayList);
    AppMethodBeat.o(167297);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(167293);
    int i = this.qMA.size();
    AppMethodBeat.o(167293);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(167296);
    d.g.b.k.h(paramViewGroup, "viewGroup");
    if (paramView == null)
    {
      paramView = (View)new MultiTouchImageView((Context)this.qMB, 0, 0, (byte)0);
      ((MultiTouchImageView)paramView).setLayoutParams((ViewGroup.LayoutParams)new Gallery.LayoutParams(-1, -1));
    }
    for (;;)
    {
      if (this.dtp)
      {
        paramViewGroup = e.ghT;
        paramViewGroup = e.agS();
        String str = getItem(paramInt);
        if (str == null) {
          d.g.b.k.fvU();
        }
        paramViewGroup = paramViewGroup.rd(str);
        paramViewGroup.ghX = ((com.tencent.mm.loader.f.d)a.qMC);
        paramViewGroup.c((ImageView)paramView);
      }
      for (;;)
      {
        AppMethodBeat.o(167296);
        return paramView;
        paramViewGroup = com.tencent.mm.plugin.finder.loader.h.qCF;
        paramViewGroup = com.tencent.mm.plugin.finder.loader.h.cmU().bI(new com.tencent.mm.plugin.finder.loader.k(bt.nullAsNil(getItem(paramInt)), com.tencent.mm.plugin.finder.storage.h.qJY));
        paramViewGroup.ghX = ((com.tencent.mm.loader.f.d)b.qMF);
        paramViewGroup.c((ImageView)paramView);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "", "kotlin.jvm.PlatformType", "imageView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class a<T, R>
    implements com.tencent.mm.loader.f.d<String, Bitmap>
  {
    public static final a qMC;
    
    static
    {
      AppMethodBeat.i(167289);
      qMC = new a();
      AppMethodBeat.o(167289);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$FinderPreviewImageAdapter$getView$1$1$1"})
    static final class a
      implements Runnable
    {
      a(g paramg, Bitmap paramBitmap) {}
      
      public final void run()
      {
        AppMethodBeat.i(167287);
        Object localObject = this.qMD;
        d.g.b.k.g(localObject, "imageView");
        localObject = ((g)localObject).getView();
        if (localObject != null)
        {
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
            AppMethodBeat.o(167287);
            throw ((Throwable)localObject);
          }
          ((MultiTouchImageView)localObject).cH(this.qME.getWidth(), this.qME.getHeight());
          ((MultiTouchImageView)localObject).eSz();
          AppMethodBeat.o(167287);
          return;
        }
        AppMethodBeat.o(167287);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "imageView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class b<T, R>
    implements com.tencent.mm.loader.f.d<j, Bitmap>
  {
    public static final b qMF;
    
    static
    {
      AppMethodBeat.i(167292);
      qMF = new b();
      AppMethodBeat.o(167292);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$FinderPreviewImageAdapter$getView$2$1$1"})
    static final class a
      implements Runnable
    {
      a(g paramg, Bitmap paramBitmap) {}
      
      public final void run()
      {
        AppMethodBeat.i(167290);
        Object localObject = this.qMD;
        d.g.b.k.g(localObject, "imageView");
        localObject = ((g)localObject).getView();
        if (localObject != null)
        {
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
            AppMethodBeat.o(167290);
            throw ((Throwable)localObject);
          }
          ((MultiTouchImageView)localObject).cH(this.qME.getWidth(), this.qME.getHeight());
          ((MultiTouchImageView)localObject).eSz();
          AppMethodBeat.o(167290);
          return;
        }
        AppMethodBeat.o(167290);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderImagePreviewUI.a
 * JD-Core Version:    0.7.0.1
 */