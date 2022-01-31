package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m.a;
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.sdk.platformtools.ab;

final class FreeWifiCopyPwdUI$3
  implements m.a
{
  FreeWifiCopyPwdUI$3(FreeWifiCopyPwdUI paramFreeWifiCopyPwdUI) {}
  
  public final void g(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(20938);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramm instanceof a))
      {
        AppMethodBeat.o(20938);
        return;
      }
      paramString = ((a)paramm).bAW();
      if (paramString != null)
      {
        ab.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { paramString.woB, paramString.jKG, paramString.jJA, Integer.valueOf(paramString.wsQ), paramString.wsR, paramString.gwS, paramString.wsS });
        FreeWifiCopyPwdUI.a(this.mNe, new FreeWifiCopyPwdUI.b(this.mNe, FreeWifiCopyPwdUI.b(this.mNe), paramString));
        AppMethodBeat.o(20938);
        return;
      }
      ab.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo is null");
      paramString = this.mNe;
      paramm = this.mNe;
      paramInt1 = FreeWifiCopyPwdUI.c(this.mNe);
      localObject = new FreeWifiCopyPwdUI.a();
      ((FreeWifiCopyPwdUI.a)localObject).mNi = com.tencent.mm.plugin.freewifi.m.a(FreeWifiCopyPwdUI.d(this.mNe), k.b.mIS, 21);
      FreeWifiCopyPwdUI.a(paramString, new FreeWifiCopyPwdUI.b(paramm, paramInt1, localObject));
      AppMethodBeat.o(20938);
      return;
    }
    if ((com.tencent.mm.plugin.freewifi.m.eq(paramInt1, paramInt2)) && (!com.tencent.mm.plugin.freewifi.m.isEmpty(paramString)))
    {
      paramm = this.mNe;
      localObject = this.mNe;
      paramInt1 = FreeWifiCopyPwdUI.c(this.mNe);
      FreeWifiCopyPwdUI.a locala = new FreeWifiCopyPwdUI.a();
      locala.text = paramString;
      locala.mNi = com.tencent.mm.plugin.freewifi.m.a(FreeWifiCopyPwdUI.d(this.mNe), k.b.mIS, paramInt2);
      FreeWifiCopyPwdUI.a(paramm, new FreeWifiCopyPwdUI.b((FreeWifiCopyPwdUI)localObject, paramInt1, locala));
      AppMethodBeat.o(20938);
      return;
    }
    paramString = this.mNe;
    paramm = this.mNe;
    paramInt1 = FreeWifiCopyPwdUI.c(this.mNe);
    Object localObject = new FreeWifiCopyPwdUI.a();
    ((FreeWifiCopyPwdUI.a)localObject).mNi = com.tencent.mm.plugin.freewifi.m.a(FreeWifiCopyPwdUI.d(this.mNe), k.b.mIS, paramInt2);
    FreeWifiCopyPwdUI.a(paramString, new FreeWifiCopyPwdUI.b(paramm, paramInt1, localObject));
    AppMethodBeat.o(20938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI.3
 * JD-Core Version:    0.7.0.1
 */