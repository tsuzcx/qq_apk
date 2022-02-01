package com.tencent.mm.plugin.card.ui;

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
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.mg;
import com.tencent.mm.kernel.f;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.c.d;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.c.n;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AcceptedCardItem;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AccepterItem;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.card.model.z;
import com.tencent.mm.protocal.protobuf.fhj;
import com.tencent.mm.protocal.protobuf.wt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftReceiveUI
  extends MMActivity
  implements View.OnClickListener, com.tencent.mm.am.h
{
  private int nSr;
  private String nSs;
  private w tipDialog;
  private CardGiftInfo wAS;
  private ProgressBar wAV;
  private MMHandler wAW;
  private ListView wBA;
  private RelativeLayout wBB;
  private LinearLayout wBC;
  private ImageView wBD;
  private TextView wBE;
  private LinearLayout wBF;
  private TextView wBG;
  private RelativeLayout wBH;
  private RelativeLayout wBI;
  private ImageView wBJ;
  private ImageView wBK;
  private TextView wBL;
  private Button wBM;
  private TextView wBN;
  private ListView wBO;
  private RelativeLayout wBP;
  private TextView wBQ;
  private TextView wBR;
  private View wBS;
  private RelativeLayout wBT;
  com.tencent.mm.plugin.card.c.a.a wBU;
  private ScrollView wBg;
  private LinearLayout wBh;
  private ImageView wBi;
  private TextView wBj;
  private TextView wBk;
  private ImageView wBl;
  private ImageView wBm;
  private LinearLayout wBn;
  private RelativeLayout wBo;
  private RelativeLayout wBp;
  private TextView wBq;
  private ImageView wBr;
  private TextView wBs;
  private TextView wBt;
  private TextView wBu;
  private ImageView wBv;
  private ImageView wBw;
  private View wBx;
  private TextView wBy;
  private LinearLayout wBz;
  
  public CardGiftReceiveUI()
  {
    AppMethodBeat.i(113355);
    this.tipDialog = null;
    this.wAW = new MMHandler(Looper.getMainLooper());
    this.wBU = new com.tencent.mm.plugin.card.c.a.a()
    {
      public final void akZ(String paramAnonymousString)
      {
        AppMethodBeat.i(293778);
        Log.e("MicroMsg.CardGiftReceiveUI", "CDN download pic failure! fieldId:".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(293778);
      }
      
      public final void dK(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(293776);
        if (CardGiftReceiveUI.a(CardGiftReceiveUI.this) == null)
        {
          Log.e("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress cardGiftInfo is null return!");
          AppMethodBeat.o(293776);
          return;
        }
        if ((!Util.isNullOrNil(paramAnonymousString)) && (!Util.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).wsQ)) && (paramAnonymousString.equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).wsQ)))
        {
          Log.i("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress fromUserContentVideoUrl return!");
          AppMethodBeat.o(293776);
          return;
        }
        CardGiftReceiveUI.g(CardGiftReceiveUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(293797);
            if (CardGiftReceiveUI.f(CardGiftReceiveUI.this).getVisibility() != 0) {
              CardGiftReceiveUI.f(CardGiftReceiveUI.this).setVisibility(0);
            }
            AppMethodBeat.o(293797);
          }
        });
        AppMethodBeat.o(293776);
      }
      
      public final void gj(final String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(293780);
        Log.i("MicroMsg.CardGiftReceiveUI", "CDN  download success! fieldId:".concat(String.valueOf(paramAnonymousString1)));
        if (CardGiftReceiveUI.a(CardGiftReceiveUI.this) == null)
        {
          Log.e("MicroMsg.CardGiftReceiveUI", "CDN  download cardGiftInfo is null return!");
          AppMethodBeat.o(293780);
          return;
        }
        if ((!Util.isNullOrNil(paramAnonymousString1)) && (!Util.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).wsQ)) && (paramAnonymousString1.equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).wsQ)))
        {
          Log.i("MicroMsg.CardGiftReceiveUI", "CDN  download fromUserContentVideoUrl! return");
          AppMethodBeat.o(293780);
          return;
        }
        CardGiftReceiveUI.g(CardGiftReceiveUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(293798);
            if (CardGiftReceiveUI.f(CardGiftReceiveUI.this).getVisibility() != 8) {
              CardGiftReceiveUI.f(CardGiftReceiveUI.this).setVisibility(8);
            }
            if ((!Util.isNullOrNil(paramAnonymousString1)) && (!Util.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).wsR)) && (paramAnonymousString1.equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).wsR))) {
              CardGiftReceiveUI.h(CardGiftReceiveUI.this).setVisibility(0);
            }
            Bitmap localBitmap;
            for (;;)
            {
              localBitmap = com.tencent.mm.platformtools.r.Sg(paramAnonymousString2);
              if (localBitmap != null) {
                break;
              }
              CardGiftReceiveUI.i(CardGiftReceiveUI.this).setImageResource(a.f.download_image_icon);
              AppMethodBeat.o(293798);
              return;
              CardGiftReceiveUI.h(CardGiftReceiveUI.this).setVisibility(8);
            }
            CardGiftReceiveUI.i(CardGiftReceiveUI.this).setImageBitmap(localBitmap);
            AppMethodBeat.o(293798);
          }
        });
        AppMethodBeat.o(293780);
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
      View localView = View.inflate(this, a.e.wmB, null);
      TextView localTextView1 = (TextView)localView.findViewById(a.d.wlN);
      TextView localTextView2 = (TextView)localView.findViewById(a.d.wlM);
      localTextView1.setText(localAcceptedCardItem.wtD);
      localTextView2.setText(localAcceptedCardItem.wtE + getContext().getString(a.g.woJ));
      this.wBz.addView(localView);
    }
    AppMethodBeat.o(113365);
  }
  
  private static void b(ListView paramListView)
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
  
  private void dlL()
  {
    int i = 0;
    AppMethodBeat.i(113364);
    if (this.wAS.wto.size() > 0)
    {
      this.wBx.setVisibility(0);
      this.wBA.setVisibility(8);
      if (this.wAS.wto.size() <= 2)
      {
        this.wBy.setVisibility(8);
        T(this.wAS.wto);
        AppMethodBeat.o(113364);
        return;
      }
      Object localObject = new LinkedList();
      ((LinkedList)localObject).add((CardGiftInfo.AcceptedCardItem)this.wAS.wto.get(0));
      ((LinkedList)localObject).add((CardGiftInfo.AcceptedCardItem)this.wAS.wto.get(1));
      T((LinkedList)localObject);
      this.wBy.setVisibility(0);
      this.wBy.setOnClickListener(this);
      localObject = new LinkedList();
      while (i < this.wAS.wto.size())
      {
        if ((i != 0) && (i != 1)) {
          ((LinkedList)localObject).add((CardGiftInfo.AcceptedCardItem)this.wAS.wto.get(i));
        }
        i += 1;
      }
      localObject = new c((LinkedList)localObject);
      this.wBA.setAdapter((ListAdapter)localObject);
      b(this.wBA);
      AppMethodBeat.o(113364);
      return;
    }
    this.wBx.setVisibility(8);
    this.wBy.setVisibility(8);
    this.wBA.setVisibility(8);
    AppMethodBeat.o(113364);
  }
  
  private void dlx()
  {
    AppMethodBeat.i(113358);
    if (this.wAS == null)
    {
      Log.e("MicroMsg.CardGiftReceiveUI", "doUpdate due to cardGiftInfo is null!");
      AppMethodBeat.o(113358);
      return;
    }
    Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descLayoutMode:%d", new Object[] { Integer.valueOf(this.wAS.wte) });
    if ((this.wAS.wte != 1) && (this.wAS.wte == 2))
    {
      dmL();
      dmK();
      dlL();
      dmN();
      if (Util.isNullOrNil(this.wAS.wtx)) {
        break label227;
      }
      this.wBM.setVisibility(0);
      this.wBM.setText(this.wAS.wtx);
      this.wBM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(293781);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardGiftReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (!Util.isNullOrNil(CardGiftReceiveUI.a(CardGiftReceiveUI.this).wtC))
          {
            paramAnonymousView = new e.a(CardGiftReceiveUI.this.getContext());
            paramAnonymousView.bDw(CardGiftReceiveUI.a(CardGiftReceiveUI.this).wtC);
            paramAnonymousView.aES(a.g.app_cancel);
            paramAnonymousView.aER(a.g.app_accept);
            paramAnonymousView.a(true, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(293802);
                if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).wty == 1)
                {
                  if ("cardhomepage".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).wtz))
                  {
                    paramAnonymous2DialogInterface = new mg();
                    paramAnonymous2DialogInterface.hOp.context = CardGiftReceiveUI.this.getContext();
                    paramAnonymous2DialogInterface.publish();
                    AppMethodBeat.o(293802);
                    return;
                  }
                  if ("cardhomepage/couponandgiftcard".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).wtz))
                  {
                    if (((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acYh, Boolean.TRUE)).booleanValue())
                    {
                      paramAnonymous2DialogInterface = new Intent();
                      paramAnonymous2DialogInterface.putExtra("scene", 1);
                      com.tencent.mm.br.c.b(CardGiftReceiveUI.this.getContext(), "card", ".ui.v3.CouponCardListUI", paramAnonymous2DialogInterface);
                      AppMethodBeat.o(293802);
                      return;
                    }
                    paramAnonymous2DialogInterface = new mg();
                    paramAnonymous2DialogInterface.hOp.context = CardGiftReceiveUI.this.getContext();
                    paramAnonymous2DialogInterface.publish();
                    AppMethodBeat.o(293802);
                  }
                }
                else if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).wty == 2)
                {
                  com.tencent.mm.plugin.card.c.b.V(CardGiftReceiveUI.a(CardGiftReceiveUI.this).wtj, CardGiftReceiveUI.a(CardGiftReceiveUI.this).wtA, CardGiftReceiveUI.a(CardGiftReceiveUI.this).wtB);
                }
                AppMethodBeat.o(293802);
              }
            });
            paramAnonymousView.jHH().show();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(293781);
            return;
            if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).wty == 1)
            {
              if ("cardhomepage".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).wtz))
              {
                paramAnonymousView = new mg();
                paramAnonymousView.hOp.context = CardGiftReceiveUI.this.getContext();
                paramAnonymousView.publish();
              }
              else if ("cardhomepage/couponandgiftcard".equals(CardGiftReceiveUI.a(CardGiftReceiveUI.this).wtz))
              {
                if (((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acYh, Boolean.TRUE)).booleanValue())
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("scene", 1);
                  com.tencent.mm.br.c.b(CardGiftReceiveUI.this.getContext(), "card", ".ui.v3.CouponCardListUI", paramAnonymousView);
                }
                else
                {
                  paramAnonymousView = new mg();
                  paramAnonymousView.hOp.context = CardGiftReceiveUI.this.getContext();
                  paramAnonymousView.publish();
                }
              }
            }
            else if (CardGiftReceiveUI.a(CardGiftReceiveUI.this).wty == 2) {
              com.tencent.mm.plugin.card.c.b.V(CardGiftReceiveUI.a(CardGiftReceiveUI.this).wtj, CardGiftReceiveUI.a(CardGiftReceiveUI.this).wtA, CardGiftReceiveUI.a(CardGiftReceiveUI.this).wtB);
            }
          }
        }
      });
    }
    for (;;)
    {
      if ((Util.isNullOrNil(this.wAS.wtk)) && (Util.isNullOrNil(this.wAS.footerWording)) && (Util.isNullOrNil(this.wAS.wtu)) && (Util.isNullOrNil(this.wAS.wtv))) {
        break label239;
      }
      this.wBg.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(293779);
          int i = com.tencent.mm.cd.a.fromDPToPix(CardGiftReceiveUI.this.getContext(), 67);
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
            AppMethodBeat.o(293779);
            return;
            CardGiftReceiveUI.a(CardGiftReceiveUI.this, false);
          }
        }
      });
      AppMethodBeat.o(113358);
      return;
      dmM();
      break;
      label227:
      this.wBM.setVisibility(8);
    }
    label239:
    this.wBg.setFillViewport(true);
    AppMethodBeat.o(113358);
  }
  
  private void dmK()
  {
    AppMethodBeat.i(113360);
    if (this.wAS.wtr == 1)
    {
      this.wBC.setVisibility(0);
      this.wBF.setVisibility(8);
      this.wBB.setVisibility(8);
      this.wBE.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, this.wAS.hYg, this.wBE.getTextSize()));
      f(this.wBD);
      AppMethodBeat.o(113360);
      return;
    }
    this.wBC.setVisibility(8);
    this.wBF.setVisibility(0);
    this.wBB.setVisibility(0);
    f(this.wBK);
    this.wBL.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, this.wAS.hYg, this.wBL.getTextSize()));
    if (((!Util.isNullOrNil(this.wAS.wsP)) && (!"undefined".equals(this.wAS.wsP))) || ((!Util.isNullOrNil(this.wAS.wsQ)) && (!"undefined".equals(this.wAS.wsQ)))) {
      this.wBH.setVisibility(0);
    }
    for (;;)
    {
      dmO();
      if (!Util.isNullOrNil(this.wAS.wsO)) {
        this.wBG.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, this.wAS.wsO, this.wBG.getTextSize()));
      }
      AppMethodBeat.o(113360);
      return;
      this.wBH.setVisibility(8);
      Log.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is empty");
    }
  }
  
  private void dmL()
  {
    AppMethodBeat.i(113362);
    this.wBn.setVisibility(8);
    this.wBh.setVisibility(0);
    this.wBj.setText(this.wAS.wtc);
    this.wBk.setText(this.wAS.wsX + "     " + this.wAS.wsY + getContext().getString(a.g.woJ));
    Object localObject;
    if (!Util.isNullOrNil(this.wAS.wtd))
    {
      this.wBi.setVisibility(0);
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.i.b.bmz();
      ((c.a)localObject).oKH = com.tencent.mm.modelimage.r.bKf();
      ((c.a)localObject).fullPath = m.akH(this.wAS.wtd);
      ((c.a)localObject).oKp = true;
      ((c.a)localObject).oKn = true;
      localObject = ((c.a)localObject).bKx();
      com.tencent.mm.modelimage.r.bKe().a(this.wAS.wtd, this.wBi, (com.tencent.mm.modelimage.loader.a.c)localObject);
      if (Util.isNullOrNil(this.wAS.wtg)) {
        break label501;
      }
      this.wBj.setTextColor(Util.convertStringToRGB(this.wAS.wtg, getResources().getColor(com.tencent.mm.plugin.card.a.a.normal_text_color)));
      label223:
      if (Util.isNullOrNil(this.wAS.wth)) {
        break label513;
      }
      this.wBk.setTextColor(Util.convertStringToRGB(this.wAS.wth, getResources().getColor(com.tencent.mm.plugin.card.a.a.normal_text_color)));
      label263:
      if (Util.isNullOrNil(this.wAS.wsW)) {
        break label525;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.i.b.bmz();
      ((c.a)localObject).oKH = com.tencent.mm.modelimage.r.bKf();
      ((c.a)localObject).fullPath = m.akH(this.wAS.wsW);
      ((c.a)localObject).nrc = true;
      ((c.a)localObject).oKp = true;
      ((c.a)localObject).oKn = true;
      ((c.a)localObject).npX = new ColorDrawable(l.alv("#CCCCCC"));
      localObject = ((c.a)localObject).bKx();
      com.tencent.mm.modelimage.r.bKe().a(this.wAS.wsW, this.wBm, (com.tencent.mm.modelimage.loader.a.c)localObject);
    }
    for (;;)
    {
      if (Util.isNullOrNil(this.wAS.wsV)) {
        break label537;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.i.b.bmz();
      ((c.a)localObject).oKH = com.tencent.mm.modelimage.r.bKf();
      ((c.a)localObject).fullPath = m.akH(this.wAS.wsV);
      ((c.a)localObject).oKp = true;
      ((c.a)localObject).oKn = true;
      ((c.a)localObject).npX = new ColorDrawable(l.alv("#CCCCCC"));
      ((c.a)localObject).nrc = true;
      ((c.a)localObject).oKI = com.tencent.mm.cd.a.fromDPToPix(this, 8);
      localObject = ((c.a)localObject).bKx();
      com.tencent.mm.modelimage.r.bKe().a(this.wAS.wsV, this.wBl, (com.tencent.mm.modelimage.loader.a.c)localObject);
      AppMethodBeat.o(113362);
      return;
      this.wBi.setVisibility(8);
      break;
      label501:
      Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
      break label223;
      label513:
      Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
      break label263;
      label525:
      Log.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
    }
    label537:
    Log.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
    AppMethodBeat.o(113362);
  }
  
  private void dmM()
  {
    AppMethodBeat.i(113363);
    this.wBh.setVisibility(8);
    this.wBn.setVisibility(0);
    this.wBs.setText(this.wAS.wsX);
    Object localObject;
    if (this.wAS.wtr == 1)
    {
      this.wBv.setAlpha(0.5F);
      this.wBt.setVisibility(8);
      this.wBu.setVisibility(8);
      this.wBp.setVisibility(8);
      this.wBo.setVisibility(8);
      if (Util.isNullOrNil(this.wAS.wtd)) {
        break label667;
      }
      this.wBr.setVisibility(0);
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.i.b.bmz();
      ((c.a)localObject).oKH = com.tencent.mm.modelimage.r.bKf();
      ((c.a)localObject).fullPath = m.akH(this.wAS.wtd);
      ((c.a)localObject).oKp = true;
      ((c.a)localObject).oKn = true;
      localObject = ((c.a)localObject).bKx();
      com.tencent.mm.modelimage.r.bKe().a(this.wAS.wtd, this.wBr, (com.tencent.mm.modelimage.loader.a.c)localObject);
      label184:
      if (Util.isNullOrNil(this.wAS.wtc)) {
        break label700;
      }
      this.wBq.setVisibility(0);
      this.wBq.setText(this.wAS.wtc);
      if (Util.isNullOrNil(this.wAS.wtg)) {
        break label688;
      }
      this.wBq.setTextColor(Util.convertStringToRGB(this.wAS.wtg, getResources().getColor(com.tencent.mm.plugin.card.a.a.normal_text_color)));
      label259:
      if (Util.isNullOrNil(this.wAS.wth)) {
        break label721;
      }
      this.wBs.setTextColor(Util.convertStringToRGB(this.wAS.wth, getResources().getColor(com.tencent.mm.plugin.card.a.a.normal_text_color)));
      label299:
      if (Util.isNullOrNil(this.wAS.wsW)) {
        break label733;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.i.b.bmz();
      ((c.a)localObject).oKH = com.tencent.mm.modelimage.r.bKf();
      ((c.a)localObject).fullPath = m.akH(this.wAS.wsW);
      ((c.a)localObject).nrc = true;
      ((c.a)localObject).oKp = true;
      ((c.a)localObject).oKn = true;
      ((c.a)localObject).npX = new ColorDrawable(l.alv("#CCCCCC"));
      localObject = ((c.a)localObject).bKx();
      com.tencent.mm.modelimage.r.bKe().a(this.wAS.wsW, this.wBw, (com.tencent.mm.modelimage.loader.a.c)localObject);
    }
    for (;;)
    {
      if (Util.isNullOrNil(this.wAS.wsV)) {
        break label745;
      }
      localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.i.b.bmz();
      ((c.a)localObject).oKH = com.tencent.mm.modelimage.r.bKf();
      ((c.a)localObject).fullPath = m.akH(this.wAS.wsV);
      ((c.a)localObject).oKp = true;
      ((c.a)localObject).oKn = true;
      ((c.a)localObject).npX = new ColorDrawable(l.alv("#CCCCCC"));
      ((c.a)localObject).nrc = true;
      ((c.a)localObject).oKI = com.tencent.mm.cd.a.fromDPToPix(this, 8);
      localObject = ((c.a)localObject).bKx();
      com.tencent.mm.modelimage.r.bKe().a(this.wAS.wsV, this.wBv, (com.tencent.mm.modelimage.loader.a.c)localObject);
      AppMethodBeat.o(113363);
      return;
      this.wBt.setVisibility(0);
      this.wBu.setVisibility(0);
      this.wBp.setVisibility(0);
      this.wBo.setVisibility(0);
      this.wBt.setText(this.wAS.wsY);
      this.wBu.setText(a.g.woJ);
      if (Util.isNullOrNil(this.wAS.wsY))
      {
        this.wBt.setVisibility(8);
        this.wBu.setVisibility(8);
      }
      if (!Util.isNullOrNil(this.wAS.wti))
      {
        this.wBt.setTextColor(Util.convertStringToRGB(this.wAS.wti, getResources().getColor(com.tencent.mm.plugin.card.a.a.normal_text_color)));
        break;
      }
      Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardPriceTitleColor is empty");
      break;
      label667:
      this.wBr.setVisibility(8);
      Log.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
      break label184;
      label688:
      Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
      break label259;
      label700:
      this.wBq.setVisibility(8);
      Log.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
      break label259;
      label721:
      Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
      break label299;
      label733:
      Log.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
    }
    label745:
    Log.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
    AppMethodBeat.o(113363);
  }
  
  private void dmN()
  {
    AppMethodBeat.i(113366);
    if (this.wAS.wtp.size() > 0)
    {
      this.wBP.setVisibility(0);
      this.wBO.setVisibility(0);
      a locala = new a();
      this.wBO.setAdapter(locala);
      b(this.wBO);
      if (!Util.isNullOrNil(this.wAS.wtq))
      {
        this.wBN.setVisibility(0);
        this.wBN.setText(this.wAS.wtq);
      }
      AppMethodBeat.o(113366);
      return;
    }
    if (!Util.isNullOrNil(this.wAS.wtq))
    {
      this.wBP.setVisibility(0);
      this.wBN.setVisibility(0);
      this.wBN.setText(this.wAS.wtq);
      this.wBO.setVisibility(8);
      AppMethodBeat.o(113366);
      return;
    }
    this.wBP.setVisibility(8);
    this.wBN.setVisibility(8);
    this.wBO.setVisibility(8);
    AppMethodBeat.o(113366);
  }
  
  private void dmO()
  {
    AppMethodBeat.i(113370);
    if ((this.wAS != null) && (!Util.isNullOrNil(this.wAS.wsP))) {
      com.tencent.mm.plugin.card.c.a.h(this.wAS.wsP, this.wAS.wsS, this.wAS.wsZ, 2);
    }
    while ((this.wAS != null) && (!Util.isNullOrNil(this.wAS.wsR)))
    {
      com.tencent.mm.plugin.card.c.a.h(this.wAS.wsR, this.wAS.wsU, this.wAS.wtb, 2);
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
    if (!Util.isNullOrNil(this.wAS.wsN))
    {
      int i = com.tencent.mm.cd.a.fromDPToPix(this, 20);
      Object localObject = new c.a();
      ((c.a)localObject).prefixPath = com.tencent.mm.loader.i.b.bmz();
      ((c.a)localObject).oKH = com.tencent.mm.modelimage.r.bKf();
      ((c.a)localObject).fullPath = m.akH(this.wAS.wsN);
      ((c.a)localObject).oKp = true;
      ((c.a)localObject).nrc = true;
      ((c.a)localObject).oKI = 3.0F;
      ((c.a)localObject).oKn = true;
      ((c.a)localObject).npV = i;
      ((c.a)localObject).npU = i;
      ((c.a)localObject).npX = new ColorDrawable(l.alv("#CCCCCC"));
      localObject = ((c.a)localObject).bKx();
      com.tencent.mm.modelimage.r.bKe().a(this.wAS.wsN, paramImageView, (com.tencent.mm.modelimage.loader.a.c)localObject);
      AppMethodBeat.o(113361);
      return;
    }
    Log.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is null");
    AppMethodBeat.o(113361);
  }
  
  private int jt(int paramInt)
  {
    AppMethodBeat.i(113359);
    paramInt = com.tencent.mm.cd.a.fromDPToPix(getContext(), paramInt);
    AppMethodBeat.o(113359);
    return paramInt;
  }
  
  public int getLayoutId()
  {
    return a.e.wmF;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113368);
    this.wBg = ((ScrollView)findViewById(a.d.wgy));
    this.wBh = ((LinearLayout)findViewById(a.d.whT));
    this.wBi = ((ImageView)findViewById(a.d.wkz));
    this.wBj = ((TextView)findViewById(a.d.wlX));
    this.wBk = ((TextView)findViewById(a.d.wlW));
    this.wBl = ((ImageView)findViewById(a.d.wkx));
    this.wBm = ((ImageView)findViewById(a.d.wky));
    this.wBl.setOnClickListener(this);
    this.wBn = ((LinearLayout)findViewById(a.d.whS));
    this.wBo = ((RelativeLayout)findViewById(a.d.weT));
    this.wBp = ((RelativeLayout)findViewById(a.d.weU));
    this.wBq = ((TextView)findViewById(a.d.wlO));
    this.wBs = ((TextView)findViewById(a.d.wlV));
    this.wBr = ((ImageView)findViewById(a.d.wkw));
    this.wBt = ((TextView)findViewById(a.d.wlZ));
    this.wBu = ((TextView)findViewById(a.d.wma));
    this.wBv = ((ImageView)findViewById(a.d.wkr));
    this.wBw = ((ImageView)findViewById(a.d.wks));
    this.wBv.setOnClickListener(this);
    this.wBx = findViewById(a.d.wha);
    this.wBy = ((TextView)findViewById(a.d.wlY));
    this.wBz = ((LinearLayout)findViewById(a.d.wgZ));
    this.wBA = ((ListView)findViewById(a.d.whb));
    this.wBB = ((RelativeLayout)findViewById(a.d.wgn));
    this.wBC = ((LinearLayout)findViewById(a.d.wkh));
    this.wBD = ((ImageView)findViewById(a.d.wku));
    this.wBE = ((TextView)findViewById(a.d.wlT));
    this.wBF = ((LinearLayout)findViewById(a.d.wkg));
    this.wBK = ((ImageView)findViewById(a.d.wkt));
    this.wBL = ((TextView)findViewById(a.d.wlS));
    this.wBG = ((TextView)findViewById(a.d.wlR));
    this.wBH = ((RelativeLayout)findViewById(a.d.wgK));
    this.wBI = ((RelativeLayout)findViewById(a.d.wkl));
    this.wBJ = ((ImageView)findViewById(a.d.wlU));
    this.wBH.setOnClickListener(this);
    this.wBI.setOnClickListener(this);
    this.wBN = ((TextView)findViewById(a.d.wlI));
    this.wBO = ((ListView)findViewById(a.d.weL));
    this.wBP = ((RelativeLayout)findViewById(a.d.wgm));
    this.wBM = ((Button)findViewById(a.d.wgQ));
    this.wAV = ((ProgressBar)findViewById(a.d.wki));
    n.f(this);
    setMMTitle("");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(293777);
        CardGiftReceiveUI.this.finish();
        AppMethodBeat.o(293777);
        return true;
      }
    });
    AppMethodBeat.o(113368);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(113371);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    if (paramView.getId() == a.d.wkl) {
      if (!Util.isNullOrNil(this.wAS.wsQ))
      {
        paramView = new Intent(this, CardGiftVideoUI.class);
        paramView.putExtra("key_gift_into", this.wAS);
        paramView.putExtra("key_is_mute", false);
        paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramView.aYi(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramView.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        overridePendingTransition(0, 0);
        com.tencent.mm.plugin.report.service.h.OAn.b(13866, new Object[] { Integer.valueOf(3), this.nSs, com.tencent.mm.b.p.getString(this.nSr) });
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(113371);
      return;
      if (paramView.getId() == a.d.wgK)
      {
        if (this.wAV.getVisibility() == 0)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113371);
          return;
        }
        if (!Util.isNullOrNil(this.wAS.wsP))
        {
          paramView = new Intent(this, CardGiftImageUI.class);
          paramView.putExtra("key_gift_into", this.wAS);
          paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramView.aYi(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          overridePendingTransition(0, 0);
          com.tencent.mm.plugin.report.service.h.OAn.b(13866, new Object[] { Integer.valueOf(4), this.nSs, com.tencent.mm.b.p.getString(this.nSr) });
        }
      }
      else if (paramView.getId() == a.d.wlP)
      {
        if ((this.wAS != null) && (this.wAS.hPp))
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(13866, new Object[] { Integer.valueOf(7), this.nSs, com.tencent.mm.b.p.getString(this.nSr) });
          if ("cardhomepage/couponandgiftcard".equals(this.wAS.wtw)) {
            if (((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acYh, Boolean.TRUE)).booleanValue())
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
            paramView = new mg();
            paramView.hOp.context = getContext();
            paramView.publish();
            continue;
            paramView = new mg();
            paramView.hOp.context = getContext();
            paramView.hOp.scene = 2;
            paramView.publish();
            Log.i("MicroMsg.CardGiftReceiveUI", "enter to cardhome");
          }
        }
      }
      else if (paramView.getId() == a.d.wlQ)
      {
        if ((!TextUtils.isEmpty(this.wAS.wts)) && (!TextUtils.isEmpty(this.wAS.wtt)))
        {
          int i = getIntent().getIntExtra("key_from_appbrand_type", 0);
          com.tencent.mm.plugin.card.c.b.f(this.wAS.wtj, this.wAS.wts, this.wAS.wtt, 1062, i);
          com.tencent.mm.plugin.report.service.h.OAn.b(13866, new Object[] { Integer.valueOf(8), this.nSs, com.tencent.mm.b.p.getString(this.nSr) });
        }
        else if (!Util.isNullOrNil(this.wAS.wtl))
        {
          com.tencent.mm.plugin.card.c.b.a(this, this.wAS.wtl, 0);
          com.tencent.mm.plugin.report.service.h.OAn.b(13866, new Object[] { Integer.valueOf(8), this.nSs, com.tencent.mm.b.p.getString(this.nSr) });
        }
      }
      else if ((paramView.getId() == a.d.wkr) || (paramView.getId() == a.d.wkx))
      {
        if ((!Util.isNullOrNil(this.wAS.wtm)) && (!Util.isNullOrNil(this.wAS.wtn)))
        {
          paramView = new LinkedList();
          localObject = new wt();
          ((wt)localObject).wsy = this.wAS.wtm;
          ((wt)localObject).code = this.wAS.wtn;
          paramView.add(localObject);
          localObject = getIntent().getStringExtra("key_template_id");
          fhj localfhj = new fhj();
          localfhj.abHW = ((String)localObject);
          Log.i("MicroMsg.CardGiftReceiveUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { localObject });
          paramView = new t(paramView, localfhj, 27);
          com.tencent.mm.kernel.h.baD().mCm.a(paramView, 0);
          com.tencent.mm.plugin.report.service.h.OAn.b(13866, new Object[] { Integer.valueOf(9), this.nSs, com.tencent.mm.b.p.getString(this.nSr) });
        }
        else
        {
          Log.e("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.userCardId is null");
        }
      }
      else if (paramView.getId() == a.d.wlY)
      {
        if (this.wBA.getVisibility() == 0)
        {
          this.wBA.setVisibility(8);
          this.wBy.setText("查看全部");
        }
        else
        {
          this.wBA.setVisibility(0);
          this.wBy.setText("收起");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113356);
    super.onCreate(paramBundle);
    this.nSs = getIntent().getStringExtra("key_order_id");
    this.nSr = getIntent().getIntExtra("key_biz_uin", -1);
    this.wAS = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    Log.i("MicroMsg.CardGiftReceiveUI", "onCreate, orderId:%s, bizUin:%s", new Object[] { this.nSs, Integer.valueOf(this.nSr) });
    initView();
    com.tencent.mm.kernel.h.baD().mCm.a(1165, this);
    com.tencent.mm.kernel.h.baD().mCm.a(1099, this);
    com.tencent.mm.plugin.card.c.a.a(this.wBU);
    if (this.wAS == null)
    {
      Log.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo is null, sync GiftCard from serve");
      if (this.nSr == -1)
      {
        Log.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, bizUin is -1, fail!");
        AppMethodBeat.o(113356);
        return;
      }
      if (this.nSs == null) {
        Log.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, orderId is null, fail");
      }
      Log.e("MicroMsg.CardGiftReceiveUI", "doNetSceneGetCardGiftInfo");
      paramBundle = new z(this.nSr, this.nSs);
      com.tencent.mm.kernel.h.baD().mCm.a(paramBundle, 0);
      this.tipDialog = k.a(getContext(), getString(a.g.loading_tips), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(293775);
          if ((CardGiftReceiveUI.c(CardGiftReceiveUI.this) != null) && (CardGiftReceiveUI.c(CardGiftReceiveUI.this).isShowing())) {
            CardGiftReceiveUI.c(CardGiftReceiveUI.this).dismiss();
          }
          if ((CardGiftReceiveUI.d(CardGiftReceiveUI.this).getVisibility() == 8) || (CardGiftReceiveUI.e(CardGiftReceiveUI.this).getVisibility() == 4))
          {
            Log.i("MicroMsg.CardGiftReceiveUI", "user cancel & finish");
            CardGiftReceiveUI.this.finish();
          }
          AppMethodBeat.o(293775);
        }
      });
      if (this.tipDialog != null) {
        this.tipDialog.show();
      }
      AppMethodBeat.o(113356);
      return;
    }
    dlx();
    AppMethodBeat.o(113356);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113357);
    super.onDestroy();
    com.tencent.mm.kernel.h.baD().mCm.b(1165, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1099, this);
    com.tencent.mm.plugin.card.c.a.b(this.wBU);
    AppMethodBeat.o(113357);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(113369);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof z))
      {
        Log.i("MicroMsg.CardGiftReceiveUI", "card gift info cgi success!");
        this.wAS = ((z)paramp).wuB;
        dlx();
        AppMethodBeat.o(113369);
        return;
      }
      if ((paramp instanceof t))
      {
        paramString = new Intent(this, CardDetailUI.class);
        Object localObject = ((t)paramp).wuE;
        if ((localObject == null) || (((LinkedList)localObject).size() == 0))
        {
          Log.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardinfo list  size is null or empty!");
          AppMethodBeat.o(113369);
          return;
        }
        paramp = (com.tencent.mm.plugin.card.base.b)((LinkedList)localObject).get(0);
        if ((paramp == null) || (!(paramp instanceof CardInfo)))
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
        paramString.putExtra("key_card_info", (CardInfo)paramp);
        paramString.putExtra("key_previous_scene", 27);
        paramString.putExtra("key_from_scene", 27);
        paramString.putExtra("key_from_appbrand_type", paramString.getIntExtra("key_from_appbrand_type", 0));
        paramString.putExtra("key_card_git_info", this.wAS);
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/card/ui/CardGiftReceiveUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(113369);
      }
    }
    else
    {
      if ((paramp instanceof z))
      {
        Log.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        d.a(this, paramString, true);
        AppMethodBeat.o(113369);
        return;
      }
      if ((paramp instanceof t))
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
      int i = CardGiftReceiveUI.a(CardGiftReceiveUI.this).wtp.size();
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
      CardGiftInfo.AccepterItem localAccepterItem = (CardGiftInfo.AccepterItem)CardGiftReceiveUI.a(CardGiftReceiveUI.this).wtp.get(paramInt);
      ImageView localImageView;
      String str;
      if (paramView == null)
      {
        paramView = View.inflate(CardGiftReceiveUI.this, a.e.wmC, null);
        paramViewGroup = new CardGiftReceiveUI.b(CardGiftReceiveUI.this);
        paramViewGroup.wBY = ((ImageView)paramView.findViewById(a.d.wkk));
        paramViewGroup.wBZ = ((TextView)paramView.findViewById(a.d.wlJ));
        paramViewGroup.mll = ((TextView)paramView.findViewById(a.d.wlL));
        paramViewGroup.wCa = ((TextView)paramView.findViewById(a.d.wlK));
        paramView.setTag(paramViewGroup);
        if (localAccepterItem != null) {
          if (localAccepterItem.wtG != null)
          {
            localImageView = paramViewGroup.wBY;
            str = localAccepterItem.wtG;
            paramInt = a.c.my_card_package_defaultlogo;
            if ((localImageView != null) && (!TextUtils.isEmpty(str))) {
              break label239;
            }
          }
        }
      }
      for (;;)
      {
        paramViewGroup.wBZ.setText(localAccepterItem.wtF);
        paramViewGroup.mll.setText(localAccepterItem.wtD);
        paramViewGroup.wCa.setText(localAccepterItem.wtE + CardGiftReceiveUI.this.getContext().getString(a.g.woJ));
        AppMethodBeat.o(113349);
        return paramView;
        paramViewGroup = (CardGiftReceiveUI.b)paramView.getTag();
        break;
        label239:
        if (!TextUtils.isEmpty(str))
        {
          Object localObject = new c.a();
          ((c.a)localObject).prefixPath = com.tencent.mm.loader.i.b.bmz();
          ((c.a)localObject).oKH = com.tencent.mm.modelimage.r.bKf();
          ((c.a)localObject).fullPath = m.akH(str);
          ((c.a)localObject).oKp = true;
          ((c.a)localObject).nrc = true;
          ((c.a)localObject).oKI = 3.0F;
          ((c.a)localObject).oKn = true;
          ((c.a)localObject).npV = 34;
          ((c.a)localObject).npU = 34;
          ((c.a)localObject).oKB = paramInt;
          localObject = ((c.a)localObject).bKx();
          com.tencent.mm.modelimage.r.bKe().a(str, localImageView, (com.tencent.mm.modelimage.loader.a.c)localObject);
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
    public TextView mll;
    public ImageView wBY;
    public TextView wBZ;
    public TextView wCa;
    
    b() {}
  }
  
  final class c
    extends BaseAdapter
  {
    private LinkedList<CardGiftInfo.AcceptedCardItem> wCb;
    
    c()
    {
      Object localObject;
      this.wCb = localObject;
    }
    
    private CardGiftInfo.AcceptedCardItem Iw(int paramInt)
    {
      AppMethodBeat.i(113352);
      CardGiftInfo.AcceptedCardItem localAcceptedCardItem = (CardGiftInfo.AcceptedCardItem)this.wCb.get(paramInt);
      AppMethodBeat.o(113352);
      return localAcceptedCardItem;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(113351);
      int i = this.wCb.size();
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
      CardGiftInfo.AcceptedCardItem localAcceptedCardItem = Iw(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = View.inflate(CardGiftReceiveUI.this, a.e.wmB, null);
        paramView = new CardGiftReceiveUI.d(CardGiftReceiveUI.this);
        paramView.mll = ((TextView)localView.findViewById(a.d.wlN));
        paramView.wCa = ((TextView)localView.findViewById(a.d.wlM));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        paramViewGroup.mll.setText(localAcceptedCardItem.wtD);
        paramViewGroup.wCa.setText(localAcceptedCardItem.wtE + CardGiftReceiveUI.this.getContext().getString(a.g.woJ));
        AppMethodBeat.o(113353);
        return localView;
        paramViewGroup = (CardGiftReceiveUI.d)paramView.getTag();
        localView = paramView;
      }
    }
  }
  
  final class d
  {
    public TextView mll;
    public TextView wCa;
    
    d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftReceiveUI
 * JD-Core Version:    0.7.0.1
 */