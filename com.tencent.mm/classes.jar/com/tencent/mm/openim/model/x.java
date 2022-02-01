package com.tencent.mm.openim.model;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.openim.api.h.b;
import com.tencent.mm.openim.ui.a;
import com.tencent.mm.openim.ui.c;
import com.tencent.mm.openim.ui.d;
import com.tencent.mm.openim.ui.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/model/OpenIMKefuConfirmUIModelFactory;", "", "()V", "createUIModel", "Lcom/tencent/mm/openim/ui/OpenIMKefuConfirmUIModel;", "context", "Landroid/app/Activity;", "confirmPageType", "", "confirmType", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
{
  public static final x psW;
  
  static
  {
    AppMethodBeat.i(235819);
    psW = new x();
    AppMethodBeat.o(235819);
  }
  
  public static final e a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235818);
    s.u(paramActivity, "context");
    if (!h.b.xE(paramInt2))
    {
      paramActivity = (e)new a(paramActivity);
      AppMethodBeat.o(235818);
      return paramActivity;
    }
    if (paramInt1 == 1)
    {
      paramActivity = (e)new c(paramActivity);
      AppMethodBeat.o(235818);
      return paramActivity;
    }
    if (paramInt1 == 2)
    {
      paramActivity = (e)new d(paramActivity);
      AppMethodBeat.o(235818);
      return paramActivity;
    }
    paramActivity = (e)new d(paramActivity);
    AppMethodBeat.o(235818);
    return paramActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.openim.model.x
 * JD-Core Version:    0.7.0.1
 */