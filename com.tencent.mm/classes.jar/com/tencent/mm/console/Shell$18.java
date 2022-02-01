package com.tencent.mm.console;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;

final class Shell$18
  implements Shell.a
{
  @SuppressLint({"VisibleForTests"})
  public final void s(Intent paramIntent)
  {
    AppMethodBeat.i(231512);
    if ((!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()))
    {
      Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
      AppMethodBeat.o(231512);
      return;
    }
    paramIntent = paramIntent.getStringExtra("fetch_base_id");
    if (TextUtils.isEmpty(paramIntent))
    {
      Log.e("MicroMsg.Shell", "base id is empty, abort");
      Toast.makeText(MMApplicationContext.getContext(), "base id is empty, abort", 1).show();
      AppMethodBeat.o(231512);
      return;
    }
    Log.i("MicroMsg.Shell", "#RECOVERY_FETCH_PATCH, baseId = ".concat(String.valueOf(paramIntent)));
    WXRecoveryUploadService.fetchTinkerPatch(MMApplicationContext.getContext(), paramIntent);
    AppMethodBeat.o(231512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.Shell.18
 * JD-Core Version:    0.7.0.1
 */