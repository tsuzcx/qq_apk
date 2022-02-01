package com.tencent.mm.plugin.finder.video.plugin.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.af;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.effect.FinderFilterLayoutManager;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "adapter", "Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordTypeAdapter;", "itemClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "pos", "", "layoutManager", "Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterLayoutManager;", "selectChangeListener", "position", "selectIndex", "selectTypeList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "selectTypeView", "Landroid/support/v7/widget/RecyclerView;", "snapHelper", "Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordLinearSnapHelper;", "setData", "title", "setSelectChangeListener", "listener", "Companion", "RecordLinearSnapHelper", "RecordTypeAdapter", "plugin-finder_release"})
public final class RecordTypeSelectView
  extends RelativeLayout
{
  public static final RecordTypeSelectView.a whA;
  private b<? super Integer, x> hXE;
  private RecyclerView wht;
  private ArrayList<String> whu;
  private int whv;
  private RecordTypeSelectView.c whw;
  private FinderFilterLayoutManager whx;
  private b why;
  private b<? super Integer, x> whz;
  
  static
  {
    AppMethodBeat.i(254519);
    whA = new RecordTypeSelectView.a((byte)0);
    AppMethodBeat.o(254519);
  }
  
  public RecordTypeSelectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254518);
    this.whu = new ArrayList();
    this.whw = new RecordTypeSelectView.c(this, paramContext);
    this.whx = new FinderFilterLayoutManager(paramContext);
    this.why = new b();
    this.hXE = ((b)new d(this));
    LayoutInflater.from(paramContext).inflate(2131494605, (ViewGroup)this, true);
    paramContext = findViewById(2131307562);
    p.g(paramContext, "findViewById(R.id.select_type_list)");
    this.wht = ((RecyclerView)paramContext);
    this.wht.setLayoutManager((RecyclerView.LayoutManager)this.whx);
    this.wht.setAdapter((RecyclerView.a)this.whw);
    this.why.f(this.wht);
    AppMethodBeat.o(254518);
  }
  
  public final void setData(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(254517);
    p.h(paramArrayList, "title");
    this.whu.addAll((Collection)paramArrayList);
    this.whw.notifyDataSetChanged();
    AppMethodBeat.o(254517);
  }
  
  public final void setSelectChangeListener(b<? super Integer, x> paramb)
  {
    this.whz = paramb;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView$RecordLinearSnapHelper;", "Landroid/support/v7/widget/LinearSnapHelper;", "(Lcom/tencent/mm/plugin/finder/video/plugin/view/RecordTypeSelectView;)V", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "findSnapView", "findTargetSnapPosition", "", "velocityX", "velocityY", "plugin-finder_release"})
  public final class b
    extends af
  {
    public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(254508);
      paramInt1 = super.a(paramLayoutManager, paramInt1, paramInt2);
      AppMethodBeat.o(254508);
      return paramInt1;
    }
    
    public final View a(RecyclerView.LayoutManager paramLayoutManager)
    {
      AppMethodBeat.i(254509);
      View localView = super.a(paramLayoutManager);
      Object localObject = new StringBuilder("findSnapView ");
      if (localView != null)
      {
        paramLayoutManager = localView.getTag();
        Log.i("MicroMsg.RecordTypeSelectView", paramLayoutManager);
        i = RecordTypeSelectView.a(this.whB);
        if (localView == null) {
          break label155;
        }
        paramLayoutManager = localView.getTag();
        label62:
        if ((paramLayoutManager instanceof Integer)) {
          break label160;
        }
        label69:
        localObject = this.whB;
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
        paramLayoutManager = RecordTypeSelectView.b(this.whB);
        if (paramLayoutManager != null) {
          paramLayoutManager.invoke(Integer.valueOf(RecordTypeSelectView.a(this.whB)));
        }
        RecordTypeSelectView.c(this.whB).notifyDataSetChanged();
        do
        {
          AppMethodBeat.o(254509);
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
      AppMethodBeat.i(254507);
      p.h(paramLayoutManager, "layoutManager");
      p.h(paramView, "targetView");
      paramLayoutManager = super.a(paramLayoutManager, paramView);
      AppMethodBeat.o(254507);
      return paramLayoutManager;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends q
    implements b<Integer, x>
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