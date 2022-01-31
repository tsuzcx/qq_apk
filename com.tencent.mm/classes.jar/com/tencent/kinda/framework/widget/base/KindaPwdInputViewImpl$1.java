package com.tencent.kinda.framework.widget.base;

import com.tencent.kinda.gen.KPwdInputViewOnEndEnterPasswordCallback;
import com.tencent.kinda.gen.KPwdInputViewOnPasswordChangeCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cb;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;
import com.tenpay.android.wechat.TenpaySecureEditText;

class KindaPwdInputViewImpl$1
  implements EditHintPasswdView.a
{
  KindaPwdInputViewImpl$1(KindaPwdInputViewImpl paramKindaPwdInputViewImpl) {}
  
  public void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(144788);
    if (KindaPwdInputViewImpl.access$000(this.this$0).mEditText != null) {
      TenpaySecureEditText.setSalt(Long.toString(cb.abp() / 1000L));
    }
    if (paramBoolean)
    {
      KindaPwdInputViewImpl.access$000(this.this$0).getText();
      if (KindaPwdInputViewImpl.access$100(this.this$0) != null) {
        KindaPwdInputViewImpl.access$100(this.this$0).onEndEnterPassword(KindaPwdInputViewImpl.access$000(this.this$0).getText(), KindaPwdInputViewImpl.access$000(this.this$0).getMd5Value());
      }
      if (KindaPwdInputViewImpl.access$200(this.this$0) != null) {
        KindaPwdInputViewImpl.access$200(this.this$0).onPasswordChange(6, KindaPwdInputViewImpl.access$000(this.this$0).getText(), KindaPwdInputViewImpl.access$000(this.this$0).getMd5Value());
      }
      AppMethodBeat.o(144788);
      return;
    }
    if (KindaPwdInputViewImpl.access$200(this.this$0) != null) {
      KindaPwdInputViewImpl.access$200(this.this$0).onPasswordChange(0, KindaPwdInputViewImpl.access$000(this.this$0).getText(), KindaPwdInputViewImpl.access$000(this.this$0).getMd5Value());
    }
    AppMethodBeat.o(144788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaPwdInputViewImpl.1
 * JD-Core Version:    0.7.0.1
 */