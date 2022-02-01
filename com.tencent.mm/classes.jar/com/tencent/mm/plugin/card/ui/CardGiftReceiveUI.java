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
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.card.d.a.a;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AcceptedCardItem;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AccepterItem;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.model.z;
import com.tencent.mm.protocal.protobuf.eck;
import com.tencent.mm.protocal.protobuf.va;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftReceiveUI
  extends MMActivity
  implements View.OnClickListener, i
{
  private int ixX;
  private String ixY;
  private ProgressBar qaB;
  private MMHandler qaC;
  private ScrollView qaM;
  private LinearLayout qaN;
  private ImageView qaO;
  private TextView qaP;
  private TextView qaQ;
  private ImageView qaR;
  private ImageView qaS;
  private LinearLayout qaT;
  private RelativeLayout qaU;
  private RelativeLayout qaV;
  private TextView qaW;
  private ImageView qaX;
  private TextView qaY;
  private TextView qaZ;
  private CardGiftInfo qay;
  a.a qbA;
  private TextView qba;
  private ImageView qbb;
  private ImageView qbc;
  private View qbd;
  private TextView qbe;
  private LinearLayout qbf;
  private ListView qbg;
  private RelativeLayout qbh;
  private LinearLayout qbi;
  private ImageView qbj;
  private TextView qbk;
  private LinearLayout qbl;
  private TextView qbm;
  private RelativeLayout qbn;
  private RelativeLayout qbo;
  private ImageView qbp;
  private ImageView qbq;
  private TextView qbr;
  private Button qbs;
  private TextView qbt;
  private ListView qbu;
  private RelativeLayout qbv;
  private TextView qbw;
  private TextView qbx;
  private View qby;
  private RelativeLayout qbz;
  private com.tencent.mm.ui.base.q tipDialog;
  
  public CardGiftReceiveUI()
  {
    AppMethodBeat.i(113355);
    this.tipDialog = null;
    this.qaC = new MMHandler(Looper.getMainLooper());
    this.qbA = new a.a()
    {
      public final void ajH(String paramAnonymousString)
      {
        AppMethodBeat.i(201316);
        Log.e("MicroMsg.CardGiftReceiveUI", "CDN download pic failure! fieldId:".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(201316);
      }
      
      public final void cP(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(201315);
        if (CardGiftReceiveUI.a(CardGiftReceiveUI.this) == null)
        {
          Log.e("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress cardGiftInfo is null return!");
          AppMethodBeat.o(201315);
          return;
        }
        if ((!Util.isNullOrNil(paramAnonymousString)) && (!Util.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).pSq)) && (paramAnonymousString.equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).pSq)))
        {
          Log.i("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress fromUserContentVideoUrl return!");
          AppMethodBeat.o(201315);
          return;
        }
        CardGiftReceiveUI.g(CardGiftReceiveUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(201313);
            if (CardGiftReceiveUI.f(CardGiftReceiveUI.this).getVisibility() != 0) {
              CardGiftReceiveUI.f(CardGiftReceiveUI.this).setVisibility(0);
            }
            AppMethodBeat.o(201313);
          }
        });
        AppMethodBeat.o(201315);
      }
      
      public final void fw(final String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(201317);
        Log.i("MicroMsg.CardGiftReceiveUI", "CDN  download success! fieldId:".concat(String.valueOf(paramAnonymousString1)));
        if (CardGiftReceiveUI.a(CardGiftReceiveUI.this) == null)
        {
          Log.e("MicroMsg.CardGiftReceiveUI", "CDN  download cardGiftInfo is null return!");
          AppMethodBeat.o(201317);
          return;
        }
        if ((!Util.isNullOrNil(paramAnonymousString1)) && (!Util.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).pSq)) && (paramAnonymousString1.equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).pSq)))
        {
          Log.i("MicroMsg.CardGiftReceiveUI", "CDN  download fromUserContentVideoUrl! return");
          AppMethodBeat.o(201317);
          return;
        }
        CardGiftReceiveUI.g(CardGiftReceiveUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(201314);
            if (CardGiftReceiveUI.f(CardGiftReceiveUI.this).getVisibility() != 8) {
              CardGiftReceiveUI.f(CardGiftReceiveUI.this).setVisibility(8);
            }
            if ((!Util.isNullOrNil(paramAnonymousString1)) && (!Util.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).pSr)) && (paramAnonymousString1.equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).pSr))) {
              CardGiftReceiveUI.h(CardGiftReceiveUI.this).setVisibility(0);
            }
            Bitmap localBitmap;
            for (;;)
            {
              localBitmap = u.Sq(paramAnonymousString2);
              if (localBitmap != null) {
                break;
              }
              CardGiftReceiveUI.i(CardGiftReceiveUI.this).setImageResource(2131690098);
              AppMethodBeat.o(201314);
              return;
              CardGiftReceiveUI.h(CardGiftReceiveUI.this).setVisibility(8);
            }
            CardGiftReceiveUI.i(CardGiftReceiveUI.this).setImageBitmap(localBitmap);
            AppMethodBeat.o(201314);
          }
        });
        AppMethodBeat.o(201317);
      }
    };
    AppMethodBeat.o(113355);
  }
  
  private void T(LinkedList<CardGiftInfo.AcceptedCardItem> paramLinkedList)
  {
    AppMethodBeat.i(113365);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      CardGiftInfo.AcceptedCardItem localAcceptedCardItem = (CardGiftInfo.AcceptedCardItem)paramLinkedList.next();
      View localView = View.inflate(this, 2131493366, null);
      TextView localTextView1 = (TextView)localView.findViewById(2131309464);
      TextView localTextView2 = (TextView)localView.findViewById(2131309463);
      localTextView1.setText(localAcceptedCardItem.pTd);
      localTextView2.setText(localAcceptedCardItem.pTe + getContext().getString(2131757021));
      this.qbf.addView(localView);
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
  
  private int ac(int paramInt)
  {
    AppMethodBeat.i(113359);
    paramInt = com.tencent.mm.cb.a.fromDPToPix(getContext(), paramInt);
    AppMethodBeat.o(113359);
    return paramInt;
  }
  
  private void cuE()
  {
    AppMethodBeat.i(113358);
    if (this.qay == null)
    {
      Log.e("MicroMsg.CardGiftReceiveUI", "doUpdate due to cardGiftInfo is null!");
      AppMethodBeat.o(113358);
      return;
    }
    Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descLayoutMode:%d", new Object[] { Integer.valueOf(this.qay.pSF) });
    if ((this.qay.pSF != 1) && (this.qay.pSF == 2))
    {
      cvS();
      cvR();
      cuS();
      cvU();
      if (Util.isNullOrNil(this.qay.pSX)) {
        break label227;
      }
      this.qbs.setVisibility(0);
      this.qbs.setText(this.qay.pSX);
      this.qbs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(201309);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardGiftReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (!Util.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).pTc))
          {
            paramAnonymousView = new d.a(CardGiftReceiveUI.this.getContext());
            paramAnonymousView.boo(CardGiftReceiveUI.a(CardGiftReceiveUI.this).pTc);
            paramAnonymousView.aoW(2131755761);
            paramAnonymousView.aoV(2131755305);
            paramAnonymousView.a(true, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(201308);
                if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).pSY == 1)
                {
                  if ("cardhomepage".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).pSZ))
                  {
                    paramAnonymous2DialogInterface = new kl();
                    paramAnonymous2DialogInterface.dPA.context = CardGiftReceiveUI.this.getContext();
                    EventCenter.instance.publish(paramAnonymous2DialogInterface);
                    AppMethodBeat.o(201308);
                    return;
                  }
                  if ("cardhomepage/couponandgiftcard".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).pSZ))
                  {
                    if (((Boolean)g.aAh().azQ().get(ar.a.Oig, Boolean.FALSE)).booleanValue())
                    {
                      paramAnonymous2DialogInterface = new Intent();
                      paramAnonymous2DialogInterface.putExtra("scene", 1);
                      com.tencent.mm.br.c.b(CardGiftReceiveUI.this.getContext(), "card", ".ui.v3.CouponCardListUI", paramAnonymous2DialogInterface);
                      AppMethodBeat.o(201308);
                      return;
                    }
                    paramAnonymous2DialogInterface = new kl();
                    paramAnonymous2DialogInterface.dPA.context = CardGiftReceiveUI.this.getContext();
                    EventCenter.instance.publish(paramAnonymous2DialogInterface);
                    AppMethodBeat.o(201308);
                  }
                }
                else if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).pSY == 2)
                {
                  com.tencent.mm.plugin.card.d.b.V(CardGiftReceiveUI.a(CardGiftReceiveUI.this).pSK, CardGiftReceiveUI.a(CardGiftReceiveUI.this).pTa, CardGiftReceiveUI.a(CardGiftReceiveUI.this).pTb);
                }
                AppMethodBeat.o(201308);
              }
            });
            paramAnonymousView.hbn().show();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(201309);
            return;
            if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).pSY == 1)
            {
              if ("cardhomepage".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).pSZ))
              {
                paramAnonymousView = new kl();
                paramAnonymousView.dPA.context = CardGiftReceiveUI.this.getContext();
                EventCenter.instance.publish(paramAnonymousView);
              }
              else if ("cardhomepage/couponandgiftcard".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).pSZ))
              {
                if (((Boolean)g.aAh().azQ().get(ar.a.Oig, Boolean.FALSE)).booleanValue())
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("scene", 1);
                  com.tencent.mm.br.c.b(CardGiftReceiveUI.this.getContext(), "card", ".ui.v3.CouponCardListUI", paramAnonymousView);
                }
                else
                {
                  paramAnonymousView = new kl();
                  paramAnonymousView.dPA.context = CardGiftReceiveUI.this.getContext();
                  EventCenter.instance.publish(paramAnonymousView);
                }
              }
            }
            else if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).pSY == 2) {
              com.tencent.mm.plugin.card.d.b.V(CardGiftReceiveUI.a(CardGiftReceiveUI.this).pSK, CardGiftReceiveUI.a(CardGiftReceiveUI.this).pTa, CardGiftReceiveUI.a(CardGiftReceiveUI.this).pTb);
            }
          }
        }
      });
    }
    for (;;)
    {
      if ((Util.isNullOrNil(this.qay.pSL)) && (Util.isNullOrNil(this.qay.footerWording)) && (Util.isNullOrNil(this.qay.pSU)) && (Util.isNullOrNil(this.qay.pSV))) {
        break label239;
      }
      this.qaM.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(201310);
          int i = com.tencent.mm.cb.a.fromDPToPix(CardGiftReceiveUI.this.getContext(), 67);
          int j = CardGiftReceiveUI.b(CardGiftReceiveUI.this).getChildAt(0).getHeight() + i;
          int k = CardGiftReceiveUI.this.getWindow().findViewById(16908290).getHeight();
          Log.i("MicroMsg.CardGiftReceiveUI", "bottomHeight: %d  totalViewHeight:%d  screenHeight:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
          CardGiftReceiveUI.b(CardGiftReceiveUI.this).setFillViewport(true);
          if (j > k) {
            CardGiftReceiveUI.a(CardGiftReceiveUI.this, true);
          }
          for (;;)
          {
            CardGiftReceiveUI.b(CardGiftReceiveUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            AppMethodBeat.o(201310);
            return;
            CardGiftReceiveUI.a(CardGiftReceiveUI.this, false);
          }
        }
      });
      AppMethodBeat.o(113358);
      return;
      cvT();
      break;
      label227:
      this.qbs.setVisibility(8);
    }
    label239:
    this.qaM.setFillViewport(true);
    AppMethodBeat.o(113358);
  }
  
  private void cuS()
  {
    int i = 0;
    AppMethodBeat.i(113364);
    if (this.qay.pSO.size() > 0)
    {
      this.qbd.setVisibility(0);
      this.qbg.setVisibility(8);
      if (this.qay.pSO.size() <= 2)
      {
        this.qbe.setVisibility(8);
        T(this.qay.pSO);
        AppMethodBeat.o(113364);
        return;
      }
      Object localObject = new LinkedList();
      ((LinkedList)localObject).add(this.qay.pSO.get(0));
      ((LinkedList)localObject).add(this.qay.pSO.get(1));
      T((LinkedList)localObject);
      this.qbe.setVisibility(0);
      this.qbe.setOnClickListener(this);
      localObject = new LinkedList();
      while (i < this.qay.pSO.size())
      {
        if ((i != 0) && (i != 1)) {
          ((LinkedList)localObject).add(this.qay.pSO.get(i));
        }
        i += 1;
      }
      localObject = new c((LinkedList)localObject);
      this.qbg.setAdapter((ListAdapter)localObject);
      a(this.qbg);
      AppMethodBeat.o(113364);
      return;
    }
    this.qbd.setVisibility(8);
    this.qbe.setVisibility(8);
    this.qbg.setVisibility(8);
    AppMethodBeat.o(113364);
  }
  
  private void cvR()
  {
    AppMethodBeat.i(113360);
    if (this.qay.pSR == 1)
    {
      this.qbi.setVisibility(0);
      this.qbl.setVisibility(8);
      this.qbh.setVisibility(8);
      this.qbk.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, this.qay.dYs, this.qbk.getTextSize()));
      g(this.qbj);
      AppMethodBeat.o(113360);
      return;
    }
    this.qbi.setVisibility(8);
    this.qbl.setVisibility(0);
    this.qbh.setVisibility(0);
    g(this.qbq);
    this.qbr.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, this.qay.dYs, this.qbr.getTextSize()));
    if (((!Util.isNullOrNil(this.qay.pSp)) && (!"undefined".equals(this.qay.pSp))) || ((!Util.isNullOrNil(this.qay.pSq)) && (!"undefined".equals(this.qay.pSq)))) {
      this.qbn.setVisibility(0);
    }
    for (;;)
    {
      cvV();
      if (!Util.isNullOrNil(this.qay.pSo)) {
        this.qbm.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, this.qay.pSo, this.qbm.getTextSize()));
      }
      AppMethodBeat.o(113360);
      return;
      this.qbn.setVisibility(8);
      Log.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is empty");
    }
  }
  
  private void cvS()
  {
    AppMethodBeat.i(113362);
    this.qaT.setVisibility(8);
    this.qaN.setVisibility(0);
    this.qaP.setText(this.qay.pSD);
    this.qaQ.setText(this.qay.pSx + "     " + this.qay.pSy + getContext().getString(2131757021));
    Object localObject;
    if (!Util.isNullOrNil(this.qay.pSE))
    {
      this.qaO.setVisibility(0);
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aKJ();
      com.tencent.mm.av.q.bcW();
      ((c.a)localObject).jbw = null;
      ((c.a)localObject).fullPath = m.ajp(this.qay.pSE);
      ((c.a)localObject).jbf = true;
      ((c.a)localObject).jbd = true;
      localObject = ((c.a)localObject).bdv();
      com.tencent.mm.av.q.bcV().a(this.qay.pSE, this.qaO, (com.tencent.mm.av.a.a.c)localObject);
      if (Util.isNullOrNil(this.qay.pSH)) {
        break label506;
      }
      this.qaP.setTextColor(Util.convertStringToRGB(this.qay.pSH, getResources().getColor(2131100904)));
      label224:
      if (Util.isNullOrNil(this.qay.pSI)) {
        break label518;
      }
      this.qaQ.setTextColor(Util.convertStringToRGB(this.qay.pSI, getResources().getColor(2131100904)));
      label264:
      if (Util.isNullOrNil(this.qay.pSw)) {
        break label530;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aKJ();
      com.tencent.mm.av.q.bcW();
      ((c.a)localObject).jbw = null;
      ((c.a)localObject).fullPath = m.ajp(this.qay.pSw);
      ((c.a)localObject).iaT = true;
      ((c.a)localObject).jbf = true;
      ((c.a)localObject).jbd = true;
      ((c.a)localObject).hZC = new ColorDrawable(com.tencent.mm.plugin.card.d.l.ake("#CCCCCC"));
      localObject = ((c.a)localObject).bdv();
      com.tencent.mm.av.q.bcV().a(this.qay.pSw, this.qaS, (com.tencent.mm.av.a.a.c)localObject);
    }
    for (;;)
    {
      if (Util.isNullOrNil(this.qay.pSv)) {
        break label542;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aKJ();
      com.tencent.mm.av.q.bcW();
      ((c.a)localObject).jbw = null;
      ((c.a)localObject).fullPath = m.ajp(this.qay.pSv);
      ((c.a)localObject).jbf = true;
      ((c.a)localObject).jbd = true;
      ((c.a)localObject).hZC = new ColorDrawable(com.tencent.mm.plugin.card.d.l.ake("#CCCCCC"));
      ((c.a)localObject).iaT = true;
      ((c.a)localObject).jbx = com.tencent.mm.cb.a.fromDPToPix(this, 8);
      localObject = ((c.a)localObject).bdv();
      com.tencent.mm.av.q.bcV().a(this.qay.pSv, this.qaR, (com.tencent.mm.av.a.a.c)localObject);
      AppMethodBeat.o(113362);
      return;
      this.qaO.setVisibility(8);
      break;
      label506:
      Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
      break label224;
      label518:
      Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
      break label264;
      label530:
      Log.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
    }
    label542:
    Log.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
    AppMethodBeat.o(113362);
  }
  
  private void cvT()
  {
    AppMethodBeat.i(113363);
    this.qaN.setVisibility(8);
    this.qaT.setVisibility(0);
    this.qaY.setText(this.qay.pSx);
    Object localObject;
    if (this.qay.pSR == 1)
    {
      this.qbb.setAlpha(0.5F);
      this.qaZ.setVisibility(8);
      this.qba.setVisibility(8);
      this.qaV.setVisibility(8);
      this.qaU.setVisibility(8);
      if (Util.isNullOrNil(this.qay.pSE)) {
        break label672;
      }
      this.qaX.setVisibility(0);
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aKJ();
      com.tencent.mm.av.q.bcW();
      ((c.a)localObject).jbw = null;
      ((c.a)localObject).fullPath = m.ajp(this.qay.pSE);
      ((c.a)localObject).jbf = true;
      ((c.a)localObject).jbd = true;
      localObject = ((c.a)localObject).bdv();
      com.tencent.mm.av.q.bcV().a(this.qay.pSE, this.qaX, (com.tencent.mm.av.a.a.c)localObject);
      label186:
      if (Util.isNullOrNil(this.qay.pSD)) {
        break label705;
      }
      this.qaW.setVisibility(0);
      this.qaW.setText(this.qay.pSD);
      if (Util.isNullOrNil(this.qay.pSH)) {
        break label693;
      }
      this.qaW.setTextColor(Util.convertStringToRGB(this.qay.pSH, getResources().getColor(2131100904)));
      label261:
      if (Util.isNullOrNil(this.qay.pSI)) {
        break label726;
      }
      this.qaY.setTextColor(Util.convertStringToRGB(this.qay.pSI, getResources().getColor(2131100904)));
      label301:
      if (Util.isNullOrNil(this.qay.pSw)) {
        break label738;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aKJ();
      com.tencent.mm.av.q.bcW();
      ((c.a)localObject).jbw = null;
      ((c.a)localObject).fullPath = m.ajp(this.qay.pSw);
      ((c.a)localObject).iaT = true;
      ((c.a)localObject).jbf = true;
      ((c.a)localObject).jbd = true;
      ((c.a)localObject).hZC = new ColorDrawable(com.tencent.mm.plugin.card.d.l.ake("#CCCCCC"));
      localObject = ((c.a)localObject).bdv();
      com.tencent.mm.av.q.bcV().a(this.qay.pSw, this.qbc, (com.tencent.mm.av.a.a.c)localObject);
    }
    for (;;)
    {
      if (Util.isNullOrNil(this.qay.pSv)) {
        break label750;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aKJ();
      com.tencent.mm.av.q.bcW();
      ((c.a)localObject).jbw = null;
      ((c.a)localObject).fullPath = m.ajp(this.qay.pSv);
      ((c.a)localObject).jbf = true;
      ((c.a)localObject).jbd = true;
      ((c.a)localObject).hZC = new ColorDrawable(com.tencent.mm.plugin.card.d.l.ake("#CCCCCC"));
      ((c.a)localObject).iaT = true;
      ((c.a)localObject).jbx = com.tencent.mm.cb.a.fromDPToPix(this, 8);
      localObject = ((c.a)localObject).bdv();
      com.tencent.mm.av.q.bcV().a(this.qay.pSv, this.qbb, (com.tencent.mm.av.a.a.c)localObject);
      AppMethodBeat.o(113363);
      return;
      this.qaZ.setVisibility(0);
      this.qba.setVisibility(0);
      this.qaV.setVisibility(0);
      this.qaU.setVisibility(0);
      this.qaZ.setText(this.qay.pSy);
      this.qba.setText(2131757021);
      if (Util.isNullOrNil(this.qay.pSy))
      {
        this.qaZ.setVisibility(8);
        this.qba.setVisibility(8);
      }
      if (!Util.isNullOrNil(this.qay.pSJ))
      {
        this.qaZ.setTextColor(Util.convertStringToRGB(this.qay.pSJ, getResources().getColor(2131100904)));
        break;
      }
      Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardPriceTitleColor is empty");
      break;
      label672:
      this.qaX.setVisibility(8);
      Log.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
      break label186;
      label693:
      Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
      break label261;
      label705:
      this.qaW.setVisibility(8);
      Log.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
      break label261;
      label726:
      Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
      break label301;
      label738:
      Log.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
    }
    label750:
    Log.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
    AppMethodBeat.o(113363);
  }
  
  private void cvU()
  {
    AppMethodBeat.i(113366);
    if (this.qay.pSP.size() > 0)
    {
      this.qbv.setVisibility(0);
      this.qbu.setVisibility(0);
      a locala = new a();
      this.qbu.setAdapter(locala);
      a(this.qbu);
      if (!Util.isNullOrNil(this.qay.pSQ))
      {
        this.qbt.setVisibility(0);
        this.qbt.setText(this.qay.pSQ);
      }
      AppMethodBeat.o(113366);
      return;
    }
    if (!Util.isNullOrNil(this.qay.pSQ))
    {
      this.qbv.setVisibility(0);
      this.qbt.setVisibility(0);
      this.qbt.setText(this.qay.pSQ);
      this.qbu.setVisibility(8);
      AppMethodBeat.o(113366);
      return;
    }
    this.qbv.setVisibility(8);
    this.qbt.setVisibility(8);
    this.qbu.setVisibility(8);
    AppMethodBeat.o(113366);
  }
  
  private void cvV()
  {
    AppMethodBeat.i(113370);
    if ((this.qay != null) && (!Util.isNullOrNil(this.qay.pSp))) {
      com.tencent.mm.plugin.card.d.a.g(this.qay.pSp, this.qay.pSs, this.qay.pSA, 2);
    }
    while ((this.qay != null) && (!Util.isNullOrNil(this.qay.pSr)))
    {
      com.tencent.mm.plugin.card.d.a.g(this.qay.pSr, this.qay.pSu, this.qay.pSC, 2);
      AppMethodBeat.o(113370);
      return;
      Log.e("MicroMsg.CardGiftReceiveUI", "fromUserContentPicUrl is null");
    }
    Log.e("MicroMsg.CardGiftReceiveUI", "fromUserContentThumbPicUrl is null");
    AppMethodBeat.o(113370);
  }
  
  private void g(ImageView paramImageView)
  {
    AppMethodBeat.i(113361);
    if (!Util.isNullOrNil(this.qay.pSn))
    {
      int i = com.tencent.mm.cb.a.fromDPToPix(this, 20);
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aKJ();
      com.tencent.mm.av.q.bcW();
      ((c.a)localObject).jbw = null;
      ((c.a)localObject).fullPath = m.ajp(this.qay.pSn);
      ((c.a)localObject).jbf = true;
      ((c.a)localObject).iaT = true;
      ((c.a)localObject).jbx = 3.0F;
      ((c.a)localObject).jbd = true;
      ((c.a)localObject).hZA = i;
      ((c.a)localObject).hZz = i;
      ((c.a)localObject).hZC = new ColorDrawable(com.tencent.mm.plugin.card.d.l.ake("#CCCCCC"));
      localObject = ((c.a)localObject).bdv();
      com.tencent.mm.av.q.bcV().a(this.qay.pSn, paramImageView, (com.tencent.mm.av.a.a.c)localObject);
      AppMethodBeat.o(113361);
      return;
    }
    Log.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is null");
    AppMethodBeat.o(113361);
  }
  
  public int getLayoutId()
  {
    return 2131493371;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113368);
    this.qaM = ((ScrollView)findViewById(2131298126));
    this.qaN = ((LinearLayout)findViewById(2131298231));
    this.qaO = ((ImageView)findViewById(2131302911));
    this.qaP = ((TextView)findViewById(2131309525));
    this.qaQ = ((TextView)findViewById(2131309524));
    this.qaR = ((ImageView)findViewById(2131302909));
    this.qaS = ((ImageView)findViewById(2131302910));
    this.qaR.setOnClickListener(this);
    this.qaT = ((LinearLayout)findViewById(2131298230));
    this.qaU = ((RelativeLayout)findViewById(2131297358));
    this.qaV = ((RelativeLayout)findViewById(2131297361));
    this.qaW = ((TextView)findViewById(2131309474));
    this.qaY = ((TextView)findViewById(2131309520));
    this.qaX = ((ImageView)findViewById(2131302905));
    this.qaZ = ((TextView)findViewById(2131309535));
    this.qba = ((TextView)findViewById(2131309536));
    this.qbb = ((ImageView)findViewById(2131302891));
    this.qbc = ((ImageView)findViewById(2131302892));
    this.qbb.setOnClickListener(this);
    this.qbd = findViewById(2131298169);
    this.qbe = ((TextView)findViewById(2131309527));
    this.qbf = ((LinearLayout)findViewById(2131298168));
    this.qbg = ((ListView)findViewById(2131298170));
    this.qbh = ((RelativeLayout)findViewById(2131298115));
    this.qbi = ((LinearLayout)findViewById(2131302140));
    this.qbj = ((ImageView)findViewById(2131302894));
    this.qbk = ((TextView)findViewById(2131309490));
    this.qbl = ((LinearLayout)findViewById(2131302139));
    this.qbq = ((ImageView)findViewById(2131302893));
    this.qbr = ((TextView)findViewById(2131309489));
    this.qbm = ((TextView)findViewById(2131309488));
    this.qbn = ((RelativeLayout)findViewById(2131298145));
    this.qbo = ((RelativeLayout)findViewById(2131302634));
    this.qbp = ((ImageView)findViewById(2131309494));
    this.qbn.setOnClickListener(this);
    this.qbo.setOnClickListener(this);
    this.qbt = ((TextView)findViewById(2131309447));
    this.qbu = ((ListView)findViewById(2131296337));
    this.qbv = ((RelativeLayout)findViewById(2131298113));
    this.qbs = ((Button)findViewById(2131298155));
    this.qaB = ((ProgressBar)findViewById(2131302583));
    n.d(this);
    setMMTitle("");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(201311);
        CardGiftReceiveUI.this.finish();
        AppMethodBeat.o(201311);
        return true;
      }
    });
    AppMethodBeat.o(113368);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(113371);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    if (paramView.getId() == 2131302634) {
      if (!Util.isNullOrNil(this.qay.pSq))
      {
        paramView = new Intent(this, CardGiftVideoUI.class);
        paramView.putExtra("key_gift_into", this.qay);
        paramView.putExtra("key_is_mute", false);
        paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramView.axQ(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramView.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        overridePendingTransition(0, 0);
        com.tencent.mm.plugin.report.service.h.CyF.a(13866, new Object[] { Integer.valueOf(3), this.ixY, p.getString(this.ixX) });
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113371);
      return;
      if (paramView.getId() == 2131298145)
      {
        if (this.qaB.getVisibility() == 0)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113371);
          return;
        }
        if (!Util.isNullOrNil(this.qay.pSp))
        {
          paramView = new Intent(this, CardGiftImageUI.class);
          paramView.putExtra("key_gift_into", this.qay);
          paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramView.axQ(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramView.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          overridePendingTransition(0, 0);
          com.tencent.mm.plugin.report.service.h.CyF.a(13866, new Object[] { Integer.valueOf(4), this.ixY, p.getString(this.ixX) });
        }
      }
      else if (paramView.getId() == 2131309486)
      {
        if ((this.qay != null) && (this.qay.pSz))
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(13866, new Object[] { Integer.valueOf(7), this.ixY, p.getString(this.ixX) });
          if ("cardhomepage/couponandgiftcard".equals(this.qay.pSW)) {
            if (((Boolean)g.aAh().azQ().get(ar.a.Oig, Boolean.FALSE)).booleanValue())
            {
              paramView = new Intent();
              paramView.putExtra("scene", 1);
              com.tencent.mm.br.c.b(getContext(), "card", ".ui.v3.CouponCardListUI", paramView);
            }
          }
          for (;;)
          {
            finish();
            overridePendingTransition(0, 0);
            break;
            paramView = new kl();
            paramView.dPA.context = getContext();
            EventCenter.instance.publish(paramView);
            continue;
            paramView = new kl();
            paramView.dPA.context = getContext();
            paramView.dPA.scene = 2;
            EventCenter.instance.publish(paramView);
            Log.i("MicroMsg.CardGiftReceiveUI", "enter to cardhome");
          }
        }
      }
      else if (paramView.getId() == 2131309487)
      {
        if ((!TextUtils.isEmpty(this.qay.pSS)) && (!TextUtils.isEmpty(this.qay.pST)))
        {
          int i = getIntent().getIntExtra("key_from_appbrand_type", 0);
          com.tencent.mm.plugin.card.d.b.d(this.qay.pSK, this.qay.pSS, this.qay.pST, 1062, i);
          com.tencent.mm.plugin.report.service.h.CyF.a(13866, new Object[] { Integer.valueOf(8), this.ixY, p.getString(this.ixX) });
        }
        else if (!Util.isNullOrNil(this.qay.pSM))
        {
          com.tencent.mm.plugin.card.d.b.a(this, this.qay.pSM, 0);
          com.tencent.mm.plugin.report.service.h.CyF.a(13866, new Object[] { Integer.valueOf(8), this.ixY, p.getString(this.ixX) });
        }
      }
      else if ((paramView.getId() == 2131302891) || (paramView.getId() == 2131302909))
      {
        if ((!Util.isNullOrNil(this.qay.cardTpId)) && (!Util.isNullOrNil(this.qay.pSN)))
        {
          paramView = new LinkedList();
          localObject = new va();
          ((va)localObject).pRX = this.qay.cardTpId;
          ((va)localObject).code = this.qay.pSN;
          paramView.add(localObject);
          localObject = getIntent().getStringExtra("key_template_id");
          eck localeck = new eck();
          localeck.NcB = ((String)localObject);
          Log.i("MicroMsg.CardGiftReceiveUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { localObject });
          paramView = new com.tencent.mm.plugin.card.model.t(paramView, localeck, 27);
          g.aAg().hqi.a(paramView, 0);
          com.tencent.mm.plugin.report.service.h.CyF.a(13866, new Object[] { Integer.valueOf(9), this.ixY, p.getString(this.ixX) });
        }
        else
        {
          Log.e("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.userCardId is null");
        }
      }
      else if (paramView.getId() == 2131309527)
      {
        if (this.qbg.getVisibility() == 0)
        {
          this.qbg.setVisibility(8);
          this.qbe.setText("查看全部");
        }
        else
        {
          this.qbg.setVisibility(0);
          this.qbe.setText("收起");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113356);
    super.onCreate(paramBundle);
    this.ixY = getIntent().getStringExtra("key_order_id");
    this.ixX = getIntent().getIntExtra("key_biz_uin", -1);
    this.qay = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    Log.i("MicroMsg.CardGiftReceiveUI", "onCreate, orderId:%s, bizUin:%s", new Object[] { this.ixY, Integer.valueOf(this.ixX) });
    initView();
    g.aAg().hqi.a(1165, this);
    g.aAg().hqi.a(1099, this);
    com.tencent.mm.plugin.card.d.a.a(this.qbA);
    if (this.qay == null)
    {
      Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo is null, sync GiftCard from serve");
      if (this.ixX == -1)
      {
        Log.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, bizUin is -1, fail!");
        AppMethodBeat.o(113356);
        return;
      }
      if (this.ixY == null) {
        Log.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, orderId is null, fail");
      }
      Log.e("MicroMsg.CardGiftReceiveUI", "doNetSceneGetCardGiftInfo");
      paramBundle = new z(this.ixX, this.ixY);
      g.aAg().hqi.a(paramBundle, 0);
      this.tipDialog = com.tencent.mm.ui.base.h.a(getContext(), getString(2131762446), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(201312);
          if ((CardGiftReceiveUI.c(CardGiftReceiveUI.this) != null) && (CardGiftReceiveUI.c(CardGiftReceiveUI.this).isShowing())) {
            CardGiftReceiveUI.c(CardGiftReceiveUI.this).dismiss();
          }
          if ((CardGiftReceiveUI.d(CardGiftReceiveUI.this).getVisibility() == 8) || (CardGiftReceiveUI.e(CardGiftReceiveUI.this).getVisibility() == 4))
          {
            Log.i("MicroMsg.CardGiftReceiveUI", "user cancel & finish");
            CardGiftReceiveUI.this.finish();
          }
          AppMethodBeat.o(201312);
        }
      });
      if (this.tipDialog != null) {
        this.tipDialog.show();
      }
      AppMethodBeat.o(113356);
      return;
    }
    cuE();
    AppMethodBeat.o(113356);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113357);
    super.onDestroy();
    g.aAg().hqi.b(1165, this);
    g.aAg().hqi.b(1099, this);
    com.tencent.mm.plugin.card.d.a.b(this.qbA);
    AppMethodBeat.o(113357);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(113369);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof z))
      {
        Log.i("MicroMsg.CardGiftReceiveUI", "card gift info cgi success!");
        this.qay = ((z)paramq).pUb;
        cuE();
        AppMethodBeat.o(113369);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.card.model.t))
      {
        paramString = new Intent(this, CardDetailUI.class);
        Object localObject = ((com.tencent.mm.plugin.card.model.t)paramq).pUe;
        if ((localObject == null) || (((LinkedList)localObject).size() == 0))
        {
          Log.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardinfo list  size is null or empty!");
          AppMethodBeat.o(113369);
          return;
        }
        paramq = (com.tencent.mm.plugin.card.base.b)((LinkedList)localObject).get(0);
        if ((paramq == null) || (!(paramq instanceof CardInfo)))
        {
          Log.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardInfo  is null!");
          AppMethodBeat.o(113369);
          return;
        }
        ArrayList localArrayList = new ArrayList();
        localObject = ((LinkedList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList.add((CardInfo)((Iterator)localObject).next());
        }
        paramString.putExtra("key_card_info", (CardInfo)paramq);
        paramString.putExtra("key_previous_scene", 27);
        paramString.putExtra("key_from_scene", 27);
        paramString.putExtra("key_from_appbrand_type", paramString.getIntExtra("key_from_appbrand_type", 0));
        paramString.putExtra("key_card_git_info", this.qay);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(113369);
      }
    }
    else
    {
      if ((paramq instanceof z))
      {
        Log.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        com.tencent.mm.plugin.card.d.d.a(this, paramString, true);
        AppMethodBeat.o(113369);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.card.model.t))
      {
        Log.e("MicroMsg.CardGiftReceiveUI", ", NetSceneBatchGetCardItemByTpInfo onSceneEnd fail return!  errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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
      int i = CardGiftReceiveUI.a(CardGiftReceiveUI.this).pSP.size();
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
      CardGiftInfo.AccepterItem localAccepterItem = (CardGiftInfo.AccepterItem)CardGiftReceiveUI.a(CardGiftReceiveUI.this).pSP.get(paramInt);
      ImageView localImageView;
      String str;
      if (paramView == null)
      {
        paramView = View.inflate(CardGiftReceiveUI.this, 2131493367, null);
        paramViewGroup = new CardGiftReceiveUI.b(CardGiftReceiveUI.this);
        paramViewGroup.qbE = ((ImageView)paramView.findViewById(2131302621));
        paramViewGroup.qbF = ((TextView)paramView.findViewById(2131309448));
        paramViewGroup.hbb = ((TextView)paramView.findViewById(2131309450));
        paramViewGroup.qbG = ((TextView)paramView.findViewById(2131309449));
        paramView.setTag(paramViewGroup);
        if (localAccepterItem != null) {
          if (localAccepterItem.pTg != null)
          {
            localImageView = paramViewGroup.qbE;
            str = localAccepterItem.pTg;
            if ((localImageView != null) && (!TextUtils.isEmpty(str))) {
              break label229;
            }
          }
        }
      }
      for (;;)
      {
        paramViewGroup.qbF.setText(localAccepterItem.pTf);
        paramViewGroup.hbb.setText(localAccepterItem.pTd);
        paramViewGroup.qbG.setText(localAccepterItem.pTe + CardGiftReceiveUI.this.getContext().getString(2131757021));
        AppMethodBeat.o(113349);
        return paramView;
        paramViewGroup = (CardGiftReceiveUI.b)paramView.getTag();
        break;
        label229:
        if (!TextUtils.isEmpty(str))
        {
          Object localObject = new c.a();
          ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aKJ();
          com.tencent.mm.av.q.bcW();
          ((c.a)localObject).jbw = null;
          ((c.a)localObject).fullPath = m.ajp(str);
          ((c.a)localObject).jbf = true;
          ((c.a)localObject).iaT = true;
          ((c.a)localObject).jbx = 3.0F;
          ((c.a)localObject).jbd = true;
          ((c.a)localObject).hZA = 34;
          ((c.a)localObject).hZz = 34;
          ((c.a)localObject).jbq = 2131234198;
          localObject = ((c.a)localObject).bdv();
          com.tencent.mm.av.q.bcV().a(str, localImageView, (com.tencent.mm.av.a.a.c)localObject);
        }
        else
        {
          localImageView.setImageResource(2131234198);
        }
      }
    }
  }
  
  final class b
  {
    public TextView hbb;
    public ImageView qbE;
    public TextView qbF;
    public TextView qbG;
    
    b() {}
  }
  
  final class c
    extends BaseAdapter
  {
    private LinkedList<CardGiftInfo.AcceptedCardItem> qbH;
    
    c()
    {
      Object localObject;
      this.qbH = localObject;
    }
    
    private CardGiftInfo.AcceptedCardItem Et(int paramInt)
    {
      AppMethodBeat.i(113352);
      CardGiftInfo.AcceptedCardItem localAcceptedCardItem = (CardGiftInfo.AcceptedCardItem)this.qbH.get(paramInt);
      AppMethodBeat.o(113352);
      return localAcceptedCardItem;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(113351);
      int i = this.qbH.size();
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
      CardGiftInfo.AcceptedCardItem localAcceptedCardItem = Et(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = View.inflate(CardGiftReceiveUI.this, 2131493366, null);
        paramView = new CardGiftReceiveUI.d(CardGiftReceiveUI.this);
        paramView.hbb = ((TextView)localView.findViewById(2131309464));
        paramView.qbG = ((TextView)localView.findViewById(2131309463));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        paramViewGroup.hbb.setText(localAcceptedCardItem.pTd);
        paramViewGroup.qbG.setText(localAcceptedCardItem.pTe + CardGiftReceiveUI.this.getContext().getString(2131757021));
        AppMethodBeat.o(113353);
        return localView;
        paramViewGroup = (CardGiftReceiveUI.d)paramView.getTag();
        localView = paramView;
      }
    }
  }
  
  final class d
  {
    public TextView hbb;
    public TextView qbG;
    
    d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftReceiveUI
 * JD-Core Version:    0.7.0.1
 */