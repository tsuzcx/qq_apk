package com.tencent.kinda.framework.widget.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

class MMKView$2
  implements Runnable
{
  MMKView$2(MMKView paramMMKView1, MMKView paramMMKView2, MMKView paramMMKView3) {}
  
  public void run()
  {
    AppMethodBeat.i(226605);
    int i;
    if ((this.val$selfView instanceof MMKRichLabelView))
    {
      if ((((MMKRichLabelView)this.val$selfView).linkCallback == null) && (MMKView.access$500(this.val$selfView) == null)) {
        break label126;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        MMKView.access$602(this.val$targetView, new WeakReference(this.val$selfView));
        this.val$targetView.setOnClickCallback(MMKView.access$500(this.val$targetView));
      }
      AppMethodBeat.o(226605);
      return;
      if ((this.val$selfView instanceof KindaSwitchViewImpl))
      {
        if (((KindaSwitchViewImpl)this.val$selfView).onChangeSwitchCallback != null) {
          i = 1;
        }
      }
      else if (MMKView.access$500(this.val$selfView) != null)
      {
        i = 1;
        continue;
      }
      label126:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKView.2
 * JD-Core Version:    0.7.0.1
 */