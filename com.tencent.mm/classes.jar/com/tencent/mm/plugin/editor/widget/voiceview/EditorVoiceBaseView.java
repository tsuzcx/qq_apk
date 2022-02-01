package com.tencent.mm.plugin.editor.widget.voiceview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.editor.d.g;
import com.tencent.mm.plugin.editor.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;

public class EditorVoiceBaseView
  extends TextView
  implements a.a
{
  private Context context;
  private int duration;
  private int fEi;
  private boolean isRunning;
  private String path;
  private AlphaAnimation uwn;
  private AnimationDrawable uwo;
  
  public EditorVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(181995);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    buR();
    AppMethodBeat.o(181995);
  }
  
  public EditorVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(181996);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    buR();
    AppMethodBeat.o(181996);
  }
  
  private void buR()
  {
    AppMethodBeat.i(181997);
    this.uwn = new AlphaAnimation(0.1F, 1.0F);
    this.uwn.setDuration(1000L);
    this.uwn.setRepeatCount(-1);
    this.uwn.setRepeatMode(2);
    this.uwo = new com.tencent.mm.ui.g.a();
    Drawable localDrawable = getResources().getDrawable(d.g.chatfrom_voice_playing_new_f1);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.uwo.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(d.g.chatfrom_voice_playing_new_f2);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.uwo.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(d.g.chatfrom_voice_playing_new_f3);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.uwo.addFrame(localDrawable, 300);
    this.uwo.setOneShot(false);
    this.uwo.setVisible(true, true);
    AppMethodBeat.o(181997);
  }
  
  public final void atP(String paramString)
  {
    AppMethodBeat.i(182000);
    Log.d("MicroMsg.NoteEditorVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!Util.nullAs(paramString, "").equals(this.path)) {
      cTg();
    }
    AppMethodBeat.o(182000);
  }
  
  public final void cTg()
  {
    AppMethodBeat.i(181998);
    if ((this.uwn != null) && (this.uwn.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(d.g.chatfrom_voice_playing_new), null, null, null);
    this.uwo.stop();
    AppMethodBeat.o(181998);
  }
  
  public final void cTh()
  {
    AppMethodBeat.i(182001);
    cTg();
    AppMethodBeat.o(182001);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(181999);
    super.onFinishInflate();
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181994);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        String str = EditorVoiceBaseView.a(EditorVoiceBaseView.this);
        if (a.cTi().cTl()) {}
        for (localObject = "true";; localObject = "false")
        {
          Log.i("MicroMsg.NoteEditorVoiceBaseView", "clicked path:%s, player isPlay:%s, path:%s", new Object[] { str, localObject, a.cTi().path });
          if ((!com.tencent.mm.q.a.cy(EditorVoiceBaseView.b(EditorVoiceBaseView.this))) && (!com.tencent.mm.q.a.cw(EditorVoiceBaseView.b(EditorVoiceBaseView.this))) && (!com.tencent.mm.q.a.cB(EditorVoiceBaseView.b(EditorVoiceBaseView.this)))) {
            break;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(181994);
          return;
        }
        if ((!e.avA()) && (!Util.isNullOrNil(EditorVoiceBaseView.a(EditorVoiceBaseView.this))))
        {
          w.g(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(181994);
          return;
        }
        if (c.cRE().urq)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(181994);
          return;
        }
        if ((Util.nullAs(EditorVoiceBaseView.a(EditorVoiceBaseView.this), "").equals(a.cTi().path)) && (a.cTi().cTl()))
        {
          paramAnonymousView = EditorVoiceBaseView.this;
          Log.d("MicroMsg.NoteEditorVoiceBaseView", "stop play");
          paramAnonymousView.cTg();
          a.cTi().stopPlay();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(181994);
          return;
          EditorVoiceBaseView.c(EditorVoiceBaseView.this);
        }
      }
    });
    AppMethodBeat.o(181999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.voiceview.EditorVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */