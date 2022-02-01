package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.sdk.platformtools.ac;

public final class l
  extends c
{
  public l(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(ad paramad)
  {
    AppMethodBeat.i(127704);
    ac.d("MicroMsg.ErrorLabelProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramad.content, 0).show();
    AppMethodBeat.o(127704);
    return true;
  }
  
  public final boolean c(ad paramad)
  {
    AppMethodBeat.i(127705);
    ac.d("MicroMsg.ErrorLabelProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramad.content, 0).show();
    AppMethodBeat.o(127705);
    return true;
  }
  
  public final boolean d(ad paramad)
  {
    AppMethodBeat.i(127706);
    ac.d("MicroMsg.ErrorLabelProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramad.content, 0).show();
    AppMethodBeat.o(127706);
    return true;
  }
  
  public final boolean e(ad paramad)
  {
    AppMethodBeat.i(127707);
    ac.d("MicroMsg.ErrorLabelProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramad.content, 0).show();
    AppMethodBeat.o(127707);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(127703);
    ac.i("MicroMsg.ErrorLabelProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(127703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.platformtools.l
 * JD-Core Version:    0.7.0.1
 */