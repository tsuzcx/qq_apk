package com.tencent.mm.plugin.emojicapture.ui.capture;

import a.d.b.g;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.emojicapture.a.d;
import com.tencent.mm.plugin.emojicapture.a.e;
import com.tencent.mm.plugin.emojicapture.c.a.b;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureTextureView;
import com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.c;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.d;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.video.b;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.bl;

public final class CaptureContainer
  extends RelativeLayout
  implements a.b
{
  private final String TAG = "MicroMsg.CaptureContainer";
  private ObservableTextureView joZ;
  private EmojiCaptureTextureView jpa;
  private MMSightRecordButton jpb;
  private View jpc;
  private View jpd;
  private View jpe;
  private View jpf;
  private CaptureDecoration jpg;
  private CameraFrontSightView jph;
  private MMSightCaptureTouchView jpi;
  private TextView jpj;
  private Button jpk;
  public com.tencent.mm.plugin.emojicapture.c.a.a jpl;
  
  public CaptureContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CaptureContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View.inflate(getContext(), a.e.emoji_capture_container, (ViewGroup)this);
    paramContext = findViewById(a.d.emoji_capture_view);
    g.j(paramContext, "findViewById(R.id.emoji_capture_view)");
    this.jpa = ((EmojiCaptureTextureView)paramContext);
    paramContext = findViewById(a.d.emoji_capture_button);
    g.j(paramContext, "findViewById(R.id.emoji_capture_button)");
    this.jpb = ((MMSightRecordButton)paramContext);
    paramContext = findViewById(a.d.camera_data_view);
    g.j(paramContext, "findViewById(R.id.camera_data_view)");
    this.joZ = ((ObservableTextureView)paramContext);
    paramContext = findViewById(a.d.capture_close);
    g.j(paramContext, "findViewById(R.id.capture_close)");
    this.jpc = paramContext;
    paramContext = findViewById(a.d.capture_flip_camera);
    g.j(paramContext, "findViewById(R.id.capture_flip_camera)");
    this.jpd = paramContext;
    paramContext = findViewById(a.d.choose_from_album);
    g.j(paramContext, "findViewById(R.id.choose_from_album)");
    this.jpe = paramContext;
    paramContext = findViewById(a.d.voice_detect_hint);
    g.j(paramContext, "findViewById(R.id.voice_detect_hint)");
    this.jpf = paramContext;
    paramContext = findViewById(a.d.capture_decoration);
    g.j(paramContext, "findViewById(R.id.capture_decoration)");
    this.jpg = ((CaptureDecoration)paramContext);
    paramContext = findViewById(a.d.capture_focus_frame);
    g.j(paramContext, "findViewById(R.id.capture_focus_frame)");
    this.jph = ((CameraFrontSightView)paramContext);
    paramContext = findViewById(a.d.capture_touch_view);
    g.j(paramContext, "findViewById(R.id.capture_touch_view)");
    this.jpi = ((MMSightCaptureTouchView)paramContext);
    paramContext = findViewById(a.d.emoji_capture_hint);
    g.j(paramContext, "findViewById(R.id.emoji_capture_hint)");
    this.jpj = ((TextView)paramContext);
    paramContext = findViewById(a.d.beauty_debug);
    g.j(paramContext, "findViewById(R.id.beauty_debug)");
    this.jpk = ((Button)paramContext);
    paramInt = com.tencent.mm.cb.a.fromDPToPix(getContext(), 120);
    paramContext = this.jph;
    if (paramContext == null) {
      g.ahh("captureFocus");
    }
    paramContext.dj(paramInt, paramInt);
    paramContext = this.joZ;
    if (paramContext == null) {
      g.ahh("cameraDataView");
    }
    paramContext.setTextureChangeCallback((b)new CaptureContainer.a(this));
    paramContext = this.jpb;
    if (paramContext == null) {
      g.ahh("emojiCaptureButton");
    }
    paramContext.setLongPressCallback((MMSightRecordButton.b)new CaptureContainer.b(this));
    paramContext = this.jpb;
    if (paramContext == null) {
      g.ahh("emojiCaptureButton");
    }
    paramContext.setSimpleTapCallback((MMSightRecordButton.d)new CaptureContainer.c(this));
    paramContext = this.jpb;
    if (paramContext == null) {
      g.ahh("emojiCaptureButton");
    }
    paramContext.setLongPressScrollCallback((MMSightRecordButton.c)new CaptureContainer.d(this));
    paramContext = this.jpi;
    if (paramContext == null) {
      g.ahh("captureTouchView");
    }
    paramContext.setTouchCallback((MMSightCaptureTouchView.a)new CaptureContainer.e(this));
    paramContext = this.jpc;
    if (paramContext == null) {
      g.ahh("captureCloseView");
    }
    paramContext.setOnClickListener((View.OnClickListener)new CaptureContainer.f(this));
    paramContext = this.jpd;
    if (paramContext == null) {
      g.ahh("captureFlipCameraView");
    }
    paramContext.setOnClickListener((View.OnClickListener)new CaptureContainer.g(this));
    paramContext = this.jpe;
    if (paramContext == null) {
      g.ahh("chooseFromAlbum");
    }
    paramContext.setOnClickListener((View.OnClickListener)new h(this));
    if (bl.csf())
    {
      paramContext = this.jpk;
      if (paramContext == null) {
        g.ahh("beautyParaBtn");
      }
      paramContext.setVisibility(0);
      paramContext = this.jpk;
      if (paramContext == null) {
        g.ahh("beautyParaBtn");
      }
      paramContext.setOnClickListener((View.OnClickListener)new CaptureContainer.i(this));
      return;
    }
    paramContext = this.jpk;
    if (paramContext == null) {
      g.ahh("beautyParaBtn");
    }
    paramContext.setVisibility(8);
  }
  
  public final void fq(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localView = this.jpd;
      if (localView == null) {
        g.ahh("captureFlipCameraView");
      }
      localView.setVisibility(0);
      return;
    }
    View localView = this.jpd;
    if (localView == null) {
      g.ahh("captureFlipCameraView");
    }
    localView.setVisibility(8);
  }
  
  public final void fr(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localView = this.jpf;
      if (localView == null) {
        g.ahh("voiceDetectView");
      }
      localView.setVisibility(0);
      return;
    }
    View localView = this.jpf;
    if (localView == null) {
      g.ahh("voiceDetectView");
    }
    localView.setVisibility(8);
  }
  
  public final ObservableTextureView getCameraDataView()
  {
    ObservableTextureView localObservableTextureView = this.joZ;
    if (localObservableTextureView == null) {
      g.ahh("cameraDataView");
    }
    return localObservableTextureView;
  }
  
  public final EmojiCaptureTextureView getCaptureView()
  {
    EmojiCaptureTextureView localEmojiCaptureTextureView = this.jpa;
    if (localEmojiCaptureTextureView == null) {
      g.ahh("emojiCaptureView");
    }
    return localEmojiCaptureTextureView;
  }
  
  public final CaptureDecoration getDecoration()
  {
    CaptureDecoration localCaptureDecoration = this.jpg;
    if (localCaptureDecoration == null) {
      g.ahh("captureDecoration");
    }
    return localCaptureDecoration;
  }
  
  public final com.tencent.mm.plugin.emojicapture.c.a.a getPresenter()
  {
    com.tencent.mm.plugin.emojicapture.c.a.a locala = this.jpl;
    if (locala == null) {
      g.ahh("presenter");
    }
    return locala;
  }
  
  public final void setPresenter(com.tencent.mm.plugin.emojicapture.c.a.a parama)
  {
    g.k(parama, "<set-?>");
    this.jpl = parama;
  }
  
  public final void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    Object localObject = this.jpa;
    if (localObject == null) {
      g.ahh("emojiCaptureView");
    }
    ((EmojiCaptureTextureView)localObject).setVisibility(paramInt);
    localObject = this.jpc;
    if (localObject == null) {
      g.ahh("captureCloseView");
    }
    ((View)localObject).setVisibility(paramInt);
    localObject = this.jpe;
    if (localObject == null) {
      g.ahh("chooseFromAlbum");
    }
    ((View)localObject).setVisibility(paramInt);
    if (paramInt == 0)
    {
      localObject = this.jpb;
      if (localObject == null) {
        g.ahh("emojiCaptureButton");
      }
      ((MMSightRecordButton)localObject).setTouchEnable(true);
    }
  }
  
  static final class h
    implements View.OnClickListener
  {
    h(CaptureContainer paramCaptureContainer) {}
    
    public final void onClick(View paramView)
    {
      paramView = com.tencent.mm.plugin.emojicapture.f.a.jnW;
      com.tencent.mm.plugin.emojicapture.f.a.a.a(7, 0L, 0L, 0L);
      l.j((Activity)this.jpm.getContext(), 1002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer
 * JD-Core Version:    0.7.0.1
 */