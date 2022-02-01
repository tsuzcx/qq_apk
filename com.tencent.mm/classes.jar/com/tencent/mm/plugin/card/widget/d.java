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
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class d
  extends a
{
  private View oWJ;
  private TextView oWK;
  private TextView oWL;
  private View oWM;
  private TextView oWN;
  private TextView oWO;
  private View oWP;
  private View oWQ;
  private View oWR;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void bZX()
  {
    AppMethodBeat.i(113904);
    this.oWJ = this.oWx.findViewById(2131303161);
    this.oWK = ((TextView)this.oWx.findViewById(2131303163));
    this.oWL = ((TextView)this.oWx.findViewById(2131303162));
    this.oWM = this.oWx.findViewById(2131297221);
    this.oWN = ((TextView)this.oWx.findViewById(2131297223));
    this.oWO = ((TextView)this.oWx.findViewById(2131297222));
    this.oWQ = this.oWx.findViewById(2131297923);
    this.oWR = this.oWx.findViewById(2131297741);
    AppMethodBeat.o(113904);
  }
  
  protected final void bZY()
  {
    AppMethodBeat.i(113905);
    Object localObject3;
    Object localObject2;
    Object localObject1;
    if ((this.oDm.bVc().GjY != null) && (this.oDm.bVc().GjY.size() > 0))
    {
      localObject3 = this.oDm.bVc().GjY;
      localObject2 = null;
      if (((LinkedList)localObject3).size() == 1)
      {
        localObject1 = (aai)((LinkedList)localObject3).get(0);
        if (localObject1 != null)
        {
          this.oWJ.setVisibility(0);
          this.oWK.setText(((aai)localObject1).title);
          this.oWL.setText(((aai)localObject1).oEp);
          if (!TextUtils.isEmpty(((aai)localObject1).Gla)) {
            this.oWK.setTextColor(l.ZY(((aai)localObject1).Gla));
          }
          if (!TextUtils.isEmpty(((aai)localObject1).Glb)) {
            this.oWL.setTextColor(l.ZY(((aai)localObject1).Glb));
          }
        }
        if (localObject2 != null)
        {
          this.oWM.setVisibility(0);
          this.oWN.setText(((aai)localObject2).title);
          this.oWO.setText(((aai)localObject2).oEp);
          if (!TextUtils.isEmpty(((aai)localObject2).Gla)) {
            this.oWN.setTextColor(l.ZY(((aai)localObject2).Gla));
          }
          if (!TextUtils.isEmpty(((aai)localObject2).Glb)) {
            this.oWO.setTextColor(l.ZY(((aai)localObject2).Glb));
          }
        }
        label234:
        if ((!this.oDm.bUH()) || (this.oDm.bUN())) {
          break label358;
        }
        ae.i("MicroMsg.CardWidgetInvoice", "is not invoice, don't updateCardSecondaryFieldListView");
        label265:
        if (!this.oDm.bUY()) {
          break label866;
        }
        this.oWQ.setVisibility(8);
      }
    }
    for (;;)
    {
      if ((this.oDm.bVd().GhY != null) || (!this.oDm.bUY())) {
        break label943;
      }
      this.oWR.setVisibility(0);
      AppMethodBeat.o(113905);
      return;
      localObject1 = (aai)((LinkedList)localObject3).get(0);
      localObject2 = (aai)((LinkedList)localObject3).get(1);
      break;
      ae.i("MicroMsg.CardWidgetInvoice", "primary_fields is null");
      break label234;
      label358:
      if ((this.oDm.bVd().GhP != null) && (this.oDm.bVd().GhP.size() > 0))
      {
        if (this.oWP == null) {
          this.oWP = ((ViewStub)this.oWx.findViewById(2131297888)).inflate();
        }
        this.oWx.findViewById(2131297741).setVisibility(8);
        localObject1 = this.oWP;
        localObject3 = this.oDm;
        localObject2 = this.jwB;
        localObject3 = ((b)localObject3).bVd().GhP;
        if (((LinkedList)localObject3).size() == 1)
        {
          ((View)localObject1).findViewById(2131297892).setVisibility(0);
          localObject3 = (aai)((LinkedList)localObject3).get(0);
          ((TextView)((View)localObject1).findViewById(2131304466)).setText(((aai)localObject3).title);
          ((TextView)((View)localObject1).findViewById(2131304463)).setText(((aai)localObject3).oEp);
          ((View)localObject1).findViewById(2131297892).setOnClickListener((View.OnClickListener)localObject2);
          if (!TextUtils.isEmpty(((aai)localObject3).Gla)) {
            ((TextView)((View)localObject1).findViewById(2131304466)).setTextColor(l.ZY(((aai)localObject3).Gla));
          }
          if (!TextUtils.isEmpty(((aai)localObject3).Glb)) {
            ((TextView)((View)localObject1).findViewById(2131304463)).setTextColor(l.ZY(((aai)localObject3).Glb));
          }
          ((View)localObject1).findViewById(2131297893).setVisibility(8);
          break label265;
        }
        if (((LinkedList)localObject3).size() < 2) {
          break label265;
        }
        aai localaai = (aai)((LinkedList)localObject3).get(0);
        ((TextView)((View)localObject1).findViewById(2131304466)).setText(localaai.title);
        ((TextView)((View)localObject1).findViewById(2131304463)).setText(localaai.oEp);
        if (!TextUtils.isEmpty(localaai.Gla)) {
          ((TextView)((View)localObject1).findViewById(2131304466)).setTextColor(l.ZY(localaai.Gla));
        }
        if (!TextUtils.isEmpty(localaai.Glb)) {
          ((TextView)((View)localObject1).findViewById(2131304463)).setTextColor(l.ZY(localaai.Glb));
        }
        localObject3 = (aai)((LinkedList)localObject3).get(1);
        ((TextView)((View)localObject1).findViewById(2131304467)).setText(((aai)localObject3).title);
        ((TextView)((View)localObject1).findViewById(2131304464)).setText(((aai)localObject3).oEp);
        if (!TextUtils.isEmpty(((aai)localObject3).Gla)) {
          ((TextView)((View)localObject1).findViewById(2131304467)).setTextColor(l.ZY(((aai)localObject3).Gla));
        }
        if (!TextUtils.isEmpty(((aai)localObject3).Glb)) {
          ((TextView)((View)localObject1).findViewById(2131304464)).setTextColor(l.ZY(((aai)localObject3).Glb));
        }
        ((View)localObject1).findViewById(2131297892).setOnClickListener((View.OnClickListener)localObject2);
        ((View)localObject1).findViewById(2131297893).setOnClickListener((View.OnClickListener)localObject2);
        break label265;
      }
      if (this.oWP != null) {
        this.oWP.setVisibility(8);
      }
      this.oWx.findViewById(2131297741).setVisibility(8);
      break label265;
      label866:
      this.oWQ.setVisibility(0);
      localObject1 = (TextView)this.oWQ.findViewById(2131297901);
      if (!TextUtils.isEmpty(this.oDm.bVc().Gkv)) {
        ((TextView)localObject1).setText(this.oDm.bVc().Gkv);
      } else {
        n.h((TextView)localObject1, this.oDm.bVd().status);
      }
    }
    label943:
    this.oWR.setVisibility(8);
    AppMethodBeat.o(113905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.d
 * JD-Core Version:    0.7.0.1
 */