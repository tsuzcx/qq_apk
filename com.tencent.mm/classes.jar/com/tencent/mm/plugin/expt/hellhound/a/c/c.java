package com.tencent.mm.plugin.expt.hellhound.a.c;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.d.c;
import com.tencent.mm.plugin.expt.b.e.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bfq;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.eih;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  private static volatile c sHR;
  public final a sHP;
  public d.c sHQ;
  private boolean sHS;
  private boolean sHT;
  private boolean sHU;
  
  private c()
  {
    AppMethodBeat.i(122032);
    this.sHS = false;
    this.sHT = false;
    this.sHU = true;
    this.sHP = new a();
    AppMethodBeat.o(122032);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(220533);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cNo()) || (!com.tencent.mm.plugin.expt.hellhound.a.cNp()))
    {
      Log.e("HABBYGE-MALI.HellFrontBackMonitor", "HellFrontBackMonitor monitor close !!!");
      AppMethodBeat.o(220533);
      return;
    }
    Log.i("HABBYGE-MALI.HellFrontBackMonitor", "HellFrontBackMonitor monitor start !!!");
    Object localObject3 = cPx();
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
      AppMethodBeat.o(220533);
      return;
    case 100: 
    case 101: 
    case 102: 
    case 103: 
      if (!TextUtils.isEmpty(paramString)) {}
      switch (paramInt1)
      {
      default: 
        AppMethodBeat.o(220533);
        return;
      case 100: 
        if (!TextUtils.isEmpty(paramString))
        {
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeBack2Front: %s, %s", new Object[] { paramString, Integer.valueOf(paramInt2) });
          if ((!com.tencent.mm.plugin.expt.hellhound.a.e.a.cPJ()) || (com.tencent.mm.plugin.expt.hellhound.a.e.a.cPH() == -1)) {
            break label288;
          }
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "HellFrontToBackMonitor, judgeBack2Front, requestPermission !!");
          com.tencent.mm.plugin.expt.hellhound.a.e.a.cPI();
          com.tencent.mm.plugin.expt.hellhound.a.e.a.mj(false);
        }
        for (;;)
        {
          localObject3 = a.cPw();
          Object localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = new bfq();
          }
          if (com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess()) {
            ((bfq)localObject1).LPj = Process.myPid();
          }
          ((bfq)localObject1).LPk = paramString;
          ((bfq)localObject1).aHK = paramInt2;
          ((bfq)localObject1).LPi = System.currentTimeMillis();
          Log.d("HABBYGE-MALI.FrontBackDao", "setLastMMProcessParamsOnResume: %s, %d", new Object[] { ((bfq)localObject1).LPk, Integer.valueOf(((bfq)localObject1).jlm) });
          a.a((bfq)localObject1);
          AppMethodBeat.o(220533);
          return;
          if (((c)localObject3).apY(paramString))
          {
            Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeBack2Front: _launchWx TRUE");
            com.tencent.mm.plugin.expt.hellhound.core.b.a.a.GQ(7);
            a.Hi(7);
            ((c)localObject3).r(paramString, paramInt2, paramLong);
          }
          else
          {
            Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeBack2Front: _launchWx FALSE");
            try
            {
              bool1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cNY().szQ.aph(paramString);
              Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_doIsBackToFront isStartActivity: %b", new Object[] { Boolean.valueOf(bool1) });
              if (!bool1) {
                break;
              }
              paramInt1 = 0;
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("HABBYGE-MALI.HellFrontBackMonitor", localException, "backToFront crash", new Object[0]);
              h.CyF.idkeyStat(932L, 44L, 1L, false);
            }
            if (paramInt1 == 0) {
              break label769;
            }
            Log.i("HABBYGE-MALI.HellFrontBackMonitor", "backToFront: isFrontToBackOfLastAction: YES");
            com.tencent.mm.plugin.expt.hellhound.core.b.a.a.GQ(7);
            a.Hi(7);
            ((c)localObject3).r(paramString, paramInt2, paramLong);
          }
        }
        bool1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cNY().szQ.cNU();
        Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_doIsBackToFront isFinish: %b", new Object[] { Boolean.valueOf(bool1) });
        if (bool1)
        {
          paramInt1 = 0;
        }
        else
        {
          if (!TextUtils.isEmpty(paramString))
          {
            com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
            localObject4 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNP();
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
          if (com.tencent.mm.plugin.expt.hellhound.core.b.aoI(paramString))
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
            localObject2 = a.cPw();
            if ((localObject2 == null) || (((bfq)localObject2).LPh != 8)) {
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
        if (com.tencent.mm.plugin.expt.hellhound.core.b.aoM(paramString))
        {
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_isBackToFront 过滤掉第三方App进入微信的场景: %s", new Object[] { paramString });
          break label1776;
        }
        ((c)localObject3).sHT = true;
        paramInt1 = 1;
        break label373;
      }
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
      localObject4 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNP();
      localObject2 = null;
      if (localObject4 != null) {
        localObject2 = (String)((com.tencent.mm.vending.j.b)localObject4).get(0);
      }
      if ((!TextUtils.isEmpty(paramString)) && (TextUtils.isEmpty((CharSequence)localObject2)))
      {
        Log.i("HABBYGE-MALI.HellFrontBackMonitor", "HellFrontBackMonitor _isBackToFront: crash路径 !!!");
        h.CyF.idkeyStat(932L, 98L, 1L, false);
        paramInt1 = 1;
        break label373;
        Log.i("HABBYGE-MALI.HellFrontBackMonitor", "backToFront: isFrontToBackOfLastAction: FALSE");
        break label190;
        Log.i("HABBYGE-MALI.HellFrontBackMonitor", "frontBack ACTION_PAUSE: %s", new Object[] { paramString });
        boolean bool2 = false;
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cNR();
        bool1 = bool2;
        if (localObject2 != null)
        {
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnPause topActivity: %s, %s", new Object[] { ((bn)localObject2).KFh.activityName, Integer.valueOf(((bn)localObject2).KFh.aHK) });
          if (((bn)localObject2).KFh.activityName.startsWith("com.tencent.mm")) {
            break label974;
          }
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnPause 栈顶非微信页面: %s", new Object[] { ((bn)localObject2).KFh.activityName });
          bool1 = true;
        }
        for (;;)
        {
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnPause: is8Event: %b", new Object[] { Boolean.valueOf(bool1) });
          if (bool1) {
            break label1068;
          }
          bool1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cNY().szQ.cNV();
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnPause.startActivity: %b, %s", new Object[] { Boolean.valueOf(bool1), paramString });
          if (!bool1) {
            break;
          }
          ((c)localObject3).sHU = false;
          AppMethodBeat.o(220533);
          return;
          bool1 = bool2;
          if ("com.tencent.mm.ui.transmit.SendAppMessageWrapperUI".equals(((bn)localObject2).KFh.activityName))
          {
            bool1 = bool2;
            if ("com.tencent.mm.plugin.sns.ui.SnsUploadUI".equals(paramString)) {
              bool1 = true;
            }
          }
        }
        bool1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cNY().szQ.api(paramString);
        Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnPause.finish: %b, %s", new Object[] { Boolean.valueOf(bool1), paramString });
        if (bool1)
        {
          ((c)localObject3).sHU = false;
          AppMethodBeat.o(220533);
          return;
        }
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.GR(104);
        localObject4 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.GR(105);
        Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFrontToBackOnPause: %s, %s", new Object[] { localObject2, localObject4 });
        if ((com.tencent.mm.plugin.expt.hellhound.core.b.aoB((String)localObject2)) && (com.tencent.mm.plugin.expt.hellhound.core.b.aoz((String)localObject4)))
        {
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFrontToBackOnPause, SelectContactUI NOT 8-Event !!");
          AppMethodBeat.o(220533);
          return;
        }
        if ((com.tencent.mm.plugin.expt.hellhound.core.b.aoA((String)localObject2)) || (com.tencent.mm.plugin.expt.hellhound.core.b.aoB((String)localObject4)))
        {
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFrontToBackOnPause, GroupCardSelectUI NOT 8-Event !!");
          AppMethodBeat.o(220533);
          return;
        }
        if ((!com.tencent.mm.plugin.expt.hellhound.core.b.aoz(paramString)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.aoR((String)localObject2)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.aoz((String)localObject4)))
        {
          if (com.tencent.mm.plugin.expt.hellhound.a.e.a.cPH() != -1)
          {
            com.tencent.mm.plugin.expt.hellhound.a.e.a.mj(true);
            Log.i("HABBYGE-MALI.HellFrontBackMonitor", "HellFrontToBackMonitor, judgeFrontToBackOnPause, requestPermission !!");
            AppMethodBeat.o(220533);
            return;
          }
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnPause front2back YES: %s", new Object[] { paramString });
          com.tencent.mm.plugin.expt.hellhound.core.b.a.a.GQ(8);
          a.Hi(8);
          ((c)localObject3).sHU = true;
          ((c)localObject3).s(paramString, paramInt2, paramLong);
        }
        AppMethodBeat.o(220533);
        return;
        Log.i("HABBYGE-MALI.HellFrontBackMonitor", "frontBack ACTION_STOP: %s", new Object[] { paramString });
        if (TextUtils.isEmpty(paramString))
        {
          Log.e("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnStop == null");
          AppMethodBeat.o(220533);
          return;
        }
        if (((c)localObject3).sHU)
        {
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnStop isFront2Back-1: true");
          AppMethodBeat.o(220533);
          return;
        }
        Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnStop stopActivityName: %s", new Object[] { paramString });
        try
        {
          localObject2 = jdMethod_do(paramString, paramInt2);
          if ((localObject2 == null) || (!((Boolean)((com.tencent.mm.vending.j.d)localObject2).get(2)).booleanValue()))
          {
            Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnStop: false");
            AppMethodBeat.o(220533);
            return;
          }
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnStop, 7-event: %s, TRUE", new Object[] { (String)((com.tencent.mm.vending.j.b)localObject2).get(0) });
          com.tencent.mm.plugin.expt.hellhound.core.b.a.a.GQ(8);
          a.Hi(8);
          ((c)localObject3).s(paramString, paramInt2, paramLong);
          AppMethodBeat.o(220533);
          return;
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace("HABBYGE-MALI.HellFrontBackMonitor", paramString, "judgeFront2BackOnStop crash", new Object[0]);
          h.CyF.idkeyStat(932L, 42L, 1L, false);
          AppMethodBeat.o(220533);
          return;
        }
        Log.i("HABBYGE-MALI.HellFrontBackMonitor", "frontBack ACTION_FINISH: %s", new Object[] { paramString });
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
        if (paramString == null) {}
        for (;;)
        {
          try
          {
            Log.e("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnFinish: aName == null");
            localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNO();
            if (localObject2 != null)
            {
              paramString = (String)((com.tencent.mm.vending.j.b)localObject2).get(0);
              ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
            }
            paramInt1 = 0;
            Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnFinish activity==null: %s", new Object[] { paramString });
            if ((paramInt1 != 0) && (com.tencent.mm.plugin.expt.hellhound.core.b.aoz(paramString)))
            {
              Log.i("HABBYGE-MALI.HellFrontBackMonitor", "shutdown && isLauncherUI");
              localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNP();
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
                a.Hi(8);
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.GQ(8);
                ((c)localObject3).s(paramString, paramInt2, paramLong);
              }
            }
            AppMethodBeat.o(220533);
            return;
          }
          catch (Exception paramString)
          {
            Log.printErrStackTrace("HABBYGE-MALI.HellFrontBackMonitor", paramString, "judgeFront2BackOnFinish", new Object[0]);
            h.CyF.idkeyStat(932L, 40L, 1L, false);
          }
          paramInt1 = 1;
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "judgeFront2BackOnFinish: %s", new Object[] { paramString });
          continue;
          break label128;
          if (!com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess()) {
            break;
          }
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().GP(600);
          AppMethodBeat.o(220533);
          return;
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "HellFrontBackMonitor, ACTION_add7Event_login");
          d.a("login", e.a.sxg, 1, paramLong);
          AppMethodBeat.o(220533);
          return;
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "HellFrontBackMonitor, ACTION_add8Event_logout");
          d.a("logout", e.a.sxh, -1, paramLong);
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
  
  private boolean apY(String paramString)
  {
    AppMethodBeat.i(122034);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
    try
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNP();
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
        h.CyF.idkeyStat(932L, 45L, 1L, false);
        localCharSequence = null;
      }
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.aoC(paramString)) || (!TextUtils.isEmpty(localCharSequence))) {
        break label137;
      }
      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx 启动微信进程 1");
      AppMethodBeat.o(122034);
      return true;
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.aoC(paramString)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.aoD(localCharSequence))) {
        break label167;
      }
      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx 启动微信进程 splash hook restart ~");
      AppMethodBeat.o(122034);
      return true;
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.aoz(paramString)) || (!TextUtils.isEmpty(localCharSequence))) {
        break label197;
      }
      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx 启动微信进程 2");
      AppMethodBeat.o(122034);
      return true;
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.aoC(localCharSequence)) || (com.tencent.mm.plugin.expt.hellhound.core.b.aoM(paramString)) || ("com.tencent.mm.plugin.base.stub.UIEntryStub".equals(paramString)) || ("com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI".equals(paramString))) {
        break label247;
      }
      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx 启动微信进程 3");
      AppMethodBeat.o(122034);
      return true;
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.aoC(localCharSequence)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.aoz(paramString))) {
        break label282;
      }
      this.sHS = true;
      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx 启动微信进程 4");
      AppMethodBeat.o(122034);
      return true;
      if ((!"com.tencent.mm.ui.tools.ShareToTimeLineUI".equals(paramString)) || (localCharSequence != null)) {
        break label312;
      }
      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx: frome outer jump to Timeline");
      AppMethodBeat.o(122034);
      return true;
      if ((!"com.tencent.mm.ui.tools.AddFavoriteUI".equals(paramString)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.aoC(localCharSequence))) {
        break label345;
      }
      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx: from outer jump to 收藏");
      AppMethodBeat.o(122034);
      return true;
      if (!apZ(paramString)) {
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
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.aoH(paramString)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.aoz(localCharSequence))) {
        break label428;
      }
      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx 启动微信进程 之前登录过，登录页");
      if (!this.sHS) {
        break label436;
      }
      this.sHS = false;
      AppMethodBeat.o(122034);
      return false;
    }
    Log.i("HABBYGE-MALI.HellFrontBackMonitor", "_launchWx resume/pause: %s, %s", new Object[] { paramString, localObject });
    if (("com.tencent.mm.plugin.voip.ui.VideoActivity".equals(paramString)) && ((TextUtils.isEmpty((CharSequence)localObject)) || (com.tencent.mm.plugin.expt.hellhound.core.b.aoC((String)localObject))))
    {
      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "VOIP start MM Process");
      AppMethodBeat.o(122034);
      return true;
    }
    label102:
    label247:
    while (this.sHT) {
      this.sHT = false;
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
  
  private static boolean apZ(String paramString)
  {
    AppMethodBeat.i(122035);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
    label77:
    CharSequence localCharSequence;
    try
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNP();
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
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.aoI(paramString)) || (!TextUtils.isEmpty(localCharSequence))) {
        break label123;
      }
      label123:
      for (int i = 1; i != 0; i = 0)
      {
        Log.i("HABBYGE-MALI.HellFrontBackMonitor", "isStartWxByLittlePragramShortcut case-2");
        AppMethodBeat.o(122035);
        return true;
      }
      if (!com.tencent.mm.plugin.expt.hellhound.core.b.aoI(paramString)) {
        break label164;
      }
    }
    if ((com.tencent.mm.plugin.expt.hellhound.core.b.aoI(paramString)) && (com.tencent.mm.plugin.expt.hellhound.core.b.aoL((String)localObject)))
    {
      i = 1;
      if (i == 0) {
        break label87;
      }
      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "isStartWxByLittlePragramShortcut case-1");
      AppMethodBeat.o(122035);
      return true;
    }
    if (com.tencent.mm.plugin.expt.hellhound.core.b.aoC(localCharSequence)) {}
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
  
  public static c cPx()
  {
    AppMethodBeat.i(122031);
    if (sHR == null) {}
    try
    {
      if (sHR == null) {
        sHR = new c();
      }
      c localc = sHR;
      AppMethodBeat.o(122031);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(122031);
    }
  }
  
  private static com.tencent.mm.vending.j.d<String, Integer, Boolean> jdMethod_do(String paramString, int paramInt)
  {
    AppMethodBeat.i(220534);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
    for (;;)
    {
      int i;
      int j;
      boolean bool1;
      try
      {
        Object localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNO();
        Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNP();
        if ((paramString == null) || (localObject2 == null) || (localObject1 == null))
        {
          Log.e("HABBYGE-MALI.HellFrontBackMonitor", "isFront2BackOnStop: illeagal Event");
          AppMethodBeat.o(220534);
          return null;
        }
        String str = (String)((com.tencent.mm.vending.j.b)localObject2).get(0);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.aoN(str))
        {
          Log.i("HABBYGE-MALI.HellFrontBackMonitor", "isFakeSwitchAccountUI true");
          AppMethodBeat.o(220534);
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
                if (!com.tencent.mm.plugin.expt.hellhound.core.b.aoO(paramString))
                {
                  bool2 = bool1;
                  if (!com.tencent.mm.plugin.expt.hellhound.core.b.aoP(paramString))
                  {
                    localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cNR();
                    bool2 = bool1;
                    if (localObject1 != null)
                    {
                      Log.i("HABBYGE-MALI.HellFrontBackMonitor", "isFront2BackOnStop isEvent8: %s, %s", new Object[] { ((bn)localObject1).KFh.activityName, Integer.valueOf(((bn)localObject1).KFh.aHK) });
                      if (!((bn)localObject1).KFh.activityName.startsWith("com.tencent.mm")) {
                        continue;
                      }
                      bool2 = bool1;
                      if (((bn)localObject1).KFh.aHK <= 0)
                      {
                        bool2 = bool1;
                        if (!((bn)localObject1).KFh.activityName.equals(paramString))
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
              paramString = com.tencent.mm.vending.j.a.i(paramString, Integer.valueOf(paramInt), Boolean.valueOf(bool2));
              AppMethodBeat.o(220534);
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
        h.CyF.idkeyStat(932L, 43L, 1L, false);
        AppMethodBeat.o(220534);
        return null;
      }
      continue;
      label468:
      if ((j != 0) && (i != 0)) {
        bool1 = true;
      }
    }
  }
  
  private void r(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(220535);
    if (this.sHQ != null) {
      this.sHQ.i(paramString, paramInt, paramLong);
    }
    AppMethodBeat.o(220535);
  }
  
  private void s(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(220536);
    if (this.sHQ != null) {
      this.sHQ.j(paramString, paramInt, paramLong);
    }
    AppMethodBeat.o(220536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.c.c
 * JD-Core Version:    0.7.0.1
 */