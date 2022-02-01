package com.tencent.mm.plugin.finder.live.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.live.model.cgi.m;
import com.tencent.mm.plugin.finder.live.model.cgi.m.a;
import com.tencent.mm.plugin.finder.live.model.cgi.m.b;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.f;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.protocal.protobuf.avp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreatePresenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "desc", "duration", "", "durationValid", "", "liveId", "", "lotteryType", "lotteryTypeValid", "nonceId", "objectId", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;)V", "winnerCnt", "winnerNumberValid", "wording", "checkDesc", "checkDuration", "checkWinnerNumber", "winnerNumber", "chooseLotteryType", "", "type", "createLottery", "isCommentEnabel", "onAttach", "callback", "onDetach", "setLotteryDesc", "setLotteyDuration", "setLotteyType", "setLotteyWording", "setWinnerNumber", "cnt", "Companion", "plugin-finder_release"})
public final class e
  implements d.a
{
  private static final int MAX_STRING_LENGTH = 10;
  private static final int ugJ = 0;
  private static final int ugK;
  private static final int ugL = 2147483647;
  public static final a ugM;
  private final String TAG;
  private final Activity activity;
  private String dQx;
  private String desc;
  private int duration;
  private long hFK;
  private String hwg;
  private long liveId;
  d.b ugD;
  private int ugE;
  private int ugF;
  private boolean ugG;
  private boolean ugH;
  private boolean ugI;
  
  static
  {
    AppMethodBeat.i(245932);
    ugM = new a((byte)0);
    c localc = c.vCb;
    ugK = c.dvp();
    MAX_STRING_LENGTH = 10;
    ugL = 2147483647;
    AppMethodBeat.o(245932);
  }
  
  public e(Activity paramActivity)
  {
    AppMethodBeat.i(245931);
    this.activity = paramActivity;
    this.TAG = "FinderLiveLotteryCreatePresenter";
    this.ugE = 1;
    this.dQx = "";
    this.desc = "";
    this.hwg = "";
    this.liveId = this.activity.getIntent().getLongExtra("KEY_PARAMS_LIVE_ID", 0L);
    this.hFK = this.activity.getIntent().getLongExtra("KEY_PARAMS_OBJECT_ID", 0L);
    String str = this.activity.getIntent().getStringExtra("KEY_PARAMS_NONCE_ID");
    paramActivity = str;
    if (str == null) {
      paramActivity = "";
    }
    this.hwg = paramActivity;
    AppMethodBeat.o(245931);
  }
  
  private final void Jc(int paramInt)
  {
    boolean bool1 = true;
    AppMethodBeat.i(245928);
    Log.i(this.TAG, "chooseLotteryType type:".concat(String.valueOf(paramInt)));
    this.ugH = Jd(this.duration);
    this.ugI = Je(this.ugF);
    d.b localb;
    switch (paramInt)
    {
    default: 
      this.ugG = false;
      localb = this.ugD;
      if (localb != null)
      {
        localb.nk(false);
        AppMethodBeat.o(245928);
        return;
      }
      break;
    case 1: 
    case 2: 
    case 3: 
      this.ugG = true;
      localb = this.ugD;
      boolean bool2;
      if (localb != null)
      {
        bool2 = this.ugH;
        if (this.duration <= ugK) {
          break label192;
        }
      }
      for (;;)
      {
        localb.N(bool2, bool1);
        bool1 = this.ugG;
        bool2 = this.ugH;
        boolean bool3 = this.ugI;
        localb = this.ugD;
        if (localb == null) {
          break;
        }
        localb.nk(bool1 & bool2 & bool3);
        AppMethodBeat.o(245928);
        return;
        label192:
        bool1 = false;
      }
      AppMethodBeat.o(245928);
      return;
    }
    AppMethodBeat.o(245928);
  }
  
  private final boolean Jd(int paramInt)
  {
    AppMethodBeat.i(245929);
    boolean bool = false;
    int i = ugJ;
    int j = ugK;
    if (i + 1 > paramInt) {}
    for (;;)
    {
      Log.i(this.TAG, "checkDuration duration:" + paramInt + " valid:" + bool);
      AppMethodBeat.o(245929);
      return bool;
      if (j >= paramInt) {
        bool = true;
      }
    }
  }
  
  private final boolean Je(int paramInt)
  {
    AppMethodBeat.i(245930);
    boolean bool = false;
    int i = ugL;
    if (1 > paramInt) {}
    for (;;)
    {
      Log.i(this.TAG, "checkWinnerNumber winnerNumber:" + paramInt + " valid:" + bool);
      AppMethodBeat.o(245930);
      return bool;
      if (i >= paramInt) {
        bool = true;
      }
    }
  }
  
  public final void IZ(int paramInt)
  {
    AppMethodBeat.i(245921);
    this.ugE = paramInt;
    Jc(this.ugE);
    AppMethodBeat.o(245921);
  }
  
  public final void Ja(int paramInt)
  {
    AppMethodBeat.i(245923);
    this.duration = paramInt;
    Jc(this.ugE);
    AppMethodBeat.o(245923);
  }
  
  public final void Jb(int paramInt)
  {
    AppMethodBeat.i(245924);
    this.ugF = paramInt;
    Jc(this.ugE);
    AppMethodBeat.o(245924);
  }
  
  public final void atu(String paramString)
  {
    AppMethodBeat.i(245922);
    p.h(paramString, "wording");
    this.dQx = paramString;
    Jc(this.ugE);
    AppMethodBeat.o(245922);
  }
  
  public final void atv(String paramString)
  {
    AppMethodBeat.i(245925);
    p.h(paramString, "desc");
    this.desc = paramString;
    Jc(this.ugE);
    AppMethodBeat.o(245925);
  }
  
  public final void dff()
  {
    int j = 0;
    AppMethodBeat.i(245926);
    Object localObject1 = o.ujN;
    localObject1 = o.dfZ();
    int i;
    label40:
    Object localObject2;
    if (localObject1 != null)
    {
      i = ((g)localObject1).uDA;
      if (d.cW(i, 8)) {
        break label184;
      }
      i = 1;
      if ((i != 0) || (this.ugE != 1)) {
        break label196;
      }
      localObject1 = MMApplicationContext.getContext();
      p.g(localObject1, "MMApplicationContext.getContext()");
      localObject1 = ((Context)localObject1).getResources().getString(2131759881);
      p.g(localObject1, "MMApplicationContext.get…_any_comemnt_lottery_ban)");
      localObject2 = (CharSequence)this.dQx;
      if (localObject2 != null)
      {
        i = j;
        if (((CharSequence)localObject2).length() != 0) {}
      }
      else
      {
        i = 1;
      }
      if (i != 0) {
        break label287;
      }
      localObject1 = MMApplicationContext.getContext();
      p.g(localObject1, "MMApplicationContext.getContext()");
      localObject1 = ((Context)localObject1).getResources().getString(2131760191);
      p.g(localObject1, "MMApplicationContext.get…cial_comemnt_lottery_ban)");
    }
    label287:
    for (;;)
    {
      localObject2 = this.ugD;
      if (localObject2 != null)
      {
        ((d.b)localObject2).atw((String)localObject1);
        AppMethodBeat.o(245926);
        return;
        i = 0;
        break;
        label184:
        i = 0;
        break label40;
      }
      AppMethodBeat.o(245926);
      return;
      label196:
      long l1 = this.liveId;
      long l2 = this.hFK;
      localObject1 = this.hwg;
      i = this.duration;
      localObject2 = this.desc;
      j = this.ugE;
      String str = this.dQx;
      m.b localb = m.ukW;
      new m(l1, l2, (String)localObject1, i, (String)localObject2, j, str, m.dgF(), this.ugF, (m.a)new b(this)).aYI();
      AppMethodBeat.o(245926);
      return;
    }
  }
  
  public final void onDetach()
  {
    this.ugD = null;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreatePresenter$Companion;", "", "()V", "MAX_RURATION", "", "getMAX_RURATION", "()I", "MAX_STRING_LENGTH", "getMAX_STRING_LENGTH", "MAX_WINNER_NUMBER", "getMAX_WINNER_NUMBER", "MIN_DURATION", "getMIN_DURATION", "MIN_STRING_LENGTH", "getMIN_STRING_LENGTH", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreatePresenter$createLottery$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCreateLotteryResponse;", "plugin-finder_release"})
  public static final class b
    implements m.a
  {
    public final void a(int paramInt1, int paramInt2, String paramString, avp paramavp)
    {
      AppMethodBeat.i(245920);
      p.h(paramavp, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = k.vkd;
        k.a(s.f.vnv, e.a(this.ugN) + '@' + e.b(this.ugN) + ';' + e.c(this.ugN) + ';' + e.d(this.ugN) + ';' + e.e(this.ugN));
        paramString = o.ujN;
        paramString = o.dfZ();
        if (paramString != null) {
          paramString.djg();
        }
        paramavp = paramavp.tWe;
        if (paramavp != null)
        {
          paramString = new LinkedList();
          paramString.add(paramavp);
          paramavp = o.ujN;
          paramavp = o.dfZ();
          if (paramavp != null) {
            g.h(paramavp, paramString);
          }
          paramString = o.ujN;
          paramString = o.dfZ();
          if (paramString != null) {
            paramString.uEd = true;
          }
        }
        e.f(this.ugN).setResult(-1);
        e.f(this.ugN).finish();
        AppMethodBeat.o(245920);
        return;
      }
      d.b localb = this.ugN.ugD;
      if (localb != null)
      {
        localb.a(paramInt2, paramString, paramavp);
        AppMethodBeat.o(245920);
        return;
      }
      AppMethodBeat.o(245920);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.e
 * JD-Core Version:    0.7.0.1
 */