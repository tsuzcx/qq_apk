package com.tencent.mm.plugin.finder.video.plugin.view;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.recordvideo.plugin.effect.FinderFilterLayoutManager;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "adapter", "Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter;", "itemClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "pos", "", "layoutManager", "Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterLayoutManager;", "selectChangeListener", "position", "selectIndex", "selectTypeList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "selectTypeView", "Landroidx/recyclerview/widget/RecyclerView;", "snapHelper", "Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordLinearSnapHelper;", "setData", "title", "setSelectChangeListener", "listener", "Companion", "RecordLinearSnapHelper", "RecordTypeAdapter", "plugin-finder_release"})
public final class RecordTypeSelectView
  extends RelativeLayout
{
  public static final a ARq;
  private RecyclerView ARj;
  private ArrayList<String> ARk;
  private int ARl;
  private c ARm;
  private FinderFilterLayoutManager ARn;
  private b ARo;
  private kotlin.g.a.b<? super Integer, x> ARp;
  private kotlin.g.a.b<? super Integer, x> kMj;
  
  static
  {
    AppMethodBeat.i(282614);
    ARq = new a((byte)0);
    AppMethodBeat.o(282614);
  }
  
  public RecordTypeSelectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(282613);
    this.ARk = new ArrayList();
    this.ARm = new c(paramContext);
    this.ARn = new FinderFilterLayoutManager(paramContext);
    this.ARo = new b();
    this.kMj = ((kotlin.g.a.b)new d(this));
    LayoutInflater.from(paramContext).inflate(b.g.finder_record_type_layout, (ViewGroup)this, true);
    paramContext = findViewById(b.f.select_type_list);
    p.j(paramContext, "findViewById(R.id.select_type_list)");
    this.ARj = ((RecyclerView)paramContext);
    this.ARj.setLayoutManager((RecyclerView.LayoutManager)this.ARn);
    this.ARj.setAdapter((RecyclerView.a)this.ARm);
    this.ARo.a(this.ARj);
    AppMethodBeat.o(282613);
  }
  
  public final void setData(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(282611);
    p.k(paramArrayList, "title");
    this.ARk.addAll((Collection)paramArrayList);
    this.ARm.notifyDataSetChanged();
    AppMethodBeat.o(282611);
  }
  
  public final void setSelectChangeListener(kotlin.g.a.b<? super Integer, x> paramb)
  {
    this.ARp = paramb;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordLinearSnapHelper;", "Landroidx/recyclerview/widget/LinearSnapHelper;", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;)V", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "findSnapView", "findTargetSnapPosition", "", "velocityX", "velocityY", "plugin-finder_release"})
  public final class b
    extends androidx.recyclerview.widget.q
  {
    public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(286321);
      paramInt1 = super.a(paramLayoutManager, paramInt1, paramInt2);
      AppMethodBeat.o(286321);
      return paramInt1;
    }
    
    public final View a(RecyclerView.LayoutManager paramLayoutManager)
    {
      AppMethodBeat.i(286322);
      View localView = super.a(paramLayoutManager);
      Object localObject = new StringBuilder("findSnapView ");
      if (localView != null)
      {
        paramLayoutManager = localView.getTag();
        Log.i("MicroMsg.RecordTypeSelectView", paramLayoutManager);
        i = RecordTypeSelectView.a(this.ARr);
        if (localView == null) {
          break label155;
        }
        paramLayoutManager = localView.getTag();
        label62:
        if ((paramLayoutManager instanceof Integer)) {
          break label160;
        }
        label69:
        localObject = this.ARr;
        if (localView == null) {
          break label174;
        }
        paramLayoutManager = localView.getTag();
        label84:
        paramLayoutManager = (Integer)paramLayoutManager;
        if (paramLayoutManager == null) {
          break label179;
        }
      }
      label155:
      label160:
      label174:
      label179:
      for (int i = paramLayoutManager.intValue();; i = 0)
      {
        RecordTypeSelectView.a((RecordTypeSelectView)localObject, i);
        paramLayoutManager = RecordTypeSelectView.b(this.ARr);
        if (paramLayoutManager != null) {
          paramLayoutManager.invoke(Integer.valueOf(RecordTypeSelectView.a(this.ARr)));
        }
        RecordTypeSelectView.c(this.ARr).notifyDataSetChanged();
        do
        {
          AppMethodBeat.o(286322);
          return localView;
          paramLayoutManager = null;
          break;
          paramLayoutManager = null;
          break label62;
        } while (i == ((Integer)paramLayoutManager).intValue());
        break label69;
        paramLayoutManager = null;
        break label84;
      }
    }
    
    public final int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView)
    {
      AppMethodBeat.i(286320);
      p.k(paramLayoutManager, "layoutManager");
      p.k(paramView, "targetView");
      paramLayoutManager = super.a(paramLayoutManager, paramView);
      AppMethodBeat.o(286320);
      return paramLayoutManager;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getItemCount", "", "getSpecialMargin", "width", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class c
    extends RecyclerView.a<RecyclerView.v>
  {
    private Context context;
    
    public c()
    {
      AppMethodBeat.i(278608);
      this.context = localObject;
      AppMethodBeat.o(278608);
    }
    
    private final int Rx(int paramInt)
    {
      AppMethodBeat.i(278607);
      paramInt = (com.tencent.mm.ci.a.kr(this.context) - paramInt) / 2;
      AppMethodBeat.o(278607);
      return paramInt;
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(278603);
      p.k(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(this.context).inflate(b.g.finder_record_type_item_layout, paramViewGroup, false);
      paramViewGroup = (RecyclerView.v)new b(paramViewGroup, paramViewGroup);
      AppMethodBeat.o(278603);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, final int paramInt)
    {
      int j = 0;
      AppMethodBeat.i(278606);
      p.k(paramv, "viewHolder");
      paramv = paramv.amk;
      if (paramv == null)
      {
        paramv = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(278606);
        throw paramv;
      }
      paramv = (TextView)paramv;
      paramv.setText((CharSequence)RecordTypeSelectView.d(RecordTypeSelectView.this).get(paramInt));
      float f = paramv.getPaint().measureText((String)RecordTypeSelectView.d(RecordTypeSelectView.this).get(paramInt)) + com.tencent.mm.ci.a.aY(this.context, b.d.Edge_4A);
      Log.d("MicroMsg.RecordTypeSelectView", "onBindViewHolder pos:" + paramInt + " width:" + f);
      Object localObject = paramv.getLayoutParams();
      if (localObject == null)
      {
        paramv = new t("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        AppMethodBeat.o(278606);
        throw paramv;
      }
      localObject = (RecyclerView.LayoutParams)localObject;
      if (paramInt == 0) {}
      for (int i = Rx((int)f);; i = 0)
      {
        ((RecyclerView.LayoutParams)localObject).setMarginStart(i);
        localObject = paramv.getLayoutParams();
        if (localObject != null) {
          break;
        }
        paramv = new t("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        AppMethodBeat.o(278606);
        throw paramv;
      }
      localObject = (RecyclerView.LayoutParams)localObject;
      i = j;
      if (paramInt == getItemCount() - 1) {
        i = Rx((int)f);
      }
      ((RecyclerView.LayoutParams)localObject).setMarginEnd(i);
      if (paramInt == RecordTypeSelectView.a(RecordTypeSelectView.this)) {}
      for (f = 1.0F;; f = 0.5F)
      {
        paramv.setAlpha(f);
        paramv.setTag(Integer.valueOf(paramInt));
        paramv.setOnClickListener((View.OnClickListener)new a(this, paramInt));
        AppMethodBeat.o(278606);
        return;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(278604);
      int i = RecordTypeSelectView.d(RecordTypeSelectView.this).size();
      AppMethodBeat.o(278604);
      return i;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(RecordTypeSelectView.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(285541);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        RecordTypeSelectView.e(this.ARs.ARr).invoke(Integer.valueOf(paramInt));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(285541);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter$onCreateViewHolder$1", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-finder_release"})
    public static final class b
      extends RecyclerView.v
    {
      b(View paramView1, View paramView2)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, x>
  {
    d(RecordTypeSelectView paramRecordTypeSelectView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.view.RecordTypeSelectView
 * JD-Core Version:    0.7.0.1
 */