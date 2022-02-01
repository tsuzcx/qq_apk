package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends c
{
  public n(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(ae paramae)
  {
    AppMethodBeat.i(127714);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ErrorTextStripleProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramae.content, 0).show();
    AppMethodBeat.o(127714);
    return true;
  }
  
  public final boolean c(ae paramae)
  {
    AppMethodBeat.i(127715);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ErrorTextStripleProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramae.content, 0).show();
    AppMethodBeat.o(127715);
    return true;
  }
  
  public final boolean d(ae paramae)
  {
    AppMethodBeat.i(127716);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ErrorTextStripleProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramae.content, 0).show();
    AppMethodBeat.o(127716);
    return true;
  }
  
  public final boolean e(ae paramae)
  {
    AppMethodBeat.i(127717);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ErrorTextStripleProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramae.content, 0).show();
    AppMethodBeat.o(127717);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(127713);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ErrorTextStripleProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(127713);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.platformtools.n
 * JD-Core Version:    0.7.0.1
 */