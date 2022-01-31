package com.tencent.kinda.framework.widget.base;

import android.widget.EditText;
import com.tencent.kinda.gen.KProfessionEditViewOnSelectProfessionCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.na;
import com.tencent.mm.g.a.na.a;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

class KindaProfessionEditViewImpl$1
  extends c<na>
{
  KindaProfessionEditViewImpl$1(KindaProfessionEditViewImpl paramKindaProfessionEditViewImpl)
  {
    AppMethodBeat.i(144779);
    this.__eventId = na.class.getName().hashCode();
    AppMethodBeat.o(144779);
  }
  
  public boolean callback(na paramna)
  {
    AppMethodBeat.i(144780);
    if ("flag_activity_close_WalletSelectProfessionUI".equals(paramna.cDg.cDh)) {
      KindaProfessionEditViewImpl.access$000(this.this$0).dead();
    }
    for (;;)
    {
      AppMethodBeat.o(144780);
      return false;
      ab.i("base_MMKView", "profession_name:" + paramna.cDg.cDh + " profession_type:" + paramna.cDg.cDi);
      KindaProfessionEditViewImpl.access$102(this.this$0, new Profession(paramna.cDg.cDh, paramna.cDg.cDi));
      KindaProfessionEditViewImpl.access$200(this.this$0).setText(KindaProfessionEditViewImpl.access$100(this.this$0).ues);
      if (this.this$0.callback != null) {
        this.this$0.callback.onSelectProfession(KindaProfessionEditViewImpl.access$100(this.this$0).ues, KindaProfessionEditViewImpl.access$100(this.this$0).uet);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaProfessionEditViewImpl.1
 * JD-Core Version:    0.7.0.1
 */