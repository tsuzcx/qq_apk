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
import com.tencent.mm.plugin.game.d.af;
import com.tencent.mm.plugin.game.d.db;
import com.tencent.mm.plugin.game.d.i;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.plugin.game.widget.EllipsizingTextView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
  extends LinearLayout
  implements View.OnClickListener
{
  private String mAppId;
  private Context mContext;
  private LayoutInflater mInflater;
  private int nok;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(111736);
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    setOrientation(1);
    AppMethodBeat.o(111736);
  }
  
  private void n(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(111739);
    ImageView localImageView = (ImageView)this.mInflater.inflate(2130969740, paramViewGroup, false);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localImageView.getLayoutParams();
    localMarginLayoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 20);
    localImageView.setLayoutParams(localMarginLayoutParams);
    paramViewGroup.addView(localImageView);
    AppMethodBeat.o(111739);
  }
  
  public final void a(af paramaf, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111737);
    if ((paramaf == null) || (bo.es(paramaf.nrw)))
    {
      setVisibility(8);
      AppMethodBeat.o(111737);
      return;
    }
    this.mAppId = paramString;
    this.nok = paramInt2;
    paramaf = paramaf.nrw.iterator();
    while (paramaf.hasNext())
    {
      i locali = (i)paramaf.next();
      if (locali != null)
      {
        e.a.a locala = new e.a.a();
        label112:
        View localView;
        TextView localTextView1;
        TextView localTextView2;
        Object localObject;
        switch (locali.nqy)
        {
        default: 
          if (paramInt1 == 2) {
            com.tencent.mm.plugin.game.e.a.a(this.mContext, 10, 1002, locali.nqv, paramString, paramInt2, com.tencent.mm.plugin.game.e.a.lR(locali.nqt));
          }
          break;
        case 1: 
          if (locali.nqw != null)
          {
            n(this);
            localView = this.mInflater.inflate(2130969696, this, false);
            localTextView1 = (TextView)localView.findViewById(2131824435);
            localTextView2 = (TextView)localView.findViewById(2131824436);
            localObject = (EllipsizingTextView)localView.findViewById(2131824437);
            ((EllipsizingTextView)localObject).setMaxLines(2);
            ImageView localImageView = (ImageView)localView.findViewById(2131824434);
            localTextView1.setText(j.b(this.mContext, locali.nqu, localTextView1.getTextSize()));
            localTextView2.setText(j.b(this.mContext, locali.nqw.Title, localTextView2.getTextSize()));
            ((EllipsizingTextView)localObject).setText(j.b(this.mContext, locali.nqw.Desc, ((EllipsizingTextView)localObject).getTextSize()));
            if (!bo.isNullOrNil(locali.nqw.npQ)) {
              com.tencent.mm.plugin.game.f.e.bHE().a(localImageView, locali.nqw.npQ, locala.bHF());
            }
            for (;;)
            {
              localView.setTag(new e.a(locali.nqv, locali.nqw.npR, locali.nqt));
              localView.setOnClickListener(this);
              addView(localView);
              break;
              localImageView.setVisibility(8);
            }
          }
          break;
        case 2: 
          if (locali.nqx != null)
          {
            n(this);
            localView = this.mInflater.inflate(2130969697, this, false);
            localTextView1 = (TextView)localView.findViewById(2131824439);
            localTextView2 = (TextView)localView.findViewById(2131824441);
            localObject = (ImageView)localView.findViewById(2131824440);
            localTextView1.setText(j.b(this.mContext, locali.nqu, localTextView1.getTextSize()));
            localTextView2.setText(j.b(this.mContext, locali.nqx.Title, localTextView2.getTextSize()));
            if (!bo.isNullOrNil(locali.nqx.npQ)) {
              if (locali.nqx.nui == 1)
              {
                locala.nEu = true;
                locala.nEx = 2130838966;
                label538:
                com.tencent.mm.plugin.game.f.e.bHE().a((ImageView)localObject, locali.nqx.npQ, locala.bHF());
              }
            }
            for (;;)
            {
              localView.setTag(new e.a(locali.nqv, locali.nqx.npR, locali.nqt));
              localView.setOnClickListener(this);
              addView(localView);
              break label112;
              break;
              locala.eOk = true;
              locala.nEx = 2130838965;
              break label538;
              ((ImageView)localObject).setVisibility(8);
            }
          }
          break;
        }
      }
    }
    AppMethodBeat.o(111737);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111738);
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof e.a)))
    {
      ab.w("MicroMsg.GameBlockContentView", "getTag is null");
      AppMethodBeat.o(111738);
      return;
    }
    paramView = (e.a)paramView.getTag();
    if (bo.isNullOrNil(paramView.jumpUrl))
    {
      ab.w("MicroMsg.GameBlockContentView", "jumpUrl is null");
      AppMethodBeat.o(111738);
      return;
    }
    int i = com.tencent.mm.plugin.game.f.c.t(this.mContext, paramView.jumpUrl, "game_center_mygame_comm");
    com.tencent.mm.game.report.c.a(this.mContext, 10, 1002, paramView.npg, i, this.mAppId, this.nok, com.tencent.mm.plugin.game.e.a.lR(paramView.nml));
    AppMethodBeat.o(111738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.e
 * JD-Core Version:    0.7.0.1
 */