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
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.plugin.hld.view.ImeGridScrollView;
import com.tencent.mm.plugin.hld.view.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.WxGridLayoutManager;
import com.tencent.wxhld.info.Candidate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridScrollView;", "Lcom/tencent/mm/plugin/hld/view/ImeGridScrollView;", "Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridViewHolder$IAlternativeWordViewListener;", "Lcom/tencent/mm/plugin/hld/candidate/ICandidateDataListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "alternativeWordList", "Ljava/util/ArrayList;", "Lcom/tencent/wxhld/info/Candidate;", "Lkotlin/collections/ArrayList;", "candidateListfetching", "", "hasMoreCandidate", "getAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "initView", "", "onClick", "text", "", "id", "", "order", "pressTime", "", "reset", "updateCandidateList", "addList", "type", "newList", "hasMore", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImeAlternativeWordGridScrollView
  extends ImeGridScrollView
  implements e.a, com.tencent.mm.plugin.hld.candidate.a
{
  public static final ImeAlternativeWordGridScrollView.a Jnu;
  private ArrayList<Candidate> Jnv;
  private boolean Jnw;
  private boolean Jnx;
  
  static
  {
    AppMethodBeat.i(311673);
    Jnu = new ImeAlternativeWordGridScrollView.a((byte)0);
    AppMethodBeat.o(311673);
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
    AppMethodBeat.i(311640);
    this.Jnv = new ArrayList();
    initView();
    AppMethodBeat.o(311640);
  }
  
  public final void a(String paramString, byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    AppMethodBeat.i(311710);
    s.u(paramString, "text");
    s.u(paramArrayOfByte, "id");
    l locall = l.JyV;
    l.jC("WxIme.ImeAlternativeWordGridScrollView", "onClick " + paramString + ' ' + paramInt);
    n.a(n.JvW, paramString, paramArrayOfByte, null, true, paramLong, false, 36);
    paramString = k.JvH;
    k.jr(2, paramInt);
    paramString = k.JvH;
    k.YA(700);
    AppMethodBeat.o(311710);
  }
  
  public final void a(ArrayList<Candidate> paramArrayList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    AppMethodBeat.i(311735);
    s.u(paramArrayList, "addList");
    Log.d("WxIme.ImeAlternativeWordGridScrollView", s.X("updateCandidates ", Integer.valueOf(paramArrayList.size())));
    Object localObject = new ArrayList((Collection)paramArrayList);
    if (paramInt == 1) {
      ((ArrayList)localObject).clear();
    }
    this.Jnw = false;
    paramArrayList = getScrollContainerRv().getAdapter();
    label108:
    RecyclerView localRecyclerView;
    if ((paramArrayList instanceof d))
    {
      paramArrayList = (d)paramArrayList;
      if (paramArrayList != null) {
        paramArrayList.qkB = null;
      }
      paramArrayList = getScrollContainerRv().getAdapter();
      if (!(paramArrayList instanceof d)) {
        break label165;
      }
      paramArrayList = (d)paramArrayList;
      if (paramArrayList != null)
      {
        paramArrayList = (e)paramArrayList;
        localRecyclerView = getScrollContainerRv();
        localObject = (List)localObject;
        if (paramBoolean1) {
          break label170;
        }
      }
    }
    label165:
    label170:
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      e.a(paramArrayList, localRecyclerView, (List)localObject, null, paramBoolean1, 4);
      this.Jnx = paramBoolean2;
      AppMethodBeat.o(311735);
      return;
      paramArrayList = null;
      break;
      paramArrayList = null;
      break label108;
    }
  }
  
  public final RecyclerView.a<RecyclerView.v> getAdapter()
  {
    AppMethodBeat.i(311698);
    Object localObject = getContext();
    s.s(localObject, "context");
    localObject = (RecyclerView.a)new d((Context)localObject, this.Jnv, (e.a)this);
    AppMethodBeat.o(311698);
    return localObject;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(311682);
    super.initView();
    getScrollContainerRv().a((RecyclerView.l)new b(this));
    AppMethodBeat.o(311682);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(311719);
    super.reset();
    this.Jnv.clear();
    AppMethodBeat.o(311719);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridScrollView$initView$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.l
  {
    b(ImeAlternativeWordGridScrollView paramImeAlternativeWordGridScrollView) {}
    
    private static final void a(ImeAlternativeWordGridScrollView paramImeAlternativeWordGridScrollView, ArrayList paramArrayList)
    {
      AppMethodBeat.i(311704);
      s.u(paramImeAlternativeWordGridScrollView, "this$0");
      s.u(paramArrayList, "$candidateList");
      Object localObject = paramImeAlternativeWordGridScrollView.getScrollContainerRv().getAdapter();
      if ((localObject instanceof d)) {}
      for (localObject = (d)localObject;; localObject = null)
      {
        if (localObject != null) {
          e.a((e)localObject, paramImeAlternativeWordGridScrollView.getScrollContainerRv(), (List)paramArrayList, null, true, 4);
        }
        AppMethodBeat.o(311704);
        return;
      }
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(311772);
      b localb = new b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridScrollView$initView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridScrollView$initView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(311772);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(311758);
      Object localObject = new b();
      ((b)localObject).cH(paramRecyclerView);
      ((b)localObject).sc(paramInt1);
      ((b)localObject).sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridScrollView$initView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((b)localObject).aYj());
      s.u(paramRecyclerView, "recyclerView");
      if (ImeAlternativeWordGridScrollView.a(this.Jny).isEmpty())
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridScrollView$initView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(311758);
        return;
      }
      paramInt1 = ImeAlternativeWordGridScrollView.a(this.Jny).size();
      paramRecyclerView = this.Jny.getScrollContainerRv().getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxGridLayoutManager");
        AppMethodBeat.o(311758);
        throw paramRecyclerView;
      }
      paramInt2 = ((WxGridLayoutManager)paramRecyclerView).Jw();
      if (ImeAlternativeWordGridScrollView.b(this.Jny))
      {
        if ((!ImeAlternativeWordGridScrollView.c(this.Jny)) && (paramInt1 - paramInt2 <= 20))
        {
          ImeAlternativeWordGridScrollView.d(this.Jny);
          paramRecyclerView = n.JvW;
          n.fMQ();
        }
        if ((ImeAlternativeWordGridScrollView.c(this.Jny)) && (paramInt2 == paramInt1 - 1))
        {
          paramRecyclerView = this.Jny.getScrollContainerRv().getAdapter();
          if (!(paramRecyclerView instanceof d)) {
            break label386;
          }
          paramRecyclerView = (d)paramRecyclerView;
          if (paramRecyclerView != null) {
            break label391;
          }
          paramRecyclerView = null;
          label225:
          if (paramRecyclerView == null)
          {
            localObject = new ProgressBar(this.Jny.getContext(), null, 0, a.k.smallCustomProgressBar);
            paramRecyclerView = new RelativeLayout.LayoutParams(com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.d.S5_alternative_footer_progress_size), com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), a.d.S5_alternative_footer_progress_size));
            paramRecyclerView.addRule(13);
            ((ProgressBar)localObject).setLayoutParams((ViewGroup.LayoutParams)paramRecyclerView);
            paramRecyclerView = this.Jny.getScrollContainerRv().getAdapter();
            if (!(paramRecyclerView instanceof d)) {
              break label399;
            }
          }
        }
      }
      label386:
      label391:
      label399:
      for (paramRecyclerView = (d)paramRecyclerView;; paramRecyclerView = null)
      {
        if (paramRecyclerView != null) {
          paramRecyclerView.qkB = ((View)localObject);
        }
        paramRecyclerView = new ArrayList((Collection)ImeAlternativeWordGridScrollView.a(this.Jny));
        this.Jny.getScrollContainerRv().post(new ImeAlternativeWordGridScrollView.b..ExternalSyntheticLambda0(this.Jny, paramRecyclerView));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/alternative/ImeAlternativeWordGridScrollView$initView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(311758);
        return;
        paramRecyclerView = null;
        break;
        paramRecyclerView = paramRecyclerView.qkB;
        break label225;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.alternative.ImeAlternativeWordGridScrollView
 * JD-Core Version:    0.7.0.1
 */