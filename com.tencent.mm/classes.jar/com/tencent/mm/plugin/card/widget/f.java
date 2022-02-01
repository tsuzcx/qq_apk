package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.protocal.protobuf.rh;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.LinkedList;

public final class f
  extends a
{
  protected TextView ica;
  private View nKd;
  private ImageView nKe;
  private TextView nKf;
  private TextView nKg;
  private View nKh;
  private TextView nKi;
  private TextView nKj;
  private ImageView nKk;
  private TextView nKl;
  public ArrayList<rh> nqw;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void bMS()
  {
    AppMethodBeat.i(113913);
    this.ica = ((TextView)bMR().findViewById(2131297911));
    this.nKd = bMR().findViewById(2131297740);
    this.nKe = ((ImageView)bMR().findViewById(2131305805));
    this.nKf = ((TextView)bMR().findViewById(2131305804));
    this.nKg = ((TextView)bMR().findViewById(2131305803));
    this.nKh = bMR().findViewById(2131305807);
    this.nKi = ((TextView)bMR().findViewById(2131305809));
    this.nKj = ((TextView)bMR().findViewById(2131305808));
    this.nKk = ((ImageView)bMR().findViewById(2131305806));
    this.nKl = ((TextView)bMR().findViewById(2131305802));
    AppMethodBeat.o(113913);
  }
  
  protected final void bMT()
  {
    AppMethodBeat.i(113914);
    label129:
    label206:
    Object localObject;
    StringBuilder localStringBuilder;
    xo localxo1;
    if ((this.nqp.bHV().CSg != null) && (!TextUtils.isEmpty(this.nqp.bHV().CSg.title)))
    {
      this.lKe.setText(this.nqp.bHV().CSg.title);
      if ((this.nqp.bHV().CSg == null) || (TextUtils.isEmpty(this.nqp.bHV().CSg.nrs))) {
        break label604;
      }
      this.ica.setText(this.nqp.bHV().CSg.nrs);
      this.ica.setVisibility(0);
      ad.i("MicroMsg.CardWidgetTicket", "updateContentView()");
      if (bt.isNullOrNil(this.nqp.bHV().CRM)) {
        break label625;
      }
      int i = this.mContext.getResources().getDimensionPixelSize(2131166000);
      n.a(this.mContext, this.nKe, this.nqp.bHV().CRM, i, l.Rm(this.nqp.bHV().gHT));
      localObject = new StringBuilder();
      localStringBuilder = new StringBuilder();
      if ((this.nqp.bHV().CRF == null) || (this.nqp.bHV().CRF.size() < 2)) {
        break label652;
      }
      ad.i("MicroMsg.CardWidgetTicket", "primary_fields length is >= 2");
      localxo1 = (xo)this.nqp.bHV().CRF.get(0);
      xo localxo2 = (xo)this.nqp.bHV().CRF.get(1);
      ((StringBuilder)localObject).append(localxo1.title).append(" - ").append(localxo2.title);
      if ((!TextUtils.isEmpty(localxo1.nrt)) && (!TextUtils.isEmpty(localxo2.nrt)))
      {
        localStringBuilder.append(localxo1.nrt).append(" ").append(localxo1.nrs);
        localStringBuilder.append(" - ");
        localStringBuilder.append(localxo2.nrt).append(" ").append(localxo2.nrs);
      }
      label403:
      if (TextUtils.isEmpty(((StringBuilder)localObject).toString())) {
        break label737;
      }
      this.nKf.setText(((StringBuilder)localObject).toString());
      label424:
      if (TextUtils.isEmpty(localStringBuilder.toString())) {
        break label749;
      }
      ad.i("MicroMsg.CardWidgetTicket", "sub_title_builder is not empty!");
      this.nKg.setText(localStringBuilder.toString());
      this.nKg.setVisibility(0);
      label460:
      ad.e("MicroMsg.CardWidgetTicket", "updateShopView(), shop_count:" + this.nqp.bHV().CRJ);
      if (this.nqp.bHV().CRJ > 0) {
        break label816;
      }
      this.nKh.setVisibility(8);
      this.nKl.setVisibility(8);
    }
    for (;;)
    {
      if (!this.nqp.bHU()) {
        break label1198;
      }
      this.nKd.setVisibility(8);
      AppMethodBeat.o(113914);
      return;
      if (!TextUtils.isEmpty(this.nqp.bHV().nsK))
      {
        this.lKe.setText(this.nqp.bHV().nsK);
        break;
      }
      this.lKe.setText("");
      break;
      label604:
      this.ica.setText("");
      this.ica.setVisibility(8);
      break label129;
      label625:
      n.b(this.nKe, 2131231506, l.Rm(this.nqp.bHV().gHT));
      break label206;
      label652:
      if ((this.nqp.bHV().CRF == null) || (this.nqp.bHV().CRF.size() != 1)) {
        break label403;
      }
      ad.i("MicroMsg.CardWidgetTicket", "primary_fields length is == 1");
      localxo1 = (xo)this.nqp.bHV().CRF.get(0);
      ((StringBuilder)localObject).append(localxo1.title);
      localStringBuilder.append(localxo1.nrs);
      break label403;
      label737:
      this.nKf.setText("");
      break label424;
      label749:
      if (!TextUtils.isEmpty(this.nqp.bHV().CRU))
      {
        ad.i("MicroMsg.CardWidgetTicket", "primary_sub_title is not empty!");
        this.nKg.setText(this.nqp.bHV().CRU);
        this.nKg.setVisibility(0);
        break label460;
      }
      this.nKg.setVisibility(8);
      break label460;
      label816:
      this.nKh.setVisibility(0);
      this.nKh.setOnClickListener(this.iAw);
      n.b(this.nKk, 2131231507, l.Rm(this.nqp.bHV().gHT));
      localStringBuilder = null;
      localObject = localStringBuilder;
      if (this.nqw != null)
      {
        localObject = localStringBuilder;
        if (this.nqw.size() > 0) {
          localObject = (rh)this.nqw.get(0);
        }
      }
      if ((this.nqp.bHV().CRJ == 1) && (localObject != null))
      {
        this.nKi.setText(((rh)localObject).name);
        this.nKj.setText(this.mContext.getString(2131756996, new Object[] { l.f(this.mContext, ((rh)localObject).wUu), ((rh)localObject).hdQ }));
        this.nKl.setVisibility(8);
        this.nKh.setTag(((rh)localObject).name);
      }
      else if ((this.nqp.bHV().CRJ > 1) && (localObject != null))
      {
        this.nKi.setText(((rh)localObject).name);
        this.nKj.setText(this.mContext.getString(2131756996, new Object[] { l.f(this.mContext, ((rh)localObject).wUu), ((rh)localObject).hdQ }));
        this.nKl.setVisibility(0);
        this.nKl.setOnClickListener(this.iAw);
        this.nKh.setTag(((rh)localObject).name);
      }
      else if (this.nqp.bHV().CRJ > 0)
      {
        this.nKi.setText(2131756806);
        this.nKj.setText(this.mContext.getString(2131757022, new Object[] { Integer.valueOf(this.nqp.bHV().CRJ) }));
        this.nKl.setVisibility(8);
        this.nKl.setOnClickListener(null);
        this.nKh.setTag(this.mContext.getString(2131756806));
      }
    }
    label1198:
    this.nKd.setVisibility(0);
    AppMethodBeat.o(113914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.f
 * JD-Core Version:    0.7.0.1
 */