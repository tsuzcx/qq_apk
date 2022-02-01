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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.b.p;
import com.tencent.mm.f.a.lc;
import com.tencent.mm.kernel.f;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AcceptedCardItem;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AccepterItem;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.model.z;
import com.tencent.mm.protocal.protobuf.eml;
import com.tencent.mm.protocal.protobuf.vc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftReceiveUI
  extends MMActivity
  implements View.OnClickListener, i
{
  private int lnn;
  private String lno;
  private s tipDialog;
  private ScrollView twJ;
  private LinearLayout twK;
  private ImageView twL;
  private TextView twM;
  private TextView twN;
  private ImageView twO;
  private ImageView twP;
  private LinearLayout twQ;
  private RelativeLayout twR;
  private RelativeLayout twS;
  private TextView twT;
  private ImageView twU;
  private TextView twV;
  private TextView twW;
  private TextView twX;
  private ImageView twY;
  private ImageView twZ;
  private CardGiftInfo twv;
  private ProgressBar twy;
  private MMHandler twz;
  private View txa;
  private TextView txb;
  private LinearLayout txc;
  private ListView txd;
  private RelativeLayout txe;
  private LinearLayout txf;
  private ImageView txg;
  private TextView txh;
  private LinearLayout txi;
  private TextView txj;
  private RelativeLayout txk;
  private RelativeLayout txl;
  private ImageView txm;
  private ImageView txn;
  private TextView txo;
  private Button txp;
  private TextView txq;
  private ListView txr;
  private RelativeLayout txs;
  private TextView txu;
  private TextView txv;
  private View txw;
  private RelativeLayout txx;
  com.tencent.mm.plugin.card.d.a.a txy;
  
  public CardGiftReceiveUI()
  {
    AppMethodBeat.i(113355);
    this.tipDialog = null;
    this.twz = new MMHandler(Looper.getMainLooper());
    this.txy = new com.tencent.mm.plugin.card.d.a.a()
    {
      public final void aru(String paramAnonymousString)
      {
        AppMethodBeat.i(245056);
        Log.e("MicroMsg.CardGiftReceiveUI", "CDN download pic failure! fieldId:".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(245056);
      }
      
      public final void dj(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(245053);
        if (CardGiftReceiveUI.a(CardGiftReceiveUI.this) == null)
        {
          Log.e("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress cardGiftInfo is null return!");
          AppMethodBeat.o(245053);
          return;
        }
        if ((!Util.isNullOrNil(paramAnonymousString)) && (!Util.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).toq)) && (paramAnonymousString.equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).toq)))
        {
          Log.i("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress fromUserContentVideoUrl return!");
          AppMethodBeat.o(245053);
          return;
        }
        CardGiftReceiveUI.g(CardGiftReceiveUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(246377);
            if (CardGiftReceiveUI.f(CardGiftReceiveUI.this).getVisibility() != 0) {
              CardGiftReceiveUI.f(CardGiftReceiveUI.this).setVisibility(0);
            }
            AppMethodBeat.o(246377);
          }
        });
        AppMethodBeat.o(245053);
      }
      
      public final void fK(final String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(245058);
        Log.i("MicroMsg.CardGiftReceiveUI", "CDN  download success! fieldId:".concat(String.valueOf(paramAnonymousString1)));
        if (CardGiftReceiveUI.a(CardGiftReceiveUI.this) == null)
        {
          Log.e("MicroMsg.CardGiftReceiveUI", "CDN  download cardGiftInfo is null return!");
          AppMethodBeat.o(245058);
          return;
        }
        if ((!Util.isNullOrNil(paramAnonymousString1)) && (!Util.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).toq)) && (paramAnonymousString1.equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).toq)))
        {
          Log.i("MicroMsg.CardGiftReceiveUI", "CDN  download fromUserContentVideoUrl! return");
          AppMethodBeat.o(245058);
          return;
        }
        CardGiftReceiveUI.g(CardGiftReceiveUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(246320);
            if (CardGiftReceiveUI.f(CardGiftReceiveUI.this).getVisibility() != 8) {
              CardGiftReceiveUI.f(CardGiftReceiveUI.this).setVisibility(8);
            }
            if ((!Util.isNullOrNil(paramAnonymousString1)) && (!Util.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).tor)) && (paramAnonymousString1.equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).tor))) {
              CardGiftReceiveUI.h(CardGiftReceiveUI.this).setVisibility(0);
            }
            Bitmap localBitmap;
            for (;;)
            {
              localBitmap = u.ZS(paramAnonymousString2);
              if (localBitmap != null) {
                break;
              }
              CardGiftReceiveUI.i(CardGiftReceiveUI.this).setImageResource(a.f.download_image_icon);
              AppMethodBeat.o(246320);
              return;
              CardGiftReceiveUI.h(CardGiftReceiveUI.this).setVisibility(8);
            }
            CardGiftReceiveUI.i(CardGiftReceiveUI.this).setImageBitmap(localBitmap);
            AppMethodBeat.o(246320);
          }
        });
        AppMethodBeat.o(245058);
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
      View localView = View.inflate(this, a.e.tic, null);
      TextView localTextView1 = (TextView)localView.findViewById(a.d.thn);
      TextView localTextView2 = (TextView)localView.findViewById(a.d.thm);
      localTextView1.setText(localAcceptedCardItem.tpe);
      localTextView2.setText(localAcceptedCardItem.tpf + getContext().getString(a.g.tkl));
      this.txc.addView(localView);
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
  
  private void cIg()
  {
    AppMethodBeat.i(113358);
    if (this.twv == null)
    {
      Log.e("MicroMsg.CardGiftReceiveUI", "doUpdate due to cardGiftInfo is null!");
      AppMethodBeat.o(113358);
      return;
    }
    Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descLayoutMode:%d", new Object[] { Integer.valueOf(this.twv.toF) });
    if ((this.twv.toF != 1) && (this.twv.toF == 2))
    {
      cJu();
      cJt();
      cIu();
      cJw();
      if (Util.isNullOrNil(this.twv.toY)) {
        break label227;
      }
      this.txp.setVisibility(0);
      this.txp.setText(this.twv.toY);
      this.txp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(248519);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardGiftReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!Util.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).tpd))
          {
            paramAnonymousView = new d.a(CardGiftReceiveUI.this.getContext());
            paramAnonymousView.bBd(CardGiftReceiveUI.a(CardGiftReceiveUI.this).tpd);
            paramAnonymousView.ayk(a.g.app_cancel);
            paramAnonymousView.ayj(a.g.app_accept);
            paramAnonymousView.a(true, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(247406);
                if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).toZ == 1)
                {
                  if ("cardhomepage".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).tpa))
                  {
                    paramAnonymous2DialogInterface = new lc();
                    paramAnonymous2DialogInterface.fIO.context = CardGiftReceiveUI.this.getContext();
                    EventCenter.instance.publish(paramAnonymous2DialogInterface);
                    AppMethodBeat.o(247406);
                    return;
                  }
                  if ("cardhomepage/couponandgiftcard".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).tpa))
                  {
                    if (((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vww, Boolean.FALSE)).booleanValue())
                    {
                      paramAnonymous2DialogInterface = new Intent();
                      paramAnonymous2DialogInterface.putExtra("scene", 1);
                      com.tencent.mm.by.c.b(CardGiftReceiveUI.this.getContext(), "card", ".ui.v3.CouponCardListUI", paramAnonymous2DialogInterface);
                      AppMethodBeat.o(247406);
                      return;
                    }
                    paramAnonymous2DialogInterface = new lc();
                    paramAnonymous2DialogInterface.fIO.context = CardGiftReceiveUI.this.getContext();
                    EventCenter.instance.publish(paramAnonymous2DialogInterface);
                    AppMethodBeat.o(247406);
                  }
                }
                else if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).toZ == 2)
                {
                  com.tencent.mm.plugin.card.d.b.S(CardGiftReceiveUI.a(CardGiftReceiveUI.this).toK, CardGiftReceiveUI.a(CardGiftReceiveUI.this).tpb, CardGiftReceiveUI.a(CardGiftReceiveUI.this).tpc);
                }
                AppMethodBeat.o(247406);
              }
            });
            paramAnonymousView.icu().show();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248519);
            return;
            if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).toZ == 1)
            {
              if ("cardhomepage".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).tpa))
              {
                paramAnonymousView = new lc();
                paramAnonymousView.fIO.context = CardGiftReceiveUI.this.getContext();
                EventCenter.instance.publish(paramAnonymousView);
              }
              else if ("cardhomepage/couponandgiftcard".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).tpa))
              {
                if (((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vww, Boolean.FALSE)).booleanValue())
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("scene", 1);
                  com.tencent.mm.by.c.b(CardGiftReceiveUI.this.getContext(), "card", ".ui.v3.CouponCardListUI", paramAnonymousView);
                }
                else
                {
                  paramAnonymousView = new lc();
                  paramAnonymousView.fIO.context = CardGiftReceiveUI.this.getContext();
                  EventCenter.instance.publish(paramAnonymousView);
                }
              }
            }
            else if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).toZ == 2) {
              com.tencent.mm.plugin.card.d.b.S(CardGiftReceiveUI.a(CardGiftReceiveUI.this).toK, CardGiftReceiveUI.a(CardGiftReceiveUI.this).tpb, CardGiftReceiveUI.a(CardGiftReceiveUI.this).tpc);
            }
          }
        }
      });
    }
    for (;;)
    {
      if ((Util.isNullOrNil(this.twv.toL)) && (Util.isNullOrNil(this.twv.footerWording)) && (Util.isNullOrNil(this.twv.toV)) && (Util.isNullOrNil(this.twv.toW))) {
        break label239;
      }
      this.twJ.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(247599);
          int i = com.tencent.mm.ci.a.fromDPToPix(CardGiftReceiveUI.this.getContext(), 67);
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
            AppMethodBeat.o(247599);
            return;
            CardGiftReceiveUI.a(CardGiftReceiveUI.this, false);
          }
        }
      });
      AppMethodBeat.o(113358);
      return;
      cJv();
      break;
      label227:
      this.txp.setVisibility(8);
    }
    label239:
    this.twJ.setFillViewport(true);
    AppMethodBeat.o(113358);
  }
  
  private void cIu()
  {
    int i = 0;
    AppMethodBeat.i(113364);
    if (this.twv.toP.size() > 0)
    {
      this.txa.setVisibility(0);
      this.txd.setVisibility(8);
      if (this.twv.toP.size() <= 2)
      {
        this.txb.setVisibility(8);
        R(this.twv.toP);
        AppMethodBeat.o(113364);
        return;
      }
      Object localObject = new LinkedList();
      ((LinkedList)localObject).add(this.twv.toP.get(0));
      ((LinkedList)localObject).add(this.twv.toP.get(1));
      R((LinkedList)localObject);
      this.txb.setVisibility(0);
      this.txb.setOnClickListener(this);
      localObject = new LinkedList();
      while (i < this.twv.toP.size())
      {
        if ((i != 0) && (i != 1)) {
          ((LinkedList)localObject).add(this.twv.toP.get(i));
        }
        i += 1;
      }
      localObject = new c((LinkedList)localObject);
      this.txd.setAdapter((ListAdapter)localObject);
      a(this.txd);
      AppMethodBeat.o(113364);
      return;
    }
    this.txa.setVisibility(8);
    this.txb.setVisibility(8);
    this.txd.setVisibility(8);
    AppMethodBeat.o(113364);
  }
  
  private void cJt()
  {
    AppMethodBeat.i(113360);
    if (this.twv.toS == 1)
    {
      this.txf.setVisibility(0);
      this.txi.setVisibility(8);
      this.txe.setVisibility(8);
      this.txh.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, this.twv.fSj, this.txh.getTextSize()));
      f(this.txg);
      AppMethodBeat.o(113360);
      return;
    }
    this.txf.setVisibility(8);
    this.txi.setVisibility(0);
    this.txe.setVisibility(0);
    f(this.txn);
    this.txo.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, this.twv.fSj, this.txo.getTextSize()));
    if (((!Util.isNullOrNil(this.twv.too)) && (!"undefined".equals(this.twv.too))) || ((!Util.isNullOrNil(this.twv.toq)) && (!"undefined".equals(this.twv.toq)))) {
      this.txk.setVisibility(0);
    }
    for (;;)
    {
      cJx();
      if (!Util.isNullOrNil(this.twv.ton)) {
        this.txj.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, this.twv.ton, this.txj.getTextSize()));
      }
      AppMethodBeat.o(113360);
      return;
      this.txk.setVisibility(8);
      Log.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is empty");
    }
  }
  
  private void cJu()
  {
    AppMethodBeat.i(113362);
    this.twQ.setVisibility(8);
    this.twK.setVisibility(0);
    this.twM.setText(this.twv.toD);
    this.twN.setText(this.twv.tox + "     " + this.twv.toy + getContext().getString(a.g.tkl));
    Object localObject;
    if (!Util.isNullOrNil(this.twv.toE))
    {
      this.twL.setVisibility(0);
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aSL();
      com.tencent.mm.ay.q.bmm();
      ((c.a)localObject).lRV = null;
      ((c.a)localObject).fullPath = m.arc(this.twv.toE);
      ((c.a)localObject).lRD = true;
      ((c.a)localObject).lRB = true;
      localObject = ((c.a)localObject).bmL();
      com.tencent.mm.ay.q.bml().a(this.twv.toE, this.twL, (com.tencent.mm.ay.a.a.c)localObject);
      if (Util.isNullOrNil(this.twv.toH)) {
        break label507;
      }
      this.twM.setTextColor(Util.convertStringToRGB(this.twv.toH, getResources().getColor(com.tencent.mm.plugin.card.a.a.normal_text_color)));
      label225:
      if (Util.isNullOrNil(this.twv.toI)) {
        break label519;
      }
      this.twN.setTextColor(Util.convertStringToRGB(this.twv.toI, getResources().getColor(com.tencent.mm.plugin.card.a.a.normal_text_color)));
      label265:
      if (Util.isNullOrNil(this.twv.tow)) {
        break label531;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aSL();
      com.tencent.mm.ay.q.bmm();
      ((c.a)localObject).lRV = null;
      ((c.a)localObject).fullPath = m.arc(this.twv.tow);
      ((c.a)localObject).kPz = true;
      ((c.a)localObject).lRD = true;
      ((c.a)localObject).lRB = true;
      ((c.a)localObject).kOi = new ColorDrawable(com.tencent.mm.plugin.card.d.l.arR("#CCCCCC"));
      localObject = ((c.a)localObject).bmL();
      com.tencent.mm.ay.q.bml().a(this.twv.tow, this.twP, (com.tencent.mm.ay.a.a.c)localObject);
    }
    for (;;)
    {
      if (Util.isNullOrNil(this.twv.tov)) {
        break label543;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aSL();
      com.tencent.mm.ay.q.bmm();
      ((c.a)localObject).lRV = null;
      ((c.a)localObject).fullPath = m.arc(this.twv.tov);
      ((c.a)localObject).lRD = true;
      ((c.a)localObject).lRB = true;
      ((c.a)localObject).kOi = new ColorDrawable(com.tencent.mm.plugin.card.d.l.arR("#CCCCCC"));
      ((c.a)localObject).kPz = true;
      ((c.a)localObject).lRW = com.tencent.mm.ci.a.fromDPToPix(this, 8);
      localObject = ((c.a)localObject).bmL();
      com.tencent.mm.ay.q.bml().a(this.twv.tov, this.twO, (com.tencent.mm.ay.a.a.c)localObject);
      AppMethodBeat.o(113362);
      return;
      this.twL.setVisibility(8);
      break;
      label507:
      Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
      break label225;
      label519:
      Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
      break label265;
      label531:
      Log.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
    }
    label543:
    Log.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
    AppMethodBeat.o(113362);
  }
  
  private void cJv()
  {
    AppMethodBeat.i(113363);
    this.twK.setVisibility(8);
    this.twQ.setVisibility(0);
    this.twV.setText(this.twv.tox);
    Object localObject;
    if (this.twv.toS == 1)
    {
      this.twY.setAlpha(0.5F);
      this.twW.setVisibility(8);
      this.twX.setVisibility(8);
      this.twS.setVisibility(8);
      this.twR.setVisibility(8);
      if (Util.isNullOrNil(this.twv.toE)) {
        break label673;
      }
      this.twU.setVisibility(0);
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aSL();
      com.tencent.mm.ay.q.bmm();
      ((c.a)localObject).lRV = null;
      ((c.a)localObject).fullPath = m.arc(this.twv.toE);
      ((c.a)localObject).lRD = true;
      ((c.a)localObject).lRB = true;
      localObject = ((c.a)localObject).bmL();
      com.tencent.mm.ay.q.bml().a(this.twv.toE, this.twU, (com.tencent.mm.ay.a.a.c)localObject);
      label186:
      if (Util.isNullOrNil(this.twv.toD)) {
        break label706;
      }
      this.twT.setVisibility(0);
      this.twT.setText(this.twv.toD);
      if (Util.isNullOrNil(this.twv.toH)) {
        break label694;
      }
      this.twT.setTextColor(Util.convertStringToRGB(this.twv.toH, getResources().getColor(com.tencent.mm.plugin.card.a.a.normal_text_color)));
      label261:
      if (Util.isNullOrNil(this.twv.toI)) {
        break label727;
      }
      this.twV.setTextColor(Util.convertStringToRGB(this.twv.toI, getResources().getColor(com.tencent.mm.plugin.card.a.a.normal_text_color)));
      label301:
      if (Util.isNullOrNil(this.twv.tow)) {
        break label739;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aSL();
      com.tencent.mm.ay.q.bmm();
      ((c.a)localObject).lRV = null;
      ((c.a)localObject).fullPath = m.arc(this.twv.tow);
      ((c.a)localObject).kPz = true;
      ((c.a)localObject).lRD = true;
      ((c.a)localObject).lRB = true;
      ((c.a)localObject).kOi = new ColorDrawable(com.tencent.mm.plugin.card.d.l.arR("#CCCCCC"));
      localObject = ((c.a)localObject).bmL();
      com.tencent.mm.ay.q.bml().a(this.twv.tow, this.twZ, (com.tencent.mm.ay.a.a.c)localObject);
    }
    for (;;)
    {
      if (Util.isNullOrNil(this.twv.tov)) {
        break label751;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aSL();
      com.tencent.mm.ay.q.bmm();
      ((c.a)localObject).lRV = null;
      ((c.a)localObject).fullPath = m.arc(this.twv.tov);
      ((c.a)localObject).lRD = true;
      ((c.a)localObject).lRB = true;
      ((c.a)localObject).kOi = new ColorDrawable(com.tencent.mm.plugin.card.d.l.arR("#CCCCCC"));
      ((c.a)localObject).kPz = true;
      ((c.a)localObject).lRW = com.tencent.mm.ci.a.fromDPToPix(this, 8);
      localObject = ((c.a)localObject).bmL();
      com.tencent.mm.ay.q.bml().a(this.twv.tov, this.twY, (com.tencent.mm.ay.a.a.c)localObject);
      AppMethodBeat.o(113363);
      return;
      this.twW.setVisibility(0);
      this.twX.setVisibility(0);
      this.twS.setVisibility(0);
      this.twR.setVisibility(0);
      this.twW.setText(this.twv.toy);
      this.twX.setText(a.g.tkl);
      if (Util.isNullOrNil(this.twv.toy))
      {
        this.twW.setVisibility(8);
        this.twX.setVisibility(8);
      }
      if (!Util.isNullOrNil(this.twv.toJ))
      {
        this.twW.setTextColor(Util.convertStringToRGB(this.twv.toJ, getResources().getColor(com.tencent.mm.plugin.card.a.a.normal_text_color)));
        break;
      }
      Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardPriceTitleColor is empty");
      break;
      label673:
      this.twU.setVisibility(8);
      Log.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
      break label186;
      label694:
      Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
      break label261;
      label706:
      this.twT.setVisibility(8);
      Log.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
      break label261;
      label727:
      Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
      break label301;
      label739:
      Log.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
    }
    label751:
    Log.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
    AppMethodBeat.o(113363);
  }
  
  private void cJw()
  {
    AppMethodBeat.i(113366);
    if (this.twv.toQ.size() > 0)
    {
      this.txs.setVisibility(0);
      this.txr.setVisibility(0);
      a locala = new a();
      this.txr.setAdapter(locala);
      a(this.txr);
      if (!Util.isNullOrNil(this.twv.toR))
      {
        this.txq.setVisibility(0);
        this.txq.setText(this.twv.toR);
      }
      AppMethodBeat.o(113366);
      return;
    }
    if (!Util.isNullOrNil(this.twv.toR))
    {
      this.txs.setVisibility(0);
      this.txq.setVisibility(0);
      this.txq.setText(this.twv.toR);
      this.txr.setVisibility(8);
      AppMethodBeat.o(113366);
      return;
    }
    this.txs.setVisibility(8);
    this.txq.setVisibility(8);
    this.txr.setVisibility(8);
    AppMethodBeat.o(113366);
  }
  
  private void cJx()
  {
    AppMethodBeat.i(113370);
    if ((this.twv != null) && (!Util.isNullOrNil(this.twv.too))) {
      com.tencent.mm.plugin.card.d.a.g(this.twv.too, this.twv.tos, this.twv.toA, 2);
    }
    while ((this.twv != null) && (!Util.isNullOrNil(this.twv.tor)))
    {
      com.tencent.mm.plugin.card.d.a.g(this.twv.tor, this.twv.tou, this.twv.toC, 2);
      AppMethodBeat.o(113370);
      return;
      Log.e("MicroMsg.CardGiftReceiveUI", "fromUserContentPicUrl is null");
    }
    Log.e("MicroMsg.CardGiftReceiveUI", "fromUserContentThumbPicUrl is null");
    AppMethodBeat.o(113370);
  }
  
  private void f(ImageView paramImageView)
  {
    AppMethodBeat.i(113361);
    if (!Util.isNullOrNil(this.twv.tom))
    {
      int i = com.tencent.mm.ci.a.fromDPToPix(this, 20);
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aSL();
      com.tencent.mm.ay.q.bmm();
      ((c.a)localObject).lRV = null;
      ((c.a)localObject).fullPath = m.arc(this.twv.tom);
      ((c.a)localObject).lRD = true;
      ((c.a)localObject).kPz = true;
      ((c.a)localObject).lRW = 3.0F;
      ((c.a)localObject).lRB = true;
      ((c.a)localObject).kOg = i;
      ((c.a)localObject).kOf = i;
      ((c.a)localObject).kOi = new ColorDrawable(com.tencent.mm.plugin.card.d.l.arR("#CCCCCC"));
      localObject = ((c.a)localObject).bmL();
      com.tencent.mm.ay.q.bml().a(this.twv.tom, paramImageView, (com.tencent.mm.ay.a.a.c)localObject);
      AppMethodBeat.o(113361);
      return;
    }
    Log.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is null");
    AppMethodBeat.o(113361);
  }
  
  private int gf(int paramInt)
  {
    AppMethodBeat.i(113359);
    paramInt = com.tencent.mm.ci.a.fromDPToPix(getContext(), paramInt);
    AppMethodBeat.o(113359);
    return paramInt;
  }
  
  public int getLayoutId()
  {
    return a.e.tih;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113368);
    this.twJ = ((ScrollView)findViewById(a.d.tcl));
    this.twK = ((LinearLayout)findViewById(a.d.tdF));
    this.twL = ((ImageView)findViewById(a.d.tgd));
    this.twM = ((TextView)findViewById(a.d.thx));
    this.twN = ((TextView)findViewById(a.d.thw));
    this.twO = ((ImageView)findViewById(a.d.tgb));
    this.twP = ((ImageView)findViewById(a.d.tgc));
    this.twO.setOnClickListener(this);
    this.twQ = ((LinearLayout)findViewById(a.d.tdE));
    this.twR = ((RelativeLayout)findViewById(a.d.taK));
    this.twS = ((RelativeLayout)findViewById(a.d.taL));
    this.twT = ((TextView)findViewById(a.d.tho));
    this.twV = ((TextView)findViewById(a.d.thv));
    this.twU = ((ImageView)findViewById(a.d.tga));
    this.twW = ((TextView)findViewById(a.d.thz));
    this.twX = ((TextView)findViewById(a.d.thA));
    this.twY = ((ImageView)findViewById(a.d.tfV));
    this.twZ = ((ImageView)findViewById(a.d.tfW));
    this.twY.setOnClickListener(this);
    this.txa = findViewById(a.d.tcM);
    this.txb = ((TextView)findViewById(a.d.thy));
    this.txc = ((LinearLayout)findViewById(a.d.tcL));
    this.txd = ((ListView)findViewById(a.d.tcN));
    this.txe = ((RelativeLayout)findViewById(a.d.tca));
    this.txf = ((LinearLayout)findViewById(a.d.tfL));
    this.txg = ((ImageView)findViewById(a.d.tfY));
    this.txh = ((TextView)findViewById(a.d.tht));
    this.txi = ((LinearLayout)findViewById(a.d.tfK));
    this.txn = ((ImageView)findViewById(a.d.tfX));
    this.txo = ((TextView)findViewById(a.d.ths));
    this.txj = ((TextView)findViewById(a.d.thr));
    this.txk = ((RelativeLayout)findViewById(a.d.tcx));
    this.txl = ((RelativeLayout)findViewById(a.d.tfP));
    this.txm = ((ImageView)findViewById(a.d.thu));
    this.txk.setOnClickListener(this);
    this.txl.setOnClickListener(this);
    this.txq = ((TextView)findViewById(a.d.thi));
    this.txr = ((ListView)findViewById(a.d.taC));
    this.txs = ((RelativeLayout)findViewById(a.d.tbZ));
    this.txp = ((Button)findViewById(a.d.tcC));
    this.twy = ((ProgressBar)findViewById(a.d.tfM));
    n.e(this);
    setMMTitle("");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(251155);
        CardGiftReceiveUI.this.finish();
        AppMethodBeat.o(251155);
        return true;
      }
    });
    AppMethodBeat.o(113368);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(113371);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    if (paramView.getId() == a.d.tfP) {
      if (!Util.isNullOrNil(this.twv.toq))
      {
        paramView = new Intent(this, CardGiftVideoUI.class);
        paramView.putExtra("key_gift_into", this.twv);
        paramView.putExtra("key_is_mute", false);
        paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramView.aFh(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        overridePendingTransition(0, 0);
        com.tencent.mm.plugin.report.service.h.IzE.a(13866, new Object[] { Integer.valueOf(3), this.lno, p.getString(this.lnn) });
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113371);
      return;
      if (paramView.getId() == a.d.tcx)
      {
        if (this.twy.getVisibility() == 0)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113371);
          return;
        }
        if (!Util.isNullOrNil(this.twv.too))
        {
          paramView = new Intent(this, CardGiftImageUI.class);
          paramView.putExtra("key_gift_into", this.twv);
          paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramView.aFh(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramView.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          overridePendingTransition(0, 0);
          com.tencent.mm.plugin.report.service.h.IzE.a(13866, new Object[] { Integer.valueOf(4), this.lno, p.getString(this.lnn) });
        }
      }
      else if (paramView.getId() == a.d.thp)
      {
        if ((this.twv != null) && (this.twv.toz))
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(13866, new Object[] { Integer.valueOf(7), this.lno, p.getString(this.lnn) });
          if ("cardhomepage/couponandgiftcard".equals(this.twv.toX)) {
            if (((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vww, Boolean.FALSE)).booleanValue())
            {
              paramView = new Intent();
              paramView.putExtra("scene", 1);
              com.tencent.mm.by.c.b(getContext(), "card", ".ui.v3.CouponCardListUI", paramView);
            }
          }
          for (;;)
          {
            finish();
            overridePendingTransition(0, 0);
            break;
            paramView = new lc();
            paramView.fIO.context = getContext();
            EventCenter.instance.publish(paramView);
            continue;
            paramView = new lc();
            paramView.fIO.context = getContext();
            paramView.fIO.scene = 2;
            EventCenter.instance.publish(paramView);
            Log.i("MicroMsg.CardGiftReceiveUI", "enter to cardhome");
          }
        }
      }
      else if (paramView.getId() == a.d.thq)
      {
        if ((!TextUtils.isEmpty(this.twv.toT)) && (!TextUtils.isEmpty(this.twv.toU)))
        {
          int i = getIntent().getIntExtra("key_from_appbrand_type", 0);
          com.tencent.mm.plugin.card.d.b.e(this.twv.toK, this.twv.toT, this.twv.toU, 1062, i);
          com.tencent.mm.plugin.report.service.h.IzE.a(13866, new Object[] { Integer.valueOf(8), this.lno, p.getString(this.lnn) });
        }
        else if (!Util.isNullOrNil(this.twv.toM))
        {
          com.tencent.mm.plugin.card.d.b.a(this, this.twv.toM, 0);
          com.tencent.mm.plugin.report.service.h.IzE.a(13866, new Object[] { Integer.valueOf(8), this.lno, p.getString(this.lnn) });
        }
      }
      else if ((paramView.getId() == a.d.tfV) || (paramView.getId() == a.d.tgb))
      {
        if ((!Util.isNullOrNil(this.twv.toN)) && (!Util.isNullOrNil(this.twv.toO)))
        {
          paramView = new LinkedList();
          localObject = new vc();
          ((vc)localObject).tnX = this.twv.toN;
          ((vc)localObject).code = this.twv.toO;
          paramView.add(localObject);
          localObject = getIntent().getStringExtra("key_template_id");
          eml localeml = new eml();
          localeml.UoY = ((String)localObject);
          Log.i("MicroMsg.CardGiftReceiveUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { localObject });
          paramView = new com.tencent.mm.plugin.card.model.t(paramView, localeml, 27);
          com.tencent.mm.kernel.h.aHF().kcd.a(paramView, 0);
          com.tencent.mm.plugin.report.service.h.IzE.a(13866, new Object[] { Integer.valueOf(9), this.lno, p.getString(this.lnn) });
        }
        else
        {
          Log.e("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.userCardId is null");
        }
      }
      else if (paramView.getId() == a.d.thy)
      {
        if (this.txd.getVisibility() == 0)
        {
          this.txd.setVisibility(8);
          this.txb.setText("查看全部");
        }
        else
        {
          this.txd.setVisibility(0);
          this.txb.setText("收起");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113356);
    super.onCreate(paramBundle);
    this.lno = getIntent().getStringExtra("key_order_id");
    this.lnn = getIntent().getIntExtra("key_biz_uin", -1);
    this.twv = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    Log.i("MicroMsg.CardGiftReceiveUI", "onCreate, orderId:%s, bizUin:%s", new Object[] { this.lno, Integer.valueOf(this.lnn) });
    initView();
    com.tencent.mm.kernel.h.aHF().kcd.a(1165, this);
    com.tencent.mm.kernel.h.aHF().kcd.a(1099, this);
    com.tencent.mm.plugin.card.d.a.a(this.txy);
    if (this.twv == null)
    {
      Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo is null, sync GiftCard from serve");
      if (this.lnn == -1)
      {
        Log.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, bizUin is -1, fail!");
        AppMethodBeat.o(113356);
        return;
      }
      if (this.lno == null) {
        Log.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, orderId is null, fail");
      }
      Log.e("MicroMsg.CardGiftReceiveUI", "doNetSceneGetCardGiftInfo");
      paramBundle = new z(this.lnn, this.lno);
      com.tencent.mm.kernel.h.aHF().kcd.a(paramBundle, 0);
      this.tipDialog = com.tencent.mm.ui.base.h.a(getContext(), getString(a.g.loading_tips), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(244214);
          if ((CardGiftReceiveUI.c(CardGiftReceiveUI.this) != null) && (CardGiftReceiveUI.c(CardGiftReceiveUI.this).isShowing())) {
            CardGiftReceiveUI.c(CardGiftReceiveUI.this).dismiss();
          }
          if ((CardGiftReceiveUI.d(CardGiftReceiveUI.this).getVisibility() == 8) || (CardGiftReceiveUI.e(CardGiftReceiveUI.this).getVisibility() == 4))
          {
            Log.i("MicroMsg.CardGiftReceiveUI", "user cancel & finish");
            CardGiftReceiveUI.this.finish();
          }
          AppMethodBeat.o(244214);
        }
      });
      if (this.tipDialog != null) {
        this.tipDialog.show();
      }
      AppMethodBeat.o(113356);
      return;
    }
    cIg();
    AppMethodBeat.o(113356);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113357);
    super.onDestroy();
    com.tencent.mm.kernel.h.aHF().kcd.b(1165, this);
    com.tencent.mm.kernel.h.aHF().kcd.b(1099, this);
    com.tencent.mm.plugin.card.d.a.b(this.txy);
    AppMethodBeat.o(113357);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
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
        this.twv = ((z)paramq).tqc;
        cIg();
        AppMethodBeat.o(113369);
        return;
      }
      if ((paramq instanceof com.tencent.mm.plugin.card.model.t))
      {
        paramString = new Intent(this, CardDetailUI.class);
        Object localObject = ((com.tencent.mm.plugin.card.model.t)paramq).tqf;
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
        paramString.putExtra("key_card_git_info", this.twv);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      int i = CardGiftReceiveUI.a(CardGiftReceiveUI.this).toQ.size();
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
      CardGiftInfo.AccepterItem localAccepterItem = (CardGiftInfo.AccepterItem)CardGiftReceiveUI.a(CardGiftReceiveUI.this).toQ.get(paramInt);
      ImageView localImageView;
      String str;
      if (paramView == null)
      {
        paramView = View.inflate(CardGiftReceiveUI.this, a.e.tie, null);
        paramViewGroup = new CardGiftReceiveUI.b(CardGiftReceiveUI.this);
        paramViewGroup.txC = ((ImageView)paramView.findViewById(a.d.tfO));
        paramViewGroup.txD = ((TextView)paramView.findViewById(a.d.thj));
        paramViewGroup.jMg = ((TextView)paramView.findViewById(a.d.thl));
        paramViewGroup.txE = ((TextView)paramView.findViewById(a.d.thk));
        paramView.setTag(paramViewGroup);
        if (localAccepterItem != null) {
          if (localAccepterItem.tph != null)
          {
            localImageView = paramViewGroup.txC;
            str = localAccepterItem.tph;
            paramInt = a.c.my_card_package_defaultlogo;
            if ((localImageView != null) && (!TextUtils.isEmpty(str))) {
              break label239;
            }
          }
        }
      }
      for (;;)
      {
        paramViewGroup.txD.setText(localAccepterItem.tpg);
        paramViewGroup.jMg.setText(localAccepterItem.tpe);
        paramViewGroup.txE.setText(localAccepterItem.tpf + CardGiftReceiveUI.this.getContext().getString(a.g.tkl));
        AppMethodBeat.o(113349);
        return paramView;
        paramViewGroup = (CardGiftReceiveUI.b)paramView.getTag();
        break;
        label239:
        if (!TextUtils.isEmpty(str))
        {
          Object localObject = new c.a();
          ((c.a)localObject).prefixPath = com.tencent.mm.loader.j.b.aSL();
          com.tencent.mm.ay.q.bmm();
          ((c.a)localObject).lRV = null;
          ((c.a)localObject).fullPath = m.arc(str);
          ((c.a)localObject).lRD = true;
          ((c.a)localObject).kPz = true;
          ((c.a)localObject).lRW = 3.0F;
          ((c.a)localObject).lRB = true;
          ((c.a)localObject).kOg = 34;
          ((c.a)localObject).kOf = 34;
          ((c.a)localObject).lRP = paramInt;
          localObject = ((c.a)localObject).bmL();
          com.tencent.mm.ay.q.bml().a(str, localImageView, (com.tencent.mm.ay.a.a.c)localObject);
        }
        else
        {
          localImageView.setImageResource(paramInt);
        }
      }
    }
  }
  
  final class b
  {
    public TextView jMg;
    public ImageView txC;
    public TextView txD;
    public TextView txE;
    
    b() {}
  }
  
  final class c
    extends BaseAdapter
  {
    private LinkedList<CardGiftInfo.AcceptedCardItem> txF;
    
    c()
    {
      Object localObject;
      this.txF = localObject;
    }
    
    private CardGiftInfo.AcceptedCardItem HV(int paramInt)
    {
      AppMethodBeat.i(113352);
      CardGiftInfo.AcceptedCardItem localAcceptedCardItem = (CardGiftInfo.AcceptedCardItem)this.txF.get(paramInt);
      AppMethodBeat.o(113352);
      return localAcceptedCardItem;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(113351);
      int i = this.txF.size();
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
      CardGiftInfo.AcceptedCardItem localAcceptedCardItem = HV(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = View.inflate(CardGiftReceiveUI.this, a.e.tic, null);
        paramView = new CardGiftReceiveUI.d(CardGiftReceiveUI.this);
        paramView.jMg = ((TextView)localView.findViewById(a.d.thn));
        paramView.txE = ((TextView)localView.findViewById(a.d.thm));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        paramViewGroup.jMg.setText(localAcceptedCardItem.tpe);
        paramViewGroup.txE.setText(localAcceptedCardItem.tpf + CardGiftReceiveUI.this.getContext().getString(a.g.tkl));
        AppMethodBeat.o(113353);
        return localView;
        paramViewGroup = (CardGiftReceiveUI.d)paramView.getTag();
        localView = paramView;
      }
    }
  }
  
  final class d
  {
    public TextView jMg;
    public TextView txE;
    
    d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftReceiveUI
 * JD-Core Version:    0.7.0.1
 */