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
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.protocal.protobuf.oz;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.LinkedList;

public final class f
  extends a
{
  protected TextView gpL;
  private View kDf;
  private ImageView kDg;
  private TextView kDh;
  private TextView kDi;
  private View kDj;
  private TextView kDk;
  private TextView kDl;
  private ImageView kDm;
  private TextView kDn;
  public ArrayList<oz> klq;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void bfH()
  {
    AppMethodBeat.i(88985);
    this.gpL = ((TextView)bfG().findViewById(2131822059));
    this.kDf = bfG().findViewById(2131822057);
    this.kDg = ((ImageView)bfG().findViewById(2131822400));
    this.kDh = ((TextView)bfG().findViewById(2131822401));
    this.kDi = ((TextView)bfG().findViewById(2131822402));
    this.kDj = bfG().findViewById(2131822403);
    this.kDk = ((TextView)bfG().findViewById(2131822405));
    this.kDl = ((TextView)bfG().findViewById(2131822406));
    this.kDm = ((ImageView)bfG().findViewById(2131822404));
    this.kDn = ((TextView)bfG().findViewById(2131822407));
    AppMethodBeat.o(88985);
  }
  
  protected final void bfI()
  {
    AppMethodBeat.i(88986);
    label129:
    label206:
    Object localObject;
    StringBuilder localStringBuilder;
    uo localuo1;
    if ((this.klk.bbd().wGB != null) && (!TextUtils.isEmpty(this.klk.bbd().wGB.title)))
    {
      this.iVS.setText(this.klk.bbd().wGB.title);
      if ((this.klk.bbd().wGB == null) || (TextUtils.isEmpty(this.klk.bbd().wGB.kmn))) {
        break label604;
      }
      this.gpL.setText(this.klk.bbd().wGB.kmn);
      this.gpL.setVisibility(0);
      ab.i("MicroMsg.CardWidgetTicket", "updateContentView()");
      if (bo.isNullOrNil(this.klk.bbd().wGh)) {
        break label625;
      }
      int i = this.mContext.getResources().getDimensionPixelSize(2131428201);
      m.a(this.mContext, this.kDg, this.klk.bbd().wGh, i, l.IB(this.klk.bbd().color));
      localObject = new StringBuilder();
      localStringBuilder = new StringBuilder();
      if ((this.klk.bbd().wFZ == null) || (this.klk.bbd().wFZ.size() < 2)) {
        break label652;
      }
      ab.i("MicroMsg.CardWidgetTicket", "primary_fields length is >= 2");
      localuo1 = (uo)this.klk.bbd().wFZ.get(0);
      uo localuo2 = (uo)this.klk.bbd().wFZ.get(1);
      ((StringBuilder)localObject).append(localuo1.title).append(" - ").append(localuo2.title);
      if ((!TextUtils.isEmpty(localuo1.kmo)) && (!TextUtils.isEmpty(localuo2.kmo)))
      {
        localStringBuilder.append(localuo1.kmo).append(" ").append(localuo1.kmn);
        localStringBuilder.append(" - ");
        localStringBuilder.append(localuo2.kmo).append(" ").append(localuo2.kmn);
      }
      label403:
      if (TextUtils.isEmpty(((StringBuilder)localObject).toString())) {
        break label737;
      }
      this.kDh.setText(((StringBuilder)localObject).toString());
      label424:
      if (TextUtils.isEmpty(localStringBuilder.toString())) {
        break label749;
      }
      ab.i("MicroMsg.CardWidgetTicket", "sub_title_builder is not empty!");
      this.kDi.setText(localStringBuilder.toString());
      this.kDi.setVisibility(0);
      label460:
      ab.e("MicroMsg.CardWidgetTicket", "updateShopView(), shop_count:" + this.klk.bbd().wGd);
      if (this.klk.bbd().wGd > 0) {
        break label816;
      }
      this.kDj.setVisibility(8);
      this.kDn.setVisibility(8);
    }
    for (;;)
    {
      if (!this.klk.bbc()) {
        break label1198;
      }
      this.kDf.setVisibility(8);
      AppMethodBeat.o(88986);
      return;
      if (!TextUtils.isEmpty(this.klk.bbd().knw))
      {
        this.iVS.setText(this.klk.bbd().knw);
        break;
      }
      this.iVS.setText("");
      break;
      label604:
      this.gpL.setText("");
      this.gpL.setVisibility(8);
      break label129;
      label625:
      m.a(this.kDg, 2130838175, l.IB(this.klk.bbd().color));
      break label206;
      label652:
      if ((this.klk.bbd().wFZ == null) || (this.klk.bbd().wFZ.size() != 1)) {
        break label403;
      }
      ab.i("MicroMsg.CardWidgetTicket", "primary_fields length is == 1");
      localuo1 = (uo)this.klk.bbd().wFZ.get(0);
      ((StringBuilder)localObject).append(localuo1.title);
      localStringBuilder.append(localuo1.kmn);
      break label403;
      label737:
      this.kDh.setText("");
      break label424;
      label749:
      if (!TextUtils.isEmpty(this.klk.bbd().wGp))
      {
        ab.i("MicroMsg.CardWidgetTicket", "primary_sub_title is not empty!");
        this.kDi.setText(this.klk.bbd().wGp);
        this.kDi.setVisibility(0);
        break label460;
      }
      this.kDi.setVisibility(8);
      break label460;
      label816:
      this.kDj.setVisibility(0);
      this.kDj.setOnClickListener(this.gMO);
      m.a(this.kDm, 2130838176, l.IB(this.klk.bbd().color));
      localStringBuilder = null;
      localObject = localStringBuilder;
      if (this.klq != null)
      {
        localObject = localStringBuilder;
        if (this.klq.size() > 0) {
          localObject = (oz)this.klq.get(0);
        }
      }
      if ((this.klk.bbd().wGd == 1) && (localObject != null))
      {
        this.kDk.setText(((oz)localObject).name);
        this.kDl.setText(this.mContext.getString(2131298054, new Object[] { l.g(this.mContext, ((oz)localObject).rqZ), ((oz)localObject).fBq }));
        this.kDn.setVisibility(8);
        this.kDj.setTag(((oz)localObject).name);
      }
      else if ((this.klk.bbd().wGd > 1) && (localObject != null))
      {
        this.kDk.setText(((oz)localObject).name);
        this.kDl.setText(this.mContext.getString(2131298054, new Object[] { l.g(this.mContext, ((oz)localObject).rqZ), ((oz)localObject).fBq }));
        this.kDn.setVisibility(0);
        this.kDn.setOnClickListener(this.gMO);
        this.kDj.setTag(((oz)localObject).name);
      }
      else if (this.klk.bbd().wGd > 0)
      {
        this.kDk.setText(2131297874);
        this.kDl.setText(this.mContext.getString(2131298080, new Object[] { Integer.valueOf(this.klk.bbd().wGd) }));
        this.kDn.setVisibility(8);
        this.kDn.setOnClickListener(null);
        this.kDj.setTag(this.mContext.getString(2131297874));
      }
    }
    label1198:
    this.kDf.setVisibility(0);
    AppMethodBeat.o(88986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.f
 * JD-Core Version:    0.7.0.1
 */