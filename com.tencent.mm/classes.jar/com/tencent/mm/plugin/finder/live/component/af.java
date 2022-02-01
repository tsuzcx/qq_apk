package com.tencent.mm.plugin.finder.live.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.cgi.e.a;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.cgi.x;
import com.tencent.mm.plugin.finder.live.model.cgi.x.a;
import com.tencent.mm.plugin.finder.live.model.cgi.y;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.protocal.protobuf.bgj;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreatePresenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "config", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateConfig;", "desc", "duration", "", "durationValid", "", "liveId", "", "lotteryType", "nonceId", "objectId", "scope", "Lkotlinx/coroutines/CoroutineScope;", "showAttendTypeCompatibility", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;)V", "winnerCnt", "winnerNumberValid", "wording", "addLotteryRecordEntrance", "", "checkLotteryState", "type", "createLottery", "getLotteryDuration", "getLotteryType", "Lcom/tencent/mm/plugin/finder/live/component/LotteryCreateItem;", "getLotteryTypeList", "", "getRepeatSwitchState", "getWinnerNumber", "isValidDuration", "isValidWinnerNumber", "isValidWording", "onAttach", "callback", "onDetach", "setLotteryDesc", "setLotteyDuration", "setLotteyType", "setLotteyWording", "setRepeatSwitch", "repeat", "setWinnerNumber", "cnt", "tryNotifyAnchorAttendCompatibility", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class af
  implements ae.a
{
  public static final af.a Czj;
  private static final int Czr;
  private final boolean Czk;
  ae.b Czl;
  private int Czm;
  private int Czn;
  private boolean Czo;
  private boolean Czp;
  private ad Czq;
  final String TAG;
  private final Activity activity;
  private String desc;
  private int duration;
  private long hKN;
  private long liveId;
  private String nonceId;
  private final aq scope;
  private String wording;
  
  static
  {
    AppMethodBeat.i(353203);
    Czj = new af.a((byte)0);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    Czr = com.tencent.d.a.a.a.a.a.jSU();
    AppMethodBeat.o(353203);
  }
  
  public af(Activity paramActivity)
  {
    AppMethodBeat.i(353086);
    this.activity = paramActivity;
    this.TAG = "FinderLiveLotteryCreatePresenter";
    paramActivity = com.tencent.d.a.a.a.a.a.ahiX;
    boolean bool;
    int i;
    if (((Number)com.tencent.d.a.a.a.a.a.jUl().bmg()).intValue() == 1)
    {
      bool = true;
      this.Czk = bool;
      this.wording = "";
      this.duration = 3;
      this.desc = "";
      this.nonceId = "";
      this.Czq = new ad();
      this.scope = ar.kBZ();
      this.liveId = this.activity.getIntent().getLongExtra("KEY_PARAMS_LIVE_ID", 0L);
      this.hKN = this.activity.getIntent().getLongExtra("KEY_PARAMS_OBJECT_ID", 0L);
      String str = this.activity.getIntent().getStringExtra("KEY_PARAMS_NONCE_ID");
      paramActivity = str;
      if (str == null) {
        paramActivity = "";
      }
      this.nonceId = paramActivity;
      paramActivity = this.Czq.eir();
      if (paramActivity != null) {
        paramActivity.CAZ = true;
      }
      if (paramActivity != null) {
        break label265;
      }
      i = 1;
      label185:
      this.Czm = i;
      paramActivity = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      paramActivity = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (paramActivity == null) {
        break label273;
      }
      paramActivity = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)paramActivity.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
      if ((paramActivity == null) || (paramActivity.Egs != true)) {
        break label273;
      }
      i = j;
      label226:
      if (i == 0) {
        break label278;
      }
      eiC();
    }
    for (;;)
    {
      Log.i(this.TAG, s.X("showAttendTypeCompatibility: ", Boolean.valueOf(this.Czk)));
      AppMethodBeat.o(353086);
      return;
      bool = false;
      break;
      label265:
      i = paramActivity.type;
      break label185;
      label273:
      i = 0;
      break label226;
      label278:
      kotlinx.coroutines.j.a(this.scope, null, null, (m)new af.1(this, null), 3);
    }
  }
  
  private final void OH(int paramInt)
  {
    AppMethodBeat.i(353100);
    Log.i(this.TAG, s.X("checkLotteryState type:", Integer.valueOf(paramInt)));
    this.Czo = eiz();
    this.Czp = eiA();
    ae.b localb;
    switch (paramInt)
    {
    default: 
      localb = this.Czl;
      if (localb != null) {
        localb.qu(false);
      }
      break;
    }
    do
    {
      do
      {
        AppMethodBeat.o(353100);
        return;
        localb = this.Czl;
        if (localb != null) {
          localb.qu(this.Czo & this.Czp);
        }
        localb = this.Czl;
      } while (localb == null);
      localb.qt(this.Czo);
      AppMethodBeat.o(353100);
      return;
      localb = this.Czl;
      if (localb != null) {
        localb.qu(this.Czo & this.Czp & eiB());
      }
      localb = this.Czl;
    } while (localb == null);
    localb.qt(this.Czo);
    AppMethodBeat.o(353100);
  }
  
  private static final boolean a(af paramaf, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(353155);
    s.u(paramaf, "this$0");
    Intent localIntent = new Intent();
    paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    int i;
    if (paramMenuItem != null)
    {
      paramMenuItem = (e)paramMenuItem.business(e.class);
      if ((paramMenuItem != null) && (paramMenuItem.DUe == true))
      {
        i = 1;
        if (i == 0) {
          break label211;
        }
        i = 3;
        label64:
        localIntent.putExtra("KEY_LOTTERY_HISTORY_SCENE", i);
        localIntent.putExtra("KEY_LOTTERY_HISTORY_LIVE_ID", paramaf.liveId);
        localIntent.putExtra("KEY_LOTTERY_HISTORY_OBJECT_ID", paramaf.hKN);
        localIntent.putExtra("KEY_LOTTERY_HISTORY_OBJECT_NONCE_ID", paramaf.nonceId);
        paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
        paramMenuItem = com.tencent.mm.plugin.finder.live.model.context.a.emY();
        if (paramMenuItem != null) {
          break label216;
        }
        paramMenuItem = null;
      }
    }
    for (;;)
    {
      localIntent.putExtra("KEY_LIVE_ANCHOR_USERNAME", paramMenuItem);
      paramMenuItem = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      s.s(paramMenuItem, "service(IFinderCommonService::class.java)");
      h.a.a((com.tencent.mm.plugin.h)paramMenuItem, (Context)paramaf.activity, localIntent, 0, 124);
      ((com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class)).a((Context)paramaf.activity, localIntent, true);
      com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.h.Dsx, "");
      AppMethodBeat.o(353155);
      return true;
      i = 0;
      break;
      label211:
      i = 1;
      break label64;
      label216:
      paramMenuItem = (e)paramMenuItem.business(e.class);
      if (paramMenuItem == null) {
        paramMenuItem = null;
      } else {
        paramMenuItem = paramMenuItem.mIC;
      }
    }
  }
  
  private final boolean eiA()
  {
    boolean bool = true;
    AppMethodBeat.i(353123);
    int i = this.Czn;
    if (i > 0) {
      if (i <= 2147483647)
      {
        i = 1;
        if (i == 0) {
          break label85;
        }
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "isValidWinnerNumber winnerNumber:" + this.Czn + " valid:" + bool);
      AppMethodBeat.o(353123);
      return bool;
      i = 0;
      break;
      i = 0;
      break;
      label85:
      bool = false;
    }
  }
  
  private final boolean eiB()
  {
    AppMethodBeat.i(353129);
    Log.i(this.TAG, s.X("isValidWording wording:", this.wording));
    if (((CharSequence)this.wording).length() > 0)
    {
      AppMethodBeat.o(353129);
      return true;
    }
    AppMethodBeat.o(353129);
    return false;
  }
  
  private final void eiC()
  {
    AppMethodBeat.i(353139);
    Object localObject = this.activity;
    if ((localObject instanceof MMActivity)) {}
    for (localObject = (MMActivity)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((MMActivity)localObject).addIconOptionMenu(0, p.g.icons_filled_more, new af..ExternalSyntheticLambda0(this));
      }
      AppMethodBeat.o(353139);
      return;
    }
  }
  
  private final boolean eiz()
  {
    boolean bool = true;
    AppMethodBeat.i(353112);
    int i = Czr;
    int j = this.duration;
    if (j > 0) {
      if (j <= i)
      {
        i = 1;
        if (i == 0) {
          break label87;
        }
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "isValidDuration duration:" + this.duration + " valid:" + bool);
      AppMethodBeat.o(353112);
      return bool;
      i = 0;
      break;
      i = 0;
      break;
      label87:
      bool = false;
    }
  }
  
  public final void OF(int paramInt)
  {
    AppMethodBeat.i(353249);
    this.duration = paramInt;
    OH(this.Czm);
    AppMethodBeat.o(353249);
  }
  
  public final void OG(int paramInt)
  {
    AppMethodBeat.i(353254);
    this.Czn = paramInt;
    OH(this.Czm);
    AppMethodBeat.o(353254);
  }
  
  public final void a(at paramat)
  {
    AppMethodBeat.i(353233);
    s.u(paramat, "type");
    ad localad = this.Czq;
    s.u(paramat, "lastType");
    Iterator localIterator = ((Iterable)localad.Czc).iterator();
    if (localIterator.hasNext())
    {
      at localat = (at)localIterator.next();
      if (localat.type == paramat.type) {}
      for (boolean bool = true;; bool = false)
      {
        localat.CAZ = bool;
        break;
      }
    }
    localad.Czf = paramat.type;
    localad.Cze.clear();
    localad.Cze.addAll((Collection)localad.Czc);
    localad.Cze.addAll((Collection)localad.Czd);
    if (paramat.type != 3) {
      this.wording = "";
    }
    this.Czm = paramat.type;
    OH(this.Czm);
    if ((this.Czk) && (this.Czm == 4))
    {
      paramat = this.Czl;
      if (paramat != null) {
        paramat.a(0, MMApplicationContext.getResources().getString(p.h.Cmg), null);
      }
    }
    AppMethodBeat.o(353233);
  }
  
  public final void awp(String paramString)
  {
    AppMethodBeat.i(353242);
    s.u(paramString, "wording");
    this.wording = paramString;
    OH(this.Czm);
    AppMethodBeat.o(353242);
  }
  
  public final void awq(String paramString)
  {
    AppMethodBeat.i(353262);
    s.u(paramString, "desc");
    this.desc = paramString;
    AppMethodBeat.o(353262);
  }
  
  public final List<at> eiu()
  {
    AppMethodBeat.i(353218);
    Object localObject = this.Czq;
    if (((ad)localObject).Cze.isEmpty()) {
      ((ad)localObject).eit();
    }
    localObject = (List)((ad)localObject).Cze;
    AppMethodBeat.o(353218);
    return localObject;
  }
  
  public final at eiv()
  {
    AppMethodBeat.i(353225);
    at localat = this.Czq.eir();
    AppMethodBeat.o(353225);
    return localat;
  }
  
  public final int eiw()
  {
    return this.duration;
  }
  
  public final void eix()
  {
    AppMethodBeat.i(353272);
    w localw = w.a((Context)this.activity, (CharSequence)this.activity.getString(p.h.app_waiting), true, 3, null);
    Object localObject = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    localObject = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    int i;
    label89:
    long l1;
    long l2;
    String str1;
    int j;
    String str2;
    int k;
    String str3;
    int m;
    int n;
    ad localad;
    if (localObject != null)
    {
      localObject = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(e.class);
      if ((localObject != null) && (((e)localObject).DUe == true))
      {
        i = 1;
        if (i == 0) {
          break label279;
        }
        com.tencent.mm.plugin.finder.live.report.k.Doi.Pl(2);
        l1 = this.liveId;
        l2 = this.hKN;
        str1 = this.nonceId;
        j = this.duration;
        str2 = this.desc;
        k = this.Czm;
        str3 = this.wording;
        localObject = x.CJC;
        m = x.emD();
        n = this.Czn;
        localad = this.Czq;
        i = 0;
        localObject = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
        localObject = com.tencent.mm.plugin.finder.live.model.context.a.emY();
        if (localObject != null) {
          break label329;
        }
        localObject = null;
        label171:
        if (localObject != null) {
          break label450;
        }
        if (!((ad)localad).Czg) {
          break label408;
        }
        i |= 0x1;
      }
    }
    label191:
    label450:
    for (;;)
    {
      long l3 = i;
      localObject = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      localObject = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (localObject == null) {
        localObject = null;
      }
      for (;;)
      {
        new x(new y(l1, l2, str1, j, str2, k, str3, m, n, l3, com.tencent.mm.bx.b.cX((byte[])localObject)), (x.a)new b(localw, this)).bFJ();
        AppMethodBeat.o(353272);
        return;
        i = 0;
        break;
        if (this.Czm != 1) {
          break label89;
        }
        if (((CharSequence)this.wording).length() > 0) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label327;
          }
          com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.h.Dsv, this.wording);
          break;
        }
        label327:
        break label89;
        label329:
        localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
        if (localObject == null)
        {
          localObject = null;
          break label171;
        }
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject).Egu;
        if (localObject == null)
        {
          localObject = null;
          break label171;
        }
        if (localad.Czg) {}
        for (i = (int)((diq)localObject).CJK | 0x1;; i = (int)((diq)localObject).CJK & 0xFFFFFFFE)
        {
          localObject = ah.aiuX;
          break;
        }
        i &= 0xFFFFFFFE;
        break label191;
        localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject).mZp;
        }
      }
    }
  }
  
  public final boolean eiy()
  {
    return this.Czq.Czg;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(353293);
    Object localObject1 = this.Czl;
    if (localObject1 != null) {
      ((ae.b)localObject1).destroy();
    }
    this.Czl = null;
    ad localad = this.Czq;
    localObject1 = aj.CGT;
    ap localap = aj.getFinderLiveAssistant();
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    diq localdiq;
    label81:
    Object localObject2;
    label99:
    Object localObject3;
    label117:
    long l1;
    if (localObject1 == null)
    {
      localdiq = null;
      localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (localObject1 != null) {
        break label295;
      }
      localObject1 = null;
      localObject2 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      localObject2 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (localObject2 != null) {
        break label350;
      }
      localObject2 = null;
      localObject3 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      localObject3 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (localObject3 != null) {
        break label387;
      }
      localObject3 = null;
      if ((localap == null) || (localdiq == null) || (localObject1 == null) || (localObject2 == null) || (localObject3 == null)) {
        break label438;
      }
      ((Number)localObject3).intValue();
      long l2 = ((Number)localObject2).longValue();
      long l3 = ((Number)localObject1).longValue();
      localdiq.BBE = localad.Czf;
      if (!localad.Czg) {
        break label424;
      }
      l1 = (int)localdiq.CJK | 0x1;
      label198:
      localdiq.CJK = l1;
      localap.a(l3, l2, localdiq, (e.a)new ad.b(localdiq));
    }
    label295:
    label424:
    label438:
    for (localObject1 = ah.aiuX;; localObject1 = null)
    {
      if (localObject1 == null) {
        Log.e("FinderLiveLotteryCreateConfig", "setLiveLotterySetting error!");
      }
      ar.a(this.scope, null);
      AppMethodBeat.o(353293);
      return;
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
      if (localObject1 == null)
      {
        localdiq = null;
        break;
      }
      localdiq = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject1).Egu;
      break;
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject1 == null)
      {
        localObject1 = null;
        break label81;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).liveInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label81;
      }
      localObject1 = Long.valueOf(((bip)localObject1).liveId);
      break label81;
      label350:
      localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject2 == null)
      {
        localObject2 = null;
        break label99;
      }
      localObject2 = Long.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject2).hKN);
      break label99;
      localObject3 = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject3).business(e.class);
      if (localObject3 == null)
      {
        localObject3 = null;
        break label117;
      }
      localObject3 = Integer.valueOf(((e)localObject3).Ecp);
      break label117;
      l1 = (int)localdiq.CJK & 0xFFFFFFFE;
      break label198;
    }
  }
  
  public final void qs(boolean paramBoolean)
  {
    AppMethodBeat.i(353276);
    this.Czq.qr(paramBoolean);
    AppMethodBeat.o(353276);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreatePresenter$createLottery$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCreateLotteryResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements x.a
  {
    b(w paramw, af paramaf) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final bgj parambgj)
    {
      AppMethodBeat.i(352865);
      s.u(parambgj, "resp");
      d.uiThread((kotlin.g.a.a)new a(this.yjx, paramInt1, paramInt2, jdField_this, parambgj, paramString));
      AppMethodBeat.o(352865);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(w paramw, int paramInt1, int paramInt2, af paramaf, bgj parambgj, String paramString)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.af
 * JD-Core Version:    0.7.0.1
 */