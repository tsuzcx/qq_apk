package com.tencent.mm.plugin.finder.video.plugin.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.af;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.recordvideo.plugin.effect.FinderFilterLayoutManager;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.b;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "adapter", "Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter;", "itemClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "pos", "", "layoutManager", "Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterLayoutManager;", "selectChangeListener", "position", "selectIndex", "selectTypeList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "selectTypeView", "Landroid/support/v7/widget/RecyclerView;", "snapHelper", "Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordLinearSnapHelper;", "setData", "title", "setSelectChangeListener", "listener", "Companion", "RecordLinearSnapHelper", "RecordTypeAdapter", "plugin-finder_release"})
public final class RecordTypeSelectView
  extends RelativeLayout
{
  public static final RecordTypeSelectView.a rUr;
  private b<? super Integer, y> gIr;
  private RecyclerView rUk;
  private ArrayList<String> rUl;
  private int rUm;
  private c rUn;
  private FinderFilterLayoutManager rUo;
  private b rUp;
  private b<? super Integer, y> rUq;
  
  static
  {
    AppMethodBeat.i(204006);
    rUr = new RecordTypeSelectView.a((byte)0);
    AppMethodBeat.o(204006);
  }
  
  public RecordTypeSelectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(204005);
    this.rUl = new ArrayList();
    this.rUn = new c(paramContext);
    this.rUo = new FinderFilterLayoutManager(paramContext);
    this.rUp = new b();
    this.gIr = ((b)new d(this));
    LayoutInflater.from(paramContext).inflate(2131496248, (ViewGroup)this, true);
    paramContext = findViewById(2131307968);
    k.g(paramContext, "findViewById(R.id.select_type_list)");
    this.rUk = ((RecyclerView)paramContext);
    this.rUk.setLayoutManager((RecyclerView.i)this.rUo);
    this.rUk.setAdapter((RecyclerView.a)this.rUn);
    this.rUp.j(this.rUk);
    AppMethodBeat.o(204005);
  }
  
  public final void setData(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(204004);
    k.h(paramArrayList, "title");
    this.rUl.addAll((Collection)paramArrayList);
    this.rUn.notifyDataSetChanged();
    AppMethodBeat.o(204004);
  }
  
  public final void setSelectChangeListener(b<? super Integer, y> paramb)
  {
    this.rUq = paramb;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordLinearSnapHelper;", "Landroid/support/v7/widget/LinearSnapHelper;", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;)V", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "findSnapView", "findTargetSnapPosition", "", "velocityX", "velocityY", "plugin-finder_release"})
  public final class b
    extends af
  {
    public final int a(RecyclerView.i parami, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(203995);
      paramInt1 = super.a(parami, paramInt1, paramInt2);
      AppMethodBeat.o(203995);
      return paramInt1;
    }
    
    public final View a(RecyclerView.i parami)
    {
      AppMethodBeat.i(203996);
      View localView = super.a(parami);
      Object localObject = new StringBuilder("findSnapView ");
      if (localView != null)
      {
        parami = localView.getTag();
        ac.i("MicroMsg.RecordTypeSelectView", parami);
        i = RecordTypeSelectView.a(this.rUs);
        if (localView == null) {
          break label155;
        }
        parami = localView.getTag();
        label62:
        if ((parami instanceof Integer)) {
          break label160;
        }
        label69:
        localObject = this.rUs;
        if (localView == null) {
          break label174;
        }
        parami = localView.getTag();
        label84:
        parami = (Integer)parami;
        if (parami == null) {
          break label179;
        }
      }
      label155:
      label160:
      label174:
      label179:
      for (int i = parami.intValue();; i = 0)
      {
        RecordTypeSelectView.a((RecordTypeSelectView)localObject, i);
        parami = RecordTypeSelectView.b(this.rUs);
        if (parami != null) {
          parami.ay(Integer.valueOf(RecordTypeSelectView.a(this.rUs)));
        }
        RecordTypeSelectView.c(this.rUs).notifyDataSetChanged();
        do
        {
          AppMethodBeat.o(203996);
          return localView;
          parami = null;
          break;
          parami = null;
          break label62;
        } while (i == ((Integer)parami).intValue());
        break label69;
        parami = null;
        break label84;
      }
    }
    
    public final int[] a(RecyclerView.i parami, View paramView)
    {
      AppMethodBeat.i(203994);
      k.h(parami, "layoutManager");
      k.h(paramView, "targetView");
      parami = super.a(parami, paramView);
      AppMethodBeat.o(203994);
      return parami;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getItemCount", "", "getSpecialMargin", "width", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class c
    extends RecyclerView.a<RecyclerView.w>
  {
    private Context context;
    
    public c()
    {
      AppMethodBeat.i(204002);
      this.context = localObject;
      AppMethodBeat.o(204002);
    }
    
    private final int EO(int paramInt)
    {
      AppMethodBeat.i(204001);
      paramInt = (a.ig(this.context) - paramInt) / 2;
      AppMethodBeat.o(204001);
      return paramInt;
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(203998);
      k.h(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(this.context).inflate(2131496247, paramViewGroup, false);
      paramViewGroup = (RecyclerView.w)new b(paramViewGroup, paramViewGroup);
      AppMethodBeat.o(203998);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, final int paramInt)
    {
      int j = 0;
      AppMethodBeat.i(204000);
      k.h(paramw, "viewHolder");
      paramw = paramw.asD;
      if (paramw == null)
      {
        paramw = new v("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(204000);
        throw paramw;
      }
      paramw = (TextView)paramw;
      paramw.setText((CharSequence)RecordTypeSelectView.d(RecordTypeSelectView.this).get(paramInt));
      float f = paramw.getPaint().measureText((String)RecordTypeSelectView.d(RecordTypeSelectView.this).get(paramInt)) + a.au(this.context, 2131165294);
      ac.d("MicroMsg.RecordTypeSelectView", "onBindViewHolder pos:" + paramInt + " width:" + f);
      Object localObject = paramw.getLayoutParams();
      if (localObject == null)
      {
        paramw = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
        AppMethodBeat.o(204000);
        throw paramw;
      }
      localObject = (RecyclerView.LayoutParams)localObject;
      if (paramInt == 0) {}
      for (int i = EO((int)f);; i = 0)
      {
        ((RecyclerView.LayoutParams)localObject).setMarginStart(i);
        localObject = paramw.getLayoutParams();
        if (localObject != null) {
          break;
        }
        paramw = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
        AppMethodBeat.o(204000);
        throw paramw;
      }
      localObject = (RecyclerView.LayoutParams)localObject;
      i = j;
      if (paramInt == getItemCount() - 1) {
        i = EO((int)f);
      }
      ((RecyclerView.LayoutParams)localObject).setMarginEnd(i);
      if (paramInt == RecordTypeSelectView.a(RecordTypeSelectView.this)) {}
      for (f = 1.0F;; f = 0.5F)
      {
        paramw.setAlpha(f);
        paramw.setTag(Integer.valueOf(paramInt));
        paramw.setOnClickListener((View.OnClickListener)new a(this, paramInt));
        AppMethodBeat.o(204000);
        return;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(203999);
      int i = RecordTypeSelectView.d(RecordTypeSelectView.this).size();
      AppMethodBeat.o(203999);
      return i;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(RecordTypeSelectView.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(203997);
        RecordTypeSelectView.e(this.rUt.rUs).ay(Integer.valueOf(paramInt));
        AppMethodBeat.o(203997);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter$onCreateViewHolder$1", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-finder_release"})
    public static final class b
      extends RecyclerView.w
    {
      b(View paramView1, View paramView2)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements b<Integer, y>
  {
    d(RecordTypeSelectView paramRecordTypeSelectView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.view.RecordTypeSelectView
 * JD-Core Version:    0.7.0.1
 */