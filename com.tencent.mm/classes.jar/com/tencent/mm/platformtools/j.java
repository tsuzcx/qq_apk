package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  extends c
{
  public j(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(aa paramaa)
  {
    AppMethodBeat.i(127704);
    Log.d("MicroMsg.ErrorLabelProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramaa.content, 0).show();
    AppMethodBeat.o(127704);
    return true;
  }
  
  public final boolean c(aa paramaa)
  {
    AppMethodBeat.i(127705);
    Log.d("MicroMsg.ErrorLabelProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramaa.content, 0).show();
    AppMethodBeat.o(127705);
    return true;
  }
  
  public final boolean d(aa paramaa)
  {
    AppMethodBeat.i(127706);
    Log.d("MicroMsg.ErrorLabelProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramaa.content, 0).show();
    AppMethodBeat.o(127706);
    return true;
  }
  
  public final boolean e(aa paramaa)
  {
    AppMethodBeat.i(127707);
    Log.d("MicroMsg.ErrorLabelProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramaa.content, 0).show();
    AppMethodBeat.o(127707);
    return true;
  }
  
  public final boolean f(aa paramaa)
  {
    AppMethodBeat.i(234051);
    Log.d("MicroMsg.ErrorLabelProcessor", "handleDoneBack");
    Toast.makeText(this.activity, paramaa.content, 0).show();
    this.activity.finish();
    AppMethodBeat.o(234051);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(127703);
    Log.i("MicroMsg.ErrorLabelProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(127703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.j
 * JD-Core Version:    0.7.0.1
 */