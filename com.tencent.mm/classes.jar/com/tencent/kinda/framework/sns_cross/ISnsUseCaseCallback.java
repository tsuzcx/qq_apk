package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

public abstract interface ISnsUseCaseCallback
  extends UseCaseCallback
{
  public abstract void setData(Context paramContext, PayInfo paramPayInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.ISnsUseCaseCallback
 * JD-Core Version:    0.7.0.1
 */