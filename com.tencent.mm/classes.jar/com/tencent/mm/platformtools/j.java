package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  extends c
{
  public j(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(ae paramae)
  {
    AppMethodBeat.i(127694);
    Log.d("MicroMsg.ErrorClientProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramae.content, 0).show();
    AppMethodBeat.o(127694);
    return true;
  }
  
  public final boolean c(ae paramae)
  {
    AppMethodBeat.i(127695);
    Log.d("MicroMsg.ErrorClientProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramae.content, 0).show();
    AppMethodBeat.o(127695);
    return true;
  }
  
  public final boolean d(ae paramae)
  {
    AppMethodBeat.i(127696);
    Log.d("MicroMsg.ErrorClientProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramae.content, 0).show();
    AppMethodBeat.o(127696);
    return true;
  }
  
  public final boolean e(ae paramae)
  {
    AppMethodBeat.i(127697);
    Log.d("MicroMsg.ErrorClientProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramae.content, 0).show();
    AppMethodBeat.o(127697);
    return true;
  }
  
  public final boolean f(ae paramae)
  {
    AppMethodBeat.i(196836);
    Log.d("MicroMsg.ErrorClientProcessor", "handleDoneBack");
    Toast.makeText(this.activity, paramae.content, 0).show();
    this.activity.finish();
    AppMethodBeat.o(196836);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(127693);
    Log.i("MicroMsg.ErrorClientProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(127693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.platformtools.j
 * JD-Core Version:    0.7.0.1
 */