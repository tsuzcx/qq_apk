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
import com.tencent.mm.plugin.game.d.ai;
import com.tencent.mm.plugin.game.d.l;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  extends LinearLayout
  implements View.OnClickListener
{
  private String mAppId;
  private Context mContext;
  private LayoutInflater mInflater;
  private int rXI;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(41905);
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    setOrientation(0);
    AppMethodBeat.o(41905);
  }
  
  public final void a(ai paramai, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41906);
    if ((paramai == null) || (bt.gL(paramai.saZ)))
    {
      setVisibility(8);
      AppMethodBeat.o(41906);
      return;
    }
    if (paramai.saZ.size() == 1)
    {
      paramai.saZ.add(null);
      paramai.saZ.add(null);
    }
    l locall;
    LinearLayout localLinearLayout;
    ImageView localImageView;
    TextView localTextView1;
    TextView localTextView2;
    for (;;)
    {
      this.mAppId = paramString;
      this.rXI = paramInt2;
      paramai = paramai.saZ.iterator();
      for (;;)
      {
        if (!paramai.hasNext()) {
          break label340;
        }
        locall = (l)paramai.next();
        localLinearLayout = (LinearLayout)this.mInflater.inflate(2131494250, this, false);
        addView(localLinearLayout, new LinearLayout.LayoutParams(-2, -2, 1.0F));
        localImageView = (ImageView)localLinearLayout.findViewById(2131299508);
        localTextView1 = (TextView)localLinearLayout.findViewById(2131299509);
        localTextView2 = (TextView)localLinearLayout.findViewById(2131299507);
        if (locall != null) {
          break;
        }
        localImageView.setImageResource(2131232590);
        localTextView1.setText(2131760011);
        localTextView1.setTextColor(this.mContext.getResources().getColor(2131100433));
      }
      if (paramai.saZ.size() == 2) {
        paramai.saZ.add(null);
      }
    }
    localLinearLayout.setOnClickListener(this);
    com.tencent.mm.plugin.game.f.e.cEB().l(localImageView, locall.IconUrl);
    localTextView1.setText(locall.Title);
    if (!bt.isNullOrNil(locall.Desc))
    {
      localTextView2.setText(locall.Desc);
      localTextView2.setVisibility(0);
    }
    for (;;)
    {
      localLinearLayout.setTag(locall);
      if (paramInt1 != 2) {
        break;
      }
      a.a(this.mContext, 10, 1002, locall.rZY, paramString, paramInt2, a.qh(locall.rZW));
      break;
      localTextView2.setVisibility(8);
    }
    label340:
    AppMethodBeat.o(41906);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41907);
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof l)))
    {
      ad.w("MicroMsg.GameBlockEntranceView", "getTag is null");
      AppMethodBeat.o(41907);
      return;
    }
    paramView = (l)paramView.getTag();
    if (bt.isNullOrNil(paramView.rZo))
    {
      ad.w("MicroMsg.GameBlockEntranceView", "jumpUrl is null");
      AppMethodBeat.o(41907);
      return;
    }
    int i = c.A(this.mContext, paramView.rZo, "game_center_mygame_comm");
    com.tencent.mm.game.report.e.a(this.mContext, 10, 1002, paramView.rZY, i, this.mAppId, this.rXI, a.qh(paramView.rZW));
    AppMethodBeat.o(41907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.f
 * JD-Core Version:    0.7.0.1
 */