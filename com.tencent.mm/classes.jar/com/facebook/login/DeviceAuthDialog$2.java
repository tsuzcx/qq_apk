package com.facebook.login;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

class DeviceAuthDialog$2
  implements View.OnClickListener
{
  DeviceAuthDialog$2(DeviceAuthDialog paramDeviceAuthDialog) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(96712);
    this.this$0.onCancel();
    AppMethodBeat.o(96712);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.login.DeviceAuthDialog.2
 * JD-Core Version:    0.7.0.1
 */