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
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class d
  extends a
{
  private View omM;
  private TextView omN;
  private TextView omO;
  private View omP;
  private TextView omQ;
  private TextView omR;
  private View omS;
  private View omT;
  private View omU;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void bUd()
  {
    AppMethodBeat.i(113904);
    this.omM = this.omA.findViewById(2131303161);
    this.omN = ((TextView)this.omA.findViewById(2131303163));
    this.omO = ((TextView)this.omA.findViewById(2131303162));
    this.omP = this.omA.findViewById(2131297221);
    this.omQ = ((TextView)this.omA.findViewById(2131297223));
    this.omR = ((TextView)this.omA.findViewById(2131297222));
    this.omT = this.omA.findViewById(2131297923);
    this.omU = this.omA.findViewById(2131297741);
    AppMethodBeat.o(113904);
  }
  
  protected final void bUe()
  {
    AppMethodBeat.i(113905);
    Object localObject3;
    Object localObject2;
    Object localObject1;
    if ((this.nTp.bPi().Ekq != null) && (this.nTp.bPi().Ekq.size() > 0))
    {
      localObject3 = this.nTp.bPi().Ekq;
      localObject2 = null;
      if (((LinkedList)localObject3).size() == 1)
      {
        localObject1 = (yg)((LinkedList)localObject3).get(0);
        if (localObject1 != null)
        {
          this.omM.setVisibility(0);
          this.omN.setText(((yg)localObject1).title);
          this.omO.setText(((yg)localObject1).nUs);
          if (!TextUtils.isEmpty(((yg)localObject1).Elt)) {
            this.omN.setTextColor(l.Vy(((yg)localObject1).Elt));
          }
          if (!TextUtils.isEmpty(((yg)localObject1).Elu)) {
            this.omO.setTextColor(l.Vy(((yg)localObject1).Elu));
          }
        }
        if (localObject2 != null)
        {
          this.omP.setVisibility(0);
          this.omQ.setText(((yg)localObject2).title);
          this.omR.setText(((yg)localObject2).nUs);
          if (!TextUtils.isEmpty(((yg)localObject2).Elt)) {
            this.omQ.setTextColor(l.Vy(((yg)localObject2).Elt));
          }
          if (!TextUtils.isEmpty(((yg)localObject2).Elu)) {
            this.omR.setTextColor(l.Vy(((yg)localObject2).Elu));
          }
        }
        label234:
        if ((!this.nTp.bON()) || (this.nTp.bOT())) {
          break label358;
        }
        ac.i("MicroMsg.CardWidgetInvoice", "is not invoice, don't updateCardSecondaryFieldListView");
        label265:
        if (!this.nTp.bPe()) {
          break label866;
        }
        this.omT.setVisibility(8);
      }
    }
    for (;;)
    {
      if ((this.nTp.bPj().Eip != null) || (!this.nTp.bPe())) {
        break label943;
      }
      this.omU.setVisibility(0);
      AppMethodBeat.o(113905);
      return;
      localObject1 = (yg)((LinkedList)localObject3).get(0);
      localObject2 = (yg)((LinkedList)localObject3).get(1);
      break;
      ac.i("MicroMsg.CardWidgetInvoice", "primary_fields is null");
      break label234;
      label358:
      if ((this.nTp.bPj().Eig != null) && (this.nTp.bPj().Eig.size() > 0))
      {
        if (this.omS == null) {
          this.omS = ((ViewStub)this.omA.findViewById(2131297888)).inflate();
        }
        this.omA.findViewById(2131297741).setVisibility(8);
        localObject1 = this.omS;
        localObject3 = this.nTp;
        localObject2 = this.jax;
        localObject3 = ((b)localObject3).bPj().Eig;
        if (((LinkedList)localObject3).size() == 1)
        {
          ((View)localObject1).findViewById(2131297892).setVisibility(0);
          localObject3 = (yg)((LinkedList)localObject3).get(0);
          ((TextView)((View)localObject1).findViewById(2131304466)).setText(((yg)localObject3).title);
          ((TextView)((View)localObject1).findViewById(2131304463)).setText(((yg)localObject3).nUs);
          ((View)localObject1).findViewById(2131297892).setOnClickListener((View.OnClickListener)localObject2);
          if (!TextUtils.isEmpty(((yg)localObject3).Elt)) {
            ((TextView)((View)localObject1).findViewById(2131304466)).setTextColor(l.Vy(((yg)localObject3).Elt));
          }
          if (!TextUtils.isEmpty(((yg)localObject3).Elu)) {
            ((TextView)((View)localObject1).findViewById(2131304463)).setTextColor(l.Vy(((yg)localObject3).Elu));
          }
          ((View)localObject1).findViewById(2131297893).setVisibility(8);
          break label265;
        }
        if (((LinkedList)localObject3).size() < 2) {
          break label265;
        }
        yg localyg = (yg)((LinkedList)localObject3).get(0);
        ((TextView)((View)localObject1).findViewById(2131304466)).setText(localyg.title);
        ((TextView)((View)localObject1).findViewById(2131304463)).setText(localyg.nUs);
        if (!TextUtils.isEmpty(localyg.Elt)) {
          ((TextView)((View)localObject1).findViewById(2131304466)).setTextColor(l.Vy(localyg.Elt));
        }
        if (!TextUtils.isEmpty(localyg.Elu)) {
          ((TextView)((View)localObject1).findViewById(2131304463)).setTextColor(l.Vy(localyg.Elu));
        }
        localObject3 = (yg)((LinkedList)localObject3).get(1);
        ((TextView)((View)localObject1).findViewById(2131304467)).setText(((yg)localObject3).title);
        ((TextView)((View)localObject1).findViewById(2131304464)).setText(((yg)localObject3).nUs);
        if (!TextUtils.isEmpty(((yg)localObject3).Elt)) {
          ((TextView)((View)localObject1).findViewById(2131304467)).setTextColor(l.Vy(((yg)localObject3).Elt));
        }
        if (!TextUtils.isEmpty(((yg)localObject3).Elu)) {
          ((TextView)((View)localObject1).findViewById(2131304464)).setTextColor(l.Vy(((yg)localObject3).Elu));
        }
        ((View)localObject1).findViewById(2131297892).setOnClickListener((View.OnClickListener)localObject2);
        ((View)localObject1).findViewById(2131297893).setOnClickListener((View.OnClickListener)localObject2);
        break label265;
      }
      if (this.omS != null) {
        this.omS.setVisibility(8);
      }
      this.omA.findViewById(2131297741).setVisibility(8);
      break label265;
      label866:
      this.omT.setVisibility(0);
      localObject1 = (TextView)this.omT.findViewById(2131297901);
      if (!TextUtils.isEmpty(this.nTp.bPi().EkN)) {
        ((TextView)localObject1).setText(this.nTp.bPi().EkN);
      } else {
        n.h((TextView)localObject1, this.nTp.bPj().status);
      }
    }
    label943:
    this.omU.setVisibility(8);
    AppMethodBeat.o(113905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.d
 * JD-Core Version:    0.7.0.1
 */