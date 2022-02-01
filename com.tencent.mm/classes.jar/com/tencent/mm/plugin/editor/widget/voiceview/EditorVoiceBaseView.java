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
import com.tencent.mm.plugin.editor.model.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.t;

public class EditorVoiceBaseView
  extends TextView
  implements a.a
{
  private Context context;
  private int dui;
  private int duration;
  private boolean isRunning;
  private AlphaAnimation pEQ;
  private AnimationDrawable pER;
  private String path;
  
  public EditorVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(181995);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    aQx();
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
    aQx();
    AppMethodBeat.o(181996);
  }
  
  private void aQx()
  {
    AppMethodBeat.i(181997);
    this.pEQ = new AlphaAnimation(0.1F, 1.0F);
    this.pEQ.setDuration(1000L);
    this.pEQ.setRepeatCount(-1);
    this.pEQ.setRepeatMode(2);
    this.pER = new com.tencent.mm.ui.e.a();
    Drawable localDrawable = getResources().getDrawable(2131689892);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pER.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689893);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pER.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689894);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pER.addFrame(localDrawable, 300);
    this.pER.setOneShot(false);
    this.pER.setVisible(true, true);
    AppMethodBeat.o(181997);
  }
  
  public final void abP(String paramString)
  {
    AppMethodBeat.i(182000);
    ae.d("MicroMsg.NoteEditorVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!bu.bI(paramString, "").equals(this.path)) {
      cgN();
    }
    AppMethodBeat.o(182000);
  }
  
  public final void cgN()
  {
    AppMethodBeat.i(181998);
    if ((this.pEQ != null) && (this.pEQ.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2131689891), null, null, null);
    this.pER.stop();
    AppMethodBeat.o(181998);
  }
  
  public final void cgO()
  {
    AppMethodBeat.i(182001);
    cgN();
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
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        String str = EditorVoiceBaseView.a(EditorVoiceBaseView.this);
        if (a.cgP().cgS()) {}
        for (localObject = "true";; localObject = "false")
        {
          ae.i("MicroMsg.NoteEditorVoiceBaseView", "clicked path:%s, player isPlay:%s, path:%s", new Object[] { str, localObject, a.cgP().path });
          if ((!com.tencent.mm.r.a.ch(EditorVoiceBaseView.b(EditorVoiceBaseView.this))) && (!com.tencent.mm.r.a.cf(EditorVoiceBaseView.b(EditorVoiceBaseView.this))) && (!com.tencent.mm.r.a.cj(EditorVoiceBaseView.b(EditorVoiceBaseView.this)))) {
            break;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(181994);
          return;
        }
        if ((!e.abo()) && (!bu.isNullOrNil(EditorVoiceBaseView.a(EditorVoiceBaseView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(181994);
          return;
        }
        if (c.cfj().pzT)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(181994);
          return;
        }
        if ((bu.bI(EditorVoiceBaseView.a(EditorVoiceBaseView.this), "").equals(a.cgP().path)) && (a.cgP().cgS()))
        {
          paramAnonymousView = EditorVoiceBaseView.this;
          ae.d("MicroMsg.NoteEditorVoiceBaseView", "stop play");
          paramAnonymousView.cgN();
          a.cgP().stopPlay();
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