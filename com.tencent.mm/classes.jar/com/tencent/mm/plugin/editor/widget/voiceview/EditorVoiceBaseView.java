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
import com.tencent.mm.ui.base.aa;

public class EditorVoiceBaseView
  extends TextView
  implements a.a
{
  private boolean Uz;
  private Context context;
  private int duration;
  private int hIY;
  private String path;
  private AlphaAnimation xCM;
  private AnimationDrawable xCN;
  
  public EditorVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(181995);
    this.Uz = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    bTa();
    AppMethodBeat.o(181995);
  }
  
  public EditorVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(181996);
    this.Uz = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    bTa();
    AppMethodBeat.o(181996);
  }
  
  private void bTa()
  {
    AppMethodBeat.i(181997);
    this.xCM = new AlphaAnimation(0.1F, 1.0F);
    this.xCM.setDuration(1000L);
    this.xCM.setRepeatCount(-1);
    this.xCM.setRepeatMode(2);
    this.xCN = new com.tencent.mm.ui.g.a();
    Drawable localDrawable = getResources().getDrawable(d.g.chatfrom_voice_playing_new_f1);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.xCN.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(d.g.chatfrom_voice_playing_new_f2);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.xCN.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(d.g.chatfrom_voice_playing_new_f3);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.xCN.addFrame(localDrawable, 300);
    this.xCN.setOneShot(false);
    this.xCN.setVisible(true, true);
    AppMethodBeat.o(181997);
  }
  
  public final void anE(String paramString)
  {
    AppMethodBeat.i(182000);
    Log.d("MicroMsg.NoteEditorVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!Util.nullAs(paramString, "").equals(this.path)) {
      dxz();
    }
    AppMethodBeat.o(182000);
  }
  
  public final void dxA()
  {
    AppMethodBeat.i(182001);
    dxz();
    AppMethodBeat.o(182001);
  }
  
  public final void dxz()
  {
    AppMethodBeat.i(181998);
    if ((this.xCM != null) && (this.xCM.isInitialized())) {
      setAnimation(null);
    }
    this.Uz = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(d.g.chatfrom_voice_playing_new), null, null, null);
    this.xCN.stop();
    AppMethodBeat.o(181998);
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
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        String str = EditorVoiceBaseView.a(EditorVoiceBaseView.this);
        if (a.dxB().dxE()) {}
        for (localObject = "true";; localObject = "false")
        {
          Log.i("MicroMsg.NoteEditorVoiceBaseView", "clicked path:%s, player isPlay:%s, path:%s", new Object[] { str, localObject, a.dxB().path });
          if ((!com.tencent.mm.n.a.dm(EditorVoiceBaseView.b(EditorVoiceBaseView.this))) && (!com.tencent.mm.n.a.dl(EditorVoiceBaseView.b(EditorVoiceBaseView.this))) && (!com.tencent.mm.n.a.dp(EditorVoiceBaseView.b(EditorVoiceBaseView.this)))) {
            break;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(181994);
          return;
        }
        if ((!e.aPU()) && (!Util.isNullOrNil(EditorVoiceBaseView.a(EditorVoiceBaseView.this))))
        {
          aa.j(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(181994);
          return;
        }
        if (c.dvX().xxL)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/voiceview/EditorVoiceBaseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(181994);
          return;
        }
        if ((Util.nullAs(EditorVoiceBaseView.a(EditorVoiceBaseView.this), "").equals(a.dxB().path)) && (a.dxB().dxE()))
        {
          paramAnonymousView = EditorVoiceBaseView.this;
          Log.d("MicroMsg.NoteEditorVoiceBaseView", "stop play");
          paramAnonymousView.dxz();
          a.dxB().stopPlay();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.voiceview.EditorVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */