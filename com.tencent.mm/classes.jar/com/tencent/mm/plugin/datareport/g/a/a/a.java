package com.tencent.mm.plugin.datareport.g.a.a;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.expt.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.c.i;

public class a
  extends com.tencent.mm.plugin.datareport.g.a.a
  implements d<Bundle, IPCVoid>, com.tencent.mm.plugin.datareport.g.b
{
  private static Integer xhu = null;
  private boolean xhA;
  private com.tencent.mm.plugin.datareport.g.b.a xhB;
  private List<com.tencent.mm.vending.j.c<com.tencent.mm.plugin.datareport.f.c, Integer>> xhC;
  private MMHandler xhD;
  q.a xhE;
  private int xht;
  private List<String> xhv;
  private List<String> xhw;
  private MultiProcessMMKV xhx;
  private b xhy;
  private com.tencent.mm.plugin.datareport.f.c xhz;
  
  public a()
  {
    AppMethodBeat.i(262960);
    this.xht = 0;
    this.xhv = null;
    this.xhw = null;
    this.xhx = MultiProcessMMKV.getMMKV("page_event_monitor");
    this.xhy = new b();
    this.xhz = null;
    this.xhA = false;
    this.xhC = new ArrayList();
    this.xhD = com.tencent.mm.plugin.datareport.j.c.a(new a..ExternalSyntheticLambda0(this));
    this.xhE = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(262959);
        if ((!com.tencent.mm.plugin.datareport.a.dtn().dto()) || (a.a(a.this) != 0))
        {
          AppMethodBeat.o(262959);
          return;
        }
        Log.i("PageEventMonitor", "[onAppBackground]");
        paramAnonymousString = a.b(a.this).obtainMessage(1002);
        paramAnonymousString.obj = Long.valueOf(System.currentTimeMillis());
        a.b(a.this).sendMessage(paramAnonymousString);
        AppMethodBeat.o(262959);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(262953);
        if ((!com.tencent.mm.plugin.datareport.a.dtn().dto()) || (a.a(a.this) != 0))
        {
          AppMethodBeat.o(262953);
          return;
        }
        Log.i("PageEventMonitor", "[onAppForeground]");
        paramAnonymousString = a.b(a.this).obtainMessage(1001);
        paramAnonymousString.obj = Long.valueOf(System.currentTimeMillis());
        a.b(a.this).sendMessage(paramAnonymousString);
        AppMethodBeat.o(262953);
      }
    };
    AppMethodBeat.o(262960);
  }
  
  private void a(int paramInt, com.tencent.mm.plugin.datareport.f.c paramc, long paramLong)
  {
    AppMethodBeat.i(262974);
    if ((!com.tencent.mm.plugin.datareport.a.dtn().dto()) || (paramc == null) || (this.xhB == null))
    {
      AppMethodBeat.o(262974);
      return;
    }
    Log.i("PageEventMonitor", "[triggerFragmentEvent] eventType " + paramInt + ", page : " + paramc);
    if ((paramc != null) && (i.qA(paramc.xhn, "com.tencent.mm.ui.chatting.ChattingUIFragment"))) {}
    for (int i = 1; (i != 0) || (d(paramc)); i = 0)
    {
      if (paramInt != 0) {
        break label226;
      }
      a(paramc, paramLong);
      AppMethodBeat.o(262974);
      return;
    }
    if (!c(paramc)) {
      if (this.xhA)
      {
        if (paramInt == 0)
        {
          this.xhB.a(paramc, paramLong, true);
          AppMethodBeat.o(262974);
          return;
        }
        if (paramInt == 1)
        {
          this.xhB.b(paramc, paramLong, true);
          AppMethodBeat.o(262974);
        }
      }
      else
      {
        if (paramInt == 0)
        {
          this.xhC.add(com.tencent.mm.vending.j.c.U(paramc, Integer.valueOf(0)));
          AppMethodBeat.o(262974);
          return;
        }
        if (paramInt == 1) {
          this.xhC.add(com.tencent.mm.vending.j.c.U(paramc, Integer.valueOf(1)));
        }
      }
    }
    label226:
    AppMethodBeat.o(262974);
  }
  
  private void a(com.tencent.mm.plugin.datareport.f.c paramc, long paramLong)
  {
    AppMethodBeat.i(262996);
    if ((paramc == null) || (this.xhB == null))
    {
      AppMethodBeat.o(262996);
      return;
    }
    if (c(paramc))
    {
      AppMethodBeat.o(262996);
      return;
    }
    Object localObject1 = this.xhy.dtK();
    if ((localObject1 != null) && (((com.tencent.mm.plugin.datareport.f.c)localObject1).b(paramc)))
    {
      Log.e("PageEventMonitor", "[pageResume] same page, page : %s, lastPage : %s", new Object[] { paramc, localObject1 });
      AppMethodBeat.o(262996);
      return;
    }
    if (!this.xhA)
    {
      this.xhC.add(com.tencent.mm.vending.j.c.U(paramc, Integer.valueOf(2)));
      Log.e("PageEventMonitor", "[pageResume] now is background, page : %s", new Object[] { paramc });
      AppMethodBeat.o(262996);
      return;
    }
    boolean bool1;
    if (MMApplicationContext.isMainProcess()) {
      if (localObject1 != null)
      {
        long l = this.xhx.getLong("multi_process_session_in_time", 0L);
        bool1 = this.xhx.getBoolean("multi_process_session_is_call_in", false);
        if ((l > 0L) && (!bool1)) {
          this.xhB.b((com.tencent.mm.plugin.datareport.f.c)localObject1, l, false);
        }
        this.xhx.putBoolean("multi_process_session_is_call_in", false);
        this.xhx.putLong("multi_process_session_in_time", 0L);
        l = this.xhx.getLong("multi_process_session_out_time", 0L);
        if (l > 0L)
        {
          this.xhB.a((com.tencent.mm.plugin.datareport.f.c)localObject1, l, false);
          this.xhx.putLong("multi_process_session_out_time", 0L);
        }
      }
    }
    Object localObject2;
    com.tencent.mm.plugin.datareport.f.c localc;
    for (;;)
    {
      Log.i("PageEventMonitor", "[pageResume] page : %s, time : %d", new Object[] { paramc, Long.valueOf(paramLong) });
      if (localObject1 != null)
      {
        this.xhB.b((com.tencent.mm.plugin.datareport.f.c)localObject1, paramLong, false);
        if ((d(paramc)) && (d((com.tencent.mm.plugin.datareport.f.c)localObject1)))
        {
          this.xhy.dtM();
          this.xhB.c((com.tencent.mm.plugin.datareport.f.c)localObject1, paramLong);
        }
      }
      bool1 = this.xhy.g(paramc);
      boolean bool2 = d(paramc);
      localObject1 = new ArrayList();
      localObject2 = this.xhy.dtL();
      if ((!bool2) || ((bool1) && (paramc.b((com.tencent.mm.plugin.datareport.f.c)localObject2)))) {
        break label627;
      }
      localObject2 = this.xhy.dtN();
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localc = (com.tencent.mm.plugin.datareport.f.c)((Iterator)localObject2).next();
        this.xhB.c(localc, paramLong);
        if ((localc.xhp != -1) && (localc.xhp > dtJ())) {
          ((List)localObject1).add(localc);
        }
      }
      this.xhx.putBoolean("multi_process_session_is_call_in", false);
      this.xhx.putLong("multi_process_session_in_time", 0L);
      this.xhx.putLong("multi_process_session_out_time", 0L);
      continue;
      if (this.xhx.getLong("multi_process_session_in_time", 0L) <= 0L) {
        this.xhx.putLong("multi_process_session_in_time", paramLong);
      }
    }
    this.xhB.b(paramc, paramLong);
    this.xhB.a(paramc, paramLong, false);
    this.xhy.e(paramc);
    for (;;)
    {
      if (((List)localObject1).size() > 0)
      {
        paramc = this.xhD.obtainMessage(1006);
        paramc.obj = localObject1;
        this.xhD.sendMessage(paramc);
      }
      AppMethodBeat.o(262996);
      return;
      label627:
      if (bool1)
      {
        localObject2 = this.xhy.h(paramc);
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localc = (com.tencent.mm.plugin.datareport.f.c)((Iterator)localObject2).next();
            this.xhB.c(localc, paramLong);
            if ((localc.xhp != -1) && (localc.xhp > dtJ())) {
              ((List)localObject1).add(localc);
            }
          }
        }
        this.xhB.a(paramc, paramLong, false);
      }
      else
      {
        this.xhB.b(paramc, paramLong);
        this.xhB.a(paramc, paramLong, false);
        this.xhy.e(paramc);
      }
    }
  }
  
  private boolean c(com.tencent.mm.plugin.datareport.f.c paramc)
  {
    AppMethodBeat.i(263013);
    if (paramc == null)
    {
      AppMethodBeat.o(263013);
      return false;
    }
    if (this.xhv == null)
    {
      this.xhv = new ArrayList();
      localObject1 = com.tencent.mm.plugin.expt.model.a.dMQ().b(c.a.zqm, "sFinderMultiTaskRouterUI|ccom.tencent.mm.ui.LauncherUI");
      if (!i.hm((String)localObject1))
      {
        localObject1 = ((String)localObject1).split("\\|");
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          localObject2 = localObject1[i];
          if (!this.xhv.contains(localObject2)) {
            this.xhv.add(localObject2);
          }
          i += 1;
        }
      }
    }
    Object localObject1 = "s" + paramc.xhm;
    paramc = "c" + paramc.xhn;
    Object localObject2 = this.xhv.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if ((i.qA(str, (String)localObject1)) || (i.qA(str, paramc)))
      {
        AppMethodBeat.o(263013);
        return true;
      }
    }
    AppMethodBeat.o(263013);
    return false;
  }
  
  private boolean d(com.tencent.mm.plugin.datareport.f.c paramc)
  {
    AppMethodBeat.i(263020);
    Object localObject2;
    if (this.xhw == null)
    {
      this.xhw = new ArrayList();
      localObject1 = com.tencent.mm.plugin.expt.model.a.dMQ().b(c.a.zqn, "MainUI|MvvmAddressUIFragment|FindMoreFriendsUI|MoreTabUI");
      if (!i.hm((String)localObject1))
      {
        localObject1 = ((String)localObject1).split("\\|");
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          localObject2 = localObject1[i];
          if (!this.xhw.contains(localObject2)) {
            this.xhw.add(localObject2);
          }
          i += 1;
        }
      }
    }
    Object localObject1 = this.xhw.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (i.qA(paramc.xhm, (String)localObject2))
      {
        AppMethodBeat.o(263020);
        return true;
      }
    }
    AppMethodBeat.o(263020);
    return false;
  }
  
  private static int dtJ()
  {
    AppMethodBeat.i(263002);
    if (xhu == null) {
      xhu = Integer.valueOf(com.tencent.mm.plugin.expt.model.a.dMQ().a(c.a.zqp, 1));
    }
    int i = xhu.intValue();
    AppMethodBeat.o(263002);
    return i;
  }
  
  public final void Jv(int paramInt)
  {
    AppMethodBeat.i(263119);
    if ((!com.tencent.mm.plugin.datareport.a.dtn().dto()) || (paramInt == 0))
    {
      AppMethodBeat.o(263119);
      return;
    }
    Log.i("PageEventMonitor", "[onHellFragmentPause] hashcode : ".concat(String.valueOf(paramInt)));
    Message localMessage = this.xhD.obtainMessage(1005);
    localMessage.obj = com.tencent.mm.vending.j.a.g(Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()));
    this.xhD.sendMessage(localMessage);
    AppMethodBeat.o(263119);
  }
  
  public final void V(Activity paramActivity)
  {
    AppMethodBeat.i(263145);
    if ((!com.tencent.mm.plugin.datareport.a.dtn().dto()) || (paramActivity == null))
    {
      AppMethodBeat.o(263145);
      return;
    }
    com.tencent.mm.plugin.datareport.f.c localc = new com.tencent.mm.plugin.datareport.f.c(paramActivity);
    Log.i("PageEventMonitor", "[onHellActivityDestroy] page : ".concat(String.valueOf(localc)));
    Object localObject = this.xhD.obtainMessage(1004);
    ((Message)localObject).obj = com.tencent.mm.vending.j.a.U(localc, Long.valueOf(System.currentTimeMillis()));
    this.xhD.sendMessage((Message)localObject);
    localObject = new ArrayList();
    ((List)localObject).add(localc);
    if ((paramActivity instanceof FragmentActivity))
    {
      paramActivity = ((FragmentActivity)paramActivity).getSupportFragmentManager();
      if (paramActivity != null)
      {
        paramActivity = paramActivity.getFragments();
        if ((paramActivity != null) && (paramActivity.size() > 0))
        {
          paramActivity = paramActivity.iterator();
          while (paramActivity.hasNext()) {
            ((List)localObject).add(new com.tencent.mm.plugin.datareport.f.c((Fragment)paramActivity.next()));
          }
        }
      }
    }
    paramActivity = this.xhD.obtainMessage(1006);
    paramActivity.obj = localObject;
    this.xhD.sendMessage(paramActivity);
    AppMethodBeat.o(263145);
  }
  
  public final void W(Activity paramActivity)
  {
    AppMethodBeat.i(263133);
    if ((!com.tencent.mm.plugin.datareport.a.dtn().dto()) || (paramActivity == null))
    {
      AppMethodBeat.o(263133);
      return;
    }
    paramActivity = new com.tencent.mm.plugin.datareport.f.c(paramActivity);
    Log.i("PageEventMonitor", "[onHellActivityResumed] page : ".concat(String.valueOf(paramActivity)));
    Message localMessage = this.xhD.obtainMessage(1003);
    localMessage.obj = com.tencent.mm.vending.j.a.U(paramActivity, Long.valueOf(System.currentTimeMillis()));
    this.xhD.sendMessage(localMessage);
    AppMethodBeat.o(263133);
  }
  
  public final void a(com.tencent.mm.plugin.datareport.g.b.a parama)
  {
    if (parama == null) {
      return;
    }
    this.xhB = parama;
  }
  
  public final void eV(Object paramObject)
  {
    AppMethodBeat.i(263110);
    if ((!com.tencent.mm.plugin.datareport.a.dtn().dto()) || (paramObject == null))
    {
      AppMethodBeat.o(263110);
      return;
    }
    Log.i("PageEventMonitor", "[onHellFragmentResume] fragmentObj : " + paramObject.getClass().getSimpleName() + ", hashcode : " + paramObject.hashCode());
    Message localMessage = this.xhD.obtainMessage(1005);
    localMessage.obj = com.tencent.mm.vending.j.a.g(paramObject, Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
    this.xhD.sendMessage(localMessage);
    AppMethodBeat.o(263110);
  }
  
  public final void eW(Object paramObject)
  {
    AppMethodBeat.i(263124);
    if ((!com.tencent.mm.plugin.datareport.a.dtn().dto()) || (paramObject == null))
    {
      AppMethodBeat.o(263124);
      return;
    }
    Object localObject = new com.tencent.mm.plugin.datareport.f.c(paramObject);
    Log.i("PageEventMonitor", "[onHellChatFragmentFinish] page : ".concat(String.valueOf(localObject)));
    paramObject = new ArrayList();
    paramObject.add(localObject);
    localObject = this.xhD.obtainMessage(1006);
    ((Message)localObject).obj = paramObject;
    this.xhD.sendMessage((Message)localObject);
    AppMethodBeat.o(263124);
  }
  
  public final void kL(long paramLong)
  {
    AppMethodBeat.i(263091);
    if (!com.tencent.mm.plugin.datareport.a.dtn().dto())
    {
      AppMethodBeat.o(263091);
      return;
    }
    Log.i("PageEventMonitor", "[onHellBackToFront] timestamp : ".concat(String.valueOf(paramLong)));
    Object localObject;
    if (this.xht == 3)
    {
      if (!MMApplicationContext.isMainProcess())
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("type", 0);
        ((Bundle)localObject).putLong("timestamp", paramLong);
        j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject, a.class, null);
      }
      localObject = this.xhD.obtainMessage(1001);
      ((Message)localObject).obj = Long.valueOf(paramLong);
      this.xhD.sendMessage((Message)localObject);
      AppMethodBeat.o(263091);
      return;
    }
    if (this.xht == 1)
    {
      localObject = this.xhD.obtainMessage(1001);
      ((Message)localObject).obj = Long.valueOf(paramLong);
      this.xhD.sendMessage((Message)localObject);
    }
    AppMethodBeat.o(263091);
  }
  
  public final void kM(long paramLong)
  {
    AppMethodBeat.i(263101);
    if (!com.tencent.mm.plugin.datareport.a.dtn().dto())
    {
      AppMethodBeat.o(263101);
      return;
    }
    Log.i("PageEventMonitor", "[onHellFrontToBack] timestamp : ".concat(String.valueOf(paramLong)));
    Object localObject;
    if (this.xht == 3)
    {
      if (!MMApplicationContext.isMainProcess())
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("type", 1);
        ((Bundle)localObject).putLong("timestamp", paramLong);
        j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject, a.class, null);
      }
      localObject = this.xhD.obtainMessage(1002);
      ((Message)localObject).obj = Long.valueOf(paramLong);
      this.xhD.sendMessage((Message)localObject);
      AppMethodBeat.o(263101);
      return;
    }
    if (this.xht == 1)
    {
      localObject = this.xhD.obtainMessage(1002);
      ((Message)localObject).obj = Long.valueOf(paramLong);
      this.xhD.sendMessage((Message)localObject);
    }
    AppMethodBeat.o(263101);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(263077);
    Log.i("PageEventMonitor", "[startMonitor]");
    e locale = (e)h.ax(e.class);
    if (locale != null) {
      locale.a(this);
    }
    this.xhE.alive();
    AppMethodBeat.o(263077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.g.a.a.a
 * JD-Core Version:    0.7.0.1
 */