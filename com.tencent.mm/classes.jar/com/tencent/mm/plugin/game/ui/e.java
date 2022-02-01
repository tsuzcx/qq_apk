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
import com.tencent.mm.game.report.g;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e.a.a;
import com.tencent.mm.plugin.game.g.d;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.protobuf.ar;
import com.tencent.mm.plugin.game.protobuf.dt;
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
  private int CKU;
  private String mAppId;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(41900);
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    setOrientation(1);
    AppMethodBeat.o(41900);
  }
  
  private void C(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(41903);
    ImageView localImageView = (ImageView)this.mInflater.inflate(g.f.CmZ, paramViewGroup, false);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localImageView.getLayoutParams();
    localMarginLayoutParams.leftMargin = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 20);
    localImageView.setLayoutParams(localMarginLayoutParams);
    paramViewGroup.addView(localImageView);
    AppMethodBeat.o(41903);
  }
  
  public final void a(ar paramar, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41901);
    if ((paramar == null) || (Util.isNullOrNil(paramar.COK)))
    {
      setVisibility(8);
      AppMethodBeat.o(41901);
      return;
    }
    this.mAppId = paramString;
    this.CKU = paramInt2;
    paramar = paramar.COK.iterator();
    while (paramar.hasNext())
    {
      n localn = (n)paramar.next();
      if (localn != null)
      {
        e.a.a locala = new e.a.a();
        label112:
        View localView;
        TextView localTextView1;
        TextView localTextView2;
        Object localObject;
        switch (localn.CNF)
        {
        default: 
          if (paramInt1 == 2) {
            com.tencent.mm.plugin.game.c.a.b(this.mContext, 10, 1002, localn.CNC, paramString, paramInt2, com.tencent.mm.plugin.game.c.a.Md(localn.CNA));
          }
          break;
        case 1: 
          if (localn.CND != null)
          {
            C(this);
            localView = this.mInflater.inflate(g.f.Cms, this, false);
            localTextView1 = (TextView)localView.findViewById(g.e.Cle);
            localTextView2 = (TextView)localView.findViewById(g.e.Clg);
            localObject = (EllipsizingTextView)localView.findViewById(g.e.Cld);
            ((EllipsizingTextView)localObject).setMaxLines(2);
            ImageView localImageView = (ImageView)localView.findViewById(g.e.Clf);
            localTextView1.setText(l.b(this.mContext, localn.CNB, localTextView1.getTextSize()));
            localTextView2.setText(l.b(this.mContext, localn.CND.fwr, localTextView2.getTextSize()));
            ((EllipsizingTextView)localObject).setText(l.b(this.mContext, localn.CND.CMB, ((EllipsizingTextView)localObject).getTextSize()));
            if (!Util.isNullOrNil(localn.CND.CMC)) {
              com.tencent.mm.plugin.game.d.e.eAa().a(localImageView, localn.CND.CMC, locala.eAb());
            }
            for (;;)
            {
              localView.setTag(new a(localn.CNC, localn.CND.CMD, localn.CNA));
              localView.setOnClickListener(this);
              addView(localView);
              break;
              localImageView.setVisibility(8);
            }
          }
          break;
        case 2: 
          if (localn.CNE != null)
          {
            C(this);
            localView = this.mInflater.inflate(g.f.Cmt, this, false);
            localTextView1 = (TextView)localView.findViewById(g.e.ClC);
            localTextView2 = (TextView)localView.findViewById(g.e.ClE);
            localObject = (ImageView)localView.findViewById(g.e.ClD);
            localTextView1.setText(l.b(this.mContext, localn.CNB, localTextView1.getTextSize()));
            localTextView2.setText(l.b(this.mContext, localn.CNE.fwr, localTextView2.getTextSize()));
            if (!Util.isNullOrNil(localn.CNE.CMC)) {
              if (localn.CNE.CRx == 1)
              {
                locala.Dea = true;
                locala.kOh = g.d.Chh;
                label548:
                com.tencent.mm.plugin.game.d.e.eAa().a((ImageView)localObject, localn.CNE.CMC, locala.eAb());
              }
            }
            for (;;)
            {
              localView.setTag(new a(localn.CNC, localn.CNE.CMD, localn.CNA));
              localView.setOnClickListener(this);
              addView(localView);
              break label112;
              break;
              locala.kPz = true;
              locala.kOh = g.d.Chg;
              break label548;
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
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameBlockContentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
    int i = c.I(this.mContext, paramView.jumpUrl, "game_center_mygame_comm");
    g.a(this.mContext, 10, 1002, paramView.CLN, i, this.mAppId, this.CKU, com.tencent.mm.plugin.game.c.a.Md(paramView.CIm));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockContentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41902);
  }
  
  static final class a
  {
    public String CIm;
    public int CLN;
    public String jumpUrl;
    
    public a(int paramInt, String paramString1, String paramString2)
    {
      this.CLN = paramInt;
      this.jumpUrl = paramString1;
      this.CIm = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.e
 * JD-Core Version:    0.7.0.1
 */