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
import com.tencent.mm.g.a.vm;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.i;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.f;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.x;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.protocal.protobuf.cze;
import com.tencent.mm.protocal.protobuf.tg;
import com.tencent.mm.protocal.protobuf.tk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CardIndexUI
  extends CardBaseUI
{
  private final String TAG = "MicroMsg.CardIndexUI";
  int fromScene = 0;
  private long mStartTime = 0L;
  private View oHU;
  private TextView oHV;
  private f oHW;
  private TextView oHX;
  private TextView oHY;
  private ImageView oHZ;
  private LinearLayout oIa;
  int oIb = -1;
  
  private void bWW()
  {
    AppMethodBeat.i(113454);
    if ((this.owi.getChildCount() == 0) && (this.owg.getCount() == 0))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardIndexUI", "show empty view");
      this.owh.setVisibility(0);
      this.owf.setVisibility(8);
      AppMethodBeat.o(113454);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardIndexUI", "hide empty view");
    this.owh.setVisibility(8);
    this.owf.setVisibility(0);
    AppMethodBeat.o(113454);
  }
  
  private void cC(List<czd> paramList)
  {
    AppMethodBeat.i(113455);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        czd localczd = (czd)paramList.next();
        if (localczd.FQR == 1)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardIndexUI", "should update new invoice");
          cD(localczd.HpR);
        }
      }
    }
    bWW();
    AppMethodBeat.o(113455);
  }
  
  private void cD(List<tk> paramList)
  {
    AppMethodBeat.i(113456);
    this.owi.removeAllViews();
    this.owi.setPadding(0, 0, 0, 0);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        Object localObject = (tk)paramList.next();
        View localView = View.inflate(getContext(), 2131493312, null);
        CdnImageView localCdnImageView = (CdnImageView)localView.findViewById(2131298358);
        TextView localTextView1 = (TextView)localView.findViewById(2131298359);
        TextView localTextView2 = (TextView)localView.findViewById(2131298357);
        localCdnImageView.setUrl(((tk)localObject).FRe);
        localTextView1.setText(((tk)localObject).FRd);
        localTextView2.setText(((tk)localObject).FRf);
        if (((tk)localObject).FRg > 0) {
          localView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(113449);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardIndexUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardIndexUI", "click header view: %s", new Object[] { Integer.valueOf(this.oId.FRg) });
              if (this.oId.FRg == 1) {
                com.tencent.mm.plugin.card.d.b.a(CardIndexUI.this, this.oId.FRh, 0);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardIndexUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113449);
                return;
                if (this.oId.FRg == 2)
                {
                  paramAnonymousView = new vm();
                  paramAnonymousView.dJF.userName = this.oId.FRi.CzQ;
                  paramAnonymousView.dJF.dJH = bt.bI(this.oId.FRi.CzR, "");
                  paramAnonymousView.dJF.scene = 1028;
                  com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
                }
              }
            }
          });
        }
        this.owi.addView(localView);
        if (i == 0) {
          this.owi.setPadding(0, com.tencent.mm.cc.a.fromDPToPix(this, 13), 0, 0);
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
  
  public final BaseAdapter Zp()
  {
    AppMethodBeat.i(113460);
    if (3 == this.oIb)
    {
      localObject = new k(this, bTh());
      AppMethodBeat.o(113460);
      return localObject;
    }
    Object localObject = new c(this, bTh());
    AppMethodBeat.o(113460);
    return localObject;
  }
  
  public final void bTg()
  {
    AppMethodBeat.i(113453);
    Object localObject;
    if (1 == this.oIb)
    {
      setMMTitle(2131756929);
      this.oHX = ((TextView)findViewById(2131302872));
      this.oHY = ((TextView)findViewById(2131302873));
      this.oHZ = ((ImageView)findViewById(2131302870));
      this.oHU = findViewById(2131297793);
      this.oHV = ((TextView)findViewById(2131297794));
      this.oIa = ((LinearLayout)findViewById(2131302871));
      this.oHU.setVisibility(8);
      this.oHY.setVisibility(0);
      this.oHX.setVisibility(0);
      this.oHZ.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.oIa.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = BackwardSupportUtil.b.g(this, 100.0F);
      this.oIa.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (1 != this.oIb) {
        break label363;
      }
      this.oHY.setText(getString(2131756917));
      this.oHX.setText(getString(2131756916));
    }
    for (;;)
    {
      if (this.oIb == 3)
      {
        this.owf.setEmptyView(null);
        this.owh.setVisibility(8);
      }
      this.oHV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113448);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardIndexUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (!TextUtils.isEmpty(CardIndexUI.a(CardIndexUI.this).ozj)) {
            com.tencent.mm.plugin.card.d.b.a(CardIndexUI.this, CardIndexUI.a(CardIndexUI.this).ozj, 0);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardIndexUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113448);
        }
      });
      if ((this.oIb != 3) || (!((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IrR, Boolean.FALSE)).booleanValue())) {
        break label447;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.CardIndexUI", "has load new entrance");
      localObject = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IrP, null);
      if (bt.isNullOrNil((String)localObject)) {
        break label447;
      }
      try
      {
        cze localcze = new cze();
        localcze.parseFrom(((String)localObject).getBytes("ISO-8859-1"));
        cC(localcze.HpS);
        AppMethodBeat.o(113453);
        return;
      }
      catch (IOException localIOException)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.CardIndexUI", localIOException, "", new Object[0]);
      }
      if (3 == this.oIb)
      {
        setMMTitle(2131757021);
        break;
      }
      setMMTitle(2131756939);
      break;
      label363:
      if (3 == this.oIb)
      {
        this.oHY.setText(getString(2131756923));
        this.oHX.setText(getString(2131756922));
      }
      else
      {
        this.oHY.setText(getString(2131756960));
        this.oHX.setText(getString(2131756975));
      }
    }
    label447:
    AppMethodBeat.o(113453);
  }
  
  public final n.a bTh()
  {
    AppMethodBeat.i(113459);
    if (1 == this.oIb)
    {
      locala = n.a.ozM;
      AppMethodBeat.o(113459);
      return locala;
    }
    if (3 == this.oIb)
    {
      if (((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IrR, Boolean.FALSE)).booleanValue())
      {
        locala = n.a.ozO;
        AppMethodBeat.o(113459);
        return locala;
      }
      locala = n.a.ozL;
      AppMethodBeat.o(113459);
      return locala;
    }
    n.a locala = n.a.ozI;
    AppMethodBeat.o(113459);
    return locala;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113452);
    if (getIntent() != null) {
      this.oIb = getIntent().getIntExtra("key_card_type", -1);
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
    com.tencent.mm.kernel.g.ajB().gAO.a(1054, this);
    am.bUM();
    com.tencent.mm.plugin.card.b.b.Ao(1);
    int i = am.bUR().oxF;
    if ((com.tencent.mm.z.c.aht().cI(262152, 266256)) || (i > 0))
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(11324, new Object[] { "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "" });
      AppMethodBeat.o(113450);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(11324, new Object[] { "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "" });
    AppMethodBeat.o(113450);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113451);
    com.tencent.mm.kernel.g.ajB().gAO.b(1054, this);
    long l1 = System.currentTimeMillis();
    long l2 = this.mStartTime;
    com.tencent.mm.plugin.report.service.g.yhR.f(13219, new Object[] { "CardPackageListView", Integer.valueOf(this.fromScene), "", "", Long.valueOf(l1 - l2) });
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
        this.oHW = i.Zf((String)com.tencent.mm.kernel.g.ajC().ajl().get(282885, ""));
        if (this.oHW == null) {
          this.oHW = new f();
        }
        if ((this.oHW != null) && (!TextUtils.isEmpty(this.oHW.ozh))) {
          this.oHX.setText(this.oHW.ozh);
        }
        if ((this.oHW == null) || (!this.oHW.ozk))
        {
          this.oHU.setVisibility(8);
          AppMethodBeat.o(113461);
          return;
        }
        this.oHV.setText(this.oHW.ozi);
        if ((!TextUtils.isEmpty(this.oHW.ozi)) && (!TextUtils.isEmpty(this.oHW.ozj)))
        {
          this.oHU.setVisibility(0);
          AppMethodBeat.o(113461);
          return;
        }
        this.oHU.setVisibility(8);
        AppMethodBeat.o(113461);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.model.ad))
      {
        paramString = (com.tencent.mm.plugin.card.model.ad)paramn;
        if ((paramString.oAf) && ((this.owg instanceof c)))
        {
          ((c)this.owg).xk(false);
          ((c)this.owg).xk(true);
          ((c)this.owg).Zu();
        }
        if ((((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IrR, Boolean.FALSE)).booleanValue()) && (paramString.oAh != null))
        {
          cC(paramString.oAh.HpS);
          if ((this.owg instanceof c))
          {
            ((c)this.owg).xk(false);
            ((c)this.owg).xk(true);
            ((c)this.owg).Zu();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardIndexUI
 * JD-Core Version:    0.7.0.1
 */