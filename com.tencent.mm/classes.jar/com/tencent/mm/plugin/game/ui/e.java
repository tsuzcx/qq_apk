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
import com.tencent.mm.plugin.game.h.d;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.protobuf.as;
import com.tencent.mm.plugin.game.protobuf.dx;
import com.tencent.mm.plugin.game.protobuf.o;
import com.tencent.mm.plugin.game.widget.EllipsizingTextView;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
  extends LinearLayout
  implements View.OnClickListener
{
  private int IFc;
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
  
  private void M(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(41903);
    ImageView localImageView = (ImageView)this.mInflater.inflate(h.f.HZh, paramViewGroup, false);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localImageView.getLayoutParams();
    localMarginLayoutParams.leftMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 20);
    localImageView.setLayoutParams(localMarginLayoutParams);
    paramViewGroup.addView(localImageView);
    AppMethodBeat.o(41903);
  }
  
  public final void a(as paramas, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41901);
    if ((paramas == null) || (Util.isNullOrNil(paramas.IIU)))
    {
      setVisibility(8);
      AppMethodBeat.o(41901);
      return;
    }
    this.mAppId = paramString;
    this.IFc = paramInt2;
    paramas = paramas.IIU.iterator();
    while (paramas.hasNext())
    {
      o localo = (o)paramas.next();
      if (localo != null)
      {
        e.a.a locala = new e.a.a();
        label112:
        View localView;
        TextView localTextView1;
        TextView localTextView2;
        Object localObject;
        switch (localo.IHN)
        {
        default: 
          if (paramInt1 == 2) {
            com.tencent.mm.plugin.game.c.a.b(this.mContext, 10, 1002, localo.IHK, paramString, paramInt2, com.tencent.mm.plugin.game.c.a.EM(localo.IHI));
          }
          break;
        case 1: 
          if (localo.IHL != null)
          {
            M(this);
            localView = this.mInflater.inflate(h.f.HYA, this, false);
            localTextView1 = (TextView)localView.findViewById(h.e.HXm);
            localTextView2 = (TextView)localView.findViewById(h.e.HXo);
            localObject = (EllipsizingTextView)localView.findViewById(h.e.HXl);
            ((EllipsizingTextView)localObject).setMaxLines(2);
            ImageView localImageView = (ImageView)localView.findViewById(h.e.HXn);
            localTextView1.setText(p.b(this.mContext, localo.IHJ, localTextView1.getTextSize()));
            localTextView2.setText(p.b(this.mContext, localo.IHL.hAP, localTextView2.getTextSize()));
            ((EllipsizingTextView)localObject).setText(p.b(this.mContext, localo.IHL.IGG, ((EllipsizingTextView)localObject).getTextSize()));
            if (!Util.isNullOrNil(localo.IHL.IGH)) {
              com.tencent.mm.plugin.game.d.e.fIb().a(localImageView, localo.IHL.IGH, locala.fIc());
            }
            for (;;)
            {
              localView.setTag(new a(localo.IHK, localo.IHL.IGI, localo.IHI));
              localView.setOnClickListener(this);
              addView(localView);
              break;
              localImageView.setVisibility(8);
            }
          }
          break;
        case 2: 
          if (localo.IHM != null)
          {
            M(this);
            localView = this.mInflater.inflate(h.f.HYB, this, false);
            localTextView1 = (TextView)localView.findViewById(h.e.HXK);
            localTextView2 = (TextView)localView.findViewById(h.e.HXM);
            localObject = (ImageView)localView.findViewById(h.e.HXL);
            localTextView1.setText(p.b(this.mContext, localo.IHJ, localTextView1.getTextSize()));
            localTextView2.setText(p.b(this.mContext, localo.IHM.hAP, localTextView2.getTextSize()));
            if (!Util.isNullOrNil(localo.IHM.IGH)) {
              if (localo.IHM.ILN == 1)
              {
                locala.IYr = true;
                locala.npW = h.d.HTq;
                label548:
                com.tencent.mm.plugin.game.d.e.fIb().a((ImageView)localObject, localo.IHM.IGH, locala.fIc());
              }
            }
            for (;;)
            {
              localView.setTag(new a(localo.IHK, localo.IHM.IGI, localo.IHI));
              localView.setOnClickListener(this);
              addView(localView);
              break label112;
              break;
              locala.nrc = true;
              locala.npW = h.d.HTp;
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
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameBlockContentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
    g.a(this.mContext, 10, 1002, paramView.IFU, i, this.mAppId, this.IFc, com.tencent.mm.plugin.game.c.a.EM(paramView.ICw));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameBlockContentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41902);
  }
  
  static final class a
  {
    public String ICw;
    public int IFU;
    public String jumpUrl;
    
    public a(int paramInt, String paramString1, String paramString2)
    {
      this.IFU = paramInt;
      this.jumpUrl = paramString1;
      this.ICw = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.e
 * JD-Core Version:    0.7.0.1
 */