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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;

public class EditorVoiceBaseView
  extends TextView
  implements a.a
{
  private Context context;
  private int dLt;
  private int duration;
  private boolean isRunning;
  private String path;
  private AlphaAnimation qUh;
  private AnimationDrawable qUi;
  
  public EditorVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(181995);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    blc();
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
    blc();
    AppMethodBeat.o(181996);
  }
  
  private void blc()
  {
    AppMethodBeat.i(181997);
    this.qUh = new AlphaAnimation(0.1F, 1.0F);
    this.qUh.setDuration(1000L);
    this.qUh.setRepeatCount(-1);
    this.qUh.setRepeatMode(2);
    this.qUi = new com.tencent.mm.ui.f.a();
    Drawable localDrawable = getResources().getDrawable(2131689907);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.qUi.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689908);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.qUi.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689909);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.qUi.addFrame(localDrawable, 300);
    this.qUi.setOneShot(false);
    this.qUi.setVisible(true, true);
    AppMethodBeat.o(181997);
  }
  
  public final void alV(String paramString)
  {
    AppMethodBeat.i(182000);
    Log.d("MicroMsg.NoteEditorVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!Util.nullAs(paramString, "").equals(this.path)) {
      cEA();
    }
    AppMethodBeat.o(182000);
  }
  
  public final void cEA()
  {
    AppMethodBeat.i(181998);
    if ((this.qUh != null) && (this.qUh.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2131689906), null, null, null);
    this.qUi.stop();
    AppMethodBeat.o(181998);
  }
  
  public final void cEB()
  {
    AppMethodBeat.i(182001);
    cEA();
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
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        String str = EditorVoiceBaseView.a(EditorVoiceBaseView.this);
        if (a.cEC().cEF()) {}
        for (localObject = "true";; localObject = "false")
        {
          Log.i("MicroMsg.NoteEditorVoiceBaseView", "clicked path:%s, player isPlay:%s, path:%s", new Object[] { str, localObject, a.cEC().path });
          if ((!com.tencent.mm.q.a.cC(EditorVoiceBaseView.b(EditorVoiceBaseView.this))) && (!com.tencent.mm.q.a.cA(EditorVoiceBaseView.b(EditorVoiceBaseView.this))) && (!com.tencent.mm.q.a.cE(EditorVoiceBaseView.b(EditorVoiceBaseView.this)))) {
            break;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(181994);
          return;
        }
        if ((!e.apn()) && (!Util.isNullOrNil(EditorVoiceBaseView.a(EditorVoiceBaseView.this))))
        {
          u.g(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(181994);
          return;
        }
        if (c.cCZ().qPk)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(181994);
          return;
        }
        if ((Util.nullAs(EditorVoiceBaseView.a(EditorVoiceBaseView.this), "").equals(a.cEC().path)) && (a.cEC().cEF()))
        {
          paramAnonymousView = EditorVoiceBaseView.this;
          Log.d("MicroMsg.NoteEditorVoiceBaseView", "stop play");
          paramAnonymousView.cEA();
          a.cEC().stopPlay();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.voiceview.EditorVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */