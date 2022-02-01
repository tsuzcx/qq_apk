package com.tencent.mm.plugin.hld.symbol;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
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
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.f.i;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.plugin.hld.view.ImeVerticalScrollView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.k.a;
import com.tencent.wxhld.info.Syllable;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysScrollView;", "Lcom/tencent/mm/plugin/hld/view/ImeVerticalScrollView;", "Lcom/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysViewHolder$ISboAndSybKeysViewListener;", "Landroid/view/View$OnTouchListener;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "Lcom/tencent/mm/plugin/hld/alternative/ISyllableListDataListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "hasSlide", "", "lastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/KeyOperation;", "mSyllables", "Ljava/util/ArrayList;", "Lcom/tencent/wxhld/info/Syllable;", "Lkotlin/collections/ArrayList;", "supportMoveCursor", "symbolList", "", "getAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getResourceId", "onClick", "", "data", "pressTime", "", "onFinishInflate", "onInterceptTouchEvent", "v", "Landroidx/recyclerview/widget/RecyclerView;", "event", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "p0", "onResume", "onTouch", "Landroid/view/View;", "onTouchEvent", "p1", "reset", "updateScrollData", "notify", "updateSyllableList", "syllables", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImeSboAndSybKeysScrollView
  extends ImeVerticalScrollView
  implements View.OnTouchListener, RecyclerView.k, com.tencent.mm.plugin.hld.alternative.a, c.a
{
  public static final ImeSboAndSybKeysScrollView.a JwO;
  private final ArrayList<Syllable> Jno;
  private com.tencent.mm.plugin.hld.keyboard.b JrQ;
  private boolean JwP;
  private final ArrayList<Object> JwQ;
  private boolean JwR;
  
  static
  {
    AppMethodBeat.i(312185);
    JwO = new ImeSboAndSybKeysScrollView.a((byte)0);
    AppMethodBeat.o(312185);
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
    AppMethodBeat.i(312164);
    this.JwQ = new ArrayList();
    this.Jno = new ArrayList();
    s.checkNotNull(paramContext);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.l.ImeSboAndSybKeysScrollView, paramInt, 0);
    s.s(paramContext, "context!!.obtainStyledAt…ollView, defStyleAttr, 0)");
    this.JwP = paramContext.getBoolean(a.l.ImeSboAndSybKeysScrollView_imeKeySupportMoveCursor, false);
    initView();
    AppMethodBeat.o(312164);
  }
  
  private final ArrayList<Object> wZ(boolean paramBoolean)
  {
    AppMethodBeat.i(312179);
    this.JwQ.clear();
    Object localObject = getScrollContainerRv().getAdapter();
    if ((localObject instanceof b))
    {
      localObject = (b)localObject;
      if (localObject != null) {
        ((b)localObject).reset();
      }
      if (!this.Jno.isEmpty()) {
        break label247;
      }
      localObject = com.tencent.mm.plugin.hld.model.g.JuL;
      if (!com.tencent.mm.plugin.hld.model.g.b(com.tencent.mm.plugin.hld.keyboard.c.Jrs)) {
        break label165;
      }
      p.a((Collection)this.JwQ, new String[] { "+", "-", "*", "/", "%", ":", "(", ")", "=" });
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localObject = getScrollContainerRv().getAdapter();
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.hld.symbol.ImeSboAndSybKeysAdapter");
          AppMethodBeat.o(312179);
          throw ((Throwable)localObject);
          localObject = null;
          break;
          label165:
          localObject = com.tencent.mm.plugin.hld.model.g.JuL;
          if (!com.tencent.mm.plugin.hld.model.g.b(com.tencent.mm.plugin.hld.keyboard.c.Jrp)) {
            continue;
          }
          p.a((Collection)this.JwQ, new String[] { "，", "。", "？", "！", "…", "：", "、", "~", "@" });
          continue;
          label247:
          this.JwQ.addAll((Collection)this.Jno);
          continue;
        }
        ((b)localObject).a(null);
        localObject = getScrollContainerRv().getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).bZE.notifyChanged();
        }
      }
    }
    localObject = this.JwQ;
    AppMethodBeat.o(312179);
    return localObject;
  }
  
  public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(312265);
    s.u(paramRecyclerView, "v");
    s.u(paramMotionEvent, "event");
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
      AppMethodBeat.o(312265);
      return false;
      this.JrQ = new com.tencent.mm.plugin.hld.keyboard.b(i, k, l, null, null, 0L, 120);
      continue;
      paramMotionEvent = this.JrQ;
      if (paramMotionEvent != null)
      {
        if (Math.abs(paramMotionEvent.y - k) > 50) {
          this.JwR = true;
        }
        if (!this.JwR)
        {
          j = Math.abs(paramMotionEvent.x - i);
          paramMotionEvent = com.tencent.mm.plugin.hld.f.k.JyF;
          if (j > com.tencent.mm.plugin.hld.f.k.fOz())
          {
            paramMotionEvent = com.tencent.mm.plugin.hld.e.b.JqP;
            com.tencent.mm.plugin.hld.e.b.a((View)paramRecyclerView, this.JrQ, i);
            AppMethodBeat.o(312265);
            return true;
            this.JwR = false;
            onClick((View)paramRecyclerView);
          }
        }
      }
    }
  }
  
  public final void aQ(ArrayList<Syllable> paramArrayList)
  {
    AppMethodBeat.i(312243);
    s.u(paramArrayList, "syllables");
    this.Jno.clear();
    this.Jno.addAll((Collection)paramArrayList);
    wZ(true);
    AppMethodBeat.o(312243);
  }
  
  public final void aX(boolean paramBoolean) {}
  
  public final void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(312274);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRecyclerView);
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysScrollView", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.aYj());
    s.u(paramRecyclerView, "p0");
    s.u(paramMotionEvent, "p1");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/symbol/ImeSboAndSybKeysScrollView", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(312274);
  }
  
  public final RecyclerView.a<RecyclerView.v> getAdapter()
  {
    AppMethodBeat.i(312198);
    RecyclerView.a locala = (RecyclerView.a)new b(wZ(false), (c.a)this);
    AppMethodBeat.o(312198);
    return locala;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(312203);
    Object localObject = getContext();
    s.s(localObject, "context");
    localObject = (RecyclerView.h)new k.a((Context)localObject).a(com.tencent.mm.view.recyclerview.e.agNS).aGi(a.c.line_color).aGj(a.c.transparent).aGh(a.d.ime_divider_size).jNn();
    AppMethodBeat.o(312203);
    return localObject;
  }
  
  public final int getResourceId()
  {
    AppMethodBeat.i(312192);
    com.tencent.mm.plugin.hld.f.e locale = com.tencent.mm.plugin.hld.f.e.Jym;
    if (com.tencent.mm.plugin.hld.f.e.fOa())
    {
      i = a.h.wxime_symbol_keys_view_selfdraw;
      AppMethodBeat.o(312192);
      return i;
    }
    int i = a.h.wxime_symbol_keys_view;
    AppMethodBeat.o(312192);
    return i;
  }
  
  public final void onFinishInflate()
  {
    AppMethodBeat.i(312212);
    super.onFinishInflate();
    if (this.JwP)
    {
      getScrollContainerRv().a((RecyclerView.k)this);
      localImeKeyRelativeLayout = (ImeKeyRelativeLayout)findViewById(a.f.below_button_ikb);
      if (localImeKeyRelativeLayout != null) {
        localImeKeyRelativeLayout.setOnTouchListener((View.OnTouchListener)this);
      }
    }
    ImeKeyRelativeLayout localImeKeyRelativeLayout = (ImeKeyRelativeLayout)findViewById(a.f.below_button_ikb);
    if (localImeKeyRelativeLayout != null) {
      localImeKeyRelativeLayout.setPadding(localImeKeyRelativeLayout.getKeyMarginLeft(), localImeKeyRelativeLayout.getKeyMarginTop(), localImeKeyRelativeLayout.getKeyMarginRight(), localImeKeyRelativeLayout.getKeyMarginBottom());
    }
    AppMethodBeat.o(312212);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(312217);
    super.onResume();
    Object localObject = com.tencent.mm.plugin.hld.model.g.JuL;
    if (com.tencent.mm.plugin.hld.model.g.b(com.tencent.mm.plugin.hld.keyboard.c.Jrp))
    {
      localObject = n.JvW;
      n.a((com.tencent.mm.plugin.hld.alternative.a)this);
    }
    wZ(true);
    AppMethodBeat.o(312217);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(312253);
    Object localObject1;
    Object localObject2;
    label30:
    int i;
    label49:
    int j;
    long l;
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      if (paramMotionEvent != null) {
        break label140;
      }
      localObject1 = null;
      if (paramMotionEvent != null) {
        break label152;
      }
      localObject2 = Double.valueOf(0.0D);
      i = (int)((Float)localObject2).floatValue();
      if (paramMotionEvent != null) {
        break label164;
      }
      paramMotionEvent = Double.valueOf(0.0D);
      j = (int)((Float)paramMotionEvent).floatValue();
      l = System.currentTimeMillis();
      Log.d("WxIme.ImeSboAndSybKeysScrollView", "onTouch action " + localObject1 + ' ' + i + ' ' + j + ' ' + l);
      if (localObject1 != null) {
        break label175;
      }
      label122:
      if (localObject1 != null) {
        break label226;
      }
      label127:
      if (localObject1 != null) {
        break label289;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(312253);
      return false;
      label140:
      localObject1 = Integer.valueOf(paramMotionEvent.getActionMasked());
      break;
      label152:
      localObject2 = Float.valueOf(paramMotionEvent.getRawX());
      break label30;
      label164:
      paramMotionEvent = Float.valueOf(paramMotionEvent.getRawY());
      break label49;
      label175:
      if (((Integer)localObject1).intValue() != 0) {
        break label122;
      }
      paramMotionEvent = i.JyA;
      i.d((ImeKeyRelativeLayout)paramView);
      this.JrQ = new com.tencent.mm.plugin.hld.keyboard.b(i, j, l, null, null, 0L, 120);
      ((ImeKeyRelativeLayout)paramView).setSelected(true);
      continue;
      label226:
      if (((Integer)localObject1).intValue() != 2) {
        break label127;
      }
      paramMotionEvent = this.JrQ;
      if (paramMotionEvent != null)
      {
        j = Math.abs(paramMotionEvent.x - i);
        paramMotionEvent = com.tencent.mm.plugin.hld.f.k.JyF;
        if (j > com.tencent.mm.plugin.hld.f.k.fOz())
        {
          paramMotionEvent = com.tencent.mm.plugin.hld.e.b.JqP;
          com.tencent.mm.plugin.hld.e.b.a(null, paramView, this.JrQ, i);
          AppMethodBeat.o(312253);
          return true;
          label289:
          if (((Integer)localObject1).intValue() == 1)
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
    AppMethodBeat.i(312227);
    super.reset();
    Object localObject = n.JvW;
    n.b((com.tencent.mm.plugin.hld.alternative.a)this);
    localObject = getScrollContainerRv().getAdapter();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.hld.symbol.ImeSboAndSybKeysAdapter");
      AppMethodBeat.o(312227);
      throw ((Throwable)localObject);
    }
    ((b)localObject).reset();
    this.JwQ.clear();
    this.Jno.clear();
    AppMethodBeat.o(312227);
  }
  
  public final void v(Object paramObject, long paramLong)
  {
    AppMethodBeat.i(312237);
    Object localObject = l.JyV;
    l.jC("WxIme.ImeSboAndSybKeysScrollView", s.X("onClick ", paramObject));
    int i;
    if ((paramObject instanceof String))
    {
      localObject = (d)h.ax(d.class);
      if (localObject != null)
      {
        localObject = ((d)localObject).fKG();
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.hld.a.b)localObject).fKC();
          if (localObject != null)
          {
            paramObject = new com.tencent.mm.plugin.hld.a.g((String)paramObject);
            paramObject.JnG = paramLong;
            ah localah = ah.aiuX;
            ((com.tencent.mm.plugin.hld.a.c)localObject).b(paramObject);
          }
        }
      }
      paramObject = getKeyboardType();
      i = com.tencent.mm.plugin.hld.keyboard.c.Jrp.ordinal();
      if (paramObject != null) {
        break label220;
      }
      label122:
      i = com.tencent.mm.plugin.hld.keyboard.c.Jrs.ordinal();
      if (paramObject != null) {
        break label236;
      }
      label134:
      i = -1;
    }
    for (;;)
    {
      paramObject = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.YA(i);
      AppMethodBeat.o(312237);
      return;
      if (!(paramObject instanceof Syllable)) {
        break;
      }
      localObject = getScrollContainerRv().getAdapter();
      if (localObject == null)
      {
        paramObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.hld.symbol.ImeSboAndSybKeysAdapter");
        AppMethodBeat.o(312237);
        throw paramObject;
      }
      ((b)localObject).a((Syllable)paramObject);
      localObject = n.JvW;
      n.b((Syllable)paramObject, paramLong);
      break;
      label220:
      if (paramObject.intValue() != i) {
        break label122;
      }
      i = 101;
      continue;
      label236:
      if (paramObject.intValue() != i) {
        break label134;
      }
      i = 401;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.symbol.ImeSboAndSybKeysScrollView
 * JD-Core Version:    0.7.0.1
 */