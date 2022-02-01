package com.tencent.mm.msgsubscription.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.plugin.comm.c.c;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/util/WxaSubscribeMsgSample;", "", "()V", "showSampleDialog", "", "context", "Landroid/content/Context;", "exampleTitle", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c pmT;
  
  static
  {
    AppMethodBeat.i(236310);
    pmT = new c();
    AppMethodBeat.o(236310);
  }
  
  public static void a(Context paramContext, String paramString, SubscribeMsgTmpItem paramSubscribeMsgTmpItem)
  {
    AppMethodBeat.i(236303);
    s.u(paramContext, "context");
    s.u(paramString, "exampleTitle");
    s.u(paramSubscribeMsgTmpItem, "item");
    b localb = b.pmS;
    paramSubscribeMsgTmpItem = b.a(paramContext, paramSubscribeMsgTmpItem.phS, paramContext.getResources().getDimensionPixelSize(c.c.SmallPadding));
    paramContext = k.a(paramContext, paramString, paramContext.getString(c.h.app_i_known), paramSubscribeMsgTmpItem, c..ExternalSyntheticLambda0.INSTANCE);
    paramContext.ayi(Color.parseColor("#07C160"));
    paramContext.setCancelable(false);
    paramContext.setCanceledOnTouchOutside(false);
    AppMethodBeat.o(236303);
  }
  
  private static final void c(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(236306);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(236306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.util.c
 * JD-Core Version:    0.7.0.1
 */