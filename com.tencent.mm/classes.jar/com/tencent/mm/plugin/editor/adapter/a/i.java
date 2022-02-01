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
import com.tencent.mm.plugin.editor.b;
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
  private LinearLayout irQ;
  public LinearLayout olP;
  public LinearLayout olQ;
  public VoiceView olR;
  public ImageView olS;
  private TextView olT;
  private TextView olU;
  private m olV;
  private final ap olW;
  
  public i(View paramView, j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181667);
    this.olW = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(181666);
        if (i.a(i.this).omJ)
        {
          i.b(i.this).removeMessages(4096);
          AppMethodBeat.o(181666);
          return;
        }
        paramAnonymousMessage = " " + b.C(aj.getContext(), i.a(i.this).omL).toString();
        i.c(i.this).setText(paramAnonymousMessage);
        sendEmptyMessageDelayed(4096, 500L);
        AppMethodBeat.o(181666);
      }
    };
    this.irQ = ((LinearLayout)paramView.findViewById(2131302943));
    this.olP = ((LinearLayout)paramView.findViewById(2131302945));
    this.olQ = ((LinearLayout)paramView.findViewById(2131302944));
    this.olS = ((ImageView)paramView.findViewById(2131302946));
    this.olT = ((TextView)paramView.findViewById(2131302948));
    this.olU = ((TextView)paramView.findViewById(2131302949));
    this.olR = ((VoiceView)paramView.findViewById(2131302925));
    this.olR.setVoiceHelper(com.tencent.mm.plugin.editor.widget.voiceview.a.bTH());
    this.irQ.setVisibility(0);
    this.olP.setVisibility(8);
    this.olQ.setVisibility(0);
    this.djK.setVisibility(8);
    this.oln.setVisibility(8);
    this.irQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181665);
        if ((i.a(i.this) != null) && (i.a(i.this).omS.booleanValue())) {
          i.a(i.this).omT = Boolean.TRUE;
        }
        AppMethodBeat.o(181665);
      }
    });
    AppMethodBeat.o(181667);
  }
  
  public final void a(com.tencent.mm.plugin.editor.model.a.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181668);
    this.olV = ((m)parama);
    if (this.olV.omJ)
    {
      this.irQ.setBackgroundResource(0);
      this.olQ.setVisibility(0);
      this.olP.setVisibility(8);
      this.irQ.setPadding(0, 0, 0, 0);
      if (!parama.omC) {
        break label589;
      }
    }
    label304:
    label317:
    label589:
    for (int i = 1;; i = 0)
    {
      Object localObject1 = this.olR;
      Object localObject2 = this.olV.drZ;
      int j = this.olV.dkj;
      int k = this.olV.dkk;
      ((VoiceView)localObject1).path = bt.by((String)localObject2, "");
      ((VoiceView)localObject1).dkj = j;
      ((VoiceView)localObject1).duration = k;
      if (i != 0)
      {
        ((VoiceView)localObject1).lRB.setVisibility(0);
        if (!((VoiceView)localObject1).path.equals(((VoiceView)localObject1).orr.path)) {
          break label317;
        }
        if (!((VoiceView)localObject1).orr.bTK()) {
          break label227;
        }
        ad.i("MicroMsg.NoteVoiceView", "updateInfo .isPlay()");
        localObject2 = ((VoiceView)localObject1).ors;
        ((VoiceView)localObject1).orr.Oa();
        ((VoiceView.a)localObject2).jA(true);
      }
      for (;;)
      {
        super.a(parama, paramInt1, paramInt2);
        AppMethodBeat.o(181668);
        return;
        ((VoiceView)localObject1).lRB.setVisibility(8);
        break;
        label227:
        localObject2 = ((VoiceView)localObject1).orr;
        if (((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject2).org == null) {
          ad.w("MicroMsg.RecordVoiceHelper", "check is pause, but player is null");
        }
        for (boolean bool = false;; bool = ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject2).org.Nb())
        {
          if (!bool) {
            break label304;
          }
          ad.i("MicroMsg.NoteVoiceView", "updateInfo .isPause()");
          localObject2 = ((VoiceView)localObject1).ors;
          ((VoiceView)localObject1).orr.Oa();
          ((VoiceView.a)localObject2).jA(false);
          break;
        }
        ((VoiceView)localObject1).ors.Ah(k);
        continue;
        ((VoiceView)localObject1).ors.Ah(k);
        continue;
        this.irQ.setBackgroundResource(2131231992);
        this.irQ.setPadding(26, 7, 0, 7);
        this.olQ.setVisibility(8);
        this.olP.setVisibility(0);
        localObject1 = this.olS;
        if (((ImageView)localObject1).getAnimation() != null) {
          ((ImageView)localObject1).startAnimation(((ImageView)localObject1).getAnimation());
        }
        for (;;)
        {
          if (!this.olV.omS.booleanValue()) {
            break label527;
          }
          this.olW.sendEmptyMessage(4096);
          this.olT.setText(2131759039);
          localObject1 = " " + b.C(aj.getContext(), this.olV.omL).toString();
          this.olU.setText((CharSequence)localObject1);
          break;
          localObject2 = new AlphaAnimation(1.0F, 0.0F);
          ((Animation)localObject2).setDuration(500L);
          ((Animation)localObject2).setInterpolator(new LinearInterpolator());
          ((Animation)localObject2).setRepeatCount(-1);
          ((Animation)localObject2).setRepeatMode(2);
          ((ImageView)localObject1).startAnimation((Animation)localObject2);
        }
        this.olT.setText(2131759038);
        localObject1 = " " + b.C(aj.getContext(), (int)b.mI(this.olV.dkk)).toString();
        this.olU.setText((CharSequence)localObject1);
      }
    }
  }
  
  public final int bSa()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.i
 * JD-Core Version:    0.7.0.1
 */