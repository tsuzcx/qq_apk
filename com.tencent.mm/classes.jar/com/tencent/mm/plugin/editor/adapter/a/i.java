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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;

public final class i
  extends d
{
  private LinearLayout iRV;
  public LinearLayout oPp;
  public LinearLayout oPq;
  public VoiceView oPr;
  public ImageView oPs;
  private TextView oPt;
  private TextView oPu;
  private m oPv;
  private final ao oPw;
  
  public i(View paramView, j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181667);
    this.oPw = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(181666);
        if (i.a(i.this).oQj)
        {
          i.b(i.this).removeMessages(4096);
          AppMethodBeat.o(181666);
          return;
        }
        paramAnonymousMessage = " " + b.F(ai.getContext(), i.a(i.this).oQl).toString();
        i.c(i.this).setText(paramAnonymousMessage);
        sendEmptyMessageDelayed(4096, 500L);
        AppMethodBeat.o(181666);
      }
    };
    this.iRV = ((LinearLayout)paramView.findViewById(2131302943));
    this.oPp = ((LinearLayout)paramView.findViewById(2131302945));
    this.oPq = ((LinearLayout)paramView.findViewById(2131302944));
    this.oPs = ((ImageView)paramView.findViewById(2131302946));
    this.oPt = ((TextView)paramView.findViewById(2131302948));
    this.oPu = ((TextView)paramView.findViewById(2131302949));
    this.oPr = ((VoiceView)paramView.findViewById(2131302925));
    this.oPr.setVoiceHelper(com.tencent.mm.plugin.editor.widget.voiceview.a.caV());
    this.iRV.setVisibility(0);
    this.oPp.setVisibility(8);
    this.oPq.setVisibility(0);
    this.dhf.setVisibility(8);
    this.oON.setVisibility(8);
    this.iRV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181665);
        if ((i.a(i.this) != null) && (i.a(i.this).oQs.booleanValue())) {
          i.a(i.this).oQt = Boolean.TRUE;
        }
        AppMethodBeat.o(181665);
      }
    });
    AppMethodBeat.o(181667);
  }
  
  public final void a(com.tencent.mm.plugin.editor.model.a.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181668);
    this.oPv = ((m)parama);
    if (this.oPv.oQj)
    {
      this.iRV.setBackgroundResource(0);
      this.oPq.setVisibility(0);
      this.oPp.setVisibility(8);
      this.iRV.setPadding(0, 0, 0, 0);
      if (!parama.oQc) {
        break label589;
      }
    }
    label304:
    label317:
    label589:
    for (int i = 1;; i = 0)
    {
      Object localObject1 = this.oPr;
      Object localObject2 = this.oPv.dpK;
      int j = this.oPv.dhE;
      int k = this.oPv.dhF;
      ((VoiceView)localObject1).path = bs.bG((String)localObject2, "");
      ((VoiceView)localObject1).dhE = j;
      ((VoiceView)localObject1).duration = k;
      if (i != 0)
      {
        ((VoiceView)localObject1).gGk.setVisibility(0);
        if (!((VoiceView)localObject1).path.equals(((VoiceView)localObject1).oUR.path)) {
          break label317;
        }
        if (!((VoiceView)localObject1).oUR.caY()) {
          break label227;
        }
        ac.i("MicroMsg.NoteVoiceView", "updateInfo .isPlay()");
        localObject2 = ((VoiceView)localObject1).oUS;
        ((VoiceView)localObject1).oUR.NW();
        ((VoiceView.a)localObject2).kd(true);
      }
      for (;;)
      {
        super.a(parama, paramInt1, paramInt2);
        AppMethodBeat.o(181668);
        return;
        ((VoiceView)localObject1).gGk.setVisibility(8);
        break;
        label227:
        localObject2 = ((VoiceView)localObject1).oUR;
        if (((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject2).oUG == null) {
          ac.w("MicroMsg.RecordVoiceHelper", "check is pause, but player is null");
        }
        for (boolean bool = false;; bool = ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject2).oUG.MZ())
        {
          if (!bool) {
            break label304;
          }
          ac.i("MicroMsg.NoteVoiceView", "updateInfo .isPause()");
          localObject2 = ((VoiceView)localObject1).oUS;
          ((VoiceView)localObject1).oUR.NW();
          ((VoiceView.a)localObject2).kd(false);
          break;
        }
        ((VoiceView)localObject1).oUS.AZ(k);
        continue;
        ((VoiceView)localObject1).oUS.AZ(k);
        continue;
        this.iRV.setBackgroundResource(2131231992);
        this.iRV.setPadding(26, 7, 0, 7);
        this.oPq.setVisibility(8);
        this.oPp.setVisibility(0);
        localObject1 = this.oPs;
        if (((ImageView)localObject1).getAnimation() != null) {
          ((ImageView)localObject1).startAnimation(((ImageView)localObject1).getAnimation());
        }
        for (;;)
        {
          if (!this.oPv.oQs.booleanValue()) {
            break label527;
          }
          this.oPw.sendEmptyMessage(4096);
          this.oPt.setText(2131759039);
          localObject1 = " " + b.F(ai.getContext(), this.oPv.oQl).toString();
          this.oPu.setText((CharSequence)localObject1);
          break;
          localObject2 = new AlphaAnimation(1.0F, 0.0F);
          ((Animation)localObject2).setDuration(500L);
          ((Animation)localObject2).setInterpolator(new LinearInterpolator());
          ((Animation)localObject2).setRepeatCount(-1);
          ((Animation)localObject2).setRepeatMode(2);
          ((ImageView)localObject1).startAnimation((Animation)localObject2);
        }
        this.oPt.setText(2131759038);
        localObject1 = " " + b.F(ai.getContext(), (int)b.qw(this.oPv.dhF)).toString();
        this.oPu.setText((CharSequence)localObject1);
      }
    }
  }
  
  public final int bZp()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.i
 * JD-Core Version:    0.7.0.1
 */