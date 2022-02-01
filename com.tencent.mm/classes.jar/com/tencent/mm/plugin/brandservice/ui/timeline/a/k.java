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
import com.tencent.mm.ah.v;
import com.tencent.mm.al.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class k
  extends n
{
  public View ijv;
  private Context mContext;
  public View nBh;
  public View nCh;
  public MMNeat7extView nCi;
  public TextView nCj;
  public View nCk;
  public ImageView nCl;
  public View nCm;
  public ImageView nCn;
  public ImageView nCo;
  public View nCp;
  public TextView nCq;
  public View nCr;
  public View nCs;
  public TextView nCt;
  private View.OnClickListener nCu;
  
  public k(com.tencent.mm.plugin.brandservice.ui.timeline.c paramc, Context paramContext)
  {
    AppMethodBeat.i(6003);
    this.nCu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6002);
        long l = ((com.tencent.mm.plugin.brandservice.a.a)g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).dx(paramAnonymousView);
        paramAnonymousView = af.aDc().Ax(l);
        if (paramAnonymousView != null)
        {
          k.this.nCM.nzw.d(paramAnonymousView, 4);
          AppMethodBeat.o(6002);
          return;
        }
        ac.w("MicroMsg.BizTimeLineItem", "mediaIconClickListener info is null");
        AppMethodBeat.o(6002);
      }
    };
    super.b(paramContext, paramc);
    this.mContext = paramContext;
    AppMethodBeat.o(6003);
  }
  
  private static void V(View paramView, int paramInt)
  {
    AppMethodBeat.i(6005);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(6005);
  }
  
  public final void a(ImageView paramImageView, t paramt, int paramInt, String paramString)
  {
    AppMethodBeat.i(6006);
    ((com.tencent.mm.plugin.brandservice.a.a)g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramImageView, paramt.field_msgId, paramString, paramt.field_content, paramInt);
    paramImageView.setOnClickListener(this.nCu);
    AppMethodBeat.o(6006);
  }
  
  public final void a(v paramv, t paramt, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(6004);
    this.nCm.setVisibility(8);
    if (paramv.type == 5)
    {
      this.nCo.setVisibility(0);
      this.nCo.setImageResource(2131231270);
      this.nCo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(6001);
          k.this.nBh.performClick();
          AppMethodBeat.o(6001);
        }
      });
    }
    for (;;)
    {
      paramInt = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 28);
      if (paramv.type == 7) {
        paramInt = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 48);
      }
      V(this.nCo, paramInt);
      AppMethodBeat.o(6004);
      return;
      if (paramv.type == 6)
      {
        this.nCo.setVisibility(0);
        if (paramBoolean) {
          if ((paramt.field_msgId + "_" + paramInt).equals(com.tencent.mm.plugin.brandservice.ui.b.c.bNJ())) {
            this.nCo.setImageResource(2131231672);
          }
        }
        for (;;)
        {
          a(this.nCo, paramt, paramInt, paramv.hld);
          break;
          this.nCo.setImageResource(2131231673);
          continue;
          if ((paramt.field_msgId + "_" + paramInt).equals(com.tencent.mm.plugin.brandservice.ui.b.c.bNJ())) {
            this.nCo.setImageResource(2131689906);
          } else {
            this.nCo.setImageResource(2131689909);
          }
        }
      }
      if (paramv.type == 7)
      {
        this.nCo.setVisibility(8);
        this.nCm.setVisibility(0);
        Drawable localDrawable = this.nCn.getDrawable();
        if (((localDrawable instanceof AnimationDrawable)) && (((AnimationDrawable)localDrawable).isRunning())) {
          ((AnimationDrawable)localDrawable).stop();
        }
        if ((paramt.field_msgId + "_" + paramInt).equals(com.tencent.mm.plugin.brandservice.ui.b.c.bNJ()))
        {
          this.nCn.setImageResource(2131231272);
          if ((this.nCo.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)this.nCo.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(this.nCn, paramt, paramInt, paramv.hld);
          break;
          this.nCn.setImageResource(2131231271);
        }
      }
      this.nCo.setVisibility(8);
    }
  }
  
  public final void a(v paramv, boolean paramBoolean)
  {
    AppMethodBeat.i(6007);
    if (paramv.type == 8)
    {
      this.nCr.setVisibility(0);
      if (paramv.hlt > 1)
      {
        this.nCt.setVisibility(0);
        this.nCt.setText(String.valueOf(paramv.hlt));
      }
      while (paramBoolean)
      {
        this.nCs.setBackgroundResource(2131231282);
        AppMethodBeat.o(6007);
        return;
        this.nCt.setVisibility(8);
      }
      this.nCs.setBackgroundResource(2131233299);
      AppMethodBeat.o(6007);
      return;
    }
    this.nCr.setVisibility(8);
    AppMethodBeat.o(6007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.k
 * JD-Core Version:    0.7.0.1
 */