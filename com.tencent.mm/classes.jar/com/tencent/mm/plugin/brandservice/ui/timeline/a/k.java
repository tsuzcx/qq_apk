package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.v;
import com.tencent.mm.am.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class k
  extends n
{
  public View hIU;
  private Context mContext;
  public View mYI;
  public View mZJ;
  public MMNeat7extView mZK;
  public TextView mZL;
  public View mZM;
  public ImageView mZN;
  public View mZO;
  public ImageView mZP;
  public ImageView mZQ;
  public View mZR;
  public TextView mZS;
  public View mZT;
  public View mZU;
  public TextView mZV;
  private View.OnClickListener mZW;
  
  public k(com.tencent.mm.plugin.brandservice.ui.timeline.c paramc, Context paramContext)
  {
    AppMethodBeat.i(6003);
    this.mZW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6002);
        long l = ((com.tencent.mm.plugin.brandservice.a.a)g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).dv(paramAnonymousView);
        paramAnonymousView = af.awk().vU(l);
        if (paramAnonymousView != null)
        {
          k.this.nao.mWX.c(paramAnonymousView, 4);
          AppMethodBeat.o(6002);
          return;
        }
        ad.w("MicroMsg.BizTimeLineItem", "mediaIconClickListener info is null");
        AppMethodBeat.o(6002);
      }
    };
    super.b(paramContext, paramc);
    this.mContext = paramContext;
    AppMethodBeat.o(6003);
  }
  
  private static void U(View paramView, int paramInt)
  {
    AppMethodBeat.i(6005);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(6005);
  }
  
  public final void a(ImageView paramImageView, s params, int paramInt, String paramString)
  {
    AppMethodBeat.i(6006);
    ((com.tencent.mm.plugin.brandservice.a.a)g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramImageView, params.field_msgId, paramString, params.field_content, paramInt);
    paramImageView.setOnClickListener(this.mZW);
    AppMethodBeat.o(6006);
  }
  
  public final void a(v paramv, s params, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(6004);
    this.mZO.setVisibility(8);
    if (paramv.type == 5)
    {
      this.mZQ.setVisibility(0);
      this.mZQ.setImageResource(2131231270);
      this.mZQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(6001);
          k.this.mYI.performClick();
          AppMethodBeat.o(6001);
        }
      });
    }
    for (;;)
    {
      paramInt = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 28);
      if (paramv.type == 7) {
        paramInt = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 48);
      }
      U(this.mZQ, paramInt);
      AppMethodBeat.o(6004);
      return;
      if (paramv.type == 6)
      {
        this.mZQ.setVisibility(0);
        if (paramBoolean) {
          if ((params.field_msgId + "_" + paramInt).equals(com.tencent.mm.plugin.brandservice.ui.b.c.bGw())) {
            this.mZQ.setImageResource(2131231672);
          }
        }
        for (;;)
        {
          a(this.mZQ, params, paramInt, paramv.gKD);
          break;
          this.mZQ.setImageResource(2131231673);
          continue;
          if ((params.field_msgId + "_" + paramInt).equals(com.tencent.mm.plugin.brandservice.ui.b.c.bGw())) {
            this.mZQ.setImageResource(2131689906);
          } else {
            this.mZQ.setImageResource(2131689909);
          }
        }
      }
      if (paramv.type == 7)
      {
        this.mZQ.setVisibility(8);
        this.mZO.setVisibility(0);
        Drawable localDrawable = this.mZP.getDrawable();
        if (((localDrawable instanceof AnimationDrawable)) && (((AnimationDrawable)localDrawable).isRunning())) {
          ((AnimationDrawable)localDrawable).stop();
        }
        if ((params.field_msgId + "_" + paramInt).equals(com.tencent.mm.plugin.brandservice.ui.b.c.bGw()))
        {
          this.mZP.setImageResource(2131231272);
          if ((this.mZQ.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)this.mZQ.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(this.mZP, params, paramInt, paramv.gKD);
          break;
          this.mZP.setImageResource(2131231271);
        }
      }
      this.mZQ.setVisibility(8);
    }
  }
  
  public final void a(v paramv, boolean paramBoolean)
  {
    AppMethodBeat.i(6007);
    if (paramv.type == 8)
    {
      this.mZT.setVisibility(0);
      if (paramv.gKT > 1)
      {
        this.mZV.setVisibility(0);
        this.mZV.setText(String.valueOf(paramv.gKT));
      }
      while (paramBoolean)
      {
        this.mZU.setBackgroundResource(2131231282);
        AppMethodBeat.o(6007);
        return;
        this.mZV.setVisibility(8);
      }
      this.mZU.setBackgroundResource(2131233299);
      AppMethodBeat.o(6007);
      return;
    }
    this.mZT.setVisibility(8);
    AppMethodBeat.o(6007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.k
 * JD-Core Version:    0.7.0.1
 */