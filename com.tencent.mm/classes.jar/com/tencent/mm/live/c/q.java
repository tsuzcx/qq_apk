package com.tencent.mm.live.c;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.g;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveDebugPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "editText", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType", "plugin-logic_release"})
public final class q
  extends a
{
  final b gVv;
  final EditText vr;
  
  public q(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(216032);
    this.gVv = paramb;
    this.vr = ((EditText)paramViewGroup.findViewById(2131307945));
    EditText localEditText = this.vr;
    paramb = g.gQZ;
    paramb = g.anH();
    if (paramb != null) {}
    for (paramb = Long.valueOf(paramb.FKy);; paramb = null)
    {
      localEditText.setText((CharSequence)String.valueOf(paramb.longValue()));
      ((Button)paramViewGroup.findViewById(2131307622)).setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(216031);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveDebugPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = this.gWZ.vr;
          p.g(paramAnonymousView, "editText");
          paramAnonymousView = paramAnonymousView.getText();
          if (!bu.ah((CharSequence)paramAnonymousView))
          {
            localObject = g.gQZ;
            localObject = g.anH();
            if (localObject != null) {
              ((bvk)localObject).FKy = Long.parseLong(paramAnonymousView.toString());
            }
          }
          paramViewGroup.setVisibility(8);
          b.b.a(this.gWZ.gVv, b.c.gUy);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveDebugPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(216031);
        }
      });
      AppMethodBeat.o(216032);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.q
 * JD-Core Version:    0.7.0.1
 */