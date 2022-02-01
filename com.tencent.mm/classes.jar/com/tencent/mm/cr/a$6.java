package com.tencent.mm.cr;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class a$6
  implements View.OnClickListener
{
  a$6(ValueCallback paramValueCallback) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(223912);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/xwebutil/FileReaderLogic$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.lVA.onReceiveValue("fileReaderMenuClicked");
    a.a(this, "com/tencent/mm/xwebutil/FileReaderLogic$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(223912);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cr.a.6
 * JD-Core Version:    0.7.0.1
 */