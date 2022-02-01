package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.kb;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;

final class LuckyMoneyNotHookReceiveUI$12
  implements i
{
  LuckyMoneyNotHookReceiveUI$12(LuckyMoneyNotHookReceiveUI paramLuckyMoneyNotHookReceiveUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(65738);
    if ((Util.isEqual(paramq.getType(), 697)) && ((paramq instanceof e)))
    {
      paramString = (e)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.cGq();
        if ((paramString != null) && (paramString.KOp != null) && (paramString.KOp.size() > 0) && (Util.isEqual(((ait)paramString.KOp.get(0)).Md5, LuckyMoneyNotHookReceiveUI.a(this.zgg).getMd5()))) {
          LuckyMoneyNotHookReceiveUI.a(this.zgg, false);
        }
      }
    }
    AppMethodBeat.o(65738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.12
 * JD-Core Version:    0.7.0.1
 */