package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URL;
import org.json.JSONObject;

final class CleanNewUI$4
  implements View.OnClickListener
{
  CleanNewUI$4(CleanNewUI paramCleanNewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22925);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.CleanNewUI", "qq mgr btn click");
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(714L, 3L, 1L, false);
    if (!CleanNewUI.d(this.qrp))
    {
      if (!CleanNewUI.e(this.qrp)) {
        break label158;
      }
      com.tencent.mm.ui.base.h.c(this.qrp, this.qrp.getString(2131757606, new Object[] { Util.getSizeMB(CleanNewUI.f(this.qrp)) }), "", this.qrp.getString(2131755785), this.qrp.getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(22924);
          try
          {
            Object localObject = new URL(CleanNewUI.g(CleanNewUI.4.this.qrp).getString("url"));
            String str = CleanNewUI.g(CleanNewUI.4.this.qrp).getString("md5");
            Log.i("MicroMsg.CleanNewUI", "download url:%s, md5:%s", new Object[] { localObject, str });
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.setClassName(CleanNewUI.4.this.qrp.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI");
            paramAnonymousDialogInterface.putExtra("task_name", "腾讯手机管家");
            paramAnonymousDialogInterface.putExtra("title", "腾讯手机管家");
            paramAnonymousDialogInterface.putExtra("task_url", ((URL)localObject).toString());
            paramAnonymousDialogInterface.putExtra("file_md5", str);
            paramAnonymousDialogInterface.putExtra("fileType", 1);
            paramAnonymousDialogInterface.putExtra("package_name", "com.tencent.qqpimsecure");
            localObject = CleanNewUI.4.this.qrp;
            paramAnonymousDialogInterface = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousDialogInterface);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousDialogInterface.axQ(), "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$4$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((CleanNewUI)localObject).startActivity((Intent)paramAnonymousDialogInterface.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$4$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(714L, 4L, 1L, false);
            AppMethodBeat.o(22924);
            return;
          }
          catch (Exception paramAnonymousDialogInterface)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.CleanNewUI", paramAnonymousDialogInterface, "", new Object[0]);
            }
          }
        }
      }, null);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/clean/ui/fileindexui/CleanNewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(22925);
      return;
      label158:
      paramView = new Intent();
      paramView.putExtra("rawUrl", CleanNewUI.bUk());
      paramView.putExtra("show_bottom", false);
      paramView.putExtra("showShare", false);
      c.b(this.qrp.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(714L, 5L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.4
 * JD-Core Version:    0.7.0.1
 */