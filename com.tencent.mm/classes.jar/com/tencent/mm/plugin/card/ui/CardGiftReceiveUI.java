package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.il;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.a.a;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AcceptedCardItem;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.card.model.z;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.cgd;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftReceiveUI
  extends MMActivity
  implements View.OnClickListener, f
{
  private int fhN;
  private String fhO;
  private ProgressBar kuD;
  private ak kuE;
  private ScrollView kuN;
  private LinearLayout kuO;
  private ImageView kuP;
  private TextView kuQ;
  private TextView kuR;
  private ImageView kuS;
  private ImageView kuT;
  private LinearLayout kuU;
  private RelativeLayout kuV;
  private RelativeLayout kuW;
  private TextView kuX;
  private ImageView kuY;
  private TextView kuZ;
  private CardGiftInfo kuz;
  private TextView kva;
  private TextView kvb;
  private ImageView kvc;
  private ImageView kvd;
  private View kve;
  private TextView kvf;
  private LinearLayout kvg;
  private ListView kvh;
  private RelativeLayout kvi;
  private LinearLayout kvj;
  private ImageView kvk;
  private TextView kvl;
  private LinearLayout kvm;
  private TextView kvn;
  private RelativeLayout kvo;
  private RelativeLayout kvp;
  private ImageView kvq;
  private ImageView kvr;
  private TextView kvs;
  private TextView kvt;
  private ListView kvu;
  private RelativeLayout kvv;
  private TextView kvw;
  private TextView kvx;
  private View kvy;
  a.a kvz;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public CardGiftReceiveUI()
  {
    AppMethodBeat.i(88430);
    this.tipDialog = null;
    this.kuE = new ak(Looper.getMainLooper());
    this.kvz = new CardGiftReceiveUI.4(this);
    AppMethodBeat.o(88430);
  }
  
  private int L(int paramInt)
  {
    AppMethodBeat.i(88434);
    paramInt = com.tencent.mm.cb.a.fromDPToPix(getContext(), paramInt);
    AppMethodBeat.o(88434);
    return paramInt;
  }
  
  private void L(LinkedList<CardGiftInfo.AcceptedCardItem> paramLinkedList)
  {
    AppMethodBeat.i(88440);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      CardGiftInfo.AcceptedCardItem localAcceptedCardItem = (CardGiftInfo.AcceptedCardItem)paramLinkedList.next();
      View localView = View.inflate(this, 2130968935, null);
      TextView localTextView1 = (TextView)localView.findViewById(2131822123);
      TextView localTextView2 = (TextView)localView.findViewById(2131822124);
      localTextView1.setText(localAcceptedCardItem.knk);
      localTextView2.setText(localAcceptedCardItem.knl + getContext().getString(2131297924));
      this.kvg.addView(localView);
    }
    AppMethodBeat.o(88440);
  }
  
  private static void b(ListView paramListView)
  {
    AppMethodBeat.i(88442);
    ListAdapter localListAdapter = paramListView.getAdapter();
    if (localListAdapter == null)
    {
      AppMethodBeat.o(88442);
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
    AppMethodBeat.o(88442);
  }
  
  private void bcI()
  {
    AppMethodBeat.i(88433);
    if (this.kuz == null)
    {
      ab.e("MicroMsg.CardGiftReceiveUI", "doUpdate due to cardGiftInfo is null!");
      AppMethodBeat.o(88433);
      return;
    }
    ab.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descLayoutMode:%d", new Object[] { Integer.valueOf(this.kuz.kmU) });
    if ((this.kuz.kmU != 1) && (this.kuz.kmU == 2)) {
      bdY();
    }
    for (;;)
    {
      bdX();
      bcX();
      bea();
      if ((bo.isNullOrNil(this.kuz.kna)) && (bo.isNullOrNil(this.kuz.kmN))) {
        break;
      }
      this.kuN.getViewTreeObserver().addOnGlobalLayoutListener(new CardGiftReceiveUI.1(this));
      AppMethodBeat.o(88433);
      return;
      bdZ();
    }
    this.kuN.setFillViewport(true);
    AppMethodBeat.o(88433);
  }
  
  private void bcX()
  {
    int i = 0;
    AppMethodBeat.i(88439);
    if (this.kuz.kne.size() > 0)
    {
      this.kve.setVisibility(0);
      this.kvh.setVisibility(8);
      if (this.kuz.kne.size() <= 2)
      {
        this.kvf.setVisibility(8);
        L(this.kuz.kne);
        AppMethodBeat.o(88439);
        return;
      }
      Object localObject = new LinkedList();
      ((LinkedList)localObject).add(this.kuz.kne.get(0));
      ((LinkedList)localObject).add(this.kuz.kne.get(1));
      L((LinkedList)localObject);
      this.kvf.setVisibility(0);
      this.kvf.setOnClickListener(this);
      localObject = new LinkedList();
      while (i < this.kuz.kne.size())
      {
        if ((i != 0) && (i != 1)) {
          ((LinkedList)localObject).add(this.kuz.kne.get(i));
        }
        i += 1;
      }
      localObject = new c((LinkedList)localObject);
      this.kvh.setAdapter((ListAdapter)localObject);
      b(this.kvh);
      AppMethodBeat.o(88439);
      return;
    }
    this.kve.setVisibility(8);
    this.kvf.setVisibility(8);
    this.kvh.setVisibility(8);
    AppMethodBeat.o(88439);
  }
  
  private void bdX()
  {
    AppMethodBeat.i(88435);
    if (this.kuz.knh == 1)
    {
      this.kvj.setVisibility(0);
      this.kvm.setVisibility(8);
      this.kvi.setVisibility(8);
      this.kvl.setText(j.b(this, this.kuz.cFh, this.kvl.getTextSize()));
      g(this.kvk);
      AppMethodBeat.o(88435);
      return;
    }
    this.kvj.setVisibility(8);
    this.kvm.setVisibility(0);
    this.kvi.setVisibility(0);
    g(this.kvr);
    this.kvs.setText(j.b(this, this.kuz.cFh, this.kvs.getTextSize()));
    if (((!bo.isNullOrNil(this.kuz.kmD)) && (!"undefined".equals(this.kuz.kmD))) || ((!bo.isNullOrNil(this.kuz.kmE)) && (!"undefined".equals(this.kuz.kmE)))) {
      this.kvo.setVisibility(0);
    }
    for (;;)
    {
      beb();
      if (!bo.isNullOrNil(this.kuz.kmC)) {
        this.kvn.setText(j.b(this, this.kuz.kmC, this.kvn.getTextSize()));
      }
      AppMethodBeat.o(88435);
      return;
      this.kvo.setVisibility(8);
      ab.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is empty");
    }
  }
  
  private void bdY()
  {
    AppMethodBeat.i(88437);
    this.kuU.setVisibility(8);
    this.kuO.setVisibility(0);
    this.kuQ.setText(this.kuz.kmS);
    this.kuR.setText(this.kuz.kmL + "     " + this.kuz.kmM + getContext().getString(2131297924));
    Object localObject;
    if (!bo.isNullOrNil(this.kuz.kmT))
    {
      this.kuP.setVisibility(0);
      localObject = new c.a();
      ((c.a)localObject).eNP = e.eQz;
      o.ahH();
      ((c.a)localObject).eOd = null;
      ((c.a)localObject).eNO = com.tencent.mm.plugin.card.model.m.HO(this.kuz.kmT);
      ((c.a)localObject).eNM = true;
      ((c.a)localObject).eNK = true;
      localObject = ((c.a)localObject).ahY();
      o.ahG().a(this.kuz.kmT, this.kuP, (c)localObject);
      if (bo.isNullOrNil(this.kuz.kmW)) {
        break label506;
      }
      this.kuQ.setTextColor(bo.bS(this.kuz.kmW, getResources().getColor(2131689763)));
      label224:
      if (bo.isNullOrNil(this.kuz.kmX)) {
        break label518;
      }
      this.kuR.setTextColor(bo.bS(this.kuz.kmX, getResources().getColor(2131689763)));
      label264:
      if (bo.isNullOrNil(this.kuz.kmK)) {
        break label530;
      }
      localObject = new c.a();
      ((c.a)localObject).eNP = e.eQz;
      o.ahH();
      ((c.a)localObject).eOd = null;
      ((c.a)localObject).eNO = com.tencent.mm.plugin.card.model.m.HO(this.kuz.kmK);
      ((c.a)localObject).eOk = true;
      ((c.a)localObject).eNM = true;
      ((c.a)localObject).eNK = true;
      ((c.a)localObject).eNZ = new ColorDrawable(l.IB("#CCCCCC"));
      localObject = ((c.a)localObject).ahY();
      o.ahG().a(this.kuz.kmK, this.kuT, (c)localObject);
    }
    for (;;)
    {
      if (bo.isNullOrNil(this.kuz.kmJ)) {
        break label542;
      }
      localObject = new c.a();
      ((c.a)localObject).eNP = e.eQz;
      o.ahH();
      ((c.a)localObject).eOd = null;
      ((c.a)localObject).eNO = com.tencent.mm.plugin.card.model.m.HO(this.kuz.kmJ);
      ((c.a)localObject).eNM = true;
      ((c.a)localObject).eNK = true;
      ((c.a)localObject).eNZ = new ColorDrawable(l.IB("#CCCCCC"));
      ((c.a)localObject).eOk = true;
      ((c.a)localObject).eOl = com.tencent.mm.cb.a.fromDPToPix(this, 8);
      localObject = ((c.a)localObject).ahY();
      o.ahG().a(this.kuz.kmJ, this.kuS, (c)localObject);
      AppMethodBeat.o(88437);
      return;
      this.kuP.setVisibility(8);
      break;
      label506:
      ab.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
      break label224;
      label518:
      ab.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
      break label264;
      label530:
      ab.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
    }
    label542:
    ab.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
    AppMethodBeat.o(88437);
  }
  
  private void bdZ()
  {
    AppMethodBeat.i(88438);
    this.kuO.setVisibility(8);
    this.kuU.setVisibility(0);
    this.kuZ.setText(this.kuz.kmL);
    Object localObject;
    if (this.kuz.knh == 1)
    {
      this.kvc.setAlpha(0.5F);
      this.kva.setVisibility(8);
      this.kvb.setVisibility(8);
      this.kuW.setVisibility(8);
      this.kuV.setVisibility(8);
      if (bo.isNullOrNil(this.kuz.kmT)) {
        break label672;
      }
      this.kuY.setVisibility(0);
      localObject = new c.a();
      ((c.a)localObject).eNP = e.eQz;
      o.ahH();
      ((c.a)localObject).eOd = null;
      ((c.a)localObject).eNO = com.tencent.mm.plugin.card.model.m.HO(this.kuz.kmT);
      ((c.a)localObject).eNM = true;
      ((c.a)localObject).eNK = true;
      localObject = ((c.a)localObject).ahY();
      o.ahG().a(this.kuz.kmT, this.kuY, (c)localObject);
      label186:
      if (bo.isNullOrNil(this.kuz.kmS)) {
        break label705;
      }
      this.kuX.setVisibility(0);
      this.kuX.setText(this.kuz.kmS);
      if (bo.isNullOrNil(this.kuz.kmW)) {
        break label693;
      }
      this.kuX.setTextColor(bo.bS(this.kuz.kmW, getResources().getColor(2131689763)));
      label261:
      if (bo.isNullOrNil(this.kuz.kmX)) {
        break label726;
      }
      this.kuZ.setTextColor(bo.bS(this.kuz.kmX, getResources().getColor(2131689763)));
      label301:
      if (bo.isNullOrNil(this.kuz.kmK)) {
        break label738;
      }
      localObject = new c.a();
      ((c.a)localObject).eNP = e.eQz;
      o.ahH();
      ((c.a)localObject).eOd = null;
      ((c.a)localObject).eNO = com.tencent.mm.plugin.card.model.m.HO(this.kuz.kmK);
      ((c.a)localObject).eOk = true;
      ((c.a)localObject).eNM = true;
      ((c.a)localObject).eNK = true;
      ((c.a)localObject).eNZ = new ColorDrawable(l.IB("#CCCCCC"));
      localObject = ((c.a)localObject).ahY();
      o.ahG().a(this.kuz.kmK, this.kvd, (c)localObject);
    }
    for (;;)
    {
      if (bo.isNullOrNil(this.kuz.kmJ)) {
        break label750;
      }
      localObject = new c.a();
      ((c.a)localObject).eNP = e.eQz;
      o.ahH();
      ((c.a)localObject).eOd = null;
      ((c.a)localObject).eNO = com.tencent.mm.plugin.card.model.m.HO(this.kuz.kmJ);
      ((c.a)localObject).eNM = true;
      ((c.a)localObject).eNK = true;
      ((c.a)localObject).eNZ = new ColorDrawable(l.IB("#CCCCCC"));
      ((c.a)localObject).eOk = true;
      ((c.a)localObject).eOl = com.tencent.mm.cb.a.fromDPToPix(this, 8);
      localObject = ((c.a)localObject).ahY();
      o.ahG().a(this.kuz.kmJ, this.kvc, (c)localObject);
      AppMethodBeat.o(88438);
      return;
      this.kva.setVisibility(0);
      this.kvb.setVisibility(0);
      this.kuW.setVisibility(0);
      this.kuV.setVisibility(0);
      this.kva.setText(this.kuz.kmM);
      this.kvb.setText(2131297924);
      if (bo.isNullOrNil(this.kuz.kmM))
      {
        this.kva.setVisibility(8);
        this.kvb.setVisibility(8);
      }
      if (!bo.isNullOrNil(this.kuz.kmY))
      {
        this.kva.setTextColor(bo.bS(this.kuz.kmY, getResources().getColor(2131689763)));
        break;
      }
      ab.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardPriceTitleColor is empty");
      break;
      label672:
      this.kuY.setVisibility(8);
      ab.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
      break label186;
      label693:
      ab.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
      break label261;
      label705:
      this.kuX.setVisibility(8);
      ab.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
      break label261;
      label726:
      ab.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
      break label301;
      label738:
      ab.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
    }
    label750:
    ab.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
    AppMethodBeat.o(88438);
  }
  
  private void bea()
  {
    AppMethodBeat.i(88441);
    if (this.kuz.knf.size() > 0)
    {
      this.kvv.setVisibility(0);
      this.kvu.setVisibility(0);
      CardGiftReceiveUI.a locala = new CardGiftReceiveUI.a(this);
      this.kvu.setAdapter(locala);
      b(this.kvu);
      if (!bo.isNullOrNil(this.kuz.kng))
      {
        this.kvt.setVisibility(0);
        this.kvt.setText(this.kuz.kng);
      }
      AppMethodBeat.o(88441);
      return;
    }
    this.kvv.setVisibility(0);
    this.kvu.setVisibility(0);
    this.kvt.setVisibility(0);
    if (!bo.isNullOrNil(this.kuz.kng))
    {
      this.kvt.setVisibility(0);
      this.kvt.setText(this.kuz.kng);
    }
    AppMethodBeat.o(88441);
  }
  
  private void beb()
  {
    AppMethodBeat.i(88445);
    if ((this.kuz != null) && (!bo.isNullOrNil(this.kuz.kmD))) {
      com.tencent.mm.plugin.card.d.a.h(this.kuz.kmD, this.kuz.kmG, this.kuz.kmP, 2);
    }
    while ((this.kuz != null) && (!bo.isNullOrNil(this.kuz.kmF)))
    {
      com.tencent.mm.plugin.card.d.a.h(this.kuz.kmF, this.kuz.kmI, this.kuz.kmR, 2);
      AppMethodBeat.o(88445);
      return;
      ab.e("MicroMsg.CardGiftReceiveUI", "fromUserContentPicUrl is null");
    }
    ab.e("MicroMsg.CardGiftReceiveUI", "fromUserContentThumbPicUrl is null");
    AppMethodBeat.o(88445);
  }
  
  private void g(ImageView paramImageView)
  {
    AppMethodBeat.i(88436);
    if (!bo.isNullOrNil(this.kuz.kmB))
    {
      int i = com.tencent.mm.cb.a.fromDPToPix(this, 20);
      Object localObject = new c.a();
      ((c.a)localObject).eNP = e.eQz;
      o.ahH();
      ((c.a)localObject).eOd = null;
      ((c.a)localObject).eNO = com.tencent.mm.plugin.card.model.m.HO(this.kuz.kmB);
      ((c.a)localObject).eNM = true;
      ((c.a)localObject).eOk = true;
      ((c.a)localObject).eOl = 3.0F;
      ((c.a)localObject).eNK = true;
      ((c.a)localObject).eNT = i;
      ((c.a)localObject).eNS = i;
      ((c.a)localObject).eNZ = new ColorDrawable(l.IB("#CCCCCC"));
      localObject = ((c.a)localObject).ahY();
      o.ahG().a(this.kuz.kmB, paramImageView, (c)localObject);
      AppMethodBeat.o(88436);
      return;
    }
    ab.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is null");
    AppMethodBeat.o(88436);
  }
  
  public int getLayoutId()
  {
    return 2130968940;
  }
  
  public void initView()
  {
    AppMethodBeat.i(88443);
    this.kuN = ((ScrollView)findViewById(2131822158));
    this.kuO = ((LinearLayout)findViewById(2131822160));
    this.kuP = ((ImageView)findViewById(2131822161));
    this.kuQ = ((TextView)findViewById(2131822162));
    this.kuR = ((TextView)findViewById(2131822165));
    this.kuS = ((ImageView)findViewById(2131822163));
    this.kuT = ((ImageView)findViewById(2131822164));
    this.kuS.setOnClickListener(this);
    this.kuU = ((LinearLayout)findViewById(2131822166));
    this.kuV = ((RelativeLayout)findViewById(2131822167));
    this.kuW = ((RelativeLayout)findViewById(2131822168));
    this.kuX = ((TextView)findViewById(2131822141));
    this.kuZ = ((TextView)findViewById(2131822144));
    this.kuY = ((ImageView)findViewById(2131822143));
    this.kva = ((TextView)findViewById(2131822145));
    this.kvb = ((TextView)findViewById(2131822169));
    this.kvc = ((ImageView)findViewById(2131822147));
    this.kvd = ((ImageView)findViewById(2131822148));
    this.kvc.setOnClickListener(this);
    this.kve = findViewById(2131822173);
    this.kvf = ((TextView)findViewById(2131822176));
    this.kvg = ((LinearLayout)findViewById(2131822174));
    this.kvh = ((ListView)findViewById(2131822175));
    this.kvi = ((RelativeLayout)findViewById(2131822177));
    this.kvj = ((LinearLayout)findViewById(2131822170));
    this.kvk = ((ImageView)findViewById(2131822171));
    this.kvl = ((TextView)findViewById(2131822172));
    this.kvm = ((LinearLayout)findViewById(2131822179));
    this.kvr = ((ImageView)findViewById(2131822155));
    this.kvs = ((TextView)findViewById(2131822156));
    this.kvn = ((TextView)findViewById(2131822180));
    this.kvo = ((RelativeLayout)findViewById(2131822181));
    this.kvp = ((RelativeLayout)findViewById(2131822182));
    this.kvq = ((ImageView)findViewById(2131822152));
    this.kvo.setOnClickListener(this);
    this.kvp.setOnClickListener(this);
    this.kvt = ((TextView)findViewById(2131822185));
    this.kvu = ((ListView)findViewById(2131822186));
    this.kvv = ((RelativeLayout)findViewById(2131822183));
    this.kuD = ((ProgressBar)findViewById(2131822138));
    com.tencent.mm.plugin.card.d.m.d(this);
    setMMTitle("");
    setBackBtn(new CardGiftReceiveUI.2(this));
    AppMethodBeat.o(88443);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(88446);
    if (paramView.getId() == 2131822182)
    {
      if (!bo.isNullOrNil(this.kuz.kmE))
      {
        paramView = new Intent(this, CardGiftVideoUI.class);
        paramView.putExtra("key_gift_into", this.kuz);
        paramView.putExtra("key_is_mute", false);
        startActivity(paramView);
        overridePendingTransition(0, 0);
        com.tencent.mm.plugin.report.service.h.qsU.e(13866, new Object[] { Integer.valueOf(3), this.fhO, com.tencent.mm.a.p.getString(this.fhN) });
        AppMethodBeat.o(88446);
      }
    }
    else if (paramView.getId() == 2131822181)
    {
      if (this.kuD.getVisibility() == 0)
      {
        AppMethodBeat.o(88446);
        return;
      }
      if (!bo.isNullOrNil(this.kuz.kmD))
      {
        paramView = new Intent(this, CardGiftImageUI.class);
        paramView.putExtra("key_gift_into", this.kuz);
        startActivity(paramView);
        overridePendingTransition(0, 0);
        com.tencent.mm.plugin.report.service.h.qsU.e(13866, new Object[] { Integer.valueOf(4), this.fhO, com.tencent.mm.a.p.getString(this.fhN) });
        AppMethodBeat.o(88446);
      }
    }
    else if (paramView.getId() == 2131822134)
    {
      if ((this.kuz != null) && (this.kuz.kmO))
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(13866, new Object[] { Integer.valueOf(7), this.fhO, com.tencent.mm.a.p.getString(this.fhN) });
        paramView = new il();
        paramView.cxQ.context = getContext();
        paramView.cxQ.scene = 2;
        com.tencent.mm.sdk.b.a.ymk.l(paramView);
        ab.i("MicroMsg.CardGiftReceiveUI", "enter to cardhome");
        finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(88446);
      }
    }
    else if (paramView.getId() == 2131822133)
    {
      if ((!TextUtils.isEmpty(this.kuz.kni)) && (!TextUtils.isEmpty(this.kuz.knj)))
      {
        int i = getIntent().getIntExtra("key_from_appbrand_type", 0);
        com.tencent.mm.plugin.card.d.b.d(this.kuz.kmZ, this.kuz.kni, this.kuz.knj, 1062, i);
        com.tencent.mm.plugin.report.service.h.qsU.e(13866, new Object[] { Integer.valueOf(8), this.fhO, com.tencent.mm.a.p.getString(this.fhN) });
        AppMethodBeat.o(88446);
        return;
      }
      if (!bo.isNullOrNil(this.kuz.knb))
      {
        com.tencent.mm.plugin.card.d.b.a(this, this.kuz.knb, 0);
        com.tencent.mm.plugin.report.service.h.qsU.e(13866, new Object[] { Integer.valueOf(8), this.fhO, com.tencent.mm.a.p.getString(this.fhN) });
        AppMethodBeat.o(88446);
      }
    }
    else
    {
      if ((paramView.getId() == 2131822147) || (paramView.getId() == 2131822163))
      {
        if ((!bo.isNullOrNil(this.kuz.knc)) && (!bo.isNullOrNil(this.kuz.knd)))
        {
          paramView = new LinkedList();
          Object localObject = new ph();
          ((ph)localObject).kml = this.kuz.knc;
          ((ph)localObject).code = this.kuz.knd;
          paramView.add(localObject);
          localObject = getIntent().getStringExtra("key_template_id");
          cgd localcgd = new cgd();
          localcgd.xQS = ((String)localObject);
          ab.i("MicroMsg.CardGiftReceiveUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { localObject });
          paramView = new t(paramView, localcgd, 27);
          g.RK().eHt.a(paramView, 0);
          com.tencent.mm.plugin.report.service.h.qsU.e(13866, new Object[] { Integer.valueOf(9), this.fhO, com.tencent.mm.a.p.getString(this.fhN) });
          AppMethodBeat.o(88446);
          return;
        }
        ab.e("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.userCardId is null");
        AppMethodBeat.o(88446);
        return;
      }
      if (paramView.getId() == 2131822176)
      {
        if (this.kvh.getVisibility() == 0)
        {
          this.kvh.setVisibility(8);
          this.kvf.setText("查看全部");
          AppMethodBeat.o(88446);
          return;
        }
        this.kvh.setVisibility(0);
        this.kvf.setText("收起");
      }
    }
    AppMethodBeat.o(88446);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(88431);
    super.onCreate(paramBundle);
    this.fhO = getIntent().getStringExtra("key_order_id");
    this.fhN = getIntent().getIntExtra("key_biz_uin", -1);
    this.kuz = ((CardGiftInfo)getIntent().getParcelableExtra("key_gift_into"));
    ab.i("MicroMsg.CardGiftReceiveUI", "onCreate, orderId:%s, bizUin:%s", new Object[] { this.fhO, Integer.valueOf(this.fhN) });
    initView();
    g.RK().eHt.a(1165, this);
    g.RK().eHt.a(699, this);
    com.tencent.mm.plugin.card.d.a.a(this.kvz);
    if (this.kuz == null)
    {
      ab.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo is null, sync GiftCard from serve");
      if (this.fhN == -1)
      {
        ab.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, bizUin is -1, fail!");
        AppMethodBeat.o(88431);
        return;
      }
      if (this.fhO == null) {
        ab.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, orderId is null, fail");
      }
      ab.e("MicroMsg.CardGiftReceiveUI", "doNetSceneGetCardGiftInfo");
      paramBundle = new z(this.fhN, this.fhO);
      g.RK().eHt.a(paramBundle, 0);
      this.tipDialog = com.tencent.mm.ui.base.h.b(getContext(), getString(2131301086), true, new CardGiftReceiveUI.3(this));
      if (this.tipDialog != null) {
        this.tipDialog.show();
      }
      AppMethodBeat.o(88431);
      return;
    }
    bcI();
    AppMethodBeat.o(88431);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(88432);
    super.onDestroy();
    g.RK().eHt.b(1165, this);
    g.RK().eHt.b(699, this);
    com.tencent.mm.plugin.card.d.a.b(this.kvz);
    AppMethodBeat.o(88432);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(88444);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof z))
      {
        ab.i("MicroMsg.CardGiftReceiveUI", "card gift info cgi success!");
        this.kuz = ((z)paramm).kol;
        bcI();
        AppMethodBeat.o(88444);
        return;
      }
      if ((paramm instanceof t))
      {
        paramString = new Intent(this, CardDetailUI.class);
        Object localObject = ((t)paramm).kop;
        if ((localObject == null) || (((LinkedList)localObject).size() == 0))
        {
          ab.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardinfo list  size is null or empty!");
          AppMethodBeat.o(88444);
          return;
        }
        paramm = (com.tencent.mm.plugin.card.base.b)((LinkedList)localObject).get(0);
        if ((paramm == null) || (!(paramm instanceof CardInfo)))
        {
          ab.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardInfo  is null!");
          AppMethodBeat.o(88444);
          return;
        }
        ArrayList localArrayList = new ArrayList();
        localObject = ((LinkedList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList.add((CardInfo)((Iterator)localObject).next());
        }
        paramString.putExtra("key_card_info", (CardInfo)paramm);
        paramString.putExtra("key_previous_scene", 27);
        paramString.putExtra("key_from_scene", 27);
        paramString.putExtra("key_from_appbrand_type", paramString.getIntExtra("key_from_appbrand_type", 0));
        paramString.putExtra("key_card_git_info", this.kuz);
        startActivity(paramString);
        AppMethodBeat.o(88444);
      }
    }
    else
    {
      if ((paramm instanceof z))
      {
        ab.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        d.a(this, paramString, true);
        AppMethodBeat.o(88444);
        return;
      }
      if ((paramm instanceof t))
      {
        ab.e("MicroMsg.CardGiftReceiveUI", ", NetSceneBatchGetCardItemByTpInfo onSceneEnd fail return!  errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        AppMethodBeat.o(88444);
        return;
      }
    }
    AppMethodBeat.o(88444);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class c
    extends BaseAdapter
  {
    private LinkedList<CardGiftInfo.AcceptedCardItem> kvE;
    
    c()
    {
      Object localObject;
      this.kvE = localObject;
    }
    
    private CardGiftInfo.AcceptedCardItem tk(int paramInt)
    {
      AppMethodBeat.i(88427);
      CardGiftInfo.AcceptedCardItem localAcceptedCardItem = (CardGiftInfo.AcceptedCardItem)this.kvE.get(paramInt);
      AppMethodBeat.o(88427);
      return localAcceptedCardItem;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(88426);
      int i = this.kvE.size();
      AppMethodBeat.o(88426);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(88428);
      CardGiftInfo.AcceptedCardItem localAcceptedCardItem = tk(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = View.inflate(CardGiftReceiveUI.this, 2130968935, null);
        paramView = new CardGiftReceiveUI.d(CardGiftReceiveUI.this);
        paramView.gui = ((TextView)localView.findViewById(2131822123));
        paramView.kvD = ((TextView)localView.findViewById(2131822124));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        paramViewGroup.gui.setText(localAcceptedCardItem.knk);
        paramViewGroup.kvD.setText(localAcceptedCardItem.knl + CardGiftReceiveUI.this.getContext().getString(2131297924));
        AppMethodBeat.o(88428);
        return localView;
        paramViewGroup = (CardGiftReceiveUI.d)paramView.getTag();
        localView = paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftReceiveUI
 * JD-Core Version:    0.7.0.1
 */