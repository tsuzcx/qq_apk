package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class m
  extends d
{
  public m(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(ag paramag)
  {
    AppMethodBeat.i(124546);
    ab.d("MicroMsg.ErrorLabelProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramag.content, 0).show();
    AppMethodBeat.o(124546);
    return true;
  }
  
  public final boolean c(ag paramag)
  {
    AppMethodBeat.i(124547);
    ab.d("MicroMsg.ErrorLabelProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramag.content, 0).show();
    AppMethodBeat.o(124547);
    return true;
  }
  
  public final boolean d(ag paramag)
  {
    AppMethodBeat.i(124548);
    ab.d("MicroMsg.ErrorLabelProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramag.content, 0).show();
    AppMethodBeat.o(124548);
    return true;
  }
  
  public final boolean e(ag paramag)
  {
    AppMethodBeat.i(124549);
    ab.d("MicroMsg.ErrorLabelProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramag.content, 0).show();
    AppMethodBeat.o(124549);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(124545);
    ab.i("MicroMsg.ErrorLabelProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(124545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.m
 * JD-Core Version:    0.7.0.1
 */