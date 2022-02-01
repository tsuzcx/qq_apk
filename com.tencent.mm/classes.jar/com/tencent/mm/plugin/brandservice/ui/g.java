package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.sortview.a.a;
import com.tencent.mm.ui.base.sortview.a.b;

public final class g
  extends com.tencent.mm.ui.base.sortview.a
{
  private static a.b vCC;
  int Sc;
  long vCG;
  String vCH;
  String vEv;
  
  public g(long paramLong, int paramInt, String paramString)
  {
    super(2, null);
    this.vCG = paramLong;
    this.vCH = paramString;
    this.Sc = paramInt;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    this.vEv = "";
  }
  
  public final a.b dco()
  {
    AppMethodBeat.i(5757);
    if (vCC == null) {
      vCC = new a.b()
      {
        public final void a(Context paramAnonymousContext, a.a paramAnonymousa, com.tencent.mm.ui.base.sortview.a paramAnonymousVarArgs)
        {
          AppMethodBeat.i(5755);
          if ((paramAnonymousContext == null) || (paramAnonymousa == null) || (paramAnonymousVarArgs == null))
          {
            Log.e("MicroMsg.ReadMoreBtnDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            AppMethodBeat.o(5755);
            return;
          }
          if (!(paramAnonymousa instanceof g.a))
          {
            Log.e("MicroMsg.ReadMoreBtnDataItem", "The ViewHolder is not a instance of MoreBtnViewHolder.");
            AppMethodBeat.o(5755);
            return;
          }
          if (!(paramAnonymousVarArgs instanceof g))
          {
            Log.e("MicroMsg.ReadMoreBtnDataItem", "The DataItem is not a instance of MoreBtnDataItem.");
            AppMethodBeat.o(5755);
            return;
          }
          paramAnonymousContext = (g.a)paramAnonymousa;
          paramAnonymousa = (g)paramAnonymousVarArgs;
          paramAnonymousContext.ttU.setText(paramAnonymousa.vEv);
          AppMethodBeat.o(5755);
        }
        
        public final void a(View paramAnonymousView, a.a paramAnonymousa)
        {
          AppMethodBeat.i(5756);
          if ((paramAnonymousView != null) && (paramAnonymousa != null) && ((paramAnonymousa instanceof g.a))) {
            ((g.a)paramAnonymousa).ttU = ((TextView)paramAnonymousView.findViewById(d.e.tipsTV));
          }
          AppMethodBeat.o(5756);
        }
        
        public final boolean a(Context paramAnonymousContext, com.tencent.mm.ui.base.sortview.a paramAnonymousa, Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(5753);
          if ((paramAnonymousContext != null) && (paramAnonymousa != null)) {
            if ((paramAnonymousVarArgs == null) || (paramAnonymousVarArgs.length < 2) || (!(paramAnonymousVarArgs[1] instanceof Integer))) {
              break label178;
            }
          }
          label178:
          for (int i = ((Integer)paramAnonymousVarArgs[1]).intValue();; i = 0)
          {
            paramAnonymousa = (g)paramAnonymousa;
            paramAnonymousVarArgs = new Intent(paramAnonymousContext, BizSearchDetailPageUI.class);
            paramAnonymousVarArgs.putExtra("keyword", paramAnonymousa.vCH);
            paramAnonymousVarArgs.putExtra("businessType", paramAnonymousa.vCG);
            paramAnonymousVarArgs.putExtra("offset", paramAnonymousa.Sc);
            paramAnonymousVarArgs.putExtra("showEditText", true);
            paramAnonymousVarArgs.putExtra("fromScene", i);
            paramAnonymousa = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousVarArgs);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousContext, paramAnonymousa.aYi(), "com/tencent/mm/plugin/brandservice/ui/ReadMoreBtnDataItem$1", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/ui/base/sortview/BaseDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousContext.startActivity((Intent)paramAnonymousa.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousContext, "com/tencent/mm/plugin/brandservice/ui/ReadMoreBtnDataItem$1", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/ui/base/sortview/BaseDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(5753);
            return true;
          }
        }
        
        public final View c(Context paramAnonymousContext, View paramAnonymousView)
        {
          AppMethodBeat.i(5754);
          View localView = paramAnonymousView;
          if (paramAnonymousView == null) {
            localView = View.inflate(paramAnonymousContext, d.f.search_result_item_more, null);
          }
          AppMethodBeat.o(5754);
          return localView;
        }
      };
    }
    a.b localb = vCC;
    AppMethodBeat.o(5757);
    return localb;
  }
  
  public final a.a dcp()
  {
    AppMethodBeat.i(5758);
    a locala = new a();
    AppMethodBeat.o(5758);
    return locala;
  }
  
  public static final class a
    implements a.a
  {
    public TextView ttU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.g
 * JD-Core Version:    0.7.0.1
 */