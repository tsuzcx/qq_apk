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
import com.tencent.mm.h.c.r;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.g.d;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.g.j;
import com.tencent.mm.plugin.game.model.ay;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.i;
import java.util.Set;

public final class d
{
  private static Object lock = new Object();
  private am iRj = new am(Looper.getMainLooper(), new d.1(this), false);
  int kQh = 0;
  String kWO = null;
  private h kWZ = null;
  private u kXa = null;
  private q kXb = null;
  private t kXc = null;
  DialogInterface.OnClickListener kXd = null;
  private Dialog kXe;
  private int kXf = 3000;
  private Context mContext;
  
  public d(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private static boolean a(Set<String> paramSet, String paramString)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {}
    while (!paramSet.contains(paramString)) {
      return false;
    }
    return true;
  }
  
  public final void a(ProgressBar paramProgressBar, Button paramButton, com.tencent.mm.plugin.game.model.d paramd, l paraml)
  {
    if ((paramProgressBar == null) || (paramButton == null)) {
      return;
    }
    paramButton.setEnabled(true);
    paramButton.setVisibility(0);
    if (paramd.status == 1)
    {
      if (paramd.kOb)
      {
        paramButton.setEnabled(false);
        paramButton.setText(g.i.game_action_subscribed);
        paramButton.setVisibility(0);
        paramProgressBar.setVisibility(8);
        return;
      }
      paramButton.setText(g.i.game_action_subscribe);
      paramButton.setVisibility(0);
      paramProgressBar.setVisibility(8);
      return;
    }
    if (com.tencent.mm.pluginsdk.model.app.g.a(this.mContext, paramd))
    {
      int i = c.Fe(paramd.field_packageName);
      if (paramd.versionCode > i) {
        if (paraml.status == 1)
        {
          paramProgressBar.setVisibility(0);
          paramProgressBar.setProgress(paraml.progress);
          paramButton.setVisibility(8);
        }
      }
      for (;;)
      {
        y.i("MicroMsg.GameActionBtnHandler", "AppId: %s installed, local: %d, server: %d", new Object[] { paramd.field_appId, Integer.valueOf(i), Integer.valueOf(paramd.versionCode) });
        return;
        if (paramd.scene == 12) {
          paramButton.setText(g.i.game_detail_rank_update);
        }
        for (;;)
        {
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
          break;
          paramButton.setText(g.i.game_action_update);
        }
        paramButton.setVisibility(0);
        paramProgressBar.setVisibility(8);
        if (paramd.scene == 12) {
          paramButton.setText(g.i.game_detail_rank_launch);
        } else {
          paramButton.setText(g.i.game_list_launch);
        }
      }
    }
    if (paramd.aYR())
    {
      paramButton.setVisibility(0);
      paramProgressBar.setVisibility(8);
      if (paramd.scene == 12)
      {
        paramButton.setText(g.i.game_detail_rank_launch);
        return;
      }
      paramButton.setText(g.i.game_list_launch);
      return;
    }
    switch (paramd.status)
    {
    default: 
      paramButton.setVisibility(8);
      paramProgressBar.setVisibility(8);
    }
    for (;;)
    {
      y.i("MicroMsg.GameActionBtnHandler", "updateBtnStateAndText: %s, Status: %d, Text: %s", new Object[] { paramd.field_appId, Integer.valueOf(paramd.status), paramButton.getText() });
      return;
      if (paraml == null)
      {
        paramButton.setVisibility(8);
        paramProgressBar.setVisibility(8);
        return;
      }
      switch (paraml.status)
      {
      default: 
        break;
      case 0: 
        if (paramd.scene == 12) {
          if (paramd.kOi)
          {
            paraml = paramd.field_appId;
            if (!a(f.ds(this.mContext), paraml)) {
              paramButton.setText(g.i.game_download_gift);
            }
          }
        }
        for (;;)
        {
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
          break;
          paramButton.setText(g.i.game_list_download_app);
          continue;
          paramButton.setText(g.i.game_list_download);
        }
      case 1: 
        if (paraml.mode == 3) {
          paramButton.setText(g.i.game_list_download_view);
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
          if (paramd.scene == 12) {
            paramButton.setText(g.i.game_download_continue_task);
          }
          for (;;)
          {
            paramButton.setVisibility(0);
            paramProgressBar.setVisibility(8);
            break;
            paramButton.setText(g.i.game_list_download_continue);
          }
          if (paramd.scene == 12) {
            paramButton.setText(g.i.game_list_app_install_btn);
          } else {
            paramButton.setText(g.i.game_list_app_install);
          }
        }
        if (paramd.kOb)
        {
          paramButton.setEnabled(false);
          paramButton.setText(g.i.game_action_subscribed);
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
        }
        else
        {
          paramButton.setText(g.i.game_action_subscribe);
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
          continue;
          paramButton.setText(g.i.game_action_preemptive);
          paramButton.setVisibility(0);
          paramProgressBar.setVisibility(8);
          continue;
          if (paraml == null)
          {
            paramButton.setText(g.i.game_action_grab);
            paramButton.setVisibility(0);
            paramProgressBar.setVisibility(8);
            return;
          }
          switch (paraml.status)
          {
          default: 
            break;
          case 0: 
            paramButton.setText(g.i.game_action_grab);
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
                paramButton.setText(g.i.game_list_download_view);
                break;
              }
              if (paraml.mode != 1) {
                break;
              }
              paramProgressBar.setProgress(paraml.progress);
              paramButton.setVisibility(8);
              paramProgressBar.setVisibility(0);
              break;
              if (paramd.scene == 12) {
                paramButton.setText(g.i.game_download_continue_task);
              }
              for (;;)
              {
                paramButton.setVisibility(0);
                paramProgressBar.setVisibility(8);
                break;
                paramButton.setText(g.i.game_list_download_continue);
              }
              if (paramd.scene == 12) {
                paramButton.setText(g.i.game_list_app_install_btn);
              } else {
                paramButton.setText(g.i.game_list_app_install);
              }
            }
            paramButton.setText(g.i.game_action_trial);
            paramButton.setVisibility(0);
            paramProgressBar.setVisibility(8);
          }
        }
        break;
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.game.model.d paramd, l paraml)
  {
    if ((paramd == null) || (paraml == null))
    {
      y.e("MicroMsg.GameActionBtnHandler", "Null appInfo or null downloadInfo");
      return;
    }
    Object localObject1 = new View(this.mContext);
    ((View)localObject1).setTag(paramd);
    y.i("MicroMsg.GameActionBtnHandler", "App Status: %d, Download Mode: %d, Download Status: %d", new Object[] { Integer.valueOf(paramd.status), Integer.valueOf(paraml.mode), Integer.valueOf(paraml.status) });
    if ((com.tencent.mm.pluginsdk.model.app.g.o(this.mContext, paramd.field_appId)) || (paramd.aYR())) {
      paraml.mode = 1;
    }
    int i;
    if (paraml.mode == 3)
    {
      ay.aZP();
      i = ay.h(this.mContext, "com.tencent.android.qqdownloader", paramd.cvN);
      y.i("MicroMsg.GameActionBtnHandler", "qqdownloader install status:[%d], yybSupportedVersionCode:[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramd.cvN) });
      if ((i == -1) || (i == 1) || (i == 2)) {
        paraml.mode = 1;
      }
    }
    switch (paramd.status)
    {
    default: 
      return;
    case 0: 
    case 3: 
    case 4: 
      switch (paraml.mode)
      {
      default: 
        y.d("MicroMsg.GameActionBtnHandler", "summertoken downloadInfo.mode[%d]", new Object[] { Integer.valueOf(paraml.mode) });
        if (this.kWZ == null) {
          this.kWZ = new h(this.mContext);
        }
        this.kWZ.setSourceScene(this.kQh);
        this.kWZ.dr(this.kWO, "");
        this.kWZ.onClick((View)localObject1);
      }
      while (paramd.kOi)
      {
        localObject1 = f.ds(this.mContext);
        if (a((Set)localObject1, paramd.field_appId)) {
          break;
        }
        if (paraml.mode != 3)
        {
          paraml = LayoutInflater.from(this.mContext).inflate(g.f.game_gift_tips, null);
          ((LinearLayout)paraml.findViewById(g.e.mm_alert_msg_area)).setGravity(17);
          localObject2 = (ImageView)paraml.findViewById(g.e.mm_alert_msg_icon);
          localObject3 = (TextView)paraml.findViewById(g.e.mm_alert_msg);
          TextView localTextView = (TextView)paraml.findViewById(g.e.mm_alert_msg_subdesc);
          ((ImageView)localObject2).setBackgroundResource(g.d.download_gift);
          ((TextView)localObject3).setText(g.i.game_gift_title);
          localTextView.setText(g.i.game_gift_content);
          this.kXe = new i(this.mContext, g.j.GameNoticStyle);
          this.kXe.setContentView(paraml);
          this.kXe.setCancelable(true);
          this.kXe.setCanceledOnTouchOutside(true);
          this.kXe.show();
          paraml = this.iRj;
          long l = this.kXf;
          paraml.S(l, l);
        }
        ((com.tencent.mm.plugin.game.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.b.class)).aYd();
        com.tencent.mm.plugin.game.model.u.b(paramd.field_appId, 1, 0, null, null);
        ((Set)localObject1).add(paramd.field_appId);
        f.a(this.mContext, (Set)localObject1);
        return;
        Object localObject2 = com.tencent.mm.plugin.downloader.model.d.aFP().zL(paramd.field_appId);
        if ((localObject2 != null) && (((FileDownloadTaskInfo)localObject2).id > 0L)) {
          com.tencent.mm.plugin.downloader.model.d.aFP().dc(((FileDownloadTaskInfo)localObject2).id);
        }
        if (this.kXa == null) {
          this.kXa = new u(this.mContext);
        }
        localObject2 = this.kXa;
        i = this.kQh;
        Object localObject3 = this.kWO;
        ((u)localObject2).kQh = i;
        ((u)localObject2).kWO = ((String)localObject3);
        this.kXa.onClick((View)localObject1);
        continue;
        if (!bk.bl(paramd.cvE))
        {
          y.i("MicroMsg.GameActionBtnHandler", "gp download url is not null and download flag is download directly by gp store");
          com.tencent.mm.pluginsdk.model.app.q.bk(this.mContext, paramd.cvE);
          com.tencent.mm.plugin.game.e.b.a(this.mContext, paramd.scene, paramd.bXn, paramd.position, 25, paramd.field_appId, this.kQh, paramd.bGy, this.kWO);
        }
      }
    case 1: 
      if (this.kXc == null)
      {
        this.kXc = new t(this.mContext);
        this.kXc.lfH = this.kXd;
      }
      this.kXc.kQh = this.kQh;
      this.kXc.onClick((View)localObject1);
      com.tencent.mm.plugin.game.e.b.a(this.mContext, paramd.scene, paramd.bXn, paramd.position, 9, paramd.field_appId, this.kQh, paramd.bGy, this.kWO);
      return;
    }
    paraml = com.tencent.mm.plugin.downloader.model.d.aFP().zL(paramd.field_appId);
    if ((paraml != null) && (paraml.id > 0L)) {
      com.tencent.mm.plugin.downloader.model.d.aFP().dc(paraml.id);
    }
    if (this.kXb == null) {
      this.kXb = new q(this.mContext);
    }
    this.kXb.drX = this.kQh;
    this.kXb.lev = paramd.cvI;
    this.kXb.onClick((View)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.d
 * JD-Core Version:    0.7.0.1
 */