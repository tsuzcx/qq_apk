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
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.game.model.ax;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.i;
import java.util.Set;

public final class d
{
  private static Object lock;
  private Dialog dialog;
  private ap kZH;
  private Context mContext;
  int nok;
  String nuQ;
  private h nvb;
  private u nvc;
  private q nvd;
  private t nve;
  DialogInterface.OnClickListener nvf;
  private int nvg;
  
  static
  {
    AppMethodBeat.i(111717);
    lock = new Object();
    AppMethodBeat.o(111717);
  }
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(111713);
    this.nvb = null;
    this.nvc = null;
    this.nvd = null;
    this.nve = null;
    this.nvf = null;
    this.nok = 0;
    this.nuQ = null;
    this.nvg = 3000;
    this.kZH = new ap(Looper.getMainLooper(), new d.1(this), false);
    this.mContext = paramContext;
    AppMethodBeat.o(111713);
  }
  
  private static boolean a(Set<String> paramSet, String paramString)
  {
    AppMethodBeat.i(111716);
    if ((paramSet == null) || (paramSet.isEmpty()))
    {
      AppMethodBeat.o(111716);
      return false;
    }
    if (!paramSet.contains(paramString))
    {
      AppMethodBeat.o(111716);
      return false;
    }
    AppMethodBeat.o(111716);
    return true;
  }
  
  public final void a(ProgressBar paramProgressBar, Button paramButton, com.tencent.mm.plugin.game.model.c paramc, k paramk)
  {
    AppMethodBeat.i(111715);
    if ((paramProgressBar == null) || (paramButton == null))
    {
      AppMethodBeat.o(111715);
      return;
    }
    paramButton.setEnabled(true);
    paramButton.setVisibility(0);
    if (paramc.status == 1)
    {
      if (paramc.nlY)
      {
        paramButton.setEnabled(false);
        paramButton.setText(2131300330);
        paramButton.setVisibility(0);
        paramProgressBar.setVisibility(8);
        AppMethodBeat.o(111715);
        return;
      }
      paramButton.setText(2131300329);
      paramButton.setVisibility(0);
      paramProgressBar.setVisibility(8);
      AppMethodBeat.o(111715);
      return;
    }
    if (com.tencent.mm.pluginsdk.model.app.g.a(this.mContext, paramc))
    {
      int i = com.tencent.mm.plugin.game.f.c.Qy(paramc.field_packageName);
      if (paramc.versionCode > i) {
        if (paramk.status == 1)
        {
          paramProgressBar.setVisibility(0);
          paramProgressBar.setProgress(paramk.progress);
          paramButton.setVisibility(8);
        }
      }
      for (;;)
      {
        ab.i("MicroMsg.GameActionBtnHandler", "AppId: %s installed, local: %d, server: %d", new Object[] { paramc.field_appId, Integer.valueOf(i), Integer.valueOf(paramc.versionCode) });
        AppMethodBeat.o(111715);
        return;
        if (paramc.scene == 12) {
          paramButton.setText(2131300351);
        }
        for (;;)
        {
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
          break;
          paramButton.setText(2131300332);
        }
        paramButton.setVisibility(0);
        paramProgressBar.setVisibility(8);
        if (paramc.scene == 12) {
          paramButton.setText(2131300349);
        } else {
          paramButton.setText(2131300408);
        }
      }
    }
    if (paramc.bFQ())
    {
      paramButton.setVisibility(0);
      paramProgressBar.setVisibility(8);
      if (paramc.scene == 12)
      {
        paramButton.setText(2131300349);
        AppMethodBeat.o(111715);
        return;
      }
      paramButton.setText(2131300408);
      AppMethodBeat.o(111715);
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
      ab.i("MicroMsg.GameActionBtnHandler", "updateBtnStateAndText: %s, Status: %d, Text: %s", new Object[] { paramc.field_appId, Integer.valueOf(paramc.status), paramButton.getText() });
      AppMethodBeat.o(111715);
      return;
      if (paramk == null)
      {
        paramButton.setVisibility(8);
        paramProgressBar.setVisibility(8);
        AppMethodBeat.o(111715);
        return;
      }
      switch (paramk.status)
      {
      default: 
        break;
      case 0: 
        if (paramc.scene == 12) {
          if (paramc.nmf)
          {
            paramk = paramc.field_appId;
            if (!a(e.ef(this.mContext), paramk)) {
              paramButton.setText(2131300359);
            }
          }
        }
        for (;;)
        {
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
          break;
          paramButton.setText(2131300400);
          continue;
          paramButton.setText(2131300399);
        }
      case 1: 
        if (paramk.mode == 3) {
          paramButton.setText(2131300406);
        }
      case 2: 
      case 3: 
        for (;;)
        {
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
          break;
          if (paramk.mode != 1) {
            break;
          }
          paramProgressBar.setProgress(paramk.progress);
          paramButton.setVisibility(8);
          paramProgressBar.setVisibility(0);
          break;
          if (paramc.scene == 12) {
            paramButton.setText(2131300358);
          }
          for (;;)
          {
            paramButton.setVisibility(0);
            paramProgressBar.setVisibility(8);
            break;
            paramButton.setText(2131300404);
          }
          if (paramc.scene == 12) {
            paramButton.setText(2131300398);
          } else {
            paramButton.setText(2131300397);
          }
        }
        if (paramc.nlY)
        {
          paramButton.setEnabled(false);
          paramButton.setText(2131300330);
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
        }
        else
        {
          paramButton.setText(2131300329);
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
          continue;
          paramButton.setText(2131300328);
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
          continue;
          if (paramk == null)
          {
            paramButton.setText(2131300327);
            paramButton.setVisibility(0);
            paramProgressBar.setVisibility(8);
            AppMethodBeat.o(111715);
            return;
          }
          switch (paramk.status)
          {
          default: 
            break;
          case 0: 
            paramButton.setText(2131300327);
          case 1: 
          case 2: 
          case 3: 
            for (;;)
            {
              paramButton.setVisibility(0);
              paramProgressBar.setVisibility(8);
              break;
              if (paramk.mode == 3)
              {
                paramButton.setText(2131300406);
                break;
              }
              if (paramk.mode != 1) {
                break;
              }
              paramProgressBar.setProgress(paramk.progress);
              paramButton.setVisibility(8);
              paramProgressBar.setVisibility(0);
              break;
              if (paramc.scene == 12) {
                paramButton.setText(2131300358);
              }
              for (;;)
              {
                paramButton.setVisibility(0);
                paramProgressBar.setVisibility(8);
                break;
                paramButton.setText(2131300404);
              }
              if (paramc.scene == 12) {
                paramButton.setText(2131300398);
              } else {
                paramButton.setText(2131300397);
              }
            }
            paramButton.setText(2131300331);
            paramButton.setVisibility(0);
            paramProgressBar.setVisibility(8);
          }
        }
        break;
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.game.model.c paramc, k paramk)
  {
    AppMethodBeat.i(111714);
    if ((paramc == null) || (paramk == null))
    {
      ab.e("MicroMsg.GameActionBtnHandler", "Null appInfo or null downloadInfo");
      AppMethodBeat.o(111714);
      return;
    }
    Object localObject1 = new View(this.mContext);
    ((View)localObject1).setTag(paramc);
    ab.i("MicroMsg.GameActionBtnHandler", "App Status: %d, Download Mode: %d, Download Status: %d", new Object[] { Integer.valueOf(paramc.status), Integer.valueOf(paramk.mode), Integer.valueOf(paramk.status) });
    if ((com.tencent.mm.pluginsdk.model.app.g.u(this.mContext, paramc.field_appId)) || (paramc.bFQ())) {
      paramk.mode = 1;
    }
    int i;
    if (paramk.mode == 3)
    {
      ax.bGV();
      i = ax.k(this.mContext, "com.tencent.android.qqdownloader", paramc.djY);
      ab.i("MicroMsg.GameActionBtnHandler", "qqdownloader install status:[%d], yybSupportedVersionCode:[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramc.djY) });
      if ((i == -1) || (i == 1) || (i == 2)) {
        paramk.mode = 1;
      }
    }
    switch (paramc.status)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(111714);
      return;
      switch (paramk.mode)
      {
      default: 
        ab.d("MicroMsg.GameActionBtnHandler", "summertoken downloadInfo.mode[%d]", new Object[] { Integer.valueOf(paramk.mode) });
        if (this.nvb == null) {
          this.nvb = new h(this.mContext);
        }
        this.nvb.setSourceScene(this.nok);
        this.nvb.eI(this.nuQ, "");
        this.nvb.onClick((View)localObject1);
      }
      while (paramc.nmf)
      {
        localObject1 = e.ef(this.mContext);
        if (!a((Set)localObject1, paramc.field_appId))
        {
          if (paramk.mode != 3)
          {
            paramk = LayoutInflater.from(this.mContext).inflate(2130969759, null);
            ((LinearLayout)paramk.findViewById(2131824644)).setGravity(17);
            localObject2 = (ImageView)paramk.findViewById(2131822985);
            localObject3 = (TextView)paramk.findViewById(2131826150);
            TextView localTextView = (TextView)paramk.findViewById(2131822987);
            ((ImageView)localObject2).setBackgroundResource(2130838569);
            ((TextView)localObject3).setText(2131300381);
            localTextView.setText(2131300380);
            this.dialog = new i(this.mContext, 2131493291);
            this.dialog.setContentView(paramk);
            this.dialog.setCancelable(true);
            this.dialog.setCanceledOnTouchOutside(true);
            this.dialog.show();
            paramk = this.kZH;
            long l = this.nvg;
            paramk.ag(l, l);
          }
          ((com.tencent.mm.plugin.game.api.d)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.d.class)).bEQ();
          com.tencent.mm.plugin.game.model.t.b(paramc.field_appId, 1, 0, null, null);
          ((Set)localObject1).add(paramc.field_appId);
          e.a(this.mContext, (Set)localObject1);
        }
        AppMethodBeat.o(111714);
        return;
        Object localObject2 = f.bjl().JH(paramc.field_appId);
        if ((localObject2 != null) && (((FileDownloadTaskInfo)localObject2).id > 0L)) {
          f.bjl().iz(((FileDownloadTaskInfo)localObject2).id);
        }
        if (this.nvc == null) {
          this.nvc = new u(this.mContext);
        }
        localObject2 = this.nvc;
        i = this.nok;
        Object localObject3 = this.nuQ;
        ((u)localObject2).nok = i;
        ((u)localObject2).nuQ = ((String)localObject3);
        this.nvc.onClick((View)localObject1);
        continue;
        if (!bo.isNullOrNil(paramc.djP))
        {
          ab.i("MicroMsg.GameActionBtnHandler", "gp download url is not null and download flag is download directly by gp store");
          com.tencent.mm.pluginsdk.model.app.q.bw(this.mContext, paramc.djP);
          com.tencent.mm.game.report.c.a(this.mContext, paramc.scene, paramc.cFj, paramc.position, 25, paramc.field_appId, this.nok, paramc.cnG, this.nuQ);
        }
      }
      if (this.nve == null)
      {
        this.nve = new t(this.mContext);
        this.nve.nDC = this.nvf;
      }
      this.nve.nok = this.nok;
      this.nve.onClick((View)localObject1);
      com.tencent.mm.game.report.c.a(this.mContext, paramc.scene, paramc.cFj, paramc.position, 9, paramc.field_appId, this.nok, paramc.cnG, this.nuQ);
      AppMethodBeat.o(111714);
      return;
      paramk = f.bjl().JH(paramc.field_appId);
      if ((paramk != null) && (paramk.id > 0L)) {
        f.bjl().iz(paramk.id);
      }
      if (this.nvd == null) {
        this.nvd = new q(this.mContext);
      }
      this.nvd.ejF = this.nok;
      this.nvd.nCq = paramc.djT;
      this.nvd.onClick((View)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.d
 * JD-Core Version:    0.7.0.1
 */