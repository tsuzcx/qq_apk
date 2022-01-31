package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;

public final class p
  extends d
{
  public p(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(ag paramag)
  {
    AppMethodBeat.i(124561);
    ab.d("MicroMsg.ErrorYesNoProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramag.content, 0).show();
    AppMethodBeat.o(124561);
    return true;
  }
  
  public final boolean c(ag paramag)
  {
    AppMethodBeat.i(124562);
    ab.d("MicroMsg.ErrorYesNoProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramag.content, 0).show();
    AppMethodBeat.o(124562);
    return true;
  }
  
  public final boolean d(ag paramag)
  {
    AppMethodBeat.i(124563);
    ab.d("MicroMsg.ErrorYesNoProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramag.content, 0).show();
    AppMethodBeat.o(124563);
    return true;
  }
  
  public final boolean e(ag paramag)
  {
    AppMethodBeat.i(124564);
    ab.d("MicroMsg.ErrorYesNoProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramag.content, 0).show();
    AppMethodBeat.o(124564);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(124560);
    ab.i("MicroMsg.ErrorYesNoProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(124560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.p
 * JD-Core Version:    0.7.0.1
 */