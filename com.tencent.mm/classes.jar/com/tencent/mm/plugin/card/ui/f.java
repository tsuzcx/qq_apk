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
import com.tencent.mm.protocal.protobuf.tk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class f
{
  private View iFK;
  private MMActivity oDq;
  private b oJE;
  private int oOf;
  private View oOg;
  private TextView oOh;
  private TextView oOi;
  private CdnImageView oOj;
  private ImageView[] oOk;
  private ImageView oOl;
  private tk oOm;
  
  public f(MMActivity paramMMActivity, View paramView, int paramInt, b paramb)
  {
    this(paramMMActivity, paramView, paramInt, paramb, null);
  }
  
  public f(MMActivity paramMMActivity, View paramView, int paramInt, b paramb, tk paramtk)
  {
    AppMethodBeat.i(113406);
    this.oOk = new ImageView[3];
    this.oDq = paramMMActivity;
    this.iFK = paramView;
    this.oOf = paramInt;
    this.oJE = paramb;
    this.oOm = paramtk;
    this.oOg = this.iFK.findViewById(2131297818);
    this.oOh = ((TextView)this.iFK.findViewById(2131297820));
    this.oOi = ((TextView)this.iFK.findViewById(2131297819));
    this.oOj = ((CdnImageView)this.iFK.findViewById(2131297821));
    this.oOk[0] = ((ImageView)this.iFK.findViewById(2131297815));
    this.oOk[1] = ((ImageView)this.iFK.findViewById(2131297816));
    this.oOk[2] = ((ImageView)this.iFK.findViewById(2131297817));
    this.oOl = ((ImageView)this.iFK.findViewById(2131297885));
    if (this.oOf == 1)
    {
      this.oOh.setText(this.oDq.getString(2131756928, new Object[] { Integer.valueOf(0) }));
      this.oOj.setImageResource(2131689869);
      AppMethodBeat.o(113406);
      return;
    }
    if (this.oOf == 2)
    {
      this.oOh.setText(2131756988);
      this.oOj.setImageResource(2131689868);
      AppMethodBeat.o(113406);
      return;
    }
    if (this.oOf == 3)
    {
      this.oOh.setText(2131757021);
      this.oOj.setImageResource(2131689870);
      AppMethodBeat.o(113406);
      return;
    }
    if (this.oOf == 4)
    {
      if (this.oOm == null)
      {
        ae.w("MicroMsg.CardHomePageItemController", "cell element is null");
        bYh();
      }
      this.iFK.findViewById(2131297814).setVisibility(8);
      this.oOh.setText(this.oOm.Gjr);
      this.oOj.setUseSdcardCache(true);
      this.oOj.setUrl(this.oOm.Gjs);
      if (!bu.isNullOrNil(this.oOm.Gjt))
      {
        this.oOi.setText(this.oOm.Gjt);
        this.oOi.setVisibility(0);
        AppMethodBeat.o(113406);
        return;
      }
      this.oOi.setVisibility(8);
    }
    AppMethodBeat.o(113406);
  }
  
  public final void bYh()
  {
    AppMethodBeat.i(113409);
    this.iFK.setVisibility(8);
    AppMethodBeat.o(113409);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113407);
    this.oOg.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(113407);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(113408);
    Object localObject;
    if (this.oOf == 2)
    {
      localObject = (l)am.bWh().getValue("key_share_card_layout_data");
      if (localObject == null)
      {
        ae.w("MicroMsg.CardHomePageItemController", "updateShareCardView data is null");
        AppMethodBeat.o(113408);
        return;
      }
      if (bu.isNullOrNil(((l)localObject).oIr)) {
        this.oOi.setVisibility(8);
      }
      while (bu.ht(((l)localObject).oIq))
      {
        i = 0;
        while (i < 3)
        {
          this.oOk[i].setVisibility(8);
          i += 1;
        }
        this.oOi.setVisibility(0);
        this.oOi.setText(((l)localObject).oIr);
      }
      int i = 0;
      if (i < 3)
      {
        if (i < ((l)localObject).oIq.size())
        {
          this.oOk[i].setVisibility(0);
          int j = this.oDq.getResources().getDimensionPixelSize(2131165483);
          n.a(this.oOk[i], (String)((l)localObject).oIq.get(i), j, 2131233400, false);
        }
        for (;;)
        {
          i += 1;
          break;
          this.oOk[i].setVisibility(8);
        }
      }
      if ((!bu.ht(((l)localObject).oIq)) && (((l)localObject).oIq.size() == 1) && (((l)localObject).dJl) && (!((l)localObject).dJm))
      {
        this.oOl.setVisibility(0);
        AppMethodBeat.o(113408);
        return;
      }
      this.oOl.setVisibility(8);
      AppMethodBeat.o(113408);
      return;
    }
    if (this.oOf == 3)
    {
      this.oOh.setText(2131757021);
      this.iFK.findViewById(2131297814).setVisibility(8);
      localObject = (String)am.bWh().getValue("key_card_entrance_tips");
      if (!bu.isNullOrNil((String)localObject))
      {
        this.oOi.setText((CharSequence)localObject);
        this.oOi.setVisibility(0);
        AppMethodBeat.o(113408);
        return;
      }
      this.oOi.setVisibility(8);
    }
    AppMethodBeat.o(113408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.f
 * JD-Core Version:    0.7.0.1
 */