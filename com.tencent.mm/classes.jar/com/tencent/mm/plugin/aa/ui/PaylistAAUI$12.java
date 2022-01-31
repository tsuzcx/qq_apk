package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;

final class PaylistAAUI$12
  implements Runnable
{
  PaylistAAUI$12(PaylistAAUI paramPaylistAAUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(40877);
    int m = this.grF.getWindow().getDecorView().getHeight();
    Object localObject = new int[2];
    View localView = this.grF.findViewById(2131826652);
    localView.getLocationInWindow((int[])localObject);
    int n = localObject[1] + localView.getHeight();
    int j = a.fromDPToPix(this.grF.getContext(), 20);
    int k = m - n - a.fromDPToPix(this.grF.getContext(), 24) - a.fromDPToPix(this.grF.getContext(), 12);
    int i = k;
    if (k < j) {
      i = j;
    }
    ab.d("MicroMsg.PaylistAAUI", "height: %s, h1: %s, topMargin: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i) });
    localObject = (RelativeLayout.LayoutParams)PaylistAAUI.d(this.grF).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = i;
    PaylistAAUI.d(this.grF).setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(40877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.12
 * JD-Core Version:    0.7.0.1
 */