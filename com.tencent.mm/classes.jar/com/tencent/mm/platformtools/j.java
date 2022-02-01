package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.sdk.platformtools.ac;

public final class j
  extends c
{
  public j(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(ad paramad)
  {
    AppMethodBeat.i(127694);
    ac.d("MicroMsg.ErrorClientProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramad.content, 0).show();
    AppMethodBeat.o(127694);
    return true;
  }
  
  public final boolean c(ad paramad)
  {
    AppMethodBeat.i(127695);
    ac.d("MicroMsg.ErrorClientProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramad.content, 0).show();
    AppMethodBeat.o(127695);
    return true;
  }
  
  public final boolean d(ad paramad)
  {
    AppMethodBeat.i(127696);
    ac.d("MicroMsg.ErrorClientProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramad.content, 0).show();
    AppMethodBeat.o(127696);
    return true;
  }
  
  public final boolean e(ad paramad)
  {
    AppMethodBeat.i(127697);
    ac.d("MicroMsg.ErrorClientProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramad.content, 0).show();
    AppMethodBeat.o(127697);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(127693);
    ac.i("MicroMsg.ErrorClientProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(127693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.platformtools.j
 * JD-Core Version:    0.7.0.1
 */