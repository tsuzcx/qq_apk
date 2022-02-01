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
import com.tencent.mm.ak.k;
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
  private LinearLayout kmg;
  public LinearLayout qOU;
  public LinearLayout qOV;
  public VoiceView qOW;
  public ImageView qOX;
  private TextView qOY;
  private TextView qOZ;
  private m qPa;
  private final MMHandler qPb;
  
  public i(View paramView, j paramj)
  {
    super(paramView, paramj);
    AppMethodBeat.i(181667);
    this.qPb = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(181666);
        if (i.a(i.this).qPO)
        {
          i.b(i.this).removeMessages(4096);
          AppMethodBeat.o(181666);
          return;
        }
        paramAnonymousMessage = " " + com.tencent.mm.plugin.editor.b.J(MMApplicationContext.getContext(), i.a(i.this).qPQ).toString();
        i.c(i.this).setText(paramAnonymousMessage);
        sendEmptyMessageDelayed(4096, 500L);
        AppMethodBeat.o(181666);
      }
    };
    this.kmg = ((LinearLayout)paramView.findViewById(2131305530));
    this.qOU = ((LinearLayout)paramView.findViewById(2131305532));
    this.qOV = ((LinearLayout)paramView.findViewById(2131305531));
    this.qOX = ((ImageView)paramView.findViewById(2131305533));
    this.qOY = ((TextView)paramView.findViewById(2131305535));
    this.qOZ = ((TextView)paramView.findViewById(2131305536));
    this.qOW = ((VoiceView)paramView.findViewById(2131305512));
    this.qOW.setVoiceHelper(com.tencent.mm.plugin.editor.widget.voiceview.a.cEC());
    this.kmg.setVisibility(0);
    this.qOU.setVisibility(8);
    this.qOV.setVisibility(0);
    this.dKU.setVisibility(8);
    this.qOs.setVisibility(8);
    this.kmg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181665);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/itemholder/EditorVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((i.a(i.this) != null) && (i.a(i.this).qPX.booleanValue())) {
          i.a(i.this).qPY = Boolean.TRUE;
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
    this.qPa = ((m)parama);
    if (this.qPa.qPO)
    {
      this.kmg.setBackgroundResource(0);
      this.qOV.setVisibility(0);
      this.qOU.setVisibility(8);
      this.kmg.setPadding(0, 0, 0, 0);
      if (!parama.qPH) {
        break label589;
      }
    }
    label304:
    label317:
    label589:
    for (int i = 1;; i = 0)
    {
      Object localObject1 = this.qOW;
      Object localObject2 = this.qPa.dUs;
      int j = this.qPa.dLt;
      int k = this.qPa.dLu;
      ((VoiceView)localObject1).path = Util.nullAs((String)localObject2, "");
      ((VoiceView)localObject1).dLt = j;
      ((VoiceView)localObject1).duration = k;
      if (i != 0)
      {
        ((VoiceView)localObject1).maskView.setVisibility(0);
        if (!((VoiceView)localObject1).path.equals(((VoiceView)localObject1).qUw.path)) {
          break label317;
        }
        if (!((VoiceView)localObject1).qUw.cEF()) {
          break label227;
        }
        Log.i("MicroMsg.NoteVoiceView", "updateInfo .isPlay()");
        localObject2 = ((VoiceView)localObject1).qUx;
        ((VoiceView)localObject1).qUw.ZY();
        ((VoiceView.a)localObject2).lp(true);
      }
      for (;;)
      {
        super.a(parama, paramInt1, paramInt2);
        AppMethodBeat.o(181668);
        return;
        ((VoiceView)localObject1).maskView.setVisibility(8);
        break;
        label227:
        localObject2 = ((VoiceView)localObject1).qUw;
        if (((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject2).qUl == null) {
          Log.w("MicroMsg.RecordVoiceHelper", "check is pause, but player is null");
        }
        for (boolean bool = false;; bool = ((com.tencent.mm.plugin.editor.widget.voiceview.a)localObject2).qUl.YY())
        {
          if (!bool) {
            break label304;
          }
          Log.i("MicroMsg.NoteVoiceView", "updateInfo .isPause()");
          localObject2 = ((VoiceView)localObject1).qUx;
          ((VoiceView)localObject1).qUw.ZY();
          ((VoiceView.a)localObject2).lp(false);
          break;
        }
        ((VoiceView)localObject1).qUx.FD(k);
        continue;
        ((VoiceView)localObject1).qUx.FD(k);
        continue;
        this.kmg.setBackgroundResource(2131232083);
        this.kmg.setPadding(26, 7, 0, 7);
        this.qOV.setVisibility(8);
        this.qOU.setVisibility(0);
        localObject1 = this.qOX;
        if (((ImageView)localObject1).getAnimation() != null) {
          ((ImageView)localObject1).startAnimation(((ImageView)localObject1).getAnimation());
        }
        for (;;)
        {
          if (!this.qPa.qPX.booleanValue()) {
            break label527;
          }
          this.qPb.sendEmptyMessage(4096);
          this.qOY.setText(2131759365);
          localObject1 = " " + com.tencent.mm.plugin.editor.b.J(MMApplicationContext.getContext(), this.qPa.qPQ).toString();
          this.qOZ.setText((CharSequence)localObject1);
          break;
          localObject2 = new AlphaAnimation(1.0F, 0.0F);
          ((Animation)localObject2).setDuration(500L);
          ((Animation)localObject2).setInterpolator(new LinearInterpolator());
          ((Animation)localObject2).setRepeatCount(-1);
          ((Animation)localObject2).setRepeatMode(2);
          ((ImageView)localObject1).startAnimation((Animation)localObject2);
        }
        this.qOY.setText(2131759364);
        localObject1 = " " + com.tencent.mm.plugin.editor.b.J(MMApplicationContext.getContext(), (int)com.tencent.mm.plugin.editor.b.AO(this.qPa.dLu)).toString();
        this.qOZ.setText((CharSequence)localObject1);
      }
    }
  }
  
  public final int cCY()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.i
 * JD-Core Version:    0.7.0.1
 */