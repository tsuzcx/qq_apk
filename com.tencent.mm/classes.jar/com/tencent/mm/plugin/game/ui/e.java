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
import com.tencent.mm.plugin.game.d.ah;
import com.tencent.mm.plugin.game.d.b;
import com.tencent.mm.plugin.game.d.dc;
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
  private int rXI;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(41900);
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    setOrientation(1);
    AppMethodBeat.o(41900);
  }
  
  private void q(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(41903);
    ImageView localImageView = (ImageView)this.mInflater.inflate(2131494293, paramViewGroup, false);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localImageView.getLayoutParams();
    localMarginLayoutParams.leftMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 20);
    localImageView.setLayoutParams(localMarginLayoutParams);
    paramViewGroup.addView(localImageView);
    AppMethodBeat.o(41903);
  }
  
  public final void a(ah paramah, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41901);
    if ((paramah == null) || (bt.gL(paramah.saZ)))
    {
      setVisibility(8);
      AppMethodBeat.o(41901);
      return;
    }
    this.mAppId = paramString;
    this.rXI = paramInt2;
    paramah = paramah.saZ.iterator();
    while (paramah.hasNext())
    {
      com.tencent.mm.plugin.game.d.k localk = (com.tencent.mm.plugin.game.d.k)paramah.next();
      if (localk != null)
      {
        e.a.a locala = new e.a.a();
        label112:
        View localView;
        TextView localTextView1;
        TextView localTextView2;
        Object localObject;
        switch (localk.sab)
        {
        default: 
          if (paramInt1 == 2) {
            com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1002, localk.rZY, paramString, paramInt2, com.tencent.mm.plugin.game.e.a.qh(localk.rZW));
          }
          break;
        case 1: 
          if (localk.rZZ != null)
          {
            q(this);
            localView = this.mInflater.inflate(2131494248, this, false);
            localTextView1 = (TextView)localView.findViewById(2131302568);
            localTextView2 = (TextView)localView.findViewById(2131302570);
            localObject = (EllipsizingTextView)localView.findViewById(2131302567);
            ((EllipsizingTextView)localObject).setMaxLines(2);
            ImageView localImageView = (ImageView)localView.findViewById(2131302569);
            localTextView1.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, localk.rZX, localTextView1.getTextSize()));
            localTextView2.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, localk.rZZ.Title, localTextView2.getTextSize()));
            ((EllipsizingTextView)localObject).setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, localk.rZZ.Desc, ((EllipsizingTextView)localObject).getTextSize()));
            if (!bt.isNullOrNil(localk.rZZ.rZn)) {
              com.tencent.mm.plugin.game.f.e.cEB().a(localImageView, localk.rZZ.rZn, locala.cEC());
            }
            for (;;)
            {
              localView.setTag(new a(localk.rZY, localk.rZZ.rZo, localk.rZW));
              localView.setOnClickListener(this);
              addView(localView);
              break;
              localImageView.setVisibility(8);
            }
          }
          break;
        case 2: 
          if (localk.saa != null)
          {
            q(this);
            localView = this.mInflater.inflate(2131494249, this, false);
            localTextView1 = (TextView)localView.findViewById(2131304833);
            localTextView2 = (TextView)localView.findViewById(2131304835);
            localObject = (ImageView)localView.findViewById(2131304834);
            localTextView1.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, localk.rZX, localTextView1.getTextSize()));
            localTextView2.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, localk.saa.Title, localTextView2.getTextSize()));
            if (!bt.isNullOrNil(localk.saa.rZn)) {
              if (localk.saa.sdL == 1)
              {
                locala.soD = true;
                locala.gjx = 2131232501;
                label538:
                com.tencent.mm.plugin.game.f.e.cEB().a((ImageView)localObject, localk.saa.rZn, locala.cEC());
              }
            }
            for (;;)
            {
              localView.setTag(new a(localk.rZY, localk.saa.rZo, localk.rZW));
              localView.setOnClickListener(this);
              addView(localView);
              break label112;
              break;
              locala.gkG = true;
              locala.gjx = 2131232500;
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
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      ad.w("MicroMsg.GameBlockContentView", "getTag is null");
      AppMethodBeat.o(41902);
      return;
    }
    paramView = (a)paramView.getTag();
    if (bt.isNullOrNil(paramView.jumpUrl))
    {
      ad.w("MicroMsg.GameBlockContentView", "jumpUrl is null");
      AppMethodBeat.o(41902);
      return;
    }
    int i = c.A(this.mContext, paramView.jumpUrl, "game_center_mygame_comm");
    com.tencent.mm.game.report.e.a(this.mContext, 10, 1002, paramView.rYB, i, this.mAppId, this.rXI, com.tencent.mm.plugin.game.e.a.qh(paramView.rVj));
    AppMethodBeat.o(41902);
  }
  
  static final class a
  {
    public String jumpUrl;
    public String rVj;
    public int rYB;
    
    public a(int paramInt, String paramString1, String paramString2)
    {
      this.rYB = paramInt;
      this.jumpUrl = paramString1;
      this.rVj = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.e
 * JD-Core Version:    0.7.0.1
 */