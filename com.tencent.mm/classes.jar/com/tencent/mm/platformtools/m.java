package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends c
{
  public m(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(aa paramaa)
  {
    AppMethodBeat.i(127719);
    Log.d("MicroMsg.ErrorYesNoProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramaa.content, 0).show();
    AppMethodBeat.o(127719);
    return true;
  }
  
  public final boolean c(aa paramaa)
  {
    AppMethodBeat.i(127720);
    Log.d("MicroMsg.ErrorYesNoProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramaa.content, 0).show();
    AppMethodBeat.o(127720);
    return true;
  }
  
  public final boolean d(aa paramaa)
  {
    AppMethodBeat.i(127721);
    Log.d("MicroMsg.ErrorYesNoProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramaa.content, 0).show();
    AppMethodBeat.o(127721);
    return true;
  }
  
  public final boolean e(aa paramaa)
  {
    AppMethodBeat.i(127722);
    Log.d("MicroMsg.ErrorYesNoProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramaa.content, 0).show();
    AppMethodBeat.o(127722);
    return true;
  }
  
  public final boolean f(aa paramaa)
  {
    AppMethodBeat.i(234071);
    Log.d("MicroMsg.ErrorYesNoProcessor", "handleDoneBack");
    Toast.makeText(this.activity, paramaa.content, 0).show();
    this.activity.finish();
    AppMethodBeat.o(234071);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(127718);
    Log.i("MicroMsg.ErrorYesNoProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(127718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.m
 * JD-Core Version:    0.7.0.1
 */