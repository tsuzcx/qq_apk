package com.tencent.mm.plugin.card.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.b.e;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ti;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class f
{
  private View iCR;
  private b oDc;
  private int oHD;
  private View oHE;
  private TextView oHF;
  private TextView oHG;
  private CdnImageView oHH;
  private ImageView[] oHI;
  private ImageView oHJ;
  private ti oHK;
  private MMActivity owO;
  
  public f(MMActivity paramMMActivity, View paramView, int paramInt, b paramb)
  {
    this(paramMMActivity, paramView, paramInt, paramb, null);
  }
  
  public f(MMActivity paramMMActivity, View paramView, int paramInt, b paramb, ti paramti)
  {
    AppMethodBeat.i(113406);
    this.oHI = new ImageView[3];
    this.owO = paramMMActivity;
    this.iCR = paramView;
    this.oHD = paramInt;
    this.oDc = paramb;
    this.oHK = paramti;
    this.oHE = this.iCR.findViewById(2131297818);
    this.oHF = ((TextView)this.iCR.findViewById(2131297820));
    this.oHG = ((TextView)this.iCR.findViewById(2131297819));
    this.oHH = ((CdnImageView)this.iCR.findViewById(2131297821));
    this.oHI[0] = ((ImageView)this.iCR.findViewById(2131297815));
    this.oHI[1] = ((ImageView)this.iCR.findViewById(2131297816));
    this.oHI[2] = ((ImageView)this.iCR.findViewById(2131297817));
    this.oHJ = ((ImageView)this.iCR.findViewById(2131297885));
    if (this.oHD == 1)
    {
      this.oHF.setText(this.owO.getString(2131756928, new Object[] { Integer.valueOf(0) }));
      this.oHH.setImageResource(2131689869);
      AppMethodBeat.o(113406);
      return;
    }
    if (this.oHD == 2)
    {
      this.oHF.setText(2131756988);
      this.oHH.setImageResource(2131689868);
      AppMethodBeat.o(113406);
      return;
    }
    if (this.oHD == 3)
    {
      this.oHF.setText(2131757021);
      this.oHH.setImageResource(2131689870);
      AppMethodBeat.o(113406);
      return;
    }
    if (this.oHD == 4)
    {
      if (this.oHK == null)
      {
        ad.w("MicroMsg.CardHomePageItemController", "cell element is null");
        bWS();
      }
      this.iCR.findViewById(2131297814).setVisibility(8);
      this.oHF.setText(this.oHK.FQS);
      this.oHH.setUseSdcardCache(true);
      this.oHH.setUrl(this.oHK.FQT);
      if (!bt.isNullOrNil(this.oHK.FQU))
      {
        this.oHG.setText(this.oHK.FQU);
        this.oHG.setVisibility(0);
        AppMethodBeat.o(113406);
        return;
      }
      this.oHG.setVisibility(8);
    }
    AppMethodBeat.o(113406);
  }
  
  public final void bWS()
  {
    AppMethodBeat.i(113409);
    this.iCR.setVisibility(8);
    AppMethodBeat.o(113409);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113407);
    this.oHE.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(113407);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(113408);
    Object localObject;
    if (this.oHD == 2)
    {
      localObject = (l)am.bUS().getValue("key_share_card_layout_data");
      if (localObject == null)
      {
        ad.w("MicroMsg.CardHomePageItemController", "updateShareCardView data is null");
        AppMethodBeat.o(113408);
        return;
      }
      if (bt.isNullOrNil(((l)localObject).oBP)) {
        this.oHG.setVisibility(8);
      }
      while (bt.hj(((l)localObject).oBO))
      {
        i = 0;
        while (i < 3)
        {
          this.oHI[i].setVisibility(8);
          i += 1;
        }
        this.oHG.setVisibility(0);
        this.oHG.setText(((l)localObject).oBP);
      }
      int i = 0;
      if (i < 3)
      {
        if (i < ((l)localObject).oBO.size())
        {
          this.oHI[i].setVisibility(0);
          int j = this.owO.getResources().getDimensionPixelSize(2131165483);
          n.a(this.oHI[i], (String)((l)localObject).oBO.get(i), j, 2131233400, false);
        }
        for (;;)
        {
          i += 1;
          break;
          this.oHI[i].setVisibility(8);
        }
      }
      if ((!bt.hj(((l)localObject).oBO)) && (((l)localObject).oBO.size() == 1) && (((l)localObject).dIh) && (!((l)localObject).dIi))
      {
        this.oHJ.setVisibility(0);
        AppMethodBeat.o(113408);
        return;
      }
      this.oHJ.setVisibility(8);
      AppMethodBeat.o(113408);
      return;
    }
    if (this.oHD == 3)
    {
      this.oHF.setText(2131757021);
      this.iCR.findViewById(2131297814).setVisibility(8);
      localObject = (String)am.bUS().getValue("key_card_entrance_tips");
      if (!bt.isNullOrNil((String)localObject))
      {
        this.oHG.setText((CharSequence)localObject);
        this.oHG.setVisibility(0);
        AppMethodBeat.o(113408);
        return;
      }
      this.oHG.setVisibility(8);
    }
    AppMethodBeat.o(113408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.f
 * JD-Core Version:    0.7.0.1
 */