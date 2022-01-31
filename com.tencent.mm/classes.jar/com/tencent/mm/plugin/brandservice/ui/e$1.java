package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.base.sortview.a.a;
import com.tencent.mm.ui.base.sortview.a.b;

final class e$1
  extends a.b
{
  e$1(e parame) {}
  
  public final void a(Context paramContext, a.a parama, a paramVarArgs)
  {
    AppMethodBeat.i(14017);
    if ((paramContext == null) || (parama == null) || (paramVarArgs == null))
    {
      ab.e("MicroMsg.ReadMoreBtnDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
      AppMethodBeat.o(14017);
      return;
    }
    if (!(parama instanceof e.a))
    {
      ab.e("MicroMsg.ReadMoreBtnDataItem", "The ViewHolder is not a instance of MoreBtnViewHolder.");
      AppMethodBeat.o(14017);
      return;
    }
    if (!(paramVarArgs instanceof e))
    {
      ab.e("MicroMsg.ReadMoreBtnDataItem", "The DataItem is not a instance of MoreBtnDataItem.");
      AppMethodBeat.o(14017);
      return;
    }
    paramContext = (e.a)parama;
    parama = (e)paramVarArgs;
    paramContext.ivt.setText(parama.jUF);
    AppMethodBeat.o(14017);
  }
  
  public final void a(View paramView, a.a parama)
  {
    AppMethodBeat.i(14018);
    if ((paramView != null) && (parama != null) && ((parama instanceof e.a))) {
      ((e.a)parama).ivt = ((TextView)paramView.findViewById(2131823748));
    }
    AppMethodBeat.o(14018);
  }
  
  public final boolean a(Context paramContext, a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(14015);
    if ((paramContext != null) && (parama != null))
    {
      int j = 0;
      int i = j;
      if (paramVarArgs != null)
      {
        i = j;
        if (paramVarArgs.length >= 2)
        {
          i = j;
          if ((paramVarArgs[1] instanceof Integer)) {
            i = ((Integer)paramVarArgs[1]).intValue();
          }
        }
      }
      parama = (e)parama;
      paramVarArgs = new Intent(paramContext, BizSearchDetailPageUI.class);
      paramVarArgs.putExtra("keyword", parama.jTm);
      paramVarArgs.putExtra("businessType", parama.jTl);
      paramVarArgs.putExtra("offset", parama.Fb);
      paramVarArgs.putExtra("showEditText", true);
      paramVarArgs.putExtra("fromScene", i);
      paramContext.startActivity(paramVarArgs);
    }
    AppMethodBeat.o(14015);
    return true;
  }
  
  public final View c(Context paramContext, View paramView)
  {
    AppMethodBeat.i(14016);
    View localView = paramView;
    if (paramView == null) {
      localView = View.inflate(paramContext, 2130970632, null);
    }
    AppMethodBeat.o(14016);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.e.1
 * JD-Core Version:    0.7.0.1
 */