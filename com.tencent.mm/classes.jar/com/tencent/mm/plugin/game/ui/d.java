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
import com.tencent.mm.f.c.y;
import com.tencent.mm.game.report.api.a;
import com.tencent.mm.game.report.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.game.g.d;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.g.j;
import com.tencent.mm.plugin.game.model.ax;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.i;
import java.util.Set;

public final class d
{
  private static Object lock;
  int CKU;
  private h CSG;
  private u CSH;
  private q CSI;
  private t CSJ;
  DialogInterface.OnClickListener CSK;
  private int CSL;
  String CSv;
  private Dialog dialog;
  private Context mContext;
  private MTimerHandler uiU;
  
  static
  {
    AppMethodBeat.i(41877);
    lock = new Object();
    AppMethodBeat.o(41877);
  }
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(41873);
    this.CSG = null;
    this.CSH = null;
    this.CSI = null;
    this.CSJ = null;
    this.CSK = null;
    this.CKU = 0;
    this.CSv = null;
    this.CSL = 3000;
    this.uiU = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
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
  
  private static boolean a(Set<String> paramSet, String paramString)
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
      if (paramc.moD)
      {
        paramButton.setEnabled(false);
        paramButton.setText(g.i.Cos);
        paramButton.setVisibility(0);
        paramProgressBar.setVisibility(8);
        AppMethodBeat.o(41875);
        return;
      }
      paramButton.setText(g.i.Cor);
      paramButton.setVisibility(0);
      paramProgressBar.setVisibility(8);
      AppMethodBeat.o(41875);
      return;
    }
    if (com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, paramc))
    {
      int i = com.tencent.mm.plugin.game.d.c.aKt(paramc.field_packageName);
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
        Log.i("MicroMsg.GameActionBtnHandler", "AppId: %s installed, local: %d, server: %d", new Object[] { paramc.field_appId, Integer.valueOf(i), Integer.valueOf(paramc.versionCode) });
        AppMethodBeat.o(41875);
        return;
        if (paramc.scene == 12) {
          paramButton.setText(g.i.CoL);
        }
        for (;;)
        {
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
          break;
          paramButton.setText(g.i.Cou);
        }
        paramButton.setVisibility(0);
        paramProgressBar.setVisibility(8);
        if (paramc.scene == 12) {
          paramButton.setText(g.i.CoJ);
        } else {
          paramButton.setText(g.i.Cpg);
        }
      }
    }
    if (paramc.exW())
    {
      paramButton.setVisibility(0);
      paramProgressBar.setVisibility(8);
      if (paramc.scene == 12)
      {
        paramButton.setText(g.i.CoJ);
        AppMethodBeat.o(41875);
        return;
      }
      paramButton.setText(g.i.Cpg);
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
      Log.i("MicroMsg.GameActionBtnHandler", "updateBtnStateAndText: %s, Status: %d, Text: %s", new Object[] { paramc.field_appId, Integer.valueOf(paramc.status), paramButton.getText() });
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
          if (paramc.CIg)
          {
            paraml = paramc.field_appId;
            if (!a(e.gv(this.mContext), paraml)) {
              paramButton.setText(g.i.CoO);
            }
          }
        }
        for (;;)
        {
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
          break;
          paramButton.setText(g.i.Cpc);
          continue;
          paramButton.setText(g.i.Cpb);
        }
      case 1: 
        if (paraml.mode == 3) {
          paramButton.setText(g.i.Cpe);
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
            paramButton.setText(g.i.CoN);
          }
          for (;;)
          {
            paramButton.setVisibility(0);
            paramProgressBar.setVisibility(8);
            break;
            paramButton.setText(g.i.Cpd);
          }
          if (paramc.scene == 12) {
            paramButton.setText(g.i.Cpa);
          } else {
            paramButton.setText(g.i.CoZ);
          }
        }
        if (paramc.moD)
        {
          paramButton.setEnabled(false);
          paramButton.setText(g.i.Cos);
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
        }
        else
        {
          paramButton.setText(g.i.Cor);
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
          continue;
          paramButton.setText(g.i.Coq);
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
          continue;
          if (paraml == null)
          {
            paramButton.setText(g.i.Cop);
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
            paramButton.setText(g.i.Cop);
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
                paramButton.setText(g.i.Cpe);
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
                paramButton.setText(g.i.CoN);
              }
              for (;;)
              {
                paramButton.setVisibility(0);
                paramProgressBar.setVisibility(8);
                break;
                paramButton.setText(g.i.Cpd);
              }
              if (paramc.scene == 12) {
                paramButton.setText(g.i.Cpa);
              } else {
                paramButton.setText(g.i.CoZ);
              }
            }
            paramButton.setText(g.i.Cot);
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
      Log.e("MicroMsg.GameActionBtnHandler", "Null appInfo or null downloadInfo");
      AppMethodBeat.o(41874);
      return;
    }
    Object localObject1 = new View(this.mContext);
    ((View)localObject1).setTag(paramc);
    Log.i("MicroMsg.GameActionBtnHandler", "App Status: %d, Download Mode: %d, Download Status: %d", new Object[] { Integer.valueOf(paramc.status), Integer.valueOf(paraml.mode), Integer.valueOf(paraml.status) });
    if ((com.tencent.mm.pluginsdk.model.app.h.u(this.mContext, paramc.field_appId)) || (paramc.exW())) {
      paraml.mode = 1;
    }
    int i;
    if (paraml.mode == 3)
    {
      ax.ezg();
      i = ax.j(this.mContext, "com.tencent.android.qqdownloader", paramc.hrS);
      Log.i("MicroMsg.GameActionBtnHandler", "qqdownloader install status:[%d], yybSupportedVersionCode:[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramc.hrS) });
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
        Log.d("MicroMsg.GameActionBtnHandler", "summertoken downloadInfo.mode[%d]", new Object[] { Integer.valueOf(paraml.mode) });
        if (this.CSG == null) {
          this.CSG = new h(this.mContext);
        }
        this.CSG.setSourceScene(this.CKU);
        this.CSG.hX(this.CSv, "");
        this.CSG.onClick((View)localObject1);
      }
      while (paramc.CIg)
      {
        localObject1 = e.gv(this.mContext);
        if (!a((Set)localObject1, paramc.field_appId))
        {
          if (paraml.mode != 3)
          {
            paraml = LayoutInflater.from(this.mContext).inflate(g.f.Cnr, null);
            ((LinearLayout)paraml.findViewById(g.e.mm_alert_msg_area)).setGravity(17);
            localObject2 = (ImageView)paraml.findViewById(g.e.mm_alert_msg_icon);
            localObject3 = (TextView)paraml.findViewById(g.e.mm_alert_msg);
            TextView localTextView = (TextView)paraml.findViewById(g.e.mm_alert_msg_subdesc);
            ((ImageView)localObject2).setBackgroundResource(g.d.Chd);
            ((TextView)localObject3).setText(g.i.CoU);
            localTextView.setText(g.i.CoT);
            this.dialog = new i(this.mContext, g.j.Cqh);
            this.dialog.setContentView(paraml);
            this.dialog.setCancelable(true);
            this.dialog.setCanceledOnTouchOutside(true);
            this.dialog.show();
            this.uiU.startTimer(this.CSL);
          }
          a.jTp.c(paramc.field_appId, 1, 0, null, null);
          ((Set)localObject1).add(paramc.field_appId);
          e.a(this.mContext, (Set)localObject1);
        }
        AppMethodBeat.o(41874);
        return;
        Object localObject2 = f.cPZ().asZ(paramc.field_appId);
        if ((localObject2 != null) && (((FileDownloadTaskInfo)localObject2).id > 0L)) {
          f.cPZ().Iw(((FileDownloadTaskInfo)localObject2).id);
        }
        if (this.CSH == null) {
          this.CSH = new u(this.mContext);
        }
        localObject2 = this.CSH;
        i = this.CKU;
        Object localObject3 = this.CSv;
        ((u)localObject2).CKU = i;
        ((u)localObject2).CSv = ((String)localObject3);
        this.CSH.onClick((View)localObject1);
        continue;
        if (!Util.isNullOrNil(paramc.hrJ))
        {
          Log.i("MicroMsg.GameActionBtnHandler", "gp download url is not null and download flag is download directly by gp store");
          r.cw(this.mContext, paramc.hrJ);
          g.a(this.mContext, paramc.scene, paramc.fSl, paramc.position, 25, paramc.field_appId, this.CKU, paramc.fwt, this.CSv);
        }
      }
      if (this.CSJ == null)
      {
        this.CSJ = new t(this.mContext);
        this.CSJ.DaT = this.CSK;
      }
      this.CSJ.CKU = this.CKU;
      this.CSJ.onClick((View)localObject1);
      g.a(this.mContext, paramc.scene, paramc.fSl, paramc.position, 9, paramc.field_appId, this.CKU, paramc.fwt, this.CSv);
      AppMethodBeat.o(41874);
      return;
      paraml = f.cPZ().asZ(paramc.field_appId);
      if ((paraml != null) && (paraml.id > 0L)) {
        f.cPZ().Iw(paraml.id);
      }
      if (this.CSI == null) {
        this.CSI = new q(this.mContext);
      }
      this.CSI.jaR = this.CKU;
      this.CSI.CZK = paramc.hrN;
      this.CSI.onClick((View)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.d
 * JD-Core Version:    0.7.0.1
 */