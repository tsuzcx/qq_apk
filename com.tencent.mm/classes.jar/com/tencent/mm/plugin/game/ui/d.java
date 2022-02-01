package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.y;
import com.tencent.mm.game.report.api.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.game.model.aw;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.i;
import java.util.Set;

public final class d
{
  private static Object lock;
  private Dialog dialog;
  private Context mContext;
  private au oJW;
  int tfA;
  private u tmA;
  private q tmB;
  private t tmC;
  DialogInterface.OnClickListener tmD;
  private int tmE;
  String tmo;
  private h tmz;
  
  static
  {
    AppMethodBeat.i(41877);
    lock = new Object();
    AppMethodBeat.o(41877);
  }
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(41873);
    this.tmz = null;
    this.tmA = null;
    this.tmB = null;
    this.tmC = null;
    this.tmD = null;
    this.tfA = 0;
    this.tmo = null;
    this.tmE = 3000;
    this.oJW = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(41872);
        if (d.a(d.this) != null) {
          d.a(d.this).cancel();
        }
        AppMethodBeat.o(41872);
        return true;
      }
    }, false);
    this.mContext = paramContext;
    AppMethodBeat.o(41873);
  }
  
  private static boolean b(Set<String> paramSet, String paramString)
  {
    AppMethodBeat.i(41876);
    if ((paramSet == null) || (paramSet.isEmpty()))
    {
      AppMethodBeat.o(41876);
      return false;
    }
    if (!paramSet.contains(paramString))
    {
      AppMethodBeat.o(41876);
      return false;
    }
    AppMethodBeat.o(41876);
    return true;
  }
  
  public final void a(ProgressBar paramProgressBar, Button paramButton, com.tencent.mm.plugin.game.model.c paramc, l paraml)
  {
    AppMethodBeat.i(41875);
    if ((paramProgressBar == null) || (paramButton == null))
    {
      AppMethodBeat.o(41875);
      return;
    }
    paramButton.setEnabled(true);
    paramButton.setVisibility(0);
    if (paramc.status == 1)
    {
      if (paramc.iis)
      {
        paramButton.setEnabled(false);
        paramButton.setText(2131759829);
        paramButton.setVisibility(0);
        paramProgressBar.setVisibility(8);
        AppMethodBeat.o(41875);
        return;
      }
      paramButton.setText(2131759828);
      paramButton.setVisibility(0);
      paramProgressBar.setVisibility(8);
      AppMethodBeat.o(41875);
      return;
    }
    if (com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, paramc))
    {
      int i = com.tencent.mm.plugin.game.f.c.ahP(paramc.field_packageName);
      if (paramc.versionCode > i) {
        if (paraml.status == 1)
        {
          paramProgressBar.setVisibility(0);
          paramProgressBar.setProgress(paraml.progress);
          paramButton.setVisibility(8);
        }
      }
      for (;;)
      {
        ac.i("MicroMsg.GameActionBtnHandler", "AppId: %s installed, local: %d, server: %d", new Object[] { paramc.field_appId, Integer.valueOf(i), Integer.valueOf(paramc.versionCode) });
        AppMethodBeat.o(41875);
        return;
        if (paramc.scene == 12) {
          paramButton.setText(2131759855);
        }
        for (;;)
        {
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
          break;
          paramButton.setText(2131759831);
        }
        paramButton.setVisibility(0);
        paramProgressBar.setVisibility(8);
        if (paramc.scene == 12) {
          paramButton.setText(2131759853);
        } else {
          paramButton.setText(2131759917);
        }
      }
    }
    if (paramc.cPT())
    {
      paramButton.setVisibility(0);
      paramProgressBar.setVisibility(8);
      if (paramc.scene == 12)
      {
        paramButton.setText(2131759853);
        AppMethodBeat.o(41875);
        return;
      }
      paramButton.setText(2131759917);
      AppMethodBeat.o(41875);
      return;
    }
    switch (paramc.status)
    {
    default: 
      paramButton.setVisibility(8);
      paramProgressBar.setVisibility(8);
    }
    for (;;)
    {
      ac.i("MicroMsg.GameActionBtnHandler", "updateBtnStateAndText: %s, Status: %d, Text: %s", new Object[] { paramc.field_appId, Integer.valueOf(paramc.status), paramButton.getText() });
      AppMethodBeat.o(41875);
      return;
      if (paraml == null)
      {
        paramButton.setVisibility(8);
        paramProgressBar.setVisibility(8);
        AppMethodBeat.o(41875);
        return;
      }
      switch (paraml.status)
      {
      default: 
        break;
      case 0: 
        if (paramc.scene == 12) {
          if (paramc.tcV)
          {
            paraml = paramc.field_appId;
            if (!b(com.tencent.mm.plugin.game.model.e.fn(this.mContext), paraml)) {
              paramButton.setText(2131759863);
            }
          }
        }
        for (;;)
        {
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
          break;
          paramButton.setText(2131759909);
          continue;
          paramButton.setText(2131759908);
        }
      case 1: 
        if (paraml.mode == 3) {
          paramButton.setText(2131759915);
        }
      case 2: 
      case 3: 
        for (;;)
        {
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
          break;
          if (paraml.mode != 1) {
            break;
          }
          paramProgressBar.setProgress(paraml.progress);
          paramButton.setVisibility(8);
          paramProgressBar.setVisibility(0);
          break;
          if (paramc.scene == 12) {
            paramButton.setText(2131759862);
          }
          for (;;)
          {
            paramButton.setVisibility(0);
            paramProgressBar.setVisibility(8);
            break;
            paramButton.setText(2131759913);
          }
          if (paramc.scene == 12) {
            paramButton.setText(2131759907);
          } else {
            paramButton.setText(2131759906);
          }
        }
        if (paramc.iis)
        {
          paramButton.setEnabled(false);
          paramButton.setText(2131759829);
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
        }
        else
        {
          paramButton.setText(2131759828);
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
          continue;
          paramButton.setText(2131759827);
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
          continue;
          if (paraml == null)
          {
            paramButton.setText(2131759826);
            paramButton.setVisibility(0);
            paramProgressBar.setVisibility(8);
            AppMethodBeat.o(41875);
            return;
          }
          switch (paraml.status)
          {
          default: 
            break;
          case 0: 
            paramButton.setText(2131759826);
          case 1: 
          case 2: 
          case 3: 
            for (;;)
            {
              paramButton.setVisibility(0);
              paramProgressBar.setVisibility(8);
              break;
              if (paraml.mode == 3)
              {
                paramButton.setText(2131759915);
                break;
              }
              if (paraml.mode != 1) {
                break;
              }
              paramProgressBar.setProgress(paraml.progress);
              paramButton.setVisibility(8);
              paramProgressBar.setVisibility(0);
              break;
              if (paramc.scene == 12) {
                paramButton.setText(2131759862);
              }
              for (;;)
              {
                paramButton.setVisibility(0);
                paramProgressBar.setVisibility(8);
                break;
                paramButton.setText(2131759913);
              }
              if (paramc.scene == 12) {
                paramButton.setText(2131759907);
              } else {
                paramButton.setText(2131759906);
              }
            }
            paramButton.setText(2131759830);
            paramButton.setVisibility(0);
            paramProgressBar.setVisibility(8);
          }
        }
        break;
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.game.model.c paramc, l paraml)
  {
    AppMethodBeat.i(41874);
    if ((paramc == null) || (paraml == null))
    {
      ac.e("MicroMsg.GameActionBtnHandler", "Null appInfo or null downloadInfo");
      AppMethodBeat.o(41874);
      return;
    }
    Object localObject1 = new View(this.mContext);
    ((View)localObject1).setTag(paramc);
    ac.i("MicroMsg.GameActionBtnHandler", "App Status: %d, Download Mode: %d, Download Status: %d", new Object[] { Integer.valueOf(paramc.status), Integer.valueOf(paraml.mode), Integer.valueOf(paraml.status) });
    if ((com.tencent.mm.pluginsdk.model.app.h.t(this.mContext, paramc.field_appId)) || (paramc.cPT())) {
      paraml.mode = 1;
    }
    int i;
    if (paraml.mode == 3)
    {
      aw.cRa();
      i = aw.l(this.mContext, "com.tencent.android.qqdownloader", paramc.eqz);
      ac.i("MicroMsg.GameActionBtnHandler", "qqdownloader install status:[%d], yybSupportedVersionCode:[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramc.eqz) });
      if ((i == -1) || (i == 1) || (i == 2)) {
        paraml.mode = 1;
      }
    }
    switch (paramc.status)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41874);
      return;
      switch (paraml.mode)
      {
      default: 
        ac.d("MicroMsg.GameActionBtnHandler", "summertoken downloadInfo.mode[%d]", new Object[] { Integer.valueOf(paraml.mode) });
        if (this.tmz == null) {
          this.tmz = new h(this.mContext);
        }
        this.tmz.setSourceScene(this.tfA);
        this.tmz.gR(this.tmo, "");
        this.tmz.onClick((View)localObject1);
      }
      while (paramc.tcV)
      {
        localObject1 = com.tencent.mm.plugin.game.model.e.fn(this.mContext);
        if (!b((Set)localObject1, paramc.field_appId))
        {
          if (paraml.mode != 3)
          {
            paraml = LayoutInflater.from(this.mContext).inflate(2131494315, null);
            ((LinearLayout)paraml.findViewById(2131302308)).setGravity(17);
            localObject2 = (ImageView)paraml.findViewById(2131302310);
            localObject3 = (TextView)paraml.findViewById(2131302307);
            TextView localTextView = (TextView)paraml.findViewById(2131302311);
            ((ImageView)localObject2).setBackgroundResource(2131231955);
            ((TextView)localObject3).setText(2131759888);
            localTextView.setText(2131759887);
            this.dialog = new i(this.mContext, 2131820968);
            this.dialog.setContentView(paraml);
            this.dialog.setCancelable(true);
            this.dialog.setCanceledOnTouchOutside(true);
            this.dialog.show();
            paraml = this.oJW;
            long l = this.tmE;
            paraml.au(l, l);
          }
          a.fYF.c(paramc.field_appId, 1, 0, null, null);
          ((Set)localObject1).add(paramc.field_appId);
          com.tencent.mm.plugin.game.model.e.a(this.mContext, (Set)localObject1);
        }
        AppMethodBeat.o(41874);
        return;
        Object localObject2 = f.bXJ().WB(paramc.field_appId);
        if ((localObject2 != null) && (((FileDownloadTaskInfo)localObject2).id > 0L)) {
          f.bXJ().rS(((FileDownloadTaskInfo)localObject2).id);
        }
        if (this.tmA == null) {
          this.tmA = new u(this.mContext);
        }
        localObject2 = this.tmA;
        i = this.tfA;
        Object localObject3 = this.tmo;
        ((u)localObject2).tfA = i;
        ((u)localObject2).tmo = ((String)localObject3);
        this.tmA.onClick((View)localObject1);
        continue;
        if (!bs.isNullOrNil(paramc.eqq))
        {
          ac.i("MicroMsg.GameActionBtnHandler", "gp download url is not null and download flag is download directly by gp store");
          r.bL(this.mContext, paramc.eqq);
          com.tencent.mm.game.report.e.a(this.mContext, paramc.scene, paramc.dtF, paramc.position, 25, paramc.field_appId, this.tfA, paramc.daa, this.tmo);
        }
      }
      if (this.tmC == null)
      {
        this.tmC = new t(this.mContext);
        this.tmC.tuU = this.tmD;
      }
      this.tmC.tfA = this.tfA;
      this.tmC.onClick((View)localObject1);
      com.tencent.mm.game.report.e.a(this.mContext, paramc.scene, paramc.dtF, paramc.position, 9, paramc.field_appId, this.tfA, paramc.daa, this.tmo);
      AppMethodBeat.o(41874);
      return;
      paraml = f.bXJ().WB(paramc.field_appId);
      if ((paraml != null) && (paraml.id > 0L)) {
        f.bXJ().rS(paraml.id);
      }
      if (this.tmB == null) {
        this.tmB = new q(this.mContext);
      }
      this.tmB.fwc = this.tfA;
      this.tmB.ttJ = paramc.equ;
      this.tmB.onClick((View)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.d
 * JD-Core Version:    0.7.0.1
 */