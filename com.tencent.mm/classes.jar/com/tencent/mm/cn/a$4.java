package com.tencent.mm.cn;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$4
  implements View.OnClickListener
{
  a$4(ValueCallback paramValueCallback) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(151645);
    this.AZE.onReceiveValue("fileReaderMenuClicked");
    AppMethodBeat.o(151645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.cn.a.4
 * JD-Core Version:    0.7.0.1
 */