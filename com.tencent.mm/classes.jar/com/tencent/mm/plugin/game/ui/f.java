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
import com.tencent.mm.plugin.game.d.ag;
import com.tencent.mm.plugin.game.d.j;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  extends LinearLayout
  implements View.OnClickListener
{
  private String mAppId;
  private Context mContext;
  private LayoutInflater mInflater;
  private int nok;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(111740);
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    setOrientation(0);
    AppMethodBeat.o(111740);
  }
  
  public final void a(ag paramag, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111741);
    if ((paramag == null) || (bo.es(paramag.nrw)))
    {
      setVisibility(8);
      AppMethodBeat.o(111741);
      return;
    }
    if (paramag.nrw.size() == 1)
    {
      paramag.nrw.add(null);
      paramag.nrw.add(null);
    }
    j localj;
    LinearLayout localLinearLayout;
    ImageView localImageView;
    TextView localTextView1;
    TextView localTextView2;
    for (;;)
    {
      this.mAppId = paramString;
      this.nok = paramInt2;
      paramag = paramag.nrw.iterator();
      for (;;)
      {
        if (!paramag.hasNext()) {
          break label340;
        }
        localj = (j)paramag.next();
        localLinearLayout = (LinearLayout)this.mInflater.inflate(2130969698, this, false);
        addView(localLinearLayout, new LinearLayout.LayoutParams(-2, -2, 1.0F));
        localImageView = (ImageView)localLinearLayout.findViewById(2131824442);
        localTextView1 = (TextView)localLinearLayout.findViewById(2131824443);
        localTextView2 = (TextView)localLinearLayout.findViewById(2131824444);
        if (localj != null) {
          break;
        }
        localImageView.setImageResource(2130839050);
        localTextView1.setText(2131300477);
        localTextView1.setTextColor(this.mContext.getResources().getColor(2131690109));
      }
      if (paramag.nrw.size() == 2) {
        paramag.nrw.add(null);
      }
    }
    localLinearLayout.setOnClickListener(this);
    e.bHE().i(localImageView, localj.IconUrl);
    localTextView1.setText(localj.Title);
    if (!bo.isNullOrNil(localj.Desc))
    {
      localTextView2.setText(localj.Desc);
      localTextView2.setVisibility(0);
    }
    for (;;)
    {
      localLinearLayout.setTag(localj);
      if (paramInt1 != 2) {
        break;
      }
      a.a(this.mContext, 10, 1002, localj.nqv, paramString, paramInt2, a.lR(localj.nqt));
      break;
      localTextView2.setVisibility(8);
    }
    label340:
    AppMethodBeat.o(111741);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111742);
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof j)))
    {
      ab.w("MicroMsg.GameBlockEntranceView", "getTag is null");
      AppMethodBeat.o(111742);
      return;
    }
    paramView = (j)paramView.getTag();
    if (bo.isNullOrNil(paramView.npR))
    {
      ab.w("MicroMsg.GameBlockEntranceView", "jumpUrl is null");
      AppMethodBeat.o(111742);
      return;
    }
    int i = com.tencent.mm.plugin.game.f.c.t(this.mContext, paramView.npR, "game_center_mygame_comm");
    com.tencent.mm.game.report.c.a(this.mContext, 10, 1002, paramView.nqv, i, this.mAppId, this.nok, a.lR(paramView.nqt));
    AppMethodBeat.o(111742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.f
 * JD-Core Version:    0.7.0.1
 */