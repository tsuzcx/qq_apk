package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.d.ae;
import com.tencent.mm.plugin.game.d.da;
import com.tencent.mm.plugin.game.d.i;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.plugin.game.g.d;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.widget.EllipsizingTextView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
  extends LinearLayout
  implements View.OnClickListener
{
  private LayoutInflater Lu;
  private int kQh;
  private String mAppId;
  private Context mContext;
  
  public e(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.Lu = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    setOrientation(1);
  }
  
  private void l(ViewGroup paramViewGroup)
  {
    ImageView localImageView = (ImageView)this.Lu.inflate(g.f.game_divide_line, paramViewGroup, false);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localImageView.getLayoutParams();
    localMarginLayoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 20);
    localImageView.setLayoutParams(localMarginLayoutParams);
    paramViewGroup.addView(localImageView);
  }
  
  public final void a(ae paramae, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramae == null) || (bk.dk(paramae.kTw))) {
      setVisibility(8);
    }
    label20:
    label40:
    i locali;
    e.a.a locala;
    label100:
    do
    {
      return;
      break label40;
      break label40;
      this.mAppId = paramString;
      this.kQh = paramInt2;
      paramae = paramae.kTw.iterator();
      do
      {
        for (;;)
        {
          if (!paramae.hasNext()) {
            break label20;
          }
          locali = (i)paramae.next();
          if (locali == null) {
            break;
          }
          locala = new e.a.a();
          switch (locali.kSx)
          {
          default: 
            if (paramInt1 != 2) {
              break label600;
            }
            com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1002, locali.kSu, paramString, paramInt2, com.tencent.mm.plugin.game.e.a.fy(locali.kSs));
          }
        }
      } while (locali.kSv == null);
      l(this);
      localView = this.Lu.inflate(g.f.game_center_4_block_content_multiline_view, this, false);
      localTextView1 = (TextView)localView.findViewById(g.e.multiline_module);
      localTextView2 = (TextView)localView.findViewById(g.e.multiline_title);
      localObject = (EllipsizingTextView)localView.findViewById(g.e.multiline_desc);
      ((EllipsizingTextView)localObject).setMaxLines(2);
      ImageView localImageView = (ImageView)localView.findViewById(g.e.multiline_picture);
      localTextView1.setText(j.a(this.mContext, locali.kSt, localTextView1.getTextSize()));
      localTextView2.setText(j.a(this.mContext, locali.kSv.bGw, localTextView2.getTextSize()));
      ((EllipsizingTextView)localObject).setText(j.a(this.mContext, locali.kSv.kRN, ((EllipsizingTextView)localObject).getTextSize()));
      if (!bk.bl(locali.kSv.kRO)) {
        com.tencent.mm.plugin.game.f.e.baw().a(localImageView, locali.kSv.kRO, locala.bax());
      }
      for (;;)
      {
        localView.setTag(new e.a(locali.kSu, locali.kSv.kRP, locali.kSs));
        localView.setOnClickListener(this);
        addView(localView);
        break;
        localImageView.setVisibility(8);
      }
    } while (locali.kSw == null);
    l(this);
    View localView = this.Lu.inflate(g.f.game_center_4_block_content_singleline_view, this, false);
    TextView localTextView1 = (TextView)localView.findViewById(g.e.singleline_module);
    TextView localTextView2 = (TextView)localView.findViewById(g.e.singleline_title);
    Object localObject = (ImageView)localView.findViewById(g.e.singleline_picture);
    localTextView1.setText(j.a(this.mContext, locali.kSt, localTextView1.getTextSize()));
    localTextView2.setText(j.a(this.mContext, locali.kSw.bGw, localTextView2.getTextSize()));
    if (!bk.bl(locali.kSw.kRO)) {
      if (locali.kSw.kWj == 1)
      {
        locala.lgz = true;
        locala.lgC = g.d.game_default_square;
        label536:
        com.tencent.mm.plugin.game.f.e.baw().a((ImageView)localObject, locali.kSw.kRO, locala.bax());
      }
    }
    for (;;)
    {
      localView.setTag(new e.a(locali.kSu, locali.kSw.kRP, locali.kSs));
      localView.setOnClickListener(this);
      addView(localView);
      break label100;
      label600:
      break;
      locala.erD = true;
      locala.lgC = g.d.game_default_round;
      break label536;
      ((ImageView)localObject).setVisibility(8);
    }
  }
  
  public final void onClick(View paramView)
  {
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof e.a)))
    {
      y.w("MicroMsg.GameBlockContentView", "getTag is null");
      return;
    }
    paramView = (e.a)paramView.getTag();
    if (bk.bl(paramView.jumpUrl))
    {
      y.w("MicroMsg.GameBlockContentView", "jumpUrl is null");
      return;
    }
    int i = c.o(this.mContext, paramView.jumpUrl, "game_center_mygame_comm");
    b.a(this.mContext, 10, 1002, paramView.kRc, i, this.mAppId, this.kQh, com.tencent.mm.plugin.game.e.a.fy(paramView.kOo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.e
 * JD-Core Version:    0.7.0.1
 */