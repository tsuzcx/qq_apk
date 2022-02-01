package com.tencent.kinda.framework.widget.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

class MMKViewLayout$1
  implements Runnable
{
  MMKViewLayout$1(MMKViewLayout paramMMKViewLayout) {}
  
  public void run()
  {
    AppMethodBeat.i(226628);
    int i = 0;
    while (i < this.this$0.childList.size())
    {
      ((MMKView)this.this$0.childList.get(i)).getView().setImportantForAccessibility(4);
      i += 1;
    }
    AppMethodBeat.o(226628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKViewLayout.1
 * JD-Core Version:    0.7.0.1
 */