package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.ix;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;

final class LuckyMoneyDetailUI$8
  implements g
{
  LuckyMoneyDetailUI$8(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(163722);
    if ((bt.iY(paramn.getType(), 697)) && ((paramn instanceof e)))
    {
      paramString = (e)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.bVk();
        if ((paramString != null) && (paramString.CEq != null) && (paramString.CEq.size() > 0) && (bt.kU(((act)paramString.CEq.get(0)).Md5, LuckyMoneyDetailUI.n(this.tme).JS()))) {
          LuckyMoneyDetailUI.a(this.tme, false);
        }
      }
    }
    AppMethodBeat.o(163722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.8
 * JD-Core Version:    0.7.0.1
 */