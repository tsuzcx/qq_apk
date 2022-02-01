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
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class f
{
  private View gQj;
  private View jBN;
  private MMActivity pQZ;
  private b pXs;
  private int qbU;
  private TextView qbV;
  private TextView qbW;
  private CdnImageView qbX;
  private ImageView[] qbY;
  private ImageView qbZ;
  private up qca;
  
  public f(MMActivity paramMMActivity, View paramView, int paramInt, b paramb)
  {
    this(paramMMActivity, paramView, paramInt, paramb, null);
  }
  
  public f(MMActivity paramMMActivity, View paramView, int paramInt, b paramb, up paramup)
  {
    AppMethodBeat.i(113406);
    this.qbY = new ImageView[3];
    this.pQZ = paramMMActivity;
    this.jBN = paramView;
    this.qbU = paramInt;
    this.pXs = paramb;
    this.qca = paramup;
    this.gQj = this.jBN.findViewById(2131298134);
    this.qbV = ((TextView)this.jBN.findViewById(2131298136));
    this.qbW = ((TextView)this.jBN.findViewById(2131298135));
    this.qbX = ((CdnImageView)this.jBN.findViewById(2131298137));
    this.qbY[0] = ((ImageView)this.jBN.findViewById(2131298131));
    this.qbY[1] = ((ImageView)this.jBN.findViewById(2131298132));
    this.qbY[2] = ((ImageView)this.jBN.findViewById(2131298133));
    this.qbZ = ((ImageView)this.jBN.findViewById(2131298202));
    if (this.qbU == 1)
    {
      this.qbV.setText(this.pQZ.getString(2131757098, new Object[] { Integer.valueOf(0) }));
      this.qbX.setImageResource(2131689884);
      AppMethodBeat.o(113406);
      return;
    }
    if (this.qbU == 2)
    {
      this.qbV.setText(2131757158);
      this.qbX.setImageResource(2131689883);
      AppMethodBeat.o(113406);
      return;
    }
    if (this.qbU == 3)
    {
      this.qbV.setText(2131757191);
      this.qbX.setImageResource(2131689885);
      AppMethodBeat.o(113406);
      return;
    }
    if (this.qbU == 4)
    {
      if (this.qca == null)
      {
        Log.w("MicroMsg.CardHomePageItemController", "cell element is null");
        cvX();
      }
      this.jBN.findViewById(2131298130).setVisibility(8);
      this.qbV.setText(this.qca.LdW);
      this.qbX.setUseSdcardCache(true);
      this.qbX.setUrl(this.qca.LdX);
      if (!Util.isNullOrNil(this.qca.LdY))
      {
        this.qbW.setText(this.qca.LdY);
        this.qbW.setVisibility(0);
        AppMethodBeat.o(113406);
        return;
      }
      this.qbW.setVisibility(8);
    }
    AppMethodBeat.o(113406);
  }
  
  public final void cvX()
  {
    AppMethodBeat.i(113409);
    this.jBN.setVisibility(8);
    AppMethodBeat.o(113409);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113407);
    this.gQj.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(113407);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(113408);
    Object localObject;
    if (this.qbU == 2)
    {
      localObject = (l)am.ctV().getValue("key_share_card_layout_data");
      if (localObject == null)
      {
        Log.w("MicroMsg.CardHomePageItemController", "updateShareCardView data is null");
        AppMethodBeat.o(113408);
        return;
      }
      if (Util.isNullOrNil(((l)localObject).pWf)) {
        this.qbW.setVisibility(8);
      }
      while (Util.isNullOrNil(((l)localObject).pWe))
      {
        i = 0;
        while (i < 3)
        {
          this.qbY[i].setVisibility(8);
          i += 1;
        }
        this.qbW.setVisibility(0);
        this.qbW.setText(((l)localObject).pWf);
      }
      int i = 0;
      if (i < 3)
      {
        if (i < ((l)localObject).pWe.size())
        {
          this.qbY[i].setVisibility(0);
          int j = this.pQZ.getResources().getDimensionPixelSize(2131165501);
          n.a(this.qbY[i], (String)((l)localObject).pWe.get(i), j, 2131234198, false);
        }
        for (;;)
        {
          i += 1;
          break;
          this.qbY[i].setVisibility(8);
        }
      }
      if ((!Util.isNullOrNil(((l)localObject).pWe)) && (((l)localObject).pWe.size() == 1) && (((l)localObject).eaY) && (!((l)localObject).eaZ))
      {
        this.qbZ.setVisibility(0);
        AppMethodBeat.o(113408);
        return;
      }
      this.qbZ.setVisibility(8);
      AppMethodBeat.o(113408);
      return;
    }
    if (this.qbU == 3)
    {
      this.qbV.setText(2131757191);
      this.jBN.findViewById(2131298130).setVisibility(8);
      localObject = (String)am.ctV().getValue("key_card_entrance_tips");
      if (!Util.isNullOrNil((String)localObject))
      {
        this.qbW.setText((CharSequence)localObject);
        this.qbW.setVisibility(0);
        AppMethodBeat.o(113408);
        return;
      }
      this.qbW.setVisibility(8);
    }
    AppMethodBeat.o(113408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.f
 * JD-Core Version:    0.7.0.1
 */