package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;

public final class m
  extends c
{
  public m(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(ae paramae)
  {
    AppMethodBeat.i(127709);
    Log.d("MicroMsg.ErrorMsgBoxProcessor", "handleOpenUrl");
    h.a(this.activity, paramae.content, "", this.activity.getString(2131755874), null);
    AppMethodBeat.o(127709);
    return true;
  }
  
  public final boolean c(ae paramae)
  {
    AppMethodBeat.i(127710);
    Log.d("MicroMsg.ErrorMsgBoxProcessor", "handleIgnore");
    h.a(this.activity, paramae.content, "", this.activity.getString(2131755874), null);
    AppMethodBeat.o(127710);
    return true;
  }
  
  public final boolean d(ae paramae)
  {
    AppMethodBeat.i(127711);
    Log.d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseLast");
    h.a(this.activity, paramae.content, "", this.activity.getString(2131755874), null);
    AppMethodBeat.o(127711);
    return true;
  }
  
  public final boolean e(ae paramae)
  {
    AppMethodBeat.i(127712);
    Log.d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseCancel");
    h.a(this.activity, paramae.content, "", this.activity.getString(2131755874), null);
    AppMethodBeat.o(127712);
    return true;
  }
  
  public final boolean f(ae paramae)
  {
    AppMethodBeat.i(196842);
    Log.d("MicroMsg.ErrorMsgBoxProcessor", "handleDoneBack");
    final Activity localActivity = this.activity;
    h.a(this.activity, paramae.content, "", this.activity.getString(2131755874), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(196841);
        localActivity.finish();
        AppMethodBeat.o(196841);
      }
    });
    AppMethodBeat.o(196842);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(127708);
    Log.i("MicroMsg.ErrorMsgBoxProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(127708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.platformtools.m
 * JD-Core Version:    0.7.0.1
 */