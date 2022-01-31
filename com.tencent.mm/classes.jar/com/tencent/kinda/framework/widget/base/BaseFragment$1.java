package com.tencent.kinda.framework.widget.base;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

class BaseFragment$1
  implements MenuItem.OnMenuItemClickListener
{
  BaseFragment$1(BaseFragment paramBaseFragment) {}
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(144646);
    this.this$0.popFragment();
    AppMethodBeat.o(144646);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseFragment.1
 * JD-Core Version:    0.7.0.1
 */