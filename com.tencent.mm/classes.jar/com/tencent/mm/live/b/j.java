package com.tencent.mm.live.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.model.u;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveDebugPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "editText", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends a
{
  private final EditText dzv;
  private final b nfT;
  
  public j(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247035);
    this.nfT = paramb;
    this.dzv = ((EditText)paramViewGroup.findViewById(b.e.room_edit));
    EditText localEditText = this.dzv;
    paramb = u.mZl;
    paramb = u.bie();
    if (paramb == null) {}
    for (paramb = null;; paramb = Long.valueOf(paramb.mMJ))
    {
      localEditText.setText((CharSequence)paramb.toString());
      ((Button)paramViewGroup.findViewById(b.e.live_enter_room)).setOnClickListener(new j..ExternalSyntheticLambda0(this, paramViewGroup));
      AppMethodBeat.o(247035);
      return;
    }
  }
  
  private static final void a(j paramj, ViewGroup paramViewGroup, View paramView)
  {
    AppMethodBeat.i(247046);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramViewGroup);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveDebugPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "this$0");
    s.u(paramViewGroup, "$root");
    paramView = paramj.dzv.getText();
    if (!Util.isNullOrNil((CharSequence)paramView))
    {
      localObject = u.mZl;
      localObject = u.bie();
      if (localObject != null) {
        ((dio)localObject).mMJ = Long.parseLong(paramView.toString());
      }
    }
    paramViewGroup.setVisibility(8);
    b.b.a(paramj.nfT, b.c.ncF);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveDebugPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247046);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.j
 * JD-Core Version:    0.7.0.1
 */