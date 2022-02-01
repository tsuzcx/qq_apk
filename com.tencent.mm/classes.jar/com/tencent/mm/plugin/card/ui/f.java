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
import com.tencent.mm.plugin.card.c.n;
import com.tencent.mm.plugin.card.mgr.d;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.wi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class f
{
  private View plc;
  private int wCo;
  private View wCp;
  private TextView wCq;
  private TextView wCr;
  private CdnImageView wCs;
  private ImageView[] wCt;
  private ImageView wCu;
  private wi wCv;
  private MMActivity wry;
  private b wxM;
  
  public f(MMActivity paramMMActivity, View paramView, int paramInt, b paramb)
  {
    this(paramMMActivity, paramView, paramInt, paramb, null);
  }
  
  public f(MMActivity paramMMActivity, View paramView, int paramInt, b paramb, wi paramwi)
  {
    AppMethodBeat.i(113406);
    this.wCt = new ImageView[3];
    this.wry = paramMMActivity;
    this.plc = paramView;
    this.wCo = paramInt;
    this.wxM = paramb;
    this.wCv = paramwi;
    this.wCp = this.plc.findViewById(a.d.wgE);
    this.wCq = ((TextView)this.plc.findViewById(a.d.wgG));
    this.wCr = ((TextView)this.plc.findViewById(a.d.wgF));
    this.wCs = ((CdnImageView)this.plc.findViewById(a.d.wgH));
    this.wCt[0] = ((ImageView)this.plc.findViewById(a.d.wgB));
    this.wCt[1] = ((ImageView)this.plc.findViewById(a.d.wgC));
    this.wCt[2] = ((ImageView)this.plc.findViewById(a.d.wgD));
    this.wCu = ((ImageView)this.plc.findViewById(a.d.whz));
    if (this.wCo == 1)
    {
      this.wCq.setText(this.wry.getString(a.g.wpu, new Object[] { Integer.valueOf(0) }));
      this.wCs.setImageResource(a.f.card_home_member_card_icon);
      AppMethodBeat.o(113406);
      return;
    }
    if (this.wCo == 2)
    {
      this.wCq.setText(a.g.wqf);
      this.wCs.setImageResource(a.f.card_home_friend_ticket_icon);
      AppMethodBeat.o(113406);
      return;
    }
    if (this.wCo == 3)
    {
      this.wCq.setText(a.g.wqE);
      this.wCs.setImageResource(a.f.card_home_my_ticket_icon);
      AppMethodBeat.o(113406);
      return;
    }
    if (this.wCo == 4)
    {
      if (this.wCv == null)
      {
        Log.w("MicroMsg.CardHomePageItemController", "cell element is null");
        dmQ();
      }
      this.plc.findViewById(a.d.wgA).setVisibility(8);
      this.wCq.setText(this.wCv.Zde);
      this.wCs.setUseSdcardCache(true);
      this.wCs.setUrl(this.wCv.Zdf);
      if (!Util.isNullOrNil(this.wCv.Zdg))
      {
        this.wCr.setText(this.wCv.Zdg);
        this.wCr.setVisibility(0);
        AppMethodBeat.o(113406);
        return;
      }
      this.wCr.setVisibility(8);
    }
    AppMethodBeat.o(113406);
  }
  
  public final void dmQ()
  {
    AppMethodBeat.i(113409);
    this.plc.setVisibility(8);
    AppMethodBeat.o(113409);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113407);
    this.wCp.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(113407);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(113408);
    Object localObject;
    if (this.wCo == 2)
    {
      localObject = (l)am.dkO().getValue("key_share_card_layout_data");
      if (localObject == null)
      {
        Log.w("MicroMsg.CardHomePageItemController", "updateShareCardView data is null");
        AppMethodBeat.o(113408);
        return;
      }
      if (Util.isNullOrNil(((l)localObject).lym)) {
        this.wCr.setVisibility(8);
      }
      while (Util.isNullOrNil(((l)localObject).wwD))
      {
        i = 0;
        while (i < 3)
        {
          this.wCt[i].setVisibility(8);
          i += 1;
        }
        this.wCr.setVisibility(0);
        this.wCr.setText(((l)localObject).lym);
      }
      int i = 0;
      if (i < 3)
      {
        if (i < ((l)localObject).wwD.size())
        {
          this.wCt[i].setVisibility(0);
          int j = this.wry.getResources().getDimensionPixelSize(a.b.LargerPadding);
          n.a(this.wCt[i], (String)((l)localObject).wwD.get(i), j, a.c.my_card_package_defaultlogo, false);
        }
        for (;;)
        {
          i += 1;
          break;
          this.wCt[i].setVisibility(8);
        }
      }
      if ((!Util.isNullOrNil(((l)localObject).wwD)) && (((l)localObject).wwD.size() == 1) && (((l)localObject).iaS) && (!((l)localObject).iaT))
      {
        this.wCu.setVisibility(0);
        AppMethodBeat.o(113408);
        return;
      }
      this.wCu.setVisibility(8);
      AppMethodBeat.o(113408);
      return;
    }
    if (this.wCo == 3)
    {
      this.wCq.setText(a.g.wqE);
      this.plc.findViewById(a.d.wgA).setVisibility(8);
      localObject = (String)am.dkO().getValue("key_card_entrance_tips");
      if (!Util.isNullOrNil((String)localObject))
      {
        this.wCr.setText((CharSequence)localObject);
        this.wCr.setVisibility(0);
        AppMethodBeat.o(113408);
        return;
      }
      this.wCr.setVisibility(8);
    }
    AppMethodBeat.o(113408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.f
 * JD-Core Version:    0.7.0.1
 */