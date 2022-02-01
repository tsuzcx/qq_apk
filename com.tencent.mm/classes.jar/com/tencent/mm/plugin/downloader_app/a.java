package com.tencent.mm.plugin.downloader_app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.j;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader_app.api.b.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.game.luggage.j.f;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.a.j.a;

public final class a
  implements com.tencent.mm.plugin.downloader_app.api.b
{
  public final void a(Context paramContext, final b.a parama1, final b.a parama2)
  {
    AppMethodBeat.i(269682);
    final j localj = new j(paramContext, 1, 0, false);
    localj.d(paramContext.getString(e.h.xra), paramContext.getString(e.h.xrb));
    localj.a(new j.a()new j.a
    {
      public final void onClick()
      {
        AppMethodBeat.i(269659);
        localj.cyW();
        if (parama1 != null) {
          parama1.onClick();
        }
        AppMethodBeat.o(269659);
      }
    }, new j.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(269662);
        localj.cyW();
        if (parama2 != null) {
          parama2.onClick();
        }
        AppMethodBeat.o(269662);
      }
    });
    paramContext = LayoutInflater.from(paramContext).inflate(e.f.xqS, null);
    parama1 = (ImageView)paramContext.findViewById(e.e.xqj);
    if (aw.isDarkMode()) {
      parama1.setImageResource(e.g.ic_download_pause_alert_dark);
    }
    for (;;)
    {
      localj.setCustomView(paramContext);
      localj.dDn();
      AppMethodBeat.o(269682);
      return;
      parama1.setImageResource(e.g.ic_download_pause_alert);
    }
  }
  
  public final void a(Context paramContext, final String paramString, final DialogInterface.OnClickListener paramOnClickListener1, final DialogInterface.OnClickListener paramOnClickListener2, final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(8767);
    final PBool localPBool = new PBool();
    paramContext = new e.a(paramContext);
    paramContext.aEK(e.h.luggage_game_download_not_in_wifi_title);
    paramContext.aEO(e.h.luggage_game_book_download_in_wifi_tips);
    paramContext.aER(e.h.luggage_game_download_straight);
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
    paramContext.aES(e.h.luggage_game_book_download_in_wifi);
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
        if (!com.tencent.mm.compatible.e.b.dh(MMApplicationContext.getContext()))
        {
          paramAnonymousDialogInterface = new RequestFloatWindowPermissionDialog.a()
          {
            public final void a(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(269676);
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              AppMethodBeat.o(269676);
            }
            
            public final void b(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(269679);
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              AppMethodBeat.o(269679);
            }
            
            public final void c(RequestFloatWindowPermissionDialog paramAnonymous2RequestFloatWindowPermissionDialog)
            {
              AppMethodBeat.i(269681);
              paramAnonymous2RequestFloatWindowPermissionDialog.finish();
              AppMethodBeat.o(269681);
            }
          };
          RequestFloatWindowPermissionDialog.a(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(j.f.float_ball_no_float_window_permission_alert_download), paramAnonymousDialogInterface, true, com.tencent.mm.bq.a.aQB());
        }
        AppMethodBeat.o(8762);
      }
    });
    paramContext.NC(true);
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
    paramContext.jHH().show();
    com.tencent.mm.plugin.downloader_app.b.a.a(15, 1501, 1, 1, paramString, "", "");
    AppMethodBeat.o(8767);
  }
  
  public final void a(Context paramContext, final String paramString, final b.a parama1, final b.a parama2, final b.a parama3)
  {
    AppMethodBeat.i(269680);
    Object localObject;
    if (((com.tencent.mm.game.report.a.b)h.ax(com.tencent.mm.game.report.a.b.class)).a(c.a.yGQ, false))
    {
      localObject = new androidx.appcompat.app.e(paramContext, a.j.CustomSheetStyle);
      ((androidx.appcompat.app.e)localObject).bU();
      ((androidx.appcompat.app.e)localObject).setCancelable(false);
      paramContext = LayoutInflater.from(paramContext).inflate(e.f.xqQ, null);
      ((androidx.appcompat.app.e)localObject).setContentView(paramContext);
      paramContext.findViewById(e.e.xqh).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(269668);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          this.xpp.dismiss();
          if (parama3 != null) {
            parama3.onClick();
          }
          com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 2, paramString, "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(269668);
        }
      });
      paramContext.findViewById(e.e.xqi).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(269667);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          this.xpp.dismiss();
          if (parama1 != null) {
            parama1.onClick();
          }
          com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 23, paramString, "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(269667);
        }
      });
      paramContext.findViewById(e.e.xqg).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(269665);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          this.xpp.dismiss();
          if (parama2 != null) {
            parama2.onClick();
          }
          com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 3, paramString, "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/DownloadAppAlertDelegateImpl$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(269665);
        }
      });
      ((androidx.appcompat.app.e)localObject).show();
    }
    for (;;)
    {
      com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 1, paramString, "", "");
      AppMethodBeat.o(269680);
      return;
      localObject = new PBool();
      paramContext = new e.a(paramContext);
      paramContext.aEK(e.h.luggage_game_download_tips);
      paramContext.aEO(e.h.luggage_game_resume_not_wifi_tips);
      paramContext.aER(e.h.luggage_game_download_straight);
      paramContext.c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(269664);
          this.xph.value = true;
          if (parama1 != null) {
            parama1.onClick();
          }
          this.xph.value = true;
          com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 23, paramString, "", "");
          AppMethodBeat.o(269664);
        }
      });
      paramContext.aES(e.h.luggage_game_cancel_book_wifi);
      paramContext.d(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(269685);
          if (parama2 != null) {
            parama2.onClick();
          }
          this.xph.value = true;
          com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 3, paramString, "", "");
          AppMethodBeat.o(269685);
        }
      });
      paramContext.NC(true);
      paramContext.e(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(269683);
          if (parama3 != null) {
            parama3.onClick();
          }
          if (!this.xph.value) {
            com.tencent.mm.plugin.downloader_app.b.a.a(15, 1502, 1, 2, paramString, "", "");
          }
          AppMethodBeat.o(269683);
        }
      });
      paramContext.jHH().show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a
 * JD-Core Version:    0.7.0.1
 */