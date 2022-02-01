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
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.i;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.x;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ecz;
import com.tencent.mm.protocal.protobuf.eda;
import com.tencent.mm.protocal.protobuf.ut;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CardIndexUI
  extends CardBaseUI
{
  private final String TAG = "MicroMsg.CardIndexUI";
  int fromScene = 0;
  private long mStartTime = 0L;
  private View tyi;
  private TextView tyj;
  private com.tencent.mm.plugin.card.model.f tyk;
  private TextView tyl;
  private TextView tym;
  private ImageView tyn;
  private LinearLayout tyo;
  int viewType = -1;
  
  private void cJD()
  {
    AppMethodBeat.i(113454);
    if ((this.tmt.getChildCount() == 0) && (this.tmr.getCount() == 0))
    {
      Log.i("MicroMsg.CardIndexUI", "show empty view");
      this.tms.setVisibility(0);
      this.tmq.setVisibility(8);
      AppMethodBeat.o(113454);
      return;
    }
    Log.i("MicroMsg.CardIndexUI", "hide empty view");
    this.tms.setVisibility(8);
    this.tmq.setVisibility(0);
    AppMethodBeat.o(113454);
  }
  
  private void cQ(List<ecz> paramList)
  {
    AppMethodBeat.i(113455);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ecz localecz = (ecz)paramList.next();
        if (localecz.Sfi == 1)
        {
          Log.i("MicroMsg.CardIndexUI", "should update new invoice");
          cR(localecz.Uhu);
        }
      }
    }
    cJD();
    AppMethodBeat.o(113455);
  }
  
  private void cR(List<ut> paramList)
  {
    AppMethodBeat.i(113456);
    this.tmt.removeAllViews();
    this.tmt.setPadding(0, 0, 0, 0);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        Object localObject = (ut)paramList.next();
        View localView = View.inflate(getContext(), a.e.tiL, null);
        CdnImageView localCdnImageView = (CdnImageView)localView.findViewById(a.d.teX);
        TextView localTextView1 = (TextView)localView.findViewById(a.d.teY);
        TextView localTextView2 = (TextView)localView.findViewById(a.d.teW);
        localCdnImageView.setUrl(((ut)localObject).Sfv);
        localTextView1.setText(((ut)localObject).Sfu);
        localTextView2.setText(((ut)localObject).Sfw);
        if (((ut)localObject).Sfx > 0) {
          localView.setOnClickListener(new CardIndexUI.2(this, (ut)localObject));
        }
        this.tmt.addView(localView);
        if (i == 0) {
          this.tmt.setPadding(0, com.tencent.mm.ci.a.fromDPToPix(this, 13), 0, 0);
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = (LinearLayout.LayoutParams)localView.getLayoutParams();
          if (localObject != null)
          {
            ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.ci.a.fromDPToPix(this, 6);
            localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(113456);
  }
  
  public final BaseAdapter atn()
  {
    AppMethodBeat.i(113460);
    if (3 == this.viewType)
    {
      localObject = new k(this, cFK());
      AppMethodBeat.o(113460);
      return localObject;
    }
    Object localObject = new c(this, cFK());
    AppMethodBeat.o(113460);
    return localObject;
  }
  
  public final void cFJ()
  {
    AppMethodBeat.i(113453);
    Object localObject;
    if (1 == this.viewType)
    {
      setMMTitle(a.g.tkW);
      this.tyl = ((TextView)findViewById(a.d.tgk));
      this.tym = ((TextView)findViewById(a.d.tgl));
      this.tyn = ((ImageView)findViewById(a.d.tgi));
      this.tyi = findViewById(a.d.tbV);
      this.tyj = ((TextView)findViewById(a.d.tbW));
      this.tyo = ((LinearLayout)findViewById(a.d.tgj));
      this.tyi.setVisibility(8);
      this.tym.setVisibility(0);
      this.tyl.setVisibility(0);
      this.tyn.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.tyo.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 100.0F);
      this.tyo.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (1 != this.viewType) {
        break label367;
      }
      this.tym.setText(getString(a.g.tkM));
      this.tyl.setText(getString(a.g.tkL));
    }
    for (;;)
    {
      if (this.viewType == 3)
      {
        this.tmq.setEmptyView(null);
        this.tms.setVisibility(8);
      }
      this.tyj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113448);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardIndexUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!TextUtils.isEmpty(CardIndexUI.a(CardIndexUI.this).tpt)) {
            com.tencent.mm.plugin.card.d.b.a(CardIndexUI.this, CardIndexUI.a(CardIndexUI.this).tpt, 0);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardIndexUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113448);
        }
      });
      if ((this.viewType != 3) || (!((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vip, Boolean.FALSE)).booleanValue())) {
        break label451;
      }
      Log.i("MicroMsg.CardIndexUI", "has load new entrance");
      localObject = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vin, null);
      if (Util.isNullOrNil((String)localObject)) {
        break label451;
      }
      try
      {
        eda localeda = new eda();
        localeda.parseFrom(((String)localObject).getBytes("ISO-8859-1"));
        cQ(localeda.Uhv);
        AppMethodBeat.o(113453);
        return;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.CardIndexUI", localIOException, "", new Object[0]);
      }
      if (3 == this.viewType)
      {
        setMMTitle(a.g.tmf);
        break;
      }
      setMMTitle(a.g.tlf);
      break;
      label367:
      if (3 == this.viewType)
      {
        this.tym.setText(getString(a.g.tkQ));
        this.tyl.setText(getString(a.g.tkP));
      }
      else
      {
        this.tym.setText(getString(a.g.tlp));
        this.tyl.setText(getString(a.g.tlx));
      }
    }
    label451:
    AppMethodBeat.o(113453);
  }
  
  public final n.a cFK()
  {
    AppMethodBeat.i(113459);
    if (1 == this.viewType)
    {
      locala = n.a.tpV;
      AppMethodBeat.o(113459);
      return locala;
    }
    if (3 == this.viewType)
    {
      if (((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vip, Boolean.FALSE)).booleanValue())
      {
        locala = n.a.tpX;
        AppMethodBeat.o(113459);
        return locala;
      }
      locala = n.a.tpU;
      AppMethodBeat.o(113459);
      return locala;
    }
    n.a locala = n.a.tpR;
    AppMethodBeat.o(113459);
    return locala;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113452);
    if (getIntent() != null) {
      this.viewType = getIntent().getIntExtra("key_card_type", -1);
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
    Log.i("MicroMsg.CardIndexUI", "oncreate");
    this.mStartTime = System.currentTimeMillis();
    initView();
    com.tencent.mm.kernel.h.aHF().kcd.a(1054, this);
    am.cHr();
    com.tencent.mm.plugin.card.b.b.HG(1);
    int i = am.cHw().tnQ;
    if ((com.tencent.mm.aa.c.aFn().dj(262152, 266256)) || (i > 0))
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(11324, new Object[] { "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "" });
      AppMethodBeat.o(113450);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(11324, new Object[] { "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "" });
    AppMethodBeat.o(113450);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113451);
    com.tencent.mm.kernel.h.aHF().kcd.b(1054, this);
    long l1 = System.currentTimeMillis();
    long l2 = this.mStartTime;
    com.tencent.mm.plugin.report.service.h.IzE.a(13219, new Object[] { "CardPackageListView", Integer.valueOf(this.fromScene), "", "", Long.valueOf(l1 - l2) });
    super.onDestroy();
    AppMethodBeat.o(113451);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113457);
    super.onResume();
    AppMethodBeat.o(113457);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(113461);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof x))
      {
        this.tyk = i.arP((String)com.tencent.mm.kernel.h.aHG().aHp().b(282885, ""));
        if (this.tyk == null) {
          this.tyk = new com.tencent.mm.plugin.card.model.f();
        }
        if ((this.tyk != null) && (!TextUtils.isEmpty(this.tyk.tpr))) {
          this.tyl.setText(this.tyk.tpr);
        }
        if ((this.tyk == null) || (!this.tyk.tpu))
        {
          this.tyi.setVisibility(8);
          AppMethodBeat.o(113461);
          return;
        }
        this.tyj.setText(this.tyk.tps);
        if ((!TextUtils.isEmpty(this.tyk.tps)) && (!TextUtils.isEmpty(this.tyk.tpt)))
        {
          this.tyi.setVisibility(0);
          AppMethodBeat.o(113461);
          return;
        }
        this.tyi.setVisibility(8);
        AppMethodBeat.o(113461);
        return;
      }
      if ((paramq instanceof ad))
      {
        paramString = (ad)paramq;
        if ((paramString.tqo) && ((this.tmr instanceof c)))
        {
          ((c)this.tmr).Fx(false);
          ((c)this.tmr).Fx(true);
          ((c)this.tmr).atr();
        }
        if ((((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vip, Boolean.FALSE)).booleanValue()) && (paramString.tqq != null))
        {
          cQ(paramString.tqq.Uhv);
          if ((this.tmr instanceof c))
          {
            ((c)this.tmr).Fx(false);
            ((c)this.tmr).Fx(true);
            ((c)this.tmr).atr();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardIndexUI
 * JD-Core Version:    0.7.0.1
 */