package com.tencent.kinda.framework.widget.base;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

class FrLifeController$1
  implements FrLifeController.IFrLife
{
  FrLifeController$1(FrLifeController paramFrLifeController, BaseFragment paramBaseFragment) {}
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy()
  {
    AppMethodBeat.i(155334);
    BaseFragment localBaseFragment = FrLifeController.access$100(this.this$0, -1);
    if ((localBaseFragment != null) && (!localBaseFragment.isActive())) {
      localBaseFragment.willActive();
    }
    AppMethodBeat.o(155334);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(144664);
    BaseFragment localBaseFragment = this.this$0.getCurrent();
    if ((localBaseFragment != null) && (localBaseFragment.equals(this.val$frag)) && (this.val$frag.isActive())) {
      this.val$frag.willDeActive();
    }
    AppMethodBeat.o(144664);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(144663);
    FrLifeController.access$000(this.this$0);
    BaseFragment localBaseFragment = this.this$0.getCurrent();
    if ((localBaseFragment != null) && (localBaseFragment.equals(this.val$frag)))
    {
      if (!this.val$frag.isActive()) {
        this.val$frag.willActive();
      }
      localBaseFragment = FrLifeController.access$100(this.this$0, -2);
      if ((localBaseFragment != null) && (localBaseFragment.isActive())) {
        localBaseFragment.willDeActive();
      }
    }
    AppMethodBeat.o(144663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.FrLifeController.1
 * JD-Core Version:    0.7.0.1
 */