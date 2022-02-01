package com.tencent.mm.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.NoRomSpaceDexUI;

final class MMApplicationWrapper$1
  implements k.b
{
  MMApplicationWrapper$1(MMApplicationWrapper paramMMApplicationWrapper, Context paramContext) {}
  
  public final boolean aCx()
  {
    AppMethodBeat.i(239102);
    if ((BuildInfo.IS_ARM64) && (!Build.CPU_ABI.equals("arm64-v8a")))
    {
      Object localObject1 = this.hgJ;
      Object localObject2 = new Intent(this.hgJ, NoRomSpaceDexUI.class).addFlags(268435456).putExtra("titleRes", 2131756385).putExtra("messageRes", 2131756384).putExtra("buttonRes", 2131756383).putExtra("action", PendingIntent.getActivity(this.hgJ, 0, new Intent("android.intent.action.VIEW", Uri.parse("http://" + WeChatHosts.domainString(2131763776) + "/")).addFlags(268435456), 0));
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/app/MMApplicationWrapper$1", "onFailure", "(Ljava/lang/String;Ljava/lang/UnsatisfiedLinkError;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/app/MMApplicationWrapper$1", "onFailure", "(Ljava/lang/String;Ljava/lang/UnsatisfiedLinkError;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localObject1 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/app/MMApplicationWrapper$1", "onFailure", "(Ljava/lang/String;Ljava/lang/UnsatisfiedLinkError;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/app/MMApplicationWrapper$1", "onFailure", "(Ljava/lang/String;Ljava/lang/UnsatisfiedLinkError;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      AppMethodBeat.o(239102);
      return true;
    }
    AppMethodBeat.o(239102);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.MMApplicationWrapper.1
 * JD-Core Version:    0.7.0.1
 */