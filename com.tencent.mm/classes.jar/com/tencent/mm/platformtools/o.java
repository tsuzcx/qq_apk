package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
  extends c
{
  public o(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(ad paramad)
  {
    AppMethodBeat.i(127719);
    Log.d("MicroMsg.ErrorYesNoProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramad.content, 0).show();
    AppMethodBeat.o(127719);
    return true;
  }
  
  public final boolean c(ad paramad)
  {
    AppMethodBeat.i(127720);
    Log.d("MicroMsg.ErrorYesNoProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramad.content, 0).show();
    AppMethodBeat.o(127720);
    return true;
  }
  
  public final boolean d(ad paramad)
  {
    AppMethodBeat.i(127721);
    Log.d("MicroMsg.ErrorYesNoProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramad.content, 0).show();
    AppMethodBeat.o(127721);
    return true;
  }
  
  public final boolean e(ad paramad)
  {
    AppMethodBeat.i(127722);
    Log.d("MicroMsg.ErrorYesNoProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramad.content, 0).show();
    AppMethodBeat.o(127722);
    return true;
  }
  
  public final boolean f(ad paramad)
  {
    AppMethodBeat.i(214341);
    Log.d("MicroMsg.ErrorYesNoProcessor", "handleDoneBack");
    Toast.makeText(this.activity, paramad.content, 0).show();
    this.activity.finish();
    AppMethodBeat.o(214341);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(127718);
    Log.i("MicroMsg.ErrorYesNoProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(127718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.platformtools.o
 * JD-Core Version:    0.7.0.1
 */