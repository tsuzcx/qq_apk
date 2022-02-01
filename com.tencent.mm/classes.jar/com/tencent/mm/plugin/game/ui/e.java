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
import com.tencent.mm.plugin.game.d.ap;
import com.tencent.mm.plugin.game.d.ds;
import com.tencent.mm.plugin.game.d.n;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.plugin.game.widget.EllipsizingTextView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
  extends LinearLayout
  implements View.OnClickListener
{
  private String mAppId;
  private Context mContext;
  private LayoutInflater mInflater;
  private int uoy;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(41900);
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    setOrientation(1);
    AppMethodBeat.o(41900);
  }
  
  private void r(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(41903);
    ImageView localImageView = (ImageView)this.mInflater.inflate(2131494293, paramViewGroup, false);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localImageView.getLayoutParams();
    localMarginLayoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 20);
    localImageView.setLayoutParams(localMarginLayoutParams);
    paramViewGroup.addView(localImageView);
    AppMethodBeat.o(41903);
  }
  
  public final void a(ap paramap, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41901);
    if ((paramap == null) || (bu.ht(paramap.usl)))
    {
      setVisibility(8);
      AppMethodBeat.o(41901);
      return;
    }
    this.mAppId = paramString;
    this.uoy = paramInt2;
    paramap = paramap.usl.iterator();
    while (paramap.hasNext())
    {
      n localn = (n)paramap.next();
      if (localn != null)
      {
        e.a.a locala = new e.a.a();
        label112:
        View localView;
        TextView localTextView1;
        TextView localTextView2;
        Object localObject;
        switch (localn.urf)
        {
        default: 
          if (paramInt1 == 2) {
            com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1002, localn.urc, paramString, paramInt2, com.tencent.mm.plugin.game.e.a.wT(localn.ura));
          }
          break;
        case 1: 
          if (localn.urd != null)
          {
            r(this);
            localView = this.mInflater.inflate(2131494248, this, false);
            localTextView1 = (TextView)localView.findViewById(2131302568);
            localTextView2 = (TextView)localView.findViewById(2131302570);
            localObject = (EllipsizingTextView)localView.findViewById(2131302567);
            ((EllipsizingTextView)localObject).setMaxLines(2);
            ImageView localImageView = (ImageView)localView.findViewById(2131302569);
            localTextView1.setText(k.b(this.mContext, localn.urb, localTextView1.getTextSize()));
            localTextView2.setText(k.b(this.mContext, localn.urd.Title, localTextView2.getTextSize()));
            ((EllipsizingTextView)localObject).setText(k.b(this.mContext, localn.urd.Desc, ((EllipsizingTextView)localObject).getTextSize()));
            if (!bu.isNullOrNil(localn.urd.uqe)) {
              com.tencent.mm.plugin.game.f.e.ddh().a(localImageView, localn.urd.uqe, locala.ddi());
            }
            for (;;)
            {
              localView.setTag(new a(localn.urc, localn.urd.uqf, localn.ura));
              localView.setOnClickListener(this);
              addView(localView);
              break;
              localImageView.setVisibility(8);
            }
          }
          break;
        case 2: 
          if (localn.ure != null)
          {
            r(this);
            localView = this.mInflater.inflate(2131494249, this, false);
            localTextView1 = (TextView)localView.findViewById(2131304833);
            localTextView2 = (TextView)localView.findViewById(2131304835);
            localObject = (ImageView)localView.findViewById(2131304834);
            localTextView1.setText(k.b(this.mContext, localn.urb, localTextView1.getTextSize()));
            localTextView2.setText(k.b(this.mContext, localn.ure.Title, localTextView2.getTextSize()));
            if (!bu.isNullOrNil(localn.ure.uqe)) {
              if (localn.ure.uvm == 1)
              {
                locala.uHh = true;
                locala.hgH = 2131232501;
                label538:
                com.tencent.mm.plugin.game.f.e.ddh().a((ImageView)localObject, localn.ure.uqe, locala.ddi());
              }
            }
            for (;;)
            {
              localView.setTag(new a(localn.urc, localn.ure.uqf, localn.ura));
              localView.setOnClickListener(this);
              addView(localView);
              break label112;
              break;
              locala.hhW = true;
              locala.hgH = 2131232500;
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
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameBlockContentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      ae.w("MicroMsg.GameBlockContentView", "getTag is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockContentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41902);
      return;
    }
    paramView = (a)paramView.getTag();
    if (bu.isNullOrNil(paramView.jumpUrl))
    {
      ae.w("MicroMsg.GameBlockContentView", "jumpUrl is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockContentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41902);
      return;
    }
    int i = c.B(this.mContext, paramView.jumpUrl, "game_center_mygame_comm");
    f.a(this.mContext, 10, 1002, paramView.upr, i, this.mAppId, this.uoy, com.tencent.mm.plugin.game.e.a.wT(paramView.ulT));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockContentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41902);
  }
  
  static final class a
  {
    public String jumpUrl;
    public String ulT;
    public int upr;
    
    public a(int paramInt, String paramString1, String paramString2)
    {
      this.upr = paramInt;
      this.jumpUrl = paramString1;
      this.ulT = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.e
 * JD-Core Version:    0.7.0.1
 */