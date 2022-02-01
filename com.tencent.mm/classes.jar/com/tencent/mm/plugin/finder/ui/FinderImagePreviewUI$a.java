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
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$FinderPreviewImageAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/finder/ui/FinderImagePreviewUI;)V", "images", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "isLocal", "", "getCount", "", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "view", "viewGroup", "Landroid/view/ViewGroup;", "setImages", "", "files", "setIsLocal", "plugin-finder_release"})
public final class FinderImagePreviewUI$a
  extends BaseAdapter
{
  boolean fEF;
  private ArrayList<String> images;
  
  public FinderImagePreviewUI$a()
  {
    AppMethodBeat.i(167298);
    this.images = new ArrayList();
    AppMethodBeat.o(167298);
  }
  
  private String getItem(int paramInt)
  {
    AppMethodBeat.i(167294);
    String str = (String)this.images.get(paramInt);
    AppMethodBeat.o(167294);
    return str;
  }
  
  public final void aq(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(167297);
    p.k(paramArrayList, "files");
    this.images.addAll((Collection)paramArrayList);
    AppMethodBeat.o(167297);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(167293);
    int i = this.images.size();
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
    p.k(paramViewGroup, "viewGroup");
    if (paramView == null)
    {
      paramView = (View)new MultiTouchImageView((Context)this.Aru, 0, 0, (byte)0);
      ((MultiTouchImageView)paramView).setLayoutParams((ViewGroup.LayoutParams)new Gallery.LayoutParams(-1, -1));
    }
    for (;;)
    {
      if (this.fEF)
      {
        paramViewGroup = com.tencent.mm.loader.e.kMy;
        paramViewGroup = com.tencent.mm.loader.e.aRs();
        String str = getItem(paramInt);
        if (str == null) {
          p.iCn();
        }
        paramViewGroup = paramViewGroup.Oq(str);
        paramViewGroup.kMC = ((com.tencent.mm.loader.f.e)a.Arv);
        paramViewGroup.c((ImageView)paramView);
        AppMethodBeat.o(167296);
        return paramView;
      }
      if (!FinderImagePreviewUI.a(this.Aru)) {
        paramViewGroup = com.tencent.mm.plugin.finder.loader.t.ztT;
      }
      for (paramViewGroup = com.tencent.mm.plugin.finder.loader.t.dJe().bQ(new com.tencent.mm.plugin.finder.loader.x(Util.nullAsNil(getItem(paramInt)), u.Aly));; paramViewGroup = com.tencent.mm.plugin.finder.loader.t.dJk().bQ(new com.tencent.mm.plugin.finder.loader.e(Util.nullAsNil(getItem(paramInt)), u.AlO)))
      {
        ((com.tencent.mm.loader.a.a)paramViewGroup).a((ImageView)paramView, (m)b.Ary);
        break;
        paramViewGroup = com.tencent.mm.plugin.finder.loader.t.ztT;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "", "kotlin.jvm.PlatformType", "imageView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class a<T, R>
    implements com.tencent.mm.loader.f.e<String, Bitmap>
  {
    public static final a Arv;
    
    static
    {
      AppMethodBeat.i(167289);
      Arv = new a();
      AppMethodBeat.o(167289);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$FinderPreviewImageAdapter$getView$1$1$1"})
    static final class a
      implements Runnable
    {
      a(g paramg, Bitmap paramBitmap) {}
      
      public final void run()
      {
        AppMethodBeat.i(167287);
        Object localObject = this.Arw;
        p.j(localObject, "imageView");
        localObject = ((g)localObject).getView();
        if (localObject != null)
        {
          if (localObject == null)
          {
            localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
            AppMethodBeat.o(167287);
            throw ((Throwable)localObject);
          }
          ((MultiTouchImageView)localObject).di(this.Arx.getWidth(), this.Arx.getHeight());
          ((MultiTouchImageView)localObject).hJx();
          AppMethodBeat.o(167287);
          return;
        }
        AppMethodBeat.o(167287);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "imageView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "invoke"})
  static final class b
    extends q
    implements m<g<?>, Bitmap, kotlin.x>
  {
    public static final b Ary;
    
    static
    {
      AppMethodBeat.i(167292);
      Ary = new b();
      AppMethodBeat.o(167292);
    }
    
    b()
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/ui/FinderImagePreviewUI$FinderPreviewImageAdapter$getView$2$1$1"})
    static final class a
      implements Runnable
    {
      a(g paramg, Bitmap paramBitmap) {}
      
      public final void run()
      {
        AppMethodBeat.i(167290);
        Object localObject = this.Arw.getView();
        if (localObject != null)
        {
          if (localObject == null)
          {
            localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.base.MultiTouchImageView");
            AppMethodBeat.o(167290);
            throw ((Throwable)localObject);
          }
          ((MultiTouchImageView)localObject).di(this.Arx.getWidth(), this.Arx.getHeight());
          ((MultiTouchImageView)localObject).hJx();
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