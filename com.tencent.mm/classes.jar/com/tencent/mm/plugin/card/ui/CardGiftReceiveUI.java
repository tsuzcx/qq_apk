package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.jg;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.card.d.a.a;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AcceptedCardItem;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AccepterItem;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.card.model.z;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cxe;
import com.tencent.mm.protocal.protobuf.rp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftReceiveUI
  extends MMActivity
  implements View.OnClickListener, com.tencent.mm.al.g
{
  private int gIu;
  private String gIv;
  private ImageView nAA;
  private TextView nAB;
  private LinearLayout nAC;
  private TextView nAD;
  private RelativeLayout nAE;
  private RelativeLayout nAF;
  private ImageView nAG;
  private ImageView nAH;
  private TextView nAI;
  private Button nAJ;
  private TextView nAK;
  private ListView nAL;
  private RelativeLayout nAM;
  private TextView nAN;
  private TextView nAO;
  private View nAP;
  private RelativeLayout nAQ;
  a.a nAR;
  private ScrollView nAd;
  private LinearLayout nAe;
  private ImageView nAf;
  private TextView nAg;
  private TextView nAh;
  private ImageView nAi;
  private ImageView nAj;
  private LinearLayout nAk;
  private RelativeLayout nAl;
  private RelativeLayout nAm;
  private TextView nAn;
  private ImageView nAo;
  private TextView nAp;
  private TextView nAq;
  private TextView nAr;
  private ImageView nAs;
  private ImageView nAt;
  private View nAu;
  private TextView nAv;
  private LinearLayout nAw;
  private ListView nAx;
  private RelativeLayout nAy;
  private LinearLayout nAz;
  private CardGiftInfo nzP;
  private ProgressBar nzS;
  private ap nzT;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public CardGiftReceiveUI()
  {
    AppMethodBeat.i(113355);
    this.tipDialog = null;
    this.nzT = new ap(Looper.getMainLooper());
    this.nAR = new a.a()
    {
      public final void QQ(String paramAnonymousString)
      {
        AppMethodBeat.i(192638);
        ad.e("MicroMsg.CardGiftReceiveUI", "CDN download pic failure! fieldId:".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(192638);
      }
      
      public final void cx(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(192637);
        if (CardGiftReceiveUI.a(CardGiftReceiveUI.this) == null)
        {
          ad.e("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress cardGiftInfo is null return!");
          AppMethodBeat.o(192637);
          return;
        }
        if ((!bt.isNullOrNil(paramAnonymousString)) && (!bt.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nrK)) && (paramAnonymousString.equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nrK)))
        {
          ad.i("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress fromUserContentVideoUrl return!");
          AppMethodBeat.o(192637);
          return;
        }
        CardGiftReceiveUI.g(CardGiftReceiveUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(192635);
            if (CardGiftReceiveUI.f(CardGiftReceiveUI.this).getVisibility() != 0) {
              CardGiftReceiveUI.f(CardGiftReceiveUI.this).setVisibility(0);
            }
            AppMethodBeat.o(192635);
          }
        });
        AppMethodBeat.o(192637);
      }
      
      public final void eE(final String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(192639);
        ad.i("MicroMsg.CardGiftReceiveUI", "CDN  download success! fieldId:".concat(String.valueOf(paramAnonymousString1)));
        if (CardGiftReceiveUI.a(CardGiftReceiveUI.this) == null)
        {
          ad.e("MicroMsg.CardGiftReceiveUI", "CDN  download cardGiftInfo is null return!");
          AppMethodBeat.o(192639);
          return;
        }
        if ((!bt.isNullOrNil(paramAnonymousString1)) && (!bt.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nrK)) && (paramAnonymousString1.equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nrK)))
        {
          ad.i("MicroMsg.CardGiftReceiveUI", "CDN  download fromUserContentVideoUrl! return");
          AppMethodBeat.o(192639);
          return;
        }
        CardGiftReceiveUI.g(CardGiftReceiveUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(192636);
            if (CardGiftReceiveUI.f(CardGiftReceiveUI.this).getVisibility() != 8) {
              CardGiftReceiveUI.f(CardGiftReceiveUI.this).setVisibility(8);
            }
            if ((!bt.isNullOrNil(paramAnonymousString1)) && (!bt.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nrL)) && (paramAnonymousString1.equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nrL))) {
              CardGiftReceiveUI.h(CardGiftReceiveUI.this).setVisibility(0);
            }
            Bitmap localBitmap;
            for (;;)
            {
              localBitmap = u.BA(paramAnonymousString2);
              if (localBitmap != null) {
                break;
              }
              CardGiftReceiveUI.i(CardGiftReceiveUI.this).setImageResource(2131690066);
              AppMethodBeat.o(192636);
              return;
              CardGiftReceiveUI.h(CardGiftReceiveUI.this).setVisibility(8);
            }
            CardGiftReceiveUI.i(CardGiftReceiveUI.this).setImageBitmap(localBitmap);
            AppMethodBeat.o(192636);
          }
        });
        AppMethodBeat.o(192639);
      }
    };
    AppMethodBeat.o(113355);
  }
  
  private void Q(LinkedList<CardGiftInfo.AcceptedCardItem> paramLinkedList)
  {
    AppMethodBeat.i(113365);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      CardGiftInfo.AcceptedCardItem localAcceptedCardItem = (CardGiftInfo.AcceptedCardItem)paramLinkedList.next();
      View localView = View.inflate(this, 2131493277, null);
      TextView localTextView1 = (TextView)localView.findViewById(2131306111);
      TextView localTextView2 = (TextView)localView.findViewById(2131306110);
      localTextView1.setText(localAcceptedCardItem.nsy);
      localTextView2.setText(localAcceptedCardItem.nsz + getContext().getString(2131756856));
      this.nAw.addView(localView);
    }
    AppMethodBeat.o(113365);
  }
  
  private static void a(ListView paramListView)
  {
    AppMethodBeat.i(113367);
    ListAdapter localListAdapter = paramListView.getAdapter();
    if (localListAdapter == null)
    {
      AppMethodBeat.o(113367);
      return;
    }
    int k = localListAdapter.getCount();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      localObject = localListAdapter.getView(i, null, paramListView);
      ((View)localObject).measure(0, 0);
      j += ((View)localObject).getMeasuredHeight();
      i += 1;
    }
    Object localObject = paramListView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (paramListView.getDividerHeight() * (localListAdapter.getCount() - 1) + j);
    paramListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(113367);
  }
  
  private int ag(int paramInt)
  {
    AppMethodBeat.i(113359);
    paramInt = com.tencent.mm.cd.a.fromDPToPix(getContext(), paramInt);
    AppMethodBeat.o(113359);
    return paramInt;
  }
  
  private void bJG()
  {
    AppMethodBeat.i(113358);
    if (this.nzP == null)
    {
      ad.e("MicroMsg.CardGiftReceiveUI", "doUpdate due to cardGiftInfo is null!");
      AppMethodBeat.o(113358);
      return;
    }
    ad.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descLayoutMode:%d", new Object[] { Integer.valueOf(this.nzP.nrZ) });
    if ((this.nzP.nrZ != 1) && (this.nzP.nrZ == 2))
    {
      bKV();
      bKU();
      bJV();
      bKX();
      if (bt.isNullOrNil(this.nzP.nss)) {
        break label227;
      }
      this.nAJ.setVisibility(0);
      this.nAJ.setText(this.nzP.nss);
      this.nAJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(192631);
          if (!bt.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nsx))
          {
            paramAnonymousView = new d.a(CardGiftReceiveUI.this.getContext());
            paramAnonymousView.aMg(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nsx);
            paramAnonymousView.aaC(2131755691);
            paramAnonymousView.aaB(2131755270);
            paramAnonymousView.a(true, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(192630);
                if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).nst == 1)
                {
                  if ("cardhomepage".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nsu))
                  {
                    paramAnonymous2DialogInterface = new jg();
                    paramAnonymous2DialogInterface.dnt.context = CardGiftReceiveUI.this.getContext();
                    com.tencent.mm.sdk.b.a.ESL.l(paramAnonymous2DialogInterface);
                    AppMethodBeat.o(192630);
                    return;
                  }
                  if ("cardhomepage/couponandgiftcard".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nsu))
                  {
                    if (((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FuC, Boolean.FALSE)).booleanValue())
                    {
                      paramAnonymous2DialogInterface = new Intent();
                      paramAnonymous2DialogInterface.putExtra("scene", 1);
                      com.tencent.mm.bs.d.b(CardGiftReceiveUI.this.getContext(), "card", ".ui.v3.CouponCardListUI", paramAnonymous2DialogInterface);
                      AppMethodBeat.o(192630);
                      return;
                    }
                    paramAnonymous2DialogInterface = new jg();
                    paramAnonymous2DialogInterface.dnt.context = CardGiftReceiveUI.this.getContext();
                    com.tencent.mm.sdk.b.a.ESL.l(paramAnonymous2DialogInterface);
                    AppMethodBeat.o(192630);
                  }
                }
                else if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).nst == 2)
                {
                  com.tencent.mm.plugin.card.d.b.O(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nse, CardGiftReceiveUI.a(CardGiftReceiveUI.this).nsv, CardGiftReceiveUI.a(CardGiftReceiveUI.this).nsw);
                }
                AppMethodBeat.o(192630);
              }
            });
            paramAnonymousView.fft().show();
            AppMethodBeat.o(192631);
            return;
          }
          if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).nst == 1)
          {
            if ("cardhomepage".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nsu))
            {
              paramAnonymousView = new jg();
              paramAnonymousView.dnt.context = CardGiftReceiveUI.this.getContext();
              com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
              AppMethodBeat.o(192631);
              return;
            }
            if ("cardhomepage/couponandgiftcard".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nsu))
            {
              if (((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FuC, Boolean.FALSE)).booleanValue())
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("scene", 1);
                com.tencent.mm.bs.d.b(CardGiftReceiveUI.this.getContext(), "card", ".ui.v3.CouponCardListUI", paramAnonymousView);
                AppMethodBeat.o(192631);
                return;
              }
              paramAnonymousView = new jg();
              paramAnonymousView.dnt.context = CardGiftReceiveUI.this.getContext();
              com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
              AppMethodBeat.o(192631);
            }
          }
          else if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).nst == 2)
          {
            com.tencent.mm.plugin.card.d.b.O(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nse, CardGiftReceiveUI.a(CardGiftReceiveUI.this).nsv, CardGiftReceiveUI.a(CardGiftReceiveUI.this).nsw);
          }
          AppMethodBeat.o(192631);
        }
      });
    }
    for (;;)
    {
      if ((bt.isNullOrNil(this.nzP.nsf)) && (bt.isNullOrNil(this.nzP.footerWording)) && (bt.isNullOrNil(this.nzP.nsp)) && (bt.isNullOrNil(this.nzP.nsq))) {
        break label239;
      }
      this.nAd.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(192632);
          int i = com.tencent.mm.cd.a.fromDPToPix(CardGiftReceiveUI.this.getContext(), 67);
          int j = CardGiftReceiveUI.b(CardGiftReceiveUI.this).getChildAt(0).getHeight() + i;
          int k = CardGiftReceiveUI.this.getWindow().findViewById(16908290).getHeight();
          ad.i("MicroMsg.CardGiftReceiveUI", "bottomHeight: %d  totalViewHeight:%d  screenHeight:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
          CardGiftReceiveUI.b(CardGiftReceiveUI.this).setFillViewport(true);
          if (j > k) {
            CardGiftReceiveUI.a(CardGiftReceiveUI.this, true);
          }
          for (;;)
          {
            CardGiftReceiveUI.b(CardGiftReceiveUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            AppMethodBeat.o(192632);
            return;
            CardGiftReceiveUI.a(CardGiftReceiveUI.this, false);
          }
        }
      });
      AppMethodBeat.o(113358);
      return;
      bKW();
      break;
      label227:
      this.nAJ.setVisibility(8);
    }
    label239:
    this.nAd.setFillViewport(true);
    AppMethodBeat.o(113358);
  }
  
  private void bJV()
  {
    int i = 0;
    AppMethodBeat.i(113364);
    if (this.nzP.nsj.size() > 0)
    {
      this.nAu.setVisibility(0);
      this.nAx.setVisibility(8);
      if (this.nzP.nsj.size() <= 2)
      {
        this.nAv.setVisibility(8);
        Q(this.nzP.nsj);
        AppMethodBeat.o(113364);
        return;
      }
      Object localObject = new LinkedList();
      ((LinkedList)localObject).add(this.nzP.nsj.get(0));
      ((LinkedList)localObject).add(this.nzP.nsj.get(1));
      Q((LinkedList)localObject);
      this.nAv.setVisibility(0);
      this.nAv.setOnClickListener(this);
      localObject = new LinkedList();
      while (i < this.nzP.nsj.size())
      {
        if ((i != 0) && (i != 1)) {
          ((LinkedList)localObject).add(this.nzP.nsj.get(i));
        }
        i += 1;
      }
      localObject = new c((LinkedList)localObject);
      this.nAx.setAdapter((ListAdapter)localObject);
      a(this.nAx);
      AppMethodBeat.o(113364);
      return;
    }
    this.nAu.setVisibility(8);
    this.nAv.setVisibility(8);
    this.nAx.setVisibility(8);
    AppMethodBeat.o(113364);
  }
  
  private void bKU()
  {
    AppMethodBeat.i(113360);
    if (this.nzP.nsm == 1)
    {
      this.nAz.setVisibility(0);
      this.nAC.setVisibility(8);
      this.nAy.setVisibility(8);
      this.nAB.setText(k.b(this, this.nzP.dvQ, this.nAB.getTextSize()));
      e(this.nAA);
      AppMethodBeat.o(113360);
      return;
    }
    this.nAz.setVisibility(8);
    this.nAC.setVisibility(0);
    this.nAy.setVisibility(0);
    e(this.nAH);
    this.nAI.setText(k.b(this, this.nzP.dvQ, this.nAI.getTextSize()));
    if (((!bt.isNullOrNil(this.nzP.nrJ)) && (!"undefined".equals(this.nzP.nrJ))) || ((!bt.isNullOrNil(this.nzP.nrK)) && (!"undefined".equals(this.nzP.nrK)))) {
      this.nAE.setVisibility(0);
    }
    for (;;)
    {
      bKY();
      if (!bt.isNullOrNil(this.nzP.nrI)) {
        this.nAD.setText(k.b(this, this.nzP.nrI, this.nAD.getTextSize()));
      }
      AppMethodBeat.o(113360);
      return;
      this.nAE.setVisibility(8);
      ad.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is empty");
    }
  }
  
  private void bKV()
  {
    AppMethodBeat.i(113362);
    this.nAk.setVisibility(8);
    this.nAe.setVisibility(0);
    this.nAg.setText(this.nzP.nrX);
    this.nAh.setText(this.nzP.nrR + "     " + this.nzP.nrS + getContext().getString(2131756856));
    Object localObject;
    if (!bt.isNullOrNil(this.nzP.nrY))
    {
      this.nAf.setVisibility(0);
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aih();
      o.ayK();
      ((c.a)localObject).hkl = null;
      ((c.a)localObject).gjt = m.Qy(this.nzP.nrY);
      ((c.a)localObject).hjU = true;
      ((c.a)localObject).hjS = true;
      localObject = ((c.a)localObject).azc();
      o.ayJ().a(this.nzP.nrY, this.nAf, (c)localObject);
      if (bt.isNullOrNil(this.nzP.nsb)) {
        break label506;
      }
      this.nAg.setTextColor(bt.cB(this.nzP.nsb, getResources().getColor(2131100711)));
      label224:
      if (bt.isNullOrNil(this.nzP.nsc)) {
        break label518;
      }
      this.nAh.setTextColor(bt.cB(this.nzP.nsc, getResources().getColor(2131100711)));
      label264:
      if (bt.isNullOrNil(this.nzP.nrQ)) {
        break label530;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aih();
      o.ayK();
      ((c.a)localObject).hkl = null;
      ((c.a)localObject).gjt = m.Qy(this.nzP.nrQ);
      ((c.a)localObject).gkG = true;
      ((c.a)localObject).hjU = true;
      ((c.a)localObject).hjS = true;
      ((c.a)localObject).gjy = new ColorDrawable(l.Rm("#CCCCCC"));
      localObject = ((c.a)localObject).azc();
      o.ayJ().a(this.nzP.nrQ, this.nAj, (c)localObject);
    }
    for (;;)
    {
      if (bt.isNullOrNil(this.nzP.nrP)) {
        break label542;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aih();
      o.ayK();
      ((c.a)localObject).hkl = null;
      ((c.a)localObject).gjt = m.Qy(this.nzP.nrP);
      ((c.a)localObject).hjU = true;
      ((c.a)localObject).hjS = true;
      ((c.a)localObject).gjy = new ColorDrawable(l.Rm("#CCCCCC"));
      ((c.a)localObject).gkG = true;
      ((c.a)localObject).hkm = com.tencent.mm.cd.a.fromDPToPix(this, 8);
      localObject = ((c.a)localObject).azc();
      o.ayJ().a(this.nzP.nrP, this.nAi, (c)localObject);
      AppMethodBeat.o(113362);
      return;
      this.nAf.setVisibility(8);
      break;
      label506:
      ad.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
      break label224;
      label518:
      ad.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
      break label264;
      label530:
      ad.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
    }
    label542:
    ad.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
    AppMethodBeat.o(113362);
  }
  
  private void bKW()
  {
    AppMethodBeat.i(113363);
    this.nAe.setVisibility(8);
    this.nAk.setVisibility(0);
    this.nAp.setText(this.nzP.nrR);
    Object localObject;
    if (this.nzP.nsm == 1)
    {
      this.nAs.setAlpha(0.5F);
      this.nAq.setVisibility(8);
      this.nAr.setVisibility(8);
      this.nAm.setVisibility(8);
      this.nAl.setVisibility(8);
      if (bt.isNullOrNil(this.nzP.nrY)) {
        break label672;
      }
      this.nAo.setVisibility(0);
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aih();
      o.ayK();
      ((c.a)localObject).hkl = null;
      ((c.a)localObject).gjt = m.Qy(this.nzP.nrY);
      ((c.a)localObject).hjU = true;
      ((c.a)localObject).hjS = true;
      localObject = ((c.a)localObject).azc();
      o.ayJ().a(this.nzP.nrY, this.nAo, (c)localObject);
      label186:
      if (bt.isNullOrNil(this.nzP.nrX)) {
        break label705;
      }
      this.nAn.setVisibility(0);
      this.nAn.setText(this.nzP.nrX);
      if (bt.isNullOrNil(this.nzP.nsb)) {
        break label693;
      }
      this.nAn.setTextColor(bt.cB(this.nzP.nsb, getResources().getColor(2131100711)));
      label261:
      if (bt.isNullOrNil(this.nzP.nsc)) {
        break label726;
      }
      this.nAp.setTextColor(bt.cB(this.nzP.nsc, getResources().getColor(2131100711)));
      label301:
      if (bt.isNullOrNil(this.nzP.nrQ)) {
        break label738;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aih();
      o.ayK();
      ((c.a)localObject).hkl = null;
      ((c.a)localObject).gjt = m.Qy(this.nzP.nrQ);
      ((c.a)localObject).gkG = true;
      ((c.a)localObject).hjU = true;
      ((c.a)localObject).hjS = true;
      ((c.a)localObject).gjy = new ColorDrawable(l.Rm("#CCCCCC"));
      localObject = ((c.a)localObject).azc();
      o.ayJ().a(this.nzP.nrQ, this.nAt, (c)localObject);
    }
    for (;;)
    {
      if (bt.isNullOrNil(this.nzP.nrP)) {
        break label750;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aih();
      o.ayK();
      ((c.a)localObject).hkl = null;
      ((c.a)localObject).gjt = m.Qy(this.nzP.nrP);
      ((c.a)localObject).hjU = true;
      ((c.a)localObject).hjS = true;
      ((c.a)localObject).gjy = new ColorDrawable(l.Rm("#CCCCCC"));
      ((c.a)localObject).gkG = true;
      ((c.a)localObject).hkm = com.tencent.mm.cd.a.fromDPToPix(this, 8);
      localObject = ((c.a)localObject).azc();
      o.ayJ().a(this.nzP.nrP, this.nAs, (c)localObject);
      AppMethodBeat.o(113363);
      return;
      this.nAq.setVisibility(0);
      this.nAr.setVisibility(0);
      this.nAm.setVisibility(0);
      this.nAl.setVisibility(0);
      this.nAq.setText(this.nzP.nrS);
      this.nAr.setText(2131756856);
      if (bt.isNullOrNil(this.nzP.nrS))
      {
        this.nAq.setVisibility(8);
        this.nAr.setVisibility(8);
      }
      if (!bt.isNullOrNil(this.nzP.nsd))
      {
        this.nAq.setTextColor(bt.cB(this.nzP.nsd, getResources().getColor(2131100711)));
        break;
      }
      ad.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardPriceTitleColor is empty");
      break;
      label672:
      this.nAo.setVisibility(8);
      ad.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
      break label186;
      label693:
      ad.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
      break label261;
      label705:
      this.nAn.setVisibility(8);
      ad.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
      break label261;
      label726:
      ad.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
      break label301;
      label738:
      ad.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
    }
    label750:
    ad.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
    AppMethodBeat.o(113363);
  }
  
  private void bKX()
  {
    AppMethodBeat.i(113366);
    if (this.nzP.nsk.size() > 0)
    {
      this.nAM.setVisibility(0);
      this.nAL.setVisibility(0);
      a locala = new a();
      this.nAL.setAdapter(locala);
      a(this.nAL);
      if (!bt.isNullOrNil(this.nzP.nsl))
      {
        this.nAK.setVisibility(0);
        this.nAK.setText(this.nzP.nsl);
      }
      AppMethodBeat.o(113366);
      return;
    }
    if (!bt.isNullOrNil(this.nzP.nsl))
    {
      this.nAM.setVisibility(0);
      this.nAK.setVisibility(0);
      this.nAK.setText(this.nzP.nsl);
      this.nAL.setVisibility(8);
      AppMethodBeat.o(113366);
      return;
    }
    this.nAM.setVisibility(8);
    this.nAK.setVisibility(8);
    this.nAL.setVisibility(8);
    AppMethodBeat.o(113366);
  }
  
  private void bKY()
  {
    AppMethodBeat.i(113370);
    if ((this.nzP != null) && (!bt.isNullOrNil(this.nzP.nrJ))) {
      com.tencent.mm.plugin.card.d.a.g(this.nzP.nrJ, this.nzP.nrM, this.nzP.nrU, 2);
    }
    while ((this.nzP != null) && (!bt.isNullOrNil(this.nzP.nrL)))
    {
      com.tencent.mm.plugin.card.d.a.g(this.nzP.nrL, this.nzP.nrO, this.nzP.nrW, 2);
      AppMethodBeat.o(113370);
      return;
      ad.e("MicroMsg.CardGiftReceiveUI", "fromUserContentPicUrl is null");
    }
    ad.e("MicroMsg.CardGiftReceiveUI", "fromUserContentThumbPicUrl is null");
    AppMethodBeat.o(113370);
  }
  
  private void e(ImageView paramImageView)
  {
    AppMethodBeat.i(113361);
    if (!bt.isNullOrNil(this.nzP.nrH))
    {
      int i = com.tencent.mm.cd.a.fromDPToPix(this, 20);
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aih();
      o.ayK();
      ((c.a)localObject).hkl = null;
      ((c.a)localObject).gjt = m.Qy(this.nzP.nrH);
      ((c.a)localObject).hjU = true;
      ((c.a)localObject).gkG = true;
      ((c.a)localObject).hkm = 3.0F;
      ((c.a)localObject).hjS = true;
      ((c.a)localObject).gjw = i;
      ((c.a)localObject).gjv = i;
      ((c.a)localObject).gjy = new ColorDrawable(l.Rm("#CCCCCC"));
      localObject = ((c.a)localObject).azc();
      o.ayJ().a(this.nzP.nrH, paramImageView, (c)localObject);
      AppMethodBeat.o(113361);
      return;
    }
    ad.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is null");
    AppMethodBeat.o(113361);
  }
  
  public int getLayoutId()
  {
    return 2131493282;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113368);
    this.nAd = ((ScrollView)findViewById(2131297811));
    this.nAe = ((LinearLayout)findViewById(2131297913));
    this.nAf = ((ImageView)findViewById(2131301223));
    this.nAg = ((TextView)findViewById(2131306153));
    this.nAh = ((TextView)findViewById(2131306152));
    this.nAi = ((ImageView)findViewById(2131301221));
    this.nAj = ((ImageView)findViewById(2131301222));
    this.nAi.setOnClickListener(this);
    this.nAk = ((LinearLayout)findViewById(2131297912));
    this.nAl = ((RelativeLayout)findViewById(2131297206));
    this.nAm = ((RelativeLayout)findViewById(2131297209));
    this.nAn = ((TextView)findViewById(2131306118));
    this.nAp = ((TextView)findViewById(2131306149));
    this.nAo = ((ImageView)findViewById(2131301219));
    this.nAq = ((TextView)findViewById(2131306158));
    this.nAr = ((TextView)findViewById(2131306159));
    this.nAs = ((ImageView)findViewById(2131301210));
    this.nAt = ((ImageView)findViewById(2131301211));
    this.nAs.setOnClickListener(this);
    this.nAu = findViewById(2131297853);
    this.nAv = ((TextView)findViewById(2131306154));
    this.nAw = ((LinearLayout)findViewById(2131297852));
    this.nAx = ((ListView)findViewById(2131297854));
    this.nAy = ((RelativeLayout)findViewById(2131297800));
    this.nAz = ((LinearLayout)findViewById(2131300593));
    this.nAA = ((ImageView)findViewById(2131301213));
    this.nAB = ((TextView)findViewById(2131306131));
    this.nAC = ((LinearLayout)findViewById(2131300592));
    this.nAH = ((ImageView)findViewById(2131301212));
    this.nAI = ((TextView)findViewById(2131306130));
    this.nAD = ((TextView)findViewById(2131306129));
    this.nAE = ((RelativeLayout)findViewById(2131297829));
    this.nAF = ((RelativeLayout)findViewById(2131300993));
    this.nAG = ((ImageView)findViewById(2131306134));
    this.nAE.setOnClickListener(this);
    this.nAF.setOnClickListener(this);
    this.nAK = ((TextView)findViewById(2131306104));
    this.nAL = ((ListView)findViewById(2131296324));
    this.nAM = ((RelativeLayout)findViewById(2131297798));
    this.nAJ = ((Button)findViewById(2131297839));
    this.nzS = ((ProgressBar)findViewById(2131300950));
    com.tencent.mm.plugin.card.d.n.d(this);
    setMMTitle("");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(192633);
        CardGiftReceiveUI.this.finish();
        AppMethodBeat.o(192633);
        return true;
      }
    });
    AppMethodBeat.o(113368);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(113371);
    if (paramView.getId() == 2131300993)
    {
      if (!bt.isNullOrNil(this.nzP.nrK))
      {
        paramView = new Intent(this, CardGiftVideoUI.class);
        paramView.putExtra("key_gift_into", this.nzP);
        paramView.putExtra("key_is_mute", false);
        paramView = new com.tencent.mm.hellhoundlib.b.a().bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramView.adn(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramView.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        overridePendingTransition(0, 0);
        com.tencent.mm.plugin.report.service.h.vKh.f(13866, new Object[] { Integer.valueOf(3), this.gIv, com.tencent.mm.b.p.getString(this.gIu) });
        AppMethodBeat.o(113371);
      }
    }
    else if (paramView.getId() == 2131297829)
    {
      if (this.nzS.getVisibility() == 0)
      {
        AppMethodBeat.o(113371);
        return;
      }
      if (!bt.isNullOrNil(this.nzP.nrJ))
      {
        paramView = new Intent(this, CardGiftImageUI.class);
        paramView.putExtra("key_gift_into", this.nzP);
        paramView = new com.tencent.mm.hellhoundlib.b.a().bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramView.adn(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramView.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        overridePendingTransition(0, 0);
        com.tencent.mm.plugin.report.service.h.vKh.f(13866, new Object[] { Integer.valueOf(4), this.gIv, com.tencent.mm.b.p.getString(this.gIu) });
        AppMethodBeat.o(113371);
      }
    }
    else if (paramView.getId() == 2131306127)
    {
      if ((this.nzP != null) && (this.nzP.nrT))
      {
        com.tencent.mm.plugin.report.service.h.vKh.f(13866, new Object[] { Integer.valueOf(7), this.gIv, com.tencent.mm.b.p.getString(this.gIu) });
        if ("cardhomepage/couponandgiftcard".equals(this.nzP.nsr)) {
          if (((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FuC, Boolean.FALSE)).booleanValue())
          {
            paramView = new Intent();
            paramView.putExtra("scene", 1);
            com.tencent.mm.bs.d.b(getContext(), "card", ".ui.v3.CouponCardListUI", paramView);
          }
        }
        for (;;)
        {
          finish();
          overridePendingTransition(0, 0);
          AppMethodBeat.o(113371);
          return;
          paramView = new jg();
          paramView.dnt.context = getContext();
          com.tencent.mm.sdk.b.a.ESL.l(paramView);
          continue;
          paramView = new jg();
          paramView.dnt.context = getContext();
          paramView.dnt.scene = 2;
          com.tencent.mm.sdk.b.a.ESL.l(paramView);
          ad.i("MicroMsg.CardGiftReceiveUI", "enter to cardhome");
        }
      }
    }
    else if (paramView.getId() == 2131306128)
    {
      if ((!TextUtils.isEmpty(this.nzP.nsn)) && (!TextUtils.isEmpty(this.nzP.nso)))
      {
        int i = getIntent().getIntExtra("key_from_appbrand_type", 0);
        com.tencent.mm.plugin.card.d.b.d(this.nzP.nse, this.nzP.nsn, this.nzP.nso, 1062, i);
        com.tencent.mm.plugin.report.service.h.vKh.f(13866, new Object[] { Integer.valueOf(8), this.gIv, com.tencent.mm.b.p.getString(this.gIu) });
        AppMethodBeat.o(113371);
        return;
      }
      if (!bt.isNullOrNil(this.nzP.nsg))
      {
        com.tencent.mm.plugin.card.d.b.a(this, this.nzP.nsg, 0);
        com.tencent.mm.plugin.report.service.h.vKh.f(13866, new Object[] { Integer.valueOf(8), this.gIv, com.tencent.mm.b.p.getString(this.gIu) });
        AppMethodBeat.o(113371);
      }
    }
    else
    {
      if ((paramView.getId() == 2131301210) || (paramView.getId() == 2131301221))
      {
        if ((!bt.isNullOrNil(this.nzP.nsh)) && (!bt.isNullOrNil(this.nzP.nsi)))
        {
          paramView = new LinkedList();
          Object localObject = new rp();
          ((rp)localObject).nrr = this.nzP.nsh;
          ((rp)localObject).code = this.nzP.nsi;
          paramView.add(localObject);
          localObject = getIntent().getStringExtra("key_template_id");
          cxe localcxe = new cxe();
          localcxe.Epn = ((String)localObject);
          ad.i("MicroMsg.CardGiftReceiveUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { localObject });
          paramView = new t(paramView, localcxe, 27);
          com.tencent.mm.kernel.g.afA().gcy.a(paramView, 0);
          com.tencent.mm.plugin.report.service.h.vKh.f(13866, new Object[] { Integer.valueOf(9), this.gIv, com.tencent.mm.b.p.getString(this.gIu) });
          AppMethodBeat.o(113371);
          return;
        }
        ad.e("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.userCardId is null");
        AppMethodBeat.o(113371);
        return;
      }
      if (paramView.getId() == 2131306154)
      {
        if (this.nAx.getVisibility() == 0)
        {
          this.nAx.setVisibility(8);
          this.nAv.setText("查看全部");
          AppMethodBeat.o(113371);
          return;
        }
        this.nAx.setVisibility(0);
        this.nAv.setText("收起");
      }
    }
    AppMethodBeat.o(113371);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113356);
    super.onCreate(paramBundle);
    this.gIv = getIntent().getStringExtra("key_order_id");
    this.gIu = getIntent().getIntExtra("key_biz_uin", -1);
    this.nzP = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    ad.i("MicroMsg.CardGiftReceiveUI", "onCreate, orderId:%s, bizUin:%s", new Object[] { this.gIv, Integer.valueOf(this.gIu) });
    initView();
    com.tencent.mm.kernel.g.afA().gcy.a(1165, this);
    com.tencent.mm.kernel.g.afA().gcy.a(1099, this);
    com.tencent.mm.plugin.card.d.a.a(this.nAR);
    if (this.nzP == null)
    {
      ad.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo is null, sync GiftCard from serve");
      if (this.gIu == -1)
      {
        ad.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, bizUin is -1, fail!");
        AppMethodBeat.o(113356);
        return;
      }
      if (this.gIv == null) {
        ad.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, orderId is null, fail");
      }
      ad.e("MicroMsg.CardGiftReceiveUI", "doNetSceneGetCardGiftInfo");
      paramBundle = new z(this.gIu, this.gIv);
      com.tencent.mm.kernel.g.afA().gcy.a(paramBundle, 0);
      this.tipDialog = com.tencent.mm.ui.base.h.b(getContext(), getString(2131760709), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(192634);
          if ((CardGiftReceiveUI.c(CardGiftReceiveUI.this) != null) && (CardGiftReceiveUI.c(CardGiftReceiveUI.this).isShowing())) {
            CardGiftReceiveUI.c(CardGiftReceiveUI.this).dismiss();
          }
          if ((CardGiftReceiveUI.d(CardGiftReceiveUI.this).getVisibility() == 8) || (CardGiftReceiveUI.e(CardGiftReceiveUI.this).getVisibility() == 4))
          {
            ad.i("MicroMsg.CardGiftReceiveUI", "user cancel & finish");
            CardGiftReceiveUI.this.finish();
          }
          AppMethodBeat.o(192634);
        }
      });
      if (this.tipDialog != null) {
        this.tipDialog.show();
      }
      AppMethodBeat.o(113356);
      return;
    }
    bJG();
    AppMethodBeat.o(113356);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113357);
    super.onDestroy();
    com.tencent.mm.kernel.g.afA().gcy.b(1165, this);
    com.tencent.mm.kernel.g.afA().gcy.b(1099, this);
    com.tencent.mm.plugin.card.d.a.b(this.nAR);
    AppMethodBeat.o(113357);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(113369);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof z))
      {
        ad.i("MicroMsg.CardGiftReceiveUI", "card gift info cgi success!");
        this.nzP = ((z)paramn).ntz;
        bJG();
        AppMethodBeat.o(113369);
        return;
      }
      if ((paramn instanceof t))
      {
        paramString = new Intent(this, CardDetailUI.class);
        Object localObject = ((t)paramn).ntC;
        if ((localObject == null) || (((LinkedList)localObject).size() == 0))
        {
          ad.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardinfo list  size is null or empty!");
          AppMethodBeat.o(113369);
          return;
        }
        paramn = (com.tencent.mm.plugin.card.base.b)((LinkedList)localObject).get(0);
        if ((paramn == null) || (!(paramn instanceof CardInfo)))
        {
          ad.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardInfo  is null!");
          AppMethodBeat.o(113369);
          return;
        }
        ArrayList localArrayList = new ArrayList();
        localObject = ((LinkedList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList.add((CardInfo)((Iterator)localObject).next());
        }
        paramString.putExtra("key_card_info", (CardInfo)paramn);
        paramString.putExtra("key_previous_scene", 27);
        paramString.putExtra("key_from_scene", 27);
        paramString.putExtra("key_from_appbrand_type", paramString.getIntExtra("key_from_appbrand_type", 0));
        paramString.putExtra("key_card_git_info", this.nzP);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(113369);
      }
    }
    else
    {
      if ((paramn instanceof z))
      {
        ad.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        com.tencent.mm.plugin.card.d.d.a(this, paramString, true);
        AppMethodBeat.o(113369);
        return;
      }
      if ((paramn instanceof t))
      {
        ad.e("MicroMsg.CardGiftReceiveUI", ", NetSceneBatchGetCardItemByTpInfo onSceneEnd fail return!  errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        AppMethodBeat.o(113369);
        return;
      }
    }
    AppMethodBeat.o(113369);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(113348);
      int i = CardGiftReceiveUI.a(CardGiftReceiveUI.this).nsk.size();
      AppMethodBeat.o(113348);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(113349);
      CardGiftInfo.AccepterItem localAccepterItem = (CardGiftInfo.AccepterItem)CardGiftReceiveUI.a(CardGiftReceiveUI.this).nsk.get(paramInt);
      ImageView localImageView;
      String str;
      if (paramView == null)
      {
        paramView = View.inflate(CardGiftReceiveUI.this, 2131493278, null);
        paramViewGroup = new CardGiftReceiveUI.b(CardGiftReceiveUI.this);
        paramViewGroup.nAV = ((ImageView)paramView.findViewById(2131300983));
        paramViewGroup.mWl = ((TextView)paramView.findViewById(2131306105));
        paramViewGroup.fQp = ((TextView)paramView.findViewById(2131306107));
        paramViewGroup.nAW = ((TextView)paramView.findViewById(2131306106));
        paramView.setTag(paramViewGroup);
        if (localAccepterItem != null) {
          if (localAccepterItem.nsB != null)
          {
            localImageView = paramViewGroup.nAV;
            str = localAccepterItem.nsB;
            if ((localImageView != null) && (!TextUtils.isEmpty(str))) {
              break label229;
            }
          }
        }
      }
      for (;;)
      {
        paramViewGroup.mWl.setText(localAccepterItem.nsA);
        paramViewGroup.fQp.setText(localAccepterItem.nsy);
        paramViewGroup.nAW.setText(localAccepterItem.nsz + CardGiftReceiveUI.this.getContext().getString(2131756856));
        AppMethodBeat.o(113349);
        return paramView;
        paramViewGroup = (CardGiftReceiveUI.b)paramView.getTag();
        break;
        label229:
        if (!TextUtils.isEmpty(str))
        {
          Object localObject = new c.a();
          ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aih();
          o.ayK();
          ((c.a)localObject).hkl = null;
          ((c.a)localObject).gjt = m.Qy(str);
          ((c.a)localObject).hjU = true;
          ((c.a)localObject).gkG = true;
          ((c.a)localObject).hkm = 3.0F;
          ((c.a)localObject).hjS = true;
          ((c.a)localObject).gjw = 34;
          ((c.a)localObject).gjv = 34;
          ((c.a)localObject).hkf = 2131233400;
          localObject = ((c.a)localObject).azc();
          o.ayJ().a(str, localImageView, (c)localObject);
        }
        else
        {
          localImageView.setImageResource(2131233400);
        }
      }
    }
  }
  
  final class b
  {
    public TextView fQp;
    public TextView mWl;
    public ImageView nAV;
    public TextView nAW;
    
    b() {}
  }
  
  final class c
    extends BaseAdapter
  {
    private LinkedList<CardGiftInfo.AcceptedCardItem> nAX;
    
    c()
    {
      Object localObject;
      this.nAX = localObject;
    }
    
    private CardGiftInfo.AcceptedCardItem zd(int paramInt)
    {
      AppMethodBeat.i(113352);
      CardGiftInfo.AcceptedCardItem localAcceptedCardItem = (CardGiftInfo.AcceptedCardItem)this.nAX.get(paramInt);
      AppMethodBeat.o(113352);
      return localAcceptedCardItem;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(113351);
      int i = this.nAX.size();
      AppMethodBeat.o(113351);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(113353);
      CardGiftInfo.AcceptedCardItem localAcceptedCardItem = zd(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = View.inflate(CardGiftReceiveUI.this, 2131493277, null);
        paramView = new CardGiftReceiveUI.d(CardGiftReceiveUI.this);
        paramView.fQp = ((TextView)localView.findViewById(2131306111));
        paramView.nAW = ((TextView)localView.findViewById(2131306110));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        paramViewGroup.fQp.setText(localAcceptedCardItem.nsy);
        paramViewGroup.nAW.setText(localAcceptedCardItem.nsz + CardGiftReceiveUI.this.getContext().getString(2131756856));
        AppMethodBeat.o(113353);
        return localView;
        paramViewGroup = (CardGiftReceiveUI.d)paramView.getTag();
        localView = paramView;
      }
    }
  }
  
  final class d
  {
    public TextView fQp;
    public TextView nAW;
    
    d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftReceiveUI
 * JD-Core Version:    0.7.0.1
 */