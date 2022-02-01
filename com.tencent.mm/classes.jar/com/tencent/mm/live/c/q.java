package com.tencent.mm.live.c;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.g;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveDebugPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "editText", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType", "plugin-logic_release"})
public final class q
  extends a
{
  final b gzb;
  final EditText ty;
  
  public q(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190124);
    this.gzb = paramb;
    this.ty = ((EditText)paramViewGroup.findViewById(2131307945));
    EditText localEditText = this.ty;
    paramb = g.guG;
    paramb = g.akF();
    if (paramb != null) {}
    for (paramb = Long.valueOf(paramb.DMV);; paramb = null)
    {
      localEditText.setText((CharSequence)String.valueOf(paramb.longValue()));
      ((Button)paramViewGroup.findViewById(2131307622)).setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(190123);
          paramAnonymousView = this.gAG.ty;
          k.g(paramAnonymousView, "editText");
          paramAnonymousView = paramAnonymousView.getText();
          if (!bs.aj((CharSequence)paramAnonymousView))
          {
            Object localObject = g.guG;
            localObject = g.akF();
            if (localObject != null) {
              ((bqd)localObject).DMV = Long.parseLong(paramAnonymousView.toString());
            }
          }
          paramViewGroup.setVisibility(8);
          b.b.a(this.gAG.gzb, b.c.gyf);
          AppMethodBeat.o(190123);
        }
      });
      AppMethodBeat.o(190124);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.q
 * JD-Core Version:    0.7.0.1
 */