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

public final class f
  extends com.tencent.mm.ui.base.sortview.a
{
  private static a.b swV;
  long swZ;
  String sxa;
  String syO;
  int zP;
  
  public f(long paramLong, int paramInt, String paramString)
  {
    super(2, null);
    this.swZ = paramLong;
    this.sxa = paramString;
    this.zP = paramInt;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    this.syO = "";
  }
  
  public final a.b czw()
  {
    AppMethodBeat.i(5757);
    if (swV == null) {
      swV = new a.b()
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
          if (!(paramAnonymousa instanceof f.a))
          {
            Log.e("MicroMsg.ReadMoreBtnDataItem", "The ViewHolder is not a instance of MoreBtnViewHolder.");
            AppMethodBeat.o(5755);
            return;
          }
          if (!(paramAnonymousVarArgs instanceof f))
          {
            Log.e("MicroMsg.ReadMoreBtnDataItem", "The DataItem is not a instance of MoreBtnDataItem.");
            AppMethodBeat.o(5755);
            return;
          }
          paramAnonymousContext = (f.a)paramAnonymousa;
          paramAnonymousa = (f)paramAnonymousVarArgs;
          paramAnonymousContext.qpt.setText(paramAnonymousa.syO);
          AppMethodBeat.o(5755);
        }
        
        public final void a(View paramAnonymousView, a.a paramAnonymousa)
        {
          AppMethodBeat.i(5756);
          if ((paramAnonymousView != null) && (paramAnonymousa != null) && ((paramAnonymousa instanceof f.a))) {
            ((f.a)paramAnonymousa).qpt = ((TextView)paramAnonymousView.findViewById(d.e.dXu));
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
            paramAnonymousa = (f)paramAnonymousa;
            paramAnonymousVarArgs = new Intent(paramAnonymousContext, BizSearchDetailPageUI.class);
            paramAnonymousVarArgs.putExtra("keyword", paramAnonymousa.sxa);
            paramAnonymousVarArgs.putExtra("businessType", paramAnonymousa.swZ);
            paramAnonymousVarArgs.putExtra("offset", paramAnonymousa.zP);
            paramAnonymousVarArgs.putExtra("showEditText", true);
            paramAnonymousVarArgs.putExtra("fromScene", i);
            paramAnonymousa = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousVarArgs);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousContext, paramAnonymousa.aFh(), "com/tencent/mm/plugin/brandservice/ui/ReadMoreBtnDataItem$1", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/ui/base/sortview/BaseDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousContext.startActivity((Intent)paramAnonymousa.sf(0));
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
            localView = View.inflate(paramAnonymousContext, d.f.suy, null);
          }
          AppMethodBeat.o(5754);
          return localView;
        }
      };
    }
    a.b localb = swV;
    AppMethodBeat.o(5757);
    return localb;
  }
  
  public final a.a czx()
  {
    AppMethodBeat.i(5758);
    a locala = new a();
    AppMethodBeat.o(5758);
    return locala;
  }
  
  public static final class a
    implements a.a
  {
    public TextView qpt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.f
 * JD-Core Version:    0.7.0.1
 */