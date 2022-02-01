package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.protocal.protobuf.jr;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;

final class LuckyMoneyNotHookReceiveUI$16
  implements i
{
  LuckyMoneyNotHookReceiveUI$16(LuckyMoneyNotHookReceiveUI paramLuckyMoneyNotHookReceiveUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(276465);
    if ((Util.isEqual(paramq.getType(), 697)) && ((paramq instanceof e)))
    {
      paramString = (e)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.cUZ();
        if ((paramString != null) && (paramString.RPm != null) && (paramString.RPm.size() > 0) && (Util.isEqual(((aji)paramString.RPm.get(0)).Md5, LuckyMoneyNotHookReceiveUI.a(this.ELl).getMd5()))) {
          LuckyMoneyNotHookReceiveUI.a(this.ELl, false);
        }
      }
    }
    AppMethodBeat.o(276465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.16
 * JD-Core Version:    0.7.0.1
 */