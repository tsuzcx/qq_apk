package com.tencent.mm.plugin.fingerprint.ui;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class a$1
  extends g
{
  a$1(a parama, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    paramVarArgs = (String)paramVarArgs[0];
    a.a(this.klQ).putString("pwd", paramVarArgs);
    y.i("MicroMsg.FingerPrintAuthProcess", "this is onNext");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.a.1
 * JD-Core Version:    0.7.0.1
 */