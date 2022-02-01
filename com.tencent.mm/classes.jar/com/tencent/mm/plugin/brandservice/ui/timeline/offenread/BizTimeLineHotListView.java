package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.g.a;
import androidx.recyclerview.widget.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aw;
import com.tencent.mm.autogen.a.ja;
import com.tencent.mm.autogen.a.ja.a;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.ball.f.d.a;
import com.tencent.mm.plugin.bizui.widget.BizTagTextView;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.c;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardCanvasView;
import com.tencent.mm.pluginsdk.model.y;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.l;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.applet.m.b;
import com.tencent.mm.protocal.protobuf.dvv;
import com.tencent.mm.protocal.protobuf.fxl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.af;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BizTimeLineHotListView
  extends MRecyclerView
  implements com.tencent.mm.vending.e.a
{
  public static int vOI;
  public static int vOJ;
  public static int vOK;
  public static int vOL;
  public static int vOM;
  public static int vON;
  public static int vOO;
  public static int vOP;
  private static Map<String, Integer> vOT;
  private List<e> eXW;
  private int mScreenWidth;
  private int vOA;
  boolean vOB;
  private h vOC;
  k vOD;
  private boolean vOE;
  private float vOF;
  private float vOG;
  private float vOH;
  private IListener<aw> vOQ;
  private IListener<ja> vOR;
  private boolean vOS;
  private i vOx;
  private b vOy;
  private float vOz;
  
  static
  {
    AppMethodBeat.i(302480);
    vOT = new HashMap();
    AppMethodBeat.o(302480);
  }
  
  public BizTimeLineHotListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(6081);
    this.eXW = new ArrayList();
    this.vOz = 0.0F;
    this.mScreenWidth = 0;
    this.vOA = 0;
    this.vOB = false;
    this.vOE = false;
    this.vOF = 0.0F;
    this.vOG = 0.0F;
    this.vOH = 0.0F;
    this.vOQ = new IListener(com.tencent.mm.app.f.hfK) {};
    this.vOR = new IListener(com.tencent.mm.app.f.hfK) {};
    this.vOS = true;
    init();
    AppMethodBeat.o(6081);
  }
  
  public BizTimeLineHotListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(6082);
    this.eXW = new ArrayList();
    this.vOz = 0.0F;
    this.mScreenWidth = 0;
    this.vOA = 0;
    this.vOB = false;
    this.vOE = false;
    this.vOF = 0.0F;
    this.vOG = 0.0F;
    this.vOH = 0.0F;
    this.vOQ = new IListener(com.tencent.mm.app.f.hfK) {};
    this.vOR = new IListener(com.tencent.mm.app.f.hfK) {};
    this.vOS = true;
    init();
    AppMethodBeat.o(6082);
  }
  
  private static boolean Hq(int paramInt)
  {
    AppMethodBeat.i(302305);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(302305);
      return false;
    }
    int i = MultiProcessMMKV.getSingleMMKV("MicroMsg.BizTimeLineHotListView").decodeInt("VideoChannelTopBarVersion", 0);
    Log.i("MicroMsg.BizTimeLineHotListView", "getVideoChannelUnReadState, version: %d, lastVersion: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if (paramInt > i)
    {
      AppMethodBeat.o(302305);
      return true;
    }
    AppMethodBeat.o(302305);
    return false;
  }
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(302343);
    paramc.uQt.setVisibility(0);
    paramc.tCz.setVisibility(0);
    if (paramc.vKq != null) {
      paramc.vKq.setVisibility(8);
    }
    AppMethodBeat.o(302343);
  }
  
  public static void a(e parame, View paramView)
  {
    AppMethodBeat.i(302277);
    if ((paramView == null) || (parame == null))
    {
      Log.i("MicroMsg.BizTimeLineHotListView", "green dot erro, null!");
      AppMethodBeat.o(302277);
      return;
    }
    if ((parame.vPT) || (parame.vPQ))
    {
      paramView.setVisibility(0);
      AppMethodBeat.o(302277);
      return;
    }
    paramView.setVisibility(8);
    AppMethodBeat.o(302277);
  }
  
  private void a(e parame, c paramc)
  {
    AppMethodBeat.i(302292);
    if (this.vOE)
    {
      AppMethodBeat.o(302292);
      return;
    }
    com.tencent.mm.pluginsdk.model.c localc = com.tencent.mm.pluginsdk.model.c.XPt;
    if (com.tencent.mm.pluginsdk.model.c.iGW())
    {
      if (Util.isNullOrNil(parame.YSM))
      {
        localc = com.tencent.mm.pluginsdk.model.c.XPt;
        if (com.tencent.mm.pluginsdk.model.c.bpk(parame.YIf)) {}
      }
    }
    else
    {
      paramc.vPo.setVisibility(8);
      paramc.vPp.setVisibility(8);
      paramc.vPp.setContentDescription("");
      AppMethodBeat.o(302292);
      return;
    }
    localc = com.tencent.mm.pluginsdk.model.c.XPt;
    if (com.tencent.mm.pluginsdk.model.c.pa(parame.YIf, parame.YSM))
    {
      paramc.vPo.setVisibility(0);
      paramc.vPp.setContentDescription(paramc.vPp.getText());
    }
    for (;;)
    {
      paramc.vPp.setVisibility(0);
      paramc.vPp.setTextSize(1, 8.0F);
      paramc.vPp.daK();
      paramc.vPp.setFillColor(getContext().getResources().getColor(d.b.biz_finder_live_logo_color));
      if (com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext()) > 1.4F)
      {
        paramc.vPp.setTextSize(1, 11.0F);
        paramc.vPp.setPadding(paramc.vPp.getPaddingLeft(), com.tencent.mm.cd.a.fromDPToPix(getContext(), 3), paramc.vPp.getPaddingRight(), com.tencent.mm.cd.a.fromDPToPix(getContext(), 2));
        parame = (RelativeLayout.LayoutParams)paramc.vPp.getLayoutParams();
        parame.setMargins(parame.leftMargin, parame.topMargin, parame.rightMargin, com.tencent.mm.cd.a.fromDPToPix(getContext(), 3));
        paramc.vPp.setLayoutParams(parame);
      }
      AppMethodBeat.o(302292);
      return;
      paramc.vPo.setVisibility(8);
      paramc.vPp.setContentDescription("");
    }
  }
  
  private static void a(f paramf, fxl paramfxl)
  {
    AppMethodBeat.i(302335);
    if ((paramf != null) && (paramfxl != null))
    {
      paramf.title = paramfxl.title;
      paramf.pLF = paramfxl.abVh;
      paramf.appId = paramfxl.appid;
      paramf.nQG = paramfxl.nQG;
      paramf.vPY = paramfxl.abVb;
      paramf.appVersion = paramfxl.version;
      paramf.vPW = paramfxl.abVa;
      paramf.vPX = paramfxl.abVe;
      paramf.vPQ = Hq(paramfxl.abVa);
    }
    AppMethodBeat.o(302335);
  }
  
  private void b(final e parame)
  {
    AppMethodBeat.i(302285);
    if (!this.vOE)
    {
      localc = com.tencent.mm.pluginsdk.model.c.XPt;
      if (!Util.isNullOrNil(com.tencent.mm.pluginsdk.model.c.iHj())) {}
    }
    else
    {
      this.vOS = false;
      AppMethodBeat.o(302285);
      return;
    }
    com.tencent.mm.pluginsdk.model.c localc = com.tencent.mm.pluginsdk.model.c.XPt;
    if (com.tencent.mm.pluginsdk.model.c.bpk(parame.YIf))
    {
      if (!this.vOS)
      {
        AppMethodBeat.o(302285);
        return;
      }
      this.vOS = false;
      com.tencent.threadpool.h.ahAA.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(302353);
          com.tencent.mm.pluginsdk.model.c localc = com.tencent.mm.pluginsdk.model.c.XPt;
          com.tencent.mm.pluginsdk.model.c.bpp(parame.YIf);
          localc = com.tencent.mm.pluginsdk.model.c.XPt;
          if (Util.isNullOrNil(com.tencent.mm.pluginsdk.model.c.bpi(parame.YIf))) {
            BizTimeLineHotListView.this.c(parame);
          }
          AppMethodBeat.o(302353);
        }
      }, 2000L);
    }
    AppMethodBeat.o(302285);
  }
  
  private void des()
  {
    AppMethodBeat.i(302299);
    setOnItemClickListener(new MRecyclerView.a()
    {
      public final void onItemClick(RecyclerView paramAnonymousRecyclerView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(302383);
        paramAnonymousRecyclerView = (e)BizTimeLineHotListView.b(BizTimeLineHotListView.this).get(paramAnonymousInt);
        if (paramAnonymousRecyclerView == null)
        {
          AppMethodBeat.o(302383);
          return;
        }
        Object localObject1 = BizTimeLineHotListView.e(BizTimeLineHotListView.this);
        boolean bool1 = BizTimeLineHotListView.a(BizTimeLineHotListView.this);
        Object localObject2;
        if (paramAnonymousRecyclerView != null)
        {
          if (paramAnonymousRecyclerView.type != 1) {
            break label401;
          }
          localObject2 = new dvv();
          ((dvv)localObject2).ADE = paramAnonymousRecyclerView.YIf;
          ((dvv)localObject2).Caf = (paramAnonymousRecyclerView.position - 1);
          ((dvv)localObject2).abbw = ((int)(System.currentTimeMillis() / 1000L));
          if (paramAnonymousRecyclerView.vPQ)
          {
            paramAnonymousInt = 1;
            ((dvv)localObject2).abbv = paramAnonymousInt;
            ((dvv)localObject2).type = 0;
            if (!bool1) {
              break label373;
            }
            paramAnonymousInt = 1;
            label132:
            ((dvv)localObject2).abbB = paramAnonymousInt;
            if (!bool1) {
              break label378;
            }
            paramAnonymousInt = 1;
            label145:
            ((dvv)localObject2).ZVE = paramAnonymousInt;
            ((dvv)localObject2).abbC = paramAnonymousRecyclerView.YSM;
            ((dvv)localObject2).mRN = paramAnonymousRecyclerView.YSN;
            if (paramAnonymousRecyclerView.vPV != 2) {
              break label386;
            }
            paramAnonymousInt = 1;
            label179:
            ((dvv)localObject2).abbF = paramAnonymousInt;
            if (bool1)
            {
              if (!((h)localObject1).vQd) {
                break label391;
              }
              paramAnonymousInt = 1;
              label200:
              ((dvv)localObject2).abbD = paramAnonymousInt;
              if (!paramAnonymousRecyclerView.nXh) {
                break label396;
              }
              paramAnonymousInt = 1;
              label215:
              ((dvv)localObject2).abbE = paramAnonymousInt;
            }
            ((h)localObject1).vQb.add(localObject2);
            localObject1 = com.tencent.mm.pluginsdk.model.c.XPt;
            com.tencent.mm.pluginsdk.model.c.b(paramAnonymousRecyclerView.YIf, null);
          }
        }
        else
        {
          label245:
          if ((!BizTimeLineHotListView.a(BizTimeLineHotListView.this)) && (!BizTimeLineHotListView.d(paramAnonymousRecyclerView))) {
            break label695;
          }
          if (!BizTimeLineHotListView.a(BizTimeLineHotListView.this)) {
            break label668;
          }
        }
        label386:
        label391:
        label396:
        label401:
        label658:
        label663:
        label668:
        for (paramAnonymousInt = 2;; paramAnonymousInt = 1)
        {
          paramAnonymousView = com.tencent.mm.pluginsdk.model.c.XPt;
          localObject1 = BizTimeLineHotListView.this.getContext();
          localObject2 = paramAnonymousRecyclerView.YIf;
          Object localObject3 = paramAnonymousRecyclerView.YSM;
          int i = paramAnonymousRecyclerView.YSN;
          b localb = b.vPq;
          paramAnonymousView.a((Context)localObject1, (String)localObject2, (String)localObject3, paramAnonymousInt, i, b.ev(BizTimeLineHotListView.b(BizTimeLineHotListView.this)));
          if (BizTimeLineHotListView.a(BizTimeLineHotListView.this)) {
            break label673;
          }
          paramAnonymousView = com.tencent.mm.pluginsdk.model.c.XPt;
          com.tencent.mm.pluginsdk.model.c.bpp(paramAnonymousRecyclerView.YIf);
          BizTimeLineHotListView.this.c(paramAnonymousRecyclerView);
          AppMethodBeat.o(302383);
          return;
          paramAnonymousInt = 0;
          break;
          label373:
          paramAnonymousInt = 0;
          break label132;
          label378:
          paramAnonymousInt = h.g(paramAnonymousRecyclerView);
          break label145;
          paramAnonymousInt = 0;
          break label179;
          paramAnonymousInt = 0;
          break label200;
          paramAnonymousInt = 0;
          break label215;
          if (paramAnonymousRecyclerView.type != 3) {
            break label245;
          }
          localObject2 = new dvv();
          paramAnonymousLong = System.currentTimeMillis();
          ((dvv)localObject2).Caf = (paramAnonymousRecyclerView.position - 1);
          ((dvv)localObject2).abbw = ((int)(paramAnonymousLong / 1000L));
          localObject3 = com.tencent.mm.plugin.brandservice.model.d.vBI;
          if (com.tencent.mm.plugin.brandservice.model.d.dcd())
          {
            paramAnonymousInt = 2;
            label459:
            ((dvv)localObject2).type = paramAnonymousInt;
            localObject3 = com.tencent.mm.plugin.brandservice.model.d.vBI;
            ((dvv)localObject2).nQG = com.tencent.mm.plugin.brandservice.model.d.mN(false);
            if (!com.tencent.mm.plugin.brandservice.model.d.vBI.dca()) {
              break label653;
            }
            paramAnonymousInt = 1;
            label490:
            ((dvv)localObject2).abby = paramAnonymousInt;
            localObject3 = com.tencent.mm.plugin.brandservice.model.d.vBI;
            ((dvv)localObject2).abbx = com.tencent.mm.plugin.brandservice.model.d.dcb();
            localObject3 = com.tencent.mm.plugin.brandservice.model.d.vBI;
            if (!com.tencent.mm.plugin.brandservice.model.d.dbZ()) {
              break label658;
            }
            paramAnonymousInt = 1;
            ((dvv)localObject2).abbz = paramAnonymousInt;
            ((dvv)localObject2).abbA = paramAnonymousLong;
            Log.d("MicroMsg.BizTimeLineOftenReadReport", "onClick is_default_icon %d, is_icon_cache %d", new Object[] { Integer.valueOf(((dvv)localObject2).abbz), Integer.valueOf(((dvv)localObject2).abby) });
            ((h)localObject1).vQb.add(localObject2);
            localObject1 = com.tencent.mm.plugin.brandservice.model.d.vBI;
            if (!com.tencent.mm.plugin.brandservice.model.d.dcd()) {
              break label663;
            }
          }
          for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(21258, new Object[] { Integer.valueOf(2), Long.valueOf(paramAnonymousLong), Integer.valueOf(0), com.tencent.mm.pluginsdk.ui.tools.aa.aUC(((dvv)localObject2).nQG), Integer.valueOf(paramAnonymousInt) });
            break;
            paramAnonymousInt = 1;
            break label459;
            paramAnonymousInt = 0;
            break label490;
            paramAnonymousInt = 0;
            break label522;
          }
        }
        label522:
        label653:
        label673:
        BizTimeLineHotListView.this.vOD.ajd(paramAnonymousRecyclerView.YIf);
        AppMethodBeat.o(302383);
        return;
        label695:
        if (paramAnonymousRecyclerView.type == 1)
        {
          bool1 = com.tencent.mm.model.ab.IR(paramAnonymousRecyclerView.YIf);
          paramAnonymousView = b.vPq;
          boolean bool2 = b.dew();
          if ((bool1) && (!bool2))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Chat_User", paramAnonymousRecyclerView.YIf);
            paramAnonymousView.putExtra("finish_direct", true);
            paramAnonymousView.putExtra("KOpenArticleSceneFromScene", 91);
            paramAnonymousView.putExtra("specific_chat_from_scene", 8);
            paramAnonymousView.putExtra("preChatTYPE", 12);
            com.tencent.mm.br.c.g(BizTimeLineHotListView.this.getContext(), ".ui.chatting.ChattingUI", paramAnonymousView);
            paramAnonymousRecyclerView.vPQ = false;
            paramAnonymousRecyclerView.vPT = false;
            BizTimeLineHotListView.this.a(paramAnonymousRecyclerView);
            if (!Util.isNullOrNil(paramAnonymousRecyclerView.YIf)) {
              ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxO(paramAnonymousRecyclerView.YIf);
            }
            if ((BizTimeLineHotListView.this.getContext() instanceof BizTimeLineUI))
            {
              paramAnonymousView = ((BizTimeLineUI)BizTimeLineHotListView.this.getContext()).vFK;
              paramAnonymousRecyclerView = paramAnonymousRecyclerView.YIf;
              if (paramAnonymousView.dataList.size() > 0)
              {
                localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.g.vHx;
                com.tencent.mm.plugin.brandservice.ui.timeline.g.a((com.tencent.mm.storage.ab)paramAnonymousView.dataList.get(0), paramAnonymousView.dataList, paramAnonymousView.vHh, paramAnonymousRecyclerView);
              }
            }
            AppMethodBeat.o(302383);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramAnonymousRecyclerView.YIf);
          paramAnonymousView.putExtra("Contact_Scene", 228);
          paramAnonymousView.putExtra("force_get_contact", true);
          paramAnonymousView.putExtra("key_use_new_contact_profile", true);
          MultiProcessMMKV.getMMKV("BizTimeLineHotList_UserClick_FinderMsgTimeStamp").encode(paramAnonymousRecyclerView.YIf, paramAnonymousRecyclerView.vPU);
          Log.i("MicroMsg.BizTimeLineHotListView", "user click!, greenDotJumpType = %s, username = %s, time = %s", new Object[] { Integer.valueOf(paramAnonymousRecyclerView.vPV), paramAnonymousRecyclerView.YIf, Long.valueOf(paramAnonymousRecyclerView.vPU) });
          if (paramAnonymousRecyclerView.vPV == 1) {
            paramAnonymousView.putExtra("biz_profile_enter_from_finder", false);
          }
          for (;;)
          {
            com.tencent.mm.br.c.b(BizTimeLineHotListView.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
            break;
            if (paramAnonymousRecyclerView.vPV == 2)
            {
              paramAnonymousView.putExtra("biz_profile_tab_type", 1);
              paramAnonymousView.putExtra("biz_profile_enter_from_finder", true);
            }
          }
        }
        if (paramAnonymousRecyclerView.type == 3)
        {
          Log.i("MicroMsg.BizTimeLineHotListView", "alvinluo onClick jump to video channel");
          if ((paramAnonymousRecyclerView instanceof f)) {
            BizTimeLineHotListView.a(BizTimeLineHotListView.this, (f)paramAnonymousRecyclerView, paramAnonymousView);
          }
        }
        AppMethodBeat.o(302383);
      }
    });
    AppMethodBeat.o(302299);
  }
  
  private void det()
  {
    AppMethodBeat.i(302310);
    setOnScrollPageListener(new i.a()
    {
      public final void Hr(int paramAnonymousInt)
      {
        AppMethodBeat.i(302337);
        int i = BizTimeLineHotListView.this.getCurrentPage();
        Log.d("MicroMsg.BizTimeLineHotListView", "alvinluo ScrollPageListener onScrolled offsetOfCurPage: %d, , currentPage: %d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
        BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramAnonymousInt, i);
        BizTimeLineHotListView.f(BizTimeLineHotListView.this);
        AppMethodBeat.o(302337);
      }
      
      public final void aq(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(302342);
        if (!paramAnonymousBoolean)
        {
          int i = (int)(System.currentTimeMillis() / 1000L);
          com.tencent.mm.plugin.report.service.h.OAn.b(15721, new Object[] { "", Integer.valueOf(0), Integer.valueOf(10), Integer.valueOf(i), Integer.valueOf(ad.getSessionId()) });
        }
        BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramAnonymousInt);
        BizTimeLineHotListView.this.del();
        AppMethodBeat.o(302342);
      }
    });
    AppMethodBeat.o(302310);
  }
  
  private void et(List<e> paramList)
  {
    AppMethodBeat.i(6093);
    if (paramList == null)
    {
      AppMethodBeat.o(6093);
      return;
    }
    e locale = new e(2);
    locale.YIf = "__BizTimeLine.CustomItem__";
    paramList.add(0, locale);
    eu(paramList);
    AppMethodBeat.o(6093);
  }
  
  private void eu(List<e> paramList)
  {
    AppMethodBeat.i(175433);
    if ((paramList == null) || (this.vOE))
    {
      AppMethodBeat.o(175433);
      return;
    }
    if (com.tencent.mm.plugin.brandservice.model.d.dbT())
    {
      Log.i("MicroMsg.BizTimeLineHotListView", "alvinluo addCustomItems timeline top bar entry is open");
      f localf = new f();
      fxl localfxl = com.tencent.mm.plugin.brandservice.model.d.dbU();
      if (localfxl != null)
      {
        localf.YIf = "__BizTimeLine.VideoChannelEntry__";
        a(localf, localfxl);
        paramList.add(1, localf);
        localf.position = 1;
        this.vOB = true;
      }
    }
    AppMethodBeat.o(175433);
  }
  
  public static int fM(Context paramContext)
  {
    AppMethodBeat.i(302338);
    int i = (c.fP(paramContext) - vOM) * 4 / 3;
    int j = vOP;
    AppMethodBeat.o(302338);
    return i + j;
  }
  
  private void g(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(302318);
    Log.d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha pos: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramv != null)
    {
      float f = paramv.caK.getX();
      if (f >= this.mScreenWidth - getItemWidth() / 2)
      {
        paramv.caK.setAlpha(0.3F);
        AppMethodBeat.o(302318);
        return;
      }
      if ((f < this.mScreenWidth - getItemWidth() / 2) && (f >= this.vOz))
      {
        f = 1.0F - (f - this.vOz) / this.vOA * 0.7F;
        Log.d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha %f", new Object[] { Float.valueOf(f) });
        paramv.caK.setAlpha(f);
        AppMethodBeat.o(302318);
        return;
      }
      paramv.caK.setAlpha(1.0F);
    }
    AppMethodBeat.o(302318);
  }
  
  private void init()
  {
    AppMethodBeat.i(175432);
    Log.v("MicroMsg.BizTimeLineHotListView", "alvinluo init");
    if ((getContext() instanceof MMFragmentActivity)) {
      ((MMFragmentActivity)getContext()).keep(this);
    }
    vOJ = com.tencent.mm.cd.a.fromDPToPix(getContext(), 90);
    vOK = com.tencent.mm.cd.a.fromDPToPix(getContext(), 30);
    vOL = com.tencent.mm.cd.a.fromDPToPix(getContext(), 12);
    vOM = com.tencent.mm.cd.a.fromDPToPix(getContext(), 8);
    vON = com.tencent.mm.cd.a.fromDPToPix(getContext(), 6);
    vOO = com.tencent.mm.cd.a.fromDPToPix(getContext(), 7);
    vOP = com.tencent.mm.cd.a.fromDPToPix(getContext(), 4);
    vOI = com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
    setItemAnimator(null);
    AppMethodBeat.o(175432);
  }
  
  public final void a(Context paramContext, List<e> paramList, h paramh, k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(302528);
    this.vOC = paramh;
    this.vOD = paramk;
    this.vOE = paramBoolean;
    this.eXW.addAll(paramList);
    et(this.eXW);
    if (paramBoolean) {}
    for (paramList = new a();; paramList = new b())
    {
      this.vOy = paramList;
      getContext();
      paramList = new LinearLayoutManager()
      {
        public final boolean supportsPredictiveItemAnimations()
        {
          return false;
        }
      };
      paramList.setOrientation(0);
      setLayoutManager(paramList);
      setAdapter(this.vOy);
      this.vOx = new i(getCustomItemCount());
      this.vOx.a(paramContext, this, c.getCompletelyCountPerPage());
      det();
      des();
      if (!paramBoolean)
      {
        this.vOQ.alive();
        this.vOR.alive();
      }
      AppMethodBeat.o(302528);
      return;
    }
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(302493);
    if ((parame == null) || (this.vOE))
    {
      AppMethodBeat.o(302493);
      return;
    }
    c localc = (c)fU(parame.position);
    if (localc == null)
    {
      Log.e("MicroMsg.BizTimeLineHotListView", "refreshUnread %s", new Object[] { parame.YIf });
      AppMethodBeat.o(302493);
      return;
    }
    a(parame, localc.vPi);
    AppMethodBeat.o(302493);
  }
  
  public final boolean bs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6088);
    i locali = this.vOx;
    locali.am(locali.EK(locali.biT + paramInt1), false);
    boolean bool = super.bs(paramInt1, paramInt2);
    AppMethodBeat.o(6088);
    return bool;
  }
  
  public final void c(e parame)
  {
    AppMethodBeat.i(302499);
    if (parame == null)
    {
      AppMethodBeat.o(302499);
      return;
    }
    c localc = (c)fU(parame.position);
    if (localc == null)
    {
      Log.e("MicroMsg.BizTimeLineHotListView", "refreshUnread %s", new Object[] { parame.YIf });
      AppMethodBeat.o(302499);
      return;
    }
    a(parame, localc);
    AppMethodBeat.o(302499);
  }
  
  public final boolean cSV()
  {
    return false;
  }
  
  public void dead()
  {
    AppMethodBeat.i(302619);
    Log.d("MicroMsg.BizTimeLineHotListView", "dead");
    com.tencent.threadpool.h.ahAA.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(302360);
        if (BizTimeLineHotListView.this.isAttachedToWindow()) {
          try
          {
            BizTimeLineHotListView.this.onDetachedFromWindow();
            Log.i("MicroMsg.BizTimeLineHotListView", "dead onDestroy but has not called onDetachedFromWindow!");
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1378L, 12L, 1L, false);
            AppMethodBeat.o(302360);
            return;
          }
          catch (Exception localException)
          {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1378L, 13L, 1L, false);
            Log.e("MicroMsg.BizTimeLineHotListView", "dead onDetachedFromWindow ex %s", new Object[] { localException.getMessage() });
          }
        }
        AppMethodBeat.o(302360);
      }
    }, 3000L);
    AppMethodBeat.o(302619);
  }
  
  public final void del()
  {
    AppMethodBeat.i(6085);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.eXW);
    int m = getCurrentPage();
    int j = i.EN(m);
    int k = i.Hs(m);
    int i = j;
    if (m == 0) {
      i = j + 1;
    }
    while ((i <= k) && (i < localArrayList.size()))
    {
      e locale = (e)localArrayList.get(i);
      if (locale != null)
      {
        b(locale);
        this.vOC.a(locale, this.vOE);
      }
      i += 1;
    }
    AppMethodBeat.o(6085);
  }
  
  public final void der()
  {
    AppMethodBeat.i(302537);
    this.vOx.uQM = c.getCompletelyCountPerPage();
    AppMethodBeat.o(302537);
  }
  
  public final void deu()
  {
    AppMethodBeat.i(302566);
    if (this.vOx != null)
    {
      i locali = this.vOx;
      RecyclerView.LayoutManager localLayoutManager = locali.vQf.getLayoutManager();
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localLayoutManager, locala.aYi(), "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "resetToFirstPage", "()V", "Undefined", "scrollToPosition", "(I)V");
      localLayoutManager.scrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localLayoutManager, "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "resetToFirstPage", "()V", "Undefined", "scrollToPosition", "(I)V");
      locali.biT = 0;
      locali.uQI = 0;
      locali.uQJ = 0;
      locali.uQL = 0;
    }
    AppMethodBeat.o(302566);
  }
  
  public final void f(List<e> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(302491);
    paramList = new ArrayList(paramList);
    et(paramList);
    Log.i("MicroMsg.BizTimeLineHotListView", "alvinluo refreshData new list: %d, old list: %d, configurationChanged: %b", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(this.eXW.size()), Boolean.valueOf(paramBoolean) });
    Object localObject = new d(this.eXW, paramList);
    if (paramBoolean) {
      ((d)localObject).vPO = true;
    }
    localObject = androidx.recyclerview.widget.g.a((g.a)localObject, true);
    this.eXW.clear();
    this.eXW.addAll(paramList);
    int i = 0;
    while (i < this.eXW.size())
    {
      ((e)this.eXW.get(i)).vPP = i;
      i += 1;
    }
    ((g.b)localObject).a(this.vOy);
    if ((this.vOE) || (this.vOD == null))
    {
      AppMethodBeat.o(302491);
      return;
    }
    if (this.vOB)
    {
      i = getItemPadding();
      int j = c.fP(getContext());
      this.vOF = (i / 2 + j);
      Log.d("MicroMsg.BizTimeLineHotListView", "updateTitlePos originalPaddingLeft=%s， width=%d", new Object[] { Float.valueOf(this.vOF), Integer.valueOf(j) });
      this.vOD.setOftenReadTitlePaddingLeft(this.vOF);
      this.vOD.setVideoTitlePaddingLeft(vOI);
      this.vOG = (j / 2 - vOI);
      Log.d("MicroMsg.BizTimeLineHotListView", "updateTitlePos originalVideoIconMiddle=%s", new Object[] { Float.valueOf(this.vOG) });
      AppMethodBeat.o(302491);
      return;
    }
    this.vOD.setOftenReadTitlePaddingLeft(vOI);
    this.vOD.den();
    AppMethodBeat.o(302491);
  }
  
  public final void fN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(302497);
    if ((Util.isNullOrNil(paramString1)) && (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(302497);
      return;
    }
    if (!Util.isNullOrNil(this.eXW))
    {
      Iterator localIterator = this.eXW.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (!Util.isNullOrNil(paramString1))
        {
          if (Util.isEqual(paramString1, locale.YIf))
          {
            paramString1 = com.tencent.mm.pluginsdk.model.c.XPt;
            com.tencent.mm.pluginsdk.model.c.oY(locale.YIf, locale.YSM);
            c(locale);
            AppMethodBeat.o(302497);
          }
        }
        else if ((!Util.isNullOrNil(paramString2)) && (Util.isEqual(paramString2, locale.YSM)))
        {
          paramString1 = com.tencent.mm.pluginsdk.model.c.XPt;
          com.tencent.mm.pluginsdk.model.c.oY(locale.YIf, locale.YSM);
          c(locale);
          AppMethodBeat.o(302497);
          return;
        }
      }
    }
    AppMethodBeat.o(302497);
  }
  
  public b getAdapter()
  {
    return this.vOy;
  }
  
  public int getCurrentPage()
  {
    if (this.vOx != null) {
      return this.vOx.uQL;
    }
    return 0;
  }
  
  public int getCustomItemCount()
  {
    return 1;
  }
  
  public int getDataCount()
  {
    AppMethodBeat.i(6090);
    int i = this.eXW.size();
    AppMethodBeat.o(6090);
    return i;
  }
  
  public int getItemPadding()
  {
    AppMethodBeat.i(6089);
    int i = c.fN(getContext());
    AppMethodBeat.o(6089);
    return i;
  }
  
  public int getItemWidth()
  {
    AppMethodBeat.i(6092);
    int i = c.ft(getContext());
    AppMethodBeat.o(6092);
    return i;
  }
  
  public int getShowCount()
  {
    if (this.vOE) {
      return 30;
    }
    if (this.vOB) {
      return c.vPL + 1;
    }
    return c.vPL;
  }
  
  protected float getShowCountPerPage()
  {
    AppMethodBeat.i(6091);
    float f = c.getShowCountPerPage();
    AppMethodBeat.o(6091);
    return f;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(302612);
    if (!this.vOE)
    {
      this.vOQ.dead();
      this.vOR.dead();
    }
    AppMethodBeat.o(302612);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(6083);
    super.onDetachedFromWindow();
    Log.d("MicroMsg.BizTimeLineHotListView", "onDetachedFromWindow");
    AppMethodBeat.o(6083);
  }
  
  public void setOnScrollPageListener(i.a parama)
  {
    if (this.vOx != null) {
      this.vOx.vQh = parama;
    }
  }
  
  public final class a
    extends BizTimeLineHotListView.b
  {
    float[] rTA;
    
    public a()
    {
      super();
      AppMethodBeat.i(302296);
      this.rTA = new float[8];
      this$1 = this.rTA;
      float[] arrayOfFloat1 = this.rTA;
      float[] arrayOfFloat2 = this.rTA;
      this.rTA[3] = 0.0F;
      arrayOfFloat2[2] = 0.0F;
      arrayOfFloat1[1] = 0.0F;
      BizTimeLineHotListView.this[0] = 0.0F;
      this$1 = this.rTA;
      arrayOfFloat1 = this.rTA;
      arrayOfFloat2 = this.rTA;
      float[] arrayOfFloat3 = this.rTA;
      float f = BizTimeLineHotListView.vOM - 2;
      arrayOfFloat3[7] = f;
      arrayOfFloat2[6] = f;
      arrayOfFloat1[5] = f;
      BizTimeLineHotListView.this[4] = f;
      AppMethodBeat.o(302296);
    }
    
    private void a(int paramInt, ImageView paramImageView)
    {
      AppMethodBeat.i(302302);
      BizTimeLineHotListView.a.2 local2 = new BizTimeLineHotListView.a.2(this, 0xFF000000 | paramInt);
      PaintDrawable localPaintDrawable = new PaintDrawable();
      localPaintDrawable.setShape(new RectShape());
      localPaintDrawable.setShaderFactory(local2);
      localPaintDrawable.setCornerRadii(this.rTA);
      paramImageView.setBackground(localPaintDrawable);
      AppMethodBeat.o(302302);
    }
    
    public final void a(BizTimeLineHotListView.c paramc, int paramInt)
    {
      AppMethodBeat.i(302319);
      super.a(paramc, paramInt);
      AppMethodBeat.o(302319);
    }
    
    public final void a(final BizTimeLineHotListView.c paramc, e parame, int paramInt)
    {
      AppMethodBeat.i(302341);
      int i = c.fP(BizTimeLineHotListView.this.getContext());
      BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramc, parame, paramInt, i);
      int j = i - BizTimeLineHotListView.vOM;
      int k = j * 4 / 3;
      Log.d("MicroMsg.BizTimeLineHotListView", "live onBindCustomViewHolder postion: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      Object localObject1;
      if ((parame != null) && (parame.type == 1))
      {
        localObject1 = com.tencent.mm.plugin.bizui.a.a.vtB;
        com.tencent.mm.plugin.bizui.a.a.Z(paramc.caK, k);
        a.b.h(paramc.ttT, parame.YIf);
        localObject1 = com.tencent.mm.model.aa.getDisplayName(parame.YIf);
        paramc.titleTv.setText((CharSequence)localObject1);
        paramc.titleTv.setTextSize(0, com.tencent.mm.cd.a.bs(BizTimeLineHotListView.this.getContext(), d.c.SmallestTextSize) * com.tencent.mm.cd.a.jO(BizTimeLineHotListView.this.getContext()));
        localObject1 = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
        com.tencent.mm.plugin.brandservice.ui.b.e.l(paramc.titleTv);
        if (parame.vPS != null)
        {
          Object localObject2 = String.format("finder_live_bg_%s", new Object[] { MD5Util.getMD5String(parame.vPS) });
          localObject1 = (Integer)BizTimeLineHotListView.dev().get(localObject2);
          if (localObject1 != null) {
            a(((Integer)localObject1).intValue(), paramc.vPf);
          }
          String str = parame.vPS;
          localObject1 = paramc.vPe;
          localObject2 = new m.b()
          {
            public final boolean af(Bitmap paramAnonymousBitmap)
            {
              AppMethodBeat.i(302237);
              com.tencent.mm.plugin.ball.f.d.a(paramAnonymousBitmap, new d.a()
              {
                public final void onGetColor(int paramAnonymous2Int)
                {
                  AppMethodBeat.i(302320);
                  BizTimeLineHotListView.dev().put(BizTimeLineHotListView.a.1.this.vPa, Integer.valueOf(paramAnonymous2Int));
                  BizTimeLineHotListView.a.a(BizTimeLineHotListView.a.this, paramAnonymous2Int, BizTimeLineHotListView.a.1.this.vOY.vPf);
                  AppMethodBeat.o(302320);
                }
              });
              AppMethodBeat.o(302237);
              return true;
            }
            
            public final void onFinish() {}
            
            public final void onStart() {}
          };
          str = com.tencent.mm.api.b.U(str, 1);
          int m = d.d.biz_timeline_finder_live_bar_default_bg;
          float f = com.tencent.mm.cd.a.fromDPToPix(BizTimeLineHotListView.this.getContext(), 8);
          com.tencent.mm.modelimage.loader.a locala = r.bKe();
          c.a locala1 = new c.a();
          locala1.oKE = m;
          locala1.oKp = true;
          locala1 = locala1.eG(j, k);
          locala1.oKe = new com.tencent.mm.pluginsdk.ui.applet.n(1);
          locala1.oKN = new com.tencent.mm.pluginsdk.ui.applet.e(1);
          locala1.oKO = new l();
          locala1.fullPath = y.bpF(str);
          locala.a(str, (ImageView)localObject1, locala1.bKx(), null, new m(1, j, k, true, true, f, (m.a)localObject2));
        }
      }
      for (;;)
      {
        BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramc, parame, paramInt, true, i);
        AppMethodBeat.o(302341);
        return;
        localObject1 = com.tencent.mm.plugin.bizui.a.a.vtB;
        com.tencent.mm.plugin.bizui.a.a.Z(paramc.caK, 1);
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(302325);
      int i = super.getItemCount();
      AppMethodBeat.o(302325);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public final BizTimeLineHotListView.c r(ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(302314);
      paramViewGroup = new BizTimeLineHotListView.c(BizTimeLineHotListView.this, af.mU(BizTimeLineHotListView.this.getContext()).inflate(d.f.biz_time_line_finder_live_bar_view_item, paramViewGroup, false));
      AppMethodBeat.o(302314);
      return paramViewGroup;
    }
  }
  
  public class b
    extends RecyclerView.a<BizTimeLineHotListView.c>
  {
    public b() {}
    
    public void a(BizTimeLineHotListView.c paramc, int paramInt)
    {
      AppMethodBeat.i(302324);
      if ((paramInt < BizTimeLineHotListView.b(BizTimeLineHotListView.this).size()) && (paramInt - BizTimeLineHotListView.this.getCustomItemCount() <= BizTimeLineHotListView.this.getShowCount()))
      {
        paramc.caK.setVisibility(0);
        e locale = (e)BizTimeLineHotListView.b(BizTimeLineHotListView.this).get(paramInt);
        if (locale != null)
        {
          locale.position = paramInt;
          paramc.caK.setTag(locale);
        }
        a(paramc, locale, paramInt);
        AppMethodBeat.o(302324);
        return;
      }
      paramc.caK.setVisibility(4);
      a(paramc, null, paramInt);
      AppMethodBeat.o(302324);
    }
    
    public void a(BizTimeLineHotListView.c paramc, e parame, int paramInt)
    {
      boolean bool2 = true;
      AppMethodBeat.i(6077);
      int i = c.fP(BizTimeLineHotListView.this.getContext());
      BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramc, parame, paramInt, i);
      Object localObject;
      boolean bool1;
      if ((parame != null) && (parame.type == 1))
      {
        BizTimeLineHotListView.b(paramc);
        a.b.h(paramc.ttT, parame.YIf);
        localObject = com.tencent.mm.model.aa.getDisplayName(parame.YIf);
        paramc.titleTv.setText((CharSequence)localObject);
        paramc.titleTv.setTextSize(0, com.tencent.mm.cd.a.bs(BizTimeLineHotListView.this.getContext(), d.c.SmallestTextSize) * com.tencent.mm.cd.a.jO(BizTimeLineHotListView.this.getContext()));
        paramc.titleTv.setTextColor(BizTimeLineHotListView.this.getContext().getResources().getColor(d.b.half_alpha_black));
        BizTimeLineHotListView.a(parame, paramc.vPi);
        BizTimeLineHotListView.a(BizTimeLineHotListView.this, parame, paramc);
        paramc.vPj.setVisibility(8);
        paramc.vPn.setVisibility(8);
        paramc.vPm.setVisibility(8);
        paramc.vPl.setVisibility(8);
        bool1 = bool2;
      }
      for (;;)
      {
        BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramc, parame, paramInt, bool1, i);
        AppMethodBeat.o(6077);
        return;
        bool1 = bool2;
        if (parame != null)
        {
          bool1 = bool2;
          if (parame.type == 3)
          {
            bool1 = bool2;
            if ((parame instanceof f))
            {
              localObject = com.tencent.mm.plugin.brandservice.model.d.vBI;
              if (com.tencent.mm.plugin.brandservice.model.d.dcd())
              {
                paramc.uQt.setVisibility(8);
                paramc.tCz.setVisibility(8);
                if (paramc.vPk == null)
                {
                  paramc.vPk = ((ViewStub)paramc.caK.findViewById(d.e.viewstub_video_channel_canvas)).inflate();
                  paramc.vKq = ((BizTLRecCardCanvasView)paramc.vPk.findViewById(d.e.video_channel_canvas));
                }
                localObject = paramc.vKq;
                ((BizTLRecCardCanvasView)localObject).setVisibility(0);
                com.tencent.mm.plugin.brandservice.model.d locald = com.tencent.mm.plugin.brandservice.model.d.vBI;
                ((BizTLRecCardCanvasView)localObject).a(0L, "__biz_video_channel_canvas_id__", "vc", "");
                bool1 = false;
              }
              else
              {
                paramc.vPo.setVisibility(8);
                paramc.vPp.setVisibility(8);
                localObject = (f)parame;
                BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramc, (f)localObject);
                bool1 = bool2;
              }
            }
          }
        }
      }
    }
    
    public int getItemCount()
    {
      AppMethodBeat.i(6075);
      if (Util.isNullOrNil(BizTimeLineHotListView.b(BizTimeLineHotListView.this)))
      {
        AppMethodBeat.o(6075);
        return 0;
      }
      int j = BizTimeLineHotListView.b(BizTimeLineHotListView.this).size();
      int k = c.getCompletelyCountPerPage();
      int i = j;
      if (BizTimeLineHotListView.this.getCustomItemCount() == 1) {
        i = j - 1;
      }
      j = i;
      if (i > BizTimeLineHotListView.this.getShowCount()) {
        j = BizTimeLineHotListView.this.getShowCount();
      }
      if (BizTimeLineHotListView.this.getCustomItemCount() == 1)
      {
        if (j % k == 0) {}
        for (i = j + 1;; i = j + (k + 1 - j % k))
        {
          j = BizTimeLineHotListView.this.getCustomItemCount();
          AppMethodBeat.o(6075);
          return i + j;
        }
      }
      i = j;
      if (j % k != 0) {
        i = j + (k - j % k);
      }
      AppMethodBeat.o(6075);
      return i;
    }
    
    public int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(6076);
      if ((paramInt < BizTimeLineHotListView.b(BizTimeLineHotListView.this).size()) && (paramInt - BizTimeLineHotListView.this.getCustomItemCount() <= BizTimeLineHotListView.this.getShowCount()))
      {
        e locale = (e)BizTimeLineHotListView.b(BizTimeLineHotListView.this).get(paramInt);
        if ((locale != null) && (locale.type == 3) && ((locale instanceof f)))
        {
          AppMethodBeat.o(6076);
          return 1;
        }
      }
      AppMethodBeat.o(6076);
      return 0;
    }
    
    public BizTimeLineHotListView.c r(ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(302317);
      paramViewGroup = new BizTimeLineHotListView.c(BizTimeLineHotListView.this, af.mU(BizTimeLineHotListView.this.getContext()).inflate(d.f.biz_time_line_hot_view_item, paramViewGroup, false));
      AppMethodBeat.o(302317);
      return paramViewGroup;
    }
  }
  
  public final class c
    extends RecyclerView.v
  {
    public View caK;
    public View tCz;
    public TextView titleTv;
    public ImageView ttT;
    public ImageView uAt;
    public RelativeLayout uQt;
    public BizTLRecCardCanvasView vKq;
    public ImageView vPe;
    public ImageView vPf;
    public RelativeLayout vPg;
    public ImageView vPh;
    public ImageView vPi;
    public ImageView vPj;
    public View vPk;
    public TextView vPl;
    public ImageView vPm;
    public ImageView vPn;
    public ImageView vPo;
    public BizTagTextView vPp;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(6080);
      this.vPk = null;
      this.vPl = null;
      this.vPm = null;
      this.vPn = null;
      this.vPo = null;
      this.vPp = null;
      this.caK = paramView;
      com.tencent.mm.plugin.bizui.a.a locala = com.tencent.mm.plugin.bizui.a.a.vtB;
      locala = com.tencent.mm.plugin.bizui.a.a.vtB;
      com.tencent.mm.plugin.bizui.a.a.Y(paramView, com.tencent.mm.plugin.bizui.a.a.fK(BizTimeLineHotListView.this.getContext()) / 4);
      this.ttT = ((ImageView)paramView.findViewById(d.e.biz_time_line_hot_view_item_icon));
      this.vPe = ((ImageView)paramView.findViewById(d.e.biz_time_line_finder_live_item_cover_iv));
      this.vPf = ((ImageView)paramView.findViewById(d.e.biz_time_line_finder_live_item_cover_bg_iv));
      this.uAt = ((ImageView)paramView.findViewById(d.e.biz_time_line_hot_view_item_icon_bg));
      this.uQt = ((RelativeLayout)paramView.findViewById(d.e.biz_time_line_hot_view_item_icon_layout));
      this.vPg = ((RelativeLayout)paramView.findViewById(d.e.biz_time_line_hot_view_gap_layout));
      this.vPh = ((ImageView)paramView.findViewById(d.e.biz_time_line_hot_view_gap_iv));
      this.tCz = paramView.findViewById(d.e.biz_time_line_hot_view_item_title_layout);
      this.titleTv = ((TextView)paramView.findViewById(d.e.biz_time_line_hot_view_item_title));
      this.vPi = ((ImageView)paramView.findViewById(d.e.biz_time_line_hot_view_item_unread_dot));
      this.vPj = ((ImageView)paramView.findViewById(d.e.biz_time_line_hot_view_item_right_arrow));
      this.vPl = ((TextView)paramView.findViewById(d.e.biz_time_line_hot_view_item_green_unread_tv));
      this.vPm = ((ImageView)paramView.findViewById(d.e.biz_time_line_hot_view_item_right_top_unread_dot));
      this.vPn = ((ImageView)paramView.findViewById(d.e.biz_time_line_hot_view_item_small_avatar));
      this.vPo = ((ImageView)paramView.findViewById(d.e.biz_time_line_hot_view_item_live_circle));
      this.vPp = ((BizTagTextView)paramView.findViewById(d.e.biz_time_line_hot_view_item_live_title));
      AppMethodBeat.o(6080);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView
 * JD-Core Version:    0.7.0.1
 */