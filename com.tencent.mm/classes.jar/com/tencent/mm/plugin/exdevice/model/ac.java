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
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.List;

public final class ac
{
  private Context context;
  boolean ifz;
  private View rAO;
  private TextView rAP;
  private TextView rAQ;
  private TextView rAR;
  private TextView rAS;
  private View rAT;
  boolean rAU;
  Dialog rAV;
  private int width;
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(23448);
    ag.bah();
    Object localObject = f.aZG();
    String str;
    if (((List)localObject).size() > 0)
    {
      localObject = (String)((List)localObject).get(0);
      WXImageObject localWXImageObject = new WXImageObject();
      localWXImageObject.setImagePath(paramString2);
      str = com.tencent.mm.model.aa.getDisplayName((String)localObject);
      WXMediaMessage localWXMediaMessage = new WXMediaMessage();
      localWXMediaMessage.mediaObject = localWXImageObject;
      localWXMediaMessage.title = str;
      localWXMediaMessage.description = paramString4;
      localWXMediaMessage.setThumbImage(BitmapUtil.decodeFile(paramString2, null));
      paramString2 = new tt();
      paramString2.eaf.dCE = localWXMediaMessage;
      paramString2.eaf.appId = "wx7fa037cc7dfabad5";
      paramString2.eaf.appName = paramContext.getString(2131758927);
      paramString2.eaf.toUser = paramString1;
      paramString2.eaf.dMG = 2;
      if (!Util.isNullOrNil((String)localObject)) {
        break label253;
      }
      paramString2.eaf.eai = null;
    }
    for (;;)
    {
      boolean bool = EventCenter.instance.publish(paramString2);
      if (!Util.isNullOrNil(paramString3))
      {
        paramContext = new tw();
        paramContext.eaq.dkV = paramString1;
        paramContext.eaq.content = paramString3;
        paramContext.eaq.type = ab.JG(paramString1);
        paramContext.eaq.flags = 0;
        EventCenter.instance.publish(paramContext);
      }
      AppMethodBeat.o(23448);
      return bool;
      localObject = null;
      break;
      label253:
      paramString2.eaf.eag = ((String)localObject);
      paramString2.eaf.eah = str;
    }
  }
  
  public static final String fb(Context paramContext)
  {
    AppMethodBeat.i(23445);
    paramContext = com.tencent.mm.vfs.aa.z(new o(paramContext.getCacheDir(), "sport_share_bitmap.jpg").her());
    AppMethodBeat.o(23445);
    return paramContext;
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, final a parama)
  {
    AppMethodBeat.i(23446);
    if (this.rAU)
    {
      AppMethodBeat.o(23446);
      return;
    }
    this.rAU = true;
    this.ifz = false;
    if ((this.rAV == null) && (!Util.isNullOrNil(paramString3)))
    {
      paramContext.getString(2131755998);
      this.rAV = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131758907), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          ac.this.ifz = true;
        }
      });
      this.rAV.show();
    }
    this.context = paramContext;
    this.width = 1280;
    if (this.width > com.tencent.mm.cb.a.jn(paramContext)) {
      this.width = com.tencent.mm.cb.a.jn(paramContext);
    }
    this.rAO = LayoutInflater.from(paramContext).inflate(2131494050, null);
    this.rAP = ((TextView)this.rAO.findViewById(2131300217));
    this.rAQ = ((TextView)this.rAO.findViewById(2131300216));
    this.rAR = ((TextView)this.rAO.findViewById(2131300224));
    this.rAS = ((TextView)this.rAO.findViewById(2131300223));
    this.rAT = this.rAO.findViewById(2131297359);
    this.rAP.setText(paramString1);
    this.rAR.setText(paramString2);
    a.b.a((ImageView)this.rAO.findViewById(2131297120), z.aTY(), 0.5F, false);
    paramContext = (ImageView)this.rAO.findViewById(2131297353);
    paramString1 = new RelativeLayout.LayoutParams(-1, -1);
    this.rAO.setLayoutParams(paramString1);
    this.rAO.measure(View.MeasureSpec.makeMeasureSpec(this.width, 1073741824), View.MeasureSpec.makeMeasureSpec(this.width, 1073741824));
    this.rAO.layout(0, 0, this.width, this.width);
    if (!Util.isNullOrNil(paramString3))
    {
      ad.cKO().a(paramString3, paramContext, new com.tencent.mm.av.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView) {}
        
        public final void b(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
        {
          AppMethodBeat.i(23443);
          if (ac.this.ifz)
          {
            ac.this.rAU = false;
            AppMethodBeat.o(23443);
            return;
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(23442);
              if (ac.this.rAV.isShowing()) {
                ac.this.rAV.dismiss();
              }
              AppMethodBeat.o(23442);
            }
          });
          paramAnonymousString = ac.this.aa(paramAnonymousb.bitmap);
          parama.anx(paramAnonymousString);
          ac.this.rAU = false;
          AppMethodBeat.o(23443);
        }
      });
      AppMethodBeat.o(23446);
      return;
    }
    paramContext.setImageResource(2131100237);
    parama.anx(aa(null));
    this.rAU = false;
    AppMethodBeat.o(23446);
  }
  
  final String aa(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(23447);
    if (paramBitmap != null) {
      paramBitmap = ao.aK(paramBitmap);
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
      this.rAT.setBackgroundDrawable(localPaintDrawable);
      this.rAP.setTextColor(paramBitmap[1]);
      this.rAQ.setTextColor(paramBitmap[1]);
      this.rAR.setTextColor(paramBitmap[1]);
      this.rAS.setTextColor(paramBitmap[1]);
      paramBitmap = Bitmap.createBitmap(this.width, this.width, Bitmap.Config.ARGB_8888);
      localObject = new Canvas(paramBitmap);
      this.rAO.draw((Canvas)localObject);
      localObject = new o(fb(this.context));
      if (((o)localObject).exists()) {
        ((o)localObject).delete();
      }
      try
      {
        BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, com.tencent.mm.vfs.aa.z(((o)localObject).her()), true);
        label174:
        paramBitmap = com.tencent.mm.vfs.aa.z(((o)localObject).her());
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
    public abstract void anx(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ac
 * JD-Core Version:    0.7.0.1
 */