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
import com.tencent.mm.plugin.game.d.af;
import com.tencent.mm.plugin.game.d.j;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.d;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  extends LinearLayout
  implements View.OnClickListener
{
  private LayoutInflater Lu;
  private int kQh;
  private String mAppId;
  private Context mContext;
  
  public f(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.Lu = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    setOrientation(0);
  }
  
  public final void a(af paramaf, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramaf == null) || (bk.dk(paramaf.kTw)))
    {
      setVisibility(8);
      return;
    }
    if (paramaf.kTw.size() == 1)
    {
      paramaf.kTw.add(null);
      paramaf.kTw.add(null);
    }
    label69:
    j localj;
    LinearLayout localLinearLayout;
    ImageView localImageView;
    TextView localTextView1;
    TextView localTextView2;
    for (;;)
    {
      this.mAppId = paramString;
      this.kQh = paramInt2;
      paramaf = paramaf.kTw.iterator();
      for (;;)
      {
        if (!paramaf.hasNext()) {
          break label325;
        }
        localj = (j)paramaf.next();
        localLinearLayout = (LinearLayout)this.Lu.inflate(g.f.game_center_4_block_entrance_item, this, false);
        addView(localLinearLayout, new LinearLayout.LayoutParams(-2, -2, 1.0F));
        localImageView = (ImageView)localLinearLayout.findViewById(g.e.entrance_icon);
        localTextView1 = (TextView)localLinearLayout.findViewById(g.e.entrance_title);
        localTextView2 = (TextView)localLinearLayout.findViewById(g.e.entrance_desc);
        if (localj != null) {
          break;
        }
        localImageView.setImageResource(g.d.game_wait_unlock);
        localTextView1.setText(g.i.game_wait_unlock);
        localTextView1.setTextColor(this.mContext.getResources().getColor(g.b.game_title_hint));
      }
      if (paramaf.kTw.size() == 2) {
        paramaf.kTw.add(null);
      }
    }
    localLinearLayout.setOnClickListener(this);
    e.baw().g(localImageView, localj.kSy);
    localTextView1.setText(localj.bGw);
    if (!bk.bl(localj.kRN))
    {
      localTextView2.setText(localj.kRN);
      localTextView2.setVisibility(0);
    }
    for (;;)
    {
      localLinearLayout.setTag(localj);
      if (paramInt1 != 2) {
        break label69;
      }
      a.a(this.mContext, 10, 1002, localj.kSu, paramString, paramInt2, a.fy(localj.kSs));
      break label69;
      label325:
      break;
      localTextView2.setVisibility(8);
    }
  }
  
  public final void onClick(View paramView)
  {
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof j)))
    {
      y.w("MicroMsg.GameBlockEntranceView", "getTag is null");
      return;
    }
    paramView = (j)paramView.getTag();
    if (bk.bl(paramView.kRP))
    {
      y.w("MicroMsg.GameBlockEntranceView", "jumpUrl is null");
      return;
    }
    int i = c.o(this.mContext, paramView.kRP, "game_center_mygame_comm");
    b.a(this.mContext, 10, 1002, paramView.kSu, i, this.mAppId, this.kQh, a.fy(paramView.kSs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.f
 * JD-Core Version:    0.7.0.1
 */