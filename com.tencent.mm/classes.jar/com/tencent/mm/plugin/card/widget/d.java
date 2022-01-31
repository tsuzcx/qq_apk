package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class d
  extends a
{
  private View kCO;
  private TextView kCP;
  private TextView kCQ;
  private View kCR;
  private TextView kCS;
  private TextView kCT;
  private View kCU;
  private View kCV;
  private View kCW;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void bfH()
  {
    AppMethodBeat.i(88976);
    this.kCO = this.kCC.findViewById(2131822252);
    this.kCP = ((TextView)this.kCC.findViewById(2131822253));
    this.kCQ = ((TextView)this.kCC.findViewById(2131822254));
    this.kCR = this.kCC.findViewById(2131822255);
    this.kCS = ((TextView)this.kCC.findViewById(2131822256));
    this.kCT = ((TextView)this.kCC.findViewById(2131822257));
    this.kCV = this.kCC.findViewById(2131822260);
    this.kCW = this.kCC.findViewById(2131822259);
    AppMethodBeat.o(88976);
  }
  
  protected final void bfI()
  {
    AppMethodBeat.i(88977);
    Object localObject3;
    Object localObject2;
    Object localObject1;
    if ((this.klk.bbd().wFZ != null) && (this.klk.bbd().wFZ.size() > 0))
    {
      localObject3 = this.klk.bbd().wFZ;
      localObject2 = null;
      if (((LinkedList)localObject3).size() == 1)
      {
        localObject1 = (uo)((LinkedList)localObject3).get(0);
        if (localObject1 != null)
        {
          this.kCO.setVisibility(0);
          this.kCP.setText(((uo)localObject1).title);
          this.kCQ.setText(((uo)localObject1).kmn);
          if (!TextUtils.isEmpty(((uo)localObject1).wHa)) {
            this.kCP.setTextColor(l.IB(((uo)localObject1).wHa));
          }
          if (!TextUtils.isEmpty(((uo)localObject1).wHb)) {
            this.kCQ.setTextColor(l.IB(((uo)localObject1).wHb));
          }
        }
        if (localObject2 != null)
        {
          this.kCR.setVisibility(0);
          this.kCS.setText(((uo)localObject2).title);
          this.kCT.setText(((uo)localObject2).kmn);
          if (!TextUtils.isEmpty(((uo)localObject2).wHa)) {
            this.kCS.setTextColor(l.IB(((uo)localObject2).wHa));
          }
          if (!TextUtils.isEmpty(((uo)localObject2).wHb)) {
            this.kCT.setTextColor(l.IB(((uo)localObject2).wHb));
          }
        }
        label234:
        if ((!this.klk.baJ()) || (this.klk.baP())) {
          break label358;
        }
        ab.i("MicroMsg.CardWidgetInvoice", "is not invoice, don't updateCardSecondaryFieldListView");
        label265:
        if (!this.klk.isNormal()) {
          break label866;
        }
        this.kCV.setVisibility(8);
      }
    }
    for (;;)
    {
      if ((this.klk.bbe().wEd != null) || (!this.klk.isNormal())) {
        break label943;
      }
      this.kCW.setVisibility(0);
      AppMethodBeat.o(88977);
      return;
      localObject1 = (uo)((LinkedList)localObject3).get(0);
      localObject2 = (uo)((LinkedList)localObject3).get(1);
      break;
      ab.i("MicroMsg.CardWidgetInvoice", "primary_fields is null");
      break label234;
      label358:
      if ((this.klk.bbe().wDU != null) && (this.klk.bbe().wDU.size() > 0))
      {
        if (this.kCU == null) {
          this.kCU = ((ViewStub)this.kCC.findViewById(2131822258)).inflate();
        }
        this.kCC.findViewById(2131822259).setVisibility(8);
        localObject1 = this.kCU;
        localObject3 = this.klk;
        localObject2 = this.gMO;
        localObject3 = ((b)localObject3).bbe().wDU;
        if (((LinkedList)localObject3).size() == 1)
        {
          ((View)localObject1).findViewById(2131822343).setVisibility(0);
          localObject3 = (uo)((LinkedList)localObject3).get(0);
          ((TextView)((View)localObject1).findViewById(2131822344)).setText(((uo)localObject3).title);
          ((TextView)((View)localObject1).findViewById(2131822345)).setText(((uo)localObject3).kmn);
          ((View)localObject1).findViewById(2131822343).setOnClickListener((View.OnClickListener)localObject2);
          if (!TextUtils.isEmpty(((uo)localObject3).wHa)) {
            ((TextView)((View)localObject1).findViewById(2131822344)).setTextColor(l.IB(((uo)localObject3).wHa));
          }
          if (!TextUtils.isEmpty(((uo)localObject3).wHb)) {
            ((TextView)((View)localObject1).findViewById(2131822345)).setTextColor(l.IB(((uo)localObject3).wHb));
          }
          ((View)localObject1).findViewById(2131822346).setVisibility(8);
          break label265;
        }
        if (((LinkedList)localObject3).size() < 2) {
          break label265;
        }
        uo localuo = (uo)((LinkedList)localObject3).get(0);
        ((TextView)((View)localObject1).findViewById(2131822344)).setText(localuo.title);
        ((TextView)((View)localObject1).findViewById(2131822345)).setText(localuo.kmn);
        if (!TextUtils.isEmpty(localuo.wHa)) {
          ((TextView)((View)localObject1).findViewById(2131822344)).setTextColor(l.IB(localuo.wHa));
        }
        if (!TextUtils.isEmpty(localuo.wHb)) {
          ((TextView)((View)localObject1).findViewById(2131822345)).setTextColor(l.IB(localuo.wHb));
        }
        localObject3 = (uo)((LinkedList)localObject3).get(1);
        ((TextView)((View)localObject1).findViewById(2131822347)).setText(((uo)localObject3).title);
        ((TextView)((View)localObject1).findViewById(2131822348)).setText(((uo)localObject3).kmn);
        if (!TextUtils.isEmpty(((uo)localObject3).wHa)) {
          ((TextView)((View)localObject1).findViewById(2131822347)).setTextColor(l.IB(((uo)localObject3).wHa));
        }
        if (!TextUtils.isEmpty(((uo)localObject3).wHb)) {
          ((TextView)((View)localObject1).findViewById(2131822348)).setTextColor(l.IB(((uo)localObject3).wHb));
        }
        ((View)localObject1).findViewById(2131822343).setOnClickListener((View.OnClickListener)localObject2);
        ((View)localObject1).findViewById(2131822346).setOnClickListener((View.OnClickListener)localObject2);
        break label265;
      }
      if (this.kCU != null) {
        this.kCU.setVisibility(8);
      }
      this.kCC.findViewById(2131822259).setVisibility(8);
      break label265;
      label866:
      this.kCV.setVisibility(0);
      localObject1 = (TextView)this.kCV.findViewById(2131822381);
      if (!TextUtils.isEmpty(this.klk.bbd().wGx)) {
        ((TextView)localObject1).setText(this.klk.bbd().wGx);
      } else {
        m.f((TextView)localObject1, this.klk.bbe().status);
      }
    }
    label943:
    this.kCW.setVisibility(8);
    AppMethodBeat.o(88977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.d
 * JD-Core Version:    0.7.0.1
 */