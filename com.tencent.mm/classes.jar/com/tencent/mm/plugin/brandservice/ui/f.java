package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.sortview.a.a;
import com.tencent.mm.ui.base.sortview.a.b;

public final class f
  extends com.tencent.mm.ui.base.sortview.a
{
  private static a.b nXp;
  int fq;
  long nXt;
  String nXu;
  String nZi;
  
  public f(long paramLong, int paramInt, String paramString)
  {
    super(2, null);
    this.nXt = paramLong;
    this.nXu = paramString;
    this.fq = paramInt;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    this.nZi = "";
  }
  
  public final a.b bNP()
  {
    AppMethodBeat.i(5757);
    if (nXp == null) {
      nXp = new a.b()
      {
        public final void a(Context paramAnonymousContext, a.a paramAnonymousa, com.tencent.mm.ui.base.sortview.a paramAnonymousVarArgs)
        {
          AppMethodBeat.i(5755);
          if ((paramAnonymousContext == null) || (paramAnonymousa == null) || (paramAnonymousVarArgs == null))
          {
            ad.e("MicroMsg.ReadMoreBtnDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            AppMethodBeat.o(5755);
            return;
          }
          if (!(paramAnonymousa instanceof f.a))
          {
            ad.e("MicroMsg.ReadMoreBtnDataItem", "The ViewHolder is not a instance of MoreBtnViewHolder.");
            AppMethodBeat.o(5755);
            return;
          }
          if (!(paramAnonymousVarArgs instanceof f))
          {
            ad.e("MicroMsg.ReadMoreBtnDataItem", "The DataItem is not a instance of MoreBtnDataItem.");
            AppMethodBeat.o(5755);
            return;
          }
          paramAnonymousContext = (f.a)paramAnonymousa;
          paramAnonymousa = (f)paramAnonymousVarArgs;
          paramAnonymousContext.lZb.setText(paramAnonymousa.nZi);
          AppMethodBeat.o(5755);
        }
        
        public final void a(View paramAnonymousView, a.a paramAnonymousa)
        {
          AppMethodBeat.i(5756);
          if ((paramAnonymousView != null) && (paramAnonymousa != null) && ((paramAnonymousa instanceof f.a))) {
            ((f.a)paramAnonymousa).lZb = ((TextView)paramAnonymousView.findViewById(2131305885));
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
            paramAnonymousVarArgs.putExtra("keyword", paramAnonymousa.nXu);
            paramAnonymousVarArgs.putExtra("businessType", paramAnonymousa.nXt);
            paramAnonymousVarArgs.putExtra("offset", paramAnonymousa.fq);
            paramAnonymousVarArgs.putExtra("showEditText", true);
            paramAnonymousVarArgs.putExtra("fromScene", i);
            paramAnonymousa = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousVarArgs);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousContext, paramAnonymousa.ahp(), "com/tencent/mm/plugin/brandservice/ui/ReadMoreBtnDataItem$1", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/ui/base/sortview/BaseDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousContext.startActivity((Intent)paramAnonymousa.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousContext, "com/tencent/mm/plugin/brandservice/ui/ReadMoreBtnDataItem$1", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/ui/base/sortview/BaseDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(5753);
            return true;
          }
        }
        
        public final View c(Context paramAnonymousContext, View paramAnonymousView)
        {
          AppMethodBeat.i(5754);
          View localView = paramAnonymousView;
          if (paramAnonymousView == null) {
            localView = View.inflate(paramAnonymousContext, 2131495327, null);
          }
          AppMethodBeat.o(5754);
          return localView;
        }
      };
    }
    a.b localb = nXp;
    AppMethodBeat.o(5757);
    return localb;
  }
  
  public final a.a bNQ()
  {
    AppMethodBeat.i(5758);
    a locala = new a();
    AppMethodBeat.o(5758);
    return locala;
  }
  
  public static final class a
    implements a.a
  {
    public TextView lZb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.f
 * JD-Core Version:    0.7.0.1
 */