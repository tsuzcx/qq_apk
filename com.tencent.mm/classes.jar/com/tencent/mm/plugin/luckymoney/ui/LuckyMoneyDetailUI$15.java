package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.protocal.protobuf.ia;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;

final class LuckyMoneyDetailUI$15
  implements f
{
  LuckyMoneyDetailUI$15(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(42664);
    if ((bo.hl(paramm.getType(), 697)) && ((paramm instanceof e)))
    {
      paramString = (e)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.blA();
        if ((paramString != null) && (paramString.wuz != null) && (paramString.wuz.size() > 0) && (bo.isEqual(((zg)paramString.wuz.get(0)).Md5, LuckyMoneyDetailUI.m(this.otz).Al()))) {
          LuckyMoneyDetailUI.a(this.otz, false);
        }
      }
    }
    AppMethodBeat.o(42664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.15
 * JD-Core Version:    0.7.0.1
 */