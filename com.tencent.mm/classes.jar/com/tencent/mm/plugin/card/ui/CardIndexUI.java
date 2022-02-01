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
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
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
import com.tencent.mm.protocal.protobuf.dtb;
import com.tencent.mm.protocal.protobuf.dtc;
import com.tencent.mm.protocal.protobuf.ur;
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
  private View qck;
  private TextView qcl;
  private f qcm;
  private TextView qcn;
  private TextView qco;
  private ImageView qcp;
  private LinearLayout qcq;
  int qcr = -1;
  
  private void cT(List<dtb> paramList)
  {
    AppMethodBeat.i(113455);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        dtb localdtb = (dtb)paramList.next();
        if (localdtb.LdV == 1)
        {
          Log.i("MicroMsg.CardIndexUI", "should update new invoice");
          cU(localdtb.MVh);
        }
      }
    }
    cwb();
    AppMethodBeat.o(113455);
  }
  
  private void cU(List<ur> paramList)
  {
    AppMethodBeat.i(113456);
    this.pQt.removeAllViews();
    this.pQt.setPadding(0, 0, 0, 0);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        Object localObject = (ur)paramList.next();
        View localView = View.inflate(getContext(), 2131493403, null);
        CdnImageView localCdnImageView = (CdnImageView)localView.findViewById(2131298761);
        TextView localTextView1 = (TextView)localView.findViewById(2131298762);
        TextView localTextView2 = (TextView)localView.findViewById(2131298760);
        localCdnImageView.setUrl(((ur)localObject).Lei);
        localTextView1.setText(((ur)localObject).Leh);
        localTextView2.setText(((ur)localObject).Lej);
        if (((ur)localObject).Lek > 0) {
          localView.setOnClickListener(new CardIndexUI.2(this, (ur)localObject));
        }
        this.pQt.addView(localView);
        if (i == 0) {
          this.pQt.setPadding(0, com.tencent.mm.cb.a.fromDPToPix(this, 13), 0, 0);
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = (LinearLayout.LayoutParams)localView.getLayoutParams();
          if (localObject != null)
          {
            ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 6);
            localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(113456);
  }
  
  private void cwb()
  {
    AppMethodBeat.i(113454);
    if ((this.pQt.getChildCount() == 0) && (this.pQr.getCount() == 0))
    {
      Log.i("MicroMsg.CardIndexUI", "show empty view");
      this.pQs.setVisibility(0);
      this.pQq.setVisibility(8);
      AppMethodBeat.o(113454);
      return;
    }
    Log.i("MicroMsg.CardIndexUI", "hide empty view");
    this.pQs.setVisibility(8);
    this.pQq.setVisibility(0);
    AppMethodBeat.o(113454);
  }
  
  public final BaseAdapter anl()
  {
    AppMethodBeat.i(113460);
    if (3 == this.qcr)
    {
      localObject = new k(this, csk());
      AppMethodBeat.o(113460);
      return localObject;
    }
    Object localObject = new c(this, csk());
    AppMethodBeat.o(113460);
    return localObject;
  }
  
  public final void csj()
  {
    AppMethodBeat.i(113453);
    Object localObject;
    if (1 == this.qcr)
    {
      setMMTitle(2131757099);
      this.qcn = ((TextView)findViewById(2131305445));
      this.qco = ((TextView)findViewById(2131305446));
      this.qcp = ((ImageView)findViewById(2131305443));
      this.qck = findViewById(2131298108);
      this.qcl = ((TextView)findViewById(2131298109));
      this.qcq = ((LinearLayout)findViewById(2131305444));
      this.qck.setVisibility(8);
      this.qco.setVisibility(0);
      this.qcn.setVisibility(0);
      this.qcp.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.qcq.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 100.0F);
      this.qcq.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (1 != this.qcr) {
        break label363;
      }
      this.qco.setText(getString(2131757087));
      this.qcn.setText(getString(2131757086));
    }
    for (;;)
    {
      if (this.qcr == 3)
      {
        this.pQq.setEmptyView(null);
        this.pQs.setVisibility(8);
      }
      this.qcl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113448);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardIndexUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (!TextUtils.isEmpty(CardIndexUI.a(CardIndexUI.this).pTs)) {
            com.tencent.mm.plugin.card.d.b.a(CardIndexUI.this, CardIndexUI.a(CardIndexUI.this).pTs, 0);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardIndexUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113448);
        }
      });
      if ((this.qcr != 3) || (!((Boolean)g.aAh().azQ().get(ar.a.NUp, Boolean.FALSE)).booleanValue())) {
        break label447;
      }
      Log.i("MicroMsg.CardIndexUI", "has load new entrance");
      localObject = (String)g.aAh().azQ().get(ar.a.NUn, null);
      if (Util.isNullOrNil((String)localObject)) {
        break label447;
      }
      try
      {
        dtc localdtc = new dtc();
        localdtc.parseFrom(((String)localObject).getBytes("ISO-8859-1"));
        cT(localdtc.MVi);
        AppMethodBeat.o(113453);
        return;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.CardIndexUI", localIOException, "", new Object[0]);
      }
      if (3 == this.qcr)
      {
        setMMTitle(2131757191);
        break;
      }
      setMMTitle(2131757109);
      break;
      label363:
      if (3 == this.qcr)
      {
        this.qco.setText(getString(2131757093));
        this.qcn.setText(getString(2131757092));
      }
      else
      {
        this.qco.setText(getString(2131757130));
        this.qcn.setText(getString(2131757145));
      }
    }
    label447:
    AppMethodBeat.o(113453);
  }
  
  public final n.a csk()
  {
    AppMethodBeat.i(113459);
    if (1 == this.qcr)
    {
      locala = n.a.pTU;
      AppMethodBeat.o(113459);
      return locala;
    }
    if (3 == this.qcr)
    {
      if (((Boolean)g.aAh().azQ().get(ar.a.NUp, Boolean.FALSE)).booleanValue())
      {
        locala = n.a.pTW;
        AppMethodBeat.o(113459);
        return locala;
      }
      locala = n.a.pTT;
      AppMethodBeat.o(113459);
      return locala;
    }
    n.a locala = n.a.pTQ;
    AppMethodBeat.o(113459);
    return locala;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113452);
    if (getIntent() != null) {
      this.qcr = getIntent().getIntExtra("key_card_type", -1);
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
    g.aAg().hqi.a(1054, this);
    am.ctP();
    com.tencent.mm.plugin.card.b.b.Ef(1);
    int i = am.ctU().pRQ;
    if ((com.tencent.mm.y.c.axV().cO(262152, 266256)) || (i > 0))
    {
      h.CyF.a(11324, new Object[] { "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "" });
      AppMethodBeat.o(113450);
      return;
    }
    h.CyF.a(11324, new Object[] { "CardPackageListView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.fromScene), "", Integer.valueOf(0), "" });
    AppMethodBeat.o(113450);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113451);
    g.aAg().hqi.b(1054, this);
    long l1 = System.currentTimeMillis();
    long l2 = this.mStartTime;
    h.CyF.a(13219, new Object[] { "CardPackageListView", Integer.valueOf(this.fromScene), "", "", Long.valueOf(l1 - l2) });
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
        this.qcm = i.akc((String)g.aAh().azQ().get(282885, ""));
        if (this.qcm == null) {
          this.qcm = new f();
        }
        if ((this.qcm != null) && (!TextUtils.isEmpty(this.qcm.pTq))) {
          this.qcn.setText(this.qcm.pTq);
        }
        if ((this.qcm == null) || (!this.qcm.pTt))
        {
          this.qck.setVisibility(8);
          AppMethodBeat.o(113461);
          return;
        }
        this.qcl.setText(this.qcm.pTr);
        if ((!TextUtils.isEmpty(this.qcm.pTr)) && (!TextUtils.isEmpty(this.qcm.pTs)))
        {
          this.qck.setVisibility(0);
          AppMethodBeat.o(113461);
          return;
        }
        this.qck.setVisibility(8);
        AppMethodBeat.o(113461);
        return;
      }
      if ((paramq instanceof ad))
      {
        paramString = (ad)paramq;
        if ((paramString.pUn) && ((this.pQr instanceof c)))
        {
          ((c)this.pQr).Bh(false);
          ((c)this.pQr).Bh(true);
          ((c)this.pQr).anp();
        }
        if ((((Boolean)g.aAh().azQ().get(ar.a.NUp, Boolean.FALSE)).booleanValue()) && (paramString.pUp != null))
        {
          cT(paramString.pUp.MVi);
          if ((this.pQr instanceof c))
          {
            ((c)this.pQr).Bh(false);
            ((c)this.pQr).Bh(true);
            ((c)this.pQr).anp();
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