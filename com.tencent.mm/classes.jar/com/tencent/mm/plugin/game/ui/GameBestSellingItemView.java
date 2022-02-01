package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.plugin.game.protobuf.ah;
import com.tencent.mm.plugin.game.protobuf.ao;
import com.tencent.mm.plugin.game.protobuf.be;
import com.tencent.mm.plugin.game.protobuf.g;
import com.tencent.mm.plugin.game.widget.AutoResizeTextView;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameBestSellingItemView
  extends LinearLayout
  implements View.OnClickListener
{
  AutoResizeTextView xOK;
  ImageView xOL;
  TextView xOM;
  GameTagListView xON;
  GameDownloadView xOO;
  View xOP;
  private int xOQ;
  private ah xOR;
  private d xOS;
  
  public GameBestSellingItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(41892);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameBestSellingItemView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if ((this.xOR == null) || (Util.isNullOrNil(this.xOR.xIz.xIB)))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBestSellingItemView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41892);
      return;
    }
    int i = com.tencent.mm.plugin.game.e.c.aQ(getContext(), this.xOR.xIz.xIB);
    f.a(getContext(), 10, 1022, this.xOS.xEr + 1, i, this.xOR.xIz.hik, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.Fh(this.xOS.xEq.xJt));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBestSellingItemView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41892);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41890);
    super.onFinishInflate();
    this.xOK = ((AutoResizeTextView)findViewById(2131302066));
    this.xOL = ((ImageView)findViewById(2131301985));
    this.xOM = ((TextView)findViewById(2131302051));
    this.xON = ((GameTagListView)findViewById(2131308871));
    this.xOO = ((GameDownloadView)findViewById(2131301876));
    this.xOP = findViewById(2131308274);
    this.xOQ = (com.tencent.mm.plugin.game.e.c.getScreenWidth(getContext()) - com.tencent.mm.cb.a.fromDPToPix(getContext(), 190));
    setOnClickListener(this);
    AppMethodBeat.o(41890);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(41891);
    if ((paramd == null) || (paramd.xEq == null) || (paramd.xEq.xKv == null) || (Util.isNullOrNil(paramd.xEq.xKv.xJs)))
    {
      setVisibility(8);
      AppMethodBeat.o(41891);
      return;
    }
    this.xOS = paramd;
    ah localah = (ah)paramd.xEq.xKv.xJs.get(paramd.xEr);
    int i = paramd.xEr + 1;
    if ((localah == null) || (localah.xIz == null)) {
      setVisibility(8);
    }
    for (;;)
    {
      if (!paramd.xEs)
      {
        com.tencent.mm.plugin.game.d.a.b(getContext(), 10, 1022, paramd.xEr + 1, localah.xIz.hik, GameIndexListView.getSourceScene(), com.tencent.mm.plugin.game.d.a.Fh(paramd.xEq.xJt));
        paramd.xEs = true;
      }
      AppMethodBeat.o(41891);
      return;
      this.xOR = localah;
      com.tencent.mm.plugin.game.model.c localc = x.a(this.xOR.xIz);
      localc.scene = 10;
      localc.dYu = 1022;
      localc.position = (this.xOS.xEr + 1);
      this.xOO.setDownloadInfo(new l(localc));
      setVisibility(0);
      this.xOK.setText(String.valueOf(i));
      if (i == 1) {
        this.xOK.setTextColor(com.tencent.mm.plugin.game.e.c.parseColor("#EED157"));
      }
      for (;;)
      {
        e.dWR().c(this.xOL, localah.xIz.hik, com.tencent.mm.cb.a.getDensity(getContext()));
        this.xOM.setText(localah.xIz.Name);
        this.xON.h(localah.xIz.xIX, this.xOQ);
        if ((Util.isNullOrNil(localah.xKe)) && (localah.xKf == null) && (localah.Desc == null)) {
          break label437;
        }
        if ((this.xOP instanceof ViewStub)) {
          this.xOP = ((ViewStub)this.xOP).inflate();
        }
        ((GameFeedSocialInfoView)this.xOP.findViewById(2131302082)).setData(localah);
        break;
        if (i == 2) {
          this.xOK.setTextColor(com.tencent.mm.plugin.game.e.c.parseColor("#BDC5CB"));
        } else if (i == 3) {
          this.xOK.setTextColor(com.tencent.mm.plugin.game.e.c.parseColor("#D4B897"));
        } else {
          this.xOK.setTextColor(com.tencent.mm.plugin.game.e.c.parseColor("#B2B2B2"));
        }
      }
      label437:
      this.xOP.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBestSellingItemView
 * JD-Core Version:    0.7.0.1
 */