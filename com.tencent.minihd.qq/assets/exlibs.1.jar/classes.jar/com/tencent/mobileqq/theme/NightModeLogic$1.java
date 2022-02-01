package com.tencent.mobileqq.theme;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

class NightModeLogic$1
  implements View.OnClickListener
{
  NightModeLogic$1(NightModeLogic paramNightModeLogic) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.mCallback != null)
    {
      paramView = new Bundle();
      paramView.putInt("start_status", 2);
      this.this$0.mCallback.c(paramView);
    }
    if ((this.this$0.downloadDialog != null) && (this.this$0.downloadDialog.isShowing())) {
      this.this$0.downloadDialog.dismiss();
    }
    this.this$0.downloadDialog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.NightModeLogic.1
 * JD-Core Version:    0.7.0.1
 */