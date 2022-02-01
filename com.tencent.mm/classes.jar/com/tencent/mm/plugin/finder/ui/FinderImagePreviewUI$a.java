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
import com.tencent.mm.loader.a.a.a;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.e;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.MultiTouchImageView;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$FinderPreviewImageAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/ui/FinderImagePreviewUI;)V", "images", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "isLocal", "", "getCount", "", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "view", "viewGroup", "Landroid/view/ViewGroup;", "setImages", "", "files", "setIsLocal", "plugin-finder_release"})
public final class FinderImagePreviewUI$a
  extends BaseAdapter
{
  boolean dqZ;
  private ArrayList<String> rHT;
  
  public FinderImagePreviewUI$a()
  {
    AppMethodBeat.i(167298);
    this.rHT = new ArrayList();
    AppMethodBeat.o(167298);
  }
  
  private String getItem(int paramInt)
  {
    AppMethodBeat.i(167294);
    String str = (String)this.rHT.get(paramInt);
    AppMethodBeat.o(167294);
    return str;
  }
  
  public final void Z(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(167297);
    d.g.b.k.h(paramArrayList, "files");
    this.rHT.addAll((Collection)paramArrayList);
    AppMethodBeat.o(167297);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(167293);
    int i = this.rHT.size();
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
      paramView = (View)new MultiTouchImageView((Context)this.rHU, 0, 0, (byte)0);
      ((MultiTouchImageView)paramView).setLayoutParams((ViewGroup.LayoutParams)new Gallery.LayoutParams(-1, -1));
    }
    for (;;)
    {
      Object localObject;
      if (this.dqZ)
      {
        paramViewGroup = e.gIC;
        paramViewGroup = e.anT();
        localObject = getItem(paramInt);
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        paramViewGroup = paramViewGroup.vf((String)localObject);
        paramViewGroup.gIG = ((com.tencent.mm.loader.f.d)a.rHV);
        paramViewGroup.c((ImageView)paramView);
        AppMethodBeat.o(167296);
        return paramView;
      }
      if (!FinderImagePreviewUI.a(this.rHU)) {
        paramViewGroup = h.rtK;
      }
      for (paramViewGroup = h.cwn().bG(new com.tencent.mm.plugin.finder.loader.k(bs.nullAsNil(getItem(paramInt)), com.tencent.mm.plugin.finder.storage.m.rDQ));; paramViewGroup = h.cwq().bG(new com.tencent.mm.plugin.finder.loader.a(bs.nullAsNil(getItem(paramInt)))))
      {
        paramViewGroup = (com.tencent.mm.loader.a.a)paramViewGroup;
        localObject = (ImageView)paramView;
        d.g.a.m localm = (d.g.a.m)b.rHY;
        d.g.b.k.h(localObject, "imageView");
        if (paramViewGroup.gJa == null) {
          paramViewGroup.gJa = ((com.tencent.mm.loader.e.b.d)new a.a(localm, (ImageView)localObject, new g(localObject)));
        }
        paramViewGroup.tX();
        break;
        paramViewGroup = h.rtK;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "", "kotlin.jvm.PlatformType", "imageView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class a<T, R>
    implements com.tencent.mm.loader.f.d<String, Bitmap>
  {
    public static final a rHV;
    
    static
    {
      AppMethodBeat.i(167289);
      rHV = new a();
      AppMethodBeat.o(167289);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$FinderPreviewImageAdapter$getView$1$1$1"})
    static final class a
      implements Runnable
    {
      a(g paramg, Bitmap paramBitmap) {}
      
      public final void run()
      {
        AppMethodBeat.i(167287);
        Object localObject = this.rHW;
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
          ((MultiTouchImageView)localObject).cF(this.rHX.getWidth(), this.rHX.getHeight());
          ((MultiTouchImageView)localObject).fij();
          AppMethodBeat.o(167287);
          return;
        }
        AppMethodBeat.o(167287);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "imageView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.m<g<?>, Bitmap, y>
  {
    public static final b rHY;
    
    static
    {
      AppMethodBeat.i(167292);
      rHY = new b();
      AppMethodBeat.o(167292);
    }
    
    b()
    {
      super();
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$FinderPreviewImageAdapter$getView$2$1$1"})
    static final class a
      implements Runnable
    {
      a(g paramg, Bitmap paramBitmap) {}
      
      public final void run()
      {
        AppMethodBeat.i(167290);
        Object localObject = this.rHW.getView();
        if (localObject != null)
        {
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
            AppMethodBeat.o(167290);
            throw ((Throwable)localObject);
          }
          ((MultiTouchImageView)localObject).cF(this.rHX.getWidth(), this.rHX.getHeight());
          ((MultiTouchImageView)localObject).fij();
          AppMethodBeat.o(167290);
          return;
        }
        AppMethodBeat.o(167290);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderImagePreviewUI.a
 * JD-Core Version:    0.7.0.1
 */