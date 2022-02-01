package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.sdk.platformtools.ac;

public final class m
  extends c
{
  public m(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(ad paramad)
  {
    AppMethodBeat.i(127709);
    ac.d("MicroMsg.ErrorMsgBoxProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramad.content, 0).show();
    AppMethodBeat.o(127709);
    return true;
  }
  
  public final boolean c(ad paramad)
  {
    AppMethodBeat.i(127710);
    ac.d("MicroMsg.ErrorMsgBoxProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramad.content, 0).show();
    AppMethodBeat.o(127710);
    return true;
  }
  
  public final boolean d(ad paramad)
  {
    AppMethodBeat.i(127711);
    ac.d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramad.content, 0).show();
    AppMethodBeat.o(127711);
    return true;
  }
  
  public final boolean e(ad paramad)
  {
    AppMethodBeat.i(127712);
    ac.d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramad.content, 0).show();
    AppMethodBeat.o(127712);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(127708);
    ac.i("MicroMsg.ErrorMsgBoxProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(127708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.platformtools.m
 * JD-Core Version:    0.7.0.1
 */