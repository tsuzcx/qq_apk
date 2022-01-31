package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.sortview.a.a;
import com.tencent.mm.ui.base.sortview.a.b;

final class d$1
  extends a.b
{
  d$1(d paramd) {}
  
  public final void a(Context paramContext, a.a parama, com.tencent.mm.ui.base.sortview.a paramVarArgs)
  {
    AppMethodBeat.i(13938);
    if ((paramContext == null) || (parama == null) || (paramVarArgs == null))
    {
      ab.e("MicroMsg.CatalogDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
      AppMethodBeat.o(13938);
      return;
    }
    if (!(parama instanceof d.a))
    {
      ab.e("MicroMsg.CatalogDataItem", "The ViewHolder is not a instance of CatalogViewHolder.");
      AppMethodBeat.o(13938);
      return;
    }
    if (!(paramVarArgs instanceof d))
    {
      ab.e("MicroMsg.CatalogDataItem", "The DataItem is not a instance of CatalogDataItem.");
      AppMethodBeat.o(13938);
      return;
    }
    paramContext = (d.a)parama;
    parama = (d)paramVarArgs;
    com.tencent.mm.plugin.brandservice.b.a.b(paramContext.jTb, parama.jTi);
    AppMethodBeat.o(13938);
  }
  
  public final void a(View paramView, a.a parama)
  {
    AppMethodBeat.i(13939);
    if ((paramView != null) && (parama != null) && ((parama instanceof d.a))) {
      ((d.a)parama).jTb = ((TextView)paramView.findViewById(2131821732));
    }
    AppMethodBeat.o(13939);
  }
  
  public final boolean a(Context paramContext, com.tencent.mm.ui.base.sortview.a parama, Object... paramVarArgs)
  {
    return true;
  }
  
  public final View c(Context paramContext, View paramView)
  {
    AppMethodBeat.i(13937);
    View localView = paramView;
    if (paramView == null) {
      localView = View.inflate(paramContext, 2130970631, null);
    }
    AppMethodBeat.o(13937);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.d.1
 * JD-Core Version:    0.7.0.1
 */