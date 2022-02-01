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
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.c.n;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.wl;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedList;

public final class f
  extends a
{
  protected TextView pJJ;
  private ImageView wLA;
  private TextView wLB;
  private TextView wLC;
  private View wLD;
  private TextView wLE;
  private TextView wLF;
  private ImageView wLG;
  private TextView wLH;
  private View wLz;
  public ArrayList<wl> wrB;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void doX()
  {
    AppMethodBeat.i(113913);
    this.pJJ = ((TextView)doW().findViewById(a.d.fvy));
    this.wLz = doW().findViewById(a.d.wfx);
    this.wLA = ((ImageView)doW().findViewById(a.d.wlD));
    this.wLB = ((TextView)doW().findViewById(a.d.wlC));
    this.wLC = ((TextView)doW().findViewById(a.d.wlB));
    this.wLD = doW().findViewById(a.d.wlF);
    this.wLE = ((TextView)doW().findViewById(a.d.wlH));
    this.wLF = ((TextView)doW().findViewById(a.d.wlG));
    this.wLG = ((ImageView)doW().findViewById(a.d.wlE));
    this.wLH = ((TextView)doW().findViewById(a.d.wlA));
    AppMethodBeat.o(113913);
  }
  
  protected final void doY()
  {
    AppMethodBeat.i(113914);
    label129:
    label210:
    Object localObject;
    StringBuilder localStringBuilder;
    aek localaek1;
    if ((this.wru.djK().Zel != null) && (!TextUtils.isEmpty(this.wru.djK().Zel.title)))
    {
      this.uov.setText(this.wru.djK().Zel.title);
      if ((this.wru.djK().Zel == null) || (TextUtils.isEmpty(this.wru.djK().Zel.wsz))) {
        break label609;
      }
      this.pJJ.setText(this.wru.djK().Zel.wsz);
      this.pJJ.setVisibility(0);
      Log.i("MicroMsg.CardWidgetTicket", "updateContentView()");
      if (Util.isNullOrNil(this.wru.djK().ZdR)) {
        break label631;
      }
      int i = this.mContext.getResources().getDimensionPixelSize(a.b.weh);
      n.a(this.mContext, this.wLA, this.wru.djK().ZdR, i, a.c.wev, l.alv(this.wru.djK().nRQ));
      localObject = new StringBuilder();
      localStringBuilder = new StringBuilder();
      if ((this.wru.djK().ZdK == null) || (this.wru.djK().ZdK.size() < 2)) {
        break label659;
      }
      Log.i("MicroMsg.CardWidgetTicket", "primary_fields length is >= 2");
      localaek1 = (aek)this.wru.djK().ZdK.get(0);
      aek localaek2 = (aek)this.wru.djK().ZdK.get(1);
      ((StringBuilder)localObject).append(localaek1.title).append(" - ").append(localaek2.title);
      if ((!TextUtils.isEmpty(localaek1.wsA)) && (!TextUtils.isEmpty(localaek2.wsA)))
      {
        localStringBuilder.append(localaek1.wsA).append(" ").append(localaek1.wsz);
        localStringBuilder.append(" - ");
        localStringBuilder.append(localaek2.wsA).append(" ").append(localaek2.wsz);
      }
      label407:
      if (TextUtils.isEmpty(((StringBuilder)localObject).toString())) {
        break label745;
      }
      this.wLB.setText(((StringBuilder)localObject).toString());
      label428:
      if (TextUtils.isEmpty(localStringBuilder.toString())) {
        break label758;
      }
      Log.i("MicroMsg.CardWidgetTicket", "sub_title_builder is not empty!");
      this.wLC.setText(localStringBuilder.toString());
      this.wLC.setVisibility(0);
      label464:
      Log.e("MicroMsg.CardWidgetTicket", "updateShopView(), shop_count:" + this.wru.djK().ZdO);
      if (this.wru.djK().ZdO > 0) {
        break label826;
      }
      this.wLD.setVisibility(8);
      this.wLH.setVisibility(8);
    }
    for (;;)
    {
      if (!this.wru.djJ()) {
        break label1208;
      }
      this.wLz.setVisibility(8);
      AppMethodBeat.o(113914);
      return;
      if (!TextUtils.isEmpty(this.wru.djK().mee))
      {
        this.uov.setText(this.wru.djK().mee);
        break;
      }
      this.uov.setText("");
      break;
      label609:
      this.pJJ.setText("");
      this.pJJ.setVisibility(8);
      break label129;
      label631:
      n.b(this.wLA, a.c.wev, l.alv(this.wru.djK().nRQ));
      break label210;
      label659:
      if ((this.wru.djK().ZdK == null) || (this.wru.djK().ZdK.size() != 1)) {
        break label407;
      }
      Log.i("MicroMsg.CardWidgetTicket", "primary_fields length is == 1");
      localaek1 = (aek)this.wru.djK().ZdK.get(0);
      ((StringBuilder)localObject).append(localaek1.title);
      localStringBuilder.append(localaek1.wsz);
      break label407;
      label745:
      this.wLB.setText("");
      break label428;
      label758:
      if (!TextUtils.isEmpty(this.wru.djK().ZdZ))
      {
        Log.i("MicroMsg.CardWidgetTicket", "primary_sub_title is not empty!");
        this.wLC.setText(this.wru.djK().ZdZ);
        this.wLC.setVisibility(0);
        break label464;
      }
      this.wLC.setVisibility(8);
      break label464;
      label826:
      this.wLD.setVisibility(0);
      this.wLD.setOnClickListener(this.qjL);
      n.b(this.wLG, a.c.wew, l.alv(this.wru.djK().nRQ));
      localStringBuilder = null;
      localObject = localStringBuilder;
      if (this.wrB != null)
      {
        localObject = localStringBuilder;
        if (this.wrB.size() > 0) {
          localObject = (wl)this.wrB.get(0);
        }
      }
      if ((this.wru.djK().ZdO == 1) && (localObject != null))
      {
        this.wLE.setText(((wl)localObject).name);
        this.wLF.setText(this.mContext.getString(a.g.wqk, new Object[] { l.f(this.mContext, ((wl)localObject).TG), ((wl)localObject).oDI }));
        this.wLH.setVisibility(8);
        this.wLD.setTag(((wl)localObject).name);
      }
      else if ((this.wru.djK().ZdO > 1) && (localObject != null))
      {
        this.wLE.setText(((wl)localObject).name);
        this.wLF.setText(this.mContext.getString(a.g.wqk, new Object[] { l.f(this.mContext, ((wl)localObject).TG), ((wl)localObject).oDI }));
        this.wLH.setVisibility(0);
        this.wLH.setOnClickListener(this.qjL);
        this.wLD.setTag(((wl)localObject).name);
      }
      else if (this.wru.djK().ZdO > 0)
      {
        this.wLE.setText(a.g.woi);
        this.wLF.setText(this.mContext.getString(a.g.wqF, new Object[] { Integer.valueOf(this.wru.djK().ZdO) }));
        this.wLH.setVisibility(8);
        this.wLH.setOnClickListener(null);
        this.wLD.setTag(this.mContext.getString(a.g.woi));
      }
    }
    label1208:
    this.wLz.setVisibility(0);
    AppMethodBeat.o(113914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.f
 * JD-Core Version:    0.7.0.1
 */