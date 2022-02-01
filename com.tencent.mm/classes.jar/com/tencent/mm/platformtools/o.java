package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.sdk.platformtools.ad;

public final class o
  extends c
{
  public o(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(ae paramae)
  {
    AppMethodBeat.i(127719);
    ad.d("MicroMsg.ErrorYesNoProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramae.content, 0).show();
    AppMethodBeat.o(127719);
    return true;
  }
  
  public final boolean c(ae paramae)
  {
    AppMethodBeat.i(127720);
    ad.d("MicroMsg.ErrorYesNoProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramae.content, 0).show();
    AppMethodBeat.o(127720);
    return true;
  }
  
  public final boolean d(ae paramae)
  {
    AppMethodBeat.i(127721);
    ad.d("MicroMsg.ErrorYesNoProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramae.content, 0).show();
    AppMethodBeat.o(127721);
    return true;
  }
  
  public final boolean e(ae paramae)
  {
    AppMethodBeat.i(127722);
    ad.d("MicroMsg.ErrorYesNoProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramae.content, 0).show();
    AppMethodBeat.o(127722);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(127718);
    ad.i("MicroMsg.ErrorYesNoProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(127718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.platformtools.o
 * JD-Core Version:    0.7.0.1
 */