package com.tencent.mm.openim.ui;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.openim.api.j;
import com.tencent.mm.openim.model.IOpenIMKefuConfirmController;
import com.tencent.mm.plugin.comm.c.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/ui/OpenIMKefuAutoConfirmImpl;", "Lcom/tencent/mm/openim/ui/OpenIMKefuConfirmBaseUIModel;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "onConfirm", "", "onConfirmOpSuccess", "onCreate", "confirmController", "Lcom/tencent/mm/openim/model/IOpenIMKefuConfirmController;", "showConfirmUI", "confirmType", "", "confirmPageType", "confirmData", "Lcom/tencent/mm/openim/api/OpenIMKefuGetContactResult;", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b
{
  public static final a.a ptV;
  
  static
  {
    AppMethodBeat.i(235905);
    ptV = new a.a((byte)0);
    AppMethodBeat.o(235905);
  }
  
  public a(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(235898);
    AppMethodBeat.o(235898);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(235900);
    s.u(parama, "this$0");
    parama.bSn();
    AppMethodBeat.o(235900);
  }
  
  public final void a(int paramInt1, int paramInt2, j paramj)
  {
    AppMethodBeat.i(235923);
    s.u(paramj, "confirmData");
    super.a(paramInt1, paramInt2, paramj);
    paramj = this.ptX;
    if (paramj != null) {
      paramj.xH(paramInt1);
    }
    AppMethodBeat.o(235923);
  }
  
  public final void a(IOpenIMKefuConfirmController paramIOpenIMKefuConfirmController)
  {
    AppMethodBeat.i(235916);
    s.u(paramIOpenIMKefuConfirmController, "confirmController");
    super.a(paramIOpenIMKefuConfirmController);
    if ((getContext() instanceof MMActivity))
    {
      paramIOpenIMKefuConfirmController = getContext();
      if (paramIOpenIMKefuConfirmController == null)
      {
        paramIOpenIMKefuConfirmController = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(235916);
        throw paramIOpenIMKefuConfirmController;
      }
      paramIOpenIMKefuConfirmController = ((MMActivity)paramIOpenIMKefuConfirmController).getController();
      Activity localActivity = getContext();
      s.checkNotNull(localActivity);
      paramIOpenIMKefuConfirmController.setStatusBarColor(bb.gy(localActivity.getResources().getColor(c.b.white), 0));
    }
    AppMethodBeat.o(235916);
  }
  
  public final void bSn()
  {
    AppMethodBeat.i(235933);
    h.ahAA.o(new a..ExternalSyntheticLambda0(this), 400L);
    AppMethodBeat.o(235933);
  }
  
  public final void bSs()
  {
    AppMethodBeat.i(235927);
    super.bSs();
    AppMethodBeat.o(235927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.openim.ui.a
 * JD-Core Version:    0.7.0.1
 */