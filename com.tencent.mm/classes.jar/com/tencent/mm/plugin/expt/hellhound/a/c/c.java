package com.tencent.mm.plugin.expt.hellhound.a.c;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.d.c;
import com.tencent.mm.plugin.expt.b.e.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.dno;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
{
  private static volatile c qYp;
  public final a qYn;
  public d.c qYo;
  private boolean qYq;
  private boolean qYr;
  private boolean qYs;
  
  private c()
  {
    AppMethodBeat.i(122032);
    this.qYq = false;
    this.qYr = false;
    this.qYs = true;
    this.qYn = new a();
    AppMethodBeat.o(122032);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(210436);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cnt()) || (!com.tencent.mm.plugin.expt.hellhound.a.cnu()))
    {
      ad.e("HABBYGE-MALI.HellFrontBackMonitor", "HellFrontBackMonitor monitor close !!!");
      AppMethodBeat.o(210436);
      return;
    }
    ad.i("HABBYGE-MALI.HellFrontBackMonitor", "HellFrontBackMonitor monitor start !!!");
    Object localObject3 = cpn();
    label128:
    label190:
    boolean bool1;
    label288:
    label373:
    Object localObject4;
    Object localObject2;
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(210436);
      return;
    case 100: 
    case 101: 
    case 102: 
    case 103: 
      if (!TextUtils.isEmpty(paramString)) {}
      switch (paramInt1)
      {
      default: 
        AppMethodBeat.o(210436);
        return;
      case 100: 
        if (!TextUtils.isEmpty(paramString))
        {
          ad.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeBack2Front: %s, %s", new Object[] { paramString, Integer.valueOf(paramInt2) });
          if ((!com.tencent.mm.plugin.expt.hellhound.a.e.a.cpz()) || (com.tencent.mm.plugin.expt.hellhound.a.e.a.cpx() == -1)) {
            break label288;
          }
          ad.i("HABBYGE-MALI.HellFrontBackMonitor", "HellFrontToBackMonitor, judgeBack2Front, requestPermission !!");
          com.tencent.mm.plugin.expt.hellhound.a.e.a.cpy();
          com.tencent.mm.plugin.expt.hellhound.a.e.a.lb(false);
        }
        for (;;)
        {
          localObject3 = a.cpm();
          Object localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = new atr();
          }
          if (com.tencent.mm.plugin.expt.hellhound.core.b.cnC()) {
            ((atr)localObject1).GrH = Process.myPid();
          }
          ((atr)localObject1).GrI = paramString;
          ((atr)localObject1).aHQ = paramInt2;
          ((atr)localObject1).GrG = System.currentTimeMillis();
          ad.d("HABBYGE-MALI.FrontBackDao", "setLastMMProcessParamsOnResume: %s, %d", new Object[] { ((atr)localObject1).GrI, Integer.valueOf(((atr)localObject1).inh) });
          a.a((atr)localObject1);
          AppMethodBeat.o(210436);
          return;
          if (((c)localObject3).aer(paramString))
          {
            ad.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeBack2Front: _launchWx TRUE");
            com.tencent.mm.plugin.expt.hellhound.core.b.a.a.CS(7);
            a.Di(7);
            ((c)localObject3).t(paramString, paramInt2, paramLong);
          }
          else
          {
            ad.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeBack2Front: _launchWx FALSE");
            try
            {
              bool1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cod().qRB.adX(paramString);
              ad.i("HABBYGE-MALI.HellFrontBackMonitor", "_doIsBackToFront isStartActivity: %b", new Object[] { Boolean.valueOf(bool1) });
              if (!bool1) {
                break;
              }
              paramInt1 = 0;
            }
            catch (Exception localException)
            {
              ad.printErrStackTrace("HABBYGE-MALI.HellFrontBackMonitor", localException, "backToFront crash", new Object[0]);
              g.yhR.idkeyStat(932L, 44L, 1L, false);
            }
            if (paramInt1 == 0) {
              break label769;
            }
            ad.i("HABBYGE-MALI.HellFrontBackMonitor", "backToFront: isFrontToBackOfLastAction: YES");
            com.tencent.mm.plugin.expt.hellhound.core.b.a.a.CS(7);
            a.Di(7);
            ((c)localObject3).t(paramString, paramInt2, paramLong);
          }
        }
        bool1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cod().qRB.cnZ();
        ad.i("HABBYGE-MALI.HellFrontBackMonitor", "_doIsBackToFront isFinish: %b", new Object[] { Boolean.valueOf(bool1) });
        if (bool1)
        {
          paramInt1 = 0;
        }
        else
        {
          if (!TextUtils.isEmpty(paramString))
          {
            com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
            localObject4 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnU();
            if (localObject4 != null)
            {
              localObject2 = (String)((com.tencent.mm.vending.j.b)localObject4).get(0);
              localObject4 = (Integer)((com.tencent.mm.vending.j.c)localObject4).get(1);
              if (localObject4 == null) {}
              for (paramInt1 = -1;; paramInt1 = ((Integer)localObject4).intValue())
              {
                localObject4 = Integer.valueOf(paramInt1);
                ad.i("HABBYGE-MALI.HellFrontBackMonitor", "_doIsBackToFront resume: %s, %s, %s, %s", new Object[] { paramString, Integer.valueOf(paramInt2), localObject2, localObject4 });
                if (!paramString.equals(localObject2)) {
                  break label1771;
                }
                if (paramInt2 == ((Integer)localObject4).intValue()) {
                  break;
                }
                break label1771;
              }
            }
          }
          if (com.tencent.mm.plugin.expt.hellhound.core.b.adB(paramString))
          {
            ad.e("HABBYGE-MALI.HellFrontBackMonitor", "_doIsBackToFront 7事件，过滤小程序");
            paramInt1 = 0;
          }
          else
          {
            ad.i("HABBYGE-MALI.HellFrontBackMonitor", "_doIsBackToFront ret: true");
            paramInt1 = 1;
            break label1762;
            label628:
            localObject2 = a.cpm();
            if ((localObject2 == null) || (((atr)localObject2).GrF != 8)) {
              break label1781;
            }
          }
        }
        break;
      }
      break;
    }
    label769:
    label974:
    label1757:
    label1762:
    label1771:
    label1774:
    label1776:
    label1781:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        ad.i("HABBYGE-MALI.HellFrontBackMonitor", "isFrontToBackAction.lastAction: true");
        if (com.tencent.mm.plugin.expt.hellhound.core.b.adF(paramString))
        {
          ad.i("HABBYGE-MALI.HellFrontBackMonitor", "_isBackToFront 过滤掉第三方App进入微信的场景: %s", new Object[] { paramString });
          break label1776;
        }
        ((c)localObject3).qYr = true;
        paramInt1 = 1;
        break label373;
      }
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
      localObject4 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnU();
      localObject2 = null;
      if (localObject4 != null) {
        localObject2 = (String)((com.tencent.mm.vending.j.b)localObject4).get(0);
      }
      if ((!TextUtils.isEmpty(paramString)) && (TextUtils.isEmpty((CharSequence)localObject2)))
      {
        ad.i("HABBYGE-MALI.HellFrontBackMonitor", "HellFrontBackMonitor _isBackToFront: crash路径 !!!");
        g.yhR.idkeyStat(932L, 98L, 1L, false);
        paramInt1 = 1;
        break label373;
        ad.i("HABBYGE-MALI.HellFrontBackMonitor", "backToFront: isFrontToBackOfLastAction: FALSE");
        break label190;
        ad.i("HABBYGE-MALI.HellFrontBackMonitor", "frontBack ACTION_PAUSE: %s", new Object[] { paramString });
        boolean bool2 = false;
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cnW();
        bool1 = bool2;
        if (localObject2 != null)
        {
          ad.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnPause topActivity: %s, %s", new Object[] { ((bj)localObject2).Fti.activityName, Integer.valueOf(((bj)localObject2).Fti.aHQ) });
          if (((bj)localObject2).Fti.activityName.startsWith("com.tencent.mm")) {
            break label974;
          }
          ad.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnPause 栈顶非微信页面: %s", new Object[] { ((bj)localObject2).Fti.activityName });
          bool1 = true;
        }
        for (;;)
        {
          ad.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnPause: is8Event: %b", new Object[] { Boolean.valueOf(bool1) });
          if (bool1) {
            break label1068;
          }
          bool1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cod().qRB.coa();
          ad.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnPause.startActivity: %b, %s", new Object[] { Boolean.valueOf(bool1), paramString });
          if (!bool1) {
            break;
          }
          ((c)localObject3).qYs = false;
          AppMethodBeat.o(210436);
          return;
          bool1 = bool2;
          if ("com.tencent.mm.ui.transmit.SendAppMessageWrapperUI".equals(((bj)localObject2).Fti.activityName))
          {
            bool1 = bool2;
            if ("com.tencent.mm.plugin.sns.ui.SnsUploadUI".equals(paramString)) {
              bool1 = true;
            }
          }
        }
        bool1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cod().qRB.adY(paramString);
        ad.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnPause.finish: %b, %s", new Object[] { Boolean.valueOf(bool1), paramString });
        if (bool1)
        {
          ((c)localObject3).qYs = false;
          AppMethodBeat.o(210436);
          return;
        }
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.CT(104);
        localObject4 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.CT(105);
        ad.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFrontToBackOnPause: %s, %s", new Object[] { localObject2, localObject4 });
        if ((com.tencent.mm.plugin.expt.hellhound.core.b.adu((String)localObject2)) && (com.tencent.mm.plugin.expt.hellhound.core.b.ads((String)localObject4)))
        {
          ad.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFrontToBackOnPause, SelectContactUI NOT 8-Event !!");
          AppMethodBeat.o(210436);
          return;
        }
        if ((com.tencent.mm.plugin.expt.hellhound.core.b.adt((String)localObject2)) || (com.tencent.mm.plugin.expt.hellhound.core.b.adu((String)localObject4)))
        {
          ad.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFrontToBackOnPause, GroupCardSelectUI NOT 8-Event !!");
          AppMethodBeat.o(210436);
          return;
        }
        if ((!com.tencent.mm.plugin.expt.hellhound.core.b.ads(paramString)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.adK((String)localObject2)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.ads((String)localObject4)))
        {
          if (com.tencent.mm.plugin.expt.hellhound.a.e.a.cpx() != -1)
          {
            com.tencent.mm.plugin.expt.hellhound.a.e.a.lb(true);
            ad.i("HABBYGE-MALI.HellFrontBackMonitor", "HellFrontToBackMonitor, judgeFrontToBackOnPause, requestPermission !!");
            AppMethodBeat.o(210436);
            return;
          }
          ad.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnPause front2back YES: %s", new Object[] { paramString });
          com.tencent.mm.plugin.expt.hellhound.core.b.a.a.CS(8);
          a.Di(8);
          ((c)localObject3).qYs = true;
          ((c)localObject3).u(paramString, paramInt2, paramLong);
        }
        AppMethodBeat.o(210436);
        return;
        ad.i("HABBYGE-MALI.HellFrontBackMonitor", "frontBack ACTION_STOP: %s", new Object[] { paramString });
        if (TextUtils.isEmpty(paramString))
        {
          ad.e("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnStop == null");
          AppMethodBeat.o(210436);
          return;
        }
        if (((c)localObject3).qYs)
        {
          ad.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnStop isFront2Back-1: true");
          AppMethodBeat.o(210436);
          return;
        }
        ad.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnStop stopActivityName: %s", new Object[] { paramString });
        try
        {
          localObject2 = de(paramString, paramInt2);
          if ((localObject2 == null) || (!((Boolean)((com.tencent.mm.vending.j.d)localObject2).get(2)).booleanValue()))
          {
            ad.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnStop: false");
            AppMethodBeat.o(210436);
            return;
          }
          ad.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnStop, 7-event: %s, TRUE", new Object[] { (String)((com.tencent.mm.vending.j.b)localObject2).get(0) });
          com.tencent.mm.plugin.expt.hellhound.core.b.a.a.CS(8);
          a.Di(8);
          ((c)localObject3).u(paramString, paramInt2, paramLong);
          AppMethodBeat.o(210436);
          return;
        }
        catch (Exception paramString)
        {
          ad.printErrStackTrace("HABBYGE-MALI.HellFrontBackMonitor", paramString, "judgeFront2BackOnStop crash", new Object[0]);
          g.yhR.idkeyStat(932L, 42L, 1L, false);
          AppMethodBeat.o(210436);
          return;
        }
        ad.i("HABBYGE-MALI.HellFrontBackMonitor", "frontBack ACTION_FINISH: %s", new Object[] { paramString });
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
        if (paramString == null) {}
        for (;;)
        {
          try
          {
            ad.e("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnFinish: aName == null");
            localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnT();
            if (localObject2 != null)
            {
              paramString = (String)((com.tencent.mm.vending.j.b)localObject2).get(0);
              ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
            }
            paramInt1 = 0;
            ad.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnFinish activity==null: %s", new Object[] { paramString });
            if ((paramInt1 != 0) && (com.tencent.mm.plugin.expt.hellhound.core.b.ads(paramString)))
            {
              ad.i("HABBYGE-MALI.HellFrontBackMonitor", "shutdown && isLauncherUI");
              localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnU();
              if (localObject2 == null) {
                break label1757;
              }
              localObject2 = (String)((com.tencent.mm.vending.j.b)localObject2).get(0);
              ad.i("HABBYGE-MALI.HellFrontBackMonitor", "_quiteActivity.pause = %s", new Object[] { localObject2 });
              if (!"com.tencent.mm.plugin.setting.ui.setting.SettingsUI".equals(localObject2)) {
                break label1757;
              }
              paramInt1 = 1;
              if (paramInt1 != 0)
              {
                a.Di(8);
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.CS(8);
                ((c)localObject3).u(paramString, paramInt2, paramLong);
              }
            }
            AppMethodBeat.o(210436);
            return;
          }
          catch (Exception paramString)
          {
            ad.printErrStackTrace("HABBYGE-MALI.HellFrontBackMonitor", paramString, "judgeFront2BackOnFinish", new Object[0]);
            g.yhR.idkeyStat(932L, 40L, 1L, false);
          }
          paramInt1 = 1;
          ad.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnFinish: %s", new Object[] { paramString });
          continue;
          break label128;
          if (!com.tencent.mm.plugin.expt.hellhound.core.b.cnC()) {
            break;
          }
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().CR(600);
          AppMethodBeat.o(210436);
          return;
          ad.i("HABBYGE-MALI.HellFrontBackMonitor", "HellFrontBackMonitor, ACTION_add7Event_login");
          d.a("login", e.a.qPh, 1, paramLong);
          AppMethodBeat.o(210436);
          return;
          ad.i("HABBYGE-MALI.HellFrontBackMonitor", "HellFrontBackMonitor, ACTION_add8Event_logout");
          d.a("logout", e.a.qPi, -1, paramLong);
          break;
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 == 0) {
            break label1774;
          }
          paramInt1 = 1;
          break;
          paramInt1 = 0;
        }
        break label628;
      }
      paramInt1 = 0;
      break label373;
    }
  }
  
  private boolean aer(String paramString)
  {
    AppMethodBeat.i(122034);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
    try
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnU();
      if (localObject == null) {
        break label102;
      }
      localObject = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
    }
    catch (Exception localException)
    {
      CharSequence localCharSequence;
      for (;;)
      {
        Object localObject;
        g.yhR.idkeyStat(932L, 45L, 1L, false);
        localCharSequence = null;
      }
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.adv(paramString)) || (!TextUtils.isEmpty(localCharSequence))) {
        break label137;
      }
      ad.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx 启动微信进程 1");
      AppMethodBeat.o(122034);
      return true;
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.adv(paramString)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.adw(localCharSequence))) {
        break label167;
      }
      ad.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx 启动微信进程 splash hook restart ~");
      AppMethodBeat.o(122034);
      return true;
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.ads(paramString)) || (!TextUtils.isEmpty(localCharSequence))) {
        break label197;
      }
      ad.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx 启动微信进程 2");
      AppMethodBeat.o(122034);
      return true;
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.adv(localCharSequence)) || (com.tencent.mm.plugin.expt.hellhound.core.b.adF(paramString)) || ("com.tencent.mm.plugin.base.stub.UIEntryStub".equals(paramString)) || ("com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI".equals(paramString))) {
        break label247;
      }
      ad.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx 启动微信进程 3");
      AppMethodBeat.o(122034);
      return true;
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.adv(localCharSequence)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.ads(paramString))) {
        break label282;
      }
      this.qYq = true;
      ad.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx 启动微信进程 4");
      AppMethodBeat.o(122034);
      return true;
      if ((!"com.tencent.mm.ui.tools.ShareToTimeLineUI".equals(paramString)) || (localCharSequence != null)) {
        break label312;
      }
      ad.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx: frome outer jump to Timeline");
      AppMethodBeat.o(122034);
      return true;
      if ((!"com.tencent.mm.ui.tools.AddFavoriteUI".equals(paramString)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.adv(localCharSequence))) {
        break label345;
      }
      ad.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx: from outer jump to 收藏");
      AppMethodBeat.o(122034);
      return true;
      if (!aes(paramString)) {
        break label368;
      }
      ad.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx 启动微信进程 通过小程序桌面快捷方式");
      AppMethodBeat.o(122034);
      return true;
      if (!"com.tencent.mm.plugin.base.stub.UIEntryStub".equals(paramString)) {
        break label394;
      }
      ad.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx 启动微信进程 通过第三方拉起微信(第三方登录、分享好友、朋友圈)");
      AppMethodBeat.o(122034);
      return true;
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.adA(paramString)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.ads(localCharSequence))) {
        break label428;
      }
      ad.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx 启动微信进程 之前登录过，登录页");
      if (!this.qYq) {
        break label436;
      }
      this.qYq = false;
      AppMethodBeat.o(122034);
      return false;
    }
    ad.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx resume/pause: %s, %s", new Object[] { paramString, localObject });
    if (("com.tencent.mm.plugin.voip.ui.VideoActivity".equals(paramString)) && ((TextUtils.isEmpty((CharSequence)localObject)) || (com.tencent.mm.plugin.expt.hellhound.core.b.adv((String)localObject))))
    {
      ad.i("HABBYGE-MALI.HellFrontBackMonitor", "VOIP start MM Process");
      AppMethodBeat.o(122034);
      return true;
    }
    label102:
    label247:
    while (this.qYr) {
      this.qYr = false;
    }
    label137:
    label167:
    label197:
    label345:
    label368:
    AppMethodBeat.o(122034);
    label282:
    label312:
    return true;
  }
  
  private static boolean aes(String paramString)
  {
    AppMethodBeat.i(122035);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
    label77:
    CharSequence localCharSequence;
    try
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnU();
      if (localObject == null) {
        break label77;
      }
      localObject = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        ad.printErrStackTrace("HABBYGE-MALI.HellFrontBackMonitor", localException, "isStartWxByLittlePragramShortcut", new Object[0]);
        localCharSequence = null;
        continue;
        i = 0;
      }
      label87:
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.adB(paramString)) || (!TextUtils.isEmpty(localCharSequence))) {
        break label123;
      }
      label123:
      for (int i = 1; i != 0; i = 0)
      {
        ad.i("HABBYGE-MALI.HellFrontBackMonitor", "isStartWxByLittlePragramShortcut case-2");
        AppMethodBeat.o(122035);
        return true;
      }
      if (!com.tencent.mm.plugin.expt.hellhound.core.b.adB(paramString)) {
        break label164;
      }
    }
    if ((com.tencent.mm.plugin.expt.hellhound.core.b.adB(paramString)) && (com.tencent.mm.plugin.expt.hellhound.core.b.adE((String)localObject)))
    {
      i = 1;
      if (i == 0) {
        break label87;
      }
      ad.i("HABBYGE-MALI.HellFrontBackMonitor", "isStartWxByLittlePragramShortcut case-1");
      AppMethodBeat.o(122035);
      return true;
    }
    if (com.tencent.mm.plugin.expt.hellhound.core.b.adv(localCharSequence)) {}
    label164:
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        ad.i("HABBYGE-MALI.HellFrontBackMonitor", "isStartWxByLittlePragramShortcut case-3");
      }
      AppMethodBeat.o(122035);
      return bool;
    }
  }
  
  public static c cpn()
  {
    AppMethodBeat.i(122031);
    if (qYp == null) {}
    try
    {
      if (qYp == null) {
        qYp = new c();
      }
      c localc = qYp;
      AppMethodBeat.o(122031);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(122031);
    }
  }
  
  private static com.tencent.mm.vending.j.d<String, Integer, Boolean> de(String paramString, int paramInt)
  {
    AppMethodBeat.i(210437);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
    for (;;)
    {
      int i;
      int j;
      boolean bool1;
      try
      {
        Object localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnT();
        Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnU();
        if ((paramString == null) || (localObject2 == null) || (localObject1 == null))
        {
          ad.e("HABBYGE-MALI.HellFrontBackMonitor", "isFront2BackOnStop: illeagal Event");
          AppMethodBeat.o(210437);
          return null;
        }
        String str = (String)((com.tencent.mm.vending.j.b)localObject2).get(0);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.adG(str))
        {
          ad.i("HABBYGE-MALI.HellFrontBackMonitor", "isFakeSwitchAccountUI true");
          AppMethodBeat.o(210437);
          return null;
        }
        ad.i("HABBYGE-MALI.HellFrontBackMonitor", "isFront2BackOnStop: Resume: %s, Pause: %s, Stop: %s", new Object[] { localObject2, localObject1, paramString });
        localObject2 = (Integer)((com.tencent.mm.vending.j.c)localObject2).get(1);
        Integer localInteger = (Integer)((com.tencent.mm.vending.j.c)localObject1).get(1);
        if ((localObject2 != null) && (localInteger != null))
        {
          if ((paramInt == ((Integer)localObject2).intValue()) && (paramInt == localInteger.intValue()))
          {
            i = 1;
            if ((paramString.equals(str)) && (paramString.equals(((com.tencent.mm.vending.j.b)localObject1).get(0))))
            {
              j = 1;
              break label468;
              ad.i("HABBYGE-MALI.HellFrontBackMonitor", "isFront2BackOnStop, case-1：%b", new Object[] { Boolean.valueOf(bool1) });
              bool2 = bool1;
              if (bool1)
              {
                bool2 = bool1;
                if (!com.tencent.mm.plugin.expt.hellhound.core.b.adH(paramString))
                {
                  bool2 = bool1;
                  if (!com.tencent.mm.plugin.expt.hellhound.core.b.adI(paramString))
                  {
                    localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cnW();
                    bool2 = bool1;
                    if (localObject1 != null)
                    {
                      ad.i("HABBYGE-MALI.HellFrontBackMonitor", "isFront2BackOnStop isEvent8: %s, %s", new Object[] { ((bj)localObject1).Fti.activityName, Integer.valueOf(((bj)localObject1).Fti.aHQ) });
                      if (!((bj)localObject1).Fti.activityName.startsWith("com.tencent.mm")) {
                        continue;
                      }
                      bool2 = bool1;
                      if (((bj)localObject1).Fti.aHQ <= 0)
                      {
                        bool2 = bool1;
                        if (!((bj)localObject1).Fti.activityName.equals(paramString))
                        {
                          ad.i("HABBYGE-MALI.HellFrontBackMonitor", "isFront2BackOnStop isEvent8-1: false");
                          bool2 = false;
                        }
                      }
                    }
                  }
                }
              }
              ad.i("HABBYGE-MALI.HellFrontBackMonitor", "isFront2BackOnStop case1 && case2：%b", new Object[] { Boolean.valueOf(bool2) });
              paramString = com.tencent.mm.vending.j.a.i(paramString, Integer.valueOf(paramInt), Boolean.valueOf(bool2));
              AppMethodBeat.o(210437);
              return paramString;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          j = 0;
          break label468;
          bool1 = false;
          continue;
          ad.i("HABBYGE-MALI.HellFrontBackMonitor", "isFront2BackOnStop: NOT wx activity");
          boolean bool2 = bool1;
          continue;
        }
        i = 0;
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("HABBYGE-MALI.HellFrontBackMonitor", paramString, "isFront2BackOnStop", new Object[0]);
        g.yhR.idkeyStat(932L, 43L, 1L, false);
        AppMethodBeat.o(210437);
        return null;
      }
      continue;
      label468:
      if ((j != 0) && (i != 0)) {
        bool1 = true;
      }
    }
  }
  
  private void t(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210438);
    if (this.qYo != null) {
      this.qYo.j(paramString, paramInt, paramLong);
    }
    AppMethodBeat.o(210438);
  }
  
  private void u(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210439);
    if (this.qYo != null) {
      this.qYo.k(paramString, paramInt, paramLong);
    }
    AppMethodBeat.o(210439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.c.c
 * JD-Core Version:    0.7.0.1
 */