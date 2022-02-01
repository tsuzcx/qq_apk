package com.tencent.mm.plugin.downloader_app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.e;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.g.a;

public final class a
  implements com.tencent.mm.plugin.downloader_app.api.b
{
  public final void a(Context paramContext, final com.tencent.mm.plugin.downloader_app.api.b.a parama1, final com.tencent.mm.plugin.downloader_app.api.b.a parama2)
  {
    AppMethodBeat.i(240196);
    final com.tencent.mm.ui.widget.a.g localg = new com.tencent.mm.ui.widget.a.g(paramContext, 1, 0, false);
    localg.b(paramContext.getString(2131758368), paramContext.getString(2131758369));
    localg.a(new g.a()new g.a
    {
      public final void onClick()
      {
        AppMethodBeat.i(240184);
        localg.bMo();
        if (parama1 != null) {
          parama1.onClick();
        }
        AppMethodBeat.o(240184);
      }
    }, new g.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(240185);
        localg.bMo();
        if (parama2 != null) {
          parama2.onClick();
        }
        AppMethodBeat.o(240185);
      }
    });
    paramContext = LayoutInflater.from(paramContext).inflate(2131496316, null);
    parama1 = (ImageView)paramContext.findViewById(2131299775);
    if (ao.isDarkMode()) {
      parama1.setImageResource(2131690421);
    }
    for (;;)
    {
      localg.setCustomView(paramContext);
      localg.dGm();
      AppMethodBeat.o(240196);
      return;
      parama1.setImageResource(2131690420);
    }
  }
  
  public final void a(Context paramContext, final String paramString, final DialogInterface.OnClickListener paramOnClickListener1, final DialogInterface.OnClickListener paramOnClickListener2, final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(8767);
    final PBool localPBool = new PBool();
    paramContext = new d.a(paramContext);
    paramContext.aoO(2131762784);
    paramContext.aoS(2131762782);
    paramContext.aoV(2131762785);
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
    paramContext.aoW(2131762781);
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
        if (!com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext()))
        {
          paramAnonymousDialogInterface = new RequestFloatWindowPermissionDialog.a()
          {
            public final void onResultAllow(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(240186);
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              AppMethodBeat.o(240186);
            }
            
            public final void onResultCancel(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(240188);
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              AppMethodBeat.o(240188);
            }
            
            public final void onResultRefuse(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(240187);
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              AppMethodBeat.o(240187);
            }
          };
          RequestFloatWindowPermissionDialog.a(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131760767), paramAnonymousDialogInterface, true, com.tencent.mm.bq.a.apJ());
        }
        AppMethodBeat.o(8762);
      }
    });
    paramContext.Dk(true);
    paramContext.f(new DialogInterface.OnCancelListener()
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
    paramContext.hbn().show();
    com.tencent.mm.plugin.downloader_app.b.a.a(15, 1501, 1, 1, paramString, "", "");
    AppMethodBeat.o(8767);
  }
  
  public final void a(Context paramContext, final String paramString, final com.tencent.mm.plugin.downloader_app.api.b.a parama1, final com.tencent.mm.plugin.downloader_app.api.b.a parama2, final com.tencent.mm.plugin.downloader_app.api.b.a parama3)
  {
    AppMethodBeat.i(240195);
    Object localObject;
    if (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rOq, false))
    {
      localObject = new e(paramContext, 2131820868);
      ((e)localObject).gR();
      ((e)localObject).setCancelable(false);
      paramContext = LayoutInflater.from(paramContext).inflate(2131496116, null);
      ((e)localObject).setContentView(paramContext);
      paramContext.findViewById(2131299746).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(240189);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          this.qKh.dismiss();
          if (parama3 != null) {
            parama3.onClick();
          }
          com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 2, paramString, "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(240189);
        }
      });
      paramContext.findViewById(2131299749).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(240190);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          this.qKh.dismiss();
          if (parama1 != null) {
            parama1.onClick();
          }
          com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 23, paramString, "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(240190);
        }
      });
      paramContext.findViewById(2131299745).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(240191);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          this.qKh.dismiss();
          if (parama2 != null) {
            parama2.onClick();
          }
          com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 3, paramString, "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(240191);
        }
      });
      ((e)localObject).show();
    }
    for (;;)
    {
      com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 1, paramString, "", "");
      AppMethodBeat.o(240195);
      return;
      localObject = new PBool();
      paramContext = new d.a(paramContext);
      paramContext.aoO(2131762786);
      paramContext.aoS(2131762787);
      paramContext.aoV(2131762785);
      paramContext.c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(240192);
          this.qJZ.value = true;
          if (parama1 != null) {
            parama1.onClick();
          }
          this.qJZ.value = true;
          com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 23, paramString, "", "");
          AppMethodBeat.o(240192);
        }
      });
      paramContext.aoW(2131762783);
      paramContext.d(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(240193);
          if (parama2 != null) {
            parama2.onClick();
          }
          this.qJZ.value = true;
          com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 3, paramString, "", "");
          AppMethodBeat.o(240193);
        }
      });
      paramContext.Dk(true);
      paramContext.f(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(240194);
          if (parama3 != null) {
            parama3.onClick();
          }
          if (!this.qJZ.value) {
            com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 2, paramString, "", "");
          }
          AppMethodBeat.o(240194);
        }
      });
      paramContext.hbn().show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a
 * JD-Core Version:    0.7.0.1
 */