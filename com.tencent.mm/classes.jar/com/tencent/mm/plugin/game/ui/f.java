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
import com.tencent.mm.plugin.game.d.aq;
import com.tencent.mm.plugin.game.d.o;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  extends LinearLayout
  implements View.OnClickListener
{
  private String mAppId;
  private Context mContext;
  private LayoutInflater mInflater;
  private int uoy;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(41905);
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    setOrientation(0);
    AppMethodBeat.o(41905);
  }
  
  public final void a(aq paramaq, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41906);
    if ((paramaq == null) || (bu.ht(paramaq.usl)))
    {
      setVisibility(8);
      AppMethodBeat.o(41906);
      return;
    }
    if (paramaq.usl.size() == 1)
    {
      paramaq.usl.add(null);
      paramaq.usl.add(null);
    }
    o localo;
    LinearLayout localLinearLayout;
    ImageView localImageView;
    TextView localTextView1;
    TextView localTextView2;
    for (;;)
    {
      this.mAppId = paramString;
      this.uoy = paramInt2;
      paramaq = paramaq.usl.iterator();
      for (;;)
      {
        if (!paramaq.hasNext()) {
          break label340;
        }
        localo = (o)paramaq.next();
        localLinearLayout = (LinearLayout)this.mInflater.inflate(2131494250, this, false);
        addView(localLinearLayout, new LinearLayout.LayoutParams(-2, -2, 1.0F));
        localImageView = (ImageView)localLinearLayout.findViewById(2131299508);
        localTextView1 = (TextView)localLinearLayout.findViewById(2131299509);
        localTextView2 = (TextView)localLinearLayout.findViewById(2131299507);
        if (localo != null) {
          break;
        }
        localImageView.setImageResource(2131232590);
        localTextView1.setText(2131760011);
        localTextView1.setTextColor(this.mContext.getResources().getColor(2131100433));
      }
      if (paramaq.usl.size() == 2) {
        paramaq.usl.add(null);
      }
    }
    localLinearLayout.setOnClickListener(this);
    e.ddh().l(localImageView, localo.IconUrl);
    localTextView1.setText(localo.Title);
    if (!bu.isNullOrNil(localo.Desc))
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
      com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1002, localo.urc, paramString, paramInt2, com.tencent.mm.plugin.game.e.a.wT(localo.ura));
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
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameBlockEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof o)))
    {
      ae.w("MicroMsg.GameBlockEntranceView", "getTag is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41907);
      return;
    }
    paramView = (o)paramView.getTag();
    if (bu.isNullOrNil(paramView.uqf))
    {
      ae.w("MicroMsg.GameBlockEntranceView", "jumpUrl is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41907);
      return;
    }
    int i = c.B(this.mContext, paramView.uqf, "game_center_mygame_comm");
    com.tencent.mm.game.report.f.a(this.mContext, 10, 1002, paramView.urc, i, this.mAppId, this.uoy, com.tencent.mm.plugin.game.e.a.wT(paramView.ura));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockEntranceView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.f
 * JD-Core Version:    0.7.0.1
 */