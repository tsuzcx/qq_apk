package com.tencent.mm.plugin.luckymoney.ui;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.aa;
import com.tencent.mm.g.b.a.ab;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.s;

final class LuckyMoneyDetailUI$9
  implements q.a
{
  LuckyMoneyDetailUI$9(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    paramInt = 1;
    AppMethodBeat.i(42655);
    this.otz.hideVKB();
    LuckyMoneyDetailUI.a(this.otz, new aa());
    if (paramBoolean)
    {
      LuckyMoneyDetailUI.w(this.otz).cRI = 5L;
      LuckyMoneyDetailUI.a(this.otz, new ab());
      if ((LuckyMoneyDetailUI.x(this.otz) == 0) || (LuckyMoneyDetailUI.x(this.otz) == 2)) {
        if (b.y(LuckyMoneyDetailUI.y(this.otz)))
        {
          LuckyMoneyDetailUI.z(this.otz).cTZ = paramInt;
          LuckyMoneyDetailUI.z(this.otz).fx(LuckyMoneyDetailUI.y(this.otz).Al());
          if (!bo.isNullOrNil(paramString)) {
            break label286;
          }
          LuckyMoneyDetailUI.z(this.otz).cUb = 1L;
          label146:
          LuckyMoneyDetailUI.z(this.otz).ake();
          LuckyMoneyDetailUI.a(this.otz, LuckyMoneyDetailUI.A(this.otz), paramString, LuckyMoneyDetailUI.y(this.otz).Al());
          LuckyMoneyDetailUI.b(this.otz, 3);
          s.a(this.otz.getContext().getResources().getString(2131300637), this.otz.getContext());
          al.p(new LuckyMoneyDetailUI.9.1(this), 500L);
        }
      }
    }
    for (;;)
    {
      LuckyMoneyDetailUI.w(this.otz).ake();
      AppMethodBeat.o(42655);
      return;
      if (b.x(LuckyMoneyDetailUI.y(this.otz)))
      {
        paramInt = 3;
        break;
      }
      paramInt = 2;
      break;
      if (LuckyMoneyDetailUI.x(this.otz) == 1) {
        break;
      }
      paramInt = 0;
      break;
      label286:
      LuckyMoneyDetailUI.z(this.otz).cUb = 2L;
      break label146;
      LuckyMoneyDetailUI.w(this.otz).cRI = 6L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.9
 * JD-Core Version:    0.7.0.1
 */