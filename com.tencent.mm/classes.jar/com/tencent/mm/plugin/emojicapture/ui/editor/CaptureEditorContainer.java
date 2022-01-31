package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.d.b.g;
import a.n;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.api.r;
import com.tencent.mm.api.r.a;
import com.tencent.mm.api.s;
import com.tencent.mm.plugin.emojicapture.a.c;
import com.tencent.mm.plugin.emojicapture.a.d;
import com.tencent.mm.plugin.emojicapture.a.e;
import com.tencent.mm.plugin.emojicapture.c.b.a;
import com.tencent.mm.plugin.emojicapture.c.b.b;
import com.tencent.mm.plugin.emojicapture.f.a.a;
import com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;

public final class CaptureEditorContainer
  extends RelativeLayout
  implements b.b
{
  private final String TAG = "MicroMsg.CaptureEditorContainer";
  private long iZh;
  private View jpA;
  private View jpB;
  private ChatFooterPanel jpC;
  private a.d.a.a<n> jpD;
  private final CaptureEditorContainer.k jpE = new CaptureEditorContainer.k(this);
  public b.a jps;
  private EmojiVideoPlayTextureView jpt;
  private EditorItemContainer jpu;
  private EditorChangeTextView jpv;
  private View jpw;
  private View jpx;
  private View jpy;
  private View jpz;
  
  public CaptureEditorContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CaptureEditorContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View.inflate(getContext(), a.e.emoji_editor_container, (ViewGroup)this);
    paramContext = findViewById(a.d.emoji_capture_video_play_view);
    g.j(paramContext, "findViewById(R.id.emoji_capture_video_play_view)");
    this.jpt = ((EmojiVideoPlayTextureView)paramContext);
    paramContext = findViewById(a.d.editor_item_container);
    g.j(paramContext, "findViewById(R.id.editor_item_container)");
    this.jpu = ((EditorItemContainer)paramContext);
    paramContext = findViewById(a.d.change_text_root);
    g.j(paramContext, "findViewById(R.id.change_text_root)");
    this.jpv = ((EditorChangeTextView)paramContext);
    paramContext = findViewById(a.d.editor_type_root);
    g.j(paramContext, "findViewById(R.id.editor_type_root)");
    this.jpw = paramContext;
    paramContext = findViewById(a.d.editor_remove_background);
    g.j(paramContext, "findViewById(R.id.editor_remove_background)");
    this.jpx = paramContext;
    paramContext = findViewById(a.d.editor_speed_up);
    g.j(paramContext, "findViewById(R.id.editor_speed_up)");
    this.jpy = paramContext;
    paramContext = findViewById(a.d.editor_add_emoji);
    g.j(paramContext, "findViewById(R.id.editor_add_emoji)");
    this.jpz = paramContext;
    paramContext = findViewById(a.d.to_capture);
    g.j(paramContext, "findViewById(R.id.to_capture)");
    this.jpA = paramContext;
    paramContext = findViewById(a.d.mix_video);
    g.j(paramContext, "findViewById(R.id.mix_video)");
    this.jpB = paramContext;
    paramContext = this.jpx;
    if (paramContext == null) {
      g.ahh("removeBgView");
    }
    paramContext.setOnClickListener((View.OnClickListener)new CaptureEditorContainer.a(this));
    paramContext = this.jpy;
    if (paramContext == null) {
      g.ahh("speedUpView");
    }
    paramContext.setOnClickListener((View.OnClickListener)new CaptureEditorContainer.b(this));
    paramContext = this.jpz;
    if (paramContext == null) {
      g.ahh("addEmojiView");
    }
    paramContext.setOnClickListener((View.OnClickListener)new c(this));
    paramContext = this.jpA;
    if (paramContext == null) {
      g.ahh("backBtn");
    }
    paramContext.setOnClickListener((View.OnClickListener)new CaptureEditorContainer.d(this));
    paramContext = this.jpB;
    if (paramContext == null) {
      g.ahh("mixBtn");
    }
    paramContext.setOnClickListener((View.OnClickListener)new e(this));
    setOnClickListener((View.OnClickListener)new CaptureEditorContainer.f(this));
    paramContext = this.jpv;
    if (paramContext == null) {
      g.ahh("changeTextRoot");
    }
    paramContext.setCallback((EditorChangeTextView.a)new CaptureEditorContainer.g(this));
    paramContext = this.jpu;
    if (paramContext == null) {
      g.ahh("editorItemContainer");
    }
    paramContext.setStateChangeListener((EditorItemContainer.b)new CaptureEditorContainer.h(this));
    if (this.jpC == null) {
      this.jpC = ((ChatFooterPanel)s.ay(getContext()));
    }
    paramContext = this.jpC;
    if (paramContext != null) {
      paramContext.setEntranceScene(ChatFooterPanel.rZx);
    }
    paramContext = this.jpC;
    if (paramContext != null) {
      paramContext.setBackgroundResource(a.c.bottombar_bg);
    }
    paramContext = this.jpC;
    if (paramContext != null) {
      paramContext.sl();
    }
    paramContext = this.jpC;
    if (paramContext != null) {
      paramContext.aN(true);
    }
    paramContext = this.jpC;
    if (paramContext != null) {
      paramContext.i(true, true);
    }
    paramContext = this.jpC;
    if (paramContext != null) {
      paramContext.setVisibility(8);
    }
    paramContext = this.jpC;
    if (paramContext != null) {
      paramContext.onResume();
    }
    paramContext = s.so();
    g.j(paramContext, "callbackWrapper");
    paramContext.a((r.a)new CaptureEditorContainer.i(this));
    paramAttributeSet = this.jpC;
    if (paramAttributeSet != null) {
      paramAttributeSet.setCallback((f)paramContext);
    }
    paramContext = new RelativeLayout.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 230));
    paramContext.addRule(12);
    addView((View)this.jpC, (ViewGroup.LayoutParams)paramContext);
    paramAttributeSet = this.jpC;
    if (paramAttributeSet == null) {
      g.cUk();
    }
    paramAttributeSet.setTranslationY(paramContext.height);
  }
  
  public final void a(String paramString, boolean paramBoolean, a.d.a.a<n> parama)
  {
    g.k(paramString, "videoPath");
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.jpt;
    if (localEmojiVideoPlayTextureView == null) {
      g.ahh("videoPlayView");
    }
    localEmojiVideoPlayTextureView.setVideoCallback((f.a)this.jpE);
    localEmojiVideoPlayTextureView = this.jpt;
    if (localEmojiVideoPlayTextureView == null) {
      g.ahh("videoPlayView");
    }
    localEmojiVideoPlayTextureView.setVideoPath(paramString);
    paramString = this.jpt;
    if (paramString == null) {
      g.ahh("videoPlayView");
    }
    paramString.setAlpha(0.0F);
    paramString = this.jpx;
    if (paramString == null) {
      g.ahh("removeBgView");
    }
    paramString.setActivated(paramBoolean);
    this.jpD = parama;
  }
  
  public final void a(boolean paramBoolean, CharSequence paramCharSequence, int paramInt)
  {
    if (paramBoolean)
    {
      EditorChangeTextView localEditorChangeTextView = this.jpv;
      if (localEditorChangeTextView == null) {
        g.ahh("changeTextRoot");
      }
      localEditorChangeTextView.setVisibility(0);
      localEditorChangeTextView = this.jpv;
      if (localEditorChangeTextView == null) {
        g.ahh("changeTextRoot");
      }
      localEditorChangeTextView.hvM.setText(paramCharSequence);
      if (paramCharSequence != null) {
        localEditorChangeTextView.hvM.setSelection(paramCharSequence.length());
      }
      localEditorChangeTextView.jpK.setColor(paramInt);
      localEditorChangeTextView.jpL = localEditorChangeTextView.jpK.getTextColor();
      localEditorChangeTextView.jpM = localEditorChangeTextView.jpK.getStrokeColor();
      localEditorChangeTextView.hvM.setTextColor(localEditorChangeTextView.jpL);
      localEditorChangeTextView.jpP = false;
      return;
    }
    paramCharSequence = this.jpv;
    if (paramCharSequence == null) {
      g.ahh("changeTextRoot");
    }
    paramCharSequence.cancel();
  }
  
  public final void aJT()
  {
    Object localObject = this.jpt;
    if (localObject == null) {
      g.ahh("videoPlayView");
    }
    ((EmojiVideoPlayTextureView)localObject).setAlpha(1.0F);
    localObject = com.tencent.mm.plugin.emojicapture.f.a.jnW;
    com.tencent.mm.plugin.emojicapture.f.a.dy(System.currentTimeMillis());
  }
  
  public final boolean aJU()
  {
    EditorChangeTextView localEditorChangeTextView = this.jpv;
    if (localEditorChangeTextView == null) {
      g.ahh("changeTextRoot");
    }
    return localEditorChangeTextView.getVisibility() == 0;
  }
  
  public final boolean aJV()
  {
    if (this.jpC != null)
    {
      ChatFooterPanel localChatFooterPanel = this.jpC;
      if (localChatFooterPanel == null) {
        g.cUk();
      }
      if (localChatFooterPanel.getVisibility() == 0) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean akH()
  {
    return getVisibility() == 0;
  }
  
  public final void destroy()
  {
    ChatFooterPanel localChatFooterPanel = this.jpC;
    if (localChatFooterPanel != null) {
      localChatFooterPanel.destroy();
    }
  }
  
  public final void fs(boolean paramBoolean)
  {
    if (this.jpC == null)
    {
      localObject = this.jpz;
      if (localObject == null) {
        g.ahh("addEmojiView");
      }
      ((View)localObject).setActivated(false);
      return;
    }
    Object localObject = this.jpC;
    if (localObject == null) {
      g.cUk();
    }
    float f = ((ChatFooterPanel)localObject).getLayoutParams().height;
    if (paramBoolean)
    {
      localObject = this.jpz;
      if (localObject == null) {
        g.ahh("addEmojiView");
      }
      ((View)localObject).setActivated(true);
      localObject = this.jpC;
      if (localObject == null) {
        g.cUk();
      }
      ((ChatFooterPanel)localObject).setVisibility(0);
      localObject = this.jpC;
      if (localObject == null) {
        g.cUk();
      }
      ((ChatFooterPanel)localObject).animate().translationY(0.0F).start();
      return;
    }
    localObject = this.jpz;
    if (localObject == null) {
      g.ahh("addEmojiView");
    }
    ((View)localObject).setActivated(false);
    localObject = this.jpC;
    if (localObject == null) {
      g.cUk();
    }
    ((ChatFooterPanel)localObject).animate().translationY(f).withEndAction((Runnable)new CaptureEditorContainer.j(this)).start();
  }
  
  public final EditorItemContainer getItemContainer()
  {
    EditorItemContainer localEditorItemContainer = this.jpu;
    if (localEditorItemContainer == null) {
      g.ahh("editorItemContainer");
    }
    return localEditorItemContainer;
  }
  
  public final b.a getPresenter()
  {
    b.a locala = this.jps;
    if (locala == null) {
      g.ahh("presenter");
    }
    return locala;
  }
  
  public final long getStartTick()
  {
    return this.iZh;
  }
  
  public final EmojiVideoPlayTextureView getVideoPlayView()
  {
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.jpt;
    if (localEmojiVideoPlayTextureView == null) {
      g.ahh("videoPlayView");
    }
    return localEmojiVideoPlayTextureView;
  }
  
  public final void setPresenter(b.a parama)
  {
    g.k(parama, "<set-?>");
    this.jps = parama;
  }
  
  public final void setStartTick(long paramLong)
  {
    this.iZh = paramLong;
  }
  
  public final void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    EmojiVideoPlayTextureView localEmojiVideoPlayTextureView = this.jpt;
    if (localEmojiVideoPlayTextureView == null) {
      g.ahh("videoPlayView");
    }
    localEmojiVideoPlayTextureView.setVisibility(paramInt);
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(CaptureEditorContainer paramCaptureEditorContainer) {}
    
    public final void onClick(View paramView)
    {
      paramView = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      a.a.a(12, 0L, 0L, 0L);
      paramView = this.jpF;
      if (!this.jpF.aJV()) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.fs(bool);
        return;
      }
    }
  }
  
  static final class e
    implements View.OnClickListener
  {
    e(CaptureEditorContainer paramCaptureEditorContainer) {}
    
    public final void onClick(View paramView)
    {
      paramView = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      com.tencent.mm.plugin.emojicapture.f.a.dz(System.currentTimeMillis());
      paramView = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      paramView = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      long l = com.tencent.mm.plugin.emojicapture.f.a.aKs();
      paramView = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      com.tencent.mm.plugin.emojicapture.f.a.dD(l - com.tencent.mm.plugin.emojicapture.f.a.aKr());
      paramView = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      paramView = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      a.a.a(17, 0L, 0L, com.tencent.mm.plugin.emojicapture.f.a.aKw());
      paramView = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      a.a.cG(3, 1);
      this.jpF.getPresenter().aJS();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer
 * JD-Core Version:    0.7.0.1
 */