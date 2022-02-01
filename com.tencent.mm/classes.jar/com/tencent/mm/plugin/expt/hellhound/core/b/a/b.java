package com.tencent.mm.plugin.expt.hellhound.core.b.a;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.e.a;
import com.tencent.mm.plugin.expt.b.e.d;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.k;
import com.tencent.mm.plugin.expt.hellhound.ext.session.config.f;
import com.tencent.mm.protocal.protobuf.bt;
import com.tencent.mm.protocal.protobuf.drg;
import com.tencent.mm.protocal.protobuf.dwh;
import com.tencent.mm.protocal.protobuf.fns;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class b
  implements e, com.tencent.mm.plugin.expt.hellhound.core.c
{
  private List<e.d> zBA;
  private d zBB;
  private c zBC;
  private boolean zBD;
  private e.a zBz;
  
  public b()
  {
    AppMethodBeat.i(121919);
    this.zBA = new CopyOnWriteArrayList();
    this.zBB = new d(this);
    this.zBD = com.tencent.mm.plugin.expt.hellhound.a.dIP();
    this.zBC = new c();
    AppMethodBeat.o(121919);
  }
  
  @Deprecated
  private static void a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(300038);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg().a(paramActivity, paramIntent, paramString1, paramString2, paramInt);
    AppMethodBeat.o(300038);
  }
  
  @Deprecated
  private static void a(String paramString, int paramInt, com.tencent.mm.plugin.expt.hellhound.core.stack.a parama)
  {
    AppMethodBeat.i(300045);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.a(paramString, paramInt, parama);
    AppMethodBeat.o(300045);
  }
  
  @Deprecated
  private static com.tencent.mm.vending.j.c<String, Integer> ag(Activity paramActivity)
  {
    AppMethodBeat.i(121936);
    if (paramActivity == null) {
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg();
        paramActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJh();
        Log.d("HABBYGE-MALI.ActivityMonitor", "getActivityOnFinish: %s, %s", new Object[] { paramActivity.get(0), paramActivity.get(1) });
        AppMethodBeat.o(121936);
        return paramActivity;
      }
      catch (Exception paramActivity)
      {
        Log.printErrStackTrace("HABBYGE-MALI.ActivityMonitor", paramActivity, "getActivityOnFinish", new Object[0]);
        AppMethodBeat.o(121936);
        return null;
      }
    }
    paramActivity = com.tencent.mm.vending.j.a.U(paramActivity.getClass().getCanonicalName(), Integer.valueOf(paramActivity.hashCode()));
    AppMethodBeat.o(121936);
    return paramActivity;
  }
  
  @Deprecated
  private static void bm(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(121932);
    a.LA(1);
    if ((!paramBoolean) && (com.tencent.mm.plugin.expt.hellhound.core.b.aqC(paramString)))
    {
      Log.i("HABBYGE-MALI.ActivityMonitor", "_quiteActivity come frome: moveActivityTaskToBack");
      AppMethodBeat.o(121932);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg();
    bt localbt = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dJl();
    String str = null;
    if (localbt != null) {
      str = localbt.YDs.AtM;
    }
    a.ark(paramString);
    a.ari(str);
    Log.i("HABBYGE-MALI.ActivityMonitor", "_finish: from: %s, to: %s = ", new Object[] { paramString, str });
    AppMethodBeat.o(121932);
  }
  
  @Deprecated
  private static void f(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(121933);
    String str = paramActivity.getClass().getCanonicalName();
    int i = paramActivity.hashCode();
    com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Y(str, null, 104);
    a(null, paramIntent, null, str, i);
    a(str, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.zBo);
    AppMethodBeat.o(121933);
  }
  
  public final void Z(Activity paramActivity)
  {
    AppMethodBeat.i(121923);
    Object localObject;
    if (this.zBD)
    {
      localObject = new fns();
      if (paramActivity == null)
      {
        k.f(paramActivity, ((fns)localObject).timestamp);
        com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGR = ((fns)localObject).AtM;
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(101, localObject);
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
        com.tencent.mm.plugin.expt.hellhound.ext.session.b.f(paramActivity, 2);
        com.tencent.mm.plugin.expt.hellhound.ext.b.a.a(paramActivity.getClass().getCanonicalName(), Integer.valueOf(paramActivity.hashCode()), 1);
      }
    }
    for (;;)
    {
      paramActivity = this.zBA.iterator();
      while (paramActivity.hasNext()) {
        ((e.d)paramActivity.next()).dtB();
      }
      ((fns)localObject).AtM = paramActivity.getClass().getCanonicalName();
      ((fns)localObject).cHb = paramActivity.hashCode();
      ((fns)localObject).timestamp = System.currentTimeMillis();
      break;
      paramActivity = ag(paramActivity);
      if (paramActivity != null)
      {
        localObject = (String)paramActivity.get(0);
        ((Integer)paramActivity.get(1)).intValue();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Y((String)localObject, null, 102);
          bm((String)localObject, true);
        }
      }
    }
    AppMethodBeat.o(121923);
  }
  
  public final void a(e.a parama)
  {
    this.zBz = parama;
    this.zBC.zBz = parama;
  }
  
  public final void a(e.d paramd)
  {
    AppMethodBeat.i(300066);
    if (paramd == null)
    {
      AppMethodBeat.o(300066);
      return;
    }
    this.zBA.add(paramd);
    AppMethodBeat.o(300066);
  }
  
  public final void aa(Activity paramActivity)
  {
    AppMethodBeat.i(121926);
    Object localObject;
    if (this.zBD)
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.dIT().fa(paramActivity);
      if ((paramActivity != null) && (com.tencent.mm.plugin.expt.hellhound.core.b.aqM(paramActivity.getClass().getSimpleName())) && (f.ap(paramActivity))) {
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(222, "144");
      }
      k.a(paramActivity, null, System.currentTimeMillis(), 5);
      localObject = new fns();
      ((fns)localObject).AtM = paramActivity.getClass().getCanonicalName();
      ((fns)localObject).cHb = paramActivity.hashCode();
      ((fns)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(202, localObject);
      com.tencent.mm.plugin.expt.hellhound.ext.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.ext.b.a.b.zES;
      com.tencent.mm.plugin.expt.hellhound.ext.b.a.b.c(((fns)localObject).AtM, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.ext.f.e.dME().a(0, ((fns)localObject).AtM, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.b.c.e.dJP();
      k.arX(paramActivity.getClass().getSimpleName());
    }
    for (;;)
    {
      paramActivity = this.zBA.iterator();
      while (paramActivity.hasNext()) {
        ((e.d)paramActivity.next()).dtF();
      }
      localObject = paramActivity.getClass().getCanonicalName();
      int i = paramActivity.hashCode();
      com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Y((String)localObject, null, 105);
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg();
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.arf((String)localObject);
      a((String)localObject, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.zBp);
    }
    AppMethodBeat.o(121926);
  }
  
  public final void ab(Activity paramActivity)
  {
    AppMethodBeat.i(121927);
    if (this.zBD)
    {
      long l = System.currentTimeMillis();
      k.d(paramActivity, l);
      localObject = com.tencent.mm.plugin.expt.hellhound.core.a.dIT();
      if (paramActivity != null) {
        ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject).zAO.a(paramActivity, l);
      }
      localObject = c.c(paramActivity, l);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(203, localObject);
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.f(paramActivity, 0);
    }
    Object localObject = this.zBA.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((e.d)((Iterator)localObject).next()).W(paramActivity);
    }
    AppMethodBeat.o(121927);
  }
  
  public final void ac(Activity paramActivity)
  {
    AppMethodBeat.i(121928);
    if (paramActivity == null)
    {
      AppMethodBeat.o(121928);
      return;
    }
    Object localObject;
    if (this.zBD)
    {
      localObject = new fns();
      ((fns)localObject).cHb = paramActivity.hashCode();
      ((fns)localObject).AtM = paramActivity.getClass().getCanonicalName();
      ((fns)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGS = ((fns)localObject).AtM;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(204, localObject);
      com.tencent.mm.plugin.expt.hellhound.ext.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.ext.b.a.b.zES;
      com.tencent.mm.plugin.expt.hellhound.ext.b.a.b.d(((fns)localObject).AtM, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.ext.f.e.dME().a(1, ((fns)localObject).AtM, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.b.c.e.dJQ();
      k.arY(paramActivity.getClass().getSimpleName());
    }
    for (;;)
    {
      paramActivity = this.zBA.iterator();
      while (paramActivity.hasNext()) {
        ((e.d)paramActivity.next()).dtG();
      }
      localObject = paramActivity.getClass().getCanonicalName();
      int i = paramActivity.hashCode();
      com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Y((String)localObject, null, 106);
      a((String)localObject, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.zBq);
    }
    AppMethodBeat.o(121928);
  }
  
  public final void ad(Activity paramActivity)
  {
    AppMethodBeat.i(121929);
    if (this.zBD)
    {
      long l = System.currentTimeMillis();
      k.b(paramActivity, null, l, 7);
      k.e(paramActivity, l);
      Object localObject = c.c(paramActivity, l);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(205, localObject);
      localObject = com.tencent.mm.plugin.expt.hellhound.core.a.dIT();
      if (paramActivity != null) {
        ((com.tencent.mm.plugin.expt.hellhound.core.a)localObject).zAO.b(paramActivity, l);
      }
    }
    paramActivity = this.zBA.iterator();
    while (paramActivity.hasNext()) {
      ((e.d)paramActivity.next()).dtI();
    }
    AppMethodBeat.o(121929);
  }
  
  public final void ae(Activity paramActivity)
  {
    AppMethodBeat.i(121930);
    if (paramActivity == null)
    {
      AppMethodBeat.o(121930);
      return;
    }
    Object localObject;
    if (this.zBD)
    {
      localObject = new fns();
      ((fns)localObject).cHb = paramActivity.hashCode();
      ((fns)localObject).AtM = paramActivity.getClass().getCanonicalName();
      ((fns)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(206, localObject);
    }
    for (;;)
    {
      paramActivity = this.zBA.iterator();
      while (paramActivity.hasNext()) {
        ((e.d)paramActivity.next()).dtH();
      }
      localObject = paramActivity.getClass().getCanonicalName();
      int i = paramActivity.hashCode();
      if (!com.tencent.mm.plugin.expt.hellhound.core.b.aqJ((String)localObject))
      {
        com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Y((String)localObject, null, 107);
        a((String)localObject, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.zBr);
      }
    }
    AppMethodBeat.o(121930);
  }
  
  public final void af(Activity paramActivity)
  {
    AppMethodBeat.i(121931);
    if (paramActivity == null)
    {
      AppMethodBeat.o(121931);
      return;
    }
    Object localObject;
    if (this.zBD)
    {
      localObject = new fns();
      ((fns)localObject).AtM = paramActivity.getClass().getCanonicalName();
      ((fns)localObject).cHb = paramActivity.hashCode();
      ((fns)localObject).timestamp = System.currentTimeMillis();
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(207, localObject);
      com.tencent.mm.plugin.expt.hellhound.ext.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.ext.b.a.b.zES;
      com.tencent.mm.plugin.expt.hellhound.ext.b.a.b.e(((fns)localObject).AtM, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.ext.f.e.dME().a(2, ((fns)localObject).AtM, paramActivity);
      k.arV(((fns)localObject).AtM);
    }
    for (;;)
    {
      localObject = this.zBA.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((e.d)((Iterator)localObject).next()).V(paramActivity);
      }
      localObject = paramActivity.getClass().getCanonicalName();
      int i = paramActivity.hashCode();
      com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Y((String)localObject, null, 108);
      a((String)localObject, i, com.tencent.mm.plugin.expt.hellhound.core.stack.a.zBs);
    }
    AppMethodBeat.o(121931);
  }
  
  public final void b(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(121922);
    Object localObject;
    if (this.zBD)
    {
      localObject = new drg();
      ((drg)localObject).aajj = new fns();
      ((drg)localObject).timestamp = System.currentTimeMillis();
      if (paramActivity != null)
      {
        ((drg)localObject).aajj.AtM = paramActivity.getClass().getCanonicalName();
        ((drg)localObject).aajj.cHb = paramActivity.hashCode();
        ((drg)localObject).aajj.timestamp = ((drg)localObject).timestamp;
      }
      ((drg)localObject).aaFe = paramBoolean;
      k.f(paramActivity, ((drg)localObject).timestamp);
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGR = ((drg)localObject).aajj.AtM;
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(102, localObject);
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx();
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.f(paramActivity, 2);
      com.tencent.mm.plugin.expt.hellhound.ext.b.a.a(paramActivity.getClass().getCanonicalName(), Integer.valueOf(paramActivity.hashCode()), 1);
    }
    for (;;)
    {
      paramActivity = this.zBA.iterator();
      while (paramActivity.hasNext()) {
        ((e.d)paramActivity.next()).dtC();
      }
      paramActivity = ag(paramActivity);
      if (paramActivity != null)
      {
        localObject = (String)paramActivity.get(0);
        ((Integer)paramActivity.get(1)).intValue();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Y((String)localObject, null, 103);
          bm((String)localObject, false);
        }
      }
    }
    AppMethodBeat.o(121922);
  }
  
  public final void d(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(121924);
    if (this.zBD)
    {
      paramIntent = c.g(paramIntent, paramActivity);
      k.dKS();
      k.arT(paramIntent.aajj.AtM);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(200, paramIntent);
    }
    for (;;)
    {
      paramIntent = this.zBA.iterator();
      while (paramIntent.hasNext()) {
        ((e.d)paramIntent.next()).dtD();
      }
      if (paramActivity != null) {
        f(paramIntent, paramActivity);
      }
    }
    AppMethodBeat.o(121924);
  }
  
  public final void e(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(121925);
    if (this.zBD)
    {
      paramIntent = c.g(paramIntent, paramActivity);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(201, paramIntent);
    }
    for (;;)
    {
      paramIntent = this.zBA.iterator();
      while (paramIntent.hasNext()) {
        ((e.d)paramIntent.next()).dtE();
      }
      if (paramActivity != null) {
        f(paramIntent, paramActivity);
      }
    }
    AppMethodBeat.o(121925);
  }
  
  /* Error */
  public final void l(Activity paramActivity, Intent paramIntent)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: ldc_w 478
    //   6: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 50	com/tencent/mm/plugin/expt/hellhound/core/b/a/b:zBD	Z
    //   13: ifeq +630 -> 643
    //   16: invokestatic 273	java/lang/System:currentTimeMillis	()J
    //   19: lstore 4
    //   21: new 480	com/tencent/mm/protocal/protobuf/fhg
    //   24: dup
    //   25: invokespecial 481	com/tencent/mm/protocal/protobuf/fhg:<init>	()V
    //   28: astore 7
    //   30: aload 7
    //   32: new 171	com/tencent/mm/protocal/protobuf/fns
    //   35: dup
    //   36: invokespecial 206	com/tencent/mm/protocal/protobuf/fns:<init>	()V
    //   39: putfield 484	com/tencent/mm/protocal/protobuf/fhg:aaEZ	Lcom/tencent/mm/protocal/protobuf/fns;
    //   42: aload_1
    //   43: ifnull +510 -> 553
    //   46: aload_1
    //   47: invokevirtual 114	java/lang/Object:getClass	()Ljava/lang/Class;
    //   50: invokevirtual 120	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   53: astore 6
    //   55: aload 7
    //   57: getfield 484	com/tencent/mm/protocal/protobuf/fhg:aaEZ	Lcom/tencent/mm/protocal/protobuf/fns;
    //   60: aload_1
    //   61: invokevirtual 124	java/lang/Object:hashCode	()I
    //   64: putfield 267	com/tencent/mm/protocal/protobuf/fns:cHb	I
    //   67: ldc_w 486
    //   70: ldc_w 488
    //   73: iconst_1
    //   74: anewarray 4	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload 6
    //   81: aastore
    //   82: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: aload_1
    //   86: invokestatic 491	com/tencent/mm/plugin/expt/hellhound/core/b/a/c:ai	(Landroid/app/Activity;)Lcom/tencent/mm/vending/j/c;
    //   89: astore_1
    //   90: aload 7
    //   92: aload_1
    //   93: iconst_0
    //   94: invokevirtual 95	com/tencent/mm/vending/j/b:get	(I)Ljava/lang/Object;
    //   97: checkcast 277	java/lang/String
    //   100: putfield 494	com/tencent/mm/protocal/protobuf/fhg:aajk	Ljava/lang/String;
    //   103: aload 7
    //   105: aload_1
    //   106: iconst_1
    //   107: invokevirtual 98	com/tencent/mm/vending/j/c:get	(I)Ljava/lang/Object;
    //   110: checkcast 496	java/lang/Boolean
    //   113: invokevirtual 499	java/lang/Boolean:booleanValue	()Z
    //   116: putfield 502	com/tencent/mm/protocal/protobuf/fhg:aajn	Z
    //   119: aload 6
    //   121: astore_1
    //   122: aload 7
    //   124: getfield 484	com/tencent/mm/protocal/protobuf/fhg:aaEZ	Lcom/tencent/mm/protocal/protobuf/fns;
    //   127: aload_1
    //   128: putfield 175	com/tencent/mm/protocal/protobuf/fns:AtM	Ljava/lang/String;
    //   131: aload 7
    //   133: getfield 484	com/tencent/mm/protocal/protobuf/fhg:aaEZ	Lcom/tencent/mm/protocal/protobuf/fns;
    //   136: lload 4
    //   138: putfield 210	com/tencent/mm/protocal/protobuf/fns:timestamp	J
    //   141: aload_2
    //   142: ifnull +815 -> 957
    //   145: aload_2
    //   146: invokevirtual 508	android/content/Intent:getComponent	()Landroid/content/ComponentName;
    //   149: astore 6
    //   151: aload 6
    //   153: ifnull +804 -> 957
    //   156: aload 6
    //   158: invokevirtual 513	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   161: astore 6
    //   163: aload 7
    //   165: new 171	com/tencent/mm/protocal/protobuf/fns
    //   168: dup
    //   169: invokespecial 206	com/tencent/mm/protocal/protobuf/fns:<init>	()V
    //   172: putfield 516	com/tencent/mm/protocal/protobuf/fhg:aaFa	Lcom/tencent/mm/protocal/protobuf/fns;
    //   175: aload 7
    //   177: getfield 516	com/tencent/mm/protocal/protobuf/fhg:aaFa	Lcom/tencent/mm/protocal/protobuf/fns;
    //   180: aload 6
    //   182: putfield 175	com/tencent/mm/protocal/protobuf/fns:AtM	Ljava/lang/String;
    //   185: aload 7
    //   187: getfield 516	com/tencent/mm/protocal/protobuf/fhg:aaFa	Lcom/tencent/mm/protocal/protobuf/fns;
    //   190: iconst_0
    //   191: putfield 267	com/tencent/mm/protocal/protobuf/fns:cHb	I
    //   194: ldc_w 486
    //   197: ldc_w 518
    //   200: iconst_1
    //   201: anewarray 4	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: aload 6
    //   208: aastore
    //   209: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: aload 7
    //   214: getfield 516	com/tencent/mm/protocal/protobuf/fhg:aaFa	Lcom/tencent/mm/protocal/protobuf/fns;
    //   217: lload 4
    //   219: putfield 210	com/tencent/mm/protocal/protobuf/fns:timestamp	J
    //   222: aload_2
    //   223: ifnull +73 -> 296
    //   226: aload_2
    //   227: invokevirtual 522	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   230: astore 9
    //   232: aload 9
    //   234: ifnull +53 -> 287
    //   237: aload 7
    //   239: aload 9
    //   241: ldc_w 524
    //   244: invokevirtual 530	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   247: putfield 533	com/tencent/mm/protocal/protobuf/fhg:aajm	Ljava/lang/String;
    //   250: aload 9
    //   252: ldc_w 535
    //   255: iconst_m1
    //   256: invokevirtual 539	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   259: istore_3
    //   260: aload 9
    //   262: ldc_w 541
    //   265: aconst_null
    //   266: invokevirtual 544	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   269: astore 9
    //   271: aload 7
    //   273: iload_3
    //   274: invokestatic 547	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   277: putfield 550	com/tencent/mm/protocal/protobuf/fhg:aaFb	Ljava/lang/String;
    //   280: aload 7
    //   282: aload 9
    //   284: putfield 553	com/tencent/mm/protocal/protobuf/fhg:aaFc	Ljava/lang/String;
    //   287: aload 7
    //   289: aload_2
    //   290: invokevirtual 556	android/content/Intent:getFlags	()I
    //   293: putfield 559	com/tencent/mm/protocal/protobuf/fhg:flags	I
    //   296: invokestatic 236	com/tencent/mm/plugin/expt/hellhound/ext/session/b:dLx	()Lcom/tencent/mm/plugin/expt/hellhound/ext/session/b;
    //   299: astore 9
    //   301: aload_1
    //   302: invokestatic 152	com/tencent/mm/plugin/expt/hellhound/core/b:aqC	(Ljava/lang/String;)Z
    //   305: ifeq +300 -> 605
    //   308: aload_1
    //   309: invokestatic 565	com/tencent/mm/plugin/expt/hellhound/core/b/b/h:arq	(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    //   312: astore 10
    //   314: aload 10
    //   316: ifnonnull +277 -> 593
    //   319: aload_1
    //   320: invokestatic 568	com/tencent/mm/plugin/expt/hellhound/core/b:aqW	(Ljava/lang/String;)Z
    //   323: ifeq +627 -> 950
    //   326: aload_1
    //   327: aload 6
    //   329: invokestatic 573	com/tencent/mm/plugin/expt/hellhound/ext/session/config/b:hr	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   332: astore_1
    //   333: aload 9
    //   335: new 575	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 576	java/lang/StringBuilder:<init>	()V
    //   342: aload_1
    //   343: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: ldc_w 582
    //   349: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: lload 4
    //   354: invokevirtual 585	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   357: invokevirtual 588	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: putfield 591	com/tencent/mm/plugin/expt/hellhound/ext/session/b:zKp	Ljava/lang/String;
    //   363: ldc_w 593
    //   366: ldc_w 595
    //   369: iconst_1
    //   370: anewarray 4	java/lang/Object
    //   373: dup
    //   374: iconst_0
    //   375: aload 9
    //   377: getfield 591	com/tencent/mm/plugin/expt/hellhound/ext/session/b:zKp	Ljava/lang/String;
    //   380: aastore
    //   381: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   384: aload 7
    //   386: lload 4
    //   388: putfield 596	com/tencent/mm/protocal/protobuf/fhg:timestamp	J
    //   391: aload 7
    //   393: getfield 516	com/tencent/mm/protocal/protobuf/fhg:aaFa	Lcom/tencent/mm/protocal/protobuf/fns;
    //   396: getfield 175	com/tencent/mm/protocal/protobuf/fns:AtM	Ljava/lang/String;
    //   399: astore_1
    //   400: iconst_4
    //   401: putstatic 599	com/tencent/mm/plugin/expt/hellhound/ext/b/b/c:zGP	I
    //   404: aload_1
    //   405: putstatic 602	com/tencent/mm/plugin/expt/hellhound/ext/b/b/c:zGQ	Ljava/lang/String;
    //   408: aload_1
    //   409: aload_2
    //   410: invokestatic 605	com/tencent/mm/plugin/expt/hellhound/ext/b/b/c:e	(Ljava/lang/String;Landroid/content/Intent;)V
    //   413: aload_1
    //   414: invokestatic 466	com/tencent/mm/plugin/expt/hellhound/ext/b/b/k:arT	(Ljava/lang/String;)V
    //   417: aload_1
    //   418: invokestatic 608	com/tencent/mm/plugin/expt/hellhound/ext/b/b/k:arR	(Ljava/lang/String;)V
    //   421: aload_1
    //   422: invokestatic 611	com/tencent/mm/plugin/expt/hellhound/ext/b/b/k:arW	(Ljava/lang/String;)V
    //   425: aload_1
    //   426: invokestatic 614	com/tencent/mm/plugin/expt/hellhound/a:aqx	(Ljava/lang/String;)V
    //   429: invokestatic 226	com/tencent/mm/plugin/expt/hellhound/core/a/a/c:dJd	()Lcom/tencent/mm/plugin/expt/hellhound/core/a/a/c;
    //   432: bipush 100
    //   434: aload 7
    //   436: invokevirtual 230	com/tencent/mm/plugin/expt/hellhound/core/a/a/c:I	(ILjava/lang/Object;)V
    //   439: aload 7
    //   441: getfield 516	com/tencent/mm/protocal/protobuf/fhg:aaFa	Lcom/tencent/mm/protocal/protobuf/fns;
    //   444: getfield 175	com/tencent/mm/protocal/protobuf/fns:AtM	Ljava/lang/String;
    //   447: iconst_m1
    //   448: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   451: iconst_0
    //   452: invokestatic 244	com/tencent/mm/plugin/expt/hellhound/ext/b/a:a	(Ljava/lang/String;Ljava/lang/Integer;I)V
    //   455: aload_2
    //   456: ifnull +37 -> 493
    //   459: aload_2
    //   460: invokevirtual 508	android/content/Intent:getComponent	()Landroid/content/ComponentName;
    //   463: ifnull +30 -> 493
    //   466: new 616	com/tencent/mm/autogen/a/zo
    //   469: dup
    //   470: invokespecial 617	com/tencent/mm/autogen/a/zo:<init>	()V
    //   473: astore_1
    //   474: aload_1
    //   475: getfield 621	com/tencent/mm/autogen/a/zo:icK	Lcom/tencent/mm/autogen/a/zo$a;
    //   478: aload_2
    //   479: invokevirtual 508	android/content/Intent:getComponent	()Landroid/content/ComponentName;
    //   482: invokevirtual 513	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   485: putfield 626	com/tencent/mm/autogen/a/zo$a:icL	Ljava/lang/String;
    //   488: aload_1
    //   489: invokevirtual 629	com/tencent/mm/autogen/a/zo:publish	()Z
    //   492: pop
    //   493: aload_2
    //   494: invokevirtual 508	android/content/Intent:getComponent	()Landroid/content/ComponentName;
    //   497: astore_2
    //   498: aload 8
    //   500: astore_1
    //   501: aload_2
    //   502: ifnull +8 -> 510
    //   505: aload_2
    //   506: invokevirtual 513	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   509: astore_1
    //   510: aload_1
    //   511: invokestatic 634	org/apache/commons/c/i:hm	(Ljava/lang/String;)Z
    //   514: ifne +417 -> 931
    //   517: aload_0
    //   518: getfield 35	com/tencent/mm/plugin/expt/hellhound/core/b/a/b:zBA	Ljava/util/List;
    //   521: invokeinterface 250 1 0
    //   526: astore_1
    //   527: aload_1
    //   528: invokeinterface 255 1 0
    //   533: ifeq +398 -> 931
    //   536: aload_1
    //   537: invokeinterface 259 1 0
    //   542: checkcast 261	com/tencent/mm/plugin/expt/b/e$d
    //   545: invokeinterface 637 1 0
    //   550: goto -23 -> 527
    //   553: invokestatic 69	com/tencent/mm/plugin/expt/hellhound/core/stack/d:dJg	()Lcom/tencent/mm/plugin/expt/hellhound/core/stack/d;
    //   556: pop
    //   557: invokestatic 163	com/tencent/mm/plugin/expt/hellhound/core/stack/e:dJl	()Lcom/tencent/mm/protocal/protobuf/bt;
    //   560: astore_1
    //   561: aload_1
    //   562: ifnull +401 -> 963
    //   565: aload_1
    //   566: getfield 169	com/tencent/mm/protocal/protobuf/bt:YDs	Lcom/tencent/mm/protocal/protobuf/fns;
    //   569: getfield 175	com/tencent/mm/protocal/protobuf/fns:AtM	Ljava/lang/String;
    //   572: astore_1
    //   573: ldc_w 486
    //   576: ldc_w 639
    //   579: iconst_1
    //   580: anewarray 4	java/lang/Object
    //   583: dup
    //   584: iconst_0
    //   585: aload_1
    //   586: aastore
    //   587: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   590: goto -468 -> 122
    //   593: aload 10
    //   595: invokevirtual 114	java/lang/Object:getClass	()Ljava/lang/Class;
    //   598: invokevirtual 120	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   601: astore_1
    //   602: goto -283 -> 319
    //   605: aload_1
    //   606: invokestatic 568	com/tencent/mm/plugin/expt/hellhound/core/b:aqW	(Ljava/lang/String;)Z
    //   609: ifeq -225 -> 384
    //   612: aload_1
    //   613: aload 6
    //   615: invokestatic 573	com/tencent/mm/plugin/expt/hellhound/ext/session/config/b:hr	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   618: astore_1
    //   619: goto -286 -> 333
    //   622: astore_1
    //   623: ldc_w 486
    //   626: ldc_w 641
    //   629: iconst_1
    //   630: anewarray 4	java/lang/Object
    //   633: dup
    //   634: iconst_0
    //   635: aload_1
    //   636: aastore
    //   637: invokestatic 643	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   640: goto -147 -> 493
    //   643: aload_1
    //   644: ifnull +214 -> 858
    //   647: aload_1
    //   648: invokevirtual 114	java/lang/Object:getClass	()Ljava/lang/Class;
    //   651: invokevirtual 120	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   654: astore 6
    //   656: ldc 87
    //   658: ldc_w 645
    //   661: iconst_1
    //   662: anewarray 4	java/lang/Object
    //   665: dup
    //   666: iconst_0
    //   667: aload 6
    //   669: aastore
    //   670: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   673: invokestatic 651	com/tencent/mm/plugin/expt/hellhound/core/b/a/a/c:dJs	()Lcom/tencent/mm/plugin/expt/hellhound/core/b/a/a/c;
    //   676: getfield 655	com/tencent/mm/plugin/expt/hellhound/core/b/a/a/c:zBL	Lcom/tencent/mm/plugin/expt/hellhound/core/b/a/a/a;
    //   679: aload_1
    //   680: invokevirtual 660	com/tencent/mm/plugin/expt/hellhound/core/b/a/a/a:aj	(Landroid/app/Activity;)V
    //   683: aload 6
    //   685: aconst_null
    //   686: bipush 100
    //   688: invokestatic 195	com/tencent/mm/plugin/expt/hellhound/core/b/a/a/e:Y	(Ljava/lang/String;Ljava/lang/String;I)V
    //   691: aload_2
    //   692: invokevirtual 508	android/content/Intent:getComponent	()Landroid/content/ComponentName;
    //   695: astore 7
    //   697: aload 7
    //   699: ifnull +239 -> 938
    //   702: aload 7
    //   704: invokevirtual 513	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   707: astore 7
    //   709: ldc 87
    //   711: ldc_w 662
    //   714: iconst_1
    //   715: anewarray 4	java/lang/Object
    //   718: dup
    //   719: iconst_0
    //   720: aload 7
    //   722: aastore
    //   723: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   726: aload 7
    //   728: aconst_null
    //   729: bipush 101
    //   731: invokestatic 195	com/tencent/mm/plugin/expt/hellhound/core/b/a/a/e:Y	(Ljava/lang/String;Ljava/lang/String;I)V
    //   734: aload_2
    //   735: invokevirtual 522	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   738: astore 9
    //   740: aload 9
    //   742: ifnull +89 -> 831
    //   745: aload 9
    //   747: ldc_w 524
    //   750: invokevirtual 530	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   753: astore 10
    //   755: aload 10
    //   757: invokestatic 286	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   760: ifne +11 -> 771
    //   763: ldc_w 524
    //   766: aload 10
    //   768: invokestatic 667	com/tencent/mm/plugin/expt/hellhound/core/b/a/a/b:hj	(Ljava/lang/String;Ljava/lang/String;)V
    //   771: aload 9
    //   773: ldc_w 535
    //   776: iconst_m1
    //   777: invokevirtual 539	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   780: istore_3
    //   781: aload 9
    //   783: ldc_w 541
    //   786: aconst_null
    //   787: invokevirtual 544	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   790: astore 9
    //   792: iload_3
    //   793: iconst_1
    //   794: if_icmpne +116 -> 910
    //   797: aload 9
    //   799: ifnull +111 -> 910
    //   802: ldc_w 669
    //   805: aload 9
    //   807: invokevirtual 672	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   810: ifeq +100 -> 910
    //   813: ldc_w 535
    //   816: iload_3
    //   817: invokestatic 547	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   820: invokestatic 667	com/tencent/mm/plugin/expt/hellhound/core/b/a/a/b:hj	(Ljava/lang/String;Ljava/lang/String;)V
    //   823: ldc_w 541
    //   826: aload 9
    //   828: invokestatic 667	com/tencent/mm/plugin/expt/hellhound/core/b/a/a/b:hj	(Ljava/lang/String;Ljava/lang/String;)V
    //   831: aload_1
    //   832: aload_2
    //   833: aload 6
    //   835: aload 7
    //   837: iconst_0
    //   838: invokestatic 196	com/tencent/mm/plugin/expt/hellhound/core/b/a/b:a	(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;I)V
    //   841: aload 7
    //   843: invokestatic 675	com/tencent/mm/plugin/expt/hellhound/core/b/a/a:arh	(Ljava/lang/String;)V
    //   846: aload 6
    //   848: invokestatic 678	com/tencent/mm/plugin/expt/hellhound/core/b/a/a:arj	(Ljava/lang/String;)V
    //   851: iconst_0
    //   852: invokestatic 146	com/tencent/mm/plugin/expt/hellhound/core/b/a/a:LA	(I)V
    //   855: goto -362 -> 493
    //   858: invokestatic 69	com/tencent/mm/plugin/expt/hellhound/core/stack/d:dJg	()Lcom/tencent/mm/plugin/expt/hellhound/core/stack/d;
    //   861: pop
    //   862: invokestatic 163	com/tencent/mm/plugin/expt/hellhound/core/stack/e:dJl	()Lcom/tencent/mm/protocal/protobuf/bt;
    //   865: astore 6
    //   867: aload 6
    //   869: ifnull +75 -> 944
    //   872: aload 6
    //   874: getfield 169	com/tencent/mm/protocal/protobuf/bt:YDs	Lcom/tencent/mm/protocal/protobuf/fns;
    //   877: getfield 175	com/tencent/mm/protocal/protobuf/fns:AtM	Ljava/lang/String;
    //   880: astore 6
    //   882: ldc 87
    //   884: ldc_w 680
    //   887: iconst_1
    //   888: anewarray 4	java/lang/Object
    //   891: dup
    //   892: iconst_0
    //   893: aload 6
    //   895: aastore
    //   896: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   899: invokestatic 651	com/tencent/mm/plugin/expt/hellhound/core/b/a/a/c:dJs	()Lcom/tencent/mm/plugin/expt/hellhound/core/b/a/a/c;
    //   902: aload 6
    //   904: invokevirtual 683	com/tencent/mm/plugin/expt/hellhound/core/b/a/a/c:arn	(Ljava/lang/String;)V
    //   907: goto -224 -> 683
    //   910: ldc_w 535
    //   913: ldc_w 685
    //   916: invokestatic 667	com/tencent/mm/plugin/expt/hellhound/core/b/a/a/b:hj	(Ljava/lang/String;Ljava/lang/String;)V
    //   919: ldc_w 541
    //   922: ldc_w 685
    //   925: invokestatic 667	com/tencent/mm/plugin/expt/hellhound/core/b/a/a/b:hj	(Ljava/lang/String;Ljava/lang/String;)V
    //   928: goto -97 -> 831
    //   931: ldc_w 478
    //   934: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   937: return
    //   938: aconst_null
    //   939: astore 7
    //   941: goto -232 -> 709
    //   944: aconst_null
    //   945: astore 6
    //   947: goto -264 -> 683
    //   950: ldc_w 687
    //   953: astore_1
    //   954: goto -621 -> 333
    //   957: aconst_null
    //   958: astore 6
    //   960: goto -797 -> 163
    //   963: aconst_null
    //   964: astore_1
    //   965: goto -843 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	968	0	this	b
    //   0	968	1	paramActivity	Activity
    //   0	968	2	paramIntent	Intent
    //   259	558	3	i	int
    //   19	368	4	l	long
    //   53	906	6	localObject1	Object
    //   28	912	7	localObject2	Object
    //   1	498	8	localObject3	Object
    //   230	597	9	localObject4	Object
    //   312	455	10	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   459	493	622	finally
  }
  
  public final void o(Application paramApplication)
  {
    AppMethodBeat.i(121920);
    if (paramApplication == null)
    {
      AppMethodBeat.o(121920);
      return;
    }
    if (!com.tencent.mm.plugin.expt.hellhound.a.dIK())
    {
      AppMethodBeat.o(121920);
      return;
    }
    paramApplication = this.zBB;
    com.tencent.mm.hellhoundlib.a.aYh().mxj = paramApplication.zBH;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair("startActivity", "(Landroid/content/Intent;)V"));
    localArrayList.add(new Pair("startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V"));
    localArrayList.add(new Pair("startActivities", "([Landroid/content/Intent;)V"));
    localArrayList.add(new Pair("startActivities", "([Landroid/content/Intent;Landroid/os/Bundle;)V"));
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a(localArrayList, paramApplication.zBI);
    AppMethodBeat.o(121920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.b
 * JD-Core Version:    0.7.0.1
 */