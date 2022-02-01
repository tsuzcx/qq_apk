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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.e.a.a;
import com.tencent.mm.plugin.game.protobuf.aq;
import com.tencent.mm.plugin.game.protobuf.ds;
import com.tencent.mm.plugin.game.protobuf.n;
import com.tencent.mm.plugin.game.widget.EllipsizingTextView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
  extends LinearLayout
  implements View.OnClickListener
{
  private String mAppId;
  private Context mContext;
  private LayoutInflater mInflater;
  private int xGR;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(41900);
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    setOrientation(1);
    AppMethodBeat.o(41900);
  }
  
  private void w(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(41903);
    ImageView localImageView = (ImageView)this.mInflater.inflate(2131494855, paramViewGroup, false);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localImageView.getLayoutParams();
    localMarginLayoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 20);
    localImageView.setLayoutParams(localMarginLayoutParams);
    paramViewGroup.addView(localImageView);
    AppMethodBeat.o(41903);
  }
  
  public final void a(aq paramaq, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41901);
    if ((paramaq == null) || (Util.isNullOrNil(paramaq.xKD)))
    {
      setVisibility(8);
      AppMethodBeat.o(41901);
      return;
    }
    this.mAppId = paramString;
    this.xGR = paramInt2;
    paramaq = paramaq.xKD.iterator();
    while (paramaq.hasNext())
    {
      n localn = (n)paramaq.next();
      if (localn != null)
      {
        e.a.a locala = new e.a.a();
        label112:
        View localView;
        TextView localTextView1;
        TextView localTextView2;
        Object localObject;
        switch (localn.xJy)
        {
        default: 
          if (paramInt1 == 2) {
            com.tencent.mm.plugin.game.d.a.b(this.mContext, 10, 1002, localn.xJv, paramString, paramInt2, com.tencent.mm.plugin.game.d.a.Fh(localn.xJt));
          }
          break;
        case 1: 
          if (localn.xJw != null)
          {
            w(this);
            localView = this.mInflater.inflate(2131494809, this, false);
            localTextView1 = (TextView)localView.findViewById(2131305022);
            localTextView2 = (TextView)localView.findViewById(2131305024);
            localObject = (EllipsizingTextView)localView.findViewById(2131305021);
            ((EllipsizingTextView)localObject).setMaxLines(2);
            ImageView localImageView = (ImageView)localView.findViewById(2131305023);
            localTextView1.setText(l.b(this.mContext, localn.xJu, localTextView1.getTextSize()));
            localTextView2.setText(l.b(this.mContext, localn.xJw.Title, localTextView2.getTextSize()));
            ((EllipsizingTextView)localObject).setText(l.b(this.mContext, localn.xJw.Desc, ((EllipsizingTextView)localObject).getTextSize()));
            if (!Util.isNullOrNil(localn.xJw.xIx)) {
              com.tencent.mm.plugin.game.e.e.dWR().a(localImageView, localn.xJw.xIx, locala.dWS());
            }
            for (;;)
            {
              localView.setTag(new a(localn.xJv, localn.xJw.xIy, localn.xJt));
              localView.setOnClickListener(this);
              addView(localView);
              break;
              localImageView.setVisibility(8);
            }
          }
          break;
        case 2: 
          if (localn.xJx != null)
          {
            w(this);
            localView = this.mInflater.inflate(2131494810, this, false);
            localTextView1 = (TextView)localView.findViewById(2131307919);
            localTextView2 = (TextView)localView.findViewById(2131307921);
            localObject = (ImageView)localView.findViewById(2131307920);
            localTextView1.setText(l.b(this.mContext, localn.xJu, localTextView1.getTextSize()));
            localTextView2.setText(l.b(this.mContext, localn.xJx.Title, localTextView2.getTextSize()));
            if (!Util.isNullOrNil(localn.xJx.xIx)) {
              if (localn.xJx.xNn == 1)
              {
                locala.xZt = true;
                locala.hZB = 2131232890;
                label538:
                com.tencent.mm.plugin.game.e.e.dWR().a((ImageView)localObject, localn.xJx.xIx, locala.dWS());
              }
            }
            for (;;)
            {
              localView.setTag(new a(localn.xJv, localn.xJx.xIy, localn.xJt));
              localView.setOnClickListener(this);
              addView(localView);
              break label112;
              break;
              locala.iaT = true;
              locala.hZB = 2131232889;
              break label538;
              ((ImageView)localObject).setVisibility(8);
            }
          }
          break;
        }
      }
    }
    AppMethodBeat.o(41901);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41902);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameBlockContentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      Log.w("MicroMsg.GameBlockContentView", "getTag is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockContentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41902);
      return;
    }
    paramView = (a)paramView.getTag();
    if (Util.isNullOrNil(paramView.jumpUrl))
    {
      Log.w("MicroMsg.GameBlockContentView", "jumpUrl is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockContentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41902);
      return;
    }
    int i = c.D(this.mContext, paramView.jumpUrl, "game_center_mygame_comm");
    f.a(this.mContext, 10, 1002, paramView.xHK, i, this.mAppId, this.xGR, com.tencent.mm.plugin.game.d.a.Fh(paramView.xEl));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockContentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41902);
  }
  
  static final class a
  {
    public String jumpUrl;
    public String xEl;
    public int xHK;
    
    public a(int paramInt, String paramString1, String paramString2)
    {
      this.xHK = paramInt;
      this.jumpUrl = paramString1;
      this.xEl = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.e
 * JD-Core Version:    0.7.0.1
 */