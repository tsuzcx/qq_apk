package com.tencent.mm.plugin.finder.video.plugin.view;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.publish.l.c;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.publish.l.f;
import com.tencent.mm.plugin.recordvideo.plugin.effect.FinderFilterLayoutManager;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "adapter", "Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter;", "itemClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "pos", "", "layoutManager", "Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterLayoutManager;", "selectChangeListener", "position", "selectIndex", "selectTypeList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "selectTypeView", "Landroidx/recyclerview/widget/RecyclerView;", "snapHelper", "Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordLinearSnapHelper;", "setData", "title", "setSelectChangeListener", "listener", "Companion", "RecordLinearSnapHelper", "RecordTypeAdapter", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RecordTypeSelectView
  extends RelativeLayout
{
  public static final RecordTypeSelectView.a Gtn;
  private int Fjh;
  private RecyclerView Gto;
  private ArrayList<String> Gtp;
  private c Gtq;
  private FinderFilterLayoutManager Gtr;
  private b Gts;
  private kotlin.g.a.b<? super Integer, ah> Gtt;
  private kotlin.g.a.b<? super Integer, ah> nod;
  
  static
  {
    AppMethodBeat.i(335765);
    Gtn = new RecordTypeSelectView.a((byte)0);
    AppMethodBeat.o(335765);
  }
  
  public RecordTypeSelectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(335703);
    this.Gtp = new ArrayList();
    this.Gtq = new c(paramContext);
    this.Gtr = new FinderFilterLayoutManager(paramContext);
    this.Gts = new b();
    this.nod = ((kotlin.g.a.b)new d(this));
    LayoutInflater.from(paramContext).inflate(l.f.finder_record_type_layout, (ViewGroup)this, true);
    paramContext = findViewById(l.e.select_type_list);
    s.s(paramContext, "findViewById(R.id.select_type_list)");
    this.Gto = ((RecyclerView)paramContext);
    this.Gto.setLayoutManager((RecyclerView.LayoutManager)this.Gtr);
    this.Gto.setAdapter((RecyclerView.a)this.Gtq);
    this.Gts.a(this.Gto);
    AppMethodBeat.o(335703);
  }
  
  public final void setData(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(335771);
    s.u(paramArrayList, "title");
    this.Gtp.addAll((Collection)paramArrayList);
    this.Gtq.bZE.notifyChanged();
    AppMethodBeat.o(335771);
  }
  
  public final void setSelectChangeListener(kotlin.g.a.b<? super Integer, ah> paramb)
  {
    this.Gtt = paramb;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordLinearSnapHelper;", "Landroidx/recyclerview/widget/LinearSnapHelper;", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;)V", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "findSnapView", "findTargetSnapPosition", "", "velocityX", "velocityY", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends p
  {
    public b()
    {
      AppMethodBeat.i(335662);
      AppMethodBeat.o(335662);
    }
    
    public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(335678);
      paramInt1 = super.a(paramLayoutManager, paramInt1, paramInt2);
      AppMethodBeat.o(335678);
      return paramInt1;
    }
    
    public final View a(RecyclerView.LayoutManager paramLayoutManager)
    {
      AppMethodBeat.i(335694);
      View localView = super.a(paramLayoutManager);
      label52:
      label54:
      RecordTypeSelectView localRecordTypeSelectView;
      if (localView == null)
      {
        paramLayoutManager = null;
        Log.i("MicroMsg.RecordTypeSelectView", s.X("findSnapView ", paramLayoutManager));
        i = RecordTypeSelectView.a(this.Gtu);
        if (localView != null)
        {
          paramLayoutManager = localView.getTag();
          if ((paramLayoutManager instanceof Integer)) {
            break label144;
          }
        }
        i = 0;
        if (i == 0)
        {
          localRecordTypeSelectView = this.Gtu;
          if (localView != null) {
            break label160;
          }
          paramLayoutManager = null;
          label70:
          paramLayoutManager = (Integer)paramLayoutManager;
          if (paramLayoutManager != null) {
            break label168;
          }
        }
      }
      label144:
      label160:
      label168:
      for (int i = 0;; i = paramLayoutManager.intValue())
      {
        RecordTypeSelectView.a(localRecordTypeSelectView, i);
        paramLayoutManager = RecordTypeSelectView.b(this.Gtu);
        if (paramLayoutManager != null) {
          paramLayoutManager.invoke(Integer.valueOf(RecordTypeSelectView.a(this.Gtu)));
        }
        RecordTypeSelectView.c(this.Gtu).bZE.notifyChanged();
        AppMethodBeat.o(335694);
        return localView;
        paramLayoutManager = localView.getTag();
        break;
        if (i != ((Number)paramLayoutManager).intValue()) {
          break label52;
        }
        i = 1;
        break label54;
        paramLayoutManager = localView.getTag();
        break label70;
      }
    }
    
    public final int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView)
    {
      AppMethodBeat.i(335673);
      s.u(paramLayoutManager, "layoutManager");
      s.u(paramView, "targetView");
      paramLayoutManager = super.a(paramLayoutManager, paramView);
      AppMethodBeat.o(335673);
      return paramLayoutManager;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getItemCount", "", "getSpecialMargin", "width", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends RecyclerView.a<RecyclerView.v>
  {
    private Context context;
    
    public c()
    {
      AppMethodBeat.i(335682);
      this.context = localObject;
      AppMethodBeat.o(335682);
    }
    
    private final int UC(int paramInt)
    {
      AppMethodBeat.i(335691);
      paramInt = (com.tencent.mm.cd.a.ms(this.context) - paramInt) / 2;
      AppMethodBeat.o(335691);
      return paramInt;
    }
    
    private static final void a(RecordTypeSelectView paramRecordTypeSelectView, int paramInt, View paramView)
    {
      AppMethodBeat.i(335698);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecordTypeSelectView);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramRecordTypeSelectView, "this$0");
      RecordTypeSelectView.e(paramRecordTypeSelectView).invoke(Integer.valueOf(paramInt));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(335698);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(335719);
      s.u(paramViewGroup, "parent");
      paramViewGroup = (RecyclerView.v)new a(LayoutInflater.from(this.context).inflate(l.f.finder_record_type_item_layout, paramViewGroup, false));
      AppMethodBeat.o(335719);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      int j = 0;
      AppMethodBeat.i(335737);
      s.u(paramv, "viewHolder");
      paramv = (TextView)paramv.caK;
      paramv.setText((CharSequence)RecordTypeSelectView.d(RecordTypeSelectView.this).get(paramInt));
      float f = paramv.getPaint().measureText((String)RecordTypeSelectView.d(RecordTypeSelectView.this).get(paramInt)) + com.tencent.mm.cd.a.br(this.context, l.c.Edge_4A);
      Log.d("MicroMsg.RecordTypeSelectView", "onBindViewHolder pos:" + paramInt + " width:" + f);
      Object localObject = paramv.getLayoutParams();
      if (localObject == null)
      {
        paramv = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        AppMethodBeat.o(335737);
        throw paramv;
      }
      localObject = (RecyclerView.LayoutParams)localObject;
      if (paramInt == 0) {}
      for (int i = UC((int)f);; i = 0)
      {
        ((RecyclerView.LayoutParams)localObject).setMarginStart(i);
        localObject = paramv.getLayoutParams();
        if (localObject != null) {
          break;
        }
        paramv = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        AppMethodBeat.o(335737);
        throw paramv;
      }
      localObject = (RecyclerView.LayoutParams)localObject;
      i = j;
      if (paramInt == getItemCount() - 1) {
        i = UC((int)f);
      }
      ((RecyclerView.LayoutParams)localObject).setMarginEnd(i);
      if (paramInt == RecordTypeSelectView.a(RecordTypeSelectView.this)) {}
      for (f = 1.0F;; f = 0.5F)
      {
        paramv.setAlpha(f);
        paramv.setTag(Integer.valueOf(paramInt));
        paramv.setOnClickListener(new RecordTypeSelectView.c..ExternalSyntheticLambda0(RecordTypeSelectView.this, paramInt));
        AppMethodBeat.o(335737);
        return;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(335725);
      int i = RecordTypeSelectView.d(RecordTypeSelectView.this).size();
      AppMethodBeat.o(335725);
      return i;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter$onCreateViewHolder$1", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends RecyclerView.v
    {
      a(View paramView)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<Integer, ah>
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