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
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MultiTouchImageView;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$FinderPreviewImageAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/ui/FinderImagePreviewUI;)V", "images", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "isLocal", "", "getCount", "", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "view", "viewGroup", "Landroid/view/ViewGroup;", "setImages", "", "files", "setIsLocal", "plugin-finder_release"})
public final class FinderImagePreviewUI$a
  extends BaseAdapter
{
  boolean dDV;
  private ArrayList<String> sNQ;
  
  public FinderImagePreviewUI$a()
  {
    AppMethodBeat.i(167298);
    this.sNQ = new ArrayList();
    AppMethodBeat.o(167298);
  }
  
  private String getItem(int paramInt)
  {
    AppMethodBeat.i(167294);
    String str = (String)this.sNQ.get(paramInt);
    AppMethodBeat.o(167294);
    return str;
  }
  
  public final void X(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(167297);
    p.h(paramArrayList, "files");
    this.sNQ.addAll((Collection)paramArrayList);
    AppMethodBeat.o(167297);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(167293);
    int i = this.sNQ.size();
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
    p.h(paramViewGroup, "viewGroup");
    if (paramView == null)
    {
      paramView = (View)new MultiTouchImageView((Context)this.sNR, 0, 0, (byte)0);
      ((MultiTouchImageView)paramView).setLayoutParams((ViewGroup.LayoutParams)new Gallery.LayoutParams(-1, -1));
    }
    for (;;)
    {
      Object localObject;
      if (this.dDV)
      {
        paramViewGroup = com.tencent.mm.loader.e.hfa;
        paramViewGroup = com.tencent.mm.loader.e.aqU();
        localObject = getItem(paramInt);
        if (localObject == null) {
          p.gkB();
        }
        paramViewGroup = paramViewGroup.yG((String)localObject);
        paramViewGroup.hfe = ((com.tencent.mm.loader.f.e)a.sNS);
        paramViewGroup.c((ImageView)paramView);
        AppMethodBeat.o(167296);
        return paramView;
      }
      if (!FinderImagePreviewUI.a(this.sNR)) {
        paramViewGroup = i.srW;
      }
      for (paramViewGroup = i.cEn().bI(new com.tencent.mm.plugin.finder.loader.l(bu.nullAsNil(getItem(paramInt)), r.sJu));; paramViewGroup = i.cEr().bI(new com.tencent.mm.plugin.finder.loader.a(bu.nullAsNil(getItem(paramInt)))))
      {
        paramViewGroup = (com.tencent.mm.loader.a.a)paramViewGroup;
        localObject = (ImageView)paramView;
        m localm = (m)b.sNV;
        p.h(localObject, "imageView");
        if (paramViewGroup.hfz == null) {
          paramViewGroup.hfz = ((com.tencent.mm.loader.e.b.d)new a.a(localm, (ImageView)localObject, new g(localObject)));
        }
        paramViewGroup.vw();
        break;
        paramViewGroup = i.srW;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "", "kotlin.jvm.PlatformType", "imageView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class a<T, R>
    implements com.tencent.mm.loader.f.e<String, Bitmap>
  {
    public static final a sNS;
    
    static
    {
      AppMethodBeat.i(167289);
      sNS = new a();
      AppMethodBeat.o(167289);
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$FinderPreviewImageAdapter$getView$1$1$1"})
    static final class a
      implements Runnable
    {
      a(g paramg, Bitmap paramBitmap) {}
      
      public final void run()
      {
        AppMethodBeat.i(167287);
        Object localObject = this.sNT;
        p.g(localObject, "imageView");
        localObject = ((g)localObject).getView();
        if (localObject != null)
        {
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
            AppMethodBeat.o(167287);
            throw ((Throwable)localObject);
          }
          ((MultiTouchImageView)localObject).cH(this.sNU.getWidth(), this.sNU.getHeight());
          ((MultiTouchImageView)localObject).fCA();
          AppMethodBeat.o(167287);
          return;
        }
        AppMethodBeat.o(167287);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "imageView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "invoke"})
  static final class b
    extends q
    implements m<g<?>, Bitmap, z>
  {
    public static final b sNV;
    
    static
    {
      AppMethodBeat.i(167292);
      sNV = new b();
      AppMethodBeat.o(167292);
    }
    
    b()
    {
      super();
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$FinderPreviewImageAdapter$getView$2$1$1"})
    static final class a
      implements Runnable
    {
      a(g paramg, Bitmap paramBitmap) {}
      
      public final void run()
      {
        AppMethodBeat.i(167290);
        Object localObject = this.sNT.getView();
        if (localObject != null)
        {
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
            AppMethodBeat.o(167290);
            throw ((Throwable)localObject);
          }
          ((MultiTouchImageView)localObject).cH(this.sNU.getWidth(), this.sNU.getHeight());
          ((MultiTouchImageView)localObject).fCA();
          AppMethodBeat.o(167290);
          return;
        }
        AppMethodBeat.o(167290);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderImagePreviewUI.a
 * JD-Core Version:    0.7.0.1
 */