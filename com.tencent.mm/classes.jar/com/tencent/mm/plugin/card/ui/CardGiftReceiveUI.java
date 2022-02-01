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
import com.tencent.mm.ak.f;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.a.jw;
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
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.tv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  private int hDS;
  private String hDT;
  private CardGiftInfo oMK;
  private ProgressBar oMN;
  private aq oMO;
  private ScrollView oMY;
  private LinearLayout oMZ;
  private RelativeLayout oNA;
  private ImageView oNB;
  private ImageView oNC;
  private TextView oND;
  private Button oNE;
  private TextView oNF;
  private ListView oNG;
  private RelativeLayout oNH;
  private TextView oNI;
  private TextView oNJ;
  private View oNK;
  private RelativeLayout oNL;
  a.a oNM;
  private ImageView oNa;
  private TextView oNb;
  private TextView oNc;
  private ImageView oNd;
  private ImageView oNe;
  private LinearLayout oNf;
  private RelativeLayout oNg;
  private RelativeLayout oNh;
  private TextView oNi;
  private ImageView oNj;
  private TextView oNk;
  private TextView oNl;
  private TextView oNm;
  private ImageView oNn;
  private ImageView oNo;
  private View oNp;
  private TextView oNq;
  private LinearLayout oNr;
  private ListView oNs;
  private RelativeLayout oNt;
  private LinearLayout oNu;
  private ImageView oNv;
  private TextView oNw;
  private LinearLayout oNx;
  private TextView oNy;
  private RelativeLayout oNz;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public CardGiftReceiveUI()
  {
    AppMethodBeat.i(113355);
    this.tipDialog = null;
    this.oMO = new aq(Looper.getMainLooper());
    this.oNM = new a.a()
    {
      public final void ZC(String paramAnonymousString)
      {
        AppMethodBeat.i(218601);
        ae.e("MicroMsg.CardGiftReceiveUI", "CDN download pic failure! fieldId:".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(218601);
      }
      
      public final void cJ(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(218600);
        if (CardGiftReceiveUI.a(CardGiftReceiveUI.this) == null)
        {
          ae.e("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress cardGiftInfo is null return!");
          AppMethodBeat.o(218600);
          return;
        }
        if ((!bu.isNullOrNil(paramAnonymousString)) && (!bu.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oEH)) && (paramAnonymousString.equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oEH)))
        {
          ae.i("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress fromUserContentVideoUrl return!");
          AppMethodBeat.o(218600);
          return;
        }
        CardGiftReceiveUI.g(CardGiftReceiveUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(218598);
            if (CardGiftReceiveUI.f(CardGiftReceiveUI.this).getVisibility() != 0) {
              CardGiftReceiveUI.f(CardGiftReceiveUI.this).setVisibility(0);
            }
            AppMethodBeat.o(218598);
          }
        });
        AppMethodBeat.o(218600);
      }
      
      public final void ff(final String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(218602);
        ae.i("MicroMsg.CardGiftReceiveUI", "CDN  download success! fieldId:".concat(String.valueOf(paramAnonymousString1)));
        if (CardGiftReceiveUI.a(CardGiftReceiveUI.this) == null)
        {
          ae.e("MicroMsg.CardGiftReceiveUI", "CDN  download cardGiftInfo is null return!");
          AppMethodBeat.o(218602);
          return;
        }
        if ((!bu.isNullOrNil(paramAnonymousString1)) && (!bu.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oEH)) && (paramAnonymousString1.equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oEH)))
        {
          ae.i("MicroMsg.CardGiftReceiveUI", "CDN  download fromUserContentVideoUrl! return");
          AppMethodBeat.o(218602);
          return;
        }
        CardGiftReceiveUI.g(CardGiftReceiveUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(218599);
            if (CardGiftReceiveUI.f(CardGiftReceiveUI.this).getVisibility() != 8) {
              CardGiftReceiveUI.f(CardGiftReceiveUI.this).setVisibility(8);
            }
            if ((!bu.isNullOrNil(paramAnonymousString1)) && (!bu.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oEI)) && (paramAnonymousString1.equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oEI))) {
              CardGiftReceiveUI.h(CardGiftReceiveUI.this).setVisibility(0);
            }
            Bitmap localBitmap;
            for (;;)
            {
              localBitmap = u.Js(paramAnonymousString2);
              if (localBitmap != null) {
                break;
              }
              CardGiftReceiveUI.i(CardGiftReceiveUI.this).setImageResource(2131690066);
              AppMethodBeat.o(218599);
              return;
              CardGiftReceiveUI.h(CardGiftReceiveUI.this).setVisibility(8);
            }
            CardGiftReceiveUI.i(CardGiftReceiveUI.this).setImageBitmap(localBitmap);
            AppMethodBeat.o(218599);
          }
        });
        AppMethodBeat.o(218602);
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
      localTextView1.setText(localAcceptedCardItem.oFv);
      localTextView2.setText(localAcceptedCardItem.oFw + getContext().getString(2131756856));
      this.oNr.addView(localView);
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
    paramInt = com.tencent.mm.cb.a.fromDPToPix(getContext(), paramInt);
    AppMethodBeat.o(113359);
    return paramInt;
  }
  
  private void bWN()
  {
    AppMethodBeat.i(113358);
    if (this.oMK == null)
    {
      ae.e("MicroMsg.CardGiftReceiveUI", "doUpdate due to cardGiftInfo is null!");
      AppMethodBeat.o(113358);
      return;
    }
    ae.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descLayoutMode:%d", new Object[] { Integer.valueOf(this.oMK.oEW) });
    if ((this.oMK.oEW != 1) && (this.oMK.oEW == 2))
    {
      bYc();
      bYb();
      bXc();
      bYe();
      if (bu.isNullOrNil(this.oMK.oFp)) {
        break label227;
      }
      this.oNE.setVisibility(0);
      this.oNE.setText(this.oMK.oFp);
      this.oNE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(218594);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardGiftReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (!bu.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oFu))
          {
            paramAnonymousView = new d.a(CardGiftReceiveUI.this.getContext());
            paramAnonymousView.aZi(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oFu);
            paramAnonymousView.afV(2131755691);
            paramAnonymousView.afU(2131755270);
            paramAnonymousView.a(true, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(218593);
                if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).oFq == 1)
                {
                  if ("cardhomepage".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oFr))
                  {
                    paramAnonymous2DialogInterface = new jw();
                    paramAnonymous2DialogInterface.dxT.context = CardGiftReceiveUI.this.getContext();
                    com.tencent.mm.sdk.b.a.IvT.l(paramAnonymous2DialogInterface);
                    AppMethodBeat.o(218593);
                    return;
                  }
                  if ("cardhomepage/couponandgiftcard".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oFr))
                  {
                    if (((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IZB, Boolean.FALSE)).booleanValue())
                    {
                      paramAnonymous2DialogInterface = new Intent();
                      paramAnonymous2DialogInterface.putExtra("scene", 1);
                      com.tencent.mm.br.d.b(CardGiftReceiveUI.this.getContext(), "card", ".ui.v3.CouponCardListUI", paramAnonymous2DialogInterface);
                      AppMethodBeat.o(218593);
                      return;
                    }
                    paramAnonymous2DialogInterface = new jw();
                    paramAnonymous2DialogInterface.dxT.context = CardGiftReceiveUI.this.getContext();
                    com.tencent.mm.sdk.b.a.IvT.l(paramAnonymous2DialogInterface);
                    AppMethodBeat.o(218593);
                  }
                }
                else if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).oFq == 2)
                {
                  com.tencent.mm.plugin.card.d.b.Q(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oFb, CardGiftReceiveUI.a(CardGiftReceiveUI.this).oFs, CardGiftReceiveUI.a(CardGiftReceiveUI.this).oFt);
                }
                AppMethodBeat.o(218593);
              }
            });
            paramAnonymousView.fQv().show();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(218594);
            return;
            if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).oFq == 1)
            {
              if ("cardhomepage".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oFr))
              {
                paramAnonymousView = new jw();
                paramAnonymousView.dxT.context = CardGiftReceiveUI.this.getContext();
                com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
              }
              else if ("cardhomepage/couponandgiftcard".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oFr))
              {
                if (((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IZB, Boolean.FALSE)).booleanValue())
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("scene", 1);
                  com.tencent.mm.br.d.b(CardGiftReceiveUI.this.getContext(), "card", ".ui.v3.CouponCardListUI", paramAnonymousView);
                }
                else
                {
                  paramAnonymousView = new jw();
                  paramAnonymousView.dxT.context = CardGiftReceiveUI.this.getContext();
                  com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
                }
              }
            }
            else if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).oFq == 2) {
              com.tencent.mm.plugin.card.d.b.Q(CardGiftReceiveUI.a(CardGiftReceiveUI.this).oFb, CardGiftReceiveUI.a(CardGiftReceiveUI.this).oFs, CardGiftReceiveUI.a(CardGiftReceiveUI.this).oFt);
            }
          }
        }
      });
    }
    for (;;)
    {
      if ((bu.isNullOrNil(this.oMK.oFc)) && (bu.isNullOrNil(this.oMK.footerWording)) && (bu.isNullOrNil(this.oMK.oFm)) && (bu.isNullOrNil(this.oMK.oFn))) {
        break label239;
      }
      this.oMY.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(218595);
          int i = com.tencent.mm.cb.a.fromDPToPix(CardGiftReceiveUI.this.getContext(), 67);
          int j = CardGiftReceiveUI.b(CardGiftReceiveUI.this).getChildAt(0).getHeight() + i;
          int k = CardGiftReceiveUI.this.getWindow().findViewById(16908290).getHeight();
          ae.i("MicroMsg.CardGiftReceiveUI", "bottomHeight: %d  totalViewHeight:%d  screenHeight:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
          CardGiftReceiveUI.b(CardGiftReceiveUI.this).setFillViewport(true);
          if (j > k) {
            CardGiftReceiveUI.a(CardGiftReceiveUI.this, true);
          }
          for (;;)
          {
            CardGiftReceiveUI.b(CardGiftReceiveUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            AppMethodBeat.o(218595);
            return;
            CardGiftReceiveUI.a(CardGiftReceiveUI.this, false);
          }
        }
      });
      AppMethodBeat.o(113358);
      return;
      bYd();
      break;
      label227:
      this.oNE.setVisibility(8);
    }
    label239:
    this.oMY.setFillViewport(true);
    AppMethodBeat.o(113358);
  }
  
  private void bXc()
  {
    int i = 0;
    AppMethodBeat.i(113364);
    if (this.oMK.oFg.size() > 0)
    {
      this.oNp.setVisibility(0);
      this.oNs.setVisibility(8);
      if (this.oMK.oFg.size() <= 2)
      {
        this.oNq.setVisibility(8);
        R(this.oMK.oFg);
        AppMethodBeat.o(113364);
        return;
      }
      Object localObject = new LinkedList();
      ((LinkedList)localObject).add(this.oMK.oFg.get(0));
      ((LinkedList)localObject).add(this.oMK.oFg.get(1));
      R((LinkedList)localObject);
      this.oNq.setVisibility(0);
      this.oNq.setOnClickListener(this);
      localObject = new LinkedList();
      while (i < this.oMK.oFg.size())
      {
        if ((i != 0) && (i != 1)) {
          ((LinkedList)localObject).add(this.oMK.oFg.get(i));
        }
        i += 1;
      }
      localObject = new c((LinkedList)localObject);
      this.oNs.setAdapter((ListAdapter)localObject);
      a(this.oNs);
      AppMethodBeat.o(113364);
      return;
    }
    this.oNp.setVisibility(8);
    this.oNq.setVisibility(8);
    this.oNs.setVisibility(8);
    AppMethodBeat.o(113364);
  }
  
  private void bYb()
  {
    AppMethodBeat.i(113360);
    if (this.oMK.oFj == 1)
    {
      this.oNu.setVisibility(0);
      this.oNx.setVisibility(8);
      this.oNt.setVisibility(8);
      this.oNw.setText(k.b(this, this.oMK.dGJ, this.oNw.getTextSize()));
      f(this.oNv);
      AppMethodBeat.o(113360);
      return;
    }
    this.oNu.setVisibility(8);
    this.oNx.setVisibility(0);
    this.oNt.setVisibility(0);
    f(this.oNC);
    this.oND.setText(k.b(this, this.oMK.dGJ, this.oND.getTextSize()));
    if (((!bu.isNullOrNil(this.oMK.oEG)) && (!"undefined".equals(this.oMK.oEG))) || ((!bu.isNullOrNil(this.oMK.oEH)) && (!"undefined".equals(this.oMK.oEH)))) {
      this.oNz.setVisibility(0);
    }
    for (;;)
    {
      bYf();
      if (!bu.isNullOrNil(this.oMK.oEF)) {
        this.oNy.setText(k.b(this, this.oMK.oEF, this.oNy.getTextSize()));
      }
      AppMethodBeat.o(113360);
      return;
      this.oNz.setVisibility(8);
      ae.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is empty");
    }
  }
  
  private void bYc()
  {
    AppMethodBeat.i(113362);
    this.oNf.setVisibility(8);
    this.oMZ.setVisibility(0);
    this.oNb.setText(this.oMK.oEU);
    this.oNc.setText(this.oMK.oEO + "     " + this.oMK.oEP + getContext().getString(2131756856));
    Object localObject;
    if (!bu.isNullOrNil(this.oMK.oEV))
    {
      this.oNa.setVisibility(0);
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.asj();
      com.tencent.mm.av.q.aJc();
      ((c.a)localObject).igB = null;
      ((c.a)localObject).hgD = m.Zk(this.oMK.oEV);
      ((c.a)localObject).igk = true;
      ((c.a)localObject).igi = true;
      localObject = ((c.a)localObject).aJu();
      com.tencent.mm.av.q.aJb().a(this.oMK.oEV, this.oNa, (c)localObject);
      if (bu.isNullOrNil(this.oMK.oEY)) {
        break label506;
      }
      this.oNb.setTextColor(bu.cN(this.oMK.oEY, getResources().getColor(2131100711)));
      label224:
      if (bu.isNullOrNil(this.oMK.oEZ)) {
        break label518;
      }
      this.oNc.setTextColor(bu.cN(this.oMK.oEZ, getResources().getColor(2131100711)));
      label264:
      if (bu.isNullOrNil(this.oMK.oEN)) {
        break label530;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.asj();
      com.tencent.mm.av.q.aJc();
      ((c.a)localObject).igB = null;
      ((c.a)localObject).hgD = m.Zk(this.oMK.oEN);
      ((c.a)localObject).hhW = true;
      ((c.a)localObject).igk = true;
      ((c.a)localObject).igi = true;
      ((c.a)localObject).hgI = new ColorDrawable(l.ZY("#CCCCCC"));
      localObject = ((c.a)localObject).aJu();
      com.tencent.mm.av.q.aJb().a(this.oMK.oEN, this.oNe, (c)localObject);
    }
    for (;;)
    {
      if (bu.isNullOrNil(this.oMK.oEM)) {
        break label542;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.asj();
      com.tencent.mm.av.q.aJc();
      ((c.a)localObject).igB = null;
      ((c.a)localObject).hgD = m.Zk(this.oMK.oEM);
      ((c.a)localObject).igk = true;
      ((c.a)localObject).igi = true;
      ((c.a)localObject).hgI = new ColorDrawable(l.ZY("#CCCCCC"));
      ((c.a)localObject).hhW = true;
      ((c.a)localObject).igC = com.tencent.mm.cb.a.fromDPToPix(this, 8);
      localObject = ((c.a)localObject).aJu();
      com.tencent.mm.av.q.aJb().a(this.oMK.oEM, this.oNd, (c)localObject);
      AppMethodBeat.o(113362);
      return;
      this.oNa.setVisibility(8);
      break;
      label506:
      ae.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
      break label224;
      label518:
      ae.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
      break label264;
      label530:
      ae.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
    }
    label542:
    ae.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
    AppMethodBeat.o(113362);
  }
  
  private void bYd()
  {
    AppMethodBeat.i(113363);
    this.oMZ.setVisibility(8);
    this.oNf.setVisibility(0);
    this.oNk.setText(this.oMK.oEO);
    Object localObject;
    if (this.oMK.oFj == 1)
    {
      this.oNn.setAlpha(0.5F);
      this.oNl.setVisibility(8);
      this.oNm.setVisibility(8);
      this.oNh.setVisibility(8);
      this.oNg.setVisibility(8);
      if (bu.isNullOrNil(this.oMK.oEV)) {
        break label672;
      }
      this.oNj.setVisibility(0);
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.asj();
      com.tencent.mm.av.q.aJc();
      ((c.a)localObject).igB = null;
      ((c.a)localObject).hgD = m.Zk(this.oMK.oEV);
      ((c.a)localObject).igk = true;
      ((c.a)localObject).igi = true;
      localObject = ((c.a)localObject).aJu();
      com.tencent.mm.av.q.aJb().a(this.oMK.oEV, this.oNj, (c)localObject);
      label186:
      if (bu.isNullOrNil(this.oMK.oEU)) {
        break label705;
      }
      this.oNi.setVisibility(0);
      this.oNi.setText(this.oMK.oEU);
      if (bu.isNullOrNil(this.oMK.oEY)) {
        break label693;
      }
      this.oNi.setTextColor(bu.cN(this.oMK.oEY, getResources().getColor(2131100711)));
      label261:
      if (bu.isNullOrNil(this.oMK.oEZ)) {
        break label726;
      }
      this.oNk.setTextColor(bu.cN(this.oMK.oEZ, getResources().getColor(2131100711)));
      label301:
      if (bu.isNullOrNil(this.oMK.oEN)) {
        break label738;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.asj();
      com.tencent.mm.av.q.aJc();
      ((c.a)localObject).igB = null;
      ((c.a)localObject).hgD = m.Zk(this.oMK.oEN);
      ((c.a)localObject).hhW = true;
      ((c.a)localObject).igk = true;
      ((c.a)localObject).igi = true;
      ((c.a)localObject).hgI = new ColorDrawable(l.ZY("#CCCCCC"));
      localObject = ((c.a)localObject).aJu();
      com.tencent.mm.av.q.aJb().a(this.oMK.oEN, this.oNo, (c)localObject);
    }
    for (;;)
    {
      if (bu.isNullOrNil(this.oMK.oEM)) {
        break label750;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.asj();
      com.tencent.mm.av.q.aJc();
      ((c.a)localObject).igB = null;
      ((c.a)localObject).hgD = m.Zk(this.oMK.oEM);
      ((c.a)localObject).igk = true;
      ((c.a)localObject).igi = true;
      ((c.a)localObject).hgI = new ColorDrawable(l.ZY("#CCCCCC"));
      ((c.a)localObject).hhW = true;
      ((c.a)localObject).igC = com.tencent.mm.cb.a.fromDPToPix(this, 8);
      localObject = ((c.a)localObject).aJu();
      com.tencent.mm.av.q.aJb().a(this.oMK.oEM, this.oNn, (c)localObject);
      AppMethodBeat.o(113363);
      return;
      this.oNl.setVisibility(0);
      this.oNm.setVisibility(0);
      this.oNh.setVisibility(0);
      this.oNg.setVisibility(0);
      this.oNl.setText(this.oMK.oEP);
      this.oNm.setText(2131756856);
      if (bu.isNullOrNil(this.oMK.oEP))
      {
        this.oNl.setVisibility(8);
        this.oNm.setVisibility(8);
      }
      if (!bu.isNullOrNil(this.oMK.oFa))
      {
        this.oNl.setTextColor(bu.cN(this.oMK.oFa, getResources().getColor(2131100711)));
        break;
      }
      ae.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardPriceTitleColor is empty");
      break;
      label672:
      this.oNj.setVisibility(8);
      ae.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
      break label186;
      label693:
      ae.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
      break label261;
      label705:
      this.oNi.setVisibility(8);
      ae.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
      break label261;
      label726:
      ae.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
      break label301;
      label738:
      ae.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
    }
    label750:
    ae.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
    AppMethodBeat.o(113363);
  }
  
  private void bYe()
  {
    AppMethodBeat.i(113366);
    if (this.oMK.oFh.size() > 0)
    {
      this.oNH.setVisibility(0);
      this.oNG.setVisibility(0);
      a locala = new a();
      this.oNG.setAdapter(locala);
      a(this.oNG);
      if (!bu.isNullOrNil(this.oMK.oFi))
      {
        this.oNF.setVisibility(0);
        this.oNF.setText(this.oMK.oFi);
      }
      AppMethodBeat.o(113366);
      return;
    }
    if (!bu.isNullOrNil(this.oMK.oFi))
    {
      this.oNH.setVisibility(0);
      this.oNF.setVisibility(0);
      this.oNF.setText(this.oMK.oFi);
      this.oNG.setVisibility(8);
      AppMethodBeat.o(113366);
      return;
    }
    this.oNH.setVisibility(8);
    this.oNF.setVisibility(8);
    this.oNG.setVisibility(8);
    AppMethodBeat.o(113366);
  }
  
  private void bYf()
  {
    AppMethodBeat.i(113370);
    if ((this.oMK != null) && (!bu.isNullOrNil(this.oMK.oEG))) {
      com.tencent.mm.plugin.card.d.a.g(this.oMK.oEG, this.oMK.oEJ, this.oMK.oER, 2);
    }
    while ((this.oMK != null) && (!bu.isNullOrNil(this.oMK.oEI)))
    {
      com.tencent.mm.plugin.card.d.a.g(this.oMK.oEI, this.oMK.oEL, this.oMK.oET, 2);
      AppMethodBeat.o(113370);
      return;
      ae.e("MicroMsg.CardGiftReceiveUI", "fromUserContentPicUrl is null");
    }
    ae.e("MicroMsg.CardGiftReceiveUI", "fromUserContentThumbPicUrl is null");
    AppMethodBeat.o(113370);
  }
  
  private void f(ImageView paramImageView)
  {
    AppMethodBeat.i(113361);
    if (!bu.isNullOrNil(this.oMK.oEE))
    {
      int i = com.tencent.mm.cb.a.fromDPToPix(this, 20);
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.asj();
      com.tencent.mm.av.q.aJc();
      ((c.a)localObject).igB = null;
      ((c.a)localObject).hgD = m.Zk(this.oMK.oEE);
      ((c.a)localObject).igk = true;
      ((c.a)localObject).hhW = true;
      ((c.a)localObject).igC = 3.0F;
      ((c.a)localObject).igi = true;
      ((c.a)localObject).hgG = i;
      ((c.a)localObject).hgF = i;
      ((c.a)localObject).hgI = new ColorDrawable(l.ZY("#CCCCCC"));
      localObject = ((c.a)localObject).aJu();
      com.tencent.mm.av.q.aJb().a(this.oMK.oEE, paramImageView, (c)localObject);
      AppMethodBeat.o(113361);
      return;
    }
    ae.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is null");
    AppMethodBeat.o(113361);
  }
  
  public int getLayoutId()
  {
    return 2131493282;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113368);
    this.oMY = ((ScrollView)findViewById(2131297811));
    this.oMZ = ((LinearLayout)findViewById(2131297913));
    this.oNa = ((ImageView)findViewById(2131301223));
    this.oNb = ((TextView)findViewById(2131306153));
    this.oNc = ((TextView)findViewById(2131306152));
    this.oNd = ((ImageView)findViewById(2131301221));
    this.oNe = ((ImageView)findViewById(2131301222));
    this.oNd.setOnClickListener(this);
    this.oNf = ((LinearLayout)findViewById(2131297912));
    this.oNg = ((RelativeLayout)findViewById(2131297206));
    this.oNh = ((RelativeLayout)findViewById(2131297209));
    this.oNi = ((TextView)findViewById(2131306118));
    this.oNk = ((TextView)findViewById(2131306149));
    this.oNj = ((ImageView)findViewById(2131301219));
    this.oNl = ((TextView)findViewById(2131306158));
    this.oNm = ((TextView)findViewById(2131306159));
    this.oNn = ((ImageView)findViewById(2131301210));
    this.oNo = ((ImageView)findViewById(2131301211));
    this.oNn.setOnClickListener(this);
    this.oNp = findViewById(2131297853);
    this.oNq = ((TextView)findViewById(2131306154));
    this.oNr = ((LinearLayout)findViewById(2131297852));
    this.oNs = ((ListView)findViewById(2131297854));
    this.oNt = ((RelativeLayout)findViewById(2131297800));
    this.oNu = ((LinearLayout)findViewById(2131300593));
    this.oNv = ((ImageView)findViewById(2131301213));
    this.oNw = ((TextView)findViewById(2131306131));
    this.oNx = ((LinearLayout)findViewById(2131300592));
    this.oNC = ((ImageView)findViewById(2131301212));
    this.oND = ((TextView)findViewById(2131306130));
    this.oNy = ((TextView)findViewById(2131306129));
    this.oNz = ((RelativeLayout)findViewById(2131297829));
    this.oNA = ((RelativeLayout)findViewById(2131300993));
    this.oNB = ((ImageView)findViewById(2131306134));
    this.oNz.setOnClickListener(this);
    this.oNA.setOnClickListener(this);
    this.oNF = ((TextView)findViewById(2131306104));
    this.oNG = ((ListView)findViewById(2131296324));
    this.oNH = ((RelativeLayout)findViewById(2131297798));
    this.oNE = ((Button)findViewById(2131297839));
    this.oMN = ((ProgressBar)findViewById(2131300950));
    com.tencent.mm.plugin.card.d.n.d(this);
    setMMTitle("");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(218596);
        CardGiftReceiveUI.this.finish();
        AppMethodBeat.o(218596);
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    if (paramView.getId() == 2131300993) {
      if (!bu.isNullOrNil(this.oMK.oEH))
      {
        paramView = new Intent(this, CardGiftVideoUI.class);
        paramView.putExtra("key_gift_into", this.oMK);
        paramView.putExtra("key_is_mute", false);
        paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramView.ahE(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramView.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        overridePendingTransition(0, 0);
        com.tencent.mm.plugin.report.service.g.yxI.f(13866, new Object[] { Integer.valueOf(3), this.hDT, com.tencent.mm.b.p.getString(this.hDS) });
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113371);
      return;
      if (paramView.getId() == 2131297829)
      {
        if (this.oMN.getVisibility() == 0)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113371);
          return;
        }
        if (!bu.isNullOrNil(this.oMK.oEG))
        {
          paramView = new Intent(this, CardGiftImageUI.class);
          paramView.putExtra("key_gift_into", this.oMK);
          paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramView.ahE(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramView.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          overridePendingTransition(0, 0);
          com.tencent.mm.plugin.report.service.g.yxI.f(13866, new Object[] { Integer.valueOf(4), this.hDT, com.tencent.mm.b.p.getString(this.hDS) });
        }
      }
      else if (paramView.getId() == 2131306127)
      {
        if ((this.oMK != null) && (this.oMK.oEQ))
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(13866, new Object[] { Integer.valueOf(7), this.hDT, com.tencent.mm.b.p.getString(this.hDS) });
          if ("cardhomepage/couponandgiftcard".equals(this.oMK.oFo)) {
            if (((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IZB, Boolean.FALSE)).booleanValue())
            {
              paramView = new Intent();
              paramView.putExtra("scene", 1);
              com.tencent.mm.br.d.b(getContext(), "card", ".ui.v3.CouponCardListUI", paramView);
            }
          }
          for (;;)
          {
            finish();
            overridePendingTransition(0, 0);
            break;
            paramView = new jw();
            paramView.dxT.context = getContext();
            com.tencent.mm.sdk.b.a.IvT.l(paramView);
            continue;
            paramView = new jw();
            paramView.dxT.context = getContext();
            paramView.dxT.scene = 2;
            com.tencent.mm.sdk.b.a.IvT.l(paramView);
            ae.i("MicroMsg.CardGiftReceiveUI", "enter to cardhome");
          }
        }
      }
      else if (paramView.getId() == 2131306128)
      {
        if ((!TextUtils.isEmpty(this.oMK.oFk)) && (!TextUtils.isEmpty(this.oMK.oFl)))
        {
          int i = getIntent().getIntExtra("key_from_appbrand_type", 0);
          com.tencent.mm.plugin.card.d.b.d(this.oMK.oFb, this.oMK.oFk, this.oMK.oFl, 1062, i);
          com.tencent.mm.plugin.report.service.g.yxI.f(13866, new Object[] { Integer.valueOf(8), this.hDT, com.tencent.mm.b.p.getString(this.hDS) });
        }
        else if (!bu.isNullOrNil(this.oMK.oFd))
        {
          com.tencent.mm.plugin.card.d.b.a(this, this.oMK.oFd, 0);
          com.tencent.mm.plugin.report.service.g.yxI.f(13866, new Object[] { Integer.valueOf(8), this.hDT, com.tencent.mm.b.p.getString(this.hDS) });
        }
      }
      else if ((paramView.getId() == 2131301210) || (paramView.getId() == 2131301221))
      {
        if ((!bu.isNullOrNil(this.oMK.oFe)) && (!bu.isNullOrNil(this.oMK.oFf)))
        {
          paramView = new LinkedList();
          localObject = new tv();
          ((tv)localObject).oEo = this.oMK.oFe;
          ((tv)localObject).code = this.oMK.oFf;
          paramView.add(localObject);
          localObject = getIntent().getStringExtra("key_template_id");
          diy localdiy = new diy();
          localdiy.HQD = ((String)localObject);
          ae.i("MicroMsg.CardGiftReceiveUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { localObject });
          paramView = new t(paramView, localdiy, 27);
          com.tencent.mm.kernel.g.ajQ().gDv.a(paramView, 0);
          com.tencent.mm.plugin.report.service.g.yxI.f(13866, new Object[] { Integer.valueOf(9), this.hDT, com.tencent.mm.b.p.getString(this.hDS) });
        }
        else
        {
          ae.e("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.userCardId is null");
        }
      }
      else if (paramView.getId() == 2131306154)
      {
        if (this.oNs.getVisibility() == 0)
        {
          this.oNs.setVisibility(8);
          this.oNq.setText("查看全部");
        }
        else
        {
          this.oNs.setVisibility(0);
          this.oNq.setText("收起");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113356);
    super.onCreate(paramBundle);
    this.hDT = getIntent().getStringExtra("key_order_id");
    this.hDS = getIntent().getIntExtra("key_biz_uin", -1);
    this.oMK = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    ae.i("MicroMsg.CardGiftReceiveUI", "onCreate, orderId:%s, bizUin:%s", new Object[] { this.hDT, Integer.valueOf(this.hDS) });
    initView();
    com.tencent.mm.kernel.g.ajQ().gDv.a(1165, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1099, this);
    com.tencent.mm.plugin.card.d.a.a(this.oNM);
    if (this.oMK == null)
    {
      ae.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo is null, sync GiftCard from serve");
      if (this.hDS == -1)
      {
        ae.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, bizUin is -1, fail!");
        AppMethodBeat.o(113356);
        return;
      }
      if (this.hDT == null) {
        ae.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, orderId is null, fail");
      }
      ae.e("MicroMsg.CardGiftReceiveUI", "doNetSceneGetCardGiftInfo");
      paramBundle = new z(this.hDS, this.hDT);
      com.tencent.mm.kernel.g.ajQ().gDv.a(paramBundle, 0);
      this.tipDialog = h.b(getContext(), getString(2131760709), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(218597);
          if ((CardGiftReceiveUI.c(CardGiftReceiveUI.this) != null) && (CardGiftReceiveUI.c(CardGiftReceiveUI.this).isShowing())) {
            CardGiftReceiveUI.c(CardGiftReceiveUI.this).dismiss();
          }
          if ((CardGiftReceiveUI.d(CardGiftReceiveUI.this).getVisibility() == 8) || (CardGiftReceiveUI.e(CardGiftReceiveUI.this).getVisibility() == 4))
          {
            ae.i("MicroMsg.CardGiftReceiveUI", "user cancel & finish");
            CardGiftReceiveUI.this.finish();
          }
          AppMethodBeat.o(218597);
        }
      });
      if (this.tipDialog != null) {
        this.tipDialog.show();
      }
      AppMethodBeat.o(113356);
      return;
    }
    bWN();
    AppMethodBeat.o(113356);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113357);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajQ().gDv.b(1165, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1099, this);
    com.tencent.mm.plugin.card.d.a.b(this.oNM);
    AppMethodBeat.o(113357);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(113369);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof z))
      {
        ae.i("MicroMsg.CardGiftReceiveUI", "card gift info cgi success!");
        this.oMK = ((z)paramn).oGv;
        bWN();
        AppMethodBeat.o(113369);
        return;
      }
      if ((paramn instanceof t))
      {
        paramString = new Intent(this, CardDetailUI.class);
        Object localObject = ((t)paramn).oGy;
        if ((localObject == null) || (((LinkedList)localObject).size() == 0))
        {
          ae.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardinfo list  size is null or empty!");
          AppMethodBeat.o(113369);
          return;
        }
        paramn = (com.tencent.mm.plugin.card.base.b)((LinkedList)localObject).get(0);
        if ((paramn == null) || (!(paramn instanceof CardInfo)))
        {
          ae.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardInfo  is null!");
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
        paramString.putExtra("key_card_git_info", this.oMK);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(113369);
      }
    }
    else
    {
      if ((paramn instanceof z))
      {
        ae.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        com.tencent.mm.plugin.card.d.d.a(this, paramString, true);
        AppMethodBeat.o(113369);
        return;
      }
      if ((paramn instanceof t))
      {
        ae.e("MicroMsg.CardGiftReceiveUI", ", NetSceneBatchGetCardItemByTpInfo onSceneEnd fail return!  errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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
      int i = CardGiftReceiveUI.a(CardGiftReceiveUI.this).oFh.size();
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
      CardGiftInfo.AccepterItem localAccepterItem = (CardGiftInfo.AccepterItem)CardGiftReceiveUI.a(CardGiftReceiveUI.this).oFh.get(paramInt);
      ImageView localImageView;
      String str;
      if (paramView == null)
      {
        paramView = View.inflate(CardGiftReceiveUI.this, 2131493278, null);
        paramViewGroup = new CardGiftReceiveUI.b(CardGiftReceiveUI.this);
        paramViewGroup.oNQ = ((ImageView)paramView.findViewById(2131300983));
        paramViewGroup.oNR = ((TextView)paramView.findViewById(2131306105));
        paramViewGroup.gqi = ((TextView)paramView.findViewById(2131306107));
        paramViewGroup.oNS = ((TextView)paramView.findViewById(2131306106));
        paramView.setTag(paramViewGroup);
        if (localAccepterItem != null) {
          if (localAccepterItem.oFy != null)
          {
            localImageView = paramViewGroup.oNQ;
            str = localAccepterItem.oFy;
            if ((localImageView != null) && (!TextUtils.isEmpty(str))) {
              break label229;
            }
          }
        }
      }
      for (;;)
      {
        paramViewGroup.oNR.setText(localAccepterItem.oFx);
        paramViewGroup.gqi.setText(localAccepterItem.oFv);
        paramViewGroup.oNS.setText(localAccepterItem.oFw + CardGiftReceiveUI.this.getContext().getString(2131756856));
        AppMethodBeat.o(113349);
        return paramView;
        paramViewGroup = (CardGiftReceiveUI.b)paramView.getTag();
        break;
        label229:
        if (!TextUtils.isEmpty(str))
        {
          Object localObject = new c.a();
          ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.asj();
          com.tencent.mm.av.q.aJc();
          ((c.a)localObject).igB = null;
          ((c.a)localObject).hgD = m.Zk(str);
          ((c.a)localObject).igk = true;
          ((c.a)localObject).hhW = true;
          ((c.a)localObject).igC = 3.0F;
          ((c.a)localObject).igi = true;
          ((c.a)localObject).hgG = 34;
          ((c.a)localObject).hgF = 34;
          ((c.a)localObject).igv = 2131233400;
          localObject = ((c.a)localObject).aJu();
          com.tencent.mm.av.q.aJb().a(str, localImageView, (c)localObject);
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
    public TextView gqi;
    public ImageView oNQ;
    public TextView oNR;
    public TextView oNS;
    
    b() {}
  }
  
  final class c
    extends BaseAdapter
  {
    private LinkedList<CardGiftInfo.AcceptedCardItem> oNT;
    
    c()
    {
      Object localObject;
      this.oNT = localObject;
    }
    
    private CardGiftInfo.AcceptedCardItem AO(int paramInt)
    {
      AppMethodBeat.i(113352);
      CardGiftInfo.AcceptedCardItem localAcceptedCardItem = (CardGiftInfo.AcceptedCardItem)this.oNT.get(paramInt);
      AppMethodBeat.o(113352);
      return localAcceptedCardItem;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(113351);
      int i = this.oNT.size();
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
      CardGiftInfo.AcceptedCardItem localAcceptedCardItem = AO(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = View.inflate(CardGiftReceiveUI.this, 2131493277, null);
        paramView = new CardGiftReceiveUI.d(CardGiftReceiveUI.this);
        paramView.gqi = ((TextView)localView.findViewById(2131306111));
        paramView.oNS = ((TextView)localView.findViewById(2131306110));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        paramViewGroup.gqi.setText(localAcceptedCardItem.oFv);
        paramViewGroup.oNS.setText(localAcceptedCardItem.oFw + CardGiftReceiveUI.this.getContext().getString(2131756856));
        AppMethodBeat.o(113353);
        return localView;
        paramViewGroup = (CardGiftReceiveUI.d)paramView.getTag();
        localView = paramView;
      }
    }
  }
  
  final class d
  {
    public TextView gqi;
    public TextView oNS;
    
    d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftReceiveUI
 * JD-Core Version:    0.7.0.1
 */