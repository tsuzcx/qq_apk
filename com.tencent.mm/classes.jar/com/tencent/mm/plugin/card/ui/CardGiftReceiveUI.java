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
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.jn;
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
import com.tencent.mm.protocal.protobuf.dcq;
import com.tencent.mm.protocal.protobuf.rz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftReceiveUI
  extends MMActivity
  implements View.OnClickListener, com.tencent.mm.ak.g
{
  private int hiV;
  private String hiW;
  private CardGiftInfo ocP;
  private ProgressBar ocS;
  private ao ocT;
  private ImageView odA;
  private TextView odB;
  private LinearLayout odC;
  private TextView odD;
  private RelativeLayout odE;
  private RelativeLayout odF;
  private ImageView odG;
  private ImageView odH;
  private TextView odI;
  private Button odJ;
  private TextView odK;
  private ListView odL;
  private RelativeLayout odM;
  private TextView odN;
  private TextView odO;
  private View odP;
  private RelativeLayout odQ;
  a.a odR;
  private ScrollView odd;
  private LinearLayout ode;
  private ImageView odf;
  private TextView odg;
  private TextView odh;
  private ImageView odi;
  private ImageView odj;
  private LinearLayout odk;
  private RelativeLayout odl;
  private RelativeLayout odm;
  private TextView odn;
  private ImageView odo;
  private TextView odp;
  private TextView odq;
  private TextView odr;
  private ImageView ods;
  private ImageView odt;
  private View odu;
  private TextView odv;
  private LinearLayout odw;
  private ListView odx;
  private RelativeLayout ody;
  private LinearLayout odz;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public CardGiftReceiveUI()
  {
    AppMethodBeat.i(113355);
    this.tipDialog = null;
    this.ocT = new ao(Looper.getMainLooper());
    this.odR = new a.a()
    {
      public final void Vc(String paramAnonymousString)
      {
        AppMethodBeat.i(206441);
        ac.e("MicroMsg.CardGiftReceiveUI", "CDN download pic failure! fieldId:".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(206441);
      }
      
      public final void cC(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(206440);
        if (CardGiftReceiveUI.a(CardGiftReceiveUI.this) == null)
        {
          ac.e("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress cardGiftInfo is null return!");
          AppMethodBeat.o(206440);
          return;
        }
        if ((!bs.isNullOrNil(paramAnonymousString)) && (!bs.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nUK)) && (paramAnonymousString.equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nUK)))
        {
          ac.i("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress fromUserContentVideoUrl return!");
          AppMethodBeat.o(206440);
          return;
        }
        CardGiftReceiveUI.g(CardGiftReceiveUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(206438);
            if (CardGiftReceiveUI.f(CardGiftReceiveUI.this).getVisibility() != 0) {
              CardGiftReceiveUI.f(CardGiftReceiveUI.this).setVisibility(0);
            }
            AppMethodBeat.o(206438);
          }
        });
        AppMethodBeat.o(206440);
      }
      
      public final void eR(final String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(206442);
        ac.i("MicroMsg.CardGiftReceiveUI", "CDN  download success! fieldId:".concat(String.valueOf(paramAnonymousString1)));
        if (CardGiftReceiveUI.a(CardGiftReceiveUI.this) == null)
        {
          ac.e("MicroMsg.CardGiftReceiveUI", "CDN  download cardGiftInfo is null return!");
          AppMethodBeat.o(206442);
          return;
        }
        if ((!bs.isNullOrNil(paramAnonymousString1)) && (!bs.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nUK)) && (paramAnonymousString1.equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nUK)))
        {
          ac.i("MicroMsg.CardGiftReceiveUI", "CDN  download fromUserContentVideoUrl! return");
          AppMethodBeat.o(206442);
          return;
        }
        CardGiftReceiveUI.g(CardGiftReceiveUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(206439);
            if (CardGiftReceiveUI.f(CardGiftReceiveUI.this).getVisibility() != 8) {
              CardGiftReceiveUI.f(CardGiftReceiveUI.this).setVisibility(8);
            }
            if ((!bs.isNullOrNil(paramAnonymousString1)) && (!bs.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nUL)) && (paramAnonymousString1.equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nUL))) {
              CardGiftReceiveUI.h(CardGiftReceiveUI.this).setVisibility(0);
            }
            Bitmap localBitmap;
            for (;;)
            {
              localBitmap = u.FE(paramAnonymousString2);
              if (localBitmap != null) {
                break;
              }
              CardGiftReceiveUI.i(CardGiftReceiveUI.this).setImageResource(2131690066);
              AppMethodBeat.o(206439);
              return;
              CardGiftReceiveUI.h(CardGiftReceiveUI.this).setVisibility(8);
            }
            CardGiftReceiveUI.i(CardGiftReceiveUI.this).setImageBitmap(localBitmap);
            AppMethodBeat.o(206439);
          }
        });
        AppMethodBeat.o(206442);
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
      localTextView1.setText(localAcceptedCardItem.nVy);
      localTextView2.setText(localAcceptedCardItem.nVz + getContext().getString(2131756856));
      this.odw.addView(localView);
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
  
  private void bQT()
  {
    AppMethodBeat.i(113358);
    if (this.ocP == null)
    {
      ac.e("MicroMsg.CardGiftReceiveUI", "doUpdate due to cardGiftInfo is null!");
      AppMethodBeat.o(113358);
      return;
    }
    ac.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descLayoutMode:%d", new Object[] { Integer.valueOf(this.ocP.nUZ) });
    if ((this.ocP.nUZ != 1) && (this.ocP.nUZ == 2))
    {
      bSi();
      bSh();
      bRi();
      bSk();
      if (bs.isNullOrNil(this.ocP.nVs)) {
        break label227;
      }
      this.odJ.setVisibility(0);
      this.odJ.setText(this.ocP.nVs);
      this.odJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(206434);
          if (!bs.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nVx))
          {
            paramAnonymousView = new d.a(CardGiftReceiveUI.this.getContext());
            paramAnonymousView.aRI(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nVx);
            paramAnonymousView.acN(2131755691);
            paramAnonymousView.acM(2131755270);
            paramAnonymousView.a(true, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(206433);
                if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).nVt == 1)
                {
                  if ("cardhomepage".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nVu))
                  {
                    paramAnonymous2DialogInterface = new jn();
                    paramAnonymous2DialogInterface.dlb.context = CardGiftReceiveUI.this.getContext();
                    com.tencent.mm.sdk.b.a.GpY.l(paramAnonymous2DialogInterface);
                    AppMethodBeat.o(206433);
                    return;
                  }
                  if ("cardhomepage/couponandgiftcard".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nVu))
                  {
                    if (((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GSw, Boolean.FALSE)).booleanValue())
                    {
                      paramAnonymous2DialogInterface = new Intent();
                      paramAnonymous2DialogInterface.putExtra("scene", 1);
                      com.tencent.mm.br.d.b(CardGiftReceiveUI.this.getContext(), "card", ".ui.v3.CouponCardListUI", paramAnonymous2DialogInterface);
                      AppMethodBeat.o(206433);
                      return;
                    }
                    paramAnonymous2DialogInterface = new jn();
                    paramAnonymous2DialogInterface.dlb.context = CardGiftReceiveUI.this.getContext();
                    com.tencent.mm.sdk.b.a.GpY.l(paramAnonymous2DialogInterface);
                    AppMethodBeat.o(206433);
                  }
                }
                else if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).nVt == 2)
                {
                  com.tencent.mm.plugin.card.d.b.O(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nVe, CardGiftReceiveUI.a(CardGiftReceiveUI.this).nVv, CardGiftReceiveUI.a(CardGiftReceiveUI.this).nVw);
                }
                AppMethodBeat.o(206433);
              }
            });
            paramAnonymousView.fvp().show();
            AppMethodBeat.o(206434);
            return;
          }
          if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).nVt == 1)
          {
            if ("cardhomepage".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nVu))
            {
              paramAnonymousView = new jn();
              paramAnonymousView.dlb.context = CardGiftReceiveUI.this.getContext();
              com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
              AppMethodBeat.o(206434);
              return;
            }
            if ("cardhomepage/couponandgiftcard".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nVu))
            {
              if (((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GSw, Boolean.FALSE)).booleanValue())
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("scene", 1);
                com.tencent.mm.br.d.b(CardGiftReceiveUI.this.getContext(), "card", ".ui.v3.CouponCardListUI", paramAnonymousView);
                AppMethodBeat.o(206434);
                return;
              }
              paramAnonymousView = new jn();
              paramAnonymousView.dlb.context = CardGiftReceiveUI.this.getContext();
              com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
              AppMethodBeat.o(206434);
            }
          }
          else if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).nVt == 2)
          {
            com.tencent.mm.plugin.card.d.b.O(CardGiftReceiveUI.a(CardGiftReceiveUI.this).nVe, CardGiftReceiveUI.a(CardGiftReceiveUI.this).nVv, CardGiftReceiveUI.a(CardGiftReceiveUI.this).nVw);
          }
          AppMethodBeat.o(206434);
        }
      });
    }
    for (;;)
    {
      if ((bs.isNullOrNil(this.ocP.nVf)) && (bs.isNullOrNil(this.ocP.footerWording)) && (bs.isNullOrNil(this.ocP.nVp)) && (bs.isNullOrNil(this.ocP.nVq))) {
        break label239;
      }
      this.odd.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(206435);
          int i = com.tencent.mm.cc.a.fromDPToPix(CardGiftReceiveUI.this.getContext(), 67);
          int j = CardGiftReceiveUI.b(CardGiftReceiveUI.this).getChildAt(0).getHeight() + i;
          int k = CardGiftReceiveUI.this.getWindow().findViewById(16908290).getHeight();
          ac.i("MicroMsg.CardGiftReceiveUI", "bottomHeight: %d  totalViewHeight:%d  screenHeight:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
          CardGiftReceiveUI.b(CardGiftReceiveUI.this).setFillViewport(true);
          if (j > k) {
            CardGiftReceiveUI.a(CardGiftReceiveUI.this, true);
          }
          for (;;)
          {
            CardGiftReceiveUI.b(CardGiftReceiveUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            AppMethodBeat.o(206435);
            return;
            CardGiftReceiveUI.a(CardGiftReceiveUI.this, false);
          }
        }
      });
      AppMethodBeat.o(113358);
      return;
      bSj();
      break;
      label227:
      this.odJ.setVisibility(8);
    }
    label239:
    this.odd.setFillViewport(true);
    AppMethodBeat.o(113358);
  }
  
  private void bRi()
  {
    int i = 0;
    AppMethodBeat.i(113364);
    if (this.ocP.nVj.size() > 0)
    {
      this.odu.setVisibility(0);
      this.odx.setVisibility(8);
      if (this.ocP.nVj.size() <= 2)
      {
        this.odv.setVisibility(8);
        Q(this.ocP.nVj);
        AppMethodBeat.o(113364);
        return;
      }
      Object localObject = new LinkedList();
      ((LinkedList)localObject).add(this.ocP.nVj.get(0));
      ((LinkedList)localObject).add(this.ocP.nVj.get(1));
      Q((LinkedList)localObject);
      this.odv.setVisibility(0);
      this.odv.setOnClickListener(this);
      localObject = new LinkedList();
      while (i < this.ocP.nVj.size())
      {
        if ((i != 0) && (i != 1)) {
          ((LinkedList)localObject).add(this.ocP.nVj.get(i));
        }
        i += 1;
      }
      localObject = new c((LinkedList)localObject);
      this.odx.setAdapter((ListAdapter)localObject);
      a(this.odx);
      AppMethodBeat.o(113364);
      return;
    }
    this.odu.setVisibility(8);
    this.odv.setVisibility(8);
    this.odx.setVisibility(8);
    AppMethodBeat.o(113364);
  }
  
  private void bSh()
  {
    AppMethodBeat.i(113360);
    if (this.ocP.nVm == 1)
    {
      this.odz.setVisibility(0);
      this.odC.setVisibility(8);
      this.ody.setVisibility(8);
      this.odB.setText(k.b(this, this.ocP.dtD, this.odB.getTextSize()));
      f(this.odA);
      AppMethodBeat.o(113360);
      return;
    }
    this.odz.setVisibility(8);
    this.odC.setVisibility(0);
    this.ody.setVisibility(0);
    f(this.odH);
    this.odI.setText(k.b(this, this.ocP.dtD, this.odI.getTextSize()));
    if (((!bs.isNullOrNil(this.ocP.nUJ)) && (!"undefined".equals(this.ocP.nUJ))) || ((!bs.isNullOrNil(this.ocP.nUK)) && (!"undefined".equals(this.ocP.nUK)))) {
      this.odE.setVisibility(0);
    }
    for (;;)
    {
      bSl();
      if (!bs.isNullOrNil(this.ocP.nUI)) {
        this.odD.setText(k.b(this, this.ocP.nUI, this.odD.getTextSize()));
      }
      AppMethodBeat.o(113360);
      return;
      this.odE.setVisibility(8);
      ac.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is empty");
    }
  }
  
  private void bSi()
  {
    AppMethodBeat.i(113362);
    this.odk.setVisibility(8);
    this.ode.setVisibility(0);
    this.odg.setText(this.ocP.nUX);
    this.odh.setText(this.ocP.nUR + "     " + this.ocP.nUS + getContext().getString(2131756856));
    Object localObject;
    if (!bs.isNullOrNil(this.ocP.nUY))
    {
      this.odf.setVisibility(0);
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aph();
      o.aFC();
      ((c.a)localObject).hKO = null;
      ((c.a)localObject).gKe = m.UK(this.ocP.nUY);
      ((c.a)localObject).hKx = true;
      ((c.a)localObject).hKv = true;
      localObject = ((c.a)localObject).aFT();
      o.aFB().a(this.ocP.nUY, this.odf, (c)localObject);
      if (bs.isNullOrNil(this.ocP.nVb)) {
        break label506;
      }
      this.odg.setTextColor(bs.cG(this.ocP.nVb, getResources().getColor(2131100711)));
      label224:
      if (bs.isNullOrNil(this.ocP.nVc)) {
        break label518;
      }
      this.odh.setTextColor(bs.cG(this.ocP.nVc, getResources().getColor(2131100711)));
      label264:
      if (bs.isNullOrNil(this.ocP.nUQ)) {
        break label530;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aph();
      o.aFC();
      ((c.a)localObject).hKO = null;
      ((c.a)localObject).gKe = m.UK(this.ocP.nUQ);
      ((c.a)localObject).gLt = true;
      ((c.a)localObject).hKx = true;
      ((c.a)localObject).hKv = true;
      ((c.a)localObject).gKj = new ColorDrawable(l.Vy("#CCCCCC"));
      localObject = ((c.a)localObject).aFT();
      o.aFB().a(this.ocP.nUQ, this.odj, (c)localObject);
    }
    for (;;)
    {
      if (bs.isNullOrNil(this.ocP.nUP)) {
        break label542;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aph();
      o.aFC();
      ((c.a)localObject).hKO = null;
      ((c.a)localObject).gKe = m.UK(this.ocP.nUP);
      ((c.a)localObject).hKx = true;
      ((c.a)localObject).hKv = true;
      ((c.a)localObject).gKj = new ColorDrawable(l.Vy("#CCCCCC"));
      ((c.a)localObject).gLt = true;
      ((c.a)localObject).hKP = com.tencent.mm.cc.a.fromDPToPix(this, 8);
      localObject = ((c.a)localObject).aFT();
      o.aFB().a(this.ocP.nUP, this.odi, (c)localObject);
      AppMethodBeat.o(113362);
      return;
      this.odf.setVisibility(8);
      break;
      label506:
      ac.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
      break label224;
      label518:
      ac.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
      break label264;
      label530:
      ac.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
    }
    label542:
    ac.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
    AppMethodBeat.o(113362);
  }
  
  private void bSj()
  {
    AppMethodBeat.i(113363);
    this.ode.setVisibility(8);
    this.odk.setVisibility(0);
    this.odp.setText(this.ocP.nUR);
    Object localObject;
    if (this.ocP.nVm == 1)
    {
      this.ods.setAlpha(0.5F);
      this.odq.setVisibility(8);
      this.odr.setVisibility(8);
      this.odm.setVisibility(8);
      this.odl.setVisibility(8);
      if (bs.isNullOrNil(this.ocP.nUY)) {
        break label672;
      }
      this.odo.setVisibility(0);
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aph();
      o.aFC();
      ((c.a)localObject).hKO = null;
      ((c.a)localObject).gKe = m.UK(this.ocP.nUY);
      ((c.a)localObject).hKx = true;
      ((c.a)localObject).hKv = true;
      localObject = ((c.a)localObject).aFT();
      o.aFB().a(this.ocP.nUY, this.odo, (c)localObject);
      label186:
      if (bs.isNullOrNil(this.ocP.nUX)) {
        break label705;
      }
      this.odn.setVisibility(0);
      this.odn.setText(this.ocP.nUX);
      if (bs.isNullOrNil(this.ocP.nVb)) {
        break label693;
      }
      this.odn.setTextColor(bs.cG(this.ocP.nVb, getResources().getColor(2131100711)));
      label261:
      if (bs.isNullOrNil(this.ocP.nVc)) {
        break label726;
      }
      this.odp.setTextColor(bs.cG(this.ocP.nVc, getResources().getColor(2131100711)));
      label301:
      if (bs.isNullOrNil(this.ocP.nUQ)) {
        break label738;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aph();
      o.aFC();
      ((c.a)localObject).hKO = null;
      ((c.a)localObject).gKe = m.UK(this.ocP.nUQ);
      ((c.a)localObject).gLt = true;
      ((c.a)localObject).hKx = true;
      ((c.a)localObject).hKv = true;
      ((c.a)localObject).gKj = new ColorDrawable(l.Vy("#CCCCCC"));
      localObject = ((c.a)localObject).aFT();
      o.aFB().a(this.ocP.nUQ, this.odt, (c)localObject);
    }
    for (;;)
    {
      if (bs.isNullOrNil(this.ocP.nUP)) {
        break label750;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aph();
      o.aFC();
      ((c.a)localObject).hKO = null;
      ((c.a)localObject).gKe = m.UK(this.ocP.nUP);
      ((c.a)localObject).hKx = true;
      ((c.a)localObject).hKv = true;
      ((c.a)localObject).gKj = new ColorDrawable(l.Vy("#CCCCCC"));
      ((c.a)localObject).gLt = true;
      ((c.a)localObject).hKP = com.tencent.mm.cc.a.fromDPToPix(this, 8);
      localObject = ((c.a)localObject).aFT();
      o.aFB().a(this.ocP.nUP, this.ods, (c)localObject);
      AppMethodBeat.o(113363);
      return;
      this.odq.setVisibility(0);
      this.odr.setVisibility(0);
      this.odm.setVisibility(0);
      this.odl.setVisibility(0);
      this.odq.setText(this.ocP.nUS);
      this.odr.setText(2131756856);
      if (bs.isNullOrNil(this.ocP.nUS))
      {
        this.odq.setVisibility(8);
        this.odr.setVisibility(8);
      }
      if (!bs.isNullOrNil(this.ocP.nVd))
      {
        this.odq.setTextColor(bs.cG(this.ocP.nVd, getResources().getColor(2131100711)));
        break;
      }
      ac.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardPriceTitleColor is empty");
      break;
      label672:
      this.odo.setVisibility(8);
      ac.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
      break label186;
      label693:
      ac.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
      break label261;
      label705:
      this.odn.setVisibility(8);
      ac.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
      break label261;
      label726:
      ac.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
      break label301;
      label738:
      ac.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
    }
    label750:
    ac.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
    AppMethodBeat.o(113363);
  }
  
  private void bSk()
  {
    AppMethodBeat.i(113366);
    if (this.ocP.nVk.size() > 0)
    {
      this.odM.setVisibility(0);
      this.odL.setVisibility(0);
      a locala = new a();
      this.odL.setAdapter(locala);
      a(this.odL);
      if (!bs.isNullOrNil(this.ocP.nVl))
      {
        this.odK.setVisibility(0);
        this.odK.setText(this.ocP.nVl);
      }
      AppMethodBeat.o(113366);
      return;
    }
    if (!bs.isNullOrNil(this.ocP.nVl))
    {
      this.odM.setVisibility(0);
      this.odK.setVisibility(0);
      this.odK.setText(this.ocP.nVl);
      this.odL.setVisibility(8);
      AppMethodBeat.o(113366);
      return;
    }
    this.odM.setVisibility(8);
    this.odK.setVisibility(8);
    this.odL.setVisibility(8);
    AppMethodBeat.o(113366);
  }
  
  private void bSl()
  {
    AppMethodBeat.i(113370);
    if ((this.ocP != null) && (!bs.isNullOrNil(this.ocP.nUJ))) {
      com.tencent.mm.plugin.card.d.a.g(this.ocP.nUJ, this.ocP.nUM, this.ocP.nUU, 2);
    }
    while ((this.ocP != null) && (!bs.isNullOrNil(this.ocP.nUL)))
    {
      com.tencent.mm.plugin.card.d.a.g(this.ocP.nUL, this.ocP.nUO, this.ocP.nUW, 2);
      AppMethodBeat.o(113370);
      return;
      ac.e("MicroMsg.CardGiftReceiveUI", "fromUserContentPicUrl is null");
    }
    ac.e("MicroMsg.CardGiftReceiveUI", "fromUserContentThumbPicUrl is null");
    AppMethodBeat.o(113370);
  }
  
  private void f(ImageView paramImageView)
  {
    AppMethodBeat.i(113361);
    if (!bs.isNullOrNil(this.ocP.nUH))
    {
      int i = com.tencent.mm.cc.a.fromDPToPix(this, 20);
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aph();
      o.aFC();
      ((c.a)localObject).hKO = null;
      ((c.a)localObject).gKe = m.UK(this.ocP.nUH);
      ((c.a)localObject).hKx = true;
      ((c.a)localObject).gLt = true;
      ((c.a)localObject).hKP = 3.0F;
      ((c.a)localObject).hKv = true;
      ((c.a)localObject).gKh = i;
      ((c.a)localObject).gKg = i;
      ((c.a)localObject).gKj = new ColorDrawable(l.Vy("#CCCCCC"));
      localObject = ((c.a)localObject).aFT();
      o.aFB().a(this.ocP.nUH, paramImageView, (c)localObject);
      AppMethodBeat.o(113361);
      return;
    }
    ac.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is null");
    AppMethodBeat.o(113361);
  }
  
  public int getLayoutId()
  {
    return 2131493282;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113368);
    this.odd = ((ScrollView)findViewById(2131297811));
    this.ode = ((LinearLayout)findViewById(2131297913));
    this.odf = ((ImageView)findViewById(2131301223));
    this.odg = ((TextView)findViewById(2131306153));
    this.odh = ((TextView)findViewById(2131306152));
    this.odi = ((ImageView)findViewById(2131301221));
    this.odj = ((ImageView)findViewById(2131301222));
    this.odi.setOnClickListener(this);
    this.odk = ((LinearLayout)findViewById(2131297912));
    this.odl = ((RelativeLayout)findViewById(2131297206));
    this.odm = ((RelativeLayout)findViewById(2131297209));
    this.odn = ((TextView)findViewById(2131306118));
    this.odp = ((TextView)findViewById(2131306149));
    this.odo = ((ImageView)findViewById(2131301219));
    this.odq = ((TextView)findViewById(2131306158));
    this.odr = ((TextView)findViewById(2131306159));
    this.ods = ((ImageView)findViewById(2131301210));
    this.odt = ((ImageView)findViewById(2131301211));
    this.ods.setOnClickListener(this);
    this.odu = findViewById(2131297853);
    this.odv = ((TextView)findViewById(2131306154));
    this.odw = ((LinearLayout)findViewById(2131297852));
    this.odx = ((ListView)findViewById(2131297854));
    this.ody = ((RelativeLayout)findViewById(2131297800));
    this.odz = ((LinearLayout)findViewById(2131300593));
    this.odA = ((ImageView)findViewById(2131301213));
    this.odB = ((TextView)findViewById(2131306131));
    this.odC = ((LinearLayout)findViewById(2131300592));
    this.odH = ((ImageView)findViewById(2131301212));
    this.odI = ((TextView)findViewById(2131306130));
    this.odD = ((TextView)findViewById(2131306129));
    this.odE = ((RelativeLayout)findViewById(2131297829));
    this.odF = ((RelativeLayout)findViewById(2131300993));
    this.odG = ((ImageView)findViewById(2131306134));
    this.odE.setOnClickListener(this);
    this.odF.setOnClickListener(this);
    this.odK = ((TextView)findViewById(2131306104));
    this.odL = ((ListView)findViewById(2131296324));
    this.odM = ((RelativeLayout)findViewById(2131297798));
    this.odJ = ((Button)findViewById(2131297839));
    this.ocS = ((ProgressBar)findViewById(2131300950));
    com.tencent.mm.plugin.card.d.n.c(this);
    setMMTitle("");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(206436);
        CardGiftReceiveUI.this.finish();
        AppMethodBeat.o(206436);
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
      if (!bs.isNullOrNil(this.ocP.nUK))
      {
        paramView = new Intent(this, CardGiftVideoUI.class);
        paramView.putExtra("key_gift_into", this.ocP);
        paramView.putExtra("key_is_mute", false);
        paramView = new com.tencent.mm.hellhoundlib.b.a().ba(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramView.aeD(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramView.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        overridePendingTransition(0, 0);
        com.tencent.mm.plugin.report.service.h.wUl.f(13866, new Object[] { Integer.valueOf(3), this.hiW, com.tencent.mm.b.p.getString(this.hiV) });
        AppMethodBeat.o(113371);
      }
    }
    else if (paramView.getId() == 2131297829)
    {
      if (this.ocS.getVisibility() == 0)
      {
        AppMethodBeat.o(113371);
        return;
      }
      if (!bs.isNullOrNil(this.ocP.nUJ))
      {
        paramView = new Intent(this, CardGiftImageUI.class);
        paramView.putExtra("key_gift_into", this.ocP);
        paramView = new com.tencent.mm.hellhoundlib.b.a().ba(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramView.aeD(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramView.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        overridePendingTransition(0, 0);
        com.tencent.mm.plugin.report.service.h.wUl.f(13866, new Object[] { Integer.valueOf(4), this.hiW, com.tencent.mm.b.p.getString(this.hiV) });
        AppMethodBeat.o(113371);
      }
    }
    else if (paramView.getId() == 2131306127)
    {
      if ((this.ocP != null) && (this.ocP.nUT))
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(13866, new Object[] { Integer.valueOf(7), this.hiW, com.tencent.mm.b.p.getString(this.hiV) });
        if ("cardhomepage/couponandgiftcard".equals(this.ocP.nVr)) {
          if (((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GSw, Boolean.FALSE)).booleanValue())
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
          AppMethodBeat.o(113371);
          return;
          paramView = new jn();
          paramView.dlb.context = getContext();
          com.tencent.mm.sdk.b.a.GpY.l(paramView);
          continue;
          paramView = new jn();
          paramView.dlb.context = getContext();
          paramView.dlb.scene = 2;
          com.tencent.mm.sdk.b.a.GpY.l(paramView);
          ac.i("MicroMsg.CardGiftReceiveUI", "enter to cardhome");
        }
      }
    }
    else if (paramView.getId() == 2131306128)
    {
      if ((!TextUtils.isEmpty(this.ocP.nVn)) && (!TextUtils.isEmpty(this.ocP.nVo)))
      {
        int i = getIntent().getIntExtra("key_from_appbrand_type", 0);
        com.tencent.mm.plugin.card.d.b.d(this.ocP.nVe, this.ocP.nVn, this.ocP.nVo, 1062, i);
        com.tencent.mm.plugin.report.service.h.wUl.f(13866, new Object[] { Integer.valueOf(8), this.hiW, com.tencent.mm.b.p.getString(this.hiV) });
        AppMethodBeat.o(113371);
        return;
      }
      if (!bs.isNullOrNil(this.ocP.nVg))
      {
        com.tencent.mm.plugin.card.d.b.a(this, this.ocP.nVg, 0);
        com.tencent.mm.plugin.report.service.h.wUl.f(13866, new Object[] { Integer.valueOf(8), this.hiW, com.tencent.mm.b.p.getString(this.hiV) });
        AppMethodBeat.o(113371);
      }
    }
    else
    {
      if ((paramView.getId() == 2131301210) || (paramView.getId() == 2131301221))
      {
        if ((!bs.isNullOrNil(this.ocP.nVh)) && (!bs.isNullOrNil(this.ocP.nVi)))
        {
          paramView = new LinkedList();
          Object localObject = new rz();
          ((rz)localObject).nUr = this.ocP.nVh;
          ((rz)localObject).code = this.ocP.nVi;
          paramView.add(localObject);
          localObject = getIntent().getStringExtra("key_template_id");
          dcq localdcq = new dcq();
          localdcq.FMm = ((String)localObject);
          ac.i("MicroMsg.CardGiftReceiveUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { localObject });
          paramView = new t(paramView, localdcq, 27);
          com.tencent.mm.kernel.g.agQ().ghe.a(paramView, 0);
          com.tencent.mm.plugin.report.service.h.wUl.f(13866, new Object[] { Integer.valueOf(9), this.hiW, com.tencent.mm.b.p.getString(this.hiV) });
          AppMethodBeat.o(113371);
          return;
        }
        ac.e("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.userCardId is null");
        AppMethodBeat.o(113371);
        return;
      }
      if (paramView.getId() == 2131306154)
      {
        if (this.odx.getVisibility() == 0)
        {
          this.odx.setVisibility(8);
          this.odv.setText("查看全部");
          AppMethodBeat.o(113371);
          return;
        }
        this.odx.setVisibility(0);
        this.odv.setText("收起");
      }
    }
    AppMethodBeat.o(113371);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113356);
    super.onCreate(paramBundle);
    this.hiW = getIntent().getStringExtra("key_order_id");
    this.hiV = getIntent().getIntExtra("key_biz_uin", -1);
    this.ocP = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    ac.i("MicroMsg.CardGiftReceiveUI", "onCreate, orderId:%s, bizUin:%s", new Object[] { this.hiW, Integer.valueOf(this.hiV) });
    initView();
    com.tencent.mm.kernel.g.agQ().ghe.a(1165, this);
    com.tencent.mm.kernel.g.agQ().ghe.a(1099, this);
    com.tencent.mm.plugin.card.d.a.a(this.odR);
    if (this.ocP == null)
    {
      ac.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo is null, sync GiftCard from serve");
      if (this.hiV == -1)
      {
        ac.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, bizUin is -1, fail!");
        AppMethodBeat.o(113356);
        return;
      }
      if (this.hiW == null) {
        ac.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, orderId is null, fail");
      }
      ac.e("MicroMsg.CardGiftReceiveUI", "doNetSceneGetCardGiftInfo");
      paramBundle = new z(this.hiV, this.hiW);
      com.tencent.mm.kernel.g.agQ().ghe.a(paramBundle, 0);
      this.tipDialog = com.tencent.mm.ui.base.h.b(getContext(), getString(2131760709), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(206437);
          if ((CardGiftReceiveUI.c(CardGiftReceiveUI.this) != null) && (CardGiftReceiveUI.c(CardGiftReceiveUI.this).isShowing())) {
            CardGiftReceiveUI.c(CardGiftReceiveUI.this).dismiss();
          }
          if ((CardGiftReceiveUI.d(CardGiftReceiveUI.this).getVisibility() == 8) || (CardGiftReceiveUI.e(CardGiftReceiveUI.this).getVisibility() == 4))
          {
            ac.i("MicroMsg.CardGiftReceiveUI", "user cancel & finish");
            CardGiftReceiveUI.this.finish();
          }
          AppMethodBeat.o(206437);
        }
      });
      if (this.tipDialog != null) {
        this.tipDialog.show();
      }
      AppMethodBeat.o(113356);
      return;
    }
    bQT();
    AppMethodBeat.o(113356);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113357);
    super.onDestroy();
    com.tencent.mm.kernel.g.agQ().ghe.b(1165, this);
    com.tencent.mm.kernel.g.agQ().ghe.b(1099, this);
    com.tencent.mm.plugin.card.d.a.b(this.odR);
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
        ac.i("MicroMsg.CardGiftReceiveUI", "card gift info cgi success!");
        this.ocP = ((z)paramn).nWz;
        bQT();
        AppMethodBeat.o(113369);
        return;
      }
      if ((paramn instanceof t))
      {
        paramString = new Intent(this, CardDetailUI.class);
        Object localObject = ((t)paramn).nWC;
        if ((localObject == null) || (((LinkedList)localObject).size() == 0))
        {
          ac.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardinfo list  size is null or empty!");
          AppMethodBeat.o(113369);
          return;
        }
        paramn = (com.tencent.mm.plugin.card.base.b)((LinkedList)localObject).get(0);
        if ((paramn == null) || (!(paramn instanceof CardInfo)))
        {
          ac.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardInfo  is null!");
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
        paramString.putExtra("key_card_git_info", this.ocP);
        paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(113369);
      }
    }
    else
    {
      if ((paramn instanceof z))
      {
        ac.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        com.tencent.mm.plugin.card.d.d.a(this, paramString, true);
        AppMethodBeat.o(113369);
        return;
      }
      if ((paramn instanceof t))
      {
        ac.e("MicroMsg.CardGiftReceiveUI", ", NetSceneBatchGetCardItemByTpInfo onSceneEnd fail return!  errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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
      int i = CardGiftReceiveUI.a(CardGiftReceiveUI.this).nVk.size();
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
      CardGiftInfo.AccepterItem localAccepterItem = (CardGiftInfo.AccepterItem)CardGiftReceiveUI.a(CardGiftReceiveUI.this).nVk.get(paramInt);
      ImageView localImageView;
      String str;
      if (paramView == null)
      {
        paramView = View.inflate(CardGiftReceiveUI.this, 2131493278, null);
        paramViewGroup = new CardGiftReceiveUI.b(CardGiftReceiveUI.this);
        paramViewGroup.odV = ((ImageView)paramView.findViewById(2131300983));
        paramViewGroup.nyK = ((TextView)paramView.findViewById(2131306105));
        paramViewGroup.fUk = ((TextView)paramView.findViewById(2131306107));
        paramViewGroup.odW = ((TextView)paramView.findViewById(2131306106));
        paramView.setTag(paramViewGroup);
        if (localAccepterItem != null) {
          if (localAccepterItem.nVB != null)
          {
            localImageView = paramViewGroup.odV;
            str = localAccepterItem.nVB;
            if ((localImageView != null) && (!TextUtils.isEmpty(str))) {
              break label229;
            }
          }
        }
      }
      for (;;)
      {
        paramViewGroup.nyK.setText(localAccepterItem.nVA);
        paramViewGroup.fUk.setText(localAccepterItem.nVy);
        paramViewGroup.odW.setText(localAccepterItem.nVz + CardGiftReceiveUI.this.getContext().getString(2131756856));
        AppMethodBeat.o(113349);
        return paramView;
        paramViewGroup = (CardGiftReceiveUI.b)paramView.getTag();
        break;
        label229:
        if (!TextUtils.isEmpty(str))
        {
          Object localObject = new c.a();
          ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aph();
          o.aFC();
          ((c.a)localObject).hKO = null;
          ((c.a)localObject).gKe = m.UK(str);
          ((c.a)localObject).hKx = true;
          ((c.a)localObject).gLt = true;
          ((c.a)localObject).hKP = 3.0F;
          ((c.a)localObject).hKv = true;
          ((c.a)localObject).gKh = 34;
          ((c.a)localObject).gKg = 34;
          ((c.a)localObject).hKI = 2131233400;
          localObject = ((c.a)localObject).aFT();
          o.aFB().a(str, localImageView, (c)localObject);
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
    public TextView fUk;
    public TextView nyK;
    public ImageView odV;
    public TextView odW;
    
    b() {}
  }
  
  final class c
    extends BaseAdapter
  {
    private LinkedList<CardGiftInfo.AcceptedCardItem> odX;
    
    c()
    {
      Object localObject;
      this.odX = localObject;
    }
    
    private CardGiftInfo.AcceptedCardItem zT(int paramInt)
    {
      AppMethodBeat.i(113352);
      CardGiftInfo.AcceptedCardItem localAcceptedCardItem = (CardGiftInfo.AcceptedCardItem)this.odX.get(paramInt);
      AppMethodBeat.o(113352);
      return localAcceptedCardItem;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(113351);
      int i = this.odX.size();
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
      CardGiftInfo.AcceptedCardItem localAcceptedCardItem = zT(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = View.inflate(CardGiftReceiveUI.this, 2131493277, null);
        paramView = new CardGiftReceiveUI.d(CardGiftReceiveUI.this);
        paramView.fUk = ((TextView)localView.findViewById(2131306111));
        paramView.odW = ((TextView)localView.findViewById(2131306110));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        paramViewGroup.fUk.setText(localAcceptedCardItem.nVy);
        paramViewGroup.odW.setText(localAcceptedCardItem.nVz + CardGiftReceiveUI.this.getContext().getString(2131756856));
        AppMethodBeat.o(113353);
        return localView;
        paramViewGroup = (CardGiftReceiveUI.d)paramView.getTag();
        localView = paramView;
      }
    }
  }
  
  final class d
  {
    public TextView fUk;
    public TextView odW;
    
    d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftReceiveUI
 * JD-Core Version:    0.7.0.1
 */