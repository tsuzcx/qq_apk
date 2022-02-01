package com.tencent.mm.plugin.hld.alternative;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.k;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.plugin.hld.view.ImeGridScrollView;
import com.tencent.mm.plugin.hld.view.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.WxGridLayoutManager;
import com.tencent.wxhld.info.Candidate;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.wxhld.info.Candidate;>;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridScrollView;", "Lcom/tencent/mm/plugin/hld/view/ImeGridScrollView;", "Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridViewHolder$IAlternativeWordViewListener;", "Lcom/tencent/mm/plugin/hld/candidate/ICandidateDataListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "alternativeWordList", "Ljava/util/ArrayList;", "Lcom/tencent/wxhld/info/Candidate;", "Lkotlin/collections/ArrayList;", "candidateListfetching", "", "hasMoreCandidate", "getAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "initView", "", "onClick", "text", "", "id", "", "order", "pressTime", "", "reset", "updateCandidateList", "addList", "type", "newList", "hasMore", "Companion", "plugin-hld_release"})
public final class ImeAlternativeWordGridScrollView
  extends ImeGridScrollView
  implements e.a, com.tencent.mm.plugin.hld.candidate.a
{
  public static final a DtX;
  private ArrayList<Candidate> DtU;
  private boolean DtV;
  private boolean DtW;
  
  static
  {
    AppMethodBeat.i(211575);
    DtX = new a((byte)0);
    AppMethodBeat.o(211575);
  }
  
  public ImeAlternativeWordGridScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImeAlternativeWordGridScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private ImeAlternativeWordGridScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(211574);
    this.DtU = new ArrayList();
    initView();
    AppMethodBeat.o(211574);
  }
  
  public final void a(String paramString, byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    AppMethodBeat.i(211569);
    p.k(paramString, "text");
    p.k(paramArrayOfByte, "id");
    com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
    com.tencent.mm.plugin.hld.f.l.it("WxIme.ImeAlternativeWordGridScrollView", "onClick " + paramString + ' ' + paramInt);
    n.a(n.DEn, paramString, paramArrayOfByte, null, true, paramLong, false, 36);
    paramString = k.DDb;
    k.hN(2, paramInt);
    paramString = k.DDb;
    k.hO(700, 1);
    AppMethodBeat.o(211569);
  }
  
  public final void a(ArrayList<Candidate> paramArrayList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    AppMethodBeat.i(211572);
    p.k(paramArrayList, "addList");
    Log.d("WxIme.ImeAlternativeWordGridScrollView", "updateCandidates " + paramArrayList.size());
    Object localObject2 = new ArrayList((Collection)paramArrayList);
    if (paramInt == 1) {
      ((ArrayList)localObject2).clear();
    }
    this.DtV = false;
    Object localObject1 = getScrollContainerRv().getAdapter();
    paramArrayList = (ArrayList<Candidate>)localObject1;
    if (!(localObject1 instanceof d)) {
      paramArrayList = null;
    }
    paramArrayList = (d)paramArrayList;
    if (paramArrayList != null) {
      paramArrayList.nnu = null;
    }
    localObject1 = getScrollContainerRv().getAdapter();
    paramArrayList = (ArrayList<Candidate>)localObject1;
    if (!(localObject1 instanceof d)) {
      paramArrayList = null;
    }
    paramArrayList = (d)paramArrayList;
    if (paramArrayList != null)
    {
      localObject1 = getScrollContainerRv();
      localObject2 = (List)localObject2;
      if (paramBoolean1) {
        break label176;
      }
    }
    label176:
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      f.a(paramArrayList, (RecyclerView)localObject1, (List)localObject2, null, paramBoolean1, 4);
      this.DtW = paramBoolean2;
      AppMethodBeat.o(211572);
      return;
    }
  }
  
  public final RecyclerView.a<RecyclerView.v> getAdapter()
  {
    AppMethodBeat.i(211567);
    Object localObject = getContext();
    p.j(localObject, "context");
    localObject = (RecyclerView.a)new d((Context)localObject, this.DtU, (e.a)this);
    AppMethodBeat.o(211567);
    return localObject;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(211564);
    super.initView();
    getScrollContainerRv().a((RecyclerView.l)new b(this));
    AppMethodBeat.o(211564);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(211570);
    super.reset();
    this.DtU.clear();
    AppMethodBeat.o(211570);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridScrollView$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridScrollView$initView$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-hld_release"})
  public static final class b
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(213923);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridScrollView$initView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridScrollView$initView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(213923);
    }
    
    public final void onScrolled(final RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(213921);
      Object localObject = new b();
      ((b)localObject).bn(paramRecyclerView);
      ((b)localObject).sg(paramInt1);
      ((b)localObject).sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridScrollView$initView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      if (ImeAlternativeWordGridScrollView.a(this.DtY).isEmpty())
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridScrollView$initView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(213921);
        return;
      }
      paramInt1 = ImeAlternativeWordGridScrollView.a(this.DtY).size();
      paramRecyclerView = this.DtY.getScrollContainerRv().getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxGridLayoutManager");
        AppMethodBeat.o(213921);
        throw paramRecyclerView;
      }
      paramInt2 = ((WxGridLayoutManager)paramRecyclerView).kL();
      if (ImeAlternativeWordGridScrollView.b(this.DtY))
      {
        if ((!ImeAlternativeWordGridScrollView.c(this.DtY)) && (paramInt1 - paramInt2 <= 20))
        {
          ImeAlternativeWordGridScrollView.d(this.DtY);
          paramRecyclerView = n.DEn;
          n.eEN();
        }
        if ((ImeAlternativeWordGridScrollView.c(this.DtY)) && (paramInt2 == paramInt1 - 1))
        {
          localObject = this.DtY.getScrollContainerRv().getAdapter();
          paramRecyclerView = (RecyclerView)localObject;
          if (!(localObject instanceof d)) {
            paramRecyclerView = null;
          }
          paramRecyclerView = (d)paramRecyclerView;
          if (paramRecyclerView == null) {
            break label403;
          }
        }
      }
      label403:
      for (paramRecyclerView = paramRecyclerView.nnu;; paramRecyclerView = null)
      {
        if (paramRecyclerView == null)
        {
          ProgressBar localProgressBar = new ProgressBar(this.DtY.getContext(), null, 0, a.k.smallCustomProgressBar);
          paramRecyclerView = new RelativeLayout.LayoutParams(com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.d.S5_alternative_footer_progress_size), com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), a.d.S5_alternative_footer_progress_size));
          paramRecyclerView.addRule(13);
          localProgressBar.setLayoutParams((ViewGroup.LayoutParams)paramRecyclerView);
          localObject = this.DtY.getScrollContainerRv().getAdapter();
          paramRecyclerView = (RecyclerView)localObject;
          if (!(localObject instanceof d)) {
            paramRecyclerView = null;
          }
          paramRecyclerView = (d)paramRecyclerView;
          if (paramRecyclerView != null) {
            paramRecyclerView.nnu = ((View)localProgressBar);
          }
          paramRecyclerView = new ArrayList((Collection)ImeAlternativeWordGridScrollView.a(this.DtY));
          this.DtY.getScrollContainerRv().post((Runnable)new a(this, paramRecyclerView));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridScrollView$initView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(213921);
        return;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ImeAlternativeWordGridScrollView.b paramb, ArrayList paramArrayList) {}
      
      public final void run()
      {
        AppMethodBeat.i(216439);
        RecyclerView.a locala = this.DtZ.DtY.getScrollContainerRv().getAdapter();
        Object localObject = locala;
        if (!(locala instanceof d)) {
          localObject = null;
        }
        localObject = (d)localObject;
        if (localObject != null)
        {
          f.a((f)localObject, this.DtZ.DtY.getScrollContainerRv(), (List)paramRecyclerView, null, true, 4);
          AppMethodBeat.o(216439);
          return;
        }
        AppMethodBeat.o(216439);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.alternative.ImeAlternativeWordGridScrollView
 * JD-Core Version:    0.7.0.1
 */