package com.tencent.mm.live.c;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.f;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveDebugPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "editText", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType", "plugin-logic_release"})
public final class q
  extends a
{
  final b IIs;
  final EditText sz;
  
  public q(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(202911);
    this.IIs = paramb;
    this.sz = ((EditText)paramViewGroup.findViewById(2131307838));
    EditText localEditText = this.sz;
    paramb = f.rGw;
    paramb = f.eNG();
    if (paramb != null) {}
    for (paramb = Long.valueOf(paramb.LwA);; paramb = null)
    {
      localEditText.setText((CharSequence)String.valueOf(paramb.longValue()));
      ((Button)paramViewGroup.findViewById(2131307541)).setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(202910);
          paramAnonymousView = this.KuU.sz;
          k.g(paramAnonymousView, "editText");
          paramAnonymousView = paramAnonymousView.getText();
          if (!bt.ai((CharSequence)paramAnonymousView))
          {
            Object localObject = f.rGw;
            localObject = f.eNG();
            if (localObject != null) {
              ((eas)localObject).LwA = Long.parseLong(paramAnonymousView.toString());
            }
          }
          paramViewGroup.setVisibility(8);
          b.b.a(this.KuU.IIs, b.c.FBp);
          AppMethodBeat.o(202910);
        }
      });
      AppMethodBeat.o(202911);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.q
 * JD-Core Version:    0.7.0.1
 */