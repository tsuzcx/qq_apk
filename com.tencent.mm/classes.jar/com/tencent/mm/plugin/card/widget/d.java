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
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class d
  extends a
{
  private View qlD;
  private TextView qlE;
  private TextView qlF;
  private View qlG;
  private TextView qlH;
  private TextView qlI;
  private View qlJ;
  private View qlK;
  private View qlL;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void cxM()
  {
    AppMethodBeat.i(113904);
    this.qlD = this.qlr.findViewById(2131305818);
    this.qlE = ((TextView)this.qlr.findViewById(2131305820));
    this.qlF = ((TextView)this.qlr.findViewById(2131305819));
    this.qlG = this.qlr.findViewById(2131297376);
    this.qlH = ((TextView)this.qlr.findViewById(2131297378));
    this.qlI = ((TextView)this.qlr.findViewById(2131297377));
    this.qlK = this.qlr.findViewById(2131298241);
    this.qlL = this.qlr.findViewById(2131298053);
    AppMethodBeat.o(113904);
  }
  
  protected final void cxN()
  {
    AppMethodBeat.i(113905);
    Object localObject3;
    Object localObject2;
    Object localObject1;
    if ((this.pQV.csQ().LeC != null) && (this.pQV.csQ().LeC.size() > 0))
    {
      localObject3 = this.pQV.csQ().LeC;
      localObject2 = null;
      if (((LinkedList)localObject3).size() == 1)
      {
        localObject1 = (abz)((LinkedList)localObject3).get(0);
        if (localObject1 != null)
        {
          this.qlD.setVisibility(0);
          this.qlE.setText(((abz)localObject1).title);
          this.qlF.setText(((abz)localObject1).pRY);
          if (!TextUtils.isEmpty(((abz)localObject1).LfE)) {
            this.qlE.setTextColor(l.ake(((abz)localObject1).LfE));
          }
          if (!TextUtils.isEmpty(((abz)localObject1).LfF)) {
            this.qlF.setTextColor(l.ake(((abz)localObject1).LfF));
          }
        }
        if (localObject2 != null)
        {
          this.qlG.setVisibility(0);
          this.qlH.setText(((abz)localObject2).title);
          this.qlI.setText(((abz)localObject2).pRY);
          if (!TextUtils.isEmpty(((abz)localObject2).LfE)) {
            this.qlH.setTextColor(l.ake(((abz)localObject2).LfE));
          }
          if (!TextUtils.isEmpty(((abz)localObject2).LfF)) {
            this.qlI.setTextColor(l.ake(((abz)localObject2).LfF));
          }
        }
        label234:
        if ((!this.pQV.csv()) || (this.pQV.csB())) {
          break label358;
        }
        Log.i("MicroMsg.CardWidgetInvoice", "is not invoice, don't updateCardSecondaryFieldListView");
        label265:
        if (!this.pQV.csM()) {
          break label866;
        }
        this.qlK.setVisibility(8);
      }
    }
    for (;;)
    {
      if ((this.pQV.csR().LcB != null) || (!this.pQV.csM())) {
        break label943;
      }
      this.qlL.setVisibility(0);
      AppMethodBeat.o(113905);
      return;
      localObject1 = (abz)((LinkedList)localObject3).get(0);
      localObject2 = (abz)((LinkedList)localObject3).get(1);
      break;
      Log.i("MicroMsg.CardWidgetInvoice", "primary_fields is null");
      break label234;
      label358:
      if ((this.pQV.csR().Lcs != null) && (this.pQV.csR().Lcs.size() > 0))
      {
        if (this.qlJ == null) {
          this.qlJ = ((ViewStub)this.qlr.findViewById(2131298206)).inflate();
        }
        this.qlr.findViewById(2131298053).setVisibility(8);
        localObject1 = this.qlJ;
        localObject3 = this.pQV;
        localObject2 = this.kuO;
        localObject3 = ((b)localObject3).csR().Lcs;
        if (((LinkedList)localObject3).size() == 1)
        {
          ((View)localObject1).findViewById(2131298210).setVisibility(0);
          localObject3 = (abz)((LinkedList)localObject3).get(0);
          ((TextView)((View)localObject1).findViewById(2131307444)).setText(((abz)localObject3).title);
          ((TextView)((View)localObject1).findViewById(2131307441)).setText(((abz)localObject3).pRY);
          ((View)localObject1).findViewById(2131298210).setOnClickListener((View.OnClickListener)localObject2);
          if (!TextUtils.isEmpty(((abz)localObject3).LfE)) {
            ((TextView)((View)localObject1).findViewById(2131307444)).setTextColor(l.ake(((abz)localObject3).LfE));
          }
          if (!TextUtils.isEmpty(((abz)localObject3).LfF)) {
            ((TextView)((View)localObject1).findViewById(2131307441)).setTextColor(l.ake(((abz)localObject3).LfF));
          }
          ((View)localObject1).findViewById(2131298211).setVisibility(8);
          break label265;
        }
        if (((LinkedList)localObject3).size() < 2) {
          break label265;
        }
        abz localabz = (abz)((LinkedList)localObject3).get(0);
        ((TextView)((View)localObject1).findViewById(2131307444)).setText(localabz.title);
        ((TextView)((View)localObject1).findViewById(2131307441)).setText(localabz.pRY);
        if (!TextUtils.isEmpty(localabz.LfE)) {
          ((TextView)((View)localObject1).findViewById(2131307444)).setTextColor(l.ake(localabz.LfE));
        }
        if (!TextUtils.isEmpty(localabz.LfF)) {
          ((TextView)((View)localObject1).findViewById(2131307441)).setTextColor(l.ake(localabz.LfF));
        }
        localObject3 = (abz)((LinkedList)localObject3).get(1);
        ((TextView)((View)localObject1).findViewById(2131307445)).setText(((abz)localObject3).title);
        ((TextView)((View)localObject1).findViewById(2131307442)).setText(((abz)localObject3).pRY);
        if (!TextUtils.isEmpty(((abz)localObject3).LfE)) {
          ((TextView)((View)localObject1).findViewById(2131307445)).setTextColor(l.ake(((abz)localObject3).LfE));
        }
        if (!TextUtils.isEmpty(((abz)localObject3).LfF)) {
          ((TextView)((View)localObject1).findViewById(2131307442)).setTextColor(l.ake(((abz)localObject3).LfF));
        }
        ((View)localObject1).findViewById(2131298210).setOnClickListener((View.OnClickListener)localObject2);
        ((View)localObject1).findViewById(2131298211).setOnClickListener((View.OnClickListener)localObject2);
        break label265;
      }
      if (this.qlJ != null) {
        this.qlJ.setVisibility(8);
      }
      this.qlr.findViewById(2131298053).setVisibility(8);
      break label265;
      label866:
      this.qlK.setVisibility(0);
      localObject1 = (TextView)this.qlK.findViewById(2131298219);
      if (!TextUtils.isEmpty(this.pQV.csQ().LeY)) {
        ((TextView)localObject1).setText(this.pQV.csQ().LeY);
      } else {
        n.h((TextView)localObject1, this.pQV.csR().status);
      }
    }
    label943:
    this.qlL.setVisibility(8);
    AppMethodBeat.o(113905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.d
 * JD-Core Version:    0.7.0.1
 */