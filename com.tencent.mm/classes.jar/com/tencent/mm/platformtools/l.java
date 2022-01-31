package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.y;

public final class l
  extends d
{
  public l(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(ag paramag)
  {
    y.d("MicroMsg.ErrorConfirmProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramag.content, 0).show();
    return true;
  }
  
  public final boolean c(ag paramag)
  {
    y.d("MicroMsg.ErrorConfirmProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramag.content, 0).show();
    return true;
  }
  
  public final boolean d(ag paramag)
  {
    y.d("MicroMsg.ErrorConfirmProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramag.content, 0).show();
    return true;
  }
  
  public final boolean e(ag paramag)
  {
    y.d("MicroMsg.ErrorConfirmProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramag.content, 0).show();
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.ErrorConfirmProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.platformtools.l
 * JD-Core Version:    0.7.0.1
 */