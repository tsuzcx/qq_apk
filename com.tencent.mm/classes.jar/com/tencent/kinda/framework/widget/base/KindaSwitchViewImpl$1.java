package com.tencent.kinda.framework.widget.base;

import com.tencent.kinda.gen.KSwitchViewOnChangeSwitchCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

class KindaSwitchViewImpl$1
  implements MMSwitchBtn.a
{
  KindaSwitchViewImpl$1(KindaSwitchViewImpl paramKindaSwitchViewImpl, KSwitchViewOnChangeSwitchCallback paramKSwitchViewOnChangeSwitchCallback) {}
  
  public void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(144817);
    this.val$callback.onChangeSwitch();
    AppMethodBeat.o(144817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaSwitchViewImpl.1
 * JD-Core Version:    0.7.0.1
 */