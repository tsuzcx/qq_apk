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
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.h.a;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView;", "Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Adapter;", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "isDataChange", "", "isPrint", "itemViewWidth", "getItemViewWidth", "()I", "setItemViewWidth", "(I)V", "padding", "", "getPadding", "()F", "viewPool", "Ljava/util/HashMap;", "Ljava/util/LinkedList;", "Lkotlin/collections/HashMap;", "createView", "width", "height", "offsetX", "offsetY", "index", "notifyDataChange", "", "onLayout", "changed", "left", "top", "right", "bottom", "onViewRemoved", "child", "Landroid/view/View;", "print", "content", "", "setAdapter", "Adapter", "Companion", "Holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFeedAlbumView
  extends RoundedCornerFrameLayout
{
  public static final b GyE;
  private final HashMap<Integer, LinkedList<c>> GyF;
  private a<? extends c> GyG;
  private boolean GyH;
  private int GyI;
  private final boolean GyJ;
  private final float fhM;
  
  static
  {
    AppMethodBeat.i(344918);
    GyE = new b((byte)0);
    AppMethodBeat.o(344918);
  }
  
  public FinderFeedAlbumView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344875);
    this.GyF = new HashMap();
    this.GyI = -1;
    this.fhM = (getContext().getResources().getDimension(e.c.Edge_0_5_A) / 2.0F);
    AppMethodBeat.o(344875);
  }
  
  public FinderFeedAlbumView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344879);
    this.GyF = new HashMap();
    this.GyI = -1;
    this.fhM = (getContext().getResources().getDimension(e.c.Edge_0_5_A) / 2.0F);
    AppMethodBeat.o(344879);
  }
  
  private final void Xa(String paramString)
  {
    AppMethodBeat.i(344904);
    if (this.GyJ) {
      Log.i("Finder.FinderFeedAlbumView", paramString);
    }
    AppMethodBeat.o(344904);
  }
  
  private static final void a(FinderFeedAlbumView paramFinderFeedAlbumView)
  {
    AppMethodBeat.i(344909);
    s.u(paramFinderFeedAlbumView, "this$0");
    paramFinderFeedAlbumView.requestLayout();
    AppMethodBeat.o(344909);
  }
  
  private final c m(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(344891);
    a locala = this.GyG;
    s.checkNotNull(locala);
    int i = locala.UG(paramInt5);
    Object localObject = (LinkedList)this.GyF.get(Integer.valueOf(i));
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label239;
      }
      localObject = LayoutInflater.from(getContext());
      s.s(localObject, "from(this.context)");
      localObject = locala.a((LayoutInflater)localObject, (FrameLayout)this, paramInt5);
    }
    label239:
    for (;;)
    {
      ((c)localObject).caK.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(paramInt1, paramInt2));
      ((c)localObject).caK.setTag(e.e.finder_album_item_id, localObject);
      ((c)localObject).caK.setTag(e.e.finder_album_item_type, Integer.valueOf(i));
      ((c)localObject).caK.setTranslationX(paramInt3);
      ((c)localObject).caK.setTranslationY(paramInt4);
      Xa("[createView] width=" + paramInt1 + " height=" + paramInt2 + " offsetX=" + paramInt3 + " offsetY=" + paramInt4 + " index=" + paramInt5);
      AppMethodBeat.o(344891);
      return localObject;
      localObject = (c)((LinkedList)localObject).poll();
      break;
    }
  }
  
  public final void deo()
  {
    AppMethodBeat.i(344952);
    this.GyH = true;
    Xa(s.X("[notifyDataChange] isInLayout=", Boolean.valueOf(isInLayout())));
    post(new FinderFeedAlbumView..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(344952);
  }
  
  public final int getItemViewWidth()
  {
    return this.GyI;
  }
  
  public final float getPadding()
  {
    return this.fhM;
  }
  
  public final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(344962);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
    paramInt4 = paramInt3 - paramInt1 - getPaddingStart() - getPaddingEnd();
    Object localObject1 = this.GyG;
    if (localObject1 == null) {}
    for (paramInt1 = 0;; paramInt1 = ((a)localObject1).getSize())
    {
      paramInt3 = k.qv(4, paramInt1);
      if (paramInt3 > 0) {
        break;
      }
      AppMethodBeat.o(344962);
      return;
    }
    Xa("[onLayout] changed=" + paramBoolean + " isDataChange=" + this.GyH + " width=" + paramInt4 + " height=" + paramInt2 + " size=" + paramInt3);
    float f1;
    float f2;
    if ((paramBoolean) || (this.GyH))
    {
      removeAllViews();
      f1 = paramInt2 / 3.0F;
      f2 = paramInt4 / 3.0F;
      paramInt1 = 0;
      if (paramInt3 <= 0) {}
    }
    for (;;)
    {
      paramInt2 = paramInt1 + 1;
      switch (paramInt1)
      {
      default: 
        localObject1 = m(a.eH(f2), a.eH(1.5F * f1), a.eH(2.0F * f2 + this.fhM), a.eH(1.5F * f1 + this.fhM), paramInt1);
      }
      for (;;)
      {
        Object localObject2 = ((c)localObject1).caK;
        addViewInLayout((View)localObject2, paramInt1, ((View)localObject2).getLayoutParams());
        localObject2 = this.GyG;
        if (localObject2 != null) {
          ((a)localObject2).a(((c)localObject1).caK, paramInt1, (c)localObject1);
        }
        if (paramInt2 < paramInt3) {
          break;
        }
        this.GyH = false;
        AppMethodBeat.o(344962);
        return;
        localObject1 = m(a.eH(2.0F * f2), a.eH(2.0F * f1), 0, 0, paramInt1);
        continue;
        localObject1 = m(a.eH(f2), a.eH(1.5F * f1), a.eH(2.0F * f2 + this.fhM), 0, paramInt1);
        continue;
        localObject1 = m(a.eH(2.0F * f2), a.eH(f1), 0, a.eH(2.0F * f1 + this.fhM), paramInt1);
      }
      paramInt1 = paramInt2;
    }
  }
  
  public final void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(344972);
    super.onViewRemoved(paramView);
    Object localObject;
    label29:
    label35:
    label47:
    int i;
    if (paramView == null)
    {
      localObject = null;
      if (!(localObject instanceof c)) {
        break label134;
      }
      localObject = (c)localObject;
      if (paramView != null) {
        break label139;
      }
      paramView = null;
      if (!(paramView instanceof Integer)) {
        break label150;
      }
      paramView = (Integer)paramView;
      if (paramView != null) {
        break label155;
      }
      i = 0;
      label53:
      if (localObject != null)
      {
        if (((Map)this.GyF).containsKey(Integer.valueOf(i))) {
          break label163;
        }
        paramView = new LinkedList();
        ((Map)this.GyF).put(Integer.valueOf(i), paramView);
      }
    }
    for (;;)
    {
      if (!paramView.contains(localObject)) {
        paramView.add(localObject);
      }
      AppMethodBeat.o(344972);
      return;
      localObject = paramView.getTag(e.e.finder_album_item_id);
      break;
      label134:
      localObject = null;
      break label29;
      label139:
      paramView = paramView.getTag(e.e.finder_album_item_type);
      break label35;
      label150:
      paramView = null;
      break label47;
      label155:
      i = paramView.intValue();
      break label53;
      label163:
      paramView = this.GyF.get(Integer.valueOf(i));
      s.checkNotNull(paramView);
      s.s(paramView, "{\n                viewPool[type]!!\n            }");
      paramView = (LinkedList)paramView;
    }
  }
  
  public final void setAdapter(a<? extends c> parama)
  {
    AppMethodBeat.i(344943);
    s.u(parama, "adapter");
    this.GyG = parama;
    deo();
    AppMethodBeat.o(344943);
  }
  
  public final void setItemViewWidth(int paramInt)
  {
    this.GyI = paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Adapter;", "V", "Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "", "()V", "getItemType", "", "position", "getSize", "onBindView", "", "itemView", "Landroid/view/View;", "holder", "onCreateView", "layoutInflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/widget/FrameLayout;", "(Landroid/view/LayoutInflater;Landroid/widget/FrameLayout;I)Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class a<V extends FinderFeedAlbumView.c>
  {
    public abstract int UG(int paramInt);
    
    public abstract V a(LayoutInflater paramLayoutInflater, FrameLayout paramFrameLayout, int paramInt);
    
    public abstract void a(View paramView, int paramInt, FinderFeedAlbumView.c paramc);
    
    public abstract int getSize();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Companion;", "", "()V", "ITEM_COUNT", "", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderFeedAlbumView$Holder;", "", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "getItemView", "()Landroid/view/View;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class c
  {
    final View caK;
    
    public c(View paramView)
    {
      this.caK = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFeedAlbumView
 * JD-Core Version:    0.7.0.1
 */