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
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.mm.g.a.ql;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.luckymoney.scaledLayout.ScaleLayoutManager;
import com.tencent.mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bnu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.e.g;
import com.tencent.mm.ui.s.b;
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
  private View GG;
  private boolean isLoading;
  private String sessionId;
  private Dialog tipDialog;
  private int vkm;
  private View vqW;
  private String vzA;
  private com.tencent.mm.plugin.luckymoney.scaledLayout.a vzB;
  private TextView vzC;
  private LinkedList<String> vzD;
  private RecyclerView.m vzE;
  private boolean vzF;
  private Boolean vzG;
  private String vzH;
  private String vzI;
  private com.tencent.mm.sdk.b.c<ql> vzJ;
  private boolean vzK;
  private LuckyMoneyEnvelopeTouchRecyclerView vzt;
  private a vzu;
  private ScaleLayoutManager vzv;
  private List<b> vzw;
  private int vzx;
  private int vzy;
  private boolean vzz;
  
  public LuckyMoneyPickEnvelopeUI()
  {
    AppMethodBeat.i(65813);
    this.vzw = new ArrayList();
    this.vzx = -1;
    this.vzy = -1;
    this.vzz = false;
    this.isLoading = false;
    this.vkm = 0;
    this.vzF = true;
    this.vzJ = new com.tencent.mm.sdk.b.c() {};
    this.vzK = false;
    AppMethodBeat.o(65813);
  }
  
  private void a(bip parambip)
  {
    AppMethodBeat.i(65818);
    ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "try show illegal msg");
    if (bt.isNullOrNil(parambip.vnL))
    {
      AppMethodBeat.o(65818);
      return;
    }
    ArrayList localArrayList = new ArrayList(bt.lO((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICw, ""), ","));
    this.vzD = parambip.GDn;
    Iterator localIterator = this.vzD.iterator();
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
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICw, bt.m(localArrayList, ","));
        h.a(this, parambip.vnL, "", getString(2131755793), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      AppMethodBeat.o(65818);
      return;
    }
  }
  
  private void a(bip parambip, boolean paramBoolean)
  {
    AppMethodBeat.i(199021);
    ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "update by resp");
    boolean bool;
    if (parambip.GDo == 1)
    {
      bool = true;
      this.vzz = bool;
      a(parambip);
      if (parambip.GDk != null)
      {
        if (!parambip.GDk.isEmpty()) {
          break label97;
        }
        this.GG.setVisibility(0);
        this.vzt.setVisibility(8);
      }
    }
    for (;;)
    {
      this.vzu.asY.notifyChanged();
      cJW();
      AppMethodBeat.o(199021);
      return;
      bool = false;
      break;
      label97:
      ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "list size: %s", new Object[] { Integer.valueOf(parambip.GDk.size()) });
      if (!bt.isNullOrNil(this.vzI)) {}
      int i;
      int j;
      bnu localbnu;
      b localb;
      int n;
      int k;
      for (int m = 1;; m = 0)
      {
        parambip = parambip.GDk.iterator();
        i = 0;
        for (j = -1;; j = n)
        {
          if (!parambip.hasNext()) {
            break label370;
          }
          localbnu = (bnu)parambip.next();
          localb = new b((byte)0);
          localb.vqP = localbnu;
          n = j;
          if (paramBoolean)
          {
            if (m == 0) {
              break;
            }
            k = j;
            if (localbnu.Gat.equals(this.vzI))
            {
              localb.oBZ = true;
              k = j;
            }
            n = k;
            if (localb.oBZ)
            {
              this.vzx = i;
              n = k;
            }
          }
          this.vzw.add(localb);
          i += 1;
        }
      }
      if ((localbnu.GIb != 1) && (localbnu.FHA != 1) && (!ape(localbnu.Gat)))
      {
        n = 1;
        label310:
        if ((localbnu.GIc != 1) || (n == 0)) {
          break label364;
        }
      }
      label364:
      for (bool = true;; bool = false)
      {
        localb.oBZ = bool;
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
      if (this.vzx < 0)
      {
        this.vzx = j;
        ((b)this.vzw.get(this.vzx)).oBZ = true;
      }
      if (this.vzF)
      {
        this.vzF = false;
        this.vzy = this.vzx;
        if (this.vzy >= 0) {
          this.vzH = ((b)this.vzw.get(this.vzy)).vqP.Gat;
        }
      }
    }
  }
  
  private boolean ape(String paramString)
  {
    AppMethodBeat.i(163789);
    if ((this.vzD != null) && (!this.vzD.isEmpty()))
    {
      Iterator localIterator = this.vzD.iterator();
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
  
  private void cJW()
  {
    AppMethodBeat.i(163792);
    if (this.vzx == -1)
    {
      enableOptionMenu(1, false);
      AppMethodBeat.o(163792);
      return;
    }
    enableOptionMenu(1, true);
    AppMethodBeat.o(163792);
  }
  
  private void djB()
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
          i = localScaleLayoutManager.wR(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
          if (localScaleLayoutManager.mOrientation == 1) {
            localLuckyMoneyEnvelopeTouchRecyclerView.scrollBy(0, i);
          }
        }
        else
        {
          Math.max(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this), 0);
          LuckyMoneyPickEnvelopeUI.djC();
          if (LuckyMoneyPickEnvelopeUI.q(LuckyMoneyPickEnvelopeUI.this) != null) {
            break label174;
          }
          LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, new RecyclerView.m()
          {
            public final void a(RecyclerView paramAnonymous2RecyclerView, int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(163766);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2RecyclerView);
              localb.mr(paramAnonymous2Int1);
              localb.mr(paramAnonymous2Int2);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
              super.a(paramAnonymous2RecyclerView, paramAnonymous2Int1, paramAnonymous2Int2);
              paramAnonymous2Int1 = LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this).ko();
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
              LuckyMoneyPickEnvelopeUI.djD();
              if ((paramAnonymous2Int1 != LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this)) && (paramAnonymous2Int1 >= 0) && (paramAnonymous2Int1 < LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).size()))
              {
                paramAnonymous2RecyclerView = (LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(paramAnonymous2Int1);
                if ((paramAnonymous2RecyclerView.vqP != null) && ((paramAnonymous2RecyclerView.vqP.GIb == 1) || (paramAnonymous2RecyclerView.vqP.FHA == 1)))
                {
                  ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "expired: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                  if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0)
                  {
                    ((LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).oBZ = false;
                    LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this), false);
                    LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this, -1);
                  }
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                  AppMethodBeat.o(163766);
                  return;
                }
                if (paramAnonymous2RecyclerView.oBZ) {
                  break label556;
                }
                ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do select pos: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0)
                {
                  ((LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).oBZ = false;
                  paramAnonymous2Int2 = LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this);
                  LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, paramAnonymous2Int2, false);
                }
                paramAnonymous2RecyclerView.oBZ = true;
                LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this, paramAnonymous2Int1);
                LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this), true);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(163766);
                return;
                label556:
                paramAnonymous2RecyclerView.oBZ = false;
                LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this, -1);
              }
            }
            
            public final void b(RecyclerView paramAnonymous2RecyclerView, int paramAnonymous2Int)
            {
              AppMethodBeat.i(163765);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2RecyclerView);
              localb.mr(paramAnonymous2Int);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
              super.b(paramAnonymous2RecyclerView, paramAnonymous2Int);
              ad.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "on scroll changed: %s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
              if (paramAnonymous2Int == 0)
              {
                if ((!LuckyMoneyPickEnvelopeUI.r(LuckyMoneyPickEnvelopeUI.this)) && (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0))
                {
                  paramAnonymous2RecyclerView = (LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
                  com.tencent.mm.plugin.report.service.g.yhR.f(19272, new Object[] { Integer.valueOf(1), LuckyMoneyPickEnvelopeUI.d(LuckyMoneyPickEnvelopeUI.this), paramAnonymous2RecyclerView.vqP.Gat });
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
    this.vzt.post(local2);
    AppMethodBeat.o(163791);
  }
  
  private void oc(final boolean paramBoolean)
  {
    AppMethodBeat.i(163790);
    ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do get show source: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), this.vzA });
    if (paramBoolean) {
      this.vzA = "";
    }
    this.tipDialog = h.a(getContext(), 3, 2131820985, getString(2131760709), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    this.isLoading = true;
    com.tencent.mm.plugin.luckymoney.model.g localg = com.tencent.mm.plugin.luckymoney.model.g.dig();
    localg.b(new com.tencent.mm.plugin.luckymoney.model.c(this.vzA));
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
    this.vzt = ((LuckyMoneyEnvelopeTouchRecyclerView)findViewById(2131301483));
    this.GG = findViewById(2131301481);
    this.vzC = ((TextView)findViewById(2131301482));
    this.vzu = new a((byte)0);
    this.vzu.av(true);
    this.vzt.setAdapter(this.vzu);
    this.vzt.setItemAnimator(null);
    this.vzt.setItemViewCacheSize(-1);
    this.vzv = new ScaleLayoutManager(this)
    {
      public final void div()
      {
        AppMethodBeat.i(65792);
        super.div();
        this.vrp -= 31.0F;
        AppMethodBeat.o(65792);
      }
    };
    Object localObject = this.vzv;
    ((ScaleLayoutManager)localObject).F(null);
    if (((ScaleLayoutManager)localObject).aXF != 0.8F)
    {
      ((ScaleLayoutManager)localObject).aXF = 0.8F;
      ((ScaleLayoutManager)localObject).removeAllViews();
    }
    this.vzt.setLayoutManager(this.vzv);
    this.vzB = new com.tencent.mm.plugin.luckymoney.scaledLayout.a();
    this.vzB.context = this;
    this.vzB.j(this.vzt);
    this.vzt.vxk = new LuckyMoneyEnvelopeTouchRecyclerView.a()
    {
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(65793);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          paramAnonymousMotionEvent = LuckyMoneyPickEnvelopeUI.this;
          LuckyMoneyPickEnvelopeUI.g(LuckyMoneyPickEnvelopeUI.this);
          LuckyMoneyPickEnvelopeUI.a(paramAnonymousMotionEvent, com.tencent.mm.plugin.luckymoney.scaledLayout.a.h(LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this)));
          LuckyMoneyPickEnvelopeUI.g(LuckyMoneyPickEnvelopeUI.this).vqW = LuckyMoneyPickEnvelopeUI.h(LuckyMoneyPickEnvelopeUI.this);
        }
        AppMethodBeat.o(65793);
        return false;
      }
    };
    localObject = getIntent().getStringExtra(e.g.IUz);
    final String str = getIntent().getStringExtra(e.g.IUA);
    if (!bt.isNullOrNil((String)localObject))
    {
      this.vzC.setText((CharSequence)localObject);
      this.vzC.setVisibility(0);
      this.vzC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(163772);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          ad.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "click exchange tv");
          paramAnonymousView = Uri.parse(str).buildUpon();
          paramAnonymousView.appendQueryParameter("sessionId", LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this));
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramAnonymousView.build().toString());
          ((Intent)localObject).putExtra("showShare", false);
          ((Intent)localObject).putExtra("KRightBtn", true);
          com.tencent.mm.wallet_core.ui.e.b(LuckyMoneyPickEnvelopeUI.this.getContext(), (Intent)localObject, 1);
          paramAnonymousView = com.tencent.mm.plugin.report.service.g.yhR;
          if (LuckyMoneyPickEnvelopeUI.i(LuckyMoneyPickEnvelopeUI.this).booleanValue()) {}
          for (int i = 2;; i = 1)
          {
            paramAnonymousView.f(18890, new Object[] { Integer.valueOf(3), Integer.valueOf(i), LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(163772);
            return;
          }
        }
      });
      AppMethodBeat.o(65815);
      return;
    }
    this.vzC.setVisibility(8);
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
    paramBundle = getIntent().getByteArrayExtra(e.g.IUx);
    boolean bool = getIntent().getBooleanExtra(e.g.IUy, true);
    this.vzG = Boolean.valueOf(getIntent().getBooleanExtra(e.g.IUB, false));
    this.sessionId = getIntent().getStringExtra("key_session_id");
    this.vzI = getIntent().getStringExtra("packetId");
    ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll packageid: %s", new Object[] { this.vzI });
    if (bool) {
      if (paramBundle == null) {}
    }
    for (;;)
    {
      try
      {
        paramBundle = (bip)new bip().parseFrom(paramBundle);
        if (paramBundle.dlw == 0)
        {
          this.vzA = paramBundle.GDl;
          this.vkm = paramBundle.GDm;
          a(paramBundle, true);
          djB();
          setBackBtn(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(65787);
              paramAnonymousMenuItem = "";
              if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) {
                paramAnonymousMenuItem = ((LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).vqP.Gat;
              }
              com.tencent.mm.plugin.report.service.g.yhR.f(18892, new Object[] { Integer.valueOf(2), Integer.valueOf(LuckyMoneyPickEnvelopeUI.c(LuckyMoneyPickEnvelopeUI.this) + 1), Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) + 1), LuckyMoneyPickEnvelopeUI.d(LuckyMoneyPickEnvelopeUI.this), paramAnonymousMenuItem, LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this) });
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
                if ((!paramAnonymousMenuItem.oBZ) || (paramAnonymousMenuItem.vqP == null)) {}
              }
              for (paramAnonymousMenuItem = paramAnonymousMenuItem.vqP.Gat;; paramAnonymousMenuItem = "0")
              {
                LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, paramAnonymousMenuItem);
                com.tencent.mm.plugin.report.service.g.yhR.f(16822, new Object[] { Integer.valueOf(3) });
                paramAnonymousMenuItem = "";
                if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) {
                  paramAnonymousMenuItem = ((LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).vqP.Gat;
                }
                com.tencent.mm.plugin.report.service.g.yhR.f(18892, new Object[] { Integer.valueOf(1), Integer.valueOf(LuckyMoneyPickEnvelopeUI.c(LuckyMoneyPickEnvelopeUI.this) + 1), Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) + 1), LuckyMoneyPickEnvelopeUI.d(LuckyMoneyPickEnvelopeUI.this), paramAnonymousMenuItem, LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this) });
                AppMethodBeat.o(65791);
                return false;
              }
            }
          }, null, s.b.JbT);
          cJW();
          this.vzJ.alive();
          AppMethodBeat.o(65814);
          return;
        }
        oc(true);
        continue;
      }
      catch (IOException paramBundle)
      {
        ad.printErrStackTrace("MicroMsg.LuckyMoneyPickEnvelopeUI", paramBundle, "", new Object[0]);
        oc(true);
        continue;
      }
      oc(true);
      continue;
      this.vzz = false;
      this.vkm = 0;
      this.vzx = 0;
      paramBundle = new b((byte)0);
      paramBundle.oBZ = true;
      paramBundle.vqP = new bnu();
      paramBundle.vqP.Gat = "0";
      paramBundle.vqP.GHY = getString(2131760842);
      this.vzw.add(paramBundle);
      this.vzu.asY.notifyChanged();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65816);
    super.onDestroy();
    this.vzJ.dead();
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
      paramc.auu.setSelected(localb.oBZ);
      a.b.a(paramc.fRd, u.aAm(), 0.06F, false);
      paramc.opA.setText(k.b(paramc.vzL.getContext(), u.aAo(), com.tencent.mm.cc.a.ax(paramc.vzL.getContext(), 2131165574)));
      paramc.vzT.setImageBitmap(null);
      paramc.vzU.setVisibility(8);
      if (localb.vqP != null)
      {
        paramc.fQd.setText(localb.vqP.GHY);
        if (localb.vqP.GHZ != null) {
          paramc.a(localb.vqP, false);
        }
        paramc.vzU.setOnClickListener(new LuckyMoneyPickEnvelopeUI.c.2(paramc, localb));
        if (!bt.isNullOrNil(localb.vqP.GIa))
        {
          paramc.vzY.setText(localb.vqP.GIa);
          paramc.vzY.setVisibility(0);
          if (localb.vqP.hzE != 2) {
            break label269;
          }
          paramc.vzZ.setVisibility(0);
        }
        for (;;)
        {
          if ((localb.vqP.hzE != 1) || (bt.isNullOrNil(localb.vqP.GIf))) {
            break label281;
          }
          paramc.vzY.setVisibility(0);
          paramc.vzY.setText(localb.vqP.GIf);
          AppMethodBeat.o(163777);
          return;
          paramc.vzY.setText("");
          break;
          label269:
          paramc.vzZ.setVisibility(8);
        }
        label281:
        if (localb.vqP.FHA == 1)
        {
          paramc.auu.setSelected(false);
          paramc.vAa.setEnabled(false);
          paramc.vzY.setVisibility(0);
          if (!bt.isNullOrNil(localb.vqP.GIe)) {
            paramc.vzY.setText(localb.vqP.GIe);
          }
          paramc.djE();
          AppMethodBeat.o(163777);
          return;
        }
        if (localb.vqP.GIb == 1)
        {
          paramc.auu.setSelected(false);
          paramc.vAa.setEnabled(false);
          if (!bt.isNullOrNil(localb.vqP.GIa))
          {
            paramc.vzY.setText(localb.vqP.GIa);
            paramc.vzY.setVisibility(0);
          }
          paramc.djE();
          AppMethodBeat.o(163777);
          return;
        }
        if (LuckyMoneyPickEnvelopeUI.e(paramc.vzL, localb.vqP.Gat))
        {
          paramc.auu.setSelected(false);
          paramc.vAa.setEnabled(false);
          paramc.vzY.setText(2131760852);
          paramc.vzY.setVisibility(0);
          paramc.djE();
          AppMethodBeat.o(163777);
          return;
        }
        paramc.vAa.setEnabled(true);
        if (bt.ai(paramc.vzY.getText())) {
          paramc.vzY.setVisibility(4);
        }
        paramc.vzU.setVisibility(8);
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
    public boolean oBZ = false;
    public bnu vqP;
  }
  
  final class c
    extends RecyclerView.w
  {
    TextView fQd;
    ImageView fRd;
    TextView opA;
    private Dialog tipDialog;
    ViewGroup vAa;
    ProgressBar vAb;
    ImageView vzT;
    View vzU;
    ImageView vzV;
    ProgressBar vzW;
    TextView vzX;
    TextView vzY;
    TextView vzZ;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(65810);
      this.tipDialog = null;
      this.vAa = ((ViewGroup)paramView.findViewById(2131301470));
      this.vzT = ((ImageView)paramView.findViewById(2131301471));
      this.fQd = ((TextView)paramView.findViewById(2131301473));
      this.fRd = ((ImageView)paramView.findViewById(2131301469));
      this.opA = ((TextView)paramView.findViewById(2131301477));
      this.vzU = paramView.findViewById(2131301479);
      this.vzV = ((ImageView)paramView.findViewById(2131301476));
      this.vzW = ((ProgressBar)paramView.findViewById(2131301468));
      this.vzX = ((TextView)paramView.findViewById(2131301478));
      this.vzY = ((TextView)paramView.findViewById(2131301472));
      this.vzZ = ((TextView)paramView.findViewById(2131307210));
      this.vAb = ((ProgressBar)paramView.findViewById(2131301475));
      if (al.isDarkMode()) {
        this.vAa.setBackgroundResource(2131233104);
      }
      for (;;)
      {
        this$1 = new View.OnLongClickListener()
        {
          public final boolean onLongClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(163781);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$VH$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            if (!LuckyMoneyPickEnvelopeUI.x(LuckyMoneyPickEnvelopeUI.this))
            {
              com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$VH$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
              AppMethodBeat.o(163781);
              return false;
            }
            paramAnonymousView = LuckyMoneyPickEnvelopeUI.p(LuckyMoneyPickEnvelopeUI.this).bt(paramAnonymousView);
            LuckyMoneyPickEnvelopeUI.p(LuckyMoneyPickEnvelopeUI.this);
            int i = LuckyMoneyEnvelopeTouchRecyclerView.bw(paramAnonymousView);
            LuckyMoneyPickEnvelopeUI.g(LuckyMoneyPickEnvelopeUI.this);
            localObject = com.tencent.mm.plugin.luckymoney.scaledLayout.a.h(LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this));
            if ((i >= 0) && (i < LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).size()) && (paramAnonymousView == localObject))
            {
              ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "delete pos: %s", new Object[] { Integer.valueOf(i) });
              paramAnonymousView = (LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(i);
              if ((paramAnonymousView != null) && (paramAnonymousView.vqP != null))
              {
                if ("0".equals(paramAnonymousView.vqP.Gat))
                {
                  ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "can not delete default envelope");
                  com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$VH$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                  AppMethodBeat.o(163781);
                  return false;
                }
                localObject = new com.tencent.mm.ui.widget.a.e(LuckyMoneyPickEnvelopeUI.this.getContext(), 1, true);
                TextView localTextView = new TextView(LuckyMoneyPickEnvelopeUI.this.getContext());
                localTextView.setPadding(0, 0, 0, com.tencent.mm.cc.a.fromDPToPix(LuckyMoneyPickEnvelopeUI.this.getContext(), 9));
                localTextView.setMinHeight(com.tencent.mm.cc.a.ax(LuckyMoneyPickEnvelopeUI.this.getContext(), 2131165204));
                localTextView.setTextSize(14.0F);
                localTextView.setTextColor(LuckyMoneyPickEnvelopeUI.this.getResources().getColor(2131100482));
                localTextView.setText(2131760927);
                localTextView.setGravity(81);
                ((com.tencent.mm.ui.widget.a.e)localObject).K(localTextView, true);
                ((com.tencent.mm.ui.widget.a.e)localObject).KJy = new n.d()
                {
                  public final void onCreateMMMenu(l paramAnonymous2l)
                  {
                    AppMethodBeat.i(163779);
                    paramAnonymous2l.a(0, LuckyMoneyPickEnvelopeUI.this.getResources().getColor(2131099803), LuckyMoneyPickEnvelopeUI.this.getString(2131760926));
                    AppMethodBeat.o(163779);
                  }
                };
                ((com.tencent.mm.ui.widget.a.e)localObject).KJz = new n.e()
                {
                  public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(163780);
                    if (paramAnonymous2MenuItem.getItemId() == 0) {
                      LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this, paramAnonymousView.vqP.Gat);
                    }
                    AppMethodBeat.o(163780);
                  }
                };
                ((com.tencent.mm.ui.widget.a.e)localObject).cMW();
              }
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$VH$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(163781);
            return false;
          }
        };
        paramView.setOnLongClickListener(LuckyMoneyPickEnvelopeUI.this);
        this.vzU.setOnLongClickListener(LuckyMoneyPickEnvelopeUI.this);
        AppMethodBeat.o(65810);
        return;
        this.vAa.setBackgroundResource(2131233102);
      }
    }
    
    final void a(final bnu parambnu, boolean paramBoolean)
    {
      AppMethodBeat.i(65811);
      if (paramBoolean)
      {
        this.vzV.setVisibility(8);
        this.vzW.setVisibility(0);
        this.vzX.setVisibility(8);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.vzT, parambnu, new com.tencent.mm.plugin.luckymoney.a.a.a()
        {
          public final void iK(final boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(163784);
            ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "load ok: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            Runnable local1 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(163783);
                LuckyMoneyPickEnvelopeUI.c.this.vAb.setVisibility(8);
                if ((LuckyMoneyPickEnvelopeUI.c.a(LuckyMoneyPickEnvelopeUI.c.this) != null) && (LuckyMoneyPickEnvelopeUI.c.a(LuckyMoneyPickEnvelopeUI.c.this).isShowing())) {
                  LuckyMoneyPickEnvelopeUI.c.a(LuckyMoneyPickEnvelopeUI.c.this).dismiss();
                }
                if ((LuckyMoneyPickEnvelopeUI.c.3.this.vAg.GIb == 1) || (LuckyMoneyPickEnvelopeUI.c.3.this.vAg.FHA == 1))
                {
                  ad.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "envelope has expired do nothing");
                  AppMethodBeat.o(163783);
                  return;
                }
                if (!paramAnonymousBoolean)
                {
                  LuckyMoneyPickEnvelopeUI.c.this.vzU.setVisibility(0);
                  LuckyMoneyPickEnvelopeUI.c.this.vzV.setVisibility(0);
                  LuckyMoneyPickEnvelopeUI.c.this.vzW.setVisibility(8);
                  LuckyMoneyPickEnvelopeUI.c.this.vzX.setVisibility(0);
                  AppMethodBeat.o(163783);
                  return;
                }
                LuckyMoneyPickEnvelopeUI.c.this.vzU.setVisibility(8);
                AppMethodBeat.o(163783);
              }
            };
            if (aq.isMainThread())
            {
              local1.run();
              AppMethodBeat.o(163784);
              return;
            }
            LuckyMoneyPickEnvelopeUI.c.this.vzU.post(local1);
            AppMethodBeat.o(163784);
          }
        });
        AppMethodBeat.o(65811);
        return;
        if ("0".equals(parambnu.Gat))
        {
          ad.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "default envelope");
          AppMethodBeat.o(65811);
          return;
        }
        this.vAb.setVisibility(0);
      }
    }
    
    final void djE()
    {
      AppMethodBeat.i(163786);
      this.vzU.setVisibility(0);
      this.vzV.setVisibility(8);
      this.vzW.setVisibility(8);
      this.vzX.setVisibility(8);
      this.vzU.setOnClickListener(null);
      AppMethodBeat.o(163786);
    }
    
    public final void od(boolean paramBoolean)
    {
      AppMethodBeat.i(163785);
      this.auu.setSelected(paramBoolean);
      AppMethodBeat.o(163785);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI
 * JD-Core Version:    0.7.0.1
 */