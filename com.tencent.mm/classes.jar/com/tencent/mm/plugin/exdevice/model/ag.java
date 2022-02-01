package com.tencent.mm.plugin.exdevice.model;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.af;
import com.tencent.mm.an.f;
import com.tencent.mm.autogen.a.wm;
import com.tencent.mm.autogen.a.wp;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.loader.b.h;
import com.tencent.mm.modelimage.loader.c.b;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.List;

public final class ag
{
  private Context context;
  boolean nzW;
  private int width;
  private View ysA;
  boolean ysB;
  Dialog ysC;
  private View ysv;
  private TextView ysw;
  private TextView ysx;
  private TextView ysy;
  private TextView ysz;
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(23448);
    af.bHf();
    Object localObject = f.bGG();
    String str;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (String)((List)localObject).get(0);
      WXImageObject localWXImageObject = new WXImageObject();
      localWXImageObject.setImagePath(paramString2);
      str = aa.getDisplayName((String)localObject);
      WXMediaMessage localWXMediaMessage = new WXMediaMessage();
      localWXMediaMessage.mediaObject = localWXImageObject;
      localWXMediaMessage.title = str;
      localWXMediaMessage.description = paramString4;
      localWXMediaMessage.setThumbImage(BitmapUtil.decodeFile(paramString2, null));
      paramString2 = new wm();
      paramString2.hZZ.hzF = localWXMediaMessage;
      paramString2.hZZ.appId = "wx7fa037cc7dfabad5";
      paramString2.hZZ.appName = paramContext.getString(R.l.exdevice_wechat_sport);
      paramString2.hZZ.toUser = paramString1;
      paramString2.hZZ.hKZ = 2;
      if (!Util.isNullOrNil((String)localObject)) {
        break label253;
      }
      paramString2.hZZ.iac = null;
    }
    for (;;)
    {
      boolean bool = paramString2.publish();
      if (!Util.isNullOrNil(paramString3))
      {
        paramContext = new wp();
        paramContext.iak.hgl = paramString1;
        paramContext.iak.content = paramString3;
        paramContext.iak.type = ab.IX(paramString1);
        paramContext.iak.flags = 0;
        paramContext.publish();
      }
      AppMethodBeat.o(23448);
      return bool;
      localObject = null;
      break;
      label253:
      paramString2.hZZ.iaa = ((String)localObject);
      paramString2.hZZ.iab = str;
    }
  }
  
  public static final String gc(Context paramContext)
  {
    AppMethodBeat.i(23445);
    paramContext = com.tencent.mm.vfs.ah.v(new u(paramContext.getCacheDir(), "sport_share_bitmap.jpg").jKT());
    AppMethodBeat.o(23445);
    return paramContext;
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, final a parama)
  {
    AppMethodBeat.i(23446);
    if (this.ysB)
    {
      AppMethodBeat.o(23446);
      return;
    }
    this.ysB = true;
    this.nzW = false;
    if ((this.ysC == null) && (!Util.isNullOrNil(paramString3)))
    {
      paramContext.getString(R.l.app_tip);
      this.ysC = k.a(paramContext, paramContext.getString(R.l.gGT), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          ag.this.nzW = true;
        }
      });
      this.ysC.show();
    }
    this.context = paramContext;
    this.width = 1280;
    if (this.width > com.tencent.mm.cd.a.ms(paramContext)) {
      this.width = com.tencent.mm.cd.a.ms(paramContext);
    }
    this.ysv = LayoutInflater.from(paramContext).inflate(R.i.gjO, null);
    this.ysw = ((TextView)this.ysv.findViewById(R.h.fHl));
    this.ysx = ((TextView)this.ysv.findViewById(R.h.fHk));
    this.ysy = ((TextView)this.ysv.findViewById(R.h.fHs));
    this.ysz = ((TextView)this.ysv.findViewById(R.h.fHr));
    this.ysA = this.ysv.findViewById(R.h.bg_mask);
    this.ysw.setText(paramString1);
    this.ysy.setText(paramString2);
    a.b.a((ImageView)this.ysv.findViewById(R.h.avatarIV), z.bAM(), 0.5F, false);
    paramContext = (ImageView)this.ysv.findViewById(R.h.ftv);
    paramString1 = new RelativeLayout.LayoutParams(-1, -1);
    this.ysv.setLayoutParams(paramString1);
    this.ysv.measure(View.MeasureSpec.makeMeasureSpec(this.width, 1073741824), View.MeasureSpec.makeMeasureSpec(this.width, 1073741824));
    this.ysv.layout(0, 0, this.width, this.width);
    if (!Util.isNullOrNil(paramString3))
    {
      ah.dFU().a(paramString3, paramContext, new h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
        {
          AppMethodBeat.i(23443);
          if (ag.this.nzW)
          {
            ag.this.ysB = false;
            AppMethodBeat.o(23443);
            return;
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(23442);
              if (ag.this.ysC.isShowing()) {
                ag.this.ysC.dismiss();
              }
              AppMethodBeat.o(23442);
            }
          });
          paramAnonymousString = ag.this.ai(paramAnonymousb.bitmap);
          parama.apw(paramAnonymousString);
          ag.this.ysB = false;
          AppMethodBeat.o(23443);
        }
        
        public final void c(String paramAnonymousString, View paramAnonymousView) {}
      });
      AppMethodBeat.o(23446);
      return;
    }
    paramContext.setImageResource(R.e.darkgrey);
    parama.apw(ai(null));
    this.ysB = false;
    AppMethodBeat.o(23446);
  }
  
  final String ai(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(23447);
    if (paramBitmap != null) {
      paramBitmap = aw.bc(paramBitmap);
    }
    for (;;)
    {
      Object localObject = new ShapeDrawable.ShaderFactory()
      {
        public final Shader resize(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(23444);
          float f = paramAnonymousInt2;
          paramAnonymousInt1 = paramBitmap[0];
          Object localObject = Shader.TileMode.REPEAT;
          localObject = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { 0, paramAnonymousInt1 }, new float[] { 0.0F, 1.0F }, (Shader.TileMode)localObject);
          AppMethodBeat.o(23444);
          return localObject;
        }
      };
      PaintDrawable localPaintDrawable = new PaintDrawable();
      localPaintDrawable.setShape(new RectShape());
      localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
      this.ysA.setBackgroundDrawable(localPaintDrawable);
      this.ysw.setTextColor(paramBitmap[1]);
      this.ysx.setTextColor(paramBitmap[1]);
      this.ysy.setTextColor(paramBitmap[1]);
      this.ysz.setTextColor(paramBitmap[1]);
      paramBitmap = Bitmap.createBitmap(this.width, this.width, Bitmap.Config.ARGB_8888);
      localObject = new Canvas(paramBitmap);
      this.ysv.draw((Canvas)localObject);
      localObject = new u(gc(this.context));
      if (((u)localObject).jKS()) {
        ((u)localObject).diJ();
      }
      try
      {
        BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, com.tencent.mm.vfs.ah.v(((u)localObject).jKT()), true);
        label174:
        paramBitmap = com.tencent.mm.vfs.ah.v(((u)localObject).jKT());
        AppMethodBeat.o(23447);
        return paramBitmap;
        paramBitmap = new int[2];
        Bitmap tmp195_194 = paramBitmap;
        tmp195_194[0] = -1;
        Bitmap tmp199_195 = tmp195_194;
        tmp199_195[1] = -16777216;
        tmp199_195;
      }
      catch (IOException paramBitmap)
      {
        break label174;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void apw(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ag
 * JD-Core Version:    0.7.0.1
 */