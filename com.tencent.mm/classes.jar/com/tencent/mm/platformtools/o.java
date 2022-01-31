package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;

public final class o
  extends d
{
  public o(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(ag paramag)
  {
    AppMethodBeat.i(124556);
    ab.d("MicroMsg.ErrorTextStripleProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramag.content, 0).show();
    AppMethodBeat.o(124556);
    return true;
  }
  
  public final boolean c(ag paramag)
  {
    AppMethodBeat.i(124557);
    ab.d("MicroMsg.ErrorTextStripleProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramag.content, 0).show();
    AppMethodBeat.o(124557);
    return true;
  }
  
  public final boolean d(ag paramag)
  {
    AppMethodBeat.i(124558);
    ab.d("MicroMsg.ErrorTextStripleProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramag.content, 0).show();
    AppMethodBeat.o(124558);
    return true;
  }
  
  public final boolean e(ag paramag)
  {
    AppMethodBeat.i(124559);
    ab.d("MicroMsg.ErrorTextStripleProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramag.content, 0).show();
    AppMethodBeat.o(124559);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(124555);
    ab.i("MicroMsg.ErrorTextStripleProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(124555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.o
 * JD-Core Version:    0.7.0.1
 */