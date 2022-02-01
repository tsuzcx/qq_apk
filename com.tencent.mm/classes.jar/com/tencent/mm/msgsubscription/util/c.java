package com.tencent.mm.msgsubscription.util;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.plugin.comm.c.c;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/util/WxaSubscribeMsgSample;", "", "()V", "showSampleDialog", "", "context", "Landroid/content/Context;", "exampleTitle", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "plugin-comm_release"})
public final class c
{
  public static final c mty;
  
  static
  {
    AppMethodBeat.i(199935);
    mty = new c();
    AppMethodBeat.o(199935);
  }
  
  public static void a(Context paramContext, String paramString, SubscribeMsgTmpItem paramSubscribeMsgTmpItem)
  {
    AppMethodBeat.i(199931);
    p.k(paramContext, "context");
    p.k(paramString, "exampleTitle");
    p.k(paramSubscribeMsgTmpItem, "item");
    b localb = b.mtx;
    paramSubscribeMsgTmpItem = b.a(paramContext, paramSubscribeMsgTmpItem.moe, paramContext.getResources().getDimensionPixelSize(c.c.SmallPadding));
    paramContext = h.a(paramContext, paramString, paramContext.getString(c.h.app_i_known), paramSubscribeMsgTmpItem, (DialogInterface.OnClickListener)c.a.mtz);
    paramContext.asd(Color.parseColor("#07C160"));
    paramContext.setCancelable(false);
    paramContext.setCanceledOnTouchOutside(false);
    AppMethodBeat.o(199931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.util.c
 * JD-Core Version:    0.7.0.1
 */