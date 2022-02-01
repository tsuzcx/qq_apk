package com.tencent.mm.plugin.card.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.e;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ur;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class f
{
  private View jAC;
  private View mrI;
  private MMActivity tmY;
  private b ttp;
  private int txS;
  private TextView txT;
  private TextView txU;
  private CdnImageView txV;
  private ImageView[] txW;
  private ImageView txX;
  private ur txY;
  
  public f(MMActivity paramMMActivity, View paramView, int paramInt, b paramb)
  {
    this(paramMMActivity, paramView, paramInt, paramb, null);
  }
  
  public f(MMActivity paramMMActivity, View paramView, int paramInt, b paramb, ur paramur)
  {
    AppMethodBeat.i(113406);
    this.txW = new ImageView[3];
    this.tmY = paramMMActivity;
    this.mrI = paramView;
    this.txS = paramInt;
    this.ttp = paramb;
    this.txY = paramur;
    this.jAC = this.mrI.findViewById(a.d.tcr);
    this.txT = ((TextView)this.mrI.findViewById(a.d.tct));
    this.txU = ((TextView)this.mrI.findViewById(a.d.tcs));
    this.txV = ((CdnImageView)this.mrI.findViewById(a.d.tcu));
    this.txW[0] = ((ImageView)this.mrI.findViewById(a.d.tco));
    this.txW[1] = ((ImageView)this.mrI.findViewById(a.d.tcp));
    this.txW[2] = ((ImageView)this.mrI.findViewById(a.d.tcq));
    this.txX = ((ImageView)this.mrI.findViewById(a.d.tdl));
    if (this.txS == 1)
    {
      this.txT.setText(this.tmY.getString(a.g.tkV, new Object[] { Integer.valueOf(0) }));
      this.txV.setImageResource(a.f.card_home_member_card_icon);
      AppMethodBeat.o(113406);
      return;
    }
    if (this.txS == 2)
    {
      this.txT.setText(a.g.tlG);
      this.txV.setImageResource(a.f.card_home_friend_ticket_icon);
      AppMethodBeat.o(113406);
      return;
    }
    if (this.txS == 3)
    {
      this.txT.setText(a.g.tmf);
      this.txV.setImageResource(a.f.card_home_my_ticket_icon);
      AppMethodBeat.o(113406);
      return;
    }
    if (this.txS == 4)
    {
      if (this.txY == null)
      {
        Log.w("MicroMsg.CardHomePageItemController", "cell element is null");
        cJz();
      }
      this.mrI.findViewById(a.d.tcn).setVisibility(8);
      this.txT.setText(this.txY.Sfj);
      this.txV.setUseSdcardCache(true);
      this.txV.setUrl(this.txY.Sfk);
      if (!Util.isNullOrNil(this.txY.Sfl))
      {
        this.txU.setText(this.txY.Sfl);
        this.txU.setVisibility(0);
        AppMethodBeat.o(113406);
        return;
      }
      this.txU.setVisibility(8);
    }
    AppMethodBeat.o(113406);
  }
  
  public final void cJz()
  {
    AppMethodBeat.i(113409);
    this.mrI.setVisibility(8);
    AppMethodBeat.o(113409);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113407);
    this.jAC.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(113407);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(113408);
    Object localObject;
    if (this.txS == 2)
    {
      localObject = (l)am.cHx().getValue("key_share_card_layout_data");
      if (localObject == null)
      {
        Log.w("MicroMsg.CardHomePageItemController", "updateShareCardView data is null");
        AppMethodBeat.o(113408);
        return;
      }
      if (Util.isNullOrNil(((l)localObject).tsf)) {
        this.txU.setVisibility(8);
      }
      while (Util.isNullOrNil(((l)localObject).tse))
      {
        i = 0;
        while (i < 3)
        {
          this.txW[i].setVisibility(8);
          i += 1;
        }
        this.txU.setVisibility(0);
        this.txU.setText(((l)localObject).tsf);
      }
      int i = 0;
      if (i < 3)
      {
        if (i < ((l)localObject).tse.size())
        {
          this.txW[i].setVisibility(0);
          int j = this.tmY.getResources().getDimensionPixelSize(a.b.LargerPadding);
          n.a(this.txW[i], (String)((l)localObject).tse.get(i), j, a.c.my_card_package_defaultlogo, false);
        }
        for (;;)
        {
          i += 1;
          break;
          this.txW[i].setVisibility(8);
        }
      }
      if ((!Util.isNullOrNil(((l)localObject).tse)) && (((l)localObject).tse.size() == 1) && (((l)localObject).fUV) && (!((l)localObject).fUW))
      {
        this.txX.setVisibility(0);
        AppMethodBeat.o(113408);
        return;
      }
      this.txX.setVisibility(8);
      AppMethodBeat.o(113408);
      return;
    }
    if (this.txS == 3)
    {
      this.txT.setText(a.g.tmf);
      this.mrI.findViewById(a.d.tcn).setVisibility(8);
      localObject = (String)am.cHx().getValue("key_card_entrance_tips");
      if (!Util.isNullOrNil((String)localObject))
      {
        this.txU.setText((CharSequence)localObject);
        this.txU.setVisibility(0);
        AppMethodBeat.o(113408);
        return;
      }
      this.txU.setVisibility(8);
    }
    AppMethodBeat.o(113408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.f
 * JD-Core Version:    0.7.0.1
 */