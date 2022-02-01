package com.tencent.kinda.framework.widget.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

class MMKViewLayout$2
  implements Runnable
{
  MMKViewLayout$2(MMKViewLayout paramMMKViewLayout) {}
  
  public void run()
  {
    AppMethodBeat.i(226629);
    int i = 0;
    while (i < this.this$0.childList.size())
    {
      View localView = ((MMKView)this.this$0.childList.get(i)).getView();
      if (localView.getImportantForAccessibility() == 4) {
        localView.setImportantForAccessibility(0);
      }
      i += 1;
    }
    AppMethodBeat.o(226629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKViewLayout.2
 * JD-Core Version:    0.7.0.1
 */