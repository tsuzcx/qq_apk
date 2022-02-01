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
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.tl;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.LinkedList;

public final class f
  extends a
{
  protected TextView iVq;
  private TextView oQA;
  private TextView oQB;
  private View oQC;
  private TextView oQD;
  private TextView oQE;
  private ImageView oQF;
  private TextView oQG;
  private View oQy;
  private ImageView oQz;
  public ArrayList<tl> owR;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void bYI()
  {
    AppMethodBeat.i(113913);
    this.iVq = ((TextView)bYH().findViewById(2131297911));
    this.oQy = bYH().findViewById(2131297740);
    this.oQz = ((ImageView)bYH().findViewById(2131305805));
    this.oQA = ((TextView)bYH().findViewById(2131305804));
    this.oQB = ((TextView)bYH().findViewById(2131305803));
    this.oQC = bYH().findViewById(2131305807);
    this.oQD = ((TextView)bYH().findViewById(2131305809));
    this.oQE = ((TextView)bYH().findViewById(2131305808));
    this.oQF = ((ImageView)bYH().findViewById(2131305806));
    this.oQG = ((TextView)bYH().findViewById(2131305802));
    AppMethodBeat.o(113913);
  }
  
  protected final void bYJ()
  {
    AppMethodBeat.i(113914);
    label129:
    label206:
    Object localObject;
    StringBuilder localStringBuilder;
    aaf localaaf1;
    if ((this.owK.bTN().FSa != null) && (!TextUtils.isEmpty(this.owK.bTN().FSa.title)))
    {
      this.mMD.setText(this.owK.bTN().FSa.title);
      if ((this.owK.bTN().FSa == null) || (TextUtils.isEmpty(this.owK.bTN().FSa.oxN))) {
        break label604;
      }
      this.iVq.setText(this.owK.bTN().FSa.oxN);
      this.iVq.setVisibility(0);
      ad.i("MicroMsg.CardWidgetTicket", "updateContentView()");
      if (bt.isNullOrNil(this.owK.bTN().FRG)) {
        break label625;
      }
      int i = this.mContext.getResources().getDimensionPixelSize(2131166000);
      n.a(this.mContext, this.oQz, this.owK.bTN().FRG, i, l.Zh(this.owK.bTN().hAD));
      localObject = new StringBuilder();
      localStringBuilder = new StringBuilder();
      if ((this.owK.bTN().FRz == null) || (this.owK.bTN().FRz.size() < 2)) {
        break label652;
      }
      ad.i("MicroMsg.CardWidgetTicket", "primary_fields length is >= 2");
      localaaf1 = (aaf)this.owK.bTN().FRz.get(0);
      aaf localaaf2 = (aaf)this.owK.bTN().FRz.get(1);
      ((StringBuilder)localObject).append(localaaf1.title).append(" - ").append(localaaf2.title);
      if ((!TextUtils.isEmpty(localaaf1.oxO)) && (!TextUtils.isEmpty(localaaf2.oxO)))
      {
        localStringBuilder.append(localaaf1.oxO).append(" ").append(localaaf1.oxN);
        localStringBuilder.append(" - ");
        localStringBuilder.append(localaaf2.oxO).append(" ").append(localaaf2.oxN);
      }
      label403:
      if (TextUtils.isEmpty(((StringBuilder)localObject).toString())) {
        break label737;
      }
      this.oQA.setText(((StringBuilder)localObject).toString());
      label424:
      if (TextUtils.isEmpty(localStringBuilder.toString())) {
        break label749;
      }
      ad.i("MicroMsg.CardWidgetTicket", "sub_title_builder is not empty!");
      this.oQB.setText(localStringBuilder.toString());
      this.oQB.setVisibility(0);
      label460:
      ad.e("MicroMsg.CardWidgetTicket", "updateShopView(), shop_count:" + this.owK.bTN().FRD);
      if (this.owK.bTN().FRD > 0) {
        break label816;
      }
      this.oQC.setVisibility(8);
      this.oQG.setVisibility(8);
    }
    for (;;)
    {
      if (!this.owK.bTM()) {
        break label1198;
      }
      this.oQy.setVisibility(8);
      AppMethodBeat.o(113914);
      return;
      if (!TextUtils.isEmpty(this.owK.bTN().oze))
      {
        this.mMD.setText(this.owK.bTN().oze);
        break;
      }
      this.mMD.setText("");
      break;
      label604:
      this.iVq.setText("");
      this.iVq.setVisibility(8);
      break label129;
      label625:
      n.b(this.oQz, 2131231506, l.Zh(this.owK.bTN().hAD));
      break label206;
      label652:
      if ((this.owK.bTN().FRz == null) || (this.owK.bTN().FRz.size() != 1)) {
        break label403;
      }
      ad.i("MicroMsg.CardWidgetTicket", "primary_fields length is == 1");
      localaaf1 = (aaf)this.owK.bTN().FRz.get(0);
      ((StringBuilder)localObject).append(localaaf1.title);
      localStringBuilder.append(localaaf1.oxN);
      break label403;
      label737:
      this.oQA.setText("");
      break label424;
      label749:
      if (!TextUtils.isEmpty(this.owK.bTN().FRO))
      {
        ad.i("MicroMsg.CardWidgetTicket", "primary_sub_title is not empty!");
        this.oQB.setText(this.owK.bTN().FRO);
        this.oQB.setVisibility(0);
        break label460;
      }
      this.oQB.setVisibility(8);
      break label460;
      label816:
      this.oQC.setVisibility(0);
      this.oQC.setOnClickListener(this.jtG);
      n.b(this.oQF, 2131231507, l.Zh(this.owK.bTN().hAD));
      localStringBuilder = null;
      localObject = localStringBuilder;
      if (this.owR != null)
      {
        localObject = localStringBuilder;
        if (this.owR.size() > 0) {
          localObject = (tl)this.owR.get(0);
        }
      }
      if ((this.owK.bTN().FRD == 1) && (localObject != null))
      {
        this.oQD.setText(((tl)localObject).name);
        this.oQE.setText(this.mContext.getString(2131756996, new Object[] { l.f(this.mContext, ((tl)localObject).zxp), ((tl)localObject).hWY }));
        this.oQG.setVisibility(8);
        this.oQC.setTag(((tl)localObject).name);
      }
      else if ((this.owK.bTN().FRD > 1) && (localObject != null))
      {
        this.oQD.setText(((tl)localObject).name);
        this.oQE.setText(this.mContext.getString(2131756996, new Object[] { l.f(this.mContext, ((tl)localObject).zxp), ((tl)localObject).hWY }));
        this.oQG.setVisibility(0);
        this.oQG.setOnClickListener(this.jtG);
        this.oQC.setTag(((tl)localObject).name);
      }
      else if (this.owK.bTN().FRD > 0)
      {
        this.oQD.setText(2131756806);
        this.oQE.setText(this.mContext.getString(2131757022, new Object[] { Integer.valueOf(this.owK.bTN().FRD) }));
        this.oQG.setVisibility(8);
        this.oQG.setOnClickListener(null);
        this.oQC.setTag(this.mContext.getString(2131756806));
      }
    }
    label1198:
    this.oQy.setVisibility(0);
    AppMethodBeat.o(113914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.f
 * JD-Core Version:    0.7.0.1
 */