package com.tencent.mm.plugin.expt.hellhound.a.c;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.d.c;
import com.tencent.mm.plugin.expt.b.e.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bl;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.esj;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  private static volatile c wnM;
  public final a wnK;
  public d.c wnL;
  private boolean wnN;
  private boolean wnO;
  private boolean wnP;
  
  private c()
  {
    AppMethodBeat.i(122032);
    this.wnN = false;
    this.wnO = false;
    this.wnP = true;
    this.wnK = new a();
    AppMethodBeat.o(122032);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(251290);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.dcg()) || (!com.tencent.mm.plugin.expt.hellhound.a.dch()))
    {
      Log.e("HABBYGE-MALI.HellFrontBackMonitor", "HellFrontBackMonitor monitor close !!!");
      AppMethodBeat.o(251290);
      return;
    }
    Log.i("HABBYGE-MALI.HellFrontBackMonitor", "HellFrontBackMonitor monitor start !!!");
    Object localObject3 = der();
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
      AppMethodBeat.o(251290);
      return;
    case 100: 
    case 101: 
    case 102: 
    case 103: 
      if (!TextUtils.isEmpty(paramString)) {}
      switch (paramInt1)
      {
      default: 
        AppMethodBeat.o(251290);
        return;
      case 100: 
        if (!TextUtils.isEmpty(paramString))
        {
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeBack2Front: %s, %s", new Object[] { paramString, Integer.valueOf(paramInt2) });
          if ((!com.tencent.mm.plugin.expt.hellhound.a.e.a.deD()) || (com.tencent.mm.plugin.expt.hellhound.a.e.a.deB() == -1)) {
            break label288;
          }
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "HellFrontToBackMonitor, judgeBack2Front, requestPermission !!");
          com.tencent.mm.plugin.expt.hellhound.a.e.a.deC();
          com.tencent.mm.plugin.expt.hellhound.a.e.a.nw(false);
        }
        for (;;)
        {
          localObject3 = a.deq();
          Object localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = new bmr();
          }
          if (com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess()) {
            ((bmr)localObject1).SXA = Process.myPid();
          }
          ((bmr)localObject1).SXB = paramString;
          ((bmr)localObject1).aNf = paramInt2;
          ((bmr)localObject1).SXz = System.currentTimeMillis();
          Log.d("HABBYGE-MALI.FrontBackDao", "setLastMMProcessParamsOnResume: %s, %d", new Object[] { ((bmr)localObject1).SXB, Integer.valueOf(((bmr)localObject1).mbp) });
          a.a((bmr)localObject1);
          AppMethodBeat.o(251290);
          return;
          if (((c)localObject3).axY(paramString))
          {
            Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeBack2Front: _launchWx TRUE");
            com.tencent.mm.plugin.expt.hellhound.core.b.a.a.KA(7);
            a.KS(7);
            ((c)localObject3).s(paramString, paramInt2, paramLong);
          }
          else
          {
            Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeBack2Front: _launchWx FALSE");
            try
            {
              bool1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.dcQ().wfK.axh(paramString);
              Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_doIsBackToFront isStartActivity: %b", new Object[] { Boolean.valueOf(bool1) });
              if (!bool1) {
                break;
              }
              paramInt1 = 0;
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("HABBYGE-MALI.HellFrontBackMonitor", localException, "backToFront crash", new Object[0]);
              h.IzE.idkeyStat(932L, 44L, 1L, false);
            }
            if (paramInt1 == 0) {
              break label769;
            }
            Log.i("HABBYGE-MALI.HellFrontBackMonitor", "backToFront: isFrontToBackOfLastAction: YES");
            com.tencent.mm.plugin.expt.hellhound.core.b.a.a.KA(7);
            a.KS(7);
            ((c)localObject3).s(paramString, paramInt2, paramLong);
          }
        }
        bool1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.dcQ().wfK.dcM();
        Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_doIsBackToFront isFinish: %b", new Object[] { Boolean.valueOf(bool1) });
        if (bool1)
        {
          paramInt1 = 0;
        }
        else
        {
          if (!TextUtils.isEmpty(paramString))
          {
            com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
            localObject4 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcH();
            if (localObject4 != null)
            {
              localObject2 = (String)((com.tencent.mm.vending.j.b)localObject4).get(0);
              localObject4 = (Integer)((com.tencent.mm.vending.j.c)localObject4).get(1);
              if (localObject4 == null) {}
              for (paramInt1 = -1;; paramInt1 = ((Integer)localObject4).intValue())
              {
                localObject4 = Integer.valueOf(paramInt1);
                Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_doIsBackToFront resume: %s, %s, %s, %s", new Object[] { paramString, Integer.valueOf(paramInt2), localObject2, localObject4 });
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
          if (com.tencent.mm.plugin.expt.hellhound.core.b.awH(paramString))
          {
            Log.e("HABBYGE-MALI.HellFrontBackMonitor", "_doIsBackToFront 7事件，过滤小程序");
            paramInt1 = 0;
          }
          else
          {
            Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_doIsBackToFront ret: true");
            paramInt1 = 1;
            break label1762;
            label628:
            localObject2 = a.deq();
            if ((localObject2 == null) || (((bmr)localObject2).SXy != 8)) {
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
        Log.i("HABBYGE-MALI.HellFrontBackMonitor", "isFrontToBackAction.lastAction: true");
        if (com.tencent.mm.plugin.expt.hellhound.core.b.awL(paramString))
        {
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_isBackToFront 过滤掉第三方App进入微信的场景: %s", new Object[] { paramString });
          break label1776;
        }
        ((c)localObject3).wnO = true;
        paramInt1 = 1;
        break label373;
      }
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
      localObject4 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcH();
      localObject2 = null;
      if (localObject4 != null) {
        localObject2 = (String)((com.tencent.mm.vending.j.b)localObject4).get(0);
      }
      if ((!TextUtils.isEmpty(paramString)) && (TextUtils.isEmpty((CharSequence)localObject2)))
      {
        Log.i("HABBYGE-MALI.HellFrontBackMonitor", "HellFrontBackMonitor _isBackToFront: crash路径 !!!");
        h.IzE.idkeyStat(932L, 98L, 1L, false);
        paramInt1 = 1;
        break label373;
        Log.i("HABBYGE-MALI.HellFrontBackMonitor", "backToFront: isFrontToBackOfLastAction: FALSE");
        break label190;
        Log.i("HABBYGE-MALI.HellFrontBackMonitor", "frontBack ACTION_PAUSE: %s", new Object[] { paramString });
        boolean bool2 = false;
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dcJ();
        bool1 = bool2;
        if (localObject2 != null)
        {
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnPause topActivity: %s, %s", new Object[] { ((bl)localObject2).RGy.activityName, Integer.valueOf(((bl)localObject2).RGy.aNf) });
          if (((bl)localObject2).RGy.activityName.startsWith("com.tencent.mm")) {
            break label974;
          }
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnPause 栈顶非微信页面: %s", new Object[] { ((bl)localObject2).RGy.activityName });
          bool1 = true;
        }
        for (;;)
        {
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnPause: is8Event: %b", new Object[] { Boolean.valueOf(bool1) });
          if (bool1) {
            break label1068;
          }
          bool1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.dcQ().wfK.dcN();
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnPause.startActivity: %b, %s", new Object[] { Boolean.valueOf(bool1), paramString });
          if (!bool1) {
            break;
          }
          ((c)localObject3).wnP = false;
          AppMethodBeat.o(251290);
          return;
          bool1 = bool2;
          if ("com.tencent.mm.ui.transmit.SendAppMessageWrapperUI".equals(((bl)localObject2).RGy.activityName))
          {
            bool1 = bool2;
            if ("com.tencent.mm.plugin.sns.ui.SnsUploadUI".equals(paramString)) {
              bool1 = true;
            }
          }
        }
        bool1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.dcQ().wfK.axi(paramString);
        Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnPause.finish: %b, %s", new Object[] { Boolean.valueOf(bool1), paramString });
        if (bool1)
        {
          ((c)localObject3).wnP = false;
          AppMethodBeat.o(251290);
          return;
        }
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.KB(104);
        localObject4 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.KB(105);
        Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFrontToBackOnPause: %s, %s", new Object[] { localObject2, localObject4 });
        if ((com.tencent.mm.plugin.expt.hellhound.core.b.awA((String)localObject2)) && (com.tencent.mm.plugin.expt.hellhound.core.b.awy((String)localObject4)))
        {
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFrontToBackOnPause, SelectContactUI NOT 8-Event !!");
          AppMethodBeat.o(251290);
          return;
        }
        if ((com.tencent.mm.plugin.expt.hellhound.core.b.awz((String)localObject2)) || (com.tencent.mm.plugin.expt.hellhound.core.b.awA((String)localObject4)))
        {
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFrontToBackOnPause, GroupCardSelectUI NOT 8-Event !!");
          AppMethodBeat.o(251290);
          return;
        }
        if ((!com.tencent.mm.plugin.expt.hellhound.core.b.awy(paramString)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.awQ((String)localObject2)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.awy((String)localObject4)))
        {
          if (com.tencent.mm.plugin.expt.hellhound.a.e.a.deB() != -1)
          {
            com.tencent.mm.plugin.expt.hellhound.a.e.a.nw(true);
            Log.i("HABBYGE-MALI.HellFrontBackMonitor", "HellFrontToBackMonitor, judgeFrontToBackOnPause, requestPermission !!");
            AppMethodBeat.o(251290);
            return;
          }
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnPause front2back YES: %s", new Object[] { paramString });
          com.tencent.mm.plugin.expt.hellhound.core.b.a.a.KA(8);
          a.KS(8);
          ((c)localObject3).wnP = true;
          ((c)localObject3).t(paramString, paramInt2, paramLong);
        }
        AppMethodBeat.o(251290);
        return;
        Log.i("HABBYGE-MALI.HellFrontBackMonitor", "frontBack ACTION_STOP: %s", new Object[] { paramString });
        if (TextUtils.isEmpty(paramString))
        {
          Log.e("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnStop == null");
          AppMethodBeat.o(251290);
          return;
        }
        if (((c)localObject3).wnP)
        {
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnStop isFront2Back-1: true");
          AppMethodBeat.o(251290);
          return;
        }
        Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnStop stopActivityName: %s", new Object[] { paramString });
        try
        {
          localObject2 = dJ(paramString, paramInt2);
          if ((localObject2 == null) || (!((Boolean)((com.tencent.mm.vending.j.d)localObject2).get(2)).booleanValue()))
          {
            Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnStop: false");
            AppMethodBeat.o(251290);
            return;
          }
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnStop, 7-event: %s, TRUE", new Object[] { (String)((com.tencent.mm.vending.j.b)localObject2).get(0) });
          com.tencent.mm.plugin.expt.hellhound.core.b.a.a.KA(8);
          a.KS(8);
          ((c)localObject3).t(paramString, paramInt2, paramLong);
          AppMethodBeat.o(251290);
          return;
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace("HABBYGE-MALI.HellFrontBackMonitor", paramString, "judgeFront2BackOnStop crash", new Object[0]);
          h.IzE.idkeyStat(932L, 42L, 1L, false);
          AppMethodBeat.o(251290);
          return;
        }
        Log.i("HABBYGE-MALI.HellFrontBackMonitor", "frontBack ACTION_FINISH: %s", new Object[] { paramString });
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
        if (paramString == null) {}
        for (;;)
        {
          try
          {
            Log.e("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnFinish: aName == null");
            localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcG();
            if (localObject2 != null)
            {
              paramString = (String)((com.tencent.mm.vending.j.b)localObject2).get(0);
              ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
            }
            paramInt1 = 0;
            Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnFinish activity==null: %s", new Object[] { paramString });
            if ((paramInt1 != 0) && (com.tencent.mm.plugin.expt.hellhound.core.b.awy(paramString)))
            {
              Log.i("HABBYGE-MALI.HellFrontBackMonitor", "shutdown && isLauncherUI");
              localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcH();
              if (localObject2 == null) {
                break label1757;
              }
              localObject2 = (String)((com.tencent.mm.vending.j.b)localObject2).get(0);
              Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_quiteActivity.pause = %s", new Object[] { localObject2 });
              if (!"com.tencent.mm.plugin.setting.ui.setting.SettingsUI".equals(localObject2)) {
                break label1757;
              }
              paramInt1 = 1;
              if (paramInt1 != 0)
              {
                a.KS(8);
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.KA(8);
                ((c)localObject3).t(paramString, paramInt2, paramLong);
              }
            }
            AppMethodBeat.o(251290);
            return;
          }
          catch (Exception paramString)
          {
            Log.printErrStackTrace("HABBYGE-MALI.HellFrontBackMonitor", paramString, "judgeFront2BackOnFinish", new Object[0]);
            h.IzE.idkeyStat(932L, 40L, 1L, false);
          }
          paramInt1 = 1;
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnFinish: %s", new Object[] { paramString });
          continue;
          break label128;
          if (!com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess()) {
            break;
          }
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().Kz(600);
          AppMethodBeat.o(251290);
          return;
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "HellFrontBackMonitor, ACTION_add7Event_login");
          d.a("login", e.a.wcI, 1, paramLong);
          AppMethodBeat.o(251290);
          return;
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "HellFrontBackMonitor, ACTION_add8Event_logout");
          d.a("logout", e.a.wcJ, -1, paramLong);
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
  
  private boolean axY(String paramString)
  {
    AppMethodBeat.i(122034);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
    try
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcH();
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
        h.IzE.idkeyStat(932L, 45L, 1L, false);
        localCharSequence = null;
      }
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.awB(paramString)) || (!TextUtils.isEmpty(localCharSequence))) {
        break label137;
      }
      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx 启动微信进程 1");
      AppMethodBeat.o(122034);
      return true;
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.awB(paramString)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.awC(localCharSequence))) {
        break label167;
      }
      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx 启动微信进程 splash hook restart ~");
      AppMethodBeat.o(122034);
      return true;
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.awy(paramString)) || (!TextUtils.isEmpty(localCharSequence))) {
        break label197;
      }
      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx 启动微信进程 2");
      AppMethodBeat.o(122034);
      return true;
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.awB(localCharSequence)) || (com.tencent.mm.plugin.expt.hellhound.core.b.awL(paramString)) || ("com.tencent.mm.plugin.base.stub.UIEntryStub".equals(paramString)) || ("com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI".equals(paramString))) {
        break label247;
      }
      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx 启动微信进程 3");
      AppMethodBeat.o(122034);
      return true;
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.awB(localCharSequence)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.awy(paramString))) {
        break label282;
      }
      this.wnN = true;
      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx 启动微信进程 4");
      AppMethodBeat.o(122034);
      return true;
      if ((!"com.tencent.mm.ui.tools.ShareToTimeLineUI".equals(paramString)) || (localCharSequence != null)) {
        break label312;
      }
      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx: frome outer jump to Timeline");
      AppMethodBeat.o(122034);
      return true;
      if ((!"com.tencent.mm.ui.tools.AddFavoriteUI".equals(paramString)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.awB(localCharSequence))) {
        break label345;
      }
      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx: from outer jump to 收藏");
      AppMethodBeat.o(122034);
      return true;
      if (!axZ(paramString)) {
        break label368;
      }
      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx 启动微信进程 通过小程序桌面快捷方式");
      AppMethodBeat.o(122034);
      return true;
      if (!"com.tencent.mm.plugin.base.stub.UIEntryStub".equals(paramString)) {
        break label394;
      }
      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx 启动微信进程 通过第三方拉起微信(第三方登录、分享好友、朋友圈)");
      AppMethodBeat.o(122034);
      return true;
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.awG(paramString)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.awy(localCharSequence))) {
        break label428;
      }
      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx 启动微信进程 之前登录过，登录页");
      if (!this.wnN) {
        break label436;
      }
      this.wnN = false;
      AppMethodBeat.o(122034);
      return false;
    }
    Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx resume/pause: %s, %s", new Object[] { paramString, localObject });
    if (("com.tencent.mm.plugin.voip.ui.VideoActivity".equals(paramString)) && ((TextUtils.isEmpty((CharSequence)localObject)) || (com.tencent.mm.plugin.expt.hellhound.core.b.awB((String)localObject))))
    {
      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "VOIP start MM Process");
      AppMethodBeat.o(122034);
      return true;
    }
    label102:
    label247:
    while (this.wnO) {
      this.wnO = false;
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
  
  private static boolean axZ(String paramString)
  {
    AppMethodBeat.i(122035);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
    label77:
    CharSequence localCharSequence;
    try
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcH();
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
        Log.printErrStackTrace("HABBYGE-MALI.HellFrontBackMonitor", localException, "isStartWxByLittlePragramShortcut", new Object[0]);
        localCharSequence = null;
        continue;
        i = 0;
      }
      label87:
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.awH(paramString)) || (!TextUtils.isEmpty(localCharSequence))) {
        break label123;
      }
      label123:
      for (int i = 1; i != 0; i = 0)
      {
        Log.i("HABBYGE-MALI.HellFrontBackMonitor", "isStartWxByLittlePragramShortcut case-2");
        AppMethodBeat.o(122035);
        return true;
      }
      if (!com.tencent.mm.plugin.expt.hellhound.core.b.awH(paramString)) {
        break label164;
      }
    }
    if ((com.tencent.mm.plugin.expt.hellhound.core.b.awH(paramString)) && (com.tencent.mm.plugin.expt.hellhound.core.b.awK((String)localObject)))
    {
      i = 1;
      if (i == 0) {
        break label87;
      }
      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "isStartWxByLittlePragramShortcut case-1");
      AppMethodBeat.o(122035);
      return true;
    }
    if (com.tencent.mm.plugin.expt.hellhound.core.b.awB(localCharSequence)) {}
    label164:
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        Log.i("HABBYGE-MALI.HellFrontBackMonitor", "isStartWxByLittlePragramShortcut case-3");
      }
      AppMethodBeat.o(122035);
      return bool;
    }
  }
  
  private static com.tencent.mm.vending.j.d<String, Integer, Boolean> dJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(251293);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
    for (;;)
    {
      int i;
      int j;
      boolean bool1;
      try
      {
        Object localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcG();
        Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcH();
        if ((paramString == null) || (localObject2 == null) || (localObject1 == null))
        {
          Log.e("HABBYGE-MALI.HellFrontBackMonitor", "isFront2BackOnStop: illeagal Event");
          AppMethodBeat.o(251293);
          return null;
        }
        String str = (String)((com.tencent.mm.vending.j.b)localObject2).get(0);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.awM(str))
        {
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "isFakeSwitchAccountUI true");
          AppMethodBeat.o(251293);
          return null;
        }
        Log.i("HABBYGE-MALI.HellFrontBackMonitor", "isFront2BackOnStop: Resume: %s, Pause: %s, Stop: %s", new Object[] { localObject2, localObject1, paramString });
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
              Log.i("HABBYGE-MALI.HellFrontBackMonitor", "isFront2BackOnStop, case-1：%b", new Object[] { Boolean.valueOf(bool1) });
              bool2 = bool1;
              if (bool1)
              {
                bool2 = bool1;
                if (!com.tencent.mm.plugin.expt.hellhound.core.b.awN(paramString))
                {
                  bool2 = bool1;
                  if (!com.tencent.mm.plugin.expt.hellhound.core.b.awO(paramString))
                  {
                    localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dcJ();
                    bool2 = bool1;
                    if (localObject1 != null)
                    {
                      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "isFront2BackOnStop isEvent8: %s, %s", new Object[] { ((bl)localObject1).RGy.activityName, Integer.valueOf(((bl)localObject1).RGy.aNf) });
                      if (!((bl)localObject1).RGy.activityName.startsWith("com.tencent.mm")) {
                        continue;
                      }
                      bool2 = bool1;
                      if (((bl)localObject1).RGy.aNf <= 0)
                      {
                        bool2 = bool1;
                        if (!((bl)localObject1).RGy.activityName.equals(paramString))
                        {
                          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "isFront2BackOnStop isEvent8-1: false");
                          bool2 = false;
                        }
                      }
                    }
                  }
                }
              }
              Log.i("HABBYGE-MALI.HellFrontBackMonitor", "isFront2BackOnStop case1 && case2：%b", new Object[] { Boolean.valueOf(bool2) });
              paramString = com.tencent.mm.vending.j.a.h(paramString, Integer.valueOf(paramInt), Boolean.valueOf(bool2));
              AppMethodBeat.o(251293);
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
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "isFront2BackOnStop: NOT wx activity");
          boolean bool2 = bool1;
          continue;
        }
        i = 0;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellFrontBackMonitor", paramString, "isFront2BackOnStop", new Object[0]);
        h.IzE.idkeyStat(932L, 43L, 1L, false);
        AppMethodBeat.o(251293);
        return null;
      }
      continue;
      label468:
      if ((j != 0) && (i != 0)) {
        bool1 = true;
      }
    }
  }
  
  public static c der()
  {
    AppMethodBeat.i(122031);
    if (wnM == null) {}
    try
    {
      if (wnM == null) {
        wnM = new c();
      }
      c localc = wnM;
      AppMethodBeat.o(122031);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(122031);
    }
  }
  
  private void s(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(251294);
    if (this.wnL != null) {
      this.wnL.j(paramString, paramInt, paramLong);
    }
    AppMethodBeat.o(251294);
  }
  
  private void t(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(251295);
    if (this.wnL != null) {
      this.wnL.k(paramString, paramInt, paramLong);
    }
    AppMethodBeat.o(251295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.c.c
 * JD-Core Version:    0.7.0.1
 */