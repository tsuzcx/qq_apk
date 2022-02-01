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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.h.a;
import kotlin.k.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView;", "Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Adapter;", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "isDataChange", "", "isPrint", "itemViewWidth", "getItemViewWidth", "()I", "setItemViewWidth", "(I)V", "padding", "", "getPadding", "()F", "viewPool", "Ljava/util/HashMap;", "Ljava/util/LinkedList;", "Lkotlin/collections/HashMap;", "createView", "width", "height", "offsetX", "offsetY", "index", "notifyDataChange", "", "onLayout", "changed", "left", "top", "right", "bottom", "onViewRemoved", "child", "Landroid/view/View;", "print", "content", "", "setAdapter", "Adapter", "Companion", "Holder", "plugin-finder_release"})
public final class FinderFeedAlbumView
  extends RoundedCornerFrameLayout
{
  public static final b wmc;
  private final float ddU;
  private final HashMap<Integer, LinkedList<c>> wlX;
  private a<? extends c> wlY;
  private boolean wlZ;
  private int wma;
  private final boolean wmb;
  
  static
  {
    AppMethodBeat.i(254792);
    wmc = new b((byte)0);
    AppMethodBeat.o(254792);
  }
  
  public FinderFeedAlbumView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254790);
    this.wlX = new HashMap();
    this.wma = -1;
    paramContext = getContext();
    p.g(paramContext, "context");
    this.ddU = (paramContext.getResources().getDimension(2131165277) / 2.0F);
    AppMethodBeat.o(254790);
  }
  
  public FinderFeedAlbumView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(254791);
    this.wlX = new HashMap();
    this.wma = -1;
    paramContext = getContext();
    p.g(paramContext, "context");
    this.ddU = (paramContext.getResources().getDimension(2131165277) / 2.0F);
    AppMethodBeat.o(254791);
  }
  
  private final c j(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(254787);
    a locala = this.wlY;
    if (locala == null) {
      p.hyc();
    }
    int i = locala.Mm(paramInt5);
    Object localObject = (LinkedList)this.wlX.get(Integer.valueOf(i));
    if (localObject != null)
    {
      localObject = (c)((LinkedList)localObject).poll();
      if (localObject != null) {}
    }
    else
    {
      localObject = LayoutInflater.from(getContext());
      p.g(localObject, "LayoutInflater.from(this.context)");
      localObject = locala.a((LayoutInflater)localObject, (FrameLayout)this, paramInt5);
    }
    for (;;)
    {
      ((c)localObject).aus.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(paramInt1, paramInt2));
      ((c)localObject).aus.setTag(2131300769, localObject);
      ((c)localObject).aus.setTag(2131300770, Integer.valueOf(i));
      ((c)localObject).aus.setTranslationX(paramInt3);
      ((c)localObject).aus.setTranslationY(paramInt4);
      print("[createView] width=" + paramInt1 + " height=" + paramInt2 + " offsetX=" + paramInt3 + " offsetY=" + paramInt4 + " index=" + paramInt5);
      AppMethodBeat.o(254787);
      return localObject;
    }
  }
  
  private final void print(String paramString)
  {
    AppMethodBeat.i(254789);
    if (this.wmb) {
      Log.i("Finder.FinderFeedAlbumView", paramString);
    }
    AppMethodBeat.o(254789);
  }
  
  public final void dGH()
  {
    AppMethodBeat.i(254785);
    this.wlZ = true;
    print("[notifyDataChange] isInLayout=" + isInLayout());
    post((Runnable)new d(this));
    AppMethodBeat.o(254785);
  }
  
  public final int getItemViewWidth()
  {
    return this.wma;
  }
  
  public final float getPadding()
  {
    return this.ddU;
  }
  
  public final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(254786);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
    paramInt3 = paramInt3 - paramInt1 - getPaddingStart() - getPaddingEnd();
    Object localObject1 = this.wlY;
    if (localObject1 != null) {}
    for (paramInt1 = ((a)localObject1).getSize();; paramInt1 = 0)
    {
      paramInt4 = j.na(4, paramInt1);
      if (paramInt4 > 0) {
        break;
      }
      AppMethodBeat.o(254786);
      return;
    }
    print("[onLayout] changed=" + paramBoolean + " isDataChange=" + this.wlZ + " width=" + paramInt3 + " height=" + paramInt2 + " size=" + paramInt4);
    if ((paramBoolean) || (this.wlZ))
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
          localObject1 = j(a.cR(f2), a.cR(1.5F * f1), a.cR(2.0F * f2 + this.ddU), a.cR(1.5F * f1 + this.ddU), paramInt1);
        }
        for (;;)
        {
          Object localObject2 = ((c)localObject1).aus;
          addViewInLayout((View)localObject2, paramInt1, ((View)localObject2).getLayoutParams());
          localObject2 = this.wlY;
          if (localObject2 != null) {
            ((a)localObject2).a(((c)localObject1).aus, paramInt1, (c)localObject1);
          }
          paramInt1 += 1;
          break;
          localObject1 = j(a.cR(2.0F * f2), a.cR(2.0F * f1), 0, 0, paramInt1);
          continue;
          localObject1 = j(a.cR(f2), a.cR(1.5F * f1), a.cR(2.0F * f2 + this.ddU), 0, paramInt1);
          continue;
          localObject1 = j(a.cR(2.0F * f2), a.cR(f1), 0, a.cR(2.0F * f1 + this.ddU), paramInt1);
        }
      }
      this.wlZ = false;
    }
    AppMethodBeat.o(254786);
  }
  
  public final void onViewRemoved(View paramView)
  {
    Object localObject3 = null;
    AppMethodBeat.i(254788);
    super.onViewRemoved(paramView);
    Object localObject1;
    if (paramView != null)
    {
      localObject1 = paramView.getTag(2131300769);
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof c)) {
        localObject2 = null;
      }
      localObject1 = (c)localObject2;
      if (paramView == null) {
        break label154;
      }
      paramView = paramView.getTag(2131300770);
      label55:
      if ((paramView instanceof Integer)) {
        break label205;
      }
      paramView = localObject3;
    }
    label154:
    label164:
    label198:
    label205:
    for (;;)
    {
      paramView = (Integer)paramView;
      int i;
      if (paramView != null)
      {
        i = paramView.intValue();
        label79:
        if (localObject1 == null) {
          break label198;
        }
        if (((Map)this.wlX).containsKey(Integer.valueOf(i))) {
          break label164;
        }
        paramView = new LinkedList();
        ((Map)this.wlX).put(Integer.valueOf(i), paramView);
      }
      for (;;)
      {
        if (!paramView.contains(localObject1)) {
          paramView.add(localObject1);
        }
        AppMethodBeat.o(254788);
        return;
        localObject1 = null;
        break;
        paramView = null;
        break label55;
        i = 0;
        break label79;
        paramView = this.wlX.get(Integer.valueOf(i));
        if (paramView == null) {
          p.hyc();
        }
        p.g(paramView, "viewPool[type]!!");
        paramView = (LinkedList)paramView;
      }
      AppMethodBeat.o(254788);
      return;
    }
  }
  
  public final void setAdapter(a<? extends c> parama)
  {
    AppMethodBeat.i(254784);
    p.h(parama, "adapter");
    this.wlY = parama;
    dGH();
    AppMethodBeat.o(254784);
  }
  
  public final void setItemViewWidth(int paramInt)
  {
    this.wma = paramInt;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Adapter;", "V", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "", "()V", "getItemType", "", "position", "getSize", "onBindView", "", "itemView", "Landroid/view/View;", "holder", "onCreateView", "layoutInflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/widget/FrameLayout;", "(Landroid/view/LayoutInflater;Landroid/widget/FrameLayout;I)Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "plugin-finder_release"})
  public static abstract class a<V extends FinderFeedAlbumView.c>
  {
    public abstract int Mm(int paramInt);
    
    public abstract V a(LayoutInflater paramLayoutInflater, FrameLayout paramFrameLayout, int paramInt);
    
    public abstract void a(View paramView, int paramInt, FinderFeedAlbumView.c paramc);
    
    public abstract int getSize();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Companion;", "", "()V", "ITEM_COUNT", "", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "getItemView", "()Landroid/view/View;", "plugin-finder_release"})
  public static abstract class c
  {
    final View aus;
    
    public c(View paramView)
    {
      this.aus = paramView;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(FinderFeedAlbumView paramFinderFeedAlbumView) {}
    
    public final void run()
    {
      AppMethodBeat.i(254783);
      this.wmd.requestLayout();
      AppMethodBeat.o(254783);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFeedAlbumView
 * JD-Core Version:    0.7.0.1
 */