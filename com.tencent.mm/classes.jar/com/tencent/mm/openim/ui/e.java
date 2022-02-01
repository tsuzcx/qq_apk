package com.tencent.mm.openim.ui;

import com.tencent.mm.openim.api.j;
import com.tencent.mm.openim.model.IOpenIMKefuConfirmController;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/ui/OpenIMKefuConfirmUIModel;", "", "onConfirm", "", "onConfirmCancel", "onConfirmOpFailed", "onConfirmOpSuccess", "onCreate", "confirmController", "Lcom/tencent/mm/openim/model/IOpenIMKefuConfirmController;", "release", "showConfirmUI", "confirmType", "", "confirmPageType", "confirmData", "Lcom/tencent/mm/openim/api/OpenIMKefuGetContactResult;", "ConfirmPageListener", "OnConfirmDialogOpListener", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface e
{
  public abstract void a(int paramInt1, int paramInt2, j paramj);
  
  public abstract void a(IOpenIMKefuConfirmController paramIOpenIMKefuConfirmController);
  
  public abstract void bSn();
  
  public abstract void bSs();
  
  public abstract void bSu();
  
  public abstract void bSv();
  
  public abstract void release();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/ui/OpenIMKefuConfirmUIModel$OnConfirmDialogOpListener;", "", "onClose", "", "exitType", "", "onConfirmClick", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void bSw();
    
    public abstract void xL(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.openim.ui.e
 * JD-Core Version:    0.7.0.1
 */