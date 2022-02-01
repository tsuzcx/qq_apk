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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.t;

public class EditorVoiceBaseView
  extends TextView
  implements a.a
{
  private Context context;
  private int dtc;
  private int duration;
  private boolean isRunning;
  private String path;
  private AlphaAnimation pym;
  private AnimationDrawable pyn;
  
  public EditorVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(181995);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    aPY();
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
    aPY();
    AppMethodBeat.o(181996);
  }
  
  private void aPY()
  {
    AppMethodBeat.i(181997);
    this.pym = new AlphaAnimation(0.1F, 1.0F);
    this.pym.setDuration(1000L);
    this.pym.setRepeatCount(-1);
    this.pym.setRepeatMode(2);
    this.pyn = new com.tencent.mm.ui.e.a();
    Drawable localDrawable = getResources().getDrawable(2131689892);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pyn.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689893);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pyn.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689894);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pyn.addFrame(localDrawable, 300);
    this.pyn.setOneShot(false);
    this.pyn.setVisible(true, true);
    AppMethodBeat.o(181997);
  }
  
  public final void aaY(String paramString)
  {
    AppMethodBeat.i(182000);
    ad.d("MicroMsg.NoteEditorVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!bt.bI(paramString, "").equals(this.path)) {
      cfx();
    }
    AppMethodBeat.o(182000);
  }
  
  public final void cfx()
  {
    AppMethodBeat.i(181998);
    if ((this.pym != null) && (this.pym.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2131689891), null, null, null);
    this.pyn.stop();
    AppMethodBeat.o(181998);
  }
  
  public final void cfy()
  {
    AppMethodBeat.i(182001);
    cfx();
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        String str = EditorVoiceBaseView.a(EditorVoiceBaseView.this);
        if (a.cfz().cfC()) {}
        for (localObject = "true";; localObject = "false")
        {
          ad.i("MicroMsg.NoteEditorVoiceBaseView", "clicked path:%s, player isPlay:%s, path:%s", new Object[] { str, localObject, a.cfz().path });
          if ((!com.tencent.mm.s.a.cf(EditorVoiceBaseView.b(EditorVoiceBaseView.this))) && (!com.tencent.mm.s.a.cd(EditorVoiceBaseView.b(EditorVoiceBaseView.this))) && (!com.tencent.mm.s.a.ch(EditorVoiceBaseView.b(EditorVoiceBaseView.this)))) {
            break;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(181994);
          return;
        }
        if ((!e.abf()) && (!bt.isNullOrNil(EditorVoiceBaseView.a(EditorVoiceBaseView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(181994);
          return;
        }
        if (c.cdU().ptn)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(181994);
          return;
        }
        if ((bt.bI(EditorVoiceBaseView.a(EditorVoiceBaseView.this), "").equals(a.cfz().path)) && (a.cfz().cfC()))
        {
          paramAnonymousView = EditorVoiceBaseView.this;
          ad.d("MicroMsg.NoteEditorVoiceBaseView", "stop play");
          paramAnonymousView.cfx();
          a.cfz().stopPlay();
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