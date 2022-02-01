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
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class d
  extends a
{
  private View nJM;
  private TextView nJN;
  private TextView nJO;
  private View nJP;
  private TextView nJQ;
  private TextView nJR;
  private View nJS;
  private View nJT;
  private View nJU;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void bMS()
  {
    AppMethodBeat.i(113904);
    this.nJM = this.nJA.findViewById(2131303161);
    this.nJN = ((TextView)this.nJA.findViewById(2131303163));
    this.nJO = ((TextView)this.nJA.findViewById(2131303162));
    this.nJP = this.nJA.findViewById(2131297221);
    this.nJQ = ((TextView)this.nJA.findViewById(2131297223));
    this.nJR = ((TextView)this.nJA.findViewById(2131297222));
    this.nJT = this.nJA.findViewById(2131297923);
    this.nJU = this.nJA.findViewById(2131297741);
    AppMethodBeat.o(113904);
  }
  
  protected final void bMT()
  {
    AppMethodBeat.i(113905);
    Object localObject3;
    Object localObject2;
    Object localObject1;
    if ((this.nqp.bHV().CRF != null) && (this.nqp.bHV().CRF.size() > 0))
    {
      localObject3 = this.nqp.bHV().CRF;
      localObject2 = null;
      if (((LinkedList)localObject3).size() == 1)
      {
        localObject1 = (xo)((LinkedList)localObject3).get(0);
        if (localObject1 != null)
        {
          this.nJM.setVisibility(0);
          this.nJN.setText(((xo)localObject1).title);
          this.nJO.setText(((xo)localObject1).nrs);
          if (!TextUtils.isEmpty(((xo)localObject1).CSI)) {
            this.nJN.setTextColor(l.Rm(((xo)localObject1).CSI));
          }
          if (!TextUtils.isEmpty(((xo)localObject1).CSJ)) {
            this.nJO.setTextColor(l.Rm(((xo)localObject1).CSJ));
          }
        }
        if (localObject2 != null)
        {
          this.nJP.setVisibility(0);
          this.nJQ.setText(((xo)localObject2).title);
          this.nJR.setText(((xo)localObject2).nrs);
          if (!TextUtils.isEmpty(((xo)localObject2).CSI)) {
            this.nJQ.setTextColor(l.Rm(((xo)localObject2).CSI));
          }
          if (!TextUtils.isEmpty(((xo)localObject2).CSJ)) {
            this.nJR.setTextColor(l.Rm(((xo)localObject2).CSJ));
          }
        }
        label234:
        if ((!this.nqp.bHA()) || (this.nqp.bHG())) {
          break label358;
        }
        ad.i("MicroMsg.CardWidgetInvoice", "is not invoice, don't updateCardSecondaryFieldListView");
        label265:
        if (!this.nqp.bHR()) {
          break label866;
        }
        this.nJT.setVisibility(8);
      }
    }
    for (;;)
    {
      if ((this.nqp.bHW().CPE != null) || (!this.nqp.bHR())) {
        break label943;
      }
      this.nJU.setVisibility(0);
      AppMethodBeat.o(113905);
      return;
      localObject1 = (xo)((LinkedList)localObject3).get(0);
      localObject2 = (xo)((LinkedList)localObject3).get(1);
      break;
      ad.i("MicroMsg.CardWidgetInvoice", "primary_fields is null");
      break label234;
      label358:
      if ((this.nqp.bHW().CPv != null) && (this.nqp.bHW().CPv.size() > 0))
      {
        if (this.nJS == null) {
          this.nJS = ((ViewStub)this.nJA.findViewById(2131297888)).inflate();
        }
        this.nJA.findViewById(2131297741).setVisibility(8);
        localObject1 = this.nJS;
        localObject3 = this.nqp;
        localObject2 = this.iAw;
        localObject3 = ((b)localObject3).bHW().CPv;
        if (((LinkedList)localObject3).size() == 1)
        {
          ((View)localObject1).findViewById(2131297892).setVisibility(0);
          localObject3 = (xo)((LinkedList)localObject3).get(0);
          ((TextView)((View)localObject1).findViewById(2131304466)).setText(((xo)localObject3).title);
          ((TextView)((View)localObject1).findViewById(2131304463)).setText(((xo)localObject3).nrs);
          ((View)localObject1).findViewById(2131297892).setOnClickListener((View.OnClickListener)localObject2);
          if (!TextUtils.isEmpty(((xo)localObject3).CSI)) {
            ((TextView)((View)localObject1).findViewById(2131304466)).setTextColor(l.Rm(((xo)localObject3).CSI));
          }
          if (!TextUtils.isEmpty(((xo)localObject3).CSJ)) {
            ((TextView)((View)localObject1).findViewById(2131304463)).setTextColor(l.Rm(((xo)localObject3).CSJ));
          }
          ((View)localObject1).findViewById(2131297893).setVisibility(8);
          break label265;
        }
        if (((LinkedList)localObject3).size() < 2) {
          break label265;
        }
        xo localxo = (xo)((LinkedList)localObject3).get(0);
        ((TextView)((View)localObject1).findViewById(2131304466)).setText(localxo.title);
        ((TextView)((View)localObject1).findViewById(2131304463)).setText(localxo.nrs);
        if (!TextUtils.isEmpty(localxo.CSI)) {
          ((TextView)((View)localObject1).findViewById(2131304466)).setTextColor(l.Rm(localxo.CSI));
        }
        if (!TextUtils.isEmpty(localxo.CSJ)) {
          ((TextView)((View)localObject1).findViewById(2131304463)).setTextColor(l.Rm(localxo.CSJ));
        }
        localObject3 = (xo)((LinkedList)localObject3).get(1);
        ((TextView)((View)localObject1).findViewById(2131304467)).setText(((xo)localObject3).title);
        ((TextView)((View)localObject1).findViewById(2131304464)).setText(((xo)localObject3).nrs);
        if (!TextUtils.isEmpty(((xo)localObject3).CSI)) {
          ((TextView)((View)localObject1).findViewById(2131304467)).setTextColor(l.Rm(((xo)localObject3).CSI));
        }
        if (!TextUtils.isEmpty(((xo)localObject3).CSJ)) {
          ((TextView)((View)localObject1).findViewById(2131304464)).setTextColor(l.Rm(((xo)localObject3).CSJ));
        }
        ((View)localObject1).findViewById(2131297892).setOnClickListener((View.OnClickListener)localObject2);
        ((View)localObject1).findViewById(2131297893).setOnClickListener((View.OnClickListener)localObject2);
        break label265;
      }
      if (this.nJS != null) {
        this.nJS.setVisibility(8);
      }
      this.nJA.findViewById(2131297741).setVisibility(8);
      break label265;
      label866:
      this.nJT.setVisibility(0);
      localObject1 = (TextView)this.nJT.findViewById(2131297901);
      if (!TextUtils.isEmpty(this.nqp.bHV().CSc)) {
        ((TextView)localObject1).setText(this.nqp.bHV().CSc);
      } else {
        n.h((TextView)localObject1, this.nqp.bHW().status);
      }
    }
    label943:
    this.nJU.setVisibility(8);
    AppMethodBeat.o(113905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.d
 * JD-Core Version:    0.7.0.1
 */