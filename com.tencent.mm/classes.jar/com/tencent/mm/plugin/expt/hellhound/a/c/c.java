package com.tencent.mm.plugin.expt.hellhound.a.c;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.d.c;
import com.tencent.mm.plugin.expt.a.e.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.dcm;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
{
  private static volatile c pGJ;
  public a pGH;
  public d.c pGI;
  private boolean pGK;
  private boolean pGL;
  private boolean pGM;
  
  private c()
  {
    AppMethodBeat.i(122032);
    this.pGK = false;
    this.pGL = false;
    this.pGM = true;
    this.pGH = new a();
    AppMethodBeat.o(122032);
  }
  
  private boolean Wg(String paramString)
  {
    AppMethodBeat.i(122034);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
    try
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbJ();
      if (localObject == null) {
        break label97;
      }
      localObject = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
    }
    catch (Exception localException)
    {
      CharSequence localCharSequence;
      for (;;)
      {
        Object localObject;
        h.vKh.idkeyStat(932L, 45L, 1L, false);
        localCharSequence = null;
      }
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.Vw(paramString)) || (!TextUtils.isEmpty(localCharSequence))) {
        break label130;
      }
      ad.i("HellFrontBackMonitor", "HABBYGE-MALI, _launchWx 启动微信进程 1");
      AppMethodBeat.o(122034);
      return true;
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.Vw(paramString)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.Vx(localCharSequence))) {
        break label158;
      }
      ad.i("HellFrontBackMonitor", "HABBYGE-MALI, _launchWx 启动微信进程 splash hook restart ~");
      AppMethodBeat.o(122034);
      return true;
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.Vt(paramString)) || (!TextUtils.isEmpty(localCharSequence))) {
        break label186;
      }
      ad.i("HellFrontBackMonitor", "HABBYGE-MALI, _launchWx 启动微信进程 2");
      AppMethodBeat.o(122034);
      return true;
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.Vw(localCharSequence)) || (com.tencent.mm.plugin.expt.hellhound.core.b.VG(paramString)) || ("com.tencent.mm.plugin.base.stub.UIEntryStub".equals(paramString)) || ("com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI".equals(paramString))) {
        break label232;
      }
      ad.i("HellFrontBackMonitor", "HABBYGE-MALI, _launchWx 启动微信进程 3");
      AppMethodBeat.o(122034);
      return true;
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.Vw(localCharSequence)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.Vt(paramString))) {
        break label265;
      }
      this.pGK = true;
      ad.i("HellFrontBackMonitor", "HABBYGE-MALI, _launchWx 启动微信进程 4");
      AppMethodBeat.o(122034);
      return true;
      if ((!"com.tencent.mm.ui.tools.ShareToTimeLineUI".equals(paramString)) || (localCharSequence != null)) {
        break label292;
      }
      ad.i("HellFrontBackMonitor", "HABBYGE-MALI, _launchWx: frome outer jump to Timeline");
      AppMethodBeat.o(122034);
      return true;
      if ((!"com.tencent.mm.ui.tools.AddFavoriteUI".equals(paramString)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.Vw(localCharSequence))) {
        break label322;
      }
      ad.i("HellFrontBackMonitor", "HABBYGE-MALI, _launchWx: from outer jump to 收藏");
      AppMethodBeat.o(122034);
      return true;
      if (!Wh(paramString)) {
        break label343;
      }
      ad.i("HellFrontBackMonitor", "HABBYGE-MALI, _launchWx 启动微信进程 通过小程序桌面快捷方式");
      AppMethodBeat.o(122034);
      return true;
      if (!"com.tencent.mm.plugin.base.stub.UIEntryStub".equals(paramString)) {
        break label366;
      }
      ad.i("HellFrontBackMonitor", "HABBYGE-MALI, _launchWx 启动微信进程 通过第三方拉起微信(第三方登录、分享好友、朋友圈)");
      AppMethodBeat.o(122034);
      return true;
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.VB(paramString)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.Vt(localCharSequence))) {
        break label399;
      }
      ad.i("HellFrontBackMonitor", "HABBYGE-MALI, _launchWx 启动微信进程 之前登录过，登录页");
      if (!this.pGK) {
        break label406;
      }
      this.pGK = false;
      AppMethodBeat.o(122034);
      return false;
    }
    ad.i("HellFrontBackMonitor", "HABBYGE-MALI, _launchWx resume/pause: %s, %s", new Object[] { paramString, localObject });
    if (("com.tencent.mm.plugin.voip.ui.VideoActivity".equals(paramString)) && ((TextUtils.isEmpty((CharSequence)localObject)) || (com.tencent.mm.plugin.expt.hellhound.core.b.Vw((String)localObject))))
    {
      ad.i("HellFrontBackMonitor", "HABBYGE-MALI, VOIP start MM Process");
      AppMethodBeat.o(122034);
      return true;
    }
    label97:
    label232:
    label366:
    while (this.pGL) {
      this.pGL = false;
    }
    label130:
    label158:
    label186:
    label322:
    label343:
    AppMethodBeat.o(122034);
    label265:
    label292:
    return true;
  }
  
  private static boolean Wh(String paramString)
  {
    AppMethodBeat.i(122035);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
    label73:
    CharSequence localCharSequence;
    try
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbJ();
      if (localObject == null) {
        break label73;
      }
      localObject = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        ad.printErrStackTrace("HellFrontBackMonitor", localException, "HABBYGE-MALI, isStartWxByLittlePragramShortcut", new Object[0]);
        localCharSequence = null;
        continue;
        i = 0;
      }
      label83:
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.VC(paramString)) || (!TextUtils.isEmpty(localCharSequence))) {
        break label117;
      }
      label117:
      for (int i = 1; i != 0; i = 0)
      {
        ad.i("HellFrontBackMonitor", "HABBYGE-MALI, isStartWxByLittlePragramShortcut case-2");
        AppMethodBeat.o(122035);
        return true;
      }
      if (!com.tencent.mm.plugin.expt.hellhound.core.b.VC(paramString)) {
        break label156;
      }
    }
    if ((com.tencent.mm.plugin.expt.hellhound.core.b.VC(paramString)) && (com.tencent.mm.plugin.expt.hellhound.core.b.VF((String)localObject)))
    {
      i = 1;
      if (i == 0) {
        break label83;
      }
      ad.i("HellFrontBackMonitor", "HABBYGE-MALI, isStartWxByLittlePragramShortcut case-1");
      AppMethodBeat.o(122035);
      return true;
    }
    if (com.tencent.mm.plugin.expt.hellhound.core.b.Vw(localCharSequence)) {}
    label156:
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        ad.i("HellFrontBackMonitor", "HABBYGE-MALI, isStartWxByLittlePragramShortcut case-3");
      }
      AppMethodBeat.o(122035);
      return bool;
    }
  }
  
  public static void b(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(184359);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cbn()) || (!com.tencent.mm.plugin.expt.hellhound.a.cbo()))
    {
      ad.e("HellFrontBackMonitor", "HABBYGE-MALI, HellFrontBackMonitor monitor close !!!");
      AppMethodBeat.o(184359);
      return;
    }
    ad.i("HellFrontBackMonitor", "HABBYGE-MALI, HellFrontBackMonitor monitor start !!!");
    Object localObject3 = ccq();
    label128:
    label187:
    boolean bool1;
    label285:
    label373:
    Object localObject4;
    Object localObject2;
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(184359);
      return;
    case 100: 
    case 101: 
    case 102: 
    case 103: 
      if (!TextUtils.isEmpty(paramString1)) {}
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184359);
        return;
      case 100: 
        if (!TextUtils.isEmpty(paramString1))
        {
          ad.i("HellFrontBackMonitor", "HABBYGE-MALI, judgeBack2Front: %s, %s", new Object[] { paramString1, paramString2 });
          if ((!com.tencent.mm.plugin.expt.hellhound.a.e.a.ccB()) || (com.tencent.mm.plugin.expt.hellhound.a.e.a.ccz() == -1)) {
            break label285;
          }
          ad.i("HellFrontBackMonitor", "HABBYGE-MALI, HellFrontToBackMonitor, judgeBack2Front, requestPermission !!");
          com.tencent.mm.plugin.expt.hellhound.a.e.a.ccA();
          com.tencent.mm.plugin.expt.hellhound.a.e.a.kf(false);
        }
        for (;;)
        {
          localObject3 = a.ccp();
          Object localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = new amt();
          }
          if (com.tencent.mm.plugin.expt.hellhound.core.b.cbv()) {
            ((amt)localObject1).DnP = Process.myPid();
          }
          ((amt)localObject1).DnQ = paramString1;
          ((amt)localObject1).DnR = paramString2;
          ((amt)localObject1).DnO = System.currentTimeMillis();
          ad.d("FrontBackDao", "habbyge-mali, setLastMMProcessParamsOnResume: %s, %d", new Object[] { ((amt)localObject1).DnQ, Integer.valueOf(((amt)localObject1).htk) });
          a.a((amt)localObject1);
          AppMethodBeat.o(184359);
          return;
          if (((c)localObject3).Wg(paramString1))
          {
            ad.i("HellFrontBackMonitor", "HABBYGE-MALI, judgeBack2Front: _launchWx TRUE");
            com.tencent.mm.plugin.expt.hellhound.core.b.a.a.Bp(7);
            a.BB(7);
            ((c)localObject3).p(paramString1, paramString2, paramLong);
          }
          else
          {
            ad.i("HellFrontBackMonitor", "HABBYGE-MALI, judgeBack2Front: _launchWx FALSE");
            try
            {
              bool1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cbS().pEO.VV(paramString1);
              ad.i("HellFrontBackMonitor", "HABBYGE-MALI, _doIsBackToFront isStartActivity: %b", new Object[] { Boolean.valueOf(bool1) });
              if (!bool1) {
                break;
              }
              paramInt = 0;
            }
            catch (Exception localException)
            {
              ad.printErrStackTrace("HellFrontBackMonitor", localException, "HABBYGE-MALI, backToFront crash", new Object[0]);
              h.vKh.idkeyStat(932L, 44L, 1L, false);
            }
            if (paramInt == 0) {
              break label748;
            }
            ad.i("HellFrontBackMonitor", "HABBYGE-MALI, backToFront: isFrontToBackOfLastAction: YES");
            com.tencent.mm.plugin.expt.hellhound.core.b.a.a.Bp(7);
            a.BB(7);
            ((c)localObject3).p(paramString1, paramString2, paramLong);
          }
        }
        bool1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cbS().pEO.cbO();
        ad.i("HellFrontBackMonitor", "HABBYGE-MALI, _doIsBackToFront isFinish: %b", new Object[] { Boolean.valueOf(bool1) });
        if (bool1)
        {
          paramInt = 0;
        }
        else
        {
          if (!TextUtils.isEmpty(paramString1))
          {
            com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
            localObject4 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbJ();
            if (localObject4 != null)
            {
              localObject2 = (String)((com.tencent.mm.vending.j.b)localObject4).get(0);
              localObject4 = (String)((com.tencent.mm.vending.j.c)localObject4).get(1);
              ad.i("HellFrontBackMonitor", "HABBYGE-MALI, _doIsBackToFront resume: %s, pause: %s, %s, %s", new Object[] { paramString1, paramString2, localObject2, localObject4 });
              if ((!paramString1.equals(localObject2)) || (!paramString2.equals(localObject4))) {
                break label1736;
              }
            }
          }
          if (com.tencent.mm.plugin.expt.hellhound.core.b.VC(paramString1))
          {
            ad.e("HellFrontBackMonitor", "HABBYGE-MALI, _doIsBackToFront 7事件，过滤小程序");
            paramInt = 0;
          }
          else
          {
            ad.i("HellFrontBackMonitor", "HABBYGE-MALI, _doIsBackToFront ret: true");
            paramInt = 1;
            break label1727;
            label607:
            localObject2 = a.ccp();
            if ((localObject2 == null) || (((amt)localObject2).DnN != 8)) {
              break label1746;
            }
          }
        }
        break;
      }
      break;
    }
    label950:
    label1722:
    label1727:
    label1736:
    label1739:
    label1741:
    label1746:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        ad.i("HellFrontBackMonitor", "HABBYGE-MALI, isFrontToBackAction.lastAction: true");
        if (com.tencent.mm.plugin.expt.hellhound.core.b.VG(paramString1))
        {
          ad.i("HellFrontBackMonitor", "HABBYGE-MALI, _isBackToFront 过滤掉第三方App进入微信的场景: %s", new Object[] { paramString1 });
          break label1741;
        }
        ((c)localObject3).pGL = true;
        paramInt = 1;
        break label373;
      }
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
      localObject4 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbJ();
      localObject2 = null;
      if (localObject4 != null) {
        localObject2 = (String)((com.tencent.mm.vending.j.b)localObject4).get(0);
      }
      if ((!TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty((CharSequence)localObject2)))
      {
        ad.i("HellFrontBackMonitor", "HABBYGE-MALI, HellFrontBackMonitor _isBackToFront: crash路径 !!!");
        h.vKh.idkeyStat(932L, 98L, 1L, false);
        paramInt = 1;
        break label373;
        label748:
        ad.i("HellFrontBackMonitor", "HABBYGE-MALI, backToFront: isFrontToBackOfLastAction: FALSE");
        break label187;
        ad.i("HellFrontBackMonitor", "HABBYGE-MALI, frontBack ACTION_PAUSE: %s", new Object[] { paramString1 });
        boolean bool2 = false;
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cbL();
        bool1 = bool2;
        if (localObject2 != null)
        {
          ad.i("HellFrontBackMonitor", "HABBYGE-MALI, judgeFront2BackOnPause topActivity: %s, %s", new Object[] { ((bh)localObject2).CvH.activityName, ((bh)localObject2).CvH.DnR });
          if (((bh)localObject2).CvH.activityName.startsWith("com.tencent.mm")) {
            break label950;
          }
          ad.i("HellFrontBackMonitor", "HABBYGE-MALI, judgeFront2BackOnPause 栈顶非微信页面: %s", new Object[] { ((bh)localObject2).CvH.activityName });
          bool1 = true;
        }
        for (;;)
        {
          ad.i("HellFrontBackMonitor", "HABBYGE-MALI, judgeFront2BackOnPause: is8Event: %b", new Object[] { Boolean.valueOf(bool1) });
          if (bool1) {
            break label1044;
          }
          bool1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cbS().pEO.cbP();
          ad.i("HellFrontBackMonitor", "HABBYGE-MALI, judgeFront2BackOnPause.startActivity: %b, %s", new Object[] { Boolean.valueOf(bool1), paramString1 });
          if (!bool1) {
            break;
          }
          ((c)localObject3).pGM = false;
          AppMethodBeat.o(184359);
          return;
          bool1 = bool2;
          if ("com.tencent.mm.ui.transmit.SendAppMessageWrapperUI".equals(((bh)localObject2).CvH.activityName))
          {
            bool1 = bool2;
            if ("com.tencent.mm.plugin.sns.ui.SnsUploadUI".equals(paramString1)) {
              bool1 = true;
            }
          }
        }
        bool1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cbS().pEO.VW(paramString1);
        ad.i("HellFrontBackMonitor", "HABBYGE-MALI, judgeFront2BackOnPause.finish: %b, %s", new Object[] { Boolean.valueOf(bool1), paramString1 });
        if (bool1)
        {
          ((c)localObject3).pGM = false;
          AppMethodBeat.o(184359);
          return;
        }
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Bq(104);
        localObject4 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Bq(105);
        ad.i("HellFrontBackMonitor", "HABBYGE-MALI, judgeFrontToBackOnPause: %s, %s", new Object[] { localObject2, localObject4 });
        if ((com.tencent.mm.plugin.expt.hellhound.core.b.Vv((String)localObject2)) && (com.tencent.mm.plugin.expt.hellhound.core.b.Vt((String)localObject4)))
        {
          ad.i("HellFrontBackMonitor", "HABBYGE-MALI, judgeFrontToBackOnPause, SelectContactUI NOT 8-Event !!");
          AppMethodBeat.o(184359);
          return;
        }
        if ((com.tencent.mm.plugin.expt.hellhound.core.b.Vu((String)localObject2)) || (com.tencent.mm.plugin.expt.hellhound.core.b.Vv((String)localObject4)))
        {
          ad.i("HellFrontBackMonitor", "HABBYGE-MALI, judgeFrontToBackOnPause, GroupCardSelectUI NOT 8-Event !!");
          AppMethodBeat.o(184359);
          return;
        }
        if ((!com.tencent.mm.plugin.expt.hellhound.core.b.Vt(paramString1)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.VL((String)localObject2)) || (!com.tencent.mm.plugin.expt.hellhound.core.b.Vt((String)localObject4)))
        {
          if (com.tencent.mm.plugin.expt.hellhound.a.e.a.ccz() != -1)
          {
            com.tencent.mm.plugin.expt.hellhound.a.e.a.kf(true);
            ad.i("HellFrontBackMonitor", "HABBYGE-MALI, HellFrontToBackMonitor, judgeFrontToBackOnPause, requestPermission !!");
            AppMethodBeat.o(184359);
            return;
          }
          ad.i("HellFrontBackMonitor", "HABBYGE-MALI, judgeFront2BackOnPause front2back YES: %s", new Object[] { paramString1 });
          com.tencent.mm.plugin.expt.hellhound.core.b.a.a.Bp(8);
          a.BB(8);
          ((c)localObject3).pGM = true;
          ((c)localObject3).q(paramString1, paramString2, paramLong);
        }
        AppMethodBeat.o(184359);
        return;
        ad.i("HellFrontBackMonitor", "HABBYGE-MALI, frontBack ACTION_STOP: %s", new Object[] { paramString1 });
        if (TextUtils.isEmpty(paramString1))
        {
          ad.e("HellFrontBackMonitor", "HABBYGE-MALI, judgeFront2BackOnStop == null");
          AppMethodBeat.o(184359);
          return;
        }
        if (((c)localObject3).pGM)
        {
          ad.i("HellFrontBackMonitor", "HABBYGE-MALI, judgeFront2BackOnStop isFront2Back-1: true");
          AppMethodBeat.o(184359);
          return;
        }
        ad.i("HellFrontBackMonitor", "HABBYGE-MALI, judgeFront2BackOnStop stopActivityName: %s", new Object[] { paramString1 });
        try
        {
          localObject2 = fw(paramString1, paramString2);
          if ((localObject2 == null) || (!((Boolean)((com.tencent.mm.vending.j.d)localObject2).get(2)).booleanValue()))
          {
            ad.i("HellFrontBackMonitor", "HABBYGE-MALI, judgeFront2BackOnStop: false");
            AppMethodBeat.o(184359);
            return;
          }
          ad.i("HellFrontBackMonitor", "HABBYGE-MALI, judgeFront2BackOnStop, 7-event: %s, TRUE", new Object[] { (String)((com.tencent.mm.vending.j.b)localObject2).get(0) });
          com.tencent.mm.plugin.expt.hellhound.core.b.a.a.Bp(8);
          a.BB(8);
          ((c)localObject3).q(paramString1, paramString2, paramLong);
          AppMethodBeat.o(184359);
          return;
        }
        catch (Exception paramString1)
        {
          ad.printErrStackTrace("HellFrontBackMonitor", paramString1, "HABBYGE-MALI, judgeFront2BackOnStop crash", new Object[0]);
          h.vKh.idkeyStat(932L, 42L, 1L, false);
          AppMethodBeat.o(184359);
          return;
        }
        ad.i("HellFrontBackMonitor", "HABBYGE-MALI, frontBack ACTION_FINISH: %s", new Object[] { paramString1 });
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
        if (paramString1 == null) {}
        for (;;)
        {
          try
          {
            ad.e("HellFrontBackMonitor", "HABBYGE-MALI, judgeFront2BackOnFinish: aName == null");
            localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbI();
            if (localObject2 != null)
            {
              paramString1 = (String)((com.tencent.mm.vending.j.b)localObject2).get(0);
              paramString2 = null;
            }
            paramInt = 0;
            ad.i("HellFrontBackMonitor", "HABBYGE-MALI, judgeFront2BackOnFinish activity==null: %s", new Object[] { paramString1 });
            if ((paramInt != 0) && (com.tencent.mm.plugin.expt.hellhound.core.b.Vt(paramString1)))
            {
              ad.i("HellFrontBackMonitor", "HABBYGE-MALI, shutdown && isLauncherUI");
              localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbJ();
              if (localObject2 == null) {
                break label1722;
              }
              localObject2 = (String)((com.tencent.mm.vending.j.b)localObject2).get(0);
              ad.i("HellFrontBackMonitor", "HABBYGE-MALI, _quiteActivity.pause = %s", new Object[] { localObject2 });
              if (!"com.tencent.mm.plugin.setting.ui.setting.SettingsUI".equals(localObject2)) {
                break label1722;
              }
              paramInt = 1;
              if (paramInt != 0)
              {
                a.BB(8);
                com.tencent.mm.plugin.expt.hellhound.core.b.a.a.Bp(8);
                ((c)localObject3).q(paramString1, paramString2, paramLong);
              }
            }
            AppMethodBeat.o(184359);
            return;
          }
          catch (Exception paramString1)
          {
            ad.printErrStackTrace("HellFrontBackMonitor", paramString1, "HABBYGE-MALI, judgeFront2BackOnFinish", new Object[0]);
            h.vKh.idkeyStat(932L, 40L, 1L, false);
          }
          paramInt = 1;
          ad.i("HellFrontBackMonitor", "HABBYGE-MALI, judgeFront2BackOnFinish: %s", new Object[] { paramString1 });
          continue;
          break label128;
          if (!com.tencent.mm.plugin.expt.hellhound.core.b.cbv()) {
            break;
          }
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cbD().Bo(600);
          AppMethodBeat.o(184359);
          return;
          ad.i("HellFrontBackMonitor", "HABBYGE-MALI, HellFrontBackMonitor, ACTION_add7Event_login");
          d.a("login", e.a.pDH, 1, paramLong);
          AppMethodBeat.o(184359);
          return;
          ad.i("HellFrontBackMonitor", "HABBYGE-MALI, HellFrontBackMonitor, ACTION_add8Event_logout");
          d.a("logout", e.a.pDI, -1, paramLong);
          break;
          paramInt = 0;
        }
        for (;;)
        {
          if (paramInt == 0) {
            break label1739;
          }
          paramInt = 1;
          break;
          paramInt = 0;
        }
        break label607;
      }
      paramInt = 0;
      break label373;
    }
  }
  
  public static c ccq()
  {
    AppMethodBeat.i(122031);
    if (pGJ == null) {}
    try
    {
      if (pGJ == null) {
        pGJ = new c();
      }
      c localc = pGJ;
      AppMethodBeat.o(122031);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(122031);
    }
  }
  
  private static com.tencent.mm.vending.j.d<String, String, Boolean> fw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122036);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
    for (;;)
    {
      int i;
      boolean bool1;
      try
      {
        Object localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbI();
        com.tencent.mm.vending.j.c localc = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbJ();
        if ((paramString1 == null) || (localObject == null) || (localc == null))
        {
          ad.e("HellFrontBackMonitor", "HABBYGE-MALI, isFront2BackOnStop: illeagal Event");
          AppMethodBeat.o(122036);
          return null;
        }
        String str = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.VH(str))
        {
          ad.i("HellFrontBackMonitor", "HABBYGE-MALI, isFakeSwitchAccountUI true");
          AppMethodBeat.o(122036);
          return null;
        }
        ad.i("HellFrontBackMonitor", "HABBYGE-MALI, isFront2BackOnStop: Resume: %s, Pause: %s, Stop: %s", new Object[] { localObject, localc, paramString1 });
        if ((paramString2.equals(((com.tencent.mm.vending.j.c)localObject).get(1))) && (paramString2.equals(localc.get(1))))
        {
          i = 1;
          if ((paramString1.equals(str)) && (paramString1.equals(localc.get(0))))
          {
            j = 1;
            break label436;
            ad.i("HellFrontBackMonitor", "HABBYGE-MALI, isFront2BackOnStop, case-1：%b", new Object[] { Boolean.valueOf(bool1) });
            bool2 = bool1;
            if (bool1)
            {
              bool2 = bool1;
              if (!com.tencent.mm.plugin.expt.hellhound.core.b.VI(paramString1))
              {
                bool2 = bool1;
                if (!com.tencent.mm.plugin.expt.hellhound.core.b.VJ(paramString1))
                {
                  localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cbL();
                  bool2 = bool1;
                  if (localObject != null)
                  {
                    ad.i("HellFrontBackMonitor", "HABBYGE-MALI, isFront2BackOnStop isEvent8: %s, %s", new Object[] { ((bh)localObject).CvH.activityName, ((bh)localObject).CvH.DnR });
                    if (!((bh)localObject).CvH.activityName.startsWith("com.tencent.mm")) {
                      continue;
                    }
                    bool2 = bool1;
                    if (TextUtils.isEmpty(((bh)localObject).CvH.DnR))
                    {
                      bool2 = bool1;
                      if (!((bh)localObject).CvH.activityName.equals(paramString1))
                      {
                        ad.i("HellFrontBackMonitor", "HABBYGE-MALI, isFront2BackOnStop isEvent8-1: false");
                        bool2 = false;
                      }
                    }
                  }
                }
              }
            }
            ad.i("HellFrontBackMonitor", "HABBYGE-MALI, isFront2BackOnStop case1 && case2：%b", new Object[] { Boolean.valueOf(bool2) });
            paramString1 = com.tencent.mm.vending.j.a.i(paramString1, paramString2, Boolean.valueOf(bool2));
            AppMethodBeat.o(122036);
            return paramString1;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        int j = 0;
        break label436;
        bool1 = false;
        continue;
        ad.i("HellFrontBackMonitor", "HABBYGE-MALI, isFront2BackOnStop: NOT wx activity");
        boolean bool2 = bool1;
        continue;
        if (j == 0) {
          continue;
        }
      }
      catch (Exception paramString1)
      {
        ad.printErrStackTrace("HellFrontBackMonitor", paramString1, "HABBYGE-MALI, isFront2BackOnStop", new Object[0]);
        h.vKh.idkeyStat(932L, 43L, 1L, false);
        AppMethodBeat.o(122036);
        return null;
      }
      label436:
      if (i != 0) {
        bool1 = true;
      }
    }
  }
  
  private void p(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(184360);
    if (this.pGI != null) {
      this.pGI.n(paramString1, paramString2, paramLong);
    }
    AppMethodBeat.o(184360);
  }
  
  private void q(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(184361);
    if (this.pGI != null) {
      this.pGI.o(paramString1, paramString2, paramLong);
    }
    AppMethodBeat.o(184361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.c.c
 * JD-Core Version:    0.7.0.1
 */