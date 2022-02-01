package com.tencent.mm.media.widget.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.media.widget.a.f;
import com.tencent.mm.media.widget.b.e;
import com.tencent.mm.media.widget.camerarecordview.d.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera/common/CameraHandler;", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "looper", "Landroid/os/Looper;", "mContext", "Landroid/content/Context;", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "(Landroid/os/Looper;Landroid/content/Context;Lcom/tencent/mm/media/widget/camera/ICommonCamera;)V", "TAG", "", "getCamera", "()Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "setCamera", "(Lcom/tencent/mm/media/widget/camera/ICommonCamera;)V", "dataCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "", "getDataCallback$plugin_mediaeditor_release", "()Lkotlin/jvm/functions/Function1;", "setDataCallback$plugin_mediaeditor_release", "(Lkotlin/jvm/functions/Function1;)V", "displayH", "", "getDisplayH$plugin_mediaeditor_release", "()I", "setDisplayH$plugin_mediaeditor_release", "(I)V", "displayW", "getDisplayW$plugin_mediaeditor_release", "setDisplayW$plugin_mediaeditor_release", "focusMode", "getFocusMode$plugin_mediaeditor_release", "()Ljava/lang/String;", "setFocusMode$plugin_mediaeditor_release", "(Ljava/lang/String;)V", "mCameraHandler", "Landroid/os/Handler;", "getMCameraHandler$plugin_mediaeditor_release", "()Landroid/os/Handler;", "setMCameraHandler$plugin_mediaeditor_release", "(Landroid/os/Handler;)V", "mCameraHandlerThread", "Landroid/os/HandlerThread;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "onImageAvailableListener", "Landroid/media/ImageReader$OnImageAvailableListener;", "getOnImageAvailableListener$plugin_mediaeditor_release", "()Landroid/media/ImageReader$OnImageAvailableListener;", "renderHelper", "Lcom/tencent/mm/media/widget/camera2/RenderScriptImageHelper;", "sAutoFocusBack", "", "getSAutoFocusBack$plugin_mediaeditor_release", "()Z", "setSAutoFocusBack$plugin_mediaeditor_release", "(Z)V", "touchX", "", "getTouchX$plugin_mediaeditor_release", "()F", "setTouchX$plugin_mediaeditor_release", "(F)V", "touchY", "getTouchY$plugin_mediaeditor_release", "setTouchY$plugin_mediaeditor_release", "calculateTapArea", "Landroid/graphics/Rect;", "x", "y", "coefficient", "surfaceWidth", "surfaceHeight", "handleMessage", "msg", "Landroid/os/Message;", "initRenderScript", "triggerAutoFocus", "triggerAutoFocus$plugin_mediaeditor_release", "unInitRenderScript", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MMHandler
{
  public static final a.a nGH;
  private static final int nGR;
  private final String TAG;
  private Context mContext;
  private f mRu;
  public float mkm;
  public float mkn;
  public Handler nGI;
  public HandlerThread nGJ;
  public kotlin.g.a.b<? super Bitmap, ah> nGK;
  public e nGL;
  public int nGM;
  public int nGN;
  public boolean nGO;
  public String nGP;
  public final ImageReader.OnImageAvailableListener nGQ;
  
  static
  {
    AppMethodBeat.i(237654);
    nGH = new a.a((byte)0);
    nGR = 4354;
    AppMethodBeat.o(237654);
  }
  
  public a(Looper paramLooper, Context paramContext, f paramf)
  {
    super(paramLooper);
    AppMethodBeat.i(237627);
    this.mContext = paramContext;
    this.mRu = paramf;
    this.TAG = "MicroMsg.BaseCameraHandler";
    this.nGO = true;
    paramLooper = com.tencent.mm.media.widget.camerarecordview.d.b.nKO;
    this.nGP = b.b.but();
    Log.i(this.TAG, "init camera handler");
    this.nGJ = new HandlerThread("CameraHandler");
    paramLooper = this.nGJ;
    s.checkNotNull(paramLooper);
    paramLooper.start();
    paramLooper = this.nGJ;
    s.checkNotNull(paramLooper);
    this.nGI = new Handler(paramLooper.getLooper());
    if (com.tencent.mm.media.widget.d.c.bvv()) {
      this.nGL = new e(this.mContext);
    }
    this.nGQ = new a..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(237627);
  }
  
  private Rect a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237629);
    Rect localRect = this.mRu.a(paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2);
    AppMethodBeat.o(237629);
    return localRect;
  }
  
  private static final void a(a parama, ImageReader paramImageReader)
  {
    AppMethodBeat.i(237634);
    s.u(parama, "this$0");
    Object localObject1 = com.tencent.mm.media.widget.d.a.nMV;
    com.tencent.mm.media.widget.d.a.bvb();
    localObject1 = parama.nGL;
    Object localObject2 = com.tencent.mm.media.widget.b.c.nGZ;
    localObject2 = com.tencent.mm.media.widget.b.c.btq();
    s.checkNotNull(localObject2);
    com.tencent.mm.media.widget.b.c localc = com.tencent.mm.media.widget.b.c.nGZ;
    if (!com.tencent.mm.media.widget.b.c.btn()) {}
    for (boolean bool = true;; bool = false)
    {
      paramImageReader = paramImageReader.acquireLatestImage();
      s.s(paramImageReader, "it.acquireLatestImage()");
      parama.post((Runnable)new com.tencent.mm.media.widget.b.a((e)localObject1, (Point)localObject2, bool, paramImageReader, (kotlin.g.a.b)new b(parama)));
      AppMethodBeat.o(237634);
      return;
    }
  }
  
  public final void handleMessage(Message paramMessage)
  {
    boolean bool = false;
    AppMethodBeat.i(237668);
    s.u(paramMessage, "msg");
    if (paramMessage.what == nGR)
    {
      if ((this.nGM == 0) || (this.nGN == 0) || (d.rc(14)))
      {
        this.nGO = false;
        this.nGP = this.mRu.btg();
        if (!this.mRu.bth()) {
          bool = true;
        }
        this.nGO = bool;
        Log.i(this.TAG, s.X("triggerAutoFocus ret ", Boolean.valueOf(this.nGO)));
        AppMethodBeat.o(237668);
        return;
      }
      float f1 = this.mkm;
      float f2 = this.mkn;
      int i = this.nGM;
      int j = this.nGN;
      if (this.mRu == null)
      {
        Log.w(this.TAG, "want to auto focus, but camera is null, do nothing");
        AppMethodBeat.o(237668);
        return;
      }
      if (!this.nGO)
      {
        Log.w(this.TAG, "auto focus not back");
        AppMethodBeat.o(237668);
        return;
      }
      this.nGO = false;
      this.nGP = this.mRu.btg();
      paramMessage = a(f1, f2, 1.25F, i, j);
      Rect localRect = a(f1, f2, 1.0F, i, j);
      this.nGO = this.mRu.f(paramMessage, localRect);
    }
    AppMethodBeat.o(237668);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "image", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Bitmap, ah>
  {
    b(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.a.a
 * JD-Core Version:    0.7.0.1
 */