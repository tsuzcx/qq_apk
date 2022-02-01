package com.tencent.mm.plugin.downloader_app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.appcompat.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.j;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.luggage.j.f;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.a.g.a;

public final class a
  implements com.tencent.mm.plugin.downloader_app.api.b
{
  public final void a(Context paramContext, final com.tencent.mm.plugin.downloader_app.api.b.a parama1, final com.tencent.mm.plugin.downloader_app.api.b.a parama2)
  {
    AppMethodBeat.i(242828);
    final g localg = new g(paramContext, 1, 0, false);
    localg.d(paramContext.getString(e.h.ukO), paramContext.getString(e.h.ukP));
    localg.a(new g.a()new g.a
    {
      public final void onClick()
      {
        AppMethodBeat.i(243112);
        localg.bYF();
        if (parama1 != null) {
          parama1.onClick();
        }
        AppMethodBeat.o(243112);
      }
    }, new g.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(243001);
        localg.bYF();
        if (parama2 != null) {
          parama2.onClick();
        }
        AppMethodBeat.o(243001);
      }
    });
    paramContext = LayoutInflater.from(paramContext).inflate(e.f.ukG, null);
    parama1 = (ImageView)paramContext.findViewById(e.e.ukd);
    if (ar.isDarkMode()) {
      parama1.setImageResource(e.g.ic_download_pause_alert_dark);
    }
    for (;;)
    {
      localg.setCustomView(paramContext);
      localg.eik();
      AppMethodBeat.o(242828);
      return;
      parama1.setImageResource(e.g.ic_download_pause_alert);
    }
  }
  
  public final void a(Context paramContext, final String paramString, final DialogInterface.OnClickListener paramOnClickListener1, final DialogInterface.OnClickListener paramOnClickListener2, final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(8767);
    final PBool localPBool = new PBool();
    paramContext = new d.a(paramContext);
    paramContext.ayc(e.h.luggage_game_download_not_in_wifi_title);
    paramContext.ayg(e.h.luggage_game_book_download_in_wifi_tips);
    paramContext.ayj(e.h.luggage_game_download_straight);
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
    paramContext.ayk(e.h.luggage_game_book_download_in_wifi);
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
        if (!com.tencent.mm.compatible.e.b.ct(MMApplicationContext.getContext()))
        {
          paramAnonymousDialogInterface = new RequestFloatWindowPermissionDialog.a()
          {
            public final void a(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(243183);
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              AppMethodBeat.o(243183);
            }
            
            public final void b(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(243184);
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              AppMethodBeat.o(243184);
            }
            
            public final void c(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(243186);
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              AppMethodBeat.o(243186);
            }
          };
          RequestFloatWindowPermissionDialog.a(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(j.f.float_ball_no_float_window_permission_alert_download), paramAnonymousDialogInterface, true, com.tencent.mm.bx.a.awc());
        }
        AppMethodBeat.o(8762);
      }
    });
    paramContext.HG(true);
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
    paramContext.icu().show();
    com.tencent.mm.plugin.downloader_app.b.a.a(15, 1501, 1, 1, paramString, "", "");
    AppMethodBeat.o(8767);
  }
  
  public final void a(Context paramContext, final String paramString, final com.tencent.mm.plugin.downloader_app.api.b.a parama1, final com.tencent.mm.plugin.downloader_app.api.b.a parama2, final com.tencent.mm.plugin.downloader_app.api.b.a parama3)
  {
    AppMethodBeat.i(242827);
    Object localObject;
    if (((com.tencent.mm.game.report.a.b)h.ae(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vul, false))
    {
      localObject = new e(paramContext, a.j.CustomSheetStyle);
      ((e)localObject).bb();
      ((e)localObject).setCancelable(false);
      paramContext = LayoutInflater.from(paramContext).inflate(e.f.ukE, null);
      ((e)localObject).setContentView(paramContext);
      paramContext.findViewById(e.e.ukb).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(242964);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          this.ujm.dismiss();
          if (parama3 != null) {
            parama3.onClick();
          }
          com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 2, paramString, "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(242964);
        }
      });
      paramContext.findViewById(e.e.ukc).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(242982);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          this.ujm.dismiss();
          if (parama1 != null) {
            parama1.onClick();
          }
          com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 23, paramString, "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(242982);
        }
      });
      paramContext.findViewById(e.e.uka).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(243101);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          this.ujm.dismiss();
          if (parama2 != null) {
            parama2.onClick();
          }
          com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 3, paramString, "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(243101);
        }
      });
      ((e)localObject).show();
    }
    for (;;)
    {
      com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 1, paramString, "", "");
      AppMethodBeat.o(242827);
      return;
      localObject = new PBool();
      paramContext = new d.a(paramContext);
      paramContext.ayc(e.h.luggage_game_download_tips);
      paramContext.ayg(e.h.luggage_game_resume_not_wifi_tips);
      paramContext.ayj(e.h.luggage_game_download_straight);
      paramContext.c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(242920);
          this.uje.value = true;
          if (parama1 != null) {
            parama1.onClick();
          }
          this.uje.value = true;
          com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 23, paramString, "", "");
          AppMethodBeat.o(242920);
        }
      });
      paramContext.ayk(e.h.luggage_game_cancel_book_wifi);
      paramContext.d(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(243233);
          if (parama2 != null) {
            parama2.onClick();
          }
          this.uje.value = true;
          com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 3, paramString, "", "");
          AppMethodBeat.o(243233);
        }
      });
      paramContext.HG(true);
      paramContext.f(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(243105);
          if (parama3 != null) {
            parama3.onClick();
          }
          if (!this.uje.value) {
            com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 2, paramString, "", "");
          }
          AppMethodBeat.o(243105);
        }
      });
      paramContext.icu().show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a
 * JD-Core Version:    0.7.0.1
 */