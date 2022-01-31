package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.View;
import com.tencent.kinda.framework.animate.KindaAnimatorViewProxy;
import com.tencent.kinda.gen.KMoneyInputTextOnkeyBoardVisibleAnchorCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.a;

class MMMoneyInputText$3
  implements a
{
  MMMoneyInputText$3(MMMoneyInputText paramMMMoneyInputText, Context paramContext) {}
  
  public void onVisibleStateChange(boolean paramBoolean)
  {
    AppMethodBeat.i(145124);
    View localView = this.this$0.findParentScrollView(MMMoneyInputText.access$100(this.this$0));
    if (MMMoneyInputText.access$200(this.this$0) != null)
    {
      Object localObject = MMMoneyInputText.access$200(this.this$0).onkeyBoardVisibleAnchor();
      if (paramBoolean)
      {
        if ((localObject instanceof MMKView))
        {
          ((BaseFrActivity)this.val$context).scrollToFormEditPosAfterShowTenPay(localView, ((MMKView)localObject).getView(), 30);
          AppMethodBeat.o(145124);
          return;
        }
        localObject = KindaAnimatorViewProxy.unwrapProxyObject(localObject);
        if ((localObject instanceof MMKView)) {
          ((BaseFrActivity)this.val$context).scrollToFormEditPosAfterShowTenPay(localView, ((MMKView)localObject).getView(), 30);
        }
        AppMethodBeat.o(145124);
        return;
      }
      ((BaseFrActivity)this.val$context).scrollTo(localView, 0, 0);
    }
    AppMethodBeat.o(145124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMMoneyInputText.3
 * JD-Core Version:    0.7.0.1
 */