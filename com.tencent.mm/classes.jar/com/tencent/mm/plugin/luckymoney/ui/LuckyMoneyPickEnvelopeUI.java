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
import com.tencent.mm.ak.c.a;
import com.tencent.mm.g.a.qa;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.luckymoney.scaledLayout.ScaleLayoutManager;
import com.tencent.mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.beh;
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.protocal.protobuf.yy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
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
  private View EP;
  private boolean isLoading;
  private String sessionId;
  private Dialog tipDialog;
  private int uhC;
  private View uos;
  private LuckyMoneyEnvelopeTouchRecyclerView uwQ;
  private a uwR;
  private ScaleLayoutManager uwS;
  private List<b> uwT;
  private int uwU;
  private int uwV;
  private boolean uwW;
  private String uwX;
  private com.tencent.mm.plugin.luckymoney.scaledLayout.a uwY;
  private TextView uwZ;
  private LinkedList<String> uxa;
  private RecyclerView.m uxb;
  private boolean uxc;
  private Boolean uxd;
  private String uxe;
  private String uxf;
  private com.tencent.mm.sdk.b.c<qa> uxg;
  private boolean uxh;
  
  public LuckyMoneyPickEnvelopeUI()
  {
    AppMethodBeat.i(65813);
    this.uwT = new ArrayList();
    this.uwU = -1;
    this.uwV = -1;
    this.uwW = false;
    this.isLoading = false;
    this.uhC = 0;
    this.uxc = true;
    this.uxg = new com.tencent.mm.sdk.b.c() {};
    this.uxh = false;
    AppMethodBeat.o(65813);
  }
  
  private void a(beh parambeh)
  {
    AppMethodBeat.i(65818);
    ac.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "try show illegal msg");
    if (bs.isNullOrNil(parambeh.ulf))
    {
      AppMethodBeat.o(65818);
      return;
    }
    ArrayList localArrayList = new ArrayList(bs.lp((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GQc, ""), ","));
    this.uxa = parambeh.ETQ;
    Iterator localIterator = this.uxa.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (localArrayList.contains(str)) {
        break label200;
      }
      localArrayList.add(str);
      ac.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "show illegal id: %s", new Object[] { str });
      i = 1;
    }
    label200:
    for (;;)
    {
      break;
      if (i != 0)
      {
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQc, bs.n(localArrayList, ","));
        com.tencent.mm.ui.base.h.a(this, parambeh.ulf, "", getString(2131755793), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      AppMethodBeat.o(65818);
      return;
    }
  }
  
  private void a(beh parambeh, boolean paramBoolean)
  {
    AppMethodBeat.i(207115);
    ac.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "update by resp");
    boolean bool;
    if (parambeh.ETR == 1)
    {
      bool = true;
      this.uwW = bool;
      a(parambeh);
      if (parambeh.ETN != null)
      {
        if (!parambeh.ETN.isEmpty()) {
          break label97;
        }
        this.EP.setVisibility(0);
        this.uwQ.setVisibility(8);
      }
    }
    for (;;)
    {
      this.uwR.arg.notifyChanged();
      cBW();
      AppMethodBeat.o(207115);
      return;
      bool = false;
      break;
      label97:
      ac.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "list size: %s", new Object[] { Integer.valueOf(parambeh.ETN.size()) });
      if (!bs.isNullOrNil(this.uxf)) {}
      int i;
      int j;
      bjm localbjm;
      b localb;
      int n;
      int k;
      for (int m = 1;; m = 0)
      {
        parambeh = parambeh.ETN.iterator();
        i = 0;
        for (j = -1;; j = n)
        {
          if (!parambeh.hasNext()) {
            break label370;
          }
          localbjm = (bjm)parambeh.next();
          localb = new b((byte)0);
          localb.uol = localbjm;
          n = j;
          if (paramBoolean)
          {
            if (m == 0) {
              break;
            }
            k = j;
            if (localbjm.Etc.equals(this.uxf))
            {
              localb.nYF = true;
              k = j;
            }
            n = k;
            if (localb.nYF)
            {
              this.uwU = i;
              n = k;
            }
          }
          this.uwT.add(localb);
          i += 1;
        }
      }
      if ((localbjm.EYF != 1) && (localbjm.EbO != 1) && (!akr(localbjm.Etc)))
      {
        n = 1;
        label310:
        if ((localbjm.EYG != 1) || (n == 0)) {
          break label364;
        }
      }
      label364:
      for (bool = true;; bool = false)
      {
        localb.nYF = bool;
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
      if (this.uwU < 0)
      {
        this.uwU = j;
        ((b)this.uwT.get(this.uwU)).nYF = true;
      }
      if (this.uxc)
      {
        this.uxc = false;
        this.uwV = this.uwU;
        if (this.uwV >= 0) {
          this.uxe = ((b)this.uwT.get(this.uwV)).uol.Etc;
        }
      }
    }
  }
  
  private boolean akr(String paramString)
  {
    AppMethodBeat.i(163789);
    if ((this.uxa != null) && (!this.uxa.isEmpty()))
    {
      Iterator localIterator = this.uxa.iterator();
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
  
  private void cBW()
  {
    AppMethodBeat.i(163792);
    if (this.uwU == -1)
    {
      enableOptionMenu(1, false);
      AppMethodBeat.o(163792);
      return;
    }
    enableOptionMenu(1, true);
    AppMethodBeat.o(163792);
  }
  
  private void dao()
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
          ac.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll to pos: %s", new Object[] { Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this)) });
          localLuckyMoneyEnvelopeTouchRecyclerView = LuckyMoneyPickEnvelopeUI.p(LuckyMoneyPickEnvelopeUI.this);
          ScaleLayoutManager localScaleLayoutManager = LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this);
          i = localScaleLayoutManager.wm(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
          if (localScaleLayoutManager.mOrientation == 1) {
            localLuckyMoneyEnvelopeTouchRecyclerView.scrollBy(0, i);
          }
        }
        else
        {
          Math.max(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this), 0);
          LuckyMoneyPickEnvelopeUI.dap();
          if (LuckyMoneyPickEnvelopeUI.q(LuckyMoneyPickEnvelopeUI.this) != null) {
            break label174;
          }
          LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, new RecyclerView.m()
          {
            public final void a(RecyclerView paramAnonymous2RecyclerView, int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(163766);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bb(paramAnonymous2RecyclerView);
              localb.lS(paramAnonymous2Int1);
              localb.lS(paramAnonymous2Int2);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
              super.a(paramAnonymous2RecyclerView, paramAnonymous2Int1, paramAnonymous2Int2);
              paramAnonymous2Int1 = LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this).jY();
              ac.v("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll last vispos: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
              if ((!LuckyMoneyPickEnvelopeUI.u(LuckyMoneyPickEnvelopeUI.this)) && (LuckyMoneyPickEnvelopeUI.l(LuckyMoneyPickEnvelopeUI.this) == 1) && (paramAnonymous2Int1 == LuckyMoneyPickEnvelopeUI.o(LuckyMoneyPickEnvelopeUI.this).getItemCount() - 1))
              {
                ac.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "trigger load more: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, false);
              }
              LuckyMoneyPickEnvelopeUI.g(LuckyMoneyPickEnvelopeUI.this);
              paramAnonymous2RecyclerView = com.tencent.mm.plugin.luckymoney.scaledLayout.a.h(LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this));
              LuckyMoneyPickEnvelopeUI.p(LuckyMoneyPickEnvelopeUI.this);
              paramAnonymous2Int1 = LuckyMoneyEnvelopeTouchRecyclerView.bw(paramAnonymous2RecyclerView);
              LuckyMoneyPickEnvelopeUI.daq();
              if ((paramAnonymous2Int1 != LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this)) && (paramAnonymous2Int1 >= 0) && (paramAnonymous2Int1 < LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).size()))
              {
                paramAnonymous2RecyclerView = (LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(paramAnonymous2Int1);
                if ((paramAnonymous2RecyclerView.uol != null) && ((paramAnonymous2RecyclerView.uol.EYF == 1) || (paramAnonymous2RecyclerView.uol.EbO == 1)))
                {
                  ac.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "expired: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                  if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0)
                  {
                    ((LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).nYF = false;
                    LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this), false);
                    LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this, -1);
                  }
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                  AppMethodBeat.o(163766);
                  return;
                }
                if (paramAnonymous2RecyclerView.nYF) {
                  break label556;
                }
                ac.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do select pos: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0)
                {
                  ((LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).nYF = false;
                  paramAnonymous2Int2 = LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this);
                  LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, paramAnonymous2Int2, false);
                }
                paramAnonymous2RecyclerView.nYF = true;
                LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this, paramAnonymous2Int1);
                LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this), true);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(163766);
                return;
                label556:
                paramAnonymous2RecyclerView.nYF = false;
                LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this, -1);
              }
            }
            
            public final void b(RecyclerView paramAnonymous2RecyclerView, int paramAnonymous2Int)
            {
              AppMethodBeat.i(163765);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bb(paramAnonymous2RecyclerView);
              localb.lS(paramAnonymous2Int);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
              super.b(paramAnonymous2RecyclerView, paramAnonymous2Int);
              ac.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "on scroll changed: %s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
              if (paramAnonymous2Int == 0)
              {
                if ((!LuckyMoneyPickEnvelopeUI.r(LuckyMoneyPickEnvelopeUI.this)) && (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0))
                {
                  paramAnonymous2RecyclerView = (LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
                  com.tencent.mm.plugin.report.service.h.wUl.f(19272, new Object[] { Integer.valueOf(1), LuckyMoneyPickEnvelopeUI.d(LuckyMoneyPickEnvelopeUI.this), paramAnonymous2RecyclerView.uol.Etc });
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
    this.uwQ.post(local2);
    AppMethodBeat.o(163791);
  }
  
  private void nI(final boolean paramBoolean)
  {
    AppMethodBeat.i(163790);
    ac.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do get show source: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), this.uwX });
    if (paramBoolean) {
      this.uwX = "";
    }
    this.tipDialog = com.tencent.mm.ui.base.h.a(getContext(), 3, 2131820985, getString(2131760709), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    this.isLoading = true;
    com.tencent.mm.plugin.luckymoney.model.g localg = com.tencent.mm.plugin.luckymoney.model.g.cYU();
    localg.b(new com.tencent.mm.plugin.luckymoney.model.c(this.uwX));
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
    this.uwQ = ((LuckyMoneyEnvelopeTouchRecyclerView)findViewById(2131301483));
    this.EP = findViewById(2131301481);
    this.uwZ = ((TextView)findViewById(2131301482));
    this.uwR = new a((byte)0);
    this.uwR.av(true);
    this.uwQ.setAdapter(this.uwR);
    this.uwQ.setItemAnimator(null);
    this.uwQ.setItemViewCacheSize(-1);
    this.uwS = new ScaleLayoutManager(this)
    {
      public final void cZj()
      {
        AppMethodBeat.i(65792);
        super.cZj();
        this.uoL -= 31.0F;
        AppMethodBeat.o(65792);
      }
    };
    Object localObject = this.uwS;
    ((ScaleLayoutManager)localObject).G(null);
    if (((ScaleLayoutManager)localObject).aNl != 0.8F)
    {
      ((ScaleLayoutManager)localObject).aNl = 0.8F;
      ((ScaleLayoutManager)localObject).removeAllViews();
    }
    this.uwQ.setLayoutManager(this.uwS);
    this.uwY = new com.tencent.mm.plugin.luckymoney.scaledLayout.a();
    this.uwY.context = this;
    this.uwY.j(this.uwQ);
    this.uwQ.uuH = new LuckyMoneyEnvelopeTouchRecyclerView.a()
    {
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(65793);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          paramAnonymousMotionEvent = LuckyMoneyPickEnvelopeUI.this;
          LuckyMoneyPickEnvelopeUI.g(LuckyMoneyPickEnvelopeUI.this);
          LuckyMoneyPickEnvelopeUI.a(paramAnonymousMotionEvent, com.tencent.mm.plugin.luckymoney.scaledLayout.a.h(LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this)));
          LuckyMoneyPickEnvelopeUI.g(LuckyMoneyPickEnvelopeUI.this).uos = LuckyMoneyPickEnvelopeUI.h(LuckyMoneyPickEnvelopeUI.this);
        }
        AppMethodBeat.o(65793);
        return false;
      }
    };
    localObject = getIntent().getStringExtra(e.g.Hhj);
    final String str = getIntent().getStringExtra(e.g.Hhk);
    if (!bs.isNullOrNil((String)localObject))
    {
      this.uwZ.setText((CharSequence)localObject);
      this.uwZ.setVisibility(0);
      this.uwZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(163772);
          ac.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "click exchange tv");
          paramAnonymousView = Uri.parse(str).buildUpon();
          paramAnonymousView.appendQueryParameter("sessionId", LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this));
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", paramAnonymousView.build().toString());
          localIntent.putExtra("showShare", false);
          localIntent.putExtra("KRightBtn", true);
          com.tencent.mm.wallet_core.ui.e.b(LuckyMoneyPickEnvelopeUI.this.getContext(), localIntent, 1);
          paramAnonymousView = com.tencent.mm.plugin.report.service.h.wUl;
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
    this.uwZ.setVisibility(8);
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
    paramBundle = getIntent().getByteArrayExtra(e.g.Hhh);
    boolean bool = getIntent().getBooleanExtra(e.g.Hhi, true);
    this.uxd = Boolean.valueOf(getIntent().getBooleanExtra(e.g.Hhl, false));
    this.sessionId = getIntent().getStringExtra("key_session_id");
    this.uxf = getIntent().getStringExtra("packetId");
    ac.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll packageid: %s", new Object[] { this.uxf });
    if (bool) {
      if (paramBundle == null) {}
    }
    for (;;)
    {
      try
      {
        paramBundle = (beh)new beh().parseFrom(paramBundle);
        if (paramBundle.dae == 0)
        {
          this.uwX = paramBundle.ETO;
          this.uhC = paramBundle.ETP;
          a(paramBundle, true);
          dao();
          setBackBtn(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(65787);
              paramAnonymousMenuItem = "";
              if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) {
                paramAnonymousMenuItem = ((LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).uol.Etc;
              }
              com.tencent.mm.plugin.report.service.h.wUl.f(18892, new Object[] { Integer.valueOf(2), Integer.valueOf(LuckyMoneyPickEnvelopeUI.c(LuckyMoneyPickEnvelopeUI.this) + 1), Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) + 1), LuckyMoneyPickEnvelopeUI.d(LuckyMoneyPickEnvelopeUI.this), paramAnonymousMenuItem, LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this) });
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
              ac.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "click save: %s", new Object[] { Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this)) });
              if ((LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) && (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) < LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).size()))
              {
                paramAnonymousMenuItem = (LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
                if ((!paramAnonymousMenuItem.nYF) || (paramAnonymousMenuItem.uol == null)) {}
              }
              for (paramAnonymousMenuItem = paramAnonymousMenuItem.uol.Etc;; paramAnonymousMenuItem = "0")
              {
                LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, paramAnonymousMenuItem);
                com.tencent.mm.plugin.report.service.h.wUl.f(16822, new Object[] { Integer.valueOf(3) });
                paramAnonymousMenuItem = "";
                if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) {
                  paramAnonymousMenuItem = ((LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).uol.Etc;
                }
                com.tencent.mm.plugin.report.service.h.wUl.f(18892, new Object[] { Integer.valueOf(1), Integer.valueOf(LuckyMoneyPickEnvelopeUI.c(LuckyMoneyPickEnvelopeUI.this) + 1), Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) + 1), LuckyMoneyPickEnvelopeUI.d(LuckyMoneyPickEnvelopeUI.this), paramAnonymousMenuItem, LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this) });
                AppMethodBeat.o(65791);
                return false;
              }
            }
          }, null, s.b.Hon);
          cBW();
          this.uxg.alive();
          AppMethodBeat.o(65814);
          return;
        }
        nI(true);
        continue;
      }
      catch (IOException paramBundle)
      {
        ac.printErrStackTrace("MicroMsg.LuckyMoneyPickEnvelopeUI", paramBundle, "", new Object[0]);
        nI(true);
        continue;
      }
      nI(true);
      continue;
      this.uwW = false;
      this.uhC = 0;
      this.uwU = 0;
      paramBundle = new b((byte)0);
      paramBundle.nYF = true;
      paramBundle.uol = new bjm();
      paramBundle.uol.Etc = "0";
      paramBundle.uol.EYC = getString(2131760842);
      this.uwT.add(paramBundle);
      this.uwR.arg.notifyChanged();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65816);
    super.onDestroy();
    this.uxg.dead();
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
      paramc.asD.setSelected(localb.nYF);
      a.b.a(paramc.fxQ, u.axw(), 0.06F, false);
      paramc.nMU.setText(k.b(paramc.uxi.getContext(), u.axy(), com.tencent.mm.cc.a.au(paramc.uxi.getContext(), 2131165574)));
      paramc.uxq.setImageBitmap(null);
      paramc.uxr.setVisibility(8);
      if (localb.uol != null)
      {
        paramc.fwQ.setText(localb.uol.EYC);
        if (localb.uol.EYD != null) {
          paramc.a(localb.uol, false);
        }
        paramc.uxr.setOnClickListener(new LuckyMoneyPickEnvelopeUI.c.2(paramc, localb));
        if (!bs.isNullOrNil(localb.uol.EYE))
        {
          paramc.uxv.setText(localb.uol.EYE);
          paramc.uxv.setVisibility(0);
          if (localb.uol.hhv != 2) {
            break label269;
          }
          paramc.uxw.setVisibility(0);
        }
        for (;;)
        {
          if ((localb.uol.hhv != 1) || (bs.isNullOrNil(localb.uol.EYJ))) {
            break label281;
          }
          paramc.uxv.setVisibility(0);
          paramc.uxv.setText(localb.uol.EYJ);
          AppMethodBeat.o(163777);
          return;
          paramc.uxv.setText("");
          break;
          label269:
          paramc.uxw.setVisibility(8);
        }
        label281:
        if (localb.uol.EbO == 1)
        {
          paramc.asD.setSelected(false);
          paramc.uxx.setEnabled(false);
          paramc.uxv.setVisibility(0);
          if (!bs.isNullOrNil(localb.uol.EYI)) {
            paramc.uxv.setText(localb.uol.EYI);
          }
          paramc.dar();
          AppMethodBeat.o(163777);
          return;
        }
        if (localb.uol.EYF == 1)
        {
          paramc.asD.setSelected(false);
          paramc.uxx.setEnabled(false);
          if (!bs.isNullOrNil(localb.uol.EYE))
          {
            paramc.uxv.setText(localb.uol.EYE);
            paramc.uxv.setVisibility(0);
          }
          paramc.dar();
          AppMethodBeat.o(163777);
          return;
        }
        if (LuckyMoneyPickEnvelopeUI.e(paramc.uxi, localb.uol.Etc))
        {
          paramc.asD.setSelected(false);
          paramc.uxx.setEnabled(false);
          paramc.uxv.setText(2131760852);
          paramc.uxv.setVisibility(0);
          paramc.dar();
          AppMethodBeat.o(163777);
          return;
        }
        paramc.uxx.setEnabled(true);
        if (bs.aj(paramc.uxv.getText())) {
          paramc.uxv.setVisibility(4);
        }
        paramc.uxr.setVisibility(8);
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
    public boolean nYF = false;
    public bjm uol;
  }
  
  final class c
    extends RecyclerView.w
  {
    TextView fwQ;
    ImageView fxQ;
    TextView nMU;
    private Dialog tipDialog;
    ImageView uxq;
    View uxr;
    ImageView uxs;
    ProgressBar uxt;
    TextView uxu;
    TextView uxv;
    TextView uxw;
    ViewGroup uxx;
    ProgressBar uxy;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(65810);
      this.tipDialog = null;
      this.uxx = ((ViewGroup)paramView.findViewById(2131301470));
      this.uxq = ((ImageView)paramView.findViewById(2131301471));
      this.fwQ = ((TextView)paramView.findViewById(2131301473));
      this.fxQ = ((ImageView)paramView.findViewById(2131301469));
      this.nMU = ((TextView)paramView.findViewById(2131301477));
      this.uxr = paramView.findViewById(2131301479);
      this.uxs = ((ImageView)paramView.findViewById(2131301476));
      this.uxt = ((ProgressBar)paramView.findViewById(2131301468));
      this.uxu = ((TextView)paramView.findViewById(2131301478));
      this.uxv = ((TextView)paramView.findViewById(2131301472));
      this.uxw = ((TextView)paramView.findViewById(2131307210));
      this.uxy = ((ProgressBar)paramView.findViewById(2131301475));
      if (aj.DT()) {
        this.uxx.setBackgroundResource(2131233104);
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
              ac.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "delete pos: %s", new Object[] { Integer.valueOf(i) });
              paramAnonymousView = (LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(i);
              if ((paramAnonymousView != null) && (paramAnonymousView.uol != null))
              {
                if ("0".equals(paramAnonymousView.uol.Etc))
                {
                  ac.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "can not delete default envelope");
                  AppMethodBeat.o(163781);
                  return false;
                }
                localObject = new com.tencent.mm.ui.widget.a.e(LuckyMoneyPickEnvelopeUI.this.getContext(), 1, true);
                TextView localTextView = new TextView(LuckyMoneyPickEnvelopeUI.this.getContext());
                localTextView.setPadding(0, 0, 0, com.tencent.mm.cc.a.fromDPToPix(LuckyMoneyPickEnvelopeUI.this.getContext(), 9));
                localTextView.setMinHeight(com.tencent.mm.cc.a.au(LuckyMoneyPickEnvelopeUI.this.getContext(), 2131165204));
                localTextView.setTextSize(14.0F);
                localTextView.setTextColor(LuckyMoneyPickEnvelopeUI.this.getResources().getColor(2131100482));
                localTextView.setText(2131760927);
                localTextView.setGravity(81);
                ((com.tencent.mm.ui.widget.a.e)localObject).J(localTextView, true);
                ((com.tencent.mm.ui.widget.a.e)localObject).ISu = new n.c()
                {
                  public final void onCreateMMMenu(l paramAnonymous2l)
                  {
                    AppMethodBeat.i(163779);
                    paramAnonymous2l.a(0, LuckyMoneyPickEnvelopeUI.this.getResources().getColor(2131099803), LuckyMoneyPickEnvelopeUI.this.getString(2131760926));
                    AppMethodBeat.o(163779);
                  }
                };
                ((com.tencent.mm.ui.widget.a.e)localObject).ISv = new n.d()
                {
                  public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(163780);
                    if (paramAnonymous2MenuItem.getItemId() == 0) {
                      LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this, paramAnonymousView.uol.Etc);
                    }
                    AppMethodBeat.o(163780);
                  }
                };
                ((com.tencent.mm.ui.widget.a.e)localObject).cED();
              }
            }
            AppMethodBeat.o(163781);
            return false;
          }
        };
        paramView.setOnLongClickListener(LuckyMoneyPickEnvelopeUI.this);
        this.uxr.setOnLongClickListener(LuckyMoneyPickEnvelopeUI.this);
        AppMethodBeat.o(65810);
        return;
        this.uxx.setBackgroundResource(2131233102);
      }
    }
    
    final void a(final bjm parambjm, boolean paramBoolean)
    {
      AppMethodBeat.i(65811);
      if (paramBoolean)
      {
        this.uxs.setVisibility(8);
        this.uxt.setVisibility(0);
        this.uxu.setVisibility(8);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.uxq, parambjm, new com.tencent.mm.plugin.luckymoney.a.a.a()
        {
          public final void iB(final boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(163784);
            ac.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "load ok: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            Runnable local1 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(163783);
                LuckyMoneyPickEnvelopeUI.c.this.uxy.setVisibility(8);
                if ((LuckyMoneyPickEnvelopeUI.c.a(LuckyMoneyPickEnvelopeUI.c.this) != null) && (LuckyMoneyPickEnvelopeUI.c.a(LuckyMoneyPickEnvelopeUI.c.this).isShowing())) {
                  LuckyMoneyPickEnvelopeUI.c.a(LuckyMoneyPickEnvelopeUI.c.this).dismiss();
                }
                if ((LuckyMoneyPickEnvelopeUI.c.3.this.uxD.EYF == 1) || (LuckyMoneyPickEnvelopeUI.c.3.this.uxD.EbO == 1))
                {
                  ac.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "envelope has expired do nothing");
                  AppMethodBeat.o(163783);
                  return;
                }
                if (!paramAnonymousBoolean)
                {
                  LuckyMoneyPickEnvelopeUI.c.this.uxr.setVisibility(0);
                  LuckyMoneyPickEnvelopeUI.c.this.uxs.setVisibility(0);
                  LuckyMoneyPickEnvelopeUI.c.this.uxt.setVisibility(8);
                  LuckyMoneyPickEnvelopeUI.c.this.uxu.setVisibility(0);
                  AppMethodBeat.o(163783);
                  return;
                }
                LuckyMoneyPickEnvelopeUI.c.this.uxr.setVisibility(8);
                AppMethodBeat.o(163783);
              }
            };
            if (ap.isMainThread())
            {
              local1.run();
              AppMethodBeat.o(163784);
              return;
            }
            LuckyMoneyPickEnvelopeUI.c.this.uxr.post(local1);
            AppMethodBeat.o(163784);
          }
        });
        AppMethodBeat.o(65811);
        return;
        if ("0".equals(parambjm.Etc))
        {
          ac.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "default envelope");
          AppMethodBeat.o(65811);
          return;
        }
        this.uxy.setVisibility(0);
      }
    }
    
    final void dar()
    {
      AppMethodBeat.i(163786);
      this.uxr.setVisibility(0);
      this.uxs.setVisibility(8);
      this.uxt.setVisibility(8);
      this.uxu.setVisibility(8);
      this.uxr.setOnClickListener(null);
      AppMethodBeat.o(163786);
    }
    
    public final void nJ(boolean paramBoolean)
    {
      AppMethodBeat.i(163785);
      this.asD.setSelected(paramBoolean);
      AppMethodBeat.o(163785);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI
 * JD-Core Version:    0.7.0.1
 */