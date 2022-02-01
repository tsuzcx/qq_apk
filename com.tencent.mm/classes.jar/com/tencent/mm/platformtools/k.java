package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.sdk.platformtools.ac;

public final class k
  extends c
{
  public k(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(ad paramad)
  {
    AppMethodBeat.i(127699);
    ac.d("MicroMsg.ErrorConfirmProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramad.content, 0).show();
    AppMethodBeat.o(127699);
    return true;
  }
  
  public final boolean c(ad paramad)
  {
    AppMethodBeat.i(127700);
    ac.d("MicroMsg.ErrorConfirmProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramad.content, 0).show();
    AppMethodBeat.o(127700);
    return true;
  }
  
  public final boolean d(ad paramad)
  {
    AppMethodBeat.i(127701);
    ac.d("MicroMsg.ErrorConfirmProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramad.content, 0).show();
    AppMethodBeat.o(127701);
    return true;
  }
  
  public final boolean e(ad paramad)
  {
    AppMethodBeat.i(127702);
    ac.d("MicroMsg.ErrorConfirmProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramad.content, 0).show();
    AppMethodBeat.o(127702);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(127698);
    ac.i("MicroMsg.ErrorConfirmProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(127698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.platformtools.k
 * JD-Core Version:    0.7.0.1
 */