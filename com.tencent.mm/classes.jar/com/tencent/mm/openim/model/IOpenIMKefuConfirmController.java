package com.tencent.mm.openim.model;

import android.content.Intent;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/model/IOpenIMKefuConfirmController;", "", "cancel", "", "confirm", "confirmType", "", "finishUI", "resultCode", "errCode", "data", "Landroid/content/Intent;", "finishWhenCancel", "", "finishWhenConfirmFailed", "getScene", "onCreate", "intent", "release", "setConfirmPageListener", "listener", "Lcom/tencent/mm/openim/ui/OpenIMKefuConfirmUIModel$ConfirmPageListener;", "start", "ConfirmResultReceiver", "OnGetConfirmInfoListener", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface IOpenIMKefuConfirmController
{
  public abstract void b(int paramInt, Intent paramIntent);
  
  public abstract boolean bSg();
  
  public abstract boolean bSh();
  
  public abstract void cancel();
  
  public abstract int getScene();
  
  public abstract void xH(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.openim.model.IOpenIMKefuConfirmController
 * JD-Core Version:    0.7.0.1
 */