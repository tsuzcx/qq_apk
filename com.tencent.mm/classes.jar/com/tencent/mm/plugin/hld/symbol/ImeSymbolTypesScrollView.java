package com.tencent.mm.plugin.hld.symbol;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.a.m;
import com.tencent.mm.plugin.hld.f.b;
import com.tencent.mm.plugin.hld.view.ImeVerticalScrollView;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypesScrollView;", "Lcom/tencent/mm/plugin/hld/view/ImeVerticalScrollView;", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypesViewHolder$ISymbolTypesViewListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mISymbolTypeSelectListener", "Lcom/tencent/mm/plugin/hld/symbol/ISymbolTypeSelectListener;", "getAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getResourceId", "getScrollData", "", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypeData;", "()[Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypeData;", "onClick", "", "typeName", "", "reset", "setISymbolTypeSelectListener", "listener", "Companion", "plugin-hld_release"})
public final class ImeSymbolTypesScrollView
  extends ImeVerticalScrollView
  implements h.a
{
  public static final a DFA;
  private a DFz;
  
  static
  {
    AppMethodBeat.i(209337);
    DFA = new a((byte)0);
    AppMethodBeat.o(209337);
  }
  
  public ImeSymbolTypesScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImeSymbolTypesScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private ImeSymbolTypesScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(209336);
    initView();
    AppMethodBeat.o(209336);
  }
  
  private final f[] getScrollData()
  {
    AppMethodBeat.i(209334);
    Object localObject1 = com.tencent.mm.plugin.hld.f.l.DHK;
    int i;
    Object localObject2;
    if (com.tencent.mm.plugin.hld.f.l.eCE())
    {
      i = 4;
      localObject1 = new f[i];
      localObject2 = com.tencent.mm.plugin.hld.f.l.DHK;
      if (com.tencent.mm.plugin.hld.f.l.eCE()) {
        break label222;
      }
      i = 1;
      localObject2 = getContext().getString(a.j.ime_symbol_type_common);
      p.j(localObject2, "context.getString(R.string.ime_symbol_type_common)");
      localObject1[0] = new f((String)localObject2, "common");
    }
    for (;;)
    {
      int j = i + 1;
      localObject2 = getContext().getString(a.j.ime_symbol_type_emoji);
      p.j(localObject2, "context.getString(R.string.ime_symbol_type_emoji)");
      localObject1[i] = new f((String)localObject2, "emoji");
      i = j + 1;
      localObject2 = getContext().getString(a.j.ime_symbol_type_chinese);
      p.j(localObject2, "context.getString(R.stri….ime_symbol_type_chinese)");
      localObject1[j] = new f((String)localObject2, "chinese");
      localObject2 = getContext().getString(a.j.ime_symbol_type_english);
      p.j(localObject2, "context.getString(R.stri….ime_symbol_type_english)");
      localObject1[i] = new f((String)localObject2, "english");
      localObject2 = getContext().getString(a.j.ime_symbol_type_other);
      p.j(localObject2, "context.getString(R.string.ime_symbol_type_other)");
      localObject1[(i + 1)] = new f((String)localObject2, "other");
      AppMethodBeat.o(209334);
      return localObject1;
      i = 5;
      break;
      label222:
      i = 0;
    }
  }
  
  public final void azH(String paramString)
  {
    AppMethodBeat.i(209332);
    p.k(paramString, "typeName");
    Log.d("WxIme.ImeSymbolTypesScrollView", "onClick ".concat(String.valueOf(paramString)));
    Object localObject = getScrollContainerRv().getAdapter();
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.hld.symbol.ImeSymbolTypesAdapter");
      AppMethodBeat.o(209332);
      throw paramString;
    }
    ((g)localObject).aLC(paramString);
    localObject = this.DFz;
    if (localObject != null)
    {
      ((a)localObject).aLv(paramString);
      AppMethodBeat.o(209332);
      return;
    }
    AppMethodBeat.o(209332);
  }
  
  public final RecyclerView.a<RecyclerView.v> getAdapter()
  {
    AppMethodBeat.i(209329);
    RecyclerView.a locala = (RecyclerView.a)new g(getScrollData(), (h.a)this);
    AppMethodBeat.o(209329);
    return locala;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    return null;
  }
  
  public final int getResourceId()
  {
    return a.m.wxime_symbol_types_view;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(209331);
    super.reset();
    Object localObject = getScrollContainerRv().getAdapter();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.hld.symbol.ImeSymbolTypesAdapter");
      AppMethodBeat.o(209331);
      throw ((Throwable)localObject);
    }
    localObject = (g)localObject;
    b localb = b.DGL;
    ((g)localObject).aLC(b.eFU());
    AppMethodBeat.o(209331);
  }
  
  public final void setISymbolTypeSelectListener(a parama)
  {
    AppMethodBeat.i(209333);
    p.k(parama, "listener");
    this.DFz = parama;
    AppMethodBeat.o(209333);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypesScrollView$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.symbol.ImeSymbolTypesScrollView
 * JD-Core Version:    0.7.0.1
 */