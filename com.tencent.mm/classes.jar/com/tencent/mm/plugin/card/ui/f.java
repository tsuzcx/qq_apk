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
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class f
{
  private View ijA;
  private MMActivity nTt;
  private b nZI;
  private int oej;
  private View oek;
  private TextView oel;
  private TextView oem;
  private CdnImageView oen;
  private ImageView[] oeo;
  private ImageView oep;
  private ro oeq;
  
  public f(MMActivity paramMMActivity, View paramView, int paramInt, b paramb)
  {
    this(paramMMActivity, paramView, paramInt, paramb, null);
  }
  
  public f(MMActivity paramMMActivity, View paramView, int paramInt, b paramb, ro paramro)
  {
    AppMethodBeat.i(113406);
    this.oeo = new ImageView[3];
    this.nTt = paramMMActivity;
    this.ijA = paramView;
    this.oej = paramInt;
    this.nZI = paramb;
    this.oeq = paramro;
    this.oek = this.ijA.findViewById(2131297818);
    this.oel = ((TextView)this.ijA.findViewById(2131297820));
    this.oem = ((TextView)this.ijA.findViewById(2131297819));
    this.oen = ((CdnImageView)this.ijA.findViewById(2131297821));
    this.oeo[0] = ((ImageView)this.ijA.findViewById(2131297815));
    this.oeo[1] = ((ImageView)this.ijA.findViewById(2131297816));
    this.oeo[2] = ((ImageView)this.ijA.findViewById(2131297817));
    this.oep = ((ImageView)this.ijA.findViewById(2131297885));
    if (this.oej == 1)
    {
      this.oel.setText(this.nTt.getString(2131756928, new Object[] { Integer.valueOf(0) }));
      this.oen.setImageResource(2131689869);
      AppMethodBeat.o(113406);
      return;
    }
    if (this.oej == 2)
    {
      this.oel.setText(2131756988);
      this.oen.setImageResource(2131689868);
      AppMethodBeat.o(113406);
      return;
    }
    if (this.oej == 3)
    {
      this.oel.setText(2131757021);
      this.oen.setImageResource(2131689870);
      AppMethodBeat.o(113406);
      return;
    }
    if (this.oej == 4)
    {
      if (this.oeq == null)
      {
        ac.w("MicroMsg.CardHomePageItemController", "cell element is null");
        bSn();
      }
      this.ijA.findViewById(2131297814).setVisibility(8);
      this.oel.setText(this.oeq.EjJ);
      this.oen.setUseSdcardCache(true);
      this.oen.setUrl(this.oeq.EjK);
      if (!bs.isNullOrNil(this.oeq.EjL))
      {
        this.oem.setText(this.oeq.EjL);
        this.oem.setVisibility(0);
        AppMethodBeat.o(113406);
        return;
      }
      this.oem.setVisibility(8);
    }
    AppMethodBeat.o(113406);
  }
  
  public final void bSn()
  {
    AppMethodBeat.i(113409);
    this.ijA.setVisibility(8);
    AppMethodBeat.o(113409);
  }
  
  public final void cL()
  {
    AppMethodBeat.i(113408);
    Object localObject;
    if (this.oej == 2)
    {
      localObject = (l)am.bQn().getValue("key_share_card_layout_data");
      if (localObject == null)
      {
        ac.w("MicroMsg.CardHomePageItemController", "updateShareCardView data is null");
        AppMethodBeat.o(113408);
        return;
      }
      if (bs.isNullOrNil(((l)localObject).nYv)) {
        this.oem.setVisibility(8);
      }
      while (bs.gY(((l)localObject).nYu))
      {
        i = 0;
        while (i < 3)
        {
          this.oeo[i].setVisibility(8);
          i += 1;
        }
        this.oem.setVisibility(0);
        this.oem.setText(((l)localObject).nYv);
      }
      int i = 0;
      if (i < 3)
      {
        if (i < ((l)localObject).nYu.size())
        {
          this.oeo[i].setVisibility(0);
          int j = this.nTt.getResources().getDimensionPixelSize(2131165483);
          n.a(this.oeo[i], (String)((l)localObject).nYu.get(i), j, 2131233400, false);
        }
        for (;;)
        {
          i += 1;
          break;
          this.oeo[i].setVisibility(8);
        }
      }
      if ((!bs.gY(((l)localObject).nYu)) && (((l)localObject).nYu.size() == 1) && (((l)localObject).dvX) && (!((l)localObject).dvY))
      {
        this.oep.setVisibility(0);
        AppMethodBeat.o(113408);
        return;
      }
      this.oep.setVisibility(8);
      AppMethodBeat.o(113408);
      return;
    }
    if (this.oej == 3)
    {
      this.oel.setText(2131757021);
      this.ijA.findViewById(2131297814).setVisibility(8);
      localObject = (String)am.bQn().getValue("key_card_entrance_tips");
      if (!bs.isNullOrNil((String)localObject))
      {
        this.oem.setText((CharSequence)localObject);
        this.oem.setVisibility(0);
        AppMethodBeat.o(113408);
        return;
      }
      this.oem.setVisibility(8);
    }
    AppMethodBeat.o(113408);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113407);
    this.oek.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(113407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.f
 * JD-Core Version:    0.7.0.1
 */