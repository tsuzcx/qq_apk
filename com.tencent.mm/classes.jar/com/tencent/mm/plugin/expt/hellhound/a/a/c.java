package com.tencent.mm.plugin.expt.hellhound.a.a;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.c;
import com.tencent.mm.plugin.expt.a.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aef;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.ckn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.j.f;

public final class c
{
  private static volatile c maF;
  a maD;
  public b.c maE;
  private boolean maG;
  private boolean maH;
  private boolean maI;
  
  private c()
  {
    AppMethodBeat.i(73451);
    this.maG = false;
    this.maH = false;
    this.maI = true;
    this.maD = new a();
    AppMethodBeat.o(73451);
  }
  
  private boolean Mr(String paramString)
  {
    AppMethodBeat.i(73453);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
    try
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.d.brF();
      if (localObject == null) {
        break label110;
      }
      localObject = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
    }
    catch (Exception localException)
    {
      CharSequence localCharSequence;
      for (;;)
      {
        Object localObject;
        h.qsU.idkeyStat(932L, 45L, 1L, false);
        localCharSequence = null;
      }
      if ((!"com.tencent.mm.app.WeChatSplashActivity".equals(paramString)) || (!TextUtils.isEmpty(localCharSequence))) {
        break label145;
      }
      ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 1");
      AppMethodBeat.o(73453);
      return true;
      if (!"com.tencent.mm.app.WeChatSplashActivity".equals(paramString)) {
        break label192;
      }
      if ((localCharSequence == null) || (!localCharSequence.startsWith("com.tencent.mm.splash."))) {
        break label187;
      }
      for (int i = 1; i != 0; i = 0)
      {
        ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 splash hook restart ~");
        AppMethodBeat.o(73453);
        return true;
      }
      if ((!"com.tencent.mm.ui.LauncherUI".equals(paramString)) || (!TextUtils.isEmpty(localCharSequence))) {
        break label222;
      }
      ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 2");
      AppMethodBeat.o(73453);
      return true;
      if ((!"com.tencent.mm.app.WeChatSplashActivity".equals(localCharSequence)) || ("com.tencent.mm.plugin.base.stub.WXEntryActivity".equals(paramString)) || ("com.tencent.mm.plugin.base.stub.UIEntryStub".equals(paramString)) || ("com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI".equals(paramString))) {
        break label272;
      }
      ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 3");
      AppMethodBeat.o(73453);
      return true;
      if ((!"com.tencent.mm.app.WeChatSplashActivity".equals(localCharSequence)) || (!"com.tencent.mm.ui.LauncherUI".equals(paramString))) {
        break label309;
      }
      this.maG = true;
      ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 4");
      AppMethodBeat.o(73453);
      return true;
      if ((!"com.tencent.mm.ui.tools.ShareToTimeLineUI".equals(paramString)) || (localCharSequence != null)) {
        break label336;
      }
      ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx: frome outer jump to Timeline");
      AppMethodBeat.o(73453);
      return true;
      if ((!"com.tencent.mm.ui.tools.AddFavoriteUI".equals(paramString)) || (!"com.tencent.mm.app.WeChatSplashActivity".equals(localCharSequence))) {
        break label368;
      }
      ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx: from outer jump to 收藏");
      AppMethodBeat.o(73453);
      return true;
      if (!Ms(paramString)) {
        break label389;
      }
      ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 通过小程序桌面快捷方式");
      AppMethodBeat.o(73453);
      return true;
      if (!"com.tencent.mm.plugin.base.stub.UIEntryStub".equals(paramString)) {
        break label412;
      }
      ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 通过第三方拉起微信(第三方登录、分享好友、朋友圈)");
      AppMethodBeat.o(73453);
      return true;
      if ((!"com.tencent.mm.plugin.account.ui.LoginPasswordUI".equals(paramString)) || (!"com.tencent.mm.ui.LauncherUI".equals(localCharSequence))) {
        break label449;
      }
      ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 之前登录过，登录页");
      if (!this.maG) {
        break label456;
      }
      this.maG = false;
      AppMethodBeat.o(73453);
      return false;
    }
    ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx resume/pause = " + paramString + "/" + (String)localObject);
    if (("com.tencent.mm.plugin.voip.ui.VideoActivity".equals(paramString)) && ((TextUtils.isEmpty((CharSequence)localObject)) || ("com.tencent.mm.app.WeChatSplashActivity".equals(localObject))))
    {
      ab.i("HellFrontBackMonitor", "habbyge-mali, VOIP start MM Process");
      AppMethodBeat.o(73453);
      return true;
    }
    label110:
    label368:
    while (this.maH) {
      this.maH = false;
    }
    label145:
    label187:
    label192:
    label222:
    AppMethodBeat.o(73453);
    label272:
    label309:
    label336:
    return true;
  }
  
  private static boolean Ms(String paramString)
  {
    AppMethodBeat.i(73454);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
    label75:
    CharSequence localCharSequence;
    try
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.d.brF();
      if (localObject == null) {
        break label75;
      }
      localObject = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        ab.printErrStackTrace("HellFrontBackMonitor", localException, "habbyge-mali, isStartWxByLittlePragramShortcut", new Object[0]);
        localCharSequence = null;
        continue;
        i = 0;
      }
      label85:
      if ((!com.tencent.mm.plugin.expt.hellhound.core.b.Mc(paramString)) || (!TextUtils.isEmpty(localCharSequence))) {
        break label119;
      }
      label119:
      for (int i = 1; i != 0; i = 0)
      {
        ab.i("HellFrontBackMonitor", "habbyge-mali, isStartWxByLittlePragramShortcut case-2");
        AppMethodBeat.o(73454);
        return true;
      }
      if (!com.tencent.mm.plugin.expt.hellhound.core.b.Mc(paramString)) {
        break label160;
      }
    }
    if ((com.tencent.mm.plugin.expt.hellhound.core.b.Mc(paramString)) && ("com.tencent.mm.plugin.base.stub.WXShortcutEntryActivity".equals(localObject)))
    {
      i = 1;
      if (i == 0) {
        break label85;
      }
      ab.i("HellFrontBackMonitor", "habbyge-mali, isStartWxByLittlePragramShortcut case-1");
      AppMethodBeat.o(73454);
      return true;
    }
    if ("com.tencent.mm.app.WeChatSplashActivity".equals(localCharSequence)) {}
    label160:
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        ab.i("HellFrontBackMonitor", "habbyge-mali, isStartWxByLittlePragramShortcut case-3");
      }
      AppMethodBeat.o(73454);
      return bool;
    }
  }
  
  public static c brV()
  {
    AppMethodBeat.i(73450);
    if (maF == null) {}
    try
    {
      if (maF == null) {
        maF = new c();
      }
      c localc = maF;
      AppMethodBeat.o(73450);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(73450);
    }
  }
  
  private static com.tencent.mm.vending.j.d<String, String, Boolean> ei(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73455);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
    for (;;)
    {
      int i;
      boolean bool1;
      try
      {
        Object localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.d.brE();
        com.tencent.mm.vending.j.c localc = com.tencent.mm.plugin.expt.hellhound.core.stack.d.brF();
        if ((paramString1 == null) || (localObject == null) || (localc == null))
        {
          ab.e("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop: illeagal Event");
          AppMethodBeat.o(73455);
          return null;
        }
        if ("com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI".equals((String)((com.tencent.mm.vending.j.b)localObject).get(0)))
        {
          ab.i("HellFrontBackMonitor", "habbyge-mali, isFakeSwitchAccountUI true");
          AppMethodBeat.o(73455);
          return null;
        }
        ab.i("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop: Resume/pause/stop = " + localObject + "/" + localc + "/" + paramString1);
        if ((paramString2.equals(((com.tencent.mm.vending.j.c)localObject).get(1))) && (paramString2.equals(localc.get(1))))
        {
          i = 1;
          if ((paramString1.equals(((com.tencent.mm.vending.j.b)localObject).get(0))) && (paramString1.equals(localc.get(0))))
          {
            j = 1;
            break label486;
            ab.i("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop, case-1：".concat(String.valueOf(bool1)));
            bool2 = bool1;
            if (bool1)
            {
              bool2 = bool1;
              if (!"com.tencent.mm.plugin.voip.ui.VideoActivity".equals(paramString1))
              {
                bool2 = bool1;
                if (!"com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity".equals(paramString1))
                {
                  localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.brH();
                  bool2 = bool1;
                  if (localObject != null)
                  {
                    ab.i("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop isEvent8: " + ((be)localObject).wnr.activityName + ":" + ((be)localObject).wnr.wXg);
                    if (!((be)localObject).wnr.activityName.startsWith("com.tencent.mm")) {
                      continue;
                    }
                    if (!TextUtils.isEmpty(((be)localObject).wnr.wXg)) {
                      continue;
                    }
                    bool2 = bool1;
                    if (!((be)localObject).wnr.activityName.equals(paramString1))
                    {
                      ab.i("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop isEvent8-1: false");
                      bool2 = false;
                    }
                  }
                }
              }
            }
            ab.i("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop case1 && case2：".concat(String.valueOf(bool2)));
            paramString1 = com.tencent.mm.vending.j.a.i(paramString1, paramString2, Boolean.valueOf(bool2));
            AppMethodBeat.o(73455);
            return paramString1;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        int j = 0;
        break label486;
        bool1 = false;
        continue;
        boolean bool2 = bool1;
        if (com.tencent.mm.plugin.expt.hellhound.core.stack.d.k(paramString1, paramString2, ((be)localObject).wnr.activityName, ((be)localObject).wnr.wXg)) {
          continue;
        }
        ab.i("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop isEvent8-2: false");
        bool2 = false;
        continue;
        ab.i("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop: NOT wx activity");
        bool2 = bool1;
        continue;
        if (j == 0) {
          continue;
        }
      }
      catch (Exception paramString1)
      {
        ab.printErrStackTrace("HellFrontBackMonitor", paramString1, "habbyge-mali, isFront2BackOnStop", new Object[0]);
        h.qsU.idkeyStat(932L, 43L, 1L, false);
        AppMethodBeat.o(73455);
        return null;
      }
      label486:
      if (i != 0) {
        bool1 = true;
      }
    }
  }
  
  private void ej(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73456);
    if (this.maE != null) {
      this.maE.ee(paramString1, paramString2);
    }
    AppMethodBeat.o(73456);
  }
  
  private void ek(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73457);
    if (this.maE != null) {
      this.maE.ef(paramString1, paramString2);
    }
    AppMethodBeat.o(73457);
  }
  
  public static void s(int paramInt, String paramString1, String paramString2)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(73452);
    if (!com.tencent.mm.plugin.expt.hellhound.a.bro())
    {
      ab.w("HellFrontBackMonitor", "habbyge-mali, HellFrontBackMonitor monitor close !!!");
      AppMethodBeat.o(73452);
      return;
    }
    ab.i("HellFrontBackMonitor", "habbyge-mali, HellFrontBackMonitor monitor start !!!");
    Object localObject3 = brV();
    label132:
    label211:
    boolean bool;
    label320:
    label366:
    Object localObject4;
    Object localObject2;
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(73452);
      return;
    case 100: 
    case 101: 
    case 102: 
    case 103: 
      if (!TextUtils.isEmpty(paramString1)) {}
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(73452);
        return;
      case 100: 
        if (!TextUtils.isEmpty(paramString1))
        {
          ab.i("HellFrontBackMonitor", "habbyge-mali, judgeBackToFront: " + paramString1 + "/" + paramString2);
          if (!((c)localObject3).Mr(paramString1)) {
            break label320;
          }
          ab.i("HellFrontBackMonitor", "habbyge-mali, judgeBackToFront: _launchWx TRUE");
          com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.vm(7);
          a.vq(7);
          ((c)localObject3).ej(paramString1, paramString2);
        }
        for (;;)
        {
          localObject3 = a.brU();
          Object localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = new aef();
          }
          if (com.tencent.mm.plugin.expt.hellhound.core.b.brt()) {
            ((aef)localObject1).wXe = Process.myPid();
          }
          ((aef)localObject1).wXf = paramString1;
          ((aef)localObject1).wXg = paramString2;
          ((aef)localObject1).wXd = System.currentTimeMillis();
          ab.d("FrontBackDao", "habbyge-mali, setLastMMProcessParamsOnResume: " + ((aef)localObject1).wXf + "/" + ((aef)localObject1).fQD);
          a.a((aef)localObject1);
          AppMethodBeat.o(73452);
          return;
          ab.i("HellFrontBackMonitor", "habbyge-mali, judgeBackToFront: _launchWx FALSE");
          try
          {
            bool = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.c.brO().mah.Ml(paramString1);
            ab.i("HellFrontBackMonitor", "habbyge-mali, _doIsBackToFront isStartActivity: ".concat(String.valueOf(bool)));
            if (!bool) {
              break;
            }
            paramInt = 0;
          }
          catch (Exception localException)
          {
            ab.printErrStackTrace("HellFrontBackMonitor", localException, "habbyge-mali, backToFront crash", new Object[0]);
            h.qsU.idkeyStat(932L, 44L, 1L, false);
          }
          if (paramInt == 0) {
            break label759;
          }
          ab.i("HellFrontBackMonitor", "habbyge-mali, backToFront: isFrontToBackOfLastAction: YES");
          com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.vm(7);
          a.vq(7);
          ((c)localObject3).ej(paramString1, paramString2);
        }
        bool = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.c.brO().mah.brL();
        ab.i("HellFrontBackMonitor", "habbyge-mali, _doIsBackToFront isFinish: ".concat(String.valueOf(bool)));
        if (bool)
        {
          paramInt = 0;
        }
        else
        {
          if (!TextUtils.isEmpty(paramString1))
          {
            com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
            localObject4 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.brF();
            if (localObject4 != null)
            {
              localObject2 = (String)((com.tencent.mm.vending.j.b)localObject4).get(0);
              localObject4 = (String)((com.tencent.mm.vending.j.c)localObject4).get(1);
              ab.i("HellFrontBackMonitor", "habbyge-mali, _doIsBackToFront resume/pause " + paramString1 + ":" + paramString2 + " / " + (String)localObject2 + ":" + (String)localObject4);
              if ((!paramString1.equals(localObject2)) || (!paramString2.equals(localObject4))) {
                break label2180;
              }
            }
          }
          if (com.tencent.mm.plugin.expt.hellhound.core.b.Mc(paramString1))
          {
            ab.e("HellFrontBackMonitor", "habbyge-mali, _doIsBackToFront 7事件，过滤小程序");
            paramInt = 0;
          }
          else
          {
            ab.i("HellFrontBackMonitor", "habbyge-mali, _doIsBackToFront ret: true");
            paramInt = 1;
            break label2171;
            label617:
            localObject2 = a.brU();
            if ((localObject2 == null) || (((aef)localObject2).wXc != 8)) {
              break label2190;
            }
          }
        }
        break;
      }
      break;
    }
    label2180:
    label2183:
    label2185:
    label2190:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        ab.i("HellFrontBackMonitor", "habbyge-mali, isFrontToBackAction.lastAction: true");
        if ("com.tencent.mm.plugin.base.stub.WXEntryActivity".equals(paramString1))
        {
          ab.i("HellFrontBackMonitor", "habbyge-mali, _isBackToFront 过滤掉第三方App进入微信的场景: ".concat(String.valueOf(paramString1)));
          break label2185;
        }
        ((c)localObject3).maH = true;
        paramInt = i;
        break label366;
      }
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
      localObject4 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.brF();
      localObject2 = null;
      if (localObject4 != null) {
        localObject2 = (String)((com.tencent.mm.vending.j.b)localObject4).get(0);
      }
      if ((!TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty((CharSequence)localObject2)))
      {
        ab.i("HellFrontBackMonitor", "habbyge-mali, HellFrontBackMonitor _isBackToFront: crash路径 !!!");
        h.qsU.idkeyStat(932L, 98L, 1L, false);
        paramInt = i;
        break label366;
        label759:
        ab.i("HellFrontBackMonitor", "habbyge-mali, backToFront: isFrontToBackOfLastAction: FALSE");
        break label211;
        ab.i("HellFrontBackMonitor", "habbyge-mali, frontBack ACTION_PAUSE: ".concat(String.valueOf(paramString1)));
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.e.brH();
        if (localObject2 != null)
        {
          ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnPause topActivity: " + ((be)localObject2).wnr.activityName + ":" + ((be)localObject2).wnr.wXg);
          if (!((be)localObject2).wnr.activityName.startsWith("com.tencent.mm"))
          {
            ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnPause 栈顶非微信页面: " + ((be)localObject2).wnr.activityName);
            bool = true;
          }
        }
        for (;;)
        {
          ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnPause: is8Event = ".concat(String.valueOf(bool)));
          if (!bool)
          {
            bool = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.c.brO().mah.Mn(paramString1);
            ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnPause.startActivity: " + bool + "/" + paramString1);
            if (bool)
            {
              ((c)localObject3).maI = false;
              AppMethodBeat.o(73452);
              return;
              if ((!"com.tencent.mm.ui.transmit.SendAppMessageWrapperUI".equals(((be)localObject2).wnr.activityName)) || (!"com.tencent.mm.plugin.sns.ui.SnsUploadUI".equals(paramString1))) {
                break label2165;
              }
              bool = true;
              continue;
            }
            bool = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.c.brO().mah.Mo(paramString1);
            ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnPause.finish: " + bool + "/" + paramString1);
            if (bool)
            {
              ((c)localObject3).maI = false;
              AppMethodBeat.o(73452);
              return;
            }
          }
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.e.vn(104);
          localObject4 = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.e.vn(105);
          ab.w("HellFrontBackMonitor", "habbyge-mali, judgeFrontToBackOnPause: " + (String)localObject2 + " | " + (String)localObject4);
          if (("com.tencent.mm.ui.contact.SelectContactUI".equals(localObject2)) && ("com.tencent.mm.ui.LauncherUI".equals(localObject4)))
          {
            ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFrontToBackOnPause, SelectContactUI NOT 8-Event !!");
            AppMethodBeat.o(73452);
            return;
          }
          if (("com.tencent.mm.ui.contact.GroupCardSelectUI".equals(localObject2)) || ("com.tencent.mm.ui.contact.SelectContactUI".equals(localObject4)))
          {
            ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFrontToBackOnPause, GroupCardSelectUI NOT 8-Event !!");
            AppMethodBeat.o(73452);
            return;
          }
          ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnPause front2back YES: ".concat(String.valueOf(paramString1)));
          com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.vm(8);
          a.vq(8);
          ((c)localObject3).maI = true;
          ((c)localObject3).ek(paramString1, paramString2);
          AppMethodBeat.o(73452);
          return;
          ab.i("HellFrontBackMonitor", "habbyge-mali, frontBack ACTION_STOP: ".concat(String.valueOf(paramString1)));
          if (TextUtils.isEmpty(paramString1))
          {
            ab.e("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnStop == null");
            AppMethodBeat.o(73452);
            return;
          }
          if (((c)localObject3).maI)
          {
            ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnStop isFront2Back-1: true");
            AppMethodBeat.o(73452);
            return;
          }
          ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnStop stopActivityName: ".concat(String.valueOf(paramString1)));
          try
          {
            localObject2 = ei(paramString1, paramString2);
            if ((localObject2 == null) || (!((Boolean)((com.tencent.mm.vending.j.d)localObject2).get(2)).booleanValue()))
            {
              ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnStop: false");
              AppMethodBeat.o(73452);
              return;
            }
            localObject2 = (String)((com.tencent.mm.vending.j.b)localObject2).get(0);
            ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnStop, 7-event: " + (String)localObject2 + " / true");
            com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.vm(8);
            a.vq(8);
            ((c)localObject3).ek(paramString1, paramString2);
            AppMethodBeat.o(73452);
            return;
          }
          catch (Exception paramString1)
          {
            ab.printErrStackTrace("HellFrontBackMonitor", paramString1, "habbyge-mali, judgeFront2BackOnStop crash", new Object[0]);
            h.qsU.idkeyStat(932L, 42L, 1L, false);
            AppMethodBeat.o(73452);
            return;
          }
          ab.i("HellFrontBackMonitor", "habbyge-mali, frontBack ACTION_FINISH: ".concat(String.valueOf(paramString1)));
          com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
          if (paramString1 == null) {}
          for (;;)
          {
            try
            {
              ab.e("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnFinish: aName == null");
              localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.brE();
              if (localObject2 != null)
              {
                paramString1 = (String)((com.tencent.mm.vending.j.b)localObject2).get(0);
                paramString2 = null;
              }
              ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnFinish activity==null: ".concat(String.valueOf(paramString1)));
              paramInt = 0;
              ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnFinish, aName: ".concat(String.valueOf(paramString1)));
              if ((paramInt != 0) && ("com.tencent.mm.ui.LauncherUI".equals(paramString1)))
              {
                ab.i("HellFrontBackMonitor", "habbyge-mali, shutdown && isLauncherUI");
                localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.brF();
                if (localObject2 == null) {
                  break label2160;
                }
                localObject2 = (String)((com.tencent.mm.vending.j.b)localObject2).get(0);
                ab.i("HellFrontBackMonitor", "habbyge-mali, _quiteActivity.pause = ".concat(String.valueOf(localObject2)));
                if (!"com.tencent.mm.plugin.setting.ui.setting.SettingsUI".equals(localObject2)) {
                  break label2160;
                }
                paramInt = j;
                if (paramInt != 0)
                {
                  a.vq(8);
                  com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.vm(8);
                  ((c)localObject3).ek(paramString1, paramString2);
                }
              }
              AppMethodBeat.o(73452);
              return;
            }
            catch (Exception paramString1)
            {
              ab.printErrStackTrace("HellFrontBackMonitor", paramString1, "habbyge-mali, judgeFront2BackOnFinish", new Object[0]);
              h.qsU.idkeyStat(932L, 40L, 1L, false);
            }
            ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnFinish: ".concat(String.valueOf(paramString1)));
            paramInt = 1;
            continue;
            break label132;
            ab.i("HellFrontBackMonitor", "habbyge-mali, add8EventMMProcessEndIfNeed");
            if (!com.tencent.mm.plugin.expt.hellhound.core.b.brt())
            {
              paramString1 = null;
              if (paramString1 != null)
              {
                a.vq(8);
                com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.vm(8);
                paramString2 = (String)paramString1.get(0);
                localObject2 = (String)paramString1.get(1);
                paramInt = ((Integer)paramString1.get(2)).intValue();
                long l = ((Long)paramString1.get(3)).longValue();
                i = ((Integer)paramString1.get(4)).intValue();
                ab.i("HellFrontBackMonitor", "habbyge-mali, add8EventMMProcessEndIfNeed need 补充8事件: " + paramString2 + "/" + paramInt + "/" + l + "/" + i);
                if (((c)localObject3).maE != null) {
                  ((c)localObject3).maE.a(paramString2, (String)localObject2, paramInt, l, i);
                }
              }
              AppMethodBeat.o(73452);
              return;
            }
            paramInt = Process.myPid();
            paramString2 = a.brU();
            paramString1 = paramString2;
            if (paramString2 == null) {
              paramString1 = new aef();
            }
            if (paramString1.wXe <= 0)
            {
              ab.i("FrontBackDao", "habbyge-mali, handleLastProcessParams lastMMProcessId <= 0");
              paramString1 = null;
            }
            for (;;)
            {
              break;
              if (paramString1.wXe != paramInt)
              {
                ab.i("FrontBackDao", "habbyge-mali, handleLastProcessParams last != curr ---1: " + paramString1.wXe + "/" + paramInt);
                if (paramString1.wXc == 7)
                {
                  brV();
                  paramString2 = a.brU();
                  if ((paramString2 != null) && (paramString2.wXh)) {}
                  for (paramInt = 1;; paramInt = 0)
                  {
                    if (paramInt == 0) {
                      break label1999;
                    }
                    ab.w("FrontBackDao", "habbyge-mali, getIsLogoutFromMMPageFlowService true");
                    a.hi(false);
                    paramString1 = null;
                    break;
                  }
                  label1999:
                  if (TextUtils.isEmpty("page_hell_seq_mmkv_key")) {}
                  for (paramInt = -1;; paramInt = as.apq("_hellhound_mmkv").getInt("page_hell_seq_mmkv_key", -1))
                  {
                    paramString1.fQD = paramInt;
                    paramString1 = com.tencent.mm.vending.j.a.b(paramString1.wXf, paramString1.wXg, Integer.valueOf(paramString1.wXe), Long.valueOf(paramString1.wXd), Integer.valueOf(paramString1.fQD));
                    break;
                  }
                }
              }
              else
              {
                ab.i("FrontBackDao", "habbyge-mali, handleLastProcessParams last == curr: " + paramString1.wXe + "/" + paramInt);
              }
              paramString1 = null;
            }
            ab.i("HellFrontBackMonitor", "habbyge-mali, HellFrontBackMonitor, ACTION_add7Event_login");
            d.a("login", c.a.lZt, 1, bo.aoy());
            AppMethodBeat.o(73452);
            return;
            ab.i("HellFrontBackMonitor", "habbyge-mali, HellFrontBackMonitor, ACTION_add8Event_logout");
            d.a("logout", c.a.lZu, -1, bo.aoy());
            break;
            label2160:
            paramInt = 0;
          }
          label2165:
          bool = false;
        }
        for (;;)
        {
          label2171:
          if (paramInt == 0) {
            break label2183;
          }
          paramInt = i;
          break;
          paramInt = 0;
        }
        break label617;
      }
      paramInt = 0;
      break label366;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.c
 * JD-Core Version:    0.7.0.1
 */