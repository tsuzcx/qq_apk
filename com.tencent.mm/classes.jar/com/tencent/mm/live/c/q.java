package com.tencent.mm.live.c;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.g;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveDebugPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "editText", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType", "plugin-logic_release"})
public final class q
  extends a
{
  final b gSM;
  final EditText vr;
  
  public q(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(212412);
    this.gSM = paramb;
    this.vr = ((EditText)paramViewGroup.findViewById(2131307945));
    EditText localEditText = this.vr;
    paramb = g.gOr;
    paramb = g.ans();
    if (paramb != null) {}
    for (paramb = Long.valueOf(paramb.Fsa);; paramb = null)
    {
      localEditText.setText((CharSequence)String.valueOf(paramb.longValue()));
      ((Button)paramViewGroup.findViewById(2131307622)).setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(212411);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveDebugPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          paramAnonymousView = this.gUq.vr;
          p.g(paramAnonymousView, "editText");
          paramAnonymousView = paramAnonymousView.getText();
          if (!bt.ai((CharSequence)paramAnonymousView))
          {
            localObject = g.gOr;
            localObject = g.ans();
            if (localObject != null) {
              ((buq)localObject).Fsa = Long.parseLong(paramAnonymousView.toString());
            }
          }
          paramViewGroup.setVisibility(8);
          b.b.a(this.gUq.gSM, b.c.gRQ);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveDebugPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(212411);
        }
      });
      AppMethodBeat.o(212412);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.q
 * JD-Core Version:    0.7.0.1
 */