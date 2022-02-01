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
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.view.ImeVerticalScrollView;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypesScrollView;", "Lcom/tencent/mm/plugin/hld/view/ImeVerticalScrollView;", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypesViewHolder$ISymbolTypesViewListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mISymbolTypeSelectListener", "Lcom/tencent/mm/plugin/hld/symbol/ISymbolTypeSelectListener;", "getAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getResourceId", "getScrollData", "", "Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypeData;", "()[Lcom/tencent/mm/plugin/hld/symbol/ImeSymbolTypeData;", "onClick", "", "typeName", "", "reset", "setISymbolTypeSelectListener", "listener", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImeSymbolTypesScrollView
  extends ImeVerticalScrollView
  implements h.a
{
  public static final ImeSymbolTypesScrollView.a Jxg;
  private a Jxh;
  
  static
  {
    AppMethodBeat.i(312162);
    Jxg = new ImeSymbolTypesScrollView.a((byte)0);
    AppMethodBeat.o(312162);
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
    AppMethodBeat.i(312132);
    initView();
    AppMethodBeat.o(312132);
  }
  
  private final f[] getScrollData()
  {
    AppMethodBeat.i(312150);
    Object localObject1 = l.JyV;
    int i;
    Object localObject2;
    if (l.fKH())
    {
      i = 4;
      localObject1 = new f[i];
      localObject2 = l.JyV;
      if (l.fKH()) {
        break label222;
      }
      i = 1;
      localObject2 = getContext().getString(a.j.ime_symbol_type_common);
      s.s(localObject2, "context.getString(R.string.ime_symbol_type_common)");
      localObject1[0] = new f((String)localObject2, "common");
    }
    for (;;)
    {
      int j = i + 1;
      localObject2 = getContext().getString(a.j.ime_symbol_type_emoji);
      s.s(localObject2, "context.getString(R.string.ime_symbol_type_emoji)");
      localObject1[i] = new f((String)localObject2, "emoji");
      i = j + 1;
      localObject2 = getContext().getString(a.j.ime_symbol_type_chinese);
      s.s(localObject2, "context.getString(R.stri….ime_symbol_type_chinese)");
      localObject1[j] = new f((String)localObject2, "chinese");
      localObject2 = getContext().getString(a.j.ime_symbol_type_english);
      s.s(localObject2, "context.getString(R.stri….ime_symbol_type_english)");
      localObject1[i] = new f((String)localObject2, "english");
      localObject2 = getContext().getString(a.j.ime_symbol_type_other);
      s.s(localObject2, "context.getString(R.string.ime_symbol_type_other)");
      localObject1[(i + 1)] = new f((String)localObject2, "other");
      AppMethodBeat.o(312150);
      return localObject1;
      i = 5;
      break;
      label222:
      i = 0;
    }
  }
  
  public final RecyclerView.a<RecyclerView.v> getAdapter()
  {
    AppMethodBeat.i(312187);
    RecyclerView.a locala = (RecyclerView.a)new g(getScrollData(), (h.a)this);
    AppMethodBeat.o(312187);
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
  
  public final void onClick(String paramString)
  {
    AppMethodBeat.i(312221);
    s.u(paramString, "typeName");
    Log.d("WxIme.ImeSymbolTypesScrollView", s.X("onClick ", paramString));
    Object localObject = getScrollContainerRv().getAdapter();
    if (localObject == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.hld.symbol.ImeSymbolTypesAdapter");
      AppMethodBeat.o(312221);
      throw paramString;
    }
    ((g)localObject).aIu(paramString);
    localObject = this.Jxh;
    if (localObject != null) {
      ((a)localObject).aIm(paramString);
    }
    AppMethodBeat.o(312221);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(312206);
    super.reset();
    Object localObject = getScrollContainerRv().getAdapter();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.hld.symbol.ImeSymbolTypesAdapter");
      AppMethodBeat.o(312206);
      throw ((Throwable)localObject);
    }
    localObject = (g)localObject;
    b localb = b.Jyf;
    ((g)localObject).aIu(b.fNN());
    AppMethodBeat.o(312206);
  }
  
  public final void setISymbolTypeSelectListener(a parama)
  {
    AppMethodBeat.i(312232);
    s.u(parama, "listener");
    this.Jxh = parama;
    AppMethodBeat.o(312232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.symbol.ImeSymbolTypesScrollView
 * JD-Core Version:    0.7.0.1
 */