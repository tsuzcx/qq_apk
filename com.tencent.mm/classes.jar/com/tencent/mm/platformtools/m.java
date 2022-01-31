package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.y;

public final class m
  extends d
{
  public m(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(ag paramag)
  {
    y.d("MicroMsg.ErrorLabelProcessor", "handleOpenUrl");
    Toast.makeText(this.activity, paramag.content, 0).show();
    return true;
  }
  
  public final boolean c(ag paramag)
  {
    y.d("MicroMsg.ErrorLabelProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramag.content, 0).show();
    return true;
  }
  
  public final boolean d(ag paramag)
  {
    y.d("MicroMsg.ErrorLabelProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramag.content, 0).show();
    return true;
  }
  
  public final boolean e(ag paramag)
  {
    y.d("MicroMsg.ErrorLabelProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramag.content, 0).show();
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.ErrorLabelProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.m
 * JD-Core Version:    0.7.0.1
 */