package com.tencent.mm.plugin.finder.live.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.model.cgi.v;
import com.tencent.mm.plugin.finder.live.model.cgi.v.a;
import com.tencent.mm.plugin.finder.live.model.cgi.v.b;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.b;
import com.tencent.mm.protocal.protobuf.azc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreatePresenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$Presenter;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "desc", "duration", "", "durationValid", "", "liveId", "", "lotteryType", "lotteryTypeValid", "nonceId", "objectId", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateContract$ViewCallback;)V", "winnerCnt", "winnerNumberValid", "wording", "checkDesc", "checkDuration", "checkWinnerNumber", "winnerNumber", "chooseLotteryType", "", "type", "createLottery", "isCommentEnabel", "onAttach", "callback", "onDetach", "setLotteryDesc", "setLotteyDuration", "setLotteyType", "setLotteyWording", "setWinnerNumber", "cnt", "Companion", "plugin-finder_release"})
public final class q
  implements p.a
{
  private static final int MAX_STRING_LENGTH = 10;
  private static final int yaL = 0;
  private static final int yaM;
  private static final int yaN = 2147483647;
  public static final a yaO;
  private final String TAG;
  private final Activity activity;
  private String desc;
  private int duration;
  private long liveId;
  private String nonceId;
  private String wording;
  private long xbk;
  p.b yaF;
  private int yaG;
  private int yaH;
  private boolean yaI;
  private boolean yaJ;
  private boolean yaK;
  
  static
  {
    AppMethodBeat.i(283849);
    yaO = new a((byte)0);
    com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
    yaM = com.tencent.c.a.a.a.a.a.ims();
    MAX_STRING_LENGTH = 10;
    yaN = 2147483647;
    AppMethodBeat.o(283849);
  }
  
  public q(Activity paramActivity)
  {
    AppMethodBeat.i(283848);
    this.activity = paramActivity;
    this.TAG = "FinderLiveLotteryCreatePresenter";
    this.yaG = 1;
    this.wording = "";
    this.desc = "";
    this.nonceId = "";
    this.liveId = this.activity.getIntent().getLongExtra("KEY_PARAMS_LIVE_ID", 0L);
    this.xbk = this.activity.getIntent().getLongExtra("KEY_PARAMS_OBJECT_ID", 0L);
    String str = this.activity.getIntent().getStringExtra("KEY_PARAMS_NONCE_ID");
    paramActivity = str;
    if (str == null) {
      paramActivity = "";
    }
    this.nonceId = paramActivity;
    AppMethodBeat.o(283848);
  }
  
  private final void Nh(int paramInt)
  {
    boolean bool1 = true;
    AppMethodBeat.i(283845);
    Log.i(this.TAG, "chooseLotteryType type:".concat(String.valueOf(paramInt)));
    this.yaJ = Ni(this.duration);
    this.yaK = Nj(this.yaH);
    p.b localb;
    switch (paramInt)
    {
    default: 
      this.yaI = false;
      localb = this.yaF;
      if (localb != null)
      {
        localb.oG(false);
        AppMethodBeat.o(283845);
        return;
      }
      break;
    case 1: 
    case 2: 
    case 3: 
      this.yaI = true;
      localb = this.yaF;
      boolean bool2;
      if (localb != null)
      {
        bool2 = this.yaJ;
        if (this.duration <= yaM) {
          break label192;
        }
      }
      for (;;)
      {
        localb.S(bool2, bool1);
        bool1 = this.yaI;
        bool2 = this.yaJ;
        boolean bool3 = this.yaK;
        localb = this.yaF;
        if (localb == null) {
          break;
        }
        localb.oG(bool1 & bool2 & bool3);
        AppMethodBeat.o(283845);
        return;
        label192:
        bool1 = false;
      }
      AppMethodBeat.o(283845);
      return;
    }
    AppMethodBeat.o(283845);
  }
  
  private final boolean Ni(int paramInt)
  {
    AppMethodBeat.i(283846);
    boolean bool = false;
    int i = yaL;
    int j = yaM;
    if (i + 1 > paramInt) {}
    for (;;)
    {
      Log.i(this.TAG, "checkDuration duration:" + paramInt + " valid:" + bool);
      AppMethodBeat.o(283846);
      return bool;
      if (j >= paramInt) {
        bool = true;
      }
    }
  }
  
  private final boolean Nj(int paramInt)
  {
    AppMethodBeat.i(283847);
    boolean bool = false;
    int i = yaN;
    if (1 > paramInt) {}
    for (;;)
    {
      Log.i(this.TAG, "checkWinnerNumber winnerNumber:" + paramInt + " valid:" + bool);
      AppMethodBeat.o(283847);
      return bool;
      if (i >= paramInt) {
        bool = true;
      }
    }
  }
  
  public final void Ne(int paramInt)
  {
    AppMethodBeat.i(283838);
    this.yaG = paramInt;
    Nh(this.yaG);
    AppMethodBeat.o(283838);
  }
  
  public final void Nf(int paramInt)
  {
    AppMethodBeat.i(283840);
    this.duration = paramInt;
    Nh(this.yaG);
    AppMethodBeat.o(283840);
  }
  
  public final void Ng(int paramInt)
  {
    AppMethodBeat.i(283841);
    this.yaH = paramInt;
    Nh(this.yaG);
    AppMethodBeat.o(283841);
  }
  
  public final void aBS(String paramString)
  {
    AppMethodBeat.i(283839);
    p.k(paramString, "wording");
    this.wording = paramString;
    Nh(this.yaG);
    AppMethodBeat.o(283839);
  }
  
  public final void aBT(String paramString)
  {
    AppMethodBeat.i(283842);
    p.k(paramString, "desc");
    this.desc = paramString;
    Nh(this.yaG);
    AppMethodBeat.o(283842);
  }
  
  public final void dxy()
  {
    int j = 0;
    AppMethodBeat.i(283843);
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    int i;
    label58:
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = (b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(b.class);
      if (localObject1 != null)
      {
        i = ((b)localObject1).zfa;
        if (d.dr(i, 8)) {
          break label202;
        }
        i = 1;
        if ((i != 0) || (this.yaG != 1)) {
          break label214;
        }
        localObject1 = MMApplicationContext.getContext();
        p.j(localObject1, "MMApplicationContext.getContext()");
        localObject1 = ((Context)localObject1).getResources().getString(b.j.finder_live_any_comemnt_lottery_ban);
        p.j(localObject1, "MMApplicationContext.get…_any_comemnt_lottery_ban)");
        localObject2 = (CharSequence)this.wording;
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
          break label305;
        }
        localObject1 = MMApplicationContext.getContext();
        p.j(localObject1, "MMApplicationContext.getContext()");
        localObject1 = ((Context)localObject1).getResources().getString(b.j.finder_live_special_comemnt_lottery_ban);
        p.j(localObject1, "MMApplicationContext.get…cial_comemnt_lottery_ban)");
      }
    }
    label305:
    for (;;)
    {
      localObject2 = this.yaF;
      if (localObject2 != null)
      {
        ((p.b)localObject2).aBU((String)localObject1);
        AppMethodBeat.o(283843);
        return;
        i = 0;
        break;
        label202:
        i = 0;
        break label58;
      }
      AppMethodBeat.o(283843);
      return;
      label214:
      long l1 = this.liveId;
      long l2 = this.xbk;
      localObject1 = this.nonceId;
      i = this.duration;
      localObject2 = this.desc;
      j = this.yaG;
      String str = this.wording;
      v.b localb = v.yjz;
      new v(l1, l2, (String)localObject1, i, (String)localObject2, j, str, v.dzX(), this.yaH, (v.a)new b(this)).bhW();
      AppMethodBeat.o(283843);
      return;
    }
  }
  
  public final void onDetach()
  {
    this.yaF = null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreatePresenter$Companion;", "", "()V", "MAX_RURATION", "", "getMAX_RURATION", "()I", "MAX_STRING_LENGTH", "getMAX_STRING_LENGTH", "MAX_WINNER_NUMBER", "getMAX_WINNER_NUMBER", "MIN_DURATION", "getMIN_DURATION", "MIN_STRING_LENGTH", "getMIN_STRING_LENGTH", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreatePresenter$createLottery$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCreateLotteryResponse;", "plugin-finder_release"})
  public static final class b
    implements v.a
  {
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final azc paramazc)
    {
      AppMethodBeat.i(225348);
      p.k(paramazc, "resp");
      d.uiThread((kotlin.g.a.a)new a(this, paramInt1, paramInt2, paramazc, paramString));
      AppMethodBeat.o(225348);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(q.b paramb, int paramInt1, int paramInt2, azc paramazc, String paramString)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.q
 * JD-Core Version:    0.7.0.1
 */