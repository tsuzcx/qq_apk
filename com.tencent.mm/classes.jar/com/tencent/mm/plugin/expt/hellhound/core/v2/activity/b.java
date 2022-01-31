package com.tencent.mm.plugin.expt.hellhound.core.v2.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.expt.hellhound.core.stack.f;
import com.tencent.mm.plugin.expt.hellhound.core.stack.g;
import com.tencent.mm.plugin.expt.hellhound.core.stack.h;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.protocal.protobuf.cjr;
import com.tencent.mm.protocal.protobuf.ckn;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class b
  implements com.tencent.mm.plugin.expt.hellhound.core.c, c, d
{
  private b.a maa;
  private ActivityHijack mab;
  private HellInstrumentationHijack mad;
  
  public b()
  {
    AppMethodBeat.i(73396);
    this.mab = new ActivityHijack(this);
    this.mad = new HellInstrumentationHijack(this);
    AppMethodBeat.o(73396);
  }
  
  private static com.tencent.mm.vending.j.c<String, String> P(Activity paramActivity)
  {
    AppMethodBeat.i(73411);
    if (paramActivity == null) {
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
        paramActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.d.brD();
        ab.d("ActivityMonitor", "habbyge-mali, getActivityOnFinish: " + (String)paramActivity.get(0) + " / " + (String)paramActivity.get(1));
        AppMethodBeat.o(73411);
        return paramActivity;
      }
      catch (Exception paramActivity)
      {
        ab.printErrStackTrace("ActivityMonitor", paramActivity, "habbyge-mali, getActivityOnFinish", new Object[0]);
        AppMethodBeat.o(73411);
        return null;
      }
    }
    paramActivity = com.tencent.mm.vending.j.a.C(paramActivity.getClass().getCanonicalName(), String.valueOf(paramActivity.hashCode()));
    AppMethodBeat.o(73411);
    return paramActivity;
  }
  
  private static void a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(152276);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC().a(paramActivity, paramIntent, paramString1, paramString2, paramString3);
    AppMethodBeat.o(152276);
  }
  
  private static void a(String paramString1, String paramString2, com.tencent.mm.plugin.expt.hellhound.core.stack.a parama)
  {
    AppMethodBeat.i(73410);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.a(paramString1, paramString2, parama);
    AppMethodBeat.o(73410);
  }
  
  private static void aI(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(73400);
    a.vm(1);
    if ((!paramBoolean) && ("com.tencent.mm.ui.LauncherUI".equals(paramString)))
    {
      ab.i("ActivityMonitor", "habbyge-mali, _quiteActivity come frome: moveActivityTaskToBack");
      AppMethodBeat.o(73400);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
    be localbe = com.tencent.mm.plugin.expt.hellhound.core.stack.e.brH();
    String str = null;
    if (localbe != null) {
      str = localbe.wnr.activityName;
    }
    a.Mj(paramString);
    a.Mi(str);
    ab.i("ActivityMonitor", "habbyge-mali, _finish: from/to = " + paramString + "/" + str);
    AppMethodBeat.o(73400);
  }
  
  private static void f(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(73404);
    String str = paramActivity.getClass().getCanonicalName();
    paramActivity = String.valueOf(paramActivity.hashCode());
    ab.d("ActivityMonitor", "habbyge-mali, _onCreateEvent: /0x" + Integer.toHexString(paramIntent.getFlags()) + "/" + str + "/" + paramActivity);
    com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.e.cf(str, 104);
    a(null, paramIntent, null, str, paramActivity);
    a(str, paramActivity, com.tencent.mm.plugin.expt.hellhound.core.stack.a.lZI);
    AppMethodBeat.o(73404);
  }
  
  public final void B(Activity paramActivity)
  {
    AppMethodBeat.i(73399);
    Object localObject = P(paramActivity);
    if (localObject == null)
    {
      AppMethodBeat.o(73399);
      return;
    }
    String str = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
    localObject = (String)((com.tencent.mm.vending.j.c)localObject).get(1);
    ab.d("ActivityMonitor", "habbyge-mali, finish: " + str + " / " + (String)localObject);
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(73399);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.e.cf(str, 102);
    if ((paramActivity != null) && (this.maa != null)) {
      this.maa.B(paramActivity);
    }
    g localg = com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC().lZQ.lZR;
    bf localbf;
    be localbe;
    if (!TextUtils.isEmpty(str))
    {
      ab.d("TaskRecordWrapper", "habbyge-mali, pop_String: " + str + ":" + (String)localObject);
      localbf = com.tencent.mm.plugin.expt.hellhound.core.stack.c.brA();
      if (!localbf.wnv.isEmpty())
      {
        localbe = g.a(localbf, str, (String)localObject);
        if (localbe != null) {
          break label227;
        }
        ab.e("TaskRecordWrapper", "habbyge-mali, pop_string: realPopActivityRecord Do-Nothing !!!");
      }
    }
    for (;;)
    {
      aI(str, true);
      if ((paramActivity != null) && (this.maa != null)) {
        this.maa.b(paramActivity, (String)localObject);
      }
      AppMethodBeat.o(73399);
      return;
      label227:
      com.tencent.mm.plugin.expt.hellhound.core.stack.c.a(localbf);
      if (localg.lZU != null) {
        localg.lZU.a(localbe, (be)g.brI().get(1));
      }
    }
  }
  
  public final void H(Activity paramActivity)
  {
    AppMethodBeat.i(152274);
    if (this.maa != null) {
      this.maa.H(paramActivity);
    }
    AppMethodBeat.o(152274);
  }
  
  public final void I(Activity paramActivity)
  {
    AppMethodBeat.i(152275);
    if (this.maa != null) {
      this.maa.I(paramActivity);
    }
    AppMethodBeat.o(152275);
  }
  
  public final void L(Activity paramActivity)
  {
    AppMethodBeat.i(73405);
    String str1 = paramActivity.getClass().getCanonicalName();
    String str2 = String.valueOf(paramActivity.hashCode());
    com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.e.cf(str1, 105);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
    bf localbf;
    int i;
    if (!TextUtils.isEmpty(str1))
    {
      ab.d("TaskRecordWrapper", "habbyge-mali, bringTask2FrontWhenActivityResumeIfNeed: ".concat(String.valueOf(str1)));
      localbf = com.tencent.mm.plugin.expt.hellhound.core.stack.c.brA();
      if ((localbf != null) && (!localbf.wnv.isEmpty()) && (!TextUtils.isEmpty(str1))) {
        break label141;
      }
      i = 0;
      if (i == 0) {
        break label384;
      }
      com.tencent.mm.plugin.expt.hellhound.core.stack.c.a(localbf);
      ab.d("TaskRecordWrapper", "habbyge-mali, bringTask2FntWhenActivityResume true");
    }
    for (;;)
    {
      a(str1, str2, com.tencent.mm.plugin.expt.hellhound.core.stack.a.lZJ);
      if (this.maa != null) {
        this.maa.D(paramActivity);
      }
      AppMethodBeat.o(73405);
      return;
      label141:
      ab.d("TaskRecordWrapper", "habbyge-mali, bringTask2Front: " + str1 + "/" + str2);
      Object localObject = (cjr)localbf.wnv.getLast();
      if (localObject == null)
      {
        i = 0;
        break;
      }
      if (((cjr)localObject).xTI.isEmpty())
      {
        i = 0;
        break;
      }
      localObject = (be)((cjr)localObject).xTI.getLast();
      if (localObject == null)
      {
        i = 0;
        break;
      }
      if (h.l(((be)localObject).wnr.activityName, ((be)localObject).wnr.wXg, str1, str2))
      {
        i = 0;
        break;
      }
      localObject = g.b(localbf, str1, str2);
      i = ((Integer)((com.tencent.mm.vending.j.b)localObject).get(0)).intValue();
      int j = ((Integer)((com.tencent.mm.vending.j.c)localObject).get(1)).intValue();
      if (i < 0)
      {
        i = 0;
        break;
      }
      localObject = (cjr)localbf.wnv.remove(i);
      i = ((cjr)localObject).xTI.size();
      if (j < i - 1)
      {
        i -= 1;
        while (i > j)
        {
          ((cjr)localObject).xTI.remove(i);
          i -= 1;
        }
      }
      localbf.wnv.addLast(localObject);
      i = 1;
      break;
      label384:
      ab.d("TaskRecordWrapper", "habbyge-mali, bringTask2FrontWhenActivityResume false");
    }
  }
  
  public final void M(Activity paramActivity)
  {
    AppMethodBeat.i(73406);
    if (paramActivity == null)
    {
      AppMethodBeat.o(73406);
      return;
    }
    String str = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.e.cf(str, 106);
    a(str, String.valueOf(i), com.tencent.mm.plugin.expt.hellhound.core.stack.a.lZK);
    if (this.maa != null) {
      this.maa.E(paramActivity);
    }
    AppMethodBeat.o(73406);
  }
  
  public final void N(Activity paramActivity)
  {
    AppMethodBeat.i(73407);
    if (paramActivity == null)
    {
      AppMethodBeat.o(73407);
      return;
    }
    String str = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    if ("com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI".equals(str))
    {
      AppMethodBeat.o(73407);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.e.cf(str, 107);
    a(str, String.valueOf(i), com.tencent.mm.plugin.expt.hellhound.core.stack.a.lZL);
    if (this.maa != null) {
      this.maa.F(paramActivity);
    }
    AppMethodBeat.o(73407);
  }
  
  public final void O(Activity paramActivity)
  {
    AppMethodBeat.i(73408);
    if (paramActivity == null)
    {
      AppMethodBeat.o(73408);
      return;
    }
    String str = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.e.cf(str, 108);
    a(str, String.valueOf(i), com.tencent.mm.plugin.expt.hellhound.core.stack.a.lZM);
    if (this.maa != null) {
      this.maa.G(paramActivity);
    }
    AppMethodBeat.o(73408);
  }
  
  public final void a(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(73401);
    Object localObject1;
    if (paramActivity != null)
    {
      localObject1 = paramActivity.getClass().getCanonicalName();
      ab.i("ActivityMonitor", "habbyge-mali, startActivity, srcActivity: ".concat(String.valueOf(localObject1)));
      com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.c.brO().mah.Q(paramActivity);
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.e.cf((String)localObject1, 100);
      Object localObject2 = paramIntent.getComponent();
      if (localObject2 != null) {}
      for (localObject2 = ((ComponentName)localObject2).getClassName();; localObject2 = null)
      {
        ab.i("ActivityMonitor", "habbyge-mali, startActivity, dstActivityName: ".concat(String.valueOf(localObject2)));
        com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.e.cf((String)localObject2, 101);
        Object localObject3 = paramIntent.getExtras();
        if (localObject3 != null)
        {
          String str = ((Bundle)localObject3).getString("Chat_User");
          if (!TextUtils.isEmpty(str))
          {
            ab.d("ActivityBundleDao", "habbyge-mali, putExtra, ConstantsUI.Chat.KUser: ".concat(String.valueOf(str)));
            com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.b.eh("Chat_User", str);
          }
          int i = ((Bundle)localObject3).getInt("minimize_secene", -1);
          localObject3 = ((Bundle)localObject3).getString("KPublisherId", null);
          if ((i != 1) || (localObject3 == null) || (!"jd_store".equals(localObject3))) {
            break label378;
          }
          ab.d("ActivityBundleDao", "habbyge-mali, putExtra, ConstantsUI.WebViewUI.KPublisherId: ".concat(String.valueOf(localObject3)));
          com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.b.eh("minimize_secene", String.valueOf(i));
          com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.b.eh("KPublisherId", (String)localObject3);
        }
        for (;;)
        {
          a(paramActivity, paramIntent, (String)localObject1, (String)localObject2, null);
          ab.i("ActivityActionWrapper", "habbyge-mali, setStartActivityAction_resume: ".concat(String.valueOf(localObject2)));
          com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.c.brO().mah.Mk((String)localObject2);
          ab.i("ActivityActionWrapper", "habbyge-mali, setStartActivityAction_pause: ".concat(String.valueOf(localObject1)));
          com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.c.brO().mah.Mm((String)localObject1);
          a.vm(0);
          if ((localObject2 != null) && (this.maa != null)) {
            this.maa.Ma((String)localObject2);
          }
          AppMethodBeat.o(73401);
          return;
          com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.e.brH();
          if (localObject1 == null) {
            break label405;
          }
          localObject1 = ((be)localObject1).wnr.activityName;
          ab.i("ActivityMonitor", "habbyge-mali, startActivity, srcActivityName: ".concat(String.valueOf(localObject1)));
          com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.c.brO().mah.Mp((String)localObject1);
          break;
          label378:
          com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.b.eh("minimize_secene", "");
          com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.b.eh("KPublisherId", "");
        }
      }
      label405:
      localObject1 = null;
    }
  }
  
  public final void a(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(73398);
    Object localObject = P(paramActivity);
    if (localObject == null)
    {
      AppMethodBeat.o(73398);
      return;
    }
    String str = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
    localObject = (String)((com.tencent.mm.vending.j.c)localObject).get(1);
    ab.d("ActivityMonitor", "habbyge-mali, moveActivityTaskToBack: " + str + " / " + (String)localObject);
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(73398);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.e.cf(str, 103);
    if ((paramActivity != null) && (this.maa != null)) {
      this.maa.C(paramActivity);
    }
    g localg = com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC().lZQ.lZR;
    ab.d("TaskRecordWrapper", "habbyge-mali, moveActivityTaskToBack: " + str + ":" + (String)localObject + ":" + paramBoolean);
    bf localbf = com.tencent.mm.plugin.expt.hellhound.core.stack.c.brA();
    be localbe = new be();
    localbe.wnr = new ckn();
    localbe.wnr.activityName = str;
    localbe.wnr.wXg = ((String)localObject);
    com.tencent.mm.vending.j.c localc = g.a(localbf, localbe);
    if (localc == null) {
      ab.e("TaskRecordWrapper", "habbyge-mali, moveActivityTaskToBack tuple2 == null");
    }
    for (;;)
    {
      aI(str, false);
      if ((paramActivity != null) && (this.maa != null)) {
        this.maa.c(paramActivity, (String)localObject);
      }
      AppMethodBeat.o(73398);
      return;
      cjr localcjr = (cjr)localc.get(0);
      int i = ((Integer)localc.get(1)).intValue();
      if (!paramBoolean)
      {
        ab.w("TaskRecordWrapper", "habbyge-mali, moveActivityTaskToBack nonRoot: false");
        if (!h.a(((be)localcjr.xTI.getFirst()).wnr, localbe.wnr))
        {
          ab.w("TaskRecordWrapper", "habbyge-mali, moveActivityTaskToBack nonRoot: 不处理直接返回");
          continue;
        }
      }
      int j = localbf.wnv.size();
      ab.d("TaskRecordWrapper", "habbyge-mali, moveActivityTaskToBack: taskPosition = " + i + "/" + j);
      if (i == j - 1)
      {
        localbf.wnv.remove(i);
        localbf.wnv.addFirst(localcjr);
        com.tencent.mm.plugin.expt.hellhound.core.stack.c.a(localbf);
        ab.d("TaskRecordWrapper", "habbyge-mali, moveActivityTaskToBack 栈顶");
        if (localg.lZU != null) {
          localg.lZU.c(localbe, g.c(localbf));
        }
      }
      else
      {
        ab.e("TaskRecordWrapper", "habbyge-mali, moveActivityTaskToBack 非栈顶，不合法");
      }
    }
  }
  
  public final void a(b.a parama)
  {
    this.maa = parama;
  }
  
  public final void d(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(73402);
    if (paramActivity == null)
    {
      AppMethodBeat.o(73402);
      return;
    }
    f(paramIntent, paramActivity);
    AppMethodBeat.o(73402);
  }
  
  public final void e(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(73403);
    if (paramActivity == null)
    {
      AppMethodBeat.o(73403);
      return;
    }
    f(paramIntent, paramActivity);
    AppMethodBeat.o(73403);
  }
  
  /* Error */
  public final void h(android.app.Application paramApplication)
  {
    // Byte code:
    //   0: ldc_w 527
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +10 -> 17
    //   10: ldc_w 527
    //   13: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: return
    //   17: aload_0
    //   18: getfield 34	com/tencent/mm/plugin/expt/hellhound/core/v2/activity/b:mab	Lcom/tencent/mm/plugin/expt/hellhound/core/v2/activity/ActivityHijack;
    //   21: astore 5
    //   23: ldc_w 529
    //   26: ldc_w 531
    //   29: invokestatic 154	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: getstatic 536	android/os/Build$VERSION:SDK_INT	I
    //   35: bipush 26
    //   37: if_icmpge +429 -> 466
    //   40: ldc_w 538
    //   43: invokestatic 543	com/tencent/mm/plugin/expt/hellhound/core/a/a/a:getClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   46: astore 6
    //   48: aload 6
    //   50: ldc_w 545
    //   53: invokestatic 548	com/tencent/mm/plugin/expt/hellhound/core/a/a/a:a	(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   56: astore_1
    //   57: aload 6
    //   59: ldc_w 545
    //   62: invokestatic 551	com/tencent/mm/plugin/expt/hellhound/core/a/a/a:b	(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;
    //   65: astore_2
    //   66: aload_1
    //   67: astore_3
    //   68: aload_2
    //   69: astore_1
    //   70: aload_3
    //   71: astore_2
    //   72: aload_1
    //   73: ifnonnull +152 -> 225
    //   76: ldc_w 529
    //   79: ldc_w 553
    //   82: invokestatic 271	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: getfield 41	com/tencent/mm/plugin/expt/hellhound/core/v2/activity/b:mad	Lcom/tencent/mm/plugin/expt/hellhound/core/v2/activity/HellInstrumentationHijack;
    //   89: astore_1
    //   90: ldc_w 555
    //   93: ldc_w 557
    //   96: invokestatic 154	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: invokestatic 560	com/tencent/mm/plugin/expt/hellhound/core/a/a/a:brz	()Ljava/lang/Class;
    //   102: astore_2
    //   103: aload_2
    //   104: ifnonnull +549 -> 653
    //   107: ldc_w 527
    //   110: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: return
    //   114: astore_1
    //   115: aconst_null
    //   116: astore_1
    //   117: aload 6
    //   119: ifnull +676 -> 795
    //   122: aload 6
    //   124: ldc_w 562
    //   127: iconst_0
    //   128: anewarray 108	java/lang/Class
    //   131: invokevirtual 566	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   134: astore_2
    //   135: aload_2
    //   136: iconst_1
    //   137: invokevirtual 572	java/lang/reflect/Method:setAccessible	(Z)V
    //   140: aload_2
    //   141: aconst_null
    //   142: iconst_0
    //   143: anewarray 4	java/lang/Object
    //   146: invokevirtual 576	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   149: astore_3
    //   150: aload_3
    //   151: astore_2
    //   152: ldc_w 529
    //   155: new 64	java/lang/StringBuilder
    //   158: dup
    //   159: ldc_w 578
    //   162: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   165: aload_3
    //   166: invokevirtual 106	java/lang/Object:getClass	()Ljava/lang/Class;
    //   169: invokevirtual 111	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   172: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 494	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload_3
    //   182: astore_2
    //   183: aload 6
    //   185: ldc_w 562
    //   188: invokestatic 580	com/tencent/mm/plugin/expt/hellhound/core/a/a/a:c	(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;
    //   191: astore_3
    //   192: aload_1
    //   193: astore_2
    //   194: aload_3
    //   195: astore_1
    //   196: goto -124 -> 72
    //   199: astore 4
    //   201: aconst_null
    //   202: astore_3
    //   203: ldc_w 529
    //   206: aload 4
    //   208: ldc_w 582
    //   211: iconst_0
    //   212: anewarray 4	java/lang/Object
    //   215: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: aload_1
    //   219: astore_2
    //   220: aload_3
    //   221: astore_1
    //   222: goto -150 -> 72
    //   225: aload 6
    //   227: ifnull +124 -> 351
    //   230: aload_1
    //   231: aload 6
    //   233: invokestatic 585	com/tencent/mm/plugin/expt/hellhound/core/a/a/a:b	(Ljava/lang/Object;Ljava/lang/Class;)Z
    //   236: ifeq +115 -> 351
    //   239: aload 5
    //   241: aload_1
    //   242: putfield 589	com/tencent/mm/plugin/expt/hellhound/core/v2/activity/ActivityHijack:lZV	Ljava/lang/Object;
    //   245: aload_1
    //   246: invokevirtual 106	java/lang/Object:getClass	()Ljava/lang/Class;
    //   249: astore_3
    //   250: aload_3
    //   251: invokestatic 593	com/tencent/mm/plugin/expt/hellhound/core/a/a/a:ak	(Ljava/lang/Class;)Ljava/util/ArrayList;
    //   254: astore_1
    //   255: aload_1
    //   256: ifnull +87 -> 343
    //   259: aload_1
    //   260: invokeinterface 596 1 0
    //   265: ifle +78 -> 343
    //   268: aload_1
    //   269: aload_1
    //   270: invokeinterface 596 1 0
    //   275: anewarray 108	java/lang/Class
    //   278: invokeinterface 600 2 0
    //   283: checkcast 602	[Ljava/lang/Class;
    //   286: astore_1
    //   287: aload_3
    //   288: invokevirtual 606	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   291: aload_1
    //   292: aload 5
    //   294: invokestatic 612	java/lang/reflect/Proxy:newProxyInstance	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   297: astore_1
    //   298: aload_2
    //   299: ifnull -214 -> 85
    //   302: aload_2
    //   303: aconst_null
    //   304: aload_1
    //   305: invokevirtual 618	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   308: goto -223 -> 85
    //   311: astore_1
    //   312: ldc_w 529
    //   315: aload_1
    //   316: ldc_w 582
    //   319: iconst_0
    //   320: anewarray 4	java/lang/Object
    //   323: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   326: getstatic 624	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   329: ldc2_w 625
    //   332: ldc2_w 627
    //   335: lconst_1
    //   336: iconst_0
    //   337: invokevirtual 632	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   340: goto -255 -> 85
    //   343: iconst_0
    //   344: anewarray 108	java/lang/Class
    //   347: astore_1
    //   348: goto -61 -> 287
    //   351: ldc_w 634
    //   354: invokestatic 637	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   357: astore_2
    //   358: aload_1
    //   359: aload_2
    //   360: invokestatic 585	com/tencent/mm/plugin/expt/hellhound/core/a/a/a:b	(Ljava/lang/Object;Ljava/lang/Class;)Z
    //   363: ifeq -278 -> 85
    //   366: aload_2
    //   367: ldc_w 639
    //   370: invokevirtual 643	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   373: astore_3
    //   374: aload_3
    //   375: iconst_1
    //   376: invokevirtual 644	java/lang/reflect/Field:setAccessible	(Z)V
    //   379: aload_3
    //   380: aload_1
    //   381: invokevirtual 647	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   384: astore_2
    //   385: aload_2
    //   386: ifnull -301 -> 85
    //   389: aload 5
    //   391: aload_2
    //   392: putfield 589	com/tencent/mm/plugin/expt/hellhound/core/v2/activity/ActivityHijack:lZV	Ljava/lang/Object;
    //   395: aload_2
    //   396: invokevirtual 106	java/lang/Object:getClass	()Ljava/lang/Class;
    //   399: astore 4
    //   401: aload 4
    //   403: invokestatic 593	com/tencent/mm/plugin/expt/hellhound/core/a/a/a:ak	(Ljava/lang/Class;)Ljava/util/ArrayList;
    //   406: astore_2
    //   407: aload_2
    //   408: ifnull +50 -> 458
    //   411: aload_2
    //   412: invokeinterface 596 1 0
    //   417: ifle +41 -> 458
    //   420: aload_2
    //   421: aload_2
    //   422: invokeinterface 596 1 0
    //   427: anewarray 108	java/lang/Class
    //   430: invokeinterface 600 2 0
    //   435: checkcast 602	[Ljava/lang/Class;
    //   438: astore_2
    //   439: aload_3
    //   440: aload_1
    //   441: aload 4
    //   443: invokevirtual 606	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   446: aload_2
    //   447: aload 5
    //   449: invokestatic 612	java/lang/reflect/Proxy:newProxyInstance	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   452: invokevirtual 618	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   455: goto -370 -> 85
    //   458: iconst_0
    //   459: anewarray 108	java/lang/Class
    //   462: astore_2
    //   463: goto -24 -> 439
    //   466: ldc_w 649
    //   469: invokestatic 543	com/tencent/mm/plugin/expt/hellhound/core/a/a/a:getClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   472: ldc_w 651
    //   475: invokestatic 551	com/tencent/mm/plugin/expt/hellhound/core/a/a/a:b	(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;
    //   478: astore_2
    //   479: ldc_w 634
    //   482: invokestatic 543	com/tencent/mm/plugin/expt/hellhound/core/a/a/a:getClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   485: ldc_w 639
    //   488: invokestatic 548	com/tencent/mm/plugin/expt/hellhound/core/a/a/a:a	(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   491: astore_3
    //   492: aload_3
    //   493: ifnull -408 -> 85
    //   496: aload_2
    //   497: aload_3
    //   498: invokestatic 654	com/tencent/mm/plugin/expt/hellhound/core/a/a/a:a	(Ljava/lang/Object;Ljava/lang/reflect/Field;)Ljava/lang/Object;
    //   501: astore 4
    //   503: aload 4
    //   505: ifnull -420 -> 85
    //   508: aload 5
    //   510: aload 4
    //   512: putfield 589	com/tencent/mm/plugin/expt/hellhound/core/v2/activity/ActivityHijack:lZV	Ljava/lang/Object;
    //   515: aload 4
    //   517: invokevirtual 106	java/lang/Object:getClass	()Ljava/lang/Class;
    //   520: invokestatic 593	com/tencent/mm/plugin/expt/hellhound/core/a/a/a:ak	(Ljava/lang/Class;)Ljava/util/ArrayList;
    //   523: astore_1
    //   524: aload_1
    //   525: ifnull +120 -> 645
    //   528: aload_1
    //   529: invokeinterface 596 1 0
    //   534: ifle +111 -> 645
    //   537: aload_1
    //   538: aload_1
    //   539: invokeinterface 596 1 0
    //   544: anewarray 108	java/lang/Class
    //   547: invokeinterface 600 2 0
    //   552: checkcast 602	[Ljava/lang/Class;
    //   555: astore_1
    //   556: aload 4
    //   558: invokevirtual 106	java/lang/Object:getClass	()Ljava/lang/Class;
    //   561: invokevirtual 606	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   564: aload_1
    //   565: aload 5
    //   567: invokestatic 656	com/tencent/mm/plugin/expt/hellhound/core/a/a/a:a	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   570: astore_1
    //   571: aload_1
    //   572: ifnull +32 -> 604
    //   575: ldc_w 529
    //   578: new 64	java/lang/StringBuilder
    //   581: dup
    //   582: ldc_w 658
    //   585: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   588: aload_1
    //   589: invokevirtual 106	java/lang/Object:getClass	()Ljava/lang/Class;
    //   592: invokevirtual 111	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   595: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 494	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   604: aload_3
    //   605: aload_2
    //   606: aload_1
    //   607: invokestatic 661	com/tencent/mm/plugin/expt/hellhound/core/a/a/a:a	(Ljava/lang/reflect/Field;Ljava/lang/Object;Ljava/lang/Object;)V
    //   610: goto -525 -> 85
    //   613: astore_1
    //   614: ldc_w 529
    //   617: aload_1
    //   618: ldc_w 663
    //   621: iconst_0
    //   622: anewarray 4	java/lang/Object
    //   625: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   628: getstatic 624	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   631: ldc2_w 625
    //   634: ldc2_w 664
    //   637: lconst_1
    //   638: iconst_0
    //   639: invokevirtual 632	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   642: goto -557 -> 85
    //   645: iconst_0
    //   646: anewarray 108	java/lang/Class
    //   649: astore_1
    //   650: goto -94 -> 556
    //   653: ldc_w 555
    //   656: new 64	java/lang/StringBuilder
    //   659: dup
    //   660: ldc_w 667
    //   663: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   666: aload_2
    //   667: invokevirtual 111	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   670: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   676: invokestatic 494	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   679: aload_2
    //   680: ldc_w 669
    //   683: iconst_0
    //   684: anewarray 108	java/lang/Class
    //   687: invokevirtual 566	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   690: astore_3
    //   691: aload_3
    //   692: iconst_1
    //   693: invokevirtual 572	java/lang/reflect/Method:setAccessible	(Z)V
    //   696: aload_3
    //   697: aconst_null
    //   698: iconst_0
    //   699: anewarray 4	java/lang/Object
    //   702: invokevirtual 576	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   705: astore_3
    //   706: aload_2
    //   707: ldc_w 671
    //   710: invokevirtual 643	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   713: astore_2
    //   714: aload_2
    //   715: iconst_1
    //   716: invokevirtual 644	java/lang/reflect/Field:setAccessible	(Z)V
    //   719: aload_1
    //   720: aload_2
    //   721: aload_3
    //   722: invokevirtual 647	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   725: checkcast 673	android/app/Instrumentation
    //   728: putfield 677	com/tencent/mm/plugin/expt/hellhound/core/v2/activity/HellInstrumentationHijack:maf	Landroid/app/Instrumentation;
    //   731: aload_1
    //   732: invokevirtual 680	com/tencent/mm/plugin/expt/hellhound/core/v2/activity/HellInstrumentationHijack:brK	()V
    //   735: aload_2
    //   736: aload_3
    //   737: aload_1
    //   738: invokevirtual 618	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   741: ldc_w 527
    //   744: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   747: return
    //   748: astore_1
    //   749: ldc_w 555
    //   752: aload_1
    //   753: ldc_w 682
    //   756: iconst_0
    //   757: anewarray 4	java/lang/Object
    //   760: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   763: getstatic 624	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   766: ldc2_w 625
    //   769: ldc2_w 683
    //   772: lconst_1
    //   773: iconst_0
    //   774: invokevirtual 632	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   777: ldc_w 527
    //   780: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   783: return
    //   784: astore 4
    //   786: aload_2
    //   787: astore_3
    //   788: goto -585 -> 203
    //   791: astore_2
    //   792: goto -675 -> 117
    //   795: aconst_null
    //   796: astore_2
    //   797: goto -614 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	800	0	this	b
    //   0	800	1	paramApplication	android.app.Application
    //   65	722	2	localObject1	Object
    //   791	1	2	localException1	Exception
    //   796	1	2	localObject2	Object
    //   67	721	3	localObject3	Object
    //   199	8	4	localException2	Exception
    //   399	158	4	localObject4	Object
    //   784	1	4	localException3	Exception
    //   21	545	5	localActivityHijack	ActivityHijack
    //   46	186	6	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   48	57	114	java/lang/Exception
    //   122	150	199	java/lang/Exception
    //   40	48	311	java/lang/Exception
    //   76	85	311	java/lang/Exception
    //   203	218	311	java/lang/Exception
    //   230	255	311	java/lang/Exception
    //   259	287	311	java/lang/Exception
    //   287	298	311	java/lang/Exception
    //   302	308	311	java/lang/Exception
    //   343	348	311	java/lang/Exception
    //   351	385	311	java/lang/Exception
    //   389	407	311	java/lang/Exception
    //   411	439	311	java/lang/Exception
    //   439	455	311	java/lang/Exception
    //   458	463	311	java/lang/Exception
    //   466	492	613	java/lang/Exception
    //   496	503	613	java/lang/Exception
    //   508	524	613	java/lang/Exception
    //   528	556	613	java/lang/Exception
    //   556	571	613	java/lang/Exception
    //   575	604	613	java/lang/Exception
    //   604	610	613	java/lang/Exception
    //   645	650	613	java/lang/Exception
    //   99	103	748	java/lang/Exception
    //   653	741	748	java/lang/Exception
    //   152	181	784	java/lang/Exception
    //   183	192	784	java/lang/Exception
    //   57	66	791	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.v2.activity.b
 * JD-Core Version:    0.7.0.1
 */