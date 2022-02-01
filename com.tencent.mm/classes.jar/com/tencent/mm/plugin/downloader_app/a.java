package com.tencent.mm.plugin.downloader_app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ak;
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
    paramContext.afN(2131761008);
    paramContext.afR(2131761006);
    paramContext.afU(2131761009);
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
    paramContext.afV(2131761005);
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
        if (!com.tencent.mm.compatible.d.b.cc(ak.getContext()))
        {
          paramAnonymousDialogInterface = new RequestFloatWindowPermissionDialog.a()
          {
            public final void a(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(195253);
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              AppMethodBeat.o(195253);
            }
            
            public final void b(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(195254);
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              AppMethodBeat.o(195254);
            }
            
            public final void c(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(195255);
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              AppMethodBeat.o(195255);
            }
          };
          RequestFloatWindowPermissionDialog.a(ak.getContext(), ak.getContext().getString(2131759453), paramAnonymousDialogInterface, true, com.tencent.mm.bq.a.abK());
        }
        AppMethodBeat.o(8762);
      }
    });
    paramContext.zf(true);
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
    paramContext.fQv().show();
    com.tencent.mm.plugin.downloader_app.b.a.a(15, 1501, 1, 1, paramString, "", "");
    AppMethodBeat.o(8767);
  }
  
  public final void b(Context paramContext, final String paramString, final DialogInterface.OnClickListener paramOnClickListener1, final DialogInterface.OnClickListener paramOnClickListener2, final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(8768);
    final PBool localPBool = new PBool();
    paramContext = new d.a(paramContext);
    paramContext.afN(2131761010);
    paramContext.afR(2131761011);
    paramContext.afU(2131761009);
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
    paramContext.afV(2131761007);
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
    paramContext.zf(true);
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
    paramContext.fQv().show();
    com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 1, paramString, "", "");
    AppMethodBeat.o(8768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a
 * JD-Core Version:    0.7.0.1
 */