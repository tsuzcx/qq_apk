package com.tencent.mm.plugin.editor.adapter.a;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.h;
import com.tencent.mm.plugin.editor.model.a.m;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;
import com.tencent.mm.plugin.editor.widget.voiceview.VoiceView;
import com.tencent.mm.plugin.editor.widget.voiceview.VoiceView.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;

public final class i
  extends d
{
  private LinearLayout jld;
  public LinearLayout psX;
  public LinearLayout psY;
  public VoiceView psZ;
  public ImageView pta;
  private TextView ptb;
  private TextView ptc;
  private m ptd;
  private final ap pte;
  
  public i(View paramView, j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181667);
    this.pte = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(181666);
        if (i.a(i.this).ptT)
        {
          i.b(i.this).removeMessages(4096);
          AppMethodBeat.o(181666);
          return;
        }
        paramAnonymousMessage = " " + com.tencent.mm.plugin.editor.b.G(aj.getContext(), i.a(i.this).ptV).toString();
        i.c(i.this).setText(paramAnonymousMessage);
        sendEmptyMessageDelayed(4096, 500L);
        AppMethodBeat.o(181666);
      }
    };
    this.jld = ((LinearLayout)paramView.findViewById(2131302943));
    this.psX = ((LinearLayout)paramView.findViewById(2131302945));
    this.psY = ((LinearLayout)paramView.findViewById(2131302944));
    this.pta = ((ImageView)paramView.findViewById(2131302946));
    this.ptb = ((TextView)paramView.findViewById(2131302948));
    this.ptc = ((TextView)paramView.findViewById(2131302949));
    this.psZ = ((VoiceView)paramView.findViewById(2131302925));
    this.psZ.setVoiceHelper(com.tencent.mm.plugin.editor.widget.voiceview.a.cfz());
    this.jld.setVisibility(0);
    this.psX.setVisibility(8);
    this.psY.setVisibility(0);
    this.dsD.setVisibility(8);
    this.psv.setVisibility(8);
    this.jld.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181665);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/itemholder/EditorVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((i.a(i.this) != null) && (i.a(i.this).puc.booleanValue())) {
          i.a(i.this).pud = Boolean.TRUE;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181665);
      }
    });
    AppMethodBeat.o(181667);
  }
  
  public final void a(com.tencent.mm.plugin.editor.model.a.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181668);
    this.ptd = ((m)parama);
    if (this.ptd.ptT)
    {
      this.jld.setBackgroundResource(0);
      this.psY.setVisibility(0);
      this.psX.setVisibility(8);
      this.jld.setPadding(0, 0, 0, 0);
      if (!parama.ptM) {
        break label589;
      }
    }
    label304:
    label317:
    label589:
    for (int i = 1;; i = 0)
    {
      Object localObject1 = this.psZ;
      Object localObject2 = this.ptd.dBx;
      int j = this.ptd.dtc;
      int k = this.ptd.dtd;
      ((VoiceView)localObject1).path = bt.bI((String)localObject2, "");
      ((VoiceView)localObject1).dtc = j;
      ((VoiceView)localObject1).duration = k;
      if (i != 0)
      {
        ((VoiceView)localObject1).gZU.setVisibility(0);
        if (!((VoiceView)localObject1).path.equals(((VoiceView)localObject1).pyB.path)) {
          break label317;
        }
        if (!((VoiceView)localObject1).pyB.cfC()) {
          break label227;
        }
        ad.i("MicroMsg.NoteVoiceView", "updateInfo .isPlay()");
        localObject2 = ((VoiceView)localObject1).pyC;
        ((VoiceView)localObject1).pyB.PF();
        ((VoiceView.a)localObject2).ko(true);
      }
      for (;;)
      {
        super.a(parama, paramInt1, paramInt2);
        AppMethodBeat.o(181668);
        return;
        ((VoiceView)localObject1).gZU.setVisibility(8);
        break;
        label227:
        localObject2 = ((VoiceView)localObject1).pyB;
        if (((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject2).pyq == null) {
          ad.w("MicroMsg.RecordVoiceHelper", "check is pause, but player is null");
        }
        for (boolean bool = false;; bool = ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject2).pyq.OI())
        {
          if (!bool) {
            break label304;
          }
          ad.i("MicroMsg.NoteVoiceView", "updateInfo .isPause()");
          localObject2 = ((VoiceView)localObject1).pyC;
          ((VoiceView)localObject1).pyB.PF();
          ((VoiceView.a)localObject2).ko(false);
          break;
        }
        ((VoiceView)localObject1).pyC.BH(k);
        continue;
        ((VoiceView)localObject1).pyC.BH(k);
        continue;
        this.jld.setBackgroundResource(2131231992);
        this.jld.setPadding(26, 7, 0, 7);
        this.psY.setVisibility(8);
        this.psX.setVisibility(0);
        localObject1 = this.pta;
        if (((ImageView)localObject1).getAnimation() != null) {
          ((ImageView)localObject1).startAnimation(((ImageView)localObject1).getAnimation());
        }
        for (;;)
        {
          if (!this.ptd.puc.booleanValue()) {
            break label527;
          }
          this.pte.sendEmptyMessage(4096);
          this.ptb.setText(2131759039);
          localObject1 = " " + com.tencent.mm.plugin.editor.b.G(aj.getContext(), this.ptd.ptV).toString();
          this.ptc.setText((CharSequence)localObject1);
          break;
          localObject2 = new AlphaAnimation(1.0F, 0.0F);
          ((Animation)localObject2).setDuration(500L);
          ((Animation)localObject2).setInterpolator(new LinearInterpolator());
          ((Animation)localObject2).setRepeatCount(-1);
          ((Animation)localObject2).setRepeatMode(2);
          ((ImageView)localObject1).startAnimation((Animation)localObject2);
        }
        this.ptb.setText(2131759038);
        localObject1 = " " + com.tencent.mm.plugin.editor.b.G(aj.getContext(), (int)com.tencent.mm.plugin.editor.b.sv(this.ptd.dtd)).toString();
        this.ptc.setText((CharSequence)localObject1);
      }
    }
  }
  
  public final int cdT()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.i
 * JD-Core Version:    0.7.0.1
 */