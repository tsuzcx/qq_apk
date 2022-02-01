package com.tencent.luggage.h;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.skyline.SkylineLogic;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import io.flutter.embedding.android.FlutterView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/skyline/SkylineView;", "", "()V", "isReady", "", "isTextureView", "mActivity", "Landroid/content/ContextWrapper;", "mBitmap", "Landroid/graphics/Bitmap;", "mContentView", "Landroid/view/ViewGroup;", "mDensity", "", "mFlutterView", "Lio/flutter/embedding/android/FlutterView;", "mId", "", "mImageView", "Landroid/widget/ImageView;", "mLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "appIsDetached", "", "appIsInactive", "appIsPaused", "appIsResumed", "attach", "attachToViewTree", "covertToImage", "detach", "getBitmap", "getHeight", "getWidth", "init", "id", "context", "Landroid/content/Context;", "contentView", "markReady", "pause", "release", "resume", "revertImage", "waitForDone", "callback", "Lcom/tencent/luggage/skyline/SkylineCallback;", "Companion", "luggage-skyline-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g.a ewa;
  public FlutterView ewb;
  public ViewGroup ewc;
  public FrameLayout.LayoutParams ewd;
  public boolean ewe;
  public boolean ewf;
  private ImageView ewg;
  private Bitmap mBitmap;
  private float mDensity = 1.0F;
  public int mId = -1;
  
  static
  {
    AppMethodBeat.i(220025);
    ewa = new g.a((byte)0);
    AppMethodBeat.o(220025);
  }
  
  private static final void a(int paramInt, Context paramContext, DisplayMetrics paramDisplayMetrics, g paramg)
  {
    AppMethodBeat.i(220004);
    s.u(paramContext, "$context");
    s.u(paramg, "this$0");
    f.evZ.a(paramInt, paramContext, paramDisplayMetrics.widthPixels, paramDisplayMetrics.heightPixels);
    paramg.appIsResumed();
    AppMethodBeat.o(220004);
  }
  
  private final void appIsResumed()
  {
    AppMethodBeat.i(219992);
    SkylineLogic.INSTANCE.waitForDone(this.mId, (kotlin.g.a.a)new d(this));
    AppMethodBeat.o(219992);
  }
  
  public final void a(int paramInt, Context paramContext, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    AppMethodBeat.i(220034);
    s.u(paramContext, "context");
    s.u(paramViewGroup, "contentView");
    Log.i("SkylineView", "id:" + paramInt + " isTextureView:" + paramBoolean + " init");
    this.mId = paramInt;
    this.ewe = paramBoolean;
    this.ewc = paramViewGroup;
    paramViewGroup = paramContext.getResources().getDisplayMetrics();
    this.mDensity = paramViewGroup.density;
    this.ewd = new FrameLayout.LayoutParams(-1, -1);
    if (!paramBoolean)
    {
      this.ewg = new ImageView(paramContext);
      ViewGroup localViewGroup = this.ewc;
      if (localViewGroup != null) {
        localViewGroup.addView((View)this.ewg);
      }
    }
    a.evR.init((Context)new ContextWrapper(MMApplicationContext.getContext()), paramBoolean);
    h.ahAA.bk(new g..ExternalSyntheticLambda0(paramInt, paramContext, paramViewGroup, this));
    AppMethodBeat.o(220034);
  }
  
  public final void asW()
  {
    AppMethodBeat.i(220050);
    Object localObject = this.ewg;
    if (localObject != null)
    {
      ((ImageView)localObject).setVisibility(8);
      if (this.mBitmap != null)
      {
        localObject = this.mBitmap;
        if (localObject != null) {
          ((Bitmap)localObject).recycle();
        }
      }
      this.mBitmap = null;
    }
    AppMethodBeat.o(220050);
  }
  
  /* Error */
  public final void pause()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 286
    //   5: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 288	com/tencent/luggage/h/g:ewf	Z
    //   12: ifne +55 -> 67
    //   15: ldc 168
    //   17: new 170	java/lang/StringBuilder
    //   20: dup
    //   21: ldc 172
    //   23: invokespecial 175	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: getfield 110	com/tencent/luggage/h/g:mId	I
    //   30: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: ldc_w 290
    //   36: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: getfield 162	com/tencent/luggage/h/g:ewb	Lio/flutter/embedding/android/FlutterView;
    //   43: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: ldc_w 295
    //   49: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 198	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: ldc_w 286
    //   61: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: ldc 168
    //   69: new 170	java/lang/StringBuilder
    //   72: dup
    //   73: ldc 172
    //   75: invokespecial 175	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: aload_0
    //   79: getfield 110	com/tencent/luggage/h/g:mId	I
    //   82: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: ldc_w 290
    //   88: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: getfield 162	com/tencent/luggage/h/g:ewb	Lio/flutter/embedding/android/FlutterView;
    //   95: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   98: ldc_w 297
    //   101: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 198	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: getstatic 150	com/tencent/skyline/SkylineLogic:INSTANCE	Lcom/tencent/skyline/SkylineLogic;
    //   113: aload_0
    //   114: getfield 110	com/tencent/luggage/h/g:mId	I
    //   117: new 10	com/tencent/luggage/h/g$c
    //   120: dup
    //   121: aload_0
    //   122: invokespecial 298	com/tencent/luggage/h/g$c:<init>	(Lcom/tencent/luggage/h/g;)V
    //   125: checkcast 155	kotlin/g/a/a
    //   128: invokevirtual 158	com/tencent/skyline/SkylineLogic:waitForDone	(ILkotlin/g/a/a;)V
    //   131: aload_0
    //   132: getfield 231	com/tencent/luggage/h/g:ewg	Landroid/widget/ImageView;
    //   135: astore_1
    //   136: aload_1
    //   137: ifnull +31 -> 168
    //   140: aload_0
    //   141: getstatic 150	com/tencent/skyline/SkylineLogic:INSTANCE	Lcom/tencent/skyline/SkylineLogic;
    //   144: aload_0
    //   145: getfield 110	com/tencent/luggage/h/g:mId	I
    //   148: invokevirtual 302	com/tencent/skyline/SkylineLogic:obtainBitmap	(I)Landroid/graphics/Bitmap;
    //   151: putfield 280	com/tencent/luggage/h/g:mBitmap	Landroid/graphics/Bitmap;
    //   154: aload_1
    //   155: aload_0
    //   156: getfield 280	com/tencent/luggage/h/g:mBitmap	Landroid/graphics/Bitmap;
    //   159: invokevirtual 306	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   162: aload_1
    //   163: bipush 8
    //   165: invokevirtual 278	android/widget/ImageView:setVisibility	(I)V
    //   168: getstatic 150	com/tencent/skyline/SkylineLogic:INSTANCE	Lcom/tencent/skyline/SkylineLogic;
    //   171: aload_0
    //   172: getfield 110	com/tencent/luggage/h/g:mId	I
    //   175: new 16	com/tencent/luggage/h/g$f
    //   178: dup
    //   179: aload_0
    //   180: invokespecial 307	com/tencent/luggage/h/g$f:<init>	(Lcom/tencent/luggage/h/g;)V
    //   183: checkcast 155	kotlin/g/a/a
    //   186: invokevirtual 158	com/tencent/skyline/SkylineLogic:waitForDone	(ILkotlin/g/a/a;)V
    //   189: aload_0
    //   190: aconst_null
    //   191: putfield 162	com/tencent/luggage/h/g:ewb	Lio/flutter/embedding/android/FlutterView;
    //   194: ldc_w 286
    //   197: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: goto -136 -> 64
    //   203: astore_1
    //   204: aload_0
    //   205: monitorexit
    //   206: aload_1
    //   207: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	g
    //   135	28	1	localImageView	ImageView
    //   203	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	64	203	finally
    //   67	136	203	finally
    //   140	168	203	finally
    //   168	200	203	finally
  }
  
  /* Error */
  public final void resume()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 308
    //   5: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 288	com/tencent/luggage/h/g:ewf	Z
    //   12: ifne +55 -> 67
    //   15: ldc 168
    //   17: new 170	java/lang/StringBuilder
    //   20: dup
    //   21: ldc 172
    //   23: invokespecial 175	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: getfield 110	com/tencent/luggage/h/g:mId	I
    //   30: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: ldc_w 290
    //   36: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: getfield 162	com/tencent/luggage/h/g:ewb	Lio/flutter/embedding/android/FlutterView;
    //   43: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: ldc_w 310
    //   49: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 198	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: ldc_w 308
    //   61: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: ldc 168
    //   69: new 170	java/lang/StringBuilder
    //   72: dup
    //   73: ldc 172
    //   75: invokespecial 175	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: aload_0
    //   79: getfield 110	com/tencent/luggage/h/g:mId	I
    //   82: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: ldc_w 290
    //   88: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: getfield 162	com/tencent/luggage/h/g:ewb	Lio/flutter/embedding/android/FlutterView;
    //   95: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   98: ldc_w 312
    //   101: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 198	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload_0
    //   111: invokespecial 143	com/tencent/luggage/h/g:appIsResumed	()V
    //   114: aload_0
    //   115: getstatic 245	com/tencent/luggage/h/a:evR	Lcom/tencent/luggage/h/a;
    //   118: invokevirtual 316	com/tencent/luggage/h/a:asR	()Lio/flutter/embedding/android/FlutterView;
    //   121: putfield 162	com/tencent/luggage/h/g:ewb	Lio/flutter/embedding/android/FlutterView;
    //   124: aload_0
    //   125: getfield 202	com/tencent/luggage/h/g:ewc	Landroid/view/ViewGroup;
    //   128: astore_1
    //   129: aload_1
    //   130: ifnull +21 -> 151
    //   133: aload_1
    //   134: aload_0
    //   135: getfield 162	com/tencent/luggage/h/g:ewb	Lio/flutter/embedding/android/FlutterView;
    //   138: checkcast 233	android/view/View
    //   141: aload_0
    //   142: getfield 224	com/tencent/luggage/h/g:ewd	Landroid/widget/FrameLayout$LayoutParams;
    //   145: checkcast 318	android/view/ViewGroup$LayoutParams
    //   148: invokevirtual 321	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   151: aload_0
    //   152: invokevirtual 324	com/tencent/luggage/h/g:vX	()V
    //   155: aload_0
    //   156: invokevirtual 326	com/tencent/luggage/h/g:asW	()V
    //   159: ldc_w 308
    //   162: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: goto -101 -> 64
    //   168: astore_1
    //   169: aload_0
    //   170: monitorexit
    //   171: aload_1
    //   172: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	g
    //   128	6	1	localViewGroup	ViewGroup
    //   168	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	64	168	finally
    //   67	129	168	finally
    //   133	151	168	finally
    //   151	165	168	finally
  }
  
  public final void vX()
  {
    AppMethodBeat.i(220056);
    SkylineLogic.INSTANCE.waitForDone(this.mId, (kotlin.g.a.a)new e(this));
    AppMethodBeat.o(220056);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    public b(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.h.g
 * JD-Core Version:    0.7.0.1
 */