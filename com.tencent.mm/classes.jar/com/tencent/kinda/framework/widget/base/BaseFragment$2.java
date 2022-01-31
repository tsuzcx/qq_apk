package com.tencent.kinda.framework.widget.base;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

class BaseFragment$2
  implements MenuItem.OnMenuItemClickListener
{
  BaseFragment$2(BaseFragment paramBaseFragment) {}
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(144647);
    this.this$0.popFragment();
    AppMethodBeat.o(144647);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseFragment.2
 * JD-Core Version:    0.7.0.1
 */