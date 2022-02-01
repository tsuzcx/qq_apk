package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class d
  extends a
{
  private TextView tHA;
  private View tHB;
  private TextView tHC;
  private TextView tHD;
  private View tHE;
  private View tHF;
  private View tHG;
  private View tHy;
  private TextView tHz;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void cLo()
  {
    AppMethodBeat.i(113904);
    this.tHy = this.tHm.findViewById(a.d.tgq);
    this.tHz = ((TextView)this.tHm.findViewById(a.d.tgs));
    this.tHA = ((TextView)this.tHm.findViewById(a.d.tgr));
    this.tHB = this.tHm.findViewById(a.d.taM);
    this.tHC = ((TextView)this.tHm.findViewById(a.d.taO));
    this.tHD = ((TextView)this.tHm.findViewById(a.d.taN));
    this.tHF = this.tHm.findViewById(a.d.tdK);
    this.tHG = this.tHm.findViewById(a.d.tbo);
    AppMethodBeat.o(113904);
  }
  
  protected final void cLp()
  {
    AppMethodBeat.i(113905);
    Object localObject3;
    Object localObject2;
    Object localObject1;
    if ((this.tmU.cGs().SfP != null) && (this.tmU.cGs().SfP.size() > 0))
    {
      localObject3 = this.tmU.cGs().SfP;
      localObject2 = null;
      if (((LinkedList)localObject3).size() == 1)
      {
        localObject1 = (acg)((LinkedList)localObject3).get(0);
        if (localObject1 != null)
        {
          this.tHy.setVisibility(0);
          this.tHz.setText(((acg)localObject1).title);
          this.tHA.setText(((acg)localObject1).tnY);
          if (!TextUtils.isEmpty(((acg)localObject1).SgS)) {
            this.tHz.setTextColor(l.arR(((acg)localObject1).SgS));
          }
          if (!TextUtils.isEmpty(((acg)localObject1).SgT)) {
            this.tHA.setTextColor(l.arR(((acg)localObject1).SgT));
          }
        }
        if (localObject2 != null)
        {
          this.tHB.setVisibility(0);
          this.tHC.setText(((acg)localObject2).title);
          this.tHD.setText(((acg)localObject2).tnY);
          if (!TextUtils.isEmpty(((acg)localObject2).SgS)) {
            this.tHC.setTextColor(l.arR(((acg)localObject2).SgS));
          }
          if (!TextUtils.isEmpty(((acg)localObject2).SgT)) {
            this.tHD.setTextColor(l.arR(((acg)localObject2).SgT));
          }
        }
        label234:
        if ((!this.tmU.cFW()) || (this.tmU.cGc())) {
          break label358;
        }
        Log.i("MicroMsg.CardWidgetInvoice", "is not invoice, don't updateCardSecondaryFieldListView");
        label265:
        if (!this.tmU.cGn()) {
          break label886;
        }
        this.tHF.setVisibility(8);
      }
    }
    for (;;)
    {
      if ((this.tmU.cGt().SdO != null) || (!this.tmU.cGn())) {
        break label964;
      }
      this.tHG.setVisibility(0);
      AppMethodBeat.o(113905);
      return;
      localObject1 = (acg)((LinkedList)localObject3).get(0);
      localObject2 = (acg)((LinkedList)localObject3).get(1);
      break;
      Log.i("MicroMsg.CardWidgetInvoice", "primary_fields is null");
      break label234;
      label358:
      if ((this.tmU.cGt().SdF != null) && (this.tmU.cGt().SdF.size() > 0))
      {
        if (this.tHE == null) {
          this.tHE = ((ViewStub)this.tHm.findViewById(a.d.tdn)).inflate();
        }
        this.tHm.findViewById(a.d.tbo).setVisibility(8);
        localObject1 = this.tHE;
        localObject3 = this.tmU;
        localObject2 = this.nmC;
        localObject3 = ((b)localObject3).cGt().SdF;
        if (((LinkedList)localObject3).size() == 1)
        {
          ((View)localObject1).findViewById(a.d.tdr).setVisibility(0);
          localObject3 = (acg)((LinkedList)localObject3).get(0);
          ((TextView)((View)localObject1).findViewById(a.d.tgA)).setText(((acg)localObject3).title);
          ((TextView)((View)localObject1).findViewById(a.d.tgx)).setText(((acg)localObject3).tnY);
          ((View)localObject1).findViewById(a.d.tdr).setOnClickListener((View.OnClickListener)localObject2);
          if (!TextUtils.isEmpty(((acg)localObject3).SgS)) {
            ((TextView)((View)localObject1).findViewById(a.d.tgA)).setTextColor(l.arR(((acg)localObject3).SgS));
          }
          if (!TextUtils.isEmpty(((acg)localObject3).SgT)) {
            ((TextView)((View)localObject1).findViewById(a.d.tgx)).setTextColor(l.arR(((acg)localObject3).SgT));
          }
          ((View)localObject1).findViewById(a.d.tds).setVisibility(8);
          break label265;
        }
        if (((LinkedList)localObject3).size() < 2) {
          break label265;
        }
        acg localacg = (acg)((LinkedList)localObject3).get(0);
        ((TextView)((View)localObject1).findViewById(a.d.tgA)).setText(localacg.title);
        ((TextView)((View)localObject1).findViewById(a.d.tgx)).setText(localacg.tnY);
        if (!TextUtils.isEmpty(localacg.SgS)) {
          ((TextView)((View)localObject1).findViewById(a.d.tgA)).setTextColor(l.arR(localacg.SgS));
        }
        if (!TextUtils.isEmpty(localacg.SgT)) {
          ((TextView)((View)localObject1).findViewById(a.d.tgx)).setTextColor(l.arR(localacg.SgT));
        }
        localObject3 = (acg)((LinkedList)localObject3).get(1);
        ((TextView)((View)localObject1).findViewById(a.d.tgB)).setText(((acg)localObject3).title);
        ((TextView)((View)localObject1).findViewById(a.d.tgy)).setText(((acg)localObject3).tnY);
        if (!TextUtils.isEmpty(((acg)localObject3).SgS)) {
          ((TextView)((View)localObject1).findViewById(a.d.tgB)).setTextColor(l.arR(((acg)localObject3).SgS));
        }
        if (!TextUtils.isEmpty(((acg)localObject3).SgT)) {
          ((TextView)((View)localObject1).findViewById(a.d.tgy)).setTextColor(l.arR(((acg)localObject3).SgT));
        }
        ((View)localObject1).findViewById(a.d.tdr).setOnClickListener((View.OnClickListener)localObject2);
        ((View)localObject1).findViewById(a.d.tds).setOnClickListener((View.OnClickListener)localObject2);
        break label265;
      }
      if (this.tHE != null) {
        this.tHE.setVisibility(8);
      }
      this.tHm.findViewById(a.d.tbo).setVisibility(8);
      break label265;
      label886:
      this.tHF.setVisibility(0);
      localObject1 = (TextView)this.tHF.findViewById(a.d.tdz);
      if (!TextUtils.isEmpty(this.tmU.cGs().Sgm)) {
        ((TextView)localObject1).setText(this.tmU.cGs().Sgm);
      } else {
        n.h((TextView)localObject1, this.tmU.cGt().status);
      }
    }
    label964:
    this.tHG.setVisibility(8);
    AppMethodBeat.o(113905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.d
 * JD-Core Version:    0.7.0.1
 */