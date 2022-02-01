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
import com.tencent.mm.ak.h;
import com.tencent.mm.plugin.editor.model.a.m;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;
import com.tencent.mm.plugin.editor.widget.voiceview.VoiceView;
import com.tencent.mm.plugin.editor.widget.voiceview.VoiceView.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;

public final class i
  extends d
{
  private LinearLayout jnX;
  public LinearLayout pzD;
  public LinearLayout pzE;
  public VoiceView pzF;
  public ImageView pzG;
  private TextView pzH;
  private TextView pzI;
  private m pzJ;
  private final aq pzK;
  
  public i(View paramView, j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181667);
    this.pzK = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(181666);
        if (i.a(i.this).pAx)
        {
          i.b(i.this).removeMessages(4096);
          AppMethodBeat.o(181666);
          return;
        }
        paramAnonymousMessage = " " + com.tencent.mm.plugin.editor.b.G(ak.getContext(), i.a(i.this).pAz).toString();
        i.c(i.this).setText(paramAnonymousMessage);
        sendEmptyMessageDelayed(4096, 500L);
        AppMethodBeat.o(181666);
      }
    };
    this.jnX = ((LinearLayout)paramView.findViewById(2131302943));
    this.pzD = ((LinearLayout)paramView.findViewById(2131302945));
    this.pzE = ((LinearLayout)paramView.findViewById(2131302944));
    this.pzG = ((ImageView)paramView.findViewById(2131302946));
    this.pzH = ((TextView)paramView.findViewById(2131302948));
    this.pzI = ((TextView)paramView.findViewById(2131302949));
    this.pzF = ((VoiceView)paramView.findViewById(2131302925));
    this.pzF.setVoiceHelper(com.tencent.mm.plugin.editor.widget.voiceview.a.cgP());
    this.jnX.setVisibility(0);
    this.pzD.setVisibility(8);
    this.pzE.setVisibility(0);
    this.dtJ.setVisibility(8);
    this.pzb.setVisibility(8);
    this.jnX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181665);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/itemholder/EditorVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((i.a(i.this) != null) && (i.a(i.this).pAG.booleanValue())) {
          i.a(i.this).pAH = Boolean.TRUE;
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
    this.pzJ = ((m)parama);
    if (this.pzJ.pAx)
    {
      this.jnX.setBackgroundResource(0);
      this.pzE.setVisibility(0);
      this.pzD.setVisibility(8);
      this.jnX.setPadding(0, 0, 0, 0);
      if (!parama.pAq) {
        break label589;
      }
    }
    label304:
    label317:
    label589:
    for (int i = 1;; i = 0)
    {
      Object localObject1 = this.pzF;
      Object localObject2 = this.pzJ.dCC;
      int j = this.pzJ.dui;
      int k = this.pzJ.duj;
      ((VoiceView)localObject1).path = bu.bI((String)localObject2, "");
      ((VoiceView)localObject1).dui = j;
      ((VoiceView)localObject1).duration = k;
      if (i != 0)
      {
        ((VoiceView)localObject1).hcH.setVisibility(0);
        if (!((VoiceView)localObject1).path.equals(((VoiceView)localObject1).pFf.path)) {
          break label317;
        }
        if (!((VoiceView)localObject1).pFf.cgS()) {
          break label227;
        }
        ae.i("MicroMsg.NoteVoiceView", "updateInfo .isPlay()");
        localObject2 = ((VoiceView)localObject1).pFg;
        ((VoiceView)localObject1).pFf.PE();
        ((VoiceView.a)localObject2).kn(true);
      }
      for (;;)
      {
        super.a(parama, paramInt1, paramInt2);
        AppMethodBeat.o(181668);
        return;
        ((VoiceView)localObject1).hcH.setVisibility(8);
        break;
        label227:
        localObject2 = ((VoiceView)localObject1).pFf;
        if (((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject2).pEU == null) {
          ae.w("MicroMsg.RecordVoiceHelper", "check is pause, but player is null");
        }
        for (boolean bool = false;; bool = ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject2).pEU.OG())
        {
          if (!bool) {
            break label304;
          }
          ae.i("MicroMsg.NoteVoiceView", "updateInfo .isPause()");
          localObject2 = ((VoiceView)localObject1).pFg;
          ((VoiceView)localObject1).pFf.PE();
          ((VoiceView.a)localObject2).kn(false);
          break;
        }
        ((VoiceView)localObject1).pFg.BT(k);
        continue;
        ((VoiceView)localObject1).pFg.BT(k);
        continue;
        this.jnX.setBackgroundResource(2131231992);
        this.jnX.setPadding(26, 7, 0, 7);
        this.pzE.setVisibility(8);
        this.pzD.setVisibility(0);
        localObject1 = this.pzG;
        if (((ImageView)localObject1).getAnimation() != null) {
          ((ImageView)localObject1).startAnimation(((ImageView)localObject1).getAnimation());
        }
        for (;;)
        {
          if (!this.pzJ.pAG.booleanValue()) {
            break label527;
          }
          this.pzK.sendEmptyMessage(4096);
          this.pzH.setText(2131759039);
          localObject1 = " " + com.tencent.mm.plugin.editor.b.G(ak.getContext(), this.pzJ.pAz).toString();
          this.pzI.setText((CharSequence)localObject1);
          break;
          localObject2 = new AlphaAnimation(1.0F, 0.0F);
          ((Animation)localObject2).setDuration(500L);
          ((Animation)localObject2).setInterpolator(new LinearInterpolator());
          ((Animation)localObject2).setRepeatCount(-1);
          ((Animation)localObject2).setRepeatMode(2);
          ((ImageView)localObject1).startAnimation((Animation)localObject2);
        }
        this.pzH.setText(2131759038);
        localObject1 = " " + com.tencent.mm.plugin.editor.b.G(ak.getContext(), (int)com.tencent.mm.plugin.editor.b.sI(this.pzJ.duj)).toString();
        this.pzI.setText((CharSequence)localObject1);
      }
    }
  }
  
  public final int cfi()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.i
 * JD-Core Version:    0.7.0.1
 */