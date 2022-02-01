package com.tencent.mm.plugin.brandservice.ui.timeline.item;

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
import com.tencent.mm.am.ag;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class w
  extends z
{
  public View iCM;
  private Context mContext;
  public View ocG;
  public TextView ocH;
  public ImageView ocn;
  public View odh;
  public View oeQ;
  public MMNeat7extView oeR;
  public TextView oeS;
  public View oeT;
  public View oeU;
  public ImageView oeV;
  public ImageView oeW;
  public View oeX;
  public View oeY;
  public TextView oeZ;
  private View.OnClickListener ofa;
  
  public w(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(6003);
    this.ofa = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6002);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        long l = ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).dz(paramAnonymousView);
        paramAnonymousView = ag.aGf().M(l, "msgId");
        if (paramAnonymousView != null) {
          w.this.ofm.oaB.d(paramAnonymousView, 4);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(6002);
          return;
          ad.w("MicroMsg.BizTimeLineItem", "mediaIconClickListener info is null");
        }
      }
    };
    super.b(paramContext, paramb);
    this.mContext = paramContext;
    AppMethodBeat.o(6003);
  }
  
  private static void W(View paramView, int paramInt)
  {
    AppMethodBeat.i(6005);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(6005);
  }
  
  public final void a(ImageView paramImageView, com.tencent.mm.storage.w paramw, int paramInt, String paramString)
  {
    AppMethodBeat.i(6006);
    ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramImageView, paramw.field_msgId, paramString, paramw.field_content, paramInt);
    paramImageView.setOnClickListener(this.ofa);
    AppMethodBeat.o(6006);
  }
  
  public final void a(v paramv, com.tencent.mm.storage.w paramw, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(6004);
    this.oeU.setVisibility(8);
    if (paramv.type == 5)
    {
      this.oeW.setVisibility(0);
      this.oeW.setImageResource(2131231270);
      this.oeW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(6001);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          w.this.odh.performClick();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
      W(this.oeW, paramInt);
      AppMethodBeat.o(6004);
      return;
      if (paramv.type == 6)
      {
        this.oeW.setVisibility(0);
        if (paramBoolean) {
          if ((paramw.field_msgId + "_" + paramInt).equals(c.bSj())) {
            this.oeW.setImageResource(2131231672);
          }
        }
        for (;;)
        {
          a(this.oeW, paramw, paramInt, paramv.hDm);
          break;
          this.oeW.setImageResource(2131231673);
          continue;
          if ((paramw.field_msgId + "_" + paramInt).equals(c.bSj())) {
            this.oeW.setImageResource(2131689906);
          } else {
            this.oeW.setImageResource(2131689909);
          }
        }
      }
      if (paramv.type == 7)
      {
        this.oeW.setVisibility(8);
        this.oeU.setVisibility(0);
        Drawable localDrawable = this.oeV.getDrawable();
        if (((localDrawable instanceof AnimationDrawable)) && (((AnimationDrawable)localDrawable).isRunning())) {
          ((AnimationDrawable)localDrawable).stop();
        }
        if ((paramw.field_msgId + "_" + paramInt).equals(c.bSj()))
        {
          this.oeV.setImageResource(2131231272);
          if ((this.oeW.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)this.oeW.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(this.oeV, paramw, paramInt, paramv.hDm);
          break;
          this.oeV.setImageResource(2131231271);
        }
      }
      this.oeW.setVisibility(8);
    }
  }
  
  public final void a(v paramv, boolean paramBoolean)
  {
    AppMethodBeat.i(6007);
    if (paramv.type == 8)
    {
      this.oeX.setVisibility(0);
      if (paramv.hDC > 1)
      {
        this.oeZ.setVisibility(0);
        this.oeZ.setText(String.valueOf(paramv.hDC));
      }
      while (paramBoolean)
      {
        this.oeY.setBackgroundResource(2131231282);
        AppMethodBeat.o(6007);
        return;
        this.oeZ.setVisibility(8);
      }
      this.oeY.setBackgroundResource(2131233299);
      AppMethodBeat.o(6007);
      return;
    }
    this.oeX.setVisibility(8);
    AppMethodBeat.o(6007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.w
 * JD-Core Version:    0.7.0.1
 */