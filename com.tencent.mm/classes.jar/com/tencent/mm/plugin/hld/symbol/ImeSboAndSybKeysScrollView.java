package com.tencent.mm.plugin.hld.symbol;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.k;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.plugin.hld.a.l;
import com.tencent.mm.plugin.hld.f.e;
import com.tencent.mm.plugin.hld.f.i;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.plugin.hld.view.ImeVerticalScrollView;
import com.tencent.mm.plugin.hld.view.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wxhld.info.Syllable;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysScrollView;", "Lcom/tencent/mm/plugin/hld/view/ImeVerticalScrollView;", "Lcom/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysViewHolder$ISboAndSybKeysViewListener;", "Landroid/view/View$OnTouchListener;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "Lcom/tencent/mm/plugin/hld/alternative/ISyllableListDataListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "hasSlide", "", "lastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/KeyOperation;", "mSyllables", "Ljava/util/ArrayList;", "Lcom/tencent/wxhld/info/Syllable;", "Lkotlin/collections/ArrayList;", "supportMoveCursor", "symbolList", "", "getAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getResourceId", "onClick", "", "data", "pressTime", "", "onFinishInflate", "onInterceptTouchEvent", "v", "Landroidx/recyclerview/widget/RecyclerView;", "event", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "p0", "onResume", "onTouch", "Landroid/view/View;", "onTouchEvent", "p1", "reset", "updateScrollData", "notify", "updateSyllableList", "syllables", "Companion", "plugin-hld_release"})
public final class ImeSboAndSybKeysScrollView
  extends ImeVerticalScrollView
  implements View.OnTouchListener, RecyclerView.k, com.tencent.mm.plugin.hld.alternative.a, c.a
{
  public static final a DFk;
  private boolean DFh;
  private final ArrayList<Object> DFi;
  private boolean DFj;
  private final ArrayList<Syllable> DtM;
  private com.tencent.mm.plugin.hld.keyboard.b DyL;
  
  static
  {
    AppMethodBeat.i(212641);
    DFk = new a((byte)0);
    AppMethodBeat.o(212641);
  }
  
  public ImeSboAndSybKeysScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImeSboAndSybKeysScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private ImeSboAndSybKeysScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(212638);
    this.DFi = new ArrayList();
    this.DtM = new ArrayList();
    if (paramContext == null) {
      p.iCn();
    }
    this.DFh = paramContext.obtainStyledAttributes(paramAttributeSet, a.l.ImeSboAndSybKeysScrollView, paramInt, 0).getBoolean(a.l.ImeSboAndSybKeysScrollView_imeKeySupportMoveCursor, false);
    initView();
    AppMethodBeat.o(212638);
  }
  
  private final ArrayList<Object> sU(boolean paramBoolean)
  {
    AppMethodBeat.i(212619);
    this.DFi.clear();
    RecyclerView.a locala = getScrollContainerRv().getAdapter();
    Object localObject = locala;
    if (!(locala instanceof b)) {
      localObject = null;
    }
    localObject = (b)localObject;
    if (localObject != null) {
      ((b)localObject).reset();
    }
    if (this.DtM.isEmpty())
    {
      localObject = com.tencent.mm.plugin.hld.model.g.DCm;
      if (com.tencent.mm.plugin.hld.model.g.b(com.tencent.mm.plugin.hld.keyboard.c.Dyo)) {
        j.a((Collection)this.DFi, new String[] { "+", "-", "*", "/", "%", ":", "(", ")", "=" });
      }
    }
    while (paramBoolean)
    {
      localObject = getScrollContainerRv().getAdapter();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.hld.symbol.ImeSboAndSybKeysAdapter");
        AppMethodBeat.o(212619);
        throw ((Throwable)localObject);
        localObject = com.tencent.mm.plugin.hld.model.g.DCm;
        if (com.tencent.mm.plugin.hld.model.g.b(com.tencent.mm.plugin.hld.keyboard.c.Dyl))
        {
          j.a((Collection)this.DFi, new String[] { "，", "。", "？", "！", "…", "：", "、", "~", "@" });
          continue;
          this.DFi.addAll((Collection)this.DtM);
        }
      }
      else
      {
        ((b)localObject).a(null);
        localObject = getScrollContainerRv().getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).notifyDataSetChanged();
        }
      }
    }
    localObject = this.DFi;
    AppMethodBeat.o(212619);
    return localObject;
  }
  
  public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(212628);
    p.k(paramRecyclerView, "v");
    p.k(paramMotionEvent, "event");
    int j = paramMotionEvent.getActionMasked();
    int i = (int)paramMotionEvent.getRawX();
    int k = (int)paramMotionEvent.getRawY();
    long l = System.currentTimeMillis();
    Log.d("WxIme.ImeSboAndSybKeysScrollView", "onInterceptTouchEvent action " + j + ' ' + i + ' ' + k + ' ' + l);
    switch (j)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212628);
      return false;
      this.DyL = new com.tencent.mm.plugin.hld.keyboard.b(i, k, l, null, null, 0L, 120);
      continue;
      paramMotionEvent = this.DyL;
      if (paramMotionEvent != null)
      {
        if (Math.abs(paramMotionEvent.y - k) > 50) {
          this.DFj = true;
        }
        if (!this.DFj)
        {
          j = Math.abs(paramMotionEvent.x - i);
          paramMotionEvent = com.tencent.mm.plugin.hld.f.k.DHH;
          if (j > com.tencent.mm.plugin.hld.f.k.eGQ())
          {
            paramMotionEvent = com.tencent.mm.plugin.hld.e.c.DxP;
            com.tencent.mm.plugin.hld.e.c.a((View)paramRecyclerView, this.DyL, i);
            AppMethodBeat.o(212628);
            return true;
            this.DFj = false;
            onClick((View)paramRecyclerView);
          }
        }
      }
    }
  }
  
  public final void aB(ArrayList<Syllable> paramArrayList)
  {
    AppMethodBeat.i(212616);
    p.k(paramArrayList, "syllables");
    this.DtM.clear();
    this.DtM.addAll((Collection)paramArrayList);
    sU(true);
    AppMethodBeat.o(212616);
  }
  
  public final void ao(boolean paramBoolean) {}
  
  public final void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(212631);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramRecyclerView);
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysScrollView", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.aFi());
    p.k(paramRecyclerView, "p0");
    p.k(paramMotionEvent, "p1");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysScrollView", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(212631);
  }
  
  public final RecyclerView.a<RecyclerView.v> getAdapter()
  {
    AppMethodBeat.i(212595);
    RecyclerView.a locala = (RecyclerView.a)new b(sU(false), (c.a)this);
    AppMethodBeat.o(212595);
    return locala;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(212599);
    Object localObject = getContext();
    p.j(localObject, "context");
    localObject = new i.a((Context)localObject);
    com.tencent.mm.plugin.hld.view.d locald = com.tencent.mm.plugin.hld.view.d.DHY;
    p.k(locald, "dividerType");
    ((i.a)localObject).DJs = locald;
    localObject = (RecyclerView.h)((i.a)localObject).US(a.c.line_color).UT(a.c.transparent).UR(a.d.ime_divider_size).eHI();
    AppMethodBeat.o(212599);
    return localObject;
  }
  
  public final int getResourceId()
  {
    AppMethodBeat.i(212591);
    e locale = e.DGW;
    if (e.eGo())
    {
      i = a.h.wxime_symbol_keys_view_selfdraw;
      AppMethodBeat.o(212591);
      return i;
    }
    int i = a.h.wxime_symbol_keys_view;
    AppMethodBeat.o(212591);
    return i;
  }
  
  public final void m(Object paramObject, long paramLong)
  {
    AppMethodBeat.i(212613);
    Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    com.tencent.mm.plugin.hld.f.l.it("WxIme.ImeSboAndSybKeysScrollView", "onClick ".concat(String.valueOf(paramObject)));
    int i;
    if ((paramObject instanceof String))
    {
      localObject = (com.tencent.mm.plugin.hld.a.d)h.ae(com.tencent.mm.plugin.hld.a.d.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.hld.a.d)localObject).eCD();
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.hld.a.b)localObject).eCr();
          if (localObject != null)
          {
            paramObject = new com.tencent.mm.plugin.hld.a.g((String)paramObject);
            paramObject.Dui = paramLong;
            ((com.tencent.mm.plugin.hld.a.c)localObject).b(paramObject);
          }
        }
      }
      paramObject = getKeyboardType();
      i = com.tencent.mm.plugin.hld.keyboard.c.Dyl.ordinal();
      if (paramObject != null) {
        break label219;
      }
      label120:
      i = com.tencent.mm.plugin.hld.keyboard.c.Dyo.ordinal();
      if (paramObject != null) {
        break label235;
      }
      label132:
      i = -1;
    }
    for (;;)
    {
      paramObject = com.tencent.mm.plugin.hld.model.k.DDb;
      com.tencent.mm.plugin.hld.model.k.hO(i, 1);
      AppMethodBeat.o(212613);
      return;
      if (!(paramObject instanceof Syllable)) {
        break;
      }
      localObject = getScrollContainerRv().getAdapter();
      if (localObject == null)
      {
        paramObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.hld.symbol.ImeSboAndSybKeysAdapter");
        AppMethodBeat.o(212613);
        throw paramObject;
      }
      ((b)localObject).a((Syllable)paramObject);
      localObject = n.DEn;
      n.b((Syllable)paramObject, paramLong);
      break;
      label219:
      if (paramObject.intValue() != i) {
        break label120;
      }
      i = 101;
      continue;
      label235:
      if (paramObject.intValue() != i) {
        break label132;
      }
      i = 401;
    }
  }
  
  public final void onFinishInflate()
  {
    AppMethodBeat.i(212603);
    super.onFinishInflate();
    if (this.DFh)
    {
      getScrollContainerRv().a((RecyclerView.k)this);
      localImeKeyRelativeLayout = (ImeKeyRelativeLayout)findViewById(a.f.below_button_ikb);
      if (localImeKeyRelativeLayout != null) {
        localImeKeyRelativeLayout.setOnTouchListener((View.OnTouchListener)this);
      }
    }
    ImeKeyRelativeLayout localImeKeyRelativeLayout = (ImeKeyRelativeLayout)findViewById(a.f.below_button_ikb);
    if (localImeKeyRelativeLayout != null)
    {
      localImeKeyRelativeLayout.setPadding(localImeKeyRelativeLayout.getKeyMarginLeft(), localImeKeyRelativeLayout.getKeyMarginTop(), localImeKeyRelativeLayout.getKeyMarginRight(), localImeKeyRelativeLayout.getKeyMarginBottom());
      AppMethodBeat.o(212603);
      return;
    }
    AppMethodBeat.o(212603);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(212606);
    super.onResume();
    Object localObject = com.tencent.mm.plugin.hld.model.g.DCm;
    if (com.tencent.mm.plugin.hld.model.g.b(com.tencent.mm.plugin.hld.keyboard.c.Dyl))
    {
      localObject = n.DEn;
      n.a((com.tencent.mm.plugin.hld.alternative.a)this);
    }
    sU(true);
    AppMethodBeat.o(212606);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(212623);
    Integer localInteger;
    Object localObject;
    label39:
    int i;
    label61:
    int j;
    long l;
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      if (paramMotionEvent == null) {
        break label152;
      }
      localInteger = Integer.valueOf(paramMotionEvent.getActionMasked());
      if (paramMotionEvent == null) {
        break label158;
      }
      localObject = Float.valueOf(paramMotionEvent.getRawX());
      i = (int)((Float)localObject).floatValue();
      if (paramMotionEvent == null) {
        break label167;
      }
      paramMotionEvent = Float.valueOf(paramMotionEvent.getRawY());
      j = (int)((Float)paramMotionEvent).floatValue();
      l = System.currentTimeMillis();
      Log.d("WxIme.ImeSboAndSybKeysScrollView", "onTouch action " + localInteger + ' ' + i + ' ' + j + ' ' + l);
      if (localInteger != null) {
        break label175;
      }
      label134:
      if (localInteger != null) {
        break label226;
      }
      label139:
      if (localInteger != null) {
        break label289;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(212623);
      return false;
      label152:
      localInteger = null;
      break;
      label158:
      localObject = Double.valueOf(0.0D);
      break label39;
      label167:
      paramMotionEvent = Double.valueOf(0.0D);
      break label61;
      label175:
      if (localInteger.intValue() != 0) {
        break label134;
      }
      paramMotionEvent = i.DHq;
      i.d((ImeKeyRelativeLayout)paramView);
      this.DyL = new com.tencent.mm.plugin.hld.keyboard.b(i, j, l, null, null, 0L, 120);
      ((ImeKeyRelativeLayout)paramView).setSelected(true);
      continue;
      label226:
      if (localInteger.intValue() != 2) {
        break label139;
      }
      paramMotionEvent = this.DyL;
      if (paramMotionEvent != null)
      {
        j = Math.abs(paramMotionEvent.x - i);
        paramMotionEvent = com.tencent.mm.plugin.hld.f.k.DHH;
        if (j > com.tencent.mm.plugin.hld.f.k.eGQ())
        {
          paramMotionEvent = com.tencent.mm.plugin.hld.e.c.DxP;
          com.tencent.mm.plugin.hld.e.c.a(null, paramView, this.DyL, i);
          AppMethodBeat.o(212623);
          return true;
          label289:
          if (localInteger.intValue() == 1)
          {
            ((ImeKeyRelativeLayout)paramView).setSelected(false);
            onClick(paramView);
          }
        }
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(212608);
    super.reset();
    Object localObject = n.DEn;
    n.b((com.tencent.mm.plugin.hld.alternative.a)this);
    localObject = getScrollContainerRv().getAdapter();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.hld.symbol.ImeSboAndSybKeysAdapter");
      AppMethodBeat.o(212608);
      throw ((Throwable)localObject);
    }
    ((b)localObject).reset();
    this.DFi.clear();
    this.DtM.clear();
    AppMethodBeat.o(212608);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysScrollView$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.symbol.ImeSboAndSybKeysScrollView
 * JD-Core Version:    0.7.0.1
 */