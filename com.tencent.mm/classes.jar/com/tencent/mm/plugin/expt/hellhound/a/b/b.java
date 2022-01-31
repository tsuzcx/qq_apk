package com.tencent.mm.plugin.expt.hellhound.a.b;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.v2.a.f;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.protocal.protobuf.ava;
import com.tencent.mm.protocal.protobuf.azc;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.protocal.protobuf.bki;
import com.tencent.mm.protocal.protobuf.ckn;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  private static b maJ;
  private int maK;
  private int maL;
  private long maM;
  
  private b()
  {
    AppMethodBeat.i(73461);
    this.maK = -1;
    this.maL = -1;
    this.maM = -1L;
    AppMethodBeat.o(73461);
  }
  
  private static void IE()
  {
    AppMethodBeat.i(152355);
    ab.i("HellSessionMonitor", "HABBYGE-MALI, HellSessionMonitor, report...");
    ava localava = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsk();
    if (localava == null)
    {
      AppMethodBeat.o(152355);
      return;
    }
    aux localaux = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.bsu();
    if (localaux == null)
    {
      AppMethodBeat.o(152355);
      return;
    }
    com.tencent.mm.sdk.g.d.ysm.execute(new b.2(localava, localaux));
    com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsi();
    com.tencent.mm.plugin.expt.hellhound.a.b.c.a.reset();
    AppMethodBeat.o(152355);
  }
  
  private static void J(int paramInt, long paramLong)
  {
    AppMethodBeat.i(152343);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(152343);
      return;
      jA(paramLong);
      AppMethodBeat.o(152343);
      return;
      K(paramInt, paramLong);
    }
  }
  
  private static void K(int paramInt, long paramLong)
  {
    AppMethodBeat.i(152345);
    bki localbki = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsj();
    if (localbki == null)
    {
      ab.e("HellSessionMonitor", "HABBYGE-MALI, _chattingUIOut, 不是合法session !!!");
      AppMethodBeat.o(152345);
      return;
    }
    ab.i("HellSessionMonitor", "HABBYGE-MALI, _chattingUIOut, curSessionId: " + localbki.czq);
    if (!com.tencent.mm.plugin.expt.hellhound.a.b.a.b.My(localbki.czq))
    {
      ab.w("HellSessionMonitor", "HABBYGE-MALI, _chattingUIOut, not chat session: " + localbki.czq);
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.brH();
      if (localObject != null)
      {
        localObject = ((be)localObject).wnr.activityName;
        ab.w("HellSessionMonitor", "HABBYGE-MALI, _chattingUIOut, not chat session, page: ".concat(String.valueOf(localObject)));
        com.tencent.mm.plugin.expt.hellhound.a.b.c.b.a(localbki, (String)localObject, paramLong);
      }
      AppMethodBeat.o(152345);
      return;
    }
    Object localObject = a.brW();
    ab.i("HellSessionMonitor", "HABBYGE-MALI, _chattingUIOut, userName: ".concat(String.valueOf((String)((com.tencent.mm.vending.j.b)localObject).get(0))));
    int i = ((Integer)((com.tencent.mm.vending.j.c)localObject).get(1)).intValue();
    ab.i("HellSessionMonitor", "HABBYGE-MALI, _chattingUIOut, newChattingType: ".concat(String.valueOf(i)));
    if (i == localbki.xyL)
    {
      if ("ChattingUI".equals(localbki.xyK))
      {
        ab.i("HellSessionMonitor", "HABBYGE-MALI, chattingUIOut, CHATTING_UI");
        a(localbki, paramLong);
        AppMethodBeat.o(152345);
        return;
      }
      if (paramInt == 2)
      {
        ab.i("HellSessionMonitor", "HABBYGE-MALI, chattingUIOut, SLIENCE: " + localbki.xyK);
        a(localbki, paramLong);
        AppMethodBeat.o(152345);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.brH();
      if (localObject != null)
      {
        com.tencent.mm.plugin.expt.hellhound.a.b.c.b.a(localbki, ((be)localObject).wnr.activityName, paramLong);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.a.f(localbki);
      }
      AppMethodBeat.o(152345);
      return;
    }
    ab.e("HellSessionMonitor", "HABBYGE-MALI, _chattingUIOut, curChattingType不等: ".concat(String.valueOf(i)));
    AppMethodBeat.o(152345);
  }
  
  public static void Mu(String paramString)
  {
    AppMethodBeat.i(152326);
    if (brZ())
    {
      ab.i("HellSessionMonitor", "habbyge-mali, HellSessionMonitor, monitorScanSession: FALSE");
      AppMethodBeat.o(152326);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsj();
    if (localObject != null)
    {
      ab.i("ScanSessionHandler", "HABBYGE-MALI, ScanSessionHandler scanSessionOnReume, curSession: " + ((bki)localObject).czq + " | " + paramString);
      if (com.tencent.mm.plugin.expt.hellhound.a.b.f.a.MT(((bki)localObject).czq))
      {
        String str = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(paramString);
        if ("com.tencent.mm.ui.LauncherUI".equals(paramString))
        {
          a((bki)localObject, l);
          localObject = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.Mv(((bki)localObject).czq);
          paramString = str;
          if (localObject != null)
          {
            if (!"124".equals(localObject)) {
              break label157;
            }
            paramString = "FindMoreFriendsUI";
          }
          for (;;)
          {
            ab.i("ScanSessionHandler", "habbyge-mali, scanSessionOnReume, realPageName: ".concat(String.valueOf(paramString)));
            AppMethodBeat.o(152326);
            return;
            label157:
            paramString = str;
            if ("109".equals(localObject)) {
              paramString = "MainUI";
            }
          }
        }
        if ((localObject == null) || (TextUtils.isEmpty(str)))
        {
          AppMethodBeat.o(152326);
          return;
        }
        if (com.tencent.mm.plugin.expt.hellhound.a.b.f.a.MT(((bki)localObject).czq)) {
          com.tencent.mm.plugin.expt.hellhound.a.b.c.b.b((bki)localObject, str, l);
        }
      }
    }
    AppMethodBeat.o(152326);
  }
  
  private static void N(String paramString, long paramLong)
  {
    AppMethodBeat.i(152331);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(152331);
      return;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsk();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ava();
    }
    ((ava)localObject1).xki = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.b.b.a.b((ava)localObject1);
    ab.i("HellSessionMonitor", "HABBYGE-MALI, _launcherUIOn7Event: " + paramString + ", " + ((ava)localObject1).xki);
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsj();
    if (localObject1 != null)
    {
      if (((bki)localObject1).xyO)
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.Mv(((bki)localObject1).czq);
        ab.i("HellSessionMonitor", "HABBYGE-MALI, _launcherUIOn7Event, curSessionId: ".concat(String.valueOf(localObject2)));
        if ((com.tencent.mm.plugin.expt.hellhound.a.b.a.b.Mx((String)localObject2)) && ("com.tencent.mm.ui.LauncherUI".equals(paramString)))
        {
          ab.w("HellSessionMonitor", "HABBYGE-MALI, _launcherUIOn7Event, AppBrand 7Event !!!");
          com.tencent.mm.plugin.expt.hellhound.a.b.b.a.MG(((bki)localObject1).czq);
          AppMethodBeat.o(152331);
          return;
        }
        ((bki)localObject1).xyO = false;
        ((bki)localObject1).startTime = paramLong;
        if ("142".equals(localObject2))
        {
          ab.i("HellSessionMonitor", "HABBYGE-MALI, launcherUIOn7Event, addPageFlow: StoryGalleryView");
          com.tencent.mm.plugin.expt.hellhound.a.b.c.b.a((bki)localObject1, "StoryGalleryView", paramLong);
          com.tencent.mm.plugin.expt.hellhound.a.b.b.a.f((bki)localObject1);
        }
        for (;;)
        {
          a((bki)localObject1);
          ab.w("HellSessionMonitor", "HABBYGE-MALI, _launcherUIOn7Event, curSession: " + ((bki)localObject1).czq + "/" + ((bki)localObject1).xyK + "/" + ((bki)localObject1).xyN + "/" + ((bki)localObject1).xyL);
          AppMethodBeat.o(152331);
          return;
          ab.i("HellSessionMonitor", "HABBYGE-MALI, launcherUIOn7Event, addPageFlow: ChattingUIFragment");
          com.tencent.mm.plugin.expt.hellhound.a.b.c.b.a((bki)localObject1, "com.tencent.mm.ui.chatting.ChattingUIFragment", paramLong);
          com.tencent.mm.plugin.expt.hellhound.a.b.b.a.f((bki)localObject1);
        }
      }
    }
    else {
      ab.w("HellSessionMonitor", "HABBYGE-MALI, _launcherUIOn7Event, no Session: ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(152331);
  }
  
  private static void O(String paramString, long paramLong)
  {
    AppMethodBeat.i(152332);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsj();
    if (localObject != null)
    {
      ((bki)localObject).xyO = true;
      ((bki)localObject).endTime = paramLong;
      ab.i("HellSessionMonitor", "HABBYGE-MALI, launcherUIOn8Event, curSession: " + ((bki)localObject).czq + " | " + paramString);
      ava localava = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsk();
      if (localava == null)
      {
        AppMethodBeat.o(152332);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.b.c.b.T(paramString, paramLong);
      localava.xkj = paramLong;
      com.tencent.mm.plugin.expt.hellhound.a.b.b.a.b(localava);
      a((bki)localObject, paramLong);
      IE();
      a((bki)localObject, paramString);
      AppMethodBeat.o(152332);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
    localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.d.Mh(paramString);
    if (localObject != null)
    {
      ab.d("HellSessionMonitor", "HABBYGE-MALI, _launcherUIOn8Event, curAR: " + ((be)localObject).wnr.activityName + "/" + ((be)localObject).wnu + "/" + ((be)localObject).wns + "/" + ((be)localObject).wnt);
      if (!TextUtils.isEmpty(((be)localObject).wns)) {
        break label243;
      }
    }
    label243:
    for (paramString = ((be)localObject).wnr.activityName;; paramString = ((be)localObject).wns)
    {
      localObject = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        localObject = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(paramString);
      }
      S((String)localObject, paramLong);
      paramString = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsk();
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(152332);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.b.c.b.T((String)localObject, paramLong);
    paramString.xkj = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.b.b.a.b(paramString);
    IE();
    com.tencent.mm.plugin.expt.hellhound.a.b.b.a.reset();
    ab.i("HellSessionMonitor", "HABBYGE-MALI, _launcherUIOn8Event, 无Session: ".concat(String.valueOf(localObject)));
    AppMethodBeat.o(152332);
  }
  
  private void P(String paramString, long paramLong)
  {
    AppMethodBeat.i(152334);
    ava localava = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsk();
    Object localObject = localava;
    if (localava == null) {
      localObject = new ava();
    }
    ((ava)localObject).xki = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.b.b.a.b((ava)localObject);
    localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsj();
    if (localObject != null)
    {
      if (((bki)localObject).xyO)
      {
        ((bki)localObject).xyO = false;
        ((bki)localObject).startTime = paramLong;
        ab.i("HellSessionMonitor", "HABBYGE-MALI, activityOn7Event, curSession: " + ((bki)localObject).xyK + " | " + paramString);
        com.tencent.mm.plugin.expt.hellhound.a.b.c.b.a((bki)localObject, paramString, paramLong);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.a.f((bki)localObject);
        a((bki)localObject);
        ab.w("HellSessionMonitor", "HABBYGE-MALI, _activityOn7Event, curSession: " + ((bki)localObject).czq + "/" + ((bki)localObject).xyK + "/" + ((bki)localObject).xyN + "/" + ((bki)localObject).xyL);
        AppMethodBeat.o(152334);
      }
    }
    else
    {
      ab.i("HellSessionMonitor", "HABBYGE-MALI, _activityOn7Event, 无Session: ".concat(String.valueOf(paramString)));
      paramString = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(paramString);
      if (!"LauncherUI".equals(paramString))
      {
        R(paramString, paramLong);
        com.tencent.mm.plugin.expt.hellhound.a.b.c.b.a(null, paramString, paramLong);
      }
    }
    AppMethodBeat.o(152334);
  }
  
  private static void Q(String paramString, long paramLong)
  {
    AppMethodBeat.i(152335);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsj();
    Object localObject2;
    if (localObject1 != null)
    {
      ((bki)localObject1).xyO = true;
      ((bki)localObject1).endTime = paramLong;
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsk();
      if (localObject2 == null)
      {
        AppMethodBeat.o(152335);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.b.c.b.T(paramString, paramLong);
      ((ava)localObject2).xkj = paramLong;
      com.tencent.mm.plugin.expt.hellhound.a.b.b.a.b((ava)localObject2);
      a((bki)localObject1, paramLong);
      IE();
      ab.i("HellSessionMonitor", "HABBYGE-MALI, _activityOn8Event: " + ((bki)localObject1).czq + ", " + ((bki)localObject1).xyK);
      a((bki)localObject1, paramString);
      AppMethodBeat.o(152335);
      return;
    }
    if (paramString == null)
    {
      AppMethodBeat.o(152335);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
    localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.d.Mh(paramString);
    if (localObject1 != null)
    {
      ab.d("HellSessionMonitor", "HABBYGE-MALI, _activityOn8Event, curAR: " + ((be)localObject1).wnr.activityName + "/" + ((be)localObject1).wnu + "/" + ((be)localObject1).wns + "/" + ((be)localObject1).wnt);
      if (TextUtils.isEmpty(((be)localObject1).wns)) {
        localObject1 = ((be)localObject1).wnr.activityName;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.Mb((String)localObject1);
      }
      S((String)localObject2, paramLong);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsk();
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(152335);
      return;
      localObject1 = ((be)localObject1).wns;
      continue;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(paramString);
    }
    com.tencent.mm.plugin.expt.hellhound.a.b.c.b.T(paramString, paramLong);
    ((ava)localObject1).xkj = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.b.b.a.b((ava)localObject1);
    IE();
    com.tencent.mm.plugin.expt.hellhound.a.b.b.a.reset();
    ab.i("HellSessionMonitor", "HABBYGE-MALI, _activityOn8Event, 无Session: ".concat(String.valueOf(localObject2)));
    AppMethodBeat.o(152335);
  }
  
  private long R(String paramString, long paramLong)
  {
    AppMethodBeat.i(152336);
    if (TextUtils.isEmpty(paramString))
    {
      ab.w("HellSessionMonitor", "HABBYGE-MALI, addUnknownPage: page is NULL");
      AppMethodBeat.o(152336);
      return -1L;
    }
    bke localbke = new bke();
    localbke.xkf = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(paramString);
    if (this.maL == 7)
    {
      ab.i("HellSessionMonitor", "habbyge-mali, addUnknownPage, 7: " + localbke.xkf);
      localbke.startTime = this.maM;
      this.maL = -1;
    }
    for (;;)
    {
      localbke.xyE = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsh();
      ab.w("HellSessionMonitor", "HABBYGE-MALI, addUnknownPage: " + localbke.xkf + ", " + localbke.startTime);
      com.tencent.mm.plugin.expt.hellhound.a.b.b.a.a(localbke);
      paramLong = localbke.startTime;
      AppMethodBeat.o(152336);
      return paramLong;
      ab.i("HellSessionMonitor", "habbyge-mali, addUnknownPage, mFrontBackEvent, 8: " + localbke.xkf);
      localbke.startTime = paramLong;
    }
  }
  
  private static void S(String paramString, long paramLong)
  {
    AppMethodBeat.i(152337);
    bke localbke = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsl();
    if (localbke == null)
    {
      AppMethodBeat.o(152337);
      return;
    }
    localbke.endTime = paramLong;
    ab.i("HellSessionMonitor", "HABBYGE-MALI, closeUnknownPage NOT NULL: " + paramString + ", " + localbke.xkf + "/" + localbke.startTime + "-" + localbke.endTime);
    com.tencent.mm.plugin.expt.hellhound.a.b.b.a.b(localbke);
    AppMethodBeat.o(152337);
  }
  
  private static bki a(Activity paramActivity, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(152351);
    if (paramString2 == null)
    {
      ab.e("HellSessionMonitor", "HABBYGE-MALI, newSession: dstPageName is NULL");
      AppMethodBeat.o(152351);
      return null;
    }
    ab.i("HellSessionMonitor", "HABBYGE-MALI, newSession: srcPageName | dstPageName: " + paramString1 + " | " + paramString2);
    azc localazc;
    Object localObject1;
    if ("WebViewUI".equals(paramString2))
    {
      localazc = new azc();
      localazc.key = "minimize_secene";
      localazc.value = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.b.Mq("minimize_secene");
      localObject2 = new azc();
      ((azc)localObject2).key = "KPublisherId";
      ((azc)localObject2).value = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.b.Mq("KPublisherId");
      localObject1 = new ArrayList();
      ((List)localObject1).add(localazc.value);
      ((List)localObject1).add(((azc)localObject2).value);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.a(paramActivity, paramString1, paramString2, (List)localObject1);
      ab.i("HellSessionMonitor", "HABBYGE-MALI, newSession(WebViewUI)sid = " + (String)localObject1 + "/" + paramLong);
      paramActivity = (Activity)localObject2;
    }
    while (TextUtils.isEmpty((CharSequence)localObject1))
    {
      AppMethodBeat.o(152351);
      return null;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.a(paramActivity, paramString1, paramString2, null);
      ab.i("HellSessionMonitor", "HABBYGE-MALI, newSession(no args)sid = " + (String)localObject1 + "/" + paramLong);
      paramActivity = null;
      localazc = null;
    }
    Object localObject2 = new bki();
    ((bki)localObject2).czq = ((String)localObject1 + "_" + paramLong);
    ((bki)localObject2).xyE = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsh();
    ((bki)localObject2).xyK = paramString2;
    ((bki)localObject2).xyN = paramString1;
    ((bki)localObject2).startTime = paramLong;
    if ("WebViewUI".equals(((bki)localObject2).xyK))
    {
      ((bki)localObject2).xyM = new bkf();
      ((bki)localObject2).xyM.xyH.add(localazc);
      ((bki)localObject2).xyM.xyH.add(paramActivity);
    }
    for (;;)
    {
      ((bki)localObject2).xyP = paramString2;
      ab.i("HellSessionMonitor", "habbyge-mali, HellSessionMonitor, newSession: " + ((bki)localObject2).czq + " | " + ((bki)localObject2).xyP);
      AppMethodBeat.o(152351);
      return localObject2;
      if ("ChattingUI".equals(((bki)localObject2).xyK))
      {
        paramActivity = a.brW();
        ((bki)localObject2).userName = ((String)paramActivity.get(0));
        ((bki)localObject2).xyL = ((Integer)paramActivity.get(1)).intValue();
      }
      else if ("ChattingUIFragment".equals(((bki)localObject2).xyK))
      {
        paramActivity = a.brX();
        ((bki)localObject2).userName = ((String)paramActivity.get(0));
        ((bki)localObject2).xyL = ((Integer)paramActivity.get(1)).intValue();
      }
    }
  }
  
  private static com.tencent.mm.vending.j.c<String, String> a(be parambe1, int paramInt, be parambe2)
  {
    AppMethodBeat.i(152352);
    if (parambe1 == null)
    {
      AppMethodBeat.o(152352);
      return null;
    }
    String str3 = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(parambe1.wnr.activityName);
    String str1;
    if (paramInt == 4)
    {
      String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(parambe1.wns);
      str1 = str2;
      if (TextUtils.isEmpty(parambe1.wnt)) {
        break label137;
      }
      str1 = str2;
      if (parambe2 == null) {
        break label137;
      }
      str1 = str2;
      if (TextUtils.isEmpty(parambe2.wnt)) {
        break label137;
      }
      parambe1 = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(parambe2.wnt);
      str1 = str2;
    }
    for (;;)
    {
      if (parambe1 == null) {
        parambe1 = str3;
      }
      for (;;)
      {
        parambe1 = com.tencent.mm.vending.j.a.C(str1, parambe1);
        AppMethodBeat.o(152352);
        return parambe1;
        if (paramInt != 5) {
          break label145;
        }
        str1 = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(parambe1.wnt);
        ab.i("HellSessionMonitor", "HABBYGE-MALI, _getCurLastFragment, EVENT_FRAGMENT_OUT: ".concat(String.valueOf(str1)));
        label137:
        parambe1 = null;
        break;
      }
      label145:
      parambe1 = null;
      str1 = null;
    }
  }
  
  private static String a(be parambe)
  {
    AppMethodBeat.i(156196);
    be localbe = null;
    Object localObject = localbe;
    if (parambe != null)
    {
      if (TextUtils.isEmpty(parambe.wns)) {
        break label62;
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(parambe.wns);
    }
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      ab.i("HellSessionMonitor", "HABBYGE-MALI, getLastPageName, lastOrNextAR, lastPageName: ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(156196);
      return localObject;
      label62:
      localObject = localbe;
      if (!TextUtils.isEmpty(parambe.wnt)) {
        localObject = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(parambe.wns);
      }
    }
    parambe = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.c.brO().mah.brM();
    ab.i("HellSessionMonitor", "HABBYGE-MALI, getLastPageName, lastPageName-1: ".concat(String.valueOf(parambe)));
    if ("com.tencent.mm.ui.LauncherUI".equals(parambe))
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
      localbe = com.tencent.mm.plugin.expt.hellhound.core.stack.e.brH();
      if (localbe != null)
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(localbe.wns);
        ab.i("HellSessionMonitor", "HABBYGE-MALI, getLastPageName, lastPageName-2: ".concat(String.valueOf(localObject)));
        parambe = (be)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          parambe = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(localbe.wnt);
          ab.i("HellSessionMonitor", "HABBYGE-MALI, activityIn, lastPageName-3: ".concat(String.valueOf(parambe)));
        }
      }
    }
    for (;;)
    {
      ab.i("HellSessionMonitor", "HABBYGE-MALI, getLastPageName, lastPageName: ".concat(String.valueOf(parambe)));
      if (!TextUtils.isEmpty(parambe)) {
        break;
      }
      AppMethodBeat.o(156196);
      return "MainUI";
      parambe = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(parambe);
    }
    AppMethodBeat.o(156196);
    return parambe;
  }
  
  private void a(int paramInt, be parambe, long paramLong)
  {
    AppMethodBeat.i(152348);
    ab.i("HellSessionMonitor", "HABBYGE-MALI, monitorChatUIFragment: ".concat(String.valueOf(paramInt)));
    if (paramInt == 6)
    {
      a(parambe, paramLong);
      AppMethodBeat.o(152348);
      return;
    }
    if (paramInt == 7) {
      jC(paramLong);
    }
    AppMethodBeat.o(152348);
  }
  
  private static void a(Activity paramActivity, be parambe1, be parambe2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(156193);
    if (parambe1 == null)
    {
      AppMethodBeat.o(156193);
      return;
    }
    if ("ChattingUI".equals(com.tencent.mm.plugin.expt.hellhound.core.b.Mb(parambe1.wnr.activityName)))
    {
      J(paramInt, paramLong);
      AppMethodBeat.o(156193);
      return;
    }
    b(paramActivity, parambe1, parambe2, paramInt, paramLong);
    AppMethodBeat.o(156193);
  }
  
  private static void a(Activity paramActivity, be parambe1, be parambe2, long paramLong)
  {
    AppMethodBeat.i(156195);
    if (parambe1 == null)
    {
      AppMethodBeat.o(156195);
      return;
    }
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(parambe1.wnr.activityName);
    ab.i("HellSessionMonitor", "HABBYGE-MALI, activityIn, curActivityName: ".concat(String.valueOf(str)));
    int i = 0;
    parambe1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsj();
    if (parambe1 == null)
    {
      parambe1 = a(parambe2);
      ab.w("HellSessionMonitor", "HABBYGE-MALI, _activityIn, newSession: " + str + "/" + parambe1);
      paramActivity = a(paramActivity, parambe1, str, paramLong);
      if (paramActivity == null)
      {
        ab.e("HellSessionMonitor", "HABBYGE-MALI, _activityIn, 不是合法session ~~~");
        AppMethodBeat.o(156195);
        return;
      }
      i = 1;
    }
    for (;;)
    {
      if ((str != null) && (!str.equals("LauncherUI"))) {
        com.tencent.mm.plugin.expt.hellhound.a.b.c.b.a(paramActivity, str, paramLong);
      }
      if (i == 0) {
        break;
      }
      ab.i("HellSessionMonitor", "HABBYGE-MALI, activityIn, isNewSession: " + paramActivity.czq);
      com.tencent.mm.plugin.expt.hellhound.a.b.b.a.e(paramActivity);
      a(paramActivity);
      AppMethodBeat.o(156195);
      return;
      ab.d("HellSessionMonitor", "HABBYGE-MALI, _activityIn, curSession: " + parambe1.czq + "/" + str);
      paramActivity = parambe1;
    }
    ab.i("HellSessionMonitor", "HABBYGE-MALI, activityIn, setPageFlow: " + paramActivity.czq);
    AppMethodBeat.o(156195);
  }
  
  private static void a(be parambe, int paramInt, long paramLong)
  {
    int m = 1;
    AppMethodBeat.i(152342);
    if (parambe == null)
    {
      ab.e("HellSessionMonitor", "HABBYGE-MALI, HelLSessionMonitor, activityOut: NULL");
      AppMethodBeat.o(152342);
      return;
    }
    bki localbki = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsj();
    if (localbki == null)
    {
      ab.e("HellSessionMonitor", "HABBYGE-MALI, _activityOut, 不是合法session !!!");
      AppMethodBeat.o(152342);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(parambe.wnr.activityName);
    if (localObject1 == null)
    {
      AppMethodBeat.o(152342);
      return;
    }
    String str = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.Mv(localbki.czq);
    ab.i("HellSessionMonitor", "habbyge-mali, activityOut, curSesssion: " + str + " | " + (String)localObject1);
    Object localObject2;
    if ("105".equals(str))
    {
      if (com.tencent.mm.plugin.expt.hellhound.core.b.Me(localbki.xyP))
      {
        if (com.tencent.mm.plugin.expt.hellhound.core.b.Me((String)localObject1))
        {
          a(localbki, paramLong);
          AppMethodBeat.o(152342);
          return;
        }
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
        parambe = com.tencent.mm.plugin.expt.hellhound.core.stack.e.brH();
        if (parambe != null) {
          com.tencent.mm.plugin.expt.hellhound.a.b.c.b.a(localbki, parambe.wnr.activityName, paramLong);
        }
        AppMethodBeat.o(152342);
        return;
      }
      if ("AppBrandLaunchProxyUI".equals(localObject1))
      {
        ab.e("HellSessionMonitor", "HABBYGE-MALI, _activityOut, AppBrandLaunchProxyUI out ~~");
        AppMethodBeat.o(152342);
        return;
      }
      ab.w("HellSessionMonitor", "HABBYGE-MALI, _activityOut, AppBrand cur/start: " + (String)localObject1 + " | " + localbki.xyP);
      if ((com.tencent.mm.plugin.expt.hellhound.core.b.Md((String)localObject1)) && (((String)localObject1).equals(localbki.xyP)))
      {
        a(localbki, paramLong);
        AppMethodBeat.o(152342);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
      localObject2 = com.tencent.mm.plugin.expt.hellhound.core.stack.e.brH();
      if ((com.tencent.mm.plugin.expt.hellhound.core.b.Md((String)localObject1)) && (localObject2 != null) && ("com.tencent.mm.ui.LauncherUI".equals(((be)localObject2).wnr.activityName)))
      {
        a(localbki, paramLong);
        AppMethodBeat.o(152342);
        return;
      }
      if ((localObject2 != null) && (!"com.tencent.mm.ui.LauncherUI".equals(((be)localObject2).wnr.activityName))) {
        com.tencent.mm.plugin.expt.hellhound.a.b.c.b.a(localbki, ((be)localObject2).wnr.activityName, paramLong);
      }
    }
    if ("132".equals(str))
    {
      if ("GameCenterUI".equals(localObject1))
      {
        ab.e("HellSessionMonitor", "HABBYGE-MALI, _activityOut, GameCenterUI out ~~");
        AppMethodBeat.o(152342);
        return;
      }
      if (("GameWebViewUI".equals(localObject1)) || ("LuggageGameWebViewUI".equals(localObject1)))
      {
        ab.w("HellSessionMonitor", "HABBYGE-MALI, _activityOut, GameWebViewUI: ".concat(String.valueOf(localObject1)));
        a(localbki, paramLong);
        AppMethodBeat.o(152342);
        return;
      }
    }
    if ("142".equals(str))
    {
      ab.i("HellSessionMonitor", "HABBYGE-MALI, _activityOut, StoryGallery Session(142)");
      if ("StoryCaptureUI".equals(localObject1))
      {
        ab.w("HellSessionMonitor", "HABBYGE-MALI, _activityOut, GameWebViewUI: ".concat(String.valueOf(localObject1)));
        a(localbki, paramLong);
        AppMethodBeat.o(152342);
        return;
      }
    }
    if ("110".equals(str))
    {
      if (!"WalletOfflineCoinPurseUI".equals(localObject1))
      {
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
        parambe = com.tencent.mm.plugin.expt.hellhound.core.stack.e.brH();
        if (parambe != null) {
          com.tencent.mm.plugin.expt.hellhound.a.b.c.b.a(localbki, parambe.wnr.activityName, paramLong);
        }
        AppMethodBeat.o(152342);
        return;
      }
      if (paramInt != 2) {
        a(localbki, paramLong);
      }
      AppMethodBeat.o(152342);
      return;
    }
    if ((parambe.wnu != null) && (!parambe.wnu.isEmpty()))
    {
      parambe = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(parambe.wnu);
      ab.i("HellSessionMonitor", "habbyge-mali, _activityOut, nextActivity: " + parambe + " | " + paramInt);
      if ((paramInt != 2) && (!"LauncherUI".equals(parambe)))
      {
        localObject2 = f.brS();
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (com.tencent.mm.plugin.expt.hellhound.a.b.a.b.Mz((String)localObject2)))
        {
          ab.d("HellSessionMonitor", "habbyge-mali, _activityOut, BIZ, quit !!");
          AppMethodBeat.o(152342);
          return;
        }
        com.tencent.mm.plugin.expt.hellhound.a.b.c.b.a(localbki, parambe, paramLong);
      }
    }
    if (!((String)localObject1).equals(localbki.xyK))
    {
      ab.w("HellSessionMonitor", "HABBYGE-MALI, _activityOut, 当前Activity: %s不是当前session: %s的起始页 %s", new Object[] { localObject1, localbki.czq, localbki.xyK });
      AppMethodBeat.o(152342);
      return;
    }
    paramInt = m;
    int i;
    if ("WebViewUI".equals(localObject1))
    {
      parambe = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.b.Mq("minimize_secene");
      localObject1 = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.b.Mq("KPublisherId");
      ab.i("HellSessionMonitor", "HABBYGE-MALI, _activityOut, WebViewUI: " + parambe + ", " + (String)localObject1);
      parambe = localbki.xyM.xyH.iterator();
      paramInt = 0;
      i = 0;
    }
    for (;;)
    {
      int j = paramInt;
      int k = i;
      if (parambe.hasNext())
      {
        localObject1 = (azc)parambe.next();
        if (localObject1 == null) {
          continue;
        }
        if (("minimize_secene".equals(((azc)localObject1).key)) && ("1".equals(((azc)localObject1).value)))
        {
          if (paramInt == 0) {
            break label1031;
          }
          k = 1;
          j = paramInt;
        }
      }
      else
      {
        label914:
        if ((k == 0) || (j == 0)) {
          break label1013;
        }
        paramInt = m;
        label927:
        if (paramInt == 0) {
          break label1006;
        }
        ab.i("HellSessionMonitor", "habbyge-mali, HellSessionMonitor, isStartPageOfSession true");
        if (!com.tencent.mm.plugin.expt.hellhound.a.b.f.a.MT(str)) {
          break label1000;
        }
        ab.w("HellSessionMonitor", "habbyge-mali, HellSessionMonitor, activityOut: Scan-Session NOT CLOSE SESSION");
        AppMethodBeat.o(152342);
        return;
      }
      if (("KPublisherId".equals(((azc)localObject1).key)) && ("jd_store".equals(((azc)localObject1).value))) {
        if (i == 0) {
          paramInt = 1;
        }
      }
      for (;;)
      {
        break;
        label1000:
        a(localbki, paramLong);
        label1006:
        AppMethodBeat.o(152342);
        return;
        label1013:
        paramInt = 0;
        break label927;
        j = 1;
        k = i;
        break label914;
      }
      label1031:
      i = 1;
    }
  }
  
  private void a(be parambe1, int paramInt, be parambe2, long paramLong)
  {
    AppMethodBeat.i(152347);
    Object localObject = a(parambe1, paramInt, parambe2);
    if (localObject == null)
    {
      AppMethodBeat.o(152347);
      return;
    }
    String str = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
    localObject = (String)((com.tencent.mm.vending.j.c)localObject).get(1);
    ab.i("HellSessionMonitor", "HABBYGE-MALI, monitorFragment: " + str + ", " + (String)localObject + ", " + paramInt);
    if (paramInt == 4) {
      if ("ChattingUIFragment".equals(str))
      {
        ab.w("HellSessionMonitor", "HABBYGE-MALI, monitorFragment, EVENT_CHATTINGUIFRAGMENT_IN");
        a(6, parambe2, paramLong);
      }
    }
    for (;;)
    {
      if (this.maK != -1) {
        this.maK = -1;
      }
      AppMethodBeat.o(152347);
      return;
      paramLong = R(parambe1.wns, paramLong);
      com.tencent.mm.plugin.expt.hellhound.a.b.c.b.a(null, parambe1.wns, paramLong);
      continue;
      if (paramInt == 5)
      {
        if ("ChattingUIFragment".equals(str))
        {
          ab.i("HellSessionMonitor", "HABBYGE-MALI, monitorFragment, CHATTING_UI_FRAGMENT, no need handle");
          AppMethodBeat.o(152347);
          return;
        }
        S(str, paramLong);
      }
    }
  }
  
  private void a(be parambe, long paramLong)
  {
    AppMethodBeat.i(152349);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsj();
    if (localObject == null) {
      if (parambe != null)
      {
        parambe = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(parambe.wnt);
        localObject = a(null, parambe, "ChattingUIFragment", paramLong);
        if (localObject == null)
        {
          ab.e("HellSessionMonitor", "HABBYGE-MALI, chatUIFragmentSessionStart, curSession == null");
          AppMethodBeat.o(152349);
          return;
        }
        ab.i("HellSessionMonitor", "HABBYGE-MALI, chatUIFragmentSessionStart, lastPage: ".concat(String.valueOf(parambe)));
        parambe = (be)localObject;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ab.i("HellSessionMonitor", "HABBYGE-MALI, chatUIFragmentSessionStart new Session: ".concat(String.valueOf(paramLong)));
        com.tencent.mm.plugin.expt.hellhound.a.b.c.b.a(parambe, "com.tencent.mm.ui.chatting.ChattingUIFragment", paramLong);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.a.e(parambe);
        a(parambe);
        AppMethodBeat.o(152349);
        return;
      }
      localObject = a.brX();
      String str = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
      i = ((Integer)((com.tencent.mm.vending.j.c)localObject).get(1)).intValue();
      ab.i("HellSessionMonitor", "HABBYGE-MALI, chatUIFragmentSessionStart: " + str + ", " + i);
      if (i == parambe.xyL)
      {
        ab.w("HellSessionMonitor", "HABBYGE-MALI, chatUIFragmentSessionStart, curChatType == chatType");
        if (this.maK != 7)
        {
          ab.i("HellSessionMonitor", "HABBYGE-MALI, chatUIFragmentSessionStart, 7-Event-NOT");
          com.tencent.mm.plugin.expt.hellhound.a.b.c.b.a(parambe, "com.tencent.mm.ui.chatting.ChattingUIFragment", paramLong);
          AppMethodBeat.o(152349);
          return;
        }
        ab.i("HellSessionMonitor", "HABBYGE-MALI, chatUIFragmentSessionStart, 7-Event");
        AppMethodBeat.o(152349);
        return;
      }
      ab.d("HellSessionMonitor", "HABBYGE-MALI, chatUIFragmentSessio`nStart, curChatType!=chatType: " + i + "/" + parambe.xyL);
      a(parambe, paramLong);
      parambe = a(null, "MainUI", "ChattingUIFragment", paramLong);
      if (parambe != null)
      {
        com.tencent.mm.plugin.expt.hellhound.a.b.c.b.a(parambe, "com.tencent.mm.ui.chatting.ChattingUIFragment", paramLong);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.a.e(parambe);
        a(parambe);
      }
      AppMethodBeat.o(152349);
      return;
      parambe = null;
      break;
      parambe = (be)localObject;
    }
  }
  
  private static void a(bki parambki)
  {
    AppMethodBeat.i(152353);
    if (parambki == null)
    {
      AppMethodBeat.o(152353);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.b(parambki);
    ab.i("HellSessionMonitor", "HABBYGE-MALI, onSessionStart: " + parambki.czq + "/" + parambki.startTime);
    AppMethodBeat.o(152353);
  }
  
  private static void a(bki parambki, long paramLong)
  {
    AppMethodBeat.i(152354);
    if (parambki == null)
    {
      AppMethodBeat.o(152354);
      return;
    }
    parambki.endTime = paramLong;
    ab.i("HellSessionMonitor", "HABBYGE-MALI, onSessionClose: " + parambki.czq + "/" + parambki.startTime + "-" + parambki.endTime);
    com.tencent.mm.plugin.expt.hellhound.a.b.b.a.g(parambki);
    com.tencent.mm.plugin.expt.hellhound.a.b.a.b.b(parambki);
    ab.i("HellSessionMonitor", "HABBYGE-MALI, toCloseCurSession: " + parambki.czq + "/" + parambki.xyK);
    AppMethodBeat.o(152354);
  }
  
  private static void a(bki parambki, String paramString)
  {
    AppMethodBeat.i(156192);
    if (parambki == null)
    {
      AppMethodBeat.o(156192);
      return;
    }
    if (parambki.czq.startsWith("142"))
    {
      if ((paramString == null) || ("com.tencent.mm.ui.LauncherUI".equals(paramString))) {}
      for (int i = 1; i != 0; i = 0)
      {
        boolean bool = com.tencent.mm.plugin.expt.hellhound.core.v2.a.e.d(com.tencent.mm.plugin.expt.hellhound.core.b.bru(), "com.tencent.mm.ui.MoreTabUI");
        ab.i("HellSessionMonitor", "HABBYGE-MALI, retainCurSession, 142: isActive: ".concat(String.valueOf(bool)));
        if (bool) {
          break label99;
        }
        AppMethodBeat.o(156192);
        return;
      }
      ab.i("HellSessionMonitor", "HABBYGE-MALI, retainCurSession, 142: isStoryGalleryViewShow: FALSE");
    }
    label99:
    paramString = new ava();
    bki localbki = new bki();
    localbki.czq = parambki.czq;
    localbki.xyO = true;
    localbki.xyK = parambki.xyK;
    localbki.xyL = parambki.xyL;
    localbki.userName = parambki.userName;
    localbki.xyM = parambki.xyM;
    localbki.xyN = parambki.xyN;
    localbki.xyE = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsh();
    paramString.xkk.addLast(localbki);
    paramString.xkl = (paramString.xkk.size() - 1);
    ab.i("HellSessionMonitor", "HABBYGE-MALI, retainCurSession.session: " + localbki.czq + "/" + localbki.xyK);
    com.tencent.mm.plugin.expt.hellhound.a.b.b.a.b(paramString);
    AppMethodBeat.o(156192);
  }
  
  private static void b(Activity paramActivity, be parambe1, be parambe2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(156194);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(156194);
      return;
      a(paramActivity, parambe1, parambe2, paramLong);
      AppMethodBeat.o(156194);
      return;
      a(parambe1, paramInt, paramLong);
    }
  }
  
  public static b brY()
  {
    AppMethodBeat.i(73460);
    if (maJ == null) {}
    try
    {
      if (maJ == null) {
        maJ = new b();
      }
      b localb = maJ;
      AppMethodBeat.o(73460);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(73460);
    }
  }
  
  public static boolean brZ()
  {
    AppMethodBeat.i(152323);
    com.tencent.mm.plugin.expt.hellhound.a.b.a.c.bsb();
    if ((com.tencent.mm.plugin.expt.hellhound.a.b.a.c.bsd()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      ab.e("HellSessionMonitor", "HABBYGE-MALI, HellSessionMonitor monitor FALSE");
      AppMethodBeat.o(152323);
      return true;
    }
    if (!com.tencent.mm.plugin.expt.hellhound.a.brp())
    {
      ab.w("HellSessionMonitor", "HABBYGE-MALI, HellSessionMonitor monitor, close !!!");
      AppMethodBeat.o(152323);
      return true;
    }
    AppMethodBeat.o(152323);
    return false;
  }
  
  public static void d(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(152327);
    if (brZ())
    {
      ab.i("HellSessionMonitor", "habbyge-mali, HellSessionMonitor, catchParams: FALSE");
      AppMethodBeat.o(152327);
      return;
    }
    if (paramActivity != null) {}
    switch (paramInt)
    {
    default: 
      if (paramActivity != null) {
        switch (paramInt)
        {
        }
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(152327);
      return;
      com.tencent.mm.plugin.expt.hellhound.a.b.d.a.bI(paramActivity);
      break;
      com.tencent.mm.plugin.expt.hellhound.a.b.d.a.bJ(paramActivity);
      break;
      com.tencent.mm.plugin.expt.hellhound.a.b.d.c.bI(paramActivity);
      AppMethodBeat.o(152327);
      return;
      com.tencent.mm.plugin.expt.hellhound.a.b.d.c.bJ(paramActivity);
    }
  }
  
  private void d(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(152330);
    ab.i("HellSessionMonitor", "HABBYGE-MALI, _launcherUIOnFrontBack, pageName: ".concat(String.valueOf(paramString)));
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(152330);
      return;
      this.maK = 7;
      N(paramString, paramLong);
      AppMethodBeat.o(152330);
      return;
      this.maK = 8;
      O(paramString, paramLong);
    }
  }
  
  private void e(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(152333);
    ab.i("HellSessionMonitor", "HABBYGE-MALI, activityOnFrontBack: " + paramString + " | " + paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(152333);
      return;
      ab.i("HellSessionMonitor", "HABBYGE-MALI, activityOnFrontBack, 7Event: ".concat(String.valueOf(paramString)));
      P(paramString, paramLong);
      AppMethodBeat.o(152333);
      return;
      ab.i("HellSessionMonitor", "HABBYGE-MALI, activityOnFrontBack, 8Event: ".concat(String.valueOf(paramString)));
      Q(paramString, paramLong);
    }
  }
  
  public static void g(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(152320);
    if (brZ())
    {
      ab.i("HellSessionMonitor", "habbyge-mali, HellSessionMonitor, notify enter biz, needSessionMonitor: FALSE");
      AppMethodBeat.o(152320);
      return;
    }
    if ("Biz".equals(paramString1))
    {
      ab.i("HellBizSessionHandler", "habbyge-mali, whenChattingUIFragmentEnter: " + paramString2 + " -> com.tencent.mm.ui.chatting.ChattingUIFragment");
      if (!paramString2.contains("BizTimeLineUI")) {
        paramString2.contains("BizConversationUI");
      }
      com.tencent.mm.plugin.expt.hellhound.a.b.c.b.U("com.tencent.mm.ui.chatting.ChattingUIFragment", paramLong);
    }
    AppMethodBeat.o(152320);
  }
  
  public static void h(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(152321);
    if (brZ())
    {
      ab.i("HellSessionMonitor", "habbyge-mali, HellSessionMonitor, notify exit biz, needSessionMonitor: FALSE");
      AppMethodBeat.o(152321);
      return;
    }
    if ("Biz".equals(paramString1))
    {
      ab.i("HellBizSessionHandler", "habbyge-mali, whenChattingUIFragmentExit: ".concat(String.valueOf(paramString2)));
      if (paramString2.contains("BizTimeLineUI"))
      {
        com.tencent.mm.plugin.expt.hellhound.a.b.c.b.U(paramString2, paramLong);
        AppMethodBeat.o(152321);
        return;
      }
      if (paramString2.contains("BizConversationUI")) {
        com.tencent.mm.plugin.expt.hellhound.a.b.c.b.U(paramString2, paramLong);
      }
    }
    AppMethodBeat.o(152321);
  }
  
  private static void jA(long paramLong)
  {
    AppMethodBeat.i(152344);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsj();
    if (localObject1 == null)
    {
      localObject1 = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.e.vn(100);
      localObject2 = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.e.vn(101);
      String str1 = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.e.vn(102);
      String str2 = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.e.vn(104);
      if (("com.tencent.mm.ui.contact.SelectContactUI".equals(localObject1)) && ("com.tencent.mm.ui.chatting.ChattingUI".equals(localObject2)) && ("com.tencent.mm.ui.contact.SelectContactUI".equals(str1)) && ("com.tencent.mm.ui.chatting.ChattingUI".equals(str2)))
      {
        jB(paramLong);
        AppMethodBeat.o(152344);
        return;
      }
      ab.e("HellSessionMonitor", "HABBYGE-MALI, chattingUIIn, 不是合法session !!!");
      AppMethodBeat.o(152344);
      return;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.Mv(((bki)localObject1).czq);
    ab.d("HellSessionMonitor", "HABBYGE-MALI, chattingUIIn, curSessionId: ".concat(String.valueOf(localObject2)));
    if (!com.tencent.mm.plugin.expt.hellhound.a.b.a.b.My((String)localObject2))
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.c.b.a((bki)localObject1, "com.tencent.mm.ui.chatting.ChattingUI", paramLong);
      AppMethodBeat.o(152344);
      return;
    }
    localObject2 = a.brW();
    ab.d("HellSessionMonitor", "HABBYGE-MALI, chattingUIIn, userName: ".concat(String.valueOf((String)((com.tencent.mm.vending.j.b)localObject2).get(0))));
    int i = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
    ab.w("HellSessionMonitor", "HABBYGE-MALI, chattingUIIn, newChattingType: ".concat(String.valueOf(i)));
    if (i == ((bki)localObject1).xyL)
    {
      ab.w("HellSessionMonitor", "HABBYGE-MALI, chattingUIIn, newChattingType same !!!");
      com.tencent.mm.plugin.expt.hellhound.a.b.c.b.a((bki)localObject1, "com.tencent.mm.ui.chatting.ChattingUI", paramLong);
      AppMethodBeat.o(152344);
      return;
    }
    ab.i("HellSessionMonitor", "HABBYGE-MALI, chattingUIIn, newChattingType difference !!!");
    a((bki)localObject1, paramLong);
    jB(paramLong);
    AppMethodBeat.o(152344);
  }
  
  private static void jB(long paramLong)
  {
    AppMethodBeat.i(152346);
    ab.i("HellSessionMonitor", "HABBYGE-MALI, newChattingUISession");
    bki localbki = a(null, "MainUI", "ChattingUI", paramLong);
    if (localbki == null)
    {
      ab.e("HellSessionMonitor", "HABBYGE-MALI, _doChattingUIInContinue, 不是合法session ~~~");
      AppMethodBeat.o(152346);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.b.c.b.a(localbki, "com.tencent.mm.ui.chatting.ChattingUI", paramLong);
    com.tencent.mm.plugin.expt.hellhound.a.b.b.a.e(localbki);
    a(localbki);
    AppMethodBeat.o(152346);
  }
  
  private static void jC(long paramLong)
  {
    AppMethodBeat.i(152350);
    bki localbki = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsj();
    if (localbki == null)
    {
      ab.e("HellSessionMonitor", "HABBYGE-MALI, chatUIFragmentSessionClose, curSession不合法");
      AppMethodBeat.o(152350);
      return;
    }
    com.tencent.mm.vending.j.c localc = a.brX();
    String str = (String)localc.get(0);
    int i = ((Integer)localc.get(1)).intValue();
    ab.i("HellSessionMonitor", "HABBYGE-MALI, chatUIFragmentSessionClose: " + str + ", " + i);
    if (i == localbki.xyL)
    {
      ab.w("HellSessionMonitor", "HABBYGE-MALI, chatUIFragmentSessionClose, ==");
      a(localbki, paramLong);
      AppMethodBeat.o(152350);
      return;
    }
    ab.e("HellSessionMonitor", "HABBYGE-MALI, chatUIFragmentSessionClose, != " + localbki.xyL);
    AppMethodBeat.o(152350);
  }
  
  private static void jy(long paramLong)
  {
    AppMethodBeat.i(152328);
    ab.i("HellSessionMonitor", "HABBYGE-MALI, openStoryGalleryView");
    int i = 0;
    bki localbki = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsj();
    if (localbki == null)
    {
      localbki = a(null, "MoreTabUI", "StoryGalleryView", paramLong);
      if (localbki == null)
      {
        ab.e("HellSessionMonitor", "HABBYGE-MALI, openStoryGalleryView, 不是合法session ~~~");
        AppMethodBeat.o(152328);
        return;
      }
      i = 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.c.b.a(localbki, "StoryGalleryView", paramLong);
      if (i == 0) {
        break;
      }
      com.tencent.mm.plugin.expt.hellhound.a.b.b.a.e(localbki);
      a(localbki);
      AppMethodBeat.o(152328);
      return;
      ab.d("HellSessionMonitor", "HABBYGE-MALI, openStoryGalleryView, curSession: " + localbki.czq);
    }
    com.tencent.mm.plugin.expt.hellhound.a.b.b.a.f(localbki);
    AppMethodBeat.o(152328);
  }
  
  private static void jz(long paramLong)
  {
    AppMethodBeat.i(152329);
    bki localbki = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsj();
    if (localbki == null)
    {
      ab.e("HellSessionMonitor", "HABBYGE-MALI, closeStoryGalleryView, 不是合法session !!!");
      AppMethodBeat.o(152329);
      return;
    }
    ab.i("HellSessionMonitor", "HABBYGE-MALI, closeStoryGalleryView, curSession = " + localbki.czq);
    if ("142".equals(com.tencent.mm.plugin.expt.hellhound.a.b.a.b.Mv(localbki.czq)))
    {
      a(localbki, paramLong);
      AppMethodBeat.o(152329);
      return;
    }
    if (!"StoryGalleryView".equals(localbki.xyK))
    {
      ab.w("HellSessionMonitor", "HABBYGE-MALI, closeStoryGalleryView, 当前Activity: %s 不是当前session: %s 的起始页 %s", new Object[] { "StoryGalleryView", localbki.czq, localbki.xyK });
      com.tencent.mm.plugin.expt.hellhound.a.b.b.a.f(localbki);
    }
    AppMethodBeat.o(152329);
  }
  
  public final void a(Activity paramActivity, be parambe1, int paramInt, be parambe2)
  {
    AppMethodBeat.i(152324);
    if (brZ())
    {
      ab.i("HellSessionMonitor", "habbyge-mali, HellSessionMonitor, monitor, needSessionMonitor: FALSE");
      AppMethodBeat.o(152324);
      return;
    }
    if (parambe1 == null)
    {
      AppMethodBeat.o(152324);
      return;
    }
    long l = System.currentTimeMillis();
    ab.i("HellSessionMonitor", "HABBYGE-MALI, HellSessionMonitor monitor = " + paramInt + ", " + l);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.maL = -1;
      AppMethodBeat.o(152324);
      return;
      a(paramActivity, parambe1, parambe2, paramInt, l);
      ab.i("HellSessionMonitor", "HABBYGE-MALI, monitor, activity: " + parambe1.wnr.activityName + ", " + paramInt);
      continue;
      a(parambe1, paramInt, parambe2, l);
      ab.i("HellSessionMonitor", "HABBYGE-MALI, monitor, fragment: " + parambe1.wns + ", " + paramInt);
      continue;
      a(paramInt, parambe2, l);
      ab.i("HellSessionMonitor", "HABBYGE-MALI, monitor, session end: ChattingUIFragment");
    }
  }
  
  public final void cg(String paramString, int paramInt)
  {
    AppMethodBeat.i(152322);
    this.maL = paramInt;
    this.maM = System.currentTimeMillis();
    ab.i("HellSessionMonitor", "HABBYGE-MALI, frontbackEvent: " + paramString + ", " + paramInt + ", " + this.maM);
    if (brZ())
    {
      ab.i("HellSessionMonitor", "habbyge-mali, HellSessionMonitor, frontbackEvent, needSessionMonitor: FALSE");
      AppMethodBeat.o(152322);
      return;
    }
    if ("com.tencent.mm.ui.LauncherUI".equals(paramString))
    {
      d(paramString, paramInt, this.maM);
      AppMethodBeat.o(152322);
      return;
    }
    e(paramString, paramInt, this.maM);
    AppMethodBeat.o(152322);
  }
  
  public final void ei(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152325);
    if (brZ())
    {
      ab.i("HellSessionMonitor", "habbyge-mali, HellSessionMonitor, monitorStoryGalleryViewSession: FALSE");
      AppMethodBeat.o(152325);
      return;
    }
    switch (paramInt1)
    {
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(152325);
        return;
        switch (paramInt2)
        {
        case 1: 
        default: 
          AppMethodBeat.o(152325);
          return;
        case 2: 
          ab.i("HellSessionMonitor", "HABBYGE-MALI, monitorStoryGallery: IN, FROM_RESUME, Event-7, !!");
          AppMethodBeat.o(152325);
          return;
        }
        ab.d("HellSessionMonitor", "HABBYGE-MALI, monitorStoryGallery: IN, FROM_StoryGallery_SHOW");
        long l = System.currentTimeMillis();
        S("com.tencent.mm.ui.MoreTabUI", l);
        ab.w("HellSessionMonitor", "habbyge-mali, 关闭(闭环)MoreTabUI无效页之后，再开启动态视频session");
        jy(l);
        AppMethodBeat.o(152325);
        return;
        switch (paramInt2)
        {
        case 2: 
        default: 
          break;
        case 1: 
          ab.i("HellSessionMonitor", "HABBYGE-MALI, monitorStoryGallery: OUT, FROM_StoryGallery_GONE");
          l = System.currentTimeMillis();
          jz(l);
          ab.w("HellSessionMonitor", "habbyge-mali, 关闭动态视频session之后, MoreTabUI无效页开始");
          com.tencent.mm.plugin.expt.hellhound.a.b.c.b.a(null, "MoreTabUI", R("com.tencent.mm.ui.MoreTabUI", l));
        }
      }
      ab.i("HellSessionMonitor", "HABBYGE-MALI, monitorStoryGallery: OUT, FROM_PAUSE Event-8, !!");
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.brH();
      if (localObject == null)
      {
        AppMethodBeat.o(152325);
        return;
      }
      if (((be)localObject).wnr == null)
      {
        AppMethodBeat.o(152325);
        return;
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(((be)localObject).wnr.activityName);
      ab.w("HellSessionMonitor", "HABBYGE-MALI, monitorStoryGalleryViewSession, topActivity: ".concat(String.valueOf(localObject)));
    } while (!"StoryCaptureUI".equals(localObject));
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsj();
    if (localObject == null)
    {
      AppMethodBeat.o(152325);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.b.b.a.f((bki)localObject);
    AppMethodBeat.o(152325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b
 * JD-Core Version:    0.7.0.1
 */