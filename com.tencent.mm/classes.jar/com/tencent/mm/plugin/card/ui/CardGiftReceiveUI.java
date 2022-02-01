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
import com.tencent.mm.al.f;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.g.a.jv;
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
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.protocal.protobuf.tt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftReceiveUI
  extends MMActivity
  implements View.OnClickListener, f
{
  private int hBe;
  private String hBf;
  private TextView oGA;
  private ImageView oGB;
  private ImageView oGC;
  private LinearLayout oGD;
  private RelativeLayout oGE;
  private RelativeLayout oGF;
  private TextView oGG;
  private ImageView oGH;
  private TextView oGI;
  private TextView oGJ;
  private TextView oGK;
  private ImageView oGL;
  private ImageView oGM;
  private View oGN;
  private TextView oGO;
  private LinearLayout oGP;
  private ListView oGQ;
  private RelativeLayout oGR;
  private LinearLayout oGS;
  private ImageView oGT;
  private TextView oGU;
  private LinearLayout oGV;
  private TextView oGW;
  private RelativeLayout oGX;
  private RelativeLayout oGY;
  private ImageView oGZ;
  private CardGiftInfo oGi;
  private ProgressBar oGl;
  private ap oGm;
  private ScrollView oGw;
  private LinearLayout oGx;
  private ImageView oGy;
  private TextView oGz;
  private ImageView oHa;
  private TextView oHb;
  private Button oHc;
  private TextView oHd;
  private ListView oHe;
  private RelativeLayout oHf;
  private TextView oHg;
  private TextView oHh;
  private View oHi;
  private RelativeLayout oHj;
  a.a oHk;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public CardGiftReceiveUI()
  {
    AppMethodBeat.i(113355);
    this.tipDialog = null;
    this.oGm = new ap(Looper.getMainLooper());
    this.oHk = new a.a()
    {
      public final void YL(String paramAnonymousString)
      {
        AppMethodBeat.i(215405);
        ad.e("MicroMsg.CardGiftReceiveUI", "CDN download pic failure! fieldId:".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(215405);
      }
      
      public final void cF(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(215404);
        if (CardGiftReceiveUI.a(CardGiftReceiveUI.this) == null)
        {
          ad.e("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress cardGiftInfo is null return!");
          AppMethodBeat.o(215404);
          return;
        }
        if ((!bt.isNullOrNil(paramAnonymousString)) && (!bt.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyf)) && (paramAnonymousString.equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyf)))
        {
          ad.i("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress fromUserContentVideoUrl return!");
          AppMethodBeat.o(215404);
          return;
        }
        CardGiftReceiveUI.g(CardGiftReceiveUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(215402);
            if (CardGiftReceiveUI.f(CardGiftReceiveUI.this).getVisibility() != 0) {
              CardGiftReceiveUI.f(CardGiftReceiveUI.this).setVisibility(0);
            }
            AppMethodBeat.o(215402);
          }
        });
        AppMethodBeat.o(215404);
      }
      
      public final void fb(final String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(215406);
        ad.i("MicroMsg.CardGiftReceiveUI", "CDN  download success! fieldId:".concat(String.valueOf(paramAnonymousString1)));
        if (CardGiftReceiveUI.a(CardGiftReceiveUI.this) == null)
        {
          ad.e("MicroMsg.CardGiftReceiveUI", "CDN  download cardGiftInfo is null return!");
          AppMethodBeat.o(215406);
          return;
        }
        if ((!bt.isNullOrNil(paramAnonymousString1)) && (!bt.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyf)) && (paramAnonymousString1.equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyf)))
        {
          ad.i("MicroMsg.CardGiftReceiveUI", "CDN  download fromUserContentVideoUrl! return");
          AppMethodBeat.o(215406);
          return;
        }
        CardGiftReceiveUI.g(CardGiftReceiveUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(215403);
            if (CardGiftReceiveUI.f(CardGiftReceiveUI.this).getVisibility() != 8) {
              CardGiftReceiveUI.f(CardGiftReceiveUI.this).setVisibility(8);
            }
            if ((!bt.isNullOrNil(paramAnonymousString1)) && (!bt.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyg)) && (paramAnonymousString1.equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyg))) {
              CardGiftReceiveUI.h(CardGiftReceiveUI.this).setVisibility(0);
            }
            Bitmap localBitmap;
            for (;;)
            {
              localBitmap = u.IT(paramAnonymousString2);
              if (localBitmap != null) {
                break;
              }
              CardGiftReceiveUI.i(CardGiftReceiveUI.this).setImageResource(2131690066);
              AppMethodBeat.o(215403);
              return;
              CardGiftReceiveUI.h(CardGiftReceiveUI.this).setVisibility(8);
            }
            CardGiftReceiveUI.i(CardGiftReceiveUI.this).setImageBitmap(localBitmap);
            AppMethodBeat.o(215403);
          }
        });
        AppMethodBeat.o(215406);
      }
    };
    AppMethodBeat.o(113355);
  }
  
  private void R(LinkedList<CardGiftInfo.AcceptedCardItem> paramLinkedList)
  {
    AppMethodBeat.i(113365);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      CardGiftInfo.AcceptedCardItem localAcceptedCardItem = (CardGiftInfo.AcceptedCardItem)paramLinkedList.next();
      View localView = View.inflate(this, 2131493277, null);
      TextView localTextView1 = (TextView)localView.findViewById(2131306111);
      TextView localTextView2 = (TextView)localView.findViewById(2131306110);
      localTextView1.setText(localAcceptedCardItem.oyT);
      localTextView2.setText(localAcceptedCardItem.oyU + getContext().getString(2131756856));
      this.oGP.addView(localView);
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
    paramInt = com.tencent.mm.cc.a.fromDPToPix(getContext(), paramInt);
    AppMethodBeat.o(113359);
    return paramInt;
  }
  
  private void bVN()
  {
    int i = 0;
    AppMethodBeat.i(113364);
    if (this.oGi.oyE.size() > 0)
    {
      this.oGN.setVisibility(0);
      this.oGQ.setVisibility(8);
      if (this.oGi.oyE.size() <= 2)
      {
        this.oGO.setVisibility(8);
        R(this.oGi.oyE);
        AppMethodBeat.o(113364);
        return;
      }
      Object localObject = new LinkedList();
      ((LinkedList)localObject).add(this.oGi.oyE.get(0));
      ((LinkedList)localObject).add(this.oGi.oyE.get(1));
      R((LinkedList)localObject);
      this.oGO.setVisibility(0);
      this.oGO.setOnClickListener(this);
      localObject = new LinkedList();
      while (i < this.oGi.oyE.size())
      {
        if ((i != 0) && (i != 1)) {
          ((LinkedList)localObject).add(this.oGi.oyE.get(i));
        }
        i += 1;
      }
      localObject = new c((LinkedList)localObject);
      this.oGQ.setAdapter((ListAdapter)localObject);
      a(this.oGQ);
      AppMethodBeat.o(113364);
      return;
    }
    this.oGN.setVisibility(8);
    this.oGO.setVisibility(8);
    this.oGQ.setVisibility(8);
    AppMethodBeat.o(113364);
  }
  
  private void bVy()
  {
    AppMethodBeat.i(113358);
    if (this.oGi == null)
    {
      ad.e("MicroMsg.CardGiftReceiveUI", "doUpdate due to cardGiftInfo is null!");
      AppMethodBeat.o(113358);
      return;
    }
    ad.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descLayoutMode:%d", new Object[] { Integer.valueOf(this.oGi.oyu) });
    if ((this.oGi.oyu != 1) && (this.oGi.oyu == 2))
    {
      bWN();
      bWM();
      bVN();
      bWP();
      if (bt.isNullOrNil(this.oGi.oyN)) {
        break label227;
      }
      this.oHc.setVisibility(0);
      this.oHc.setText(this.oGi.oyN);
      this.oHc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(215398);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardGiftReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (!bt.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyS))
          {
            paramAnonymousView = new d.a(CardGiftReceiveUI.this.getContext());
            paramAnonymousView.aXG(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyS);
            paramAnonymousView.afm(2131755691);
            paramAnonymousView.afl(2131755270);
            paramAnonymousView.a(true, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(215397);
                if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyO == 1)
                {
                  if ("cardhomepage".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyP))
                  {
                    paramAnonymous2DialogInterface = new jv();
                    paramAnonymous2DialogInterface.dwO.context = CardGiftReceiveUI.this.getContext();
                    com.tencent.mm.sdk.b.a.IbL.l(paramAnonymous2DialogInterface);
                    AppMethodBeat.o(215397);
                    return;
                  }
                  if ("cardhomepage/couponandgiftcard".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyP))
                  {
                    if (((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IFb, Boolean.FALSE)).booleanValue())
                    {
                      paramAnonymous2DialogInterface = new Intent();
                      paramAnonymous2DialogInterface.putExtra("scene", 1);
                      com.tencent.mm.bs.d.b(CardGiftReceiveUI.this.getContext(), "card", ".ui.v3.CouponCardListUI", paramAnonymous2DialogInterface);
                      AppMethodBeat.o(215397);
                      return;
                    }
                    paramAnonymous2DialogInterface = new jv();
                    paramAnonymous2DialogInterface.dwO.context = CardGiftReceiveUI.this.getContext();
                    com.tencent.mm.sdk.b.a.IbL.l(paramAnonymous2DialogInterface);
                    AppMethodBeat.o(215397);
                  }
                }
                else if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyO == 2)
                {
                  com.tencent.mm.plugin.card.d.b.P(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyz, CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyQ, CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyR);
                }
                AppMethodBeat.o(215397);
              }
            });
            paramAnonymousView.fMb().show();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(215398);
            return;
            if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyO == 1)
            {
              if ("cardhomepage".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyP))
              {
                paramAnonymousView = new jv();
                paramAnonymousView.dwO.context = CardGiftReceiveUI.this.getContext();
                com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
              }
              else if ("cardhomepage/couponandgiftcard".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyP))
              {
                if (((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IFb, Boolean.FALSE)).booleanValue())
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("scene", 1);
                  com.tencent.mm.bs.d.b(CardGiftReceiveUI.this.getContext(), "card", ".ui.v3.CouponCardListUI", paramAnonymousView);
                }
                else
                {
                  paramAnonymousView = new jv();
                  paramAnonymousView.dwO.context = CardGiftReceiveUI.this.getContext();
                  com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
                }
              }
            }
            else if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyO == 2) {
              com.tencent.mm.plugin.card.d.b.P(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyz, CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyQ, CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyR);
            }
          }
        }
      });
    }
    for (;;)
    {
      if ((bt.isNullOrNil(this.oGi.oyA)) && (bt.isNullOrNil(this.oGi.footerWording)) && (bt.isNullOrNil(this.oGi.oyK)) && (bt.isNullOrNil(this.oGi.oyL))) {
        break label239;
      }
      this.oGw.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(215399);
          int i = com.tencent.mm.cc.a.fromDPToPix(CardGiftReceiveUI.this.getContext(), 67);
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
            AppMethodBeat.o(215399);
            return;
            CardGiftReceiveUI.a(CardGiftReceiveUI.this, false);
          }
        }
      });
      AppMethodBeat.o(113358);
      return;
      bWO();
      break;
      label227:
      this.oHc.setVisibility(8);
    }
    label239:
    this.oGw.setFillViewport(true);
    AppMethodBeat.o(113358);
  }
  
  private void bWM()
  {
    AppMethodBeat.i(113360);
    if (this.oGi.oyH == 1)
    {
      this.oGS.setVisibility(0);
      this.oGV.setVisibility(8);
      this.oGR.setVisibility(8);
      this.oGU.setText(k.b(this, this.oGi.dFE, this.oGU.getTextSize()));
      f(this.oGT);
      AppMethodBeat.o(113360);
      return;
    }
    this.oGS.setVisibility(8);
    this.oGV.setVisibility(0);
    this.oGR.setVisibility(0);
    f(this.oHa);
    this.oHb.setText(k.b(this, this.oGi.dFE, this.oHb.getTextSize()));
    if (((!bt.isNullOrNil(this.oGi.oye)) && (!"undefined".equals(this.oGi.oye))) || ((!bt.isNullOrNil(this.oGi.oyf)) && (!"undefined".equals(this.oGi.oyf)))) {
      this.oGX.setVisibility(0);
    }
    for (;;)
    {
      bWQ();
      if (!bt.isNullOrNil(this.oGi.oyd)) {
        this.oGW.setText(k.b(this, this.oGi.oyd, this.oGW.getTextSize()));
      }
      AppMethodBeat.o(113360);
      return;
      this.oGX.setVisibility(8);
      ad.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is empty");
    }
  }
  
  private void bWN()
  {
    AppMethodBeat.i(113362);
    this.oGD.setVisibility(8);
    this.oGx.setVisibility(0);
    this.oGz.setText(this.oGi.oys);
    this.oGA.setText(this.oGi.oym + "     " + this.oGi.oyn + getContext().getString(2131756856));
    Object localObject;
    if (!bt.isNullOrNil(this.oGi.oyt))
    {
      this.oGy.setVisibility(0);
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.arU();
      com.tencent.mm.aw.q.aIK();
      ((c.a)localObject).idJ = null;
      ((c.a)localObject).hdP = m.Yt(this.oGi.oyt);
      ((c.a)localObject).idr = true;
      ((c.a)localObject).idp = true;
      localObject = ((c.a)localObject).aJc();
      com.tencent.mm.aw.q.aIJ().a(this.oGi.oyt, this.oGy, (c)localObject);
      if (bt.isNullOrNil(this.oGi.oyw)) {
        break label506;
      }
      this.oGz.setTextColor(bt.cJ(this.oGi.oyw, getResources().getColor(2131100711)));
      label224:
      if (bt.isNullOrNil(this.oGi.oyx)) {
        break label518;
      }
      this.oGA.setTextColor(bt.cJ(this.oGi.oyx, getResources().getColor(2131100711)));
      label264:
      if (bt.isNullOrNil(this.oGi.oyl)) {
        break label530;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.arU();
      com.tencent.mm.aw.q.aIK();
      ((c.a)localObject).idJ = null;
      ((c.a)localObject).hdP = m.Yt(this.oGi.oyl);
      ((c.a)localObject).hfi = true;
      ((c.a)localObject).idr = true;
      ((c.a)localObject).idp = true;
      ((c.a)localObject).hdU = new ColorDrawable(l.Zh("#CCCCCC"));
      localObject = ((c.a)localObject).aJc();
      com.tencent.mm.aw.q.aIJ().a(this.oGi.oyl, this.oGC, (c)localObject);
    }
    for (;;)
    {
      if (bt.isNullOrNil(this.oGi.oyk)) {
        break label542;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.arU();
      com.tencent.mm.aw.q.aIK();
      ((c.a)localObject).idJ = null;
      ((c.a)localObject).hdP = m.Yt(this.oGi.oyk);
      ((c.a)localObject).idr = true;
      ((c.a)localObject).idp = true;
      ((c.a)localObject).hdU = new ColorDrawable(l.Zh("#CCCCCC"));
      ((c.a)localObject).hfi = true;
      ((c.a)localObject).idK = com.tencent.mm.cc.a.fromDPToPix(this, 8);
      localObject = ((c.a)localObject).aJc();
      com.tencent.mm.aw.q.aIJ().a(this.oGi.oyk, this.oGB, (c)localObject);
      AppMethodBeat.o(113362);
      return;
      this.oGy.setVisibility(8);
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
  
  private void bWO()
  {
    AppMethodBeat.i(113363);
    this.oGx.setVisibility(8);
    this.oGD.setVisibility(0);
    this.oGI.setText(this.oGi.oym);
    Object localObject;
    if (this.oGi.oyH == 1)
    {
      this.oGL.setAlpha(0.5F);
      this.oGJ.setVisibility(8);
      this.oGK.setVisibility(8);
      this.oGF.setVisibility(8);
      this.oGE.setVisibility(8);
      if (bt.isNullOrNil(this.oGi.oyt)) {
        break label672;
      }
      this.oGH.setVisibility(0);
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.arU();
      com.tencent.mm.aw.q.aIK();
      ((c.a)localObject).idJ = null;
      ((c.a)localObject).hdP = m.Yt(this.oGi.oyt);
      ((c.a)localObject).idr = true;
      ((c.a)localObject).idp = true;
      localObject = ((c.a)localObject).aJc();
      com.tencent.mm.aw.q.aIJ().a(this.oGi.oyt, this.oGH, (c)localObject);
      label186:
      if (bt.isNullOrNil(this.oGi.oys)) {
        break label705;
      }
      this.oGG.setVisibility(0);
      this.oGG.setText(this.oGi.oys);
      if (bt.isNullOrNil(this.oGi.oyw)) {
        break label693;
      }
      this.oGG.setTextColor(bt.cJ(this.oGi.oyw, getResources().getColor(2131100711)));
      label261:
      if (bt.isNullOrNil(this.oGi.oyx)) {
        break label726;
      }
      this.oGI.setTextColor(bt.cJ(this.oGi.oyx, getResources().getColor(2131100711)));
      label301:
      if (bt.isNullOrNil(this.oGi.oyl)) {
        break label738;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.arU();
      com.tencent.mm.aw.q.aIK();
      ((c.a)localObject).idJ = null;
      ((c.a)localObject).hdP = m.Yt(this.oGi.oyl);
      ((c.a)localObject).hfi = true;
      ((c.a)localObject).idr = true;
      ((c.a)localObject).idp = true;
      ((c.a)localObject).hdU = new ColorDrawable(l.Zh("#CCCCCC"));
      localObject = ((c.a)localObject).aJc();
      com.tencent.mm.aw.q.aIJ().a(this.oGi.oyl, this.oGM, (c)localObject);
    }
    for (;;)
    {
      if (bt.isNullOrNil(this.oGi.oyk)) {
        break label750;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.arU();
      com.tencent.mm.aw.q.aIK();
      ((c.a)localObject).idJ = null;
      ((c.a)localObject).hdP = m.Yt(this.oGi.oyk);
      ((c.a)localObject).idr = true;
      ((c.a)localObject).idp = true;
      ((c.a)localObject).hdU = new ColorDrawable(l.Zh("#CCCCCC"));
      ((c.a)localObject).hfi = true;
      ((c.a)localObject).idK = com.tencent.mm.cc.a.fromDPToPix(this, 8);
      localObject = ((c.a)localObject).aJc();
      com.tencent.mm.aw.q.aIJ().a(this.oGi.oyk, this.oGL, (c)localObject);
      AppMethodBeat.o(113363);
      return;
      this.oGJ.setVisibility(0);
      this.oGK.setVisibility(0);
      this.oGF.setVisibility(0);
      this.oGE.setVisibility(0);
      this.oGJ.setText(this.oGi.oyn);
      this.oGK.setText(2131756856);
      if (bt.isNullOrNil(this.oGi.oyn))
      {
        this.oGJ.setVisibility(8);
        this.oGK.setVisibility(8);
      }
      if (!bt.isNullOrNil(this.oGi.oyy))
      {
        this.oGJ.setTextColor(bt.cJ(this.oGi.oyy, getResources().getColor(2131100711)));
        break;
      }
      ad.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardPriceTitleColor is empty");
      break;
      label672:
      this.oGH.setVisibility(8);
      ad.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
      break label186;
      label693:
      ad.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
      break label261;
      label705:
      this.oGG.setVisibility(8);
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
  
  private void bWP()
  {
    AppMethodBeat.i(113366);
    if (this.oGi.oyF.size() > 0)
    {
      this.oHf.setVisibility(0);
      this.oHe.setVisibility(0);
      a locala = new a();
      this.oHe.setAdapter(locala);
      a(this.oHe);
      if (!bt.isNullOrNil(this.oGi.oyG))
      {
        this.oHd.setVisibility(0);
        this.oHd.setText(this.oGi.oyG);
      }
      AppMethodBeat.o(113366);
      return;
    }
    if (!bt.isNullOrNil(this.oGi.oyG))
    {
      this.oHf.setVisibility(0);
      this.oHd.setVisibility(0);
      this.oHd.setText(this.oGi.oyG);
      this.oHe.setVisibility(8);
      AppMethodBeat.o(113366);
      return;
    }
    this.oHf.setVisibility(8);
    this.oHd.setVisibility(8);
    this.oHe.setVisibility(8);
    AppMethodBeat.o(113366);
  }
  
  private void bWQ()
  {
    AppMethodBeat.i(113370);
    if ((this.oGi != null) && (!bt.isNullOrNil(this.oGi.oye))) {
      com.tencent.mm.plugin.card.d.a.g(this.oGi.oye, this.oGi.oyh, this.oGi.oyp, 2);
    }
    while ((this.oGi != null) && (!bt.isNullOrNil(this.oGi.oyg)))
    {
      com.tencent.mm.plugin.card.d.a.g(this.oGi.oyg, this.oGi.oyj, this.oGi.oyr, 2);
      AppMethodBeat.o(113370);
      return;
      ad.e("MicroMsg.CardGiftReceiveUI", "fromUserContentPicUrl is null");
    }
    ad.e("MicroMsg.CardGiftReceiveUI", "fromUserContentThumbPicUrl is null");
    AppMethodBeat.o(113370);
  }
  
  private void f(ImageView paramImageView)
  {
    AppMethodBeat.i(113361);
    if (!bt.isNullOrNil(this.oGi.oyc))
    {
      int i = com.tencent.mm.cc.a.fromDPToPix(this, 20);
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.arU();
      com.tencent.mm.aw.q.aIK();
      ((c.a)localObject).idJ = null;
      ((c.a)localObject).hdP = m.Yt(this.oGi.oyc);
      ((c.a)localObject).idr = true;
      ((c.a)localObject).hfi = true;
      ((c.a)localObject).idK = 3.0F;
      ((c.a)localObject).idp = true;
      ((c.a)localObject).hdS = i;
      ((c.a)localObject).hdR = i;
      ((c.a)localObject).hdU = new ColorDrawable(l.Zh("#CCCCCC"));
      localObject = ((c.a)localObject).aJc();
      com.tencent.mm.aw.q.aIJ().a(this.oGi.oyc, paramImageView, (c)localObject);
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
    this.oGw = ((ScrollView)findViewById(2131297811));
    this.oGx = ((LinearLayout)findViewById(2131297913));
    this.oGy = ((ImageView)findViewById(2131301223));
    this.oGz = ((TextView)findViewById(2131306153));
    this.oGA = ((TextView)findViewById(2131306152));
    this.oGB = ((ImageView)findViewById(2131301221));
    this.oGC = ((ImageView)findViewById(2131301222));
    this.oGB.setOnClickListener(this);
    this.oGD = ((LinearLayout)findViewById(2131297912));
    this.oGE = ((RelativeLayout)findViewById(2131297206));
    this.oGF = ((RelativeLayout)findViewById(2131297209));
    this.oGG = ((TextView)findViewById(2131306118));
    this.oGI = ((TextView)findViewById(2131306149));
    this.oGH = ((ImageView)findViewById(2131301219));
    this.oGJ = ((TextView)findViewById(2131306158));
    this.oGK = ((TextView)findViewById(2131306159));
    this.oGL = ((ImageView)findViewById(2131301210));
    this.oGM = ((ImageView)findViewById(2131301211));
    this.oGL.setOnClickListener(this);
    this.oGN = findViewById(2131297853);
    this.oGO = ((TextView)findViewById(2131306154));
    this.oGP = ((LinearLayout)findViewById(2131297852));
    this.oGQ = ((ListView)findViewById(2131297854));
    this.oGR = ((RelativeLayout)findViewById(2131297800));
    this.oGS = ((LinearLayout)findViewById(2131300593));
    this.oGT = ((ImageView)findViewById(2131301213));
    this.oGU = ((TextView)findViewById(2131306131));
    this.oGV = ((LinearLayout)findViewById(2131300592));
    this.oHa = ((ImageView)findViewById(2131301212));
    this.oHb = ((TextView)findViewById(2131306130));
    this.oGW = ((TextView)findViewById(2131306129));
    this.oGX = ((RelativeLayout)findViewById(2131297829));
    this.oGY = ((RelativeLayout)findViewById(2131300993));
    this.oGZ = ((ImageView)findViewById(2131306134));
    this.oGX.setOnClickListener(this);
    this.oGY.setOnClickListener(this);
    this.oHd = ((TextView)findViewById(2131306104));
    this.oHe = ((ListView)findViewById(2131296324));
    this.oHf = ((RelativeLayout)findViewById(2131297798));
    this.oHc = ((Button)findViewById(2131297839));
    this.oGl = ((ProgressBar)findViewById(2131300950));
    com.tencent.mm.plugin.card.d.n.d(this);
    setMMTitle("");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(215400);
        CardGiftReceiveUI.this.finish();
        AppMethodBeat.o(215400);
        return true;
      }
    });
    AppMethodBeat.o(113368);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(113371);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    if (paramView.getId() == 2131300993) {
      if (!bt.isNullOrNil(this.oGi.oyf))
      {
        paramView = new Intent(this, CardGiftVideoUI.class);
        paramView.putExtra("key_gift_into", this.oGi);
        paramView.putExtra("key_is_mute", false);
        paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramView.ahp(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramView.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        overridePendingTransition(0, 0);
        com.tencent.mm.plugin.report.service.g.yhR.f(13866, new Object[] { Integer.valueOf(3), this.hBf, com.tencent.mm.b.p.getString(this.hBe) });
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113371);
      return;
      if (paramView.getId() == 2131297829)
      {
        if (this.oGl.getVisibility() == 0)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113371);
          return;
        }
        if (!bt.isNullOrNil(this.oGi.oye))
        {
          paramView = new Intent(this, CardGiftImageUI.class);
          paramView.putExtra("key_gift_into", this.oGi);
          paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramView.ahp(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramView.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          overridePendingTransition(0, 0);
          com.tencent.mm.plugin.report.service.g.yhR.f(13866, new Object[] { Integer.valueOf(4), this.hBf, com.tencent.mm.b.p.getString(this.hBe) });
        }
      }
      else if (paramView.getId() == 2131306127)
      {
        if ((this.oGi != null) && (this.oGi.oyo))
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(13866, new Object[] { Integer.valueOf(7), this.hBf, com.tencent.mm.b.p.getString(this.hBe) });
          if ("cardhomepage/couponandgiftcard".equals(this.oGi.oyM)) {
            if (((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IFb, Boolean.FALSE)).booleanValue())
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
            break;
            paramView = new jv();
            paramView.dwO.context = getContext();
            com.tencent.mm.sdk.b.a.IbL.l(paramView);
            continue;
            paramView = new jv();
            paramView.dwO.context = getContext();
            paramView.dwO.scene = 2;
            com.tencent.mm.sdk.b.a.IbL.l(paramView);
            ad.i("MicroMsg.CardGiftReceiveUI", "enter to cardhome");
          }
        }
      }
      else if (paramView.getId() == 2131306128)
      {
        if ((!TextUtils.isEmpty(this.oGi.oyI)) && (!TextUtils.isEmpty(this.oGi.oyJ)))
        {
          int i = getIntent().getIntExtra("key_from_appbrand_type", 0);
          com.tencent.mm.plugin.card.d.b.d(this.oGi.oyz, this.oGi.oyI, this.oGi.oyJ, 1062, i);
          com.tencent.mm.plugin.report.service.g.yhR.f(13866, new Object[] { Integer.valueOf(8), this.hBf, com.tencent.mm.b.p.getString(this.hBe) });
        }
        else if (!bt.isNullOrNil(this.oGi.oyB))
        {
          com.tencent.mm.plugin.card.d.b.a(this, this.oGi.oyB, 0);
          com.tencent.mm.plugin.report.service.g.yhR.f(13866, new Object[] { Integer.valueOf(8), this.hBf, com.tencent.mm.b.p.getString(this.hBe) });
        }
      }
      else if ((paramView.getId() == 2131301210) || (paramView.getId() == 2131301221))
      {
        if ((!bt.isNullOrNil(this.oGi.oyC)) && (!bt.isNullOrNil(this.oGi.oyD)))
        {
          paramView = new LinkedList();
          localObject = new tt();
          ((tt)localObject).oxM = this.oGi.oyC;
          ((tt)localObject).code = this.oGi.oyD;
          paramView.add(localObject);
          localObject = getIntent().getStringExtra("key_template_id");
          did localdid = new did();
          localdid.HwU = ((String)localObject);
          ad.i("MicroMsg.CardGiftReceiveUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { localObject });
          paramView = new t(paramView, localdid, 27);
          com.tencent.mm.kernel.g.ajB().gAO.a(paramView, 0);
          com.tencent.mm.plugin.report.service.g.yhR.f(13866, new Object[] { Integer.valueOf(9), this.hBf, com.tencent.mm.b.p.getString(this.hBe) });
        }
        else
        {
          ad.e("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.userCardId is null");
        }
      }
      else if (paramView.getId() == 2131306154)
      {
        if (this.oGQ.getVisibility() == 0)
        {
          this.oGQ.setVisibility(8);
          this.oGO.setText("查看全部");
        }
        else
        {
          this.oGQ.setVisibility(0);
          this.oGO.setText("收起");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113356);
    super.onCreate(paramBundle);
    this.hBf = getIntent().getStringExtra("key_order_id");
    this.hBe = getIntent().getIntExtra("key_biz_uin", -1);
    this.oGi = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    ad.i("MicroMsg.CardGiftReceiveUI", "onCreate, orderId:%s, bizUin:%s", new Object[] { this.hBf, Integer.valueOf(this.hBe) });
    initView();
    com.tencent.mm.kernel.g.ajB().gAO.a(1165, this);
    com.tencent.mm.kernel.g.ajB().gAO.a(1099, this);
    com.tencent.mm.plugin.card.d.a.a(this.oHk);
    if (this.oGi == null)
    {
      ad.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo is null, sync GiftCard from serve");
      if (this.hBe == -1)
      {
        ad.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, bizUin is -1, fail!");
        AppMethodBeat.o(113356);
        return;
      }
      if (this.hBf == null) {
        ad.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, orderId is null, fail");
      }
      ad.e("MicroMsg.CardGiftReceiveUI", "doNetSceneGetCardGiftInfo");
      paramBundle = new z(this.hBe, this.hBf);
      com.tencent.mm.kernel.g.ajB().gAO.a(paramBundle, 0);
      this.tipDialog = h.b(getContext(), getString(2131760709), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(215401);
          if ((CardGiftReceiveUI.c(CardGiftReceiveUI.this) != null) && (CardGiftReceiveUI.c(CardGiftReceiveUI.this).isShowing())) {
            CardGiftReceiveUI.c(CardGiftReceiveUI.this).dismiss();
          }
          if ((CardGiftReceiveUI.d(CardGiftReceiveUI.this).getVisibility() == 8) || (CardGiftReceiveUI.e(CardGiftReceiveUI.this).getVisibility() == 4))
          {
            ad.i("MicroMsg.CardGiftReceiveUI", "user cancel & finish");
            CardGiftReceiveUI.this.finish();
          }
          AppMethodBeat.o(215401);
        }
      });
      if (this.tipDialog != null) {
        this.tipDialog.show();
      }
      AppMethodBeat.o(113356);
      return;
    }
    bVy();
    AppMethodBeat.o(113356);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113357);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajB().gAO.b(1165, this);
    com.tencent.mm.kernel.g.ajB().gAO.b(1099, this);
    com.tencent.mm.plugin.card.d.a.b(this.oHk);
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
        this.oGi = ((z)paramn).ozT;
        bVy();
        AppMethodBeat.o(113369);
        return;
      }
      if ((paramn instanceof t))
      {
        paramString = new Intent(this, CardDetailUI.class);
        Object localObject = ((t)paramn).ozW;
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
        paramString.putExtra("key_card_git_info", this.oGi);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.mq(0));
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
      int i = CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyF.size();
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
      CardGiftInfo.AccepterItem localAccepterItem = (CardGiftInfo.AccepterItem)CardGiftReceiveUI.a(CardGiftReceiveUI.this).oyF.get(paramInt);
      ImageView localImageView;
      String str;
      if (paramView == null)
      {
        paramView = View.inflate(CardGiftReceiveUI.this, 2131493278, null);
        paramViewGroup = new CardGiftReceiveUI.b(CardGiftReceiveUI.this);
        paramViewGroup.oHo = ((ImageView)paramView.findViewById(2131300983));
        paramViewGroup.oHp = ((TextView)paramView.findViewById(2131306105));
        paramViewGroup.gnM = ((TextView)paramView.findViewById(2131306107));
        paramViewGroup.oHq = ((TextView)paramView.findViewById(2131306106));
        paramView.setTag(paramViewGroup);
        if (localAccepterItem != null) {
          if (localAccepterItem.oyW != null)
          {
            localImageView = paramViewGroup.oHo;
            str = localAccepterItem.oyW;
            if ((localImageView != null) && (!TextUtils.isEmpty(str))) {
              break label229;
            }
          }
        }
      }
      for (;;)
      {
        paramViewGroup.oHp.setText(localAccepterItem.oyV);
        paramViewGroup.gnM.setText(localAccepterItem.oyT);
        paramViewGroup.oHq.setText(localAccepterItem.oyU + CardGiftReceiveUI.this.getContext().getString(2131756856));
        AppMethodBeat.o(113349);
        return paramView;
        paramViewGroup = (CardGiftReceiveUI.b)paramView.getTag();
        break;
        label229:
        if (!TextUtils.isEmpty(str))
        {
          Object localObject = new c.a();
          ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.arU();
          com.tencent.mm.aw.q.aIK();
          ((c.a)localObject).idJ = null;
          ((c.a)localObject).hdP = m.Yt(str);
          ((c.a)localObject).idr = true;
          ((c.a)localObject).hfi = true;
          ((c.a)localObject).idK = 3.0F;
          ((c.a)localObject).idp = true;
          ((c.a)localObject).hdS = 34;
          ((c.a)localObject).hdR = 34;
          ((c.a)localObject).idD = 2131233400;
          localObject = ((c.a)localObject).aJc();
          com.tencent.mm.aw.q.aIJ().a(str, localImageView, (c)localObject);
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
    public TextView gnM;
    public ImageView oHo;
    public TextView oHp;
    public TextView oHq;
    
    b() {}
  }
  
  final class c
    extends BaseAdapter
  {
    private LinkedList<CardGiftInfo.AcceptedCardItem> oHr;
    
    c()
    {
      Object localObject;
      this.oHr = localObject;
    }
    
    private CardGiftInfo.AcceptedCardItem AC(int paramInt)
    {
      AppMethodBeat.i(113352);
      CardGiftInfo.AcceptedCardItem localAcceptedCardItem = (CardGiftInfo.AcceptedCardItem)this.oHr.get(paramInt);
      AppMethodBeat.o(113352);
      return localAcceptedCardItem;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(113351);
      int i = this.oHr.size();
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
      CardGiftInfo.AcceptedCardItem localAcceptedCardItem = AC(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = View.inflate(CardGiftReceiveUI.this, 2131493277, null);
        paramView = new CardGiftReceiveUI.d(CardGiftReceiveUI.this);
        paramView.gnM = ((TextView)localView.findViewById(2131306111));
        paramView.oHq = ((TextView)localView.findViewById(2131306110));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        paramViewGroup.gnM.setText(localAcceptedCardItem.oyT);
        paramViewGroup.oHq.setText(localAcceptedCardItem.oyU + CardGiftReceiveUI.this.getContext().getString(2131756856));
        AppMethodBeat.o(113353);
        return localView;
        paramViewGroup = (CardGiftReceiveUI.d)paramView.getTag();
        localView = paramView;
      }
    }
  }
  
  final class d
  {
    public TextView gnM;
    public TextView oHq;
    
    d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftReceiveUI
 * JD-Core Version:    0.7.0.1
 */