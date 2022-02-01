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
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.LinkedList;

public final class f
  extends a
{
  protected TextView iYj;
  public ArrayList<tn> oDt;
  private View oXa;
  private ImageView oXb;
  private TextView oXc;
  private TextView oXd;
  private View oXe;
  private TextView oXf;
  private TextView oXg;
  private ImageView oXh;
  private TextView oXi;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void bZX()
  {
    AppMethodBeat.i(113913);
    this.iYj = ((TextView)bZW().findViewById(2131297911));
    this.oXa = bZW().findViewById(2131297740);
    this.oXb = ((ImageView)bZW().findViewById(2131305805));
    this.oXc = ((TextView)bZW().findViewById(2131305804));
    this.oXd = ((TextView)bZW().findViewById(2131305803));
    this.oXe = bZW().findViewById(2131305807);
    this.oXf = ((TextView)bZW().findViewById(2131305809));
    this.oXg = ((TextView)bZW().findViewById(2131305808));
    this.oXh = ((ImageView)bZW().findViewById(2131305806));
    this.oXi = ((TextView)bZW().findViewById(2131305802));
    AppMethodBeat.o(113913);
  }
  
  protected final void bZY()
  {
    AppMethodBeat.i(113914);
    label129:
    label206:
    Object localObject;
    StringBuilder localStringBuilder;
    aai localaai1;
    if ((this.oDm.bVc().Gkz != null) && (!TextUtils.isEmpty(this.oDm.bVc().Gkz.title)))
    {
      this.mRG.setText(this.oDm.bVc().Gkz.title);
      if ((this.oDm.bVc().Gkz == null) || (TextUtils.isEmpty(this.oDm.bVc().Gkz.oEp))) {
        break label604;
      }
      this.iYj.setText(this.oDm.bVc().Gkz.oEp);
      this.iYj.setVisibility(0);
      ae.i("MicroMsg.CardWidgetTicket", "updateContentView()");
      if (bu.isNullOrNil(this.oDm.bVc().Gkf)) {
        break label625;
      }
      int i = this.mContext.getResources().getDimensionPixelSize(2131166000);
      n.a(this.mContext, this.oXb, this.oDm.bVc().Gkf, i, l.ZY(this.oDm.bVc().hDr));
      localObject = new StringBuilder();
      localStringBuilder = new StringBuilder();
      if ((this.oDm.bVc().GjY == null) || (this.oDm.bVc().GjY.size() < 2)) {
        break label652;
      }
      ae.i("MicroMsg.CardWidgetTicket", "primary_fields length is >= 2");
      localaai1 = (aai)this.oDm.bVc().GjY.get(0);
      aai localaai2 = (aai)this.oDm.bVc().GjY.get(1);
      ((StringBuilder)localObject).append(localaai1.title).append(" - ").append(localaai2.title);
      if ((!TextUtils.isEmpty(localaai1.oEq)) && (!TextUtils.isEmpty(localaai2.oEq)))
      {
        localStringBuilder.append(localaai1.oEq).append(" ").append(localaai1.oEp);
        localStringBuilder.append(" - ");
        localStringBuilder.append(localaai2.oEq).append(" ").append(localaai2.oEp);
      }
      label403:
      if (TextUtils.isEmpty(((StringBuilder)localObject).toString())) {
        break label737;
      }
      this.oXc.setText(((StringBuilder)localObject).toString());
      label424:
      if (TextUtils.isEmpty(localStringBuilder.toString())) {
        break label749;
      }
      ae.i("MicroMsg.CardWidgetTicket", "sub_title_builder is not empty!");
      this.oXd.setText(localStringBuilder.toString());
      this.oXd.setVisibility(0);
      label460:
      ae.e("MicroMsg.CardWidgetTicket", "updateShopView(), shop_count:" + this.oDm.bVc().Gkc);
      if (this.oDm.bVc().Gkc > 0) {
        break label816;
      }
      this.oXe.setVisibility(8);
      this.oXi.setVisibility(8);
    }
    for (;;)
    {
      if (!this.oDm.bVb()) {
        break label1198;
      }
      this.oXa.setVisibility(8);
      AppMethodBeat.o(113914);
      return;
      if (!TextUtils.isEmpty(this.oDm.bVc().oFG))
      {
        this.mRG.setText(this.oDm.bVc().oFG);
        break;
      }
      this.mRG.setText("");
      break;
      label604:
      this.iYj.setText("");
      this.iYj.setVisibility(8);
      break label129;
      label625:
      n.b(this.oXb, 2131231506, l.ZY(this.oDm.bVc().hDr));
      break label206;
      label652:
      if ((this.oDm.bVc().GjY == null) || (this.oDm.bVc().GjY.size() != 1)) {
        break label403;
      }
      ae.i("MicroMsg.CardWidgetTicket", "primary_fields length is == 1");
      localaai1 = (aai)this.oDm.bVc().GjY.get(0);
      ((StringBuilder)localObject).append(localaai1.title);
      localStringBuilder.append(localaai1.oEp);
      break label403;
      label737:
      this.oXc.setText("");
      break label424;
      label749:
      if (!TextUtils.isEmpty(this.oDm.bVc().Gkn))
      {
        ae.i("MicroMsg.CardWidgetTicket", "primary_sub_title is not empty!");
        this.oXd.setText(this.oDm.bVc().Gkn);
        this.oXd.setVisibility(0);
        break label460;
      }
      this.oXd.setVisibility(8);
      break label460;
      label816:
      this.oXe.setVisibility(0);
      this.oXe.setOnClickListener(this.jwB);
      n.b(this.oXh, 2131231507, l.ZY(this.oDm.bVc().hDr));
      localStringBuilder = null;
      localObject = localStringBuilder;
      if (this.oDt != null)
      {
        localObject = localStringBuilder;
        if (this.oDt.size() > 0) {
          localObject = (tn)this.oDt.get(0);
        }
      }
      if ((this.oDm.bVc().Gkc == 1) && (localObject != null))
      {
        this.oXf.setText(((tn)localObject).name);
        this.oXg.setText(this.mContext.getString(2131756996, new Object[] { l.f(this.mContext, ((tn)localObject).zOO), ((tn)localObject).hZQ }));
        this.oXi.setVisibility(8);
        this.oXe.setTag(((tn)localObject).name);
      }
      else if ((this.oDm.bVc().Gkc > 1) && (localObject != null))
      {
        this.oXf.setText(((tn)localObject).name);
        this.oXg.setText(this.mContext.getString(2131756996, new Object[] { l.f(this.mContext, ((tn)localObject).zOO), ((tn)localObject).hZQ }));
        this.oXi.setVisibility(0);
        this.oXi.setOnClickListener(this.jwB);
        this.oXe.setTag(((tn)localObject).name);
      }
      else if (this.oDm.bVc().Gkc > 0)
      {
        this.oXf.setText(2131756806);
        this.oXg.setText(this.mContext.getString(2131757022, new Object[] { Integer.valueOf(this.oDm.bVc().Gkc) }));
        this.oXi.setVisibility(8);
        this.oXi.setOnClickListener(null);
        this.oXe.setTag(this.mContext.getString(2131756806));
      }
    }
    label1198:
    this.oXa.setVisibility(0);
    AppMethodBeat.o(113914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.f
 * JD-Core Version:    0.7.0.1
 */