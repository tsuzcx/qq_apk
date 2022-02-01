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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.transition.Transition;
import androidx.transition.Transition.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.f.a.sg;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.luckymoney.model.d;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.scaledLayout.ScaleLayoutManager;
import com.tencent.mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.adn;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.protocal.protobuf.cjf;
import com.tencent.mm.protocal.protobuf.xs;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.f.j;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.ui.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(1)
public class LuckyMoneyPickEnvelopeUI
  extends MMActivity
{
  private RecyclerView.l DIR;
  private View ECm;
  private LuckyMoneyEnvelopeTouchRecyclerView ELI;
  private d ELJ;
  private ScaleLayoutManager ELK;
  private List<e> ELL;
  private int ELM;
  private int ELN;
  private boolean ELO;
  private String ELP;
  private com.tencent.mm.plugin.luckymoney.scaledLayout.a ELQ;
  private Button ELR;
  private LinkedList<String> ELS;
  private boolean ELT;
  private Boolean ELU;
  private String ELV;
  private String ELW;
  private String ELX;
  private boolean ELY;
  private IListener<sg> ELZ;
  private boolean EMa;
  private int EuD;
  private View Xd;
  private boolean isLoading;
  private String sessionId;
  private long startTime;
  private Dialog tipDialog;
  
  public LuckyMoneyPickEnvelopeUI()
  {
    AppMethodBeat.i(65813);
    this.ELL = new ArrayList();
    this.ELM = -1;
    this.ELN = -1;
    this.ELO = false;
    this.isLoading = false;
    this.EuD = 0;
    this.ELT = true;
    this.ELY = false;
    this.ELZ = new LuckyMoneyPickEnvelopeUI.14(this);
    this.EMa = false;
    AppMethodBeat.o(65813);
  }
  
  private void a(cda paramcda)
  {
    AppMethodBeat.i(65818);
    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "try show illegal msg");
    if (Util.isNullOrNil(paramcda.EyC))
    {
      AppMethodBeat.o(65818);
      return;
    }
    ArrayList localArrayList = new ArrayList(Util.stringToList((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VtB, ""), ","));
    this.ELS = paramcda.TkT;
    Iterator localIterator = this.ELS.iterator();
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
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VtB, Util.listToString(localArrayList, ","));
        com.tencent.mm.ui.base.h.a(this, paramcda.EyC, "", getString(a.i.app_i_known), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      AppMethodBeat.o(65818);
      return;
    }
  }
  
  private void a(cda paramcda, boolean paramBoolean)
  {
    AppMethodBeat.i(271768);
    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "update by resp");
    if (paramcda.TkU == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.ELO = bool;
      a(paramcda);
      if (paramcda.TkQ != null)
      {
        if (!paramcda.TkQ.isEmpty()) {
          break;
        }
        this.Xd.setVisibility(0);
        this.ELI.setVisibility(8);
      }
      this.ELJ.alc.notifyChanged();
      eQc();
      AppMethodBeat.o(271768);
      return;
    }
    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "list size: %s", new Object[] { Integer.valueOf(paramcda.TkQ.size()) });
    int m;
    Iterator localIterator;
    int i;
    int j;
    if (!Util.isNullOrNil(this.ELW))
    {
      m = 1;
      localIterator = paramcda.TkQ.iterator();
      i = 0;
      j = -1;
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        cjf localcjf = (cjf)localIterator.next();
        if ((localcjf.RUO == 1) || (localcjf.Tqq == 1) || (aNQ(localcjf.SpP)))
        {
          Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "filter unused envelope: %s", new Object[] { localcjf.SpP });
          continue;
          m = 0;
          break;
        }
        e locale = new e((byte)0);
        locale.ECc = localcjf;
        int n = j;
        int k;
        if (paramBoolean)
        {
          if (m == 0) {
            break label378;
          }
          k = j;
          if (localcjf.SpP.equals(this.ELW))
          {
            locale.tsm = true;
            k = j;
          }
          n = k;
          if (locale.tsm)
          {
            this.ELM = i;
            n = k;
          }
        }
        if (localcjf.llL == 3)
        {
          this.ELX = localcjf.SpP;
          com.tencent.mm.plugin.report.service.h.IzE.a(22104, new Object[] { this.ELX, Integer.valueOf(1) });
        }
        this.ELL.add(locale);
        i += 1;
        j = n;
        continue;
        label378:
        if ((localcjf.Tqq != 1) && (localcjf.RUO != 1) && (!aNQ(localcjf.SpP)))
        {
          n = 1;
          if ((localcjf.Tqr != 1) || (n == 0)) {
            break label465;
          }
        }
        label411:
        label465:
        for (bool = true;; bool = false)
        {
          locale.tsm = bool;
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
          break label411;
        }
      }
    }
    if (this.ELM < 0) {
      if (j < 0) {
        break label625;
      }
    }
    label625:
    for (this.ELM = j;; this.ELM = 0)
    {
      ((e)this.ELL.get(this.ELM)).tsm = true;
      if (paramcda.TkW == 1)
      {
        paramcda = new e((byte)0);
        paramcda.ECc = new cjf();
        paramcda.EMG = true;
        this.ELL.add(paramcda);
      }
      if (!this.ELT) {
        break;
      }
      this.ELT = false;
      this.ELN = this.ELM;
      if ((this.ELN < 0) || (this.ELN >= this.ELL.size())) {
        break;
      }
      this.ELV = ((e)this.ELL.get(this.ELN)).ECc.SpP;
      break;
    }
  }
  
  private boolean aNQ(String paramString)
  {
    AppMethodBeat.i(163789);
    if ((this.ELS != null) && (!this.ELS.isEmpty()))
    {
      Iterator localIterator = this.ELS.iterator();
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
  
  private void eQb()
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
          i = localScaleLayoutManager.Ek(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
          if (localScaleLayoutManager.mOrientation == 1) {
            localLuckyMoneyEnvelopeTouchRecyclerView.scrollBy(0, i);
          }
        }
        else
        {
          Math.max(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this), 0);
          LuckyMoneyPickEnvelopeUI.eQf();
          if (LuckyMoneyPickEnvelopeUI.s(LuckyMoneyPickEnvelopeUI.this) != null) {
            break label174;
          }
          LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, new RecyclerView.l()
          {
            public final void onScrollStateChanged(RecyclerView paramAnonymous2RecyclerView, int paramAnonymous2Int)
            {
              AppMethodBeat.i(272571);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymous2RecyclerView);
              localb.sg(paramAnonymous2Int);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
              super.onScrollStateChanged(paramAnonymous2RecyclerView, paramAnonymous2Int);
              Log.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "on scroll changed: %s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
              if (paramAnonymous2Int == 0)
              {
                if ((!LuckyMoneyPickEnvelopeUI.t(LuckyMoneyPickEnvelopeUI.this)) && (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0))
                {
                  paramAnonymous2RecyclerView = (LuckyMoneyPickEnvelopeUI.e)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
                  com.tencent.mm.plugin.report.service.h.IzE.a(19272, new Object[] { Integer.valueOf(1), LuckyMoneyPickEnvelopeUI.d(LuckyMoneyPickEnvelopeUI.this), paramAnonymous2RecyclerView.ECc.SpP });
                  LuckyMoneyPickEnvelopeUI.u(LuckyMoneyPickEnvelopeUI.this);
                }
                if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0)
                {
                  paramAnonymous2RecyclerView = (LuckyMoneyPickEnvelopeUI.e)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
                  if (paramAnonymous2RecyclerView.ECc.llL == 3) {
                    com.tencent.mm.plugin.report.service.h.IzE.a(22104, new Object[] { paramAnonymous2RecyclerView.ECc.SpP, Integer.valueOf(2) });
                  }
                }
                LuckyMoneyPickEnvelopeUI.v(LuckyMoneyPickEnvelopeUI.this);
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
              AppMethodBeat.o(272571);
            }
            
            public final void onScrolled(RecyclerView paramAnonymous2RecyclerView, int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(272572);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymous2RecyclerView);
              localb.sg(paramAnonymous2Int1);
              localb.sg(paramAnonymous2Int2);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
              super.onScrolled(paramAnonymous2RecyclerView, paramAnonymous2Int1, paramAnonymous2Int2);
              paramAnonymous2Int1 = LuckyMoneyPickEnvelopeUI.i(LuckyMoneyPickEnvelopeUI.this).kL();
              Log.v("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll last vispos: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
              if ((!LuckyMoneyPickEnvelopeUI.w(LuckyMoneyPickEnvelopeUI.this)) && (LuckyMoneyPickEnvelopeUI.n(LuckyMoneyPickEnvelopeUI.this) == 1) && (paramAnonymous2Int1 == LuckyMoneyPickEnvelopeUI.q(LuckyMoneyPickEnvelopeUI.this).getItemCount() - 1))
              {
                Log.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "trigger load more: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, false);
              }
              LuckyMoneyPickEnvelopeUI.j(LuckyMoneyPickEnvelopeUI.this);
              paramAnonymous2RecyclerView = com.tencent.mm.plugin.luckymoney.scaledLayout.a.h(LuckyMoneyPickEnvelopeUI.i(LuckyMoneyPickEnvelopeUI.this));
              LuckyMoneyPickEnvelopeUI.r(LuckyMoneyPickEnvelopeUI.this);
              paramAnonymous2Int1 = LuckyMoneyEnvelopeTouchRecyclerView.bh(paramAnonymous2RecyclerView);
              LuckyMoneyPickEnvelopeUI.eQg();
              if ((paramAnonymous2Int1 != LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this)) && (paramAnonymous2Int1 >= 0) && (paramAnonymous2Int1 < LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).size()))
              {
                paramAnonymous2RecyclerView = (LuckyMoneyPickEnvelopeUI.e)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(paramAnonymous2Int1);
                if ((paramAnonymous2RecyclerView.ECc != null) && ((paramAnonymous2RecyclerView.ECc.Tqq == 1) || (paramAnonymous2RecyclerView.ECc.RUO == 1)))
                {
                  Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "expired: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                  if ((LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) && (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) < LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).size()))
                  {
                    ((LuckyMoneyPickEnvelopeUI.e)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).tsm = false;
                    LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this), false);
                    LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this, -1);
                  }
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
                  AppMethodBeat.o(272572);
                  return;
                }
                if (!paramAnonymous2RecyclerView.EMG) {
                  break label473;
                }
                LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this, -2);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
                AppMethodBeat.o(272572);
                return;
                label473:
                if (!paramAnonymous2RecyclerView.tsm)
                {
                  Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do select pos: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                  if ((LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) && (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) < LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).size()))
                  {
                    ((LuckyMoneyPickEnvelopeUI.e)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).tsm = false;
                    paramAnonymous2Int2 = LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this);
                    LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, paramAnonymous2Int2, false);
                  }
                  paramAnonymous2RecyclerView.tsm = true;
                  LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this, paramAnonymous2Int1);
                  LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this), true);
                }
                else
                {
                  paramAnonymous2RecyclerView.tsm = false;
                  LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this, -1);
                }
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
    this.ELI.post(local2);
    AppMethodBeat.o(163791);
  }
  
  private void eQc()
  {
    AppMethodBeat.i(271772);
    if (this.ELM == -1)
    {
      this.ELR.setEnabled(false);
      this.ELR.setText(a.i.lucky_money_envelope_use_btn_text);
    }
    for (;;)
    {
      this.ELR.setVisibility(0);
      AppMethodBeat.o(271772);
      return;
      if (this.ELM == -2)
      {
        if (!this.ELY)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(22302, new Object[] { Integer.valueOf(2) });
          this.ELY = true;
        }
        this.ELR.setVisibility(4);
        AppMethodBeat.o(271772);
        return;
      }
      if (eQd())
      {
        this.ELR.setVisibility(4);
        AppMethodBeat.o(271772);
        return;
      }
      this.ELR.setEnabled(true);
      if (!eQe()) {
        break;
      }
      this.ELR.setText(a.i.lucky_money_envelope_receive_use_btn_text);
    }
  }
  
  private boolean eQd()
  {
    AppMethodBeat.i(271774);
    if ((this.ELM < 0) || (this.ELM >= this.ELL.size()))
    {
      AppMethodBeat.o(271774);
      return false;
    }
    e locale = (e)this.ELL.get(this.ELM);
    if ((locale.tsm) && (locale.ECc != null) && (locale.ECc.llL == 4))
    {
      AppMethodBeat.o(271774);
      return true;
    }
    AppMethodBeat.o(271774);
    return false;
  }
  
  private boolean eQe()
  {
    AppMethodBeat.i(271776);
    if ((this.ELM < 0) || (this.ELM >= this.ELL.size()))
    {
      AppMethodBeat.o(271776);
      return false;
    }
    e locale = (e)this.ELL.get(this.ELM);
    if ((locale.tsm) && (locale.ECc != null) && (locale.ECc.llL == 3))
    {
      AppMethodBeat.o(271776);
      return true;
    }
    AppMethodBeat.o(271776);
    return false;
  }
  
  private void tP(final boolean paramBoolean)
  {
    AppMethodBeat.i(163790);
    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do get show source: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), this.ELP });
    if (paramBoolean) {
      this.ELP = "";
    }
    this.tipDialog = com.tencent.mm.ui.base.h.a(getContext(), 3, a.j.LuckyMoneyNoAnimDialog, getString(a.i.loading_tips), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    this.isLoading = true;
    k localk = k.eOu();
    localk.d(new d(this.ELP, 1));
    localk.a(new com.tencent.mm.wallet_core.c.a.a() {}, 0L);
    AppMethodBeat.o(163790);
  }
  
  public int getLayoutId()
  {
    return a.g.lucky_money_pick_envelope_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65815);
    this.ELI = ((LuckyMoneyEnvelopeTouchRecyclerView)findViewById(a.f.lmps_rv));
    this.Xd = findViewById(a.f.lmps_empty_view);
    this.ELR = ((Button)findViewById(a.f.lmps_envelope_confirm_btn));
    this.ELJ = new d((byte)0);
    this.ELJ.aw(true);
    this.ELI.setAdapter(this.ELJ);
    this.ELI.setItemAnimator(null);
    this.ELK = new ScaleLayoutManager(this)
    {
      public final void eON()
      {
        AppMethodBeat.i(65792);
        super.eON();
        this.ECE -= 31.0F;
        AppMethodBeat.o(65792);
      }
    };
    ScaleLayoutManager localScaleLayoutManager = this.ELK;
    localScaleLayoutManager.assertNotInLayoutOrScroll(null);
    if (localScaleLayoutManager.aGO != 0.8F)
    {
      localScaleLayoutManager.aGO = 0.8F;
      localScaleLayoutManager.removeAllViews();
    }
    this.ELI.setLayoutManager(this.ELK);
    this.ELQ = new com.tencent.mm.plugin.luckymoney.scaledLayout.a();
    this.ELQ.context = this;
    this.ELQ.a(this.ELI);
    this.ELI.EIZ = new LuckyMoneyEnvelopeTouchRecyclerView.a()
    {
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(65793);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          paramAnonymousMotionEvent = LuckyMoneyPickEnvelopeUI.this;
          LuckyMoneyPickEnvelopeUI.j(LuckyMoneyPickEnvelopeUI.this);
          LuckyMoneyPickEnvelopeUI.a(paramAnonymousMotionEvent, com.tencent.mm.plugin.luckymoney.scaledLayout.a.h(LuckyMoneyPickEnvelopeUI.i(LuckyMoneyPickEnvelopeUI.this)));
          LuckyMoneyPickEnvelopeUI.j(LuckyMoneyPickEnvelopeUI.this).ECm = LuckyMoneyPickEnvelopeUI.k(LuckyMoneyPickEnvelopeUI.this);
        }
        AppMethodBeat.o(65793);
        return false;
      }
    };
    getIntent().getStringExtra(f.j.VSq);
    getIntent().getStringExtra(f.j.VSr);
    this.ELR.setOnClickListener(new aa()
    {
      public final void cOw()
      {
        AppMethodBeat.i(232753);
        Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "click save: %s", new Object[] { Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this)) });
        Object localObject;
        String str;
        if ((LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) && (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) < LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).size()))
        {
          localObject = (LuckyMoneyPickEnvelopeUI.e)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
          if ((((LuckyMoneyPickEnvelopeUI.e)localObject).tsm) && (((LuckyMoneyPickEnvelopeUI.e)localObject).ECc != null))
          {
            str = ((LuckyMoneyPickEnvelopeUI.e)localObject).ECc.SpP;
            if (((LuckyMoneyPickEnvelopeUI.e)localObject).ECc.llL != 3) {
              break label312;
            }
            LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, str, ((LuckyMoneyPickEnvelopeUI.e)localObject).ECc.TqF, LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
            com.tencent.mm.plugin.report.service.h.IzE.a(22104, new Object[] { ((LuckyMoneyPickEnvelopeUI.e)localObject).ECc.SpP, Integer.valueOf(3) });
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(16822, new Object[] { Integer.valueOf(3) });
          localObject = "";
          if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) {
            localObject = ((LuckyMoneyPickEnvelopeUI.e)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).ECc.SpP;
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(18892, new Object[] { Integer.valueOf(1), Integer.valueOf(LuckyMoneyPickEnvelopeUI.c(LuckyMoneyPickEnvelopeUI.this) + 1), Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) + 1), LuckyMoneyPickEnvelopeUI.d(LuckyMoneyPickEnvelopeUI.this), localObject, LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this) });
          AppMethodBeat.o(232753);
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
    int j = 0;
    AppMethodBeat.i(65814);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    hideActionbarLine();
    setActionbarColor(getContext().getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.BW_97));
    initView();
    setMMTitle(a.i.lucky_money_pick_envelope_title);
    this.startTime = Util.currentTicks();
    getIntent().getByteArrayExtra(f.j.VSo);
    boolean bool = getIntent().getBooleanExtra(f.j.VSp, true);
    this.ELU = Boolean.valueOf(getIntent().getBooleanExtra(f.j.VSs, false));
    this.sessionId = getIntent().getStringExtra("key_session_id");
    paramBundle = getIntent().getStringExtra(f.j.VSr);
    this.ELW = getIntent().getStringExtra("packetId");
    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll packageid: %s", new Object[] { this.ELW });
    Object localObject;
    if (bool)
    {
      int i = j;
      if (getIntent().getBooleanExtra(f.j.ZuR, false))
      {
        k.eOu();
        localObject = k.eOv();
        i = j;
        if (localObject != null)
        {
          i = j;
          if (((cda)localObject).fwx == 0)
          {
            this.ELP = ((cda)localObject).TkR;
            this.EuD = ((cda)localObject).TkS;
            a((cda)localObject, true);
            eQb();
            i = 1;
          }
        }
      }
      if (i == 0) {
        tP(true);
      }
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(65787);
          paramAnonymousMenuItem = "";
          if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) {
            paramAnonymousMenuItem = ((LuckyMoneyPickEnvelopeUI.e)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).ECc.SpP;
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(18892, new Object[] { Integer.valueOf(2), Integer.valueOf(LuckyMoneyPickEnvelopeUI.c(LuckyMoneyPickEnvelopeUI.this) + 1), Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) + 1), LuckyMoneyPickEnvelopeUI.d(LuckyMoneyPickEnvelopeUI.this), paramAnonymousMenuItem, LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this) });
          if (!Util.isNullOrNil(LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this))) {
            com.tencent.mm.plugin.report.service.h.IzE.a(22104, new Object[] { LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this), Integer.valueOf(4), Long.valueOf(Util.ticksToNow(LuckyMoneyPickEnvelopeUI.g(LuckyMoneyPickEnvelopeUI.this)) / 1000L) });
          }
          LuckyMoneyPickEnvelopeUI.this.setResult(0);
          LuckyMoneyPickEnvelopeUI.this.finish();
          AppMethodBeat.o(65787);
          return false;
        }
      });
      if (!Util.isNullOrNil(paramBundle)) {
        addTextOptionMenu(1, getString(a.i.lucky_money_envelope_add_text), com.tencent.mm.ci.a.w(getContext(), com.tencent.mm.ah.a.d.link_color_selector), new MenuItem.OnMenuItemClickListener()
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
            g.c(LuckyMoneyPickEnvelopeUI.this.getContext(), localIntent, 1);
            paramAnonymousMenuItem = com.tencent.mm.plugin.report.service.h.IzE;
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
      eQc();
      this.ELZ.alive();
      AppMethodBeat.o(65814);
      return;
      this.ELO = false;
      this.EuD = 0;
      this.ELM = 0;
      localObject = new e((byte)0);
      ((e)localObject).tsm = true;
      ((e)localObject).ECc = new cjf();
      ((e)localObject).ECc.SpP = "0";
      ((e)localObject).ECc.Tqn = getString(a.i.lucky_money_default_envelope_name);
      this.ELL.add(localObject);
      this.ELJ.alc.notifyChanged();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65816);
    super.onDestroy();
    this.ELZ.dead();
    AppMethodBeat.o(65816);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class b
    extends LuckyMoneyPickEnvelopeUI.a
  {
    ImageView EMl;
    View EMm;
    ImageView EMn;
    ProgressBar EMo;
    TextView EMp;
    TextView EMq;
    TextView EMr;
    ViewGroup EMs;
    ProgressBar EMt;
    ImageView EMu;
    ViewGroup EMv;
    TextView EMw;
    TextView EMx;
    TextView jbF;
    ImageView jiu;
    Button wNZ;
    TextView xoK;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(249270);
      this.EMs = ((ViewGroup)paramView.findViewById(a.f.lmpi_content_view));
      this.EMl = ((ImageView)paramView.findViewById(a.f.lmpi_envelope_iv));
      this.jbF = ((TextView)paramView.findViewById(a.f.lmpi_envelope_name_tv));
      this.jiu = ((ImageView)paramView.findViewById(a.f.lmpi_avatar_iv));
      this.xoK = ((TextView)paramView.findViewById(a.f.lmpi_nickname_tv));
      this.EMm = paramView.findViewById(a.f.lmpi_white_cover_view);
      this.EMn = ((ImageView)paramView.findViewById(a.f.lmpi_loading_iv));
      this.EMo = ((ProgressBar)paramView.findViewById(a.f.lmpi_anim_pb));
      this.EMp = ((TextView)paramView.findViewById(a.f.lmpi_retry_tv));
      this.EMq = ((TextView)paramView.findViewById(a.f.lmpi_envelope_leave_tv));
      this.EMr = ((TextView)paramView.findViewById(a.f.lmpi_temp_label_tv));
      this.wNZ = ((Button)paramView.findViewById(a.f.lmpi_envelope_open_btn));
      this.EMu = ((ImageView)paramView.findViewById(a.f.lmpi_envelope_biz_snapshot_iv));
      this.EMv = ((ViewGroup)paramView.findViewById(a.f.lmpi_envelope_red_bg));
      this.EMw = ((TextView)paramView.findViewById(a.f.lmpi_envelope_biz_title_tv));
      this.EMx = ((TextView)paramView.findViewById(a.f.lmpi_envelope_biz_desc_tv));
      g.N(this.EMw);
      g.N(this.EMx);
      this$1 = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
      if ((LuckyMoneyPickEnvelopeUI.this == null) || (LuckyMoneyPickEnvelopeUI.this.length() <= 0) || ((!LuckyMoneyPickEnvelopeUI.this.equals("zh_CN")) && (!LuckyMoneyPickEnvelopeUI.this.equals("zh_TW")) && (!LuckyMoneyPickEnvelopeUI.this.equals("zh_HK"))))
      {
        this.wNZ.setBackgroundResource(a.e.pick_envelope_btn_icon);
        this.wNZ.setText(a.i.lucky_money_open_title);
      }
      this.EMt = ((ProgressBar)paramView.findViewById(a.f.lmpi_inline_cover_loading_pb));
      if (ar.isDarkMode()) {
        this.EMs.setBackgroundResource(a.e.lucky_money_pick_envelope_item_dark_bg);
      }
      for (;;)
      {
        this.EMs.setEnabled(false);
        AppMethodBeat.o(249270);
        return;
        this.EMs.setBackgroundResource(a.e.lucky_money_pick_envelope_item_bg);
      }
    }
    
    private void a(final cjf paramcjf, boolean paramBoolean)
    {
      AppMethodBeat.i(249277);
      if (paramBoolean)
      {
        this.EMn.setVisibility(8);
        this.EMo.setVisibility(0);
        this.EMp.setVisibility(8);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.EMl, paramcjf, new com.tencent.mm.plugin.luckymoney.a.a.a()
        {
          public final void eG(final boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(268578);
            Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "load ok: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            Runnable local1 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(274952);
                LuckyMoneyPickEnvelopeUI.b.this.EMt.setVisibility(8);
                if ((LuckyMoneyPickEnvelopeUI.l(LuckyMoneyPickEnvelopeUI.this) != null) && (LuckyMoneyPickEnvelopeUI.l(LuckyMoneyPickEnvelopeUI.this).isShowing())) {
                  LuckyMoneyPickEnvelopeUI.l(LuckyMoneyPickEnvelopeUI.this).dismiss();
                }
                if ((LuckyMoneyPickEnvelopeUI.b.2.this.EJt.Tqq == 1) || (LuckyMoneyPickEnvelopeUI.b.2.this.EJt.RUO == 1))
                {
                  Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "envelope has expired do nothing");
                  AppMethodBeat.o(274952);
                  return;
                }
                if (!paramAnonymousBoolean)
                {
                  LuckyMoneyPickEnvelopeUI.b.this.EMm.setVisibility(0);
                  LuckyMoneyPickEnvelopeUI.b.this.EMn.setVisibility(0);
                  LuckyMoneyPickEnvelopeUI.b.this.EMo.setVisibility(8);
                  LuckyMoneyPickEnvelopeUI.b.this.EMp.setVisibility(0);
                  AppMethodBeat.o(274952);
                  return;
                }
                LuckyMoneyPickEnvelopeUI.b.this.EMm.setVisibility(8);
                AppMethodBeat.o(274952);
              }
            };
            if (MMHandlerThread.isMainThread())
            {
              local1.run();
              AppMethodBeat.o(268578);
              return;
            }
            LuckyMoneyPickEnvelopeUI.b.this.EMm.post(local1);
            AppMethodBeat.o(268578);
          }
        });
        AppMethodBeat.o(249277);
        return;
        if ("0".equals(paramcjf.SpP))
        {
          Log.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "default envelope");
          AppMethodBeat.o(249277);
          return;
        }
        this.EMt.setVisibility(0);
      }
    }
    
    public final void a(final LuckyMoneyPickEnvelopeUI.e parame)
    {
      AppMethodBeat.i(249273);
      this.amk.setSelected(parame.tsm);
      a.b.a(this.jiu, z.bcZ(), 0.06F, false);
      this.xoK.setText(LuckyMoneyPickEnvelopeUI.this.getString(a.i.lucky_money_whose, new Object[] { l.d(LuckyMoneyPickEnvelopeUI.this.getContext(), z.bdb(), com.tencent.mm.ci.a.aY(LuckyMoneyPickEnvelopeUI.this.getContext(), com.tencent.mm.plugin.wxpay.a.d.SmallerTextSize)) }));
      this.EMl.setImageBitmap(null);
      this.EMm.setVisibility(8);
      if (parame.ECc != null)
      {
        this.jbF.setText(parame.ECc.Tqn);
        this.EMw.setText(parame.ECc.Tqn);
        if (parame.ECc.Tqo != null) {
          a(parame.ECc, false);
        }
        this.EMm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(231925);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$BizVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            LuckyMoneyPickEnvelopeUI.b.a(LuckyMoneyPickEnvelopeUI.b.this, parame.ECc);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$BizVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(231925);
          }
        });
        if (Util.isNullOrNil(parame.ECc.Tqp)) {
          break label240;
        }
        this.EMq.setText(parame.ECc.Tqp);
        this.EMq.setVisibility(0);
      }
      for (;;)
      {
        if (this.EMx != null) {
          this.EMx.setText(parame.ECc.TqE);
        }
        this.EMm.setVisibility(8);
        AppMethodBeat.o(249273);
        return;
        label240:
        this.EMq.setText("");
      }
    }
    
    public final void tS(boolean paramBoolean) {}
  }
  
  final class c
    extends LuckyMoneyPickEnvelopeUI.a
  {
    TextView EMB;
    TextView EMC;
    WeImageView EMD;
    ViewGroup EME;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(272546);
      this.EMB = ((TextView)paramView.findViewById(a.f.lmpi_create_envelope_title));
      this.EMC = ((TextView)paramView.findViewById(a.f.lmpi_create_envelope_sub_title));
      this.EMD = ((WeImageView)paramView.findViewById(a.f.lmpi_create_envelope_title_arrow));
      this.EME = ((ViewGroup)paramView.findViewById(a.f.lmpi_create_envelope_title_ll));
      AppMethodBeat.o(272546);
    }
    
    public final void a(final LuckyMoneyPickEnvelopeUI.e parame)
    {
      AppMethodBeat.i(272547);
      this.amk.setSelected(parame.tsm);
      if (parame.ECc != null)
      {
        this.EMB.setText(parame.ECc.Tqy);
        this.EMC.setText(parame.ECc.Tqz);
        ar.a(this.EMB.getPaint(), 0.8F);
        ar.a(this.EMC.getPaint(), 0.8F);
        this.EME.setClickable(true);
        this.EME.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(226195);
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              LuckyMoneyPickEnvelopeUI.c.this.EMD.setIconColor(LuckyMoneyPickEnvelopeUI.this.getContext().getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.UN_BW_0_Alpha_0_1));
              LuckyMoneyPickEnvelopeUI.c.this.EMB.setTextColor(LuckyMoneyPickEnvelopeUI.this.getContext().getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.UN_BW_0_Alpha_0_1));
            }
            for (;;)
            {
              AppMethodBeat.o(226195);
              return false;
              LuckyMoneyPickEnvelopeUI.c.this.EMD.setIconColor(LuckyMoneyPickEnvelopeUI.this.getContext().getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.lucky_money_goldstyle_detail_primary_text_color));
              LuckyMoneyPickEnvelopeUI.c.this.EMB.setTextColor(LuckyMoneyPickEnvelopeUI.this.getContext().getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.lucky_money_goldstyle_detail_primary_text_color));
              Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "on click ");
              g.v(parame.ECc.Tqw, parame.ECc.Tqx, 0, 1100);
            }
          }
        });
      }
      AppMethodBeat.o(272547);
    }
    
    public final void tS(boolean paramBoolean) {}
  }
  
  final class d
    extends RecyclerView.a<LuckyMoneyPickEnvelopeUI.a>
  {
    private d() {}
    
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
      long l = ((LuckyMoneyPickEnvelopeUI.e)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(paramInt)).hashCode();
      AppMethodBeat.o(65804);
      return l;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(190035);
      LuckyMoneyPickEnvelopeUI.e locale = (LuckyMoneyPickEnvelopeUI.e)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(paramInt);
      if (locale.EMG)
      {
        AppMethodBeat.o(190035);
        return 3;
      }
      if (locale.ECc.llL == 3)
      {
        AppMethodBeat.o(190035);
        return 2;
      }
      if (locale.ECc.llL == 4)
      {
        AppMethodBeat.o(190035);
        return 4;
      }
      AppMethodBeat.o(190035);
      return 1;
    }
  }
  
  static final class e
  {
    public cjf ECc;
    public boolean EMG;
    public boolean tsm = false;
  }
  
  final class g
    extends LuckyMoneyPickEnvelopeUI.a
  {
    ImageView EMl;
    View EMm;
    ImageView EMn;
    ProgressBar EMo;
    TextView EMp;
    TextView EMq;
    TextView EMr;
    ViewGroup EMs;
    ProgressBar EMt;
    TextView jbF;
    ImageView jiu;
    Button wNZ;
    TextView xoK;
    
    public g(View paramView)
    {
      super();
      AppMethodBeat.i(276918);
      this.EMs = ((ViewGroup)paramView.findViewById(a.f.lmpi_content_view));
      this.EMl = ((ImageView)paramView.findViewById(a.f.lmpi_envelope_iv));
      this.jbF = ((TextView)paramView.findViewById(a.f.lmpi_envelope_name_tv));
      this.jiu = ((ImageView)paramView.findViewById(a.f.lmpi_avatar_iv));
      this.xoK = ((TextView)paramView.findViewById(a.f.lmpi_nickname_tv));
      this.EMm = paramView.findViewById(a.f.lmpi_white_cover_view);
      this.EMn = ((ImageView)paramView.findViewById(a.f.lmpi_loading_iv));
      this.EMo = ((ProgressBar)paramView.findViewById(a.f.lmpi_anim_pb));
      this.EMp = ((TextView)paramView.findViewById(a.f.lmpi_retry_tv));
      this.EMq = ((TextView)paramView.findViewById(a.f.lmpi_envelope_leave_tv));
      this.EMr = ((TextView)paramView.findViewById(a.f.lmpi_temp_label_tv));
      this.wNZ = ((Button)paramView.findViewById(a.f.lmpi_envelope_open_btn));
      String str = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
      if ((str == null) || (str.length() <= 0) || ((!str.equals("zh_CN")) && (!str.equals("zh_TW")) && (!str.equals("zh_HK"))))
      {
        this.wNZ.setBackgroundResource(a.e.pick_envelope_btn_icon);
        this.wNZ.setText(a.i.lucky_money_open_title);
      }
      this.EMt = ((ProgressBar)paramView.findViewById(a.f.lmpi_inline_cover_loading_pb));
      if (ar.isDarkMode()) {
        this.EMs.setBackgroundResource(a.e.lucky_money_pick_envelope_item_dark_bg);
      }
      for (;;)
      {
        this$1 = new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(274459);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$NormalVH$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
            LuckyMoneyPickEnvelopeUI.g.a(LuckyMoneyPickEnvelopeUI.g.this, paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$NormalVH$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(274459);
            return false;
          }
        };
        paramView.setOnLongClickListener(LuckyMoneyPickEnvelopeUI.this);
        this.EMm.setOnLongClickListener(LuckyMoneyPickEnvelopeUI.this);
        AppMethodBeat.o(276918);
        return;
        this.EMs.setBackgroundResource(a.e.lucky_money_pick_envelope_item_bg);
      }
    }
    
    private void a(final cjf paramcjf, boolean paramBoolean)
    {
      AppMethodBeat.i(276922);
      if (paramBoolean)
      {
        this.EMn.setVisibility(8);
        this.EMo.setVisibility(0);
        this.EMp.setVisibility(8);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.EMl, paramcjf, new com.tencent.mm.plugin.luckymoney.a.a.a()
        {
          public final void eG(final boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(267710);
            Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "load ok: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            Runnable local1 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(186523);
                LuckyMoneyPickEnvelopeUI.g.this.EMt.setVisibility(8);
                if ((LuckyMoneyPickEnvelopeUI.l(LuckyMoneyPickEnvelopeUI.this) != null) && (LuckyMoneyPickEnvelopeUI.l(LuckyMoneyPickEnvelopeUI.this).isShowing())) {
                  LuckyMoneyPickEnvelopeUI.l(LuckyMoneyPickEnvelopeUI.this).dismiss();
                }
                if ((LuckyMoneyPickEnvelopeUI.g.5.this.EJt.Tqq == 1) || (LuckyMoneyPickEnvelopeUI.g.5.this.EJt.RUO == 1))
                {
                  Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "envelope has expired do nothing");
                  AppMethodBeat.o(186523);
                  return;
                }
                if (!paramAnonymousBoolean)
                {
                  LuckyMoneyPickEnvelopeUI.g.this.EMm.setVisibility(0);
                  LuckyMoneyPickEnvelopeUI.g.this.EMn.setVisibility(0);
                  LuckyMoneyPickEnvelopeUI.g.this.EMo.setVisibility(8);
                  LuckyMoneyPickEnvelopeUI.g.this.EMp.setVisibility(0);
                  AppMethodBeat.o(186523);
                  return;
                }
                LuckyMoneyPickEnvelopeUI.g.this.EMm.setVisibility(8);
                AppMethodBeat.o(186523);
              }
            };
            if (MMHandlerThread.isMainThread())
            {
              local1.run();
              AppMethodBeat.o(267710);
              return;
            }
            LuckyMoneyPickEnvelopeUI.g.this.EMm.post(local1);
            AppMethodBeat.o(267710);
          }
        });
        AppMethodBeat.o(276922);
        return;
        if ("0".equals(paramcjf.SpP))
        {
          Log.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "default envelope");
          AppMethodBeat.o(276922);
          return;
        }
        this.EMt.setVisibility(0);
      }
    }
    
    private void eQh()
    {
      AppMethodBeat.i(276921);
      this.EMm.setVisibility(0);
      this.EMn.setVisibility(8);
      this.EMo.setVisibility(8);
      this.EMp.setVisibility(8);
      this.EMm.setOnClickListener(null);
      AppMethodBeat.o(276921);
    }
    
    public final void a(final LuckyMoneyPickEnvelopeUI.e parame)
    {
      AppMethodBeat.i(276920);
      this.amk.setSelected(parame.tsm);
      a.b.a(this.jiu, z.bcZ(), 0.06F, false);
      this.xoK.setText(LuckyMoneyPickEnvelopeUI.this.getString(a.i.lucky_money_whose, new Object[] { l.d(LuckyMoneyPickEnvelopeUI.this.getContext(), z.bdb(), com.tencent.mm.ci.a.aY(LuckyMoneyPickEnvelopeUI.this.getContext(), com.tencent.mm.plugin.wxpay.a.d.SmallerTextSize)) }));
      this.EMl.setImageBitmap(null);
      this.EMm.setVisibility(8);
      if (parame.ECc != null)
      {
        this.jbF.setText(parame.ECc.Tqn);
        if (parame.ECc.Tqo != null) {
          a(parame.ECc, false);
        }
        this.EMm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(196236);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$NormalVH$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            LuckyMoneyPickEnvelopeUI.g.a(LuckyMoneyPickEnvelopeUI.g.this, parame.ECc);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$NormalVH$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(196236);
          }
        });
        if (!Util.isNullOrNil(parame.ECc.Tqp))
        {
          this.EMq.setText(parame.ECc.Tqp);
          this.EMq.setVisibility(0);
          this.EMq.setOnTouchListener(null);
          this.EMq.setClickable(false);
          if (parame.ECc.llL != 2) {
            break label290;
          }
          this.EMr.setVisibility(0);
        }
        for (;;)
        {
          if ((parame.ECc.llL != 1) || (Util.isNullOrNil(parame.ECc.Tqu))) {
            break label302;
          }
          this.EMq.setVisibility(0);
          this.EMq.setText(parame.ECc.Tqu);
          AppMethodBeat.o(276920);
          return;
          this.EMq.setText("");
          break;
          label290:
          this.EMr.setVisibility(8);
        }
        label302:
        if (parame.ECc.RUO == 1)
        {
          this.amk.setSelected(false);
          this.EMs.setEnabled(false);
          this.EMq.setVisibility(0);
          if (!Util.isNullOrNil(parame.ECc.Tqt)) {
            this.EMq.setText(parame.ECc.Tqt);
          }
          eQh();
          AppMethodBeat.o(276920);
          return;
        }
        if (parame.ECc.Tqq == 1)
        {
          this.amk.setSelected(false);
          this.EMs.setEnabled(false);
          if (!Util.isNullOrNil(parame.ECc.Tqp))
          {
            this.EMq.setText(parame.ECc.Tqp);
            this.EMq.setVisibility(0);
          }
          this.EMm.setVisibility(8);
          this.EMn.setVisibility(8);
          this.EMo.setVisibility(8);
          this.EMp.setVisibility(8);
          this.EMm.setOnClickListener(null);
          AppMethodBeat.o(276920);
          return;
        }
        if (LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this, parame.ECc.SpP))
        {
          this.amk.setSelected(false);
          this.EMs.setEnabled(false);
          this.EMq.setText(a.i.lucky_money_envelope_illegal_tips);
          this.EMq.setVisibility(0);
          eQh();
          AppMethodBeat.o(276920);
          return;
        }
        this.EMs.setEnabled(true);
        if (Util.isNullOrNil(this.EMq.getText())) {
          this.EMq.setVisibility(4);
        }
        this.EMm.setVisibility(8);
      }
      AppMethodBeat.o(276920);
    }
    
    public final void tS(boolean paramBoolean)
    {
      AppMethodBeat.i(276919);
      this.amk.setSelected(paramBoolean);
      AppMethodBeat.o(276919);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI
 * JD-Core Version:    0.7.0.1
 */