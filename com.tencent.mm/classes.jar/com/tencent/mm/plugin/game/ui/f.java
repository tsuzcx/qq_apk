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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.protobuf.ar;
import com.tencent.mm.plugin.game.protobuf.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  extends LinearLayout
  implements View.OnClickListener
{
  private String mAppId;
  private Context mContext;
  private LayoutInflater mInflater;
  private int xGR;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(41905);
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    setOrientation(0);
    AppMethodBeat.o(41905);
  }
  
  public final void a(ar paramar, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41906);
    if ((paramar == null) || (Util.isNullOrNil(paramar.xKD)))
    {
      setVisibility(8);
      AppMethodBeat.o(41906);
      return;
    }
    if (paramar.xKD.size() == 1)
    {
      paramar.xKD.add(null);
      paramar.xKD.add(null);
    }
    o localo;
    LinearLayout localLinearLayout;
    ImageView localImageView;
    TextView localTextView1;
    TextView localTextView2;
    for (;;)
    {
      this.mAppId = paramString;
      this.xGR = paramInt2;
      paramar = paramar.xKD.iterator();
      for (;;)
      {
        if (!paramar.hasNext()) {
          break label340;
        }
        localo = (o)paramar.next();
        localLinearLayout = (LinearLayout)this.mInflater.inflate(2131494811, this, false);
        addView(localLinearLayout, new LinearLayout.LayoutParams(-2, -2, 1.0F));
        localImageView = (ImageView)localLinearLayout.findViewById(2131300145);
        localTextView1 = (TextView)localLinearLayout.findViewById(2131300146);
        localTextView2 = (TextView)localLinearLayout.findViewById(2131300144);
        if (localo != null) {
          break;
        }
        localImageView.setImageResource(2131232980);
        localTextView1.setText(2131761375);
        localTextView1.setTextColor(this.mContext.getResources().getColor(2131100535));
      }
      if (paramar.xKD.size() == 2) {
        paramar.xKD.add(null);
      }
    }
    localLinearLayout.setOnClickListener(this);
    e.dWR().o(localImageView, localo.IconUrl);
    localTextView1.setText(localo.Title);
    if (!Util.isNullOrNil(localo.Desc))
    {
      localTextView2.setText(localo.Desc);
      localTextView2.setVisibility(0);
    }
    for (;;)
    {
      localLinearLayout.setTag(localo);
      if (paramInt1 != 2) {
        break;
      }
      com.tencent.mm.plugin.game.d.a.b(this.mContext, 10, 1002, localo.xJv, paramString, paramInt2, com.tencent.mm.plugin.game.d.a.Fh(localo.xJt));
      break;
      localTextView2.setVisibility(8);
    }
    label340:
    AppMethodBeat.o(41906);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41907);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameBlockEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof o)))
    {
      Log.w("MicroMsg.GameBlockEntranceView", "getTag is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41907);
      return;
    }
    paramView = (o)paramView.getTag();
    if (Util.isNullOrNil(paramView.xIy))
    {
      Log.w("MicroMsg.GameBlockEntranceView", "jumpUrl is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41907);
      return;
    }
    int i = c.D(this.mContext, paramView.xIy, "game_center_mygame_comm");
    com.tencent.mm.game.report.f.a(this.mContext, 10, 1002, paramView.xJv, i, this.mAppId, this.xGR, com.tencent.mm.plugin.game.d.a.Fh(paramView.xJt));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.f
 * JD-Core Version:    0.7.0.1
 */