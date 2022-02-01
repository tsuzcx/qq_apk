package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.f;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/AnyProcessAvatarAttacher;", "", "()V", "TAG", "", "attachAvatar", "", "imageView", "Landroid/widget/ImageView;", "username", "getAvatarPathAnyProcess", "getAvatarPathAnyProcessAsync", "onAvatarPathGot", "Lkotlin/Function1;", "getAvatarPathMainProcess", "getAvatarPathMainProcessAsync", "tryDispatchOnAvatarPathGot", "Lcom/tencent/mm/plugin/appbrand/utils/AnyProcessAvatarAttacher$DispatchResult;", "avatarPathHolder", "Lcom/tencent/mm/plugin/appbrand/utils/AnyProcessAvatarAttacher$StringHolder;", "AvatarBitmapDrawable", "DispatchResult", "StringHolder", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c uqm;
  
  static
  {
    AppMethodBeat.i(317436);
    uqm = new c();
    AppMethodBeat.o(317436);
  }
  
  private static final int a(f paramf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(317420);
    s.u(paramf, "$getHDHeadImgHelper");
    Log.i("MicroMsg.AnyProcessAvatarAttacher", "resultCallback#GetHDHeadImg, errType: " + paramInt1 + ", errCode: " + paramInt2);
    paramf.Qh();
    AppMethodBeat.o(317420);
    return 0;
  }
  
  private static final void agx(String paramString)
  {
    AppMethodBeat.i(317425);
    f localf = new f();
    localf.a(paramString, new c..ExternalSyntheticLambda1(localf));
    AppMethodBeat.o(317425);
  }
  
  private static final void agy(String paramString)
  {
    AppMethodBeat.i(317427);
    s.u(paramString, "$username");
    agx(paramString);
    AppMethodBeat.o(317427);
  }
  
  public static void b(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(317404);
    s.u(paramImageView, "imageView");
    s.u(paramString, "username");
    Log.d("MicroMsg.AnyProcessAvatarAttacher", "attachAvatar, imageView: " + paramImageView + ", username: " + paramString);
    Object localObject = paramImageView.getDrawable();
    if ((localObject instanceof a))
    {
      Log.i("MicroMsg.AnyProcessAvatarAttacher", "attachAvatar, AvatarBitmapDrawable already set");
      ((a)localObject).setUsername(paramString);
      AppMethodBeat.o(317404);
      return;
    }
    paramString = new a(paramString);
    paramString.attachToView((View)paramImageView);
    localObject = ah.aiuX;
    paramImageView.setImageDrawable((Drawable)paramString);
    AppMethodBeat.o(317404);
  }
  
  private static final IPCString e(IPCString paramIPCString)
  {
    AppMethodBeat.i(317414);
    String str1;
    if (paramIPCString == null)
    {
      str1 = null;
      paramIPCString = (CharSequence)str1;
      if ((paramIPCString != null) && (paramIPCString.length() != 0)) {
        break label67;
      }
    }
    label67:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label72;
      }
      Log.i("MicroMsg.AnyProcessAvatarAttacher", "invoke#IPCSyncInvokeTask, username is empty");
      paramIPCString = new IPCString("");
      AppMethodBeat.o(317414);
      return paramIPCString;
      str1 = paramIPCString.value;
      break;
    }
    label72:
    c.c localc = new c.c();
    q.bFp();
    String str2;
    if (AvatarStorage.S(str1, true))
    {
      q.bFp();
      str2 = AvatarStorage.Q(str1, true);
      paramIPCString = str2;
      if (str2 == null) {
        paramIPCString = "";
      }
      localc.setValue(paramIPCString);
      paramIPCString = c.b.uqp;
      Log.i("MicroMsg.AnyProcessAvatarAttacher", s.X("getAvatarPathMainProcess, dispatchResult: ", paramIPCString));
      if (c.b.uqq == paramIPCString)
      {
        if (!au.bwE(str1)) {
          break label259;
        }
        Log.i("MicroMsg.AnyProcessAvatarAttacher", "getAvatarPathMainProcess, " + str1 + " is chat room, do not need to fetch hd avatar");
      }
    }
    for (;;)
    {
      paramIPCString = localc.value;
      Log.d("MicroMsg.AnyProcessAvatarAttacher", s.X("invoke#IPCSyncInvokeTask, avatarPath: ", paramIPCString));
      paramIPCString = new IPCString(paramIPCString);
      AppMethodBeat.o(317414);
      return paramIPCString;
      q.bFp();
      if (AvatarStorage.S(str1, false))
      {
        q.bFp();
        str2 = AvatarStorage.Q(str1, false);
        paramIPCString = str2;
        if (str2 == null) {
          paramIPCString = "";
        }
        localc.setValue(paramIPCString);
        paramIPCString = c.b.uqq;
        break;
      }
      paramIPCString = c.b.uqr;
      break;
      label259:
      if (Looper.myLooper() != null) {
        agx(str1);
      } else {
        h.ahAA.bk(new c..ExternalSyntheticLambda2(str1));
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/AnyProcessAvatarAttacher$AvatarBitmapDrawable;", "Landroid/graphics/drawable/BitmapDrawable;", "username", "", "(Ljava/lang/String;)V", "avatarBitmap", "Landroid/graphics/Bitmap;", "value", "", "isPressed", "setPressed", "(Z)V", "myTag", "pressedPaint", "Landroid/graphics/Paint;", "getUsername", "()Ljava/lang/String;", "setUsername", "attachToView", "", "view", "Landroid/view/View;", "draw", "canvas", "Landroid/graphics/Canvas;", "tryUpdateAvatar", "tryUpdateAvatarAsync", "tryUpdateAvatarSync", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    extends BitmapDrawable
  {
    private static final Bitmap hfN;
    public static final c.a.a uqn;
    private final String djQ;
    private boolean isPressed;
    private volatile Bitmap qfk;
    private final Paint uqo;
    private String username;
    
    static
    {
      AppMethodBeat.i(317484);
      uqn = new c.a.a((byte)0);
      hfN = c.a.a.ad(BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null)));
      AppMethodBeat.o(317484);
    }
    
    public a(String paramString)
    {
      super();
      AppMethodBeat.i(317465);
      this.djQ = s.X("MicroMsg.AnyProcessAvatarAttacher.AvatarDrawable#", Integer.valueOf(hashCode()));
      this.username = "";
      this.uqo = new Paint();
      this.uqo.setColor(-16777216);
      this.uqo.setAlpha(76);
      this.uqo.setAntiAlias(true);
      setUsername(paramString);
      AppMethodBeat.o(317465);
    }
    
    private static final boolean a(a parama, View paramView1, View paramView2, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(317480);
      s.u(parama, "this$0");
      s.u(paramView1, "$view");
      int i = paramMotionEvent.getActionMasked();
      Log.d(parama.djQ, "onTouch, view: " + paramView1 + ", action: " + i);
      switch (i)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(317480);
        return false;
        parama.lc(true);
        continue;
        parama.lc(false);
      }
    }
    
    private final void agA(String paramString)
    {
      AppMethodBeat.i(317477);
      c localc = c.uqm;
      paramString = c.agz(paramString);
      int i;
      if (((CharSequence)paramString).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label60;
        }
      }
      label60:
      for (paramString = c.a.a.ad(AvatarStorage.LL(paramString));; paramString = null)
      {
        this.qfk = paramString;
        invalidateSelf();
        AppMethodBeat.o(317477);
        return;
        i = 0;
        break;
      }
    }
    
    private final void lc(boolean paramBoolean)
    {
      AppMethodBeat.i(317472);
      this.isPressed = paramBoolean;
      invalidateSelf();
      AppMethodBeat.o(317472);
    }
    
    public final void attachToView(View paramView)
    {
      AppMethodBeat.i(317488);
      s.u(paramView, "view");
      if ((!(paramView instanceof MaskImageButton)) && ((paramView.isClickable()) || (paramView.isLongClickable()))) {
        try
        {
          paramView.setOnTouchListener(new c.a..ExternalSyntheticLambda0(this, paramView));
          AppMethodBeat.o(317488);
          return;
        }
        catch (Exception paramView)
        {
          Log.printErrStackTrace(this.djQ, (Throwable)paramView, "attachToView fail", new Object[0]);
        }
      }
      AppMethodBeat.o(317488);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(317491);
      s.u(paramCanvas, "canvas");
      Log.d(this.djQ, "draw");
      Object localObject2 = this.qfk;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = hfN;
      }
      if (localObject1 == null)
      {
        Log.i(this.djQ, "draw, bitmap2Draw is null");
        super.draw(paramCanvas);
        AppMethodBeat.o(317491);
        return;
      }
      localObject2 = getBounds();
      s.s(localObject2, "bounds");
      paramCanvas.drawBitmap((Bitmap)localObject1, null, (Rect)localObject2, getPaint());
      if (this.isPressed) {
        paramCanvas.drawRoundRect(new RectF((Rect)localObject2), ((Rect)localObject2).width() * 0.1F, ((Rect)localObject2).height() * 0.1F, this.uqo);
      }
      AppMethodBeat.o(317491);
    }
    
    public final void setUsername(String paramString)
    {
      AppMethodBeat.i(317487);
      s.u(paramString, "value");
      String str = this.username;
      Log.i(this.djQ, "username#set, oldUsername: " + str + ", newUsername: " + paramString);
      if (!s.p(paramString, str)) {
        agA(paramString);
      }
      this.username = paramString;
      AppMethodBeat.o(317487);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.c
 * JD-Core Version:    0.7.0.1
 */