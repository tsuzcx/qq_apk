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
import com.tencent.mm.plugin.editor.model.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.t;

public class EditorVoiceBaseView
  extends TextView
  implements a.a
{
  private Context context;
  private int dhE;
  private int duration;
  private boolean isRunning;
  private AlphaAnimation oUC;
  private AnimationDrawable oUD;
  private String path;
  
  public EditorVoiceBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(181995);
    this.isRunning = false;
    this.duration = -1;
    this.path = "";
    this.context = paramContext;
    aMN();
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
    aMN();
    AppMethodBeat.o(181996);
  }
  
  private void aMN()
  {
    AppMethodBeat.i(181997);
    this.oUC = new AlphaAnimation(0.1F, 1.0F);
    this.oUC.setDuration(1000L);
    this.oUC.setRepeatCount(-1);
    this.oUC.setRepeatMode(2);
    this.oUD = new com.tencent.mm.ui.e.a();
    Drawable localDrawable = getResources().getDrawable(2131689892);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.oUD.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689893);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.oUD.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689894);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.oUD.addFrame(localDrawable, 300);
    this.oUD.setOneShot(false);
    this.oUD.setVisible(true, true);
    AppMethodBeat.o(181997);
  }
  
  public final void Xr(String paramString)
  {
    AppMethodBeat.i(182000);
    ac.d("MicroMsg.NoteEditorVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    if (!bs.bG(paramString, "").equals(this.path)) {
      caT();
    }
    AppMethodBeat.o(182000);
  }
  
  public final void caT()
  {
    AppMethodBeat.i(181998);
    if ((this.oUC != null) && (this.oUC.isInitialized())) {
      setAnimation(null);
    }
    this.isRunning = false;
    setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2131689891), null, null, null);
    this.oUD.stop();
    AppMethodBeat.o(181998);
  }
  
  public final void caU()
  {
    AppMethodBeat.i(182001);
    caT();
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
        String str2 = EditorVoiceBaseView.a(EditorVoiceBaseView.this);
        if (a.caV().caY()) {}
        for (String str1 = "true";; str1 = "false")
        {
          ac.i("MicroMsg.NoteEditorVoiceBaseView", "clicked path:%s, player isPlay:%s, path:%s", new Object[] { str2, str1, a.caV().path });
          if ((!com.tencent.mm.r.a.ci(EditorVoiceBaseView.b(EditorVoiceBaseView.this))) && (!com.tencent.mm.r.a.cf(EditorVoiceBaseView.b(EditorVoiceBaseView.this))) && (!com.tencent.mm.r.a.ck(EditorVoiceBaseView.b(EditorVoiceBaseView.this)))) {
            break;
          }
          AppMethodBeat.o(181994);
          return;
        }
        if ((!e.YD()) && (!bs.isNullOrNil(EditorVoiceBaseView.a(EditorVoiceBaseView.this))))
        {
          t.g(paramAnonymousView.getContext(), null);
          AppMethodBeat.o(181994);
          return;
        }
        if (c.bZq().oPF)
        {
          AppMethodBeat.o(181994);
          return;
        }
        if ((bs.bG(EditorVoiceBaseView.a(EditorVoiceBaseView.this), "").equals(a.caV().path)) && (a.caV().caY()))
        {
          paramAnonymousView = EditorVoiceBaseView.this;
          ac.d("MicroMsg.NoteEditorVoiceBaseView", "stop play");
          paramAnonymousView.caT();
          a.caV().stopPlay();
          AppMethodBeat.o(181994);
          return;
        }
        EditorVoiceBaseView.c(EditorVoiceBaseView.this);
        AppMethodBeat.o(181994);
      }
    });
    AppMethodBeat.o(181999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.voiceview.EditorVoiceBaseView
 * JD-Core Version:    0.7.0.1
 */