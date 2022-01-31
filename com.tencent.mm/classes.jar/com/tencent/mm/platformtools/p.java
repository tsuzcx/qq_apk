package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.y;

public final class p
  extends d
{
  public p(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(ag paramag)
  {
    y.d("MicroMsg.ErrorYesNoProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramag.content, 0).show();
    return true;
  }
  
  public final boolean c(ag paramag)
  {
    y.d("MicroMsg.ErrorYesNoProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramag.content, 0).show();
    return true;
  }
  
  public final boolean d(ag paramag)
  {
    y.d("MicroMsg.ErrorYesNoProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramag.content, 0).show();
    return true;
  }
  
  public final boolean e(ag paramag)
  {
    y.d("MicroMsg.ErrorYesNoProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramag.content, 0).show();
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.ErrorYesNoProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.p
 * JD-Core Version:    0.7.0.1
 */