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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.i;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.f;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ctt;
import com.tencent.mm.protocal.protobuf.ctu;
import com.tencent.mm.protocal.protobuf.rm;
import com.tencent.mm.protocal.protobuf.rq;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CardIndexUI
  extends CardBaseUI
{
  private final String TAG = "MicroMsg.CardIndexUI";
  int fromScene = 0;
  private long mStartTime = 0L;
  private View oeA;
  private TextView oeB;
  private f oeC;
  private TextView oeD;
  private TextView oeE;
  private ImageView oeF;
  private LinearLayout oeG;
  int oeH = -1;
  
  private void bSr()
  {
    AppMethodBeat.i(113454);
    if ((this.nSN.getChildCount() == 0) && (this.nSL.getCount() == 0))
    {
      ac.i("MicroMsg.CardIndexUI", "show empty view");
      this.nSM.setVisibility(0);
      this.nSK.setVisibility(8);
      AppMethodBeat.o(113454);
      return;
    }
    ac.i("MicroMsg.CardIndexUI", "hide empty view");
    this.nSM.setVisibility(8);
    this.nSK.setVisibility(0);
    AppMethodBeat.o(113454);
  }
  
  private void cB(List<ctt> paramList)
  {
    AppMethodBeat.i(113455);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ctt localctt = (ctt)paramList.next();
        if (localctt.EjI == 1)
        {
          ac.i("MicroMsg.CardIndexUI", "should update new invoice");
          cC(localctt.FFs);
        }
      }
    }
    bSr();
    AppMethodBeat.o(113455);
  }
  
  private void cC(List<rq> paramList)
  {
    AppMethodBeat.i(113456);
    this.nSN.removeAllViews();
    this.nSN.setPadding(0, 0, 0, 0);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        Object localObject = (rq)paramList.next();
        View localView = View.inflate(getContext(), 2131493312, null);
        CdnImageView localCdnImageView = (CdnImageView)localView.findViewById(2131298358);
        TextView localTextView1 = (TextView)localView.findViewById(2131298359);
        TextView localTextView2 = (TextView)localView.findViewById(2131298357);
        localCdnImageView.setUrl(((rq)localObject).EjV);
        localTextView1.setText(((rq)localObject).EjU);
        localTextView2.setText(((rq)localObject).EjW);
        if (((rq)localObject).EjX > 0) {
          localView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(113449);
              ac.i("MicroMsg.CardIndexUI", "click header view: %s", new Object[] { Integer.valueOf(this.oeJ.EjX) });
              if (this.oeJ.EjX == 1)
              {
                com.tencent.mm.plugin.card.d.b.a(CardIndexUI.this, this.oeJ.EjY, 0);
                AppMethodBeat.o(113449);
                return;
              }
              if (this.oeJ.EjX == 2)
              {
                paramAnonymousView = new ut();
                paramAnonymousView.dxt.userName = this.oeJ.EjZ.AZE;
                paramAnonymousView.dxt.dxv = bs.bG(this.oeJ.EjZ.AZF, "");
                paramAnonymousView.dxt.scene = 1028;
                com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
              }
              AppMethodBeat.o(113449);
            }
          });
        }
        this.nSN.addView(localView);
        if (i == 0) {
          this.nSN.setPadding(0, com.tencent.mm.cc.a.fromDPToPix(this, 13), 0, 0);
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = (LinearLayout.LayoutParams)localView.getLayoutParams();
          if (localObject != null)
          {
            ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cc.a.fromDPToPix(this, 6);
            localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(113456);
  }
  
  public final BaseAdapter WW()
  {
    AppMethodBeat.i(113460);
    if (3 == this.oeH)
    {
      localObject = new k(this, bOC());
      AppMethodBeat.o(113460);
      return localObject;
    }
    Object localObject = new c(this, bOC());
    AppMethodBeat.o(113460);
    return localObject;
  }
  
  public final void bOB()
  {
    AppMethodBeat.i(113453);
    Object localObject;
    if (1 == this.oeH)
    {
      setMMTitle(2131756929);
      this.oeD = ((TextView)findViewById(2131302872));
      this.oeE = ((TextView)findViewById(2131302873));
      this.oeF = ((ImageView)findViewById(2131302870));
      this.oeA = findViewById(2131297793);
      this.oeB = ((TextView)findViewById(2131297794));
      this.oeG = ((LinearLayout)findViewById(2131302871));
      this.oeA.setVisibility(8);
      this.oeE.setVisibility(0);
      this.oeD.setVisibility(0);
      this.oeF.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.oeG.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = BackwardSupportUtil.b.g(this, 100.0F);
      this.oeG.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (1 != this.oeH) {
        break label363;
      }
      this.oeE.setText(getString(2131756917));
      this.oeD.setText(getString(2131756916));
    }
    for (;;)
    {
      if (this.oeH == 3)
      {
        this.nSK.setEmptyView(null);
        this.nSM.setVisibility(8);
      }
      this.oeB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113448);
          if (!TextUtils.isEmpty(CardIndexUI.a(CardIndexUI.this).nVP)) {
            com.tencent.mm.plugin.card.d.b.a(CardIndexUI.this, CardIndexUI.a(CardIndexUI.this).nVP, 0);
          }
          AppMethodBeat.o(113448);
        }
      });
      if ((this.oeH != 3) || (!((Boolean)g.agR().agA().get(ah.a.GFz, Boolean.FALSE)).booleanValue())) {
        break label447;
      }
      ac.i("MicroMsg.CardIndexUI", "has load new entrance");
      localObject = (String)g.agR().agA().get(ah.a.GFx, null);
      if (bs.isNullOrNil((String)localObject)) {
        break label447;
      }
      try
      {
        ctu localctu = new ctu();
        localctu.parseFrom(((String)localObject).getBytes("ISO-8859-1"));
        cB(localctu.FFt);
        AppMethodBeat.o(113453);
        return;
      }
      catch (IOException localIOException)
      {
        ac.printErrStackTrace("MicroMsg.CardIndexUI", localIOException, "", new Object[0]);
      }
      if (3 == this.oeH)
      {
        setMMTitle(2131757021);
        break;
      }
      setMMTitle(2131756939);
      break;
      label363:
      if (3 == this.oeH)
      {
        this.oeE.setText(getString(2131756923));
        this.oeD.setText(getString(2131756922));
      }
      else
      {
        this.oeE.setText(getString(2131756960));
        this.oeD.setText(getString(2131756975));
      }
    }
    label447:
    AppMethodBeat.o(113453);
  }
  
  public final n.a bOC()
  {
    AppMethodBeat.i(113459);
    if (1 == this.oeH)
    {
      locala = n.a.nWs;
      AppMethodBeat.o(113459);
      return locala;
    }
    if (3 == this.oeH)
    {
      if (((Boolean)g.agR().agA().get(ah.a.GFz, Boolean.FALSE)).booleanValue())
      {
        locala = n.a.nWu;
        AppMethodBeat.o(113459);
        return locala;
      }
      locala = n.a.nWr;
      AppMethodBeat.o(113459);
      return locala;
    }
    n.a locala = n.a.nWo;
    AppMethodBeat.o(113459);
    return locala;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113452);
    if (getIntent() != null) {
      this.oeH = getIntent().getIntExtra("key_card_type", -1);
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
    ac.i("MicroMsg.CardIndexUI", "oncreate");
    this.mStartTime = System.currentTimeMillis();
    initView();
    g.agQ().ghe.a(1054, this);
    am.bQh();
    com.tencent.mm.plugin.card.b.b.zF(1);
    int i = am.bQm().nUk;
    if ((com.tencent.mm.y.c.aeH().cG(262152, 266256)) || (i > 0))
    {
      h.wUl.f(11324, new Object[] { "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "" });
      AppMethodBeat.o(113450);
      return;
    }
    h.wUl.f(11324, new Object[] { "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "" });
    AppMethodBeat.o(113450);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113451);
    g.agQ().ghe.b(1054, this);
    long l1 = System.currentTimeMillis();
    long l2 = this.mStartTime;
    h.wUl.f(13219, new Object[] { "CardPackageListView", Integer.valueOf(this.fromScene), "", "", Long.valueOf(l1 - l2) });
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
        this.oeC = i.Vw((String)g.agR().agA().get(282885, ""));
        if (this.oeC == null) {
          this.oeC = new f();
        }
        if ((this.oeC != null) && (!TextUtils.isEmpty(this.oeC.nVN))) {
          this.oeD.setText(this.oeC.nVN);
        }
        if ((this.oeC == null) || (!this.oeC.nVQ))
        {
          this.oeA.setVisibility(8);
          AppMethodBeat.o(113461);
          return;
        }
        this.oeB.setText(this.oeC.nVO);
        if ((!TextUtils.isEmpty(this.oeC.nVO)) && (!TextUtils.isEmpty(this.oeC.nVP)))
        {
          this.oeA.setVisibility(0);
          AppMethodBeat.o(113461);
          return;
        }
        this.oeA.setVisibility(8);
        AppMethodBeat.o(113461);
        return;
      }
      if ((paramn instanceof ad))
      {
        paramString = (ad)paramn;
        if ((paramString.nWL) && ((this.nSL instanceof c)))
        {
          ((c)this.nSL).wy(false);
          ((c)this.nSL).wy(true);
          ((c)this.nSL).Xb();
        }
        if ((((Boolean)g.agR().agA().get(ah.a.GFz, Boolean.FALSE)).booleanValue()) && (paramString.nWN != null))
        {
          cB(paramString.nWN.FFt);
          if ((this.nSL instanceof c))
          {
            ((c)this.nSL).wy(false);
            ((c)this.nSL).wy(true);
            ((c)this.nSL).Xb();
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