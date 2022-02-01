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
import com.tencent.mm.protocal.protobuf.re;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class f
{
  private View hIZ;
  private int nBj;
  private View nBk;
  private TextView nBl;
  private TextView nBm;
  private CdnImageView nBn;
  private ImageView[] nBo;
  private ImageView nBp;
  private re nBq;
  private MMActivity nqt;
  private b nwI;
  
  public f(MMActivity paramMMActivity, View paramView, int paramInt, b paramb)
  {
    this(paramMMActivity, paramView, paramInt, paramb, null);
  }
  
  public f(MMActivity paramMMActivity, View paramView, int paramInt, b paramb, re paramre)
  {
    AppMethodBeat.i(113406);
    this.nBo = new ImageView[3];
    this.nqt = paramMMActivity;
    this.hIZ = paramView;
    this.nBj = paramInt;
    this.nwI = paramb;
    this.nBq = paramre;
    this.nBk = this.hIZ.findViewById(2131297818);
    this.nBl = ((TextView)this.hIZ.findViewById(2131297820));
    this.nBm = ((TextView)this.hIZ.findViewById(2131297819));
    this.nBn = ((CdnImageView)this.hIZ.findViewById(2131297821));
    this.nBo[0] = ((ImageView)this.hIZ.findViewById(2131297815));
    this.nBo[1] = ((ImageView)this.hIZ.findViewById(2131297816));
    this.nBo[2] = ((ImageView)this.hIZ.findViewById(2131297817));
    this.nBp = ((ImageView)this.hIZ.findViewById(2131297885));
    if (this.nBj == 1)
    {
      this.nBl.setText(this.nqt.getString(2131756928, new Object[] { Integer.valueOf(0) }));
      this.nBn.setImageResource(2131689869);
      AppMethodBeat.o(113406);
      return;
    }
    if (this.nBj == 2)
    {
      this.nBl.setText(2131756988);
      this.nBn.setImageResource(2131689868);
      AppMethodBeat.o(113406);
      return;
    }
    if (this.nBj == 3)
    {
      this.nBl.setText(2131757021);
      this.nBn.setImageResource(2131689870);
      AppMethodBeat.o(113406);
      return;
    }
    if (this.nBj == 4)
    {
      if (this.nBq == null)
      {
        ad.w("MicroMsg.CardHomePageItemController", "cell element is null");
        bLa();
      }
      this.hIZ.findViewById(2131297814).setVisibility(8);
      this.nBl.setText(this.nBq.CQY);
      this.nBn.setUseSdcardCache(true);
      this.nBn.setUrl(this.nBq.CQZ);
      if (!bt.isNullOrNil(this.nBq.CRa))
      {
        this.nBm.setText(this.nBq.CRa);
        this.nBm.setVisibility(0);
        AppMethodBeat.o(113406);
        return;
      }
      this.nBm.setVisibility(8);
    }
    AppMethodBeat.o(113406);
  }
  
  public final void bLa()
  {
    AppMethodBeat.i(113409);
    this.hIZ.setVisibility(8);
    AppMethodBeat.o(113409);
  }
  
  public final void cE()
  {
    AppMethodBeat.i(113408);
    Object localObject;
    if (this.nBj == 2)
    {
      localObject = (l)am.bJa().getValue("key_share_card_layout_data");
      if (localObject == null)
      {
        ad.w("MicroMsg.CardHomePageItemController", "updateShareCardView data is null");
        AppMethodBeat.o(113408);
        return;
      }
      if (bt.isNullOrNil(((l)localObject).nvv)) {
        this.nBm.setVisibility(8);
      }
      while (bt.gL(((l)localObject).nvu))
      {
        i = 0;
        while (i < 3)
        {
          this.nBo[i].setVisibility(8);
          i += 1;
        }
        this.nBm.setVisibility(0);
        this.nBm.setText(((l)localObject).nvv);
      }
      int i = 0;
      if (i < 3)
      {
        if (i < ((l)localObject).nvu.size())
        {
          this.nBo[i].setVisibility(0);
          int j = this.nqt.getResources().getDimensionPixelSize(2131165483);
          n.a(this.nBo[i], (String)((l)localObject).nvu.get(i), j, 2131233400, false);
        }
        for (;;)
        {
          i += 1;
          break;
          this.nBo[i].setVisibility(8);
        }
      }
      if ((!bt.gL(((l)localObject).nvu)) && (((l)localObject).nvu.size() == 1) && (((l)localObject).dyl) && (!((l)localObject).dym))
      {
        this.nBp.setVisibility(0);
        AppMethodBeat.o(113408);
        return;
      }
      this.nBp.setVisibility(8);
      AppMethodBeat.o(113408);
      return;
    }
    if (this.nBj == 3)
    {
      this.nBl.setText(2131757021);
      this.hIZ.findViewById(2131297814).setVisibility(8);
      localObject = (String)am.bJa().getValue("key_card_entrance_tips");
      if (!bt.isNullOrNil((String)localObject))
      {
        this.nBm.setText((CharSequence)localObject);
        this.nBm.setVisibility(0);
        AppMethodBeat.o(113408);
        return;
      }
      this.nBm.setVisibility(8);
    }
    AppMethodBeat.o(113408);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113407);
    this.nBk.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(113407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.f
 * JD-Core Version:    0.7.0.1
 */