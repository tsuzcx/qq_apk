package com.tencent.mm.plugin.finder.video.plugin.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.recordvideo.plugin.effect.FinderFilterLayoutManager;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.b;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "adapter", "Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter;", "itemClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "pos", "", "layoutManager", "Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterLayoutManager;", "selectChangeListener", "position", "selectIndex", "selectTypeList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "selectTypeView", "Landroid/support/v7/widget/RecyclerView;", "snapHelper", "Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordLinearSnapHelper;", "setData", "title", "setSelectChangeListener", "listener", "Companion", "RecordLinearSnapHelper", "RecordTypeAdapter", "plugin-finder_release"})
public final class RecordTypeSelectView
  extends RelativeLayout
{
  public static final a Ldz;
  private b<? super Integer, y> KBy;
  private RecyclerView Ldt;
  private ArrayList<String> Ldu;
  private c Ldv;
  private FinderFilterLayoutManager Ldw;
  private b Ldx;
  private b<? super Integer, y> Ldy;
  private int zGx;
  
  static
  {
    AppMethodBeat.i(199938);
    Ldz = new a((byte)0);
    AppMethodBeat.o(199938);
  }
  
  public RecordTypeSelectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(199937);
    this.Ldu = new ArrayList();
    this.Ldv = new c(paramContext);
    this.Ldw = new FinderFilterLayoutManager(paramContext);
    this.Ldx = new b();
    this.KBy = ((b)new d(this));
    LayoutInflater.from(paramContext).inflate(2131496247, (ViewGroup)this, true);
    paramContext = findViewById(2131307860);
    k.g(paramContext, "findViewById(R.id.select_type_list)");
    this.Ldt = ((RecyclerView)paramContext);
    this.Ldt.setLayoutManager((RecyclerView.i)this.Ldw);
    this.Ldt.setAdapter((RecyclerView.a)this.Ldv);
    this.Ldx.j(this.Ldt);
    AppMethodBeat.o(199937);
  }
  
  public final void setData(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(199936);
    k.h(paramArrayList, "title");
    this.Ldu.addAll((Collection)paramArrayList);
    this.Ldv.notifyDataSetChanged();
    AppMethodBeat.o(199936);
  }
  
  public final void setSelectChangeListener(b<? super Integer, y> paramb)
  {
    this.Ldy = paramb;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordLinearSnapHelper;", "Landroid/support/v7/widget/LinearSnapHelper;", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;)V", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "findSnapView", "findTargetSnapPosition", "", "velocityX", "velocityY", "plugin-finder_release"})
  public final class b
    extends af
  {
    public final int a(RecyclerView.i parami, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199927);
      paramInt1 = super.a(parami, paramInt1, paramInt2);
      AppMethodBeat.o(199927);
      return paramInt1;
    }
    
    public final View a(RecyclerView.i parami)
    {
      AppMethodBeat.i(199928);
      View localView = super.a(parami);
      Object localObject = new StringBuilder("findSnapView ");
      if (localView != null)
      {
        parami = localView.getTag();
        ad.i("MicroMsg.RecordTypeSelectView", parami);
        i = RecordTypeSelectView.a(this.LdA);
        if (localView == null) {
          break label155;
        }
        parami = localView.getTag();
        label62:
        if ((parami instanceof Integer)) {
          break label160;
        }
        label69:
        localObject = this.LdA;
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
        parami = RecordTypeSelectView.b(this.LdA);
        if (parami != null) {
          parami.aA(Integer.valueOf(RecordTypeSelectView.a(this.LdA)));
        }
        RecordTypeSelectView.c(this.LdA).notifyDataSetChanged();
        do
        {
          AppMethodBeat.o(199928);
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
      AppMethodBeat.i(199926);
      k.h(parami, "layoutManager");
      k.h(paramView, "targetView");
      parami = super.a(parami, paramView);
      AppMethodBeat.o(199926);
      return parami;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getItemCount", "", "getSpecialMargin", "width", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class c
    extends RecyclerView.a<RecyclerView.v>
  {
    private Context context;
    
    public c()
    {
      AppMethodBeat.i(199934);
      this.context = localObject;
      AppMethodBeat.o(199934);
    }
    
    private final int ahK(int paramInt)
    {
      AppMethodBeat.i(199933);
      paramInt = (a.hV(this.context) - paramInt) / 2;
      AppMethodBeat.o(199933);
      return paramInt;
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(199930);
      k.h(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(this.context).inflate(2131496246, paramViewGroup, false);
      paramViewGroup = (RecyclerView.v)new b(paramViewGroup, paramViewGroup);
      AppMethodBeat.o(199930);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, final int paramInt)
    {
      int j = 0;
      AppMethodBeat.i(199932);
      k.h(paramv, "viewHolder");
      paramv = paramv.arI;
      if (paramv == null)
      {
        paramv = new v("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(199932);
        throw paramv;
      }
      paramv = (TextView)paramv;
      paramv.setText((CharSequence)RecordTypeSelectView.d(RecordTypeSelectView.this).get(paramInt));
      float f = paramv.getPaint().measureText((String)RecordTypeSelectView.d(RecordTypeSelectView.this).get(paramInt)) + a.ao(this.context, 2131165294);
      ad.d("MicroMsg.RecordTypeSelectView", "onBindViewHolder pos:" + paramInt + " width:" + f);
      Object localObject = paramv.getLayoutParams();
      if (localObject == null)
      {
        paramv = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
        AppMethodBeat.o(199932);
        throw paramv;
      }
      localObject = (RecyclerView.LayoutParams)localObject;
      if (paramInt == 0) {}
      for (int i = ahK((int)f);; i = 0)
      {
        ((RecyclerView.LayoutParams)localObject).setMarginStart(i);
        localObject = paramv.getLayoutParams();
        if (localObject != null) {
          break;
        }
        paramv = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
        AppMethodBeat.o(199932);
        throw paramv;
      }
      localObject = (RecyclerView.LayoutParams)localObject;
      i = j;
      if (paramInt == getItemCount() - 1) {
        i = ahK((int)f);
      }
      ((RecyclerView.LayoutParams)localObject).setMarginEnd(i);
      if (paramInt == RecordTypeSelectView.a(RecordTypeSelectView.this)) {}
      for (f = 1.0F;; f = 0.5F)
      {
        paramv.setAlpha(f);
        paramv.setTag(Integer.valueOf(paramInt));
        paramv.setOnClickListener((View.OnClickListener)new a(this, paramInt));
        AppMethodBeat.o(199932);
        return;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(199931);
      int i = RecordTypeSelectView.d(RecordTypeSelectView.this).size();
      AppMethodBeat.o(199931);
      return i;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(RecordTypeSelectView.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(199929);
        RecordTypeSelectView.e(this.LdB.LdA).aA(Integer.valueOf(paramInt));
        AppMethodBeat.o(199929);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter$onCreateViewHolder$1", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-finder_release"})
    public static final class b
      extends RecyclerView.v
    {
      b(View paramView1, View paramView2)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.view.RecordTypeSelectView
 * JD-Core Version:    0.7.0.1
 */