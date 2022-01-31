package com.tencent.mm.cn;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$3
  implements View.OnClickListener
{
  a$3(ValueCallback paramValueCallback) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(151644);
    this.AZE.onReceiveValue("fileReaderClosed");
    AppMethodBeat.o(151644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.cn.a.3
 * JD-Core Version:    0.7.0.1
 */