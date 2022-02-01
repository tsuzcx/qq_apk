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
import com.tencent.mm.protocal.protobuf.rr;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.LinkedList;

public final class f
  extends a
{
  protected TextView iCg;
  public ArrayList<rr> nTw;
  private View ond;
  private ImageView one;
  private TextView onf;
  private TextView ong;
  private View onh;
  private TextView oni;
  private TextView onj;
  private ImageView onk;
  private TextView onl;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void bUd()
  {
    AppMethodBeat.i(113913);
    this.iCg = ((TextView)bUc().findViewById(2131297911));
    this.ond = bUc().findViewById(2131297740);
    this.one = ((ImageView)bUc().findViewById(2131305805));
    this.onf = ((TextView)bUc().findViewById(2131305804));
    this.ong = ((TextView)bUc().findViewById(2131305803));
    this.onh = bUc().findViewById(2131305807);
    this.oni = ((TextView)bUc().findViewById(2131305809));
    this.onj = ((TextView)bUc().findViewById(2131305808));
    this.onk = ((ImageView)bUc().findViewById(2131305806));
    this.onl = ((TextView)bUc().findViewById(2131305802));
    AppMethodBeat.o(113913);
  }
  
  protected final void bUe()
  {
    AppMethodBeat.i(113914);
    label129:
    label206:
    Object localObject;
    StringBuilder localStringBuilder;
    yg localyg1;
    if ((this.nTp.bPi().EkR != null) && (!TextUtils.isEmpty(this.nTp.bPi().EkR.title)))
    {
      this.mmb.setText(this.nTp.bPi().EkR.title);
      if ((this.nTp.bPi().EkR == null) || (TextUtils.isEmpty(this.nTp.bPi().EkR.nUs))) {
        break label604;
      }
      this.iCg.setText(this.nTp.bPi().EkR.nUs);
      this.iCg.setVisibility(0);
      ac.i("MicroMsg.CardWidgetTicket", "updateContentView()");
      if (bs.isNullOrNil(this.nTp.bPi().Ekx)) {
        break label625;
      }
      int i = this.mContext.getResources().getDimensionPixelSize(2131166000);
      n.a(this.mContext, this.one, this.nTp.bPi().Ekx, i, l.Vy(this.nTp.bPi().hiu));
      localObject = new StringBuilder();
      localStringBuilder = new StringBuilder();
      if ((this.nTp.bPi().Ekq == null) || (this.nTp.bPi().Ekq.size() < 2)) {
        break label652;
      }
      ac.i("MicroMsg.CardWidgetTicket", "primary_fields length is >= 2");
      localyg1 = (yg)this.nTp.bPi().Ekq.get(0);
      yg localyg2 = (yg)this.nTp.bPi().Ekq.get(1);
      ((StringBuilder)localObject).append(localyg1.title).append(" - ").append(localyg2.title);
      if ((!TextUtils.isEmpty(localyg1.nUt)) && (!TextUtils.isEmpty(localyg2.nUt)))
      {
        localStringBuilder.append(localyg1.nUt).append(" ").append(localyg1.nUs);
        localStringBuilder.append(" - ");
        localStringBuilder.append(localyg2.nUt).append(" ").append(localyg2.nUs);
      }
      label403:
      if (TextUtils.isEmpty(((StringBuilder)localObject).toString())) {
        break label737;
      }
      this.onf.setText(((StringBuilder)localObject).toString());
      label424:
      if (TextUtils.isEmpty(localStringBuilder.toString())) {
        break label749;
      }
      ac.i("MicroMsg.CardWidgetTicket", "sub_title_builder is not empty!");
      this.ong.setText(localStringBuilder.toString());
      this.ong.setVisibility(0);
      label460:
      ac.e("MicroMsg.CardWidgetTicket", "updateShopView(), shop_count:" + this.nTp.bPi().Eku);
      if (this.nTp.bPi().Eku > 0) {
        break label816;
      }
      this.onh.setVisibility(8);
      this.onl.setVisibility(8);
    }
    for (;;)
    {
      if (!this.nTp.bPh()) {
        break label1198;
      }
      this.ond.setVisibility(8);
      AppMethodBeat.o(113914);
      return;
      if (!TextUtils.isEmpty(this.nTp.bPi().nVK))
      {
        this.mmb.setText(this.nTp.bPi().nVK);
        break;
      }
      this.mmb.setText("");
      break;
      label604:
      this.iCg.setText("");
      this.iCg.setVisibility(8);
      break label129;
      label625:
      n.b(this.one, 2131231506, l.Vy(this.nTp.bPi().hiu));
      break label206;
      label652:
      if ((this.nTp.bPi().Ekq == null) || (this.nTp.bPi().Ekq.size() != 1)) {
        break label403;
      }
      ac.i("MicroMsg.CardWidgetTicket", "primary_fields length is == 1");
      localyg1 = (yg)this.nTp.bPi().Ekq.get(0);
      ((StringBuilder)localObject).append(localyg1.title);
      localStringBuilder.append(localyg1.nUs);
      break label403;
      label737:
      this.onf.setText("");
      break label424;
      label749:
      if (!TextUtils.isEmpty(this.nTp.bPi().EkF))
      {
        ac.i("MicroMsg.CardWidgetTicket", "primary_sub_title is not empty!");
        this.ong.setText(this.nTp.bPi().EkF);
        this.ong.setVisibility(0);
        break label460;
      }
      this.ong.setVisibility(8);
      break label460;
      label816:
      this.onh.setVisibility(0);
      this.onh.setOnClickListener(this.jax);
      n.b(this.onk, 2131231507, l.Vy(this.nTp.bPi().hiu));
      localStringBuilder = null;
      localObject = localStringBuilder;
      if (this.nTw != null)
      {
        localObject = localStringBuilder;
        if (this.nTw.size() > 0) {
          localObject = (rr)this.nTw.get(0);
        }
      }
      if ((this.nTp.bPi().Eku == 1) && (localObject != null))
      {
        this.oni.setText(((rr)localObject).name);
        this.onj.setText(this.mContext.getString(2131756996, new Object[] { l.f(this.mContext, ((rr)localObject).yhi), ((rr)localObject).hEt }));
        this.onl.setVisibility(8);
        this.onh.setTag(((rr)localObject).name);
      }
      else if ((this.nTp.bPi().Eku > 1) && (localObject != null))
      {
        this.oni.setText(((rr)localObject).name);
        this.onj.setText(this.mContext.getString(2131756996, new Object[] { l.f(this.mContext, ((rr)localObject).yhi), ((rr)localObject).hEt }));
        this.onl.setVisibility(0);
        this.onl.setOnClickListener(this.jax);
        this.onh.setTag(((rr)localObject).name);
      }
      else if (this.nTp.bPi().Eku > 0)
      {
        this.oni.setText(2131756806);
        this.onj.setText(this.mContext.getString(2131757022, new Object[] { Integer.valueOf(this.nTp.bPi().Eku) }));
        this.onl.setVisibility(8);
        this.onl.setOnClickListener(null);
        this.onh.setTag(this.mContext.getString(2131756806));
      }
    }
    label1198:
    this.ond.setVisibility(0);
    AppMethodBeat.o(113914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.f
 * JD-Core Version:    0.7.0.1
 */