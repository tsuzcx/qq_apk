package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.i;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.f;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.com;
import com.tencent.mm.protocal.protobuf.con;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.protocal.protobuf.rg;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CardIndexUI
  extends CardBaseUI
{
  private final String TAG = "MicroMsg.CardIndexUI";
  int fromScene = 0;
  private long mStartTime = 0L;
  private View nBA;
  private TextView nBB;
  private f nBC;
  private TextView nBD;
  private TextView nBE;
  private ImageView nBF;
  private LinearLayout nBG;
  int nBH = -1;
  
  private void bLe()
  {
    AppMethodBeat.i(113454);
    if ((this.npN.getChildCount() == 0) && (this.npL.getCount() == 0))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardIndexUI", "show empty view");
      this.npM.setVisibility(0);
      this.npK.setVisibility(8);
      AppMethodBeat.o(113454);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardIndexUI", "hide empty view");
    this.npM.setVisibility(8);
    this.npK.setVisibility(0);
    AppMethodBeat.o(113454);
  }
  
  private void cA(List<rg> paramList)
  {
    AppMethodBeat.i(113456);
    this.npN.removeAllViews();
    this.npN.setPadding(0, 0, 0, 0);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        Object localObject = (rg)paramList.next();
        View localView = View.inflate(getContext(), 2131493312, null);
        CdnImageView localCdnImageView = (CdnImageView)localView.findViewById(2131298358);
        TextView localTextView1 = (TextView)localView.findViewById(2131298359);
        TextView localTextView2 = (TextView)localView.findViewById(2131298357);
        localCdnImageView.setUrl(((rg)localObject).CRk);
        localTextView1.setText(((rg)localObject).CRj);
        localTextView2.setText(((rg)localObject).CRl);
        if (((rg)localObject).CRm > 0) {
          localView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(113449);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardIndexUI", "click header view: %s", new Object[] { Integer.valueOf(this.nBJ.CRm) });
              if (this.nBJ.CRm == 1)
              {
                com.tencent.mm.plugin.card.d.b.a(CardIndexUI.this, this.nBJ.CRn, 0);
                AppMethodBeat.o(113449);
                return;
              }
              if (this.nBJ.CRm == 2)
              {
                paramAnonymousView = new uj();
                paramAnonymousView.dzH.userName = this.nBJ.CRo.zHs;
                paramAnonymousView.dzH.dzJ = bt.by(this.nBJ.CRo.zHt, "");
                paramAnonymousView.dzH.scene = 1028;
                com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
              }
              AppMethodBeat.o(113449);
            }
          });
        }
        this.npN.addView(localView);
        if (i == 0) {
          this.npN.setPadding(0, com.tencent.mm.cd.a.fromDPToPix(this, 13), 0, 0);
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = (LinearLayout.LayoutParams)localView.getLayoutParams();
          if (localObject != null)
          {
            ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 6);
            localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(113456);
  }
  
  private void cz(List<com> paramList)
  {
    AppMethodBeat.i(113455);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        com localcom = (com)paramList.next();
        if (localcom.CQX == 1)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardIndexUI", "should update new invoice");
          cA(localcom.Eiu);
        }
      }
    }
    bLe();
    AppMethodBeat.o(113455);
  }
  
  public final BaseAdapter VY()
  {
    AppMethodBeat.i(113460);
    if (3 == this.nBH)
    {
      localObject = new k(this, bHp());
      AppMethodBeat.o(113460);
      return localObject;
    }
    Object localObject = new c(this, bHp());
    AppMethodBeat.o(113460);
    return localObject;
  }
  
  public final void bHo()
  {
    AppMethodBeat.i(113453);
    Object localObject;
    if (1 == this.nBH)
    {
      setMMTitle(2131756929);
      this.nBD = ((TextView)findViewById(2131302872));
      this.nBE = ((TextView)findViewById(2131302873));
      this.nBF = ((ImageView)findViewById(2131302870));
      this.nBA = findViewById(2131297793);
      this.nBB = ((TextView)findViewById(2131297794));
      this.nBG = ((LinearLayout)findViewById(2131302871));
      this.nBA.setVisibility(8);
      this.nBE.setVisibility(0);
      this.nBD.setVisibility(0);
      this.nBF.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.nBG.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = BackwardSupportUtil.b.g(this, 100.0F);
      this.nBG.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (1 != this.nBH) {
        break label363;
      }
      this.nBE.setText(getString(2131756917));
      this.nBD.setText(getString(2131756916));
    }
    for (;;)
    {
      if (this.nBH == 3)
      {
        this.npK.setEmptyView(null);
        this.npM.setVisibility(8);
      }
      this.nBB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113448);
          if (!TextUtils.isEmpty(CardIndexUI.a(CardIndexUI.this).nsP)) {
            com.tencent.mm.plugin.card.d.b.a(CardIndexUI.this, CardIndexUI.a(CardIndexUI.this).nsP, 0);
          }
          AppMethodBeat.o(113448);
        }
      });
      if ((this.nBH != 3) || (!((Boolean)g.afB().afk().get(ae.a.FhK, Boolean.FALSE)).booleanValue())) {
        break label447;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardIndexUI", "has load new entrance");
      localObject = (String)g.afB().afk().get(ae.a.FhI, null);
      if (bt.isNullOrNil((String)localObject)) {
        break label447;
      }
      try
      {
        con localcon = new con();
        localcon.parseFrom(((String)localObject).getBytes("ISO-8859-1"));
        cz(localcon.Eiv);
        AppMethodBeat.o(113453);
        return;
      }
      catch (IOException localIOException)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.CardIndexUI", localIOException, "", new Object[0]);
      }
      if (3 == this.nBH)
      {
        setMMTitle(2131757021);
        break;
      }
      setMMTitle(2131756939);
      break;
      label363:
      if (3 == this.nBH)
      {
        this.nBE.setText(getString(2131756923));
        this.nBD.setText(getString(2131756922));
      }
      else
      {
        this.nBE.setText(getString(2131756960));
        this.nBD.setText(getString(2131756975));
      }
    }
    label447:
    AppMethodBeat.o(113453);
  }
  
  public final n.a bHp()
  {
    AppMethodBeat.i(113459);
    if (1 == this.nBH)
    {
      locala = n.a.nts;
      AppMethodBeat.o(113459);
      return locala;
    }
    if (3 == this.nBH)
    {
      if (((Boolean)g.afB().afk().get(ae.a.FhK, Boolean.FALSE)).booleanValue())
      {
        locala = n.a.ntu;
        AppMethodBeat.o(113459);
        return locala;
      }
      locala = n.a.ntr;
      AppMethodBeat.o(113459);
      return locala;
    }
    n.a locala = n.a.nto;
    AppMethodBeat.o(113459);
    return locala;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113452);
    if (getIntent() != null) {
      this.nBH = getIntent().getIntExtra("key_card_type", -1);
    }
    super.initView();
    AppMethodBeat.o(113452);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(113462);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(113462);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113450);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardIndexUI", "oncreate");
    this.mStartTime = System.currentTimeMillis();
    initView();
    g.afA().gcy.a(1054, this);
    am.bIU();
    com.tencent.mm.plugin.card.b.b.yP(1);
    int i = am.bIZ().nrk;
    if ((com.tencent.mm.z.c.adr().cI(262152, 266256)) || (i > 0))
    {
      h.vKh.f(11324, new Object[] { "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "" });
      AppMethodBeat.o(113450);
      return;
    }
    h.vKh.f(11324, new Object[] { "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "" });
    AppMethodBeat.o(113450);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113451);
    g.afA().gcy.b(1054, this);
    long l1 = System.currentTimeMillis();
    long l2 = this.mStartTime;
    h.vKh.f(13219, new Object[] { "CardPackageListView", Integer.valueOf(this.fromScene), "", "", Long.valueOf(l1 - l2) });
    super.onDestroy();
    AppMethodBeat.o(113451);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113457);
    super.onResume();
    AppMethodBeat.o(113457);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(113461);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof x))
      {
        this.nBC = i.Rk((String)g.afB().afk().get(282885, ""));
        if (this.nBC == null) {
          this.nBC = new f();
        }
        if ((this.nBC != null) && (!TextUtils.isEmpty(this.nBC.nsN))) {
          this.nBD.setText(this.nBC.nsN);
        }
        if ((this.nBC == null) || (!this.nBC.nsQ))
        {
          this.nBA.setVisibility(8);
          AppMethodBeat.o(113461);
          return;
        }
        this.nBB.setText(this.nBC.nsO);
        if ((!TextUtils.isEmpty(this.nBC.nsO)) && (!TextUtils.isEmpty(this.nBC.nsP)))
        {
          this.nBA.setVisibility(0);
          AppMethodBeat.o(113461);
          return;
        }
        this.nBA.setVisibility(8);
        AppMethodBeat.o(113461);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.model.ad))
      {
        paramString = (com.tencent.mm.plugin.card.model.ad)paramn;
        if ((paramString.ntL) && ((this.npL instanceof c)))
        {
          ((c)this.npL).vw(false);
          ((c)this.npL).vw(true);
          ((c)this.npL).Wd();
        }
        if ((((Boolean)g.afB().afk().get(ae.a.FhK, Boolean.FALSE)).booleanValue()) && (paramString.ntN != null))
        {
          cz(paramString.ntN.Eiv);
          if ((this.npL instanceof c))
          {
            ((c)this.npL).vw(false);
            ((c)this.npL).vw(true);
            ((c)this.npL).Wd();
          }
        }
      }
    }
    AppMethodBeat.o(113461);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(113458);
    super.onStop();
    AppMethodBeat.o(113458);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardIndexUI
 * JD-Core Version:    0.7.0.1
 */