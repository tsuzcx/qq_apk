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
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.d;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.protobuf.as;
import com.tencent.mm.plugin.game.protobuf.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  extends LinearLayout
  implements View.OnClickListener
{
  private int CKU;
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
  
  public final void a(as paramas, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41906);
    if ((paramas == null) || (Util.isNullOrNil(paramas.COK)))
    {
      setVisibility(8);
      AppMethodBeat.o(41906);
      return;
    }
    if (paramas.COK.size() == 1)
    {
      paramas.COK.add(null);
      paramas.COK.add(null);
    }
    o localo;
    LinearLayout localLinearLayout;
    ImageView localImageView;
    TextView localTextView1;
    TextView localTextView2;
    for (;;)
    {
      this.mAppId = paramString;
      this.CKU = paramInt2;
      paramas = paramas.COK.iterator();
      for (;;)
      {
        if (!paramas.hasNext()) {
          break label347;
        }
        localo = (o)paramas.next();
        localLinearLayout = (LinearLayout)this.mInflater.inflate(g.f.Cmu, this, false);
        addView(localLinearLayout, new LinearLayout.LayoutParams(-2, -2, 1.0F));
        localImageView = (ImageView)localLinearLayout.findViewById(g.e.ChG);
        localTextView1 = (TextView)localLinearLayout.findViewById(g.e.ChH);
        localTextView2 = (TextView)localLinearLayout.findViewById(g.e.ChF);
        if (localo != null) {
          break;
        }
        localImageView.setImageResource(g.d.Chm);
        localTextView1.setText(g.i.Chm);
        localTextView1.setTextColor(this.mContext.getResources().getColor(g.b.CgH));
      }
      if (paramas.COK.size() == 2) {
        paramas.COK.add(null);
      }
    }
    localLinearLayout.setOnClickListener(this);
    e.eAa().o(localImageView, localo.CNj);
    localTextView1.setText(localo.fwr);
    if (!Util.isNullOrNil(localo.CMB))
    {
      localTextView2.setText(localo.CMB);
      localTextView2.setVisibility(0);
    }
    for (;;)
    {
      localLinearLayout.setTag(localo);
      if (paramInt1 != 2) {
        break;
      }
      com.tencent.mm.plugin.game.c.a.b(this.mContext, 10, 1002, localo.CNC, paramString, paramInt2, com.tencent.mm.plugin.game.c.a.Md(localo.CNA));
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
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameBlockEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof o)))
    {
      Log.w("MicroMsg.GameBlockEntranceView", "getTag is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41907);
      return;
    }
    paramView = (o)paramView.getTag();
    if (Util.isNullOrNil(paramView.CMD))
    {
      Log.w("MicroMsg.GameBlockEntranceView", "jumpUrl is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41907);
      return;
    }
    int i = c.I(this.mContext, paramView.CMD, "game_center_mygame_comm");
    g.a(this.mContext, 10, 1002, paramView.CNC, i, this.mAppId, this.CKU, com.tencent.mm.plugin.game.c.a.Md(paramView.CNA));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.f
 * JD-Core Version:    0.7.0.1
 */