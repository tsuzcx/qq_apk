package com.tencent.mm.plugin.luckymoney.ui;

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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.transition.Transition;
import androidx.transition.Transition.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.a.tw;
import com.tencent.mm.plugin.luckymoney.model.e;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.plugin.luckymoney.scaledLayout.ScaleLayoutManager;
import com.tencent.mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.afv;
import com.tencent.mm.protocal.protobuf.csm;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.protocal.protobuf.zn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.f.k;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.ui.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(1)
public class LuckyMoneyPickEnvelopeUI
  extends MMActivity
{
  private RecyclerView.l JzU;
  private LuckyMoneyEnvelopeTouchRecyclerView KGa;
  private d KGb;
  private ScaleLayoutManager KGc;
  private List<e> KGd;
  private boolean KGe;
  private int KGf;
  private int KGg;
  private boolean KGh;
  private String KGi;
  private com.tencent.mm.plugin.luckymoney.scaledLayout.a KGj;
  private Button KGk;
  private LinkedList<String> KGl;
  private boolean KGm;
  private Boolean KGn;
  private String KGo;
  private String KGp;
  private String KGq;
  private boolean KGr;
  private IListener<tw> KGs;
  private boolean KGt;
  private int Knk;
  private View bEx;
  private boolean isLoading;
  private String sessionId;
  private long startTime;
  private View startView;
  private Dialog tipDialog;
  
  public LuckyMoneyPickEnvelopeUI()
  {
    AppMethodBeat.i(65813);
    this.KGd = new ArrayList();
    this.KGe = false;
    this.KGf = -1;
    this.KGg = -1;
    this.KGh = false;
    this.isLoading = false;
    this.Knk = 0;
    this.KGm = true;
    this.KGr = false;
    this.KGs = new LuckyMoneyPickEnvelopeUI.6(this, com.tencent.mm.app.f.hfK);
    this.KGt = false;
    AppMethodBeat.o(65813);
  }
  
  private void a(csm paramcsm)
  {
    AppMethodBeat.i(65818);
    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "try show illegal msg");
    if (Util.isNullOrNil(paramcsm.Krp))
    {
      AppMethodBeat.o(65818);
      return;
    }
    ArrayList localArrayList = new ArrayList(Util.stringToList((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVg, ""), ","));
    this.KGl = paramcsm.aayA;
    Iterator localIterator = this.KGl.iterator();
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
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acVg, Util.listToString(localArrayList, ","));
        k.a(this, paramcsm.Krp, "", getString(a.i.app_i_known), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      AppMethodBeat.o(65818);
      return;
    }
  }
  
  private void a(csm paramcsm, boolean paramBoolean)
  {
    AppMethodBeat.i(284462);
    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "update by resp");
    if (paramcsm.aayB == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.KGh = bool;
      a(paramcsm);
      if (paramcsm.aayx != null)
      {
        if (!paramcsm.aayx.isEmpty()) {
          break;
        }
        this.bEx.setVisibility(0);
        this.KGa.setVisibility(8);
      }
      this.KGb.bZE.notifyChanged();
      fYL();
      AppMethodBeat.o(284462);
      return;
    }
    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "list size: %s", new Object[] { Integer.valueOf(paramcsm.aayx.size()) });
    int m;
    Iterator localIterator;
    int i;
    int j;
    if (!Util.isNullOrNil(this.KGp))
    {
      m = 1;
      localIterator = paramcsm.aayx.iterator();
      i = 0;
      j = -1;
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        czi localczi = (czi)localIterator.next();
        if ((localczi.user_flag == 1) || (localczi.aaEs == 1) || (aKO(localczi.ZoK)))
        {
          Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "filter unused envelope: %s", new Object[] { localczi.ZoK });
          continue;
          m = 0;
          break;
        }
        e locale = new e((byte)0);
        locale.Kvd = localczi;
        int n = j;
        int k;
        if (paramBoolean)
        {
          if (m == 0) {
            break label405;
          }
          k = j;
          if (localczi.ZoK.equals(this.KGp))
          {
            locale.wwJ = true;
            k = j;
          }
          n = k;
          if (locale.wwJ)
          {
            this.KGf = i;
            n = k;
          }
        }
        if (localczi.nQJ == 3)
        {
          this.KGq = localczi.ZoK;
          com.tencent.mm.plugin.report.service.h.OAn.b(22104, new Object[] { this.KGq, Integer.valueOf(1) });
        }
        if ((localczi.aaEq != null) && (!Util.isNullOrNil(localczi.aaEq.aaEP))) {
          this.KGe = true;
        }
        this.KGd.add(locale);
        i += 1;
        j = n;
        continue;
        label405:
        if ((localczi.aaEs != 1) && (localczi.user_flag != 1) && (!aKO(localczi.ZoK)))
        {
          n = 1;
          label438:
          if ((localczi.aaEt != 1) || (n == 0)) {
            break label492;
          }
        }
        label492:
        for (bool = true;; bool = false)
        {
          locale.wwJ = bool;
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
          break label438;
        }
      }
    }
    if (this.KGf < 0) {
      if (j < 0) {
        break label652;
      }
    }
    label652:
    for (this.KGf = j;; this.KGf = 0)
    {
      ((e)this.KGd.get(this.KGf)).wwJ = true;
      if (paramcsm.aayD == 1)
      {
        paramcsm = new e((byte)0);
        paramcsm.Kvd = new czi();
        paramcsm.KGZ = true;
        this.KGd.add(paramcsm);
      }
      if (!this.KGm) {
        break;
      }
      this.KGm = false;
      this.KGg = this.KGf;
      if ((this.KGg < 0) || (this.KGg >= this.KGd.size())) {
        break;
      }
      this.KGo = ((e)this.KGd.get(this.KGg)).Kvd.ZoK;
      break;
    }
  }
  
  private boolean aKO(String paramString)
  {
    AppMethodBeat.i(163789);
    if ((this.KGl != null) && (!this.KGl.isEmpty()))
    {
      Iterator localIterator = this.KGl.iterator();
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
  
  private void fYK()
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
          i = localScaleLayoutManager.EK(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
          if (localScaleLayoutManager.mOrientation == 1) {
            localLuckyMoneyEnvelopeTouchRecyclerView.scrollBy(0, i);
          }
        }
        else
        {
          Math.max(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this), 0);
          LuckyMoneyPickEnvelopeUI.fYO();
          if (LuckyMoneyPickEnvelopeUI.s(LuckyMoneyPickEnvelopeUI.this) != null) {
            break label174;
          }
          LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, new RecyclerView.l()
          {
            public final void onScrollStateChanged(RecyclerView paramAnonymous2RecyclerView, int paramAnonymous2Int)
            {
              AppMethodBeat.i(284339);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymous2RecyclerView);
              localb.sc(paramAnonymous2Int);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
              super.onScrollStateChanged(paramAnonymous2RecyclerView, paramAnonymous2Int);
              Log.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "on scroll changed: %s", new Object[] { Integer.valueOf(paramAnonymous2Int) });
              if (paramAnonymous2Int == 0)
              {
                if ((!LuckyMoneyPickEnvelopeUI.t(LuckyMoneyPickEnvelopeUI.this)) && (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0))
                {
                  paramAnonymous2RecyclerView = (LuckyMoneyPickEnvelopeUI.e)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
                  com.tencent.mm.plugin.report.service.h.OAn.b(19272, new Object[] { Integer.valueOf(1), LuckyMoneyPickEnvelopeUI.d(LuckyMoneyPickEnvelopeUI.this), paramAnonymous2RecyclerView.Kvd.ZoK });
                  LuckyMoneyPickEnvelopeUI.u(LuckyMoneyPickEnvelopeUI.this);
                }
                if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0)
                {
                  paramAnonymous2RecyclerView = (LuckyMoneyPickEnvelopeUI.e)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
                  if (paramAnonymous2RecyclerView.Kvd.nQJ == 3) {
                    com.tencent.mm.plugin.report.service.h.OAn.b(22104, new Object[] { paramAnonymous2RecyclerView.Kvd.ZoK, Integer.valueOf(2) });
                  }
                }
                LuckyMoneyPickEnvelopeUI.v(LuckyMoneyPickEnvelopeUI.this);
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
              AppMethodBeat.o(284339);
            }
            
            public final void onScrolled(RecyclerView paramAnonymous2RecyclerView, int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(284351);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymous2RecyclerView);
              localb.sc(paramAnonymous2Int1);
              localb.sc(paramAnonymous2Int2);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
              super.onScrolled(paramAnonymous2RecyclerView, paramAnonymous2Int1, paramAnonymous2Int2);
              paramAnonymous2Int1 = LuckyMoneyPickEnvelopeUI.i(LuckyMoneyPickEnvelopeUI.this).Jw();
              Log.v("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll last vispos: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
              if ((!LuckyMoneyPickEnvelopeUI.w(LuckyMoneyPickEnvelopeUI.this)) && (LuckyMoneyPickEnvelopeUI.n(LuckyMoneyPickEnvelopeUI.this) == 1) && (paramAnonymous2Int1 == LuckyMoneyPickEnvelopeUI.q(LuckyMoneyPickEnvelopeUI.this).getItemCount() - 1))
              {
                Log.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "trigger load more: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, false);
              }
              LuckyMoneyPickEnvelopeUI.j(LuckyMoneyPickEnvelopeUI.this);
              paramAnonymous2RecyclerView = com.tencent.mm.plugin.luckymoney.scaledLayout.a.j(LuckyMoneyPickEnvelopeUI.i(LuckyMoneyPickEnvelopeUI.this));
              LuckyMoneyPickEnvelopeUI.r(LuckyMoneyPickEnvelopeUI.this);
              paramAnonymous2Int1 = LuckyMoneyEnvelopeTouchRecyclerView.bA(paramAnonymous2RecyclerView);
              LuckyMoneyPickEnvelopeUI.fYP();
              if ((paramAnonymous2Int1 != LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this)) && (paramAnonymous2Int1 >= 0) && (paramAnonymous2Int1 < LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).size()))
              {
                paramAnonymous2RecyclerView = (LuckyMoneyPickEnvelopeUI.e)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(paramAnonymous2Int1);
                if ((paramAnonymous2RecyclerView.Kvd != null) && ((paramAnonymous2RecyclerView.Kvd.aaEs == 1) || (paramAnonymous2RecyclerView.Kvd.user_flag == 1)))
                {
                  Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "expired: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                  if ((LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) && (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) < LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).size()))
                  {
                    ((LuckyMoneyPickEnvelopeUI.e)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).wwJ = false;
                    LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this), false);
                    LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this, -1);
                  }
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
                  AppMethodBeat.o(284351);
                  return;
                }
                if (!paramAnonymous2RecyclerView.KGZ) {
                  break label473;
                }
                LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this, -2);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$10$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
                AppMethodBeat.o(284351);
                return;
                label473:
                if (!paramAnonymous2RecyclerView.wwJ)
                {
                  Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do select pos: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                  if ((LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) && (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) < LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).size()))
                  {
                    ((LuckyMoneyPickEnvelopeUI.e)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).wwJ = false;
                    paramAnonymous2Int2 = LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this);
                    LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, paramAnonymous2Int2, false);
                  }
                  paramAnonymous2RecyclerView.wwJ = true;
                  LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this, paramAnonymous2Int1);
                  LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this), true);
                }
                else
                {
                  paramAnonymous2RecyclerView.wwJ = false;
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
    this.KGa.post(local2);
    AppMethodBeat.o(163791);
  }
  
  private void fYL()
  {
    AppMethodBeat.i(284467);
    if (this.KGf == -1)
    {
      this.KGk.setEnabled(false);
      this.KGk.setText(a.i.lucky_money_envelope_use_btn_text);
    }
    for (;;)
    {
      this.KGk.setVisibility(0);
      AppMethodBeat.o(284467);
      return;
      if (this.KGf == -2)
      {
        if (!this.KGr)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(22302, new Object[] { Integer.valueOf(2) });
          this.KGr = true;
        }
        this.KGk.setVisibility(4);
        AppMethodBeat.o(284467);
        return;
      }
      if (fYM())
      {
        this.KGk.setVisibility(4);
        AppMethodBeat.o(284467);
        return;
      }
      this.KGk.setEnabled(true);
      if (!fYN()) {
        break;
      }
      this.KGk.setText(a.i.lucky_money_envelope_receive_use_btn_text);
    }
  }
  
  private boolean fYM()
  {
    AppMethodBeat.i(284473);
    if ((this.KGf < 0) || (this.KGf >= this.KGd.size()))
    {
      AppMethodBeat.o(284473);
      return false;
    }
    e locale = (e)this.KGd.get(this.KGf);
    if ((locale.wwJ) && (locale.Kvd != null) && (locale.Kvd.nQJ == 4))
    {
      AppMethodBeat.o(284473);
      return true;
    }
    AppMethodBeat.o(284473);
    return false;
  }
  
  private boolean fYN()
  {
    AppMethodBeat.i(284476);
    if ((this.KGf < 0) || (this.KGf >= this.KGd.size()))
    {
      AppMethodBeat.o(284476);
      return false;
    }
    e locale = (e)this.KGd.get(this.KGf);
    if ((locale.wwJ) && (locale.Kvd != null) && (locale.Kvd.nQJ == 3))
    {
      AppMethodBeat.o(284476);
      return true;
    }
    AppMethodBeat.o(284476);
    return false;
  }
  
  private void yd(final boolean paramBoolean)
  {
    AppMethodBeat.i(163790);
    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "do get show source: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), this.KGi });
    if (paramBoolean) {
      this.KGi = "";
    }
    this.tipDialog = k.a(getContext(), 3, a.j.LuckyMoneyNoAnimDialog, getString(a.i.loading_tips), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    this.isLoading = true;
    l locall = l.fWR();
    locall.d(new e(this.KGi, 1));
    locall.a(new com.tencent.mm.wallet_core.model.a.a() {}, 0L);
    AppMethodBeat.o(163790);
  }
  
  public int getLayoutId()
  {
    return a.g.lucky_money_pick_envelope_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(65815);
    this.KGa = ((LuckyMoneyEnvelopeTouchRecyclerView)findViewById(a.f.lmps_rv));
    this.bEx = findViewById(a.f.lmps_empty_view);
    this.KGk = ((Button)findViewById(a.f.lmps_envelope_confirm_btn));
    this.KGb = new d((byte)0);
    this.KGb.bf(true);
    this.KGa.setAdapter(this.KGb);
    this.KGa.setItemAnimator(null);
    this.KGc = new ScaleLayoutManager(this)
    {
      public final void fXr()
      {
        AppMethodBeat.i(65792);
        super.fXr();
        this.KvI -= 31.0F;
        AppMethodBeat.o(65792);
      }
    };
    ScaleLayoutManager localScaleLayoutManager = this.KGc;
    localScaleLayoutManager.assertNotInLayoutOrScroll(null);
    if (localScaleLayoutManager.minScale != 0.8F)
    {
      localScaleLayoutManager.minScale = 0.8F;
      localScaleLayoutManager.removeAllViews();
    }
    this.KGa.setLayoutManager(this.KGc);
    this.KGj = new com.tencent.mm.plugin.luckymoney.scaledLayout.a();
    this.KGj.context = this;
    this.KGj.a(this.KGa);
    this.KGa.KCy = new LuckyMoneyEnvelopeTouchRecyclerView.a()
    {
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(65793);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          paramAnonymousMotionEvent = LuckyMoneyPickEnvelopeUI.this;
          LuckyMoneyPickEnvelopeUI.j(LuckyMoneyPickEnvelopeUI.this);
          LuckyMoneyPickEnvelopeUI.a(paramAnonymousMotionEvent, com.tencent.mm.plugin.luckymoney.scaledLayout.a.j(LuckyMoneyPickEnvelopeUI.i(LuckyMoneyPickEnvelopeUI.this)));
          LuckyMoneyPickEnvelopeUI.j(LuckyMoneyPickEnvelopeUI.this).startView = LuckyMoneyPickEnvelopeUI.k(LuckyMoneyPickEnvelopeUI.this);
        }
        AppMethodBeat.o(65793);
        return false;
      }
    };
    getIntent().getStringExtra(f.k.adwy);
    getIntent().getStringExtra(f.k.adwz);
    this.KGk.setOnClickListener(new ac()
    {
      public final void dsb()
      {
        AppMethodBeat.i(284260);
        Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "click save: %s", new Object[] { Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this)) });
        Object localObject;
        String str;
        if ((LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) && (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) < LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).size()))
        {
          localObject = (LuckyMoneyPickEnvelopeUI.e)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
          if ((((LuckyMoneyPickEnvelopeUI.e)localObject).wwJ) && (((LuckyMoneyPickEnvelopeUI.e)localObject).Kvd != null))
          {
            str = ((LuckyMoneyPickEnvelopeUI.e)localObject).Kvd.ZoK;
            if (((LuckyMoneyPickEnvelopeUI.e)localObject).Kvd.nQJ != 3) {
              break label312;
            }
            LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this, str, ((LuckyMoneyPickEnvelopeUI.e)localObject).Kvd.aaEH, LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this));
            com.tencent.mm.plugin.report.service.h.OAn.b(22104, new Object[] { ((LuckyMoneyPickEnvelopeUI.e)localObject).Kvd.ZoK, Integer.valueOf(3) });
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(16822, new Object[] { Integer.valueOf(3) });
          localObject = "";
          if (LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) >= 0) {
            localObject = ((LuckyMoneyPickEnvelopeUI.e)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).Kvd.ZoK;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(18892, new Object[] { Integer.valueOf(1), Integer.valueOf(LuckyMoneyPickEnvelopeUI.c(LuckyMoneyPickEnvelopeUI.this) + 1), Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) + 1), LuckyMoneyPickEnvelopeUI.d(LuckyMoneyPickEnvelopeUI.this), localObject, LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this) });
          AppMethodBeat.o(284260);
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
    getIntent().getByteArrayExtra(f.k.adww);
    boolean bool = getIntent().getBooleanExtra(f.k.adwx, true);
    this.KGn = Boolean.valueOf(getIntent().getBooleanExtra(f.k.adwA, false));
    this.sessionId = getIntent().getStringExtra("key_session_id");
    paramBundle = getIntent().getStringExtra(f.k.adwz);
    this.KGp = getIntent().getStringExtra("packetId");
    Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll packageid: %s", new Object[] { this.KGp });
    Object localObject;
    if (bool)
    {
      int i = j;
      if (getIntent().getBooleanExtra(f.k.adwB, false))
      {
        l.fWR();
        localObject = l.fWS();
        i = j;
        if (localObject != null)
        {
          i = j;
          if (((csm)localObject).hAV == 0)
          {
            this.KGi = ((csm)localObject).aayy;
            this.Knk = ((csm)localObject).aayz;
            a((csm)localObject, true);
            fYK();
            i = 1;
          }
        }
      }
      if (i == 0) {
        yd(true);
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
            paramAnonymousMenuItem = ((LuckyMoneyPickEnvelopeUI.e)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this))).Kvd.ZoK;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(18892, new Object[] { Integer.valueOf(2), Integer.valueOf(LuckyMoneyPickEnvelopeUI.c(LuckyMoneyPickEnvelopeUI.this) + 1), Integer.valueOf(LuckyMoneyPickEnvelopeUI.a(LuckyMoneyPickEnvelopeUI.this) + 1), LuckyMoneyPickEnvelopeUI.d(LuckyMoneyPickEnvelopeUI.this), paramAnonymousMenuItem, LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this) });
          if (!Util.isNullOrNil(LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this))) {
            com.tencent.mm.plugin.report.service.h.OAn.b(22104, new Object[] { LuckyMoneyPickEnvelopeUI.f(LuckyMoneyPickEnvelopeUI.this), Integer.valueOf(4), Long.valueOf(Util.ticksToNow(LuckyMoneyPickEnvelopeUI.g(LuckyMoneyPickEnvelopeUI.this)) / 1000L) });
          }
          LuckyMoneyPickEnvelopeUI.this.setResult(0);
          LuckyMoneyPickEnvelopeUI.this.finish();
          AppMethodBeat.o(65787);
          return false;
        }
      });
      if (!Util.isNullOrNil(paramBundle)) {
        addTextOptionMenu(1, getString(a.i.lucky_money_envelope_add_text), com.tencent.mm.cd.a.w(getContext(), com.tencent.mm.ah.a.d.link_color_selector), new MenuItem.OnMenuItemClickListener()
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
            i.d(LuckyMoneyPickEnvelopeUI.this.getContext(), localIntent, 1);
            paramAnonymousMenuItem = com.tencent.mm.plugin.report.service.h.OAn;
            if (LuckyMoneyPickEnvelopeUI.h(LuckyMoneyPickEnvelopeUI.this).booleanValue()) {}
            for (int i = 2;; i = 1)
            {
              paramAnonymousMenuItem.b(18890, new Object[] { Integer.valueOf(3), Integer.valueOf(i), LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this) });
              AppMethodBeat.o(65791);
              return false;
            }
          }
        });
      }
      fYL();
      this.KGs.alive();
      AppMethodBeat.o(65814);
      return;
      this.KGh = false;
      this.Knk = 0;
      this.KGf = 0;
      localObject = new e((byte)0);
      ((e)localObject).wwJ = true;
      ((e)localObject).Kvd = new czi();
      ((e)localObject).Kvd.ZoK = "0";
      ((e)localObject).Kvd.aaEp = getString(a.i.lucky_money_default_envelope_name);
      this.KGd.add(localObject);
      this.KGb.bZE.notifyChanged();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65816);
    super.onDestroy();
    this.KGs.dead();
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
    Button AkB;
    ImageView KGE;
    View KGF;
    ImageView KGG;
    ProgressBar KGH;
    TextView KGI;
    TextView KGJ;
    TextView KGK;
    ViewGroup KGL;
    ProgressBar KGM;
    ImageView KGN;
    ViewGroup KGO;
    TextView KGP;
    TextView KGQ;
    TextView lDF;
    ImageView lKK;
    TextView nicknameTv;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(284193);
      this.KGL = ((ViewGroup)paramView.findViewById(a.f.lmpi_content_view));
      this.KGE = ((ImageView)paramView.findViewById(a.f.lmpi_envelope_iv));
      this.lDF = ((TextView)paramView.findViewById(a.f.lmpi_envelope_name_tv));
      this.lKK = ((ImageView)paramView.findViewById(a.f.lmpi_avatar_iv));
      this.nicknameTv = ((TextView)paramView.findViewById(a.f.lmpi_nickname_tv));
      this.KGF = paramView.findViewById(a.f.lmpi_white_cover_view);
      this.KGG = ((ImageView)paramView.findViewById(a.f.lmpi_loading_iv));
      this.KGH = ((ProgressBar)paramView.findViewById(a.f.lmpi_anim_pb));
      this.KGI = ((TextView)paramView.findViewById(a.f.lmpi_retry_tv));
      this.KGJ = ((TextView)paramView.findViewById(a.f.lmpi_envelope_leave_tv));
      this.KGK = ((TextView)paramView.findViewById(a.f.lmpi_temp_label_tv));
      this.AkB = ((Button)paramView.findViewById(a.f.lmpi_envelope_open_btn));
      this.KGN = ((ImageView)paramView.findViewById(a.f.lmpi_envelope_biz_snapshot_iv));
      this.KGO = ((ViewGroup)paramView.findViewById(a.f.lmpi_envelope_red_bg));
      this.KGP = ((TextView)paramView.findViewById(a.f.lmpi_envelope_biz_title_tv));
      this.KGQ = ((TextView)paramView.findViewById(a.f.lmpi_envelope_biz_desc_tv));
      i.Q(this.KGP);
      i.Q(this.KGQ);
      this$1 = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
      if ((LuckyMoneyPickEnvelopeUI.this == null) || (LuckyMoneyPickEnvelopeUI.this.length() <= 0) || ((!LuckyMoneyPickEnvelopeUI.this.equals("zh_CN")) && (!LuckyMoneyPickEnvelopeUI.this.equals("zh_TW")) && (!LuckyMoneyPickEnvelopeUI.this.equals("zh_HK"))))
      {
        this.AkB.setBackgroundResource(a.e.pick_envelope_btn_icon);
        this.AkB.setText(a.i.lucky_money_open_title);
      }
      this.KGM = ((ProgressBar)paramView.findViewById(a.f.lmpi_inline_cover_loading_pb));
      if (aw.isDarkMode()) {
        this.KGL.setBackgroundResource(a.e.lucky_money_pick_envelope_item_dark_bg);
      }
      for (;;)
      {
        this.KGL.setEnabled(false);
        AppMethodBeat.o(284193);
        return;
        this.KGL.setBackgroundResource(a.e.lucky_money_pick_envelope_item_bg);
      }
    }
    
    private void a(final czi paramczi, boolean paramBoolean)
    {
      AppMethodBeat.i(284199);
      if (paramBoolean)
      {
        this.KGG.setVisibility(8);
        this.KGH.setVisibility(0);
        this.KGI.setVisibility(8);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.KGE, paramczi, new com.tencent.mm.plugin.luckymoney.a.a.a()
        {
          public final void onComplete(final boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(284296);
            Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "load ok: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            Runnable local1 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(284362);
                LuckyMoneyPickEnvelopeUI.b.this.KGM.setVisibility(8);
                if ((LuckyMoneyPickEnvelopeUI.l(LuckyMoneyPickEnvelopeUI.this) != null) && (LuckyMoneyPickEnvelopeUI.l(LuckyMoneyPickEnvelopeUI.this).isShowing())) {
                  LuckyMoneyPickEnvelopeUI.l(LuckyMoneyPickEnvelopeUI.this).dismiss();
                }
                if ((LuckyMoneyPickEnvelopeUI.b.2.this.KCZ.aaEs == 1) || (LuckyMoneyPickEnvelopeUI.b.2.this.KCZ.user_flag == 1))
                {
                  Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "envelope has expired do nothing");
                  AppMethodBeat.o(284362);
                  return;
                }
                if (!paramAnonymousBoolean)
                {
                  LuckyMoneyPickEnvelopeUI.b.this.KGF.setVisibility(0);
                  LuckyMoneyPickEnvelopeUI.b.this.KGG.setVisibility(0);
                  LuckyMoneyPickEnvelopeUI.b.this.KGH.setVisibility(8);
                  LuckyMoneyPickEnvelopeUI.b.this.KGI.setVisibility(0);
                  AppMethodBeat.o(284362);
                  return;
                }
                LuckyMoneyPickEnvelopeUI.b.this.KGF.setVisibility(8);
                AppMethodBeat.o(284362);
              }
            };
            if (MMHandlerThread.isMainThread())
            {
              local1.run();
              AppMethodBeat.o(284296);
              return;
            }
            LuckyMoneyPickEnvelopeUI.b.this.KGF.post(local1);
            AppMethodBeat.o(284296);
          }
        });
        AppMethodBeat.o(284199);
        return;
        if ("0".equals(paramczi.ZoK))
        {
          Log.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "default envelope");
          AppMethodBeat.o(284199);
          return;
        }
        this.KGM.setVisibility(0);
      }
    }
    
    public final void a(final LuckyMoneyPickEnvelopeUI.e parame)
    {
      AppMethodBeat.i(284207);
      this.caK.setSelected(parame.wwJ);
      a.b.a(this.lKK, com.tencent.mm.model.z.bAM(), 0.06F, false);
      this.nicknameTv.setText(LuckyMoneyPickEnvelopeUI.this.getString(a.i.lucky_money_whose, new Object[] { p.d(LuckyMoneyPickEnvelopeUI.this.getContext(), com.tencent.mm.model.z.bAO(), com.tencent.mm.cd.a.br(LuckyMoneyPickEnvelopeUI.this.getContext(), com.tencent.mm.plugin.wxpay.a.d.SmallerTextSize)) }));
      this.KGE.setImageBitmap(null);
      this.KGF.setVisibility(8);
      if (parame.Kvd != null)
      {
        this.lDF.setText(parame.Kvd.aaEp);
        this.KGP.setText(parame.Kvd.aaEp);
        if (parame.Kvd.aaEq != null) {
          a(parame.Kvd, false);
        }
        this.KGF.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(284295);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$BizVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            LuckyMoneyPickEnvelopeUI.b.a(LuckyMoneyPickEnvelopeUI.b.this, parame.Kvd);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$BizVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(284295);
          }
        });
        if (Util.isNullOrNil(parame.Kvd.aaEr)) {
          break label240;
        }
        this.KGJ.setText(parame.Kvd.aaEr);
        this.KGJ.setVisibility(0);
      }
      for (;;)
      {
        if (this.KGQ != null) {
          this.KGQ.setText(parame.Kvd.aaEG);
        }
        this.KGF.setVisibility(8);
        AppMethodBeat.o(284207);
        return;
        label240:
        this.KGJ.setText("");
      }
    }
    
    public final void yh(boolean paramBoolean) {}
  }
  
  final class c
    extends LuckyMoneyPickEnvelopeUI.a
  {
    TextView KGU;
    TextView KGV;
    WeImageView KGW;
    ViewGroup KGX;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(284234);
      this.KGU = ((TextView)paramView.findViewById(a.f.lmpi_create_envelope_title));
      this.KGV = ((TextView)paramView.findViewById(a.f.lmpi_create_envelope_sub_title));
      this.KGW = ((WeImageView)paramView.findViewById(a.f.lmpi_create_envelope_title_arrow));
      this.KGX = ((ViewGroup)paramView.findViewById(a.f.lmpi_create_envelope_title_ll));
      AppMethodBeat.o(284234);
    }
    
    public final void a(final LuckyMoneyPickEnvelopeUI.e parame)
    {
      AppMethodBeat.i(284238);
      this.caK.setSelected(parame.wwJ);
      if (parame.Kvd != null)
      {
        this.KGU.setText(parame.Kvd.aaEA);
        this.KGV.setText(parame.Kvd.aaEB);
        aw.a(this.KGU.getPaint(), 0.8F);
        aw.a(this.KGV.getPaint(), 0.8F);
        this.KGX.setClickable(true);
        this.KGX.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(284530);
            if (paramAnonymousMotionEvent.getAction() == 0)
            {
              LuckyMoneyPickEnvelopeUI.c.this.KGW.setIconColor(LuckyMoneyPickEnvelopeUI.this.getContext().getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.UN_BW_0_Alpha_0_1));
              LuckyMoneyPickEnvelopeUI.c.this.KGU.setTextColor(LuckyMoneyPickEnvelopeUI.this.getContext().getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.UN_BW_0_Alpha_0_1));
            }
            for (;;)
            {
              AppMethodBeat.o(284530);
              return false;
              LuckyMoneyPickEnvelopeUI.c.this.KGW.setIconColor(LuckyMoneyPickEnvelopeUI.this.getContext().getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.lucky_money_goldstyle_detail_primary_text_color));
              LuckyMoneyPickEnvelopeUI.c.this.KGU.setTextColor(LuckyMoneyPickEnvelopeUI.this.getContext().getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.lucky_money_goldstyle_detail_primary_text_color));
              Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "on click ");
              i.y(parame.Kvd.aaEy, parame.Kvd.aaEz, 0, 1100);
            }
          }
        });
      }
      AppMethodBeat.o(284238);
    }
    
    public final void yh(boolean paramBoolean) {}
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
      AppMethodBeat.i(284256);
      LuckyMoneyPickEnvelopeUI.e locale = (LuckyMoneyPickEnvelopeUI.e)LuckyMoneyPickEnvelopeUI.b(LuckyMoneyPickEnvelopeUI.this).get(paramInt);
      if (locale.KGZ)
      {
        AppMethodBeat.o(284256);
        return 3;
      }
      if (locale.Kvd.nQJ == 3)
      {
        AppMethodBeat.o(284256);
        return 2;
      }
      if (locale.Kvd.nQJ == 4)
      {
        AppMethodBeat.o(284256);
        return 4;
      }
      AppMethodBeat.o(284256);
      return 1;
    }
  }
  
  static final class e
  {
    public boolean KGZ;
    public czi Kvd;
    public boolean wwJ = false;
  }
  
  final class g
    extends LuckyMoneyPickEnvelopeUI.a
  {
    Button AkB;
    ImageView KGE;
    View KGF;
    ImageView KGG;
    ProgressBar KGH;
    TextView KGI;
    TextView KGJ;
    TextView KGK;
    ViewGroup KGL;
    ProgressBar KGM;
    ImageView KHc;
    ImageView KHd;
    View KHe;
    TextView lDF;
    ImageView lKK;
    TextView nicknameTv;
    
    public g(View paramView)
    {
      super();
      AppMethodBeat.i(284230);
      this.KGL = ((ViewGroup)paramView.findViewById(a.f.lmpi_content_view));
      this.KGE = ((ImageView)paramView.findViewById(a.f.lmpi_envelope_iv));
      this.KHc = ((ImageView)paramView.findViewById(a.f.lmpi_envelope_top_cap_iv));
      this.KHd = ((ImageView)paramView.findViewById(a.f.lmpi_envelope_widget_iv));
      this.KHe = paramView.findViewById(a.f.lmpi_container);
      this.lDF = ((TextView)paramView.findViewById(a.f.lmpi_envelope_name_tv));
      this.lKK = ((ImageView)paramView.findViewById(a.f.lmpi_avatar_iv));
      this.nicknameTv = ((TextView)paramView.findViewById(a.f.lmpi_nickname_tv));
      this.KGF = paramView.findViewById(a.f.lmpi_white_cover_view);
      this.KGG = ((ImageView)paramView.findViewById(a.f.lmpi_loading_iv));
      this.KGH = ((ProgressBar)paramView.findViewById(a.f.lmpi_anim_pb));
      this.KGI = ((TextView)paramView.findViewById(a.f.lmpi_retry_tv));
      this.KGJ = ((TextView)paramView.findViewById(a.f.lmpi_envelope_leave_tv));
      this.KGK = ((TextView)paramView.findViewById(a.f.lmpi_temp_label_tv));
      this.AkB = ((Button)paramView.findViewById(a.f.lmpi_envelope_open_btn));
      String str = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
      if ((str == null) || (str.length() <= 0) || ((!str.equals("zh_CN")) && (!str.equals("zh_TW")) && (!str.equals("zh_HK"))))
      {
        this.AkB.setBackgroundResource(a.e.pick_envelope_btn_icon);
        this.AkB.setText(a.i.lucky_money_open_title);
      }
      this.KGM = ((ProgressBar)paramView.findViewById(a.f.lmpi_inline_cover_loading_pb));
      if (aw.isDarkMode()) {
        this.KGL.setBackgroundResource(a.e.lucky_money_pick_envelope_item_dark_bg);
      }
      for (;;)
      {
        this$1 = new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(284441);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$NormalVH$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
            LuckyMoneyPickEnvelopeUI.g.a(LuckyMoneyPickEnvelopeUI.g.this, paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$NormalVH$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(284441);
            return false;
          }
        };
        paramView.setOnLongClickListener(LuckyMoneyPickEnvelopeUI.this);
        this.KGF.setOnLongClickListener(LuckyMoneyPickEnvelopeUI.this);
        AppMethodBeat.o(284230);
        return;
        this.KGL.setBackgroundResource(a.e.lucky_money_pick_envelope_item_bg);
      }
    }
    
    private void a(final czi paramczi, boolean paramBoolean)
    {
      AppMethodBeat.i(284237);
      if (paramBoolean)
      {
        this.KGG.setVisibility(8);
        this.KGH.setVisibility(0);
        this.KGI.setVisibility(8);
        if ((this.KHd == null) || (paramczi.aaEq == null) || (Util.isNullOrNil(paramczi.aaEq.aaEP)) || (Util.isNullOrNil(paramczi.aaEq.aaEQ))) {
          break label203;
        }
        this.KHd.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(284458);
            float f = LuckyMoneyPickEnvelopeUI.g.this.KGE.getWidth() * 1.0993F;
            int i = Math.round(f);
            int j = Math.round(f * 1.72F);
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)LuckyMoneyPickEnvelopeUI.g.this.KHd.getLayoutParams();
            localLayoutParams.width = i;
            localLayoutParams.height = j;
            LuckyMoneyPickEnvelopeUI.g.this.KHd.setLayoutParams(localLayoutParams);
            AppMethodBeat.o(284458);
          }
        });
        this.KHd.setVisibility(0);
        ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.luckymoney.a.a.class)).b(this.KHd, paramczi, new com.tencent.mm.plugin.luckymoney.a.a.a()
        {
          public final void onComplete(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(284444);
            Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "load ok: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            Runnable local1 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(284554);
                if ((LuckyMoneyPickEnvelopeUI.g.6.this.KCZ.aaEs == 1) || (LuckyMoneyPickEnvelopeUI.g.6.this.KCZ.user_flag == 1))
                {
                  Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "envelope has expired do nothing");
                  AppMethodBeat.o(284554);
                  return;
                }
                AppMethodBeat.o(284554);
              }
            };
            if (MMHandlerThread.isMainThread())
            {
              local1.run();
              AppMethodBeat.o(284444);
              return;
            }
            LuckyMoneyPickEnvelopeUI.g.this.KGF.post(local1);
            AppMethodBeat.o(284444);
          }
        });
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.KGE, paramczi, new com.tencent.mm.plugin.luckymoney.a.a.a()
        {
          public final void onComplete(final boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(284449);
            Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "load ok: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            Runnable local1 = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(284270);
                LuckyMoneyPickEnvelopeUI.g.this.KGM.setVisibility(8);
                if ((LuckyMoneyPickEnvelopeUI.l(LuckyMoneyPickEnvelopeUI.this) != null) && (LuckyMoneyPickEnvelopeUI.l(LuckyMoneyPickEnvelopeUI.this).isShowing())) {
                  LuckyMoneyPickEnvelopeUI.l(LuckyMoneyPickEnvelopeUI.this).dismiss();
                }
                if ((LuckyMoneyPickEnvelopeUI.g.7.this.KCZ.aaEs == 1) || (LuckyMoneyPickEnvelopeUI.g.7.this.KCZ.user_flag == 1))
                {
                  Log.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "envelope has expired do nothing");
                  AppMethodBeat.o(284270);
                  return;
                }
                if (!paramAnonymousBoolean)
                {
                  LuckyMoneyPickEnvelopeUI.g.this.KGF.setVisibility(0);
                  LuckyMoneyPickEnvelopeUI.g.this.KGG.setVisibility(0);
                  LuckyMoneyPickEnvelopeUI.g.this.KGH.setVisibility(8);
                  LuckyMoneyPickEnvelopeUI.g.this.KGI.setVisibility(0);
                  AppMethodBeat.o(284270);
                  return;
                }
                LuckyMoneyPickEnvelopeUI.g.this.KGF.setVisibility(8);
                AppMethodBeat.o(284270);
              }
            };
            if (MMHandlerThread.isMainThread())
            {
              local1.run();
              AppMethodBeat.o(284449);
              return;
            }
            LuckyMoneyPickEnvelopeUI.g.this.KGF.post(local1);
            AppMethodBeat.o(284449);
          }
        });
        AppMethodBeat.o(284237);
        return;
        if ("0".equals(paramczi.ZoK))
        {
          Log.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "default envelope");
          AppMethodBeat.o(284237);
          return;
        }
        this.KGM.setVisibility(0);
        break;
        label203:
        if (this.KHd != null) {
          this.KHd.setVisibility(8);
        }
      }
    }
    
    private void fYQ()
    {
      AppMethodBeat.i(284233);
      this.KGF.setVisibility(0);
      this.KGG.setVisibility(8);
      this.KGH.setVisibility(8);
      this.KGI.setVisibility(8);
      this.KGF.setOnClickListener(null);
      AppMethodBeat.o(284233);
    }
    
    public final void a(final LuckyMoneyPickEnvelopeUI.e parame)
    {
      AppMethodBeat.i(284262);
      this.caK.setSelected(parame.wwJ);
      a.b.a(this.lKK, com.tencent.mm.model.z.bAM(), 0.06F, false);
      this.nicknameTv.setText(LuckyMoneyPickEnvelopeUI.this.getString(a.i.lucky_money_whose, new Object[] { p.d(LuckyMoneyPickEnvelopeUI.this.getContext(), com.tencent.mm.model.z.bAO(), com.tencent.mm.cd.a.br(LuckyMoneyPickEnvelopeUI.this.getContext(), com.tencent.mm.plugin.wxpay.a.d.SmallerTextSize)) }));
      this.KGE.setImageBitmap(null);
      this.KHd.setImageBitmap(null);
      this.KGF.setVisibility(8);
      if (parame.Kvd != null)
      {
        this.lDF.setText(parame.Kvd.aaEp);
        if (parame.Kvd.aaEq != null)
        {
          a(parame.Kvd, false);
          this.KHc.setImageResource(a.e.lucky_money_envelope_transparent_cap_widget);
          this.KGF.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(284434);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$NormalVH$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              LuckyMoneyPickEnvelopeUI.g.a(LuckyMoneyPickEnvelopeUI.g.this, parame.Kvd);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$NormalVH$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(284434);
            }
          });
          if (Util.isNullOrNil(parame.Kvd.aaEr)) {
            break label422;
          }
          this.KGJ.setText(parame.Kvd.aaEr);
          this.KGJ.setVisibility(0);
          label207:
          this.KGJ.setOnTouchListener(null);
          this.KGJ.setClickable(false);
          if (parame.Kvd.nQJ != 2) {
            break label435;
          }
          this.KGK.setVisibility(0);
          label242:
          if ((parame.Kvd.nQJ != 1) || (Util.isNullOrNil(parame.Kvd.aaEw))) {
            break label447;
          }
          this.KGJ.setVisibility(0);
          this.KGJ.setText(parame.Kvd.aaEw);
        }
        for (;;)
        {
          if (!LuckyMoneyPickEnvelopeUI.z(LuckyMoneyPickEnvelopeUI.this)) {
            break label724;
          }
          int j = com.tencent.mm.cd.a.fromDPToPix(LuckyMoneyPickEnvelopeUI.this.getContext(), 256);
          int i = com.tencent.mm.cd.a.fromDPToPix(LuckyMoneyPickEnvelopeUI.this.getContext(), 424);
          float f = j * 1.0993F;
          Math.round(f);
          j = Math.round(f * 1.72F);
          parame = (RelativeLayout.LayoutParams)this.KGL.getLayoutParams();
          parame.topMargin = ((j - i) / 2 - com.tencent.mm.cd.a.fromDPToPix(LuckyMoneyPickEnvelopeUI.this.getContext(), 12) + (int)(1.0F * com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext())));
          this.KGL.setLayoutParams(parame);
          AppMethodBeat.o(284262);
          return;
          this.KHc.setImageResource(a.e.lucky_money_envelope_transparent_cap);
          break;
          label422:
          this.KGJ.setText("");
          break label207;
          label435:
          this.KGK.setVisibility(8);
          break label242;
          label447:
          if (parame.Kvd.user_flag == 1)
          {
            this.caK.setSelected(false);
            this.KGL.setEnabled(false);
            this.KGJ.setVisibility(0);
            if (!Util.isNullOrNil(parame.Kvd.aaEv)) {
              this.KGJ.setText(parame.Kvd.aaEv);
            }
            fYQ();
          }
          else if (parame.Kvd.aaEs == 1)
          {
            this.caK.setSelected(false);
            this.KGL.setEnabled(false);
            if (!Util.isNullOrNil(parame.Kvd.aaEr))
            {
              this.KGJ.setText(parame.Kvd.aaEr);
              this.KGJ.setVisibility(0);
            }
            this.KGF.setVisibility(8);
            this.KGG.setVisibility(8);
            this.KGH.setVisibility(8);
            this.KGI.setVisibility(8);
            this.KGF.setOnClickListener(null);
          }
          else if (LuckyMoneyPickEnvelopeUI.e(LuckyMoneyPickEnvelopeUI.this, parame.Kvd.ZoK))
          {
            this.caK.setSelected(false);
            this.KGL.setEnabled(false);
            this.KGJ.setText(a.i.lucky_money_envelope_illegal_tips);
            this.KGJ.setVisibility(0);
            fYQ();
          }
          else
          {
            this.KGL.setEnabled(true);
            if (Util.isNullOrNil(this.KGJ.getText())) {
              this.KGJ.setVisibility(4);
            }
            this.KGF.setVisibility(8);
          }
        }
        label724:
        parame = (RelativeLayout.LayoutParams)this.KGL.getLayoutParams();
        parame.topMargin = com.tencent.mm.cd.a.fromDPToPix(LuckyMoneyPickEnvelopeUI.this.getContext(), 3);
        this.KGL.setLayoutParams(parame);
      }
      AppMethodBeat.o(284262);
    }
    
    public final void yh(boolean paramBoolean)
    {
      AppMethodBeat.i(284254);
      this.caK.setSelected(paramBoolean);
      AppMethodBeat.o(284254);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI
 * JD-Core Version:    0.7.0.1
 */