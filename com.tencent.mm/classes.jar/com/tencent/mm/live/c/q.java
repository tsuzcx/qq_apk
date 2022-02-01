package com.tencent.mm.live.c;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.x;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveDebugPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "editText", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType", "plugin-logic_release"})
public final class q
  extends a
{
  final b hOp;
  final EditText vy;
  
  public q(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(207990);
    this.hOp = paramb;
    this.vy = ((EditText)paramViewGroup.findViewById(2131307127));
    EditText localEditText = this.vy;
    paramb = x.hJf;
    paramb = x.aGr();
    if (paramb != null) {}
    for (paramb = Long.valueOf(paramb.hyH);; paramb = null)
    {
      localEditText.setText((CharSequence)String.valueOf(paramb.longValue()));
      ((Button)paramViewGroup.findViewById(2131303384)).setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(207989);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveDebugPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousView = this.hPU.vy;
          p.g(paramAnonymousView, "editText");
          paramAnonymousView = paramAnonymousView.getText();
          if (!Util.isNullOrNil((CharSequence)paramAnonymousView))
          {
            localObject = x.hJf;
            localObject = x.aGr();
            if (localObject != null) {
              ((civ)localObject).hyH = Long.parseLong(paramAnonymousView.toString());
            }
          }
          paramViewGroup.setVisibility(8);
          b.b.a(this.hPU.hOp, b.c.hLX);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveDebugPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(207989);
        }
      });
      AppMethodBeat.o(207990);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.q
 * JD-Core Version:    0.7.0.1
 */