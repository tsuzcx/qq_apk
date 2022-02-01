package com.tencent.mm.plugin.downloader_app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public final class a
  implements com.tencent.mm.plugin.downloader_app.api.b
{
  public final void a(Context paramContext, final String paramString, final DialogInterface.OnClickListener paramOnClickListener1, final DialogInterface.OnClickListener paramOnClickListener2, final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(8767);
    final PBool localPBool = new PBool();
    paramContext = new d.a(paramContext);
    paramContext.afe(2131761008);
    paramContext.afi(2131761006);
    paramContext.afl(2131761009);
    paramContext.c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(8761);
        if (paramOnClickListener1 != null) {
          paramOnClickListener1.onClick(paramAnonymousDialogInterface, paramAnonymousInt);
        }
        localPBool.value = true;
        com.tencent.mm.plugin.downloader_app.b.a.a(15, 1501, 1, 23, paramString, "", "");
        AppMethodBeat.o(8761);
      }
    });
    paramContext.afm(2131761005);
    paramContext.d(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(8762);
        if (paramOnClickListener2 != null) {
          paramOnClickListener2.onClick(paramAnonymousDialogInterface, paramAnonymousInt);
        }
        localPBool.value = true;
        com.tencent.mm.plugin.downloader_app.b.a.a(15, 1501, 1, 3, paramString, "", "");
        if (!com.tencent.mm.compatible.d.b.ca(aj.getContext()))
        {
          paramAnonymousDialogInterface = new RequestFloatWindowPermissionDialog.a()
          {
            public final void a(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(206774);
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              AppMethodBeat.o(206774);
            }
            
            public final void b(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(206775);
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              AppMethodBeat.o(206775);
            }
            
            public final void c(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(206776);
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              AppMethodBeat.o(206776);
            }
          };
          RequestFloatWindowPermissionDialog.a(aj.getContext(), aj.getContext().getString(2131759453), paramAnonymousDialogInterface, true, com.tencent.mm.br.a.abB());
        }
        AppMethodBeat.o(8762);
      }
    });
    paramContext.yR(true);
    paramContext.e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(8763);
        if (paramOnCancelListener != null) {
          paramOnCancelListener.onCancel(paramAnonymousDialogInterface);
        }
        if (!localPBool.value) {
          com.tencent.mm.plugin.downloader_app.b.a.a(15, 1501, 1, 2, paramString, "", "");
        }
        AppMethodBeat.o(8763);
      }
    });
    paramContext.fMb().show();
    com.tencent.mm.plugin.downloader_app.b.a.a(15, 1501, 1, 1, paramString, "", "");
    AppMethodBeat.o(8767);
  }
  
  public final void b(Context paramContext, final String paramString, final DialogInterface.OnClickListener paramOnClickListener1, final DialogInterface.OnClickListener paramOnClickListener2, final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(8768);
    final PBool localPBool = new PBool();
    paramContext = new d.a(paramContext);
    paramContext.afe(2131761010);
    paramContext.afi(2131761011);
    paramContext.afl(2131761009);
    paramContext.c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(8764);
        localPBool.value = true;
        if (paramOnClickListener1 != null) {
          paramOnClickListener1.onClick(paramAnonymousDialogInterface, paramAnonymousInt);
        }
        localPBool.value = true;
        com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 23, paramString, "", "");
        AppMethodBeat.o(8764);
      }
    });
    paramContext.afm(2131761007);
    paramContext.d(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(8765);
        if (paramOnClickListener2 != null) {
          paramOnClickListener2.onClick(paramAnonymousDialogInterface, paramAnonymousInt);
        }
        localPBool.value = true;
        com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 3, paramString, "", "");
        AppMethodBeat.o(8765);
      }
    });
    paramContext.yR(true);
    paramContext.e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(8766);
        if (paramOnCancelListener != null) {
          paramOnCancelListener.onCancel(paramAnonymousDialogInterface);
        }
        if (!localPBool.value) {
          com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 2, paramString, "", "");
        }
        AppMethodBeat.o(8766);
      }
    });
    paramContext.fMb().show();
    com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 1, paramString, "", "");
    AppMethodBeat.o(8768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a
 * JD-Core Version:    0.7.0.1
 */