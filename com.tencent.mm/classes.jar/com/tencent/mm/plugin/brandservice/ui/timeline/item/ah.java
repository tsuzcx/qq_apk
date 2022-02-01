package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.v;
import com.tencent.mm.al.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class ah
  extends aj
{
  public View jBI;
  private Context mContext;
  public ImageView ptE;
  public View ptX;
  public TextView ptY;
  public TextView puD;
  public View puO;
  public View pxo;
  public MMNeat7extView pxp;
  public TextView pxq;
  public View pxr;
  public View pxs;
  public ImageView pxt;
  public ImageView pxu;
  public View pxv;
  public View pxw;
  private View.OnClickListener pxx;
  
  public ah(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    AppMethodBeat.i(6003);
    this.pxx = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(6002);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        long l = ((com.tencent.mm.plugin.brandservice.a.a)g.af(com.tencent.mm.plugin.brandservice.a.a.class)).dq(paramAnonymousView);
        paramAnonymousView = ag.ban().R(l, "msgId");
        if (paramAnonymousView != null) {
          ah.this.pxE.pqZ.f(paramAnonymousView, 4);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(6002);
          return;
          Log.w("MicroMsg.BizTimeLineItem", "mediaIconClickListener info is null");
        }
      }
    };
    super.a(paramContext, paramb);
    this.mContext = paramContext;
    AppMethodBeat.o(6003);
  }
  
  public final void a(ImageView paramImageView, z paramz, int paramInt, String paramString)
  {
    AppMethodBeat.i(6006);
    ((com.tencent.mm.plugin.brandservice.a.a)g.af(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramImageView, paramz.field_msgId, paramString, paramz.field_content, paramInt);
    paramImageView.setOnClickListener(this.pxx);
    AppMethodBeat.o(6006);
  }
  
  public final void a(v paramv, z paramz, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(6004);
    this.pxs.setVisibility(8);
    if (paramv.type == 5)
    {
      this.pxu.setVisibility(0);
      this.pxu.setImageResource(2131231330);
      this.pxu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(6001);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          ah.this.puO.performClick();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(6001);
        }
      });
    }
    for (;;)
    {
      paramInt = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 28);
      if (paramv.type == 7) {
        paramInt = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 48);
      }
      paramv = this.pxu;
      paramz = paramv.getLayoutParams();
      paramz.width = paramInt;
      paramz.height = paramInt;
      paramv.setLayoutParams(paramz);
      AppMethodBeat.o(6004);
      return;
      if (paramv.type == 6)
      {
        this.pxu.setVisibility(0);
        if (paramBoolean) {
          if ((paramz.field_msgId + "_" + paramInt).equals(c.crh())) {
            this.pxu.setImageResource(2131231738);
          }
        }
        for (;;)
        {
          a(this.pxu, paramz, paramInt, paramv.iAo);
          break;
          this.pxu.setImageResource(2131231739);
          continue;
          if ((paramz.field_msgId + "_" + paramInt).equals(c.crh())) {
            this.pxu.setImageResource(2131689921);
          } else {
            this.pxu.setImageResource(2131689924);
          }
        }
      }
      if (paramv.type == 7)
      {
        this.pxu.setVisibility(8);
        this.pxs.setVisibility(0);
        Drawable localDrawable = this.pxt.getDrawable();
        if (((localDrawable instanceof AnimationDrawable)) && (((AnimationDrawable)localDrawable).isRunning())) {
          ((AnimationDrawable)localDrawable).stop();
        }
        if ((paramz.field_msgId + "_" + paramInt).equals(c.crh()))
        {
          this.pxt.setImageResource(2131231332);
          if ((this.pxu.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)this.pxu.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(this.pxt, paramz, paramInt, paramv.iAo);
          break;
          this.pxt.setImageResource(2131231331);
        }
      }
      this.pxu.setVisibility(8);
    }
  }
  
  public void a(v paramv, boolean paramBoolean)
  {
    AppMethodBeat.i(6007);
    if (paramv.type == 8)
    {
      this.pxv.setVisibility(0);
      if (paramv.iAC > 1)
      {
        this.puD.setVisibility(0);
        this.puD.setText(String.valueOf(paramv.iAC));
      }
      while (paramBoolean)
      {
        this.pxw.setBackgroundResource(2131231342);
        AppMethodBeat.o(6007);
        return;
        this.puD.setVisibility(8);
      }
      this.pxw.setBackgroundResource(2131233974);
      AppMethodBeat.o(6007);
      return;
    }
    this.pxv.setVisibility(8);
    AppMethodBeat.o(6007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ah
 * JD-Core Version:    0.7.0.1
 */