package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.plugin.game.d.z;
import com.tencent.mm.sdk.platformtools.y;

final class CreateOrJoinChatroomUI$1
  implements w.a
{
  CreateOrJoinChatroomUI$1(CreateOrJoinChatroomUI paramCreateOrJoinChatroomUI) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    paramb = (z)paramb.ecF.ecN;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if (paramInt1 == 4) {
        CreateOrJoinChatroomUI.a(this.kWY, paramb.jxl);
      }
      for (;;)
      {
        CreateOrJoinChatroomUI.a(this.kWY);
        this.kWY.finish();
        return 0;
        CreateOrJoinChatroomUI.a(this.kWY, -1);
      }
    }
    paramString = paramb.kTe;
    y.i("MicroMsg.CreateOrJoinChatroomUI", "Create Url: %s", new Object[] { paramString });
    CreateOrJoinChatroomUI.a(this.kWY);
    CreateOrJoinChatroomUI.a(this.kWY, paramString);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.CreateOrJoinChatroomUI.1
 * JD-Core Version:    0.7.0.1
 */