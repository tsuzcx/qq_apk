package com.tencent.kinda.framework.widget.base;

import android.widget.EditText;
import com.tencent.kinda.gen.KBankEditViewOnSeletBankCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ac;
import com.tencent.mm.g.a.ac.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

class KindaBankEditViewImpl$1
  extends c<ac>
{
  KindaBankEditViewImpl$1(KindaBankEditViewImpl paramKindaBankEditViewImpl)
  {
    AppMethodBeat.i(144715);
    this.__eventId = ac.class.getName().hashCode();
    AppMethodBeat.o(144715);
  }
  
  public boolean callback(ac paramac)
  {
    AppMethodBeat.i(144716);
    if ("flag_activity_close_KindaWrapBankEditActivity".equals(paramac.cni.cnj)) {
      KindaBankEditViewImpl.access$000(this.this$0).dead();
    }
    for (;;)
    {
      AppMethodBeat.o(144716);
      return false;
      ab.i(this.this$0.TAG, "BankEditSelected callback 获得银行名称：" + paramac.cni.cnj);
      KindaBankEditViewImpl.access$100(this.this$0).setText(paramac.cni.cnj);
      if (KindaBankEditViewImpl.access$200(this.this$0) != null) {
        KindaBankEditViewImpl.access$200(this.this$0).onSeletBank(paramac.cni.cnj);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaBankEditViewImpl.1
 * JD-Core Version:    0.7.0.1
 */