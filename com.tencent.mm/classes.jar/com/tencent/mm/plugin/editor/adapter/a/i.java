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
import com.tencent.mm.an.k;
import com.tencent.mm.plugin.editor.d.d;
import com.tencent.mm.plugin.editor.d.e;
import com.tencent.mm.plugin.editor.d.h;
import com.tencent.mm.plugin.editor.model.a.m;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;
import com.tencent.mm.plugin.editor.widget.voiceview.VoiceView;
import com.tencent.mm.plugin.editor.widget.voiceview.VoiceView.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class i
  extends d
{
  private LinearLayout ndX;
  public LinearLayout uqY;
  public LinearLayout uqZ;
  public VoiceView ura;
  public ImageView urb;
  private TextView urc;
  private TextView urd;
  private m ure;
  private final MMHandler urf;
  
  public i(View paramView, j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181667);
    this.urf = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(181666);
        if (i.a(i.this).urU)
        {
          i.b(i.this).removeMessages(4096);
          AppMethodBeat.o(181666);
          return;
        }
        paramAnonymousMessage = " " + com.tencent.mm.plugin.editor.b.N(MMApplicationContext.getContext(), i.a(i.this).urW).toString();
        i.c(i.this).setText(paramAnonymousMessage);
        sendEmptyMessageDelayed(4096, 500L);
        AppMethodBeat.o(181666);
      }
    };
    this.ndX = ((LinearLayout)paramView.findViewById(d.e.dQh));
    this.uqY = ((LinearLayout)paramView.findViewById(d.e.dQj));
    this.uqZ = ((LinearLayout)paramView.findViewById(d.e.dQi));
    this.urb = ((ImageView)paramView.findViewById(d.e.dQk));
    this.urc = ((TextView)paramView.findViewById(d.e.dQl));
    this.urd = ((TextView)paramView.findViewById(d.e.dQm));
    this.ura = ((VoiceView)paramView.findViewById(d.e.dPT));
    this.ura.setVoiceHelper(com.tencent.mm.plugin.editor.widget.voiceview.a.cTi());
    this.ndX.setVisibility(0);
    this.uqY.setVisibility(8);
    this.uqZ.setVisibility(0);
    this.fDJ.setVisibility(8);
    this.uqw.setVisibility(8);
    this.ndX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181665);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/adapter/itemholder/EditorVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((i.a(i.this) != null) && (i.a(i.this).usd.booleanValue())) {
          i.a(i.this).use = Boolean.TRUE;
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
    this.ure = ((m)parama);
    if (this.ure.urU)
    {
      this.ndX.setBackgroundResource(0);
      this.uqZ.setVisibility(0);
      this.uqY.setVisibility(8);
      this.ndX.setPadding(0, 0, 0, 0);
      if (!parama.urN) {
        break label593;
      }
    }
    label304:
    label317:
    label593:
    for (int i = 1;; i = 0)
    {
      Object localObject1 = this.ura;
      Object localObject2 = this.ure.fNU;
      int j = this.ure.fEi;
      int k = this.ure.fEj;
      ((VoiceView)localObject1).path = Util.nullAs((String)localObject2, "");
      ((VoiceView)localObject1).fEi = j;
      ((VoiceView)localObject1).duration = k;
      if (i != 0)
      {
        ((VoiceView)localObject1).maskView.setVisibility(0);
        if (!((VoiceView)localObject1).path.equals(((VoiceView)localObject1).uwC.path)) {
          break label317;
        }
        if (!((VoiceView)localObject1).uwC.cTl()) {
          break label227;
        }
        Log.i("MicroMsg.NoteVoiceView", "updateInfo .isPlay()");
        localObject2 = ((VoiceView)localObject1).uwD;
        ((VoiceView)localObject1).uwC.aeI();
        ((VoiceView.a)localObject2).mB(true);
      }
      for (;;)
      {
        super.a(parama, paramInt1, paramInt2);
        AppMethodBeat.o(181668);
        return;
        ((VoiceView)localObject1).maskView.setVisibility(8);
        break;
        label227:
        localObject2 = ((VoiceView)localObject1).uwC;
        if (((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject2).uwr == null) {
          Log.w("MicroMsg.RecordVoiceHelper", "check is pause, but player is null");
        }
        for (boolean bool = false;; bool = ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject2).uwr.adH())
        {
          if (!bool) {
            break label304;
          }
          Log.i("MicroMsg.NoteVoiceView", "updateInfo .isPause()");
          localObject2 = ((VoiceView)localObject1).uwD;
          ((VoiceView)localObject1).uwC.aeI();
          ((VoiceView.a)localObject2).mB(false);
          break;
        }
        ((VoiceView)localObject1).uwD.Jl(k);
        continue;
        ((VoiceView)localObject1).uwD.Jl(k);
        continue;
        this.ndX.setBackgroundResource(d.d.upA);
        this.ndX.setPadding(26, 7, 0, 7);
        this.uqZ.setVisibility(8);
        this.uqY.setVisibility(0);
        localObject1 = this.urb;
        if (((ImageView)localObject1).getAnimation() != null) {
          ((ImageView)localObject1).startAnimation(((ImageView)localObject1).getAnimation());
        }
        for (;;)
        {
          if (!this.ure.usd.booleanValue()) {
            break label530;
          }
          this.urf.sendEmptyMessage(4096);
          this.urc.setText(d.h.favorite_wenote_voice_recording);
          localObject1 = " " + com.tencent.mm.plugin.editor.b.N(MMApplicationContext.getContext(), this.ure.urW).toString();
          this.urd.setText((CharSequence)localObject1);
          break;
          localObject2 = new AlphaAnimation(1.0F, 0.0F);
          ((Animation)localObject2).setDuration(500L);
          ((Animation)localObject2).setInterpolator(new LinearInterpolator());
          ((Animation)localObject2).setRepeatCount(-1);
          ((Animation)localObject2).setRepeatMode(2);
          ((ImageView)localObject1).startAnimation((Animation)localObject2);
        }
        this.urc.setText(d.h.favorite_wenote_voice_downloading);
        localObject1 = " " + com.tencent.mm.plugin.editor.b.N(MMApplicationContext.getContext(), (int)com.tencent.mm.plugin.editor.b.GW(this.ure.fEj)).toString();
        this.urd.setText((CharSequence)localObject1);
      }
    }
  }
  
  public final int cRD()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.i
 * JD-Core Version:    0.7.0.1
 */