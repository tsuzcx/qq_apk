package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.h.a;
import androidx.recyclerview.widget.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.as;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.bizui.widget.BizTagTextView;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.c;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.f.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.g.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardCanvasView;
import com.tencent.mm.pluginsdk.model.b.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.ddx;
import com.tencent.mm.protocal.protobuf.dea;
import com.tencent.mm.protocal.protobuf.fbe;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;

public class BizTimeLineHotListView
  extends MRecyclerView
  implements com.tencent.mm.vending.e.a
{
  public static int sJb;
  private int mScreenWidth;
  private List<d> rbc;
  private i sIQ;
  private a sIR;
  private float sIS;
  private int sIT;
  boolean sIU;
  private h sIV;
  private k sIW;
  private boolean sIX;
  private float sIY;
  private float sIZ;
  private float sJa;
  private IListener<as> sJc;
  private boolean sJd;
  
  public BizTimeLineHotListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(6081);
    this.rbc = new ArrayList();
    this.sIS = 0.0F;
    this.mScreenWidth = 0;
    this.sIT = 0;
    this.sIU = false;
    this.sIX = false;
    this.sIY = 0.0F;
    this.sIZ = 0.0F;
    this.sJa = 0.0F;
    this.sJc = new IListener() {};
    this.sJd = true;
    init();
    AppMethodBeat.o(6081);
  }
  
  public BizTimeLineHotListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(6082);
    this.rbc = new ArrayList();
    this.sIS = 0.0F;
    this.mScreenWidth = 0;
    this.sIT = 0;
    this.sIU = false;
    this.sIX = false;
    this.sIY = 0.0F;
    this.sIZ = 0.0F;
    this.sJa = 0.0F;
    this.sJc = new IListener() {};
    this.sJd = true;
    init();
    AppMethodBeat.o(6082);
  }
  
  private static boolean GQ(int paramInt)
  {
    AppMethodBeat.i(257744);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(257744);
      return false;
    }
    int i = MultiProcessMMKV.getSingleMMKV("MicroMsg.BizTimeLineHotListView").decodeInt("VideoChannelTopBarVersion", 0);
    Log.i("MicroMsg.BizTimeLineHotListView", "getVideoChannelUnReadState, version: %d, lastVersion: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if (paramInt > i)
    {
      AppMethodBeat.o(257744);
      return true;
    }
    AppMethodBeat.o(257744);
    return false;
  }
  
  private static void a(b paramb)
  {
    AppMethodBeat.i(257760);
    paramb.rFh.setVisibility(0);
    paramb.sJi.setVisibility(0);
    if (paramb.sEI != null) {
      paramb.sEI.setVisibility(8);
    }
    AppMethodBeat.o(257760);
  }
  
  private void a(d paramd, b paramb)
  {
    AppMethodBeat.i(257741);
    com.tencent.mm.pluginsdk.model.b localb;
    if (!this.sIX)
    {
      localb = com.tencent.mm.pluginsdk.model.b.QTJ;
      if (!com.tencent.mm.pluginsdk.model.b.hgd()) {}
    }
    else
    {
      if (!Util.isNullOrNil(paramd.RVp)) {
        break label72;
      }
      localb = com.tencent.mm.pluginsdk.model.b.QTJ;
      if (com.tencent.mm.pluginsdk.model.b.bpt(paramd.RKL)) {
        break label72;
      }
    }
    paramb.sJp.setVisibility(8);
    paramb.sJq.setVisibility(8);
    AppMethodBeat.o(257741);
    return;
    label72:
    if (this.sIX)
    {
      localb = com.tencent.mm.pluginsdk.model.b.QTJ;
      if (com.tencent.mm.pluginsdk.model.b.nh(paramd.RKL, paramd.RVp)) {}
    }
    else
    {
      if ((this.sIX) || (!com.tencent.mm.pluginsdk.model.b.QTJ.ng(paramd.RKL, paramd.RVp))) {
        break label182;
      }
    }
    paramb.sJp.setVisibility(0);
    for (;;)
    {
      paramb.sJq.setVisibility(0);
      paramb.sJq.setTextSize(1, 8.0F);
      paramb.sJq.cxS();
      paramb.sJq.setFillColor(getContext().getResources().getColor(d.b.biz_finder_live_logo_color));
      AppMethodBeat.o(257741);
      return;
      label182:
      paramb.sJp.setVisibility(8);
    }
  }
  
  private static void a(f paramf, fbe paramfbe)
  {
    AppMethodBeat.i(257755);
    if ((paramf != null) && (paramfbe != null))
    {
      paramf.title = paramfbe.title;
      paramf.mOZ = paramfbe.UBe;
      paramf.appId = paramfbe.appid;
      paramf.llI = paramfbe.llI;
      paramf.sJZ = paramfbe.UAY;
      paramf.appVersion = paramfbe.version;
      paramf.sJX = paramfbe.UAX;
      paramf.sJY = paramfbe.UBb;
      paramf.sJW = GQ(paramfbe.UAX);
    }
    AppMethodBeat.o(257755);
  }
  
  private void cB(List<d> paramList)
  {
    AppMethodBeat.i(6093);
    if (paramList == null)
    {
      AppMethodBeat.o(6093);
      return;
    }
    d locald = new d(2);
    locald.RKL = "__BizTimeLine.CustomItem__";
    paramList.add(0, locald);
    cC(paramList);
    AppMethodBeat.o(6093);
  }
  
  private void cBk()
  {
    AppMethodBeat.i(257764);
    if ((this.sIX) || (this.sIW == null))
    {
      AppMethodBeat.o(257764);
      return;
    }
    if (this.sIU)
    {
      int i = getItemPadding();
      int j = b.eS(getContext());
      this.sIY = (i / 2 + j);
      Log.d("MicroMsg.BizTimeLineHotListView", "updateTitlePos originalPaddingLeft=%s， width=%d", new Object[] { Float.valueOf(this.sIY), Integer.valueOf(j) });
      this.sIW.setOftenReadTitlePaddingLeft(this.sIY);
      this.sIW.setVideoTitlePaddingLeft(sJb);
      this.sIZ = (j / 2 - sJb);
      Log.d("MicroMsg.BizTimeLineHotListView", "updateTitlePos originalVideoIconMiddle=%s", new Object[] { Float.valueOf(this.sIZ) });
      AppMethodBeat.o(257764);
      return;
    }
    this.sIW.setOftenReadTitlePaddingLeft(sJb);
    this.sIW.cBe();
    AppMethodBeat.o(257764);
  }
  
  private void cC(List<d> paramList)
  {
    AppMethodBeat.i(175433);
    if ((paramList == null) || (this.sIX))
    {
      AppMethodBeat.o(175433);
      return;
    }
    if (com.tencent.mm.plugin.brandservice.b.d.cyY())
    {
      Log.i("MicroMsg.BizTimeLineHotListView", "alvinluo addCustomItems timeline top bar entry is open");
      f localf = new f();
      fbe localfbe = com.tencent.mm.plugin.brandservice.b.d.cza();
      if (localfbe != null)
      {
        localf.RKL = "__BizTimeLine.VideoChannelEntry__";
        a(localf, localfbe);
        paramList.add(1, localf);
        localf.position = 1;
        this.sIU = true;
      }
    }
    AppMethodBeat.o(175433);
  }
  
  private void g(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(257745);
    Log.d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha pos: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramv != null)
    {
      float f = paramv.amk.getX();
      if (f >= this.mScreenWidth - getItemWidth() / 2)
      {
        paramv.amk.setAlpha(0.3F);
        AppMethodBeat.o(257745);
        return;
      }
      if ((f < this.mScreenWidth - getItemWidth() / 2) && (f >= this.sIS))
      {
        f = 1.0F - (f - this.sIS) / this.sIT * 0.7F;
        Log.d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha %f", new Object[] { Float.valueOf(f) });
        paramv.amk.setAlpha(f);
        AppMethodBeat.o(257745);
        return;
      }
      paramv.amk.setAlpha(1.0F);
    }
    AppMethodBeat.o(257745);
  }
  
  private void init()
  {
    AppMethodBeat.i(175432);
    Log.v("MicroMsg.BizTimeLineHotListView", "alvinluo init");
    if ((getContext() instanceof MMFragmentActivity)) {
      ((MMFragmentActivity)getContext()).keep(this);
    }
    sJb = com.tencent.mm.ci.a.fromDPToPix(getContext(), 16);
    setItemAnimator(null);
    AppMethodBeat.o(175432);
  }
  
  public final void a(Context paramContext, List<d> paramList, h paramh, k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(257742);
    this.sIV = paramh;
    this.sIW = paramk;
    this.sIX = paramBoolean;
    this.rbc.addAll(paramList);
    cB(this.rbc);
    this.sIR = new a();
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
    setAdapter(this.sIR);
    this.sIQ = new i(getCustomItemCount());
    paramList = this.sIQ;
    int i = b.getCompletelyCountPerPage();
    paramList.mContext = paramContext;
    paramList.sKf = this;
    paramList.rFA = i;
    paramList.sKf.b(paramList);
    paramList.sKf.a(paramList);
    paramList.rFD = ((LinearLayoutManager)paramList.sKf.getLayoutManager());
    paramList.mSmoothScroller = new i.1(paramList, paramList.sKf.getContext());
    paramList.rFy = new i.2(paramList, paramList.sKf.getContext());
    setOnScrollPageListener(new i.a()
    {
      public final void GR(int paramAnonymousInt)
      {
        AppMethodBeat.i(265929);
        int i = BizTimeLineHotListView.this.getCurrentPage();
        Log.d("MicroMsg.BizTimeLineHotListView", "alvinluo ScrollPageListener onScrolled offsetOfCurPage: %d, , currentPage: %d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
        BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramAnonymousInt, i);
        BizTimeLineHotListView.f(BizTimeLineHotListView.this);
        AppMethodBeat.o(265929);
      }
      
      public final void Z(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(265930);
        if (!paramAnonymousBoolean)
        {
          int i = (int)(System.currentTimeMillis() / 1000L);
          com.tencent.mm.plugin.report.service.h.IzE.a(15721, new Object[] { "", Integer.valueOf(0), Integer.valueOf(10), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.storage.ab.getSessionId()) });
        }
        BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramAnonymousInt);
        BizTimeLineHotListView.this.cBd();
        AppMethodBeat.o(265930);
      }
    });
    setOnItemClickListener(new MRecyclerView.a()
    {
      public final void U(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(258035);
        Object localObject1 = (d)BizTimeLineHotListView.b(BizTimeLineHotListView.this).get(paramAnonymousInt);
        if (localObject1 == null)
        {
          AppMethodBeat.o(258035);
          return;
        }
        Object localObject2 = BizTimeLineHotListView.e(BizTimeLineHotListView.this);
        boolean bool = BizTimeLineHotListView.a(BizTimeLineHotListView.this);
        Object localObject3;
        if (localObject1 != null)
        {
          if (((d)localObject1).type != 1) {
            break label290;
          }
          localObject3 = new ddx();
          ((ddx)localObject3).RVH = ((d)localObject1).RKL;
          ((ddx)localObject3).CLe = (((d)localObject1).position - 1);
          ((ddx)localObject3).TLx = ((int)(System.currentTimeMillis() / 1000L));
          if (((d)localObject1).sJW)
          {
            paramAnonymousInt = 1;
            ((ddx)localObject3).TLw = paramAnonymousInt;
            ((ddx)localObject3).type = 0;
            if (!bool) {
              break label285;
            }
            paramAnonymousInt = 1;
            label137:
            ((ddx)localObject3).TLC = paramAnonymousInt;
            ((ddx)localObject3).TLD = h.e((d)localObject1);
            ((ddx)localObject3).TLE = ((d)localObject1).RVp;
            ((ddx)localObject3).knL = ((d)localObject1).RVq;
            ((h)localObject2).sKc.add(localObject3);
            localObject2 = com.tencent.mm.pluginsdk.model.b.QTJ;
            com.tencent.mm.pluginsdk.model.b.a(((d)localObject1).RKL, null);
          }
        }
        else
        {
          label198:
          if (!BizTimeLineHotListView.c((d)localObject1)) {
            break label566;
          }
          if (!BizTimeLineHotListView.a(BizTimeLineHotListView.this)) {
            break label555;
          }
          paramAnonymousView = b.b.QUa;
        }
        label285:
        label290:
        Object localObject4;
        for (paramAnonymousInt = b.b.hgA();; paramAnonymousInt = b.b.hgz())
        {
          com.tencent.mm.pluginsdk.model.b.QTJ.b(BizTimeLineHotListView.this.getContext(), ((d)localObject1).RKL, ((d)localObject1).RVp, paramAnonymousInt, ((d)localObject1).RVq);
          paramAnonymousView = com.tencent.mm.pluginsdk.model.b.QTJ;
          com.tencent.mm.pluginsdk.model.b.bpx(((d)localObject1).RKL);
          BizTimeLineHotListView.this.b((d)localObject1);
          AppMethodBeat.o(258035);
          return;
          paramAnonymousInt = 0;
          break;
          paramAnonymousInt = 0;
          break label137;
          if (((d)localObject1).type != 3) {
            break label198;
          }
          localObject3 = new ddx();
          long l = System.currentTimeMillis();
          ((ddx)localObject3).CLe = (((d)localObject1).position - 1);
          ((ddx)localObject3).TLx = ((int)(l / 1000L));
          localObject4 = com.tencent.mm.plugin.brandservice.b.d.swc;
          if (com.tencent.mm.plugin.brandservice.b.d.czj())
          {
            paramAnonymousInt = 2;
            label350:
            ((ddx)localObject3).type = paramAnonymousInt;
            ((ddx)localObject3).llI = com.tencent.mm.plugin.brandservice.b.d.swc.lv(false);
            if (!com.tencent.mm.plugin.brandservice.b.d.swc.czg()) {
              break label540;
            }
            paramAnonymousInt = 1;
            label379:
            ((ddx)localObject3).TLz = paramAnonymousInt;
            localObject4 = com.tencent.mm.plugin.brandservice.b.d.swc;
            ((ddx)localObject3).TLy = com.tencent.mm.plugin.brandservice.b.d.czh();
            if (!com.tencent.mm.plugin.brandservice.b.d.swc.czf()) {
              break label545;
            }
            paramAnonymousInt = 1;
            label409:
            ((ddx)localObject3).TLA = paramAnonymousInt;
            ((ddx)localObject3).TLB = l;
            Log.d("MicroMsg.BizTimeLineOftenReadReport", "onClick is_default_icon %d, is_icon_cache %d", new Object[] { Integer.valueOf(((ddx)localObject3).TLA), Integer.valueOf(((ddx)localObject3).TLz) });
            ((h)localObject2).sKc.add(localObject3);
            localObject2 = com.tencent.mm.plugin.brandservice.b.d.swc;
            if (!com.tencent.mm.plugin.brandservice.b.d.czj()) {
              break label550;
            }
          }
          label540:
          label545:
          label550:
          for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(21258, new Object[] { Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(0), com.tencent.mm.pluginsdk.ui.tools.ab.aXb(((ddx)localObject3).llI), Integer.valueOf(paramAnonymousInt) });
            break;
            paramAnonymousInt = 1;
            break label350;
            paramAnonymousInt = 0;
            break label379;
            paramAnonymousInt = 0;
            break label409;
          }
          label555:
          paramAnonymousView = b.b.QUa;
        }
        label566:
        if (((d)localObject1).type == 1)
        {
          if (com.tencent.mm.model.ab.Ql(((d)localObject1).RKL))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Chat_User", ((d)localObject1).RKL);
            paramAnonymousView.putExtra("finish_direct", true);
            paramAnonymousView.putExtra("KOpenArticleSceneFromScene", 91);
            paramAnonymousView.putExtra("specific_chat_from_scene", 8);
            paramAnonymousView.putExtra("preChatTYPE", 12);
            com.tencent.mm.by.c.f(BizTimeLineHotListView.this.getContext(), ".ui.chatting.ChattingUI", paramAnonymousView);
            ((d)localObject1).sJW = false;
            BizTimeLineHotListView.this.a((d)localObject1);
            if (!(BizTimeLineHotListView.this.getContext() instanceof BizTimeLineUI)) {
              break label958;
            }
            localObject2 = ((BizTimeLineUI)BizTimeLineHotListView.this.getContext()).szZ;
            paramAnonymousView = ((d)localObject1).RKL;
            if (((com.tencent.mm.plugin.brandservice.ui.timeline.f)localObject2).dataList.size() > 0)
            {
              localObject1 = g.sBS;
              localObject1 = (z)((com.tencent.mm.plugin.brandservice.ui.timeline.f)localObject2).dataList.get(0);
              localObject3 = ((com.tencent.mm.plugin.brandservice.ui.timeline.f)localObject2).dataList;
              localObject2 = ((com.tencent.mm.plugin.brandservice.ui.timeline.f)localObject2).sBC;
              p.k(localObject1, "info");
              p.k(localObject2, "sessionItemCache");
              localObject4 = ad.Vfe;
              if ((!ad.hxt()) || ((g.bcJ().decodeInt("ReSortBizMsgFlag", 0) & 0x2) == 0)) {
                break label914;
              }
            }
          }
          for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
          {
            if ((paramAnonymousInt != 0) && (paramAnonymousView != null) && (localObject3 != null)) {
              com.tencent.e.h.ZvG.bc((Runnable)new g.d((z)localObject1, (List)localObject3, (f.c)localObject2, paramAnonymousView));
            }
            AppMethodBeat.o(258035);
            return;
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", ((d)localObject1).RKL);
            paramAnonymousView.putExtra("Contact_Scene", 174);
            paramAnonymousView.putExtra("force_get_contact", true);
            paramAnonymousView.putExtra("key_use_new_contact_profile", true);
            com.tencent.mm.by.c.b(BizTimeLineHotListView.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
            break;
          }
        }
        else if (((d)localObject1).type == 3)
        {
          Log.i("MicroMsg.BizTimeLineHotListView", "alvinluo onClick jump to video channel");
          if ((localObject1 instanceof f)) {
            BizTimeLineHotListView.a(BizTimeLineHotListView.this, (f)localObject1, paramAnonymousView);
          }
        }
        label914:
        label958:
        AppMethodBeat.o(258035);
      }
    });
    if (!paramBoolean) {
      this.sJc.alive();
    }
    AppMethodBeat.o(257742);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(257739);
    if (paramd == null)
    {
      AppMethodBeat.o(257739);
      return;
    }
    b localb = (b)cK(paramd.position);
    if (localb == null)
    {
      Log.e("MicroMsg.BizTimeLineHotListView", "refreshUnread %s", new Object[] { paramd.RKL });
      AppMethodBeat.o(257739);
      return;
    }
    if (paramd.sJW)
    {
      localb.sJj.setVisibility(0);
      AppMethodBeat.o(257739);
      return;
    }
    localb.sJj.setVisibility(8);
    AppMethodBeat.o(257739);
  }
  
  public final boolean ay(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(6088);
    i locali = this.sIQ;
    locali.W(locali.Ek(locali.CL + paramInt1), false);
    boolean bool = super.ay(paramInt1, paramInt2);
    AppMethodBeat.o(6088);
    return bool;
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(257740);
    if (paramd == null)
    {
      AppMethodBeat.o(257740);
      return;
    }
    b localb = (b)cK(paramd.position);
    if (localb == null)
    {
      Log.e("MicroMsg.BizTimeLineHotListView", "refreshUnread %s", new Object[] { paramd.RKL });
      AppMethodBeat.o(257740);
      return;
    }
    a(paramd, localb);
    AppMethodBeat.o(257740);
  }
  
  public final void b(List<d> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(257738);
    paramList = new ArrayList(paramList);
    cB(paramList);
    Log.i("MicroMsg.BizTimeLineHotListView", "alvinluo refreshData new list: %d, old list: %d, configurationChanged: %b", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(this.rbc.size()), Boolean.valueOf(paramBoolean) });
    Object localObject = new c(this.rbc, paramList);
    if (paramBoolean) {
      ((c)localObject).sJU = true;
    }
    localObject = androidx.recyclerview.widget.h.a((h.a)localObject, true);
    this.rbc.clear();
    this.rbc.addAll(paramList);
    int i = 0;
    while (i < this.rbc.size())
    {
      ((d)this.rbc.get(i)).sJV = i;
      i += 1;
    }
    ((h.b)localObject).a(this.sIR);
    cBk();
    AppMethodBeat.o(257738);
  }
  
  public final void cBd()
  {
    AppMethodBeat.i(6085);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.rbc);
    int m = getCurrentPage();
    int j = i.En(m);
    int k = i.GT(m);
    int i = j;
    if (m == 0) {
      i = j + 1;
    }
    if ((i <= k) && (i < localArrayList.size()))
    {
      Object localObject1 = (d)localArrayList.get(i);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.pluginsdk.model.b.QTJ;
        if (!Util.isNullOrNil(com.tencent.mm.pluginsdk.model.b.hgj())) {
          break label314;
        }
        this.sJd = false;
        label109:
        localObject2 = this.sIV;
        boolean bool = this.sIX;
        if (localObject1 != null)
        {
          if (((d)localObject1).type != 1) {
            break label444;
          }
          localdea = (dea)((h)localObject2).sKb.get(((d)localObject1).RKL);
          if (localdea != null) {
            break label377;
          }
          localdea = new dea();
          localdea.RVH = ((d)localObject1).RKL;
          if (!((d)localObject1).sJW) {
            break label367;
          }
          j = 1;
          localdea.TLw = j;
          localdea.TLx = ((int)(System.currentTimeMillis() / 1000L));
          localdea.CLe = (((d)localObject1).position - 1);
          localdea.tmI = 1;
          localdea.type = 0;
          if (!bool) {
            break label372;
          }
          j = 1;
          localdea.TLC = j;
          localdea.TLD = h.e((d)localObject1);
          localdea.TLE = ((d)localObject1).RVp;
          localdea.knL = ((d)localObject1).RVq;
          ((h)localObject2).sKb.put(((d)localObject1).RKL, localdea);
          localObject2 = com.tencent.mm.pluginsdk.model.b.QTJ;
          com.tencent.mm.pluginsdk.model.b.nj(((d)localObject1).RKL, ((d)localObject1).RVp);
        }
      }
      label314:
      label367:
      label372:
      label377:
      while (((d)localObject1).type != 3)
      {
        for (;;)
        {
          i += 1;
          break;
          localObject2 = com.tencent.mm.pluginsdk.model.b.QTJ;
          if ((!com.tencent.mm.pluginsdk.model.b.bpt(((d)localObject1).RKL)) || (!this.sJd)) {
            break label109;
          }
          this.sJd = false;
          com.tencent.e.h.ZvG.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(265171);
              com.tencent.mm.pluginsdk.model.b localb = com.tencent.mm.pluginsdk.model.b.QTJ;
              com.tencent.mm.pluginsdk.model.b.bpx(this.sJf.RKL);
              if (Util.isNullOrNil(this.sJf.RVp)) {
                BizTimeLineHotListView.this.b(this.sJf);
              }
              AppMethodBeat.o(265171);
            }
          }, 2000L);
          break label109;
          j = 0;
          continue;
          j = 0;
        }
        if (((d)localObject1).sJW) {}
        for (j = 1;; j = 0)
        {
          localdea.TLw = j;
          localdea.TLx = ((int)(System.currentTimeMillis() / 1000L));
          localdea.CLe = (((d)localObject1).position - 1);
          localdea.type = 0;
          localdea.tmI += 1;
          break;
        }
      }
      label444:
      dea localdea = new dea();
      long l = System.currentTimeMillis();
      localdea.TLx = ((int)(l / 1000L));
      localdea.CLe = (((d)localObject1).position - 1);
      localdea.tmI = 1;
      com.tencent.mm.plugin.brandservice.b.d locald = com.tencent.mm.plugin.brandservice.b.d.swc;
      if (com.tencent.mm.plugin.brandservice.b.d.czj())
      {
        j = 2;
        label510:
        localdea.type = j;
        localdea.llI = com.tencent.mm.plugin.brandservice.b.d.swc.lv(false);
        if (!com.tencent.mm.plugin.brandservice.b.d.swc.czg()) {
          break label688;
        }
        j = 1;
        label539:
        localdea.TLz = j;
        locald = com.tencent.mm.plugin.brandservice.b.d.swc;
        localdea.TLy = com.tencent.mm.plugin.brandservice.b.d.czh();
        if (!com.tencent.mm.plugin.brandservice.b.d.swc.czf()) {
          break label693;
        }
        j = 1;
        label569:
        localdea.TLA = j;
        j = h.sKd;
        h.sKd = j + 1;
        localdea.TLI = j;
        localdea.TLB = l;
        ((h)localObject2).sKb.put(((d)localObject1).RKL, localdea);
        localObject1 = com.tencent.mm.plugin.brandservice.b.d.swc;
        if (!com.tencent.mm.plugin.brandservice.b.d.czj()) {
          break label698;
        }
      }
      label688:
      label693:
      label698:
      for (j = 1;; j = 0)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(21258, new Object[] { Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(0), com.tencent.mm.pluginsdk.ui.tools.ab.aXb(localdea.llI), Integer.valueOf(j) });
        break;
        j = 1;
        break label510;
        j = 0;
        break label539;
        j = 0;
        break label569;
      }
    }
    AppMethodBeat.o(6085);
  }
  
  public final boolean cBi()
  {
    return this.sIU;
  }
  
  public final void cBj()
  {
    AppMethodBeat.i(257748);
    if (this.sIQ != null)
    {
      i locali = this.sIQ;
      RecyclerView.LayoutManager localLayoutManager = locali.sKf.getLayoutManager();
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localLayoutManager, locala.aFh(), "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "resetToFirstPage", "()V", "Undefined", "scrollToPosition", "(I)V");
      localLayoutManager.scrollToPosition(((Integer)locala.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localLayoutManager, "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineViewPagerHelper", "resetToFirstPage", "()V", "Undefined", "scrollToPosition", "(I)V");
      locali.CL = 0;
      locali.rFw = 0;
      locali.rFx = 0;
      locali.rFz = 0;
    }
    AppMethodBeat.o(257748);
  }
  
  public final boolean cqo()
  {
    return false;
  }
  
  public final void cs(List<d> paramList)
  {
    AppMethodBeat.i(6084);
    b(paramList, false);
    AppMethodBeat.o(6084);
  }
  
  public void dead()
  {
    AppMethodBeat.i(293044);
    Log.d("MicroMsg.BizTimeLineHotListView", "dead");
    com.tencent.e.h.ZvG.n(new BizTimeLineHotListView.7(this), 3000L);
    AppMethodBeat.o(293044);
  }
  
  public a getAdapter()
  {
    return this.sIR;
  }
  
  public int getCurrentPage()
  {
    if (this.sIQ != null) {
      return this.sIQ.rFz;
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
    int i = this.rbc.size();
    AppMethodBeat.o(6090);
    return i;
  }
  
  public int getItemPadding()
  {
    AppMethodBeat.i(6089);
    int i = b.eQ(getContext());
    AppMethodBeat.o(6089);
    return i;
  }
  
  public int getItemWidth()
  {
    AppMethodBeat.i(6092);
    int i = b.ex(getContext());
    AppMethodBeat.o(6092);
    return i;
  }
  
  public int getShowCount()
  {
    if (this.sIU) {
      return b.sJR + 1;
    }
    return b.sJR;
  }
  
  protected float getShowCountPerPage()
  {
    AppMethodBeat.i(6091);
    float f = b.getShowCountPerPage();
    AppMethodBeat.o(6091);
    return f;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(257758);
    if (!this.sIX) {
      this.sJc.dead();
    }
    AppMethodBeat.o(257758);
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
    if (this.sIQ != null) {
      this.sIQ.sKh = parama;
    }
  }
  
  public class a
    extends RecyclerView.a<BizTimeLineHotListView.b>
  {
    public a() {}
    
    private void a(BizTimeLineHotListView.b paramb, d paramd, int paramInt)
    {
      AppMethodBeat.i(6077);
      int j = BizTimeLineHotListView.this.getItemWidth();
      float f = BizTimeLineHotListView.this.getShowCountPerPage();
      int i = j;
      if (paramInt == BizTimeLineHotListView.d(BizTimeLineHotListView.this).getItemCount() - 1)
      {
        double d = j;
        i = (int)((1.0D - (Math.ceil(f) - f)) * d);
        Log.i("MicroMsg.BizTimeLineHotListView", "alvinluo lastPosition %d set width %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      }
      j = i;
      if (paramd != null)
      {
        j = i;
        if (paramd.type == 3) {
          j = b.eS(BizTimeLineHotListView.this.getContext());
        }
      }
      paramb.amk.getLayoutParams().width = j;
      paramb.amk.setScaleX(1.0F);
      paramb.amk.setScaleY(1.0F);
      Log.d("MicroMsg.BizTimeLineHotListView", "alvinluo onBindCustomViewHolder postion: %d, width: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j) });
      Object localObject;
      boolean bool;
      if ((paramd != null) && (paramd.type == 1))
      {
        BizTimeLineHotListView.b(paramb);
        a.b.d(paramb.qps, paramd.RKL);
        localObject = aa.PJ(paramd.RKL);
        paramb.titleTv.setText((CharSequence)localObject);
        paramb.titleTv.setTextSize(0, com.tencent.mm.ci.a.aZ(BizTimeLineHotListView.this.getContext(), d.c.SmallestTextSize) * com.tencent.mm.ci.a.km(BizTimeLineHotListView.this.getContext()));
        paramb.titleTv.setTextColor(BizTimeLineHotListView.this.getContext().getResources().getColor(d.b.half_alpha_black));
        localObject = paramb.sJj;
        if (paramd.sJW)
        {
          i = 0;
          ((ImageView)localObject).setVisibility(i);
          BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramd, paramb);
          paramb.sJk.setVisibility(8);
          paramb.sJo.setVisibility(8);
          paramb.sJn.setVisibility(8);
          paramb.sJm.setVisibility(8);
          bool = true;
        }
      }
      for (;;)
      {
        BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramb, paramd, paramInt, bool);
        AppMethodBeat.o(6077);
        return;
        i = 8;
        break;
        if ((paramd != null) && (paramd.type == 3) && ((paramd instanceof f)))
        {
          localObject = com.tencent.mm.plugin.brandservice.b.d.swc;
          if (com.tencent.mm.plugin.brandservice.b.d.czj())
          {
            paramb.rFh.setVisibility(8);
            paramb.sJi.setVisibility(8);
            if (paramb.sJl == null)
            {
              paramb.sJl = ((ViewStub)paramb.amk.findViewById(d.e.stB)).inflate();
              paramb.sEI = ((BizTLRecCardCanvasView)paramb.sJl.findViewById(d.e.stl));
            }
            localObject = paramb.sEI;
            ((BizTLRecCardCanvasView)localObject).setVisibility(0);
            com.tencent.mm.plugin.brandservice.b.d locald = com.tencent.mm.plugin.brandservice.b.d.swc;
            ((BizTLRecCardCanvasView)localObject).a(0L, "__biz_video_channel_canvas_id__", "vc", "");
            bool = false;
          }
          else
          {
            paramb.sJp.setVisibility(8);
            paramb.sJq.setVisibility(8);
            localObject = (f)paramd;
            BizTimeLineHotListView.a(BizTimeLineHotListView.this, paramb, (f)localObject);
          }
        }
        else
        {
          bool = true;
        }
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(6075);
      if (Util.isNullOrNil(BizTimeLineHotListView.b(BizTimeLineHotListView.this)))
      {
        AppMethodBeat.o(6075);
        return 0;
      }
      int j = BizTimeLineHotListView.b(BizTimeLineHotListView.this).size();
      int k = b.getCompletelyCountPerPage();
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
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(6076);
      if ((paramInt < BizTimeLineHotListView.b(BizTimeLineHotListView.this).size()) && (paramInt - BizTimeLineHotListView.this.getCustomItemCount() <= BizTimeLineHotListView.this.getShowCount()))
      {
        d locald = (d)BizTimeLineHotListView.b(BizTimeLineHotListView.this).get(paramInt);
        if ((locald != null) && (locald.type == 3) && ((locald instanceof f)))
        {
          AppMethodBeat.o(6076);
          return 1;
        }
      }
      AppMethodBeat.o(6076);
      return 0;
    }
  }
  
  public final class b
    extends RecyclerView.v
  {
    public View amk;
    public ImageView qps;
    public RelativeLayout rFh;
    public ImageView rqi;
    public BizTLRecCardCanvasView sEI;
    public View sJi;
    public ImageView sJj;
    public ImageView sJk;
    public View sJl;
    public TextView sJm;
    public ImageView sJn;
    public ImageView sJo;
    public ImageView sJp;
    public BizTagTextView sJq;
    public TextView titleTv;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(6080);
      this.sJl = null;
      this.sJm = null;
      this.sJn = null;
      this.sJo = null;
      this.sJp = null;
      this.sJq = null;
      this.amk = paramView;
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      com.tencent.mm.plugin.bizui.a.a locala = com.tencent.mm.plugin.bizui.a.a.shG;
      localLayoutParams.width = (com.tencent.mm.plugin.bizui.a.a.eO(BizTimeLineHotListView.this.getContext()) / 4);
      this.qps = ((ImageView)paramView.findViewById(d.e.sqx));
      this.rqi = ((ImageView)paramView.findViewById(d.e.sqy));
      this.rFh = ((RelativeLayout)paramView.findViewById(d.e.sqz));
      this.sJi = paramView.findViewById(d.e.sqG);
      this.titleTv = ((TextView)paramView.findViewById(d.e.sqF));
      this.sJj = ((ImageView)paramView.findViewById(d.e.sqH));
      this.sJk = ((ImageView)paramView.findViewById(d.e.sqC));
      this.sJm = ((TextView)paramView.findViewById(d.e.sqw));
      this.sJn = ((ImageView)paramView.findViewById(d.e.sqD));
      this.sJo = ((ImageView)paramView.findViewById(d.e.sqE));
      this.sJp = ((ImageView)paramView.findViewById(d.e.sqA));
      this.sJq = ((BizTagTextView)paramView.findViewById(d.e.sqB));
      AppMethodBeat.o(6080);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView
 * JD-Core Version:    0.7.0.1
 */