package com.tencent.mm.plugin.luckymoney.story;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.a.a.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.protocal.protobuf.eno;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.i;

final class EnvelopeAppBarLayout$a$1
  implements a.a
{
  EnvelopeAppBarLayout$a$1(EnvelopeAppBarLayout.a parama, i parami, eno parameno) {}
  
  public final void eG(boolean paramBoolean)
  {
    AppMethodBeat.i(163592);
    if (!paramBoolean)
    {
      AppMethodBeat.o(163592);
      return;
    }
    String str = (String)this.EEG.RD(a.f.lucky_money_detail_story_item_loading_pb).getTag(a.f.lucky_money_envelope_url);
    if ((!Util.isNullOrNil(str)) && (str.equals(this.EEH.Uqm))) {
      this.EEG.RD(a.f.lucky_money_detail_story_item_loading_pb).setVisibility(8);
    }
    AppMethodBeat.o(163592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.a.1
 * JD-Core Version:    0.7.0.1
 */