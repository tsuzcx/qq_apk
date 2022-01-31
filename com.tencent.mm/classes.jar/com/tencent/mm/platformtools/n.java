package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;

public final class n
  extends d
{
  public n(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(ag paramag)
  {
    AppMethodBeat.i(124551);
    ab.d("MicroMsg.ErrorMsgBoxProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramag.content, 0).show();
    AppMethodBeat.o(124551);
    return true;
  }
  
  public final boolean c(ag paramag)
  {
    AppMethodBeat.i(124552);
    ab.d("MicroMsg.ErrorMsgBoxProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramag.content, 0).show();
    AppMethodBeat.o(124552);
    return true;
  }
  
  public final boolean d(ag paramag)
  {
    AppMethodBeat.i(124553);
    ab.d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramag.content, 0).show();
    AppMethodBeat.o(124553);
    return true;
  }
  
  public final boolean e(ag paramag)
  {
    AppMethodBeat.i(124554);
    ab.d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramag.content, 0).show();
    AppMethodBeat.o(124554);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(124550);
    ab.i("MicroMsg.ErrorMsgBoxProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(124550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.n
 * JD-Core Version:    0.7.0.1
 */