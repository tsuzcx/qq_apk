package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.transition.Transition;
import android.support.transition.Transition.d;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.g.a.rg;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.luckymoney.model.d;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.scaledLayout.ScaleLayoutManager;
import com.tencent.mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.adg;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.protocal.protobuf.xm;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.e.i;
import com.tencent.mm.ui.widget.snackbar.a.c;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(1)
public class LuckyMoneyPickEnvelopeUI
  extends MMActivity
{
  private View GQ;
  private boolean isLoading;
  private String sessionId;
  private long startTime;
  private Dialog tipDialog;
  private int yQF;
  private View yYd;
  private LuckyMoneyEnvelopeTouchRecyclerView zgB;
  private c zgC;
  private ScaleLayoutManager zgD;
  private List<d> zgE;
  private int zgF;
  private int zgG;
  private boolean zgH;
  private String zgI;
  private com.tencent.mm.plugin.luckymoney.scaledLayout.a zgJ;
  private Button zgK;
  private LinkedList<String> zgL;
  private RecyclerView.l zgM;
  private boolean zgN;
  private Boolean zgO;
  private String zgP;
  private String zgQ;
  private String zgR;
  private IListener<rg> zgS;
  private boolean zgT;
  
  public LuckyMoneyPickEnvelopeUI()
  {
    AppMethodBeat.i(65813);
    this.zgE = new ArrayList();
    this.zgF = -1;
    this.zgG = -1;
    this.zgH = false;
    this.isLoading = false;
    this.yQF = 0;
    this.zgN = true;
    this.zgS = new IListener() {};
    this.zgT = false;
    AppMethodBeat.o(65813);
  }
  
  private void a(bvi parambvi)
  {
    AppMethodBeat.i(65818);
    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "try show illegal msg");
    if (Util.isNullOrNil(parambvi.yUF))
    {
      AppMethodBeat.o(65818);
      return;
    }
    ArrayList localArrayList = new ArrayList(Util.stringToList((String)g.aAh().azQ().get(ar.a.Ofp, ""), ","));
    this.zgL = parambvi.Mbv;
    Iterator localIterator = this.zgL.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (localArrayList.contains(str)) {
        break label204;
      }
      localArrayList.add(str);
      Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "show illegal id: %s", new Object[] { str });
      i = 1;
    }
    label204:
    for (;;)
    {
      break;
      if (i != 0)
      {
        g.aAh().azQ().set(ar.a.Ofp, Util.listToString(localArrayList, ","));
        com.tencent.mm.ui.base.h.a(this, parambvi.yUF, "", getString(2131755874), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      AppMethodBeat.o(65818);
      return;
    }
  }
  
  private void a(bvi parambvi, boolean paramBoolean)
  {
    AppMethodBeat.i(213459);
    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "update by resp");
    boolean bool;
    if (parambvi.Mbw == 1)
    {
      bool = true;
      this.zgH = bool;
      a(parambvi);
      if (parambvi.Mbs != null)
      {
        if (!parambvi.Mbs.isEmpty()) {
          break label97;
        }
        this.GQ.setVisibility(0);
        this.zgB.setVisibility(8);
      }
    }
    for (;;)
    {
      this.zgC.atj.notifyChanged();
      egx();
      AppMethodBeat.o(213459);
      return;
      bool = false;
      break;
      label97:
      Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "list size: %s", new Object[] { Integer.valueOf(parambvi.Mbs.size()) });
      if (!Util.isNullOrNil(this.zgQ)) {}
      int i;
      int j;
      cbe localcbe;
      d locald;
      int n;
      int k;
      for (int m = 1;; m = 0)
      {
        parambvi = parambvi.Mbs.iterator();
        i = 0;
        for (j = -1;; j = n)
        {
          if (!parambvi.hasNext()) {
            break label415;
          }
          localcbe = (cbe)parambvi.next();
          locald = new d((byte)0);
          locald.yXW = localcbe;
          n = j;
          if (paramBoolean)
          {
            if (m == 0) {
              break;
            }
            k = j;
            if (localcbe.Lot.equals(this.zgQ))
            {
              locald.pWp = true;
              k = j;
            }
            n = k;
            if (locald.pWp)
            {
              this.zgF = i;
              n = k;
            }
          }
          if (localcbe.iwy == 3)
          {
            this.zgR = localcbe.Lot;
            com.tencent.mm.plugin.report.service.h.CyF.a(22104, new Object[] { this.zgR, Integer.valueOf(1) });
          }
          this.zgE.add(locald);
          i += 1;
        }
      }
      if ((localcbe.MgE != 1) && (localcbe.KTQ != 1) && (!aDG(localcbe.Lot)))
      {
        n = 1;
        label355:
        if ((localcbe.MgF != 1) || (n == 0)) {
          break label409;
        }
      }
      label409:
      for (bool = true;; bool = false)
      {
        locald.pWp = bool;
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
        break label355;
      }
      label415:
      if ((this.zgF < 0) && (j >= 0))
      {
        this.zgF = j;
        ((d)this.zgE.get(this.zgF)).pWp = true;
      }
      if (this.zgN)
      {
        this.zgN = false;
        this.zgG = this.zgF;
        if (this.zgG >= 0) {
          this.zgP = ((d)this.zgE.get(this.zgG)).yXW.Lot;
        }
      }
    }
  }
  
  private boolean aDG(String paramString)
  {
    AppMethodBeat.i(163789);
    if ((this.zgL != null) && (!this.zgL.isEmpty()))
    {
      Iterator localIterator = this.zgL.iterator();
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
  
  private void egw()
  {
    AppMethodBeat.i(163791);
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163767);
        LuckyMoneyEnvelopeTouchRecyclerView localLuckyMoneyEnvelopeTouchRecyclerView;
        int i;
        if ((LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) && (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) < LuckyMoneyPickEnvelopeUI.q(LuckyMoneyPickEnvelopeUI.this).getItemCount()))
        {
          Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll to pos: %s", new Object[] { Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this)) });
          localLuckyMoneyEnvelopeTouchRecyclerView = LuckyMoneyPickEnvelopeUI.r(LuckyMoneyPickEnvelopeUI.this);
          ScaleLayoutManager localScaleLayoutManager = LuckyMoneyPickEnvelopeUI.i(LuckyMoneyPickEnvelopeUI.this);
          i = localScaleLayoutManager.AE(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
          if (localScaleLayoutManager.mOrientation == 1) {
            localLuckyMoneyEnvelopeTouchRecyclerView.scrollBy(0, i);
          }
        }
        else
        {
          Math.max(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this), 0);
          LuckyMoneyPickEnvelopeUI.egz();
          if (LuckyMoneyPickEnvelopeUI.s(LuckyMoneyPickEnvelopeUI.this) != null) {
            break label174;
          }
          LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, new RecyclerView.l()
          {
            public final void onScrollStateChanged(RecyclerView paramAnonymous2RecyclerView, int paramAnonymous2Int)
            {
              AppMethodBeat.i(163765);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymous2RecyclerView);
              localb.pH(paramAnonymous2Int);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
              super.onScrollStateChanged(paramAnonymous2RecyclerView, paramAnonymous2Int);
              Log.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "on scroll changed: %s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
              if (paramAnonymous2Int == 0)
              {
                if ((!LuckyMoneyPickEnvelopeUI.t(LuckyMoneyPickEnvelopeUI.this)) && (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0))
                {
                  paramAnonymous2RecyclerView = (LuckyMoneyPickEnvelopeUI.d)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
                  com.tencent.mm.plugin.report.service.h.CyF.a(19272, new Object[] { Integer.valueOf(1), LuckyMoneyPickEnvelopeUI.d(LuckyMoneyPickEnvelopeUI.this), paramAnonymous2RecyclerView.yXW.Lot });
                  LuckyMoneyPickEnvelopeUI.u(LuckyMoneyPickEnvelopeUI.this);
                }
                if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0)
                {
                  paramAnonymous2RecyclerView = (LuckyMoneyPickEnvelopeUI.d)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
                  if (paramAnonymous2RecyclerView.yXW.iwy == 3) {
                    com.tencent.mm.plugin.report.service.h.CyF.a(22104, new Object[] { paramAnonymous2RecyclerView.yXW.Lot, Integer.valueOf(2) });
                  }
                }
                LuckyMoneyPickEnvelopeUI.v(LuckyMoneyPickEnvelopeUI.this);
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
              AppMethodBeat.o(163765);
            }
            
            public final void onScrolled(RecyclerView paramAnonymous2RecyclerView, int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(163766);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymous2RecyclerView);
              localb.pH(paramAnonymous2Int1);
              localb.pH(paramAnonymous2Int2);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
              super.onScrolled(paramAnonymous2RecyclerView, paramAnonymous2Int1, paramAnonymous2Int2);
              paramAnonymous2Int1 = LuckyMoneyPickEnvelopeUI.i(LuckyMoneyPickEnvelopeUI.this).ku();
              Log.v("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll last vispos: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
              if ((!LuckyMoneyPickEnvelopeUI.w(LuckyMoneyPickEnvelopeUI.this)) && (LuckyMoneyPickEnvelopeUI.n(LuckyMoneyPickEnvelopeUI.this) == 1) && (paramAnonymous2Int1 == LuckyMoneyPickEnvelopeUI.q(LuckyMoneyPickEnvelopeUI.this).getItemCount() - 1))
              {
                Log.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "trigger load more: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, false);
              }
              LuckyMoneyPickEnvelopeUI.j(LuckyMoneyPickEnvelopeUI.this);
              paramAnonymous2RecyclerView = com.tencent.mm.plugin.luckymoney.scaledLayout.a.h(LuckyMoneyPickEnvelopeUI.i(LuckyMoneyPickEnvelopeUI.this));
              LuckyMoneyPickEnvelopeUI.r(LuckyMoneyPickEnvelopeUI.this);
              paramAnonymous2Int1 = LuckyMoneyEnvelopeTouchRecyclerView.bw(paramAnonymous2RecyclerView);
              LuckyMoneyPickEnvelopeUI.egA();
              if ((paramAnonymous2Int1 != LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this)) && (paramAnonymous2Int1 >= 0) && (paramAnonymous2Int1 < LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).size()))
              {
                paramAnonymous2RecyclerView = (LuckyMoneyPickEnvelopeUI.d)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(paramAnonymous2Int1);
                if ((paramAnonymous2RecyclerView.yXW != null) && ((paramAnonymous2RecyclerView.yXW.MgE == 1) || (paramAnonymous2RecyclerView.yXW.KTQ == 1)))
                {
                  Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "expired: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                  if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0)
                  {
                    ((LuckyMoneyPickEnvelopeUI.d)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).pWp = false;
                    LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this), false);
                    LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this, -1);
                  }
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                  AppMethodBeat.o(163766);
                  return;
                }
                if (paramAnonymous2RecyclerView.pWp) {
                  break label556;
                }
                Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do select pos: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0)
                {
                  ((LuckyMoneyPickEnvelopeUI.d)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).pWp = false;
                  paramAnonymous2Int2 = LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this);
                  LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, paramAnonymous2Int2, false);
                }
                paramAnonymous2RecyclerView.pWp = true;
                LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this, paramAnonymous2Int1);
                LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this), true);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(163766);
                return;
                label556:
                paramAnonymous2RecyclerView.pWp = false;
                LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this, -1);
              }
            }
          });
        }
        for (;;)
        {
          LuckyMoneyPickEnvelopeUI.r(LuckyMoneyPickEnvelopeUI.this).a(LuckyMoneyPickEnvelopeUI.s(LuckyMoneyPickEnvelopeUI.this));
          AppMethodBeat.o(163767);
          return;
          localLuckyMoneyEnvelopeTouchRecyclerView.scrollBy(i, 0);
          break;
          label174:
          LuckyMoneyPickEnvelopeUI.r(LuckyMoneyPickEnvelopeUI.this).b(LuckyMoneyPickEnvelopeUI.s(LuckyMoneyPickEnvelopeUI.this));
        }
      }
    };
    this.zgB.post(local2);
    AppMethodBeat.o(163791);
  }
  
  private void egx()
  {
    AppMethodBeat.i(213460);
    if (this.zgF == -1) {
      this.zgK.setEnabled(false);
    }
    do
    {
      this.zgK.setText(2131762625);
      AppMethodBeat.o(213460);
      return;
      this.zgK.setEnabled(true);
    } while (!egy());
    this.zgK.setText(2131762614);
    AppMethodBeat.o(213460);
  }
  
  private boolean egy()
  {
    AppMethodBeat.i(213461);
    if ((this.zgF < 0) || (this.zgF >= this.zgE.size()))
    {
      AppMethodBeat.o(213461);
      return false;
    }
    d locald = (d)this.zgE.get(this.zgF);
    if ((locald.pWp) && (locald.yXW != null) && (locald.yXW.iwy == 3))
    {
      AppMethodBeat.o(213461);
      return true;
    }
    AppMethodBeat.o(213461);
    return false;
  }
  
  private void qP(final boolean paramBoolean)
  {
    AppMethodBeat.i(163790);
    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do get show source: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), this.zgI });
    if (paramBoolean) {
      this.zgI = "";
    }
    this.tipDialog = com.tencent.mm.ui.base.h.a(getContext(), 3, 2131821007, getString(2131762446), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    this.isLoading = true;
    k localk = k.eeZ();
    localk.b(new d(this.zgI));
    localk.a(new com.tencent.mm.wallet_core.c.a.a() {}, 0L);
    AppMethodBeat.o(163790);
  }
  
  public int getLayoutId()
  {
    return 2131495379;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65815);
    this.zgB = ((LuckyMoneyEnvelopeTouchRecyclerView)findViewById(2131303679));
    this.GQ = findViewById(2131303676);
    this.zgK = ((Button)findViewById(2131303677));
    this.zgC = new c((byte)0);
    this.zgC.au(true);
    this.zgB.setAdapter(this.zgC);
    this.zgB.setItemAnimator(null);
    this.zgD = new ScaleLayoutManager(this)
    {
      public final void efp()
      {
        AppMethodBeat.i(65792);
        super.efp();
        this.yYw -= 31.0F;
        AppMethodBeat.o(65792);
      }
    };
    ScaleLayoutManager localScaleLayoutManager = this.zgD;
    localScaleLayoutManager.assertNotInLayoutOrScroll(null);
    if (localScaleLayoutManager.aXu != 0.8F)
    {
      localScaleLayoutManager.aXu = 0.8F;
      localScaleLayoutManager.removeAllViews();
    }
    this.zgB.setLayoutManager(this.zgD);
    this.zgJ = new com.tencent.mm.plugin.luckymoney.scaledLayout.a();
    this.zgJ.context = this;
    this.zgJ.f(this.zgB);
    this.zgB.zer = new LuckyMoneyEnvelopeTouchRecyclerView.a()
    {
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(65793);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          paramAnonymousMotionEvent = LuckyMoneyPickEnvelopeUI.this;
          LuckyMoneyPickEnvelopeUI.j(LuckyMoneyPickEnvelopeUI.this);
          LuckyMoneyPickEnvelopeUI.a(paramAnonymousMotionEvent, com.tencent.mm.plugin.luckymoney.scaledLayout.a.h(LuckyMoneyPickEnvelopeUI.i(LuckyMoneyPickEnvelopeUI.this)));
          LuckyMoneyPickEnvelopeUI.j(LuckyMoneyPickEnvelopeUI.this).yYd = LuckyMoneyPickEnvelopeUI.k(LuckyMoneyPickEnvelopeUI.this);
        }
        AppMethodBeat.o(65793);
        return false;
      }
    };
    getIntent().getStringExtra(e.i.Ozg);
    getIntent().getStringExtra(e.i.Ozh);
    this.zgK.setOnClickListener(new x()
    {
      public final void czW()
      {
        AppMethodBeat.i(213437);
        Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "click save: %s", new Object[] { Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this)) });
        Object localObject;
        String str;
        if ((LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) && (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) < LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).size()))
        {
          localObject = (LuckyMoneyPickEnvelopeUI.d)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
          if ((((LuckyMoneyPickEnvelopeUI.d)localObject).pWp) && (((LuckyMoneyPickEnvelopeUI.d)localObject).yXW != null))
          {
            str = ((LuckyMoneyPickEnvelopeUI.d)localObject).yXW.Lot;
            if (((LuckyMoneyPickEnvelopeUI.d)localObject).yXW.iwy != 3) {
              break label312;
            }
            LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, str, ((LuckyMoneyPickEnvelopeUI.d)localObject).yXW.MgS, LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
            com.tencent.mm.plugin.report.service.h.CyF.a(22104, new Object[] { ((LuckyMoneyPickEnvelopeUI.d)localObject).yXW.Lot, Integer.valueOf(3) });
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(16822, new Object[] { Integer.valueOf(3) });
          localObject = "";
          if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) {
            localObject = ((LuckyMoneyPickEnvelopeUI.d)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).yXW.Lot;
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(18892, new Object[] { Integer.valueOf(1), Integer.valueOf(LuckyMoneyPickEnvelopeUI.c(LuckyMoneyPickEnvelopeUI.this) + 1), Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) + 1), LuckyMoneyPickEnvelopeUI.d(LuckyMoneyPickEnvelopeUI.this), localObject, LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this) });
          AppMethodBeat.o(213437);
          return;
          label312:
          LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, str);
        }
      }
    });
    AppMethodBeat.o(65815);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(163788);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(163788);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(65814);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    hideActionbarLine();
    setActionbarColor(getContext().getResources().getColor(2131099692));
    initView();
    setMMTitle(2131762706);
    this.startTime = Util.currentTicks();
    Object localObject = getIntent().getByteArrayExtra(e.i.Oze);
    boolean bool = getIntent().getBooleanExtra(e.i.Ozf, true);
    this.zgO = Boolean.valueOf(getIntent().getBooleanExtra(e.i.Ozi, false));
    this.sessionId = getIntent().getStringExtra("key_session_id");
    paramBundle = getIntent().getStringExtra(e.i.Ozh);
    this.zgQ = getIntent().getStringExtra("packetId");
    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll packageid: %s", new Object[] { this.zgQ });
    if (bool) {
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        localObject = (bvi)new bvi().parseFrom((byte[])localObject);
        if (((bvi)localObject).dDN == 0)
        {
          this.zgI = ((bvi)localObject).Mbt;
          this.yQF = ((bvi)localObject).Mbu;
          a((bvi)localObject, true);
          egw();
          setBackBtn(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(65787);
              paramAnonymousMenuItem = "";
              if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) {
                paramAnonymousMenuItem = ((LuckyMoneyPickEnvelopeUI.d)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).yXW.Lot;
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(18892, new Object[] { Integer.valueOf(2), Integer.valueOf(LuckyMoneyPickEnvelopeUI.c(LuckyMoneyPickEnvelopeUI.this) + 1), Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) + 1), LuckyMoneyPickEnvelopeUI.d(LuckyMoneyPickEnvelopeUI.this), paramAnonymousMenuItem, LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this) });
              if (!Util.isNullOrNil(LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this))) {
                com.tencent.mm.plugin.report.service.h.CyF.a(22104, new Object[] { LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this), Integer.valueOf(4), Long.valueOf(Util.ticksToNow(LuckyMoneyPickEnvelopeUI.g(LuckyMoneyPickEnvelopeUI.this)) / 1000L) });
              }
              LuckyMoneyPickEnvelopeUI.this.setResult(0);
              LuckyMoneyPickEnvelopeUI.this.finish();
              AppMethodBeat.o(65787);
              return false;
            }
          });
          if (!Util.isNullOrNil(paramBundle)) {
            addTextOptionMenu(1, getString(2131762608), com.tencent.mm.cb.a.n(getContext(), 2131100688), new MenuItem.OnMenuItemClickListener()
            {
              public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
              {
                AppMethodBeat.i(65791);
                Log.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "click exchange tv");
                paramAnonymousMenuItem = Uri.parse(paramBundle).buildUpon();
                paramAnonymousMenuItem.appendQueryParameter("sessionId", LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this));
                Intent localIntent = new Intent();
                localIntent.putExtra("rawUrl", paramAnonymousMenuItem.build().toString());
                localIntent.putExtra("showShare", false);
                localIntent.putExtra("KRightBtn", true);
                f.b(LuckyMoneyPickEnvelopeUI.this.getContext(), localIntent, 1);
                paramAnonymousMenuItem = com.tencent.mm.plugin.report.service.h.CyF;
                if (LuckyMoneyPickEnvelopeUI.h(LuckyMoneyPickEnvelopeUI.this).booleanValue()) {}
                for (int i = 2;; i = 1)
                {
                  paramAnonymousMenuItem.a(18890, new Object[] { Integer.valueOf(3), Integer.valueOf(i), LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this) });
                  AppMethodBeat.o(65791);
                  return false;
                }
              }
            });
          }
          egx();
          this.zgS.alive();
          AppMethodBeat.o(65814);
          return;
        }
        qP(true);
        continue;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.LuckyMoneyPickEnvelopeUI", localIOException, "", new Object[0]);
        qP(true);
        continue;
      }
      qP(true);
      continue;
      this.zgH = false;
      this.yQF = 0;
      this.zgF = 0;
      d locald = new d((byte)0);
      locald.pWp = true;
      locald.yXW = new cbe();
      locald.yXW.Lot = "0";
      locald.yXW.MgB = getString(2131762599);
      this.zgE.add(locald);
      this.zgC.atj.notifyChanged();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65816);
    super.onDestroy();
    this.zgS.dead();
    AppMethodBeat.o(65816);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static abstract class a
    extends RecyclerView.v
  {
    public a(View paramView)
    {
      super();
    }
    
    public abstract void a(LuckyMoneyPickEnvelopeUI.d paramd);
    
    public abstract void qQ(boolean paramBoolean);
  }
  
  final class b
    extends LuckyMoneyPickEnvelopeUI.a
  {
    TextView gxs;
    ImageView gyr;
    TextView pIN;
    Button thI;
    ImageView zhf;
    View zhg;
    ImageView zhh;
    ProgressBar zhi;
    TextView zhj;
    TextView zhk;
    TextView zhl;
    ViewGroup zhm;
    ProgressBar zhn;
    ImageView zho;
    ViewGroup zhp;
    TextView zhq;
    TextView zhr;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(213441);
      this.zhm = ((ViewGroup)paramView.findViewById(2131303656));
      this.zhf = ((ImageView)paramView.findViewById(2131303661));
      this.gxs = ((TextView)paramView.findViewById(2131303664));
      this.gyr = ((ImageView)paramView.findViewById(2131303655));
      this.pIN = ((TextView)paramView.findViewById(2131303671));
      this.zhg = paramView.findViewById(2131303674);
      this.zhh = ((ImageView)paramView.findViewById(2131303670));
      this.zhi = ((ProgressBar)paramView.findViewById(2131303654));
      this.zhj = ((TextView)paramView.findViewById(2131303672));
      this.zhk = ((TextView)paramView.findViewById(2131303662));
      this.zhl = ((TextView)paramView.findViewById(2131303673));
      this.thI = ((Button)paramView.findViewById(2131303665));
      this.zho = ((ImageView)paramView.findViewById(2131303659));
      this.zhp = ((ViewGroup)paramView.findViewById(2131303666));
      this.zhq = ((TextView)paramView.findViewById(2131303660));
      this.zhr = ((TextView)paramView.findViewById(2131303658));
      f.G(this.zhr);
      this$1 = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
      if ((LuckyMoneyPickEnvelopeUI.this == null) || (LuckyMoneyPickEnvelopeUI.this.length() <= 0) || ((!LuckyMoneyPickEnvelopeUI.this.equals("zh_CN")) && (!LuckyMoneyPickEnvelopeUI.this.equals("zh_TW")) && (!LuckyMoneyPickEnvelopeUI.this.equals("zh_HK"))))
      {
        this.thI.setBackgroundResource(2131234423);
        this.thI.setText(2131762695);
      }
      this.zhn = ((ProgressBar)paramView.findViewById(2131303669));
      if (com.tencent.mm.ui.ao.isDarkMode()) {
        this.zhm.setBackgroundResource(2131233757);
      }
      for (;;)
      {
        this.zhm.setEnabled(false);
        AppMethodBeat.o(213441);
        return;
        this.zhm.setBackgroundResource(2131233755);
      }
    }
    
    private void a(final cbe paramcbe, boolean paramBoolean)
    {
      AppMethodBeat.i(213443);
      if (paramBoolean)
      {
        this.zhh.setVisibility(8);
        this.zhi.setVisibility(0);
        this.zhj.setVisibility(8);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.luckymoney.a.a)g.af(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.zhf, paramcbe, new com.tencent.mm.plugin.luckymoney.a.a.a()
        {
          public final void ei(final boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(213440);
            Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "load ok: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            Runnable local1 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(213439);
                LuckyMoneyPickEnvelopeUI.b.this.zhn.setVisibility(8);
                if ((LuckyMoneyPickEnvelopeUI.l(LuckyMoneyPickEnvelopeUI.this) != null) && (LuckyMoneyPickEnvelopeUI.l(LuckyMoneyPickEnvelopeUI.this).isShowing())) {
                  LuckyMoneyPickEnvelopeUI.l(LuckyMoneyPickEnvelopeUI.this).dismiss();
                }
                if ((LuckyMoneyPickEnvelopeUI.b.2.this.zhu.MgE == 1) || (LuckyMoneyPickEnvelopeUI.b.2.this.zhu.KTQ == 1))
                {
                  Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "envelope has expired do nothing");
                  AppMethodBeat.o(213439);
                  return;
                }
                if (!paramAnonymousBoolean)
                {
                  LuckyMoneyPickEnvelopeUI.b.this.zhg.setVisibility(0);
                  LuckyMoneyPickEnvelopeUI.b.this.zhh.setVisibility(0);
                  LuckyMoneyPickEnvelopeUI.b.this.zhi.setVisibility(8);
                  LuckyMoneyPickEnvelopeUI.b.this.zhj.setVisibility(0);
                  AppMethodBeat.o(213439);
                  return;
                }
                LuckyMoneyPickEnvelopeUI.b.this.zhg.setVisibility(8);
                AppMethodBeat.o(213439);
              }
            };
            if (MMHandlerThread.isMainThread())
            {
              local1.run();
              AppMethodBeat.o(213440);
              return;
            }
            LuckyMoneyPickEnvelopeUI.b.this.zhg.post(local1);
            AppMethodBeat.o(213440);
          }
        });
        AppMethodBeat.o(213443);
        return;
        if ("0".equals(paramcbe.Lot))
        {
          Log.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "default envelope");
          AppMethodBeat.o(213443);
          return;
        }
        this.zhn.setVisibility(0);
      }
    }
    
    public final void a(final LuckyMoneyPickEnvelopeUI.d paramd)
    {
      AppMethodBeat.i(213442);
      this.aus.setSelected(paramd.pWp);
      a.b.a(this.gyr, z.aTY(), 0.06F, false);
      this.pIN.setText(l.e(LuckyMoneyPickEnvelopeUI.this.getContext(), z.aUa(), com.tencent.mm.cb.a.aG(LuckyMoneyPickEnvelopeUI.this.getContext(), 2131165592)));
      this.zhf.setImageBitmap(null);
      this.zhg.setVisibility(8);
      if (paramd.yXW != null)
      {
        this.gxs.setText(paramd.yXW.MgB);
        this.zhq.setText(paramd.yXW.MgB);
        if (paramd.yXW.MgC != null) {
          a(paramd.yXW, false);
        }
        this.zhg.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(213438);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$BizVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            LuckyMoneyPickEnvelopeUI.b.a(LuckyMoneyPickEnvelopeUI.b.this, paramd.yXW);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$BizVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213438);
          }
        });
        if (Util.isNullOrNil(paramd.yXW.MgD)) {
          break label220;
        }
        this.zhk.setText(paramd.yXW.MgD);
        this.zhk.setVisibility(0);
      }
      for (;;)
      {
        if (this.zhr != null) {
          this.zhr.setText(paramd.yXW.MgR);
        }
        this.zhg.setVisibility(8);
        AppMethodBeat.o(213442);
        return;
        label220:
        this.zhk.setText("");
      }
    }
    
    public final void qQ(boolean paramBoolean) {}
  }
  
  final class c
    extends RecyclerView.a<LuckyMoneyPickEnvelopeUI.a>
  {
    private c() {}
    
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
      long l = ((LuckyMoneyPickEnvelopeUI.d)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(paramInt)).hashCode();
      AppMethodBeat.o(65804);
      return l;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(213445);
      if (((LuckyMoneyPickEnvelopeUI.d)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(paramInt)).yXW.iwy == 3)
      {
        AppMethodBeat.o(213445);
        return 2;
      }
      AppMethodBeat.o(213445);
      return 1;
    }
  }
  
  static final class d
  {
    public boolean pWp = false;
    public cbe yXW;
  }
  
  final class e
    extends LuckyMoneyPickEnvelopeUI.a
  {
    TextView gxs;
    ImageView gyr;
    TextView pIN;
    Button thI;
    ImageView zhf;
    View zhg;
    ImageView zhh;
    ProgressBar zhi;
    TextView zhj;
    TextView zhk;
    TextView zhl;
    ViewGroup zhm;
    ProgressBar zhn;
    
    public e(View paramView)
    {
      super();
      AppMethodBeat.i(213452);
      this.zhm = ((ViewGroup)paramView.findViewById(2131303656));
      this.zhf = ((ImageView)paramView.findViewById(2131303661));
      this.gxs = ((TextView)paramView.findViewById(2131303664));
      this.gyr = ((ImageView)paramView.findViewById(2131303655));
      this.pIN = ((TextView)paramView.findViewById(2131303671));
      this.zhg = paramView.findViewById(2131303674);
      this.zhh = ((ImageView)paramView.findViewById(2131303670));
      this.zhi = ((ProgressBar)paramView.findViewById(2131303654));
      this.zhj = ((TextView)paramView.findViewById(2131303672));
      this.zhk = ((TextView)paramView.findViewById(2131303662));
      this.zhl = ((TextView)paramView.findViewById(2131303673));
      this.thI = ((Button)paramView.findViewById(2131303665));
      String str = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
      if ((str == null) || (str.length() <= 0) || ((!str.equals("zh_CN")) && (!str.equals("zh_TW")) && (!str.equals("zh_HK"))))
      {
        this.thI.setBackgroundResource(2131234423);
        this.thI.setText(2131762695);
      }
      this.zhn = ((ProgressBar)paramView.findViewById(2131303669));
      if (com.tencent.mm.ui.ao.isDarkMode()) {
        this.zhm.setBackgroundResource(2131233757);
      }
      for (;;)
      {
        this$1 = new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(213446);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$NormalVH$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
            LuckyMoneyPickEnvelopeUI.e.a(LuckyMoneyPickEnvelopeUI.e.this, paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$NormalVH$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(213446);
            return false;
          }
        };
        paramView.setOnLongClickListener(LuckyMoneyPickEnvelopeUI.this);
        this.zhg.setOnLongClickListener(LuckyMoneyPickEnvelopeUI.this);
        AppMethodBeat.o(213452);
        return;
        this.zhm.setBackgroundResource(2131233755);
      }
    }
    
    private void a(final cbe paramcbe, boolean paramBoolean)
    {
      AppMethodBeat.i(213456);
      if (paramBoolean)
      {
        this.zhh.setVisibility(8);
        this.zhi.setVisibility(0);
        this.zhj.setVisibility(8);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.luckymoney.a.a)g.af(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.zhf, paramcbe, new com.tencent.mm.plugin.luckymoney.a.a.a()
        {
          public final void ei(final boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(213451);
            Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "load ok: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            Runnable local1 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(213450);
                LuckyMoneyPickEnvelopeUI.e.this.zhn.setVisibility(8);
                if ((LuckyMoneyPickEnvelopeUI.l(LuckyMoneyPickEnvelopeUI.this) != null) && (LuckyMoneyPickEnvelopeUI.l(LuckyMoneyPickEnvelopeUI.this).isShowing())) {
                  LuckyMoneyPickEnvelopeUI.l(LuckyMoneyPickEnvelopeUI.this).dismiss();
                }
                if ((LuckyMoneyPickEnvelopeUI.e.5.this.zhu.MgE == 1) || (LuckyMoneyPickEnvelopeUI.e.5.this.zhu.KTQ == 1))
                {
                  Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "envelope has expired do nothing");
                  AppMethodBeat.o(213450);
                  return;
                }
                if (!paramAnonymousBoolean)
                {
                  LuckyMoneyPickEnvelopeUI.e.this.zhg.setVisibility(0);
                  LuckyMoneyPickEnvelopeUI.e.this.zhh.setVisibility(0);
                  LuckyMoneyPickEnvelopeUI.e.this.zhi.setVisibility(8);
                  LuckyMoneyPickEnvelopeUI.e.this.zhj.setVisibility(0);
                  AppMethodBeat.o(213450);
                  return;
                }
                LuckyMoneyPickEnvelopeUI.e.this.zhg.setVisibility(8);
                AppMethodBeat.o(213450);
              }
            };
            if (MMHandlerThread.isMainThread())
            {
              local1.run();
              AppMethodBeat.o(213451);
              return;
            }
            LuckyMoneyPickEnvelopeUI.e.this.zhg.post(local1);
            AppMethodBeat.o(213451);
          }
        });
        AppMethodBeat.o(213456);
        return;
        if ("0".equals(paramcbe.Lot))
        {
          Log.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "default envelope");
          AppMethodBeat.o(213456);
          return;
        }
        this.zhn.setVisibility(0);
      }
    }
    
    private void egB()
    {
      AppMethodBeat.i(213455);
      this.zhg.setVisibility(0);
      this.zhh.setVisibility(8);
      this.zhi.setVisibility(8);
      this.zhj.setVisibility(8);
      this.zhg.setOnClickListener(null);
      AppMethodBeat.o(213455);
    }
    
    public final void a(final LuckyMoneyPickEnvelopeUI.d paramd)
    {
      AppMethodBeat.i(213454);
      this.aus.setSelected(paramd.pWp);
      a.b.a(this.gyr, z.aTY(), 0.06F, false);
      this.pIN.setText(l.e(LuckyMoneyPickEnvelopeUI.this.getContext(), z.aUa(), com.tencent.mm.cb.a.aG(LuckyMoneyPickEnvelopeUI.this.getContext(), 2131165592)));
      this.zhf.setImageBitmap(null);
      this.zhg.setVisibility(8);
      if (paramd.yXW != null)
      {
        this.gxs.setText(paramd.yXW.MgB);
        if (paramd.yXW.MgC != null) {
          a(paramd.yXW, false);
        }
        this.zhg.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(213447);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$NormalVH$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            LuckyMoneyPickEnvelopeUI.e.a(LuckyMoneyPickEnvelopeUI.e.this, paramd.yXW);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$NormalVH$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213447);
          }
        });
        if (!Util.isNullOrNil(paramd.yXW.MgD))
        {
          this.zhk.setText(paramd.yXW.MgD);
          this.zhk.setVisibility(0);
          this.zhk.setOnTouchListener(null);
          this.zhk.setClickable(false);
          if (paramd.yXW.iwy != 2) {
            break label273;
          }
          this.zhl.setVisibility(0);
        }
        for (;;)
        {
          if ((paramd.yXW.iwy != 1) || (Util.isNullOrNil(paramd.yXW.MgI))) {
            break label285;
          }
          this.zhk.setVisibility(0);
          this.zhk.setText(paramd.yXW.MgI);
          AppMethodBeat.o(213454);
          return;
          this.zhk.setText("");
          break;
          label273:
          this.zhl.setVisibility(8);
        }
        label285:
        if (paramd.yXW.KTQ == 1)
        {
          this.aus.setSelected(false);
          this.zhm.setEnabled(false);
          this.zhk.setVisibility(0);
          if (!Util.isNullOrNil(paramd.yXW.MgH)) {
            this.zhk.setText(paramd.yXW.MgH);
          }
          egB();
          AppMethodBeat.o(213454);
          return;
        }
        if (paramd.yXW.MgE == 1)
        {
          this.aus.setSelected(false);
          this.zhm.setEnabled(false);
          if (!Util.isNullOrNil(paramd.yXW.MgD))
          {
            this.zhk.setText(paramd.yXW.MgD);
            this.zhk.setVisibility(0);
          }
          this.zhg.setVisibility(8);
          this.zhh.setVisibility(8);
          this.zhi.setVisibility(8);
          this.zhj.setVisibility(8);
          this.zhg.setOnClickListener(null);
          AppMethodBeat.o(213454);
          return;
        }
        if (LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this, paramd.yXW.Lot))
        {
          this.aus.setSelected(false);
          this.zhm.setEnabled(false);
          this.zhk.setText(2131762613);
          this.zhk.setVisibility(0);
          egB();
          AppMethodBeat.o(213454);
          return;
        }
        this.zhm.setEnabled(true);
        if (Util.isNullOrNil(this.zhk.getText())) {
          this.zhk.setVisibility(4);
        }
        this.zhg.setVisibility(8);
      }
      AppMethodBeat.o(213454);
    }
    
    public final void qQ(boolean paramBoolean)
    {
      AppMethodBeat.i(213453);
      this.aus.setSelected(paramBoolean);
      AppMethodBeat.o(213453);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI
 * JD-Core Version:    0.7.0.1
 */