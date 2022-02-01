package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.h.a;
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView;", "Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Adapter;", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "isDataChange", "", "isPrint", "itemViewWidth", "getItemViewWidth", "()I", "setItemViewWidth", "(I)V", "padding", "", "getPadding", "()F", "viewPool", "Ljava/util/HashMap;", "Ljava/util/LinkedList;", "Lkotlin/collections/HashMap;", "createView", "width", "height", "offsetX", "offsetY", "index", "notifyDataChange", "", "onLayout", "changed", "left", "top", "right", "bottom", "onViewRemoved", "child", "Landroid/view/View;", "print", "content", "", "setAdapter", "Adapter", "Companion", "Holder", "plugin-finder_release"})
public final class FinderFeedAlbumView
  extends RoundedCornerFrameLayout
{
  public static final b AXe;
  private final HashMap<Integer, LinkedList<c>> AWZ;
  private a<? extends c> AXa;
  private boolean AXb;
  private int AXc;
  private final boolean AXd;
  private final float dhX;
  
  static
  {
    AppMethodBeat.i(291375);
    AXe = new b((byte)0);
    AppMethodBeat.o(291375);
  }
  
  public FinderFeedAlbumView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(291373);
    this.AWZ = new HashMap();
    this.AXc = -1;
    paramContext = getContext();
    p.j(paramContext, "context");
    this.dhX = (paramContext.getResources().getDimension(b.d.Edge_0_5_A) / 2.0F);
    AppMethodBeat.o(291373);
  }
  
  public FinderFeedAlbumView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(291374);
    this.AWZ = new HashMap();
    this.AXc = -1;
    paramContext = getContext();
    p.j(paramContext, "context");
    this.dhX = (paramContext.getResources().getDimension(b.d.Edge_0_5_A) / 2.0F);
    AppMethodBeat.o(291374);
  }
  
  private final void aex(String paramString)
  {
    AppMethodBeat.i(291372);
    if (this.AXd) {
      Log.i("Finder.FinderFeedAlbumView", paramString);
    }
    AppMethodBeat.o(291372);
  }
  
  private final c l(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(291370);
    a locala = this.AXa;
    if (locala == null) {
      p.iCn();
    }
    int i = locala.RC(paramInt5);
    Object localObject = (LinkedList)this.AWZ.get(Integer.valueOf(i));
    if (localObject != null)
    {
      localObject = (c)((LinkedList)localObject).poll();
      if (localObject != null) {}
    }
    else
    {
      localObject = LayoutInflater.from(getContext());
      p.j(localObject, "LayoutInflater.from(this.context)");
      localObject = locala.a((LayoutInflater)localObject, (FrameLayout)this, paramInt5);
    }
    for (;;)
    {
      ((c)localObject).amk.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(paramInt1, paramInt2));
      ((c)localObject).amk.setTag(b.f.finder_album_item_id, localObject);
      ((c)localObject).amk.setTag(b.f.finder_album_item_type, Integer.valueOf(i));
      ((c)localObject).amk.setTranslationX(paramInt3);
      ((c)localObject).amk.setTranslationY(paramInt4);
      aex("[createView] width=" + paramInt1 + " height=" + paramInt2 + " offsetX=" + paramInt3 + " offsetY=" + paramInt4 + " index=" + paramInt5);
      AppMethodBeat.o(291370);
      return localObject;
    }
  }
  
  public final void cBf()
  {
    AppMethodBeat.i(291368);
    this.AXb = true;
    aex("[notifyDataChange] isInLayout=" + isInLayout());
    post((Runnable)new d(this));
    AppMethodBeat.o(291368);
  }
  
  public final int getItemViewWidth()
  {
    return this.AXc;
  }
  
  public final float getPadding()
  {
    return this.dhX;
  }
  
  public final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(291369);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
    paramInt3 = paramInt3 - paramInt1 - getPaddingStart() - getPaddingEnd();
    Object localObject1 = this.AXa;
    if (localObject1 != null) {}
    for (paramInt1 = ((a)localObject1).getSize();; paramInt1 = 0)
    {
      paramInt4 = i.ow(4, paramInt1);
      if (paramInt4 > 0) {
        break;
      }
      AppMethodBeat.o(291369);
      return;
    }
    aex("[onLayout] changed=" + paramBoolean + " isDataChange=" + this.AXb + " width=" + paramInt3 + " height=" + paramInt2 + " size=" + paramInt4);
    if ((paramBoolean) || (this.AXb))
    {
      removeAllViews();
      float f1 = paramInt2 / 3.0F;
      float f2 = paramInt3 / 3.0F;
      paramInt1 = 0;
      if (paramInt1 < paramInt4)
      {
        switch (paramInt1)
        {
        default: 
          localObject1 = l(a.dm(f2), a.dm(1.5F * f1), a.dm(2.0F * f2 + this.dhX), a.dm(1.5F * f1 + this.dhX), paramInt1);
        }
        for (;;)
        {
          Object localObject2 = ((c)localObject1).amk;
          addViewInLayout((View)localObject2, paramInt1, ((View)localObject2).getLayoutParams());
          localObject2 = this.AXa;
          if (localObject2 != null) {
            ((a)localObject2).a(((c)localObject1).amk, paramInt1, (c)localObject1);
          }
          paramInt1 += 1;
          break;
          localObject1 = l(a.dm(2.0F * f2), a.dm(2.0F * f1), 0, 0, paramInt1);
          continue;
          localObject1 = l(a.dm(f2), a.dm(1.5F * f1), a.dm(2.0F * f2 + this.dhX), 0, paramInt1);
          continue;
          localObject1 = l(a.dm(2.0F * f2), a.dm(f1), 0, a.dm(2.0F * f1 + this.dhX), paramInt1);
        }
      }
      this.AXb = false;
    }
    AppMethodBeat.o(291369);
  }
  
  public final void onViewRemoved(View paramView)
  {
    Object localObject3 = null;
    AppMethodBeat.i(291371);
    super.onViewRemoved(paramView);
    Object localObject1;
    if (paramView != null)
    {
      localObject1 = paramView.getTag(b.f.finder_album_item_id);
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof c)) {
        localObject2 = null;
      }
      localObject1 = (c)localObject2;
      if (paramView == null) {
        break label156;
      }
      paramView = paramView.getTag(b.f.finder_album_item_type);
      label57:
      if ((paramView instanceof Integer)) {
        break label207;
      }
      paramView = localObject3;
    }
    label156:
    label166:
    label200:
    label207:
    for (;;)
    {
      paramView = (Integer)paramView;
      int i;
      if (paramView != null)
      {
        i = paramView.intValue();
        label81:
        if (localObject1 == null) {
          break label200;
        }
        if (((Map)this.AWZ).containsKey(Integer.valueOf(i))) {
          break label166;
        }
        paramView = new LinkedList();
        ((Map)this.AWZ).put(Integer.valueOf(i), paramView);
      }
      for (;;)
      {
        if (!paramView.contains(localObject1)) {
          paramView.add(localObject1);
        }
        AppMethodBeat.o(291371);
        return;
        localObject1 = null;
        break;
        paramView = null;
        break label57;
        i = 0;
        break label81;
        paramView = this.AWZ.get(Integer.valueOf(i));
        if (paramView == null) {
          p.iCn();
        }
        p.j(paramView, "viewPool[type]!!");
        paramView = (LinkedList)paramView;
      }
      AppMethodBeat.o(291371);
      return;
    }
  }
  
  public final void setAdapter(a<? extends c> parama)
  {
    AppMethodBeat.i(291367);
    p.k(parama, "adapter");
    this.AXa = parama;
    cBf();
    AppMethodBeat.o(291367);
  }
  
  public final void setItemViewWidth(int paramInt)
  {
    this.AXc = paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Adapter;", "V", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "", "()V", "getItemType", "", "position", "getSize", "onBindView", "", "itemView", "Landroid/view/View;", "holder", "onCreateView", "layoutInflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/widget/FrameLayout;", "(Landroid/view/LayoutInflater;Landroid/widget/FrameLayout;I)Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "plugin-finder_release"})
  public static abstract class a<V extends FinderFeedAlbumView.c>
  {
    public abstract int RC(int paramInt);
    
    public abstract V a(LayoutInflater paramLayoutInflater, FrameLayout paramFrameLayout, int paramInt);
    
    public abstract void a(View paramView, int paramInt, FinderFeedAlbumView.c paramc);
    
    public abstract int getSize();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Companion;", "", "()V", "ITEM_COUNT", "", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "getItemView", "()Landroid/view/View;", "plugin-finder_release"})
  public static abstract class c
  {
    final View amk;
    
    public c(View paramView)
    {
      this.amk = paramView;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(FinderFeedAlbumView paramFinderFeedAlbumView) {}
    
    public final void run()
    {
      AppMethodBeat.i(291616);
      this.AXf.requestLayout();
      AppMethodBeat.o(291616);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFeedAlbumView
 * JD-Core Version:    0.7.0.1
 */