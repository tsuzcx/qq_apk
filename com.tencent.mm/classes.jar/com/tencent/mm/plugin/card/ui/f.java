package com.tencent.mm.plugin.card.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.b.e;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ow;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class f
{
  private View iCk;
  private MMActivity jpX;
  private b krp;
  private int kvQ;
  private View kvR;
  private TextView kvS;
  private TextView kvT;
  private CdnImageView kvU;
  private ImageView[] kvV;
  private ImageView kvW;
  private ow kvX;
  
  public f(MMActivity paramMMActivity, View paramView, int paramInt, b paramb)
  {
    this(paramMMActivity, paramView, paramInt, paramb, null);
  }
  
  public f(MMActivity paramMMActivity, View paramView, int paramInt, b paramb, ow paramow)
  {
    AppMethodBeat.i(88479);
    this.kvV = new ImageView[3];
    this.jpX = paramMMActivity;
    this.iCk = paramView;
    this.kvQ = paramInt;
    this.krp = paramb;
    this.kvX = paramow;
    this.kvR = this.iCk.findViewById(2131822195);
    this.kvS = ((TextView)this.iCk.findViewById(2131822197));
    this.kvT = ((TextView)this.iCk.findViewById(2131822198));
    this.kvU = ((CdnImageView)this.iCk.findViewById(2131822196));
    this.kvV[0] = ((ImageView)this.iCk.findViewById(2131822200));
    this.kvV[1] = ((ImageView)this.iCk.findViewById(2131822201));
    this.kvV[2] = ((ImageView)this.iCk.findViewById(2131822202));
    this.kvW = ((ImageView)this.iCk.findViewById(2131822203));
    if (this.kvQ == 1)
    {
      this.kvS.setText(this.jpX.getString(2131297986, new Object[] { Integer.valueOf(0) }));
      this.kvU.setImageResource(2131231077);
      AppMethodBeat.o(88479);
      return;
    }
    if (this.kvQ == 2)
    {
      this.kvS.setText(2131298046);
      this.kvU.setImageResource(2131231076);
      AppMethodBeat.o(88479);
      return;
    }
    if (this.kvQ == 3)
    {
      this.kvS.setText(2131298079);
      this.kvU.setImageResource(2131231078);
      AppMethodBeat.o(88479);
      return;
    }
    if (this.kvQ == 4)
    {
      if (this.kvX == null)
      {
        ab.w("MicroMsg.CardHomePageItemController", "cell element is null");
        bed();
      }
      this.iCk.findViewById(2131822199).setVisibility(8);
      this.kvS.setText(this.kvX.wFt);
      this.kvU.setUseSdcardCache(true);
      this.kvU.setUrl(this.kvX.wFu);
      if (!bo.isNullOrNil(this.kvX.wFv))
      {
        this.kvT.setText(this.kvX.wFv);
        this.kvT.setVisibility(0);
        AppMethodBeat.o(88479);
        return;
      }
      this.kvT.setVisibility(8);
    }
    AppMethodBeat.o(88479);
  }
  
  public final void bJ()
  {
    AppMethodBeat.i(88481);
    Object localObject;
    if (this.kvQ == 2)
    {
      localObject = (l)am.bci().getValue("key_share_card_layout_data");
      if (localObject == null)
      {
        ab.w("MicroMsg.CardHomePageItemController", "updateShareCardView data is null");
        AppMethodBeat.o(88481);
        return;
      }
      if (bo.isNullOrNil(((l)localObject).kqb)) {
        this.kvT.setVisibility(8);
      }
      while (bo.es(((l)localObject).kqa))
      {
        i = 0;
        while (i < 3)
        {
          this.kvV[i].setVisibility(8);
          i += 1;
        }
        this.kvT.setVisibility(0);
        this.kvT.setText(((l)localObject).kqb);
      }
      int i = 0;
      if (i < 3)
      {
        if (i < ((l)localObject).kqa.size())
        {
          this.kvV[i].setVisibility(0);
          int j = this.jpX.getResources().getDimensionPixelSize(2131427775);
          m.a(this.kvV[i], (String)((l)localObject).kqa.get(i), j, 2130839758, false);
        }
        for (;;)
        {
          i += 1;
          break;
          this.kvV[i].setVisibility(8);
        }
      }
      if ((!bo.es(((l)localObject).kqa)) && (((l)localObject).kqa.size() == 1) && (((l)localObject).cHw) && (!((l)localObject).cHx))
      {
        this.kvW.setVisibility(0);
        AppMethodBeat.o(88481);
        return;
      }
      this.kvW.setVisibility(8);
      AppMethodBeat.o(88481);
      return;
    }
    if (this.kvQ == 3)
    {
      this.kvS.setText(2131298079);
      this.iCk.findViewById(2131822199).setVisibility(8);
      localObject = (String)am.bci().getValue("key_card_entrance_tips");
      if (!bo.isNullOrNil((String)localObject))
      {
        this.kvT.setText((CharSequence)localObject);
        this.kvT.setVisibility(0);
        AppMethodBeat.o(88481);
        return;
      }
      this.kvT.setVisibility(8);
    }
    AppMethodBeat.o(88481);
  }
  
  public final void bed()
  {
    AppMethodBeat.i(88482);
    this.iCk.setVisibility(8);
    AppMethodBeat.o(88482);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(88480);
    this.kvR.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(88480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.f
 * JD-Core Version:    0.7.0.1
 */