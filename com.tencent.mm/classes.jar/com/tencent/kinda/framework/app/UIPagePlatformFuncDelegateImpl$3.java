package com.tencent.kinda.framework.app;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class UIPagePlatformFuncDelegateImpl$3
  implements MenuItem.OnMenuItemClickListener
{
  UIPagePlatformFuncDelegateImpl$3(UIPagePlatformFuncDelegateImpl paramUIPagePlatformFuncDelegateImpl) {}
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(144486);
    if (UIPagePlatformFuncDelegateImpl.access$100(this.this$0) != null)
    {
      UIPagePlatformFuncDelegateImpl.access$100(this.this$0).call();
      AppMethodBeat.o(144486);
      return true;
    }
    AppMethodBeat.o(144486);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.app.UIPagePlatformFuncDelegateImpl.3
 * JD-Core Version:    0.7.0.1
 */