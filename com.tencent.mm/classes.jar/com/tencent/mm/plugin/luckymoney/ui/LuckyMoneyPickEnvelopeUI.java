package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.g.a.pr;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.luckymoney.scaledLayout.ScaleLayoutManager;
import com.tencent.mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.yd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.e.g;
import com.tencent.mm.ui.r.b;
import com.tencent.mm.ui.widget.snackbar.a.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(1)
public class LuckyMoneyPickEnvelopeUI
  extends MMActivity
{
  private View DR;
  private boolean isLoading;
  private int sZo;
  private String sessionId;
  private View tgd;
  private Dialog tipDialog;
  private ScaleLayoutManager toA;
  private List<b> toB;
  private int toC;
  private int toD;
  private boolean toE;
  private String toF;
  private com.tencent.mm.plugin.luckymoney.scaledLayout.a toG;
  private TextView toH;
  private LinkedList<String> toI;
  private RecyclerView.m toJ;
  private boolean toK;
  private Boolean toL;
  private String toM;
  private String toN;
  private com.tencent.mm.sdk.b.c<pr> toO;
  private boolean toP;
  private LuckyMoneyEnvelopeTouchRecyclerView toy;
  private a toz;
  
  public LuckyMoneyPickEnvelopeUI()
  {
    AppMethodBeat.i(65813);
    this.toB = new ArrayList();
    this.toC = -1;
    this.toD = -1;
    this.toE = false;
    this.isLoading = false;
    this.sZo = 0;
    this.toK = true;
    this.toO = new com.tencent.mm.sdk.b.c() {};
    this.toP = false;
    AppMethodBeat.o(65813);
  }
  
  private void a(bap parambap)
  {
    AppMethodBeat.i(65818);
    ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "try show illegal msg");
    if (bt.isNullOrNil(parambap.tcQ))
    {
      AppMethodBeat.o(65818);
      return;
    }
    ArrayList localArrayList = new ArrayList(bt.kS((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fsl, ""), ","));
    this.toI = parambap.Dyu;
    Iterator localIterator = this.toI.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (localArrayList.contains(str)) {
        break label200;
      }
      localArrayList.add(str);
      ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "show illegal id: %s", new Object[] { str });
      i = 1;
    }
    label200:
    for (;;)
    {
      break;
      if (i != 0)
      {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fsl, bt.n(localArrayList, ","));
        com.tencent.mm.ui.base.h.a(this, parambap.tcQ, "", getString(2131755793), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      AppMethodBeat.o(65818);
      return;
    }
  }
  
  private void a(bap parambap, boolean paramBoolean)
  {
    AppMethodBeat.i(187046);
    ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "update by resp");
    boolean bool;
    if (parambap.Dyv == 1)
    {
      bool = true;
      this.toE = bool;
      a(parambap);
      if (parambap.Dyr != null)
      {
        if (!parambap.Dyr.isEmpty()) {
          break label97;
        }
        this.DR.setVisibility(0);
        this.toy.setVisibility(8);
      }
    }
    for (;;)
    {
      this.toz.aql.notifyChanged();
      cri();
      AppMethodBeat.o(187046);
      return;
      bool = false;
      break;
      label97:
      ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "list size: %s", new Object[] { Integer.valueOf(parambap.Dyr.size()) });
      if (!bt.isNullOrNil(this.toN)) {}
      int i;
      int j;
      bfu localbfu;
      b localb;
      int n;
      int k;
      for (int m = 1;; m = 0)
      {
        parambap = parambap.Dyr.iterator();
        i = 0;
        for (j = -1;; j = n)
        {
          if (!parambap.hasNext()) {
            break label370;
          }
          localbfu = (bfu)parambap.next();
          localb = new b((byte)0);
          localb.tfW = localbfu;
          n = j;
          if (paramBoolean)
          {
            if (m == 0) {
              break;
            }
            k = j;
            if (localbfu.Daf.equals(this.toN))
            {
              localb.nvF = true;
              k = j;
            }
            n = k;
            if (localb.nvF)
            {
              this.toC = i;
              n = k;
            }
          }
          this.toB.add(localb);
          i += 1;
        }
      }
      if ((localbfu.DDj != 1) && (localbfu.CJm != 1) && (!afx(localbfu.Daf)))
      {
        n = 1;
        label310:
        if ((localbfu.DDk != 1) || (n == 0)) {
          break label364;
        }
      }
      label364:
      for (bool = true;; bool = false)
      {
        localb.nvF = bool;
        k = j;
        if (j >= 0) {
          break;
        }
        k = j;
        if (n == 0) {
          break;
        }
        k = i;
        break;
        n = 0;
        break label310;
      }
      label370:
      if (this.toC < 0)
      {
        this.toC = j;
        ((b)this.toB.get(this.toC)).nvF = true;
      }
      if (this.toK)
      {
        this.toK = false;
        this.toD = this.toC;
        if (this.toD >= 0) {
          this.toM = ((b)this.toB.get(this.toD)).tfW.Daf;
        }
      }
    }
  }
  
  private boolean afx(String paramString)
  {
    AppMethodBeat.i(163789);
    if ((this.toI != null) && (!this.toI.isEmpty()))
    {
      Iterator localIterator = this.toI.iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).equals(paramString))
        {
          AppMethodBeat.o(163789);
          return true;
        }
      }
    }
    AppMethodBeat.o(163789);
    return false;
  }
  
  private void cMI()
  {
    AppMethodBeat.i(163791);
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163767);
        LuckyMoneyEnvelopeTouchRecyclerView localLuckyMoneyEnvelopeTouchRecyclerView;
        int i;
        if ((LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) && (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) < LuckyMoneyPickEnvelopeUI.o(LuckyMoneyPickEnvelopeUI.this).getItemCount()))
        {
          ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll to pos: %s", new Object[] { Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this)) });
          localLuckyMoneyEnvelopeTouchRecyclerView = LuckyMoneyPickEnvelopeUI.p(LuckyMoneyPickEnvelopeUI.this);
          ScaleLayoutManager localScaleLayoutManager = LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this);
          i = localScaleLayoutManager.vv(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
          if (localScaleLayoutManager.mOrientation == 1) {
            localLuckyMoneyEnvelopeTouchRecyclerView.scrollBy(0, i);
          }
        }
        else
        {
          Math.max(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this), 0);
          LuckyMoneyPickEnvelopeUI.cMJ();
          if (LuckyMoneyPickEnvelopeUI.q(LuckyMoneyPickEnvelopeUI.this) != null) {
            break label174;
          }
          LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, new RecyclerView.m()
          {
            public final void a(RecyclerView paramAnonymous2RecyclerView, int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(163766);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.be(paramAnonymous2RecyclerView);
              localb.lT(paramAnonymous2Int1);
              localb.lT(paramAnonymous2Int2);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
              super.a(paramAnonymous2RecyclerView, paramAnonymous2Int1, paramAnonymous2Int2);
              paramAnonymous2Int1 = LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this).jQ();
              ad.v("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll last vispos: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
              if ((!LuckyMoneyPickEnvelopeUI.u(LuckyMoneyPickEnvelopeUI.this)) && (LuckyMoneyPickEnvelopeUI.l(LuckyMoneyPickEnvelopeUI.this) == 1) && (paramAnonymous2Int1 == LuckyMoneyPickEnvelopeUI.o(LuckyMoneyPickEnvelopeUI.this).getItemCount() - 1))
              {
                ad.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "trigger load more: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, false);
              }
              LuckyMoneyPickEnvelopeUI.g(LuckyMoneyPickEnvelopeUI.this);
              paramAnonymous2RecyclerView = com.tencent.mm.plugin.luckymoney.scaledLayout.a.h(LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this));
              LuckyMoneyPickEnvelopeUI.p(LuckyMoneyPickEnvelopeUI.this);
              paramAnonymous2Int1 = LuckyMoneyEnvelopeTouchRecyclerView.bw(paramAnonymous2RecyclerView);
              LuckyMoneyPickEnvelopeUI.cMK();
              if ((paramAnonymous2Int1 != LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this)) && (paramAnonymous2Int1 >= 0) && (paramAnonymous2Int1 < LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).size()))
              {
                paramAnonymous2RecyclerView = (LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(paramAnonymous2Int1);
                if ((paramAnonymous2RecyclerView.tfW != null) && ((paramAnonymous2RecyclerView.tfW.DDj == 1) || (paramAnonymous2RecyclerView.tfW.CJm == 1)))
                {
                  ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "expired: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                  if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0)
                  {
                    ((LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).nvF = false;
                    LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this), false);
                    LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this, -1);
                  }
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                  AppMethodBeat.o(163766);
                  return;
                }
                if (paramAnonymous2RecyclerView.nvF) {
                  break label556;
                }
                ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do select pos: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0)
                {
                  ((LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).nvF = false;
                  paramAnonymous2Int2 = LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this);
                  LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, paramAnonymous2Int2, false);
                }
                paramAnonymous2RecyclerView.nvF = true;
                LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this, paramAnonymous2Int1);
                LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this), true);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(163766);
                return;
                label556:
                paramAnonymous2RecyclerView.nvF = false;
                LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this, -1);
              }
            }
            
            public final void b(RecyclerView paramAnonymous2RecyclerView, int paramAnonymous2Int)
            {
              AppMethodBeat.i(163765);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.be(paramAnonymous2RecyclerView);
              localb.lT(paramAnonymous2Int);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
              super.b(paramAnonymous2RecyclerView, paramAnonymous2Int);
              ad.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "on scroll changed: %s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
              if (paramAnonymous2Int == 0)
              {
                if ((!LuckyMoneyPickEnvelopeUI.r(LuckyMoneyPickEnvelopeUI.this)) && (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0))
                {
                  paramAnonymous2RecyclerView = (LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
                  com.tencent.mm.plugin.report.service.h.vKh.f(19272, new Object[] { Integer.valueOf(1), LuckyMoneyPickEnvelopeUI.d(LuckyMoneyPickEnvelopeUI.this), paramAnonymous2RecyclerView.tfW.Daf });
                  LuckyMoneyPickEnvelopeUI.s(LuckyMoneyPickEnvelopeUI.this);
                }
                LuckyMoneyPickEnvelopeUI.t(LuckyMoneyPickEnvelopeUI.this);
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
              AppMethodBeat.o(163765);
            }
          });
        }
        for (;;)
        {
          LuckyMoneyPickEnvelopeUI.p(LuckyMoneyPickEnvelopeUI.this).a(LuckyMoneyPickEnvelopeUI.q(LuckyMoneyPickEnvelopeUI.this));
          AppMethodBeat.o(163767);
          return;
          localLuckyMoneyEnvelopeTouchRecyclerView.scrollBy(i, 0);
          break;
          label174:
          LuckyMoneyPickEnvelopeUI.p(LuckyMoneyPickEnvelopeUI.this).b(LuckyMoneyPickEnvelopeUI.q(LuckyMoneyPickEnvelopeUI.this));
        }
      }
    };
    this.toy.post(local2);
    AppMethodBeat.o(163791);
  }
  
  private void cri()
  {
    AppMethodBeat.i(163792);
    if (this.toC == -1)
    {
      enableOptionMenu(1, false);
      AppMethodBeat.o(163792);
      return;
    }
    enableOptionMenu(1, true);
    AppMethodBeat.o(163792);
  }
  
  private void mQ(final boolean paramBoolean)
  {
    AppMethodBeat.i(163790);
    ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do get show source: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), this.toF });
    if (paramBoolean) {
      this.toF = "";
    }
    this.tipDialog = com.tencent.mm.ui.base.h.a(getContext(), 3, 2131820985, getString(2131760709), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    this.isLoading = true;
    com.tencent.mm.plugin.luckymoney.model.g localg = com.tencent.mm.plugin.luckymoney.model.g.cLo();
    localg.b(new com.tencent.mm.plugin.luckymoney.model.c(this.toF));
    localg.a(new com.tencent.mm.wallet_core.c.a.a() {}, 0L);
    AppMethodBeat.o(163790);
  }
  
  public int getLayoutId()
  {
    return 2131494655;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65815);
    this.toy = ((LuckyMoneyEnvelopeTouchRecyclerView)findViewById(2131301483));
    this.DR = findViewById(2131301481);
    this.toH = ((TextView)findViewById(2131301482));
    this.toz = new a((byte)0);
    this.toz.av(true);
    this.toy.setAdapter(this.toz);
    this.toy.setItemAnimator(null);
    this.toy.setItemViewCacheSize(-1);
    this.toA = new ScaleLayoutManager(this)
    {
      public final void cLD()
      {
        AppMethodBeat.i(65792);
        super.cLD();
        this.tgw -= 31.0F;
        AppMethodBeat.o(65792);
      }
    };
    Object localObject = this.toA;
    ((ScaleLayoutManager)localObject).E(null);
    if (((ScaleLayoutManager)localObject).aMv != 0.8F)
    {
      ((ScaleLayoutManager)localObject).aMv = 0.8F;
      ((ScaleLayoutManager)localObject).removeAllViews();
    }
    this.toy.setLayoutManager(this.toA);
    this.toG = new com.tencent.mm.plugin.luckymoney.scaledLayout.a();
    this.toG.context = this;
    this.toG.j(this.toy);
    this.toy.tmo = new LuckyMoneyEnvelopeTouchRecyclerView.a()
    {
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(65793);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          paramAnonymousMotionEvent = LuckyMoneyPickEnvelopeUI.this;
          LuckyMoneyPickEnvelopeUI.g(LuckyMoneyPickEnvelopeUI.this);
          LuckyMoneyPickEnvelopeUI.a(paramAnonymousMotionEvent, com.tencent.mm.plugin.luckymoney.scaledLayout.a.h(LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this)));
          LuckyMoneyPickEnvelopeUI.g(LuckyMoneyPickEnvelopeUI.this).tgd = LuckyMoneyPickEnvelopeUI.h(LuckyMoneyPickEnvelopeUI.this);
        }
        AppMethodBeat.o(65793);
        return false;
      }
    };
    localObject = getIntent().getStringExtra(e.g.FIb);
    final String str = getIntent().getStringExtra(e.g.FIc);
    if (!bt.isNullOrNil((String)localObject))
    {
      this.toH.setText((CharSequence)localObject);
      this.toH.setVisibility(0);
      this.toH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(163772);
          ad.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "click exchange tv");
          paramAnonymousView = Uri.parse(str).buildUpon();
          paramAnonymousView.appendQueryParameter("sessionId", LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this));
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", paramAnonymousView.build().toString());
          localIntent.putExtra("showShare", false);
          localIntent.putExtra("KRightBtn", true);
          com.tencent.mm.wallet_core.ui.e.b(LuckyMoneyPickEnvelopeUI.this.getContext(), localIntent, 1);
          paramAnonymousView = com.tencent.mm.plugin.report.service.h.vKh;
          if (LuckyMoneyPickEnvelopeUI.i(LuckyMoneyPickEnvelopeUI.this).booleanValue()) {}
          for (int i = 2;; i = 1)
          {
            paramAnonymousView.f(18890, new Object[] { Integer.valueOf(3), Integer.valueOf(i), LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this) });
            AppMethodBeat.o(163772);
            return;
          }
        }
      });
      AppMethodBeat.o(65815);
      return;
    }
    this.toH.setVisibility(8);
    AppMethodBeat.o(65815);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(163788);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(163788);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65814);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    hideActionbarLine();
    setActionbarColor(getContext().getResources().getColor(2131099682));
    initView();
    setMMTitle(2131760932);
    paramBundle = getIntent().getByteArrayExtra(e.g.FHZ);
    boolean bool = getIntent().getBooleanExtra(e.g.FIa, true);
    this.toL = Boolean.valueOf(getIntent().getBooleanExtra(e.g.FId, false));
    this.sessionId = getIntent().getStringExtra("key_session_id");
    this.toN = getIntent().getStringExtra("packetId");
    ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll packageid: %s", new Object[] { this.toN });
    if (bool) {
      if (paramBundle == null) {}
    }
    for (;;)
    {
      try
      {
        paramBundle = (bap)new bap().parseFrom(paramBundle);
        if (paramBundle.dcG == 0)
        {
          this.toF = paramBundle.Dys;
          this.sZo = paramBundle.Dyt;
          a(paramBundle, true);
          cMI();
          setBackBtn(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(65787);
              paramAnonymousMenuItem = "";
              if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) {
                paramAnonymousMenuItem = ((LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).tfW.Daf;
              }
              com.tencent.mm.plugin.report.service.h.vKh.f(18892, new Object[] { Integer.valueOf(2), Integer.valueOf(LuckyMoneyPickEnvelopeUI.c(LuckyMoneyPickEnvelopeUI.this) + 1), Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) + 1), LuckyMoneyPickEnvelopeUI.d(LuckyMoneyPickEnvelopeUI.this), paramAnonymousMenuItem, LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this) });
              LuckyMoneyPickEnvelopeUI.this.setResult(0);
              LuckyMoneyPickEnvelopeUI.this.finish();
              AppMethodBeat.o(65787);
              return false;
            }
          });
          addTextOptionMenu(1, getString(2131760929), new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(65791);
              ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "click save: %s", new Object[] { Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this)) });
              if ((LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) && (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) < LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).size()))
              {
                paramAnonymousMenuItem = (LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
                if ((!paramAnonymousMenuItem.nvF) || (paramAnonymousMenuItem.tfW == null)) {}
              }
              for (paramAnonymousMenuItem = paramAnonymousMenuItem.tfW.Daf;; paramAnonymousMenuItem = "0")
              {
                LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, paramAnonymousMenuItem);
                com.tencent.mm.plugin.report.service.h.vKh.f(16822, new Object[] { Integer.valueOf(3) });
                paramAnonymousMenuItem = "";
                if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) {
                  paramAnonymousMenuItem = ((LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).tfW.Daf;
                }
                com.tencent.mm.plugin.report.service.h.vKh.f(18892, new Object[] { Integer.valueOf(1), Integer.valueOf(LuckyMoneyPickEnvelopeUI.c(LuckyMoneyPickEnvelopeUI.this) + 1), Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) + 1), LuckyMoneyPickEnvelopeUI.d(LuckyMoneyPickEnvelopeUI.this), paramAnonymousMenuItem, LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this) });
                AppMethodBeat.o(65791);
                return false;
              }
            }
          }, null, r.b.FOC);
          cri();
          this.toO.alive();
          AppMethodBeat.o(65814);
          return;
        }
        mQ(true);
        continue;
      }
      catch (IOException paramBundle)
      {
        ad.printErrStackTrace("MicroMsg.LuckyMoneyPickEnvelopeUI", paramBundle, "", new Object[0]);
        mQ(true);
        continue;
      }
      mQ(true);
      continue;
      this.toE = false;
      this.sZo = 0;
      this.toC = 0;
      paramBundle = new b((byte)0);
      paramBundle.nvF = true;
      paramBundle.tfW = new bfu();
      paramBundle.tfW.Daf = "0";
      paramBundle.tfW.DDg = getString(2131760842);
      this.toB.add(paramBundle);
      this.toz.aql.notifyChanged();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65816);
    super.onDestroy();
    this.toO.dead();
    AppMethodBeat.o(65816);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends RecyclerView.a<LuckyMoneyPickEnvelopeUI.c>
  {
    private a() {}
    
    private void a(LuckyMoneyPickEnvelopeUI.c paramc, int paramInt)
    {
      AppMethodBeat.i(163777);
      LuckyMoneyPickEnvelopeUI.b localb = (LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(paramInt);
      paramc.arI.setSelected(localb.nvF);
      a.b.a(paramc.fuj, u.aqG(), 0.06F, false);
      paramc.nkb.setText(k.b(paramc.toQ.getContext(), u.aqI(), com.tencent.mm.cd.a.ao(paramc.toQ.getContext(), 2131165574)));
      paramc.toY.setImageBitmap(null);
      paramc.toZ.setVisibility(8);
      if (localb.tfW != null)
      {
        paramc.ftj.setText(localb.tfW.DDg);
        if (localb.tfW.DDh != null) {
          paramc.a(localb.tfW, false);
        }
        paramc.toZ.setOnClickListener(new LuckyMoneyPickEnvelopeUI.c.2(paramc, localb));
        if (!bt.isNullOrNil(localb.tfW.DDi))
        {
          paramc.tpd.setText(localb.tfW.DDi);
          paramc.tpd.setVisibility(0);
          if (localb.tfW.gGU != 2) {
            break label269;
          }
          paramc.tpe.setVisibility(0);
        }
        for (;;)
        {
          if ((localb.tfW.gGU != 1) || (bt.isNullOrNil(localb.tfW.DDn))) {
            break label281;
          }
          paramc.tpd.setVisibility(0);
          paramc.tpd.setText(localb.tfW.DDn);
          AppMethodBeat.o(163777);
          return;
          paramc.tpd.setText("");
          break;
          label269:
          paramc.tpe.setVisibility(8);
        }
        label281:
        if (localb.tfW.CJm == 1)
        {
          paramc.arI.setSelected(false);
          paramc.tpf.setEnabled(false);
          paramc.tpd.setVisibility(0);
          if (!bt.isNullOrNil(localb.tfW.DDm)) {
            paramc.tpd.setText(localb.tfW.DDm);
          }
          paramc.cML();
          AppMethodBeat.o(163777);
          return;
        }
        if (localb.tfW.DDj == 1)
        {
          paramc.arI.setSelected(false);
          paramc.tpf.setEnabled(false);
          if (!bt.isNullOrNil(localb.tfW.DDi))
          {
            paramc.tpd.setText(localb.tfW.DDi);
            paramc.tpd.setVisibility(0);
          }
          paramc.cML();
          AppMethodBeat.o(163777);
          return;
        }
        if (LuckyMoneyPickEnvelopeUI.e(paramc.toQ, localb.tfW.Daf))
        {
          paramc.arI.setSelected(false);
          paramc.tpf.setEnabled(false);
          paramc.tpd.setText(2131760852);
          paramc.tpd.setVisibility(0);
          paramc.cML();
          AppMethodBeat.o(163777);
          return;
        }
        paramc.tpf.setEnabled(true);
        if (bt.ai(paramc.tpd.getText())) {
          paramc.tpd.setVisibility(4);
        }
        paramc.toZ.setVisibility(8);
      }
      AppMethodBeat.o(163777);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(65803);
      int i = LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).size();
      AppMethodBeat.o(65803);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(65804);
      long l = ((LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(paramInt)).hashCode();
      AppMethodBeat.o(65804);
      return l;
    }
  }
  
  static final class b
  {
    public boolean nvF = false;
    public bfu tfW;
  }
  
  final class c
    extends RecyclerView.v
  {
    TextView ftj;
    ImageView fuj;
    TextView nkb;
    private Dialog tipDialog;
    ImageView toY;
    View toZ;
    ImageView tpa;
    ProgressBar tpb;
    TextView tpc;
    TextView tpd;
    TextView tpe;
    ViewGroup tpf;
    ProgressBar tpg;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(65810);
      this.tipDialog = null;
      this.tpf = ((ViewGroup)paramView.findViewById(2131301470));
      this.toY = ((ImageView)paramView.findViewById(2131301471));
      this.ftj = ((TextView)paramView.findViewById(2131301473));
      this.fuj = ((ImageView)paramView.findViewById(2131301469));
      this.nkb = ((TextView)paramView.findViewById(2131301477));
      this.toZ = paramView.findViewById(2131301479);
      this.tpa = ((ImageView)paramView.findViewById(2131301476));
      this.tpb = ((ProgressBar)paramView.findViewById(2131301468));
      this.tpc = ((TextView)paramView.findViewById(2131301478));
      this.tpd = ((TextView)paramView.findViewById(2131301472));
      this.tpe = ((TextView)paramView.findViewById(2131307210));
      this.tpg = ((ProgressBar)paramView.findViewById(2131301475));
      if (ai.Eq()) {
        this.tpf.setBackgroundResource(2131233104);
      }
      for (;;)
      {
        this$1 = new View.OnLongClickListener()
        {
          public final boolean onLongClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(163781);
            if (!LuckyMoneyPickEnvelopeUI.x(LuckyMoneyPickEnvelopeUI.this))
            {
              AppMethodBeat.o(163781);
              return false;
            }
            paramAnonymousView = LuckyMoneyPickEnvelopeUI.p(LuckyMoneyPickEnvelopeUI.this).bt(paramAnonymousView);
            LuckyMoneyPickEnvelopeUI.p(LuckyMoneyPickEnvelopeUI.this);
            int i = LuckyMoneyEnvelopeTouchRecyclerView.bw(paramAnonymousView);
            LuckyMoneyPickEnvelopeUI.g(LuckyMoneyPickEnvelopeUI.this);
            Object localObject = com.tencent.mm.plugin.luckymoney.scaledLayout.a.h(LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this));
            if ((i >= 0) && (i < LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).size()) && (paramAnonymousView == localObject))
            {
              ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "delete pos: %s", new Object[] { Integer.valueOf(i) });
              paramAnonymousView = (LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(i);
              if ((paramAnonymousView != null) && (paramAnonymousView.tfW != null))
              {
                if ("0".equals(paramAnonymousView.tfW.Daf))
                {
                  ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "can not delete default envelope");
                  AppMethodBeat.o(163781);
                  return false;
                }
                localObject = new com.tencent.mm.ui.widget.a.e(LuckyMoneyPickEnvelopeUI.this.getContext(), 1, true);
                TextView localTextView = new TextView(LuckyMoneyPickEnvelopeUI.this.getContext());
                localTextView.setPadding(0, 0, 0, com.tencent.mm.cd.a.fromDPToPix(LuckyMoneyPickEnvelopeUI.this.getContext(), 9));
                localTextView.setMinHeight(com.tencent.mm.cd.a.ao(LuckyMoneyPickEnvelopeUI.this.getContext(), 2131165204));
                localTextView.setTextSize(14.0F);
                localTextView.setTextColor(LuckyMoneyPickEnvelopeUI.this.getResources().getColor(2131100482));
                localTextView.setText(2131760927);
                localTextView.setGravity(81);
                ((com.tencent.mm.ui.widget.a.e)localObject).J(localTextView, true);
                ((com.tencent.mm.ui.widget.a.e)localObject).HrX = new n.c()
                {
                  public final void onCreateMMMenu(l paramAnonymous2l)
                  {
                    AppMethodBeat.i(163779);
                    paramAnonymous2l.a(0, LuckyMoneyPickEnvelopeUI.this.getResources().getColor(2131099803), LuckyMoneyPickEnvelopeUI.this.getString(2131760926));
                    AppMethodBeat.o(163779);
                  }
                };
                ((com.tencent.mm.ui.widget.a.e)localObject).HrY = new n.d()
                {
                  public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(163780);
                    if (paramAnonymous2MenuItem.getItemId() == 0) {
                      LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this, paramAnonymousView.tfW.Daf);
                    }
                    AppMethodBeat.o(163780);
                  }
                };
                ((com.tencent.mm.ui.widget.a.e)localObject).csG();
              }
            }
            AppMethodBeat.o(163781);
            return false;
          }
        };
        paramView.setOnLongClickListener(LuckyMoneyPickEnvelopeUI.this);
        this.toZ.setOnLongClickListener(LuckyMoneyPickEnvelopeUI.this);
        AppMethodBeat.o(65810);
        return;
        this.tpf.setBackgroundResource(2131233102);
      }
    }
    
    final void a(final bfu parambfu, boolean paramBoolean)
    {
      AppMethodBeat.i(65811);
      if (paramBoolean)
      {
        this.tpa.setVisibility(8);
        this.tpb.setVisibility(0);
        this.tpc.setVisibility(8);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.toY, parambfu, new com.tencent.mm.plugin.luckymoney.a.a.a()
        {
          public final void ib(final boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(163784);
            ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "load ok: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            Runnable local1 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(163783);
                LuckyMoneyPickEnvelopeUI.c.this.tpg.setVisibility(8);
                if ((LuckyMoneyPickEnvelopeUI.c.a(LuckyMoneyPickEnvelopeUI.c.this) != null) && (LuckyMoneyPickEnvelopeUI.c.a(LuckyMoneyPickEnvelopeUI.c.this).isShowing())) {
                  LuckyMoneyPickEnvelopeUI.c.a(LuckyMoneyPickEnvelopeUI.c.this).dismiss();
                }
                if ((LuckyMoneyPickEnvelopeUI.c.3.this.tpl.DDj == 1) || (LuckyMoneyPickEnvelopeUI.c.3.this.tpl.CJm == 1))
                {
                  ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "envelope has expired do nothing");
                  AppMethodBeat.o(163783);
                  return;
                }
                if (!paramAnonymousBoolean)
                {
                  LuckyMoneyPickEnvelopeUI.c.this.toZ.setVisibility(0);
                  LuckyMoneyPickEnvelopeUI.c.this.tpa.setVisibility(0);
                  LuckyMoneyPickEnvelopeUI.c.this.tpb.setVisibility(8);
                  LuckyMoneyPickEnvelopeUI.c.this.tpc.setVisibility(0);
                  AppMethodBeat.o(163783);
                  return;
                }
                LuckyMoneyPickEnvelopeUI.c.this.toZ.setVisibility(8);
                AppMethodBeat.o(163783);
              }
            };
            if (aq.isMainThread())
            {
              local1.run();
              AppMethodBeat.o(163784);
              return;
            }
            LuckyMoneyPickEnvelopeUI.c.this.toZ.post(local1);
            AppMethodBeat.o(163784);
          }
        });
        AppMethodBeat.o(65811);
        return;
        if ("0".equals(parambfu.Daf))
        {
          ad.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "default envelope");
          AppMethodBeat.o(65811);
          return;
        }
        this.tpg.setVisibility(0);
      }
    }
    
    final void cML()
    {
      AppMethodBeat.i(163786);
      this.toZ.setVisibility(0);
      this.tpa.setVisibility(8);
      this.tpb.setVisibility(8);
      this.tpc.setVisibility(8);
      this.toZ.setOnClickListener(null);
      AppMethodBeat.o(163786);
    }
    
    public final void mR(boolean paramBoolean)
    {
      AppMethodBeat.i(163785);
      this.arI.setSelected(paramBoolean);
      AppMethodBeat.o(163785);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI
 * JD-Core Version:    0.7.0.1
 */