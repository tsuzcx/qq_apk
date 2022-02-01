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
import com.tencent.mm.plugin.game.d.aj;
import com.tencent.mm.plugin.game.d.dk;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.plugin.game.widget.EllipsizingTextView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
  extends LinearLayout
  implements View.OnClickListener
{
  private String mAppId;
  private Context mContext;
  private LayoutInflater mInflater;
  private int udq;
  
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
    localMarginLayoutParams.leftMargin = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 20);
    localImageView.setLayoutParams(localMarginLayoutParams);
    paramViewGroup.addView(localImageView);
    AppMethodBeat.o(41903);
  }
  
  public final void a(aj paramaj, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41901);
    if ((paramaj == null) || (bt.hj(paramaj.ugO)))
    {
      setVisibility(8);
      AppMethodBeat.o(41901);
      return;
    }
    this.mAppId = paramString;
    this.udq = paramInt2;
    paramaj = paramaj.ugO.iterator();
    while (paramaj.hasNext())
    {
      com.tencent.mm.plugin.game.d.k localk = (com.tencent.mm.plugin.game.d.k)paramaj.next();
      if (localk != null)
      {
        e.a.a locala = new e.a.a();
        label112:
        View localView;
        TextView localTextView1;
        TextView localTextView2;
        Object localObject;
        switch (localk.ufL)
        {
        default: 
          if (paramInt1 == 2) {
            com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1002, localk.ufI, paramString, paramInt2, com.tencent.mm.plugin.game.e.a.wk(localk.ufG));
          }
          break;
        case 1: 
          if (localk.ufJ != null)
          {
            r(this);
            localView = this.mInflater.inflate(2131494248, this, false);
            localTextView1 = (TextView)localView.findViewById(2131302568);
            localTextView2 = (TextView)localView.findViewById(2131302570);
            localObject = (EllipsizingTextView)localView.findViewById(2131302567);
            ((EllipsizingTextView)localObject).setMaxLines(2);
            ImageView localImageView = (ImageView)localView.findViewById(2131302569);
            localTextView1.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, localk.ufH, localTextView1.getTextSize()));
            localTextView2.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, localk.ufJ.Title, localTextView2.getTextSize()));
            ((EllipsizingTextView)localObject).setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, localk.ufJ.Desc, ((EllipsizingTextView)localObject).getTextSize()));
            if (!bt.isNullOrNil(localk.ufJ.ueX)) {
              com.tencent.mm.plugin.game.f.e.dav().a(localImageView, localk.ufJ.ueX, locala.daw());
            }
            for (;;)
            {
              localView.setTag(new a(localk.ufI, localk.ufJ.ueY, localk.ufG));
              localView.setOnClickListener(this);
              addView(localView);
              break;
              localImageView.setVisibility(8);
            }
          }
          break;
        case 2: 
          if (localk.ufK != null)
          {
            r(this);
            localView = this.mInflater.inflate(2131494249, this, false);
            localTextView1 = (TextView)localView.findViewById(2131304833);
            localTextView2 = (TextView)localView.findViewById(2131304835);
            localObject = (ImageView)localView.findViewById(2131304834);
            localTextView1.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, localk.ufH, localTextView1.getTextSize()));
            localTextView2.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, localk.ufK.Title, localTextView2.getTextSize()));
            if (!bt.isNullOrNil(localk.ufK.ueX)) {
              if (localk.ufK.ujO == 1)
              {
                locala.uvI = true;
                locala.hdT = 2131232501;
                label538:
                com.tencent.mm.plugin.game.f.e.dav().a((ImageView)localObject, localk.ufK.ueX, locala.daw());
              }
            }
            for (;;)
            {
              localView.setTag(new a(localk.ufI, localk.ufK.ueY, localk.ufG));
              localView.setOnClickListener(this);
              addView(localView);
              break label112;
              break;
              locala.hfi = true;
              locala.hdT = 2131232500;
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameBlockContentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      ad.w("MicroMsg.GameBlockContentView", "getTag is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockContentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41902);
      return;
    }
    paramView = (a)paramView.getTag();
    if (bt.isNullOrNil(paramView.jumpUrl))
    {
      ad.w("MicroMsg.GameBlockContentView", "jumpUrl is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockContentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(41902);
      return;
    }
    int i = c.B(this.mContext, paramView.jumpUrl, "game_center_mygame_comm");
    f.a(this.mContext, 10, 1002, paramView.uek, i, this.mAppId, this.udq, com.tencent.mm.plugin.game.e.a.wk(paramView.uaR));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockContentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41902);
  }
  
  static final class a
  {
    public String jumpUrl;
    public String uaR;
    public int uek;
    
    public a(int paramInt, String paramString1, String paramString2)
    {
      this.uek = paramInt;
      this.jumpUrl = paramString1;
      this.uaR = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.e
 * JD-Core Version:    0.7.0.1
 */