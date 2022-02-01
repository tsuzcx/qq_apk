package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
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
import com.tencent.mm.g.a.qm;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.luckymoney.scaledLayout.ScaleLayoutManager;
import com.tencent.mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  private View vDb;
  private List<b> vLA;
  private int vLB;
  private int vLC;
  private boolean vLD;
  private String vLE;
  private com.tencent.mm.plugin.luckymoney.scaledLayout.a vLF;
  private TextView vLG;
  private LinkedList<String> vLH;
  private RecyclerView.m vLI;
  private boolean vLJ;
  private Boolean vLK;
  private String vLL;
  private String vLM;
  private com.tencent.mm.sdk.b.c<qm> vLN;
  private boolean vLO;
  private LuckyMoneyEnvelopeTouchRecyclerView vLx;
  private a vLy;
  private ScaleLayoutManager vLz;
  private int vwr;
  
  public LuckyMoneyPickEnvelopeUI()
  {
    AppMethodBeat.i(65813);
    this.vLA = new ArrayList();
    this.vLB = -1;
    this.vLC = -1;
    this.vLD = false;
    this.isLoading = false;
    this.vwr = 0;
    this.vLJ = true;
    this.vLN = new com.tencent.mm.sdk.b.c() {};
    this.vLO = false;
    AppMethodBeat.o(65813);
  }
  
  private void a(bjf parambjf)
  {
    AppMethodBeat.i(65818);
    ae.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "try show illegal msg");
    if (bu.isNullOrNil(parambjf.vzQ))
    {
      AppMethodBeat.o(65818);
      return;
    }
    ArrayList localArrayList = new ArrayList(bu.lV((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWW, ""), ","));
    this.vLH = parambjf.GWN;
    Iterator localIterator = this.vLH.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (localArrayList.contains(str)) {
        break label200;
      }
      localArrayList.add(str);
      ae.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "show illegal id: %s", new Object[] { str });
      i = 1;
    }
    label200:
    for (;;)
    {
      break;
      if (i != 0)
      {
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWW, bu.m(localArrayList, ","));
        h.a(this, parambjf.vzQ, "", getString(2131755793), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      AppMethodBeat.o(65818);
      return;
    }
  }
  
  private void a(bjf parambjf, boolean paramBoolean)
  {
    AppMethodBeat.i(189856);
    ae.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "update by resp");
    boolean bool;
    if (parambjf.GWO == 1)
    {
      bool = true;
      this.vLD = bool;
      a(parambjf);
      if (parambjf.GWK != null)
      {
        if (!parambjf.GWK.isEmpty()) {
          break label97;
        }
        this.GG.setVisibility(0);
        this.vLx.setVisibility(8);
      }
    }
    for (;;)
    {
      this.vLy.asY.notifyChanged();
      cMz();
      AppMethodBeat.o(189856);
      return;
      bool = false;
      break;
      label97:
      ae.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "list size: %s", new Object[] { Integer.valueOf(parambjf.GWK.size()) });
      if (!bu.isNullOrNil(this.vLM)) {}
      int i;
      int j;
      bom localbom;
      b localb;
      int n;
      int k;
      for (int m = 1;; m = 0)
      {
        parambjf = parambjf.GWK.iterator();
        i = 0;
        for (j = -1;; j = n)
        {
          if (!parambjf.hasNext()) {
            break label370;
          }
          localbom = (bom)parambjf.next();
          localb = new b((byte)0);
          localb.vCU = localbom;
          n = j;
          if (paramBoolean)
          {
            if (m == 0) {
              break;
            }
            k = j;
            if (localbom.Gta.equals(this.vLM))
            {
              localb.oIB = true;
              k = j;
            }
            n = k;
            if (localb.oIB)
            {
              this.vLB = i;
              n = k;
            }
          }
          this.vLA.add(localb);
          i += 1;
        }
      }
      if ((localbom.HbD != 1) && (localbom.FZW != 1) && (!aqj(localbom.Gta)))
      {
        n = 1;
        label310:
        if ((localbom.HbE != 1) || (n == 0)) {
          break label364;
        }
      }
      label364:
      for (bool = true;; bool = false)
      {
        localb.oIB = bool;
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
      if (this.vLB < 0)
      {
        this.vLB = j;
        ((b)this.vLA.get(this.vLB)).oIB = true;
      }
      if (this.vLJ)
      {
        this.vLJ = false;
        this.vLC = this.vLB;
        if (this.vLC >= 0) {
          this.vLL = ((b)this.vLA.get(this.vLC)).vCU.Gta;
        }
      }
    }
  }
  
  private boolean aqj(String paramString)
  {
    AppMethodBeat.i(163789);
    if ((this.vLH != null) && (!this.vLH.isEmpty()))
    {
      Iterator localIterator = this.vLH.iterator();
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
  
  private void cMz()
  {
    AppMethodBeat.i(163792);
    if (this.vLB == -1)
    {
      enableOptionMenu(1, false);
      AppMethodBeat.o(163792);
      return;
    }
    enableOptionMenu(1, true);
    AppMethodBeat.o(163792);
  }
  
  private void dmA()
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
          ae.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll to pos: %s", new Object[] { Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this)) });
          localLuckyMoneyEnvelopeTouchRecyclerView = LuckyMoneyPickEnvelopeUI.p(LuckyMoneyPickEnvelopeUI.this);
          ScaleLayoutManager localScaleLayoutManager = LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this);
          i = localScaleLayoutManager.wW(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
          if (localScaleLayoutManager.mOrientation == 1) {
            localLuckyMoneyEnvelopeTouchRecyclerView.scrollBy(0, i);
          }
        }
        else
        {
          Math.max(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this), 0);
          LuckyMoneyPickEnvelopeUI.dmB();
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
              localb.mu(paramAnonymous2Int1);
              localb.mu(paramAnonymous2Int2);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
              super.a(paramAnonymous2RecyclerView, paramAnonymous2Int1, paramAnonymous2Int2);
              paramAnonymous2Int1 = LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this).ko();
              ae.v("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll last vispos: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
              if ((!LuckyMoneyPickEnvelopeUI.u(LuckyMoneyPickEnvelopeUI.this)) && (LuckyMoneyPickEnvelopeUI.l(LuckyMoneyPickEnvelopeUI.this) == 1) && (paramAnonymous2Int1 == LuckyMoneyPickEnvelopeUI.o(LuckyMoneyPickEnvelopeUI.this).getItemCount() - 1))
              {
                ae.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "trigger load more: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, false);
              }
              LuckyMoneyPickEnvelopeUI.g(LuckyMoneyPickEnvelopeUI.this);
              paramAnonymous2RecyclerView = com.tencent.mm.plugin.luckymoney.scaledLayout.a.h(LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this));
              LuckyMoneyPickEnvelopeUI.p(LuckyMoneyPickEnvelopeUI.this);
              paramAnonymous2Int1 = LuckyMoneyEnvelopeTouchRecyclerView.bw(paramAnonymous2RecyclerView);
              LuckyMoneyPickEnvelopeUI.dmC();
              if ((paramAnonymous2Int1 != LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this)) && (paramAnonymous2Int1 >= 0) && (paramAnonymous2Int1 < LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).size()))
              {
                paramAnonymous2RecyclerView = (LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(paramAnonymous2Int1);
                if ((paramAnonymous2RecyclerView.vCU != null) && ((paramAnonymous2RecyclerView.vCU.HbD == 1) || (paramAnonymous2RecyclerView.vCU.FZW == 1)))
                {
                  ae.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "expired: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                  if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0)
                  {
                    ((LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).oIB = false;
                    LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this), false);
                    LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this, -1);
                  }
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                  AppMethodBeat.o(163766);
                  return;
                }
                if (paramAnonymous2RecyclerView.oIB) {
                  break label556;
                }
                ae.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do select pos: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0)
                {
                  ((LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).oIB = false;
                  paramAnonymous2Int2 = LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this);
                  LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, paramAnonymous2Int2, false);
                }
                paramAnonymous2RecyclerView.oIB = true;
                LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this, paramAnonymous2Int1);
                LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this), true);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(163766);
                return;
                label556:
                paramAnonymous2RecyclerView.oIB = false;
                LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this, -1);
              }
            }
            
            public final void b(RecyclerView paramAnonymous2RecyclerView, int paramAnonymous2Int)
            {
              AppMethodBeat.i(163765);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2RecyclerView);
              localb.mu(paramAnonymous2Int);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
              super.b(paramAnonymous2RecyclerView, paramAnonymous2Int);
              ae.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "on scroll changed: %s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
              if (paramAnonymous2Int == 0)
              {
                if ((!LuckyMoneyPickEnvelopeUI.r(LuckyMoneyPickEnvelopeUI.this)) && (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0))
                {
                  paramAnonymous2RecyclerView = (LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
                  com.tencent.mm.plugin.report.service.g.yxI.f(19272, new Object[] { Integer.valueOf(1), LuckyMoneyPickEnvelopeUI.d(LuckyMoneyPickEnvelopeUI.this), paramAnonymous2RecyclerView.vCU.Gta });
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
    this.vLx.post(local2);
    AppMethodBeat.o(163791);
  }
  
  private void oh(final boolean paramBoolean)
  {
    AppMethodBeat.i(163790);
    ae.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do get show source: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), this.vLE });
    if (paramBoolean) {
      this.vLE = "";
    }
    this.tipDialog = h.a(getContext(), 3, 2131820985, getString(2131760709), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    this.isLoading = true;
    com.tencent.mm.plugin.luckymoney.model.g localg = com.tencent.mm.plugin.luckymoney.model.g.dlf();
    localg.b(new com.tencent.mm.plugin.luckymoney.model.c(this.vLE));
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
    this.vLx = ((LuckyMoneyEnvelopeTouchRecyclerView)findViewById(2131301483));
    this.GG = findViewById(2131301481);
    this.vLG = ((TextView)findViewById(2131301482));
    this.vLy = new a((byte)0);
    this.vLy.av(true);
    this.vLx.setAdapter(this.vLy);
    this.vLx.setItemAnimator(null);
    this.vLx.setItemViewCacheSize(-1);
    this.vLz = new ScaleLayoutManager(this)
    {
      public final void dlu()
      {
        AppMethodBeat.i(65792);
        super.dlu();
        this.vDu -= 31.0F;
        AppMethodBeat.o(65792);
      }
    };
    Object localObject = this.vLz;
    ((ScaleLayoutManager)localObject).F(null);
    if (((ScaleLayoutManager)localObject).aXF != 0.8F)
    {
      ((ScaleLayoutManager)localObject).aXF = 0.8F;
      ((ScaleLayoutManager)localObject).removeAllViews();
    }
    this.vLx.setLayoutManager(this.vLz);
    this.vLF = new com.tencent.mm.plugin.luckymoney.scaledLayout.a();
    this.vLF.context = this;
    this.vLF.j(this.vLx);
    this.vLx.vJo = new LuckyMoneyEnvelopeTouchRecyclerView.a()
    {
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(65793);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          paramAnonymousMotionEvent = LuckyMoneyPickEnvelopeUI.this;
          LuckyMoneyPickEnvelopeUI.g(LuckyMoneyPickEnvelopeUI.this);
          LuckyMoneyPickEnvelopeUI.a(paramAnonymousMotionEvent, com.tencent.mm.plugin.luckymoney.scaledLayout.a.h(LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this)));
          LuckyMoneyPickEnvelopeUI.g(LuckyMoneyPickEnvelopeUI.this).vDb = LuckyMoneyPickEnvelopeUI.h(LuckyMoneyPickEnvelopeUI.this);
        }
        AppMethodBeat.o(65793);
        return false;
      }
    };
    localObject = getIntent().getStringExtra(e.g.Jph);
    String str = getIntent().getStringExtra(e.g.Jpi);
    if (!bu.isNullOrNil((String)localObject))
    {
      this.vLG.setText((CharSequence)localObject);
      this.vLG.setVisibility(0);
      this.vLG.setOnClickListener(new LuckyMoneyPickEnvelopeUI.10(this, str));
      AppMethodBeat.o(65815);
      return;
    }
    this.vLG.setVisibility(8);
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
    paramBundle = getIntent().getByteArrayExtra(e.g.Jpf);
    boolean bool = getIntent().getBooleanExtra(e.g.Jpg, true);
    this.vLK = Boolean.valueOf(getIntent().getBooleanExtra(e.g.Jpj, false));
    this.sessionId = getIntent().getStringExtra("key_session_id");
    this.vLM = getIntent().getStringExtra("packetId");
    ae.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll packageid: %s", new Object[] { this.vLM });
    if (bool) {
      if (paramBundle == null) {}
    }
    for (;;)
    {
      try
      {
        paramBundle = (bjf)new bjf().parseFrom(paramBundle);
        if (paramBundle.dmy == 0)
        {
          this.vLE = paramBundle.GWL;
          this.vwr = paramBundle.GWM;
          a(paramBundle, true);
          dmA();
          setBackBtn(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(65787);
              paramAnonymousMenuItem = "";
              if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) {
                paramAnonymousMenuItem = ((LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).vCU.Gta;
              }
              com.tencent.mm.plugin.report.service.g.yxI.f(18892, new Object[] { Integer.valueOf(2), Integer.valueOf(LuckyMoneyPickEnvelopeUI.c(LuckyMoneyPickEnvelopeUI.this) + 1), Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) + 1), LuckyMoneyPickEnvelopeUI.d(LuckyMoneyPickEnvelopeUI.this), paramAnonymousMenuItem, LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this) });
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
              ae.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "click save: %s", new Object[] { Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this)) });
              if ((LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) && (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) < LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).size()))
              {
                paramAnonymousMenuItem = (LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
                if ((!paramAnonymousMenuItem.oIB) || (paramAnonymousMenuItem.vCU == null)) {}
              }
              for (paramAnonymousMenuItem = paramAnonymousMenuItem.vCU.Gta;; paramAnonymousMenuItem = "0")
              {
                LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, paramAnonymousMenuItem);
                com.tencent.mm.plugin.report.service.g.yxI.f(16822, new Object[] { Integer.valueOf(3) });
                paramAnonymousMenuItem = "";
                if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) {
                  paramAnonymousMenuItem = ((LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).vCU.Gta;
                }
                com.tencent.mm.plugin.report.service.g.yxI.f(18892, new Object[] { Integer.valueOf(1), Integer.valueOf(LuckyMoneyPickEnvelopeUI.c(LuckyMoneyPickEnvelopeUI.this) + 1), Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) + 1), LuckyMoneyPickEnvelopeUI.d(LuckyMoneyPickEnvelopeUI.this), paramAnonymousMenuItem, LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this) });
                AppMethodBeat.o(65791);
                return false;
              }
            }
          }, null, s.b.JwB);
          cMz();
          this.vLN.alive();
          AppMethodBeat.o(65814);
          return;
        }
        oh(true);
        continue;
      }
      catch (IOException paramBundle)
      {
        ae.printErrStackTrace("MicroMsg.LuckyMoneyPickEnvelopeUI", paramBundle, "", new Object[0]);
        oh(true);
        continue;
      }
      oh(true);
      continue;
      this.vLD = false;
      this.vwr = 0;
      this.vLB = 0;
      paramBundle = new b((byte)0);
      paramBundle.oIB = true;
      paramBundle.vCU = new bom();
      paramBundle.vCU.Gta = "0";
      paramBundle.vCU.HbA = getString(2131760842);
      this.vLA.add(paramBundle);
      this.vLy.asY.notifyChanged();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65816);
    super.onDestroy();
    this.vLN.dead();
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
      paramc.auu.setSelected(localb.oIB);
      a.b.a(paramc.fTj, v.aAC(), 0.06F, false);
      paramc.ovs.setText(k.b(paramc.vLP.getContext(), v.aAE(), com.tencent.mm.cb.a.ax(paramc.vLP.getContext(), 2131165574)));
      paramc.vLX.setImageBitmap(null);
      paramc.vLY.setVisibility(8);
      if (localb.vCU != null)
      {
        paramc.fSj.setText(localb.vCU.HbA);
        if (localb.vCU.HbB != null) {
          paramc.a(localb.vCU, false);
        }
        paramc.vLY.setOnClickListener(new LuckyMoneyPickEnvelopeUI.c.2(paramc, localb));
        if (!bu.isNullOrNil(localb.vCU.HbC))
        {
          paramc.vMc.setText(localb.vCU.HbC);
          paramc.vMc.setVisibility(0);
          if (localb.vCU.hCs != 2) {
            break label269;
          }
          paramc.vMd.setVisibility(0);
        }
        for (;;)
        {
          if ((localb.vCU.hCs != 1) || (bu.isNullOrNil(localb.vCU.HbH))) {
            break label281;
          }
          paramc.vMc.setVisibility(0);
          paramc.vMc.setText(localb.vCU.HbH);
          AppMethodBeat.o(163777);
          return;
          paramc.vMc.setText("");
          break;
          label269:
          paramc.vMd.setVisibility(8);
        }
        label281:
        if (localb.vCU.FZW == 1)
        {
          paramc.auu.setSelected(false);
          paramc.vMe.setEnabled(false);
          paramc.vMc.setVisibility(0);
          if (!bu.isNullOrNil(localb.vCU.HbG)) {
            paramc.vMc.setText(localb.vCU.HbG);
          }
          paramc.dmD();
          AppMethodBeat.o(163777);
          return;
        }
        if (localb.vCU.HbD == 1)
        {
          paramc.auu.setSelected(false);
          paramc.vMe.setEnabled(false);
          if (!bu.isNullOrNil(localb.vCU.HbC))
          {
            paramc.vMc.setText(localb.vCU.HbC);
            paramc.vMc.setVisibility(0);
          }
          paramc.dmD();
          AppMethodBeat.o(163777);
          return;
        }
        if (LuckyMoneyPickEnvelopeUI.e(paramc.vLP, localb.vCU.Gta))
        {
          paramc.auu.setSelected(false);
          paramc.vMe.setEnabled(false);
          paramc.vMc.setText(2131760852);
          paramc.vMc.setVisibility(0);
          paramc.dmD();
          AppMethodBeat.o(163777);
          return;
        }
        paramc.vMe.setEnabled(true);
        if (bu.ah(paramc.vMc.getText())) {
          paramc.vMc.setVisibility(4);
        }
        paramc.vLY.setVisibility(8);
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
    public boolean oIB = false;
    public bom vCU;
  }
  
  final class c
    extends RecyclerView.w
  {
    TextView fSj;
    ImageView fTj;
    TextView ovs;
    private Dialog tipDialog;
    ImageView vLX;
    View vLY;
    ImageView vLZ;
    ProgressBar vMa;
    TextView vMb;
    TextView vMc;
    TextView vMd;
    ViewGroup vMe;
    ProgressBar vMf;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(65810);
      this.tipDialog = null;
      this.vMe = ((ViewGroup)paramView.findViewById(2131301470));
      this.vLX = ((ImageView)paramView.findViewById(2131301471));
      this.fSj = ((TextView)paramView.findViewById(2131301473));
      this.fTj = ((ImageView)paramView.findViewById(2131301469));
      this.ovs = ((TextView)paramView.findViewById(2131301477));
      this.vLY = paramView.findViewById(2131301479);
      this.vLZ = ((ImageView)paramView.findViewById(2131301476));
      this.vMa = ((ProgressBar)paramView.findViewById(2131301468));
      this.vMb = ((TextView)paramView.findViewById(2131301478));
      this.vMc = ((TextView)paramView.findViewById(2131301472));
      this.vMd = ((TextView)paramView.findViewById(2131307210));
      this.vMf = ((ProgressBar)paramView.findViewById(2131301475));
      if (al.isDarkMode()) {
        this.vMe.setBackgroundResource(2131233104);
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
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$VH$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
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
              ae.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "delete pos: %s", new Object[] { Integer.valueOf(i) });
              paramAnonymousView = (LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(i);
              if ((paramAnonymousView != null) && (paramAnonymousView.vCU != null))
              {
                if ("0".equals(paramAnonymousView.vCU.Gta))
                {
                  ae.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "can not delete default envelope");
                  com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$VH$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                  AppMethodBeat.o(163781);
                  return false;
                }
                localObject = new com.tencent.mm.ui.widget.a.e(LuckyMoneyPickEnvelopeUI.this.getContext(), 1, true);
                TextView localTextView = new TextView(LuckyMoneyPickEnvelopeUI.this.getContext());
                localTextView.setPadding(0, 0, 0, com.tencent.mm.cb.a.fromDPToPix(LuckyMoneyPickEnvelopeUI.this.getContext(), 9));
                localTextView.setMinHeight(com.tencent.mm.cb.a.ax(LuckyMoneyPickEnvelopeUI.this.getContext(), 2131165204));
                localTextView.setTextSize(14.0F);
                localTextView.setTextColor(LuckyMoneyPickEnvelopeUI.this.getResources().getColor(2131100482));
                localTextView.setText(2131760927);
                localTextView.setGravity(81);
                ((com.tencent.mm.ui.widget.a.e)localObject).P(localTextView, true);
                ((com.tencent.mm.ui.widget.a.e)localObject).LfS = new n.d()
                {
                  public final void onCreateMMMenu(l paramAnonymous2l)
                  {
                    AppMethodBeat.i(163779);
                    paramAnonymous2l.a(0, LuckyMoneyPickEnvelopeUI.this.getResources().getColor(2131099803), LuckyMoneyPickEnvelopeUI.this.getString(2131760926));
                    AppMethodBeat.o(163779);
                  }
                };
                ((com.tencent.mm.ui.widget.a.e)localObject).LfT = new n.e()
                {
                  public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(163780);
                    if (paramAnonymous2MenuItem.getItemId() == 0) {
                      LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this, paramAnonymousView.vCU.Gta);
                    }
                    AppMethodBeat.o(163780);
                  }
                };
                ((com.tencent.mm.ui.widget.a.e)localObject).cPF();
              }
            }
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$VH$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(163781);
            return false;
          }
        };
        paramView.setOnLongClickListener(LuckyMoneyPickEnvelopeUI.this);
        this.vLY.setOnLongClickListener(LuckyMoneyPickEnvelopeUI.this);
        AppMethodBeat.o(65810);
        return;
        this.vMe.setBackgroundResource(2131233102);
      }
    }
    
    final void a(final bom parambom, boolean paramBoolean)
    {
      AppMethodBeat.i(65811);
      if (paramBoolean)
      {
        this.vLZ.setVisibility(8);
        this.vMa.setVisibility(0);
        this.vMb.setVisibility(8);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.vLX, parambom, new com.tencent.mm.plugin.luckymoney.a.a.a()
        {
          public final void iI(final boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(163784);
            ae.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "load ok: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            Runnable local1 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(163783);
                LuckyMoneyPickEnvelopeUI.c.this.vMf.setVisibility(8);
                if ((LuckyMoneyPickEnvelopeUI.c.a(LuckyMoneyPickEnvelopeUI.c.this) != null) && (LuckyMoneyPickEnvelopeUI.c.a(LuckyMoneyPickEnvelopeUI.c.this).isShowing())) {
                  LuckyMoneyPickEnvelopeUI.c.a(LuckyMoneyPickEnvelopeUI.c.this).dismiss();
                }
                if ((LuckyMoneyPickEnvelopeUI.c.3.this.vMk.HbD == 1) || (LuckyMoneyPickEnvelopeUI.c.3.this.vMk.FZW == 1))
                {
                  ae.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "envelope has expired do nothing");
                  AppMethodBeat.o(163783);
                  return;
                }
                if (!paramAnonymousBoolean)
                {
                  LuckyMoneyPickEnvelopeUI.c.this.vLY.setVisibility(0);
                  LuckyMoneyPickEnvelopeUI.c.this.vLZ.setVisibility(0);
                  LuckyMoneyPickEnvelopeUI.c.this.vMa.setVisibility(8);
                  LuckyMoneyPickEnvelopeUI.c.this.vMb.setVisibility(0);
                  AppMethodBeat.o(163783);
                  return;
                }
                LuckyMoneyPickEnvelopeUI.c.this.vLY.setVisibility(8);
                AppMethodBeat.o(163783);
              }
            };
            if (ar.isMainThread())
            {
              local1.run();
              AppMethodBeat.o(163784);
              return;
            }
            LuckyMoneyPickEnvelopeUI.c.this.vLY.post(local1);
            AppMethodBeat.o(163784);
          }
        });
        AppMethodBeat.o(65811);
        return;
        if ("0".equals(parambom.Gta))
        {
          ae.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "default envelope");
          AppMethodBeat.o(65811);
          return;
        }
        this.vMf.setVisibility(0);
      }
    }
    
    final void dmD()
    {
      AppMethodBeat.i(163786);
      this.vLY.setVisibility(0);
      this.vLZ.setVisibility(8);
      this.vMa.setVisibility(8);
      this.vMb.setVisibility(8);
      this.vLY.setOnClickListener(null);
      AppMethodBeat.o(163786);
    }
    
    public final void oi(boolean paramBoolean)
    {
      AppMethodBeat.i(163785);
      this.auu.setSelected(paramBoolean);
      AppMethodBeat.o(163785);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI
 * JD-Core Version:    0.7.0.1
 */