package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.uu;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedList;

public final class f
  extends a
{
  protected TextView mNb;
  private View tHP;
  private ImageView tHQ;
  private TextView tHR;
  private TextView tHS;
  private View tHT;
  private TextView tHU;
  private TextView tHV;
  private ImageView tHW;
  private TextView tHX;
  public ArrayList<uu> tnb;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void cLo()
  {
    AppMethodBeat.i(113913);
    this.mNb = ((TextView)cLn().findViewById(a.d.dvg));
    this.tHP = cLn().findViewById(a.d.tbn);
    this.tHQ = ((ImageView)cLn().findViewById(a.d.thd));
    this.tHR = ((TextView)cLn().findViewById(a.d.thc));
    this.tHS = ((TextView)cLn().findViewById(a.d.thb));
    this.tHT = cLn().findViewById(a.d.thf);
    this.tHU = ((TextView)cLn().findViewById(a.d.thh));
    this.tHV = ((TextView)cLn().findViewById(a.d.thg));
    this.tHW = ((ImageView)cLn().findViewById(a.d.the));
    this.tHX = ((TextView)cLn().findViewById(a.d.tha));
    AppMethodBeat.o(113913);
  }
  
  protected final void cLp()
  {
    AppMethodBeat.i(113914);
    label129:
    label210:
    Object localObject;
    StringBuilder localStringBuilder;
    acg localacg1;
    if ((this.tmU.cGs().Sgq != null) && (!TextUtils.isEmpty(this.tmU.cGs().Sgq.title)))
    {
      this.rgv.setText(this.tmU.cGs().Sgq.title);
      if ((this.tmU.cGs().Sgq == null) || (TextUtils.isEmpty(this.tmU.cGs().Sgq.tnY))) {
        break label609;
      }
      this.mNb.setText(this.tmU.cGs().Sgq.tnY);
      this.mNb.setVisibility(0);
      Log.i("MicroMsg.CardWidgetTicket", "updateContentView()");
      if (Util.isNullOrNil(this.tmU.cGs().SfW)) {
        break label631;
      }
      int i = this.mContext.getResources().getDimensionPixelSize(a.b.taa);
      n.a(this.mContext, this.tHQ, this.tmU.cGs().SfW, i, a.c.tan, l.arR(this.tmU.cGs().lmL));
      localObject = new StringBuilder();
      localStringBuilder = new StringBuilder();
      if ((this.tmU.cGs().SfP == null) || (this.tmU.cGs().SfP.size() < 2)) {
        break label659;
      }
      Log.i("MicroMsg.CardWidgetTicket", "primary_fields length is >= 2");
      localacg1 = (acg)this.tmU.cGs().SfP.get(0);
      acg localacg2 = (acg)this.tmU.cGs().SfP.get(1);
      ((StringBuilder)localObject).append(localacg1.title).append(" - ").append(localacg2.title);
      if ((!TextUtils.isEmpty(localacg1.tnZ)) && (!TextUtils.isEmpty(localacg2.tnZ)))
      {
        localStringBuilder.append(localacg1.tnZ).append(" ").append(localacg1.tnY);
        localStringBuilder.append(" - ");
        localStringBuilder.append(localacg2.tnZ).append(" ").append(localacg2.tnY);
      }
      label407:
      if (TextUtils.isEmpty(((StringBuilder)localObject).toString())) {
        break label745;
      }
      this.tHR.setText(((StringBuilder)localObject).toString());
      label428:
      if (TextUtils.isEmpty(localStringBuilder.toString())) {
        break label758;
      }
      Log.i("MicroMsg.CardWidgetTicket", "sub_title_builder is not empty!");
      this.tHS.setText(localStringBuilder.toString());
      this.tHS.setVisibility(0);
      label464:
      Log.e("MicroMsg.CardWidgetTicket", "updateShopView(), shop_count:" + this.tmU.cGs().SfT);
      if (this.tmU.cGs().SfT > 0) {
        break label826;
      }
      this.tHT.setVisibility(8);
      this.tHX.setVisibility(8);
    }
    for (;;)
    {
      if (!this.tmU.cGr()) {
        break label1208;
      }
      this.tHP.setVisibility(8);
      AppMethodBeat.o(113914);
      return;
      if (!TextUtils.isEmpty(this.tmU.cGs().jEi))
      {
        this.rgv.setText(this.tmU.cGs().jEi);
        break;
      }
      this.rgv.setText("");
      break;
      label609:
      this.mNb.setText("");
      this.mNb.setVisibility(8);
      break label129;
      label631:
      n.b(this.tHQ, a.c.tan, l.arR(this.tmU.cGs().lmL));
      break label210;
      label659:
      if ((this.tmU.cGs().SfP == null) || (this.tmU.cGs().SfP.size() != 1)) {
        break label407;
      }
      Log.i("MicroMsg.CardWidgetTicket", "primary_fields length is == 1");
      localacg1 = (acg)this.tmU.cGs().SfP.get(0);
      ((StringBuilder)localObject).append(localacg1.title);
      localStringBuilder.append(localacg1.tnY);
      break label407;
      label745:
      this.tHR.setText("");
      break label428;
      label758:
      if (!TextUtils.isEmpty(this.tmU.cGs().Sge))
      {
        Log.i("MicroMsg.CardWidgetTicket", "primary_sub_title is not empty!");
        this.tHS.setText(this.tmU.cGs().Sge);
        this.tHS.setVisibility(0);
        break label464;
      }
      this.tHS.setVisibility(8);
      break label464;
      label826:
      this.tHT.setVisibility(0);
      this.tHT.setOnClickListener(this.nmC);
      n.b(this.tHW, a.c.tao, l.arR(this.tmU.cGs().lmL));
      localStringBuilder = null;
      localObject = localStringBuilder;
      if (this.tnb != null)
      {
        localObject = localStringBuilder;
        if (this.tnb.size() > 0) {
          localObject = (uu)this.tnb.get(0);
        }
      }
      if ((this.tmU.cGs().SfT == 1) && (localObject != null))
      {
        this.tHU.setText(((uu)localObject).name);
        this.tHV.setText(this.mContext.getString(a.g.tlL, new Object[] { l.f(this.mContext, ((uu)localObject).KjR), ((uu)localObject).lLg }));
        this.tHX.setVisibility(8);
        this.tHT.setTag(((uu)localObject).name);
      }
      else if ((this.tmU.cGs().SfT > 1) && (localObject != null))
      {
        this.tHU.setText(((uu)localObject).name);
        this.tHV.setText(this.mContext.getString(a.g.tlL, new Object[] { l.f(this.mContext, ((uu)localObject).KjR), ((uu)localObject).lLg }));
        this.tHX.setVisibility(0);
        this.tHX.setOnClickListener(this.nmC);
        this.tHT.setTag(((uu)localObject).name);
      }
      else if (this.tmU.cGs().SfT > 0)
      {
        this.tHU.setText(a.g.tjL);
        this.tHV.setText(this.mContext.getString(a.g.tmg, new Object[] { Integer.valueOf(this.tmU.cGs().SfT) }));
        this.tHX.setVisibility(8);
        this.tHX.setOnClickListener(null);
        this.tHT.setTag(this.mContext.getString(a.g.tjL));
      }
    }
    label1208:
    this.tHP.setVisibility(0);
    AppMethodBeat.o(113914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.f
 * JD-Core Version:    0.7.0.1
 */