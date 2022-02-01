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
import com.tencent.mm.plugin.recordvideo.plugin.effect.FinderFilterLayoutManager;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "adapter", "Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter;", "itemClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "pos", "", "layoutManager", "Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterLayoutManager;", "selectChangeListener", "position", "selectIndex", "selectTypeList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "selectTypeView", "Landroid/support/v7/widget/RecyclerView;", "snapHelper", "Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordLinearSnapHelper;", "setData", "title", "setSelectChangeListener", "listener", "Companion", "RecordLinearSnapHelper", "RecordTypeAdapter", "plugin-finder_release"})
public final class RecordTypeSelectView
  extends RelativeLayout
{
  public static final RecordTypeSelectView.a sRc;
  private d.g.a.b<? super Integer, z> hcb;
  private RecyclerView sQV;
  private ArrayList<String> sQW;
  private int sQX;
  private c sQY;
  private FinderFilterLayoutManager sQZ;
  private b sRa;
  private d.g.a.b<? super Integer, z> sRb;
  
  static
  {
    AppMethodBeat.i(204967);
    sRc = new RecordTypeSelectView.a((byte)0);
    AppMethodBeat.o(204967);
  }
  
  public RecordTypeSelectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(204966);
    this.sQW = new ArrayList();
    this.sQY = new c(paramContext);
    this.sQZ = new FinderFilterLayoutManager(paramContext);
    this.sRa = new b();
    this.hcb = ((d.g.a.b)new d(this));
    LayoutInflater.from(paramContext).inflate(2131496248, (ViewGroup)this, true);
    paramContext = findViewById(2131307968);
    p.g(paramContext, "findViewById(R.id.select_type_list)");
    this.sQV = ((RecyclerView)paramContext);
    this.sQV.setLayoutManager((RecyclerView.i)this.sQZ);
    this.sQV.setAdapter((RecyclerView.a)this.sQY);
    this.sRa.j(this.sQV);
    AppMethodBeat.o(204966);
  }
  
  public final void setData(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(204965);
    p.h(paramArrayList, "title");
    this.sQW.addAll((Collection)paramArrayList);
    this.sQY.notifyDataSetChanged();
    AppMethodBeat.o(204965);
  }
  
  public final void setSelectChangeListener(d.g.a.b<? super Integer, z> paramb)
  {
    this.sRb = paramb;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordLinearSnapHelper;", "Landroid/support/v7/widget/LinearSnapHelper;", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;)V", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "findSnapView", "findTargetSnapPosition", "", "velocityX", "velocityY", "plugin-finder_release"})
  public final class b
    extends af
  {
    public final int a(RecyclerView.i parami, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204956);
      paramInt1 = super.a(parami, paramInt1, paramInt2);
      AppMethodBeat.o(204956);
      return paramInt1;
    }
    
    public final View a(RecyclerView.i parami)
    {
      AppMethodBeat.i(204957);
      View localView = super.a(parami);
      Object localObject = new StringBuilder("findSnapView ");
      if (localView != null)
      {
        parami = localView.getTag();
        ad.i("MicroMsg.RecordTypeSelectView", parami);
        i = RecordTypeSelectView.a(this.sRd);
        if (localView == null) {
          break label155;
        }
        parami = localView.getTag();
        label62:
        if ((parami instanceof Integer)) {
          break label160;
        }
        label69:
        localObject = this.sRd;
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
        parami = RecordTypeSelectView.b(this.sRd);
        if (parami != null) {
          parami.invoke(Integer.valueOf(RecordTypeSelectView.a(this.sRd)));
        }
        RecordTypeSelectView.c(this.sRd).notifyDataSetChanged();
        do
        {
          AppMethodBeat.o(204957);
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
      AppMethodBeat.i(204955);
      p.h(parami, "layoutManager");
      p.h(paramView, "targetView");
      parami = super.a(parami, paramView);
      AppMethodBeat.o(204955);
      return parami;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getItemCount", "", "getSpecialMargin", "width", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class c
    extends RecyclerView.a<RecyclerView.w>
  {
    private Context context;
    
    public c()
    {
      AppMethodBeat.i(204963);
      this.context = localObject;
      AppMethodBeat.o(204963);
    }
    
    private final int Gb(int paramInt)
    {
      AppMethodBeat.i(204962);
      paramInt = (com.tencent.mm.cc.a.ip(this.context) - paramInt) / 2;
      AppMethodBeat.o(204962);
      return paramInt;
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(204959);
      p.h(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(this.context).inflate(2131496247, paramViewGroup, false);
      paramViewGroup = (RecyclerView.w)new b(paramViewGroup, paramViewGroup);
      AppMethodBeat.o(204959);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, final int paramInt)
    {
      int j = 0;
      AppMethodBeat.i(204961);
      p.h(paramw, "viewHolder");
      paramw = paramw.auu;
      if (paramw == null)
      {
        paramw = new v("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(204961);
        throw paramw;
      }
      paramw = (TextView)paramw;
      paramw.setText((CharSequence)RecordTypeSelectView.d(RecordTypeSelectView.this).get(paramInt));
      float f = paramw.getPaint().measureText((String)RecordTypeSelectView.d(RecordTypeSelectView.this).get(paramInt)) + com.tencent.mm.cc.a.ax(this.context, 2131165294);
      ad.d("MicroMsg.RecordTypeSelectView", "onBindViewHolder pos:" + paramInt + " width:" + f);
      Object localObject = paramw.getLayoutParams();
      if (localObject == null)
      {
        paramw = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
        AppMethodBeat.o(204961);
        throw paramw;
      }
      localObject = (RecyclerView.LayoutParams)localObject;
      if (paramInt == 0) {}
      for (int i = Gb((int)f);; i = 0)
      {
        ((RecyclerView.LayoutParams)localObject).setMarginStart(i);
        localObject = paramw.getLayoutParams();
        if (localObject != null) {
          break;
        }
        paramw = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
        AppMethodBeat.o(204961);
        throw paramw;
      }
      localObject = (RecyclerView.LayoutParams)localObject;
      i = j;
      if (paramInt == getItemCount() - 1) {
        i = Gb((int)f);
      }
      ((RecyclerView.LayoutParams)localObject).setMarginEnd(i);
      if (paramInt == RecordTypeSelectView.a(RecordTypeSelectView.this)) {}
      for (f = 1.0F;; f = 0.5F)
      {
        paramw.setAlpha(f);
        paramw.setTag(Integer.valueOf(paramInt));
        paramw.setOnClickListener((View.OnClickListener)new a(this, paramInt));
        AppMethodBeat.o(204961);
        return;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(204960);
      int i = RecordTypeSelectView.d(RecordTypeSelectView.this).size();
      AppMethodBeat.o(204960);
      return i;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(RecordTypeSelectView.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(204958);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        RecordTypeSelectView.e(this.sRe.sRd).invoke(Integer.valueOf(paramInt));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(204958);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter$onCreateViewHolder$1", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-finder_release"})
    public static final class b
      extends RecyclerView.w
    {
      b(View paramView1, View paramView2)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<Integer, z>
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