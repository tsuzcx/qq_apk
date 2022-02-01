package com.tencent.mm.plugin.hld.alternative;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.plugin.hld.view.ImeVerticalScrollView;
import com.tencent.mm.view.recyclerview.k.a;
import com.tencent.wxhld.info.Syllable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativePyScrollView;", "Lcom/tencent/mm/plugin/hld/view/ImeVerticalScrollView;", "Lcom/tencent/mm/plugin/hld/alternative/ImeAlternativePyViewHolder$IAlternativePyViewListener;", "Lcom/tencent/mm/plugin/hld/alternative/ISyllableListDataListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mSyllables", "Ljava/util/ArrayList;", "Lcom/tencent/wxhld/info/Syllable;", "Lkotlin/collections/ArrayList;", "getAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getResourceId", "onClick", "", "v", "Landroid/view/View;", "onSyllableClick", "syllable", "pressTime", "", "reset", "updateSingleAllExchangeBt", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "single", "", "updateSyllableList", "syllables", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImeAlternativePyScrollView
  extends ImeVerticalScrollView
  implements a, c.a
{
  public static final ImeAlternativePyScrollView.a Jnn;
  private final ArrayList<Syllable> Jno;
  
  static
  {
    AppMethodBeat.i(311648);
    Jnn = new ImeAlternativePyScrollView.a((byte)0);
    AppMethodBeat.o(311648);
  }
  
  public ImeAlternativePyScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImeAlternativePyScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private ImeAlternativePyScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(311629);
    this.Jno = new ArrayList();
    initView();
    AppMethodBeat.o(311629);
  }
  
  private final void a(ImeKeyRelativeLayout paramImeKeyRelativeLayout, boolean paramBoolean)
  {
    AppMethodBeat.i(311638);
    Object localObject = k.JvH;
    k.YA(702);
    if (paramBoolean)
    {
      localObject = getResources().getString(a.j.key_single_word);
      s.s(localObject, "resources.getString(R.string.key_single_word)");
      ImeKeyRelativeLayout.a(paramImeKeyRelativeLayout, (String)localObject);
      localObject = getResources().getString(a.j.key_all_word);
      s.s(localObject, "resources.getString(R.string.key_all_word)");
      paramImeKeyRelativeLayout.aIE((String)localObject);
      paramImeKeyRelativeLayout.YO(10);
      AppMethodBeat.o(311638);
      return;
    }
    localObject = getResources().getString(a.j.key_all_word);
    s.s(localObject, "resources.getString(R.string.key_all_word)");
    ImeKeyRelativeLayout.a(paramImeKeyRelativeLayout, (String)localObject);
    localObject = getResources().getString(a.j.key_single_word);
    s.s(localObject, "resources.getString(R.string.key_single_word)");
    paramImeKeyRelativeLayout.aIE((String)localObject);
    paramImeKeyRelativeLayout.YO(11);
    AppMethodBeat.o(311638);
  }
  
  public final void a(Syllable paramSyllable, long paramLong)
  {
    AppMethodBeat.i(311689);
    Object localObject = l.JyV;
    l.jC("WxIme.ImeAlternativePyScrollView", s.X("onClick ", paramSyllable));
    if (paramSyllable != null)
    {
      localObject = getScrollContainerRv().getAdapter();
      if (localObject == null)
      {
        paramSyllable = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.hld.alternative.ImeAlternativePyAdapter");
        AppMethodBeat.o(311689);
        throw paramSyllable;
      }
      ((b)localObject).a(paramSyllable);
      localObject = n.JvW;
      n.b(paramSyllable, paramLong);
    }
    paramSyllable = k.JvH;
    k.YA(701);
    AppMethodBeat.o(311689);
  }
  
  public final void aQ(ArrayList<Syllable> paramArrayList)
  {
    AppMethodBeat.i(311702);
    s.u(paramArrayList, "syllables");
    this.Jno.clear();
    this.Jno.addAll((Collection)paramArrayList);
    paramArrayList = getScrollContainerRv().getAdapter();
    if (paramArrayList != null) {
      paramArrayList.bZE.notifyChanged();
    }
    AppMethodBeat.o(311702);
  }
  
  public final RecyclerView.a<RecyclerView.v> getAdapter()
  {
    AppMethodBeat.i(311660);
    RecyclerView.a locala = (RecyclerView.a)new b(this.Jno, (c.a)this);
    AppMethodBeat.o(311660);
    return locala;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(311665);
    Object localObject = getContext();
    s.s(localObject, "context");
    localObject = (RecyclerView.h)new k.a((Context)localObject).aGi(a.c.ime_divider_color).aGj(a.c.S6_pinyin_bg_color).aGh(a.d.ime_divider_size).jNn();
    AppMethodBeat.o(311665);
    return localObject;
  }
  
  public final int getResourceId()
  {
    return a.h.wxime_alternative_py_view;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(311715);
    super.onClick(paramView);
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      l locall = l.JyV;
      l.jC("WxIme.ImeAlternativePyScrollView", "onClick:" + ((ImeKeyRelativeLayout)paramView).getType() + ' ' + ((ImeKeyRelativeLayout)paramView).getText() + ' ' + ((ImeKeyRelativeLayout)paramView).getSecondText() + ' ' + ((ImeKeyRelativeLayout)paramView).getFunctionCode());
      if ((((ImeKeyRelativeLayout)paramView).getType() & 0x2) == 2) {
        switch (((ImeKeyRelativeLayout)paramView).getFunctionCode())
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(311715);
      return;
      a((ImeKeyRelativeLayout)paramView, false);
      AppMethodBeat.o(311715);
      return;
      a((ImeKeyRelativeLayout)paramView, true);
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(311676);
    super.reset();
    Object localObject = getScrollContainerRv().getAdapter();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.hld.alternative.ImeAlternativePyAdapter");
      AppMethodBeat.o(311676);
      throw ((Throwable)localObject);
    }
    ((b)localObject).a(null);
    localObject = getScrollContainerRv().getAdapter();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.hld.alternative.ImeAlternativePyAdapter");
      AppMethodBeat.o(311676);
      throw ((Throwable)localObject);
    }
    localObject = (b)localObject;
    ((b)localObject).Jnk = null;
    ((b)localObject).Jnm.clear();
    localObject = n.JvW;
    n.wY(false);
    localObject = findViewById(a.f.below_button_ikb);
    s.s(localObject, "findViewById<ImeKeyRelat…t>(R.id.below_button_ikb)");
    a((ImeKeyRelativeLayout)localObject, false);
    AppMethodBeat.o(311676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.alternative.ImeAlternativePyScrollView
 * JD-Core Version:    0.7.0.1
 */