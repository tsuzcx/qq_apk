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
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class d
  extends a
{
  private View oQh;
  private TextView oQi;
  private TextView oQj;
  private View oQk;
  private TextView oQl;
  private TextView oQm;
  private View oQn;
  private View oQo;
  private View oQp;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void bYI()
  {
    AppMethodBeat.i(113904);
    this.oQh = this.oPV.findViewById(2131303161);
    this.oQi = ((TextView)this.oPV.findViewById(2131303163));
    this.oQj = ((TextView)this.oPV.findViewById(2131303162));
    this.oQk = this.oPV.findViewById(2131297221);
    this.oQl = ((TextView)this.oPV.findViewById(2131297223));
    this.oQm = ((TextView)this.oPV.findViewById(2131297222));
    this.oQo = this.oPV.findViewById(2131297923);
    this.oQp = this.oPV.findViewById(2131297741);
    AppMethodBeat.o(113904);
  }
  
  protected final void bYJ()
  {
    AppMethodBeat.i(113905);
    Object localObject3;
    Object localObject2;
    Object localObject1;
    if ((this.owK.bTN().FRz != null) && (this.owK.bTN().FRz.size() > 0))
    {
      localObject3 = this.owK.bTN().FRz;
      localObject2 = null;
      if (((LinkedList)localObject3).size() == 1)
      {
        localObject1 = (aaf)((LinkedList)localObject3).get(0);
        if (localObject1 != null)
        {
          this.oQh.setVisibility(0);
          this.oQi.setText(((aaf)localObject1).title);
          this.oQj.setText(((aaf)localObject1).oxN);
          if (!TextUtils.isEmpty(((aaf)localObject1).FSB)) {
            this.oQi.setTextColor(l.Zh(((aaf)localObject1).FSB));
          }
          if (!TextUtils.isEmpty(((aaf)localObject1).FSC)) {
            this.oQj.setTextColor(l.Zh(((aaf)localObject1).FSC));
          }
        }
        if (localObject2 != null)
        {
          this.oQk.setVisibility(0);
          this.oQl.setText(((aaf)localObject2).title);
          this.oQm.setText(((aaf)localObject2).oxN);
          if (!TextUtils.isEmpty(((aaf)localObject2).FSB)) {
            this.oQl.setTextColor(l.Zh(((aaf)localObject2).FSB));
          }
          if (!TextUtils.isEmpty(((aaf)localObject2).FSC)) {
            this.oQm.setTextColor(l.Zh(((aaf)localObject2).FSC));
          }
        }
        label234:
        if ((!this.owK.bTs()) || (this.owK.bTy())) {
          break label358;
        }
        ad.i("MicroMsg.CardWidgetInvoice", "is not invoice, don't updateCardSecondaryFieldListView");
        label265:
        if (!this.owK.bTJ()) {
          break label866;
        }
        this.oQo.setVisibility(8);
      }
    }
    for (;;)
    {
      if ((this.owK.bTO().FPz != null) || (!this.owK.bTJ())) {
        break label943;
      }
      this.oQp.setVisibility(0);
      AppMethodBeat.o(113905);
      return;
      localObject1 = (aaf)((LinkedList)localObject3).get(0);
      localObject2 = (aaf)((LinkedList)localObject3).get(1);
      break;
      ad.i("MicroMsg.CardWidgetInvoice", "primary_fields is null");
      break label234;
      label358:
      if ((this.owK.bTO().FPq != null) && (this.owK.bTO().FPq.size() > 0))
      {
        if (this.oQn == null) {
          this.oQn = ((ViewStub)this.oPV.findViewById(2131297888)).inflate();
        }
        this.oPV.findViewById(2131297741).setVisibility(8);
        localObject1 = this.oQn;
        localObject3 = this.owK;
        localObject2 = this.jtG;
        localObject3 = ((b)localObject3).bTO().FPq;
        if (((LinkedList)localObject3).size() == 1)
        {
          ((View)localObject1).findViewById(2131297892).setVisibility(0);
          localObject3 = (aaf)((LinkedList)localObject3).get(0);
          ((TextView)((View)localObject1).findViewById(2131304466)).setText(((aaf)localObject3).title);
          ((TextView)((View)localObject1).findViewById(2131304463)).setText(((aaf)localObject3).oxN);
          ((View)localObject1).findViewById(2131297892).setOnClickListener((View.OnClickListener)localObject2);
          if (!TextUtils.isEmpty(((aaf)localObject3).FSB)) {
            ((TextView)((View)localObject1).findViewById(2131304466)).setTextColor(l.Zh(((aaf)localObject3).FSB));
          }
          if (!TextUtils.isEmpty(((aaf)localObject3).FSC)) {
            ((TextView)((View)localObject1).findViewById(2131304463)).setTextColor(l.Zh(((aaf)localObject3).FSC));
          }
          ((View)localObject1).findViewById(2131297893).setVisibility(8);
          break label265;
        }
        if (((LinkedList)localObject3).size() < 2) {
          break label265;
        }
        aaf localaaf = (aaf)((LinkedList)localObject3).get(0);
        ((TextView)((View)localObject1).findViewById(2131304466)).setText(localaaf.title);
        ((TextView)((View)localObject1).findViewById(2131304463)).setText(localaaf.oxN);
        if (!TextUtils.isEmpty(localaaf.FSB)) {
          ((TextView)((View)localObject1).findViewById(2131304466)).setTextColor(l.Zh(localaaf.FSB));
        }
        if (!TextUtils.isEmpty(localaaf.FSC)) {
          ((TextView)((View)localObject1).findViewById(2131304463)).setTextColor(l.Zh(localaaf.FSC));
        }
        localObject3 = (aaf)((LinkedList)localObject3).get(1);
        ((TextView)((View)localObject1).findViewById(2131304467)).setText(((aaf)localObject3).title);
        ((TextView)((View)localObject1).findViewById(2131304464)).setText(((aaf)localObject3).oxN);
        if (!TextUtils.isEmpty(((aaf)localObject3).FSB)) {
          ((TextView)((View)localObject1).findViewById(2131304467)).setTextColor(l.Zh(((aaf)localObject3).FSB));
        }
        if (!TextUtils.isEmpty(((aaf)localObject3).FSC)) {
          ((TextView)((View)localObject1).findViewById(2131304464)).setTextColor(l.Zh(((aaf)localObject3).FSC));
        }
        ((View)localObject1).findViewById(2131297892).setOnClickListener((View.OnClickListener)localObject2);
        ((View)localObject1).findViewById(2131297893).setOnClickListener((View.OnClickListener)localObject2);
        break label265;
      }
      if (this.oQn != null) {
        this.oQn.setVisibility(8);
      }
      this.oPV.findViewById(2131297741).setVisibility(8);
      break label265;
      label866:
      this.oQo.setVisibility(0);
      localObject1 = (TextView)this.oQo.findViewById(2131297901);
      if (!TextUtils.isEmpty(this.owK.bTN().FRW)) {
        ((TextView)localObject1).setText(this.owK.bTN().FRW);
      } else {
        n.h((TextView)localObject1, this.owK.bTO().status);
      }
    }
    label943:
    this.oQp.setVisibility(8);
    AppMethodBeat.o(113905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.d
 * JD-Core Version:    0.7.0.1
 */