package com.facebook.login;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.internal.Utility.PermissionsPair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Date;

class DeviceAuthDialog$6
  implements DialogInterface.OnClickListener
{
  DeviceAuthDialog$6(DeviceAuthDialog paramDeviceAuthDialog, String paramString1, Utility.PermissionsPair paramPermissionsPair, String paramString2, Date paramDate1, Date paramDate2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(96716);
    DeviceAuthDialog.access$900(this.this$0, this.val$userId, this.val$permissions, this.val$accessToken, this.val$expirationTime, this.val$dataAccessExpirationTime);
    AppMethodBeat.o(96716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.login.DeviceAuthDialog.6
 * JD-Core Version:    0.7.0.1
 */