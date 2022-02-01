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
import com.tencent.mm.autogen.b.z;
import com.tencent.mm.game.report.api.a;
import com.tencent.mm.game.report.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.game.h.d;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.h.j;
import com.tencent.mm.plugin.game.model.aw;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.pluginsdk.model.app.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.i;
import java.util.Set;

public final class d
{
  private static Object lock;
  int IFc;
  String IML;
  private h IMW;
  private u IMX;
  private q IMY;
  private t IMZ;
  DialogInterface.OnClickListener INa;
  private int INb;
  private Context mContext;
  private Dialog uCz;
  private MTimerHandler xoX;
  
  static
  {
    AppMethodBeat.i(41877);
    lock = new Object();
    AppMethodBeat.o(41877);
  }
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(41873);
    this.IMW = null;
    this.IMX = null;
    this.IMY = null;
    this.IMZ = null;
    this.INa = null;
    this.IFc = 0;
    this.IML = null;
    this.INb = 3000;
    this.xoX = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
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
      if (paramc.piu)
      {
        paramButton.setEnabled(false);
        paramButton.setText(h.i.IaA);
        paramButton.setVisibility(0);
        paramProgressBar.setVisibility(8);
        AppMethodBeat.o(41875);
        return;
      }
      paramButton.setText(h.i.Iaz);
      paramButton.setVisibility(0);
      paramProgressBar.setVisibility(8);
      AppMethodBeat.o(41875);
      return;
    }
    if (com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, paramc))
    {
      int i = com.tencent.mm.plugin.game.d.c.aHj(paramc.field_packageName);
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
          paramButton.setText(h.i.IaT);
        }
        for (;;)
        {
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
          break;
          paramButton.setText(h.i.IaC);
        }
        paramButton.setVisibility(0);
        paramProgressBar.setVisibility(8);
        if (paramc.scene == 12) {
          paramButton.setText(h.i.IaR);
        } else {
          paramButton.setText(h.i.Ibo);
        }
      }
    }
    if (paramc.fFS())
    {
      paramButton.setVisibility(0);
      paramProgressBar.setVisibility(8);
      if (paramc.scene == 12)
      {
        paramButton.setText(h.i.IaR);
        AppMethodBeat.o(41875);
        return;
      }
      paramButton.setText(h.i.Ibo);
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
          if (paramc.ICq)
          {
            paraml = paramc.field_appId;
            if (!a(e.hO(this.mContext), paraml)) {
              paramButton.setText(h.i.IaW);
            }
          }
        }
        for (;;)
        {
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
          break;
          paramButton.setText(h.i.Ibk);
          continue;
          paramButton.setText(h.i.Ibj);
        }
      case 1: 
        if (paraml.mode == 3) {
          paramButton.setText(h.i.Ibm);
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
            paramButton.setText(h.i.IaV);
          }
          for (;;)
          {
            paramButton.setVisibility(0);
            paramProgressBar.setVisibility(8);
            break;
            paramButton.setText(h.i.Ibl);
          }
          if (paramc.scene == 12) {
            paramButton.setText(h.i.Ibi);
          } else {
            paramButton.setText(h.i.Ibh);
          }
        }
        if (paramc.piu)
        {
          paramButton.setEnabled(false);
          paramButton.setText(h.i.IaA);
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
        }
        else
        {
          paramButton.setText(h.i.Iaz);
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
          continue;
          paramButton.setText(h.i.Iay);
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
          continue;
          if (paraml == null)
          {
            paramButton.setText(h.i.Iax);
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
            paramButton.setText(h.i.Iax);
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
                paramButton.setText(h.i.Ibm);
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
                paramButton.setText(h.i.IaV);
              }
              for (;;)
              {
                paramButton.setVisibility(0);
                paramProgressBar.setVisibility(8);
                break;
                paramButton.setText(h.i.Ibl);
              }
              if (paramc.scene == 12) {
                paramButton.setText(h.i.Ibi);
              } else {
                paramButton.setText(h.i.Ibh);
              }
            }
            paramButton.setText(h.i.IaB);
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
    if ((com.tencent.mm.pluginsdk.model.app.h.y(this.mContext, paramc.field_appId)) || (paramc.fFS())) {
      paraml.mode = 1;
    }
    int i;
    if (paraml.mode == 3)
    {
      aw.fHc();
      i = aw.l(this.mContext, "com.tencent.android.qqdownloader", paramc.jOF);
      Log.i("MicroMsg.GameActionBtnHandler", "qqdownloader install status:[%d], yybSupportedVersionCode:[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramc.jOF) });
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
        if (this.IMW == null) {
          this.IMW = new h(this.mContext);
        }
        this.IMW.setSourceScene(this.IFc);
        this.IMW.je(this.IML, "");
        this.IMW.onClick((View)localObject1);
      }
      while (paramc.ICq)
      {
        localObject1 = e.hO(this.mContext);
        if (!a((Set)localObject1, paramc.field_appId))
        {
          if (paraml.mode != 3)
          {
            paraml = LayoutInflater.from(this.mContext).inflate(h.f.HZz, null);
            ((LinearLayout)paraml.findViewById(h.e.mm_alert_msg_area)).setGravity(17);
            localObject2 = (ImageView)paraml.findViewById(h.e.mm_alert_msg_icon);
            localObject3 = (TextView)paraml.findViewById(h.e.mm_alert_msg);
            TextView localTextView = (TextView)paraml.findViewById(h.e.mm_alert_msg_subdesc);
            ((ImageView)localObject2).setBackgroundResource(h.d.HTm);
            ((TextView)localObject3).setText(h.i.Ibc);
            localTextView.setText(h.i.Ibb);
            this.uCz = new i(this.mContext, h.j.Icq);
            this.uCz.setContentView(paraml);
            this.uCz.setCancelable(true);
            this.uCz.setCanceledOnTouchOutside(true);
            this.uCz.show();
            this.xoX.startTimer(this.INb);
          }
          a.mtH.c(paramc.field_appId, 1, 0, null, null);
          ((Set)localObject1).add(paramc.field_appId);
          e.a(this.mContext, (Set)localObject1);
        }
        AppMethodBeat.o(41874);
        return;
        Object localObject2 = f.duv().amO(paramc.field_appId);
        if ((localObject2 != null) && (((FileDownloadTaskInfo)localObject2).id > 0L)) {
          f.duv().kR(((FileDownloadTaskInfo)localObject2).id);
        }
        if (this.IMX == null) {
          this.IMX = new u(this.mContext);
        }
        localObject2 = this.IMX;
        i = this.IFc;
        Object localObject3 = this.IML;
        ((u)localObject2).IFc = i;
        ((u)localObject2).IML = ((String)localObject3);
        this.IMX.onClick((View)localObject1);
        continue;
        if (!Util.isNullOrNil(paramc.jOw))
        {
          Log.i("MicroMsg.GameActionBtnHandler", "gp download url is not null and download flag is download directly by gp store");
          v.cH(this.mContext, paramc.jOw);
          g.a(this.mContext, paramc.scene, paramc.hYi, paramc.position, 25, paramc.field_appId, this.IFc, paramc.hAR, this.IML);
        }
      }
      if (this.IMZ == null)
      {
        this.IMZ = new t(this.mContext);
        this.IMZ.IVh = this.INa;
      }
      this.IMZ.IFc = this.IFc;
      this.IMZ.onClick((View)localObject1);
      g.a(this.mContext, paramc.scene, paramc.hYi, paramc.position, 9, paramc.field_appId, this.IFc, paramc.hAR, this.IML);
      AppMethodBeat.o(41874);
      return;
      paraml = f.duv().amO(paramc.field_appId);
      if ((paraml != null) && (paraml.id > 0L)) {
        f.duv().kR(paraml.id);
      }
      if (this.IMY == null) {
        this.IMY = new q(this.mContext);
      }
      this.IMY.lCR = this.IFc;
      this.IMY.IUa = paramc.jOA;
      this.IMY.onClick((View)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.d
 * JD-Core Version:    0.7.0.1
 */