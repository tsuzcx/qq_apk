package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;

public final class m
  extends c
{
  public m(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(ae paramae)
  {
    AppMethodBeat.i(127709);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ErrorMsgBoxProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramae.content, 0).show();
    AppMethodBeat.o(127709);
    return true;
  }
  
  public final boolean c(ae paramae)
  {
    AppMethodBeat.i(127710);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ErrorMsgBoxProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramae.content, 0).show();
    AppMethodBeat.o(127710);
    return true;
  }
  
  public final boolean d(ae paramae)
  {
    AppMethodBeat.i(127711);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramae.content, 0).show();
    AppMethodBeat.o(127711);
    return true;
  }
  
  public final boolean e(ae paramae)
  {
    AppMethodBeat.i(127712);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramae.content, 0).show();
    AppMethodBeat.o(127712);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(127708);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ErrorMsgBoxProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(127708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.platformtools.m
 * JD-Core Version:    0.7.0.1
 */