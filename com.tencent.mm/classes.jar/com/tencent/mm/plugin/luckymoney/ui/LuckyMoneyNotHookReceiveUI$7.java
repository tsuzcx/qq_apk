package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;

final class LuckyMoneyNotHookReceiveUI$7
  implements g
{
  LuckyMoneyNotHookReceiveUI$7(LuckyMoneyNotHookReceiveUI paramLuckyMoneyNotHookReceiveUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65738);
    if ((bs.jl(paramn.getType(), 697)) && ((paramn instanceof e)))
    {
      paramString = (e)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramString.ccx();
        if ((paramString != null) && (paramString.DWQ != null) && (paramString.DWQ.size() > 0) && (bs.lr(((ads)paramString.DWQ.get(0)).Md5, LuckyMoneyNotHookReceiveUI.a(this.uwx).JC()))) {
          LuckyMoneyNotHookReceiveUI.a(this.uwx, false);
        }
      }
    }
    AppMethodBeat.o(65738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.7
 * JD-Core Version:    0.7.0.1
 */