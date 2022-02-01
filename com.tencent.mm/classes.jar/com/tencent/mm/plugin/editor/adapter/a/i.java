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
import com.tencent.mm.plugin.editor.d.d;
import com.tencent.mm.plugin.editor.d.e;
import com.tencent.mm.plugin.editor.d.h;
import com.tencent.mm.plugin.editor.model.a.m;
import com.tencent.mm.plugin.editor.widget.voiceview.VoiceView;
import com.tencent.mm.plugin.editor.widget.voiceview.VoiceView.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class i
  extends d
{
  private LinearLayout pZr;
  private TextView xxA;
  private m xxB;
  private final MMHandler xxC;
  public LinearLayout xxv;
  public LinearLayout xxw;
  public VoiceView xxx;
  public ImageView xxy;
  private TextView xxz;
  
  public i(View paramView, com.tencent.mm.plugin.editor.model.nativenote.manager.j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181667);
    this.xxC = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(181666);
        if (i.a(i.this).xyp)
        {
          i.b(i.this).removeMessages(4096);
          AppMethodBeat.o(181666);
          return;
        }
        paramAnonymousMessage = " " + com.tencent.mm.plugin.editor.b.Q(MMApplicationContext.getContext(), i.a(i.this).xyr).toString();
        i.c(i.this).setText(paramAnonymousMessage);
        sendEmptyMessageDelayed(4096, 500L);
        AppMethodBeat.o(181666);
      }
    };
    this.pZr = ((LinearLayout)paramView.findViewById(d.e.fSm));
    this.xxv = ((LinearLayout)paramView.findViewById(d.e.fSo));
    this.xxw = ((LinearLayout)paramView.findViewById(d.e.fSn));
    this.xxy = ((ImageView)paramView.findViewById(d.e.fSp));
    this.xxz = ((TextView)paramView.findViewById(d.e.fSq));
    this.xxA = ((TextView)paramView.findViewById(d.e.fSr));
    this.xxx = ((VoiceView)paramView.findViewById(d.e.fRY));
    this.xxx.setVoiceHelper(com.tencent.mm.plugin.editor.widget.voiceview.a.dxB());
    this.pZr.setVisibility(0);
    this.xxv.setVisibility(8);
    this.xxw.setVisibility(0);
    this.hIz.setVisibility(8);
    this.xwT.setVisibility(8);
    this.pZr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181665);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/adapter/itemholder/EditorVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((i.a(i.this) != null) && (i.a(i.this).xyz.booleanValue())) {
          i.a(i.this).xyA = Boolean.TRUE;
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
    this.xxB = ((m)parama);
    if (this.xxB.xyp)
    {
      this.pZr.setBackgroundResource(0);
      this.xxw.setVisibility(0);
      this.xxv.setVisibility(8);
      this.pZr.setPadding(0, 0, 0, 0);
      if (!parama.xyi) {
        break label593;
      }
    }
    label304:
    label317:
    label593:
    for (int i = 1;; i = 0)
    {
      Object localObject1 = this.xxx;
      Object localObject2 = this.xxB.hTM;
      int j = this.xxB.hIY;
      int k = this.xxB.hIZ;
      ((VoiceView)localObject1).path = Util.nullAs((String)localObject2, "");
      ((VoiceView)localObject1).hIY = j;
      ((VoiceView)localObject1).duration = k;
      if (i != 0)
      {
        ((VoiceView)localObject1).maskView.setVisibility(0);
        if (!((VoiceView)localObject1).path.equals(((VoiceView)localObject1).xDb.path)) {
          break label317;
        }
        if (!((VoiceView)localObject1).xDb.dxE()) {
          break label227;
        }
        Log.i("MicroMsg.NoteVoiceView", "updateInfo .isPlay()");
        localObject2 = ((VoiceView)localObject1).xDc;
        ((VoiceView)localObject1).xDb.aGG();
        ((VoiceView.a)localObject2).nX(true);
      }
      for (;;)
      {
        super.a(parama, paramInt1, paramInt2);
        AppMethodBeat.o(181668);
        return;
        ((VoiceView)localObject1).maskView.setVisibility(8);
        break;
        label227:
        localObject2 = ((VoiceView)localObject1).xDb;
        if (((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject2).xCQ == null) {
          Log.w("MicroMsg.RecordVoiceHelper", "check is pause, but player is null");
        }
        for (boolean bool = false;; bool = ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject2).xCQ.aFF())
        {
          if (!bool) {
            break label304;
          }
          Log.i("MicroMsg.NoteVoiceView", "updateInfo .isPause()");
          localObject2 = ((VoiceView)localObject1).xDc;
          ((VoiceView)localObject1).xDb.aGG();
          ((VoiceView.a)localObject2).nX(false);
          break;
        }
        ((VoiceView)localObject1).xDc.hi(k);
        continue;
        ((VoiceView)localObject1).xDc.hi(k);
        continue;
        this.pZr.setBackgroundResource(d.d.xvX);
        this.pZr.setPadding(26, 7, 0, 7);
        this.xxw.setVisibility(8);
        this.xxv.setVisibility(0);
        localObject1 = this.xxy;
        if (((ImageView)localObject1).getAnimation() != null) {
          ((ImageView)localObject1).startAnimation(((ImageView)localObject1).getAnimation());
        }
        for (;;)
        {
          if (!this.xxB.xyz.booleanValue()) {
            break label530;
          }
          this.xxC.sendEmptyMessage(4096);
          this.xxz.setText(d.h.favorite_wenote_voice_recording);
          localObject1 = " " + com.tencent.mm.plugin.editor.b.Q(MMApplicationContext.getContext(), this.xxB.xyr).toString();
          this.xxA.setText((CharSequence)localObject1);
          break;
          localObject2 = new AlphaAnimation(1.0F, 0.0F);
          ((Animation)localObject2).setDuration(500L);
          ((Animation)localObject2).setInterpolator(new LinearInterpolator());
          ((Animation)localObject2).setRepeatCount(-1);
          ((Animation)localObject2).setRepeatMode(2);
          ((ImageView)localObject1).startAnimation((Animation)localObject2);
        }
        this.xxz.setText(d.h.favorite_wenote_voice_downloading);
        localObject1 = " " + com.tencent.mm.plugin.editor.b.Q(MMApplicationContext.getContext(), (int)com.tencent.mm.plugin.editor.b.jh(this.xxB.hIZ)).toString();
        this.xxA.setText((CharSequence)localObject1);
      }
    }
  }
  
  public final int dvW()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.i
 * JD-Core Version:    0.7.0.1
 */