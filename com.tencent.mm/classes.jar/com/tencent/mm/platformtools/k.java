package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;

public final class k
  extends d
{
  public k(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(ag paramag)
  {
    AppMethodBeat.i(124536);
    ab.d("MicroMsg.ErrorClientProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramag.content, 0).show();
    AppMethodBeat.o(124536);
    return true;
  }
  
  public final boolean c(ag paramag)
  {
    AppMethodBeat.i(124537);
    ab.d("MicroMsg.ErrorClientProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramag.content, 0).show();
    AppMethodBeat.o(124537);
    return true;
  }
  
  public final boolean d(ag paramag)
  {
    AppMethodBeat.i(124538);
    ab.d("MicroMsg.ErrorClientProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramag.content, 0).show();
    AppMethodBeat.o(124538);
    return true;
  }
  
  public final boolean e(ag paramag)
  {
    AppMethodBeat.i(124539);
    ab.d("MicroMsg.ErrorClientProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramag.content, 0).show();
    AppMethodBeat.o(124539);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(124535);
    ab.i("MicroMsg.ErrorClientProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(124535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.platformtools.k
 * JD-Core Version:    0.7.0.1
 */