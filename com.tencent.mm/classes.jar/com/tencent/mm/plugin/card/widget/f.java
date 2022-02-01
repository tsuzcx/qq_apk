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
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedList;

public final class f
  extends a
{
  protected TextView jVO;
  public ArrayList<us> pRc;
  private View qlU;
  private ImageView qlV;
  private TextView qlW;
  private TextView qlX;
  private View qlY;
  private TextView qlZ;
  private TextView qma;
  private ImageView qmb;
  private TextView qmc;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void cxM()
  {
    AppMethodBeat.i(113913);
    this.jVO = ((TextView)cxL().findViewById(2131298229));
    this.qlU = cxL().findViewById(2131298052);
    this.qlV = ((ImageView)cxL().findViewById(2131309080));
    this.qlW = ((TextView)cxL().findViewById(2131309079));
    this.qlX = ((TextView)cxL().findViewById(2131309078));
    this.qlY = cxL().findViewById(2131309082);
    this.qlZ = ((TextView)cxL().findViewById(2131309084));
    this.qma = ((TextView)cxL().findViewById(2131309083));
    this.qmb = ((ImageView)cxL().findViewById(2131309081));
    this.qmc = ((TextView)cxL().findViewById(2131309077));
    AppMethodBeat.o(113913);
  }
  
  protected final void cxN()
  {
    AppMethodBeat.i(113914);
    label129:
    label206:
    Object localObject;
    StringBuilder localStringBuilder;
    abz localabz1;
    if ((this.pQV.csQ().Lfc != null) && (!TextUtils.isEmpty(this.pQV.csQ().Lfc.title)))
    {
      this.oeJ.setText(this.pQV.csQ().Lfc.title);
      if ((this.pQV.csQ().Lfc == null) || (TextUtils.isEmpty(this.pQV.csQ().Lfc.pRY))) {
        break label604;
      }
      this.jVO.setText(this.pQV.csQ().Lfc.pRY);
      this.jVO.setVisibility(0);
      Log.i("MicroMsg.CardWidgetTicket", "updateContentView()");
      if (Util.isNullOrNil(this.pQV.csQ().LeI)) {
        break label625;
      }
      int i = this.mContext.getResources().getDimensionPixelSize(2131166032);
      n.a(this.mContext, this.qlV, this.pQV.csQ().LeI, i, l.ake(this.pQV.csQ().ixw));
      localObject = new StringBuilder();
      localStringBuilder = new StringBuilder();
      if ((this.pQV.csQ().LeC == null) || (this.pQV.csQ().LeC.size() < 2)) {
        break label652;
      }
      Log.i("MicroMsg.CardWidgetTicket", "primary_fields length is >= 2");
      localabz1 = (abz)this.pQV.csQ().LeC.get(0);
      abz localabz2 = (abz)this.pQV.csQ().LeC.get(1);
      ((StringBuilder)localObject).append(localabz1.title).append(" - ").append(localabz2.title);
      if ((!TextUtils.isEmpty(localabz1.pRZ)) && (!TextUtils.isEmpty(localabz2.pRZ)))
      {
        localStringBuilder.append(localabz1.pRZ).append(" ").append(localabz1.pRY);
        localStringBuilder.append(" - ");
        localStringBuilder.append(localabz2.pRZ).append(" ").append(localabz2.pRY);
      }
      label403:
      if (TextUtils.isEmpty(((StringBuilder)localObject).toString())) {
        break label737;
      }
      this.qlW.setText(((StringBuilder)localObject).toString());
      label424:
      if (TextUtils.isEmpty(localStringBuilder.toString())) {
        break label749;
      }
      Log.i("MicroMsg.CardWidgetTicket", "sub_title_builder is not empty!");
      this.qlX.setText(localStringBuilder.toString());
      this.qlX.setVisibility(0);
      label460:
      Log.e("MicroMsg.CardWidgetTicket", "updateShopView(), shop_count:" + this.pQV.csQ().LeF);
      if (this.pQV.csQ().LeF > 0) {
        break label816;
      }
      this.qlY.setVisibility(8);
      this.qmc.setVisibility(8);
    }
    for (;;)
    {
      if (!this.pQV.csP()) {
        break label1198;
      }
      this.qlU.setVisibility(8);
      AppMethodBeat.o(113914);
      return;
      if (!TextUtils.isEmpty(this.pQV.csQ().gTG))
      {
        this.oeJ.setText(this.pQV.csQ().gTG);
        break;
      }
      this.oeJ.setText("");
      break;
      label604:
      this.jVO.setText("");
      this.jVO.setVisibility(8);
      break label129;
      label625:
      n.b(this.qlV, 2131231570, l.ake(this.pQV.csQ().ixw));
      break label206;
      label652:
      if ((this.pQV.csQ().LeC == null) || (this.pQV.csQ().LeC.size() != 1)) {
        break label403;
      }
      Log.i("MicroMsg.CardWidgetTicket", "primary_fields length is == 1");
      localabz1 = (abz)this.pQV.csQ().LeC.get(0);
      ((StringBuilder)localObject).append(localabz1.title);
      localStringBuilder.append(localabz1.pRY);
      break label403;
      label737:
      this.qlW.setText("");
      break label424;
      label749:
      if (!TextUtils.isEmpty(this.pQV.csQ().LeQ))
      {
        Log.i("MicroMsg.CardWidgetTicket", "primary_sub_title is not empty!");
        this.qlX.setText(this.pQV.csQ().LeQ);
        this.qlX.setVisibility(0);
        break label460;
      }
      this.qlX.setVisibility(8);
      break label460;
      label816:
      this.qlY.setVisibility(0);
      this.qlY.setOnClickListener(this.kuO);
      n.b(this.qmb, 2131231571, l.ake(this.pQV.csQ().ixw));
      localStringBuilder = null;
      localObject = localStringBuilder;
      if (this.pRc != null)
      {
        localObject = localStringBuilder;
        if (this.pRc.size() > 0) {
          localObject = (us)this.pRc.get(0);
        }
      }
      if ((this.pQV.csQ().LeF == 1) && (localObject != null))
      {
        this.qlZ.setText(((us)localObject).name);
        this.qma.setText(this.mContext.getString(2131757166, new Object[] { l.f(this.mContext, ((us)localObject).DWG), ((us)localObject).iUO }));
        this.qmc.setVisibility(8);
        this.qlY.setTag(((us)localObject).name);
      }
      else if ((this.pQV.csQ().LeF > 1) && (localObject != null))
      {
        this.qlZ.setText(((us)localObject).name);
        this.qma.setText(this.mContext.getString(2131757166, new Object[] { l.f(this.mContext, ((us)localObject).DWG), ((us)localObject).iUO }));
        this.qmc.setVisibility(0);
        this.qmc.setOnClickListener(this.kuO);
        this.qlY.setTag(((us)localObject).name);
      }
      else if (this.pQV.csQ().LeF > 0)
      {
        this.qlZ.setText(2131756971);
        this.qma.setText(this.mContext.getString(2131757192, new Object[] { Integer.valueOf(this.pQV.csQ().LeF) }));
        this.qmc.setVisibility(8);
        this.qmc.setOnClickListener(null);
        this.qlY.setTag(this.mContext.getString(2131756971));
      }
    }
    label1198:
    this.qlU.setVisibility(0);
    AppMethodBeat.o(113914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.f
 * JD-Core Version:    0.7.0.1
 */