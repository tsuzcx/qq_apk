package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.h.b;
import com.tencent.mm.plugin.game.h.d;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.protobuf.at;
import com.tencent.mm.plugin.game.protobuf.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  extends LinearLayout
  implements View.OnClickListener
{
  private int IFc;
  private String mAppId;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(41905);
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    setOrientation(0);
    AppMethodBeat.o(41905);
  }
  
  public final void a(at paramat, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41906);
    if ((paramat == null) || (Util.isNullOrNil(paramat.IIU)))
    {
      setVisibility(8);
      AppMethodBeat.o(41906);
      return;
    }
    if (paramat.IIU.size() == 1)
    {
      paramat.IIU.add(null);
      paramat.IIU.add(null);
    }
    p localp;
    LinearLayout localLinearLayout;
    ImageView localImageView;
    TextView localTextView1;
    TextView localTextView2;
    for (;;)
    {
      this.mAppId = paramString;
      this.IFc = paramInt2;
      paramat = paramat.IIU.iterator();
      for (;;)
      {
        if (!paramat.hasNext()) {
          break label347;
        }
        localp = (p)paramat.next();
        localLinearLayout = (LinearLayout)this.mInflater.inflate(h.f.HYC, this, false);
        addView(localLinearLayout, new LinearLayout.LayoutParams(-2, -2, 1.0F));
        localImageView = (ImageView)localLinearLayout.findViewById(h.e.HTO);
        localTextView1 = (TextView)localLinearLayout.findViewById(h.e.HTP);
        localTextView2 = (TextView)localLinearLayout.findViewById(h.e.HTN);
        if (localp != null) {
          break;
        }
        localImageView.setImageResource(h.d.HTv);
        localTextView1.setText(h.i.HTv);
        localTextView1.setTextColor(this.mContext.getResources().getColor(h.b.HSQ));
      }
      if (paramat.IIU.size() == 2) {
        paramat.IIU.add(null);
      }
    }
    localLinearLayout.setOnClickListener(this);
    e.fIb().p(localImageView, localp.IHo);
    localTextView1.setText(localp.hAP);
    if (!Util.isNullOrNil(localp.IGG))
    {
      localTextView2.setText(localp.IGG);
      localTextView2.setVisibility(0);
    }
    for (;;)
    {
      localLinearLayout.setTag(localp);
      if (paramInt1 != 2) {
        break;
      }
      com.tencent.mm.plugin.game.c.a.b(this.mContext, 10, 1002, localp.IHK, paramString, paramInt2, com.tencent.mm.plugin.game.c.a.EM(localp.IHI));
      break;
      localTextView2.setVisibility(8);
    }
    label347:
    AppMethodBeat.o(41906);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41907);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameBlockEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof p)))
    {
      Log.w("MicroMsg.GameBlockEntranceView", "getTag is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41907);
      return;
    }
    paramView = (p)paramView.getTag();
    if (Util.isNullOrNil(paramView.IGI))
    {
      Log.w("MicroMsg.GameBlockEntranceView", "jumpUrl is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41907);
      return;
    }
    int i = c.I(this.mContext, paramView.IGI, "game_center_mygame_comm");
    g.a(this.mContext, 10, 1002, paramView.IHK, i, this.mAppId, this.IFc, com.tencent.mm.plugin.game.c.a.EM(paramView.IHI));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.f
 * JD-Core Version:    0.7.0.1
 */