package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  extends c
{
  public h(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(aa paramaa)
  {
    AppMethodBeat.i(127694);
    Log.d("MicroMsg.ErrorClientProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramaa.content, 0).show();
    AppMethodBeat.o(127694);
    return true;
  }
  
  public final boolean c(aa paramaa)
  {
    AppMethodBeat.i(127695);
    Log.d("MicroMsg.ErrorClientProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramaa.content, 0).show();
    AppMethodBeat.o(127695);
    return true;
  }
  
  public final boolean d(aa paramaa)
  {
    AppMethodBeat.i(127696);
    Log.d("MicroMsg.ErrorClientProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramaa.content, 0).show();
    AppMethodBeat.o(127696);
    return true;
  }
  
  public final boolean e(aa paramaa)
  {
    AppMethodBeat.i(127697);
    Log.d("MicroMsg.ErrorClientProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramaa.content, 0).show();
    AppMethodBeat.o(127697);
    return true;
  }
  
  public final boolean f(aa paramaa)
  {
    AppMethodBeat.i(234053);
    Log.d("MicroMsg.ErrorClientProcessor", "handleDoneBack");
    Toast.makeText(this.activity, paramaa.content, 0).show();
    this.activity.finish();
    AppMethodBeat.o(234053);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(127693);
    Log.i("MicroMsg.ErrorClientProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(127693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.h
 * JD-Core Version:    0.7.0.1
 */